package com.meizu.share.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.share.utils.c */
/* compiled from: Reflect */
public class C2834c {

    /* renamed from: a */
    private static C2840e f15784a = new C2836a();

    /* renamed from: com.meizu.share.utils.c$e */
    /* compiled from: Reflect */
    public interface C2840e {
        /* renamed from: a */
        C2841f mo24020a(Class<?> cls) throws ClassNotFoundException;

        /* renamed from: a */
        C2841f mo24022a(Object obj) throws ClassNotFoundException;
    }

    /* renamed from: com.meizu.share.utils.c$f */
    /* compiled from: Reflect */
    public interface C2841f {
        /* renamed from: a */
        C2842g mo24023a(String str) throws NoSuchFieldException;

        /* renamed from: a */
        C2843h mo24024a(String str, Class... clsArr) throws NoSuchMethodException;
    }

    /* renamed from: com.meizu.share.utils.c$g */
    /* compiled from: Reflect */
    public interface C2842g {
        /* renamed from: a */
        void mo24025a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException;
    }

    /* renamed from: com.meizu.share.utils.c$h */
    /* compiled from: Reflect */
    public interface C2843h {
        /* renamed from: a */
        Object mo24026a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException;
    }

    /* renamed from: a */
    public static C2841f m17188a(Object obj) throws ClassNotFoundException {
        return f15784a.mo24022a(obj);
    }

    /* renamed from: a */
    public static C2841f m17187a(Class<?> cls) throws ClassNotFoundException {
        return f15784a.mo24020a(cls);
    }

    /* renamed from: com.meizu.share.utils.c$a */
    /* compiled from: Reflect */
    private static class C2836a implements C2840e {

        /* renamed from: a */
        private Map<ClassLoader, Map<String, C2841f>> f15785a;

        private C2836a() {
            this.f15785a = new HashMap();
        }

        /* renamed from: a */
        public C2841f mo24022a(Object obj) throws ClassNotFoundException {
            return mo24020a(obj.getClass());
        }

        /* renamed from: a */
        public C2841f mo24020a(Class<?> cls) throws ClassNotFoundException {
            return mo24021a(cls.getClassLoader(), cls.getName());
        }

        /* renamed from: a */
        public C2841f mo24021a(ClassLoader classLoader, String str) throws ClassNotFoundException {
            Map map = this.f15785a.get(classLoader);
            if (map == null) {
                map = new HashMap();
                this.f15785a.put(classLoader, map);
            }
            C2841f fVar = (C2841f) map.get(str);
            if (fVar != null) {
                return fVar;
            }
            C2837b bVar = new C2837b(classLoader.loadClass(str));
            map.put(str, bVar);
            return bVar;
        }
    }

    /* renamed from: com.meizu.share.utils.c$b */
    /* compiled from: Reflect */
    private static class C2837b implements C2841f {

        /* renamed from: a */
        private Class<?> f15786a;

        /* renamed from: b */
        private Map<String, Object> f15787b = new HashMap();

        /* renamed from: c */
        private Map<String, C2843h> f15788c = new HashMap();

        /* renamed from: d */
        private Map<String, C2842g> f15789d = new HashMap();

        C2837b(Class<?> cls) {
            this.f15786a = cls;
        }

        /* renamed from: a */
        public C2843h mo24024a(String str, Class... clsArr) throws NoSuchMethodException {
            StringBuilder sb = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class name : clsArr) {
                    sb.append(name.getName());
                }
            }
            String sb2 = sb.toString();
            C2843h hVar = this.f15788c.get(sb2);
            if (hVar != null) {
                return hVar;
            }
            Method method = null;
            Class cls = this.f15786a;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (Exception unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (method != null) {
                C2839d dVar = new C2839d(method);
                this.f15788c.put(sb2, dVar);
                return dVar;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }

        /* renamed from: a */
        public C2842g mo24023a(String str) throws NoSuchFieldException {
            C2842g gVar = this.f15789d.get(str);
            if (gVar != null) {
                return gVar;
            }
            Field field = null;
            Class cls = this.f15786a;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    field = cls.getDeclaredField(str);
                    break;
                } catch (Exception unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (field != null) {
                C2838c cVar = new C2838c(field);
                this.f15789d.put(str, cVar);
                return cVar;
            }
            throw new NoSuchFieldException(str);
        }
    }

    /* renamed from: com.meizu.share.utils.c$d */
    /* compiled from: Reflect */
    private static class C2839d implements C2843h {

        /* renamed from: a */
        private Method f15791a;

        C2839d(Method method) {
            this.f15791a = method;
            this.f15791a.setAccessible(true);
        }

        /* renamed from: a */
        public Object mo24026a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
            return this.f15791a.invoke(obj, objArr);
        }
    }

    /* renamed from: com.meizu.share.utils.c$c */
    /* compiled from: Reflect */
    private static class C2838c implements C2842g {

        /* renamed from: a */
        private Field f15790a;

        C2838c(Field field) {
            this.f15790a = field;
            this.f15790a.setAccessible(true);
        }

        /* renamed from: a */
        public void mo24025a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            this.f15790a.set(obj, obj2);
        }
    }
}
