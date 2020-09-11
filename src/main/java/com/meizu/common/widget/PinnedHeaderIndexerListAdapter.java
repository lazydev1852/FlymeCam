package com.meizu.common.widget;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.meizu.common.R;

/* renamed from: com.meizu.common.widget.f */
public abstract class PinnedHeaderIndexerListAdapter extends PinnedHeaderListAdapter implements SectionIndexer {

    /* renamed from: g */
    protected Context f6391g;

    /* renamed from: h */
    private SectionIndexer f6392h;

    /* renamed from: i */
    private int f6393i;

    /* renamed from: j */
    private boolean f6394j;

    /* renamed from: k */
    private View f6395k;

    /* renamed from: l */
    private boolean f6396l;

    /* renamed from: m */
    private SparseIntArray f6397m;

    /* renamed from: n */
    private C1556a f6398n;

    /* renamed from: o */
    private int f6399o;

    /* renamed from: p */
    private int f6400p;

    /* renamed from: com.meizu.common.widget.f$a */
    /* compiled from: PinnedHeaderIndexerListAdapter */
    public static final class C1556a {

        /* renamed from: a */
        public boolean f6401a;

        /* renamed from: b */
        public boolean f6402b;

        /* renamed from: c */
        public String f6403c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f6404d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15859a(ListView listView, int i, int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo17583i(int i) {
        return true;
    }

    /* renamed from: c */
    public void mo17577c(boolean z) {
        this.f6396l = z;
        mo16195a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo15855a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mc_pinned_header_view, viewGroup, false);
        if (inflate != null) {
            ((ImageView) inflate.findViewById(16908288)).setVisibility(8);
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15856a(View view, int i) {
        if (view != null) {
            ((TextView) view.findViewById(R.id.mc_header_text1)).setText((String) getSections()[i]);
        }
    }

    /* renamed from: e */
    public boolean mo17579e() {
        return this.f6394j;
    }

    /* renamed from: d */
    public void mo17578d(boolean z) {
        this.f6394j = z;
    }

    public Object[] getSections() {
        if (this.f6392h == null) {
            return new String[]{" "};
        }
        return this.f6392h.getSections();
    }

    public int getPositionForSection(int i) {
        if (this.f6392h == null) {
            return -1;
        }
        if (i < 0) {
            return 0;
        }
        int positionForSection = this.f6392h.getPositionForSection(i) + this.f4724e[this.f6393i].f4733f;
        if (this.f6396l) {
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6397m.indexOfKey(i2) >= 0) {
                    positionForSection++;
                }
            }
        }
        return positionForSection;
    }

    public int getSectionForPosition(int i) {
        if (this.f6392h == null) {
            return -1;
        }
        if (mo16202b(this.f6393i, i) || i > this.f4724e[this.f6393i].f4731d - 1) {
            return getSections().length - 1;
        }
        int i2 = i - this.f4724e[this.f6393i].f4733f;
        if (i2 < 0) {
            return -1;
        }
        if (this.f6396l) {
            int i3 = 0;
            while (i3 < this.f6397m.size() && this.f6397m.valueAt(i3) < i) {
                i2--;
                i3++;
            }
        }
        return this.f6392h.getSectionForPosition(i2);
    }

    /* renamed from: f */
    public int mo17048f() {
        if (mo17579e()) {
            return super.mo17048f() + 1;
        }
        return super.mo17048f();
    }

    /* renamed from: a */
    public View mo17045a(int i, View view, ViewGroup viewGroup) {
        if (!mo17579e() || i != mo17048f() - 1) {
            return super.mo17045a(i, view, viewGroup);
        }
        if (this.f6395k == null) {
            this.f6395k = mo15855a(this.f6391g, viewGroup);
        }
        return this.f6395k;
    }

