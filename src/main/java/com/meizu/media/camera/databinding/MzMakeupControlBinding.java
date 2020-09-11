package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.common.widget.EnhanceGallery;

public abstract class MzMakeupControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final EnhanceGallery f9773a;
    @NonNull

    /* renamed from: b */
    public final LinearLayout f9774b;

    public MzMakeupControlBinding(DataBindingComponent dataBindingComponent, View view, int i, EnhanceGallery enhanceGallery, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.f9773a = enhanceGallery;
        this.f9774b = linearLayout;
    }
}
