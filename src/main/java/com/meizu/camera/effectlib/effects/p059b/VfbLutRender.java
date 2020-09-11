package com.meizu.camera.effectlib.effects.p059b;

/* renamed from: com.meizu.camera.effectlib.effects.b.h */
public class VfbLutRender extends LutRender {
    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\n#extension GL_OES_texture_3D : enable\nprecision mediump float;\nuniform sampler2D tex_sampler;\nuniform mediump sampler3D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nuniform bool b_IsCube;\nvoid main() {\nfloat r, g, b;\n  vec4 color = texture2D(tex_sampler, v_texcoord);\nr = clamp(color.r, 0.0, 0.996);\ng = clamp(color.g, 0.0, 0.996);\nb = clamp(color.b, 0.0, 0.996);\n vec4 temprgb = texture3D(lut_tab, vec3(r, g, b));\ntemprgb.r = clamp(temprgb.r, 0.0, 1.0);\ntemprgb.g = clamp(temprgb.g, 0.0, 1.0);\ntemprgb.b= clamp(temprgb.b, 0.0, 1.0);\ngl_FragColor =temprgb;\n}\n";
    }
}
