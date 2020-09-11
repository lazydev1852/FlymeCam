package com.meizu.textinputlayout;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.textinputlayout.ValueAnimatorCompat;

/* renamed from: com.meizu.textinputlayout.f */
public class ValueAnimatorCompatImplEclairMr1 extends ValueAnimatorCompat.C2968c {

    /* renamed from: a */
    private static final Handler f16115a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private long f16116b;

    /* renamed from: c */
    private boolean f16117c;

    /* renamed from: d */
    private final int[] f16118d = new int[2];

    /* renamed from: e */
    private final float[] f16119e = new float[2];

    /* renamed from: f */
    private int f16120f = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: g */
    private Interpolator f16121g;

    /* renamed from: h */
    private ValueAnimatorCompat.C2968c.C2969a f16122h;

    /* renamed from: i */
    private ValueAnimatorCompat.C2968c.C2970b f16123i;

    /* renamed from: j */
    private float f16124j;

    /* renamed from: k */
    private final Runnable f16125k = new Runnable() {
        public void run() {
            ValueAnimatorCompatImplEclairMr1.this.m17493f();
        }
    };

    ValueAnimatorCompatImplEclairMr1() {
    }

    /* renamed from: a */
    public void mo24671a() {
        if (!this.f16117c) {
            if (this.f16121g == null) {
                this.f16121g = new AccelerateDecelerateInterpolator();
            }
            this.f16116b = SystemClock.uptimeMillis();
            this.f16117c = true;
            if (this.f16122h != null) {
                this.f16122h.mo24679a();
            }
            f16115a.postDelayed(this.f16125k, 10);
        }
    }

    /* renamed from: b */
    public boolean mo24676b() {
        return this.f16117c;
    }

    /* renamed from: a */
    public void mo24674a(Interpolator interpolator) {
        this.f16121g = interpolator;
    }

    /* renamed from: a */
    public void mo24675a(ValueAnimatorCompat.C2968c.C2970b bVar) {
        this.f16123i = bVar;
    }

    /* renamed from: a */
    public void mo24672a(float f, float f2) {
        this.f16119e[0] = f;
        this.f16119e[1] = f2;
    }

    /* renamed from: c */
    public float mo24677c() {
        return AnimationUtils.m17434a(this.f16119e[0], this.f16119e[1], mo24682e());
    }

    /* renamed from: a */
    public void mo24673a(int i) {
        this.f16120f = i;
    }

    /* renamed from: d */
    public void mo24678d() {
        this.f16117c = false;
        f16115a.removeCallbacks(this.f16125k);
        if (this.f16122h != null) {
            this.f16122h.mo24681c();
        }
    }

    /* renamed from: e */
    public float mo24682e() {
        return this.f16124j;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m17493f() {
        if (this.f16117c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f16116b)) / ((float) this.f16120f);
            if (this.f16121g != null) {
                uptimeMillis = this.f16121g.getInterpolation(uptimeMillis);
            }
            this.f16124j = uptimeMillis;
            if (this.f16123i != null) {
                this.f16123i.mo24669a();
            }
            if (SystemClock.uptimeMillis() >= this.f16116b + ((long) this.f16120f)) {
                this.f16117c = false;
                if (this.f16122h != null) {
                    this.f16122h.mo24680b();
                }
            }
        }
        if (this.f16117c) {
            f16115a.postDelayed(this.f16125k, 10);
        }
    }
}
