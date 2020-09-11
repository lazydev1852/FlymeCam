package flyme.support.p093v7.widget.p096a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import flyme.support.p093v7.widget.p096a.p097a.DimensionCalculator;
import flyme.support.p093v7.widget.p096a.p097a.OrientationProvider;
import flyme.support.p093v7.widget.p096a.p097a.PinnedHeaderProvider;

/* renamed from: flyme.support.v7.widget.a.a */
public class PinnedHeaderPositionCalculator {

    /* renamed from: a */
    private final RecyclerPinnedHeaderAdapter f18416a;

    /* renamed from: b */
    private final OrientationProvider f18417b;

    /* renamed from: c */
    private final PinnedHeaderProvider f18418c;

    /* renamed from: d */
    private final DimensionCalculator f18419d;

    /* renamed from: e */
    private final Rect f18420e;

    /* renamed from: f */
    private final Rect f18421f;

    /* renamed from: a */
    public boolean mo27048a(View view, int i, int i2) {
        int i3;
        int i4;
        this.f18419d.mo27049a(this.f18420e, view);
        if (i == 1) {
            i4 = view.getTop();
            i3 = this.f18420e.top;
        } else {
            i4 = view.getLeft();
            i3 = this.f18420e.left;
        }
        if (i4 > i3 || this.f18416a.mo27055a(i2) < 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo27047a(int i, boolean z) {
        if (m20401a(i)) {
            return false;
        }
        long a = this.f18416a.mo27055a(i);
        if (a < 0) {
            return false;
        }
        long j = -1;
        int i2 = (z ? 1 : -1) + i;
        if (!m20401a(i2)) {
            j = this.f18416a.mo27055a(i2);
        }
        if (i == (z ? this.f18416a.mo27054a() - 1 : 0) || a != j) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m20401a(int i) {
        return i < 0 || i >= this.f18416a.mo27054a();
    }

    /* renamed from: a */
    public void mo27046a(Rect rect, MzRecyclerView mzRecyclerView, View view, View view2, boolean z) {
        m20399a(rect, (RecyclerView) mzRecyclerView, view, view2, this.f18417b.mo27050a(mzRecyclerView));
        if (z && m20402a(mzRecyclerView, view)) {
            View b = m20405b(mzRecyclerView, view);
            MzRecyclerView mzRecyclerView2 = mzRecyclerView;
            m20400a(mzRecyclerView2, this.f18417b.mo27050a(mzRecyclerView), rect, view, b, this.f18418c.mo27052a(mzRecyclerView, mzRecyclerView.mo26424i(b)));
        }
    }

    /* renamed from: a */
    private void m20399a(Rect rect, RecyclerView recyclerView, View view, View view2, int i) {
        int i2;
        int i3;
        int i4;
        this.f18419d.mo27049a(this.f18420e, view);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        int i5 = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i5 = marginLayoutParams.leftMargin;
            i2 = marginLayoutParams.topMargin;
        } else {
            i2 = 0;
        }
        if (i == 1) {
            int left = (view2.getLeft() - i5) + this.f18420e.left;
            i3 = Math.max(((view2.getTop() - i2) - view.getHeight()) - this.f18420e.bottom, m20398a(recyclerView) + this.f18420e.top);
            i4 = left;
        } else {
            i3 = (view2.getTop() - i2) + this.f18420e.top;
            i4 = Math.max(((view2.getLeft() - i5) - view.getWidth()) - this.f18420e.right, m20404b(recyclerView) + this.f18420e.left);
        }
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    /* renamed from: a */
    private boolean m20402a(MzRecyclerView mzRecyclerView, View view) {
        View b = m20405b(mzRecyclerView, view);
        int i = mzRecyclerView.mo26424i(b) - mzRecyclerView.getHeaderViewsCount();
        if (i == -1) {
            return false;
        }
        boolean b2 = this.f18417b.mo27051b(mzRecyclerView);
        if (i <= 0 || !mo27047a(i, b2)) {
            return false;
        }
        View a = this.f18418c.mo27052a(mzRecyclerView, i);
        this.f18419d.mo27049a(this.f18420e, a);
        this.f18419d.mo27049a(this.f18421f, view);
        if (this.f18417b.mo27050a(mzRecyclerView) == 1) {
            if (((b.getTop() - this.f18420e.bottom) - a.getHeight()) - this.f18420e.top < mzRecyclerView.getPaddingTop() + view.getBottom() + this.f18421f.top + this.f18421f.bottom) {
                return true;
            }
            return false;
        } else if (((b.getLeft() - this.f18420e.right) - a.getWidth()) - this.f18420e.left < mzRecyclerView.getPaddingLeft() + view.getRight() + this.f18421f.left + this.f18421f.right) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private void m20400a(MzRecyclerView mzRecyclerView, int i, Rect rect, View view, View view2, View view3) {
        this.f18419d.mo27049a(this.f18420e, view3);
        this.f18419d.mo27049a(this.f18421f, view);
        if (i == 1) {
            int a = m20398a((RecyclerView) mzRecyclerView) + this.f18421f.top + this.f18421f.bottom;
            int top = ((((view2.getTop() - view3.getHeight()) - this.f18420e.bottom) - this.f18420e.top) - view.getHeight()) - a;
            if (top < a) {
                rect.top += top;
                rect.bottom += top;
                return;
            }
            return;
        }
        int b = m20404b(mzRecyclerView) + this.f18421f.left + this.f18421f.right;
        int left = ((((view2.getLeft() - view3.getWidth()) - this.f18420e.right) - this.f18420e.left) - view.getWidth()) - b;
        if (left < b) {
            rect.left += left;
            rect.right += left;
        }
    }

    /* renamed from: b */
    private View m20405b(MzRecyclerView mzRecyclerView, View view) {
        boolean b = this.f18417b.mo27051b(mzRecyclerView);
        int i = b ? -1 : 1;
        int childCount = b ? mzRecyclerView.getChildCount() - 1 : 0;
        while (childCount >= 0 && childCount <= mzRecyclerView.getChildCount() - 1) {
            View childAt = mzRecyclerView.getChildAt(childCount);
            if (!m20403a(mzRecyclerView, childAt, view, this.f18417b.mo27050a(mzRecyclerView))) {
                return childAt;
            }
            childCount += i;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m20403a(MzRecyclerView mzRecyclerView, View view, View view2, int i) {
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
        this.f18419d.mo27049a(this.f18420e, view2);
        int i2 = mzRecyclerView.mo26424i(view) - mzRecyclerView.getHeaderViewsCount();
        if (i2 == -1 || this.f18418c.mo27052a(mzRecyclerView, i2) != view2) {
            return false;
        }
        if (i == 1) {
            if (view.getTop() - hVar.topMargin <= view2.getBottom() + this.f18420e.bottom + this.f18420e.top) {
                return true;
            }
            return false;
        } else if (view.getLeft() - hVar.leftMargin <= view2.getRight() + this.f18420e.right + this.f18420e.left) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private int m20398a(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().mo26654t()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    /* renamed from: b */
    private int m20404b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().mo26654t()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }
}
