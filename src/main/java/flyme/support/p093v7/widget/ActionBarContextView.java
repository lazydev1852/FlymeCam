package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.app.WindowDecorActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuPresenter;

/* renamed from: flyme.support.v7.widget.ActionBarContextView */
public class ActionBarContextView extends AbsActionBarView {
    /* access modifiers changed from: private */

    /* renamed from: y */
    public static final Interpolator f17396y = PathInterpolatorCompat.create(0.2f, 0.028f, 0.1f, 1.0f);

    /* renamed from: z */
    private static final Interpolator f17397z = f17396y;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ViewPropertyAnimatorCompat f17398A;

    /* renamed from: k */
    protected final SplitViewVisibilityAnimListener f17399k;

    /* renamed from: l */
    private CharSequence f17400l;

    /* renamed from: m */
    private CharSequence f17401m;

    /* renamed from: n */
    private View f17402n;

    /* renamed from: o */
    private View f17403o;

    /* renamed from: p */
    private LinearLayout f17404p;

    /* renamed from: q */
    private TextView f17405q;

    /* renamed from: r */
    private TextView f17406r;

    /* renamed from: s */
    private int f17407s;

    /* renamed from: t */
    private int f17408t;

    /* renamed from: u */
    private boolean f17409u;

    /* renamed from: v */
    private int f17410v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f17411w;

