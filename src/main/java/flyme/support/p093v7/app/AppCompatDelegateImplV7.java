package flyme.support.p093v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.NavUtils;
import androidx.core.p005os.ParcelableCompat;
import androidx.core.p005os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.LayoutInflaterFactory;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.FMenu;
import flyme.support.p093v7.view.menu.FMenuItem;
import flyme.support.p093v7.view.menu.ListMenuPresenter;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;
import flyme.support.p093v7.widget.ActionBarContextView;
import flyme.support.p093v7.widget.C3352x;
import flyme.support.p093v7.widget.DecorContentParent;
import java.lang.reflect.Field;

/* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7 */
public class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements LayoutInflaterFactory, MenuBuilder.C3159a {

    /* renamed from: A */
    private boolean f16753A;

    /* renamed from: B */
    private boolean f16754B;

    /* renamed from: C */
    private PanelFeatureState[] f16755C;

    /* renamed from: D */
    private PanelFeatureState f16756D;

    /* renamed from: E */
    private boolean f16757E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f16758F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f16759G;

    /* renamed from: H */
    private final Runnable f16760H = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV7.this.f16759G & 1) != 0) {
                AppCompatDelegateImplV7.this.m18385g(0);
            }
            if ((AppCompatDelegateImplV7.this.f16759G & 4096) != 0) {
                AppCompatDelegateImplV7.this.m18385g(108);
            }
            boolean unused = AppCompatDelegateImplV7.this.f16758F = false;
            int unused2 = AppCompatDelegateImplV7.this.f16759G = 0;
        }
    };

    /* renamed from: I */
    private boolean f16761I;

    /* renamed from: J */
    private Rect f16762J;

    /* renamed from: K */
    private Rect f16763K;

    /* renamed from: L */
    private AppCompatViewInflater f16764L;

    /* renamed from: M */
    private boolean f16765M;

    /* renamed from: N */
    private final MenuBuilder.C3159a f16766N = new MenuBuilder.C3159a() {
        /* renamed from: a */
        public void mo25219a(MenuBuilder menuBuilder) {
        }

        /* renamed from: a */
        public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return AppCompatDelegateImplV7.this.m18374b(menuBuilder, menuItem);
        }
    };

    /* renamed from: O */
    private View.OnClickListener f16767O = new View.OnClickListener() {
        public void onClick(View view) {
            if (AppCompatDelegateImplV7.this.f16731e != null && !AppCompatDelegateImplV7.this.mo25210o()) {
                AppCompatDelegateImplV7.this.f16731e.mo25168h();
            }
        }
    };

    /* renamed from: n */
    ActionMode f16768n;

    /* renamed from: o */
    ActionBarContextView f16769o;

    /* renamed from: p */
    PopupWindow f16770p;

    /* renamed from: q */
    Runnable f16771q;

    /* renamed from: r */
    ViewPropertyAnimatorCompat f16772r = null;

    /* renamed from: s */
    private DecorContentParent f16773s;

    /* renamed from: t */
    private C3105a f16774t;

    /* renamed from: u */
    private C3107c f16775u;

    /* renamed from: v */
    private boolean f16776v;

    /* renamed from: w */
    private ViewGroup f16777w;

    /* renamed from: x */
    private TextView f16778x;

    /* renamed from: y */
    private View f16779y;

    /* renamed from: z */
    private boolean f16780z;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25214a(ViewGroup viewGroup) {
    }

    /* renamed from: h */
    public void mo25197h() {
    }

    AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback aVar) {
        super(context, window, aVar);
    }

    /* renamed from: a */
    public void mo25181a(Bundle bundle) {
        C3352x.m20912a();
        if ((this.f16729c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.f16729c) != null) {
            ActionBar l = mo25207l();
            if (l == null) {
                this.f16761I = true;
            } else {
                l.mo25054d(true);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 19 && m18364a(this.f16728b.getAttributes(), true)) {
            View childAt = ((ViewGroup) this.f16728b.getDecorView()).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
            }
            this.f16765M = true;
        }
    }

    /* renamed from: b */
    public void mo25187b(Bundle bundle) {
        m18388s();
    }

    /* renamed from: k */
    public void mo25206k() {
        m18388s();
        if (this.f16734h && this.f16732f == null) {
            if (this.f16729c instanceof Activity) {
                this.f16732f = new WindowDecorActionBar((Activity) this.f16729c, this.f16735i);
            } else if (this.f16729c instanceof Dialog) {
                this.f16732f = new WindowDecorActionBar((Dialog) this.f16729c);
            }
            if (this.f16732f != null) {
                this.f16732f.mo25054d(this.f16761I);
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public View mo25178a(@IdRes int i) {
        m18388s();
        return this.f16728b.findViewById(i);
    }

    /* renamed from: a */
    public void mo25180a(Configuration configuration) {
        ActionBar a;
        if (this.f16734h && this.f16776v && (a = mo25179a()) != null) {
            a.mo25038a(configuration);
        }
        mo25198i();
    }

    /* renamed from: c */
    public void mo25189c() {
        ActionBar a = mo25179a();
        if (a != null) {
            a.mo25057e(false);
        }
    }

    /* renamed from: d */
    public void mo25192d() {
        ActionBar a = mo25179a();
        if (a != null) {
            a.mo25057e(true);
        }
    }

    /* renamed from: a */
    public void mo25182a(View view) {
        m18388s();
        ViewGroup viewGroup = (ViewGroup) this.f16777w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f16729c.onContentChanged();
    }

    /* renamed from: b */
    public void mo25186b(int i) {
        m18388s();
        ViewGroup viewGroup = (ViewGroup) this.f16777w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f16727a).inflate(i, viewGroup);
        this.f16729c.onContentChanged();
    }

    /* renamed from: a */
    public void mo25183a(View view, ViewGroup.LayoutParams layoutParams) {
        m18388s();
        ViewGroup viewGroup = (ViewGroup) this.f16777w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f16729c.onContentChanged();
    }

    /* renamed from: b */
    public void mo25188b(View view, ViewGroup.LayoutParams layoutParams) {
        m18388s();
        ((ViewGroup) this.f16777w.findViewById(16908290)).addView(view, layoutParams);
        this.f16729c.onContentChanged();
    }

    /* renamed from: f */
    public void mo25195f() {
        super.mo25195f();
        if (this.f16732f != null) {
            this.f16732f.mo25059f();
        }
    }

    /* renamed from: s */
    private void m18388s() {
        if (!this.f16776v) {
            this.f16777w = m18389t();
            CharSequence q = mo25212q();
            if (!TextUtils.isEmpty(q)) {
                mo25204b(q);
            }
            m18390u();
            mo25214a(this.f16777w);
            this.f16776v = true;
            PanelFeatureState a = m18352a(0, false);
            if (!mo25210o() && (a == null || a.f16800j == null)) {
                m18384f(108);
            }
            if (mo25179a() != null) {
                mo25179a().mo25056e(this.f16739m);
            }
        }
    }

    /* renamed from: t */
    private ViewGroup m18389t() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f16727a.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                mo25191c(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                mo25191c(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                mo25191c(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                mo25191c(10);
            }
            this.f16737k = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f16728b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f16727a);
            if (this.f16738l) {
                if (this.f16736j) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            int c = AppCompatDelegateImplV7.this.m18386h(systemWindowInsetTop);
                            if (systemWindowInsetTop != c) {
                                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), c, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                        }
                    });
                } else {
                    ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                        public void onFitSystemWindows(Rect rect) {
                            rect.top = AppCompatDelegateImplV7.this.m18386h(rect.top);
                        }
                    });
                }
            } else if (this.f16737k) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f16735i = false;
                this.f16734h = false;
            } else if (this.f16734h) {
                TypedValue typedValue = new TypedValue();
                this.f16727a.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.f16727a, typedValue.resourceId);
                } else {
                    context = this.f16727a;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(CommonUtils.m5121b() ? R.layout.mz_abc_screen_toolbar_full_screen : R.layout.mz_abc_screen_toolbar, (ViewGroup) null);
                this.f16773s = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                this.f16773s.setWindowCallback(mo25211p());
                if (this.f16735i) {
                    this.f16773s.mo25888a(109);
                }
                if (this.f16780z) {
                    this.f16773s.mo25888a(2);
                }
                if (this.f16753A) {
                    this.f16773s.mo25888a(5);
                }
                this.f16773s.setTransStatusBarInFlyme3(this.f16765M);
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.f16773s == null) {
                    this.f16778x = (TextView) viewGroup.findViewById(R.id.title);
                }
                C3352x.m20916b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f16728b.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if ((viewGroup2 instanceof FrameLayout) && Build.VERSION.SDK_INT >= 23) {
                        viewGroup2.setForeground((Drawable) null);
                    }
                }
                this.f16728b.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                    public void onAttachedFromWindow() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImplV7.this.m18393x();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f16734h + ", windowActionBarOverlay: " + this.f16735i + ", android:windowIsFloating: " + this.f16737k + ", windowActionModeOverlay: " + this.f16736j + ", windowNoTitle: " + this.f16738l + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: u */
    private void m18390u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f16777w.findViewById(16908290);
        View decorView = this.f16728b.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f16727a.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: c */
    public boolean mo25191c(int i) {
        int i2 = m18387i(i);
        if (this.f16738l && i2 == 108) {
            return false;
        }
        if (this.f16734h && i2 == 1) {
            this.f16734h = false;
        }
        switch (i2) {
            case 1:
                m18392w();
                this.f16738l = true;
                return true;
            case 2:
                m18392w();
                this.f16780z = true;
                return true;
            case 5:
                m18392w();
                this.f16753A = true;
                return true;
            case 10:
                m18392w();
                this.f16736j = true;
                return true;
            case 108:
                m18392w();
                this.f16734h = true;
                return true;
            case 109:
                m18392w();
                this.f16735i = true;
                return true;
            default:
                return this.f16728b.requestFeature(i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25204b(CharSequence charSequence) {
        if (this.f16773s != null) {
            this.f16773s.setWindowTitle(charSequence);
        } else if (mo25207l() != null) {
            mo25207l().mo25047b(charSequence);
        } else if (this.f16778x != null) {
            this.f16778x.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25201a(int i, Menu menu) {
        if (i == 108) {
            ActionBar a = mo25179a();
            if (a != null) {
                a.mo25060f(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = m18352a(i, true);
            if (a2.f16805o) {
                m18357a(a2, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo25205b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar a = mo25179a();
        if (a != null) {
            a.mo25060f(true);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a;
        Window.Callback p = mo25211p();
        if (p == null || mo25210o() || (a = m18353a((Menu) menuBuilder.mo25593p())) == null) {
            return false;
        }
        boolean onMenuItemSelected = p.onMenuItemSelected(a.f16791a, menuItem);
        return (onMenuItemSelected || !(menuItem instanceof FMenuItem)) ? onMenuItemSelected : this.f16731e.mo25152a(a.f16791a, (FMenuItem) menuItem);
    }

    /* renamed from: a */
    public void mo25219a(MenuBuilder menuBuilder) {
        m18362a(menuBuilder, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m18374b(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f16731e == null || mo25210o() || !(menuItem instanceof FMenuItem)) {
            return false;
        }
        return this.f16731e.mo25154a((FMenuItem) menuItem);
    }

    /* renamed from: b */
    public ActionMode mo25222b(ActionMode.C3152b bVar) {
        if (bVar != null) {
            if (this.f16768n != null) {
                this.f16768n.mo25352c();
            }
            C3106b bVar2 = new C3106b(bVar);
            ActionBar a = mo25179a();
            if (a != null) {
                this.f16768n = a.mo25035a((ActionMode.C3152b) bVar2);
                if (!(this.f16768n == null || this.f16731e == null)) {
                    this.f16731e.mo25151a(this.f16768n);
                }
            }
            if (this.f16768n == null) {
                this.f16768n = mo25200a((ActionMode.C3152b) bVar2);
            }
            return this.f16768n;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: e */
    public void mo25194e() {
        ActionBar a = mo25179a();
        if (a == null || !a.mo25055d()) {
            m18384f(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public flyme.support.p093v7.view.ActionMode mo25200a(flyme.support.p093v7.view.ActionMode.C3152b r9) {
        /*
            r8 = this;
            r8.m18391v()
            flyme.support.v7.view.b r0 = r8.f16768n
            if (r0 == 0) goto L_0x000c
            flyme.support.v7.view.b r0 = r8.f16768n
            r0.mo25352c()
        L_0x000c:
            flyme.support.v7.app.AppCompatDelegateImplV7$b r0 = new flyme.support.v7.app.AppCompatDelegateImplV7$b
            r0.<init>(r9)
            flyme.support.v7.app.a r1 = r8.f16731e
            r2 = 0
            if (r1 == 0) goto L_0x0023
            boolean r1 = r8.mo25210o()
            if (r1 != 0) goto L_0x0023
            flyme.support.v7.app.a r1 = r8.f16731e     // Catch:{ AbstractMethodError -> 0x0023 }
            flyme.support.v7.view.b r1 = r1.mo25148a((flyme.support.p093v7.view.ActionMode.C3152b) r0)     // Catch:{ AbstractMethodError -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            if (r1 == 0) goto L_0x002a
            r8.f16768n = r1
            goto L_0x0142
        L_0x002a:
            flyme.support.v7.widget.ActionBarContextView r1 = r8.f16769o
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x00e0
            boolean r1 = r8.f16737k
            if (r1 == 0) goto L_0x00c1
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.Context r5 = r8.f16727a
            android.content.res.Resources$Theme r5 = r5.getTheme()
            int r6 = flyme.support.p093v7.appcompat.R.attr.actionBarTheme
            r5.resolveAttribute(r6, r1, r4)
            int r6 = r1.resourceId
            if (r6 == 0) goto L_0x0069
            android.content.Context r6 = r8.f16727a
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.newTheme()
            r6.setTo(r5)
            int r5 = r1.resourceId
            r6.applyStyle(r5, r4)
            androidx.appcompat.view.ContextThemeWrapper r5 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r7 = r8.f16727a
            r5.<init>((android.content.Context) r7, (int) r3)
            android.content.res.Resources$Theme r7 = r5.getTheme()
            r7.setTo(r6)
            goto L_0x006b
        L_0x0069:
            android.content.Context r5 = r8.f16727a
        L_0x006b:
            flyme.support.v7.widget.ActionBarContextView r6 = new flyme.support.v7.widget.ActionBarContextView
            r6.<init>(r5)
            r8.f16769o = r6
            android.widget.PopupWindow r6 = new android.widget.PopupWindow
            int r7 = flyme.support.p093v7.appcompat.R.attr.actionModePopupWindowStyle
            r6.<init>(r5, r2, r7)
            r8.f16770p = r6
            android.widget.PopupWindow r6 = r8.f16770p
            r7 = 2
            androidx.core.widget.PopupWindowCompat.setWindowLayoutType(r6, r7)
            android.widget.PopupWindow r6 = r8.f16770p
            flyme.support.v7.widget.ActionBarContextView r7 = r8.f16769o
            r6.setContentView(r7)
            android.widget.PopupWindow r6 = r8.f16770p
            r7 = -1
            r6.setWidth(r7)
            android.content.res.Resources$Theme r6 = r5.getTheme()
            boolean r7 = com.meizu.common.util.CommonUtils.m5121b()
            if (r7 == 0) goto L_0x009b
            int r7 = flyme.support.p093v7.appcompat.R.attr.mzActionBarSizeFullScreen
            goto L_0x009d
        L_0x009b:
            int r7 = flyme.support.p093v7.appcompat.R.attr.actionBarSize
        L_0x009d:
            r6.resolveAttribute(r7, r1, r4)
            int r1 = r1.data
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            int r1 = android.util.TypedValue.complexToDimensionPixelSize(r1, r5)
            flyme.support.v7.widget.ActionBarContextView r5 = r8.f16769o
            r5.setContentHeight(r1)
            android.widget.PopupWindow r1 = r8.f16770p
            r5 = -2
            r1.setHeight(r5)
            flyme.support.v7.app.AppCompatDelegateImplV7$6 r1 = new flyme.support.v7.app.AppCompatDelegateImplV7$6
            r1.<init>()
            r8.f16771q = r1
            goto L_0x00e0
        L_0x00c1:
            android.view.ViewGroup r1 = r8.f16777w
            int r5 = flyme.support.p093v7.appcompat.R.id.action_mode_bar_stub
            android.view.View r1 = r1.findViewById(r5)
            androidx.appcompat.widget.ViewStubCompat r1 = (androidx.appcompat.widget.ViewStubCompat) r1
            if (r1 == 0) goto L_0x00e0
            android.content.Context r5 = r8.mo25208m()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            r1.setLayoutInflater(r5)
            android.view.View r1 = r1.inflate()
            flyme.support.v7.widget.ActionBarContextView r1 = (flyme.support.p093v7.widget.ActionBarContextView) r1
            r8.f16769o = r1
        L_0x00e0:
            flyme.support.v7.widget.ActionBarContextView r1 = r8.f16769o
            if (r1 == 0) goto L_0x0142
            r8.m18391v()
            flyme.support.v7.widget.ActionBarContextView r1 = r8.f16769o
            r1.mo25856c()
            flyme.support.v7.view.f r1 = new flyme.support.v7.view.f
            flyme.support.v7.widget.ActionBarContextView r5 = r8.f16769o
            android.content.Context r5 = r5.getContext()
            flyme.support.v7.widget.ActionBarContextView r6 = r8.f16769o
            android.widget.PopupWindow r7 = r8.f16770p
            if (r7 != 0) goto L_0x00fb
            r3 = 1
        L_0x00fb:
            r1.<init>(r5, r6, r0, r3)
            android.view.Menu r0 = r1.mo25348b()
            boolean r9 = r9.mo25245a((flyme.support.p093v7.view.ActionMode) r1, (android.view.Menu) r0)
            if (r9 == 0) goto L_0x0140
            r1.mo25353d()
            flyme.support.v7.widget.ActionBarContextView r9 = r8.f16769o
            r9.mo25852a((flyme.support.p093v7.view.ActionMode) r1)
            r8.f16768n = r1
            flyme.support.v7.widget.ActionBarContextView r9 = r8.f16769o
            r0 = 0
            androidx.core.view.ViewCompat.setAlpha(r9, r0)
            flyme.support.v7.widget.ActionBarContextView r9 = r8.f16769o
            androidx.core.view.ViewPropertyAnimatorCompat r9 = androidx.core.view.ViewCompat.animate(r9)
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.core.view.ViewPropertyAnimatorCompat r9 = r9.alpha(r0)
            r8.f16772r = r9
            androidx.core.view.ViewPropertyAnimatorCompat r9 = r8.f16772r
            flyme.support.v7.app.AppCompatDelegateImplV7$7 r0 = new flyme.support.v7.app.AppCompatDelegateImplV7$7
            r0.<init>()
            r9.setListener(r0)
            android.widget.PopupWindow r9 = r8.f16770p
            if (r9 == 0) goto L_0x0142
            android.view.Window r9 = r8.f16728b
            android.view.View r9 = r9.getDecorView()
            java.lang.Runnable r0 = r8.f16771q
            r9.post(r0)
            goto L_0x0142
        L_0x0140:
            r8.f16768n = r2
        L_0x0142:
            flyme.support.v7.view.b r9 = r8.f16768n
            if (r9 == 0) goto L_0x0151
            flyme.support.v7.app.a r9 = r8.f16731e
            if (r9 == 0) goto L_0x0151
            flyme.support.v7.app.a r9 = r8.f16731e
            flyme.support.v7.view.b r0 = r8.f16768n
            r9.mo25151a((flyme.support.p093v7.view.ActionMode) r0)
        L_0x0151:
            flyme.support.v7.view.b r9 = r8.f16768n
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.app.AppCompatDelegateImplV7.mo25200a(flyme.support.v7.view.b$b):flyme.support.v7.view.b");
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m18391v() {
        if (this.f16772r != null) {
            this.f16772r.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo25226r() {
        if (this.f16768n != null) {
            ActionMode.C3151a m = this.f16768n.mo25425m();
            if (m == null || !m.mo25360a()) {
                return false;
            }
            this.f16768n.mo25352c();
            return true;
        }
        ActionBar a = mo25179a();
        if (a == null || !a.mo25058e()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25202a(int i, KeyEvent keyEvent) {
        ActionBar a = mo25179a();
        if (a != null && a.mo25042a(i, keyEvent)) {
            return true;
        }
        if (this.f16756D != null && m18366a(this.f16756D, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f16756D != null) {
                this.f16756D.f16804n = true;
            }
            return true;
        } else if (this.f16756D != null) {
            return false;
        } else {
            PanelFeatureState a2 = m18352a(0, true);
            m18373b(a2, keyEvent);
            boolean a3 = m18366a(a2, keyEvent.getKeyCode(), keyEvent, 1);
            a2.f16803m = false;
            return a3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25203a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.f16729c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo25225c(keyCode, keyEvent) : mo25223b(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo25223b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f16757E;
            this.f16757E = false;
            PanelFeatureState a = m18352a(0, false);
            if (a != null && a.f16805o) {
                if (!z) {
                    m18357a(a, true);
                }
                return true;
            } else if (mo25226r()) {
                return true;
            }
        } else if (i == 82) {
            m18383e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo25225c(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.f16757E = z;
        } else if (i == 82) {
            m18379d(0, keyEvent);
            return true;
        }
        if (Build.VERSION.SDK_INT < 11) {
            mo25202a(i, keyEvent);
        }
        return false;
    }

    /* renamed from: b */
    public View mo25221b(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.f16764L == null) {
            this.f16764L = new AppCompatViewInflater();
        }
        return this.f16764L.mo25321a(view, str, context, attributeSet, z && m18363a((ViewParent) view), z, true, VectorEnabledTintResources.shouldBeUsed());
    }

    /* renamed from: a */
    private boolean m18363a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f16728b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo25213a(view, str, context, attributeSet);
        if (a != null) {
            return a;
        }
        return mo25221b(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo25213a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.f16729c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.f16729c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    /* renamed from: a */
    private void m18356a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f16805o && !mo25210o()) {
            if (panelFeatureState.f16791a == 0) {
                Context context = this.f16727a;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback p = mo25211p();
            if (p == null || p.onMenuOpened(panelFeatureState.f16791a, panelFeatureState.f16800j)) {
                WindowManager windowManager = (WindowManager) this.f16727a.getSystemService("window");
                if (windowManager != null && m18373b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f16797g == null || panelFeatureState.f16807q) {
                        if (panelFeatureState.f16797g == null) {
                            if (!m18365a(panelFeatureState) || panelFeatureState.f16797g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f16807q && panelFeatureState.f16797g.getChildCount() > 0) {
                            panelFeatureState.f16797g.removeAllViews();
                        }
                        if (m18380d(panelFeatureState) && panelFeatureState.mo25236a()) {
                            ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f16798h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            panelFeatureState.f16797g.setBackgroundResource(panelFeatureState.f16792b);
                            ViewParent parent = panelFeatureState.f16798h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.f16798h);
                            }
                            panelFeatureState.f16797g.addView(panelFeatureState.f16798h, layoutParams2);
                            if (!panelFeatureState.f16798h.hasFocus()) {
                                panelFeatureState.f16798h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (!(panelFeatureState.f16799i == null || (layoutParams = panelFeatureState.f16799i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i = -1;
                        panelFeatureState.f16804n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f16794d, panelFeatureState.f16795e, 1002, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.f16793c;
                        layoutParams3.windowAnimations = panelFeatureState.f16796f;
                        windowManager.addView(panelFeatureState.f16797g, layoutParams3);
                        panelFeatureState.f16805o = true;
                        return;
                    }
                    i = -2;
                    panelFeatureState.f16804n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f16794d, panelFeatureState.f16795e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f16793c;
                    layoutParams32.windowAnimations = panelFeatureState.f16796f;
                    windowManager.addView(panelFeatureState.f16797g, layoutParams32);
                    panelFeatureState.f16805o = true;
                    return;
                }
                return;
            }
            m18357a(panelFeatureState, true);
        }
    }

    /* renamed from: a */
    private boolean m18365a(PanelFeatureState panelFeatureState) {
        panelFeatureState.mo25234a(mo25208m());
        panelFeatureState.f16797g = new ListMenuDecorView(panelFeatureState.f16802l);
        panelFeatureState.f16793c = 81;
        return true;
    }

    /* renamed from: a */
    private void m18362a(MenuBuilder menuBuilder, boolean z) {
        if (this.f16773s == null || !this.f16773s.mo25894d() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f16727a)) && !this.f16773s.mo25897f())) {
            PanelFeatureState a = m18352a(0, true);
            a.f16807q = true;
            m18357a(a, false);
            m18356a(a, (KeyEvent) null);
            return;
        }
        Window.Callback p = mo25211p();
        if (this.f16773s.mo25896e() && z) {
            this.f16773s.mo25905h();
            if (!mo25210o()) {
                p.onPanelClosed(108, m18352a(0, true).f16800j);
            }
        } else if (p != null && !mo25210o()) {
            if (this.f16758F && (this.f16759G & 1) != 0) {
                this.f16728b.getDecorView().removeCallbacks(this.f16760H);
                this.f16760H.run();
            }
            PanelFeatureState a2 = m18352a(0, true);
            if (a2.f16800j != null && !a2.f16808r && p.onPreparePanel(0, a2.f16799i, a2.f16800j)) {
                p.onMenuOpened(108, a2.f16800j);
                this.f16773s.mo25899g();
            }
        }
    }

    /* renamed from: b */
    private boolean m18372b(PanelFeatureState panelFeatureState) {
        Context context = this.f16727a;
        if ((panelFeatureState.f16791a == 0 || panelFeatureState.f16791a == 108) && this.f16773s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.mo25545a((MenuBuilder.C3159a) this);
        panelFeatureState.mo25235a(menuBuilder);
        return true;
    }

    /* renamed from: c */
    private boolean m18377c(PanelFeatureState panelFeatureState) {
        MenuBuilder menuBuilder = new MenuBuilder(this.f16727a);
        menuBuilder.mo25545a(this.f16766N);
        panelFeatureState.mo25237b(menuBuilder);
        return true;
    }

    /* renamed from: d */
    private boolean m18380d(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f16799i != null) {
            panelFeatureState.f16798h = panelFeatureState.f16799i;
            return true;
        } else if (panelFeatureState.f16800j == null) {
            return false;
        } else {
            if (this.f16775u == null) {
                this.f16775u = new C3107c();
            }
            panelFeatureState.f16798h = (View) panelFeatureState.mo25233a((MenuPresenter.C3167a) this.f16775u);
            if (panelFeatureState.f16798h != null) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: b */
    private boolean m18373b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (mo25210o()) {
            return false;
        }
        if (panelFeatureState.f16803m) {
            return true;
        }
        if (!(this.f16756D == null || this.f16756D == panelFeatureState)) {
            m18357a(this.f16756D, false);
        }
        Window.Callback p = mo25211p();
        if (p != null) {
            panelFeatureState.f16799i = p.onCreatePanelView(panelFeatureState.f16791a);
        }
        boolean z = panelFeatureState.f16791a == 0 || panelFeatureState.f16791a == 108;
        if (z && this.f16773s != null) {
            this.f16773s.setMenuPrepared();
        }
        if (panelFeatureState.f16799i == null && (!z || !(mo25207l() instanceof ToolbarActionBar))) {
            if (panelFeatureState.f16800j == null || panelFeatureState.f16808r) {
                if (panelFeatureState.f16800j == null && (!m18372b(panelFeatureState) || panelFeatureState.f16800j == null)) {
                    return false;
                }
                if (z && this.f16773s != null) {
                    if (this.f16774t == null) {
                        this.f16774t = new C3105a();
                    }
                    this.f16773s.setMenu(panelFeatureState.f16800j, this.f16774t);
                }
                panelFeatureState.f16800j.mo25581g();
                if (!p.onCreatePanelMenu(panelFeatureState.f16791a, panelFeatureState.f16800j)) {
                    panelFeatureState.mo25235a((MenuBuilder) null);
                    if (z && this.f16773s != null) {
                        this.f16773s.setMenu((Menu) null, this.f16774t);
                    }
                    return false;
                }
                panelFeatureState.f16808r = false;
            }
            if (this.f16731e != null) {
                this.f16731e.mo25160b((FMenu) panelFeatureState.f16800j);
            }
            panelFeatureState.f16800j.mo25581g();
            if (panelFeatureState.f16809s != null) {
                panelFeatureState.f16800j.mo25564b(panelFeatureState.f16809s);
                panelFeatureState.f16809s = null;
            }
            if (!p.onPreparePanel(0, panelFeatureState.f16799i, panelFeatureState.f16800j)) {
                if (z && this.f16773s != null) {
                    this.f16773s.setMenu((Menu) null, this.f16774t);
                }
                panelFeatureState.f16800j.mo25583h();
                return false;
            }
            panelFeatureState.f16806p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f16800j.setQwertyMode(panelFeatureState.f16806p);
            panelFeatureState.f16800j.mo25583h();
            m18382e(panelFeatureState);
        }
        panelFeatureState.f16803m = true;
        panelFeatureState.f16804n = false;
        this.f16756D = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18371b(MenuBuilder menuBuilder) {
        if (!this.f16754B) {
            this.f16754B = true;
            this.f16773s.mo25906i();
            Window.Callback p = mo25211p();
            if (p != null && !mo25210o()) {
                p.onPanelClosed(108, menuBuilder);
            }
            this.f16754B = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void mo25215e(int i) {
        m18357a(m18352a(i, true), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18357a(PanelFeatureState panelFeatureState, boolean z) {
        if (!z || panelFeatureState.f16791a != 0 || this.f16773s == null || !this.f16773s.mo25896e()) {
            WindowManager windowManager = (WindowManager) this.f16727a.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f16805o || panelFeatureState.f16797g == null)) {
                if (panelFeatureState.f16797g.getParent() != null) {
                    windowManager.removeView(panelFeatureState.f16797g);
                }
                if (z) {
                    m18355a(panelFeatureState.f16791a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f16803m = false;
            panelFeatureState.f16804n = false;
            panelFeatureState.f16805o = false;
            panelFeatureState.f16798h = null;
            panelFeatureState.f16807q = true;
            if (this.f16756D == panelFeatureState) {
                this.f16756D = null;
                return;
            }
            return;
        }
        m18371b(panelFeatureState.f16800j);
    }

    /* renamed from: d */
    private boolean m18379d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a = m18352a(i, true);
        if (!a.f16805o) {
            return m18373b(a, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m18383e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            flyme.support.v7.view.b r0 = r3.f16768n
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            flyme.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState r2 = r3.m18352a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0047
            flyme.support.v7.widget.g r4 = r3.f16773s
            if (r4 == 0) goto L_0x0047
            flyme.support.v7.widget.g r4 = r3.f16773s
            boolean r4 = r4.mo25894d()
            if (r4 == 0) goto L_0x0047
            android.content.Context r4 = r3.f16727a
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = androidx.core.view.ViewConfigurationCompat.hasPermanentMenuKey(r4)
            if (r4 != 0) goto L_0x0047
            flyme.support.v7.widget.g r4 = r3.f16773s
            boolean r4 = r4.mo25896e()
            if (r4 != 0) goto L_0x0040
            boolean r4 = r3.mo25210o()
            if (r4 != 0) goto L_0x0067
            boolean r4 = r3.m18373b((flyme.support.p093v7.app.AppCompatDelegateImplV7.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0067
            flyme.support.v7.widget.g r4 = r3.f16773s
            boolean r4 = r4.mo25899g()
            goto L_0x006e
        L_0x0040:
            flyme.support.v7.widget.g r4 = r3.f16773s
            boolean r4 = r4.mo25905h()
            goto L_0x006e
        L_0x0047:
            boolean r4 = r2.f16805o
            if (r4 != 0) goto L_0x0069
            boolean r4 = r2.f16804n
            if (r4 == 0) goto L_0x0050
            goto L_0x0069
        L_0x0050:
            boolean r4 = r2.f16803m
            if (r4 == 0) goto L_0x0067
            boolean r4 = r2.f16808r
            if (r4 == 0) goto L_0x005f
            r2.f16803m = r1
            boolean r4 = r3.m18373b((flyme.support.p093v7.app.AppCompatDelegateImplV7.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x0060
        L_0x005f:
            r4 = 1
        L_0x0060:
            if (r4 == 0) goto L_0x0067
            r3.m18356a((flyme.support.p093v7.app.AppCompatDelegateImplV7.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            r4 = 1
            goto L_0x006e
        L_0x0067:
            r4 = 0
            goto L_0x006e
        L_0x0069:
            boolean r4 = r2.f16805o
            r3.m18357a((flyme.support.p093v7.app.AppCompatDelegateImplV7.PanelFeatureState) r2, (boolean) r0)
        L_0x006e:
            if (r4 == 0) goto L_0x0087
            android.content.Context r5 = r3.f16727a
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x0080
            r5.playSoundEffect(r1)
            goto L_0x0087
        L_0x0080:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0087:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.app.AppCompatDelegateImplV7.m18383e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18355a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f16755C.length) {
                panelFeatureState = this.f16755C[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f16800j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f16805o) && !mo25210o()) {
            this.f16729c.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PanelFeatureState m18353a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f16755C;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f16800j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* renamed from: a */
    private PanelFeatureState m18352a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f16755C;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f16755C = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* renamed from: a */
    private boolean m18366a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f16803m || m18373b(panelFeatureState, keyEvent)) && panelFeatureState.f16800j != null) {
            z = panelFeatureState.f16800j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f16773s == null) {
            m18357a(panelFeatureState, true);
        }
        return z;
    }

    /* renamed from: f */
    private void m18384f(int i) {
        this.f16759G = (1 << i) | this.f16759G;
        if (!this.f16758F) {
            ViewCompat.postOnAnimation(this.f16728b.getDecorView(), this.f16760H);
            this.f16758F = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18385g(int i) {
        PanelFeatureState a;
        PanelFeatureState a2 = m18352a(i, true);
        if (a2.f16800j != null) {
            Bundle bundle = new Bundle();
            a2.f16800j.mo25543a(bundle);
            if (bundle.size() > 0) {
                a2.f16809s = bundle;
            }
            a2.f16800j.mo25581g();
            a2.f16800j.clear();
        }
        a2.f16808r = true;
        a2.f16807q = true;
        if ((i == 108 || i == 0) && this.f16773s != null && (a = m18352a(0, false)) != null) {
            a.f16803m = false;
            m18373b(a, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public int m18386h(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = 0;
        if (this.f16769o == null || !(this.f16769o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16769o.getLayoutParams();
            z = true;
            if (this.f16769o.isShown()) {
                if (this.f16762J == null) {
                    this.f16762J = new Rect();
                    this.f16763K = new Rect();
                }
                Rect rect = this.f16762J;
                Rect rect2 = this.f16763K;
                rect.set(0, i, 0, 0);
                C3352x.m20914a(this.f16777w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f16779y == null) {
                        this.f16779y = new View(this.f16727a);
                        this.f16779y.setBackgroundColor(this.f16727a.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.f16777w.addView(this.f16779y, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f16779y.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f16779y.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f16779y == null) {
                    z = false;
                }
                if (!this.f16736j && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z = false;
            }
            if (z2) {
                this.f16769o.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f16779y != null) {
            View view = this.f16779y;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: w */
    private void m18392w() {
        if (this.f16776v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: i */
    private int m18387i(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m18393x() {
        if (this.f16773s != null) {
            this.f16773s.mo25906i();
        }
        if (this.f16770p != null) {
            this.f16728b.getDecorView().removeCallbacks(this.f16771q);
            if (this.f16770p.isShowing()) {
                try {
                    this.f16770p.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f16770p = null;
        }
        m18391v();
        PanelFeatureState a = m18352a(0, false);
        if (a != null && a.f16800j != null) {
            a.f16800j.close();
        }
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$b */
    class C3106b implements ActionMode.C3152b {

        /* renamed from: b */
        private ActionMode.C3152b f16816b;

        public C3106b(ActionMode.C3152b bVar) {
            this.f16816b = bVar;
        }

        /* renamed from: a */
        public boolean mo25245a(ActionMode bVar, Menu menu) {
            return this.f16816b.mo25245a(bVar, menu);
        }

        /* renamed from: b */
        public boolean mo25247b(ActionMode bVar, Menu menu) {
            return this.f16816b.mo25247b(bVar, menu);
        }

        /* renamed from: a */
        public boolean mo25246a(ActionMode bVar, MenuItem menuItem) {
            return this.f16816b.mo25246a(bVar, menuItem);
        }

        /* renamed from: a */
        public void mo25244a(ActionMode bVar) {
            this.f16816b.mo25244a(bVar);
            if (AppCompatDelegateImplV7.this.f16770p != null) {
                AppCompatDelegateImplV7.this.f16728b.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.f16771q);
            }
            if (AppCompatDelegateImplV7.this.f16769o != null) {
                AppCompatDelegateImplV7.this.m18391v();
                AppCompatDelegateImplV7.this.f16772r = ViewCompat.animate(AppCompatDelegateImplV7.this.f16769o).alpha(0.0f);
                AppCompatDelegateImplV7.this.f16772r.setListener(new AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1(this));
            }
            if (AppCompatDelegateImplV7.this.f16731e != null) {
                AppCompatDelegateImplV7.this.f16731e.mo25159b(AppCompatDelegateImplV7.this.f16768n);
            }
            AppCompatDelegateImplV7.this.f16768n = null;
        }
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$c */
    private final class C3107c implements MenuPresenter.C3167a {
        private C3107c() {
        }

        /* renamed from: a */
        public void mo25242a(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder p = menuBuilder.mo25593p();
            boolean z2 = p != menuBuilder;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                menuBuilder = p;
            }
            PanelFeatureState a = appCompatDelegateImplV7.m18353a((Menu) menuBuilder);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.m18355a(a.f16791a, a, (Menu) p);
                AppCompatDelegateImplV7.this.m18357a(a, true);
                return;
            }
            AppCompatDelegateImplV7.this.m18357a(a, z);
        }

        /* renamed from: a_ */
        public boolean mo25243a_(MenuBuilder menuBuilder) {
            Window.Callback p;
            if (menuBuilder != null || !AppCompatDelegateImplV7.this.f16734h || (p = AppCompatDelegateImplV7.this.mo25211p()) == null || AppCompatDelegateImplV7.this.mo25210o()) {
                return true;
            }
            p.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$a */
    private final class C3105a implements MenuPresenter.C3167a {
        private C3105a() {
        }

        /* renamed from: a_ */
        public boolean mo25243a_(MenuBuilder menuBuilder) {
            Window.Callback p = AppCompatDelegateImplV7.this.mo25211p();
            if (p == null) {
                return true;
            }
            p.onMenuOpened(108, menuBuilder);
            return true;
        }

        /* renamed from: a */
        public void mo25242a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV7.this.m18371b(menuBuilder);
        }
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState */
    private static final class PanelFeatureState {

        /* renamed from: a */
        int f16791a;

        /* renamed from: b */
        int f16792b;

        /* renamed from: c */
        int f16793c;

        /* renamed from: d */
        int f16794d;

        /* renamed from: e */
        int f16795e;

        /* renamed from: f */
        int f16796f;

        /* renamed from: g */
        ViewGroup f16797g;

        /* renamed from: h */
        View f16798h;

        /* renamed from: i */
        View f16799i;

        /* renamed from: j */
        MenuBuilder f16800j;

        /* renamed from: k */
        ListMenuPresenter f16801k;

        /* renamed from: l */
        Context f16802l;

        /* renamed from: m */
        boolean f16803m;

        /* renamed from: n */
        boolean f16804n;

        /* renamed from: o */
        boolean f16805o;

        /* renamed from: p */
        public boolean f16806p;

        /* renamed from: q */
        boolean f16807q = false;

        /* renamed from: r */
        boolean f16808r;

        /* renamed from: s */
        Bundle f16809s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public MenuBuilder f16810t;

        PanelFeatureState(int i) {
            this.f16791a = i;
        }

        /* renamed from: a */
        public boolean mo25236a() {
            if (this.f16798h == null) {
                return false;
            }
            if (this.f16799i == null && this.f16801k.mo25748a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25234a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f16802l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f16792b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f16796f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25235a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f16800j) {
                if (this.f16800j != null) {
                    this.f16800j.mo25566b((MenuPresenter) this.f16801k);
                }
                this.f16800j = menuBuilder;
                if (menuBuilder != null && this.f16801k != null) {
                    menuBuilder.mo25547a((MenuPresenter) this.f16801k);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo25237b(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f16810t) {
                MenuBuilder menuBuilder2 = this.f16810t;
                this.f16810t = menuBuilder;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public MenuView mo25233a(MenuPresenter.C3167a aVar) {
            if (this.f16800j == null) {
                return null;
            }
            if (this.f16801k == null) {
                this.f16801k = new ListMenuPresenter(this.f16802l, R.layout.mz_list_menu_item_layout);
                this.f16801k.mo25750a(aVar);
                this.f16800j.mo25547a((MenuPresenter) this.f16801k);
            }
            return this.f16801k.mo25749a(this.f16797g);
        }

        /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState */
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m18435b(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            });

            /* renamed from: a */
            int f16811a;

            /* renamed from: b */
            boolean f16812b;

            /* renamed from: c */
            Bundle f16813c;

            public int describeContents() {
                return 0;
            }

            private SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f16811a);
                parcel.writeInt(this.f16812b ? 1 : 0);
                if (this.f16812b) {
                    parcel.writeBundle(this.f16813c);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public static SavedState m18435b(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f16811a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f16812b = z;
                if (savedState.f16812b) {
                    savedState.f16813c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$ListMenuDecorView */
    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.mo25203a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m18427a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV7.this.mo25215e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(getContext(), i));
        }

        /* renamed from: a */
        private boolean m18427a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* renamed from: c */
    public ActionMode mo25224c(ActionMode.C3152b bVar) {
        if (bVar != null) {
            if (this.f16768n != null) {
                this.f16768n.mo25352c();
            }
            C3106b bVar2 = new C3106b(bVar);
            ActionBar a = mo25179a();
            if (a != null) {
                this.f16768n = a.mo25044b((ActionMode.C3152b) bVar2);
            }
            return this.f16768n;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: e */
    private void m18382e(PanelFeatureState panelFeatureState) {
        if (m18377c(panelFeatureState)) {
            if (this.f16773s != null) {
                if (this.f16774t == null) {
                    this.f16774t = new C3105a();
                }
                this.f16773s.setBottomMenu(panelFeatureState.f16810t, this.f16774t);
            }
            panelFeatureState.f16810t.mo25581g();
            if (!this.f16731e.mo25155a((FMenu) panelFeatureState.f16810t)) {
                panelFeatureState.mo25237b((MenuBuilder) null);
                if (this.f16773s != null) {
                    this.f16773s.setBottomMenu((Menu) null, this.f16774t);
                    return;
                }
                return;
            }
            panelFeatureState.f16810t.mo25583h();
        }
    }

    /* renamed from: a */
    private boolean m18364a(WindowManager.LayoutParams layoutParams, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            declaredField.setInt(layoutParams, z ? i | 64 : i & -65);
            return true;
        } catch (Exception e) {
            Log.e("AppCompatDelegate", "Can't set the status bar to be transparent, Caused by:" + e.getMessage());
            return false;
        }
    }
}
