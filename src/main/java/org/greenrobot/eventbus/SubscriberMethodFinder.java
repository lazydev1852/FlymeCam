package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.p119a.SubscriberInfo;
import org.greenrobot.eventbus.p119a.SubscriberInfoIndex;

/* renamed from: org.greenrobot.eventbus.l */
public class SubscriberMethodFinder {

    /* renamed from: a */
    private static final Map<Class<?>, List<SubscriberMethod>> f19084a = new ConcurrentHashMap();

    /* renamed from: e */
    private static final C3591a[] f19085e = new C3591a[4];

    /* renamed from: b */
    private List<SubscriberInfoIndex> f19086b;

    /* renamed from: c */
    private final boolean f19087c;

    /* renamed from: d */
    private final boolean f19088d;

    SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.f19086b = list;
        this.f19087c = z;
        this.f19088d = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<SubscriberMethod> mo27991a(Class<?> cls) {
        List<SubscriberMethod> list;
        List<SubscriberMethod> list2 = f19084a.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f19088d) {
            list = m21817c(cls);
        } else {
            list = m21815b(cls);
        }
        if (!list.isEmpty()) {
            f19084a.put(cls, list);
            return list;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* renamed from: b */
    private List<SubscriberMethod> m21815b(Class<?> cls) {
        C3591a a = m21814a();
        a.mo27993a(cls);
        while (a.f19094f != null) {
            a.f19096h = m21816b(a);
            if (a.f19096h != null) {
                for (SubscriberMethod kVar : a.f19096h.mo27969b()) {
                    if (a.mo27994a(kVar.f19078a, kVar.f19080c)) {
                        a.f19089a.add(kVar);
                    }
                }
            } else {
                m21818c(a);
            }
            a.mo27995b();
        }
        return m21813a(a);
    }

    /* renamed from: a */
    private List<SubscriberMethod> m21813a(C3591a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f19089a);
        aVar.mo27992a();
        synchronized (f19085e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    if (f19085e[i] == null) {
                        f19085e[i] = aVar;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private C3591a m21814a() {
        synchronized (f19085e) {
            int i = 0;
            while (i < 4) {
                try {
                    C3591a aVar = f19085e[i];
                    if (aVar != null) {
                        f19085e[i] = null;
                        return aVar;
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new C3591a();
        }
    }

    /* renamed from: b */
    private SubscriberInfo m21816b(C3591a aVar) {
        if (!(aVar.f19096h == null || aVar.f19096h.mo27970c() == null)) {
            SubscriberInfo c = aVar.f19096h.mo27970c();
            if (aVar.f19094f == c.mo27968a()) {
                return c;
            }
        }
        if (this.f19086b == null) {
            return null;
        }
        for (SubscriberInfoIndex a : this.f19086b) {
            SubscriberInfo a2 = a.mo27971a(aVar.f19094f);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* renamed from: c */
    private List<SubscriberMethod> m21817c(Class<?> cls) {
        C3591a a = m21814a();
        a.mo27993a(cls);
        while (a.f19094f != null) {
            m21818c(a);
            a.mo27995b();
        }
        return m21813a(a);
    }

    /* renamed from: c */
    private void m21818c(C3591a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f19094f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f19094f.getMethods();
            aVar.f19095g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (subscribe != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.mo27994a(method, cls)) {
                            aVar.f19089a.add(new SubscriberMethod(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                        }
                    }
                } else if (this.f19087c && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f19087c && method.isAnnotationPresent(Subscribe.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    /* renamed from: org.greenrobot.eventbus.l$a */
    /* compiled from: SubscriberMethodFinder */
    static class C3591a {

        /* renamed from: a */
        final List<SubscriberMethod> f19089a = new ArrayList();

        /* renamed from: b */
        final Map<Class, Object> f19090b = new HashMap();

        /* renamed from: c */
        final Map<String, Class> f19091c = new HashMap();

        /* renamed from: d */
        final StringBuilder f19092d = new StringBuilder(128);

        /* renamed from: e */
        Class<?> f19093e;

        /* renamed from: f */
        Class<?> f19094f;

        /* renamed from: g */
        boolean f19095g;

        /* renamed from: h */
        SubscriberInfo f19096h;

        C3591a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27993a(Class<?> cls) {
            this.f19094f = cls;
            this.f19093e = cls;
            this.f19095g = false;
            this.f19096h = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27992a() {
            this.f19089a.clear();
            this.f19090b.clear();
            this.f19091c.clear();
            this.f19092d.setLength(0);
            this.f19093e = null;
            this.f19094f = null;
            this.f19095g = false;
            this.f19096h = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo27994a(Method method, Class<?> cls) {
            Object put = this.f19090b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (m21820b((Method) put, cls)) {
                    this.f19090b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return m21820b(method, cls);
        }

        /* renamed from: b */
        private boolean m21820b(Method method, Class<?> cls) {
            this.f19092d.setLength(0);
            this.f19092d.append(method.getName());
            StringBuilder sb = this.f19092d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f19092d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f19091c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f19091c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo27995b() {
            if (this.f19095g) {
                this.f19094f = null;
                return;
            }
            this.f19094f = this.f19094f.getSuperclass();
            String name = this.f19094f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f19094f = null;
            }
        }
    }
}
