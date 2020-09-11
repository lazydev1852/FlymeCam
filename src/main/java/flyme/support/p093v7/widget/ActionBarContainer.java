package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f17380a;

    /* renamed from: b */
    Drawable f17381b;

    /* renamed from: c */
    Drawable f17382c;

    /* renamed from: d */
    boolean f17383d;

    /* renamed from: e */
    boolean f17384e;

    /* renamed from: f */
    protected ViewPropertyAnimatorCompat f17385f;

    /* renamed from: g */
    protected final TabsVisibilityAnimListener f17386g;

    /* renamed from: h */
    private boolean f17387h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MzActionBarTabContainer f17388i;

    /* renamed from: j */
    private View f17389j;

    /* renamed from: k */
    private View f17390k;

    /* renamed from: l */
    private int f17391l;

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17386g = new TabsVisibilityAnimListener();
        setBackgroundDrawable(Build.VERSION.SDK_INT >= 21 ? new ActionBarBackgroundDrawableV21(this) : new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f17380a = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f17381b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f17391l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f17383d = true;
            this.f17382c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f17383d ? this.f17380a == null && this.f17381b == null : this.f17382c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f17389j = findViewById(R.id.action_bar);
        this.f17390k = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.f17380a != null) {
            this.f17380a.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f17380a);
        }
        this.f17380a = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f17389j != null) {
                this.f17380a.setBounds(this.f17389j.getLeft(), 0, this.f17389j.getRight(), this.f17389j.getBottom());
            }
        }
        if (!this.f17383d ? this.f17380a == null && this.f17381b == null : this.f17382c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.f17381b != null) {
            this.f17381b.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f17381b);
        }
        this.f17381b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (!(!this.f17384e || this.f17381b == null || this.f17388i == null)) {
                this.f17381b.setBounds(this.f17388i.getLeft(), this.f17388i.getTop(), this.f17388i.getRight(), this.f17388i.getBottom());
            }
        }
        boolean z = false;
        if (!this.f17383d ? this.f17380a == null && this.f17381b == null : this.f17382c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.f17382c != null) {
            this.f17382c.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f17382c);
        }
        this.f17382c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f17383d && this.f17382c != null) {
                this.f17382c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f17383d ? this.f17380a == null && this.f17381b == null : this.f17382c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f17380a != null) {
            this.f17380a.setVisible(z, false);
        }
        if (this.f17381b != null) {
            this.f17381b.setVisible(z, false);
        }
        if (this.f17382c != null) {
            this.f17382c.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f17380a && !this.f17383d) || (drawable == this.f17381b && this.f17384e) || ((drawable == this.f17382c && this.f17383d) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17380a != null && this.f17380a.isStateful()) {
            this.f17380a.setState(getDrawableState());
        }
        if (this.f17381b != null && this.f17381b.isStateful()) {
            this.f17381b.setState(getDrawableState());
        }
        if (this.f17382c != null && this.f17382c.isStateful()) {
            this.f17382c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f17380a != null) {
                this.f17380a.jumpToCurrentState();
            }
            if (this.f17381b != null) {
                this.f17381b.jumpToCurrentState();
            }
            if (this.f17382c != null) {
                this.f17382c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f17387h = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f17387h || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f17388i != null) {
            removeView(this.f17388i);
        }
        if (this.f17388i == null && scrollingTabContainerView != null) {
            this.f17388i = new MzActionBarTabContainer(getContext());
        }
        if (scrollingTabContainerView != null) {
            this.f17388i.setTabView(scrollingTabContainerView);
            addView(this.f17388i);
            ViewGroup.LayoutParams layoutParams = this.f17388i.getLayoutParams();
            this.f17388i.mo26128a(false);
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        } else if (this.f17388i != null) {
            this.f17388i.setTabView((ScrollingTabContainerView) null);
            this.f17388i = null;
        }
    }

    public MzActionBarTabContainer getTabContainer() {
        return this.f17388i;
    }

    /* renamed from: a */
    private boolean m19075a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m19076b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        if (this.f17389j == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f17391l >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f17391l, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f17389j != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f17388i != null && this.f17388i.getVisibility() != 8 && mode != 1073741824) {
                if (!m19075a(this.f17389j)) {
                    i3 = m19076b(this.f17389j);
                } else {
                    i3 = !m19075a(this.f17390k) ? m19076b(this.f17390k) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m19076b(this.f17388i) + getPaddingTop() + getPaddingBottom(), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        MzActionBarTabContainer mzActionBarTabContainer = this.f17388i;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (mzActionBarTabContainer == null || mzActionBarTabContainer.getVisibility() == 8) ? false : true;
        if (!(mzActionBarTabContainer == null || mzActionBarTabContainer.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mzActionBarTabContainer.getLayoutParams();
            mzActionBarTabContainer.layout(i + layoutParams.leftMargin, (measuredHeight - mzActionBarTabContainer.getMeasuredHeight()) - layoutParams.bottomMargin, i3 - layoutParams.rightMargin, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f17383d) {
            if (this.f17380a != null) {
                if (this.f17389j.getVisibility() == 0) {
                    this.f17380a.setBounds(this.f17389j.getLeft(), 0, this.f17389j.getRight(), this.f17389j.getBottom());
                } else if (this.f17390k == null || this.f17390k.getVisibility() != 0) {
                    this.f17380a.setBounds(0, 0, 0, 0);
                } else {
                    this.f17380a.setBounds(this.f17390k.getLeft(), 0, this.f17390k.getRight(), this.f17390k.getBottom());
                }
                z3 = true;
            }
            this.f17384e = z4;
            if (!z4 || this.f17381b == null) {
                z2 = z3;
            } else {
                this.f17381b.setBounds(mzActionBarTabContainer.getLeft(), mzActionBarTabContainer.getTop(), mzActionBarTabContainer.getRight(), mzActionBarTabContainer.getBottom());
            }
        } else if (this.f17382c != null) {
            this.f17382c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionBarContainer$1 */
    class C31691 implements ViewPropertyAnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ ActionBarContainer f17392a;

        public void onAnimationUpdate(View view) {
            this.f17392a.f17381b.setAlpha((int) (view.getAlpha() * 255.0f));
            this.f17392a.invalidate();
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionBarContainer$TabsVisibilityAnimListener */
    protected class TabsVisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        int f17393a;

        /* renamed from: c */
        private boolean f17395c = false;

        protected TabsVisibilityAnimListener() {
        }

        public void onAnimationStart(View view) {
            ActionBarContainer.this.f17388i.setVisibility(0);
            this.f17395c = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f17395c) {
                ActionBarContainer.this.f17385f = null;
                ActionBarContainer.this.f17388i.setVisibility(this.f17393a);
            }
        }

        public void onAnimationCancel(View view) {
            this.f17395c = true;
        }
    }
}
