package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.view.menu.e */
public class ListMenuPresenter implements AdapterView.OnItemClickListener, MenuPresenter {

    /* renamed from: a */
    Context f17327a;

    /* renamed from: b */
    LayoutInflater f17328b;

    /* renamed from: c */
    MenuBuilder f17329c;

    /* renamed from: d */
    ExpandedMenuView f17330d;

    /* renamed from: e */
    int f17331e;

    /* renamed from: f */
    int f17332f;

    /* renamed from: g */
    C3164a f17333g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17334h;

    /* renamed from: i */
    private MenuPresenter.C3167a f17335i;

    /* renamed from: a */
    public boolean mo25737a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: b */
    public boolean mo25741b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo25742b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f17327a = context;
        this.f17328b = LayoutInflater.from(this.f17327a);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f17332f = i;
        this.f17331e = i2;
    }

    /* renamed from: a */
    public void mo25729a(Context context, MenuBuilder menuBuilder) {
        if (this.f17331e != 0) {
            this.f17327a = new ContextThemeWrapper(context, this.f17331e);
            this.f17328b = LayoutInflater.from(this.f17327a);
        } else if (this.f17327a != null) {
            this.f17327a = context;
            if (this.f17328b == null) {
                this.f17328b = LayoutInflater.from(this.f17327a);
            }
        }
        this.f17329c = menuBuilder;
        if (this.f17333g != null) {
            this.f17333g.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public MenuView mo25749a(ViewGroup viewGroup) {
        if (this.f17330d == null) {
            this.f17330d = (ExpandedMenuView) this.f17328b.inflate(R.layout.mz_expanded_menu_layout, viewGroup, false);
            if (this.f17333g == null) {
                this.f17333g = new C3164a();
            }
            this.f17330d.setAdapter(this.f17333g);
            this.f17330d.setOnItemClickListener(this);
        }
        return this.f17330d;
    }

    /* renamed from: a */
    public ListAdapter mo25748a() {
        if (this.f17333g == null) {
            this.f17333g = new C3164a();
        }
        return this.f17333g;
    }

    /* renamed from: a */
    public void mo25734a(boolean z) {
        if (this.f17333g != null) {
            this.f17333g.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo25750a(MenuPresenter.C3167a aVar) {
        this.f17335i = aVar;
    }

    /* renamed from: a */
    public boolean mo25738a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).mo25760a((IBinder) null);
        if (this.f17335i == null) {
            return true;
        }
        this.f17335i.mo25243a_(subMenuBuilder);
        return true;
    }

    /* renamed from: a */
    public void mo25731a(MenuBuilder menuBuilder, boolean z) {
        if (this.f17335i != null) {
            this.f17335i.mo25242a(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f17329c.mo25552a((MenuItem) this.f17333g.getItem(i), (MenuPresenter) this, 0);
    }

    /* renamed from: flyme.support.v7.view.menu.e$a */
    /* compiled from: ListMenuPresenter */
    private class C3164a extends BaseAdapter {

        /* renamed from: b */
        private int f17337b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public C3164a() {
            mo25753a();
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f17329c.mo25589l().size() - ListMenuPresenter.this.f17334h;
            return this.f17337b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> l = ListMenuPresenter.this.f17329c.mo25589l();
            int a = i + ListMenuPresenter.this.f17334h;
            if (this.f17337b >= 0 && a >= this.f17337b) {
                a++;
            }
            return l.get(a);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ListMenuPresenter.this.f17328b.inflate(ListMenuPresenter.this.f17332f, viewGroup, false);
            }
            ((MenuView.C3168a) view).mo25497a(getItem(i), 0);
            return view;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25753a() {
            MenuItemImpl r = ListMenuPresenter.this.f17329c.mo25597r();
            if (r != null) {
                ArrayList<MenuItemImpl> l = ListMenuPresenter.this.f17329c.mo25589l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (l.get(i) == r) {
                        this.f17337b = i;
                        return;
                    }
                }
            }
            this.f17337b = -1;
        }

        public void notifyDataSetChanged() {
            mo25753a();
            super.notifyDataSetChanged();
        }
    }
}
