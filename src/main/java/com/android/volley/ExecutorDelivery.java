package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.android.volley.f */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a */
    private final Executor f312a;

    public ExecutorDelivery(final Handler handler) {
        this.f312a = new Executor() {
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* renamed from: a */
    public void mo8689a(Request<?> request, Response<?> oVar) {
        mo8690a(request, oVar, (Runnable) null);
    }

    /* renamed from: a */
    public void mo8690a(Request<?> request, Response<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f312a.execute(new C0447a(request, oVar, runnable));
    }

    /* renamed from: a */
    public void mo8691a(Request<?> request, VolleyError tVar) {
        request.addMarker("post-error");
        this.f312a.execute(new C0447a(request, Response.m609a(tVar), (Runnable) null));
    }

    /* renamed from: com.android.volley.f$a */
    /* compiled from: ExecutorDelivery */
    private static class C0447a implements Runnable {

        /* renamed from: a */
        private final Request f315a;

        /* renamed from: b */
        private final Response f316b;

        /* renamed from: c */
        private final Runnable f317c;

        public C0447a(Request request, Response oVar, Runnable runnable) {
            this.f315a = request;
            this.f316b = oVar;
            this.f317c = runnable;
        }

        public void run() {
            if (this.f315a.isCanceled()) {
                this.f315a.finish("canceled-at-delivery");
                return;
            }
            if (this.f316b.mo8712a()) {
                this.f315a.deliverResponse(this.f316b.f343a);
            } else {
                this.f315a.deliverError(this.f316b.f345c);
            }
            if (this.f316b.f346d) {
                this.f315a.addMarker("intermediate-response");
            } else {
                this.f315a.finish("done");
            }
            if (this.f317c != null) {
                this.f317c.run();
            }
        }
    }
}
