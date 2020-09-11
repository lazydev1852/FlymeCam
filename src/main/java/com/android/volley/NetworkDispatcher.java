package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.android.volley.i */
public class NetworkDispatcher extends Thread {

    /* renamed from: a */
    private final BlockingQueue<Request<?>> f320a;

    /* renamed from: b */
    private final Network f321b;

    /* renamed from: c */
    private final Cache f322c;

    /* renamed from: d */
    private final ResponseDelivery f323d;

    /* renamed from: e */
    private volatile boolean f324e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network hVar, Cache bVar, ResponseDelivery pVar) {
        this.f320a = blockingQueue;
        this.f321b = hVar;
        this.f322c = bVar;
        this.f323d = pVar;
    }

    /* renamed from: a */
    public void mo8700a() {
        this.f324e = true;
        interrupt();
    }

    @TargetApi(14)
    /* renamed from: b */
    private void m594b(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m593b();
            } catch (InterruptedException unused) {
                if (this.f324e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.m729c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    /* renamed from: b */
    private void m593b() throws InterruptedException {
        mo8701a(this.f320a.take());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo8701a(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
                request.notifyListenerResponseNotUsable();
                return;
            }
            m594b(request);
            NetworkResponse a = this.f321b.mo8699a(request);
            request.addMarker("network-http-complete");
            if (!a.f329e || !request.hasHadResponseDelivered()) {
                Response<?> parseNetworkResponse = request.parseNetworkResponse(a);
                request.addMarker("network-parse-complete");
                if (request.shouldCache() && parseNetworkResponse.f344b != null) {
                    this.f322c.mo8678a(request.getCacheKey(), parseNetworkResponse.f344b);
                    request.addMarker("network-cache-written");
                }
                request.markDelivered();
                this.f323d.mo8689a(request, parseNetworkResponse);
                request.notifyListenerResponseReceived(parseNetworkResponse);
                return;
            }
            request.finish("not-modified");
            request.notifyListenerResponseNotUsable();
        } catch (VolleyError e) {
            e.mo8715a(SystemClock.elapsedRealtime() - elapsedRealtime);
            m592a(request, e);
            request.notifyListenerResponseNotUsable();
        } catch (Exception e2) {
            VolleyLog.m727a(e2, "Unhandled exception %s", e2.toString());
            VolleyError tVar = new VolleyError((Throwable) e2);
            tVar.mo8715a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f323d.mo8691a(request, tVar);
            request.notifyListenerResponseNotUsable();
        }
    }

    /* renamed from: a */
    private void m592a(Request<?> request, VolleyError tVar) {
        this.f323d.mo8691a(request, request.parseNetworkError(tVar));
    }
}
