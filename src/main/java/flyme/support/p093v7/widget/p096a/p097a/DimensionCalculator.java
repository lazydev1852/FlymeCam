package flyme.support.p093v7.widget.p096a.p097a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: flyme.support.v7.widget.a.a.a */
public class DimensionCalculator {
    /* renamed from: a */
    public void mo27049a(Rect rect, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            m20409a(rect, (ViewGroup.MarginLayoutParams) layoutParams);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* renamed from: a */
    private void m20409a(Rect rect, ViewGroup.MarginLayoutParams marginLayoutParams) {
        rect.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }
}
