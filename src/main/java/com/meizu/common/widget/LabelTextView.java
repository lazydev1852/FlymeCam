package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.meizu.common.R;

public class LabelTextView extends TextView {

    /* renamed from: a */
    private int f5550a;

    /* renamed from: b */
    private int f5551b;

    /* renamed from: c */
    private Drawable f5552c;

    /* renamed from: d */
    private GradientDrawable f5553d;

    public LabelTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_LabelTextViewStyle);
    }

    public LabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelTextView, i, 0);
        this.f5551b = obtainStyledAttributes.getColor(R.styleable.LabelTextView_mcBackgroundColor, context.getResources().getColor(R.color.mc_label_text_view_default_background_color));
        this.f5552c = obtainStyledAttributes.getDrawable(R.styleable.LabelTextView_mcImage);
        this.f5550a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelTextView_mcCornorRadius, context.getResources().getDimensionPixelOffset(R.dimen.mc_label_text_view_cornor_radius));
        obtainStyledAttributes.recycle();
        m5851a();
        setImage(this.f5552c);
    }

    /* renamed from: a */
    private void m5851a() {
        if (this.f5553d == null) {
            this.f5553d = new GradientDrawable();
        }
        this.f5553d.setColor(this.f5551b);
        this.f5553d.setCornerRadius((float) this.f5550a);
        setBackgroundDrawable(this.f5553d);
    }

    public void setBackgroundColor(int i) {
        this.f5551b = i;
        m5851a();
    }

    public void setCornorRadius(int i) {
        this.f5550a = i;
        m5851a();
    }

    public void setImage(Drawable drawable) {
        if (drawable != null) {
            this.f5552c = drawable;
            setText("");
            setBackgroundDrawable(drawable);
        }
    }

    public int getBackgroundColor() {
        return this.f5551b;
    }

    public int getCornorRadius() {
        return this.f5550a;
    }

    public Drawable getImage() {
        return this.f5552c;
    }
}
