package com.meizu.media.camera.util;

import android.os.Build;
import android.util.ArrayMap;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.media.camera.util.am */
/* compiled from: ReflectHelper */
public class C2634am {

    /* renamed from: a */
    public static ChangeQuickRedirect f14112a;

    /* renamed from: b */
    private static Map<String, Class> f14113b;

    /* renamed from: c */
    private static Map<String, Method> f14114c;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f14113b = new ArrayMap();
            f14114c = new ArrayMap();
            return;
        }
        f14113b = new HashMap();
        f14114c = new HashMap();
    }

    /* renamed from: a */
    public static Object m15990a(Class<?> cls, Object[] objArr) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls, objArr}, (Object) null, f14112a, true, 8178, new Class[]{Class.class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (objArr == null || objArr.length <= 0) {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        return cls.getConstructor(m16000a(objArr)).newInstance(objArr);
    }

    /* renamed from: a */
    public static Object m15989a(Class<?> cls, Class<?>[] clsArr, Object[] objArr) throws Exception {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls, clsArr, objArr}, (Object) null, changeQuickRedirect, true, 8179, new Class[]{Class.class, Class[].class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (objArr == null || objArr.length <= 0) {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    /* renamed from: a */
    public static Object m15994a(Object obj, String str, Object[] objArr) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, str, objArr}, (Object) null, f14112a, true, 8180, new Class[]{Object.class, String.class, Object[].class}, Object.class);
        return proxy.isSupported ? proxy.result : m15988a(obj.getClass(), obj, str, objArr);
    }

    /* renamed from: a */
    private static Object m15988a(Class<?> cls, Object obj, String str, Object[] objArr) throws Exception {
        Method method;
        Method method2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls, obj, str, objArr}, (Object) null, f14112a, true, 8181, new Class[]{Class.class, Object.class, String.class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (objArr == null || objArr.length == 0) {
            synchronized (f14114c) {
                method = f14114c.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    f14114c.put(str, method);
                }
            }
            return method.invoke(obj, new Object[0]);
        }
        synchronized (f14114c) {
            Class[] a = m16000a(objArr);
            String str2 = cls.getName() + '#' + str + m15997a((Class<?>[]) a) + "#bestmatch";
            method2 = f14114c.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, a);
                method2.setAccessible(true);
                f14114c.put(str2, method2);
            }
        }
        return method2.invoke(obj, objArr);
    }

    /* renamed from: a */
    public static Object m15996a(String str, String str2, Object[] objArr) throws Exception {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, objArr}, (Object) null, changeQuickRedirect, true, 8182, new Class[]{String.class, String.class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        Class<?> cls = f14113b.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            f14113b.put(str, cls);
        }
        return m15988a(cls, (Object) cls, str2, objArr);
    }

    /* renamed from: a */
    public static Object m15993a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, str, clsArr, objArr}, (Object) null, f14112a, true, 8183, new Class[]{Object.class, String.class, Class[].class, Object[].class}, Object.class);
        return proxy.isSupported ? proxy.result : m15987a(obj.getClass(), obj, str, clsArr, objArr);
    }

    /* renamed from: a */
    private static Object m15987a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Method method;
        Class<?>[] clsArr2;
        Method method2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls, obj, str, clsArr, objArr}, (Object) null, f14112a, true, 8184, new Class[]{Class.class, Object.class, String.class, Class[].class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (objArr == null || objArr.length == 0) {
            synchronized (f14114c) {
                method = f14114c.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    f14114c.put(str, method);
                }
            }
            return method.invoke(obj, new Object[0]);
        }
        synchronized (f14114c) {
            if (clsArr != null) {
                clsArr2 = clsArr;
            } else {
                clsArr2 = m16000a(objArr);
            }
            String str2 = cls.getName() + '#' + str + m15997a(clsArr2) + "#bestmatch";
            method2 = f14114c.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, clsArr);
                method2.setAccessible(true);
                f14114c.put(str2, method2);
            }
        }
        return method2.invoke(obj, objArr);
    }

    /* renamed from: a */
    public static Object m15995a(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, clsArr, objArr}, (Object) null, f14112a, true, 8185, new Class[]{String.class, String.class, Class[].class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        Class<?> cls = f14113b.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            f14113b.put(str, cls);
        }
        return m15987a(cls, cls, str2, clsArr, objArr);
    }

    /* renamed from: a */
    private static Class<?>[] m16000a(Object[] objArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, (Object) null, f14112a, true, 8186, new Class[]{Object[].class}, Class[].class);
        if (proxy.isSupported) {
            return (Class[]) proxy.result;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    /* renamed from: a */
    private static String m15997a(Class<?>... clsArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{clsArr}, (Object) null, f14112a, true, 8187, new Class[]{Class[].class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
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
    public static boolean m15998a(Object obj, Class<?> cls, String str, Object obj2) {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, cls, str, obj2}, (Object) null, changeQuickRedirect, true, 8188, new Class[]{Object.class, Class.class, String.class, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
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

    /* renamed from: a */
    public static boolean m15999a(Object obj, String str, Object obj2) {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, str, obj2}, (Object) null, changeQuickRedirect, true, 8189, new Class[]{Object.class, String.class, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (obj != null && str != null) {
            return m16002b(obj, obj.getClass(), str, obj2);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    /* renamed from: b */
    private static boolean m16002b(Object obj, Class<?> cls, String str, Object obj2) {
        Class<? super Object> cls2;
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, cls, str, obj2}, (Object) null, changeQuickRedirect, true, 8190, new Class[]{Object.class, Class.class, String.class, Object.class}, Boolean.TYPE);
        Class<?> cls3 = cls;
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        while (cls3 != null) {
            if (m15998a(obj, cls3, str, obj2)) {
                return true;
            }
            try {
                cls2 = cls3.getSuperclass();
            } catch (Exception unused) {
                cls2 = null;
            }
            cls3 = cls2;
        }
        return false;
    }

    /* renamed from: a */
    public static Object m15991a(Object obj, Class<?> cls, String str) throws NoSuchFieldException {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, cls, str}, (Object) null, changeQuickRedirect, true, 8192, new Class[]{Object.class, Class.class, String.class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
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

    /* renamed from: a */
    public static Object m15992a(Object obj, String str) throws NoSuchFieldException {
        ChangeQuickRedirect changeQuickRedirect = f14112a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, str}, (Object) null, changeQuickRedirect, true, 8193, new Class[]{Object.class, String.class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (obj != null && str != null) {
            return m16001b(obj, obj.getClass(), str);
        }
        throw new IllegalArgumentException("parameter can not be null!");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|16|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r9 = r9.getSuperclass();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0038 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m16001b(java.lang.Object r8, java.lang.Class<?> r9, java.lang.String r10) throws java.lang.NoSuchFieldException {
        /*
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            r3 = 1
            r1[r3] = r9
            r4 = 2
            r1[r4] = r10
            com.meizu.savior.ChangeQuickRedirect r5 = f14112a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r6[r2] = r0
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            r6[r3] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r4] = r0
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r2 = 0
            r4 = 1
            r0 = 8194(0x2002, float:1.1482E-41)
            r3 = r5
            r5 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0031
            java.lang.Object r8 = r0.result
            java.lang.Object r8 = (java.lang.Object) r8
            return r8
        L_0x0031:
            if (r9 == 0) goto L_0x003f
            java.lang.Object r0 = m15991a((java.lang.Object) r8, (java.lang.Class<?>) r9, (java.lang.String) r10)     // Catch:{ NoSuchFieldException -> 0x0038 }
            return r0
        L_0x0038:
            java.lang.Class r9 = r9.getSuperclass()     // Catch:{ Exception -> 0x003d }
            goto L_0x0031
        L_0x003d:
            r9 = 0
            goto L_0x0031
        L_0x003f:
            java.lang.NoSuchFieldException r8 = new java.lang.NoSuchFieldException
            r8.<init>(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.C2634am.m16001b(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }
}
