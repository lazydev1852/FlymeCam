package flyme.support.p093v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: flyme.support.v7.view.b */
public abstract class ActionMode {

    /* renamed from: a */
    private Object f17101a;

    /* renamed from: b */
    private boolean f17102b;

    /* renamed from: c */
    private C3151a f17103c;

    /* renamed from: d */
    private boolean f17104d = true;

    /* renamed from: flyme.support.v7.view.b$a */
    /* compiled from: ActionMode */
    public interface C3151a {
        /* renamed from: a */
        boolean mo25360a();
    }

    /* renamed from: flyme.support.v7.view.b$b */
    /* compiled from: ActionMode */
    public interface C3152b {
        /* renamed from: a */
        void mo25244a(ActionMode bVar);

        /* renamed from: a */
        boolean mo25245a(ActionMode bVar, Menu menu);

        /* renamed from: a */
        boolean mo25246a(ActionMode bVar, MenuItem menuItem);

        /* renamed from: b */
        boolean mo25247b(ActionMode bVar, Menu menu);
    }

    /* renamed from: a */
    public abstract MenuInflater mo25343a();

    /* renamed from: a */
    public abstract void mo25344a(int i);

    /* renamed from: a */
    public abstract void mo25345a(View view);

    /* renamed from: a */
    public abstract void mo25346a(CharSequence charSequence);

    /* renamed from: b */
    public abstract Menu mo25348b();

    /* renamed from: b */
    public abstract void mo25349b(int i);

    /* renamed from: b */
    public abstract void mo25350b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo25352c();

    /* renamed from: d */
    public abstract void mo25353d();

    /* renamed from: f */
    public abstract CharSequence mo25355f();

    /* renamed from: g */
    public abstract CharSequence mo25356g();

    /* renamed from: h */
    public boolean mo25357h() {
        return false;
    }

    /* renamed from: i */
    public abstract View mo25358i();

    /* renamed from: j */
    public boolean mo25359j() {
        return true;
    }

    /* renamed from: a */
    public void mo25422a(Object obj) {
        this.f17101a = obj;
    }

    /* renamed from: k */
    public Object mo25423k() {
        return this.f17101a;
    }

    /* renamed from: a */
    public void mo25347a(boolean z) {
        this.f17102b = z;
    }

    /* renamed from: l */
    public boolean mo25424l() {
        return this.f17102b;
    }

    /* renamed from: a */
    public void mo25421a(C3151a aVar) {
        this.f17103c = aVar;
    }

    /* renamed from: m */
    public C3151a mo25425m() {
        return this.f17103c;
    }

    /* renamed from: n */
    public boolean mo25426n() {
        return this.f17104d;
    }
}
