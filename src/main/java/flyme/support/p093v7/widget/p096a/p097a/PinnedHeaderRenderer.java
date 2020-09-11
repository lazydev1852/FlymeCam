package flyme.support.p093v7.widget.p096a.p097a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import flyme.support.p093v7.widget.MzRecyclerView;

/* renamed from: flyme.support.v7.widget.a.a.d */
public class PinnedHeaderRenderer {

    /* renamed from: a */
    private final DimensionCalculator f18422a;

    /* renamed from: b */
    private final OrientationProvider f18423b;

    /* renamed from: c */
    private final Rect f18424c;

    /* renamed from: a */
    public void mo27053a(MzRecyclerView mzRecyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (mzRecyclerView.getLayoutManager().mo26654t()) {
            m20414a(this.f18424c, mzRecyclerView, view);
            canvas.clipRect(this.f18424c);
        }
        canvas.translate((float) rect.left, (float) rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m20414a(Rect rect, MzRecyclerView mzRecyclerView, View view) {
        this.f18422a.mo27049a(rect, view);
        if (this.f18423b.mo27050a(mzRecyclerView) == 1) {
            rect.set(mzRecyclerView.getPaddingLeft(), mzRecyclerView.getPaddingTop(), (mzRecyclerView.getWidth() - mzRecyclerView.getPaddingRight()) - rect.right, mzRecyclerView.getHeight() - mzRecyclerView.getPaddingBottom());
        } else {
            rect.set(mzRecyclerView.getPaddingLeft(), mzRecyclerView.getPaddingTop(), mzRecyclerView.getWidth() - mzRecyclerView.getPaddingRight(), (mzRecyclerView.getHeight() - mzRecyclerView.getPaddingBottom()) - rect.bottom);
        }
    }
}
