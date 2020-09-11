package com.meizu.media.camera.util;

import android.os.Process;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.meizu.media.camera.util.al */
public class PriorityThreadFactory implements ThreadFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f14106a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f14107b;

    /* renamed from: c */
    private final AtomicInteger f14108c = new AtomicInteger();

    /* renamed from: d */
    private final String f14109d;

    public PriorityThreadFactory(String str, int i) {
        this.f14109d = str;
        this.f14107b = i;
    }

    public Thread newThread(Runnable runnable) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{runnable}, this, f14106a, false, 8176, new Class[]{Runnable.class}, Thread.class);
        if (proxy.isSupported) {
            return (Thread) proxy.result;
        }
        return new Thread(runnable, this.f14109d + '-' + this.f14108c.getAndIncrement()) {

            /* renamed from: a */
            public static ChangeQuickRedirect f14110a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f14110a, false, 8177, new Class[0], Void.TYPE).isSupported) {
                    Process.setThreadPriority(PriorityThreadFactory.this.f14107b);
                    super.run();
                }
            }
        };
    }
}
