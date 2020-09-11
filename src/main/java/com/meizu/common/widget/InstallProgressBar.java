package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.meizu.common.R;

public class InstallProgressBar extends View {

    /* renamed from: a */
    private Bitmap f5464a;

    /* renamed from: b */
    private Bitmap f5465b;

    /* renamed from: c */
    private StateListDrawable f5466c;

    /* renamed from: d */
    private StateListDrawable f5467d;

    /* renamed from: e */
    private StateListDrawable f5468e;

    /* renamed from: f */
    private Paint f5469f;

    /* renamed from: g */
    private float f5470g = -1.0f;

    /* renamed from: h */
    private int f5471h;

    /* renamed from: i */
    private int f5472i;

    /* renamed from: j */
    private int f5473j;

    /* renamed from: k */
    private ObjectAnimator f5474k;

    /* renamed from: l */
    private boolean f5475l = false;

    public InstallProgressBar(Context context) {
        super(context);
        m5823a();
    }

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5823a();
    }

    /* renamed from: a */
    private void m5823a() {
        this.f5472i = 0;
        this.f5471h = 100;
        this.f5466c = new StateListDrawable();
        this.f5466c.addState(new int[0], m5822a(R.drawable.mc_round_button_normal));
        this.f5467d = new StateListDrawable();
        this.f5467d.addState(new int[0], m5822a(R.drawable.mc_button_normal));
        this.f5468e = new StateListDrawable();
        this.f5468e.addState(new int[0], m5822a(R.drawable.mc_install_progress_bg_normal));
        this.f5469f = new Paint();
        this.f5469f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public void setRoundRadius(float f) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f5466c.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m5825a(Canvas canvas, boolean z) {
        float f;
        if (z) {
            f = (float) getMeasuredWidth();
        } else {
            f = (getProgress() / ((float) getMaxProgress())) * ((float) getMeasuredWidth());
        }
        canvas.drawBitmap(this.f5465b, f - ((float) getMeasuredWidth()), 0.0f, this.f5469f);
        canvas.restore();
    }

    /* renamed from: a */
    private void m5824a(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), (Paint) null, 31);
        canvas.drawBitmap(this.f5464a, 0.0f, 0.0f, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() != this.f5473j) {
            this.f5464a = null;
            this.f5465b = null;
        }
        if (this.f5464a == null) {
            if (this.f5475l) {
                this.f5464a = m5821a(this.f5467d, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.f5464a = m5821a(this.f5466c, getMeasuredWidth(), getMeasuredHeight());
            }
            this.f5473j = getMeasuredWidth();
        }
        if (this.f5465b == null) {
            this.f5465b = m5821a(this.f5468e, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m5824a(canvas);
        if (this.f5470g < ((float) this.f5472i) || this.f5470g > ((float) this.f5471h)) {
            m5825a(canvas, true);
        } else {
            m5825a(canvas, false);
        }
    }

    /* renamed from: a */
    private Drawable m5822a(int i) {
        return getResources().getDrawable(i);
    }

    /* renamed from: a */
    private Bitmap m5821a(StateListDrawable stateListDrawable, int i, int i2) {
        if (i == 0) {
            i = 1;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        stateListDrawable.setBounds(0, 0, i, i2);
        stateListDrawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private ObjectAnimator m5820a(float f) {
        if (f < this.f5470g) {
            return ObjectAnimator.ofFloat(this, "Progress", new float[]{0.0f, f}).setDuration(500);
        }
        return ObjectAnimator.ofFloat(this, "Progress", new float[]{this.f5470g, f}).setDuration(500);
    }

    /* renamed from: a */
    private static boolean m5826a(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }

    public void setRoundBtnColor(int i) {
        if (this.f5468e != null && i != 0) {
            ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f5468e.getConstantState()).getChild(0)).setColor(i);
            if (!(getMeasuredWidth() == 0 || getMeasuredHeight() == 0)) {
                if (this.f5465b != null) {
                    this.f5465b.recycle();
                }
                this.f5465b = m5821a(this.f5468e, getMeasuredWidth(), getMeasuredHeight());
            }
            invalidate();
        }
    }

    public void setProgressBackColor(int i) {
        if (this.f5467d != null && i != 0) {
            ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.f5467d.getConstantState()).getChild(0)).setColor(i);
            if (!(getMeasuredWidth() == 0 || getMeasuredHeight() == 0)) {
                if (this.f5464a != null) {
                    this.f5464a.recycle();
                }
                this.f5464a = m5821a(this.f5467d, getMeasuredWidth(), getMeasuredHeight());
            }
            invalidate();
        }
    }

    public synchronized void setProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > ((float) this.f5471h)) {
            f = (float) this.f5471h;
        }
        if (!m5826a(f, this.f5470g)) {
            this.f5470g = f;
            invalidate();
        }
    }

    public synchronized void setAnimProgress(float f) {
        this.f5474k = m5820a(f);
        this.f5474k.start();
    }

    public float getProgress() {
        return this.f5470g;
    }

    public int getMaxProgress() {
        return this.f5471h;
    }

    public int getMinProgress() {
        return this.f5472i;
    }

    public void setMaxProgress(int i) {
        this.f5471h = i;
    }

    public void setMinProgress(int i) {
        this.f5472i = i;
    }
}
