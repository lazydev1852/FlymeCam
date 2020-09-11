package flyme.support.p093v7.widget;

import android.graphics.Outline;
import androidx.annotation.NonNull;

/* renamed from: flyme.support.v7.widget.b */
public class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(@NonNull Outline outline) {
        if (this.f18415a.f17383d) {
            if (this.f18415a.f17382c != null) {
                this.f18415a.f17382c.getOutline(outline);
            }
        } else if (this.f18415a.f17380a != null) {
            this.f18415a.f17380a.getOutline(outline);
        }
    }
}
