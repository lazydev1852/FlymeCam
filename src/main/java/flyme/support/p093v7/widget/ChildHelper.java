package flyme.support.p093v7.widget;

import android.view.View;
import android.view.ViewGroup;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: flyme.support.v7.widget.d */
public class ChildHelper {

    /* renamed from: a */
    final C3326b f18452a;

    /* renamed from: b */
    final C3325a f18453b = new C3325a();

    /* renamed from: c */
    final List<View> f18454c = new ArrayList();

    /* renamed from: flyme.support.v7.widget.d$b */
    /* compiled from: ChildHelper */
    interface C3326b {
        /* renamed from: a */
        int mo26494a();

        /* renamed from: a */
        int mo26495a(View view);

        /* renamed from: a */
        void mo26496a(int i);

        /* renamed from: a */
        void mo26497a(View view, int i);

        /* renamed from: a */
        void mo26498a(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* renamed from: b */
        View mo26499b(int i);

        /* renamed from: b */
        RecyclerView.C3286u mo26500b(View view);

        /* renamed from: b */
        void mo26501b();

        /* renamed from: c */
        void mo26502c(int i);

        /* renamed from: c */
        void mo26503c(View view);

        /* renamed from: d */
        void mo26504d(View view);
    }

    ChildHelper(C3326b bVar) {
        this.f18452a = bVar;
    }

    /* renamed from: g */
    private void m20460g(View view) {
        this.f18454c.add(view);
        this.f18452a.mo26503c(view);
    }

    /* renamed from: h */
    private boolean m20461h(View view) {
        if (!this.f18454c.remove(view)) {
            return false;
        }
        this.f18452a.mo26504d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27086a(View view, boolean z) {
        mo27085a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27085a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f18452a.mo26494a();
        } else {
            i2 = m20459f(i);
        }
        this.f18453b.mo27101a(i2, z);
        if (z) {
            m20460g(view);
        }
        this.f18452a.mo26497a(view, i2);
    }

    /* renamed from: f */
    private int m20459f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f18452a.mo26494a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f18453b.mo27105e(i2));
            if (e == 0) {
                while (this.f18453b.mo27103c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27083a(View view) {
        int a = this.f18452a.mo26495a(view);
        if (a >= 0) {
            if (this.f18453b.mo27104d(a)) {
                m20461h(view);
            }
            this.f18452a.mo26496a(a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27082a(int i) {
        int f = m20459f(i);
        View b = this.f18452a.mo26499b(f);
        if (b != null) {
            if (this.f18453b.mo27104d(f)) {
                m20461h(b);
            }
            this.f18452a.mo26496a(f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo27089b(int i) {
        return this.f18452a.mo26499b(m20459f(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27081a() {
        this.f18453b.mo27099a();
        for (int size = this.f18454c.size() - 1; size >= 0; size--) {
            this.f18452a.mo26504d(this.f18454c.get(size));
            this.f18454c.remove(size);
        }
        this.f18452a.mo26501b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo27091c(int i) {
        int size = this.f18454c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f18454c.get(i2);
            RecyclerView.C3286u b = this.f18452a.mo26500b(view);
            if (b.mo26772f() == i && !b.mo26782p() && !b.mo26785s()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27084a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f18452a.mo26494a();
        } else {
            i2 = m20459f(i);
        }
        this.f18453b.mo27101a(i2, z);
        if (z) {
            m20460g(view);
        }
        this.f18452a.mo26498a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo27087b() {
        return this.f18452a.mo26494a() - this.f18454c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo27090c() {
        return this.f18452a.mo26494a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public View mo27093d(int i) {
        return this.f18452a.mo26499b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo27095e(int i) {
        int f = m20459f(i);
        this.f18453b.mo27104d(f);
        this.f18452a.mo26502c(f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo27088b(View view) {
        int a = this.f18452a.mo26495a(view);
        if (a != -1 && !this.f18453b.mo27103c(a)) {
            return a - this.f18453b.mo27105e(a);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo27092c(View view) {
        return this.f18454c.contains(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo27094d(View view) {
        int a = this.f18452a.mo26495a(view);
        if (a >= 0) {
            this.f18453b.mo27100a(a);
            m20460g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo27096e(View view) {
        int a = this.f18452a.mo26495a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f18453b.mo27103c(a)) {
            this.f18453b.mo27102b(a);
            m20461h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f18453b.toString() + ", hidden list:" + this.f18454c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo27097f(View view) {
        int a = this.f18452a.mo26495a(view);
        if (a == -1) {
            m20461h(view);
            return true;
        } else if (!this.f18453b.mo27103c(a)) {
            return false;
        } else {
            this.f18453b.mo27104d(a);
            m20461h(view);
            this.f18452a.mo26496a(a);
            return true;
        }
    }

    /* renamed from: flyme.support.v7.widget.d$a */
    /* compiled from: ChildHelper */
    static class C3325a {

        /* renamed from: a */
        long f18455a = 0;

        /* renamed from: b */
        C3325a f18456b;

        C3325a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27100a(int i) {
            if (i >= 64) {
                m20479b();
                this.f18456b.mo27100a(i - 64);
                return;
            }
            this.f18455a |= 1 << i;
        }

        /* renamed from: b */
        private void m20479b() {
            if (this.f18456b == null) {
                this.f18456b = new C3325a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo27102b(int i) {
            if (i < 64) {
                this.f18455a &= ~(1 << i);
            } else if (this.f18456b != null) {
                this.f18456b.mo27102b(i - 64);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo27103c(int i) {
            if (i < 64) {
                return (this.f18455a & (1 << i)) != 0;
            }
            m20479b();
            return this.f18456b.mo27103c(i - 64);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27099a() {
            this.f18455a = 0;
            if (this.f18456b != null) {
                this.f18456b.mo27099a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27101a(int i, boolean z) {
            if (i >= 64) {
                m20479b();
                this.f18456b.mo27101a(i - 64, z);
                return;
            }
            boolean z2 = (this.f18455a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f18455a = (this.f18455a & j) | (((~j) & this.f18455a) << 1);
            if (z) {
                mo27100a(i);
            } else {
                mo27102b(i);
            }
            if (z2 || this.f18456b != null) {
                m20479b();
                this.f18456b.mo27101a(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo27104d(int i) {
            if (i >= 64) {
                m20479b();
                return this.f18456b.mo27104d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f18455a & j) != 0;
            this.f18455a &= ~j;
            long j2 = j - 1;
            this.f18455a = (this.f18455a & j2) | Long.rotateRight((~j2) & this.f18455a, 1);
            if (this.f18456b != null) {
                if (this.f18456b.mo27103c(0)) {
                    mo27100a(63);
                }
                this.f18456b.mo27104d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo27105e(int i) {
            if (this.f18456b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f18455a);
                }
                return Long.bitCount(this.f18455a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f18455a & ((1 << i) - 1));
            } else {
                return this.f18456b.mo27105e(i - 64) + Long.bitCount(this.f18455a);
            }
        }

        public String toString() {
            if (this.f18456b == null) {
                return Long.toBinaryString(this.f18455a);
            }
            return this.f18456b.toString() + "xx" + Long.toBinaryString(this.f18455a);
        }
    }
}
