package flyme.support.p093v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.p020ar.constants.HttpConstants;
import flyme.support.p093v7.util.C3146a;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.OverScrollLayout */
public class OverScrollLayout extends FrameLayout implements NestedScrollingParent {

    /* renamed from: f */
    static final Interpolator f17872f = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    int f17873a;

    /* renamed from: b */
    int f17874b;

    /* renamed from: c */
    int f17875c;

    /* renamed from: d */
    C3243c f17876d;

    /* renamed from: e */
    C3241a f17877e;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MzRecyclerView f17878g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17879h;

    /* renamed from: i */
    private int f17880i;

    /* renamed from: j */
    private int f17881j;

    /* renamed from: k */
    private int f17882k;

    /* renamed from: l */
    private boolean f17883l;

    /* renamed from: m */
    private boolean f17884m;

    /* renamed from: n */
    private boolean f17885n;

    /* renamed from: o */
    private boolean f17886o;

    /* renamed from: p */
    private boolean f17887p;

    /* renamed from: q */
    private float f17888q;

    /* renamed from: r */
    private VelocityTracker f17889r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f17890s;

    /* renamed from: t */
    private TimeInterpolator f17891t;

    /* renamed from: u */
    private NestedScrollingParentHelper f17892u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public OverScroller f17893v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C3242b f17894w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public RecyclerView.C3274l f17895x;

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    public OverScrollLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17879h = -1;
        this.f17880i = 0;
        this.f17881j = 0;
        this.f17882k = 0;
        this.f17884m = true;
        this.f17885n = true;
        this.f17886o = true;
        this.f17887p = true;
        this.f17888q = 0.0f;
        this.f17890s = 0;
        this.f17891t = PathInterpolatorCompat.create(0.12f, 0.0f, 0.33f, 1.0f);
        this.f17895x = new RecyclerView.C3274l() {
            /* renamed from: a */
            public void mo20072a(RecyclerView recyclerView, int i, int i2) {
            }

            /* renamed from: a */
            public void mo20071a(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    OverScrollLayout.this.f17878g.mo26384b(OverScrollLayout.this.f17895x);
                    OverScrollLayout.this.f17893v.computeScrollOffset();
                    if (OverScrollLayout.this.m19522b()) {
                        if (OverScrollLayout.this.f17894w == null) {
                            C3242b unused = OverScrollLayout.this.f17894w = new C3242b();
                        }
                        int currVelocity = (int) OverScrollLayout.this.f17893v.getCurrVelocity();
                        if (OverScrollLayout.this.f17890s == 0 || OverScrollLayout.this.f17890s == 0) {
                            if (currVelocity <= 0) {
                                currVelocity = -currVelocity;
                            }
                        } else if (currVelocity > 0) {
                            currVelocity = -currVelocity;
                        }
                        OverScrollLayout.this.f17873a = OverScrollLayout.this.m19525c(currVelocity);
                        if (OverScrollLayout.this.f17879h == 1) {
                            OverScrollLayout.this.f17894w.mo26316a(0, currVelocity);
                        } else if (OverScrollLayout.this.f17879h == 0) {
                            OverScrollLayout.this.f17894w.mo26316a(currVelocity, 0);
                        }
                    }
                } else if (i == 1) {
                    OverScrollLayout.this.f17878g.mo26384b(OverScrollLayout.this.f17895x);
                }
            }
        };
        setOverScrollMode(0);
        this.f17883l = true;
        this.f17892u = new NestedScrollingParentHelper(this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            throw new IllegalStateException("OverScrollLayout only can host 1 elements");
        } else if (m19519a(getChildAt(0))) {
            this.f17888q = 1.0f;
        } else {
            throw new IllegalStateException("OverScrollLayout only contain recyclerview");
        }
    }

    /* renamed from: a */
    private boolean m19519a(View view) {
        if (view instanceof RecyclerView) {
            this.f17878g = (MzRecyclerView) view;
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m19519a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f17878g.getLayoutManager() instanceof LinearLayoutManager) {
            this.f17879h = ((LinearLayoutManager) this.f17878g.getLayoutManager()).mo26093h();
        }
        if (this.f17879h == 1) {
            this.f17873a = (int) (((float) i2) * 0.3f);
        } else if (this.f17879h == 0) {
            this.f17873a = (int) (((float) i) * 0.3f);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f17889r == null) {
            this.f17889r = VelocityTracker.obtain();
        }
        this.f17889r.addMovement(motionEvent);
        int i5 = 0;
        if (this.f17879h != 1) {
            if (this.f17879h == 0) {
                boolean canScrollHorizontally = this.f17878g.canScrollHorizontally(1);
                boolean canScrollHorizontally2 = this.f17878g.canScrollHorizontally(-1);
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.f17878g.mo26360J();
                switch (action) {
                    case 0:
                        this.f17875c = x;
                        this.f17881j = y;
                        this.f17882k = x;
                        this.f17873a = m19525c(0);
                        if (this.f17877e != null) {
                            this.f17877e.mo26313b();
                        }
                        if (this.f17894w != null) {
                            this.f17894w.mo26317b();
                        }
                        if (this.f17893v != null) {
                            this.f17893v.abortAnimation();
                        }
                        if (getScrollX() != 0) {
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        this.f17887p = true;
                        this.f17886o = true;
                        this.f17889r.computeCurrentVelocity(1000);
                        if (this.f17889r.getXVelocity() > 0.0f) {
                            i5 = 1;
                        }
                        this.f17890s = i5;
                        if (getScrollX() == 0) {
                            this.f17889r.clear();
                            break;
                        } else {
                            if (this.f17877e == null) {
                                this.f17877e = new C3241a();
                            }
                            this.f17877e.mo26312a();
                            return true;
                        }
                    case 2:
                        this.f17887p = m19523b(1);
                        this.f17886o = m19523b(-1);
                        if (getScrollX() == 0) {
                            if ((!this.f17883l || !this.f17878g.mo26171f().booleanValue()) && ((this.f17880i <= 0 || Math.abs(x - this.f17882k) >= this.f17880i) && ((float) Math.abs(x - this.f17882k)) * this.f17888q >= ((float) Math.abs(y - this.f17881j)) && ((x > this.f17875c && !canScrollHorizontally2 && !this.f17886o) || (x < this.f17875c && !canScrollHorizontally && !this.f17887p)))) {
                                i5 = 1;
                            }
                            if (i5 != 0) {
                                int a = m19513a(x - this.f17875c, getScrollX());
                                this.f17878g.mo26361K();
                                overScrollBy(-a, 0, getScrollX(), 0, 0, 0, this.f17873a, 0, true);
                                MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                                super.dispatchTouchEvent(obtain);
                                obtain.recycle();
                                this.f17875c = x;
                                return true;
                            }
                        } else if (x != this.f17875c) {
                            int a2 = m19513a(x - this.f17875c, getScrollX());
                            int scrollX = getScrollX();
                            int i6 = scrollX - a2;
                            int i7 = -a2;
                            if ((i6 > 0 || scrollX <= 0) && (i6 < 0 || scrollX >= 0)) {
                                i2 = i7;
                                i = 0;
                            } else {
                                i2 = -scrollX;
                                i = a2;
                            }
                            if (i2 != 0) {
                                overScrollBy(i2, 0, getScrollX(), 0, 0, 0, this.f17873a, 0, true);
                            }
                            if (i != 0) {
                                if (getScrollX() != 0) {
                                    setScrollX(0);
                                    mo26304a();
                                }
                                MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                                super.dispatchTouchEvent(obtain2);
                                obtain2.recycle();
                            }
                            this.f17875c = x;
                            return true;
                        }
                        this.f17875c = x;
                        break;
                }
            }
        } else {
            boolean canScrollVertically = this.f17878g.canScrollVertically(1);
            boolean canScrollVertically2 = this.f17878g.canScrollVertically(-1);
            int action2 = motionEvent.getAction();
            int y2 = (int) motionEvent.getY();
            int x2 = (int) motionEvent.getX();
            this.f17878g.mo26360J();
            switch (action2) {
                case 0:
                    this.f17874b = y2;
                    this.f17881j = y2;
                    this.f17882k = x2;
                    this.f17873a = m19525c(0);
                    if (this.f17876d != null) {
                        this.f17876d.mo26320b();
                    }
                    if (this.f17894w != null) {
                        this.f17894w.mo26317b();
                    }
                    if (this.f17893v != null) {
                        this.f17893v.abortAnimation();
                    }
                    if (getScrollY() != 0) {
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    this.f17884m = true;
                    this.f17885n = true;
                    this.f17889r.computeCurrentVelocity(1000);
                    if (this.f17889r.getYVelocity() > 0.0f) {
                        i5 = 1;
                    }
                    this.f17890s = i5;
                    if (getScrollY() == 0) {
                        this.f17889r.clear();
                        break;
                    } else {
                        if (this.f17876d == null) {
                            this.f17876d = new C3243c();
                        }
                        this.f17876d.mo26319a();
                        return true;
                    }
                case 2:
                    this.f17884m = m19518a(1);
                    this.f17885n = m19518a(-1);
                    if (getScrollY() == 0) {
                        if ((!this.f17883l || !this.f17878g.mo26171f().booleanValue()) && ((this.f17880i <= 0 || Math.abs(y2 - this.f17881j) >= this.f17880i) && ((float) Math.abs(y2 - this.f17881j)) * this.f17888q >= ((float) Math.abs(x2 - this.f17882k)) && ((y2 - this.f17881j > 5 && y2 > this.f17874b && !canScrollVertically2 && !this.f17885n) || (this.f17881j - y2 > 5 && y2 < this.f17874b && !canScrollVertically && !this.f17884m)))) {
                            i5 = 1;
                        }
                        if (i5 != 0) {
                            int a3 = m19513a(y2 - this.f17874b, getScrollY());
                            this.f17878g.mo26361K();
                            overScrollBy(0, -a3, 0, getScrollY(), 0, 0, 0, this.f17873a, true);
                            MotionEvent obtain3 = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                            super.dispatchTouchEvent(obtain3);
                            obtain3.recycle();
                            this.f17874b = y2;
                            return true;
                        }
                    } else if (y2 != this.f17874b) {
                        int a4 = m19513a(y2 - this.f17874b, getScrollY());
                        int scrollY = getScrollY();
                        int i8 = scrollY - a4;
                        int i9 = -a4;
                        if ((i8 > 0 || scrollY <= 0) && (i8 < 0 || scrollY >= 0)) {
                            i4 = i9;
                            i3 = 0;
                        } else {
                            i3 = a4;
                            i4 = -scrollY;
                        }
                        if (i4 != 0) {
                            overScrollBy(0, i4, 0, getScrollY(), 0, 0, 0, this.f17873a, true);
                        }
                        if (i3 != 0) {
                            if (getScrollY() != 0) {
                                setScrollY(0);
                                mo26304a();
                            }
                            MotionEvent obtain4 = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                            super.dispatchTouchEvent(obtain4);
                            obtain4.recycle();
                        }
                        this.f17874b = y2;
                        return true;
                    }
                    this.f17874b = y2;
                    break;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.f17879h == 1) {
            if (getScrollY() != i2) {
                onScrollChanged(i, i2, getScrollX(), getScrollY());
                setScrollY(i2);
                mo26304a();
                awakenScrollBars();
            }
        } else if (this.f17879h == 0 && getScrollX() != i) {
            onScrollChanged(i, i2, getScrollX(), getScrollY());
            setScrollX(i);
            mo26304a();
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26304a() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19513a(int i, int i2) {
        int i3 = this.f17873a;
        if (i2 == 0 || i3 == 0) {
            return i;
        }
        if (i2 * i >= 0) {
            return i / 2;
        }
        float interpolation = 1.0f - this.f17891t.getInterpolation((((float) Math.abs(i2)) * 1.0f) / ((float) i3));
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

    /* renamed from: flyme.support.v7.widget.OverScrollLayout$c */
    private class C3243c implements Runnable {

        /* renamed from: b */
        private final C3146a f17904b;

        C3243c() {
            this.f17904b = new C3146a(OverScrollLayout.this.getContext());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26319a() {
            if (this.f17904b.mo25386a(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26320b() {
            OverScrollLayout.this.removeCallbacks(this);
            this.f17904b.mo25391f();
        }

        public void run() {
            C3146a aVar = this.f17904b;
            if (aVar.mo25390e()) {
                int scrollY = OverScrollLayout.this.getScrollY();
                int c = aVar.mo25388c();
                if (!OverScrollLayout.this.overScrollBy(0, c - scrollY, 0, scrollY, 0, 0, 0, OverScrollLayout.this.f17873a, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollY > 0 || c <= 0) && (scrollY < 0 || c >= 0)) {
                    mo26319a();
                } else {
                    aVar.mo25391f();
                }
            } else {
                mo26320b();
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.OverScrollLayout$a */
    private class C3241a implements Runnable {

        /* renamed from: b */
        private final C3146a f17898b;

        C3241a() {
            this.f17898b = new C3146a(OverScrollLayout.this.getContext());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26312a() {
            if (this.f17898b.mo25386a(OverScrollLayout.this.getScrollX(), 0, 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26313b() {
            OverScrollLayout.this.removeCallbacks(this);
            this.f17898b.mo25391f();
        }

        public void run() {
            C3146a aVar = this.f17898b;
            if (aVar.mo25390e()) {
                int scrollX = OverScrollLayout.this.getScrollX();
                int b = aVar.mo25387b();
                if (!OverScrollLayout.this.overScrollBy(b - scrollX, 0, scrollX, 0, 0, 0, OverScrollLayout.this.f17873a, 0, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollX > 0 || b <= 0) && (scrollX < 0 || b >= 0)) {
                    mo26312a();
                } else {
                    aVar.mo25391f();
                }
            } else {
                mo26313b();
            }
        }
    }

    /* renamed from: a */
    private boolean m19518a(int i) {
        int computeVerticalScrollOffset = this.f17878g.computeVerticalScrollOffset();
        int computeVerticalScrollRange = this.f17878g.computeVerticalScrollRange() - this.f17878g.computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeVerticalScrollOffset > 50 : computeVerticalScrollOffset < computeVerticalScrollRange - 50;
    }

    /* renamed from: b */
    private boolean m19523b(int i) {
        int computeHorizontalScrollOffset = this.f17878g.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = this.f17878g.computeHorizontalScrollRange() - this.f17878g.computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeHorizontalScrollOffset > 50 : computeHorizontalScrollOffset < computeHorizontalScrollRange - 50;
    }

    public void setAntiShakeValue(int i) {
        this.f17880i = i;
    }

    public void setConfictRatio(float f) {
        this.f17888q = f;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f17892u.onNestedScrollAccepted(view, view2, i);
    }

    public void onStopNestedScroll(View view) {
        this.f17892u.onStopNestedScroll(view);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        if ((this.f17890s != 1 || f2 >= 0.0f) && ((this.f17890s != 0 || f2 <= 0.0f) && ((this.f17890s != 1 || f >= 0.0f) && (this.f17890s != 0 || f <= 0.0f)))) {
            return false;
        }
        this.f17878g.mo26374a(this.f17895x);
        this.f17893v = new OverScroller(view.getContext(), f17872f);
        this.f17893v.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19522b() {
        if (!this.f17893v.isFinished()) {
            if (this.f17879h == 0) {
                if (this.f17890s == 0 && !this.f17878g.canScrollHorizontally(1)) {
                    return true;
                }
                if (this.f17890s == 1 && !this.f17878g.canScrollHorizontally(-1)) {
                    return true;
                }
            }
            if (this.f17879h == 1) {
                if (this.f17890s == 0 && !this.f17878g.canScrollVertically(1)) {
                    return true;
                }
                if (this.f17890s != 1 || this.f17878g.canScrollVertically(-1)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: flyme.support.v7.widget.OverScrollLayout$b */
    private class C3242b implements Runnable {

        /* renamed from: b */
        private final C3146a f17900b;

        /* renamed from: c */
        private int f17901c;

        /* renamed from: d */
        private int f17902d;

        C3242b() {
            this.f17900b = new C3146a(OverScrollLayout.this.getContext(), OverScrollLayout.f17872f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26315a() {
            if (this.f17900b.mo25386a(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26316a(int i, int i2) {
            this.f17902d = i2;
            this.f17900b.mo25383a(0, 0, i, i2, -OverScrollLayout.this.f17873a, OverScrollLayout.this.f17873a, -OverScrollLayout.this.f17873a, OverScrollLayout.this.f17873a);
            this.f17901c = 0;
            OverScrollLayout.this.postOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26317b() {
            OverScrollLayout.this.removeCallbacks(this);
            this.f17900b.mo25391f();
        }

        public void run() {
            C3146a aVar = this.f17900b;
            if (!aVar.mo25390e()) {
                mo26317b();
                OverScrollLayout.this.m19527c();
            } else if (Math.abs(aVar.mo25389d()) <= ((float) Math.abs(this.f17902d / 2))) {
                mo26317b();
                OverScrollLayout.this.m19527c();
            } else if (OverScrollLayout.this.f17879h == 1) {
                int scrollY = OverScrollLayout.this.getScrollY();
                int c = aVar.mo25388c();
                int a = OverScrollLayout.this.m19513a(c - this.f17901c, OverScrollLayout.this.getScrollY());
                int scrollY2 = OverScrollLayout.this.getScrollY();
                int i = scrollY2 - a;
                if ((i <= 0 && scrollY2 > 0) || (i >= 0 && scrollY2 < 0)) {
                    a = -scrollY2;
                }
                int i2 = a;
                if (i2 == 0) {
                    mo26317b();
                    OverScrollLayout.this.m19527c();
                } else if (!OverScrollLayout.this.overScrollBy(0, i2, 0, OverScrollLayout.this.getScrollY(), 0, 0, 0, OverScrollLayout.this.f17873a, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollY > 0 || c <= 0) && (scrollY < 0 || c >= 0)) {
                    mo26315a();
                } else {
                    aVar.mo25391f();
                }
                this.f17901c = c;
            } else {
                int scrollX = OverScrollLayout.this.getScrollX();
                int b = aVar.mo25387b();
                int a2 = OverScrollLayout.this.m19513a(b - this.f17901c, OverScrollLayout.this.getScrollX());
                int scrollX2 = OverScrollLayout.this.getScrollX();
                int i3 = scrollX2 - a2;
                if ((i3 <= 0 && scrollX2 > 0) || (i3 >= 0 && scrollX2 < 0)) {
                    a2 = -scrollX2;
                }
                int i4 = a2;
                if (i4 == 0) {
                    mo26317b();
                    OverScrollLayout.this.m19527c();
                } else if (!OverScrollLayout.this.overScrollBy(i4, 0, OverScrollLayout.this.getScrollX(), 0, 0, 0, OverScrollLayout.this.f17873a, 0, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollX > 0 || b <= 0) && (scrollX < 0 || b >= 0)) {
                    mo26315a();
                } else {
                    aVar.mo25391f();
                }
                this.f17901c = b;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19527c() {
        if (getScrollY() != 0) {
            if (this.f17876d == null) {
                this.f17876d = new C3243c();
            }
            this.f17876d.mo26319a();
        } else if (getScrollX() != 0) {
            if (this.f17877e == null) {
                this.f17877e = new C3241a();
            }
            this.f17877e.mo26312a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m19525c(int i) {
        int height = (int) (((float) getHeight()) * 0.3f);
        if (i == 0) {
            return height;
        }
        return (int) ((((float) Math.abs(i)) / ((float) HttpConstants.HTTP_CONNECT_TIMEOUT)) * ((float) height));
    }
}
