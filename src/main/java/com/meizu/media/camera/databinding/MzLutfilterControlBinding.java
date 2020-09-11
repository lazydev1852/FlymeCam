package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.filter.FilterRecyclerView;

public abstract class MzLutfilterControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final TextView f9765a;
    @NonNull

    /* renamed from: b */
    public final FrameLayout f9766b;
    @NonNull

    /* renamed from: c */
    public final FrameLayout f9767c;
    @NonNull

    /* renamed from: d */
    public final FilterRecyclerView f9768d;

    public MzLutfilterControlBinding(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, FilterRecyclerView filterRecyclerView) {
        super(dataBindingComponent, view, i);
        this.f9765a = textView;
        this.f9766b = frameLayout;
        this.f9767c = frameLayout2;
        this.f9768d = filterRecyclerView;
    }
}
