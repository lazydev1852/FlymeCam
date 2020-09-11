package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.DrawInfo;
import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.p061a.DrawTextureOp;

/* renamed from: com.meizu.common.renderer.effect.b.o */
public class StaticBlurRender extends AbstractBlurRender {

    /* renamed from: b */
    protected DrawTextureOp f4454b = new DrawTextureOp();

    /* renamed from: c */
    protected DrawInfo f4455c = new DrawInfo();

    /* renamed from: d */
    private GaussianRender f4456d;

    public StaticBlurRender(GLCanvas dVar) {
        super(dVar);
        this.f4456d = GaussianRender.m5052a(dVar);
        this.f4441h = "__static_blur";
    }
}
