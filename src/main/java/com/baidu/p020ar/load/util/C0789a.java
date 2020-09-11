package com.baidu.p020ar.load.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.ar.load.util.a */
public class C0789a {

    /* renamed from: a */
    private static final int f1824a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f1825b = (f1824a * 2);

    /* renamed from: c */
    private static final int f1826c = ((f1824a * 4) + 1);

    /* renamed from: d */
    private static final BlockingQueue<Runnable> f1827d = new LinkedBlockingQueue(128);

    /* renamed from: e */
    private static ThreadPoolExecutor f1828e = null;

    /* renamed from: f */
    private static ThreadPoolExecutor f1829f = null;

    /* renamed from: com.baidu.ar.load.util.a$a */
    private static class C0790a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f1830a = new AtomicInteger(1);

        /* renamed from: b */
        private int f1831b = 5;

        public C0790a(int i) {
            this.f1831b = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "ARThreadPool " + this.f1831b + "#" + this.f1830a.getAndIncrement());
            thread.setPriority(this.f1831b);
            return thread;
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m2076a() {
        if (f1828e == null) {
            synchronized (C0789a.class) {
                f1828e = m2078c();
            }
        }
        return f1828e;
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m2077b() {
        if (f1829f == null) {
            synchronized (C0789a.class) {
                f1829f = new ThreadPoolExecutor(5, 5, 15, TimeUnit.SECONDS, f1827d, new C0790a(5), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        }
        return f1829f;
    }

    /* renamed from: c */
    private static ThreadPoolExecutor m2078c() {
        f1828e = new ThreadPoolExecutor(f1825b, f1826c, 15, TimeUnit.SECONDS, f1827d, new C0790a(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        return f1828e;
    }
}
