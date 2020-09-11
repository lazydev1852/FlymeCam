package com.meizu.media.mzfunnysnapsdk.MZUtil;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class EGLer {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public static final int SURFACE_PBUFFER = 1;
    public static final int SURFACE_PIM = 2;
    public static final int SURFACE_WINDOW = 3;
    public static ChangeQuickRedirect changeQuickRedirect;
    private int alpha = 8;
    private int blue = 8;
    private int bufferType = 12421;
    private int depth = 16;
    private int green = 8;
    public EGL10 mEgl;
    public EGLConfig mEglConfig;
    public EGLContext mEglContext;
    public EGLDisplay mEglDisplay;
    public EGLSurface mEglSurface;
    public GL10 mGL;
    private int red = 8;
    private int renderType = 4;
    private EGLContext shareContext = EGL10.EGL_NO_CONTEXT;
    private int surfaceType = 1;
    private Object surface_native_obj;

    public void config(int i, int i2, int i3, int i4, int i5, int i6) {
        this.red = i;
        this.green = i2;
        this.blue = i3;
        this.alpha = i4;
        this.depth = i5;
        this.renderType = i6;
    }

    public void setSurfaceType(int i, Object... objArr) {
        this.surfaceType = i;
        if (objArr != null) {
            this.surface_native_obj = objArr[0];
        }
    }

    public GlError eglInit(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i3), new Integer(i4)}, this, changeQuickRedirect, false, 9191, new Class[]{Integer.TYPE, Integer.TYPE}, GlError.class);
        if (proxy.isSupported) {
            return (GlError) proxy.result;
        }
        int[] iArr = {12324, this.red, 12323, this.green, 12322, this.blue, 12321, this.alpha, 12325, this.depth, 12352, this.renderType, 12344};
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEgl.eglInitialize(this.mEglDisplay, new int[2]);
        int[] iArr2 = new int[1];
        int[] iArr3 = iArr2;
        this.mEgl.eglChooseConfig(this.mEglDisplay, iArr, (EGLConfig[]) null, 0, iArr2);
        if (iArr3[0] == 0) {
            return GlError.ConfigErr;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr3[0]];
        this.mEgl.eglChooseConfig(this.mEglDisplay, iArr, eGLConfigArr, iArr3[0], iArr3);
        this.mEglConfig = eGLConfigArr[0];
        this.mEglSurface = createSurface(new int[]{12375, i3, 12374, i4, 12344});
        this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfig, this.shareContext, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        makeCurrent();
        return GlError.OK;
    }

    public void makeCurrent() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9192, new Class[0], Void.TYPE).isSupported) {
            this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
            this.mGL = (GL10) this.mEglContext.getGL();
        }
    }

    public void destroy() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9193, new Class[0], Void.TYPE).isSupported) {
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            this.mEgl.eglTerminate(this.mEglDisplay);
        }
    }

    private EGLSurface createSurface(int[] iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{iArr}, this, changeQuickRedirect, false, 9194, new Class[]{int[].class}, EGLSurface.class);
        if (proxy.isSupported) {
            return (EGLSurface) proxy.result;
        }
        switch (this.surfaceType) {
            case 2:
                return this.mEgl.eglCreatePixmapSurface(this.mEglDisplay, this.mEglConfig, this.surface_native_obj, iArr);
            case 3:
                return this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.surface_native_obj, iArr);
            default:
                return this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, iArr);
        }
    }
}
