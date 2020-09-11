package com.meizu.common.drawble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class CircularProgressDrawable extends Drawable {
    private Drawable mCenterIcon;
    private Paint mIconPaint;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;
    private boolean mShouldIcon = false;
    private int mSize;
    private float mStartAngle;
    private int mStrokeColor;
    private int mStrokeWidth;
    private float mSweepAngle;

    public int getOpacity() {
        return 1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public CircularProgressDrawable(int i, int i2, int i3) {
        this.mSize = i;
        this.mStrokeWidth = i2;
        this.mStrokeColor = i3;
        this.mStartAngle = 90.0f;
        this.mSweepAngle = 0.0f;
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
    }

    public void setSweepAngle(float f) {
        this.mSweepAngle = f;
    }

    public int getSize() {
        return this.mSize;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        this.mPath.reset();
        this.mPath.addArc(getRect(), this.mStartAngle, this.mSweepAngle);
        this.mPath.offset((float) bounds.left, (float) bounds.top);
        canvas.drawPath(this.mPath, createPaint());
        if (this.mCenterIcon != null) {
            canvas.save();
            this.mCenterIcon.setBounds(0, 0, this.mCenterIcon.getIntrinsicWidth(), this.mCenterIcon.getIntrinsicHeight());
            canvas.translate((float) ((bounds.left + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicWidth() / 2)), (float) ((bounds.top + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicHeight() / 2)));
            this.mCenterIcon.draw(canvas);
            canvas.restore();
        } else if (this.mShouldIcon) {
            if (this.mIconPaint == null) {
                this.mIconPaint = new Paint();
                this.mIconPaint.setStrokeCap(Paint.Cap.ROUND);
                this.mIconPaint.setColor(this.mStrokeColor);
                this.mIconPaint.setAntiAlias(true);
            }
            int size = getSize();
            int size2 = getSize();
            int i = this.mStrokeWidth;
            int i2 = (int) (((double) size2) * 0.12d);
            this.mIconPaint.setStrokeWidth((float) i);
            int i3 = size2 / 2;
            int i4 = i2 / 2;
            int i5 = i / 2;
            int i6 = size / 2;
            int i7 = ((int) (((float) size) / 3.1f)) / 2;
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) (((bounds.left + i3) - i4) - i5), (float) (((bounds.top + i6) - i7) + i5), (float) (((bounds.left + i3) - i4) - i5), (float) (((bounds.top + i6) + i7) - i5), this.mIconPaint);
            canvas2.drawLine((float) (bounds.left + i3 + i4 + i5), (float) (((bounds.top + i6) - i7) + i5), (float) (bounds.left + i3 + i4 + i5), (float) (((bounds.top + i6) + i7) - i5), this.mIconPaint);
        }
    }

    private RectF getRect() {
        if (this.mRectF == null) {
            float f = ((float) this.mStrokeWidth) / 2.0f;
            this.mRectF = new RectF(f, f, ((float) getSize()) - f, ((float) getSize()) - f);
        }
        return this.mRectF;
    }

    private Paint createPaint() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
            this.mPaint.setColor(this.mStrokeColor);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        }
        return this.mPaint;
    }

    public void setCenterIcon(Drawable drawable) {
        this.mCenterIcon = drawable;
    }

    public void setShowCenterIcon(boolean z) {
        this.mShouldIcon = z;
    }

    public void setIndicatorColor(int i) {
        createPaint();
        this.mStrokeColor = i;
        this.mPaint.setColor(this.mStrokeColor);
    }

    public void setStrokeWidth(int i) {
        if (i > 0 && this.mStrokeWidth != i) {
            this.mStrokeWidth = i;
            if (this.mRectF != null) {
                int i2 = this.mStrokeWidth / 2;
                float f = (float) i2;
                this.mRectF.set(f, f, (float) (getSize() - i2), (float) (getSize() - i2));
            }
            if (this.mPaint != null) {
                this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
            }
        }
    }
}
