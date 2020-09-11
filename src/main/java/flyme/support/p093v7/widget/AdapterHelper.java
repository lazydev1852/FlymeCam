package flyme.support.p093v7.widget;

import androidx.core.util.Pools;
import com.meizu.savior.Constants;
import flyme.support.p093v7.widget.OpReorderer;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: flyme.support.v7.widget.c */
public class AdapterHelper implements OpReorderer.C3339a {

    /* renamed from: a */
    final ArrayList<C3324b> f18440a;

    /* renamed from: b */
    final ArrayList<C3324b> f18441b;

    /* renamed from: c */
    final C3323a f18442c;

    /* renamed from: d */
    Runnable f18443d;

    /* renamed from: e */
    final boolean f18444e;

    /* renamed from: f */
    final OpReorderer f18445f;

    /* renamed from: g */
    private Pools.Pool<C3324b> f18446g;

    /* renamed from: h */
    private int f18447h;

    /* renamed from: flyme.support.v7.widget.c$a */
    /* compiled from: AdapterHelper */
    interface C3323a {
        /* renamed from: a */
        RecyclerView.C3286u mo26505a(int i);

        /* renamed from: a */
        void mo26506a(int i, int i2);

        /* renamed from: a */
        void mo26507a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo26508a(C3324b bVar);

        /* renamed from: b */
        void mo26509b(int i, int i2);

        /* renamed from: b */
        void mo26510b(C3324b bVar);

        /* renamed from: c */
        void mo26511c(int i, int i2);

        /* renamed from: d */
        void mo26513d(int i, int i2);
    }

    AdapterHelper(C3323a aVar) {
        this(aVar, false);
    }

