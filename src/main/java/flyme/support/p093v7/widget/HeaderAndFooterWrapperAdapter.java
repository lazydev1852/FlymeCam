package flyme.support.p093v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import flyme.support.p093v7.widget.GridLayoutManager;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import flyme.support.p093v7.widget.StaggeredGridLayoutManager;
import java.util.List;

/* renamed from: flyme.support.v7.widget.l */
public class HeaderAndFooterWrapperAdapter<T> extends RecyclerView.C3260a<RecyclerView.C3286u> {

    /* renamed from: d */
    private static int f18527d = 100000;

    /* renamed from: e */
    private static int f18528e = 200000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SparseArrayCompat<MzRecyclerView.C3217a> f18529a = new SparseArrayCompat<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SparseArrayCompat<MzRecyclerView.C3217a> f18530b = new SparseArrayCompat<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView.C3260a f18531c;

    /* renamed from: f */
    private final RecyclerView.C3262c f18532f = new RecyclerView.C3262c() {
        /* renamed from: a */
        public void mo23939a() {
            if (HeaderAndFooterWrapperAdapter.this.f18531c != null) {
                HeaderAndFooterWrapperAdapter.this.f18531c.mo26541f();
            }
        }

        /* renamed from: a */
        public void mo23940a(int i, int i2) {
            if (HeaderAndFooterWrapperAdapter.this.f18531c != null) {
                HeaderAndFooterWrapperAdapter.this.f18531c.mo26537a(i, i2);
            }
        }

        /* renamed from: a */
        public void mo23941a(int i, int i2, Object obj) {
            if (HeaderAndFooterWrapperAdapter.this.f18531c != null) {
                HeaderAndFooterWrapperAdapter.this.f18531c.mo26538a(i, i2, obj);
            }
        }
    };

    public HeaderAndFooterWrapperAdapter(RecyclerView.C3260a aVar) {
        this.f18531c = aVar;
    }

    /* renamed from: b */
    public RecyclerView.C3286u mo20098b(ViewGroup viewGroup, int i) {
        if (this.f18529a.get(i) != null) {
            return this.f18529a.get(i).f17769a;
        }
        if (this.f18530b.get(i) != null) {
            return this.f18530b.get(i).f17769a;
        }
        if (this.f18531c != null) {
            return this.f18531c.mo20098b(viewGroup, i);
        }
        return null;
    }

    /* renamed from: a_ */
    public int mo22520a_(int i) {
        if (m20657a(i)) {
            return this.f18529a.keyAt(i);
        }
        if (m20659b(i)) {
            return this.f18530b.keyAt((i - mo27190b()) - m20661g());
        }
        if (this.f18531c != null) {
            return this.f18531c.mo22520a_(i - mo27190b());
        }
        return -2;
    }

