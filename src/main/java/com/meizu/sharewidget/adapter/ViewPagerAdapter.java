package com.meizu.sharewidget.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private List<View> f15914a;

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public ViewPagerAdapter(Context context, List<View> list) {
        this.f15914a = list;
    }

    /* renamed from: a */
    public List<View> mo24085a() {
        return this.f15914a;
    }

    public int getCount() {
        return this.f15914a.size();
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.f15914a.get(i));
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f15914a.get(i), new ViewGroup.LayoutParams(-1, -1));
        return this.f15914a.get(i);
    }
}
