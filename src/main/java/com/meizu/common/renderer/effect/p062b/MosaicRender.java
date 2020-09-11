package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;

/* renamed from: com.meizu.common.renderer.effect.b.g */
public class MosaicRender extends ConvolutionRender {
    /* renamed from: b */
    public String mo15945b() {
        return "precision highp float; \nuniform sampler2D sTexture; \nuniform float uAlpha;\nuniform vec2 uStep; \nvarying vec2 vTexCoord; \nvec3 mosaic() { \n    vec2 step = uStep; \n    vec2 st0 = (step.x < step.y) ? \n                vec2(0.02, 0.02 * step.y/step.x) : \n                vec2(0.02*step.x/step.y, 0.02); \n    vec2 st = floor(vTexCoord/st0) * st0; \n    vec2 st1 = st + st0*0.5; \n    return 0.25 * (texture2D(sTexture, st).rgb + \n             texture2D(sTexture, st1).rgb + \n             texture2D(sTexture, vec2(st.s,st1.t)).rgb + \n             texture2D(sTexture, vec2(st1.s,st.t)).rgb); \n} \nvoid main() \n{             \n  gl_FragColor.rgb = mosaic(); \n  gl_FragColor.a = uAlpha;\n}";
    }

    public MosaicRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__mosaic";
    }
}
