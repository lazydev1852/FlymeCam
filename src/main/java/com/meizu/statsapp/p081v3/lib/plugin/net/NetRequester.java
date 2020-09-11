package com.meizu.statsapp.p081v3.lib.plugin.net;

import android.content.Context;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.NetRequester */
public class NetRequester {
    private static final String APPLICATION_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private static String MULTI_BOUNDARY = "******--212x89--";
    private static final String TAG = "NetRequester";
    private static final Object lock = new Object();
    private static NetRequester sInstance;
    private Context context;

    private NetRequester(Context context2) {
        this.context = context2;
    }

    public static NetRequester getInstance(Context context2) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new NetRequester(context2);
                }
            }
        }
        return sInstance;
    }

    private byte[] getByteArrayByInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(read);
            } finally {
                CommonUtils.closeQuietly(byteArrayOutputStream);
            }
        }
    }

    public NetResponse postNoGslb(String str, Map<String, String> map) throws IOException, RuntimeException {
        return realNoGslbRequest(str, "GET", map, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v12, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(3:1|2|(2:4|(2:6|(2:7|(1:9)(1:73)))(0))(0))|12|(6:14|15|16|17|18|19)(1:24)|25|26|(3:28|29|30)|31|32|(3:34|35|(4:37|38|39|40))(1:54)|55|(4:57|58|(1:60)|61)(5:62|63|64|(1:66)|67)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x010a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0110 A[SYNTHETIC, Splitter:B:34:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0151 A[Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135, all -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016a A[Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135, all -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0183 A[SYNTHETIC, Splitter:B:62:0x0183] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a3  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse realNoGslbRequest(java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11) throws java.io.IOException, java.lang.RuntimeException {
        /*
            r7 = this;
            java.net.URL r0 = new java.net.URL
            r0.<init>(r8)
            java.net.URLConnection r8 = r0.openConnection()
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8
            r8.setRequestMethod(r9)
            r9 = 1
            r8.setDoInput(r9)
            r0 = 0
            r8.setUseCaches(r0)
            java.lang.String r1 = "Connection"
            java.lang.String r2 = "keep-alive"
            r8.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r1 = "Charset"
            java.lang.String r2 = "UTF-8"
            r8.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r8.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x0057 }
            if (r10 == 0) goto L_0x005b
            int r1 = r10.size()     // Catch:{ Throwable -> 0x0057 }
            if (r1 <= 0) goto L_0x005b
            java.util.Set r10 = r10.entrySet()     // Catch:{ Throwable -> 0x0057 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Throwable -> 0x0057 }
        L_0x003b:
            boolean r1 = r10.hasNext()     // Catch:{ Throwable -> 0x0057 }
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r10.next()     // Catch:{ Throwable -> 0x0057 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Throwable -> 0x0057 }
            java.lang.Object r2 = r1.getKey()     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0057 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x0057 }
            r8.setRequestProperty(r2, r1)     // Catch:{ Throwable -> 0x0057 }
            goto L_0x003b
        L_0x0057:
            r10 = move-exception
            r10.printStackTrace()
        L_0x005b:
            r10 = 0
            if (r11 == 0) goto L_0x0099
            r8.setDoOutput(r9)     // Catch:{ all -> 0x0094 }
            java.io.OutputStream r9 = r8.getOutputStream()     // Catch:{ all -> 0x0094 }
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ all -> 0x0090 }
            r1.<init>(r9)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x0197 }
            r2.<init>()     // Catch:{ all -> 0x0197 }
            r1.writeBytes(r11)     // Catch:{ all -> 0x0197 }
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0197 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            r3.<init>()     // Catch:{ all -> 0x0197 }
            java.lang.String r4 = "content:\n"
            r3.append(r4)     // Catch:{ all -> 0x0197 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
            r3.append(r2)     // Catch:{ all -> 0x0197 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0197 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r11, r2)     // Catch:{ all -> 0x0197 }
            r1.flush()     // Catch:{ all -> 0x0197 }
            goto L_0x009b
        L_0x0090:
            r11 = move-exception
            r1 = r10
            goto L_0x0198
        L_0x0094:
            r11 = move-exception
            r9 = r10
            r1 = r9
            goto L_0x0198
        L_0x0099:
            r9 = r10
            r1 = r9
        L_0x009b:
            int r11 = r8.getResponseCode()     // Catch:{ all -> 0x0197 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0197 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            r3.<init>()     // Catch:{ all -> 0x0197 }
            java.lang.String r4 = "code = "
            r3.append(r4)     // Catch:{ all -> 0x0197 }
            r3.append(r11)     // Catch:{ all -> 0x0197 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0197 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r3)     // Catch:{ all -> 0x0197 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r11 != r2) goto L_0x010a
            java.lang.String r2 = "Last-Modified"
            java.lang.String r2 = r8.getHeaderField(r2)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r3 = TAG     // Catch:{ NullPointerException -> 0x010a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x010a }
            r4.<init>()     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r5 = "get lastModified = "
            r4.append(r5)     // Catch:{ NullPointerException -> 0x010a }
            r4.append(r2)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r4 = r4.toString()     // Catch:{ NullPointerException -> 0x010a }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r3 = "ETag"
            java.lang.String r3 = r8.getHeaderField(r3)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r4 = TAG     // Catch:{ NullPointerException -> 0x010a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x010a }
            r5.<init>()     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r6 = "get ETag = "
            r5.append(r6)     // Catch:{ NullPointerException -> 0x010a }
            r5.append(r2)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x010a }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r4, r5)     // Catch:{ NullPointerException -> 0x010a }
            android.content.Context r4 = r7.context     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r5 = "com.meizu.statsapp.v3.serverconfig"
            android.content.SharedPreferences r0 = r4.getSharedPreferences(r5, r0)     // Catch:{ NullPointerException -> 0x010a }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r4 = "lastModified"
            r0.putString(r4, r2)     // Catch:{ NullPointerException -> 0x010a }
            java.lang.String r2 = "ETag"
            r0.putString(r2, r3)     // Catch:{ NullPointerException -> 0x010a }
            r0.apply()     // Catch:{ NullPointerException -> 0x010a }
        L_0x010a:
            java.io.InputStream r0 = r8.getInputStream()     // Catch:{ all -> 0x0197 }
            if (r0 == 0) goto L_0x0151
            byte[] r2 = r7.getByteArrayByInputStream(r0)     // Catch:{ all -> 0x014e }
            if (r2 == 0) goto L_0x0152
            java.lang.String r3 = "AES/ECB/PKCS5Padding"
            javax.crypto.Cipher r3 = javax.crypto.Cipher.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            java.lang.String r5 = "E21B5316F7B0813C"
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            java.lang.String r6 = "AES"
            r4.<init>(r5, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            r5 = 2
            r3.init(r5, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            byte[] r3 = r3.doFinal(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0149, NoSuchPaddingException -> 0x0144, InvalidKeyException -> 0x013f, BadPaddingException -> 0x013a, IllegalBlockSizeException -> 0x0135 }
            r2 = r3
            goto L_0x0152
        L_0x0135:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x014e }
            goto L_0x0152
        L_0x013a:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x014e }
            goto L_0x0152
        L_0x013f:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x014e }
            goto L_0x0152
        L_0x0144:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x014e }
            goto L_0x0152
        L_0x0149:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x014e }
            goto L_0x0152
        L_0x014e:
            r11 = move-exception
            r10 = r0
            goto L_0x0198
        L_0x0151:
            r2 = r10
        L_0x0152:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x014e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014e }
            r4.<init>()     // Catch:{ all -> 0x014e }
            java.lang.String r5 = "body = "
            r4.append(r5)     // Catch:{ all -> 0x014e }
            r4.append(r2)     // Catch:{ all -> 0x014e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014e }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x014e }
            if (r2 == 0) goto L_0x0183
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r10 = new com.meizu.statsapp.v3.lib.plugin.net.NetResponse     // Catch:{ all -> 0x014e }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x014e }
            r3.<init>(r2)     // Catch:{ all -> 0x014e }
            r10.<init>(r11, r3)     // Catch:{ all -> 0x014e }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r1)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r9)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r0)
            if (r8 == 0) goto L_0x0182
            r8.disconnect()
        L_0x0182:
            return r10
        L_0x0183:
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r2 = new com.meizu.statsapp.v3.lib.plugin.net.NetResponse     // Catch:{ all -> 0x014e }
            r2.<init>(r11, r10)     // Catch:{ all -> 0x014e }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r1)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r9)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r0)
            if (r8 == 0) goto L_0x0196
            r8.disconnect()
        L_0x0196:
            return r2
        L_0x0197:
            r11 = move-exception
        L_0x0198:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r1)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r9)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r10)
            if (r8 == 0) goto L_0x01a6
            r8.disconnect()
        L_0x01a6:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.net.NetRequester.realNoGslbRequest(java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.meizu.statsapp.v3.lib.plugin.net.NetResponse");
    }
}
