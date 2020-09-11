package com.baidu.p020ar.p021a.p022a.p024b;

import com.baidu.p020ar.audio.AudioParams;

/* renamed from: com.baidu.ar.a.a.b.a */
public class C0493a {

    /* renamed from: c */
    private static C0493a f558c = new C0493a();

    /* renamed from: d */
    private static C0493a f559d = new C0493a();

    /* renamed from: e */
    private static C0493a f560e = new C0493a();

    /* renamed from: a */
    int f561a;

    /* renamed from: b */
    int f562b;

    /* renamed from: f */
    private float f563f = 1.0f;

    /* renamed from: g */
    private float[] f564g;

    /* renamed from: h */
    private float[] f565h;

    /* renamed from: i */
    private boolean f566i = false;

    static {
        f558c.f561a = 1280;
        f558c.f562b = 720;
        f558c.f566i = true;
        f558c.f564g = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        f558c.f565h = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        f559d.f561a = AudioParams.DEFAULT_FRAME_SIZE;
        f559d.f562b = 480;
        f558c.f566i = true;
        f559d.f564g = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        f559d.f565h = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        f560e.f561a = AudioParams.DEFAULT_FRAME_SIZE;
        f560e.f562b = 360;
        f560e.f566i = true;
        f560e.f564g = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        f560e.f565h = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private C0493a() {
    }

    public C0493a(int i, int i2) {
        float f = 1.0f;
        this.f561a = i;
        this.f562b = i2;
        this.f563f = i > 640 ? 0.5f : f;
    }

    /* renamed from: a */
    public static C0493a m859a(int i, int i2) {
        C0493a aVar;
        C0493a aVar2;
        C0493a aVar3 = new C0493a(i, i2);
        float f = (float) i;
        float f2 = f / ((float) i2);
        if (((double) Math.abs(f2 - (((float) f558c.f561a) / ((float) f558c.f562b)))) < 0.03d) {
            aVar = f558c;
            aVar2 = f558c;
        } else if (((double) Math.abs(f2 - (((float) f559d.f561a) / ((float) f559d.f562b)))) >= 0.03d) {
            return aVar3;
        } else {
            aVar = f559d;
            aVar2 = f559d;
        }
        aVar3.m861a(aVar, f / ((float) aVar2.f561a));
        return aVar3;
    }

    /* renamed from: a */
    public static C0493a m860a(int i, int i2, boolean z) {
        if (!z) {
            return m859a(i, i2);
        }
        C0493a aVar = new C0493a(i, i2);
        float f = (float) i;
        if (((double) Math.abs((f / ((float) i2)) - (((float) f560e.f561a) / ((float) f560e.f562b)))) < 0.03d) {
            aVar.m861a(f560e, f / ((float) f560e.f561a));
        }
        return aVar;
    }

    /* renamed from: a */
    private void m861a(C0493a aVar, float f) {
        this.f564g = new float[9];
        this.f565h = new float[5];
        this.f566i = true;
        for (int i = 0; i < 8; i++) {
            this.f564g[i] = aVar.f564g[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.f565h[i2] = aVar.f565h[i2];
        }
    }

    /* renamed from: a */
    public float mo8939a() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float[] mo8940b() {
        return this.f564g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float[] mo8941c() {
        return this.f565h;
    }
}
