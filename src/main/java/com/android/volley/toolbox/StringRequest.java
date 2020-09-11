package com.android.volley.toolbox;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

/* renamed from: com.android.volley.toolbox.n */
public class StringRequest extends Request<String> {
    @GuardedBy("mLock")
    @Nullable
    private Response.C0452b<String> mListener;
    private final Object mLock;

    public StringRequest(int i, String str, Response.C0452b<String> bVar, @Nullable Response.C0451a aVar) {
        super(i, str, aVar);
        this.mLock = new Object();
        this.mListener = bVar;
    }

    public StringRequest(String str, Response.C0452b<String> bVar, @Nullable Response.C0451a aVar) {
        this(0, str, bVar, aVar);
    }

    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(String str) {
        Response.C0452b<String> bVar;
        synchronized (this.mLock) {
            bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.onResponse(str);
        }
    }

    /* access modifiers changed from: protected */
    public Response<String> parseNetworkResponse(NetworkResponse kVar) {
        String str;
        try {
            str = new String(kVar.f326b, HttpHeaderParser.m671a(kVar.f327c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.f326b);
        }
        return Response.m610a(str, HttpHeaderParser.m669a(kVar));
    }
}
