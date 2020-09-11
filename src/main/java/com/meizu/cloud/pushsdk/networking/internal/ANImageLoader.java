package com.meizu.cloud.pushsdk.networking.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.networking.AndroidNetworking;
import com.meizu.cloud.pushsdk.networking.cache.LruBitmapCache;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.interfaces.BitmapRequestListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ANImageLoader {
    private static final int cacheSize = (maxMemory / 8);
    private static final int maxMemory = ((int) (Runtime.getRuntime().maxMemory() / 1024));
    private static ANImageLoader sInstance;
    private int mBatchResponseDelayMs = 100;
    /* access modifiers changed from: private */
    public final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap<>();
    private final ImageCache mCache;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap<>();
    /* access modifiers changed from: private */
    public Runnable mRunnable;

    public interface ImageCache {
        void evictAllBitmap();

        void evictBitmap(String str);

        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public interface ImageListener {
        void onError(ANError aNError);

        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public static void initialize() {
        getInstance();
    }

    public static ANImageLoader getInstance() {
        if (sInstance == null) {
            synchronized (ANImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new ANImageLoader(new LruBitmapCache(cacheSize));
                }
            }
        }
        return sInstance;
    }

    public ANImageLoader(ImageCache imageCache) {
        this.mCache = imageCache;
    }

    public ImageCache getImageCache() {
        return this.mCache;
    }

    public static ImageListener getImageListener(final ImageView imageView, final int i, final int i2) {
        return new ImageListener() {
            public void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                } else if (i != 0) {
                    imageView.setImageResource(i);
                }
            }

            public void onError(ANError aNError) {
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }
        };
    }

    public boolean isCached(String str, int i, int i2) {
        return isCached(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String str, int i, int i2, ImageView.ScaleType scaleType) {
        throwIfNotOnMainThread();
        return this.mCache.getBitmap(getCacheKey(str, i, i2, scaleType)) != null;
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        return get(str, imageListener, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2, ImageView.ScaleType scaleType) {
        ImageListener imageListener2 = imageListener;
        throwIfNotOnMainThread();
        String cacheKey = getCacheKey(str, i, i2, scaleType);
        Bitmap bitmap = this.mCache.getBitmap(cacheKey);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, (String) null, (ImageListener) null);
            imageListener2.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer((Bitmap) null, str, cacheKey, imageListener);
        imageListener2.onResponse(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = this.mInFlightRequests.get(cacheKey);
        if (batchedImageRequest != null) {
            batchedImageRequest.addContainer(imageContainer2);
            return imageContainer2;
        }
        this.mInFlightRequests.put(cacheKey, new BatchedImageRequest(makeImageRequest(str, i, i2, scaleType, cacheKey), imageContainer2));
        return imageContainer2;
    }

    /* access modifiers changed from: protected */
    public ANRequest makeImageRequest(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        ANRequest build = AndroidNetworking.get(str).setTag((Object) "ImageRequestTag").setBitmapMaxHeight(i2).setBitmapMaxWidth(i).setImageScaleType(scaleType).setBitmapConfig(Bitmap.Config.RGB_565).build();
        build.getAsBitmap(new BitmapRequestListener() {
            public void onResponse(Bitmap bitmap) {
                ANImageLoader.this.onGetImageSuccess(str2, bitmap);
            }

            public void onError(ANError aNError) {
                ANImageLoader.this.onGetImageError(str2, aNError);
            }
        });
        return build;
    }

    public void setBatchedResponseDelay(int i) {
        this.mBatchResponseDelayMs = i;
    }

    /* access modifiers changed from: protected */
    public void onGetImageSuccess(String str, Bitmap bitmap) {
        this.mCache.putBitmap(str, bitmap);
        BatchedImageRequest remove = this.mInFlightRequests.remove(str);
        if (remove != null) {
            Bitmap unused = remove.mResponseBitmap = bitmap;
            batchResponse(str, remove);
        }
    }

    /* access modifiers changed from: protected */
    public void onGetImageError(String str, ANError aNError) {
        BatchedImageRequest remove = this.mInFlightRequests.remove(str);
        if (remove != null) {
            remove.setError(aNError);
            batchResponse(str, remove);
        }
    }

    public class ImageContainer {
        /* access modifiers changed from: private */
        public Bitmap mBitmap;
        private final String mCacheKey;
        /* access modifiers changed from: private */
        public final ImageListener mListener;
        private final String mRequestUrl;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.mBitmap = bitmap;
            this.mRequestUrl = str;
            this.mCacheKey = str2;
            this.mListener = imageListener;
        }

        public void cancelRequest() {
            if (this.mListener != null) {
                BatchedImageRequest batchedImageRequest = (BatchedImageRequest) ANImageLoader.this.mInFlightRequests.get(this.mCacheKey);
                if (batchedImageRequest == null) {
                    BatchedImageRequest batchedImageRequest2 = (BatchedImageRequest) ANImageLoader.this.mBatchedResponses.get(this.mCacheKey);
                    if (batchedImageRequest2 != null) {
                        batchedImageRequest2.removeContainerAndCancelIfNecessary(this);
                        if (batchedImageRequest2.mContainers.size() == 0) {
                            ANImageLoader.this.mBatchedResponses.remove(this.mCacheKey);
                        }
                    }
                } else if (batchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
                    ANImageLoader.this.mInFlightRequests.remove(this.mCacheKey);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    private class BatchedImageRequest {
        private ANError mANError;
        /* access modifiers changed from: private */
        public final LinkedList<ImageContainer> mContainers = new LinkedList<>();
        private final ANRequest mRequest;
        /* access modifiers changed from: private */
        public Bitmap mResponseBitmap;

        public BatchedImageRequest(ANRequest aNRequest, ImageContainer imageContainer) {
            this.mRequest = aNRequest;
            this.mContainers.add(imageContainer);
        }

        public void setError(ANError aNError) {
            this.mANError = aNError;
        }

        public ANError getError() {
            return this.mANError;
        }

        public void addContainer(ImageContainer imageContainer) {
            this.mContainers.add(imageContainer);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.mContainers.remove(imageContainer);
            if (this.mContainers.size() != 0) {
                return false;
            }
            this.mRequest.cancel(true);
            if (this.mRequest.isCanceled()) {
                this.mRequest.destroy();
                ANRequestQueue.getInstance().finish(this.mRequest);
            }
            return true;
        }
    }

    private void batchResponse(String str, BatchedImageRequest batchedImageRequest) {
        this.mBatchedResponses.put(str, batchedImageRequest);
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable() {
                public void run() {
                    for (BatchedImageRequest batchedImageRequest : ANImageLoader.this.mBatchedResponses.values()) {
                        Iterator it = batchedImageRequest.mContainers.iterator();
                        while (it.hasNext()) {
                            ImageContainer imageContainer = (ImageContainer) it.next();
                            if (imageContainer.mListener != null) {
                                if (batchedImageRequest.getError() == null) {
                                    Bitmap unused = imageContainer.mBitmap = batchedImageRequest.mResponseBitmap;
                                    imageContainer.mListener.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.mListener.onError(batchedImageRequest.getError());
                                }
                            }
                        }
                    }
                    ANImageLoader.this.mBatchedResponses.clear();
                    Runnable unused2 = ANImageLoader.this.mRunnable = null;
                }
            };
            this.mHandler.postDelayed(this.mRunnable, (long) this.mBatchResponseDelayMs);
        }
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String getCacheKey(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
