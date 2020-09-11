package com.meizu.statsapp.p081v3.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.meizu.statsapp.v3.utils.reflect.ClassInfo */
public class ClassInfo {
    public final HashMap<String, Field> fields = new HashMap<>();
    public final Class<?> mClass;
    public final HashMap<String, Method> methods = new HashMap<>();

    public ClassInfo(Class<?> cls, String str) {
        this.mClass = cls;
    }

    public void addCachedMethod(String str, Method method) {
        this.methods.put(str, method);
    }

    public Method getCachedMethod(String str) {
        return this.methods.get(str);
    }

    public void addCachedField(String str, Field field) {
        this.fields.put(str, field);
    }

    public Field getCachedField(String str) {
        return this.fields.get(str);
    }
}
