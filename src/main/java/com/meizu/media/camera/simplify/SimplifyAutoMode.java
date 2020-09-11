package com.meizu.media.camera.simplify;

import android.graphics.Point;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.simplify.l */
public class SimplifyAutoMode extends SimplifyCameraMode implements MzFocusRenderer.C2745d {

    /* renamed from: a */
    public static ChangeQuickRedirect f12097a;

    /* renamed from: f */
    private MzSimplifyCamModule f12098f;

    /* renamed from: g */
    private UsageStatsHelper f12099g;

    /* renamed from: a */
    public void mo21347a(int i) {
    }

    /* renamed from: a */
    public boolean mo21349a(UUID uuid) {
        return false;
    }

    /* renamed from: i */
    public boolean mo21357i() {
        return true;
    }

    /* renamed from: j */
    public boolean mo21358j() {
        return false;
    }

    /* renamed from: k */
    public boolean mo21359k() {
        return false;
    }

    /* renamed from: l */
    public boolean mo21360l() {
        return false;
    }

    /* renamed from: o */
    public int mo21363o() {
        return 1;
    }

    public SimplifyAutoMode(CameraSimplifyActivity cameraSimplifyActivity, MzSimplifyCamParamsManager cVar, MzSimplifyUIController jVar, MzSimplifyCamModule mzSimplifyCamModule, CameraModeType.ModeType modeType) {
        super(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType);
        this.f12098f = mzSimplifyCamModule;
        this.f12099g = UsageStatsHelper.m16042a(cameraSimplifyActivity.getApplicationContext());
    }

