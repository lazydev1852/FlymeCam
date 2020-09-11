package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.widget.ScrollerCompat;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ResourceUtils;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.menu.MenuPresenter;

/* renamed from: flyme.support.v7.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {

    /* renamed from: a */
    static final int[] f17435a = {R.attr.actionBarSize, 16842841, R.attr.mzWindowSplitActionBar, R.attr.mzSplitActionBarFloat, R.attr.mzActionBarFitStatusBar};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ViewPropertyAnimatorCompat f17436A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ViewPropertyAnimatorCompat f17437B;

    /* renamed from: C */
    private boolean f17438C;

    /* renamed from: D */
    private boolean f17439D;

    /* renamed from: E */
    private int f17440E;

    /* renamed from: F */
    private boolean f17441F;

    /* renamed from: G */
    private int f17442G;

    /* renamed from: H */
    private boolean f17443H;

    /* renamed from: I */
    private boolean f17444I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public final ViewPropertyAnimatorListener f17445J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public final ViewPropertyAnimatorListener f17446K;

    /* renamed from: L */
    private final Runnable f17447L;

    /* renamed from: M */
    private final Runnable f17448M;

    /* renamed from: N */
    private final NestedScrollingParentHelper f17449N;

    /* renamed from: O */
    private Rect f17450O;

    /* renamed from: P */
    private boolean f17451P;

    /* renamed from: Q */
    private Drawable f17452Q;

    /* renamed from: R */
    private boolean f17453R;

    /* renamed from: b */
    private int f17454b;

    /* renamed from: c */
    private int f17455c;

    /* renamed from: d */
    private ContentFrameLayout f17456d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ActionBarContainer f17457e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ActionBarContainer f17458f;

    /* renamed from: g */
    private View f17459g;

    /* renamed from: h */
    private ActionBarDropDownView f17460h;

    /* renamed from: i */
    private DecorToolbar f17461i;

    /* renamed from: j */
    private Drawable f17462j;

    /* renamed from: k */
    private boolean f17463k;

    /* renamed from: l */
    private boolean f17464l;

    /* renamed from: m */
    private boolean f17465m;

    /* renamed from: n */
    private boolean f17466n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f17467o;

    /* renamed from: p */
    private int f17468p;

    /* renamed from: q */
    private int f17469q;

    /* renamed from: r */
    private final Rect f17470r;

    /* renamed from: s */
    private final Rect f17471s;

    /* renamed from: t */
    private final Rect f17472t;

    /* renamed from: u */
    private final Rect f17473u;

    /* renamed from: v */
    private final Rect f17474v;

    /* renamed from: w */
    private final Rect f17475w;

    /* renamed from: x */
    private C3178a f17476x;

    /* renamed from: y */
    private final int f17477y;

    /* renamed from: z */
    private ScrollerCompat f17478z;

    /* renamed from: flyme.support.v7.widget.ActionBarOverlayLayout$a */
    public interface C3178a {
        /* renamed from: f */
        void mo25330f(int i);

        /* renamed from: g */
        void mo25331g(boolean z);

        /* renamed from: k */
        void mo25338k();

        /* renamed from: l */
        void mo25339l();

        /* renamed from: n */
        void mo25341n();

        /* renamed from: o */
        void mo25342o();
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17455c = 0;
        this.f17470r = new Rect();
        this.f17471s = new Rect();
        this.f17472t = new Rect();
        this.f17473u = new Rect();
        this.f17474v = new Rect();
        this.f17475w = new Rect();
        this.f17477y = 600;
        this.f17440E = -1;
        this.f17444I = false;
        this.f17445J = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17436A = null;
                boolean unused2 = ActionBarOverlayLayout.this.f17467o = false;
            }

            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17436A = null;
                boolean unused2 = ActionBarOverlayLayout.this.f17467o = false;
            }
        };
        this.f17446K = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17437B = null;
                boolean unused2 = ActionBarOverlayLayout.this.f17467o = false;
            }

            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17437B = null;
                boolean unused2 = ActionBarOverlayLayout.this.f17467o = false;
            }
        };
        this.f17447L = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m19111j();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17436A = ViewCompat.animate(ActionBarOverlayLayout.this.f17458f).translationY(0.0f).setListener(ActionBarOverlayLayout.this.f17445J);
                if (ActionBarOverlayLayout.this.f17457e != null && ActionBarOverlayLayout.this.f17457e.getVisibility() != 8) {
                    ViewPropertyAnimatorCompat unused2 = ActionBarOverlayLayout.this.f17437B = ViewCompat.animate(ActionBarOverlayLayout.this.f17457e).translationY(0.0f).setListener(ActionBarOverlayLayout.this.f17446K);
                }
            }
        };
        this.f17448M = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m19111j();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f17436A = ViewCompat.animate(ActionBarOverlayLayout.this.f17458f).translationY((float) (-ActionBarOverlayLayout.this.f17458f.getHeight())).setListener(ActionBarOverlayLayout.this.f17445J);
                if (ActionBarOverlayLayout.this.f17457e != null && ActionBarOverlayLayout.this.f17457e.getVisibility() != 8) {
                    ViewPropertyAnimatorCompat unused2 = ActionBarOverlayLayout.this.f17437B = ViewCompat.animate(ActionBarOverlayLayout.this.f17457e).translationY((float) ActionBarOverlayLayout.this.f17457e.getHeight()).setListener(ActionBarOverlayLayout.this.f17446K);
                }
            }
        };
        this.f17451P = false;
        this.f17453R = false;
        m19100a(context);
        this.f17449N = new NestedScrollingParentHelper(this);
    }

    /* renamed from: a */
    private void m19100a(Context context) {
        boolean z = false;
        if (CommonUtils.m5121b()) {
            f17435a[0] = R.attr.mzActionBarSizeFullScreen;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f17435a);
        this.f17454b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f17462j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f17462j == null);
        this.f17438C = obtainStyledAttributes.getBoolean(2, false);
        this.f17439D = obtainStyledAttributes.getBoolean(3, false);
        this.f17441F = obtainStyledAttributes.getBoolean(4, this.f17441F);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f17463k = z;
        this.f17478z = ScrollerCompat.create(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m19111j();
    }

    public void setActionBarVisibilityCallback(C3178a aVar) {
        this.f17476x = aVar;
        if (getWindowToken() != null) {
            this.f17476x.mo25330f(this.f17455c);
            if (this.f17469q != 0) {
                onWindowSystemUiVisibilityChanged(this.f17469q);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f17464l = z;
        this.f17463k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* renamed from: a */
    public boolean mo25889a() {
        return this.f17464l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f17465m = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m19100a(getContext());
        ViewCompat.requestApplyInsets(this);
        setUiOptions(this.f17442G);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo25892c();
        int i2 = this.f17469q ^ i;
        this.f17469q = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        if (this.f17476x != null) {
            this.f17476x.mo25331g(!z);
            if (z2 || !z) {
                this.f17476x.mo25338k();
            } else {
                this.f17476x.mo25339l();
            }
        }
        if ((i2 & 256) != 0 && this.f17476x != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f17455c = i;
        if (this.f17476x != null) {
            this.f17476x.mo25330f(i);
        }
    }

    /* renamed from: a */
    private boolean m19104a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C3179b bVar = (C3179b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo25892c();
        if (rect.equals(this.f17450O)) {
            return true;
        }
        this.f17450O = new Rect(rect);
        int windowSystemUiVisibility = ViewCompat.getWindowSystemUiVisibility(this) & 256;
        boolean a = m19103a(rect);
        if (this.f17457e != null) {
            a |= m19104a(this.f17457e, rect, true, false, this.f17439D, true);
        }
        this.f17473u.set(rect);
        mo25890a(this.f17473u, this.f17470r);
        if (!this.f17471s.equals(this.f17470r)) {
            this.f17471s.set(this.f17470r);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3179b generateDefaultLayoutParams() {
        return new C3179b(-1, -1);
    }

    /* renamed from: a */
    public C3179b generateLayoutParams(AttributeSet attributeSet) {
        return new C3179b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C3179b(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C3179b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        Rect rect;
        MzActionBarTabContainer tabContainer;
        mo25892c();
        if (!(this.f17459g == null || this.f17459g.getVisibility() == 8)) {
            measureChildWithMargins(this.f17459g, i, 0, i2, 0);
        }
        measureChildWithMargins(this.f17458f, i, 0, i2, 0);
        C3179b bVar = (C3179b) this.f17458f.getLayoutParams();
        int i4 = 0;
        int max = Math.max(0, this.f17458f.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f17458f.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int a = C3352x.m20911a(0, ViewCompat.getMeasuredState(this.f17458f));
        if (this.f17457e != null) {
            measureChildWithMargins(this.f17457e, i, 0, i2, 0);
            C3179b bVar2 = (C3179b) this.f17457e.getLayoutParams();
            max = Math.max(max, this.f17457e.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
            max2 = Math.max(max2, this.f17457e.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
            a = C3352x.m20911a(a, ViewCompat.getMeasuredState(this.f17457e));
        }
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0 || this.f17451P;
        if (z) {
            i3 = this.f17454b;
            if (!(!this.f17465m || (tabContainer = this.f17458f.getTabContainer()) == null || tabContainer.getVisibility() == 8)) {
                i3 += ActionBarPolicy.m18758a(getContext()).mo25416e();
            }
        } else {
            i3 = this.f17458f.getVisibility() != 8 ? this.f17458f.getMeasuredHeight() : 0;
        }
        if (!(!this.f17461i.mo27133c() || this.f17457e == null || this.f17457e.getVisibility() == 8)) {
            i4 = this.f17457e.getMeasuredHeight();
        }
        this.f17472t.set(this.f17470r);
        this.f17474v.set(this.f17473u);
        if (this.f17464l || z) {
            this.f17474v.top += i3;
            this.f17474v.bottom += i4;
        } else {
            this.f17472t.top += i3;
            this.f17472t.bottom += i4;
        }
        m19104a(this.f17456d, this.f17472t, true, true, true, true);
        if (!this.f17475w.equals(this.f17474v)) {
            this.f17475w.set(this.f17474v);
            this.f17456d.dispatchFitSystemWindows(this.f17474v);
        }
        measureChildWithMargins(this.f17456d, i, 0, i2, 0);
        C3179b bVar3 = (C3179b) this.f17456d.getLayoutParams();
        int max3 = Math.max(max, this.f17456d.getMeasuredWidth() + bVar3.leftMargin + bVar3.rightMargin);
        int max4 = Math.max(max2, this.f17456d.getMeasuredHeight() + bVar3.topMargin + bVar3.bottomMargin);
        int a2 = C3352x.m20911a(a, ViewCompat.getMeasuredState(this.f17456d));
        if (!(this.f17460h == null || this.f17460h.getVisibility() == 8)) {
            if (this.f17464l || z) {
                rect = this.f17474v;
            } else {
                rect = this.f17472t;
            }
            Rect rect2 = rect;
            if (this.f17440E != -1) {
                rect2.top = this.f17440E;
            }
            m19104a(this.f17460h, rect2, true, true, true, true);
            measureChildWithMargins(this.f17460h, i, 0, i2, 0);
            a2 = C3352x.m20911a(a2, ViewCompat.getMeasuredState(this.f17460h));
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, a2), ViewCompat.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C3179b bVar = (C3179b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = bVar.leftMargin + paddingLeft;
                if (childAt == this.f17457e) {
                    i5 = (paddingBottom - measuredHeight) - bVar.bottomMargin;
                } else if (childAt == this.f17459g) {
                    i5 = ((paddingBottom - measuredHeight) - bVar.bottomMargin) - ((this.f17457e == null || this.f17457e.getVisibility() == 8) ? 0 : this.f17457e.getMeasuredHeight());
                    i7 = (paddingRight - measuredWidth) - bVar.rightMargin;
                } else {
                    i5 = paddingTop + bVar.topMargin;
                }
                childAt.layout(i7, i5, measuredWidth + i7, measuredHeight + i5);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f17462j != null && !this.f17463k) {
            int bottom = this.f17458f.getVisibility() == 0 ? (int) (((float) this.f17458f.getBottom()) + ViewCompat.getTranslationY(this.f17458f) + 0.5f) : 0;
            this.f17462j.setBounds(0, bottom, getWidth(), this.f17462j.getIntrinsicHeight() + bottom);
            this.f17462j.draw(canvas);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f17458f.getVisibility() != 0) {
            return false;
        }
        return this.f17466n;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f17449N.onNestedScrollAccepted(view, view2, i);
        this.f17468p = getActionBarHideOffset();
        m19111j();
        if (this.f17476x != null) {
            this.f17476x.mo25341n();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f17468p += i2;
        setActionBarHideOffset(this.f17468p);
    }

    public void onStopNestedScroll(View view) {
        if (this.f17466n && !this.f17467o) {
            if (this.f17468p <= this.f17458f.getHeight()) {
                m19112k();
            } else {
                m19113l();
            }
        }
        if (this.f17476x != null) {
            this.f17476x.mo25342o();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f17466n || !z) {
            return false;
        }
        if (m19102a(f, f2)) {
            m19115n();
        } else {
            m19114m();
        }
        this.f17467o = true;
        return true;
    }

    public int getNestedScrollAxes() {
        return this.f17449N.getNestedScrollAxes();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo25892c() {
        if (this.f17456d == null) {
            this.f17456d = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f17458f = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f17461i = m19099a(findViewById(R.id.action_bar));
            this.f17457e = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.f17459g = findViewById(R.id.mz_list_backtop_container);
        }
    }

    /* renamed from: a */
    private DecorToolbar m19099a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f17466n) {
            this.f17466n = z;
            if (!z) {
                m19111j();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        if (this.f17458f != null) {
            return -((int) ViewCompat.getTranslationY(this.f17458f));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        m19111j();
        int height = this.f17458f.getHeight();
        int max = Math.max(0, Math.min(i, height));
        ViewCompat.setTranslationY(this.f17458f, (float) (-max));
        if (this.f17457e != null && this.f17457e.getVisibility() != 8) {
            ViewCompat.setTranslationY(this.f17457e, (float) ((int) (((float) this.f17457e.getHeight()) * (((float) max) / ((float) height)))));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m19111j() {
        removeCallbacks(this.f17447L);
        removeCallbacks(this.f17448M);
        if (this.f17436A != null) {
            this.f17436A.cancel();
        }
        if (this.f17437B != null) {
            this.f17437B.cancel();
        }
    }

    /* renamed from: k */
    private void m19112k() {
        m19111j();
        postDelayed(this.f17447L, 600);
    }

    /* renamed from: l */
    private void m19113l() {
        m19111j();
        postDelayed(this.f17448M, 600);
    }

    /* renamed from: m */
    private void m19114m() {
        m19111j();
        this.f17447L.run();
    }

    /* renamed from: n */
    private void m19115n() {
        m19111j();
        this.f17448M.run();
    }

    /* renamed from: a */
    private boolean m19102a(float f, float f2) {
        this.f17478z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return this.f17478z.getFinalY() > this.f17458f.getHeight();
    }

    public void setWindowCallback(Window.Callback callback) {
        mo25892c();
        this.f17461i.mo27119a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo25892c();
        this.f17461i.mo27122a(charSequence);
    }

    public CharSequence getTitle() {
        mo25892c();
        return this.f17461i.mo27140f();
    }

    /* renamed from: a */
    public void mo25888a(int i) {
        mo25892c();
        if (i == 2) {
            this.f17461i.mo27141g();
        } else if (i == 5) {
            this.f17461i.mo27142h();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public void setUiOptions(int i) {
        boolean z;
        this.f17442G = i;
        int i2 = 0;
        boolean z2 = true;
        boolean z3 = (i & 1) != 0;
        if (z3) {
            z = getContext().getResources().getBoolean(R.bool.mz_split_action_bar_is_narrow);
        } else {
            z = this.f17438C;
        }
        if (i != 2) {
            z2 = false;
        }
        if (!z || !z2) {
            mo25892c();
            ActionBarContextView actionBarContextView = (ActionBarContextView) findViewById(R.id.action_context_bar);
            if (z) {
                if (this.f17457e == null || !this.f17461i.mo27143i()) {
                    Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                    return;
                } else {
                    this.f17461i.mo27118a((ViewGroup) this.f17457e);
                    actionBarContextView.setSplitView(this.f17457e);
                }
            } else if (!z2) {
                this.f17461i.mo27118a((ViewGroup) null);
                if (!actionBarContextView.mo25858e()) {
                    actionBarContextView.setSplitView((ViewGroup) null);
                }
            } else if (this.f17457e != null) {
                this.f17461i.mo27118a((ViewGroup) this.f17457e);
            } else {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f17461i.mo27123a(z);
            this.f17461i.mo27139e(z2);
            this.f17461i.mo27129b(z3);
            actionBarContextView.setSplitToolbar(z);
            actionBarContextView.setSplitWhenNarrow(z3);
            if (this.f17457e != null) {
                ActionBarContainer actionBarContainer = this.f17457e;
                if (!this.f17461i.mo27133c() && !actionBarContextView.mo25858e() && !z2) {
                    i2 = 8;
                }
                actionBarContainer.setVisibility(i2);
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
    }

    public void setIcon(int i) {
        mo25892c();
        this.f17461i.mo27115a(i);
    }

    public void setIcon(Drawable drawable) {
        mo25892c();
        this.f17461i.mo27116a(drawable);
    }

    public void setLogo(int i) {
        mo25892c();
        this.f17461i.mo27125b(i);
    }

    /* renamed from: d */
    public boolean mo25894d() {
        mo25892c();
        return this.f17461i.mo27144j();
    }

    /* renamed from: e */
    public boolean mo25896e() {
        mo25892c();
        return this.f17461i.mo27145k();
    }

    /* renamed from: f */
    public boolean mo25897f() {
        mo25892c();
        return this.f17461i.mo27146l();
    }

    /* renamed from: g */
    public boolean mo25899g() {
        mo25892c();
        return this.f17461i.mo27147m();
    }

    /* renamed from: h */
    public boolean mo25905h() {
        mo25892c();
        return this.f17461i.mo27148n();
    }

    public void setMenuPrepared() {
        mo25892c();
        this.f17461i.mo27149o();
    }

    public void setMenu(Menu menu, MenuPresenter.C3167a aVar) {
        mo25892c();
        this.f17461i.mo27117a(menu, aVar);
    }

    /* renamed from: i */
    public void mo25906i() {
        mo25892c();
        this.f17461i.mo27150p();
    }

    public void setDropDownShowStart(int i) {
        this.f17440E = i;
    }

    /* renamed from: flyme.support.v7.widget.ActionBarOverlayLayout$b */
    public static class C3179b extends ViewGroup.MarginLayoutParams {
        public C3179b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3179b(int i, int i2) {
            super(i, i2);
        }

        public C3179b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: a */
    private boolean m19103a(Rect rect) {
        if ((getWindowSystemUiVisibility() & 256) != 0 || this.f17451P) {
            if (!this.f17441F) {
                rect.top = ResourceUtils.m5161a(getContext());
            }
            this.f17458f.setPadding(this.f17458f.getPaddingLeft(), rect.top, this.f17458f.getPaddingRight(), this.f17458f.getPaddingBottom());
            m19104a(this.f17458f, new Rect(0, 0, 0, 0), true, true, true, true);
            return true;
        }
        this.f17458f.setPadding(this.f17458f.getPaddingLeft(), 0, this.f17458f.getPaddingRight(), this.f17458f.getPaddingBottom());
        return m19104a(this.f17458f, rect, true, true, false, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25890a(Rect rect, Rect rect2) {
        if (C3352x.m20914a(this, this.f17473u, this.f17470r)) {
            return true;
        }
        if (!super.getFitsSystemWindows() && !this.f17443H) {
            rect2.bottom = rect.bottom;
            rect.bottom = 0;
        }
        return false;
    }

    public void setTransStatusBarInFlyme3(boolean z) {
        this.f17451P = z;
    }

    public void setBottomMenu(Menu menu, MenuPresenter.C3167a aVar) {
        mo25892c();
        this.f17461i.mo27127b(menu, aVar);
    }

    public void setSplitBarFitSystemWindows(boolean z) {
        this.f17439D = z;
    }

    public void setActionBarFitStatusBar(boolean z) {
        this.f17441F = z;
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f17460h = actionBarDropDownView;
    }

    public void setFullWindowContent(boolean z) {
        if (this.f17443H != z) {
            this.f17443H = z;
            requestLayout();
        }
    }

    public void setBackTopEnable(boolean z) {
        this.f17444I = z;
        if (z) {
            this.f17459g.setBackgroundResource(R.drawable.mz_list_backtop_bg);
        }
    }

    public void setBackTopBackground(Drawable drawable) {
        if (!this.f17444I) {
            return;
        }
        if (drawable != null) {
            this.f17452Q = drawable;
            this.f17459g.setBackground(this.f17452Q);
            return;
        }
        this.f17459g.setBackgroundResource(R.drawable.mz_list_backtop_bg);
    }

    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.f17459g.setOnClickListener(onClickListener);
    }
}
