package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* renamed from: com.android.volley.toolbox.a */
public class AdaptedHttpStack extends BaseHttpStack {

    /* renamed from: a */
    private final HttpStack f358a;

    AdaptedHttpStack(HttpStack iVar) {
        this.f358a = iVar;
    }

    /* renamed from: a */
    public HttpResponse mo8725a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        try {
            HttpResponse b = this.f358a.mo8726b(request, map);
            int statusCode = b.getStatusLine().getStatusCode();
            Header[] allHeaders = b.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new com.android.volley.Header(header.getName(), header.getValue()));
            }
            if (b.getEntity() == null) {
                return new HttpResponse(statusCode, arrayList);
            }
            long contentLength = b.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new HttpResponse(statusCode, arrayList, (int) b.getEntity().getContentLength(), b.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
