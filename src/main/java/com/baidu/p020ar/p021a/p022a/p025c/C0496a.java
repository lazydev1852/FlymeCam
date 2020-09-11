package com.baidu.p020ar.p021a.p022a.p025c;

/* renamed from: com.baidu.ar.a.a.c.a */
public class C0496a {

    /* renamed from: a */
    private int f579a = -1;

    /* renamed from: b */
    private int f580b = -1;

    /* renamed from: a */
    public boolean mo8953a() {
        return (this.f579a == 1 || this.f579a == -1) && this.f580b == 0;
    }

    /* renamed from: a */
    public boolean mo8954a(boolean z) {
        if (this.f580b != -1) {
            this.f579a = this.f580b;
            this.f580b = z ^ true ? 1 : 0;
        } else if (z) {
            this.f579a = this.f580b;
            this.f580b = 0;
        }
        return this.f580b != -1;
    }

    /* renamed from: b */
    public boolean mo8955b() {
        return this.f579a == 0 && this.f580b == 1;
    }

    /* renamed from: c */
    public void mo8956c() {
        this.f579a = -1;
        this.f580b = -1;
    }
}
