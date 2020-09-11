package flyme.support.p093v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import flyme.support.p093v7.app.AppCompatDelegateImplBase;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.SupportActionModeWrapper;
import flyme.support.p093v7.widget.FitsWindowsContentLayout;
import java.lang.reflect.Field;

/* renamed from: flyme.support.v7.app.AppCompatDelegateImplV14 */
public class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {

    /* renamed from: s */
    private static TwilightManager f16744s;

    /* renamed from: t */
    private int f16745t = -100;

    /* renamed from: u */
    private boolean f16746u;

    /* renamed from: v */
    private boolean f16747v = true;

    /* renamed from: w */
    private FitsWindowsContentLayout.C3206a f16748w = new FitsWindowsContentLayout.C3206a() {
        /* renamed from: a */
        public ActionMode mo25216a(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.f16730d.onWindowStartingActionMode(callback);
        }

        @TargetApi(23)
        /* renamed from: a */
        public ActionMode mo25217a(ActionMode.Callback callback, int i) {
            return AppCompatDelegateImplV14.this.f16730d.onWindowStartingActionMode(callback, i);
        }
    };

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback aVar) {
        super(context, window, aVar);
    }

    /* renamed from: a */
    public void mo25181a(Bundle bundle) {
        super.mo25181a(bundle);
        if (bundle != null && this.f16745t == -100) {
            this.f16745t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo25199a(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }

    /* renamed from: n */
    public boolean mo25209n() {
        return this.f16747v;
    }

    /* renamed from: i */
    public boolean mo25198i() {
        this.f16746u = true;
        int e = mo25215e(this.f16745t == -100 ? m18290j() : this.f16745t);
        if (e != -1) {
            return m18337f(e);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo25215e(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        return m18338s().mo25327a() ? 2 : 1;
    }

    /* renamed from: c */
    public void mo25190c(Bundle bundle) {
        super.mo25190c(bundle);
        if (this.f16745t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f16745t);
        }
    }

    /* renamed from: f */
    private boolean m18337f(int i) {
        Resources resources = this.f16727a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        return true;
    }

    /* renamed from: s */
    private TwilightManager m18338s() {
        if (f16744s == null) {
            f16744s = new TwilightManager(this.f16727a.getApplicationContext());
        }
        return f16744s;
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV14$AppCompatWindowCallbackV14 */
    class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (AppCompatDelegateImplV14.this.mo25209n()) {
                return mo25218a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final ActionMode mo25218a(ActionMode.Callback callback) {
            SupportActionModeWrapper.C3155a aVar = new SupportActionModeWrapper.C3155a(AppCompatDelegateImplV14.this.f16727a, callback);
            flyme.support.p093v7.view.ActionMode c = AppCompatDelegateImplV14.this.m18335a(callback) ? AppCompatDelegateImplV14.this.mo25224c((ActionMode.C3152b) aVar) : null;
            if (c == null) {
                c = AppCompatDelegateImplV14.this.mo25222b((ActionMode.C3152b) aVar);
            }
            if (c != null) {
                return aVar.mo25451b(c);
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m18335a(ActionMode.Callback callback) {
        if (callback == null) {
            return false;
        }
        String name = callback.getClass().getName();
        if (name.equals("com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper") || name.equals("com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper")) {
            try {
                Field declaredField = callback.getClass().getDeclaredField("mWrapped");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(callback);
                if (obj != null) {
                    name = obj.getClass().getName();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (name.equals("android.widget.AbsListView$MultiChoiceModeWrapper") || name.equals("flyme.support.v7.widget.MzRecyclerView$MultiChoiceModeWrapper")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25214a(ViewGroup viewGroup) {
        super.mo25214a(viewGroup);
        View findViewById = viewGroup.findViewById(16908290);
        if (findViewById != null && (findViewById instanceof FitsWindowsContentLayout)) {
            ((FitsWindowsContentLayout) findViewById).setOnStartActionModeListener(this.f16748w);
        }
    }
}
