package com.meizu.savior.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EnhancedSaviorUtils {
    public static boolean isThrowable = true;

    public static Method getDeclaredMethod(Object obj, String str, Class[] clsArr, Class cls, Class cls2) {
        if (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            for (Class cls3 = obj.getClass(); cls3 != null; cls3 = cls3.getSuperclass()) {
                try {
                    Method declaredMethod = cls3.getDeclaredMethod(str, clsArr);
                    if (declaredMethod == null) {
                        continue;
                    } else {
                        if (!declaredMethod.isAccessible()) {
                            declaredMethod.setAccessible(true);
                        }
                        if (declaredMethod.getReturnType() == cls2) {
                            return declaredMethod;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("getDeclaredMethod error " + str + "   parameterTypes   " + clsArr + " targetObject " + obj.toString());
        }
    }

    public static Object getFieldValue(String str, Object obj, Class cls) {
        try {
            return getReflectField(str, obj, cls).get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("getFieldValue  error " + str + "   instance   " + obj);
        }
    }

    private static Field getReflectField(String str, Object obj, Class cls) {
        if (cls == null) {
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("Field " + str + " declaring class is null ");
        } else if (cls.isInterface()) {
            return cls.getDeclaredField(str);
        } else {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
            }
        }
    }

    private static Field getReflectStaticField(String str, Class cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Field " + str + " not found in " + cls);
        }
    }

    public static Object getStaticFieldValue(String str, Class cls) {
        try {
            return getReflectStaticField(str, cls).get((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("getStaticFieldValue  error " + str + "   clazz   " + cls);
        }
    }

    public static Object invokeReflectConstruct(String str, Object[] objArr, Class[] clsArr) {
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace();
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("invokeReflectConstruct error " + str + "   parameter   " + objArr);
        }
    }

    public static Object invokeReflectMethod(String str, Object obj, Object[] objArr, Class[] clsArr, Class cls, Class cls2) {
        try {
            Method declaredMethod = getDeclaredMethod(obj, str, clsArr, cls, cls2);
            if (declaredMethod != null) {
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod.invoke(obj, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isThrowable) {
            return null;
        }
        throw new RuntimeException("invokeReflectMethod error " + str + "   parameter   " + objArr + " targetObject " + obj.toString() + "  args  " + clsArr);
    }

    public static Object invokeReflectStaticMethod(String str, Class cls, Object[] objArr, Class[] clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            if (!isThrowable) {
                return null;
            }
            throw new RuntimeException("invokeReflectStaticMethod error " + str + "   class   " + cls + "  args  " + clsArr);
        }
    }

    public static void setFieldValue(String str, Object obj, byte b, Class cls) {
        try {
            getReflectField(str, obj, cls).setByte(obj, b);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue byte error " + str + "   target   " + obj + "  value  " + b);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, char c, Class cls) {
        try {
            getReflectField(str, obj, cls).setChar(obj, c);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue char error " + str + "   target   " + obj + "  value  " + c);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, double d, Class cls) {
        try {
            getReflectField(str, obj, cls).setDouble(obj, d);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue double error " + str + "   target   " + obj + "  value  " + d);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, float f, Class cls) {
        try {
            getReflectField(str, obj, cls).setFloat(obj, f);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue float error " + str + "   target   " + obj + "  value  " + f);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, int i, Class cls) {
        try {
            getReflectField(str, obj, cls).setInt(obj, i);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue int error " + str + "   target   " + obj + "  value  " + i);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, long j, Class cls) {
        try {
            getReflectField(str, obj, cls).setLong(obj, j);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue long error " + str + "   target   " + obj + "  value  " + j);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, Object obj2, Class cls) {
        try {
            getReflectField(str, obj, cls).set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue Object error " + str + "   target   " + obj + "  value  " + obj2);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, short s, Class cls) {
        try {
            getReflectField(str, obj, cls).setShort(obj, s);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue short error " + str + "   target   " + obj + "  value  " + s);
            }
        }
    }

    public static void setFieldValue(String str, Object obj, boolean z, Class cls) {
        try {
            getReflectField(str, obj, cls).setBoolean(obj, z);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setFieldValue boolean error " + str + "   target   " + obj + "  value  " + z);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, double d) {
        try {
            getReflectStaticField(str, cls).setDouble((Object) null, d);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue Object error " + str + "   Class   " + cls + "  value  " + d);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, float f) {
        try {
            getReflectStaticField(str, cls).setFloat((Object) null, f);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue float error " + str + "   Class   " + cls + "  value  " + f);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, int i) {
        try {
            getReflectStaticField(str, cls).setInt((Object) null, i);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue int error " + str + "   Class   " + cls + "  value  " + i);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, long j) {
        try {
            getReflectStaticField(str, cls).setLong((Object) null, j);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue long error " + str + "   Class   " + cls + "  value  " + j);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, Object obj) {
        try {
            getReflectStaticField(str, cls).set((Object) null, obj);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue Object error " + str + "   Class   " + cls + "  value  " + obj);
            }
        }
    }

    public static void setStaticFieldValue(String str, Class cls, boolean z) {
        try {
            getReflectStaticField(str, cls).setBoolean((Object) null, z);
        } catch (Exception e) {
            e.printStackTrace();
            if (isThrowable) {
                throw new RuntimeException("setStaticFieldValue boolean error " + str + "   Class   " + cls + "  value  " + z);
            }
        }
    }
}
