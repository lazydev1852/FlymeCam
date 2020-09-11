package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class FilterItemView extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14560a;

    public FilterItemView(Context context) {
        super(context);
    }

    public FilterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FilterItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Keep
    public void setWidth(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14560a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8354, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            getLayoutParams().width = i;
        }
    }

    @Keep
    public void setHeight(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14560a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8355, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            getLayoutParams().height = i;
        }
    }
}
