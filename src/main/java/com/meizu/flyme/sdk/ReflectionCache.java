package com.meizu.flyme.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.meizu.flyme.sdk.c */
public class ReflectionCache {

    /* renamed from: a */
    public static HashMap<String, ClassInfo> f6454a;

    /* renamed from: b */
    public static HashMap<String, Method> f6455b;

    /* renamed from: c */
    public static HashMap<String, Field> f6456c;

    /* renamed from: d */
    private final String f6457d;

    /* renamed from: com.meizu.flyme.sdk.c$a */
    /* compiled from: ReflectionCache */
    private static class C1567a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final ReflectionCache f6458a = new ReflectionCache();
    }

    private ReflectionCache() {
        this.f6457d = "ReflectionCache";
        f6454a = new HashMap<>();
        f6455b = new HashMap<>();
        f6456c = new HashMap<>();
    }

    /* renamed from: a */
    public static ReflectionCache m6352a() {
        return C1567a.f6458a;
    }

    /* renamed from: a */
    private void m6353a(String str, ClassInfo aVar) {
        f6454a.put(str, aVar);
    }

    /* renamed from: b */
    private ClassInfo m6354b(String str) {
        return f6454a.get(str);
    }

    /* renamed from: a */
    public Class<?> mo17607a(String str) throws ClassNotFoundException {
        return mo17608a(str, (Boolean) true);
    }

    /* renamed from: a */
    public synchronized Class<?> mo17608a(String str, Boolean bool) throws ClassNotFoundException {
        if (bool.booleanValue()) {
            ClassInfo b = m6354b(str);
            if (b != null) {
                return b.f6451a;
            }
            Class<?> cls = Class.forName(str);
            m6353a(str, new ClassInfo(cls, str));
            return cls;
        }
        return Class.forName(str);
    }

    /* renamed from: a */
    public synchronized Method mo17609a(Class<?> cls, String str, Class... clsArr) throws NoSuchMethodException {
        ClassInfo b = m6354b(cls.getName());
        Boolean valueOf = Boolean.valueOf(b != null);
        String str2 = str;
        for (Class cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        if (valueOf.booleanValue()) {
            Method a = b.mo17605a(str2);
            if (a != null) {
                return a;
            }
            Method method = cls.getMethod(str, clsArr);
            b.mo17606a(str2, method);
            return method;
        }
        Method method2 = f6455b.get(str2);
        if (method2 != null) {
            return method2;
        }
        Method method3 = cls.getMethod(str, clsArr);
        f6455b.put(str2, method3);
        return method3;
    }
}
