package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.util.CommonUtils;

public class EnhanceSeekBar extends View {
    private static final int AURA_HIDE_ANIM_TIME = 200;
    private static final float AURA_SCALE_BASELINE = 1.0f;
    private static final float AURA_SCALE_TARGET = 0.5f;
    private static final int AURA_SHOW_ANIM_TIME = 180;
    private static final int MIN_HEIGHT = 20;
    private static final int MIN_WIDTH = 64;
    private static final String TAG = "EnhanceSeekBar";
    private static final int TEXT_HEIGHT = 50;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private boolean hasMoved;
    private int iconPadding;
    private int iconWidth;
    private boolean isAuraShow;
    /* access modifiers changed from: private */
    public boolean isDrag;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAccessibilityFocused;
    private Drawable mAuraDrawble;
    /* access modifiers changed from: private */
    public int mAuraHeight;
    private ValueAnimator mAuraHideAnimator;
    private Interpolator mAuraHideInterpolator;
    /* access modifiers changed from: private */
    public int mAuraRadius;
    private ValueAnimator mAuraShowAnimator;
    private Interpolator mAuraShowInterpolator;
    private int mAuraWidth;
    private Bitmap mDecreaseIcon;
    private int mDistance;
    private DrawableXYHolder mDrawableXYHolder;
    private boolean mEnableEngine;
    private XYHolder mEndXY;
    private int mHalfThumbHeight;
    private int mHalfThumbWidth;
    private Bitmap mIncreaseIcon;
    private float mInitialThumbX;
    private float mInitialTouchX;
    private boolean mIsDragging;
    private boolean mIsInItemPositon;
    /* access modifiers changed from: private */
    public CharSequence[] mItems;
    private Rect mLeftIconRect;
    private Interpolator mLocationInterpolator;
    private int mMax;
    private ObjectAnimator mObjectAnimator;
    /* access modifiers changed from: private */
    public OnEnhanceSeekBarChangeListener mOnEnhanceSeekBarChangeListener;
    private Paint mPaint;
    private int mPaintColor;
    private ColorStateList mPaintColorStateList;
    /* access modifiers changed from: private */
    public int mProgress;
    private Rect mRightIconRect;
    private int mScaledTouchSlop;
    private int mSpotColor;
    private ColorStateList mSpotColorStateList;
    private float mSpotRadius;
    private XYHolder mStartXY;
    private int mStrokeColor;
    private ColorStateList mStrokeColorStateList;
    private int mStrokeWidth;
    private int mTextSize;
    private Drawable mThumb;
    private int mThumbOffset;
    private int mTouchDownProgress;
    private XYEvaluator mXYEvaluator;

    public interface OnEnhanceSeekBarChangeListener {
        void onProgressChanged(EnhanceSeekBar enhanceSeekBar, int i);

        void onProgressDragging(EnhanceSeekBar enhanceSeekBar, int i);

        void onStartTrackingTouch(EnhanceSeekBar enhanceSeekBar);

        void onStopTrackingTouch(EnhanceSeekBar enhanceSeekBar);
    }

    public static String getTAG() {
        return TAG;
    }

    private boolean isPointInside(int i, int i2) {
        return true;
    }

