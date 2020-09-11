package com.mediatek.perfframe;

import android.os.Process;

public final class PerfFrameInfoManagerImpl extends PerfFrameInfoManager {
    private static final int GLSURFACE = 2;
    private static final int HWUI = 1;
    private static final int SWUI = 0;
    private static final String TAG = "PerfFrameInfoManagerImpl";
    private static Object lock = new Object();
    private static PerfFrameInfoManagerImpl sInstance;
    private boolean draw_start;
    private boolean software_draw;

    public static native int nativeMarkDrawStart(long j);

    public static native int nativeMarkFrameComplete(int i, int i2, int i3, long j);

    public static native int nativeMarkIntendedVsync(int i, long j);

    public static native int nativeMarkNoRender(long j);

    static {
        System.loadLibrary("perfframeinfo_jni");
    }

    public static PerfFrameInfoManagerImpl getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new PerfFrameInfoManagerImpl();
                }
            }
        }
        return sInstance;
    }

    private PerfFrameInfoManagerImpl() {
    }

    public void setDrawStart(long j) {
        this.draw_start = true;
        nativeMarkDrawStart(j);
    }

    public void setSoftwareDraw() {
        this.software_draw = true;
    }

    public void clearDrawStartAndMarkIntendedVsync(long j) {
        int myPid = Process.myPid();
        this.draw_start = false;
        this.software_draw = false;
        nativeMarkIntendedVsync(myPid, j);
    }

    public void markDoFrameEnd(int i, long j) {
        int myPid = Process.myPid();
        if (this.software_draw) {
            nativeMarkFrameComplete(myPid, i, 0, j);
        } else if (!this.draw_start) {
            nativeMarkNoRender(j);
        }
    }

    public void markGLDrawStart() {
        nativeMarkIntendedVsync(Process.myTid(), 0);
    }

    public void markGLDrawEnd(int i) {
        nativeMarkFrameComplete(Process.myTid(), i, 2, 0);
    }
}
