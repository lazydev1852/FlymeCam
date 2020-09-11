package com.meizu.media.camera.p071h;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.baidu.p020ar.util.IoUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.UnsupportedEncodingException;

/* renamed from: com.meizu.media.camera.h.d */
public class Utf8StringRequest extends StringRequest {

    /* renamed from: d */
    public static ChangeQuickRedirect f10393d;

    public Utf8StringRequest(int i, String str, Response.C0452b<String> bVar, Response.C0451a aVar) {
        super(i, str, bVar, aVar);
    }

    public Response<String> parseNetworkResponse(NetworkResponse kVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{kVar}, this, f10393d, false, 5395, new Class[]{NetworkResponse.class}, Response.class);
        if (proxy.isSupported) {
            return (Response) proxy.result;
        }
        String str = null;
        try {
            str = new String(kVar.f326b, IoUtils.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Response.m610a(str, HttpHeaderParser.m669a(kVar));
    }
}
