package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.c */
public class C0708c extends C0712g {

    /* renamed from: a */
    private int f1480a;

    /* renamed from: l */
    private float f1481l;

    public C0708c() {
        this(1.2f);
    }

    public C0708c(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }");
        this.f1481l = f;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1480a = GLES20.glGetUniformLocation(mo10012j(), "contrast");
    }

    /* renamed from: a */
    public void mo9986a(float f) {
        this.f1481l = f;
        mo9989a(this.f1480a, this.f1481l);
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo9986a(this.f1481l);
    }
}
