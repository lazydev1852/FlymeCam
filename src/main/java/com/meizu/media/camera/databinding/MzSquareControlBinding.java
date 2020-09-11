package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class MzSquareControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final View f9820a;
    @NonNull

    /* renamed from: b */
    public final RelativeLayout f9821b;
    @NonNull

    /* renamed from: c */
    public final View f9822c;
    @NonNull

    /* renamed from: d */
    public final TextView f9823d;
    @NonNull

    /* renamed from: e */
    public final View f9824e;

    public MzSquareControlBinding(DataBindingComponent dataBindingComponent, View view, int i, View view2, RelativeLayout relativeLayout, View view3, TextView textView, View view4) {
        super(dataBindingComponent, view, i);
        this.f9820a = view2;
        this.f9821b = relativeLayout;
        this.f9822c = view3;
        this.f9823d = textView;
        this.f9824e = view4;
    }
}
