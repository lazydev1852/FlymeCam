package com.baidu.p020ar.blend.p036a;

import android.os.HandlerThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.baidu.ar.blend.a.b */
public class C0639b extends HandlerThread {

    /* renamed from: f */
    private static final int[] f1202f = {12339, 1, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};

    /* renamed from: g */
    private static final int[] f1203g = {12375, 1, 12374, 1, 12344};

    /* renamed from: h */
    private static final int[] f1204h = {12440, 2, 12344};

    /* renamed from: a */
    private EGLContext f1205a;

    /* renamed from: b */
    private EGL10 f1206b;

    /* renamed from: c */
    private EGLContext f1207c = null;

    /* renamed from: d */
    private EGLDisplay f1208d = null;

    /* renamed from: e */
    private EGLSurface f1209e = null;

    public C0639b(String str) {
        super(str);
    }

    /* renamed from: d */
    private void m1442d() {
        this.f1206b = (EGL10) EGLContext.getEGL();
        this.f1208d = this.f1206b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f1208d != EGL10.EGL_NO_DISPLAY) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.f1206b.eglInitialize(this.f1208d, new int[2]);
            this.f1206b.eglChooseConfig(this.f1208d, f1202f, eGLConfigArr, 1, new int[1]);
            this.f1207c = this.f1206b.eglCreateContext(this.f1208d, eGLConfigArr[0], this.f1205a, f1204h);
            this.f1209e = this.f1206b.eglCreatePbufferSurface(this.f1208d, eGLConfigArr[0], f1203g);
            this.f1206b.eglMakeCurrent(this.f1208d, this.f1209e, this.f1209e, this.f1207c);
            return;
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    /* renamed from: a */
    public EGLContext mo9763a() {
        return this.f1205a;
    }

    /* renamed from: a */
    public void mo9764a(EGLContext eGLContext, EGLConfig eGLConfig) {
        this.f1205a = eGLContext;
    }

    /* renamed from: b */
    public void mo9765b() {
        this.f1206b.eglMakeCurrent(this.f1208d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        if (this.f1207c != null) {
            this.f1206b.eglDestroyContext(this.f1208d, this.f1207c);
            this.f1207c = null;
        }
        if (this.f1209e != null) {
            this.f1206b.eglDestroySurface(this.f1208d, this.f1209e);
            this.f1209e = null;
        }
        if (this.f1208d != null) {
            this.f1206b.eglTerminate(this.f1208d);
            this.f1208d = null;
        }
    }

    /* renamed from: c */
    public boolean mo9766c() {
        return this.f1206b.eglSwapBuffers(this.f1208d, this.f1209e);
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        setName("GLResThread" + getThreadId());
        try {
            m1442d();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        super.run();
        mo9765b();
    }
}
