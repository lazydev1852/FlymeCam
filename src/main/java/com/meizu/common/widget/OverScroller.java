package com.meizu.common.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: com.meizu.common.widget.e */
public class OverScroller {

    /* renamed from: a */
    private int f6356a;

    /* renamed from: b */
    private final C1555a f6357b;

    /* renamed from: c */
    private final C1555a f6358c;

    /* renamed from: d */
    private Interpolator f6359d;

    /* renamed from: e */
    private final boolean f6360e;

    public OverScroller(Context context) {
        this(context, (Interpolator) null);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.f6359d = interpolator;
        this.f6360e = z;
        this.f6357b = new C1555a(context);
        this.f6358c = new C1555a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17561a(Interpolator interpolator) {
        this.f6359d = interpolator;
    }

    /* renamed from: a */
    public final boolean mo17564a() {
        return this.f6357b.f6378k && this.f6358c.f6378k;
    }

    /* renamed from: a */
    public final void mo17562a(boolean z) {
        boolean unused = this.f6357b.f6378k = this.f6358c.f6378k = z;
    }

    /* renamed from: b */
    public final int mo17566b() {
        return this.f6357b.f6369b;
    }

    /* renamed from: c */
    public boolean mo17567c() {
        float f;
        if (mo17564a()) {
            return false;
        }
        switch (this.f6356a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f6357b.f6374g;
                int c = this.f6357b.f6375h;
                if (currentAnimationTimeMillis < ((long) c)) {
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) c);
                    if (this.f6359d == null) {
                        f = Scroller.m6316a(f2);
                    } else {
                        f = this.f6359d.getInterpolation(f2);
                    }
                    this.f6357b.mo17570a(f);
                    this.f6358c.mo17570a(f);
                    return true;
                }
                mo17568d();
                return true;
            case 1:
                if (!this.f6357b.f6378k && !this.f6357b.mo17575c() && !this.f6357b.mo17573b()) {
                    this.f6357b.mo17569a();
                }
                if (this.f6358c.f6378k || this.f6358c.mo17575c() || this.f6358c.mo17573b()) {
                    return true;
                }
                this.f6358c.mo17569a();
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public void mo17560a(int i, int i2, int i3, int i4, int i5) {
        this.f6356a = 0;
        this.f6357b.mo17571a(i, i3, i5);
        this.f6358c.mo17571a(i2, i4, i5);
    }

    /* renamed from: a */
    public boolean mo17565a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f6356a = 1;
        boolean b = this.f6357b.mo17574b(i, i3, i4);
        boolean b2 = this.f6358c.mo17574b(i2, i5, i6);
        if (b || b2) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public void mo17568d() {
        this.f6357b.mo17569a();
        this.f6358c.mo17569a();
    }

    /* renamed from: a */
    public void mo17563a(boolean z, boolean z2) {
        this.f6357b.mo17572a(z, z2);
        this.f6358c.mo17572a(z, z2);
    }

    /* renamed from: com.meizu.common.widget.e$a */
    /* compiled from: OverScroller */
    static class C1555a {

        /* renamed from: p */
        private static float f6361p = ((float) (Math.log(0.78d) / Math.log(0.9d)));

        /* renamed from: q */
        private static final float[] f6362q = new float[101];

        /* renamed from: r */
        private static final float[] f6363r = new float[101];

        /* renamed from: A */
        private int f6364A = 0;

        /* renamed from: B */
        private int f6365B = 50;

        /* renamed from: C */
        private long f6366C = 0;

        /* renamed from: D */
        private boolean f6367D = false;

        /* renamed from: a */
        private int f6368a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f6369b;

        /* renamed from: c */
        private int f6370c;

        /* renamed from: d */
        private int f6371d;

        /* renamed from: e */
        private float f6372e;

        /* renamed from: f */
        private float f6373f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public long f6374g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f6375h;

        /* renamed from: i */
        private int f6376i;

        /* renamed from: j */
        private int f6377j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f6378k = true;

        /* renamed from: l */
        private int f6379l;

        /* renamed from: m */
        private float f6380m = ViewConfiguration.getScrollFriction();

        /* renamed from: n */
        private int f6381n = 0;

        /* renamed from: o */
        private float f6382o;

        /* renamed from: s */
        private float f6383s = 0.0f;

        /* renamed from: t */
        private float f6384t = 0.0f;

        /* renamed from: u */
        private float f6385u = 0.0f;

        /* renamed from: v */
        private int f6386v = 0;

        /* renamed from: w */
        private int f6387w = 0;

        /* renamed from: x */
        private int f6388x = 0;

        /* renamed from: y */
        private boolean f6389y = false;

        /* renamed from: z */
        private int f6390z = 1;

        /* renamed from: a */
        private static float m6275a(int i) {
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
                f6362q[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
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
                f6363r[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            }
            float[] fArr = f6362q;
            f6363r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        C1555a(Context context) {
            this.f6382o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
            this.f6390z = 0;
            this.f6366C = 0;
            this.f6389y = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17570a(float f) {
            this.f6369b = this.f6368a + Math.round(f * ((float) (this.f6370c - this.f6368a)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17571a(int i, int i2, int i3) {
            this.f6378k = false;
            this.f6368a = i;
            this.f6370c = i + i2;
            this.f6374g = AnimationUtils.currentAnimationTimeMillis();
            this.f6375h = i3;
            this.f6373f = 0.0f;
            this.f6371d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17569a() {
            this.f6369b = this.f6370c;
            this.f6378k = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo17574b(int i, int i2, int i3) {
            this.f6378k = true;
            this.f6370c = i;
            this.f6368a = i;
            this.f6371d = 0;
            this.f6374g = AnimationUtils.currentAnimationTimeMillis();
            this.f6375h = 0;
            if (i < i2) {
                m6281c(i, i2, 0);
            } else if (i > i3) {
                m6281c(i, i3, 0);
            }
            return !this.f6378k;
        }

        /* renamed from: c */
        private void m6281c(int i, int i2, int i3) {
            this.f6378k = false;
            this.f6381n = 1;
            this.f6368a = i;
            this.f6370c = i2;
            int i4 = i - i2;
            this.f6373f = m6275a(i4);
            this.f6371d = -i4;
            this.f6379l = Math.abs(i4);
            if (this.f6367D) {
                this.f6375h = 618;
            } else {
                this.f6375h = (int) (Math.sqrt((((double) i4) * -2.0d) / ((double) this.f6373f)) * 1000.0d);
            }
        }

        /* renamed from: d */
        private void m6283d() {
            double d;
            float abs = ((float) (this.f6371d * this.f6371d)) / (Math.abs(this.f6373f) * 2.0f);
            if (!this.f6367D) {
                float signum = Math.signum((float) this.f6371d);
                if (abs > ((float) this.f6379l)) {
                    this.f6373f = (((-signum) * ((float) this.f6371d)) * ((float) this.f6371d)) / (((float) this.f6379l) * 2.0f);
                    abs = (float) this.f6379l;
                }
                this.f6370c = this.f6368a + ((int) (this.f6371d > 0 ? abs : -abs));
                this.f6375h = -((int) ((((float) this.f6371d) * 1000.0f) / this.f6373f));
            } else {
                this.f6385u = 0.5f;
                this.f6383s = 0.0f;
                int i = 0;
                this.f6378k = false;
                this.f6375h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                this.f6384t = this.f6372e / 150.0f;
                while (true) {
                    d = (double) i;
                    if (((int) (((double) this.f6384t) * Math.pow((double) this.f6385u, d))) == 0) {
                        break;
                    }
                    i++;
                }
                this.f6386v = i;
                abs = (float) ((((double) this.f6384t) * (1.0d - Math.pow((double) this.f6385u, d))) / ((double) (1.0f - this.f6385u)));
                this.f6370c = (int) (((float) this.f6368a) + abs);
            }
            this.f6379l = (int) abs;
            this.f6381n = 2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo17573b() {
            switch (this.f6381n) {
                case 0:
                    if (this.f6375h < this.f6376i) {
                        this.f6368a = this.f6370c;
                        this.f6371d = (int) this.f6372e;
                        this.f6373f = m6275a(this.f6371d);
                        this.f6374g += (long) this.f6375h;
                        m6283d();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    if (this.f6367D) {
                        this.f6374g = AnimationUtils.currentAnimationTimeMillis();
                    } else {
                        this.f6374g += (long) this.f6375h;
                    }
                    m6281c(this.f6370c, this.f6368a, 0);
                    break;
            }
            mo17575c();
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo17575c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f6374g;
            if (currentAnimationTimeMillis > ((long) this.f6375h)) {
                if (this.f6367D) {
                    if (this.f6389y) {
                        if (this.f6386v != 0) {
                            this.f6370c = this.f6369b;
                        }
                    } else if (this.f6375h < this.f6376i && this.f6370c != this.f6369b) {
                        this.f6369b = this.f6370c;
                        return true;
                    }
                    this.f6378k = true;
                }
                return false;
            }
            double d = 0.0d;
            switch (this.f6381n) {
                case 0:
                    if (this.f6389y) {
                        this.f6364A++;
                        if (this.f6367D && this.f6364A == 5) {
                            this.f6366C = (this.f6366C + (currentAnimationTimeMillis / ((long) this.f6364A))) / 2;
                        }
                        this.f6372e *= this.f6385u;
                        d = (double) (this.f6383s + this.f6384t);
                        this.f6384t *= this.f6385u;
                        this.f6383s = (float) d;
                        break;
                    } else {
                        float f = ((float) currentAnimationTimeMillis) / ((float) this.f6376i);
                        int i = (int) (f * 100.0f);
                        float f2 = 1.0f;
                        float f3 = 0.0f;
                        if (i < 100) {
                            float f4 = ((float) i) / 100.0f;
                            int i2 = i + 1;
                            float f5 = f6362q[i];
                            f3 = (f6362q[i2] - f5) / ((((float) i2) / 100.0f) - f4);
                            f2 = f5 + ((f - f4) * f3);
                        }
                        d = (double) (f2 * ((float) this.f6377j));
                        this.f6372e = ((f3 * ((float) this.f6377j)) / ((float) this.f6376i)) * 1000.0f;
                        break;
                    }
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / ((float) this.f6375h);
                    float f7 = f6 * f6;
                    float signum = Math.signum((float) this.f6371d);
                    if (!this.f6367D) {
                        this.f6372e = signum * ((float) this.f6379l) * 6.0f * ((-f6) + f7);
                        d = (double) (((float) this.f6379l) * signum * ((3.0f * f7) - ((2.0f * f6) * f7)));
                        break;
                    } else {
                        d = (double) (signum * ((float) m6276a(currentAnimationTimeMillis, this.f6368a, this.f6379l, (long) this.f6375h)));
                        break;
                    }
                case 2:
                    if (this.f6367D) {
                        this.f6372e *= this.f6385u;
                        d = (double) (this.f6383s + this.f6384t);
                        this.f6384t *= this.f6385u;
                        this.f6383s = (float) d;
                        break;
                    } else {
                        float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                        this.f6372e = ((float) this.f6371d) + (this.f6373f * f8);
                        d = (double) ((((float) this.f6371d) * f8) + (((this.f6373f * f8) * f8) / 2.0f));
                        break;
                    }
            }
            if (!this.f6367D) {
                this.f6369b = this.f6368a + ((int) Math.round(d));
                return true;
            } else if (this.f6381n != 0 || this.f6389y) {
                this.f6369b = this.f6368a + ((int) d);
                if (this.f6369b != this.f6370c) {
                    return true;
                }
                return false;
            } else {
                this.f6369b = this.f6368a + ((int) Math.round(d));
                return true;
            }
        }

        /* renamed from: a */
        private int m6276a(long j, int i, int i2, long j2) {
            return (int) Math.round(((double) i2) * (Math.pow((double) (((((float) j) * 1.0f) / ((float) j2)) - 1.0f), 5.0d) + 1.0d));
        }

        /* renamed from: a */
        public void mo17572a(boolean z, boolean z2) {
            this.f6367D = z;
            this.f6389y = z2;
        }
    }
}
