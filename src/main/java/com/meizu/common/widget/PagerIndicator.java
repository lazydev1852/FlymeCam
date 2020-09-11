package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class PagerIndicator extends View {

    /* renamed from: a */
    private int f5829a;

    /* renamed from: b */
    private int f5830b;

    /* renamed from: c */
    private int f5831c;

    /* renamed from: d */
    private float f5832d;

    /* renamed from: e */
    private Paint f5833e;

    /* renamed from: f */
    private boolean f5834f;

    /* renamed from: g */
    private float f5835g;

    /* renamed from: h */
    private float f5836h;

    /* renamed from: i */
    private float f5837i;

    /* renamed from: j */
    private int f5838j;

    /* renamed from: k */
    private Paint f5839k;

    /* renamed from: l */
    private int f5840l;

    /* renamed from: m */
    private int f5841m;

    /* renamed from: n */
    private int f5842n;

    /* renamed from: a */
    private float m5941a(float f, float f2, float f3, int i) {
        return i < 0 ? f2 - ((f2 - f) * f3) : f + ((f2 - f) * f3);
    }

    public PagerIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_PagerIndicator);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagerIndicator, i, 0);
        Resources resources = getResources();
        float dimension = resources.getDimension(R.dimen.mc_pager_indicator_radius);
        float dimension2 = resources.getDimension(R.dimen.mc_pager_indicator_enlarge_radius);
        float dimension3 = resources.getDimension(R.dimen.mc_pager_indicator_distance);
        int color = resources.getColor(R.color.mc_pager_indicator_fill_color);
        int color2 = resources.getColor(R.color.mc_pager_indicator_highlight_color);
        this.f5835g = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcRadius, dimension);
        this.f5836h = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcEnlargeRadius, dimension2);
        this.f5837i = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcDistance, dimension3);
        this.f5840l = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcFillColor, color);
        this.f5841m = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcHighlightColor, color2);
        this.f5842n = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcStrokeColor, color2);
        this.f5838j = obtainStyledAttributes.getInteger(R.styleable.PagerIndicator_mcGravity, 17);
        obtainStyledAttributes.recycle();
        this.f5833e = new Paint(1);
        this.f5833e.setStyle(Paint.Style.FILL);
        this.f5833e.setColor(this.f5840l);
        this.f5839k = new Paint(1);
        this.f5839k.setStyle(Paint.Style.STROKE);
        this.f5839k.setColor(this.f5842n);
    }

    public void setSnap(boolean z) {
        this.f5834f = z;
    }

    public void setCirclePosition(int i) {
        this.f5829a = i;
        this.f5830b = i;
        invalidate();
    }

    public void setCirclePosOffset(float f, int i) {
        this.f5829a = i;
        this.f5832d = f;
        invalidate();
    }

    public void setPagerCount(int i) {
        if (this.f5831c != i) {
            this.f5831c = i;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5831c != 0) {
            int i = this.f5831c;
            int width = getWidth();
            int i2 = this.f5829a;
            float f = this.f5837i;
            float f2 = this.f5836h;
            int i3 = i - 1;
            float f3 = (((float) width) / 2.0f) - ((((float) i3) * f) / 2.0f);
            float f4 = this.f5835g;
            this.f5833e.setColor(this.f5840l);
            for (int i4 = 0; i4 < i; i4++) {
                if (!(i2 == i4 || ((i2 == i3 && i4 == 0) || i4 == i2 + 1))) {
                    canvas.drawCircle((((float) i4) * f) + f3, f2, this.f5835g, this.f5833e);
                }
            }
            float f5 = (((float) (this.f5834f ? this.f5830b : i2)) * f) + f3;
            if (i2 != i3) {
                f3 = f5 + f;
            }
            int a = m5942a(this.f5840l, this.f5841m, this.f5832d, -1);
            float a2 = m5941a(this.f5835g, this.f5836h, this.f5832d, -1);
            this.f5833e.setColor(a);
            canvas.drawCircle(f5, f2, a2, this.f5833e);
            int a3 = m5942a(this.f5840l, this.f5841m, this.f5832d, 1);
            float a4 = m5941a(this.f5835g, this.f5836h, this.f5832d, 1);
            this.f5833e.setColor(a3);
            canvas.drawCircle(f3, f2, a4, this.f5833e);
        }
    }

    /* renamed from: a */
    private int m5942a(int i, int i2, float f, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        int alpha2 = Color.alpha(i2);
        if (i3 < 0) {
            i4 = Math.round(((float) red2) - (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green2) - (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue2) - (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha2) - (((float) (alpha2 - alpha)) * f));
        } else {
            i4 = Math.round(((float) red) + (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green) + (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue) + (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha) + (((float) (alpha2 - alpha)) * f));
        }
        return Color.argb(i5, i4, i7, i6);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSizeAndState(((int) ((((float) this.f5831c) * this.f5837i) + (this.f5835g * 2.0f))) + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(((int) Math.max(this.f5835g * 2.0f, this.f5836h * 2.0f)) + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PagerIndicator.class.getName());
    }
}
