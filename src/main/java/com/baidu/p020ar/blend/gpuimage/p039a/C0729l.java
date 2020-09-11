package com.baidu.p020ar.blend.gpuimage.p039a;

import android.graphics.Bitmap;
import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.l */
public class C0729l extends C0739s {

    /* renamed from: m */
    private int f1542m;

    /* renamed from: n */
    private int f1543n;

    /* renamed from: o */
    private int f1544o;

    /* renamed from: p */
    private float f1545p;

    /* renamed from: q */
    private float f1546q;

    /* renamed from: r */
    private float f1547r;

    public C0729l() {
        this(64.0f, 512.0f, 512.0f);
    }

    public C0729l(float f, float f2, float f3) {
        super(" precision highp float;\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n uniform float lut_width;\n uniform float lut_height;\n uniform float dimension;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     float lut_row = lut_height / dimension;\n     float lut_col = lut_width / dimension;\n     float blueColor = textureColor.b * lut_row * lut_col;\n     \n     vec2 quad1;\n     quad1.y = floor(floor(blueColor) / lut_col);\n     quad1.x = floor(blueColor) - (quad1.y * lut_row);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / lut_col);\n     quad2.x = ceil(blueColor) - (quad2.y * lut_row);\n     \n     vec2 texPos1;\n     float colorIndex = lut_row * lut_col - 1.0;\n     \n     texPos1.x = (quad1.x * dimension + 0.5 + textureColor.r * colorIndex) / lut_width;\n     texPos1.y = (quad1.y * dimension + 0.5 + textureColor.g * colorIndex) / lut_height;\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * dimension + 0.5 + textureColor.r * colorIndex) / lut_width;\n     texPos2.y = (quad2.y * dimension + 0.5 + textureColor.g * colorIndex) / lut_height;\n     \n     lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n     \n     lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.a);\n }");
        this.f1545p = f;
        this.f1546q = f2;
        this.f1547r = f3;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1542m = GLES20.glGetUniformLocation(mo10012j(), "dimension");
        this.f1543n = GLES20.glGetUniformLocation(mo10012j(), "lut_width");
        this.f1544o = GLES20.glGetUniformLocation(mo10012j(), "lut_height");
    }

    /* renamed from: a */
    public void mo10039a(float f) {
        this.f1545p = f;
        mo9989a(this.f1542m, this.f1545p);
    }

    /* renamed from: a */
    public void mo10040a(Bitmap bitmap) {
        super.mo10040a(bitmap);
        if (this.f1581a != null && !this.f1581a.isRecycled()) {
            mo10041b((float) this.f1581a.getWidth());
            mo10042c((float) this.f1581a.getHeight());
        }
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo10039a(this.f1545p);
        mo10041b(this.f1546q);
        mo10042c(this.f1547r);
    }

    /* renamed from: b */
    public void mo10041b(float f) {
        this.f1546q = f;
        mo9989a(this.f1543n, this.f1546q);
    }

    /* renamed from: c */
    public void mo10042c(float f) {
        this.f1547r = f;
        mo9989a(this.f1544o, this.f1547r);
    }
}
