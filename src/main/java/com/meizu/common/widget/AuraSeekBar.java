package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.meizu.common.R;

public class AuraSeekBar extends SkipPosSeekBar {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f4684d;

    /* renamed from: e */
    private Drawable f4685e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f4686f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f4687g;

    /* renamed from: h */
    private float f4688h;

    /* renamed from: i */
    private int f4689i;

    /* renamed from: j */
    private int f4690j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f4691k;

    /* renamed from: l */
    private Interpolator f4692l;

    /* renamed from: m */
    private Interpolator f4693m;

    /* renamed from: n */
    private boolean f4694n;

    /* renamed from: o */
    private ValueAnimator f4695o;

    /* renamed from: p */
    private ValueAnimator f4696p;

    public AuraSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public AuraSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_AuraSeekBarStyle);
    }

    public AuraSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4684d = false;
        this.f4687g = 0;
        this.f4694n = false;
        this.f4689i = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AuraSeekBar, i, 0);
        this.f4685e = obtainStyledAttributes.getDrawable(R.styleable.AuraSeekBar_mcAuraThumbDrawble);
        obtainStyledAttributes.recycle();
        m5253a();
    }

    /* renamed from: a */
    private void m5253a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4692l = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
            this.f4693m = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
            return;
        }
        this.f4692l = new LinearInterpolator();
        this.f4693m = new LinearInterpolator();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable progressDrawable = getProgressDrawable();
        if (this.f4685e != null) {
            this.f4691k = this.f4685e.getIntrinsicHeight();
            this.f4690j = this.f4685e.getIntrinsicWidth();
        } else {
            this.f4691k = 0;
            this.f4690j = 0;
        }
        if (progressDrawable != null) {
            i3 = View.MeasureSpec.getSize(i);
            i4 = Math.max(this.f4691k, Math.max(7, Math.min(48, progressDrawable.getIntrinsicHeight())));
        } else {
            i4 = 0;
            i3 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* access modifiers changed from: protected */
    @TargetApi(16)
    public synchronized void onDraw(Canvas canvas) {
        if (!(!this.f4684d || getThumb() == null || this.f4685e == null)) {
            Drawable thumb = getThumb();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            Rect bounds = thumb.getBounds();
            int i = height > this.f4691k ? ((height - this.f4691k) / 2) - bounds.top : 0;
            canvas.save();
            if (Build.VERSION.SDK_INT < 21) {
                canvas.translate(0.0f, (float) (getPaddingTop() + i));
            } else {
                canvas.translate((float) (getPaddingLeft() - (getThumb().getIntrinsicWidth() / 2)), (float) (getPaddingTop() + i));
            }
            int i2 = (int) ((((float) this.f4690j) / 2.0f) - (((float) (bounds.right - bounds.left)) / 2.0f));
            Rect rect = new Rect((bounds.left - i2) + this.f4687g, this.f4687g + 0, (bounds.right + i2) - this.f4687g, this.f4691k - this.f4687g);
            Log.d("AuraSeekBar", "auraBounds y:" + (rect.bottom - rect.top) + " x:" + (rect.right - rect.left));
            StringBuilder sb = new StringBuilder();
            sb.append("auraBounds ");
            sb.append(rect.toShortString());
            Log.d("AuraSeekBar", sb.toString());
            this.f4685e.setBounds(rect);
            this.f4685e.draw(canvas);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.f4688h = x;
                this.f4684d = false;
                m5261e();
                m5263g();
                break;
            case 1:
                if (this.f4684d) {
                    m5259c();
                    break;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.f4688h) > ((float) this.f4689i)) {
                    this.f4684d = true;
                    m5257b();
                    break;
                }
                break;
            case 3:
                if (this.f4684d) {
                    m5259c();
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: b */
    private void m5257b() {
        this.f4684d = true;
        if (this.f4685e != null) {
            if (!this.f4694n) {
                m5260d();
            }
            invalidate(this.f4685e.getBounds());
        }
    }

    /* renamed from: c */
    private void m5259c() {
        this.f4694n = false;
        if (this.f4685e != null) {
            m5262f();
            invalidate(this.f4685e.getBounds());
        }
    }

    /* renamed from: d */
    private void m5260d() {
        this.f4694n = true;
        if (this.f4695o == null) {
            this.f4695o = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
            this.f4695o.setDuration(180);
            this.f4695o.setInterpolator(this.f4692l);
            this.f4695o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int unused = AuraSeekBar.this.f4686f = (int) (((float) (AuraSeekBar.this.f4691k / 2)) * floatValue);
                    int unused2 = AuraSeekBar.this.f4687g = (int) ((((float) AuraSeekBar.this.f4691k) / 2.0f) * (1.0f - floatValue));
                    Log.d("AuraSeekBar", "show mAuraBorderDistance:" + AuraSeekBar.this.f4687g);
                    Log.d("AuraSeekBar", "show mAuraRadius:" + AuraSeekBar.this.f4686f);
                    AuraSeekBar.this.invalidate();
                }
            });
        }
        this.f4695o.start();
    }

    /* renamed from: e */
    private void m5261e() {
        if (this.f4695o != null) {
            this.f4695o.cancel();
        }
    }

    /* renamed from: f */
    private void m5262f() {
        if (this.f4696p == null) {
            this.f4696p = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
            this.f4696p.setDuration(200);
            this.f4696p.setInterpolator(this.f4693m);
            this.f4696p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int unused = AuraSeekBar.this.f4686f = (int) (((float) (AuraSeekBar.this.f4691k / 2)) * floatValue);
                    int unused2 = AuraSeekBar.this.f4687g = (int) ((((float) AuraSeekBar.this.f4691k) / 2.0f) * (1.0f - floatValue));
                    Log.d("AuraSeekBar", "hide mAuraRadius:" + AuraSeekBar.this.f4686f);
                    AuraSeekBar.this.invalidate();
                }
            });
            this.f4696p.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = AuraSeekBar.this.f4684d = false;
                }
            });
        }
        this.f4696p.start();
    }

    /* renamed from: g */
    private void m5263g() {
        if (this.f4696p != null) {
            this.f4696p.cancel();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AuraSeekBar.class.getName());
    }
}
