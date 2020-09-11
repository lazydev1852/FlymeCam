package flyme.support.p093v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

/* renamed from: flyme.support.v7.view.menu.k */
public class MenuWrapperICS extends BaseMenuWrapper<SupportMenu> implements Menu {
    MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo25743a(((SupportMenu) this.f17326b).add(charSequence));
    }

    public MenuItem add(int i) {
        return mo25743a(((SupportMenu) this.f17326b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo25743a(((SupportMenu) this.f17326b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo25743a(((SupportMenu) this.f17326b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo25744a(((SupportMenu) this.f17326b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return mo25744a(((SupportMenu) this.f17326b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo25744a(((SupportMenu) this.f17326b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo25744a(((SupportMenu) this.f17326b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((SupportMenu) this.f17326b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = mo25743a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        mo25747b(i);
        ((SupportMenu) this.f17326b).removeItem(i);
    }

    public void removeGroup(int i) {
        mo25746a(i);
        ((SupportMenu) this.f17326b).removeGroup(i);
    }

    public void clear() {
        mo25745a();
        ((SupportMenu) this.f17326b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.f17326b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.f17326b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.f17326b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((SupportMenu) this.f17326b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return mo25743a(((SupportMenu) this.f17326b).findItem(i));
    }

    public int size() {
        return ((SupportMenu) this.f17326b).size();
    }

    public MenuItem getItem(int i) {
        return mo25743a(((SupportMenu) this.f17326b).getItem(i));
    }

    public void close() {
        ((SupportMenu) this.f17326b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.f17326b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.f17326b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.f17326b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.f17326b).setQwertyMode(z);
    }
}
