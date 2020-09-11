package com.meizu.cloud.pushsdk.analytics.secure;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpSecureRequester {
    private static final String APPLICATION_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String TAG = "HttpSecureRequester";
    private static final Object lock = new Object();
    private static HttpSecureRequester sInstance;
    private Context context;

    private HttpSecureRequester(Context context2) {
        this.context = context2;
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpKeyMgr.init(context2);
    }

    public static HttpSecureRequester getInstance(Context context2) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new HttpSecureRequester(context2);
                }
            }
        }
        return sInstance;
    }

    public NetResponse stringPartRequest(String str, Map<String, String> map, String str2) {
        try {
            return realStringPartRequest(str, attachKeyHeader(map), str2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0102, code lost:
        if (r9 == null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0104, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012c, code lost:
        if (r9 != null) goto L_0x0104;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0129 A[SYNTHETIC, Splitter:B:48:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0132 A[SYNTHETIC, Splitter:B:54:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.cloud.pushsdk.analytics.secure.NetResponse realStringPartRequest(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0140
            com.meizu.cloud.pushsdk.analytics.secure.HttpKeyMgr r1 = com.meizu.cloud.pushsdk.analytics.secure.HttpKeyMgr.get()
            byte[] r9 = r9.getBytes()
            byte[] r9 = r1.encrypt(r9)
            if (r9 == 0) goto L_0x001c
            java.lang.String r1 = new java.lang.String
            r2 = 2
            byte[] r9 = android.util.Base64.encode(r9, r2)
            r1.<init>(r9)
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x013b }
            java.lang.String r2 = "http://norma-external-collect.meizu.com/push/android/external/add.do"
            r9.<init>(r2)     // Catch:{ MalformedURLException -> 0x013b }
            java.net.URLConnection r9 = r9.openConnection()
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9
            r9.setRequestMethod(r7)
            r7 = 1
            r9.setDoInput(r7)
            r9.setDoOutput(r7)
            r7 = 0
            r9.setUseCaches(r7)
            r7 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r7)
            r9.setReadTimeout(r7)
            java.lang.String r7 = "Connection"
            java.lang.String r2 = "keep-alive"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Charset"
            java.lang.String r2 = "UTF-8"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r9.setRequestProperty(r7, r2)
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r9.setRequestProperty(r7, r2)
            if (r8 == 0) goto L_0x0088
            int r7 = r8.size()
            if (r7 <= 0) goto L_0x0088
            java.util.Set r7 = r8.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x006c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0088
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r2 = r8.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            r9.setRequestProperty(r2, r8)
            goto L_0x006c
        L_0x0088:
            byte[] r7 = r1.getBytes()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r6.writeBody(r9, r7)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            int r7 = r9.getResponseCode()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r1.<init>()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.lang.String r2 = "code = "
            r1.append(r2)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r1.append(r7)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            com.meizu.cloud.pushinternal.DebugLogger.m4827d(r8, r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r6.getsKey(r9)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r6.getKeyTimeout(r9)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            if (r8 == 0) goto L_0x00e8
            byte[] r1 = r6.getByteArrayByInputStream(r8)     // Catch:{ Exception -> 0x00e6 }
            if (r1 == 0) goto L_0x00e9
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x00e6 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r3 = TAG     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r4.<init>()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r5 = "body = "
            r4.append(r5)     // Catch:{ Exception -> 0x00e6 }
            r4.append(r2)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e6 }
            com.meizu.cloud.pushinternal.DebugLogger.m4827d(r3, r4)     // Catch:{ Exception -> 0x00e6 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e1 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = "code"
            r3.getInt(r2)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x00e9
        L_0x00e1:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00e9
        L_0x00e6:
            r7 = move-exception
            goto L_0x010d
        L_0x00e8:
            r1 = r0
        L_0x00e9:
            if (r1 == 0) goto L_0x00f7
            com.meizu.cloud.pushsdk.analytics.secure.NetResponse r2 = new com.meizu.cloud.pushsdk.analytics.secure.NetResponse     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00e6 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00e6 }
            r2.<init>(r7, r3)     // Catch:{ Exception -> 0x00e6 }
            r0 = r2
            goto L_0x00fd
        L_0x00f7:
            com.meizu.cloud.pushsdk.analytics.secure.NetResponse r1 = new com.meizu.cloud.pushsdk.analytics.secure.NetResponse     // Catch:{ Exception -> 0x00e6 }
            r1.<init>(r7, r0)     // Catch:{ Exception -> 0x00e6 }
            r0 = r1
        L_0x00fd:
            if (r8 == 0) goto L_0x0102
            r8.close()     // Catch:{ IOException -> 0x0102 }
        L_0x0102:
            if (r9 == 0) goto L_0x0140
        L_0x0104:
            r9.disconnect()
            goto L_0x0140
        L_0x0108:
            r7 = move-exception
            r8 = r0
            goto L_0x0130
        L_0x010b:
            r7 = move-exception
            r8 = r0
        L_0x010d:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r2.<init>()     // Catch:{ all -> 0x012f }
            java.lang.String r3 = "realStringPartRequest error "
            r2.append(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x012f }
            r2.append(r7)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x012f }
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r1, r7)     // Catch:{ all -> 0x012f }
            if (r8 == 0) goto L_0x012c
            r8.close()     // Catch:{ IOException -> 0x012c }
        L_0x012c:
            if (r9 == 0) goto L_0x0140
            goto L_0x0104
        L_0x012f:
            r7 = move-exception
        L_0x0130:
            if (r8 == 0) goto L_0x0135
            r8.close()     // Catch:{ IOException -> 0x0135 }
        L_0x0135:
            if (r9 == 0) goto L_0x013a
            r9.disconnect()
        L_0x013a:
            throw r7
        L_0x013b:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        L_0x0140:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.analytics.secure.HttpSecureRequester.realStringPartRequest(java.lang.String, java.util.Map, java.lang.String):com.meizu.cloud.pushsdk.analytics.secure.NetResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[SYNTHETIC, Splitter:B:12:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeBody(java.net.HttpURLConnection r3, byte[] r4) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0017 }
            java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ all -> 0x0017 }
            r1.<init>(r3)     // Catch:{ all -> 0x0017 }
            r1.write(r4)     // Catch:{ all -> 0x0014 }
            r1.flush()     // Catch:{ all -> 0x0014 }
            r1.close()     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            return
        L_0x0014:
            r3 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0017:
            r3 = move-exception
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r0.close()     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.analytics.secure.HttpSecureRequester.writeBody(java.net.HttpURLConnection, byte[]):void");
    }

    private Map<String, String> attachKeyHeader(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        byte[] bArr = HttpKeyMgr.get().getsKey64();
        if (bArr == null || bArr.length <= 0) {
            byte[] bArr2 = HttpKeyMgr.get().getaKey64();
            if (bArr2 != null && bArr2.length > 0) {
                String str = new String(HttpKeyMgr.get().getaKey64());
                String str2 = TAG;
                DebugLogger.m4827d(str2, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str3 = new String(bArr);
            String str4 = TAG;
            DebugLogger.m4827d(str4, "attach x_s_key: " + str3);
            map.put("X-S-Key", str3);
        }
        return map;
    }

    private void getsKey(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            String str = TAG;
            DebugLogger.m4827d(str, "get x_s_key = " + headerField);
            if (!TextUtils.isEmpty(headerField)) {
                HttpKeyMgr.get().saveSKey(headerField);
            }
        } catch (NullPointerException unused) {
        }
    }

    private void getKeyTimeout(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("Key-Timeout");
            String str = TAG;
            DebugLogger.m4827d(str, "get keyTimeout = " + headerField);
        } catch (NullPointerException unused) {
        }
    }

    private byte[] getByteArrayByInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
