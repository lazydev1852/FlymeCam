package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.a */
public class C0705a extends C0712g {

    /* renamed from: a */
    private int f1472a;

    /* renamed from: l */
    private float f1473l;

    public C0705a() {
        this(0.0f);
    }

    public C0705a(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float brightness;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n }");
        this.f1473l = f;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1472a = GLES20.glGetUniformLocation(mo10012j(), "brightness");
    }

    /* renamed from: a */
    public void mo9981a(float f) {
        this.f1473l = f;
        mo9989a(this.f1472a, this.f1473l);
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo9981a(this.f1473l);
    }
}
