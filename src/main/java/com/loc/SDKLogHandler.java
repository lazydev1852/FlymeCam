package com.loc;

import android.content.Context;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.loc.j */
public final class SDKLogHandler extends BasicLogHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static ExecutorService f3359e;

    /* renamed from: f */
    private static Set<Integer> f3360f = Collections.synchronizedSet(new HashSet());

    /* renamed from: g */
    private static WeakReference<Context> f3361g;

    /* renamed from: h */
    private static final ThreadFactory f3362h = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f3369a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f3369a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f3363d;

    /* renamed from: i */
    private List f3364i;

    private SDKLogHandler(Context context) {
        this.f3363d = context;
        try {
            this.f3345b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f3345b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f3346c = true;
                return;
            }
            String obj = this.f3345b.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f3346c = true;
                return;
            }
            this.f3346c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static synchronized SDKLogHandler m3862a(Context context, SDKInfo diVar) throws AMapCoreException {
        synchronized (SDKLogHandler.class) {
            if (diVar == null) {
                throw new AMapCoreException("sdk info is null");
            } else if (diVar.mo13272a() == null || "".equals(diVar.mo13272a())) {
                throw new AMapCoreException("sdk name is invalid");
            } else {
                try {
                    if (!f3360f.add(Integer.valueOf(diVar.hashCode()))) {
                        SDKLogHandler jVar = (SDKLogHandler) BasicLogHandler.f3344a;
                        return jVar;
                    }
                    if (BasicLogHandler.f3344a == null) {
                        BasicLogHandler.f3344a = new SDKLogHandler(context);
                    } else {
                        BasicLogHandler.f3344a.f3346c = false;
                    }
                    BasicLogHandler.f3344a.mo13289a(context, diVar, BasicLogHandler.f3344a.f3346c);
                    SDKLogHandler jVar2 = (SDKLogHandler) BasicLogHandler.f3344a;
                    return jVar2;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3863a(SDKInfo diVar, String str, AMapCoreException cxVar) {
        if (cxVar != null) {
            m3864a(diVar, str, cxVar.mo13251c(), cxVar.mo13252d(), cxVar.mo13250b());
        }
    }

    /* renamed from: a */
    public static void m3864a(SDKInfo diVar, String str, String str2, String str3, String str4) {
        try {
            if (BasicLogHandler.f3344a != null) {
                BasicLogHandler.f3344a.mo13290a(diVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static synchronized void m3865b() {
        synchronized (SDKLogHandler.class) {
            try {
                if (f3359e != null) {
                    f3359e.shutdown();
                }
                DiskLruCache.m2940a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(BasicLogHandler.f3344a == null || Thread.getDefaultUncaughtExceptionHandler() != BasicLogHandler.f3344a || BasicLogHandler.f3344a.f3345b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(BasicLogHandler.f3344a.f3345b);
                }
                BasicLogHandler.f3344a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    /* renamed from: b */
    public static void m3866b(SDKInfo diVar, String str, String str2) {
        try {
            if (BasicLogHandler.f3344a != null) {
                BasicLogHandler.f3344a.mo13290a(diVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static void m3867b(Throwable th, String str, String str2) {
        try {
            if (BasicLogHandler.f3344a != null) {
                BasicLogHandler.f3344a.mo13291a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static void m3868c() {
        if (f3361g != null && f3361g.get() != null) {
            C1108h.m3850a((Context) f3361g.get());
        } else if (BasicLogHandler.f3344a != null) {
            BasicLogHandler.f3344a.mo13288a();
        }
    }

    /* renamed from: d */
    public static synchronized ExecutorService m3869d() {
        ExecutorService executorService;
        synchronized (SDKLogHandler.class) {
            try {
                if (f3359e == null || f3359e.isShutdown()) {
                    f3359e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f3362h);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f3359e;
        }
        return executorService;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo13288a() {
        C1108h.m3850a(this.f3363d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo13289a(final Context context, final SDKInfo diVar, final boolean z) {
        try {
            ExecutorService d = m3869d();
            if (d == null) {
                return;
            }
            if (!d.isShutdown()) {
                d.submit(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
                        r0 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
                        r0.printStackTrace();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
                        return;
                     */
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r4 = this;
                            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x0024 }
                            monitor-enter(r0)     // Catch:{ Throwable -> 0x0024 }
                            com.loc.q r1 = new com.loc.q     // Catch:{ all -> 0x0021 }
                            android.content.Context r2 = r3     // Catch:{ all -> 0x0021 }
                            r3 = 1
                            r1.<init>(r2, r3)     // Catch:{ all -> 0x0021 }
                            com.loc.di r2 = r4     // Catch:{ all -> 0x0021 }
                            r1.mo13308a(r2)     // Catch:{ all -> 0x0021 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                            boolean r0 = r5     // Catch:{ Throwable -> 0x0024 }
                            if (r0 == 0) goto L_0x0020
                            com.loc.j r0 = com.loc.SDKLogHandler.this     // Catch:{ Throwable -> 0x0024 }
                            android.content.Context r0 = r0.f3363d     // Catch:{ Throwable -> 0x0024 }
                            com.loc.ErrorLogManager.m3877a((android.content.Context) r0)     // Catch:{ Throwable -> 0x0024 }
                        L_0x0020:
                            return
                        L_0x0021:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ Throwable -> 0x0024 }
                            throw r1     // Catch:{ Throwable -> 0x0024 }
                        L_0x0024:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.loc.SDKLogHandler.C11101.run():void");
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo13290a(SDKInfo diVar, String str, String str2) {
        ErrorLogManager.m3881a(diVar, this.f3363d, str2, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo13291a(Throwable th, int i, String str, String str2) {
        ErrorLogManager.m3880a(this.f3363d, th, i, str, str2);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        int i = 0;
        while (i < this.f3364i.size() && i < 10) {
            try {
                this.f3364i.get(i);
                i++;
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            mo13291a(th, 0, (String) null, (String) null);
            if (this.f3345b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.f3345b);
                } catch (Throwable unused2) {
                }
                this.f3345b.uncaughtException(thread, th);
            }
        }
    }
}
