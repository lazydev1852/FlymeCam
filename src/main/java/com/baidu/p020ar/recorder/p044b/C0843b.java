package com.baidu.p020ar.recorder.p044b;

import android.opengl.Matrix;
import com.baidu.p020ar.recorder.filter.C0869c;
import com.baidu.p020ar.recorder.p047e.C0856a;

/* renamed from: com.baidu.ar.recorder.b.b */
public class C0843b {

    /* renamed from: a */
    private static final String f2054a = "b";

    /* renamed from: b */
    private final float[] f2055b = new float[16];

    /* renamed from: c */
    private C0856a f2056c;

    /* renamed from: d */
    private C0845d f2057d;

    /* renamed from: e */
    private C0869c f2058e;

    public C0843b(C0856a aVar, C0845d dVar, C0869c cVar) {
        this.f2056c = aVar;
        this.f2057d = dVar;
        this.f2058e = cVar;
        Matrix.setIdentityM(this.f2055b, 0);
    }

    /* renamed from: a */
    public void mo10443a() {
        float[] fArr;
        int i;
        float f;
        float f2;
        float f3;
        Matrix.setIdentityM(this.f2055b, 0);
        if (this.f2057d.mo10462f() == 1) {
            fArr = this.f2055b;
            i = 0;
            f = 180.0f;
            f2 = 0.0f;
            f3 = 1.0f;
        } else {
            if (this.f2057d.mo10462f() == 2) {
                fArr = this.f2055b;
                i = 0;
                f = 180.0f;
                f2 = 1.0f;
                f3 = 0.0f;
            }
            Matrix.rotateM(this.f2055b, 0, (float) this.f2057d.mo10457c(), 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.f2055b, 0, this.f2057d.mo10460d(), this.f2057d.mo10461e(), 1.0f);
        }
        Matrix.rotateM(fArr, i, f, f2, f3, 0.0f);
        Matrix.rotateM(this.f2055b, 0, (float) this.f2057d.mo10457c(), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.f2055b, 0, this.f2057d.mo10460d(), this.f2057d.mo10461e(), 1.0f);
    }

    /* renamed from: a */
    public void mo10444a(int i, float[] fArr, boolean z, boolean z2) {
        this.f2058e.mo10553a(this.f2055b, this.f2056c.mo10509a(), 0, this.f2056c.mo10511c(), this.f2056c.mo10514f(), this.f2056c.mo10512d(), fArr, this.f2056c.mo10510b(), i, this.f2056c.mo10513e(), z, z2);
    }

    /* renamed from: a */
    public void mo10445a(C0869c cVar) {
        this.f2058e.mo10555g();
        this.f2058e = cVar;
    }

    /* renamed from: a */
    public void mo10446a(boolean z) {
        if (this.f2058e != null) {
            if (z) {
                this.f2058e.mo10555g();
            }
            this.f2058e = null;
        }
    }
}
