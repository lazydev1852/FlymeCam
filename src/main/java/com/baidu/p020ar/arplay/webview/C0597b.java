package com.baidu.p020ar.arplay.webview;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.arplay.webview.b */
public class C0597b {

    /* renamed from: a */
    private static C0597b f955a;

    /* renamed from: b */
    private List<C0596a> f956b = new ArrayList();

    private C0597b() {
    }

    /* renamed from: a */
    public static C0597b m1195a() {
        if (f955a == null) {
            synchronized (C0597b.class) {
                if (f955a == null) {
                    f955a = new C0597b();
                }
            }
        }
        return f955a;
    }

    /* renamed from: a */
    public C0596a mo9429a(int i) {
        if (this.f956b == null) {
            return null;
        }
        for (C0596a next : this.f956b) {
            if (next != null && next.f948a == i) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0596a mo9430a(int i, int i2, int i3) {
        if (this.f956b != null) {
            for (C0596a next : this.f956b) {
                if (next != null && next.f948a == i) {
                    next.mo9425a(i2, i3);
                    return next;
                }
            }
        }
        C0596a aVar = new C0596a();
        aVar.mo9423a(i, i2, i3);
        if (this.f956b != null) {
            this.f956b.add(aVar);
        }
        return aVar;
    }

    /* renamed from: b */
    public void mo9431b() {
        if (this.f956b != null) {
            for (C0596a next : this.f956b) {
                if (next != null) {
                    next.mo9428d();
                }
            }
            this.f956b.clear();
        }
        if (f955a != null) {
            f955a = null;
        }
    }
}
