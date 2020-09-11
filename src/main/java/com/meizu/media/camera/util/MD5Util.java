package com.meizu.media.camera.util;

import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Arrays;
import java.util.Map;
import org.apaches.commons.codec.digest.DigestUtils;

/* renamed from: com.meizu.media.camera.util.ae */
public class MD5Util {

    /* renamed from: a */
    public static ChangeQuickRedirect f14084a;

    /* renamed from: b */
    private static LogUtil.C2630a f14085b = new LogUtil.C2630a("MD5Util");

    /* renamed from: a */
    public static String m15963a(String str, Map<String, String> map) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, map}, (Object) null, f14084a, true, 8136, new Class[]{String.class, Map.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        map.put("ks", str);
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
        String md5Hex = DigestUtils.md5Hex(sb.toString());
        map.remove("ks");
        return md5Hex;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089 A[SYNTHETIC, Splitter:B:26:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e A[SYNTHETIC, Splitter:B:33:0x009e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m15962a(java.io.File r15) {
        /*
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r15
            com.meizu.savior.ChangeQuickRedirect r3 = f14084a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.io.File> r2 = java.io.File.class
            r6[r8] = r2
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r2 = 0
            r4 = 1
            r5 = 8137(0x1fc9, float:1.1402E-41)
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0021
            java.lang.Object r15 = r1.result
            java.lang.String r15 = (java.lang.String) r15
            return r15
        L_0x0021:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007d }
            r3.<init>(r15)     // Catch:{ Exception -> 0x007d }
            java.nio.channels.FileChannel r9 = r3.getChannel()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            java.nio.channels.FileChannel$MapMode r10 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            r11 = 0
            long r13 = r15.length()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            java.nio.MappedByteBuffer r15 = r9.map(r10, r11, r13)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            r2.update(r15)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            byte[] r15 = r2.digest()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            int r2 = r15.length     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
        L_0x004a:
            if (r8 >= r2) goto L_0x0071
            byte r4 = r15[r8]     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            if (r5 != r0) goto L_0x006b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            r5.<init>()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            java.lang.String r6 = "0"
            r5.append(r6)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            r5.append(r4)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
        L_0x006b:
            r1.append(r4)     // Catch:{ Exception -> 0x0077, all -> 0x0075 }
            int r8 = r8 + 1
            goto L_0x004a
        L_0x0071:
            r3.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0097
        L_0x0075:
            r15 = move-exception
            goto L_0x009c
        L_0x0077:
            r15 = move-exception
            r2 = r3
            goto L_0x007e
        L_0x007a:
            r15 = move-exception
            r3 = r2
            goto L_0x009c
        L_0x007d:
            r15 = move-exception
        L_0x007e:
            com.meizu.media.camera.util.ac$a r0 = f14085b     // Catch:{ all -> 0x007a }
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x007a }
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r15)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0097
        L_0x008d:
            r15 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f14085b
            java.lang.String r15 = r15.getMessage()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r15)
        L_0x0097:
            java.lang.String r15 = r1.toString()
            return r15
        L_0x009c:
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00ac
        L_0x00a2:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f14085b
            java.lang.String r0 = r0.getMessage()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r0)
        L_0x00ac:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.MD5Util.m15962a(java.io.File):java.lang.String");
    }
}
