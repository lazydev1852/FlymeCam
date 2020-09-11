package com.meizu.sharewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.sharewidget.R;

public class ItemTextView extends TextView {

    /* renamed from: a */
    private int f15966a = -1;

    /* renamed from: b */
    private int f15967b = -1;

    public View getTargetView() {
        return this;
    }

    public ItemTextView(Context context) {
        super(context);
    }

    public ItemTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ItemTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStyle(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.IntentChooserView);
        setTextColor(obtainStyledAttributes.getColor(R.styleable.IntentChooserView_itemTxtColor, -1));
        obtainStyledAttributes.recycle();
    }
}
