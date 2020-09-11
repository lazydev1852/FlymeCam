package com.meizu.media.camera.mode;

import androidx.core.view.ViewCompat;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.r */
public class SquareMode extends CameraMode implements MzFocusRenderer.C2745d {

    /* renamed from: a */
    public static ChangeQuickRedirect f11101a;

    /* renamed from: b */
    private CameraModeListener f11102b;

    /* renamed from: c */
    private UsageStatsHelper f11103c;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return false;
    }

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

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    SquareMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f11102b = hVar;
        if (uVar != null) {
            m11930c();
        }
        this.f11103c = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f11101a, false, 5073, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            super.mo20387a(uVar);
            m11930c();
        }
    }

    /* renamed from: c */
    private void m11930c() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5074, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21592g(MzUIController.f12274B);
            this.f10788j.mo21581d(134, true);
            if (this.f11102b.mo17914ak() != null) {
                this.f11102b.mo17914ak().mo20230j(true);
            }
            mo20539R().mo18267u().mo22151d(true);
            this.f10788j.mo21530a(true);
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11101a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5075, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                mo20542U().mo21506a(MzUIController.f12288j);
            }
            if (this.f10788j != null && !z2) {
                this.f10788j.mo21568b(!z);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5076, new Class[0], Void.TYPE).isSupported) {
            if (!(!NavigationBarUtils.m15972a() || this.f10787i == null || this.f10788j == null)) {
                this.f10788j.mo21635t((int) ViewCompat.MEASURED_STATE_MASK);
            }
            mo20542U().mo21506a(MzUIController.f12288j);
            mo20542U().mo21592g(MzUIController.f12274B);
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5077, new Class[0], Void.TYPE).isSupported) {
            mo20539R().mo18267u().mo22151d(false);
            this.f10788j.mo21530a(false);
            this.f10788j.mo21581d(134, true);
            this.f10788j.mo21533a(false, false, false);
            mo20541T().mo20328a(CameraController.HdrMode.OFF);
            if (this.f11102b.mo17914ak() != null) {
                this.f11102b.mo17914ak().mo20230j(false);
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.SQUARE;
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5078, new Class[0], Void.TYPE).isSupported && this.f10788j.mo21602i() && CameraOptTask.m7846m()) {
            mo20542U().mo21510a(22, true);
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5079, new Class[0], Void.TYPE).isSupported) {
            if (CameraOptTask.m7848o()) {
                this.f10788j.mo21625q();
            } else if (((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) && CameraController.m8868g().mo19522k() != null) {
                this.f10788j.mo21611l(true);
            }
            mo20542U().mo21506a(MzUIController.f12288j);
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5080, new Class[0], Void.TYPE).isSupported && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
            mo20542U().mo21510a(-1, true);
            mo20542U().mo21581d(132, true);
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5081, new Class[0], Void.TYPE).isSupported && !CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
            mo20542U().mo21510a(-1, true);
            mo20542U().mo21581d(128, true);
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11101a, false, 5082, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            mo20539R().mo18267u().mo22131at().mo23331a((MzFocusRenderer.C2745d) this);
            if (this.f11102b.mo17914ak() != null) {
                this.f11102b.mo17914ak().mo20230j(true);
                if (!mo20539R().mo18191dO()) {
                    return;
                }
                if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                    this.f11102b.mo17914ak().mo20224g(true);
                }
            }
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11101a, false, 5083, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20542U().mo21581d(4, false);
        mo20542U().mo21581d(128, false);
        mo20542U().mo21510a(-1, false);
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11101a, false, 5084, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String a = CameraSizeDefault.m16165a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: B */
    public MzFocusRenderer.C2743b mo20378B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11101a, false, 5088, new Class[0], MzFocusRenderer.C2743b.class);
        return proxy.isSupported ? (MzFocusRenderer.C2743b) proxy.result : this.f11102b.mo17914ak().mo20245x();
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5089, new Class[0], Void.TYPE).isSupported && this.f11102b.mo18267u().mo22131at() != null) {
            this.f11102b.mo18267u().mo22131at().mo23337e();
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        Map<String, String> map;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f11101a, false, 5090, new Class[0], Void.TYPE).isSupported) {
            String string = this.f10787i.getResources().getString(R.string.mz_filter_none_title);
            String i = UsageStatsHelper.m16042a(this.f10787i.getApplicationContext()).mo22706i();
            if ("none".equals(i)) {
                UsageStatsHelper.m16042a(this.f10787i.getApplicationContext()).mo22722x(string);
                i = string;
            }
            if (!string.equals(i)) {
                map = this.f11103c.mo22688a(new String[]{"mode", BaseParameters.KEY_EFFECT_NAME_HDR, "count_down", "location", "filter_value", "filter_type", "num_filter", "voice", "meshline", "level", "capture_type", "sd_card"});
            } else {
                map = this.f11103c.mo22688a(new String[]{"mode", BaseParameters.KEY_EFFECT_NAME_HDR, "count_down", "location", "voice", "meshline", "level", "capture_type", "sd_card"});
            }
            map.put("capture_time", Long.toString(this.f11102b.mo18186dJ()));
            map.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            map.put("zoom", Integer.toString(this.f11102b.mo18267u().mo22199w()));
            map.put("face_num", Integer.toString(this.f11102b.mo18267u().mo22055R()));
            map.put("flash", CameraController.m8868g().mo19534q().key);
            map.put("picture_ratio", "1 : 1");
            String str = "error mode";
            if (!(this.f11102b.mo17914ak() == null || (ak = this.f11102b.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str = h.getKey();
            }
            map.put("focus_mode", str);
            if (DeviceHelper.f14027ds) {
                map.put("wide_angle", this.f11102b.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            this.f11103c.mo22693a("capture_info", map);
        }
    }
}
