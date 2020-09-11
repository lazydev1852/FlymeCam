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

/* renamed from: com.meizu.media.camera.mode.b */
public class BackLightingMode extends CameraMode {

    /* renamed from: a */
    public static ChangeQuickRedirect f10635a;

    /* renamed from: b */
    private static final LogUtil.C2630a f10636b = new LogUtil.C2630a("BackLightingMode");

    /* renamed from: c */
    private CameraModeListener f10637c;

    /* renamed from: d */
    private boolean f10638d;

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

    public BackLightingMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10637c = hVar;
    }

    /* renamed from: c */
    private void m11113c() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4584, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21571c();
            if (this.f10637c.mo18211di() == 1) {
                this.f10788j.mo21506a(44);
                this.f10788j.mo21592g(MzUIController.f12276D);
            } else {
                this.f10788j.mo21506a(44);
                this.f10788j.mo21592g(MzUIController.f12276D);
            }
            this.f10788j.mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            this.f10788j.mo21581d(128, true);
            this.f10788j.mo21574c(128, true);
            this.f10788j.mo21593g(false);
            if (this.f10637c.mo17914ak() != null) {
                this.f10637c.mo17914ak().mo20230j(true);
            }
            m11114d(false);
            m11112a(true);
            int b = this.f10788j.mo21562b("mz_pref_tripod_key");
            CameraController g = CameraController.m8868g();
            if (b == 0) {
                z = true;
            }
            g.mo19508d(z);
        }
    }

    /* renamed from: a */
    private void m11112a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10635a, false, 4585, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            CameraController.m8868g().mo19471a("super-night-on", z ? "1" : "0", true);
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10635a, false, 4586, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i != 1) {
                z = false;
            }
            SNUtil.initSn(z);
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4587, new Class[0], Void.TYPE).isSupported) {
            SNUtil.unInit();
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4588, new Class[0], Void.TYPE).isSupported) {
            m11114d(false);
            m11112a(true);
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10635a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4589, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m11113c();
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4590, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            m11113c();
            this.f10788j.mo21553ar();
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4591, new Class[0], Void.TYPE).isSupported) {
            m11113c();
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.BACK_LIGHTING;
    }

    /* renamed from: d */
    private void m11114d(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10635a, false, 4592, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10639a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10639a, false, 4602, new Class[]{Void[].class}, Void.class);
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
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4593, new Class[0], Void.TYPE).isSupported) {
            SNUtil.unInit();
            this.f10788j.mo21581d(134, true);
            this.f10788j.mo21553ar();
            if (this.f10637c.mo17914ak() != null) {
                this.f10637c.mo17914ak().mo20230j(false);
            }
            if (DeviceUtil.m16200b()) {
                m11114d(true);
            }
            m11112a(false);
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4594, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            if (this.f10637c.mo18211di() == 1) {
                this.f10788j.mo21506a(44);
            } else {
                this.f10788j.mo21506a(44);
            }
            mo20542U().mo21581d(132, true);
            mo20542U().mo21574c(132, true);
            if (mo20542U().mo21503Z()) {
                mo20542U().mo21574c(4, true);
            }
            if (this.f10788j.mo21493P()) {
                this.f10638d = false;
            }
            mo20541T().mo20341f();
            mo20541T().mo20322a(false);
            if ((this.f10787i == null || this.f10787i.mo17677n()) && !this.f10638d) {
                SNUtil.unInit();
            }
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4595, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            if (this.f10637c.mo18211di() == 1) {
                this.f10788j.mo21506a(44);
            } else {
                this.f10788j.mo21506a(44);
            }
            mo20542U().mo21581d(132, true);
            mo20542U().mo21574c(132, true);
            this.f10638d = false;
            mo20541T().mo20341f();
            mo20541T().mo20322a(false);
            if (this.f10787i == null || this.f10787i.mo17677n()) {
                SNUtil.unInit();
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4596, new Class[0], Void.TYPE).isSupported && !this.f10638d) {
            SNUtil.unInit();
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4597, new Class[0], Void.TYPE).isSupported && !CameraOptTask.m7846m()) {
            this.f10638d = false;
        }
    }

    /* renamed from: a */
    public void mo20496a() {
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4598, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21510a(-1, true);
            if (this.f10637c.mo18211di() == 1) {
                this.f10788j.mo21506a(44);
            } else {
                this.f10788j.mo21506a(44);
            }
            mo20542U().mo21581d(132, true);
            mo20542U().mo21574c(132, true);
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10635a, false, 4599, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20542U().mo21581d(132, false);
        mo20542U().mo21574c(132, false);
        mo20542U().mo21506a(0);
        if (!(this.f10637c.mo18211di() == DeviceHelper.f14029du || this.f10637c.mo18211di() == 1)) {
            this.f10637c.mo18267u().mo22086a(false, 0);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10635a, false, 4600, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f10638d = true;
        long currentTimeMillis = System.currentTimeMillis();
        Point j = CameraController.m8868g().mo19520j();
        if (j == null) {
            LogUtil.m15956e(f10636b, "capture size is null!");
            return true;
        }
        int b = this.f10788j.mo21562b("mz_pref_tripod_key");
        MzCamParamsManager dS = mo20539R().mo18195dS();
        dS.mo20318a(currentTimeMillis);
        boolean l = dS.mo20347l();
        boolean n = dS.mo20349n();
        Storage.m7750a().mo18652e(true);
        this.f10637c.mo17914ak().mo20242u();
        mo20541T().mo20341f();
        mo20541T().mo20322a(true);
        mo20541T().mo20350o();
        CameraController.m8868g().mo19490b(0, new boolean[0]);
        boolean ag = this.f10637c.mo17910ag();
        Location location = null;
        if (this.f10637c.mo18192dP() != null) {
            location = this.f10637c.mo18192dP().mo19017a(currentTimeMillis);
        }
        Location location2 = location;
        LogUtil.m15952c(f10636b, location2 == null ? "Location is null" : "Has Location message");
        CameraOptTask.m8349a((Context) this.f10787i, CameraOptTask.m8339a(this.f10787i.getApplicationContext(), location2, uuid, Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE, j.x, j.y, CameraUtil.m15882c(mo20539R().mo18211di(), mo20539R().mo18194dR()), currentTimeMillis, b == 0, l, n, ag, false, this.f10637c.mo18211di() == 1, mo20541T().mo20351p()));
        if (this.f10637c.mo18211di() != 1 || !mo20542U().mo21615m()) {
            if (this.f10637c.mo18211di() != 1 || mo20542U().mo21615m()) {
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
        return this.f10638d;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return this.f10638d ? CameraController.FocusMode.AUTO : CameraController.FocusMode.CONTINUOUS_PICTURE;
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
        if (!PatchProxy.proxy(new Object[0], this, f10635a, false, 4601, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a((Context) this.f10787i).mo22688a(new String[]{"mode", "count_down", "location", "voice", "meshline", "level", "time_mark", "capture_type", "sd_card", "tripod"});
            a.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            a.put("face_num", Integer.toString(this.f10637c.mo18267u().mo22055R()));
            a.put("capture_time", Long.toString(this.f10637c.mo18186dJ()));
            a.put("zoom", Integer.toString(this.f10637c.mo18267u().mo22199w()));
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f10637c.mo17914ak() == null || (ak = this.f10637c.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", this.f10637c.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            UsageStatsHelper.m16042a((Context) this.f10787i).mo22693a("capture_info", a);
        }
    }
}
