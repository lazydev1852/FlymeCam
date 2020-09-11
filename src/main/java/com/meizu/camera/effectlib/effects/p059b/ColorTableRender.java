package com.meizu.camera.effectlib.effects.p059b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.meizu.camera.effectlib.effects.p058a.GLShaderProgram;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p058a.GLTexture3D;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.camera.effectlib.effects.b.b */
public class ColorTableRender extends BaseRender {

    /* renamed from: k */
    public static ChangeQuickRedirect f3497k;

    /* renamed from: l */
    private GLTexture f3498l;

    /* renamed from: m */
    private GLTexture3D f3499m;

    /* renamed from: n */
    private boolean f3500n = false;

    /* renamed from: o */
    private String f3501o = "null";

    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler;\nuniform sampler2D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  vec4 color = texture2D(tex_sampler, v_texcoord);\ncolor.r = clamp(color.r, 0.0, 0.996);\ncolor.g = clamp(color.g, 0.0, 0.996);\ncolor.b = clamp(color.b, 0.0, 0.996);\n  int r_val = int(color.r * 63.0);\n  int g_val = int(color.g * 63.0) + 1;\n  g_val = g_val < 0 ? 0 : g_val > 62 ? 62 : g_val;\n  int offset = r_val * 64 + g_val;\n  float u_off = color.b;\n  float v_off = float(offset) / 4096.0;\n  gl_FragColor= texture2D(lut_tab, vec2(u_off, v_off));\n  gl_FragColor.a= alphaValue;\n}\n";
    }

    /* renamed from: g */
    public String mo14052g() {
        return "#extension GL_OES_EGL_image_external : require\n#extension GL_OES_texture_3D : enable\nprecision mediump float;\nuniform samplerExternalOES tex_sampler;\nuniform mediump sampler3D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  vec4 s = texture2D(tex_sampler, v_texcoord);\n   s.r = clamp(s.r, 0.0, 0.996);\n   s.g = clamp(s.g, 0.0, 0.996);\n   s.b = clamp(s.b, 0.0, 0.996);\n  gl_FragColor = texture3D(lut_tab, vec3(s.b, s.g, s.r));\n  gl_FragColor.a= alphaValue;\n}\n";
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f3497k, false, 142, new Class[0], Void.TYPE).isSupported) {
            if (this.f3498l == null && this.f3499m == null) {
                this.f3500n = GLES20.glGetString(7939).contains("GL_OES_texture_3D");
            }
            try {
                if (this.f3489d == null) {
                    this.f3489d = new GLShaderProgram(mo14050e(), !this.f3500n ? mo14051f() : mo14052g());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo14042a(String str, Object obj) {
        Class[] clsArr = {String.class, Object.class};
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, f3497k, false, 143, clsArr, Void.TYPE).isSupported) {
            super.mo14042a(str, obj);
        }
    }

    /* renamed from: a */
    public void mo14039a(GLShaderProgram bVar, GLTexture cVar, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        Bitmap bitmap2;
        GLShaderProgram bVar2 = bVar;
        if (!PatchProxy.proxy(new Object[]{bVar2, cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3497k, false, 144, new Class[]{GLShaderProgram.class, GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo14039a(bVar, cVar, i, i2, i3, i4);
            if (this.f3500n) {
                if (this.f3499m == null || !mo14046c().mo14343b().equals(this.f3501o)) {
                    if (this.f3499m != null) {
                        this.f3499m.mo14036c();
                    }
                    new BitmapFactory.Options().inScaled = false;
                    try {
                        bitmap2 = mo14037a(this.f3487b, mo14046c().mo14343b());
                    } catch (Exception e) {
                        e.printStackTrace();
                        bitmap2 = null;
                    }
                    if (bitmap2 != null) {
                        this.f3499m = GLTexture3D.m4042a(64, 64, 64, bitmap2);
                        bitmap2.recycle();
                        this.f3501o = mo14046c().mo14343b();
                    }
                }
                bVar2.mo14020a("lut_tab", 1, this.f3499m.mo14033a(), this.f3499m.mo14034b());
                return;
            }
            if (this.f3498l == null || !mo14046c().mo14343b().equals(this.f3501o)) {
                new BitmapFactory.Options().inScaled = false;
                try {
                    bitmap = mo14037a(this.f3487b, mo14046c().mo14343b());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.f3498l = GLTexture.m4034a(bitmap, 64, 4096);
                    bitmap.recycle();
                    this.f3501o = mo14046c().mo14343b();
                }
            }
            bVar2.mo14020a("lut_tab", 1, this.f3498l.mo14028a(), this.f3498l.mo14029b());
        }
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f3497k, false, 145, new Class[0], Void.TYPE).isSupported) {
            super.mo14048d();
            if (this.f3498l != null) {
                this.f3498l.mo14032c();
                this.f3498l = null;
            }
            if (this.f3499m != null) {
                this.f3499m.mo14036c();
                this.f3499m = null;
            }
        }
    }
}
