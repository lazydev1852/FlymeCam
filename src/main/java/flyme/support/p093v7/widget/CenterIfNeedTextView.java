package flyme.support.p093v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;

/* renamed from: flyme.support.v7.widget.CenterIfNeedTextView */
public class CenterIfNeedTextView extends AppCompatTextView {
    public CenterIfNeedTextView(Context context) {
        super(context);
    }

    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterIfNeedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(GravityCompat.START);
            }
            super.onMeasure(i, i2);
        }
    }
}
