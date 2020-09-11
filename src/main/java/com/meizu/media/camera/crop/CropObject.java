package com.meizu.media.camera.crop;

import android.graphics.RectF;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.crop.e */
public class CropObject {

    /* renamed from: a */
    public static ChangeQuickRedirect f9252a;

    /* renamed from: b */
    private BoundedRect f9253b;

    /* renamed from: c */
    private float f9254c = 1.0f;

    /* renamed from: d */
    private float f9255d = 1.0f;

    /* renamed from: e */
    private boolean f9256e = false;

    /* renamed from: f */
    private float f9257f = 0.0f;

    /* renamed from: g */
    private float f9258g = 45.0f;

    /* renamed from: h */
    private float f9259h = 20.0f;

    /* renamed from: i */
    private int f9260i = 0;

    /* renamed from: a */
    public static boolean m9728a(int i) {
        return i == 3 || i == 6 || i == 12 || i == 9;
    }

    /* renamed from: b */
    public static boolean m9729b(int i) {
        return i == 1 || i == 2 || i == 4 || i == 8;
    }

    /* renamed from: c */
    public static boolean m9730c(int i) {
        return i == 16;
    }

    /* renamed from: f */
    private static int m9733f(int i) {
        if (i == 1) {
            i |= 2;
        }
        if (i == 2) {
            i |= 1;
        }
        if (i == 4) {
            i |= 8;
        }
        return i == 8 ? i | 4 : i;
    }

    public CropObject(RectF rectF, RectF rectF2, int i) {
        this.f9253b = new BoundedRect((float) (i % 360), rectF, rectF2);
    }

    /* renamed from: a */
    public void mo19797a(RectF rectF, RectF rectF2) {
        Class[] clsArr = {RectF.class, RectF.class};
        if (!PatchProxy.proxy(new Object[]{rectF, rectF2}, this, f9252a, false, 3303, clsArr, Void.TYPE).isSupported) {
            this.f9253b.mo19777a(0.0f, rectF2, rectF);
        }
    }

