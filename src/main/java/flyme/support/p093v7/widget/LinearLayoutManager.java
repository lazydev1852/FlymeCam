package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.fragment.app.FragmentTransaction;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.List;

/* renamed from: flyme.support.v7.widget.LinearLayoutManager */
public class LinearLayoutManager extends RecyclerView.C3266g implements RecyclerView.C3280q.C3282b {

    /* renamed from: a */
    private C3210c f17632a;

    /* renamed from: b */
    private boolean f17633b;

    /* renamed from: c */
    private boolean f17634c;

    /* renamed from: d */
    private boolean f17635d;

    /* renamed from: e */
    private boolean f17636e;

    /* renamed from: f */
    private boolean f17637f;

    /* renamed from: g */
    private final C3209b f17638g;

    /* renamed from: h */
    private int f17639h;

    /* renamed from: j */
    int f17640j;

    /* renamed from: k */
    OrientationHelper f17641k;

    /* renamed from: l */
    boolean f17642l;

    /* renamed from: m */
    int f17643m;

    /* renamed from: n */
    int f17644n;

    /* renamed from: o */
    SavedState f17645o;

    /* renamed from: p */
    final C3208a f17646p;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26066a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, C3208a aVar, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f17634c = false;
        this.f17642l = false;
        this.f17635d = false;
        this.f17636e = true;
        this.f17643m = -1;
        this.f17644n = Integer.MIN_VALUE;
        this.f17645o = null;
        this.f17646p = new C3208a();
        this.f17638g = new C3209b();
        this.f17639h = 2;
        mo26076b(i);
        mo26072a(z);
        mo26616b(true);
    }

    /* renamed from: b */
    public RecyclerView.C3270h mo26075b() {
        return new RecyclerView.C3270h(-2, -2);
    }

    /* renamed from: a */
    public void mo26070a(RecyclerView recyclerView, RecyclerView.C3277n nVar) {
        super.mo26070a(recyclerView, nVar);
        if (this.f17637f) {
            mo26620c(nVar);
            nVar.mo26688a();
        }
    }

    /* renamed from: a */
    public void mo26065a(AccessibilityEvent accessibilityEvent) {
        super.mo26065a(accessibilityEvent);
        if (mo26658x() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(mo26101o());
            asRecord.setToIndex(mo26102p());
        }
    }

    /* renamed from: f */
    public Parcelable mo26090f() {
        if (this.f17645o != null) {
            return new SavedState(this.f17645o);
        }
        SavedState savedState = new SavedState();
        if (mo26658x() > 0) {
            mo26097k();
            boolean z = this.f17633b ^ this.f17642l;
            savedState.f17649c = z;
            if (z) {
                View M = m19257M();
                savedState.f17648b = this.f17641k.mo27215d() - this.f17641k.mo27212b(M);
                savedState.f17647a = mo26623d(M);
            } else {
                View d = mo27181d();
                savedState.f17647a = mo26623d(d);
                savedState.f17648b = this.f17641k.mo27208a(d) - this.f17641k.mo27213c();
            }
        } else {
            savedState.mo26104b();
        }
        return savedState;
    }

    /* renamed from: a */
    public void mo26064a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f17645o = (SavedState) parcelable;
            mo26651q();
        }
    }

    /* renamed from: a */
    public boolean mo22258a() {
        return this.f17640j == 0;
    }

    /* renamed from: g */
    public boolean mo26092g() {
        return this.f17640j == 1;
    }

    /* renamed from: h */
    public int mo26093h() {
        return this.f17640j;
    }

    /* renamed from: b */
    public void mo26076b(int i) {
        if (i == 0 || i == 1) {
            mo26071a((String) null);
            if (i != this.f17640j) {
                this.f17640j = i;
                this.f17641k = null;
                mo26651q();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    /* renamed from: c */
    private void mo27180c() {
        if (this.f17640j == 1 || !mo26096j()) {
            this.f17642l = this.f17634c;
        } else {
            this.f17642l = !this.f17634c;
        }
    }

    /* renamed from: i */
    public boolean mo26095i() {
        return this.f17634c;
    }

    /* renamed from: a */
    public void mo26072a(boolean z) {
        mo26071a((String) null);
        if (z != this.f17634c) {
            this.f17634c = z;
            mo26651q();
        }
    }

    /* renamed from: c */
    public View mo26080c(int i) {
        int x = mo26658x();
        if (x == 0) {
            return null;
        }
        int d = i - mo26623d(mo26641i(0));
        if (d >= 0 && d < x) {
            View i2 = mo26641i(d);
            if (mo26623d(i2) == i) {
                return i2;
            }
        }
        return super.mo26080c(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo26074b(RecyclerView.C3283r rVar) {
        if (rVar.mo26747d()) {
            return this.f17641k.mo27219f();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo20065a(RecyclerView recyclerView, RecyclerView.C3283r rVar, int i) {
        LinearSmoothScroller nVar = new LinearSmoothScroller(recyclerView.getContext());
        nVar.mo26730d(i);
        mo26590a((RecyclerView.C3280q) nVar);
    }

    /* renamed from: d */
    public PointF mo26084d(int i) {
        if (mo26658x() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < mo26623d(mo26641i(0))) {
            z = true;
        }
        if (z != this.f17642l) {
            i2 = -1;
        }
        if (this.f17640j == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    /* renamed from: c */
    public void mo26082c(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        int i;
        int i2;
        int i3;
        View c;
        int i4;
        int i5 = -1;
        if (!(this.f17645o == null && this.f17643m == -1) && rVar.mo26749f() == 0) {
            mo26620c(nVar);
            return;
        }
        if (this.f17645o != null && this.f17645o.mo26103a()) {
            this.f17643m = this.f17645o.f17647a;
        }
        mo26097k();
        this.f17632a.f17659a = false;
        mo27180c();
        if (!(this.f17646p.f17653d && this.f17643m == -1 && this.f17645o == null)) {
            this.f17646p.mo26111a();
            this.f17646p.f17652c = this.f17642l ^ this.f17635d;
            m19266a(nVar, rVar, this.f17646p);
            this.f17646p.f17653d = true;
        }
        int b = mo26074b(rVar);
        if (this.f17632a.f17668j >= 0) {
            i = b;
            b = 0;
        } else {
            i = 0;
        }
        int c2 = b + this.f17641k.mo27213c();
        int g = i + this.f17641k.mo27221g();
        if (!(!rVar.mo26744a() || this.f17643m == -1 || this.f17644n == Integer.MIN_VALUE || (c = mo26080c(this.f17643m)) == null)) {
            if (this.f17642l) {
                i4 = (this.f17641k.mo27215d() - this.f17641k.mo27212b(c)) - this.f17644n;
            } else {
                i4 = this.f17644n - (this.f17641k.mo27208a(c) - this.f17641k.mo27213c());
            }
            if (i4 > 0) {
                c2 += i4;
            } else {
                g -= i4;
            }
        }
        if (!this.f17646p.f17652c ? !this.f17642l : this.f17642l) {
            i5 = 1;
        }
        mo26066a(nVar, rVar, this.f17646p, i5);
        mo26585a(nVar);
        this.f17632a.f17670l = mo26099m();
        this.f17632a.f17667i = rVar.mo26744a();
        if (this.f17646p.f17652c) {
            m19270b(this.f17646p);
            this.f17632a.f17666h = c2;
            mo26058a(nVar, this.f17632a, rVar, false);
            i3 = this.f17632a.f17660b;
            int i6 = this.f17632a.f17662d;
            if (this.f17632a.f17661c > 0) {
                g += this.f17632a.f17661c;
            }
            m19262a(this.f17646p);
            this.f17632a.f17666h = g;
            this.f17632a.f17662d += this.f17632a.f17663e;
            mo26058a(nVar, this.f17632a, rVar, false);
            i2 = this.f17632a.f17660b;
            if (this.f17632a.f17661c > 0) {
                int i7 = this.f17632a.f17661c;
                m19279h(i6, i3);
                this.f17632a.f17666h = i7;
                mo26058a(nVar, this.f17632a, rVar, false);
                i3 = this.f17632a.f17660b;
            }
        } else {
            m19262a(this.f17646p);
            this.f17632a.f17666h = g;
            mo26058a(nVar, this.f17632a, rVar, false);
            i2 = this.f17632a.f17660b;
            int i8 = this.f17632a.f17662d;
            if (this.f17632a.f17661c > 0) {
                c2 += this.f17632a.f17661c;
            }
            m19270b(this.f17646p);
            this.f17632a.f17666h = c2;
            this.f17632a.f17662d += this.f17632a.f17663e;
            mo26058a(nVar, this.f17632a, rVar, false);
            i3 = this.f17632a.f17660b;
            if (this.f17632a.f17661c > 0) {
                int i9 = this.f17632a.f17661c;
                mo20064a(i8, i2);
                this.f17632a.f17666h = i9;
                mo26058a(nVar, this.f17632a, rVar, false);
                i2 = this.f17632a.f17660b;
            }
        }
        if (mo26658x() > 0) {
            if (this.f17642l ^ this.f17635d) {
                int a = m19258a(i2, nVar, rVar, true);
                int i10 = i3 + a;
                int i11 = i2 + a;
                int b2 = m19268b(i10, nVar, rVar, false);
                i3 = i10 + b2;
                i2 = i11 + b2;
            } else {
                int b3 = m19268b(i3, nVar, rVar, true);
                int i12 = i3 + b3;
                int i13 = i2 + b3;
                int a2 = m19258a(i13, nVar, rVar, false);
                i3 = i12 + a2;
                i2 = i13 + a2;
            }
        }
        m19272b(nVar, rVar, i3, i2);
        if (!rVar.mo26744a()) {
            this.f17641k.mo27209a();
        } else {
            this.f17646p.mo26111a();
        }
        this.f17633b = this.f17635d;
    }

    /* renamed from: a */
    public void mo26068a(RecyclerView.C3283r rVar) {
        super.mo26068a(rVar);
        this.f17645o = null;
        this.f17643m = -1;
        this.f17644n = Integer.MIN_VALUE;
        this.f17646p.mo26111a();
    }

    /* renamed from: b */
    private void m19272b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i, int i2) {
        RecyclerView.C3277n nVar2 = nVar;
        RecyclerView.C3283r rVar2 = rVar;
        if (rVar.mo26745b() && mo26658x() != 0 && !rVar.mo26744a() && mo26087e()) {
            List<RecyclerView.C3286u> c = nVar.mo26705c();
            int size = c.size();
            int d = mo26623d(mo26641i(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.C3286u uVar = c.get(i5);
                if (!uVar.mo26785s()) {
                    char c2 = 1;
                    if ((uVar.mo26772f() < d) != this.f17642l) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i3 += this.f17641k.mo27218e(uVar.f18121j);
                    } else {
                        i4 += this.f17641k.mo27218e(uVar.f18121j);
                    }
                }
            }
            this.f17632a.f17669k = c;
            if (i3 > 0) {
                m19279h(mo26623d(mo27181d()), i);
                this.f17632a.f17666h = i3;
                this.f17632a.f17661c = 0;
                this.f17632a.mo26119a();
                mo26058a(nVar2, this.f17632a, rVar2, false);
            }
            if (i4 > 0) {
                mo20064a(mo26623d(m19257M()), i2);
                this.f17632a.f17666h = i4;
                this.f17632a.f17661c = 0;
                this.f17632a.mo26119a();
                mo26058a(nVar2, this.f17632a, rVar2, false);
            }
            this.f17632a.f17669k = null;
        }
    }

    /* renamed from: a */
    private void m19266a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, C3208a aVar) {
        if (!m19267a(rVar, aVar) && !m19273b(nVar, rVar, aVar)) {
            aVar.mo26114b();
            aVar.f17650a = this.f17635d ? rVar.mo26749f() - 1 : 0;
        }
    }

    /* renamed from: b */
    private boolean m19273b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, C3208a aVar) {
        View view;
        int i;
        boolean z = false;
        if (mo26658x() == 0) {
            return false;
        }
        View G = mo26563G();
        if (G != null && aVar.mo26113a(G, rVar)) {
            aVar.mo26112a(G);
            return true;
        } else if (this.f17633b != this.f17635d) {
            return false;
        } else {
            if (aVar.f17652c) {
                view = m19276f(nVar, rVar);
            } else {
                view = m19277g(nVar, rVar);
            }
            if (view == null) {
                return false;
            }
            aVar.mo26115b(view);
            if (!rVar.mo26744a() && mo26087e()) {
                if (this.f17641k.mo27208a(view) >= this.f17641k.mo27215d() || this.f17641k.mo27212b(view) < this.f17641k.mo27213c()) {
                    z = true;
                }
                if (z) {
                    if (aVar.f17652c) {
                        i = this.f17641k.mo27215d();
                    } else {
                        i = this.f17641k.mo27213c();
                    }
                    aVar.f17651b = i;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m19267a(RecyclerView.C3283r rVar, C3208a aVar) {
        int i;
        boolean z = false;
        if (rVar.mo26744a() || this.f17643m == -1) {
            return false;
        }
        if (this.f17643m < 0 || this.f17643m >= rVar.mo26749f()) {
            this.f17643m = -1;
            this.f17644n = Integer.MIN_VALUE;
            return false;
        }
        aVar.f17650a = this.f17643m;
        if (this.f17645o != null && this.f17645o.mo26103a()) {
            aVar.f17652c = this.f17645o.f17649c;
            if (aVar.f17652c) {
                aVar.f17651b = this.f17641k.mo27215d() - this.f17645o.f17648b;
            } else {
                aVar.f17651b = this.f17641k.mo27213c() + this.f17645o.f17648b;
            }
            return true;
        } else if (this.f17644n == Integer.MIN_VALUE) {
            View c = mo26080c(this.f17643m);
            if (c == null) {
                if (mo26658x() > 0) {
                    if ((this.f17643m < mo26623d(mo26641i(0))) == this.f17642l) {
                        z = true;
                    }
                    aVar.f17652c = z;
                }
                aVar.mo26114b();
            } else if (this.f17641k.mo27218e(c) > this.f17641k.mo27219f()) {
                aVar.mo26114b();
                return true;
            } else if (this.f17641k.mo27208a(c) - this.f17641k.mo27213c() < 0) {
                aVar.f17651b = this.f17641k.mo27213c();
                aVar.f17652c = false;
                return true;
            } else if (this.f17641k.mo27215d() - this.f17641k.mo27212b(c) < 0) {
                aVar.f17651b = this.f17641k.mo27215d();
                aVar.f17652c = true;
                return true;
            } else {
                if (aVar.f17652c) {
                    i = this.f17641k.mo27212b(c) + this.f17641k.mo27211b();
                } else {
                    i = this.f17641k.mo27208a(c);
                }
                aVar.f17651b = i;
            }
            return true;
        } else {
            aVar.f17652c = this.f17642l;
            if (this.f17642l) {
                aVar.f17651b = this.f17641k.mo27215d() - this.f17644n;
            } else {
                aVar.f17651b = this.f17641k.mo27213c() + this.f17644n;
            }
            return true;
        }
    }

    /* renamed from: a */
    private int m19258a(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, boolean z) {
        int d;
        int d2 = this.f17641k.mo27215d() - i;
        if (d2 <= 0) {
            return 0;
        }
        int i2 = -mo26078c(-d2, nVar, rVar);
        int i3 = i + i2;
        if (!z || (d = this.f17641k.mo27215d() - i3) <= 0) {
            return i2;
        }
        this.f17641k.mo27210a(d);
        return d + i2;
    }

    /* renamed from: b */
    private int m19268b(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, boolean z) {
        int c;
        int c2 = i - this.f17641k.mo27213c();
        if (c2 <= 0) {
            return 0;
        }
        int i2 = -mo26078c(c2, nVar, rVar);
        int i3 = i + i2;
        if (!z || (c = i3 - this.f17641k.mo27213c()) <= 0) {
            return i2;
        }
        this.f17641k.mo27210a(-c);
        return i2 - c;
    }

    /* renamed from: a */
    private void m19262a(C3208a aVar) {
        mo20064a(aVar.f17650a, aVar.f17651b);
    }

    /* renamed from: a */
    private void mo20064a(int i, int i2) {
        this.f17632a.f17661c = this.f17641k.mo27215d() - i2;
        this.f17632a.f17663e = this.f17642l ? -1 : 1;
        this.f17632a.f17662d = i;
        this.f17632a.f17664f = 1;
        this.f17632a.f17660b = i2;
        this.f17632a.f17665g = Integer.MIN_VALUE;
    }

    /* renamed from: b */
    private void m19270b(C3208a aVar) {
        m19279h(aVar.f17650a, aVar.f17651b);
    }

    /* renamed from: h */
    private void m19279h(int i, int i2) {
        this.f17632a.f17661c = i2 - this.f17641k.mo27213c();
        this.f17632a.f17662d = i;
        this.f17632a.f17663e = this.f17642l ? 1 : -1;
        this.f17632a.f17664f = -1;
        this.f17632a.f17660b = i2;
        this.f17632a.f17665g = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo26096j() {
        return mo26656v() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo26097k() {
        if (this.f17632a == null) {
            this.f17632a = mo26098l();
        }
        if (this.f17641k == null) {
            this.f17641k = OrientationHelper.m20715a(this, this.f17640j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public C3210c mo26098l() {
        return new C3210c();
    }

    /* renamed from: e */
    public void mo26086e(int i) {
        this.f17643m = i;
        this.f17644n = Integer.MIN_VALUE;
        if (this.f17645o != null) {
            this.f17645o.mo26104b();
        }
        mo26651q();
    }

    /* renamed from: b */
    public void mo26077b(int i, int i2) {
        this.f17643m = i;
        this.f17644n = i2;
        if (this.f17645o != null) {
            this.f17645o.mo26104b();
        }
        mo26651q();
    }

    /* renamed from: a */
    public int mo26057a(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17640j == 1) {
            return 0;
        }
        return mo26078c(i, nVar, rVar);
    }

    /* renamed from: b */
    public int mo26073b(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17640j == 0) {
            return 0;
        }
        return mo26078c(i, nVar, rVar);
    }

    /* renamed from: c */
    public int mo26079c(RecyclerView.C3283r rVar) {
        return m19280i(rVar);
    }

    /* renamed from: d */
    public int mo26083d(RecyclerView.C3283r rVar) {
        return m19280i(rVar);
    }

    /* renamed from: e */
    public int mo26085e(RecyclerView.C3283r rVar) {
        return m19282j(rVar);
    }

    /* renamed from: f */
    public int mo26089f(RecyclerView.C3283r rVar) {
        return m19282j(rVar);
    }

    /* renamed from: g */
    public int mo26091g(RecyclerView.C3283r rVar) {
        return m19284k(rVar);
    }

    /* renamed from: h */
    public int mo26094h(RecyclerView.C3283r rVar) {
        return m19284k(rVar);
    }

    /* renamed from: i */
    private int m19280i(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        mo26097k();
        OrientationHelper pVar = this.f17641k;
        View a = m19259a(!this.f17636e, true);
        return ScrollbarHelper.m20792a(rVar, pVar, a, m19269b(!this.f17636e, true), this, this.f17636e, this.f17642l);
    }

    /* renamed from: j */
    private int m19282j(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        mo26097k();
        OrientationHelper pVar = this.f17641k;
        View a = m19259a(!this.f17636e, true);
        return ScrollbarHelper.m20791a(rVar, pVar, a, m19269b(!this.f17636e, true), this, this.f17636e);
    }

    /* renamed from: k */
    private int m19284k(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        mo26097k();
        OrientationHelper pVar = this.f17641k;
        View a = m19259a(!this.f17636e, true);
        return ScrollbarHelper.m20793b(rVar, pVar, a, m19269b(!this.f17636e, true), this, this.f17636e);
    }

    /* renamed from: a */
    private void m19261a(int i, int i2, boolean z, RecyclerView.C3283r rVar) {
        int i3;
        this.f17632a.f17670l = mo26099m();
        this.f17632a.f17666h = mo26074b(rVar);
        this.f17632a.f17664f = i;
        int i4 = -1;
        if (i == 1) {
            this.f17632a.f17666h += this.f17641k.mo27221g();
            View M = m19257M();
            C3210c cVar = this.f17632a;
            if (!this.f17642l) {
                i4 = 1;
            }
            cVar.f17663e = i4;
            this.f17632a.f17662d = mo26623d(M) + this.f17632a.f17663e;
            this.f17632a.f17660b = this.f17641k.mo27212b(M);
            i3 = this.f17641k.mo27212b(M) - this.f17641k.mo27215d();
        } else {
            View d = mo27181d();
            this.f17632a.f17666h += this.f17641k.mo27213c();
            C3210c cVar2 = this.f17632a;
            if (this.f17642l) {
                i4 = 1;
            }
            cVar2.f17663e = i4;
            this.f17632a.f17662d = mo26623d(d) + this.f17632a.f17663e;
            this.f17632a.f17660b = this.f17641k.mo27208a(d);
            i3 = (-this.f17641k.mo27208a(d)) + this.f17641k.mo27213c();
        }
        this.f17632a.f17661c = i2;
        if (z) {
            this.f17632a.f17661c -= i3;
        }
        this.f17632a.f17665g = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo26099m() {
        return this.f17641k.mo27222h() == 0 && this.f17641k.mo27217e() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26069a(RecyclerView.C3283r rVar, C3210c cVar, RecyclerView.C3266g.C3269a aVar) {
        int i = cVar.f17662d;
        if (i >= 0 && i < rVar.mo26749f()) {
            aVar.mo26666b(i, Math.max(0, cVar.f17665g));
        }
    }

    /* renamed from: a */
    public void mo26063a(int i, RecyclerView.C3266g.C3269a aVar) {
        int i2;
        boolean z;
        int i3 = -1;
        if (this.f17645o == null || !this.f17645o.mo26103a()) {
            mo27180c();
            z = this.f17642l;
            if (this.f17643m == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.f17643m;
            }
        } else {
            z = this.f17645o.f17649c;
            i2 = this.f17645o.f17647a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f17639h && i2 >= 0 && i2 < i; i4++) {
            aVar.mo26666b(i2, 0);
            i2 += i3;
        }
    }

    /* renamed from: a */
    public void mo26062a(int i, int i2, RecyclerView.C3283r rVar, RecyclerView.C3266g.C3269a aVar) {
        if (this.f17640j != 0) {
            i = i2;
        }
        if (mo26658x() != 0 && i != 0) {
            m19261a(i > 0 ? 1 : -1, Math.abs(i), true, rVar);
            mo26069a(rVar, this.f17632a, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo26078c(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (mo26658x() == 0 || i == 0) {
            return 0;
        }
        this.f17632a.f17659a = true;
        mo26097k();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m19261a(i2, abs, true, rVar);
        int a = this.f17632a.f17665g + mo26058a(nVar, this.f17632a, rVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f17641k.mo27210a(-i);
        this.f17632a.f17668j = i;
        return i;
    }

    /* renamed from: a */
    public void mo26071a(String str) {
        if (this.f17645o == null) {
            super.mo26071a(str);
        }
    }

    /* renamed from: a */
    private void m19264a(RecyclerView.C3277n nVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    mo26572a(i3, nVar);
                }
                return;
            }
            while (i > i2) {
                mo26572a(i, nVar);
                i--;
            }
        }
    }

    /* renamed from: a */
    private void m19263a(RecyclerView.C3277n nVar, int i) {
        if (i >= 0) {
            int x = mo26658x();
            if (this.f17642l) {
                int i2 = x - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View i4 = mo26641i(i3);
                    if (this.f17641k.mo27212b(i4) > i || this.f17641k.mo27214c(i4) > i) {
                        m19264a(nVar, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i5 = 0; i5 < x; i5++) {
                View i6 = mo26641i(i5);
                if (this.f17641k.mo27212b(i6) > i || this.f17641k.mo27214c(i6) > i) {
                    m19264a(nVar, 0, i5);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private void m19271b(RecyclerView.C3277n nVar, int i) {
        int x = mo26658x();
        if (i >= 0) {
            int e = this.f17641k.mo27217e() - i;
            if (this.f17642l) {
                for (int i2 = 0; i2 < x; i2++) {
                    View i3 = mo26641i(i2);
                    if (this.f17641k.mo27208a(i3) < e || this.f17641k.mo27216d(i3) < e) {
                        m19264a(nVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i4 = x - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View i6 = mo26641i(i5);
                if (this.f17641k.mo27208a(i6) < e || this.f17641k.mo27216d(i6) < e) {
                    m19264a(nVar, i4, i5);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m19265a(RecyclerView.C3277n nVar, C3210c cVar) {
        if (cVar.f17659a && !cVar.f17670l) {
            if (cVar.f17664f == -1) {
                m19271b(nVar, cVar.f17665g);
            } else {
                m19263a(nVar, cVar.f17665g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo26058a(RecyclerView.C3277n nVar, C3210c cVar, RecyclerView.C3283r rVar, boolean z) {
        int i = cVar.f17661c;
        if (cVar.f17665g != Integer.MIN_VALUE) {
            if (cVar.f17661c < 0) {
                cVar.f17665g += cVar.f17661c;
            }
            m19265a(nVar, cVar);
        }
        int i2 = cVar.f17661c + cVar.f17666h;
        C3209b bVar = new C3209b();
        while (true) {
            if ((!cVar.f17670l && i2 <= 0) || !cVar.mo26121a(rVar)) {
                break;
            }
            bVar.mo26117a();
            mo26067a(nVar, rVar, cVar, bVar);
            if (!bVar.f17656b) {
                cVar.f17660b += bVar.f17655a * cVar.f17664f;
                if (!bVar.f17657c || this.f17632a.f17669k != null || !rVar.mo26744a()) {
                    cVar.f17661c -= bVar.f17655a;
                    i2 -= bVar.f17655a;
                }
                if (cVar.f17665g != Integer.MIN_VALUE) {
                    cVar.f17665g += bVar.f17655a;
                    if (cVar.f17661c < 0) {
                        cVar.f17665g += cVar.f17661c;
                    }
                    m19265a(nVar, cVar);
                }
                if (z && bVar.f17658d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f17661c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26067a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, C3210c cVar, C3209b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a = cVar.mo26118a(nVar);
        if (a == null) {
            bVar.f17656b = true;
            return;
        }
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) a.getLayoutParams();
        if (cVar.f17669k == null) {
            if (this.f17642l == (cVar.f17664f == -1)) {
                mo26609b(a);
            } else {
                mo26610b(a, 0);
            }
        } else {
            if (this.f17642l == (cVar.f17664f == -1)) {
                mo26574a(a);
            } else {
                mo26575a(a, 0);
            }
        }
        mo26576a(a, 0, 0);
        bVar.f17655a = this.f17641k.mo27218e(a);
        if (this.f17640j == 1) {
            if (mo26096j()) {
                i5 = mo26557A() - mo26561E();
                i4 = i5 - this.f17641k.mo27220f(a);
            } else {
                i4 = mo26559C();
                i5 = this.f17641k.mo27220f(a) + i4;
            }
            if (cVar.f17664f == -1) {
                int i6 = cVar.f17660b;
                i3 = cVar.f17660b - bVar.f17655a;
                i2 = i5;
                i = i6;
            } else {
                int i7 = cVar.f17660b;
                i = cVar.f17660b + bVar.f17655a;
                i2 = i5;
                i3 = i7;
            }
        } else {
            int D = mo26560D();
            int f = this.f17641k.mo27220f(a) + D;
            if (cVar.f17664f == -1) {
                i3 = D;
                i2 = cVar.f17660b;
                i = f;
                i4 = cVar.f17660b - bVar.f17655a;
            } else {
                int i8 = cVar.f17660b;
                i2 = cVar.f17660b + bVar.f17655a;
                i3 = D;
                i = f;
                i4 = i8;
            }
        }
        mo26577a(a, i4, i3, i2, i);
        if (hVar.mo26668d() || hVar.mo26669e()) {
            bVar.f17657c = true;
        }
        bVar.f17658d = a.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo26100n() {
        return (mo26660z() == 1073741824 || mo26659y() == 1073741824 || !mo26568L()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo26088f(int i) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        switch (i) {
                            case 1:
                                return (this.f17640j != 1 && mo26096j()) ? 1 : -1;
                            case 2:
                                return (this.f17640j != 1 && mo26096j()) ? -1 : 1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    } else if (this.f17640j == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f17640j == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f17640j == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f17640j == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: d */
    private View mo27181d() {
        return mo26641i(this.f17642l ? mo26658x() - 1 : 0);
    }

    /* renamed from: M */
    private View m19257M() {
        return mo26641i(this.f17642l ? 0 : mo26658x() - 1);
    }

    /* renamed from: a */
    private View m19259a(boolean z, boolean z2) {
        if (this.f17642l) {
            return mo26059a(mo26658x() - 1, -1, z, z2);
        }
        return mo26059a(0, mo26658x(), z, z2);
    }

    /* renamed from: b */
    private View m19269b(boolean z, boolean z2) {
        if (this.f17642l) {
            return mo26059a(0, mo26658x(), z, z2);
        }
        return mo26059a(mo26658x() - 1, -1, z, z2);
    }

    /* renamed from: f */
    private View m19276f(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17642l) {
            return m19278h(nVar, rVar);
        }
        return m19281i(nVar, rVar);
    }

    /* renamed from: g */
    private View m19277g(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17642l) {
            return m19281i(nVar, rVar);
        }
        return m19278h(nVar, rVar);
    }

    /* renamed from: h */
    private View m19278h(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26061a(nVar, rVar, 0, mo26658x(), rVar.mo26749f());
    }

    /* renamed from: i */
    private View m19281i(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26061a(nVar, rVar, mo26658x() - 1, -1, rVar.mo26749f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo26061a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i, int i2, int i3) {
        mo26097k();
        int c = this.f17641k.mo27213c();
        int d = this.f17641k.mo27215d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = mo26641i(i);
            int d2 = mo26623d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (((RecyclerView.C3270h) i5.getLayoutParams()).mo26668d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else if (this.f17641k.mo27208a(i5) < d && this.f17641k.mo27212b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* renamed from: j */
    private View m19283j(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17642l) {
            return m19286l(nVar, rVar);
        }
        return m19287m(nVar, rVar);
    }

    /* renamed from: k */
    private View m19285k(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17642l) {
            return m19287m(nVar, rVar);
        }
        return m19286l(nVar, rVar);
    }

    /* renamed from: l */
    private View m19286l(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26081c(0, mo26658x());
    }

    /* renamed from: m */
    private View m19287m(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26081c(mo26658x() - 1, -1);
    }

    /* renamed from: o */
    public int mo26101o() {
        View a = mo26059a(0, mo26658x(), false, true);
        if (a == null) {
            return -1;
        }
        return mo26623d(a);
    }

    /* renamed from: p */
    public int mo26102p() {
        View a = mo26059a(mo26658x() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return mo26623d(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo26059a(int i, int i2, boolean z, boolean z2) {
        mo26097k();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.f17640j == 0) {
            return this.f18049s.mo27035a(i, i2, i4, i3);
        }
        return this.f18050t.mo27035a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo26081c(int i, int i2) {
        int i3;
        int i4;
        mo26097k();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return mo26641i(i);
        }
        if (this.f17641k.mo27208a(mo26641i(i)) < this.f17641k.mo27213c()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.f17640j == 0) {
            return this.f18049s.mo27035a(i, i2, i4, i3);
        }
        return this.f18050t.mo27035a(i, i2, i4, i3);
    }

    /* renamed from: a */
    public View mo26060a(View view, int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        int f;
        View view2;
        View view3;
        mo27180c();
        if (mo26658x() == 0 || (f = mo26088f(i)) == Integer.MIN_VALUE) {
            return null;
        }
        mo26097k();
        mo26097k();
        m19261a(f, (int) (((float) this.f17641k.mo27219f()) * 0.33333334f), false, rVar);
        this.f17632a.f17665g = Integer.MIN_VALUE;
        this.f17632a.f17659a = false;
        mo26058a(nVar, this.f17632a, rVar, true);
        if (f == -1) {
            view2 = m19285k(nVar, rVar);
        } else {
            view2 = m19283j(nVar, rVar);
        }
        if (f == -1) {
            view3 = mo27181d();
        } else {
            view3 = m19257M();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    /* renamed from: e */
    public boolean mo26087e() {
        return this.f17645o == null && this.f17633b == this.f17635d;
    }

    /* renamed from: flyme.support.v7.widget.LinearLayoutManager$c */
    static class C3210c {

        /* renamed from: a */
        boolean f17659a = true;

        /* renamed from: b */
        int f17660b;

        /* renamed from: c */
        int f17661c;

        /* renamed from: d */
        int f17662d;

        /* renamed from: e */
        int f17663e;

        /* renamed from: f */
        int f17664f;

        /* renamed from: g */
        int f17665g;

        /* renamed from: h */
        int f17666h = 0;

        /* renamed from: i */
        boolean f17667i = false;

        /* renamed from: j */
        int f17668j;

        /* renamed from: k */
        List<RecyclerView.C3286u> f17669k = null;

        /* renamed from: l */
        boolean f17670l;

        C3210c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26121a(RecyclerView.C3283r rVar) {
            return this.f17662d >= 0 && this.f17662d < rVar.mo26749f();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo26118a(RecyclerView.C3277n nVar) {
            if (this.f17669k != null) {
                return m19346b();
            }
            View c = nVar.mo26704c(this.f17662d);
            this.f17662d += this.f17663e;
            return c;
        }

        /* renamed from: b */
        private View m19346b() {
            int size = this.f17669k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f17669k.get(i).f18121j;
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                if (!hVar.mo26668d() && this.f17662d == hVar.mo26670f()) {
                    mo26120a(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo26119a() {
            mo26120a((View) null);
        }

        /* renamed from: a */
        public void mo26120a(View view) {
            View b = mo26122b(view);
            if (b == null) {
                this.f17662d = -1;
            } else {
                this.f17662d = ((RecyclerView.C3270h) b.getLayoutParams()).mo26670f();
            }
        }

        /* renamed from: b */
        public View mo26122b(View view) {
            int f;
            int size = this.f17669k.size();
            View view2 = null;
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f17669k.get(i2).f18121j;
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view3.getLayoutParams();
                if (view3 != view && !hVar.mo26668d() && (f = (hVar.mo26670f() - this.f17662d) * this.f17663e) >= 0 && f < i) {
                    if (f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = f;
                }
            }
            return view2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: flyme.support.v7.widget.LinearLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f17647a;

        /* renamed from: b */
        int f17648b;

        /* renamed from: c */
        boolean f17649c;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f17647a = parcel.readInt();
            this.f17648b = parcel.readInt();
            this.f17649c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f17647a = savedState.f17647a;
            this.f17648b = savedState.f17648b;
            this.f17649c = savedState.f17649c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26103a() {
            return this.f17647a >= 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26104b() {
            this.f17647a = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f17647a);
            parcel.writeInt(this.f17648b);
            parcel.writeInt(this.f17649c ? 1 : 0);
        }
    }

    /* renamed from: flyme.support.v7.widget.LinearLayoutManager$a */
    class C3208a {

        /* renamed from: a */
        int f17650a;

        /* renamed from: b */
        int f17651b;

        /* renamed from: c */
        boolean f17652c;

        /* renamed from: d */
        boolean f17653d;

        C3208a() {
            mo26111a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26111a() {
            this.f17650a = -1;
            this.f17651b = Integer.MIN_VALUE;
            this.f17652c = false;
            this.f17653d = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26114b() {
            int i;
            if (this.f17652c) {
                i = LinearLayoutManager.this.f17641k.mo27215d();
            } else {
                i = LinearLayoutManager.this.f17641k.mo27213c();
            }
            this.f17651b = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f17650a + ", mCoordinate=" + this.f17651b + ", mLayoutFromEnd=" + this.f17652c + ", mValid=" + this.f17653d + '}';
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26113a(View view, RecyclerView.C3283r rVar) {
            RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
            return !hVar.mo26668d() && hVar.mo26670f() >= 0 && hVar.mo26670f() < rVar.mo26749f();
        }

        /* renamed from: a */
        public void mo26112a(View view) {
            int b = LinearLayoutManager.this.f17641k.mo27211b();
            if (b >= 0) {
                mo26115b(view);
                return;
            }
            this.f17650a = LinearLayoutManager.this.mo26623d(view);
            if (this.f17652c) {
                int d = (LinearLayoutManager.this.f17641k.mo27215d() - b) - LinearLayoutManager.this.f17641k.mo27212b(view);
                this.f17651b = LinearLayoutManager.this.f17641k.mo27215d() - d;
                if (d > 0) {
                    int e = this.f17651b - LinearLayoutManager.this.f17641k.mo27218e(view);
                    int c = LinearLayoutManager.this.f17641k.mo27213c();
                    int min = e - (c + Math.min(LinearLayoutManager.this.f17641k.mo27208a(view) - c, 0));
                    if (min < 0) {
                        this.f17651b += Math.min(d, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a = LinearLayoutManager.this.f17641k.mo27208a(view);
            int c2 = a - LinearLayoutManager.this.f17641k.mo27213c();
            this.f17651b = a;
            if (c2 > 0) {
                int d2 = (LinearLayoutManager.this.f17641k.mo27215d() - Math.min(0, (LinearLayoutManager.this.f17641k.mo27215d() - b) - LinearLayoutManager.this.f17641k.mo27212b(view))) - (a + LinearLayoutManager.this.f17641k.mo27218e(view));
                if (d2 < 0) {
                    this.f17651b -= Math.min(c2, -d2);
                }
            }
        }

        /* renamed from: b */
        public void mo26115b(View view) {
            if (this.f17652c) {
                this.f17651b = LinearLayoutManager.this.f17641k.mo27212b(view) + LinearLayoutManager.this.f17641k.mo27211b();
            } else {
                this.f17651b = LinearLayoutManager.this.f17641k.mo27208a(view);
            }
            this.f17650a = LinearLayoutManager.this.mo26623d(view);
        }
    }

    /* renamed from: flyme.support.v7.widget.LinearLayoutManager$b */
    protected static class C3209b {

        /* renamed from: a */
        public int f17655a;

        /* renamed from: b */
        public boolean f17656b;

        /* renamed from: c */
        public boolean f17657c;

        /* renamed from: d */
        public boolean f17658d;

        protected C3209b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26117a() {
            this.f17655a = 0;
            this.f17656b = false;
            this.f17657c = false;
            this.f17658d = false;
        }
    }
}
