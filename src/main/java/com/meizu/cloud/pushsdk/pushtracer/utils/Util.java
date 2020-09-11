package com.meizu.cloud.pushsdk.pushtracer.utils;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {
    private static final String TAG = "Util";

    public static boolean isTimeInRange(long j, long j2, long j3) {
        return j > j2 - j3;
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
                Logger.m4855e(TAG, "Could not put key '%s' and value '%s' into new JSONObject: %s", str, jsonSafeObject, e);
                e.printStackTrace();
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

    public static long getUTF8Length(String str) {
        long j = 0;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                j++;
            } else if (charAt <= 2047) {
                j += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                j = charAt < 65535 ? j + 3 : j + 4;
            } else {
                j += 4;
                i++;
            }
            i++;
        }
        return j;
    }

    public static String base64Encode(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static String getTimestamp() {
        return Long.toString(System.currentTimeMillis());
    }

    public static boolean isOnline(Context context) {
        Logger.m4856i(TAG, "Checking tracker internet connectivity.", new Object[0]);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            Logger.m4854d(TAG, "Tracker connection online: %s", Boolean.valueOf(z));
            return z;
        } catch (SecurityException e) {
            Logger.m4855e(TAG, "Security exception checking connection: %s", e.toString());
            return true;
        }
    }

    public static String getCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public static Location getLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(1);
        criteria.setAccuracy(2);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider != null) {
            try {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                Logger.m4854d(TAG, "Location found: %s", lastKnownLocation);
                return lastKnownLocation;
            } catch (SecurityException e) {
                Logger.m4855e(TAG, "Failed to retrieve location: %s", e.toString());
                return null;
            }
        } else {
            Logger.m4855e(TAG, "Location Manager provider is null.", new Object[0]);
            return null;
        }
    }

    public static String getEventId() {
        return UUID.randomUUID().toString();
    }
}
