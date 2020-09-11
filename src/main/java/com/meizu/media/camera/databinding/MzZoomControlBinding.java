package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.MzZoomCircleView;
import com.meizu.media.camera.views.MzZoomSlideBar;

public abstract class MzZoomControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final MzZoomCircleView f9858a;
    @NonNull

    /* renamed from: b */
    public final FrameLayout f9859b;
    @NonNull

    /* renamed from: c */
    public final TextView f9860c;
    @NonNull

    /* renamed from: d */
    public final LinearLayout f9861d;
    @NonNull

    /* renamed from: e */
    public final MzZoomSlideBar f9862e;

    public MzZoomControlBinding(DataBindingComponent dataBindingComponent, View view, int i, MzZoomCircleView mzZoomCircleView, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, MzZoomSlideBar mzZoomSlideBar) {
        super(dataBindingComponent, view, i);
        this.f9858a = mzZoomCircleView;
        this.f9859b = frameLayout;
        this.f9860c = textView;
        this.f9861d = linearLayout;
        this.f9862e = mzZoomSlideBar;
    }
}
