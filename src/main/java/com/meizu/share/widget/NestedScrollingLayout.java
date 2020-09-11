package com.meizu.share.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import com.meizu.sharewidget.R;

public class NestedScrollingLayout extends ViewGroup implements NestedScrollingParent {

    /* renamed from: a */
    private final OverScroller f15814a;

    /* renamed from: b */
    private final float f15815b;

    /* renamed from: c */
    private final VelocityTracker f15816c;

    /* renamed from: d */
    private int f15817d;

    /* renamed from: e */
    private int f15818e;

    /* renamed from: f */
    private int f15819f;

    /* renamed from: g */
    private int f15820g;

    /* renamed from: h */
    private int f15821h;

    /* renamed from: i */
    private C2851b f15822i;

    /* renamed from: j */
    private C2852c f15823j;

    /* renamed from: k */
    private float f15824k;

    /* renamed from: l */
    private boolean f15825l;

    /* renamed from: m */
    private int f15826m;

    /* renamed from: com.meizu.share.widget.NestedScrollingLayout$b */
    public interface C2851b {
        /* renamed from: a */
        void mo23967a(boolean z);
    }

    /* renamed from: com.meizu.share.widget.NestedScrollingLayout$c */
    public interface C2852c {
        /* renamed from: a */
        void mo23966a(int i);
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return (i & 2) != 0;
    }

