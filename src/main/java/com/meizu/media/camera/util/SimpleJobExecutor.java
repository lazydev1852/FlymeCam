package com.meizu.media.camera.util;

import android.os.Handler;
import com.meizu.media.camera.p064a.AsyncResource;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.an */
public class SimpleJobExecutor<T> implements AsyncResource.C1783a<T> {

    /* renamed from: b */
    public static ChangeQuickRedirect f14115b;

    /* renamed from: a */
    private JobLimiter f14116a;

    /* renamed from: c */
    private Handler f14117c = new Handler();

    public SimpleJobExecutor(int i) {
        this.f14116a = new JobLimiter(new ThreadPool(), i);
    }

    /* renamed from: a */
    public Future<T> mo18716a(ThreadPool.C2637b<T> bVar, FutureListener<T> wVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar, wVar}, this, f14115b, false, 8196, new Class[]{ThreadPool.C2637b.class, FutureListener.class}, Future.class);
        return proxy.isSupported ? (Future) proxy.result : this.f14116a.mo22652a(bVar, wVar);
    }

    /* renamed from: a */
    public void mo18717a(Runnable runnable) {
        if (!PatchProxy.proxy(new Object[]{runnable}, this, f14115b, false, 8197, new Class[]{Runnable.class}, Void.TYPE).isSupported) {
            this.f14117c.post(runnable);
        }
    }
}
