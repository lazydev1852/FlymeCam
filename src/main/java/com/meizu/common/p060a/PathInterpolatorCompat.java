package com.meizu.common.p060a;

import android.view.animation.Interpolator;

/* renamed from: com.meizu.common.a.a */
public class PathInterpolatorCompat implements Interpolator {

    /* renamed from: a */
    private int f4122a = 100;

    /* renamed from: b */
    private float f4123b = 0.01f;

    /* renamed from: c */
    private float[] f4124c;

    /* renamed from: d */
    private float[] f4125d;

    public PathInterpolatorCompat(float f, float f2, float f3, float f4) {
        m4857a(f, f2, f3, f4);
    }

    /* renamed from: a */
    private void m4857a(float f, float f2, float f3, float f4) {
        this.f4124c = new float[this.f4122a];
        this.f4125d = new float[this.f4122a];
        float f5 = f * 3.0f;
        float f6 = f3 * 3.0f;
        float f7 = (f5 + 1.0f) - f6;
        float f8 = f6 - (f * 6.0f);
        float f9 = f2 * 3.0f;
        float f10 = f4 * 3.0f;
        float f11 = (1.0f + f9) - f10;
        float f12 = f10 - (f2 * 6.0f);
        float f13 = 0.0f;
        for (int i = 0; i < this.f4122a; i++) {
            float f14 = f13 * f13;
            float f15 = f14 * f13;
            this.f4124c[i] = (f7 * f15) + (f8 * f14) + (f5 * f13);
            this.f4125d[i] = (f15 * f11) + (f14 * f12) + (f9 * f13);
            f13 += this.f4123b;
        }
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f4124c.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f4124c[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f4124c[length] - this.f4124c[i];
        if (f2 == 0.0f) {
            return this.f4125d[i];
        }
        float f3 = this.f4125d[i];
        return f3 + (((f - this.f4124c[i]) / f2) * (this.f4125d[length] - f3));
    }
}
