package com.meizu.common.renderer.effect;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Log;
import com.meizu.common.renderer.SystemProperty;
import com.meizu.common.renderer.functor.DrawGLFunctor;
import com.meizu.common.renderer.functor.InvokeFunctor;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLContext;

public class GLRenderer {

    /* renamed from: a */
    public static final boolean f4378a = SystemProperty.m5024a("sys.debug.glrenderer_blur", false);

    /* renamed from: b */
    public static final boolean f4379b = SystemProperty.m5024a("sys.debug.glrenderer_functor", false);

    /* renamed from: c */
    public static final boolean f4380c = SystemProperty.m5024a("sys.debug.glrenderer_resource", false);

    /* renamed from: d */
    public static final boolean f4381d = SystemProperty.m5024a("sys.debug.glrenderer_check_err", false);

    /* renamed from: e */
    public static final int f4382e = SystemProperty.m5022a("ro.sf.lcd_density", 480);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f4383f = "glrenderer";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static boolean f4384g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static GLCanvasImpl f4385h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static EGLContext f4386i;

    /* renamed from: j */
    private static Application f4387j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static TrimMemoryCallback f4388k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static TrimMemoryCallback f4389l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static TrimMemoryCallback f4390m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static FrameBufferPool f4391n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static TexturePool f4392o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static TextureCache f4393p;

    /* renamed from: q */
    private static C1326a f4394q;

    /* renamed from: r */
    private static GLRecycler f4395r = new GLRecycler();

    /* renamed from: s */
    private static boolean f4396s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final Object f4397t = new Object();

    /* renamed from: a */
    public static void m5029a(Context context) {
        m5030a(context, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5030a(android.content.Context r2, boolean r3) {
        /*
            java.lang.Object r0 = f4397t
            monitor-enter(r0)
            android.app.Application r1 = f4387j     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0009:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0027 }
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0027 }
            f4387j = r2     // Catch:{ all -> 0x0027 }
            com.meizu.common.renderer.effect.GLRenderer$a r2 = new com.meizu.common.renderer.effect.GLRenderer$a     // Catch:{ all -> 0x0027 }
            r1 = 0
            r2.<init>()     // Catch:{ all -> 0x0027 }
            f4394q = r2     // Catch:{ all -> 0x0027 }
            android.app.Application r2 = f4387j     // Catch:{ all -> 0x0027 }
            com.meizu.common.renderer.effect.GLRenderer$a r1 = f4394q     // Catch:{ all -> 0x0027 }
            r2.registerComponentCallbacks(r1)     // Catch:{ all -> 0x0027 }
            if (r3 != 0) goto L_0x0025
            m5028a()     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.renderer.effect.GLRenderer.m5030a(android.content.Context, boolean):void");
    }

    /* renamed from: a */
    public static void m5028a() {
        synchronized (f4397t) {
            if (f4387j == null) {
                throw new IllegalStateException("Please call it after initialize. ");
            } else if (!f4384g) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Thread(new Runnable() {
                        public void run() {
                            System.loadLibrary(GLRenderer.f4383f);
                            countDownLatch.countDown();
                        }
                    }, "glrender-so-loader-thread").start();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                        Log.w("glrenderer", "thread interrupted! glrenderer.so probably not loaded yet");
                    }
                } else {
                    System.loadLibrary(f4383f);
                }
                f4384g = true;
            }
        }
    }

    /* renamed from: b */
    public static Resources m5031b() {
        if (f4387j != null) {
            return f4387j.getResources();
        }
        return null;
    }

    /* renamed from: c */
    public static void m5034c() {
        if (f4394q != null) {
            f4394q.onTrimMemory(60);
        }
    }

    /* renamed from: d */
    public static GLRecycler m5035d() {
        return f4395r;
    }

    private static class TrimMemoryCallback extends InvokeFunctor {
        private int mLevel;

        public TrimMemoryCallback(int i) {
            this.mLevel = i;
        }

        /* access modifiers changed from: protected */
        public void onInvoke(int i) {
            synchronized (GLRenderer.f4397t) {
                if (GLRenderer.f4380c) {
                    Log.e("glrenderer", "trimResources level = " + this.mLevel);
                }
                boolean z = this.mLevel < 80;
                GLCanvasImpl g = GLRenderer.f4385h;
                if (g != null) {
                    g.trimResources(this.mLevel, z);
                }
                DrawGLFunctor.freeAllFunctorResouces(this.mLevel, z);
                if (GLRenderer.f4392o != null) {
                    GLRenderer.f4392o.trimResources(this.mLevel, z);
                }
                if (GLRenderer.f4391n != null) {
                    GLRenderer.f4391n.trimResources(this.mLevel, z);
                }
                if (GLRenderer.f4393p != null) {
                    GLRenderer.f4393p.trimResources(this.mLevel, z);
                }
                if (!z) {
                    GLCanvasImpl unused = GLRenderer.f4385h = null;
                    EGLContext unused2 = GLRenderer.f4386i = null;
                }
                GLRenderer.m5035d().mo15962a(z);
            }
        }
    }

    /* renamed from: com.meizu.common.renderer.effect.GLRenderer$a */
    private static class C1326a implements ComponentCallbacks2 {
        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        private C1326a() {
        }

        public void onTrimMemory(int i) {
            if (GLRenderer.f4384g) {
                if (i >= 80) {
                    if (GLRenderer.f4390m == null) {
                        TrimMemoryCallback unused = GLRenderer.f4390m = new TrimMemoryCallback(80);
                    }
                    GLRenderer.f4390m.invoke();
                } else if (i >= 40) {
                    if (GLRenderer.f4389l == null) {
                        TrimMemoryCallback unused2 = GLRenderer.f4389l = new TrimMemoryCallback(40);
                    }
                    GLRenderer.f4389l.invoke();
                } else if (i >= 20) {
                    if (GLRenderer.f4388k == null) {
                        TrimMemoryCallback unused3 = GLRenderer.f4388k = new TrimMemoryCallback(20);
                    }
                    GLRenderer.f4388k.invoke();
                }
            }
        }
    }
}
