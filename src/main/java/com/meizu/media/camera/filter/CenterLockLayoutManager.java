package com.meizu.media.camera.filter;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.LinearSmoothScroller;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: com.meizu.media.camera.filter.a */
public class CenterLockLayoutManager extends LinearLayoutManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10037a;

    /* renamed from: f */
    private static float f10038f = ((float) (Math.log(0.78d) / Math.log(0.9d)));

    /* renamed from: g */
    private static double f10039g = 0.84d;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f10040b = 50.0f;

    /* renamed from: c */
    private Context f10041c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f10042d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f10043e;

    /* renamed from: h */
    private int f10044h;

    /* renamed from: i */
    private double f10045i;

    public CenterLockLayoutManager(Context context, int i, int i2, int i3) {
        super(context);
        this.f10041c = context;
        this.f10042d = i2;
        this.f10043e = i3;
        this.f10044h = i;
        m10301c();
        m10297a(context);
    }

    /* renamed from: a */
    public void mo20065a(RecyclerView recyclerView, RecyclerView.C3283r rVar, int i) {
        Object[] objArr = {recyclerView, rVar, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10037a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4052, new Class[]{RecyclerView.class, RecyclerView.C3283r.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C2067a aVar = new C2067a(recyclerView.getContext());
            aVar.mo26730d(i);
            mo26590a((RecyclerView.C3280q) aVar);
        }
    }

    /* renamed from: a */
    private void m10297a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f10037a, false, 4053, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f10045i = ((double) context.getResources().getDisplayMetrics().density) * 386.0885886511961d * 160.0d * f10039g;
        }
    }

    /* renamed from: a */
    private View m10296a(LinearLayoutManager linearLayoutManager) {
        int top;
        int bottom;
        boolean z = true;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{linearLayoutManager}, this, f10037a, false, 4054, new Class[]{LinearLayoutManager.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        View view = null;
        int i = 0;
        for (int o = linearLayoutManager.mo26101o(); o <= linearLayoutManager.mo26102p() && z; o++) {
            View c = linearLayoutManager.mo26080c(o);
            if (linearLayoutManager.mo26093h() == 0) {
                top = c.getLeft();
                bottom = c.getRight();
            } else {
                top = c.getTop();
                bottom = c.getBottom();
            }
            int abs = Math.abs(this.f10044h - ((top + bottom) / 2));
            if (abs <= i || o == linearLayoutManager.mo26101o()) {
                view = c;
                i = abs;
            } else {
                z = false;
            }
        }
        return view;
    }

    /* renamed from: a */
    public int mo20064a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10037a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4055, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (mo26658x() == 0) {
            return 0;
        }
        if (mo26093h() == 0) {
            return m10295a(i, mo26641i(0).getLeft(), mo26641i(0).getWidth(), mo26623d(m10296a((LinearLayoutManager) this)));
        }
        return m10295a(i2, mo26641i(0).getTop(), mo26641i(0).getHeight(), mo26623d(m10296a((LinearLayoutManager) this)));
    }

    /* renamed from: a */
    private int m10295a(int i, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f10037a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4056, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        double a = m10293a((double) i);
        if (i <= 0) {
            a = -a;
        }
        if (Math.abs(i) < 400) {
            return i4;
        }
        if (i < 0) {
            return (int) Math.max(((double) i4) + (a / ((double) this.f10042d)), 0.0d);
        }
        return (int) (((double) i4) + (a / ((double) this.f10042d)) + 1.0d);
    }

    /* renamed from: a */
    private double m10293a(double d) {
        Object[] objArr = {new Double(d)};
        ChangeQuickRedirect changeQuickRedirect = f10037a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4057, new Class[]{Double.TYPE}, Double.TYPE);
        if (proxy.isSupported) {
            return ((Double) proxy.result).doubleValue();
        }
        double b = m10298b(d);
        return ((double) ViewConfiguration.getScrollFriction()) * this.f10045i * Math.exp((((double) f10038f) / (((double) f10038f) - 1.0d)) * b);
    }

    /* renamed from: b */
    private double m10298b(double d) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Double(d)}, this, f10037a, false, 4058, new Class[]{Double.TYPE}, Double.TYPE);
        return proxy.isSupported ? ((Double) proxy.result).doubleValue() : Math.log((Math.abs(d) * 0.3499999940395355d) / (((double) ViewConfiguration.getScrollFriction()) * this.f10045i));
    }

    /* renamed from: com.meizu.media.camera.filter.a$a */
    /* compiled from: CenterLockLayoutManager */
    private class C2067a extends LinearSmoothScroller {

        /* renamed from: a */
        public static ChangeQuickRedirect f10046a;

        C2067a(Context context) {
            super(context);
        }

        /* renamed from: a */
        public int mo20067a(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        /* renamed from: a */
        public float mo20066a(DisplayMetrics displayMetrics) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{displayMetrics}, this, f10046a, false, 4060, new Class[]{DisplayMetrics.class}, Float.TYPE);
            return proxy.isSupported ? ((Float) proxy.result).floatValue() : CenterLockLayoutManager.this.f10040b / displayMetrics.density;
        }

        /* renamed from: a */
        public void mo20069a(View view, RecyclerView.C3283r rVar, RecyclerView.C3280q.C3281a aVar) {
            int i;
            int i2;
            Class[] clsArr = {View.class, RecyclerView.C3283r.class, RecyclerView.C3280q.C3281a.class};
            if (!PatchProxy.proxy(new Object[]{view, rVar, aVar}, this, f10046a, false, 4061, clsArr, Void.TYPE).isSupported && mo26732e() != null) {
                int b = mo27201b(view, mo27202c());
                int a = mo27198a(view, mo27204d());
                if (b > 0) {
                    i = (b - mo26732e().mo26649n(view)) - ((CenterLockLayoutManager.this.f10043e - CenterLockLayoutManager.this.f10042d) / 2);
                } else {
                    i = b + mo26732e().mo26650o(view) + ((CenterLockLayoutManager.this.f10043e - CenterLockLayoutManager.this.f10042d) / 2);
                }
                if (a > 0) {
                    i2 = a - mo26732e().mo26646l(view);
                } else {
                    i2 = a + mo26732e().mo26648m(view);
                }
                int b2 = mo27200b((int) Math.sqrt((double) ((i * i) + (i2 * i2))));
                if (b2 > 0) {
                    aVar.mo26739a(-i, -i2, b2, new DecelerateInterpolator());
                }
            }
        }

        /* renamed from: a */
        public PointF mo20068a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f10046a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4062, new Class[]{Integer.TYPE}, PointF.class);
            if (proxy.isSupported) {
                return (PointF) proxy.result;
            }
            return CenterLockLayoutManager.this.mo26084d(i);
        }
    }

    /* renamed from: c */
    private void m10301c() {
        if (!PatchProxy.proxy(new Object[0], this, f10037a, false, 4059, new Class[0], Void.TYPE).isSupported) {
            this.f10040b = this.f10041c.getResources().getDisplayMetrics().density * 0.3f;
        }
    }
}
