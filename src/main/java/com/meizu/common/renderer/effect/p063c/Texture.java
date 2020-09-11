package com.meizu.common.renderer.effect.p063c;

import android.graphics.RectF;
import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.Resource;

/* renamed from: com.meizu.common.renderer.effect.c.a */
public abstract class Texture extends Resource {

    /* renamed from: a */
    protected static int[] f4459a = new int[1];

    /* renamed from: b */
    protected int f4460b = -1;

    /* renamed from: c */
    protected int f4461c = -1;

    /* renamed from: d */
    protected RectF f4462d = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: e */
    protected boolean f4463e;

    /* renamed from: f */
    protected GLCanvas f4464f;

    /* renamed from: g */
    protected int f4465g;

    /* renamed from: h */
    protected boolean f4466h;

    /* renamed from: a */
    public int mo15951a() {
        return this.f4465g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15952a(GLCanvas dVar, boolean z) {
        this.f4464f = dVar;
        this.f4466h = z;
    }

    /* renamed from: b */
    public boolean mo15953b() {
        return this.f4464f != null && this.f4466h;
    }

    /* renamed from: c */
    public boolean mo15954c() {
        return this.f4463e;
    }

    public void trimResources(int i, boolean z) {
        if (mo15953b()) {
            this.f4464f.mo15956a(mo15951a(), z);
        }
        mo15952a((GLCanvas) null, false);
    }
}
