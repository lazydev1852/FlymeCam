package flyme.support.p093v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator */
public class RecyclerViewItemAnimator extends SimpleItemAnimator {

    /* renamed from: a */
    private static TimeInterpolator f18137a = null;

    /* renamed from: o */
    private static int f18138o = 260;

    /* renamed from: p */
    private static float f18139p = 0.94f;

    /* renamed from: b */
    private ArrayList<C3299d> f18140b;

    /* renamed from: c */
    private ArrayList<C3296a> f18141c;

    /* renamed from: d */
    private ArrayList<C3298c> f18142d;

    /* renamed from: e */
    private ArrayList<C3297b> f18143e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<ArrayList<C3296a>> f18144f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<ArrayList<C3298c>> f18145g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ArrayList<ArrayList<C3297b>> f18146i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<RecyclerView.C3286u> f18147j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ArrayList<RecyclerView.C3286u> f18148k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ArrayList<RecyclerView.C3286u> f18149l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<RecyclerView.C3286u> f18150m;

    /* renamed from: n */
    private RecyclerView f18151n;

    /* renamed from: q */
    private int f18152q;

    /* renamed from: r */
    private float f18153r;

    /* renamed from: s */
    private Interpolator f18154s;

    /* renamed from: t */
    private Interpolator f18155t;

    /* renamed from: u */
    private Interpolator f18156u;

    /* renamed from: a */
    public boolean mo26033a(@NonNull RecyclerView.C3286u uVar, @NonNull List<Object> list) {
        return true;
    }

    /* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator$a */
    private static class C3296a {

        /* renamed from: a */
        public RecyclerView.C3286u f18181a;

        /* renamed from: b */
        public int f18182b;

        /* renamed from: c */
        public int f18183c;

