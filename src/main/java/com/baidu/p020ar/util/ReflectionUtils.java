package com.baidu.p020ar.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.baidu.ar.util.ReflectionUtils */
public class ReflectionUtils {
    /* renamed from: a */
    private static Field m2726a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Method m2727a(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object getElFieldValue(Object obj, String str) {
        for (String fieldValue : str.split("[.]")) {
            obj = getFieldValue(obj, fieldValue);
            if (obj == null) {
                return null;
            }
        }
        return obj;
    }

    public static Object getFieldValue(Object obj, String str) {
        Field a = m2726a(obj, str);
        if (a == null) {
            return null;
        }
        a.setAccessible(true);
        try {
            return a.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getFieldValue(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getStaticFieldValue(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str) {
        return invokeMethod(obj, str, (Class<?>[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method a = m2727a(obj, str, clsArr);
        if (a == null) {
            return null;
        }
        a.setAccessible(true);
        try {
            return a.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke((Object) null, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object newInstance(Class<?> cls, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    int length = objArr.length;
                    Class[] clsArr = new Class[length];
                    for (int i = 0; i < length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return cls.newInstance();
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstance(Class.forName(str), objArr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setElFieldValue(Object obj, String str, Object obj2) {
        String[] split = str.split("[.]");
        int length = split.length - 1;
        int i = 0;
        while (i < length) {
            obj = getFieldValue(obj, split[i]);
            if (obj != null) {
                i++;
            } else {
                return;
            }
        }
        setFieldValue(obj, split[length], obj2);
    }

    public static void setFieldValue(Object obj, String str, Object obj2) {
        Field a = m2726a(obj, str);
        if (a != null) {
            a.setAccessible(true);
            try {
                a.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFieldValue(String str, String str2, Object obj, Object obj2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setStaticFieldValue(String str, String str2, Object obj) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set((Object) null, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
