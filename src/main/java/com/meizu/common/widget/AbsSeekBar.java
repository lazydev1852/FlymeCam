package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public abstract class AbsSeekBar extends ProgressBar {

    /* renamed from: a */
    float f4522a;

    /* renamed from: b */
    boolean f4523b = true;

    /* renamed from: c */
    boolean f4524c = false;

    /* renamed from: d */
    protected int f4525d = 0;

    /* renamed from: i */
    private Drawable f4526i;

    /* renamed from: j */
    private int f4527j;

    /* renamed from: k */
    private int f4528k = 1;

    /* renamed from: l */
    private float f4529l;

    /* renamed from: m */
    private int f4530m;

    /* renamed from: n */
    private float f4531n;

    /* renamed from: o */
    private float f4532o;

    /* renamed from: p */
    private boolean f4533p;

    /* renamed from: q */
    private int f4534q = 256;

    /* renamed from: r */
    private int f4535r = 0;

    /* renamed from: s */
    private float f4536s;

    /* renamed from: t */
    private float f4537t = 0.0f;

    /* renamed from: u */
    private boolean f4538u = false;

    /* renamed from: v */
    private int f4539v = 0;

    /* renamed from: w */
    private int f4540w = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo16016d() {
    }

    public AbsSeekBar(Context context) {
        super(context);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBar, i, 0);
        setThumb(obtainStyledAttributes.getDrawable(R.styleable.SeekBar_mcThumb));
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SeekBar_mcThumbOffset, getThumbOffset()));
        obtainStyledAttributes.recycle();
        this.f4529l = 0.5f;
        this.f4530m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4534q = this.f4530m * this.f4530m;
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        if (this.f4526i == null || drawable == this.f4526i) {
            z = false;
        } else {
            this.f4526i.setCallback((Drawable.Callback) null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f4524c) {
                this.f4527j = drawable.getIntrinsicHeight() / 2;
            } else {
                this.f4527j = drawable.getIntrinsicWidth() / 2;
            }
            if (z && !(drawable.getIntrinsicWidth() == this.f4526i.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.f4526i.getIntrinsicHeight())) {
                requestLayout();
            }
            this.f4539v = drawable.getIntrinsicWidth() / 2;
            this.f4540w = drawable.getIntrinsicHeight() / 2;
        }
        this.f4526i = drawable;
        invalidate();
        if (z) {
            m5171a(getWidth(), getHeight());
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    public Drawable getThumb() {
        return this.f4526i;
    }

    public int getThumbOffset() {
        return this.f4527j;
    }

    public void setThumbOffset(int i) {
        this.f4527j = i;
        invalidate();
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.f4528k = i;
    }

    public int getKeyProgressIncrement() {
        return this.f4528k;
    }

    public synchronized void setMax(int i) {
        super.setMax(i);
        if (this.f4528k == 0 || getMax() / this.f4528k > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) getMax()) / 20.0f)));
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f4526i || super.verifyDrawable(drawable);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f4526i != null) {
            this.f4526i.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.f4529l * 255.0f));
        }
        if (this.f4526i != null && this.f4526i.isStateful()) {
            this.f4526i.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo16012a(float f, boolean z) {
        super.mo16012a(f, z);
        Drawable drawable = this.f4526i;
        if (drawable != null) {
            m5172a(getWidth(), getHeight(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m5171a(i, i2);
    }

    /* renamed from: a */
    private void m5171a(int i, int i2) {
        int i3;
        int i4;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.f4526i;
        if (this.f4524c) {
            if (drawable == null) {
                i4 = 0;
            } else {
                i4 = drawable.getIntrinsicWidth();
            }
            int min = Math.min(this.f5922f, (i - getPaddingLeft()) - getPaddingRight());
            int max = getMax();
            float progress = max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f;
            if (i4 > min) {
                if (drawable != null) {
                    m5172a(i, i2, drawable, progress, 0);
                }
                int i5 = (i4 - min) / 2;
                if (currentDrawable != null) {
                    currentDrawable.setBounds(i5, 0, ((i - getPaddingRight()) - i5) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
                    return;
                }
                return;
            }
            if (currentDrawable != null) {
                currentDrawable.setBounds(0, 0, (i - getPaddingRight()) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
            }
            int i6 = (min - i4) / 2;
            if (drawable != null) {
                m5172a(i, i2, drawable, progress, i6);
                return;
            }
            return;
        }
        if (drawable == null) {
            i3 = 0;
        } else {
            i3 = drawable.getIntrinsicHeight();
        }
        int min2 = Math.min(this.f5924h, (i2 - getPaddingTop()) - getPaddingBottom());
        int max2 = getMax();
        float progress2 = max2 > 0 ? ((float) getProgress()) / ((float) max2) : 0.0f;
        if (i3 > min2) {
            if (drawable != null) {
                m5172a(i, i2, drawable, progress2, 0);
            }
            int i7 = (i3 - min2) / 2;
            if (currentDrawable != null) {
                currentDrawable.setBounds(0, i7, (i - getPaddingRight()) - getPaddingLeft(), ((i2 - getPaddingBottom()) - i7) - getPaddingTop());
                return;
            }
            return;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, (i - getPaddingRight()) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
        }
        int i8 = (min2 - i3) / 2;
        if (drawable != null) {
            m5172a(i, i2, drawable, progress2, i8);
        }
    }

    /* renamed from: a */
    private void m5172a(int i, int i2, Drawable drawable, float f, int i3) {
        int i4;
        int i5;
        int i6;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f4524c) {
            i4 = ((i2 - getPaddingTop()) - getPaddingBottom()) - intrinsicHeight;
        } else {
            i4 = ((i - getPaddingLeft()) - getPaddingRight()) - intrinsicWidth;
        }
        int i7 = i4 + (this.f4527j * 2);
        if (this.f4524c) {
            int i8 = (int) ((1.0f - f) * ((float) i7));
            if (i3 == Integer.MIN_VALUE) {
                Rect bounds = drawable.getBounds();
                i3 = bounds.left;
                i6 = bounds.right;
            } else {
                i6 = i3 + intrinsicWidth;
            }
            drawable.setBounds(i3, i8, i6, intrinsicHeight + i8);
            return;
        }
        int i9 = (int) (f * ((float) i7));
        if (i3 == Integer.MIN_VALUE) {
            Rect bounds2 = drawable.getBounds();
            i3 = bounds2.top;
            i5 = bounds2.bottom;
        } else {
            i5 = i3 + intrinsicHeight;
        }
        drawable.setBounds(i9, i3, intrinsicWidth + i9, i5);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4526i != null) {
            canvas.save();
            if (this.f4524c) {
                canvas.translate((float) getPaddingLeft(), (float) (getPaddingTop() - this.f4527j));
                this.f4526i.draw(canvas);
                canvas.restore();
            } else {
                canvas.translate((float) (getPaddingLeft() - this.f4527j), (float) getPaddingTop());
                this.f4526i.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable currentDrawable = getCurrentDrawable();
        int intrinsicHeight = this.f4526i == null ? 0 : this.f4526i.getIntrinsicHeight();
        if (currentDrawable != null) {
            i3 = Math.max(this.f5921e, Math.min(this.f5922f, currentDrawable.getIntrinsicWidth()));
            i4 = Math.max(intrinsicHeight, Math.max(this.f5923g, Math.min(this.f5924h, currentDrawable.getIntrinsicHeight())));
        } else {
            i4 = 0;
            i3 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
        if (getMeasuredHeight() > getMeasuredWidth()) {
            this.f4524c = true;
        }
    }

    /* renamed from: a */
    public boolean mo16013a() {
        ViewParent parent = getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        float f2;
        float f3;
        int i2;
        float f4;
        if (!this.f4523b || !isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (!mo16013a()) {
                    setPressed(true);
                    if (this.f4526i != null) {
                        invalidate(this.f4526i.getBounds());
                    }
                    mo16014b();
                    this.f4535r = 0;
                    if (this.f4525d == 1) {
                        if (this.f4524c) {
                            this.f4536s = x;
                            this.f4537t = motionEvent.getY();
                        } else {
                            this.f4536s = motionEvent.getX();
                            this.f4537t = y;
                        }
                        this.f4538u = false;
                        this.f4535r = getProgress();
                    } else {
                        m5173a(motionEvent);
                    }
                    m5176g();
                    break;
                } else {
                    this.f4531n = x;
                    this.f4532o = y;
                    if (this.f4525d == 1) {
                        mo16014b();
                        this.f4536s = x;
                        this.f4537t = y;
                        this.f4538u = false;
                        this.f4535r = getProgress();
                        m5176g();
                        break;
                    }
                }
                break;
            case 1:
                if (this.f4533p) {
                    if (this.f4524c) {
                        i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                    } else {
                        i = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    }
                    if (this.f4525d == 1 && !this.f4538u) {
                        if (this.f4524c) {
                            x = y;
                        }
                        float f5 = ((float) i) - x;
                        if (((float) getPaddingBottom()) + f5 < ((float) (m5175c(this.f4535r) - this.f4539v)) || f5 + ((float) getPaddingBottom()) > ((float) (m5175c(this.f4535r) + this.f4539v))) {
                            int i3 = (int) x;
                            if (m5174b(i3) >= this.f4535r + this.f4528k) {
                                mo17101a(this.f4535r + this.f4528k, true);
                            } else if (m5174b(i3) < this.f4535r + this.f4528k) {
                                mo17101a(this.f4535r - this.f4528k, true);
                            }
                        }
                    } else if (this.f4525d != 1 || !this.f4538u) {
                        m5173a(motionEvent);
                    } else if (i != 0) {
                        mo17101a(this.f4535r + m5170a((this.f4524c ? (this.f4537t - y) / ((float) i) : (x - this.f4536s) / ((float) i)) * ((float) getMax())), true);
                    }
                    mo16015c();
                    setPressed(false);
                } else {
                    mo16014b();
                    m5173a(motionEvent);
                    mo16015c();
                }
                invalidate();
                this.f4538u = false;
                break;
            case 2:
                if (this.f4533p) {
                    if (this.f4525d != 1) {
                        m5173a(motionEvent);
                        break;
                    } else {
                        if (this.f4524c) {
                            f2 = Math.abs(motionEvent.getX() - this.f4536s);
                            f3 = Math.abs(y - this.f4537t);
                        } else {
                            float abs = Math.abs(x - this.f4536s);
                            f3 = Math.abs(motionEvent.getY() - this.f4537t);
                            f2 = abs;
                        }
                        if ((f2 * f2) + (f3 * f3) > ((float) this.f4534q) && !this.f4538u) {
                            this.f4536s = x;
                            this.f4538u = true;
                        }
                        if (this.f4538u) {
                            if (this.f4524c) {
                                i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                            } else {
                                i2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                            }
                            if (i2 != 0) {
                                if (this.f4524c) {
                                    f4 = (this.f4537t - y) / ((float) i2);
                                } else {
                                    f4 = (x - this.f4536s) / ((float) i2);
                                }
                                mo17101a(this.f4535r + m5170a(f4 * ((float) getMax())), true);
                                break;
                            }
                        }
                    }
                } else {
                    if (this.f4524c) {
                        f = Math.abs(y - this.f4532o);
                    } else {
                        f = Math.abs(x - this.f4531n);
                    }
                    if (f > ((float) this.f4530m)) {
                        setPressed(true);
                        if (this.f4526i != null) {
                            invalidate(this.f4526i.getBounds());
                        }
                        mo16014b();
                        m5173a(motionEvent);
                        m5176g();
                        break;
                    }
                }
                break;
            case 3:
                if (this.f4533p) {
                    mo16015c();
                    setPressed(false);
                }
                invalidate();
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m5173a(MotionEvent motionEvent) {
        float f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (this.f4524c) {
            int height = getHeight();
            int paddingTop = (height - getPaddingTop()) - getPaddingBottom();
            int y = (int) motionEvent.getY();
            if (y >= getPaddingTop()) {
                if (y > height - getPaddingBottom()) {
                    f2 = 0.0f;
                } else {
                    f2 = 1.0f - (((float) (y - getPaddingTop())) / ((float) paddingTop));
                    f3 = this.f4522a;
                }
            }
            f = f3 + (f2 * ((float) getMax()));
        } else {
            int width = getWidth();
            int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft()) {
                f2 = 0.0f;
            } else if (x <= width - getPaddingRight()) {
                f2 = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
                f3 = this.f4522a;
            }
            f = f3 + (f2 * ((float) getMax()));
        }
        mo17101a((int) f, true);
    }

    /* renamed from: g */
    private void m5176g() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo16014b() {
        this.f4533p = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo16015c() {
        this.f4533p = false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            int progress = getProgress();
            if ((i != 21 || this.f4524c) && (i != 20 || !this.f4524c)) {
                if (((i == 22 && !this.f4524c) || (i == 19 && this.f4524c)) && progress < getMax()) {
                    mo17101a(progress + this.f4528k, true);
                    mo16016d();
                    return true;
                }
            } else if (progress > 0) {
                mo17101a(progress - this.f4528k, true);
                mo16016d();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void setTouchMode(int i) {
        this.f4525d = i;
        if (this.f4525d > 1) {
            this.f4525d = 0;
        }
    }

    /* renamed from: a */
    private int m5170a(float f) {
        return Math.round(f);
    }

    /* renamed from: b */
    private int m5174b(int i) {
        int i2;
        if (this.f4524c) {
            i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            i = i2 - i;
        } else {
            i2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        return (int) (((float) ((i * getMax()) / i2)) - this.f4522a);
    }

    /* renamed from: c */
    private int m5175c(int i) {
        int i2;
        if (this.f4524c) {
            i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            i2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        float f = ((float) i) - this.f4522a;
        if (f < 0.0f) {
            return this.f4524c ? paddingBottom : paddingLeft;
        }
        if (f > ((float) getMax())) {
            if (this.f4524c) {
                return getHeight() - getPaddingBottom();
            }
            return getWidth() - getPaddingRight();
        } else if (getMax() <= 0) {
            return this.f4524c ? paddingBottom : paddingLeft;
        } else {
            float f2 = (float) i2;
            return this.f4524c ? paddingBottom + ((int) (f2 * (f / ((float) getMax())))) : paddingLeft + ((int) ((f / ((float) getMax())) * f2));
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSeekBar.class.getName());
    }
}
