package com.meizu.media.cameraAlgorithm.fbmodecomponent;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;

public class AlorgrithmUtil {
    public static ChangeQuickRedirect changeQuickRedirect;

    public static native byte[] changeABGRToI420(Bitmap bitmap);

    public static native byte[] changeARGBToNV21(Bitmap bitmap);

    public static native byte[] changeARGBToNV21withdata(byte[] bArr, int i, int i2);

    public static native void cleanFeatureValue();

    public static native void convertToArgb(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public static native byte[] nativeDecodeNv21(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int nativeDecodeYuv(byte[] bArr, int i, byte[] bArr2, int i2, int i3);

    public static native byte[] processI420Data(byte[] bArr, int i, int i2, int i3);

    public static native int processNV21Data(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native void setFeatureValue(int i, int i2);

    public static native void setSmartLevel(int i);
}
