package com.meizu.camera.effectlib.effects.p059b;

/* renamed from: com.meizu.camera.effectlib.effects.b.c */
public class EffectBaseRender extends BaseRender {
    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler, v_texcoord);\n  gl_FragColor.a =alphaValue;\n}\n";
    }
}
