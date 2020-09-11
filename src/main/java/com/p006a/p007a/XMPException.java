package com.p006a.p007a;

/* renamed from: com.a.a.c */
public class XMPException extends Exception {

    /* renamed from: a */
    private int f117a;

    public XMPException(String str, int i) {
        super(str);
        this.f117a = i;
    }

    public XMPException(String str, int i, Throwable th) {
        super(str, th);
        this.f117a = i;
    }

    /* renamed from: a */
    public int mo7671a() {
        return this.f117a;
    }
}
