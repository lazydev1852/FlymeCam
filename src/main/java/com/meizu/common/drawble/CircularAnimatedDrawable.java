package com.meizu.common.drawble;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

public class CircularAnimatedDrawable extends Drawable implements Animatable {
    public static final String START_ANGLE_PROPERTY = "startAngle";
    public static final String SWEEP_ANGLE_PROPERTY = "sweepAngle";
    private final long LOADING_ANIM_DURATION = 1760;
    private final RectF fBounds = new RectF();
    private boolean mAllowLoading = true;
    private float mBorderWidth;
    private Animator mLoadingAnimator = null;
    private Paint mPaint;
    private boolean mRunning;
    private float mStartAngle;
    private float mSweepAngle;

    public int getOpacity() {
        return -2;
    }

    public CircularAnimatedDrawable(int i, float f) {
        this.mBorderWidth = f;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f);
        this.mPaint.setColor(i);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mLoadingAnimator = createLoadingAnimator();
    }

    public void draw(Canvas canvas) {
        canvas.drawArc(this.fBounds, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.fBounds.left = ((float) rect.left) + (this.mBorderWidth / 2.0f);
        this.fBounds.right = ((float) rect.right) - (this.mBorderWidth / 2.0f);
        this.fBounds.top = ((float) rect.top) + (this.mBorderWidth / 2.0f);
        this.fBounds.bottom = ((float) rect.bottom) - (this.mBorderWidth / 2.0f);
    }

    public void start() {
        if (!isRunning()) {
            this.mRunning = true;
            this.mLoadingAnimator.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            this.mRunning = false;
            this.mLoadingAnimator.cancel();
            invalidateSelf();
        }
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    private Animator createLoadingAnimator() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(START_ANGLE_PROPERTY, new Keyframe[]{Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)}), PropertyValuesHolder.ofFloat(SWEEP_ANGLE_PROPERTY, new float[]{0.0f, -120.0f, 0.0f})});
        ofPropertyValuesHolder.setDuration(1760);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        return ofPropertyValuesHolder;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public void setSweepAngle(float f) {
        this.mSweepAngle = f;
        if (this.mAllowLoading) {
            invalidateSelf();
        }
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
        if (this.mAllowLoading) {
            invalidateSelf();
        }
    }

    public void setAllowLoading(boolean z) {
        this.mAllowLoading = z;
    }

    public void setIndicatorColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(i);
        }
    }

    public void setStrokeWidth(int i) {
        if (i > 0 && ((int) this.mBorderWidth) != i) {
            this.mBorderWidth = (float) i;
            onBoundsChange(getBounds());
            if (this.mPaint != null) {
                this.mPaint.setStrokeWidth(this.mBorderWidth);
            }
        }
    }
}
