package com.meizu.media.camera.portrait;

import com.meizu.media.camera.p067d.Rational;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class FractionNum {
    public static ChangeQuickRedirect changeQuickRedirect;
    long denominator;
    long numerator;

    public FractionNum(long j, long j2) {
        this.numerator = j;
        this.denominator = j2;
    }

    public Rational toRational() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5407, new Class[0], Rational.class);
        return proxy.isSupported ? (Rational) proxy.result : new Rational(this.numerator, this.denominator);
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5408, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return this.numerator + "/" + this.denominator;
    }
}
