package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.views.DocScannerView;

public abstract class MzDocBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final DocScannerView f9709a;
    @NonNull

    /* renamed from: b */
    public final LinearLayout f9710b;

    public MzDocBinding(DataBindingComponent dataBindingComponent, View view, int i, DocScannerView docScannerView, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.f9709a = docScannerView;
        this.f9710b = linearLayout;
    }
}
