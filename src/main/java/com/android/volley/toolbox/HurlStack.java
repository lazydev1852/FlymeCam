package com.android.volley.toolbox;

import androidx.annotation.VisibleForTesting;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.android.volley.toolbox.j */
public class HurlStack extends BaseHttpStack {

    /* renamed from: a */
    private final C0460b f387a;

    /* renamed from: b */
    private final SSLSocketFactory f388b;

    /* renamed from: com.android.volley.toolbox.j$b */
    /* compiled from: HurlStack */
    public interface C0460b {
        /* renamed from: a */
        String mo8748a(String str);
    }

    /* renamed from: a */
    private static boolean m686a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public HurlStack() {
        this((C0460b) null);
    }

    public HurlStack(C0460b bVar) {
        this(bVar, (SSLSocketFactory) null);
    }

    public HurlStack(C0460b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f387a = bVar;
        this.f388b = sSLSocketFactory;
    }

    /* renamed from: a */
    public HttpResponse mo8725a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String str;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        if (this.f387a != null) {
            str = this.f387a.mo8748a(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        } else {
            str = url;
        }
        HttpURLConnection a = m682a(new URL(str), request);
        boolean z = false;
        try {
            for (String str2 : hashMap.keySet()) {
                a.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            m684a(a, request);
            int responseCode = a.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } else if (!m686a(request.getMethod(), responseCode)) {
                HttpResponse hVar = new HttpResponse(responseCode, m683a((Map<String, List<String>>) a.getHeaderFields()));
                a.disconnect();
                return hVar;
            } else {
                z = true;
                return new HttpResponse(responseCode, m683a((Map<String, List<String>>) a.getHeaderFields()), a.getContentLength(), new C0459a(a));
            }
        } catch (Throwable th) {
            if (!z) {
                a.disconnect();
            }
            throw th;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static List<Header> m683a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String gVar : (List) next.getValue()) {
                    arrayList.add(new Header((String) next.getKey(), gVar));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: com.android.volley.toolbox.j$a */
    /* compiled from: HurlStack */
    static class C0459a extends FilterInputStream {

        /* renamed from: a */
        private final HttpURLConnection f389a;

        C0459a(HttpURLConnection httpURLConnection) {
            super(HurlStack.m687b(httpURLConnection));
            this.f389a = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            this.f389a.disconnect();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static InputStream m687b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo8746a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    /* renamed from: a */
    private HttpURLConnection m682a(URL url, Request<?> request) throws IOException {
        HttpURLConnection a = mo8746a(url);
        int timeoutMs = request.getTimeoutMs();
        a.setConnectTimeout(timeoutMs);
        a.setReadTimeout(timeoutMs);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f388b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f388b);
        }
        return a;
    }

    /* renamed from: a */
    static void m684a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    m685a(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m688b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m688b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m688b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: b */
    private static void m688b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            m685a(httpURLConnection, request, body);
        }
    }

    /* renamed from: a */
    private static void m685a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey(HTTP.CONTENT_TYPE)) {
            httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
