package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager */
public class StaggeredGridLayoutManager extends RecyclerView.C3266g implements RecyclerView.C3280q.C3282b {

    /* renamed from: A */
    private SavedState f18265A;

    /* renamed from: B */
    private int f18266B;

    /* renamed from: C */
    private final Rect f18267C;

    /* renamed from: D */
    private final C3307a f18268D;

    /* renamed from: E */
    private boolean f18269E;

    /* renamed from: F */
    private boolean f18270F;

    /* renamed from: G */
    private int[] f18271G;

    /* renamed from: H */
    private final Runnable f18272H;

    /* renamed from: a */
    C3309c[] f18273a;
    @NonNull

    /* renamed from: b */
    OrientationHelper f18274b;
    @NonNull

    /* renamed from: c */
    OrientationHelper f18275c;

    /* renamed from: d */
    boolean f18276d;

    /* renamed from: e */
    boolean f18277e;

    /* renamed from: f */
    int f18278f;

    /* renamed from: g */
    int f18279g;

    /* renamed from: h */
    LazySpanLookup f18280h;

    /* renamed from: i */
    private int f18281i;

    /* renamed from: j */
    private int f18282j;

    /* renamed from: k */
    private int f18283k;
    @NonNull

    /* renamed from: l */
    private final LayoutState f18284l;

    /* renamed from: m */
    private BitSet f18285m;

    /* renamed from: n */
    private int f18286n;

    /* renamed from: o */
    private boolean f18287o;

