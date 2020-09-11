package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class CircleProgressBar extends View {

    /* renamed from: a */
    private int f4740a;

    /* renamed from: b */
    private int f4741b;

    /* renamed from: c */
    private int f4742c;

    /* renamed from: d */
    private float f4743d;

    /* renamed from: e */
    private int f4744e;

    /* renamed from: f */
    private int f4745f;

    /* renamed from: g */
    private Paint f4746g;

    /* renamed from: h */
    private Paint f4747h;

    /* renamed from: i */
    private Paint f4748i;

    /* renamed from: j */
    private RectF f4749j;

    /* renamed from: k */
    private int f4750k;

    /* renamed from: l */
    private int f4751l;

    /* renamed from: m */
    private String f4752m;

    /* renamed from: n */
    private int f4753n;

    /* renamed from: o */
    private boolean f4754o;

    /* renamed from: p */
    private boolean f4755p;

    public CircleProgressBar(Context context) {
        super(context, (AttributeSet) null);
        this.f4742c = 0;
        this.f4746g = new Paint();
        this.f4747h = new Paint();
        this.f4748i = new Paint();
        this.f4749j = new RectF();
        this.f4750k = 0;
        this.f4752m = "0%";
        this.f4753n = 0;
        this.f4754o = false;
        this.f4755p = true;
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4742c = 0;
        this.f4746g = new Paint();
        this.f4747h = new Paint();
        this.f4748i = new Paint();
        this.f4749j = new RectF();
        this.f4750k = 0;
        this.f4752m = "0%";
        this.f4753n = 0;
        this.f4754o = false;
        this.f4755p = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar, i, 0);
        this.f4744e = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCircleBarColor, -15102483);
        this.f4745f = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCircleBarRimColor, 201326592);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4743d = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_mcCircleBarWidth, (int) (displayMetrics.density * 3.0f));
        this.f4750k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_mcCenterTextSize, (int) (displayMetrics.density * 14.0f));
        this.f4751l = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCenterTextColor, -1);
        this.f4755p = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_mcCircleIsShowProgress, this.f4755p);
        setMax(obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_mcCircleBarMax, 0));
        setProgress(obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_mcCircleBarProgress, 0));
        obtainStyledAttributes.recycle();
        m5297a();
    }

    /* renamed from: a */
    private void m5297a() {
        m5298b();
        m5299c();
        this.f4742c = m5296a(this.f4741b, true);
        this.f4753n = m5296a(this.f4741b, false);
        this.f4752m = String.valueOf(this.f4753n) + "%";
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4754o) {
            m5298b();
            this.f4754o = false;
        }
        canvas.drawArc(this.f4749j, 360.0f, 360.0f, false, this.f4747h);
        canvas.drawArc(this.f4749j, (float) (this.f4742c + 90), (float) (this.f4742c * -2), false, this.f4746g);
        float descent = ((this.f4748i.descent() - this.f4748i.ascent()) / 2.0f) - this.f4748i.descent();
        float measureText = this.f4748i.measureText(this.f4752m) / 2.0f;
        if (this.f4755p) {
            canvas.drawText(this.f4752m, ((float) (getWidth() / 2)) - measureText, ((float) (getHeight() / 2)) + descent, this.f4748i);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4754o = true;
    }

    /* renamed from: b */
    private void m5298b() {
        if (this.f4749j == null) {
            this.f4749j = new RectF();
        }
        this.f4749j.left = ((float) getPaddingLeft()) + this.f4743d;
        this.f4749j.top = ((float) getPaddingTop()) + this.f4743d;
        this.f4749j.right = ((float) (getWidth() - getPaddingRight())) - this.f4743d;
        this.f4749j.bottom = ((float) (getHeight() - getPaddingBottom())) - this.f4743d;
    }

    /* renamed from: c */
    private void m5299c() {
        if (this.f4746g == null) {
            this.f4746g = new Paint();
        }
        this.f4746g.setColor(this.f4744e);
        this.f4746g.setAntiAlias(true);
        this.f4746g.setStyle(Paint.Style.STROKE);
        this.f4746g.setStrokeWidth(this.f4743d);
        this.f4746g.setStrokeJoin(Paint.Join.ROUND);
        if (this.f4747h == null) {
            this.f4747h = new Paint();
        }
        this.f4747h.setColor(this.f4745f);
        this.f4747h.setAntiAlias(true);
        this.f4747h.setStyle(Paint.Style.STROKE);
        this.f4747h.setStrokeWidth(this.f4743d);
        if (this.f4748i == null) {
            this.f4748i = new Paint();
        }
        this.f4748i.setTextSize((float) this.f4750k);
        this.f4748i.setColor(this.f4751l);
        this.f4748i.setAntiAlias(true);
    }

    /* renamed from: a */
    private int m5296a(int i, boolean z) {
        int i2 = z ? 180 : 100;
        if (this.f4740a <= 0) {
            return 0;
        }
        if (i >= this.f4740a) {
            return i2;
        }
        return (int) ((((float) i) / ((float) this.f4740a)) * ((float) i2));
    }

    public void setProgressStatus(boolean z) {
        this.f4755p = z;
    }

    public void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f4740a) {
            this.f4740a = i;
            if (this.f4741b > i) {
                this.f4741b = i;
            }
            postInvalidate();
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.f4740a) {
            i = this.f4740a;
        }
        if (i != this.f4741b) {
            this.f4741b = i;
            this.f4742c = m5296a(this.f4741b, true);
            this.f4753n = m5296a(this.f4741b, false);
            this.f4752m = String.valueOf(this.f4753n) + "%";
            postInvalidate();
        }
    }

    public void setCircleBarColor(int i) {
        if (this.f4744e != i) {
            this.f4744e = i;
            this.f4746g.setColor(this.f4744e);
            postInvalidate();
        }
    }

    public void setCircleRimColor(int i) {
        if (this.f4745f != i) {
            this.f4745f = i;
            this.f4747h.setColor(this.f4745f);
            postInvalidate();
        }
    }

    public void setCircleBarWidth(float f) {
        if (((double) Math.abs(this.f4743d - f)) >= 1.0E-6d) {
            if (f < 0.0f) {
                this.f4743d = 0.0f;
            } else {
                this.f4743d = f;
            }
            this.f4746g.setStrokeWidth(this.f4743d);
            this.f4747h.setStrokeWidth(this.f4743d);
            this.f4754o = true;
            postInvalidate();
        }
    }

    public int getMax() {
        if (this.f4740a < 0) {
            return 0;
        }
        return this.f4740a;
    }

    public int getProgress() {
        if (this.f4741b < 0) {
            return 0;
        }
        return this.f4741b;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircleProgressBar.class.getName());
    }
}
