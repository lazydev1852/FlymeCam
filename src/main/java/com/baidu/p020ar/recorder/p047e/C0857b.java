package com.baidu.p020ar.recorder.p047e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* renamed from: com.baidu.ar.recorder.e.b */
public final class C0857b {

    /* renamed from: a */
    private static final String f2123a = "b";

    /* renamed from: b */
    private EGLDisplay f2124b;

    /* renamed from: c */
    private EGLContext f2125c;

    /* renamed from: d */
    private EGLConfig f2126d;

    /* renamed from: e */
    private int f2127e;

    public C0857b() {
        this((EGLContext) null, 0);
    }

    public C0857b(EGLContext eGLContext, int i) {
        this.f2124b = EGL14.EGL_NO_DISPLAY;
        this.f2125c = EGL14.EGL_NO_CONTEXT;
        this.f2126d = null;
        this.f2127e = -1;
        if (this.f2124b == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            this.f2124b = EGL14.eglGetDisplay(0);
            if (this.f2124b != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.f2124b, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0) {
                        Log.d(f2123a, "Trying GLES 3");
                        EGLConfig a = m2450a(i, 3);
                        if (a != null) {
                            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f2124b, a, eGLContext, new int[]{12440, 3, 12344}, 0);
                            if (EGL14.eglGetError() == 12288) {
                                this.f2126d = a;
                                this.f2125c = eglCreateContext;
                                this.f2127e = 3;
                            }
                        }
                    }
                    if (this.f2125c == EGL14.EGL_NO_CONTEXT) {
                        Log.d(f2123a, "Trying GLES 2");
                        EGLConfig a2 = m2450a(i, 2);
                        if (a2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f2124b, a2, eGLContext, new int[]{12440, 2, 12344}, 0);
                            m2451a("eglCreateContext");
                            this.f2126d = a2;
                            this.f2125c = eglCreateContext2;
                            this.f2127e = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f2124b, this.f2125c, 12440, iArr2, 0);
                    String str = f2123a;
                    Log.d(str, "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f2124b = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    /* renamed from: a */
    private EGLConfig m2450a(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f2124b, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        String str = f2123a;
        Log.w(str, "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    /* renamed from: a */
    private void m2451a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    /* renamed from: a */
    public EGLSurface mo10515a(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f2124b, this.f2126d, obj, new int[]{12344}, 0);
            m2451a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + obj);
    }

    /* renamed from: a */
    public void mo10516a() {
        if (this.f2124b != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f2124b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f2124b, this.f2125c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f2124b);
        }
        this.f2124b = EGL14.EGL_NO_DISPLAY;
        this.f2125c = EGL14.EGL_NO_CONTEXT;
        this.f2126d = null;
    }

    /* renamed from: a */
    public void mo10517a(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f2124b, eGLSurface);
    }

    /* renamed from: a */
    public void mo10518a(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f2124b, eGLSurface, j);
    }

    /* renamed from: b */
    public void mo10519b(EGLSurface eGLSurface) {
        if (this.f2124b == EGL14.EGL_NO_DISPLAY) {
            Log.d(f2123a, "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f2124b, eGLSurface, eGLSurface, this.f2125c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: c */
    public boolean mo10520c(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f2124b, eGLSurface);
    }

    /* renamed from: d */
    public boolean mo10521d(EGLSurface eGLSurface) {
        return this.f2125c.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.f2124b != EGL14.EGL_NO_DISPLAY) {
                Log.w(f2123a, "WARNING: EglCore was not explicitly released -- state may be leaked");
                mo10516a();
            }
        } finally {
            super.finalize();
        }
    }
}