    public EnhanceSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public EnhanceSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_EnhanceSeekBarStyle);
    }

    public EnhanceSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDrag = false;
        this.mTouchDownProgress = 0;
        this.mHalfThumbWidth = 0;
        this.mHalfThumbHeight = 0;
        this.mAuraRadius = 0;
        this.mStartXY = new XYHolder();
        this.mEndXY = new XYHolder();
        this.mXYEvaluator = new XYEvaluator();
        this.mDrawableXYHolder = new DrawableXYHolder();
        this.hasMoved = false;
        this.mAccessibilityFocused = false;
        this.isAuraShow = false;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EnhanceSeekBar, i, 0);
        setItems(obtainStyledAttributes.getTextArray(R.styleable.EnhanceSeekBar_mcEItems));
        setProgress(obtainStyledAttributes.getInt(R.styleable.EnhanceSeekBar_mcEProgress, 0));
        setItemsCount(obtainStyledAttributes.getInt(R.styleable.EnhanceSeekBar_mcEItemsCount, 1));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcEThumb);
        drawable = drawable == null ? context.getResources().getDrawable(R.drawable.mz_scrubber_control_selector) : drawable;
        this.mDistance = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcEnhanceDistance, getResources().getDimension(R.dimen.mc_enhance_seekbar_distance));
        this.mStrokeWidth = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcStrokeWidth, getResources().getDimension(R.dimen.mc_enhance_seekbar_stroke_width));
        this.mTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcItemsTextSize, (float) getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_item_text_size));
        this.mStrokeColorStateList = obtainStyledAttributes.getColorStateList(R.styleable.EnhanceSeekBar_mcEnhanceStrokeColor);
        setThumb(drawable);
        this.mAuraDrawble = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcAuraEnhanceThumbDrawble);
        this.iconWidth = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_width);
        this.iconPadding = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_padding);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.mz_enhance_seekbar_ic_increase);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mz_enhance_seekbar_ic_decrease);
        setIncreaseIcon(decodeResource);
        setDecreaseIcon(decodeResource2);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.mc_enhance_seekbar_background_color);
        this.mSpotColorStateList = getResources().getColorStateList(R.color.mc_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(R.dimen.mc_enhance_seekbar_spot_radius);
        obtainStyledAttributes.recycle();
        refreshRes();
        this.mPaint = new Paint();
        this.mPaint.setColor(this.mPaintColor);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mLocationInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, AURA_SCALE_BASELINE);
            this.mAuraShowInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, AURA_SCALE_BASELINE);
            this.mAuraHideInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, AURA_SCALE_BASELINE);
            return;
        }
        this.mLocationInterpolator = new AccelerateInterpolator();
        this.mAuraShowInterpolator = new LinearInterpolator();
        this.mAuraHideInterpolator = new LinearInterpolator();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        refreshRes();
        invalidate();
    }

    private void refreshRes() {
        if (isEnabled()) {
            this.mStrokeColor = getNormalColor(this.mStrokeColorStateList);
            this.mSpotColor = getNormalColor(this.mSpotColorStateList);
            this.mPaintColor = getNormalColor(this.mPaintColorStateList);
            return;
        }
        this.mStrokeColor = getDisabledColor(this.mStrokeColorStateList);
        this.mSpotColor = getDisabledColor(this.mSpotColorStateList);
        this.mPaintColor = getDisabledColor(this.mPaintColorStateList);
    }

    public void setOnEnhanceSeekBarChangeListener(OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener) {
        this.mOnEnhanceSeekBarChangeListener = onEnhanceSeekBarChangeListener;
    }

    public void setItems(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            this.mItems = null;
            setMax(0);
            return;
        }
        int length = charSequenceArr.length;
        this.mItems = new CharSequence[length];
        System.arraycopy(charSequenceArr, 0, this.mItems, 0, length);
        setMax(length - 1);
    }

    public void setItemsCount(int i) {
        if (this.mItems != null && this.mItems.length < i) {
            setMax(this.mItems.length - 1);
        } else if (i < 1) {
            setMax(0);
        } else {
            setMax(i - 1);
        }
    }

    private void setIncreaseIcon(Bitmap bitmap) {
        this.mIncreaseIcon = bitmap;
    }

    private void setDecreaseIcon(Bitmap bitmap) {
        this.mDecreaseIcon = bitmap;
    }

    private void setIconRect() {
        this.mLeftIconRect = new Rect(getPaddingLeft(), ((getPaddingTop() + 50) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), (getPaddingLeft() + this.iconWidth) - this.iconPadding, getPaddingTop() + 50 + this.mHalfThumbHeight + ((this.iconWidth - this.iconPadding) / 2));
        this.mRightIconRect = new Rect(((getWidth() - getPaddingRight()) - this.iconWidth) + this.iconPadding, ((getPaddingTop() + 50) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), getWidth() - getPaddingRight(), getPaddingTop() + 50 + this.mHalfThumbHeight + ((this.iconWidth - this.iconPadding) / 2));
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.mz_scrubber_control_selector);
        }
        if (this.mThumb == null || drawable == this.mThumb) {
            z = false;
        } else {
            this.mThumb.setCallback((Drawable.Callback) null);
            this.mThumb.getIntrinsicWidth();
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
            if (z && !(drawable.getIntrinsicWidth() == this.mThumb.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
            this.mHalfThumbWidth = drawable.getIntrinsicWidth() / 2;
            this.mHalfThumbHeight = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
        if (z) {
            updateThumbPos(getWidth(), getHeight());
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    private void setThumbOffset(int i) {
        this.mThumbOffset = i;
        invalidate();
    }

    public synchronized void setProgress(int i) {
        setProgress(i, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setProgress(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.mMax) {
            i = this.mMax;
        }
        if (i != this.mProgress || !this.mIsInItemPositon) {
            this.mProgress = i;
            if (!z) {
                onProgressRefresh(this.mMax > 0 ? ((float) this.mProgress) / ((float) this.mMax) : 0.0f);
            } else if (this.mOnEnhanceSeekBarChangeListener != null && this.mIsDragging) {
                this.mOnEnhanceSeekBarChangeListener.onProgressDragging(this, getProgress());
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && this.mAccessibilityFocused) {
                scheduleAccessibilityEventSender();
            }
        }
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public synchronized int getProgress() {
        return this.mProgress;
    }

    public void setEnableEngine(boolean z) {
        this.mEnableEngine = z;
    }

    public synchronized int getItemsCount() {
        return this.mItems != null ? this.mItems.length : this.mMax;
    }

    private synchronized int getMax() {
        return this.mMax;
    }

    private synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.mMax) {
            this.mMax = i;
            if (this.mProgress > i) {
                this.mProgress = i;
            }
            onProgressRefresh(this.mMax > 0 ? ((float) this.mProgress) / ((float) this.mMax) : 0.0f);
        }
    }

    private void onProgressRefresh(float f) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mThumb != null && this.mThumb.isStateful()) {
            this.mThumb.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateThumbPos(i, i2);
    }

    private void updateThumbPos(int i, int i2) {
        float f;
        Drawable drawable = this.mThumb;
        int max = getMax();
        if (max > 0) {
            f = isRTL() ? AURA_SCALE_BASELINE - (((float) this.mProgress) / ((float) max)) : ((float) this.mProgress) / ((float) max);
        } else {
            f = 0.0f;
        }
        if (drawable != null) {
            setThumbPos(i, drawable, f, 0);
        }
    }

    private void setThumbPos(int i, Drawable drawable, float f, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isRTL()) {
            i3 = paddingLeft - Math.round(f * ((float) paddingLeft));
            i4 = paddingLeft - i3;
        } else {
            i3 = paddingLeft - Math.round((AURA_SCALE_BASELINE - f) * ((float) paddingLeft));
            i4 = i3;
        }
        int i7 = intrinsicWidth + i4;
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i6 = bounds.top;
            i5 = bounds.bottom;
            z = true;
        } else {
            i6 = i2;
            i5 = drawable.getIntrinsicHeight() + i2;
            z = false;
        }
        if (this.mObjectAnimator != null) {
            if (!z) {
                this.mObjectAnimator.cancel();
                this.mObjectAnimator = null;
            } else if (this.mObjectAnimator.isStarted()) {
                z = false;
            }
        }
        if (z) {
            int i8 = drawable.getBounds().left;
            if (i8 == i3) {
                this.mIsInItemPositon = true;
                if (i2 == Integer.MIN_VALUE && this.mOnEnhanceSeekBarChangeListener != null) {
                    this.mOnEnhanceSeekBarChangeListener.onProgressChanged(this, getProgress());
                    return;
                }
                return;
            }
            float f2 = (float) i6;
            this.mStartXY.setXY((float) i8, f2);
            this.mEndXY.setXY((float) i3, f2);
            this.mDrawableXYHolder.setDrawable(drawable);
            this.mObjectAnimator = ObjectAnimator.ofObject(this.mDrawableXYHolder, "xY", this.mXYEvaluator, new Object[]{this.mStartXY, this.mEndXY});
            this.mObjectAnimator.setDuration((long) ((int) (Math.abs(this.mEndXY.getX() - this.mStartXY.getX()) * 0.44444445f)));
            this.mObjectAnimator.setInterpolator(this.mLocationInterpolator);
            this.mObjectAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener != null) {
                        EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener.onProgressChanged(EnhanceSeekBar.this, EnhanceSeekBar.this.getProgress());
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener != null) {
                        EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener.onProgressChanged(EnhanceSeekBar.this, EnhanceSeekBar.this.getProgress());
                    }
                }
            });
            this.mObjectAnimator.start();
        } else {
            this.mThumb.setBounds(i4, i6, i7, i5);
            invalidate();
        }
        this.mIsInItemPositon = true;
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!(this.mThumb == null || this.mIncreaseIcon == null || this.mDecreaseIcon == null)) {
            Rect bounds = this.mThumb.getBounds();
            if (isRTL()) {
                canvas.drawBitmap(this.mDecreaseIcon, (Rect) null, this.mRightIconRect, (Paint) null);
                canvas.drawBitmap(this.mIncreaseIcon, (Rect) null, this.mLeftIconRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.mDecreaseIcon, (Rect) null, this.mLeftIconRect, (Paint) null);
                canvas.drawBitmap(this.mIncreaseIcon, (Rect) null, this.mRightIconRect, (Paint) null);
            }
            canvas.save();
            if (this.mItems != null) {
                canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + 50 + this.mHalfThumbHeight));
            } else {
                canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mHalfThumbHeight));
            }
            float width = (float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2));
            int max = getMax();
            float f = max > 0 ? width / ((float) max) : 0.0f;
            this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
            this.mPaint.setColor(this.mPaintColor);
            this.mPaint.setAntiAlias(true);
            canvas.drawLine(0.0f, 0.0f, width, 0.0f, this.mPaint);
            this.mPaint.setColor(this.mStrokeColor);
            if (isRTL()) {
                canvas.drawLine(Math.min((float) bounds.centerX(), width), 0.0f, width, 0.0f, this.mPaint);
            } else {
                canvas.drawLine(0.0f, 0.0f, (float) bounds.centerX(), 0.0f, this.mPaint);
            }
            this.mPaint.setTextSize((float) this.mTextSize);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            for (int i = 0; i <= max; i++) {
                if (isRTL()) {
                    int i2 = max - i;
                    if (getProgress() == i2) {
                        String str = (String) this.mItems[i2];
                        canvas.drawText(str, (width - this.mPaint.measureText(str)) / 2.0f, (float) (-(this.mHalfThumbHeight + this.mDistance)), this.mPaint);
                    }
                } else if (getProgress() == i) {
                    String str2 = (String) this.mItems[i];
                    canvas.drawText(str2, (width - this.mPaint.measureText(str2)) / 2.0f, (float) (-(this.mHalfThumbHeight + this.mDistance)), this.mPaint);
                }
            }
            canvas.restore();
            canvas.save();
            if (this.mItems != null) {
                canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + 50 + this.mHalfThumbHeight));
            } else {
                canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mHalfThumbHeight));
            }
            for (int i3 = 0; i3 <= max; i3++) {
                float f2 = ((float) i3) * f;
                if (isRTL()) {
                    if (Math.min((float) bounds.left, width) < f2) {
                        this.mPaint.setColor(this.mStrokeColor);
                    } else {
                        this.mPaint.setColor(this.mSpotColor);
                    }
                } else if (((float) bounds.left) > f2) {
                    this.mPaint.setColor(this.mStrokeColor);
                } else {
                    this.mPaint.setColor(this.mSpotColor);
                }
                canvas.drawCircle(f2, 0.0f, this.mSpotRadius, this.mPaint);
            }
            canvas.restore();
            canvas.save();
            if (this.mItems != null) {
                canvas.translate((float) ((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth), (float) (getPaddingTop() + 50));
            } else {
                canvas.translate((float) ((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth), (float) getPaddingTop());
            }
            this.mThumb.draw(canvas);
            if (this.isDrag) {
                this.mAuraDrawble.setBounds(bounds.centerX() - this.mAuraRadius, bounds.centerY() - this.mAuraRadius, bounds.centerX() + this.mAuraRadius, bounds.centerY() + this.mAuraRadius);
                this.mAuraDrawble.draw(canvas);
            }
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        this.mAuraHeight = this.mAuraDrawble == null ? 0 : this.mAuraDrawble.getIntrinsicHeight();
        int intrinsicHeight = this.mThumb == null ? 0 : this.mThumb.getIntrinsicHeight();
        int i3 = 20;
        if (this.mItems != null) {
            i3 = 70;
        }
        int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
        if (intrinsicHeight != 0) {
            i3 = Math.max(intrinsicHeight + (this.mItems != null ? 50 : 0), i3);
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i)), i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        setIconRect();
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getMax() == 0) {
            return false;
        }
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.mInitialTouchX = x;
                this.isDrag = false;
                if (this.mThumb != null) {
                    this.mInitialThumbX = (float) this.mThumb.getBounds().left;
                }
                this.mTouchDownProgress = Math.round((x - ((float) (getPaddingLeft() / (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2))))) * ((float) getMax()));
                stopAuraShowAnim();
                stopAuraHideAnim();
                if (isPointInside((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    setPressed(true);
                    if (this.mThumb != null) {
                        invalidate(this.mThumb.getBounds());
                    }
                    onStartTrackingTouch();
                }
                attemptClaimDrag();
                this.hasMoved = false;
                break;
            case 1:
                if (this.isDrag) {
                    prepareStartAuraHide();
                }
                if (this.hasMoved) {
                    if (this.mAuraDrawble != null) {
                        invalidate(this.mAuraDrawble.getBounds());
                    }
                    if (!this.mIsDragging) {
                        setProgress(this.mTouchDownProgress, false);
                        break;
                    } else {
                        trackTouchEvent(motionEvent);
                        onStopTrackingTouch();
                        setPressed(false);
                        break;
                    }
                } else {
                    trackTapUpTouchEvent(motionEvent);
                    setPressed(false);
                    if (this.mThumb != null) {
                        invalidate(this.mThumb.getBounds());
                        break;
                    }
                }
                break;
            case 2:
                if (this.mObjectAnimator == null || !this.mObjectAnimator.isStarted()) {
                    if (this.mIsDragging) {
                        this.mIsInItemPositon = false;
                        flingThumb(motionEvent);
                        attemptClaimDrag();
                    }
                    if (Math.abs(motionEvent.getX() - this.mInitialTouchX) <= ((float) this.mScaledTouchSlop)) {
                        this.hasMoved = false;
                        break;
                    } else {
                        this.hasMoved = true;
                        this.isDrag = true;
                        if (this.mAuraDrawble != null) {
                            invalidate(this.mAuraDrawble.getBounds());
                            prepareStartAuraShow();
                            break;
                        }
                    }
                } else {
                    return true;
                }
                break;
            case 3:
                if (this.mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                }
                if (this.isDrag) {
                    prepareStartAuraHide();
                }
                invalidate();
                break;
        }
        return true;
    }

    private void flingThumb(MotionEvent motionEvent) {
        if (this.mObjectAnimator == null || !this.mObjectAnimator.isStarted()) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            Rect bounds = this.mThumb.getBounds();
            int x = (int) ((this.mInitialThumbX + ((float) ((int) motionEvent.getX()))) - this.mInitialTouchX);
            if (x < 0) {
                x = 0;
            } else if (x > width) {
                x = width;
            }
            setProgress(Math.round((isRTL() ? AURA_SCALE_BASELINE - (((float) (x - getPaddingLeft())) / ((float) width)) : ((float) (x - getPaddingLeft())) / ((float) width)) * ((float) getMax())), true);
            this.mThumb.setBounds(x, bounds.top, this.mThumb.getIntrinsicWidth() + x, bounds.bottom);
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        if (isRTL() != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (isRTL() != false) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r1 = r5.getPaddingLeft()
            int r1 = r0 - r1
            int r2 = r5.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r5.iconWidth
            int r2 = r2 * 2
            int r1 = r1 - r2
            float r6 = r6.getX()
            int r6 = (int) r6
            float r2 = r5.mInitialThumbX
            float r6 = (float) r6
            float r2 = r2 + r6
            float r6 = r5.mInitialTouchX
            float r2 = r2 - r6
            int r6 = (int) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r6 >= 0) goto L_0x002f
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x002d
            goto L_0x005b
        L_0x002d:
            r2 = 0
            goto L_0x005b
        L_0x002f:
            int r4 = r5.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r5.mHalfThumbWidth
            int r4 = r4 * 2
            int r0 = r0 - r4
            if (r6 <= r0) goto L_0x0042
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x005b
            goto L_0x002d
        L_0x0042:
            boolean r0 = r5.isRTL()
            if (r0 == 0) goto L_0x0052
            int r0 = r5.getPaddingLeft()
            int r6 = r6 - r0
            float r6 = (float) r6
            float r0 = (float) r1
            float r6 = r6 / r0
            float r2 = r2 - r6
            goto L_0x005b
        L_0x0052:
            int r0 = r5.getPaddingLeft()
            int r6 = r6 - r0
            float r6 = (float) r6
            float r0 = (float) r1
            float r2 = r6 / r0
        L_0x005b:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r2 = r2 * r6
            float r3 = r3 + r2
            int r6 = java.lang.Math.round(r3)
            r0 = 0
            r5.setProgress(r6, r0)
            boolean r6 = r5.mEnableEngine
            if (r6 == 0) goto L_0x0072
            com.meizu.common.util.CommonUtils.m5118a((android.view.View) r5)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceSeekBar.trackTouchEvent(android.view.MotionEvent):void");
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        float f;
        float progress;
        if (this.mObjectAnimator == null || !this.mObjectAnimator.isStarted()) {
            if (this.mEnableEngine) {
                CommonUtils.m5118a((View) this);
            }
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            float x = (float) ((int) motionEvent.getX());
            if (x >= ((float) ((getPaddingLeft() + this.iconWidth) - this.iconPadding))) {
                if (x <= ((float) (getPaddingLeft() + this.iconWidth + width + this.iconPadding))) {
                    f = (float) (isRTL() ? Math.round((AURA_SCALE_BASELINE - (((x - ((float) getPaddingLeft())) - ((float) this.iconWidth)) / ((float) width))) * ((float) this.mMax)) : Math.round((((x - ((float) getPaddingLeft())) - ((float) this.iconWidth)) / ((float) width)) * ((float) this.mMax)));
                } else if (!isRTL()) {
                    f = (float) (getProgress() + 1 > this.mMax ? this.mMax : getProgress() + 1);
                } else if (getProgress() - 1 >= 0) {
                    progress = (float) (getProgress() - 1);
                    f = progress;
                }
                float f2 = f / ((float) this.mMax);
                setProgress((int) f, true);
                setThumbPos(getWidth(), this.mThumb, f2, Integer.MIN_VALUE);
            } else if (isRTL()) {
                f = (float) (getProgress() + 1 > this.mMax ? this.mMax : getProgress() + 1);
                float f22 = f / ((float) this.mMax);
                setProgress((int) f, true);
                setThumbPos(getWidth(), this.mThumb, f22, Integer.MIN_VALUE);
            } else if (getProgress() - 1 >= 0) {
                progress = (float) (getProgress() - 1);
                f = progress;
                float f222 = f / ((float) this.mMax);
                setProgress((int) f, true);
                setThumbPos(getWidth(), this.mThumb, f222, Integer.MIN_VALUE);
            }
            f = 0.0f;
            float f2222 = f / ((float) this.mMax);
            setProgress((int) f, true);
            setThumbPos(getWidth(), this.mThumb, f2222, Integer.MIN_VALUE);
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        if (this.mOnEnhanceSeekBarChangeListener != null) {
            this.mOnEnhanceSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        if (this.mOnEnhanceSeekBarChangeListener != null) {
            this.mOnEnhanceSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    private void startAuraShowAnim() {
        this.isAuraShow = true;
        if (this.mAuraShowAnimator == null) {
            this.mAuraShowAnimator = ValueAnimator.ofFloat(new float[]{AURA_SCALE_TARGET, AURA_SCALE_BASELINE});
            this.mAuraShowAnimator.setDuration(180);
            this.mAuraShowAnimator.setInterpolator(this.mAuraShowInterpolator);
            this.mAuraShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = EnhanceSeekBar.this.mAuraRadius = (int) (((float) (EnhanceSeekBar.this.mAuraHeight / 2)) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    EnhanceSeekBar.this.invalidate();
                }
            });
        }
        this.mAuraShowAnimator.start();
    }

    private void stopAuraShowAnim() {
        if (this.mAuraShowAnimator != null && this.mAuraShowAnimator.isRunning()) {
            this.mAuraShowAnimator.cancel();
        }
    }

    private void startAuraHideAnim() {
        if (this.mAuraHideAnimator == null) {
            this.mAuraHideAnimator = ValueAnimator.ofFloat(new float[]{AURA_SCALE_BASELINE, AURA_SCALE_TARGET});
            this.mAuraHideAnimator.setDuration(200);
            this.mAuraHideAnimator.setInterpolator(this.mAuraHideInterpolator);
            this.mAuraHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = EnhanceSeekBar.this.mAuraRadius = (int) (((float) (EnhanceSeekBar.this.mAuraHeight / 2)) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    EnhanceSeekBar.this.invalidate();
                }
            });
            this.mAuraHideAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = EnhanceSeekBar.this.isDrag = false;
                }
            });
        }
        this.mAuraHideAnimator.start();
    }

    private void stopAuraHideAnim() {
        if (this.mAuraHideAnimator != null && this.mAuraHideAnimator.isRunning()) {
            this.mAuraHideAnimator.cancel();
        }
    }

    private void prepareStartAuraShow() {
        if (this.mAuraDrawble != null && !this.isAuraShow) {
            startAuraShowAnim();
        }
    }

    private void prepareStartAuraHide() {
        this.isAuraShow = false;
        if (this.mAuraDrawble != null) {
            startAuraHideAnim();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress, true);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(EnhanceSeekBar.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EnhanceSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i == 64) {
            this.mAccessibilityFocused = true;
        } else if (i == 128) {
            this.mAccessibilityFocused = false;
        }
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        int max = Math.max(1, Math.round(((float) getMax()) / 5.0f));
        if (i != 4096) {
            if (i != 8192 || progress <= 0) {
                return false;
            }
            setProgress(progress - max, false);
            return true;
        } else if (progress >= getMax()) {
            return false;
        } else {
            setProgress(progress + max, false);
            return true;
        }
    }

    private class DrawableXYHolder {
        private Drawable mDrawable;

        public DrawableXYHolder() {
        }

        public DrawableXYHolder(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void setXY(XYHolder xYHolder) {
            if (this.mDrawable != null) {
                this.mDrawable.setBounds((int) xYHolder.getX(), (int) xYHolder.getY(), (int) (xYHolder.getX() + ((float) this.mDrawable.getIntrinsicWidth())), (int) (xYHolder.getY() + ((float) this.mDrawable.getIntrinsicHeight())));
                EnhanceSeekBar.this.invalidate();
            }
        }

        public XYHolder getXY() {
            if (this.mDrawable == null) {
                return null;
            }
            Rect bounds = this.mDrawable.getBounds();
            return new XYHolder((float) bounds.left, (float) bounds.top);
        }
    }

    private class XYHolder {

        /* renamed from: mX */
        private float f5188mX;

        /* renamed from: mY */
        private float f5189mY;

        public XYHolder() {
            this.f5189mY = 0.0f;
            this.f5188mX = 0.0f;
        }

        public XYHolder(float f, float f2) {
            this.f5188mX = f;
            this.f5189mY = f2;
        }

        public float getX() {
            return this.f5188mX;
        }

        public void setXY(float f, float f2) {
            this.f5188mX = f;
            this.f5189mY = f2;
        }

        public void setX(float f) {
            this.f5188mX = f;
        }

        public float getY() {
            return this.f5189mY;
        }

        public void setY(float f) {
            this.f5189mY = f;
        }
    }

    private class XYEvaluator implements TypeEvaluator {
        private XYEvaluator() {
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return new XYHolder(xYHolder.getX() + ((xYHolder2.getX() - xYHolder.getX()) * f), xYHolder.getY() + (f * (xYHolder2.getY() - xYHolder.getY())));
        }
    }

    public void setPaintColor(int i) {
        this.mPaintColor = i;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7) {
                switch (action) {
                    case 9:
                        motionEvent.setAction(0);
                        break;
                    case 10:
                        motionEvent.setAction(1);
                        break;
                }
            } else {
                motionEvent.setAction(2);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    private void scheduleAccessibilityEventSender() {
        if (this.mAccessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(this.mAccessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 200);
    }

    private class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        public void run() {
            EnhanceSeekBar.this.sendAccessibilityEvent(4);
            if (Build.VERSION.SDK_INT >= 16) {
                EnhanceSeekBar.this.announceForAccessibility(String.format(EnhanceSeekBar.this.getResources().getString(R.string.mc_enhanceseekbar), new Object[]{EnhanceSeekBar.this.mItems[EnhanceSeekBar.this.mProgress]}));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAccessibilityEventSender != null) {
            this.mAccessibilityFocused = false;
            removeCallbacks(this.mAccessibilityEventSender);
        }
    }

    private int getNormalColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }
}
