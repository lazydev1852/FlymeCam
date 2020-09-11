package com.meizu.media.camera.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView;

public abstract class MzVideoContainerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final MzVideoSurfaceView f9847a;

    public MzVideoContainerBinding(DataBindingComponent dataBindingComponent, View view, int i, MzVideoSurfaceView mzVideoSurfaceView) {
        super(dataBindingComponent, view, i);
        this.f9847a = mzVideoSurfaceView;
    }
}
