package com.meizu.textinputlayout;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.meizu.textinputlayout.ValueAnimatorCompat;

/* renamed from: com.meizu.textinputlayout.g */
public class ValueAnimatorCompatImplHoneycombMr1 extends ValueAnimatorCompat.C2968c {

    /* renamed from: a */
    final ValueAnimator f16127a = new ValueAnimator();

    ValueAnimatorCompatImplHoneycombMr1() {
    }

    /* renamed from: a */
    public void mo24671a() {
        this.f16127a.start();
    }

    /* renamed from: b */
    public boolean mo24676b() {
        return this.f16127a.isRunning();
    }

    /* renamed from: a */
    public void mo24674a(Interpolator interpolator) {
        this.f16127a.setInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo24675a(final ValueAnimatorCompat.C2968c.C2970b bVar) {
        this.f16127a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.mo24669a();
            }
        });
    }

    /* renamed from: a */
    public void mo24672a(float f, float f2) {
        this.f16127a.setFloatValues(new float[]{f, f2});
    }

    /* renamed from: c */
    public float mo24677c() {
        return ((Float) this.f16127a.getAnimatedValue()).floatValue();
    }

    /* renamed from: a */
    public void mo24673a(int i) {
        this.f16127a.setDuration((long) i);
    }

    /* renamed from: d */
    public void mo24678d() {
        this.f16127a.cancel();
    }
}
