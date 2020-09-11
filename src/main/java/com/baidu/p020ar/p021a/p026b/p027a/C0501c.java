package com.baidu.p020ar.p021a.p026b.p027a;

import android.util.Log;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.ar.a.b.a.c */
public class C0501c {

    /* renamed from: a */
    private static C0501c f599a;

    /* renamed from: b */
    private static final int f600b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c */
    private static final int f601c = Math.max(2, Math.min(f600b - 1, 4));

    /* renamed from: d */
    private static final int f602d = ((f600b * 2) + 1);

    /* renamed from: e */
    private final ThreadFactory f603e = new ThreadFactory() {

        /* renamed from: b */
        private final AtomicInteger f610b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f610b.getAndIncrement());
        }
    };

    /* renamed from: f */
    private final BlockingQueue<Runnable> f604f = new LinkedBlockingQueue(10);

    /* renamed from: g */
    private ThreadPoolExecutor f605g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new C0503a());

    /* renamed from: h */
    private ThreadPoolExecutor f606h;

    /* renamed from: i */
    private Queue<byte[]> f607i;

    /* renamed from: j */
    private Queue<byte[]> f608j;

    /* renamed from: com.baidu.ar.a.b.a.c$a */
    public static class C0503a implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown()) {
                Runnable runnable2 = (Runnable) threadPoolExecutor.getQueue().poll();
                if (runnable2 != null && (runnable2 instanceof C0500b)) {
                    ((C0500b) runnable2).mo8960a();
                }
                threadPoolExecutor.execute(runnable);
            }
        }
    }

    private C0501c(int i, int i2, int i3) {
        int i4 = i3;
        int i5 = f601c;
        int i6 = f602d;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = this.f604f;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i6, 10, timeUnit, blockingQueue, this.f603e, new C0503a());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f606h = threadPoolExecutor;
        this.f607i = new ArrayBlockingQueue(3);
        for (int i7 = 0; i7 < 3; i7++) {
            this.f607i.add(new byte[i4]);
        }
        this.f608j = new ArrayBlockingQueue(3);
        for (int i8 = 0; i8 < 3; i8++) {
            this.f608j.add(new byte[i4]);
        }
    }

    /* renamed from: a */
    public static C0501c m896a() {
        return f599a;
    }

    /* renamed from: a */
    public static void m897a(int i, int i2, int i3) {
        f599a = new C0501c(i, i2, i3);
    }

    /* renamed from: a */
    private boolean m898a(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            try {
                threadPoolExecutor.execute(runnable);
                return true;
            } catch (Exception unused) {
                Log.e("bdar: AlgoThreadPool", "AlgoThreadPool execute runnable error");
            }
        }
        return false;
    }

    /* renamed from: c */
    public static void m899c() {
        f599a = null;
    }

    /* renamed from: a */
    public void mo8966a(ThreadPoolExecutor threadPoolExecutor, Queue<byte[]> queue) {
        if (threadPoolExecutor != null) {
            try {
                queue.clear();
                threadPoolExecutor.shutdownNow();
            } catch (Exception e) {
                Log.e("bdar: AlgoThreadPool", "AlgoThreadPool destroy error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo8967a(byte[] bArr, int i) {
        Queue<byte[]> queue;
        if (i == 1) {
            try {
                queue = this.f608j;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            queue = this.f607i;
        }
        queue.add(bArr);
    }

    /* renamed from: a */
    public boolean mo8968a(Runnable runnable) {
        if (!(runnable instanceof C0500b)) {
            return m898a(this.f605g, runnable);
        }
        return m898a(((C0500b) runnable).mo8964d() == 1 ? this.f606h : this.f605g, runnable);
    }

    /* renamed from: a */
    public byte[] mo8969a(int i) {
        if (i != 1) {
            return this.f607i.poll();
        }
        try {
            return this.f608j.poll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void mo8970b() {
        mo8966a(this.f605g, this.f607i);
        mo8966a(this.f606h, this.f608j);
        this.f605g = null;
        this.f606h = null;
        this.f607i = null;
        this.f608j = null;
    }
}
