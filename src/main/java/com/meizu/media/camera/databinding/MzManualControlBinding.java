package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.HorizontalPickerView;
import com.meizu.media.camera.views.ManualCircleBoardView;
import flyme.support.p093v7.widget.MzRecyclerView;

public abstract class MzManualControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final HorizontalPickerView f9779a;
    @NonNull

    /* renamed from: b */
    public final ManualCircleBoardView f9780b;
    @NonNull

    /* renamed from: c */
    public final TextView f9781c;
    @NonNull

    /* renamed from: d */
    public final FrameLayout f9782d;
    @NonNull

    /* renamed from: e */
    public final LinearLayout f9783e;
    @NonNull

    /* renamed from: f */
    public final MzRecyclerView f9784f;

    public MzManualControlBinding(DataBindingComponent dataBindingComponent, View view, int i, HorizontalPickerView horizontalPickerView, ManualCircleBoardView manualCircleBoardView, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, MzRecyclerView mzRecyclerView) {
        super(dataBindingComponent, view, i);
        this.f9779a = horizontalPickerView;
        this.f9780b = manualCircleBoardView;
        this.f9781c = textView;
        this.f9782d = frameLayout;
        this.f9783e = linearLayout;
        this.f9784f = mzRecyclerView;
    }
}
