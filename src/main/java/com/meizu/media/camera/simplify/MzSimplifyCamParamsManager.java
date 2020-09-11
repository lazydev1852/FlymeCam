package com.meizu.media.camera.simplify;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.text.TextUtils;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.R;
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

/* renamed from: com.meizu.media.camera.simplify.c */
public class MzSimplifyCamParamsManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f11778a;

    /* renamed from: b */
    public static String f11779b = "fast";

    /* renamed from: c */
    public static String f11780c;

    /* renamed from: d */
    public static String f11781d;

    /* renamed from: e */
    public static String f11782e = "night-enhancement";

    /* renamed from: f */
    public static String f11783f;

    /* renamed from: g */
    public static String f11784g;

    /* renamed from: h */
    public static String f11785h;

    /* renamed from: i */
    public static String f11786i;

    /* renamed from: j */
    public static String f11787j;

    /* renamed from: k */
    public static String f11788k;

    /* renamed from: l */
    public static String f11789l;

    /* renamed from: m */
    public static String f11790m;

    /* renamed from: n */
    private static final LogUtil.C2630a f11791n = new LogUtil.C2630a("ParamsManager");

    /* renamed from: A */
    private int f11792A = DeviceHelper.f14029du;

    /* renamed from: B */
    private CameraController.FlashMode f11793B = CameraController.FlashMode.NO_FLASH;

    /* renamed from: o */
    private boolean f11794o;

    /* renamed from: p */
    private boolean f11795p;

    /* renamed from: q */
    private boolean f11796q;

    /* renamed from: r */
    private boolean f11797r = false;

    /* renamed from: s */
    private boolean f11798s = false;

    /* renamed from: t */
    private int f11799t = -1;

    /* renamed from: u */
    private int f11800u;

    /* renamed from: v */
    private Activity f11801v;

    /* renamed from: w */
    private C2305a f11802w;

    /* renamed from: x */
    private boolean f11803x = false;

    /* renamed from: y */
    private boolean f11804y = false;

    /* renamed from: z */
    private String f11805z = null;

    /* renamed from: com.meizu.media.camera.simplify.c$a */
    /* compiled from: MzSimplifyCamParamsManager */
    public interface C2305a {
        /* renamed from: C */
        boolean mo18352C();

        /* renamed from: E */
        boolean mo18354E();

        /* renamed from: a */
        void mo18376a(float f);

        /* renamed from: aA */
        boolean mo18405aA();

        /* renamed from: aB */
        boolean mo18406aB();

        /* renamed from: aC */
        boolean mo18407aC();

        /* renamed from: aD */
        boolean mo18408aD();

        /* renamed from: aS */
        boolean mo18423aS();

        /* renamed from: aT */
        boolean mo18424aT();

        /* renamed from: aj */
        int mo18435aj();

        /* renamed from: ak */
        ComboPreferences mo18436ak();

        /* renamed from: am */
        FocusOverlaySimplifyManager mo18438am();

        /* renamed from: ao */
        int mo18440ao();

        /* renamed from: aq */
        void mo18442aq();

        /* renamed from: av */
        String mo18447av();

        /* renamed from: ay */
        int mo18450ay();

        /* renamed from: az */
        boolean mo18451az();

        /* renamed from: g */
        void mo18474g(boolean z);

        /* renamed from: t */
        boolean mo18499t();
    }

    static {
        if (DeviceHelper.f13839S) {
            f11783f = "continuousshot";
            f11784g = "light-field";
            f11781d = BaseParameters.KEY_EFFECT_NAME_HDR;
            f11780c = "normal";
            f11785h = "iso-speed";
            f11786i = "shutter-value";
            f11788k = "saturation";
            f11787j = "contrast";
            f11789l = "middle";
            f11790m = "middle";
        } else if (DeviceHelper.f13841U) {
            f11783f = "35";
            f11784g = "33";
            f11780c = "0";
            f11781d = "9";
            f11785h = "iso-speed";
            f11786i = "shutter-value";
            f11788k = "saturation";
            f11787j = "contrast";
            f11789l = "0";
            f11790m = "0";
        } else if (DeviceHelper.f13840T) {
            f11783f = "continuousshot";
            f11786i = "shutter-value";
            f11780c = "auto";
            f11781d = BaseParameters.KEY_EFFECT_NAME_HDR;
            f11785h = "iso";
            f11788k = "saturation";
            f11787j = "contrast";
            f11789l = "5";
            f11790m = "5";
        }
    }

    public MzSimplifyCamParamsManager(C2305a aVar, Activity activity) {
        this.f11802w = aVar;
        this.f11801v = activity;
    }

    /* renamed from: a */
    public boolean mo21113a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5474, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19543z();
    }

    /* renamed from: b */
    public boolean mo21119b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5475, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19437A();
    }

    /* renamed from: c */
    public boolean mo21121c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5476, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19438B();
    }

    /* renamed from: d */
    public boolean mo21122d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5477, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19439C();
    }

    /* renamed from: e */
    public boolean mo21123e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5478, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8868g().mo19440D();
    }

    /* renamed from: a */
    public boolean mo21114a(CameraController.FlashMode flashMode) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{flashMode}, this, f11778a, false, 5482, new Class[]{CameraController.FlashMode.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraUtil.m15862a((Object) this.f11793B, (Object) flashMode)) {
            return false;
        }
        this.f11793B = flashMode;
        LogUtil.C2630a aVar = f11791n;
        LogUtil.m15952c(aVar, "setFlashParameters(" + flashMode + ")");
        return true;
    }

    /* renamed from: f */
    public CameraController.FlashMode mo21124f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5483, new Class[0], CameraController.FlashMode.class);
        if (proxy.isSupported) {
            return (CameraController.FlashMode) proxy.result;
        }
        CameraController.FlashMode q = CameraController.m8868g().mo19534q();
        if (q == null) {
            this.f11793B = CameraController.FlashMode.FLASH_MODE_OFF;
        }
        if (this.f11793B == CameraController.FlashMode.NO_FLASH) {
            this.f11793B = q;
        }
        return this.f11793B;
    }

    /* renamed from: a */
    public void mo21104a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11778a, false, 5484, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f11800u = i | this.f11800u;
            if (CameraController.m8868g().mo19522k() == null) {
                this.f11800u = 0;
            } else if (this.f11802w.mo18354E()) {
                mo21105a(this.f11800u, new boolean[0]);
                this.f11800u = 0;
            } else {
                this.f11802w.mo18442aq();
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo21105a(int i, boolean... zArr) {
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect = f11778a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5485, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15952c(aVar, "setCameraParameters " + i);
            if (CameraController.m8868g().mo19522k() != null) {
                if ((i & 1) != 0) {
                    m12885x();
                }
                if ((i & 2) != 0) {
                    m12886y();
                }
                if ((i & 16) != 0) {
                    m12883v();
                }
                if ((i & 4) != 0) {
                    m12887z();
                }
                CameraController.m8868g().mo19480a(zArr);
            }
        }
    }

    /* renamed from: u */
    private void m12882u() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5489, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f13849aB || DeviceHelper.f13853aF || DeviceHelper.f13840T) {
                if (this.f11802w.mo18451az()) {
                    CameraController.m8868g().mo19471a("recording-hint", "true", new boolean[0]);
                } else {
                    CameraController.m8868g().mo19471a("recording-hint", "false", new boolean[0]);
                }
                LogUtil.C2630a aVar = f11791n;
                LogUtil.m15952c(aVar, "updateParametersRecordingHint recording-hint(" + this.f11802w.mo18451az() + ")");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x028a, code lost:
        if (r2.equals("4 : 3") != false) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02b0, code lost:
        if (r2.equals("16 : 9") != false) goto L_0x025c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02c4  */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12883v() {
        /*
            r12 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11778a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5490(0x1572, float:7.693E-42)
            r2 = r12
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 != 0) goto L_0x0028
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.String r1 = "attempting to set picture size without camera device"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        L_0x0028:
            android.app.Activity r1 = r12.f11801v
            if (r1 != 0) goto L_0x0034
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.String r1 = "attempting to set picture size with null activity"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        L_0x0034:
            com.meizu.media.camera.simplify.c$a r1 = r12.f11802w
            com.meizu.media.camera.e r1 = r1.mo18436ak()
            if (r1 != 0) goto L_0x003d
            return
        L_0x003d:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            r4 = 0
            if (r2 != r3) goto L_0x0091
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13894au
            if (r2 == 0) goto L_0x0091
            com.meizu.media.camera.simplify.c$a r2 = r12.f11802w
            int r2 = r2.mo18440ao()
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
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adjust picture size for sub camera in manual 20M size: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x0300
        L_0x0091:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.MANUAL
            if (r2 != r3) goto L_0x00de
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13895av
            if (r2 == 0) goto L_0x00de
            boolean r2 = r12.f11804y
            if (r2 == 0) goto L_0x00de
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
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adjust picture size for camera in manual 48M size: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x0300
        L_0x00de:
            com.meizu.media.camera.simplify.c$a r2 = r12.f11802w
            java.lang.String r2 = r2.mo18447av()
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.util.List r3 = r3.mo19530o()
            com.meizu.media.camera.util.ac$a r5 = f11791n
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
            boolean r5 = r12.f11794o
            if (r5 == 0) goto L_0x0182
            com.meizu.media.camera.simplify.c$a r5 = r12.f11802w
            boolean r5 = r5.mo18451az()
            if (r5 == 0) goto L_0x0182
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9783b((com.meizu.media.camera.ComboPreferences) r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x012f
            android.app.Activity r2 = r12.f11801v
            com.meizu.media.camera.simplify.c$a r3 = r12.f11802w
            int r3 = r3.mo18440ao()
            com.meizu.media.camera.util.CameraSizeDefault.m16169a((android.content.Context) r2, (int) r3)
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9783b((com.meizu.media.camera.ComboPreferences) r1)
        L_0x012f:
            if (r2 == 0) goto L_0x0136
            java.lang.String r1 = com.meizu.media.camera.util.CameraSizeUtil.m16181c(r2)
            r4 = r1
        L_0x0136:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 != r2) goto L_0x0300
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13862aO
            if (r1 == 0) goto L_0x017d
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "sw-vdis"
            boolean r3 = r12.f11796q
            if (r3 != 0) goto L_0x0152
            boolean r3 = r12.f11795p
            if (r3 == 0) goto L_0x014f
            goto L_0x0152
        L_0x014f:
            java.lang.String r3 = "on"
            goto L_0x0154
        L_0x0152:
            java.lang.String r3 = "off"
        L_0x0154:
            boolean[] r0 = new boolean[r0]
            r1.mo19471a((java.lang.String) r2, (java.lang.String) r3, (boolean[]) r0)
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "set sw-vdis: "
            r1.append(r2)
            boolean r2 = r12.f11796q
            if (r2 != 0) goto L_0x0171
            boolean r2 = r12.f11795p
            if (r2 == 0) goto L_0x016e
            goto L_0x0171
        L_0x016e:
            java.lang.String r2 = "on"
            goto L_0x0173
        L_0x0171:
            java.lang.String r2 = "off"
        L_0x0173:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
        L_0x017d:
            r12.m12884w()
            goto L_0x0300
        L_0x0182:
            com.meizu.media.camera.simplify.c$a r5 = r12.f11802w
            boolean r5 = r5.mo18405aA()
            if (r5 == 0) goto L_0x01dc
            com.meizu.media.camera.simplify.c$a r1 = r12.f11802w
            boolean r1 = r1.mo18499t()
            if (r1 != 0) goto L_0x01c0
            java.lang.String r1 = com.meizu.media.camera.util.DeviceHelper.f14011dc
            if (r1 == 0) goto L_0x01c0
            java.lang.String r0 = com.meizu.media.camera.util.DeviceHelper.f14011dc
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            if (r0 == 0) goto L_0x019f
            r4 = r0
        L_0x019f:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 != r1) goto L_0x0300
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraControllerV2 r0 = (com.meizu.media.camera.camcontroller.CameraControllerV2) r0
            java.lang.String r1 = com.meizu.media.camera.util.DeviceHelper.f14012dd
            android.graphics.Point r1 = com.meizu.media.camera.util.CameraSizeUtil.m16173a((java.lang.String) r1)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x0300
            int r2 = r1.x
            int r1 = r1.y
            r0.mo19563a((int) r2, (int) r1)
            goto L_0x0300
        L_0x01c0:
            com.meizu.media.camera.simplify.c$a r1 = r12.f11802w
            boolean r1 = r1.mo18499t()
            if (r1 == 0) goto L_0x0300
            java.lang.String r1 = "4 : 3"
            com.meizu.media.camera.util.CameraSizeUtil.m16177a((boolean) r0)
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16182d(r1)
            if (r0 == 0) goto L_0x0300
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            if (r0 == 0) goto L_0x0300
            r4 = r0
            goto L_0x0300
        L_0x01dc:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x01e6
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
        L_0x01e6:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x01fb
            android.app.Activity r2 = r12.f11801v
            com.meizu.media.camera.simplify.c$a r5 = r12.f11802w
            int r5 = r5.mo18440ao()
            com.meizu.media.camera.util.CameraSizeDefault.m16168a(r2, r5, r3)
            java.lang.String r2 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
        L_0x01fb:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0205
            java.lang.String r2 = com.meizu.media.camera.util.CameraSizeDefault.m16165a()
        L_0x0205:
            if (r2 != 0) goto L_0x0208
            return
        L_0x0208:
            r1 = 120(0x78, float:1.68E-43)
            int r1 = r2.indexOf(r1)
            r5 = -1
            if (r1 != r5) goto L_0x0212
            return
        L_0x0212:
            java.lang.String r5 = r2.substring(r0, r1)
            int r5 = java.lang.Integer.parseInt(r5)
            r6 = 1
            int r1 = r1 + r6
            java.lang.String r1 = r2.substring(r1)
            int r1 = java.lang.Integer.parseInt(r1)
            if (r5 <= r1) goto L_0x022b
            java.lang.String r2 = com.meizu.media.camera.util.DeviceSizeTable.m16185a((int) r5, (int) r1, (java.lang.String) r4)
            goto L_0x022f
        L_0x022b:
            java.lang.String r2 = com.meizu.media.camera.util.DeviceSizeTable.m16185a((int) r1, (int) r5, (java.lang.String) r4)
        L_0x022f:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r7 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            boolean r4 = r4.equals(r7)
            r7 = 1944(0x798, float:2.724E-42)
            r8 = 2592(0xa20, float:3.632E-42)
            r9 = 1512(0x5e8, float:2.119E-42)
            r10 = 2688(0xa80, float:3.767E-42)
            r11 = 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0268
            java.lang.String r0 = "4 : 3"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0254
            r0 = 1536(0x600, float:2.152E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r10 = 1536(0x600, float:2.152E-42)
            goto L_0x02b5
        L_0x0254:
            java.lang.String r0 = "16 : 9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0261
        L_0x025c:
            r9 = 2688(0xa80, float:3.767E-42)
            r10 = 1512(0x5e8, float:2.119E-42)
            goto L_0x02b5
        L_0x0261:
            r0 = 1024(0x400, float:1.435E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r10 = 1024(0x400, float:1.435E-42)
            goto L_0x02b5
        L_0x0268:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13884ak
            if (r4 != 0) goto L_0x0270
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13885al
            if (r4 == 0) goto L_0x0291
        L_0x0270:
            com.meizu.media.camera.mode.CameraModeType$ModeType r4 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            com.meizu.media.camera.mode.CameraModeType$ModeType r11 = com.meizu.media.camera.mode.CameraModeType.ModeType.SUPER_NIGHT
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x0291
            com.meizu.media.camera.simplify.c$a r4 = r12.f11802w
            int r4 = r4.mo18440ao()
            if (r4 != r6) goto L_0x0291
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x02b3
        L_0x028c:
            r9 = 2592(0xa20, float:3.632E-42)
            r10 = 1944(0x798, float:2.724E-42)
            goto L_0x02b5
        L_0x0291:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13884ak
            if (r4 == 0) goto L_0x02b3
            boolean r4 = r12.f11803x
            if (r4 == 0) goto L_0x02b3
            com.meizu.media.camera.simplify.c$a r4 = r12.f11802w
            boolean r4 = r4.mo18423aS()
            if (r4 != 0) goto L_0x02b3
            java.lang.String r4 = "4 : 3"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x02aa
            goto L_0x028c
        L_0x02aa:
            java.lang.String r4 = "16 : 9"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x02b3
            goto L_0x025c
        L_0x02b3:
            r9 = 0
            r10 = 0
        L_0x02b5:
            if (r9 == 0) goto L_0x02c4
            android.app.Activity r0 = r12.f11801v
            double r4 = (double) r5
            double r1 = (double) r1
            double r7 = r4 / r1
            r5 = r0
            r6 = r3
            java.lang.String r0 = com.meizu.media.camera.util.CameraUtil.m15835a((android.app.Activity) r5, (java.util.List<android.graphics.Point>) r6, (double) r7, (int) r9, (int) r10)
            goto L_0x02c8
        L_0x02c4:
            java.lang.String r0 = com.meizu.media.camera.util.CameraSizeUtil.m16182d(r2)
        L_0x02c8:
            com.meizu.media.camera.util.ac$a r1 = f11791n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "setCameraPictureSize: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            java.lang.String r4 = com.meizu.media.camera.util.CameraSizeUtil.m16175a((java.lang.String) r0, (java.util.List<android.graphics.Point>) r3)
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "picSize:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.simplify.c$a r0 = r12.f11802w
            int r0 = r0.mo18440ao()
            r12.f11792A = r0
        L_0x0300:
            r12.m12880a((java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamParamsManager.m12883v():void");
    }

    /* renamed from: a */
    private void m12880a(String str) {
        Point point;
        if (!PatchProxy.proxy(new Object[]{str}, this, f11778a, false, 5491, new Class[]{String.class}, Void.TYPE).isSupported) {
            Point j = CameraController.m8868g().mo19520j();
            if (j == null || str == null) {
                LogUtil.C2630a aVar = f11791n;
                StringBuilder sb = new StringBuilder();
                sb.append("getPictureSize from ");
                sb.append(j == null ? "mParameters" : "paramMapCache");
                sb.append(" failed, return without updating previewSize&Ratio and ZSD");
                LogUtil.m15949b(aVar, sb.toString());
                return;
            }
            int indexOf = str.indexOf(120);
            if (indexOf != -1) {
                j.x = Integer.parseInt(str.substring(0, indexOf));
                j.y = Integer.parseInt(str.substring(indexOf + 1));
            }
            if ((DeviceHelper.f13853aF || DeviceHelper.f13910bJ == CameraController.CameraApi.API2) && this.f11794o && this.f11802w.mo18451az()) {
                point = new Point(j.x, j.y);
            } else {
                List<Point> p = CameraController.m8868g().mo19532p();
                if (p.size() != 0) {
                    if (CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT) || CameraModeType.m10946a().equals(CameraModeType.ModeType.DOCUMENT) || CameraModeType.m10946a().equals(CameraModeType.ModeType.AUTO)) {
                        point = CameraUtil.m15827a(this.f11801v, p, ((double) j.x) / ((double) j.y), this.f11803x, true);
                    } else {
                        point = CameraUtil.m15827a(this.f11801v, p, ((double) j.x) / ((double) j.y), this.f11803x, false);
                    }
                } else {
                    return;
                }
            }
            if (this.f11802w.mo18405aA() && this.f11802w.mo18499t() && DeviceHelper.f13873aZ) {
                point.x = 960;
                point.y = 720;
            }
            Point n = CameraController.m8868g().mo19528n();
            m12879a(j);
            m12881b(true);
            if (!(point == null || n == null || n.equals(point))) {
                LogUtil.C2630a aVar2 = f11791n;
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
                this.f11797r = true;
                LogUtil.C2630a aVar3 = f11791n;
                LogUtil.m15952c(aVar3, "updateParametersPictureSize need restart preview (" + this.f11797r + ")");
            }
            if (point == null || point.x == 0 || point.y == 0) {
                LogUtil.m15952c(f11791n, "Preview size is null");
                return;
            }
            LogUtil.m15954d(f11791n, "updating aspect ratio");
            if (DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2)) {
                CameraController.m8868g().mo19450a(point.x, point.y, new boolean[0]);
            }
            this.f11802w.mo18376a(((float) point.x) / ((float) point.y));
            EffectRenderContext.m4369h().mo14173a(point.x, point.y);
            LogUtil.C2630a aVar4 = f11791n;
            LogUtil.m15952c(aVar4, "Preview size is " + point.x + "x" + point.y);
        }
    }

    /* renamed from: w */
    private void m12884w() {
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5492, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13840T) {
            boolean z = Integer.valueOf(CameraSizeDefault.m16170b((Context) this.f11801v, this.f11802w.mo18440ao())).intValue() == DeviceHelper.f14004cy;
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15952c(aVar, "setVideCdsMode: " + this.f11795p + "，mIs4KRecording:" + z);
            String str = null;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
                str = ((CameraProxyV1) k).mo19740f().get("video-cds-mode");
            }
            String str2 = (this.f11795p || z) ? "off" : "on";
            if (str != str2) {
                CameraController.m8868g().mo19471a("video-cds-mode", str2, new boolean[0]);
                this.f11797r = true;
            }
        }
    }

    /* renamed from: a */
    private void m12879a(Point point) {
        if (PatchProxy.proxy(new Object[]{point}, this, f11778a, false, 5493, new Class[]{Point.class}, Void.TYPE).isSupported || !DeviceHelper.f13839S) {
            return;
        }
        if (this.f11794o || this.f11802w.mo18352C()) {
            CameraController.m8868g().mo19494b("zsd-mode", "off", new boolean[0]);
        } else if (this.f11802w.mo18450ay() != -1) {
            boolean a = CameraController.m8868g().mo19482a("zsd-mode");
            boolean z = this.f11802w.mo18450ay() == 1 && point.x <= DeviceHelper.f13918bR;
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15952c(aVar, "setZsdForMtk currentZsd(" + a + "), needZsd(" + z + ")");
            if (a != z) {
                CameraController.m8868g().mo19494b("zsd-mode", z ? "on" : "off", new boolean[0]);
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f11797r = true;
                    LogUtil.C2630a aVar2 = f11791n;
                    LogUtil.m15952c(aVar2, "setZsdForMtk need restart preview (" + this.f11797r + ")");
                }
            }
        }
    }

    /* renamed from: b */
    private void m12881b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11778a, false, 5494, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13840T && this.f11802w.mo18450ay() != -1) {
            boolean a = CameraController.m8868g().mo19482a("zsl");
            boolean z2 = this.f11802w.mo18450ay() == 1;
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15952c(aVar, "setZsdForQCOM currentZsl(" + a + "), needZsl(" + z2 + ") " + z);
            if (a != (z && z2)) {
                CameraController.m8868g().mo19494b("zsl", (!z || !z2) ? "off" : "on", new boolean[0]);
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f11797r = true;
                    LogUtil.C2630a aVar2 = f11791n;
                    LogUtil.m15952c(aVar2, "setZsdForQCOM need restart preview (" + this.f11797r + ")");
                }
            }
        }
    }

    /* renamed from: g */
    public boolean mo21125g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5495, new Class[0], Boolean.TYPE);
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

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01de, code lost:
        r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g().mo19522k();
     */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12885x() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f11778a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5496(0x1578, float:7.702E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int[] r1 = com.meizu.media.camera.util.CameraUtil.m15910p()
            r2 = 1
            if (r1 == 0) goto L_0x01ca
            int r3 = r1.length
            if (r3 <= 0) goto L_0x01ca
            com.meizu.media.camera.simplify.c$a r3 = r8.f11802w
            boolean r3 = r3.mo18451az()
            if (r3 == 0) goto L_0x00f4
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13853aF
            r3 = 30
            if (r1 == 0) goto L_0x00aa
            boolean r1 = r8.f11795p
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
            java.lang.String r5 = java.lang.Integer.toString(r3)
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
            boolean r1 = r8.f11795p
            if (r1 == 0) goto L_0x00d2
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            int r1 = r1.mo19733b()
            if (r1 != 0) goto L_0x00d2
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-frame-rate"
            com.meizu.media.camera.util.DeviceHelper$SLOW_MOTION_FPS r4 = com.meizu.media.camera.util.DeviceHelper.f14038h
            java.lang.String r4 = r4.getValue()
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x00e1
        L_0x00d2:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-frame-rate"
            java.lang.String r3 = java.lang.Integer.toString(r3)
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r3, (boolean[]) r5)
        L_0x00e1:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x01ca
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "30000,30000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x00f4:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13830J
            if (r3 == 0) goto L_0x0145
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            int r1 = r1.mo19733b()
            if (r1 != r2) goto L_0x0115
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "14000,30000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x0115:
            com.meizu.media.camera.simplify.c$a r1 = r8.f11802w
            com.meizu.media.camera.e r1 = r1.mo18436ak()
            java.lang.String r1 = com.meizu.media.camera.CameraSettings.m9777a((com.meizu.media.camera.ComboPreferences) r1)
            java.lang.String r3 = "5312x2988"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0136
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "14000,30000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x0136:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "14000,24000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x0145:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f14047q
            if (r3 != 0) goto L_0x014d
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13832L
            if (r3 == 0) goto L_0x0169
        L_0x014d:
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r3 = r3.mo19522k()
            int r3 = r3.mo19733b()
            if (r3 != r2) goto L_0x0169
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "14000,30000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x0169:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13822B
            if (r3 != 0) goto L_0x01bd
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13824D
            if (r3 == 0) goto L_0x0172
            goto L_0x01bd
        L_0x0172:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r3 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE
            if (r3 == r4) goto L_0x017e
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r3 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r4 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG
            if (r3 != r4) goto L_0x0194
        L_0x017e:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r3 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r3)
            if (r3 == 0) goto L_0x0194
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "7500,24000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
            goto L_0x01ca
        L_0x0194:
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "preview-fps-range"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ""
            r5.append(r6)
            r6 = r1[r0]
            r5.append(r6)
            java.lang.String r6 = ","
            r5.append(r6)
            r1 = r1[r2]
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            boolean[] r5 = new boolean[r0]
            r3.mo19471a((java.lang.String) r4, (java.lang.String) r1, (boolean[]) r5)
            goto L_0x01ca
        L_0x01bd:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "preview-fps-range"
            java.lang.String r4 = "14000,30000"
            boolean[] r5 = new boolean[r0]
            r1.mo19471a((java.lang.String) r3, (java.lang.String) r4, (boolean[]) r5)
        L_0x01ca:
            r8.m12882u()
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 == 0) goto L_0x01f5
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 == 0) goto L_0x01f5
            com.meizu.media.camera.camcontroller.e r1 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r1
            android.hardware.Camera$Parameters r1 = r1.mo19740f()
            java.lang.String r4 = "video-stabilization-supported"
            java.lang.String r1 = r1.get(r4)
            goto L_0x01f6
        L_0x01f5:
            r1 = r3
        L_0x01f6:
            java.lang.String r4 = "true"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x020b
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "video-stabilization"
            java.lang.String r5 = "false"
            boolean[] r6 = new boolean[r0]
            r1.mo19471a((java.lang.String) r4, (java.lang.String) r5, (boolean[]) r6)
        L_0x020b:
            com.meizu.media.camera.simplify.c$a r1 = r8.f11802w
            com.meizu.media.camera.e r1 = r1.mo18436ak()
            java.lang.String r4 = "pref_video_quality_key"
            java.lang.String r1 = r1.getString(r4, r3)
            com.meizu.media.camera.simplify.c$a r3 = r8.f11802w
            int r3 = r3.mo18440ao()
            if (r3 == r2) goto L_0x023b
            com.meizu.media.camera.util.ac$a r2 = f11791n
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "current cameraId = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = ", reset it to facing back for getting video quality"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            goto L_0x023c
        L_0x023b:
            r0 = r3
        L_0x023c:
            java.util.ArrayList r0 = com.meizu.media.camera.util.CameraSizeUtil.m16176a((int) r0)
            if (r1 == 0) goto L_0x0248
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0253
        L_0x0248:
            android.app.Activity r0 = r8.f11801v
            com.meizu.media.camera.simplify.c$a r1 = r8.f11802w
            int r1 = r1.mo18440ao()
            com.meizu.media.camera.util.CameraSizeDefault.m16172c(r0, r1)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamParamsManager.m12885x():void");
    }

    /* renamed from: y */
    private void m12886y() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5497, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19541x()) {
            CameraController.m8868g().mo19501c(this.f11802w.mo18435aj(), new boolean[0]);
        }
    }

    /* renamed from: z */
    private void m12887z() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5498, new Class[0], Void.TYPE).isSupported) {
            m12870B();
            m12871C();
            m12872D();
            m12873E();
            FocusOverlaySimplifyManager am = this.f11802w.mo18438am();
            if (am != null) {
                am.mo21064a((CameraController.FocusMode) null);
                CameraController.m8868g().mo19467a(this.f11802w.mo18438am().mo21079g(), new boolean[0]);
            }
            m12874F();
            m12878J();
            m12875G();
            m12876H();
            if (mo21123e() && ApiHelper.f14203d) {
                m12869A();
            }
        }
    }

    /* renamed from: A */
    private void m12869A() {
        CameraController.FocusMode aa;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5499, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (aa = CameraController.m8868g().mo19483aa()) != null) {
            this.f11802w.mo18474g(CameraController.FocusMode.CONTINUOUS_PICTURE.equals(aa));
        }
    }

    /* renamed from: B */
    private void m12870B() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5500, new Class[0], Void.TYPE).isSupported && mo21121c() && this.f11802w.mo18438am() != null) {
            CameraController.m8868g().mo19471a("auto-exposure-lock", this.f11802w.mo18438am().mo21092o() ? "true" : "false", new boolean[0]);
        }
    }

    /* renamed from: C */
    private void m12871C() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5501, new Class[0], Void.TYPE).isSupported && mo21122d() && this.f11802w.mo18438am() != null) {
            CameraController.m8868g().mo19471a("auto-whitebalance-lock", this.f11802w.mo18438am().mo21092o() ? "true" : "false", new boolean[0]);
        }
    }

    /* renamed from: D */
    private void m12872D() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5502, new Class[0], Void.TYPE).isSupported && mo21113a() && this.f11802w.mo18438am() != null) {
            CameraController.m8868g().mo19476a(false, (List<Rect>) this.f11802w.mo18438am().mo21081h());
        }
    }

    /* renamed from: E */
    private void m12873E() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5503, new Class[0], Void.TYPE).isSupported && mo21119b() && this.f11802w.mo18438am() != null) {
            CameraController.m8868g().mo19476a(true, (List<Rect>) this.f11802w.mo18438am().mo21083i());
        }
    }

    /* renamed from: F */
    private void m12874F() {
        Camera.Size a;
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5504, new Class[0], Void.TYPE).isSupported) {
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

    /* renamed from: G */
    private void m12875G() {
        ComboPreferences ak;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5505, new Class[0], Void.TYPE).isSupported && (ak = this.f11802w.mo18436ak()) != null && this.f11802w.mo18406aB()) {
            CameraController.m8868g().mo19470a(ak);
        }
    }

    /* renamed from: H */
    private void m12876H() {
        List<String> list;
        String str;
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5506, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11791n, "updateParametersSceneMode start");
            ComboPreferences ak = this.f11802w.mo18436ak();
            if (ak != null) {
                String string = ak.getString("pref_camera_scenemode_key", this.f11801v.getString(R.string.pref_camera_scenemode_default));
                ArrayList arrayList = new ArrayList();
                if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) || (k = CameraController.m8868g().mo19522k()) == null) {
                    list = arrayList;
                    str = null;
                } else {
                    Camera.Parameters f = ((CameraProxyV1) k).mo19740f();
                    list = f.getSupportedSceneModes();
                    str = f.getSceneMode();
                }
                LogUtil.m15942a(f11791n, "sceneMode in preferences:" + string + ",sceneModeOnParms:" + str);
                if (!CameraUtil.m15864a(string, list)) {
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
                        LogUtil.m15942a(f11791n, "setParameter scene-mode:" + string);
                    }
                } else if (!CameraUtil.m15862a((Object) string, (Object) str)) {
                    CameraController.m8868g().mo19471a("scene-mode", string, new boolean[0]);
                    LogUtil.m15942a(f11791n, "sceneMode is not hdr, setParameter scene-mode:" + string);
                }
                FocusOverlaySimplifyManager am = this.f11802w.mo18438am();
                if (am != null) {
                    if ("auto".equals(string) || BaseParameters.KEY_EFFECT_NAME_HDR.equals(string)) {
                        m12877I();
                        if (am != null) {
                            am.mo21064a((CameraController.FocusMode) null);
                            CameraController.m8868g().mo19467a(am.mo21079g(), new boolean[0]);
                            return;
                        }
                        return;
                    }
                    am.mo21064a(CameraController.m8868g().mo19483aa());
                }
            }
        }
    }

    /* renamed from: I */
    private void m12877I() {
        ComboPreferences ak;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5507, new Class[0], Void.TYPE).isSupported && (ak = this.f11802w.mo18436ak()) != null) {
            if (this.f11793B == CameraController.FlashMode.NO_FLASH) {
                this.f11793B = CameraController.FlashMode.convertFlashMode(ak.getString("pref_camera_flashmode_key", this.f11801v.getString(R.string.pref_camera_flashmode_default)));
            }
            CameraController.m8868g().mo19466a(this.f11793B, new boolean[0]);
        }
    }

    /* renamed from: J */
    private void m12878J() {
        ComboPreferences ak;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5508, new Class[0], Void.TYPE).isSupported && (ak = this.f11802w.mo18436ak()) != null) {
            if (DeviceHelper.f13839S || DeviceHelper.f13840T) {
                CameraController.m8868g().mo19471a("rec-mute-ogg", "1", new boolean[0]);
            }
            mo21112a(false);
            if (ak.getString("mz_pref_time_mark_key", this.f11801v.getString(R.string.setting_off_value)).equals(this.f11801v.getString(R.string.setting_off_value)) || !this.f11802w.mo18407aC()) {
                CameraController.m8868g().mo19471a("digital-Watermark", "0", new boolean[0]);
                CameraController.m8868g().mo19471a("watermark-Date", "null", new boolean[0]);
            } else {
                CameraController.m8868g().mo19471a("digital-Watermark", "1", new boolean[0]);
            }
            mo21127i();
            if (DeviceHelper.f13838R && (!CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL) || DeviceHelper.f13840T)) {
                CameraController.m8868g().mo19471a("antibanding", "auto", new boolean[0]);
            }
            if (DeviceHelper.f13856aI) {
                String string = ak.getString("mz_pref_stereo_level_key", "0");
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
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0153 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo21112a(boolean... r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f11778a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<boolean[]> r0 = boolean[].class
            r6[r8] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5509(0x1585, float:7.72E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            com.meizu.media.camera.util.ac$a r0 = f11791n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateExposureParams:"
            r1.append(r2)
            boolean r2 = r10[r8]
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.simplify.c$a r0 = r9.f11802w
            com.meizu.media.camera.e r0 = r0.mo18436ak()
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
            com.meizu.media.camera.util.ac$a r5 = f11791n
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
            com.meizu.media.camera.util.ac$a r10 = f11791n
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
            com.meizu.media.camera.util.ac$a r1 = f11791n
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
            com.meizu.media.camera.util.ac$a r10 = f11791n
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
            com.meizu.media.camera.util.ac$a r3 = f11791n
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
            com.meizu.media.camera.util.ac$a r10 = f11791n
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyCamParamsManager.mo21112a(boolean[]):void");
    }

    /* renamed from: a */
    public void mo21107a(String str, Object... objArr) {
        Class[] clsArr = {String.class, Object[].class};
        if (!PatchProxy.proxy(new Object[]{str, objArr}, this, f11778a, false, 5510, clsArr, Void.TYPE).isSupported && !TextUtils.isEmpty(str) && DeviceHelper.f13838R) {
            CameraController.m8868g().mo19473a(str, objArr);
        }
    }

    /* renamed from: h */
    public void mo21126h() {
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5511, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13838R) {
            mo21107a(f11780c, new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo21106a(long j) {
        ComboPreferences ak;
        if (PatchProxy.proxy(new Object[]{new Long(j)}, this, f11778a, false, 5514, new Class[]{Long.TYPE}, Void.TYPE).isSupported || (ak = this.f11802w.mo18436ak()) == null || !DeviceHelper.f13838R) {
            return;
        }
        if (ak.getString("mz_pref_time_mark_key", this.f11801v.getString(R.string.setting_off_value)).equals(this.f11801v.getString(R.string.setting_off_value)) || !this.f11802w.mo18407aC()) {
            CameraController.m8868g().mo19471a("digital-Watermark", "0", new boolean[0]);
            CameraController.m8868g().mo19471a("watermark-Date", "null", new boolean[0]);
            return;
        }
        LogUtil.C2630a aVar = f11791n;
        LogUtil.m15942a(aVar, "set watermark: " + j);
        CameraController.m8868g().mo19471a("digital-Watermark", "1", new boolean[0]);
        CameraController.m8868g().mo19471a("watermark-Date", DeviceHelper.f13979cZ.format(Long.valueOf(j)), new boolean[0]);
    }

    /* renamed from: i */
    public void mo21127i() {
        ComboPreferences ak;
        if (PatchProxy.proxy(new Object[0], this, f11778a, false, 5515, new Class[0], Void.TYPE).isSupported || (ak = this.f11802w.mo18436ak()) == null) {
            return;
        }
        if (DeviceHelper.f13879af || DeviceHelper.f13882ai) {
            String string = ak.getString("mz_pref_device_mark_key", this.f11801v.getString(R.string.setting_on_value));
            if (string.equals(this.f11801v.getString(R.string.setting_off_value)) || !this.f11802w.mo18408aD()) {
                CameraController.m8868g().mo19471a("device-Watermark", "0", new boolean[0]);
                this.f11805z = null;
                CameraController.m8868g().mo19493b((String) null);
                LogUtil.m15942a(f11791n, "set devicemark off");
            } else if (string.equals(this.f11801v.getString(R.string.setting_on_value))) {
                CameraController.m8868g().mo19471a("device-Watermark", "1", new boolean[0]);
                this.f11805z = null;
                CameraController.m8868g().mo19493b((String) null);
                LogUtil.m15942a(f11791n, "set devicemark default on");
            } else if (DeviceHelper.f13881ah) {
                CameraController.m8868g().mo19471a("device-Watermark", "2", new boolean[0]);
                this.f11805z = ak.getString("mz_pref_custom_device_mark_key", this.f11801v.getString(R.string.mz_custom_device_mark_defalut_hint));
                CameraController.m8868g().mo19493b(ak.getString("mz_pref_custom_device_mark_key", this.f11801v.getString(R.string.mz_custom_device_mark_defalut_hint)));
                LogUtil.m15942a(f11791n, "set devicemark custom on");
            }
        }
    }

    /* renamed from: j */
    public boolean mo21128j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5516, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ComboPreferences ak = this.f11802w.mo18436ak();
        if (ak == null) {
            return false;
        }
        if ((DeviceHelper.f13879af || DeviceHelper.f13882ai) && !ak.getString("mz_pref_device_mark_key", this.f11801v.getString(R.string.setting_on_value)).equals(this.f11801v.getString(R.string.setting_off_value)) && this.f11802w.mo18408aD()) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public String mo21129k() {
        return this.f11805z;
    }

    /* renamed from: l */
    public boolean mo21130l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5517, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ComboPreferences ak = this.f11802w.mo18436ak();
        if (ak != null && !ak.getString("mz_pref_time_mark_key", this.f11801v.getString(R.string.setting_off_value)).equals(this.f11801v.getString(R.string.setting_off_value)) && this.f11802w.mo18407aC()) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public void mo21131m() {
        ComboPreferences ak;
        if (!PatchProxy.proxy(new Object[0], this, f11778a, false, 5519, new Class[0], Void.TYPE).isSupported && (ak = this.f11802w.mo18436ak()) != null) {
            String string = ak.getString("mz_pref_mirror", this.f11801v.getString(R.string.setting_on_value));
            if (CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP) || (!string.equals(this.f11801v.getString(R.string.setting_off_value)) && !this.f11794o)) {
                CameraController.m8868g().mo19471a("front-mirror", "1", new boolean[0]);
            } else {
                CameraController.m8868g().mo19471a("front-mirror", "0", new boolean[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo21110a(boolean z, boolean z2, boolean z3) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11778a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5527, new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11794o = z;
            this.f11795p = z2;
            this.f11796q = z3;
            if (!this.f11794o && !this.f11795p) {
                this.f11797r = true;
            } else if (DeviceHelper.f13849aB || DeviceHelper.f13853aF || DeviceHelper.f13840T) {
                this.f11797r = true;
            }
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15952c(aVar, "setRecording need restart preview (" + this.f11797r + ")");
        }
    }

    /* renamed from: n */
    public boolean mo21132n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5528, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraController.m8868g().mo19447Y() != CameraController.HdrMode.OFF) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo21115a(CameraController.HdrMode hdrMode) {
        boolean z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hdrMode}, this, f11778a, false, 5529, new Class[]{CameraController.HdrMode.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean z2 = CameraController.HdrMode.ON == hdrMode;
        if (DeviceHelper.f13840T) {
            this.f11802w.mo18436ak().edit().putString("pref_camera_scenemode_key", z2 ? BaseParameters.KEY_EFFECT_NAME_HDR : "auto").apply();
        }
        if (!DeviceHelper.f14039i || z2 || !mo21132n()) {
            z = false;
        } else {
            this.f11797r = true;
            z = true;
        }
        if (DeviceHelper.f13875ab) {
            mo21107a(f11781d, hdrMode);
        } else if (z2) {
            mo21107a(f11781d, new Object[0]);
        } else {
            mo21126h();
        }
        return z;
    }

    /* renamed from: a */
    public void mo21109a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11778a, false, 5530, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13830J || DeviceHelper.f13831K) {
                CameraController.m8868g().mo19471a("metering-spot-isolate", z ? "1" : "0", new boolean[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo21111a(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f11778a, false, 5531, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && DeviceHelper.f13840T) {
            CameraController.m8868g().mo19471a("is-flyme-camera-apk", z ? "0" : "1", zArr);
        }
    }

    /* renamed from: b */
    public void mo21116b(int i, boolean... zArr) {
        int i2;
        String str;
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect = f11778a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5532, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported || ApiHelper.f14210k || i == this.f11799t || CameraController.m8868g().mo19522k() == null) {
            return;
        }
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1 || this.f11802w.mo18424aT()) {
            try {
                if (this.f11802w.mo18440ao() == 1 && i == 0) {
                    i2 = (i + 270) % 360;
                } else if (!DeviceHelper.f13841U || DeviceHelper.f13830J) {
                    i2 = (i + 90) % 360;
                } else {
                    i2 = CameraUtil.m15882c(this.f11802w.mo18440ao(), i);
                }
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    str = BaseParameters.KEY_PICTURE_ROTATION;
                } else {
                    str = Contants.CameraV2Key.DEVICE_ORIENTATION.getKeyName();
                }
                CameraController.m8868g().mo19471a(str, Integer.toString(i2), zArr);
                this.f11799t = i;
            } catch (Exception unused) {
                LogUtil.m15952c(f11791n, "set FD rotation failed");
            }
        }
    }

    /* renamed from: o */
    public void mo21133o() {
        this.f11799t = -1;
    }

    /* renamed from: b */
    public void mo21117b(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f11778a, false, 5533, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15942a(aVar, "setMFLLParams:" + z + " needUpdateNow:" + zArr);
            if (!DeviceHelper.f13854aG || CameraController.m8868g().mo19522k() == null) {
                return;
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                if (DeviceHelper.f13840T) {
                    CameraController.m8868g().mo19471a("mfll-on", (!z || mo21132n()) ? "0" : "1", zArr);
                } else {
                    CameraController.m8868g().mo19471a("mfll-on", z ? "1" : "0", zArr);
                }
            } else if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                CameraController.m8868g().mo19471a(Contants.CameraV2Key.MFNR_ENABLE.getKeyName(), z ? "1" : "0", zArr);
            }
        }
    }

    /* renamed from: c */
    public void mo21120c(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f11778a, false, 5534, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15942a(aVar, "setMzFBMode:" + z + " needUpdateNow:" + zArr);
            this.f11803x = z;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19471a("mzfb-enable", z ? "1" : "0", zArr);
            }
        }
    }

    /* renamed from: a */
    public void mo21108a(String str, boolean... zArr) {
        Class[] clsArr = {String.class, boolean[].class};
        if (!PatchProxy.proxy(new Object[]{str, zArr}, this, f11778a, false, 5538, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11791n;
            LogUtil.m15942a(aVar, "setHalFBLevel:" + str + " needUpdateNow:" + zArr);
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19471a(Contants.CameraV2Key.BEAUTY_LEVEL.getKeyName(), str, zArr);
            }
        }
    }

    /* renamed from: p */
    public void mo21134p() {
        this.f11797r = false;
    }

    /* renamed from: q */
    public String mo21135q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5539, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            if (k != null) {
                return ((CameraProxyV1) k).mo19740f().get("video-hfr");
            }
            return null;
        } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            return DeviceHelper.f14038h.getValue();
        } else {
            return null;
        }
    }

    /* renamed from: r */
    public void mo21136r() {
        this.f11801v = null;
    }

    /* renamed from: b */
    public void mo21118b(boolean... zArr) {
        String str;
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f11778a, false, 5540, new Class[]{boolean[].class}, Void.TYPE).isSupported && DeviceHelper.f13884ak) {
            String a = CameraSettings.m9777a(this.f11802w.mo18436ak());
            String str2 = null;
            if (this.f11803x && a != null) {
                int indexOf = a.indexOf(120);
                int parseInt = Integer.parseInt(a.substring(0, indexOf));
                int parseInt2 = Integer.parseInt(a.substring(indexOf + 1));
                if (parseInt > parseInt2) {
                    str = DeviceSizeTable.m16185a(parseInt, parseInt2, (String) null);
                } else {
                    str = DeviceSizeTable.m16185a(parseInt2, parseInt, (String) null);
                }
                if (str.equals("4 : 3")) {
                    str2 = !this.f11802w.mo18423aS() ? "2592x1944" : "3840x5120";
                } else if (str.equals("16 : 9")) {
                    str2 = !this.f11802w.mo18423aS() ? "2688x1512" : "2880x5120";
                }
            }
            if (a == null || str2 == null || !a.equals(str2)) {
                m12883v();
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && zArr != null && zArr.length > 0 && zArr[0]) {
                    LogUtil.m15942a(f11791n, "onFBPictureSizeChange update");
                    CameraController.m8868g().mo19480a(new boolean[0]);
                }
            }
        }
    }

    /* renamed from: s */
    public boolean mo21137s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5541, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11791n;
        LogUtil.m15942a(aVar, "isFBMode:" + this.f11803x);
        return this.f11803x;
    }

    /* renamed from: t */
    public int mo21138t() {
        CameraProxy k;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11778a, false, 5542, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
            CameraProxyV1 eVar = (CameraProxyV1) k;
            eVar.mo19739e();
            Camera.Parameters f = eVar.mo19740f();
            if (f == null || f.get("bokeh-free-tasks") == null) {
                return 0;
            }
            return Integer.valueOf(f.get("bokeh-free-tasks")).intValue();
        }
        return 0;
    }
}
