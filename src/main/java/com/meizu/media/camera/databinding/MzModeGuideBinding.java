package com.meizu.media.camera.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.views.GuidePageIndicator;

public abstract class MzModeGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: a */
    public final GuidePageIndicator f9789a;
    @NonNull

    /* renamed from: b */
    public final ImageView f9790b;
    @NonNull

    /* renamed from: c */
    public final RelativeLayout f9791c;
    @NonNull

    /* renamed from: d */
    public final ImageView f9792d;
    @NonNull

    /* renamed from: e */
    public final ViewPager f9793e;
    @NonNull

    /* renamed from: f */
    public final Button f9794f;
    @NonNull

    /* renamed from: g */
    public final TextView f9795g;

    public MzModeGuideBinding(DataBindingComponent dataBindingComponent, View view, int i, GuidePageIndicator guidePageIndicator, ImageView imageView, RelativeLayout relativeLayout, ImageView imageView2, ViewPager viewPager, Button button, TextView textView) {
        super(dataBindingComponent, view, i);
        this.f9789a = guidePageIndicator;
        this.f9790b = imageView;
        this.f9791c = relativeLayout;
        this.f9792d = imageView2;
        this.f9793e = viewPager;
        this.f9794f = button;
        this.f9795g = textView;
    }
}
