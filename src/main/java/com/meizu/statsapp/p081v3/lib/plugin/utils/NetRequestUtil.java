package com.meizu.statsapp.p081v3.lib.plugin.utils;

import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.NetRequestUtil */
public class NetRequestUtil {
    public static String HEADER_If_Modified_Since = "If-Modified-Since";
    public static String HEADER_If_None_Match = "If-None-Match";
    public static String TAG = "NetRequestUtil";

    public static String sign(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        String str3;
        HashMap hashMap = new HashMap(map);
        try {
            str3 = new URI(str2).getPath();
        } catch (URISyntaxException e) {
            String str4 = TAG;
            Logger.m17382w(str4, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            str3 = "";
        }
        hashMap.put("key", UxipConstants.UMID_SECRET_KEY);
        if (map2 != null && map2.containsKey(HEADER_If_None_Match)) {
            hashMap.put(HEADER_If_None_Match, map2.get(HEADER_If_None_Match));
        }
        if (map2 != null && map2.containsKey(HEADER_If_Modified_Since)) {
            hashMap.put(HEADER_If_Modified_Since, map2.get(HEADER_If_Modified_Since));
        }
        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str5 : arrayList) {
            sb.append("&");
            sb.append(urlEncode(str5));
            sb.append("=");
            sb.append(urlEncode((String) hashMap.get(str5)));
        }
        String substring = sb.toString().substring(1);
        return C2943Utils.getMD5((str + "\n" + str3 + "\n" + substring).getBytes());
    }

    private static Map<String, String> flatMap(Map<String, String[]> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), toString((String[]) next.getValue()));
        }
        return hashMap;
    }

    private static String toString(String[] strArr) {
        int length;
        if (strArr == null || strArr.length - 1 == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            sb.append(strArr[i]);
            if (i == length) {
                return sb.toString();
            }
            sb.append(",  ");
            i++;
        }
    }

    private static String urlEncode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
