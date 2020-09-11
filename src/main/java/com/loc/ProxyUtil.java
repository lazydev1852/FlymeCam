package com.loc;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* renamed from: com.loc.dg */
public final class ProxyUtil {
    /* renamed from: a */
    private static String m3767a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: a */
    public static java.net.Proxy m3768a(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? m3769a(context, new URI("http://restapi.amap.com")) : m3771b(context);
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "pu", "gp");
            return null;
        }
    }

    /* renamed from: a */
    private static java.net.Proxy m3769a(Context context, URI uri) {
        java.net.Proxy proxy;
        if (m3772c(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                SDKLogHandler.m3867b(th, "pu", "gpsc");
            }
        }
        return null;
    }

    /* renamed from: b */
    private static int m3770b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r4 == -1) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ac, code lost:
        if (r4 == -1) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x014e A[SYNTHETIC, Splitter:B:109:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0153 A[SYNTHETIC, Splitter:B:112:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0161 A[Catch:{ Throwable -> 0x015d }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017b A[SYNTHETIC, Splitter:B:125:0x017b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b9 A[SYNTHETIC, Splitter:B:62:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dc A[SYNTHETIC, Splitter:B:75:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2 A[Catch:{ all -> 0x0178 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy m3771b(android.content.Context r11) {
        /*
            boolean r0 = m3772c(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0188
            java.lang.String r0 = "content://telephony/carriers/preferapn"
            android.net.Uri r3 = android.net.Uri.parse(r0)
            android.content.ContentResolver r2 = r11.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = 80
            r8 = 0
            r9 = 1
            r10 = -1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ SecurityException -> 0x00e1, Throwable -> 0x00cc, all -> 0x00c8 }
            if (r2 == 0) goto L_0x00b5
            boolean r3 = r2.moveToFirst()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x00b5
            java.lang.String r3 = "apn"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x0038
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            java.lang.String r3 = r3.toLowerCase(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        L_0x0038:
            if (r3 == 0) goto L_0x007d
            java.lang.String r4 = "ctwap"
            boolean r4 = r3.contains(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r4 == 0) goto L_0x007d
            java.lang.String r3 = m3767a()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            int r4 = m3770b()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
            if (r5 != 0) goto L_0x005b
            java.lang.String r5 = "null"
            boolean r5 = r3.equals(r5)     // Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
            if (r5 != 0) goto L_0x005b
            r5 = r3
            r3 = 1
            goto L_0x005d
        L_0x005b:
            r5 = r1
            r3 = 0
        L_0x005d:
            if (r3 != 0) goto L_0x006e
            java.lang.String r3 = "QMTAuMC4wLjIwMA=="
            java.lang.String r3 = com.loc.C1107dj.m3824c((java.lang.String) r3)     // Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
            goto L_0x006f
        L_0x0066:
            r11 = move-exception
            r0 = r4
            r3 = r5
            goto L_0x00d0
        L_0x006b:
            r3 = move-exception
            goto L_0x00e5
        L_0x006e:
            r3 = r5
        L_0x006f:
            if (r4 != r10) goto L_0x0072
            goto L_0x00b7
        L_0x0072:
            r0 = r4
            goto L_0x00b7
        L_0x0074:
            r11 = move-exception
            r3 = r1
            r0 = r4
            goto L_0x00d0
        L_0x0079:
            r3 = move-exception
            r5 = r1
            goto L_0x00e5
        L_0x007d:
            if (r3 == 0) goto L_0x00b5
            java.lang.String r4 = "wap"
            boolean r3 = r3.contains(r4)     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            if (r3 == 0) goto L_0x00b5
            java.lang.String r3 = m3767a()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            int r4 = m3770b()     // Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
            if (r5 != 0) goto L_0x00a0
            java.lang.String r5 = "null"
            boolean r5 = r3.equals(r5)     // Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
            if (r5 != 0) goto L_0x00a0
            r5 = r3
            r3 = 1
            goto L_0x00a2
        L_0x00a0:
            r5 = r1
            r3 = 0
        L_0x00a2:
            if (r3 != 0) goto L_0x00ab
            java.lang.String r3 = "QMTAuMC4wLjE3Mg=="
            java.lang.String r3 = com.loc.C1107dj.m3824c((java.lang.String) r3)     // Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
            goto L_0x00ac
        L_0x00ab:
            r3 = r5
        L_0x00ac:
            if (r4 != r10) goto L_0x0072
            goto L_0x00b7
        L_0x00af:
            r11 = move-exception
            r3 = r1
            goto L_0x00cf
        L_0x00b2:
            r3 = move-exception
            r5 = r1
            goto L_0x00e4
        L_0x00b5:
            r3 = r1
            r0 = -1
        L_0x00b7:
            if (r2 == 0) goto L_0x0151
            r2.close()     // Catch:{ Throwable -> 0x00be }
            goto L_0x0151
        L_0x00be:
            r11 = move-exception
            java.lang.String r2 = "pu"
            java.lang.String r4 = "gPx2"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r11, (java.lang.String) r2, (java.lang.String) r4)
            goto L_0x0151
        L_0x00c8:
            r11 = move-exception
            r2 = r1
            goto L_0x0179
        L_0x00cc:
            r11 = move-exception
            r2 = r1
            r3 = r2
        L_0x00cf:
            r0 = -1
        L_0x00d0:
            java.lang.String r4 = "pu"
            java.lang.String r5 = "gPx1"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r11, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0178 }
            r11.printStackTrace()     // Catch:{ all -> 0x0178 }
            if (r2 == 0) goto L_0x0151
            r2.close()     // Catch:{ Throwable -> 0x00be }
            goto L_0x0151
        L_0x00e1:
            r3 = move-exception
            r2 = r1
            r5 = r2
        L_0x00e4:
            r4 = -1
        L_0x00e5:
            java.lang.String r6 = "pu"
            java.lang.String r7 = "ghp"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r3, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = com.loc.DeviceInfo.m3731t(r11)     // Catch:{ all -> 0x0178 }
            if (r11 == 0) goto L_0x014a
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = r11.toLowerCase(r3)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = m3767a()     // Catch:{ all -> 0x0178 }
            int r4 = m3770b()     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = "ctwap"
            int r6 = r11.indexOf(r6)     // Catch:{ all -> 0x0178 }
            if (r6 == r10) goto L_0x0127
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0178 }
            if (r11 != 0) goto L_0x0118
            java.lang.String r11 = "null"
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0178 }
            if (r11 != 0) goto L_0x0118
            r11 = 1
            goto L_0x011a
        L_0x0118:
            r3 = r5
            r11 = 0
        L_0x011a:
            if (r11 != 0) goto L_0x0122
            java.lang.String r11 = "QMTAuMC4wLjIwMA=="
            java.lang.String r3 = com.loc.C1107dj.m3824c((java.lang.String) r11)     // Catch:{ all -> 0x0178 }
        L_0x0122:
            if (r4 != r10) goto L_0x0125
            goto L_0x014c
        L_0x0125:
            r0 = r4
            goto L_0x014c
        L_0x0127:
            java.lang.String r6 = "wap"
            int r11 = r11.indexOf(r6)     // Catch:{ all -> 0x0178 }
            if (r11 == r10) goto L_0x014a
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0178 }
            if (r11 != 0) goto L_0x013f
            java.lang.String r11 = "null"
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0178 }
            if (r11 != 0) goto L_0x013f
            r11 = 1
            goto L_0x0141
        L_0x013f:
            r3 = r5
            r11 = 0
        L_0x0141:
            if (r11 != 0) goto L_0x014c
            java.lang.String r11 = "QMTAuMC4wLjE3Mg=="
            java.lang.String r3 = com.loc.C1107dj.m3824c((java.lang.String) r11)     // Catch:{ all -> 0x0178 }
            goto L_0x014c
        L_0x014a:
            r0 = r4
            r3 = r5
        L_0x014c:
            if (r2 == 0) goto L_0x0151
            r2.close()     // Catch:{ Throwable -> 0x00be }
        L_0x0151:
            if (r3 == 0) goto L_0x015f
            int r11 = r3.length()     // Catch:{ Throwable -> 0x015d }
            if (r11 <= 0) goto L_0x015f
            if (r0 == r10) goto L_0x015f
            r8 = 1
            goto L_0x015f
        L_0x015d:
            r11 = move-exception
            goto L_0x016d
        L_0x015f:
            if (r8 == 0) goto L_0x0188
            java.net.Proxy r11 = new java.net.Proxy     // Catch:{ Throwable -> 0x015d }
            java.net.Proxy$Type r2 = java.net.Proxy.Type.HTTP     // Catch:{ Throwable -> 0x015d }
            java.net.InetSocketAddress r0 = java.net.InetSocketAddress.createUnresolved(r3, r0)     // Catch:{ Throwable -> 0x015d }
            r11.<init>(r2, r0)     // Catch:{ Throwable -> 0x015d }
            return r11
        L_0x016d:
            java.lang.String r0 = "pu"
            java.lang.String r2 = "gp2"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
            r11.printStackTrace()
            goto L_0x0188
        L_0x0178:
            r11 = move-exception
        L_0x0179:
            if (r2 == 0) goto L_0x0187
            r2.close()     // Catch:{ Throwable -> 0x017f }
            goto L_0x0187
        L_0x017f:
            r0 = move-exception
            java.lang.String r1 = "pu"
            java.lang.String r2 = "gPx2"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0187:
            throw r11
        L_0x0188:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ProxyUtil.m3771b(android.content.Context):java.net.Proxy");
    }

    /* renamed from: c */
    private static boolean m3772c(Context context) {
        return DeviceInfo.m3729r(context) == 0;
    }
}
