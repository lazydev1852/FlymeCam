package flyme.support.p093v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: flyme.support.v7.view.menu.MenuBuilder */
public class MenuBuilder implements SupportMenu, FMenu {

    /* renamed from: d */
    private static final int[] f17238d = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    CharSequence f17239a;

    /* renamed from: b */
    Drawable f17240b;

    /* renamed from: c */
    View f17241c;

    /* renamed from: e */
    private final Context f17242e;

    /* renamed from: f */
    private final Resources f17243f;

    /* renamed from: g */
    private boolean f17244g;

    /* renamed from: h */
    private boolean f17245h;

    /* renamed from: i */
    private C3159a f17246i;

    /* renamed from: j */
    private ArrayList<MenuItemImpl> f17247j;

    /* renamed from: k */
    private ArrayList<MenuItemImpl> f17248k;

    /* renamed from: l */
    private boolean f17249l;

    /* renamed from: m */
    private ArrayList<MenuItemImpl> f17250m;

    /* renamed from: n */
    private ArrayList<MenuItemImpl> f17251n;

    /* renamed from: o */
    private boolean f17252o;

    /* renamed from: p */
    private int f17253p = 0;

    /* renamed from: q */
    private ContextMenu.ContextMenuInfo f17254q;

    /* renamed from: r */
    private boolean f17255r = false;

    /* renamed from: s */
    private boolean f17256s = false;

    /* renamed from: t */
    private boolean f17257t = false;

    /* renamed from: u */
    private boolean f17258u = false;

    /* renamed from: v */
    private ArrayList<MenuItemImpl> f17259v = new ArrayList<>();

    /* renamed from: w */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f17260w = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    private MenuItemImpl f17261x;

    /* renamed from: y */
    private boolean f17262y;

    /* renamed from: flyme.support.v7.view.menu.MenuBuilder$a */
    public interface C3159a {
        /* renamed from: a */
        void mo25219a(MenuBuilder menuBuilder);

