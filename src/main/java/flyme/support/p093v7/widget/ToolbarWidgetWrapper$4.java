package flyme.support.p093v7.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: flyme.support.v7.widget.ToolbarWidgetWrapper$4 */
class ToolbarWidgetWrapper$4 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ int f18399a;

    /* renamed from: b */
    final /* synthetic */ ToolbarWidgetWrapper f18400b;

    /* renamed from: c */
    private boolean f18401c = false;

    ToolbarWidgetWrapper$4(ToolbarWidgetWrapper vVar, int i) {
        this.f18400b = vVar;
        this.f18399a = i;
    }

    public void onAnimationStart(View view) {
        this.f18400b.f18591d.setVisibility(0);
    }

    public void onAnimationEnd(View view) {
        if (!this.f18401c) {
            this.f18400b.f18591d.setVisibility(this.f18399a);
            this.f18400b.f18591d.setMenuVisibility(this.f18399a);
            if (this.f18399a == 4) {
                this.f18400b.f18591d.requestLayout();
            }
        }
    }

    public void onAnimationCancel(View view) {
        this.f18401c = true;
    }
}
