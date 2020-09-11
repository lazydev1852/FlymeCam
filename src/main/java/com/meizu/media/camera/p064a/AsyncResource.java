package com.meizu.media.camera.p064a;

import com.meizu.media.camera.util.Future;
import com.meizu.media.camera.util.FutureListener;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.a.a */
public abstract class AsyncResource<T> implements FutureListener<T> {

    /* renamed from: a */
    public static ChangeQuickRedirect f7447a;

    /* renamed from: b */
    private final C1783a<T> f7448b;

    /* renamed from: c */
    private int f7449c = 0;

    /* renamed from: d */
    private Future<T> f7450d;

    /* renamed from: e */
    private T f7451e;

    /* renamed from: f */
    private Runnable f7452f = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7453a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f7453a, false, 3407, new Class[0], Void.TYPE).isSupported) {
                AsyncResource.this.mo18711a(AsyncResource.this.mo18709a());
            }
        }
    };

    /* renamed from: com.meizu.media.camera.a.a$a */
    /* compiled from: AsyncResource */
    public interface C1783a<T> {
        /* renamed from: a */
        Future<T> mo18716a(ThreadPool.C2637b<T> bVar, FutureListener<T> wVar);

        /* renamed from: a */
        void mo18717a(Runnable runnable);
    }

    /* renamed from: a */
    public abstract void mo18711a(T t);

    /* renamed from: b */
    public abstract void mo18713b(T t);

    /* renamed from: c */
    public abstract ThreadPool.C2637b<T> mo18714c();

    public AsyncResource(C1783a<T> aVar) {
        this.f7448b = aVar;
    }

    /* renamed from: a */
    public T mo18709a() {
        return this.f7451e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18710a(com.meizu.media.camera.util.Future<T> r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f7447a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.v> r4 = com.meizu.media.camera.util.Future.class
            r6[r2] = r4
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3403(0xd4b, float:4.769E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r8)
            r1 = 0
            r8.f7450d = r1     // Catch:{ all -> 0x0076 }
            java.lang.Object r2 = r9.mo22657c()     // Catch:{ all -> 0x0076 }
            r8.f7451e = r2     // Catch:{ all -> 0x0076 }
            int r2 = r8.f7449c     // Catch:{ all -> 0x0076 }
            r3 = 4
            if (r2 != r3) goto L_0x0040
            T r9 = r8.f7451e     // Catch:{ all -> 0x0076 }
            if (r9 == 0) goto L_0x0037
            T r9 = r8.f7451e     // Catch:{ all -> 0x0076 }
            r8.mo18713b(r9)     // Catch:{ all -> 0x0076 }
            r8.f7451e = r1     // Catch:{ all -> 0x0076 }
        L_0x0037:
            com.meizu.media.camera.a.a$a<T> r9 = r8.f7448b     // Catch:{ all -> 0x0076 }
            java.lang.Runnable r0 = r8.f7452f     // Catch:{ all -> 0x0076 }
            r9.mo18717a(r0)     // Catch:{ all -> 0x0076 }
            monitor-exit(r8)     // Catch:{ all -> 0x0076 }
            return
        L_0x0040:
            boolean r9 = r9.mo22656b()     // Catch:{ all -> 0x0076 }
            if (r9 == 0) goto L_0x0064
            T r9 = r8.f7451e     // Catch:{ all -> 0x0076 }
            if (r9 != 0) goto L_0x0064
            int r9 = r8.f7449c     // Catch:{ all -> 0x0076 }
            if (r9 != r0) goto L_0x005b
            com.meizu.media.camera.a.a$a<T> r9 = r8.f7448b     // Catch:{ all -> 0x0076 }
            com.meizu.media.camera.util.aq$b r0 = r8.mo18714c()     // Catch:{ all -> 0x0076 }
            com.meizu.media.camera.util.v r9 = r9.mo18716a(r0, r8)     // Catch:{ all -> 0x0076 }
            r8.f7450d = r9     // Catch:{ all -> 0x0076 }
            goto L_0x0062
        L_0x005b:
            com.meizu.media.camera.a.a$a<T> r9 = r8.f7448b     // Catch:{ all -> 0x0076 }
            java.lang.Runnable r0 = r8.f7452f     // Catch:{ all -> 0x0076 }
            r9.mo18717a(r0)     // Catch:{ all -> 0x0076 }
        L_0x0062:
            monitor-exit(r8)     // Catch:{ all -> 0x0076 }
            return
        L_0x0064:
            T r9 = r8.f7451e     // Catch:{ all -> 0x0076 }
            if (r9 != 0) goto L_0x006a
            r9 = 3
            goto L_0x006b
        L_0x006a:
            r9 = 2
        L_0x006b:
            r8.f7449c = r9     // Catch:{ all -> 0x0076 }
            monitor-exit(r8)     // Catch:{ all -> 0x0076 }
            com.meizu.media.camera.a.a$a<T> r9 = r8.f7448b
            java.lang.Runnable r0 = r8.f7452f
            r9.mo18717a(r0)
            return
        L_0x0076:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0076 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p064a.AsyncResource.mo18710a(com.meizu.media.camera.util.v):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo18712b() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0031 }
            com.meizu.savior.ChangeQuickRedirect r3 = f7447a     // Catch:{ all -> 0x0031 }
            r4 = 0
            r5 = 3404(0xd4c, float:4.77E-42)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0031 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0031 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            int r0 = r8.f7449c     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x002f
            r0 = 1
            r8.f7449c = r0     // Catch:{ all -> 0x0031 }
            com.meizu.media.camera.util.v<T> r0 = r8.f7450d     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x002f
            com.meizu.media.camera.a.a$a<T> r0 = r8.f7448b     // Catch:{ all -> 0x0031 }
            com.meizu.media.camera.util.aq$b r1 = r8.mo18714c()     // Catch:{ all -> 0x0031 }
            com.meizu.media.camera.util.v r0 = r0.mo18716a(r1, r8)     // Catch:{ all -> 0x0031 }
            r8.f7450d = r0     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r8)
            return
        L_0x0031:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p064a.AsyncResource.mo18712b():void");
    }
}
