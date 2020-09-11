package com.baidu.p020ar.util;

import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.util.IoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.baidu.ar.util.HttpUtils */
public class HttpUtils {

    /* renamed from: a */
    private static final String f2368a = UUID.randomUUID().toString();

    /* renamed from: a */
    private static File m2719a(File file) {
        return new File(file.getAbsolutePath() + ".tmp" + System.currentTimeMillis());
    }

    /* renamed from: a */
    private static StringBuffer m2720a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry next : map.entrySet()) {
                if (next.getValue() != null) {
                    stringBuffer.append("--");
                    stringBuffer.append(f2368a);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"" + SystemInfoUtil.LINE_END);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), IoUtils.UTF_8));
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    /* renamed from: a */
    private static void m2721a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static boolean downloadFile(String str, File file) {
        return downloadFile(str, file, (IoUtils.Operation) null);
    }

    public static boolean downloadFile(String str, File file, IoUtils.Operation operation) {
        HttpURLConnection httpURLConnection;
        File a = m2719a(file);
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    int contentLength = httpURLConnection.getContentLength();
                    IoUtils.copyStream(inputStream2, a, (IoUtils.Cancelable) operation);
                    if (((long) contentLength) == a.length()) {
                        FileUtils.deleteFileIfExist(file);
                        boolean renameTo = a.renameTo(file);
                        IoUtils.closeQuietly(inputStream2);
                        m2721a(httpURLConnection);
                        return renameTo;
                    }
                    IoUtils.closeQuietly(inputStream2);
                    m2721a(httpURLConnection);
                    return false;
                } catch (IOException e) {
                    e = e;
                    inputStream = inputStream2;
                    try {
                        e.printStackTrace();
                        IoUtils.closeQuietly(inputStream);
                        m2721a(httpURLConnection);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        IoUtils.closeQuietly(inputStream);
                        m2721a(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    IoUtils.closeQuietly(inputStream);
                    m2721a(httpURLConnection);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                IoUtils.closeQuietly(inputStream);
                m2721a(httpURLConnection);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            e.printStackTrace();
            IoUtils.closeQuietly(inputStream);
            m2721a(httpURLConnection);
            return false;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            IoUtils.closeQuietly(inputStream);
            m2721a(httpURLConnection);
            throw th;
        }
    }

    public static int getLength(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(ComponentMessageType.MSG_TYPE_ON_SHAKE);
                int contentLength = httpURLConnection2.getContentLength();
                m2721a(httpURLConnection2);
                return contentLength;
            } catch (IOException e) {
                IOException iOException = e;
                httpURLConnection = httpURLConnection2;
                e = iOException;
                try {
                    e.printStackTrace();
                    m2721a(httpURLConnection);
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    m2721a(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                m2721a(httpURLConnection);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            m2721a(httpURLConnection);
            return 0;
        }
    }

    public static String getUrlAsString(String str) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream = httpURLConnection2.getInputStream();
            } catch (IOException e) {
                e = e;
                inputStream = null;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(inputStream);
                    m2721a(httpURLConnection2);
                    return null;
                } catch (Throwable th2) {
                    InputStream inputStream3 = inputStream;
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    inputStream2 = inputStream3;
                    IoUtils.closeQuietly(inputStream2);
                    m2721a(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection = httpURLConnection2;
                th = th4;
                IoUtils.closeQuietly(inputStream2);
                m2721a(httpURLConnection);
                throw th;
            }
            try {
                String loadContent = IoUtils.loadContent(inputStream);
                IoUtils.closeQuietly(inputStream);
                m2721a(httpURLConnection2);
                return loadContent;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                IoUtils.closeQuietly(inputStream);
                m2721a(httpURLConnection2);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection2 = null;
            inputStream = null;
            e.printStackTrace();
            IoUtils.closeQuietly(inputStream);
            m2721a(httpURLConnection2);
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            IoUtils.closeQuietly(inputStream2);
            m2721a(httpURLConnection);
            throw th;
        }
    }

    public static String post(String str, String str2) {
        InputStream inputStream;
        PrintWriter printWriter;
        PrintWriter printWriter2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("charset", IoUtils.UTF_8);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setConnectTimeout(30000);
            if (str2 == null || str2.trim().equals("")) {
                printWriter = null;
            } else {
                printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                try {
                    printWriter.print(str2);
                    printWriter.flush();
                } catch (Exception e) {
                    e = e;
                    inputStream = null;
                    printWriter2 = printWriter;
                    try {
                        e.printStackTrace();
                        IoUtils.closeQuietly(printWriter2);
                        IoUtils.closeQuietly(inputStream);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        IoUtils.closeQuietly(printWriter2);
                        IoUtils.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    printWriter2 = printWriter;
                    IoUtils.closeQuietly(printWriter2);
                    IoUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            try {
                String loadContent = IoUtils.loadContent(inputStream2);
                IoUtils.closeQuietly(printWriter);
                IoUtils.closeQuietly(inputStream2);
                return loadContent;
            } catch (Exception e2) {
                printWriter2 = printWriter;
                Exception exc = e2;
                inputStream = inputStream2;
                e = exc;
                e.printStackTrace();
                IoUtils.closeQuietly(printWriter2);
                IoUtils.closeQuietly(inputStream);
                return "";
            } catch (Throwable th3) {
                printWriter2 = printWriter;
                Throwable th4 = th3;
                inputStream = inputStream2;
                th = th4;
                IoUtils.closeQuietly(printWriter2);
                IoUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
            e.printStackTrace();
            IoUtils.closeQuietly(printWriter2);
            IoUtils.closeQuietly(inputStream);
            return "";
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            IoUtils.closeQuietly(printWriter2);
            IoUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String postRequest(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x006a, all -> 0x0065 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0065 }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x006a, all -> 0x0065 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x006a, all -> 0x0065 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r4.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r1 = 30000(0x7530, float:4.2039E-41)
            r4.setReadTimeout(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r1 = 1
            r4.setDoOutput(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r4.setDoInput(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r1 = 0
            r4.setUseCaches(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.lang.String r1 = "POST"
            r4.setRequestMethod(r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.lang.String r1 = "Connection"
            java.lang.String r2 = "Keep-Alive"
            r4.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r4.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.io.OutputStream r1 = r4.getOutputStream()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            byte[] r5 = r5.getBytes(r2)     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            r1.write(r5)     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            r1.flush()     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            java.lang.String r2 = com.baidu.p020ar.util.IoUtils.loadContent(r5)     // Catch:{ Exception -> 0x0056 }
            m2721a((java.net.HttpURLConnection) r4)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r5)
            return r2
        L_0x0056:
            r2 = move-exception
            goto L_0x006e
        L_0x0058:
            r5 = move-exception
            r3 = r1
            r1 = r0
            goto L_0x007f
        L_0x005c:
            r2 = move-exception
            r5 = r0
            goto L_0x006e
        L_0x005f:
            r5 = move-exception
            r1 = r0
            goto L_0x0080
        L_0x0062:
            r2 = move-exception
            r5 = r0
            goto L_0x006d
        L_0x0065:
            r4 = move-exception
            r5 = r4
            r4 = r0
            r1 = r4
            goto L_0x0080
        L_0x006a:
            r2 = move-exception
            r4 = r0
            r5 = r4
        L_0x006d:
            r1 = r5
        L_0x006e:
            r2.printStackTrace()     // Catch:{ all -> 0x007b }
            m2721a((java.net.HttpURLConnection) r4)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r5)
            return r0
        L_0x007b:
            r0 = move-exception
            r3 = r1
            r1 = r5
            r5 = r0
        L_0x007f:
            r0 = r3
        L_0x0080:
            m2721a((java.net.HttpURLConnection) r4)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.HttpUtils.postRequest(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String uploadFile(java.lang.String r6, java.util.HashMap r7, byte[] r8) {
        /*
            java.lang.String r0 = "multipart/form-data"
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r2.<init>(r6)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.net.URLConnection r6 = r2.openConnection()     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r2 = 20000(0x4e20, float:2.8026E-41)
            r6.setReadTimeout(r2)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r2 = 3000(0xbb8, float:4.204E-42)
            r6.setConnectTimeout(r2)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r2 = 1
            r6.setDoInput(r2)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r6.setDoOutput(r2)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r2 = 0
            r6.setUseCaches(r2)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r3 = "POST"
            r6.setRequestMethod(r3)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r3 = "Charset"
            java.lang.String r4 = "utf-8"
            r6.setRequestProperty(r3, r4)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r3 = "connection"
            java.lang.String r4 = "keep-alive"
            r6.setRequestProperty(r3, r4)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r3 = "Content-Type"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r4.append(r0)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r0 = ";boundary="
            r4.append(r0)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r0 = f2368a     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r4.append(r0)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.String r0 = r4.toString()     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r6.setRequestProperty(r3, r0)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            if (r8 == 0) goto L_0x0127
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.io.OutputStream r3 = r6.getOutputStream()     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            r0.<init>(r3)     // Catch:{ MalformedURLException -> 0x0139, IOException -> 0x0133, all -> 0x0130 }
            java.lang.StringBuffer r7 = m2720a((java.util.Map<java.lang.String, java.lang.String>) r7)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r7 = r7.toString()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            byte[] r7 = r7.getBytes(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r0.write(r7)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.<init>()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "--"
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = f2368a     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "\r\n"
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r4 = ".jpg"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r5 = "Content-Disposition: form-data; name=\"image\"; filename=\""
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "\""
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "\r\n"
            r4.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = r4.toString()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "Content-Type: application/octet-stream; charset=utf-8\r\n"
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r3 = "\r\n"
            r7.append(r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r7 = r7.toString()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            byte[] r7 = r7.getBytes()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r0.write(r7)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
        L_0x00d2:
            int r3 = r7.read(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r4 = -1
            if (r3 == r4) goto L_0x00dd
            r0.write(r8, r2, r3)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            goto L_0x00d2
        L_0x00dd:
            r7.close()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r7 = "\r\n"
            byte[] r7 = r7.getBytes()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r0.write(r7)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.<init>()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r8 = "--"
            r7.append(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r8 = f2368a     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r7.append(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r8 = "--"
            r7.append(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r8 = "\r\n"
            r7.append(r8)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r7 = r7.toString()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            byte[] r7 = r7.getBytes()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r0.write(r7)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r0.flush()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            int r7 = r6.getResponseCode()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x0121
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            java.lang.String r6 = com.baidu.p020ar.util.IoUtils.loadContent(r6)     // Catch:{ MalformedURLException -> 0x0125, IOException -> 0x0123 }
            goto L_0x0129
        L_0x0121:
            r6 = r1
            goto L_0x0129
        L_0x0123:
            r6 = move-exception
            goto L_0x0135
        L_0x0125:
            r6 = move-exception
            goto L_0x013b
        L_0x0127:
            r6 = r1
            r0 = r6
        L_0x0129:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            goto L_0x0145
        L_0x0130:
            r6 = move-exception
            r0 = r1
            goto L_0x0147
        L_0x0133:
            r6 = move-exception
            r0 = r1
        L_0x0135:
            r6.printStackTrace()     // Catch:{ all -> 0x0146 }
            goto L_0x013e
        L_0x0139:
            r6 = move-exception
            r0 = r1
        L_0x013b:
            r6.printStackTrace()     // Catch:{ all -> 0x0146 }
        L_0x013e:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            r6 = r1
        L_0x0145:
            return r6
        L_0x0146:
            r6 = move-exception
        L_0x0147:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.HttpUtils.uploadFile(java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }
}
