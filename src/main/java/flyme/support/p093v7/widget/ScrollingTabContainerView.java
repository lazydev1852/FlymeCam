package flyme.support.p093v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.p094a.EmptyDivider;
import flyme.support.p093v7.view.ActionBarPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: flyme.support.v7.widget.ScrollingTabContainerView */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Interpolator f18199f = PathInterpolatorCompat.create(0.17f, 0.17f, 0.2f, 1.0f);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Interpolator f18200g = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 0.83f);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Interpolator f18201h = PathInterpolatorCompat.create(0.17f, 0.17f, 0.2f, 1.0f);

    /* renamed from: p */
    private static final Interpolator f18202p = new DecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f18203A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f18204B;

    /* renamed from: a */
    Runnable f18205a;

    /* renamed from: b */
    int f18206b;

    /* renamed from: c */
    int f18207c;

    /* renamed from: d */
    protected ViewPropertyAnimatorCompat f18208d;

    /* renamed from: e */
    protected final VisibilityAnimListener f18209e;

    /* renamed from: i */
    private C3304b f18210i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SlidingTabStrip f18211j;

    /* renamed from: k */
    private Spinner f18212k;

    /* renamed from: l */
    private boolean f18213l;

    /* renamed from: m */
    private boolean f18214m;

    /* renamed from: n */
    private int f18215n;

    /* renamed from: o */
    private int f18216o;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f18217q;

    /* renamed from: r */
    private boolean f18218r;

    /* renamed from: s */
    private int f18219s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f18220t;

    /* renamed from: u */
    private int f18221u;

    /* renamed from: v */
    private int f18222v;

    /* renamed from: w */
    private int f18223w;

    /* renamed from: x */
    private int f18224x;

    /* renamed from: y */
    private int f18225y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f18226z;

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public ScrollingTabContainerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScrollingTabContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzActionBarTabScrollViewStyle);
    }

    public ScrollingTabContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18209e = new VisibilityAnimListener();
        this.f18217q = 0;
        this.f18218r = false;
        this.f18219s = 17;
        this.f18226z = false;
        this.f18204B = false;
        setOverScrollMode(2);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_scroll_fading_edge_length));
        ActionBarPolicy a = ActionBarPolicy.m18758a(context);
        setContentHeight(a.mo25416e());
        this.f18207c = a.mo25418g();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.MzActionBarTabScrollView, i, 0);
        this.f18221u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTabScrollView2TabsPadding, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_2_tabs_padding));
        this.f18222v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTabScrollViewOver5TabsPadding, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_over_5_tabs_padding));
        this.f18223w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTabScrollView3TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_3_tabs_width));
        this.f18224x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTabScrollView4TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_4_tabs_width));
        this.f18225y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTabScrollViewNoCollapse5TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_5_tabs_nocollapse_width));
        obtainStyledAttributes.recycle();
        this.f18211j = m20152g();
        addView(this.f18211j, new ViewGroup.LayoutParams(-2, -1));
    }

    @TargetApi(16)
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        setTabsGravity(this.f18219s);
        int childCount = this.f18211j.getChildCount();
        this.f18211j.setShowDividers(0);
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f18206b = -1;
        } else {
            if (childCount > 2) {
                this.f18206b = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f18206b = View.MeasureSpec.getSize(i) / 2;
            }
            this.f18206b = Math.min(this.f18206b, this.f18207c);
            if (!this.f18203A && Build.VERSION.SDK_INT >= 16) {
                this.f18220t = 0;
                if (childCount > 2 && childCount < 5 && this.f18218r) {
                    this.f18220t = View.MeasureSpec.getSize(i) / childCount;
                } else if (childCount < 5 || !this.f18214m) {
                    if (!this.f18226z) {
                        switch (childCount) {
                            case 2:
                                for (int i3 = 0; i3 < childCount; i3++) {
                                    this.f18211j.getChildAt(i3).setPadding(this.f18221u, 0, this.f18221u, 0);
                                }
                                break;
                            case 3:
                                this.f18220t = this.f18223w;
                                setTabsGravityInner(17);
                                break;
                            case 4:
                                this.f18220t = this.f18224x;
                                break;
                            case 5:
                                this.f18220t = this.f18225y;
                                setTabsGravityInner(17);
                                break;
                        }
                    } else {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int i4 = 0;
                        for (int i5 = 0; i5 < childCount; i5++) {
                            View childAt = this.f18211j.getChildAt(i5);
                            childAt.measure(makeMeasureSpec, i2);
                            i4 += childAt.getMeasuredWidth();
                        }
                        int size = View.MeasureSpec.getSize(i);
                        for (int i6 = 0; i6 < childCount; i6++) {
                            View childAt2 = this.f18211j.getChildAt(i6);
                            LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt2.getLayoutParams();
                            layoutParams.width = (int) (((float) (childAt2.getMeasuredWidth() * size)) / ((float) i4));
                            layoutParams.weight = 0.0f;
                        }
                    }
                } else {
                    for (int i7 = 0; i7 < childCount; i7++) {
                        this.f18211j.getChildAt(i7).setPadding(this.f18222v, 0, this.f18222v, 0);
                    }
                    this.f18211j.setShowDividers(2);
                }
            }
        }
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f18215n, 1073741824);
        if (z2 || !this.f18213l) {
            z = false;
        }
        if (z) {
            this.f18211j.measure(0, makeMeasureSpec2);
            if (this.f18211j.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m20148e();
            } else {
                m20151f();
            }
        } else {
            m20151f();
        }
        getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec2);
        getMeasuredWidth();
    }

    /* renamed from: d */
    private boolean m20146d() {
        return this.f18212k != null && this.f18212k.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f18213l = z;
    }

    public void setNeedCollapse(boolean z) {
        this.f18214m = z;
    }

    /* renamed from: e */
    private void m20148e() {
        if (!m20146d()) {
            if (this.f18212k == null) {
                this.f18212k = m20153h();
            }
            removeView(this.f18211j);
            addView(this.f18212k, new ViewGroup.LayoutParams(-2, -1));
            if (this.f18212k.getAdapter() == null) {
                this.f18212k.setAdapter(new C3303a());
            }
            if (this.f18205a != null) {
                removeCallbacks(this.f18205a);
                this.f18205a = null;
            }
            this.f18212k.setSelection(this.f18216o);
        }
    }

    /* renamed from: f */
    private boolean m20151f() {
        if (!m20146d()) {
            return false;
        }
        removeView(this.f18212k);
        addView(this.f18211j, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f18212k.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        setTabSelected(i, false);
    }

    public void setTabSelected(int i, boolean z) {
        this.f18216o = i;
        int childCount = this.f18211j.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f18211j.getChildAt(i2);
            boolean z2 = i2 == i;
            childAt.setSelected(z2);
            if (z2) {
                if (z) {
                    mo26801a(i);
                } else {
                    this.f18211j.mo26826a(i, 0);
                }
            }
            i2++;
        }
        if (this.f18212k != null && i >= 0) {
            this.f18212k.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f18215n = i;
        requestLayout();
    }

    /* renamed from: g */
    private SlidingTabStrip m20152g() {
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        slidingTabStrip.setGravity(this.f18219s);
        slidingTabStrip.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return slidingTabStrip;
    }

    /* renamed from: h */
    private Spinner m20153h() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        ActionBarPolicy a = ActionBarPolicy.m18758a(getContext());
        setContentHeight(this.f18203A ? a.mo25419h() : a.mo25416e());
        this.f18207c = a.mo25418g();
    }

    /* renamed from: a */
    public void mo26801a(final int i) {
        final View childAt = this.f18211j.getChildAt(i);
        if (this.f18205a != null) {
            removeCallbacks(this.f18205a);
        }
        this.f18205a = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f18211j.mo26826a(i, 400);
                ScrollingTabContainerView.this.f18205a = null;
            }
        };
        post(this.f18205a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18205a != null) {
            post(this.f18205a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f18205a != null) {
            removeCallbacks(this.f18205a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public TabView m20141b(ActionBar.C3077g gVar, boolean z) {
        TabView tabView = new TabView(getContext(), gVar, z);
        if (z) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f18215n));
        } else {
            tabView.setFocusable(true);
            if (this.f18210i == null) {
                this.f18210i = new C3304b();
            }
            tabView.setOnClickListener(this.f18210i);
        }
        return tabView;
    }

    /* renamed from: a */
    public void mo26802a(ActionBar.C3077g gVar, boolean z) {
        TabView b = m20141b(gVar, false);
        this.f18211j.addView(b, new LinearLayoutCompat.LayoutParams(-2, -1));
        if (this.f18212k != null) {
            ((C3303a) this.f18212k.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            b.setSelected(true);
            this.f18211j.mo26825a(this.f18211j.getChildCount() - 1, 0.0f);
        }
        if (this.f18213l) {
            requestLayout();
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).getTab().mo25078f();
    }

    /* renamed from: a */
    public void mo26803a(boolean z) {
        if (this.f18203A != z) {
            this.f18203A = z;
            ActionBarPolicy a = ActionBarPolicy.m18758a(getContext());
            setContentHeight(this.f18203A ? a.mo25419h() : a.mo25416e());
            if (this.f18211j != null) {
                this.f18211j.setAtToolbar(this.f18203A);
            }
            if (this.f18211j != null && this.f18211j.getChildCount() > 0) {
                int childCount = this.f18211j.getChildCount();
                ArrayList arrayList = new ArrayList();
                int i = this.f18216o;
                for (int i2 = 0; i2 < childCount; i2++) {
                    TabView tabView = (TabView) this.f18211j.getChildAt(i2);
                    if (tabView.isSelected()) {
                        i = i2;
                    }
                    arrayList.add(tabView.getTab());
                }
                this.f18211j.removeAllViews();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ActionBar.C3077g gVar = (ActionBar.C3077g) it.next();
                    mo26802a(gVar, gVar.mo25070a() == i);
                }
                setTabSelected(i);
            }
        }
    }

    public void setTabsGravity(int i) {
        this.f18219s = i;
        if (this.f18211j != null) {
            this.f18211j.setGravity(this.f18219s);
        }
    }

    private void setTabsGravityInner(int i) {
        if (this.f18211j != null) {
            this.f18211j.setGravity(i);
        }
    }

    /* renamed from: flyme.support.v7.widget.ScrollingTabContainerView$TabView */
    private class TabView extends LinearLayoutCompat implements View.OnLongClickListener {

        /* renamed from: b */
        private final int[] f18255b;

        /* renamed from: c */
        private ActionBar.C3077g f18256c;

        /* renamed from: d */
        private TextView f18257d;

        /* renamed from: e */
        private ImageView f18258e;

        /* renamed from: f */
        private View f18259f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TabView(Context context, ActionBar.C3077g gVar, boolean z) {
            super(context, (AttributeSet) null, ScrollingTabContainerView.this.f18203A ? R.attr.mzToolBarTabStyle : R.attr.actionBarTabStyle);
            this.f18255b = new int[]{16842964};
            this.f18256c = gVar;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, this.f18255b, ScrollingTabContainerView.this.f18203A ? R.attr.mzToolBarTabStyle : R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            mo26837a();
        }

        /* renamed from: a */
        public void mo26838a(ActionBar.C3077g gVar) {
            this.f18256c = gVar;
            mo26837a();
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.C3077g.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(ActionBar.C3077g.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f18220t > 0 && getMeasuredWidth() < ScrollingTabContainerView.this.f18220t && !ScrollingTabContainerView.this.f18226z) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f18220t, 1073741824), i2);
            }
        }

        /* renamed from: a */
        public void mo26837a() {
            CustomTabView fVar;
            ActionBar.C3077g gVar = this.f18256c;
            View e = gVar.mo25077e();
            boolean z = true;
            boolean z2 = false;
            if (e != null) {
                ViewParent parent = e.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(e);
                    }
                    addView(e);
                }
                this.f18259f = e;
                if (this.f18257d != null) {
                    this.f18257d.setVisibility(8);
                }
                if (this.f18258e != null) {
                    this.f18258e.setVisibility(8);
                    this.f18258e.setImageDrawable((Drawable) null);
                }
                if ((e instanceof CustomTabView) && (fVar = (CustomTabView) e) != null) {
                    this.f18257d = fVar.getTabTextView();
                }
            } else {
                if (this.f18259f != null) {
                    removeView(this.f18259f);
                    this.f18259f = null;
                }
                Drawable b = gVar.mo25074b();
                CharSequence c = gVar.mo25075c();
                ColorStateList d = gVar.mo25076d();
                int i = 16;
                if (b != null) {
                    if (this.f18258e == null) {
                        ImageView imageView = new ImageView(getContext());
                        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        imageView.setLayoutParams(layoutParams);
                        addView(imageView, 0);
                        this.f18258e = imageView;
                    }
                    this.f18258e.setImageDrawable(b);
                    this.f18258e.setVisibility(0);
                } else if (this.f18258e != null) {
                    this.f18258e.setVisibility(8);
                    this.f18258e.setImageDrawable((Drawable) null);
                }
                boolean z3 = !TextUtils.isEmpty(c);
                if (z3) {
                    if (this.f18257d == null) {
                        int i2 = ScrollingTabContainerView.this.f18203A ? R.attr.mzToolBarTabTextStyle : R.attr.actionBarTabTextStyle;
                        if (ScrollingTabContainerView.this.f18204B) {
                            i2 = R.attr.mzAloneTabContainerTabTextStyle;
                        }
                        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, i2);
                        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                        LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                        if (!ScrollingTabContainerView.this.f18203A) {
                            i = 48;
                        }
                        layoutParams2.gravity = i;
                        appCompatTextView.setLayoutParams(layoutParams2);
                        addView(appCompatTextView);
                        this.f18257d = appCompatTextView;
                    }
                    this.f18257d.setText(c);
                    if (d != null) {
                        this.f18257d.setTextColor(d);
                    }
                    this.f18257d.setVisibility(0);
                    this.f18257d.setEnabled(gVar.mo25080h());
                } else if (this.f18257d != null) {
                    this.f18257d.setVisibility(8);
                    this.f18257d.setText((CharSequence) null);
                }
                if (this.f18258e != null) {
                    this.f18258e.setContentDescription(gVar.mo25079g());
                }
                if (z3 || TextUtils.isEmpty(gVar.mo25079g())) {
                    setOnLongClickListener((View.OnLongClickListener) null);
                    setLongClickable(false);
                } else {
                    setOnLongClickListener(this);
                }
            }
            setEnabled(gVar.mo25080h());
            int i3 = gVar.mo25081i();
            int j = gVar.mo25082j();
            if (i3 >= 0) {
                z2 = true;
            } else {
                i3 = getPaddingLeft();
            }
            if (j < 0) {
                j = getPaddingRight();
                z = z2;
            }
            if (z) {
                setPadding(i3, getPaddingTop(), j, getPaddingBottom());
            }
            int k = gVar.mo25083k();
            if (k >= 0) {
                setMinimumWidth(k);
            }
            if (this.f18257d != null) {
                this.f18257d.setEllipsize(TextUtils.TruncateAt.END);
            }
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f18256c.mo25079g(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public ActionBar.C3077g getTab() {
            return this.f18256c;
        }

        private TextView getContentTextView() {
            return this.f18257d;
        }
    }

    /* renamed from: flyme.support.v7.widget.ScrollingTabContainerView$a */
    private class C3303a extends BaseAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        private C3303a() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f18211j.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.f18211j.getChildAt(i)).getTab();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m20141b((ActionBar.C3077g) getItem(i), true);
            }
            ((TabView) view).mo26838a((ActionBar.C3077g) getItem(i));
            return view;
        }
    }

    /* renamed from: flyme.support.v7.widget.ScrollingTabContainerView$b */
    private class C3304b implements View.OnClickListener {
        private C3304b() {
        }

        public void onClick(View view) {
            ((TabView) view).getTab().mo25073a(true);
            int childCount = ScrollingTabContainerView.this.f18211j.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f18211j.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.ScrollingTabContainerView$VisibilityAnimListener */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: b */
        private boolean f18261b = false;

        /* renamed from: c */
        private int f18262c;

        protected VisibilityAnimListener() {
        }

        public void onAnimationStart(View view) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f18261b = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f18261b) {
                ScrollingTabContainerView.this.f18208d = null;
                ScrollingTabContainerView.this.setVisibility(this.f18262c);
            }
        }

        public void onAnimationCancel(View view) {
            this.f18261b = true;
        }
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f18211j.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            this.f18211j.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    public void setScrollPosition(int i, float f, boolean z) {
        if (!m20142b(getAnimation()) && i >= 0 && i < this.f18211j.getChildCount()) {
            this.f18211j.mo26825a(i, f);
            smoothScrollTo(m20133a(i, f), 0);
            if (z) {
                setSelectedTabView(Math.round(((float) i) + f));
            }
        }
    }

    /* renamed from: a */
    private int m20133a(int i, float f) {
        int i2 = 0;
        if (this.f18217q != 0) {
            return 0;
        }
        View childAt = this.f18211j.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.f18211j.getChildCount() ? this.f18211j.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        if (this.f18211j.getShowDividers() == 2) {
            i2 = this.f18211j.getDividerDrawable().getIntrinsicWidth();
        }
        return (int) (((((float) childAt.getLeft()) + ((((float) ((width + width2) + (i2 * 2))) * f) * 0.5f)) + (((float) childAt.getWidth()) * 0.5f)) - (((float) getWidth()) * 0.5f));
    }

    /* renamed from: flyme.support.v7.widget.ScrollingTabContainerView$SlidingTabStrip */
    private class SlidingTabStrip extends LinearLayoutCompat {

        /* renamed from: b */
        private int f18231b;

        /* renamed from: c */
        private int f18232c;

        /* renamed from: d */
        private final Paint f18233d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f18234e = -1;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public float f18235f;

        /* renamed from: g */
        private int f18236g = -1;

        /* renamed from: h */
        private int f18237h = -1;

        /* renamed from: i */
        private ValueAnimator f18238i;

        /* renamed from: j */
        private Drawable f18239j;

        /* renamed from: k */
        private int f18240k;

        /* renamed from: l */
        private int f18241l;

        /* renamed from: m */
        private int f18242m;

        /* renamed from: n */
        private int f18243n;

        /* renamed from: o */
        private int f18244o;

        /* renamed from: p */
        private int f18245p;

        /* renamed from: q */
        private int f18246q;

        public SlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setWillNotDraw(false);
            this.f18233d = new Paint();
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.MzActionBarTabBar, i, 0);
            this.f18232c = obtainStyledAttributes.getColor(R.styleable.MzActionBarTabBar_mzTabBarIndicatorColor, getResources().getColor(R.color.mz_action_bar_tab_indicator_default_color));
            this.f18233d.setColor(this.f18232c);
            this.f18231b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorHeight, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_height));
            this.f18239j = obtainStyledAttributes.getDrawable(R.styleable.MzActionBarTabBar_mzTabBarIndicatorDrawable);
            this.f18242m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_width));
            this.f18241l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorWidthSecond, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_width_second));
            if (ScrollingTabContainerView.this.f18203A) {
                this.f18240k = this.f18242m;
            } else {
                this.f18240k = this.f18241l;
            }
            this.f18246q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorExceedContent, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_indicator_exceed_content));
            this.f18243n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorPaddingBottom, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_padding_bottom));
            this.f18244o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzActionBarTabBar_mzTabBarIndicatorPaddingBottomAtToolBar, getResources().getDimensionPixelSize(R.dimen.mz_tool_bar_tab_indicator_padding_bottom));
            obtainStyledAttributes.recycle();
            this.f18245p = getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_edge_max_move_width);
            setMotionEventSplittingEnabled(false);
            EmptyDivider aVar = new EmptyDivider();
            aVar.mo25013a(33);
            setDividerDrawable(aVar);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorColor(int i) {
            this.f18233d.setColor(i);
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorHeight(int i) {
            this.f18231b = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorWidth(int i) {
            this.f18240k = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorPaddingBottom(int i) {
            this.f18243n = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorPaddingBottomAtToolBar(int i) {
            this.f18244o = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void setAtToolbar(boolean z) {
            if (z) {
                this.f18240k = this.f18242m;
            } else {
                this.f18240k = this.f18241l;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26825a(int i, float f) {
            if (!ScrollingTabContainerView.m20142b(getAnimation())) {
                mo26824a();
                this.f18234e = i;
                this.f18235f = f;
                m20162b();
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && ScrollingTabContainerView.this.f18217q == 1) {
                int childCount = getChildCount();
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    childAt.measure(makeMeasureSpec, i2);
                    i3 = Math.max(i3, childAt.getMeasuredWidth());
                }
                if (i3 > 0) {
                    if (i3 * childCount <= getMeasuredWidth() - (ScrollingTabContainerView.this.m20139b(16) * 2)) {
                        for (int i5 = 0; i5 < childCount; i5++) {
                            LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) getChildAt(i5).getLayoutParams();
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                        }
                    }
                    super.onMeasure(i, i2);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (!ScrollingTabContainerView.m20142b(getAnimation())) {
                m20162b();
            }
        }

        /* renamed from: b */
        private void m20162b() {
            int i;
            int i2;
            View childAt = getChildAt(this.f18234e);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i = -1;
            } else {
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                i2 = left - (this.f18240k / 2);
                i = left + (this.f18240k / 2);
                if (this.f18235f > 0.0f && this.f18234e < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f18234e + 1);
                    int left2 = (childAt2.getLeft() + childAt2.getRight()) / 2;
                    int a = m20158a(childAt2) / 2;
                    m20160a(this.f18235f, i2, i, left2 - a, left2 + a);
                    return;
                }
            }
            m20163b(i2, i);
        }

        /* renamed from: b */
        private void m20163b(int i, int i2) {
            if (i != this.f18236g || i2 != this.f18237h) {
                this.f18236g = i;
                this.f18237h = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m20160a(float f, int i, int i2, int i3, int i4) {
            Interpolator interpolator;
            float f2;
            float max = Math.max(Math.min(f, 1.0f), 0.0f);
            if (max < 0.325f) {
                f2 = max / 0.325f;
                interpolator = ScrollingTabContainerView.f18200g;
            } else {
                f2 = (1.0f - max) / 0.675f;
                interpolator = ScrollingTabContainerView.f18201h;
            }
            int interpolation = this.f18240k + ((int) (interpolator.getInterpolation(f2) * ((float) this.f18245p)));
            if (i < i3) {
                i2 = AnimationUtils.m19217a(i2, i4, ScrollingTabContainerView.f18199f.getInterpolation(max));
                i = i2 - interpolation;
            } else if (i > i3) {
                i = AnimationUtils.m19217a(i, i3, ScrollingTabContainerView.f18199f.getInterpolation(max));
                i2 = i + interpolation;
            }
            m20163b(i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26826a(final int i, int i2) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            View childAt = getChildAt(i);
            if (childAt != null) {
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                int a = m20158a(childAt) / 2;
                final int i3 = left - a;
                final int i4 = left + a;
                final int i5 = this.f18236g;
                final int i6 = this.f18237h;
                if ((i5 == i3 && i6 == i4) || i5 < 0 || i6 < 0) {
                    this.f18234e = i;
                    this.f18235f = 0.0f;
                } else if (i2 > 0) {
                    if (this.f18238i != null && this.f18238i.isRunning()) {
                        this.f18238i.cancel();
                    }
                    this.f18238i = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                    this.f18238i.setDuration((long) i2);
                    this.f18238i.setInterpolator((TimeInterpolator) null);
                    this.f18238i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SlidingTabStrip.this.m20160a(valueAnimator.getAnimatedFraction(), i5, i6, i3, i4);
                        }
                    });
                    this.f18238i.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            int unused = SlidingTabStrip.this.f18234e = i;
                            float unused2 = SlidingTabStrip.this.f18235f = 0.0f;
                        }

                        public void onAnimationCancel(Animator animator) {
                            int unused = SlidingTabStrip.this.f18234e = i;
                            float unused2 = SlidingTabStrip.this.f18235f = 0.0f;
                        }
                    });
                    this.f18238i.start();
                } else {
                    m20160a(1.0f, i5, i6, i3, i4);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            if (this.f18236g >= 0 && this.f18237h > this.f18236g) {
                int i = ScrollingTabContainerView.this.f18203A ? this.f18244o : this.f18243n;
                if (this.f18239j != null) {
                    this.f18239j.setBounds(this.f18236g, (getHeight() - this.f18231b) - i, this.f18237h, getHeight() - i);
                    this.f18239j.draw(canvas);
                    return;
                }
                canvas.drawRect((float) this.f18236g, (float) ((getHeight() - this.f18231b) - i), (float) this.f18237h, (float) (getHeight() - i), this.f18233d);
            }
        }

        /* renamed from: a */
        public void mo26824a() {
            if (this.f18238i != null && this.f18238i.isRunning()) {
                this.f18238i.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorDrawable(Drawable drawable) {
            if (this.f18239j != drawable) {
                this.f18239j = drawable;
                invalidate();
            }
        }

        /* renamed from: a */
        private int m20158a(View view) {
            return this.f18240k;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m20139b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m20142b(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.f18211j.setIndicatorDrawable(drawable);
    }

    public int getTabStripWidth() {
        return this.f18211j.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setEqualTabWidth(boolean z) {
        this.f18218r = z;
    }

    public void setIsAloneTabContainer(boolean z) {
        this.f18204B = z;
    }

    public void setAdaptTabWidthNoScroll(boolean z) {
        if (this.f18226z != z) {
            this.f18226z = z;
            requestLayout();
        }
    }
}
