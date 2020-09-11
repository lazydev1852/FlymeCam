package flyme.support.p093v7.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* renamed from: flyme.support.v7.view.f */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.C3159a {

    /* renamed from: a */
    private Context f17126a;

    /* renamed from: b */
    private ActionBarContextView f17127b;

    /* renamed from: c */
    private ActionMode.C3152b f17128c;

    /* renamed from: d */
    private WeakReference<View> f17129d;

    /* renamed from: e */
    private boolean f17130e;

    /* renamed from: f */
    private boolean f17131f;

    /* renamed from: g */
    private MenuBuilder f17132g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.C3152b bVar, boolean z) {
        this.f17126a = context;
        this.f17127b = actionBarContextView;
        this.f17128c = bVar;
        this.f17132g = new MenuBuilder(actionBarContextView.getContext()).mo25537a(1);
        this.f17132g.mo25545a((MenuBuilder.C3159a) this);
        this.f17131f = z;
    }

    /* renamed from: b */
    public void mo25350b(CharSequence charSequence) {
        this.f17127b.setTitle(charSequence);
    }

    /* renamed from: a */
    public void mo25346a(CharSequence charSequence) {
        this.f17127b.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo25344a(int i) {
        mo25350b((CharSequence) this.f17126a.getString(i));
    }

    /* renamed from: b */
    public void mo25349b(int i) {
        mo25346a((CharSequence) this.f17126a.getString(i));
    }

    /* renamed from: a */
    public void mo25347a(boolean z) {
        super.mo25347a(z);
        this.f17127b.setTitleOptional(z);
    }

    /* renamed from: h */
    public boolean mo25357h() {
        return this.f17127b.mo25857d();
    }

    /* renamed from: a */
    public void mo25345a(View view) {
        this.f17127b.setCustomView(view);
        this.f17129d = view != null ? new WeakReference<>(view) : null;
    }

    /* renamed from: d */
    public void mo25353d() {
        this.f17128c.mo25247b(this, this.f17132g);
    }

    /* renamed from: c */
    public void mo25352c() {
        if (!this.f17130e) {
            this.f17130e = true;
            this.f17127b.sendAccessibilityEvent(32);
            this.f17128c.mo25244a(this);
        }
    }

    /* renamed from: b */
    public Menu mo25348b() {
        return this.f17132g;
    }

    /* renamed from: f */
    public CharSequence mo25355f() {
        return this.f17127b.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo25356g() {
        return this.f17127b.getSubtitle();
    }

    /* renamed from: i */
    public View mo25358i() {
        if (this.f17129d != null) {
            return (View) this.f17129d.get();
        }
        return null;
    }

    /* renamed from: a */
    public MenuInflater mo25343a() {
        return new SupportMenuInflater(this.f17127b.getContext());
    }

    /* renamed from: a */
    public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f17128c.mo25246a((ActionMode) this, menuItem);
    }

    /* renamed from: a */
    public void mo25219a(MenuBuilder menuBuilder) {
        mo25353d();
        this.f17127b.mo25823a();
    }
}