    public NestedScrollingLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public NestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15817d = 1;
        this.f15818e = 0;
        this.f15826m = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NestedScrollingLayout, i, 0);
        this.f15821h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NestedScrollingLayout_mzShareViewMaxHeight, getResources().getDisplayMetrics().heightPixels);
        obtainStyledAttributes.recycle();
        this.f15814a = new OverScroller(context, AnimationUtils.loadInterpolator(context, 17563653));
        this.f15815b = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.f15816c = VelocityTracker.obtain();
        setClipToPadding(false);
    }

    public void setMaxHeight(int i) {
        this.f15821h = i;
    }

    public void setScrollListener(C2852c cVar) {
        this.f15823j = cVar;
    }

    public void setOnDismissedListener(C2851b bVar) {
        this.f15822i = bVar;
    }

    public void setUncollapsibleHeight(int i) {
        this.f15819f = i;
    }

    public int getCurrentScrollY() {
        return this.f15818e;
    }

    public void computeScroll() {
        if (this.f15814a.computeScrollOffset()) {
            m17226e(this.f15814a.getCurrY());
            if (!this.f15814a.isFinished()) {
                invalidate();
            } else if (this.f15817d == 2 && this.f15822i != null) {
                this.f15822i.mo23967a(false);
            }
        }
    }

    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = i2 > 0 && this.f15818e < this.f15820g;
        if (i2 < 0 && !view.canScrollVertically(-1)) {
            z = true;
        }
        if (z2 || z) {
            iArr[1] = m17225d(i2);
        }
    }

    public void onStopNestedScroll(@NonNull View view) {
        if (this.f15814a.isFinished()) {
            m17223b(m17217a(this.f15817d));
        }
    }

    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        boolean z = this.f15818e < this.f15820g;
        if (z && m17221a(f2)) {
            m17223b(m17218a(this.f15817d, -f2));
        }
        return z;
    }

    /* renamed from: a */
    private int m17218a(int i, float f) {
        return (this.f15818e < (-this.f15819f) || this.f15818e >= 0) ? f < 0.0f ? 0 : 1 : f < 0.0f ? 1 : 2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f15816c.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.f15824k = motionEvent.getY();
                this.f15825l = m17219a(motionEvent.getX(), this.f15824k) != null;
                break;
            case 1:
                if (this.f15825l) {
                    this.f15816c.computeCurrentVelocity(1000);
                    float yVelocity = this.f15816c.getYVelocity();
                    if (m17221a(yVelocity)) {
                        m17223b(m17218a(this.f15817d, yVelocity));
                    } else {
                        m17223b(m17217a(this.f15817d));
                    }
                } else if (this.f15822i != null) {
                    this.f15822i.mo23967a(true);
                }
                this.f15816c.clear();
                break;
            case 2:
                if (this.f15825l) {
                    this.f15824k = motionEvent.getY();
                    m17225d((int) (-(motionEvent.getY() - this.f15824k)));
                    break;
                }
                break;
            case 3:
                this.f15816c.clear();
                break;
        }
        return true;
    }

    /* renamed from: a */
    private int m17217a(int i) {
        int i2 = this.f15818e - (i == 0 ? this.f15820g : i == 1 ? 0 : -this.f15819f);
        int abs = Math.abs(i2);
        if (i2 > 0) {
            if (i != 2) {
                return (i != 1 || abs > 120) ? 0 : 1;
            }
            if (abs > this.f15819f + 120) {
                return 0;
            }
            if (abs > 120) {
                return 1;
            }
            return 2;
        } else if (i == 0) {
            if (abs > this.f15820g + 120) {
                return 2;
            }
            return abs > 120 ? 1 : 0;
        } else if (i != 1 || abs > 120) {
            return 2;
        } else {
            return 1;
        }
    }

    /* renamed from: b */
    private void m17223b(int i) {
        this.f15817d = i;
        switch (i) {
            case 0:
                m17224c(this.f15820g);
                return;
            case 1:
                m17224c(0);
                return;
            case 2:
                m17224c(-this.f15819f);
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m17224c(int i) {
        if (this.f15818e != i) {
            this.f15814a.abortAnimation();
            this.f15814a.startScroll(0, this.f15818e, 0, i - this.f15818e);
            invalidate();
        }
    }

    /* renamed from: d */
    private int m17225d(int i) {
        if (this.f15818e + i > this.f15820g) {
            i = this.f15820g - this.f15818e;
        }
        this.f15814a.abortAnimation();
        m17227f(i);
        return i;
    }

    /* renamed from: e */
    private void m17226e(int i) {
        m17227f(i - this.f15818e);
    }

    /* renamed from: f */
    private void m17227f(int i) {
        m17228g(-i);
        this.f15818e += i;
        if (this.f15823j != null) {
            this.f15823j.mo23966a(this.f15818e);
        }
    }

    /* renamed from: g */
    private void m17228g(int i) {
        int i2;
        if (this.f15818e + (-i) >= 0) {
            i2 = -this.f15826m;
        } else {
            i2 = (this.f15818e <= 0 || i <= 0) ? i : i - this.f15818e;
        }
        this.f15826m += i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((C2850a) childAt.getLayoutParams()).f15827a) {
                childAt.offsetTopAndBottom(i2);
            } else {
                childAt.offsetTopAndBottom(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int min = Math.min(View.MeasureSpec.getSize(i2), this.f15821h);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            C2850a aVar = (C2850a) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !aVar.f15829c) {
                C2850a aVar2 = aVar;
                measureChildWithMargins(childAt, makeMeasureSpec, 0, makeMeasureSpec2, i3);
                if (!aVar2.f15828b) {
                    i3 += childAt.getMeasuredHeight();
                }
            }
        }
        int i5 = min - i3;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            C2850a aVar3 = (C2850a) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && aVar3.f15829c) {
                childAt2.measure(getChildMeasureSpec(makeMeasureSpec, getPaddingLeft() + getPaddingRight() + aVar3.leftMargin + aVar3.rightMargin, aVar3.width), getChildMeasureSpec(makeMeasureSpec2, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin + i3, i5));
                i3 += childAt2.getMeasuredHeight();
            }
        }
        this.f15819f = Math.min(this.f15819f, getPaddingBottom() + i3);
        this.f15820g = Math.max(0, (i3 + getPaddingBottom()) - this.f15819f);
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f15819f) - this.f15818e;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        int i5 = measuredHeight;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            C2850a aVar = (C2850a) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !aVar.f15827a) {
                int i7 = i5 + aVar.topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i7;
                int measuredWidth = childAt.getMeasuredWidth();
                int i8 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i8, i7, measuredWidth + i8, measuredHeight2);
                i5 = measuredHeight2 + aVar.bottomMargin;
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            C2850a aVar2 = (C2850a) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && aVar2.f15827a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (aVar2.f15828b ? 0 : getPaddingBottom())) - aVar2.bottomMargin) + this.f15826m;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i10 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i10, height, measuredWidth2 + i10, childAt2.getMeasuredHeight() + height);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C2850a(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C2850a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C2850a) {
            return new C2850a((C2850a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C2850a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C2850a(layoutParams);
    }

    /* renamed from: a */
    private boolean m17221a(float f) {
        return Math.abs(f) > this.f15815b;
    }

    /* renamed from: a */
    private View m17219a(float f, float f2) {
        return m17220a((ViewGroup) this, f, f2);
    }

    /* renamed from: a */
    private static View m17220a(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (m17222a(childAt, f, f2)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m17222a(View view, float f, float f2) {
        float x = view.getX();
        float y = view.getY();
        return f >= x && f2 >= y && f < ((float) view.getWidth()) + x && f2 < ((float) view.getHeight()) + y;
    }

    /* renamed from: com.meizu.share.widget.NestedScrollingLayout$a */
    public static class C2850a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        boolean f15827a;

        /* renamed from: b */
        boolean f15828b;

        /* renamed from: c */
        boolean f15829c;

        public C2850a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NestedScrollingLayout_LayoutParams);
            this.f15827a = obtainStyledAttributes.getBoolean(R.styleable.NestedScrollingLayout_LayoutParams_layout_share_alignParentBottom, false);
            this.f15828b = obtainStyledAttributes.getBoolean(R.styleable.NestedScrollingLayout_LayoutParams_layout_share_ignoreParentPadding, false);
            this.f15829c = obtainStyledAttributes.getBoolean(R.styleable.NestedScrollingLayout_LayoutParams_layout_share_listView, false);
            obtainStyledAttributes.recycle();
        }

        public C2850a(int i, int i2) {
            super(i, i2);
        }

        public C2850a(C2850a aVar) {
            super(aVar);
            this.f15827a = aVar.f15827a;
            this.f15828b = aVar.f15828b;
            this.f15829c = aVar.f15829c;
        }

        public C2850a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C2850a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
