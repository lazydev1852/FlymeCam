package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.wrapper.GLES20Wrapper;

/* renamed from: com.meizu.common.renderer.effect.b.b */
public abstract class ConvolutionRender extends PixelsRender {

    /* renamed from: a */
    protected int f4426a;

    /* renamed from: b */
    protected float f4427b;

    /* renamed from: c */
    protected float f4428c;

    public ConvolutionRender(GLCanvas dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15944a() {
        super.mo15944a();
        this.f4426a = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uStep");
    }
}
