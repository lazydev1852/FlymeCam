package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class RotateTextView extends AppCompatTextView implements Rotatable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15022a;

    /* renamed from: b */
    private int f15023b = 0;

    /* renamed from: c */
    private int f15024c = 0;

    /* renamed from: d */
    private int f15025d = 0;

    /* renamed from: e */
    private int f15026e = 0;

    /* renamed from: f */
    private boolean f15027f = false;

    /* renamed from: g */
    private boolean f15028g = true;

    /* renamed from: h */
    private long f15029h = 0;

    /* renamed from: i */
    private long f15030i = 0;

    public RotateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15022a, false, 8821, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f15024c != this.f15026e) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis < this.f15030i) {
                    int i = (int) (currentAnimationTimeMillis - this.f15029h);
                    int i2 = this.f15025d;
                    int i3 = this.f15023b;
                    if (!this.f15027f) {
                        i = -i;
                    }
                    int i4 = i2 + ((i3 * i) / 1000);
                    this.f15024c = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                    invalidate();
                } else {
                    this.f15024c = this.f15026e;
                }
            }
            canvas.rotate((float) (-this.f15024c), (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
            super.onDraw(canvas);
        }
    }

    public void setOrientation(int i, boolean z) {
        boolean z2 = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f15022a, false, 8822, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15028g = z;
            int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
            if (i2 != this.f15026e) {
                this.f15026e = i2;
                if (this.f15028g) {
                    this.f15025d = this.f15024c;
                    this.f15029h = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.f15026e - this.f15024c;
                    if (i3 < 0) {
                        i3 += 360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    if (i3 >= 0 && i3 != 180) {
                        z2 = true;
                    }
                    this.f15027f = z2;
                    this.f15023b = (Math.abs(i3) * 1000) / 180;
                    this.f15030i = this.f15029h + 180;
                } else {
                    this.f15024c = this.f15026e;
                }
                invalidate();
            }
        }
    }
}
