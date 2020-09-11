package com.baidu.p020ar.blend.gpuimage.p039a;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import com.baidu.p020ar.blend.gpuimage.graphics.Drawable2d;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* renamed from: com.baidu.ar.blend.gpuimage.a.g */
public class C0712g {

    /* renamed from: a */
    private final LinkedList<Runnable> f1484a;

    /* renamed from: b */
    protected final Drawable2d f1485b;

    /* renamed from: c */
    protected boolean f1486c;

    /* renamed from: d */
    protected int f1487d;

    /* renamed from: e */
    protected int f1488e;

    /* renamed from: f */
    protected int f1489f;

    /* renamed from: g */
    protected float[] f1490g;

    /* renamed from: h */
    protected float[] f1491h;

    /* renamed from: i */
    protected int f1492i;

    /* renamed from: j */
    protected int f1493j;

    /* renamed from: k */
    protected FloatBuffer f1494k;

    /* renamed from: l */
    private String f1495l;

    /* renamed from: m */
    private String f1496m;

    /* renamed from: n */
    private int f1497n;

    /* renamed from: o */
    private int f1498o;

    /* renamed from: p */
    private int f1499p;

    /* renamed from: q */
    private int f1500q;

    public C0712g() {
        this("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}");
    }

    public C0712g(String str, String str2) {
        this.f1485b = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.f1495l = null;
        this.f1496m = null;
        this.f1490g = null;
        this.f1491h = null;
        this.f1484a = new LinkedList<>();
        this.f1489f = 3553;
        this.f1495l = TextUtils.isEmpty(str) ? "uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}" : str;
        if (!TextUtils.isEmpty(str2)) {
            this.f1496m = str2;
        } else {
            this.f1496m = "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}";
        }
        this.f1494k = this.f1485b.mo10070b();
    }

    /* renamed from: m */
    private void mo10030m() {
        synchronized (this.f1484a) {
            while (!this.f1484a.isEmpty()) {
                this.f1484a.removeFirst().run();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9980a() {
        this.f1497n = C0749a.m1937a(this.f1495l, this.f1496m);
        if (this.f1497n != 0) {
            this.f1498o = GLES20.glGetAttribLocation(this.f1497n, "position");
            C0749a.m1945b(this.f1498o, "position");
            this.f1499p = GLES20.glGetAttribLocation(this.f1497n, "inputTextureCoordinate");
            C0749a.m1945b(this.f1499p, "inputTextureCoordinate");
            this.f1487d = GLES20.glGetUniformLocation(this.f1497n, "uMVPMatrix");
            C0749a.m1941a("getting location of uMVPMatrix");
            this.f1488e = GLES20.glGetUniformLocation(this.f1497n, "uTexMatrix");
            C0749a.m1941a("getting location of uTexMatrix");
            this.f1500q = GLES20.glGetUniformLocation(this.f1497n, "inputImageTexture");
            C0749a.m1945b(this.f1500q, "inputImageTexture");
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    /* renamed from: a */
    public void mo9988a(int i) {
        mo9997b(i, 0);
    }

    /* renamed from: a */
    public void mo9989a(final int i, final float f) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform1f(i, f);
            }
        });
    }

    /* renamed from: a */
    public void mo9990a(int i, int i2) {
        this.f1492i = i;
        this.f1493j = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9991a(final int i, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9992a(Runnable runnable) {
        synchronized (this.f1484a) {
            this.f1484a.addLast(runnable);
        }
    }

    /* renamed from: a */
    public void mo9993a(final String str, final float f) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform1f(glGetUniformLocation, f);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9994a(final String str, final int i) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform1i(glGetUniformLocation, i);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9995a(final String str, final PointF pointF) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                float[] fArr = {pointF.x, pointF.y};
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform2fv(glGetUniformLocation, 1, fArr, 0);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9996a(final String str, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform3fv(glGetUniformLocation, 1, FloatBuffer.wrap(fArr));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9982b() {
        this.f1492i = 0;
        this.f1493j = 0;
    }

    /* renamed from: b */
    public void mo9997b(int i, int i2) {
        if (this.f1490g == null) {
            this.f1490g = (float[]) C0749a.f1635a.clone();
        }
        if (this.f1491h == null) {
            this.f1491h = (float[]) C0749a.f1635a.clone();
        }
        C0749a.m1941a("draw start");
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, this.f1492i, this.f1493j);
        GLES20.glUseProgram(this.f1497n);
        C0749a.m1941a("glUseProgram");
        mo10030m();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f1489f, i);
        GLES20.glUniform1i(this.f1500q, 0);
        if (this.f1487d >= 0) {
            GLES20.glUniformMatrix4fv(this.f1487d, 1, false, this.f1490g, 0);
            C0749a.m1941a("glUniformMatrix4fv for mMvpMatrix");
        }
        if (this.f1488e >= 0) {
            GLES20.glUniformMatrix4fv(this.f1488e, 1, false, this.f1491h, 0);
            C0749a.m1941a("glUniformMatrix4fv for mTexMatrix");
        }
        GLES20.glEnableVertexAttribArray(this.f1498o);
        C0749a.m1941a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1498o, 2, 5126, false, 0, this.f1485b.mo10069a());
        C0749a.m1941a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f1499p);
        C0749a.m1941a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1499p, 2, 5126, false, 0, this.f1494k);
        C0749a.m1941a("glVertexAttribPointer");
        mo10008f();
        GLES20.glDrawArrays(5, 0, 4);
        C0749a.m1941a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f1498o);
        GLES20.glDisableVertexAttribArray(this.f1499p);
        GLES20.glBindTexture(this.f1489f, 0);
        GLES20.glUseProgram(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9998b(final int i, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* renamed from: b */
    public void mo9999b(final String str, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform4fv(glGetUniformLocation, 1, FloatBuffer.wrap(fArr));
                }
            }
        });
    }

    /* renamed from: b */
    public void mo10000b(float[] fArr) {
        this.f1490g = fArr;
    }

    /* renamed from: c */
    public final void mo10001c() {
        if (!this.f1486c) {
            mo9980a();
            this.f1486c = true;
            mo9982b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10002c(final int i, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    /* renamed from: c */
    public void mo10003c(final String str, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniformMatrix3fv(glGetUniformLocation, 1, false, fArr, 0);
                }
            }
        });
    }

    /* renamed from: c */
    public void mo10004c(float[] fArr) {
        this.f1491h = fArr;
    }

    /* renamed from: d */
    public void mo10005d() {
        Log.d("GlUtil", "deleting program " + this.f1497n);
        GLES20.glDeleteProgram(this.f1497n);
        this.f1486c = false;
        this.f1497n = -1;
        mo10007e();
    }

    /* renamed from: d */
    public void mo10006d(final String str, final float[] fArr) {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(C0712g.this.mo10012j(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr, 0);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo10007e() {
        this.f1492i = 0;
        this.f1493j = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo10008f() {
    }

    /* renamed from: g */
    public boolean mo10009g() {
        return this.f1486c;
    }

    /* renamed from: h */
    public int mo10010h() {
        return this.f1492i;
    }

    /* renamed from: i */
    public int mo10011i() {
        return this.f1493j;
    }

    /* renamed from: j */
    public int mo10012j() {
        return this.f1497n;
    }

    /* renamed from: k */
    public int mo10013k() {
        return this.f1498o;
    }

    /* renamed from: l */
    public int mo10014l() {
        return this.f1499p;
    }
}
