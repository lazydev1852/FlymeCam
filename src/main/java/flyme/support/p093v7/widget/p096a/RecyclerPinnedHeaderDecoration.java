package flyme.support.p093v7.widget.p096a;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import flyme.support.p093v7.widget.p096a.p097a.DimensionCalculator;
import flyme.support.p093v7.widget.p096a.p097a.OrientationProvider;
import flyme.support.p093v7.widget.p096a.p097a.PinnedHeaderProvider;
import flyme.support.p093v7.widget.p096a.p097a.PinnedHeaderRenderer;

/* renamed from: flyme.support.v7.widget.a.c */
public class RecyclerPinnedHeaderDecoration extends RecyclerView.C3265f {

    /* renamed from: a */
    private final RecyclerPinnedHeaderAdapter f18425a;

    /* renamed from: b */
    private final SparseArray<Rect> f18426b;

    /* renamed from: c */
    private final PinnedHeaderProvider f18427c;

    /* renamed from: d */
    private final OrientationProvider f18428d;

    /* renamed from: e */
    private final PinnedHeaderPositionCalculator f18429e;

    /* renamed from: f */
    private final PinnedHeaderRenderer f18430f;

    /* renamed from: g */
    private final DimensionCalculator f18431g;

    /* renamed from: h */
    private final Rect f18432h;

    /* renamed from: i */
    private MzRecyclerView f18433i;

    /* renamed from: j */
    private long f18434j;

    /* renamed from: k */
    private long f18435k;

    /* renamed from: l */
    private int f18436l;

    /* renamed from: m */
    private int f18437m;

    /* renamed from: n */
    private View f18438n;

    /* renamed from: o */
    private C3322a f18439o;

    /* renamed from: flyme.support.v7.widget.a.c$a */
    /* compiled from: RecyclerPinnedHeaderDecoration */
    public interface C3322a {
        /* renamed from: a */
        void mo27060a(RecyclerView recyclerView, View view, int i, long j, View view2, int i2, long j2);
    }

