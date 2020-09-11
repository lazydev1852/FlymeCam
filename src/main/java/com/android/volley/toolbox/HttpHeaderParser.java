package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* renamed from: com.android.volley.toolbox.g */
public class HttpHeaderParser {
    /* renamed from: a */
    public static Cache.C0443a m669a(NetworkResponse kVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        NetworkResponse kVar2 = kVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = kVar2.f327c;
        String str = map.get(HTTP.DATE_HEADER);
        long a = str != null ? m668a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(SystemInfoUtil.COMMA, 0);
            j2 = 0;
            int i2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j2 = 0;
            j = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long a2 = str3 != null ? m668a(str3) : 0;
        String str4 = map.get("Last-Modified");
        long a3 = str4 != null ? m668a(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i == 0) {
                j3 = (j * 1000) + j4;
                Cache.C0443a aVar = new Cache.C0443a();
                aVar.f289a = kVar2.f326b;
                aVar.f290b = str5;
                aVar.f294f = j4;
                aVar.f293e = j3;
                aVar.f291c = a;
                aVar.f292d = a3;
                aVar.f295g = map;
                aVar.f296h = kVar2.f328d;
                return aVar;
            }
        } else if (a <= 0 || a2 < a) {
            j4 = 0;
        } else {
            j3 = (a2 - a) + currentTimeMillis;
            j4 = j3;
            Cache.C0443a aVar2 = new Cache.C0443a();
            aVar2.f289a = kVar2.f326b;
            aVar2.f290b = str5;
            aVar2.f294f = j4;
            aVar2.f293e = j3;
            aVar2.f291c = a;
            aVar2.f292d = a3;
            aVar2.f295g = map;
            aVar2.f296h = kVar2.f328d;
            return aVar2;
        }
        j3 = j4;
        Cache.C0443a aVar22 = new Cache.C0443a();
        aVar22.f289a = kVar2.f326b;
        aVar22.f290b = str5;
        aVar22.f294f = j4;
        aVar22.f293e = j3;
        aVar22.f291c = a;
        aVar22.f292d = a3;
        aVar22.f295g = map;
        aVar22.f296h = kVar2.f328d;
        return aVar22;
    }

    /* renamed from: a */
    public static long m668a(String str) {
        try {
            return m673a().parse(str).getTime();
        } catch (ParseException e) {
            VolleyLog.m727a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    /* renamed from: a */
    static String m670a(long j) {
        return m673a().format(new Date(j));
    }

    /* renamed from: a */
    private static SimpleDateFormat m673a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    public static String m672a(Map<String, String> map, String str) {
        String str2 = map.get(HTTP.CONTENT_TYPE);
        if (str2 != null) {
            String[] split = str2.split(Constants.PACKNAME_END, 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m671a(Map<String, String> map) {
        return m672a(map, "ISO-8859-1");
    }

    /* renamed from: a */
    static Map<String, String> m674a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header next : list) {
            treeMap.put(next.mo8694a(), next.mo8695b());
        }
        return treeMap;
    }

    /* renamed from: b */
    static List<Header> m675b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new Header((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }
}
