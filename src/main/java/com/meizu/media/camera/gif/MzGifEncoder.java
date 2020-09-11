package com.meizu.media.camera.gif;

import android.graphics.Bitmap;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.OutputStream;

public final class MzGifEncoder {
    private static final LogUtil.C2630a TAG = new LogUtil.C2630a("MzGifEncoder");
    private static final int WORKING_COMPRESS_STORAGE = 4096;
    public static ChangeQuickRedirect changeQuickRedirect;
    private int fEncodeCount;
    private int fHeight;
    private OutputStream fStream = null;
    private int fWidth;
    private final int mNativeAGifEncoder;

    private native boolean nativeCloseGif(OutputStream outputStream, byte[] bArr);

    private native boolean nativeCloseStream(int i, OutputStream outputStream, byte[] bArr);

    private static native MzGifEncoder nativeCreateAGifEncoder(int i, int i2);

    private static native MzGifEncoder nativeCreateEncoder(int i, int i2, OutputStream outputStream, byte[] bArr);

    private static native void nativeDestructor(int i);

    private native int nativeDuration(int i);

    private static native boolean nativeEncodeBitmap(int i, int[] iArr, OutputStream outputStream, byte[] bArr);

    private native int nativeEncodeFrameCount();

    private native int nativeHeight(int i);

    private native boolean nativeSetDuration(int i, int i2);

    private static native boolean nativeSetOutputStream(int i, OutputStream outputStream, byte[] bArr);

    private native int nativeWidth(int i);

    static {
        System.loadLibrary("mzGifEncoder_jni");
    }

    private MzGifEncoder(int i, int i2, int i3) {
        if (i != 0) {
            this.mNativeAGifEncoder = i;
            this.fWidth = i2;
            this.fHeight = i3;
            this.fEncodeCount = 0;
            return;
        }
        throw new IllegalArgumentException("native gif encoder creation failed");
    }

    public boolean setDuration(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 4180, new Class[]{Integer.TYPE}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : nativeSetDuration(this.mNativeAGifEncoder, i);
    }

    public int width() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 4181, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : nativeWidth(this.mNativeAGifEncoder);
    }

    public int height() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 4182, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : nativeHeight(this.mNativeAGifEncoder);
    }

    public int duration() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 4183, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : nativeDuration(this.mNativeAGifEncoder);
    }

    private boolean setOutputStream(OutputStream outputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{outputStream}, this, changeQuickRedirect, false, 4184, new Class[]{OutputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (outputStream != null) {
            this.fStream = outputStream;
            return nativeSetOutputStream(this.mNativeAGifEncoder, this.fStream, new byte[4096]);
        }
        throw new IllegalArgumentException();
    }

    public static MzGifEncoder create(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 4185, new Class[]{Integer.TYPE, Integer.TYPE}, MzGifEncoder.class);
        if (proxy.isSupported) {
            return (MzGifEncoder) proxy.result;
        }
        if (i != 0 && i2 != 0) {
            return nativeCreateAGifEncoder(i, i2);
        }
        throw new IllegalArgumentException();
    }

    private static MzGifEncoder encodeAGifStream(int i, int i2, OutputStream outputStream) {
        Object[] objArr = {new Integer(i), new Integer(i2), outputStream};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 4186, new Class[]{Integer.TYPE, Integer.TYPE, OutputStream.class}, MzGifEncoder.class);
        if (proxy.isSupported) {
            return (MzGifEncoder) proxy.result;
        }
        if (outputStream != null && i != 0 && i2 != 0) {
            return nativeCreateEncoder(i, i2, outputStream, new byte[4096]);
        }
        throw new IllegalArgumentException();
    }

    public boolean encodeBitmap(Bitmap bitmap, OutputStream outputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, outputStream}, this, changeQuickRedirect, false, 4187, new Class[]{Bitmap.class, OutputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (bitmap == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (outputStream == null) {
            LogUtil.m15949b(TAG, "output stream is null!!");
            return false;
        } else if (width == 0 || height == 0 || width != this.fWidth || height != this.fHeight) {
            LogUtil.m15949b(TAG, "width = " + width + ", height = " + height + ", fWidth = " + this.fWidth + ", fHeight = " + this.fHeight);
            return false;
        } else {
            if (this.fEncodeCount == 0) {
                this.fStream = outputStream;
            } else if (this.fStream != outputStream) {
                throw new IllegalArgumentException("output stream doesn't match with the creation!!");
            }
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            boolean nativeEncodeBitmap = nativeEncodeBitmap(this.mNativeAGifEncoder, iArr, outputStream, new byte[4096]);
            if (nativeEncodeBitmap) {
                this.fEncodeCount++;
            }
            return nativeEncodeBitmap;
        }
    }

    public int encodeFrameCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 4188, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : nativeEncodeFrameCount();
    }

    public boolean close(OutputStream outputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{outputStream}, this, changeQuickRedirect, false, 4189, new Class[]{OutputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.fStream != null && this.fStream == outputStream) {
            return nativeCloseStream(this.mNativeAGifEncoder, this.fStream, new byte[4096]);
        }
        throw new IllegalArgumentException();
    }
}
