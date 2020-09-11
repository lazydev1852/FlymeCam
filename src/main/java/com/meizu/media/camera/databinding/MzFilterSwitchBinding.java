package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class MzFilterSwitchBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final TextView f9723a;
    @NonNull

    /* renamed from: b */
    public final TextView f9724b;
    @NonNull

    /* renamed from: c */
    public final FrameLayout f9725c;

    public MzFilterSwitchBinding(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.f9723a = textView;
        this.f9724b = textView2;
        this.f9725c = frameLayout;
    }
}
