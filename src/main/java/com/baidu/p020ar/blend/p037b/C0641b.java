package com.baidu.p020ar.blend.p037b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.baidu.ar.blend.b.b */
public class C0641b {
    /* renamed from: a */
    public static String m1452a(InputStream inputStream) {
        return m1453a(inputStream, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        r7 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0016] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:7:0x0016] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0065=Splitter:B:37:0x0065, B:33:0x005c=Splitter:B:33:0x005c} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1453a(java.io.InputStream r6, java.lang.String r7) {
        /*
            if (r6 == 0) goto L_0x006a
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0010
            java.lang.String r7 = "file.encoding"
            java.lang.String r0 = "utf-8"
            java.lang.String r7 = java.lang.System.getProperty(r7, r0)
        L_0x0010:
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0064, NullPointerException -> 0x005a }
            r1.<init>(r6, r7)     // Catch:{ IOException -> 0x0064, NullPointerException -> 0x005a }
            java.io.StringWriter r6 = new java.io.StringWriter     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
            r6.<init>()     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
            r2 = 4096(0x1000, float:5.74E-42)
            char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
        L_0x001f:
            int r3 = r1.read(r2)     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
            if (r3 <= 0) goto L_0x002a
            r4 = 0
            r6.write(r2, r4, r3)     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
            goto L_0x001f
        L_0x002a:
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0050, all -> 0x004e }
            java.lang.String r0 = "utf-8"
            boolean r7 = r0.equalsIgnoreCase(r7)     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0048, all -> 0x004e }
            if (r7 == 0) goto L_0x0044
            java.lang.String r7 = "﻿"
            boolean r7 = r6.startsWith(r7)     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0048, all -> 0x004e }
            if (r7 == 0) goto L_0x0044
            r7 = 1
            java.lang.String r7 = r6.substring(r7)     // Catch:{ IOException -> 0x0054, NullPointerException -> 0x0048, all -> 0x004e }
            r6 = r7
        L_0x0044:
            m1454a((java.io.Closeable) r1)
            goto L_0x0063
        L_0x0048:
            r7 = move-exception
            r0 = r1
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x005c
        L_0x004e:
            r6 = move-exception
            goto L_0x0066
        L_0x0050:
            r6 = move-exception
            r7 = r0
            r0 = r1
            goto L_0x005c
        L_0x0054:
            r6 = move-exception
            r0 = r1
            goto L_0x0065
        L_0x0057:
            r6 = move-exception
            r1 = r0
            goto L_0x0066
        L_0x005a:
            r6 = move-exception
            r7 = r0
        L_0x005c:
            r6.printStackTrace()     // Catch:{ all -> 0x0057 }
            m1454a((java.io.Closeable) r0)
            r6 = r7
        L_0x0063:
            return r6
        L_0x0064:
            r6 = move-exception
        L_0x0065:
            throw r6     // Catch:{ all -> 0x0057 }
        L_0x0066:
            m1454a((java.io.Closeable) r1)
            throw r6
        L_0x006a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "stream may not be null."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.p037b.C0641b.m1453a(java.io.InputStream, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m1454a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
