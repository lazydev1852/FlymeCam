package com.meizu.media.camera.util;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTaskEx<Params, Progress, Result> {

    /* renamed from: a */
    private static final int f13733a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f13734b = (f13733a + 1);

    /* renamed from: c */
    private static final ThreadFactory f13735c = new ThreadFactory() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13751a;

        /* renamed from: b */
        private final AtomicInteger f13752b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{runnable}, this, f13751a, false, 7740, new Class[]{Runnable.class}, Thread.class);
            if (proxy.isSupported) {
                return (Thread) proxy.result;
            }
            return new Thread(runnable, "AsyncTaskEx #" + this.f13752b.getAndIncrement());
        }
    };

    /* renamed from: d */
    private static final BlockingQueue<Runnable> f13736d = new LinkedBlockingQueue(128);

    /* renamed from: e */
    private static final BlockingQueue<Runnable> f13737e = new LinkedBlockingQueue(DeviceHelper.f13940bn);

    /* renamed from: f */
    private static volatile Executor f13738f = f13743q;

    /* renamed from: g */
    private static C2617b f13739g;

    /* renamed from: n */
    public static ChangeQuickRedirect f13740n;

    /* renamed from: o */
    public static final Executor f13741o = new ThreadPoolExecutor(f13734b, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1, TimeUnit.SECONDS, f13736d, f13735c);

    /* renamed from: p */
    public static final Executor f13742p = new ThreadPoolExecutor(0, 5, 0, TimeUnit.SECONDS, f13737e, f13735c);

    /* renamed from: q */
    public static final Executor f13743q = new C2618c();

    /* renamed from: r */
    public static final C2618c f13744r = new C2618c();

    /* renamed from: s */
    public static final Executor f13745s = new C2618c();

    /* renamed from: h */
    private final C2621d<Params, Result> f13746h = new C2621d<Params, Result>() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13753a;

        public Result call() throws Exception {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13753a, false, 7741, new Class[0], Object.class);
            if (proxy.isSupported) {
                return (Object) proxy.result;
            }
            AsyncTaskEx.this.f13750l.set(true);
            Process.setThreadPriority(10);
            Object a = AsyncTaskEx.this.mo17658a((Params[]) this.f13773c);
            Binder.flushPendingCommands();
            return AsyncTaskEx.this.m15790d(a);
        }
    };

    /* renamed from: i */
    private final FutureTask<Result> f13747i = new FutureTask<Result>(this.f13746h) {

        /* renamed from: a */
        public static ChangeQuickRedirect f13755a;

        public void done() {
            if (!PatchProxy.proxy(new Object[0], this, f13755a, false, 7742, new Class[0], Void.TYPE).isSupported) {
                try {
                    AsyncTaskEx.this.m15789c(get());
                } catch (InterruptedException e) {
                    Log.w("AsyncTaskEx", e);
                } catch (ExecutionException e2) {
                    throw new UnsupportedOperationException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (CancellationException unused) {
                    AsyncTaskEx.this.m15789c(null);
                }
            }
        }
    };

    /* renamed from: j */
    private volatile Status f13748j = Status.PENDING;

    /* renamed from: k */
    private final AtomicBoolean f13749k = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final AtomicBoolean f13750l = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    @WorkerThread
    /* renamed from: a */
    public abstract Result mo17658a(Params... paramsArr);

    @MainThread
    /* renamed from: a */
    public void mo19181a() {
    }

    @MainThread
    /* renamed from: a */
    public void mo17660a(Result result) {
    }

    @MainThread
    /* renamed from: b */
    public void mo19184b() {
    }

    @MainThread
    /* renamed from: b */
    public void mo22611b(Progress... progressArr) {
    }

    /* renamed from: com.meizu.media.camera.util.AsyncTaskEx$c */
    public static class C2618c implements Executor {

        /* renamed from: a */
        public static ChangeQuickRedirect f13761a;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public static final LogUtil.C2630a f13762d = new LogUtil.C2630a("SeExe");

        /* renamed from: b */
        final ArrayDeque<Runnable> f13763b = new ArrayDeque<>();

        /* renamed from: c */
        Runnable f13764c;

        public synchronized void execute(Runnable runnable) {
            if (!PatchProxy.proxy(new Object[]{runnable}, this, f13761a, false, 7744, new Class[]{Runnable.class}, Void.TYPE).isSupported) {
                mo22621a((String) null, runnable);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo22621a(final java.lang.String r9, final java.lang.Runnable r10) {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 2
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0055 }
                r2 = 0
                r1[r2] = r9     // Catch:{ all -> 0x0055 }
                r3 = 1
                r1[r3] = r10     // Catch:{ all -> 0x0055 }
                com.meizu.savior.ChangeQuickRedirect r4 = f13761a     // Catch:{ all -> 0x0055 }
                r5 = 0
                r6 = 7745(0x1e41, float:1.0853E-41)
                java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0055 }
                java.lang.Class<java.lang.String> r7 = java.lang.String.class
                r0[r2] = r7     // Catch:{ all -> 0x0055 }
                java.lang.Class<java.lang.Runnable> r2 = java.lang.Runnable.class
                r0[r3] = r2     // Catch:{ all -> 0x0055 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0055 }
                r2 = r8
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r0
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0055 }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x0055 }
                if (r0 == 0) goto L_0x002a
                monitor-exit(r8)
                return
            L_0x002a:
                if (r9 == 0) goto L_0x0042
                com.meizu.media.camera.util.ac$a r0 = f13762d     // Catch:{ all -> 0x0055 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
                r1.<init>()     // Catch:{ all -> 0x0055 }
                java.lang.String r2 = "offer "
                r1.append(r2)     // Catch:{ all -> 0x0055 }
                r1.append(r9)     // Catch:{ all -> 0x0055 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0055 }
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0055 }
            L_0x0042:
                java.util.ArrayDeque<java.lang.Runnable> r0 = r8.f13763b     // Catch:{ all -> 0x0055 }
                com.meizu.media.camera.util.AsyncTaskEx$c$1 r1 = new com.meizu.media.camera.util.AsyncTaskEx$c$1     // Catch:{ all -> 0x0055 }
                r1.<init>(r9, r10)     // Catch:{ all -> 0x0055 }
                r0.offer(r1)     // Catch:{ all -> 0x0055 }
                java.lang.Runnable r9 = r8.f13764c     // Catch:{ all -> 0x0055 }
                if (r9 != 0) goto L_0x0053
                r8.mo22620a()     // Catch:{ all -> 0x0055 }
            L_0x0053:
                monitor-exit(r8)
                return
            L_0x0055:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.AsyncTaskEx.C2618c.mo22621a(java.lang.String, java.lang.Runnable):void");
        }

        /* renamed from: a */
        public boolean mo22622a(final String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13761a, false, 7746, new Class[]{String.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            final Object obj = new Object();
            C26202 r2 = new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13769a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f13769a, false, 7749, new Class[0], Void.TYPE).isSupported) {
                        synchronized (obj) {
                            obj.notifyAll();
                            if (str != null) {
                                LogUtil.C2630a b = C2618c.f13762d;
                                LogUtil.m15952c(b, str + " notifyAll");
                            }
                        }
                    }
                }
            };
            synchronized (obj) {
                execute(r2);
                if (str != null) {
                    try {
                        LogUtil.C2630a aVar = f13762d;
                        LogUtil.m15952c(aVar, "wait " + str);
                    } catch (InterruptedException unused) {
                        LogUtil.m15949b(f13762d, "waitDone interrupted");
                        return false;
                    }
                }
                obj.wait();
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo22620a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002d }
                com.meizu.savior.ChangeQuickRedirect r3 = f13761a     // Catch:{ all -> 0x002d }
                r4 = 0
                r5 = 7747(0x1e43, float:1.0856E-41)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002d }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x002d }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002d }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x002d }
                if (r0 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                java.util.ArrayDeque<java.lang.Runnable> r0 = r8.f13763b     // Catch:{ all -> 0x002d }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x002d }
                java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x002d }
                r8.f13764c = r0     // Catch:{ all -> 0x002d }
                if (r0 == 0) goto L_0x002b
                java.util.concurrent.Executor r0 = com.meizu.media.camera.util.AsyncTaskEx.f13741o     // Catch:{ all -> 0x002d }
                java.lang.Runnable r1 = r8.f13764c     // Catch:{ all -> 0x002d }
                r0.execute(r1)     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r8)
                return
            L_0x002d:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.AsyncTaskEx.C2618c.mo22620a():void");
        }
    }

    /* renamed from: e */
    private static Handler m15791e() {
        C2617b bVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13740n, true, 7727, new Class[0], Handler.class);
        if (proxy.isSupported) {
            return (Handler) proxy.result;
        }
        synchronized (AsyncTaskEx.class) {
            if (f13739g == null) {
                f13739g = new C2617b();
            }
            bVar = f13739g;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15789c(Result result) {
        if (!PatchProxy.proxy(new Object[]{result}, this, f13740n, false, 7728, new Class[]{Object.class}, Void.TYPE).isSupported && !this.f13750l.get()) {
            m15790d(result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Result m15790d(Result result) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{result}, this, f13740n, false, 7729, new Class[]{Object.class}, Object.class);
        if (proxy.isSupported) {
            return (Object) proxy.result;
        }
        m15791e().obtainMessage(1, new C2616a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: c */
    public final Status mo22613c() {
        return this.f13748j;
    }

    @MainThread
    /* renamed from: b */
    public void mo19185b(Result result) {
        if (!PatchProxy.proxy(new Object[]{result}, this, f13740n, false, 7730, new Class[]{Object.class}, Void.TYPE).isSupported) {
            mo19184b();
        }
    }

    /* renamed from: d */
    public final boolean mo22615d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13740n, false, 7731, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f13749k.get();
    }

    /* renamed from: b */
    public final boolean mo22612b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13740n;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7732, new Class[]{Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f13749k.set(true);
        return this.f13747i.cancel(z);
    }

    @MainThread
    /* renamed from: c */
    public final AsyncTaskEx<Params, Progress, Result> mo22614c(Params... paramsArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{paramsArr}, this, f13740n, false, 7735, new Class[]{Object[].class}, AsyncTaskEx.class);
        return proxy.isSupported ? (AsyncTaskEx) proxy.result : mo22610a(f13738f, paramsArr);
    }

    @MainThread
    /* renamed from: a */
    public final AsyncTaskEx<Params, Progress, Result> mo22610a(Executor executor, Params... paramsArr) {
        ChangeQuickRedirect changeQuickRedirect = f13740n;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{executor, paramsArr}, this, changeQuickRedirect, false, 7736, new Class[]{Executor.class, Object[].class}, AsyncTaskEx.class);
        if (proxy.isSupported) {
            return (AsyncTaskEx) proxy.result;
        }
        if (this.f13748j != Status.PENDING) {
            switch (this.f13748j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f13748j = Status.RUNNING;
        mo19181a();
        this.f13746h.f13773c = paramsArr;
        executor.execute(this.f13747i);
        return this;
    }

    @MainThread
    /* renamed from: a */
    public static void m15786a(Runnable runnable) {
        if (!PatchProxy.proxy(new Object[]{runnable}, (Object) null, f13740n, true, 7737, new Class[]{Runnable.class}, Void.TYPE).isSupported) {
            f13738f.execute(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15792e(Result result) {
        if (!PatchProxy.proxy(new Object[]{result}, this, f13740n, false, 7739, new Class[]{Object.class}, Void.TYPE).isSupported) {
            if (mo22615d()) {
                mo19185b(result);
            } else {
                mo17660a(result);
            }
            this.f13748j = Status.FINISHED;
        }
    }

    /* renamed from: com.meizu.media.camera.util.AsyncTaskEx$b */
    private static class C2617b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f13760a;

        public C2617b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f13760a, false, 7743, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C2616a aVar = (C2616a) message.obj;
                switch (message.what) {
                    case 1:
                        aVar.f13758a.m15792e(aVar.f13759b[0]);
                        return;
                    case 2:
                        aVar.f13758a.mo22611b((Progress[]) aVar.f13759b);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.util.AsyncTaskEx$d */
    private static abstract class C2621d<Params, Result> implements Callable<Result> {

        /* renamed from: c */
        Params[] f13773c;

        private C2621d() {
        }
    }

    /* renamed from: com.meizu.media.camera.util.AsyncTaskEx$a */
    private static class C2616a<Data> {

        /* renamed from: a */
        final AsyncTaskEx f13758a;

        /* renamed from: b */
        final Data[] f13759b;

        C2616a(AsyncTaskEx asyncTaskEx, Data... dataArr) {
            this.f13758a = asyncTaskEx;
            this.f13759b = dataArr;
        }
    }
}
