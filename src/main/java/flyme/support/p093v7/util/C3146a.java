package flyme.support.p093v7.util;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: flyme.support.v7.util.a */
/* compiled from: OverScroller */
public class C3146a {

    /* renamed from: a */
    private int f17062a;

    /* renamed from: b */
    private final C3147a f17063b;

    /* renamed from: c */
    private final C3147a f17064c;

    /* renamed from: d */
    private Interpolator f17065d;

    /* renamed from: e */
    private final boolean f17066e;

    public C3146a(Context context) {
        this(context, (Interpolator) null);
    }

    public C3146a(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public C3146a(Context context, Interpolator interpolator, boolean z) {
        if (interpolator == null) {
            this.f17065d = new C3148b();
        } else {
            this.f17065d = interpolator;
        }
        this.f17066e = z;
        this.f17063b = new C3147a(context);
        this.f17064c = new C3147a(context);
    }

    /* renamed from: a */
    public final boolean mo25385a() {
        return this.f17063b.f17080k && this.f17064c.f17080k;
    }

    /* renamed from: b */
    public final int mo25387b() {
        return this.f17063b.f17071b;
    }

    /* renamed from: c */
    public final int mo25388c() {
        return this.f17064c.f17071b;
    }

    /* renamed from: d */
    public float mo25389d() {
        return (float) Math.hypot((double) this.f17063b.f17074e, (double) this.f17064c.f17074e);
    }

    /* renamed from: e */
    public boolean mo25390e() {
        if (mo25385a()) {
            return false;
        }
        switch (this.f17062a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f17063b.f17076g;
                int d = this.f17063b.f17077h;
                if (currentAnimationTimeMillis < ((long) d)) {
                    float interpolation = this.f17065d.getInterpolation(((float) currentAnimationTimeMillis) / ((float) d));
                    this.f17063b.mo25393a(interpolation);
                    this.f17064c.mo25393a(interpolation);
                    return true;
                }
                mo25391f();
                return true;
            case 1:
                if (!this.f17063b.f17080k && !this.f17063b.mo25397c() && !this.f17063b.mo25396b()) {
                    this.f17063b.mo25392a();
                }
                if (this.f17064c.f17080k || this.f17064c.mo25397c() || this.f17064c.mo25396b()) {
                    return true;
                }
                this.f17064c.mo25392a();
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public boolean mo25386a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f17062a = 1;
        boolean a = this.f17063b.mo25395a(i, i3, i4);
        boolean a2 = this.f17064c.mo25395a(i2, i5, i6);
        if (a || a2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo25383a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        mo25384a(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    /* renamed from: a */
    public void mo25384a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!this.f17066e || mo25385a()) {
            i14 = i3;
        } else {
            float c = this.f17063b.f17074e;
            float c2 = this.f17064c.f17074e;
            i14 = i3;
            float f = (float) i14;
            if (Math.signum(f) == Math.signum(c)) {
                i13 = i4;
                float f2 = (float) i13;
                if (Math.signum(f2) == Math.signum(c2)) {
                    i12 = (int) (f2 + c2);
                    i11 = (int) (f + c);
                    this.f17062a = 1;
                    this.f17063b.mo25394a(i, i11, i5, i6, i9);
                    this.f17064c.mo25394a(i2, i12, i7, i8, i10);
                }
                i12 = i13;
                i11 = i14;
                this.f17062a = 1;
                this.f17063b.mo25394a(i, i11, i5, i6, i9);
                this.f17064c.mo25394a(i2, i12, i7, i8, i10);
            }
        }
        i13 = i4;
        i12 = i13;
        i11 = i14;
        this.f17062a = 1;
        this.f17063b.mo25394a(i, i11, i5, i6, i9);
        this.f17064c.mo25394a(i2, i12, i7, i8, i10);
    }

    /* renamed from: f */
    public void mo25391f() {
        this.f17063b.mo25392a();
        this.f17064c.mo25392a();
    }

    /* renamed from: flyme.support.v7.util.a$a */
    /* compiled from: OverScroller */
    static class C3147a {

        /* renamed from: p */
        private static float f17067p = ((float) (Math.log(0.78d) / Math.log(0.9d)));

        /* renamed from: q */
        private static final float[] f17068q = new float[101];

        /* renamed from: r */
        private static final float[] f17069r = new float[101];

        /* renamed from: a */
        private int f17070a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f17071b;

        /* renamed from: c */
        private int f17072c;

        /* renamed from: d */
        private int f17073d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public float f17074e;

        /* renamed from: f */
        private float f17075f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public long f17076g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f17077h;

        /* renamed from: i */
        private int f17078i;

        /* renamed from: j */
        private int f17079j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f17080k = true;

        /* renamed from: l */
        private int f17081l;

        /* renamed from: m */
        private float f17082m = ViewConfiguration.getScrollFriction();

        /* renamed from: n */
        private int f17083n = 0;

        /* renamed from: o */
        private float f17084o;

        /* renamed from: a */
        private static float m18723a(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f13 = ((float) i) / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    f = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                    float f16 = f15;
                    if (((double) Math.abs(f15 - f13)) < 1.0E-5d) {
                        break;
                    } else if (f16 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                f17068q[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f17 = 1.0f;
                while (true) {
                    f7 = ((f17 - f12) / f) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f18 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (((double) Math.abs(f18 - f13)) < 1.0E-5d) {
                        break;
                    }
                    if (f18 > f13) {
                        f17 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                f17069r[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            }
            float[] fArr = f17068q;
            f17069r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        C3147a(Context context) {
            this.f17084o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25393a(float f) {
            this.f17071b = this.f17070a + Math.round(f * ((float) (this.f17072c - this.f17070a)));
        }

        /* renamed from: b */
        private void m18729b(int i, int i2, int i3) {
            float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = ((float) i4) / 100.0f;
                int i5 = i4 + 1;
                float f2 = f17069r[i4];
                this.f17077h = (int) (((float) this.f17077h) * (f2 + (((abs - f) / ((((float) i5) / 100.0f) - f)) * (f17069r[i5] - f2))));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25392a() {
            this.f17071b = this.f17072c;
            this.f17080k = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo25395a(int i, int i2, int i3) {
            this.f17080k = true;
            this.f17072c = i;
            this.f17070a = i;
            this.f17071b = i;
            this.f17073d = 0;
            this.f17076g = AnimationUtils.currentAnimationTimeMillis();
            this.f17077h = 0;
            if (i < i2) {
                m18732c(i, i2, 0);
            } else if (i > i3) {
                m18732c(i, i3, 0);
            }
            return !this.f17080k;
        }

        /* renamed from: c */
        private void m18732c(int i, int i2, int i3) {
            this.f17080k = false;
            this.f17083n = 1;
            this.f17070a = i;
            this.f17071b = i;
            this.f17072c = i2;
            int i4 = i - i2;
            this.f17075f = m18723a(i4);
            this.f17073d = -i4;
            this.f17081l = Math.abs(i4);
            this.f17077h = (int) (Math.sqrt((((double) i4) * -2.0d) / ((double) this.f17075f)) * 1000.0d * 1.5d);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25394a(int i, int i2, int i3, int i4, int i5) {
            this.f17081l = i5;
            this.f17080k = false;
            this.f17073d = i2;
            float f = (float) i2;
            this.f17074e = f;
            this.f17078i = 0;
            this.f17077h = 0;
            this.f17076g = AnimationUtils.currentAnimationTimeMillis();
            this.f17070a = i;
            this.f17071b = i;
            if (i > i4 || i < i3) {
                m18725a(i, i3, i4, i2);
                return;
            }
            this.f17083n = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int d2 = m18733d(i2);
                this.f17078i = d2;
                this.f17077h = d2;
                d = m18730c(i2);
            }
            this.f17079j = (int) (d * ((double) Math.signum(f)));
            this.f17072c = i + this.f17079j;
            if (this.f17072c < i3) {
                m18729b(this.f17070a, this.f17072c, i3);
                this.f17072c = i3;
            }
            if (this.f17072c > i4) {
                m18729b(this.f17070a, this.f17072c, i4);
                this.f17072c = i4;
            }
        }

        /* renamed from: b */
        private double m18727b(int i) {
            return Math.log((double) ((((float) Math.abs(i)) * 0.35f) / (this.f17082m * this.f17084o)));
        }

        /* renamed from: c */
        private double m18730c(int i) {
            double b = m18727b(i);
            return ((double) (this.f17082m * this.f17084o)) * Math.exp((((double) f17067p) / (((double) f17067p) - 1.0d)) * b);
        }

        /* renamed from: d */
        private int m18733d(int i) {
            return (int) (Math.exp(m18727b(i) / (((double) f17067p) - 1.0d)) * 1000.0d * 1.5d);
        }

        /* renamed from: d */
        private void m18736d(int i, int i2, int i3) {
            float f = ((float) (-i3)) / this.f17075f;
            float f2 = (float) i3;
            float sqrt = (float) Math.sqrt((((double) ((((f2 * f2) / 2.0f) / Math.abs(this.f17075f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f17075f)));
            this.f17076g -= (long) ((int) ((sqrt - f) * 1000.0f));
            this.f17070a = i2;
            this.f17071b = i2;
            this.f17073d = (int) ((-this.f17075f) * sqrt);
        }

        /* renamed from: e */
        private void m18738e(int i, int i2, int i3) {
            this.f17075f = m18723a(i3 == 0 ? i - i2 : i3);
            m18736d(i, i2, i3);
            m18735d();
        }

        /* renamed from: a */
        private void m18725a(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (i <= i2 || i >= i3) {
                boolean z2 = i > i3;
                int i5 = z2 ? i3 : i2;
                int i6 = i - i5;
                if (i6 * i4 < 0) {
                    z = false;
                }
                if (z) {
                    m18738e(i, i5, i4);
                } else if (m18730c(i4) > ((double) Math.abs(i6))) {
                    mo25394a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.f17081l);
                } else {
                    m18732c(i, i5, i4);
                }
            } else {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.f17080k = true;
            }
        }

        /* renamed from: d */
        private void m18735d() {
            float f = ((float) this.f17073d) * ((float) this.f17073d);
            float abs = f / (Math.abs(this.f17075f) * 2.0f);
            float signum = Math.signum((float) this.f17073d);
            if (abs > ((float) this.f17081l)) {
                this.f17075f = ((-signum) * f) / (((float) this.f17081l) * 2.0f);
                abs = (float) this.f17081l;
            }
            this.f17081l = (int) abs;
            this.f17083n = 2;
            int i = this.f17070a;
            if (this.f17073d <= 0) {
                abs = -abs;
            }
            this.f17072c = i + ((int) abs);
            this.f17077h = -((int) ((((float) this.f17073d) * 1000.0f) / this.f17075f));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo25396b() {
            switch (this.f17083n) {
                case 0:
                    if (this.f17077h < this.f17078i) {
                        int i = this.f17072c;
                        this.f17070a = i;
                        this.f17071b = i;
                        this.f17073d = (int) this.f17074e;
                        this.f17075f = m18723a(this.f17073d);
                        this.f17076g += (long) this.f17077h;
                        m18735d();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.f17076g += (long) this.f17077h;
                    m18732c(this.f17072c, this.f17070a, 0);
                    break;
            }
            mo25397c();
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo25397c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f17076g;
            if (currentAnimationTimeMillis == 0) {
                if (this.f17077h > 0) {
                    return true;
                }
                return false;
            } else if (currentAnimationTimeMillis > ((long) this.f17077h)) {
                return false;
            } else {
                double d = 0.0d;
                switch (this.f17083n) {
                    case 0:
                        float f = ((float) currentAnimationTimeMillis) / ((float) this.f17078i);
                        int i = (int) (f * 100.0f);
                        float f2 = 1.0f;
                        float f3 = 0.0f;
                        if (i < 100) {
                            float f4 = ((float) i) / 100.0f;
                            int i2 = i + 1;
                            float f5 = f17068q[i];
                            f3 = (f17068q[i2] - f5) / ((((float) i2) / 100.0f) - f4);
                            f2 = f5 + ((f - f4) * f3);
                        }
                        d = (double) (f2 * ((float) this.f17079j));
                        this.f17074e = ((f3 * ((float) this.f17079j)) / ((float) this.f17078i)) * 1000.0f;
                        break;
                    case 1:
                        float f6 = ((float) currentAnimationTimeMillis) / ((float) this.f17077h);
                        float signum = Math.signum((float) this.f17073d);
                        int i3 = this.f17081l;
                        this.f17074e = signum * ((float) this.f17081l) * 6.0f * ((-f6) + (f6 * f6));
                        d = (double) (((float) m18724a(currentAnimationTimeMillis)) * signum);
                        break;
                    case 2:
                        float f7 = ((float) currentAnimationTimeMillis) / 1000.0f;
                        this.f17074e = ((float) this.f17073d) + (this.f17075f * f7);
                        d = (double) ((((float) this.f17073d) * f7) + (((this.f17075f * f7) * f7) / 2.0f));
                        break;
                }
                this.f17071b = this.f17070a + ((int) Math.round(d));
                return true;
            }
        }

        /* renamed from: a */
        private int m18724a(long j) {
            return (int) Math.round(((double) this.f17081l) * (Math.pow((double) (((((float) j) * 1.0f) / ((float) this.f17077h)) - 1.0f), 5.0d) + 1.0d));
        }
    }

    /* renamed from: flyme.support.v7.util.a$b */
    /* compiled from: OverScroller */
    static class C3148b implements Interpolator {

        /* renamed from: a */
        private static final float f17085a = (1.0f / m18745a(1.0f));

        /* renamed from: b */
        private static final float f17086b = (1.0f - (f17085a * m18745a(1.0f)));

        C3148b() {
        }

        /* renamed from: a */
        private static float m18745a(float f) {
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
            }
            return ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f) + 0.36787945f;
        }

        public float getInterpolation(float f) {
            float a = f17085a * m18745a(f);
            return a > 0.0f ? a + f17086b : a;
        }
    }
}
