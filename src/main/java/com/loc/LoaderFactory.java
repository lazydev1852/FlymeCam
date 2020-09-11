package com.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.loc.y */
public final class LoaderFactory {

    /* renamed from: a */
    private static final LoaderFactory f3435a = new LoaderFactory();

    /* renamed from: d */
    private static final ThreadFactory f3436d = new C1119b();

    /* renamed from: b */
    private final Map<String, BaseLoader> f3437b = new HashMap();

    /* renamed from: c */
    private final Map<String, C1118a> f3438c = new HashMap();

    /* renamed from: e */
    private ExecutorService f3439e = null;

    /* renamed from: com.loc.y$a */
    /* compiled from: LoaderFactory */
    class C1118a {

        /* renamed from: a */
        volatile boolean f3440a = false;

        /* renamed from: b */
        volatile boolean f3441b = false;

        C1118a() {
        }
    }

    /* renamed from: com.loc.y$b */
    /* compiled from: LoaderFactory */
    static class C1119b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f3443a = new AtomicInteger(1);

        C1119b() {
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "amapD#" + this.f3443a.getAndIncrement());
        }
    }

    private LoaderFactory() {
    }

    /* renamed from: b */
    public static LoaderFactory m3976b() {
        return f3435a;
    }

    /* renamed from: b */
    private static boolean m3977b(SDKInfo diVar) {
        return diVar != null && !TextUtils.isEmpty(diVar.mo13274b()) && !TextUtils.isEmpty(diVar.mo13272a());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(5:8|9|10|11|12)|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.loc.BaseLoader mo13330a(android.content.Context r6, com.loc.SDKInfo r7) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = m3977b(r7)
            if (r0 == 0) goto L_0x0031
            if (r6 != 0) goto L_0x0009
            goto L_0x0031
        L_0x0009:
            java.lang.String r0 = r7.mo13272a()
            java.util.Map<java.lang.String, com.loc.aa> r1 = r5.f3437b
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.loc.aa> r2 = r5.f3437b     // Catch:{ all -> 0x002e }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x002e }
            com.loc.aa r2 = (com.loc.BaseLoader) r2     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            com.loc.ac r3 = new com.loc.ac     // Catch:{ Throwable -> 0x002c }
            android.content.Context r4 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x002c }
            r3.<init>(r4, r7)     // Catch:{ Throwable -> 0x002c }
            java.util.Map<java.lang.String, com.loc.aa> r2 = r5.f3437b     // Catch:{ Throwable -> 0x002b }
            r2.put(r0, r3)     // Catch:{ Throwable -> 0x002b }
            com.loc.DynamicExceptionHandler.m3941a(r6, r7)     // Catch:{ Throwable -> 0x002b }
        L_0x002b:
            r2 = r3
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            return r2
        L_0x002e:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        L_0x0031:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LoaderFactory.mo13330a(android.content.Context, com.loc.di):com.loc.aa");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|(5:10|11|12|13|14)|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0025 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.loc.LoaderFactory.C1118a mo13331a(com.loc.SDKInfo r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, com.loc.y$a> r0 = r3.f3438c
            monitor-enter(r0)
            boolean r1 = m3977b(r4)     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x000c
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return r4
        L_0x000c:
            java.lang.String r4 = r4.mo13272a()     // Catch:{ all -> 0x0027 }
            java.util.Map<java.lang.String, com.loc.y$a> r1 = r3.f3438c     // Catch:{ all -> 0x0027 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0027 }
            com.loc.y$a r1 = (com.loc.LoaderFactory.C1118a) r1     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0025
            com.loc.y$a r2 = new com.loc.y$a     // Catch:{ Throwable -> 0x0025 }
            r2.<init>()     // Catch:{ Throwable -> 0x0025 }
            java.util.Map<java.lang.String, com.loc.y$a> r1 = r3.f3438c     // Catch:{ Throwable -> 0x0024 }
            r1.put(r4, r2)     // Catch:{ Throwable -> 0x0024 }
        L_0x0024:
            r1 = r2
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return r1
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LoaderFactory.mo13331a(com.loc.di):com.loc.y$a");
    }

    /* renamed from: a */
    public final ExecutorService mo13332a() {
        try {
            if (this.f3439e == null || this.f3439e.isShutdown()) {
                this.f3439e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), f3436d);
            }
        } catch (Throwable unused) {
        }
        return this.f3439e;
    }
}
