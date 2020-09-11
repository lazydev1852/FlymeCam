package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.TopSettingView;

public abstract class MzTopSettingControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final View f9836a;
    @NonNull

    /* renamed from: b */
    public final View f9837b;
    @NonNull

    /* renamed from: c */
    public final View f9838c;
    @NonNull

    /* renamed from: d */
    public final View f9839d;
    @NonNull

    /* renamed from: e */
    public final View f9840e;
    @NonNull

    /* renamed from: f */
    public final LinearLayout f9841f;
    @NonNull

    /* renamed from: g */
    public final TopSettingView f9842g;

    public MzTopSettingControlBinding(DataBindingComponent dataBindingComponent, View view, int i, View view2, View view3, View view4, View view5, View view6, LinearLayout linearLayout, TopSettingView topSettingView) {
        super(dataBindingComponent, view, i);
        this.f9836a = view2;
        this.f9837b = view3;
        this.f9838c = view4;
        this.f9839d = view5;
        this.f9840e = view6;
        this.f9841f = linearLayout;
        this.f9842g = topSettingView;
    }
}
