package flyme.support.p093v7.widget;

import androidx.annotation.Nullable;
import androidx.core.p005os.TraceCompat;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: flyme.support.v7.widget.j */
public final class GapWorker implements Runnable {

    /* renamed from: a */
    static final ThreadLocal<GapWorker> f18500a = new ThreadLocal<>();

    /* renamed from: e */
    static Comparator<C3333b> f18501e = new Comparator<C3333b>() {
        /* renamed from: a */
        public int compare(C3333b bVar, C3333b bVar2) {
            if ((bVar.f18513d == null) != (bVar2.f18513d == null)) {
                if (bVar.f18513d == null) {
                    return 1;
                }
                return -1;
            } else if (bVar.f18510a == bVar2.f18510a) {
                int i = bVar2.f18511b - bVar.f18511b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.f18512c - bVar2.f18512c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (bVar.f18510a) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    /* renamed from: b */
    ArrayList<RecyclerView> f18502b = new ArrayList<>();

    /* renamed from: c */
    long f18503c;

    /* renamed from: d */
    long f18504d;

    /* renamed from: f */
    private ArrayList<C3333b> f18505f = new ArrayList<>();

    GapWorker() {
    }

    /* renamed from: flyme.support.v7.widget.j$b */
    /* compiled from: GapWorker */
    static class C3333b {

        /* renamed from: a */
        public boolean f18510a;

        /* renamed from: b */
        public int f18511b;

        /* renamed from: c */
        public int f18512c;

        /* renamed from: d */
        public RecyclerView f18513d;

        /* renamed from: e */
        public int f18514e;

        C3333b() {
        }

        /* renamed from: a */
        public void mo27177a() {
            this.f18510a = false;
            this.f18511b = 0;
            this.f18512c = 0;
            this.f18513d = null;
            this.f18514e = 0;
        }
    }

    /* renamed from: flyme.support.v7.widget.j$a */
    /* compiled from: GapWorker */
    static class C3332a implements RecyclerView.C3266g.C3269a {

        /* renamed from: a */
        int f18506a;

        /* renamed from: b */
        int f18507b;

        /* renamed from: c */
        int[] f18508c;

        /* renamed from: d */
        int f18509d;

        C3332a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27174a(int i, int i2) {
            this.f18506a = i;
            this.f18507b = i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27175a(RecyclerView recyclerView, boolean z) {
            this.f18509d = 0;
            if (this.f18508c != null) {
                Arrays.fill(this.f18508c, -1);
            }
            RecyclerView.C3266g gVar = recyclerView.f17955K;
            if (recyclerView.f17954J != null && gVar != null && gVar.mo26652r()) {
                if (z) {
                    if (!recyclerView.f17947C.mo27074d()) {
                        gVar.mo26063a(recyclerView.f17954J.mo20093a(), (RecyclerView.C3266g.C3269a) this);
                    }
                } else if (!recyclerView.mo26357G()) {
                    gVar.mo26062a(this.f18506a, this.f18507b, recyclerView.f17978ac, (RecyclerView.C3266g.C3269a) this);
                }
                if (this.f18509d > gVar.f18055y) {
                    gVar.f18055y = this.f18509d;
                    gVar.f18056z = z;
                    recyclerView.f17946B.mo26700b();
                }
            }
        }

        /* renamed from: b */
        public void mo26666b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f18509d * 2;
                if (this.f18508c == null) {
                    this.f18508c = new int[4];
                    Arrays.fill(this.f18508c, -1);
                } else if (i3 >= this.f18508c.length) {
                    int[] iArr = this.f18508c;
                    this.f18508c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.f18508c, 0, iArr.length);
                }
                this.f18508c[i3] = i;
                this.f18508c[i3 + 1] = i2;
                this.f18509d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo27176a(int i) {
            if (this.f18508c != null) {
                int i2 = this.f18509d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f18508c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27173a() {
            if (this.f18508c != null) {
                Arrays.fill(this.f18508c, -1);
            }
            this.f18509d = 0;
        }
    }

    /* renamed from: a */
    public void mo27167a(RecyclerView recyclerView) {
        this.f18502b.add(recyclerView);
    }

    /* renamed from: b */
    public void mo27169b(RecyclerView recyclerView) {
        this.f18502b.remove(recyclerView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27168a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f18503c == 0) {
            this.f18503c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f17977ab.mo27174a(i, i2);
    }

    /* renamed from: a */
    private void m20588a() {
        C3333b bVar;
        int size = this.f18502b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f18502b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f17977ab.mo27175a(recyclerView, false);
                i += recyclerView.f17977ab.f18509d;
            }
        }
        this.f18505f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f18502b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C3332a aVar = recyclerView2.f17977ab;
                int abs = Math.abs(aVar.f18506a) + Math.abs(aVar.f18507b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f18509d * 2; i6 += 2) {
                    if (i5 >= this.f18505f.size()) {
                        bVar = new C3333b();
                        this.f18505f.add(bVar);
                    } else {
                        bVar = this.f18505f.get(i5);
                    }
                    int i7 = aVar.f18508c[i6 + 1];
                    bVar.f18510a = i7 <= abs;
                    bVar.f18511b = abs;
                    bVar.f18512c = i7;
                    bVar.f18513d = recyclerView2;
                    bVar.f18514e = aVar.f18508c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f18505f, f18501e);
    }

    /* renamed from: a */
    static boolean m20591a(RecyclerView recyclerView, int i) {
        int c = recyclerView.f17948D.mo27090c();
        for (int i2 = 0; i2 < c; i2++) {
            RecyclerView.C3286u h = RecyclerView.m19601h(recyclerView.f17948D.mo27093d(i2));
            if (h.f18123l == i && !h.mo26782p()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private RecyclerView.C3286u m20587a(RecyclerView recyclerView, int i, long j) {
        if (m20591a(recyclerView, i)) {
            return null;
        }
        RecyclerView.C3277n nVar = recyclerView.f17946B;
        RecyclerView.C3286u a = nVar.mo26686a(i, false, j);
        if (a != null) {
            if (a.mo26784r()) {
                nVar.mo26692a(a.f18121j);
            } else {
                nVar.mo26696a(a, false);
            }
        }
        return a;
    }

    /* renamed from: a */
    private void m20589a(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.f17965U && recyclerView.f17948D.mo27090c() != 0) {
                recyclerView.mo26440n();
            }
            C3332a aVar = recyclerView.f17977ab;
            aVar.mo27175a(recyclerView, true);
            if (aVar.f18509d != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.f17978ac.mo26743a(recyclerView.f17954J);
                    for (int i = 0; i < aVar.f18509d * 2; i += 2) {
                        m20587a(recyclerView, aVar.f18508c[i], j);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    /* renamed from: a */
    private void m20590a(C3333b bVar, long j) {
        RecyclerView.C3286u a = m20587a(bVar.f18513d, bVar.f18514e, bVar.f18510a ? Long.MAX_VALUE : j);
        if (a != null && a.f18122k != null) {
            m20589a((RecyclerView) a.f18122k.get(), j);
        }
    }

    /* renamed from: b */
    private void m20592b(long j) {
        int i = 0;
        while (i < this.f18505f.size()) {
            C3333b bVar = this.f18505f.get(i);
            if (bVar.f18513d != null) {
                m20590a(bVar, j);
                bVar.mo27177a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27166a(long j) {
        m20588a();
        m20592b(j);
    }

    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.f18502b.isEmpty()) {
                int size = this.f18502b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f18502b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.f18503c = 0;
                    TraceCompat.endSection();
                    return;
                }
                mo27166a(TimeUnit.MILLISECONDS.toNanos(j) + this.f18504d);
                this.f18503c = 0;
                TraceCompat.endSection();
            }
        } finally {
            this.f18503c = 0;
            TraceCompat.endSection();
        }
    }
}
