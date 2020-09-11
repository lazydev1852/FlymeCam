package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.AbsActionBarView */
public abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a */
    static final Interpolator f17365a = PathInterpolatorCompat.create(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: b */
    protected final VisibilityAnimListener f17366b;

    /* renamed from: c */
    protected final Context f17367c;

    /* renamed from: d */
    protected ActionMenuView f17368d;

    /* renamed from: e */
    protected ActionMenuPresenter f17369e;

    /* renamed from: f */
    protected ViewGroup f17370f;

    /* renamed from: g */
    protected boolean f17371g;

    /* renamed from: h */
    protected boolean f17372h;

    /* renamed from: i */
    protected int f17373i;

    /* renamed from: j */
    protected ViewPropertyAnimatorCompat f17374j;

    /* renamed from: k */
    private boolean f17375k;

    /* renamed from: l */
    private boolean f17376l;

    /* renamed from: a */
    protected static int m19066a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    AbsActionBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17366b = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f17367c = context;
        } else {
            this.f17367c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, CommonUtils.m5121b() ? R.attr.mzActionBarStyleFullScreen : R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f17369e != null) {
            this.f17369e.mo25941a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f17375k = false;
        }
        if (!this.f17375k) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f17375k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f17375k = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f17376l = false;
        }
        if (!this.f17376l) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f17376l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f17376l = false;
        }
        return true;
    }

    public void setSplitToolbar(boolean z) {
        this.f17371g = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f17372h = z;
    }

    public void setContentHeight(int i) {
        this.f17373i = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f17373i;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f17370f = viewGroup;
    }

    public int getAnimatedVisibility() {
        if (this.f17374j != null) {
            return this.f17366b.f17377a;
        }
        return getVisibility();
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat mo25822a(int i, long j) {
        if (this.f17374j != null) {
            this.f17374j.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, 0.0f);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(j);
            alpha.setListener(this.f17366b.mo25834a(alpha, i));
            return alpha;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(0.0f);
        alpha2.setDuration(j);
        alpha2.setListener(this.f17366b.mo25834a(alpha2, i));
        return alpha2;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f17374j != null) {
                this.f17374j.cancel();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo25823a() {
        if (this.f17369e != null) {
            return this.f17369e.mo25950d();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25820a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25821a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: flyme.support.v7.widget.AbsActionBarView$VisibilityAnimListener */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        int f17377a;

        /* renamed from: c */
        private boolean f17379c = false;

        protected VisibilityAnimListener() {
        }

        /* renamed from: a */
        public VisibilityAnimListener mo25834a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.f17374j = viewPropertyAnimatorCompat;
            this.f17377a = i;
            return this;
        }

        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f17379c = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f17379c) {
                AbsActionBarView.this.f17374j = null;
                AbsActionBarView.super.setVisibility(this.f17377a);
            }
        }

        public void onAnimationCancel(View view) {
            this.f17379c = true;
        }
    }
}
