package flyme.support.p093v7.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

/* renamed from: flyme.support.v7.app.WindowDecorActionBar$5 */
class WindowDecorActionBar$5 implements ViewPropertyAnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ WindowDecorActionBar f16954a;

    WindowDecorActionBar$5(WindowDecorActionBar fVar) {
        this.f16954a = fVar;
    }

    public void onAnimationUpdate(View view) {
        ((View) this.f16954a.f17026s.getParent()).invalidate();
    }
}
