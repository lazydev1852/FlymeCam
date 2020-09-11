package com.meizu.camera.effectlib.effects.p059b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.camera.effectlib.effects.p058a.GLShaderProgram;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p058a.GLTexture3D;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.camera.effectlib.utils.C1198Utils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0014J8\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo27294d2 = {"Lcom/meizu/camera/effectlib/effects/renders/LutRender;", "Lcom/meizu/camera/effectlib/effects/renders/BaseRender;", "()V", "mLut3DTexture", "Lcom/meizu/camera/effectlib/effects/gles/GLTexture3D;", "mLutFilePath", "", "getFragmentShader", "release", "", "setParameters", "key", "obj", "", "setupGraphics", "updateParameters", "program", "Lcom/meizu/camera/effectlib/effects/gles/GLShaderProgram;", "texture", "Lcom/meizu/camera/effectlib/effects/gles/GLTexture;", "x", "", "y", "width", "height", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.camera.effectlib.effects.b.d */
public class LutRender extends BaseRender {

    /* renamed from: k */
    public static ChangeQuickRedirect f3502k;

    /* renamed from: l */
    private GLTexture3D f3503l;

    /* renamed from: m */
    private String f3504m = "null";

    @NotNull
    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\n#extension GL_OES_texture_3D : enable\nprecision mediump float;\nuniform samplerExternalOES tex_sampler;\nuniform mediump sampler3D lut_tab;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nuniform bool b_IsCube;\nvoid main() {\nfloat r, g, b;\n  vec4 color = texture2D(tex_sampler, v_texcoord);\nr = clamp(color.r, 0.0, 0.996);\ng = clamp(color.g, 0.0, 0.996);\nb = clamp(color.b, 0.0, 0.996);\n vec4 temprgb = texture3D(lut_tab, vec3(r, g, b));\ntemprgb.r = clamp(temprgb.r, 0.0, 1.0);\ntemprgb.g = clamp(temprgb.g, 0.0, 1.0);\ntemprgb.b= clamp(temprgb.b, 0.0, 1.0);\ngl_FragColor =temprgb;\n}\n";
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f3502k, false, 155, new Class[0], Void.TYPE).isSupported) {
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
    public void mo14042a(@NotNull String str, @NotNull Object obj) {
        Class[] clsArr = {String.class, Object.class};
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, f3502k, false, 156, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "key");
            C3443i.m21155b(obj, "obj");
            super.mo14042a(str, obj);
        }
    }

    /* renamed from: a */
    public void mo14039a(@NotNull GLShaderProgram bVar, @NotNull GLTexture cVar, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        GLShaderProgram bVar2 = bVar;
        GLTexture cVar2 = cVar;
        if (!PatchProxy.proxy(new Object[]{bVar2, cVar2, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3502k, false, 157, new Class[]{GLShaderProgram.class, GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar2, "program");
            C3443i.m21155b(cVar2, "texture");
            super.mo14039a(bVar, cVar, i, i2, i3, i4);
            EffectRenderContext h = EffectRenderContext.m4369h();
            EffectRenderFactory.C1191c c = mo14046c();
            C3443i.m21152a((Object) c, "type");
            this.f3503l = h.mo14204d(c.mo14343b());
            if (this.f3503l != null) {
                GLTexture3D dVar = this.f3503l;
                if (dVar == null) {
                    C3443i.m21151a();
                }
                int a = dVar.mo14033a();
                GLTexture3D dVar2 = this.f3503l;
                if (dVar2 == null) {
                    C3443i.m21151a();
                }
                bVar2.mo14020a("lut_tab", 1, a, dVar2.mo14034b());
                return;
            }
            new BitmapFactory.Options().inScaled = false;
            Bitmap bitmap2 = null;
            try {
                EffectRenderFactory.C1191c c2 = mo14046c();
                C3443i.m21152a((Object) c2, "type");
                bitmap = C1198Utils.m4821a(c2.mo14343b(), false, this.f3487b);
            } catch (Exception e) {
                e.printStackTrace();
                bitmap = bitmap2;
            }
            if (bitmap != null) {
                this.f3503l = GLTexture3D.m4042a(bitmap.getWidth(), bitmap.getWidth(), bitmap.getWidth(), bitmap);
                EffectRenderContext effectRenderContext = EffectRenderContext.f3778b;
                EffectRenderFactory.C1191c c3 = mo14046c();
                C3443i.m21152a((Object) c3, "type");
                effectRenderContext.mo14183a(c3.mo14343b(), this.f3503l);
                bitmap.recycle();
                EffectRenderFactory.C1191c c4 = mo14046c();
                C3443i.m21152a((Object) c4, "type");
                String b = c4.mo14343b();
                C3443i.m21152a((Object) b, "type.resourcePath");
                this.f3504m = b;
            }
            if (this.f3503l != null) {
                GLTexture3D dVar3 = this.f3503l;
                if (dVar3 == null) {
                    C3443i.m21151a();
                }
                int a2 = dVar3.mo14033a();
                GLTexture3D dVar4 = this.f3503l;
                if (dVar4 == null) {
                    C3443i.m21151a();
                }
                bVar2.mo14020a("lut_tab", 1, a2, dVar4.mo14034b());
            }
        }
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f3502k, false, Opcodes.IFLE, new Class[0], Void.TYPE).isSupported) {
            super.mo14048d();
        }
    }
}
