package com.meizu.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.common.util.e */
public class ReflectUtils {

    /* renamed from: a */
    private static C1341e f4512a = new C1337a();

    /* renamed from: com.meizu.common.util.e$e */
    /* compiled from: ReflectUtils */
    public interface C1341e {
        /* renamed from: a */
        C1342f mo16005a(Object obj) throws ClassNotFoundException;

        /* renamed from: a */
        C1342f mo16006a(String str) throws ClassNotFoundException;
    }

    /* renamed from: com.meizu.common.util.e$f */
    /* compiled from: ReflectUtils */
    public interface C1342f {
        /* renamed from: a */
        C1343g mo16007a(String str) throws NoSuchFieldException;

        /* renamed from: a */
        C1344h mo16008a(String str, Class... clsArr) throws NoSuchMethodException;
    }

    /* renamed from: com.meizu.common.util.e$g */
    /* compiled from: ReflectUtils */
    public interface C1343g {
        /* renamed from: a */
        Object mo16009a(Object obj) throws IllegalAccessException, IllegalArgumentException;

        /* renamed from: a */
        void mo16010a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException;
    }

    /* renamed from: com.meizu.common.util.e$h */
    /* compiled from: ReflectUtils */
    public interface C1344h {
        /* renamed from: a */
        Object mo16011a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException;
    }

    /* renamed from: a */
    public static C1342f m5142a(Object obj) throws ClassNotFoundException {
        return f4512a.mo16005a(obj);
    }

    /* renamed from: a */
    public static C1342f m5143a(String str) throws ClassNotFoundException {
        return f4512a.mo16006a(str);
    }

    /* renamed from: com.meizu.common.util.e$a */
    /* compiled from: ReflectUtils */
    private static class C1337a implements C1341e {

        /* renamed from: a */
        private Map<ClassLoader, Map<String, C1342f>> f4513a;

        private C1337a() {
            this.f4513a = new HashMap();
        }

        /* renamed from: a */
        public C1342f mo16005a(Object obj) throws ClassNotFoundException {
            return mo16003a(obj.getClass());
        }

        /* renamed from: a */
        public C1342f mo16003a(Class<?> cls) throws ClassNotFoundException {
            return mo16004a(cls.getClassLoader(), cls.getName());
        }

        /* renamed from: a */
        public C1342f mo16004a(ClassLoader classLoader, String str) throws ClassNotFoundException {
            Map map = this.f4513a.get(classLoader);
            if (map == null) {
                map = new HashMap();
                this.f4513a.put(classLoader, map);
            }
            C1342f fVar = (C1342f) map.get(str);
            if (fVar != null) {
                return fVar;
            }
            C1338b bVar = new C1338b(classLoader.loadClass(str));
            map.put(str, bVar);
            return bVar;
        }

        /* renamed from: a */
        public C1342f mo16006a(String str) throws ClassNotFoundException {
            return mo16004a(getClass().getClassLoader(), str);
        }
    }

    /* renamed from: com.meizu.common.util.e$b */
    /* compiled from: ReflectUtils */
    private static class C1338b implements C1342f {

        /* renamed from: a */
        private Class<?> f4514a;

        /* renamed from: b */
        private Map<String, Object> f4515b = new HashMap();

        /* renamed from: c */
        private Map<String, C1344h> f4516c = new HashMap();

        /* renamed from: d */
        private Map<String, C1343g> f4517d = new HashMap();

        C1338b(Class<?> cls) {
            this.f4514a = cls;
        }

        /* renamed from: a */
        public C1344h mo16008a(String str, Class... clsArr) throws NoSuchMethodException {
            StringBuilder sb = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class name : clsArr) {
                    sb.append(name.getName());
                }
            }
            String sb2 = sb.toString();
            C1344h hVar = this.f4516c.get(sb2);
            if (hVar != null) {
                return hVar;
            }
            Method method = null;
            Class cls = this.f4514a;
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
                C1340d dVar = new C1340d(method);
                this.f4516c.put(sb2, dVar);
                return dVar;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }

        /* renamed from: a */
        public C1343g mo16007a(String str) throws NoSuchFieldException {
            C1343g gVar = this.f4517d.get(str);
            if (gVar != null) {
                return gVar;
            }
            Field field = null;
            Class cls = this.f4514a;
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
                C1339c cVar = new C1339c(field);
                this.f4517d.put(str, cVar);
                return cVar;
            }
            throw new NoSuchFieldException(str);
        }
    }

    /* renamed from: com.meizu.common.util.e$d */
    /* compiled from: ReflectUtils */
    private static class C1340d implements C1344h {

        /* renamed from: a */
        private Method f4519a;

        C1340d(Method method) {
            this.f4519a = method;
            this.f4519a.setAccessible(true);
        }

        /* renamed from: a */
        public Object mo16011a(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
            return this.f4519a.invoke(obj, objArr);
        }
    }

    /* renamed from: com.meizu.common.util.e$c */
    /* compiled from: ReflectUtils */
    private static class C1339c implements C1343g {

        /* renamed from: a */
        private Field f4518a;

        C1339c(Field field) {
            this.f4518a = field;
            this.f4518a.setAccessible(true);
        }

        /* renamed from: a */
        public Object mo16009a(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.f4518a.get(obj);
        }

        /* renamed from: a */
        public void mo16010a(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            this.f4518a.set(obj, obj2);
        }
    }
}