    /* renamed from: a */
    public void mo17046a(PinnedHeaderListView pinnedHeaderListView) {
        int e;
        int f;
        super.mo17046a(pinnedHeaderListView);
        if (mo17049g() && mo17579e()) {
            int currentOverScrollDistance = pinnedHeaderListView.getCurrentOverScrollDistance();
            boolean z = true;
            int i = 0;
            boolean z2 = currentOverScrollDistance <= 0 && pinnedHeaderListView.getFirstVisiblePosition() == 0;
            if (z2 && this.f6400p >= 0) {
                mo15859a((ListView) pinnedHeaderListView, m6292l(0) + pinnedHeaderListView.getHeaderViewsCount(), 0, true);
            }
            this.f6400p = currentOverScrollDistance;
            int f2 = mo17048f() - 1;
            if (this.f6392h == null || getCount() == 0 || z2) {
                pinnedHeaderListView.setHeaderInvisible(f2, false);
                this.f6399o = -1;
                return;
            }
            int b = pinnedHeaderListView.mo17052b(pinnedHeaderListView.getTotalTopPinnedHeaderHeight() + pinnedHeaderListView.getHeaderPaddingTop());
            int headerViewsCount = b - pinnedHeaderListView.getHeaderViewsCount();
            int sectionForPosition = (pinnedHeaderListView.getChildAt(0) == null || pinnedHeaderListView.getChildAt(0).getTop() - pinnedHeaderListView.getDividerHeight() > pinnedHeaderListView.getHeaderPaddingTop() || (e = mo16209e(headerViewsCount)) != this.f6393i || (f = mo16211f(headerViewsCount)) < this.f4724e[e].f4733f) ? -1 : getSectionForPosition(f);
            if (this.f6399o == sectionForPosition && sectionForPosition != -1 && m6292l(sectionForPosition) == headerViewsCount) {
                mo15859a((ListView) pinnedHeaderListView, b, sectionForPosition, true);
            }
            if (this.f6399o > sectionForPosition) {
                for (int i2 = this.f6399o; i2 > sectionForPosition; i2--) {
                    mo15859a((ListView) pinnedHeaderListView, m6292l(i2) + pinnedHeaderListView.getHeaderViewsCount(), i2, true);
                }
            } else if (this.f6399o < sectionForPosition) {
                for (int i3 = this.f6399o + 1; i3 <= sectionForPosition; i3++) {
                    mo15859a((ListView) pinnedHeaderListView, m6292l(i3) + pinnedHeaderListView.getHeaderViewsCount(), i3, false);
                }
            }
            this.f6399o = sectionForPosition;
            if (sectionForPosition == -1 || !mo17583i(sectionForPosition)) {
                pinnedHeaderListView.setHeaderInvisible(f2, false);
                return;
            }
            mo15856a(this.f6395k, sectionForPosition);
            if (headerViewsCount != m6292l(sectionForPosition + 1) - 1) {
                z = false;
            }
            if (z && pinnedHeaderListView.getChildAt(0).getBottom() < pinnedHeaderListView.mo17051a(f2)) {
                i = pinnedHeaderListView.getChildAt(0).getBottom() - pinnedHeaderListView.mo17051a(f2);
            }
            pinnedHeaderListView.setTranslateHeader(f2, i);
        }
    }

    /* renamed from: l */
    private int m6292l(int i) {
        int g = mo16213g(this.f6393i);
        if (mo16201b(this.f6393i)) {
            g++;
        }
        return g + getPositionForSection(i);
    }

