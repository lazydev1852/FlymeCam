package com.meizu.media.camera.simplify;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.camera.effectlib.effects.views.CameraPreviewRenderView;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p068e.AlorgrithmManager;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.simplify.f */
public class MzSimplifyFacebeautyManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f11926a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final LogUtil.C2630a f11927c = new LogUtil.C2630a("MzFacebeautyManager");

    /* renamed from: b */
    protected C2332b f11928b = new C2332b();

    /* renamed from: d */
    private int f11929d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f11930e;

    /* renamed from: f */
    private BaseRender f11931f;

    /* renamed from: g */
    private CameraPreviewRenderView f11932g;

    /* renamed from: h */
    private MzSimplifyCamUI f11933h;

    /* renamed from: i */
    private MzSimplifyUIController f11934i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C2331a f11935j;

    /* renamed from: k */
    private MzSimplifyCamParamsManager f11936k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f11937l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MzSimplifyCamController f11938m;

    /* renamed from: n */
    private boolean f11939n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11940o = 6;

    /* renamed from: p */
    private int f11941p = 5;

    /* renamed from: q */
    private int f11942q = 1;

    /* renamed from: r */
    private int f11943r = 0;

    /* renamed from: com.meizu.media.camera.simplify.f$a */
    /* compiled from: MzSimplifyFacebeautyManager */
    public interface C2331a {
        /* renamed from: al */
        SharedPreferences mo18437al();
    }

    public MzSimplifyFacebeautyManager(Context context, MzSimplifyCamParamsManager cVar, boolean z) {
        this.f11930e = context;
        this.f11936k = cVar;
        this.f11937l = z;
        AsyncTaskEx.f13741o.execute(new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f11944a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f11944a, false, 5993, new Class[0], Void.TYPE).isSupported) {
                    MzSimplifyFacebeautyManager.this.f11928b.mo21268a();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo21260a(MzSimplifyUIController jVar, MzSimplifyCamUI dVar, MzSimplifyCamController mzSimplifyCamController) {
        Class[] clsArr = {MzSimplifyUIController.class, MzSimplifyCamUI.class, MzSimplifyCamController.class};
        if (!PatchProxy.proxy(new Object[]{jVar, dVar, mzSimplifyCamController}, this, f11926a, false, 5971, clsArr, Void.TYPE).isSupported) {
            this.f11933h = dVar;
            this.f11934i = jVar;
            this.f11932g = dVar.mo21139A();
            this.f11938m = mzSimplifyCamController;
            this.f11938m.mo18418aN();
        }
    }

    /* renamed from: a */
    public int mo21256a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11926a, false, 5972, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = this.f11928b.mo21270b();
        if (b == 1) {
            return 1;
        }
        return b == 5 ? 2 : 0;
    }

    /* renamed from: a */
    public void mo21257a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11926a, false, 5973, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            switch (i) {
                case 0:
                    m13100a("autoFacebeautyLevel", 0);
                    m13114k();
                    m13103b(false);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        m13109f();
                        this.f11936k.mo21118b(false);
                    } else if (!DeviceHelper.f13867aT || this.f11938m.mo18418aN() != 1) {
                        mo21263b(0);
                        this.f11933h.mo21181b("Mznone");
                        m13109f();
                    } else {
                        mo21263b(1);
                        this.f11933h.mo21181b("Mzvfacebeauty");
                        m13104c(0);
                    }
                    m13101a(true);
                    return;
                case 1:
                    this.f11933h.mo21181b("Mzvfacebeauty");
                    m13100a("autoFacebeautyLevel", 1);
                    m13104c(1);
                    m13113j();
                    m13103b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        this.f11936k.mo21118b(false);
                        AlorgrithmManager.m10019a(this.f11928b.mo21270b());
                    } else {
                        mo21263b(2);
                    }
                    m13101a(false);
                    return;
                case 2:
                    this.f11933h.mo21181b("Mzvfacebeauty");
                    m13104c(5);
                    m13100a("autoFacebeautyLevel", 5);
                    m13113j();
                    m13103b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        this.f11936k.mo21118b(false);
                        AlorgrithmManager.m10019a(this.f11928b.mo21270b());
                    } else {
                        mo21263b(3);
                    }
                    m13101a(false);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m13101a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11926a, false, 5974, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11946a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11946a, false, 5994, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    MzSimplifyFacebeautyManager.this.f11938m.mo18491o(false);
                    MzSimplifyFacebeautyManager.this.f11938m.mo18401a(true);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: b */
    private void m13103b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11926a, false, 5975, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11927c;
            LogUtil.m15942a(aVar, "setFBMode" + z);
            this.f11936k.mo21120c(z, false);
        }
    }

    /* renamed from: b */
    public void mo21263b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11926a, false, 5976, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            String valueOf = String.valueOf(i);
            LogUtil.C2630a aVar = f11927c;
            LogUtil.m15942a(aVar, "setHalFBLevel:" + valueOf);
            this.f11936k.mo21108a(valueOf, false);
            this.f11943r = i;
        }
    }

    /* renamed from: b */
    public void mo21262b() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5978, new Class[0], Void.TYPE).isSupported && mo21265d() && this.f11928b.mo21270b() > 0) {
            m13114k();
        }
    }

    /* renamed from: a */
    public void mo21261a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11926a, false, 5979, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f11927c, "resumeFbEffect");
            if (z) {
                if (z2) {
                    m13111h();
                    if (this.f11928b.mo21270b() == 0) {
                        this.f11928b.mo21271b(1);
                    }
                    this.f11933h.mo21181b("Mzvfacebeauty");
                    m13112i();
                    m13113j();
                    m13103b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        AlorgrithmManager.m10019a(this.f11928b.mo21270b());
                        this.f11936k.mo21118b(false);
                    } else if (this.f11928b.mo21270b() == 0) {
                        if (!DeviceHelper.f13867aT || this.f11938m.mo18418aN() != 1) {
                            mo21263b(0);
                        } else {
                            mo21263b(1);
                        }
                    } else if (this.f11928b.mo21270b() == 1) {
                        mo21263b(2);
                    } else if (this.f11928b.mo21270b() == 5) {
                        mo21263b(3);
                    }
                    m13101a(false);
                    return;
                }
                m13109f();
                m13114k();
                m13103b(false);
                if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                    this.f11936k.mo21118b(false);
                } else if (!DeviceHelper.f13867aT || this.f11938m.mo18418aN() != 1) {
                    mo21263b(0);
                } else {
                    mo21263b(1);
                }
                m13101a(true);
            } else if (mo21265d()) {
                m13111h();
                if (this.f11928b.mo21270b() <= 0 || this.f11933h == null) {
                    m13103b(false);
                    m13114k();
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        this.f11936k.mo21118b(false);
                    } else if (!DeviceHelper.f13867aT || this.f11938m.mo18418aN() != 1) {
                        m13109f();
                    } else {
                        mo21263b(1);
                        this.f11933h.mo21181b("Mzvfacebeauty");
                        m13104c(0);
                    }
                    m13101a(true);
                } else {
                    this.f11933h.mo21181b("Mzvfacebeauty");
                    m13112i();
                    m13113j();
                    m13103b(true);
                    if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API1)) {
                        AlorgrithmManager.m10019a(this.f11928b.mo21270b());
                        this.f11936k.mo21118b(false);
                    } else if (this.f11928b.mo21270b() == 1) {
                        mo21263b(2);
                    } else if (this.f11928b.mo21270b() == 5) {
                        mo21263b(3);
                    }
                    m13101a(false);
                }
                if (this.f11934i != null) {
                    this.f11934i.mo20948j(mo21256a());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo21258a(CameraModeType.ModeType modeType) {
        if (PatchProxy.proxy(new Object[]{modeType}, this, f11926a, false, 5980, new Class[]{CameraModeType.ModeType.class}, Void.TYPE).isSupported || !modeType.equals(CameraModeType.ModeType.AUTO)) {
            return;
        }
        if (this.f11928b.mo21270b() > 0 || DeviceHelper.f13867aT) {
            LogUtil.m15942a(f11927c, "onModeRelease");
            m13109f();
            m13114k();
        }
    }

    /* renamed from: c */
    public void mo21264c() {
        if (PatchProxy.proxy(new Object[0], this, f11926a, false, 5981, new Class[0], Void.TYPE).isSupported || !mo21265d()) {
            return;
        }
        if (this.f11928b.mo21270b() > 0 || DeviceHelper.f13867aT) {
            LogUtil.m15942a(f11927c, "onPreCameraSwitch");
            m13109f();
            m13114k();
        }
    }

    /* renamed from: d */
    public boolean mo21265d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11926a, false, 5982, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraModeType.m10946a().equals(CameraModeType.ModeType.AUTO);
    }

    /* renamed from: a */
    public void mo21259a(C2331a aVar) {
        this.f11935j = aVar;
    }

    /* renamed from: f */
    private void m13109f() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5983, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11927c, "cleanFbEffect");
            this.f11928b.mo21271b(0);
            if (this.f11933h != null) {
                this.f11933h.mo21181b("Mznone");
            }
            this.f11931f = null;
            mo21263b(0);
            m13110g();
        }
    }

    /* renamed from: g */
    private void m13110g() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5985, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13886am) {
                this.f11931f = this.f11932g.getVfbRender();
            } else {
                this.f11931f = this.f11932g.getRender();
            }
            if (this.f11931f != null) {
                this.f11931f.mo14042a("eyeEnlargement-Strength", (Object) 0);
                this.f11931f.mo14042a("slimming-Strength", (Object) 0);
                this.f11931f.mo14042a("toning-Strength", (Object) 0);
                this.f11931f.mo14042a("smoothing-Strength", (Object) 0);
            }
        }
    }

    /* renamed from: c */
    private void m13104c(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11926a, false, 5986, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f11928b.mo21271b(i);
            if (DeviceHelper.f13886am) {
                this.f11931f = this.f11932g.getVfbRender();
            } else {
                this.f11931f = this.f11932g.getRender();
            }
            if (this.f11931f != null) {
                this.f11931f.mo14042a("smoothing-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(i)[0]));
                this.f11931f.mo14042a("toning-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(i)[1]));
                this.f11931f.mo14042a("slimming-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(i)[2]));
                this.f11931f.mo14042a("eyeEnlargement-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(i)[3]));
                this.f11931f.mo14042a("skinbright-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[4]));
                this.f11931f.mo14042a("skinauto-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[5]));
            }
        }
    }

    /* renamed from: h */
    private void m13111h() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5988, new Class[0], Void.TYPE).isSupported) {
            this.f11928b.mo21268a();
        }
    }

    /* renamed from: i */
    private void m13112i() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5989, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13886am) {
                this.f11931f = this.f11932g.getVfbRender();
            } else {
                this.f11931f = this.f11932g.getRender();
            }
            if (this.f11931f != null) {
                this.f11931f.mo14042a("smoothing-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[0]));
                this.f11931f.mo14042a("toning-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[1]));
                this.f11931f.mo14042a("slimming-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[2]));
                this.f11931f.mo14042a("eyeEnlargement-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[3]));
                this.f11931f.mo14042a("skinbright-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[4]));
                this.f11931f.mo14042a("skinauto-Strength", (Object) Integer.valueOf(this.f11928b.mo21269a(this.f11928b.mo21270b())[5]));
            }
        }
    }

    /* renamed from: j */
    private void m13113j() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5990, new Class[0], Void.TYPE).isSupported && !this.f11939n) {
            boolean z = true;
            this.f11939n = true;
            try {
                this.f11929d = Settings.System.getInt(this.f11930e.getContentResolver(), "cpu_l");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            LogUtil.C2630a aVar = f11927c;
            LogUtil.m15942a(aVar, "current cpu performance mode : " + this.f11929d + ". (high - " + 0 + ", low - " + 1 + ")");
            if (this.f11929d != 0) {
                z = Settings.System.putInt(this.f11930e.getContentResolver(), "cpu_l", 0);
            }
            LogUtil.C2630a aVar2 = f11927c;
            LogUtil.m15942a(aVar2, "Setting high performance mode(status : " + z + ")");
        }
    }

    /* renamed from: k */
    private void m13114k() {
        if (!PatchProxy.proxy(new Object[0], this, f11926a, false, 5991, new Class[0], Void.TYPE).isSupported && this.f11939n) {
            this.f11939n = false;
            boolean putInt = Settings.System.putInt(this.f11930e.getContentResolver(), "cpu_l", this.f11929d);
            LogUtil.C2630a aVar = f11927c;
            LogUtil.m15942a(aVar, "Setting cpu run in recorded performance mode(status : " + putInt + ")");
            LogUtil.C2630a aVar2 = f11927c;
            LogUtil.m15942a(aVar2, "current cpu performance mode : " + this.f11929d + ". (high - " + 0 + ", low - " + 1 + ")");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        if (r11.equals("smoothing-Strength") != false) goto L_0x0072;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13100a(java.lang.String r11, int r12) {
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
            com.meizu.savior.ChangeQuickRedirect r3 = f11926a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r8] = r2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r9] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5992(0x1768, float:8.397E-42)
            r2 = r10
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0029
            return
        L_0x0029:
            com.meizu.media.camera.simplify.f$a r1 = r10.f11935j
            if (r1 == 0) goto L_0x0096
            com.meizu.media.camera.simplify.f$a r1 = r10.f11935j
            android.content.SharedPreferences r1 = r1.mo18437al()
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyFacebeautyManager.m13100a(java.lang.String, int):void");
    }

    /* renamed from: com.meizu.media.camera.simplify.f$b */
    /* compiled from: MzSimplifyFacebeautyManager */
    private class C2332b {

        /* renamed from: a */
        public static ChangeQuickRedirect f11948a;

        /* renamed from: b */
        protected int f11949b = -1;

        /* renamed from: c */
        List<int[]> f11950c = new ArrayList();

        public C2332b() {
            this.f11950c.add(DeviceHelper.f13966cM);
            this.f11950c.add(DeviceHelper.f13967cN);
            this.f11950c.add(DeviceHelper.f13968cO);
            this.f11950c.add(DeviceHelper.f13969cP);
            this.f11950c.add(DeviceHelper.f13970cQ);
            this.f11950c.add(DeviceHelper.f13971cR);
            if (DeviceHelper.f13907bG) {
                this.f11950c.add(DeviceHelper.f13972cS);
                this.f11950c.add(DeviceHelper.f13973cT);
                this.f11950c.add(DeviceHelper.f13974cU);
                this.f11950c.add(DeviceHelper.f13975cV);
                this.f11950c.add(DeviceHelper.f13976cW);
                this.f11950c.add(DeviceHelper.f13977cX);
            }
            if (DeviceHelper.f13906bF) {
                this.f11950c.add(DeviceHelper.f13978cY);
            }
        }

        /* renamed from: a */
        public void mo21268a() {
            int i = 0;
            if (!PatchProxy.proxy(new Object[0], this, f11948a, false, 5995, new Class[0], Void.TYPE).isSupported) {
                LogUtil.C2630a e = MzSimplifyFacebeautyManager.f11927c;
                LogUtil.m15942a(e, "init mFaceBeautyListener:" + MzSimplifyFacebeautyManager.this.f11935j);
                if (!(CameraController.m8868g() == null || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1)) {
                    i = 1;
                }
                if (MzSimplifyFacebeautyManager.this.f11937l) {
                    this.f11949b = ComboPreferences.m10008b(MzSimplifyFacebeautyManager.this.f11930e, 1).getInt("mz_pref_fb_smart_level", i);
                    LogUtil.C2630a e2 = MzSimplifyFacebeautyManager.f11927c;
                    LogUtil.m15942a(e2, "init watch smartFBLevel:" + this.f11949b);
                } else if (MzSimplifyFacebeautyManager.this.f11935j != null) {
                    this.f11949b = MzSimplifyFacebeautyManager.this.f11935j.mo18437al().getInt("mz_pref_fb_smart_level", i);
                    LogUtil.C2630a e3 = MzSimplifyFacebeautyManager.f11927c;
                    LogUtil.m15942a(e3, "init smartFBLevel:" + this.f11949b);
                } else {
                    this.f11949b = i;
                }
            }
        }

        /* renamed from: a */
        public int[] mo21269a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f11948a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5996, new Class[]{Integer.TYPE}, int[].class);
            if (proxy.isSupported) {
                return (int[]) proxy.result;
            }
            if (this.f11950c != null) {
                if (MzSimplifyFacebeautyManager.this.f11938m.mo18418aN() == 1 || !DeviceHelper.f13907bG) {
                    return this.f11950c.get(i);
                }
                return this.f11950c.get(i + MzSimplifyFacebeautyManager.this.f11940o);
            } else if (MzSimplifyFacebeautyManager.this.f11938m.mo18418aN() == 1 || !DeviceHelper.f13907bG) {
                return DeviceHelper.f13966cM;
            } else {
                return DeviceHelper.f13972cS;
            }
        }

        /* renamed from: b */
        public int mo21270b() {
            return this.f11949b;
        }

        /* renamed from: b */
        public void mo21271b(int i) {
            this.f11949b = i;
        }
    }
}
