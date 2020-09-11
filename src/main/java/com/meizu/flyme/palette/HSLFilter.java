package com.meizu.flyme.palette;

import androidx.palette.graphics.Palette;

public class HSLFilter implements Palette.C0288Filter {

    /* renamed from: a */
    public static final HSLFilter f6439a = new HSLFilter();

    public boolean isAllowed(int i, float[] fArr) {
        return !m6340b(fArr) && !m6339a(fArr) && !m6341c(fArr);
    }

    /* renamed from: a */
    private boolean m6339a(float[] fArr) {
        return fArr[2] <= 0.05f;
    }

    /* renamed from: b */
    private boolean m6340b(float[] fArr) {
        return fArr[2] >= 0.95f;
    }

    /* renamed from: c */
    private boolean m6341c(float[] fArr) {
        return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.3f;
    }
}
