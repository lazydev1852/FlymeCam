package com.baidu.p020ar.arplay.util;

import com.baidu.p020ar.util.SystemInfoUtil;
import java.util.HashMap;

/* renamed from: com.baidu.ar.arplay.util.MsgParamsUtil */
public class MsgParamsUtil {
    public static float obj2Float(Object obj, float f) {
        if (obj == null) {
            return f;
        }
        if ((obj instanceof Float) || (obj instanceof Integer)) {
            return ((Float) obj).floatValue();
        }
        if (!(obj instanceof String)) {
            return f;
        }
        try {
            return Float.parseFloat((String) obj);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return f;
        }
    }

    public static HashMap<String, Object> obj2HashMap(Object obj, HashMap<String, Object> hashMap) {
        return (obj == null || !(obj instanceof HashMap)) ? hashMap : (HashMap) obj;
    }

    public static int obj2Int(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return i;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static long obj2Long(Object obj, long j) {
        if (obj == null) {
            return j;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return j;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static String obj2String(Object obj, String str) {
        return obj != null ? String.valueOf(obj) : str;
    }

    public static float[] str2FloatArray(String str) {
        String[] split = str.split(SystemInfoUtil.COMMA);
        float[] fArr = new float[split.length];
        int i = 0;
        while (i < split.length) {
            try {
                fArr[i] = Float.parseFloat(split[i]);
                i++;
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return fArr;
    }

    public static String[] str2StringArray(String str) {
        return str.split(SystemInfoUtil.COMMA);
    }
}
