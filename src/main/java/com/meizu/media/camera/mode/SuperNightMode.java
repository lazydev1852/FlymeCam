package com.meizu.media.camera.mode;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.cameraAlgorithm.supernight.SNUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.s */
public class SuperNightMode extends CameraMode {

    /* renamed from: a */
    public static ChangeQuickRedirect f11104a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f11105b = new LogUtil.C2630a("SuperNightMode");

    /* renamed from: c */
    private static final int f11106c = (DeviceHelper.f14025dq ? 1 : 128);

    /* renamed from: d */
    private CameraModeListener f11107d;

    /* renamed from: e */
    private boolean f11108e;

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return false;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public SuperNightMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f11107d = hVar;
    }

    /* renamed from: a */
    public static boolean m11955a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11104a, true, 5091, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "meizu.intent.action.shortcut.SUPER_NIGHT".equals(str);
    }

    /* renamed from: q */
    private void m11960q() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5092, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21571c();
            m11954a(true);
            this.f10788j.mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            this.f10788j.mo21581d(f11106c, true);
            this.f10788j.mo21574c(f11106c, true);
            this.f10788j.mo21593g(false);
            if (this.f11107d.mo17914ak() != null) {
                this.f11107d.mo17914ak().mo20230j(true);
            }
            m11959e(false);
            m11958d(true);
            AsyncTaskEx.m15786a((Runnable) new Runnable(this.f10788j.mo21562b("mz_pref_tripod_key")) {
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    SuperNightMode.m11957d(this.f$0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m11957d(int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f11104a, true, 5111, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            CameraController g = CameraController.m8868g();
            if (i != 0) {
                z = false;
            }
            g.mo19508d(z);
        }
    }

    /* renamed from: a */
    private void m11954a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11104a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5093, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f11107d.mo18211di() == 1) {
                this.f10788j.mo21506a(MzUIController.f12290l);
                if (z) {
                    this.f10788j.mo21592g(MzUIController.f12276D);
                }
            } else if (this.f11107d.mo18211di() != DeviceHelper.f14029du || DeviceHelper.f14033dy) {
                this.f10788j.mo21506a(MzUIController.f12289k);
                if (z) {
                    this.f10788j.mo21592g(MzUIController.f12275C);
                }
            } else {
                this.f10788j.mo21506a(MzUIController.f12291m);
                if (z) {
                    this.f10788j.mo21592g(MzUIController.f12275C);
                }
            }
        }
    }

    /* renamed from: d */
    private void m11958d(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11104a, false, 5094, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            CameraController.m8868g().mo19471a("super-night-on", z ? "1" : "0", true);
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11104a, false, 5095, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i != 1) {
                z = false;
            }
            SNUtil.initSn(z);
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5096, new Class[0], Void.TYPE).isSupported) {
            SNUtil.unInit();
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5097, new Class[0], Void.TYPE).isSupported) {
            m11959e(false);
            m11958d(true);
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11104a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5098, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m11960q();
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5099, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            m11960q();
            this.f10788j.mo21553ar();
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5100, new Class[0], Void.TYPE).isSupported) {
            m11960q();
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.SUPER_NIGHT;
    }

    /* renamed from: e */
    private void m11959e(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11104a, false, 5101, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11109a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11109a, false, 5112, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    CameraController.m8868g().mo19475a(z);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5102, new Class[0], Void.TYPE).isSupported) {
            SNUtil.unInit();
            this.f10788j.mo21581d(f11106c ^ 6, true);
            this.f10788j.mo21553ar();
            if (this.f11107d.mo17914ak() != null) {
                this.f11107d.mo17914ak().mo20230j(false);
            }
            if (DeviceUtil.m16200b()) {
                m11959e(true);
            }
            m11958d(false);
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5103, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            m11954a(false);
            mo20542U().mo21581d(f11106c ^ 4, true);
            mo20542U().mo21574c(f11106c ^ 4, true);
            if (mo20542U().mo21503Z()) {
                mo20542U().mo21574c(4, true);
            }
            this.f11108e = false;
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11112a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11112a, false, 5113, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    LogUtil.m15942a(SuperNightMode.f11105b, "onCaptureFinished doInBackground");
                    SuperNightMode.this.mo20541T().mo20341f();
                    SuperNightMode.this.mo20541T().mo20322a(false);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
            if (this.f10787i == null || this.f10787i.mo17677n()) {
                SNUtil.unInit();
            }
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5104, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            m11954a(false);
            mo20542U().mo21581d(f11106c ^ 4, true);
            mo20542U().mo21574c(f11106c ^ 4, true);
            if (this.f10788j.mo21493P()) {
                this.f11108e = false;
            }
            mo20541T().mo20341f();
            mo20541T().mo20322a(false);
            if ((this.f10787i == null || this.f10787i.mo17677n()) && !this.f11108e) {
                SNUtil.unInit();
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5105, new Class[0], Void.TYPE).isSupported && !this.f11108e) {
            SNUtil.unInit();
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5106, new Class[0], Void.TYPE).isSupported && !CameraOptTask.m7846m()) {
            this.f11108e = false;
        }
    }

    /* renamed from: a */
    public void mo20496a() {
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5107, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            m11954a(false);
            mo20542U().mo21581d(f11106c ^ 4, true);
            mo20542U().mo21574c(f11106c ^ 4, true);
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11104a, false, 5108, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20542U().mo21581d(f11106c ^ 4, false);
        mo20542U().mo21574c(f11106c ^ 4, false);
        mo20542U().mo21506a(0);
        if ((this.f11107d.mo18211di() != DeviceHelper.f14029du || DeviceHelper.f13928bb) && this.f11107d.mo18211di() != 1) {
            this.f11107d.mo18267u().mo22086a(false, 0);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f11104a, false, 5109, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f11108e = true;
        long currentTimeMillis = System.currentTimeMillis();
        Point j = CameraController.m8868g().mo19520j();
        if (j == null) {
            LogUtil.m15956e(f11105b, "capture size is null!");
            return true;
        }
        int b = this.f10788j.mo21562b("mz_pref_tripod_key");
        MzCamParamsManager dS = mo20539R().mo18195dS();
        dS.mo20318a(currentTimeMillis);
        boolean l = dS.mo20347l();
        boolean n = dS.mo20349n();
        Storage.m7750a().mo18652e(true);
        this.f11107d.mo17914ak().mo20242u();
        mo20541T().mo20341f();
        mo20541T().mo20322a(true);
        mo20541T().mo20350o();
        Location location = null;
        if (this.f11107d.mo18192dP() != null) {
            location = this.f11107d.mo18192dP().mo19017a(currentTimeMillis);
        }
        Location location2 = location;
        LogUtil.m15952c(f11105b, location2 == null ? "Location is null" : "Has Location message");
        CameraController.m8868g().mo19490b(0, new boolean[0]);
        CameraOptTask.m8349a((Context) this.f10787i, CameraOptTask.m8339a(this.f10787i.getApplicationContext(), location2, uuid, Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE, j.x, j.y, CameraUtil.m15882c(mo20539R().mo18211di(), mo20539R().mo18194dR()), currentTimeMillis, b == 0, l, n, this.f11107d.mo17910ag(), false, this.f11107d.mo18211di() == 1, mo20541T().mo20351p()));
        if (this.f11107d.mo18211di() != 1 || !mo20542U().mo21615m()) {
            if (this.f11107d.mo18211di() != 1 || mo20542U().mo21615m()) {
                MzCamUI u = mo20539R().mo18267u();
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    z = true;
                }
                u.mo22067a(90, 2, z);
            } else if (mo20539R().mo18194dR() == 270 || mo20539R().mo18194dR() == 90) {
                MzCamUI u2 = mo20539R().mo18267u();
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    z = true;
                }
                u2.mo22067a(90, 2, z);
            } else {
                MzCamUI u3 = mo20539R().mo18267u();
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    z = true;
                }
                u3.mo22067a(-90, 2, z);
            }
        } else if (!mo20539R().mo18267u().mo22104aK() || !(mo20539R().mo18194dR() == 0 || mo20539R().mo18194dR() == 180)) {
            MzCamUI u4 = mo20539R().mo18267u();
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                z = true;
            }
            u4.mo22067a(90, 2, z);
        } else {
            MzCamUI u5 = mo20539R().mo18267u();
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                z = true;
            }
            u5.mo22068a(-90, 2, true, z);
        }
        this.f10788j.mo21501X();
        return true;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return this.f11108e;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return this.f11108e ? CameraController.FocusMode.AUTO : CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: A */
    public int mo20377A() {
        return DeviceHelper.f13910bJ == CameraController.CameraApi.API1 ? 1 : 0;
    }

    /* renamed from: I */
    public void mo20384I() {
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f11104a, false, 5110, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a((Context) this.f10787i).mo22688a(new String[]{"mode", "count_down", "location", "voice", "meshline", "level", "time_mark", "capture_type", "sd_card", "tripod"});
            a.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            a.put("face_num", Integer.toString(this.f11107d.mo18267u().mo22055R()));
            a.put("capture_time", Long.toString(this.f11107d.mo18186dJ()));
            a.put("zoom", Integer.toString(this.f11107d.mo18267u().mo22199w()));
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f11107d.mo17914ak() == null || (ak = this.f11107d.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", this.f11107d.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            UsageStatsHelper.m16042a((Context) this.f10787i).mo22693a("capture_info", a);
        }
    }
}
