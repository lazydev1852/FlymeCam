package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPException;

/* renamed from: com.a.a.a.i */
/* compiled from: ISO8601Converter */
public class C0424i {

    /* renamed from: a */
    private String f56a;

    /* renamed from: b */
    private int f57b = 0;

    public C0424i(String str) {
        this.f56a = str;
    }

    /* renamed from: a */
    public int mo7512a() {
        return this.f56a.length();
    }

    /* renamed from: b */
    public boolean mo7514b() {
        return this.f57b < this.f56a.length();
    }

    /* renamed from: a */
    public char mo7511a(int i) {
        if (i < this.f56a.length()) {
            return this.f56a.charAt(i);
        }
        return 0;
    }

    /* renamed from: c */
    public char mo7515c() {
        if (this.f57b < this.f56a.length()) {
            return this.f56a.charAt(this.f57b);
        }
        return 0;
    }

    /* renamed from: d */
    public void mo7516d() {
        this.f57b++;
    }

    /* renamed from: e */
    public int mo7517e() {
        return this.f57b;
    }

    /* renamed from: a */
    public int mo7513a(String str, int i) throws XMPException {
        char a = mo7511a(this.f57b);
        boolean z = false;
        int i2 = 0;
        while ('0' <= a && a <= '9') {
            i2 = (i2 * 10) + (a - '0');
            this.f57b++;
            a = mo7511a(this.f57b);
            z = true;
        }
        if (!z) {
            throw new XMPException(str, 5);
        } else if (i2 > i) {
            return i;
        } else {
            if (i2 < 0) {
                return 0;
            }
            return i2;
        }
    }
}
