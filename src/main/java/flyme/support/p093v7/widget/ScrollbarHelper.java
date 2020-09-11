package flyme.support.p093v7.widget;

import android.view.View;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.t */
public class ScrollbarHelper {
    /* renamed from: a */
    static int m20792a(RecyclerView.C3283r rVar, OrientationHelper pVar, View view, View view2, RecyclerView.C3266g gVar, boolean z, boolean z2) {
        int i;
        if (gVar.mo26658x() == 0 || rVar.mo26749f() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(gVar.mo26623d(view), gVar.mo26623d(view2));
        int max = Math.max(gVar.mo26623d(view), gVar.mo26623d(view2));
        if (z2) {
            i = Math.max(0, (rVar.mo26749f() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(pVar.mo27212b(view2) - pVar.mo27208a(view))) / ((float) (Math.abs(gVar.mo26623d(view) - gVar.mo26623d(view2)) + 1)))) + ((float) (pVar.mo27213c() - pVar.mo27208a(view))));
    }

    /* renamed from: a */
    static int m20791a(RecyclerView.C3283r rVar, OrientationHelper pVar, View view, View view2, RecyclerView.C3266g gVar, boolean z) {
        if (gVar.mo26658x() == 0 || rVar.mo26749f() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(gVar.mo26623d(view) - gVar.mo26623d(view2)) + 1;
        }
        return Math.min(pVar.mo27219f(), pVar.mo27212b(view2) - pVar.mo27208a(view));
    }

    /* renamed from: b */
    static int m20793b(RecyclerView.C3283r rVar, OrientationHelper pVar, View view, View view2, RecyclerView.C3266g gVar, boolean z) {
        if (gVar.mo26658x() == 0 || rVar.mo26749f() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return rVar.mo26749f();
        }
        return (int) ((((float) (pVar.mo27212b(view2) - pVar.mo27208a(view))) / ((float) (Math.abs(gVar.mo26623d(view) - gVar.mo26623d(view2)) + 1))) * ((float) rVar.mo26749f()));
    }
}
