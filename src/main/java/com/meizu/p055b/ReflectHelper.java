package com.meizu.p055b;

import android.os.Build;
import android.util.ArrayMap;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.b.a */
public class ReflectHelper {

    /* renamed from: a */
    private static Map<String, Class> f3453a;

    /* renamed from: b */
    private static Map<String, Method> f3454b;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f3453a = new ArrayMap();
            f3454b = new ArrayMap();
            return;
        }
        f3453a = new HashMap();
        f3454b = new HashMap();
    }

    /* renamed from: a */
    private static Object m4007a(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        Object invoke;
        Object invoke2;
        if (objArr == null || objArr.length == 0) {
            synchronized (f3454b) {
                Method method = f3454b.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    f3454b.put(str, method);
                }
                invoke = method.invoke(obj, new Object[0]);
            }
            return invoke;
        }
        synchronized (f3454b) {
            Class[] a = m4014a(objArr);
            String str2 = cls.getName() + '#' + str + m4013a((Class<?>[]) a) + "#bestmatch";
            Method method2 = f3454b.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, a);
                method2.setAccessible(true);
                f3454b.put(str2, method2);
            }
            invoke2 = method2.invoke(obj, objArr);
        }
        return invoke2;
    }

    /* renamed from: a */
    public static Object m4012a(String str, String str2, Object[] objArr) throws Exception {
        Object a;
        synchronized (f3453a) {
            Class<?> cls = f3453a.get(str);
            if (cls == null) {
                cls = Class.forName(str);
                f3453a.put(str, cls);
            }
            a = m4007a(cls, (Object) cls, str2, objArr);
        }
        return a;
    }

    /* renamed from: a */
    public static Object m4009a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return m4006a(obj.getClass(), obj, str, clsArr, objArr);
    }

    /* renamed from: a */
    private static Object m4006a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Object invoke;
        Object invoke2;
        if (objArr == null || objArr.length == 0) {
            synchronized (f3454b) {
                Method method = f3454b.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    f3454b.put(str, method);
                }
                invoke = method.invoke(obj, new Object[0]);
            }
            return invoke;
        }
        synchronized (f3454b) {
            String str2 = cls.getName() + '#' + str + m4013a(clsArr) + "#bestmatch";
            Method method2 = f3454b.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, clsArr);
                method2.setAccessible(true);
                f3454b.put(str2, method2);
            }
            invoke2 = method2.invoke(obj, objArr);
        }
        return invoke2;
    }

    /* renamed from: a */
    public static Object m4011a(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Object a;
        synchronized (f3453a) {
            Class<?> cls = f3453a.get(str);
            if (cls == null) {
                cls = Class.forName(str);
                f3453a.put(str, cls);
            }
            a = m4006a(cls, cls, str2, clsArr, objArr);
        }
        return a;
    }

    /* renamed from: a */
    private static Class<?>[] m4014a(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    /* renamed from: a */
    private static String m4013a(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = true;
        for (Class<?> cls : clsArr) {
            if (z) {
                z = false;
            } else {
                sb.append(SystemInfoUtil.COMMA);
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public static Object m4008a(Object obj, Class<?> cls, String str) throws NoSuchFieldException {
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
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m4015b(java.lang.Object r1, java.lang.Class<?> r2, java.lang.String r3) throws java.lang.NoSuchFieldException {
        /*
        L_0x0000:
            if (r2 == 0) goto L_0x000e
            java.lang.Object r0 = m4008a((java.lang.Object) r1, (java.lang.Class<?>) r2, (java.lang.String) r3)     // Catch:{ NoSuchFieldException -> 0x0007 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.p055b.ReflectHelper.m4015b(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object m4010a(java.lang.String r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /*
            if (r3 == 0) goto L_0x002c
            if (r4 == 0) goto L_0x002c
            java.util.Map<java.lang.String, java.lang.Class> r0 = f3453a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Class> r1 = f3453a     // Catch:{ all -> 0x0029 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0029 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0023
            java.lang.Class r1 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x001b }
            java.util.Map<java.lang.String, java.lang.Class> r2 = f3453a     // Catch:{ ClassNotFoundException -> 0x001b }
            r2.put(r3, r1)     // Catch:{ ClassNotFoundException -> 0x001b }
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "className not found"
            r3.<init>(r4)     // Catch:{ all -> 0x0029 }
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x0023:
            java.lang.Object r3 = m4015b(r1, r1, r4)     // Catch:{ all -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return r3
        L_0x0029:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r3
        L_0x002c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "parameter can not be null!"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.p055b.ReflectHelper.m4010a(java.lang.String, java.lang.String):java.lang.Object");
    }
}
