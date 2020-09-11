package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class FaceBeautyItemView extends AppCompatTextView implements Checkable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14505a;

    /* renamed from: b */
    private int f14506b;

    /* renamed from: c */
    private int f14507c;

    /* renamed from: d */
    private int f14508d;

    /* renamed from: e */
    private int f14509e;

    /* renamed from: f */
    private boolean f14510f;

    public FaceBeautyItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FaceBeautyItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceBeautyItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14506b = getResources().getColor(R.color.mz_settting_item_select_color);
        this.f14507c = getResources().getColor(R.color.default_background);
    }

    public void setTwoStateIcon(int i, int i2) {
        this.f14508d = i;
        this.f14509e = i2;
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14505a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8331, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f14510f != z) {
            this.f14510f = z;
            if (z) {
                setTextColor(this.f14506b);
                setImageResource(this.f14509e);
                return;
            }
            setTextColor(this.f14507c);
            setImageResource(this.f14508d);
        }
    }

    public void setImageResource(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14505a, false, 8332, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
        }
    }

    public boolean isChecked() {
        return this.f14510f;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f14505a, false, 8333, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f14510f);
        }
    }
}
