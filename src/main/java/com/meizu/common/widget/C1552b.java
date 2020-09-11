package com.meizu.common.widget;

/* renamed from: com.meizu.common.widget.b */
/* compiled from: Switch */
public class C1552b {

    /* renamed from: a */
    public static final C1552b f6338a = new C1552b(0, 0, 0, 0);

    /* renamed from: b */
    public final int f6339b;

    /* renamed from: c */
    public final int f6340c;

    /* renamed from: d */
    public final int f6341d;

    /* renamed from: e */
    public final int f6342e;

    private C1552b(int i, int i2, int i3, int i4) {
        this.f6339b = i;
        this.f6340c = i2;
        this.f6341d = i3;
        this.f6342e = i4;
    }

    /* renamed from: a */
    public static C1552b m6257a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return f6338a;
        }
        return new C1552b(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1552b bVar = (C1552b) obj;
        if (this.f6342e == bVar.f6342e && this.f6339b == bVar.f6339b && this.f6341d == bVar.f6341d && this.f6340c == bVar.f6340c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f6339b * 31) + this.f6340c) * 31) + this.f6341d) * 31) + this.f6342e;
    }

    public String toString() {
        return "Insets{left=" + this.f6339b + ", top=" + this.f6340c + ", right=" + this.f6341d + ", bottom=" + this.f6342e + '}';
    }
}
