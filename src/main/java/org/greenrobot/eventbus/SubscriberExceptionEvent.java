package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.j */
public final class SubscriberExceptionEvent {

    /* renamed from: a */
    public final EventBus f19074a;

    /* renamed from: b */
    public final Throwable f19075b;

    /* renamed from: c */
    public final Object f19076c;

    /* renamed from: d */
    public final Object f19077d;

    public SubscriberExceptionEvent(EventBus cVar, Throwable th, Object obj, Object obj2) {
        this.f19074a = cVar;
        this.f19075b = th;
        this.f19076c = obj;
        this.f19077d = obj2;
    }
}
