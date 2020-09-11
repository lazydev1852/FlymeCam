package com.meizu.flyme.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.meizu.flyme.sdk.a */
public class ClassInfo {

    /* renamed from: a */
    final Class<?> f6451a;

    /* renamed from: b */
    final HashMap<String, Method> f6452b = new HashMap<>();

    /* renamed from: c */
    final HashMap<String, Field> f6453c = new HashMap<>();

    public ClassInfo(Class<?> cls, String str) {
        this.f6451a = cls;
    }

    /* renamed from: a */
    public void mo17606a(String str, Method method) {
        this.f6452b.put(str, method);
    }

    /* renamed from: a */
    public Method mo17605a(String str) {
        return this.f6452b.get(str);
    }
}
