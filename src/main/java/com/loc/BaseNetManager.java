package com.loc;

import java.net.URLConnection;

/* renamed from: com.loc.ai */
public final class BaseNetManager {

    /* renamed from: a */
    public static int f2562a = 0;

    /* renamed from: b */
    public static String f2563b = "";

    /* renamed from: c */
    private static BaseNetManager f2564c;

    /* renamed from: com.loc.ai$a */
    /* compiled from: BaseNetManager */
    public interface C1049a {
        /* renamed from: a */
        URLConnection mo12998a();
    }

    /* renamed from: a */
    public static BaseNetManager m2998a() {
        if (f2564c == null) {
            f2564c = new BaseNetManager();
        }
        return f2564c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.loc.ResponseEntity m2999a(com.loc.Request r7, boolean r8) throws com.loc.AMapCoreException {
        /*
            if (r7 == 0) goto L_0x008f
            java.lang.String r0 = r7.mo12967c()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r0 == 0) goto L_0x0087
            java.lang.String r0 = ""
            java.lang.String r1 = r7.mo12967c()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            boolean r0 = r0.equals(r1)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r0 != 0) goto L_0x0087
            java.net.Proxy r0 = r7.f2586e     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r0 != 0) goto L_0x001a
            r0 = 0
            goto L_0x001c
        L_0x001a:
            java.net.Proxy r0 = r7.f2586e     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
        L_0x001c:
            com.loc.al r1 = new com.loc.al     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            int r2 = r7.f2584c     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            int r3 = r7.f2585d     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            r1.<init>(r2, r3, r0, r8)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            byte[] r8 = r7.mo12997d()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r8 == 0) goto L_0x0053
            int r8 = r8.length     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r8 != 0) goto L_0x002f
            goto L_0x0053
        L_0x002f:
            java.util.Map r8 = r7.mo12966b()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r8 != 0) goto L_0x0036
            goto L_0x0053
        L_0x0036:
            java.lang.String r8 = com.loc.HttpUrlUtil.m3022a((java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            r0.<init>()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r2 = r7.mo12967c()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            r0.append(r2)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r2 = "?"
            r0.append(r2)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            r0.append(r8)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r8 = r0.toString()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            goto L_0x0057
        L_0x0053:
            java.lang.String r8 = r7.mo12967c()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
        L_0x0057:
            r2 = r8
            boolean r3 = r7.mo13025l()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r4 = r7.mo13024k()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.util.Map r5 = r7.mo12965a()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            byte[] r8 = r7.mo12997d()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r8 == 0) goto L_0x006d
            int r0 = r8.length     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r0 != 0) goto L_0x0081
        L_0x006d:
            java.util.Map r7 = r7.mo12966b()     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r7 = com.loc.HttpUrlUtil.m3022a((java.util.Map<java.lang.String, java.lang.String>) r7)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            if (r0 != 0) goto L_0x0081
            byte[] r7 = com.loc.C1107dj.m3818a((java.lang.String) r7)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            r6 = r7
            goto L_0x0082
        L_0x0081:
            r6 = r8
        L_0x0082:
            com.loc.an r7 = r1.mo13010a((java.lang.String) r2, (boolean) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r5, (byte[]) r6)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            return r7
        L_0x0087:
            com.loc.cx r7 = new com.loc.cx     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r8 = "request url is empty"
            r7.<init>(r8)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            throw r7     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
        L_0x008f:
            com.loc.cx r7 = new com.loc.cx     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            java.lang.String r8 = "requeust is null"
            r7.<init>(r8)     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
            throw r7     // Catch:{ cx -> 0x00a3, Throwable -> 0x0097 }
        L_0x0097:
            r7 = move-exception
            r7.printStackTrace()
            com.loc.cx r7 = new com.loc.cx
            java.lang.String r8 = "未知的错误"
            r7.<init>(r8)
            throw r7
        L_0x00a3:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.BaseNetManager.m2999a(com.loc.am, boolean):com.loc.an");
    }

    /* renamed from: a */
    public static byte[] m3000a(Request amVar) throws AMapCoreException {
        try {
            ResponseEntity a = m2999a(amVar, true);
            if (a != null) {
                return a.f2587a;
            }
            return null;
        } catch (AMapCoreException e) {
            throw e;
        } catch (Throwable unused) {
            throw new AMapCoreException("未知的错误");
        }
    }

    /* renamed from: b */
    public static byte[] m3001b(Request amVar) throws AMapCoreException {
        try {
            ResponseEntity a = m2999a(amVar, false);
            if (a != null) {
                return a.f2587a;
            }
            return null;
        } catch (AMapCoreException e) {
            throw e;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "bm", "msp");
            throw new AMapCoreException("未知的错误");
        }
    }
}
