package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class PagerCornerIndicator extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14957a;

    /* renamed from: b */
    private Context f14958b;

    /* renamed from: c */
    private int f14959c;

    /* renamed from: d */
    private Paint f14960d;

    /* renamed from: e */
    private int f14961e;

    /* renamed from: f */
    private int f14962f;

    /* renamed from: g */
    private int f14963g;

    /* renamed from: h */
    private int f14964h;

    /* renamed from: i */
    private int f14965i;

    /* renamed from: j */
    private int f14966j;

    /* renamed from: k */
    private float f14967k;

    public PagerCornerIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerCornerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerCornerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14963g = ViewCompat.MEASURED_SIZE_MASK;
        this.f14964h = ViewCompat.MEASURED_SIZE_MASK;
        this.f14965i = 0;
        m16579a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16579a(Context context, AttributeSet attributeSet) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f14957a, false, 8774, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            this.f14958b = ContextBuilder.m6349a(context, true, true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagerCornerIndicator);
            this.f14959c = obtainStyledAttributes.getInt(0, 5);
            this.f14961e = obtainStyledAttributes.getDimensionPixelOffset(2, 5);
            this.f14963g = obtainStyledAttributes.getColor(4, this.f14963g);
            this.f14964h = obtainStyledAttributes.getColor(3, this.f14964h);
            this.f14962f = obtainStyledAttributes.getDimensionPixelOffset(1, 15);
            obtainStyledAttributes.recycle();
            int a = CameraUtil.m15809a();
            if (this.f14959c % 2 == 0) {
                this.f14967k = (((float) a) / 2.0f) - ((((((float) this.f14959c) / 2.0f) * ((float) this.f14962f)) - (((float) this.f14962f) / 2.0f)) + ((float) ((this.f14959c - 1) * this.f14961e)));
            } else if (this.f14959c % 2 == 1) {
                this.f14967k = (((float) a) / 2.0f) - (((((float) this.f14959c) / 2.0f) * ((float) this.f14962f)) + ((float) ((this.f14959c - 1) * this.f14961e)));
            }
            this.f14960d = new Paint(1);
            this.f14960d.setColor(this.f14963g);
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14957a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8775, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f14957a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8776, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14957a, false, 8777, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            this.f14966j = getHeight();
            m16580a(canvas);
        }
    }

    public void setSelectIndex(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14957a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8778, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i >= this.f14959c) {
                i = this.f14959c - 1;
            }
            this.f14965i = i;
            invalidate();
        }
    }

    /* renamed from: a */
    private void m16580a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14957a, false, 8779, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            for (int i = 0; i < this.f14959c; i++) {
                if (i == this.f14965i) {
                    this.f14960d.setColor(this.f14964h);
                } else {
                    this.f14960d.setColor(this.f14963g);
                }
                canvas.drawCircle(this.f14967k + ((float) ((this.f14962f + (this.f14961e * 2)) * i)), ((float) this.f14966j) / 2.0f, (float) this.f14961e, this.f14960d);
            }
        }
    }

    public void setIndicatorNumber(int i) {
        this.f14959c = i;
    }
}
