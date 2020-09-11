package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;
import flyme.support.p093v7.widget.ListPopupWindow;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.view.menu.g */
public class MenuPopupHelper implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter {

    /* renamed from: a */
    static final int f17342a = R.layout.mz_popup_menu_item_layout;

    /* renamed from: b */
    boolean f17343b;

    /* renamed from: c */
    private final Context f17344c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LayoutInflater f17345d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MenuBuilder f17346e;

    /* renamed from: f */
    private final C3166a f17347f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final boolean f17348g;

    /* renamed from: h */
    private final int f17349h;

    /* renamed from: i */
    private final int f17350i;

    /* renamed from: j */
    private final int f17351j;

    /* renamed from: k */
    private View f17352k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ListPopupWindow f17353l;

    /* renamed from: m */
    private ViewTreeObserver f17354m;

    /* renamed from: n */
    private MenuPresenter.C3167a f17355n;

    /* renamed from: o */
    private ViewGroup f17356o;

    /* renamed from: p */
    private boolean f17357p;

    /* renamed from: q */
    private int f17358q;

    /* renamed from: r */
    private int f17359r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public View.OnClickListener f17360s;

    /* renamed from: a */
    public void mo25729a(Context context, MenuBuilder menuBuilder) {
    }

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

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f17359r = 0;
        this.f17360s = new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuPopupHelper.this.mo25772f()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    ListView listView = MenuPopupHelper.this.f17353l.getListView();
                    MenuPopupHelper.this.onItemClick(listView, listView.getChildAt(intValue - listView.getFirstVisiblePosition()), intValue, listView.getAdapter().getItemId(intValue));
                }
            }
        };
        this.f17344c = context;
        this.f17345d = LayoutInflater.from(context);
        this.f17346e = menuBuilder;
        this.f17347f = new C3166a(this.f17346e);
        this.f17348g = z;
        this.f17350i = i;
        this.f17351j = i2;
        Resources resources = context.getResources();
        this.f17349h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f17352k = view;
        menuBuilder.mo25548a((MenuPresenter) this, context);
    }

    /* renamed from: a */
    public void mo25766a(View view) {
        this.f17352k = view;
    }

    /* renamed from: b */
    public void mo25768b(boolean z) {
        this.f17343b = z;
    }

    /* renamed from: a */
    public void mo25765a(int i) {
        this.f17359r = i;
    }

    /* renamed from: a */
    public void mo25764a() {
        if (!mo25770d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: c */
    public ListPopupWindow mo25769c() {
        return this.f17353l;
    }

    /* renamed from: d */
    public boolean mo25770d() {
        this.f17353l = new ListPopupWindow(this.f17344c, (AttributeSet) null, this.f17350i, this.f17351j);
        this.f17353l.setOnDismissListener(this);
        this.f17353l.setOnItemClickListener(this);
        this.f17353l.setAdapter(this.f17347f);
        this.f17353l.setModal(true);
        View view = this.f17352k;
        if (view == null) {
            return false;
        }
        boolean z = this.f17354m == null;
        this.f17354m = view.getViewTreeObserver();
        if (z) {
            this.f17354m.addOnGlobalLayoutListener(this);
        }
        this.f17353l.setAnchorView(view);
        this.f17353l.setDropDownGravity(this.f17359r);
        if (!this.f17357p) {
            this.f17358q = m19030g();
            this.f17357p = true;
        }
        this.f17353l.setContentWidth(this.f17358q);
        this.f17353l.setInputMethodMode(2);
        this.f17353l.mo26123a(false);
        this.f17353l.show();
        this.f17353l.getListView().setOnKeyListener(this);
        return true;
    }

    /* renamed from: e */
    public void mo25771e() {
        if (mo25772f()) {
            this.f17353l.dismiss();
        }
    }

    public void onDismiss() {
        this.f17353l = null;
        this.f17346e.close();
        if (this.f17354m != null) {
            if (!this.f17354m.isAlive()) {
                this.f17354m = this.f17352k.getViewTreeObserver();
            }
            this.f17354m.removeGlobalOnLayoutListener(this);
            this.f17354m = null;
        }
    }

    /* renamed from: f */
    public boolean mo25772f() {
        return this.f17353l != null && this.f17353l.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3166a aVar = this.f17347f;
        aVar.f17363b.mo25551a((MenuItem) aVar.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo25771e();
        return true;
    }

    /* renamed from: g */
    private int m19030g() {
        C3166a aVar = this.f17347f;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = aVar.getCount();
        View view = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = aVar.getItemViewType(i3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            if (this.f17356o == null) {
                this.f17356o = new FrameLayout(this.f17344c);
            }
            view = aVar.getView(i3, view, this.f17356o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= this.f17349h) {
                return this.f17349h;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public void onGlobalLayout() {
        if (mo25772f()) {
            View view = this.f17352k;
            if (view == null || !view.isShown()) {
                mo25771e();
            } else if (mo25772f()) {
                this.f17353l.show();
            }
        }
    }

    /* renamed from: a */
    public void mo25734a(boolean z) {
        this.f17357p = false;
        if (this.f17347f != null) {
            this.f17347f.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo25767a(MenuPresenter.C3167a aVar) {
        this.f17355n = aVar;
    }

    /* renamed from: a */
    public boolean mo25738a(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper gVar = new MenuPopupHelper(this.f17344c, subMenuBuilder, this.f17352k);
            gVar.mo25767a(this.f17355n);
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            gVar.mo25768b(z);
            if (gVar.mo25770d()) {
                if (this.f17355n != null) {
                    this.f17355n.mo25243a_(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo25731a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f17346e) {
            mo25771e();
            if (this.f17355n != null) {
                this.f17355n.mo25242a(menuBuilder, z);
            }
        }
    }

    /* renamed from: flyme.support.v7.view.menu.g$a */
    /* compiled from: MenuPopupHelper */
    private class C3166a extends BaseAdapter {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public MenuBuilder f17363b;

        /* renamed from: c */
        private int f17364c = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public C3166a(MenuBuilder menuBuilder) {
            this.f17363b = menuBuilder;
            mo25779a();
        }

        public int getCount() {
            ArrayList<MenuItemImpl> l = MenuPopupHelper.this.f17348g ? this.f17363b.mo25589l() : this.f17363b.mo25585i();
            if (this.f17364c < 0) {
                return l.size();
            }
            return l.size() - 1;
        }

        /* renamed from: a */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> l = MenuPopupHelper.this.f17348g ? this.f17363b.mo25589l() : this.f17363b.mo25585i();
            if (this.f17364c >= 0 && i >= this.f17364c) {
                i++;
            }
            return l.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MenuPopupHelper.this.f17345d.inflate(MenuPopupHelper.f17342a, viewGroup, false);
                view.setOnClickListener(MenuPopupHelper.this.f17360s);
            }
            view.setTag(Integer.valueOf(i));
            MenuView.C3168a aVar = (MenuView.C3168a) view;
            if (MenuPopupHelper.this.f17343b) {
                ((ListMenuItemView) view).setForceShowIcon(true);
            }
            aVar.mo25497a(getItem(i), 0);
            int count = getCount();
            if (count == 1) {
                view.setBackgroundResource(R.drawable.mz_popup_item_selector_all);
            } else if (i == 0) {
                view.setBackgroundResource(R.drawable.mz_popup_item_selector_top);
            } else if (i == count - 1) {
                view.setBackgroundResource(R.drawable.mz_popup_item_selector_bottom);
            } else {
                view.setBackgroundResource(R.drawable.mz_popup_item_selector_center);
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25779a() {
            MenuItemImpl r = MenuPopupHelper.this.f17346e.mo25597r();
            if (r != null) {
                ArrayList<MenuItemImpl> l = MenuPopupHelper.this.f17346e.mo25589l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (l.get(i) == r) {
                        this.f17364c = i;
                        return;
                    }
                }
            }
            this.f17364c = -1;
        }

        public void notifyDataSetChanged() {
            mo25779a();
            super.notifyDataSetChanged();
        }

        public boolean isEnabled(int i) {
            MenuItemImpl a = getItem(i);
            return a == null ? super.isEnabled(i) : a.isEnabled();
        }
    }
}
