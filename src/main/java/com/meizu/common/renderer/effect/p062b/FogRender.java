package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;

/* renamed from: com.meizu.common.renderer.effect.b.d */
public class FogRender extends PixelsRender {
    /* renamed from: b */
    public String mo15945b() {
        return "precision mediump float; \nuniform sampler2D sTexture; \nuniform float uAlpha;\nvarying vec2 vTexCoord; \nvoid main() \n{ \n    vec4 color = texture2D(sTexture, vTexCoord).rgba; \n    vec3 fog = mix(vec3(0.5, 0.8, 0.5), color.rgb, 0.7); \n    gl_FragColor = vec4(fog, color.a*uAlpha); \n} \n";
    }

    public FogRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__fog";
    }
}
