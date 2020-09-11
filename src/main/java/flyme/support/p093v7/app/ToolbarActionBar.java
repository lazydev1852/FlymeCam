package flyme.support.p093v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.widget.DecorToolbar;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.app.c */
public class ToolbarActionBar extends ActionBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DecorToolbar f16964a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Window.Callback f16965b;

    /* renamed from: c */
    private boolean f16966c;

    /* renamed from: d */
    private boolean f16967d;

    /* renamed from: e */
    private ArrayList<ActionBar.C3075e> f16968e;

    /* renamed from: f */
    private final Runnable f16969f;

    /* renamed from: b */
    public void mo25046b(Drawable drawable) {
    }

    /* renamed from: b */
    public void mo25048b(boolean z) {
    }

    /* renamed from: d */
    public void mo25054d(boolean z) {
    }

    /* renamed from: e */
    public void mo25057e(boolean z) {
    }

    /* renamed from: flyme.support.v7.app.c$1 */
    /* compiled from: ToolbarActionBar */
    class C31341 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ToolbarActionBar f16970a;

        public void run() {
            this.f16970a.mo25324h();
        }
    }

    /* renamed from: a */
    public void mo25036a(float f) {
        ViewCompat.setElevation(this.f16964a.mo27113a(), f);
    }

    /* renamed from: b */
    public Context mo25043b() {
        return this.f16964a.mo27124b();
    }

    /* renamed from: c */
    public void mo25051c(Drawable drawable) {
        this.f16964a.mo27126b(drawable);
    }

    /* renamed from: c */
    public void mo25050c(int i) {
        this.f16964a.mo27134d(i);
    }

    /* renamed from: d */
    public void mo25053d(int i) {
        this.f16964a.mo27138e(i);
    }

    /* renamed from: a */
    public void mo25038a(Configuration configuration) {
        super.mo25038a(configuration);
    }

    /* renamed from: a */
    public void mo25040a(CharSequence charSequence) {
        this.f16964a.mo27128b(charSequence);
    }

    /* renamed from: a */
    public void mo25037a(int i) {
        this.f16964a.mo27128b(i != 0 ? this.f16964a.mo27124b().getText(i) : null);
    }

    /* renamed from: b */
    public void mo25047b(CharSequence charSequence) {
        this.f16964a.mo27122a(charSequence);
    }

    /* renamed from: b */
    public void mo25045b(int i) {
        mo25323a(i, -1);
    }

    /* renamed from: a */
    public void mo25323a(int i, int i2) {
        this.f16964a.mo27130c((i & i2) | ((~i2) & this.f16964a.mo27151q()));
    }

    /* renamed from: a */
    public void mo25041a(boolean z) {
        mo25323a(z ? 4 : 0, 4);
    }

    /* renamed from: a */
    public void mo25039a(@Nullable Drawable drawable) {
        this.f16964a.mo27131c(drawable);
    }

    /* renamed from: a */
    public int mo25034a() {
        return this.f16964a.mo27151q();
    }

    /* renamed from: d */
    public boolean mo25055d() {
        this.f16964a.mo27113a().removeCallbacks(this.f16969f);
        ViewCompat.postOnAnimation(this.f16964a.mo27113a(), this.f16969f);
        return true;
    }

    /* renamed from: e */
    public boolean mo25058e() {
        if (!this.f16964a.mo27136d()) {
            return false;
        }
        this.f16964a.mo27137e();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo25324h() {
        Menu i = m18568i();
        MenuBuilder menuBuilder = i instanceof MenuBuilder ? (MenuBuilder) i : null;
        if (menuBuilder != null) {
            menuBuilder.mo25581g();
        }
        try {
            i.clear();
            if (!this.f16965b.onCreatePanelMenu(0, i) || !this.f16965b.onPreparePanel(0, (View) null, i)) {
                i.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.mo25583h();
            }
        }
    }

    /* renamed from: a */
    public boolean mo25042a(int i, KeyEvent keyEvent) {
        Menu i2 = m18568i();
        if (i2 != null) {
            i2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            i2.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo25059f() {
        this.f16964a.mo27113a().removeCallbacks(this.f16969f);
    }

    /* renamed from: f */
    public void mo25060f(boolean z) {
        if (z != this.f16967d) {
            this.f16967d = z;
            int size = this.f16968e.size();
            for (int i = 0; i < size; i++) {
                this.f16968e.get(i).mo25067a(z);
            }
        }
    }

    /* renamed from: i */
    private Menu m18568i() {
        if (!this.f16966c) {
            this.f16964a.mo27120a((MenuPresenter.C3167a) new C3135a(this, (C31341) null), (MenuBuilder.C3159a) new C3136b(this, (C31341) null));
            this.f16966c = true;
        }
        return this.f16964a.mo27153s();
    }

    /* renamed from: flyme.support.v7.app.c$a */
    /* compiled from: ToolbarActionBar */
    private final class C3135a implements MenuPresenter.C3167a {

        /* renamed from: b */
        private boolean f16972b;

        private C3135a() {
        }

        /* synthetic */ C3135a(ToolbarActionBar cVar, C31341 r2) {
            this();
        }

        /* renamed from: a_ */
        public boolean mo25243a_(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f16965b == null) {
                return false;
            }
            ToolbarActionBar.this.f16965b.onMenuOpened(108, menuBuilder);
            return true;
        }

        /* renamed from: a */
        public void mo25242a(MenuBuilder menuBuilder, boolean z) {
            if (!this.f16972b) {
                this.f16972b = true;
                ToolbarActionBar.this.f16964a.mo27150p();
                if (ToolbarActionBar.this.f16965b != null) {
                    ToolbarActionBar.this.f16965b.onPanelClosed(108, menuBuilder);
                }
                this.f16972b = false;
            }
        }
    }

    /* renamed from: flyme.support.v7.app.c$b */
    /* compiled from: ToolbarActionBar */
    private final class C3136b implements MenuBuilder.C3159a {
        /* renamed from: a */
        public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        private C3136b() {
        }

        /* synthetic */ C3136b(ToolbarActionBar cVar, C31341 r2) {
            this();
        }

        /* renamed from: a */
        public void mo25219a(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f16965b == null) {
                return;
            }
            if (ToolbarActionBar.this.f16964a.mo27145k()) {
                ToolbarActionBar.this.f16965b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f16965b.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.f16965b.onMenuOpened(108, menuBuilder);
            }
        }
    }
}
