package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class RoundedCornerLayout extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f15036a;

    /* renamed from: b */
    private Bitmap f15037b;

    /* renamed from: c */
    private Paint f15038c;

    /* renamed from: d */
    private Paint f15039d;

    /* renamed from: e */
    private float f15040e;

    public RoundedCornerLayout(Context context) {
        super(context);
        m16615a(context, (AttributeSet) null, 0);
    }

    public RoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16615a(context, attributeSet, 0);
    }

    public RoundedCornerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16615a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m16615a(Context context, AttributeSet attributeSet, int i) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet, new Integer(i)}, this, f15036a, false, 8827, new Class[]{Context.class, AttributeSet.class, Integer.TYPE}, Void.TYPE).isSupported) {
            TypedArray obtainStyledAttributes = ContextBuilder.m6349a(context, true, true).obtainStyledAttributes(attributeSet, R.styleable.RoundedCornerLayout);
            this.f15040e = obtainStyledAttributes.getDimension(0, 2.13116608E9f);
            this.f15038c = new Paint(1);
            this.f15039d = new Paint(3);
            this.f15039d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            setWillNotDraw(false);
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15036a, false, 8828, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            super.draw(canvas2);
            if (this.f15037b == null) {
                this.f15037b = m16614a(getWidth(), getHeight());
            }
            canvas2.drawBitmap(this.f15037b, 0.0f, 0.0f, this.f15039d);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f15038c);
        }
    }

    /* renamed from: a */
    private Bitmap m16614a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15036a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8829, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f2), this.f15040e, this.f15040e, paint);
        return createBitmap;
    }
}
