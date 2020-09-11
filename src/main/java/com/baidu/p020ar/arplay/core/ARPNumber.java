package com.baidu.p020ar.arplay.core;

import com.baidu.p020ar.arplay.representation.Quaternion;
import com.baidu.p020ar.arplay.representation.Vector3f;

/* renamed from: com.baidu.ar.arplay.core.ARPNumber */
public class ARPNumber {
    /* renamed from: a */
    public static Quaternion m1081a(Vector3f vector3f, Vector3f vector3f2) {
        float[] nativeRotationBetweenVector = nativeRotationBetweenVector(vector3f.mo9363x(), vector3f.mo9365y(), vector3f.mo9367z(), vector3f2.mo9363x(), vector3f2.mo9365y(), vector3f2.mo9367z());
        if (nativeRotationBetweenVector.length != 4) {
            return new Quaternion();
        }
        Quaternion quaternion = new Quaternion();
        quaternion.setXYZW(nativeRotationBetweenVector[0], nativeRotationBetweenVector[1], nativeRotationBetweenVector[2], nativeRotationBetweenVector[3]);
        return quaternion;
    }

    private static native float[] nativeRotationBetweenVector(float f, float f2, float f3, float f4, float f5, float f6);
}
