package com.baidu.p020ar;

import com.baidu.p020ar.arplay.core.ARPCamera;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.ARPScene;
import com.baidu.p020ar.arplay.core.ARPScriptEnvironment;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.representation.Matrix;
import com.baidu.p020ar.arplay.representation.Matrixf4x4;
import com.baidu.p020ar.arplay.representation.Quaternion;
import com.baidu.p020ar.arplay.representation.Vector3f;
import com.baidu.p020ar.arplay.representation.Vector4f;
import com.baidu.p020ar.track.TrackStateMachine;
import java.util.HashMap;

/* renamed from: com.baidu.ar.a */
public class C0482a {

    /* renamed from: a */
    private static C0482a f510a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Matrixf4x4 f511b = new Matrixf4x4();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Matrixf4x4 f512c = new Matrixf4x4();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Matrixf4x4 f513d = new Matrixf4x4();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Matrixf4x4 f514e = new Matrixf4x4();

    /* renamed from: f */
    private float[] f515f = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f516g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f517h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f518i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f519j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f520k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f521l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f522m = false;

    /* renamed from: n */
    private boolean f523n = true;

    /* renamed from: o */
    private boolean f524o = false;

    /* renamed from: p */
    private boolean f525p = true;

    /* renamed from: q */
    private boolean f526q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f527r = false;

    /* renamed from: s */
    private boolean f528s = false;

