package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.savior.Constants;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ASMUtils {
    public static final boolean IS_ANDROID = isAndroid(JAVA_VM_NAME);
    public static final String JAVA_VM_NAME = System.getProperty("java.vm.name");

    public static boolean isAndroid(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("dalvik") || lowerCase.contains("lemur")) {
            return true;
        }
        return false;
    }

    public static String desc(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder((parameterTypes.length + 1) << 4);
        sb.append('(');
        for (Class desc : parameterTypes) {
            sb.append(desc((Class<?>) desc));
        }
        sb.append(')');
        sb.append(desc(method.getReturnType()));
        return sb.toString();
    }

    public static String desc(Class<?> cls) {
        if (cls.isPrimitive()) {
            return getPrimitiveLetter(cls);
        }
        if (cls.isArray()) {
            return Constants.ARRAY_TYPE + desc(cls.getComponentType());
        }
        return "L" + type(cls) + Constants.PACKNAME_END;
    }

    public static String type(Class<?> cls) {
        if (cls.isArray()) {
            return Constants.ARRAY_TYPE + desc(cls.getComponentType());
        } else if (!cls.isPrimitive()) {
            return cls.getName().replace('.', '/');
        } else {
            return getPrimitiveLetter(cls);
        }
    }

    public static String getPrimitiveLetter(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return "I";
        }
        if (Void.TYPE == cls) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return "B";
        }
        if (Short.TYPE == cls) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return "J";
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static Type getMethodType(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]).getGenericReturnType();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean checkName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 1 || charAt > 127 || charAt == '.') {
                return false;
            }
        }
        return true;
    }
}
