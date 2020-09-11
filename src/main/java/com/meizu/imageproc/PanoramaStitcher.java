package com.meizu.imageproc;

import android.graphics.SurfaceTexture;

public class PanoramaStitcher {

    /* renamed from: a */
    private static int[] f6459a = new int[2];

    /* renamed from: b */
    private static int f6460b;

    /* renamed from: c */
    private static int f6461c;

    /* renamed from: a */
    public static String m6360a(int i) {
        switch (i) {
            case -108:
                return "holding portrait horizontal movement";
            case -107:
                return "a wide range in the wrong direction";
            case -106:
                return "a small range in the wrong direction";
            case -105:
                return "keep horizontal";
            case -104:
                return "out of scene";
            case -103:
                return "high speed";
            case -102:
                return "big displacement";
            case -101:
                return "low contrast";
            default:
                return "";
        }
    }

    public static native int nativeGetOffsets(long j, int[] iArr);

    public static native int nativeGetPanoramaDirectionType(long j);

    public static native int nativeGetResultImage(long j, boolean z, byte[] bArr);

    public static native int nativeGetResultImageSize(long j, boolean z, int[] iArr);

    public static native long nativeInit(int i, int i2, boolean z);

    public static native int nativeProcessImage(long j, SurfaceTexture surfaceTexture, byte[] bArr, int i);

    public static native int nativeProcessImage(long j, SurfaceTextureWrapper surfaceTextureWrapper, byte[] bArr, int i);

    public static native void nativeRelease(long j);

    public static native int nativeStartup(long j, int i);

    public static native int nativeStop(long j);

    public static native void nativeYuv2Rgba(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6);

    /* renamed from: a */
    public static int m6359a() {
        return f6460b;
    }

    /* renamed from: b */
    public static int m6361b() {
        return f6461c;
    }
}
