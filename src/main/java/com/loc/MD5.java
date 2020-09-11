package com.loc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.loc.df */
public final class MD5 {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a A[SYNTHETIC, Splitter:B:30:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006b A[SYNTHETIC, Splitter:B:38:0x006b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3759a(java.lang.String r5) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            if (r1 == 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            boolean r5 = r1.isFile()     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            if (r5 == 0) goto L_0x004c
            boolean r5 = r1.exists()     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            if (r5 != 0) goto L_0x001a
            goto L_0x004c
        L_0x001a:
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x004f, all -> 0x004d }
        L_0x0029:
            int r1 = r3.read(r5)     // Catch:{ Throwable -> 0x004a }
            r4 = -1
            if (r1 == r4) goto L_0x0035
            r4 = 0
            r2.update(r5, r4, r1)     // Catch:{ Throwable -> 0x004a }
            goto L_0x0029
        L_0x0035:
            byte[] r5 = r2.digest()     // Catch:{ Throwable -> 0x004a }
            java.lang.String r5 = com.loc.C1107dj.m3830e((byte[]) r5)     // Catch:{ Throwable -> 0x004a }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0049
        L_0x0041:
            r0 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "gfm"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0049:
            return r5
        L_0x004a:
            r5 = move-exception
            goto L_0x0051
        L_0x004c:
            return r0
        L_0x004d:
            r5 = move-exception
            goto L_0x0069
        L_0x004f:
            r5 = move-exception
            r3 = r0
        L_0x0051:
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "gfm"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0066
        L_0x005e:
            r5 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "gfm"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0066:
            return r0
        L_0x0067:
            r5 = move-exception
            r0 = r3
        L_0x0069:
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0077
        L_0x006f:
            r0 = move-exception
            java.lang.String r1 = "MD5"
            java.lang.String r2 = "gfm"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0077:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.MD5.m3759a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m3760a(byte[] bArr) {
        return C1107dj.m3830e(m3761a(bArr, MessageDigestAlgorithms.MD5));
    }

    /* renamed from: a */
    public static byte[] m3761a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, MessageDigestAlgorithms.MD5, "gmb");
            return null;
        }
    }

    /* renamed from: b */
    public static String m3762b(String str) {
        if (str == null) {
            return null;
        }
        return C1107dj.m3830e(m3764d(str));
    }

    /* renamed from: c */
    public static String m3763c(String str) {
        return C1107dj.m3832f(m3765e(str));
    }

    /* renamed from: d */
    private static byte[] m3764d(String str) {
        try {
            return m3766f(str);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, MessageDigestAlgorithms.MD5, "gmb");
            return new byte[0];
        }
    }

    /* renamed from: e */
    private static byte[] m3765e(String str) {
        try {
            return m3766f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: f */
    private static byte[] m3766f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        instance.update(C1107dj.m3818a(str));
        return instance.digest();
    }
}
