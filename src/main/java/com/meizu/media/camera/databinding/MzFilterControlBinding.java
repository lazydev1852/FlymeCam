package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.filter.FilterRecyclerView;

public abstract class MzFilterControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final TextView f9715a;
    @NonNull

    /* renamed from: b */
    public final FrameLayout f9716b;
    @NonNull

    /* renamed from: c */
    public final FrameLayout f9717c;
    @NonNull

    /* renamed from: d */
    public final FilterRecyclerView f9718d;

    public MzFilterControlBinding(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, FilterRecyclerView filterRecyclerView) {
        super(dataBindingComponent, view, i);
        this.f9715a = textView;
        this.f9716b = frameLayout;
        this.f9717c = frameLayout2;
        this.f9718d = filterRecyclerView;
    }
}
