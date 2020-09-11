package flyme.support.p093v7.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ScrollView;

/* renamed from: flyme.support.v7.widget.LimitingHeightScrollView */
public class LimitingHeightScrollView extends ScrollView {

    /* renamed from: a */
    private Context f17631a;

    public LimitingHeightScrollView(Context context) {
        super(context);
        m19256a(context);
    }

    public LimitingHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19256a(context);
    }

    public LimitingHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19256a(context);
    }

    /* renamed from: a */
    private void m19256a(Context context) {
        this.f17631a = context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        try {
            Display defaultDisplay = ((Activity) this.f17631a).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) displayMetrics.heightPixels) * 0.33d), Integer.MIN_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(i, i2);
    }
}
