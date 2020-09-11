package flyme.support.p093v7.view.menu;

/* renamed from: flyme.support.v7.view.menu.c */
public class BaseWrapper<T> {

    /* renamed from: b */
    final T f17326b;

    BaseWrapper(T t) {
        if (t != null) {
            this.f17326b = t;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
}
