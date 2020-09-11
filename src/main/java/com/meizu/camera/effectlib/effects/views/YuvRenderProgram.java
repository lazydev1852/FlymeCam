package com.meizu.camera.effectlib.effects.views;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.meizu.camera.effectlib.effects.views.d */
public class YuvRenderProgram {

    /* renamed from: a */
    public static ChangeQuickRedirect f4066a;

    /* renamed from: b */
    private FloatBuffer f4067b;

    /* renamed from: c */
    private FloatBuffer f4068c;

    /* renamed from: d */
    private ShortBuffer f4069d;

    /* renamed from: e */
    private int f4070e;

    /* renamed from: f */
    private int f4071f;

    /* renamed from: g */
    private int f4072g;

    /* renamed from: h */
    private int f4073h;

    /* renamed from: i */
    private int f4074i;

    /* renamed from: j */
    private boolean f4075j;

    /* renamed from: k */
    private final float[] f4076k;

    /* renamed from: l */
    private short[] f4077l;

    /* renamed from: m */
    private final float[] f4078m;

    /* renamed from: n */
    private final float[] f4079n;

    public YuvRenderProgram() {
        this.f4070e = -1;
        this.f4071f = -1;
        this.f4072g = -1;
        this.f4073h = -1;
        this.f4074i = -1;
        this.f4075j = false;
        this.f4076k = new float[]{1.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f};
        this.f4077l = new short[]{0, 1, 2, 2, 1, 3};
        this.f4078m = new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        this.f4079n = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.f4075j = false;
    }

    /* renamed from: a */
    public void mo14359a() {
        if (!PatchProxy.proxy(new Object[0], this, f4066a, false, 470, new Class[0], Void.TYPE).isSupported && !this.f4075j) {
            Log.i("YuvRenderProgram", "initProgram");
            this.f4070e = mo14358a(35633, "attribute vec4 aPosition;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main()\n{\n  vTextureCoord = aTextureCoordinate.xy;\n  gl_Position = uMVPMatrix * aPosition;\n}\n");
            this.f4071f = mo14358a(35632, "precision mediump float;\nuniform sampler2D textureY;\nuniform sampler2D textureUV;\nvarying vec2 vTextureCoord;\nvoid main() \n{\n  float r, g, b, y, u, v;\n  y = texture2D(textureY, vTextureCoord).r;\n  u = texture2D(textureUV, vTextureCoord).a - 0.5;\n  v = texture2D(textureUV, vTextureCoord).r - 0.5;\n  r = y + 1.370705*v;\n  g = y - 0.337633*u - 0.698001*v;\n  b = y + 1.732446*u;\n  r = clamp(r, 0.0, 1.0);\n  g = clamp(g, 0.0, 1.0);\n  b = clamp(b, 0.0, 1.0);\n  gl_FragColor = vec4(r, g, b, 1.0);\n}\n");
            this.f4072g = mo14357a(this.f4070e, this.f4071f);
            this.f4075j = true;
        }
    }

    /* renamed from: b */
    public void mo14362b() {
        if (!PatchProxy.proxy(new Object[0], this, f4066a, false, 471, new Class[0], Void.TYPE).isSupported) {
            this.f4067b = ByteBuffer.allocateDirect(this.f4078m.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f4067b.put(this.f4078m).position(0);
            this.f4068c = ByteBuffer.allocateDirect(this.f4079n.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f4068c.put(this.f4079n).position(0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f4077l.length * 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f4069d = allocateDirect.asShortBuffer();
            this.f4069d.put(this.f4077l);
            this.f4069d.position(0);
        }
    }

    /* renamed from: a */
    public int mo14358a(int i, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f4066a, false, 472, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            int[] iArr2 = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35716, iArr2, 0);
            if (iArr2[0] > 1) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                Log.e("YuvRenderProgram", "Error Compiling shader" + glGetShaderInfoLog);
            }
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        throw new IllegalStateException("Create Shader Failed!" + GLES20.glGetError());
    }

    /* renamed from: a */
    public int mo14357a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f4066a, false, 473, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i);
            GLES20.glAttachShader(glCreateProgram, i2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateProgram;
            }
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35716, iArr2, 0);
            if (iArr2[0] > 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                Log.e("YuvRenderProgram", "Error linking program: " + glGetProgramInfoLog);
            }
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        throw new IllegalStateException("Create Program Failed: " + GLES20.glGetError());
    }

    /* renamed from: c */
    public int mo14363c() {
        return this.f4072g;
    }

    /* renamed from: d */
    public FloatBuffer mo14364d() {
        return this.f4067b;
    }

    /* renamed from: e */
    public FloatBuffer mo14365e() {
        return this.f4068c;
    }

    /* renamed from: f */
    public ShortBuffer mo14366f() {
        return this.f4069d;
    }

    /* renamed from: g */
    public boolean mo14367g() {
        return this.f4075j;
    }

    /* renamed from: h */
    public void mo14368h() {
        if (!PatchProxy.proxy(new Object[0], this, f4066a, false, 474, new Class[0], Void.TYPE).isSupported) {
            Log.i("YuvRenderProgram", "release");
            this.f4067b.clear();
            this.f4069d.clear();
            this.f4068c.clear();
            this.f4067b = null;
            this.f4069d = null;
            this.f4068c = null;
            if (this.f4075j) {
                Log.i("YuvRenderProgram", "glDeleteProgram");
                GLES20.glDeleteProgram(this.f4072g);
                mo14361a("glDeleteProgram");
                this.f4075j = false;
            }
        }
    }

    /* renamed from: i */
    public int mo14369i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4066a, false, 475, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("YuvRenderProgram", "Create Texture failed!:" + glGetError);
        }
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    /* renamed from: a */
    public void mo14360a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f4066a, false, 476, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.e("YuvRenderProgram", "glDeleteTextures texture:" + i);
            if (i != -1) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                mo14361a("glDeleteTextures");
            }
        }
    }

    /* renamed from: a */
    public void mo14361a(String str) {
        int eglGetError;
        if (!PatchProxy.proxy(new Object[]{str}, this, f4066a, false, 477, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
            Log.d("CameraGLOnDraw", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
