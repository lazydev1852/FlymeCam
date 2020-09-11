package com.meizu.share.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class RectClipView extends LinearLayout {

    /* renamed from: a */
    private Rect f15830a = new Rect();

    public RectClipView(Context context) {
        super(context);
    }

    public RectClipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RectClipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.clipRect(this.f15830a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setClipRect(int i, int i2, int i3, int i4) {
        this.f15830a.set(i, i2, i3, i4);
        invalidate();
    }
}
