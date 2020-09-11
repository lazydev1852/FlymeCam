package flyme.support.p093v7.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;

/* renamed from: flyme.support.v7.widget.AnimationUtils */
public class AnimationUtils {

    /* renamed from: a */
    public static final Interpolator f17551a = new LinearInterpolator();

    /* renamed from: b */
    public static final Interpolator f17552b = new DecelerateInterpolator();

    /* renamed from: c */
    public static final Interpolator f17553c = PathInterpolatorCompat.create(0.0f, 0.33f, 0.1f, 1.0f);

    /* renamed from: d */
    public static final Interpolator f17554d = PathInterpolatorCompat.create(0.0f, 0.66f, 0.66f, 1.0f);

    /* renamed from: a */
    public static int m19217a(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }

    /* renamed from: flyme.support.v7.widget.AnimationUtils$AlphaVisibilityAnimator */
    public static class AlphaVisibilityAnimator {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public View f17555a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ViewPropertyAnimatorCompat f17556b;

        /* renamed from: c */
        private VisibilityAnimListener f17557c = new VisibilityAnimListener();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public ViewPropertyAnimatorListener f17558d;

        public AlphaVisibilityAnimator(View view, int i) {
            this.f17555a = view;
            if (i == 0) {
                if (this.f17555a.getVisibility() != 0) {
                    ViewCompat.setAlpha(this.f17555a, 0.0f);
                }
                this.f17556b = ViewCompat.animate(this.f17555a).alpha(1.0f);
                this.f17556b.setDuration(100);
                this.f17556b.setListener(this.f17557c.mo26011a(this.f17556b, i));
                return;
            }
            this.f17556b = ViewCompat.animate(this.f17555a).alpha(0.0f);
            this.f17556b.setDuration(200);
            this.f17556b.setListener(this.f17557c.mo26011a(this.f17556b, i));
        }

        /* renamed from: flyme.support.v7.widget.AnimationUtils$AlphaVisibilityAnimator$VisibilityAnimListener */
        private class VisibilityAnimListener implements ViewPropertyAnimatorListener {

            /* renamed from: a */
            int f17559a;

            /* renamed from: c */
            private boolean f17561c;

            private VisibilityAnimListener() {
                this.f17561c = false;
            }

            /* renamed from: a */
            public VisibilityAnimListener mo26011a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
                ViewPropertyAnimatorCompat unused = AlphaVisibilityAnimator.this.f17556b = viewPropertyAnimatorCompat;
                this.f17559a = i;
                return this;
            }

            public void onAnimationStart(View view) {
                AlphaVisibilityAnimator.this.f17555a.setVisibility(0);
                this.f17561c = false;
                if (AlphaVisibilityAnimator.this.f17558d != null) {
                    AlphaVisibilityAnimator.this.f17558d.onAnimationStart(view);
                }
            }

            public void onAnimationEnd(View view) {
                if (!this.f17561c) {
                    ViewPropertyAnimatorCompat unused = AlphaVisibilityAnimator.this.f17556b = null;
                    AlphaVisibilityAnimator.this.f17555a.setVisibility(this.f17559a);
                    if (AlphaVisibilityAnimator.this.f17558d != null) {
                        AlphaVisibilityAnimator.this.f17558d.onAnimationEnd(view);
                    }
                }
            }

            public void onAnimationCancel(View view) {
                this.f17561c = true;
                if (AlphaVisibilityAnimator.this.f17558d != null) {
                    AlphaVisibilityAnimator.this.f17558d.onAnimationCancel(view);
                }
            }
        }

        /* renamed from: a */
        public void mo26006a() {
            if (this.f17556b != null) {
                this.f17556b.cancel();
            }
        }

        /* renamed from: a */
        public void mo26008a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            this.f17558d = viewPropertyAnimatorListener;
        }

        /* renamed from: a */
        public void mo26007a(int i) {
            if (this.f17556b != null) {
                this.f17556b.setDuration((long) i);
            }
        }

        /* renamed from: b */
        public ViewPropertyAnimatorCompat mo26009b() {
            return this.f17556b;
        }

        /* renamed from: c */
        public int mo26010c() {
            return this.f17557c.f17559a;
        }
    }
}
