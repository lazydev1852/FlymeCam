package com.meizu.update.util;

import java.io.InputStream;
import java.security.MessageDigest;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.meizu.update.util.f */
public class Md5Helper {

    /* renamed from: a */
    private static final char[] f16361a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0019 A[SYNTHETIC, Splitter:B:16:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0021 A[SYNTHETIC, Splitter:B:23:0x0021] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m17945a(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0012, all -> 0x0010 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0012, all -> 0x0010 }
            java.lang.String r2 = m17944a((java.io.InputStream) r1)     // Catch:{ IOException -> 0x000e }
            r1.close()     // Catch:{ IOException -> 0x000d }
        L_0x000d:
            return r2
        L_0x000e:
            r2 = move-exception
            goto L_0x0014
        L_0x0010:
            r2 = move-exception
            goto L_0x001f
        L_0x0012:
            r2 = move-exception
            r1 = r0
        L_0x0014:
            r2.printStackTrace()     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x001c
            r1.close()     // Catch:{ IOException -> 0x001c }
        L_0x001c:
            return r0
        L_0x001d:
            r2 = move-exception
            r0 = r1
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.Md5Helper.m17945a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m17944a(InputStream inputStream) {
        try {
            byte[] bArr = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return m17947a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m17947a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = f16361a[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = f16361a[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a1 A[SYNTHETIC, Splitter:B:47:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8 A[SYNTHETIC, Splitter:B:53:0x00a8] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m17946a(java.lang.String r10, int r11) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            long r1 = r1.length()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            int r3 = r11 * 2
            long r3 = (long) r3     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0026
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r10.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r11 = "md5sumHeadTail file length is: "
            r10.append(r11)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r10.append(r1)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            com.meizu.update.util.Loger.m17943d(r10)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            return r0
        L_0x0026:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r6 = 0
            r7 = 0
        L_0x0037:
            if (r7 >= r11) goto L_0x004a
            int r8 = r11 - r7
            int r9 = r4.length     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r8 <= r9) goto L_0x003f
            int r8 = r4.length     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
        L_0x003f:
            int r8 = r3.read(r4, r6, r8)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r8 <= 0) goto L_0x004a
            r5.update(r4, r6, r8)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            int r7 = r7 + r8
            goto L_0x0037
        L_0x004a:
            r3.close()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            long r10 = (long) r11
            long r1 = r1 - r10
        L_0x0054:
            r10 = 0
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x007b
            long r8 = r7.skip(r1)     // Catch:{ Exception -> 0x0079 }
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0064
            long r1 = r1 - r8
            goto L_0x0054
        L_0x0064:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079 }
            r10.<init>()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r11 = "skip file return: "
            r10.append(r11)     // Catch:{ Exception -> 0x0079 }
            r10.append(r8)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0079 }
            com.meizu.update.util.Loger.m17943d(r10)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0054
        L_0x0079:
            r10 = move-exception
            goto L_0x009c
        L_0x007b:
            int r10 = r7.read(r4)     // Catch:{ Exception -> 0x0079 }
            if (r10 <= 0) goto L_0x0085
            r5.update(r4, r6, r10)     // Catch:{ Exception -> 0x0079 }
            goto L_0x007b
        L_0x0085:
            byte[] r10 = r5.digest()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r10 = m17947a((byte[]) r10)     // Catch:{ Exception -> 0x0079 }
            r7.close()     // Catch:{ IOException -> 0x0090 }
        L_0x0090:
            return r10
        L_0x0091:
            r10 = move-exception
            r7 = r3
            goto L_0x00a6
        L_0x0094:
            r10 = move-exception
            r7 = r3
            goto L_0x009c
        L_0x0097:
            r10 = move-exception
            r7 = r0
            goto L_0x00a6
        L_0x009a:
            r10 = move-exception
            r7 = r0
        L_0x009c:
            r10.printStackTrace()     // Catch:{ all -> 0x00a5 }
            if (r7 == 0) goto L_0x00a4
            r7.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            return r0
        L_0x00a5:
            r10 = move-exception
        L_0x00a6:
            if (r7 == 0) goto L_0x00ab
            r7.close()     // Catch:{ IOException -> 0x00ab }
        L_0x00ab:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.Md5Helper.m17946a(java.lang.String, int):java.lang.String");
    }
}
