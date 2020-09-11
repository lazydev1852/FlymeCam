package flyme.support.p093v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.MenuWrapperFactory;
import java.util.ArrayList;

@TargetApi(11)
/* renamed from: flyme.support.v7.view.g */
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a */
    final Context f17133a;

    /* renamed from: b */
    final ActionMode f17134b;

    public SupportActionModeWrapper(Context context, ActionMode bVar) {
        this.f17133a = context;
        this.f17134b = bVar;
    }

    public Object getTag() {
        return this.f17134b.mo25423k();
    }

    public void setTag(Object obj) {
        this.f17134b.mo25422a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f17134b.mo25350b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f17134b.mo25346a(charSequence);
    }

    public void invalidate() {
        this.f17134b.mo25353d();
    }

    public void finish() {
        this.f17134b.mo25352c();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.m19062a(this.f17133a, (SupportMenu) this.f17134b.mo25348b());
    }

    public CharSequence getTitle() {
        return this.f17134b.mo25355f();
    }

    public void setTitle(int i) {
        this.f17134b.mo25344a(i);
    }

    public CharSequence getSubtitle() {
        return this.f17134b.mo25356g();
    }

    public void setSubtitle(int i) {
        this.f17134b.mo25349b(i);
    }

    public View getCustomView() {
        return this.f17134b.mo25358i();
    }

    public void setCustomView(View view) {
        this.f17134b.mo25345a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f17134b.mo25343a();
    }

    public boolean getTitleOptionalHint() {
        return this.f17134b.mo25424l();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f17134b.mo25347a(z);
    }

    public boolean isTitleOptional() {
        return this.f17134b.mo25357h();
    }

    /* renamed from: flyme.support.v7.view.g$a */
    /* compiled from: SupportActionModeWrapper */
    public static class C3155a implements ActionMode.C3152b {

        /* renamed from: a */
        final ActionMode.Callback f17135a;

        /* renamed from: b */
        final Context f17136b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f17137c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f17138d = new SimpleArrayMap<>();

        public C3155a(Context context, ActionMode.Callback callback) {
            this.f17136b = context;
            this.f17135a = callback;
        }

        /* renamed from: a */
        public boolean mo25245a(ActionMode bVar, Menu menu) {
            return this.f17135a.onCreateActionMode(mo25451b(bVar), m18836a(menu));
        }

        /* renamed from: b */
        public boolean mo25247b(ActionMode bVar, Menu menu) {
            return this.f17135a.onPrepareActionMode(mo25451b(bVar), m18836a(menu));
        }

        /* renamed from: a */
        public boolean mo25246a(ActionMode bVar, MenuItem menuItem) {
            return this.f17135a.onActionItemClicked(mo25451b(bVar), MenuWrapperFactory.m19063a(this.f17136b, (SupportMenuItem) menuItem));
        }

        /* renamed from: a */
        public void mo25244a(ActionMode bVar) {
            this.f17135a.onDestroyActionMode(mo25451b(bVar));
        }

        /* renamed from: a */
        private Menu m18836a(Menu menu) {
            Menu menu2 = this.f17138d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a = MenuWrapperFactory.m19062a(this.f17136b, (SupportMenu) menu);
            this.f17138d.put(menu, a);
            return a;
        }

        /* renamed from: b */
        public android.view.ActionMode mo25451b(ActionMode bVar) {
            int size = this.f17137c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper gVar = this.f17137c.get(i);
                if (gVar != null && gVar.f17134b == bVar) {
                    return gVar;
                }
            }
            SupportActionModeWrapper gVar2 = new SupportActionModeWrapper(this.f17136b, bVar);
            this.f17137c.add(gVar2);
            return gVar2;
        }
    }
}
