package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class ShutterLayout extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f15054a;

    public ShutterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f15054a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8837, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            if (measuredHeight != measuredWidth) {
                int min = Math.min(measuredHeight, measuredWidth);
                setMeasuredDimension(min, min);
            }
        }
    }
}
