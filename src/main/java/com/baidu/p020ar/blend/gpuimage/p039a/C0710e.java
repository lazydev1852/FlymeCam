package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.e */
public class C0710e extends C0712g {

    /* renamed from: a */
    private int f1482a;

    /* renamed from: l */
    private float f1483l;

    public C0710e() {
        this(0.0f);
    }

    public C0710e(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ");
        this.f1483l = f;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1482a = GLES20.glGetUniformLocation(mo10012j(), "exposure");
    }

    /* renamed from: a */
    public void mo9987a(float f) {
        this.f1483l = f;
        mo9989a(this.f1482a, this.f1483l);
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo9987a(this.f1483l);
    }
}