    /* renamed from: a */
    public void mo19796a(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f9252a, false, 3304, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            this.f9253b.mo19780b(rectF);
        }
    }

    /* renamed from: a */
    public RectF mo19794a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9252a, false, 3306, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : this.f9253b.mo19775a();
    }

    /* renamed from: b */
    public RectF mo19799b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9252a, false, 3307, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : this.f9253b.mo19779b();
    }

    /* renamed from: c */
    public int mo19802c() {
        return this.f9260i;
    }

    /* renamed from: d */
    public boolean mo19804d() {
        return this.f9256e;
    }

    /* renamed from: a */
    public boolean mo19798a(float f, float f2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, this, f9252a, false, 3309, new Class[]{Float.TYPE, Float.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("Width and Height must be greater than zero");
        }
        RectF a = this.f9253b.mo19775a();
        CropMath.m9726b(a, f, f2);
        if (a.width() < this.f9259h || a.height() < this.f9259h) {
            return false;
        }
        this.f9254c = f;
        this.f9255d = f2;
        this.f9256e = true;
        this.f9253b.mo19778a(a);
        mo19805e();
        return true;
    }

    /* renamed from: a */
    public void mo19795a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f9252a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3310, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            if (f > 0.0f) {
                this.f9258g = f;
                return;
            }
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        }
    }

    /* renamed from: b */
    public void mo19800b(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f9252a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3311, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            if (f > 0.0f) {
                this.f9259h = f;
                return;
            }
            throw new IllegalArgumentException("Min dide must be greater than zero");
        }
    }

    /* renamed from: d */
    public static boolean m9732d(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f9252a, true, 3313, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (i == 0 || m9730c(i) || m9729b(i) || m9728a(i)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void mo19805e() {
        this.f9260i = 0;
    }

    /* renamed from: e */
    public boolean mo19806e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9252a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3315, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!m9732d(i)) {
            throw new IllegalArgumentException("bad edge selected");
        } else if (!this.f9256e || m9728a(i) || m9730c(i) || i == 0) {
            this.f9260i = i;
            return true;
        } else {
            throw new IllegalArgumentException("bad corner selected");
        }
    }

    /* renamed from: b */
    public boolean mo19801b(float f, float f2) {
        Object[] objArr = {new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect = f9252a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3316, new Class[]{Float.TYPE, Float.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int d = m9731d(f, f2);
        if (this.f9256e) {
            d = m9733f(d);
        }
        if (d == 0) {
            return false;
        }
        return mo19806e(d);
    }

    /* renamed from: c */
    public boolean mo19803c(float f, float f2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, this, f9252a, false, 3317, new Class[]{Float.TYPE, Float.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f9260i == 0) {
            return false;
        }
        RectF a = this.f9253b.mo19775a();
        float f3 = this.f9259h;
        int i = this.f9260i;
        if (i == 16) {
            this.f9253b.mo19776a(f, f2);
            return true;
        }
        int i2 = i & 1;
        float f4 = 0.0f;
        float min = i2 != 0 ? Math.min(a.left + f, a.right - f3) - a.left : 0.0f;
        int i3 = i & 2;
        if (i3 != 0) {
            f4 = Math.min(a.top + f2, a.bottom - f3) - a.top;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            min = Math.max(a.right + f, a.left + f3) - a.right;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            f4 = Math.max(a.bottom + f2, a.top + f3) - a.bottom;
        }
        if (this.f9256e) {
            float[] fArr = {a.left, a.bottom};
            float[] fArr2 = {a.right, a.top};
            if (i == 3 || i == 12) {
                fArr[1] = a.top;
                fArr2[1] = a.bottom;
            }
            float[] a2 = GeometryMathUtils.m9748a(new float[]{fArr[0] - fArr2[0], fArr[1] - fArr2[1]});
            float d = GeometryMathUtils.m9753d(new float[]{min, f4}, a2);
            this.f9253b.mo19782d(m9727a(a, i, a2[0] * d, d * a2[1]));
        } else {
            if (i2 != 0) {
                a.left += min;
            }
            if (i3 != 0) {
                a.top += f4;
            }
            if (i4 != 0) {
                a.right += min;
            }
            if (i5 != 0) {
                a.bottom += f4;
            }
            this.f9253b.mo19781c(a);
        }
        return true;
    }

    /* renamed from: d */
    private int m9731d(float f, float f2) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, this, f9252a, false, 3318, new Class[]{Float.TYPE, Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        RectF a = this.f9253b.mo19775a();
        float abs = Math.abs(f - a.left);
        float abs2 = Math.abs(f - a.right);
        float abs3 = Math.abs(f2 - a.top);
        float abs4 = Math.abs(f2 - a.bottom);
        if (abs <= this.f9258g && this.f9258g + f2 >= a.top && f2 - this.f9258g <= a.bottom && abs < abs2) {
            i = 1;
        } else if (abs2 <= this.f9258g && this.f9258g + f2 >= a.top && f2 - this.f9258g <= a.bottom) {
            i = 4;
        }
        if (abs3 > this.f9258g || this.f9258g + f < a.left || f - this.f9258g > a.right || abs3 >= abs4) {
            return (abs4 > this.f9258g || this.f9258g + f < a.left || f - this.f9258g > a.right) ? i : i | 8;
        }
        return i | 2;
    }

    /* renamed from: a */
    private static RectF m9727a(RectF rectF, int i, float f, float f2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{rectF, new Integer(i), new Float(f), new Float(f2)}, (Object) null, f9252a, true, 3319, new Class[]{RectF.class, Integer.TYPE, Float.TYPE, Float.TYPE}, RectF.class);
        if (proxy.isSupported) {
            return (RectF) proxy.result;
        }
        if (i == 12) {
            return new RectF(rectF.left, rectF.top, rectF.left + rectF.width() + f, rectF.top + rectF.height() + f2);
        }
        if (i == 9) {
            return new RectF((rectF.right - rectF.width()) + f, rectF.top, rectF.right, rectF.top + rectF.height() + f2);
        }
        if (i == 3) {
            return new RectF((rectF.right - rectF.width()) + f, (rectF.bottom - rectF.height()) + f2, rectF.right, rectF.bottom);
        }
        if (i == 6) {
            return new RectF(rectF.left, (rectF.bottom - rectF.height()) + f2, rectF.left + rectF.width() + f, rectF.bottom);
        }
        return null;
    }
}
