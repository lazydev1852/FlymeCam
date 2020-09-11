package com.meizu.media.camera.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.meizu.media.camera.animation.SplashAnim;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class SplashAnimView extends View implements IUpdateCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f7599a;

    /* renamed from: b */
    private SplashAnim f7600b = new SplashAnim(this);

    /* renamed from: c */
    private RectF f7601c = new RectF();

    public SplashAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f7599a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2416, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
            this.f7601c.left = (float) i;
            this.f7601c.top = (float) i2;
            this.f7601c.bottom = (float) i4;
            this.f7601c.right = (float) i3;
        }
    }

    /* renamed from: a */
    public void mo18854a(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f7599a, false, 2418, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            this.f7600b.mo18927a(rectF);
        }
    }

    public void setSplashAnimListener(SplashAnim.C1810a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f7599a, false, 2419, new Class[]{SplashAnim.C1810a.class}, Void.TYPE).isSupported) {
            this.f7600b.mo18928a(aVar);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7599a, false, 2420, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            this.f7600b.mo18926a(canvas);
        }
    }

    /* renamed from: r */
    public void mo18841r() {
        if (!PatchProxy.proxy(new Object[0], this, f7599a, false, 2421, new Class[0], Void.TYPE).isSupported) {
            invalidate();
        }
    }
}