    /* renamed from: a */
    public void mo23920a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C3283r rVar) {
        super.mo23920a(rect, view, recyclerView, rVar);
        m20419a(recyclerView);
        MzRecyclerView mzRecyclerView = (MzRecyclerView) recyclerView;
        int i = mzRecyclerView.mo26424i(view) - mzRecyclerView.getHeaderViewsCount();
        if (i != -1 && this.f18429e.mo27047a(i, this.f18428d.mo27051b(mzRecyclerView))) {
            m20418a(rect, mo27057a(mzRecyclerView, i), this.f18428d.mo27050a(mzRecyclerView));
        }
    }

    /* renamed from: a */
    private void m20418a(Rect rect, View view, int i) {
        this.f18431g.mo27049a(this.f18432h, view);
        if (i == 1) {
            rect.top = view.getHeight() + this.f18432h.top + this.f18432h.bottom;
        } else {
            rect.left = view.getWidth() + this.f18432h.left + this.f18432h.right;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c0  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo26552b(android.graphics.Canvas r21, flyme.support.p093v7.widget.RecyclerView r22, flyme.support.p093v7.widget.RecyclerView.C3283r r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            super.mo26552b(r21, r22, r23)
            r11 = r1
            flyme.support.v7.widget.MzRecyclerView r11 = (flyme.support.p093v7.widget.MzRecyclerView) r11
            r0.f18433i = r11
            r0.m20419a(r1)
            int r12 = r11.getChildCount()
            if (r12 <= 0) goto L_0x00e5
            flyme.support.v7.widget.a.b r1 = r0.f18425a
            int r1 = r1.mo27054a()
            if (r1 > 0) goto L_0x001f
            goto L_0x00e5
        L_0x001f:
            r1 = 0
            r13 = 0
        L_0x0021:
            if (r13 >= r12) goto L_0x00e4
            android.view.View r14 = r11.getChildAt(r13)
            int r1 = r11.mo26424i((android.view.View) r14)
            flyme.support.v7.widget.MzRecyclerView r2 = r0.f18433i
            int r2 = r2.getHeaderViewsCount()
            int r15 = r1 - r2
            r1 = -1
            if (r15 != r1) goto L_0x003a
        L_0x0036:
            r2 = r21
            goto L_0x00e0
        L_0x003a:
            flyme.support.v7.widget.a.a r1 = r0.f18429e
            flyme.support.v7.widget.a.a.b r2 = r0.f18428d
            int r2 = r2.mo27050a(r11)
            boolean r16 = r1.mo27048a(r14, r2, r15)
            if (r16 != 0) goto L_0x0056
            flyme.support.v7.widget.a.a r1 = r0.f18429e
            flyme.support.v7.widget.a.a.b r2 = r0.f18428d
            boolean r2 = r2.mo27051b(r11)
            boolean r1 = r1.mo27047a((int) r15, (boolean) r2)
            if (r1 == 0) goto L_0x0036
        L_0x0056:
            flyme.support.v7.widget.a.a.c r1 = r0.f18427c
            android.view.View r9 = r1.mo27052a(r11, r15)
            flyme.support.v7.widget.a.c$a r1 = r0.f18439o
            if (r1 == 0) goto L_0x00b4
            flyme.support.v7.widget.LinearLayoutManager r1 = r20.mo27059b()
            int r1 = r1.mo26101o()
            r0.f18436l = r1
            flyme.support.v7.widget.a.b r1 = r20.mo27058a()
            int r2 = r0.f18436l
            long r1 = r1.mo27055a(r2)
            r0.f18434j = r1
            flyme.support.v7.widget.a.b r1 = r20.mo27058a()
            int r2 = r0.f18437m
            long r1 = r1.mo27055a(r2)
            r0.f18435k = r1
            flyme.support.v7.widget.a.a.c r1 = r0.f18427c
            int r2 = r0.f18437m
            android.view.View r1 = r1.mo27052a(r11, r2)
            r0.f18438n = r1
            long r1 = r0.f18434j
            long r3 = r0.f18435k
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00b4
            flyme.support.v7.widget.a.c$a r1 = r0.f18439o
            int r4 = r0.f18436l
            long r5 = r0.f18434j
            android.view.View r7 = r0.f18438n
            int r8 = r0.f18437m
            long r2 = r0.f18435k
            r17 = r2
            r2 = r11
            r3 = r9
            r19 = r9
            r9 = r17
            r1.mo27060a(r2, r3, r4, r5, r7, r8, r9)
            long r1 = r0.f18434j
            r0.f18435k = r1
            int r1 = r0.f18436l
            r0.f18437m = r1
            goto L_0x00b6
        L_0x00b4:
            r19 = r9
        L_0x00b6:
            android.util.SparseArray<android.graphics.Rect> r1 = r0.f18426b
            java.lang.Object r1 = r1.get(r15)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            if (r1 != 0) goto L_0x00ca
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            android.util.SparseArray<android.graphics.Rect> r2 = r0.f18426b
            r2.put(r15, r1)
        L_0x00ca:
            r7 = r1
            flyme.support.v7.widget.a.a r1 = r0.f18429e
            r2 = r7
            r3 = r11
            r4 = r19
            r5 = r14
            r6 = r16
            r1.mo27046a((android.graphics.Rect) r2, (flyme.support.p093v7.widget.MzRecyclerView) r3, (android.view.View) r4, (android.view.View) r5, (boolean) r6)
            flyme.support.v7.widget.a.a.d r1 = r0.f18430f
            r2 = r21
            r3 = r19
            r1.mo27053a(r11, r2, r3, r7)
        L_0x00e0:
            int r13 = r13 + 1
            goto L_0x0021
        L_0x00e4:
            return
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.p096a.RecyclerPinnedHeaderDecoration.mo26552b(android.graphics.Canvas, flyme.support.v7.widget.RecyclerView, flyme.support.v7.widget.RecyclerView$r):void");
    }

    /* renamed from: a */
    public int mo27056a(int i, int i2) {
        int i3;
        if (this.f18433i == null || !(this.f18433i.getLayoutManager() instanceof LinearLayoutManager)) {
            i3 = 0;
        } else {
            i3 = ((LinearLayoutManager) this.f18433i.getLayoutManager()).mo26101o();
            if (i3 < 0) {
                return -1;
            }
        }
        while (i3 < this.f18426b.size()) {
            if (this.f18426b.get(this.f18426b.keyAt(i3)).contains(i, i2)) {
                return this.f18426b.keyAt(i3);
            }
            i3++;
        }
        return -1;
    }

    /* renamed from: a */
    private void m20419a(RecyclerView recyclerView) {
        if (!(recyclerView instanceof MzRecyclerView)) {
            String str = RecyclerPinnedHeaderDecoration.class.getSimpleName() + " only surport MzRecyclerView.";
            Log.e("lijinqian", "RecyclerPinnedHeaderDecoration IllegalStateException : " + str);
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public View mo27057a(MzRecyclerView mzRecyclerView, int i) {
        return this.f18427c.mo27052a(mzRecyclerView, i);
    }

    /* renamed from: a */
    public RecyclerPinnedHeaderAdapter mo27058a() {
        if (this.f18433i.getAdapter() instanceof RecyclerPinnedHeaderAdapter) {
            return (RecyclerPinnedHeaderAdapter) this.f18433i.getAdapter();
        }
        throw new IllegalStateException("MzRecyclerView with " + RecyclerPinnedHeaderDecoration.class.getSimpleName() + " requires a " + RecyclerPinnedHeaderAdapter.class.getSimpleName());
    }

    /* renamed from: b */
    public LinearLayoutManager mo27059b() {
        if (this.f18433i.getLayoutManager() instanceof LinearLayoutManager) {
            return (LinearLayoutManager) this.f18433i.getLayoutManager();
        }
        throw new IllegalStateException("MzRecyclerView with " + RecyclerPinnedHeaderDecoration.class.getSimpleName() + " requires a " + LinearLayoutManager.class.getSimpleName());
    }
}
