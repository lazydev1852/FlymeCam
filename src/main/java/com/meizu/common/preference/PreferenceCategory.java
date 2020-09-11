package com.meizu.common.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.R;

public class PreferenceCategory extends android.preference.PreferenceCategory {

    /* renamed from: a */
    private int f4365a = R.layout.mz_preference_category_no_title;

    /* renamed from: b */
    private int f4366b = 0;

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5015a(context, attributeSet);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5015a(context, attributeSet);
    }

    /* renamed from: a */
    private void m5015a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceCategory, 0, 0);
        this.f4365a = obtainStyledAttributes.getResourceId(R.styleable.PreferenceCategory_mzNoTitleLayout, this.f4365a);
        this.f4366b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceCategory_mzTopPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public View getView(View view, ViewGroup viewGroup) {
        return super.getView((View) null, viewGroup);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        View view;
        if (getTitle() == null && getTitleRes() == 0) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
            view = layoutInflater.inflate(this.f4365a, viewGroup, false);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(16908312);
            if (viewGroup2 != null) {
                if (getWidgetLayoutResource() != 0) {
                    layoutInflater.inflate(getWidgetLayoutResource(), viewGroup2);
                } else {
                    viewGroup2.setVisibility(8);
                }
            }
        } else {
            view = super.onCreateView(viewGroup);
        }
        if (this.f4366b != 0) {
            view.setPadding(view.getPaddingStart(), this.f4366b, view.getPaddingEnd(), view.getPaddingBottom());
        }
        return view;
    }
}
