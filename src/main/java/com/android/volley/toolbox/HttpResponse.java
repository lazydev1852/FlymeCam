package com.android.volley.toolbox;

import com.android.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.android.volley.toolbox.h */
public final class HttpResponse {

    /* renamed from: a */
    private final int f383a;

    /* renamed from: b */
    private final List<Header> f384b;

    /* renamed from: c */
    private final int f385c;

    /* renamed from: d */
    private final InputStream f386d;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, (InputStream) null);
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f383a = i;
        this.f384b = list;
        this.f385c = i2;
        this.f386d = inputStream;
    }

    /* renamed from: a */
    public final int mo8742a() {
        return this.f383a;
    }

    /* renamed from: b */
    public final List<Header> mo8743b() {
        return Collections.unmodifiableList(this.f384b);
    }

    /* renamed from: c */
    public final int mo8744c() {
        return this.f385c;
    }

    /* renamed from: d */
    public final InputStream mo8745d() {
        return this.f386d;
    }
}
