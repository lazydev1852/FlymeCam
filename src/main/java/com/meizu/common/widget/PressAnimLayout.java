package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PressAnimLayout extends FrameLayout {

    /* renamed from: a */
    private final long f5902a;

    /* renamed from: b */
    private final long f5903b;

    /* renamed from: c */
    private float f5904c;

    /* renamed from: d */
    private float f5905d;

    /* renamed from: e */
    private float f5906e;

    /* renamed from: f */
    private float f5907f;

    /* renamed from: g */
    private float f5908g;

    /* renamed from: h */
    private int f5909h;

    /* renamed from: i */
    private int f5910i;

    /* renamed from: j */
    private long f5911j;

    /* renamed from: k */
    private long f5912k;

    /* renamed from: l */
    private boolean f5913l;

    /* renamed from: m */
    private ObjectAnimator f5914m;

    /* renamed from: n */
    private ObjectAnimator f5915n;

    /* renamed from: o */
    private TimeInterpolator f5916o;

    public PressAnimLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public PressAnimLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressAnimLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5902a = 128;
        this.f5903b = 352;
        this.f5904c = 1.0f;
        this.f5905d = 0.95f;
        this.f5913l = false;
        m5976a();
    }

    /* renamed from: a */
    private void m5976a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5916o = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
        } else {
            this.f5916o = new AccelerateDecelerateInterpolator();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5909h = i;
        this.f5910i = i2;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setEnabled(z);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m5977a(motionEvent);
                break;
            case 1:
            case 3:
                if (!this.f5913l) {
                    m5981c(motionEvent);
                }
                this.f5913l = false;
                break;
            case 2:
                if (!this.f5913l) {
                    m5979b(motionEvent);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m5977a(MotionEvent motionEvent) {
        this.f5911j = System.currentTimeMillis();
        this.f5907f = motionEvent.getX();
        this.f5908g = motionEvent.getY();
        m5978b();
        this.f5914m.start();
    }

    /* renamed from: b */
    private void m5979b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < 0.0f - this.f5906e || x > ((float) this.f5909h) + this.f5906e || y < 0.0f || y > ((float) this.f5910i)) {
            this.f5913l = true;
        }
        if (this.f5913l) {
            m5981c(motionEvent);
        }
    }

    /* renamed from: c */
    private void m5981c(MotionEvent motionEvent) {
        this.f5912k = System.currentTimeMillis();
        long j = this.f5912k - this.f5911j;
        m5980c();
        if (j < 128) {
            this.f5915n.setStartDelay(128 - j);
        } else {
            this.f5915n.setStartDelay(0);
        }
        this.f5915n.start();
    }

    /* renamed from: b */
    private void m5978b() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(SCALE_X, new float[]{this.f5904c, this.f5905d});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(SCALE_Y, new float[]{this.f5904c, this.f5905d});
        if (this.f5914m == null) {
            this.f5914m = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.f5914m.setInterpolator(this.f5916o);
            this.f5914m.setDuration(128);
            return;
        }
        this.f5914m.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    /* renamed from: c */
    private void m5980c() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(SCALE_X, new float[]{this.f5905d, this.f5904c});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(SCALE_Y, new float[]{this.f5905d, this.f5904c});
        if (this.f5915n == null) {
            this.f5915n = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.f5915n.setInterpolator(this.f5916o);
            this.f5915n.setDuration(352);
            return;
        }
        this.f5915n.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }
}
