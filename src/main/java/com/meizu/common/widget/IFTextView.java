package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class IFTextView extends TextView {
    public IFTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IFTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IFTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5817a(context);
    }

    /* renamed from: a */
    private void m5817a(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "iconfont.ttf"));
    }
}
