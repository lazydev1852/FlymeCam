package flyme.support.p093v7.widget;

import android.view.View;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.m */
public class LayoutState {

    /* renamed from: a */
    boolean f18537a;

    /* renamed from: b */
    int f18538b;

    /* renamed from: c */
    int f18539c;

    /* renamed from: d */
    int f18540d;

    /* renamed from: e */
    int f18541e;

    /* renamed from: f */
    int f18542f;

    /* renamed from: g */
    int f18543g;

    /* renamed from: h */
    boolean f18544h;

    /* renamed from: i */
    boolean f18545i;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27196a(RecyclerView.C3283r rVar) {
        return this.f18539c >= 0 && this.f18539c < rVar.mo26749f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo27195a(RecyclerView.C3277n nVar) {
        View c = nVar.mo26704c(this.f18539c);
        this.f18539c += this.f18540d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f18538b + ", mCurrentPosition=" + this.f18539c + ", mItemDirection=" + this.f18540d + ", mLayoutDirection=" + this.f18541e + ", mStartLine=" + this.f18542f + ", mEndLine=" + this.f18543g + '}';
    }
}
