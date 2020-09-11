package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* renamed from: org.greenrobot.eventbus.k */
public class SubscriberMethod {

    /* renamed from: a */
    final Method f19078a;

    /* renamed from: b */
    final ThreadMode f19079b;

    /* renamed from: c */
    final Class<?> f19080c;

    /* renamed from: d */
    final int f19081d;

    /* renamed from: e */
    final boolean f19082e;

    /* renamed from: f */
    String f19083f;

    public SubscriberMethod(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f19078a = method;
        this.f19079b = threadMode;
        this.f19080c = cls;
        this.f19081d = i;
        this.f19082e = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        m21812a();
        SubscriberMethod kVar = (SubscriberMethod) obj;
        kVar.m21812a();
        return this.f19083f.equals(kVar.f19083f);
    }

    /* renamed from: a */
    private synchronized void m21812a() {
        if (this.f19083f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f19078a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f19078a.getName());
            sb.append('(');
            sb.append(this.f19080c.getName());
            this.f19083f = sb.toString();
        }
    }

    public int hashCode() {
        return this.f19078a.hashCode();
    }
}
