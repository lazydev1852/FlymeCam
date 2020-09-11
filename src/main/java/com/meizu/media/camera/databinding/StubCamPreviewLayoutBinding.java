package com.meizu.media.camera.databinding;

import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public abstract class StubCamPreviewLayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final TextureView f9879a;

    public StubCamPreviewLayoutBinding(DataBindingComponent dataBindingComponent, View view, int i, TextureView textureView) {
        super(dataBindingComponent, view, i);
        this.f9879a = textureView;
    }
}
