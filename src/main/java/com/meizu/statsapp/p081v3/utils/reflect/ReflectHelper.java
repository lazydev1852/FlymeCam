package com.meizu.statsapp.p081v3.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.meizu.statsapp.v3.utils.reflect.ReflectHelper */
public class ReflectHelper {
    public static Object reflectConstructor(String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        if (objArr == null || objArr.length <= 0) {
            return ReflectionCache.build().forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        return ReflectionCache.build().forName(str).getConstructor(clsArr).newInstance(objArr);
    }

    public static Object invokeStatic(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return invoke(ReflectionCache.build().forName(str), (Object) null, str2, clsArr, objArr);
    }

    public static Object invokeStatic(String str, String str2, Object[] objArr) throws Exception {
        return invoke(ReflectionCache.build().forName(str), (Object) null, str2, objArr);
    }

    private static Class<?>[] getParamsTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    public static Object invoke(Object obj, String str, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, objArr);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        if (objArr == null || objArr.length == 0) {
            Method declaredMethod = ReflectionCache.build().getDeclaredMethod(cls, str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        }
        Method declaredMethod2 = ReflectionCache.build().getDeclaredMethod(cls, str, getParamsTypes(objArr));
        declaredMethod2.setAccessible(true);
        return declaredMethod2.invoke(obj, objArr);
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return invoke(obj.getClass(), obj, str, clsArr, objArr);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        if (objArr == null || objArr.length == 0) {
            Method declaredMethod = ReflectionCache.build().getDeclaredMethod(cls, str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        }
        Method declaredMethod2 = ReflectionCache.build().getDeclaredMethod(cls, str, clsArr);
        declaredMethod2.setAccessible(true);
        return declaredMethod2.invoke(obj, objArr);
    }

    public static boolean setField(Object obj, Class<?> cls, String str, Object obj2) {
        if (cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean setFieldStepwise(Object obj, Class<?> cls, String str, Object obj2) {
        Class<?> cls2;
        Class<? super Object> cls3;
        while (cls2 != null) {
            if (setField(obj, cls2, str, obj2)) {
                return true;
            }
            try {
                cls3 = cls2.getSuperclass();
            } catch (Exception unused) {
                cls3 = null;
            }
            cls2 = cls;
            cls2 = cls3;
        }
        return false;
    }

    public static boolean setStaticField(String str, String str2, Object obj) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            return setFieldStepwise((Object) null, ReflectionCache.build().forName(str), str2, obj);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("className not found");
        }
    }

    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException {
        if (cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = ReflectionCache.build().getDeclaredField(cls, str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            throw new NoSuchFieldException(str);
        }
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException {
        if (str != null) {
            return getFieldStepwise(obj, obj.getClass(), str);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|12|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0000, code lost:
        r2 = r2;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0000, code lost:
        r2 = r2.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object getFieldStepwise(java.lang.Object r1, java.lang.Class<?> r2, java.lang.String r3) throws java.lang.NoSuchFieldException {
        /*
        L_0x0000:
            if (r2 == 0) goto L_0x000e
            java.lang.Object r0 = getField(r1, r2, r3)     // Catch:{ NoSuchFieldException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.Class r2 = r2.getSuperclass()     // Catch:{ Exception -> 0x000c }
            goto L_0x0000
        L_0x000c:
            r2 = 0
            goto L_0x0000
        L_0x000e:
            java.lang.NoSuchFieldException r1 = new java.lang.NoSuchFieldException
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.utils.reflect.ReflectHelper.getFieldStepwise(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static Object getStaticField(String str, String str2) throws NoSuchFieldException {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            return getFieldStepwise((Object) null, ReflectionCache.build().forName(str), str2);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("className not found");
        }
    }
}
