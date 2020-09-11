package org.greenrobot.eventbus;

import android.util.Log;

/* renamed from: org.greenrobot.eventbus.b */
public final class BackgroundPoster implements Runnable {

    /* renamed from: a */
    private final PendingPostQueue f19020a = new PendingPostQueue();

    /* renamed from: b */
    private final EventBus f19021b;

    /* renamed from: c */
    private volatile boolean f19022c;

    BackgroundPoster(EventBus cVar) {
        this.f19021b = cVar;
    }

    /* renamed from: a */
    public void mo27972a(Subscription mVar, Object obj) {
        PendingPost a = PendingPost.m21807a(mVar, obj);
        synchronized (this) {
            this.f19020a.mo27988a(a);
            if (!this.f19022c) {
                this.f19022c = true;
                this.f19021b.mo27977b().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                PendingPost a = this.f19020a.mo27987a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f19020a.mo27986a();
                        if (a == null) {
                            this.f19022c = false;
                            this.f19022c = false;
                            return;
                        }
                    }
                }
                this.f19021b.mo27975a(a);
            } catch (InterruptedException e) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f19022c = false;
                }
            }
        }
    }
}
