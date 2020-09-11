package com.p006a.p007a.p010b;

import com.p006a.p007a.XMPException;
import org.apaches.commons.codec.CharEncoding;

/* renamed from: com.a.a.b.e */
public final class SerializeOptions extends Options {

    /* renamed from: a */
    private int f112a = 2048;

    /* renamed from: b */
    private String f113b = "\n";

    /* renamed from: c */
    private String f114c = "  ";

    /* renamed from: d */
    private int f115d = 0;

    /* renamed from: e */
    private boolean f116e = false;

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo7613e() {
        return 4976;
    }

    public SerializeOptions() {
    }

    public SerializeOptions(int i) throws XMPException {
        super(i);
    }

    /* renamed from: a */
    public boolean mo7652a() {
        return mo7615a(16);
    }

    /* renamed from: a */
    public SerializeOptions mo7651a(boolean z) {
        mo7614a(16, z);
        return this;
    }

    /* renamed from: b */
    public boolean mo7655b() {
        return mo7615a(32);
    }

    /* renamed from: c */
    public boolean mo7656c() {
        return mo7615a(64);
    }

    /* renamed from: b */
    public SerializeOptions mo7654b(boolean z) {
        mo7614a(64, z);
        return this;
    }

    /* renamed from: d */
    public boolean mo7659d() {
        return mo7615a(256);
    }

    /* renamed from: g */
    public boolean mo7661g() {
        return mo7615a(512);
    }

    /* renamed from: h */
    public boolean mo7662h() {
        return mo7615a(4096);
    }

    /* renamed from: i */
    public boolean mo7663i() {
        return (mo7619f() & 3) == 2;
    }

    /* renamed from: j */
    public boolean mo7664j() {
        return (mo7619f() & 3) == 3;
    }

    /* renamed from: k */
    public int mo7665k() {
        return this.f115d;
    }

    /* renamed from: d */
    public SerializeOptions mo7658d(int i) {
        this.f115d = i;
        return this;
    }

    /* renamed from: l */
    public String mo7666l() {
        return this.f114c;
    }

    /* renamed from: a */
    public SerializeOptions mo7650a(String str) {
        this.f114c = str;
        return this;
    }

    /* renamed from: m */
    public String mo7667m() {
        return this.f113b;
    }

    /* renamed from: b */
    public SerializeOptions mo7653b(String str) {
        this.f113b = str;
        return this;
    }

    /* renamed from: n */
    public int mo7668n() {
        return this.f112a;
    }

    /* renamed from: e */
    public SerializeOptions mo7660e(int i) {
        this.f112a = i;
        return this;
    }

    /* renamed from: o */
    public boolean mo7669o() {
        return this.f116e;
    }

    /* renamed from: p */
    public String mo7670p() {
        if (mo7663i()) {
            return CharEncoding.UTF_16BE;
        }
        return mo7664j() ? CharEncoding.UTF_16LE : "UTF-8";
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            SerializeOptions eVar = new SerializeOptions(mo7619f());
            eVar.mo7658d(this.f115d);
            eVar.mo7650a(this.f114c);
            eVar.mo7653b(this.f113b);
            eVar.mo7660e(this.f112a);
            return eVar;
        } catch (XMPException unused) {
            return null;
        }
    }
}
