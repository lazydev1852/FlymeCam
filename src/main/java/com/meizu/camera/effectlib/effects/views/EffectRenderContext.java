package com.meizu.camera.effectlib.effects.views;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.camera.effectlib.effects.p058a.GLTexture;
import com.meizu.camera.effectlib.effects.p058a.GLTexture3D;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EffectRenderContext {

    /* renamed from: N */
    private static int f3775N;

    /* renamed from: O */
    private static int f3776O;

    /* renamed from: a */
    public static ChangeQuickRedirect f3777a;

    /* renamed from: b */
    public static EffectRenderContext f3778b;

    /* renamed from: A */
    private int f3779A;

    /* renamed from: B */
    private int f3780B;

    /* renamed from: C */
    private int f3781C;

    /* renamed from: D */
    private int f3782D;

    /* renamed from: E */
    private int f3783E;

    /* renamed from: F */
    private float[] f3784F = new float[16];

    /* renamed from: G */
    private final Object f3785G = new Object();

    /* renamed from: H */
    private final List<BaseRender> f3786H = new ArrayList();

    /* renamed from: I */
    private final List<GLTexture> f3787I = new ArrayList();

    /* renamed from: J */
    private final List<C1175a> f3788J = new ArrayList();

    /* renamed from: K */
    private final List<SurfaceTexture> f3789K = new ArrayList();

    /* renamed from: L */
    private final List<SurfaceTextureWrapper> f3790L = new ArrayList();

    /* renamed from: M */
    private boolean f3791M = true;

    /* renamed from: P */
    private int f3792P = 0;

    /* renamed from: Q */
    private boolean f3793Q = false;

    /* renamed from: R */
    private final Map<String, BaseRender> f3794R = new HashMap();

    /* renamed from: S */
    private final Map<String, BaseRender> f3795S = new HashMap();

    /* renamed from: T */
    private final Map<String, BaseRender> f3796T = new HashMap();

    /* renamed from: U */
    private final Map<String, BaseRender> f3797U = new HashMap();

    /* renamed from: V */
    private final Map<String, GLTexture3D> f3798V = new HashMap();

    /* renamed from: W */
    private boolean f3799W = false;

    /* renamed from: X */
    private boolean f3800X = false;

    /* renamed from: Y */
    private boolean f3801Y = true;

    /* renamed from: Z */
    private int f3802Z = 0;

    /* renamed from: aa */
    private boolean f3803aa = false;

    /* renamed from: ab */
    private EGLContext f3804ab = EGL14.EGL_NO_CONTEXT;

    /* renamed from: ac */
    private final Object f3805ac = new Object();

    /* renamed from: c */
    public SurfaceTextureWrapper f3806c;

    /* renamed from: d */
    public boolean f3807d = false;

    /* renamed from: e */
    public boolean f3808e = false;

    /* renamed from: f */
    public boolean f3809f = false;

    /* renamed from: g */
    private SurfaceTexture f3810g;

    /* renamed from: h */
    private GLTexture f3811h = null;

    /* renamed from: i */
    private GLTexture f3812i = null;

    /* renamed from: j */
    private int f3813j;

    /* renamed from: k */
    private int f3814k;

    /* renamed from: l */
    private int f3815l;

    /* renamed from: m */
    private int f3816m;

    /* renamed from: n */
    private boolean f3817n = false;

    /* renamed from: o */
    private boolean f3818o = false;

    /* renamed from: p */
    private boolean f3819p = true;

    /* renamed from: q */
    private boolean f3820q = false;

    /* renamed from: r */
    private boolean f3821r = false;

    /* renamed from: s */
    private boolean f3822s = false;

    /* renamed from: t */
    private boolean f3823t = false;

    /* renamed from: u */
    private boolean f3824u = false;

    /* renamed from: v */
    private boolean f3825v = false;

    /* renamed from: w */
    private boolean f3826w = false;

    /* renamed from: x */
    private int f3827x;

    /* renamed from: y */
    private int f3828y;

    /* renamed from: z */
    private int f3829z;

    public enum MapType {
        PREVIEW,
        EFFECT,
        VIDEO,
        RECORDER;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    private EffectRenderContext() {
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.EffectRenderContext$a */
    private class C1175a {

        /* renamed from: a */
        PreviewView f3830a;

        /* renamed from: b */
        GLTexture f3831b;

        /* renamed from: c */
        SurfaceTexture f3832c;

        /* renamed from: d */
        SurfaceTextureWrapper f3833d;

        private C1175a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14179a(com.meizu.camera.effectlib.effects.views.PreviewView r11, com.meizu.camera.effectlib.effects.p058a.GLTexture r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            r8 = 0
            r1[r8] = r11     // Catch:{ all -> 0x006d }
            r9 = 1
            r1[r9] = r12     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x006d }
            r4 = 0
            r5 = 269(0x10d, float:3.77E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.c> r0 = com.meizu.camera.effectlib.effects.views.PreviewView.class
            r6[r8] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class<com.meizu.camera.effectlib.effects.a.c> r0 = com.meizu.camera.effectlib.effects.p058a.GLTexture.class
            r6[r9] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r10
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r10)
            return
        L_0x0026:
            if (r11 == 0) goto L_0x006b
            if (r12 != 0) goto L_0x002b
            goto L_0x006b
        L_0x002b:
            r0 = 0
        L_0x002c:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            int r1 = r1.size()     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x0045
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r1 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r1     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.c r1 = r1.f3830a     // Catch:{ all -> 0x006d }
            if (r1 != r11) goto L_0x0042
            r8 = 1
            goto L_0x0046
        L_0x0042:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r8 != 0) goto L_0x005f
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r0 = new com.meizu.camera.effectlib.effects.views.EffectRenderContext$a     // Catch:{ all -> 0x006d }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x006d }
            r0.f3830a = r11     // Catch:{ all -> 0x006d }
            r0.f3831b = r12     // Catch:{ all -> 0x006d }
            r0.f3832c = r1     // Catch:{ all -> 0x006d }
            int r11 = f3775N     // Catch:{ all -> 0x006d }
            int r11 = r11 + r9
            f3775N = r11     // Catch:{ all -> 0x006d }
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            r11.add(r0)     // Catch:{ all -> 0x006d }
            goto L_0x0069
        L_0x005f:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r11 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r11     // Catch:{ all -> 0x006d }
            r11.f3831b = r12     // Catch:{ all -> 0x006d }
        L_0x0069:
            monitor-exit(r10)
            return
        L_0x006b:
            monitor-exit(r10)
            return
        L_0x006d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14179a(com.meizu.camera.effectlib.effects.views.c, com.meizu.camera.effectlib.effects.a.c):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14178a(com.meizu.camera.effectlib.effects.views.PreviewView r11, android.graphics.SurfaceTexture r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            r8 = 0
            r1[r8] = r11     // Catch:{ all -> 0x006d }
            r9 = 1
            r1[r9] = r12     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x006d }
            r4 = 0
            r5 = 270(0x10e, float:3.78E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.c> r0 = com.meizu.camera.effectlib.effects.views.PreviewView.class
            r6[r8] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class<android.graphics.SurfaceTexture> r0 = android.graphics.SurfaceTexture.class
            r6[r9] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r10
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r10)
            return
        L_0x0026:
            if (r11 == 0) goto L_0x006b
            if (r12 != 0) goto L_0x002b
            goto L_0x006b
        L_0x002b:
            r0 = 0
        L_0x002c:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            int r1 = r1.size()     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x0045
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r1 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r1     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.c r1 = r1.f3830a     // Catch:{ all -> 0x006d }
            if (r1 != r11) goto L_0x0042
            r8 = 1
            goto L_0x0046
        L_0x0042:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r8 != 0) goto L_0x005f
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r0 = new com.meizu.camera.effectlib.effects.views.EffectRenderContext$a     // Catch:{ all -> 0x006d }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x006d }
            r0.f3830a = r11     // Catch:{ all -> 0x006d }
            r0.f3832c = r12     // Catch:{ all -> 0x006d }
            r0.f3831b = r1     // Catch:{ all -> 0x006d }
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            r11.add(r0)     // Catch:{ all -> 0x006d }
            int r11 = f3775N     // Catch:{ all -> 0x006d }
            int r11 = r11 + r9
            f3775N = r11     // Catch:{ all -> 0x006d }
            goto L_0x0069
        L_0x005f:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r11 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r11     // Catch:{ all -> 0x006d }
            r11.f3832c = r12     // Catch:{ all -> 0x006d }
        L_0x0069:
            monitor-exit(r10)
            return
        L_0x006b:
            monitor-exit(r10)
            return
        L_0x006d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14178a(com.meizu.camera.effectlib.effects.views.c, android.graphics.SurfaceTexture):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14175a(android.graphics.SurfaceTexture r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0067 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x0067 }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x0067 }
            r4 = 0
            r5 = 271(0x10f, float:3.8E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0067 }
            java.lang.Class<android.graphics.SurfaceTexture> r2 = android.graphics.SurfaceTexture.class
            r6[r8] = r2     // Catch:{ all -> 0x0067 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0067 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            if (r10 != 0) goto L_0x0023
            monitor-exit(r9)
            return
        L_0x0023:
            r1 = 0
        L_0x0024:
            java.util.List<android.graphics.SurfaceTexture> r2 = r9.f3789K     // Catch:{ all -> 0x0067 }
            int r2 = r2.size()     // Catch:{ all -> 0x0067 }
            if (r1 >= r2) goto L_0x0039
            java.util.List<android.graphics.SurfaceTexture> r2 = r9.f3789K     // Catch:{ all -> 0x0067 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0067 }
            if (r2 != r10) goto L_0x0036
            r8 = 1
            goto L_0x0039
        L_0x0036:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0039:
            if (r8 != 0) goto L_0x0065
            java.util.List<android.graphics.SurfaceTexture> r1 = r9.f3789K     // Catch:{ all -> 0x0067 }
            r1.add(r10)     // Catch:{ all -> 0x0067 }
            int r1 = f3776O     // Catch:{ all -> 0x0067 }
            int r1 = r1 + r0
            f3776O = r1     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = " addSurfaceTexture :"
            r1.append(r2)     // Catch:{ all -> 0x0067 }
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            java.lang.String r10 = " CameraSurfaceTextureNum :"
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            int r10 = f3776O     // Catch:{ all -> 0x0067 }
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0067 }
            android.util.Log.i(r0, r10)     // Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r9)
            return
        L_0x0067:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14175a(android.graphics.SurfaceTexture):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo14195b(android.graphics.SurfaceTexture r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0043 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x0043 }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x0043 }
            r4 = 0
            r5 = 272(0x110, float:3.81E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0043 }
            java.lang.Class<android.graphics.SurfaceTexture> r2 = android.graphics.SurfaceTexture.class
            r6[r8] = r2     // Catch:{ all -> 0x0043 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0043 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0043 }
            boolean r2 = r1.isSupported     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0027
            java.lang.Object r10 = r1.result     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0043 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0043 }
            monitor-exit(r9)
            return r10
        L_0x0027:
            if (r10 != 0) goto L_0x002b
            monitor-exit(r9)
            return r8
        L_0x002b:
            r1 = 0
        L_0x002c:
            java.util.List<android.graphics.SurfaceTexture> r2 = r9.f3789K     // Catch:{ all -> 0x0043 }
            int r2 = r2.size()     // Catch:{ all -> 0x0043 }
            if (r1 >= r2) goto L_0x0040
            java.util.List<android.graphics.SurfaceTexture> r2 = r9.f3789K     // Catch:{ all -> 0x0043 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0043 }
            if (r2 != r10) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            int r1 = r1 + 1
            goto L_0x002c
        L_0x0040:
            r0 = 0
        L_0x0041:
            monitor-exit(r9)
            return r0
        L_0x0043:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14195b(android.graphics.SurfaceTexture):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14180a(com.meizu.camera.effectlib.effects.views.PreviewView r11, com.meizu.imageproc.SurfaceTextureWrapper r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            r8 = 0
            r1[r8] = r11     // Catch:{ all -> 0x006d }
            r9 = 1
            r1[r9] = r12     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x006d }
            r4 = 0
            r5 = 273(0x111, float:3.83E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.c> r0 = com.meizu.camera.effectlib.effects.views.PreviewView.class
            r6[r8] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class<com.meizu.imageproc.SurfaceTextureWrapper> r0 = com.meizu.imageproc.SurfaceTextureWrapper.class
            r6[r9] = r0     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r10
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r10)
            return
        L_0x0026:
            if (r11 == 0) goto L_0x006b
            if (r12 != 0) goto L_0x002b
            goto L_0x006b
        L_0x002b:
            r0 = 0
        L_0x002c:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            int r1 = r1.size()     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x0045
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r1 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r1     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.c r1 = r1.f3830a     // Catch:{ all -> 0x006d }
            if (r1 != r11) goto L_0x0042
            r8 = 1
            goto L_0x0046
        L_0x0042:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r8 != 0) goto L_0x005f
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r0 = new com.meizu.camera.effectlib.effects.views.EffectRenderContext$a     // Catch:{ all -> 0x006d }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x006d }
            r0.f3830a = r11     // Catch:{ all -> 0x006d }
            r0.f3833d = r12     // Catch:{ all -> 0x006d }
            r0.f3831b = r1     // Catch:{ all -> 0x006d }
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            r11.add(r0)     // Catch:{ all -> 0x006d }
            int r11 = f3775N     // Catch:{ all -> 0x006d }
            int r11 = r11 + r9
            f3775N = r11     // Catch:{ all -> 0x006d }
            goto L_0x0069
        L_0x005f:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r11 = r10.f3788J     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r11 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r11     // Catch:{ all -> 0x006d }
            r11.f3833d = r12     // Catch:{ all -> 0x006d }
        L_0x0069:
            monitor-exit(r10)
            return
        L_0x006b:
            monitor-exit(r10)
            return
        L_0x006d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14180a(com.meizu.camera.effectlib.effects.views.c, com.meizu.imageproc.SurfaceTextureWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14181a(com.meizu.imageproc.SurfaceTextureWrapper r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0067 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x0067 }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x0067 }
            r4 = 0
            r5 = 274(0x112, float:3.84E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0067 }
            java.lang.Class<com.meizu.imageproc.SurfaceTextureWrapper> r2 = com.meizu.imageproc.SurfaceTextureWrapper.class
            r6[r8] = r2     // Catch:{ all -> 0x0067 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0067 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            if (r10 != 0) goto L_0x0023
            monitor-exit(r9)
            return
        L_0x0023:
            r1 = 0
        L_0x0024:
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r2 = r9.f3790L     // Catch:{ all -> 0x0067 }
            int r2 = r2.size()     // Catch:{ all -> 0x0067 }
            if (r1 >= r2) goto L_0x0039
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r2 = r9.f3790L     // Catch:{ all -> 0x0067 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0067 }
            if (r2 != r10) goto L_0x0036
            r8 = 1
            goto L_0x0039
        L_0x0036:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0039:
            if (r8 != 0) goto L_0x0065
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r1 = r9.f3790L     // Catch:{ all -> 0x0067 }
            r1.add(r10)     // Catch:{ all -> 0x0067 }
            int r1 = f3776O     // Catch:{ all -> 0x0067 }
            int r1 = r1 + r0
            f3776O = r1     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = " addSurfaceTexture :"
            r1.append(r2)     // Catch:{ all -> 0x0067 }
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            java.lang.String r10 = " CameraSurfaceTextureNum :"
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            int r10 = f3776O     // Catch:{ all -> 0x0067 }
            r1.append(r10)     // Catch:{ all -> 0x0067 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0067 }
            android.util.Log.i(r0, r10)     // Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r9)
            return
        L_0x0067:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14181a(com.meizu.imageproc.SurfaceTextureWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo14196b(com.meizu.imageproc.SurfaceTextureWrapper r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0043 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x0043 }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x0043 }
            r4 = 0
            r5 = 275(0x113, float:3.85E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0043 }
            java.lang.Class<com.meizu.imageproc.SurfaceTextureWrapper> r2 = com.meizu.imageproc.SurfaceTextureWrapper.class
            r6[r8] = r2     // Catch:{ all -> 0x0043 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0043 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0043 }
            boolean r2 = r1.isSupported     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0027
            java.lang.Object r10 = r1.result     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0043 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0043 }
            monitor-exit(r9)
            return r10
        L_0x0027:
            if (r10 != 0) goto L_0x002b
            monitor-exit(r9)
            return r8
        L_0x002b:
            r1 = 0
        L_0x002c:
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r2 = r9.f3790L     // Catch:{ all -> 0x0043 }
            int r2 = r2.size()     // Catch:{ all -> 0x0043 }
            if (r1 >= r2) goto L_0x0040
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r2 = r9.f3790L     // Catch:{ all -> 0x0043 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0043 }
            if (r2 != r10) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            int r1 = r1 + 1
            goto L_0x002c
        L_0x0040:
            r0 = 0
        L_0x0041:
            monitor-exit(r9)
            return r0
        L_0x0043:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14196b(com.meizu.imageproc.SurfaceTextureWrapper):boolean");
    }

    /* renamed from: a */
    public synchronized GLTexture mo14169a(PreviewView cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, this, f3777a, false, 276, new Class[]{PreviewView.class}, GLTexture.class);
        if (proxy.isSupported) {
            return (GLTexture) proxy.result;
        }
        if (cVar != null) {
            for (int i = 0; i < this.f3788J.size(); i++) {
                if (this.f3788J.get(i).f3830a == cVar) {
                    return this.f3788J.get(i).f3831b;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized List<SurfaceTexture> mo14171a() {
        return this.f3789K;
    }

    /* renamed from: b */
    public synchronized List<SurfaceTextureWrapper> mo14189b() {
        return this.f3790L;
    }

    /* renamed from: c */
    public synchronized SurfaceTexture mo14198c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3777a, false, 279, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        } else if (this.f3788J.size() <= 0) {
            return null;
        } else {
            return this.f3788J.get(0).f3832c;
        }
    }

    /* renamed from: d */
    public synchronized SurfaceTextureWrapper mo14205d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3777a, false, 280, new Class[0], SurfaceTextureWrapper.class);
        if (proxy.isSupported) {
            return (SurfaceTextureWrapper) proxy.result;
        } else if (this.f3788J.size() <= 0) {
            return null;
        } else {
            return this.f3788J.get(0).f3833d;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14193b(com.meizu.camera.effectlib.effects.views.PreviewView r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a1 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x00a1 }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x00a1 }
            r4 = 0
            r5 = 281(0x119, float:3.94E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x00a1 }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.c> r2 = com.meizu.camera.effectlib.effects.views.PreviewView.class
            r6[r8] = r2     // Catch:{ all -> 0x00a1 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x00a1 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a1 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r1 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x009f
            r1 = 0
        L_0x0024:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r2 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a1 }
            r3 = 0
            if (r1 >= r2) goto L_0x0051
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r2 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00a1 }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r2 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r2     // Catch:{ all -> 0x00a1 }
            com.meizu.camera.effectlib.effects.views.c r4 = r2.f3830a     // Catch:{ all -> 0x00a1 }
            if (r10 != r4) goto L_0x004e
            r2.f3830a = r3     // Catch:{ all -> 0x00a1 }
            r2.f3831b = r3     // Catch:{ all -> 0x00a1 }
            android.graphics.SurfaceTexture r4 = r2.f3832c     // Catch:{ all -> 0x00a1 }
            if (r4 == 0) goto L_0x0043
            r2.f3832c = r3     // Catch:{ all -> 0x00a1 }
        L_0x0043:
            com.meizu.imageproc.SurfaceTextureWrapper r4 = r2.f3833d     // Catch:{ all -> 0x00a1 }
            if (r4 == 0) goto L_0x0049
            r2.f3833d = r3     // Catch:{ all -> 0x00a1 }
        L_0x0049:
            int r2 = f3775N     // Catch:{ all -> 0x00a1 }
            int r2 = r2 - r0
            f3775N = r2     // Catch:{ all -> 0x00a1 }
        L_0x004e:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0051:
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = " releaseCameraTexture: "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            r1.append(r10)     // Catch:{ all -> 0x00a1 }
            java.lang.String r10 = " CameraTextureNum "
            r1.append(r10)     // Catch:{ all -> 0x00a1 }
            int r10 = f3775N     // Catch:{ all -> 0x00a1 }
            r1.append(r10)     // Catch:{ all -> 0x00a1 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x00a1 }
            android.util.Log.e(r0, r10)     // Catch:{ all -> 0x00a1 }
            int r10 = f3775N     // Catch:{ all -> 0x00a1 }
            if (r10 != 0) goto L_0x009f
        L_0x0075:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r10 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            int r10 = r10.size()     // Catch:{ all -> 0x00a1 }
            if (r8 >= r10) goto L_0x009a
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r10 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ all -> 0x00a1 }
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$a r10 = (com.meizu.camera.effectlib.effects.views.EffectRenderContext.C1175a) r10     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x0097
            r10.f3830a = r3     // Catch:{ all -> 0x00a1 }
            r10.f3831b = r3     // Catch:{ all -> 0x00a1 }
            android.graphics.SurfaceTexture r0 = r10.f3832c     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0091
            r10.f3832c = r3     // Catch:{ all -> 0x00a1 }
        L_0x0091:
            com.meizu.imageproc.SurfaceTextureWrapper r0 = r10.f3833d     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0097
            r10.f3833d = r3     // Catch:{ all -> 0x00a1 }
        L_0x0097:
            int r8 = r8 + 1
            goto L_0x0075
        L_0x009a:
            java.util.List<com.meizu.camera.effectlib.effects.views.EffectRenderContext$a> r10 = r9.f3788J     // Catch:{ all -> 0x00a1 }
            r10.clear()     // Catch:{ all -> 0x00a1 }
        L_0x009f:
            monitor-exit(r9)
            return
        L_0x00a1:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14193b(com.meizu.camera.effectlib.effects.views.c):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        return;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14208e() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x006d }
            r4 = 0
            r5 = 282(0x11a, float:3.95E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            java.util.List<android.graphics.SurfaceTexture> r1 = r8.f3789K     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x006b
        L_0x001c:
            java.util.List<android.graphics.SurfaceTexture> r1 = r8.f3789K     // Catch:{ all -> 0x006d }
            int r1 = r1.size()     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x004e
            java.util.List<android.graphics.SurfaceTexture> r1 = r8.f3789K     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006d }
            android.graphics.SurfaceTexture r1 = (android.graphics.SurfaceTexture) r1     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "EffectRenderContext"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r3.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r4 = " releaseSurfaceTexture:"
            r3.append(r4)     // Catch:{ all -> 0x006d }
            r3.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006d }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x006d }
            r1.release()     // Catch:{ all -> 0x006d }
            int r1 = f3776O     // Catch:{ all -> 0x006d }
            int r1 = r1 + -1
            f3776O = r1     // Catch:{ all -> 0x006d }
            int r0 = r0 + 1
            goto L_0x001c
        L_0x004e:
            java.util.List<android.graphics.SurfaceTexture> r0 = r8.f3789K     // Catch:{ all -> 0x006d }
            r0.clear()     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = " releaseSurfaceTexture: CameraSurfaceTextureNum "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            int r2 = f3776O     // Catch:{ all -> 0x006d }
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006d }
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r8)
            return
        L_0x006d:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14208e():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        return;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14211f() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x006d }
            r4 = 0
            r5 = 283(0x11b, float:3.97E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            java.util.List<android.graphics.SurfaceTexture> r1 = r8.f3789K     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x006b
        L_0x001c:
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r1 = r8.f3790L     // Catch:{ all -> 0x006d }
            int r1 = r1.size()     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x004e
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r1 = r8.f3790L     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006d }
            com.meizu.imageproc.SurfaceTextureWrapper r1 = (com.meizu.imageproc.SurfaceTextureWrapper) r1     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "EffectRenderContext"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r3.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r4 = " releaseSurfaceTexture:"
            r3.append(r4)     // Catch:{ all -> 0x006d }
            r3.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006d }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x006d }
            r1.release()     // Catch:{ all -> 0x006d }
            int r1 = f3776O     // Catch:{ all -> 0x006d }
            int r1 = r1 + -1
            f3776O = r1     // Catch:{ all -> 0x006d }
            int r0 = r0 + 1
            goto L_0x001c
        L_0x004e:
            java.util.List<com.meizu.imageproc.SurfaceTextureWrapper> r0 = r8.f3790L     // Catch:{ all -> 0x006d }
            r0.clear()     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = " releaseSurfaceTexture: CameraSurfaceTextureNum "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            int r2 = f3776O     // Catch:{ all -> 0x006d }
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006d }
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r8)
            return
        L_0x006d:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14211f():void");
    }

    /* renamed from: g */
    public boolean mo14216g() {
        return this.f3791M;
    }

    /* renamed from: h */
    public static EffectRenderContext m4369h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f3777a, true, 285, new Class[0], EffectRenderContext.class);
        if (proxy.isSupported) {
            return (EffectRenderContext) proxy.result;
        }
        if (f3778b == null) {
            f3778b = new EffectRenderContext();
        }
        return f3778b;
    }

    /* renamed from: a */
    public void mo14186a(boolean z) {
        this.f3826w = z;
    }

    /* renamed from: b */
    public synchronized void mo14194b(boolean z) {
        this.f3820q = z;
    }

    /* renamed from: i */
    public synchronized boolean mo14221i() {
        return this.f3820q;
    }

    /* renamed from: c */
    public synchronized void mo14200c(SurfaceTexture surfaceTexture) {
        this.f3810g = surfaceTexture;
    }

    /* renamed from: c */
    public synchronized void mo14201c(SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f3806c = surfaceTextureWrapper;
    }

    /* renamed from: c */
    public void mo14203c(boolean z) {
        this.f3793Q = z;
    }

    /* renamed from: j */
    public boolean mo14223j() {
        return this.f3793Q;
    }

    /* renamed from: a */
    public synchronized void mo14177a(GLTexture cVar) {
        this.f3811h = cVar;
    }

    /* renamed from: b */
    public synchronized void mo14192b(GLTexture cVar) {
        this.f3812i = cVar;
    }

    /* renamed from: a */
    public synchronized void mo14173a(int i, int i2) {
        this.f3813j = i;
        this.f3814k = i2;
    }

    /* renamed from: b */
    public synchronized void mo14191b(int i, int i2) {
        this.f3815l = i;
        this.f3816m = i2;
    }

    /* renamed from: k */
    public int mo14224k() {
        return this.f3781C;
    }

    /* renamed from: a */
    public void mo14172a(int i) {
        this.f3781C = i;
    }

    /* renamed from: l */
    public int mo14226l() {
        return this.f3782D;
    }

    /* renamed from: b */
    public void mo14190b(int i) {
        this.f3782D = i;
    }

    /* renamed from: m */
    public int mo14228m() {
        return this.f3783E;
    }

    /* renamed from: c */
    public void mo14199c(int i) {
        this.f3783E = i;
    }

    /* renamed from: n */
    public int mo14230n() {
        return this.f3780B;
    }

    /* renamed from: d */
    public void mo14206d(int i) {
        this.f3780B = i;
    }

    /* renamed from: o */
    public int mo14231o() {
        return this.f3829z;
    }

    /* renamed from: e */
    public void mo14209e(int i) {
        this.f3829z = i;
    }

    /* renamed from: p */
    public int mo14232p() {
        return this.f3779A;
    }

    /* renamed from: f */
    public void mo14212f(int i) {
        this.f3779A = i;
    }

    /* renamed from: d */
    public void mo14207d(boolean z) {
        this.f3817n = z;
    }

    /* renamed from: q */
    public boolean mo14233q() {
        return this.f3817n;
    }

    /* renamed from: r */
    public boolean mo14234r() {
        return this.f3821r;
    }

    /* renamed from: s */
    public boolean mo14235s() {
        return this.f3823t;
    }

    /* renamed from: e */
    public void mo14210e(boolean z) {
        this.f3823t = z;
    }

    /* renamed from: f */
    public void mo14213f(boolean z) {
        this.f3822s = z;
    }

    /* renamed from: g */
    public void mo14215g(boolean z) {
        this.f3818o = z;
    }

    /* renamed from: t */
    public boolean mo14236t() {
        return this.f3824u;
    }

    /* renamed from: h */
    public void mo14218h(boolean z) {
        this.f3824u = z;
    }

    /* renamed from: i */
    public void mo14220i(boolean z) {
        this.f3825v = z;
    }

    /* renamed from: u */
    public boolean mo14237u() {
        return this.f3825v;
    }

    /* renamed from: j */
    public void mo14222j(boolean z) {
        this.f3819p = z;
    }

    /* renamed from: g */
    public void mo14214g(int i) {
        this.f3827x = i;
    }

    /* renamed from: h */
    public void mo14217h(int i) {
        this.f3828y = i;
    }

    /* renamed from: v */
    public boolean mo14238v() {
        return this.f3819p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14187a(float[] r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002b }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x002b }
            com.meizu.savior.ChangeQuickRedirect r3 = f3777a     // Catch:{ all -> 0x002b }
            r4 = 0
            r5 = 286(0x11e, float:4.01E-43)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002b }
            java.lang.Class<float[]> r0 = float[].class
            r6[r8] = r0     // Catch:{ all -> 0x002b }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x002b }
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002b }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            if (r10 == 0) goto L_0x0029
            float[] r0 = r9.f3784F     // Catch:{ all -> 0x002b }
            float[] r1 = r9.f3784F     // Catch:{ all -> 0x002b }
            int r1 = r1.length     // Catch:{ all -> 0x002b }
            java.lang.System.arraycopy(r10, r8, r0, r8, r1)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r9)
            return
        L_0x002b:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14187a(float[]):void");
    }

    /* renamed from: a */
    public void mo14174a(int i, boolean z, boolean z2, boolean z3) {
        this.f3792P = i;
        this.f3807d = z;
        this.f3808e = z2;
        this.f3809f = z3;
    }

    /* renamed from: b */
    public int mo14188b(int i, boolean z, boolean z2, boolean z3) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)}, this, f3777a, false, 287, new Class[]{Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f3792P == 0) {
            mo14174a(i, z, z2, z3);
        }
        return this.f3792P;
    }

    /* renamed from: w */
    public synchronized int mo14239w() {
        return this.f3813j;
    }

    /* renamed from: x */
    public synchronized int mo14240x() {
        return this.f3814k;
    }

    /* renamed from: y */
    public synchronized SurfaceTexture mo14241y() {
        return this.f3810g;
    }

    /* renamed from: z */
    public synchronized SurfaceTextureWrapper mo14242z() {
        return this.f3806c;
    }

    /* renamed from: A */
    public synchronized GLTexture mo14156A() {
        return this.f3811h;
    }

    /* renamed from: B */
    public synchronized GLTexture mo14157B() {
        return this.f3812i;
    }

    /* renamed from: C */
    public synchronized float[] mo14158C() {
        return this.f3784F;
    }

    /* renamed from: a */
    public synchronized void mo14182a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3777a, false, 288, new Class[]{String.class}, Void.TYPE).isSupported) {
            Log.d("EffectRenderContext", "removeEffectRender rendername:" + str);
            this.f3794R.remove(str);
        }
    }

    /* renamed from: b */
    public synchronized boolean mo14197b(String str) {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f3777a, false, 289, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (Map.Entry next : this.f3794R.entrySet()) {
            BaseRender aVar = (BaseRender) next.getValue();
            if (((String) next.getKey()).equals(str)) {
                z = true;
            }
        }
        Log.d("EffectRenderContext", "isEffectRenderActive:" + str + " Active: " + z);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14184a(java.lang.String r10, com.meizu.camera.effectlib.effects.p059b.BaseRender r11, com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x005d }
            r2 = 0
            r1[r2] = r10     // Catch:{ all -> 0x005d }
            r3 = 1
            r1[r3] = r11     // Catch:{ all -> 0x005d }
            r4 = 2
            r1[r4] = r12     // Catch:{ all -> 0x005d }
            com.meizu.savior.ChangeQuickRedirect r5 = f3777a     // Catch:{ all -> 0x005d }
            r6 = 0
            r7 = 291(0x123, float:4.08E-43)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x005d }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r0[r2] = r8     // Catch:{ all -> 0x005d }
            java.lang.Class<com.meizu.camera.effectlib.effects.b.a> r2 = com.meizu.camera.effectlib.effects.p059b.BaseRender.class
            r0[r3] = r2     // Catch:{ all -> 0x005d }
            java.lang.Class<com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType> r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType.class
            r0[r4] = r2     // Catch:{ all -> 0x005d }
            java.lang.Class r8 = java.lang.Void.TYPE     // Catch:{ all -> 0x005d }
            r2 = r9
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r0
            r7 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x005d }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0032
            monitor-exit(r9)
            return
        L_0x0032:
            if (r11 == 0) goto L_0x005b
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType.PREVIEW     // Catch:{ all -> 0x005d }
            if (r12 != r0) goto L_0x003e
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.b.a> r12 = r9.f3795S     // Catch:{ all -> 0x005d }
            r12.put(r10, r11)     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x003e:
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType.EFFECT     // Catch:{ all -> 0x005d }
            if (r12 != r0) goto L_0x0048
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.b.a> r12 = r9.f3794R     // Catch:{ all -> 0x005d }
            r12.put(r10, r11)     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0048:
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType.VIDEO     // Catch:{ all -> 0x005d }
            if (r12 != r0) goto L_0x0052
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.b.a> r12 = r9.f3796T     // Catch:{ all -> 0x005d }
            r12.put(r10, r11)     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0052:
            com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.MapType.RECORDER     // Catch:{ all -> 0x005d }
            if (r12 != r0) goto L_0x005b
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.b.a> r12 = r9.f3797U     // Catch:{ all -> 0x005d }
            r12.put(r10, r11)     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r9)
            return
        L_0x005d:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14184a(java.lang.String, com.meizu.camera.effectlib.effects.b.a, com.meizu.camera.effectlib.effects.views.EffectRenderContext$MapType):void");
    }

    /* renamed from: a */
    public synchronized BaseRender mo14170a(String str, MapType mapType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, mapType}, this, f3777a, false, 292, new Class[]{String.class, MapType.class}, BaseRender.class);
        if (proxy.isSupported) {
            return (BaseRender) proxy.result;
        } else if (mapType == MapType.PREVIEW) {
            return this.f3795S.get(str);
        } else if (mapType == MapType.EFFECT) {
            return this.f3794R.get(str);
        } else if (mapType == MapType.VIDEO) {
            return this.f3796T.get(str);
        } else if (mapType == MapType.RECORDER) {
            return this.f3797U.get(str);
        } else {
            return this.f3795S.get(str);
        }
    }

    /* renamed from: c */
    public synchronized void mo14202c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f3777a, false, 293, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f3795S.remove(str);
        }
    }

    /* renamed from: D */
    public synchronized void mo14159D() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, 294, new Class[0], Void.TYPE).isSupported) {
            mo14185a(this.f3795S, "freePreviewRenderMap");
        }
    }

    /* renamed from: E */
    public synchronized void mo14160E() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, 295, new Class[0], Void.TYPE).isSupported) {
            mo14185a(this.f3794R, "freeEffectRenderMap");
        }
    }

    /* renamed from: F */
    public synchronized void mo14161F() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, 296, new Class[0], Void.TYPE).isSupported) {
            mo14185a(this.f3796T, "freeVideoRenderMap");
        }
    }

    /* renamed from: G */
    public synchronized void mo14162G() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, 297, new Class[0], Void.TYPE).isSupported) {
            mo14185a(this.f3797U, "freeRecordRenderMap");
        }
    }

    /* renamed from: a */
    public synchronized void mo14185a(Map<String, BaseRender> map, String str) {
        if (!PatchProxy.proxy(new Object[]{map, str}, this, f3777a, false, 298, new Class[]{Map.class, String.class}, Void.TYPE).isSupported) {
            Log.d("EffectRenderContext", str);
            Iterator<Map.Entry<String, BaseRender>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                String str2 = (String) next.getKey();
                BaseRender aVar = (BaseRender) next.getValue();
                if (aVar != null) {
                    Log.d("EffectRenderContext", "key:" + str2 + "rendername:" + aVar.mo14046c().mo14345d());
                    aVar.mo14048d();
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0048, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo14183a(java.lang.String r9, com.meizu.camera.effectlib.effects.p058a.GLTexture3D r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0049 }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x0049 }
            r3 = 1
            r1[r3] = r10     // Catch:{ all -> 0x0049 }
            com.meizu.savior.ChangeQuickRedirect r4 = f3777a     // Catch:{ all -> 0x0049 }
            r5 = 0
            r6 = 299(0x12b, float:4.19E-43)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0049 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r2] = r7     // Catch:{ all -> 0x0049 }
            java.lang.Class<com.meizu.camera.effectlib.effects.a.d> r2 = com.meizu.camera.effectlib.effects.p058a.GLTexture3D.class
            r0[r3] = r2     // Catch:{ all -> 0x0049 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0049 }
            r2 = r8
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0049 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x002a
            monitor-exit(r8)
            return
        L_0x002a:
            if (r10 == 0) goto L_0x0047
            java.lang.String r0 = "EffectRenderContext"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r1.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "addLutTexture texturename:"
            r1.append(r2)     // Catch:{ all -> 0x0049 }
            r1.append(r9)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0049 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0049 }
            java.util.Map<java.lang.String, com.meizu.camera.effectlib.effects.a.d> r0 = r8.f3798V     // Catch:{ all -> 0x0049 }
            r0.put(r9, r10)     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r8)
            return
        L_0x0049:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectRenderContext.mo14183a(java.lang.String, com.meizu.camera.effectlib.effects.a.d):void");
    }

    /* renamed from: d */
    public synchronized GLTexture3D mo14204d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f3777a, false, 300, new Class[]{String.class}, GLTexture3D.class);
        if (proxy.isSupported) {
            return (GLTexture3D) proxy.result;
        }
        return this.f3798V.get(str);
    }

    /* renamed from: H */
    public synchronized void mo14163H() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, 302, new Class[0], Void.TYPE).isSupported) {
            Log.d("EffectRenderContext", " freeLutTextureMap");
            Iterator<Map.Entry<String, GLTexture3D>> it = this.f3798V.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                GLTexture3D dVar = (GLTexture3D) next.getValue();
                if (dVar != null) {
                    dVar.mo14036c();
                }
                it.remove();
            }
        }
    }

    /* renamed from: k */
    public void mo14225k(boolean z) {
        this.f3800X = z;
    }

    /* renamed from: I */
    public void mo14164I() {
        if (!PatchProxy.proxy(new Object[0], this, f3777a, false, ARPMessageType.MSG_TYPE_IMU_RESET_LOCATION, new Class[0], Void.TYPE).isSupported) {
            Log.d("EffectRenderContext", "cleanPreviewSurfaceTexture mIsHasWatchOpen:" + this.f3800X + " mIsHasWatchOpen:" + this.f3800X);
            if (this.f3800X && this.f3799W) {
                mo14200c((SurfaceTexture) null);
            }
        }
    }

    /* renamed from: J */
    public boolean mo14165J() {
        return this.f3801Y;
    }

    /* renamed from: l */
    public void mo14227l(boolean z) {
        this.f3801Y = z;
    }

    /* renamed from: i */
    public void mo14219i(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f3777a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 308, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.i("EffectRenderContext", "setCameraId :" + i);
            this.f3802Z = i;
        }
    }

    /* renamed from: K */
    public int mo14166K() {
        return this.f3802Z;
    }

    /* renamed from: m */
    public void mo14229m(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f3777a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, MsgConstants.TRACK_HIDE_LOST_INFO, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Log.i("EffectRenderContext", "setIsVideoMode :" + this.f3803aa);
            this.f3803aa = z;
        }
    }

    /* renamed from: L */
    public boolean mo14167L() {
        return this.f3803aa;
    }

    /* renamed from: a */
    public void mo14176a(EGLContext eGLContext) {
        if (!PatchProxy.proxy(new Object[]{eGLContext}, this, f3777a, false, MsgConstants.TRACK_MSG_ID_TRACK_LOST, new Class[]{EGLContext.class}, Void.TYPE).isSupported) {
            synchronized (this.f3805ac) {
                Log.i("EffectRenderContext", "setEGLContext :" + eGLContext);
                this.f3804ab = eGLContext;
                this.f3805ac.notifyAll();
                Log.i("EffectRenderContext", "mWaitEGLContextLock notifyAll");
            }
        }
    }

    /* renamed from: M */
    public EGLContext mo14168M() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f3777a, false, 311, new Class[0], EGLContext.class);
        if (proxy.isSupported) {
            return (EGLContext) proxy.result;
        }
        synchronized (this.f3805ac) {
            try {
                if (this.f3804ab != EGL14.EGL_NO_CONTEXT) {
                    EGLContext eGLContext = this.f3804ab;
                    return eGLContext;
                }
                Log.i("EffectRenderContext", "mWaitEGLContextLock wait");
                this.f3805ac.wait();
            } catch (InterruptedException unused) {
                Log.i("EffectRenderContext", "mWaitEGLContextLock :interrupted");
            }
        }
        return this.f3804ab;
    }
}
