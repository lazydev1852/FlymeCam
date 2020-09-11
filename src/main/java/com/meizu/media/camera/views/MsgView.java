package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class MsgView extends AppCompatTextView {

    /* renamed from: a */
    public static ChangeQuickRedirect f14753a;

    /* renamed from: b */
    private Context f14754b;

    /* renamed from: c */
    private GradientDrawable f14755c;

    /* renamed from: d */
    private int f14756d;

    /* renamed from: e */
    private int f14757e;

    /* renamed from: f */
    private int f14758f;

    /* renamed from: g */
    private int f14759g;

    /* renamed from: h */
    private boolean f14760h;

    /* renamed from: i */
    private boolean f14761i;

    public MsgView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14755c = new GradientDrawable();
        this.f14754b = context;
        m16488a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16488a(Context context, AttributeSet attributeSet) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f14753a, false, 8488, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
            this.f14756d = obtainStyledAttributes.getColor(0, 0);
            this.f14757e = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f14758f = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f14759g = obtainStyledAttributes.getColor(4, 0);
            this.f14760h = obtainStyledAttributes.getBoolean(2, false);
            this.f14761i = obtainStyledAttributes.getBoolean(3, false);
            obtainStyledAttributes.recycle();
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8489, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (!mo23007b() || getWidth() <= 0 || getHeight() <= 0) {
                super.onMeasure(i, i2);
                return;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f14753a, false, 8490, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
            if (mo23006a()) {
                setCornerRadius(getHeight() / 2);
            } else {
                setBgSelector();
            }
        }
    }

    public void setBackgroundColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8491, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14756d = i;
            setBgSelector();
        }
    }

    public void setCornerRadius(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8492, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14757e = m16487a((float) i);
            setBgSelector();
        }
    }

    public void setStrokeWidth(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8493, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14758f = m16487a((float) i);
            setBgSelector();
        }
    }

    public void setStrokeColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8494, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14759g = i;
            setBgSelector();
        }
    }

    public void setIsRadiusHalfHeight(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8495, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14760h = z;
            setBgSelector();
        }
    }

    public void setIsWidthHeightEqual(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14753a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8496, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14761i = z;
            setBgSelector();
        }
    }

    public int getBackgroundColor() {
        return this.f14756d;
    }

    public int getCornerRadius() {
        return this.f14757e;
    }

    public int getStrokeWidth() {
        return this.f14758f;
    }

    public int getStrokeColor() {
        return this.f14759g;
    }

    /* renamed from: a */
    public boolean mo23006a() {
        return this.f14760h;
    }

    /* renamed from: b */
    public boolean mo23007b() {
        return this.f14761i;
    }

    /* renamed from: a */
    private int m16487a(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f14753a, false, 8497, new Class[]{Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * this.f14754b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private void m16489a(GradientDrawable gradientDrawable, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{gradientDrawable, new Integer(i), new Integer(i2)}, this, f14753a, false, 8499, new Class[]{GradientDrawable.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius((float) this.f14757e);
            gradientDrawable.setStroke(this.f14758f, i2);
        }
    }

    public void setBgSelector() {
        if (!PatchProxy.proxy(new Object[0], this, f14753a, false, 8500, new Class[0], Void.TYPE).isSupported) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            m16489a(this.f14755c, this.f14756d, this.f14759g);
            stateListDrawable.addState(new int[]{-16842919}, this.f14755c);
            setBackground(stateListDrawable);
        }
    }
}
