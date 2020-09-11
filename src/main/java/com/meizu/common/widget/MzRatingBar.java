package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.RatingBar;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;

public class MzRatingBar extends RatingBar implements GestureDetector.OnGestureListener {

    /* renamed from: a */
    private int f5707a;

    /* renamed from: b */
    private int f5708b;

    /* renamed from: c */
    private float f5709c;

    /* renamed from: d */
    private Drawable f5710d;

    /* renamed from: e */
    private int[] f5711e;

    /* renamed from: f */
    private boolean f5712f;

    /* renamed from: g */
    private GestureDetector f5713g;

    /* renamed from: h */
    private ValueAnimator f5714h;

    /* renamed from: i */
    private PathInterpolatorCompat f5715i;

    /* renamed from: j */
    private PathInterpolatorCompat f5716j;

    /* renamed from: k */
    private int f5717k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float[] f5718l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float[] f5719m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f5720n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f5721o;

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public MzRatingBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_MzRatingBarStyle);
    }

    public MzRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5707a = 0;
        this.f5708b = 0;
        this.f5712f = false;
        this.f5715i = new PathInterpolatorCompat(0.2f, 0.04f, 0.08f, 1.0f);
        this.f5716j = new PathInterpolatorCompat(0.35f, 0.56f, 0.0f, 1.0f);
        this.f5717k = 0;
        this.f5720n = 220;
        this.f5721o = 280;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzRatingBar, i, 0);
        this.f5711e = getResources().getIntArray(obtainStyledAttributes.getResourceId(R.styleable.MzRatingBar_mcStarColors, R.array.mc_rating_bar_default_colors));
        this.f5710d = obtainStyledAttributes.getDrawable(R.styleable.MzRatingBar_mcStarDrawable);
        if (this.f5710d == null) {
            this.f5710d = getResources().getDrawable(R.drawable.mz_btn_big_star);
        }
        this.f5709c = (float) this.f5710d.getIntrinsicWidth();
        obtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.f5707a = rating;
            this.f5708b = rating;
            this.f5712f = true;
        }
        this.f5713g = new GestureDetector(context, this);
        this.f5718l = new float[getNumStars()];
        this.f5719m = new float[getNumStars()];
        m5898a();
        try {
            if (1 == Settings.Global.getInt(context.getContentResolver(), "flymelab_flyme_night_mode", 0)) {
                BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", new Class[]{Boolean.TYPE}).invoke(this.f5710d, new Object[]{false});
            }
        } catch (Exception unused) {
            Log.e("MzRatingBar", "NightMode methods reflected failed!");
        }
    }

    /* renamed from: a */
    private void m5898a() {
        for (int i = 0; i < this.f5718l.length; i++) {
            this.f5718l[i] = 0.0f;
        }
    }

    /* renamed from: a */
    private void m5900a(int i, int i2) {
        if (i != i2) {
            while (i < i2) {
                this.f5719m[i] = 0.0f;
                i++;
            }
        }
    }

    /* renamed from: a */
    private void m5899a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f5719m[i2] = this.f5718l[i2];
        }
    }

    /* renamed from: b */
    private void m5902b() {
        if (this.f5714h == null) {
            this.f5717k = this.f5720n + this.f5721o + (getNumStars() * 16);
            new ValueAnimator();
            this.f5714h = ValueAnimator.ofInt(new int[]{0, this.f5717k});
            this.f5714h.setDuration((long) this.f5717k);
            this.f5714h.setInterpolator(new LinearInterpolator());
            this.f5714h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float intValue = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    for (int i = 0; i < MzRatingBar.this.getNumStars(); i++) {
                        MzRatingBar.this.f5718l[i] = Math.min(Math.max(0.0f, (MzRatingBar.this.f5719m[i] + intValue) - (((float) i) * 16.0f)), (float) (MzRatingBar.this.f5720n + MzRatingBar.this.f5721o));
                    }
                    MzRatingBar.this.invalidate();
                }
            });
        }
        this.f5714h.start();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.f5713g.onTouchEvent(motionEvent);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int i;
        float f;
        int intrinsicWidth;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        if (!(this.f5710d == null || this.f5711e == null)) {
            canvas.save();
            if (z) {
                canvas.clipRect(((float) getWidth()) - ((this.f5712f ? getRating() : (float) this.f5707a) * this.f5709c), 0.0f, (float) getWidth(), (float) getHeight());
            } else {
                canvas.clipRect(0.0f, 0.0f, (this.f5712f ? getRating() : (float) this.f5707a) * this.f5709c, (float) getHeight());
            }
            int paddingLeft = !z ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f5710d.getIntrinsicWidth();
            int paddingTop = getPaddingTop();
            for (int i2 = 0; i2 < getNumStars(); i2++) {
                if (i2 >= this.f5711e.length) {
                    i = this.f5711e[this.f5711e.length - 1];
                } else {
                    i = this.f5711e[i2];
                }
                this.f5710d.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                Rect rect = new Rect(paddingLeft, paddingTop, this.f5710d.getIntrinsicWidth() + paddingLeft, this.f5710d.getIntrinsicHeight() + paddingTop);
                this.f5710d.setBounds(rect);
                if (z) {
                    intrinsicWidth = paddingLeft - this.f5710d.getIntrinsicWidth();
                } else {
                    intrinsicWidth = paddingLeft + this.f5710d.getIntrinsicWidth();
                }
                canvas.save();
                if (!this.f5712f) {
                    float f2 = this.f5718l[i2];
                    if (f2 < ((float) this.f5720n)) {
                        f = (this.f5715i.getInterpolation(f2 / ((float) this.f5720n)) * 0.92999995f) + 0.1f;
                    } else {
                        f = ((1.0f - this.f5716j.getInterpolation((f2 - ((float) this.f5720n)) / ((float) this.f5721o))) * 0.03f) + 1.0f;
                    }
                    float f3 = 1.0f - f;
                    canvas.translate((((float) ((z ? (this.f5718l.length - 1) - i2 : i2) * rect.width())) * f3) + (((float) rect.width()) * f3 * 0.5f), ((float) rect.height()) * f3 * 0.5f);
                    canvas.scale(f, f);
                }
                this.f5710d.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
        }
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.f5711e = iArr;
        }
    }

    private int getProgressPos() {
        return ((int) ((getScale() * ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight()))) + 0.5f)) + getPaddingLeft();
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return ((float) getProgress()) / ((float) max);
        }
        return 0.0f;
    }

    private void setEnd(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f5718l[i2] = (float) (this.f5720n + this.f5721o + (i2 * 16));
        }
    }

    public void setRating(float f) {
        super.setRating(f);
        this.f5712f = true;
        int min = Math.min(getNumStars(), (int) Math.ceil((double) f));
        this.f5707a = min;
        this.f5708b = min;
    }

    public float getRating() {
        float rating = super.getRating();
        return this.f5712f ? rating : (float) ((int) Math.ceil((double) rating));
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.f5712f) {
            setEnd(Math.min(this.f5708b, getNumStars()));
        }
        m5899a(this.f5708b);
        m5900a(Math.min(this.f5708b, getNumStars()), getNumStars());
        this.f5707a = m5904c();
        this.f5708b = this.f5707a;
        this.f5712f = false;
        m5902b();
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5707a = m5904c();
        if (this.f5707a - this.f5708b > 0) {
            m5899a(this.f5708b);
            m5900a(Math.min(this.f5707a - 1, getNumStars()), getNumStars());
            m5898a();
            this.f5714h.cancel();
            m5902b();
        } else {
            m5899a(this.f5707a);
            m5900a(Math.min(this.f5708b, getNumStars()), getNumStars());
        }
        this.f5708b = this.f5707a;
        return false;
    }

    /* renamed from: c */
    private int m5904c() {
        return Math.min((int) ((((float) getProgressPos()) / this.f5709c) + 0.5f), getNumStars());
    }
}
