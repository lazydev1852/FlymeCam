package com.meizu.sharewidget.p080a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.sharewidget.a.d */
/* compiled from: Reflect */
public class C2866d {

    /* renamed from: a */
    private static C2872e f15865a = new C2868a();

    /* renamed from: com.meizu.sharewidget.a.d$e */
    /* compiled from: Reflect */
    public interface C2872e {
        /* renamed from: a */
        C2873f mo24060a(Class<?> cls) throws ClassNotFoundException;

        /* renamed from: a */
        C2873f mo24062a(Object obj) throws ClassNotFoundException;

        /* renamed from: a */
        C2873f mo24063a(String str) throws ClassNotFoundException;
    }

    /* renamed from: com.meizu.sharewidget.a.d$f */
    /* compiled from: Reflect */
    public interface C2873f {
        /* renamed from: a */
        C2874g mo24064a(String str) throws NoSuchFieldException;

        /* renamed from: a */
        C2875h mo24065a(String str, Class... clsArr) throws NoSuchMethodException;
    }

    /* renamed from: com.meizu.sharewidget.a.d$g */
    /* compiled from: Reflect */
    public interface C2874g {
        /* renamed from: a */
        void mo24066a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException;
    }

    /* renamed from: com.meizu.sharewidget.a.d$h */
    /* compiled from: Reflect */
    public interface C2875h {
        /* renamed from: a */
        Object mo24067a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException;
    }

    /* renamed from: a */
    public static C2873f m17251a(Object obj) throws ClassNotFoundException {
        return f15865a.mo24062a(obj);
    }

    /* renamed from: a */
    public static C2873f m17250a(Class<?> cls) throws ClassNotFoundException {
        return f15865a.mo24060a(cls);
    }

    /* renamed from: a */
    public static C2873f m17252a(String str) throws ClassNotFoundException {
        return f15865a.mo24063a(str);
    }

    /* renamed from: com.meizu.sharewidget.a.d$a */
    /* compiled from: Reflect */
    private static class C2868a implements C2872e {

        /* renamed from: a */
        private Map<ClassLoader, Map<String, C2873f>> f15866a;

        private C2868a() {
            this.f15866a = new HashMap();
        }

        /* renamed from: a */
        public C2873f mo24062a(Object obj) throws ClassNotFoundException {
            return mo24060a(obj.getClass());
        }

        /* renamed from: a */
        public C2873f mo24060a(Class<?> cls) throws ClassNotFoundException {
            return mo24061a(cls.getClassLoader(), cls.getName());
        }

        /* renamed from: a */
        public C2873f mo24061a(ClassLoader classLoader, String str) throws ClassNotFoundException {
            Map map = this.f15866a.get(classLoader);
            if (map == null) {
                map = new HashMap();
                this.f15866a.put(classLoader, map);
            }
            C2873f fVar = (C2873f) map.get(str);
            if (fVar != null) {
                return fVar;
            }
            C2869b bVar = new C2869b(classLoader.loadClass(str));
            map.put(str, bVar);
            return bVar;
        }

        /* renamed from: a */
        public C2873f mo24063a(String str) throws ClassNotFoundException {
            return mo24061a(getClass().getClassLoader(), str);
        }
    }

    /* renamed from: com.meizu.sharewidget.a.d$b */
    /* compiled from: Reflect */
    private static class C2869b implements C2873f {

        /* renamed from: a */
        private Class<?> f15867a;

        /* renamed from: b */
        private Map<String, Object> f15868b = new HashMap();

        /* renamed from: c */
        private Map<String, C2875h> f15869c = new HashMap();

        /* renamed from: d */
        private Map<String, C2874g> f15870d = new HashMap();

        C2869b(Class<?> cls) {
            this.f15867a = cls;
        }

        /* renamed from: a */
        public C2875h mo24065a(String str, Class... clsArr) throws NoSuchMethodException {
            StringBuilder sb = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class name : clsArr) {
                    sb.append(name.getName());
                }
            }
            String sb2 = sb.toString();
            C2875h hVar = this.f15869c.get(sb2);
            if (hVar != null) {
                return hVar;
            }
            Method method = null;
            Class cls = this.f15867a;
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
                C2871d dVar = new C2871d(method);
                this.f15869c.put(sb2, dVar);
                return dVar;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }

        /* renamed from: a */
        public C2874g mo24064a(String str) throws NoSuchFieldException {
            C2874g gVar = this.f15870d.get(str);
            if (gVar != null) {
                return gVar;
            }
            Field field = null;
            Class cls = this.f15867a;
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
                C2870c cVar = new C2870c(field);
                this.f15870d.put(str, cVar);
                return cVar;
            }
            throw new NoSuchFieldException(str);
        }
    }

    /* renamed from: com.meizu.sharewidget.a.d$d */
    /* compiled from: Reflect */
    private static class C2871d implements C2875h {

        /* renamed from: a */
        private Method f15872a;

        C2871d(Method method) {
            this.f15872a = method;
            this.f15872a.setAccessible(true);
        }

        /* renamed from: a */
        public Object mo24067a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
            return this.f15872a.invoke(obj, objArr);
        }
    }

    /* renamed from: com.meizu.sharewidget.a.d$c */
    /* compiled from: Reflect */
    private static class C2870c implements C2874g {

        /* renamed from: a */
        private Field f15871a;

        C2870c(Field field) {
            this.f15871a = field;
            this.f15871a.setAccessible(true);
        }

        /* renamed from: a */
        public void mo24066a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            this.f15871a.set(obj, obj2);
        }
    }
}
