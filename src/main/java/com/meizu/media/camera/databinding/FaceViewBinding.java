package com.meizu.media.camera.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.FaceView;

public abstract class FaceViewBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final FaceView f9601a;

    public FaceViewBinding(DataBindingComponent dataBindingComponent, View view, int i, FaceView faceView) {
        super(dataBindingComponent, view, i);
        this.f9601a = faceView;
    }
}
