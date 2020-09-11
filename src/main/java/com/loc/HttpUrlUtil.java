package com.loc;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.loc.BaseNetManager;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

/* renamed from: com.loc.al */
public final class HttpUrlUtil {

    /* renamed from: a */
    private int f2569a;

    /* renamed from: b */
    private int f2570b;

    /* renamed from: c */
    private boolean f2571c;

    /* renamed from: d */
    private SSLContext f2572d;

    /* renamed from: e */
    private Proxy f2573e;

    /* renamed from: f */
    private volatile boolean f2574f;

    /* renamed from: g */
    private long f2575g;

    /* renamed from: h */
    private long f2576h;

    /* renamed from: i */
    private String f2577i;

    /* renamed from: j */
    private C1051a f2578j;

    /* renamed from: k */
    private BaseNetManager.C1049a f2579k;

    /* renamed from: com.loc.al$a */
    /* compiled from: HttpUrlUtil */
    private static class C1051a {

        /* renamed from: a */
        private Vector<C1052b> f2580a;

        /* renamed from: b */
        private volatile C1052b f2581b;

        private C1051a() {
            this.f2580a = new Vector<>();
            this.f2581b = new C1052b((byte) 0);
        }

        /* synthetic */ C1051a(byte b) {
            this();
        }

        /* renamed from: a */
        public final C1052b mo13014a() {
            return this.f2581b;
        }

