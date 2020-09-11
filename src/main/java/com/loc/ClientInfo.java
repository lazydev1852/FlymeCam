package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.io.ByteArrayOutputStream;

/* renamed from: com.loc.da */
public final class ClientInfo {

    /* renamed from: com.loc.da$a */
    /* compiled from: ClientInfo */
    private static class C1100a {

        /* renamed from: a */
        String f3244a;

        /* renamed from: b */
        String f3245b;

        /* renamed from: c */
        String f3246c;

        /* renamed from: d */
        String f3247d;

        /* renamed from: e */
        String f3248e;

        /* renamed from: f */
        String f3249f;

        /* renamed from: g */
        String f3250g;

        /* renamed from: h */
        String f3251h;

        /* renamed from: i */
        String f3252i;

        /* renamed from: j */
        String f3253j;

        /* renamed from: k */
        String f3254k;

        /* renamed from: l */
        String f3255l;

        /* renamed from: m */
        String f3256m;

        /* renamed from: n */
        String f3257n;

        /* renamed from: o */
        String f3258o;

        /* renamed from: p */
        String f3259p;

        /* renamed from: q */
        String f3260q;

        /* renamed from: r */
        String f3261r;

        /* renamed from: s */
        String f3262s;

        /* renamed from: t */
        String f3263t;

        /* renamed from: u */
        String f3264u;

        /* renamed from: v */
        String f3265v;

        /* renamed from: w */
        String f3266w;

        /* renamed from: x */
        String f3267x;

        /* renamed from: y */
        String f3268y;

        private C1100a() {
        }

        /* synthetic */ C1100a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static String m3686a() {
        String str;
        Throwable th;
        try {
            str = String.valueOf(System.currentTimeMillis());
            String str2 = "1";
            try {
                if (!AppInfo.m3660a()) {
                    str2 = "0";
                }
                int length = str.length();
                return str.substring(0, length - 2) + str2 + str.substring(length - 1);
            } catch (Throwable th2) {
                th = th2;
                BasicLogHandler.m3844a(th, "CI", "TS");
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = null;
            th = th4;
            BasicLogHandler.m3844a(th, "CI", "TS");
            return str;
        }
    }

    /* renamed from: a */
    public static String m3687a(Context context, String str, String str2) {
        try {
            String e = AppInfo.m3665e(context);
            return MD5.m3762b(e + SystemInfoUtil.COLON + str.substring(0, str.length() - 3) + SystemInfoUtil.COLON + str2);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "CI", "Sco");
            return null;
        }
    }

