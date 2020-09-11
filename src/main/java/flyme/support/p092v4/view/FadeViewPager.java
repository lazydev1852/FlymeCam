package flyme.support.p092v4.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: flyme.support.v4.view.FadeViewPager */
public class FadeViewPager extends ViewPager {

    /* renamed from: a */
    ValueAnimator f16432a;

    /* renamed from: b */
    int f16433b;

    /* renamed from: c */
    int f16434c;

    /* renamed from: d */
    Interpolator f16435d;

    /* renamed from: e */
    Interpolator f16436e;

    /* renamed from: f */
    ArrayList<View> f16437f;

    /* renamed from: g */
    Boolean f16438g;

    public FadeViewPager(Context context) {
        super(context);
        m18045a();
    }

    public FadeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18045a();
    }

    /* renamed from: a */
    private void m18045a() {
        this.f16438g = false;
        this.f16433b = 80;
        this.f16434c = 80;
        this.f16435d = new AccelerateDecelerateInterpolator();
        this.f16436e = new AccelerateDecelerateInterpolator();
    }

    public void setFadeInTime(int i) {
        this.f16433b = i;
    }

    public void setFadeOutTime(int i) {
        this.f16434c = i;
    }

    public void setFadeInInterpolator(Interpolator interpolator) {
        this.f16435d = interpolator;
    }

    public void setFadeOutInterPolator(Interpolator interpolator) {
        this.f16436e = interpolator;
    }

    public void setShowWithOutAnimation() {
        m18046b();
        if (this.f16437f != null) {
            Iterator<View> it = this.f16437f.iterator();
            while (it.hasNext()) {
                it.next().setAlpha(1.0f);
            }
        }
    }

    /* renamed from: b */
    private void m18046b() {
        if (this.f16432a == null) {
            return;
        }
        if (this.f16432a.isStarted() || this.f16432a.isRunning()) {
            this.f16432a.cancel();
        }
    }
}
