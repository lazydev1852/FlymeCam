package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

@Deprecated
/* renamed from: com.android.volley.toolbox.i */
public interface HttpStack {
    /* renamed from: b */
    HttpResponse mo8726b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
