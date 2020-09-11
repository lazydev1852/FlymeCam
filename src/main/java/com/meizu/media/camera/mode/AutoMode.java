package com.meizu.media.camera.mode;

import android.graphics.Point;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.a */
public class AutoMode extends CameraMode implements MzFocusRenderer.C2745d {

    /* renamed from: a */
    public static ChangeQuickRedirect f10631a;

    /* renamed from: b */
    private CameraModeListener f10632b;

    /* renamed from: c */
    private UsageStatsHelper f10633c;

    /* renamed from: d */
    private BarCodeMode f10634d;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: a */
    public void mo20386a(int i) {
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return false;
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return true;
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

    public AutoMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10632b = hVar;
        this.f10633c = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
        if (DeviceHelper.f13880ag && this.f10634d == null) {
            this.f10634d = new BarCodeMode(cameraActivity, lVar, uVar, hVar, modeType);
        }
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f10631a, false, 4554, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            if (this.f10634d != null) {
                this.f10634d.mo20387a(uVar);
            }
            super.mo20387a(uVar);
        }
    }

    /* renamed from: e_ */
    public void mo20491e_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4555, new Class[0], Void.TYPE).isSupported && mo20542U() != null) {
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                mo20542U().mo21592g(MzUIController.f12293o);
                mo20542U().mo21506a(MzUIController.f12279a);
            } else {
                mo20542U().mo21592g(MzUIController.f12294p);
                mo20542U().mo21506a(MzUIController.f12280b);
            }
            mo20542U().mo21510a(-1, true);
            mo20542U().mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            mo20542U().mo21593g(false);
            if (this.f10632b.mo17914ak() != null) {
                this.f10632b.mo17914ak().mo20230j(true);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10631a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4556, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                mo20491e_();
            }
            if (this.f10634d != null && this.f10632b.mo17926aw()) {
                if (z) {
                    this.f10634d.mo20405i_();
                } else if (!z2) {
                    this.f10634d.mo20406j_();
                    this.f10634d.mo20518c();
                }
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4557, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f10788j != null && CameraModeType.m10957c(this.f10789k)) {
                mo20491e_();
            }
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4558, new Class[0], Void.TYPE).isSupported) {
            if (this.f10634d != null) {
                this.f10634d.mo20404h_();
                this.f10634d = null;
            }
            mo20541T().mo20328a(CameraController.HdrMode.OFF);
            if (this.f10632b.mo17914ak() != null) {
                this.f10632b.mo17914ak().mo20230j(false);
            }
            if (this.f10788j != null) {
                this.f10788j.mo21533a(false, false, false);
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.AUTO;
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4559, new Class[0], Void.TYPE).isSupported) {
            if (this.f10634d != null) {
                this.f10634d.mo20405i_();
            }
            if (this.f10788j != null && this.f10788j.mo21602i() && CameraOptTask.m7846m()) {
                mo20542U().mo21581d(1, true);
                mo20542U().mo21510a(22, true);
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4560, new Class[0], Void.TYPE).isSupported) {
            if (this.f10634d != null) {
                this.f10634d.mo20406j_();
                if (this.f10632b.mo17926aw() && !this.f10634d.mo20521r()) {
                    this.f10634d.mo20518c();
                }
            }
            MzUIController uVar = this.f10788j;
            if (CameraOptTask.m7848o() && this.f10788j != null) {
                this.f10788j.mo21625q();
            } else if (((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) && CameraController.m8868g().mo19522k() != null && this.f10788j != null) {
                this.f10788j.mo21611l(true);
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4561, new Class[0], Void.TYPE).isSupported) {
            if (this.f10634d != null) {
                this.f10634d.mo20408l();
            }
            mo20539R().mo18267u().mo22131at().mo23331a((MzFocusRenderer.C2745d) this);
            mo20491e_();
            if (CameraOptTask.m7848o() && this.f10788j != null) {
                this.f10788j.mo21625q();
            } else if (!(((CameraOptTask.m7849p() || !DeviceHelper.f13878ae) && CameraOptTask.m7846m()) || CameraController.m8868g().mo19522k() == null || this.f10788j == null)) {
                this.f10788j.mo21611l(true);
            }
            if (this.f10632b.mo17914ak() != null) {
                this.f10632b.mo17914ak().mo20230j(true);
                if (!mo20539R().mo18191dO()) {
                    return;
                }
                if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                    this.f10632b.mo17914ak().mo20224g(true);
                }
            }
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4562, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10632b.mo18190dN()) {
            mo20542U().mo21581d(5, false);
            mo20542U().mo21510a(-1, false);
        }
        if (this.f10632b.mo17910ag()) {
            mo20542U().mo21581d(1, false);
            mo20542U().mo21510a(34, false);
        }
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4563, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10634d != null) {
            return this.f10634d.mo20421x();
        }
        return false;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4564, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f10632b.mo18211di() == 1) {
            return CameraController.FocusMode.FIXED;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: B */
    public MzFocusRenderer.C2743b mo20378B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4568, new Class[0], MzFocusRenderer.C2743b.class);
        return proxy.isSupported ? (MzFocusRenderer.C2743b) proxy.result : this.f10632b.mo17914ak().mo20245x();
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4569, new Class[0], Void.TYPE).isSupported) {
            super.mo20492m_();
            if (this.f10634d != null) {
                this.f10634d.mo20492m_();
            }
        }
    }

    /* renamed from: c */
    public void mo20489c() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4570, new Class[0], Void.TYPE).isSupported && this.f10634d != null) {
            this.f10634d.mo20406j_();
            this.f10634d.mo20518c();
        }
    }

    /* renamed from: q */
    public void mo20493q() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4571, new Class[0], Void.TYPE).isSupported && this.f10634d != null) {
            this.f10634d.mo20405i_();
        }
    }

    /* renamed from: a */
    public void mo20487a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10631a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4572, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f10634d != null) {
            this.f10634d.mo20514a(z);
        }
    }

    /* renamed from: a */
    public void mo20488a(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10631a, false, 4573, new Class[]{byte[].class}, Void.TYPE).isSupported && this.f10634d != null) {
            this.f10634d.mo20515a(bArr);
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4574, new Class[0], Void.TYPE).isSupported) {
            if (this.f10632b.mo18267u().mo22131at() != null) {
                this.f10632b.mo18267u().mo22131at().mo23337e();
            }
            if (this.f10634d != null && (this.f10632b.mo18211di() == 1 || this.f10632b.mo18211di() == DeviceHelper.f14029du)) {
                this.f10634d.mo20404h_();
                this.f10634d = null;
            } else if (this.f10634d == null && DeviceHelper.f13880ag) {
                this.f10634d = new BarCodeMode(mo20540S(), mo20541T(), mo20542U(), mo20539R(), mo20403g_());
            }
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4575, new Class[0], Void.TYPE).isSupported) {
            if ((this.f10788j.mo21602i() || this.f10632b.mo17910ag()) && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21581d(1, true);
                mo20542U().mo21510a(-1, true);
            }
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4576, new Class[0], Void.TYPE).isSupported) {
            if ((this.f10788j.mo21602i() || this.f10632b.mo17910ag()) && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21581d(1, true);
                mo20542U().mo21510a(-1, true);
            }
        }
    }

    /* renamed from: F */
    public void mo20382F() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4577, new Class[0], Void.TYPE).isSupported) {
            super.mo20382F();
            m11076K();
            if (this.f10787i.getString(R.string.setting_on_value).equals(mo20539R().mo17902aE().getString("mz_pref_hdr_key", this.f10787i.getString(R.string.setting_off_value))) && m11077L()) {
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

    /* renamed from: K */
    private void m11076K() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4578, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13856aI && DeviceHelper.f14043m && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f13912bL) {
            CameraController.m8868g().mo19471a("bokeh-mode", String.valueOf(0), new boolean[0]);
            CameraController.m8868g().mo19471a("bokeh-blur-value", String.valueOf(0), new boolean[0]);
            CameraController.m8868g().mo19471a("sat-mode", String.valueOf(1), new boolean[0]);
            CameraController.m8868g().mo19494b("zsl", "on", new boolean[0]);
        }
    }

    /* renamed from: L */
    private boolean m11077L() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4579, new Class[0], Boolean.TYPE);
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

    /* renamed from: r */
    public boolean mo20494r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4580, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10634d != null && this.f10634d.mo20510B();
    }

    /* renamed from: s */
    public boolean mo20495s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10631a, false, 4581, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10634d != null && this.f10634d.mo20521r();
    }

    /* renamed from: I */
    public void mo20384I() {
        Map<String, String> map;
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4582, new Class[0], Void.TYPE).isSupported) {
            String string = this.f10787i.getResources().getString(R.string.mz_filter_none_title);
            String i = UsageStatsHelper.m16042a(this.f10787i.getApplicationContext()).mo22706i();
            if ("none".equals(i)) {
                UsageStatsHelper.m16042a(this.f10787i.getApplicationContext()).mo22722x(string);
                i = string;
            }
            if (!string.equals(i)) {
                map = this.f10633c.mo22688a(new String[]{"mode", "is_back_camera", BaseParameters.KEY_EFFECT_NAME_HDR, "count_down", "location", "filter_value", "filter_type", "num_filter", "voice", "meshline", "level", "time_mark", "capture_type", "mirror", "night_scene", "watch_projection", "sd_card", "hd_fb"});
            } else {
                map = this.f10633c.mo22688a(new String[]{"mode", "is_back_camera", BaseParameters.KEY_EFFECT_NAME_HDR, "count_down", "location", "voice", "meshline", "level", "time_mark", "capture_type", "mirror", "night_scene", "watch_projection", "sd_card", "hd_fb"});
            }
            map.put("capture_time", Long.toString(this.f10632b.mo18186dJ()));
            map.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            map.put("zoom", Integer.toString(this.f10632b.mo18267u().mo22199w()));
            map.put("face_num", Integer.toString(this.f10632b.mo18267u().mo22055R()));
            map.put("face_beauty", UsageStatsHelper.m16043a());
            map.put("flash", CameraController.m8868g().mo19534q().key);
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            map.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f10632b.mo17914ak() == null || (ak = this.f10632b.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            map.put("focus_mode", str2);
            if (DeviceHelper.f13877ad && this.f10788j != null && CameraController.m8868g().mo19484ab() && !this.f10788j.mo21500W() && this.f10788j.mo21504a() != null) {
                map.put("asd", this.f10788j.mo21504a().getTitle());
            }
            if (DeviceHelper.f13877ad && this.f10632b.mo18211di() != 1) {
                map.put("asd_enable", UsageStatsHelper.m16052f());
            }
            if ((DeviceHelper.f13879af && this.f10632b.mo18211di() != 1) || (DeviceHelper.f13882ai && this.f10632b.mo18211di() == 1)) {
                map.put("device_mark", UsageStatsHelper.m16051e());
            }
            if (DeviceHelper.f13906bF && this.f10632b.mo18211di() == 1 && this.f10632b.mo18212dj() == 1) {
                map.put("gender", this.f10632b.mo18267u().mo22102aI());
            }
            if (DeviceHelper.f14027ds) {
                map.put("wide_angle", this.f10632b.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            this.f10633c.mo22693a("capture_info", map);
        }
    }

    /* renamed from: d_ */
    public void mo20490d_() {
        if (!PatchProxy.proxy(new Object[0], this, f10631a, false, 4583, new Class[0], Void.TYPE).isSupported && this.f10634d != null) {
            this.f10634d.mo20490d_();
        }
    }
}
