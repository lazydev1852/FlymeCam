package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* renamed from: com.android.volley.toolbox.b */
public abstract class BaseHttpStack implements HttpStack {
    /* renamed from: a */
    public abstract HttpResponse mo8725a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;

    @Deprecated
    /* renamed from: b */
    public final HttpResponse mo8726b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpResponse a = mo8725a(request, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), a.mo8742a(), ""));
        ArrayList arrayList = new ArrayList();
        for (Header next : a.mo8743b()) {
            arrayList.add(new BasicHeader(next.mo8694a(), next.mo8695b()));
        }
        basicHttpResponse.setHeaders((org.apache.http.Header[]) arrayList.toArray(new org.apache.http.Header[arrayList.size()]));
        InputStream d = a.mo8745d();
        if (d != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(d);
            basicHttpEntity.setContentLength((long) a.mo8744c());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
