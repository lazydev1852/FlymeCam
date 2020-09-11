package com.meizu.savior.net;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.baidu.p020ar.util.IoUtils;
import java.io.UnsupportedEncodingException;

public class Utf8StringRequest extends StringRequest {
    public Utf8StringRequest(int i, String str, Response.C0452b<String> bVar, Response.C0451a aVar) {
        super(i, str, bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public Response<String> parseNetworkResponse(NetworkResponse kVar) {
        String str;
        try {
            str = new String(kVar.f326b, IoUtils.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str = null;
        }
        return Response.m610a(str, HttpHeaderParser.m669a(kVar));
    }
}
