package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzBarcodeListview extends ListView {

    /* renamed from: a */
    public static ChangeQuickRedirect f14762a;

    /* renamed from: b */
    private final int f14763b;

    /* renamed from: c */
    private final int f14764c;

    public MzBarcodeListview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14763b = context.getResources().getDimensionPixelSize(R.dimen.mz_barcode_list_max_height);
        this.f14764c = context.getResources().getDimensionPixelSize(R.dimen.mz_barcode_list_min_height);
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14762a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8501, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f14763b, Integer.MIN_VALUE));
            if (getMeasuredHeight() < this.f14764c) {
                setMeasuredDimension(getMeasuredWidth(), this.f14764c);
            }
        }
    }
}
