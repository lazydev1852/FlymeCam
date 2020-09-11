package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.HorizontalPickerView;

public abstract class MzStereoCameraControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final FrameLayout f9829a;
    @NonNull

    /* renamed from: b */
    public final TextView f9830b;
    @NonNull

    /* renamed from: c */
    public final HorizontalPickerView f9831c;

    public MzStereoCameraControlBinding(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, HorizontalPickerView horizontalPickerView) {
        super(dataBindingComponent, view, i);
        this.f9829a = frameLayout;
        this.f9830b = textView;
        this.f9831c = horizontalPickerView;
    }
}
