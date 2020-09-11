package com.android.volley;

import com.android.volley.Cache;

/* renamed from: com.android.volley.o */
public class Response<T> {

    /* renamed from: a */
    public final T f343a;

    /* renamed from: b */
    public final Cache.C0443a f344b;

    /* renamed from: c */
    public final VolleyError f345c;

    /* renamed from: d */
    public boolean f346d;

    /* renamed from: com.android.volley.o$a */
    /* compiled from: Response */
    public interface C0451a {
        void onErrorResponse(VolleyError tVar);
    }

    /* renamed from: com.android.volley.o$b */
    /* compiled from: Response */
    public interface C0452b<T> {
        void onResponse(T t);
    }

    /* renamed from: a */
    public static <T> Response<T> m610a(T t, Cache.C0443a aVar) {
        return new Response<>(t, aVar);
    }

    /* renamed from: a */
    public static <T> Response<T> m609a(VolleyError tVar) {
        return new Response<>(tVar);
    }

    /* renamed from: a */
    public boolean mo8712a() {
        return this.f345c == null;
    }

    private Response(T t, Cache.C0443a aVar) {
        this.f346d = false;
        this.f343a = t;
        this.f344b = aVar;
        this.f345c = null;
    }

    private Response(VolleyError tVar) {
        this.f346d = false;
        this.f343a = null;
        this.f344b = null;
        this.f345c = tVar;
    }
}
