package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.m */
public final class Subscription {

    /* renamed from: a */
    final Object f19097a;

    /* renamed from: b */
    final SubscriberMethod f19098b;

    /* renamed from: c */
    volatile boolean f19099c = true;

    Subscription(Object obj, SubscriberMethod kVar) {
        this.f19097a = obj;
        this.f19098b = kVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription mVar = (Subscription) obj;
        if (this.f19097a != mVar.f19097a || !this.f19098b.equals(mVar.f19098b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f19097a.hashCode() + this.f19098b.f19083f.hashCode();
    }
}
