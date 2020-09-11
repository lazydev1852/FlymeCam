package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.ShaderUtils;
import com.meizu.common.renderer.wrapper.GLES20Wrapper;
import java.nio.FloatBuffer;

/* renamed from: com.meizu.common.renderer.effect.b.i */
public abstract class PixelsRender extends ShaderRender {

    /* renamed from: a */
    private static final float[] f4436a = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: b */
    private static final float[] f4437b = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: c */
    private static FloatBuffer f4438c;

    /* renamed from: d */
    private static FloatBuffer f4439d;

    static {
        m5058e();
    }

    public PixelsRender(GLCanvas dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15944a() {
        this.f4443i = ShaderUtils.m5096a(mo15950d(), mo15945b());
        if (this.f4443i != 0) {
            GLES20Wrapper.glUseProgram(this.f4443i);
            this.f4444j = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uMVPMatrix");
            this.f4445k = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uSTMatrix");
            this.f4447m = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uAlpha");
            this.f4446l = GLES20Wrapper.glGetUniformLocation(this.f4443i, "sTexture");
            this.f4448n = GLES20Wrapper.glGetAttribLocation(this.f4443i, "aPosition");
            this.f4449o = GLES20Wrapper.glGetAttribLocation(this.f4443i, "aTexCoord");
            return;
        }
        throw new IllegalArgumentException(getClass() + ": mProgram = 0");
    }

    /* renamed from: e */
    private static void m5058e() {
        f4438c = m5064b((f4436a.length * 32) / 8).asFloatBuffer();
        f4438c.put(f4436a);
        f4438c.position(0);
        f4439d = m5064b((f4437b.length * 32) / 8).asFloatBuffer();
        f4439d.put(f4437b);
        f4439d.position(0);
    }
}
