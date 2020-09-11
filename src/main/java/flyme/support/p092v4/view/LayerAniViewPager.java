package flyme.support.p092v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import flyme.support.p092v4.view.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: flyme.support.v4.view.LayerAniViewPager */
public class LayerAniViewPager extends ViewPager {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static float f16439f = Float.MAX_VALUE;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3044c f16440a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f16441b = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f16442c = -1.0f;

    /* renamed from: d */
    private float f16443d = -100.0f;

    /* renamed from: e */
    private float f16444e = 100.0f;

    /* renamed from: g */
    private HashSet<View> f16445g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f16446h = false;

    /* renamed from: i */
    private C3042a f16447i = null;

    /* renamed from: j */
    private float f16448j = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f16449k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f16450l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f16451m = 0;

    public LayerAniViewPager(Context context) {
        super(context);
    }

    public LayerAniViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                LayerAniViewPager.this.removeOnLayoutChangeListener(this);
                if (LayerAniViewPager.this.f16441b < 0.0f) {
                    float unused = LayerAniViewPager.this.f16441b = (float) (-view.getWidth());
                }
                if (LayerAniViewPager.this.f16442c < 0.0f) {
                    float unused2 = LayerAniViewPager.this.f16442c = (float) view.getWidth();
                }
            }
        });
    }

    public void setEnableLayerAni(boolean z) {
        if (z) {
            if (this.f16440a == null) {
                this.f16440a = new C3044c();
            }
            if (this.f16445g == null) {
                this.f16445g = new HashSet<>();
            }
            if (this.f16447i == null) {
                this.f16447i = new C3042a();
                mo24936a((ViewPager.C3054e) this.f16447i);
            }
        }
        this.f16446h = z;
    }

    public void setMaxLeftOffset(float f) {
        this.f16441b = f;
    }

    public void setMaxRightOffset(float f) {
        this.f16442c = f;
    }

    /* renamed from: flyme.support.v4.view.LayerAniViewPager$a */
    private class C3042a implements ViewPager.C3054e {

        /* renamed from: b */
        private boolean f16454b;

        private C3042a() {
            this.f16454b = false;
        }

        /* renamed from: a */
        public void mo17730a(int i, float f, int i2) {
            if (LayerAniViewPager.this.f16446h) {
                if (!this.f16454b) {
                    this.f16454b = true;
                    LayerAniViewPager.this.mo24887a();
                }
                int unused = LayerAniViewPager.this.f16449k = (LayerAniViewPager.this.getWidth() - LayerAniViewPager.this.getPaddingLeft()) - LayerAniViewPager.this.getPaddingRight();
                int unused2 = LayerAniViewPager.this.f16450l = i;
                LayerAniViewPager.this.f16440a.mo24928a((float) i2);
            }
        }

        /* renamed from: a */
        public void mo17729a(int i) {
            int unused = LayerAniViewPager.this.f16451m = i;
        }

        /* renamed from: b */
        public void mo17731b(int i) {
            if (i == 0) {
                this.f16454b = false;
            }
        }
    }

    public void setScrollSensitivity(float f) {
        this.f16448j = f;
    }

    public HashSet getViewHoldSet() {
        return this.f16445g;
    }

    /* renamed from: flyme.support.v4.view.LayerAniViewPager$c */
    class C3044c {

        /* renamed from: b */
        private HashMap<View, C3043b> f16462b = new HashMap<>();

        /* renamed from: c */
        private ArrayList<C3043b> f16463c = new ArrayList<>();

        C3044c() {
        }

        /* renamed from: a */
        public void mo24928a(float f) {
            float f2;
            float f3;
            for (C3043b next : this.f16462b.values()) {
                if (next.mo24923b() != null) {
                    int intValue = ((Integer) next.mo24923b().getTag()).intValue();
                    if (intValue >= LayerAniViewPager.this.f16450l + 2) {
                        f2 = f;
                    } else if (intValue == LayerAniViewPager.this.f16450l + 1) {
                        f2 = ((float) LayerAniViewPager.this.f16449k) - f;
                    } else if (intValue == LayerAniViewPager.this.f16450l) {
                        f2 = -f;
                    } else {
                        f2 = -(((float) LayerAniViewPager.this.f16449k) - f);
                    }
                    if (f2 < 0.0f) {
                        f3 = ((-next.mo24925c()) * f2) / ((float) LayerAniViewPager.this.f16449k);
                    } else {
                        f3 = (next.mo24926d() * f2) / ((float) LayerAniViewPager.this.f16449k);
                    }
                    if (intValue >= LayerAniViewPager.this.f16450l - 1 && intValue <= LayerAniViewPager.this.f16450l + 2) {
                        next.mo24922a((float) ((int) f3));
                    }
                }
            }
        }

        /* renamed from: a */
        public HashMap<View, C3043b> mo24927a() {
            return this.f16462b;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void mo24887a() {
        if (this.f16446h) {
            for (C3043b next : this.f16440a.mo24927a().values()) {
                if (((Integer) next.mo24923b().getTag()).intValue() == this.f16451m && next.mo24921a() > -1.0f && next.mo24921a() < 1.0f) {
                    next.mo24924b(f16439f);
                }
            }
        }
    }

    /* renamed from: flyme.support.v4.view.LayerAniViewPager$b */
    class C3043b {

        /* renamed from: a */
        private View f16455a;

        /* renamed from: b */
        private View f16456b;

        /* renamed from: c */
        private float f16457c;

        /* renamed from: d */
        private float f16458d;

        /* renamed from: e */
        private float f16459e;

        /* renamed from: f */
        private float f16460f;

        /* renamed from: a */
        public void mo24922a(float f) {
            if (this.f16455a != null) {
                if (this.f16460f == LayerAniViewPager.f16439f) {
                    this.f16460f = this.f16455a.getTranslationX();
                }
                this.f16457c = f;
                this.f16455a.setTranslationX(this.f16460f + this.f16457c);
            }
        }

        /* renamed from: a */
        public float mo24921a() {
            return this.f16457c;
        }

        /* renamed from: b */
        public void mo24924b(float f) {
            this.f16460f = f;
        }

        /* renamed from: b */
        public View mo24923b() {
            return this.f16456b;
        }

        /* renamed from: c */
        public float mo24925c() {
            return this.f16458d;
        }

        /* renamed from: d */
        public float mo24926d() {
            return this.f16459e;
        }
    }
}