        /* renamed from: a */
        boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem);
    }

    /* renamed from: flyme.support.v7.view.menu.MenuBuilder$b */
    public interface C3160b {
        /* renamed from: a */
        boolean mo25523a(MenuItemImpl menuItemImpl);
    }

    /* renamed from: a */
    public static boolean m18890a(ViewConfiguration viewConfiguration, @NonNull Context context) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25542a() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: p */
    public MenuBuilder mo25593p() {
        return this;
    }

    public void setGroupDividerEnabled(boolean z) {
    }

    public MenuBuilder(Context context) {
        this.f17242e = context;
        this.f17243f = context.getResources();
        this.f17247j = new ArrayList<>();
        this.f17248k = new ArrayList<>();
        this.f17249l = true;
        this.f17250m = new ArrayList<>();
        this.f17251n = new ArrayList<>();
        this.f17252o = true;
        m18894e(true);
    }

    /* renamed from: a */
    public MenuBuilder mo25537a(int i) {
        this.f17253p = i;
        return this;
    }

    /* renamed from: a */
    public void mo25547a(MenuPresenter hVar) {
        mo25548a(hVar, this.f17242e);
    }

    /* renamed from: a */
    public void mo25548a(MenuPresenter hVar, Context context) {
        this.f17260w.add(new WeakReference(hVar));
        hVar.mo25729a(context, this);
        this.f17252o = true;
    }

    /* renamed from: b */
    public void mo25566b(MenuPresenter hVar) {
        Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter hVar2 = (MenuPresenter) next.get();
            if (hVar2 == null || hVar2 == hVar) {
                this.f17260w.remove(next);
            }
        }
    }

    /* renamed from: d */
    private void m18893d(boolean z) {
        if (!this.f17260w.isEmpty()) {
            mo25581g();
            Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter hVar = (MenuPresenter) next.get();
                if (hVar == null) {
                    this.f17260w.remove(next);
                } else {
                    hVar.mo25734a(z);
                }
            }
            mo25583h();
        }
    }

    /* renamed from: a */
    private boolean m18891a(SubMenuBuilder subMenuBuilder, MenuPresenter hVar) {
        boolean z = false;
        if (this.f17260w.isEmpty()) {
            return false;
        }
        if (hVar != null) {
            z = hVar.mo25738a(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter hVar2 = (MenuPresenter) next.get();
            if (hVar2 == null) {
                this.f17260w.remove(next);
            } else if (!z) {
                z = hVar2.mo25738a(subMenuBuilder);
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo25543a(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).mo25543a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo25542a(), sparseArray);
        }
    }

    /* renamed from: b */
    public void mo25564b(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo25542a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = MenuItemCompat.getActionView(item);
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).mo25564b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                MenuItemCompat.expandActionView(findItem);
            }
        }
    }

    /* renamed from: a */
    public void mo25545a(C3159a aVar) {
        this.f17246i = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo25536a(int i, int i2, int i3, CharSequence charSequence) {
        int d = m18892d(i3);
        MenuItemImpl a = m18887a(i, i2, i3, d, charSequence, this.f17253p);
        if (this.f17254q != null) {
            a.mo25609a(this.f17254q);
        }
        this.f17247j.add(m18886a(this.f17247j, d), a);
        mo25567b(true);
        return a;
    }

    /* renamed from: a */
    private MenuItemImpl m18887a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo25536a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return mo25536a(0, 0, 0, this.f17243f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo25536a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo25536a(i, i2, i3, this.f17243f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f17243f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo25536a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f17242e, this, menuItemImpl);
        menuItemImpl.mo25610a(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f17243f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f17242e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m18889a(mo25563b(i), true);
    }

    public void removeGroup(int i) {
        int c = mo25569c(i);
        if (c >= 0) {
            int size = this.f17247j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f17247j.get(c).getGroupId() != i) {
                    mo25567b(true);
                } else {
                    m18889a(c, false);
                    i2 = i3;
                }
            }
            mo25567b(true);
        }
    }

    /* renamed from: a */
    private void m18889a(int i, boolean z) {
        if (i >= 0 && i < this.f17247j.size()) {
            this.f17247j.remove(i);
            if (z) {
                mo25567b(true);
            }
        }
    }

    public void clear() {
        if (this.f17261x != null) {
            mo25577d(this.f17261x);
        }
        this.f17247j.clear();
        mo25567b(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25544a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f17247j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.mo25622f() && menuItemImpl.isCheckable()) {
                menuItemImpl.mo25615b(menuItemImpl == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f17247j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.mo25611a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f17247j.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.mo25617c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            mo25567b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f17247j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f17262y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f17247j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int mo25563b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f17247j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public int mo25569c(int i) {
        return mo25535a(i, 0);
    }

    /* renamed from: a */
    public int mo25535a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f17247j.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int size() {
        return this.f17247j.size();
    }

    public MenuItem getItem(int i) {
        return this.f17247j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo25541a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f17244g = z;
        mo25567b(false);
    }

    /* renamed from: d */
    private static int m18892d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 < 0 || i2 >= f17238d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & 65535) | (f17238d[i2] << 16);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo25568b() {
        return this.f17244g;
    }

    /* renamed from: e */
    private void m18894e(boolean z) {
        boolean z2 = true;
        if (!z || this.f17243f.getConfiguration().keyboard == 1 || !m18890a(ViewConfiguration.get(this.f17242e), this.f17242e)) {
            z2 = false;
        }
        this.f17245h = z2;
    }

    /* renamed from: c */
    public boolean mo25571c() {
        return this.f17245h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Resources mo25576d() {
        return this.f17243f;
    }

    /* renamed from: e */
    public Context mo25578e() {
        return this.f17242e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25553a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f17246i != null && this.f17246i.mo25220a(menuBuilder, menuItem);
    }

    /* renamed from: f */
    public void mo25579f() {
        if (this.f17246i != null) {
            this.f17246i.mo25219a(this);
        }
    }

    /* renamed from: a */
    private static int m18886a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).mo25613b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl a = mo25541a(i, keyEvent);
        boolean a2 = a != null ? mo25551a((MenuItem) a, i2) : false;
        if ((i2 & 2) != 0) {
            mo25550a(true);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25549a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean b = mo25568b();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f17247j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f17247j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).mo25549a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == 8 && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemImpl mo25541a(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<MenuItemImpl> arrayList = this.f17259v;
        arrayList.clear();
        mo25549a((List<MenuItemImpl>) arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean b = mo25568b();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            if (b) {
                c = menuItemImpl.getAlphabeticShortcut();
            } else {
                c = menuItemImpl.getNumericShortcut();
            }
            if ((c == keyData.meta[0] && (metaState & 2) == 0) || ((c == keyData.meta[2] && (metaState & 2) != 0) || (b && c == 8 && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return mo25551a(findItem(i), i2);
    }

    /* renamed from: a */
    public boolean mo25551a(MenuItem menuItem, int i) {
        return mo25552a(menuItem, (MenuPresenter) null, i);
    }

    /* renamed from: a */
    public boolean mo25552a(MenuItem menuItem, MenuPresenter hVar, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean a = menuItemImpl.mo25612a();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.mo25646m()) {
            a |= menuItemImpl.expandActionView();
            if (a) {
                mo25550a(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            mo25550a(false);
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.mo25610a(new SubMenuBuilder(mo25578e(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            a |= m18891a(subMenuBuilder, hVar);
            if (!a) {
                mo25550a(true);
            }
        } else if ((i & 1) == 0) {
            mo25550a(true);
        }
        return a;
    }

    /* renamed from: a */
    public final void mo25550a(boolean z) {
        if (!this.f17258u) {
            this.f17258u = true;
            Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter hVar = (MenuPresenter) next.get();
                if (hVar == null) {
                    this.f17260w.remove(next);
                } else {
                    hVar.mo25731a(this, z);
                }
            }
            this.f17258u = false;
        }
    }

    public void close() {
        mo25550a(true);
    }

    /* renamed from: b */
    public void mo25567b(boolean z) {
        if (!this.f17255r) {
            if (z) {
                this.f17249l = true;
                this.f17252o = true;
            }
            m18893d(z);
            return;
        }
        this.f17256s = true;
    }

    /* renamed from: g */
    public void mo25581g() {
        if (!this.f17255r) {
            this.f17255r = true;
            this.f17256s = false;
        }
    }

    /* renamed from: h */
    public void mo25583h() {
        this.f17255r = false;
        if (this.f17256s) {
            this.f17256s = false;
            mo25567b(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25546a(MenuItemImpl menuItemImpl) {
        this.f17249l = true;
        mo25567b(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25565b(MenuItemImpl menuItemImpl) {
        this.f17252o = true;
        mo25567b(true);
    }

    /* renamed from: i */
    public ArrayList<MenuItemImpl> mo25585i() {
        if (!this.f17249l) {
            return this.f17248k;
        }
        this.f17248k.clear();
        int size = this.f17247j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f17247j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f17248k.add(menuItemImpl);
            }
        }
        this.f17249l = false;
        this.f17252o = true;
        return this.f17248k;
    }

    /* renamed from: j */
    public void mo25587j() {
        ArrayList<MenuItemImpl> i = mo25585i();
        if (this.f17252o) {
            Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter hVar = (MenuPresenter) next.get();
                if (hVar == null) {
                    this.f17260w.remove(next);
                } else {
                    z |= hVar.mo25741b();
                }
            }
            if (z) {
                this.f17250m.clear();
                this.f17251n.clear();
                int size = i.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = i.get(i2);
                    if (menuItemImpl.mo25638i()) {
                        this.f17250m.add(menuItemImpl);
                    } else {
                        this.f17251n.add(menuItemImpl);
                    }
                }
            } else {
                this.f17250m.clear();
                this.f17251n.clear();
                this.f17251n.addAll(mo25585i());
            }
            this.f17252o = false;
        }
    }

    /* renamed from: k */
    public ArrayList<MenuItemImpl> mo25588k() {
        mo25587j();
        return this.f17250m;
    }

    /* renamed from: l */
    public ArrayList<MenuItemImpl> mo25589l() {
        mo25587j();
        return this.f17251n;
    }

    public void clearHeader() {
        this.f17240b = null;
        this.f17239a = null;
        this.f17241c = null;
        mo25567b(false);
    }

    /* renamed from: a */
    private void m18888a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = mo25576d();
        if (view != null) {
            this.f17241c = view;
            this.f17239a = null;
            this.f17240b = null;
        } else {
            if (i > 0) {
                this.f17239a = d.getText(i);
            } else if (charSequence != null) {
                this.f17239a = charSequence;
            }
            if (i2 > 0) {
                this.f17240b = ContextCompat.getDrawable(mo25578e(), i2);
            } else if (drawable != null) {
                this.f17240b = drawable;
            }
            this.f17241c = null;
        }
        mo25567b(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo25540a(CharSequence charSequence) {
        m18888a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo25538a(Drawable drawable) {
        m18888a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo25539a(View view) {
        m18888a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* renamed from: m */
    public CharSequence mo25590m() {
        return this.f17239a;
    }

    /* renamed from: n */
    public Drawable mo25591n() {
        return this.f17240b;
    }

    /* renamed from: o */
    public View mo25592o() {
        return this.f17241c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo25596q() {
        return this.f17257t;
    }

    /* renamed from: c */
    public boolean mo25572c(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (this.f17260w.isEmpty()) {
            return false;
        }
        mo25581g();
        Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter hVar = (MenuPresenter) next.get();
            if (hVar == null) {
                this.f17260w.remove(next);
            } else {
                z = hVar.mo25737a(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        mo25583h();
        if (z) {
            this.f17261x = menuItemImpl;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo25577d(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (this.f17260w.isEmpty() || this.f17261x != menuItemImpl) {
            return false;
        }
        mo25581g();
        Iterator<WeakReference<MenuPresenter>> it = this.f17260w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter hVar = (MenuPresenter) next.get();
            if (hVar == null) {
                this.f17260w.remove(next);
            } else {
                z = hVar.mo25742b(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        mo25583h();
        if (z) {
            this.f17261x = null;
        }
        return z;
    }

    /* renamed from: r */
    public MenuItemImpl mo25597r() {
        return this.f17261x;
    }

    /* renamed from: c */
    public void mo25570c(boolean z) {
        this.f17262y = z;
    }
}
