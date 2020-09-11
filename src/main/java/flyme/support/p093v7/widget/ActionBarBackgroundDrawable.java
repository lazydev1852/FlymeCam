package flyme.support.p093v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: flyme.support.v7.widget.a */
public class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f18415a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f18415a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f18415a.f17383d) {
            if (this.f18415a.f17381b != null && this.f18415a.f17384e) {
                this.f18415a.f17381b.draw(canvas);
            }
            if (this.f18415a.f17380a != null) {
                this.f18415a.f17380a.draw(canvas);
            }
        } else if (this.f18415a.f17382c != null) {
            this.f18415a.f17382c.draw(canvas);
        }
    }
}
