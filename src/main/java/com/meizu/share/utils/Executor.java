package com.meizu.share.utils;

import androidx.annotation.NonNull;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.meizu.share.utils.a */
public class Executor {

    /* renamed from: b */
    private static volatile Executor f15764b;

    /* renamed from: a */
    private ThreadPoolExecutor f15765a = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, "share-executor-thread");
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    });

    /* renamed from: a */
    public static Executor m17171a() {
        if (f15764b == null) {
            synchronized (Executor.class) {
                if (f15764b == null) {
                    f15764b = new Executor();
                }
            }
        }
        return f15764b;
    }

    private Executor() {
        this.f15765a.allowCoreThreadTimeOut(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Future<?> mo24010a(Runnable runnable) {
        return this.f15765a.submit(runnable);
    }

    /* renamed from: b */
    public void mo24011b(Runnable runnable) {
        this.f15765a.execute(runnable);
    }
}
