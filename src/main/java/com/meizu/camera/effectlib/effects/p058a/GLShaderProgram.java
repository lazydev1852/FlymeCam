package com.meizu.camera.effectlib.effects.p058a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.meizu.camera.effectlib.effects.a.b */
public class GLShaderProgram {

    /* renamed from: a */
    public static ChangeQuickRedirect f3463a;

    /* renamed from: b */
    public static final float[] f3464b = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: c */
    public static final float[] f3465c = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: d */
    protected int f3466d;

    /* renamed from: e */
    protected int f3467e;

    /* renamed from: f */
    protected int f3468f;

    /* renamed from: g */
    protected int f3469g;

    /* renamed from: h */
    protected int f3470h;

    /* renamed from: i */
    protected FloatBuffer f3471i;

    /* renamed from: j */
    protected FloatBuffer f3472j;

    /* renamed from: k */
    protected boolean f3473k = false;

    /* renamed from: l */
    private final float[] f3474l = new float[16];

    /* renamed from: m */
    private final float[] f3475m = new float[16];

    public GLShaderProgram(String str, String str2) {
        this.f3466d = m4021a(str, str2);
        if (this.f3466d != 0) {
            this.f3467e = GLES20.glGetAttribLocation(this.f3466d, "a_position");
            GLES20Utils.m4017a("glGetAttribLocation a_position");
            this.f3468f = GLES20.glGetAttribLocation(this.f3466d, "a_texcoord");
            GLES20Utils.m4017a("glGetAttribLocation a_texcoord");
            this.f3469g = GLES20.glGetUniformLocation(this.f3466d, "uMVPMatrix");
            GLES20Utils.m4017a("glGetUniformLocation uMVPMatrix");
            this.f3470h = GLES20.glGetUniformLocation(this.f3466d, "utexMatrix");
            GLES20Utils.m4017a("glGetAttribLocation utexMatrix");
        }
        Matrix.setIdentityM(this.f3474l, 0);
        Matrix.setIdentityM(this.f3475m, 0);
    }

    /* renamed from: a */
    public void mo14021a(float[] fArr) {
        if (PatchProxy.proxy(new Object[]{fArr}, this, f3463a, false, 95, new Class[]{float[].class}, Void.TYPE).isSupported || fArr == null) {
            return;
        }
        if (this.f3471i == null) {
            this.f3471i = m4022a(fArr, 4);
        } else {
            this.f3471i.put(fArr).position(0);
        }
    }

    /* renamed from: b */
    public void mo14024b(float[] fArr) {
        if (PatchProxy.proxy(new Object[]{fArr}, this, f3463a, false, 96, new Class[]{float[].class}, Void.TYPE).isSupported || fArr == null) {
            return;
        }
        if (this.f3472j == null) {
            this.f3472j = m4022a(fArr, 4);
        } else {
            this.f3472j.put(fArr).position(0);
        }
    }

    /* renamed from: a */
    public void mo14018a(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f3463a, false, 97, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f3466d != 0 && this.f3473k) {
            GLES20.glViewport(i, i2, i3, i4);
            GLES20Utils.m4017a("glViewport");
        }
    }

    /* renamed from: a */
    public void mo14020a(String str, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i), new Integer(i2), new Integer(i3)}, this, f3463a, false, 98, new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f3466d != 0 && this.f3473k) {
            GLES20.glActiveTexture(33984 + i);
            GLES20Utils.m4017a("glActiveTexture");
            GLES20.glBindTexture(i3, i2);
            GLES20Utils.m4017a("glBindTexture");
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3466d, str), i);
            GLES20Utils.m4017a("setRenderTarget");
        }
    }

    /* renamed from: a */
    public void mo14019a(String str, float f) {
        if (!PatchProxy.proxy(new Object[]{str, new Float(f)}, this, f3463a, false, 99, new Class[]{String.class, Float.TYPE}, Void.TYPE).isSupported && this.f3466d != 0 && str != null && str != "") {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3466d, str), f);
        }
    }

    /* renamed from: c */
    public void mo14026c(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3463a, false, 105, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3474l, 0, this.f3474l.length);
        }
    }

    /* renamed from: d */
    public void mo14027d(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f3463a, false, 106, new Class[]{float[].class}, Void.TYPE).isSupported && fArr != null) {
            System.arraycopy(fArr, 0, this.f3475m, 0, this.f3475m.length);
        }
    }

    /* renamed from: a */
    public boolean mo14022a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3463a, false, 107, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        GLES20Utils.m4017a("beginScene");
        if (this.f3466d != 0) {
            GLES20.glUseProgram(this.f3466d);
            GLES20Utils.m4017a("glUseProgram");
            this.f3473k = true;
        }
        return this.f3473k;
    }

    /* renamed from: b */
    public void mo14023b() {
        if (!PatchProxy.proxy(new Object[0], this, f3463a, false, 108, new Class[0], Void.TYPE).isSupported && this.f3473k) {
            if (this.f3471i == null) {
                this.f3471i = m4022a(f3464b, 4);
            }
            if (this.f3472j == null) {
                this.f3472j = m4022a(f3465c, 4);
            }
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.f3468f, 2, 5126, false, 0, this.f3472j);
            GLES20.glEnableVertexAttribArray(this.f3468f);
            GLES20.glVertexAttribPointer(this.f3467e, 2, 5126, false, 0, this.f3471i);
            GLES20.glEnableVertexAttribArray(this.f3467e);
            GLES20Utils.m4017a("vertex attribute setup");
            GLES20.glUniformMatrix4fv(this.f3469g, 1, false, this.f3474l, 0);
            GLES20.glUniformMatrix4fv(this.f3470h, 1, false, this.f3475m, 0);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20Utils.m4017a("glDrawArrays");
            this.f3473k = false;
        }
    }

    /* renamed from: c */
    public void mo14025c() {
        if (!PatchProxy.proxy(new Object[0], this, f3463a, false, 109, new Class[0], Void.TYPE).isSupported && this.f3466d != 0) {
            GLES20.glDeleteProgram(this.f3466d);
            GLES20Utils.m4017a("glDeleteProgram");
            this.f3466d = 0;
        }
    }

    /* renamed from: a */
    public static int m4020a(int i, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, (Object) null, f3463a, true, 110, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new IllegalStateException("Could not compile shader " + i + SystemInfoUtil.COLON + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    /* renamed from: a */
    public static int m4021a(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f3463a, true, 111, new Class[]{String.class, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int a = m4020a(35633, str);
        int a2 = m4020a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20Utils.m4017a("glCreateProgram");
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a);
            GLES20Utils.m4017a("glAttachShader vertexShaderHandle");
            GLES20.glAttachShader(glCreateProgram, a2);
            GLES20Utils.m4017a("glAttachShader fragmentShaderHandle");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 1) {
                GLES20.glDeleteShader(a);
                GLES20Utils.m4017a("glDeleteShader vertexShaderHandle");
                GLES20.glDeleteShader(a2);
                GLES20Utils.m4017a("glDeleteShader fragmentShaderHandle");
            } else {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new IllegalStateException("Could not link program: " + glGetProgramInfoLog);
            }
        }
        return glCreateProgram;
    }

    /* renamed from: a */
    public static FloatBuffer m4022a(float[] fArr, int i) {
        Object[] objArr = {fArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3463a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 112, new Class[]{float[].class, Integer.TYPE}, FloatBuffer.class);
        if (proxy.isSupported) {
            return (FloatBuffer) proxy.result;
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * i).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }
}
