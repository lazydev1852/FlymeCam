package com.meizu.camera.effectlib.effects.filters;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.camera.effectlib.effects.filters.b */
public class SurfaceManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f3650a;

    /* renamed from: b */
    private EGLContext f3651b;

    /* renamed from: c */
    private EGLContext f3652c;

    /* renamed from: d */
    private EGLSurface f3653d;

    /* renamed from: e */
    private EGLDisplay f3654e;

    /* renamed from: f */
    private EGLConfig[] f3655f;

    /* renamed from: g */
    private int[] f3656g;

    /* renamed from: h */
    private EGLDisplay f3657h;

    /* renamed from: i */
    private EGLSurface f3658i;

    /* renamed from: j */
    private EGLSurface f3659j;

    /* renamed from: k */
    private EGLContext f3660k;

    /* renamed from: l */
    private boolean f3661l;

    public SurfaceManager() {
        this.f3651b = null;
        this.f3652c = null;
        this.f3653d = null;
        this.f3654e = null;
        this.f3655f = new EGLConfig[1];
        this.f3657h = null;
        this.f3658i = null;
        this.f3659j = null;
        this.f3660k = null;
        this.f3661l = true;
        this.f3652c = EGL14.eglGetCurrentContext();
        Log.d("SurfaceManager", "eglsetup");
        m4228d();
    }

    public SurfaceManager(boolean z) {
        this.f3651b = null;
        this.f3652c = null;
        this.f3653d = null;
        this.f3654e = null;
        this.f3655f = new EGLConfig[1];
        this.f3657h = null;
        this.f3658i = null;
        this.f3659j = null;
        this.f3660k = null;
        this.f3661l = true;
        this.f3661l = z;
        if (!this.f3661l) {
            Log.d("SurfaceManager", "eglsetup");
            m4228d();
        }
    }

    /* renamed from: a */
    public void mo14093a(EGLContext eGLContext) {
        if (!PatchProxy.proxy(new Object[]{eGLContext}, this, f3650a, false, 61, new Class[]{EGLContext.class}, Void.TYPE).isSupported) {
            this.f3652c = eGLContext;
            m4228d();
        }
    }

    /* renamed from: a */
    public void mo14095a(SurfaceHolder surfaceHolder) {
        if (!PatchProxy.proxy(new Object[]{surfaceHolder}, this, f3650a, false, 62, new Class[]{SurfaceHolder.class}, Void.TYPE).isSupported) {
            Log.d("SurfaceManager", "makeCurrent: " + surfaceHolder);
            if (this.f3653d != null) {
                EGL14.eglDestroySurface(this.f3654e, this.f3653d);
            }
            this.f3653d = EGL14.eglCreateWindowSurface(this.f3654e, this.f3655f[0], surfaceHolder, this.f3656g, 0);
            m4227a("eglCreateWindowSurface");
            if (!EGL14.eglMakeCurrent(this.f3654e, this.f3653d, this.f3653d, this.f3651b)) {
                throw new IllegalStateException("eglMakeCurrent failed");
            }
        }
    }

    /* renamed from: a */
    public void mo14094a(Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f3650a, false, 63, new Class[]{Surface.class}, Void.TYPE).isSupported) {
            Log.d("SurfaceManager", "makeCurrent: " + surface);
            if (this.f3653d != null) {
                EGL14.eglDestroySurface(this.f3654e, this.f3653d);
            }
            this.f3653d = EGL14.eglCreateWindowSurface(this.f3654e, this.f3655f[0], surface, this.f3656g, 0);
            m4227a("eglCreateWindowSurface");
            Log.v("SurfaceManager", String.format("EglSurface:size(%d,%d)", new Object[]{Integer.valueOf(mo14091a(this.f3653d, 12375)), Integer.valueOf(mo14091a(this.f3653d, 12374))}));
            if (!EGL14.eglMakeCurrent(this.f3654e, this.f3653d, this.f3653d, this.f3651b)) {
                throw new IllegalStateException("eglMakeCurrent failed");
            }
        }
    }

    /* renamed from: a */
    public void mo14092a() {
        if (!PatchProxy.proxy(new Object[0], this, f3650a, false, 65, new Class[0], Void.TYPE).isSupported) {
            if (this.f3653d != null) {
                EGL14.eglDestroySurface(this.f3654e, this.f3653d);
            }
            this.f3653d = EGL14.eglCreatePbufferSurface(this.f3654e, this.f3655f[0], this.f3656g, 0);
            if (!EGL14.eglMakeCurrent(this.f3654e, this.f3653d, this.f3653d, this.f3651b)) {
                throw new IllegalStateException("eglMakeCurrent failed");
            }
        }
    }

    /* renamed from: b */
    public void mo14096b() {
        if (!PatchProxy.proxy(new Object[0], this, f3650a, false, 66, new Class[0], Void.TYPE).isSupported) {
            EGL14.eglSwapBuffers(this.f3654e, this.f3653d);
        }
    }

    /* renamed from: a */
    public int mo14091a(EGLSurface eGLSurface, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eGLSurface, new Integer(i)}, this, f3650a, false, 67, new Class[]{EGLSurface.class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f3654e, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    /* renamed from: d */
    private void m4228d() {
        if (!PatchProxy.proxy(new Object[0], this, f3650a, false, 69, new Class[0], Void.TYPE).isSupported) {
            this.f3654e = EGL14.eglGetDisplay(0);
            if (this.f3654e != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.f3654e, iArr, 0, iArr, 1)) {
                    EGL14.eglChooseConfig(this.f3654e, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, this.f3655f, 0, this.f3655f.length, new int[1], 0);
                    m4227a("eglCreateContext RGB888+recordable ES2");
                    int[] iArr2 = {12440, 2, 12344};
                    if (this.f3661l) {
                        this.f3651b = EGL14.eglCreateContext(this.f3654e, this.f3655f[0], this.f3652c, iArr2, 0);
                    } else {
                        this.f3651b = EGL14.eglCreateContext(this.f3654e, this.f3655f[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
                    }
                    this.f3656g = new int[]{12344};
                    m4227a("eglCreateContext");
                    return;
                }
                Log.d("SurfaceManager", "unable to initialize EGL14");
                throw new IllegalStateException("unable to initialize EGL14");
            }
            Log.d("SurfaceManager", "unable to get EGL14 display");
            throw new IllegalStateException("unable to get EGL14 display");
        }
    }

    /* renamed from: c */
    public void mo14097c() {
        if (!PatchProxy.proxy(new Object[0], this, f3650a, false, 71, new Class[0], Void.TYPE).isSupported) {
            if (this.f3654e != EGL14.EGL_NO_DISPLAY) {
                EGL14.eglMakeCurrent(this.f3654e, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                if (this.f3653d != null) {
                    EGL14.eglDestroySurface(this.f3654e, this.f3653d);
                    this.f3653d = EGL14.EGL_NO_SURFACE;
                }
                EGL14.eglDestroyContext(this.f3654e, this.f3651b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.f3654e);
            }
            this.f3654e = EGL14.EGL_NO_DISPLAY;
            this.f3651b = EGL14.EGL_NO_CONTEXT;
        }
    }

    /* renamed from: a */
    private void m4227a(String str) {
        int eglGetError;
        if (!PatchProxy.proxy(new Object[]{str}, this, f3650a, false, 72, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
            Log.d("SurfaceManager", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
