package com.p006a.p007a.p010b;

import com.p006a.p007a.XMPException;

/* renamed from: com.a.a.b.a */
public final class AliasOptions extends Options {
    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo7613e() {
        return 7680;
    }

    public AliasOptions() {
    }

    public AliasOptions(int i) throws XMPException {
        super(i);
    }

    /* renamed from: a */
    public boolean mo7608a() {
        return mo7619f() == 0;
    }

    /* renamed from: b */
    public boolean mo7610b() {
        return mo7615a(512);
    }

    /* renamed from: a */
    public AliasOptions mo7607a(boolean z) {
        mo7614a(1536, z);
        return this;
    }

    /* renamed from: c */
    public boolean mo7611c() {
        return mo7615a(4096);
    }

    /* renamed from: b */
    public AliasOptions mo7609b(boolean z) {
        mo7614a(7680, z);
        return this;
    }

    /* renamed from: d */
    public PropertyOptions mo7612d() throws XMPException {
        return new PropertyOptions(mo7619f());
    }
}
