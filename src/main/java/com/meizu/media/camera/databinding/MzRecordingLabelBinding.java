package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.RotateImageView;

public abstract class MzRecordingLabelBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final FrameLayout f9806a;
    @NonNull

    /* renamed from: b */
    public final RotateImageView f9807b;
    @NonNull

    /* renamed from: c */
    public final RotateImageView f9808c;

    public MzRecordingLabelBinding(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, RotateImageView rotateImageView, RotateImageView rotateImageView2) {
        super(dataBindingComponent, view, i);
        this.f9806a = frameLayout;
        this.f9807b = rotateImageView;
        this.f9808c = rotateImageView2;
    }
}