        /* renamed from: a */
        public final C1052b mo13015a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f2581b;
            }
            for (int i = 0; i < this.f2580a.size(); i++) {
                C1052b bVar = this.f2580a.get(i);
                if (bVar != null && bVar.mo13017a().equals(str)) {
                    return bVar;
                }
            }
            C1052b bVar2 = new C1052b((byte) 0);
            bVar2.mo13019b(str);
            this.f2580a.add(bVar2);
            return bVar2;
        }

        /* renamed from: b */
        public final void mo13016b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f2581b.mo13018a(str);
            }
        }
    }

    /* renamed from: com.loc.al$b */
    /* compiled from: HttpUrlUtil */
    private static class C1052b implements HostnameVerifier {

        /* renamed from: a */
        private String f2582a;

        /* renamed from: b */
        private String f2583b;

        private C1052b() {
        }

        /* synthetic */ C1052b(byte b) {
            this();
        }

        /* renamed from: a */
        public final String mo13017a() {
            return this.f2583b;
        }

        /* renamed from: a */
        public final void mo13018a(String str) {
            this.f2582a = str;
        }

        /* renamed from: b */
        public final void mo13019b(String str) {
            this.f2583b = str;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f2582a) ? this.f2582a.equals(str) : !TextUtils.isEmpty(this.f2583b) ? defaultHostnameVerifier.verify(this.f2583b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    HttpUrlUtil(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, (byte) 0);
    }

    private HttpUrlUtil(int i, int i2, Proxy proxy, boolean z, byte b) {
        this.f2574f = false;
        this.f2575g = -1;
        this.f2576h = 0;
        this.f2569a = i;
        this.f2570b = i2;
        this.f2573e = proxy;
        this.f2571c = HttpsDecisionUtil.m3747a().mo13265b(z);
        if (HttpsDecisionUtil.m3749b()) {
            this.f2571c = false;
        }
        this.f2579k = null;
        try {
            this.f2577i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "ht", "ic");
        }
        if (this.f2571c) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.f2572d = instance;
            } catch (Throwable th2) {
                BasicLogHandler.m3844a(th2, "ht", "ne");
            }
        }
        this.f2578j = new C1051a((byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0112 A[SYNTHETIC, Splitter:B:74:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0120 A[SYNTHETIC, Splitter:B:79:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012e A[SYNTHETIC, Splitter:B:84:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013c A[SYNTHETIC, Splitter:B:89:0x013c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.loc.ResponseEntity m3021a(java.net.HttpURLConnection r11) throws com.loc.AMapCoreException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = 0
            r11.connect()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.util.Map r2 = r11.getHeaderFields()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            int r3 = r11.getResponseCode()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r4 = 0
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = "gsid"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.util.List r5 = (java.util.List) r5     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            if (r5 == 0) goto L_0x0028
            int r6 = r5.size()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            if (r6 <= 0) goto L_0x0028
            java.lang.Object r5 = r5.get(r4)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r0 = r5
        L_0x0028:
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 != r5) goto L_0x00c7
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r3.<init>()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ IOException -> 0x00c2, all -> 0x00bc }
            java.io.PushbackInputStream r5 = new java.io.PushbackInputStream     // Catch:{ IOException -> 0x00ba, all -> 0x00b5 }
            r6 = 2
            r5.<init>(r11, r6)     // Catch:{ IOException -> 0x00ba, all -> 0x00b5 }
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r5.read(r6)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r5.unread(r6)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            byte r7 = r6[r4]     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r8 = 31
            if (r7 != r8) goto L_0x0057
            r7 = 1
            byte r6 = r6[r7]     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r7 = -117(0xffffffffffffff8b, float:NaN)
            if (r6 != r7) goto L_0x0057
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r1 = r6
            goto L_0x0058
        L_0x0057:
            r1 = r5
        L_0x0058:
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
        L_0x005c:
            int r7 = r1.read(r6)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r8 = -1
            if (r7 == r8) goto L_0x0067
            r3.write(r6, r4, r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            goto L_0x005c
        L_0x0067:
            com.loc.SDKLogHandler.m3868c()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            com.loc.an r4 = new com.loc.an     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r4.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            byte[] r6 = r3.toByteArray()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r4.f2587a = r6     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r4.f2588b = r2     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            java.lang.String r2 = r10.f2577i     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r4.f2589c = r2     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r4.f2590d = r0     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            r3.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x0089
        L_0x0081:
            r0 = move-exception
            java.lang.String r2 = "ht"
            java.lang.String r3 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0089:
            if (r11 == 0) goto L_0x0097
            r11.close()     // Catch:{ Throwable -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r2 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x0097:
            r5.close()     // Catch:{ Throwable -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r2 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x00a3:
            r1.close()     // Catch:{ Throwable -> 0x00a7 }
            goto L_0x00af
        L_0x00a7:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r1 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r1)
        L_0x00af:
            return r4
        L_0x00b0:
            r0 = move-exception
            r2 = r1
            goto L_0x00b8
        L_0x00b3:
            r2 = r1
            goto L_0x00c5
        L_0x00b5:
            r0 = move-exception
            r2 = r1
            r5 = r2
        L_0x00b8:
            r1 = r3
            goto L_0x010d
        L_0x00ba:
            r2 = r1
            goto L_0x00c4
        L_0x00bc:
            r11 = move-exception
            r0 = r1
            r2 = r0
            r5 = r2
            r1 = r3
            goto L_0x0110
        L_0x00c2:
            r11 = r1
            r2 = r11
        L_0x00c4:
            r5 = r2
        L_0x00c5:
            r1 = r3
            goto L_0x0104
        L_0x00c7:
            com.loc.cx r2 = new com.loc.cx     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r5 = "网络异常原因："
            r4.<init>(r5)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = r11.getResponseMessage()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r4.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = " 网络异常状态码："
            r4.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r4.append(r3)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = "  "
            r4.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r4.append(r0)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = " "
            r4.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = r10.f2577i     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r4.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            java.lang.String r11 = r4.toString()     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r2.<init>(r11, r0)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            r2.mo13249a(r3)     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
            throw r2     // Catch:{ IOException -> 0x0101, all -> 0x00fc }
        L_0x00fc:
            r11 = move-exception
            r0 = r1
            r2 = r0
            r5 = r2
            goto L_0x0110
        L_0x0101:
            r11 = r1
            r2 = r11
            r5 = r2
        L_0x0104:
            com.loc.cx r3 = new com.loc.cx     // Catch:{ all -> 0x010c }
            java.lang.String r4 = "IO 操作异常 - IOException"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x010c }
            throw r3     // Catch:{ all -> 0x010c }
        L_0x010c:
            r0 = move-exception
        L_0x010d:
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0110:
            if (r1 == 0) goto L_0x011e
            r1.close()     // Catch:{ Throwable -> 0x0116 }
            goto L_0x011e
        L_0x0116:
            r1 = move-exception
            java.lang.String r3 = "ht"
            java.lang.String r4 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)
        L_0x011e:
            if (r0 == 0) goto L_0x012c
            r0.close()     // Catch:{ Throwable -> 0x0124 }
            goto L_0x012c
        L_0x0124:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r3 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x012c:
            if (r5 == 0) goto L_0x013a
            r5.close()     // Catch:{ Throwable -> 0x0132 }
            goto L_0x013a
        L_0x0132:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r3 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x013a:
            if (r2 == 0) goto L_0x0148
            r2.close()     // Catch:{ Throwable -> 0x0140 }
            goto L_0x0148
        L_0x0140:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r2 = "par"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0148:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.HttpUrlUtil.m3021a(java.net.HttpURLConnection):com.loc.an");
    }

    /* renamed from: a */
    static String m3022a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append("=");
            sb.append(URLEncoder.encode(str2));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private HttpURLConnection m3023a(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        URLConnection uRLConnection;
        HttpURLConnection httpURLConnection;
        DeviceInfo.m3709b();
        if (map == null) {
            map = new HashMap<>();
        }
        C1052b a = this.f2578j.mo13014a();
        if (z && !TextUtils.isEmpty(str2)) {
            a = this.f2578j.mo13015a(str2);
        }
        String str3 = "";
        if (BaseNetManager.f2562a == 1) {
            str3 = BaseNetManager.f2563b;
        }
        if (!TextUtils.isEmpty(str3)) {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            str = parse.buildUpon().encodedAuthority(str3).build().toString();
            if (map != null) {
                map.put("targetHost", host);
            }
            if (this.f2571c) {
                this.f2578j.mo13016b(str3);
            }
        }
        if (this.f2571c) {
            str = HttpsDecisionUtil.m3748a(str);
        }
        URL url = new URL(str);
        if (this.f2579k != null) {
            BaseNetManager.C1049a aVar = this.f2579k;
            Proxy proxy = this.f2573e;
            uRLConnection = aVar.mo12998a();
        } else {
            uRLConnection = null;
        }
        if (uRLConnection == null) {
            uRLConnection = this.f2573e != null ? url.openConnection(this.f2573e) : url.openConnection();
        }
        if (this.f2571c) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.f2572d.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "close");
        }
        m3024a(map, httpURLConnection);
        if (z2) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m3024a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.addRequestProperty(next, map.get(next));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.f2577i);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.f2569a);
        httpURLConnection.setReadTimeout(this.f2570b);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bf A[SYNTHETIC, Splitter:B:66:0x00bf] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.loc.ResponseEntity mo13010a(java.lang.String r8, boolean r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, byte[] r12) throws com.loc.AMapCoreException {
        /*
            r7 = this;
            r5 = 1
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            java.net.HttpURLConnection r8 = r0.m3023a((java.lang.String) r1, (boolean) r2, (java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r5)     // Catch:{ ConnectException -> 0x00b1, MalformedURLException -> 0x00a5, UnknownHostException -> 0x0099, SocketException -> 0x008d, SocketTimeoutException -> 0x0081, InterruptedIOException -> 0x0079, IOException -> 0x006d, cx -> 0x0064, Throwable -> 0x0054 }
            if (r12 == 0) goto L_0x003d
            int r9 = r12.length     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            if (r9 <= 0) goto L_0x003d
            java.io.DataOutputStream r9 = new java.io.DataOutputStream     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            java.io.OutputStream r10 = r8.getOutputStream()     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            r9.<init>(r10)     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            r9.write(r12)     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            r9.close()     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            goto L_0x003d
        L_0x0020:
            r9 = move-exception
            r6 = r8
            goto L_0x00bd
        L_0x0024:
            r9 = move-exception
            r6 = r8
            goto L_0x0055
        L_0x0027:
            r9 = move-exception
            r6 = r8
            goto L_0x0065
        L_0x002a:
            r9 = move-exception
            r6 = r8
            goto L_0x006e
        L_0x002d:
            r9 = move-exception
            r6 = r8
            goto L_0x0082
        L_0x0030:
            r9 = move-exception
            r6 = r8
            goto L_0x008e
        L_0x0033:
            r9 = move-exception
            r6 = r8
            goto L_0x009a
        L_0x0036:
            r9 = move-exception
            r6 = r8
            goto L_0x00a6
        L_0x0039:
            r9 = move-exception
            r6 = r8
            goto L_0x00b2
        L_0x003d:
            com.loc.an r9 = r7.m3021a((java.net.HttpURLConnection) r8)     // Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, cx -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
            if (r8 == 0) goto L_0x004f
            r8.disconnect()     // Catch:{ Throwable -> 0x0047 }
            goto L_0x004f
        L_0x0047:
            r8 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mPt"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r8, (java.lang.String) r10, (java.lang.String) r11)
        L_0x004f:
            return r9
        L_0x0050:
            r6 = r8
            goto L_0x0079
        L_0x0052:
            r9 = move-exception
            goto L_0x00bd
        L_0x0054:
            r9 = move-exception
        L_0x0055:
            java.lang.String r8 = "ht"
            java.lang.String r10 = "mPt"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r9, (java.lang.String) r8, (java.lang.String) r10)     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "未知的错误"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x0064:
            r9 = move-exception
        L_0x0065:
            java.lang.String r8 = "ht"
            java.lang.String r10 = "mPt"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r9, (java.lang.String) r8, (java.lang.String) r10)     // Catch:{ all -> 0x0052 }
            throw r9     // Catch:{ all -> 0x0052 }
        L_0x006d:
            r9 = move-exception
        L_0x006e:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "IO 操作异常 - IOException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x0079:
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "未知的错误"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x0081:
            r9 = move-exception
        L_0x0082:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "socket 连接超时 - SocketTimeoutException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x008d:
            r9 = move-exception
        L_0x008e:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "socket 连接异常 - SocketException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x0099:
            r9 = move-exception
        L_0x009a:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "未知主机 - UnKnowHostException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x00a5:
            r9 = move-exception
        L_0x00a6:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "url异常 - MalformedURLException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x00b1:
            r9 = move-exception
        L_0x00b2:
            r9.printStackTrace()     // Catch:{ all -> 0x0052 }
            com.loc.cx r8 = new com.loc.cx     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "http连接失败 - ConnectionException"
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            throw r8     // Catch:{ all -> 0x0052 }
        L_0x00bd:
            if (r6 == 0) goto L_0x00cb
            r6.disconnect()     // Catch:{ Throwable -> 0x00c3 }
            goto L_0x00cb
        L_0x00c3:
            r8 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mPt"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r8, (java.lang.String) r10, (java.lang.String) r11)
        L_0x00cb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.HttpUrlUtil.mo13010a(java.lang.String, boolean, java.lang.String, java.util.Map, byte[]):com.loc.an");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo13011a() {
        this.f2576h = 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0108 */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010d A[SYNTHETIC, Splitter:B:74:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011b A[SYNTHETIC, Splitter:B:79:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0122 A[SYNTHETIC, Splitter:B:83:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0130 A[SYNTHETIC, Splitter:B:88:0x0130] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13012a(java.lang.String r9, boolean r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, byte[] r14, com.loc.DownloadManager.C1050a r15) {
        /*
            r8 = this;
            if (r15 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.String r13 = m3022a((java.util.Map<java.lang.String, java.lang.String>) r13)     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            r1.<init>()     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            r1.append(r9)     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            if (r13 == 0) goto L_0x001a
            java.lang.String r9 = "?"
            r1.append(r9)     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            r1.append(r13)     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
        L_0x001a:
            r9 = 1
            r13 = 0
            if (r14 == 0) goto L_0x0023
            int r2 = r14.length     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            if (r2 <= 0) goto L_0x0023
            r7 = 1
            goto L_0x0024
        L_0x0023:
            r7 = 0
        L_0x0024:
            java.lang.String r2 = r1.toString()     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r7
            java.net.HttpURLConnection r10 = r1.m3023a((java.lang.String) r2, (boolean) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r5, (boolean) r6)     // Catch:{ Throwable -> 0x0107, all -> 0x0104 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r12 = "bytes="
            r11.<init>(r12)     // Catch:{ Throwable -> 0x0108 }
            long r1 = r8.f2576h     // Catch:{ Throwable -> 0x0108 }
            r11.append(r1)     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r12 = "-"
            r11.append(r12)     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r11 = r11.toString()     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r12 = "RANGE"
            r10.setRequestProperty(r12, r11)     // Catch:{ Throwable -> 0x0108 }
            if (r7 == 0) goto L_0x005c
            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ Throwable -> 0x0108 }
            java.io.OutputStream r12 = r10.getOutputStream()     // Catch:{ Throwable -> 0x0108 }
            r11.<init>(r12)     // Catch:{ Throwable -> 0x0108 }
            r11.write(r14)     // Catch:{ Throwable -> 0x0108 }
            r11.close()     // Catch:{ Throwable -> 0x0108 }
        L_0x005c:
            r10.connect()     // Catch:{ Throwable -> 0x0108 }
            int r11 = r10.getResponseCode()     // Catch:{ Throwable -> 0x0108 }
            r12 = 200(0xc8, float:2.8E-43)
            if (r11 == r12) goto L_0x0069
            r12 = 1
            goto L_0x006a
        L_0x0069:
            r12 = 0
        L_0x006a:
            r14 = 206(0xce, float:2.89E-43)
            if (r11 == r14) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r9 = 0
        L_0x0070:
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0095
            com.loc.cx r9 = new com.loc.cx     // Catch:{ Throwable -> 0x0108 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r14 = "网络异常原因："
            r12.<init>(r14)     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r14 = r10.getResponseMessage()     // Catch:{ Throwable -> 0x0108 }
            r12.append(r14)     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r14 = " 网络异常状态码："
            r12.append(r14)     // Catch:{ Throwable -> 0x0108 }
            r12.append(r11)     // Catch:{ Throwable -> 0x0108 }
            java.lang.String r11 = r12.toString()     // Catch:{ Throwable -> 0x0108 }
            r9.<init>(r11)     // Catch:{ Throwable -> 0x0108 }
            r15.mo13007c()     // Catch:{ Throwable -> 0x0108 }
        L_0x0095:
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ Throwable -> 0x0108 }
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r11]     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
        L_0x009d:
            boolean r14 = java.lang.Thread.interrupted()     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            if (r14 != 0) goto L_0x00d6
            boolean r14 = r8.f2574f     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            if (r14 != 0) goto L_0x00d6
            int r14 = r9.read(r12, r13, r11)     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            if (r14 <= 0) goto L_0x00d6
            long r0 = r8.f2575g     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00bd
            long r0 = r8.f2576h     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            long r2 = r8.f2575g     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d6
        L_0x00bd:
            if (r14 != r11) goto L_0x00c5
            long r0 = r8.f2576h     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            r15.mo13006a(r12, r0)     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            goto L_0x00cf
        L_0x00c5:
            byte[] r0 = new byte[r14]     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            java.lang.System.arraycopy(r12, r13, r0, r13, r14)     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            long r1 = r8.f2576h     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            r15.mo13006a(r0, r1)     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
        L_0x00cf:
            long r0 = r8.f2576h     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            long r2 = (long) r14     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            long r0 = r0 + r2
            r8.f2576h = r0     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            goto L_0x009d
        L_0x00d6:
            boolean r11 = r8.f2574f     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            if (r11 == 0) goto L_0x00de
            r15.mo13009e()     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
            goto L_0x00e1
        L_0x00de:
            r15.mo13008d()     // Catch:{ Throwable -> 0x0102, all -> 0x00fe }
        L_0x00e1:
            if (r9 == 0) goto L_0x00ef
            r9.close()     // Catch:{ IOException | Throwable -> 0x00e7 }
            goto L_0x00ef
        L_0x00e7:
            r9 = move-exception
            java.lang.String r11 = "ht"
            java.lang.String r12 = "mdr"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r9, (java.lang.String) r11, (java.lang.String) r12)
        L_0x00ef:
            if (r10 == 0) goto L_0x011e
            r10.disconnect()     // Catch:{ Throwable -> 0x00f5 }
            return
        L_0x00f5:
            r9 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mdr"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
            return
        L_0x00fe:
            r11 = move-exception
            r0 = r9
            r9 = r11
            goto L_0x0120
        L_0x0102:
            r0 = r9
            goto L_0x0108
        L_0x0104:
            r9 = move-exception
            r10 = r0
            goto L_0x0120
        L_0x0107:
            r10 = r0
        L_0x0108:
            r15.mo13007c()     // Catch:{ all -> 0x011f }
            if (r0 == 0) goto L_0x0119
            r0.close()     // Catch:{ IOException | Throwable -> 0x0111 }
            goto L_0x0119
        L_0x0111:
            r9 = move-exception
            java.lang.String r11 = "ht"
            java.lang.String r12 = "mdr"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r9, (java.lang.String) r11, (java.lang.String) r12)
        L_0x0119:
            if (r10 == 0) goto L_0x011e
            r10.disconnect()     // Catch:{ Throwable -> 0x00f5 }
        L_0x011e:
            return
        L_0x011f:
            r9 = move-exception
        L_0x0120:
            if (r0 == 0) goto L_0x012e
            r0.close()     // Catch:{ IOException | Throwable -> 0x0126 }
            goto L_0x012e
        L_0x0126:
            r11 = move-exception
            java.lang.String r12 = "ht"
            java.lang.String r13 = "mdr"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.String) r13)
        L_0x012e:
            if (r10 == 0) goto L_0x013c
            r10.disconnect()     // Catch:{ Throwable -> 0x0134 }
            goto L_0x013c
        L_0x0134:
            r10 = move-exception
            java.lang.String r11 = "ht"
            java.lang.String r12 = "mdr"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r10, (java.lang.String) r11, (java.lang.String) r12)
        L_0x013c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.HttpUrlUtil.mo13012a(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, byte[], com.loc.ak$a):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo13013b() {
        this.f2575g = -1;
    }
}
