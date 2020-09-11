package com.meizu.media.camera;

import android.content.Context;
import android.provider.Settings;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.media.camera.agegender.AgeGenderEngine;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p068e.AlorgrithmManager;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.n */
public class MzFacebeautyManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f11361a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final LogUtil.C2630a f11362c = new LogUtil.C2630a("MzFacebeautyManager");

    /* renamed from: b */
    protected C2252a f11363b = new C2252a();

    /* renamed from: d */
    private int f11364d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f11365e;

    /* renamed from: f */
    private BaseRender f11366f;

    /* renamed from: g */
    private PreviewView f11367g;

    /* renamed from: h */
    private MzCamUI f11368h;

    /* renamed from: i */
    private MzUIController f11369i;

    /* renamed from: j */
    private MzCamParamsManager f11370j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MzCamController f11371k;

    /* renamed from: l */
    private boolean f11372l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f11373m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f11374n = 6;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11375o = 5;

    /* renamed from: p */
    private int f11376p = 1;

    /* renamed from: q */
    private int f11377q = 0;

    public MzFacebeautyManager(Context context, MzCamParamsManager lVar, boolean z) {
        this.f11365e = context;
        this.f11370j = lVar;
        this.f11373m = z;
        AsyncTaskEx.f13741o.execute(new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f11378a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f11378a, false, 1682, new Class[0], Void.TYPE).isSupported) {
                    MzFacebeautyManager.this.f11363b.mo20781a();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo20767a(MzUIController uVar, MzCamUI iVar, MzCamController mzCamController) {
        Class[] clsArr = {MzUIController.class, MzCamUI.class, MzCamController.class};
        if (!PatchProxy.proxy(new Object[]{uVar, iVar, mzCamController}, this, f11361a, false, 1657, clsArr, Void.TYPE).isSupported) {
            this.f11368h = iVar;
            this.f11369i = uVar;
            this.f11367g = iVar.mo22113ab();
            this.f11371k = mzCamController;
            this.f11371k.mo17871T();
        }
    }

    /* renamed from: a */
    public int mo20764a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11361a, false, 1658, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = this.f11363b.mo20784b();
        if (b == 1) {
            return 1;
        }
        return b == 5 ? 2 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d4, code lost:
        r10 = r9.f11368h.mo22157f();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20765a(int r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f11361a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 1659(0x67b, float:2.325E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            switch(r10) {
                case 0: goto L_0x00bb;
                case 1: goto L_0x0072;
                case 2: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0122
        L_0x0027:
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            java.lang.String r1 = "Mzvfacebeauty"
            r10.mo22147c((java.lang.String) r1)
            r10 = 5
            r9.m12358e((int) r10)
            java.lang.String r1 = "autoFacebeautyLevel"
            r9.m12350a((java.lang.String) r1, (int) r10)
            r9.m12363m()
            r9.m12352b((boolean) r0)
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x005a
            com.meizu.media.camera.l r10 = r9.f11370j
            boolean[] r0 = new boolean[r0]
            r0[r8] = r8
            r10.mo20332b((boolean[]) r0)
            com.meizu.media.camera.n$a r10 = r9.f11363b
            int r10 = r10.mo20784b()
            com.meizu.media.camera.p068e.AlorgrithmManager.m10019a((int) r10)
            goto L_0x006d
        L_0x005a:
            boolean r10 = r9.mo20777g()
            if (r10 == 0) goto L_0x0069
            com.meizu.media.camera.n$a r10 = r9.f11363b
            int r10 = r10.mo20784b()
            com.meizu.media.camera.p068e.AlorgrithmManager.m10019a((int) r10)
        L_0x0069:
            r10 = 3
            r9.mo20770b((int) r10)
        L_0x006d:
            r9.m12351a((boolean) r8)
            goto L_0x0122
        L_0x0072:
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            java.lang.String r1 = "Mzvfacebeauty"
            r10.mo22147c((java.lang.String) r1)
            java.lang.String r10 = "autoFacebeautyLevel"
            r9.m12350a((java.lang.String) r10, (int) r0)
            r9.m12358e((int) r0)
            r9.m12363m()
            r9.m12352b((boolean) r0)
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x00a4
            com.meizu.media.camera.l r10 = r9.f11370j
            boolean[] r0 = new boolean[r0]
            r0[r8] = r8
            r10.mo20332b((boolean[]) r0)
            com.meizu.media.camera.n$a r10 = r9.f11363b
            int r10 = r10.mo20784b()
            com.meizu.media.camera.p068e.AlorgrithmManager.m10019a((int) r10)
            goto L_0x00b7
        L_0x00a4:
            boolean r10 = r9.mo20777g()
            if (r10 == 0) goto L_0x00b3
            com.meizu.media.camera.n$a r10 = r9.f11363b
            int r10 = r10.mo20784b()
            com.meizu.media.camera.p068e.AlorgrithmManager.m10019a((int) r10)
        L_0x00b3:
            r10 = 2
            r9.mo20770b((int) r10)
        L_0x00b7:
            r9.m12351a((boolean) r8)
            goto L_0x0122
        L_0x00bb:
            java.lang.String r10 = "autoFacebeautyLevel"
            r9.m12350a((java.lang.String) r10, (int) r8)
            r9.m12364n()
            r9.m12352b((boolean) r8)
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x00f8
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            if (r10 == 0) goto L_0x00ea
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            com.meizu.camera.effectlib.effects.b.a r10 = r10.mo22157f()
            if (r10 == 0) goto L_0x00ea
            com.meizu.camera.effectlib.effects.views.b$c r10 = r10.mo14046c()
            java.lang.String r10 = r10.mo14345d()
            java.lang.String r1 = "Mzvfacebeauty"
            if (r10 == r1) goto L_0x00ea
            r10 = 0
            goto L_0x00eb
        L_0x00ea:
            r10 = 1
        L_0x00eb:
            r9.m12355c((boolean) r10)
            com.meizu.media.camera.l r10 = r9.f11370j
            boolean[] r1 = new boolean[r0]
            r1[r8] = r8
            r10.mo20332b((boolean[]) r1)
            goto L_0x011f
        L_0x00f8:
            boolean r10 = com.meizu.media.camera.util.DeviceHelper.f13867aT
            if (r10 == 0) goto L_0x0112
            com.meizu.media.camera.MzCamController r10 = r9.f11371k
            int r10 = r10.mo17871T()
            if (r10 != r0) goto L_0x0112
            r9.mo20770b((int) r0)
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            java.lang.String r1 = "Mzvfacebeauty"
            r10.mo22147c((java.lang.String) r1)
            r9.m12358e((int) r8)
            goto L_0x011f
        L_0x0112:
            r9.mo20770b((int) r8)
            com.meizu.media.camera.ui.i r10 = r9.f11368h
            java.lang.String r1 = "Mznone"
            r10.mo22147c((java.lang.String) r1)
            r9.m12355c((boolean) r0)
        L_0x011f:
            r9.m12351a((boolean) r0)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzFacebeautyManager.mo20765a(int):void");
    }

    /* renamed from: a */
    private void m12351a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11361a, false, 1660, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11380a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11380a, false, 1683, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    MzFacebeautyManager.this.f11371k.mo17948k(false);
                    MzFacebeautyManager.this.f11371k.mo17933b(true);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: b */
    private void m12352b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11361a, false, 1661, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11362c;
            LogUtil.m15942a(aVar, "setFBMode" + z);
            this.f11370j.mo20335c(z, false);
        }
    }

    /* renamed from: b */
    public void mo20770b(int i) {
        String str;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11361a, false, 1662, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (mo20777g()) {
                str = String.valueOf(0);
            } else {
                str = String.valueOf(i);
            }
            LogUtil.C2630a aVar = f11362c;
            LogUtil.m15942a(aVar, "setHalFBLevel:" + str);
            this.f11370j.mo20321a(str, false);
            this.f11377q = i;
        }
    }

    /* renamed from: c */
    public void mo20772c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11361a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1663, new Class[]{Integer.TYPE}, Void.TYPE).isSupported || this.f11363b.mo20784b() != 1) {
            return;
        }
        if (i == AgeGenderEngine.f7572c) {
            if (this.f11377q != 4) {
                mo20770b(4);
            }
        } else if (this.f11377q != 2) {
            mo20770b(2);
        }
    }

    /* renamed from: b */
    public void mo20769b() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1664, new Class[0], Void.TYPE).isSupported && mo20776f() && this.f11363b.mo20784b() > 0) {
            m12364n();
        }
    }

    /* renamed from: a */
    public void mo20768a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11361a, false, 1665, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f11362c, "resumeFbEffect");
            if (z) {
                if (z2) {
                    m12361k();
                    if (this.f11363b.mo20784b() == 0) {
                        this.f11363b.mo20785b(1);
                    }
                    this.f11368h.mo22147c("Mzvfacebeauty");
                    m12362l();
                    m12363m();
                    m12352b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        AlorgrithmManager.m10019a(this.f11363b.mo20784b());
                        this.f11370j.mo20332b(false);
                    } else {
                        if (mo20777g()) {
                            AlorgrithmManager.m10019a(this.f11363b.mo20784b());
                        }
                        if (this.f11363b.mo20784b() == 0) {
                            if (!DeviceHelper.f13867aT || this.f11371k.mo17871T() != 1) {
                                mo20770b(0);
                            } else {
                                mo20770b(1);
                            }
                        } else if (this.f11363b.mo20784b() == 1) {
                            mo20770b(2);
                        } else if (this.f11363b.mo20784b() == 5) {
                            mo20770b(3);
                        }
                    }
                    m12351a(false);
                    return;
                }
                m12355c(true);
                m12364n();
                m12352b(false);
                if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                    this.f11370j.mo20332b(false);
                } else if (!DeviceHelper.f13867aT || this.f11371k.mo17871T() != 1) {
                    mo20770b(0);
                } else {
                    mo20770b(1);
                }
                m12351a(true);
            } else if (mo20776f()) {
                m12361k();
                if (this.f11363b.mo20784b() <= 0 || this.f11368h == null) {
                    m12352b(false);
                    m12364n();
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        this.f11370j.mo20332b(false);
                    } else if (!DeviceHelper.f13867aT || this.f11371k.mo17871T() != 1) {
                        m12355c(true);
                    } else {
                        mo20770b(1);
                        this.f11368h.mo22147c("Mzvfacebeauty");
                        m12358e(0);
                    }
                    m12351a(true);
                } else {
                    this.f11368h.mo22147c("Mzvfacebeauty");
                    m12362l();
                    m12363m();
                    m12352b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        AlorgrithmManager.m10019a(this.f11363b.mo20784b());
                        this.f11370j.mo20332b(false);
                    } else {
                        if (mo20777g()) {
                            AlorgrithmManager.m10019a(this.f11363b.mo20784b());
                        }
                        if (this.f11363b.mo20784b() == 1) {
                            mo20770b(2);
                        } else if (this.f11363b.mo20784b() == 5) {
                            mo20770b(3);
                        }
                    }
                    m12351a(false);
                }
                if (this.f11369i != null) {
                    this.f11369i.mo21626q(mo20764a());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20766a(CameraModeType.ModeType modeType) {
        if (!PatchProxy.proxy(new Object[]{modeType}, this, f11361a, false, 1666, new Class[]{CameraModeType.ModeType.class}, Void.TYPE).isSupported) {
            if (!modeType.equals(CameraModeType.ModeType.AUTO) && !modeType.equals(CameraModeType.ModeType.BACK_LIGHTING) && !modeType.equals(CameraModeType.ModeType.SUPER_NIGHT)) {
                return;
            }
            if (this.f11363b.mo20784b() > 0 || DeviceHelper.f13867aT) {
                LogUtil.m15942a(f11362c, "onModeRelease");
                m12355c(true);
                m12364n();
            }
        }
    }

    /* renamed from: c */
    public void mo20771c() {
        if (PatchProxy.proxy(new Object[0], this, f11361a, false, 1667, new Class[0], Void.TYPE).isSupported || !mo20776f()) {
            return;
        }
        if (this.f11363b.mo20784b() > 0 || DeviceHelper.f13867aT) {
            LogUtil.m15942a(f11362c, "onPreCameraSwitch");
            m12355c(true);
            m12364n();
        }
    }

    /* renamed from: d */
    public void mo20773d() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1668, new Class[0], Void.TYPE).isSupported && mo20776f() && this.f11363b.mo20784b() > 0) {
            m12355c(true);
            m12364n();
            if (this.f11369i != null) {
                this.f11369i.mo21626q(0);
            }
        }
    }

    /* renamed from: e */
    public void mo20775e() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1669, new Class[0], Void.TYPE).isSupported && mo20776f()) {
            m12361k();
            if (this.f11363b.mo20784b() > 0 && this.f11368h != null) {
                this.f11368h.mo22147c("Mzvfacebeauty");
                m12362l();
                m12363m();
                if (this.f11363b.mo20784b() == 1) {
                    mo20770b(2);
                } else if (this.f11363b.mo20784b() == 5) {
                    mo20770b(3);
                }
            }
            if (this.f11369i != null) {
                this.f11369i.mo21626q(mo20764a());
            }
        }
    }

    /* renamed from: f */
    public boolean mo20776f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11361a, false, 1670, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraModeType.m10983m(CameraModeType.ModeType.AUTO) || (((CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) && this.f11368h.mo22178o() == 1) || CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING)) && DeviceHelper.f14025dq)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo20777g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11361a, false, 1671, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ((((!CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) || this.f11368h.mo22178o() != 1) && !CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING)) || !DeviceHelper.f14025dq) && (!CameraModeType.m10983m(CameraModeType.ModeType.AUTO) || !DeviceHelper.f13909bI)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private void m12355c(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11361a, false, 1672, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f11362c, "cleanFbEffect");
            this.f11363b.mo20785b(0);
            if (this.f11368h != null && z) {
                this.f11368h.mo22147c("Mznone");
            }
            this.f11366f = null;
            mo20770b(0);
            m12360j();
        }
    }

    /* renamed from: h */
    public void mo20778h() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1673, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11362c, "setWeakFbEffect");
            mo20770b(1);
            this.f11368h.mo22147c("Mzvfacebeauty");
            m12358e(0);
        }
    }

    /* renamed from: j */
    private void m12360j() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1674, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13886am) {
                this.f11366f = this.f11367g.getVfbRender();
            } else {
                this.f11366f = this.f11367g.getRender();
            }
            if (this.f11366f != null) {
                this.f11366f.mo14042a("eyeEnlargement-Strength", (Object) 0);
                this.f11366f.mo14042a("slimming-Strength", (Object) 0);
                this.f11366f.mo14042a("toning-Strength", (Object) 0);
                this.f11366f.mo14042a("smoothing-Strength", (Object) 0);
            }
        }
    }

    /* renamed from: e */
    private void m12358e(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11361a, false, 1675, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f11363b.mo20785b(i);
            if (DeviceHelper.f13886am) {
                this.f11366f = this.f11367g.getVfbRender();
            } else {
                this.f11366f = this.f11367g.getRender();
            }
            if (this.f11366f != null) {
                this.f11366f.mo14042a("smoothing-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(i)[0]));
                this.f11366f.mo14042a("toning-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(i)[1]));
                this.f11366f.mo14042a("slimming-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(i)[2]));
                this.f11366f.mo14042a("eyeEnlargement-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(i)[3]));
                this.f11366f.mo14042a("skinbright-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[4]));
                this.f11366f.mo14042a("skinauto-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[5]));
            }
        }
    }

    /* renamed from: d */
    public void mo20774d(int i) {
        int b;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11361a, false, 1676, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (b = this.f11363b.mo20784b()) == 1) {
            if (DeviceHelper.f13886am) {
                this.f11366f = this.f11367g.getVfbRender();
            } else {
                this.f11366f = this.f11367g.getRender();
            }
            int i2 = i == AgeGenderEngine.f7572c ? 1 : 0;
            if (this.f11366f != null) {
                this.f11366f.mo14042a("smoothing-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[0]));
                this.f11366f.mo14042a("toning-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[1]));
                this.f11366f.mo14042a("slimming-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[2]));
                this.f11366f.mo14042a("eyeEnlargement-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[3]));
                this.f11366f.mo14042a("skinbright-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[4]));
                this.f11366f.mo14042a("skinauto-Strength", (Object) Integer.valueOf(this.f11363b.mo20783a(b, i2)[5]));
            }
            if (DeviceHelper.f13909bI) {
                AlorgrithmManager.m10027b(i2);
            }
        }
    }

    /* renamed from: k */
    private void m12361k() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1677, new Class[0], Void.TYPE).isSupported) {
            this.f11363b.mo20781a();
        }
    }

    /* renamed from: l */
    private void m12362l() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1678, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13886am) {
                this.f11366f = this.f11367g.getVfbRender();
            } else {
                this.f11366f = this.f11367g.getRender();
            }
            if (this.f11366f != null) {
                this.f11366f.mo14042a("smoothing-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[0]));
                this.f11366f.mo14042a("toning-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[1]));
                this.f11366f.mo14042a("slimming-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[2]));
                this.f11366f.mo14042a("eyeEnlargement-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[3]));
                this.f11366f.mo14042a("skinbright-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[4]));
                this.f11366f.mo14042a("skinauto-Strength", (Object) Integer.valueOf(this.f11363b.mo20782a(this.f11363b.mo20784b())[5]));
            }
        }
    }

    /* renamed from: m */
    private void m12363m() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1679, new Class[0], Void.TYPE).isSupported && !DeviceHelper.f13837Q && !this.f11372l) {
            boolean z = true;
            this.f11372l = true;
            try {
                this.f11364d = Settings.System.getInt(this.f11365e.getContentResolver(), "cpu_l");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            LogUtil.C2630a aVar = f11362c;
            LogUtil.m15942a(aVar, "current cpu performance mode : " + this.f11364d + ". (high - " + 0 + ", low - " + 1 + ")");
            if (this.f11364d != 0) {
                z = Settings.System.putInt(this.f11365e.getContentResolver(), "cpu_l", 0);
            }
            LogUtil.C2630a aVar2 = f11362c;
            LogUtil.m15942a(aVar2, "Setting high performance mode(status : " + z + ")");
        }
    }

    /* renamed from: n */
    private void m12364n() {
        if (!PatchProxy.proxy(new Object[0], this, f11361a, false, 1680, new Class[0], Void.TYPE).isSupported && !DeviceHelper.f13837Q && this.f11372l) {
            this.f11372l = false;
            boolean putInt = Settings.System.putInt(this.f11365e.getContentResolver(), "cpu_l", this.f11364d);
            LogUtil.C2630a aVar = f11362c;
            LogUtil.m15942a(aVar, "Setting cpu run in recorded performance mode(status : " + putInt + ")");
            LogUtil.C2630a aVar2 = f11362c;
            LogUtil.m15942a(aVar2, "current cpu performance mode : " + this.f11364d + ". (high - " + 0 + ", low - " + 1 + ")");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        if (r11.equals("smoothing-Strength") != false) goto L_0x0072;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12350a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r11
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r12)
            r9 = 1
            r1[r9] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f11361a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r8] = r2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r9] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 1681(0x691, float:2.356E-42)
            r2 = r10
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0029
            return
        L_0x0029:
            com.meizu.media.camera.MzCamController r1 = r10.f11371k
            if (r1 == 0) goto L_0x0096
            com.meizu.media.camera.MzCamController r1 = r10.f11371k
            com.meizu.media.camera.e r1 = r1.mo17902aE()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r2 = -1
            int r3 = r11.hashCode()
            switch(r3) {
                case -1840398694: goto L_0x0068;
                case -1767032625: goto L_0x005e;
                case -463149892: goto L_0x0054;
                case 221821631: goto L_0x004a;
                case 1606872124: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0071
        L_0x0040:
            java.lang.String r0 = "autoFacebeautyLevel"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0071
            r0 = 4
            goto L_0x0072
        L_0x004a:
            java.lang.String r0 = "toning-Strength"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0071
            r0 = 3
            goto L_0x0072
        L_0x0054:
            java.lang.String r0 = "slimming-Strength"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0071
            r0 = 1
            goto L_0x0072
        L_0x005e:
            java.lang.String r0 = "eyeEnlargement-Strength"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0071
            r0 = 0
            goto L_0x0072
        L_0x0068:
            java.lang.String r3 = "smoothing-Strength"
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r0 = -1
        L_0x0072:
            switch(r0) {
                case 0: goto L_0x008e;
                case 1: goto L_0x0088;
                case 2: goto L_0x0082;
                case 3: goto L_0x007c;
                case 4: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x0093
        L_0x0076:
            java.lang.String r11 = "mz_pref_fb_smart_level"
            r1.putInt(r11, r12)
            goto L_0x0093
        L_0x007c:
            java.lang.String r11 = "mz_pref_fb_advanced_whiten_level"
            r1.putInt(r11, r12)
            goto L_0x0093
        L_0x0082:
            java.lang.String r11 = "mz_pref_fb_advanced_smooth_level"
            r1.putInt(r11, r12)
            goto L_0x0093
        L_0x0088:
            java.lang.String r11 = "mz_pref_fb_advanced_slim_level"
            r1.putInt(r11, r12)
            goto L_0x0093
        L_0x008e:
            java.lang.String r11 = "mz_pref_fb_advanced_eye_level"
            r1.putInt(r11, r12)
        L_0x0093:
            r1.apply()
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzFacebeautyManager.m12350a(java.lang.String, int):void");
    }

    /* renamed from: com.meizu.media.camera.n$a */
    /* compiled from: MzFacebeautyManager */
    private class C2252a {

        /* renamed from: a */
        public static ChangeQuickRedirect f11382a;

        /* renamed from: b */
        protected int f11383b = -1;

        /* renamed from: c */
        List<int[]> f11384c = new ArrayList();

        public C2252a() {
            this.f11384c.add(DeviceHelper.f13966cM);
            this.f11384c.add(DeviceHelper.f13967cN);
            this.f11384c.add(DeviceHelper.f13968cO);
            this.f11384c.add(DeviceHelper.f13969cP);
            this.f11384c.add(DeviceHelper.f13970cQ);
            this.f11384c.add(DeviceHelper.f13971cR);
            if (DeviceHelper.f13907bG) {
                this.f11384c.add(DeviceHelper.f13972cS);
                this.f11384c.add(DeviceHelper.f13973cT);
                this.f11384c.add(DeviceHelper.f13974cU);
                this.f11384c.add(DeviceHelper.f13975cV);
                this.f11384c.add(DeviceHelper.f13976cW);
                this.f11384c.add(DeviceHelper.f13977cX);
            }
            if (DeviceHelper.f13906bF) {
                this.f11384c.add(DeviceHelper.f13978cY);
            }
        }

        /* renamed from: a */
        public void mo20781a() {
            int i = 0;
            if (!PatchProxy.proxy(new Object[0], this, f11382a, false, 1684, new Class[0], Void.TYPE).isSupported) {
                LogUtil.C2630a i2 = MzFacebeautyManager.f11362c;
                LogUtil.m15942a(i2, "init mController:" + MzFacebeautyManager.this.f11371k);
                if (!(CameraController.m8868g() == null || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1)) {
                    i = 1;
                }
                if (MzFacebeautyManager.this.f11373m) {
                    this.f11383b = ComboPreferences.m10008b(MzFacebeautyManager.this.f11365e, 1).getInt("mz_pref_fb_smart_level", i);
                    LogUtil.C2630a i3 = MzFacebeautyManager.f11362c;
                    LogUtil.m15942a(i3, "init watch smartFBLevel:" + this.f11383b);
                } else if (MzFacebeautyManager.this.f11371k != null) {
                    this.f11383b = MzFacebeautyManager.this.f11371k.mo17902aE().getInt("mz_pref_fb_smart_level", i);
                    LogUtil.C2630a i4 = MzFacebeautyManager.f11362c;
                    LogUtil.m15942a(i4, "init smartFBLevel:" + this.f11383b);
                } else {
                    this.f11383b = i;
                }
            }
        }

        /* renamed from: a */
        public int[] mo20782a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f11382a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 1685, new Class[]{Integer.TYPE}, int[].class);
            if (proxy.isSupported) {
                return (int[]) proxy.result;
            }
            if (this.f11384c != null) {
                if (MzFacebeautyManager.this.f11371k.mo17871T() == 1 || !DeviceHelper.f13907bG) {
                    return this.f11384c.get(i);
                }
                return this.f11384c.get(i + MzFacebeautyManager.this.f11374n);
            } else if (MzFacebeautyManager.this.f11371k.mo17871T() == 1 || !DeviceHelper.f13907bG) {
                return DeviceHelper.f13966cM;
            } else {
                return DeviceHelper.f13972cS;
            }
        }

        /* renamed from: a */
        public int[] mo20783a(int i, int i2) {
            Object[] objArr = {new Integer(i), new Integer(i2)};
            ChangeQuickRedirect changeQuickRedirect = f11382a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 1686, new Class[]{Integer.TYPE, Integer.TYPE}, int[].class);
            if (proxy.isSupported) {
                return (int[]) proxy.result;
            }
            if (this.f11384c != null) {
                if (MzFacebeautyManager.this.f11371k.mo17871T() != 1 && DeviceHelper.f13907bG) {
                    return this.f11384c.get(i + MzFacebeautyManager.this.f11374n);
                }
                if (!DeviceHelper.f13907bG) {
                    return this.f11384c.get(i + (i2 * MzFacebeautyManager.this.f11375o));
                }
                if (i2 == 0) {
                    return this.f11384c.get(i);
                }
                return this.f11384c.get(i + MzFacebeautyManager.this.f11374n + (i2 * MzFacebeautyManager.this.f11375o));
            } else if (MzFacebeautyManager.this.f11371k.mo17871T() == 1 || !DeviceHelper.f13907bG) {
                return DeviceHelper.f13966cM;
            } else {
                return DeviceHelper.f13972cS;
            }
        }

        /* renamed from: b */
        public int mo20784b() {
            return this.f11383b;
        }

        /* renamed from: b */
        public void mo20785b(int i) {
            this.f11383b = i;
        }
    }
}
