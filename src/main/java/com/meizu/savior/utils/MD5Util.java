package com.meizu.savior.utils;

import android.content.Context;
import java.util.Arrays;
import java.util.Map;
import org.p113a.p114a.p115a.p117b.C3573a;

public class MD5Util {
    private static final String PARAM_KEY_STORE = "ks";

    static {
        System.loadLibrary("secret");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[SYNTHETIC, Splitter:B:23:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072 A[SYNTHETIC, Splitter:B:29:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMD5FromFile(java.io.File r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005e }
            r2.<init>(r9)     // Catch:{ Exception -> 0x005e }
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.nio.channels.FileChannel$MapMode r4 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r5 = 0
            long r7 = r9.length()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.nio.MappedByteBuffer r9 = r3.map(r4, r5, r7)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r1.update(r9)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            byte[] r9 = r1.digest()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            int r1 = r9.length     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r3 = 0
        L_0x002a:
            if (r3 >= r1) goto L_0x0052
            byte r4 = r9[r3]     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r6 = 1
            if (r5 != r6) goto L_0x004c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r5.<init>()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r6 = "0"
            r5.append(r6)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            r5.append(r4)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
        L_0x004c:
            r0.append(r4)     // Catch:{ Exception -> 0x0058, all -> 0x0056 }
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0052:
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006b
        L_0x0056:
            r9 = move-exception
            goto L_0x0070
        L_0x0058:
            r9 = move-exception
            r1 = r2
            goto L_0x005f
        L_0x005b:
            r9 = move-exception
            r2 = r1
            goto L_0x0070
        L_0x005e:
            r9 = move-exception
        L_0x005f:
            java.lang.String r2 = "savior"
            java.lang.String r3 = "getMD5FromFile error! "
            android.util.Log.e(r2, r3, r9)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            java.lang.String r9 = r0.toString()
            return r9
        L_0x0070:
            if (r2 == 0) goto L_0x0075
            r2.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.savior.utils.MD5Util.getMD5FromFile(java.io.File):java.lang.String");
    }

    public static native String getSecretKey(Context context);

    public static String sortAndSign(String str, Map<String, String> map) {
        map.put(PARAM_KEY_STORE, str);
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (map.get(str2) != null) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append("&");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        String c = C3573a.m21781c(sb.toString());
        map.remove(PARAM_KEY_STORE);
        return c;
    }
}
