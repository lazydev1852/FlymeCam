package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.android.volley.b */
public interface Cache {
    /* renamed from: a */
    C0443a mo8676a(String str);

    /* renamed from: a */
    void mo8677a();

    /* renamed from: a */
    void mo8678a(String str, C0443a aVar);

    /* renamed from: com.android.volley.b$a */
    /* compiled from: Cache */
    public static class C0443a {

        /* renamed from: a */
        public byte[] f289a;

        /* renamed from: b */
        public String f290b;

        /* renamed from: c */
        public long f291c;

        /* renamed from: d */
        public long f292d;

        /* renamed from: e */
        public long f293e;

        /* renamed from: f */
        public long f294f;

        /* renamed from: g */
        public Map<String, String> f295g = Collections.emptyMap();

        /* renamed from: h */
        public List<Header> f296h;

        /* renamed from: a */
        public boolean mo8679a() {
            return this.f293e < System.currentTimeMillis();
        }

        /* renamed from: b */
        public boolean mo8680b() {
            return this.f294f < System.currentTimeMillis();
        }
    }
}