    AdapterHelper(C3323a aVar, boolean z) {
        this.f18446g = new Pools.SimplePool(30);
        this.f18440a = new ArrayList<>();
        this.f18441b = new ArrayList<>();
        this.f18447h = 0;
        this.f18442c = aVar;
        this.f18444e = z;
        this.f18445f = new OpReorderer(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27064a() {
        mo27067a((List<C3324b>) this.f18440a);
        mo27067a((List<C3324b>) this.f18441b);
        this.f18447h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo27071b() {
        this.f18445f.mo27205a(this.f18440a);
        int size = this.f18440a.size();
        for (int i = 0; i < size; i++) {
            C3324b bVar = this.f18440a.get(i);
            int i2 = bVar.f18448a;
            if (i2 == 4) {
                m20430d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        m20433f(bVar);
                        break;
                    case 2:
                        m20429c(bVar);
                        break;
                }
            } else {
                m20428b(bVar);
            }
            if (this.f18443d != null) {
                this.f18443d.run();
            }
        }
        this.f18440a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo27073c() {
        int size = this.f18441b.size();
        for (int i = 0; i < size; i++) {
            this.f18442c.mo26510b(this.f18441b.get(i));
        }
        mo27067a((List<C3324b>) this.f18441b);
        this.f18447h = 0;
    }

    /* renamed from: b */
    private void m20428b(C3324b bVar) {
        m20434g(bVar);
    }

    /* renamed from: c */
    private void m20429c(C3324b bVar) {
        char c;
        boolean z;
        boolean z2;
        int i = bVar.f18449b;
        int i2 = bVar.f18449b + bVar.f18451d;
        int i3 = bVar.f18449b;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.f18442c.mo26505a(i3) != null || m20431d(i3)) {
                if (c2 == 0) {
                    m20432e(mo27063a(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m20434g(mo27063a(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.f18451d) {
            mo27065a(bVar);
            bVar = mo27063a(2, i, i4, (Object) null);
        }
        if (c2 == 0) {
            m20432e(bVar);
        } else {
            m20434g(bVar);
        }
    }

    /* renamed from: d */
    private void m20430d(C3324b bVar) {
        int i = bVar.f18449b;
        int i2 = bVar.f18449b + bVar.f18451d;
        char c = 65535;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.f18449b; i5 < i2; i5++) {
            if (this.f18442c.mo26505a(i5) != null || m20431d(i5)) {
                if (c == 0) {
                    m20432e(mo27063a(4, i3, i4, bVar.f18450c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m20434g(mo27063a(4, i3, i4, bVar.f18450c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.f18451d) {
            Object obj = bVar.f18450c;
            mo27065a(bVar);
            bVar = mo27063a(4, i3, i4, obj);
        }
        if (c == 0) {
            m20432e(bVar);
        } else {
            m20434g(bVar);
        }
    }

    /* renamed from: e */
    private void m20432e(C3324b bVar) {
        int i;
        if (bVar.f18448a == 1 || bVar.f18448a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b = m20427b(bVar.f18449b, bVar.f18448a);
        int i2 = bVar.f18449b;
        int i3 = bVar.f18448a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i4 = b;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f18451d; i7++) {
            int b2 = m20427b(bVar.f18449b + (i * i7), bVar.f18448a);
            int i8 = bVar.f18448a;
            if (i8 == 2 ? b2 == i4 : i8 == 4 && b2 == i4 + 1) {
                i6++;
            } else {
                C3324b a = mo27063a(bVar.f18448a, i4, i6, bVar.f18450c);
                mo27066a(a, i5);
                mo27065a(a);
                if (bVar.f18448a == 4) {
                    i5 += i6;
                }
                i4 = b2;
                i6 = 1;
            }
        }
        Object obj = bVar.f18450c;
        mo27065a(bVar);
        if (i6 > 0) {
            C3324b a2 = mo27063a(bVar.f18448a, i4, i6, obj);
            mo27066a(a2, i5);
            mo27065a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27066a(C3324b bVar, int i) {
        this.f18442c.mo26508a(bVar);
        int i2 = bVar.f18448a;
        if (i2 == 2) {
            this.f18442c.mo26506a(i, bVar.f18451d);
        } else if (i2 == 4) {
            this.f18442c.mo26507a(i, bVar.f18451d, bVar.f18450c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: b */
    private int m20427b(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f18441b.size() - 1; size >= 0; size--) {
            C3324b bVar = this.f18441b.get(size);
            if (bVar.f18448a == 8) {
                if (bVar.f18449b < bVar.f18451d) {
                    i4 = bVar.f18449b;
                    i3 = bVar.f18451d;
                } else {
                    i4 = bVar.f18451d;
                    i3 = bVar.f18449b;
                }
                if (i < i4 || i > i3) {
                    if (i < bVar.f18449b) {
                        if (i2 == 1) {
                            bVar.f18449b++;
                            bVar.f18451d++;
                        } else if (i2 == 2) {
                            bVar.f18449b--;
                            bVar.f18451d--;
                        }
                    }
                } else if (i4 == bVar.f18449b) {
                    if (i2 == 1) {
                        bVar.f18451d++;
                    } else if (i2 == 2) {
                        bVar.f18451d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.f18449b++;
                    } else if (i2 == 2) {
                        bVar.f18449b--;
                    }
                    i--;
                }
            } else if (bVar.f18449b <= i) {
                if (bVar.f18448a == 1) {
                    i -= bVar.f18451d;
                } else if (bVar.f18448a == 2) {
                    i += bVar.f18451d;
                }
            } else if (i2 == 1) {
                bVar.f18449b++;
            } else if (i2 == 2) {
                bVar.f18449b--;
            }
        }
        for (int size2 = this.f18441b.size() - 1; size2 >= 0; size2--) {
            C3324b bVar2 = this.f18441b.get(size2);
            if (bVar2.f18448a == 8) {
                if (bVar2.f18451d == bVar2.f18449b || bVar2.f18451d < 0) {
                    this.f18441b.remove(size2);
                    mo27065a(bVar2);
                }
            } else if (bVar2.f18451d <= 0) {
                this.f18441b.remove(size2);
                mo27065a(bVar2);
            }
        }
        return i;
    }

    /* renamed from: d */
    private boolean m20431d(int i) {
        int size = this.f18441b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3324b bVar = this.f18441b.get(i2);
            if (bVar.f18448a == 8) {
                if (mo27062a(bVar.f18451d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f18448a == 1) {
                int i3 = bVar.f18449b + bVar.f18451d;
                for (int i4 = bVar.f18449b; i4 < i3; i4++) {
                    if (mo27062a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m20433f(C3324b bVar) {
        m20434g(bVar);
    }

    /* renamed from: g */
    private void m20434g(C3324b bVar) {
        this.f18441b.add(bVar);
        int i = bVar.f18448a;
        if (i == 4) {
            this.f18442c.mo26507a(bVar.f18449b, bVar.f18451d, bVar.f18450c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.f18442c.mo26511c(bVar.f18449b, bVar.f18451d);
                    return;
                case 2:
                    this.f18442c.mo26509b(bVar.f18449b, bVar.f18451d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        } else {
            this.f18442c.mo26513d(bVar.f18449b, bVar.f18451d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo27074d() {
        return this.f18440a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27068a(int i) {
        return (i & this.f18447h) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo27070b(int i) {
        return mo27062a(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo27062a(int i, int i2) {
        int size = this.f18441b.size();
        while (i2 < size) {
            C3324b bVar = this.f18441b.get(i2);
            if (bVar.f18448a == 8) {
                if (bVar.f18449b == i) {
                    i = bVar.f18451d;
                } else {
                    if (bVar.f18449b < i) {
                        i--;
                    }
                    if (bVar.f18451d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f18449b > i) {
                continue;
            } else if (bVar.f18448a == 2) {
                if (i < bVar.f18449b + bVar.f18451d) {
                    return -1;
                }
                i -= bVar.f18451d;
            } else if (bVar.f18448a == 1) {
                i += bVar.f18451d;
            }
            i2++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27069a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f18440a.add(mo27063a(4, i, i2, obj));
        this.f18447h |= 4;
        if (this.f18440a.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo27075e() {
        mo27073c();
        int size = this.f18440a.size();
        for (int i = 0; i < size; i++) {
            C3324b bVar = this.f18440a.get(i);
            int i2 = bVar.f18448a;
            if (i2 == 4) {
                this.f18442c.mo26510b(bVar);
                this.f18442c.mo26507a(bVar.f18449b, bVar.f18451d, bVar.f18450c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f18442c.mo26510b(bVar);
                        this.f18442c.mo26511c(bVar.f18449b, bVar.f18451d);
                        break;
                    case 2:
                        this.f18442c.mo26510b(bVar);
                        this.f18442c.mo26506a(bVar.f18449b, bVar.f18451d);
                        break;
                }
            } else {
                this.f18442c.mo26510b(bVar);
                this.f18442c.mo26513d(bVar.f18449b, bVar.f18451d);
            }
            if (this.f18443d != null) {
                this.f18443d.run();
            }
        }
        mo27067a((List<C3324b>) this.f18440a);
        this.f18447h = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0047, code lost:
        continue;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo27072c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<flyme.support.v7.widget.c$b> r0 = r5.f18440a
            int r0 = r0.size()
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x004a
            java.util.ArrayList<flyme.support.v7.widget.c$b> r2 = r5.f18440a
            java.lang.Object r2 = r2.get(r1)
            flyme.support.v7.widget.c$b r2 = (flyme.support.p093v7.widget.AdapterHelper.C3324b) r2
            int r3 = r2.f18448a
            r4 = 8
            if (r3 == r4) goto L_0x0034
            switch(r3) {
                case 1: goto L_0x002c;
                case 2: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0047
        L_0x001b:
            int r3 = r2.f18449b
            if (r3 > r6) goto L_0x0047
            int r3 = r2.f18449b
            int r4 = r2.f18451d
            int r3 = r3 + r4
            if (r3 <= r6) goto L_0x0028
            r6 = -1
            return r6
        L_0x0028:
            int r2 = r2.f18451d
            int r6 = r6 - r2
            goto L_0x0047
        L_0x002c:
            int r3 = r2.f18449b
            if (r3 > r6) goto L_0x0047
            int r2 = r2.f18451d
            int r6 = r6 + r2
            goto L_0x0047
        L_0x0034:
            int r3 = r2.f18449b
            if (r3 != r6) goto L_0x003b
            int r6 = r2.f18451d
            goto L_0x0047
        L_0x003b:
            int r3 = r2.f18449b
            if (r3 >= r6) goto L_0x0041
            int r6 = r6 + -1
        L_0x0041:
            int r2 = r2.f18451d
            if (r2 > r6) goto L_0x0047
            int r6 = r6 + 1
        L_0x0047:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.AdapterHelper.mo27072c(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo27076f() {
        return !this.f18441b.isEmpty() && !this.f18440a.isEmpty();
    }

    /* renamed from: flyme.support.v7.widget.c$b */
    /* compiled from: AdapterHelper */
    static class C3324b {

        /* renamed from: a */
        int f18448a;

        /* renamed from: b */
        int f18449b;

        /* renamed from: c */
        Object f18450c;

        /* renamed from: d */
        int f18451d;

        C3324b(int i, int i2, int i3, Object obj) {
            this.f18448a = i;
            this.f18449b = i2;
            this.f18451d = i3;
            this.f18450c = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo27077a() {
            int i = this.f18448a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + Constants.ARRAY_TYPE + mo27077a() + ",s:" + this.f18449b + "c:" + this.f18451d + ",p:" + this.f18450c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C3324b bVar = (C3324b) obj;
            if (this.f18448a != bVar.f18448a) {
                return false;
            }
            if (this.f18448a == 8 && Math.abs(this.f18451d - this.f18449b) == 1 && this.f18451d == bVar.f18449b && this.f18449b == bVar.f18451d) {
                return true;
            }
            if (this.f18451d != bVar.f18451d || this.f18449b != bVar.f18449b) {
                return false;
            }
            if (this.f18450c != null) {
                return this.f18450c.equals(bVar.f18450c);
            }
            if (bVar.f18450c == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f18448a * 31) + this.f18449b) * 31) + this.f18451d;
        }
    }

    /* renamed from: a */
    public C3324b mo27063a(int i, int i2, int i3, Object obj) {
        C3324b acquire = this.f18446g.acquire();
        if (acquire == null) {
            return new C3324b(i, i2, i3, obj);
        }
        acquire.f18448a = i;
        acquire.f18449b = i2;
        acquire.f18451d = i3;
        acquire.f18450c = obj;
        return acquire;
    }

    /* renamed from: a */
    public void mo27065a(C3324b bVar) {
        if (!this.f18444e) {
            bVar.f18450c = null;
            this.f18446g.release(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27067a(List<C3324b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo27065a(list.get(i));
        }
        list.clear();
    }
}
