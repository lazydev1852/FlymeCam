package com.baidu.p020ar.arplay.core;

import android.util.Log;
import java.util.HashMap;

/* renamed from: com.baidu.ar.arplay.core.ARPScene */
public class ARPScene {

    /* renamed from: a */
    private HashMap<String, ARPNode> f813a;

    /* renamed from: b */
    private long f814b = -1;

    public ARPScene() {
        m1083d();
    }

    /* renamed from: b */
    private ARPNode m1082b(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.f813a.get(nativeGetNodeName);
        if (aRPNode != null) {
            return aRPNode;
        }
        ARPNode aRPNode2 = new ARPNode();
        aRPNode2.mo9189a(j);
        this.f813a.put(nativeGetNodeName, aRPNode2);
        return aRPNode2;
    }

    /* renamed from: d */
    private void m1083d() {
        this.f813a = new HashMap<>();
    }

    /* renamed from: a */
    public ARPCamera mo9202a() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.f814b);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.mo9189a(nativeGetActiveCamera);
        return aRPCamera;
    }

    /* renamed from: a */
    public void mo9203a(long j) {
        this.f814b = j;
    }

    /* renamed from: a */
    public boolean mo9204a(boolean z) {
        if (this.f814b == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(this.f814b, z);
        return true;
    }

    /* renamed from: b */
    public ARPNode mo9205b() {
        if (this.f814b != -1) {
            return m1082b(nativeGetRootNode(this.f814b));
        }
        Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        return null;
    }

    /* renamed from: b */
    public void mo9206b(boolean z) {
        if (this.f814b == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(this.f814b, z);
        }
    }

    /* renamed from: c */
    public void mo9207c() {
        if (this.f814b == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(this.f814b);
        }
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetActiveCamera(long j);

    /* access modifiers changed from: package-private */
    public native String nativeGetNodeName(long j);

    /* access modifiers changed from: package-private */
    public native long nativeGetRootNode(long j);

    /* access modifiers changed from: package-private */
    public native void nativeRelocate(long j);

    /* access modifiers changed from: package-private */
    public native void nativeSetOffScreenGuideWork(long j, boolean z);

    /* access modifiers changed from: package-private */
    public native void nativeSetVisible(long j, boolean z);
}
