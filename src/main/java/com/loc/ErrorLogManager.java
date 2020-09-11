package com.loc;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.loc.k */
public class ErrorLogManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WeakReference<LogConfig> f3370a = null;

    /* renamed from: b */
    private static boolean f3371b = true;

    /* renamed from: c */
    private static WeakReference<UpdateStrategy> f3372c;

    /* renamed from: d */
    private static WeakReference<UpdateStrategy> f3373d;

    /* renamed from: e */
    private static String[] f3374e = new String[10];

    /* renamed from: f */
    private static int f3375f = 0;

    /* renamed from: g */
    private static boolean f3376g = false;

    /* renamed from: h */
    private static int f3377h = 0;

    /* renamed from: i */
    private static SDKInfo f3378i;

    /* renamed from: a */
    private static SDKInfo m3874a(Context context, String str) {
        List<SDKInfo> b = C1108h.m3853b(context);
        if (b == null) {
            b = new ArrayList<>();
        }
        if (str != null && !"".equals(str)) {
            for (SDKInfo diVar : b) {
                if (C1108h.m3852a(diVar.mo13279f(), str)) {
                    return diVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return C1107dj.m3804a();
                } catch (AMapCoreException e) {
                    e.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    SDKInfo b2 = C1107dj.m3819b();
                    b2.mo13273a(true);
                    return b2;
                } catch (AMapCoreException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a2, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a4 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0125 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a4 A[EDGE_INSN: B:45:0x00a4->B:46:? ?: BREAK  
EDGE_INSN: B:34:0x0078->B:45:0x00a4 ?: BREAK  , SYNTHETIC, Splitter:B:45:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d7 A[SYNTHETIC, Splitter:B:67:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e5 A[SYNTHETIC, Splitter:B:72:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec A[SYNTHETIC, Splitter:B:76:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fa A[SYNTHETIC, Splitter:B:81:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010b A[SYNTHETIC, Splitter:B:90:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0119 A[SYNTHETIC, Splitter:B:95:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3875a(java.util.List<com.loc.SDKInfo> r10) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0107, Throwable -> 0x00cb, all -> 0x00c7 }
            java.lang.String r2 = "/data/anr/traces.txt"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0107, Throwable -> 0x00cb, all -> 0x00c7 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0107, Throwable -> 0x00cb, all -> 0x00c7 }
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0107, Throwable -> 0x00cb, all -> 0x00c7 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0107, Throwable -> 0x00cb, all -> 0x00c7 }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
            r3 = 1024000(0xfa000, float:1.43493E-39)
            if (r1 <= r3) goto L_0x0022
            int r1 = r1 - r3
            long r3 = (long) r1     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
            r2.skip(r3)     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
        L_0x0022:
            com.loc.af r1 = new com.loc.af     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
            java.nio.charset.Charset r3 = com.loc.Util.f2558a     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x00c5, Throwable -> 0x00c2, all -> 0x00bf }
            r3 = 0
            r4 = 0
        L_0x002b:
            java.lang.String r5 = r1.mo12994a()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            java.lang.String r5 = r5.trim()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            java.lang.String r6 = "pid"
            boolean r6 = r5.contains(r6)     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            r7 = 1
            if (r6 == 0) goto L_0x004a
        L_0x003c:
            java.lang.String r4 = "\"main\""
            boolean r4 = r5.startsWith(r4)     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            if (r4 != 0) goto L_0x0049
            java.lang.String r5 = r1.mo12994a()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            goto L_0x003c
        L_0x0049:
            r4 = 1
        L_0x004a:
            java.lang.String r6 = ""
            boolean r6 = r5.equals(r6)     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            if (r6 == 0) goto L_0x0055
            if (r4 == 0) goto L_0x0055
            goto L_0x00a4
        L_0x0055:
            if (r4 == 0) goto L_0x002b
            int r6 = f3375f     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            r8 = 9
            if (r6 <= r8) goto L_0x005f
            f3375f = r3     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
        L_0x005f:
            java.lang.String[] r6 = f3374e     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            int r8 = f3375f     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            r6[r8] = r5     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            int r6 = f3375f     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            int r6 = r6 + r7
            f3375f = r6     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x0109 }
            goto L_0x0073
        L_0x006b:
            r6 = move-exception
            java.lang.String r8 = "alg"
            java.lang.String r9 = "aDa"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r6, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
        L_0x0073:
            int r6 = f3377h     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            r8 = 5
            if (r6 != r8) goto L_0x0079
            goto L_0x00a4
        L_0x0079:
            boolean r6 = f3376g     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            if (r6 != 0) goto L_0x009c
            java.util.Iterator r6 = r10.iterator()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
        L_0x0081:
            boolean r7 = r6.hasNext()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            if (r7 == 0) goto L_0x002b
            java.lang.Object r7 = r6.next()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            com.loc.di r7 = (com.loc.SDKInfo) r7     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            java.lang.String[] r8 = r7.mo13279f()     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            boolean r8 = com.loc.C1108h.m3855b((java.lang.String[]) r8, (java.lang.String) r5)     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            f3376g = r8     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            if (r8 == 0) goto L_0x0081
            f3378i = r7     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            goto L_0x002b
        L_0x009c:
            int r5 = f3377h     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            int r5 = r5 + r7
            f3377h = r5     // Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x0109, Throwable -> 0x00a2 }
            goto L_0x002b
        L_0x00a2:
            r10 = move-exception
            goto L_0x00ce
        L_0x00a4:
            r1.close()     // Catch:{ Throwable -> 0x00a8 }
            goto L_0x00b0
        L_0x00a8:
            r10 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r10, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00b0:
            r2.close()     // Catch:{ Throwable -> 0x00b5 }
            goto L_0x011c
        L_0x00b5:
            r10 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r10, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x011c
        L_0x00bf:
            r10 = move-exception
            r1 = r0
            goto L_0x00ea
        L_0x00c2:
            r10 = move-exception
            r1 = r0
            goto L_0x00ce
        L_0x00c5:
            r1 = r0
            goto L_0x0109
        L_0x00c7:
            r10 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x00ea
        L_0x00cb:
            r10 = move-exception
            r1 = r0
            r2 = r1
        L_0x00ce:
            java.lang.String r3 = "alg"
            java.lang.String r4 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r10, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00e9 }
            if (r1 == 0) goto L_0x00e3
            r1.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00e3
        L_0x00db:
            r10 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r10, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00e3:
            if (r2 == 0) goto L_0x011c
            r2.close()     // Catch:{ Throwable -> 0x00b5 }
            goto L_0x011c
        L_0x00e9:
            r10 = move-exception
        L_0x00ea:
            if (r1 == 0) goto L_0x00f8
            r1.close()     // Catch:{ Throwable -> 0x00f0 }
            goto L_0x00f8
        L_0x00f0:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00f8:
            if (r2 == 0) goto L_0x0106
            r2.close()     // Catch:{ Throwable -> 0x00fe }
            goto L_0x0106
        L_0x00fe:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0106:
            throw r10
        L_0x0107:
            r1 = r0
            r2 = r1
        L_0x0109:
            if (r1 == 0) goto L_0x0117
            r1.close()     // Catch:{ Throwable -> 0x010f }
            goto L_0x0117
        L_0x010f:
            r10 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r10, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0117:
            if (r2 == 0) goto L_0x011c
            r2.close()     // Catch:{ Throwable -> 0x00b5 }
        L_0x011c:
            boolean r10 = f3376g
            if (r10 == 0) goto L_0x0125
            java.lang.String r10 = m3883b()
            return r10
        L_0x0125:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ErrorLogManager.m3875a(java.util.List):java.lang.String");
    }

    /* renamed from: a */
    static void m3877a(Context context) {
        String a;
        List<SDKInfo> b = C1108h.m3853b(context);
        if (b != null && b.size() != 0 && (a = m3875a(b)) != null && !"".equals(a) && f3378i != null) {
            m3879a(context, f3378i, 2, "ANR", a);
        }
    }

    /* renamed from: a */
    private static void m3878a(final Context context, final UpdateStrategy bkVar, final String str) {
        SDKLogHandler.m3869d().submit(new Runnable() {
            public final void run() {
                try {
                    synchronized (ErrorLogManager.class) {
                        LogConfig a = C1059ax.m3069a(ErrorLogManager.f3370a);
                        C1059ax.m3071a(context, a, str, 1000, 40960, "1");
                        a.f2596f = bkVar;
                        if (a.f2597g == null) {
                            a.f2597g = new LogJsonDataStrategy(new HeaderAddStrategy(context, new ZipUpdateDataStrategy(), new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", AppInfo.m3666f(context), DeviceInfo.m3733v(context), AppInfo.m3663c(context), Build.MODEL, AppInfo.m3661b(context), AppInfo.m3664d(context), Build.VERSION.RELEASE));
                        }
                        a.f2598h = 3600000;
                        LogEngine.m3049a(a);
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m3867b(th, "lg", "pul");
                }
            }
        });
    }

    /* renamed from: a */
    private static void m3879a(Context context, SDKInfo diVar, int i, String str, String str2) {
        String str3;
        String a = C1107dj.m3805a(System.currentTimeMillis());
        String a2 = C1059ax.m3070a(context, diVar);
        AppInfo.m3657a(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a2);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(a);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !"".equals(stringBuffer2)) {
            String c = MD5.m3763c(str2);
            if (i == 1) {
                str3 = C1108h.f3348b;
            } else if (i == 2) {
                str3 = C1108h.f3350d;
            } else if (i == 0) {
                str3 = C1108h.f3349c;
            } else {
                return;
            }
            String str4 = str3;
            LogConfig a3 = C1059ax.m3069a(f3370a);
            C1059ax.m3071a(context, a3, str4, 1000, 40960, "1");
            if (a3.f2595e == null) {
                a3.f2595e = new ADDNumEncryptProcessor(new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())));
            }
            try {
                LogEngine.m3050a(c, C1107dj.m3818a(stringBuffer2.replaceAll("\n", "<br/>")), a3);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m3880a(Context context, Throwable th, int i, String str, String str2) {
        String a = C1107dj.m3808a(th);
        SDKInfo a2 = m3874a(context, a);
        if (m3882a(a2)) {
            String replaceAll = a.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                m3879a(context, a2, i, th2, sb.toString());
            }
        }
    }

    /* renamed from: a */
    static void m3881a(SDKInfo diVar, Context context, String str, String str2) {
        if (m3882a(diVar) && str != null && !"".equals(str)) {
            m3879a(context, diVar, 1, str, str2);
        }
    }

    /* renamed from: a */
    private static boolean m3882a(SDKInfo diVar) {
        return diVar != null && diVar.mo13277e();
    }

    /* renamed from: b */
    private static String m3883b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = f3375f;
            while (i < 10 && i <= 9) {
                sb.append(f3374e[i]);
                i++;
            }
            for (int i2 = 0; i2 < f3375f; i2++) {
                sb.append(f3374e[i2]);
            }
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* renamed from: b */
    static void m3884b(Context context) {
        SwitchUpdateStrategy biVar = new SwitchUpdateStrategy(f3371b);
        f3371b = false;
        m3878a(context, biVar, C1108h.f3349c);
    }

    /* renamed from: c */
    static void m3885c(Context context) {
        if (f3372c == null || f3372c.get() == null) {
            f3372c = new WeakReference<>(new TimeUpdateStrategy(context, 3600000, "hKey", new WiFiUplateStrategy(context)));
        }
        m3878a(context, (UpdateStrategy) f3372c.get(), C1108h.f3350d);
    }

    /* renamed from: d */
    static void m3886d(Context context) {
        if (f3373d == null || f3373d.get() == null) {
            f3373d = new WeakReference<>(new TimeUpdateStrategy(context, 3600000, "gKey", new WiFiUplateStrategy(context)));
        }
        m3878a(context, (UpdateStrategy) f3373d.get(), C1108h.f3348b);
    }
}
