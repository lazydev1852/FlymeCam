package flyme.support.p093v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.ActionBarDropDownView */
public class ActionBarDropDownView extends FrameLayout {

    /* renamed from: a */
    private static final Interpolator f17421a = PathInterpolatorCompat.create(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: b */
    private static final Interpolator f17422b = PathInterpolatorCompat.create(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: c */
    private View f17423c;

    /* renamed from: d */
    private int f17424d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f17425e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ActionBar.C3073c f17426f;

    /* renamed from: g */
    private View f17427g;

    /* renamed from: h */
    private AnimatorSet f17428h;

    /* renamed from: i */
    private Animator.AnimatorListener f17429i;

    /* renamed from: j */
    private Animator.AnimatorListener f17430j;

    public ActionBarDropDownView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17424d = -1;
        this.f17425e = 1;
        this.f17429i = new AnimatorListenerAdapter() {

            /* renamed from: b */
            private boolean f17432b;

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.f17432b = true;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.f17432b) {
                    int unused = ActionBarDropDownView.this.f17425e = 3;
                    if (ActionBarDropDownView.this.f17426f != null) {
                        ActionBarDropDownView.this.f17426f.mo25065c();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                int unused = ActionBarDropDownView.this.f17425e = 2;
                ActionBarDropDownView.this.setVisibility(0);
                this.f17432b = false;
            }
        };
        this.f17430j = new AnimatorListenerAdapter() {

            /* renamed from: b */
            private boolean f17434b;

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.f17434b = true;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.f17434b) {
                    int unused = ActionBarDropDownView.this.f17425e = 1;
                    ActionBarDropDownView.this.setVisibility(4);
                    if (ActionBarDropDownView.this.f17426f != null) {
                        ActionBarDropDownView.this.f17426f.mo25066d();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                int unused = ActionBarDropDownView.this.f17425e = 0;
                this.f17434b = false;
            }
        };
        this.f17427g = new View(context);
        this.f17427g.setBackgroundColor(context.getResources().getColor(R.color.mz_action_bar_drop_down_view_background));
        addView(this.f17427g, -1, -1);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getVisibility() == 0 && this.f17423c != null) {
            this.f17424d = this.f17423c.getMeasuredHeight();
            if (this.f17425e == 1 && this.f17424d > 0) {
                m19096b();
            }
        }
    }

    /* renamed from: b */
    private void m19096b() {
        if (this.f17428h != null) {
            this.f17428h.cancel();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.f17423c.setTranslationY((float) (-this.f17424d));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f17423c, "translationY", new float[]{0.0f});
        ofFloat.setInterpolator(f17421a);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        this.f17427g.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f17427g, "alpha", new float[]{1.0f});
        ofFloat2.setInterpolator(f17422b);
        play.with(ofFloat2);
        animatorSet.setDuration(350);
        animatorSet.addListener(this.f17429i);
        animatorSet.start();
        this.f17428h = animatorSet;
        if (this.f17426f != null) {
            this.f17426f.mo25063a();
        }
    }

    /* renamed from: a */
    public void mo25875a() {
        if (this.f17425e != 1 && this.f17425e != 0) {
            if (this.f17428h != null) {
                this.f17428h.cancel();
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f17423c, "translationY", new float[]{(float) (-this.f17424d)});
            ofFloat.setInterpolator(f17421a);
            AnimatorSet.Builder play = animatorSet.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f17427g, "alpha", new float[]{0.0f});
            ofFloat2.setInterpolator(f17422b);
            play.with(ofFloat2);
            animatorSet.setDuration(350);
            animatorSet.addListener(this.f17430j);
            animatorSet.start();
            this.f17428h = animatorSet;
            if (this.f17426f != null) {
                this.f17426f.mo25064b();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return true;
            case 1:
                mo25875a();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(ActionBar.C3073c cVar) {
        this.f17426f = cVar;
    }

    public void setContentView(View view, int i, int i2) {
        ViewGroup viewGroup;
        if (view != null) {
            if (this.f17423c != null && this.f17423c.getParent() == this) {
                removeView(this.f17423c);
            }
            if (!(view == null || view.getParent() == null || (viewGroup = (ViewGroup) view.getParent()) == this)) {
                viewGroup.removeView(view);
            }
            this.f17423c = view;
            addView(this.f17423c, i, i2);
        }
    }
}
