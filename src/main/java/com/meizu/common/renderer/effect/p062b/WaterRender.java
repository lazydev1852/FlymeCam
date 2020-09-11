package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;

/* renamed from: com.meizu.common.renderer.effect.b.q */
public class WaterRender extends ConvolutionRender {
    /* renamed from: b */
    public String mo15945b() {
        return "precision mediump float;   \nvarying vec2 vTexCoord;   \nuniform float uAlpha;\nuniform sampler2D sTexture; \nuniform vec2 uStep; \nvec2 water() {  \n  float s1 = (uStep.x < uStep.y) ? 0.01 : 0.01 * uStep.x / uStep.y; \n  float t1 = (uStep.x < uStep.y) ? 0.01 * uStep.y / uStep.x : 0.01;    \n  float s2 = (uStep.x < uStep.y) ? 30.0 : 30.0 * uStep.x / uStep.y; \n  float t2 = (uStep.x < uStep.y) ? 30.0 * uStep.y / uStep.x : 30.0;   \n  float s = sin(s2*vTexCoord.t) * s1; \n  float t = sin(t2*vTexCoord.s) * t1;\n  return vec2(s,t);} \nvoid main()  \n{   \n    gl_FragColor = texture2D(sTexture, vTexCoord + water()); \n    gl_FragColor.a *= uAlpha;\n}";
    }

    public WaterRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__water";
    }
}
