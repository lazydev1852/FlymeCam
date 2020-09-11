package com.meizu.common.util;

import android.graphics.Path;
import android.util.Log;

/* renamed from: com.meizu.common.util.h */
public class SmoothCornerPathGenerator {
    /* renamed from: a */
    public static boolean m5169a(Path path, int i, float f, int i2, int i3, int i4, int i5) {
        if (path == null || i == 0) {
            return false;
        }
        path.reset();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = i * 2;
        if (i6 < i8 || i7 < i8) {
            Log.e("SmoothCornerView", "radius should less than width, width=" + i6 + ", radius=" + i);
            return false;
        }
        int i9 = i7 - i;
        int i10 = -i;
        for (int i11 = i10; i11 <= 0; i11++) {
            double d = (double) f;
            float pow = (float) Math.pow(Math.abs(Math.pow((double) i, d) - Math.pow((double) Math.abs(i11), d)), (double) (1.0f / f));
            if (i11 == i10) {
                path.moveTo((float) (i11 + i), pow + ((float) i9));
            } else {
                path.lineTo((float) (i11 + i), pow + ((float) i9));
            }
        }
        int i12 = i6 - i;
        for (int i13 = 0; i13 <= i; i13++) {
            double d2 = (double) f;
            path.lineTo((float) (i13 + i12), ((float) Math.pow(Math.abs(Math.pow((double) i, d2) - Math.pow((double) Math.abs(i13), d2)), (double) (1.0f / f))) + ((float) i9));
        }
        for (int i14 = i; i14 >= 0; i14--) {
            double d3 = (double) f;
            path.lineTo((float) (i14 + i12), ((float) (-Math.pow(Math.abs(Math.pow((double) i, d3) - Math.pow((double) Math.abs(i14), d3)), (double) (1.0f / f)))) + ((float) i));
        }
        for (int i15 = 0; i15 >= i10; i15--) {
            double d4 = (double) f;
            path.lineTo((float) (i15 + i), ((float) (-Math.pow(Math.abs(Math.pow((double) i, d4) - Math.pow((double) Math.abs(i15), d4)), (double) (1.0f / f)))) + ((float) i));
        }
        return true;
    }
}
