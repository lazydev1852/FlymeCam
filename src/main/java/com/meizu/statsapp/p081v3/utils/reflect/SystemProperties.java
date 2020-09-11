package com.meizu.statsapp.p081v3.utils.reflect;

/* renamed from: com.meizu.statsapp.v3.utils.reflect.SystemProperties */
public class SystemProperties {
    public static String get(String str) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (String) ReflectionCache.build().getMethod(forName, "get", String.class).invoke(forName, new Object[]{str});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String get(String str, String str2) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (String) ReflectionCache.build().getMethod(forName, "get", String.class, String.class).invoke(forName, new Object[]{str, str2});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static Integer getInt(String str, int i) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Integer) ReflectionCache.build().getMethod(forName, "getInt", String.class, Integer.TYPE).invoke(forName, new Object[]{str, Integer.valueOf(i)});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Integer.valueOf(i);
        }
    }

    public static Long getLong(String str, long j) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Long) ReflectionCache.build().getMethod(forName, "getLong", String.class, Long.TYPE).invoke(forName, new Object[]{str, Long.valueOf(j)});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Long.valueOf(j);
        }
    }

    public static Boolean getBoolean(String str, boolean z) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Boolean) ReflectionCache.build().getMethod(forName, "getBoolean", String.class, Boolean.TYPE).invoke(forName, new Object[]{str, Boolean.valueOf(z)});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Boolean.valueOf(z);
        }
    }
}