    /* renamed from: g */
    private int m20661g() {
        if (this.f18531c != null) {
            return this.f18531c.mo20093a();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo20097a(RecyclerView.C3286u uVar, int i) {
        if (!m20657a(i) && !m20659b(i) && this.f18531c != null) {
            this.f18531c.mo20097a(uVar, i - mo27190b());
        }
    }

    /* renamed from: a */
    public void mo23922a(RecyclerView.C3286u uVar, int i, List<Object> list) {
        if (!m20657a(i) && !m20659b(i) && this.f18531c != null) {
            this.f18531c.mo23922a(uVar, i - mo27190b(), list);
        }
    }

    /* renamed from: a */
    public int mo20093a() {
        return mo27190b() + mo27193c() + m20661g();
    }

    /* renamed from: a */
    public void mo23923a(RecyclerView recyclerView) {
        if (this.f18531c != null) {
            this.f18531c.mo23923a(recyclerView);
        }
        mo27192b(recyclerView);
    }

    /* renamed from: b */
    public void mo27192b(RecyclerView recyclerView) {
        RecyclerView.C3266g layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager kVar = (GridLayoutManager) layoutManager;
            final GridLayoutManager.C3336c c = kVar.mo27180c();
            kVar.mo27179a((GridLayoutManager.C3336c) new GridLayoutManager.C3336c() {
                /* renamed from: a */
                public int mo23938a(int i) {
                    int a_ = HeaderAndFooterWrapperAdapter.this.mo22520a_(i);
                    if (HeaderAndFooterWrapperAdapter.this.f18529a.get(a_) != null) {
                        return kVar.mo27181d();
                    }
                    if (HeaderAndFooterWrapperAdapter.this.f18530b.get(a_) != null) {
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
        if (this.f18531c != null) {
            this.f18531c.mo23932c(recyclerView);
        }
    }

    /* renamed from: b */
    public void mo23927b(RecyclerView.C3286u uVar) {
        ViewGroup.LayoutParams layoutParams;
        if (this.f18531c != null) {
            this.f18531c.mo23927b(uVar);
        }
        int f = uVar.mo26772f();
        if ((m20657a(f) || m20659b(f)) && (layoutParams = uVar.f18121j.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.C3308b)) {
            ((StaggeredGridLayoutManager.C3308b) layoutParams).mo26899a(true);
        }
    }

    /* renamed from: c */
    public void mo23931c(RecyclerView.C3286u uVar) {
        if (this.f18531c != null) {
            this.f18531c.mo23931c(uVar);
        }
    }

    /* renamed from: a */
    private boolean m20657a(int i) {
        return i < mo27190b();
    }

    /* renamed from: b */
    private boolean m20659b(int i) {
        if (i >= mo20093a()) {
            Log.e("HeaderFooterAdapter", "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is " + i + ", but total itemcount is " + mo20093a() + ", headers:" + mo27190b() + ", items:" + m20661g() + ", footers:" + mo27193c());
            return false;
        } else if (i >= mo27190b() + m20661g()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public void mo27189a(MzRecyclerView.C3217a aVar) {
        SparseArrayCompat<MzRecyclerView.C3217a> sparseArrayCompat = this.f18529a;
        int i = f18527d;
        f18527d = i + 1;
        sparseArrayCompat.put(i, aVar);
    }

    /* renamed from: b */
    public void mo27191b(MzRecyclerView.C3217a aVar) {
        SparseArrayCompat<MzRecyclerView.C3217a> sparseArrayCompat = this.f18530b;
        int i = f18528e;
        f18528e = i + 1;
        sparseArrayCompat.put(i, aVar);
    }

    /* renamed from: b */
    public int mo27190b() {
        return this.f18529a.size();
    }

    /* renamed from: c */
    public int mo27193c() {
        return this.f18530b.size();
    }

    /* renamed from: a */
    public void mo23921a(RecyclerView.C3262c cVar) {
        this.f18531c.mo23921a(cVar);
        super.mo23921a(this.f18532f);
    }

    /* renamed from: b */
    public void mo23926b(RecyclerView.C3262c cVar) {
        this.f18531c.mo23926b(cVar);
        super.mo23926b(this.f18532f);
    }

    /* renamed from: f */
    public boolean mo23936f(int i) {
        int i2;
        MzRecyclerView.C3217a valueAt;
        int b = mo27190b();
        if (i < 0 || i >= b) {
            int i3 = i - b;
            if (this.f18531c == null || i < b) {
                i2 = 0;
            } else {
                i2 = m20661g();
                if (i3 < i2) {
                    return this.f18531c.mo23936f(i3);
                }
            }
            int i4 = i3 - i2;
            if (i4 < 0 || i4 >= mo27193c() || (valueAt = this.f18530b.valueAt(i4)) == null) {
                return false;
            }
            return valueAt.f17770b;
        }
        MzRecyclerView.C3217a valueAt2 = this.f18529a.valueAt(i);
        if (valueAt2 != null) {
            return valueAt2.f17770b;
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo23937g(int i) {
        int b = mo27190b();
        if (i < b) {
            return false;
        }
        int i2 = i - b;
        if (this.f18531c == null || i < b || i2 >= m20661g()) {
            return false;
        }
        return this.f18531c.mo23937g(i2);
    }

    /* renamed from: c */
    public long mo20100c(int i) {
        int i2;
        int b = mo27190b();
        if (this.f18531c == null || i < b || (i2 = i - b) >= m20661g()) {
            return -1;
        }
        return this.f18531c.mo20100c(i2);
    }

    /* renamed from: a */
    public void mo20096a(RecyclerView.C3286u uVar) {
        if (this.f18531c != null) {
            this.f18531c.mo20096a(uVar);
        }
    }

    /* renamed from: d */
    public boolean mo23934d(RecyclerView.C3286u uVar) {
        if (this.f18531c != null) {
            return this.f18531c.mo23934d(uVar);
        }
        return super.mo23934d(uVar);
    }

    /* renamed from: e */
    public RecyclerView.C3260a mo27194e() {
        return this.f18531c;
    }

    /* renamed from: d */
    public boolean mo23933d() {
        if (this.f18531c != null) {
            return this.f18531c.mo23933d();
        }
        return super.mo23933d();
    }
}
