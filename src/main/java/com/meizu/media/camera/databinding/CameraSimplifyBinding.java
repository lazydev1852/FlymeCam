package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView;
import com.meizu.media.camera.views.MzImageView;
import com.meizu.media.camera.views.MzInterceptFrameLayout;
import com.meizu.media.camera.views.RenderOverlay;

public abstract class CameraSimplifyBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final ImageView f9528a;
    @NonNull

    /* renamed from: b */
    public final FrameLayout f9529b;
    @NonNull

    /* renamed from: c */
    public final MzCameraControlbarBinding f9530c;
    @NonNull

    /* renamed from: d */
    public final MzCameraSimplifySmartbarBinding f9531d;
    @NonNull

    /* renamed from: e */
    public final ViewStubProxy f9532e;
    @NonNull

    /* renamed from: f */
    public final ViewStubProxy f9533f;
    @NonNull

    /* renamed from: g */
    public final MzInterceptFrameLayout f9534g;
    @NonNull

    /* renamed from: h */
    public final View f9535h;
    @NonNull

    /* renamed from: i */
    public final RelativeLayout f9536i;
    @NonNull

    /* renamed from: j */
    public final ImageView f9537j;
    @NonNull

    /* renamed from: k */
    public final ViewStubProxy f9538k;
    @NonNull

    /* renamed from: l */
    public final ViewStubProxy f9539l;
    @NonNull

    /* renamed from: m */
    public final ImageView f9540m;
    @NonNull

    /* renamed from: n */
    public final ViewStubProxy f9541n;
    @NonNull

    /* renamed from: o */
    public final ImageView f9542o;
    @NonNull

    /* renamed from: p */
    public final CameraPreviewRenderView f9543p;
    @NonNull

    /* renamed from: q */
    public final RenderOverlay f9544q;
    @NonNull

    /* renamed from: r */
    public final MzImageView f9545r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraSimplifyBinding(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FrameLayout frameLayout, MzCameraControlbarBinding mzCameraControlbarBinding, MzCameraSimplifySmartbarBinding mzCameraSimplifySmartbarBinding, ViewStubProxy viewStubProxy, ViewStubProxy viewStubProxy2, MzInterceptFrameLayout mzInterceptFrameLayout, View view2, RelativeLayout relativeLayout, ImageView imageView2, ViewStubProxy viewStubProxy3, ViewStubProxy viewStubProxy4, ImageView imageView3, ViewStubProxy viewStubProxy5, ImageView imageView4, CameraPreviewRenderView cameraPreviewRenderView, RenderOverlay renderOverlay, MzImageView mzImageView) {
        super(dataBindingComponent, view, i);
        this.f9528a = imageView;
        this.f9529b = frameLayout;
        this.f9530c = mzCameraControlbarBinding;
        setContainedBinding(this.f9530c);
        this.f9531d = mzCameraSimplifySmartbarBinding;
        setContainedBinding(this.f9531d);
        this.f9532e = viewStubProxy;
        this.f9533f = viewStubProxy2;
        this.f9534g = mzInterceptFrameLayout;
        this.f9535h = view2;
        this.f9536i = relativeLayout;
        this.f9537j = imageView2;
        this.f9538k = viewStubProxy3;
        this.f9539l = viewStubProxy4;
        this.f9540m = imageView3;
        this.f9541n = viewStubProxy5;
        this.f9542o = imageView4;
        this.f9543p = cameraPreviewRenderView;
        this.f9544q = renderOverlay;
        this.f9545r = mzImageView;
    }
}
