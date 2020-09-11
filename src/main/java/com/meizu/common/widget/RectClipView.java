package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class RectClipView extends LinearLayout {

    /* renamed from: a */
    private Rect f5957a = new Rect();

    public RectClipView(Context context) {
        super(context);
    }

    public RectClipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RectClipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        canvas.clipRect(this.f5957a);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    public void setClipRect(int i, int i2, int i3, int i4) {
        this.f5957a.set(i, i2, i3, i4);
        invalidate();
    }
}
