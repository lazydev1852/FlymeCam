package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class MzNightvisionBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final FrameLayout f9800a;
    @NonNull

    /* renamed from: b */
    public final TextView f9801b;

    public MzNightvisionBinding(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.f9800a = frameLayout;
        this.f9801b = textView;
    }
}
