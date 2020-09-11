package com.meizu.common.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.widget.LabelLayout;

public class LabelItem extends RelativeLayout {

    /* renamed from: a */
    private int f5519a;

    /* renamed from: b */
    private int f5520b;

    /* renamed from: c */
    private LabelLayout.C1450a f5521c;

    /* renamed from: d */
    private int f5522d;

    /* renamed from: e */
    private int f5523e;

    /* renamed from: f */
    private TextView f5524f;

    /* renamed from: g */
    private ImageView f5525g;

    public TextView getTextView() {
        return this.f5524f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f5520b, 1073741824);
        if (this.f5521c == null || this.f5525g.getDrawable() == null) {
            this.f5524f.setPadding(this.f5519a, 0, this.f5519a, 0);
            this.f5524f.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = View.MeasureSpec.makeMeasureSpec(this.f5524f.getMeasuredWidth(), 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(this.f5524f.getMeasuredHeight(), 1073741824);
        } else {
            this.f5525g.measure(makeMeasureSpec, makeMeasureSpec);
            this.f5524f.setPadding(this.f5519a, 0, (this.f5522d * 2) + this.f5525g.getMeasuredWidth(), 0);
            this.f5524f.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = View.MeasureSpec.makeMeasureSpec(this.f5524f.getMeasuredWidth(), 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(this.f5523e + this.f5525g.getMeasuredHeight(), 1073741824);
        }
        super.onMeasure(i4, i3);
    }
}
