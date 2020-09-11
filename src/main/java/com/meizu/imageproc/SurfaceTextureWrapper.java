package com.meizu.imageproc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;

public class SurfaceTextureWrapper implements Handler.Callback {
    public static ChangeQuickRedirect changeQuickRedirect;
    private final Looper mCreatorLooper;
    private long mFrameAvailableListener;
    private boolean mIsSingleBuffered;
    private C1568a mListener;
    private Handler mOnFrameAvailableHandler;
    private long mProducer;
    private long mSurfaceTexture;

    /* renamed from: com.meizu.imageproc.SurfaceTextureWrapper$a */
    public interface C1568a {
        /* renamed from: a */
        void mo17626a(SurfaceTextureWrapper surfaceTextureWrapper);
    }

    private native int nativeAttachToGLContext(int i);

    private native long nativeCreateSurface();

    private native int nativeDetachFromGLContext();

    private native void nativeFinalize();

    private native long nativeGetTimestamp();

    private native void nativeGetTransformMatrix(float[] fArr);

    private native void nativeInit(boolean z, int i, boolean z2, WeakReference<SurfaceTextureWrapper> weakReference) throws Surface.OutOfResourcesException;

    private native boolean nativeIsReleased();

    private native void nativeRelease();

    private native void nativeReleaseTexImage();

    private native void nativeSetDefaultBufferSize(int i, int i2);

    private native void nativeSetPreviewTextureToCamera();

    private native void nativeUpdateTexImage();

    public SurfaceTextureWrapper(int i) {
        this(i, false);
    }

    public SurfaceTextureWrapper(int i, boolean z) {
        this.mListener = null;
        this.mCreatorLooper = Looper.myLooper();
        this.mIsSingleBuffered = z;
        nativeInit(false, i, z, new WeakReference(this));
    }

    public SurfaceTextureWrapper(boolean z) {
        this.mListener = null;
        this.mCreatorLooper = Looper.myLooper();
        this.mIsSingleBuffered = z;
        nativeInit(true, 0, z, new WeakReference(this));
    }

    public void setOnFrameAvailableListener(C1568a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, changeQuickRedirect, false, 547, new Class[]{C1568a.class}, Void.TYPE).isSupported) {
            setOnFrameAvailableListener(aVar, (Handler) null);
        }
    }

    public void setOnFrameAvailableListener(C1568a aVar, Handler handler) {
        if (!PatchProxy.proxy(new Object[]{aVar, handler}, this, changeQuickRedirect, false, 548, new Class[]{C1568a.class, Handler.class}, Void.TYPE).isSupported) {
            if (aVar != null) {
                Looper looper = handler != null ? handler.getLooper() : this.mCreatorLooper != null ? this.mCreatorLooper : Looper.getMainLooper();
                this.mListener = aVar;
                this.mOnFrameAvailableHandler = HandlerWrapper.f6470b.mo17627a(looper, this, true);
                return;
            }
            this.mOnFrameAvailableHandler = null;
        }
    }

    public boolean handleMessage(Message message) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, changeQuickRedirect, false, 549, new Class[]{Message.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.mListener != null) {
            this.mListener.mo17626a(this);
        }
        return true;
    }

    public void setPreviewTextureToCamera() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 550, new Class[0], Void.TYPE).isSupported) {
            nativeSetPreviewTextureToCamera();
        }
    }

    public Surface createSurface() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 551, new Class[0], Surface.class);
        if (proxy.isSupported) {
            return (Surface) proxy.result;
        }
        Log.e("@@@", "[SurfaceTextureWrapper] createSurface...1");
        long nativeCreateSurface = nativeCreateSurface();
        Log.e("@@@", "[SurfaceTextureWrapper] createSurface...2");
        return SurfaceWrapper.f6472b.mo17628a(nativeCreateSurface);
    }

    public void setDefaultBufferSize(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 552, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            nativeSetDefaultBufferSize(i, i2);
        }
    }

    public void updateTexImage() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 553, new Class[0], Void.TYPE).isSupported) {
            nativeUpdateTexImage();
        }
    }

    public void releaseTexImage() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 554, new Class[0], Void.TYPE).isSupported) {
            nativeReleaseTexImage();
        }
    }

    public void detachFromGLContext() throws UnsupportedOperationException {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 555, new Class[0], Void.TYPE).isSupported && nativeDetachFromGLContext() != 0) {
            throw new UnsupportedOperationException("Error during detachFromGLContext (see logcat for details)");
        }
    }

    public void attachToGLContext(int i) throws UnsupportedOperationException {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 556, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && nativeAttachToGLContext(i) != 0) {
            throw new UnsupportedOperationException("Error during attachToGLContext (see logcat for details)");
        }
    }

    public void getTransformMatrix(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 557, new Class[]{float[].class}, Void.TYPE).isSupported) {
            if (fArr.length == 16) {
                nativeGetTransformMatrix(fArr);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public long getTimestamp() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 558, new Class[0], Long.TYPE);
        return proxy.isSupported ? ((Long) proxy.result).longValue() : nativeGetTimestamp();
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 559, new Class[0], Void.TYPE).isSupported) {
            nativeRelease();
        }
    }

    public boolean isReleased() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 560, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : nativeIsReleased();
    }

    public void finalize() throws Throwable {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 561, new Class[0], Void.TYPE).isSupported) {
            try {
                nativeFinalize();
            } finally {
                super.finalize();
            }
        }
    }

    private static void postEventFromNative(WeakReference<SurfaceTextureWrapper> weakReference) {
        SurfaceTextureWrapper surfaceTextureWrapper;
        Handler handler;
        if (!PatchProxy.proxy(new Object[]{weakReference}, (Object) null, changeQuickRedirect, true, 562, new Class[]{WeakReference.class}, Void.TYPE).isSupported && (surfaceTextureWrapper = (SurfaceTextureWrapper) weakReference.get()) != null && (handler = surfaceTextureWrapper.mOnFrameAvailableHandler) != null) {
            handler.sendEmptyMessage(0);
        }
    }

    public boolean isSingleBuffered() {
        return this.mIsSingleBuffered;
    }

    static {
        System.loadLibrary("SurfaceTextureWrapper");
    }
}
