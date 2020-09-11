package com.baidu.p020ar.blend.blender;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* renamed from: com.baidu.ar.blend.blender.a */
public final class C0642a {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C0652i f1238d = new C0652i();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f1239a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GLSurfaceView.Renderer f1240b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1241c = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Object f1242e;

    /* renamed from: f */
    private C0650g f1243f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0647d f1244g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0648e f1245h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0649f f1246i;

    /* renamed from: j */
    private final WeakReference<C0642a> f1247j = new WeakReference<>(this);

    /* renamed from: com.baidu.ar.blend.blender.a$a */
    private static class C0644a implements C0647d {

        /* renamed from: a */
        protected int f1248a;

        /* renamed from: b */
        protected int f1249b;

        /* renamed from: c */
        protected int f1250c;

        /* renamed from: d */
        protected int f1251d;

        /* renamed from: e */
        protected int f1252e;

        /* renamed from: f */
        protected int f1253f;

        /* renamed from: g */
        protected int[] f1254g;

        /* renamed from: h */
        private int[] f1255h = new int[1];

        public C0644a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f1248a = i;
            this.f1249b = i2;
            this.f1250c = i3;
            this.f1251d = i4;
            this.f1252e = i5;
            this.f1253f = i6;
            this.f1254g = new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12352, 4, 12344};
        }

        /* renamed from: a */
        private int m1497a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f1255h) ? this.f1255h[0] : i2;
        }

        /* renamed from: a */
        public EGLConfig mo9801a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f1254g, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f1254g, eGLConfigArr, i, iArr)) {
                        EGLConfig a = mo9802a(egl10, eGLDisplay, eGLConfigArr);
                        if (a != null) {
                            return a;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        /* renamed from: a */
        public EGLConfig mo9802a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int a = m1497a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a2 = m1497a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a >= this.f1252e && a2 >= this.f1253f) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int a3 = m1497a(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int a4 = m1497a(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int a5 = m1497a(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int a6 = m1497a(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (a3 == this.f1248a && a4 == this.f1249b && a5 == this.f1250c && a6 == this.f1251d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.a$b */
    private static class C0645b implements C0648e {
        private C0645b() {
        }

        /* renamed from: a */
        public EGLContext mo9803a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        }

        /* renamed from: a */
        public void mo9804a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.a$c */
    private static class C0646c implements C0649f {
        private C0646c() {
        }

        /* renamed from: a */
        public EGLSurface mo9805a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Log.e("EngineLogger", "eglCreateWindowSurface", e);
                return null;
            }
        }

        /* renamed from: a */
        public void mo9806a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.a$d */
    public interface C0647d {
        /* renamed from: a */
        EGLConfig mo9801a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.baidu.ar.blend.blender.a$e */
    public interface C0648e {
        /* renamed from: a */
        EGLContext mo9803a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: a */
        void mo9804a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.baidu.ar.blend.blender.a$f */
    public interface C0649f {
        /* renamed from: a */
        EGLSurface mo9805a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: a */
        void mo9806a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.baidu.ar.blend.blender.a$g */
    static class C0650g extends Thread {

        /* renamed from: a */
        private boolean f1256a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f1257b;

        /* renamed from: c */
        private boolean f1258c;

        /* renamed from: d */
        private boolean f1259d;

        /* renamed from: e */
        private boolean f1260e;

        /* renamed from: f */
        private boolean f1261f;

        /* renamed from: g */
        private boolean f1262g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f1263h;

        /* renamed from: i */
        private boolean f1264i;

        /* renamed from: j */
        private boolean f1265j;

        /* renamed from: k */
        private boolean f1266k;

        /* renamed from: l */
        private int f1267l = 0;

        /* renamed from: m */
        private int f1268m = 0;

        /* renamed from: n */
        private int f1269n = 1;

        /* renamed from: o */
        private boolean f1270o = true;

        /* renamed from: p */
        private boolean f1271p = false;

        /* renamed from: q */
        private boolean f1272q;

        /* renamed from: r */
        private ArrayList<Runnable> f1273r = new ArrayList<>();

        /* renamed from: s */
        private boolean f1274s = true;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public C0651h f1275t;

        /* renamed from: u */
        private WeakReference<C0642a> f1276u;

        C0650g(WeakReference<C0642a> weakReference) {
            this.f1276u = weakReference;
        }

        /* renamed from: h */
        private void m1512h() {
            if (this.f1264i) {
                this.f1264i = false;
                this.f1275t.mo9822e();
            }
        }

        /* renamed from: i */
        private void m1513i() {
            if (this.f1263h) {
                this.f1275t.mo9823f();
                this.f1263h = false;
                C0642a.f1238d.mo9825b(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0155, code lost:
            r15 = com.baidu.p020ar.blend.blender.C0642a.m1485h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0159, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            r1.f1265j = true;
            r1.f1261f = true;
            com.baidu.p020ar.blend.blender.C0642a.m1485h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0166, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x016c, code lost:
            if (r12 == false) goto L_0x0178;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x016e, code lost:
            r6 = (javax.microedition.khronos.opengles.GL10) r1.f1275t.mo9820c();
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0178, code lost:
            if (r10 == false) goto L_0x0190;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x017a, code lost:
            r0 = (com.baidu.p020ar.blend.blender.C0642a) r1.f1276u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0182, code lost:
            if (r0 == null) goto L_0x018f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0184, code lost:
            com.baidu.p020ar.blend.blender.C0642a.m1478a(r0).onSurfaceCreated(r6, r1.f1275t.f1280d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x018f, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0190, code lost:
            if (r13 == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0192, code lost:
            r0 = (com.baidu.p020ar.blend.blender.C0642a) r1.f1276u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x019a, code lost:
            if (r0 == null) goto L_0x01a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x019c, code lost:
            com.baidu.p020ar.blend.blender.C0642a.m1478a(r0).onSurfaceChanged(r6, r7, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01a3, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01a4, code lost:
            r0 = (com.baidu.p020ar.blend.blender.C0642a) r1.f1276u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ac, code lost:
            if (r0 == null) goto L_0x01e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01b2, code lost:
            if (com.baidu.p020ar.blend.blender.C0642a.m1480b(r0) == false) goto L_0x01e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01b4, code lost:
            com.baidu.p020ar.blend.blender.C0642a.m1478a(r0).onDrawFrame(r6);
            r0 = r1.f1275t.mo9821d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01c3, code lost:
            if (r0 == 12288) goto L_0x01e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c7, code lost:
            if (r0 == 12302) goto L_0x01e4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01c9, code lost:
            com.baidu.p020ar.blend.blender.C0642a.C0651h.m1528a("GLThread", "eglSwapBuffers", r0);
            r2 = com.baidu.p020ar.blend.blender.C0642a.m1485h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01d4, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
            r1.f1261f = true;
            com.baidu.p020ar.blend.blender.C0642a.m1485h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x01df, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01e4, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x01e7, code lost:
            com.baidu.p020ar.blend.blender.C0642a.m1479a(r0, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x01eb, code lost:
            if (r14 == false) goto L_0x01ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x01ed, code lost:
            r5 = true;
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x012d, code lost:
            if (r9 == null) goto L_0x0136;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r9.run();
            r9 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0136, code lost:
            if (r11 == false) goto L_0x016c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x013e, code lost:
            if (r1.f1275t.mo9819b() == false) goto L_0x0155;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0140, code lost:
            r11 = com.baidu.p020ar.blend.blender.C0642a.m1485h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0144, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r1.f1265j = true;
            com.baidu.p020ar.blend.blender.C0642a.m1485h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x014f, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0150, code lost:
            r11 = false;
         */
        /* renamed from: j */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m1514j() {
            /*
                r16 = this;
                r1 = r16
                com.baidu.ar.blend.blender.a$h r0 = new com.baidu.ar.blend.blender.a$h
                java.lang.ref.WeakReference<com.baidu.ar.blend.blender.a> r2 = r1.f1276u
                r0.<init>(r2)
                r1.f1275t = r0
                r0 = 0
                r1.f1263h = r0
                r1.f1264i = r0
                r1.f1271p = r0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
            L_0x001e:
                com.baidu.ar.blend.blender.a$i r15 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0200 }
                monitor-enter(r15)     // Catch:{ all -> 0x0200 }
            L_0x0023:
                boolean r2 = r1.f1256a     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x0038
                monitor-exit(r15)     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r2)
                r16.m1512h()     // Catch:{ all -> 0x0035 }
                r16.m1513i()     // Catch:{ all -> 0x0035 }
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                return
            L_0x0035:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                throw r0
            L_0x0038:
                boolean r2 = r1.f1263h     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x0055
                boolean r2 = r1.f1264i     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x0055
                java.util.ArrayList<java.lang.Runnable> r2 = r1.f1273r     // Catch:{ all -> 0x01fd }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x01fd }
                if (r2 != 0) goto L_0x0055
                java.util.ArrayList<java.lang.Runnable> r2 = r1.f1273r     // Catch:{ all -> 0x01fd }
                r9 = 0
                java.lang.Object r2 = r2.remove(r9)     // Catch:{ all -> 0x01fd }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x01fd }
                r9 = r2
                r2 = 0
                goto L_0x012c
            L_0x0055:
                boolean r2 = r1.f1259d     // Catch:{ all -> 0x01fd }
                boolean r0 = r1.f1258c     // Catch:{ all -> 0x01fd }
                if (r2 == r0) goto L_0x0069
                boolean r0 = r1.f1258c     // Catch:{ all -> 0x01fd }
                boolean r2 = r1.f1258c     // Catch:{ all -> 0x01fd }
                r1.f1259d = r2     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r2.notifyAll()     // Catch:{ all -> 0x01fd }
                goto L_0x006a
            L_0x0069:
                r0 = 0
            L_0x006a:
                boolean r2 = r1.f1266k     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x0078
                r16.m1512h()     // Catch:{ all -> 0x01fd }
                r16.m1513i()     // Catch:{ all -> 0x01fd }
                r2 = 0
                r1.f1266k = r2     // Catch:{ all -> 0x01fd }
                r3 = 1
            L_0x0078:
                if (r4 == 0) goto L_0x0081
                r16.m1512h()     // Catch:{ all -> 0x01fd }
                r16.m1513i()     // Catch:{ all -> 0x01fd }
                r4 = 0
            L_0x0081:
                if (r0 == 0) goto L_0x008a
                boolean r2 = r1.f1264i     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x008a
                r16.m1512h()     // Catch:{ all -> 0x01fd }
            L_0x008a:
                if (r0 == 0) goto L_0x008e
                boolean r0 = r1.f1263h     // Catch:{ all -> 0x01fd }
            L_0x008e:
                boolean r0 = r1.f1260e     // Catch:{ all -> 0x01fd }
                if (r0 != 0) goto L_0x00aa
                boolean r0 = r1.f1262g     // Catch:{ all -> 0x01fd }
                if (r0 != 0) goto L_0x00aa
                boolean r0 = r1.f1264i     // Catch:{ all -> 0x01fd }
                if (r0 == 0) goto L_0x009d
                r16.m1512h()     // Catch:{ all -> 0x01fd }
            L_0x009d:
                r0 = 1
                r1.f1262g = r0     // Catch:{ all -> 0x01fd }
                r0 = 0
                r1.f1261f = r0     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r0.notifyAll()     // Catch:{ all -> 0x01fd }
            L_0x00aa:
                boolean r0 = r1.f1260e     // Catch:{ all -> 0x01fd }
                if (r0 == 0) goto L_0x00bc
                boolean r0 = r1.f1262g     // Catch:{ all -> 0x01fd }
                if (r0 == 0) goto L_0x00bc
                r0 = 0
                r1.f1262g = r0     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r0.notifyAll()     // Catch:{ all -> 0x01fd }
            L_0x00bc:
                if (r5 == 0) goto L_0x00cc
                r0 = 0
                r1.f1271p = r0     // Catch:{ all -> 0x01fd }
                r0 = 1
                r1.f1272q = r0     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r0.notifyAll()     // Catch:{ all -> 0x01fd }
                r5 = 0
            L_0x00cc:
                boolean r0 = r16.m1515k()     // Catch:{ all -> 0x01fd }
                if (r0 == 0) goto L_0x01f3
                boolean r0 = r1.f1263h     // Catch:{ all -> 0x01fd }
                if (r0 != 0) goto L_0x00f4
                if (r3 == 0) goto L_0x00da
                r3 = 0
                goto L_0x00f4
            L_0x00da:
                com.baidu.ar.blend.blender.a$h r0 = r1.f1275t     // Catch:{ RuntimeException -> 0x00eb }
                r0.mo9818a()     // Catch:{ RuntimeException -> 0x00eb }
                r0 = 1
                r1.f1263h = r0     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r0.notifyAll()     // Catch:{ all -> 0x01fd }
                r10 = 1
                goto L_0x00f4
            L_0x00eb:
                r0 = move-exception
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r2.mo9825b(r1)     // Catch:{ all -> 0x01fd }
                throw r0     // Catch:{ all -> 0x01fd }
            L_0x00f4:
                boolean r0 = r1.f1263h     // Catch:{ all -> 0x01fd }
                if (r0 == 0) goto L_0x0103
                boolean r0 = r1.f1264i     // Catch:{ all -> 0x01fd }
                if (r0 != 0) goto L_0x0103
                r0 = 1
                r1.f1264i = r0     // Catch:{ all -> 0x01fd }
                r0 = 1
                r12 = 1
                r13 = 1
                goto L_0x0104
            L_0x0103:
                r0 = r11
            L_0x0104:
                boolean r2 = r1.f1264i     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x01f2
                boolean r2 = r1.f1274s     // Catch:{ all -> 0x01fd }
                if (r2 == 0) goto L_0x011a
                int r7 = r1.f1267l     // Catch:{ all -> 0x01fd }
                int r8 = r1.f1268m     // Catch:{ all -> 0x01fd }
                r0 = 1
                r1.f1271p = r0     // Catch:{ all -> 0x01fd }
                r0 = 0
                r1.f1274s = r0     // Catch:{ all -> 0x01fd }
                r0 = 1
                r2 = 0
                r13 = 1
                goto L_0x011b
            L_0x011a:
                r2 = 0
            L_0x011b:
                r1.f1270o = r2     // Catch:{ all -> 0x01fd }
                com.baidu.ar.blend.blender.a$i r11 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r11.notifyAll()     // Catch:{ all -> 0x01fd }
                boolean r11 = r1.f1271p     // Catch:{ all -> 0x01fd }
                if (r11 == 0) goto L_0x012b
                r11 = r0
                r14 = 1
                goto L_0x012c
            L_0x012b:
                r11 = r0
            L_0x012c:
                monitor-exit(r15)     // Catch:{ all -> 0x01fd }
                if (r9 == 0) goto L_0x0136
                r9.run()     // Catch:{ all -> 0x0200 }
                r0 = 0
                r9 = 0
                goto L_0x001e
            L_0x0136:
                if (r11 == 0) goto L_0x016c
                com.baidu.ar.blend.blender.a$h r0 = r1.f1275t     // Catch:{ all -> 0x0200 }
                boolean r0 = r0.mo9819b()     // Catch:{ all -> 0x0200 }
                if (r0 == 0) goto L_0x0155
                com.baidu.ar.blend.blender.a$i r11 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0200 }
                monitor-enter(r11)     // Catch:{ all -> 0x0200 }
                r0 = 1
                r1.f1265j = r0     // Catch:{ all -> 0x0152 }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0152 }
                r0.notifyAll()     // Catch:{ all -> 0x0152 }
                monitor-exit(r11)     // Catch:{ all -> 0x0152 }
                r11 = 0
                goto L_0x016c
            L_0x0152:
                r0 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x0152 }
                throw r0     // Catch:{ all -> 0x0200 }
            L_0x0155:
                com.baidu.ar.blend.blender.a$i r15 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0200 }
                monitor-enter(r15)     // Catch:{ all -> 0x0200 }
                r0 = 1
                r1.f1265j = r0     // Catch:{ all -> 0x0169 }
                r1.f1261f = r0     // Catch:{ all -> 0x0169 }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0169 }
                r0.notifyAll()     // Catch:{ all -> 0x0169 }
                monitor-exit(r15)     // Catch:{ all -> 0x0169 }
                goto L_0x01ef
            L_0x0169:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0169 }
                throw r0     // Catch:{ all -> 0x0200 }
            L_0x016c:
                if (r12 == 0) goto L_0x0178
                com.baidu.ar.blend.blender.a$h r0 = r1.f1275t     // Catch:{ all -> 0x0200 }
                javax.microedition.khronos.opengles.GL r0 = r0.mo9820c()     // Catch:{ all -> 0x0200 }
                javax.microedition.khronos.opengles.GL10 r0 = (javax.microedition.khronos.opengles.GL10) r0     // Catch:{ all -> 0x0200 }
                r6 = r0
                r12 = 0
            L_0x0178:
                if (r10 == 0) goto L_0x0190
                java.lang.ref.WeakReference<com.baidu.ar.blend.blender.a> r0 = r1.f1276u     // Catch:{ all -> 0x0200 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a r0 = (com.baidu.p020ar.blend.blender.C0642a) r0     // Catch:{ all -> 0x0200 }
                if (r0 == 0) goto L_0x018f
                android.opengl.GLSurfaceView$Renderer r0 = r0.f1240b     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a$h r10 = r1.f1275t     // Catch:{ all -> 0x0200 }
                javax.microedition.khronos.egl.EGLConfig r10 = r10.f1280d     // Catch:{ all -> 0x0200 }
                r0.onSurfaceCreated(r6, r10)     // Catch:{ all -> 0x0200 }
            L_0x018f:
                r10 = 0
            L_0x0190:
                if (r13 == 0) goto L_0x01a4
                java.lang.ref.WeakReference<com.baidu.ar.blend.blender.a> r0 = r1.f1276u     // Catch:{ all -> 0x0200 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a r0 = (com.baidu.p020ar.blend.blender.C0642a) r0     // Catch:{ all -> 0x0200 }
                if (r0 == 0) goto L_0x01a3
                android.opengl.GLSurfaceView$Renderer r0 = r0.f1240b     // Catch:{ all -> 0x0200 }
                r0.onSurfaceChanged(r6, r7, r8)     // Catch:{ all -> 0x0200 }
            L_0x01a3:
                r13 = 0
            L_0x01a4:
                java.lang.ref.WeakReference<com.baidu.ar.blend.blender.a> r0 = r1.f1276u     // Catch:{ all -> 0x0200 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a r0 = (com.baidu.p020ar.blend.blender.C0642a) r0     // Catch:{ all -> 0x0200 }
                if (r0 == 0) goto L_0x01e5
                boolean r15 = r0.f1241c     // Catch:{ all -> 0x0200 }
                if (r15 == 0) goto L_0x01e7
                android.opengl.GLSurfaceView$Renderer r0 = r0.f1240b     // Catch:{ all -> 0x0200 }
                r0.onDrawFrame(r6)     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a$h r0 = r1.f1275t     // Catch:{ all -> 0x0200 }
                int r0 = r0.mo9821d()     // Catch:{ all -> 0x0200 }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r15) goto L_0x01e5
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r15) goto L_0x01e4
                java.lang.String r15 = "GLThread"
                java.lang.String r2 = "eglSwapBuffers"
                com.baidu.p020ar.blend.blender.C0642a.C0651h.m1528a(r15, r2, r0)     // Catch:{ all -> 0x0200 }
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0200 }
                monitor-enter(r2)     // Catch:{ all -> 0x0200 }
                r0 = 1
                r1.f1261f = r0     // Catch:{ all -> 0x01e1 }
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01e1 }
                r0.notifyAll()     // Catch:{ all -> 0x01e1 }
                monitor-exit(r2)     // Catch:{ all -> 0x01e1 }
                goto L_0x01e5
            L_0x01e1:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01e1 }
                throw r0     // Catch:{ all -> 0x0200 }
            L_0x01e4:
                r4 = 1
            L_0x01e5:
                r2 = 1
                goto L_0x01eb
            L_0x01e7:
                r2 = 1
                boolean unused = r0.f1241c = r2     // Catch:{ all -> 0x0200 }
            L_0x01eb:
                if (r14 == 0) goto L_0x01ef
                r5 = 1
                r14 = 0
            L_0x01ef:
                r0 = 0
                goto L_0x001e
            L_0x01f2:
                r11 = r0
            L_0x01f3:
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x01fd }
                r0.wait()     // Catch:{ all -> 0x01fd }
                r0 = 0
                goto L_0x0023
            L_0x01fd:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x01fd }
                throw r0     // Catch:{ all -> 0x0200 }
            L_0x0200:
                r0 = move-exception
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r2)
                r16.m1512h()     // Catch:{ all -> 0x020e }
                r16.m1513i()     // Catch:{ all -> 0x020e }
                monitor-exit(r2)     // Catch:{ all -> 0x020e }
                throw r0
            L_0x020e:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x020e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.m1514j():void");
        }

        /* renamed from: k */
        private boolean m1515k() {
            return !this.f1259d && this.f1260e && !this.f1261f && this.f1267l > 0 && this.f1268m > 0 && (this.f1270o || this.f1269n == 1);
        }

        /* renamed from: a */
        public void mo9807a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (C0642a.f1238d) {
                this.f1269n = i;
                C0642a.f1238d.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003a */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9808a(int r2, int r3) {
            /*
                r1 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1.f1267l = r2     // Catch:{ all -> 0x0044 }
                r1.f1268m = r3     // Catch:{ all -> 0x0044 }
                r2 = 1
                r1.f1274s = r2     // Catch:{ all -> 0x0044 }
                r1.f1270o = r2     // Catch:{ all -> 0x0044 }
                r2 = 0
                r1.f1272q = r2     // Catch:{ all -> 0x0044 }
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                if (r2 != r1) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0019:
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0044 }
                r2.notifyAll()     // Catch:{ all -> 0x0044 }
            L_0x0020:
                boolean r2 = r1.f1257b     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.f1259d     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.f1272q     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.mo9810a()     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0042
                com.baidu.ar.blend.blender.a$i r2 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x003a }
                r2.wait()     // Catch:{ InterruptedException -> 0x003a }
                goto L_0x0020
            L_0x003a:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                r2.interrupt()     // Catch:{ all -> 0x0044 }
                goto L_0x0020
            L_0x0042:
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0044:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9808a(int, int):void");
        }

        /* renamed from: a */
        public void mo9809a(Runnable runnable) {
            if (runnable != null) {
                synchronized (C0642a.f1238d) {
                    this.f1273r.add(runnable);
                    C0642a.f1238d.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* renamed from: a */
        public boolean mo9810a() {
            return this.f1263h && this.f1264i && m1515k();
        }

        /* renamed from: b */
        public void mo9811b() {
            synchronized (C0642a.f1238d) {
                this.f1270o = true;
                C0642a.f1238d.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9812c() {
            /*
                r2 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1 = 1
                r2.f1260e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.f1265j = r1     // Catch:{ all -> 0x0030 }
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.f1262g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.f1265j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.f1257b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9812c():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9813d() {
            /*
                r2 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1 = 0
                r2.f1260e = r1     // Catch:{ all -> 0x0029 }
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f1262g     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f1257b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9813d():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9814e() {
            /*
                r2 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1 = 1
                r2.f1258c = r1     // Catch:{ all -> 0x0029 }
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f1257b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f1259d     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9814e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9815f() {
            /*
                r3 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1 = 0
                r3.f1258c = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.f1270o = r2     // Catch:{ all -> 0x0032 }
                r3.f1272q = r1     // Catch:{ all -> 0x0032 }
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.f1257b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.f1259d     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.f1272q     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9815f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* renamed from: g */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo9816g() {
            /*
                r2 = this;
                com.baidu.ar.blend.blender.a$i r0 = com.baidu.p020ar.blend.blender.C0642a.f1238d
                monitor-enter(r0)
                r1 = 1
                r2.f1256a = r1     // Catch:{ all -> 0x0025 }
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f1257b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.baidu.ar.blend.blender.a$i r1 = com.baidu.p020ar.blend.blender.C0642a.f1238d     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0642a.C0650g.mo9816g():void");
        }

        public void run() {
            setName("ARGLThread " + getId());
            try {
                m1514j();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                C0642a.f1238d.mo9824a(this);
                throw th;
            }
            C0642a.f1238d.mo9824a(this);
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.a$h */
    private static class C0651h {

        /* renamed from: a */
        EGL10 f1277a;

        /* renamed from: b */
        EGLDisplay f1278b;

        /* renamed from: c */
        EGLSurface f1279c;

        /* renamed from: d */
        EGLConfig f1280d;

        /* renamed from: e */
        EGLContext f1281e;

        /* renamed from: f */
        private WeakReference<C0642a> f1282f;

        public C0651h(WeakReference<C0642a> weakReference) {
            this.f1282f = weakReference;
        }

        /* renamed from: a */
        private void m1526a(String str) {
            m1527a(str, this.f1277a.eglGetError());
        }

        /* renamed from: a */
        public static void m1527a(String str, int i) {
            throw new RuntimeException(m1529b(str, i));
        }

        /* renamed from: a */
        public static void m1528a(String str, String str2, int i) {
            Log.w(str, m1529b(str2, i));
        }

        /* renamed from: b */
        public static String m1529b(String str, int i) {
            return str + " failed: " + i;
        }

        /* renamed from: g */
        private void m1530g() {
            if (this.f1279c != null && this.f1279c != EGL10.EGL_NO_SURFACE) {
                this.f1277a.eglMakeCurrent(this.f1278b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                C0642a aVar = (C0642a) this.f1282f.get();
                if (aVar != null) {
                    aVar.f1246i.mo9806a(this.f1277a, this.f1278b, this.f1279c);
                }
                this.f1279c = null;
            }
        }

        /* renamed from: a */
        public void mo9818a() {
            this.f1277a = (EGL10) EGLContext.getEGL();
            this.f1278b = this.f1277a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f1278b != EGL10.EGL_NO_DISPLAY) {
                if (this.f1277a.eglInitialize(this.f1278b, new int[2])) {
                    C0642a aVar = (C0642a) this.f1282f.get();
                    if (aVar == null) {
                        this.f1280d = null;
                        this.f1281e = null;
                    } else {
                        this.f1280d = aVar.f1244g.mo9801a(this.f1277a, this.f1278b);
                        this.f1281e = aVar.f1245h.mo9803a(this.f1277a, this.f1278b, this.f1280d);
                        long unused = aVar.f1239a = Thread.currentThread().getId();
                    }
                    if (this.f1281e == null || this.f1281e == EGL10.EGL_NO_CONTEXT) {
                        this.f1281e = null;
                        m1526a("createContext");
                    }
                    this.f1279c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        /* renamed from: b */
        public boolean mo9819b() {
            if (this.f1277a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f1278b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f1280d != null) {
                m1530g();
                C0642a aVar = (C0642a) this.f1282f.get();
                this.f1279c = (aVar == null || aVar.f1242e == null) ? null : aVar.f1246i.mo9805a(this.f1277a, this.f1278b, this.f1280d, aVar.f1242e);
                if (this.f1279c == null || this.f1279c == EGL10.EGL_NO_SURFACE) {
                    if (this.f1277a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.f1277a.eglMakeCurrent(this.f1278b, this.f1279c, this.f1279c, this.f1281e)) {
                    return true;
                } else {
                    m1528a("EGLHelper", "eglMakeCurrent", this.f1277a.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public GL mo9820c() {
            return this.f1281e.getGL();
        }

        /* renamed from: d */
        public int mo9821d() {
            if (!this.f1277a.eglSwapBuffers(this.f1278b, this.f1279c)) {
                return this.f1277a.eglGetError();
            }
            return 12288;
        }

        /* renamed from: e */
        public void mo9822e() {
            m1530g();
        }

        /* renamed from: f */
        public void mo9823f() {
            if (this.f1281e != null) {
                C0642a aVar = (C0642a) this.f1282f.get();
                if (aVar != null) {
                    aVar.f1245h.mo9804a(this.f1277a, this.f1278b, this.f1281e);
                    long unused = aVar.f1239a = -1;
                }
                this.f1281e = null;
            }
            if (this.f1278b != null) {
                this.f1277a.eglTerminate(this.f1278b);
                this.f1278b = null;
            }
        }
    }

    /* renamed from: com.baidu.ar.blend.blender.a$i */
    private static class C0652i {

        /* renamed from: a */
        private static String f1283a = "GLThreadManager";

        /* renamed from: b */
        private C0650g f1284b;

        private C0652i() {
        }

        /* renamed from: a */
        public synchronized void mo9824a(C0650g gVar) {
            boolean unused = gVar.f1257b = true;
            if (this.f1284b == gVar) {
                this.f1284b = null;
            }
            notifyAll();
        }

        /* renamed from: b */
        public void mo9825b(C0650g gVar) {
            if (this.f1284b == gVar) {
                this.f1284b = null;
            }
            notifyAll();
        }
    }

    /* renamed from: a */
    public void mo9789a() {
        if (this.f1243f != null) {
            this.f1243f.mo9811b();
        }
    }

    /* renamed from: a */
    public void mo9790a(int i) {
        if (this.f1243f != null) {
            this.f1243f.mo9807a(i);
        }
    }

    /* renamed from: a */
    public void mo9791a(GLSurfaceView.Renderer renderer) {
        if (this.f1244g == null) {
            this.f1244g = new C0644a(8, 8, 8, 8, 16, 0);
        }
        if (this.f1245h == null) {
            this.f1245h = new C0645b();
        }
        if (this.f1246i == null) {
            this.f1246i = new C0646c();
        }
        this.f1240b = renderer;
        this.f1243f = new C0650g(this.f1247j);
        this.f1243f.start();
    }

    /* renamed from: a */
    public void mo9792a(Object obj, int i, int i2) {
        this.f1242e = obj;
        if (Build.VERSION.SDK_INT >= 15 && this.f1242e != null && (this.f1242e instanceof SurfaceTexture)) {
            ((SurfaceTexture) this.f1242e).setDefaultBufferSize(i, i2);
        }
        if (this.f1243f == null) {
            return;
        }
        if (this.f1242e != null) {
            this.f1243f.mo9812c();
            this.f1243f.mo9808a(i, i2);
            return;
        }
        this.f1243f.mo9813d();
    }

    /* renamed from: a */
    public void mo9793a(Runnable runnable) {
        if (this.f1243f != null) {
            this.f1243f.mo9809a(runnable);
        }
    }

    /* renamed from: b */
    public void mo9794b() {
        if (this.f1243f != null) {
            this.f1243f.mo9814e();
        }
    }

    /* renamed from: c */
    public void mo9795c() {
        if (this.f1243f != null) {
            this.f1243f.mo9815f();
        }
    }

    /* renamed from: d */
    public void mo9796d() {
        if (this.f1243f != null) {
            this.f1243f.mo9816g();
        }
        Log.e("EngineLogger", "exitGLThread()");
    }

    /* renamed from: e */
    public boolean mo9797e() {
        return this.f1243f != null && this.f1243f.f1263h;
    }

    /* renamed from: f */
    public EGLContext mo9798f() {
        if (this.f1243f == null || this.f1243f.f1275t == null) {
            return null;
        }
        return this.f1243f.f1275t.f1281e;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.f1243f != null) {
                this.f1243f.mo9816g();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: g */
    public EGLConfig mo9800g() {
        if (this.f1243f == null || this.f1243f.f1275t == null) {
            return null;
        }
        return this.f1243f.f1275t.f1280d;
    }
}
