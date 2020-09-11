package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.a */
public class AsyncPoster implements Runnable {

    /* renamed from: a */
    private final PendingPostQueue f19018a = new PendingPostQueue();

    /* renamed from: b */
    private final EventBus f19019b;

    AsyncPoster(EventBus cVar) {
        this.f19019b = cVar;
    }

    /* renamed from: a */
    public void mo27966a(Subscription mVar, Object obj) {
        this.f19018a.mo27988a(PendingPost.m21807a(mVar, obj));
        this.f19019b.mo27977b().execute(this);
    }

    public void run() {
        PendingPost a = this.f19018a.mo27986a();
        if (a != null) {
            this.f19019b.mo27975a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
