package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.Resource;

/* renamed from: com.meizu.common.renderer.effect.b.j */
public abstract class Render extends Resource {

    /* renamed from: g */
    protected GLCanvas f4440g;

    /* renamed from: h */
    protected String f4441h = "__none";

    public void trimResources(int i, boolean z) {
    }

    public Render(GLCanvas dVar) {
        this.f4440g = dVar;
    }

    /* renamed from: c */
    public String mo15947c() {
        return this.f4441h;
    }
}
