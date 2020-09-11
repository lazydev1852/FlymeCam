package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class GlowImageView extends MzSMBRotateImageView {

    /* renamed from: a */
    public static ChangeQuickRedirect f14588a;

    public GlowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
    }

    public GlowImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setPressed(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14588a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8372, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.setPressed(z);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14588a, false, 8373, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
        }
    }

    public void setImageResource(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14588a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8374, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i != -1) {
            super.setImageResource(i);
        }
    }
}
