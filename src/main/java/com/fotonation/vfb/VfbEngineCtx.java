package com.fotonation.vfb;

import com.meizu.camera.effectlib.p056a.p057a.Face;

public class VfbEngineCtx {
    private static final int EYE_CIRCLES_REMOVAL_STRENGTH_BIT = 16;
    private static final int EYE_ENLARGEMENT_STRENGTH_BIT = 8;
    private static final int SLIMMING_STRENGTH_BIT = 4;
    private static final int SMOOTHING_STRENGTH_BIT = 1;
    private static final int TONING_STRENGTH_BIT = 2;
    private static boolean mIsLoadLib = false;
    private long mCtx;

    private final native int NtvCreate(int i, int i2, int i3, int i4);

    private final native void NtvDestroy();

    private static final native String NtvGetEmbeddedProgramsGpu();

    private final native int NtvGetFaceByIndex(long j, int i, Face aVar);

    private final native int NtvGetFacesCnt(long j);

    private static final native String NtvGetVfbCpuVersion();

    private static final native String NtvGetVfbEngineVersion();

    private static final native String NtvGetVfbGpuVersion();

    private final native int NtvProcess(long j, float[] fArr, int i);

    private final native int NtvSetPreviewSize(long j, int i, int i2);

    private final native void NtvSetShowFaceRectangles(long j, boolean z, boolean z2);

    private final native void NtvSetStrengths(long j, int i, int i2, int i3, int i4, int i5, int i6);

    private final native int NtvSetViewSize(long j, int i, int i2);

    public static void initVFBConfig(String[] strArr) {
        if (!mIsLoadLib) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    System.loadLibrary(strArr[i]);
                    mIsLoadLib = true;
                    return;
                } catch (UnsatisfiedLinkError unused) {
                    i++;
                }
            }
        }
    }

    public boolean create(int i, int i2, int i3, int i4) {
        return NtvCreate(i, i2, i3, i4) == 0;
    }

    public void setSmoothingStrength(int i) {
        NtvSetStrengths(this.mCtx, 1, i, 0, 0, 0, 0);
    }

    public void setToningStrength(int i) {
        NtvSetStrengths(this.mCtx, 2, 0, i, 0, 0, 0);
    }

    public void setSlimmingStrength(int i) {
        NtvSetStrengths(this.mCtx, 4, 0, 0, i, 0, 0);
    }

    public void setEyeEnlargementStrength(int i) {
        NtvSetStrengths(this.mCtx, 8, 0, 0, 0, i, 0);
    }

    public void setEyeCirclesRemovalStrength(int i) {
        NtvSetStrengths(this.mCtx, 16, 0, 0, 0, 0, i);
    }

    public void destroy() {
        NtvDestroy();
    }

    public boolean process(float[] fArr, int i) {
        return NtvProcess(this.mCtx, fArr, i) == 0;
    }

    public void setShowFaceRectangles(boolean z, boolean z2) {
        NtvSetShowFaceRectangles(this.mCtx, z, z2);
    }

    public boolean setViewSize(int i, int i2) {
        return NtvSetViewSize(this.mCtx, i, i2) == 0;
    }

    public boolean setPreviewSize(int i, int i2) {
        return NtvSetPreviewSize(this.mCtx, i, i2) == 0;
    }

    public int getFacesCnt() {
        return NtvGetFacesCnt(this.mCtx);
    }

    public Face getFaceByIndex(int i) {
        Face aVar = new Face();
        if (NtvGetFaceByIndex(this.mCtx, i, aVar) != 0) {
            return null;
        }
        return aVar;
    }

    public Face getMaxFace() {
        int i;
        int facesCnt = getFacesCnt();
        Face aVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < facesCnt; i3++) {
            Face faceByIndex = getFaceByIndex(i3);
            if (faceByIndex != null && i2 <= (i = faceByIndex.f3457a * faceByIndex.f3458b)) {
                aVar = faceByIndex;
                i2 = i;
            }
        }
        return aVar;
    }

    public static String GetEmbeddedProgramsGpu() {
        return NtvGetEmbeddedProgramsGpu();
    }

    public static String GetVfbCpuVersion() {
        return NtvGetVfbCpuVersion();
    }

    public static String GetVfbGpuVersion() {
        return NtvGetVfbGpuVersion();
    }

    public static String GetVfbEngineVersion() {
        return NtvGetVfbEngineVersion();
    }
}
