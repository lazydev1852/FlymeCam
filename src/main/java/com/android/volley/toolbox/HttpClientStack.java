package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

@Deprecated
/* renamed from: com.android.volley.toolbox.f */
public class HttpClientStack implements HttpStack {

    /* renamed from: a */
    protected final HttpClient f382a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8740a(HttpUriRequest httpUriRequest) throws IOException {
    }

    public HttpClientStack(HttpClient httpClient) {
        this.f382a = httpClient;
    }

    /* renamed from: a */
    private static void m665a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    /* renamed from: b */
    public HttpResponse mo8726b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest a = m663a(request, map);
        m665a(a, map);
        m665a(a, request.getHeaders());
        mo8740a(a);
        HttpParams params = a.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.f382a.execute(a);
    }

    /* renamed from: a */
    static HttpUriRequest m663a(Request<?> request, Map<String, String> map) throws AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody == null) {
                    return new HttpGet(request.getUrl());
                }
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader(HTTP.CONTENT_TYPE, request.getPostBodyContentType());
                httpPost.setEntity(new ByteArrayEntity(postBody));
                return httpPost;
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader(HTTP.CONTENT_TYPE, request.getBodyContentType());
                m664a((HttpEntityEnclosingRequestBase) httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader(HTTP.CONTENT_TYPE, request.getBodyContentType());
                m664a((HttpEntityEnclosingRequestBase) httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                C0458a aVar = new C0458a(request.getUrl());
                aVar.addHeader(HTTP.CONTENT_TYPE, request.getBodyContentType());
                m664a((HttpEntityEnclosingRequestBase) aVar, request);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    /* renamed from: a */
    private static void m664a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    /* renamed from: com.android.volley.toolbox.f$a */
    /* compiled from: HttpClientStack */
    public static final class C0458a extends HttpEntityEnclosingRequestBase {
        public String getMethod() {
            return "PATCH";
        }

        public C0458a() {
        }

        public C0458a(String str) {
            setURI(URI.create(str));
        }
    }
}
