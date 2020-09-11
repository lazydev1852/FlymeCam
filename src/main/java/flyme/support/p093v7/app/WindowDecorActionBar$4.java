package flyme.support.p093v7.app;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: flyme.support.v7.app.WindowDecorActionBar$4 */
class WindowDecorActionBar$4 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ WindowDecorActionBar f16953a;

    WindowDecorActionBar$4(WindowDecorActionBar fVar) {
        this.f16953a = fVar;
    }

    public void onAnimationEnd(View view) {
        ViewPropertyAnimatorCompatSet unused = this.f16953a.f17001K = null;
        boolean unused2 = this.f16953a.f17005O = true;
        ViewCompat.setTranslationY(this.f16953a.f17026s, 0.0f);
        if (this.f16953a.f17029v != null) {
            ViewCompat.setTranslationY(this.f16953a.f17029v, 0.0f);
        }
        this.f16953a.f17026s.requestLayout();
    }
}
