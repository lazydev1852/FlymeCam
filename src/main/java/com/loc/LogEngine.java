package com.loc;

import java.io.File;
import java.util.List;

/* renamed from: com.loc.ar */
public final class LogEngine {
    /* renamed from: a */
    private static void m3048a(DiskLruCache adVar, List<String> list) {
        if (adVar != null) {
            try {
                for (String c : list) {
                    adVar.mo12976c(c);
                }
                adVar.close();
            } catch (Throwable th) {
                SDKLogHandler.m3867b(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b7, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b2 A[SYNTHETIC, Splitter:B:55:0x00b2] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3049a(com.loc.LogConfig r8) {
        /*
            r0 = 0
            com.loc.bk r1 = r8.f2596f     // Catch:{ Throwable -> 0x009d }
            boolean r1 = r1.mo13046c()     // Catch:{ Throwable -> 0x009d }
            if (r1 == 0) goto L_0x008f
            com.loc.bk r1 = r8.f2596f     // Catch:{ Throwable -> 0x009d }
            r2 = 1
            r1.mo13045a((boolean) r2)     // Catch:{ Throwable -> 0x009d }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x009d }
            java.lang.String r3 = r8.f2591a     // Catch:{ Throwable -> 0x009d }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x009d }
            long r3 = r8.f2592b     // Catch:{ Throwable -> 0x009d }
            com.loc.ad r1 = com.loc.DiskLruCache.m2938a((java.io.File) r1, (long) r3)     // Catch:{ Throwable -> 0x009d }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r3.<init>()     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            byte[] r4 = m3052a((com.loc.DiskLruCache) r1, (com.loc.LogConfig) r8, (java.util.List<java.lang.String>) r3)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            if (r4 == 0) goto L_0x007f
            int r5 = r4.length     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            if (r5 != 0) goto L_0x002b
            goto L_0x007f
        L_0x002b:
            com.loc.i r5 = new com.loc.i     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            java.lang.String r6 = r8.f2593c     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r5.<init>(r4, r6)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            com.loc.BaseNetManager.m2998a()     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            byte[] r5 = com.loc.BaseNetManager.m3001b(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            java.lang.String r7 = new java.lang.String     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r7.<init>(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r6.<init>(r7)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            java.lang.String r5 = "code"
            boolean r5 = r6.has(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            if (r5 == 0) goto L_0x007d
            java.lang.String r5 = "code"
            int r5 = r6.getInt(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            if (r5 != r2) goto L_0x007d
            com.loc.bk r2 = r8.f2596f     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            if (r2 == 0) goto L_0x005f
            if (r4 == 0) goto L_0x005f
            com.loc.bk r2 = r8.f2596f     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            int r4 = r4.length     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r2.mo13043a((int) r4)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
        L_0x005f:
            com.loc.bk r8 = r8.f2596f     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            int r8 = r8.mo13044b()     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r8 >= r2) goto L_0x006e
            m3048a((com.loc.DiskLruCache) r1, (java.util.List<java.lang.String>) r3)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            goto L_0x008f
        L_0x006e:
            if (r1 == 0) goto L_0x008f
            r1.mo12978d()     // Catch:{ Throwable -> 0x0074, all -> 0x008a }
            goto L_0x008f
        L_0x0074:
            r8 = move-exception
            java.lang.String r2 = "ofm"
            java.lang.String r3 = "dlo"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r8, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x008c, all -> 0x008a }
            goto L_0x008f
        L_0x007d:
            r0 = r1
            goto L_0x008f
        L_0x007f:
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ Throwable -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0089:
            return
        L_0x008a:
            r8 = move-exception
            goto L_0x00b0
        L_0x008c:
            r8 = move-exception
            r0 = r1
            goto L_0x009e
        L_0x008f:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ Throwable -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0099:
            return
        L_0x009a:
            r8 = move-exception
            r1 = r0
            goto L_0x00b0
        L_0x009d:
            r8 = move-exception
        L_0x009e:
            java.lang.String r1 = "leg"
            java.lang.String r2 = "uts"
            com.loc.SDKLogHandler.m3867b((java.lang.Throwable) r8, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ Throwable -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00af:
            return
        L_0x00b0:
            if (r1 == 0) goto L_0x00ba
            r1.close()     // Catch:{ Throwable -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ba:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LogEngine.m3049a(com.loc.aq):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A[SYNTHETIC, Splitter:B:29:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069 A[SYNTHETIC, Splitter:B:34:0x0069] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3050a(java.lang.String r6, byte[] r7, com.loc.LogConfig r8) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        /*
            r0 = 0
            java.lang.String r1 = r8.f2591a     // Catch:{ all -> 0x005b }
            boolean r1 = m3051a((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x000a
            return
        L_0x000a:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r8.f2591a     // Catch:{ all -> 0x005b }
            r1.<init>(r2)     // Catch:{ all -> 0x005b }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x001a
            r1.mkdirs()     // Catch:{ all -> 0x005b }
        L_0x001a:
            long r2 = r8.f2592b     // Catch:{ all -> 0x005b }
            int r4 = r8.f2594d     // Catch:{ all -> 0x005b }
            long r4 = (long) r4     // Catch:{ all -> 0x005b }
            long r2 = r2 * r4
            com.loc.ad r1 = com.loc.DiskLruCache.m2938a((java.io.File) r1, (long) r2)     // Catch:{ all -> 0x005b }
            int r2 = r8.f2594d     // Catch:{ all -> 0x0059 }
            r1.mo12972a((int) r2)     // Catch:{ all -> 0x0059 }
            com.loc.a r8 = r8.f2595e     // Catch:{ all -> 0x0059 }
            byte[] r7 = r8.mo12961a(r7)     // Catch:{ all -> 0x0059 }
            com.loc.ad$a r6 = r1.mo12973b((java.lang.String) r6)     // Catch:{ all -> 0x0059 }
            java.io.OutputStream r8 = r6.mo12982a()     // Catch:{ all -> 0x0059 }
            r8.write(r7)     // Catch:{ all -> 0x0056 }
            r6.mo12983b()     // Catch:{ all -> 0x0056 }
            r1.mo12975c()     // Catch:{ all -> 0x0056 }
            if (r8 == 0) goto L_0x004b
            r8.close()     // Catch:{ Throwable -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ Throwable -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0055:
            return
        L_0x0056:
            r6 = move-exception
            r0 = r8
            goto L_0x005d
        L_0x0059:
            r6 = move-exception
            goto L_0x005d
        L_0x005b:
            r6 = move-exception
            r1 = r0
        L_0x005d:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ Throwable -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0067:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ Throwable -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0071:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LogEngine.m3050a(java.lang.String, byte[], com.loc.aq):void");
    }

    /* renamed from: a */
    private static boolean m3051a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "leg", "fet");
            return false;
        }
    }

    /* renamed from: a */
    private static byte[] m3052a(DiskLruCache adVar, LogConfig aqVar, List<String> list) {
        try {
            File b = adVar.mo12974b();
            if (b != null && b.exists()) {
                int i = 0;
                for (String str : b.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = C1059ax.m3072a(adVar, str2);
                        i += a.length;
                        list.add(str2);
                        if (i > aqVar.f2596f.mo13044b()) {
                            break;
                        }
                        aqVar.f2597g.mo13040b(a);
                    }
                }
                return aqVar.f2597g.mo13041a();
            }
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
