package com.android.volley;

/* renamed from: com.android.volley.t */
public class VolleyError extends Exception {

    /* renamed from: a */
    public final NetworkResponse f347a;

    /* renamed from: b */
    private long f348b;

    public VolleyError() {
        this.f347a = null;
    }

    public VolleyError(NetworkResponse kVar) {
        this.f347a = kVar;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f347a = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8715a(long j) {
        this.f348b = j;
    }
}
