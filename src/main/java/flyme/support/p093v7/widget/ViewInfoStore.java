package flyme.support.p093v7.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.util.Pools;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.w */
public class ViewInfoStore {
    @VisibleForTesting

    /* renamed from: a */
    final ArrayMap<RecyclerView.C3286u, C3350a> f18625a = new ArrayMap<>();
    @VisibleForTesting

    /* renamed from: b */
    final LongSparseArray<RecyclerView.C3286u> f18626b = new LongSparseArray<>();

    /* renamed from: flyme.support.v7.widget.w$b */
    /* compiled from: ViewInfoStore */
    interface C3351b {
        /* renamed from: a */
        void mo26490a(RecyclerView.C3286u uVar);

        /* renamed from: a */
        void mo26491a(RecyclerView.C3286u uVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar, @Nullable RecyclerView.ItemAnimator.C3258c cVar2);

        /* renamed from: b */
        void mo26492b(RecyclerView.C3286u uVar, @Nullable RecyclerView.ItemAnimator.C3258c cVar, RecyclerView.ItemAnimator.C3258c cVar2);

        /* renamed from: c */
        void mo26493c(RecyclerView.C3286u uVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar2);
    }

    ViewInfoStore() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27271a() {
        this.f18625a.clear();
        this.f18626b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27273a(RecyclerView.C3286u uVar, RecyclerView.ItemAnimator.C3258c cVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar == null) {
            aVar = C3350a.m20903a();
            this.f18625a.put(uVar, aVar);
        }
        aVar.f18629b = cVar;
        aVar.f18628a |= 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27275a(RecyclerView.C3286u uVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar == null || (aVar.f18628a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public RecyclerView.ItemAnimator.C3258c mo27276b(RecyclerView.C3286u uVar) {
        return m20886a(uVar, 4);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public RecyclerView.ItemAnimator.C3258c mo27279c(RecyclerView.C3286u uVar) {
        return m20886a(uVar, 8);
    }

    /* renamed from: a */
    private RecyclerView.ItemAnimator.C3258c m20886a(RecyclerView.C3286u uVar, int i) {
        C3350a valueAt;
        RecyclerView.ItemAnimator.C3258c cVar;
        int indexOfKey = this.f18625a.indexOfKey(uVar);
        if (indexOfKey < 0 || (valueAt = this.f18625a.valueAt(indexOfKey)) == null || (valueAt.f18628a & i) == 0) {
            return null;
        }
        valueAt.f18628a &= ~i;
        if (i == 4) {
            cVar = valueAt.f18629b;
        } else if (i == 8) {
            cVar = valueAt.f18630c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((valueAt.f18628a & 12) == 0) {
            this.f18625a.removeAt(indexOfKey);
            C3350a.m20904a(valueAt);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27272a(long j, RecyclerView.C3286u uVar) {
        this.f18626b.put(j, uVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo27278b(RecyclerView.C3286u uVar, RecyclerView.ItemAnimator.C3258c cVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar == null) {
            aVar = C3350a.m20903a();
            this.f18625a.put(uVar, aVar);
        }
        aVar.f18628a |= 2;
        aVar.f18629b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo27281d(RecyclerView.C3286u uVar) {
        C3350a aVar = this.f18625a.get(uVar);
        return (aVar == null || (aVar.f18628a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RecyclerView.C3286u mo27270a(long j) {
        return this.f18626b.get(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo27280c(RecyclerView.C3286u uVar, RecyclerView.ItemAnimator.C3258c cVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar == null) {
            aVar = C3350a.m20903a();
            this.f18625a.put(uVar, aVar);
        }
        aVar.f18630c = cVar;
        aVar.f18628a |= 8;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo27282e(RecyclerView.C3286u uVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar == null) {
            aVar = C3350a.m20903a();
            this.f18625a.put(uVar, aVar);
        }
        aVar.f18628a |= 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo27283f(RecyclerView.C3286u uVar) {
        C3350a aVar = this.f18625a.get(uVar);
        if (aVar != null) {
            aVar.f18628a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27274a(C3351b bVar) {
        for (int size = this.f18625a.size() - 1; size >= 0; size--) {
            RecyclerView.C3286u keyAt = this.f18625a.keyAt(size);
            C3350a removeAt = this.f18625a.removeAt(size);
            if ((removeAt.f18628a & 3) == 3) {
                bVar.mo26490a(keyAt);
            } else if ((removeAt.f18628a & 1) != 0) {
                if (removeAt.f18629b == null) {
                    bVar.mo26490a(keyAt);
                } else {
                    bVar.mo26491a(keyAt, removeAt.f18629b, removeAt.f18630c);
                }
            } else if ((removeAt.f18628a & 14) == 14) {
                bVar.mo26492b(keyAt, removeAt.f18629b, removeAt.f18630c);
            } else if ((removeAt.f18628a & 12) == 12) {
                bVar.mo26493c(keyAt, removeAt.f18629b, removeAt.f18630c);
            } else if ((removeAt.f18628a & 4) != 0) {
                bVar.mo26491a(keyAt, removeAt.f18629b, (RecyclerView.ItemAnimator.C3258c) null);
            } else if ((removeAt.f18628a & 8) != 0) {
                bVar.mo26492b(keyAt, removeAt.f18629b, removeAt.f18630c);
            } else {
                int i = removeAt.f18628a;
            }
            C3350a.m20904a(removeAt);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo27284g(RecyclerView.C3286u uVar) {
        int size = this.f18626b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (uVar == this.f18626b.valueAt(size)) {
                this.f18626b.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        C3350a remove = this.f18625a.remove(uVar);
        if (remove != null) {
            C3350a.m20904a(remove);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo27277b() {
        C3350a.m20905b();
    }

    /* renamed from: h */
    public void mo27285h(RecyclerView.C3286u uVar) {
        mo27283f(uVar);
    }

    /* renamed from: flyme.support.v7.widget.w$a */
    /* compiled from: ViewInfoStore */
    static class C3350a {

        /* renamed from: d */
        static Pools.Pool<C3350a> f18627d = new Pools.SimplePool(20);

        /* renamed from: a */
        int f18628a;
        @Nullable

        /* renamed from: b */
        RecyclerView.ItemAnimator.C3258c f18629b;
        @Nullable

        /* renamed from: c */
        RecyclerView.ItemAnimator.C3258c f18630c;

        private C3350a() {
        }

        /* renamed from: a */
        static C3350a m20903a() {
            C3350a acquire = f18627d.acquire();
            return acquire == null ? new C3350a() : acquire;
        }

        /* renamed from: a */
        static void m20904a(C3350a aVar) {
            aVar.f18628a = 0;
            aVar.f18629b = null;
            aVar.f18630c = null;
            f18627d.release(aVar);
        }

        /* renamed from: b */
        static void m20905b() {
            do {
            } while (f18627d.acquire() != null);
        }
    }
}
