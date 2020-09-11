package flyme.support.p093v7.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuPopupHelper;
import flyme.support.p093v7.view.menu.MenuPresenter;

/* renamed from: flyme.support.v7.widget.q */
public class PopupMenu implements MenuBuilder.C3159a, MenuPresenter.C3167a {

    /* renamed from: a */
    private Context f18556a;

    /* renamed from: b */
    private View f18557b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MenuPopupHelper f18558c;

    /* renamed from: d */
    private C3343b f18559d;

    /* renamed from: e */
    private C3342a f18560e;

    /* renamed from: flyme.support.v7.widget.q$a */
    /* compiled from: PopupMenu */
    public interface C3342a {
        /* renamed from: a */
        void mo27226a(PopupMenu qVar);
    }

    /* renamed from: flyme.support.v7.widget.q$b */
    /* compiled from: PopupMenu */
    public interface C3343b {
        /* renamed from: a */
        boolean mo27227a(MenuItem menuItem);
    }

    /* renamed from: a */
    public void mo25219a(MenuBuilder menuBuilder) {
    }

    /* renamed from: a */
    public void mo27224a() {
        this.f18558c.mo25764a();
    }

    /* renamed from: b */
    public void mo27225b() {
        this.f18558c.mo25771e();
    }

    /* renamed from: a */
    public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f18559d != null) {
            return this.f18559d.mo27227a(menuItem);
        }
        return false;
    }

    /* renamed from: a */
    public void mo25242a(MenuBuilder menuBuilder, boolean z) {
        if (this.f18560e != null) {
            this.f18560e.mo27226a(this);
        }
    }

    /* renamed from: a_ */
    public boolean mo25243a_(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        if (!menuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f18556a, menuBuilder, this.f18557b).mo25764a();
        return true;
    }
}
