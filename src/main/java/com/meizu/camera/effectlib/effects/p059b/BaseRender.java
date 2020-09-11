package com.meizu.camera.effectlib.effects.p059b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.camera.effectlib.effects.p058a.GLShaderProgram;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.meizu.camera.effectlib.effects.b.a */
public class BaseRender {

    /* renamed from: a */
    public static ChangeQuickRedirect f3486a;

    /* renamed from: b */
    protected Context f3487b;

    /* renamed from: c */
    protected String f3488c;

    /* renamed from: d */
    protected GLShaderProgram f3489d = null;

    /* renamed from: e */
    protected String f3490e;

    /* renamed from: f */
    protected final float[] f3491f = new float[8];

    /* renamed from: g */
    protected final float[] f3492g = new float[8];

    /* renamed from: h */
    protected final float[] f3493h = new float[16];

    /* renamed from: i */
    protected final float[] f3494i = new float[16];

    /* renamed from: j */
    protected float f3495j = 1.0f;

    /* renamed from: k */
    private EffectRenderFactory.C1191c f3496k;

    /* renamed from: e */
    public String mo14050e() {
        return "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nuniform mat4 utexMatrix;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * a_position;\n  v_texcoord = (utexMatrix * vec4(a_texcoord, 0.0, 1.0)).st;\n}\n";
    }

    /* renamed from: f */
    public String mo14051f() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler;\nvarying vec2 v_texcoord;\nuniform float alphaValue;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler, v_texcoord);\n  gl_FragColor.a =alphaValue;\n}\n";
    }

    /* renamed from: a */
    public void mo14041a(EffectRenderFactory.C1191c cVar, Context context, String str, String str2) {
        if (!PatchProxy.proxy(new Object[]{cVar, context, str, str2}, this, f3486a, false, 130, new Class[]{EffectRenderFactory.C1191c.class, Context.class, String.class, String.class}, Void.TYPE).isSupported) {
            mo14044b();
            this.f3496k = cVar;
            this.f3487b = context;
            this.f3490e = str;
            this.f3488c = str2;
        }
    }

    /* renamed from: a */
    public void mo14038a() {
        if (!PatchProxy.proxy(new Object[0], this, f3486a, false, 131, new Class[0], Void.TYPE).isSupported && this.f3489d == null) {
            this.f3489d = new GLShaderProgram(mo14050e(), mo14051f());
        }
    }

    /* renamed from: a */
    public void mo14043a(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3486a, false, 132, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3491f, 0, this.f3491f.length);
        }
    }

    /* renamed from: b */
    public void mo14045b(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3486a, false, 133, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3492g, 0, this.f3492g.length);
        }
    }

    /* renamed from: c */
    public void mo14047c(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3486a, false, 134, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3493h, 0, this.f3493h.length);
        }
    }

    /* renamed from: d */
    public void mo14049d(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3486a, false, 135, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3494i, 0, this.f3494i.length);
        }
    }

    /* renamed from: b */
    public void mo14044b() {
        if (!PatchProxy.proxy(new Object[0], this, f3486a, false, 136, new Class[0], Void.TYPE).isSupported) {
            Matrix.setIdentityM(this.f3493h, 0);
            Matrix.setIdentityM(this.f3494i, 0);
        }
    }

    /* renamed from: a */
    public void mo14042a(String str, Object obj) {
        Class[] clsArr = {String.class, Object.class};
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, f3486a, false, 137, clsArr, Void.TYPE).isSupported && TextUtils.equals(str, "alpha")) {
            float floatValue = ((Float) obj).floatValue();
            if (floatValue < 0.0f) {
                floatValue = 0.0f;
            } else if (floatValue > 1.0f) {
                floatValue = 1.0f;
            }
            this.f3495j = floatValue;
        }
    }

    /* renamed from: a */
    public void mo14039a(GLShaderProgram bVar, GLTexture cVar, int i, int i2, int i3, int i4) {
        Object[] objArr = {bVar, cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f3486a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 138, new Class[]{GLShaderProgram.class, GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            bVar.mo14019a("alphaValue", this.f3495j);
        }
    }

    /* renamed from: a */
    public void mo14040a(GLTexture cVar, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{cVar, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3486a, false, 139, new Class[]{GLTexture.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            mo14038a();
            if (this.f3489d != null && this.f3489d.mo14022a()) {
                this.f3489d.mo14018a(i, i2, i3, i4);
                this.f3489d.mo14020a("tex_sampler", 0, cVar.mo14028a(), cVar.mo14029b());
                this.f3489d.mo14021a(this.f3491f);
                this.f3489d.mo14024b(this.f3492g);
                this.f3489d.mo14026c(this.f3493h);
                this.f3489d.mo14027d(this.f3494i);
                mo14039a(this.f3489d, cVar, i, i2, i3, i4);
                this.f3489d.mo14023b();
            }
        }
    }

    /* renamed from: c */
    public EffectRenderFactory.C1191c mo14046c() {
        return this.f3496k;
    }

    /* renamed from: d */
    public void mo14048d() {
        if (!PatchProxy.proxy(new Object[0], this, f3486a, false, 140, new Class[0], Void.TYPE).isSupported && this.f3489d != null) {
            this.f3489d.mo14025c();
            this.f3489d = null;
        }
    }

    /* renamed from: a */
    public Bitmap mo14037a(Context context, String str) throws Exception {
        InputStream inputStream;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, f3486a, false, 141, new Class[]{Context.class, String.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        String str2 = "/system/media/" + str;
        Log.i("BaseRender", "readZipFile systemFilePath :" + str2);
        Bitmap bitmap = null;
        if (new File(str2).exists()) {
            fileInputStream = new FileInputStream(str2);
            inputStream = new BufferedInputStream(fileInputStream);
            zipInputStream = new ZipInputStream(inputStream);
            Log.i("BaseRender", "readZipFile from system");
        } else {
            inputStream = context.getAssets().open(str);
            zipInputStream = new ZipInputStream(inputStream);
            fileInputStream = null;
        }
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            Log.i("BaseRender", "readZipFile: " + name);
            if (nextEntry.isDirectory()) {
                String substring = name.substring(0, name.length() - 1);
                substring.substring(substring.lastIndexOf("/") + 1);
            } else {
                nextEntry.getSize();
                if (!name.contains("MACOSX") && (name.endsWith(".png") || name.endsWith(".jpg"))) {
                    Log.i("BaseRender", "decodeStream: " + name);
                    bitmap = BitmapFactory.decodeStream(zipInputStream);
                }
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        inputStream.close();
        zipInputStream.close();
        return bitmap;
    }
}