    /* renamed from: a */
    private static void m3688a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            C1107dj.m3813a(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, C1107dj.m3818a(str));
        } else {
            C1107dj.m3813a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* renamed from: a */
    public static byte[] m3689a(Context context, boolean z) {
        String str;
        try {
            C1100a aVar = new C1100a((byte) 0);
            aVar.f3244a = DeviceInfo.m3733v(context);
            aVar.f3245b = DeviceInfo.m3724m(context);
            String h = DeviceInfo.m3719h(context);
            if (h == null) {
                h = "";
            }
            aVar.f3246c = h;
            aVar.f3247d = AppInfo.m3663c(context);
            aVar.f3248e = Build.MODEL;
            aVar.f3249f = Build.MANUFACTURER;
            aVar.f3250g = Build.DEVICE;
            aVar.f3251h = AppInfo.m3661b(context);
            aVar.f3252i = AppInfo.m3664d(context);
            aVar.f3253j = String.valueOf(Build.VERSION.SDK_INT);
            aVar.f3254k = DeviceInfo.m3735x(context);
            aVar.f3255l = DeviceInfo.m3732u(context);
            StringBuilder sb = new StringBuilder();
            sb.append(DeviceInfo.m3729r(context));
            aVar.f3256m = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DeviceInfo.m3728q(context));
            aVar.f3257n = sb2.toString();
            aVar.f3258o = DeviceInfo.m3737z(context);
            aVar.f3259p = DeviceInfo.m3727p(context);
            aVar.f3260q = z ? "" : DeviceInfo.m3723l(context);
            aVar.f3261r = z ? "" : DeviceInfo.m3722k(context);
            if (z) {
                aVar.f3262s = "";
                str = "";
            } else {
                String[] n = DeviceInfo.m3725n(context);
                aVar.f3262s = n[0];
                str = n[1];
            }
            aVar.f3263t = str;
            aVar.f3266w = DeviceInfo.m3703a();
            String b = DeviceInfo.m3708b(context);
            if (TextUtils.isEmpty(b)) {
                b = "";
            }
            aVar.f3267x = b;
            aVar.f3268y = "aid=" + DeviceInfo.m3721j(context) + "|serial=" + DeviceInfo.m3720i(context) + "|storage=" + DeviceInfo.m3711c() + "|ram=" + DeviceInfo.m3736y(context) + "|arch=" + DeviceInfo.m3713d();
            String a = DeviceInfo.m3704a(context);
            if (!TextUtils.isEmpty(a)) {
                aVar.f3268y += "|adiuExtras=" + a;
            }
            String a2 = DeviceInfo.m3705a(context, SystemInfoUtil.COMMA);
            if (!TextUtils.isEmpty(a2)) {
                aVar.f3268y += "|multiImeis=" + a2;
            }
            String w = DeviceInfo.m3734w(context);
            if (!TextUtils.isEmpty(w)) {
                aVar.f3268y += "|meid=" + w;
            }
            return m3690a(aVar);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "CI", "gz");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cb A[SYNTHETIC, Splitter:B:22:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d7 A[SYNTHETIC, Splitter:B:29:0x00d7] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m3690a(com.loc.ClientInfo.C1100a r7) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
            r1.<init>()     // Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
            java.lang.String r2 = r7.f3244a     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3245b     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3246c     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3247d     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3248e     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3249f     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3250g     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3251h     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3252i     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3253j     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3254k     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3255l     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3256m     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3257n     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3258o     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3259p     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3260q     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3261r     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3262s     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3263t     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3264u     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3265v     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3266w     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r7.f3267x     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r7 = r7.f3268y     // Catch:{ Throwable -> 0x00bb }
            m3688a((java.io.ByteArrayOutputStream) r1, (java.lang.String) r7)     // Catch:{ Throwable -> 0x00bb }
            byte[] r7 = r1.toByteArray()     // Catch:{ Throwable -> 0x00bb }
            byte[] r7 = com.loc.C1107dj.m3823b((byte[]) r7)     // Catch:{ Throwable -> 0x00bb }
            java.security.PublicKey r2 = com.loc.C1107dj.m3828d()     // Catch:{ Throwable -> 0x00bb }
            int r3 = r7.length     // Catch:{ Throwable -> 0x00bb }
            r4 = 117(0x75, float:1.64E-43)
            if (r3 <= r4) goto L_0x00ae
            byte[] r3 = new byte[r4]     // Catch:{ Throwable -> 0x00bb }
            r5 = 0
            java.lang.System.arraycopy(r7, r5, r3, r5, r4)     // Catch:{ Throwable -> 0x00bb }
            byte[] r2 = com.loc.C1102dd.m3740a((byte[]) r3, (java.security.Key) r2)     // Catch:{ Throwable -> 0x00bb }
            int r3 = r7.length     // Catch:{ Throwable -> 0x00bb }
            r6 = 128(0x80, float:1.794E-43)
            int r3 = r3 + r6
            int r3 = r3 - r4
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x00bb }
            java.lang.System.arraycopy(r2, r5, r3, r5, r6)     // Catch:{ Throwable -> 0x00bb }
            int r2 = r7.length     // Catch:{ Throwable -> 0x00bb }
            int r2 = r2 - r4
            java.lang.System.arraycopy(r7, r4, r3, r6, r2)     // Catch:{ Throwable -> 0x00bb }
            goto L_0x00b2
        L_0x00ae:
            byte[] r3 = com.loc.C1102dd.m3740a((byte[]) r7, (java.security.Key) r2)     // Catch:{ Throwable -> 0x00bb }
        L_0x00b2:
            r1.close()     // Catch:{ Throwable -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ba:
            return r3
        L_0x00bb:
            r7 = move-exception
            goto L_0x00c2
        L_0x00bd:
            r7 = move-exception
            r1 = r0
            goto L_0x00d5
        L_0x00c0:
            r7 = move-exception
            r1 = r0
        L_0x00c2:
            java.lang.String r2 = "CI"
            java.lang.String r3 = "gzx"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r7, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x00d3
            r1.close()     // Catch:{ Throwable -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00d3:
            return r0
        L_0x00d4:
            r7 = move-exception
        L_0x00d5:
            if (r1 == 0) goto L_0x00df
            r1.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00df:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ClientInfo.m3690a(com.loc.da$a):byte[]");
    }
}
