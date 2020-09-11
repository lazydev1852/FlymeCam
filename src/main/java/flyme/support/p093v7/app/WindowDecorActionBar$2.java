package flyme.support.p093v7.app;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: flyme.support.v7.app.WindowDecorActionBar$2 */
class WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ WindowDecorActionBar f16951a;

    WindowDecorActionBar$2(WindowDecorActionBar fVar) {
        this.f16951a = fVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f16951a.f17029v != null) {
            ViewCompat.setTranslationY(this.f16951a.f17029v, 0.0f);
            boolean unused = this.f16951a.f17005O = true;
        }
        ViewPropertyAnimatorCompatSet unused2 = this.f16951a.f17001K = null;
    }
}
