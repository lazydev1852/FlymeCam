package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.d.l */
public class Rational {

    /* renamed from: a */
    public static ChangeQuickRedirect f9480a;

    /* renamed from: b */
    private final long f9481b;

    /* renamed from: c */
    private final long f9482c;

    public Rational(long j, long j2) {
        this.f9481b = j;
        this.f9482c = j2;
    }

    public Rational(Rational lVar) {
        this.f9481b = lVar.f9481b;
        this.f9482c = lVar.f9482c;
    }

    /* renamed from: a */
    public long mo19954a() {
        return this.f9481b;
    }

    /* renamed from: b */
    public long mo19955b() {
        return this.f9482c;
    }

    /* renamed from: c */
    public double mo19956c() {
        return ((double) this.f9481b) / ((double) this.f9482c);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rational)) {
            return false;
        }
        Rational lVar = (Rational) obj;
        if (this.f9481b == lVar.f9481b && this.f9482c == lVar.f9482c) {
            return true;
        }
        return false;
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9480a, false, 4012, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return this.f9481b + "/" + this.f9482c;
    }
}
