package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FlymeListView extends ListView {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static float f5241e = Float.MAX_VALUE;

    /* renamed from: a */
    private float f5242a;

    /* renamed from: b */
    private float f5243b;

    /* renamed from: c */
    private C1437c f5244c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1435a f5245d;

    /* renamed from: f */
    private float f5246f = f5241e;

    /* renamed from: g */
    private HashSet<View> f5247g;

    /* renamed from: h */
    private boolean f5248h = false;

    /* renamed from: com.meizu.common.widget.FlymeListView$a */
    public interface C1435a {
        /* renamed from: a */
        void mo16672a(int i, HashSet hashSet);
    }

    public FlymeListView(Context context) {
        super(context);
    }

    public FlymeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlymeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setEnableParallax(boolean z) {
        if (z) {
            if (this.f5244c == null) {
                this.f5244c = new C1437c();
            }
            if (this.f5247g == null) {
                this.f5247g = new HashSet<>();
            }
        }
        this.f5248h = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f5248h) {
            this.f5242a = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.f5243b = this.f5242a;
                    this.f5246f = 0.0f;
                    this.f5244c.mo16691c();
                    if (this.f5244c.mo16690b()) {
                        this.f5244c.mo16688a(false);
                        if (this.f5245d != null) {
                            this.f5245d.mo16672a(1, getViewHoldSet());
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.f5246f != f5241e) {
                        this.f5244c.mo16684a();
                        break;
                    }
                    break;
                case 2:
                    if (this.f5246f != f5241e) {
                        if (canScrollVertically(1) && this.f5243b - this.f5242a > 15.0f) {
                            this.f5246f += this.f5243b - this.f5242a;
                        } else if (canScrollVertically(-1) && this.f5243b - this.f5242a < -15.0f) {
                            this.f5246f += this.f5243b - this.f5242a;
                        }
                        this.f5244c.mo16685a(this.f5246f);
                        break;
                    }
                    break;
            }
            this.f5243b = this.f5242a;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public HashSet getViewHoldSet() {
        return this.f5247g;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null && this.f5244c != null) {
            this.f5244c.mo16687a(timeInterpolator);
        }
    }

    public void setBaseDuration(int i) {
        if (this.f5244c != null) {
            this.f5244c.mo16689b(i);
        }
    }

    public void setScrollSensitivity(int i) {
        if (this.f5244c != null) {
            this.f5244c.mo16686a(i);
        }
    }

    public void setParallaxAnimationListener(C1435a aVar) {
        this.f5245d = aVar;
    }

    /* renamed from: com.meizu.common.widget.FlymeListView$c */
    class C1437c {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public HashMap<View, C1436b> f5259b = new HashMap<>();

        /* renamed from: c */
        private ArrayList<C1436b> f5260c = new ArrayList<>();

        /* renamed from: d */
        private TimeInterpolator f5261d = new LinearInterpolator();

        /* renamed from: e */
        private int f5262e = 500;

        /* renamed from: f */
        private ValueAnimator f5263f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f5264g = 3;

        /* renamed from: h */
        private float f5265h = 0.0f;

        /* renamed from: i */
        private int f5266i = 5;

        /* renamed from: j */
        private int f5267j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f5268k = true;

        C1437c() {
        }

        /* renamed from: a */
        public void mo16685a(float f) {
            if (f != 0.0f || this.f5264g != 3) {
                this.f5264g = 3;
                this.f5265h = 0.0f;
                for (C1436b next : this.f5259b.values()) {
                    float a = m5742a(next, f);
                    if (a > 0.0f) {
                        this.f5264g = 1;
                        this.f5265h = Math.abs(a / next.mo16677c());
                    } else if (a < 0.0f) {
                        this.f5264g = 2;
                        this.f5265h = Math.abs(a / next.mo16679d());
                    }
                    next.mo16674a(a);
                }
            }
        }

        /* renamed from: a */
        private float m5742a(C1436b bVar, float f) {
            float c;
            float a;
            float f2 = 0.0f;
            int i = (bVar.mo16683g() > 0.0f ? 1 : (bVar.mo16683g() == 0.0f ? 0 : -1));
            if (i == 0) {
                if (f > 0.0f) {
                    if (bVar.mo16677c() == 0.0f) {
                        return 0.0f;
                    }
                    float f3 = bVar.mo16682f();
                    if (f3 < 0.0f) {
                        f3 *= Math.abs(bVar.mo16677c() / bVar.mo16679d());
                    }
                    a = f3 + (bVar.mo16675b() * (f / ((float) this.f5266i)));
                    if (a > bVar.mo16677c()) {
                        c = bVar.mo16677c();
                    }
                } else if (bVar.mo16679d() == 0.0f) {
                    return 0.0f;
                } else {
                    float f4 = bVar.mo16682f();
                    if (f4 > 0.0f) {
                        f4 *= Math.abs(bVar.mo16679d() / bVar.mo16677c());
                    }
                    a = f4 + (bVar.mo16673a() * (f / ((float) this.f5266i)));
                    if (a < bVar.mo16679d()) {
                        c = bVar.mo16679d();
                    }
                }
                return a;
            } else if (i > 0) {
                if (bVar.mo16677c() == 0.0f) {
                    return 0.0f;
                }
                float f5 = bVar.mo16682f();
                if (f5 < 0.0f) {
                    f5 *= Math.abs(bVar.mo16677c() / bVar.mo16679d());
                }
                float b = f5 + (bVar.mo16675b() * (f / ((float) this.f5266i)));
                if (b < 0.0f) {
                    b = 0.0f;
                }
                if (b <= bVar.mo16677c()) {
                    return b;
                }
                c = bVar.mo16677c();
            } else if (bVar.mo16679d() == 0.0f) {
                return 0.0f;
            } else {
                float f6 = bVar.mo16682f();
                if (f6 > 0.0f) {
                    f6 *= Math.abs(bVar.mo16679d() / bVar.mo16677c());
                }
                float a2 = f6 + (bVar.mo16673a() * (f / ((float) this.f5266i)));
                if (a2 <= 0.0f) {
                    f2 = a2;
                }
                return f2 < bVar.mo16679d() ? bVar.mo16679d() : f2;
            }
            return c;
        }

        /* renamed from: a */
        public void mo16684a() {
            if (this.f5264g == 3) {
                mo16692d();
                this.f5268k = true;
                if (FlymeListView.this.f5245d != null) {
                    FlymeListView.this.f5245d.mo16672a(3, FlymeListView.this.getViewHoldSet());
                    return;
                }
                return;
            }
            this.f5267j = (int) (((float) this.f5262e) * this.f5265h);
            for (C1436b next : this.f5259b.values()) {
                next.mo16676b(next.mo16683g());
            }
            this.f5263f = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.f5263f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (C1436b bVar : C1437c.this.f5259b.values()) {
                        bVar.mo16674a(((Float) valueAnimator.getAnimatedValue()).floatValue() * bVar.mo16681e());
                    }
                }
            });
            this.f5263f.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = C1437c.this.f5268k = true;
                    for (C1436b bVar : C1437c.this.f5259b.values()) {
                        bVar.mo16678c(bVar.mo16683g());
                        if (bVar.mo16683g() != 0.0f) {
                            boolean unused2 = C1437c.this.f5268k = false;
                        } else {
                            bVar.mo16680d(FlymeListView.f5241e);
                        }
                    }
                    if (C1437c.this.f5268k) {
                        int unused3 = C1437c.this.f5264g = 3;
                    }
                    if (C1437c.this.f5268k && FlymeListView.this.f5245d != null) {
                        FlymeListView.this.f5245d.mo16672a(3, FlymeListView.this.getViewHoldSet());
                    }
                }
            });
            this.f5263f.setDuration((long) this.f5267j);
            this.f5263f.setInterpolator(this.f5261d);
            this.f5263f.start();
        }

        /* renamed from: b */
        public boolean mo16690b() {
            return this.f5268k;
        }

        /* renamed from: a */
        public void mo16688a(boolean z) {
            this.f5268k = z;
        }

        /* renamed from: c */
        public void mo16691c() {
            if (this.f5263f != null && this.f5263f.isRunning()) {
                this.f5263f.cancel();
            }
        }

        /* renamed from: a */
        public void mo16686a(int i) {
            this.f5266i = i;
        }

        /* renamed from: a */
        public void mo16687a(TimeInterpolator timeInterpolator) {
            this.f5261d = timeInterpolator;
        }

        /* renamed from: b */
        public void mo16689b(int i) {
            this.f5262e = i;
        }

        /* renamed from: d */
        public void mo16692d() {
            for (C1436b d : this.f5259b.values()) {
                d.mo16680d(FlymeListView.f5241e);
            }
        }
    }

    /* renamed from: com.meizu.common.widget.FlymeListView$b */
    class C1436b {

        /* renamed from: a */
        private View f5249a;

        /* renamed from: b */
        private float f5250b;

        /* renamed from: c */
        private float f5251c;

        /* renamed from: d */
        private float f5252d;

        /* renamed from: e */
        private float f5253e;

        /* renamed from: f */
        private float f5254f;

        /* renamed from: g */
        private float f5255g;

        /* renamed from: h */
        private float f5256h;

        /* renamed from: i */
        private float f5257i;

        /* renamed from: a */
        public float mo16673a() {
            return this.f5250b;
        }

        /* renamed from: b */
        public float mo16675b() {
            return this.f5251c;
        }

        /* renamed from: a */
        public void mo16674a(float f) {
            if (this.f5249a != null) {
                if (this.f5257i == FlymeListView.f5241e) {
                    this.f5257i = this.f5249a.getTranslationY();
                }
                this.f5256h = f;
                this.f5249a.setTranslationY(this.f5257i + f);
            }
        }

        /* renamed from: c */
        public float mo16677c() {
            return this.f5252d;
        }

        /* renamed from: d */
        public float mo16679d() {
            return this.f5253e;
        }

        /* renamed from: b */
        public void mo16676b(float f) {
            this.f5254f = f;
        }

        /* renamed from: c */
        public void mo16678c(float f) {
            this.f5255g = f;
        }

        /* renamed from: e */
        public float mo16681e() {
            return this.f5254f;
        }

        /* renamed from: f */
        public float mo16682f() {
            return this.f5255g;
        }

        /* renamed from: g */
        public float mo16683g() {
            return this.f5256h;
        }

        /* renamed from: d */
        public void mo16680d(float f) {
            this.f5257i = f;
        }
    }
}
