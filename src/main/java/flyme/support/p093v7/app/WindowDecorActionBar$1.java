package flyme.support.p093v7.app;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: flyme.support.v7.app.WindowDecorActionBar$1 */
class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ WindowDecorActionBar f16950a;

    WindowDecorActionBar$1(WindowDecorActionBar fVar) {
        this.f16950a = fVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f16950a.f17029v != null) {
            this.f16950a.f17029v.setVisibility(8);
        }
        boolean unused = this.f16950a.f17005O = false;
        ViewPropertyAnimatorCompatSet unused2 = this.f16950a.f17001K = null;
    }
}