    /* renamed from: t */
    private ARPEngine.C0571e f529t = new ARPEngine.C0571e() {
        /* renamed from: a */
        public void mo8920a() {
            if (C0482a.this.f516g) {
                ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap<String, Object>) null);
                boolean unused = C0482a.this.f522m = ARPEngine.getInstance().isDriverdByARPVersion();
                boolean unused2 = C0482a.this.f516g = false;
            }
            Matrixf4x4 b = C0482a.this.f511b;
            if (C0482a.this.f522m) {
                b = C0482a.this.m798a(b);
            }
            ARPCamera.m1058a().mo9088a(b.getMatrix());
        }
    };

    /* renamed from: u */
    private ARPEngine.C0571e f530u = new ARPEngine.C0571e() {
        /* renamed from: a */
        public void mo8920a() {
            if (TrackStateMachine.getInstance().getTrackState() == TrackStateMachine.STATE.TRACKED) {
                ARPCamera.m1058a().mo9088a(C0482a.this.f511b.getMatrix());
            }
        }
    };

    /* renamed from: v */
    private ARPEngine.C0571e f531v = new ARPEngine.C0571e() {
        /* renamed from: a */
        public void mo8920a() {
            float[] fArr;
            float[] fArr2;
            Matrixf4x4 k;
            if (C0482a.this.f521l) {
                if (C0482a.this.f518i && !C0482a.this.f517h) {
                    boolean unused = C0482a.this.f517h = true;
                    ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap<String, Object>) null);
                    boolean unused2 = C0482a.this.f522m = ARPEngine.getInstance().isDriverdByARPVersion();
                }
                Matrixf4x4 matrixf4x4 = new Matrixf4x4();
                matrixf4x4.setMatrixValues(C0482a.this.f511b.getMatrix());
                matrixf4x4.transpose();
                Matrixf4x4 e = ARPCamera.m1058a().mo9194e();
                float[] matrix = e.getMatrix();
                Vector3f vector3f = new Vector3f(matrix[12], matrix[13], matrix[14]);
                Matrixf4x4 matrixf4x42 = new Matrixf4x4();
                matrix[14] = 0.0f;
                matrix[13] = 0.0f;
                matrix[12] = 0.0f;
                matrixf4x42.setMatrixValues(matrix);
                Matrixf4x4 matrixf4x43 = new Matrixf4x4();
                Matrix.invertM(matrixf4x43.getMatrix(), 0, matrixf4x42.getMatrix(), 0);
                Vector4f vector4f = new Vector4f();
                Matrix.multiplyMV3(vector4f.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
                vector3f.setXYZ(vector4f.mo9392x(), vector4f.mo9394y(), vector4f.mo9396z());
                if (C0482a.this.f519j) {
                    boolean unused3 = C0482a.this.f519j = false;
                    if (C0482a.this.f520k == 1) {
                        C0482a.this.f512c.setMatrixValues(matrixf4x4.getMatrix());
                        Matrixf4x4 matrixf4x44 = new Matrixf4x4();
                        matrixf4x44.setW0(vector3f.mo9363x());
                        matrixf4x44.setW1(vector3f.mo9365y());
                        matrixf4x44.setW2(vector3f.mo9367z());
                        float[] fArr3 = new float[16];
                        Matrix.multiplyMM(fArr3, matrixf4x4.getMatrix(), matrixf4x44.getMatrix());
                        fArr2 = new float[16];
                        Matrix.invertM(fArr2, 0, fArr3, 0);
                        k = C0482a.this.f513d;
                    } else {
                        fArr2 = new float[16];
                        Matrix.transposeM(fArr2, 0, matrixf4x4.getMatrix(), 0);
                        k = C0482a.this.f514e;
                    }
                    k.setMatrixValues(fArr2);
                }
                float[] fArr4 = new float[16];
                Matrix.multiplyMM(fArr4, C0482a.this.f514e.getMatrix(), matrixf4x4.getMatrix());
                matrixf4x4.setMatrixValues(fArr4);
                Matrixf4x4 matrixf4x45 = new Matrixf4x4();
                if (C0482a.this.f520k != 1) {
                    Matrixf4x4 matrixf4x46 = new Matrixf4x4();
                    matrixf4x46.setW0(vector3f.mo9363x());
                    matrixf4x46.setW1(vector3f.mo9365y());
                    matrixf4x46.setW2(vector3f.mo9367z());
                    float[] fArr5 = new float[16];
                    Matrix.multiplyMM(fArr5, matrixf4x46.getMatrix(), matrixf4x4.getMatrix());
                    fArr = new float[16];
                    Matrix.invertM(fArr, 0, fArr5, 0);
                } else if (C0482a.this.f516g) {
                    boolean unused4 = C0482a.this.f516g = false;
                    C0482a.this.f512c.setMatrixValues(matrixf4x4.getMatrix());
                    C0482a.this.f513d.loadIndentity();
                    Matrix.translateM(C0482a.this.f513d.getMatrix(), 0, vector3f.getX(), vector3f.getY(), vector3f.getZ());
                    float[] fArr6 = new float[16];
                    Matrix.multiplyMM(fArr6, matrixf4x4.getMatrix(), C0482a.this.f513d.getMatrix());
                    float[] fArr7 = new float[16];
                    Matrix.invertM(fArr7, 0, fArr6, 0);
                    C0482a.this.f513d.setMatrixValues(fArr7);
                    fArr = e.getMatrix();
                } else {
                    Matrixf4x4 matrixf4x47 = new Matrixf4x4();
                    float[] fArr8 = new float[16];
                    Matrix.transposeM(fArr8, 0, C0482a.this.f512c.getMatrix(), 0);
                    float[] fArr9 = new float[16];
                    Matrix.multiplyMM(fArr9, fArr8, matrixf4x4.getMatrix());
                    matrixf4x47.setMatrixValues(fArr9);
                    Matrix.transposeM(fArr9, 0, matrixf4x47.getMatrix(), 0);
                    fArr = new float[16];
                    Matrix.multiplyMM(fArr, fArr9, C0482a.this.f513d.getMatrix());
                }
                matrixf4x45.setMatrixValues(fArr);
                if (C0482a.this.f527r) {
                    float[] fArr10 = new float[16];
                    Matrix.invertM(fArr10, 0, matrixf4x45.getMatrix(), 0);
                    Matrixf4x4 matrixf4x48 = new Matrixf4x4();
                    matrixf4x48.setMatrix(fArr10);
                    matrixf4x48.setW0(0.0f);
                    matrixf4x48.setW1(0.0f);
                    matrixf4x48.setW2(0.0f);
                    matrixf4x48.setW3(1.0f);
                    Vector3f vector3f2 = new Vector3f(-fArr10[12], -fArr10[13], -fArr10[14]);
                    Vector4f vector4f2 = new Vector4f(0.0f, 0.0f, 1.0f, 1.0f);
                    matrixf4x48.multiplyVector4fByMatrix(vector4f2);
                    Vector3f vector3f3 = new Vector3f(vector4f2.mo9392x(), vector4f2.mo9394y(), vector4f2.mo9396z());
                    vector3f3.add(vector3f2);
                    Vector4f vector4f3 = new Vector4f(0.0f, -1.0f, 0.0f, 1.0f);
                    matrixf4x48.multiplyVector4fByMatrix(vector4f3);
                    Matrixf4x4 lookAtLH = Matrixf4x4.lookAtLH(vector3f2, vector3f3, new Vector3f(vector4f3.mo9392x(), vector4f3.mo9394y(), vector4f3.mo9396z()));
                    Matrixf4x4 matrixf4x49 = new Matrixf4x4();
                    matrixf4x49.setX0(-1.0f);
                    Matrix.multiplyMM(matrixf4x45.getMatrix(), matrixf4x49.getMatrix(), lookAtLH.getMatrix());
                }
                if (ARPEngine.getInstance().getImuType() == 0 && C0482a.this.f522m) {
                    matrixf4x45 = C0482a.this.m798a(matrixf4x45);
                }
                ARPCamera.m1058a().mo9088a(matrixf4x45.getMatrix());
            }
        }
    };

    /* renamed from: a */
    public static C0482a m796a() {
        if (f510a == null) {
            synchronized (C0482a.class) {
                if (f510a == null) {
                    f510a = new C0482a();
                }
            }
        }
        return f510a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Matrixf4x4 m798a(Matrixf4x4 matrixf4x4) {
        if (matrixf4x4 == null) {
            return null;
        }
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), -90.0f);
        Matrixf4x4 matrix4x4 = quaternion.getMatrix4x4();
        Matrixf4x4 matrixf4x44 = new Matrixf4x4();
        matrixf4x44.setMatrixValues(matrixf4x43.getMatrix());
        matrixf4x44.getMatrix()[12] = 0.0f;
        matrixf4x44.getMatrix()[13] = 0.0f;
        matrixf4x44.getMatrix()[14] = 0.0f;
        matrixf4x44.getMatrix()[15] = 1.0f;
        Matrix.multiplyMM(matrixf4x42.getMatrix(), matrix4x4.getMatrix(), matrixf4x44.getMatrix());
        matrixf4x44.setMatrixValues(matrixf4x42.getMatrix());
        Vector3f vector3f = new Vector3f(matrixf4x43.getMatrix()[12], matrixf4x43.getMatrix()[13], matrixf4x43.getMatrix()[14]);
        float z = vector3f.mo9367z();
        vector3f.setZ(vector3f.mo9365y() * -1.0f);
        vector3f.setY(z);
        Matrixf4x4 matrixf4x45 = new Matrixf4x4();
        Matrix.translateM(matrixf4x45.getMatrix(), 0, vector3f.mo9363x(), vector3f.mo9365y(), vector3f.mo9367z());
        Matrixf4x4 matrixf4x46 = new Matrixf4x4();
        Matrix.multiplyMM(matrixf4x42.getMatrix(), matrixf4x45.getMatrix(), matrixf4x44.getMatrix());
        matrixf4x46.setMatrixValues(matrixf4x42.getMatrix());
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x46.getMatrix(), 0);
        matrixf4x4.setMatrixValues(matrixf4x42.getMatrix());
        return matrixf4x4;
    }

    /* renamed from: c */
    public static void m803c() {
        ARPEngine.getInstance().setUpdateCallback((ARPEngine.C0571e) null);
        f510a = null;
    }

    /* renamed from: a */
    public void mo8908a(boolean z) {
        ARPScene currentScene;
        this.f519j = true;
        if (!z && (currentScene = ARPEngine.getInstance().getCurrentScene()) != null) {
            currentScene.mo9207c();
        }
    }

    /* renamed from: a */
    public void mo8909a(float[] fArr) {
        if (!this.f528s) {
            if (this.f526q) {
                mo8911b();
            } else if (fArr != null && fArr.length == 16) {
                float[] fArr2 = {fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13], fArr[14], fArr[15]};
                Matrixf4x4 matrixf4x4 = new Matrixf4x4();
                matrixf4x4.setMatrix(fArr2);
                if (!this.f523n) {
                    if (this.f525p) {
                        ARPEngine.getInstance().getCurrentScene().mo9206b(true);
                        this.f525p = false;
                    }
                    if (this.f524o) {
                        this.f524o = false;
                        ARPEngine.getInstance().sceneWorldPositionToOrigin();
                    }
                    this.f511b = matrixf4x4;
                    ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, this.f511b);
                    ARPEngine.getInstance().setUpdateCallback(this.f529t);
                } else if (this.f525p) {
                    matrixf4x4.setMatrixValues(this.f515f);
                    this.f511b = matrixf4x4;
                    ARPEngine.getInstance().setUpdateCallback(this.f529t);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8910a(float[] fArr, int i) {
        if (fArr != null && fArr.length == 16) {
            this.f511b.setMatrixValues(new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13], fArr[14], fArr[15]});
            ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_IMU, this.f511b);
            this.f518i = true;
            this.f520k = i;
            ARPEngine.getInstance().getCurrentScene().mo9206b(true);
            ARPEngine.getInstance().setUpdateCallback(this.f531v);
        }
    }

    /* renamed from: b */
    public void mo8911b() {
        ARPEngine.getInstance().setUpdateCallback((ARPEngine.C0571e) null);
    }

    /* renamed from: b */
    public void mo8912b(boolean z) {
        this.f524o = z;
    }

    /* renamed from: b */
    public void mo8913b(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 != null && fArr2.length >= 12) {
            float[] fArr3 = {fArr2[0], fArr2[3], fArr2[6], 0.0f, fArr2[1], fArr2[4], fArr2[7], 0.0f, fArr2[2], fArr2[5], fArr2[8], 0.0f, fArr2[9], fArr2[10], fArr2[11], 1.0f};
            Matrixf4x4 matrixf4x4 = new Matrixf4x4();
            matrixf4x4.setMatrix(fArr3);
            Vector4f vector4f = new Vector4f(fArr2[0], fArr2[1], fArr2[2], fArr2[9]);
            Vector4f vector4f2 = new Vector4f(fArr2[3], fArr2[4], fArr2[5], fArr2[10]);
            Vector4f vector4f3 = new Vector4f(fArr2[6], fArr2[7], fArr2[8], fArr2[11]);
            Vector4f vector4f4 = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
            Vector4f vector4f5 = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (new Vector4f(Math.abs(vector4f.dotProduct(vector4f5)), Math.abs(vector4f2.dotProduct(vector4f5)), Math.abs(vector4f3.dotProduct(vector4f5)), Math.abs(vector4f4.dotProduct(vector4f5))).dotProduct(vector4f5) > 0.001f) {
                this.f511b = matrixf4x4;
                ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_TRACK, this.f511b);
                ARPEngine.getInstance().getCurrentScene().mo9206b(true);
            }
            ARPEngine.getInstance().setUpdateCallback(this.f530u);
        }
    }

    /* renamed from: c */
    public void mo8914c(boolean z) {
        this.f523n = z;
    }

    /* renamed from: d */
    public void mo8915d() {
        this.f516g = true;
        this.f517h = false;
        this.f518i = false;
        this.f519j = false;
        this.f520k = 0;
        this.f521l = false;
        this.f522m = false;
        this.f523n = true;
        this.f524o = false;
        this.f525p = true;
        this.f526q = false;
        this.f527r = false;
    }

    /* renamed from: d */
    public void mo8916d(boolean z) {
        this.f526q = z;
    }

    /* renamed from: e */
    public void mo8917e(boolean z) {
        this.f527r = z;
    }

    /* renamed from: f */
    public void mo8918f(boolean z) {
        this.f528s = z;
    }

    /* renamed from: g */
    public void mo8919g(boolean z) {
        this.f521l = z;
    }
}
