package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.android.volley.n */
public class RequestQueue {

    /* renamed from: a */
    private final AtomicInteger f331a;

    /* renamed from: b */
    private final Set<Request<?>> f332b;

    /* renamed from: c */
    private final PriorityBlockingQueue<Request<?>> f333c;

    /* renamed from: d */
    private final PriorityBlockingQueue<Request<?>> f334d;

    /* renamed from: e */
    private final Cache f335e;

    /* renamed from: f */
    private final Network f336f;

    /* renamed from: g */
    private final ResponseDelivery f337g;

    /* renamed from: h */
    private final NetworkDispatcher[] f338h;

    /* renamed from: i */
    private CacheDispatcher f339i;

    /* renamed from: j */
    private final List<C0450b> f340j;

    /* renamed from: com.android.volley.n$a */
    /* compiled from: RequestQueue */
    public interface C0449a {
        /* renamed from: a */
        boolean mo8710a(Request<?> request);
    }

    /* renamed from: com.android.volley.n$b */
    /* compiled from: RequestQueue */
    public interface C0450b<T> {
        /* renamed from: a */
        void mo8711a(Request<T> request);
    }

    public RequestQueue(Cache bVar, Network hVar, int i, ResponseDelivery pVar) {
        this.f331a = new AtomicInteger();
        this.f332b = new HashSet();
        this.f333c = new PriorityBlockingQueue<>();
        this.f334d = new PriorityBlockingQueue<>();
        this.f340j = new ArrayList();
        this.f335e = bVar;
        this.f336f = hVar;
        this.f338h = new NetworkDispatcher[i];
        this.f337g = pVar;
    }

    public RequestQueue(Cache bVar, Network hVar, int i) {
        this(bVar, hVar, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache bVar, Network hVar) {
        this(bVar, hVar, 4);
    }

    /* renamed from: a */
    public void mo8704a() {
        mo8707b();
        this.f339i = new CacheDispatcher(this.f333c, this.f334d, this.f335e, this.f337g);
        this.f339i.start();
        for (int i = 0; i < this.f338h.length; i++) {
            NetworkDispatcher iVar = new NetworkDispatcher(this.f334d, this.f336f, this.f335e, this.f337g);
            this.f338h[i] = iVar;
            iVar.start();
        }
    }

    /* renamed from: b */
    public void mo8707b() {
        if (this.f339i != null) {
            this.f339i.mo8681a();
        }
        for (NetworkDispatcher iVar : this.f338h) {
            if (iVar != null) {
                iVar.mo8700a();
            }
        }
    }

    /* renamed from: c */
    public int mo8709c() {
        return this.f331a.incrementAndGet();
    }

    /* renamed from: a */
    public void mo8705a(C0449a aVar) {
        synchronized (this.f332b) {
            for (Request next : this.f332b) {
                if (aVar.mo8710a(next)) {
                    next.cancel();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8706a(final Object obj) {
        if (obj != null) {
            mo8705a((C0449a) new C0449a() {
                /* renamed from: a */
                public boolean mo8710a(Request<?> request) {
                    return request.getTag() == obj;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    /* renamed from: a */
    public <T> Request<T> mo8703a(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f332b) {
            this.f332b.add(request);
        }
        request.setSequence(mo8709c());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.f334d.add(request);
            return request;
        }
        this.f333c.add(request);
        return request;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> void mo8708b(Request<T> request) {
        synchronized (this.f332b) {
            this.f332b.remove(request);
        }
        synchronized (this.f340j) {
            for (C0450b a : this.f340j) {
                a.mo8711a(request);
            }
        }
    }
}
