package com.meizu.common.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: com.meizu.common.widget.g */
public class Scroller {

    /* renamed from: s */
    private static float f6405s = ((float) (Math.log(0.78d) / Math.log(0.9d)));

    /* renamed from: t */
    private static final float[] f6406t = new float[101];

    /* renamed from: u */
    private static final float[] f6407u = new float[101];

    /* renamed from: y */
    private static float f6408y = 8.0f;

    /* renamed from: z */
    private static float f6409z;

    /* renamed from: a */
    private int f6410a;

    /* renamed from: b */
    private int f6411b;

    /* renamed from: c */
    private int f6412c;

    /* renamed from: d */
    private int f6413d;

    /* renamed from: e */
    private int f6414e;

    /* renamed from: f */
    private int f6415f;

    /* renamed from: g */
    private int f6416g;

    /* renamed from: h */
    private int f6417h;

    /* renamed from: i */
    private int f6418i;

    /* renamed from: j */
    private long f6419j;

    /* renamed from: k */
    private int f6420k;

    /* renamed from: l */
    private boolean f6421l;

    /* renamed from: m */
    private Interpolator f6422m;

    /* renamed from: n */
    private boolean f6423n;

    /* renamed from: o */
    private float f6424o;

    /* renamed from: p */
    private float f6425p;

    /* renamed from: q */
    private int f6426q;

    /* renamed from: r */
    private float f6427r;

    /* renamed from: v */
    private float f6428v;

    /* renamed from: w */
    private final float f6429w;

    /* renamed from: x */
    private float f6430x;

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
            f6406t[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
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
            f6407u[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
        }
        float[] fArr = f6406t;
        f6407u[100] = 1.0f;
        fArr[100] = 1.0f;
        f6409z = 1.0f;
        f6409z = 1.0f / m6316a(1.0f);
    }

    public Scroller(Context context) {
        this(context, (Interpolator) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.f6427r = ViewConfiguration.getScrollFriction();
        this.f6421l = true;
        this.f6422m = interpolator;
        this.f6429w = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f6428v = m6317b(ViewConfiguration.getScrollFriction());
        this.f6423n = z;
        this.f6430x = m6317b(0.84f);
    }

    /* renamed from: b */
    private float m6317b(float f) {
        return this.f6429w * 386.0878f * f;
    }

    /* renamed from: a */
    public final void mo17587a(boolean z) {
        this.f6421l = z;
    }

    /* renamed from: a */
    public float mo17585a() {
        if (this.f6410a == 1) {
            return this.f6425p;
        }
        return this.f6424o - ((this.f6428v * ((float) mo17588b())) / 2000.0f);
    }

    /* renamed from: a */
    public void mo17586a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f6423n && !this.f6421l) {
            float a = mo17585a();
            float f = (float) (this.f6413d - this.f6411b);
            float f2 = (float) (this.f6414e - this.f6412c);
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            float f3 = (f / sqrt) * a;
            float f4 = (f2 / sqrt) * a;
            float f5 = (float) i3;
            if (Math.signum(f5) == Math.signum(f3)) {
                float f6 = (float) i4;
                if (Math.signum(f6) == Math.signum(f4)) {
                    i3 = (int) (f5 + f3);
                    i4 = (int) (f6 + f4);
                }
            }
        }
        this.f6410a = 1;
        this.f6421l = false;
        float sqrt2 = (float) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        this.f6424o = sqrt2;
        this.f6420k = m6319d(sqrt2);
        this.f6419j = AnimationUtils.currentAnimationTimeMillis();
        this.f6411b = i;
        this.f6412c = i2;
        int i9 = (sqrt2 > 0.0f ? 1 : (sqrt2 == 0.0f ? 0 : -1));
        float f7 = 1.0f;
        float f8 = i9 == 0 ? 1.0f : ((float) i3) / sqrt2;
        if (i9 != 0) {
            f7 = ((float) i4) / sqrt2;
        }
        double e = m6320e(sqrt2);
        this.f6426q = (int) (((double) Math.signum(sqrt2)) * e);
        this.f6415f = i5;
        this.f6416g = i6;
        this.f6417h = i7;
        this.f6418i = i8;
        this.f6413d = i + ((int) Math.round(((double) f8) * e));
        this.f6413d = Math.min(this.f6413d, this.f6416g);
        this.f6413d = Math.max(this.f6413d, this.f6415f);
        this.f6414e = i2 + ((int) Math.round(e * ((double) f7)));
        this.f6414e = Math.min(this.f6414e, this.f6418i);
        this.f6414e = Math.max(this.f6414e, this.f6417h);
    }

    /* renamed from: c */
    private double m6318c(float f) {
        return Math.log((double) ((Math.abs(f) * 0.35f) / (this.f6427r * this.f6430x)));
    }

    /* renamed from: d */
    private int m6319d(float f) {
        return (int) (Math.exp(m6318c(f) / (((double) f6405s) - 1.0d)) * 1000.0d);
    }

    /* renamed from: e */
    private double m6320e(float f) {
        double c = m6318c(f);
        return ((double) (this.f6427r * this.f6430x)) * Math.exp((((double) f6405s) / (((double) f6405s) - 1.0d)) * c);
    }

    /* renamed from: a */
    static float m6316a(float f) {
        float f2;
        float f3 = f * f6408y;
        if (f3 < 1.0f) {
            f2 = f3 - (1.0f - ((float) Math.exp((double) (-f3))));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f3)))) * 0.63212055f) + 0.36787945f;
        }
        return f2 * f6409z;
    }

    /* renamed from: b */
    public int mo17588b() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f6419j);
    }
}
