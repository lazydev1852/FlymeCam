package flyme.support.p093v7.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.u */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: h */
    boolean f18587h = true;

    /* renamed from: a */
    public abstract boolean mo26030a(RecyclerView.C3286u uVar);

    /* renamed from: a */
    public abstract boolean mo26031a(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo26032a(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2, int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract boolean mo26036b(RecyclerView.C3286u uVar);

    /* renamed from: c */
    public void mo27238c(RecyclerView.C3286u uVar, boolean z) {
    }

    /* renamed from: d */
    public void mo27239d(RecyclerView.C3286u uVar, boolean z) {
    }

    /* renamed from: o */
    public void mo27246o(RecyclerView.C3286u uVar) {
    }

    /* renamed from: p */
    public void mo27247p(RecyclerView.C3286u uVar) {
    }

    /* renamed from: q */
    public void mo27248q(RecyclerView.C3286u uVar) {
    }

    /* renamed from: r */
    public void mo27249r(RecyclerView.C3286u uVar) {
    }

    /* renamed from: s */
    public void mo27250s(RecyclerView.C3286u uVar) {
    }

    /* renamed from: t */
    public void mo27251t(RecyclerView.C3286u uVar) {
    }

    /* renamed from: h */
    public boolean mo26527h(@NonNull RecyclerView.C3286u uVar) {
        return !this.f18587h || uVar.mo26782p();
    }

    /* renamed from: a */
    public boolean mo26517a(@NonNull RecyclerView.C3286u uVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar, @Nullable RecyclerView.ItemAnimator.C3258c cVar2) {
        int i = cVar.f18029a;
        int i2 = cVar.f18030b;
        View view = uVar.f18121j;
        int left = cVar2 == null ? view.getLeft() : cVar2.f18029a;
        int top = cVar2 == null ? view.getTop() : cVar2.f18030b;
        if (uVar.mo26785s() || (i == left && i2 == top)) {
            return mo26030a(uVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo26031a(uVar, i, i2, left, top);
    }

    /* renamed from: b */
    public boolean mo26519b(@NonNull RecyclerView.C3286u uVar, @Nullable RecyclerView.ItemAnimator.C3258c cVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar2) {
        if (cVar == null || (cVar.f18029a == cVar2.f18029a && cVar.f18030b == cVar2.f18030b)) {
            return mo26036b(uVar);
        }
        return mo26031a(uVar, cVar.f18029a, cVar.f18030b, cVar2.f18029a, cVar2.f18030b);
    }

    /* renamed from: c */
    public boolean mo26520c(@NonNull RecyclerView.C3286u uVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar2) {
        if (cVar.f18029a == cVar2.f18029a && cVar.f18030b == cVar2.f18030b) {
            mo27241j(uVar);
            return false;
        }
        return mo26031a(uVar, cVar.f18029a, cVar.f18030b, cVar2.f18029a, cVar2.f18030b);
    }

    /* renamed from: a */
    public boolean mo26518a(@NonNull RecyclerView.C3286u uVar, @NonNull RecyclerView.C3286u uVar2, @NonNull RecyclerView.ItemAnimator.C3258c cVar, @NonNull RecyclerView.ItemAnimator.C3258c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f18029a;
        int i4 = cVar.f18030b;
        if (uVar2.mo26771e()) {
            int i5 = cVar.f18029a;
            i = cVar.f18030b;
            i2 = i5;
        } else {
            i2 = cVar2.f18029a;
            i = cVar2.f18030b;
        }
        return mo26032a(uVar, uVar2, i3, i4, i2, i);
    }

    /* renamed from: i */
    public final void mo27240i(RecyclerView.C3286u uVar) {
        mo27247p(uVar);
        mo26523f(uVar);
    }

    /* renamed from: j */
    public final void mo27241j(RecyclerView.C3286u uVar) {
        mo27251t(uVar);
        mo26523f(uVar);
    }

    /* renamed from: k */
    public final void mo27242k(RecyclerView.C3286u uVar) {
        mo27249r(uVar);
        mo26523f(uVar);
    }

    /* renamed from: a */
    public final void mo27236a(RecyclerView.C3286u uVar, boolean z) {
        mo27239d(uVar, z);
        mo26523f(uVar);
    }

    /* renamed from: l */
    public final void mo27243l(RecyclerView.C3286u uVar) {
        mo27246o(uVar);
    }

    /* renamed from: m */
    public final void mo27244m(RecyclerView.C3286u uVar) {
        mo27250s(uVar);
    }

    /* renamed from: n */
    public final void mo27245n(RecyclerView.C3286u uVar) {
        mo27248q(uVar);
    }

    /* renamed from: b */
    public final void mo27237b(RecyclerView.C3286u uVar, boolean z) {
        mo27238c(uVar, z);
    }
}
