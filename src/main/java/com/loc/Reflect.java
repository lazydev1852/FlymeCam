package com.loc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.loc.cj */
public final class Reflect {
    /* renamed from: a */
    private static Object m3409a(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static Object m3410a(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<Double>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
            if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
            if (clsArr[i] == Double.class) {
                clsArr[i] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static Object m3411a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return m3409a(obj, obj.getClass(), str, clsArr, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Object m3412a(Object obj, String str, Object... objArr) {
        try {
            return m3410a(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m3413a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    /* renamed from: a */
    public static Object m3414a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke((Object) null, objArr);
    }

    /* renamed from: a */
    public static Object m3415a(String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
    }

    /* renamed from: b */
    public static int m3416b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) m3412a(obj, str, objArr)).intValue();
    }

    /* renamed from: b */
    public static int m3417b(String str, String str2) throws Exception {
        return ((Integer) m3413a(str, str2)).intValue();
    }
}
