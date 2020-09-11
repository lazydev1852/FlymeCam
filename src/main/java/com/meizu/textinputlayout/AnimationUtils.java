package com.meizu.textinputlayout;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* renamed from: com.meizu.textinputlayout.a */
public class AnimationUtils {

    /* renamed from: a */
    static final Interpolator f16075a = new LinearInterpolator();

    /* renamed from: b */
    static final Interpolator f16076b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    static final Interpolator f16077c = new DecelerateInterpolator();

    /* renamed from: a */
    static float m17434a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
