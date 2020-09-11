package com.meizu.share.p078a;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import flyme.support.p093v7.widget.GridLayoutManager;
import flyme.support.p093v7.widget.RecyclerView;
import flyme.support.p093v7.widget.StaggeredGridLayoutManager;
import java.util.List;

/* renamed from: com.meizu.share.a.b */
public class HeaderAndFooterAdapter<T> extends RecyclerView.C3260a<RecyclerView.C3286u> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SparseArrayCompat<View> f15661a = new SparseArrayCompat<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SparseArrayCompat<View> f15662b = new SparseArrayCompat<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView.C3260a f15663c;

    /* renamed from: d */
    private final RecyclerView.C3262c f15664d = new RecyclerView.C3262c() {
        /* renamed from: a */
        public void mo23939a() {
            if (HeaderAndFooterAdapter.this.f15663c != null) {
                HeaderAndFooterAdapter.this.f15663c.mo26541f();
            }
        }

        /* renamed from: a */
        public void mo23940a(int i, int i2) {
            if (HeaderAndFooterAdapter.this.f15663c != null) {
                HeaderAndFooterAdapter.this.f15663c.mo26537a(i, i2);
            }
        }

        /* renamed from: a */
        public void mo23941a(int i, int i2, Object obj) {
            if (HeaderAndFooterAdapter.this.f15663c != null) {
                HeaderAndFooterAdapter.this.f15663c.mo26538a(i, i2, obj);
            }
        }
    };

    public HeaderAndFooterAdapter(RecyclerView.C3260a aVar) {
        this.f15663c = aVar;
    }

    /* renamed from: b */
    public RecyclerView.C3286u mo20098b(ViewGroup viewGroup, int i) {
        if (this.f15661a.get(i) != null) {
            return new C2809a(this.f15661a.get(i));
        }
        if (this.f15662b.get(i) != null) {
            return new C2809a(this.f15662b.get(i));
        }
        if (this.f15663c != null) {
            return this.f15663c.mo20098b(viewGroup, i);
        }
        return null;
    }

    /* renamed from: com.meizu.share.a.b$a */
    /* compiled from: HeaderAndFooterAdapter */
    private static class C2809a extends RecyclerView.C3286u {
        public C2809a(View view) {
            super(view);
        }
    }

    /* renamed from: a_ */
    public int mo22520a_(int i) {
        if (mo23924a(i)) {
            return this.f15661a.keyAt(i);
        }
        if (mo23929b(i)) {
            return this.f15662b.keyAt((i - mo23925b()) - m16989e());
        }
        if (this.f15663c != null) {
            return this.f15663c.mo22520a_(i - mo23925b());
        }
        return -2;
    }

    /* renamed from: e */
    private int m16989e() {
        if (this.f15663c != null) {
            return this.f15663c.mo20093a();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo20097a(RecyclerView.C3286u uVar, int i) {
        if (!mo23924a(i) && !mo23929b(i) && this.f15663c != null) {
            this.f15663c.mo20097a(uVar, i - mo23925b());
        }
    }

    /* renamed from: a */
    public void mo23922a(RecyclerView.C3286u uVar, int i, List<Object> list) {
        if (!mo23924a(i) && !mo23929b(i) && this.f15663c != null) {
            this.f15663c.mo23922a(uVar, i - mo23925b(), list);
        }
    }

    /* renamed from: a */
    public int mo20093a() {
        return mo23925b() + mo23930c() + m16989e();
    }

    /* renamed from: a */
    public void mo23923a(RecyclerView recyclerView) {
        if (this.f15663c != null) {
            this.f15663c.mo23923a(recyclerView);
        }
        mo23928b(recyclerView);
    }

    /* renamed from: b */
    public void mo23928b(RecyclerView recyclerView) {
        RecyclerView.C3266g layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager kVar = (GridLayoutManager) layoutManager;
            final GridLayoutManager.C3336c c = kVar.mo27180c();
            kVar.mo27179a((GridLayoutManager.C3336c) new GridLayoutManager.C3336c() {
                /* renamed from: a */
                public int mo23938a(int i) {
                    int a_ = HeaderAndFooterAdapter.this.mo22520a_(i);
                    if (HeaderAndFooterAdapter.this.f15661a.get(a_) != null) {
                        return kVar.mo27181d();
                    }
                    if (HeaderAndFooterAdapter.this.f15662b.get(a_) != null) {
                        return kVar.mo27181d();
                    }
                    if (c != null) {
                        return c.mo23938a(i);
                    }
                    return 1;
                }
            });
            kVar.mo27178a(kVar.mo27181d());
        }
    }

    /* renamed from: c */
    public void mo23932c(RecyclerView recyclerView) {
        if (this.f15663c != null) {
            this.f15663c.mo23932c(recyclerView);
        }
    }

    /* renamed from: b */
    public void mo23927b(RecyclerView.C3286u uVar) {
        ViewGroup.LayoutParams layoutParams;
        if (this.f15663c != null) {
            this.f15663c.mo23927b(uVar);
        }
        int f = uVar.mo26772f();
        if ((mo23924a(f) || mo23929b(f)) && (layoutParams = uVar.f18121j.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.C3308b)) {
            ((StaggeredGridLayoutManager.C3308b) layoutParams).mo26899a(true);
        }
    }

    /* renamed from: c */
    public void mo23931c(RecyclerView.C3286u uVar) {
        if (this.f15663c != null) {
            this.f15663c.mo23931c(uVar);
        }
    }

    /* renamed from: a */
    public boolean mo23924a(int i) {
        return i < mo23925b();
    }

    /* renamed from: b */
    public boolean mo23929b(int i) {
        if (i >= mo20093a()) {
            Log.e("HeaderAndFooterAdapter", "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is " + i + ", but total itemcount is " + mo20093a() + ", headers:" + mo23925b() + ", items:" + m16989e() + ", footers:" + mo23930c());
            return false;
        } else if (i >= mo23925b() + m16989e()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: e */
    public int mo23935e(int i) {
        return i - mo23925b();
    }

    /* renamed from: b */
    public int mo23925b() {
        return this.f15661a.size();
    }

    /* renamed from: c */
    public int mo23930c() {
        return this.f15662b.size();
    }

    /* renamed from: a */
    public void mo23921a(RecyclerView.C3262c cVar) {
        this.f15663c.mo23921a(cVar);
        super.mo23921a(this.f15664d);
    }

    /* renamed from: b */
    public void mo23926b(RecyclerView.C3262c cVar) {
        this.f15663c.mo23926b(cVar);
        super.mo23926b(this.f15664d);
    }

    /* renamed from: f */
    public boolean mo23936f(int i) {
        int i2;
        int b = mo23925b();
        if (i < 0 || i >= b) {
            int i3 = i - b;
            if (this.f15663c == null || i < b) {
                i2 = 0;
            } else {
                i2 = m16989e();
                if (i3 < i2) {
                    return this.f15663c.mo23936f(i3);
                }
            }
            int i4 = i3 - i2;
            if (i4 < 0 || i4 >= mo23930c() || this.f15662b.valueAt(i4) != null) {
                return false;
            }
            return true;
        } else if (this.f15661a.valueAt(i) == null) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: g */
    public boolean mo23937g(int i) {
        int b = mo23925b();
        if (i < b) {
            return false;
        }
        int i2 = i - b;
        if (this.f15663c == null || i < b || i2 >= m16989e()) {
            return false;
        }
        return this.f15663c.mo23937g(i2);
    }

    /* renamed from: c */
    public long mo20100c(int i) {
        int i2;
        int b = mo23925b();
        if (this.f15663c == null || i < b || (i2 = i - b) >= m16989e()) {
            return -1;
        }
        return this.f15663c.mo20100c(i2);
    }

    /* renamed from: a */
    public void mo20096a(RecyclerView.C3286u uVar) {
        if (this.f15663c != null) {
            this.f15663c.mo20096a(uVar);
        }
    }

    /* renamed from: d */
    public boolean mo23934d(RecyclerView.C3286u uVar) {
        if (this.f15663c != null) {
            return this.f15663c.mo23934d(uVar);
        }
        return super.mo23934d(uVar);
    }

    /* renamed from: d */
    public boolean mo23933d() {
        if (this.f15663c != null) {
            return this.f15663c.mo23933d();
        }
        return super.mo23933d();
    }
}
