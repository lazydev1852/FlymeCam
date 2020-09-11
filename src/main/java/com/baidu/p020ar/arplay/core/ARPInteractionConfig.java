package com.baidu.p020ar.arplay.core;

import com.baidu.p020ar.arplay.representation.Vector3f;

/* renamed from: com.baidu.ar.arplay.core.ARPInteractionConfig */
public class ARPInteractionConfig {
    /* renamed from: a */
    public static void m1073a(Vector3f vector3f, float f) {
        nativeSetMovePlane(vector3f.getX(), vector3f.getY(), vector3f.getZ(), f);
    }

    private static native void nativeSetMovePlane(float f, float f2, float f3, float f4);
}
