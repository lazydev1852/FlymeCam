package com.meizu.media.camera.mode;

import android.graphics.Point;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.e */
public class BlackWhiteMode extends CameraMode {

    /* renamed from: a */
    public static ChangeQuickRedirect f10779a;

    /* renamed from: b */
    private CameraModeListener f10780b;

    /* renamed from: c */
    private UsageStatsHelper f10781c;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return false;
    }

    /* renamed from: i_ */
    public void mo20405i_() {
    }

    /* renamed from: j_ */
    public void mo20406j_() {
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return true;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return true;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return true;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public BlackWhiteMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10780b = hVar;
        mo20542U().mo21592g(MzUIController.f12301w);
        mo20542U().mo21574c(1, false);
        this.f10781c = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10779a, false, 4685, new Class[0], Void.TYPE).isSupported) {
            mo20541T().mo20328a(CameraController.HdrMode.OFF);
            if (this.f10780b.mo17914ak() != null) {
                this.f10780b.mo17914ak().mo20230j(false);
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.BLACK_WHITE;
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10779a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4686, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m11315c();
        }
    }

    /* renamed from: c */
    private void m11315c() {
        if (!PatchProxy.proxy(new Object[0], this, f10779a, false, 4687, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21506a(12);
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10779a, false, 4688, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            if (this.f10780b.mo17914ak() != null) {
                this.f10780b.mo17914ak().mo20230j(false);
                if (mo20539R().mo18191dO() && (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1)) {
                    this.f10780b.mo17914ak().mo20224g(true);
                }
                m11315c();
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10779a, false, 4689, new Class[0], Void.TYPE).isSupported) {
            m11315c();
        }
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        if (ApiHelper.f14209j) {
            return CameraController.FocusMode.AUTO;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: I */
    public void mo20384I() {
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f10779a, false, 4690, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = this.f10781c.mo22688a(new String[]{"mode", "count_down", "location", "voice", "meshline", "level", "time_mark", "capture_type", "sd_card"});
            a.put("capture_time", Long.toString(this.f10780b.mo18186dJ()));
            a.put("zoom", Integer.toString(this.f10780b.mo18267u().mo22199w()));
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f10780b.mo17914ak() == null || (ak = this.f10780b.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1) || (DeviceHelper.f13882ai && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            this.f10781c.mo22693a("capture_info", a);
        }
    }
}
