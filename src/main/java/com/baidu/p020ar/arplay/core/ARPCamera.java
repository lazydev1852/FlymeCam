package com.baidu.p020ar.arplay.core;

import android.util.Log;

/* renamed from: com.baidu.ar.arplay.core.ARPCamera */
public class ARPCamera extends ARPNode {

    /* renamed from: c */
    private static ARPCamera f743c;

    /* renamed from: a */
    public static ARPCamera m1058a() {
        ARPCamera aRPCamera;
        if (f743c == null) {
            synchronized (ARPCamera.class) {
                if (f743c == null) {
                    f743c = new ARPCamera();
                }
                f743c.m1060g();
                aRPCamera = f743c;
            }
            return aRPCamera;
        }
        f743c.m1060g();
        return f743c;
    }

    /* renamed from: c */
    public static void m1059c() {
        nativeDestory();
    }

    /* renamed from: g */
    private void m1060g() {
        mo9189a(nativeCheckSceneCameraValid());
    }

    static native void nativeDestory();

    /* renamed from: a */
    public void mo9087a(float f) {
        if (this.f810a == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(this.f810a, f);
        }
    }

    /* renamed from: a */
    public void mo9088a(float[] fArr) {
        if (this.f810a == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return;
        }
        this.f811b.lock();
        nativeSetViewMatrix(this.f810a, fArr);
        this.f811b.unlock();
    }

    /* renamed from: b */
    public float[] mo9089b() {
        if (this.f810a == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.f811b.lock();
        float[] nativeGetViewMatrix = nativeGetViewMatrix(this.f810a);
        this.f811b.unlock();
        return nativeGetViewMatrix;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
        synchronized (this) {
            m1059c();
        }
    }

    /* access modifiers changed from: package-private */
    public native long nativeCheckSceneCameraValid();

    /* access modifiers changed from: package-private */
    public native float[] nativeGetViewMatrix(long j);

    /* access modifiers changed from: package-private */
    public native void nativeSetFieldOfView(long j, float f);

    /* access modifiers changed from: package-private */
    public native void nativeSetViewMatrix(long j, float[] fArr);
}
