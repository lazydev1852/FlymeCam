package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.os.Build;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.Utils */
public class C2943Utils {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String TAG = "Utils";

    public static String getMD5(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            return bytesToHexString(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            String str = TAG;
            Logger.m17382w(str, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return null;
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = DIGITS[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = DIGITS[b & 15];
        }
        return new String(cArr);
    }

    public static JSONObject mapToJSONObject(Map map) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object jsonSafeObject = getJsonSafeObject(entry.getValue());
            try {
                jSONObject.put(str, jsonSafeObject);
            } catch (JSONException e) {
                String str2 = TAG;
                Logger.m17382w(str2, "Could not put key:" + str + " and value:" + jsonSafeObject + " into new JSONObject:" + e);
            }
        }
        return jSONObject;
    }

    private static Object getJsonSafeObject(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return obj;
        }
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            for (Object jsonSafeObject : (Collection) obj) {
                jSONArray.put(getJsonSafeObject(jsonSafeObject));
            }
            return jSONArray;
        } else if (obj.getClass().isArray()) {
            JSONArray jSONArray2 = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray2.put(getJsonSafeObject(Array.get(obj, i)));
            }
            return jSONArray2;
        } else if (obj instanceof Map) {
            return mapToJSONObject((Map) obj);
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                return obj;
            }
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
    }

    public static Map<String, Object> jsonObjectToMap(JSONObject jSONObject) throws JSONException {
        return jSONObject != JSONObject.NULL ? toMap(jSONObject) : new HashMap();
    }

    private static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj == JSONObject.NULL) {
                obj = null;
            } else if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    private static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                CommonUtils.closeQuietly(gZIPOutputStream2);
            } catch (IOException e) {
                e = e;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    String str = TAG;
                    Logger.m17382w(str, "Exception: " + e.toString() + " - Cause: " + e.getCause());
                    CommonUtils.closeQuietly(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeQuietly(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                CommonUtils.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            String str2 = TAG;
            Logger.m17382w(str2, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            CommonUtils.closeQuietly(gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean isAndroidQ() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
