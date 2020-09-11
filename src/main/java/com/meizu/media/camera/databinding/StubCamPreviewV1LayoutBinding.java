package com.meizu.media.camera.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView;

public abstract class StubCamPreviewV1LayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final CameraPreviewRenderView f9884a;

    public StubCamPreviewV1LayoutBinding(DataBindingComponent dataBindingComponent, View view, int i, CameraPreviewRenderView cameraPreviewRenderView) {
        super(dataBindingComponent, view, i);
        this.f9884a = cameraPreviewRenderView;
    }
}
