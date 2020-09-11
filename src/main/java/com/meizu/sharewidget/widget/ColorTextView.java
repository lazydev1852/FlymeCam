package com.meizu.sharewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.sharewidget.R;

public class ColorTextView extends TextView {

    /* renamed from: a */
    private int f15934a = -1;

    /* renamed from: b */
    private int f15935b = -1;

    public View getTargetView() {
        return this;
    }

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStyle(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.IntentChooserView);
        setTextColor(obtainStyledAttributes.getColor(R.styleable.IntentChooserView_titleColor, -1));
        obtainStyledAttributes.recycle();
    }
}
