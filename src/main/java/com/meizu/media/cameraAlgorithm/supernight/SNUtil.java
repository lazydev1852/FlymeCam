package com.meizu.media.cameraAlgorithm.supernight;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class SNUtil {
    public static ChangeQuickRedirect changeQuickRedirect;
    private static final Object lock = new Object();
    private static long sHandle = -1;

    static {
        System.loadLibrary("snutil");
    }

    private static native void getSnImage(long j, byte[][] bArr, byte[] bArr2, int i, int i2, boolean z, float[] fArr, int i3, int i4, int i5, int i6, int i7, boolean z2);

    public static void getSnImage(byte[][] bArr, byte[] bArr2, int i, int i2, boolean z, float[] fArr, int i3, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        Object[] objArr = {bArr, bArr2, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0), fArr, new Integer(i3), new Integer(i4), new Integer(i5), new Integer(i6), new Integer(i7), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 8976, new Class[]{byte[][].class, byte[].class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, float[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (lock) {
                if (sHandle == -1) {
                    sHandle = init(z2);
                }
                getSnImage(sHandle, bArr, bArr2, i, i2, z, fArr, i3, i4, i5, i6, i7, z3);
            }
        }
    }

    private static native long init(boolean z);

    public static void initSn(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 8975, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (lock) {
                if (sHandle == -1) {
                    sHandle = init(z);
                }
            }
        }
    }

    public static void unInit() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 8977, new Class[0], Void.TYPE).isSupported) {
            synchronized (lock) {
                if (sHandle != -1) {
                    unInit(sHandle);
                    sHandle = -1;
                }
            }
        }
    }

    private static native void unInit(long j);
}
