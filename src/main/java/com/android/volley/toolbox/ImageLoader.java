package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.android.volley.toolbox.k */
public class ImageLoader {

    /* renamed from: a */
    private final RequestQueue f390a;

    /* renamed from: b */
    private int f391b;

    /* renamed from: c */
    private final C0465b f392c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HashMap<String, C0464a> f393d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final HashMap<String, C0464a> f394e;

    /* renamed from: f */
    private final Handler f395f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f396g;

    /* renamed from: com.android.volley.toolbox.k$b */
    /* compiled from: ImageLoader */
    public interface C0465b {
        /* renamed from: a */
        Bitmap mo8759a(String str);

        /* renamed from: a */
        void mo8760a(String str, Bitmap bitmap);
    }

    /* renamed from: com.android.volley.toolbox.k$d */
    /* compiled from: ImageLoader */
    public interface C0467d extends Response.C0451a {
        /* renamed from: a */
        void mo8723a(C0466c cVar, boolean z);
    }

    @MainThread
    /* renamed from: a */
    public C0466c mo8750a(String str, C0467d dVar, int i, int i2, ImageView.ScaleType scaleType) {
        C0467d dVar2 = dVar;
        Threads.m722a();
        String a = m693a(str, i, i2, scaleType);
        Bitmap a2 = this.f392c.mo8759a(a);
        if (a2 != null) {
            C0466c cVar = new C0466c(a2, str, (String) null, (C0467d) null);
            dVar2.mo8723a(cVar, true);
            return cVar;
        }
        C0466c cVar2 = new C0466c((Bitmap) null, str, a, dVar);
        dVar2.mo8723a(cVar2, true);
        C0464a aVar = this.f393d.get(a);
        if (aVar != null) {
            aVar.mo8757a(cVar2);
            return cVar2;
        }
        Request<Bitmap> a3 = mo8749a(str, i, i2, scaleType, a);
        this.f390a.mo8703a(a3);
        this.f393d.put(a, new C0464a(a3, cVar2));
        return cVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request<Bitmap> mo8749a(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new ImageRequest(str, new Response.C0452b<Bitmap>() {
            /* renamed from: a */
            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.mo8751a(str2, bitmap);
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, new Response.C0451a() {
            public void onErrorResponse(VolleyError tVar) {
                ImageLoader.this.mo8752a(str2, tVar);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8751a(String str, Bitmap bitmap) {
        this.f392c.mo8760a(str, bitmap);
        C0464a remove = this.f393d.remove(str);
        if (remove != null) {
            Bitmap unused = remove.f403b = bitmap;
            m695a(str, remove);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8752a(String str, VolleyError tVar) {
        C0464a remove = this.f393d.remove(str);
        if (remove != null) {
            remove.mo8756a(tVar);
            m695a(str, remove);
        }
    }

    /* renamed from: com.android.volley.toolbox.k$c */
    /* compiled from: ImageLoader */
    public class C0466c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Bitmap f407b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C0467d f408c;

        /* renamed from: d */
        private final String f409d;

        /* renamed from: e */
        private final String f410e;

        public C0466c(Bitmap bitmap, String str, String str2, C0467d dVar) {
            this.f407b = bitmap;
            this.f410e = str;
            this.f409d = str2;
            this.f408c = dVar;
        }

        @MainThread
        /* renamed from: a */
        public void mo8761a() {
            Threads.m722a();
            if (this.f408c != null) {
                C0464a aVar = (C0464a) ImageLoader.this.f393d.get(this.f409d);
                if (aVar == null) {
                    C0464a aVar2 = (C0464a) ImageLoader.this.f394e.get(this.f409d);
                    if (aVar2 != null) {
                        aVar2.mo8758b(this);
                        if (aVar2.f405d.size() == 0) {
                            ImageLoader.this.f394e.remove(this.f409d);
                        }
                    }
                } else if (aVar.mo8758b(this)) {
                    ImageLoader.this.f393d.remove(this.f409d);
                }
            }
        }

        /* renamed from: b */
        public Bitmap mo8762b() {
            return this.f407b;
        }

        /* renamed from: c */
        public String mo8763c() {
            return this.f410e;
        }
    }

    /* renamed from: com.android.volley.toolbox.k$a */
    /* compiled from: ImageLoader */
    private static class C0464a {

        /* renamed from: a */
        private final Request<?> f402a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Bitmap f403b;

        /* renamed from: c */
        private VolleyError f404c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final List<C0466c> f405d = new ArrayList();

        public C0464a(Request<?> request, C0466c cVar) {
            this.f402a = request;
            this.f405d.add(cVar);
        }

        /* renamed from: a */
        public void mo8756a(VolleyError tVar) {
            this.f404c = tVar;
        }

        /* renamed from: a */
        public VolleyError mo8755a() {
            return this.f404c;
        }

        /* renamed from: a */
        public void mo8757a(C0466c cVar) {
            this.f405d.add(cVar);
        }

        /* renamed from: b */
        public boolean mo8758b(C0466c cVar) {
            this.f405d.remove(cVar);
            if (this.f405d.size() != 0) {
                return false;
            }
            this.f402a.cancel();
            return true;
        }
    }

    /* renamed from: a */
    private void m695a(String str, C0464a aVar) {
        this.f394e.put(str, aVar);
        if (this.f396g == null) {
            this.f396g = new Runnable() {
                public void run() {
                    for (C0464a aVar : ImageLoader.this.f394e.values()) {
                        for (C0466c cVar : aVar.f405d) {
                            if (cVar.f408c != null) {
                                if (aVar.mo8755a() == null) {
                                    Bitmap unused = cVar.f407b = aVar.f403b;
                                    cVar.f408c.mo8723a(cVar, false);
                                } else {
                                    cVar.f408c.onErrorResponse(aVar.mo8755a());
                                }
                            }
                        }
                    }
                    ImageLoader.this.f394e.clear();
                    Runnable unused2 = ImageLoader.this.f396g = null;
                }
            };
            this.f395f.postDelayed(this.f396g, (long) this.f391b);
        }
    }

    /* renamed from: a */
    private static String m693a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
