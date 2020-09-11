package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.u */
public class C0743u extends C0742t {
    public C0743u(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        mo10063q();
    }

    /* renamed from: a */
    public void mo9990a(int i, int i2) {
        super.mo9990a(i, i2);
        mo10063q();
    }

    /* renamed from: o */
    public float mo10033o() {
        return 1.0f;
    }

    /* renamed from: p */
    public float mo10034p() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo10063q() {
        if (this.f1492i > 0 && this.f1493j > 0) {
            float p = mo10034p();
            C0712g gVar = (C0712g) this.f1535a.get(0);
            int glGetUniformLocation = GLES20.glGetUniformLocation(gVar.mo10012j(), "texelWidthOffset");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(gVar.mo10012j(), "texelHeightOffset");
            gVar.mo9989a(glGetUniformLocation, p / ((float) this.f1492i));
            gVar.mo9989a(glGetUniformLocation2, 0.0f);
            float o = mo10033o();
            C0712g gVar2 = (C0712g) this.f1535a.get(1);
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(gVar2.mo10012j(), "texelWidthOffset");
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(gVar2.mo10012j(), "texelHeightOffset");
            gVar2.mo9989a(glGetUniformLocation3, 0.0f);
            gVar2.mo9989a(glGetUniformLocation4, o / ((float) this.f1493j));
        }
    }
}
