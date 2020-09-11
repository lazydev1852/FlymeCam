package com.meizu.media.cameraAlgorithm.yuv;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;
import java.nio.ByteBuffer;

public class YuvUtil {
    public static ChangeQuickRedirect changeQuickRedirect;

    static {
        System.loadLibrary("yuvutil");
    }

    public static native byte[] changeABGRToI420(Bitmap bitmap);

    public static native byte[] changeARGBToNV21(Bitmap bitmap);

    public static native void changeARGBToNV21withdata(byte[] bArr, int i, int i2, byte[] bArr2);

    public static native void convertNv21toYU12(byte[] bArr, int i, int i2, int i3);

    public static native void convertNv21toYv12(byte[] bArr, int i, int i2, int i3);

    public static native void convertNv21torealyuv(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native void convertToArgb(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public static native void convertYuvToNv21(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native byte[] nativeDecodeNv21(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int nativeDecodeYuv(byte[] bArr, int i, byte[] bArr2, int i2, int i3);

    public static native void rotateNV21Buffer(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, boolean z, int i5);

    public static native byte[] rotateNV21Data(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native void scaleNV21Data(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);
}
