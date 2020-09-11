package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.p119a.SubscriberInfoIndex;

/* renamed from: org.greenrobot.eventbus.d */
public class EventBusBuilder {

    /* renamed from: k */
    private static final ExecutorService f19051k = Executors.newCachedThreadPool();

    /* renamed from: a */
    boolean f19052a = true;

    /* renamed from: b */
    boolean f19053b = true;

    /* renamed from: c */
    boolean f19054c = true;

    /* renamed from: d */
    boolean f19055d = true;

    /* renamed from: e */
    boolean f19056e;

    /* renamed from: f */
    boolean f19057f = true;

    /* renamed from: g */
    boolean f19058g;

    /* renamed from: h */
    boolean f19059h;

    /* renamed from: i */
    ExecutorService f19060i = f19051k;

    /* renamed from: j */
    List<SubscriberInfoIndex> f19061j;

    EventBusBuilder() {
    }
}
