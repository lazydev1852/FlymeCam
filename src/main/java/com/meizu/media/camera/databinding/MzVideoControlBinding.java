package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class MzVideoControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final LinearLayout f9852a;
    @NonNull

    /* renamed from: b */
    public final TextView f9853b;

    public MzVideoControlBinding(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.f9852a = linearLayout;
        this.f9853b = textView;
    }
}
