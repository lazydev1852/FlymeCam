package com.meizu.update.util;

import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* renamed from: com.meizu.update.util.i */
public class UrlRequest {
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e0 A[SYNTHETIC, Splitter:B:56:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e8 A[Catch:{ IOException -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ed A[Catch:{ IOException -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fa A[SYNTHETIC, Splitter:B:67:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0102 A[Catch:{ IOException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0107 A[Catch:{ IOException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m17953a(android.content.Context r4, java.lang.String r5, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r6) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.lang.String r1 = "User-Agent"
            java.lang.String r4 = com.meizu.update.util.Utility.m18002u(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            r5.setRequestProperty(r1, r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            r4 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            r4 = 1
            r5.setDoInput(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            r5.setDoOutput(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            r4 = 0
            r5.setUseCaches(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            java.io.OutputStream r4 = r5.getOutputStream()     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            java.lang.String r1 = "UTF-8"
            byte[] r6 = m17954a(r6, r1)     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            r4.write(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            int r6 = r5.getResponseCode()     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            r1 = 200(0xc8, float:2.8E-43)
            if (r6 != r1) goto L_0x008c
            java.io.InputStream r6 = r5.getInputStream()     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            java.lang.String r2 = "UTF-8"
            r1.<init>(r6, r2)     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            r1.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
        L_0x0056:
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            if (r2 == 0) goto L_0x0065
            r1.append(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            goto L_0x0056
        L_0x0065:
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            if (r6 == 0) goto L_0x0071
            r6.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r4 = move-exception
            goto L_0x007c
        L_0x0071:
            if (r4 == 0) goto L_0x0076
            r4.close()     // Catch:{ IOException -> 0x006f }
        L_0x0076:
            if (r5 == 0) goto L_0x007f
            r5.disconnect()     // Catch:{ IOException -> 0x006f }
            goto L_0x007f
        L_0x007c:
            r4.printStackTrace()
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            r3 = r5
            r5 = r4
            r4 = r0
            r0 = r6
            goto L_0x00af
        L_0x0086:
            r0 = move-exception
            r3 = r5
            r5 = r4
            r4 = r0
            r0 = r6
            goto L_0x00b5
        L_0x008c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            r1.<init>()     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            java.lang.String r2 = "UrlRequest --> Server response code : "
            r1.append(r2)     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            r1.append(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            com.meizu.update.util.Loger.m17943d(r6)     // Catch:{ Exception -> 0x00b1, all -> 0x00ab }
            if (r4 == 0) goto L_0x00a5
            r4.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00a5:
            if (r5 == 0) goto L_0x00f4
            r5.disconnect()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00f4
        L_0x00ab:
            r6 = move-exception
            r3 = r5
            r5 = r4
            r4 = r6
        L_0x00af:
            r6 = r3
            goto L_0x00f8
        L_0x00b1:
            r6 = move-exception
            r3 = r5
            r5 = r4
            r4 = r6
        L_0x00b5:
            r6 = r3
            goto L_0x00c6
        L_0x00b7:
            r4 = move-exception
            r6 = r5
            r5 = r0
            goto L_0x00f8
        L_0x00bb:
            r4 = move-exception
            r6 = r5
            r5 = r0
            goto L_0x00c6
        L_0x00bf:
            r4 = move-exception
            r5 = r0
            r6 = r5
            goto L_0x00f8
        L_0x00c3:
            r4 = move-exception
            r5 = r0
            r6 = r5
        L_0x00c6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r1.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = "UrlRequest --> requestBase Error: "
            r1.append(r2)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00f7 }
            r1.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00f7 }
            com.meizu.update.util.Loger.m17943d(r4)     // Catch:{ all -> 0x00f7 }
            if (r0 == 0) goto L_0x00e6
            r0.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00e6
        L_0x00e4:
            r4 = move-exception
            goto L_0x00f1
        L_0x00e6:
            if (r5 == 0) goto L_0x00eb
            r5.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00eb:
            if (r6 == 0) goto L_0x00f4
            r6.disconnect()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00f4
        L_0x00f1:
            r4.printStackTrace()
        L_0x00f4:
            java.lang.String r4 = ""
            return r4
        L_0x00f7:
            r4 = move-exception
        L_0x00f8:
            if (r0 == 0) goto L_0x0100
            r0.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0100
        L_0x00fe:
            r5 = move-exception
            goto L_0x010b
        L_0x0100:
            if (r5 == 0) goto L_0x0105
            r5.close()     // Catch:{ IOException -> 0x00fe }
        L_0x0105:
            if (r6 == 0) goto L_0x010e
            r6.disconnect()     // Catch:{ IOException -> 0x00fe }
            goto L_0x010e
        L_0x010b:
            r5.printStackTrace()
        L_0x010e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.UrlRequest.m17953a(android.content.Context, java.lang.String, java.util.List):java.lang.String");
    }

    /* renamed from: a */
    public static byte[] m17954a(List<Pair<String, String>> list, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (Pair next : list) {
                        sb.append(URLEncoder.encode((String) next.first, str));
                        sb.append('=');
                        sb.append(URLEncoder.encode((String) next.second, str));
                        sb.append('&');
                    }
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Encoding not supported: " + str, e);
            }
        }
        return sb.toString().getBytes(str);
    }
}
