package com.baidu.p020ar.recorder.filter;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import com.arcsoft.livebroadcast.ArcSpotlightOffscreen;
import com.baidu.p020ar.recorder.p047e.C0859d;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.recorder.filter.b */
public class C0868b extends C0867a implements C0869c {

    /* renamed from: b */
    private static final String f2164b = "b";

    /* renamed from: a */
    protected int f2165a;

    /* renamed from: c */
    private int f2166c;

    /* renamed from: d */
    private int f2167d;

    /* renamed from: e */
    private int f2168e;

    /* renamed from: f */
    private int f2169f;

    /* renamed from: g */
    private int f2170g;

    public C0868b(Context context) {
        this.f2165a = mo10544a(context);
        if (this.f2165a != 0) {
            mo10545a();
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo10544a(Context context) {
        return C0859d.m2465a("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float; //指定默认精度\n\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo10545a() {
        this.f2170g = GLES20.glGetUniformLocation(this.f2165a, "uTexture");
        this.f2166c = GLES20.glGetAttribLocation(this.f2165a, "aPosition");
        this.f2167d = GLES20.glGetUniformLocation(this.f2165a, "uMVPMatrix");
        this.f2168e = GLES20.glGetUniformLocation(this.f2165a, "uTexMatrix");
        this.f2169f = GLES20.glGetAttribLocation(this.f2165a, "aTextureCoord");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10546a(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(mo10554f(), i);
        GLES20.glUniform1i(this.f2170g, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10547a(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        if (z2) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(ArcSpotlightOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        }
        GLES20.glDrawArrays(5, i, i2);
        if (z2) {
            GLES20.glDisable(3042);
        }
    }

    /* renamed from: a */
    public void mo10553a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, boolean z, boolean z2) {
        C0859d.m2467a("draw start");
        mo10549b();
        mo10546a(i5);
        mo10548a(fArr, floatBuffer, i3, i4, fArr2, floatBuffer2, i6);
        int i7 = i;
        int i8 = i2;
        mo10547a(i, i2, z, z2);
        mo10550c();
        mo10551d();
        mo10552e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10548a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, float[] fArr2, FloatBuffer floatBuffer2, int i3) {
        GLES20.glUniformMatrix4fv(this.f2167d, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.f2168e, 1, false, fArr2, 0);
        GLES20.glEnableVertexAttribArray(this.f2166c);
        GLES20.glVertexAttribPointer(this.f2166c, i, 5126, false, i2, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f2169f);
        GLES20.glVertexAttribPointer(this.f2169f, 2, 5126, false, i3, floatBuffer2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10549b() {
        GLES20.glUseProgram(this.f2165a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10550c() {
        GLES20.glDisableVertexAttribArray(this.f2166c);
        GLES20.glDisableVertexAttribArray(this.f2169f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10551d() {
        GLES20.glBindTexture(mo10554f(), 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo10552e() {
        GLES20.glUseProgram(0);
        GLES20.glFinish();
    }

    /* renamed from: f */
    public int mo10554f() {
        return 36197;
    }

    /* renamed from: g */
    public void mo10555g() {
        Log.d(f2164b, "releaseProgram");
        GLES20.glDeleteProgram(this.f2165a);
        this.f2165a = -1;
    }
}
