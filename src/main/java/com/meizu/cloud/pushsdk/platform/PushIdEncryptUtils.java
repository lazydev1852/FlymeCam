package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PushIdEncryptUtils {
    private static final String TAG = "PushIdEncryptUtils";
    private static final List<String> keyList = new ArrayList(secretKeyMap.keySet());
    private static Map<String, String> secretKeyMap = initKeyMap();

    private static Map<String, String> initKeyMap() {
        if (isEmpty(secretKeyMap)) {
            synchronized (PushIdEncryptUtils.class) {
                if (isEmpty(secretKeyMap)) {
                    secretKeyMap = new TreeMap();
                    secretKeyMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    secretKeyMap.put("G3G", "XAsFqhhaf4gKpmAi");
                    secretKeyMap.put("V5R", "cOqH18NXwBtZVkvz");
                    secretKeyMap.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    secretKeyMap.put("Z9K", "pH6J9DMPNgqQp8m8");
                    secretKeyMap.put("EIM", "K11Rs9HAKRXeNwq8");
                    secretKeyMap.put("SO7", "T8LquL1DvwVcogiU");
                    secretKeyMap.put("DDI", "d02F6ttOtV05MYCQ");
                    secretKeyMap.put("ULY", "ToZZIhAywnUfHShN");
                    secretKeyMap.put("0EV", "r5D5RRwQhfV0AYLb");
                    secretKeyMap.put("N6A", "QAtSBFcXnQoUgHO2");
                    secretKeyMap.put("S5Q", "sDWLrZINnum227am");
                    secretKeyMap.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    secretKeyMap.put("J04", "N5hViUTdLCpN59H0");
                    secretKeyMap.put("B68", "EY3sH1KKtalg5ZaT");
                    secretKeyMap.put("9IW", "q1u0MiuFyim4pCYY");
                    secretKeyMap.put("UU3", "syLnkkd8AqNykVV7");
                    secretKeyMap.put("Z49", "V00FiWu124yE91sH");
                    secretKeyMap.put("BNA", "rPP7AK1VWpKEry3p");
                    secretKeyMap.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return secretKeyMap;
    }

    private static String encryptPushId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = keyList.get(Math.abs(str.hashCode()) % secretKeyMap.size());
        String str3 = secretKeyMap.get(str2);
        try {
            str = new String(str.getBytes("UTF-8"), "iso-8859-1");
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "encryptPushId getBytes error " + e.getMessage());
        }
        char[] cArr = new char[str.length()];
        String str4 = str2;
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (i2 == str3.length()) {
                i2 = 0;
            }
            cArr[i] = (char) (str.charAt(i) ^ str3.charAt(i2));
            String hexString = Integer.toHexString(cArr[i]);
            if (hexString.length() == 1) {
                str4 = str4 + "0" + hexString;
            } else {
                str4 = str4 + hexString;
            }
            i++;
            i2++;
        }
        return str4;
    }

    public static String decryptPushId(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() <= 3) {
                return str;
            }
            String substring = str.substring(0, 3);
            if (!secretKeyMap.containsKey(substring)) {
                return str;
            }
            String str3 = secretKeyMap.get(substring);
            str2 = str.substring(3, str.length());
            try {
                char[] cArr = new char[(str2.length() / 2)];
                int i = 0;
                int i2 = 0;
                while (i < str2.length() / 2) {
                    if (i2 == str3.length()) {
                        i2 = 0;
                    }
                    int i3 = i * 2;
                    cArr[i] = (char) (((char) Integer.valueOf(str2.substring(i3, i3 + 2), 16).intValue()) ^ str3.charAt(i2));
                    i++;
                    i2++;
                }
                return new String(String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
            } catch (Exception unused) {
                DebugLogger.m4828e(TAG, "invalid pushId encryption " + str2);
                return str;
            }
        } catch (Exception unused2) {
            str2 = str;
            DebugLogger.m4828e(TAG, "invalid pushId encryption " + str2);
            return str;
        }
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
