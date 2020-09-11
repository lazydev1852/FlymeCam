package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.p020ar.util.SystemInfoUtil;
import flyme.support.p093v7.view.menu.MenuBuilder;

/* renamed from: flyme.support.v7.view.menu.SubMenuBuilder */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: d */
    private MenuBuilder f17311d;

    /* renamed from: e */
    private MenuItemImpl f17312e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f17311d = menuBuilder;
        this.f17312e = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f17311d.setQwertyMode(z);
    }

    /* renamed from: b */
    public boolean mo25568b() {
        return this.f17311d.mo25568b();
    }

    /* renamed from: c */
    public boolean mo25571c() {
        return this.f17311d.mo25571c();
    }

    /* renamed from: s */
    public Menu mo25717s() {
        return this.f17311d;
    }

    public MenuItem getItem() {
        return this.f17312e;
    }

    /* renamed from: a */
    public void mo25545a(MenuBuilder.C3159a aVar) {
        this.f17311d.mo25545a(aVar);
    }

    /* renamed from: p */
    public MenuBuilder mo25593p() {
        return this.f17311d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25553a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo25553a(menuBuilder, menuItem) || this.f17311d.mo25553a(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f17312e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f17312e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.mo25538a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.mo25538a(ContextCompat.getDrawable(mo25578e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.mo25540a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.mo25540a((CharSequence) mo25578e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo25539a(view);
        return this;
    }

    /* renamed from: c */
    public boolean mo25572c(MenuItemImpl menuItemImpl) {
        return this.f17311d.mo25572c(menuItemImpl);
    }

    /* renamed from: d */
    public boolean mo25577d(MenuItemImpl menuItemImpl) {
        return this.f17311d.mo25577d(menuItemImpl);
    }

    /* renamed from: a */
    public String mo25542a() {
        int itemId = this.f17312e != null ? this.f17312e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo25542a() + SystemInfoUtil.COLON + itemId;
    }
}
