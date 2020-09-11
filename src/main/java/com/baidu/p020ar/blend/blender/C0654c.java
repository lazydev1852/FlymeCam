package com.baidu.p020ar.blend.blender;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.blend.filter.C0674a;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;
import com.baidu.p020ar.blend.p036a.C0630a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.baidu.ar.blend.blender.c */
public class C0654c {

    /* renamed from: a */
    static int f1339a = 0;

    /* renamed from: b */
    static int f1340b = 0;

    /* renamed from: c */
    static byte[] f1341c = null;

    /* renamed from: d */
    private static final String f1342d = "c";

    /* renamed from: h */
    private static int f1343h;

    /* renamed from: e */
    private boolean f1344e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0671d f1345f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0653b f1346g;

    /* renamed from: i */
    private boolean f1347i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0670e f1348j;

    /* renamed from: k */
    private C0674a f1349k;

    /* renamed from: l */
    private C0667b f1350l;

    /* renamed from: com.baidu.ar.blend.blender.c$a */
    public interface C0666a {
        /* renamed from: a */
        void mo9871a();
    }

    /* renamed from: com.baidu.ar.blend.blender.c$b */
    public interface C0667b {
        /* renamed from: a */
        void mo9872a(C0674a aVar);
    }

    /* renamed from: com.baidu.ar.blend.blender.c$c */
    public interface C0668c {
        /* renamed from: a */
        void mo9505a();

        /* renamed from: a */
        void mo9506a(int i);

        /* renamed from: a */
        void mo9509a(EGLContext eGLContext, int i, int i2);

        /* renamed from: b */
        void mo9510b();
    }

    /* renamed from: com.baidu.ar.blend.blender.c$d */
    public interface C0669d {
        /* renamed from: a */
        void mo9550a(int[] iArr, int i, int i2);
    }

    /* renamed from: com.baidu.ar.blend.blender.c$e */
    private static class C0670e {

        /* renamed from: a */
        int f1375a = 0;

        /* renamed from: b */
        int f1376b = 0;

        /* renamed from: c */
        boolean f1377c = false;

        /* renamed from: d */
        private boolean f1378d = true;

        /* renamed from: e */
        private boolean f1379e = true;

        /* renamed from: f */
        private C0630a f1380f;

        C0670e(boolean z, boolean z2) {
            this.f1378d = z;
            this.f1379e = z2;
        }

        /* renamed from: a */
        public void mo9873a(int i, int i2) {
            if (!(this.f1375a == i && this.f1376b == i2)) {
                this.f1377c = true;
            }
            this.f1375a = i;
            this.f1376b = i2;
        }

        /* renamed from: a */
        public void mo9874a(EGLContext eGLContext, EGLConfig eGLConfig) {
            if (this.f1380f == null) {
                this.f1380f = new C0630a(eGLContext, eGLConfig);
                this.f1380f.mo9741a(this.f1378d, this.f1379e);
                ARPEngine.getInstance().setArEngineCtl(this.f1380f);
                ARPEngine.getInstance().onResume();
                ARPEngine.getInstance().setEnginGLJniEnv();
            }
            if (this.f1377c) {
                this.f1380f.mo9740a(this.f1375a, this.f1376b);
                ARPEngine.getInstance().setSize(this.f1375a, this.f1376b);
                this.f1377c = false;
            }
        }

        /* renamed from: a */
        public boolean mo9875a() {
            return this.f1377c;
        }

        /* renamed from: b */
        public void mo9876b() {
            if (this.f1380f != null) {
                this.f1380f.mo9748i();
            }
        }

        /* renamed from: c */
        public C0630a mo9877c() {
            return this.f1380f;
        }
    }

    public C0654c() {
        this.f1344e = false;
        this.f1346g = null;
        this.f1347i = false;
        this.f1346g = new C0653b();
        this.f1345f = new C0671d(this.f1346g);
        this.f1345f.mo9878a();
        this.f1349k = m1583j();
    }

    /* renamed from: a */
    private void m1575a(C0674a aVar) {
        if (aVar != null) {
            this.f1349k = aVar;
            final List<C0712g> c = aVar.mo9900c();
            final List<C0712g> d = aVar.mo9906d();
            final List<C0712g> e = aVar.mo9910e();
            this.f1345f.mo9881a((Runnable) new Runnable() {
                public void run() {
                    C0654c.this.f1346g.mo9833a((List<C0712g>) c);
                    C0654c.this.f1346g.mo9837b((List<C0712g>) d);
                    C0654c.this.f1346g.mo9838c(e);
                }
            });
            if (this.f1350l != null) {
                this.f1350l.mo9872a(this.f1349k);
            }
        }
    }

