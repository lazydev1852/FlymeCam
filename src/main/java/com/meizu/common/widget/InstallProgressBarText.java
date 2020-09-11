package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;

public class InstallProgressBarText extends View {

    /* renamed from: a */
    private int f5507a = 0;

    /* renamed from: b */
    private int f5508b = 0;

    /* renamed from: c */
    private Paint f5509c;

    /* renamed from: d */
    private int f5510d = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);

    /* renamed from: e */
    private int f5511e = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: f */
    private int f5512f = -1;

    /* renamed from: g */
    private Rect f5513g = new Rect();

    /* renamed from: h */
    private String f5514h = null;

    /* renamed from: i */
    private int f5515i;

    /* renamed from: j */
    private int f5516j;

    /* renamed from: k */
    private float f5517k;

    /* renamed from: l */
    private ObjectAnimator f5518l;

    public InstallProgressBarText(Context context) {
        super(context);
        m5839a(context, (AttributeSet) null);
    }

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5839a(context, attributeSet);
    }

    public InstallProgressBarText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5839a(context, attributeSet);
    }

    /* renamed from: a */
    private void m5839a(Context context, AttributeSet attributeSet) {
        this.f5509c = new Paint(1);
        this.f5509c.setTypeface(Typeface.create("sans-serif-medium", 0));
        m5843b(context, attributeSet);
    }

    /* renamed from: b */
    private void m5843b(Context context, AttributeSet attributeSet) {
        TypedArray a = mo16832a(context, attributeSet, R.styleable.InstallProgressBarText);
        if (a != null) {
            this.f5514h = a.getString(R.styleable.InstallProgressBarText_mcText);
            this.f5510d = a.getDimensionPixelSize(R.styleable.InstallProgressBarText_mcProgressTextSize, this.f5510d);
            this.f5511e = a.getColor(R.styleable.InstallProgressBarText_mcTextOriginColor, this.f5511e);
            this.f5512f = a.getColor(R.styleable.InstallProgressBarText_mcTextChangeColor, this.f5512f);
            this.f5517k = a.getFloat(R.styleable.InstallProgressBarText_mcTextProgress, 0.0f);
            a.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo16832a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    private void m5838a() {
        this.f5515i = (int) this.f5509c.measureText(this.f5514h);
        this.f5509c.getTextBounds(this.f5514h, 0, this.f5514h.length(), this.f5513g);
    }

    /* renamed from: a */
    private int m5836a(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i2 = this.f5513g.height() * 2;
        } else {
            i2 = mode != 1073741824 ? 0 : size;
        }
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return i2 + getPaddingTop() + getPaddingBottom();
    }

    /* renamed from: b */
    private int m5842b(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i2 = this.f5515i;
        } else {
            i2 = mode != 1073741824 ? 0 : size;
        }
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return i2 + getPaddingLeft() + getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m5838a();
        this.f5509c.setTextSize((float) this.f5510d);
        setMeasuredDimension(m5842b(i), m5836a(i2));
        this.f5516j = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f5508b = (this.f5516j / 2) - (this.f5515i / 2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m5840a(canvas);
        m5844b(canvas);
    }

    /* renamed from: a */
    private void m5841a(Canvas canvas, int i, int i2, int i3) {
        this.f5509c.setColor(i);
        canvas.save();
        canvas.clipRect(i2, 0, i3, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.f5509c.getFontMetricsInt();
        canvas.drawText(this.f5514h, (float) this.f5508b, (float) ((((getMeasuredHeight() - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) - fontMetricsInt.top), this.f5509c);
        canvas.restore();
    }

    /* renamed from: a */
    private void m5840a(Canvas canvas) {
        m5841a(canvas, this.f5512f, this.f5507a, (int) (((float) this.f5507a) + (this.f5517k * ((float) this.f5516j))));
    }

    /* renamed from: b */
    private void m5844b(Canvas canvas) {
        m5841a(canvas, this.f5511e, (int) (((float) this.f5507a) + (this.f5517k * ((float) this.f5516j))), this.f5507a + this.f5516j);
    }

    /* renamed from: a */
    private ObjectAnimator m5837a(float f) {
        if (f < this.f5517k) {
            return ObjectAnimator.ofFloat(this, "Progress", new float[]{0.0f, f}).setDuration(500);
        }
        return ObjectAnimator.ofFloat(this, "Progress", new float[]{this.f5517k, f}).setDuration(500);
    }

    public float getProgress() {
        return this.f5517k;
    }

    public void setProgress(float f) {
        this.f5517k = f;
        invalidate();
    }

    public synchronized void setAnimProgress(float f) {
        this.f5518l = m5837a(f);
        this.f5518l.start();
    }

    public void setText(String str) {
        this.f5514h = str;
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.f5514h;
    }

    public int getTextSize() {
        return this.f5510d;
    }

    public void setTextSize(int i) {
        this.f5510d = i;
        requestLayout();
        invalidate();
    }

    public int getTextOriginColor() {
        return this.f5511e;
    }

    public void setTextOriginColor(int i) {
        this.f5511e = i;
        invalidate();
    }

    public int getTextChangeColor() {
        return this.f5512f;
    }

    public void setTextChangeColor(int i) {
        this.f5512f = i;
        invalidate();
    }
}
