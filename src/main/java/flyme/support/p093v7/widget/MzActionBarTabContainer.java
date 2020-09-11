package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.widget.AnimationUtils;
import flyme.support.p093v7.widget.TabCollapseButton;

/* renamed from: flyme.support.v7.widget.MzActionBarTabContainer */
public class MzActionBarTabContainer extends ViewGroup {

    /* renamed from: a */
    protected AnimationUtils.AlphaVisibilityAnimator f17673a;

    /* renamed from: b */
    protected AnimationUtils.AlphaVisibilityAnimator f17674b;

    /* renamed from: c */
    private boolean f17675c;

    /* renamed from: d */
    private ScrollingTabContainerView f17676d;

    /* renamed from: e */
    private TabCollapseButton f17677e;

    /* renamed from: f */
    private Context f17678f;

    /* renamed from: g */
    private int f17679g;

    /* renamed from: h */
    private int f17680h;

    /* renamed from: i */
    private final Paint f17681i;

    /* renamed from: j */
    private boolean f17682j;

    /* renamed from: k */
    private boolean f17683k = false;

    /* renamed from: l */
    private TabCollapseButton.C3311a f17684l;

    /* renamed from: m */
    private boolean f17685m = false;

    /* renamed from: n */
    private boolean f17686n = true;

    /* renamed from: o */
    private Drawable f17687o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ActionBar.C3076f f17688p;

    /* renamed from: q */
    private TextView f17689q;

    /* renamed from: r */
    private int f17690r;

    /* renamed from: s */
    private int f17691s;

    /* renamed from: t */
    private boolean f17692t;

    /* renamed from: u */
    private ViewPropertyAnimatorListener f17693u = new ViewPropertyAnimatorListener() {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationStart(View view) {
            if (MzActionBarTabContainer.this.f17688p != null) {
                MzActionBarTabContainer.this.f17688p.mo25068a(MzActionBarTabContainer.this.f17674b.mo26010c() == 0);
            }
        }

        public void onAnimationEnd(View view) {
            if (MzActionBarTabContainer.this.f17688p != null) {
                MzActionBarTabContainer.this.f17688p.mo25069b(MzActionBarTabContainer.this.f17674b.mo26010c() == 0);
            }
        }
    };

