package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class ImageCheckableView extends RotateImageView implements Checkable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14680a;

    /* renamed from: d */
    private int f14681d;

    /* renamed from: e */
    private int f14682e;

    /* renamed from: f */
    private boolean f14683f;

    public ImageCheckableView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageCheckableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageCheckableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTwoStateIcon(int i, int i2) {
        this.f14681d = i;
        this.f14682e = i2;
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14680a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8449, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f14683f != z) {
            this.f14683f = z;
            if (z) {
                setImageResource(this.f14682e);
            } else {
                setImageResource(this.f14681d);
            }
        }
    }

    public boolean isChecked() {
        return this.f14683f;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f14680a, false, 8450, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f14683f);
        }
    }
}
