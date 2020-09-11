package com.meizu.common.datetimepicker.date;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {

    /* renamed from: a */
    private final Typeface f4139a;

    public void updateDrawState(TextPaint textPaint) {
        m4862a(textPaint, this.f4139a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m4862a(textPaint, this.f4139a);
    }

    /* renamed from: a */
    private static void m4862a(Paint paint, Typeface typeface) {
        int i;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i = 0;
        } else {
            i = typeface2.getStyle();
        }
        int i2 = i & (~typeface.getStyle());
        if ((i2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }
}
