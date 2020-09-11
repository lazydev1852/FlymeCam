package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.i */
public final class PendingPostQueue {

    /* renamed from: a */
    private PendingPost f19072a;

    /* renamed from: b */
    private PendingPost f19073b;

    PendingPostQueue() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo27988a(PendingPost hVar) {
        if (hVar != null) {
            if (this.f19073b != null) {
                this.f19073b.f19071c = hVar;
                this.f19073b = hVar;
            } else if (this.f19072a == null) {
                this.f19073b = hVar;
                this.f19072a = hVar;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized PendingPost mo27986a() {
        PendingPost hVar;
        hVar = this.f19072a;
        if (this.f19072a != null) {
            this.f19072a = this.f19072a.f19071c;
            if (this.f19072a == null) {
                this.f19073b = null;
            }
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized PendingPost mo27987a(int i) throws InterruptedException {
        if (this.f19072a == null) {
            wait((long) i);
        }
        return mo27986a();
    }
}
