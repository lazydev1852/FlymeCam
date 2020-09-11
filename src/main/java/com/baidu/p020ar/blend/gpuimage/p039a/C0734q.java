package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;

/* renamed from: com.baidu.ar.blend.gpuimage.a.q */
public class C0734q extends C0712g {

    /* renamed from: a */
    private int f1559a = -1;

    /* renamed from: l */
    private int f1560l = -1;

    /* renamed from: m */
    private int f1561m = -1;

    /* renamed from: n */
    private int f1562n = -1;

    /* renamed from: o */
    private float f1563o = 0.0f;

    /* renamed from: p */
    private float f1564p = 0.0f;

    /* renamed from: q */
    private float f1565q = 0.0f;

    /* renamed from: r */
    private float f1566r = 1.0f;

    public C0734q() {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 singleStepOffset;\nuniform highp vec4 params;\nuniform highp float brightness;\nuniform lowp float skip;\n\nconst highp vec3 W = vec3(0.299, 0.587, 0.114);\nconst highp mat3 saturateMatrix = mat3(\n    1.1102, -0.0598, -0.061,\n    -0.0774, 1.0826, -0.1186,\n    -0.0228, -0.0228, 1.1772);\nhighp vec2 blurCoordinates[12];\n\n\nvoid main(){\n    highp vec4 tmpTexture = texture2D(inputImageTexture, textureCoordinate);\n    highp vec3 centralColor = tmpTexture.rgb;\n    if (skip == 0.0) {\n        blurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -6.0);\n        blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 6.0);\n        blurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(6.0, 0.0);\n        blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(-6.0, 0.0);\n        blurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n        blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n        blurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n        blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n        blurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, -2.0);\n        blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, 2.0);\n        blurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(2.0, -2.0);\n        blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(2.0, 2.0);\n\n        highp float sampleColor = centralColor.g * 22.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[0]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[1]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[2]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[3]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[4]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[5]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[6]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[7]).g * 2.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[8]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[9]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[10]).g * 3.0;\n        sampleColor += texture2D(inputImageTexture, blurCoordinates[11]).g * 3.0;\n\n        sampleColor = sampleColor / 50.0;\n\n        highp float highPass = clamp(centralColor.g - sampleColor + 0.5, 0.0, 1.0);\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n        highPass = mix(1.0 - (1.0 - highPass) * (1.0 - highPass) * 2.0, highPass * highPass * 2.0,                 step(highPass, 0.5));\n\n        highp float luminance = dot(centralColor, W);\n        highp float alpha = pow(luminance, params.r);\n\n        highp vec3 smoothColor = centralColor + (centralColor-vec3(highPass)) * alpha * 0.1;\n        gl_FragColor.rgb = mix(centralColor.rgb, smoothColor, params.g);\n\n        gl_FragColor.rgb = mix(gl_FragColor.rgb * (brightness + 1.0),                 gl_FragColor.rgb * saturateMatrix, params.b);\n        gl_FragColor.a = tmpTexture.a;\n    } else {\n        gl_FragColor.rgb = centralColor.rgb;\n        gl_FragColor.a = tmpTexture.a;\n    }\n}\n");
    }

    /* renamed from: a */
    private void m1874a(float f, float f2) {
        mo9991a(this.f1560l, new float[]{2.0f / f, 2.0f / f2});
    }

    /* renamed from: b */
    private void m1875b(float f, float f2) {
        mo9998b(this.f1559a, new float[]{1.0f - (0.6f * f), f, f2, f2});
    }

    /* renamed from: m */
    private void m1876m() {
        if (this.f1563o == 0.0f && this.f1564p == 0.0f && this.f1565q == 0.0f) {
            this.f1566r = 1.0f;
        } else {
            this.f1566r = 0.0f;
        }
        mo9989a(this.f1562n, this.f1566r);
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1559a = GLES20.glGetUniformLocation(mo10012j(), "params");
        this.f1560l = GLES20.glGetUniformLocation(mo10012j(), "singleStepOffset");
        this.f1561m = GLES20.glGetUniformLocation(mo10012j(), "brightness");
        this.f1562n = GLES20.glGetUniformLocation(mo10012j(), "skip");
        mo10048b(this.f1564p);
        m1875b(this.f1563o, this.f1565q);
    }

    /* renamed from: a */
    public void mo10047a(float f) {
        this.f1563o = Math.max(0.0f, Math.min(1.0f, f));
        m1876m();
        m1875b(this.f1563o, this.f1565q);
    }

    /* renamed from: a */
    public void mo9990a(int i, int i2) {
        super.mo9990a(i, i2);
        m1874a((float) i, (float) i2);
    }

    /* renamed from: b */
    public void mo10048b(float f) {
        this.f1564p = Math.max(0.0f, Math.min(1.0f, f));
        m1876m();
        mo9989a(this.f1561m, this.f1564p * 0.3f);
    }
}
