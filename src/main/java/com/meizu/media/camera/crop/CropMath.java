package com.meizu.media.camera.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.crop.d */
public class CropMath {

    /* renamed from: a */
    public static ChangeQuickRedirect f9251a;

    /* renamed from: a */
    public static int m9718a(float f) {
        int i = (int) ((f % 360.0f) / 90.0f);
        if (i < 0) {
            i += 4;
        }
        return i * 90;
    }

    /* renamed from: a */
    public static float[] m9724a(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    /* renamed from: a */
    public static boolean m9723a(RectF rectF, float f, float f2) {
        return f <= rectF.right && f >= rectF.left && f2 <= rectF.bottom && f2 >= rectF.top;
    }

    /* renamed from: a */
    public static RectF m9721a(float[] fArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr}, (Object) null, f9251a, true, 3293, new Class[]{float[].class}, RectF.class);
        if (proxy.isSupported) {
            return (RectF) proxy.result;
        }
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float f = fArr[i - 1];
            float f2 = fArr[i];
            rectF.left = f < rectF.left ? f : rectF.left;
            rectF.top = f2 < rectF.top ? f2 : rectF.top;
            if (f <= rectF.right) {
                f = rectF.right;
            }
            rectF.right = f;
            if (f2 <= rectF.bottom) {
                f2 = rectF.bottom;
            }
            rectF.bottom = f2;
        }
        rectF.sort();
        return rectF;
    }

    /* renamed from: a */
    public static void m9722a(RectF rectF, float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{rectF, fArr}, (Object) null, f9251a, true, 3294, new Class[]{RectF.class, float[].class}, Void.TYPE).isSupported && fArr.length >= 2) {
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i] = GeometryMathUtils.m9747a(fArr[i], rectF.left, rectF.right);
                int i2 = i + 1;
                fArr[i2] = GeometryMathUtils.m9747a(fArr[i2], rectF.top, rectF.bottom);
            }
        }
    }

    /* renamed from: a */
    public static float[] m9725a(float[] fArr, float[] fArr2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, fArr2}, (Object) null, f9251a, true, 3295, new Class[]{float[].class, float[].class}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        int length = fArr2.length;
        float[] fArr3 = null;
        int i = 0;
        float f = Float.POSITIVE_INFINITY;
        while (i < length) {
            int i2 = i + 2;
            float[] fArr4 = {fArr2[i], fArr2[(i + 1) % length], fArr2[i2 % length], fArr2[(i + 3) % length]};
            float b = GeometryMathUtils.m9750b(GeometryMathUtils.m9751b(fArr, fArr4));
            if (b < f) {
                f = b;
                fArr3 = fArr4;
            }
            i = i2;
        }
        return fArr3;
    }

    /* renamed from: b */
    public static void m9726b(RectF rectF, float f, float f2) {
        if (!PatchProxy.proxy(new Object[]{rectF, new Float(f), new Float(f2)}, (Object) null, f9251a, true, 3299, new Class[]{RectF.class, Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            float width = rectF.width();
            float height = rectF.height();
            float f3 = f / f2;
            if (width / height < f3) {
                float f4 = width / f3;
                rectF.top = rectF.centerY() - (f4 / 2.0f);
                rectF.bottom = rectF.top + f4;
                return;
            }
            float f5 = height * f3;
            rectF.left = rectF.centerX() - (f5 / 2.0f);
            rectF.right = rectF.left + f5;
        }
    }

    /* renamed from: a */
    public static RectF m9720a(RectF rectF, RectF rectF2, RectF rectF3) {
        ChangeQuickRedirect changeQuickRedirect = f9251a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{rectF, rectF2, rectF3}, (Object) null, changeQuickRedirect, true, 3300, new Class[]{RectF.class, RectF.class, RectF.class}, RectF.class);
        if (proxy.isSupported) {
            return (RectF) proxy.result;
        }
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF2, rectF3, Matrix.ScaleToFit.FILL);
        RectF rectF4 = new RectF(rectF);
        if (!matrix.mapRect(rectF4)) {
            return null;
        }
        return rectF4;
    }

    /* renamed from: a */
    public static int m9719a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f9251a, true, 3301, new Class[]{Bitmap.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : bitmap.getRowBytes() * bitmap.getHeight();
    }
}
