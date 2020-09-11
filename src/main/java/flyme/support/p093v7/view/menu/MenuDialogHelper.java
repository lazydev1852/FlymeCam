package flyme.support.p093v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import flyme.support.p093v7.app.AlertDialog;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuPresenter;

/* renamed from: flyme.support.v7.view.menu.f */
public class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.C3167a {

    /* renamed from: a */
    ListMenuPresenter f17338a;

    /* renamed from: b */
    private MenuBuilder f17339b;

    /* renamed from: c */
    private AlertDialog f17340c;

    /* renamed from: d */
    private MenuPresenter.C3167a f17341d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f17339b = menuBuilder;
    }

    /* renamed from: a */
    public void mo25760a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f17339b;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.mo25578e());
        this.f17338a = new ListMenuPresenter(builder.mo25123a(), R.layout.mz_list_menu_item_layout);
        this.f17338a.mo25750a((MenuPresenter.C3167a) this);
        this.f17339b.mo25547a((MenuPresenter) this.f17338a);
        builder.mo25130a(this.f17338a.mo25748a(), (DialogInterface.OnClickListener) this);
        View o = menuBuilder.mo25592o();
        if (o != null) {
            builder.mo25129a(o);
        } else {
            builder.mo25128a(menuBuilder.mo25591n()).mo25131a(menuBuilder.mo25590m());
        }
        builder.mo25127a((DialogInterface.OnKeyListener) this);
        this.f17340c = builder.mo25141b();
        this.f17340c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f17340c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f17340c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f17340c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f17340c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f17339b.mo25550a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f17339b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void mo25759a() {
        if (this.f17340c != null) {
            this.f17340c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f17338a.mo25731a(this.f17339b, true);
    }

    /* renamed from: a */
    public void mo25242a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f17339b) {
            mo25759a();
        }
        if (this.f17341d != null) {
            this.f17341d.mo25242a(menuBuilder, z);
        }
    }

    /* renamed from: a_ */
    public boolean mo25243a_(MenuBuilder menuBuilder) {
        if (this.f17341d != null) {
            return this.f17341d.mo25243a_(menuBuilder);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17339b.mo25551a((MenuItem) (MenuItemImpl) this.f17338a.mo25748a().getItem(i), 0);
    }
}
