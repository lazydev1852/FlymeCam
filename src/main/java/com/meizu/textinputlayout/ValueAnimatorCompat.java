package com.meizu.textinputlayout;

import android.view.animation.Interpolator;

/* renamed from: com.meizu.textinputlayout.e */
public class ValueAnimatorCompat {

    /* renamed from: a */
    private final C2968c f16112a;

    /* renamed from: com.meizu.textinputlayout.e$a */
    /* compiled from: ValueAnimatorCompat */
    interface C2966a {
        /* renamed from: a */
        void mo24638a(ValueAnimatorCompat eVar);
    }

    /* renamed from: com.meizu.textinputlayout.e$b */
    /* compiled from: ValueAnimatorCompat */
    interface C2967b {
        /* renamed from: a */
        ValueAnimatorCompat mo24670a();
    }

    /* renamed from: com.meizu.textinputlayout.e$c */
    /* compiled from: ValueAnimatorCompat */
    static abstract class C2968c {

        /* renamed from: com.meizu.textinputlayout.e$c$a */
        /* compiled from: ValueAnimatorCompat */
        interface C2969a {
            /* renamed from: a */
            void mo24679a();

            /* renamed from: b */
            void mo24680b();

            /* renamed from: c */
            void mo24681c();
        }

        /* renamed from: com.meizu.textinputlayout.e$c$b */
        /* compiled from: ValueAnimatorCompat */
        interface C2970b {
            /* renamed from: a */
            void mo24669a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo24671a();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo24672a(float f, float f2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo24673a(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo24674a(Interpolator interpolator);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo24675a(C2970b bVar);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract boolean mo24676b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract float mo24677c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract void mo24678d();

        C2968c() {
        }
    }

    ValueAnimatorCompat(C2968c cVar) {
        this.f16112a = cVar;
    }

    /* renamed from: a */
    public void mo24661a() {
        this.f16112a.mo24671a();
    }

    /* renamed from: b */
    public boolean mo24666b() {
        return this.f16112a.mo24676b();
    }

    /* renamed from: a */
    public void mo24664a(Interpolator interpolator) {
        this.f16112a.mo24674a(interpolator);
    }

    /* renamed from: a */
    public void mo24665a(final C2966a aVar) {
        if (aVar != null) {
            this.f16112a.mo24675a((C2968c.C2970b) new C2968c.C2970b() {
                /* renamed from: a */
                public void mo24669a() {
                    aVar.mo24638a(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.f16112a.mo24675a((C2968c.C2970b) null);
        }
    }

    /* renamed from: a */
    public void mo24662a(float f, float f2) {
        this.f16112a.mo24672a(f, f2);
    }

    /* renamed from: c */
    public float mo24667c() {
        return this.f16112a.mo24677c();
    }

    /* renamed from: a */
    public void mo24663a(int i) {
        this.f16112a.mo24673a(i);
    }

    /* renamed from: d */
    public void mo24668d() {
        this.f16112a.mo24678d();
    }
}
