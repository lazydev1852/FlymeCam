package com.baidu.p020ar.arplay;

/* renamed from: com.baidu.ar.arplay.ARNativeRunnable */
public final class ARNativeRunnable implements Runnable {
    private long mNativeRunnable;

    private ARNativeRunnable(long j) {
        this.mNativeRunnable = j;
    }

    private native void nativeFinalize();

    private native void nativeRun();

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            nativeFinalize();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    public void run() {
        nativeRun();
    }
}
