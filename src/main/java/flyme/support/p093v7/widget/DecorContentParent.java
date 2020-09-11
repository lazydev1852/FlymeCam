package flyme.support.p093v7.widget;

import android.view.Menu;
import android.view.Window;
import flyme.support.p093v7.view.menu.MenuPresenter;

/* renamed from: flyme.support.v7.widget.g */
public interface DecorContentParent {
    /* renamed from: a */
    void mo25888a(int i);

    /* renamed from: d */
    boolean mo25894d();

    /* renamed from: e */
    boolean mo25896e();

    /* renamed from: f */
    boolean mo25897f();

    /* renamed from: g */
    boolean mo25899g();

    /* renamed from: h */
    boolean mo25905h();

    /* renamed from: i */
    void mo25906i();

    void setBottomMenu(Menu menu, MenuPresenter.C3167a aVar);

    void setMenu(Menu menu, MenuPresenter.C3167a aVar);

    void setMenuPrepared();

    void setTransStatusBarInFlyme3(boolean z);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
