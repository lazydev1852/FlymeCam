package com.meizu.camera.effectlib.effects.p059b;

import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.camera.effectlib.effects.p058a.GLShaderProgram;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.camera.effectlib.effects.b.f */
public class SceneRender extends BaseRender {

    /* renamed from: k */
    public static ChangeQuickRedirect f3549k;

    /* renamed from: l */
    private float f3550l = 0.0f;

    /* renamed from: m */
    private float f3551m = 0.0f;

    /* renamed from: n */
    private float f3552n = 0.0f;

    /* renamed from: o */
    private float f3553o = 0.0f;

    /* renamed from: p */
    private float f3554p = 128.0f;

    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nuniform float u_brightness;\nuniform float u_saturation;\nuniform float u_temperature;\nuniform float u_contrast;\nuniform float u_threshold;\nvec4 calBrightnessContract(vec4 color,float brightness, float contrast,float threshold) {\n float cv = contrast <= -255.0 ? -1.0 : contrast / 255.0;\nif (contrast > 0.0 && contrast < 255.0) {\n\tcv = 1.0 / (1.0 - cv) - 1.0;\n}\nfloat r  = color.r + brightness / 255.0;\nfloat g = color.g + brightness / 255.0;\nfloat b = color.b + brightness / 255.0;\nif (contrast >= 255.0) {\nr = r >= threshold / 255.0 ? 1.0 : 0.0;\ng = g >= threshold / 255.0 ? 1.0 : 0.0;\nb = b >= threshold / 255.0 ? 1.0 : 0.0;\n} else {\nr =  r + (r - threshold / 255.0) * cv;\ng = g + (g - threshold / 255.0) * cv;\nb = b + (b - threshold / 255.0) * cv;\n}\ncolor.r = r;\ncolor.g = g;\ncolor.b = b;\nreturn color;\n}\nvec4 calNewSaturation(vec4 color,float saturation){\nfloat gray = dot(color.rgb, vec3(0.299,0.587,0.114));\nreturn vec4(gray + (saturation / 100.0 + 1.0) * (color.r - gray), gray + (saturation / 100.0 + 1.0) * (color.g - gray), gray + (saturation / 100.0 + 1.0) * (color.b - gray), color.a);\n}\nvec4 calColorTemperature(vec4 color, float scale){\nvec3 new_color = color.rgb;\nnew_color.r = color.r + color.r * ( 1.0 - color.r) * scale;\nnew_color.b = color.b - color.b * ( 1.0 - color.b) * scale;\nif (scale > 0.0) { \n\tnew_color.g = color.g + color.g * ( 1.0 - color.g) * scale * 0.25;\n}\nfloat max_value = max(new_color.r, max(new_color.g, new_color.b));\nif (max_value > 1.0) { \nnew_color /= max_value;\n}\nreturn vec4(new_color.rgb, color.a);\n}\nvoid main() {\n  vec4 color = texture2D(tex_sampler, v_texcoord);\n  vec4 color2 =calBrightnessContract(color,u_brightness,u_contrast,u_threshold);\n  vec4 color3 =calNewSaturation(color2,u_saturation);\n  vec4 color4 =calColorTemperature(color3,u_temperature);\n gl_FragColor =color4;\n}\n";
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f3549k, false, Opcodes.INVOKESPECIAL, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f3489d == null) {
                    this.f3489d = new GLShaderProgram(mo14050e(), mo14051f());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo14042a(String str, Object obj) {
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, f3549k, false, Opcodes.INVOKESTATIC, new Class[]{String.class, Object.class}, Void.TYPE).isSupported) {
            super.mo14042a(str, obj);
            float f = -255.0f;
            if ("u_brightness".equals(str)) {
                this.f3550l = ((Float) obj).floatValue();
                this.f3550l *= 255.0f;
                if (this.f3550l >= -255.0f) {
                    f = this.f3550l > 255.0f ? 255.0f : this.f3550l;
                }
                this.f3550l = f;
            } else if ("u_contrast".equals(str)) {
                this.f3552n = ((Float) obj).floatValue();
                this.f3552n *= 255.0f;
                if (this.f3552n >= -255.0f) {
                    f = this.f3552n > 255.0f ? 255.0f : this.f3552n;
                }
                this.f3552n = f;
            } else if ("u_saturation".equals(str)) {
                this.f3551m = ((Float) obj).floatValue();
                float f2 = 100.0f;
                this.f3551m *= 100.0f;
                if (this.f3551m < -100.0f) {
                    f2 = -100.0f;
                } else if (this.f3551m <= 100.0f) {
                    f2 = this.f3551m;
                }
                this.f3551m = f2;
            } else if ("u_temperature".equals(str)) {
                this.f3553o = ((Float) obj).floatValue();
                float f3 = -1.0f;
                if (this.f3553o >= -1.0f) {
                    f3 = this.f3553o > 1.0f ? 1.0f : this.f3553o;
                }
                this.f3553o = f3;
            } else if ("u_threshold".equals(str)) {
                this.f3554p = ((Float) obj).floatValue();
                if (this.f3554p >= -255.0f) {
                    f = this.f3554p > 255.0f ? 255.0f : this.f3554p;
                }
                this.f3554p = f;
            }
            Log.d("SceneRender", "setParameters: mBrightness " + this.f3550l + " mContrast " + this.f3552n + " mSaturation " + this.f3551m + " mTemperature " + this.f3553o + " mThreshold " + this.f3554p);
        }
    }

    /* renamed from: a */
    public void mo14039a(GLShaderProgram bVar, GLTexture cVar, int i, int i2, int i3, int i4) {
        GLShaderProgram bVar2 = bVar;
        Object[] objArr = {bVar2, cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f3549k;
        Class[] clsArr = {GLShaderProgram.class, GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE};
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, Opcodes.INVOKEINTERFACE, clsArr, Void.TYPE).isSupported) {
            super.mo14039a(bVar, cVar, i, i2, i3, i4);
            bVar2.mo14019a("u_brightness", this.f3550l);
            bVar2.mo14019a("u_saturation", this.f3551m);
            bVar2.mo14019a("u_contrast", this.f3552n);
            bVar2.mo14019a("u_temperature", this.f3553o);
            bVar2.mo14019a("u_threshold", this.f3554p);
        }
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f3549k, false, 186, new Class[0], Void.TYPE).isSupported) {
            super.mo14048d();
        }
    }
}