    /* renamed from: a */
    public void mo21348a(MzSimplifyUIController jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f12097a, false, 6106, new Class[]{MzSimplifyUIController.class}, Void.TYPE).isSupported) {
            super.mo21348a(jVar);
        }
    }

    /* renamed from: a */
    public void mo21346a() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6107, new Class[0], Void.TYPE).isSupported && mo21404x() != null) {
            boolean z = (this.f12098f.mo18446au() == null || this.f12098f.mo18446au().mo21272a() == null) ? false : true;
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                if (z) {
                    mo21404x().mo20954l(12);
                } else {
                    mo21404x().mo20954l(MzUIController.f12293o);
                }
                mo21404x().mo20912c(MzUIController.f12279a);
            } else {
                if (z) {
                    mo21404x().mo20954l(12);
                } else {
                    mo21404x().mo20954l(MzUIController.f12294p);
                }
                mo21404x().mo20912c(MzUIController.f12280b);
            }
            mo21404x().mo20856a(-1, true);
            mo21404x().mo20920d(2, (int) R.drawable.mz_btn_shutter_default);
            mo21404x().mo20937g(false);
            if (this.f12098f.mo18438am() != null) {
                this.f12098f.mo18438am().mo21086j(true);
            }
        }
    }

    /* renamed from: b */
    public void mo21350b() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6109, new Class[0], Void.TYPE).isSupported) {
            super.mo21350b();
            if (this.f12103d != null && CameraModeType.m10957c(this.f12104e)) {
                mo21346a();
            }
        }
    }

    /* renamed from: c */
    public void mo21351c() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6110, new Class[0], Void.TYPE).isSupported) {
            mo21403w().mo21115a(CameraController.HdrMode.OFF);
            if (this.f12098f.mo18438am() != null) {
                this.f12098f.mo18438am().mo21086j(false);
            }
            if (this.f12103d != null) {
                this.f12103d.mo20873a(false, false, false);
            }
        }
    }

    /* renamed from: d */
    public CameraModeType.ModeType mo21352d() {
        return CameraModeType.ModeType.AUTO;
    }

    /* renamed from: e */
    public void mo21353e() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6111, new Class[0], Void.TYPE).isSupported && this.f12103d != null && this.f12103d.mo20843T() && CameraOptTask.m7846m()) {
            mo21404x().mo20927e(1, true);
            mo21404x().mo20856a(22, true);
        }
    }

    /* renamed from: f */
    public void mo21354f() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6112, new Class[0], Void.TYPE).isSupported) {
            MzSimplifyUIController jVar = this.f12103d;
            if (CameraOptTask.m7848o() && this.f12103d != null) {
                this.f12103d.mo20895aq();
            } else if (((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) && CameraController.m8868g().mo19522k() != null && this.f12103d != null) {
                this.f12103d.mo20952k(true);
            }
        }
    }

    /* renamed from: g */
    public void mo21355g() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6113, new Class[0], Void.TYPE).isSupported) {
            mo21401u().mo18443ar().mo21145G().mo23331a((MzFocusRenderer.C2745d) this);
            mo21346a();
            if (CameraOptTask.m7848o() && this.f12103d != null) {
                this.f12103d.mo20895aq();
            } else if (!(((CameraOptTask.m7849p() || !DeviceHelper.f13878ae) && CameraOptTask.m7846m()) || CameraController.m8868g().mo19522k() == null || this.f12103d == null)) {
                this.f12103d.mo20952k(true);
            }
            if (this.f12098f.mo18438am() != null) {
                this.f12098f.mo18438am().mo21086j(true);
                if (!mo21401u().mo18412aH()) {
                    return;
                }
                if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                    this.f12098f.mo18438am().mo21080g(true);
                }
            }
        }
    }

    /* renamed from: h */
    public boolean mo21356h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12097a, false, 6114, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12098f.mo18444as()) {
            mo21404x().mo20927e(5, false);
            mo21404x().mo20856a(-1, false);
        }
        if (this.f12098f.mo18472f()) {
            mo21404x().mo20927e(1, false);
            mo21404x().mo20856a(34, false);
        }
        return false;
    }

    /* renamed from: m */
    public String mo21361m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12097a, false, 6115, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String a = CameraSizeDefault.m16165a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: n */
    public CameraController.FocusMode mo21362n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12097a, false, 6116, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f12098f.mo18440ao() == 1) {
            return CameraController.FocusMode.FIXED;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: B */
    public MzFocusRenderer.C2743b mo20378B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12097a, false, 6120, new Class[0], MzFocusRenderer.C2743b.class);
        return proxy.isSupported ? (MzFocusRenderer.C2743b) proxy.result : this.f12098f.mo18438am().mo21100w();
    }

    /* renamed from: p */
    public void mo21364p() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6121, new Class[0], Void.TYPE).isSupported && this.f12098f.mo18443ar().mo21145G() != null) {
            this.f12098f.mo18443ar().mo21145G().mo23337e();
        }
    }

    /* renamed from: q */
    public void mo21365q() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6122, new Class[0], Void.TYPE).isSupported) {
            if ((this.f12103d.mo20843T() || this.f12098f.mo18472f()) && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo21404x().mo20927e(1, true);
                mo21404x().mo20856a(-1, true);
            }
        }
    }

    /* renamed from: r */
    public void mo21366r() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6123, new Class[0], Void.TYPE).isSupported) {
            if ((this.f12103d.mo20843T() || this.f12098f.mo18472f()) && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo21404x().mo20927e(1, true);
                mo21404x().mo20856a(-1, true);
            }
        }
    }

    /* renamed from: s */
    public void mo21367s() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6124, new Class[0], Void.TYPE).isSupported) {
            super.mo21367s();
            m13369W();
            if (this.f12102c.getString(R.string.setting_on_value).equals(mo21401u().mo18437al().getString("mz_pref_hdr_key", this.f12102c.getString(R.string.setting_off_value))) && m13370X()) {
                if (DeviceHelper.f13839S) {
                    CameraController.m8868g().mo19471a("cap-mode", BaseParameters.KEY_EFFECT_NAME_HDR, new boolean[0]);
                } else if (DeviceHelper.f13841U) {
                    CameraController.m8868g().mo19471a("cap-mode", "9", new boolean[0]);
                }
                if (DeviceHelper.f13840T) {
                    CameraController.m8868g().mo19471a("cap-mode", BaseParameters.KEY_EFFECT_NAME_HDR, new boolean[0]);
                }
            }
        }
    }

    /* renamed from: W */
    private void m13369W() {
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6125, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13856aI && DeviceHelper.f14043m && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f13912bL) {
            CameraController.m8868g().mo19471a("bokeh-mode", String.valueOf(0), new boolean[0]);
            CameraController.m8868g().mo19471a("bokeh-blur-value", String.valueOf(0), new boolean[0]);
            CameraController.m8868g().mo19471a("sat-mode", String.valueOf(1), new boolean[0]);
            CameraController.m8868g().mo19494b("zsl", "on", new boolean[0]);
        }
    }

    /* renamed from: X */
    private boolean m13370X() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12097a, false, 6126, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            CameraProxyV1 eVar = (CameraProxyV1) CameraController.m8868g().mo19522k();
            if (DeviceHelper.f13839S) {
                return BaseParameters.KEY_EFFECT_NAME_HDR.equals(eVar.mo19740f().get("cap-mode"));
            }
            if (DeviceHelper.f13841U) {
                return "9".equals(eVar.mo19740f().get("shot-mode"));
            }
            if (DeviceHelper.f13840T) {
                return BaseParameters.KEY_EFFECT_NAME_HDR.equals(eVar.mo19740f().getSceneMode());
            }
        }
        return false;
    }

    /* renamed from: t */
    public void mo21368t() {
        String str;
        FocusOverlaySimplifyManager am;
        CameraController.FocusMode g;
        if (!PatchProxy.proxy(new Object[0], this, f12097a, false, 6127, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = this.f12099g.mo22688a(new String[]{"mode", "is_back_camera", BaseParameters.KEY_EFFECT_NAME_HDR, "count_down", "location", "voice", "meshline", "level", "time_mark", "capture_type", "mirror", "night_scene", "watch_projection", "sd_card", "hd_fb"});
            a.put("capture_time", Long.toString(this.f12098f.mo18441ap()));
            a.put("exposure", CameraSettings.m9787d(mo21401u().mo18437al()));
            a.put("face_num", Integer.toString(this.f12098f.mo18443ar().mo21224y()));
            a.put("face_beauty", UsageStatsHelper.m16043a());
            a.put("flash", CameraController.m8868g().mo19534q().key);
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f12098f.mo18438am() == null || (am = this.f12098f.mo18438am()) == null || (g = am.mo21079g()) == null)) {
                str2 = g.getKey();
            }
            a.put("focus_mode", str2);
            if (DeviceHelper.f13877ad && this.f12103d != null && CameraController.m8868g().mo19484ab() && !this.f12103d.mo20901aw() && this.f12103d.mo20988y() != null) {
                a.put("asd", this.f12103d.mo20988y().getTitle());
            }
            if (!(!DeviceHelper.f13877ad || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("asd_enable", UsageStatsHelper.m16052f());
            }
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1) || (DeviceHelper.f13882ai && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f14029du ? "1" : "0");
            }
            this.f12099g.mo22693a("capture_info", a);
        }
    }
}
