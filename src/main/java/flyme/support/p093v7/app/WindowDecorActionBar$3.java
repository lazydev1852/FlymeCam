package flyme.support.p093v7.app;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: flyme.support.v7.app.WindowDecorActionBar$3 */
class WindowDecorActionBar$3 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ WindowDecorActionBar f16952a;

    WindowDecorActionBar$3(WindowDecorActionBar fVar) {
        this.f16952a = fVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f16952a.f16996F && this.f16952a.f17030w != null) {
            ViewCompat.setTranslationY(this.f16952a.f17030w, 0.0f);
            ViewCompat.setTranslationY(this.f16952a.f17026s, 0.0f);
        }
        if (this.f16952a.f17029v != null) {
            this.f16952a.f17029v.setVisibility(8);
        }
        this.f16952a.f17026s.setVisibility(8);
        this.f16952a.f17026s.setTransitioning(false);
        ViewPropertyAnimatorCompatSet unused = this.f16952a.f17001K = null;
        boolean unused2 = this.f16952a.f17005O = false;
        this.f16952a.mo25332h();
        if (this.f16952a.f17025r != null) {
            ViewCompat.requestApplyInsets(this.f16952a.f17025r);
        }
    }
}
