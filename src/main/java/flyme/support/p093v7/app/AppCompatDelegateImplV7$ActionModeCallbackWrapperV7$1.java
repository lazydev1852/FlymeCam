package flyme.support.p093v7.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import flyme.support.p093v7.app.AppCompatDelegateImplV7;

/* renamed from: flyme.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1 */
class AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ AppCompatDelegateImplV7.C3106b f16818a;

    AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1(AppCompatDelegateImplV7.C3106b bVar) {
        this.f16818a = bVar;
    }

    public void onAnimationEnd(View view) {
        AppCompatDelegateImplV7.this.f16769o.setVisibility(8);
        if (AppCompatDelegateImplV7.this.f16770p != null) {
            AppCompatDelegateImplV7.this.f16770p.dismiss();
        } else if (AppCompatDelegateImplV7.this.f16769o.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.f16769o.getParent());
        }
        AppCompatDelegateImplV7.this.f16769o.removeAllViews();
        AppCompatDelegateImplV7.this.f16772r.setListener((ViewPropertyAnimatorListener) null);
        AppCompatDelegateImplV7.this.f16772r = null;
    }
}
