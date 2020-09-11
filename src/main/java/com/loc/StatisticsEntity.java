package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.loc.av */
public final class StatisticsEntity {

    /* renamed from: a */
    private Context f2613a;

    /* renamed from: b */
    private String f2614b;

    /* renamed from: c */
    private String f2615c;

    /* renamed from: d */
    private String f2616d;

    /* renamed from: e */
    private String f2617e;

    public StatisticsEntity(Context context, String str, String str2, String str3) throws AMapCoreException {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new AMapCoreException("无效的参数 - IllegalArgumentException");
        }
        this.f2613a = context.getApplicationContext();
        this.f2615c = str;
        this.f2616d = str2;
        this.f2614b = str3;
    }

    /* renamed from: a */
    public final void mo13034a(String str) throws AMapCoreException {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new AMapCoreException("无效的参数 - IllegalArgumentException");
        }
        this.f2617e = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b3, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[SYNTHETIC, Splitter:B:34:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae A[SYNTHETIC, Splitter:B:40:0x00ae] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] mo13035a() {
        /*
            r8 = this;
            r0 = 0
            byte[] r1 = new byte[r0]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0098 }
            r3.<init>()     // Catch:{ Throwable -> 0x0098 }
            java.lang.String r2 = r8.f2615c     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            com.loc.C1107dj.m3814a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            java.lang.String r2 = r8.f2616d     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            com.loc.C1107dj.m3814a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            java.lang.String r2 = r8.f2614b     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            com.loc.C1107dj.m3814a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            android.content.Context r2 = r8.f2613a     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r2 = com.loc.DeviceInfo.m3729r(r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            com.loc.C1107dj.m3814a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x002e, all -> 0x0090 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            int r2 = (int) r4
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r4 = 4
            byte[] r4 = new byte[r4]     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r5 = r2 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r4[r0] = r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r5 = r2 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r6 = 1
            r4[r6] = r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r5 = r2 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r7 = 2
            r4[r7] = r5     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r5 = 3
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r4[r5] = r2     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r3.write(r4)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            java.lang.String r2 = r8.f2617e     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            if (r2 == 0) goto L_0x0060
        L_0x005a:
            byte[] r0 = new byte[r7]     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r0 = {0, 0} // fill-array     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            goto L_0x0077
        L_0x0060:
            java.lang.String r2 = r8.f2617e     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            byte[] r2 = com.loc.C1107dj.m3818a((java.lang.String) r2)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            if (r2 != 0) goto L_0x0069
            goto L_0x005a
        L_0x0069:
            int r2 = r2.length     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r4 = r2 / 256
            byte r4 = (byte) r4     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            int r2 = r2 % 256
            byte r2 = (byte) r2     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            byte[] r5 = new byte[r7]     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r5[r0] = r4     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r5[r6] = r2     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r0 = r5
        L_0x0077:
            r3.write(r0)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            java.lang.String r0 = r8.f2617e     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            byte[] r0 = com.loc.C1107dj.m3818a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r3.write(r0)     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            byte[] r0 = r3.toByteArray()     // Catch:{ Throwable -> 0x0092, all -> 0x0090 }
            r3.close()     // Catch:{ Throwable -> 0x008b }
            goto L_0x00ab
        L_0x008b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x00ab
        L_0x0090:
            r0 = move-exception
            goto L_0x00ac
        L_0x0092:
            r0 = move-exception
            r2 = r3
            goto L_0x0099
        L_0x0095:
            r0 = move-exception
            r3 = r2
            goto L_0x00ac
        L_0x0098:
            r0 = move-exception
        L_0x0099:
            java.lang.String r3 = "se"
            java.lang.String r4 = "tds"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x00aa
            r2.close()     // Catch:{ Throwable -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00aa:
            r0 = r1
        L_0x00ab:
            return r0
        L_0x00ac:
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ Throwable -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.StatisticsEntity.mo13035a():byte[]");
    }
}
