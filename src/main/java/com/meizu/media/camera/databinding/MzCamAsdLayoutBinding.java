package com.meizu.media.camera.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.GlowImageView;

public abstract class MzCamAsdLayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final GlowImageView f9653a;

    public MzCamAsdLayoutBinding(DataBindingComponent dataBindingComponent, View view, int i, GlowImageView glowImageView) {
        super(dataBindingComponent, view, i);
        this.f9653a = glowImageView;
    }
}
