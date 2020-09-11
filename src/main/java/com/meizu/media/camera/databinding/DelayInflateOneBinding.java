package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.meizu.media.camera.animation.SplashAnimView;

public abstract class DelayInflateOneBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final ImageView f9556a;
    @NonNull

    /* renamed from: b */
    public final ViewStubProxy f9557b;
    @NonNull

    /* renamed from: c */
    public final SplashAnimView f9558c;
    @NonNull

    /* renamed from: d */
    public final ViewStubProxy f9559d;
    @NonNull

    /* renamed from: e */
    public final ViewStubProxy f9560e;
    @NonNull

    /* renamed from: f */
    public final ViewStubProxy f9561f;

    public DelayInflateOneBinding(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ViewStubProxy viewStubProxy, SplashAnimView splashAnimView, ViewStubProxy viewStubProxy2, ViewStubProxy viewStubProxy3, ViewStubProxy viewStubProxy4) {
        super(dataBindingComponent, view, i);
        this.f9556a = imageView;
        this.f9557b = viewStubProxy;
        this.f9558c = splashAnimView;
        this.f9559d = viewStubProxy2;
        this.f9560e = viewStubProxy3;
        this.f9561f = viewStubProxy4;
    }
}
