package com.baidu.p020ar.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.baidu.ar.util.Res */
public class Res {

    /* renamed from: a */
    private static String f2373a;

    /* renamed from: b */
    private static Map<String, C0916a> f2374b = new HashMap();

    /* renamed from: com.baidu.ar.util.Res$a */
    private static class C0916a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Context f2377a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Context f2378b;

        public C0916a(Context context) {
            this.f2377a = context;
        }

        /* renamed from: a */
        public void mo10681a(Context context) {
            this.f2378b = context;
        }
    }

    /* renamed from: com.baidu.ar.util.Res$b */
    private static class C0917b {

        /* renamed from: a */
        private final C0916a f2379a;

        /* renamed from: b */
        private final int f2380b;

        public C0917b(C0916a aVar, int i) {
            this.f2379a = aVar;
            this.f2380b = i;
        }

        /* renamed from: j */
        private Resources m2736j() {
            return this.f2379a.f2377a.getResources();
        }

        /* renamed from: k */
        private LayoutInflater m2737k() {
            return LayoutInflater.from(this.f2379a.f2378b != null ? this.f2379a.f2378b : this.f2379a.f2377a);
        }

        /* renamed from: a */
        public View mo10682a(ViewGroup viewGroup, boolean z) {
            return m2737k().inflate(this.f2380b, viewGroup, z);
        }

        /* renamed from: a */
        public String mo10683a() {
            return m2736j().getString(this.f2380b);
        }

        /* renamed from: b */
        public int mo10684b() {
            return m2736j().getDimensionPixelSize(this.f2380b);
        }

        /* renamed from: c */
        public Drawable mo10685c() {
            return m2736j().getDrawable(this.f2380b);
        }

        /* renamed from: d */
        public Bitmap mo10686d() {
            return BitmapFactory.decodeResource(m2736j(), this.f2380b);
        }

        /* renamed from: e */
        public int mo10687e() {
            return m2736j().getColor(this.f2380b);
        }

        /* renamed from: f */
        public ColorStateList mo10688f() {
            return m2736j().getColorStateList(this.f2380b);
        }

        /* renamed from: g */
        public View mo10689g() {
            return m2737k().inflate(this.f2380b, (ViewGroup) null);
        }

        /* renamed from: h */
        public int mo10690h() {
            return this.f2380b;
        }

        /* renamed from: i */
        public Animation mo10691i() {
            return AnimationUtils.loadAnimation(this.f2379a.f2377a, this.f2380b);
        }
    }

    /* renamed from: a */
    private static int m2728a(Resources resources, String str, String str2, String str3) {
        try {
            return resources.getIdentifier(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    private static C0917b m2729a(String str, String str2) {
        for (String next : f2374b.keySet()) {
            C0916a aVar = f2374b.get(next);
            int a = m2728a(aVar.f2377a.getResources(), str, str2, next);
            if (a > 0) {
                return new C0917b(aVar, a);
            }
        }
        ARLog.m2696e("Can not found res, name:" + str + ", type:" + str2);
        return null;
    }

    /* renamed from: a */
    private static String m2730a() {
        return f2373a;
    }

    public static void addResource(Context context) {
        addResource(context, context.getPackageName());
    }

    public static void addResource(Context context, String str) {
        f2374b.put(str, new C0916a(context));
    }

    public static void addResource(Context context, String str, Context context2) {
        C0916a aVar = new C0916a(context);
        aVar.mo10681a(context2);
        f2374b.put(str, aVar);
    }

    /* renamed from: b */
    private static int m2731b(String str, String str2) {
        C0917b a = m2729a(str, str2);
        if (a != null) {
            return a.mo10690h();
        }
        return -1;
    }

    public static void clear() {
        f2374b.clear();
    }

    public static void clear(Context context) {
        boolean z;
        Iterator<String> it = f2374b.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (f2374b.get(it.next()).f2377a == context) {
                z = true;
                break;
            }
        }
        if (z) {
            clear();
        }
    }

    public static void clear(String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.equals(m2730a())) {
            clear(context);
        }
    }

    public static void clearDelay(final String str, final Context context) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Res.clear(str, context);
            }
        }, 1000);
    }

    public static Bitmap decodeBitmap(String str) {
        C0917b a = m2729a(str, "drawable");
        if (a != null) {
            return a.mo10686d();
        }
        return null;
    }

    public static View findViewById(View view, String str) {
        return view.findViewById(m2732id(str));
    }

    public static int getColor(String str) {
        C0917b a = m2729a(str, "color");
        if (a != null) {
            return a.mo10687e();
        }
        return 0;
    }

    public static ColorStateList getColorStateList(String str) {
        C0917b a = m2729a(str, "color");
        if (a != null) {
            return a.mo10688f();
        }
        return null;
    }

    public static int getDimensionPixelSize(String str) {
        C0917b a = m2729a(str, "dimen");
        if (a != null) {
            return a.mo10684b();
        }
        return 0;
    }

    public static Drawable getDrawable(String str) {
        C0917b a = m2729a(str, "drawable");
        if (a != null) {
            return a.mo10685c();
        }
        return null;
    }

    public static int getRaw(String str) {
        return m2731b(str, "raw");
    }

    public static String getString(String str) {
        C0917b a = m2729a(str, "string");
        if (a != null) {
            return a.mo10683a();
        }
        return null;
    }

    public static int getStyle(String str) {
        return m2731b(str, "style");
    }

    /* renamed from: id */
    public static int m2732id(String str) {
        C0917b a = m2729a(str, "id");
        if (a != null) {
            return a.mo10690h();
        }
        return -1;
    }

    public static View inflate(String str) {
        C0917b a = m2729a(str, "layout");
        if (a != null) {
            return a.mo10689g();
        }
        return null;
    }

    public static View inflate(String str, ViewGroup viewGroup, boolean z) {
        C0917b a = m2729a(str, "layout");
        if (a != null) {
            return a.mo10682a(viewGroup, z);
        }
        return null;
    }

    public static Animation loadAnimation(String str) {
        C0917b a = m2729a(str, "anim");
        if (a != null) {
            return a.mo10691i();
        }
        return null;
    }

    public static void removeResource(String str) {
        f2374b.remove(str);
    }

    public static void setFragmentHashCode(String str) {
        f2373a = str;
    }
}
