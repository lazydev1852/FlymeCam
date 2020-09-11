package flyme.support.p093v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: flyme.support.v7.widget.DefaultItemAnimator */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: i */
    private static TimeInterpolator f17577i;

    /* renamed from: a */
    ArrayList<ArrayList<RecyclerView.C3286u>> f17578a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<ArrayList<C3205b>> f17579b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<ArrayList<C3204a>> f17580c = new ArrayList<>();

    /* renamed from: d */
    ArrayList<RecyclerView.C3286u> f17581d = new ArrayList<>();

    /* renamed from: e */
    ArrayList<RecyclerView.C3286u> f17582e = new ArrayList<>();

    /* renamed from: f */
    ArrayList<RecyclerView.C3286u> f17583f = new ArrayList<>();

    /* renamed from: g */
    ArrayList<RecyclerView.C3286u> f17584g = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<RecyclerView.C3286u> f17585j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<RecyclerView.C3286u> f17586k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<C3205b> f17587l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<C3204a> f17588m = new ArrayList<>();

    /* renamed from: flyme.support.v7.widget.DefaultItemAnimator$b */
    private static class C3205b {

        /* renamed from: a */
        public RecyclerView.C3286u f17619a;

        /* renamed from: b */
        public int f17620b;

        /* renamed from: c */
        public int f17621c;

        /* renamed from: d */
        public int f17622d;

        /* renamed from: e */
        public int f17623e;

        C3205b(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4) {
            this.f17619a = uVar;
            this.f17620b = i;
            this.f17621c = i2;
            this.f17622d = i3;
            this.f17623e = i4;
        }
    }

    /* renamed from: flyme.support.v7.widget.DefaultItemAnimator$a */
    private static class C3204a {

        /* renamed from: a */
        public RecyclerView.C3286u f17613a;

        /* renamed from: b */
        public RecyclerView.C3286u f17614b;

        /* renamed from: c */
        public int f17615c;

        /* renamed from: d */
        public int f17616d;

        /* renamed from: e */
        public int f17617e;

        /* renamed from: f */
        public int f17618f;

        private C3204a(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2) {
            this.f17613a = uVar;
            this.f17614b = uVar2;
        }

        C3204a(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2, int i, int i2, int i3, int i4) {
            this(uVar, uVar2);
            this.f17615c = i;
            this.f17616d = i2;
            this.f17617e = i3;
            this.f17618f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f17613a + ", newHolder=" + this.f17614b + ", fromX=" + this.f17615c + ", fromY=" + this.f17616d + ", toX=" + this.f17617e + ", toY=" + this.f17618f + '}';
        }
    }

    /* renamed from: a */
    public void mo26027a() {
        boolean z = !this.f17585j.isEmpty();
        boolean z2 = !this.f17587l.isEmpty();
        boolean z3 = !this.f17588m.isEmpty();
        boolean z4 = !this.f17586k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.C3286u> it = this.f17585j.iterator();
            while (it.hasNext()) {
                m19235u(it.next());
            }
            this.f17585j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f17587l);
                this.f17579b.add(arrayList);
                this.f17587l.clear();
                C31961 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C3205b bVar = (C3205b) it.next();
                            DefaultItemAnimator.this.mo26034b(bVar.f17619a, bVar.f17620b, bVar.f17621c, bVar.f17622d, bVar.f17623e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.f17579b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C3205b) arrayList.get(0)).f17619a.f18121j, r6, mo26524g());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f17588m);
                this.f17580c.add(arrayList2);
                this.f17588m.clear();
                C31972 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.mo26028a((C3204a) it.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.f17580c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C3204a) arrayList2.get(0)).f17613a.f18121j, r62, mo26524g());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f17586k);
                this.f17578a.add(arrayList3);
                this.f17586k.clear();
                C31983 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.mo26038c((RecyclerView.C3286u) it.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.f17578a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j = 0;
                    long g = z ? mo26524g() : 0;
                    long e = z2 ? mo26521e() : 0;
                    if (z3) {
                        j = mo26526h();
                    }
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.C3286u) arrayList3.get(0)).f18121j, r5, g + Math.max(e, j));
                    return;
                }
                r5.run();
            }
        }
    }

    /* renamed from: a */
    public boolean mo26030a(RecyclerView.C3286u uVar) {
        m19236v(uVar);
        this.f17585j.add(uVar);
        return true;
    }

    /* renamed from: u */
    private void m19235u(final RecyclerView.C3286u uVar) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(uVar.f18121j);
        this.f17583f.add(uVar);
        animate.setDuration(mo26524g()).alpha(0.0f).setListener(new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.mo27243l(uVar);
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                ViewCompat.setAlpha(view, 1.0f);
                DefaultItemAnimator.this.mo27240i(uVar);
                DefaultItemAnimator.this.f17583f.remove(uVar);
                DefaultItemAnimator.this.mo26037c();
            }
        }).start();
    }

    /* renamed from: b */
    public boolean mo26036b(RecyclerView.C3286u uVar) {
        m19236v(uVar);
        ViewCompat.setAlpha(uVar.f18121j, 0.0f);
        this.f17586k.add(uVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo26038c(final RecyclerView.C3286u uVar) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(uVar.f18121j);
        this.f17581d.add(uVar);
        animate.alpha(1.0f).setDuration(mo26522f()).setListener(new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.mo27245n(uVar);
            }

            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                DefaultItemAnimator.this.mo27242k(uVar);
                DefaultItemAnimator.this.f17581d.remove(uVar);
                DefaultItemAnimator.this.mo26037c();
            }
        }).start();
    }

    /* renamed from: a */
    public boolean mo26031a(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.f18121j;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(uVar.f18121j));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(uVar.f18121j));
        m19236v(uVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo27241j(uVar);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.setTranslationX(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.setTranslationY(view, (float) (-i6));
        }
        this.f17587l.add(new C3205b(uVar, translationX, translationY, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo26034b(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.f18121j;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.f17582e.add(uVar);
        final RecyclerView.C3286u uVar2 = uVar;
        animate.setDuration(mo26521e()).setListener(new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.mo27244m(uVar2);
            }

            public void onAnimationCancel(View view) {
                if (i5 != 0) {
                    ViewCompat.setTranslationX(view, 0.0f);
                }
                if (i6 != 0) {
                    ViewCompat.setTranslationY(view, 0.0f);
                }
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                DefaultItemAnimator.this.mo27241j(uVar2);
                DefaultItemAnimator.this.f17582e.remove(uVar2);
                DefaultItemAnimator.this.mo26037c();
            }
        }).start();
    }

    /* renamed from: a */
    public boolean mo26032a(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2, int i, int i2, int i3, int i4) {
        if (uVar == uVar2) {
            return mo26031a(uVar, i, i2, i3, i4);
        }
        float translationX = ViewCompat.getTranslationX(uVar.f18121j);
        float translationY = ViewCompat.getTranslationY(uVar.f18121j);
        float alpha = ViewCompat.getAlpha(uVar.f18121j);
        m19236v(uVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(uVar.f18121j, translationX);
        ViewCompat.setTranslationY(uVar.f18121j, translationY);
        ViewCompat.setAlpha(uVar.f18121j, alpha);
        if (uVar2 != null) {
            m19236v(uVar2);
            ViewCompat.setTranslationX(uVar2.f18121j, (float) (-i5));
            ViewCompat.setTranslationY(uVar2.f18121j, (float) (-i6));
            ViewCompat.setAlpha(uVar2.f18121j, 0.0f);
        }
        this.f17588m.add(new C3204a(uVar, uVar2, i, i2, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26028a(final C3204a aVar) {
        View view;
        RecyclerView.C3286u uVar = aVar.f17613a;
        final View view2 = null;
        if (uVar == null) {
            view = null;
        } else {
            view = uVar.f18121j;
        }
        RecyclerView.C3286u uVar2 = aVar.f17614b;
        if (uVar2 != null) {
            view2 = uVar2.f18121j;
        }
        if (view != null) {
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(mo26526h());
            this.f17584g.add(aVar.f17613a);
            duration.translationX((float) (aVar.f17617e - aVar.f17615c));
            duration.translationY((float) (aVar.f17618f - aVar.f17616d));
            duration.alpha(0.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.mo27237b(aVar.f17613a, true);
                }

                public void onAnimationEnd(View view) {
                    duration.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    DefaultItemAnimator.this.mo27236a(aVar.f17613a, true);
                    DefaultItemAnimator.this.f17584g.remove(aVar.f17613a);
                    DefaultItemAnimator.this.mo26037c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
            this.f17584g.add(aVar.f17614b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(mo26526h()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.mo27237b(aVar.f17614b, false);
                }

                public void onAnimationEnd(View view) {
                    animate.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    DefaultItemAnimator.this.mo27236a(aVar.f17614b, false);
                    DefaultItemAnimator.this.f17584g.remove(aVar.f17614b);
                    DefaultItemAnimator.this.mo26037c();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m19232a(List<C3204a> list, RecyclerView.C3286u uVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C3204a aVar = list.get(size);
            if (m19233a(aVar, uVar) && aVar.f17613a == null && aVar.f17614b == null) {
                list.remove(aVar);
            }
        }
    }

    /* renamed from: b */
    private void m19234b(C3204a aVar) {
        if (aVar.f17613a != null) {
            m19233a(aVar, aVar.f17613a);
        }
        if (aVar.f17614b != null) {
            m19233a(aVar, aVar.f17614b);
        }
    }

    /* renamed from: a */
    private boolean m19233a(C3204a aVar, RecyclerView.C3286u uVar) {
        boolean z = false;
        if (aVar.f17614b == uVar) {
            aVar.f17614b = null;
        } else if (aVar.f17613a != uVar) {
            return false;
        } else {
            aVar.f17613a = null;
            z = true;
        }
        ViewCompat.setAlpha(uVar.f18121j, 1.0f);
        ViewCompat.setTranslationX(uVar.f18121j, 0.0f);
        ViewCompat.setTranslationY(uVar.f18121j, 0.0f);
        mo27236a(uVar, z);
        return true;
    }

    /* renamed from: d */
    public void mo26040d(RecyclerView.C3286u uVar) {
        View view = uVar.f18121j;
        ViewCompat.animate(view).cancel();
        int size = this.f17587l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f17587l.get(size).f17619a == uVar) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                mo27241j(uVar);
                this.f17587l.remove(size);
            }
        }
        m19232a((List<C3204a>) this.f17588m, uVar);
        if (this.f17585j.remove(uVar)) {
            ViewCompat.setAlpha(view, 1.0f);
            mo27240i(uVar);
        }
        if (this.f17586k.remove(uVar)) {
            ViewCompat.setAlpha(view, 1.0f);
            mo27242k(uVar);
        }
        for (int size2 = this.f17580c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f17580c.get(size2);
            m19232a((List<C3204a>) arrayList, uVar);
            if (arrayList.isEmpty()) {
                this.f17580c.remove(size2);
            }
        }
        for (int size3 = this.f17579b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f17579b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C3205b) arrayList2.get(size4)).f17619a == uVar) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    mo27241j(uVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f17579b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f17578a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f17578a.get(size5);
            if (arrayList3.remove(uVar)) {
                ViewCompat.setAlpha(view, 1.0f);
                mo27242k(uVar);
                if (arrayList3.isEmpty()) {
                    this.f17578a.remove(size5);
                }
            }
        }
        this.f17583f.remove(uVar);
        this.f17581d.remove(uVar);
        this.f17584g.remove(uVar);
        this.f17582e.remove(uVar);
        mo26037c();
    }

    /* renamed from: v */
    private void m19236v(RecyclerView.C3286u uVar) {
        if (f17577i == null) {
            f17577i = new ValueAnimator().getInterpolator();
        }
        uVar.f18121j.animate().setInterpolator(f17577i);
        mo26040d(uVar);
    }

    /* renamed from: b */
    public boolean mo26035b() {
        return !this.f17586k.isEmpty() || !this.f17588m.isEmpty() || !this.f17587l.isEmpty() || !this.f17585j.isEmpty() || !this.f17582e.isEmpty() || !this.f17583f.isEmpty() || !this.f17581d.isEmpty() || !this.f17584g.isEmpty() || !this.f17579b.isEmpty() || !this.f17578a.isEmpty() || !this.f17580c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo26037c() {
        if (!mo26035b()) {
            mo26528i();
        }
    }

    /* renamed from: d */
    public void mo26039d() {
        int size = this.f17587l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C3205b bVar = this.f17587l.get(size);
            View view = bVar.f17619a.f18121j;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            mo27241j(bVar.f17619a);
            this.f17587l.remove(size);
        }
        for (int size2 = this.f17585j.size() - 1; size2 >= 0; size2--) {
            mo27240i(this.f17585j.get(size2));
            this.f17585j.remove(size2);
        }
        int size3 = this.f17586k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C3286u uVar = this.f17586k.get(size3);
            ViewCompat.setAlpha(uVar.f18121j, 1.0f);
            mo27242k(uVar);
            this.f17586k.remove(size3);
        }
        for (int size4 = this.f17588m.size() - 1; size4 >= 0; size4--) {
            m19234b(this.f17588m.get(size4));
        }
        this.f17588m.clear();
        if (mo26035b()) {
            for (int size5 = this.f17579b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f17579b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C3205b bVar2 = (C3205b) arrayList.get(size6);
                    View view2 = bVar2.f17619a.f18121j;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    mo27241j(bVar2.f17619a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f17579b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f17578a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f17578a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C3286u uVar2 = (RecyclerView.C3286u) arrayList2.get(size8);
                    ViewCompat.setAlpha(uVar2.f18121j, 1.0f);
                    mo27242k(uVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f17578a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f17580c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f17580c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m19234b((C3204a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f17580c.remove(arrayList3);
                    }
                }
            }
            mo26029a((List<RecyclerView.C3286u>) this.f17583f);
            mo26029a((List<RecyclerView.C3286u>) this.f17582e);
            mo26029a((List<RecyclerView.C3286u>) this.f17581d);
            mo26029a((List<RecyclerView.C3286u>) this.f17584g);
            mo26528i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26029a(List<RecyclerView.C3286u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).f18121j).cancel();
        }
    }

    /* renamed from: a */
    public boolean mo26033a(@NonNull RecyclerView.C3286u uVar, @NonNull List<Object> list) {
        return !list.isEmpty() || super.mo26033a(uVar, list);
    }

    /* renamed from: flyme.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter */
    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }

        VpaListenerAdapter() {
        }
    }
}
