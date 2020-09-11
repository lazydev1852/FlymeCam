package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;

public class SubscribeButton extends Button {

    /* renamed from: D */
    private static final int[] f6177D = {16842919};

    /* renamed from: k */
    private static float f6178k = 0.0f;

    /* renamed from: l */
    private static float f6179l = 1.0f;

    /* renamed from: A */
    private int f6180A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f6181B;

    /* renamed from: C */
    private boolean f6182C;

    /* renamed from: a */
    boolean f6183a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f6184b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f6185c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f6186d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f6187e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f6188f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f6189g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f6190h;

    /* renamed from: i */
    private int f6191i;

    /* renamed from: j */
    private ValueAnimator f6192j;

    /* renamed from: m */
    private Drawable f6193m;

    /* renamed from: n */
    private Drawable f6194n;

    /* renamed from: o */
    private int f6195o;

    /* renamed from: p */
    private float f6196p;

    /* renamed from: q */
    private Rect f6197q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Rect f6198r;

    /* renamed from: s */
    private Rect f6199s;

    /* renamed from: t */
    private TextPaint f6200t;

    /* renamed from: u */
    private TextPaint f6201u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Interpolator f6202v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Interpolator f6203w;

    /* renamed from: x */
    private String f6204x;

    /* renamed from: y */
    private String f6205y;

    /* renamed from: z */
    private int f6206z;

