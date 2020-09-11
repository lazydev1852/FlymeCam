package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.meizu.media.camera.p066c.MeasuredAsyncDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class FixedSizeImageView extends AppCompatImageView {

    /* renamed from: a */
    public static ChangeQuickRedirect f14561a;

    /* renamed from: b */
    private int f14562b;

    /* renamed from: c */
    private int f14563c;

    public FixedSizeImageView(Context context) {
        super(context);
        m16426a();
    }

    public FixedSizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16426a();
    }

    public FixedSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16426a();
    }

    /* renamed from: a */
    private void m16426a() {
        if (!PatchProxy.proxy(new Object[0], this, f14561a, false, 8356, new Class[0], Void.TYPE).isSupported) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void setSize(int i, int i2) {
        this.f14562b = i;
        this.f14563c = i2;
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14561a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8357, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f14562b == 0 || this.f14563c == 0) {
                super.onMeasure(i, i2);
            } else {
                setMeasuredDimension(this.f14562b, this.f14563c);
            }
        }
    }

    public void setMeasuredDrawable(MeasuredAsyncDrawable cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f14561a, false, 8358, new Class[]{MeasuredAsyncDrawable.class}, Void.TYPE).isSupported) {
            if (cVar != null) {
                if (this.f14562b == 0 || this.f14563c == 0) {
                    setSize(cVar.mo19411e(), cVar.mo19412f());
                }
                cVar.mo19376a((ImageView) this);
                return;
            }
            setImageDrawable((Drawable) null);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14561a, false, 8359, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            Drawable drawable = getDrawable();
            if (!(drawable == null || drawable.getCallback() == this)) {
                drawable.setCallback(this);
            }
            super.onDraw(canvas);
        }
    }
}
