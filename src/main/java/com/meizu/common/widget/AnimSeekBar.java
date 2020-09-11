package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.meizu.common.R;

public class AnimSeekBar extends SkipPosSeekBar implements GestureDetector.OnGestureListener {

    /* renamed from: A */
    private int f4607A;

    /* renamed from: B */
    private String f4608B;

    /* renamed from: C */
    private int f4609C;

    /* renamed from: D */
    private int f4610D;

    /* renamed from: E */
    private int f4611E;

    /* renamed from: F */
    private Rect f4612F;

    /* renamed from: G */
    private Paint f4613G;

    /* renamed from: H */
    private Resources f4614H;

    /* renamed from: I */
    private GestureDetector f4615I;

    /* renamed from: J */
    private ValueAnimator f4616J;

    /* renamed from: K */
    private ValueAnimator f4617K;

    /* renamed from: L */
    private ValueAnimator f4618L;

    /* renamed from: d */
    private float f4619d;

    /* renamed from: e */
    private Interpolator f4620e;

    /* renamed from: f */
    private Interpolator f4621f;

    /* renamed from: g */
    private Interpolator f4622g;

    /* renamed from: h */
    private Interpolator f4623h;

    /* renamed from: i */
    private int f4624i;

    /* renamed from: j */
    private int f4625j;

    /* renamed from: k */
    private int f4626k;

    /* renamed from: l */
    private int f4627l;

    /* renamed from: m */
    private float f4628m;

    /* renamed from: n */
    private float f4629n;

    /* renamed from: o */
    private float f4630o;

    /* renamed from: p */
    private int f4631p;

    /* renamed from: q */
    private boolean f4632q;

    /* renamed from: r */
    private boolean f4633r;

    /* renamed from: s */
    private boolean f4634s;

    /* renamed from: t */
    private float f4635t;

    /* renamed from: u */
    private float f4636u;

    /* renamed from: v */
    private Drawable f4637v;

    /* renamed from: w */
    private Drawable f4638w;

    /* renamed from: x */
    private Drawable f4639x;

    /* renamed from: y */
    private int f4640y;

    /* renamed from: z */
    private int f4641z;