    /* renamed from: a */
    private void m1576a(Object obj, int i, int i2) {
        if (this.f1345f != null) {
            this.f1345f.mo9880a(obj, i, i2);
        }
    }

    /* renamed from: b */
    private static void m1578b(int i) {
        f1343h = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m1579b(byte[] r2, int r3, int r4) {
        /*
            java.lang.Class<com.baidu.ar.blend.blender.c> r0 = com.baidu.p020ar.blend.blender.C0654c.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x0030
            int r1 = r2.length     // Catch:{ all -> 0x002d }
            if (r1 > 0) goto L_0x0009
            goto L_0x0030
        L_0x0009:
            int r1 = f1339a     // Catch:{ all -> 0x002d }
            if (r1 == r3) goto L_0x000f
            f1339a = r3     // Catch:{ all -> 0x002d }
        L_0x000f:
            int r3 = f1340b     // Catch:{ all -> 0x002d }
            if (r3 == r4) goto L_0x0015
            f1340b = r4     // Catch:{ all -> 0x002d }
        L_0x0015:
            byte[] r3 = f1341c     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x001f
            byte[] r3 = f1341c     // Catch:{ all -> 0x002d }
            int r3 = r3.length     // Catch:{ all -> 0x002d }
            int r4 = r2.length     // Catch:{ all -> 0x002d }
            if (r3 == r4) goto L_0x0024
        L_0x001f:
            int r3 = r2.length     // Catch:{ all -> 0x002d }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x002d }
            f1341c = r3     // Catch:{ all -> 0x002d }
        L_0x0024:
            byte[] r3 = f1341c     // Catch:{ all -> 0x002d }
            int r4 = r2.length     // Catch:{ all -> 0x002d }
            r1 = 0
            java.lang.System.arraycopy(r2, r1, r3, r1, r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)
            return
        L_0x002d:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0030:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.blender.C0654c.m1579b(byte[], int, int):void");
    }

    /* renamed from: h */
    public static synchronized void m1581h() {
        synchronized (C0654c.class) {
            f1341c = null;
        }
    }

    /* renamed from: i */
    private void m1582i() {
        if (this.f1348j != null) {
            this.f1345f.mo9881a((Runnable) new Runnable() {
                public void run() {
                    if (C0654c.this.f1345f.mo9885e().mo9797e() && C0654c.this.f1348j != null) {
                        if (C0654c.this.f1348j.mo9875a()) {
                            C0654c.this.f1348j.mo9876b();
                            C0654c.this.f1346g.mo9826a();
                        }
                        C0654c.this.f1348j.mo9874a(C0654c.this.f1345f.mo9885e().mo9798f(), C0654c.this.f1345f.mo9885e().mo9800g());
                        C0654c.this.f1346g.mo9829a(C0654c.this.f1348j.mo9877c());
                    }
                }
            });
        }
    }

    /* renamed from: j */
    private C0674a m1583j() {
        C0674a aVar = new C0674a();
        aVar.mo9888a(0);
        aVar.mo9893a(true);
        aVar.mo9899b(true);
        aVar.mo9905c(true);
        aVar.mo9909d(true);
        HashMap hashMap = new HashMap();
        hashMap.put(0, new C0712g());
        aVar.mo9908d((Map<Integer, C0712g>) hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(0, new C0712g());
        aVar.mo9912e((Map<Integer, C0712g>) hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(0, new C0712g());
        aVar.mo9915f((Map<Integer, C0712g>) hashMap3);
        return aVar;
    }

    /* renamed from: a */
    public void mo9842a() {
        this.f1344e = true;
    }

    /* renamed from: a */
    public void mo9843a(int i) {
        m1578b(i);
        if (this.f1346g != null) {
            this.f1346g.mo9827a(i);
        }
    }

    /* renamed from: a */
    public void mo9844a(SurfaceTexture surfaceTexture, int i, int i2) {
        m1576a((Object) surfaceTexture, i, i2);
        if (this.f1348j != null) {
            this.f1348j.mo9873a(i, i2);
        }
        if (this.f1347i) {
            m1582i();
        }
    }

    /* renamed from: a */
    public void mo9845a(final SurfaceTexture surfaceTexture, final TextureParams textureParams) {
        try {
            if (Build.VERSION.SDK_INT >= 16 && surfaceTexture != null) {
                surfaceTexture.detachFromGLContext();
            }
        } catch (RuntimeException unused) {
            Log.e(f1342d, "detachFromGLContext error");
        }
        Log.i(f1342d, "setupSource ");
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                C0654c.this.f1346g.mo9828a(surfaceTexture);
                C0654c.this.f1346g.mo9830a(textureParams);
            }
        });
    }

    /* renamed from: a */
    public void mo9846a(final TextureParams textureParams) {
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                C0654c.this.f1346g.mo9830a(textureParams);
            }
        });
    }

    /* renamed from: a */
    public void mo9847a(final C0668c cVar) {
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                C0654c.this.f1346g.mo9831a(cVar);
                cVar.mo9505a();
            }
        });
    }

    /* renamed from: a */
    public void mo9848a(final C0669d dVar) {
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                if (C0654c.this.f1346g != null) {
                    C0654c.this.f1346g.mo9832a(dVar);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9849a(C0674a aVar, String str) {
        C0671d dVar;
        Runnable r0;
        boolean z = aVar != null;
        if (!z) {
            aVar = this.f1349k;
        }
        if (aVar != null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("reality_target")) {
                    final List<C0712g> c = aVar.mo9900c();
                    if (z) {
                        this.f1349k.mo9908d(aVar.mo9919i());
                    }
                    dVar = this.f1345f;
                    r0 = new Runnable() {
                        public void run() {
                            C0654c.this.f1346g.mo9833a((List<C0712g>) c);
                        }
                    };
                } else if (str.equals("virtual_target")) {
                    final List<C0712g> d = aVar.mo9906d();
                    if (z) {
                        this.f1349k.mo9912e(aVar.mo9920j());
                    }
                    dVar = this.f1345f;
                    r0 = new Runnable() {
                        public void run() {
                            C0654c.this.f1346g.mo9837b((List<C0712g>) d);
                        }
                    };
                } else if (str.equals("mix_target")) {
                    final List<C0712g> e = aVar.mo9910e();
                    if (z) {
                        this.f1349k.mo9915f(aVar.mo9921k());
                    }
                    dVar = this.f1345f;
                    r0 = new Runnable() {
                        public void run() {
                            C0654c.this.f1346g.mo9838c(e);
                        }
                    };
                }
                dVar.mo9881a(r0);
                return;
            }
            m1575a(aVar);
        }
    }

    /* renamed from: a */
    public void mo9850a(final boolean z) {
        if (z) {
            m1582i();
        }
        this.f1347i = z;
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                if (C0654c.this.f1346g != null) {
                    C0654c.this.f1346g.mo9834a(z);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9851a(boolean z, boolean z2) {
        this.f1348j = new C0670e(z, z2);
    }

    /* renamed from: a */
    public void mo9852a(byte[] bArr, int i, int i2) {
        if (this.f1346g != null) {
            this.f1346g.mo9835a(bArr, i, i2);
        }
    }

    /* renamed from: b */
    public void mo9853b() {
        this.f1344e = false;
    }

    /* renamed from: b */
    public void mo9854b(final C0668c cVar) {
        this.f1345f.mo9881a((Runnable) new Runnable() {
            public void run() {
                cVar.mo9510b();
                C0654c.this.f1346g.mo9831a((C0668c) null);
            }
        });
    }

    /* renamed from: c */
    public void mo9855c() {
        if (!(this.f1348j == null || this.f1348j.mo9877c() == null)) {
            this.f1348j.mo9877c().mo9747h();
        }
        if (this.f1345f != null) {
            this.f1345f.mo9883c();
        }
    }

    /* renamed from: d */
    public C0671d mo9856d() {
        return this.f1345f;
    }

    /* renamed from: e */
    public boolean mo9857e() {
        return this.f1347i;
    }

    /* renamed from: f */
    public void mo9858f() {
        m1575a(m1583j());
    }

    /* renamed from: g */
    public C0674a mo9859g() {
        return this.f1349k;
    }
}
