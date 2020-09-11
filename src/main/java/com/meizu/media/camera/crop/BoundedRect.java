package com.meizu.media.camera.crop;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Arrays;

/* renamed from: com.meizu.media.camera.crop.a */
public class BoundedRect {

    /* renamed from: a */
    public static ChangeQuickRedirect f9233a;

    /* renamed from: b */
    private float f9234b;

    /* renamed from: c */
    private RectF f9235c;

    /* renamed from: d */
    private RectF f9236d;

    /* renamed from: e */
    private float[] f9237e = CropMath.m9724a(this.f9236d);

    public BoundedRect(float f, RectF rectF, RectF rectF2) {
        this.f9234b = f;
        this.f9235c = new RectF(rectF);
        this.f9236d = new RectF(rectF2);
        m9689e();
        if (!m9687c()) {
            m9688d();
        }
    }

    /* renamed from: a */
    public void mo19777a(float f, RectF rectF, RectF rectF2) {
        Object[] objArr = {new Float(f), rectF, rectF2};
        ChangeQuickRedirect changeQuickRedirect = f9233a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3242, new Class[]{Float.TYPE, RectF.class, RectF.class}, Void.TYPE).isSupported) {
            this.f9234b = f;
            this.f9235c.set(rectF);
            this.f9236d.set(rectF2);
            this.f9237e = CropMath.m9724a(this.f9236d);
            m9689e();
            if (!m9687c()) {
                m9688d();
            }
        }
    }

    /* renamed from: a */
    public void mo19778a(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f9233a, false, 3243, new Class[]{RectF.class}, Void.TYPE).isSupported && !this.f9236d.equals(rectF)) {
            this.f9236d = rectF;
            this.f9237e = CropMath.m9724a(this.f9236d);
            m9689e();
            if (!m9687c()) {
                m9688d();
            }
        }
    }

    /* renamed from: b */
    public void mo19780b(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f9233a, false, 3245, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            rectF.set(this.f9236d);
        }
    }

    /* renamed from: a */
    public RectF mo19775a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9233a, false, 3247, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : new RectF(this.f9236d);
    }

    /* renamed from: b */
    public RectF mo19779b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9233a, false, 3248, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : new RectF(this.f9235c);
    }

    /* renamed from: a */
    public void mo19776a(float f, float f2) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, this, f9233a, false, 3249, new Class[]{Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            Matrix g = m9691g();
            RectF rectF = new RectF(this.f9236d);
            rectF.offset(f, f2);
            float[] a = CropMath.m9724a(rectF);
            float[] a2 = CropMath.m9724a(this.f9235c);
            g.mapPoints(a);
            float[] fArr = {0.0f, 0.0f};
            for (int i = 0; i < a.length; i += 2) {
                float f3 = a[i] + fArr[0];
                float f4 = a[i + 1] + fArr[1];
                if (!CropMath.m9723a(this.f9235c, f3, f4)) {
                    float[] fArr2 = {f3, f4};
                    float[] b = GeometryMathUtils.m9751b(fArr2, CropMath.m9725a(fArr2, a2));
                    fArr[0] = fArr[0] + b[0];
                    fArr[1] = fArr[1] + b[1];
                }
            }
            for (int i2 = 0; i2 < a.length; i2 += 2) {
                float f5 = a[i2] + fArr[0];
                float f6 = a[i2 + 1] + fArr[1];
                if (!CropMath.m9723a(this.f9235c, f5, f6)) {
                    float[] fArr3 = {f5, f6};
                    CropMath.m9722a(this.f9235c, fArr3);
                    fArr3[0] = fArr3[0] - f5;
                    fArr3[1] = fArr3[1] - f6;
                    fArr[0] = fArr[0] + fArr3[0];
                    fArr[1] = fArr[1] + fArr3[1];
                }
            }
            for (int i3 = 0; i3 < a.length; i3 += 2) {
                int i4 = i3 + 1;
                a[i3] = a[i3] + fArr[0];
                a[i4] = a[i4] + fArr[1];
            }
            this.f9237e = a;
            m9688d();
        }
    }

    /* renamed from: c */
    public void mo19781c(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f9233a, false, 3250, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            Matrix f = m9690f();
            Matrix g = m9691g();
            float[] a = CropMath.m9724a(this.f9235c);
            f.mapPoints(a);
            float[] a2 = CropMath.m9724a(this.f9236d);
            float[] a3 = CropMath.m9724a(rectF);
            RectF rectF2 = new RectF(rectF);
            for (int i = 0; i < a3.length; i += 2) {
                int i2 = i + 1;
                float[] fArr = {a3[i], a3[i2]};
                float[] copyOf = Arrays.copyOf(fArr, 2);
                g.mapPoints(copyOf);
                if (!CropMath.m9723a(this.f9235c, copyOf[0], copyOf[1])) {
                    float[] a4 = GeometryMathUtils.m9749a(new float[]{a3[i], a3[i2], a2[i], a2[i2]}, CropMath.m9725a(fArr, a));
                    if (a4 == null) {
                        a4 = new float[]{a2[i], a2[i2]};
                    }
                    switch (i) {
                        case 0:
                        case 1:
                            rectF2.left = a4[0] > rectF2.left ? a4[0] : rectF2.left;
                            rectF2.top = a4[1] > rectF2.top ? a4[1] : rectF2.top;
                            break;
                        case 2:
                        case 3:
                            rectF2.right = a4[0] < rectF2.right ? a4[0] : rectF2.right;
                            rectF2.top = a4[1] > rectF2.top ? a4[1] : rectF2.top;
                            break;
                        case 4:
                        case 5:
                            rectF2.right = a4[0] < rectF2.right ? a4[0] : rectF2.right;
                            rectF2.bottom = a4[1] < rectF2.bottom ? a4[1] : rectF2.bottom;
                            break;
                        case 6:
                        case 7:
                            rectF2.left = a4[0] > rectF2.left ? a4[0] : rectF2.left;
                            rectF2.bottom = a4[1] < rectF2.bottom ? a4[1] : rectF2.bottom;
                            break;
                    }
                }
            }
            float[] a5 = CropMath.m9724a(rectF2);
            g.mapPoints(a5);
            this.f9237e = a5;
            m9688d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19782d(android.graphics.RectF r18) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = 1
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r10 = 0
            r0[r10] = r8
            com.meizu.savior.ChangeQuickRedirect r2 = f9233a
            java.lang.Class[] r5 = new java.lang.Class[r9]
            java.lang.Class<android.graphics.RectF> r1 = android.graphics.RectF.class
            r5[r10] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 3251(0xcb3, float:4.556E-42)
            r1 = r17
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            android.graphics.Matrix r0 = r17.m9690f()
            android.graphics.Matrix r1 = r17.m9691g()
            android.graphics.RectF r2 = r7.f9236d
            float r2 = r2.width()
            android.graphics.RectF r3 = r7.f9236d
            float r3 = r3.height()
            float r2 = r2 / r3
            android.graphics.RectF r3 = r7.f9235c
            float[] r3 = com.meizu.media.camera.crop.CropMath.m9724a((android.graphics.RectF) r3)
            r0.mapPoints(r3)
            android.graphics.RectF r0 = r7.f9236d
            float[] r0 = com.meizu.media.camera.crop.CropMath.m9724a((android.graphics.RectF) r0)
            float[] r4 = com.meizu.media.camera.crop.CropMath.m9724a((android.graphics.RectF) r18)
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.top
            float r6 = r8.top
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            r11 = -1
            r13 = 2
            if (r5 != 0) goto L_0x006e
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.left
            float r14 = r8.left
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x0062
            r5 = 0
            goto L_0x0091
        L_0x0062:
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.right
            float r14 = r8.right
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x0090
            r5 = 2
            goto L_0x0091
        L_0x006e:
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.bottom
            float r14 = r8.bottom
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x0090
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.right
            float r14 = r8.right
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x0084
            r5 = 4
            goto L_0x0091
        L_0x0084:
            android.graphics.RectF r5 = r7.f9236d
            float r5 = r5.left
            float r14 = r8.left
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x0090
            r5 = 6
            goto L_0x0091
        L_0x0090:
            r5 = -1
        L_0x0091:
            if (r5 != r11) goto L_0x0094
            return
        L_0x0094:
            float r8 = r18.width()
            r11 = r8
            r8 = 0
        L_0x009a:
            int r14 = r4.length
            if (r8 >= r14) goto L_0x010b
            float[] r14 = new float[r13]
            r15 = r4[r8]
            r14[r10] = r15
            int r15 = r8 + 1
            r16 = r4[r15]
            r14[r9] = r16
            float[] r6 = java.util.Arrays.copyOf(r14, r13)
            r1.mapPoints(r6)
            android.graphics.RectF r13 = r7.f9235c
            r12 = r6[r10]
            r6 = r6[r9]
            boolean r6 = com.meizu.media.camera.crop.CropMath.m9723a((android.graphics.RectF) r13, (float) r12, (float) r6)
            if (r6 != 0) goto L_0x0107
            if (r8 != r5) goto L_0x00bf
            goto L_0x0107
        L_0x00bf:
            float[] r6 = com.meizu.media.camera.crop.CropMath.m9725a((float[]) r14, (float[]) r3)
            r12 = 4
            float[] r13 = new float[r12]
            r12 = r4[r8]
            r13[r10] = r12
            r12 = r4[r15]
            r13[r9] = r12
            r12 = r0[r8]
            r14 = 2
            r13[r14] = r12
            r12 = 3
            r16 = r0[r15]
            r13[r12] = r16
            float[] r6 = com.meizu.media.camera.crop.GeometryMathUtils.m9749a(r13, r6)
            if (r6 != 0) goto L_0x00e8
            float[] r6 = new float[r14]
            r12 = r0[r8]
            r6[r10] = r12
            r12 = r0[r15]
            r6[r9] = r12
        L_0x00e8:
            r12 = r0[r5]
            int r13 = r5 + 1
            r13 = r0[r13]
            r14 = r6[r10]
            float r12 = r12 - r14
            float r12 = java.lang.Math.abs(r12)
            r6 = r6[r9]
            float r13 = r13 - r6
            float r6 = java.lang.Math.abs(r13)
            float r6 = r6 * r2
            float r6 = java.lang.Math.max(r12, r6)
            int r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r12 >= 0) goto L_0x0107
            r11 = r6
        L_0x0107:
            int r8 = r8 + 2
            r13 = 2
            goto L_0x009a
        L_0x010b:
            float r0 = r11 / r2
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r7.f9236d
            r2.<init>(r3)
            if (r5 != 0) goto L_0x0121
            float r3 = r2.left
            float r3 = r3 + r11
            r2.right = r3
            float r3 = r2.top
            float r3 = r3 + r0
            r2.bottom = r3
            goto L_0x014a
        L_0x0121:
            r3 = 2
            if (r5 != r3) goto L_0x012f
            float r3 = r2.right
            float r3 = r3 - r11
            r2.left = r3
            float r3 = r2.top
            float r3 = r3 + r0
            r2.bottom = r3
            goto L_0x014a
        L_0x012f:
            r3 = 4
            if (r5 != r3) goto L_0x013d
            float r3 = r2.right
            float r3 = r3 - r11
            r2.left = r3
            float r3 = r2.bottom
            float r3 = r3 - r0
            r2.top = r3
            goto L_0x014a
        L_0x013d:
            r3 = 6
            if (r5 != r3) goto L_0x014a
            float r3 = r2.left
            float r3 = r3 + r11
            r2.right = r3
            float r3 = r2.bottom
            float r3 = r3 - r0
            r2.top = r3
        L_0x014a:
            float[] r0 = com.meizu.media.camera.crop.CropMath.m9724a((android.graphics.RectF) r2)
            r1.mapPoints(r0)
            r7.f9237e = r0
            r17.m9688d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.crop.BoundedRect.mo19782d(android.graphics.RectF):void");
    }

    /* renamed from: c */
    private boolean m9687c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9233a, false, 3252, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (int i = 0; i < 8; i += 2) {
            if (!CropMath.m9723a(this.f9235c, this.f9237e[i], this.f9237e[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private void m9688d() {
        if (!PatchProxy.proxy(new Object[0], this, f9233a, false, 3253, new Class[0], Void.TYPE).isSupported) {
            CropMath.m9722a(this.f9235c, this.f9237e);
            Matrix f = m9690f();
            float[] copyOf = Arrays.copyOf(this.f9237e, 8);
            f.mapPoints(copyOf);
            this.f9236d = CropMath.m9721a(copyOf);
        }
    }

    /* renamed from: e */
    private void m9689e() {
        if (!PatchProxy.proxy(new Object[0], this, f9233a, false, 3254, new Class[0], Void.TYPE).isSupported) {
            m9691g().mapPoints(this.f9237e);
        }
    }

    /* renamed from: f */
    private Matrix m9690f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9233a, false, 3255, new Class[0], Matrix.class);
        if (proxy.isSupported) {
            return (Matrix) proxy.result;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(this.f9234b, this.f9235c.centerX(), this.f9235c.centerY());
        return matrix;
    }

    /* renamed from: g */
    private Matrix m9691g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9233a, false, 3256, new Class[0], Matrix.class);
        if (proxy.isSupported) {
            return (Matrix) proxy.result;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.f9234b, this.f9235c.centerX(), this.f9235c.centerY());
        return matrix;
    }
}
