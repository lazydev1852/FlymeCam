package com.meizu.update.util;

import android.content.Context;
import android.util.Log;

/* renamed from: com.meizu.update.util.e */
public class Loger {
    /* renamed from: a */
    public static final void m17939a(String str) {
    }

    /* renamed from: b */
    public static final void m17941b(String str) {
        Log.d("MzUpdateComponent:4.1.0", str);
    }

    /* renamed from: c */
    public static final void m17942c(String str) {
        Log.w("MzUpdateComponent:4.1.0", str);
    }

    /* renamed from: d */
    public static final void m17943d(String str) {
        Log.e("MzUpdateComponent:4.1.0", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f7 A[Catch:{ IOException -> 0x0100, Exception -> 0x00fb }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m17938a(android.content.Context r14, java.lang.String r15) {
        /*
            m17942c(r15)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r0.<init>()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r0.append(r1)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r1 = "/Android/data/"
            r0.append(r1)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r0.append(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r14 = "/"
            r0.append(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r14 = r0.toString()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r0.<init>(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            boolean r1 = r0.exists()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            if (r1 == 0) goto L_0x0039
            boolean r1 = r0.isDirectory()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            if (r1 != 0) goto L_0x003c
        L_0x0039:
            r0.mkdir()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
        L_0x003c:
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r1.<init>()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r1.append(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r14 = "update_component_log"
            r1.append(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r14 = r1.toString()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r0.<init>(r14)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            boolean r14 = r0.exists()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r1 = 0
            r2 = 1
            if (r14 != 0) goto L_0x0061
            boolean r14 = r0.createNewFile()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            if (r14 != 0) goto L_0x006d
            return
        L_0x0061:
            long r3 = r0.length()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r5 = 16384(0x4000, double:8.0948E-320)
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x006d
            r14 = 0
            goto L_0x006e
        L_0x006d:
            r14 = 1
        L_0x006e:
            java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            int r4 = r3.get(r2)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r5 = 2
            int r6 = r3.get(r5)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            int r6 = r6 + r2
            r7 = 5
            int r8 = r3.get(r7)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r9 = 11
            int r9 = r3.get(r9)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r10 = 12
            int r10 = r3.get(r10)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r11 = 13
            int r3 = r3.get(r11)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.StringBuffer r11 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r11.<init>()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r12 = "["
            r11.append(r12)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r12 = "%04d-%02d-%02d %02d:%02d:%02d"
            r13 = 6
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r1] = r4     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r2] = r1     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r5] = r1     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r1 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r1] = r2     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r1 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r1] = r2     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r13[r7] = r1     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r1 = java.lang.String.format(r12, r13)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r11.append(r1)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r1 = "]"
            r11.append(r1)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r11.append(r15)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            java.lang.String r15 = "\n"
            r11.append(r15)     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            r15 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x00f3 }
            r1.<init>(r0, r14)     // Catch:{ all -> 0x00f3 }
            java.lang.String r14 = r11.toString()     // Catch:{ all -> 0x00f1 }
            byte[] r14 = r14.getBytes()     // Catch:{ all -> 0x00f1 }
            r1.write(r14)     // Catch:{ all -> 0x00f1 }
            r1.close()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
            goto L_0x0104
        L_0x00f1:
            r14 = move-exception
            goto L_0x00f5
        L_0x00f3:
            r14 = move-exception
            r1 = r15
        L_0x00f5:
            if (r1 == 0) goto L_0x00fa
            r1.close()     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
        L_0x00fa:
            throw r14     // Catch:{ IOException -> 0x0100, Exception -> 0x00fb }
        L_0x00fb:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x0104
        L_0x0100:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.Loger.m17938a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: b */
    public static void m17940b(final Context context, final String str) {
        new Thread(new Runnable() {
            public void run() {
                Loger.m17938a(context, str);
            }
        }).start();
    }
}
