package com.p006a.p007a.p010b;

import com.p006a.p007a.XMPException;
import java.util.Map;

/* renamed from: com.a.a.b.b */
public abstract class Options {

    /* renamed from: a */
    private int f110a = 0;

    /* renamed from: b */
    private Map f111b = null;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7617c(int i) throws XMPException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract int mo7613e();

    public Options() {
    }

    public Options(int i) throws XMPException {
        mo7658d(i);
        mo7616b(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7615a(int i) {
        return (i & this.f110a) != 0;
    }

    /* renamed from: a */
    public void mo7614a(int i, boolean z) {
        int i2;
        if (z) {
            i2 = i | this.f110a;
        } else {
            i2 = (~i) & this.f110a;
        }
        this.f110a = i2;
    }

    /* renamed from: f */
    public int mo7619f() {
        return this.f110a;
    }

    /* renamed from: b */
    public void mo7616b(int i) throws XMPException {
        mo7658d(i);
        this.f110a = i;
    }

    public boolean equals(Object obj) {
        return mo7619f() == ((Options) obj).mo7619f();
    }

    public int hashCode() {
        return mo7619f();
    }

    public String toString() {
        return "0x" + Integer.toHexString(this.f110a);
    }

    /* renamed from: d */
    private void mo7658d(int i) throws XMPException {
        int i2 = (~mo7613e()) & i;
        if (i2 == 0) {
            mo7617c(i);
            return;
        }
        throw new XMPException("The option bit(s) 0x" + Integer.toHexString(i2) + " are invalid!", 103);
    }
}
