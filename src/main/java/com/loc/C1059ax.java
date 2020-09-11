package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.loc.ax */
/* compiled from: Utils */
public final class C1059ax {
    /* renamed from: a */
    public static LogConfig m3069a(WeakReference<LogConfig> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new LogConfig());
        }
        return (LogConfig) weakReference.get();
    }

    /* renamed from: a */
    public static String m3070a(Context context, SDKInfo diVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = DeviceInfo.m3718g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(diVar.mo13275c());
            sb.append("\",\"product\":\"");
            sb.append(diVar.mo13272a());
            sb.append("\",\"ed\":\"");
            sb.append(diVar.mo13276d());
            sb.append("\",\"nt\":\"");
            sb.append(DeviceInfo.m3715e(context));
            sb.append("\",\"np\":\"");
            sb.append(DeviceInfo.m3712c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(DeviceInfo.m3714d(context));
            sb.append("\",\"ant\":\"");
            sb.append(DeviceInfo.m3717f(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m3071a(Context context, LogConfig aqVar, String str, int i, int i2, String str2) {
        aqVar.f2591a = C1108h.m3856c(context, str);
        aqVar.f2594d = i;
        aqVar.f2592b = (long) i2;
        aqVar.f2593c = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x006e A[SYNTHETIC, Splitter:B:54:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0078 A[SYNTHETIC, Splitter:B:59:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0084 A[SYNTHETIC, Splitter:B:66:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x008e A[SYNTHETIC, Splitter:B:71:0x008e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] m3072a(com.loc.DiskLruCache r5, java.lang.String r6) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            r1 = 0
            com.loc.ad$b r5 = r5.mo12971a((java.lang.String) r6)     // Catch:{ Throwable -> 0x0061, all -> 0x005d }
            if (r5 != 0) goto L_0x0015
            if (r5 == 0) goto L_0x0014
            r5.close()     // Catch:{ Throwable -> 0x0010 }
            goto L_0x0014
        L_0x0010:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0014:
            return r0
        L_0x0015:
            java.io.InputStream r6 = r5.mo12989a()     // Catch:{ Throwable -> 0x0058, all -> 0x0055 }
            if (r6 != 0) goto L_0x0030
            if (r6 == 0) goto L_0x0025
            r6.close()     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0025:
            if (r5 == 0) goto L_0x002f
            r5.close()     // Catch:{ Throwable -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            int r1 = r6.available()     // Catch:{ Throwable -> 0x0053 }
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x0053 }
            r6.read(r1)     // Catch:{ Throwable -> 0x004e }
            if (r6 == 0) goto L_0x0043
            r6.close()     // Catch:{ Throwable -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0043:
            if (r5 == 0) goto L_0x004d
            r5.close()     // Catch:{ Throwable -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004d:
            return r1
        L_0x004e:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0065
        L_0x0053:
            r1 = move-exception
            goto L_0x0065
        L_0x0055:
            r0 = move-exception
            r6 = r1
            goto L_0x0082
        L_0x0058:
            r6 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x0065
        L_0x005d:
            r0 = move-exception
            r5 = r1
            r6 = r5
            goto L_0x0082
        L_0x0061:
            r5 = move-exception
            r6 = r1
            r1 = r5
            r5 = r6
        L_0x0065:
            java.lang.String r2 = "sui"
            java.lang.String r3 = "rdS"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0081 }
            if (r6 == 0) goto L_0x0076
            r6.close()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0076:
            if (r5 == 0) goto L_0x0080
            r5.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0080:
            return r0
        L_0x0081:
            r0 = move-exception
        L_0x0082:
            if (r6 == 0) goto L_0x008c
            r6.close()     // Catch:{ Throwable -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008c:
            if (r5 == 0) goto L_0x0096
            r5.close()     // Catch:{ Throwable -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0096:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1059ax.m3072a(com.loc.ad, java.lang.String):byte[]");
    }
}
