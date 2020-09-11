package com.meizu.sharewidget.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.meizu.sharewidget.R;
import flyme.support.p092v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class PageIndicator extends LinearLayout {

    /* renamed from: a */
    private Context f15968a;

    /* renamed from: b */
    private List<ImageView> f15969b;

    public PageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public PageIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15968a = context;
        this.f15969b = new ArrayList();
    }

    public void setCount(int i) {
        removeAllViews();
        this.f15969b.clear();
        this.f15969b = new ArrayList();
        if (i < 2) {
            setVisibility(8);
            return;
        }
        int i2 = 0;
        setVisibility(0);
        while (i2 < i) {
            ImageView imageView = new ImageView(this.f15968a);
            imageView.setBackgroundResource(i2 == 0 ? R.drawable.dark : R.drawable.light);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
            layoutParams.leftMargin = this.f15968a.getResources().getDimensionPixelSize(R.dimen.share_page_point_view_margin);
            layoutParams.rightMargin = this.f15968a.getResources().getDimensionPixelSize(R.dimen.share_page_point_view_margin);
            layoutParams.width = this.f15968a.getResources().getDimensionPixelSize(R.dimen.share_page_point_view_width);
            layoutParams.height = this.f15968a.getResources().getDimensionPixelSize(R.dimen.share_page_point_view_height);
            addView(imageView, layoutParams);
            this.f15969b.add(imageView);
            i2++;
        }
    }

    public void setSelectedPosition(int i) {
        int i2 = 0;
        while (i2 < this.f15969b.size()) {
            this.f15969b.get(i2).setBackgroundResource(i == i2 ? R.drawable.dark : R.drawable.light);
            i2++;
        }
    }

    /* renamed from: a */
    public void mo24127a(ViewPager viewPager) {
        setCount(viewPager.getAdapter().getCount());
        viewPager.mo24936a((ViewPager.C3054e) new ViewPager.C3054e() {
            /* renamed from: a */
            public void mo17730a(int i, float f, int i2) {
            }

            /* renamed from: b */
            public void mo17731b(int i) {
            }

            /* renamed from: a */
            public void mo17729a(int i) {
                PageIndicator.this.setSelectedPosition(i);
            }
        });
    }
}
