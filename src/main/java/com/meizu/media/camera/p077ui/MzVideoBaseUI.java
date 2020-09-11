package com.meizu.media.camera.p077ui;

import android.os.Handler;
import android.os.Looper;
import com.meizu.camera.effectlib.effects.views.MzVideoSurfaceView;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.ac */
public class MzVideoBaseUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12685a;

    /* renamed from: b */
    private static final LogUtil.C2630a f12686b = new LogUtil.C2630a("MzVideoBaseUI");

    /* renamed from: c */
    private MzVideoSurfaceView f12687c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MzCamUI f12688d = null;

    /* renamed from: e */
    private Handler f12689e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private CameraUtil.ScreeAspectRatio f12690f = CameraUtil.ScreeAspectRatio.Ratio_4_3;

    public MzVideoBaseUI(MzCamUI iVar) {
        this.f12688d = iVar;
        this.f12687c = this.f12688d.mo22106aM();
    }

    /* renamed from: a */
    public void mo21822a() {
        if (!PatchProxy.proxy(new Object[0], this, f12685a, false, 7647, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f12686b, "init");
            mo21825a(true);
        }
    }

    /* renamed from: b */
    public void mo21826b() {
        if (!PatchProxy.proxy(new Object[0], this, f12685a, false, 7648, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f12686b, "onEnter");
            if (this.f12688d != null) {
                this.f12688d.mo22107aN();
            }
        }
    }

    /* renamed from: c */
    public void mo21827c() {
        if (!PatchProxy.proxy(new Object[0], this, f12685a, false, 7649, new Class[0], Void.TYPE).isSupported) {
            if (this.f12687c != null) {
                this.f12687c.setAlpha(1.0f);
            }
            if (this.f12688d != null) {
                this.f12688d.mo22143b(false, false);
            }
        }
    }

    /* renamed from: a */
    public void mo21824a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12685a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7650, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12687c != null) {
            this.f12687c.mo14269a(i);
        }
    }

    /* renamed from: d */
    public void mo21828d() {
        if (!PatchProxy.proxy(new Object[0], this, f12685a, false, 7651, new Class[0], Void.TYPE).isSupported && this.f12687c != null) {
            this.f12687c.mo14119k();
        }
    }

    /* renamed from: e */
    public void mo21829e() {
        if (!PatchProxy.proxy(new Object[0], this, f12685a, false, 7652, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f12686b, "onLeave");
            this.f12689e.postDelayed(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12691a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f12691a, false, 7656, new Class[0], Void.TYPE).isSupported && !CameraModeType.m10946a().equals(CameraModeType.ModeType.VIDEO) && !CameraModeType.m10946a().equals(CameraModeType.ModeType.SLOWMOTION) && !CameraModeType.m10946a().equals(CameraModeType.ModeType.TIMELAPSE) && !CameraModeType.m10946a().equals(CameraModeType.ModeType.NightVision) && MzVideoBaseUI.this.f12688d != null) {
                        MzVideoBaseUI.this.mo21825a(false);
                        MzVideoBaseUI.this.f12688d.mo22143b(true, false);
                    }
                }
            }, 300);
        }
    }

    /* renamed from: a */
    public void mo21823a(float f) {
        CameraUtil.ScreeAspectRatio a;
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f12685a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7653, new Class[]{Float.TYPE}, Void.TYPE).isSupported && (a = CameraUtil.m15829a(f)) != this.f12690f) {
            this.f12690f = a;
        }
    }

    /* renamed from: a */
    public void mo21825a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12685a, false, 7655, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12686b;
            LogUtil.m15942a(aVar, "setVideoPreviewViewVisiable showSurface:" + z);
            if (this.f12687c == null) {
                return;
            }
            if (z) {
                this.f12687c.setVisibility(0);
                this.f12687c.setAlpha(0.0f);
                return;
            }
            this.f12687c.setVisibility(8);
        }
    }
}
