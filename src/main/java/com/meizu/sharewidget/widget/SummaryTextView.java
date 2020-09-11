package com.meizu.sharewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.sharewidget.R;

public class SummaryTextView extends TextView {

    /* renamed from: a */
    private int f15971a = -1;

    /* renamed from: b */
    private int f15972b = -1;

    public View getTargetView() {
        return this;
    }

    public SummaryTextView(Context context) {
        super(context);
    }

    public SummaryTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SummaryTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStyle(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.IntentChooserView);
        setTextColor(obtainStyledAttributes.getColor(R.styleable.IntentChooserView_summaryColor, -1));
        obtainStyledAttributes.recycle();
    }
}
