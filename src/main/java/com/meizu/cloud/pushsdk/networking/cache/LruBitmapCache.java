package com.meizu.cloud.pushsdk.networking.cache;

import android.graphics.Bitmap;
import com.meizu.cloud.pushsdk.networking.internal.ANImageLoader;

public class LruBitmapCache extends LruCache<String, Bitmap> implements ANImageLoader.ImageCache {
    public LruBitmapCache(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public void evictBitmap(String str) {
        remove(str);
    }

    public void evictAllBitmap() {
        evictAll();
    }

    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }
}
