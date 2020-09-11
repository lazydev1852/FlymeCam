package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import flyme.support.p093v7.widget.Toolbar;

public abstract class MzSettingControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final LinearLayout f9813a;
    @NonNull

    /* renamed from: b */
    public final ListView f9814b;
    @NonNull

    /* renamed from: c */
    public final Toolbar f9815c;

    public MzSettingControlBinding(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ListView listView, Toolbar toolbar) {
        super(dataBindingComponent, view, i);
        this.f9813a = linearLayout;
        this.f9814b = listView;
        this.f9815c = toolbar;
    }
}
