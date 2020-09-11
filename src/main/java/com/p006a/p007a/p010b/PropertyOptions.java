package com.p006a.p007a.p010b;

import com.p006a.p007a.XMPException;

/* renamed from: com.a.a.b.d */
public final class PropertyOptions extends Options {
    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo7613e() {
        return -2147475470;
    }

    public PropertyOptions() {
    }

    public PropertyOptions(int i) throws XMPException {
        super(i);
    }

    /* renamed from: a */
    public boolean mo7629a() {
        return mo7615a(2);
    }

    /* renamed from: a */
    public PropertyOptions mo7627a(boolean z) {
        mo7614a(2, z);
        return this;
    }

    /* renamed from: b */
    public PropertyOptions mo7630b(boolean z) {
        mo7614a(16, z);
        return this;
    }

    /* renamed from: b */
    public boolean mo7631b() {
        return mo7615a(32);
    }

    /* renamed from: c */
    public PropertyOptions mo7632c(boolean z) {
        mo7614a(32, z);
        return this;
    }

    /* renamed from: c */
    public boolean mo7633c() {
        return mo7615a(64);
    }

    /* renamed from: d */
    public PropertyOptions mo7634d(boolean z) {
        mo7614a(64, z);
        return this;
    }

    /* renamed from: e */
    public PropertyOptions mo7636e(boolean z) {
        mo7614a(128, z);
        return this;
    }

    /* renamed from: d */
    public boolean mo7635d() {
        return mo7615a(256);
    }

    /* renamed from: f */
    public PropertyOptions mo7637f(boolean z) {
        mo7614a(256, z);
        return this;
    }

    /* renamed from: g */
    public boolean mo7639g() {
        return mo7615a(512);
    }

    /* renamed from: g */
    public PropertyOptions mo7638g(boolean z) {
        mo7614a(512, z);
        return this;
    }

    /* renamed from: h */
    public boolean mo7641h() {
        return mo7615a(1024);
    }

    /* renamed from: h */
    public PropertyOptions mo7640h(boolean z) {
        mo7614a(1024, z);
        return this;
    }

    /* renamed from: i */
    public boolean mo7643i() {
        return mo7615a(2048);
    }

    /* renamed from: i */
    public PropertyOptions mo7642i(boolean z) {
        mo7614a(2048, z);
        return this;
    }

    /* renamed from: j */
    public boolean mo7645j() {
        return mo7615a(4096);
    }

    /* renamed from: j */
    public PropertyOptions mo7644j(boolean z) {
        mo7614a(4096, z);
        return this;
    }

    /* renamed from: k */
    public boolean mo7647k() {
        return mo7615a(Integer.MIN_VALUE);
    }

    /* renamed from: k */
    public PropertyOptions mo7646k(boolean z) {
        mo7614a(Integer.MIN_VALUE, z);
        return this;
    }

    /* renamed from: l */
    public boolean mo7648l() {
        return (mo7619f() & 768) > 0;
    }

    /* renamed from: m */
    public boolean mo7649m() {
        return (mo7619f() & 768) == 0;
    }

    /* renamed from: a */
    public void mo7628a(PropertyOptions dVar) throws XMPException {
        if (dVar != null) {
            mo7616b(dVar.mo7619f() | mo7619f());
        }
    }

    /* renamed from: c */
    public void mo7617c(int i) throws XMPException {
        if ((i & 256) > 0 && (i & 512) > 0) {
            throw new XMPException("IsStruct and IsArray options are mutually exclusive", 103);
        } else if ((i & 2) > 0 && (i & 768) > 0) {
            throw new XMPException("Structs and arrays can't have \"value\" options", 103);
        }
    }
}
