package com.meizu.common.renderer.functor;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import com.meizu.common.renderer.GLRendererNotProguard;
import com.meizu.common.renderer.RendererUtils;
import com.meizu.common.renderer.SystemProperty;
import com.meizu.common.renderer.effect.GLCanvas;
import com.meizu.common.renderer.effect.GLRenderer;
import com.meizu.common.renderer.effect.Resource;
import com.meizu.common.renderer.effect.p062b.Render;
import com.meizu.common.renderer.effect.p063c.Texture;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawGLFunctor extends Resource {
    protected static final String TAG = "glrenderer";
    public static final int kModeDraw = 0;
    public static final int kModeProcess = 1;
    public static final int kModeProcessNoContext = 2;
    public static final int kModeSync = 3;
    private static LongSparseArray<WeakReference<DrawGLFunctor>> sDrawGLFunctors = new LongSparseArray<>();
    public static boolean sIsLibInitialized = false;
    protected static Method sMethod_callDrawGLFunction;
    protected static Method sMethod_invokeFunctor;
    private boolean GLOBAL_SWITCH = true;
    protected int mAlpha = 255;
    protected String mEffectKey = "__none";
    protected long mNativeFunctor;
    private Object[] mNativeFunctorObject;
    protected Rect mSourceBounds = new Rect();

    @GLRendererNotProguard
    private native long native_create(Object obj);

    @GLRendererNotProguard
    private native void native_destory(long j);

    @GLRendererNotProguard
    private static native void native_init();

    public void invalidate() {
    }

    /* access modifiers changed from: protected */
    public void onInvoke(int i) {
    }

    public void trimResources(int i, boolean z) {
    }

    public DrawGLFunctor() {
        initLibrary();
        this.mNativeFunctor = native_create(new WeakReference(this));
        RendererUtils.m5021a(this.mNativeFunctor != 0);
        this.mNativeFunctorObject = new Object[1];
        if (Build.VERSION.SDK_INT < 21) {
            this.mNativeFunctorObject[0] = new Integer((int) this.mNativeFunctor);
        } else {
            this.mNativeFunctorObject[0] = new Long(this.mNativeFunctor);
        }
        synchronized (sDrawGLFunctors) {
            sDrawGLFunctors.put(this.mNativeFunctor, new WeakReference(this));
        }
        this.GLOBAL_SWITCH = enable();
    }

    private static boolean enable() {
        return !SystemProperty.m5024a("persist.sys.glrenderer.disable", false);
    }

    public void draw(Canvas canvas) {
        if (!canvas.isHardwareAccelerated() || !this.GLOBAL_SWITCH) {
            Log.e(TAG, "DrawGLFunctor only can use in hardware accelerated");
            return;
        }
        this.mSourceBounds.set(0, 0, canvas.getWidth(), canvas.getHeight());
        drawFunctorInternal(canvas);
    }

    public void draw(Canvas canvas, int i, int i2, int i3, int i4) {
        if (!canvas.isHardwareAccelerated() || !this.GLOBAL_SWITCH) {
            Log.e(TAG, "DrawGLFunctor only can use in hardware accelerated");
            return;
        }
        this.mSourceBounds.set(i, i2, i3, i4);
        drawFunctorInternal(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawFunctorInternal(Canvas canvas) {
        if (this.mNativeFunctor == 0 || sMethod_callDrawGLFunction == null) {
            return false;
        }
        try {
            sMethod_callDrawGLFunction.invoke(canvas, this.mNativeFunctorObject);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "invoke callDrawGLFunction e：" + e.getMessage());
            return false;
        }
    }

    public static void freeAllFunctorResouces(int i, boolean z) {
        int size = sDrawGLFunctors.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            WeakReference weakReference = sDrawGLFunctors.get(sDrawGLFunctors.keyAt(i2));
            if (weakReference == null || weakReference.get() == null) {
                arrayList.add(Long.valueOf(sDrawGLFunctors.keyAt(i2)));
            } else {
                ((DrawGLFunctor) weakReference.get()).trimResources(i, z);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sDrawGLFunctors.remove(((Long) it.next()).longValue());
        }
    }

    public void setEffect(String str) {
        if (str != null) {
            this.mEffectKey = str;
        }
    }

    public String getEffect() {
        return this.mEffectKey;
    }

    public Render getRender(GLCanvas dVar) {
        return dVar.mo15955a(this.mEffectKey);
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public boolean isBlend(Texture aVar) {
        return this.mAlpha != 255 || (aVar != null && !aVar.mo15954c());
    }

    /* access modifiers changed from: protected */
    public void onDraw(GLInfo gLInfo) {
        if (GLRenderer.f4379b) {
            Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Log.i(TAG, String.format("viewport: [%d, %d]", new Object[]{Integer.valueOf(gLInfo.viewportWidth), Integer.valueOf(gLInfo.viewportHeight)}));
            Log.i(TAG, String.format("source:[%d, %d, %d, %d]", new Object[]{Integer.valueOf(this.mSourceBounds.left), Integer.valueOf(this.mSourceBounds.top), Integer.valueOf(this.mSourceBounds.right), Integer.valueOf(this.mSourceBounds.bottom)}));
            Log.i(TAG, String.format("clip:[%d, %d, %d, %d]", new Object[]{Integer.valueOf(gLInfo.clipLeft), Integer.valueOf(gLInfo.clipTop), Integer.valueOf(gLInfo.clipRight), Integer.valueOf(gLInfo.clipBottom)}));
            Log.i(TAG, "transform: ");
            for (int i = 0; i < 4; i++) {
                Log.i(TAG, String.format("[%.1f, %.1f, %.1f, %.1f]", new Object[]{Float.valueOf(gLInfo.transform[i + 0]), Float.valueOf(gLInfo.transform[i + 4]), Float.valueOf(gLInfo.transform[i + 8]), Float.valueOf(gLInfo.transform[i + 12])}));
            }
            Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }

    public static synchronized void initLibrary() {
        synchronized (DrawGLFunctor.class) {
            if (!sIsLibInitialized) {
                GLRenderer.m5028a();
                init();
                sIsLibInitialized = true;
            }
        }
    }

    private static void init() {
        native_init();
        try {
            if (Build.VERSION.SDK_INT < 23) {
                Class<?> cls = Class.forName("android.view.HardwareCanvas");
                if (Build.VERSION.SDK_INT < 21) {
                    sMethod_callDrawGLFunction = cls.getMethod("callDrawGLFunction", new Class[]{Integer.TYPE});
                } else if (Build.VERSION.SDK_INT == 21) {
                    sMethod_callDrawGLFunction = cls.getMethod("callDrawGLFunction", new Class[]{Long.TYPE});
                } else {
                    sMethod_callDrawGLFunction = cls.getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});
                }
            } else if (Build.VERSION.SDK_INT < 29) {
                sMethod_callDrawGLFunction = Class.forName("android.view.DisplayListCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});
            } else {
                sMethod_callDrawGLFunction = Class.forName("android.graphics.RecordingCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});
            }
            if (Build.VERSION.SDK_INT >= 29) {
                sMethod_invokeFunctor = Class.forName("android.graphics.HardwareRenderer").getDeclaredMethod("invokeFunctor", new Class[]{Long.TYPE, Boolean.TYPE});
                sMethod_invokeFunctor.setAccessible(true);
            } else if (Build.VERSION.SDK_INT >= 21) {
                sMethod_invokeFunctor = Class.forName("android.view.ThreadedRenderer").getDeclaredMethod("invokeFunctor", new Class[]{Long.TYPE, Boolean.TYPE});
                sMethod_invokeFunctor.setAccessible(true);
            }
        } catch (Exception e) {
            Log.e(TAG, "DrawGLFunctor init fail", e);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mNativeFunctor != 0) {
                trimResources(80, false);
                native_destory(this.mNativeFunctor);
                this.mNativeFunctor = 0;
            }
        } finally {
            super.finalize();
        }
    }

    @GLRendererNotProguard
    private static void postEventFromNative(WeakReference<DrawGLFunctor> weakReference, GLInfo gLInfo, int i) {
        if (weakReference != null && weakReference.get() != null) {
            DrawGLFunctor drawGLFunctor = (DrawGLFunctor) weakReference.get();
            if (gLInfo != null) {
                drawGLFunctor.onDraw(gLInfo);
            } else {
                drawGLFunctor.onInvoke(i);
            }
        }
    }

    @GLRendererNotProguard
    public static class GLInfo {
        public int clipBottom;
        public int clipLeft;
        public int clipRight;
        public int clipTop;
        public boolean isLayer;
        public float[] transform;
        public int viewportHeight;
        public int viewportWidth;

        public GLInfo() {
            this.transform = new float[16];
            Matrix.setIdentityM(this.transform, 0);
        }

        public GLInfo(int i, int i2) {
            this.viewportWidth = i;
            this.viewportHeight = i2;
        }
    }
}
