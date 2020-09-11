package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.b */
public class C0706b extends C0712g {

    /* renamed from: a */
    protected float[] f1474a;

    /* renamed from: l */
    private float f1475l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f1476m;

    /* renamed from: n */
    private int f1477n;

    public C0706b() {
        this(1.0f, (float[]) C0749a.f1635a.clone());
    }

    public C0706b(float f, float[] fArr) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp mat4 colorMatrix;\nuniform lowp float intensity;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 outputColor = textureColor * colorMatrix;\n    \n    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);\n}");
        this.f1475l = f;
        this.f1474a = fArr;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1476m = GLES20.glGetUniformLocation(mo10012j(), "colorMatrix");
        this.f1477n = GLES20.glGetUniformLocation(mo10012j(), "intensity");
    }

    /* renamed from: a */
    public void mo9983a(float f) {
        this.f1475l = f;
        mo9989a(this.f1477n, f);
    }

    /* renamed from: a */
    public void mo9984a(final float[] fArr) {
        this.f1474a = fArr;
        mo9992a((Runnable) new Runnable() {
            public void run() {
                C0706b.this.mo10002c(C0706b.this.f1476m, fArr);
            }
        });
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo9983a(this.f1475l);
        mo9984a(this.f1474a);
    }
}