    /* renamed from: x */
    private boolean f17412x;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat mo25822a(int i, long j) {
        return super.mo25822a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, CommonUtils.m5121b() ? R.attr.mzActionModeStyleFullScreen : R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17399k = new SplitViewVisibilityAnimListener();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.f17407s = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.f17408t = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f17373i = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.f17410v = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f17369e != null) {
            this.f17369e.mo25951e();
            this.f17369e.mo25953g();
        }
    }

    public void setSplitToolbar(boolean z) {
        if (this.f17371g != z) {
            if (this.f17369e != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z) {
                    this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
                    this.f17368d.setBackgroundDrawable((Drawable) null);
                    ViewGroup viewGroup = (ViewGroup) this.f17368d.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f17368d);
                    }
                    addView(this.f17368d, layoutParams);
                } else if (this.f17370f != null) {
                    this.f17369e.mo25940a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.f17369e.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    layoutParams.width = -1;
                    layoutParams.height = this.f17373i;
                    this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
                    ViewGroup viewGroup2 = (ViewGroup) this.f17368d.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f17368d);
                    }
                    this.f17370f.addView(this.f17368d, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public void setContentHeight(int i) {
        this.f17373i = i;
    }

    public void setCustomView(View view) {
        if (this.f17403o != null) {
            removeView(this.f17403o);
        }
        this.f17403o = view;
        if (!(view == null || this.f17404p == null)) {
            removeView(this.f17404p);
            this.f17404p = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f17400l = charSequence;
        m19082g();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f17401m = charSequence;
        m19082g();
    }

    public CharSequence getTitle() {
        return this.f17400l;
    }

    public CharSequence getSubtitle() {
        return this.f17401m;
    }

    /* renamed from: g */
    private void m19082g() {
        if (this.f17404p == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.mz_action_bar_title_item, this);
            this.f17404p = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f17405q = (TextView) this.f17404p.findViewById(R.id.action_bar_title);
            this.f17406r = (TextView) this.f17404p.findViewById(R.id.action_bar_subtitle);
            if (this.f17407s != 0) {
                this.f17405q.setTextAppearance(getContext(), this.f17407s);
            }
            if (this.f17408t != 0) {
                this.f17406r.setTextAppearance(getContext(), this.f17408t);
            }
        }
        this.f17405q.setText(this.f17400l);
        this.f17406r.setText(this.f17401m);
        boolean z = !TextUtils.isEmpty(this.f17400l);
        boolean z2 = !TextUtils.isEmpty(this.f17401m);
        int i = 8;
        this.f17406r.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.f17404p;
        if (z || z2) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f17404p.getParent() == null) {
            addView(this.f17404p);
        }
    }

    /* renamed from: a */
    public void mo25852a(final ActionMode bVar) {
        if (this.f17402n == null) {
            this.f17402n = LayoutInflater.from(getContext()).inflate(this.f17410v, this, false);
            addView(this.f17402n);
        } else if (this.f17402n.getParent() == null) {
            addView(this.f17402n);
        }
        this.f17402n.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bVar.mo25352c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) bVar.mo25348b();
        if (this.f17369e != null) {
            this.f17369e.mo25952f();
        }
        this.f17369e = new ActionMenuPresenter(getContext());
        this.f17369e.mo25945b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.f17371g) {
            menuBuilder.mo25548a((MenuPresenter) this.f17369e, this.f17367c);
            this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
            this.f17368d.setBackgroundDrawable((Drawable) null);
            addView(this.f17368d, layoutParams);
            return;
        }
        this.f17369e.mo25940a(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.m18758a(getContext()).mo25420i() * 2), true);
        this.f17369e.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.f17369e.mo25949d(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        menuBuilder.mo25548a((MenuPresenter) this.f17369e, this.f17367c);
        this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
        this.f17368d.setId(R.id.mz_action_mode_menu_view);
        if (this.f17370f != null) {
            this.f17370f.addView(this.f17368d, layoutParams);
        }
    }

    /* renamed from: b */
    public void mo25854b() {
        if (this.f17402n == null && !this.f17412x) {
            mo25856c();
        }
    }

    /* renamed from: c */
    public void mo25856c() {
        removeAllViews();
        if (this.f17370f != null) {
            this.f17370f.removeView(this.f17368d);
        }
        this.f17403o = null;
        this.f17368d = null;
        this.f17412x = false;
        this.f17369e = null;
    }

    /* renamed from: a */
    public boolean mo25823a() {
        if (this.f17369e != null) {
            return this.f17369e.mo25950d();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            if (this.f17373i > 0) {
                i3 = this.f17373i;
            } else {
                i3 = View.MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i3 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f17402n != null) {
                int a = mo25820a(this.f17402n, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17402n.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.f17368d != null && this.f17368d.getParent() == this) {
                paddingLeft = mo25820a(this.f17368d, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f17404p != null && this.f17403o == null) {
                if (this.f17409u) {
                    this.f17404p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f17404p.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f17404p.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo25820a(this.f17404p, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f17403o != null) {
                ViewGroup.LayoutParams layoutParams = this.f17403o.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i4 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.f17403o.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i4));
            }
            if (this.f17373i <= 0) {
                int childCount = getChildCount();
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i7) {
                        i7 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i7);
                return;
            }
            setMeasuredDimension(size, i3);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C3352x.m20913a((View) this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f17402n == null || this.f17402n.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17402n.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m19066a(paddingRight, i6, a);
            i5 = m19066a(a2 + mo25821a(this.f17402n, a2, paddingTop, paddingTop2, a), i7, a);
        }
        if (!(this.f17404p == null || this.f17403o != null || this.f17404p.getVisibility() == 8)) {
            i5 += mo25821a(this.f17404p, i5, paddingTop, paddingTop2, a);
        }
        int i8 = i5;
        if (this.f17403o != null) {
            mo25821a(this.f17403o, i8, paddingTop, paddingTop2, a);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f17368d != null && this.f17368d.getParent() == this) {
            mo25821a(this.f17368d, paddingLeft, paddingTop, paddingTop2, !a);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f17400l);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f17409u) {
            requestLayout();
        }
        this.f17409u = z;
    }

    /* renamed from: d */
    public boolean mo25857d() {
        return this.f17409u;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f17372h) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.mz_split_action_bar_is_narrow));
        }
    }

    /* renamed from: b */
    public void mo25855b(ActionMode bVar) {
        this.f17412x = true;
        MenuBuilder menuBuilder = (MenuBuilder) bVar.mo25348b();
        if (this.f17369e != null) {
            this.f17369e.mo25952f();
        }
        this.f17369e = new ActionMenuPresenter(getContext());
        this.f17369e.mo25945b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (this.f17370f == null) {
            menuBuilder.mo25548a((MenuPresenter) this.f17369e, this.f17367c);
            this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
            this.f17368d.setBackgroundDrawable((Drawable) null);
            addView(this.f17368d, layoutParams);
            return;
        }
        this.f17369e.mo25940a(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.m18758a(getContext()).mo25420i() * 2), true);
        this.f17369e.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.f17369e.mo25949d(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        menuBuilder.mo25548a((MenuPresenter) this.f17369e, this.f17367c);
        this.f17368d = (ActionMenuView) this.f17369e.mo25727a((ViewGroup) this);
        this.f17368d.setId(R.id.mz_action_mode_menu_view);
        this.f17370f.addView(this.f17368d, layoutParams);
    }

    /* renamed from: a */
    public void mo25851a(final int i) {
        final View view;
        if (this.f17398A != null) {
            this.f17398A.cancel();
        }
        this.f17411w = i == 0 ? 1 : 2;
        ViewGroup viewGroup = this.f17370f != null ? (ViewGroup) this.f17370f.getChildAt(0) : null;
        if (this.f17370f == null) {
            view = this.f17368d;
        } else if (viewGroup == null || viewGroup == this.f17368d || viewGroup.getChildCount() <= 0) {
            view = this.f17370f;
        } else {
            view = this.f17368d;
        }
        if (view == null) {
            this.f17411w = 0;
        } else if (i == 0) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ActionBarContextView.this.f17411w == 2) {
                            ActionBarContextView.this.f17399k.onAnimationEnd(view);
                            return false;
                        }
                        ViewCompat.setTranslationY(view, (float) view.getHeight());
                        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(view).translationY(0.0f);
                        translationY.setDuration(260);
                        translationY.setInterpolator(ActionBarContextView.f17396y);
                        translationY.setListener(ActionBarContextView.this.f17399k.mo25874a(translationY, i));
                        translationY.start();
                        return false;
                    }
                });
            }
        } else {
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(view).translationY((float) view.getHeight());
            translationY.setDuration(260);
            translationY.setListener(this.f17399k.mo25874a(translationY, i));
            translationY.setInterpolator(f17397z);
            translationY.start();
        }
    }

    /* renamed from: e */
    public boolean mo25858e() {
        return this.f17412x;
    }

    /* renamed from: a */
    public void mo25853a(boolean z, WindowDecorActionBar.C3139a aVar) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (z) {
            viewPropertyAnimatorCompat = mo25822a(0, 200);
        } else {
            viewPropertyAnimatorCompat = mo25822a(8, 100);
        }
        viewPropertyAnimatorCompat.start();
        if (this.f17371g || this.f17412x) {
            boolean z2 = true;
            if (aVar != null) {
                z2 = aVar.mo25426n();
            }
            if (z2) {
                m19080a(z);
            } else if (this.f17411w == 2 && this.f17398A != null && z) {
                this.f17398A.cancel();
            }
        }
    }

    /* renamed from: a */
    private void m19080a(boolean z) {
        mo25851a(z ? 0 : 8);
    }

    /* renamed from: flyme.support.v7.widget.ActionBarContextView$SplitViewVisibilityAnimListener */
    protected class SplitViewVisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        int f17418a;

        /* renamed from: c */
        private boolean f17420c = false;

        protected SplitViewVisibilityAnimListener() {
        }

        /* renamed from: a */
        public SplitViewVisibilityAnimListener mo25874a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            ViewPropertyAnimatorCompat unused = ActionBarContextView.this.f17398A = viewPropertyAnimatorCompat;
            this.f17418a = i;
            return this;
        }

        public void onAnimationStart(View view) {
            if (ActionBarContextView.this.f17370f != null) {
                ActionBarContextView.this.f17370f.setVisibility(0);
            }
            this.f17420c = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f17420c) {
                if (ActionBarContextView.this.f17411w == 2) {
                    ActionBarContextView.this.mo25856c();
                }
                if (ActionBarContextView.this.f17370f != null) {
                    ActionBarContextView.this.f17370f.setTranslationY(0.0f);
                }
                int unused = ActionBarContextView.this.f17411w = 0;
                ViewPropertyAnimatorCompat unused2 = ActionBarContextView.this.f17398A = null;
            }
        }

        public void onAnimationCancel(View view) {
            this.f17420c = true;
        }
    }
}
