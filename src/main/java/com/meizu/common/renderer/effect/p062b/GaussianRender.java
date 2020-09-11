package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.wrapper.GLES20Wrapper;

/* renamed from: com.meizu.common.renderer.effect.b.e */
public class GaussianRender extends ConvolutionRender {

    /* renamed from: d */
    protected int f4431d;

    /* renamed from: e */
    protected int f4432e;

    /* renamed from: f */
    protected int f4433f;

    /* renamed from: p */
    private int f4434p;

    /* renamed from: q */
    private float f4435q;

    /* renamed from: b */
    public String mo15945b() {
        return "precision mediump float; \nuniform vec2 uStep; \nuniform sampler2D sTexture; \nvarying vec2 vTexCoord; \nuniform int uVertical; \nuniform int uRadius; \nuniform float uWeight; \nvec4 gassian(vec2 step) { \n    if (uRadius == 0) return texture2D(sTexture, vTexCoord); \n    vec3 sum; \n    float j=0.0;  \n    for (int i=0; i<=uRadius; ++i) {  \n        if (i == 0) { \n           sum = texture2D(sTexture, vTexCoord).rgb * uWeight; \n        } else {  \n           sum += texture2D(sTexture,uVertical==1 ? vec2(vTexCoord.x,vTexCoord.y-j*step.y) : vec2(vTexCoord.x-j*step.x,vTexCoord.y)).rgb * uWeight;\n           sum += texture2D(sTexture,uVertical==1 ? vec2(vTexCoord.x,vTexCoord.y+j*step.y) : vec2(vTexCoord.x+j*step.x,vTexCoord.y)).rgb * uWeight;\n        }\n        j += 1.0;\n    }\n    return vec4(sum, 1.0); \n} \nvec4 gassian2(vec2 step) { \n    vec3 sum; \n\t float a[6]; \n    a[0] = 0.001; a[1] = 0.01; a[2] = 0.044; a[3] = 0.116; a[4] = 0.205; a[5] = 0.246; \n    //a[0] = 0.0355; a[1] = 0.0585; a[2] = 0.0863; a[3] = 0.1139; a[4] = 0.1346; a[5] = 0.1423; \n    //a[0] = 0.0549; a[1] = 0.0727; a[2] = 0.0905; a[3] = 0.1058; a[4] = 0.1162; a[5] = 0.1199; \n    sum  = texture2D(sTexture, vTexCoord - 5.0 * step).rgb * a[0]; \n    sum += texture2D(sTexture, vTexCoord - 4.0 * step).rgb * a[1]; \n    sum += texture2D(sTexture, vTexCoord - 3.0 * step).rgb * a[2]; \n    sum += texture2D(sTexture, vTexCoord - 2.0 * step).rgb * a[3]; \n    sum += texture2D(sTexture, vTexCoord - step).rgb * a[4]; \n    sum += texture2D(sTexture, vTexCoord).rgb * a[5]; \n    sum += texture2D(sTexture, vTexCoord + step).rgb * a[4]; \n    sum += texture2D(sTexture, vTexCoord + 2.0 * step).rgb * a[3]; \n    sum += texture2D(sTexture, vTexCoord + 3.0 * step).rgb * a[2]; \n    sum += texture2D(sTexture, vTexCoord + 4.0 * step).rgb * a[1]; \n    sum += texture2D(sTexture, vTexCoord + 5.0 * step).rgb * a[0]; \n    return vec4(sum, 1.0); \n} \nvoid main() { \n    if (uRadius <= 100) { \n        gl_FragColor = gassian(uStep); \n    } else { \n        gl_FragColor = gassian2(uStep);\n    } \n} \n";
    }

    /* renamed from: a */
    public static GaussianRender m5052a(GLCanvas dVar) {
        Render a = dVar.mo15955a("__gaussian");
        if (a == null) {
            a = new GaussianRender(dVar);
            dVar.mo15957a(a);
        }
        return (GaussianRender) a;
    }

    public GaussianRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__gaussian";
        this.f4427b = 1.0f;
        this.f4428c = 1.0f;
        mo15946a(4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15944a() {
        super.mo15944a();
        this.f4433f = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uVertical");
        this.f4431d = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uRadius");
        this.f4432e = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uWeight");
    }

    /* renamed from: a */
    public void mo15946a(int i) {
        this.f4434p = i;
        this.f4435q = 1.0f / ((float) ((i * 2) + 1));
    }
}