        private C3296a(RecyclerView.C3286u uVar, int i) {
            this.f18181a = uVar;
            this.f18182b = i;
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator$d */
    private static class C3299d {

        /* renamed from: a */
        public RecyclerView.C3286u f18197a;

        /* renamed from: b */
        public int f18198b;

        private C3299d(RecyclerView.C3286u uVar, int i) {
            this.f18197a = uVar;
            this.f18198b = i;
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator$c */
    private static class C3298c {

        /* renamed from: a */
        public RecyclerView.C3286u f18190a;

        /* renamed from: b */
        public int f18191b;

        /* renamed from: c */
        public int f18192c;

        /* renamed from: d */
        public int f18193d;

        /* renamed from: e */
        public int f18194e;

        /* renamed from: f */
        public int f18195f;

        /* renamed from: g */
        public int f18196g;

        private C3298c(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f18190a = uVar;
            this.f18191b = i;
            this.f18192c = i2;
            this.f18193d = i3;
            this.f18194e = i4;
            this.f18195f = i5;
            this.f18196g = i6;
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator$b */
    private static class C3297b {

        /* renamed from: a */
        public RecyclerView.C3286u f18184a;

        /* renamed from: b */
        public RecyclerView.C3286u f18185b;

        /* renamed from: c */
        public int f18186c;

        /* renamed from: d */
        public int f18187d;

        /* renamed from: e */
        public int f18188e;

        /* renamed from: f */
        public int f18189f;

        private C3297b(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2) {
            this.f18184a = uVar;
            this.f18185b = uVar2;
        }

        private C3297b(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2, int i, int i2, int i3, int i4) {
            this(uVar, uVar2);
            this.f18186c = i;
            this.f18187d = i2;
            this.f18188e = i3;
            this.f18189f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f18184a + ", newHolder=" + this.f18185b + ", fromX=" + this.f18186c + ", fromY=" + this.f18187d + ", toX=" + this.f18188e + ", toY=" + this.f18189f + '}';
        }
    }

    /* renamed from: a */
    public void mo26027a() {
        boolean z = !this.f18140b.isEmpty();
        boolean z2 = !this.f18142d.isEmpty();
        boolean z3 = !this.f18143e.isEmpty();
        boolean z4 = !this.f18141c.isEmpty();
        if (z || z2 || z4 || z3) {
            m20113b(this.f18141c);
            Iterator<C3299d> it = this.f18140b.iterator();
            while (it.hasNext()) {
                m20104a(it.next());
            }
            this.f18140b.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f18142d);
                this.f18145g.add(arrayList);
                this.f18142d.clear();
                C32881 r8 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.m20103a((C3298c) it.next());
                        }
                        arrayList.clear();
                        RecyclerViewItemAnimator.this.f18145g.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C3298c) arrayList.get(0)).f18190a.f18121j, r8, 0);
                } else {
                    r8.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f18143e);
                this.f18146i.add(arrayList2);
                this.f18143e.clear();
                C32892 r82 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.m20102a((C3297b) it.next());
                        }
                        arrayList2.clear();
                        RecyclerViewItemAnimator.this.f18146i.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C3297b) arrayList2.get(0)).f18184a.f18121j, r82, 0);
                } else {
                    r82.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f18141c);
                this.f18144f.add(arrayList3);
                this.f18141c.clear();
                C32903 r7 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.m20101a((C3296a) it.next());
                        }
                        arrayList3.clear();
                        RecyclerViewItemAnimator.this.f18144f.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(((C3296a) arrayList3.get(0)).f18181a.f18121j, r7, 0);
                } else {
                    r7.run();
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo26030a(RecyclerView.C3286u uVar) {
        int i;
        m20122u(uVar);
        View view = uVar.f18121j;
        int f = uVar.mo26772f();
        if (f == -1) {
            i = this.f18151n.getPaddingTop() - view.getTop();
        } else {
            RecyclerView.C3286u h = this.f18151n.mo26422h(f);
            i = (h == null || h.f18121j == null) ? 0 : h.f18121j.getBottom() - view.getTop();
        }
        this.f18140b.add(new C3299d(uVar, i));
        return true;
    }

    /* renamed from: a */
    private void m20104a(final C3299d dVar) {
        View view = dVar.f18197a.f18121j;
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        C32914 r2 = new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.mo27243l(dVar.f18197a);
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                view.setTag(-1912602624, (Object) null);
                ViewCompat.setAlpha(view, 1.0f);
                ViewCompat.setScaleY(view, 1.0f);
                ViewCompat.setScaleX(view, 1.0f);
                ViewCompat.setTranslationY(view, 0.0f);
                RecyclerViewItemAnimator.this.mo27240i(dVar.f18197a);
                RecyclerViewItemAnimator.this.f18149l.remove(dVar.f18197a);
                RecyclerViewItemAnimator.this.m20116c();
            }
        };
        m20100a(view, (VpaListenerAdapter) r2);
        this.f18149l.add(dVar.f18197a);
        animate.setDuration((long) this.f18152q).alpha(0.0f).scaleY(this.f18153r).scaleX(this.f18153r).translationY((float) dVar.f18198b).setInterpolator(this.f18155t).setListener(r2).start();
    }

    /* renamed from: b */
    public boolean mo26036b(RecyclerView.C3286u uVar) {
        m20122u(uVar);
        ViewCompat.setAlpha(uVar.f18121j, 0.0f);
        ViewCompat.setScaleY(uVar.f18121j, this.f18153r);
        ViewCompat.setScaleX(uVar.f18121j, this.f18153r);
        this.f18141c.add(new C3296a(uVar, uVar.mo26772f()));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20101a(final C3296a aVar) {
        View view = aVar.f18181a.f18121j;
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        C32925 r2 = new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.mo27245n(aVar.f18181a);
            }

            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
                ViewCompat.setScaleY(view, 1.0f);
                ViewCompat.setScaleX(view, 1.0f);
                ViewCompat.setTranslationY(view, 0.0f);
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                view.setTag(-1912602624, (Object) null);
                RecyclerViewItemAnimator.this.mo27242k(aVar.f18181a);
                RecyclerViewItemAnimator.this.f18147j.remove(aVar.f18181a);
                RecyclerViewItemAnimator.this.m20116c();
            }
        };
        m20100a(view, (VpaListenerAdapter) r2);
        this.f18147j.add(aVar.f18181a);
        animate.alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationY(0.0f).setDuration((long) this.f18152q).setInterpolator(this.f18154s).setListener(r2).start();
    }

    /* renamed from: a */
    public boolean mo26031a(RecyclerView.C3286u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.f18121j;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(uVar.f18121j));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(uVar.f18121j));
        m20122u(uVar);
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
        this.f18142d.add(new C3298c(uVar, uVar.mo26772f(), translationX, translationY, i3, i4, translationY + uVar.f18121j.getHeight()));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20103a(C3298c cVar) {
        View view = cVar.f18190a.f18121j;
        final int i = cVar.f18194e - cVar.f18192c;
        final int i2 = cVar.f18195f - cVar.f18193d;
        if (i != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i2 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        final C3298c cVar2 = cVar;
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = animate;
        C32936 r3 = new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.mo27244m(cVar2.f18190a);
            }

            public void onAnimationCancel(View view) {
                if (i != 0) {
                    ViewCompat.setTranslationX(view, 0.0f);
                }
                if (i2 != 0) {
                    ViewCompat.setTranslationY(view, 0.0f);
                }
            }

            public void onAnimationEnd(View view) {
                viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener) null);
                view.setTag(-1912602624, (Object) null);
                RecyclerViewItemAnimator.this.mo27241j(cVar2.f18190a);
                RecyclerViewItemAnimator.this.f18148k.remove(cVar2.f18190a);
                RecyclerViewItemAnimator.this.m20116c();
            }
        };
        m20100a(view, (VpaListenerAdapter) r3);
        this.f18148k.add(cVar.f18190a);
        animate.setDuration((long) this.f18152q).setInterpolator(this.f18156u).setListener(r3).start();
    }

    /* renamed from: a */
    public boolean mo26032a(RecyclerView.C3286u uVar, RecyclerView.C3286u uVar2, int i, int i2, int i3, int i4) {
        RecyclerView.C3286u uVar3 = uVar;
        RecyclerView.C3286u uVar4 = uVar2;
        if (uVar3 == uVar4) {
            mo27236a(uVar, true);
            return false;
        }
        float translationX = ViewCompat.getTranslationX(uVar3.f18121j);
        float translationY = ViewCompat.getTranslationY(uVar3.f18121j);
        float alpha = ViewCompat.getAlpha(uVar3.f18121j);
        m20122u(uVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(uVar3.f18121j, translationX);
        ViewCompat.setTranslationY(uVar3.f18121j, translationY);
        ViewCompat.setAlpha(uVar3.f18121j, alpha);
        if (uVar4 != null) {
            m20122u(uVar2);
            ViewCompat.setTranslationX(uVar4.f18121j, (float) (-i5));
            ViewCompat.setTranslationY(uVar4.f18121j, (float) (-i6));
            ViewCompat.setAlpha(uVar4.f18121j, 0.0f);
        }
        this.f18143e.add(new C3297b(uVar, uVar2, i, i2, i3, i4));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20102a(final C3297b bVar) {
        View view;
        RecyclerView.C3286u uVar = bVar.f18184a;
        final View view2 = null;
        if (uVar == null) {
            view = null;
        } else {
            view = uVar.f18121j;
        }
        RecyclerView.C3286u uVar2 = bVar.f18185b;
        if (uVar2 != null) {
            view2 = uVar2.f18121j;
        }
        if (view != null) {
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(mo26526h());
            this.f18150m.add(bVar.f18184a);
            duration.translationX((float) (bVar.f18188e - bVar.f18186c));
            duration.translationY((float) (bVar.f18189f - bVar.f18187d));
            duration.alpha(0.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    RecyclerViewItemAnimator.this.mo27237b(bVar.f18184a, true);
                }

                public void onAnimationEnd(View view) {
                    duration.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    RecyclerViewItemAnimator.this.mo27236a(bVar.f18184a, true);
                    RecyclerViewItemAnimator.this.f18150m.remove(bVar.f18184a);
                    RecyclerViewItemAnimator.this.m20116c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
            this.f18150m.add(bVar.f18185b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(mo26526h()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    RecyclerViewItemAnimator.this.mo27237b(bVar.f18185b, false);
                }

                public void onAnimationEnd(View view) {
                    animate.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    RecyclerViewItemAnimator.this.mo27236a(bVar.f18185b, false);
                    RecyclerViewItemAnimator.this.f18150m.remove(bVar.f18185b);
                    RecyclerViewItemAnimator.this.m20116c();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m20100a(View view, VpaListenerAdapter vpaListenerAdapter) {
        if (view.getTag(-1912602624) != null) {
            VpaListenerAdapter vpaListenerAdapter2 = (VpaListenerAdapter) view.getTag(-1912602624);
            vpaListenerAdapter2.onAnimationCancel(view);
            vpaListenerAdapter2.onAnimationEnd(view);
        }
        view.setTag(-1912602624, vpaListenerAdapter);
    }

    /* renamed from: a */
    private void m20108a(ArrayList<C3296a> arrayList) {
        int i = 0;
        while (true) {
            if (i < arrayList.size() - 1) {
                for (int i2 = 1; i2 < arrayList.size() - i; i2++) {
                    int i3 = i2 - 1;
                    if (arrayList.get(i3).f18182b - arrayList.get(i2).f18182b > 0) {
                        arrayList.set(i3, arrayList.get(i2));
                        arrayList.set(i2, arrayList.get(i3));
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m20113b(ArrayList<C3296a> arrayList) {
        int i;
        int i2;
        m20108a(arrayList);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < arrayList.size()) {
            if (i3 == 0) {
                int i6 = arrayList.get(0).f18182b;
                if (arrayList.get(0).f18182b == 0) {
                    i5 = 0;
                } else {
                    RecyclerView.C3286u h = this.f18151n.mo26422h(i6 - 1);
                    if (!(h == null || h.f18121j == null)) {
                        i5 = h.f18121j.getBottom();
                    }
                }
                arrayList.get(0).f18183c = 0;
                i = i6;
                i2 = 0;
            } else {
                i = arrayList.get(i3).f18182b;
                if (i - i4 == 1) {
                    i2 = arrayList.get(i3).f18181a.f18121j.getTop() - i5;
                    arrayList.get(i3).f18183c = i2;
                } else {
                    i5 = m20114c(this.f18151n.mo26422h(i - 1));
                    i2 = arrayList.get(i3).f18181a.f18121j.getTop() - i5;
                    arrayList.get(i3).f18183c = i2;
                }
            }
            if (i2 != 0) {
                ViewCompat.setTranslationY(arrayList.get(i3).f18181a.f18121j, (float) (-i2));
            }
            i3++;
            i4 = i;
        }
    }

    /* renamed from: c */
    private int m20114c(RecyclerView.C3286u uVar) {
        if (uVar == null) {
            return 0;
        }
        int a = m20098a(uVar.mo26772f());
        return a == -1 ? uVar.f18121j.getBottom() : a;
    }

    /* renamed from: a */
    private int m20098a(int i) {
        for (int i2 = 0; i2 < this.f18142d.size(); i2++) {
            if (this.f18142d.get(i2).f18191b == i) {
                return this.f18142d.get(i2).f18196g;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private void m20109a(List<C3297b> list, RecyclerView.C3286u uVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C3297b bVar = list.get(size);
            if (m20110a(bVar, uVar) && bVar.f18184a == null && bVar.f18185b == null) {
                list.remove(bVar);
            }
        }
    }

    /* renamed from: b */
    private void m20112b(C3297b bVar) {
        if (bVar.f18184a != null) {
            m20110a(bVar, bVar.f18184a);
        }
        if (bVar.f18185b != null) {
            m20110a(bVar, bVar.f18185b);
        }
    }

    /* renamed from: a */
    private boolean m20110a(C3297b bVar, RecyclerView.C3286u uVar) {
        boolean z = false;
        if (bVar.f18185b == uVar) {
            bVar.f18185b = null;
        } else if (bVar.f18184a != uVar) {
            return false;
        } else {
            bVar.f18184a = null;
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
        int size = this.f18142d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f18142d.get(size).f18190a == uVar) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                mo27241j(uVar);
                this.f18142d.remove(size);
            }
        }
        m20109a((List<C3297b>) this.f18143e, uVar);
        if (this.f18140b.remove(uVar)) {
            ViewCompat.setAlpha(view, 1.0f);
            mo27240i(uVar);
        }
        if (this.f18141c.remove(uVar)) {
            ViewCompat.setAlpha(view, 1.0f);
            mo27242k(uVar);
        }
        for (int size2 = this.f18146i.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f18146i.get(size2);
            m20109a((List<C3297b>) arrayList, uVar);
            if (arrayList.isEmpty()) {
                this.f18146i.remove(size2);
            }
        }
        for (int size3 = this.f18145g.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f18145g.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C3298c) arrayList2.get(size4)).f18190a == uVar) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    mo27241j(uVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f18145g.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f18144f.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f18144f.get(size5);
            if (arrayList3.remove(uVar)) {
                ViewCompat.setAlpha(view, 1.0f);
                ViewCompat.setScaleY(view, 1.0f);
                ViewCompat.setScaleX(view, 1.0f);
                ViewCompat.setTranslationY(view, 0.0f);
                mo27242k(uVar);
                if (arrayList3.isEmpty()) {
                    this.f18144f.remove(size5);
                }
            }
        }
        this.f18149l.remove(uVar);
        this.f18147j.remove(uVar);
        this.f18150m.remove(uVar);
        this.f18148k.remove(uVar);
        m20116c();
    }

    /* renamed from: u */
    private void m20122u(RecyclerView.C3286u uVar) {
        if (f18137a == null) {
            f18137a = new ValueAnimator().getInterpolator();
        }
        uVar.f18121j.animate().setInterpolator(f18137a);
        mo26040d(uVar);
    }

    /* renamed from: b */
    public boolean mo26035b() {
        return !this.f18141c.isEmpty() || !this.f18143e.isEmpty() || !this.f18142d.isEmpty() || !this.f18140b.isEmpty() || !this.f18148k.isEmpty() || !this.f18149l.isEmpty() || !this.f18147j.isEmpty() || !this.f18150m.isEmpty() || !this.f18145g.isEmpty() || !this.f18144f.isEmpty() || !this.f18146i.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20116c() {
        if (!mo26035b()) {
            mo26528i();
        }
    }

    /* renamed from: d */
    public void mo26039d() {
        int size = this.f18142d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C3298c cVar = this.f18142d.get(size);
            View view = cVar.f18190a.f18121j;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            mo27241j(cVar.f18190a);
            this.f18142d.remove(size);
        }
        for (int size2 = this.f18140b.size() - 1; size2 >= 0; size2--) {
            mo27240i(this.f18140b.get(size2).f18197a);
            this.f18140b.remove(size2);
        }
        int size3 = this.f18141c.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            C3296a aVar = this.f18141c.get(size3);
            View view2 = aVar.f18181a.f18121j;
            ViewCompat.setAlpha(view2, 1.0f);
            ViewCompat.setScaleY(view2, 1.0f);
            ViewCompat.setScaleX(view2, 1.0f);
            ViewCompat.setTranslationY(view2, 0.0f);
            mo27242k(aVar.f18181a);
            this.f18141c.remove(size3);
        }
        for (int size4 = this.f18143e.size() - 1; size4 >= 0; size4--) {
            m20112b(this.f18143e.get(size4));
        }
        this.f18143e.clear();
        if (mo26035b()) {
            for (int size5 = this.f18145g.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f18145g.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C3298c cVar2 = (C3298c) arrayList.get(size6);
                    View view3 = cVar2.f18190a.f18121j;
                    ViewCompat.setTranslationY(view3, 0.0f);
                    ViewCompat.setTranslationX(view3, 0.0f);
                    mo27241j(cVar2.f18190a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f18145g.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f18144f.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f18144f.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C3286u uVar = ((C3296a) arrayList2.get(size8)).f18181a;
                    View view4 = uVar.f18121j;
                    ViewCompat.setAlpha(view4, 1.0f);
                    ViewCompat.setScaleY(view4, 1.0f);
                    ViewCompat.setScaleX(view4, 1.0f);
                    ViewCompat.setTranslationY(view4, 0.0f);
                    mo27242k(uVar);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f18144f.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f18146i.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f18146i.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m20112b((C3297b) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f18146i.remove(arrayList3);
                    }
                }
            }
            mo26796a((List<RecyclerView.C3286u>) this.f18149l);
            mo26796a((List<RecyclerView.C3286u>) this.f18148k);
            mo26796a((List<RecyclerView.C3286u>) this.f18147j);
            mo26796a((List<RecyclerView.C3286u>) this.f18150m);
            mo26528i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26796a(List<RecyclerView.C3286u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).f18121j).cancel();
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerViewItemAnimator$VpaListenerAdapter */
    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }

        private VpaListenerAdapter() {
        }
    }
}
