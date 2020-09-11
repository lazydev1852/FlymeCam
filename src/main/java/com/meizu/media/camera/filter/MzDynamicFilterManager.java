package com.meizu.media.camera.filter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzFilterPreference;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.PreferenceGroup;
import com.meizu.media.camera.PreferenceInflater;
import com.meizu.media.camera.R;
import com.meizu.media.camera.adapter.BaseViewHolder;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.FilterItemView;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.filter.c */
public class MzDynamicFilterManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10058a;

    /* renamed from: b */
    private static final LogUtil.C2630a f10059b = new LogUtil.C2630a("FilterManager");
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static final String[] f10060q = {"Mznone", "Mzxianming", "Mznuanse", "fMzanchanuan", "Mzfanchase", "Mzmenglong", "Mznense", "Mzfanchanen", "Mzyinse", "Mzheise"};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f10061c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MzFilterPreference[] f10062d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PreferenceGroup f10063e;

    /* renamed from: f */
    private MzCamParamsManager f10064f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f10065g = "Mznone";

    /* renamed from: h */
    private String f10066h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MzUIController f10067i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public MzCamUI f10068j;

    /* renamed from: k */
    private int f10069k = 12;

    /* renamed from: l */
    private boolean f10070l = false;

    /* renamed from: m */
    private boolean f10071m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public EffectRenderFactory f10072n;

    /* renamed from: o */
    private C2072b f10073o;

    /* renamed from: p */
    private C2073c f10074p;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ArrayList<String> f10075r = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Paint f10076s = new Paint();

    /* renamed from: a */
    public void mo20074a() {
    }

    public MzDynamicFilterManager(Context context, MzCamParamsManager lVar) {
        this.f10061c = context;
        this.f10064f = lVar;
        this.f10072n = EffectRenderFactory.m4739a();
        AsyncTaskEx.f13741o.execute(new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f10077a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f10077a, false, 4102, new Class[0], Void.TYPE).isSupported) {
                    PreferenceGroup unused = MzDynamicFilterManager.this.f10063e = MzDynamicFilterManager.this.m10336g((int) R.xml.mz_filter_item_array);
                    MzDynamicFilterManager.this.m10320a(MzDynamicFilterManager.this.f10063e);
                }
            }
        });
        this.f10075r.clear();
        this.f10075r.add("null");
        this.f10075r.add("Mznone");
        this.f10076s.setTextSize(10.0f);
        this.f10076s.setTextAlign(Paint.Align.LEFT);
        this.f10076s.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f10076s.setShadowLayer(2.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.mz_mode_name_shadow_color));
    }

    /* renamed from: a */
    public void mo20076a(MzUIController uVar, MzCamUI iVar) {
        this.f10067i = uVar;
        this.f10068j = iVar;
    }

    /* renamed from: b */
    private void m10325b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10058a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4074, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            m10319a(this.f10061c);
            if (i != -1 && this.f10073o != null && this.f10067i != null) {
                UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(f10060q.length));
                UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(m10333e(i));
                this.f10073o.mo20095a(i);
                this.f10067i.mo21632s(i);
            }
        }
    }

    /* renamed from: c */
    private void m10328c(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10058a, false, 4075, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            m10343n();
            LogUtil.C2630a aVar = f10059b;
            LogUtil.m15942a(aVar, "filterIndex: " + i);
            if (i != -1 && this.f10074p != null && this.f10067i != null) {
                if (this.f10075r.size() > 2) {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(this.f10075r.size() - 2));
                } else {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(0));
                }
                if (i == 0) {
                    this.f10074p.mo20095a(1);
                    this.f10067i.mo21632s(1);
                } else {
                    this.f10074p.mo20095a(i);
                    this.f10067i.mo21632s(i);
                }
                if (i <= 1) {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(m10333e(0));
                    this.f10067i.mo21528a(m10333e(0));
                    return;
                }
                UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(this.f10075r.get(i));
            }
        }
    }

    /* renamed from: b */
    private int m10322b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f10058a, false, 4076, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!m10342m()) {
            for (int i = 0; i < this.f10062d.length; i++) {
                if (f10060q[i].equals(str)) {
                    return i;
                }
            }
        } else if (this.f10075r != null) {
            for (int i2 = 0; i2 < this.f10075r.size(); i2++) {
                if (this.f10075r.get(i2).equals(str)) {
                    return i2;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void mo20077a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10058a, false, 4077, new Class[]{String.class}, Void.TYPE).isSupported && !str.equals(this.f10065g) && this.f10068j != null) {
            int b = m10322b(str);
            if (!f10060q[b].equals("Mznone")) {
                this.f10068j.mo22084a(f10060q[b]);
                if (!DeviceHelper.f13886am) {
                    this.f10068j.mo22100aG().mo17912ai();
                }
            } else if (!mo20084e() || !DeviceHelper.f13867aT || this.f10068j.mo22178o() != 1) {
                this.f10068j.mo22084a("Mznone");
                if (!DeviceHelper.f13886am) {
                    this.f10068j.mo22100aG().mo17912ai();
                }
            } else {
                this.f10068j.mo22100aG().mo17911ah();
            }
            UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(f10060q.length));
            UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(m10333e(b));
            this.f10065g = str;
            if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                m10321a(m10335f(b), new boolean[0]);
            } else {
                DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2);
            }
        }
    }

    /* renamed from: a */
    public void mo20075a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10058a, false, 4078, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            String str = this.f10075r.get(i);
            if (!str.equals(this.f10065g) && this.f10068j != null) {
                if (!str.equals("Mznone")) {
                    this.f10068j.mo22084a(str);
                    if (!DeviceHelper.f13886am) {
                        this.f10068j.mo22100aG().mo17912ai();
                    }
                } else if (!mo20084e() || !DeviceHelper.f13867aT || this.f10068j.mo22178o() != 1) {
                    this.f10068j.mo22084a("Mznone");
                    if (!DeviceHelper.f13886am) {
                        this.f10068j.mo22100aG().mo17912ai();
                    }
                } else {
                    this.f10068j.mo22100aG().mo17911ah();
                }
                if (this.f10075r.size() > 2) {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(this.f10075r.size() - 2));
                } else {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22721w(String.valueOf(0));
                }
                if (i == 1) {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(m10333e(0));
                } else {
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(this.f10075r.get(i));
                }
                this.f10065g = str;
            }
        }
    }

    /* renamed from: b */
    public void mo20081b() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4079, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10059b;
            LogUtil.m15942a(aVar, "openDynamicEffect: " + m10342m());
            if (m10342m()) {
                m10328c(m10322b(this.f10065g));
            } else {
                m10325b(m10322b(this.f10065g));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m10342m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10058a, false, 4080, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f10067i.mo21560ay();
    }

    /* renamed from: c */
    public String mo20082c() {
        return this.f10065g;
    }

    /* renamed from: d */
    public boolean mo20083d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10058a, false, 4081, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return !"Mznone".contains(this.f10065g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m10321a(java.lang.String r11, boolean... r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0082 }
            r8 = 0
            r1[r8] = r11     // Catch:{ all -> 0x0082 }
            r9 = 1
            r1[r9] = r12     // Catch:{ all -> 0x0082 }
            com.meizu.savior.ChangeQuickRedirect r3 = f10058a     // Catch:{ all -> 0x0082 }
            r4 = 0
            r5 = 4082(0xff2, float:5.72E-42)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0082 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0     // Catch:{ all -> 0x0082 }
            java.lang.Class<boolean[]> r0 = boolean[].class
            r6[r9] = r0     // Catch:{ all -> 0x0082 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0082 }
            r2 = r10
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0082 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r10)
            return
        L_0x0026:
            if (r12 == 0) goto L_0x0030
            int r0 = r12.length     // Catch:{ all -> 0x0082 }
            if (r0 <= 0) goto L_0x0030
            boolean r12 = r12[r8]     // Catch:{ all -> 0x0082 }
            if (r12 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r9 = 0
        L_0x0031:
            com.meizu.media.camera.camcontroller.CameraController r12 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x0082 }
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r12 = r12.mo19516h()     // Catch:{ all -> 0x0082 }
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1     // Catch:{ all -> 0x0082 }
            boolean r12 = r12.equals(r0)     // Catch:{ all -> 0x0082 }
            r0 = 0
            if (r12 == 0) goto L_0x005b
            com.meizu.media.camera.camcontroller.CameraController r12 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x0082 }
            com.meizu.media.camera.camcontroller.d r12 = r12.mo19522k()     // Catch:{ all -> 0x0082 }
            if (r12 == 0) goto L_0x005b
            com.meizu.media.camera.camcontroller.e r12 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r12     // Catch:{ all -> 0x0082 }
            android.hardware.Camera$Parameters r12 = r12.mo19740f()     // Catch:{ all -> 0x0082 }
            java.util.List r0 = r12.getSupportedColorEffects()     // Catch:{ all -> 0x0082 }
            java.lang.String r12 = r12.getColorEffect()     // Catch:{ all -> 0x0082 }
            goto L_0x005c
        L_0x005b:
            r12 = r0
        L_0x005c:
            boolean r0 = com.meizu.media.camera.util.CameraUtil.m15864a((java.lang.String) r11, (java.util.List<java.lang.String>) r0)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x0075
            if (r12 == 0) goto L_0x0075
            boolean r12 = r12.equals(r11)     // Catch:{ all -> 0x0082 }
            if (r12 != 0) goto L_0x0075
            com.meizu.media.camera.camcontroller.CameraController r12 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "effect"
            boolean[] r1 = new boolean[r8]     // Catch:{ all -> 0x0082 }
            r12.mo19471a((java.lang.String) r0, (java.lang.String) r11, (boolean[]) r1)     // Catch:{ all -> 0x0082 }
        L_0x0075:
            if (r9 != 0) goto L_0x0080
            com.meizu.media.camera.camcontroller.CameraController r11 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x0082 }
            boolean[] r12 = new boolean[r8]     // Catch:{ all -> 0x0082 }
            r11.mo19480a((boolean[]) r12)     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r10)
            return
        L_0x0082:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.filter.MzDynamicFilterManager.m10321a(java.lang.String, boolean[]):void");
    }

    /* renamed from: c */
    private synchronized void m10329c(String str) {
        String str2;
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[]{str}, this, f10058a, false, 4083, new Class[]{String.class}, Void.TYPE).isSupported) {
            List<String> list = null;
            if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) || (k = CameraController.m8868g().mo19522k()) == null) {
                str2 = null;
            } else {
                Camera.Parameters f = ((CameraProxyV1) k).mo19740f();
                list = f.getSupportedColorEffects();
                str2 = f.getColorEffect();
            }
            if (CameraUtil.m15864a(str, list) && str2 != null && !str2.equals(str)) {
                CameraController.m8868g().mo19471a("effect", str, new boolean[0]);
            }
            CameraController.m8868g().mo19480a(new boolean[0]);
        }
    }

    /* renamed from: a */
    public void mo20080a(boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f10058a, false, 4084, new Class[]{boolean[].class}, Void.TYPE).isSupported && !this.f10067i.mo21560ay()) {
            m10321a(m10335f(m10322b(this.f10065g)), zArr);
        }
    }

    /* renamed from: a */
    public void mo20079a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10058a, false, 4086, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10059b, "resetFilterEffect");
            if (this.f10068j != null) {
                if (mo20083d()) {
                    if (!mo20084e() || !DeviceHelper.f13867aT || this.f10068j.mo22178o() != 1) {
                        if (z2) {
                            this.f10068j.mo22084a("Mznone");
                        }
                        this.f10068j.mo22100aG().mo17912ai();
                    } else {
                        this.f10068j.mo22100aG().mo17911ah();
                    }
                    m10329c("Mznone");
                    if (z) {
                        this.f10066h = this.f10065g;
                    }
                    this.f10065g = "Mznone";
                    UsageStatsHelper.m16042a(this.f10061c.getApplicationContext()).mo22722x(m10333e(0));
                }
                if (this.f10066h != null && !"Mznone".equals(this.f10066h) && !z) {
                    this.f10066h = "Mznone";
                }
            }
        }
    }

    /* renamed from: e */
    public boolean mo20084e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10058a, false, 4087, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraModeType.m10946a().equals(CameraModeType.ModeType.AUTO);
    }

    /* renamed from: f */
    public void mo20085f() {
        this.f10070l = false;
    }

    /* renamed from: g */
    public void mo20086g() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4088, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10059b;
            LogUtil.m15942a(aVar, "restoreFilterEffect:" + this.f10066h + "mCurrentFilterEffect: " + this.f10065g);
            if (this.f10068j == null) {
                return;
            }
            if (this.f10066h != null && !"Mznone".equals(this.f10066h)) {
                this.f10065g = this.f10066h;
                int b = m10322b(this.f10065g);
                if (!m10342m()) {
                    this.f10068j.mo22084a(f10060q[b]);
                } else if (this.f10075r != null) {
                    if (b == 0) {
                        this.f10065g = "Mznone";
                        this.f10067i.mo21629r(0);
                        b = 1;
                    }
                    this.f10068j.mo22084a(this.f10075r.get(b));
                }
                if (!DeviceHelper.f13886am) {
                    this.f10068j.mo22100aG().mo17912ai();
                }
                mo20080a(new boolean[0]);
                this.f10066h = null;
            } else if (mo20083d() && this.f10066h == null) {
                int b2 = m10322b(this.f10065g);
                if (!m10342m()) {
                    this.f10068j.mo22084a(f10060q[b2]);
                } else if (this.f10075r != null) {
                    this.f10068j.mo22084a(this.f10075r.get(b2));
                }
                if (!DeviceHelper.f13886am) {
                    this.f10068j.mo22100aG().mo17912ai();
                }
                mo20080a(new boolean[0]);
            } else if (!mo20084e() || !DeviceHelper.f13867aT || this.f10068j.mo22178o() != 1) {
                this.f10068j.mo22084a("Mznone");
                if (!DeviceHelper.f13886am) {
                    this.f10068j.mo22100aG().mo17912ai();
                }
            } else {
                this.f10068j.mo22100aG().mo17911ah();
            }
        }
    }

    /* renamed from: a */
    private void m10319a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f10058a, false, 4089, new Class[]{Context.class}, Void.TYPE).isSupported) {
            if (this.f10070l || this.f10067i == null) {
                LogUtil.m15942a(f10059b, "failed to set filter adapter, since mCommonUI is null");
                return;
            }
            this.f10073o = new C2072b(context);
            this.f10067i.mo21526a((RecyclerView.C3260a) this.f10073o);
            this.f10067i.mo21525a((MzRecyclerView.C3227j) new MzRecyclerView.C3227j() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10079a;

                public void onItemClick(RecyclerView recyclerView, View view, int i, long j) {
                    Object[] objArr = {recyclerView, view, new Integer(i), new Long(j)};
                    ChangeQuickRedirect changeQuickRedirect = f10079a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4103, new Class[]{RecyclerView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
                        SelectAdapter pVar = (SelectAdapter) recyclerView.getAdapter();
                        if (i != pVar.mo23409b()) {
                            recyclerView.mo26403g(i);
                            pVar.mo23408a(false);
                            pVar.mo23410b(false);
                            pVar.mo20095a(i);
                        }
                    }
                }
            });
            this.f10073o.mo26541f();
            this.f10070l = true;
        }
    }

    /* renamed from: n */
    private void m10343n() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4090, new Class[0], Void.TYPE).isSupported) {
            if (!this.f10071m && this.f10067i != null) {
                this.f10074p = new C2073c(this.f10061c);
                this.f10067i.mo21526a((RecyclerView.C3260a) this.f10074p);
                this.f10067i.mo21525a((MzRecyclerView.C3227j) new MzRecyclerView.C3227j() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10081a;

                    public void onItemClick(RecyclerView recyclerView, View view, int i, long j) {
                        Object[] objArr = {recyclerView, view, new Integer(i), new Long(j)};
                        ChangeQuickRedirect changeQuickRedirect = f10081a;
                        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4104, new Class[]{RecyclerView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
                            SelectAdapter pVar = (SelectAdapter) recyclerView.getAdapter();
                            if (i != pVar.mo23409b()) {
                                recyclerView.mo26403g(i);
                                pVar.mo23408a(false);
                                pVar.mo23410b(false);
                                pVar.mo20095a(i);
                            }
                        }
                    }
                });
                mo20078a(EffectRenderFactory.m4739a().mo14339k());
                if (this.f10075r.size() > 0) {
                    this.f10074p.mo26541f();
                }
                this.f10071m = true;
            } else if (this.f10075r.size() > 0) {
                this.f10074p.mo26541f();
            }
        }
    }

    /* renamed from: a */
    public void mo20078a(ArrayList<String> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f10058a, false, 4091, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            synchronized (this.f10075r) {
                if (arrayList != null) {
                    try {
                        if (arrayList.size() != 0) {
                            this.f10075r.clear();
                            this.f10075r.add("null");
                            this.f10075r.add("Mznone");
                            this.f10075r.addAll(arrayList);
                            LogUtil.C2630a aVar = f10059b;
                            LogUtil.m15952c(aVar, "setLutData end: " + this.f10075r);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: h */
    public void mo20087h() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4092, new Class[0], Void.TYPE).isSupported && this.f10074p != null) {
            LogUtil.m15952c(f10059b, "notifyDataSetChanged");
            this.f10074p.mo26541f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m10313a(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f10058a, false, 4093, new Class[]{Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * this.f10061c.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: com.meizu.media.camera.filter.c$d */
    /* compiled from: MzDynamicFilterManager */
    public static class C2074d extends BaseViewHolder {

        /* renamed from: b */
        public static ChangeQuickRedirect f10096b;

        /* renamed from: c */
        EffectPreviewRenderView f10097c;

        /* renamed from: d */
        ImageView f10098d;

        /* renamed from: e */
        ImageView f10099e;

        /* renamed from: f */
        FilterItemView f10100f;

        public C2074d(View view) {
            super(view);
            this.f10100f = (FilterItemView) view.findViewById(R.id.mz_filter_item);
            this.f10098d = (ImageView) view.findViewById(R.id.mz_filter_item_bg);
            this.f10099e = (ImageView) view.findViewById(R.id.mz_filter_item_mgr);
            this.f10097c = (EffectPreviewRenderView) view.findViewById(R.id.mz_filter_item_rv);
            this.f10097c.mo14151a();
        }

        /* renamed from: a */
        public void mo18785a(boolean z) {
            int i = 0;
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10096b, false, 4118, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                ImageView imageView = this.f10098d;
                if (!z) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }

        /* renamed from: a */
        public EffectPreviewRenderView mo20102a() {
            return this.f10097c;
        }
    }

    /* renamed from: com.meizu.media.camera.filter.c$a */
    /* compiled from: MzDynamicFilterManager */
    static class C2071a extends BaseViewHolder {

        /* renamed from: b */
        public static ChangeQuickRedirect f10083b;

        /* renamed from: c */
        EffectPreviewRenderView f10084c;

        /* renamed from: d */
        ImageView f10085d;

        /* renamed from: e */
        ImageView f10086e;

        /* renamed from: f */
        FilterItemView f10087f;

        /* renamed from: g */
        TextView f10088g;

        public C2071a(View view) {
            super(view);
            this.f10087f = (FilterItemView) view.findViewById(R.id.mz_filter_item);
            this.f10085d = (ImageView) view.findViewById(R.id.mz_filter_item_bg);
            this.f10086e = (ImageView) view.findViewById(R.id.mz_filter_item_mgr);
            this.f10088g = (TextView) view.findViewById(R.id.mz_filter_item_mgr_text);
            this.f10084c = (EffectPreviewRenderView) view.findViewById(R.id.mz_filter_item_rv);
            this.f10084c.mo14151a();
        }

        /* renamed from: a */
        public void mo18785a(boolean z) {
            int i = 0;
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10083b, false, 4105, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                ImageView imageView = this.f10085d;
                if (!z) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.filter.c$b */
    /* compiled from: MzDynamicFilterManager */
    public class C2072b extends SelectAdapter<C2074d> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10089a;

        /* renamed from: f */
        private LayoutInflater f10091f;

        /* renamed from: c */
        public long mo20100c(int i) {
            return (long) i;
        }

        public C2072b(Context context) {
            this.f10091f = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public C2074d mo20098b(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f10089a, false, 4106, new Class[]{ViewGroup.class, Integer.TYPE}, C2074d.class);
            return proxy.isSupported ? (C2074d) proxy.result : new C2074d(this.f10091f.inflate(R.layout.mz_list_filter_item, viewGroup, false));
        }

        /* renamed from: a */
        public void mo20097a(RecyclerView.C3286u uVar, int i) {
            if (!PatchProxy.proxy(new Object[]{uVar, new Integer(i)}, this, f10089a, false, 4107, new Class[]{RecyclerView.C3286u.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C2074d dVar = (C2074d) uVar;
                dVar.f10097c.setRender(MzDynamicFilterManager.this.f10072n.mo14329c(MzDynamicFilterManager.this.f10072n.mo14321a(MzDynamicFilterManager.f10060q[i])));
                dVar.f10099e.setVisibility(8);
                if (i == 0) {
                    dVar.mo18785a(true);
                } else {
                    dVar.mo18785a(false);
                }
            }
        }

        /* renamed from: a */
        public void mo20096a(RecyclerView.C3286u uVar) {
            if (!PatchProxy.proxy(new Object[]{uVar}, this, f10089a, false, 4108, new Class[]{RecyclerView.C3286u.class}, Void.TYPE).isSupported) {
                super.mo20096a(uVar);
                ((C2074d) uVar).f10097c.mo14152b();
            }
        }

        /* renamed from: a */
        public void mo20095a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10089a, false, 4109, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (!(this.f15559c == i || MzDynamicFilterManager.this.f10067i == null || MzDynamicFilterManager.this.m10342m())) {
                    MzDynamicFilterManager.this.f10067i.mo21629r(i);
                    if (this.f15560d) {
                        DeviceUtil.m16194a(MzDynamicFilterManager.this.f10067i.mo21541af(), 22507);
                    }
                    MzDynamicFilterManager.this.f10067i.mo21528a(MzDynamicFilterManager.this.m10333e(i));
                    MzDynamicFilterManager.this.mo20077a(MzDynamicFilterManager.f10060q[i]);
                }
                super.mo20095a(i);
                super.mo23408a(false);
            }
        }

        /* renamed from: b */
        public void mo20099b(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f10089a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4110, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && !MzDynamicFilterManager.this.m10342m()) {
                MzDynamicFilterManager.this.f10068j.mo22084a(MzDynamicFilterManager.f10060q[i]);
                MzDynamicFilterManager.this.f10067i.mo21528a(MzDynamicFilterManager.this.m10333e(i));
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    String unused = MzDynamicFilterManager.this.f10065g = MzDynamicFilterManager.f10060q[i];
                }
                UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22721w(String.valueOf(MzDynamicFilterManager.f10060q.length));
                UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22722x(MzDynamicFilterManager.this.m10333e(i));
            }
        }

        /* renamed from: a */
        public int mo20093a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10089a, false, 4111, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            if (MzDynamicFilterManager.this.f10062d != null) {
                return MzDynamicFilterManager.this.f10062d.length;
            }
            return 0;
        }
    }

    /* renamed from: com.meizu.media.camera.filter.c$c */
    /* compiled from: MzDynamicFilterManager */
    public class C2073c extends SelectAdapter<C2071a> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10092a;

        /* renamed from: f */
        private LayoutInflater f10094f;

        /* renamed from: g */
        private int f10095g = 1;

        /* renamed from: c */
        public long mo20100c(int i) {
            return (long) i;
        }

        public C2073c(Context context) {
            this.f10094f = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public C2071a mo20098b(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f10092a, false, 4112, new Class[]{ViewGroup.class, Integer.TYPE}, C2071a.class);
            return proxy.isSupported ? (C2071a) proxy.result : new C2071a(this.f10094f.inflate(R.layout.mz_list_filter_item, viewGroup, false));
        }

        /* renamed from: a */
        public void mo20097a(RecyclerView.C3286u uVar, int i) {
            Object[] objArr = {uVar, new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f10092a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4113, new Class[]{RecyclerView.C3286u.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C2071a aVar = (C2071a) uVar;
                if (i == 0) {
                    aVar.f10086e.setVisibility(0);
                    aVar.f10088g.setVisibility(0);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.f10088g.getLayoutParams();
                    layoutParams.leftMargin = MzDynamicFilterManager.this.m10313a((float) (23 - ((int) (MzDynamicFilterManager.this.f10076s.measureText(aVar.f10088g.getText().toString()) / 2.0f))));
                    aVar.f10088g.setLayoutParams(layoutParams);
                    aVar.f10084c.setVisibility(8);
                    return;
                }
                aVar.f10086e.setVisibility(8);
                aVar.f10088g.setVisibility(8);
                aVar.f10084c.setVisibility(0);
                aVar.f10084c.setRender(EffectRenderFactory.m4739a().mo14329c(EffectRenderFactory.m4739a().mo14321a((String) MzDynamicFilterManager.this.f10075r.get(i))));
            }
        }

        /* renamed from: a */
        public void mo20096a(RecyclerView.C3286u uVar) {
            if (!PatchProxy.proxy(new Object[]{uVar}, this, f10092a, false, 4114, new Class[]{RecyclerView.C3286u.class}, Void.TYPE).isSupported) {
                super.mo20096a(uVar);
                ((C2071a) uVar).f10084c.mo14152b();
            }
        }

        /* renamed from: a */
        public void mo20095a(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10092a, false, 4115, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (MzDynamicFilterManager.this.f10067i != null && MzDynamicFilterManager.this.m10342m()) {
                    if (this.f15559c != i) {
                        if (i > 0) {
                            MzDynamicFilterManager.this.f10067i.mo21629r(i - 1);
                        }
                        if (this.f15560d) {
                            DeviceUtil.m16194a(MzDynamicFilterManager.this.f10067i.mo21541af(), 22507);
                        }
                    }
                    if (i == 0) {
                        MzDynamicFilterManager.this.f10067i.mo21528a("");
                        MzDynamicFilterManager.this.mo20088i();
                    } else if (i == 1) {
                        MzDynamicFilterManager.this.f10067i.mo21528a(MzDynamicFilterManager.this.m10333e(0));
                        MzDynamicFilterManager.this.mo20075a(i);
                    } else {
                        MzDynamicFilterManager.this.f10067i.mo21528a((String) MzDynamicFilterManager.this.f10075r.get(i));
                        if (!((String) MzDynamicFilterManager.this.f10075r.get(i)).equals(MzDynamicFilterManager.this.f10065g)) {
                            MzDynamicFilterManager.this.mo20075a(i);
                        }
                    }
                }
                super.mo20095a(i);
                super.mo23408a(false);
            }
        }

        /* renamed from: b */
        public void mo20099b(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10092a, false, 4116, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && MzDynamicFilterManager.this.m10342m()) {
                this.f10095g = i;
                if (i != 0) {
                    MzDynamicFilterManager.this.f10068j.mo22084a((String) MzDynamicFilterManager.this.f10075r.get(i));
                    if (i == 1) {
                        MzDynamicFilterManager.this.f10067i.mo21528a(MzDynamicFilterManager.this.m10333e(0));
                        UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22722x(MzDynamicFilterManager.this.m10333e(0));
                    } else {
                        MzDynamicFilterManager.this.f10067i.mo21528a((String) MzDynamicFilterManager.this.f10075r.get(i));
                        UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22722x((String) MzDynamicFilterManager.this.f10075r.get(i));
                    }
                    String unused = MzDynamicFilterManager.this.f10065g = (String) MzDynamicFilterManager.this.f10075r.get(i);
                    if (MzDynamicFilterManager.this.f10075r.size() > 2) {
                        UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22721w(String.valueOf(MzDynamicFilterManager.this.f10075r.size() - 2));
                    } else {
                        UsageStatsHelper.m16042a(MzDynamicFilterManager.this.f10061c.getApplicationContext()).mo22721w(String.valueOf(0));
                    }
                } else {
                    MzDynamicFilterManager.this.f10067i.mo21528a("");
                }
            }
        }

        /* renamed from: a */
        public int mo20093a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10092a, false, 4117, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            if (MzDynamicFilterManager.this.f10075r != null) {
                return MzDynamicFilterManager.this.f10075r.size();
            }
            return 1;
        }
    }

    /* renamed from: i */
    public void mo20088i() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4094, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10059b, "onLutMarClick");
            this.f10067i.mo21561az();
        }
    }

    /* renamed from: d */
    private boolean m10330d(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10058a, false, 4095, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10062d == null || this.f10062d[i] == null) {
            return false;
        }
        if (i >= this.f10062d.length) {
            LogUtil.m15949b(f10059b, "Filter array index error!!!");
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m10333e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10058a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4096, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (m10330d(i)) {
            return this.f10062d[i].mo18346a();
        }
        return null;
    }

    /* renamed from: f */
    private String m10335f(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10058a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (m10330d(i)) {
            return this.f10062d[i].mo18349e();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public PreferenceGroup m10336g(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10058a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, InputDeviceCompat.SOURCE_TOUCHSCREEN, new Class[]{Integer.TYPE}, PreferenceGroup.class);
        if (proxy.isSupported) {
            return (PreferenceGroup) proxy.result;
        }
        return (PreferenceGroup) new PreferenceInflater(this.f10061c).mo22769a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10320a(PreferenceGroup preferenceGroup) {
        int c;
        if (!PatchProxy.proxy(new Object[]{preferenceGroup}, this, f10058a, false, FragmentTransaction.TRANSIT_FRAGMENT_FADE, new Class[]{PreferenceGroup.class}, Void.TYPE).isSupported && preferenceGroup != null && (c = preferenceGroup.mo18594c()) > 0) {
            this.f10062d = new MzFilterPreference[c];
            for (int i = 0; i < c; i++) {
                this.f10062d[i] = (MzFilterPreference) this.f10063e.mo18591a(i);
            }
        }
    }

    /* renamed from: j */
    public void mo20089j() {
        if (PatchProxy.proxy(new Object[0], this, f10058a, false, 4100, new Class[0], Void.TYPE).isSupported || this.f10068j == null) {
            return;
        }
        if (mo20083d()) {
            int b = m10322b(this.f10065g);
            if (!m10342m()) {
                this.f10068j.mo22084a(f10060q[b]);
            } else if (this.f10075r != null) {
                this.f10068j.mo22084a(this.f10075r.get(b));
            }
        } else {
            this.f10068j.mo22141b("Mznone");
        }
    }

    /* renamed from: k */
    public void mo20090k() {
        if (!PatchProxy.proxy(new Object[0], this, f10058a, false, 4101, new Class[0], Void.TYPE).isSupported) {
            this.f10074p.mo20095a(1);
            this.f10067i.mo21632s(1);
        }
    }
}
