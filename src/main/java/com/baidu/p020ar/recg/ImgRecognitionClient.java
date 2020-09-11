package com.baidu.p020ar.recg;

/* renamed from: com.baidu.ar.recg.ImgRecognitionClient */
public class ImgRecognitionClient {
    public static native CornerPoint[] extractCornerPoints(byte[] bArr, int i, int i2);

    public static native byte[] extractFeature(byte[] bArr, int i, int i2);

    public static native boolean init(String[] strArr);

    public static native RecognitionResult recogniseImage(byte[] bArr, int i, int i2);

    public static native boolean release();
}
