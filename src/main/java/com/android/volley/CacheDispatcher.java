package com.android.volley;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.android.volley.Cache;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.android.volley.c */
public class CacheDispatcher extends Thread {

    /* renamed from: a */
    private static final boolean f297a = VolleyLog.f420b;

    /* renamed from: b */
    private final BlockingQueue<Request<?>> f298b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BlockingQueue<Request<?>> f299c;

    /* renamed from: d */
    private final Cache f300d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ResponseDelivery f301e;

    /* renamed from: f */
    private volatile boolean f302f = false;

    /* renamed from: g */
    private final C0445a f303g;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache bVar, ResponseDelivery pVar) {
        this.f298b = blockingQueue;
        this.f299c = blockingQueue2;
        this.f300d = bVar;
        this.f301e = pVar;
        this.f303g = new C0445a(this);
    }

    /* renamed from: a */
    public void mo8681a() {
        this.f302f = true;
        interrupt();
    }

    public void run() {
        if (f297a) {
            VolleyLog.m726a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f300d.mo8677a();
        while (true) {
            try {
                m575b();
            } catch (InterruptedException unused) {
                if (this.f302f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.m729c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    /* renamed from: b */
    private void m575b() throws InterruptedException {
        mo8682a(this.f298b.take());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo8682a(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        if (request.isCanceled()) {
            request.finish("cache-discard-canceled");
            return;
        }
        Cache.C0443a a = this.f300d.mo8676a(request.getCacheKey());
        if (a == null) {
            request.addMarker("cache-miss");
            if (!this.f303g.m579b(request)) {
                this.f299c.put(request);
            }
        } else if (a.mo8679a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a);
            if (!this.f303g.m579b(request)) {
                this.f299c.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            Response<?> parseNetworkResponse = request.parseNetworkResponse(new NetworkResponse(a.f289a, a.f295g));
            request.addMarker("cache-hit-parsed");
            if (!a.mo8680b()) {
                this.f301e.mo8689a(request, parseNetworkResponse);
                return;
            }
            request.addMarker("cache-hit-refresh-needed");
            request.setCacheEntry(a);
            parseNetworkResponse.f346d = true;
            if (!this.f303g.m579b(request)) {
                this.f301e.mo8690a(request, parseNetworkResponse, new Runnable() {
                    public void run() {
                        try {
                            CacheDispatcher.this.f299c.put(request);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
            } else {
                this.f301e.mo8689a(request, parseNetworkResponse);
            }
        }
    }

    /* renamed from: com.android.volley.c$a */
    /* compiled from: CacheDispatcher */
    private static class C0445a implements Request.C0442a {

        /* renamed from: a */
        private final Map<String, List<Request<?>>> f306a = new HashMap();

        /* renamed from: b */
        private final CacheDispatcher f307b;

        C0445a(CacheDispatcher cVar) {
            this.f307b = cVar;
        }

        /* renamed from: a */
        public void mo8674a(Request<?> request, Response<?> oVar) {
            List<Request> remove;
            if (oVar.f344b == null || oVar.f344b.mo8679a()) {
                mo8673a(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f306a.remove(cacheKey);
            }
            if (remove != null) {
                if (VolleyLog.f420b) {
                    VolleyLog.m726a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request a : remove) {
                    this.f307b.f301e.mo8689a((Request<?>) a, oVar);
                }
            }
        }

        /* renamed from: a */
        public synchronized void mo8673a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List remove = this.f306a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (VolleyLog.f420b) {
                    VolleyLog.m726a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request request2 = (Request) remove.remove(0);
                this.f306a.put(cacheKey, remove);
                request2.setNetworkRequestCompleteListener(this);
                try {
                    this.f307b.f299c.put(request2);
                } catch (InterruptedException e) {
                    VolleyLog.m729c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.f307b.mo8681a();
                }
            }
            return;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            return false;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean m579b(com.android.volley.Request<?> r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                java.lang.String r0 = r6.getCacheKey()     // Catch:{ all -> 0x0052 }
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.f306a     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x003a
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.f306a     // Catch:{ all -> 0x0052 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
                if (r1 != 0) goto L_0x001e
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
                r1.<init>()     // Catch:{ all -> 0x0052 }
            L_0x001e:
                java.lang.String r4 = "waiting-for-response"
                r6.addMarker(r4)     // Catch:{ all -> 0x0052 }
                r1.add(r6)     // Catch:{ all -> 0x0052 }
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r6 = r5.f306a     // Catch:{ all -> 0x0052 }
                r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
                boolean r6 = com.android.volley.VolleyLog.f420b     // Catch:{ all -> 0x0052 }
                if (r6 == 0) goto L_0x0038
                java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
                java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
                r1[r3] = r0     // Catch:{ all -> 0x0052 }
                com.android.volley.VolleyLog.m728b(r6, r1)     // Catch:{ all -> 0x0052 }
            L_0x0038:
                monitor-exit(r5)
                return r2
            L_0x003a:
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.f306a     // Catch:{ all -> 0x0052 }
                r4 = 0
                r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
                r6.setNetworkRequestCompleteListener(r5)     // Catch:{ all -> 0x0052 }
                boolean r6 = com.android.volley.VolleyLog.f420b     // Catch:{ all -> 0x0052 }
                if (r6 == 0) goto L_0x0050
                java.lang.String r6 = "new request, sending to network %s"
                java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
                r1[r3] = r0     // Catch:{ all -> 0x0052 }
                com.android.volley.VolleyLog.m728b(r6, r1)     // Catch:{ all -> 0x0052 }
            L_0x0050:
                monitor-exit(r5)
                return r3
            L_0x0052:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.volley.CacheDispatcher.C0445a.m579b(com.android.volley.Request):boolean");
        }
    }
}
