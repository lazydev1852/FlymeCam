package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class MzArContainerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final FrameLayout f9618a;

    public MzArContainerBinding(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.f9618a = frameLayout;
    }
}
