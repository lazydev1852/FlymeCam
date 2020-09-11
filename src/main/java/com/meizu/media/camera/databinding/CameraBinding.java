package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.meizu.media.camera.views.MzImageView;
import com.meizu.media.camera.views.MzInterceptFrameLayout;
import com.meizu.media.camera.views.RenderOverlay;

public abstract class CameraBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final ImageView f9502a;
    @NonNull

    /* renamed from: b */
    public final ViewStubProxy f9503b;
    @NonNull

    /* renamed from: c */
    public final ViewStubProxy f9504c;
    @NonNull

    /* renamed from: d */
    public final ViewStubProxy f9505d;
    @NonNull

    /* renamed from: e */
    public final FrameLayout f9506e;
    @NonNull

    /* renamed from: f */
    public final MzCameraControlbarBinding f9507f;
    @NonNull

    /* renamed from: g */
    public final ViewStubProxy f9508g;
    @NonNull

    /* renamed from: h */
    public final ViewStubProxy f9509h;
    @NonNull

    /* renamed from: i */
    public final ViewStubProxy f9510i;
    @NonNull

    /* renamed from: j */
    public final MzInterceptFrameLayout f9511j;
    @NonNull

    /* renamed from: k */
    public final View f9512k;
    @NonNull

    /* renamed from: l */
    public final RelativeLayout f9513l;
    @NonNull

    /* renamed from: m */
    public final ImageView f9514m;
    @NonNull

    /* renamed from: n */
    public final ViewStubProxy f9515n;
    @NonNull

    /* renamed from: o */
    public final ViewStubProxy f9516o;
    @NonNull

    /* renamed from: p */
    public final ImageView f9517p;
    @NonNull

    /* renamed from: q */
    public final ImageView f9518q;
    @NonNull

    /* renamed from: r */
    public final ViewStubProxy f9519r;
    @NonNull

    /* renamed from: s */
    public final ImageView f9520s;
    @NonNull

    /* renamed from: t */
    public final RenderOverlay f9521t;
    @NonNull

    /* renamed from: u */
    public final MzCameraSmartbarBinding f9522u;
    @NonNull

    /* renamed from: v */
    public final MzImageView f9523v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraBinding(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ViewStubProxy viewStubProxy, ViewStubProxy viewStubProxy2, ViewStubProxy viewStubProxy3, FrameLayout frameLayout, MzCameraControlbarBinding mzCameraControlbarBinding, ViewStubProxy viewStubProxy4, ViewStubProxy viewStubProxy5, ViewStubProxy viewStubProxy6, MzInterceptFrameLayout mzInterceptFrameLayout, View view2, RelativeLayout relativeLayout, ImageView imageView2, ViewStubProxy viewStubProxy7, ViewStubProxy viewStubProxy8, ImageView imageView3, ImageView imageView4, ViewStubProxy viewStubProxy9, ImageView imageView5, RenderOverlay renderOverlay, MzCameraSmartbarBinding mzCameraSmartbarBinding, MzImageView mzImageView) {
        super(dataBindingComponent, view, i);
        this.f9502a = imageView;
        this.f9503b = viewStubProxy;
        this.f9504c = viewStubProxy2;
        this.f9505d = viewStubProxy3;
        this.f9506e = frameLayout;
        this.f9507f = mzCameraControlbarBinding;
        setContainedBinding(this.f9507f);
        this.f9508g = viewStubProxy4;
        this.f9509h = viewStubProxy5;
        this.f9510i = viewStubProxy6;
        this.f9511j = mzInterceptFrameLayout;
        this.f9512k = view2;
        this.f9513l = relativeLayout;
        this.f9514m = imageView2;
        this.f9515n = viewStubProxy7;
        this.f9516o = viewStubProxy8;
        this.f9517p = imageView3;
        this.f9518q = imageView4;
        this.f9519r = viewStubProxy9;
        this.f9520s = imageView5;
        this.f9521t = renderOverlay;
        this.f9522u = mzCameraSmartbarBinding;
        setContainedBinding(this.f9522u);
        this.f9523v = mzImageView;
    }
}
