package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: org.greenrobot.eventbus.f */
public final class HandlerPoster extends Handler {

    /* renamed from: a */
    private final PendingPostQueue f19062a = new PendingPostQueue();

    /* renamed from: b */
    private final int f19063b;

    /* renamed from: c */
    private final EventBus f19064c;

    /* renamed from: d */
    private boolean f19065d;

    HandlerPoster(EventBus cVar, Looper looper, int i) {
        super(looper);
        this.f19064c = cVar;
        this.f19063b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27984a(Subscription mVar, Object obj) {
        PendingPost a = PendingPost.m21807a(mVar, obj);
        synchronized (this) {
            this.f19062a.mo27988a(a);
            if (!this.f19065d) {
                this.f19065d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a = this.f19062a.mo27986a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f19062a.mo27986a();
                        if (a == null) {
                            this.f19065d = false;
                            this.f19065d = false;
                            return;
                        }
                    }
                }
                this.f19064c.mo27975a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f19063b));
            if (sendMessage(obtainMessage())) {
                this.f19065d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f19065d = false;
            throw th;
        }
    }
}
