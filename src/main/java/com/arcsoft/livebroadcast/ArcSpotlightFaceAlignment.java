package com.arcsoft.livebroadcast;

public class ArcSpotlightFaceAlignment extends ArcSpotlightBase {
    public static final int ASL_FOP_0_HIGHER_EXT = -1;
    public static final int ASL_FOP_0_ONLY = 0;
    public static final int ASL_FOP_180_ONLY = 180;
    public static final int ASL_FOP_270_ONLY = 270;
    public static final int ASL_FOP_90_ONLY = 90;
    public static final int ASL_MAX_FACE_NUM = 10;
    public static final int ASL_OUTLINE_MAPPING_POINT_COUNT = 106;
    public static final int ASL_OUTLINE_POINT_COUNT = 122;

    private native long nativeCreateEngine();

    private native void nativeDestroyEngine(long j);

    private native int nativeInitial(long j, String str, int i);

    private native int nativeProcess(long j, Object obj, int i, int i2, ArcSpotlightFaceInfo arcSpotlightFaceInfo, ArcSpotlightFaceStatus arcSpotlightFaceStatus);

    private native void nativeUninitial(long j);

    public native Object nativeGetVersion(long j);

    public /* bridge */ /* synthetic */ ArcSpotlightVersion getVersion() {
        return super.getVersion();
    }

    public ArcSpotlightFaceAlignment() {
        this.nativeObjectRef = nativeCreateEngine();
    }

    public int initialize(String str, int i) {
        return nativeInitial(this.nativeObjectRef, str, i);
    }

    public void uninitialize() {
        nativeUninitial(this.nativeObjectRef);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        nativeDestroyEngine(this.nativeObjectRef);
        super.finalize();
    }

    public int process(ArcSpotlightOffscreen arcSpotlightOffscreen, int i, int i2, ArcSpotlightFaceInfo arcSpotlightFaceInfo, ArcSpotlightFaceStatus arcSpotlightFaceStatus) {
        if (arcSpotlightFaceInfo == null) {
            return 2;
        }
        arcSpotlightFaceInfo.setEmpty();
        return nativeProcess(this.nativeObjectRef, arcSpotlightOffscreen, i, i2, arcSpotlightFaceInfo, arcSpotlightFaceStatus);
    }
}
