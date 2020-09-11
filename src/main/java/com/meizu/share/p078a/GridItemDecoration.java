package com.meizu.share.p078a;

import android.graphics.Rect;
import android.view.View;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: com.meizu.share.a.a */
public class GridItemDecoration extends RecyclerView.C3265f {

    /* renamed from: a */
    private int f15659a;

    /* renamed from: b */
    private int f15660b;

    public GridItemDecoration(int i, int i2) {
        this.f15659a = i;
        this.f15660b = i2;
    }

    /* renamed from: a */
    public void mo23920a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C3283r rVar) {
        super.mo23920a(rect, view, recyclerView, rVar);
        int i = recyclerView.mo26424i(view);
        if (recyclerView.getAdapter() instanceof HeaderAndFooterAdapter) {
            HeaderAndFooterAdapter bVar = (HeaderAndFooterAdapter) recyclerView.getAdapter();
            if (!bVar.mo23924a(i) && !bVar.mo23929b(i)) {
                i = bVar.mo23935e(i);
            } else {
                return;
            }
        }
        int i2 = i % this.f15659a;
        rect.left = (this.f15660b * i2) / this.f15659a;
        rect.right = this.f15660b - (((i2 + 1) * this.f15660b) / this.f15659a);
    }
}
