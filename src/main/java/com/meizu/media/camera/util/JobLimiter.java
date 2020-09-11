package com.meizu.media.camera.util;

import android.util.Log;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.LinkedList;

/* renamed from: com.meizu.media.camera.util.ab */
public class JobLimiter implements FutureListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f14061a;

    /* renamed from: b */
    private final LinkedList<C2629a<?>> f14062b = new LinkedList<>();

    /* renamed from: c */
    private final ThreadPool f14063c;

    /* renamed from: d */
    private int f14064d;

    public JobLimiter(ThreadPool aqVar, int i) {
        this.f14063c = aqVar;
        this.f14064d = i;
    }

    /* renamed from: a */
    public static void m15934a(Object obj) {
        if (!PatchProxy.proxy(new Object[]{obj}, (Object) null, f14061a, true, 8107, new Class[]{Object.class}, Void.TYPE).isSupported) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                Log.w("JobLimiter", "unexpected interrupt: " + obj);
            }
        }
    }

    /* renamed from: a */
    public synchronized <T> Future<T> mo22652a(ThreadPool.C2637b<T> bVar, FutureListener<T> wVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar, wVar}, this, f14061a, false, 8108, new Class[]{ThreadPool.C2637b.class, FutureListener.class}, Future.class);
        if (proxy.isSupported) {
            return (Future) proxy.result;
        }
        C2629a aVar = new C2629a(bVar, wVar);
        this.f14062b.addLast(aVar);
        m15933a();
        return aVar;
    }

    /* renamed from: a */
    private void m15933a() {
        if (!PatchProxy.proxy(new Object[0], this, f14061a, false, 8109, new Class[0], Void.TYPE).isSupported) {
            while (this.f14064d > 0 && !this.f14062b.isEmpty()) {
                C2629a removeFirst = this.f14062b.removeFirst();
                if (!removeFirst.mo22656b()) {
                    this.f14064d--;
                    removeFirst.mo22654a(this.f14063c.mo22678a(removeFirst, this));
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo18710a(Future vVar) {
        if (!PatchProxy.proxy(new Object[]{vVar}, this, f14061a, false, 8110, new Class[]{Future.class}, Void.TYPE).isSupported) {
            this.f14064d++;
            m15933a();
        }
    }

    /* renamed from: com.meizu.media.camera.util.ab$a */
    /* compiled from: JobLimiter */
    private static class C2629a<T> implements ThreadPool.C2637b<T>, Future<T> {

        /* renamed from: a */
        public static ChangeQuickRedirect f14065a;

        /* renamed from: b */
        private int f14066b = 0;

        /* renamed from: c */
        private ThreadPool.C2637b<T> f14067c;

        /* renamed from: d */
        private Future<T> f14068d;

        /* renamed from: e */
        private FutureListener<T> f14069e;

        /* renamed from: f */
        private T f14070f;

        public C2629a(ThreadPool.C2637b<T> bVar, FutureListener<T> wVar) {
            this.f14067c = bVar;
            this.f14069e = wVar;
        }

        /* renamed from: a */
        public synchronized void mo22654a(Future<T> vVar) {
            if (this.f14066b == 0) {
                this.f14068d = vVar;
            }
        }

        /* renamed from: a */
        public void mo22653a() {
            FutureListener<T> wVar;
            if (!PatchProxy.proxy(new Object[0], this, f14065a, false, 8111, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    if (this.f14066b != 1) {
                        wVar = this.f14069e;
                        this.f14067c = null;
                        this.f14069e = null;
                        if (this.f14068d != null) {
                            this.f14068d.mo22653a();
                            this.f14068d = null;
                        }
                    } else {
                        wVar = null;
                    }
                    this.f14066b = 2;
                    this.f14070f = null;
                    notifyAll();
                }
                if (wVar != null) {
                    wVar.mo18710a(this);
                }
            }
        }

        /* renamed from: b */
        public synchronized boolean mo22656b() {
            return this.f14066b == 2;
        }

        /* renamed from: c */
        public synchronized T mo22657c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14065a, false, 8112, new Class[0], Object.class);
            if (proxy.isSupported) {
                return (Object) proxy.result;
            }
            while (this.f14066b == 0) {
                JobLimiter.m15934a((Object) this);
            }
            return this.f14070f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r9 = r1.mo22655b(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
            android.util.Log.w("JobLimiter", "error executing job: " + r1, r9);
            r9 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
            if (r0 == null) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
            r0.mo18710a(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
            return r9;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T mo22655b(com.meizu.media.camera.util.ThreadPool.C2638c r9) {
            /*
                r8 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r9
                com.meizu.savior.ChangeQuickRedirect r3 = f14065a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<com.meizu.media.camera.util.aq$c> r4 = com.meizu.media.camera.util.ThreadPool.C2638c.class
                r6[r2] = r4
                java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
                r4 = 0
                r5 = 8114(0x1fb2, float:1.137E-41)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r2 = r1.isSupported
                if (r2 == 0) goto L_0x0021
                java.lang.Object r9 = r1.result
                java.lang.Object r9 = (java.lang.Object) r9
                return r9
            L_0x0021:
                monitor-enter(r8)
                int r1 = r8.f14066b     // Catch:{ all -> 0x0068 }
                r2 = 2
                r3 = 0
                if (r1 != r2) goto L_0x002a
                monitor-exit(r8)     // Catch:{ all -> 0x0068 }
                return r3
            L_0x002a:
                com.meizu.media.camera.util.aq$b<T> r1 = r8.f14067c     // Catch:{ all -> 0x0068 }
                monitor-exit(r8)     // Catch:{ all -> 0x0068 }
                java.lang.Object r9 = r1.mo22655b(r9)     // Catch:{ Throwable -> 0x0032 }
                goto L_0x004a
            L_0x0032:
                r9 = move-exception
                java.lang.String r4 = "JobLimiter"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "error executing job: "
                r5.append(r6)
                r5.append(r1)
                java.lang.String r1 = r5.toString()
                android.util.Log.w(r4, r1, r9)
                r9 = r3
            L_0x004a:
                monitor-enter(r8)
                int r1 = r8.f14066b     // Catch:{ all -> 0x0065 }
                if (r1 != r2) goto L_0x0051
                monitor-exit(r8)     // Catch:{ all -> 0x0065 }
                return r3
            L_0x0051:
                r8.f14066b = r0     // Catch:{ all -> 0x0065 }
                com.meizu.media.camera.util.w<T> r0 = r8.f14069e     // Catch:{ all -> 0x0065 }
                r8.f14069e = r3     // Catch:{ all -> 0x0065 }
                r8.f14067c = r3     // Catch:{ all -> 0x0065 }
                r8.f14070f = r9     // Catch:{ all -> 0x0065 }
                r8.notifyAll()     // Catch:{ all -> 0x0065 }
                monitor-exit(r8)     // Catch:{ all -> 0x0065 }
                if (r0 == 0) goto L_0x0064
                r0.mo18710a(r8)
            L_0x0064:
                return r9
            L_0x0065:
                r9 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0065 }
                throw r9
            L_0x0068:
                r9 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0068 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.JobLimiter.C2629a.mo22655b(com.meizu.media.camera.util.aq$c):java.lang.Object");
        }
    }
}