    /* renamed from: p */
    private boolean f18288p;

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo26856c() {
        int i;
        int i2;
        if (mo26658x() == 0 || this.f18286n == 0 || !mo26653s()) {
            return false;
        }
        if (this.f18277e) {
            i2 = mo26864m();
            i = mo26865o();
        } else {
            i2 = mo26865o();
            i = mo26864m();
        }
        if (i2 == 0 && mo26857d() != null) {
            this.f18280h.mo26869a();
            mo26567K();
            mo26651q();
            return true;
        } else if (!this.f18269E) {
            return false;
        } else {
            int i3 = this.f18277e ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem a = this.f18280h.mo26868a(i2, i4, i3, true);
            if (a == null) {
                this.f18269E = false;
                this.f18280h.mo26867a(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem a2 = this.f18280h.mo26868a(i2, a.f18291a, i3 * -1, true);
            if (a2 == null) {
                this.f18280h.mo26867a(a.f18291a);
            } else {
                this.f18280h.mo26867a(a2.f18291a + 1);
            }
            mo26567K();
            mo26651q();
            return true;
        }
    }

    /* renamed from: l */
    public void mo26647l(int i) {
        if (i == 0) {
            mo26856c();
        }
    }

    /* renamed from: a */
    public void mo26070a(RecyclerView recyclerView, RecyclerView.C3277n nVar) {
        mo26607a(this.f18272H);
        for (int i = 0; i < this.f18281i; i++) {
            this.f18273a[i].mo26918e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo26857d() {
        /*
            r12 = this;
            int r0 = r12.mo26658x()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f18281i
            r2.<init>(r3)
            int r3 = r12.f18281i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f18282j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.mo26859h()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f18277e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.mo26641i((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            flyme.support.v7.widget.StaggeredGridLayoutManager$b r8 = (flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3308b) r8
            flyme.support.v7.widget.StaggeredGridLayoutManager$c r9 = r8.f18312a
            int r9 = r9.f18318e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            flyme.support.v7.widget.StaggeredGridLayoutManager$c r9 = r8.f18312a
            boolean r9 = r12.m20181a((flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3309c) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            flyme.support.v7.widget.StaggeredGridLayoutManager$c r9 = r8.f18312a
            int r9 = r9.f18318e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f18313b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.mo26641i((int) r9)
            boolean r10 = r12.f18277e
            if (r10 == 0) goto L_0x0077
            flyme.support.v7.widget.p r10 = r12.f18274b
            int r10 = r10.mo27212b((android.view.View) r7)
            flyme.support.v7.widget.p r11 = r12.f18274b
            int r11 = r11.mo27212b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            flyme.support.v7.widget.p r10 = r12.f18274b
            int r10 = r10.mo27208a((android.view.View) r7)
            flyme.support.v7.widget.p r11 = r12.f18274b
            int r11 = r11.mo27208a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            flyme.support.v7.widget.StaggeredGridLayoutManager$b r9 = (flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3308b) r9
            flyme.support.v7.widget.StaggeredGridLayoutManager$c r8 = r8.f18312a
            int r8 = r8.f18318e
            flyme.support.v7.widget.StaggeredGridLayoutManager$c r9 = r9.f18312a
            int r9 = r9.f18318e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.StaggeredGridLayoutManager.mo26857d():android.view.View");
    }

    /* renamed from: a */
    private boolean m20181a(C3309c cVar) {
        if (this.f18277e) {
            if (cVar.mo26916d() < this.f18274b.mo27215d()) {
                return !cVar.mo26913c(cVar.f18314a.get(cVar.f18314a.size() - 1)).f18313b;
            }
        } else if (cVar.mo26909b() > this.f18274b.mo27213c()) {
            return !cVar.mo26913c(cVar.f18314a.get(0)).f18313b;
        }
        return false;
    }

    /* renamed from: a */
    public void mo26851a(boolean z) {
        mo26071a((String) null);
        if (!(this.f18265A == null || this.f18265A.f18302h == z)) {
            this.f18265A.f18302h = z;
        }
        this.f18276d = z;
        mo26651q();
    }

    /* renamed from: a */
    public void mo26071a(String str) {
        if (this.f18265A == null) {
            super.mo26071a(str);
        }
    }

    /* renamed from: M */
    private void m20169M() {
        if (this.f18282j == 1 || !mo26859h()) {
            this.f18277e = this.f18276d;
        } else {
            this.f18277e = !this.f18276d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo26859h() {
        return mo26656v() == 1;
    }

    /* renamed from: i */
    public boolean mo26860i() {
        return this.f18276d;
    }

    /* renamed from: a */
    public void mo26573a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int C = mo26559C() + mo26561E();
        int D = mo26560D() + mo26562F();
        if (this.f18282j == 1) {
            i4 = m19786a(i2, rect.height() + D, mo26565I());
            i3 = m19786a(i, (this.f18283k * this.f18281i) + C, mo26564H());
        } else {
            i3 = m19786a(i, rect.width() + C, mo26564H());
            i4 = m19786a(i2, (this.f18283k * this.f18281i) + D, mo26565I());
        }
        mo26637g(i3, i4);
    }

    /* renamed from: c */
    public void mo26082c(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        m20177a(nVar, rVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0163, code lost:
        if (mo26856c() != false) goto L_0x0167;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20177a(flyme.support.p093v7.widget.RecyclerView.C3277n r9, flyme.support.p093v7.widget.RecyclerView.C3283r r10, boolean r11) {
        /*
            r8 = this;
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r0 = r8.f18268D
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f18265A
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f18278f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.mo26749f()
            if (r1 != 0) goto L_0x0018
            r8.mo26620c((flyme.support.p093v7.widget.RecyclerView.C3277n) r9)
            r0.mo26895a()
            return
        L_0x0018:
            boolean r1 = r0.f18309e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f18278f
            if (r1 != r2) goto L_0x0029
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f18265A
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.mo26895a()
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f18265A
            if (r5 == 0) goto L_0x0037
            r8.m20179a((flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3307a) r0)
            goto L_0x003e
        L_0x0037:
            r8.m20169M()
            boolean r5 = r8.f18277e
            r0.f18307c = r5
        L_0x003e:
            r8.mo26850a((flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3307a) r0)
            r0.f18309e = r4
        L_0x0043:
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f18265A
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f18278f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f18307c
            boolean r6 = r8.f18287o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.mo26859h()
            boolean r6 = r8.f18288p
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f18280h
            r5.mo26869a()
            r0.f18308d = r4
        L_0x0060:
            int r5 = r8.mo26658x()
            if (r5 <= 0) goto L_0x00cd
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f18265A
            if (r5 == 0) goto L_0x0070
            flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f18265A
            int r5 = r5.f18297c
            if (r5 >= r4) goto L_0x00cd
        L_0x0070:
            boolean r5 = r0.f18308d
            if (r5 == 0) goto L_0x0092
            r1 = 0
        L_0x0075:
            int r5 = r8.f18281i
            if (r1 >= r5) goto L_0x00cd
            flyme.support.v7.widget.StaggeredGridLayoutManager$c[] r5 = r8.f18273a
            r5 = r5[r1]
            r5.mo26918e()
            int r5 = r0.f18306b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008f
            flyme.support.v7.widget.StaggeredGridLayoutManager$c[] r5 = r8.f18273a
            r5 = r5[r1]
            int r6 = r0.f18306b
            r5.mo26915c((int) r6)
        L_0x008f:
            int r1 = r1 + 1
            goto L_0x0075
        L_0x0092:
            if (r1 != 0) goto L_0x00b3
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r1 = r8.f18268D
            int[] r1 = r1.f18310f
            if (r1 != 0) goto L_0x009b
            goto L_0x00b3
        L_0x009b:
            r1 = 0
        L_0x009c:
            int r5 = r8.f18281i
            if (r1 >= r5) goto L_0x00cd
            flyme.support.v7.widget.StaggeredGridLayoutManager$c[] r5 = r8.f18273a
            r5 = r5[r1]
            r5.mo26918e()
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r6 = r8.f18268D
            int[] r6 = r6.f18310f
            r6 = r6[r1]
            r5.mo26915c((int) r6)
            int r1 = r1 + 1
            goto L_0x009c
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            int r5 = r8.f18281i
            if (r1 >= r5) goto L_0x00c6
            flyme.support.v7.widget.StaggeredGridLayoutManager$c[] r5 = r8.f18273a
            r5 = r5[r1]
            boolean r6 = r8.f18277e
            int r7 = r0.f18306b
            r5.mo26908a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b4
        L_0x00c6:
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r1 = r8.f18268D
            flyme.support.v7.widget.StaggeredGridLayoutManager$c[] r5 = r8.f18273a
            r1.mo26897a((flyme.support.p093v7.widget.StaggeredGridLayoutManager.C3309c[]) r5)
        L_0x00cd:
            r8.mo26585a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9)
            flyme.support.v7.widget.m r1 = r8.f18284l
            r1.f18537a = r3
            r8.f18269E = r3
            flyme.support.v7.widget.p r1 = r8.f18275c
            int r1 = r1.mo27219f()
            r8.mo26847a((int) r1)
            int r1 = r0.f18305a
            r8.m20186b((int) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10)
            boolean r1 = r0.f18307c
            if (r1 == 0) goto L_0x0104
            r8.m20184b((int) r2)
            flyme.support.v7.widget.m r1 = r8.f18284l
            r8.m20171a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.LayoutState) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10)
            r8.m20184b((int) r4)
            flyme.support.v7.widget.m r1 = r8.f18284l
            int r2 = r0.f18305a
            flyme.support.v7.widget.m r5 = r8.f18284l
            int r5 = r5.f18540d
            int r2 = r2 + r5
            r1.f18539c = r2
            flyme.support.v7.widget.m r1 = r8.f18284l
            r8.m20171a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.LayoutState) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10)
            goto L_0x011f
        L_0x0104:
            r8.m20184b((int) r4)
            flyme.support.v7.widget.m r1 = r8.f18284l
            r8.m20171a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.LayoutState) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10)
            r8.m20184b((int) r2)
            flyme.support.v7.widget.m r1 = r8.f18284l
            int r2 = r0.f18305a
            flyme.support.v7.widget.m r5 = r8.f18284l
            int r5 = r5.f18540d
            int r2 = r2 + r5
            r1.f18539c = r2
            flyme.support.v7.widget.m r1 = r8.f18284l
            r8.m20171a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.LayoutState) r1, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10)
        L_0x011f:
            r8.m20170N()
            int r1 = r8.mo26658x()
            if (r1 <= 0) goto L_0x0139
            boolean r1 = r8.f18277e
            if (r1 == 0) goto L_0x0133
            r8.m20188b((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (boolean) r4)
            r8.m20190c((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (boolean) r3)
            goto L_0x0139
        L_0x0133:
            r8.m20190c((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (boolean) r4)
            r8.m20188b((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (boolean) r3)
        L_0x0139:
            if (r11 == 0) goto L_0x0166
            boolean r11 = r10.mo26744a()
            if (r11 != 0) goto L_0x0166
            int r11 = r8.f18286n
            if (r11 == 0) goto L_0x0157
            int r11 = r8.mo26658x()
            if (r11 <= 0) goto L_0x0157
            boolean r11 = r8.f18269E
            if (r11 != 0) goto L_0x0155
            android.view.View r11 = r8.mo26857d()
            if (r11 == 0) goto L_0x0157
        L_0x0155:
            r11 = 1
            goto L_0x0158
        L_0x0157:
            r11 = 0
        L_0x0158:
            if (r11 == 0) goto L_0x0166
            java.lang.Runnable r11 = r8.f18272H
            r8.mo26607a((java.lang.Runnable) r11)
            boolean r11 = r8.mo26856c()
            if (r11 == 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r4 = 0
        L_0x0167:
            boolean r11 = r10.mo26744a()
            if (r11 == 0) goto L_0x0172
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r11 = r8.f18268D
            r11.mo26895a()
        L_0x0172:
            boolean r11 = r0.f18307c
            r8.f18287o = r11
            boolean r11 = r8.mo26859h()
            r8.f18288p = r11
            if (r4 == 0) goto L_0x0186
            flyme.support.v7.widget.StaggeredGridLayoutManager$a r11 = r8.f18268D
            r11.mo26895a()
            r8.m20177a((flyme.support.p093v7.widget.RecyclerView.C3277n) r9, (flyme.support.p093v7.widget.RecyclerView.C3283r) r10, (boolean) r3)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.StaggeredGridLayoutManager.m20177a(flyme.support.v7.widget.RecyclerView$n, flyme.support.v7.widget.RecyclerView$r, boolean):void");
    }

    /* renamed from: a */
    public void mo26068a(RecyclerView.C3283r rVar) {
        super.mo26068a(rVar);
        this.f18278f = -1;
        this.f18279g = Integer.MIN_VALUE;
        this.f18265A = null;
        this.f18268D.mo26895a();
    }

    /* renamed from: N */
    private void m20170N() {
        if (this.f18275c.mo27222h() != 1073741824) {
            int x = mo26658x();
            float f = 0.0f;
            for (int i = 0; i < x; i++) {
                View i2 = mo26641i(i);
                float e = (float) this.f18275c.mo27218e(i2);
                if (e >= f) {
                    if (((C3308b) i2.getLayoutParams()).mo26900a()) {
                        e = (e * 1.0f) / ((float) this.f18281i);
                    }
                    f = Math.max(f, e);
                }
            }
            int i3 = this.f18283k;
            int round = Math.round(f * ((float) this.f18281i));
            if (this.f18275c.mo27222h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f18275c.mo27219f());
            }
            mo26847a(round);
            if (this.f18283k != i3) {
                for (int i4 = 0; i4 < x; i4++) {
                    View i5 = mo26641i(i4);
                    C3308b bVar = (C3308b) i5.getLayoutParams();
                    if (!bVar.f18313b) {
                        if (!mo26859h() || this.f18282j != 1) {
                            int i6 = bVar.f18312a.f18318e * this.f18283k;
                            int i7 = bVar.f18312a.f18318e * i3;
                            if (this.f18282j == 1) {
                                i5.offsetLeftAndRight(i6 - i7);
                            } else {
                                i5.offsetTopAndBottom(i6 - i7);
                            }
                        } else {
                            i5.offsetLeftAndRight(((-((this.f18281i - 1) - bVar.f18312a.f18318e)) * this.f18283k) - ((-((this.f18281i - 1) - bVar.f18312a.f18318e)) * i3));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m20179a(C3307a aVar) {
        if (this.f18265A.f18297c > 0) {
            if (this.f18265A.f18297c == this.f18281i) {
                for (int i = 0; i < this.f18281i; i++) {
                    this.f18273a[i].mo26918e();
                    int i2 = this.f18265A.f18298d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f18265A.f18303i) {
                            i2 += this.f18274b.mo27215d();
                        } else {
                            i2 += this.f18274b.mo27213c();
                        }
                    }
                    this.f18273a[i].mo26915c(i2);
                }
            } else {
                this.f18265A.mo26887a();
                this.f18265A.f18295a = this.f18265A.f18296b;
            }
        }
        this.f18288p = this.f18265A.f18304j;
        mo26851a(this.f18265A.f18302h);
        m20169M();
        if (this.f18265A.f18295a != -1) {
            this.f18278f = this.f18265A.f18295a;
            aVar.f18307c = this.f18265A.f18303i;
        } else {
            aVar.f18307c = this.f18277e;
        }
        if (this.f18265A.f18299e > 1) {
            this.f18280h.f18289a = this.f18265A.f18300f;
            this.f18280h.f18290b = this.f18265A.f18301g;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26850a(RecyclerView.C3283r rVar, C3307a aVar) {
        if (!mo26853b(rVar, aVar) && !m20191c(rVar, aVar)) {
            aVar.mo26898b();
            aVar.f18305a = 0;
        }
    }

    /* renamed from: c */
    private boolean m20191c(RecyclerView.C3283r rVar, C3307a aVar) {
        int i;
        if (this.f18287o) {
            i = m20205u(rVar.mo26749f());
        } else {
            i = m20204t(rVar.mo26749f());
        }
        aVar.f18305a = i;
        aVar.f18306b = Integer.MIN_VALUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo26853b(RecyclerView.C3283r rVar, C3307a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (rVar.mo26744a() || this.f18278f == -1) {
            return false;
        }
        if (this.f18278f < 0 || this.f18278f >= rVar.mo26749f()) {
            this.f18278f = -1;
            this.f18279g = Integer.MIN_VALUE;
            return false;
        }
        if (this.f18265A == null || this.f18265A.f18295a == -1 || this.f18265A.f18297c < 1) {
            View c = mo26080c(this.f18278f);
            if (c != null) {
                if (this.f18277e) {
                    i = mo26864m();
                } else {
                    i = mo26865o();
                }
                aVar.f18305a = i;
                if (this.f18279g != Integer.MIN_VALUE) {
                    if (aVar.f18307c) {
                        aVar.f18306b = (this.f18274b.mo27215d() - this.f18279g) - this.f18274b.mo27212b(c);
                    } else {
                        aVar.f18306b = (this.f18274b.mo27213c() + this.f18279g) - this.f18274b.mo27208a(c);
                    }
                    return true;
                } else if (this.f18274b.mo27218e(c) > this.f18274b.mo27219f()) {
                    if (aVar.f18307c) {
                        i2 = this.f18274b.mo27215d();
                    } else {
                        i2 = this.f18274b.mo27213c();
                    }
                    aVar.f18306b = i2;
                    return true;
                } else {
                    int a = this.f18274b.mo27208a(c) - this.f18274b.mo27213c();
                    if (a < 0) {
                        aVar.f18306b = -a;
                        return true;
                    }
                    int d = this.f18274b.mo27215d() - this.f18274b.mo27212b(c);
                    if (d < 0) {
                        aVar.f18306b = d;
                        return true;
                    }
                    aVar.f18306b = Integer.MIN_VALUE;
                }
            } else {
                aVar.f18305a = this.f18278f;
                if (this.f18279g == Integer.MIN_VALUE) {
                    if (m20203s(aVar.f18305a) == 1) {
                        z = true;
                    }
                    aVar.f18307c = z;
                    aVar.mo26898b();
                } else {
                    aVar.mo26896a(this.f18279g);
                }
                aVar.f18308d = true;
            }
        } else {
            aVar.f18306b = Integer.MIN_VALUE;
            aVar.f18305a = this.f18278f;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26847a(int i) {
        this.f18283k = i / this.f18281i;
        this.f18266B = View.MeasureSpec.makeMeasureSpec(i, this.f18275c.mo27222h());
    }

    /* renamed from: e */
    public boolean mo26087e() {
        return this.f18265A == null;
    }

    /* renamed from: a */
    public int[] mo26852a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f18281i];
        } else if (iArr.length < this.f18281i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f18281i + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f18281i; i++) {
            iArr[i] = this.f18273a[i].mo26924k();
        }
        return iArr;
    }

    /* renamed from: c */
    public int mo26079c(RecyclerView.C3283r rVar) {
        return m20183b(rVar);
    }

    /* renamed from: b */
    private int m20183b(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        return ScrollbarHelper.m20792a(rVar, this.f18274b, mo26855c(!this.f18270F), mo26858d(!this.f18270F), this, this.f18270F, this.f18277e);
    }

    /* renamed from: d */
    public int mo26083d(RecyclerView.C3283r rVar) {
        return m20183b(rVar);
    }

    /* renamed from: e */
    public int mo26085e(RecyclerView.C3283r rVar) {
        return m20193i(rVar);
    }

    /* renamed from: i */
    private int m20193i(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        return ScrollbarHelper.m20791a(rVar, this.f18274b, mo26855c(!this.f18270F), mo26858d(!this.f18270F), this, this.f18270F);
    }

    /* renamed from: f */
    public int mo26089f(RecyclerView.C3283r rVar) {
        return m20193i(rVar);
    }

    /* renamed from: g */
    public int mo26091g(RecyclerView.C3283r rVar) {
        return m20194j(rVar);
    }

    /* renamed from: j */
    private int m20194j(RecyclerView.C3283r rVar) {
        if (mo26658x() == 0) {
            return 0;
        }
        return ScrollbarHelper.m20793b(rVar, this.f18274b, mo26855c(!this.f18270F), mo26858d(!this.f18270F), this, this.f18270F);
    }

    /* renamed from: h */
    public int mo26094h(RecyclerView.C3283r rVar) {
        return m20194j(rVar);
    }

    /* renamed from: a */
    private void m20175a(View view, C3308b bVar, boolean z) {
        if (bVar.f18313b) {
            if (this.f18282j == 1) {
                m20173a(view, this.f18266B, m19787a(mo26558B(), mo26660z(), 0, bVar.height, true), z);
            } else {
                m20173a(view, m19787a(mo26557A(), mo26659y(), 0, bVar.width, true), this.f18266B, z);
            }
        } else if (this.f18282j == 1) {
            m20173a(view, m19787a(this.f18283k, mo26659y(), 0, bVar.width, false), m19787a(mo26558B(), mo26660z(), 0, bVar.height, true), z);
        } else {
            m20173a(view, m19787a(mo26557A(), mo26659y(), 0, bVar.width, true), m19787a(this.f18283k, mo26660z(), 0, bVar.height, false), z);
        }
    }

    /* renamed from: a */
    private void m20173a(View view, int i, int i2, boolean z) {
        boolean z2;
        mo26611b(view, this.f18267C);
        C3308b bVar = (C3308b) view.getLayoutParams();
        int b = m20182b(i, bVar.leftMargin + this.f18267C.left, bVar.rightMargin + this.f18267C.right);
        int b2 = m20182b(i2, bVar.topMargin + this.f18267C.top, bVar.bottomMargin + this.f18267C.bottom);
        if (z) {
            z2 = mo26596a(view, b, b2, (RecyclerView.C3270h) bVar);
        } else {
            z2 = mo26617b(view, b, b2, (RecyclerView.C3270h) bVar);
        }
        if (z2) {
            view.measure(b, b2);
        }
    }

    /* renamed from: b */
    private int m20182b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    /* renamed from: a */
    public void mo26064a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f18265A = (SavedState) parcelable;
            mo26651q();
        }
    }

    /* renamed from: f */
    public Parcelable mo26090f() {
        int i;
        int i2;
        if (this.f18265A != null) {
            return new SavedState(this.f18265A);
        }
        SavedState savedState = new SavedState();
        savedState.f18302h = this.f18276d;
        savedState.f18303i = this.f18287o;
        savedState.f18304j = this.f18288p;
        if (this.f18280h == null || this.f18280h.f18289a == null) {
            savedState.f18299e = 0;
        } else {
            savedState.f18300f = this.f18280h.f18289a;
            savedState.f18299e = savedState.f18300f.length;
            savedState.f18301g = this.f18280h.f18290b;
        }
        if (mo26658x() > 0) {
            if (this.f18287o) {
                i = mo26864m();
            } else {
                i = mo26865o();
            }
            savedState.f18295a = i;
            savedState.f18296b = mo26861j();
            savedState.f18297c = this.f18281i;
            savedState.f18298d = new int[this.f18281i];
            for (int i3 = 0; i3 < this.f18281i; i3++) {
                if (this.f18287o) {
                    i2 = this.f18273a[i3].mo26910b(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i2 -= this.f18274b.mo27215d();
                    }
                } else {
                    i2 = this.f18273a[i3].mo26902a(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i2 -= this.f18274b.mo27213c();
                    }
                }
                savedState.f18298d[i3] = i2;
            }
        } else {
            savedState.f18295a = -1;
            savedState.f18296b = -1;
            savedState.f18297c = 0;
        }
        return savedState;
    }

    /* renamed from: a */
    public void mo26587a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C3308b)) {
            super.mo26580a(view, accessibilityNodeInfoCompat);
            return;
        }
        C3308b bVar = (C3308b) layoutParams;
        if (this.f18282j == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.mo26901b(), bVar.f18313b ? this.f18281i : 1, -1, -1, bVar.f18313b, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, bVar.mo26901b(), bVar.f18313b ? this.f18281i : 1, bVar.f18313b, false));
        }
    }

    /* renamed from: a */
    public void mo26065a(AccessibilityEvent accessibilityEvent) {
        super.mo26065a(accessibilityEvent);
        if (mo26658x() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View c = mo26855c(false);
            View d = mo26858d(false);
            if (c != null && d != null) {
                int d2 = mo26623d(c);
                int d3 = mo26623d(d);
                if (d2 < d3) {
                    asRecord.setFromIndex(d2);
                    asRecord.setToIndex(d3);
                    return;
                }
                asRecord.setFromIndex(d3);
                asRecord.setToIndex(d2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo26861j() {
        View view;
        if (this.f18277e) {
            view = mo26858d(true);
        } else {
            view = mo26855c(true);
        }
        if (view == null) {
            return -1;
        }
        return mo26623d(view);
    }

    /* renamed from: a */
    public int mo26569a(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f18282j == 0) {
            return this.f18281i;
        }
        return super.mo26569a(nVar, rVar);
    }

    /* renamed from: b */
    public int mo26608b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (this.f18282j == 1) {
            return this.f18281i;
        }
        return super.mo26608b(nVar, rVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo26855c(boolean z) {
        int c = this.f18274b.mo27213c();
        int d = this.f18274b.mo27215d();
        int x = mo26658x();
        View view = null;
        for (int i = 0; i < x; i++) {
            View i2 = mo26641i(i);
            int a = this.f18274b.mo27208a(i2);
            if (this.f18274b.mo27212b(i2) > c && a < d) {
                if (a >= c || !z) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public View mo26858d(boolean z) {
        int c = this.f18274b.mo27213c();
        int d = this.f18274b.mo27215d();
        View view = null;
        for (int x = mo26658x() - 1; x >= 0; x--) {
            View i = mo26641i(x);
            int a = this.f18274b.mo27208a(i);
            int b = this.f18274b.mo27212b(i);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return i;
                }
                if (view == null) {
                    view = i;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    private void m20188b(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, boolean z) {
        int d;
        int p = m20198p(Integer.MIN_VALUE);
        if (p != Integer.MIN_VALUE && (d = this.f18274b.mo27215d() - p) > 0) {
            int i = d - (-mo26854c(-d, nVar, rVar));
            if (z && i > 0) {
                this.f18274b.mo27210a(i);
            }
        }
    }

    /* renamed from: c */
    private void m20190c(RecyclerView.C3277n nVar, RecyclerView.C3283r rVar, boolean z) {
        int c;
        int o = m20197o(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (o != Integer.MAX_VALUE && (c = o - this.f18274b.mo27213c()) > 0) {
            int c2 = c - mo26854c(c, nVar, rVar);
            if (z && c2 > 0) {
                this.f18274b.mo27210a(-c2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20186b(int r5, flyme.support.p093v7.widget.RecyclerView.C3283r r6) {
        /*
            r4 = this;
            flyme.support.v7.widget.m r0 = r4.f18284l
            r1 = 0
            r0.f18538b = r1
            flyme.support.v7.widget.m r0 = r4.f18284l
            r0.f18539c = r5
            boolean r0 = r4.mo26655u()
            r2 = 1
            if (r0 == 0) goto L_0x0030
            int r6 = r6.mo26746c()
            r0 = -1
            if (r6 == r0) goto L_0x0030
            boolean r0 = r4.f18277e
            if (r6 >= r5) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r0 != r5) goto L_0x0029
            flyme.support.v7.widget.p r5 = r4.f18274b
            int r5 = r5.mo27219f()
            r6 = r5
            r5 = 0
            goto L_0x0032
        L_0x0029:
            flyme.support.v7.widget.p r5 = r4.f18274b
            int r5 = r5.mo27219f()
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6 = 0
        L_0x0032:
            boolean r0 = r4.mo26654t()
            if (r0 == 0) goto L_0x004f
            flyme.support.v7.widget.m r0 = r4.f18284l
            flyme.support.v7.widget.p r3 = r4.f18274b
            int r3 = r3.mo27213c()
            int r3 = r3 - r5
            r0.f18542f = r3
            flyme.support.v7.widget.m r5 = r4.f18284l
            flyme.support.v7.widget.p r0 = r4.f18274b
            int r0 = r0.mo27215d()
            int r0 = r0 + r6
            r5.f18543g = r0
            goto L_0x005f
        L_0x004f:
            flyme.support.v7.widget.m r0 = r4.f18284l
            flyme.support.v7.widget.p r3 = r4.f18274b
            int r3 = r3.mo27217e()
            int r3 = r3 + r6
            r0.f18543g = r3
            flyme.support.v7.widget.m r6 = r4.f18284l
            int r5 = -r5
            r6.f18542f = r5
        L_0x005f:
            flyme.support.v7.widget.m r5 = r4.f18284l
            r5.f18544h = r1
            flyme.support.v7.widget.m r5 = r4.f18284l
            r5.f18537a = r2
            flyme.support.v7.widget.m r5 = r4.f18284l
            flyme.support.v7.widget.p r6 = r4.f18274b
            int r6 = r6.mo27222h()
            if (r6 != 0) goto L_0x007a
            flyme.support.v7.widget.p r6 = r4.f18274b
            int r6 = r6.mo27217e()
            if (r6 != 0) goto L_0x007a
            r1 = 1
        L_0x007a:
            r5.f18545i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.StaggeredGridLayoutManager.m20186b(int, flyme.support.v7.widget.RecyclerView$r):void");
    }

    /* renamed from: b */
    private void m20184b(int i) {
        this.f18284l.f18541e = i;
        LayoutState mVar = this.f18284l;
        int i2 = 1;
        if (this.f18277e != (i == -1)) {
            i2 = -1;
        }
        mVar.f18540d = i2;
    }

    /* renamed from: j */
    public void mo26643j(int i) {
        super.mo26643j(i);
        for (int i2 = 0; i2 < this.f18281i; i2++) {
            this.f18273a[i2].mo26917d(i);
        }
    }

    /* renamed from: k */
    public void mo26645k(int i) {
        super.mo26645k(i);
        for (int i2 = 0; i2 < this.f18281i; i2++) {
            this.f18273a[i2].mo26917d(i);
        }
    }

    /* renamed from: b */
    public void mo26614b(RecyclerView recyclerView, int i, int i2) {
        m20189c(i, i2, 2);
    }

    /* renamed from: a */
    public void mo26592a(RecyclerView recyclerView, int i, int i2) {
        m20189c(i, i2, 1);
    }

    /* renamed from: a */
    public void mo26591a(RecyclerView recyclerView) {
        this.f18280h.mo26869a();
        mo26651q();
    }

    /* renamed from: a */
    public void mo26593a(RecyclerView recyclerView, int i, int i2, int i3) {
        m20189c(i, i2, 8);
    }

    /* renamed from: a */
    public void mo26594a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m20189c(i, i2, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20189c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.f18277e
            if (r0 == 0) goto L_0x0009
            int r0 = r5.mo26864m()
            goto L_0x000d
        L_0x0009:
            int r0 = r5.mo26865o()
        L_0x000d:
            r1 = 8
            if (r8 != r1) goto L_0x001b
            if (r6 >= r7) goto L_0x0016
            int r2 = r7 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L_0x001f
        L_0x001b:
            int r2 = r6 + r7
        L_0x001d:
            r3 = r2
            r2 = r6
        L_0x001f:
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r5.f18280h
            r4.mo26873b(r2)
            if (r8 == r1) goto L_0x0036
            switch(r8) {
                case 1: goto L_0x0030;
                case 2: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0041
        L_0x002a:
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f18280h
            r8.mo26870a((int) r6, (int) r7)
            goto L_0x0041
        L_0x0030:
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f18280h
            r8.mo26874b(r6, r7)
            goto L_0x0041
        L_0x0036:
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f18280h
            r1 = 1
            r8.mo26870a((int) r6, (int) r1)
            flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r6 = r5.f18280h
            r6.mo26874b(r7, r1)
        L_0x0041:
            if (r3 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r6 = r5.f18277e
            if (r6 == 0) goto L_0x004d
            int r6 = r5.mo26865o()
            goto L_0x0051
        L_0x004d:
            int r6 = r5.mo26864m()
        L_0x0051:
            if (r2 > r6) goto L_0x0056
            r5.mo26651q()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.StaggeredGridLayoutManager.m20189c(int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* renamed from: a */
    private int m20171a(RecyclerView.C3277n nVar, LayoutState mVar, RecyclerView.C3283r rVar) {
        int i;
        int c;
        int i2;
        C3309c cVar;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean l;
        int i9;
        int i10;
        int i11;
        RecyclerView.C3277n nVar2 = nVar;
        LayoutState mVar2 = mVar;
        ? r9 = 0;
        this.f18285m.set(0, this.f18281i, true);
        if (this.f18284l.f18545i) {
            i = mVar2.f18541e == 1 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : Integer.MIN_VALUE;
        } else {
            if (mVar2.f18541e == 1) {
                i11 = mVar2.f18543g + mVar2.f18538b;
            } else {
                i11 = mVar2.f18542f - mVar2.f18538b;
            }
            i = i11;
        }
        m20185b(mVar2.f18541e, i);
        if (this.f18277e) {
            c = this.f18274b.mo27215d();
        } else {
            c = this.f18274b.mo27213c();
        }
        int i12 = c;
        boolean z = false;
        while (mVar.mo27196a(rVar) && (this.f18284l.f18545i || !this.f18285m.isEmpty())) {
            View a = mVar2.mo27195a(nVar2);
            C3308b bVar = (C3308b) a.getLayoutParams();
            int f = bVar.mo26670f();
            int c2 = this.f18280h.mo26875c(f);
            boolean z2 = c2 == -1;
            if (z2) {
                cVar = bVar.f18313b ? this.f18273a[r9] : m20172a(mVar2);
                this.f18280h.mo26871a(f, cVar);
            } else {
                cVar = this.f18273a[c2];
            }
            C3309c cVar2 = cVar;
            bVar.f18312a = cVar2;
            if (mVar2.f18541e == 1) {
                mo26609b(a);
            } else {
                mo26610b(a, (int) r9);
            }
            m20175a(a, bVar, (boolean) r9);
            if (mVar2.f18541e == 1) {
                if (bVar.f18313b) {
                    i10 = m20198p(i12);
                } else {
                    i10 = cVar2.mo26910b(i12);
                }
                int e = this.f18274b.mo27218e(a) + i10;
                if (z2 && bVar.f18313b) {
                    LazySpanLookup.FullSpanItem f2 = m20192f(i10);
                    f2.f18292b = -1;
                    f2.f18291a = f;
                    this.f18280h.mo26872a(f2);
                }
                i3 = e;
                i4 = i10;
            } else {
                if (bVar.f18313b) {
                    i9 = m20197o(i12);
                } else {
                    i9 = cVar2.mo26902a(i12);
                }
                i4 = i9 - this.f18274b.mo27218e(a);
                if (z2 && bVar.f18313b) {
                    LazySpanLookup.FullSpanItem m = m20195m(i9);
                    m.f18292b = 1;
                    m.f18291a = f;
                    this.f18280h.mo26872a(m);
                }
                i3 = i9;
            }
            if (bVar.f18313b && mVar2.f18540d == -1) {
                if (z2) {
                    this.f18269E = true;
                } else {
                    if (mVar2.f18541e == 1) {
                        l = mo26862k();
                    } else {
                        l = mo26863l();
                    }
                    if (!l) {
                        LazySpanLookup.FullSpanItem f3 = this.f18280h.mo26878f(f);
                        if (f3 != null) {
                            f3.f18294d = true;
                        }
                        this.f18269E = true;
                    }
                }
            }
            m20174a(a, bVar, mVar2);
            if (!mo26859h() || this.f18282j != 1) {
                if (bVar.f18313b) {
                    i7 = this.f18275c.mo27213c();
                } else {
                    i7 = (cVar2.f18318e * this.f18283k) + this.f18275c.mo27213c();
                }
                i6 = i7;
                i5 = this.f18275c.mo27218e(a) + i7;
            } else {
                if (bVar.f18313b) {
                    i8 = this.f18275c.mo27215d();
                } else {
                    i8 = this.f18275c.mo27215d() - (((this.f18281i - 1) - cVar2.f18318e) * this.f18283k);
                }
                i5 = i8;
                i6 = i8 - this.f18275c.mo27218e(a);
            }
            if (this.f18282j == 1) {
                mo26577a(a, i6, i4, i5, i3);
            } else {
                mo26577a(a, i4, i6, i3, i5);
            }
            if (bVar.f18313b) {
                m20185b(this.f18284l.f18541e, i);
            } else {
                m20180a(cVar2, this.f18284l.f18541e, i);
            }
            m20178a(nVar2, this.f18284l);
            if (this.f18284l.f18544h && a.hasFocusable()) {
                if (bVar.f18313b) {
                    this.f18285m.clear();
                } else {
                    this.f18285m.set(cVar2.f18318e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            m20178a(nVar2, this.f18284l);
        }
        if (this.f18284l.f18541e == -1) {
            i2 = this.f18274b.mo27213c() - m20197o(this.f18274b.mo27213c());
        } else {
            i2 = m20198p(this.f18274b.mo27215d()) - this.f18274b.mo27215d();
        }
        if (i2 > 0) {
            return Math.min(mVar2.f18538b, i2);
        }
        return 0;
    }

    /* renamed from: f */
    private LazySpanLookup.FullSpanItem m20192f(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f18293c = new int[this.f18281i];
        for (int i2 = 0; i2 < this.f18281i; i2++) {
            fullSpanItem.f18293c[i2] = i - this.f18273a[i2].mo26910b(i);
        }
        return fullSpanItem;
    }

    /* renamed from: m */
    private LazySpanLookup.FullSpanItem m20195m(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f18293c = new int[this.f18281i];
        for (int i2 = 0; i2 < this.f18281i; i2++) {
            fullSpanItem.f18293c[i2] = this.f18273a[i2].mo26902a(i) - i;
        }
        return fullSpanItem;
    }

    /* renamed from: a */
    private void m20174a(View view, C3308b bVar, LayoutState mVar) {
        if (mVar.f18541e == 1) {
            if (bVar.f18313b) {
                m20199p(view);
            } else {
                bVar.f18312a.mo26912b(view);
            }
        } else if (bVar.f18313b) {
            m20201q(view);
        } else {
            bVar.f18312a.mo26907a(view);
        }
    }

    /* renamed from: a */
    private void m20178a(RecyclerView.C3277n nVar, LayoutState mVar) {
        int i;
        int i2;
        if (mVar.f18537a && !mVar.f18545i) {
            if (mVar.f18538b == 0) {
                if (mVar.f18541e == -1) {
                    m20187b(nVar, mVar.f18543g);
                } else {
                    m20176a(nVar, mVar.f18542f);
                }
            } else if (mVar.f18541e == -1) {
                int n = mVar.f18542f - m20196n(mVar.f18542f);
                if (n < 0) {
                    i2 = mVar.f18543g;
                } else {
                    i2 = mVar.f18543g - Math.min(n, mVar.f18538b);
                }
                m20187b(nVar, i2);
            } else {
                int q = m20200q(mVar.f18543g) - mVar.f18543g;
                if (q < 0) {
                    i = mVar.f18542f;
                } else {
                    i = Math.min(q, mVar.f18538b) + mVar.f18542f;
                }
                m20176a(nVar, i);
            }
        }
    }

    /* renamed from: p */
    private void m20199p(View view) {
        for (int i = this.f18281i - 1; i >= 0; i--) {
            this.f18273a[i].mo26912b(view);
        }
    }

    /* renamed from: q */
    private void m20201q(View view) {
        for (int i = this.f18281i - 1; i >= 0; i--) {
            this.f18273a[i].mo26907a(view);
        }
    }

    /* renamed from: b */
    private void m20185b(int i, int i2) {
        for (int i3 = 0; i3 < this.f18281i; i3++) {
            if (!this.f18273a[i3].f18314a.isEmpty()) {
                m20180a(this.f18273a[i3], i, i2);
            }
        }
    }

    /* renamed from: a */
    private void m20180a(C3309c cVar, int i, int i2) {
        int i3 = cVar.mo26922i();
        if (i == -1) {
            if (cVar.mo26909b() + i3 <= i2) {
                this.f18285m.set(cVar.f18318e, false);
            }
        } else if (cVar.mo26916d() - i3 >= i2) {
            this.f18285m.set(cVar.f18318e, false);
        }
    }

    /* renamed from: n */
    private int m20196n(int i) {
        int a = this.f18273a[0].mo26902a(i);
        for (int i2 = 1; i2 < this.f18281i; i2++) {
            int a2 = this.f18273a[i2].mo26902a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: o */
    private int m20197o(int i) {
        int a = this.f18273a[0].mo26902a(i);
        for (int i2 = 1; i2 < this.f18281i; i2++) {
            int a2 = this.f18273a[i2].mo26902a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public boolean mo26862k() {
        int b = this.f18273a[0].mo26910b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f18281i; i++) {
            if (this.f18273a[i].mo26910b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo26863l() {
        int a = this.f18273a[0].mo26902a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f18281i; i++) {
            if (this.f18273a[i].mo26902a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    private int m20198p(int i) {
        int b = this.f18273a[0].mo26910b(i);
        for (int i2 = 1; i2 < this.f18281i; i2++) {
            int b2 = this.f18273a[i2].mo26910b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: q */
    private int m20200q(int i) {
        int b = this.f18273a[0].mo26910b(i);
        for (int i2 = 1; i2 < this.f18281i; i2++) {
            int b2 = this.f18273a[i2].mo26910b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: a */
    private void m20176a(RecyclerView.C3277n nVar, int i) {
        while (mo26658x() > 0) {
            View i2 = mo26641i(0);
            if (this.f18274b.mo27212b(i2) <= i && this.f18274b.mo27214c(i2) <= i) {
                C3308b bVar = (C3308b) i2.getLayoutParams();
                if (bVar.f18313b) {
                    int i3 = 0;
                    while (i3 < this.f18281i) {
                        if (this.f18273a[i3].f18314a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f18281i; i4++) {
                        this.f18273a[i4].mo26921h();
                    }
                } else if (bVar.f18312a.f18314a.size() != 1) {
                    bVar.f18312a.mo26921h();
                } else {
                    return;
                }
                mo26581a(i2, nVar);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m20187b(RecyclerView.C3277n nVar, int i) {
        int x = mo26658x() - 1;
        while (x >= 0) {
            View i2 = mo26641i(x);
            if (this.f18274b.mo27208a(i2) >= i && this.f18274b.mo27216d(i2) >= i) {
                C3308b bVar = (C3308b) i2.getLayoutParams();
                if (bVar.f18313b) {
                    int i3 = 0;
                    while (i3 < this.f18281i) {
                        if (this.f18273a[i3].f18314a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f18281i; i4++) {
                        this.f18273a[i4].mo26920g();
                    }
                } else if (bVar.f18312a.f18314a.size() != 1) {
                    bVar.f18312a.mo26920g();
                } else {
                    return;
                }
                mo26581a(i2, nVar);
                x--;
            } else {
                return;
            }
        }
    }

    /* renamed from: r */
    private boolean m20202r(int i) {
        if (this.f18282j == 0) {
            if ((i == -1) != this.f18277e) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f18277e) == mo26859h()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private C3309c m20172a(LayoutState mVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m20202r(mVar.f18541e)) {
            i2 = this.f18281i - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f18281i;
            i = 1;
        }
        C3309c cVar = null;
        if (mVar.f18541e == 1) {
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int c = this.f18274b.mo27213c();
            while (i2 != i3) {
                C3309c cVar2 = this.f18273a[i2];
                int b = cVar2.mo26910b(c);
                if (b < i4) {
                    cVar = cVar2;
                    i4 = b;
                }
                i2 += i;
            }
            return cVar;
        }
        int i5 = Integer.MIN_VALUE;
        int d = this.f18274b.mo27215d();
        while (i2 != i3) {
            C3309c cVar3 = this.f18273a[i2];
            int a = cVar3.mo26902a(d);
            if (a > i5) {
                cVar = cVar3;
                i5 = a;
            }
            i2 += i;
        }
        return cVar;
    }

    /* renamed from: g */
    public boolean mo26092g() {
        return this.f18282j == 1;
    }

    /* renamed from: a */
    public boolean mo22258a() {
        return this.f18282j == 0;
    }

    /* renamed from: a */
    public int mo26057a(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26854c(i, nVar, rVar);
    }

    /* renamed from: b */
    public int mo26073b(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        return mo26854c(i, nVar, rVar);
    }

    /* renamed from: s */
    private int m20203s(int i) {
        if (mo26658x() != 0) {
            if ((i < mo26865o()) != this.f18277e) {
                return -1;
            }
            return 1;
        } else if (this.f18277e) {
            return 1;
        } else {
            return -1;
        }
    }

    /* renamed from: d */
    public PointF mo26084d(int i) {
        int s = m20203s(i);
        PointF pointF = new PointF();
        if (s == 0) {
            return null;
        }
        if (this.f18282j == 0) {
            pointF.x = (float) s;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) s;
        }
        return pointF;
    }

    /* renamed from: a */
    public void mo20065a(RecyclerView recyclerView, RecyclerView.C3283r rVar, int i) {
        LinearSmoothScroller nVar = new LinearSmoothScroller(recyclerView.getContext());
        nVar.mo26730d(i);
        mo26590a((RecyclerView.C3280q) nVar);
    }

    /* renamed from: e */
    public void mo26086e(int i) {
        if (!(this.f18265A == null || this.f18265A.f18295a == i)) {
            this.f18265A.mo26888b();
        }
        this.f18278f = i;
        this.f18279g = Integer.MIN_VALUE;
        mo26651q();
    }

    /* renamed from: a */
    public void mo26848a(int i, int i2) {
        if (this.f18265A != null) {
            this.f18265A.mo26888b();
        }
        this.f18278f = i;
        this.f18279g = i2;
        mo26651q();
    }

    /* renamed from: a */
    public void mo26062a(int i, int i2, RecyclerView.C3283r rVar, RecyclerView.C3266g.C3269a aVar) {
        int i3;
        if (this.f18282j != 0) {
            i = i2;
        }
        if (mo26658x() != 0 && i != 0) {
            mo26849a(i, rVar);
            if (this.f18271G == null || this.f18271G.length < this.f18281i) {
                this.f18271G = new int[this.f18281i];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.f18281i; i5++) {
                if (this.f18284l.f18540d == -1) {
                    i3 = this.f18284l.f18542f - this.f18273a[i5].mo26902a(this.f18284l.f18542f);
                } else {
                    i3 = this.f18273a[i5].mo26910b(this.f18284l.f18543g) - this.f18284l.f18543g;
                }
                if (i3 >= 0) {
                    this.f18271G[i4] = i3;
                    i4++;
                }
            }
            Arrays.sort(this.f18271G, 0, i4);
            for (int i6 = 0; i6 < i4 && this.f18284l.mo27196a(rVar); i6++) {
                aVar.mo26666b(this.f18284l.f18539c, this.f18271G[i6]);
                this.f18284l.f18539c += this.f18284l.f18540d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26849a(int i, RecyclerView.C3283r rVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = mo26864m();
            i2 = 1;
        } else {
            i3 = mo26865o();
            i2 = -1;
        }
        this.f18284l.f18537a = true;
        m20186b(i3, rVar);
        m20184b(i2);
        this.f18284l.f18539c = i3 + this.f18284l.f18540d;
        this.f18284l.f18538b = Math.abs(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo26854c(int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        if (mo26658x() == 0 || i == 0) {
            return 0;
        }
        mo26849a(i, rVar);
        int a = m20171a(nVar, this.f18284l, rVar);
        if (this.f18284l.f18538b >= a) {
            i = i < 0 ? -a : a;
        }
        this.f18274b.mo27210a(-i);
        this.f18287o = this.f18277e;
        this.f18284l.f18538b = 0;
        m20178a(nVar, this.f18284l);
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo26864m() {
        int x = mo26658x();
        if (x == 0) {
            return 0;
        }
        return mo26623d(mo26641i(x - 1));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public int mo26865o() {
        if (mo26658x() == 0) {
            return 0;
        }
        return mo26623d(mo26641i(0));
    }

    /* renamed from: t */
    private int m20204t(int i) {
        int x = mo26658x();
        for (int i2 = 0; i2 < x; i2++) {
            int d = mo26623d(mo26641i(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    /* renamed from: u */
    private int m20205u(int i) {
        for (int x = mo26658x() - 1; x >= 0; x--) {
            int d = mo26623d(mo26641i(x));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public RecyclerView.C3270h mo26075b() {
        if (this.f18282j == 0) {
            return new C3308b(-2, -1);
        }
        return new C3308b(-1, -2);
    }

    /* renamed from: a */
    public RecyclerView.C3270h mo26570a(Context context, AttributeSet attributeSet) {
        return new C3308b(context, attributeSet);
    }

    /* renamed from: a */
    public RecyclerView.C3270h mo26571a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C3308b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C3308b(layoutParams);
    }

    /* renamed from: a */
    public boolean mo26599a(RecyclerView.C3270h hVar) {
        return hVar instanceof C3308b;
    }

    /* renamed from: p */
    public int mo26866p() {
        return this.f18282j;
    }

    @Nullable
    /* renamed from: a */
    public View mo26060a(View view, int i, RecyclerView.C3277n nVar, RecyclerView.C3283r rVar) {
        View e;
        int i2;
        int i3;
        int i4;
        int i5;
        View a;
        if (mo26658x() == 0 || (e = mo26628e(view)) == null) {
            return null;
        }
        m20169M();
        int v = m20206v(i);
        if (v == Integer.MIN_VALUE) {
            return null;
        }
        C3308b bVar = (C3308b) e.getLayoutParams();
        boolean z = bVar.f18313b;
        C3309c cVar = bVar.f18312a;
        if (v == 1) {
            i2 = mo26864m();
        } else {
            i2 = mo26865o();
        }
        m20186b(i2, rVar);
        m20184b(v);
        this.f18284l.f18539c = this.f18284l.f18540d + i2;
        this.f18284l.f18538b = (int) (((float) this.f18274b.mo27219f()) * 0.33333334f);
        this.f18284l.f18544h = true;
        this.f18284l.f18537a = false;
        m20171a(nVar, this.f18284l, rVar);
        this.f18287o = this.f18277e;
        if (!z && (a = cVar.mo26905a(i2, v)) != null && a != e) {
            return a;
        }
        if (m20202r(v)) {
            for (int i6 = this.f18281i - 1; i6 >= 0; i6--) {
                View a2 = this.f18273a[i6].mo26905a(i2, v);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f18281i; i7++) {
                View a3 = this.f18273a[i7].mo26905a(i2, v);
                if (a3 != null && a3 != e) {
                    return a3;
                }
            }
        }
        boolean z2 = (this.f18276d ^ true) == (v == -1);
        if (!z) {
            if (z2) {
                i5 = cVar.mo26923j();
            } else {
                i5 = cVar.mo26925l();
            }
            View c = mo26080c(i5);
            if (!(c == null || c == e)) {
                return c;
            }
        }
        if (m20202r(v)) {
            for (int i8 = this.f18281i - 1; i8 >= 0; i8--) {
                if (i8 != cVar.f18318e) {
                    if (z2) {
                        i4 = this.f18273a[i8].mo26923j();
                    } else {
                        i4 = this.f18273a[i8].mo26925l();
                    }
                    View c2 = mo26080c(i4);
                    if (!(c2 == null || c2 == e)) {
                        return c2;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.f18281i; i9++) {
                if (z2) {
                    i3 = this.f18273a[i9].mo26923j();
                } else {
                    i3 = this.f18273a[i9].mo26925l();
                }
                View c3 = mo26080c(i3);
                if (c3 != null && c3 != e) {
                    return c3;
                }
            }
        }
        return null;
    }

    /* renamed from: v */
    private int m20206v(int i) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        switch (i) {
                            case 1:
                                return (this.f18282j != 1 && mo26859h()) ? 1 : -1;
                            case 2:
                                return (this.f18282j != 1 && mo26859h()) ? -1 : 1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    } else if (this.f18282j == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f18282j == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f18282j == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f18282j == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$b */
    public static class C3308b extends RecyclerView.C3270h {

        /* renamed from: a */
        C3309c f18312a;

        /* renamed from: b */
        boolean f18313b;

        public C3308b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3308b(int i, int i2) {
            super(i, i2);
        }

        public C3308b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C3308b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public void mo26899a(boolean z) {
            this.f18313b = z;
        }

        /* renamed from: a */
        public boolean mo26900a() {
            return this.f18313b;
        }

        /* renamed from: b */
        public final int mo26901b() {
            if (this.f18312a == null) {
                return -1;
            }
            return this.f18312a.f18318e;
        }
    }

    /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$c */
    class C3309c {

        /* renamed from: a */
        ArrayList<View> f18314a;

        /* renamed from: b */
        int f18315b;

        /* renamed from: c */
        int f18316c;

        /* renamed from: d */
        int f18317d;

        /* renamed from: e */
        final int f18318e;

        /* renamed from: f */
        final /* synthetic */ StaggeredGridLayoutManager f18319f;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo26902a(int i) {
            if (this.f18315b != Integer.MIN_VALUE) {
                return this.f18315b;
            }
            if (this.f18314a.size() == 0) {
                return i;
            }
            mo26906a();
            return this.f18315b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26906a() {
            LazySpanLookup.FullSpanItem f;
            View view = this.f18314a.get(0);
            C3308b c = mo26913c(view);
            this.f18315b = this.f18319f.f18274b.mo27208a(view);
            if (c.f18313b && (f = this.f18319f.f18280h.mo26878f(c.mo26670f())) != null && f.f18292b == -1) {
                this.f18315b -= f.mo26879a(this.f18318e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo26909b() {
            if (this.f18315b != Integer.MIN_VALUE) {
                return this.f18315b;
            }
            mo26906a();
            return this.f18315b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo26910b(int i) {
            if (this.f18316c != Integer.MIN_VALUE) {
                return this.f18316c;
            }
            if (this.f18314a.size() == 0) {
                return i;
            }
            mo26914c();
            return this.f18316c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26914c() {
            LazySpanLookup.FullSpanItem f;
            View view = this.f18314a.get(this.f18314a.size() - 1);
            C3308b c = mo26913c(view);
            this.f18316c = this.f18319f.f18274b.mo27212b(view);
            if (c.f18313b && (f = this.f18319f.f18280h.mo26878f(c.mo26670f())) != null && f.f18292b == 1) {
                this.f18316c += f.mo26879a(this.f18318e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo26916d() {
            if (this.f18316c != Integer.MIN_VALUE) {
                return this.f18316c;
            }
            mo26914c();
            return this.f18316c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26907a(View view) {
            C3308b c = mo26913c(view);
            c.f18312a = this;
            this.f18314a.add(0, view);
            this.f18315b = Integer.MIN_VALUE;
            if (this.f18314a.size() == 1) {
                this.f18316c = Integer.MIN_VALUE;
            }
            if (c.mo26668d() || c.mo26669e()) {
                this.f18317d += this.f18319f.f18274b.mo27218e(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26912b(View view) {
            C3308b c = mo26913c(view);
            c.f18312a = this;
            this.f18314a.add(view);
            this.f18316c = Integer.MIN_VALUE;
            if (this.f18314a.size() == 1) {
                this.f18315b = Integer.MIN_VALUE;
            }
            if (c.mo26668d() || c.mo26669e()) {
                this.f18317d += this.f18319f.f18274b.mo27218e(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26908a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = mo26910b(Integer.MIN_VALUE);
            } else {
                i2 = mo26902a(Integer.MIN_VALUE);
            }
            mo26918e();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < this.f18319f.f18274b.mo27215d()) {
                    return;
                }
                if (z || i2 <= this.f18319f.f18274b.mo27213c()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f18316c = i2;
                    this.f18315b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo26918e() {
            this.f18314a.clear();
            mo26919f();
            this.f18317d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo26919f() {
            this.f18315b = Integer.MIN_VALUE;
            this.f18316c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26915c(int i) {
            this.f18315b = i;
            this.f18316c = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo26920g() {
            int size = this.f18314a.size();
            View remove = this.f18314a.remove(size - 1);
            C3308b c = mo26913c(remove);
            c.f18312a = null;
            if (c.mo26668d() || c.mo26669e()) {
                this.f18317d -= this.f18319f.f18274b.mo27218e(remove);
            }
            if (size == 1) {
                this.f18315b = Integer.MIN_VALUE;
            }
            this.f18316c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo26921h() {
            View remove = this.f18314a.remove(0);
            C3308b c = mo26913c(remove);
            c.f18312a = null;
            if (this.f18314a.size() == 0) {
                this.f18316c = Integer.MIN_VALUE;
            }
            if (c.mo26668d() || c.mo26669e()) {
                this.f18317d -= this.f18319f.f18274b.mo27218e(remove);
            }
            this.f18315b = Integer.MIN_VALUE;
        }

        /* renamed from: i */
        public int mo26922i() {
            return this.f18317d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C3308b mo26913c(View view) {
            return (C3308b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26917d(int i) {
            if (this.f18315b != Integer.MIN_VALUE) {
                this.f18315b += i;
            }
            if (this.f18316c != Integer.MIN_VALUE) {
                this.f18316c += i;
            }
        }

        /* renamed from: j */
        public int mo26923j() {
            if (this.f18319f.f18276d) {
                return mo26911b(this.f18314a.size() - 1, -1, true);
            }
            return mo26911b(0, this.f18314a.size(), true);
        }

        /* renamed from: k */
        public int mo26924k() {
            if (this.f18319f.f18276d) {
                return mo26903a(0, this.f18314a.size(), false);
            }
            return mo26903a(this.f18314a.size() - 1, -1, false);
        }

        /* renamed from: l */
        public int mo26925l() {
            if (this.f18319f.f18276d) {
                return mo26911b(0, this.f18314a.size(), true);
            }
            return mo26911b(this.f18314a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo26904a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = this.f18319f.f18274b.mo27213c();
            int d = this.f18319f.f18274b.mo27215d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f18314a.get(i);
                int a = this.f18319f.f18274b.mo27208a(view);
                int b = this.f18319f.f18274b.mo27212b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a < d : a <= d;
                if (!z3 ? b > c : b >= c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return this.f18319f.mo26623d(view);
                        }
                        if (a < c || b > d) {
                            return this.f18319f.mo26623d(view);
                        }
                    } else if (a >= c && b <= d) {
                        return this.f18319f.mo26623d(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo26903a(int i, int i2, boolean z) {
            return mo26904a(i, i2, z, true, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo26911b(int i, int i2, boolean z) {
            return mo26904a(i, i2, false, false, z);
        }

        /* renamed from: a */
        public View mo26905a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f18314a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f18314a.get(size);
                    if ((this.f18319f.f18276d && this.f18319f.mo26623d(view2) >= i) || ((!this.f18319f.f18276d && this.f18319f.mo26623d(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f18314a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f18314a.get(i3);
                    if ((this.f18319f.f18276d && this.f18319f.mo26623d(view3) <= i) || ((!this.f18319f.f18276d && this.f18319f.mo26623d(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup */
    static class LazySpanLookup {

        /* renamed from: a */
        int[] f18289a;

        /* renamed from: b */
        List<FullSpanItem> f18290b;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo26867a(int i) {
            if (this.f18290b != null) {
                for (int size = this.f18290b.size() - 1; size >= 0; size--) {
                    if (this.f18290b.get(size).f18291a >= i) {
                        this.f18290b.remove(size);
                    }
                }
            }
            return mo26873b(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo26873b(int i) {
            if (this.f18289a == null || i >= this.f18289a.length) {
                return -1;
            }
            int g = m20268g(i);
            if (g == -1) {
                Arrays.fill(this.f18289a, i, this.f18289a.length, -1);
                return this.f18289a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f18289a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo26875c(int i) {
            if (this.f18289a == null || i >= this.f18289a.length) {
                return -1;
            }
            return this.f18289a[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26871a(int i, C3309c cVar) {
            mo26877e(i);
            this.f18289a[i] = cVar.f18318e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo26876d(int i) {
            int length = this.f18289a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo26877e(int i) {
            if (this.f18289a == null) {
                this.f18289a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f18289a, -1);
            } else if (i >= this.f18289a.length) {
                int[] iArr = this.f18289a;
                this.f18289a = new int[mo26876d(i)];
                System.arraycopy(iArr, 0, this.f18289a, 0, iArr.length);
                Arrays.fill(this.f18289a, iArr.length, this.f18289a.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26869a() {
            if (this.f18289a != null) {
                Arrays.fill(this.f18289a, -1);
            }
            this.f18290b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26870a(int i, int i2) {
            if (this.f18289a != null && i < this.f18289a.length) {
                int i3 = i + i2;
                mo26877e(i3);
                System.arraycopy(this.f18289a, i3, this.f18289a, i, (this.f18289a.length - i) - i2);
                Arrays.fill(this.f18289a, this.f18289a.length - i2, this.f18289a.length, -1);
                m20266c(i, i2);
            }
        }

        /* renamed from: c */
        private void m20266c(int i, int i2) {
            if (this.f18290b != null) {
                int i3 = i + i2;
                for (int size = this.f18290b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f18290b.get(size);
                    if (fullSpanItem.f18291a >= i) {
                        if (fullSpanItem.f18291a < i3) {
                            this.f18290b.remove(size);
                        } else {
                            fullSpanItem.f18291a -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26874b(int i, int i2) {
            if (this.f18289a != null && i < this.f18289a.length) {
                int i3 = i + i2;
                mo26877e(i3);
                System.arraycopy(this.f18289a, i, this.f18289a, i3, (this.f18289a.length - i) - i2);
                Arrays.fill(this.f18289a, i, i3, -1);
                m20267d(i, i2);
            }
        }

        /* renamed from: d */
        private void m20267d(int i, int i2) {
            if (this.f18290b != null) {
                for (int size = this.f18290b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f18290b.get(size);
                    if (fullSpanItem.f18291a >= i) {
                        fullSpanItem.f18291a += i2;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m20268g(int i) {
            if (this.f18290b == null) {
                return -1;
            }
            FullSpanItem f = mo26878f(i);
            if (f != null) {
                this.f18290b.remove(f);
            }
            int size = this.f18290b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f18290b.get(i2).f18291a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f18290b.remove(i2);
            return this.f18290b.get(i2).f18291a;
        }

        /* renamed from: a */
        public void mo26872a(FullSpanItem fullSpanItem) {
            if (this.f18290b == null) {
                this.f18290b = new ArrayList();
            }
            int size = this.f18290b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f18290b.get(i);
                if (fullSpanItem2.f18291a == fullSpanItem.f18291a) {
                    this.f18290b.remove(i);
                }
                if (fullSpanItem2.f18291a >= fullSpanItem.f18291a) {
                    this.f18290b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f18290b.add(fullSpanItem);
        }

        /* renamed from: f */
        public FullSpanItem mo26878f(int i) {
            if (this.f18290b == null) {
                return null;
            }
            for (int size = this.f18290b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f18290b.get(size);
                if (fullSpanItem.f18291a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: a */
        public FullSpanItem mo26868a(int i, int i2, int i3, boolean z) {
            if (this.f18290b == null) {
                return null;
            }
            int size = this.f18290b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f18290b.get(i4);
                if (fullSpanItem.f18291a >= i2) {
                    return null;
                }
                if (fullSpanItem.f18291a >= i && (i3 == 0 || fullSpanItem.f18292b == i3 || (z && fullSpanItem.f18294d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem */
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a */
            int f18291a;

            /* renamed from: b */
            int f18292b;

            /* renamed from: c */
            int[] f18293c;

            /* renamed from: d */
            boolean f18294d;

            public int describeContents() {
                return 0;
            }

            public FullSpanItem(Parcel parcel) {
                this.f18291a = parcel.readInt();
                this.f18292b = parcel.readInt();
                this.f18294d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f18293c = new int[readInt];
                    parcel.readIntArray(this.f18293c);
                }
            }

            public FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public int mo26879a(int i) {
                if (this.f18293c == null) {
                    return 0;
                }
                return this.f18293c[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f18291a);
                parcel.writeInt(this.f18292b);
                parcel.writeInt(this.f18294d ? 1 : 0);
                if (this.f18293c == null || this.f18293c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f18293c.length);
                parcel.writeIntArray(this.f18293c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f18291a + ", mGapDir=" + this.f18292b + ", mHasUnwantedGapAfter=" + this.f18294d + ", mGapPerSpan=" + Arrays.toString(this.f18293c) + '}';
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$SavedState */
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
        int f18295a;

        /* renamed from: b */
        int f18296b;

        /* renamed from: c */
        int f18297c;

        /* renamed from: d */
        int[] f18298d;

        /* renamed from: e */
        int f18299e;

        /* renamed from: f */
        int[] f18300f;

        /* renamed from: g */
        List<LazySpanLookup.FullSpanItem> f18301g;

        /* renamed from: h */
        boolean f18302h;

        /* renamed from: i */
        boolean f18303i;

        /* renamed from: j */
        boolean f18304j;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f18295a = parcel.readInt();
            this.f18296b = parcel.readInt();
            this.f18297c = parcel.readInt();
            if (this.f18297c > 0) {
                this.f18298d = new int[this.f18297c];
                parcel.readIntArray(this.f18298d);
            }
            this.f18299e = parcel.readInt();
            if (this.f18299e > 0) {
                this.f18300f = new int[this.f18299e];
                parcel.readIntArray(this.f18300f);
            }
            boolean z = false;
            this.f18302h = parcel.readInt() == 1;
            this.f18303i = parcel.readInt() == 1;
            this.f18304j = parcel.readInt() == 1 ? true : z;
            this.f18301g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f18297c = savedState.f18297c;
            this.f18295a = savedState.f18295a;
            this.f18296b = savedState.f18296b;
            this.f18298d = savedState.f18298d;
            this.f18299e = savedState.f18299e;
            this.f18300f = savedState.f18300f;
            this.f18302h = savedState.f18302h;
            this.f18303i = savedState.f18303i;
            this.f18304j = savedState.f18304j;
            this.f18301g = savedState.f18301g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26887a() {
            this.f18298d = null;
            this.f18297c = 0;
            this.f18299e = 0;
            this.f18300f = null;
            this.f18301g = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26888b() {
            this.f18298d = null;
            this.f18297c = 0;
            this.f18295a = -1;
            this.f18296b = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f18295a);
            parcel.writeInt(this.f18296b);
            parcel.writeInt(this.f18297c);
            if (this.f18297c > 0) {
                parcel.writeIntArray(this.f18298d);
            }
            parcel.writeInt(this.f18299e);
            if (this.f18299e > 0) {
                parcel.writeIntArray(this.f18300f);
            }
            parcel.writeInt(this.f18302h ? 1 : 0);
            parcel.writeInt(this.f18303i ? 1 : 0);
            parcel.writeInt(this.f18304j ? 1 : 0);
            parcel.writeList(this.f18301g);
        }
    }

    /* renamed from: flyme.support.v7.widget.StaggeredGridLayoutManager$a */
    class C3307a {

        /* renamed from: a */
        int f18305a;

        /* renamed from: b */
        int f18306b;

        /* renamed from: c */
        boolean f18307c;

        /* renamed from: d */
        boolean f18308d;

        /* renamed from: e */
        boolean f18309e;

        /* renamed from: f */
        int[] f18310f;

        /* renamed from: g */
        final /* synthetic */ StaggeredGridLayoutManager f18311g;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26895a() {
            this.f18305a = -1;
            this.f18306b = Integer.MIN_VALUE;
            this.f18307c = false;
            this.f18308d = false;
            this.f18309e = false;
            if (this.f18310f != null) {
                Arrays.fill(this.f18310f, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26897a(C3309c[] cVarArr) {
            int length = cVarArr.length;
            if (this.f18310f == null || this.f18310f.length < length) {
                this.f18310f = new int[this.f18311g.f18273a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f18310f[i] = cVarArr[i].mo26902a(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26898b() {
            int i;
            if (this.f18307c) {
                i = this.f18311g.f18274b.mo27215d();
            } else {
                i = this.f18311g.f18274b.mo27213c();
            }
            this.f18306b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26896a(int i) {
            if (this.f18307c) {
                this.f18306b = this.f18311g.f18274b.mo27215d() - i;
            } else {
                this.f18306b = this.f18311g.f18274b.mo27213c() + i;
            }
        }
    }
}
