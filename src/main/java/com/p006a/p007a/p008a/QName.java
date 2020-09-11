package com.p006a.p007a.p008a;

/* renamed from: com.a.a.a.j */
public class QName {

    /* renamed from: a */
    private String f58a;

    /* renamed from: b */
    private String f59b;

    public QName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.f58a = str.substring(0, indexOf);
            this.f59b = str.substring(indexOf + 1);
            return;
        }
        this.f58a = "";
        this.f59b = str;
    }

    /* renamed from: a */
    public boolean mo7518a() {
        return this.f58a != null && this.f58a.length() > 0;
    }

    /* renamed from: b */
    public String mo7519b() {
        return this.f58a;
    }
}
