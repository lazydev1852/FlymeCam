package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

@TargetApi(18)
public class EGLBase {
    private static final boolean DEBUG = false;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = "EGLBase";
    public static ChangeQuickRedirect changeQuickRedirect;
    private EGLContext mDefaultContext = EGL14.EGL_NO_CONTEXT;
    private EGLConfig mEglConfig = null;
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;

    public static class EglSurface {
        public static ChangeQuickRedirect changeQuickRedirect;
        private final EGLBase mEgl;
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private final int mHeight;
        private final int mWidth;

        EglSurface(EGLBase eGLBase, Object obj) {
            if ((obj instanceof SurfaceView) || (obj instanceof Surface) || (obj instanceof SurfaceHolder) || (obj instanceof SurfaceTexture)) {
                this.mEgl = eGLBase;
                this.mEglSurface = this.mEgl.createWindowSurface(obj);
                this.mWidth = this.mEgl.querySurface(this.mEglSurface, 12375);
                this.mHeight = this.mEgl.querySurface(this.mEglSurface, 12374);
                return;
            }
            throw new IllegalArgumentException("unsupported surface");
        }

        EglSurface(EGLBase eGLBase, int i, int i2) {
            this.mEgl = eGLBase;
            this.mEglSurface = this.mEgl.createOffscreenSurface(i, i2);
            this.mWidth = i;
            this.mHeight = i2;
        }

