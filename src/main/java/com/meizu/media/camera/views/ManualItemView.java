package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class ManualItemView extends AppCompatTextView implements Checkable {

    /* renamed from: a */
    public static ChangeQuickRedirect f14733a;

    /* renamed from: b */
    private int f14734b;

    /* renamed from: c */
    private int f14735c;

    /* renamed from: d */
    private int f14736d;

    /* renamed from: e */
    private int f14737e;

    /* renamed from: f */
    private boolean f14738f;

    public ManualItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ManualItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ManualItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14734b = getResources().getColor(R.color.mz_settting_item_select_color);
        this.f14735c = getResources().getColor(R.color.mz_settting_item_unselect_color);
    }

    public void setTwoStateIcon(int i, int i2) {
        this.f14736d = i;
        this.f14737e = i2;
    }

    public void setImageResource(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14733a, false, 8478, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
        }
    }

    public boolean isChecked() {
        return this.f14738f;
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14733a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8479, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f14738f != z) {
            this.f14738f = z;
            if (z) {
                setTextColor(this.f14734b);
                setImageResource(this.f14737e);
                return;
            }
            setTextColor(this.f14735c);
            setImageResource(this.f14736d);
        }
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f14733a, false, 8480, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f14738f);
        }
    }
}
