package flyme.support.p093v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.widget.TintTypedArray;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.SupportMenuInflater;
import flyme.support.p093v7.view.menu.MenuBuilder;

/* renamed from: flyme.support.v7.app.AppCompatDelegateImplBase */
public abstract class AppCompatDelegateImplBase extends AppCompatDelegate {

    /* renamed from: a */
    final Context f16727a;

    /* renamed from: b */
    final Window f16728b;

    /* renamed from: c */
    final Window.Callback f16729c = this.f16728b.getCallback();

    /* renamed from: d */
    final Window.Callback f16730d;

    /* renamed from: e */
    final AppCompatCallback f16731e;

    /* renamed from: f */
    ActionBar f16732f;

    /* renamed from: g */
    MenuInflater f16733g;

    /* renamed from: h */
    boolean f16734h;

    /* renamed from: i */
    boolean f16735i;

    /* renamed from: j */
    boolean f16736j;

    /* renamed from: k */
    boolean f16737k;

    /* renamed from: l */
    boolean f16738l;

    /* renamed from: m */
    int f16739m;

    /* renamed from: n */
    private CharSequence f16740n;

    /* renamed from: o */
    private boolean f16741o;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract ActionMode mo25200a(ActionMode.C3152b bVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo25201a(int i, Menu menu);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo25202a(int i, KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo25203a(KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo25204b(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo25205b(int i, Menu menu);

    /* renamed from: c */
    public void mo25190c(Bundle bundle) {
    }

    /* renamed from: i */
    public boolean mo25198i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public abstract void mo25206k();

    /* renamed from: n */
    public boolean mo25209n() {
        return false;
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback aVar) {
        this.f16727a = context;
        this.f16728b = window;
        this.f16731e = aVar;
        if (!(this.f16729c instanceof AppCompatWindowCallbackBase)) {
            this.f16730d = mo25199a(this.f16729c);
            this.f16728b.setCallback(this.f16730d);
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo25199a(Window.Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    /* renamed from: a */
    public ActionBar mo25179a() {
        mo25206k();
        return this.f16732f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final ActionBar mo25207l() {
        return this.f16732f;
    }

    /* renamed from: b */
    public MenuInflater mo25185b() {
        if (this.f16733g == null) {
            mo25206k();
            this.f16733g = new SupportMenuInflater(this.f16732f != null ? this.f16732f.mo25043b() : this.f16727a);
        }
        return this.f16733g;
    }

    /* renamed from: g */
    public final ActionBarDrawerToggle.Delegate mo25196g() {
        return new ActionBarDrawableToggleImpl();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final Context mo25208m() {
        ActionBar a = mo25179a();
        Context b = a != null ? a.mo25043b() : null;
        return b == null ? this.f16727a : b;
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplBase$ActionBarDrawableToggleImpl */
    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        private ActionBarDrawableToggleImpl() {
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImplBase.this.mo25208m();
        }

        public boolean isNavigationVisible() {
            ActionBar a = AppCompatDelegateImplBase.this.mo25179a();
            return (a == null || (a.mo25034a() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar a = AppCompatDelegateImplBase.this.mo25179a();
            if (a != null) {
                a.mo25051c(drawable);
                a.mo25053d(i);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar a = AppCompatDelegateImplBase.this.mo25179a();
            if (a != null) {
                a.mo25053d(i);
            }
        }
    }

    /* renamed from: f */
    public void mo25195f() {
        this.f16741o = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final boolean mo25210o() {
        return this.f16741o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final Window.Callback mo25211p() {
        return this.f16728b.getCallback();
    }

    /* renamed from: a */
    public final void mo25184a(CharSequence charSequence) {
        this.f16740n = charSequence;
        mo25204b(charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final CharSequence mo25212q() {
        if (this.f16729c instanceof Activity) {
            return ((Activity) this.f16729c).getTitle();
        }
        return this.f16740n;
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplBase$AppCompatWindowCallbackBase */
    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        public void onContentChanged() {
        }

        AppCompatWindowCallbackBase(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplBase.this.mo25203a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImplBase.this.mo25202a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mo25570c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mo25570c(false);
            }
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImplBase.this.mo25205b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.mo25201a(i, menu);
        }
    }

    /* renamed from: d */
    public void mo25193d(int i) {
        this.f16739m = i;
    }
}
