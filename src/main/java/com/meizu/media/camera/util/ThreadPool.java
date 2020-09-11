package com.meizu.media.camera.util;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.meizu.media.camera.util.aq */
public class ThreadPool {

    /* renamed from: a */
    public static ChangeQuickRedirect f14124a;

    /* renamed from: b */
    public static final C2638c f14125b = new C2639d();

    /* renamed from: e */
    private static ThreadPool f14126e;

    /* renamed from: c */
    C2640e f14127c = new C2640e(2);

    /* renamed from: d */
    C2640e f14128d = new C2640e(2);

    /* renamed from: f */
    private final Executor f14129f = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("thread-pool", 10));

    /* renamed from: com.meizu.media.camera.util.aq$a */
    /* compiled from: ThreadPool */
    public interface C2636a {
        /* renamed from: a */
        void mo22679a();
    }

    /* renamed from: com.meizu.media.camera.util.aq$b */
    /* compiled from: ThreadPool */
    public interface C2637b<T> {
        /* renamed from: b */
        T mo22655b(C2638c cVar);
    }

    /* renamed from: com.meizu.media.camera.util.aq$c */
    /* compiled from: ThreadPool */
    public interface C2638c {
        /* renamed from: a */
        void mo22680a(C2636a aVar);

        /* renamed from: a */
        boolean mo22681a(int i);

        /* renamed from: b */
        boolean mo22682b();
    }

    /* renamed from: a */
    public static synchronized ThreadPool m16011a() {
        synchronized (ThreadPool.class) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14124a, true, 8208, new Class[0], ThreadPool.class);
            if (proxy.isSupported) {
                ThreadPool aqVar = (ThreadPool) proxy.result;
                return aqVar;
            }
            if (f14126e == null) {
                f14126e = new ThreadPool();
            }
            ThreadPool aqVar2 = f14126e;
            return aqVar2;
        }
    }

    /* renamed from: a */
    public <T> Future<T> mo22678a(C2637b<T> bVar, FutureListener<T> wVar) {
        ChangeQuickRedirect changeQuickRedirect = f14124a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar, wVar}, this, changeQuickRedirect, false, 8209, new Class[]{C2637b.class, FutureListener.class}, Future.class);
        if (proxy.isSupported) {
            return (Future) proxy.result;
        }
        C2641f fVar = new C2641f(bVar, wVar);
        this.f14129f.execute(fVar);
        return fVar;
    }

    /* renamed from: com.meizu.media.camera.util.aq$d */
    /* compiled from: ThreadPool */
    private static class C2639d implements C2638c {
        /* renamed from: a */
        public void mo22680a(C2636a aVar) {
        }

        /* renamed from: a */
        public boolean mo22681a(int i) {
            return true;
        }

        /* renamed from: b */
        public boolean mo22682b() {
            return false;
        }

        private C2639d() {
        }
    }

    /* renamed from: com.meizu.media.camera.util.aq$e */
    /* compiled from: ThreadPool */
    private static class C2640e {

        /* renamed from: a */
        public int f14130a;

        public C2640e(int i) {
            this.f14130a = i;
        }
    }

    /* renamed from: com.meizu.media.camera.util.aq$f */
    /* compiled from: ThreadPool */
    private class C2641f<T> implements C2638c, Future<T>, Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f14131a;

        /* renamed from: c */
        private C2637b<T> f14133c;

        /* renamed from: d */
        private FutureListener<T> f14134d;

        /* renamed from: e */
        private C2636a f14135e;

        /* renamed from: f */
        private C2640e f14136f;

        /* renamed from: g */
        private volatile boolean f14137g;

        /* renamed from: h */
        private boolean f14138h;

        /* renamed from: i */
        private T f14139i;

        /* renamed from: j */
        private int f14140j;

        public C2641f(C2637b<T> bVar, FutureListener<T> wVar) {
            this.f14133c = bVar;
            this.f14134d = wVar;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f14131a, false, 8211, new Class[0], Void.TYPE).isSupported) {
                T t = null;
                if (mo22681a(1)) {
                    try {
                        t = this.f14133c.mo22655b(this);
                    } catch (Throwable th) {
                        Log.w("Worker", "Exception in running a job", th);
                    }
                }
                synchronized (this) {
                    mo22681a(0);
                    this.f14139i = t;
                    this.f14138h = true;
                    notifyAll();
                }
                if (this.f14134d != null) {
                    this.f14134d.mo18710a(this);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo22653a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x003d }
                com.meizu.savior.ChangeQuickRedirect r3 = f14131a     // Catch:{ all -> 0x003d }
                r4 = 0
                r5 = 8212(0x2014, float:1.1507E-41)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x003d }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x003d }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003d }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r0 = r8.f14137g     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x001e
                monitor-exit(r8)
                return
            L_0x001e:
                r0 = 1
                r8.f14137g = r0     // Catch:{ all -> 0x003d }
                com.meizu.media.camera.util.aq$e r0 = r8.f14136f     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x0032
                com.meizu.media.camera.util.aq$e r0 = r8.f14136f     // Catch:{ all -> 0x003d }
                monitor-enter(r0)     // Catch:{ all -> 0x003d }
                com.meizu.media.camera.util.aq$e r1 = r8.f14136f     // Catch:{ all -> 0x002f }
                r1.notifyAll()     // Catch:{ all -> 0x002f }
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                goto L_0x0032
            L_0x002f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                throw r1     // Catch:{ all -> 0x003d }
            L_0x0032:
                com.meizu.media.camera.util.aq$a r0 = r8.f14135e     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x003b
                com.meizu.media.camera.util.aq$a r0 = r8.f14135e     // Catch:{ all -> 0x003d }
                r0.mo22679a()     // Catch:{ all -> 0x003d }
            L_0x003b:
                monitor-exit(r8)
                return
            L_0x003d:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.ThreadPool.C2641f.mo22653a():void");
        }

        /* renamed from: b */
        public boolean mo22682b() {
            return this.f14137g;
        }

        /* renamed from: c */
        public synchronized T mo22657c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14131a, false, 8213, new Class[0], Object.class);
            if (proxy.isSupported) {
                return (Object) proxy.result;
            }
            while (!this.f14138h) {
                try {
                    wait();
                } catch (Exception e) {
                    Log.w("Worker", "ingore exception", e);
                }
            }
            return this.f14139i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo22680a(com.meizu.media.camera.util.ThreadPool.C2636a r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0030 }
                r2 = 0
                r1[r2] = r9     // Catch:{ all -> 0x0030 }
                com.meizu.savior.ChangeQuickRedirect r3 = f14131a     // Catch:{ all -> 0x0030 }
                r4 = 0
                r5 = 8215(0x2017, float:1.1512E-41)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0030 }
                java.lang.Class<com.meizu.media.camera.util.aq$a> r0 = com.meizu.media.camera.util.ThreadPool.C2636a.class
                r6[r2] = r0     // Catch:{ all -> 0x0030 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0030 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0030 }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x0030 }
                if (r0 == 0) goto L_0x001f
                monitor-exit(r8)
                return
            L_0x001f:
                r8.f14135e = r9     // Catch:{ all -> 0x0030 }
                boolean r9 = r8.f14137g     // Catch:{ all -> 0x0030 }
                if (r9 == 0) goto L_0x002e
                com.meizu.media.camera.util.aq$a r9 = r8.f14135e     // Catch:{ all -> 0x0030 }
                if (r9 == 0) goto L_0x002e
                com.meizu.media.camera.util.aq$a r9 = r8.f14135e     // Catch:{ all -> 0x0030 }
                r9.mo22679a()     // Catch:{ all -> 0x0030 }
            L_0x002e:
                monitor-exit(r8)
                return
            L_0x0030:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.ThreadPool.C2641f.mo22680a(com.meizu.media.camera.util.aq$a):void");
        }

        /* renamed from: a */
        public boolean mo22681a(int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14131a, false, 8216, new Class[]{Integer.TYPE}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            C2640e b = m16022b(this.f14140j);
            if (b != null) {
                m16023b(b);
            }
            this.f14140j = 0;
            C2640e b2 = m16022b(i);
            if (b2 != null) {
                if (!m16021a(b2)) {
                    return false;
                }
                this.f14140j = i;
            }
            return true;
        }

        /* renamed from: b */
        private C2640e m16022b(int i) {
            if (i == 1) {
                return ThreadPool.this.f14127c;
            }
            if (i == 2) {
                return ThreadPool.this.f14128d;
            }
            return null;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
            if (r10.f14130a <= 0) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
            r10.f14130a--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r9.f14136f = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r10.wait();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0048 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m16021a(com.meizu.media.camera.util.ThreadPool.C2640e r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f14131a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<com.meizu.media.camera.util.aq$e> r2 = com.meizu.media.camera.util.ThreadPool.C2640e.class
                r6[r8] = r2
                java.lang.Class r7 = java.lang.Boolean.TYPE
                r4 = 0
                r5 = 8217(0x2019, float:1.1514E-41)
                r2 = r9
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r2 = r1.isSupported
                if (r2 == 0) goto L_0x0025
                java.lang.Object r10 = r1.result
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                return r10
            L_0x0025:
                monitor-enter(r9)
                boolean r1 = r9.f14137g     // Catch:{ all -> 0x004d }
                r2 = 0
                if (r1 == 0) goto L_0x002f
                r9.f14136f = r2     // Catch:{ all -> 0x004d }
                monitor-exit(r9)     // Catch:{ all -> 0x004d }
                return r8
            L_0x002f:
                r9.f14136f = r10     // Catch:{ all -> 0x004d }
                monitor-exit(r9)     // Catch:{ all -> 0x004d }
                monitor-enter(r10)
                int r1 = r10.f14130a     // Catch:{ all -> 0x004a }
                if (r1 <= 0) goto L_0x0045
                int r1 = r10.f14130a     // Catch:{ all -> 0x004a }
                int r1 = r1 - r0
                r10.f14130a = r1     // Catch:{ all -> 0x004a }
                monitor-exit(r10)     // Catch:{ all -> 0x004a }
                monitor-enter(r9)
                r9.f14136f = r2     // Catch:{ all -> 0x0042 }
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                return r0
            L_0x0042:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                throw r10
            L_0x0045:
                r10.wait()     // Catch:{ InterruptedException -> 0x0048 }
            L_0x0048:
                monitor-exit(r10)     // Catch:{ all -> 0x004a }
                goto L_0x0025
            L_0x004a:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x004a }
                throw r0
            L_0x004d:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x004d }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.ThreadPool.C2641f.m16021a(com.meizu.media.camera.util.aq$e):boolean");
        }

        /* renamed from: b */
        private void m16023b(C2640e eVar) {
            if (!PatchProxy.proxy(new Object[]{eVar}, this, f14131a, false, 8218, new Class[]{C2640e.class}, Void.TYPE).isSupported) {
                synchronized (eVar) {
                    eVar.f14130a++;
                    eVar.notifyAll();
                }
            }
        }
    }
}
