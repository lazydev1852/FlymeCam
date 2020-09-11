package com.meizu.camera.effectlib.utils;

import android.os.Build;
import android.util.ArrayMap;
import com.baidu.p020ar.util.MsgConstants;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.camera.effectlib.utils.a */
/* compiled from: ReflectHelper */
public class C1200a {

    /* renamed from: a */
    public static ChangeQuickRedirect f4110a;

    /* renamed from: b */
    private static Map<String, Class> f4111b;

    /* renamed from: c */
    private static Map<String, Method> f4112c;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f4111b = new ArrayMap();
            f4112c = new ArrayMap();
            return;
        }
        f4111b = new HashMap();
        f4112c = new HashMap();
    }

    /* renamed from: a */
    private static Object m4823a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Object invoke;
        Object invoke2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cls, obj, str, clsArr, objArr}, (Object) null, f4110a, true, MsgConstants.SLAM_MSG_ID_MODEL_LOADED, new Class[]{Class.class, Object.class, String.class, Class[].class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (objArr == null || objArr.length == 0) {
            synchronized (f4112c) {
                Method method = f4112c.get(str);
                if (method == null) {
                    method = cls.getMethod(str, new Class[0]);
                    method.setAccessible(true);
                    f4112c.put(str, method);
                }
                invoke = method.invoke(obj, new Object[0]);
            }
            return invoke;
        }
        synchronized (f4112c) {
            Class[] a = m4826a(objArr);
            String str2 = cls.getName() + '#' + str + m4825a((Class<?>[]) a) + "#bestmatch";
            Method method2 = f4112c.get(str2);
            if (method2 == null) {
                method2 = cls.getMethod(str, clsArr);
                method2.setAccessible(true);
                f4112c.put(str2, method2);
            }
            invoke2 = method2.invoke(obj, objArr);
        }
        return invoke2;
    }

    /* renamed from: a */
    public static Object m4824a(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, clsArr, objArr}, (Object) null, f4110a, true, 502, new Class[]{String.class, String.class, Class[].class, Object[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        Class<?> cls = f4111b.get(str);
        if (cls == null) {
            cls = Class.forName(str);
            f4111b.put(str, cls);
        }
        return m4823a(cls, cls, str2, clsArr, objArr);
    }

    /* renamed from: a */
    private static Class<?>[] m4826a(Object[] objArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, (Object) null, f4110a, true, 503, new Class[]{Object[].class}, Class[].class);
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
    private static String m4825a(Class<?>... clsArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{clsArr}, (Object) null, f4110a, true, 504, new Class[]{Class[].class}, String.class);
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
}
