package com.meizu.media.camera.mode;

import android.provider.Settings;
import com.meizu.imageproc.effects.renders.VideoMakeupRender;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzMakeupUI;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.l */
public class MakeupMode extends CameraMode implements MzMakeupUI.C2575d {

    /* renamed from: a */
    public static ChangeQuickRedirect f10861a;

    /* renamed from: b */
    private static final LogUtil.C2630a f10862b = new LogUtil.C2630a("MakeupMode");

    /* renamed from: c */
    private MzMakeupUI f10863c;

    /* renamed from: d */
    private UsageStatsHelper f10864d;

    /* renamed from: e */
    private int f10865e = 1;

    /* renamed from: f */
    private CameraModeListener f10866f;

    /* renamed from: A */
    public int mo20377A() {
        return 0;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return false;
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
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
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public MakeupMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        if (this.f10863c == null) {
            this.f10863c = mo20539R().mo18267u().mo22062Y();
            this.f10863c.mo22462a((MzMakeupUI.C2575d) this);
            this.f10863c.mo22461a(uVar);
        }
        this.f10864d = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
        this.f10866f = hVar;
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4867, new Class[0], Void.TYPE).isSupported && this.f10863c != null) {
            this.f10863c.mo22464b();
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4868, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
            mo20570B();
            mo20574r();
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4869, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            mo20402f_();
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10861a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4870, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m11585K();
        }
    }

    /* renamed from: K */
    private void m11585K() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4871, new Class[0], Void.TYPE).isSupported) {
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                mo20542U().mo21506a(5);
                mo20542U().mo21592g(MzUIController.f12298t);
                return;
            }
            mo20542U().mo21506a(12);
            mo20542U().mo21592g(MzUIController.f12299u);
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4872, new Class[0], Void.TYPE).isSupported) {
            if (this.f10863c != null) {
                this.f10863c.mo22460a();
            }
            if (this.f10863c != null) {
                this.f10863c.mo22466d();
            }
            mo20574r();
            m11585K();
        }
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.MAKEUP;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4873, new Class[0], Void.TYPE).isSupported) {
            mo20541T().mo20345j();
            this.f10863c.mo22464b();
            mo20570B();
            mo20573q();
        }
    }

    /* renamed from: c */
    public void mo20572c() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4874, new Class[0], Void.TYPE).isSupported) {
            try {
                this.f10865e = Settings.System.getInt(mo20540S().getContentResolver(), "cpu_l");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            LogUtil.C2630a aVar = f10862b;
            StringBuilder sb = new StringBuilder();
            sb.append("current cpu performance mode : ");
            sb.append(this.f10865e);
            sb.append(". (high - ");
            sb.append(0);
            sb.append(", low - ");
            boolean z = true;
            sb.append(1);
            sb.append(")");
            LogUtil.m15942a(aVar, sb.toString());
            if (this.f10865e != 0) {
                z = Settings.System.putInt(mo20540S().getContentResolver(), "cpu_l", 0);
            }
            LogUtil.C2630a aVar2 = f10862b;
            LogUtil.m15942a(aVar2, "Setting high performance mode(status : " + z + ")");
        }
    }

    /* renamed from: q */
    public void mo20573q() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4875, new Class[0], Void.TYPE).isSupported) {
            boolean putInt = Settings.System.putInt(mo20540S().getContentResolver(), "cpu_l", this.f10865e);
            LogUtil.C2630a aVar = f10862b;
            LogUtil.m15942a(aVar, "Setting cpu run in recorded performance mode(status : " + putInt + ")");
            LogUtil.C2630a aVar2 = f10862b;
            LogUtil.m15942a(aVar2, "current cpu performance mode : " + this.f10865e + ". (high - " + 0 + ", low - " + 1 + ")");
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4876, new Class[0], Void.TYPE).isSupported) {
            mo20573q();
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4877, new Class[0], Void.TYPE).isSupported) {
            mo20572c();
            mo20574r();
            m11585K();
        }
    }

    /* renamed from: a */
    public void mo20571a(String str, int i, boolean z) {
        Object[] objArr = {str, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10861a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4878, new Class[]{String.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10862b;
            LogUtil.m15952c(aVar, "key: " + str + " value: " + i);
            CameraController.m8868g().mo19471a(str, Integer.toString(i), z);
        }
    }

    /* renamed from: r */
    public void mo20574r() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4879, new Class[0], Void.TYPE).isSupported) {
            if (this.f10863c != null) {
                mo20571a("makeup-Style", VideoMakeupRender.m6383a(this.f10863c.mo22468f().mo22478a()), false);
            }
            mo20571a("faceEffect-Mode", 1, false);
            CameraController.m8868g().mo19480a(new boolean[0]);
        }
    }

    /* renamed from: B */
    public void mo20570B() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4880, new Class[0], Void.TYPE).isSupported) {
            this.f10863c.mo22467e();
            mo20571a("faceEffect-Mode", -1, false);
            mo20571a("makeup-Style", VideoMakeupRender.m6383a("original"), true);
        }
    }

    /* renamed from: ab */
    public void mo20457ab() {
        if (!PatchProxy.proxy(new Object[0], this, f10861a, false, 4881, new Class[0], Void.TYPE).isSupported) {
            mo20572c();
        }
    }
}