    public MzActionBarTabContainer(Context context) {
        super(context, (AttributeSet) null, R.attr.mzActionBarTabContainerStyle);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, R.styleable.MzActionBarTabContainer, R.attr.mzActionBarTabContainerStyle, 0);
        this.f17675c = obtainStyledAttributes.getBoolean(R.styleable.MzActionBarTabContainer_mzAllowCollapse, false);
        obtainStyledAttributes.recycle();
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, R.styleable.MzActionBarTabScrollView, R.attr.mzActionBarTabScrollViewStyle, 0);
        this.f17680h = obtainStyledAttributes2.getColor(R.styleable.MzActionBarTabScrollView_mzTopDividerColor, getResources().getColor(R.color.mz_action_bar_scrollview_divider_default_color));
        this.f17679g = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.MzActionBarTabScrollView_mzTopDividerHeight, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_scroll_top_divider_height));
        this.f17691s = obtainStyledAttributes2.getColor(R.styleable.MzActionBarTabScrollView_mzTabScrollViewExpendTitleColor, getResources().getColor(R.color.mz_white_action_bar_textcolor));
        this.f17690r = obtainStyledAttributes2.getResourceId(R.styleable.MzActionBarTabScrollView_mzTabScrollViewExpendTitleTextAppearance, R.style.TextAppearance_Flyme_AppCompat_Widget_ActionBar_TabScrollView_ExpendTitle);
        obtainStyledAttributes2.recycle();
        this.f17678f = context;
        this.f17681i = new Paint();
        this.f17681i.setColor(this.f17680h);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public void setAllowCollapse(boolean z) {
        if (this.f17675c != z) {
            this.f17675c = z;
            requestLayout();
        }
    }

    public void setTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f17676d != scrollingTabContainerView || this.f17676d.getParent() != this) {
            if (this.f17676d != null) {
                removeView(this.f17676d);
            }
            this.f17676d = scrollingTabContainerView;
            if (scrollingTabContainerView != null) {
                addView(scrollingTabContainerView);
                scrollingTabContainerView.setAllowCollapse(false);
            }
        }
    }

    public ScrollingTabContainerView getTabView() {
        return this.f17676d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            boolean z = false;
            int dimensionPixelSize = !this.f17685m ? getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left) : 0;
            boolean z2 = true;
            if (this.f17683k) {
                this.f17676d.setEqualTabWidth(false);
            } else if (!this.f17686n) {
                this.f17676d.setEqualTabWidth(true);
            }
            if (m19356a((View) this.f17676d)) {
                this.f17676d.setNeedCollapse(false);
                int i5 = dimensionPixelSize * 2;
                this.f17676d.measure(View.MeasureSpec.makeMeasureSpec(size - i5, View.MeasureSpec.getMode(i)), i2);
                if (!this.f17675c || (size >= this.f17676d.getTabStripWidth() + i5 && !this.f17683k)) {
                    z2 = false;
                } else {
                    z = true;
                }
                i3 = this.f17676d.getMeasuredHeight();
            } else {
                i3 = 0;
                z2 = false;
            }
            if (z != this.f17682j) {
                if (z) {
                    m19357b();
                } else {
                    m19354a();
                }
                this.f17682j = z;
            }
            if (!this.f17692t) {
                if (z) {
                    this.f17676d.setTabsGravity(3);
                } else {
                    this.f17676d.setTabsGravity(17);
                }
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            if (m19356a((View) this.f17677e)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17677e.getLayoutParams();
                this.f17677e.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                i4 = size - ((this.f17677e.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
            } else {
                i4 = size;
            }
            if (m19356a((View) this.f17689q)) {
                this.f17689q.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), makeMeasureSpec);
            }
            if (z2 && m19356a((View) this.f17676d)) {
                this.f17676d.setNeedCollapse(z);
                this.f17676d.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), makeMeasureSpec);
            }
            setMeasuredDimension(size, i3 + paddingTop);
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    }

    /* renamed from: a */
    private void m19354a() {
        if (this.f17677e != null) {
            this.f17677e.setVisibility(8);
        }
        if (this.f17689q != null) {
            this.f17689q.setVisibility(8);
        }
        if (this.f17685m) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    /* renamed from: b */
    private void m19357b() {
        if (this.f17677e == null) {
            this.f17677e = new TabCollapseButton(this.f17678f);
        }
        if (this.f17677e.getParent() != this) {
            addView(this.f17677e);
            ViewGroup.LayoutParams layoutParams = this.f17677e.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.f17677e.setOnTabCollapseButtonClickListener(this.f17684l);
        if (this.f17687o != null) {
            this.f17677e.setImageDrawable(this.f17687o);
        }
        this.f17677e.setVisibility(0);
        if (!this.f17685m) {
            setPadding(getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left), 0, 0, 0);
            this.f17677e.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        this.f17677e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setCollapseButtonClickListener(TabCollapseButton.C3311a aVar) {
        this.f17684l = aVar;
        if (this.f17677e != null) {
            this.f17677e.setOnTabCollapseButtonClickListener(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C3352x.m20913a((View) this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        if (m19356a((View) this.f17676d)) {
            m19355a(this.f17676d, paddingRight, a);
        }
        if (m19356a((View) this.f17689q)) {
            m19355a(this.f17689q, paddingRight, a);
        }
        if (m19356a((View) this.f17677e)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17677e.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            if (a) {
                i5 = getPaddingLeft() + i6;
            } else {
                i5 = ((getMeasuredWidth() - getPaddingRight()) - i7) - this.f17677e.getMeasuredWidth();
            }
            this.f17677e.layout(i5, 0, this.f17677e.getMeasuredWidth() + i5, this.f17677e.getMeasuredHeight());
        }
    }

    /* renamed from: a */
    private void m19355a(View view, int i, boolean z) {
        int i2;
        C3212a aVar = (C3212a) view.getLayoutParams();
        int i3 = z ? aVar.rightMargin : aVar.leftMargin;
        int i4 = z ? aVar.leftMargin : aVar.rightMargin;
        int paddingTop = getPaddingTop();
        int measuredHeight = getMeasuredHeight() - getPaddingBottom();
        int measuredWidth = z ? (i - i4) - view.getMeasuredWidth() : i + i3;
        int i5 = aVar.f17695a;
        if (i5 == -1) {
            i5 = 8388659;
        }
        int i6 = i5 & 112;
        int measuredHeight2 = view.getMeasuredHeight();
        if (i6 == 48) {
            i2 = paddingTop + aVar.topMargin;
        } else if (i6 != 80) {
            i2 = ((paddingTop + (((measuredHeight - paddingTop) - measuredHeight2) / 2)) + aVar.topMargin) - aVar.bottomMargin;
        } else {
            i2 = (measuredHeight - measuredHeight2) - aVar.bottomMargin;
        }
        view.layout(measuredWidth, i2, view.getMeasuredWidth() + measuredWidth, measuredHeight2 + i2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C3212a(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C3212a(getContext(), attributeSet);
    }

    /* renamed from: flyme.support.v7.widget.MzActionBarTabContainer$a */
    public static class C3212a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f17695a = 16;

        public C3212a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3212a(int i, int i2) {
            super(i, i2);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.f17685m && this.f17679g > 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_divider_padding);
            canvas.drawRect((float) dimensionPixelSize, 0.0f, (float) (getMeasuredWidth() - dimensionPixelSize), (float) this.f17679g, this.f17681i);
        }
    }

    public void setIsForceCollapse(boolean z) {
        if (this.f17683k != z) {
            this.f17683k = z;
            requestLayout();
        }
    }

    /* renamed from: a */
    public void mo26128a(boolean z) {
        this.f17676d.mo26803a(z);
        if (this.f17685m != z) {
            this.f17685m = z;
            if (this.f17685m) {
                setPadding(0, 0, 0, 0);
                if (this.f17689q != null && this.f17689q.getLayoutParams() != null) {
                    ((C3212a) this.f17689q.getLayoutParams()).f17695a = 16;
                }
            } else if (this.f17689q != null && this.f17689q.getLayoutParams() != null) {
                ((C3212a) this.f17689q.getLayoutParams()).f17695a = 48;
            }
        }
    }

    public void setCollapseButtonDrawable(Drawable drawable) {
        this.f17687o = drawable;
        if (this.f17677e != null && drawable != null) {
            this.f17677e.setImageDrawable(drawable);
        }
    }

    public void setupScrollTabsAnimatorToVisibility(int i, ActionBar.C3076f fVar) {
        if (this.f17674b != null) {
            this.f17674b.mo26006a();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = null;
        if (this.f17676d != null) {
            this.f17688p = fVar;
            this.f17674b = new AnimationUtils.AlphaVisibilityAnimator(this.f17676d, i);
            this.f17674b.mo26007a(100);
            this.f17674b.mo26008a(this.f17693u);
        } else {
            this.f17674b = null;
        }
        if (this.f17673a != null) {
            this.f17673a.mo26006a();
        }
        if (this.f17689q != null) {
            if (i == 4) {
                this.f17673a = new AnimationUtils.AlphaVisibilityAnimator(this.f17689q, 0);
            } else {
                this.f17673a = new AnimationUtils.AlphaVisibilityAnimator(this.f17689q, 4);
            }
            this.f17673a.mo26007a(100);
        } else {
            this.f17673a = null;
        }
        ViewPropertyAnimatorCompat b = this.f17674b != null ? this.f17674b.mo26009b() : null;
        if (this.f17673a != null) {
            viewPropertyAnimatorCompat = this.f17673a.mo26009b();
        }
        if (i == 4) {
            if (b != null) {
                b.start();
            }
            if (viewPropertyAnimatorCompat == null) {
                return;
            }
            if (b != null) {
                viewPropertyAnimatorCompat.setStartDelay(150);
            } else {
                viewPropertyAnimatorCompat.start();
            }
        } else {
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.start();
            }
            if (b == null) {
                return;
            }
            if (viewPropertyAnimatorCompat != null) {
                b.setStartDelay(150);
            } else {
                b.start();
            }
        }
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f17689q == null) {
                Context context = getContext();
                this.f17689q = new TextView(context);
                this.f17689q.setSingleLine();
                this.f17689q.setEllipsize(TextUtils.TruncateAt.END);
                this.f17689q.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_max_width));
                if (this.f17690r != 0) {
                    this.f17689q.setTextAppearance(context, this.f17690r);
                }
                if (this.f17691s != 0) {
                    this.f17689q.setTextColor(this.f17691s);
                }
                this.f17689q.setVisibility(8);
                addView(this.f17689q);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_padding_vertical);
                this.f17689q.setPadding(getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_margin_left), dimensionPixelSize, 0, dimensionPixelSize);
                C3212a aVar = (C3212a) this.f17689q.getLayoutParams();
                if (this.f17685m) {
                    aVar.f17695a = 16;
                } else {
                    aVar.f17695a = 48;
                }
            }
        } else if (this.f17689q != null) {
            removeView(this.f17689q);
            this.f17689q = null;
        }
        if (this.f17689q != null) {
            this.f17689q.setText(charSequence);
        }
    }

    public void setScrollTabsExpendTitleTextColor(int i) {
        this.f17691s = i;
        if (this.f17689q != null) {
            this.f17689q.setTextColor(i);
        }
    }

    public void setScrollTabsExpendTitleTextAppearance(int i) {
        this.f17690r = i;
        if (this.f17689q != null) {
            this.f17689q.setTextAppearance(getContext(), i);
        }
    }

    /* renamed from: a */
    private boolean m19356a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setPreventEqualWidth(boolean z) {
        this.f17686n = z;
    }

    public void setAdaptTabWidth(boolean z) {
        if (this.f17676d != null) {
            this.f17676d.setAdaptTabWidthNoScroll(z);
        }
    }

    public void setTabsGravity(int i) {
        this.f17692t = true;
        if (this.f17676d != null) {
            this.f17676d.setTabsGravity(i);
        }
    }
}