        public void makeCurrent() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9343, new Class[0], Void.TYPE).isSupported) {
                boolean unused = this.mEgl.makeCurrent(this.mEglSurface);
            }
        }

        public void swap() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9344, new Class[0], Void.TYPE).isSupported) {
                int unused = this.mEgl.swap(this.mEglSurface);
            }
        }

        public EGLContext getContext() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9345, new Class[0], EGLContext.class);
            return proxy.isSupported ? (EGLContext) proxy.result : this.mEgl.getContext();
        }

        public void release() {
            if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9346, new Class[0], Void.TYPE).isSupported) {
                this.mEgl.makeDefault();
                this.mEgl.destroyWindowSurface(this.mEglSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }

    public EGLBase(EGLContext eGLContext, boolean z, boolean z2) {
        init(eGLContext, z, z2);
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9328, new Class[0], Void.TYPE).isSupported) {
            if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) {
                destroyContext();
                EGL14.eglTerminate(this.mEglDisplay);
                EGL14.eglReleaseThread();
            }
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            this.mEglContext = EGL14.EGL_NO_CONTEXT;
        }
    }

    public EglSurface createFromSurface(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, changeQuickRedirect, false, 9329, new Class[]{Object.class}, EglSurface.class);
        if (proxy.isSupported) {
            return (EglSurface) proxy.result;
        }
        EglSurface eglSurface = new EglSurface(this, obj);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EglSurface createOffscreen(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9330, new Class[]{Integer.TYPE, Integer.TYPE}, EglSurface.class);
        if (proxy.isSupported) {
            return (EglSurface) proxy.result;
        }
        EglSurface eglSurface = new EglSurface(this, i, i2);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EGLContext getContext() {
        return this.mEglContext;
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eGLSurface, new Integer(i)}, this, changeQuickRedirect, false, 9331, new Class[]{EGLSurface.class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    private void init(EGLContext eGLContext, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{eGLContext, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, changeQuickRedirect, false, 9332, new Class[]{EGLContext.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY) {
                this.mEglDisplay = EGL14.eglGetDisplay(0);
                if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(this.mEglDisplay, iArr, 0, iArr, 1)) {
                        if (eGLContext == null) {
                            eGLContext = EGL14.EGL_NO_CONTEXT;
                        }
                        if (this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                            this.mEglConfig = getConfig(z, z2);
                            if (this.mEglConfig != null) {
                                this.mEglContext = createContext(eGLContext);
                            } else {
                                throw new RuntimeException("chooseConfig failed");
                            }
                        }
                        EGL14.eglQueryContext(this.mEglDisplay, this.mEglContext, 12440, new int[1], 0);
                        makeDefault();
                        return;
                    }
                    this.mEglDisplay = null;
                    throw new RuntimeException("eglInitialize failed");
                }
                throw new RuntimeException("eglGetDisplay failed");
            }
            throw new RuntimeException("EGL already set up");
        }
    }

    /* access modifiers changed from: private */
    public boolean makeCurrent(EGLSurface eGLSurface) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eGLSurface}, this, changeQuickRedirect, false, 9333, new Class[]{EGLSurface.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        EGLDisplay eGLDisplay = this.mEglDisplay;
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            if (EGL14.eglGetError() == 12299) {
                Log.e(TAG, "makeCurrent:returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
        } else if (EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            return true;
        } else {
            Log.w(TAG, "eglMakeCurrent:" + EGL14.eglGetError());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void makeDefault() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9334, new Class[0], Void.TYPE).isSupported && !EGL14.eglMakeCurrent(this.mEglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            Log.w("TAG", "makeDefault" + EGL14.eglGetError());
        }
    }

    /* access modifiers changed from: private */
    public int swap(EGLSurface eGLSurface) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eGLSurface}, this, changeQuickRedirect, false, 9335, new Class[]{EGLSurface.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!EGL14.eglSwapBuffers(this.mEglDisplay, eGLSurface)) {
            return EGL14.eglGetError();
        }
        return 12288;
    }

    private EGLContext createContext(EGLContext eGLContext) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{eGLContext}, this, changeQuickRedirect, false, 9336, new Class[]{EGLContext.class}, EGLContext.class);
        if (proxy.isSupported) {
            return (EGLContext) proxy.result;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, this.mEglConfig, eGLContext, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        return eglCreateContext;
    }

    private void destroyContext() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9337, new Class[0], Void.TYPE).isSupported) {
            if (!EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext)) {
                Log.e("destroyContext", "display:" + this.mEglDisplay + " context: " + this.mEglContext);
                StringBuilder sb = new StringBuilder();
                sb.append("eglDestroyContex:");
                sb.append(EGL14.eglGetError());
                Log.e(TAG, sb.toString());
            }
            this.mEglContext = EGL14.EGL_NO_CONTEXT;
            if (this.mDefaultContext != EGL14.EGL_NO_CONTEXT) {
                if (!EGL14.eglDestroyContext(this.mEglDisplay, this.mDefaultContext)) {
                    Log.e("destroyContext", "display:" + this.mEglDisplay + " context: " + this.mDefaultContext);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eglDestroyContex:");
                    sb2.append(EGL14.eglGetError());
                    Log.e(TAG, sb2.toString());
                }
                this.mDefaultContext = EGL14.EGL_NO_CONTEXT;
            }
        }
    }

    /* access modifiers changed from: private */
    public EGLSurface createWindowSurface(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, changeQuickRedirect, false, 9338, new Class[]{Object.class}, EGLSurface.class);
        if (proxy.isSupported) {
            return (EGLSurface) proxy.result;
        }
        try {
            return EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, obj, new int[]{12344}, 0);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "eglCreateWindowSurface", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public EGLSurface createOffscreenSurface(int i, int i2) {
        EGLSurface eGLSurface;
        IllegalArgumentException e;
        RuntimeException e2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9339, new Class[]{Integer.TYPE, Integer.TYPE}, EGLSurface.class);
        if (proxy.isSupported) {
            return (EGLSurface) proxy.result;
        }
        try {
            eGLSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
            try {
                checkEglError("eglCreatePbufferSurface");
                if (eGLSurface != null) {
                    return eGLSurface;
                }
                throw new RuntimeException("surface was null");
            } catch (IllegalArgumentException e3) {
                e = e3;
                Log.e(TAG, "createOffscreenSurface", e);
                return eGLSurface;
            } catch (RuntimeException e4) {
                e2 = e4;
                Log.e(TAG, "createOffscreenSurface", e2);
                return eGLSurface;
            }
        } catch (IllegalArgumentException e5) {
            IllegalArgumentException illegalArgumentException = e5;
            eGLSurface = null;
            e = illegalArgumentException;
            Log.e(TAG, "createOffscreenSurface", e);
            return eGLSurface;
        } catch (RuntimeException e6) {
            RuntimeException runtimeException = e6;
            eGLSurface = null;
            e2 = runtimeException;
            Log.e(TAG, "createOffscreenSurface", e2);
            return eGLSurface;
        }
    }

    /* access modifiers changed from: private */
    public void destroyWindowSurface(EGLSurface eGLSurface) {
        if (!PatchProxy.proxy(new Object[]{eGLSurface}, this, changeQuickRedirect, false, 9340, new Class[]{EGLSurface.class}, Void.TYPE).isSupported) {
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.mEglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
            }
            EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
        }
    }

    private void checkEglError(String str) {
        int eglGetError;
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9341, new Class[]{String.class}, Void.TYPE).isSupported && (eglGetError = EGL14.eglGetError()) != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private EGLConfig getConfig(boolean z, boolean z2) {
        boolean z3 = z;
        boolean z4 = z2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0)}, this, changeQuickRedirect, false, 9342, new Class[]{Boolean.TYPE, Boolean.TYPE}, EGLConfig.class);
        if (proxy.isSupported) {
            return (EGLConfig) proxy.result;
        }
        int[] iArr = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344, 12344, 12344, 12344, 12344, 12344, 12344};
        int i = 10;
        if (z3) {
            iArr[10] = 12325;
            i = 12;
            iArr[11] = 16;
        }
        if (z4 && Build.VERSION.SDK_INT >= 18) {
            int i2 = i + 1;
            iArr[i] = EGL_RECORDABLE_ANDROID;
            i = i2 + 1;
            iArr[i2] = 1;
        }
        for (int length = iArr.length - 1; length >= i; length--) {
            iArr[length] = 12344;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEglDisplay, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w(TAG, "unable to find RGBA8888 /  EGLConfig");
        return null;
    }
}
