package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.menu.ActionMenuItem;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.widget.Toolbar;

/* renamed from: flyme.support.v7.widget.v */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a */
    protected boolean f18588a;

    /* renamed from: b */
    protected boolean f18589b;

    /* renamed from: c */
    ActionBar.C3072b f18590c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Toolbar f18591d;

    /* renamed from: e */
    private int f18592e;

    /* renamed from: f */
    private MzActionBarTabContainer f18593f;

    /* renamed from: g */
    private View f18594g;

    /* renamed from: h */
    private Drawable f18595h;

    /* renamed from: i */
    private Drawable f18596i;

    /* renamed from: j */
    private Drawable f18597j;

    /* renamed from: k */
    private boolean f18598k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CharSequence f18599l;

    /* renamed from: m */
    private CharSequence f18600m;

    /* renamed from: n */
    private CharSequence f18601n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Window.Callback f18602o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f18603p;

    /* renamed from: q */
    private ActionMenuPresenter f18604q;

    /* renamed from: r */
    private int f18605r;

    /* renamed from: s */
    private final AppCompatDrawableManager f18606s;

    /* renamed from: t */
    private int f18607t;

    /* renamed from: u */
    private Drawable f18608u;

    /* renamed from: v */
    private ControlTitleBar f18609v;

    /* renamed from: w */
    private ControlTitleBarController f18610w;

    /* renamed from: x */
    private ActionMenuPresenter f18611x;

    /* renamed from: d */
    public void mo27135d(boolean z) {
    }

    /* renamed from: i */
    public boolean mo27143i() {
        return true;
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.mz_titlebar_ic_back_light);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.f18605r = 0;
        this.f18607t = 0;
        this.f18591d = toolbar;
        this.f18599l = toolbar.getTitle();
        this.f18600m = toolbar.getSubtitle();
        this.f18598k = this.f18599l != null;
        this.f18597j = toolbar.getNavigationIcon();
        if (z) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, CommonUtils.m5121b() ? R.attr.mzActionBarStyleFullScreen : R.attr.actionBarStyle, 0);
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                mo27128b(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                mo27253c(text2);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable != null) {
                mo27256e(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (this.f18597j == null && drawable2 != null) {
                mo27116a(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
            if (drawable3 != null) {
                mo27126b(drawable3);
            }
            mo27130c(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                mo27252a(LayoutInflater.from(this.f18591d.getContext()).inflate(resourceId, this.f18591d, false));
                mo27130c(this.f18592e | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f18591d.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f18591d.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f18591d.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                this.f18591d.setTitleTextAppearance(this.f18591d.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                this.f18591d.setSubtitleTextAppearance(this.f18591d.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f18591d.setPopupTheme(resourceId4);
            }
            obtainStyledAttributes.recycle();
        } else {
            this.f18592e = m20824u();
        }
        this.f18606s = AppCompatDrawableManager.get();
        mo27257f(i);
        this.f18601n = this.f18591d.getNavigationContentDescription();
        mo27254d(this.f18606s.getDrawable(mo27124b(), i2));
        this.f18591d.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a */
            final ActionMenuItem f18612a = new ActionMenuItem(ToolbarWidgetWrapper.this.f18591d.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f18599l);

            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.f18602o != null && ToolbarWidgetWrapper.this.f18603p) {
                    ToolbarWidgetWrapper.this.f18602o.onMenuItemSelected(0, this.f18612a);
                }
            }
        });
    }

    /* renamed from: f */
    public void mo27257f(int i) {
        if (i != this.f18607t) {
            this.f18607t = i;
            if (TextUtils.isEmpty(this.f18591d.getNavigationContentDescription())) {
                mo27138e(this.f18607t);
            }
        }
    }

    /* renamed from: d */
    public void mo27254d(Drawable drawable) {
        if (this.f18608u != drawable) {
            this.f18608u = drawable;
            m20828y();
        }
    }

    /* renamed from: u */
    private int m20824u() {
        return this.f18591d.getNavigationIcon() != null ? 15 : 11;
    }

    /* renamed from: a */
    public ViewGroup mo27113a() {
        return this.f18591d;
    }

    /* renamed from: b */
    public Context mo27124b() {
        return this.f18591d.getContext();
    }

    /* renamed from: c */
    public boolean mo27133c() {
        return this.f18588a;
    }

    /* renamed from: d */
    public boolean mo27136d() {
        return this.f18591d.mo26960g();
    }

    /* renamed from: e */
    public void mo27137e() {
        this.f18591d.mo26978h();
    }

    /* renamed from: a */
    public void mo27119a(Window.Callback callback) {
        this.f18602o = callback;
    }

    /* renamed from: a */
    public void mo27122a(CharSequence charSequence) {
        if (!this.f18598k) {
            m20823e(charSequence);
        }
    }

    /* renamed from: f */
    public CharSequence mo27140f() {
        return this.f18591d.getTitle();
    }

    /* renamed from: b */
    public void mo27128b(CharSequence charSequence) {
        this.f18598k = true;
        m20823e(charSequence);
    }

    /* renamed from: b */
    public void mo27127b(Menu menu, MenuPresenter.C3167a aVar) {
        if (this.f18611x == null) {
            this.f18611x = new ActionMenuPresenter(this.f18591d.getContext());
            this.f18611x.mo25728a(R.id.bottom_action_menu_presenter);
            this.f18611x.mo25948c(true);
            this.f18611x.mo25940a(mo27124b().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.m18758a(mo27124b()).mo25420i() * 2), true);
            this.f18611x.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f18611x.mo25949d(true);
        }
        this.f18611x.mo25733a(aVar);
        this.f18591d.setBottomMenu((MenuBuilder) menu, this.f18611x);
    }

    /* renamed from: e */
    public void mo27139e(boolean z) {
        this.f18591d.setShowBottomMenu(z);
    }

    /* renamed from: e */
    private void m20823e(CharSequence charSequence) {
        this.f18599l = charSequence;
        if ((this.f18592e & 8) != 0) {
            this.f18591d.setTitle(charSequence);
        }
        if (this.f18610w != null) {
            this.f18610w.mo27110a(this.f18599l);
        }
    }

    /* renamed from: c */
    public void mo27253c(CharSequence charSequence) {
        this.f18600m = charSequence;
        if ((this.f18592e & 8) != 0) {
            this.f18591d.setSubtitle(charSequence);
        }
    }

    /* renamed from: g */
    public void mo27141g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: h */
    public void mo27142h() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: a */
    public void mo27118a(ViewGroup viewGroup) {
        this.f18591d.setSplitView(viewGroup);
    }

    /* renamed from: a */
    public void mo27123a(boolean z) {
        if (this.f18588a != z) {
            this.f18588a = z;
            this.f18591d.setSplitToolbar(z);
            if (this.f18604q != null) {
                if (!z) {
                    this.f18604q.mo25948c(false);
                } else {
                    this.f18604q.mo25948c(true);
                    this.f18604q.mo25940a(mo27124b().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.m18758a(mo27124b()).mo25420i() * 2), true);
                    this.f18604q.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
                this.f18604q.mo25949d(z);
            }
        }
    }

    /* renamed from: b */
    public void mo27129b(boolean z) {
        this.f18589b = z;
    }

    /* renamed from: a */
    public void mo27115a(int i) {
        mo27116a(i != 0 ? this.f18606s.getDrawable(mo27124b(), i) : null);
    }

    /* renamed from: a */
    public void mo27116a(Drawable drawable) {
        this.f18595h = drawable;
        m20825v();
    }

    /* renamed from: b */
    public void mo27125b(int i) {
        mo27256e(i != 0 ? this.f18606s.getDrawable(mo27124b(), i) : null);
    }

    /* renamed from: e */
    public void mo27256e(Drawable drawable) {
        this.f18596i = drawable;
        m20825v();
    }

    /* renamed from: v */
    private void m20825v() {
        Drawable drawable;
        if ((this.f18592e & 2) != 0) {
            drawable = (this.f18592e & 1) != 0 ? this.f18596i != null ? this.f18596i : this.f18595h : this.f18595h;
        } else {
            drawable = null;
        }
        this.f18591d.setLogo(drawable);
    }

    /* renamed from: j */
    public boolean mo27144j() {
        return this.f18591d.mo26953a();
    }

    /* renamed from: k */
    public boolean mo27145k() {
        return this.f18591d.mo26954b();
    }

    /* renamed from: l */
    public boolean mo27146l() {
        return this.f18591d.mo26955c();
    }

    /* renamed from: m */
    public boolean mo27147m() {
        return this.f18591d.mo26957d();
    }

    /* renamed from: n */
    public boolean mo27148n() {
        return this.f18591d.mo26958e();
    }

    /* renamed from: o */
    public void mo27149o() {
        this.f18603p = true;
    }

    /* renamed from: a */
    public void mo27117a(Menu menu, MenuPresenter.C3167a aVar) {
        if (this.f18604q == null) {
            this.f18604q = new ActionMenuPresenter(this.f18591d.getContext());
            this.f18604q.mo25728a(R.id.action_menu_presenter);
            if (this.f18588a) {
                this.f18604q.mo25948c(true);
                this.f18604q.mo25940a(mo27124b().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.m18758a(mo27124b()).mo25420i() * 2), true);
                this.f18604q.mo25947c((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f18604q.mo25949d(true);
            }
        }
        this.f18604q.mo25733a(aVar);
        this.f18591d.setMenu((MenuBuilder) menu, this.f18604q);
    }

    /* renamed from: p */
    public void mo27150p() {
        this.f18591d.mo26959f();
    }

    /* renamed from: q */
    public int mo27151q() {
        return this.f18592e;
    }

    /* renamed from: c */
    public void mo27130c(int i) {
        int i2 = this.f18592e ^ i;
        this.f18592e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m20828y();
                    m20827x();
                } else {
                    this.f18591d.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                m20825v();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f18591d.setTitle(this.f18599l);
                    this.f18591d.setSubtitle(this.f18600m);
                    this.f18591d.setContentInsetsRelative(mo27124b().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_content_inset_start), this.f18591d.getContentInsetEnd());
                } else {
                    this.f18591d.setTitle((CharSequence) null);
                    this.f18591d.setSubtitle((CharSequence) null);
                }
            }
            if (!((i2 & 16) == 0 || this.f18594g == null)) {
                if ((i & 16) != 0) {
                    this.f18591d.addView(this.f18594g);
                } else {
                    this.f18591d.removeView(this.f18594g);
                }
            }
            if (!((i2 & 32) == 0 || this.f18593f == null)) {
                if ((i & 32) != 0) {
                    if (this.f18593f != null && this.f18605r == 2) {
                        this.f18591d.addView(this.f18593f, 0);
                        Toolbar.C3318b bVar = (Toolbar.C3318b) this.f18593f.getLayoutParams();
                        bVar.width = -2;
                        bVar.height = -2;
                        bVar.f16596a = 8388627;
                        this.f18593f.mo26128a(true);
                    }
                } else if (this.f18593f != null && this.f18593f.getParent() == this.f18591d) {
                    this.f18591d.removeView(this.f18593f);
                }
            }
            if ((i2 & 64) != 0) {
                m20826w();
                if ((i & 64) != 0) {
                    this.f18591d.addView(this.f18609v);
                    this.f18591d.setContentInsetsRelative(0, 0);
                    return;
                }
                this.f18591d.removeView(this.f18609v);
            }
        }
    }

    /* renamed from: w */
    private void m20826w() {
        if (this.f18609v == null) {
            this.f18610w = new ControlTitleBarController();
            this.f18609v = this.f18610w.mo27107a(mo27124b());
            this.f18610w.mo27110a(this.f18599l);
            int i = R.id.mz_control_title_bar_btn_ok;
            int i2 = R.id.mz_control_title_bar_btn_cancel;
            String string = mo27124b().getString(17039370);
            String string2 = mo27124b().getString(17039360);
            C3349a aVar = new C3349a(this.f18610w);
            C3349a aVar2 = new C3349a(this.f18610w);
            this.f18610w.mo27111b();
            if (this.f18590c != null) {
                this.f18590c.mo25062a(1, aVar);
                this.f18590c.mo25062a(0, aVar2);
            } else {
                aVar.mo27265a(string);
                aVar2.mo27265a(string2);
            }
            if (aVar.mo27266b() == -1) {
                aVar.mo27262a(i);
            }
            if (aVar2.mo27266b() == -1) {
                aVar2.mo27262a(i2);
            }
            final ActionMenuItem actionMenuItem = new ActionMenuItem(this.f18591d.getContext(), 0, aVar2.mo27266b(), 0, 0, aVar2.mo27261a());
            final ActionMenuItem actionMenuItem2 = new ActionMenuItem(this.f18591d.getContext(), 0, aVar.mo27266b(), 0, 0, aVar.mo27261a());
            aVar2.mo27263a(actionMenuItem);
            aVar.mo27263a(actionMenuItem2);
            this.f18610w.mo27109a(0, aVar2, new View.OnClickListener() {
                public void onClick(View view) {
                    if (ToolbarWidgetWrapper.this.f18602o != null && ToolbarWidgetWrapper.this.f18603p) {
                        ToolbarWidgetWrapper.this.f18602o.onMenuItemSelected(0, actionMenuItem);
                    }
                }
            });
            this.f18610w.mo27109a(1, aVar, new View.OnClickListener() {
                public void onClick(View view) {
                    if (ToolbarWidgetWrapper.this.f18602o != null && ToolbarWidgetWrapper.this.f18603p) {
                        ToolbarWidgetWrapper.this.f18602o.onMenuItemSelected(0, actionMenuItem2);
                    }
                }
            });
            this.f18610w.mo27112c();
        }
    }

    /* renamed from: a */
    public void mo27121a(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f18593f != null && this.f18593f.getParent() == this.f18591d) {
            this.f18591d.removeView(this.f18593f);
        }
        if (this.f18593f == null && scrollingTabContainerView != null) {
            this.f18593f = new MzActionBarTabContainer(mo27124b());
        }
        if (scrollingTabContainerView != null) {
            this.f18593f.setTabView(scrollingTabContainerView);
            this.f18593f.mo26128a(true);
            if (this.f18605r == 2) {
                this.f18591d.addView(this.f18593f);
                this.f18591d.setContentInsetsRelative(mo27124b().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_content_inset_start_with_tab), this.f18591d.getContentInsetEnd());
                Toolbar.C3318b bVar = (Toolbar.C3318b) this.f18593f.getLayoutParams();
                bVar.width = -2;
                bVar.height = -2;
                bVar.f16596a = 8388627;
            }
        } else if (this.f18593f != null) {
            this.f18593f.setTabView((ScrollingTabContainerView) null);
            this.f18593f = null;
        }
    }

    /* renamed from: c */
    public void mo27132c(boolean z) {
        this.f18591d.setCollapsible(z);
    }

    /* renamed from: r */
    public int mo27152r() {
        return this.f18605r;
    }

    /* renamed from: a */
    public void mo27252a(View view) {
        if (!(this.f18594g == null || (this.f18592e & 16) == 0)) {
            this.f18591d.removeView(this.f18594g);
        }
        this.f18594g = view;
        if (view != null && (this.f18592e & 16) != 0) {
            this.f18591d.addView(this.f18594g);
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat mo27114a(int i, long j) {
        if (this.f18591d != null) {
            this.f18591d.setMenuViewAnimateToVisibility(i, j);
        }
        return ViewCompat.animate(this.f18591d).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ToolbarWidgetWrapper$4(this, i));
    }

    /* renamed from: b */
    public void mo27126b(Drawable drawable) {
        this.f18597j = drawable;
        m20828y();
    }

    /* renamed from: d */
    public void mo27134d(int i) {
        mo27126b(i != 0 ? AppCompatDrawableManager.get().getDrawable(mo27124b(), i) : null);
    }

    /* renamed from: d */
    public void mo27255d(CharSequence charSequence) {
        this.f18601n = charSequence;
        m20827x();
    }

    /* renamed from: e */
    public void mo27138e(int i) {
        mo27255d((CharSequence) i == 0 ? null : mo27124b().getString(i));
    }

    /* renamed from: x */
    private void m20827x() {
        if ((this.f18592e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f18601n)) {
            this.f18591d.setNavigationContentDescription(this.f18607t);
        } else {
            this.f18591d.setNavigationContentDescription(this.f18601n);
        }
    }

    /* renamed from: y */
    private void m20828y() {
        if ((this.f18592e & 4) != 0) {
            this.f18591d.setNavigationIcon(this.f18597j != null ? this.f18597j : this.f18608u);
        }
    }

    /* renamed from: c */
    public void mo27131c(Drawable drawable) {
        this.f18591d.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void mo27120a(MenuPresenter.C3167a aVar, MenuBuilder.C3159a aVar2) {
        this.f18591d.setMenuCallbacks(aVar, aVar2);
    }

    /* renamed from: s */
    public Menu mo27153s() {
        return this.f18591d.getMenu();
    }

    /* renamed from: t */
    public MzActionBarTabContainer mo27154t() {
        return this.f18593f;
    }

    /* renamed from: flyme.support.v7.widget.v$a */
    /* compiled from: ToolbarWidgetWrapper */
    class C3349a implements ActionBar.C3071a {

        /* renamed from: b */
        private String f18619b;

        /* renamed from: c */
        private int f18620c = -1;

        /* renamed from: d */
        private Drawable f18621d;

        /* renamed from: e */
        private int f18622e = 16;

        /* renamed from: f */
        private ControlTitleBarController f18623f;

        /* renamed from: g */
        private ActionMenuItem f18624g;

        public C3349a(ControlTitleBarController eVar) {
            this.f18623f = eVar;
        }

        /* renamed from: a */
        public void mo27264a(ControlTitleBarController eVar) {
            this.f18623f = eVar;
        }

        /* renamed from: a */
        public void mo27265a(String str) {
            if (this.f18619b != str) {
                this.f18619b = str;
                if (this.f18623f != null) {
                    this.f18623f.mo27108a();
                }
                if (this.f18624g != null) {
                    this.f18624g.setTitle((CharSequence) str);
                }
            }
        }

        /* renamed from: a */
        public String mo27261a() {
            return this.f18619b;
        }

        /* renamed from: a */
        public void mo27262a(int i) {
            this.f18620c = i;
        }

        /* renamed from: b */
        public int mo27266b() {
            return this.f18620c;
        }

        /* renamed from: c */
        public Drawable mo27267c() {
            return this.f18621d;
        }

        /* renamed from: d */
        public boolean mo27268d() {
            return (this.f18622e & 16) != 0;
        }

        /* renamed from: e */
        public boolean mo27269e() {
            return (this.f18622e & 8) == 0;
        }

        /* renamed from: a */
        public void mo27263a(ActionMenuItem actionMenuItem) {
            this.f18624g = actionMenuItem;
        }
    }
}
