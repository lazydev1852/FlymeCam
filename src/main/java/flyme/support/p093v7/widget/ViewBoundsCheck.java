package flyme.support.p093v7.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: flyme.support.v7.widget.ViewBoundsCheck */
public class ViewBoundsCheck {

    /* renamed from: a */
    final C3321b f18408a;

    /* renamed from: b */
    C3320a f18409b = new C3320a();

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: flyme.support.v7.widget.ViewBoundsCheck$ViewBounds */
    public @interface ViewBounds {
    }

    /* renamed from: flyme.support.v7.widget.ViewBoundsCheck$b */
    interface C3321b {
        /* renamed from: a */
        int mo26661a();

        /* renamed from: a */
        int mo26662a(View view);

        /* renamed from: a */
        View mo26663a(int i);

        /* renamed from: b */
        int mo26664b();

        /* renamed from: b */
        int mo26665b(View view);
    }

    ViewBoundsCheck(C3321b bVar) {
        this.f18408a = bVar;
    }

    /* renamed from: flyme.support.v7.widget.ViewBoundsCheck$a */
    static class C3320a {

        /* renamed from: a */
        int f18410a = 0;

        /* renamed from: b */
        int f18411b;

        /* renamed from: c */
        int f18412c;

        /* renamed from: d */
        int f18413d;

        /* renamed from: e */
        int f18414e;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo27037a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        C3320a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27040a(int i, int i2, int i3, int i4) {
            this.f18411b = i;
            this.f18412c = i2;
            this.f18413d = i3;
            this.f18414e = i4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27039a(int i) {
            this.f18410a = i | this.f18410a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27038a() {
            this.f18410a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo27041b() {
            if ((this.f18410a & 7) != 0 && (this.f18410a & (mo27037a(this.f18413d, this.f18411b) << 0)) == 0) {
                return false;
            }
            if ((this.f18410a & 112) != 0 && (this.f18410a & (mo27037a(this.f18413d, this.f18412c) << 4)) == 0) {
                return false;
            }
            if ((this.f18410a & 1792) != 0 && (this.f18410a & (mo27037a(this.f18414e, this.f18411b) << 8)) == 0) {
                return false;
            }
            if ((this.f18410a & 28672) == 0 || (this.f18410a & (mo27037a(this.f18414e, this.f18412c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo27035a(int i, int i2, int i3, int i4) {
        int a = this.f18408a.mo26661a();
        int b = this.f18408a.mo26664b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f18408a.mo26663a(i);
            this.f18409b.mo27040a(a, b, this.f18408a.mo26662a(a2), this.f18408a.mo26665b(a2));
            if (i3 != 0) {
                this.f18409b.mo27038a();
                this.f18409b.mo27039a(i3);
                if (this.f18409b.mo27041b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f18409b.mo27038a();
                this.f18409b.mo27039a(i4);
                if (this.f18409b.mo27041b()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27036a(View view, int i) {
        this.f18409b.mo27040a(this.f18408a.mo26661a(), this.f18408a.mo26664b(), this.f18408a.mo26662a(view), this.f18408a.mo26665b(view));
        if (i == 0) {
            return false;
        }
        this.f18409b.mo27038a();
        this.f18409b.mo27039a(i);
        return this.f18409b.mo27041b();
    }
}