    public AnimSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_AnimSeekBarStyle);
    }

    public AnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4619d = 0.0f;
        this.f4625j = 0;
        this.f4628m = 0.0f;
        this.f4630o = 0.0f;
        this.f4632q = false;
        this.f4633r = false;
        this.f4634s = false;
        this.f4609C = 500;
        this.f4612F = new Rect();
        this.f4615I = null;
        m5233a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5233a(Context context, AttributeSet attributeSet, int i) {
        this.f4614H = context.getResources();
        this.f4615I = new GestureDetector(context, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimSeekBar, i, 0);
        this.f4637v = obtainStyledAttributes.getDrawable(R.styleable.AnimSeekBar_mcLargeCircleDrawble);
        this.f4640y = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcLargeCircleRadis, 15.0f);
        this.f4607A = obtainStyledAttributes.getColor(R.styleable.AnimSeekBar_mcTextNumberColor, -1);
        this.f4641z = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcDistanceToCircle, this.f4614H.getDisplayMetrics().density * 10.0f);
        this.f4611E = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcTextNumberSize, 14.0f);
        this.f4626k = (int) TypedValue.applyDimension(1, 24.0f, this.f4614H.getDisplayMetrics());
        this.f4610D = (int) TypedValue.applyDimension(1, 65.0f, this.f4614H.getDisplayMetrics());
        this.f4613G = new Paint();
        this.f4613G.setColor(this.f4607A);
        this.f4613G.setAntiAlias(true);
        this.f4613G.setTextSize((float) this.f4611E);
        this.f4613G.setTypeface(Typeface.create("sans-serif-medium", 0));
        obtainStyledAttributes.recycle();
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, this.f4614H.getDisplayMetrics()));
        this.f4613G.getTextBounds("100", 0, "100".length(), this.f4612F);
        if (this.f4612F.width() >= (this.f4640y - round) * 2) {
            this.f4640y = Math.round((((float) this.f4612F.width()) / 2.0f) + ((float) round));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4620e = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
            this.f4621f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            this.f4622g = new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
            this.f4623h = new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);
            return;
        }
        this.f4620e = new AccelerateInterpolator();
        this.f4621f = new AccelerateInterpolator();
        this.f4622g = new AccelerateInterpolator();
        this.f4623h = new AccelerateInterpolator();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        this.f4631p = Math.round(((float) ((this.f4640y * 2) + this.f4641z + this.f4626k + getPaddingTop() + getPaddingBottom())) + (((float) this.f4639x.getIntrinsicHeight()) / 2.0f));
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                size = this.f4609C;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            i3 = this.f4631p;
        } else if (mode2 != 1073741824) {
            i3 = this.f4631p;
        } else if (size2 <= this.f4610D) {
            i3 = this.f4610D;
            this.f4640y = (int) TypedValue.applyDimension(1, 15.0f, this.f4614H.getDisplayMetrics());
            this.f4641z = (int) TypedValue.applyDimension(1, 10.0f, this.f4614H.getDisplayMetrics());
        } else {
            i3 = this.f4631p;
        }
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4638w = getProgressDrawable();
        if (this.f4639x != null && this.f4638w != null) {
            this.f4624i = this.f4639x.getIntrinsicWidth() / 2;
            this.f4628m = (float) this.f4624i;
            this.f4630o = (float) this.f4624i;
            this.f4629n = (float) this.f4639x.getIntrinsicHeight();
            this.f4619d = (float) this.f4624i;
            setmY((float) this.f4638w.getBounds().centerY());
            this.f4631p = (int) (((float) (this.f4640y + this.f4641z + this.f4626k + getPaddingTop() + getPaddingBottom())) + this.f4629n);
            if (this.f4631p != getHeight()) {
                requestLayout();
            }
        }
    }

    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        this.f4639x = drawable;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        canvas.translate(0.0f, (((float) (this.f4631p / 2)) - this.f4629n) - ((float) getPaddingBottom()));
        canvas.save();
        if (!(this.f4639x == null || this.f4637v == null)) {
            if (Build.VERSION.SDK_INT <= 21) {
                this.f4636u = (float) this.f4639x.getBounds().centerX();
            } else {
                this.f4636u = (float) ((this.f4639x.getBounds().centerX() + getPaddingLeft()) - (this.f4639x.getIntrinsicWidth() / 2));
            }
            this.f4612F.set((int) (this.f4636u - ((float) this.f4640y)), (int) (((this.f4635t - ((float) this.f4640y)) - ((float) this.f4627l)) - ((float) this.f4641z)), (int) (this.f4636u + ((float) this.f4640y)), (int) (((this.f4635t + ((float) this.f4640y)) - ((float) this.f4627l)) - ((float) this.f4641z)));
            this.f4637v.setBounds(this.f4612F);
            this.f4637v.setAlpha(this.f4625j);
            this.f4637v.draw(canvas);
            if (this.f4625j > 100) {
                this.f4608B = Integer.toString(getRealProgress());
            } else {
                this.f4608B = "";
            }
            if (this.f4608B.length() > 4) {
                this.f4608B = this.f4608B.substring(0, 4);
            }
            this.f4613G.getTextBounds(this.f4608B, 0, this.f4608B.length(), this.f4612F);
            this.f4613G.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetricsInt fontMetricsInt = this.f4613G.getFontMetricsInt();
            canvas.drawText(this.f4608B, this.f4636u, (float) (((int) ((((this.f4635t - ((float) this.f4627l)) - ((float) this.f4641z)) - ((float) ((fontMetricsInt.bottom - fontMetricsInt.top) / 2))) - ((float) fontMetricsInt.top))) - (((int) getResources().getDisplayMetrics().density) / 2)), this.f4613G);
        }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        this.f4615I.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (this.f4633r) {
                    return true;
                }
                m5232a(motionEvent.getX(), motionEvent.getY());
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private void m5232a(float f, float f2) {
        if (this.f4632q) {
            this.f4632q = false;
        }
        m5236b();
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (getParent() == null) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        if (!this.f4632q) {
            m5231a();
            this.f4632q = true;
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f4633r = this.f4619d == this.f4628m && !this.f4632q;
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f4633r = false;
        if (!this.f4632q) {
            this.f4632q = true;
            m5231a();
        } else {
            this.f4616J.end();
            this.f4619d = this.f4630o;
        }
        invalidate();
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f4633r = false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f4639x == null) {
            return true;
        }
        m5236b();
        invalidate();
        return true;
    }

    /* renamed from: a */
    private void m5231a() {
        this.f4616J = ValueAnimator.ofFloat(new float[]{(float) this.f4624i, (float) this.f4624i});
        this.f4616J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4616J.setInterpolator(this.f4620e);
        this.f4616J.setDuration(166);
        this.f4616J.start();
        this.f4617K = ValueAnimator.ofInt(new int[]{0, 255});
        this.f4617K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setFadeValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4617K.setInterpolator(this.f4621f);
        this.f4617K.setDuration(166);
        this.f4617K.start();
        this.f4618L = ValueAnimator.ofInt(new int[]{0, this.f4626k});
        this.f4618L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setMoveValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4618L.setDuration(166);
        this.f4618L.setInterpolator(this.f4622g);
        this.f4618L.start();
    }

    /* renamed from: b */
    private void m5236b() {
        this.f4616J = ValueAnimator.ofFloat(new float[]{(float) this.f4624i, (float) this.f4624i});
        this.f4616J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4616J.setInterpolator(this.f4620e);
        this.f4616J.setDuration(166);
        this.f4616J.start();
        this.f4617K = ValueAnimator.ofInt(new int[]{255, 0});
        this.f4617K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setFadeValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4617K.setInterpolator(this.f4621f);
        this.f4617K.setDuration(166);
        this.f4617K.start();
        this.f4618L = ValueAnimator.ofInt(new int[]{this.f4626k, 0});
        this.f4618L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setMoveValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.f4618L.setDuration(166);
        this.f4618L.setInterpolator(this.f4623h);
        this.f4618L.start();
    }

    public void setTextNumberColor(int i) {
        if (this.f4607A != i) {
            this.f4607A = i;
            this.f4613G.setColor(this.f4607A);
            postInvalidate();
        }
    }

    public void setTextNumberSize(int i) {
        Context context = getContext();
        if (this.f4614H == null) {
            this.f4614H = Resources.getSystem();
        } else {
            this.f4614H = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(2, (float) i, this.f4614H.getDisplayMetrics());
        if (applyDimension != this.f4611E) {
            this.f4611E = applyDimension;
            this.f4613G.setTextSize((float) this.f4611E);
            requestLayout();
        }
        invalidate();
    }

    public void setLargeCircleDrawble(Drawable drawable) {
        int i;
        if (this.f4637v != drawable) {
            int width = this.f4637v.getBounds().width();
            int height = this.f4637v.getBounds().height();
            this.f4637v = drawable;
            int i2 = -1;
            if (drawable != null) {
                i2 = drawable.getBounds().width();
                i = drawable.getBounds().height();
            } else {
                i = -1;
            }
            if (!(width == i2 && height == i)) {
                requestLayout();
            }
            invalidate();
        }
    }

    public void setLargeCircleRadis(int i) {
        Context context = getContext();
        if (this.f4614H == null) {
            this.f4614H = Resources.getSystem();
        } else {
            this.f4614H = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, (float) i, this.f4614H.getDisplayMetrics());
        if (this.f4640y != i) {
            this.f4640y = applyDimension;
            requestLayout();
        }
        invalidate();
    }

    public void setDistanceToCircle(int i) {
        Context context = getContext();
        if (this.f4614H == null) {
            this.f4614H = Resources.getSystem();
        } else {
            this.f4614H = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, (float) i, this.f4614H.getDisplayMetrics());
        if (i != this.f4641z) {
            this.f4641z = applyDimension;
            this.f4634s = true;
            requestLayout();
        }
        invalidate();
    }

    public Drawable getLargeCircleDrawble() {
        if (this.f4637v != null) {
            return this.f4637v;
        }
        return null;
    }

    public int getTextNumberColor() {
        return this.f4607A;
    }

    public int getTextNumberSize() {
        return this.f4611E;
    }

    public int getDistanceToCircle() {
        return this.f4641z;
    }

    public int getLargeCircleRadius() {
        return this.f4640y;
    }

    private void setmY(float f) {
        this.f4635t = f;
    }

    /* access modifiers changed from: private */
    public void setFadeValue(int i) {
        this.f4625j = i;
    }

    /* access modifiers changed from: private */
    public void setMoveValue(int i) {
        this.f4627l = i;
    }

    /* access modifiers changed from: private */
    public void setSize(float f) {
        this.f4619d = (float) ((int) f);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AnimSeekBar.class.getName());
    }
}
