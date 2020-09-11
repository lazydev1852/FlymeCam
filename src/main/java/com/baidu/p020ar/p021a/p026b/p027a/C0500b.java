package com.baidu.p020ar.p021a.p026b.p027a;

import android.util.Log;

/* renamed from: com.baidu.ar.a.b.a.b */
public abstract class C0500b implements Runnable {

    /* renamed from: a */
    protected int f594a;

    /* renamed from: b */
    protected int f595b;

    /* renamed from: c */
    protected C0499a f596c;

    /* renamed from: d */
    int f597d;

    /* renamed from: e */
    private byte[] f598e;

    public C0500b() {
        this.f597d = 0;
    }

    public C0500b(C0499a aVar) {
        this.f597d = 0;
        this.f596c = aVar;
    }

    public C0500b(byte[] bArr, int i, int i2, C0499a aVar) {
        this(bArr, i, i2, aVar, 0);
    }

    public C0500b(byte[] bArr, int i, int i2, C0499a aVar, int i3) {
        this.f597d = 0;
        this.f597d = i3;
        this.f596c = aVar;
        mo8961a(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo8960a() {
        C0501c a;
        if (this.f598e != null && (a = C0501c.m896a()) != null) {
            a.mo8967a(this.f598e, this.f597d);
            this.f598e = null;
        }
    }

    /* renamed from: a */
    public void mo8961a(byte[] bArr, int i, int i2) {
        C0501c a = C0501c.m896a();
        if (a != null) {
            this.f598e = a.mo8969a(this.f597d);
            if (this.f598e != null) {
                System.arraycopy(bArr, 0, this.f598e, 0, this.f598e.length);
            }
            this.f594a = i;
            this.f595b = i2;
        }
    }

    /* renamed from: b */
    public abstract void mo8962b();

    /* renamed from: c */
    public byte[] mo8963c() {
        return this.f598e;
    }

    /* renamed from: d */
    public int mo8964d() {
        return this.f597d;
    }

    public final void run() {
        if (this.f598e == null) {
            Log.e("AlgoRunnable", "bdar: data is null!!!");
            return;
        }
        try {
            mo8962b();
        } finally {
            mo8960a();
        }
    }
}
