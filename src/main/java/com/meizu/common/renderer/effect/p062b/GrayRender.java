package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;

/* renamed from: com.meizu.common.renderer.effect.b.f */
public class GrayRender extends PixelsRender {
    /* renamed from: b */
    public String mo15945b() {
        return "precision mediump float; \nuniform sampler2D sTexture; \nuniform float uAlpha;\nvarying vec2 vTexCoord; \nvoid main() { \n    float alpha = texture2D(sTexture, vTexCoord).a*uAlpha; \n    vec3 factor = vec3(0.299, 0.587, 0.114); \n    vec3 color = texture2D(sTexture, vTexCoord).rgb; \n    float gray = 0.0; \n    gray = dot(color,factor); \n    color = vec3(gray, gray, gray); \n    gl_FragColor = vec4(color, alpha); \n}";
    }

    public GrayRender(GLCanvas dVar) {
        super(dVar);
        this.f4441h = "__gray";
    }
}
