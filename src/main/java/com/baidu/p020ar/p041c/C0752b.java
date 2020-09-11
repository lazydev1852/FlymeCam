package com.baidu.p020ar.p041c;

import android.content.Context;
import com.baidu.p020ar.p041c.C0750a;

/* renamed from: com.baidu.ar.c.b */
public class C0752b {

    /* renamed from: a */
    private static C0752b f1652a;

    /* renamed from: b */
    private C0750a f1653b;

    private C0752b(Context context) {
        this.f1653b = new C0750a(context);
    }

    /* renamed from: a */
    public static synchronized C0752b m1958a(Context context) {
        C0752b bVar;
        synchronized (C0752b.class) {
            if (f1652a == null) {
                f1652a = new C0752b(context);
            }
            bVar = f1652a;
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo10083a() {
        if (this.f1653b != null) {
            this.f1653b.mo10078b();
        }
    }

    /* renamed from: a */
    public void mo10084a(C0750a.C0751a aVar) {
        if (this.f1653b != null) {
            this.f1653b.mo10074a(aVar);
            this.f1653b.mo10072a();
        }
    }

    /* renamed from: a */
    public void mo10085a(boolean z) {
        if (this.f1653b != null) {
            this.f1653b.mo10077a(z);
        }
    }
}
