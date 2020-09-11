package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class SwitchImageView extends CompoundButton {

    /* renamed from: a */
    public static ChangeQuickRedirect f15109a;

    /* renamed from: b */
    private int f15110b;

    /* renamed from: c */
    private int f15111c;

    /* renamed from: d */
    private boolean f15112d;

    /* renamed from: e */
    private C2729a f15113e;

    /* renamed from: com.meizu.media.camera.views.SwitchImageView$a */
    public interface C2729a {
        /* renamed from: a */
        boolean mo23249a();
    }

    public SwitchImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTwoStateIcon(int i, int i2) {
        this.f15110b = i;
        this.f15111c = i2;
    }

    public void setOnPerClickListener(C2729a aVar) {
        this.f15113e = aVar;
    }

    public boolean performClick() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15109a, false, 8890, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f15113e == null || !this.f15113e.mo23249a()) {
            return super.performClick();
        }
        return true;
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15109a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8891, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.setChecked(z);
            if (this.f15112d != z) {
                this.f15112d = z;
                if (this.f15112d) {
                    setButtonDrawable(this.f15111c);
                } else {
                    setButtonDrawable(this.f15110b);
                }
            }
        }
    }
}
