package com.meizu.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.PinnedHeaderListView;

public abstract class PinnedHeaderListAdapter extends MultiCursorPartitionAdapter implements PinnedHeaderListView.C1484b {

    /* renamed from: g */
    private boolean f5852g;

    /* renamed from: h */
    private boolean[] f5853h;

    public PinnedHeaderListAdapter(Context context) {
        super(context);
    }

    public PinnedHeaderListAdapter(Context context, int i) {
        super(context, i);
    }

    /* renamed from: g */
    public boolean mo17049g() {
        return this.f5852g;
    }

    /* renamed from: e */
    public void mo17047e(boolean z) {
        this.f5852g = z;
    }

    /* renamed from: f */
    public int mo17048f() {
        if (this.f5852g) {
            return mo16203c();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo17050k(int i) {
        return this.f5852g && mo16201b(i) && !mo16208d(i);
    }

    /* renamed from: a */
    public View mo17045a(int i, View view, ViewGroup viewGroup) {
        Integer num;
        if (!mo16201b(i)) {
            return null;
        }
        if (view == null || (num = (Integer) view.getTag()) == null || num.intValue() != 0) {
            view = null;
        }
        int g = mo16213g(i);
        if (view == null) {
            view = mo16198b(this.f4720a, g, i, viewGroup);
            view.setTag(0);
            view.setFocusable(false);
            view.setEnabled(false);
        }
        mo16200b(view, this.f4720a, g, i);
        return view;
    }

    /* renamed from: a */
    public void mo17046a(PinnedHeaderListView pinnedHeaderListView) {
        int e;
        if (this.f5852g) {
            int c = mo16203c();
            if (this.f5853h == null || this.f5853h.length != c) {
                this.f5853h = new boolean[c];
            }
            for (int i = 0; i < c; i++) {
                boolean k = mo17050k(i);
                this.f5853h[i] = k;
                if (!k) {
                    pinnedHeaderListView.setHeaderInvisible(i, true);
                }
            }
            int headerViewsCount = pinnedHeaderListView.getHeaderViewsCount();
            int i2 = 0;
            int i3 = -1;
            for (int i4 = 0; i4 < c; i4++) {
                if (this.f5853h[i4]) {
                    if (i4 > mo16209e(pinnedHeaderListView.mo17052b(i2) - headerViewsCount)) {
                        break;
                    }
                    pinnedHeaderListView.setHeaderPinnedAtTop(i4, i2, false);
                    i2 += pinnedHeaderListView.mo17051a(i4);
                    i3 = i4;
                }
            }
            int height = pinnedHeaderListView.getHeight();
            int i5 = c;
            int i6 = 0;
            while (true) {
                c--;
                if (c > i3) {
                    if (this.f5853h[c]) {
                        int b = pinnedHeaderListView.mo17052b(height - i6) - headerViewsCount;
                        if (b < 0 || (e = mo16209e(b - 1)) == -1 || c <= e) {
                            break;
                        }
                        i6 += pinnedHeaderListView.mo17051a(c);
                        pinnedHeaderListView.setHeaderPinnedAtBottom(c, height - i6, b < mo16213g(c));
                        i5 = c;
                    }
                } else {
                    break;
                }
            }
            for (int i7 = i3 + 1; i7 < i5; i7++) {
                if (this.f5853h[i7]) {
                    pinnedHeaderListView.setHeaderInvisible(i7, mo16208d(i7));
                }
            }
        }
    }
}
