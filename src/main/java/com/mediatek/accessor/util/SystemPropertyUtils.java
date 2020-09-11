package com.mediatek.accessor.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SystemPropertyUtils {
    private static final String TAG = Log.Tag(SystemPropertyUtils.class.getSimpleName());
    private static Method sGetIntMethod;
    private static Method sGetMethod;
    private static boolean sHasChecked = false;
    private static boolean sIsSystemPropertiesExist = false;

    public static int getInt(String str, int i) {
        if (!isSystemPropertiesExist() || sGetIntMethod == null) {
            return i;
        }
        try {
            return ((Integer) sGetIntMethod.invoke((Object) null, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (IllegalAccessException unused) {
            return i;
        } catch (InvocationTargetException unused2) {
            return i;
        }
    }

    public static String get(String str) {
        if (!isSystemPropertiesExist() || sGetMethod == null) {
            return "";
        }
        try {
            return (String) sGetMethod.invoke((Object) null, new Object[]{str});
        } catch (IllegalAccessException unused) {
            return "";
        } catch (InvocationTargetException unused2) {
            return "";
        }
    }

    private static boolean isSystemPropertiesExist() {
        if (!sHasChecked) {
            try {
                Class<?> loadClass = SystemPropertyUtils.class.getClassLoader().loadClass("android.os.SystemProperties");
                sGetIntMethod = loadClass.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
                sGetIntMethod.setAccessible(true);
                sGetMethod = loadClass.getDeclaredMethod("get", new Class[]{String.class});
                sGetMethod.setAccessible(true);
                sIsSystemPropertiesExist = loadClass != null;
                sHasChecked = true;
            } catch (ClassNotFoundException unused) {
                sIsSystemPropertiesExist = false;
                sHasChecked = true;
            } catch (NoSuchMethodException e) {
                Log.m3996e(TAG, "<isSystemPropertiesExist> NoSuchMethodException", e);
            }
        }
        return sIsSystemPropertiesExist;
    }
}
