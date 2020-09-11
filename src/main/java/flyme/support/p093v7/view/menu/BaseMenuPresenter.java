package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.view.menu.a */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a */
    protected Context f17313a;

    /* renamed from: b */
    protected Context f17314b;

    /* renamed from: c */
    protected MenuBuilder f17315c;

    /* renamed from: d */
    protected LayoutInflater f17316d;

    /* renamed from: e */
    protected LayoutInflater f17317e;

    /* renamed from: f */
    protected MenuView f17318f;

    /* renamed from: g */
    private MenuPresenter.C3167a f17319g;

    /* renamed from: h */
    private int f17320h;

    /* renamed from: i */
    private int f17321i;

    /* renamed from: j */
    private int f17322j;

    /* renamed from: a */
    public abstract void mo25732a(MenuItemImpl menuItemImpl, MenuView.C3168a aVar);

    /* renamed from: a */
    public boolean mo25735a(int i, MenuItemImpl menuItemImpl) {
        return true;
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

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f17313a = context;
        this.f17316d = LayoutInflater.from(context);
        this.f17320h = i;
        this.f17321i = i2;
    }

    /* renamed from: a */
    public void mo25729a(Context context, MenuBuilder menuBuilder) {
        this.f17314b = context;
        this.f17317e = LayoutInflater.from(this.f17314b);
        this.f17315c = menuBuilder;
    }

    /* renamed from: a */
    public MenuView mo25727a(ViewGroup viewGroup) {
        if (this.f17318f == null) {
            this.f17318f = (MenuView) this.f17316d.inflate(this.f17320h, viewGroup, false);
            this.f17318f.mo25522a(this.f17315c);
            mo25734a(true);
        }
        return this.f17318f;
    }

    /* renamed from: a */
    public void mo25734a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f17318f;
        if (viewGroup != null) {
            int i = 0;
            if (this.f17315c != null) {
                this.f17315c.mo25587j();
                ArrayList<MenuItemImpl> i2 = this.f17315c.mo25585i();
                int size = i2.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl = i2.get(i4);
                    if (mo25735a(i3, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i3);
                        MenuItemImpl itemData = childAt instanceof MenuView.C3168a ? ((MenuView.C3168a) childAt).getItemData() : null;
                        View a = mo25725a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            a.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(a);
                        }
                        if (a != childAt) {
                            mo25730a(a, i3);
                        }
                        i3++;
                    }
                }
                i = i3;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo25736a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25730a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f17318f).addView(view, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25736a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: a */
    public void mo25733a(MenuPresenter.C3167a aVar) {
        this.f17319g = aVar;
    }

    /* renamed from: a */
    public MenuPresenter.C3167a mo25726a() {
        return this.f17319g;
    }

    /* renamed from: b */
    public MenuView.C3168a mo25739b(ViewGroup viewGroup) {
        return (MenuView.C3168a) this.f17316d.inflate(this.f17321i, viewGroup, false);
    }

    /* renamed from: a */
    public View mo25725a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.C3168a aVar;
        if (view instanceof MenuView.C3168a) {
            aVar = (MenuView.C3168a) view;
        } else {
            aVar = mo25739b(viewGroup);
        }
        mo25732a(menuItemImpl, aVar);
        return (View) aVar;
    }

    /* renamed from: a */
    public void mo25731a(MenuBuilder menuBuilder, boolean z) {
        if (this.f17319g != null) {
            this.f17319g.mo25242a(menuBuilder, z);
        }
    }

    /* renamed from: a */
    public boolean mo25738a(SubMenuBuilder subMenuBuilder) {
        if (this.f17319g != null) {
            return this.f17319g.mo25243a_(subMenuBuilder);
        }
        return false;
    }

    /* renamed from: a */
    public void mo25728a(int i) {
        this.f17322j = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25740b(int i) {
        this.f17321i = i;
    }
}
