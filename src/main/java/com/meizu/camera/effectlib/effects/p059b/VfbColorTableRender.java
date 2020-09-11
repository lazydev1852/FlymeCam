package com.meizu.camera.effectlib.effects.p059b;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.camera.effectlib.effects.b.g */
public class VfbColorTableRender extends ColorTableRender {

    /* renamed from: l */
    public static ChangeQuickRedirect f3555l;

    /* renamed from: f */
    public String mo14051f() {
        return "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform sampler2D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  vec4 color = texture2D(tex_sampler, v_texcoord);\n  color.r = clamp(color.r, 0.0, 0.996);\n  color.g = clamp(color.g, 0.0, 0.996);\n  color.b = clamp(color.b, 0.0, 0.996);\n  int r_val = int(color.r * 63.0);\n  int g_val = int(color.g * 63.0) + 1;\n  g_val = g_val < 0 ? 0 : g_val > 62 ? 62 : g_val;\n  int offset = r_val * 64 + g_val;\n  float u_off = color.b;\n  float v_off = float(offset) / 4096.0;\n  gl_FragColor= texture2D(lut_tab, vec2(u_off, v_off));\n  gl_FragColor.a= alphaValue;\n}\n";
    }

    /* renamed from: g */
    public String mo14052g() {
        return "#extension GL_OES_texture_3D : enable\nprecision mediump float;\nuniform sampler2D tex_sampler;\nuniform mediump sampler3D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  vec4 s = texture2D(tex_sampler, v_texcoord);\n   s.r = clamp(s.r, 0.0, 0.996);\n   s.g = clamp(s.g, 0.0, 0.996);\n   s.b = clamp(s.b, 0.0, 0.996);\n  gl_FragColor = texture3D(lut_tab, vec3(s.b, s.g, s.r));\n  gl_FragColor.a= alphaValue;\n}\n";
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f3555l, false, 189, new Class[0], Void.TYPE).isSupported) {
            super.mo14048d();
        }
    }
}
