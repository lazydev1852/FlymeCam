package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.common.widget.LoadingView;
import com.meizu.media.camera.views.RotateImageView;
import com.meizu.media.camera.views.ShutterButton;
import com.meizu.media.camera.views.ThunbnailRotateImageView;

public abstract class MzCameraControlbarBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final LoadingView f9659a;
    @NonNull

    /* renamed from: b */
    public final RotateImageView f9660b;
    @NonNull

    /* renamed from: c */
    public final ImageView f9661c;
    @NonNull

    /* renamed from: d */
    public final RelativeLayout f9662d;
    @NonNull

    /* renamed from: e */
    public final RotateImageView f9663e;
    @NonNull

    /* renamed from: f */
    public final RotateImageView f9664f;
    @NonNull

    /* renamed from: g */
    public final RotateImageView f9665g;
    @NonNull

    /* renamed from: h */
    public final ImageView f9666h;
    @NonNull

    /* renamed from: i */
    public final ShutterButton f9667i;
    @NonNull

    /* renamed from: j */
    public final LoadingView f9668j;
    @NonNull

    /* renamed from: k */
    public final RotateImageView f9669k;
    @NonNull

    /* renamed from: l */
    public final RotateImageView f9670l;
    @NonNull

    /* renamed from: m */
    public final ImageView f9671m;
    @NonNull

    /* renamed from: n */
    public final ThunbnailRotateImageView f9672n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MzCameraControlbarBinding(DataBindingComponent dataBindingComponent, View view, int i, LoadingView loadingView, RotateImageView rotateImageView, ImageView imageView, RelativeLayout relativeLayout, RotateImageView rotateImageView2, RotateImageView rotateImageView3, RotateImageView rotateImageView4, ImageView imageView2, ShutterButton shutterButton, LoadingView loadingView2, RotateImageView rotateImageView5, RotateImageView rotateImageView6, ImageView imageView3, ThunbnailRotateImageView thunbnailRotateImageView) {
        super(dataBindingComponent, view, i);
        this.f9659a = loadingView;
        this.f9660b = rotateImageView;
        this.f9661c = imageView;
        this.f9662d = relativeLayout;
        this.f9663e = rotateImageView2;
        this.f9664f = rotateImageView3;
        this.f9665g = rotateImageView4;
        this.f9666h = imageView2;
        this.f9667i = shutterButton;
        this.f9668j = loadingView2;
        this.f9669k = rotateImageView5;
        this.f9670l = rotateImageView6;
        this.f9671m = imageView3;
        this.f9672n = thunbnailRotateImageView;
    }
}
