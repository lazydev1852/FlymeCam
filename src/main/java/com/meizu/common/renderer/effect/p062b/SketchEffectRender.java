package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.DrawInfo;
import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.p061a.DrawTextureOp;

/* renamed from: com.meizu.common.renderer.effect.b.n */
public class SketchEffectRender extends RenderGroup {

    /* renamed from: b */
    private C1329b f4450b;

    /* renamed from: c */
    private C1328a f4451c;

    /* renamed from: d */
    private DrawTextureOp f4452d = new DrawTextureOp();

    /* renamed from: e */
    private DrawInfo f4453e = new DrawInfo();

    public SketchEffectRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__sketch";
        this.f4450b = new C1329b(dVar);
        this.f4451c = new C1328a(dVar);
        this.f4442a.add(this.f4451c);
        this.f4442a.add(this.f4450b);
    }

    /* renamed from: com.meizu.common.renderer.effect.b.n$b */
    /* compiled from: SketchEffectRender */
    private static class C1329b extends ConvolutionRender {
        /* renamed from: b */
        public String mo15945b() {
            return "precision mediump float; \nuniform vec2 uStep; \nuniform float uAlpha;\nuniform sampler2D sTexture; \nvarying vec2 vTexCoord; \nfloat rgb2gray(vec4 color) { \n    return dot(color, vec4(0.299, 0.587, 0.114, 0.0)); \n} \nvoid main() \n{ \n    vec4 bigStep = vec4(uStep, uStep); \n    float sample = 0.0; \n    sample  = 0.0448 * rgb2gray(texture2D(sTexture, vTexCoord - bigStep.pq)); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord - bigStep.sq)); \n    sample += 0.0564 * rgb2gray(texture2D(sTexture, vTexCoord - vec2(0.0, bigStep.q))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.s, -bigStep.q))); \n    sample += 0.0448 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.p, -bigStep.q))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord - bigStep.pt)); \n    sample += 0.3167 * rgb2gray(texture2D(sTexture, vTexCoord - bigStep.st)); \n    sample += 0.7146 * rgb2gray(texture2D(sTexture, vTexCoord - vec2(0.0, bigStep.t))); \n    sample += 0.3167 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.s, -bigStep.t))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.p, -bigStep.t))); \n    sample += 0.0564 * rgb2gray(texture2D(sTexture, vTexCoord - vec2(bigStep.p, 0.0))); \n    sample += 0.7146 * rgb2gray(texture2D(sTexture, vTexCoord - vec2(bigStep.s, 0.0))); \n    sample -= 4.9048 * rgb2gray(texture2D(sTexture, vTexCoord)); \n    sample += 0.7146 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.s, 0.0))); \n    sample += 0.0564 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(bigStep.p, 0.0))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(-bigStep.p, bigStep.t))); \n    sample += 0.3167 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(-bigStep.s, bigStep.t))); \n    sample += 0.7146 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(0.0, bigStep.t))); \n    sample += 0.3167 * rgb2gray(texture2D(sTexture, vTexCoord + bigStep.st)); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + bigStep.pt)); \n    sample += 0.0448 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(-bigStep.p, bigStep.q))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(-bigStep.s, bigStep.q))); \n    sample += 0.0564 * rgb2gray(texture2D(sTexture, vTexCoord + vec2(0.0, bigStep.q))); \n    sample += 0.0468 * rgb2gray(texture2D(sTexture, vTexCoord + bigStep.sq)); \n    sample += 0.0448 * rgb2gray(texture2D(sTexture, vTexCoord + bigStep.pq)); \n    sample = 1.0 - 3.0 * sample; \n    sample = clamp(sample, 0.0, 1.0); \n    gl_FragColor.rgb = vec3(sample); \n    gl_FragColor.a = uAlpha; \n}";
        }

        public C1329b(GLCanvas dVar) {
            super(dVar);
        }
    }

    /* renamed from: com.meizu.common.renderer.effect.b.n$a */
    /* compiled from: SketchEffectRender */
    private static class C1328a extends ConvolutionRender {
        /* renamed from: b */
        public String mo15945b() {
            return "precision mediump float; \nuniform vec2 uStep; \nuniform sampler2D sTexture; \nvarying vec2 vTexCoord; \nvoid main() { \n    vec2 step = uStep; \n    vec3 a = vec3(0.0113,0.0838,0.6193); \n    vec3 sum; \n    sum = texture2D(sTexture,  vTexCoord - step).rgb * a.x; \n    sum += texture2D(sTexture, vTexCoord + vec2(0.0, -step.y)).rgb * a.y; \n    sum += texture2D(sTexture, vTexCoord + vec2(step.x, -step.y)).rgb * a.x; \n    sum += texture2D(sTexture, vTexCoord + vec2(step.x, 0.0)).rgb * a.y; \n    sum += texture2D(sTexture, vTexCoord).rgb * a.z; \n    sum += texture2D(sTexture, vTexCoord + vec2(-step.x, 0.0)).rgb * a.y; \n    sum += texture2D(sTexture, vTexCoord + vec2(-step.x, step.y)).rgb * a.x; \n    sum += texture2D(sTexture, vTexCoord + vec2(0.0, step.y)).rgb * a.y; \n    sum += texture2D(sTexture, vTexCoord + step).rgb * a.x; \n    gl_FragColor.rgb = sum; \n    gl_FragColor.a = 1.0; \n } ";
        }

        public C1328a(GLCanvas dVar) {
            super(dVar);
        }
    }
}
