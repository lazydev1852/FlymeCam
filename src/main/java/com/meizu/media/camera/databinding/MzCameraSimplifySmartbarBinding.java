package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.simplify.MzSimplifySmartbarContainer;
import com.meizu.media.camera.views.GlowImageView;

public abstract class MzCameraSimplifySmartbarBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final GlowImageView f9677a;
    @NonNull

    /* renamed from: b */
    public final GlowImageView f9678b;
    @NonNull

    /* renamed from: c */
    public final MzSimplifySmartbarContainer f9679c;
    @NonNull

    /* renamed from: d */
    public final RelativeLayout f9680d;
    @NonNull

    /* renamed from: e */
    public final TextView f9681e;
    @NonNull

    /* renamed from: f */
    public final TextView f9682f;

    public MzCameraSimplifySmartbarBinding(DataBindingComponent dataBindingComponent, View view, int i, GlowImageView glowImageView, GlowImageView glowImageView2, MzSimplifySmartbarContainer mzSimplifySmartbarContainer, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.f9677a = glowImageView;
        this.f9678b = glowImageView2;
        this.f9679c = mzSimplifySmartbarContainer;
        this.f9680d = relativeLayout;
        this.f9681e = textView;
        this.f9682f = textView2;
    }
}
