package com.meizu.sharewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.meizu.sharewidget.R;

public class ColorRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private int f15933a = -1;

    public View getTargetView() {
        return this;
    }

    public ColorRelativeLayout(Context context) {
        super(context);
    }

    public ColorRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStyle(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.IntentChooserView);
        setBackgroundColor(obtainStyledAttributes.getColor(R.styleable.IntentChooserView_bgColor, -1));
        obtainStyledAttributes.recycle();
    }
}
