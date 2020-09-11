package com.meizu.savior.utils;

import android.os.Build;
import android.util.ArrayMap;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectHelper {
    private static Map<String, Class> mClassMap;
    private static Map<String, Method> mMethodMap;

    static {
        Map<String, Method> hashMap;
        if (Build.VERSION.SDK_INT >= 19) {
            mClassMap = new ArrayMap();
            hashMap = new ArrayMap<>();
        } else {
            mClassMap = new HashMap();
            hashMap = new HashMap<>();
        }
        mMethodMap = hashMap;
    }

    public static Object getField(Object obj, Class<?> cls, String str) {
        if (obj == null || cls == null || str == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            throw new NoSuchFieldException(str);
        }
    }

    public static Object getField(Object obj, String str) {
        if (obj != null && str != null) {
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
    private static java.lang.Object getFieldStepwise(java.lang.Object r1, java.lang.Class<?> r2, java.lang.String r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.savior.utils.ReflectHelper.getFieldStepwise(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    private static Class<?>[] getParamsTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    private static String getParamsTypesString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        int length = clsArr.length;
        boolean z = true;
        for (int i = 0; i < length; i++) {
            Class<?> cls = clsArr[i];
            if (z) {
                z = false;
            } else {
                sb.append(SystemInfoUtil.COMMA);
            }
            sb.append(cls != null ? cls.getCanonicalName() : "null");
        }
        sb.append(")");
        return sb.toString();
    }

    public static Object getStaticField(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("parameter can not be null!");
        }
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                mClassMap.put(str, cls);
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("className not found");
            }
        }
        return getFieldStepwise(cls, cls, str2);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        Method method2;
        if (objArr == null || objArr.length == 0) {
            synchronized (mMethodMap) {
                method = mMethodMap.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    mMethodMap.put(str, method);
                }
            }
            return method.invoke(obj, new Object[0]);
        }
        synchronized (mMethodMap) {
            Class<?>[] paramsTypes = clsArr != null ? clsArr : getParamsTypes(objArr);
            String str2 = cls.getName() + '#' + str + getParamsTypesString(paramsTypes) + "#bestmatch";
            method2 = mMethodMap.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, clsArr);
                method2.setAccessible(true);
                mMethodMap.put(str2, method2);
            }
        }
        return method2.invoke(obj, objArr);
    }

    private static Object invoke(Class<?> cls, Object obj, String str, Object[] objArr) {
        Method method;
        Method method2;
        if (objArr == null || objArr.length == 0) {
            synchronized (mMethodMap) {
                method = mMethodMap.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    mMethodMap.put(str, method);
                }
            }
            return method.invoke(obj, new Object[0]);
        }
        synchronized (mMethodMap) {
            Class[] paramsTypes = getParamsTypes(objArr);
            String str2 = cls.getName() + '#' + str + getParamsTypesString(paramsTypes) + "#bestmatch";
            method2 = mMethodMap.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, paramsTypes);
                method2.setAccessible(true);
                mMethodMap.put(str2, method2);
            }
        }
        return method2.invoke(obj, objArr);
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        return invoke(obj.getClass(), obj, str, clsArr, objArr);
    }

    public static Object invoke(Object obj, String str, Object[] objArr) {
        return invoke(obj.getClass(), obj, str, objArr);
    }

    public static Object invokeStatic(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            mClassMap.put(str, cls);
        }
        return invoke(cls, cls, str2, clsArr, objArr);
    }

    public static Object invokeStatic(String str, String str2, Object[] objArr) {
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            mClassMap.put(str, cls);
        }
        return invoke(cls, (Object) cls, str2, objArr);
    }

    public static Object reflectConstructor(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? cls.getConstructor(new Class[0]).newInstance(new Object[0]) : cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static Object reflectConstructor(Class<?> cls, Object[] objArr) {
        Constructor<?> constructor;
        if (objArr == null || objArr.length <= 0) {
            constructor = cls.getConstructor(new Class[0]);
            objArr = new Object[0];
        } else {
            constructor = cls.getConstructor(getParamsTypes(objArr));
        }
        return constructor.newInstance(objArr);
    }

    public static boolean setField(Object obj, Class<?> cls, String str, Object obj2) {
        if (obj == null || cls == null || str == null) {
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

    public static boolean setField(Object obj, String str, Object obj2) {
        if (obj != null && str != null) {
            return setFieldStepwise(obj, obj.getClass(), str, obj2);
        }
        throw new IllegalArgumentException("parameter can not be null!");
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
        Class<?> cls = mClassMap.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                mClassMap.put(str, cls);
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("className not found");
            }
        }
        return setFieldStepwise(cls, cls, str2, obj);
    }
}
