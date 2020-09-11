package com.meizu.cloud.pushsdk.networking.common;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.core.Core;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.http.Call;
import com.meizu.cloud.pushsdk.networking.http.FormBody;
import com.meizu.cloud.pushsdk.networking.http.Headers;
import com.meizu.cloud.pushsdk.networking.http.HttpUrl;
import com.meizu.cloud.pushsdk.networking.http.MediaType;
import com.meizu.cloud.pushsdk.networking.http.MultipartBody;
import com.meizu.cloud.pushsdk.networking.http.RequestBody;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.interfaces.AnalyticsListener;
import com.meizu.cloud.pushsdk.networking.interfaces.BitmapRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.DownloadListener;
import com.meizu.cloud.pushsdk.networking.interfaces.DownloadProgressListener;
import com.meizu.cloud.pushsdk.networking.interfaces.JSONArrayRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.JSONObjectRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndBitmapRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndJSONArrayRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndJSONObjectRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndStringRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseListener;
import com.meizu.cloud.pushsdk.networking.interfaces.ParsedRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.StringRequestListener;
import com.meizu.cloud.pushsdk.networking.interfaces.UploadProgressListener;
import com.meizu.cloud.pushsdk.networking.internal.ANRequestQueue;
import com.meizu.cloud.pushsdk.networking.internal.SynchronousCall;
import com.meizu.cloud.pushsdk.networking.okio.Okio;
import com.meizu.cloud.pushsdk.networking.okio.Source;
import com.meizu.cloud.pushsdk.networking.utils.C1259Utils;
import com.meizu.cloud.pushsdk.pushtracer.constant.TrackerConstants;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ANRequest<T extends ANRequest> {
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse(TrackerConstants.POST_CONTENT_TYPE);
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final String TAG = "ANRequest";
    private static final Object sDecodeLock = new Object();
    private Call call;
    private MediaType customMediaType;
    private Future future;
    /* access modifiers changed from: private */
    public boolean isCancelled;
    private boolean isDelivered;
    private AnalyticsListener mAnalyticsListener;
    private BitmapRequestListener mBitmapRequestListener;
    private HashMap<String, String> mBodyParameterMap;
    private byte[] mByte;
    private Bitmap.Config mDecodeConfig;
    private String mDirPath;
    /* access modifiers changed from: private */
    public DownloadListener mDownloadListener;
    /* access modifiers changed from: private */
    public DownloadProgressListener mDownloadProgressListener;
    private Executor mExecutor;
    private File mFile;
    private String mFileName;
    private HashMap<String, String> mHeadersMap;
    private JSONArrayRequestListener mJSONArrayRequestListener;
    private JSONObjectRequestListener mJSONObjectRequestListener;
    private JSONArray mJsonArray;
    private JSONObject mJsonObject;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMethod;
    private HashMap<String, File> mMultiPartFileMap;
    private HashMap<String, String> mMultiPartParameterMap;
    private OkHttpResponseAndBitmapRequestListener mOkHttpResponseAndBitmapRequestListener;
    private OkHttpResponseAndJSONArrayRequestListener mOkHttpResponseAndJSONArrayRequestListener;
    private OkHttpResponseAndJSONObjectRequestListener mOkHttpResponseAndJSONObjectRequestListener;
    private OkHttpResponseAndParsedRequestListener mOkHttpResponseAndParsedRequestListener;
    private OkHttpResponseAndStringRequestListener mOkHttpResponseAndStringRequestListener;
    /* access modifiers changed from: private */
    public OkHttpResponseListener mOkHttpResponseListener;
    private ParsedRequestListener mParsedRequestListener;
    private HashMap<String, String> mPathParameterMap;
    private int mPercentageThresholdForCancelling;
    private Priority mPriority;
    /* access modifiers changed from: private */
    public int mProgress;
    private HashMap<String, String> mQueryParameterMap;
    private int mRequestType;
    private ResponseType mResponseType;
    private ImageView.ScaleType mScaleType;
    private String mStringBody;
    private StringRequestListener mStringRequestListener;
    private Object mTag;
    private Type mType;
    /* access modifiers changed from: private */
    public UploadProgressListener mUploadProgressListener;
    private String mUrl;
    private HashMap<String, String> mUrlEncodedFormBodyParameterMap;
    private String mUserAgent;
    private int sequenceNumber;

    public ANRequest(GetRequestBuilder getRequestBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mJsonObject = null;
        this.mJsonArray = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mExecutor = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 0;
        this.mMethod = getRequestBuilder.mMethod;
        this.mPriority = getRequestBuilder.mPriority;
        this.mUrl = getRequestBuilder.mUrl;
        this.mTag = getRequestBuilder.mTag;
        this.mHeadersMap = getRequestBuilder.mHeadersMap;
        this.mDecodeConfig = getRequestBuilder.mDecodeConfig;
        this.mMaxHeight = getRequestBuilder.mMaxHeight;
        this.mMaxWidth = getRequestBuilder.mMaxWidth;
        this.mScaleType = getRequestBuilder.mScaleType;
        this.mQueryParameterMap = getRequestBuilder.mQueryParameterMap;
        this.mPathParameterMap = getRequestBuilder.mPathParameterMap;
        this.mExecutor = getRequestBuilder.mExecutor;
        this.mUserAgent = getRequestBuilder.mUserAgent;
    }

    public ANRequest(PostRequestBuilder postRequestBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mJsonObject = null;
        this.mJsonArray = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mExecutor = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 0;
        this.mMethod = postRequestBuilder.mMethod;
        this.mPriority = postRequestBuilder.mPriority;
        this.mUrl = postRequestBuilder.mUrl;
        this.mTag = postRequestBuilder.mTag;
        this.mHeadersMap = postRequestBuilder.mHeadersMap;
        this.mBodyParameterMap = postRequestBuilder.mBodyParameterMap;
        this.mUrlEncodedFormBodyParameterMap = postRequestBuilder.mUrlEncodedFormBodyParameterMap;
        this.mQueryParameterMap = postRequestBuilder.mQueryParameterMap;
        this.mPathParameterMap = postRequestBuilder.mPathParameterMap;
        this.mJsonObject = postRequestBuilder.mJsonObject;
        this.mJsonArray = postRequestBuilder.mJsonArray;
        this.mStringBody = postRequestBuilder.mStringBody;
        this.mFile = postRequestBuilder.mFile;
        this.mByte = postRequestBuilder.mByte;
        this.mExecutor = postRequestBuilder.mExecutor;
        this.mUserAgent = postRequestBuilder.mUserAgent;
        if (postRequestBuilder.mCustomContentType != null) {
            this.customMediaType = MediaType.parse(postRequestBuilder.mCustomContentType);
        }
    }

    public ANRequest(DownloadBuilder downloadBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mJsonObject = null;
        this.mJsonArray = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mExecutor = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 1;
        this.mMethod = 0;
        this.mPriority = downloadBuilder.mPriority;
        this.mUrl = downloadBuilder.mUrl;
        this.mTag = downloadBuilder.mTag;
        this.mDirPath = downloadBuilder.mDirPath;
        this.mFileName = downloadBuilder.mFileName;
        this.mHeadersMap = downloadBuilder.mHeadersMap;
        this.mQueryParameterMap = downloadBuilder.mQueryParameterMap;
        this.mPathParameterMap = downloadBuilder.mPathParameterMap;
        this.mPercentageThresholdForCancelling = downloadBuilder.mPercentageThresholdForCancelling;
        this.mExecutor = downloadBuilder.mExecutor;
        this.mUserAgent = downloadBuilder.mUserAgent;
    }

    public ANRequest(MultiPartBuilder multiPartBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mJsonObject = null;
        this.mJsonArray = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mExecutor = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 2;
        this.mMethod = 1;
        this.mPriority = multiPartBuilder.mPriority;
        this.mUrl = multiPartBuilder.mUrl;
        this.mTag = multiPartBuilder.mTag;
        this.mHeadersMap = multiPartBuilder.mHeadersMap;
        this.mQueryParameterMap = multiPartBuilder.mQueryParameterMap;
        this.mPathParameterMap = multiPartBuilder.mPathParameterMap;
        this.mMultiPartParameterMap = multiPartBuilder.mMultiPartParameterMap;
        this.mMultiPartFileMap = multiPartBuilder.mMultiPartFileMap;
        this.mPercentageThresholdForCancelling = multiPartBuilder.mPercentageThresholdForCancelling;
        this.mExecutor = multiPartBuilder.mExecutor;
        this.mUserAgent = multiPartBuilder.mUserAgent;
        if (multiPartBuilder.mCustomContentType != null) {
            this.customMediaType = MediaType.parse(multiPartBuilder.mCustomContentType);
        }
    }

    public void getAsJSONObject(JSONObjectRequestListener jSONObjectRequestListener) {
        this.mResponseType = ResponseType.JSON_OBJECT;
        this.mJSONObjectRequestListener = jSONObjectRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsJSONArray(JSONArrayRequestListener jSONArrayRequestListener) {
        this.mResponseType = ResponseType.JSON_ARRAY;
        this.mJSONArrayRequestListener = jSONArrayRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsString(StringRequestListener stringRequestListener) {
        this.mResponseType = ResponseType.STRING;
        this.mStringRequestListener = stringRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponse(OkHttpResponseListener okHttpResponseListener) {
        this.mResponseType = ResponseType.OK_HTTP_RESPONSE;
        this.mOkHttpResponseListener = okHttpResponseListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsBitmap(BitmapRequestListener bitmapRequestListener) {
        this.mResponseType = ResponseType.BITMAP;
        this.mBitmapRequestListener = bitmapRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndJSONObject(OkHttpResponseAndJSONObjectRequestListener okHttpResponseAndJSONObjectRequestListener) {
        this.mResponseType = ResponseType.JSON_OBJECT;
        this.mOkHttpResponseAndJSONObjectRequestListener = okHttpResponseAndJSONObjectRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndJSONArray(OkHttpResponseAndJSONArrayRequestListener okHttpResponseAndJSONArrayRequestListener) {
        this.mResponseType = ResponseType.JSON_ARRAY;
        this.mOkHttpResponseAndJSONArrayRequestListener = okHttpResponseAndJSONArrayRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndString(OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        this.mResponseType = ResponseType.STRING;
        this.mOkHttpResponseAndStringRequestListener = okHttpResponseAndStringRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndBitmap(OkHttpResponseAndBitmapRequestListener okHttpResponseAndBitmapRequestListener) {
        this.mResponseType = ResponseType.BITMAP;
        this.mOkHttpResponseAndBitmapRequestListener = okHttpResponseAndBitmapRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void startDownload(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void prefetch() {
        this.mResponseType = ResponseType.PREFETCH;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public ANResponse executeForJSONObject() {
        this.mResponseType = ResponseType.JSON_OBJECT;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForJSONArray() {
        this.mResponseType = ResponseType.JSON_ARRAY;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForString() {
        this.mResponseType = ResponseType.STRING;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForOkHttpResponse() {
        this.mResponseType = ResponseType.OK_HTTP_RESPONSE;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForBitmap() {
        this.mResponseType = ResponseType.BITMAP;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForDownload() {
        return SynchronousCall.execute(this);
    }

    public T setDownloadProgressListener(DownloadProgressListener downloadProgressListener) {
        this.mDownloadProgressListener = downloadProgressListener;
        return this;
    }

    public T setUploadProgressListener(UploadProgressListener uploadProgressListener) {
        this.mUploadProgressListener = uploadProgressListener;
        return this;
    }

    public T setAnalyticsListener(AnalyticsListener analyticsListener) {
        this.mAnalyticsListener = analyticsListener;
        return this;
    }

    public AnalyticsListener getAnalyticsListener() {
        return this.mAnalyticsListener;
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Priority getPriority() {
        return this.mPriority;
    }

    public String getUrl() {
        String str = this.mUrl;
        for (Map.Entry next : this.mPathParameterMap.entrySet()) {
            str = str.replace("{" + ((String) next.getKey()) + "}", String.valueOf(next.getValue()));
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse(str).newBuilder();
        for (Map.Entry next2 : this.mQueryParameterMap.entrySet()) {
            newBuilder.addQueryParameter((String) next2.getKey(), (String) next2.getValue());
        }
        return newBuilder.build().toString();
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(int i) {
        this.sequenceNumber = i;
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public void setResponseAs(ResponseType responseType) {
        this.mResponseType = responseType;
    }

    public ResponseType getResponseAs() {
        return this.mResponseType;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public Type getType() {
        return this.mType;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public DownloadProgressListener getDownloadProgressListener() {
        return new DownloadProgressListener() {
            public void onProgress(long j, long j2) {
                if (ANRequest.this.mDownloadProgressListener != null && !ANRequest.this.isCancelled) {
                    ANRequest.this.mDownloadProgressListener.onProgress(j, j2);
                }
            }
        };
    }

    public void updateDownloadCompletion() {
        this.isDelivered = true;
        if (this.mDownloadListener == null) {
            ANLog.m4846d("Prefetch done : " + toString());
            finish();
        } else if (this.isCancelled) {
            deliverError(new ANError());
            finish();
        } else if (this.mExecutor != null) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    if (ANRequest.this.mDownloadListener != null) {
                        ANRequest.this.mDownloadListener.onDownloadComplete();
                    }
                    ANLog.m4846d("Delivering success : " + toString());
                    ANRequest.this.finish();
                }
            });
        } else {
            Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                public void run() {
                    if (ANRequest.this.mDownloadListener != null) {
                        ANRequest.this.mDownloadListener.onDownloadComplete();
                    }
                    ANLog.m4846d("Delivering success : " + toString());
                    ANRequest.this.finish();
                }
            });
        }
    }

    public UploadProgressListener getUploadProgressListener() {
        return new UploadProgressListener() {
            public void onProgress(long j, long j2) {
                int unused = ANRequest.this.mProgress = (int) ((100 * j) / j2);
                if (ANRequest.this.mUploadProgressListener != null && !ANRequest.this.isCancelled) {
                    ANRequest.this.mUploadProgressListener.onProgress(j, j2);
                }
            }
        };
    }

    public String getDirPath() {
        return this.mDirPath;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void cancel(boolean z) {
        if (!z) {
            try {
                if (this.mPercentageThresholdForCancelling != 0) {
                    if (this.mProgress >= this.mPercentageThresholdForCancelling) {
                        ANLog.m4846d("not cancelling request : " + toString());
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ANLog.m4846d("cancelling request : " + toString());
        this.isCancelled = true;
        if (this.call != null) {
            this.call.cancel();
        }
        if (this.future != null) {
            this.future.cancel(true);
        }
        if (!this.isDelivered) {
            deliverError(new ANError());
        }
    }

    public boolean isCanceled() {
        return this.isCancelled;
    }

    public Call getCall() {
        return this.call;
    }

    public void setCall(Call call2) {
        this.call = call2;
    }

    public Future getFuture() {
        return this.future;
    }

    public void setFuture(Future future2) {
        this.future = future2;
    }

    public void destroy() {
        this.mJSONArrayRequestListener = null;
        this.mJSONArrayRequestListener = null;
        this.mStringRequestListener = null;
        this.mBitmapRequestListener = null;
        this.mParsedRequestListener = null;
        this.mDownloadProgressListener = null;
        this.mUploadProgressListener = null;
        this.mDownloadListener = null;
        this.mAnalyticsListener = null;
    }

    public void finish() {
        destroy();
        ANRequestQueue.getInstance().finish(this);
    }

    public ANResponse parseResponse(Response response) {
        ANResponse<Bitmap> decodeBitmap;
        switch (this.mResponseType) {
            case JSON_ARRAY:
                try {
                    return ANResponse.success(new JSONArray(Okio.buffer((Source) response.body().source()).readUtf8()));
                } catch (Exception e) {
                    return ANResponse.failed(C1259Utils.getErrorForParse(new ANError((Throwable) e)));
                }
            case JSON_OBJECT:
                try {
                    return ANResponse.success(new JSONObject(Okio.buffer((Source) response.body().source()).readUtf8()));
                } catch (Exception e2) {
                    return ANResponse.failed(C1259Utils.getErrorForParse(new ANError((Throwable) e2)));
                }
            case STRING:
                try {
                    return ANResponse.success(Okio.buffer((Source) response.body().source()).readUtf8());
                } catch (Exception e3) {
                    return ANResponse.failed(C1259Utils.getErrorForParse(new ANError((Throwable) e3)));
                }
            case BITMAP:
                synchronized (sDecodeLock) {
                    try {
                        decodeBitmap = C1259Utils.decodeBitmap(response, this.mMaxWidth, this.mMaxHeight, this.mDecodeConfig, this.mScaleType);
                    } catch (Exception e4) {
                        return ANResponse.failed(C1259Utils.getErrorForParse(new ANError((Throwable) e4)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return decodeBitmap;
            case PREFETCH:
                return ANResponse.success(ANConstants.PREFETCH);
            default:
                return null;
        }
    }

    public ANError parseNetworkError(ANError aNError) {
        try {
            if (!(aNError.getResponse() == null || aNError.getResponse().body() == null || aNError.getResponse().body().source() == null)) {
                aNError.setErrorBody(Okio.buffer((Source) aNError.getResponse().body().source()).readUtf8());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNError;
    }

    public synchronized void deliverError(ANError aNError) {
        try {
            if (!this.isDelivered) {
                if (this.isCancelled) {
                    aNError.setCancellationMessageInError();
                    aNError.setErrorCode(0);
                }
                deliverErrorResponse(aNError);
                ANLog.m4846d("Delivering anError : " + toString());
            }
            this.isDelivered = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void deliverResponse(final ANResponse aNResponse) {
        try {
            this.isDelivered = true;
            if (!this.isCancelled) {
                if (this.mExecutor != null) {
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            ANRequest.this.deliverSuccessResponse(aNResponse);
                        }
                    });
                } else {
                    Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                        public void run() {
                            ANRequest.this.deliverSuccessResponse(aNResponse);
                        }
                    });
                }
                ANLog.m4846d("Delivering success : " + toString());
                return;
            }
            ANError aNError = new ANError();
            aNError.setCancellationMessageInError();
            aNError.setErrorCode(0);
            deliverErrorResponse(aNError);
            finish();
            ANLog.m4846d("Delivering cancelled : " + toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void deliverSuccessResponse(ANResponse aNResponse) {
        if (this.mJSONObjectRequestListener != null) {
            this.mJSONObjectRequestListener.onResponse((JSONObject) aNResponse.getResult());
        } else if (this.mJSONArrayRequestListener != null) {
            this.mJSONArrayRequestListener.onResponse((JSONArray) aNResponse.getResult());
        } else if (this.mStringRequestListener != null) {
            this.mStringRequestListener.onResponse((String) aNResponse.getResult());
        } else if (this.mBitmapRequestListener != null) {
            this.mBitmapRequestListener.onResponse((Bitmap) aNResponse.getResult());
        } else if (this.mParsedRequestListener != null) {
            this.mParsedRequestListener.onResponse(aNResponse.getResult());
        } else if (this.mOkHttpResponseAndJSONObjectRequestListener != null) {
            this.mOkHttpResponseAndJSONObjectRequestListener.onResponse(aNResponse.getOkHttpResponse(), (JSONObject) aNResponse.getResult());
        } else if (this.mOkHttpResponseAndJSONArrayRequestListener != null) {
            this.mOkHttpResponseAndJSONArrayRequestListener.onResponse(aNResponse.getOkHttpResponse(), (JSONArray) aNResponse.getResult());
        } else if (this.mOkHttpResponseAndStringRequestListener != null) {
            this.mOkHttpResponseAndStringRequestListener.onResponse(aNResponse.getOkHttpResponse(), (String) aNResponse.getResult());
        } else if (this.mOkHttpResponseAndBitmapRequestListener != null) {
            this.mOkHttpResponseAndBitmapRequestListener.onResponse(aNResponse.getOkHttpResponse(), (Bitmap) aNResponse.getResult());
        } else if (this.mOkHttpResponseAndParsedRequestListener != null) {
            this.mOkHttpResponseAndParsedRequestListener.onResponse(aNResponse.getOkHttpResponse(), aNResponse.getResult());
        }
        finish();
    }

    private void deliverErrorResponse(ANError aNError) {
        if (this.mJSONObjectRequestListener != null) {
            this.mJSONObjectRequestListener.onError(aNError);
        } else if (this.mJSONArrayRequestListener != null) {
            this.mJSONArrayRequestListener.onError(aNError);
        } else if (this.mStringRequestListener != null) {
            this.mStringRequestListener.onError(aNError);
        } else if (this.mBitmapRequestListener != null) {
            this.mBitmapRequestListener.onError(aNError);
        } else if (this.mParsedRequestListener != null) {
            this.mParsedRequestListener.onError(aNError);
        } else if (this.mOkHttpResponseAndJSONObjectRequestListener != null) {
            this.mOkHttpResponseAndJSONObjectRequestListener.onError(aNError);
        } else if (this.mOkHttpResponseAndJSONArrayRequestListener != null) {
            this.mOkHttpResponseAndJSONArrayRequestListener.onError(aNError);
        } else if (this.mOkHttpResponseAndStringRequestListener != null) {
            this.mOkHttpResponseAndStringRequestListener.onError(aNError);
        } else if (this.mOkHttpResponseAndBitmapRequestListener != null) {
            this.mOkHttpResponseAndBitmapRequestListener.onError(aNError);
        } else if (this.mOkHttpResponseAndParsedRequestListener != null) {
            this.mOkHttpResponseAndParsedRequestListener.onError(aNError);
        } else if (this.mDownloadListener != null) {
            this.mDownloadListener.onError(aNError);
        }
    }

    public void deliverOkHttpResponse(final Response response) {
        try {
            this.isDelivered = true;
            if (!this.isCancelled) {
                if (this.mExecutor != null) {
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            if (ANRequest.this.mOkHttpResponseListener != null) {
                                ANRequest.this.mOkHttpResponseListener.onResponse(response);
                            }
                            ANRequest.this.finish();
                        }
                    });
                } else {
                    Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                        public void run() {
                            if (ANRequest.this.mOkHttpResponseListener != null) {
                                ANRequest.this.mOkHttpResponseListener.onResponse(response);
                            }
                            ANRequest.this.finish();
                        }
                    });
                }
                ANLog.m4846d("Delivering success : " + toString());
                return;
            }
            ANError aNError = new ANError();
            aNError.setCancellationMessageInError();
            aNError.setErrorCode(0);
            if (this.mOkHttpResponseListener != null) {
                this.mOkHttpResponseListener.onError(aNError);
            }
            finish();
            ANLog.m4846d("Delivering cancelled : " + toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RequestBody getRequestBody() {
        if (this.mJsonObject != null) {
            if (this.customMediaType != null) {
                return RequestBody.create(this.customMediaType, this.mJsonObject.toString());
            }
            return RequestBody.create(JSON_MEDIA_TYPE, this.mJsonObject.toString());
        } else if (this.mJsonArray != null) {
            if (this.customMediaType != null) {
                return RequestBody.create(this.customMediaType, this.mJsonArray.toString());
            }
            return RequestBody.create(JSON_MEDIA_TYPE, this.mJsonArray.toString());
        } else if (this.mStringBody != null) {
            if (this.customMediaType != null) {
                return RequestBody.create(this.customMediaType, this.mStringBody);
            }
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, this.mStringBody);
        } else if (this.mFile != null) {
            if (this.customMediaType != null) {
                return RequestBody.create(this.customMediaType, this.mFile);
            }
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, this.mFile);
        } else if (this.mByte == null) {
            FormBody.Builder builder = new FormBody.Builder();
            try {
                for (Map.Entry next : this.mBodyParameterMap.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) next.getValue())) {
                        builder.add((String) next.getKey(), (String) next.getValue());
                    }
                }
                for (Map.Entry next2 : this.mUrlEncodedFormBodyParameterMap.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && !TextUtils.isEmpty((CharSequence) next2.getValue())) {
                        builder.addEncoded((String) next2.getKey(), (String) next2.getValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return builder.build();
        } else if (this.customMediaType != null) {
            return RequestBody.create(this.customMediaType, this.mByte);
        } else {
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, this.mByte);
        }
    }

    public RequestBody getMultiPartRequestBody() {
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            for (Map.Entry next : this.mMultiPartParameterMap.entrySet()) {
                type.addPart(Headers.m4851of("Content-Disposition", "form-data; name=\"" + ((String) next.getKey()) + "\""), RequestBody.create((MediaType) null, (String) next.getValue()));
            }
            for (Map.Entry next2 : this.mMultiPartFileMap.entrySet()) {
                if (next2.getValue() != null) {
                    String name = ((File) next2.getValue()).getName();
                    RequestBody create = RequestBody.create(MediaType.parse(C1259Utils.getMimeType(name)), (File) next2.getValue());
                    type.addPart(Headers.m4851of("Content-Disposition", "form-data; name=\"" + ((String) next2.getKey()) + "\"; filename=\"" + name + "\""), create);
                    if (this.customMediaType != null) {
                        type.setType(this.customMediaType);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type.build();
    }

    public Headers getHeaders() {
        Headers.Builder builder = new Headers.Builder();
        try {
            for (Map.Entry next : this.mHeadersMap.entrySet()) {
                builder.add((String) next.getKey(), (String) next.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public static class HeadRequestBuilder extends GetRequestBuilder {
        public HeadRequestBuilder(String str) {
            super(str, 4);
        }
    }

    public static class GetRequestBuilder<T extends GetRequestBuilder> implements RequestBuilder {
        /* access modifiers changed from: private */
        public Bitmap.Config mDecodeConfig;
        /* access modifiers changed from: private */
        public Executor mExecutor;
        /* access modifiers changed from: private */
        public HashMap<String, String> mHeadersMap = new HashMap<>();
        /* access modifiers changed from: private */
        public int mMaxHeight;
        /* access modifiers changed from: private */
        public int mMaxWidth;
        /* access modifiers changed from: private */
        public int mMethod = 0;
        /* access modifiers changed from: private */
        public HashMap<String, String> mPathParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public Priority mPriority = Priority.MEDIUM;
        /* access modifiers changed from: private */
        public HashMap<String, String> mQueryParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public ImageView.ScaleType mScaleType;
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public String mUrl;
        /* access modifiers changed from: private */
        public String mUserAgent;

        public T doNotCacheResponse() {
            return this;
        }

        public T getResponseOnlyFromNetwork() {
            return this;
        }

        public T getResponseOnlyIfCached() {
            return this;
        }

        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public GetRequestBuilder(String str) {
            this.mUrl = str;
            this.mMethod = 0;
        }

        public GetRequestBuilder(String str, int i) {
            this.mUrl = str;
            this.mMethod = i;
        }

        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public T addQueryParameter(String str, String str2) {
            this.mQueryParameterMap.put(str, str2);
            return this;
        }

        public T addQueryParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mQueryParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        public T addHeaders(String str, String str2) {
            this.mHeadersMap.put(str, str2);
            return this;
        }

        public T addHeaders(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mHeadersMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public T setBitmapConfig(Bitmap.Config config) {
            this.mDecodeConfig = config;
            return this;
        }

        public T setBitmapMaxHeight(int i) {
            this.mMaxHeight = i;
            return this;
        }

        public T setBitmapMaxWidth(int i) {
            this.mMaxWidth = i;
            return this;
        }

        public T setImageScaleType(ImageView.ScaleType scaleType) {
            this.mScaleType = scaleType;
            return this;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }
    }

    public static class PutRequestBuilder extends PostRequestBuilder {
        public PutRequestBuilder(String str) {
            super(str, 2);
        }
    }

    public static class DeleteRequestBuilder extends PostRequestBuilder {
        public DeleteRequestBuilder(String str) {
            super(str, 3);
        }
    }

    public static class PatchRequestBuilder extends PostRequestBuilder {
        public PatchRequestBuilder(String str) {
            super(str, 5);
        }
    }

    public static class PostRequestBuilder<T extends PostRequestBuilder> implements RequestBuilder {
        /* access modifiers changed from: private */
        public HashMap<String, String> mBodyParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public byte[] mByte = null;
        /* access modifiers changed from: private */
        public String mCustomContentType;
        /* access modifiers changed from: private */
        public Executor mExecutor;
        /* access modifiers changed from: private */
        public File mFile = null;
        /* access modifiers changed from: private */
        public HashMap<String, String> mHeadersMap = new HashMap<>();
        /* access modifiers changed from: private */
        public JSONArray mJsonArray = null;
        /* access modifiers changed from: private */
        public JSONObject mJsonObject = null;
        /* access modifiers changed from: private */
        public int mMethod = 1;
        /* access modifiers changed from: private */
        public HashMap<String, String> mPathParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public Priority mPriority = Priority.MEDIUM;
        /* access modifiers changed from: private */
        public HashMap<String, String> mQueryParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public String mStringBody = null;
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public String mUrl;
        /* access modifiers changed from: private */
        public HashMap<String, String> mUrlEncodedFormBodyParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public String mUserAgent;

        public T doNotCacheResponse() {
            return this;
        }

        public T getResponseOnlyFromNetwork() {
            return this;
        }

        public T getResponseOnlyIfCached() {
            return this;
        }

        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public PostRequestBuilder(String str) {
            this.mUrl = str;
            this.mMethod = 1;
        }

        public PostRequestBuilder(String str, int i) {
            this.mUrl = str;
            this.mMethod = i;
        }

        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public T addQueryParameter(String str, String str2) {
            this.mQueryParameterMap.put(str, str2);
            return this;
        }

        public T addQueryParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mQueryParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        public T addHeaders(String str, String str2) {
            this.mHeadersMap.put(str, str2);
            return this;
        }

        public T addHeaders(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mHeadersMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public T addBodyParameter(String str, String str2) {
            this.mBodyParameterMap.put(str, str2);
            return this;
        }

        public T addUrlEncodeFormBodyParameter(String str, String str2) {
            this.mUrlEncodedFormBodyParameterMap.put(str, str2);
            return this;
        }

        public T addBodyParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mBodyParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addUrlEncodeFormBodyParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mUrlEncodedFormBodyParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addJSONObjectBody(JSONObject jSONObject) {
            this.mJsonObject = jSONObject;
            return this;
        }

        public T addJSONArrayBody(JSONArray jSONArray) {
            this.mJsonArray = jSONArray;
            return this;
        }

        public T addStringBody(String str) {
            this.mStringBody = str;
            return this;
        }

        public T addFileBody(File file) {
            this.mFile = file;
            return this;
        }

        public T addByteBody(byte[] bArr) {
            this.mByte = bArr;
            return this;
        }

        public T setContentType(String str) {
            this.mCustomContentType = str;
            return this;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }
    }

    public static class DownloadBuilder<T extends DownloadBuilder> implements RequestBuilder {
        /* access modifiers changed from: private */
        public String mDirPath;
        /* access modifiers changed from: private */
        public Executor mExecutor;
        /* access modifiers changed from: private */
        public String mFileName;
        /* access modifiers changed from: private */
        public HashMap<String, String> mHeadersMap = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> mPathParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public int mPercentageThresholdForCancelling = 0;
        /* access modifiers changed from: private */
        public Priority mPriority = Priority.MEDIUM;
        /* access modifiers changed from: private */
        public HashMap<String, String> mQueryParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public String mUrl;
        /* access modifiers changed from: private */
        public String mUserAgent;

        public T doNotCacheResponse() {
            return this;
        }

        public T getResponseOnlyFromNetwork() {
            return this;
        }

        public T getResponseOnlyIfCached() {
            return this;
        }

        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public DownloadBuilder(String str, String str2, String str3) {
            this.mUrl = str;
            this.mDirPath = str2;
            this.mFileName = str3;
        }

        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public T addHeaders(String str, String str2) {
            this.mHeadersMap.put(str, str2);
            return this;
        }

        public T addHeaders(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mHeadersMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addQueryParameter(String str, String str2) {
            this.mQueryParameterMap.put(str, str2);
            return this;
        }

        public T addQueryParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mQueryParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public T setPercentageThresholdForCancelling(int i) {
            this.mPercentageThresholdForCancelling = i;
            return this;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }
    }

    public static class MultiPartBuilder<T extends MultiPartBuilder> implements RequestBuilder {
        /* access modifiers changed from: private */
        public String mCustomContentType;
        /* access modifiers changed from: private */
        public Executor mExecutor;
        /* access modifiers changed from: private */
        public HashMap<String, String> mHeadersMap = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, File> mMultiPartFileMap = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> mMultiPartParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> mPathParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public int mPercentageThresholdForCancelling = 0;
        /* access modifiers changed from: private */
        public Priority mPriority = Priority.MEDIUM;
        /* access modifiers changed from: private */
        public HashMap<String, String> mQueryParameterMap = new HashMap<>();
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public String mUrl;
        /* access modifiers changed from: private */
        public String mUserAgent;

        public T doNotCacheResponse() {
            return this;
        }

        public T getResponseOnlyFromNetwork() {
            return this;
        }

        public T getResponseOnlyIfCached() {
            return this;
        }

        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            return this;
        }

        public MultiPartBuilder(String str) {
            this.mUrl = str;
        }

        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public T addQueryParameter(String str, String str2) {
            this.mQueryParameterMap.put(str, str2);
            return this;
        }

        public T addQueryParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mQueryParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        public T addHeaders(String str, String str2) {
            this.mHeadersMap.put(str, str2);
            return this;
        }

        public T addHeaders(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mHeadersMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public T addMultipartParameter(String str, String str2) {
            this.mMultiPartParameterMap.put(str, str2);
            return this;
        }

        public T addMultipartParameter(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mMultiPartParameterMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T addMultipartFile(String str, File file) {
            this.mMultiPartFileMap.put(str, file);
            return this;
        }

        public T addMultipartFile(HashMap<String, File> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.mMultiPartFileMap.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public T setPercentageThresholdForCancelling(int i) {
            this.mPercentageThresholdForCancelling = i;
            return this;
        }

        public T setContentType(String str) {
            this.mCustomContentType = str;
            return this;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.sequenceNumber + ", mMethod=" + this.mMethod + ", mPriority=" + this.mPriority + ", mRequestType=" + this.mRequestType + ", mUrl=" + this.mUrl + '}';
    }
}
