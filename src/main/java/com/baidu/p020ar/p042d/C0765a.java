package com.baidu.p020ar.p042d;

/* renamed from: com.baidu.ar.d.a */
public class C0765a {

    /* renamed from: a */
    public int f1679a;

    /* renamed from: b */
    public int f1680b;

    public C0765a(int i, int i2) {
        this.f1679a = i;
        this.f1680b = i2;
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof C0765a)) {
                return false;
            }
            C0765a aVar = (C0765a) obj;
            return this.f1679a == aVar.f1679a && this.f1680b == aVar.f1680b;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int hashCode() {
        return (this.f1679a * 32713) + this.f1680b;
    }
}
