package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class TwoStateImageView extends AppCompatImageView {

    /* renamed from: c */
    public static ChangeQuickRedirect f15151c;

    /* renamed from: a */
    private boolean f15152a;

    public TwoStateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15152a = true;
    }

    public TwoStateImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TwoStateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15152a = true;
    }

    public void setEnabled(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15151c;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8926, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.setEnabled(z);
            if (!this.f15152a) {
                return;
            }
            if (z) {
                setAlpha(255);
            } else {
                setAlpha(255);
            }
        }
    }
}
