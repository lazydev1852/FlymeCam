package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: flyme.support.v7.widget.LimitedWHLinearLayout */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a */
    private int f17629a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: b */
    private int f17630b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LimitedWHLinearLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredHeight > this.f17629a) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f17629a, 1073741824);
            z = true;
        } else {
            z = false;
        }
        if (measuredWidth > this.f17630b) {
            i = View.MeasureSpec.makeMeasureSpec(this.f17630b, 1073741824);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxHeight(int i) {
        this.f17629a = i;
    }

    public int getMaxHeight() {
        return this.f17629a;
    }

    public void setMaxWidth(int i) {
        this.f17630b = i;
    }

    public int getMaxWidth() {
        return this.f17630b;
    }
}
