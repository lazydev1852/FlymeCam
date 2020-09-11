package com.meizu.media.camera.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.CountDownView;
import com.meizu.media.camera.views.RotateTextView;

public abstract class CountDownToCaptureBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final CountDownView f9550a;
    @NonNull

    /* renamed from: b */
    public final RotateTextView f9551b;

    public CountDownToCaptureBinding(DataBindingComponent dataBindingComponent, View view, int i, CountDownView countDownView, RotateTextView rotateTextView) {
        super(dataBindingComponent, view, i);
        this.f9550a = countDownView;
        this.f9551b = rotateTextView;
    }
}
