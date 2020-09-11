package com.meizu.textinputlayout;

import android.os.Build;
import com.meizu.textinputlayout.ValueAnimatorCompat;

/* renamed from: com.meizu.textinputlayout.h */
public class ViewUtils {

    /* renamed from: a */
    static final ValueAnimatorCompat.C2967b f16130a = new ValueAnimatorCompat.C2967b() {
        /* renamed from: a */
        public ValueAnimatorCompat mo24670a() {
            return new ValueAnimatorCompat(Build.VERSION.SDK_INT >= 12 ? new ValueAnimatorCompatImplHoneycombMr1() : new ValueAnimatorCompatImplEclairMr1());
        }
    };

    /* renamed from: b */
    private static final C2974a f16131b;

    /* renamed from: com.meizu.textinputlayout.h$a */
    /* compiled from: ViewUtils */
    private interface C2974a {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f16131b = new C2976c();
        } else {
            f16131b = new C2975b();
        }
    }

    /* renamed from: com.meizu.textinputlayout.h$b */
    /* compiled from: ViewUtils */
    private static class C2975b implements C2974a {
        private C2975b() {
        }
    }

    /* renamed from: com.meizu.textinputlayout.h$c */
    /* compiled from: ViewUtils */
    private static class C2976c implements C2974a {
        private C2976c() {
        }
    }

    /* renamed from: a */
    static ValueAnimatorCompat m17511a() {
        return f16130a.mo24670a();
    }
}
