package flyme.support.p093v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.SupportMenuInflater;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.widget.ActionBarContainer;
import flyme.support.p093v7.widget.ActionBarContextView;
import flyme.support.p093v7.widget.ActionBarOverlayLayout;
import flyme.support.p093v7.widget.DecorToolbar;
import flyme.support.p093v7.widget.MzActionBarTabContainer;
import flyme.support.p093v7.widget.ScrollingTabContainerView;
import flyme.support.p093v7.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.app.f */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.C3178a {

    /* renamed from: j */
    static final /* synthetic */ boolean f16987j = (!WindowDecorActionBar.class.desiredAssertionStatus());

    /* renamed from: k */
    private static final Interpolator f16988k = new AccelerateInterpolator();

    /* renamed from: l */
    private static final Interpolator f16989l = new DecelerateInterpolator();

    /* renamed from: m */
    private static final boolean f16990m;

    /* renamed from: A */
    private boolean f16991A;

    /* renamed from: B */
    private boolean f16992B;

    /* renamed from: C */
    private ArrayList<ActionBar.C3075e> f16993C = new ArrayList<>();

    /* renamed from: D */
    private boolean f16994D;

    /* renamed from: E */
    private int f16995E = 0;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f16996F = true;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f16997G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f16998H;

    /* renamed from: I */
    private boolean f16999I;

    /* renamed from: J */
    private boolean f17000J = true;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public ViewPropertyAnimatorCompatSet f17001K;

    /* renamed from: L */
    private boolean f17002L;

    /* renamed from: M */
    private boolean f17003M;

    /* renamed from: N */
    private boolean f17004N = true;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f17005O;

    /* renamed from: P */
    private int f17006P = 288;

    /* renamed from: Q */
    private boolean f17007Q = false;

    /* renamed from: R */
    private boolean f17008R = false;

    /* renamed from: S */
    private int f17009S = -1;

    /* renamed from: T */
    private int f17010T = -1;

    /* renamed from: U */
    private int f17011U = -1;

    /* renamed from: a */
    C3139a f17012a;

    /* renamed from: b */
    ActionMode f17013b;

    /* renamed from: c */
    ActionMode.C3152b f17014c;

    /* renamed from: d */
    boolean f17015d;

    /* renamed from: e */
    final ViewPropertyAnimatorListener f17016e = new WindowDecorActionBar$1(this);

    /* renamed from: f */
    final ViewPropertyAnimatorListener f17017f = new WindowDecorActionBar$2(this);

    /* renamed from: g */
    final ViewPropertyAnimatorListener f17018g = new WindowDecorActionBar$3(this);

    /* renamed from: h */
    final ViewPropertyAnimatorListener f17019h = new WindowDecorActionBar$4(this);

    /* renamed from: i */
    final ViewPropertyAnimatorUpdateListener f17020i = new WindowDecorActionBar$5(this);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Context f17021n;

    /* renamed from: o */
    private Context f17022o;

    /* renamed from: p */
    private Activity f17023p;

    /* renamed from: q */
    private Dialog f17024q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ActionBarOverlayLayout f17025r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ActionBarContainer f17026s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public DecorToolbar f17027t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ActionBarContextView f17028u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ActionBarContainer f17029v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public View f17030w;

    /* renamed from: x */
    private ScrollingTabContainerView f17031x;

    /* renamed from: y */
    private ArrayList<Object> f17032y = new ArrayList<>();

    /* renamed from: z */
    private int f17033z = -1;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m18611b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: o */
    public void mo25342o() {
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        f16990m = z;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f17023p = activity;
        View decorView = activity.getWindow().getDecorView();
        m18606a(decorView);
        if (!z) {
            this.f17030w = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f17024q = dialog;
        m18606a(dialog.getWindow().getDecorView());
    }

    /* renamed from: a */
    private void m18606a(View view) {
        this.f17025r = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.f17025r != null) {
            this.f17025r.setActionBarVisibilityCallback(this);
        }
        this.f17027t = m18609b(view.findViewById(R.id.action_bar));
        this.f17028u = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.f17026s = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f17029v = (ActionBarContainer) view.findViewById(R.id.split_action_bar);
        if (this.f17027t == null || this.f17028u == null || this.f17026s == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f17021n = this.f17027t.mo27124b();
        int q = this.f17027t.mo27151q();
        boolean z = (q & 4) != 0;
        if (z) {
            this.f16991A = true;
        }
        ActionBarPolicy a = ActionBarPolicy.m18758a(this.f17021n);
        mo25048b(a.mo25417f() || z);
        this.f17003M = (q & 32) != 0;
        m18620k((this.f17004N && a.mo25415d()) || this.f17003M);
        TypedArray obtainStyledAttributes = this.f17021n.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, CommonUtils.m5121b() ? R.attr.mzActionBarStyleFullScreen : R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            mo25052c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo25036a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.f17005O = mo25340m();
    }

    /* renamed from: b */
    private DecorToolbar m18609b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* renamed from: a */
    public void mo25036a(float f) {
        ViewCompat.setElevation(this.f17026s, f);
        if (this.f17029v != null) {
            ViewCompat.setElevation(this.f17029v, f);
        }
    }

    /* renamed from: a */
    public void mo25038a(Configuration configuration) {
        m18620k((this.f17004N && ActionBarPolicy.m18758a(this.f17021n).mo25415d()) || this.f17003M);
    }

    /* renamed from: k */
    private void m18620k(boolean z) {
        this.f16994D = z;
        if (!this.f16994D) {
            this.f17027t.mo27121a((ScrollingTabContainerView) null);
            this.f17026s.setTabContainer(this.f17031x);
        } else {
            this.f17026s.setTabContainer((ScrollingTabContainerView) null);
            this.f17027t.mo27121a(this.f17031x);
        }
        boolean z2 = true;
        boolean z3 = mo25334i() == 2;
        MzActionBarTabContainer g = mo25061g();
        if (g != null) {
            if (z3) {
                g.setVisibility(0);
                if (this.f17025r != null) {
                    ViewCompat.requestApplyInsets(this.f17025r);
                }
            } else {
                g.setVisibility(8);
            }
        }
        this.f17027t.mo27132c(!this.f16994D && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f17025r;
        if (this.f16994D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo25332h() {
        if (this.f17014c != null) {
            this.f17014c.mo25244a(this.f17013b);
            this.f17013b = null;
            this.f17014c = null;
        }
    }

    /* renamed from: f */
    public void mo25330f(int i) {
        this.f16995E = i;
    }

    /* renamed from: e */
    public void mo25057e(boolean z) {
        this.f17002L = z;
        if (!z && this.f17001K != null) {
            this.f17001K.cancel();
        }
    }

    /* renamed from: f */
    public void mo25060f(boolean z) {
        if (z != this.f16992B) {
            this.f16992B = z;
            int size = this.f16993C.size();
            for (int i = 0; i < size; i++) {
                this.f16993C.get(i).mo25067a(z);
            }
        }
    }

    /* renamed from: a */
    public void mo25041a(boolean z) {
        mo25328a(z ? 4 : 0, 4);
    }

    /* renamed from: b */
    public void mo25048b(boolean z) {
        this.f17027t.mo27135d(z);
    }

    /* renamed from: a */
    public void mo25037a(int i) {
        mo25040a((CharSequence) this.f17021n.getString(i));
    }

    /* renamed from: a */
    public void mo25040a(CharSequence charSequence) {
        this.f17027t.mo27128b(charSequence);
    }

    /* renamed from: b */
    public void mo25047b(CharSequence charSequence) {
        this.f17027t.mo27122a(charSequence);
    }

    /* renamed from: b */
    public void mo25045b(int i) {
        if ((i & 4) != 0) {
            this.f16991A = true;
        }
        this.f17027t.mo27130c(i);
    }

    /* renamed from: a */
    public void mo25328a(int i, int i2) {
        int q = this.f17027t.mo27151q();
        if ((i2 & 4) != 0) {
            this.f16991A = true;
        }
        this.f17027t.mo27130c((i & i2) | ((~i2) & q));
    }

    /* renamed from: a */
    public void mo25039a(Drawable drawable) {
        this.f17026s.setPrimaryBackground(drawable);
    }

    /* renamed from: b */
    public void mo25046b(Drawable drawable) {
        if (this.f17029v != null) {
            this.f17029v.setSplitBackground(drawable);
        }
    }

    /* renamed from: i */
    public int mo25334i() {
        return this.f17027t.mo27152r();
    }

    /* renamed from: a */
    public int mo25034a() {
        return this.f17027t.mo27151q();
    }

    /* renamed from: a */
    public ActionMode mo25035a(ActionMode.C3152b bVar) {
        if (this.f17012a != null) {
            this.f17012a.mo25352c();
        }
        this.f17025r.setHideOnContentScrollEnabled(false);
        this.f17028u.mo25856c();
        C3139a aVar = new C3139a(this.f17028u.getContext(), bVar);
        if (!aVar.mo25354e()) {
            return null;
        }
        aVar.mo25353d();
        this.f17028u.mo25852a((ActionMode) aVar);
        mo25337j(true);
        if (!(this.f17029v == null || this.f17029v.getVisibility() == 0)) {
            this.f17029v.setVisibility(0);
            if (this.f17025r != null) {
                ViewCompat.requestApplyInsets(this.f17025r);
            }
        }
        this.f17028u.sendAccessibilityEvent(32);
        this.f17012a = aVar;
        return aVar;
    }

    /* renamed from: j */
    public int mo25336j() {
        return this.f17026s.getHeight();
    }

    /* renamed from: g */
    public void mo25331g(boolean z) {
        this.f16996F = z;
    }

    /* renamed from: p */
    private void m18622p() {
        if (!this.f16999I) {
            this.f16999I = true;
            if (this.f17025r != null) {
                this.f17025r.setShowingForActionMode(true);
            }
            m18621l(false);
        }
    }

    /* renamed from: k */
    public void mo25338k() {
        if (this.f16998H) {
            this.f16998H = false;
            m18621l(true);
        }
    }

    /* renamed from: q */
    private void m18623q() {
        if (this.f16999I) {
            this.f16999I = false;
            if (this.f17025r != null) {
                this.f17025r.setShowingForActionMode(false);
            }
            m18621l(false);
        }
    }

    /* renamed from: l */
    public void mo25339l() {
        if (!this.f16998H) {
            this.f16998H = true;
            m18621l(true);
        }
    }

    /* renamed from: c */
    public void mo25052c(boolean z) {
        if (!z || this.f17025r.mo25889a()) {
            this.f17015d = z;
            this.f17025r.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: c */
    public int mo25049c() {
        return this.f17025r.getActionBarHideOffset();
    }

    /* renamed from: l */
    private void m18621l(boolean z) {
        if (m18611b(this.f16997G, this.f16998H, this.f16999I)) {
            if (!this.f17000J) {
                this.f17000J = true;
                mo25333h(z);
            }
        } else if (this.f17000J) {
            this.f17000J = false;
            mo25335i(z);
        }
    }

    /* renamed from: h */
    public void mo25333h(boolean z) {
        if (this.f17001K != null) {
            this.f17001K.cancel();
        }
        this.f17026s.setVisibility(0);
        if (this.f16995E != 0 || !f16990m || (!this.f17002L && !z)) {
            ViewCompat.setAlpha(this.f17026s, 1.0f);
            ViewCompat.setTranslationY(this.f17026s, 0.0f);
            if (this.f16996F && this.f17030w != null) {
                ViewCompat.setTranslationY(this.f17030w, 0.0f);
            }
            if (this.f17029v != null) {
                ViewCompat.setAlpha(this.f17029v, 1.0f);
                ViewCompat.setTranslationY(this.f17029v, 0.0f);
                this.f17029v.setVisibility(0);
            }
            this.f17019h.onAnimationEnd((View) null);
        } else {
            ViewCompat.setTranslationY(this.f17026s, 0.0f);
            float f = (float) (-this.f17026s.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f17026s.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.setTranslationY(this.f17026s, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f17026s).translationY(0.0f);
            translationY.setUpdateListener(this.f17020i);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.f16996F && this.f17030w != null) {
                ViewCompat.setTranslationY(this.f17030w, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f17030w).translationY(0.0f));
            }
            if (this.f17029v != null && !this.f17005O) {
                this.f17029v.setVisibility(0);
                ViewCompat.setTranslationY(this.f17029v, (float) this.f17029v.getMeasuredHeight());
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f17029v).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.5f, 0.05f, 1.0f));
            viewPropertyAnimatorCompatSet.setDuration((long) this.f17006P);
            viewPropertyAnimatorCompatSet.setListener(this.f17019h);
            this.f17001K = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        }
        if (this.f17025r != null) {
            ViewCompat.requestApplyInsets(this.f17025r);
        }
    }

    /* renamed from: i */
    public void mo25335i(boolean z) {
        if (this.f17001K != null) {
            this.f17001K.cancel();
        }
        if (this.f16995E != 0 || !f16990m || (!this.f17002L && !z)) {
            this.f17018g.onAnimationEnd((View) null);
            return;
        }
        ViewCompat.setAlpha(this.f17026s, 1.0f);
        this.f17026s.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        float f = (float) (-this.f17026s.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f17026s.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f17026s).translationY(f);
        translationY.setUpdateListener(this.f17020i);
        viewPropertyAnimatorCompatSet.play(translationY);
        if (this.f16996F && this.f17030w != null) {
            viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f17030w).translationY(f));
        }
        if (this.f17029v != null && this.f17029v.getVisibility() == 0 && this.f17005O) {
            ViewCompat.setAlpha(this.f17029v, 1.0f);
            viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f17029v).translationY((float) this.f17029v.getHeight()));
        }
        viewPropertyAnimatorCompatSet.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.5f, 0.16f, 1.0f));
        viewPropertyAnimatorCompatSet.setDuration((long) this.f17006P);
        viewPropertyAnimatorCompatSet.setListener(this.f17018g);
        this.f17001K = viewPropertyAnimatorCompatSet;
        viewPropertyAnimatorCompatSet.start();
    }

    /* renamed from: m */
    public boolean mo25340m() {
        int j = mo25336j();
        return this.f17000J && (j == 0 || mo25049c() < j);
    }

    /* renamed from: j */
    public void mo25337j(boolean z) {
        mo25329a(z, (C3139a) null);
    }

    /* renamed from: b */
    public Context mo25043b() {
        if (this.f17022o == null) {
            TypedValue typedValue = new TypedValue();
            this.f17021n.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f17022o = new ContextThemeWrapper(this.f17021n, i);
            } else {
                this.f17022o = this.f17021n;
            }
        }
        return this.f17022o;
    }

    /* renamed from: c */
    public void mo25051c(Drawable drawable) {
        this.f17027t.mo27126b(drawable);
    }

    /* renamed from: c */
    public void mo25050c(int i) {
        this.f17027t.mo27134d(i);
    }

    /* renamed from: d */
    public void mo25053d(int i) {
        this.f17027t.mo27138e(i);
    }

    /* renamed from: n */
    public void mo25341n() {
        if (this.f17001K != null) {
            this.f17001K.cancel();
            this.f17001K = null;
        }
    }

    /* renamed from: e */
    public boolean mo25058e() {
        if (this.f17027t == null || !this.f17027t.mo27136d()) {
            return false;
        }
        this.f17027t.mo27137e();
        return true;
    }

    /* renamed from: flyme.support.v7.app.f$a */
    /* compiled from: WindowDecorActionBar */
    public class C3139a extends ActionMode implements MenuBuilder.C3159a {

        /* renamed from: b */
        private final Context f17035b;

        /* renamed from: c */
        private final MenuBuilder f17036c;

        /* renamed from: d */
        private ActionMode.C3152b f17037d;

        /* renamed from: e */
        private WeakReference<View> f17038e;

        /* renamed from: f */
        private ActionMode.C3151a f17039f = new ActionMode.C3151a() {
            /* renamed from: a */
            public boolean mo25360a() {
                return true;
            }
        };

        /* renamed from: g */
        private boolean f17040g;

        /* renamed from: h */
        private boolean f17041h = true;

        public C3139a(Context context, ActionMode.C3152b bVar) {
            this.f17035b = context;
            this.f17037d = bVar;
            this.f17036c = new MenuBuilder(context).mo25537a(1);
            this.f17036c.mo25545a((MenuBuilder.C3159a) this);
            mo25421a(this.f17039f);
        }

        /* renamed from: a */
        public MenuInflater mo25343a() {
            return new SupportMenuInflater(this.f17035b);
        }

        /* renamed from: b */
        public Menu mo25348b() {
            return this.f17036c;
        }

        /* renamed from: c */
        public void mo25352c() {
            if (WindowDecorActionBar.this.f17012a == this) {
                if (WindowDecorActionBar.m18611b(WindowDecorActionBar.this.f16997G, WindowDecorActionBar.this.f16998H, false) || !mo25359j()) {
                    this.f17037d.mo25244a(this);
                } else {
                    WindowDecorActionBar.this.f17013b = this;
                    WindowDecorActionBar.this.f17014c = this.f17037d;
                }
                this.f17037d = null;
                WindowDecorActionBar.this.mo25337j(false);
                WindowDecorActionBar.this.f17028u.mo25854b();
                WindowDecorActionBar.this.f17027t.mo27113a().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.f17025r.setHideOnContentScrollEnabled(WindowDecorActionBar.this.f17015d);
                WindowDecorActionBar.this.f17012a = null;
            }
        }

        /* renamed from: d */
        public void mo25353d() {
            if (WindowDecorActionBar.this.f17012a == this) {
                this.f17036c.mo25581g();
                try {
                    this.f17037d.mo25247b(this, this.f17036c);
                } finally {
                    this.f17036c.mo25583h();
                }
            }
        }

        /* renamed from: e */
        public boolean mo25354e() {
            this.f17036c.mo25581g();
            try {
                return this.f17037d.mo25245a((ActionMode) this, (Menu) this.f17036c);
            } finally {
                this.f17036c.mo25583h();
            }
        }

        /* renamed from: a */
        public void mo25345a(View view) {
            WindowDecorActionBar.this.f17028u.setCustomView(view);
            this.f17038e = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo25346a(CharSequence charSequence) {
            WindowDecorActionBar.this.f17028u.setSubtitle(charSequence);
        }

        /* renamed from: b */
        public void mo25350b(CharSequence charSequence) {
            WindowDecorActionBar.this.f17028u.setTitle(charSequence);
        }

        /* renamed from: a */
        public void mo25344a(int i) {
            mo25350b((CharSequence) WindowDecorActionBar.this.f17021n.getResources().getString(i));
        }

        /* renamed from: b */
        public void mo25349b(int i) {
            mo25346a((CharSequence) WindowDecorActionBar.this.f17021n.getResources().getString(i));
        }

        /* renamed from: f */
        public CharSequence mo25355f() {
            return WindowDecorActionBar.this.f17028u.getTitle();
        }

        /* renamed from: g */
        public CharSequence mo25356g() {
            return WindowDecorActionBar.this.f17028u.getSubtitle();
        }

        /* renamed from: a */
        public void mo25347a(boolean z) {
            super.mo25347a(z);
            WindowDecorActionBar.this.f17028u.setTitleOptional(z);
        }

        /* renamed from: h */
        public boolean mo25357h() {
            return WindowDecorActionBar.this.f17028u.mo25857d();
        }

        /* renamed from: i */
        public View mo25358i() {
            if (this.f17038e != null) {
                return (View) this.f17038e.get();
            }
            return null;
        }

        /* renamed from: a */
        public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f17037d != null) {
                return this.f17037d.mo25246a((ActionMode) this, menuItem);
            }
            return false;
        }

        /* renamed from: a */
        public void mo25219a(MenuBuilder menuBuilder) {
            if (this.f17037d != null) {
                mo25353d();
                WindowDecorActionBar.this.f17028u.mo25823a();
            }
        }

        /* renamed from: b */
        public void mo25351b(boolean z) {
            this.f17040g = z;
        }

        /* renamed from: j */
        public boolean mo25359j() {
            return this.f17041h;
        }
    }

    /* renamed from: d */
    public void mo25054d(boolean z) {
        if (!this.f16991A) {
            mo25041a(z);
        }
    }

    /* renamed from: b */
    public ActionMode mo25044b(ActionMode.C3152b bVar) {
        if (this.f17012a != null) {
            this.f17012a.mo25352c();
        }
        this.f17025r.setHideOnContentScrollEnabled(false);
        this.f17028u.mo25856c();
        C3139a aVar = new C3139a(this.f17028u.getContext(), bVar);
        if (!aVar.mo25354e()) {
            return null;
        }
        aVar.mo25353d();
        this.f17028u.setSplitView(this.f17029v);
        this.f17028u.mo25855b(aVar);
        mo25329a(true, aVar);
        if (!(this.f17029v == null || this.f17029v.getVisibility() == 0)) {
            this.f17029v.setVisibility(0);
            if (this.f17025r != null) {
                ViewCompat.requestApplyInsets(this.f17025r);
            }
        }
        this.f17028u.sendAccessibilityEvent(32);
        aVar.mo25351b(true);
        this.f17012a = aVar;
        return aVar;
    }

    /* renamed from: g */
    public MzActionBarTabContainer mo25061g() {
        if (!this.f16994D) {
            return this.f17026s.getTabContainer();
        }
        return this.f17027t.mo27154t();
    }

    /* renamed from: e */
    public void mo25056e(int i) {
        this.f17025r.setUiOptions(i);
    }

    /* renamed from: a */
    public void mo25329a(boolean z, C3139a aVar) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (aVar != null ? aVar.mo25359j() : z) {
            m18622p();
        } else {
            m18623q();
        }
        if (z) {
            viewPropertyAnimatorCompat = this.f17027t.mo27114a(4, 100);
        } else {
            viewPropertyAnimatorCompat = this.f17027t.mo27114a(0, 200);
        }
        viewPropertyAnimatorCompat.start();
        this.f17028u.mo25853a(z, aVar);
    }
}
