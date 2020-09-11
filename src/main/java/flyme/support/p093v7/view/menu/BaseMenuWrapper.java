package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: flyme.support.v7.view.menu.b */
public abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {

    /* renamed from: a */
    final Context f17323a;

    /* renamed from: c */
    private Map<SupportMenuItem, MenuItem> f17324c;

    /* renamed from: d */
    private Map<SupportSubMenu, SubMenu> f17325d;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f17323a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo25743a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f17324c == null) {
            this.f17324c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f17324c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a = MenuWrapperFactory.m19063a(this.f17323a, supportMenuItem);
        this.f17324c.put(supportMenuItem, a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SubMenu mo25744a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f17325d == null) {
            this.f17325d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f17325d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu a = MenuWrapperFactory.m19064a(this.f17323a, supportSubMenu);
        this.f17325d.put(supportSubMenu, a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo25745a() {
        if (this.f17324c != null) {
            this.f17324c.clear();
        }
        if (this.f17325d != null) {
            this.f17325d.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo25746a(int i) {
        if (this.f17324c != null) {
            Iterator<SupportMenuItem> it = this.f17324c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo25747b(int i) {
        if (this.f17324c != null) {
            Iterator<SupportMenuItem> it = this.f17324c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
