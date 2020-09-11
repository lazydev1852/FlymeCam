package com.meizu.media.camera.agegender;

import android.util.Log;
import com.meizu.media.cameraAlgorithm.agegender.AgeGenderInfo;
import java.util.ArrayList;
import java.util.List;

public class AgeGenderUtils {
    public static native String getVersion();

    public static native long init();

    public static native int previewEstimation(long j, byte[] bArr, int i, int i2, int i3, int i4);

    public static native void setFace(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void uninit(long j);

    public static native ArrayList<AgeGenderInfo> updateGenderInfos(long j, List<AgeGenderInfo> list);

    static {
        try {
            Log.i("AgeGenderUtils", "loadLibrary agegendersdk");
            System.loadLibrary("agegendersdk");
        } catch (UnsatisfiedLinkError e) {
            Log.e("AgeGenderUtils", "loadLibrary agegendersdk error");
            e.printStackTrace();
        }
    }
}
