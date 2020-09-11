package com.baidu.p020ar.imgseg;

/* renamed from: com.baidu.ar.imgseg.ImgSegJniClient */
public class ImgSegJniClient {
    public static native int imgPreProcess(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5, int i6, float[] fArr3);

    public static native int imgSegPostProcess(byte[] bArr, float[] fArr, int i, int i2, int i3, int i4, float f, float f2, byte[] bArr2);

    public static native int release();
}
