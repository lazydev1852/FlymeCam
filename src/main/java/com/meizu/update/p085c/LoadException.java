package com.meizu.update.p085c;

/* renamed from: com.meizu.update.c.e */
public class LoadException extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private int f16207a;

    public LoadException(int i, String str) {
        super(str);
        this.f16207a = i;
    }

    /* renamed from: a */
    public int mo24752a() {
        return this.f16207a;
    }
}
