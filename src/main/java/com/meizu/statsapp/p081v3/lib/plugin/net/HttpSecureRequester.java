package com.meizu.statsapp.p081v3.lib.plugin.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FailureRestrict;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.HttpSecureRequester */
public class HttpSecureRequester {
    private static final String APPLICATION_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private static String MULTI_BOUNDARY = "******--212x89--";
    private static final String TAG = "HttpSecureRequester";
    private static final Object lock = new Object();
    private static HttpSecureRequester sInstance;
    private Context context;
    private GslbWrapper gslbWrapper;

    private HttpSecureRequester(Context context2) {
        this.context = context2;
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gslbWrapper = GslbWrapper.getsInstance(context2);
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

    public NetResponse postMultipart(String str, Map<String, String> map, byte[] bArr) {
        NetResponse netResponse;
        NetResponse netResponse2 = null;
        if (!FailureRestrict.check("HttpSecureRequester.postMultipart")) {
            return null;
        }
        try {
            URL url = new URL(str);
            URL efURL = getEfURL(url);
            URL gslbConvert = gslbConvert(efURL);
            Map<String, String> attachKeyHeader = attachKeyHeader(map);
            if (gslbConvert.getHost().equals(url.getHost())) {
                Logger.m17378d(TAG, "gslb conversion failure.");
                try {
                    netResponse = realMultipartRequest(efURL, url.getHost(), attachKeyHeader, bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
                }
            } else {
                try {
                    netResponse2 = realMultipartRequest(gslbConvert, url.getHost(), attachKeyHeader, bArr);
                } catch (IOException e5) {
                    e5.printStackTrace();
                    this.gslbWrapper.onResponse(gslbConvert.getHost(), -1);
                } catch (ArrayIndexOutOfBoundsException e6) {
                    e6.printStackTrace();
                } catch (IllegalStateException e7) {
                    e7.printStackTrace();
                } catch (RuntimeException e8) {
                    e8.printStackTrace();
                }
                if (netResponse2 == null) {
                    try {
                        netResponse = realMultipartRequest(efURL, url.getHost(), attachKeyHeader, bArr);
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    } catch (RuntimeException e12) {
                        e12.printStackTrace();
                    }
                }
                netResponse = netResponse2;
            }
            if (!(netResponse == null || netResponse.getResponseCode() <= 400 || netResponse.getResponseCode() == 495)) {
                FailureRestrict.addFail("HttpSecureRequester.postMultipart");
            }
            return netResponse;
        } catch (MalformedURLException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: java.util.Iterator<java.util.Map$Entry<java.lang.String, java.lang.String>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: java.util.Iterator<java.util.Map$Entry<java.lang.String, java.lang.String>>} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff A[SYNTHETIC, Splitter:B:35:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0149 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014e A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0165 A[SYNTHETIC, Splitter:B:53:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse realMultipartRequest(java.net.URL r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, byte[] r10) throws java.io.IOException, java.lang.RuntimeException {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x000b
            java.lang.String r7 = "HttpSecureRequester"
            java.lang.String r8 = "url is null"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17379e(r7, r8)
            return r0
        L_0x000b:
            java.net.URLConnection r7 = r7.openConnection()
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            r1 = 1
            r7.setDoInput(r1)
            r2 = 0
            r7.setUseCaches(r2)
            java.lang.String r3 = "POST"
            r7.setRequestMethod(r3)     // Catch:{ ProtocolException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0023:
            r3 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r3)
            r7.setReadTimeout(r3)
            java.lang.String r3 = "Host"
            r7.setRequestProperty(r3, r8)     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r8 = "Connection"
            java.lang.String r3 = "keep-alive"
            r7.setRequestProperty(r8, r3)     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r8 = "Charset"
            java.lang.String r3 = "UTF-8"
            r7.setRequestProperty(r8, r3)     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r8 = "Content-Type"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0082 }
            r3.<init>()     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r4 = "multipart/form-data; boundary="
            r3.append(r4)     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r4 = MULTI_BOUNDARY     // Catch:{ Throwable -> 0x0082 }
            r3.append(r4)     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0082 }
            r7.setRequestProperty(r8, r3)     // Catch:{ Throwable -> 0x0082 }
            if (r9 == 0) goto L_0x0086
            int r8 = r9.size()     // Catch:{ Throwable -> 0x0082 }
            if (r8 <= 0) goto L_0x0086
            java.util.Set r8 = r9.entrySet()     // Catch:{ Throwable -> 0x0082 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Throwable -> 0x0082 }
        L_0x0066:
            boolean r9 = r8.hasNext()     // Catch:{ Throwable -> 0x0082 }
            if (r9 == 0) goto L_0x0086
            java.lang.Object r9 = r8.next()     // Catch:{ Throwable -> 0x0082 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Throwable -> 0x0082 }
            java.lang.Object r3 = r9.getKey()     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x0082 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Throwable -> 0x0082 }
            r7.setRequestProperty(r3, r9)     // Catch:{ Throwable -> 0x0082 }
            goto L_0x0066
        L_0x0082:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0086:
            if (r10 == 0) goto L_0x00de
            int r8 = r10.length     // Catch:{ all -> 0x00da }
            if (r8 == 0) goto L_0x00de
            r7.setDoOutput(r1)     // Catch:{ all -> 0x00da }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ all -> 0x00da }
            java.io.OutputStream r9 = r7.getOutputStream()     // Catch:{ all -> 0x00da }
            r8.<init>(r9)     // Catch:{ all -> 0x00da }
            com.meizu.statsapp.v3.lib.plugin.net.multipart.DataPart r9 = new com.meizu.statsapp.v3.lib.plugin.net.multipart.DataPart     // Catch:{ all -> 0x017d }
            java.lang.String r3 = "data"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            r4.<init>()     // Catch:{ all -> 0x017d }
            java.lang.String r5 = com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils.getMD5(r10)     // Catch:{ all -> 0x017d }
            r4.append(r5)     // Catch:{ all -> 0x017d }
            java.lang.String r5 = "-gzip"
            r4.append(r5)     // Catch:{ all -> 0x017d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017d }
            r9.<init>(r3, r4, r10)     // Catch:{ all -> 0x017d }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x017d }
            r10.<init>()     // Catch:{ all -> 0x017d }
            com.meizu.statsapp.v3.lib.plugin.net.multipart.Part[] r1 = new com.meizu.statsapp.p081v3.lib.plugin.net.multipart.Part[r1]     // Catch:{ all -> 0x017d }
            r1[r2] = r9     // Catch:{ all -> 0x017d }
            java.lang.String r9 = MULTI_BOUNDARY     // Catch:{ all -> 0x017d }
            byte[] r9 = r9.getBytes()     // Catch:{ all -> 0x017d }
            com.meizu.statsapp.p081v3.lib.plugin.net.multipart.Part.sendParts(r10, r1, r9)     // Catch:{ all -> 0x017d }
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r9 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x017d }
            byte[] r10 = r10.toByteArray()     // Catch:{ all -> 0x017d }
            byte[] r9 = r9.encrypt(r10)     // Catch:{ all -> 0x017d }
            if (r9 == 0) goto L_0x00df
            r8.write(r9)     // Catch:{ all -> 0x017d }
            r8.flush()     // Catch:{ all -> 0x017d }
            goto L_0x00df
        L_0x00da:
            r9 = move-exception
            r8 = r0
            goto L_0x017e
        L_0x00de:
            r8 = r0
        L_0x00df:
            int r9 = r7.getResponseCode()     // Catch:{ all -> 0x017d }
            java.lang.String r10 = "HttpSecureRequester"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            r1.<init>()     // Catch:{ all -> 0x017d }
            java.lang.String r2 = "code = "
            r1.append(r2)     // Catch:{ all -> 0x017d }
            r1.append(r9)     // Catch:{ all -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017d }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r10, r1)     // Catch:{ all -> 0x017d }
            java.io.InputStream r10 = r7.getInputStream()     // Catch:{ all -> 0x017d }
            if (r10 == 0) goto L_0x0149
            byte[] r1 = r6.getByteArrayByInputStream(r10)     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x014a
            java.lang.String r2 = "HttpSecureRequester"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r3.<init>()     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = "body = "
            r3.append(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r4.<init>(r1)     // Catch:{ all -> 0x0146 }
            r3.append(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0146 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r3)     // Catch:{ all -> 0x0146 }
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r2 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x0146 }
            byte[] r1 = r2.decrypt(r1)     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x014a
            java.lang.String r2 = "HttpSecureRequester"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r3.<init>()     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = "decrypt body = "
            r3.append(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r4.<init>(r1)     // Catch:{ all -> 0x0146 }
            r3.append(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0146 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r3)     // Catch:{ all -> 0x0146 }
            goto L_0x014a
        L_0x0146:
            r9 = move-exception
            r0 = r10
            goto L_0x017e
        L_0x0149:
            r1 = r0
        L_0x014a:
            r2 = 200(0xc8, float:2.8E-43)
            if (r9 == r2) goto L_0x0165
            r1 = 495(0x1ef, float:6.94E-43)
            if (r9 != r1) goto L_0x0159
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r9 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x0146 }
            r9.reInitKeys()     // Catch:{ all -> 0x0146 }
        L_0x0159:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r10)
            if (r7 == 0) goto L_0x0164
            r7.disconnect()
        L_0x0164:
            return r0
        L_0x0165:
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r2 = new com.meizu.statsapp.v3.lib.plugin.net.NetResponse     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x016e
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r0.<init>(r1)     // Catch:{ all -> 0x0146 }
        L_0x016e:
            r2.<init>(r9, r0)     // Catch:{ all -> 0x0146 }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r10)
            if (r7 == 0) goto L_0x017c
            r7.disconnect()
        L_0x017c:
            return r2
        L_0x017d:
            r9 = move-exception
        L_0x017e:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r0)
            if (r7 == 0) goto L_0x0189
            r7.disconnect()
        L_0x0189:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester.realMultipartRequest(java.net.URL, java.lang.String, java.util.Map, byte[]):com.meizu.statsapp.v3.lib.plugin.net.NetResponse");
    }

    public NetResponse stringPartRequest(String str, String str2, Map<String, String> map, String str3) {
        NetResponse netResponse;
        NetResponse netResponse2 = null;
        if (!FailureRestrict.check("HttpSecureRequester.stringPartRequest")) {
            return null;
        }
        try {
            URL url = new URL(str);
            URL efURL = getEfURL(url);
            URL gslbConvert = gslbConvert(efURL);
            Map<String, String> attachKeyHeader = attachKeyHeader(map);
            if (gslbConvert.getHost().equals(url.getHost())) {
                try {
                    netResponse = realStringPartRequest(efURL, url.getHost(), str2, attachKeyHeader, str3);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
                }
            } else {
                try {
                    netResponse2 = realStringPartRequest(gslbConvert, url.getHost(), str2, attachKeyHeader, str3);
                } catch (IOException e5) {
                    e5.printStackTrace();
                    this.gslbWrapper.onResponse(gslbConvert.getHost(), -1);
                } catch (ArrayIndexOutOfBoundsException e6) {
                    e6.printStackTrace();
                } catch (IllegalStateException e7) {
                    e7.printStackTrace();
                } catch (RuntimeException e8) {
                    e8.printStackTrace();
                }
                if (netResponse2 == null) {
                    try {
                        netResponse = realStringPartRequest(efURL, url.getHost(), str2, attachKeyHeader, str3);
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    } catch (RuntimeException e12) {
                        e12.printStackTrace();
                    }
                }
                netResponse = netResponse2;
            }
            if (!(netResponse == null || netResponse.getResponseCode() <= 400 || netResponse.getResponseCode() == 495)) {
                FailureRestrict.addFail("HttpSecureRequester.stringPartRequest");
            }
            return netResponse;
        } catch (MalformedURLException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse realStringPartRequest(java.net.URL r5, java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) throws java.io.IOException, java.lang.RuntimeException {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x000b
            java.lang.String r5 = "HttpSecureRequester"
            java.lang.String r6 = "url is null"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17379e(r5, r6)
            return r0
        L_0x000b:
            java.net.URLConnection r5 = r5.openConnection()
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5
            r5.setRequestMethod(r7)
            r7 = 1
            r5.setDoInput(r7)
            r1 = 0
            r5.setUseCaches(r1)
            r1 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r1)
            r5.setReadTimeout(r1)
            java.lang.String r1 = "Host"
            r5.setRequestProperty(r1, r6)     // Catch:{ Throwable -> 0x006a }
            java.lang.String r6 = "Connection"
            java.lang.String r1 = "keep-alive"
            r5.setRequestProperty(r6, r1)     // Catch:{ Throwable -> 0x006a }
            java.lang.String r6 = "Charset"
            java.lang.String r1 = "UTF-8"
            r5.setRequestProperty(r6, r1)     // Catch:{ Throwable -> 0x006a }
            java.lang.String r6 = "Content-Type"
            java.lang.String r1 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r6, r1)     // Catch:{ Throwable -> 0x006a }
            if (r8 == 0) goto L_0x006e
            int r6 = r8.size()     // Catch:{ Throwable -> 0x006a }
            if (r6 <= 0) goto L_0x006e
            java.util.Set r6 = r8.entrySet()     // Catch:{ Throwable -> 0x006a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Throwable -> 0x006a }
        L_0x004e:
            boolean r8 = r6.hasNext()     // Catch:{ Throwable -> 0x006a }
            if (r8 == 0) goto L_0x006e
            java.lang.Object r8 = r6.next()     // Catch:{ Throwable -> 0x006a }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ Throwable -> 0x006a }
            java.lang.Object r1 = r8.getKey()     // Catch:{ Throwable -> 0x006a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x006a }
            java.lang.Object r8 = r8.getValue()     // Catch:{ Throwable -> 0x006a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Throwable -> 0x006a }
            r5.setRequestProperty(r1, r8)     // Catch:{ Throwable -> 0x006a }
            goto L_0x004e
        L_0x006a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x006e:
            if (r9 == 0) goto L_0x00ac
            java.lang.String r6 = "HttpSecureRequester"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r8.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = "content:\n"
            r8.append(r1)     // Catch:{ all -> 0x00a7 }
            r8.append(r9)     // Catch:{ all -> 0x00a7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00a7 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r6, r8)     // Catch:{ all -> 0x00a7 }
            r5.setDoOutput(r7)     // Catch:{ all -> 0x00a7 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x00a7 }
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ all -> 0x00a7 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a7 }
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r7 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x0162 }
            byte[] r8 = r9.getBytes()     // Catch:{ all -> 0x0162 }
            byte[] r7 = r7.encrypt(r8)     // Catch:{ all -> 0x0162 }
            if (r7 == 0) goto L_0x00ad
            r6.write(r7)     // Catch:{ all -> 0x0162 }
            r6.flush()     // Catch:{ all -> 0x0162 }
            goto L_0x00ad
        L_0x00a7:
            r7 = move-exception
            r6 = r0
            r8 = r6
            goto L_0x0164
        L_0x00ac:
            r6 = r0
        L_0x00ad:
            r4.getsKey(r5)     // Catch:{ all -> 0x0162 }
            int r7 = r5.getResponseCode()     // Catch:{ all -> 0x0162 }
            java.lang.String r8 = "HttpSecureRequester"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0162 }
            r9.<init>()     // Catch:{ all -> 0x0162 }
            java.lang.String r1 = "code = "
            r9.append(r1)     // Catch:{ all -> 0x0162 }
            r9.append(r7)     // Catch:{ all -> 0x0162 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0162 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r8, r9)     // Catch:{ all -> 0x0162 }
            java.io.InputStream r8 = r5.getInputStream()     // Catch:{ all -> 0x0162 }
            if (r8 == 0) goto L_0x0119
            byte[] r9 = r4.getByteArrayByInputStream(r8)     // Catch:{ all -> 0x0117 }
            if (r9 == 0) goto L_0x011a
            java.lang.String r1 = "HttpSecureRequester"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r2.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = "body = "
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0117 }
            r3.<init>(r9)     // Catch:{ all -> 0x0117 }
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0117 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r1, r2)     // Catch:{ all -> 0x0117 }
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r1 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x0117 }
            byte[] r9 = r1.decrypt(r9)     // Catch:{ all -> 0x0117 }
            if (r9 == 0) goto L_0x011a
            java.lang.String r1 = "HttpSecureRequester"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r2.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = "decrypt body = "
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0117 }
            r3.<init>(r9)     // Catch:{ all -> 0x0117 }
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0117 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r1, r2)     // Catch:{ all -> 0x0117 }
            goto L_0x011a
        L_0x0117:
            r7 = move-exception
            goto L_0x0164
        L_0x0119:
            r9 = r0
        L_0x011a:
            r1 = 200(0xc8, float:2.8E-43)
            if (r7 == r1) goto L_0x0139
            r1 = 304(0x130, float:4.26E-43)
            if (r7 == r1) goto L_0x0139
            r9 = 495(0x1ef, float:6.94E-43)
            if (r7 != r9) goto L_0x012d
            com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr r7 = com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.get()     // Catch:{ all -> 0x0117 }
            r7.reInitKeys()     // Catch:{ all -> 0x0117 }
        L_0x012d:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r6)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            if (r5 == 0) goto L_0x0138
            r5.disconnect()
        L_0x0138:
            return r0
        L_0x0139:
            if (r9 == 0) goto L_0x0151
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r0 = new com.meizu.statsapp.v3.lib.plugin.net.NetResponse     // Catch:{ all -> 0x0117 }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0117 }
            r1.<init>(r9)     // Catch:{ all -> 0x0117 }
            r0.<init>(r7, r1)     // Catch:{ all -> 0x0117 }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r6)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            if (r5 == 0) goto L_0x0150
            r5.disconnect()
        L_0x0150:
            return r0
        L_0x0151:
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r9 = new com.meizu.statsapp.v3.lib.plugin.net.NetResponse     // Catch:{ all -> 0x0117 }
            r9.<init>(r7, r0)     // Catch:{ all -> 0x0117 }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r6)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            if (r5 == 0) goto L_0x0161
            r5.disconnect()
        L_0x0161:
            return r9
        L_0x0162:
            r7 = move-exception
            r8 = r0
        L_0x0164:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r6)
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r8)
            if (r5 == 0) goto L_0x016f
            r5.disconnect()
        L_0x016f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester.realStringPartRequest(java.net.URL, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.meizu.statsapp.v3.lib.plugin.net.NetResponse");
    }

    private String generateEf(URL url) {
        byte[] encrypt = HttpKeyMgr.get().encrypt(url.getFile().getBytes());
        if (encrypt == null) {
            return null;
        }
        String encodeToString = Base64.encodeToString(encrypt, 2);
        try {
            encodeToString = URLEncoder.encode(encodeToString, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        Logger.m17378d(TAG, "generated ef: " + encodeToString);
        return encodeToString;
    }

    private URL getEfURL(URL url) {
        URL url2;
        try {
            String generateEf = generateEf(url);
            String protocol = url.getProtocol();
            String host = url.getHost();
            url2 = new URL(protocol, host, "lighttps?ef=" + generateEf);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url2 = null;
        }
        return url2 == null ? url : url2;
    }

    private URL gslbConvert(URL url) {
        URL url2;
        Logger.m17378d(TAG, "### before gslb convert");
        String convert = this.gslbWrapper.convert(url.getHost());
        try {
            url2 = new URL(url.getProtocol(), convert, url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url2 = null;
        }
        Logger.m17378d(TAG, "### after gslb convert, ip: " + convert);
        return url2 == null ? url : url2;
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
                Logger.m17378d(TAG, "attach x_a_key: " + str);
                map.put("X-A-Key", "V1:" + str);
            }
        } else {
            String str2 = new String(bArr);
            Logger.m17378d(TAG, "attach x_s_key: " + str2);
            map.put("X-S-Key", str2);
        }
        return map;
    }

    private void getsKey(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            Logger.m17378d(TAG, "get x_s_key = " + headerField);
            if (!TextUtils.isEmpty(headerField)) {
                HttpKeyMgr.get().saveSKey(headerField);
            }
        } catch (Throwable unused) {
        }
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
}
