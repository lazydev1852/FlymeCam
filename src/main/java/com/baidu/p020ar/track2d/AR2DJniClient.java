package com.baidu.p020ar.track2d;

/* renamed from: com.baidu.ar.track2d.AR2DJniClient */
public class AR2DJniClient {
    public static native boolean arGetMarkerSize(int[] iArr);

    public static native float arGetRelativeDistance(float[] fArr);

    public static native int arInit(int i, int i2, float[] fArr, String str);

    public static native int arRelease();

    public static native int arTracking(byte[] bArr, float[] fArr);

    public static native int getVersion();
}
