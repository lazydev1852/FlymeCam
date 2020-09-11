package com.meizu.media.camera.crop;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.crop.f */
public final class GeometryMathUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f9261a;

    /* renamed from: a */
    public static float m9747a(float f, float f2, float f3) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), new Float(f3)}, (Object) null, f9261a, true, 3335, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE}, Float.TYPE);
        return proxy.isSupported ? ((Float) proxy.result).floatValue() : Math.max(Math.min(f, f3), f2);
    }

    /* renamed from: a */
    public static float[] m9749a(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr2[0];
        float f6 = fArr2[1];
        float f7 = fArr2[2];
        float f8 = fArr2[3];
        float f9 = f - f3;
        float f10 = f2 - f4;
        float f11 = f3 - f7;
        float f12 = f8 - f4;
        float f13 = f5 - f7;
        float f14 = f6 - f8;
        float f15 = (f10 * f13) - (f9 * f14);
        if (f15 == 0.0f) {
            return null;
        }
        float f16 = ((f12 * f13) + (f14 * f11)) / f15;
        return new float[]{f3 + (f9 * f16), f4 + (f16 * f10)};
    }

    /* renamed from: b */
    public static float[] m9751b(float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = fArr2[2];
        float f3 = fArr2[1];
        float f4 = f2 - f;
        float f5 = fArr2[3] - f3;
        if (f4 == 0.0f && f5 == 0.0f) {
            return null;
        }
        float f6 = (((fArr[0] - f) * f4) + ((fArr[1] - f3) * f5)) / ((f4 * f4) + (f5 * f5));
        float[] fArr3 = {f + (f4 * f6), f3 + (f6 * f5)};
        return new float[]{fArr3[0] - fArr[0], fArr3[1] - fArr[1]};
    }

    /* renamed from: c */
    public static float m9752c(float[] fArr, float[] fArr2) {
        return (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]);
    }

    /* renamed from: a */
    public static float[] m9748a(float[] fArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr}, (Object) null, f9261a, true, 3336, new Class[]{float[].class}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        float sqrt = (float) Math.sqrt((double) ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])));
        return new float[]{fArr[0] / sqrt, fArr[1] / sqrt};
    }

    /* renamed from: d */
    public static float m9753d(float[] fArr, float[] fArr2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, fArr2}, (Object) null, f9261a, true, 3337, new Class[]{float[].class, float[].class}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        return m9752c(fArr, fArr2) / ((float) Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1]))));
    }

    /* renamed from: b */
    public static float m9750b(float[] fArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr}, (Object) null, f9261a, true, 3340, new Class[]{float[].class}, Float.TYPE);
        return proxy.isSupported ? ((Float) proxy.result).floatValue() : (float) Math.sqrt((double) ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])));
    }
}
