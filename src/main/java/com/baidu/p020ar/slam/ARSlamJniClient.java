package com.baidu.p020ar.slam;

import java.util.ArrayList;

/* renamed from: com.baidu.ar.slam.ARSlamJniClient */
public class ARSlamJniClient {
    public static native int calModelPosition(float f, float[] fArr, float[] fArr2);

    public static native synchronized ArrayList<TrackModel> fetchModelPose();

    public static native synchronized int insertModel(String str, int i, int i2, float[] fArr, float f);

    public static native synchronized int removeAllModel();

    public static native synchronized int removeModel(String str);

    public static native int slamPlaneQuality(byte[] bArr, int i, int i2);

    public static native synchronized void slamReset();

    public static native synchronized boolean slamStart(int i, int i2, float[] fArr, float[] fArr2);

    public static native synchronized void slamStop();

    public static native synchronized TrackParams slamTrack(byte[] bArr, float[] fArr);
}
