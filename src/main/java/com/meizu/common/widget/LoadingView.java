package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import com.meizu.common.R;
import com.meizu.common.drawble.CircularAnimatedDrawable;

@SuppressLint({"NewApi"})
public class LoadingView extends View {

    /* renamed from: a */
    private Paint f5686a;

    /* renamed from: b */
    private Paint f5687b;

    /* renamed from: c */
    private Paint f5688c;

    /* renamed from: d */
    private Paint f5689d;

    /* renamed from: e */
    private Context f5690e;

    /* renamed from: f */
    private Animator f5691f;

    /* renamed from: g */
    private float f5692g;

    /* renamed from: h */
    private float f5693h;

    /* renamed from: i */
    private final long f5694i;

    /* renamed from: j */
    private RectF f5695j;

    /* renamed from: k */
    private int f5696k;

    /* renamed from: l */
    private float f5697l;

    /* renamed from: m */
    private float f5698m;

    /* renamed from: n */
    private float f5699n;

    /* renamed from: o */
    private float f5700o;

    /* renamed from: p */
    private int f5701p;

    /* renamed from: q */
    private int f5702q;

    /* renamed from: r */
    private int f5703r;

    /* renamed from: s */
    private int f5704s;

    public LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_LoadingViewStyle);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5686a = null;
        this.f5687b = null;
        this.f5688c = null;
        this.f5689d = null;
        this.f5690e = null;
        this.f5691f = null;
        this.f5694i = 1760;
        this.f5695j = null;
        this.f5696k = 0;
        this.f5704s = 1;
        this.f5690e = context;
        this.f5686a = new Paint(1);
        this.f5686a.setAntiAlias(true);
        this.f5686a.setColor(-1);
        this.f5686a.setAntiAlias(true);
        this.f5686a.setTextAlign(Paint.Align.CENTER);
        this.f5686a.setTextSize(36.0f);
        TypedArray obtainStyledAttributes = this.f5690e.obtainStyledAttributes(R.styleable.MZTheme);
        this.f5701p = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, -16711936);
        this.f5703r = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel5, getResources().getColor(R.color.Blue_5));
        this.f5702q = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel1, getResources().getColor(R.color.Blue_1));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingView, R.attr.MeizuCommon_LoadingStyle, 0);
        this.f5697l = obtainStyledAttributes2.getDimension(R.styleable.LoadingView_mcLoadingRadius, 24.0f);
        this.f5698m = obtainStyledAttributes2.getDimension(R.styleable.LoadingView_mcRingWidth, 10.0f);
        this.f5702q = obtainStyledAttributes2.getColor(R.styleable.LoadingView_mcLBackground, this.f5702q);
        this.f5703r = obtainStyledAttributes2.getColor(R.styleable.LoadingView_mcLForeground, this.f5703r);
        this.f5704s = obtainStyledAttributes2.getInt(R.styleable.LoadingView_mcLoadingState, 1);
        obtainStyledAttributes2.recycle();
        this.f5687b = new Paint(1);
        this.f5687b.setAntiAlias(true);
        this.f5687b.setColor(this.f5703r);
        this.f5687b.setStyle(Paint.Style.STROKE);
        this.f5689d = new Paint(this.f5687b);
        this.f5689d.setStyle(Paint.Style.FILL);
        this.f5688c = new Paint(1);
        this.f5688c.setAntiAlias(true);
        this.f5688c.setColor(this.f5702q);
        this.f5688c.setStyle(Paint.Style.STROKE);
        this.f5687b.setStrokeWidth(this.f5698m - ((float) this.f5696k));
        this.f5688c.setStrokeWidth(this.f5698m - ((float) this.f5696k));
        m5886a();
    }

    public LoadingView(Context context, float f, float f2) {
        this(context, (AttributeSet) null);
        this.f5697l = f;
        this.f5698m = f2;
        m5886a();
    }

    /* renamed from: a */
    private void m5886a() {
        this.f5699n = getX() + ((float) getPaddingLeft()) + this.f5697l + ((float) (this.f5696k * 2)) + this.f5698m;
        this.f5700o = getY() + ((float) getPaddingTop()) + this.f5697l + ((float) (this.f5696k * 2)) + this.f5698m;
        this.f5695j = new RectF();
        this.f5695j.left = ((this.f5699n - this.f5697l) - ((float) (this.f5696k / 2))) - (this.f5698m / 2.0f);
        this.f5695j.top = ((this.f5700o - this.f5697l) - ((float) (this.f5696k / 2))) - (this.f5698m / 2.0f);
        this.f5695j.right = this.f5699n + this.f5697l + ((float) (this.f5696k / 2)) + (this.f5698m / 2.0f);
        this.f5695j.bottom = this.f5700o + this.f5697l + ((float) (this.f5696k / 2)) + (this.f5698m / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.translate((((float) (getWidth() / 2)) - this.f5697l) - this.f5698m, (((float) (getHeight() / 2)) - this.f5697l) - this.f5698m);
        if (this.f5703r == this.f5702q) {
            this.f5688c.setAlpha(26);
        }
        if (this.f5704s == 1) {
            m5887a(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    /* renamed from: a */
    private void m5887a(Canvas canvas) {
        canvas.drawArc(this.f5695j, -90.0f, 360.0f, false, this.f5688c);
        canvas.drawArc(this.f5695j, this.f5692g, this.f5693h, false, this.f5687b);
        float width = this.f5695j.width() / 2.0f;
        float height = this.f5695j.height() / 2.0f;
        float strokeWidth = this.f5687b.getStrokeWidth() / 2.0f;
        canvas.drawCircle(this.f5695j.right - (((float) (1.0d - Math.cos(Math.toRadians((double) this.f5692g)))) * width), this.f5695j.bottom - (((float) (1.0d - Math.sin(Math.toRadians((double) this.f5692g)))) * height), strokeWidth, this.f5689d);
        canvas.drawCircle(this.f5695j.right - (width * ((float) (1.0d - Math.cos(Math.toRadians((double) (this.f5693h + this.f5692g)))))), this.f5695j.bottom - (height * ((float) (1.0d - Math.sin(Math.toRadians((double) (this.f5693h + this.f5692g)))))), strokeWidth, this.f5689d);
    }

    /* renamed from: b */
    private void m5888b() {
        if (this.f5691f == null || !this.f5691f.isRunning()) {
            this.f5704s = 1;
            this.f5691f = m5889c();
            this.f5691f.start();
        }
    }

    /* renamed from: c */
    private Animator m5889c() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, new Keyframe[]{Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)}), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, new float[]{0.0f, -144.0f, 0.0f})});
        ofPropertyValuesHolder.setDuration(1760);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        return ofPropertyValuesHolder;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            m5888b();
        } else if ((i == 4 || i == 8) && this.f5691f != null) {
            this.f5691f.cancel();
            this.f5691f = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (1 == this.f5704s) {
            if (i != 0) {
                if (this.f5691f != null) {
                    this.f5691f.cancel();
                    this.f5691f = null;
                }
            } else if (isShown()) {
                m5888b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (1 == this.f5704s) {
            if (i != 0) {
                if (this.f5691f != null) {
                    this.f5691f.cancel();
                    this.f5691f = null;
                }
            } else if (isShown()) {
                m5888b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = (int) ((this.f5697l + this.f5698m + 2.0f) * 2.0f);
        setMeasuredDimension(resolveSizeAndState(getPaddingLeft() + getPaddingRight() + i3, i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void setBarColor(int i) {
        if (this.f5687b != null && this.f5687b.getColor() != i) {
            this.f5687b.setColor(i);
            this.f5689d.setColor(i);
            this.f5703r = i;
            postInvalidate();
        }
    }

    public int getBarColor() {
        return this.f5703r;
    }

    public void setBarBackgroundColor(int i) {
        if (this.f5688c != null && this.f5688c.getColor() != i) {
            this.f5688c.setColor(i);
            this.f5702q = i;
            postInvalidate();
        }
    }

    public int getBarBackgroundColor() {
        return this.f5702q;
    }

    public float getSweepAngle() {
        return this.f5693h;
    }

    public void setSweepAngle(float f) {
        this.f5693h = f;
        invalidate();
    }

    public float getStartAngle() {
        return this.f5692g;
    }

    public void setStartAngle(float f) {
        this.f5692g = f;
        invalidate();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }
}
