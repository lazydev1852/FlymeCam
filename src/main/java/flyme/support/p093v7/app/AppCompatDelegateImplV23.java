package flyme.support.p093v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import flyme.support.p093v7.app.AppCompatDelegateImplV14;

/* renamed from: flyme.support.v7.app.AppCompatDelegateImplV23 */
public class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {

    /* renamed from: s */
    private final UiModeManager f16751s;

    AppCompatDelegateImplV23(Context context, Window window, AppCompatCallback aVar) {
        super(context, window, aVar);
        this.f16751s = (UiModeManager) context.getSystemService("uimode");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo25199a(Window.Callback callback) {
        return new AppCompatWindowCallbackV23(callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo25215e(int i) {
        if (i == 0 && this.f16751s.getNightMode() == 0) {
            return -1;
        }
        return super.mo25215e(i);
    }

    /* renamed from: flyme.support.v7.app.AppCompatDelegateImplV23$AppCompatWindowCallbackV23 */
    class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        AppCompatWindowCallbackV23(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImplV23.this.mo25209n() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return mo25218a(callback);
        }
    }
}
