package com.meizu.media.camera.singlebokeh;

import android.util.Log;

public class BokehAlorgrithmMgr {
    public static native int captureProcess(long j, byte[] bArr, int i, int i2, int i3, int i4, float f);

    public static native long init(int i, int i2, int i3, boolean z);

    public static native int previewProcess(long j, byte[] bArr, int i, int i2, int i3, int i4, float f);

    public static native void setCaptureFace(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void setFace(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void uninit(long j, boolean z);

    static {
        try {
            Log.i("BokehAlorgrithmMgr", "loadLibrary bokehalgorithmsdk");
            System.loadLibrary("bokehalgorithmsdk");
        } catch (UnsatisfiedLinkError e) {
            Log.e("BokehAlorgrithmMgr", "loadLibrary bokehalgorithmsdk error");
            e.printStackTrace();
        }
    }
}
