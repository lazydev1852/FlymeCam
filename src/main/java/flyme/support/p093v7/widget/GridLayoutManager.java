package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.k */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: b */
    boolean f18515b = false;

    /* renamed from: c */
    int f18516c = -1;

    /* renamed from: d */
    int[] f18517d;

    /* renamed from: e */
    View[] f18518e;

    /* renamed from: f */
    final SparseIntArray f18519f = new SparseIntArray();

    /* renamed from: g */
    final SparseIntArray f18520g = new SparseIntArray();

    /* renamed from: h */
    C3336c f18521h = new C3334a();

    /* renamed from: i */
    final Rect f18522i = new Rect();

    public GridLayoutManager(Context context, int i) {
        super(context);
        mo27178a(i);
    }

    /* renamed from: a */
    public int mo26569a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17640j == 0) {
            return this.f18516c;
        }
        if (rVar.mo26749f() < 1) {
            return 0;
        }
        return m20608a(nVar, rVar, rVar.mo26749f() - 1) + 1;
    }

    /* renamed from: b */
    public int mo26608b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f17640j == 1) {
            return this.f18516c;
        }
        if (rVar.mo26749f() < 1) {
            return 0;
        }
        return m20608a(nVar, rVar, rVar.mo26749f() - 1) + 1;
    }

    /* renamed from: a */
    public void mo26587a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C3335b)) {
            super.mo26580a(view, accessibilityNodeInfoCompat);
            return;
        }
        C3335b bVar = (C3335b) layoutParams;
        int a = m20608a(nVar, rVar, bVar.mo26670f());
        if (this.f17640j == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.mo27183a(), bVar.mo27184b(), a, 1, this.f18516c > 1 && bVar.mo27184b() == this.f18516c, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(a, 1, bVar.mo27183a(), bVar.mo27184b(), this.f18516c > 1 && bVar.mo27184b() == this.f18516c, false));
        }
    }

    /* renamed from: c */
    public void mo26082c(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (rVar.mo26744a()) {
            m20605N();
        }
        super.mo26082c(nVar, rVar);
        m20604M();
    }

    /* renamed from: a */
    public void mo26068a(RecyclerView.C3283r rVar) {
        super.mo26068a(rVar);
        this.f18515b = false;
    }

    /* renamed from: M */
    private void m20604M() {
        this.f18519f.clear();
        this.f18520g.clear();
    }

    /* renamed from: N */
    private void m20605N() {
        int x = mo26658x();
        for (int i = 0; i < x; i++) {
            C3335b bVar = (C3335b) mo26641i(i).getLayoutParams();
            int f = bVar.mo26670f();
            this.f18519f.put(f, bVar.mo27184b());
            this.f18520g.put(f, bVar.mo27183a());
        }
    }

    /* renamed from: a */
    public void mo26592a(RecyclerView recyclerView, int i, int i2) {
        this.f18521h.mo27185a();
    }

    /* renamed from: a */
    public void mo26591a(RecyclerView recyclerView) {
        this.f18521h.mo27185a();
    }

    /* renamed from: b */
    public void mo26614b(RecyclerView recyclerView, int i, int i2) {
        this.f18521h.mo27185a();
    }

    /* renamed from: a */
    public void mo26594a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f18521h.mo27185a();
    }

    /* renamed from: a */
    public void mo26593a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f18521h.mo27185a();
    }

    /* renamed from: b */
    public RecyclerView.C3270h mo26075b() {
        if (this.f17640j == 0) {
            return new C3335b(-2, -1);
        }
        return new C3335b(-1, -2);
    }

    /* renamed from: a */
    public RecyclerView.C3270h mo26570a(Context context, AttributeSet attributeSet) {
        return new C3335b(context, attributeSet);
    }

    /* renamed from: a */
    public RecyclerView.C3270h mo26571a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C3335b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C3335b(layoutParams);
    }

    /* renamed from: a */
    public boolean mo26599a(RecyclerView.C3270h hVar) {
        return hVar instanceof C3335b;
    }

    /* renamed from: a */
    public void mo27179a(C3336c cVar) {
        this.f18521h = cVar;
    }

    /* renamed from: c */
    public C3336c mo27180c() {
        return this.f18521h;
    }

    /* renamed from: O */
    private void m20606O() {
        int i;
        if (mo26093h() == 1) {
            i = (mo26557A() - mo26561E()) - mo26559C();
        } else {
            i = (mo26558B() - mo26562F()) - mo26560D();
        }
        m20617m(i);
    }

    /* renamed from: a */
    public void mo26573a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f18517d == null) {
            super.mo26573a(rect, i, i2);
        }
        int C = mo26559C() + mo26561E();
        int D = mo26560D() + mo26562F();
        if (this.f17640j == 1) {
            i4 = m19786a(i2, rect.height() + D, mo26565I());
            i3 = m19786a(i, this.f18517d[this.f18517d.length - 1] + C, mo26564H());
        } else {
            i3 = m19786a(i, rect.width() + C, mo26564H());
            i4 = m19786a(i2, this.f18517d[this.f18517d.length - 1] + D, mo26565I());
        }
        mo26637g(i3, i4);
    }

    /* renamed from: m */
    private void m20617m(int i) {
        this.f18517d = m20613a(this.f18517d, this.f18516c, i);
    }

    /* renamed from: a */
    static int[] m20613a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo20064a(int i, int i2) {
        if (this.f17640j != 1 || !mo26096j()) {
            return this.f18517d[i2 + i] - this.f18517d[i];
        }
        return this.f18517d[this.f18516c - i] - this.f18517d[(this.f18516c - i) - i2];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26066a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, LinearLayoutManager.C3208a aVar, int i) {
        super.mo26066a(nVar, rVar, aVar, i);
        m20606O();
        if (rVar.mo26749f() > 0 && !rVar.mo26744a()) {
            m20615b(nVar, rVar, aVar, i);
        }
        m20607P();
    }

    /* renamed from: P */
    private void m20607P() {
        if (this.f18518e == null || this.f18518e.length != this.f18516c) {
            this.f18518e = new View[this.f18516c];
        }
    }

    /* renamed from: a */
    public int mo26057a(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        m20606O();
        m20607P();
        return super.mo26057a(i, nVar, rVar);
    }

    /* renamed from: b */
    public int mo26073b(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        m20606O();
        m20607P();
        return super.mo26073b(i, nVar, rVar);
    }

    /* renamed from: b */
    private void m20615b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, LinearLayoutManager.C3208a aVar, int i) {
        boolean z = i == 1;
        int b = m20614b(nVar, rVar, aVar.f17650a);
        if (z) {
            while (b > 0 && aVar.f17650a > 0) {
                aVar.f17650a--;
                b = m20614b(nVar, rVar, aVar.f17650a);
            }
            return;
        }
        int f = rVar.mo26749f() - 1;
        int i2 = aVar.f17650a;
        while (i2 < f) {
            int i3 = i2 + 1;
            int b2 = m20614b(nVar, rVar, i3);
            if (b2 <= b) {
                break;
            }
            i2 = i3;
            b = b2;
        }
        aVar.f17650a = i2;
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
            if (d2 >= 0 && d2 < i3 && m20614b(nVar, rVar, d2) == 0) {
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

    /* renamed from: a */
    private int m20608a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i) {
        if (!rVar.mo26744a()) {
            return this.f18521h.mo27188c(i, this.f18516c);
        }
        int b = nVar.mo26698b(i);
        if (b != -1) {
            return this.f18521h.mo27188c(b, this.f18516c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* renamed from: b */
    private int m20614b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i) {
        if (!rVar.mo26744a()) {
            return this.f18521h.mo27187b(i, this.f18516c);
        }
        int i2 = this.f18520g.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = nVar.mo26698b(i);
        if (b != -1) {
            return this.f18521h.mo27187b(b, this.f18516c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* renamed from: c */
    private int m20616c(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i) {
        if (!rVar.mo26744a()) {
            return this.f18521h.mo23938a(i);
        }
        int i2 = this.f18519f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = nVar.mo26698b(i);
        if (b != -1) {
            return this.f18521h.mo23938a(b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26069a(RecyclerView.C3283r rVar, LinearLayoutManager.C3210c cVar, RecyclerView.C3266g.C3269a aVar) {
        int i = this.f18516c;
        for (int i2 = 0; i2 < this.f18516c && cVar.mo26121a(rVar) && i > 0; i2++) {
            int i3 = cVar.f17662d;
            aVar.mo26666b(i3, Math.max(0, cVar.f17665g));
            i -= this.f18521h.mo23938a(i3);
            cVar.f17662d += cVar.f17663e;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0225 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0223  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo26067a(flyme.support.p093v7.widget.RecyclerView.C3277n r19, flyme.support.p093v7.widget.RecyclerView.C3283r r20, flyme.support.p093v7.widget.LinearLayoutManager.C3210c r21, flyme.support.p093v7.widget.LinearLayoutManager.C3209b r22) {
        /*
            r18 = this;
            r6 = r18
            r1 = r19
            r2 = r20
            r7 = r21
            r8 = r22
            flyme.support.v7.widget.p r0 = r6.f17641k
            int r9 = r0.mo27223i()
            r10 = 1073741824(0x40000000, float:2.0)
            r11 = 1
            if (r9 == r10) goto L_0x0017
            r13 = 1
            goto L_0x0018
        L_0x0017:
            r13 = 0
        L_0x0018:
            int r0 = r18.mo26658x()
            if (r0 <= 0) goto L_0x0026
            int[] r0 = r6.f18517d
            int r3 = r6.f18516c
            r0 = r0[r3]
            r14 = r0
            goto L_0x0027
        L_0x0026:
            r14 = 0
        L_0x0027:
            if (r13 == 0) goto L_0x002c
            r18.m20606O()
        L_0x002c:
            int r0 = r7.f17663e
            if (r0 != r11) goto L_0x0032
            r15 = 1
            goto L_0x0033
        L_0x0032:
            r15 = 0
        L_0x0033:
            int r0 = r6.f18516c
            if (r15 != 0) goto L_0x0044
            int r0 = r7.f17662d
            int r0 = r6.m20614b((flyme.support.p093v7.widget.RecyclerView.C3277n) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r2, (int) r0)
            int r3 = r7.f17662d
            int r3 = r6.m20616c(r1, r2, r3)
            int r0 = r0 + r3
        L_0x0044:
            r4 = 0
            r5 = 0
        L_0x0046:
            int r3 = r6.f18516c
            if (r5 >= r3) goto L_0x009f
            boolean r3 = r7.mo26121a((flyme.support.p093v7.widget.RecyclerView.C3283r) r2)
            if (r3 == 0) goto L_0x009f
            if (r0 <= 0) goto L_0x009f
            int r3 = r7.f17662d
            int r10 = r6.m20616c(r1, r2, r3)
            int r12 = r6.f18516c
            if (r10 > r12) goto L_0x0071
            int r0 = r0 - r10
            if (r0 >= 0) goto L_0x0060
            goto L_0x009f
        L_0x0060:
            android.view.View r3 = r7.mo26118a((flyme.support.p093v7.widget.RecyclerView.C3277n) r1)
            if (r3 != 0) goto L_0x0067
            goto L_0x009f
        L_0x0067:
            int r4 = r4 + r10
            android.view.View[] r10 = r6.f18518e
            r10[r5] = r3
            int r5 = r5 + 1
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0046
        L_0x0071:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Item at position "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " requires "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = " spans but GridLayoutManager has only "
            r1.append(r2)
            int r2 = r6.f18516c
            r1.append(r2)
            java.lang.String r2 = " spans."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009f:
            if (r5 != 0) goto L_0x00a4
            r8.f17656b = r11
            return
        L_0x00a4:
            r10 = 0
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r5
            r12 = r5
            r5 = r15
            r0.m20612a((flyme.support.p093v7.widget.RecyclerView.C3277n) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r2, (int) r3, (int) r4, (boolean) r5)
            r0 = 0
            r1 = 0
        L_0x00b3:
            if (r0 >= r12) goto L_0x0101
            android.view.View[] r2 = r6.f18518e
            r2 = r2[r0]
            java.util.List<flyme.support.v7.widget.RecyclerView$u> r3 = r7.f17669k
            if (r3 != 0) goto L_0x00c9
            if (r15 == 0) goto L_0x00c4
            r6.mo26609b((android.view.View) r2)
            r3 = 0
            goto L_0x00d3
        L_0x00c4:
            r3 = 0
            r6.mo26610b((android.view.View) r2, (int) r3)
            goto L_0x00d3
        L_0x00c9:
            r3 = 0
            if (r15 == 0) goto L_0x00d0
            r6.mo26574a((android.view.View) r2)
            goto L_0x00d3
        L_0x00d0:
            r6.mo26575a((android.view.View) r2, (int) r3)
        L_0x00d3:
            android.graphics.Rect r4 = r6.f18522i
            r6.mo26611b((android.view.View) r2, (android.graphics.Rect) r4)
            r6.m20611a((android.view.View) r2, (int) r9, (boolean) r3)
            flyme.support.v7.widget.p r3 = r6.f17641k
            int r3 = r3.mo27218e(r2)
            if (r3 <= r1) goto L_0x00e4
            r1 = r3
        L_0x00e4:
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            flyme.support.v7.widget.k$b r3 = (flyme.support.p093v7.widget.GridLayoutManager.C3335b) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            flyme.support.v7.widget.p r5 = r6.f17641k
            int r2 = r5.mo27220f(r2)
            float r2 = (float) r2
            float r2 = r2 * r4
            int r3 = r3.f18524b
            float r3 = (float) r3
            float r2 = r2 / r3
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fe
            r10 = r2
        L_0x00fe:
            int r0 = r0 + 1
            goto L_0x00b3
        L_0x0101:
            if (r13 == 0) goto L_0x011f
            r6.m20609a((float) r10, (int) r14)
            r0 = 0
            r1 = 0
        L_0x0108:
            if (r0 >= r12) goto L_0x011f
            android.view.View[] r2 = r6.f18518e
            r2 = r2[r0]
            r3 = 1073741824(0x40000000, float:2.0)
            r6.m20611a((android.view.View) r2, (int) r3, (boolean) r11)
            flyme.support.v7.widget.p r3 = r6.f17641k
            int r2 = r3.mo27218e(r2)
            if (r2 <= r1) goto L_0x011c
            r1 = r2
        L_0x011c:
            int r0 = r0 + 1
            goto L_0x0108
        L_0x011f:
            r0 = 0
        L_0x0120:
            if (r0 >= r12) goto L_0x0182
            android.view.View[] r2 = r6.f18518e
            r2 = r2[r0]
            flyme.support.v7.widget.p r3 = r6.f17641k
            int r3 = r3.mo27218e(r2)
            if (r3 == r1) goto L_0x017c
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            flyme.support.v7.widget.k$b r3 = (flyme.support.p093v7.widget.GridLayoutManager.C3335b) r3
            android.graphics.Rect r4 = r3.f18060d
            int r5 = r4.top
            int r9 = r4.bottom
            int r5 = r5 + r9
            int r9 = r3.topMargin
            int r5 = r5 + r9
            int r9 = r3.bottomMargin
            int r5 = r5 + r9
            int r9 = r4.left
            int r4 = r4.right
            int r9 = r9 + r4
            int r4 = r3.leftMargin
            int r9 = r9 + r4
            int r4 = r3.rightMargin
            int r9 = r9 + r4
            int r4 = r3.f18523a
            int r10 = r3.f18524b
            int r4 = r6.mo20064a((int) r4, (int) r10)
            int r10 = r6.f17640j
            if (r10 != r11) goto L_0x0168
            int r3 = r3.width
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            int r3 = m19787a((int) r4, (int) r13, (int) r9, (int) r3, (boolean) r10)
            int r4 = r1 - r5
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r13)
            goto L_0x0178
        L_0x0168:
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = r1 - r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r3 = r3.height
            int r4 = m19787a((int) r4, (int) r13, (int) r5, (int) r3, (boolean) r10)
            r3 = r9
        L_0x0178:
            r6.m20610a((android.view.View) r2, (int) r3, (int) r4, (boolean) r11)
            goto L_0x017f
        L_0x017c:
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
        L_0x017f:
            int r0 = r0 + 1
            goto L_0x0120
        L_0x0182:
            r10 = 0
            r8.f17655a = r1
            int r0 = r6.f17640j
            r2 = -1
            if (r0 != r11) goto L_0x019d
            int r0 = r7.f17664f
            if (r0 != r2) goto L_0x0197
            int r0 = r7.f17660b
            int r1 = r0 - r1
            r3 = r0
            r2 = r1
        L_0x0194:
            r0 = 0
            r1 = 0
            goto L_0x01b2
        L_0x0197:
            int r0 = r7.f17660b
            int r1 = r1 + r0
            r2 = r0
            r3 = r1
            goto L_0x0194
        L_0x019d:
            int r0 = r7.f17664f
            if (r0 != r2) goto L_0x01ad
            int r0 = r7.f17660b
            int r1 = r0 - r1
            r2 = 0
            r3 = 0
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x01b2
        L_0x01ad:
            int r0 = r7.f17660b
            int r1 = r1 + r0
            r2 = 0
            r3 = 0
        L_0x01b2:
            if (r10 >= r12) goto L_0x0237
            android.view.View[] r4 = r6.f18518e
            r7 = r4[r10]
            android.view.ViewGroup$LayoutParams r4 = r7.getLayoutParams()
            r9 = r4
            flyme.support.v7.widget.k$b r9 = (flyme.support.p093v7.widget.GridLayoutManager.C3335b) r9
            int r4 = r6.f17640j
            if (r4 != r11) goto L_0x01f5
            boolean r0 = r18.mo26096j()
            if (r0 == 0) goto L_0x01e2
            int r0 = r18.mo26559C()
            int[] r1 = r6.f18517d
            int r4 = r6.f18516c
            int r5 = r9.f18523a
            int r4 = r4 - r5
            r1 = r1[r4]
            int r0 = r0 + r1
            flyme.support.v7.widget.p r1 = r6.f17641k
            int r1 = r1.mo27220f(r7)
            int r1 = r0 - r1
            r15 = r0
            r13 = r1
            goto L_0x0209
        L_0x01e2:
            int r0 = r18.mo26559C()
            int[] r1 = r6.f18517d
            int r4 = r9.f18523a
            r1 = r1[r4]
            int r0 = r0 + r1
            flyme.support.v7.widget.p r1 = r6.f17641k
            int r1 = r1.mo27220f(r7)
            int r1 = r1 + r0
            goto L_0x0207
        L_0x01f5:
            int r2 = r18.mo26560D()
            int[] r3 = r6.f18517d
            int r4 = r9.f18523a
            r3 = r3[r4]
            int r2 = r2 + r3
            flyme.support.v7.widget.p r3 = r6.f17641k
            int r3 = r3.mo27220f(r7)
            int r3 = r3 + r2
        L_0x0207:
            r13 = r0
            r15 = r1
        L_0x0209:
            r14 = r2
            r16 = r3
            r0 = r18
            r1 = r7
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r0.mo26577a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
            boolean r0 = r9.mo26668d()
            if (r0 != 0) goto L_0x0223
            boolean r0 = r9.mo26669e()
            if (r0 == 0) goto L_0x0225
        L_0x0223:
            r8.f17657c = r11
        L_0x0225:
            boolean r0 = r8.f17658d
            boolean r1 = r7.hasFocusable()
            r0 = r0 | r1
            r8.f17658d = r0
            int r10 = r10 + 1
            r0 = r13
            r2 = r14
            r1 = r15
            r3 = r16
            goto L_0x01b2
        L_0x0237:
            android.view.View[] r0 = r6.f18518e
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.GridLayoutManager.mo26067a(flyme.support.v7.widget.RecyclerView$n, flyme.support.v7.widget.RecyclerView$r, flyme.support.v7.widget.LinearLayoutManager$c, flyme.support.v7.widget.LinearLayoutManager$b):void");
    }

    /* renamed from: a */
    private void m20611a(View view, int i, boolean z) {
        int i2;
        int i3;
        C3335b bVar = (C3335b) view.getLayoutParams();
        Rect rect = bVar.f18060d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a = mo20064a(bVar.f18523a, bVar.f18524b);
        if (this.f17640j == 1) {
            i2 = m19787a(a, i, i5, bVar.width, false);
            i3 = m19787a(this.f17641k.mo27219f(), mo26660z(), i4, bVar.height, true);
        } else {
            int a2 = m19787a(a, i, i4, bVar.height, false);
            int a3 = m19787a(this.f17641k.mo27219f(), mo26659y(), i5, bVar.width, true);
            i3 = a2;
            i2 = a3;
        }
        m20610a(view, i2, i3, z);
    }

    /* renamed from: a */
    private void m20609a(float f, int i) {
        m20617m(Math.max(Math.round(f * ((float) this.f18516c)), i));
    }

    /* renamed from: a */
    private void m20610a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
        if (z) {
            z2 = mo26596a(view, i, i2, hVar);
        } else {
            z2 = mo26617b(view, i, i2, hVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m20612a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i5 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View view = this.f18518e[i4];
            C3335b bVar = (C3335b) view.getLayoutParams();
            bVar.f18524b = m20616c(nVar, rVar, mo26623d(view));
            bVar.f18523a = i6;
            i6 += bVar.f18524b;
            i4 += i3;
        }
    }

    /* renamed from: d */
    public int mo27181d() {
        return this.f18516c;
    }

    /* renamed from: a */
    public void mo27178a(int i) {
        if (i != this.f18516c) {
            this.f18515b = true;
            if (i >= 1) {
                this.f18516c = i;
                this.f18521h.mo27185a();
                mo26651q();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    /* renamed from: flyme.support.v7.widget.k$c */
    /* compiled from: GridLayoutManager */
    public static abstract class C3336c {

        /* renamed from: a */
        private boolean f18525a = false;

        /* renamed from: d */
        final SparseIntArray f18526d = new SparseIntArray();

        /* renamed from: a */
        public abstract int mo23938a(int i);

        /* renamed from: a */
        public void mo27185a() {
            this.f18526d.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo27187b(int i, int i2) {
            if (!this.f18525a) {
                return mo27182a(i, i2);
            }
            int i3 = this.f18526d.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a = mo27182a(i, i2);
            this.f18526d.put(i, a);
            return a;
        }

        /* renamed from: a */
        public int mo27182a(int i, int i2) {
            int i3;
            int i4;
            int b;
            int a = mo23938a(i);
            if (a == i2) {
                return 0;
            }
            if (!this.f18525a || this.f18526d.size() <= 0 || (b = mo27186b(i)) < 0) {
                i4 = 0;
                i3 = 0;
            } else {
                i3 = this.f18526d.get(b) + mo23938a(b);
                i4 = b + 1;
            }
            while (i4 < i) {
                int a2 = mo23938a(i4);
                int i5 = i3 + a2;
                if (i5 == i2) {
                    i5 = 0;
                } else if (i5 > i2) {
                    i5 = a2;
                }
                i4++;
            }
            if (a + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo27186b(int i) {
            int size = this.f18526d.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f18526d.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f18526d.size()) {
                return -1;
            }
            return this.f18526d.keyAt(i4);
        }

        /* renamed from: c */
        public int mo27188c(int i, int i2) {
            int a = mo23938a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a2 = mo23938a(i5);
                i3 += a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a2;
                }
            }
            return i3 + a > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo26060a(android.view.View r26, int r27, flyme.support.p093v7.widget.RecyclerView.C3277n r28, flyme.support.p093v7.widget.RecyclerView.C3283r r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            r2 = r29
            android.view.View r3 = r25.mo26628e((android.view.View) r26)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            flyme.support.v7.widget.k$b r5 = (flyme.support.p093v7.widget.GridLayoutManager.C3335b) r5
            int r6 = r5.f18523a
            int r7 = r5.f18523a
            int r5 = r5.f18524b
            int r7 = r7 + r5
            android.view.View r5 = super.mo26060a((android.view.View) r26, (int) r27, (flyme.support.p093v7.widget.RecyclerView.C3277n) r28, (flyme.support.p093v7.widget.RecyclerView.C3283r) r29)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r27
            int r5 = r0.mo26088f((int) r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.f17642l
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r25.mo26658x()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r25.mo26658x()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.f17640j
            if (r13 != r9) goto L_0x0053
            boolean r13 = r25.mo26096j()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.m20608a((flyme.support.p093v7.widget.RecyclerView.C3277n) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r2, (int) r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r17 = 0
            r18 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0146
            int r9 = r0.m20608a((flyme.support.p093v7.widget.RecyclerView.C3277n) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r2, (int) r5)
            android.view.View r1 = r0.mo26641i((int) r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0146
        L_0x006d:
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0146
        L_0x0079:
            r21 = r3
            r23 = r8
            r24 = r10
            r22 = r11
            r8 = r17
            r11 = r18
            goto L_0x0132
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            flyme.support.v7.widget.k$b r9 = (flyme.support.p093v7.widget.GridLayoutManager.C3335b) r9
            int r2 = r9.f18523a
            r21 = r3
            int r3 = r9.f18523a
            r22 = r11
            int r11 = r9.f18524b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00be
            if (r10 != 0) goto L_0x00be
        L_0x00b3:
            r23 = r8
            r24 = r10
            r8 = r17
        L_0x00b9:
            r11 = r18
        L_0x00bb:
            r19 = 1
            goto L_0x0102
        L_0x00be:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00db
            if (r11 <= r15) goto L_0x00d1
            goto L_0x00b3
        L_0x00d1:
            if (r11 != r15) goto L_0x00f8
            if (r2 <= r8) goto L_0x00d7
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            if (r13 != r11) goto L_0x00f8
            goto L_0x00b3
        L_0x00db:
            if (r4 != 0) goto L_0x00f8
            r23 = r8
            r24 = r10
            r8 = 1
            r10 = 0
            boolean r16 = r0.mo26598a((android.view.View) r1, (boolean) r10, (boolean) r8)
            if (r16 == 0) goto L_0x00fc
            r8 = r17
            if (r11 <= r8) goto L_0x00ee
            goto L_0x00b9
        L_0x00ee:
            if (r11 != r8) goto L_0x00fe
            r11 = r18
            if (r2 <= r11) goto L_0x00f5
            r10 = 1
        L_0x00f5:
            if (r13 != r10) goto L_0x0100
            goto L_0x00bb
        L_0x00f8:
            r23 = r8
            r24 = r10
        L_0x00fc:
            r8 = r17
        L_0x00fe:
            r11 = r18
        L_0x0100:
            r19 = 0
        L_0x0102:
            if (r19 == 0) goto L_0x0132
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x011f
            int r4 = r9.f18523a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r17 = r8
            r18 = r11
            r10 = r24
            r8 = r4
            r4 = r1
            goto L_0x013a
        L_0x011f:
            int r8 = r9.f18523a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r17 = r3
            r18 = r8
            r8 = r23
            goto L_0x013a
        L_0x0132:
            r17 = r8
            r18 = r11
            r8 = r23
            r10 = r24
        L_0x013a:
            int r5 = r5 + r12
            r3 = r21
            r11 = r22
            r1 = r28
            r2 = r29
            r9 = 1
            goto L_0x005f
        L_0x0146:
            r24 = r10
            if (r4 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r4 = r24
        L_0x014d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.GridLayoutManager.mo26060a(android.view.View, int, flyme.support.v7.widget.RecyclerView$n, flyme.support.v7.widget.RecyclerView$r):android.view.View");
    }

    /* renamed from: e */
    public boolean mo26087e() {
        return this.f17645o == null && !this.f18515b;
    }

    /* renamed from: flyme.support.v7.widget.k$a */
    /* compiled from: GridLayoutManager */
    public static final class C3334a extends C3336c {
        /* renamed from: a */
        public int mo23938a(int i) {
            return 1;
        }

        /* renamed from: a */
        public int mo27182a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: flyme.support.v7.widget.k$b */
    /* compiled from: GridLayoutManager */
    public static class C3335b extends RecyclerView.C3270h {

        /* renamed from: a */
        int f18523a = -1;

        /* renamed from: b */
        int f18524b = 0;

        public C3335b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3335b(int i, int i2) {
            super(i, i2);
        }

        public C3335b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C3335b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int mo27183a() {
            return this.f18523a;
        }

        /* renamed from: b */
        public int mo27184b() {
            return this.f18524b;
        }
    }
}
