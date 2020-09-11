package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class RotateImageView extends TwoStateImageView implements Rotatable {

    /* renamed from: a */
    private static final LogUtil.C2630a f15007a = new LogUtil.C2630a("RotateImageView");

    /* renamed from: b */
    public static ChangeQuickRedirect f15008b;

    /* renamed from: d */
    private int f15009d = 0;

    /* renamed from: e */
    private int f15010e = 0;

    /* renamed from: f */
    private int f15011f = 0;

    /* renamed from: g */
    private int f15012g = 0;

    /* renamed from: h */
    private boolean f15013h = false;

    /* renamed from: i */
    private boolean f15014i = true;

    /* renamed from: j */
    private long f15015j = 0;

    /* renamed from: k */
    private long f15016k = 0;

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
    }

    public RotateImageView(Context context) {
        super(context);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getDegree() {
        return this.f15012g;
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f15008b, false, 8814, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15014i = z;
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f15012g) {
                this.f15012g = i2;
                if (this.f15014i) {
                    this.f15011f = this.f15010e;
                    this.f15015j = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f15012g - this.f15010e;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f15013h = z2;
                    this.f15009d = (Math.abs(i3) * 1000) / 180;
                    this.f15016k = this.f15015j + 180;
                } else {
                    this.f15010e = this.f15012g;
                }
                invalidate();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable;
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15008b, false, 8815, new Class[]{Canvas.class}, Void.TYPE).isSupported && (drawable = getDrawable()) != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.right - bounds.left;
            int i2 = bounds.bottom - bounds.top;
            if (i != 0 && i2 != 0) {
                if (this.f15010e != this.f15012g) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    if (currentAnimationTimeMillis < this.f15016k) {
                        int i3 = (int) (currentAnimationTimeMillis - this.f15015j);
                        int i4 = this.f15011f;
                        int i5 = this.f15009d;
                        if (!this.f15013h) {
                            i3 = -i3;
                        }
                        int i6 = i4 + ((i5 * i3) / 1000);
                        this.f15010e = i6 >= 0 ? i6 % 360 : (i6 % 360) + 360;
                        invalidate();
                    } else {
                        this.f15010e = this.f15012g;
                    }
                }
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingRight = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                int width = (getWidth() - paddingLeft) - paddingRight;
                int height = (getHeight() - paddingTop) - paddingBottom;
                int saveCount = canvas.getSaveCount();
                if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i || height < i2)) {
                    float f = (float) width;
                    float f2 = (float) height;
                    float min = Math.min(f / ((float) i), f2 / ((float) i2));
                    canvas.scale(min, min, f / 2.0f, f2 / 2.0f);
                }
                canvas.translate((float) (paddingLeft + (width / 2)), (float) (paddingTop + (height / 2)));
                canvas.rotate((float) (-this.f15010e));
                canvas.translate((float) ((-i) / 2), (float) ((-i2) / 2));
                try {
                    drawable.draw(canvas);
                } catch (Exception unused) {
                    LogUtil.m15952c(f15007a, "bitmap may be recycled !!!");
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f15008b, false, 8816, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
    }
}
