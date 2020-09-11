package flyme.support.p093v7.widget;

import android.graphics.Rect;
import android.view.View;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.p */
public abstract class OrientationHelper {

    /* renamed from: a */
    protected final RecyclerView.C3266g f18553a;

    /* renamed from: b */
    final Rect f18554b;

    /* renamed from: c */
    private int f18555c;

    /* renamed from: a */
    public abstract int mo27208a(View view);

    /* renamed from: a */
    public abstract void mo27210a(int i);

    /* renamed from: b */
    public abstract int mo27212b(View view);

    /* renamed from: c */
    public abstract int mo27213c();

    /* renamed from: c */
    public abstract int mo27214c(View view);

    /* renamed from: d */
    public abstract int mo27215d();

    /* renamed from: d */
    public abstract int mo27216d(View view);

    /* renamed from: e */
    public abstract int mo27217e();

    /* renamed from: e */
    public abstract int mo27218e(View view);

    /* renamed from: f */
    public abstract int mo27219f();

    /* renamed from: f */
    public abstract int mo27220f(View view);

    /* renamed from: g */
    public abstract int mo27221g();

    /* renamed from: h */
    public abstract int mo27222h();

    /* renamed from: i */
    public abstract int mo27223i();

    private OrientationHelper(RecyclerView.C3266g gVar) {
        this.f18555c = Integer.MIN_VALUE;
        this.f18554b = new Rect();
        this.f18553a = gVar;
    }

    /* renamed from: a */
    public void mo27209a() {
        this.f18555c = mo27219f();
    }

    /* renamed from: b */
    public int mo27211b() {
        if (Integer.MIN_VALUE == this.f18555c) {
            return 0;
        }
        return mo27219f() - this.f18555c;
    }

    /* renamed from: a */
    public static OrientationHelper m20715a(RecyclerView.C3266g gVar, int i) {
        switch (i) {
            case 0:
                return m20714a(gVar);
            case 1:
                return m20716b(gVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* renamed from: a */
    public static OrientationHelper m20714a(RecyclerView.C3266g gVar) {
        return new OrientationHelper(gVar) {
            /* renamed from: d */
            public int mo27215d() {
                return this.f18553a.mo26557A() - this.f18553a.mo26561E();
            }

            /* renamed from: e */
            public int mo27217e() {
                return this.f18553a.mo26557A();
            }

            /* renamed from: a */
            public void mo27210a(int i) {
                this.f18553a.mo26643j(i);
            }

            /* renamed from: c */
            public int mo27213c() {
                return this.f18553a.mo26559C();
            }

            /* renamed from: e */
            public int mo27218e(View view) {
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                return this.f18553a.mo26632f(view) + hVar.leftMargin + hVar.rightMargin;
            }

            /* renamed from: f */
            public int mo27220f(View view) {
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                return this.f18553a.mo26635g(view) + hVar.topMargin + hVar.bottomMargin;
            }

            /* renamed from: b */
            public int mo27212b(View view) {
                return this.f18553a.mo26642j(view) + ((RecyclerView.C3270h) view.getLayoutParams()).rightMargin;
            }

            /* renamed from: a */
            public int mo27208a(View view) {
                return this.f18553a.mo26638h(view) - ((RecyclerView.C3270h) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: c */
            public int mo27214c(View view) {
                this.f18553a.mo26582a(view, true, this.f18554b);
                return this.f18554b.right;
            }

            /* renamed from: d */
            public int mo27216d(View view) {
                this.f18553a.mo26582a(view, true, this.f18554b);
                return this.f18554b.left;
            }

            /* renamed from: f */
            public int mo27219f() {
                return (this.f18553a.mo26557A() - this.f18553a.mo26559C()) - this.f18553a.mo26561E();
            }

            /* renamed from: g */
            public int mo27221g() {
                return this.f18553a.mo26561E();
            }

            /* renamed from: h */
            public int mo27222h() {
                return this.f18553a.mo26659y();
            }

            /* renamed from: i */
            public int mo27223i() {
                return this.f18553a.mo26660z();
            }
        };
    }

    /* renamed from: b */
    public static OrientationHelper m20716b(RecyclerView.C3266g gVar) {
        return new OrientationHelper(gVar) {
            /* renamed from: d */
            public int mo27215d() {
                return this.f18553a.mo26558B() - this.f18553a.mo26562F();
            }

            /* renamed from: e */
            public int mo27217e() {
                return this.f18553a.mo26558B();
            }

            /* renamed from: a */
            public void mo27210a(int i) {
                this.f18553a.mo26645k(i);
            }

            /* renamed from: c */
            public int mo27213c() {
                return this.f18553a.mo26560D();
            }

            /* renamed from: e */
            public int mo27218e(View view) {
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                return this.f18553a.mo26635g(view) + hVar.topMargin + hVar.bottomMargin;
            }

            /* renamed from: f */
            public int mo27220f(View view) {
                RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
                return this.f18553a.mo26632f(view) + hVar.leftMargin + hVar.rightMargin;
            }

            /* renamed from: b */
            public int mo27212b(View view) {
                return this.f18553a.mo26644k(view) + ((RecyclerView.C3270h) view.getLayoutParams()).bottomMargin;
            }

            /* renamed from: a */
            public int mo27208a(View view) {
                return this.f18553a.mo26640i(view) - ((RecyclerView.C3270h) view.getLayoutParams()).topMargin;
            }

            /* renamed from: c */
            public int mo27214c(View view) {
                this.f18553a.mo26582a(view, true, this.f18554b);
                return this.f18554b.bottom;
            }

            /* renamed from: d */
            public int mo27216d(View view) {
                this.f18553a.mo26582a(view, true, this.f18554b);
                return this.f18554b.top;
            }

            /* renamed from: f */
            public int mo27219f() {
                return (this.f18553a.mo26558B() - this.f18553a.mo26560D()) - this.f18553a.mo26562F();
            }

            /* renamed from: g */
            public int mo27221g() {
                return this.f18553a.mo26562F();
            }

            /* renamed from: h */
            public int mo27222h() {
                return this.f18553a.mo26660z();
            }

            /* renamed from: i */
            public int mo27223i() {
                return this.f18553a.mo26659y();
            }
        };
    }
}
