package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.wrapper.GLES20Wrapper;

/* renamed from: com.meizu.common.renderer.effect.b.c */
public class FishEyeRender extends ConvolutionRender {

    /* renamed from: d */
    private int f4429d;

    /* renamed from: e */
    private int f4430e;

    /* renamed from: b */
    public String mo15945b() {
        return "precision highp float; \nuniform sampler2D sTexture; \nuniform float uAlpha;\nvarying vec2 vTexCoord; \nuniform vec2 uStep; \nuniform float uInvMaxDist; \nuniform float uF; \nvec3 fisheye() { \n    const float slope = 20.0;               // vignette slope  \n    const float shade = 0.85;               // vignette shading  \n    const float range = 0.6;               // 0.6 - 1.3 \n    const float zoom = 0.3;               // smaller zoom means bigger image \n    vec2 coord = (vTexCoord - 0.5) / uStep; // convert to world coordinate  \n    float dist = length(coord); // distance to the center \n    float lumen = shade / (1.0 + exp((dist * uInvMaxDist - range) * slope)) + (1.0 - shade); \n    float t = zoom*dist/uF; \n    float theta = asin(t)*2.0; \n    float r = uF * tan(theta); \n    float angle = atan(coord.y, coord.x); \n    vec2 newCoord = vec2(cos(angle), sin(angle))*uStep*r+0.5; \n    return texture2D(sTexture, newCoord).rgb;  \n   // return texture2D(sTexture, newCoord).rgb * lumen; \n} \nvoid main() { \n    gl_FragColor.rgb = fisheye(); \n    gl_FragColor.a = texture2D(sTexture,vTexCoord).a*uAlpha; \n}";
    }

    public FishEyeRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__fisheye";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15944a() {
        super.mo15944a();
        this.f4429d = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uF");
        this.f4430e = GLES20Wrapper.glGetUniformLocation(this.f4443i, "uInvMaxDist");
    }
}
