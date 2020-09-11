package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.SupportMenuInflater;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuItemImpl;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.SubMenuBuilder;
import flyme.support.p093v7.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: flyme.support.v7.widget.Toolbar */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private final RtlSpacingHelper f18337A;

    /* renamed from: B */
    private int f18338B;

    /* renamed from: C */
    private CharSequence f18339C;

    /* renamed from: D */
    private CharSequence f18340D;

    /* renamed from: E */
    private int f18341E;

    /* renamed from: F */
    private int f18342F;

    /* renamed from: G */
    private boolean f18343G;

    /* renamed from: H */
    private boolean f18344H;

    /* renamed from: I */
    private final ArrayList<View> f18345I;

    /* renamed from: J */
    private final ArrayList<View> f18346J;

    /* renamed from: K */
    private final int[] f18347K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C3319c f18348L;

    /* renamed from: M */
    private final ActionMenuView.C3193d f18349M;

    /* renamed from: N */
    private ToolbarWidgetWrapper f18350N;

    /* renamed from: O */
    private ActionMenuPresenter f18351O;

    /* renamed from: P */
    private C3317a f18352P;

    /* renamed from: Q */
    private MenuPresenter.C3167a f18353Q;

    /* renamed from: R */
    private MenuBuilder.C3159a f18354R;

    /* renamed from: S */
    private boolean f18355S;

    /* renamed from: T */
    private final Runnable f18356T;

    /* renamed from: U */
    private final AppCompatDrawableManager f18357U;

    /* renamed from: V */
    private ActionMenuView f18358V;

    /* renamed from: W */
    private boolean f18359W;

    /* renamed from: a */
    View f18360a;

    /* renamed from: b */
    protected ViewGroup f18361b;

    /* renamed from: c */
    protected boolean f18362c;

    /* renamed from: d */
    protected boolean f18363d;

    /* renamed from: e */
    protected ViewPropertyAnimatorCompat f18364e;

    /* renamed from: f */
    protected final VisibilityAnimListener f18365f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ActionMenuView f18366g;

    /* renamed from: h */
    private HorizontalScrollView f18367h;

    /* renamed from: i */
    private TextView f18368i;

    /* renamed from: j */
    private TextView f18369j;

    /* renamed from: k */
    private ImageButton f18370k;

    /* renamed from: l */
    private ImageView f18371l;

    /* renamed from: m */
    private Drawable f18372m;

    /* renamed from: n */
    private CharSequence f18373n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ImageButton f18374o;

    /* renamed from: p */
    private Context f18375p;

    /* renamed from: q */
    private int f18376q;

    /* renamed from: r */
    private int f18377r;

    /* renamed from: s */
    private int f18378s;

    /* renamed from: t */
    private int f18379t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f18380u;

    /* renamed from: v */
    private int f18381v;

    /* renamed from: w */
    private int f18382w;

    /* renamed from: x */
    private int f18383x;

    /* renamed from: y */
    private int f18384y;

    /* renamed from: z */
    private int f18385z;

    /* renamed from: flyme.support.v7.widget.Toolbar$c */
    public interface C3319c {
        /* renamed from: a */
        boolean mo27032a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, CommonUtils.m5121b() ? R.attr.mzToolbarStyleFullScreen : R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18337A = new RtlSpacingHelper();
        this.f18338B = 8388627;
        this.f18345I = new ArrayList<>();
        this.f18346J = new ArrayList<>();
        this.f18347K = new int[2];
        this.f18349M = new ActionMenuView.C3193d() {
            /* renamed from: a */
            public boolean mo26002a(MenuItem menuItem) {
                if (Toolbar.this.f18348L != null) {
                    return Toolbar.this.f18348L.mo27032a(menuItem);
                }
                return false;
            }
        };
        this.f18356T = new Runnable() {
            public void run() {
                Toolbar.this.mo26957d();
            }
        };
        this.f18365f = new VisibilityAnimListener();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.f18377r = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f18378s = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_mzTitleTextAppearanceBack, 0);
        this.f18379t = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f18338B = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, this.f18338B);
        this.f18380u = obtainStyledAttributes.getInteger(R.styleable.Toolbar_mzButtonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);
        this.f18385z = dimensionPixelOffset;
        this.f18384y = dimensionPixelOffset;
        this.f18383x = dimensionPixelOffset;
        this.f18382w = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f18382w = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f18383x = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f18384y = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f18385z = dimensionPixelOffset5;
        }
        this.f18381v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f18337A.mo27233b(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0));
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.f18337A.mo27230a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f18372m = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.f18373n = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f18375p = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
        this.f18357U = AppCompatDrawableManager.get();
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f18376q != i) {
            this.f18376q = i;
            if (i == 0) {
                this.f18375p = getContext();
            } else {
                this.f18375p = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f18376q;
    }

    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        if (this.f18337A != null) {
            RtlSpacingHelper sVar = this.f18337A;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            sVar.mo27231a(z);
        }
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(this.f18357U.getDrawable(getContext(), i));
    }

    /* renamed from: a */
    public boolean mo26953a() {
        return getVisibility() == 0 && this.f18366g != null && this.f18366g.mo25974a();
    }

    /* renamed from: b */
    public boolean mo26954b() {
        return this.f18366g != null && this.f18366g.mo25982g();
    }

    /* renamed from: c */
    public boolean mo26955c() {
        return this.f18366g != null && this.f18366g.mo25987h();
    }

    /* renamed from: d */
    public boolean mo26957d() {
        return this.f18366g != null && this.f18366g.mo25980e();
    }

    /* renamed from: e */
    public boolean mo26958e() {
        return this.f18366g != null && this.f18366g.mo25981f();
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f18366g != null) {
            m20352n();
            MenuBuilder d = this.f18366g.mo25978d();
            if (d != menuBuilder) {
                if (d != null) {
                    d.mo25566b((MenuPresenter) this.f18351O);
                    d.mo25566b((MenuPresenter) this.f18352P);
                }
                if (this.f18352P == null) {
                    this.f18352P = new C3317a();
                }
                actionMenuPresenter.mo25948c(true);
                if (menuBuilder != null) {
                    menuBuilder.mo25548a((MenuPresenter) actionMenuPresenter, this.f18375p);
                    menuBuilder.mo25548a((MenuPresenter) this.f18352P, this.f18375p);
                } else {
                    actionMenuPresenter.mo25729a(this.f18375p, (MenuBuilder) null);
                    this.f18352P.mo25729a(this.f18375p, (MenuBuilder) null);
                    actionMenuPresenter.mo25734a(true);
                    this.f18352P.mo25734a(true);
                }
                this.f18366g.setPopupTheme(this.f18376q);
                this.f18366g.setPresenter(actionMenuPresenter);
                this.f18351O = actionMenuPresenter;
            }
        }
    }

    /* renamed from: f */
    public void mo26959f() {
        if (this.f18366g != null) {
            this.f18366g.mo25988i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m20350l();
            if (!m20348d((View) this.f18371l)) {
                m20337a((View) this.f18371l, true);
            }
        } else if (this.f18371l != null && m20348d((View) this.f18371l)) {
            removeView(this.f18371l);
            this.f18346J.remove(this.f18371l);
        }
        if (this.f18371l != null) {
            this.f18371l.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.f18371l != null) {
            return this.f18371l.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m20350l();
        }
        if (this.f18371l != null) {
            this.f18371l.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.f18371l != null) {
            return this.f18371l.getContentDescription();
        }
        return null;
    }

    /* renamed from: l */
    private void m20350l() {
        if (this.f18371l == null) {
            this.f18371l = new ImageView(getContext());
        }
    }

    /* renamed from: g */
    public boolean mo26960g() {
        return (this.f18352P == null || this.f18352P.f18396b == null) ? false : true;
    }

    /* renamed from: h */
    public void mo26978h() {
        MenuItemImpl menuItemImpl = this.f18352P == null ? null : this.f18352P.f18396b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f18339C;
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f18367h == null) {
                this.f18367h = new HorizontalScrollView(getContext());
                this.f18367h.setHorizontalFadingEdgeEnabled(true);
                this.f18367h.setOverScrollMode(2);
                this.f18367h.setHorizontalScrollBarEnabled(false);
                this.f18367h.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_min_width));
            }
            if (this.f18368i == null) {
                this.f18368i = new TextView(getContext());
                this.f18368i.setSingleLine();
            }
            if (m20340a((View) this.f18370k) && this.f18378s != 0) {
                this.f18368i.setTextAppearance(getContext(), this.f18378s);
            } else if (this.f18377r != 0) {
                this.f18368i.setTextAppearance(getContext(), this.f18377r);
            }
            if (this.f18341E != 0) {
                this.f18368i.setTextColor(this.f18341E);
            }
            this.f18367h.removeAllViews();
            this.f18367h.addView(this.f18368i);
            if (!m20348d((View) this.f18367h)) {
                m20337a((View) this.f18367h, true);
            }
        } else if (this.f18367h != null && m20348d((View) this.f18367h)) {
            removeView(this.f18367h);
            this.f18346J.remove(this.f18367h);
        }
        if (this.f18368i != null) {
            this.f18368i.setText(charSequence);
        }
        this.f18339C = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f18340D;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f18369j == null) {
                Context context = getContext();
                this.f18369j = new TextView(context);
                this.f18369j.setSingleLine();
                this.f18369j.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f18379t != 0) {
                    this.f18369j.setTextAppearance(context, this.f18379t);
                }
                if (this.f18342F != 0) {
                    this.f18369j.setTextColor(this.f18342F);
                }
            }
            if (!m20348d((View) this.f18369j)) {
                m20337a((View) this.f18369j, true);
            }
        } else if (this.f18369j != null && m20348d((View) this.f18369j)) {
            removeView(this.f18369j);
            this.f18346J.remove(this.f18369j);
        }
        if (this.f18369j != null) {
            this.f18369j.setText(charSequence);
        }
        this.f18340D = charSequence;
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.f18377r = i;
        if (this.f18368i != null) {
            this.f18368i.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.f18379t = i;
        if (this.f18369j != null) {
            this.f18369j.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.f18341E = i;
        if (this.f18368i != null) {
            this.f18368i.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.f18342F = i;
        if (this.f18369j != null) {
            this.f18369j.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        if (this.f18370k != null) {
            return this.f18370k.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m20354p();
        }
        if (this.f18370k != null) {
            this.f18370k.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(this.f18357U.getDrawable(getContext(), i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m20354p();
            if (!m20348d((View) this.f18370k)) {
                m20337a((View) this.f18370k, true);
            }
            if (!(this.f18378s == 0 || this.f18368i == null)) {
                this.f18368i.setTextAppearance(getContext(), this.f18378s);
            }
        } else if (this.f18370k != null && m20348d((View) this.f18370k)) {
            removeView(this.f18370k);
            this.f18346J.remove(this.f18370k);
            setTouchDelegate((TouchDelegate) null);
            if (!(this.f18377r == 0 || this.f18368i == null)) {
                this.f18368i.setTextAppearance(getContext(), this.f18377r);
            }
        }
        if (this.f18370k != null) {
            this.f18370k.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        if (this.f18370k != null) {
            return this.f18370k.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m20354p();
        this.f18370k.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m20351m();
        return this.f18366g.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        m20351m();
        this.f18366g.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        m20351m();
        return this.f18366g.getOverflowIcon();
    }

    /* renamed from: m */
    private void m20351m() {
        m20352n();
        if (this.f18366g.mo25978d() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f18366g.getMenu();
            if (this.f18352P == null) {
                this.f18352P = new C3317a();
            }
            this.f18366g.setExpandedActionViewsExclusive(true);
            menuBuilder.mo25548a((MenuPresenter) this.f18352P, this.f18375p);
        }
    }

    /* renamed from: n */
    private void m20352n() {
        if (this.f18366g == null) {
            this.f18366g = new ActionMenuView(getContext());
            this.f18366g.setPopupTheme(this.f18376q);
            this.f18366g.setOnMenuItemClickListener(this.f18349M);
            this.f18366g.setMenuCallbacks(this.f18353Q, this.f18354R);
            C3318b i = generateDefaultLayoutParams();
            i.f16596a = 8388613 | (this.f18380u & 112);
            this.f18366g.setLayoutParams(i);
            this.f18366g.setId(R.id.mz_action_menu_view);
            if (this.f18362c) {
                i.width = -1;
                this.f18361b.addView(this.f18366g, 0, i);
                return;
            }
            m20337a((View) this.f18366g, false);
        }
    }

    /* renamed from: o */
    private void m20353o() {
        if (this.f18358V == null) {
            this.f18358V = new ActionMenuView(getContext());
            this.f18358V.setPopupTheme(this.f18376q);
            this.f18358V.setOnMenuItemClickListener(this.f18349M);
            C3318b i = generateDefaultLayoutParams();
            i.f16596a = 8388613 | (this.f18380u & 112);
            this.f18358V.setLayoutParams(i);
            this.f18358V.setId(R.id.mz_action_bottom_menu_view);
            if (this.f18361b != null) {
                i.width = -1;
                this.f18361b.addView(this.f18358V, 0, i);
            }
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void setOnMenuItemClickListener(C3319c cVar) {
        this.f18348L = cVar;
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.f18337A.mo27230a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f18337A.mo27234c();
    }

    public int getContentInsetEnd() {
        return this.f18337A.mo27235d();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.f18337A.mo27233b(i, i2);
    }

    public int getContentInsetLeft() {
        return this.f18337A.mo27229a();
    }

    public int getContentInsetRight() {
        return this.f18337A.mo27232b();
    }

    /* renamed from: p */
    private void m20354p() {
        if (this.f18370k == null) {
            this.f18370k = new ImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            C3318b i = generateDefaultLayoutParams();
            i.f16596a = 8388611 | (this.f18380u & 112);
            this.f18370k.setLayoutParams(i);
            this.f18370k.setId(R.id.mz_toolbar_nav_button);
            this.f18370k.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    View view2 = (View) view.getParent();
                    int i9 = (int) (Toolbar.this.getResources().getDisplayMetrics().density * 56.0f);
                    int i10 = i3 - i;
                    if (i10 < i9) {
                        int i11 = (i9 - i10) / 2;
                        view2.setTouchDelegate(new TouchDelegate(new Rect(i - i11, i2, i3 + i11, i4), view));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m20355q() {
        if (this.f18374o == null) {
            this.f18374o = new ImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            this.f18374o.setImageDrawable(this.f18372m);
            this.f18374o.setContentDescription(this.f18373n);
            C3318b i = generateDefaultLayoutParams();
            i.f16596a = 8388611 | (this.f18380u & 112);
            i.f18398b = 2;
            this.f18374o.setLayoutParams(i);
            this.f18374o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.mo26978h();
                }
            });
        }
    }

    /* renamed from: a */
    private void m20337a(View view, boolean z) {
        C3318b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (C3318b) layoutParams;
        }
        bVar.f18398b = 1;
        if (!z || this.f18360a == null) {
            addView(view, bVar);
            return;
        }
        view.setLayoutParams(bVar);
        this.f18346J.add(view);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f18352P == null || this.f18352P.f18396b == null)) {
            savedState.f18390a = this.f18352P.f18396b.getItemId();
        }
        savedState.f18391b = mo26954b();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        MenuBuilder d = this.f18366g != null ? this.f18366g.mo25978d() : null;
        if (!(savedState.f18390a == 0 || this.f18352P == null || d == null || (findItem = d.findItem(savedState.f18390a)) == null)) {
            MenuItemCompat.expandActionView(findItem);
        }
        if (savedState.f18391b) {
            m20356r();
        }
    }

    /* renamed from: r */
    private void m20356r() {
        removeCallbacks(this.f18356T);
        post(this.f18356T);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f18356T);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f18343G = false;
        }
        if (!this.f18343G) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f18343G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f18343G = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f18344H = false;
        }
        if (!this.f18344H) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f18344H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f18344H = false;
        }
        return true;
    }

    /* renamed from: a */
    private void m20336a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private int m20330a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return m20331a(view, i, i2, i3, i4, iArr, false);
    }

    /* renamed from: a */
    private int m20331a(View view, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        if (z && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: s */
    private boolean m20357s() {
        if (!this.f18355S) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m20340a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m20335a(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m20339a(z, i, i2, i3, i4);
    }

    /* renamed from: a */
    private int m20333a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            C3318b bVar = (C3318b) view.getLayoutParams();
            int i6 = bVar.leftMargin - i;
            int i7 = bVar.rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i = max3;
        }
        return i5;
    }

    /* renamed from: a */
    private int m20332a(View view, int i, int[] iArr, int i2) {
        C3318b bVar = (C3318b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a = m20329a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a, max + measuredWidth, view.getMeasuredHeight() + a);
        return max + measuredWidth + bVar.rightMargin;
    }

    /* renamed from: b */
    private int m20343b(View view, int i, int[] iArr, int i2) {
        C3318b bVar = (C3318b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = m20329a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a, max, view.getMeasuredHeight() + a);
        return max - (measuredWidth + bVar.leftMargin);
    }

    /* renamed from: a */
    private int m20329a(View view, int i) {
        C3318b bVar = (C3318b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int a = m20328a(bVar.f16596a);
        if (a == 48) {
            return getPaddingTop() - i2;
        }
        if (a == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i3 < bVar.topMargin) {
            i3 = bVar.topMargin;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            if (i4 < bVar.bottomMargin) {
                i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
            }
        }
        return paddingTop + i3;
    }

    /* renamed from: a */
    private int m20328a(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f18338B & 112;
    }

    /* renamed from: a */
    private void m20338a(List<View> list, int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                C3318b bVar = (C3318b) childAt.getLayoutParams();
                if (bVar.f18398b == 0 && m20340a(childAt) && m20341b(bVar.f16596a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C3318b bVar2 = (C3318b) childAt2.getLayoutParams();
            if (bVar2.f18398b == 0 && m20340a(childAt2) && m20341b(bVar2.f16596a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: b */
    private int m20341b(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    /* renamed from: a */
    private boolean m20340a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: b */
    private int m20342b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    /* renamed from: c */
    private int m20345c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    public C3318b generateLayoutParams(AttributeSet attributeSet) {
        return new C3318b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3318b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C3318b) {
            return new C3318b((C3318b) layoutParams);
        }
        if (layoutParams instanceof ActionBar.C3074d) {
            return new C3318b((ActionBar.C3074d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C3318b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C3318b(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C3318b generateDefaultLayoutParams() {
        return new C3318b(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C3318b);
    }

    public DecorToolbar getWrapper() {
        if (this.f18350N == null) {
            this.f18350N = new ToolbarWidgetWrapper(this, true);
        }
        return this.f18350N;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo26980j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C3318b) childAt.getLayoutParams()).f18398b == 2 || childAt == this.f18366g)) {
                removeViewAt(childCount);
                this.f18346J.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo26981k() {
        for (int size = this.f18346J.size() - 1; size >= 0; size--) {
            addView(this.f18346J.get(size));
        }
        this.f18346J.clear();
    }

    /* renamed from: d */
    private boolean m20348d(View view) {
        return view.getParent() == this || this.f18346J.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f18355S = z;
        requestLayout();
    }

    public void setMenuCallbacks(MenuPresenter.C3167a aVar, MenuBuilder.C3159a aVar2) {
        this.f18353Q = aVar;
        this.f18354R = aVar2;
        if (this.f18366g != null) {
            this.f18366g.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setBottomMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        m20353o();
        MenuBuilder d = this.f18358V.mo25978d();
        if (d != menuBuilder) {
            if (d != null) {
                d.mo25566b((MenuPresenter) this.f18351O);
            }
            actionMenuPresenter.mo25948c(true);
            if (menuBuilder != null) {
                menuBuilder.mo25548a((MenuPresenter) actionMenuPresenter, this.f18375p);
            }
            this.f18358V.setPopupTheme(this.f18376q);
            this.f18358V.setPresenter(actionMenuPresenter);
        }
    }

    public void setShowBottomMenu(boolean z) {
        if (this.f18359W != z) {
            this.f18359W = z;
            if (this.f18358V != null) {
                ViewGroup viewGroup = (ViewGroup) this.f18358V.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f18358V);
                }
                if (this.f18359W) {
                    if (this.f18361b != null) {
                        this.f18361b.addView(this.f18358V);
                    }
                    this.f18358V.getLayoutParams().width = -1;
                }
                this.f18358V.requestLayout();
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.Toolbar$b */
    public static class C3318b extends ActionBar.C3074d {

        /* renamed from: b */
        int f18398b = 0;

        public C3318b(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3318b(int i, int i2) {
            super(i, i2);
            this.f16596a = 8388627;
        }

        public C3318b(C3318b bVar) {
            super((ActionBar.C3074d) bVar);
            this.f18398b = bVar.f18398b;
        }

        public C3318b(ActionBar.C3074d dVar) {
            super(dVar);
        }

        public C3318b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            mo27031a(marginLayoutParams);
        }

        public C3318b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27031a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: flyme.support.v7.widget.Toolbar$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f18390a;

        /* renamed from: b */
        boolean f18391b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f18390a = parcel.readInt();
            this.f18391b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f18390a);
            parcel.writeInt(this.f18391b ? 1 : 0);
        }
    }

    /* renamed from: flyme.support.v7.widget.Toolbar$a */
    private class C3317a implements MenuPresenter {

        /* renamed from: a */
        MenuBuilder f18395a;

        /* renamed from: b */
        MenuItemImpl f18396b;

        /* renamed from: a */
        public void mo25731a(MenuBuilder menuBuilder, boolean z) {
        }

        /* renamed from: a */
        public boolean mo25738a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        /* renamed from: b */
        public boolean mo25741b() {
            return false;
        }

        private C3317a() {
        }

        /* renamed from: a */
        public void mo25729a(Context context, MenuBuilder menuBuilder) {
            if (!(this.f18395a == null || this.f18396b == null)) {
                this.f18395a.mo25577d(this.f18396b);
            }
            this.f18395a = menuBuilder;
        }

        /* renamed from: a */
        public void mo25734a(boolean z) {
            if (this.f18396b != null) {
                boolean z2 = false;
                if (this.f18395a != null) {
                    int size = this.f18395a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f18395a.getItem(i) == this.f18396b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    mo25742b(this.f18395a, this.f18396b);
                }
            }
        }

        /* renamed from: a */
        public boolean mo25737a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.m20355q();
            if (Toolbar.this.f18374o.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.f18374o);
            }
            Toolbar.this.f18360a = menuItemImpl.getActionView();
            this.f18396b = menuItemImpl;
            if (Toolbar.this.f18360a.getParent() != Toolbar.this) {
                C3318b i = Toolbar.this.generateDefaultLayoutParams();
                i.f16596a = 8388611 | (Toolbar.this.f18380u & 112);
                i.f18398b = 2;
                Toolbar.this.f18360a.setLayoutParams(i);
                Toolbar.this.addView(Toolbar.this.f18360a);
            }
            Toolbar.this.mo26980j();
            Toolbar.this.requestLayout();
            menuItemImpl.mo25620e(true);
            if (Toolbar.this.f18360a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f18360a).onActionViewExpanded();
            }
            return true;
        }

        /* renamed from: b */
        public boolean mo25742b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.f18360a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.f18360a).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.f18360a);
            Toolbar.this.removeView(Toolbar.this.f18374o);
            Toolbar.this.f18360a = null;
            Toolbar.this.mo26981k();
            this.f18396b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.mo25620e(false);
            return true;
        }
    }

    /* renamed from: a */
    private void m20335a(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.f18347K;
        if (C3352x.m20913a((View) this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (m20340a((View) this.f18370k)) {
            m20336a((View) this.f18370k, i, 0, i2, 0, this.f18381v);
            i5 = this.f18370k.getMeasuredWidth() + m20342b((View) this.f18370k);
            i4 = Math.max(0, this.f18370k.getMeasuredHeight() + m20345c((View) this.f18370k));
            i3 = C3352x.m20911a(0, ViewCompat.getMeasuredState(this.f18370k));
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        setTitleMarginNavgationButton(m20340a((View) this.f18370k));
        if (m20340a((View) this.f18374o)) {
            m20336a((View) this.f18374o, i, 0, i2, 0, this.f18381v);
            i5 = this.f18374o.getMeasuredWidth() + m20342b((View) this.f18374o);
            i4 = Math.max(i4, this.f18374o.getMeasuredHeight() + m20345c((View) this.f18374o));
            i3 = C3352x.m20911a(i3, ViewCompat.getMeasuredState(this.f18374o));
        }
        int contentInsetStart = getContentInsetStart();
        int max = Math.max(contentInsetStart, i5) + 0;
        iArr[c2] = Math.max(0, contentInsetStart - i5);
        if (m20340a((View) this.f18366g)) {
            m20336a((View) this.f18366g, i, max, i2, 0, this.f18381v);
            int measuredWidth = this.f18366g.getMeasuredWidth() + m20342b((View) this.f18366g);
            i4 = Math.max(i4, this.f18366g.getMeasuredHeight() + m20345c((View) this.f18366g));
            i3 = C3352x.m20911a(i3, ViewCompat.getMeasuredState(this.f18366g));
            i6 = measuredWidth;
        } else {
            i6 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int max2 = max + Math.max(contentInsetEnd, i6);
        iArr[c] = Math.max(0, contentInsetEnd - i6);
        if (m20340a(this.f18360a)) {
            max2 += m20330a(this.f18360a, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f18360a.getMeasuredHeight() + m20345c(this.f18360a));
            i3 = C3352x.m20911a(i3, ViewCompat.getMeasuredState(this.f18360a));
        }
        if (m20340a((View) this.f18371l)) {
            max2 += m20330a((View) this.f18371l, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f18371l.getMeasuredHeight() + m20345c((View) this.f18371l));
            i3 = C3352x.m20911a(i3, ViewCompat.getMeasuredState(this.f18371l));
        }
        int childCount = getChildCount();
        int i10 = i3;
        int i11 = i4;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((C3318b) childAt.getLayoutParams()).f18398b != 0 || !m20340a(childAt)) {
                i10 = i10;
            } else {
                View view = childAt;
                max2 += m20330a(childAt, i, max2, i2, 0, iArr);
                View view2 = view;
                i11 = Math.max(i11, view.getMeasuredHeight() + m20345c(view2));
                i10 = C3352x.m20911a(i10, ViewCompat.getMeasuredState(view2));
            }
        }
        int i13 = i10;
        int i14 = this.f18384y + this.f18385z;
        int i15 = this.f18382w + this.f18383x;
        int i16 = (this.f18338B & 7) != 1 ? max2 : i6 * 2;
        if (m20340a((View) this.f18367h)) {
            m20331a(this.f18367h, i, i16 + i15, i2, i14, iArr, true);
            int measuredWidth2 = this.f18367h.getMeasuredWidth() + m20342b((View) this.f18367h);
            int measuredHeight = this.f18367h.getMeasuredHeight() + m20345c((View) this.f18367h);
            i9 = C3352x.m20911a(i13, ViewCompat.getMeasuredState(this.f18367h));
            i8 = measuredWidth2;
            i7 = measuredHeight;
        } else {
            i9 = i13;
            i8 = 0;
            i7 = 0;
        }
        if (m20340a((View) this.f18369j)) {
            i8 = Math.max(i8, m20330a((View) this.f18369j, i, i16 + i15, i2, i7 + i14, iArr));
            i7 += this.f18369j.getMeasuredHeight() + m20345c((View) this.f18369j);
            i9 = C3352x.m20911a(i9, ViewCompat.getMeasuredState(this.f18369j));
        } else {
            int i17 = i9;
        }
        int max3 = Math.max(i11, i7);
        int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (m20357s()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02f4 A[LOOP:0: B:113:0x02f2->B:114:0x02f4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0316 A[LOOP:1: B:116:0x0314->B:117:0x0316, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0350 A[LOOP:2: B:124:0x034e->B:125:0x0350, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x022e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20339a(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            int r1 = androidx.core.view.ViewCompat.getLayoutDirection(r23)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r23.getWidth()
            int r5 = r23.getHeight()
            int r6 = r23.getPaddingLeft()
            int r7 = r23.getPaddingRight()
            int r8 = r23.getPaddingTop()
            int r9 = r23.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.f18347K
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.ViewCompat.getMinimumHeight(r23)
            android.widget.ImageButton r13 = r0.f18370k
            boolean r13 = r0.m20340a((android.view.View) r13)
            if (r13 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x0043
            android.widget.ImageButton r13 = r0.f18370k
            int r13 = r0.m20343b(r13, r10, r11, r12)
            r14 = r6
            goto L_0x004d
        L_0x0043:
            android.widget.ImageButton r13 = r0.f18370k
            int r13 = r0.m20332a(r13, r6, r11, r12)
            r14 = r13
            goto L_0x004c
        L_0x004b:
            r14 = r6
        L_0x004c:
            r13 = r10
        L_0x004d:
            android.widget.ImageButton r15 = r0.f18370k
            boolean r15 = r0.m20340a((android.view.View) r15)
            r0.setTitleMarginNavgationButton(r15)
            android.widget.ImageButton r15 = r0.f18374o
            boolean r15 = r0.m20340a((android.view.View) r15)
            if (r15 == 0) goto L_0x006d
            if (r1 == 0) goto L_0x0067
            android.widget.ImageButton r15 = r0.f18374o
            int r13 = r0.m20343b(r15, r13, r11, r12)
            goto L_0x006d
        L_0x0067:
            android.widget.ImageButton r15 = r0.f18374o
            int r14 = r0.m20332a(r15, r14, r11, r12)
        L_0x006d:
            flyme.support.v7.widget.ActionMenuView r15 = r0.f18366g
            boolean r15 = r0.m20340a((android.view.View) r15)
            if (r15 == 0) goto L_0x0084
            if (r1 == 0) goto L_0x007e
            flyme.support.v7.widget.ActionMenuView r15 = r0.f18366g
            int r14 = r0.m20332a(r15, r14, r11, r12)
            goto L_0x0084
        L_0x007e:
            flyme.support.v7.widget.ActionMenuView r15 = r0.f18366g
            int r13 = r0.m20343b(r15, r13, r11, r12)
        L_0x0084:
            int r15 = r23.getContentInsetLeft()
            int r15 = r15 - r14
            int r15 = java.lang.Math.max(r3, r15)
            r11[r3] = r15
            int r15 = r23.getContentInsetRight()
            int r16 = r10 - r13
            int r15 = r15 - r16
            int r15 = java.lang.Math.max(r3, r15)
            r11[r2] = r15
            int r15 = r23.getContentInsetLeft()
            int r14 = java.lang.Math.max(r14, r15)
            int r15 = r23.getContentInsetRight()
            int r10 = r10 - r15
            int r10 = java.lang.Math.min(r13, r10)
            android.view.View r13 = r0.f18360a
            boolean r13 = r0.m20340a((android.view.View) r13)
            if (r13 == 0) goto L_0x00c5
            if (r1 == 0) goto L_0x00bf
            android.view.View r13 = r0.f18360a
            int r10 = r0.m20343b(r13, r10, r11, r12)
            goto L_0x00c5
        L_0x00bf:
            android.view.View r13 = r0.f18360a
            int r14 = r0.m20332a(r13, r14, r11, r12)
        L_0x00c5:
            android.widget.ImageView r13 = r0.f18371l
            boolean r13 = r0.m20340a((android.view.View) r13)
            if (r13 == 0) goto L_0x00dc
            if (r1 == 0) goto L_0x00d6
            android.widget.ImageView r13 = r0.f18371l
            int r10 = r0.m20343b(r13, r10, r11, r12)
            goto L_0x00dc
        L_0x00d6:
            android.widget.ImageView r13 = r0.f18371l
            int r14 = r0.m20332a(r13, r14, r11, r12)
        L_0x00dc:
            android.widget.HorizontalScrollView r13 = r0.f18367h
            boolean r13 = r0.m20340a((android.view.View) r13)
            android.widget.TextView r15 = r0.f18369j
            boolean r15 = r0.m20340a((android.view.View) r15)
            if (r13 == 0) goto L_0x0103
            android.widget.HorizontalScrollView r2 = r0.f18367h
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r2 = (flyme.support.p093v7.widget.Toolbar.C3318b) r2
            int r3 = r2.topMargin
            r18 = r7
            android.widget.HorizontalScrollView r7 = r0.f18367h
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r2 = r2.bottomMargin
            int r3 = r3 + r2
            r2 = 0
            int r3 = r3 + r2
            goto L_0x0106
        L_0x0103:
            r18 = r7
            r3 = 0
        L_0x0106:
            if (r15 == 0) goto L_0x0120
            android.widget.TextView r2 = r0.f18369j
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r2 = (flyme.support.p093v7.widget.Toolbar.C3318b) r2
            int r7 = r2.topMargin
            r19 = r6
            android.widget.TextView r6 = r0.f18369j
            int r6 = r6.getMeasuredHeight()
            int r7 = r7 + r6
            int r2 = r2.bottomMargin
            int r7 = r7 + r2
            int r3 = r3 + r7
            goto L_0x0122
        L_0x0120:
            r19 = r6
        L_0x0122:
            if (r13 != 0) goto L_0x012e
            if (r15 == 0) goto L_0x0127
            goto L_0x012e
        L_0x0127:
            r21 = r4
            r20 = r12
        L_0x012b:
            r2 = 0
            goto L_0x02e5
        L_0x012e:
            if (r13 == 0) goto L_0x0133
            android.widget.HorizontalScrollView r2 = r0.f18367h
            goto L_0x0135
        L_0x0133:
            android.widget.TextView r2 = r0.f18369j
        L_0x0135:
            if (r15 == 0) goto L_0x013a
            android.widget.TextView r6 = r0.f18369j
            goto L_0x013c
        L_0x013a:
            android.widget.HorizontalScrollView r6 = r0.f18367h
        L_0x013c:
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r2 = (flyme.support.p093v7.widget.Toolbar.C3318b) r2
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r6 = (flyme.support.p093v7.widget.Toolbar.C3318b) r6
            if (r13 == 0) goto L_0x0152
            android.widget.HorizontalScrollView r7 = r0.f18367h
            int r7 = r7.getMeasuredWidth()
            if (r7 > 0) goto L_0x015c
        L_0x0152:
            if (r15 == 0) goto L_0x0160
            android.widget.TextView r7 = r0.f18369j
            int r7 = r7.getMeasuredWidth()
            if (r7 <= 0) goto L_0x0160
        L_0x015c:
            r20 = r12
            r7 = 1
            goto L_0x0163
        L_0x0160:
            r20 = r12
            r7 = 0
        L_0x0163:
            int r12 = r0.f18338B
            r12 = r12 & 112(0x70, float:1.57E-43)
            r21 = r4
            r4 = 48
            if (r12 == r4) goto L_0x01ac
            r4 = 80
            if (r12 == r4) goto L_0x01a0
            int r4 = r5 - r8
            int r4 = r4 - r9
            int r4 = r4 - r3
            int r4 = r4 / 2
            int r12 = r2.topMargin
            r22 = r14
            int r14 = r0.f18384y
            int r12 = r12 + r14
            if (r4 >= r12) goto L_0x0187
            int r2 = r2.topMargin
            int r3 = r0.f18384y
            int r4 = r2 + r3
            goto L_0x019e
        L_0x0187:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r4
            int r5 = r5 - r8
            int r2 = r2.bottomMargin
            int r3 = r0.f18385z
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x019e
            int r2 = r6.bottomMargin
            int r3 = r0.f18385z
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r4 = r4 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r4)
        L_0x019e:
            int r8 = r8 + r4
            goto L_0x01b9
        L_0x01a0:
            r22 = r14
            int r5 = r5 - r9
            int r2 = r6.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f18385z
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b9
        L_0x01ac:
            r22 = r14
            int r3 = r23.getPaddingTop()
            int r2 = r2.topMargin
            int r3 = r3 + r2
            int r2 = r0.f18384y
            int r8 = r3 + r2
        L_0x01b9:
            if (r1 == 0) goto L_0x022e
            if (r7 == 0) goto L_0x01c1
            int r3 = r0.f18382w
            r1 = 1
            goto L_0x01c3
        L_0x01c1:
            r1 = 1
            r3 = 0
        L_0x01c3:
            r2 = r11[r1]
            int r3 = r3 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r3)
            int r10 = r10 - r4
            int r3 = -r3
            int r3 = java.lang.Math.max(r2, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x01f9
            android.widget.HorizontalScrollView r1 = r0.f18367h
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r1 = (flyme.support.p093v7.widget.Toolbar.C3318b) r1
            android.widget.HorizontalScrollView r2 = r0.f18367h
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.HorizontalScrollView r3 = r0.f18367h
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.HorizontalScrollView r4 = r0.f18367h
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f18383x
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01fa
        L_0x01f9:
            r2 = r10
        L_0x01fa:
            if (r15 == 0) goto L_0x0222
            android.widget.TextView r1 = r0.f18369j
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r1 = (flyme.support.p093v7.widget.Toolbar.C3318b) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f18369j
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.f18369j
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f18369j
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.f18383x
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x0223
        L_0x0222:
            r3 = r10
        L_0x0223:
            if (r7 == 0) goto L_0x022a
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x022a:
            r14 = r22
            goto L_0x012b
        L_0x022e:
            int r1 = r0.f18338B
            r1 = r1 & 7
            r2 = 1
            if (r1 == r2) goto L_0x0260
            if (r7 == 0) goto L_0x023d
            int r3 = r0.f18382w
            r17 = r3
            r2 = 0
            goto L_0x0240
        L_0x023d:
            r2 = 0
            r17 = 0
        L_0x0240:
            r1 = r11[r2]
            int r1 = r17 - r1
            r3 = r11[r2]
            if (r3 <= 0) goto L_0x024e
            int r3 = r0.f18382w
            int r14 = r22 + r3
        L_0x024c:
            r3 = r14
            goto L_0x0255
        L_0x024e:
            int r3 = java.lang.Math.max(r2, r1)
            int r14 = r22 + r3
            goto L_0x024c
        L_0x0255:
            int r1 = -r1
            int r1 = java.lang.Math.max(r2, r1)
            r11[r2] = r1
            r1 = r3
            r22 = r1
            goto L_0x027d
        L_0x0260:
            r2 = 0
            if (r13 == 0) goto L_0x026e
            android.widget.HorizontalScrollView r1 = r0.f18367h
            int r1 = r1.getMeasuredWidth()
            int r4 = r21 - r1
            int r3 = r4 / 2
            goto L_0x026f
        L_0x026e:
            r3 = 0
        L_0x026f:
            if (r15 == 0) goto L_0x027c
            android.widget.TextView r1 = r0.f18369j
            int r1 = r1.getMeasuredWidth()
            int r4 = r21 - r1
            int r1 = r4 / 2
            goto L_0x027d
        L_0x027c:
            r1 = 0
        L_0x027d:
            if (r13 == 0) goto L_0x02a1
            android.widget.HorizontalScrollView r4 = r0.f18367h
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r4 = (flyme.support.p093v7.widget.Toolbar.C3318b) r4
            android.widget.HorizontalScrollView r5 = r0.f18367h
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r3
            android.widget.HorizontalScrollView r6 = r0.f18367h
            int r6 = r6.getMeasuredHeight()
            int r6 = r6 + r8
            android.widget.HorizontalScrollView r9 = r0.f18367h
            r9.layout(r3, r8, r5, r6)
            int r3 = r0.f18383x
            int r3 = r3 + r5
            int r4 = r4.bottomMargin
            int r8 = r6 + r4
        L_0x02a1:
            if (r15 == 0) goto L_0x02c4
            android.widget.TextView r4 = r0.f18369j
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            flyme.support.v7.widget.Toolbar$b r4 = (flyme.support.p093v7.widget.Toolbar.C3318b) r4
            int r4 = r4.topMargin
            int r8 = r8 + r4
            android.widget.TextView r4 = r0.f18369j
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r1
            android.widget.TextView r5 = r0.f18369j
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f18369j
            r6.layout(r1, r8, r4, r5)
            int r1 = r0.f18383x
            int r1 = r1 + r4
        L_0x02c4:
            if (r7 == 0) goto L_0x02cc
            int r1 = java.lang.Math.max(r3, r1)
            r14 = r1
            goto L_0x02ce
        L_0x02cc:
            r14 = r22
        L_0x02ce:
            int r1 = r0.f18338B
            r1 = r1 & 112(0x70, float:1.57E-43)
            r3 = 17
            if (r1 != r3) goto L_0x02e5
            android.content.Context r1 = r23.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r3 = flyme.support.p093v7.appcompat.R.dimen.mz_toolbar_title_margin_end
            int r1 = r1.getDimensionPixelSize(r3)
            int r14 = r14 + r1
        L_0x02e5:
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            r3 = 3
            r0.m20338a((java.util.List<android.view.View>) r1, (int) r3)
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            int r1 = r1.size()
            r3 = 0
        L_0x02f2:
            if (r3 >= r1) goto L_0x0305
            java.util.ArrayList<android.view.View> r4 = r0.f18345I
            java.lang.Object r4 = r4.get(r3)
            android.view.View r4 = (android.view.View) r4
            r5 = r20
            int r14 = r0.m20332a(r4, r14, r11, r5)
            int r3 = r3 + 1
            goto L_0x02f2
        L_0x0305:
            r5 = r20
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            r3 = 5
            r0.m20338a((java.util.List<android.view.View>) r1, (int) r3)
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            int r1 = r1.size()
            r3 = 0
        L_0x0314:
            if (r3 >= r1) goto L_0x0325
            java.util.ArrayList<android.view.View> r4 = r0.f18345I
            java.lang.Object r4 = r4.get(r3)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.m20343b(r4, r10, r11, r5)
            int r3 = r3 + 1
            goto L_0x0314
        L_0x0325:
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            r3 = 1
            r0.m20338a((java.util.List<android.view.View>) r1, (int) r3)
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            int r1 = r0.m20333a((java.util.List<android.view.View>) r1, (int[]) r11)
            int r4 = r21 - r19
            int r4 = r4 - r18
            int r4 = r4 / 2
            int r6 = r19 + r4
            int r3 = r1 / 2
            int r3 = r6 - r3
            int r1 = r1 + r3
            if (r3 >= r14) goto L_0x0341
            goto L_0x0348
        L_0x0341:
            if (r1 <= r10) goto L_0x0347
            int r1 = r1 - r10
            int r14 = r3 - r1
            goto L_0x0348
        L_0x0347:
            r14 = r3
        L_0x0348:
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            int r1 = r1.size()
        L_0x034e:
            if (r2 >= r1) goto L_0x035f
            java.util.ArrayList<android.view.View> r3 = r0.f18345I
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r14 = r0.m20332a(r3, r14, r11, r5)
            int r2 = r2 + 1
            goto L_0x034e
        L_0x035f:
            java.util.ArrayList<android.view.View> r1 = r0.f18345I
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.Toolbar.m20339a(boolean, int, int, int, int):void");
    }

    private void setTitleMarginNavgationButton(boolean z) {
        if (z) {
            this.f18382w = getContext().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_margin_left_nav_btn);
        } else {
            this.f18382w = getContext().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_margin_left);
        }
    }

    public void setSplitToolbar(boolean z) {
        if (this.f18362c != z) {
            this.f18362c = z;
            if (this.f18366g != null) {
                ViewGroup viewGroup = (ViewGroup) this.f18366g.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f18366g);
                }
                if (z) {
                    if (this.f18361b != null) {
                        this.f18361b.addView(this.f18366g);
                    }
                    this.f18366g.getLayoutParams().width = -1;
                } else {
                    m20337a((View) this.f18366g, false);
                    this.f18366g.getLayoutParams().width = -2;
                }
                this.f18366g.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f18361b = viewGroup;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f18363d) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.mz_split_action_bar_is_narrow));
        }
    }

    public void setMenuVisibility(int i) {
        if (this.f18366g != null && this.f18362c) {
            this.f18366g.setVisibility(i);
        }
    }

    public void setMenuViewAnimateToVisibility(int i, long j) {
        if (this.f18362c && this.f18366g != null) {
            if (i == 0) {
                ViewCompat.setAlpha(this.f18366g, 0.0f);
                ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this.f18366g).alpha(1.0f);
                alpha.setDuration(j);
                alpha.setListener(this.f18365f.mo27030a(alpha, i));
                alpha.start();
                return;
            }
            ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this.f18366g).alpha(0.0f);
            alpha2.setDuration(j);
            alpha2.setListener(this.f18365f.mo27030a(alpha2, i));
            alpha2.start();
        }
    }

    /* renamed from: flyme.support.v7.widget.Toolbar$VisibilityAnimListener */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        int f18392a;

        /* renamed from: c */
        private boolean f18394c = false;

        protected VisibilityAnimListener() {
        }

        /* renamed from: a */
        public VisibilityAnimListener mo27030a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            Toolbar.this.f18364e = viewPropertyAnimatorCompat;
            this.f18392a = i;
            return this;
        }

        public void onAnimationStart(View view) {
            if (Toolbar.this.f18366g != null) {
                Toolbar.this.f18366g.setVisibility(0);
            }
            this.f18394c = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f18394c) {
                Toolbar.this.f18364e = null;
                if (Toolbar.this.f18366g != null) {
                    Toolbar.this.f18366g.setVisibility(this.f18392a);
                }
            }
        }

        public void onAnimationCancel(View view) {
            this.f18394c = true;
        }
    }
}
