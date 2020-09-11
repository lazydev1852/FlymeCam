package com.meizu.sharewidget.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.p092v4.view.ViewPager;

public class ViewPagerOverScrollLayout extends FrameLayout {

    /* renamed from: a */
    ViewPager f15973a;

    /* renamed from: b */
    int f15974b;

    /* renamed from: c */
    int f15975c;

    /* renamed from: d */
    C2892a f15976d;

    /* renamed from: e */
    private String f15977e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f15978f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f15979g;

    /* renamed from: h */
    private TimeInterpolator f15980h;

    public ViewPagerOverScrollLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ViewPagerOverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerOverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15977e = "OS";
        this.f15978f = 0.0f;
        this.f15979g = 0;
        this.f15980h = PathInterpolatorCompat.create(0.12f, 0.0f, 0.33f, 1.0f);
        setOverScrollMode(0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            if (childAt instanceof ViewPager) {
                this.f15973a = (ViewPager) childAt;
                this.f15973a.mo24936a((ViewPager.C3054e) new ViewPager.C3054e() {
                    /* renamed from: a */
                    public void mo17729a(int i) {
                    }

                    /* renamed from: b */
                    public void mo17731b(int i) {
                    }

                    /* renamed from: a */
                    public void mo17730a(int i, float f, int i2) {
                        float unused = ViewPagerOverScrollLayout.this.f15978f = f;
                        int unused2 = ViewPagerOverScrollLayout.this.f15979g = i;
                    }
                });
                return;
            }
            throw new IllegalStateException("ViewPagerOverScrollLayout only contain ViewPager");
        }
        throw new IllegalStateException("ViewPagerOverScrollLayout only can host 1 elements");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f15974b = (int) (((float) i) * 0.3f);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int count = this.f15973a.getAdapter().getCount();
        switch (action) {
            case 0:
                this.f15975c = x;
                if (this.f15976d != null) {
                    this.f15976d.mo24140b();
                }
                if (getScrollX() != 0) {
                    return true;
                }
                break;
            case 1:
            case 3:
                if (getScrollX() != 0) {
                    if (this.f15976d == null) {
                        this.f15976d = new C2892a();
                    }
                    this.f15976d.mo24139a();
                    return true;
                }
                break;
            case 2:
                boolean z = false;
                if (getScrollX() == 0) {
                    boolean z2 = this.f15979g == 0 && this.f15978f == 0.0f;
                    boolean z3 = this.f15979g == count + -1 && this.f15978f == 0.0f;
                    if ((x > this.f15975c && z2) || (x < this.f15975c && z3)) {
                        z = true;
                    }
                    if (z && count > 1) {
                        overScrollBy(-m17369a(x - this.f15975c, getScrollX()), 0, getScrollX(), 0, 0, 0, this.f15974b, 0, true);
                        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                        super.dispatchTouchEvent(obtain);
                        obtain.recycle();
                        this.f15975c = x;
                        return true;
                    }
                } else if (x != this.f15975c) {
                    int a = m17369a(x - this.f15975c, getScrollX());
                    int scrollX = getScrollX();
                    int i3 = scrollX - a;
                    int i4 = -a;
                    if ((i3 > 0 || scrollX <= 0) && (i3 < 0 || scrollX >= 0)) {
                        i2 = i4;
                        i = 0;
                    } else {
                        i2 = -scrollX;
                        i = a;
                    }
                    if (i2 != 0) {
                        overScrollBy(i2, 0, getScrollX(), 0, 0, 0, this.f15974b, 0, true);
                    }
                    if (i != 0) {
                        if (getScrollX() != 0) {
                            setScrollX(0);
                            mo24134a();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                        super.dispatchTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    this.f15975c = x;
                    return true;
                }
                this.f15975c = x;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (getScrollX() != i) {
            onScrollChanged(i, i2, getScrollX(), getScrollY());
            setScrollX(i);
            mo24134a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24134a() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    /* renamed from: a */
    private int m17369a(int i, int i2) {
        int i3 = this.f15974b;
        if (i2 == 0 || i3 == 0) {
            return i;
        }
        if (i2 * i >= 0) {
            return i / 2;
        }
        float interpolation = 1.0f - this.f15980h.getInterpolation((((float) Math.abs(i2)) * 1.0f) / ((float) i3));
        float f = 0.0f;
        if (interpolation >= 0.0f) {
            f = interpolation;
        }
        int i4 = (int) (((float) i) * f);
        if (i > 0) {
            if (i4 == 0) {
                i4 = 1;
            }
        } else if (i4 == 0) {
            i4 = -1;
        }
        if (Math.abs(i2) >= i3) {
            return 0;
        }
        return i4;
    }

    /* renamed from: com.meizu.sharewidget.widget.ViewPagerOverScrollLayout$a */
    private class C2892a implements Runnable {

        /* renamed from: a */
        boolean f15982a = false;

        /* renamed from: c */
        private final OverScroller f15984c;

        C2892a() {
            this.f15984c = new OverScroller(ViewPagerOverScrollLayout.this.getContext());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo24139a() {
            if (this.f15984c.springBack(ViewPagerOverScrollLayout.this.getScrollX(), 0, 0, 0, 0, 0)) {
                this.f15982a = true;
                ViewPagerOverScrollLayout.this.invalidate();
                ViewPagerOverScrollLayout.this.postOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo24140b() {
            ViewPagerOverScrollLayout.this.removeCallbacks(this);
            this.f15984c.abortAnimation();
        }

        public void run() {
            OverScroller overScroller = this.f15984c;
            if (overScroller.computeScrollOffset()) {
                int scrollX = ViewPagerOverScrollLayout.this.getScrollX();
                int currX = overScroller.getCurrX();
                this.f15982a = false;
                if (!ViewPagerOverScrollLayout.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, ViewPagerOverScrollLayout.this.f15974b, 0, false)) {
                    ViewPagerOverScrollLayout.this.invalidate();
                    ViewPagerOverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollX > 0 || currX <= 0) && (scrollX < 0 || currX >= 0)) {
                    mo24139a();
                } else {
                    overScroller.abortAnimation();
                }
            } else {
                mo24140b();
            }
        }
    }
}
