package com.android.volley;

/* renamed from: com.android.volley.e */
public class DefaultRetryPolicy implements RetryPolicy {

    /* renamed from: a */
    private int f308a;

    /* renamed from: b */
    private int f309b;

    /* renamed from: c */
    private final int f310c;

    /* renamed from: d */
    private final float f311d;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f308a = i;
        this.f310c = i2;
        this.f311d = f;
    }

    /* renamed from: a */
    public int mo8685a() {
        return this.f308a;
    }

    /* renamed from: b */
    public int mo8687b() {
        return this.f309b;
    }

    /* renamed from: a */
    public void mo8686a(VolleyError tVar) throws VolleyError {
        this.f309b++;
        this.f308a += (int) (((float) this.f308a) * this.f311d);
        if (!mo8688c()) {
            throw tVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo8688c() {
        return this.f309b <= this.f310c;
    }
}
