package com.arcsoft.livebroadcast;

import android.util.Log;

public abstract class ArcSpotlightBase {
    public static final int ASL_MERR_BAD_STATE = 5;
    public static final int ASL_MERR_BOUNDID_ERROR = 32768;
    public static final int ASL_MERR_EXPIRED = 7;
    public static final int ASL_MERR_FILE_NOT_FOUND = 6;
    public static final int ASL_MERR_INVALID_PARAM = 2;
    public static final int ASL_MERR_NO_MEMORY = 4;
    public static final int ASL_MERR_UNKNOWN = 1;
    public static final int ASL_MERR_UNSUPPORTED = 3;
    private static final int MERR_BASIC_BASE = 1;
    protected long nativeObjectRef;

    public abstract Object nativeGetVersion(long j);

    ArcSpotlightBase() {
    }

    public ArcSpotlightVersion getVersion() {
        return (ArcSpotlightVersion) nativeGetVersion(this.nativeObjectRef);
    }

    static {
        try {
            System.loadLibrary("mpbase");
            Log.e("mz0601", "==========System.loadLibrary(\"mpbase\");===========");
        } catch (UnsatisfiedLinkError e) {
            Log.e("mz0601", "loadLibrary mpbase error");
            e.printStackTrace();
        }
        try {
            System.loadLibrary("arcsoft_face_alignment");
            Log.e("mz0601", "==========System.loadLibrary(\"arcsoft_face_alignment\");===========");
        } catch (UnsatisfiedLinkError e2) {
            Log.e("mz0601", "loadLibrary arcsoft_face_alignment error");
            e2.printStackTrace();
        }
    }
}
