package com.meizu.statsapp.p081v3.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.meizu.statsapp.v3.utils.reflect.ReflectionCache */
public class ReflectionCache {
    private static HashMap<String, ClassInfo> classInfoMap;
    private final String TAG;

    private ReflectionCache() {
        this.TAG = "ReflectionCache";
        classInfoMap = new HashMap<>();
    }

    /* renamed from: com.meizu.statsapp.v3.utils.reflect.ReflectionCache$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ReflectionCache INSTANCE = new ReflectionCache();

        private SingletonHolder() {
        }
    }

    private void putClassInfoToCache(String str, ClassInfo classInfo) {
        classInfoMap.put(str, classInfo);
    }

    public static ReflectionCache build() {
        return SingletonHolder.INSTANCE;
    }

    public Class<?> forName(String str) throws ClassNotFoundException {
        return forName(str, true);
    }

    public Class<?> forName(String str, Boolean bool) throws ClassNotFoundException {
        if (!bool.booleanValue()) {
            return Class.forName(str);
        }
        ClassInfo classInfo = classInfoMap.get(str);
        if (classInfo != null) {
            return classInfo.mClass;
        }
        Class<?> cls = Class.forName(str);
        putClassInfoToCache(str, new ClassInfo(cls, str));
        return cls;
    }

    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        if (classInfoMap.get(cls.getName()) == null) {
            try {
                forName(cls.getName(), true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ClassInfo classInfo = classInfoMap.get(cls.getName());
        if (classInfo == null) {
            return null;
        }
        String str2 = str;
        for (Class<?> cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        Method cachedMethod = classInfo.getCachedMethod(str2);
        if (cachedMethod != null) {
            return cachedMethod;
        }
        Method method = cls.getMethod(str, clsArr);
        classInfo.addCachedMethod(str2, method);
        return method;
    }

    public Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        if (classInfoMap.get(cls.getName()) == null) {
            try {
                forName(cls.getName(), true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ClassInfo classInfo = classInfoMap.get(cls.getName());
        if (classInfo == null) {
            return null;
        }
        String str2 = str;
        for (Class<?> cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        Method cachedMethod = classInfo.getCachedMethod(str2);
        if (cachedMethod != null) {
            return cachedMethod;
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        classInfo.addCachedMethod(str2, declaredMethod);
        return declaredMethod;
    }

    public Field getField(Class<?> cls, String str) throws NoSuchFieldException {
        if (classInfoMap.get(cls.getName()) == null) {
            try {
                forName(cls.getName(), true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ClassInfo classInfo = classInfoMap.get(cls.getName());
        if (classInfo == null) {
            return null;
        }
        Field cachedField = classInfo.getCachedField(str);
        if (cachedField != null) {
            return cachedField;
        }
        Field field = cls.getField(str);
        classInfo.addCachedField(str, field);
        return field;
    }

    public Field getDeclaredField(Class<?> cls, String str) throws NoSuchFieldException {
        if (classInfoMap.get(cls.getName()) == null) {
            try {
                forName(cls.getName(), true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ClassInfo classInfo = classInfoMap.get(cls.getName());
        if (classInfo == null) {
            return null;
        }
        Field cachedField = classInfo.getCachedField(str);
        if (cachedField != null) {
            return cachedField;
        }
        Field declaredField = cls.getDeclaredField(str);
        classInfo.addCachedField(str, declaredField);
        return declaredField;
    }
}
