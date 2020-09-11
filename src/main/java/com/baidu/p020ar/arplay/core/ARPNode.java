package com.baidu.p020ar.arplay.core;

import android.util.Log;
import com.baidu.p020ar.arplay.representation.Matrixf4x4;
import com.baidu.p020ar.arplay.representation.Vector3f;
import com.baidu.p020ar.arplay.representation.Vector4f;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.ar.arplay.core.ARPNode */
public class ARPNode {

    /* renamed from: a */
    protected long f810a = -1;

    /* renamed from: b */
    protected Lock f811b;

    /* renamed from: c */
    private HashMap<String, ARPNode> f812c;

    public ARPNode() {
        mo9193d();
    }

    /* renamed from: a */
    public void mo9189a(long j) {
        this.f810a = j;
    }

    /* renamed from: a */
    public void mo9190a(Vector3f vector3f) {
        if (this.f810a == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.f811b.lock();
            nativeSetWorldPosition(this.f810a, vector3f.toArray());
            this.f811b.unlock();
        }
    }

    /* renamed from: a */
    public void mo9191a(Vector4f vector4f) {
        if (this.f810a == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector4f != null) {
            this.f811b.lock();
            nativeSetRotation(this.f810a, vector4f.toArray());
            this.f811b.unlock();
        }
    }

    /* renamed from: b */
    public void mo9192b(Vector3f vector3f) {
        if (this.f810a == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.f811b.lock();
            nativeSetRotateWorldAxis(this.f810a, vector3f.toArray());
            this.f811b.unlock();
        }
    }

    /* renamed from: d */
    public void mo9193d() {
        this.f811b = new ReentrantLock();
        nativeInit();
        this.f812c = new HashMap<>();
    }

    /* renamed from: e */
    public Matrixf4x4 mo9194e() {
        if (this.f810a == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.f811b.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.f810a);
        this.f811b.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    /* renamed from: f */
    public Vector4f mo9195f() {
        if (this.f810a == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.f811b.lock();
        float[] nativeGetRotation = nativeGetRotation(this.f810a);
        this.f811b.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        this.f810a = -1;
        this.f812c.clear();
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public native float[] nativeGetRotation(long j);

    /* access modifiers changed from: package-private */
    public native void nativeInit();

    /* access modifiers changed from: package-private */
    public native float[] nativeInitialTransform(long j);

    /* access modifiers changed from: package-private */
    public native void nativeSetRotateWorldAxis(long j, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetRotation(long j, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetWorldPosition(long j, float[] fArr);
}
