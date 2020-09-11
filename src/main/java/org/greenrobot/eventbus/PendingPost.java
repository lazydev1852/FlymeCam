package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.greenrobot.eventbus.h */
public final class PendingPost {

    /* renamed from: d */
    private static final List<PendingPost> f19068d = new ArrayList();

    /* renamed from: a */
    Object f19069a;

    /* renamed from: b */
    Subscription f19070b;

    /* renamed from: c */
    PendingPost f19071c;

    private PendingPost(Object obj, Subscription mVar) {
        this.f19069a = obj;
        this.f19070b = mVar;
    }

    /* renamed from: a */
    static PendingPost m21807a(Subscription mVar, Object obj) {
        synchronized (f19068d) {
            int size = f19068d.size();
            if (size <= 0) {
                return new PendingPost(obj, mVar);
            }
            PendingPost remove = f19068d.remove(size - 1);
            remove.f19069a = obj;
            remove.f19070b = mVar;
            remove.f19071c = null;
            return remove;
        }
    }

    /* renamed from: a */
    static void m21808a(PendingPost hVar) {
        hVar.f19069a = null;
        hVar.f19070b = null;
        hVar.f19071c = null;
        synchronized (f19068d) {
            if (f19068d.size() < 10000) {
                f19068d.add(hVar);
            }
        }
    }
}
