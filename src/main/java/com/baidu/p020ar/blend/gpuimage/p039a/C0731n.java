package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.n */
public class C0731n extends C0712g {

    /* renamed from: a */
    private int f1556a;

    /* renamed from: l */
    private float f1557l;

    public C0731n() {
        this(1.0f);
    }

    public C0731n(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float saturation;\n \n // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham\n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    gl_FragColor = vec4(mix(greyScaleColor, textureColor.rgb, saturation), textureColor.w);\n     \n }");
        this.f1557l = f;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1556a = GLES20.glGetUniformLocation(mo10012j(), "saturation");
    }

    /* renamed from: a */
    public void mo10045a(float f) {
        this.f1557l = f;
        mo9989a(this.f1556a, this.f1557l);
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo10045a(this.f1557l);
    }
}