    /* renamed from: j */
    public C1556a mo17584j(int i) {
        if (this.f6398n.f6404d == i) {
            return this.f6398n;
        }
        int unused = this.f6398n.f6404d = i;
        boolean z = false;
        if (mo17579e()) {
            int sectionForPosition = getSectionForPosition(i);
            if (sectionForPosition == -1 || getPositionForSection(sectionForPosition) != i) {
                this.f6398n.f6401a = false;
                this.f6398n.f6403c = null;
            } else {
                this.f6398n.f6401a = true;
                this.f6398n.f6403c = (String) getSections()[sectionForPosition];
            }
            C1556a aVar = this.f6398n;
            if (getPositionForSection(sectionForPosition + 1) - 1 == i) {
                z = true;
            }
            aVar.f6402b = z;
        } else {
            this.f6398n.f6401a = false;
            this.f6398n.f6402b = false;
            this.f6398n.f6403c = null;
        }
        return this.f6398n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo16207d(int i, int i2) {
        int i3;
        if (this.f6393i != i || i2 < 0 || this.f6392h == null) {
            return super.mo16207d(i, i2);
        }
        if (mo16196a(this.f6393i, i2)) {
            int i4 = this.f4724e[this.f6393i].f4733f;
            if (i4 == 1) {
                return 4;
            }
            if (i2 == 0) {
                return 1;
            }
            return i2 == i4 - 1 ? 3 : 2;
        } else if (mo16202b(this.f6393i, i2)) {
            int i5 = this.f4724e[this.f6393i].f4734g;
            int i6 = this.f4724e[this.f6393i].f4731d - i5;
            if (i5 == 1) {
                return 4;
            }
            if (i2 == i6) {
                return 1;
            }
            return i2 - i6 == i5 - 1 ? 3 : 2;
        } else {
            int sectionForPosition = getSectionForPosition(i2);
            int positionForSection = getPositionForSection(sectionForPosition);
            if (sectionForPosition == getSections().length - 1) {
                i3 = mo16204c(i);
            } else {
                i3 = getPositionForSection(sectionForPosition + 1);
            }
            if (this.f6396l) {
                if (i2 == positionForSection) {
                    return 0;
                }
                positionForSection++;
            }
            if (i2 == positionForSection && i3 - positionForSection == 1) {
                return 4;
            }
            if (i2 == positionForSection) {
                return 1;
            }
            return i2 == i3 - 1 ? 3 : 2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo16199b() {
        if (!this.f4725f) {
            super.mo16199b();
            m6291h();
        }
    }

    /* renamed from: h */
    private void m6291h() {
        int sectionForPosition;
        this.f6397m.clear();
        if (this.f6396l && this.f6392h != null && this.f4724e[this.f6393i].f4732e > 0) {
            int i = this.f4724e[this.f6393i].f4733f;
            int i2 = -1;
            int i3 = 0;
            while (i3 < this.f4724e[this.f6393i].f4732e && i2 != (sectionForPosition = this.f6392h.getSectionForPosition(i3))) {
                this.f6397m.put(sectionForPosition, i3 + i + this.f6397m.size());
                int positionForSection = this.f6392h.getPositionForSection(sectionForPosition + 1);
                if (i3 == positionForSection) {
                    break;
                }
                i3 = positionForSection;
                i2 = sectionForPosition;
            }
            int size = this.f6397m.size();
            this.f4724e[this.f6393i].f4731d += size;
            this.f4724e[this.f6393i].f4730c += size;
            this.f4721b += size;
        }
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo16205c(int i, int i2) {
        if (this.f6393i == i && this.f6396l && this.f6397m.size() > 0) {
            if (this.f6397m.indexOfValue(mo16211f(i2)) >= 0) {
                return getViewTypeCount() - 1;
            }
        }
        return super.mo16205c(i, i2);
    }

    public boolean areAllItemsEnabled() {
        mo16199b();
        if (!this.f6396l || this.f6397m.size() <= 0) {
            return super.areAllItemsEnabled();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo16210e(int i, int i2) {
        if (this.f6393i != i || !this.f6396l || this.f6397m.indexOfValue(i2) < 0) {
            return super.mo16210e(i, i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo16221h(int i, int i2) {
        if (this.f6393i != i || !this.f6396l || this.f6397m.indexOfValue(i2) < 0) {
            return super.mo16221h(i, i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int mo16938i(int i, int i2) {
        if (this.f6393i != i || !this.f6396l) {
            return super.mo16938i(i, i2);
        }
        if (this.f6397m.indexOfValue(i2) >= 0) {
            return -1;
        }
        int i3 = i2 - this.f4724e[this.f6393i].f4733f;
        int i4 = 0;
        while (i4 < this.f6397m.size() && this.f6397m.valueAt(i4) <= i2) {
            i3--;
            i4++;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo16192a(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        int indexOfValue;
        if (this.f6393i != i2 || !this.f6396l || (indexOfValue = this.f6397m.indexOfValue(i3)) < 0) {
            return super.mo16192a(i, i2, i3, i4, view, viewGroup);
        }
        return mo17576b(i3, this.f6397m.keyAt(indexOfValue), view, viewGroup);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public View mo17576b(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mo15854a(this.f6391g, i, i2, viewGroup);
        }
        mo15857a(view, this.f6391g, i, i2);
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo15854a(Context context, int i, int i2, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.mc_pinned_group_header, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15857a(View view, Context context, int i, int i2) {
        view.setVisibility(0);
        ((TextView) view.findViewById(R.id.mc_header_text1)).setText((String) getSections()[i2]);
        if (i == 0) {
            view.setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.mz_pinned_top_header_minHeight));
        } else {
            view.setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.mz_pinned_interval_header_minHeight));
        }
    }
}