    public SubscribeButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubscribeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SubscribeButtonStyle);
    }

    public SubscribeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6183a = false;
        this.f6184b = 0.0f;
        this.f6185c = 0.0f;
        this.f6186d = 0;
        this.f6187e = 0;
        this.f6188f = 0;
        this.f6189g = 0;
        this.f6190h = 0;
        this.f6192j = null;
        this.f6196p = 15.0f;
        this.f6181B = false;
        this.f6182C = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SubscribeButton, i, 0);
        this.f6193m = obtainStyledAttributes.getDrawable(R.styleable.SubscribeButton_mcBtnNormalBg);
        this.f6194n = obtainStyledAttributes.getDrawable(R.styleable.SubscribeButton_mcBtnBeAddedBg);
        this.f6196p = obtainStyledAttributes.getDimension(R.styleable.SubscribeButton_mcBtnSubTextSize, 15.0f);
        this.f6205y = obtainStyledAttributes.getString(R.styleable.SubscribeButton_mcBtnBeAddedText);
        this.f6204x = obtainStyledAttributes.getString(R.styleable.SubscribeButton_mcBtnNormalText);
        this.f6206z = obtainStyledAttributes.getColor(R.styleable.SubscribeButton_mcBtnBeAddedTextColor, ViewCompat.MEASURED_STATE_MASK);
        this.f6180A = obtainStyledAttributes.getColor(R.styleable.SubscribeButton_mcBtnNormalTextColor, -1);
        this.f6195o = obtainStyledAttributes.getInteger(R.styleable.SubscribeButton_mcBtnAnimDuration, 320);
        if (this.f6193m == null) {
            this.f6193m = getResources().getDrawable(R.drawable.mc_btn_list_default_alpha_normal);
        }
        if (this.f6193m != null) {
            this.f6193m.setCallback(this);
            this.f6193m.setState(new int[]{16842910, 16842919});
        }
        if (this.f6194n == null) {
            this.f6194n = getResources().getDrawable(R.drawable.mc_btn_list_default_pressed);
        }
        if (this.f6194n != null) {
            this.f6194n.setCallback(this);
            this.f6194n.setState(new int[]{16842910, 16842919});
        }
        obtainStyledAttributes.recycle();
        m6160a();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6193m || drawable == this.f6194n;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f6193m != null) {
            this.f6193m.jumpToCurrentState();
        }
        if (this.f6194n != null) {
            this.f6194n.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f6182C) {
            mergeDrawableStates(onCreateDrawableState, f6177D);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f6193m != null) {
            this.f6193m.setState(drawableState);
        }
        if (this.f6194n != null) {
            this.f6194n.setState(drawableState);
        }
        invalidate();
    }

    /* renamed from: a */
    private void m6160a() {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f6196p);
        paint.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f6200t = new TextPaint(paint);
        this.f6200t.setColor(this.f6180A);
        this.f6201u = new TextPaint(paint);
        this.f6201u.setColor(this.f6206z);
        this.f6197q = new Rect();
        this.f6198r = new Rect();
        this.f6199s = new Rect();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6202v = new PathInterpolator(0.18f, 0.7f, 0.05f, 1.0f);
            this.f6203w = new PathInterpolator(0.2f, 0.46f, 0.08f, 1.0f);
            return;
        }
        this.f6202v = new LinearInterpolator();
        this.f6203w = new LinearInterpolator();
    }

    private void setNormalAlpha(float f) {
        this.f6184b = f;
    }

    private float getNormalAlpha() {
        return this.f6184b;
    }

    /* renamed from: a */
    public int mo17402a(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 11) {
            switch (actionMasked) {
                case 0:
                    if (this.f6192j != null) {
                        this.f6192j.end();
                    }
                    this.f6182C = true;
                    break;
                case 1:
                case 2:
                case 3:
                    this.f6182C = false;
                    break;
                default:
                    this.f6182C = false;
                    break;
            }
        } else {
            this.f6182C = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = this.f6200t.getFontMetrics();
        int paddingBottom = (int) ((fontMetrics.bottom - fontMetrics.top) + ((float) getPaddingBottom()) + ((float) getPaddingTop()));
        int max = Math.max(mo17402a((Paint) this.f6200t, this.f6204x), (getMinWidth() - getPaddingLeft()) - getPaddingRight());
        int max2 = Math.max(mo17402a((Paint) this.f6201u, this.f6205y), (getMinWidth() - getPaddingLeft()) - getPaddingRight());
        int max3 = Math.max(max, max2) + getPaddingLeft() + getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = max3;
        }
        if (mode2 != Integer.MIN_VALUE) {
            paddingBottom = (mode2 == 1073741824 || mode == 0) ? size2 : 0;
        }
        setMeasuredDimension(size, paddingBottom);
        this.f6188f = max2 - max;
        m6166b();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6197q.set(0, 0, i, i2);
        Paint.FontMetricsInt fontMetricsInt = this.f6200t.getFontMetricsInt();
        this.f6191i = (this.f6197q.centerY() - ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.top;
        this.f6194n.setBounds(this.f6197q);
        this.f6193m.setBounds(this.f6197q);
        this.f6186d = i;
        this.f6187e = i2;
        m6166b();
    }

    /* renamed from: b */
    private void m6166b() {
        this.f6199s.set(Math.abs(this.f6188f), 0, this.f6186d - 1, this.f6187e - 1);
        if (this.f6183a) {
            if (this.f6188f > 0) {
                this.f6198r.set(0, 0, this.f6186d - 1, getHeight() - 1);
            } else {
                this.f6198r.set(Math.abs(this.f6188f), 0, this.f6186d - 1, this.f6187e - 1);
            }
            this.f6184b = 0.0f;
            this.f6185c = 1.0f;
            return;
        }
        if (this.f6188f < 0) {
            this.f6198r.set(0, 0, this.f6186d - 1, this.f6187e - 1);
        } else {
            this.f6198r.set(Math.abs(this.f6188f), 0, this.f6186d - 1, this.f6187e - 1);
        }
        this.f6184b = 1.0f;
        this.f6185c = 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f6200t.setAlpha((int) (this.f6184b * 255.0f));
        this.f6201u.setAlpha((int) (this.f6185c * 255.0f));
        this.f6193m.setAlpha((int) (this.f6184b * 255.0f));
        this.f6193m.setBounds(this.f6198r);
        this.f6193m.draw(canvas);
        this.f6194n.setAlpha((int) (this.f6185c * 255.0f));
        this.f6194n.setBounds(this.f6198r);
        this.f6194n.draw(canvas);
        String str = (String) TextUtils.ellipsize(this.f6204x, this.f6200t, (float) ((getWidth() - getPaddingRight()) - getPaddingLeft()), TextUtils.TruncateAt.END);
        String str2 = (String) TextUtils.ellipsize(this.f6205y, this.f6201u, (float) ((getWidth() - getPaddingRight()) - getPaddingLeft()), TextUtils.TruncateAt.END);
        if (this.f6197q != null) {
            canvas.save();
            canvas.clipRect(this.f6198r);
            if (this.f6188f > 0) {
                canvas.drawText(str, (float) this.f6199s.centerX(), (float) this.f6191i, this.f6200t);
                canvas.drawText(str2, (float) this.f6197q.centerX(), (float) this.f6191i, this.f6201u);
            } else {
                canvas.drawText(str, (float) this.f6197q.centerX(), (float) this.f6191i, this.f6200t);
                canvas.drawText(str2, (float) this.f6199s.centerX(), (float) this.f6191i, this.f6201u);
            }
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    public boolean performClick() {
        if (!this.f6181B) {
            this.f6183a = !this.f6183a;
            m6161a(0.0f, 1.0f, this.f6195o);
        }
        return super.performClick();
    }

    /* renamed from: a */
    private void m6161a(float f, float f2, int i) {
        this.f6192j = ValueAnimator.ofFloat(new float[]{f, f2});
        this.f6192j.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = SubscribeButton.this.f6181B = true;
            }

            public void onAnimationEnd(Animator animator) {
                boolean unused = SubscribeButton.this.f6181B = false;
            }

            public void onAnimationCancel(Animator animator) {
                boolean unused = SubscribeButton.this.f6181B = false;
            }
        });
        this.f6192j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SubscribeButton.this.f6183a) {
                    float unused = SubscribeButton.this.f6185c = SubscribeButton.this.f6202v.getInterpolation(floatValue);
                    float unused2 = SubscribeButton.this.f6184b = 1.0f - SubscribeButton.this.f6185c;
                    if (SubscribeButton.this.f6188f < 0) {
                        int unused3 = SubscribeButton.this.f6189g = (int) (SubscribeButton.this.f6203w.getInterpolation(floatValue) * ((float) Math.abs(SubscribeButton.this.f6188f)));
                        SubscribeButton.this.f6198r.set(SubscribeButton.this.f6189g, 0, SubscribeButton.this.f6186d - 1, SubscribeButton.this.f6187e - 1);
                    } else {
                        int unused4 = SubscribeButton.this.f6190h = (int) (SubscribeButton.this.f6203w.getInterpolation(floatValue) * ((float) SubscribeButton.this.f6188f));
                        SubscribeButton.this.f6198r.set(SubscribeButton.this.f6188f - SubscribeButton.this.f6190h, 0, SubscribeButton.this.f6186d - 1, SubscribeButton.this.f6187e - 1);
                    }
                } else {
                    float unused5 = SubscribeButton.this.f6184b = SubscribeButton.this.f6202v.getInterpolation(floatValue);
                    float unused6 = SubscribeButton.this.f6185c = 1.0f - SubscribeButton.this.f6184b;
                    if (SubscribeButton.this.f6188f < 0) {
                        int unused7 = SubscribeButton.this.f6190h = (int) (SubscribeButton.this.f6203w.getInterpolation(floatValue) * ((float) Math.abs(SubscribeButton.this.f6188f)));
                        SubscribeButton.this.f6198r.set(Math.abs(SubscribeButton.this.f6188f) - SubscribeButton.this.f6190h, 0, SubscribeButton.this.f6186d - 1, SubscribeButton.this.f6187e - 1);
                    } else {
                        int unused8 = SubscribeButton.this.f6189g = (int) (SubscribeButton.this.f6203w.getInterpolation(floatValue) * ((float) SubscribeButton.this.f6188f));
                        SubscribeButton.this.f6198r.set(SubscribeButton.this.f6189g, 0, SubscribeButton.this.f6186d - 1, SubscribeButton.this.f6187e - 1);
                    }
                }
                SubscribeButton.this.invalidate();
            }
        });
        this.f6192j.setDuration((long) i);
        this.f6192j.start();
    }

    public void setBtnBeAddedText(String str) {
        String str2 = this.f6205y;
        this.f6205y = str;
        if (this.f6201u.measureText(str2) != this.f6201u.measureText(this.f6205y)) {
            requestLayout();
        }
        invalidate();
    }

    public String getBtnBeAddedText() {
        return this.f6205y;
    }

    public void setBtnNormalText(String str) {
        String str2 = this.f6204x;
        this.f6204x = str;
        if (this.f6200t.measureText(str2) != this.f6200t.measureText(this.f6204x)) {
            requestLayout();
        }
        invalidate();
    }

    public String getBtnNormalText() {
        return this.f6204x;
    }

    public void setBtnBeAddedTextColor(int i) {
        this.f6201u.setColor(i);
        invalidate();
    }

    public int getBtnBeAddedTextColor() {
        return this.f6201u.getColor();
    }

    public void setBtnNormalTextColor(int i) {
        this.f6200t.setColor(i);
        invalidate();
    }

    public int getBtnNormalTextColor() {
        return this.f6200t.getColor();
    }

    public void setBtnSubTextSize(int i) {
        float f = (float) i;
        this.f6200t.setTextSize(f);
        this.f6201u.setTextSize(f);
        if (this.f6197q != null) {
            Paint.FontMetricsInt fontMetricsInt = this.f6200t.getFontMetricsInt();
            this.f6191i = (this.f6197q.centerY() - ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.top;
        }
        invalidate();
    }

    public void setAnimDuration(int i) {
        this.f6195o = i;
    }

    public void setSelectedable(boolean z) {
        if (this.f6183a != z) {
            this.f6183a = z;
            m6166b();
            invalidate();
        }
    }

    public boolean getSelectedState() {
        return this.f6183a;
    }

    public void setAnimating(boolean z) {
        this.f6181B = z;
    }

    public void setNormalDrawble(int i) {
        if (i != 0) {
            this.f6193m = getResources().getDrawable(i);
            invalidate();
        }
    }

    public void setNormalDrawble(Drawable drawable) {
        if (drawable != null) {
            this.f6193m = drawable;
            invalidate();
        }
    }

    public void setBeAddedDrawble(Drawable drawable) {
        if (drawable != null) {
            this.f6194n = drawable;
            invalidate();
        }
    }

    public void setBeAddedDrawble(int i) {
        if (i != 0) {
            this.f6194n = getResources().getDrawable(i);
            invalidate();
        }
    }

    public Drawable getNormalDrawble() {
        return this.f6193m;
    }

    public Drawable getBeAddedDrawble() {
        return this.f6194n;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SubscribeButton.class.getName());
    }
}
