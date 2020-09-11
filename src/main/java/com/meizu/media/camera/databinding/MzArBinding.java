package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import flyme.support.p093v7.widget.MzRecyclerView;

public abstract class MzArBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final TextView f9606a;
    @NonNull

    /* renamed from: b */
    public final FrameLayout f9607b;
    @NonNull

    /* renamed from: c */
    public final FrameLayout f9608c;
    @NonNull

    /* renamed from: d */
    public final ImageView f9609d;
    @NonNull

    /* renamed from: e */
    public final FrameLayout f9610e;
    @NonNull

    /* renamed from: f */
    public final FrameLayout f9611f;
    @NonNull

    /* renamed from: g */
    public final ImageView f9612g;
    @NonNull

    /* renamed from: h */
    public final MzRecyclerView f9613h;

    public MzArBinding(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView2, MzRecyclerView mzRecyclerView) {
        super(dataBindingComponent, view, i);
        this.f9606a = textView;
        this.f9607b = frameLayout;
        this.f9608c = frameLayout2;
        this.f9609d = imageView;
        this.f9610e = frameLayout3;
        this.f9611f = frameLayout4;
        this.f9612g = imageView2;
        this.f9613h = mzRecyclerView;
    }
}
