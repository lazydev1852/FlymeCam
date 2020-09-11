package com.meizu.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BasePartitionAdapter extends AbsBasePartitionAdapter {

    /* renamed from: a */
    protected final Context f4720a;

    /* renamed from: b */
    protected int f4721b;

    /* renamed from: c */
    protected int f4722c;

    /* renamed from: d */
    protected int f4723d;

    /* renamed from: e */
    protected C1369a[] f4724e;

    /* renamed from: f */
    protected boolean f4725f;

    /* renamed from: g */
    private boolean f4726g;

    /* renamed from: h */
    private boolean f4727h;

    /* renamed from: com.meizu.common.widget.BasePartitionAdapter$b */
    public class C1370b {

        /* renamed from: a */
        public View f4737a;

        /* renamed from: b */
        public Object f4738b;

        /* renamed from: c */
        public boolean f4739c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract View mo16192a(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public View mo16198b(Context context, int i, int i2, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo16200b(View view, Context context, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo16205c(int i, int i2) {
        return 1;
    }

    /* renamed from: d */
    public int mo16206d() {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo16210e(int i, int i2) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract Object mo16212f(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract long mo16214g(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo16221h(int i, int i2) {
        return true;
    }

    /* renamed from: com.meizu.common.widget.BasePartitionAdapter$a */
    public static class C1369a {

        /* renamed from: a */
        boolean f4728a;

        /* renamed from: b */
        boolean f4729b;

        /* renamed from: c */
        int f4730c;

        /* renamed from: d */
        int f4731d;

        /* renamed from: e */
        int f4732e;

        /* renamed from: f */
        int f4733f;

        /* renamed from: g */
        int f4734g;

        /* renamed from: h */
        ArrayList<C1370b> f4735h;

        /* renamed from: i */
        ArrayList<C1370b> f4736i;

        public String toString() {
            return "\n Partition: mShowIfEmpty: " + this.f4728a + ",mHasHeader: " + this.f4729b + ",mSize: " + this.f4730c + ",mCount: " + this.f4731d + ",mItemCount: " + this.f4732e + ",mHeaderViewsCount: " + this.f4733f + ",mFooterViewsCount: " + this.f4734g;
        }
    }

    public BasePartitionAdapter(Context context) {
        this(context, 10);
    }

    public BasePartitionAdapter(Context context, int i) {
        this.f4726g = true;
        this.f4720a = context;
        this.f4724e = new C1369a[i];
    }

    /* renamed from: a */
    public C1369a mo16194a(int i) {
        if (i < this.f4723d) {
            return this.f4724e[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* renamed from: b */
    public boolean mo16201b(int i) {
        return this.f4724e[i].f4729b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16195a() {
        this.f4725f = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo16199b() {
        if (!this.f4725f) {
            this.f4721b = 0;
            this.f4722c = 0;
            for (int i = 0; i < this.f4723d; i++) {
                this.f4724e[i].f4733f = this.f4724e[i].f4735h.size();
                this.f4724e[i].f4734g = this.f4724e[i].f4736i.size();
                this.f4724e[i].f4731d = this.f4724e[i].f4733f + this.f4724e[i].f4732e + this.f4724e[i].f4734g;
                int i2 = this.f4724e[i].f4731d;
                if (this.f4724e[i].f4729b && (i2 != 0 || this.f4724e[i].f4728a)) {
                    i2++;
                }
                this.f4724e[i].f4730c = i2;
                this.f4721b += i2;
                this.f4722c += this.f4724e[i].f4732e;
            }
            this.f4725f = true;
        }
    }

    public int getCount() {
        mo16199b();
        return this.f4721b;
    }

    /* renamed from: c */
    public int mo16203c() {
        return this.f4723d;
    }

    /* renamed from: c */
    public int mo16204c(int i) {
        if (i < this.f4723d) {
            mo16199b();
            return this.f4724e[i].f4731d;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* renamed from: d */
    public boolean mo16208d(int i) {
        if (i < this.f4723d) {
            mo16199b();
            return this.f4724e[i].f4731d == 0;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* renamed from: e */
    public int mo16209e(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i >= i3 && i < i4) {
                return i2;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    /* renamed from: f */
    public int mo16211f(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                return this.f4724e[i2].f4729b ? i5 - 1 : i5;
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* renamed from: g */
    public int mo16213g(int i) {
        if (i < this.f4723d) {
            mo16199b();
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += this.f4724e[i3].f4730c;
            }
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo16196a(int i, int i2) {
        return i2 >= 0 && i2 < this.f4724e[i].f4733f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo16202b(int i, int i2) {
        return i2 >= this.f4724e[i].f4731d - this.f4724e[i].f4734g;
    }

    public int getViewTypeCount() {
        return mo16206d() + 1;
    }

    public int getItemViewType(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (this.f4724e[i2].f4729b) {
                    i5--;
                }
                if (i5 == -1) {
                    return 0;
                }
                if (mo16196a(i2, i5) || mo16202b(i2, i5)) {
                    return -2;
                }
                return mo16205c(i2, i);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo16207d(int i, int i2) {
        if (i2 == -1) {
            return 0;
        }
        if (i2 == 0 && this.f4724e[i].f4731d == 1) {
            return 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2 == this.f4724e[i].f4731d - 1 ? 3 : 2;
    }

    /* renamed from: a */
    private boolean m5272a(ArrayList<C1370b> arrayList) {
        Iterator<C1370b> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().f4739c) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllItemsEnabled() {
        for (int i = 0; i < this.f4723d; i++) {
            if (this.f4724e[i].f4729b || !m5272a(this.f4724e[i].f4735h) || !m5272a(this.f4724e[i].f4736i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEnabled(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (this.f4724e[i2].f4729b) {
                    i5--;
                }
                if (i5 == -1) {
                    return false;
                }
                if (mo16196a(i2, i5)) {
                    return this.f4724e[i2].f4735h.get(i5).f4739c;
                }
                if (mo16202b(i2, i5)) {
                    return this.f4724e[i2].f4736i.get(i5 - (this.f4724e[i2].f4731d - this.f4724e[i2].f4734g)).f4739c;
                } else if (!mo16221h(i2, i5)) {
                    return false;
                } else {
                    return mo16210e(i2, i5);
                }
            }
        }
        return false;
    }

    public Object getItem(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (this.f4724e[i2].f4729b) {
                    i5--;
                }
                if (i5 == -1) {
                    return null;
                }
                if (mo16196a(i2, i5)) {
                    return this.f4724e[i2].f4735h.get(i5).f4738b;
                }
                if (!mo16202b(i2, i5)) {
                    return mo16212f(i2, i5);
                }
                return this.f4724e[i2].f4736i.get(i5 - (this.f4724e[i2].f4731d - this.f4724e[i2].f4734g)).f4738b;
            }
        }
        return null;
    }

    public long getItemId(int i) {
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (this.f4724e[i2].f4729b) {
                    i5--;
                }
                if (i5 == -1) {
                    return 0;
                }
                if (mo16196a(i2, i5) || mo16202b(i2, i5)) {
                    return -1;
                }
                return mo16214g(i2, i5);
            }
        }
        return 0;
    }

    public void notifyDataSetChanged() {
        if (this.f4726g) {
            this.f4727h = false;
            super.notifyDataSetChanged();
            return;
        }
        this.f4727h = true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        mo16199b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f4723d) {
            int i4 = this.f4724e[i2].f4730c + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (this.f4724e[i2].f4729b) {
                    i5--;
                }
                int i6 = i5;
                int d = mo16207d(i2, i6);
                if (i6 == -1) {
                    view2 = mo16193a(i, i2, view, viewGroup);
                } else if (mo16196a(i2, i6)) {
                    view2 = this.f4724e[i2].f4735h.get(i6).f4737a;
                } else if (mo16202b(i2, i6)) {
                    view2 = this.f4724e[i2].f4736i.get(i6 - (this.f4724e[i2].f4731d - this.f4724e[i2].f4734g)).f4737a;
                } else {
                    view2 = mo16192a(i, i2, i6, d, view, viewGroup);
                }
                if (view2 != null) {
                    return view2;
                }
                throw new NullPointerException("View should not be null, partition: " + i2 + " position: " + i);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo16193a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mo16198b(this.f4720a, i, i2, viewGroup);
        }
        mo16200b(view, this.f4720a, i, i2);
        return view;
    }
}
