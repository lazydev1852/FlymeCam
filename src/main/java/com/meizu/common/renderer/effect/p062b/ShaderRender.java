package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.meizu.common.renderer.effect.b.m */
public abstract class ShaderRender extends Render {

    /* renamed from: i */
    protected int f4443i = 0;

    /* renamed from: j */
    protected int f4444j;

    /* renamed from: k */
    protected int f4445k;

    /* renamed from: l */
    protected int f4446l;

    /* renamed from: m */
    protected int f4447m;

    /* renamed from: n */
    protected int f4448n;

    /* renamed from: o */
    protected int f4449o;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo15944a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo15945b() {
        return "precision mediump float;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvarying vec2 vTexCoord;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTexCoord);\n    gl_FragColor.a *= uAlpha; \n}\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo15950d() {
        return "uniform mat4 uMVPMatrix; \nuniform mat4 uSTMatrix;\nattribute vec3 aPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * vec4(aPosition,1);\n    vTexCoord = (uSTMatrix * vec4(aTexCoord,0,1)).st;\n}";
    }

    public ShaderRender(GLCanvas dVar) {
        super(dVar);
        mo15944a();
    }

    public void trimResources(int i, boolean z) {
        if (!(this.f4443i == 0 || this.f4440g == null)) {
            this.f4440g.mo15960d(this.f4443i, z);
            this.f4443i = 0;
            this.f4441h = null;
            this.f4440g = null;
        }
        super.trimResources(i, z);
    }

    /* renamed from: b */
    public static ByteBuffer m5064b(int i) {
        return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
    }
}
