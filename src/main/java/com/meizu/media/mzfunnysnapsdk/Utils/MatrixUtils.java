package com.meizu.media.mzfunnysnapsdk.Utils;

import android.opengl.Matrix;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public enum MatrixUtils {
    ;
    
    public static final int TYPE_CENTERCROP = 1;
    public static final int TYPE_CENTERINSIDE = 2;
    public static final int TYPE_FITEND = 4;
    public static final int TYPE_FITSTART = 3;
    public static final int TYPE_FITXY = 0;
    public static ChangeQuickRedirect changeQuickRedirect;

    @Deprecated
    public static void getShowMatrix(float[] fArr, int i, int i2, int i3, int i4) {
        if (i2 > 0 && i > 0 && i3 > 0 && i4 > 0) {
            float f = ((float) i3) / ((float) i4);
            float f2 = ((float) i) / ((float) i2);
            float[] fArr2 = new float[16];
            float[] fArr3 = new float[16];
            if (f2 > f) {
                Matrix.orthoM(fArr2, 0, (-f) / f2, f / f2, -1.0f, 1.0f, 1.0f, 3.0f);
            } else {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f, f2 / f, 1.0f, 3.0f);
            }
            Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
    }

    public static void getMatrix(float[] fArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (!PatchProxy.proxy(new Object[]{fArr, new Integer(i6), new Integer(i7), new Integer(i8), new Integer(i9), new Integer(i10)}, (Object) null, changeQuickRedirect, true, 9411, new Class[]{float[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && i8 > 0 && i7 > 0 && i9 > 0 && i10 > 0) {
            float[] fArr2 = new float[16];
            float[] fArr3 = new float[16];
            if (i6 == 0) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
                Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
            }
            float f = ((float) i9) / ((float) i10);
            float f2 = ((float) i7) / ((float) i8);
            if (f2 <= f) {
                switch (i6) {
                    case 1:
                        Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f, f2 / f, 1.0f, 3.0f);
                        break;
                    case 2:
                        Matrix.orthoM(fArr2, 0, (-f) / f2, f / f2, -1.0f, 1.0f, 1.0f, 3.0f);
                        break;
                    case 3:
                        Matrix.orthoM(fArr2, 0, -1.0f, ((f * 2.0f) / f2) - 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
                        break;
                    case 4:
                        Matrix.orthoM(fArr2, 0, 1.0f - ((f * 2.0f) / f2), 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
                        break;
                }
            } else {
                switch (i6) {
                    case 1:
                        Matrix.orthoM(fArr2, 0, (-f) / f2, f / f2, -1.0f, 1.0f, 1.0f, 3.0f);
                        break;
                    case 2:
                        Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f, f2 / f, 1.0f, 3.0f);
                        break;
                    case 3:
                        Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, 1.0f - ((f2 * 2.0f) / f), 1.0f, 1.0f, 3.0f);
                        break;
                    case 4:
                        Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, ((f2 * 2.0f) / f) - 1.0f, 1.0f, 3.0f);
                        break;
                }
            }
            Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
    }

    public static void getCenterInsideMatrix(float[] fArr, int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{fArr, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, (Object) null, changeQuickRedirect, true, 9412, new Class[]{float[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && i2 > 0 && i > 0 && i3 > 0 && i4 > 0) {
            float f = ((float) i3) / ((float) i4);
            float f2 = ((float) i) / ((float) i2);
            float[] fArr2 = new float[16];
            float[] fArr3 = new float[16];
            if (f2 > f) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f, f2 / f, 1.0f, 3.0f);
            } else {
                Matrix.orthoM(fArr2, 0, (-f) / f2, f / f2, -1.0f, 1.0f, 1.0f, 3.0f);
            }
            Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
    }

    public static float[] rotate(float[] fArr, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, new Float(f)}, (Object) null, changeQuickRedirect, true, 9413, new Class[]{float[].class, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return fArr;
    }

    public static float[] flip(float[] fArr, boolean z, boolean z2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, changeQuickRedirect, true, 9414, new Class[]{float[].class, Boolean.TYPE, Boolean.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        if (z || z2) {
            float f = -1.0f;
            float f2 = z ? -1.0f : 1.0f;
            if (!z2) {
                f = 1.0f;
            }
            Matrix.scaleM(fArr, 0, f2, f, 1.0f);
        }
        return fArr;
    }

    public static float[] scale(float[] fArr, float f, float f2) {
        Object[] objArr = {fArr, new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9415, new Class[]{float[].class, Float.TYPE, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        return fArr;
    }

    public static float[] translate(float[] fArr, float f, float f2) {
        Object[] objArr = {fArr, new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9416, new Class[]{float[].class, Float.TYPE, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        Matrix.translateM(fArr, 0, f, f2, 0.0f);
        return fArr;
    }

    public static float[] setIdentityM(float[] fArr) {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static float[] getOriginalMatrix() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }
}
