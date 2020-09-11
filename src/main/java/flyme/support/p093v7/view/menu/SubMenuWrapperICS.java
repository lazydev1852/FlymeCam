package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* renamed from: flyme.support.v7.view.menu.l */
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    /* renamed from: b */
    public SupportSubMenu mo25810b() {
        return (SupportSubMenu) this.f17326b;
    }

    public SubMenu setHeaderTitle(int i) {
        mo25810b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        mo25810b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        mo25810b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        mo25810b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        mo25810b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        mo25810b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        mo25810b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        mo25810b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return mo25743a(mo25810b().getItem());
    }
}
