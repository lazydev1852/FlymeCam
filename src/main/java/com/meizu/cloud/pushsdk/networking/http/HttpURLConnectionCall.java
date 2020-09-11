package com.meizu.cloud.pushsdk.networking.http;

import android.content.Context;
import com.meizu.cloud.pushsdk.networking.common.ANLog;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.okio.BufferedSink;
import com.meizu.cloud.pushsdk.networking.okio.BufferedSource;
import com.meizu.cloud.pushsdk.networking.okio.Okio;
import com.meizu.cloud.pushsdk.networking.ssl.SSLExtensionSocketFactory;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionCall implements Call {
    SSLExtensionSocketFactory sslExtensionSocketFactory = new SSLExtensionSocketFactory((Context) null);

    protected static boolean isSuccessfulSend(int i) {
        return i >= 200 && i < 300;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isExecuted() {
        return false;
    }

    public Response execute(Request request) throws IOException {
        HttpURLConnection openConnection = openConnection(request);
        for (String next : request.headers().names()) {
            String header = request.header(next);
            ANLog.m4848i("current header name " + next + " value " + header);
            openConnection.addRequestProperty(next, header);
        }
        setConnectionParametersForRequest(openConnection, request);
        int responseCode = openConnection.getResponseCode();
        return new Response.Builder().code(responseCode).headers(request.headers()).message(openConnection.getResponseMessage()).request(request).body(createOkBody(openConnection)).build();
    }

    private static ResponseBody createOkBody(final HttpURLConnection httpURLConnection) throws IOException {
        if (!httpURLConnection.getDoInput()) {
            return null;
        }
        final BufferedSource buffer = Okio.buffer(Okio.source(isSuccessfulSend(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
        return new ResponseBody() {
            public MediaType contentType() {
                String contentType = httpURLConnection.getContentType();
                if (contentType == null) {
                    return null;
                }
                return MediaType.parse(contentType);
            }

            public long contentLength() {
                return HttpURLConnectionCall.stringToLong(httpURLConnection.getHeaderField(HTTP.CONTENT_LEN));
            }

            public BufferedSource source() {
                return buffer;
            }
        };
    }

    /* access modifiers changed from: private */
    public static long stringToLong(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private HttpURLConnection openConnection(Request request) throws IOException {
        String httpUrl = request.url().toString();
        HttpURLConnection createConnection = createConnection(new URL(httpUrl));
        createConnection.setConnectTimeout(60000);
        createConnection.setReadTimeout(60000);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        if (request.isHttps() && httpUrl.startsWith("https://api-push.meizu.com")) {
            ((HttpsURLConnection) createConnection).setSSLSocketFactory(this.sslExtensionSocketFactory);
        }
        return createConnection;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, Request request) throws IOException {
        switch (request.getmethod()) {
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("PATCH");
                addBodyIfExists(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void addBodyIfExists(HttpURLConnection httpURLConnection, Request request) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HTTP.CONTENT_TYPE, body.contentType().toString());
            BufferedSink buffer = Okio.buffer(Okio.sink(httpURLConnection.getOutputStream()));
            body.writeTo(buffer);
            buffer.close();
        }
    }
}
