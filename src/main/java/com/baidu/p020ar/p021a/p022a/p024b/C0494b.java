package com.baidu.p020ar.p021a.p022a.p024b;

import android.opengl.Matrix;
import com.baidu.p020ar.p021a.p031c.C0507a;
import com.baidu.p020ar.slam.ARSlamJniClient;
import com.baidu.p020ar.slam.TrackModel;
import com.baidu.p020ar.slam.TrackParams;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.baidu.ar.a.a.b.b */
public class C0494b {

    /* renamed from: a */
    C0493a f567a;

    /* renamed from: b */
    float f568b = 0.0f;

    /* renamed from: c */
    float[] f569c;

    /* renamed from: d */
    float[] f570d = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: e */
    private boolean f571e;

    /* renamed from: f */
    private float f572f;

    /* renamed from: g */
    private C0507a f573g;

    /* renamed from: h */
    private C0495a f574h;

    /* renamed from: i */
    private int f575i;

    /* renamed from: j */
    private int f576j;

    /* renamed from: k */
    private boolean f577k;

    /* renamed from: l */
    private final Object f578l = new Object();

    /* renamed from: com.baidu.ar.a.a.b.b$a */
    public interface C0495a {
        /* renamed from: a */
        float[] mo8951a();

        /* renamed from: b */
        float mo8952b();
    }

    public C0494b(int i, int i2, boolean z) {
        this.f567a = C0493a.m860a(i, i2, z);
        this.f567a.f562b = i2;
        this.f567a.f561a = i;
        this.f573g = new C0507a();
        this.f575i = i;
        this.f576j = i2;
    }

    /* renamed from: a */
    private TrackParams m865a(byte[] bArr, float[] fArr) {
        this.f569c = fArr;
        return ARSlamJniClient.slamTrack(bArr, m867a(fArr));
    }

    /* renamed from: a */
    private void m866a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, this.f570d, 0, fArr3, 0);
        Matrix.invertM(fArr3, 0, fArr4, 0);
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[1];
        fArr[2] = fArr3[2];
        fArr[4] = fArr3[4];
        fArr[5] = fArr3[5];
        fArr[6] = fArr3[6];
        fArr[8] = fArr3[8];
        fArr[9] = fArr3[9];
        fArr[10] = fArr3[10];
        float a = this.f567a.mo8939a();
        fArr[12] = fArr[12] * this.f572f * a;
        fArr[13] = fArr[13] * this.f572f * a;
        fArr[14] = fArr[14] * this.f572f * a;
        Matrix.rotateM(fArr, 0, this.f568b - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    /* renamed from: a */
    private float[] m867a(float[] fArr) {
        if (this.f568b == 0.0f && this.f574h != null) {
            this.f568b = this.f574h.mo8952b();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, this.f570d, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    /* renamed from: a */
    public int mo8942a(int i) {
        return this.f573g.mo8973a(i);
    }

    /* renamed from: a */
    public int mo8943a(String str, int i, int i2, float[] fArr, float f) {
        this.f572f = f;
        synchronized (this.f578l) {
            if (this.f577k) {
                return -1;
            }
            int insertModel = ARSlamJniClient.insertModel(str, i, i2, (float[]) null, 1.0f);
            return insertModel;
        }
    }

    /* renamed from: a */
    public TrackParams mo8944a(byte[] bArr) {
        if (!this.f571e) {
            return null;
        }
        synchronized (this.f578l) {
            if (this.f577k) {
                return null;
            }
            float[] a = this.f574h != null ? this.f574h.mo8951a() : null;
            if (a == null) {
                return null;
            }
            TrackParams a2 = m865a(bArr, a);
            return a2;
        }
    }

    /* renamed from: a */
    public void mo8945a(C0495a aVar) {
        this.f574h = aVar;
    }

    /* renamed from: a */
    public boolean mo8946a() {
        if (this.f571e) {
            return this.f571e;
        }
        synchronized (this.f578l) {
            if (this.f577k) {
                return false;
            }
            this.f571e = ARSlamJniClient.slamStart(this.f567a.f561a, this.f567a.f562b, this.f567a.mo8940b(), this.f567a.mo8941c());
            return this.f571e;
        }
    }

    /* renamed from: a */
    public float[] mo8947a(float f, float[] fArr) {
        synchronized (this.f578l) {
            if (this.f577k) {
                return null;
            }
            float[] fArr2 = new float[2];
            float[] fArr3 = {(float) ARSlamJniClient.calModelPosition(f, m867a(fArr), fArr2), fArr2[0], fArr2[1]};
            return fArr3;
        }
    }

    /* renamed from: b */
    public ArrayList<TrackModel> mo8948b() {
        if (!this.f571e) {
            return null;
        }
        ArrayList<TrackModel> fetchModelPose = ARSlamJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            m866a(it.next().pose, this.f569c);
        }
        return fetchModelPose;
    }

    /* renamed from: c */
    public void mo8949c() {
        if (this.f571e) {
            synchronized (this.f578l) {
                this.f577k = true;
                ARSlamJniClient.slamStop();
                this.f573g.mo8974a();
                this.f571e = false;
            }
        }
    }

    /* renamed from: d */
    public int mo8950d() {
        synchronized (this.f578l) {
            if (this.f577k) {
                return 0;
            }
            int removeAllModel = ARSlamJniClient.removeAllModel();
            return removeAllModel;
        }
    }
}
