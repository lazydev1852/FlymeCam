package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.ZoomCircleBoardView;
import flyme.support.p093v7.widget.RecyclerView;

public abstract class MzZoomControlTwoBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final RecyclerView f9867a;
    @NonNull

    /* renamed from: b */
    public final RecyclerView f9868b;
    @NonNull

    /* renamed from: c */
    public final LinearLayout f9869c;
    @NonNull

    /* renamed from: d */
    public final ZoomCircleBoardView f9870d;
    @NonNull

    /* renamed from: e */
    public final LinearLayout f9871e;
    @NonNull

    /* renamed from: f */
    public final FrameLayout f9872f;
    @NonNull

    /* renamed from: g */
    public final TextView f9873g;
    @NonNull

    /* renamed from: h */
    public final ImageView f9874h;

    public MzZoomControlTwoBinding(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2, LinearLayout linearLayout, ZoomCircleBoardView zoomCircleBoardView, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.f9867a = recyclerView;
        this.f9868b = recyclerView2;
        this.f9869c = linearLayout;
        this.f9870d = zoomCircleBoardView;
        this.f9871e = linearLayout2;
        this.f9872f = frameLayout;
        this.f9873g = textView;
        this.f9874h = imageView;
    }
}
