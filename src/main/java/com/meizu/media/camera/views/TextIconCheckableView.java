package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class TextIconCheckableView extends LinearLayout implements Checkable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15134a;

    /* renamed from: b */
    public int f15135b;

    /* renamed from: c */
    public int f15136c;

    /* renamed from: d */
    private int f15137d;

    /* renamed from: e */
    private int f15138e;

    /* renamed from: f */
    private boolean f15139f;

    /* renamed from: g */
    private TextView f15140g;

    /* renamed from: h */
    private ImageView f15141h;

    public TextIconCheckableView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextIconCheckableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextIconCheckableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15137d = getResources().getColor(R.color.mz_settting_item_select_color);
        this.f15138e = getResources().getColor(R.color.mz_settting_item_unselect_color);
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f15134a, false, 8904, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f15140g = (TextView) findViewById(R.id.top_text);
            this.f15141h = (ImageView) findViewById(R.id.left_icon);
        }
    }

    public void setDrawableId(int i, int i2) {
        this.f15135b = i;
        this.f15136c = i2;
    }

    public void setLeftDrawable(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15134a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8905, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15141h.setImageResource(i);
        }
    }

    public void setChecked(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15134a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8906, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f15139f != z) {
            this.f15139f = z;
            if (z) {
                setLeftDrawable(this.f15136c);
                this.f15140g.setTextColor(this.f15137d);
                return;
            }
            setLeftDrawable(this.f15135b);
            this.f15140g.setTextColor(this.f15138e);
        }
    }

    public boolean isChecked() {
        return this.f15139f;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f15134a, false, 8907, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f15139f);
        }
    }

    public void setText(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f15134a, false, 8908, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f15140g.setText(str);
        }
    }
}
