package com.baidu.p020ar.blend.blender;

import android.opengl.GLSurfaceView;

/* renamed from: com.baidu.ar.blend.blender.d */
public class C0671d {

    /* renamed from: a */
    private C0642a f1381a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0673e f1382b = null;

    public C0671d(C0673e eVar) {
        C0642a aVar = new C0642a();
        this.f1382b = eVar;
        aVar.mo9791a((GLSurfaceView.Renderer) eVar);
        this.f1381a = aVar;
        this.f1381a.mo9790a(1);
    }

    /* renamed from: f */
    private void m1615f() {
        if (this.f1381a != null) {
            this.f1381a.mo9792a((Object) null, 0, 0);
            this.f1381a.mo9796d();
        }
    }

    /* renamed from: a */
    public void mo9878a() {
        if (this.f1381a != null) {
            this.f1381a.mo9795c();
        }
    }

    /* renamed from: a */
    public void mo9879a(int i) {
        if (this.f1381a != null) {
            this.f1381a.mo9790a(i);
        }
    }

    /* renamed from: a */
    public void mo9880a(Object obj, int i, int i2) {
        if (this.f1381a != null) {
            this.f1381a.mo9792a(obj, i, i2);
        }
    }

    /* renamed from: a */
    public void mo9881a(Runnable runnable) {
        if (this.f1381a != null) {
            this.f1381a.mo9793a(runnable);
        }
    }

    /* renamed from: b */
    public void mo9882b() {
        if (this.f1381a != null) {
            this.f1381a.mo9794b();
        }
    }

    /* renamed from: c */
    public void mo9883c() {
        mo9881a((Runnable) new Runnable() {
            public void run() {
                C0671d.this.f1382b.mo9836b();
            }
        });
        mo9882b();
        m1615f();
    }

    /* renamed from: d */
    public void mo9884d() {
        if (this.f1381a != null) {
            this.f1381a.mo9789a();
        }
    }

    /* renamed from: e */
    public C0642a mo9885e() {
        return this.f1381a;
    }
}
