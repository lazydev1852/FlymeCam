package com.meizu.media.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.text.TextUtils;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.meizu.media.camera.l */
public class MzCamParamsManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10476a;

    /* renamed from: b */
    public static String f10477b = "fast";

    /* renamed from: c */
    public static String f10478c;

    /* renamed from: d */
    public static String f10479d;

    /* renamed from: e */
    public static String f10480e = "night-enhancement";

    /* renamed from: f */
    public static String f10481f;

    /* renamed from: g */
    public static String f10482g;

    /* renamed from: h */
    public static String f10483h;

    /* renamed from: i */
    public static String f10484i;

    /* renamed from: j */
    public static String f10485j;

    /* renamed from: k */
    public static String f10486k;

    /* renamed from: l */
    public static String f10487l;

    /* renamed from: m */
    public static String f10488m;

    /* renamed from: n */
    private static final LogUtil.C2630a f10489n = new LogUtil.C2630a("ParamsManager");

    /* renamed from: A */
    private int f10490A = DeviceHelper.f14029du;

    /* renamed from: B */
    private CameraController.FlashMode f10491B = CameraController.FlashMode.NO_FLASH;

    /* renamed from: o */
    private boolean f10492o;

    /* renamed from: p */
    private boolean f10493p;

    /* renamed from: q */
    private boolean f10494q;

    /* renamed from: r */
    private boolean f10495r = false;

    /* renamed from: s */
    private boolean f10496s = false;

    /* renamed from: t */
    private int f10497t = -1;

    /* renamed from: u */
    private int f10498u;

    /* renamed from: v */
    private Activity f10499v;

    /* renamed from: w */
    private C2138a f10500w;

    /* renamed from: x */
    private boolean f10501x = false;

    /* renamed from: y */
    private boolean f10502y = false;

    /* renamed from: z */
    private String f10503z = null;

    /* renamed from: com.meizu.media.camera.l$a */
    /* compiled from: MzCamParamsManager */
    public interface C2138a {
        /* renamed from: M */
        boolean mo17864M();

        /* renamed from: aE */
        ComboPreferences mo17902aE();

        /* renamed from: ah */
        boolean mo18049ah(boolean z);

        /* renamed from: ai */
        void mo18050ai(boolean z);

        /* renamed from: ak */
        FocusOverlayManager mo17914ak();

        /* renamed from: b */
        void mo18057b(float f);

        /* renamed from: dA */
        boolean mo18177dA();

        /* renamed from: dB */
        int mo18178dB();

        /* renamed from: dC */
        void mo18179dC();

        /* renamed from: dD */
        boolean mo18180dD();

        /* renamed from: dE */
        boolean mo18181dE();

        /* renamed from: di */
        int mo18211di();

        /* renamed from: dq */
        boolean mo18219dq();

        /* renamed from: dr */
        ComboPreferences mo18220dr();

        /* renamed from: ds */
        String mo18221ds();

        /* renamed from: dt */
        int mo18222dt();

        /* renamed from: du */
        boolean mo18223du();

        /* renamed from: dv */
        boolean mo18224dv();

        /* renamed from: dw */
        boolean mo18225dw();

        /* renamed from: dx */
        boolean mo18226dx();

        /* renamed from: dy */
        boolean mo18227dy();

        /* renamed from: dz */
        boolean mo18228dz();

        /* renamed from: t */
        boolean mo18266t();

        /* renamed from: y */
        boolean mo17959y();
    }

    static {
        if (DeviceHelper.f13839S) {
            f10481f = "continuousshot";
            f10482g = "light-field";
            f10479d = BaseParameters.KEY_EFFECT_NAME_HDR;
            f10478c = "normal";
            f10483h = "iso-speed";
            f10484i = "shutter-value";
            f10486k = "saturation";
            f10485j = "contrast";
            f10487l = "middle";
            f10488m = "middle";
        } else if (DeviceHelper.f13841U) {
            f10481f = "35";
            f10482g = "33";
            f10478c = "0";
            f10479d = "9";
            f10483h = "iso-speed";
            f10484i = "shutter-value";
            f10486k = "saturation";
            f10485j = "contrast";
            f10487l = "0";
            f10488m = "0";
        } else if (DeviceHelper.f13840T) {
            f10481f = "continuousshot";
            f10484i = "shutter-value";
            f10478c = "auto";
            f10479d = BaseParameters.KEY_EFFECT_NAME_HDR;
            f10483h = "iso";
            f10486k = "saturation";
            f10485j = "contrast";
            f10487l = "5";
            f10488m = "5";
        }
    }

    public MzCamParamsManager(C2138a aVar, Activity activity) {
        this.f10500w = aVar;
        this.f10499v = activity;
    }

    /* renamed from: a */
    public boolean mo20326a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1580, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19543z();
    }

    /* renamed from: b */
    public boolean mo20333b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1581, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19437A();
    }

    /* renamed from: c */
    public boolean mo20336c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1582, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19438B();
    }

    /* renamed from: d */
    public boolean mo20339d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1583, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19439C();
    }

    /* renamed from: e */
    public boolean mo20340e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1584, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19440D();
    }

    /* renamed from: a */
    public void mo20322a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10476a, false, 1585, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (mo20336c()) {
                CameraController.m8868g().mo19477a(z, true);
            }
            if (mo20339d()) {
                CameraController.m8868g().mo19497b(z, true);
            }
        }
    }

    /* renamed from: f */
    public void mo20341f() {
        FocusOverlayManager ak;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1586, new Class[0], Void.TYPE).isSupported && (ak = this.f10500w.mo17914ak()) != null) {
            ak.mo20208a((CameraController.FocusMode) null);
            CameraController.m8868g().mo19467a(ak.mo20225h(), new boolean[0]);
        }
    }

    /* renamed from: a */
    public int mo20315a(int i, boolean z, boolean z2) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10476a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 1587, new Class[]{Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        LogUtil.C2630a aVar = f10489n;
        LogUtil.m15942a(aVar, "zoomValue is " + i + ", needSetTouchZoom = " + z);
        CameraController.m8868g().mo19501c(i, true);
        if (z2) {
            EventBus.m21789a().mo27980d(10);
        }
        return CameraController.m8868g().mo19538u();
    }

    /* renamed from: a */
    public boolean mo20327a(CameraController.FlashMode flashMode) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{flashMode}, this, f10476a, false, 1588, new Class[]{CameraController.FlashMode.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraUtil.m15862a((Object) this.f10491B, (Object) flashMode)) {
            return false;
        }
        this.f10491B = flashMode;
        LogUtil.C2630a aVar = f10489n;
        LogUtil.m15952c(aVar, "setFlashParameters(" + flashMode + ")");
        return true;
    }

    /* renamed from: g */
    public CameraController.FlashMode mo20342g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1589, new Class[0], CameraController.FlashMode.class);
        if (proxy.isSupported) {
            return (CameraController.FlashMode) proxy.result;
        }
        CameraController.FlashMode q = CameraController.m8868g().mo19534q();
        if (q == null) {
            this.f10491B = CameraController.FlashMode.FLASH_MODE_OFF;
        }
        if (this.f10491B == CameraController.FlashMode.NO_FLASH) {
            this.f10491B = q;
        }
        return this.f10491B;
    }

    /* renamed from: a */
    public void mo20316a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10476a, false, 1590, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f10498u = i | this.f10498u;
            if (CameraController.m8868g().mo19522k() == null) {
                this.f10498u = 0;
            } else if (this.f10500w.mo17959y()) {
                mo20317a(this.f10498u, new boolean[0]);
                this.f10498u = 0;
            } else {
                this.f10500w.mo18179dC();
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo20317a(int i, boolean... zArr) {
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect = f10476a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1591, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setCameraParameters " + i);
            if (CameraController.m8868g().mo19522k() != null) {
                if ((i & 1) != 0) {
                    m10770B();
                }
                if ((i & 2) != 0) {
                    m10771C();
                }
                if ((i & 16) != 0) {
                    m10787z();
                }
                if ((i & 4) != 0) {
                    m10772D();
                }
                CameraController.m8868g().mo19480a(zArr);
            }
        }
    }

    /* renamed from: h */
    public void mo20343h() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1593, new Class[0], Void.TYPE).isSupported) {
            this.f10500w.mo18049ah(this.f10495r);
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "updating CameraPreview mIsNeedRestartPreview = " + this.f10495r);
            this.f10495r = false;
        }
    }

    /* renamed from: y */
    private void m10786y() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1595, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13849aB || DeviceHelper.f13853aF || DeviceHelper.f13840T) {
                if (this.f10500w.mo18266t()) {
                    CameraController.m8868g().mo19471a("recording-hint", "true", new boolean[0]);
                } else {
                    CameraController.m8868g().mo19471a("recording-hint", "false", new boolean[0]);
                }
                LogUtil.C2630a aVar = f10489n;
                LogUtil.m15952c(aVar, "updateParametersRecordingHint recording-hint(" + this.f10500w.mo18266t() + ")");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c0, code lost:
        if (r2.equals("4 : 3") != false) goto L_0x02c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02e7, code lost:
        if (r2.equals("16 : 9") != false) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01db, code lost:
        if (r0 != null) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01f7, code lost:
        if (r0 != null) goto L_0x01dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03a1  */
    /* renamed from: z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10787z() {
        /*
            r14 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f10476a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 1596(0x63c, float:2.236E-42)
            r2 = r14
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 != 0) goto L_0x0028
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.String r1 = "attempting to set picture size without camera device"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        L_0x0028:
            android.app.Activity r1 = r14.f10499v
            if (r1 != 0) goto L_0x0034
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.String r1 = "attempting to set picture size with null activity"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        L_0x0034:
            com.meizu.media.camera.l$a r1 = r14.f10500w
            com.meizu.media.camera.e r1 = r1.mo18220dr()
            if (r1 != 0) goto L_0x003d
            return
        L_0x003d:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            r4 = 0
            if (r2 != r3) goto L_0x0091
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13894au
            if (r2 == 0) goto L_0x0091
            com.meizu.media.camera.l$a r2 = r14.f10500w
            int r2 = r2.mo18211di()
            int r3 = com.meizu.media.camera.util.DeviceHelper.f13949bw
            if (r2 != r3) goto L_0x0091
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            int r2 = com.meizu.media.camera.util.DeviceHelper.f13901bA
            int r3 = com.meizu.media.camera.util.DeviceHelper.f13952bz
            boolean[] r0 = new boolean[r0]
            r1.mo19500c(r2, r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13901bA
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13952bz
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adjust picture size for sub camera in manual 20M size: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x03dd
        L_0x0091:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            if (r2 != r3) goto L_0x00e2
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13895av
            if (r2 != 0) goto L_0x00a1
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13896aw
            if (r2 == 0) goto L_0x00e2
        L_0x00a1:
            boolean r2 = r14.f10502y
            if (r2 == 0) goto L_0x00e2
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            int r2 = com.meizu.media.camera.util.DeviceHelper.f13951by
            int r3 = com.meizu.media.camera.util.DeviceHelper.f13950bx
            boolean[] r0 = new boolean[r0]
            r1.mo19500c(r2, r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13951by
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13950bx
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adjust picture size for camera in manual high picture size: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x03dd
        L_0x00e2:
            com.meizu.media.camera.l$a r2 = r14.f10500w
            java.lang.String r2 = r2.mo18221ds()
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.util.List r3 = r3.mo19530o()
            com.meizu.media.camera.util.ac$a r5 = f10489n
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "supportedPictureSize is "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = ", pictureSize: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r6)
            boolean r5 = r14.f10492o
            if (r5 == 0) goto L_0x0186
            com.meizu.media.camera.l$a r5 = r14.f10500w
            boolean r5 = r5.mo18266t()
            if (r5 == 0) goto L_0x0186
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9783b((com.meizu.media.camera.ComboPreferences) r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x0133
            android.app.Activity r2 = r14.f10499v
            com.meizu.media.camera.l$a r3 = r14.f10500w
            int r3 = r3.mo18211di()
            com.meizu.media.camera.util.CameraSizeDefault.m16169a((android.content.Context) r2, (int) r3)
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9783b((com.meizu.media.camera.ComboPreferences) r1)
        L_0x0133:
            if (r2 == 0) goto L_0x013a
            java.lang.String r1 = com.meizu.media.camera.util.CameraSizeUtil.m16181c(r2)
            r4 = r1
        L_0x013a:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 != r2) goto L_0x03dd
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13862aO
            if (r1 == 0) goto L_0x0181
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "sw-vdis"
            boolean r3 = r14.f10494q
            if (r3 != 0) goto L_0x0156
            boolean r3 = r14.f10493p
            if (r3 == 0) goto L_0x0153
            goto L_0x0156
        L_0x0153:
            java.lang.String r3 = "on"
            goto L_0x0158
        L_0x0156:
            java.lang.String r3 = "off"
        L_0x0158:
            boolean[] r0 = new boolean[r0]
            r1.mo19471a((java.lang.String) r2, (java.lang.String) r3, (boolean[]) r0)
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "set sw-vdis: "
            r1.append(r2)
            boolean r2 = r14.f10494q
            if (r2 != 0) goto L_0x0175
            boolean r2 = r14.f10493p
            if (r2 == 0) goto L_0x0172
            goto L_0x0175
        L_0x0172:
            java.lang.String r2 = "on"
            goto L_0x0177
        L_0x0175:
            java.lang.String r2 = "off"
        L_0x0177:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
        L_0x0181:
            r14.m10769A()
            goto L_0x03dd
        L_0x0186:
            com.meizu.media.camera.l$a r5 = r14.f10500w
            boolean r5 = r5.mo18226dx()
            if (r5 == 0) goto L_0x01e0
            com.meizu.media.camera.l$a r1 = r14.f10500w
            boolean r1 = r1.mo18224dv()
            if (r1 != 0) goto L_0x01c4
            java.lang.String r1 = com.meizu.media.camera.util.DeviceHelper.f14011dc
            if (r1 == 0) goto L_0x01c4
            java.lang.String r0 = com.meizu.media.camera.util.DeviceHelper.f14011dc
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            if (r0 == 0) goto L_0x01a3
            r4 = r0
        L_0x01a3:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 != r1) goto L_0x03dd
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraControllerV2 r0 = (com.meizu.media.camera.camcontroller.CameraControllerV2) r0
            java.lang.String r1 = com.meizu.media.camera.util.DeviceHelper.f14012dd
            android.graphics.Point r1 = com.meizu.media.camera.util.CameraSizeUtil.m16173a((java.lang.String) r1)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x03dd
            int r2 = r1.x
            int r1 = r1.y
            r0.mo19563a((int) r2, (int) r1)
            goto L_0x03dd
        L_0x01c4:
            com.meizu.media.camera.l$a r1 = r14.f10500w
            boolean r1 = r1.mo18224dv()
            if (r1 == 0) goto L_0x03dd
            java.lang.String r1 = "4 : 3"
            com.meizu.media.camera.util.CameraSizeUtil.m16177a((boolean) r0)
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16182d(r1)
            if (r0 == 0) goto L_0x03dd
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            if (r0 == 0) goto L_0x03dd
        L_0x01dd:
            r4 = r0
            goto L_0x03dd
        L_0x01e0:
            com.meizu.media.camera.l$a r5 = r14.f10500w
            boolean r5 = r5.mo18177dA()
            if (r5 == 0) goto L_0x01fa
            java.lang.String r1 = "4 : 3"
            com.meizu.media.camera.util.CameraSizeUtil.m16177a((boolean) r0)
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16182d(r1)
            if (r0 == 0) goto L_0x03dd
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            if (r0 == 0) goto L_0x03dd
            goto L_0x01dd
        L_0x01fa:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x0204
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
        L_0x0204:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x0219
            android.app.Activity r2 = r14.f10499v
            com.meizu.media.camera.l$a r5 = r14.f10500w
            int r5 = r5.mo18211di()
            com.meizu.media.camera.util.CameraSizeDefault.m16168a(r2, r5, r3)
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
        L_0x0219:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x022c
            java.lang.String r2 = com.meizu.media.camera.util.CameraSizeDefault.m16165a()
            if (r2 != 0) goto L_0x022c
            com.meizu.media.camera.util.CameraSizeUtil.m16177a((boolean) r0)
            java.lang.String r2 = com.meizu.media.camera.util.CameraSizeDefault.m16165a()
        L_0x022c:
            if (r2 != 0) goto L_0x0237
            com.meizu.media.camera.util.ac$a r1 = f10489n
            java.lang.String r2 = "pictureSize null ,set to 4000x3000"
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            java.lang.String r2 = "4000x3000"
        L_0x0237:
            r1 = 120(0x78, float:1.68E-43)
            int r1 = r2.indexOf(r1)
            r5 = -1
            if (r1 != r5) goto L_0x0241
            return
        L_0x0241:
            java.lang.String r5 = r2.substring(r0, r1)
            int r5 = java.lang.Integer.parseInt(r5)
            r6 = 1
            int r1 = r1 + r6
            java.lang.String r1 = r2.substring(r1)
            int r1 = java.lang.Integer.parseInt(r1)
            if (r5 <= r1) goto L_0x025a
            java.lang.String r2 = com.meizu.media.camera.util.DeviceSizeTable.m16185a((int) r5, (int) r1, (java.lang.String) r4)
            goto L_0x025e
        L_0x025a:
            java.lang.String r2 = com.meizu.media.camera.util.DeviceSizeTable.m16185a((int) r1, (int) r5, (java.lang.String) r4)
        L_0x025e:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r7 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            boolean r4 = r4.equals(r7)
            r7 = 1944(0x798, float:2.724E-42)
            r8 = 2592(0xa20, float:3.632E-42)
            r9 = 1512(0x5e8, float:2.119E-42)
            r10 = 2688(0xa80, float:3.767E-42)
            r11 = 2048(0x800, float:2.87E-42)
            r12 = 4000(0xfa0, float:5.605E-42)
            r13 = 3280(0xcd0, float:4.596E-42)
            if (r4 == 0) goto L_0x029e
            java.lang.String r0 = "4 : 3"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0288
            r0 = 1536(0x600, float:2.152E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r10 = 1536(0x600, float:2.152E-42)
            goto L_0x0392
        L_0x0288:
            java.lang.String r0 = "16 : 9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0296
        L_0x0290:
            r9 = 2688(0xa80, float:3.767E-42)
            r10 = 1512(0x5e8, float:2.119E-42)
            goto L_0x0392
        L_0x0296:
            r0 = 1024(0x400, float:1.435E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r10 = 1024(0x400, float:1.435E-42)
            goto L_0x0392
        L_0x029e:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13884ak
            if (r4 != 0) goto L_0x02a6
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13885al
            if (r4 == 0) goto L_0x02c8
        L_0x02a6:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r11 = com.meizu.media.camera.mode.CameraModeType.ModeType.SUPER_NIGHT
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x02c8
            com.meizu.media.camera.l$a r4 = r14.f10500w
            int r4 = r4.mo18211di()
            if (r4 != r6) goto L_0x02c8
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0390
        L_0x02c2:
            r9 = 2592(0xa20, float:3.632E-42)
            r10 = 1944(0x798, float:2.724E-42)
            goto L_0x0392
        L_0x02c8:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13884ak
            if (r4 == 0) goto L_0x02ea
            boolean r4 = r14.f10501x
            if (r4 == 0) goto L_0x02ea
            com.meizu.media.camera.l$a r4 = r14.f10500w
            boolean r4 = r4.mo18223du()
            if (r4 != 0) goto L_0x02ea
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x02e1
            goto L_0x02c2
        L_0x02e1:
            java.lang.String r4 = "16 : 9"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0390
            goto L_0x0290
        L_0x02ea:
            com.meizu.media.camera.l$a r4 = r14.f10500w
            int r4 = r4.mo18211di()
            int r6 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r4 != r6) goto L_0x0390
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.ModeType.SUPER_NIGHT
            boolean r4 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r4)
            if (r4 == 0) goto L_0x0390
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f14007dA
            if (r4 == 0) goto L_0x0349
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0310
            r0 = 2460(0x99c, float:3.447E-42)
            r9 = 3280(0xcd0, float:4.596E-42)
            r10 = 2460(0x99c, float:3.447E-42)
            goto L_0x0392
        L_0x0310:
            java.lang.String r4 = "16 : 9"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0320
            r0 = 1845(0x735, float:2.585E-42)
            r9 = 3280(0xcd0, float:4.596E-42)
            r10 = 1845(0x735, float:2.585E-42)
            goto L_0x0392
        L_0x0320:
            java.lang.String r4 = "18 : 9"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0342
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r4 == 0) goto L_0x0390
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13883aj
            if (r4 == 0) goto L_0x0390
            int r4 = com.meizu.media.camera.util.CameraUtil.m15809a()
            int r6 = com.meizu.media.camera.util.CameraUtil.m15865b()
            java.lang.String r4 = com.meizu.media.camera.util.CameraSizeUtil.m16174a((int) r4, (int) r6)
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0390
        L_0x0342:
            r0 = 1640(0x668, float:2.298E-42)
            r9 = 3280(0xcd0, float:4.596E-42)
            r10 = 1640(0x668, float:2.298E-42)
            goto L_0x0392
        L_0x0349:
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0358
            r0 = 3000(0xbb8, float:4.204E-42)
            r9 = 4000(0xfa0, float:5.605E-42)
            r10 = 3000(0xbb8, float:4.204E-42)
            goto L_0x0392
        L_0x0358:
            java.lang.String r4 = "16 : 9"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0367
            r0 = 2250(0x8ca, float:3.153E-42)
            r9 = 4000(0xfa0, float:5.605E-42)
            r10 = 2250(0x8ca, float:3.153E-42)
            goto L_0x0392
        L_0x0367:
            java.lang.String r4 = "18 : 9"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0389
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r4 == 0) goto L_0x0390
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13883aj
            if (r4 == 0) goto L_0x0390
            int r4 = com.meizu.media.camera.util.CameraUtil.m15809a()
            int r6 = com.meizu.media.camera.util.CameraUtil.m15865b()
            java.lang.String r4 = com.meizu.media.camera.util.CameraSizeUtil.m16174a((int) r4, (int) r6)
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0390
        L_0x0389:
            r0 = 2000(0x7d0, float:2.803E-42)
            r9 = 4000(0xfa0, float:5.605E-42)
            r10 = 2000(0x7d0, float:2.803E-42)
            goto L_0x0392
        L_0x0390:
            r9 = 0
            r10 = 0
        L_0x0392:
            if (r9 == 0) goto L_0x03a1
            android.app.Activity r0 = r14.f10499v
            double r4 = (double) r5
            double r1 = (double) r1
            double r7 = r4 / r1
            r5 = r0
            r6 = r3
            java.lang.String r0 = com.meizu.media.camera.util.CameraUtil.m15835a((android.app.Activity) r5, (java.util.List<android.graphics.Point>) r6, (double) r7, (int) r9, (int) r10)
            goto L_0x03a5
        L_0x03a1:
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16182d(r2)
        L_0x03a5:
            com.meizu.media.camera.util.ac$a r1 = f10489n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "setCameraPictureSize: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            java.lang.String r4 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "picSize:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.l$a r0 = r14.f10500w
            int r0 = r0.mo18211di()
            r14.f10490A = r0
        L_0x03dd:
            r14.m10784b((java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzCamParamsManager.m10787z():void");
    }

    /* renamed from: b */
    private void m10784b(String str) {
        Point point;
        String str2 = str;
        if (!PatchProxy.proxy(new Object[]{str2}, this, f10476a, false, 1597, new Class[]{String.class}, Void.TYPE).isSupported) {
            Point j = CameraController.m8868g().mo19520j();
            if (j == null || str2 == null) {
                LogUtil.C2630a aVar = f10489n;
                StringBuilder sb = new StringBuilder();
                sb.append("getPictureSize from ");
                sb.append(j == null ? "mParameters" : "paramMapCache");
                sb.append(" failed, return without updating previewSize&Ratio and ZSD");
                LogUtil.m15949b(aVar, sb.toString());
                return;
            }
            int indexOf = str2.indexOf(120);
            if (indexOf != -1) {
                j.x = Integer.parseInt(str2.substring(0, indexOf));
                j.y = Integer.parseInt(str2.substring(indexOf + 1));
            }
            if ((DeviceHelper.f13853aF || DeviceHelper.f13910bJ == CameraController.CameraApi.API2) && this.f10492o && this.f10500w.mo18266t()) {
                int parseInt = Integer.parseInt(CameraSizeDefault.m16170b((Context) this.f10499v, this.f10500w.mo18211di()));
                if (DeviceHelper.f13910bJ != CameraController.CameraApi.API2 || parseInt == -1 || this.f10494q || this.f10493p || !(parseInt == DeviceHelper.f14005cz || parseInt == DeviceHelper.f14004cy)) {
                    point = new Point(j.x, j.y);
                } else {
                    point = new Point(1920, 1080);
                }
            } else {
                List<Point> p = CameraController.m8868g().mo19532p();
                if (p.size() != 0) {
                    if (CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT) || CameraModeType.m10946a().equals(CameraModeType.ModeType.DOCUMENT)) {
                        point = CameraUtil.m15827a(this.f10499v, p, ((double) j.x) / ((double) j.y), this.f10501x, true);
                    } else {
                        point = CameraUtil.m15827a(this.f10499v, p, ((double) j.x) / ((double) j.y), this.f10501x, false);
                    }
                } else {
                    return;
                }
            }
            if ((this.f10500w.mo18226dx() || this.f10500w.mo18177dA()) && this.f10500w.mo18224dv() && DeviceHelper.f13873aZ) {
                point.x = 960;
                point.y = 720;
            } else if (this.f10500w.mo18177dA() && this.f10500w.mo18227dy()) {
                point.x = 1920;
                point.y = 1080;
            }
            Point n = CameraController.m8868g().mo19528n();
            m10783a(j);
            m10785e(true);
            if (!(point == null || n == null || n.equals(point))) {
                LogUtil.C2630a aVar2 = f10489n;
                LogUtil.m15954d(aVar2, "set preview size. optimal: " + point.x + "x" + point.y + " original: " + n.x + "x" + n.y);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(point.x);
                sb2.append("x");
                sb2.append(point.y);
                String sb3 = sb2.toString();
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    CameraController.m8868g().mo19471a("preview-size", sb3, new boolean[0]);
                } else {
                    CameraController.m8868g().mo19450a(point.x, point.y, new boolean[0]);
                }
                this.f10495r = true;
                LogUtil.C2630a aVar3 = f10489n;
                LogUtil.m15952c(aVar3, "updateParametersPictureSize need restart preview (" + this.f10495r + ")");
            }
            if (point == null || point.x == 0 || point.y == 0) {
                LogUtil.m15952c(f10489n, "Preview size is null");
                return;
            }
            LogUtil.m15954d(f10489n, "updating aspect ratio");
            if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2)) {
                CameraController.m8868g().mo19450a(point.x, point.y, new boolean[0]);
            }
            this.f10500w.mo18057b(((float) point.x) / ((float) point.y));
            EffectRenderContext.m4369h().mo14173a(point.x, point.y);
            LogUtil.C2630a aVar4 = f10489n;
            LogUtil.m15952c(aVar4, "Preview size is " + point.x + "x" + point.y);
        }
    }

    /* renamed from: A */
    private void m10769A() {
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1598, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13840T) {
            boolean z = Integer.valueOf(CameraSizeDefault.m16170b((Context) this.f10499v, this.f10500w.mo18211di())).intValue() == DeviceHelper.f14004cy;
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setVideCdsMode: " + this.f10493p + "，mIs4KRecording:" + z);
            String str = null;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
                str = ((CameraProxyV1) k).mo19740f().get("video-cds-mode");
            }
            String str2 = (this.f10493p || z) ? "off" : "on";
            if (str != str2) {
                CameraController.m8868g().mo19471a("video-cds-mode", str2, new boolean[0]);
                this.f10495r = true;
            }
        }
    }

    /* renamed from: a */
    private void m10783a(Point point) {
        if (PatchProxy.proxy(new Object[]{point}, this, f10476a, false, 1599, new Class[]{Point.class}, Void.TYPE).isSupported || !DeviceHelper.f13839S) {
            return;
        }
        if (this.f10492o || this.f10500w.mo17864M()) {
            CameraController.m8868g().mo19494b("zsd-mode", "off", new boolean[0]);
        } else if (this.f10500w.mo18178dB() != -1) {
            boolean a = CameraController.m8868g().mo19482a("zsd-mode");
            boolean z = this.f10500w.mo18178dB() == 1 && point.x <= DeviceHelper.f13918bR;
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setZsdForMtk currentZsd(" + a + "), needZsd(" + z + ")");
            if (a != z) {
                CameraController.m8868g().mo19494b("zsd-mode", z ? "on" : "off", new boolean[0]);
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f10495r = true;
                    LogUtil.C2630a aVar2 = f10489n;
                    LogUtil.m15952c(aVar2, "setZsdForMtk need restart preview (" + this.f10495r + ")");
                }
            }
        }
    }

    /* renamed from: e */
    private void m10785e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10476a, false, 1600, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13840T && this.f10500w.mo18178dB() != -1) {
            boolean a = CameraController.m8868g().mo19482a("zsl");
            boolean z2 = this.f10500w.mo18178dB() == 1;
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setZsdForQCOM currentZsl(" + a + "), needZsl(" + z2 + ") " + z);
            if (a != (z && z2)) {
                CameraController.m8868g().mo19494b("zsl", (!z || !z2) ? "off" : "on", new boolean[0]);
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f10495r = true;
                    LogUtil.C2630a aVar2 = f10489n;
                    LogUtil.m15952c(aVar2, "setZsdForQCOM need restart preview (" + this.f10495r + ")");
                }
            }
        }
    }

    /* renamed from: i */
    public boolean mo20344i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, ARPMessageType.MSG_TYPE_SHARE, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceHelper.f13839S) {
            return CameraController.m8868g().mo19482a("zsd-mode");
        }
        if (DeviceHelper.f13840T) {
            return CameraController.m8868g().mo19482a("zsl");
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x024e, code lost:
        r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g().mo19522k();
     */
    /* renamed from: B */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10770B() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f10476a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 1602(0x642, float:2.245E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int[] r1 = com.meizu.media.camera.util.CameraUtil.m15910p()
            r2 = 30
            r3 = 1
            if (r1 == 0) goto L_0x01ca
            int r4 = r1.length
            if (r4 <= 0) goto L_0x01ca
            com.meizu.media.camera.l$a r4 = r8.f10500w
            boolean r4 = r4.mo18266t()
            if (r4 == 0) goto L_0x00f4
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13853aF
            if (r1 == 0) goto L_0x00aa
            boolean r1 = r8.f10493p
            if (r1 == 0) goto L_0x008e
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            int r1 = r1.mo19733b()
            if (r1 != 0) goto L_0x008e
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r1 = com.meizu.media.camera.util.DeviceHelper.f14038h
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r4 = com.meizu.media.camera.util.DeviceHelper.f14038h
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r4 = com.meizu.media.camera.util.DeviceHelper.SLOW_MOTION_FPS.SMF_100
            if (r1 != r4) goto L_0x0067
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            r5 = 100
            java.lang.String r5 = java.lang.Integer.toString(r5)
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "100000,100000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x00aa
        L_0x0067:
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r1 = com.meizu.media.camera.util.DeviceHelper.f14038h
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r4 = com.meizu.media.camera.util.DeviceHelper.f14038h
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r4 = com.meizu.media.camera.util.DeviceHelper.SLOW_MOTION_FPS.SMF_120
            if (r1 != r4) goto L_0x00aa
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            r5 = 120(0x78, float:1.68E-43)
            java.lang.String r5 = java.lang.Integer.toString(r5)
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "120000,120000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x00aa
        L_0x008e:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            java.lang.String r5 = java.lang.Integer.toString(r2)
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "30000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
        L_0x00aa:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13849aB
            if (r1 == 0) goto L_0x00e1
            boolean r1 = r8.f10493p
            if (r1 == 0) goto L_0x00d2
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            int r1 = r1.mo19733b()
            if (r1 != 0) goto L_0x00d2
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r5 = com.meizu.media.camera.util.DeviceHelper.f14038h
            java.lang.String r5 = r5.getValue()
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x00e1
        L_0x00d2:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            java.lang.String r5 = java.lang.Integer.toString(r2)
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
        L_0x00e1:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x01ca
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "30000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x00f4:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13830J
            if (r4 == 0) goto L_0x0145
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            int r1 = r1.mo19733b()
            if (r1 != r3) goto L_0x0115
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "14000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x0115:
            com.meizu.media.camera.l$a r1 = r8.f10500w
            com.meizu.media.camera.e r1 = r1.mo17902aE()
            java.lang.String r1 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
            java.lang.String r4 = "5312x2988"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0136
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "14000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x0136:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "14000,24000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x0145:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f14047q
            if (r4 != 0) goto L_0x014d
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13832L
            if (r4 == 0) goto L_0x0169
        L_0x014d:
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r4 = r4.mo19522k()
            int r4 = r4.mo19733b()
            if (r4 != r3) goto L_0x0169
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "14000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x0169:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13822B
            if (r4 != 0) goto L_0x01bd
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13824D
            if (r4 == 0) goto L_0x0172
            goto L_0x01bd
        L_0x0172:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r5 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE
            if (r4 == r5) goto L_0x017e
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r5 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG
            if (r4 != r5) goto L_0x0194
        L_0x017e:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r4 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r4)
            if (r4 == 0) goto L_0x0194
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "7500,24000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
            goto L_0x01ca
        L_0x0194:
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r5 = "preview-fps-range"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = ""
            r6.append(r7)
            r7 = r1[r0]
            r6.append(r7)
            java.lang.String r7 = ","
            r6.append(r7)
            r1 = r1[r3]
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            boolean[] r6 = new boolean[r0]
            r4.mo19471a((java.lang.String) r5, (java.lang.String) r1, (boolean[]) r6)
            goto L_0x01ca
        L_0x01bd:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.String r5 = "14000,30000"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
        L_0x01ca:
            r8.m10786y()
            com.meizu.media.camera.l$a r1 = r8.f10500w
            boolean r1 = r1.mo18266t()
            if (r1 == 0) goto L_0x023d
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x023d
            com.meizu.media.camera.l$a r1 = r8.f10500w
            com.meizu.media.camera.e r1 = r1.mo17902aE()
            if (r1 == 0) goto L_0x023c
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13863aP
            if (r4 == 0) goto L_0x020c
            com.meizu.media.camera.l$a r4 = r8.f10500w
            int r4 = r4.mo18211di()
            int r5 = com.meizu.media.camera.util.DeviceHelper.f13949bw
            if (r4 == r5) goto L_0x023c
            com.meizu.media.camera.util.DeviceHelper$EIS_SUPPORT_SCENE r4 = com.meizu.media.camera.util.DeviceHelper.f14019dk
            com.meizu.media.camera.util.DeviceHelper$EIS_SUPPORT_SCENE r5 = com.meizu.media.camera.util.DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE
            if (r4 != r5) goto L_0x020c
            com.meizu.media.camera.l$a r4 = r8.f10500w
            int r4 = r4.mo18211di()
            int r5 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r4 != r5) goto L_0x020c
            goto L_0x023c
        L_0x020c:
            boolean r4 = r8.f10493p
            if (r4 != 0) goto L_0x021f
            boolean r4 = r8.f10494q
            if (r4 != 0) goto L_0x021f
            java.lang.String r4 = "pref_camera_video_high_frame_rate_key"
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r1 = r1.getString(r4, r2)
            goto L_0x0232
        L_0x021f:
            boolean r4 = r8.f10493p
            if (r4 == 0) goto L_0x022e
            java.lang.String r2 = com.meizu.media.camera.util.CameraUtil.m15911q()
            java.lang.String r4 = "pref_camera_slowmotion_high_frame_rate_key"
            java.lang.String r1 = r1.getString(r4, r2)
            goto L_0x0232
        L_0x022e:
            java.lang.String r1 = java.lang.Integer.toString(r2)
        L_0x0232:
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            boolean r4 = r8.f10493p
            r2.mo19472a((java.lang.String) r1, (boolean) r4)
            goto L_0x023d
        L_0x023c:
            return
        L_0x023d:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0265
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 == 0) goto L_0x0265
            com.meizu.media.camera.camcontroller.e r1 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r1
            android.hardware.Camera$Parameters r1 = r1.mo19740f()
            java.lang.String r4 = "video-stabilization-supported"
            java.lang.String r1 = r1.get(r4)
            goto L_0x0266
        L_0x0265:
            r1 = r2
        L_0x0266:
            java.lang.String r4 = "true"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x027b
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "video-stabilization"
            java.lang.String r5 = "false"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
        L_0x027b:
            com.meizu.media.camera.l$a r1 = r8.f10500w
            com.meizu.media.camera.e r1 = r1.mo17902aE()
            java.lang.String r4 = "pref_video_quality_key"
            java.lang.String r1 = r1.getString(r4, r2)
            com.meizu.media.camera.l$a r2 = r8.f10500w
            int r2 = r2.mo18211di()
            if (r2 == r3) goto L_0x02ab
            com.meizu.media.camera.util.ac$a r3 = f10489n
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "current cameraId = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", reset it to facing back for getting video quality"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r2)
            goto L_0x02ac
        L_0x02ab:
            r0 = r2
        L_0x02ac:
            java.util.ArrayList r0 = com.meizu.media.camera.util.CameraSizeUtil.m16176a((int) r0)
            if (r1 == 0) goto L_0x02b8
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x02c3
        L_0x02b8:
            android.app.Activity r0 = r8.f10499v
            com.meizu.media.camera.l$a r1 = r8.f10500w
            int r1 = r1.mo18211di()
            com.meizu.media.camera.util.CameraSizeDefault.m16172c(r0, r1)
        L_0x02c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzCamParamsManager.m10770B():void");
    }

    /* renamed from: C */
    private void m10771C() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1603, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19541x()) {
            CameraController.m8868g().mo19501c(this.f10500w.mo18222dt(), new boolean[0]);
        }
    }

    /* renamed from: D */
    private void m10772D() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1604, new Class[0], Void.TYPE).isSupported) {
            m10774F();
            m10775G();
            m10776H();
            m10777I();
            FocusOverlayManager ak = this.f10500w.mo17914ak();
            if (ak != null) {
                ak.mo20208a((CameraController.FocusMode) null);
                CameraController.m8868g().mo19467a(this.f10500w.mo17914ak().mo20225h(), new boolean[0]);
            }
            m10778J();
            m10782N();
            m10779K();
            m10780L();
            if (mo20340e() && ApiHelper.f14203d) {
                m10773E();
            }
        }
    }

    /* renamed from: E */
    private void m10773E() {
        CameraController.FocusMode aa;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1605, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (aa = CameraController.m8868g().mo19483aa()) != null) {
            this.f10500w.mo18050ai(CameraController.FocusMode.CONTINUOUS_PICTURE.equals(aa));
        }
    }

    /* renamed from: F */
    private void m10774F() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1606, new Class[0], Void.TYPE).isSupported && mo20336c() && this.f10500w.mo17914ak() != null) {
            CameraController.m8868g().mo19471a("auto-exposure-lock", this.f10500w.mo17914ak().mo20237p() ? "true" : "false", new boolean[0]);
        }
    }

    /* renamed from: G */
    private void m10775G() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1607, new Class[0], Void.TYPE).isSupported && mo20339d() && this.f10500w.mo17914ak() != null) {
            CameraController.m8868g().mo19471a("auto-whitebalance-lock", this.f10500w.mo17914ak().mo20237p() ? "true" : "false", new boolean[0]);
        }
    }

    /* renamed from: H */
    private void m10776H() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1608, new Class[0], Void.TYPE).isSupported && mo20326a() && this.f10500w.mo17914ak() != null) {
            CameraController.m8868g().mo19476a(false, (List<Rect>) this.f10500w.mo17914ak().mo20227i());
        }
    }

    /* renamed from: I */
    private void m10777I() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1609, new Class[0], Void.TYPE).isSupported && mo20333b() && this.f10500w.mo17914ak() != null) {
            CameraController.m8868g().mo19476a(true, (List<Rect>) this.f10500w.mo17914ak().mo20229j());
        }
    }

    /* renamed from: J */
    private void m10778J() {
        Camera.Size a;
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1610, new Class[0], Void.TYPE).isSupported) {
            CameraController.m8868g().mo19471a("jpeg-quality", Integer.toString(DeviceHelper.f13843W ? 95 : 100), new boolean[0]);
            if (!CameraModeType.m10946a().equals(CameraModeType.ModeType.MAKEUP)) {
                Point j = CameraController.m8868g().mo19520j();
                List<Camera.Size> list = null;
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
                    list = ((CameraProxyV1) k).mo19740f().getSupportedJpegThumbnailSizes();
                }
                if (!(j == null || (a = CameraUtil.m15828a(list, ((double) j.x) / ((double) j.y))) == null)) {
                    CameraController.m8868g().mo19489b(a.width, a.height, new boolean[0]);
                }
                CameraController.m8868g().mo19471a("jpeg-thumbnail-quality", Integer.toString(100), new boolean[0]);
                return;
            }
            CameraController.m8868g().mo19489b(0, 0, new boolean[0]);
        }
    }

    /* renamed from: K */
    private void m10779K() {
        ComboPreferences aE;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1611, new Class[0], Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null && this.f10500w.mo18219dq()) {
            CameraController.m8868g().mo19470a(aE);
        }
    }

    /* renamed from: L */
    private void m10780L() {
        ComboPreferences aE;
        String str;
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1612, new Class[0], Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null) {
            String string = aE.getString("pref_camera_scenemode_key", this.f10499v.getString(R.string.pref_camera_scenemode_default));
            List arrayList = new ArrayList();
            if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) || (k = CameraController.m8868g().mo19522k()) == null) {
                str = null;
            } else {
                Camera.Parameters f = ((CameraProxyV1) k).mo19740f();
                List supportedSceneModes = f.getSupportedSceneModes();
                str = f.getSceneMode();
                arrayList = supportedSceneModes;
            }
            if (!CameraUtil.m15864a(string, (List<String>) arrayList)) {
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    CameraProxy k2 = CameraController.m8868g().mo19522k();
                    if (k2 != null) {
                        string = ((CameraProxyV1) k2).mo19740f().getSceneMode();
                    }
                } else {
                    string = str;
                }
                if (string == null) {
                    string = "auto";
                }
            } else if (BaseParameters.KEY_EFFECT_NAME_HDR.equals(string)) {
                if (!CameraModeType.m10972h(CameraModeType.m10962e(CameraModeType.m10946a())) || CameraUtil.m15862a((Object) string, (Object) str)) {
                    if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                        CameraProxy k3 = CameraController.m8868g().mo19522k();
                        if (k3 != null) {
                            string = ((CameraProxyV1) k3).mo19740f().getSceneMode();
                        }
                    } else {
                        string = str;
                    }
                    if (string == null) {
                        string = "auto";
                    }
                } else {
                    CameraController.m8868g().mo19471a("scene-mode", string, new boolean[0]);
                }
            } else if (!CameraUtil.m15862a((Object) string, (Object) str)) {
                CameraController.m8868g().mo19471a("scene-mode", string, new boolean[0]);
            }
            FocusOverlayManager ak = this.f10500w.mo17914ak();
            if (ak != null) {
                if ("auto".equals(string) || BaseParameters.KEY_EFFECT_NAME_HDR.equals(string)) {
                    m10781M();
                    if (ak != null) {
                        ak.mo20208a((CameraController.FocusMode) null);
                        CameraController.m8868g().mo19467a(ak.mo20225h(), new boolean[0]);
                        return;
                    }
                    return;
                }
                ak.mo20208a(CameraController.m8868g().mo19483aa());
            }
        }
    }

    /* renamed from: M */
    private void m10781M() {
        ComboPreferences aE;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1613, new Class[0], Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null) {
            if (this.f10491B == CameraController.FlashMode.NO_FLASH) {
                this.f10491B = CameraController.FlashMode.convertFlashMode(aE.getString("pref_camera_flashmode_key", this.f10499v.getString(R.string.pref_camera_flashmode_default)));
            }
            CameraController.m8868g().mo19466a(this.f10491B, new boolean[0]);
        }
    }

    /* renamed from: N */
    private void m10782N() {
        ComboPreferences aE;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1614, new Class[0], Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null) {
            if (DeviceHelper.f13839S || DeviceHelper.f13840T) {
                CameraController.m8868g().mo19471a("rec-mute-ogg", "1", new boolean[0]);
            }
            mo20325a(false);
            if (aE.getString("mz_pref_time_mark_key", this.f10499v.getString(R.string.setting_off_value)).equals(this.f10499v.getString(R.string.setting_off_value)) || !this.f10500w.mo18181dE()) {
                CameraController.m8868g().mo19471a("digital-Watermark", "0", new boolean[0]);
                CameraController.m8868g().mo19471a("watermark-Date", "null", new boolean[0]);
            } else {
                CameraController.m8868g().mo19471a("digital-Watermark", "1", new boolean[0]);
            }
            mo20346k();
            if (DeviceHelper.f13838R && (!CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL) || DeviceHelper.f13840T)) {
                CameraController.m8868g().mo19471a("antibanding", "auto", new boolean[0]);
            }
            if (DeviceHelper.f13856aI) {
                String string = aE.getString("mz_pref_stereo_level_key", "0");
                if (DeviceHelper.f13839S) {
                    if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY) {
                        CameraController.m8868g().mo19471a("stereo-dof-level", Integer.toString(1), new boolean[0]);
                    } else {
                        CameraController.m8868g().mo19471a("stereo-dof-level", string, new boolean[0]);
                    }
                } else if (DeviceHelper.f13840T) {
                    CameraController.m8868g().mo19471a("preview-blurintensity", Integer.toString(100), new boolean[0]);
                    CameraController.m8868g().mo19471a("capture-blurintensity", Integer.toString(80), new boolean[0]);
                }
            }
            if (DeviceHelper.f14027ds && DeviceHelper.f14034dz && this.f10500w.mo18211di() == DeviceHelper.f14029du) {
                CameraController.m8868g().mo19511e(!this.f10499v.getString(R.string.setting_off_value).equals(aE.getString("mz_pref_wide_angle_undistort_enable_key", this.f10499v.getString(R.string.setting_off_value))));
            }
            if (DeviceHelper.f13863aP && CameraModeType.m10983m(CameraModeType.ModeType.VIDEO)) {
                CameraController.m8868g().mo19514f(this.f10499v.getString(R.string.setting_on_value).equals(aE.getString("mz_pref_eis_switch_key", this.f10499v.getString(R.string.setting_on_value))));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0153 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20325a(boolean... r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f10476a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<boolean[]> r0 = boolean[].class
            r6[r8] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 1615(0x64f, float:2.263E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            com.meizu.media.camera.util.ac$a r0 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateExposureParams:"
            r1.append(r2)
            boolean r2 = r10[r8]
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.l$a r0 = r9.f10500w
            com.meizu.media.camera.e r0 = r0.mo17902aE()
            if (r0 != 0) goto L_0x003e
            return
        L_0x003e:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x0056
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r2 != r3) goto L_0x004f
            java.lang.String r2 = "center-weighted"
            goto L_0x0051
        L_0x004f:
            java.lang.String r2 = "1"
        L_0x0051:
            boolean[] r3 = new boolean[r8]
            r1.mo19474a((java.lang.String) r2, (boolean[]) r3)
        L_0x0056:
            java.lang.String r1 = com.meizu.media.camera.CameraSettings.m9787d((com.meizu.media.camera.ComboPreferences) r0)
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x006d
            int r2 = com.meizu.media.camera.util.DeviceHelper.f13943bq
            r3 = 3
            if (r2 == r3) goto L_0x006d
            java.lang.String r1 = "-0.3"
        L_0x006d:
            com.meizu.media.camera.util.DeviceHelper$EXPOSURE_STEP r2 = com.meizu.media.camera.util.DeviceHelper.f13937bk
            com.meizu.media.camera.util.DeviceHelper$EXPOSURE_STEP r3 = com.meizu.media.camera.util.DeviceHelper.EXPOSURE_STEP.STANDARD
            if (r2 != r3) goto L_0x011f
            r0 = 0
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ g -> 0x0091 }
            int r2 = r2.mo19487b()     // Catch:{ g -> 0x0091 }
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ g -> 0x008f }
            int r3 = r3.mo19498c()     // Catch:{ g -> 0x008f }
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ g -> 0x008d }
            float r4 = r4.mo19504d()     // Catch:{ g -> 0x008d }
            goto L_0x00ab
        L_0x008d:
            r4 = move-exception
            goto L_0x0094
        L_0x008f:
            r4 = move-exception
            goto L_0x0093
        L_0x0091:
            r4 = move-exception
            r2 = 0
        L_0x0093:
            r3 = 0
        L_0x0094:
            com.meizu.media.camera.util.ac$a r5 = f10489n
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "camera is null!!! "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r4)
            r4 = 0
        L_0x00ab:
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x00c7
            com.meizu.media.camera.util.ac$a r10 = f10489n
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "invalid exposure step: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.meizu.media.camera.util.LogUtil.m15956e(r10, r0)
            goto L_0x0183
        L_0x00c7:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r1)
            java.math.BigDecimal r1 = new java.math.BigDecimal
            java.lang.String r4 = java.lang.Float.toString(r4)
            r1.<init>(r4)
            r4 = 2
            r5 = 4
            java.math.BigDecimal r0 = r0.divide(r1, r4, r5)
            int r0 = r0.intValue()
            if (r0 < r3) goto L_0x0108
            if (r0 > r2) goto L_0x0108
            com.meizu.media.camera.util.ac$a r1 = f10489n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "set expose value:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "exposure-compensation"
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r1.mo19471a((java.lang.String) r2, (java.lang.String) r0, (boolean[]) r10)
            goto L_0x0183
        L_0x0108:
            com.meizu.media.camera.util.ac$a r10 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "invalid exposure range: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15956e(r10, r0)
            goto L_0x0183
        L_0x011f:
            com.meizu.media.camera.util.DeviceHelper$EXPOSURE_STEP r2 = com.meizu.media.camera.util.DeviceHelper.f13937bk
            com.meizu.media.camera.util.DeviceHelper$EXPOSURE_STEP r3 = com.meizu.media.camera.util.DeviceHelper.EXPOSURE_STEP.STEP_POINT_ONE
            if (r2 == r3) goto L_0x017a
            java.lang.String r2 = "."
            boolean r2 = r1.contains(r2)
            if (r2 == 0) goto L_0x012e
            goto L_0x017a
        L_0x012e:
            int r0 = com.meizu.media.camera.CameraSettings.m9785c((com.meizu.media.camera.ComboPreferences) r0)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ g -> 0x0145 }
            int r1 = r1.mo19487b()     // Catch:{ g -> 0x0145 }
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ g -> 0x0143 }
            int r2 = r2.mo19498c()     // Catch:{ g -> 0x0143 }
            goto L_0x0151
        L_0x0143:
            r2 = move-exception
            goto L_0x0147
        L_0x0145:
            r2 = move-exception
            r1 = 0
        L_0x0147:
            com.meizu.media.camera.util.ac$a r3 = f10489n
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r3, r2)
            r2 = 0
        L_0x0151:
            if (r0 < r2) goto L_0x0163
            if (r0 > r1) goto L_0x0163
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "exposure-compensation"
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r1.mo19471a((java.lang.String) r2, (java.lang.String) r0, (boolean[]) r10)
            goto L_0x0183
        L_0x0163:
            com.meizu.media.camera.util.ac$a r10 = f10489n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "invalid exposure range: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15956e(r10, r0)
            goto L_0x0183
        L_0x017a:
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "exposure-compensation"
            r0.mo19471a((java.lang.String) r2, (java.lang.String) r1, (boolean[]) r10)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzCamParamsManager.mo20325a(boolean[]):void");
    }

    /* renamed from: a */
    public void mo20320a(String str, Object... objArr) {
        Class[] clsArr = {String.class, Object[].class};
        if (!PatchProxy.proxy(new Object[]{str, objArr}, this, f10476a, false, 1616, clsArr, Void.TYPE).isSupported && !TextUtils.isEmpty(str) && DeviceHelper.f13838R) {
            CameraController.m8868g().mo19473a(str, objArr);
        }
    }

    /* renamed from: j */
    public void mo20345j() {
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1617, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13838R) {
            mo20320a(f10478c, new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo20318a(long j) {
        ComboPreferences aE;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f10476a, false, 1620, new Class[]{Long.TYPE}, Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null && DeviceHelper.f13838R) {
            String string = aE.getString("mz_pref_time_mark_key", this.f10499v.getString(R.string.setting_off_value));
            if ((DeviceHelper.f13910bJ != CameraController.CameraApi.API1 || (!CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) && !CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING))) && !string.equals(this.f10499v.getString(R.string.setting_off_value)) && this.f10500w.mo18181dE()) {
                LogUtil.C2630a aVar = f10489n;
                LogUtil.m15942a(aVar, "set watermark: " + j);
                CameraController.m8868g().mo19471a("digital-Watermark", "1", new boolean[0]);
                CameraController.m8868g().mo19471a("watermark-Date", DeviceHelper.f13979cZ.format(Long.valueOf(j)), new boolean[0]);
                return;
            }
            CameraController.m8868g().mo19471a("digital-Watermark", "0", new boolean[0]);
            CameraController.m8868g().mo19471a("watermark-Date", "null", new boolean[0]);
        }
    }

    /* renamed from: k */
    public void mo20346k() {
        ComboPreferences aE;
        if (PatchProxy.proxy(new Object[0], this, f10476a, false, 1621, new Class[0], Void.TYPE).isSupported || (aE = this.f10500w.mo17902aE()) == null) {
            return;
        }
        if (DeviceHelper.f13879af || DeviceHelper.f13882ai) {
            String string = aE.getString("mz_pref_device_mark_key", this.f10499v.getString(R.string.setting_on_value));
            if ((DeviceHelper.f13910bJ == CameraController.CameraApi.API1 && CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT)) || string.equals(this.f10499v.getString(R.string.setting_off_value)) || !this.f10500w.mo18180dD()) {
                CameraController.m8868g().mo19471a("device-Watermark", "0", new boolean[0]);
                this.f10503z = null;
                CameraController.m8868g().mo19493b((String) null);
                LogUtil.m15942a(f10489n, "set devicemark off");
            } else if (string.equals(this.f10499v.getString(R.string.setting_on_value))) {
                CameraController.m8868g().mo19471a("device-Watermark", "1", new boolean[0]);
                this.f10503z = null;
                CameraController.m8868g().mo19493b((String) null);
                LogUtil.m15942a(f10489n, "set devicemark default on");
            } else if (DeviceHelper.f13881ah) {
                CameraController.m8868g().mo19471a("device-Watermark", "2", new boolean[0]);
                this.f10503z = aE.getString("mz_pref_custom_device_mark_key", this.f10499v.getString(R.string.mz_custom_device_mark_defalut_hint));
                CameraController.m8868g().mo19493b(aE.getString("mz_pref_custom_device_mark_key", this.f10499v.getString(R.string.mz_custom_device_mark_defalut_hint)));
                LogUtil.m15942a(f10489n, "set devicemark custom on");
            }
        }
    }

    /* renamed from: l */
    public boolean mo20347l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1622, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ComboPreferences aE = this.f10500w.mo17902aE();
        if (aE == null) {
            return false;
        }
        if ((DeviceHelper.f13879af || DeviceHelper.f13882ai) && !aE.getString("mz_pref_device_mark_key", this.f10499v.getString(R.string.setting_on_value)).equals(this.f10499v.getString(R.string.setting_off_value)) && this.f10500w.mo18180dD()) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public String mo20348m() {
        return this.f10503z;
    }

    /* renamed from: n */
    public boolean mo20349n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1623, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ComboPreferences aE = this.f10500w.mo17902aE();
        if (aE != null && !aE.getString("mz_pref_time_mark_key", this.f10499v.getString(R.string.setting_off_value)).equals(this.f10499v.getString(R.string.setting_off_value)) && this.f10500w.mo18181dE()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void mo20330b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10476a, false, 1624, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setStereoMode :" + z);
            this.f10496s = z;
            if (!DeviceHelper.f13856aI) {
                return;
            }
            if (DeviceHelper.f13839S) {
                if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY) {
                    CameraController.m8868g().mo19471a("stereo-image-refocus", z ? "on" : "off", new boolean[0]);
                } else if (z) {
                    CameraController.m8868g().mo19471a("stereo-image-refocus", "on", new boolean[0]);
                    CameraController.m8868g().mo19471a("stereo-vsdof-mode", "on", new boolean[0]);
                    CameraController.m8868g().mo19471a("stereo-denoise-mode", "off", new boolean[0]);
                } else {
                    CameraController.m8868g().mo19471a("stereo-image-refocus", "off", new boolean[0]);
                    CameraController.m8868g().mo19471a("stereo-vsdof-mode", "off", new boolean[0]);
                }
            } else if (DeviceHelper.f14042l && z) {
                CameraController.m8868g().mo19471a("dual-camera-mode", "on", new boolean[0]);
                CameraController.m8868g().mo19471a("dual-camera-id", "2", new boolean[0]);
                CameraController.m8868g().mo19471a("dual-camera-main-camera", "true", new boolean[0]);
                CameraController.m8868g().mo19494b("zsl", "on", new boolean[0]);
            }
        }
    }

    /* renamed from: o */
    public void mo20350o() {
        ComboPreferences aE;
        if (!PatchProxy.proxy(new Object[0], this, f10476a, false, 1625, new Class[0], Void.TYPE).isSupported && (aE = this.f10500w.mo17902aE()) != null) {
            String string = aE.getString("mz_pref_mirror", this.f10499v.getString(R.string.setting_on_value));
            if (CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP) || (!string.equals(this.f10499v.getString(R.string.setting_off_value)) && !this.f10492o)) {
                CameraController.m8868g().mo19471a("front-mirror", "1", new boolean[0]);
            } else {
                CameraController.m8868g().mo19471a("front-mirror", "0", new boolean[0]);
            }
        }
    }

    /* renamed from: p */
    public boolean mo20351p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1626, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ComboPreferences aE = this.f10500w.mo17902aE();
        if (aE == null) {
            return false;
        }
        return aE.getString("mz_pref_mirror", this.f10499v.getString(R.string.setting_on_value)).equals(this.f10499v.getString(R.string.setting_on_value));
    }

    /* renamed from: a */
    public void mo20323a(boolean z, boolean z2, boolean z3) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10476a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1633, new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10492o = z;
            this.f10493p = z2;
            this.f10494q = z3;
            if (!this.f10492o && !this.f10493p) {
                this.f10495r = true;
            } else if (DeviceHelper.f13849aB || DeviceHelper.f13853aF || DeviceHelper.f13840T) {
                this.f10495r = true;
            }
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15952c(aVar, "setRecording need restart preview (" + this.f10495r + ")");
        }
    }

    /* renamed from: q */
    public boolean mo20352q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1634, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraController.m8868g().mo19447Y() != CameraController.HdrMode.OFF) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo20328a(CameraController.HdrMode hdrMode) {
        boolean z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hdrMode}, this, f10476a, false, 1635, new Class[]{CameraController.HdrMode.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean z2 = CameraController.HdrMode.ON == hdrMode;
        if (DeviceHelper.f13840T) {
            this.f10500w.mo17902aE().edit().putString("pref_camera_scenemode_key", z2 ? BaseParameters.KEY_EFFECT_NAME_HDR : "auto").apply();
        }
        if (!DeviceHelper.f14039i || z2 || !mo20352q()) {
            z = false;
        } else {
            this.f10495r = true;
            z = true;
        }
        if (DeviceHelper.f13875ab) {
            mo20320a(f10479d, hdrMode);
        } else if (z2) {
            mo20320a(f10479d, new Object[0]);
        } else {
            mo20345j();
        }
        return z;
    }

    /* renamed from: c */
    public void mo20334c(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10476a, false, 1636, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13830J || DeviceHelper.f13831K) {
                CameraController.m8868g().mo19471a("metering-spot-isolate", z ? "1" : "0", new boolean[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo20324a(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f10476a, false, 1637, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && DeviceHelper.f13840T) {
            CameraController.m8868g().mo19471a("is-flyme-camera-apk", z ? "0" : "1", zArr);
        }
    }

    /* renamed from: b */
    public void mo20329b(int i, boolean... zArr) {
        int i2;
        String str;
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect = f10476a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1638, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported || ApiHelper.f14210k || i == this.f10497t || CameraController.m8868g().mo19522k() == null) {
            return;
        }
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1 || this.f10500w.mo18228dz()) {
            try {
                if (this.f10500w.mo18211di() == 1 && i == 0) {
                    i2 = (i + 270) % 360;
                } else if (!DeviceHelper.f13841U || DeviceHelper.f13830J) {
                    i2 = (i + 90) % 360;
                } else {
                    i2 = CameraUtil.m15882c(this.f10500w.mo18211di(), i);
                }
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    str = BaseParameters.KEY_PICTURE_ROTATION;
                } else {
                    str = Contants.CameraV2Key.DEVICE_ORIENTATION.getKeyName();
                }
                CameraController.m8868g().mo19471a(str, Integer.toString(i2), zArr);
                this.f10497t = i;
            } catch (Exception unused) {
                LogUtil.m15952c(f10489n, "set FD rotation failed");
            }
        }
    }

    /* renamed from: r */
    public void mo20353r() {
        this.f10497t = -1;
    }

    /* renamed from: b */
    public void mo20331b(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f10476a, false, 1639, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15942a(aVar, "setMFLLParams:" + z + " needUpdateNow:" + zArr);
            if (!DeviceHelper.f13854aG || CameraController.m8868g().mo19522k() == null) {
                return;
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                if (DeviceHelper.f13840T) {
                    CameraController.m8868g().mo19471a("mfll-on", (!z || mo20352q()) ? "0" : "1", zArr);
                } else {
                    CameraController.m8868g().mo19471a("mfll-on", z ? "1" : "0", zArr);
                }
            } else if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                CameraController.m8868g().mo19471a(Contants.CameraV2Key.MFNR_ENABLE.getKeyName(), z ? "1" : "0", zArr);
            }
        }
    }

    /* renamed from: c */
    public void mo20335c(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f10476a, false, 1640, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15942a(aVar, "setMzFBMode:" + z + " needUpdateNow:" + zArr);
            this.f10501x = z;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19471a("mzfb-enable", z ? "1" : "0", zArr);
            }
        }
    }

    /* renamed from: d */
    public void mo20337d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10476a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1641, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15942a(aVar, "enableManualHighPicSize:" + z);
            this.f10502y = z;
        }
    }

    /* renamed from: s */
    public boolean mo20354s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1642, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f10489n;
        LogUtil.m15942a(aVar, "isManualHighPicSizeEnable:" + this.f10502y);
        return this.f10502y;
    }

    /* renamed from: d */
    public void mo20338d(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f10476a, false, 1643, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported && DeviceHelper.f13856aI && DeviceHelper.f13841U && DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15942a(aVar, "setMzSteroMode:" + z + " needUpdateNow:" + zArr);
            this.f10501x = z;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19471a("dual_camera_mode", z ? "1" : "0", false);
                CameraController.m8868g().mo19471a("bokeh-mode", z ? "1" : "0", false);
                CameraController.m8868g().mo19471a("bokeh-blur-value", z ? "1" : "0", zArr);
            }
        }
    }

    /* renamed from: a */
    public void mo20321a(String str, boolean... zArr) {
        Class[] clsArr = {String.class, boolean[].class};
        if (!PatchProxy.proxy(new Object[]{str, zArr}, this, f10476a, false, 1644, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10489n;
            LogUtil.m15942a(aVar, "setHalFBLevel:" + str + " needUpdateNow:" + zArr);
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && !CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) && !CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING) && CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19471a(Contants.CameraV2Key.BEAUTY_LEVEL.getKeyName(), str, zArr);
            }
        }
    }

    /* renamed from: t */
    public void mo20355t() {
        this.f10495r = false;
    }

    /* renamed from: u */
    public String mo20356u() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1645, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            if (k != null) {
                return ((CameraProxyV1) k).mo19740f().get("video-hfr");
            }
            return null;
        } else if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            return null;
        } else {
            return this.f10500w.mo17902aE().getString("pref_camera_slowmotion_high_frame_rate_key", CameraUtil.m15911q());
        }
    }

    /* renamed from: v */
    public void mo20357v() {
        this.f10499v = null;
    }

    /* renamed from: b */
    public void mo20332b(boolean... zArr) {
        String str;
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f10476a, false, 1646, new Class[]{boolean[].class}, Void.TYPE).isSupported && DeviceHelper.f13884ak) {
            String a = CameraSettings.m9777a(this.f10500w.mo17902aE());
            String str2 = null;
            if (this.f10501x && a != null) {
                int indexOf = a.indexOf(120);
                int parseInt = Integer.parseInt(a.substring(0, indexOf));
                int parseInt2 = Integer.parseInt(a.substring(indexOf + 1));
                if (parseInt > parseInt2) {
                    str = DeviceSizeTable.m16185a(parseInt, parseInt2, (String) null);
                } else {
                    str = DeviceSizeTable.m16185a(parseInt2, parseInt, (String) null);
                }
                if (str.equals("4 : 3")) {
                    str2 = !this.f10500w.mo18223du() ? "2592x1944" : "3840x5120";
                } else if (str.equals("16 : 9")) {
                    str2 = !this.f10500w.mo18223du() ? "2688x1512" : "2880x5120";
                }
            }
            if (a == null || !a.equals(str2)) {
                m10787z();
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && zArr != null && zArr.length > 0 && zArr[0]) {
                    LogUtil.m15942a(f10489n, "onFBPictureSizeChange update");
                    CameraController.m8868g().mo19480a(new boolean[0]);
                }
            }
        }
    }

    /* renamed from: w */
    public boolean mo20358w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1647, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f10489n;
        LogUtil.m15942a(aVar, "isFBMode:" + this.f10501x);
        return this.f10501x;
    }

    /* renamed from: x */
    public int mo20359x() {
        CameraProxy k;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10476a, false, 1648, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) || (k = CameraController.m8868g().mo19522k()) == null) {
            return 0;
        }
        CameraProxyV1 eVar = (CameraProxyV1) k;
        eVar.mo19739e();
        Camera.Parameters f = eVar.mo19740f();
        if (f.get("bokeh-free-tasks") != null) {
            return Integer.valueOf(f.get("bokeh-free-tasks")).intValue();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo20319a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10476a, false, 1649, new Class[]{String.class}, Void.TYPE).isSupported) {
            CameraController.m8868g().mo19471a("bokeh-filename", str, new boolean[0]);
        }
    }
}
