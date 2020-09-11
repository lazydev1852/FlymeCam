package com.meizu.media.camera;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.PointerIconCompat;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.util.Constants;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraControllerV2;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.meizu.media.camera.h */
public class FocusOverlayManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10268a;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final LogUtil.C2630a f10269m = new LogUtil.C2630a("FocusManager");

    /* renamed from: A */
    private List<Rect> f10270A;

    /* renamed from: B */
    private CameraController.FocusMode f10271B;

    /* renamed from: C */
    private String[] f10272C;

    /* renamed from: D */
    private CameraController.FocusMode f10273D;

    /* renamed from: E */
    private Camera.Parameters f10274E;

    /* renamed from: F */
    private Handler f10275F;

    /* renamed from: G */
    private boolean f10276G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f10277H;

    /* renamed from: I */
    private boolean f10278I;

    /* renamed from: J */
    private boolean f10279J = false;

    /* renamed from: K */
    private CameraController.FlashMode f10280K;

    /* renamed from: L */
    private boolean f10281L;

    /* renamed from: M */
    private boolean f10282M;

    /* renamed from: N */
    private boolean f10283N;

    /* renamed from: O */
    private boolean f10284O = false;

    /* renamed from: P */
    private float f10285P = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f10286Q = false;

    /* renamed from: R */
    private float[] f10287R;

    /* renamed from: S */
    private long f10288S;

    /* renamed from: T */
    private long f10289T;

    /* renamed from: U */
    private boolean f10290U = false;

    /* renamed from: b */
    C2098b f10291b;

    /* renamed from: c */
    float f10292c = 1.0f;

    /* renamed from: d */
    float f10293d = 3.0f;

    /* renamed from: e */
    float f10294e = -3.0f;

    /* renamed from: f */
    float f10295f;

    /* renamed from: g */
    float f10296g;

    /* renamed from: h */
    boolean f10297h = false;

    /* renamed from: i */
    boolean f10298i = false;

    /* renamed from: j */
    boolean f10299j = false;

    /* renamed from: k */
    boolean f10300k = false;

    /* renamed from: l */
    MzFocusRenderer.C2743b f10301l;

    /* renamed from: n */
    private int f10302n = 0;

    /* renamed from: o */
    private boolean f10303o;

    /* renamed from: p */
    private boolean f10304p;

    /* renamed from: q */
    private boolean f10305q;

    /* renamed from: r */
    private boolean f10306r;

    /* renamed from: s */
    private boolean f10307s;

    /* renamed from: t */
    private Matrix f10308t;

    /* renamed from: u */
    private int f10309u;

    /* renamed from: v */
    private int f10310v;

    /* renamed from: w */
    private int f10311w;

    /* renamed from: x */
    private boolean f10312x;

    /* renamed from: y */
    private int f10313y;

    /* renamed from: z */
    private List<Rect> f10314z;

    /* renamed from: com.meizu.media.camera.h$a */
    /* compiled from: FocusOverlayManager */
    public interface C2097a {
    }

    /* renamed from: com.meizu.media.camera.h$b */
    /* compiled from: FocusOverlayManager */
    public interface C2098b {
        /* renamed from: a */
        void mo17886a(CameraController.FlashMode flashMode);

        /* renamed from: a */
        void mo18015a(String str, boolean z);

        /* renamed from: l */
        void mo18245l();

        /* renamed from: m */
        void mo18247m();

        /* renamed from: n */
        boolean mo18250n();

        /* renamed from: o */
        void mo18251o();

        /* renamed from: p */
        void mo18256p();

        /* renamed from: q */
        void mo18258q();

        /* renamed from: r */
        CameraController.FocusMode mo18260r();

        /* renamed from: s */
        CameraController.FlashMode mo17956s();

        /* renamed from: t */
        boolean mo18266t();

        /* renamed from: u */
        MzCamUI mo18267u();
    }

    /* renamed from: com.meizu.media.camera.h$c */
    /* compiled from: FocusOverlayManager */
    private class C2099c extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10319a;

        public C2099c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10319a, false, ComponentMessageType.MSG_TYPE_FILTER_RESET, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 0:
                        FocusOverlayManager.this.m10512G();
                        FocusOverlayManager.this.f10291b.mo18251o();
                        return;
                    case 1:
                        FocusOverlayManager.this.m10513H();
                        FocusOverlayManager.this.f10291b.mo18251o();
                        return;
                    case 2:
                        FocusOverlayManager.this.mo20223g();
                        return;
                    case 3:
                        boolean unused = FocusOverlayManager.this.f10286Q = true;
                        FocusOverlayManager.this.f10300k = true;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public FocusOverlayManager(MzCamParamsManager lVar, String[] strArr, C2098b bVar, boolean z, Looper looper, C2097a aVar) {
        this.f10275F = new C2099c(looper);
        this.f10308t = new Matrix();
        this.f10272C = strArr;
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            if (k != null) {
                mo20206a(((CameraProxyV1) k).mo19740f(), lVar);
            }
        } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            mo20209a(lVar);
        }
        this.f10291b = bVar;
        mo20214b(z);
        this.f10277H = true;
    }

    /* renamed from: a */
    public final void mo20206a(Camera.Parameters parameters, MzCamParamsManager lVar) {
        Class[] clsArr = {Camera.Parameters.class, MzCamParamsManager.class};
        if (!PatchProxy.proxy(new Object[]{parameters, lVar}, this, f10268a, false, PointerIconCompat.TYPE_NO_DROP, clsArr, Void.TYPE).isSupported) {
            this.f10274E = parameters;
            mo20209a(lVar);
            if (parameters != null) {
                m10519N();
            }
        }
    }

    /* renamed from: a */
    public final void mo20209a(MzCamParamsManager lVar) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{lVar}, this, f10268a, false, PointerIconCompat.TYPE_ALL_SCROLL, new Class[]{MzCamParamsManager.class}, Void.TYPE).isSupported) {
            if (lVar != null) {
                this.f10304p = lVar.mo20326a();
                this.f10305q = lVar.mo20333b();
                if (!lVar.mo20336c() && !lVar.mo20339d()) {
                    z = false;
                }
                this.f10306r = z;
            }
            m10519N();
        }
    }

    /* renamed from: a */
    public void mo20205a(int i, int i2, int i3) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f10309u != i || this.f10310v != i2) {
                this.f10309u = i;
                this.f10310v = i2;
                this.f10311w = i3;
                m10506A();
            }
        }
    }

    /* renamed from: a */
    public void mo20210a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                mo20204a(this.f10309u / 2, (this.f10309u / 2) + CameraUtil.m15901h());
            } else {
                mo20204a(this.f10309u / 2, (this.f10310v / 2) + this.f10311w);
            }
        }
    }

    /* renamed from: b */
    public void mo20214b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10312x = z;
            m10506A();
        }
    }

    /* renamed from: a */
    public void mo20203a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f10313y = i;
            m10506A();
        }
    }

    /* renamed from: A */
    private void m10506A() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, PointerIconCompat.TYPE_ZOOM_IN, new Class[0], Void.TYPE).isSupported && this.f10309u != 0 && this.f10310v != 0) {
            Matrix matrix = new Matrix();
            CameraUtil.m15849a(matrix, this.f10312x, false, this.f10313y, this.f10309u, this.f10310v);
            matrix.invert(this.f10308t);
            this.f10303o = true;
        }
    }

    /* renamed from: B */
    private void m10507B() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, PointerIconCompat.TYPE_ZOOM_OUT, new Class[0], Void.TYPE).isSupported && this.f10306r && !this.f10307s) {
            this.f10307s = true;
            this.f10291b.mo18258q();
        }
    }

    /* renamed from: C */
    private void m10508C() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, PointerIconCompat.TYPE_GRAB, new Class[0], Void.TYPE).isSupported && this.f10306r && this.f10307s && this.f10302n != 2) {
            this.f10307s = false;
            this.f10291b.mo18258q();
        }
    }

    /* renamed from: a */
    public void mo20201a() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, ARPMessageType.MSG_TYPE_VIDEO_PLAY_RES, new Class[0], Void.TYPE).isSupported && this.f10303o) {
            if (m10516K() && (this.f10302n == 1 || this.f10302n == 3 || this.f10302n == 4)) {
                m10512G();
            }
            m10508C();
        }
    }

    /* renamed from: b */
    public void mo20213b() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, ARPMessageType.MSG_TYPE_VIDEO_PAUSE, new Class[0], Void.TYPE).isSupported && this.f10303o) {
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15952c(aVar, "doSnap: " + this.f10302n);
            this.f10282M = false;
            if (!m10516K() || this.f10302n == 3 || this.f10302n == 4) {
                m10514I();
            } else if (this.f10302n == 1) {
                this.f10302n = 2;
            } else if (this.f10302n == 0) {
                m10514I();
            }
        }
    }

    /* renamed from: a */
    public void mo20211a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10268a, false, 1024, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15952c(aVar, "onAutoFocus focused=" + z + " mState=" + this.f10302n + " shutterButtonPressed" + z2);
            if (this.f10302n == 2) {
                if (z) {
                    this.f10302n = 3;
                } else {
                    this.f10302n = 4;
                }
                m10509D();
                mo20231k();
                m10514I();
            } else if (this.f10302n == 1) {
                if (z) {
                    this.f10302n = 3;
                } else {
                    this.f10302n = 4;
                }
                mo20231k();
                this.f10297h = false;
                if (z2) {
                    m10507B();
                }
            } else {
                int i = this.f10302n;
            }
            boolean z3 = this.f10282M && this.f10302n == 4;
            if ((this.f10277H || this.f10282M || this.f10297h) && (this.f10277H || !z3)) {
                if (this.f10291b.mo18266t() && !this.f10284O && !this.f10312x) {
                    this.f10286Q = true;
                    this.f10300k = true;
                    LogUtil.m15952c(f10269m, "need shake focus in video mode");
                }
            } else if (this.f10299j || CameraModeType.m10946a().equals(CameraModeType.ModeType.BLACK_WHITE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP) || CameraModeType.m10946a().equals(CameraModeType.ModeType.PANORAMA) || CameraModeType.m10946a().equals(CameraModeType.ModeType.BACK_TRACE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.BARCODE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.NightVision) || this.f10291b.mo18266t()) {
                this.f10286Q = true;
                this.f10300k = true;
                this.f10298i = true;
                LogUtil.m15952c(f10269m, "need shake focus");
            } else if (m10518M()) {
                this.f10275F.sendEmptyMessage(1);
            } else if (m10517L()) {
                this.f10275F.sendEmptyMessage(2);
            } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL)) {
                this.f10286Q = true;
                this.f10300k = true;
                this.f10298i = true;
                LogUtil.m15952c(f10269m, "need shake focus");
            } else {
                this.f10275F.sendEmptyMessageDelayed(0, 3000);
            }
            m10509D();
        }
    }

    /* renamed from: D */
    private void m10509D() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1025, new Class[0], Void.TYPE).isSupported && this.f10280K != null) {
            this.f10291b.mo17886a(this.f10280K);
            this.f10280K = null;
        }
    }

    /* renamed from: c */
    public void mo20216c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !this.f10303o) {
            return;
        }
        if (this.f10291b.mo18267u().mo22050M()) {
            LogUtil.m15952c(f10269m, "onAutoFocusMoving() : hasFaces");
        } else if (!CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP)) {
            if (this.f10291b.mo18267u().mo22191s()) {
                LogUtil.m15952c(f10269m, "onAutoFocusMoving() : zoom is transiting");
            } else if (this.f10291b.mo18260r() != CameraController.FocusMode.CONTINUOUS_PICTURE) {
                LogUtil.m15952c(f10269m, "onAutoFocusMoving() : DON'T need CAF !!!");
            } else if (CameraModeType.ModeType.PANORAMA.equals(CameraModeType.m10946a())) {
                LogUtil.m15952c(f10269m, "onAutoFocusMoving() : PANORAMA MODE");
            } else if (this.f10302n == 0) {
                if (z && !this.f10276G) {
                    this.f10291b.mo18267u().mo22146c(-1, -1);
                    this.f10291b.mo18267u().mo22052O();
                } else if (!z && this.f10276G) {
                    this.f10291b.mo18267u().mo22070a(0);
                }
                this.f10276G = z;
            }
        }
    }

    @TargetApi(14)
    /* renamed from: b */
    private void m10525b(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, ARPMessageType.MSG_TYPE_VIDEO_STOP, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f10314z == null) {
                this.f10314z = new CopyOnWriteArrayList();
                this.f10314z.add(new Rect());
            }
            if (!m10523a(i, i2, 1.0f, this.f10314z)) {
                this.f10314z = null;
            }
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    private void m10528c(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f10268a, false, ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f10270A == null) {
                this.f10270A = new CopyOnWriteArrayList();
                this.f10270A.add(new Rect());
            }
            if (!m10523a(i, i2, CameraModeType.ModeType.FUNNY_SNAP.equals(CameraModeType.m10946a()) ? 4.0f : 1.5f, this.f10270A)) {
                this.f10270A = null;
            }
        }
    }

    /* renamed from: E */
    private void m10510E() {
        this.f10270A = null;
    }

    /* renamed from: a */
    public void mo20204a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f10268a, false, ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (!this.f10303o || this.f10302n == 2) {
                LogUtil.C2630a aVar = f10269m;
                LogUtil.m15952c(aVar, "mInitialized: " + this.f10303o + " mState: " + this.f10302n);
            } else if (this.f10291b.mo18267u().mo22156e(i, i2)) {
                LogUtil.C2630a aVar2 = f10269m;
                LogUtil.m15942a(aVar2, "onSingleTapUp mState:" + this.f10302n + ",mFocusDefault:" + this.f10277H);
                if (!this.f10277H && (this.f10302n == 1 || this.f10302n == 3 || this.f10302n == 4)) {
                    m10512G();
                }
                if (this.f10309u != 0 && this.f10310v != 0) {
                    this.f10277H = false;
                    if (this.f10304p) {
                        m10525b(i, i2);
                    }
                    if (this.f10305q) {
                        m10528c(i, i2);
                    }
                    this.f10291b.mo18267u().mo22053P();
                    this.f10291b.mo18267u().mo22162g(false);
                    this.f10291b.mo18267u().mo22146c(i, i2);
                    this.f10291b.mo18256p();
                    this.f10291b.mo18258q();
                    if (this.f10304p) {
                        this.f10279J = true;
                        m10511F();
                        if (this.f10281L) {
                            this.f10282M = true;
                            this.f10291b.mo18267u().mo22169j(this.f10282M);
                            return;
                        }
                        this.f10282M = false;
                        return;
                    }
                    mo20231k();
                    mo20236o();
                    if (this.f10312x || (DeviceHelper.f14029du == this.f10291b.mo18267u().mo22178o() && mo20225h() == CameraController.FocusMode.FIXED)) {
                        this.f10275F.sendEmptyMessageDelayed(3, this.f10299j ? 3000 : 0);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void mo20215c() {
        this.f10302n = 0;
    }

    /* renamed from: d */
    public void mo20217d() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, Constants.HTTP_ERRCODE_NOT_FIND, new Class[0], Void.TYPE).isSupported) {
            this.f10302n = 0;
            mo20233l();
            mo20231k();
        }
    }

    /* renamed from: e */
    public void mo20219e() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, Constants.HTTP_ERRCODE_VERSION_HIGH, new Class[0], Void.TYPE).isSupported) {
            mo20217d();
        }
    }

    /* renamed from: f */
    public void mo20221f() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1034, new Class[0], Void.TYPE).isSupported) {
            m10512G();
        }
    }

    /* renamed from: F */
    private void m10511F() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1035, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10269m, "Start autofocus.");
            this.f10291b.mo18245l();
            this.f10302n = 1;
            this.f10290U = false;
            if (this.f10298i) {
                this.f10286Q = false;
                this.f10298i = false;
            }
            this.f10297h = false;
            this.f10291b.mo18267u().mo22053P();
            mo20231k();
            mo20236o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m10512G() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1036, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10269m, "Cancel autofocus.");
            mo20233l();
            this.f10291b.mo18247m();
            this.f10291b.mo18267u().mo22054Q();
            this.f10302n = 0;
            mo20231k();
            mo20236o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m10513H() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1037, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10269m, "changeToCafAfterAf");
            if (this.f10303o) {
                this.f10277H = true;
            }
            this.f10291b.mo18267u().mo22051N();
            this.f10291b.mo18247m();
            this.f10302n = 0;
            mo20236o();
        }
    }

    /* renamed from: g */
    public void mo20223g() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1038, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10269m, "changeToManualAfterAf");
            if (this.f10303o) {
                this.f10277H = true;
            }
            this.f10302n = 0;
            mo20236o();
        }
    }

    /* renamed from: I */
    private void m10514I() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1039, new Class[0], Void.TYPE).isSupported && this.f10291b.mo18250n()) {
            this.f10302n = 0;
            mo20236o();
        }
    }

    /* renamed from: d */
    public void mo20218d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1040, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo20220e(z);
            if (!z || (z && this.f10302n == 1)) {
                m10512G();
            }
        }
    }

    /* renamed from: e */
    public void mo20220e(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1041, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15952c(aVar, "is block CAF " + z);
            this.f10278I = z;
        }
    }

    /* renamed from: h */
    public CameraController.FocusMode mo20225h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1042, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        this.f10286Q = false;
        if (this.f10273D != null) {
            return this.f10273D;
        }
        List<CameraController.FocusMode> Z = CameraController.m8868g().mo19448Z();
        if (Z == null) {
            return this.f10312x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
        }
        if (!this.f10304p || this.f10277H) {
            if (this.f10278I) {
                this.f10271B = this.f10312x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
            } else {
                this.f10271B = this.f10291b.mo18260r();
                if (!CameraUtil.m15861a(this.f10271B, Z) && this.f10291b.mo18267u().mo22178o() == DeviceHelper.f14029du && Z.size() == 1) {
                    this.f10271B = Z.get(0);
                    LogUtil.C2630a aVar = f10269m;
                    LogUtil.m15942a(aVar, "reset the focusMode in wide angle to " + this.f10271B);
                }
            }
            if (this.f10271B == null) {
                int i = 0;
                while (true) {
                    if (i >= this.f10272C.length) {
                        break;
                    }
                    CameraController.FocusMode convertFocusMode = CameraController.FocusMode.convertFocusMode(this.f10272C[i]);
                    if (CameraUtil.m15861a(convertFocusMode, Z)) {
                        this.f10271B = convertFocusMode;
                        break;
                    }
                    i++;
                }
            }
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.MACRO)) {
            this.f10271B = CameraController.FocusMode.MACRO;
        } else {
            this.f10271B = this.f10312x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
        }
        if (!CameraUtil.m15861a(this.f10271B, Z)) {
            LogUtil.m15942a(f10269m, "The focus mode need to be modified to be supported");
            if (this.f10271B == CameraController.FocusMode.CONTINUOUS_PICTURE) {
                this.f10286Q = true;
            }
            if (CameraUtil.m15861a(CameraController.FocusMode.AUTO, Z)) {
                this.f10271B = CameraController.FocusMode.AUTO;
            } else {
                LogUtil.m15942a(f10269m, "getFocusMode from Camera");
                this.f10271B = CameraController.m8868g().mo19483aa();
            }
        }
        if (this.f10298i) {
            this.f10286Q = true;
        }
        LogUtil.C2630a aVar2 = f10269m;
        LogUtil.m15945a(aVar2, "getFocusMode(%s), mFocusAreaSupported:" + this.f10304p + ", mFocusDefault:" + this.f10277H, this.f10271B);
        return this.f10271B;
    }

    /* renamed from: i */
    public List mo20227i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1043, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f10314z != null) {
            Rect rect = this.f10314z.get(0);
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15942a(aVar, "getFocusAreas mFoucsAreas:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
        }
        return this.f10314z;
    }

    /* renamed from: j */
    public List mo20229j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, Constants.HTTP_ERRCODE_VERSION_LOW, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f10270A != null) {
            Rect rect = this.f10270A.get(0);
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15942a(aVar, "getMeteringAreas mMeteringArea:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
        }
        return this.f10270A;
    }

    /* renamed from: k */
    public void mo20231k() {
        if (PatchProxy.proxy(new Object[0], this, f10268a, false, 1045, new Class[0], Void.TYPE).isSupported || !this.f10303o) {
            return;
        }
        if (this.f10302n == 0) {
            if (this.f10277H) {
                this.f10291b.mo18267u().mo22051N();
            } else {
                this.f10291b.mo18267u().mo22052O();
            }
        } else if (this.f10302n == 1 || this.f10302n == 2) {
            this.f10291b.mo18267u().mo22052O();
        } else if (CameraController.FocusMode.CONTINUOUS_PICTURE.equals(this.f10271B)) {
            this.f10291b.mo18267u().mo22070a(-1);
        } else if (this.f10302n == 3) {
            if (this.f10282M) {
                this.f10291b.mo18267u().mo22177n(true);
            } else {
                this.f10291b.mo18267u().mo22070a(this.f10299j ? 3000 : 0);
            }
        } else if (this.f10302n == 4) {
            this.f10291b.mo18267u().mo22175m(true);
        }
    }

    /* renamed from: l */
    public void mo20233l() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1046, new Class[0], Void.TYPE).isSupported && this.f10303o) {
            this.f10291b.mo18267u().mo22051N();
            if (this.f10304p) {
                this.f10314z = null;
            }
            if (this.f10305q) {
                m10510E();
            }
            this.f10277H = true;
        }
    }

    /* renamed from: a */
    private boolean m10523a(int i, int i2, float f, List<Rect> list) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        List<Rect> list2 = list;
        Object[] objArr = {new Integer(i3), new Integer(i4), new Float(f2), list2};
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, f10268a, false, 1047, new Class[]{Integer.TYPE, Integer.TYPE, Float.TYPE, List.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f10269m;
        LogUtil.m15942a(aVar, " start calculateTapArea x:" + i3 + ",y:" + i4 + ",mOffsetY:" + this.f10311w + ",areaMultiple:" + f2 + ",mPreviewWidth:" + this.f10309u + ",mPreviewHeight:" + this.f10310v + ", crop:" + this.f10285P);
        int i5 = i4 - this.f10311w;
        Rect rect = null;
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            rect = m10521a(i3, i5, f2, list2.get(0));
            list.clear();
            list2.add(rect);
        } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            CameraControllerV2 cameraControllerV2 = (CameraControllerV2) CameraController.m8868g();
            Rect ai = Build.VERSION.SDK_INT >= 23 ? cameraControllerV2.mo19567ai() : null;
            if (Build.VERSION.SDK_INT >= 23) {
                rect = new Rect(cameraControllerV2.mo19568aj());
            }
            Rect rect2 = rect;
            rect2.inset((int) ((this.f10285P / 2.0f) * ((float) rect2.width())), (int) ((this.f10285P / 2.0f) * ((float) rect2.height())));
            int i6 = this.f10309u;
            int i7 = this.f10310v;
            int a = CameraUtil.m15809a();
            int b = CameraUtil.m15865b();
            if (rect2.width() * i6 != rect2.height() * i7) {
                if (i6 >= a) {
                    i7 = (rect2.width() * i6) / rect2.height();
                }
                if (i7 >= b) {
                    i6 = (rect2.height() * i7) / rect2.width();
                }
            }
            int i8 = i6;
            int i9 = i7;
            int i10 = i5 + ((i9 - this.f10310v) / 2);
            int a2 = CameraUtil.m15812a(((i8 - this.f10309u) / 2) + i3, 0, this.f10309u);
            rect = m10520a((float) a2, (float) CameraUtil.m15812a(i10, this.f10311w, this.f10310v + this.f10311w), i8, i9, f, rect2, ai);
            list.clear();
            list2.add(rect);
        }
        if (rect != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private Rect m10521a(int i, int i2, float f, Rect rect) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Float(f), rect};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 1048, new Class[]{Integer.TYPE, Integer.TYPE, Float.TYPE, Rect.class}, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        int J = (int) (((float) m10515J()) * f);
        int i3 = J / 2;
        int a = CameraUtil.m15812a(i - i3, 0, this.f10309u - J);
        int a2 = CameraUtil.m15812a(i2 - i3, 0, this.f10310v - J);
        RectF rectF = new RectF((float) a, (float) a2, (float) (a + J), (float) (a2 + J));
        this.f10308t.mapRect(rectF);
        CameraUtil.m15850a(rectF, rect);
        return rect;
    }

    /* renamed from: a */
    private Rect m10520a(float f, float f2, int i, int i2, float f3, Rect rect, Rect rect2) {
        float f4 = f;
        float f5 = f2;
        int i3 = i;
        int i4 = i2;
        float f6 = f3;
        Rect rect3 = rect;
        Object[] objArr = {new Float(f4), new Float(f5), new Integer(i3), new Integer(i4), new Float(f6), rect3, rect2};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        Class[] clsArr = {Float.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE, Rect.class, Rect.class};
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1049, clsArr, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        int max = (int) (((float) (Math.max(i, i2) / 8)) * f6);
        float f7 = (float) (max / 2);
        RectF rectF = new RectF(f4 - f7, f5 - f7, f4 + f7, f7 + f5);
        LogUtil.C2630a aVar = f10269m;
        LogUtil.m15942a(aVar, "start calculateTapAreaCamera2 after meteringRegionF rect left:{" + rectF.left + ",right:" + rectF.right + ",top:" + rectF.top + ",bottom:" + rectF.bottom + "}, x:" + f4 + ",y:" + f5 + ",side:" + max + ",width:" + i3 + ",height:" + i4 + ",originCropRegion.width():" + rect2.width() + ",originCropRegion.height():" + rect2.height() + "mDisplayOrientation:" + this.f10313y);
        Matrix matrix = new Matrix();
        CameraUtil.m15849a(matrix, this.f10312x, false, this.f10313y, i, i2);
        matrix.invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(((float) (-rect2.width())) / 2.0f, ((float) (-rect2.height())) / 2.0f);
        matrix2.postScale(2000.0f / ((float) rect2.width()), 2000.0f / ((float) rect2.height()));
        matrix2.invert(matrix2);
        matrix.mapRect(rectF);
        matrix2.mapRect(rectF);
        rectF.left = ((rectF.left * ((float) rect.width())) / ((float) rect2.width())) + ((float) rect3.left);
        rectF.top = ((rectF.top * ((float) rect.height())) / ((float) rect2.height())) + ((float) rect3.top);
        rectF.right = ((rectF.right * ((float) rect.width())) / ((float) rect2.width())) + ((float) rect3.left);
        rectF.bottom = ((rectF.bottom * ((float) rect.height())) / ((float) rect2.height())) + ((float) rect3.top);
        Rect rect4 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        rect4.left = CameraUtil.m15812a(rect4.left, rect3.left, rect3.right);
        rect4.top = CameraUtil.m15812a(rect4.top, rect3.top, rect3.bottom);
        rect4.right = CameraUtil.m15812a(rect4.right, rect3.left, rect3.right);
        rect4.bottom = CameraUtil.m15812a(rect4.bottom, rect3.top, rect3.bottom);
        LogUtil.C2630a aVar2 = f10269m;
        LogUtil.m15942a(aVar2, "end calculateTapAreaCamera2 after calculateTapArea rect left:{" + rect4.left + ",right:" + rect4.right + ",top:" + rect4.top + ",bottom:" + rect4.bottom + "}, x:" + f4 + ",y:" + f5);
        return rect4;
    }

    /* renamed from: J */
    private int m10515J() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1050, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : Math.max(this.f10309u, this.f10310v) / 8;
    }

    /* renamed from: m */
    public boolean mo20234m() {
        return this.f10302n == 1;
    }

    /* renamed from: n */
    public boolean mo20235n() {
        return this.f10302n == 2;
    }

    /* renamed from: o */
    public void mo20236o() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1051, new Class[0], Void.TYPE).isSupported) {
            this.f10275F.removeMessages(0);
            this.f10275F.removeMessages(1);
            this.f10275F.removeMessages(2);
        }
    }

    /* renamed from: a */
    public void mo20208a(CameraController.FocusMode focusMode) {
        this.f10273D = focusMode;
    }

    /* renamed from: f */
    public void mo20222f(boolean z) {
        this.f10307s = z;
    }

    /* renamed from: p */
    public boolean mo20237p() {
        return this.f10307s;
    }

    /* renamed from: K */
    private boolean m10516K() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1052, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        CameraController.FocusMode h = mo20225h();
        if (CameraController.FocusMode.INFINITY.equals(h) || CameraController.FocusMode.FIXED.equals(h) || CameraController.FocusMode.EDOF.equals(h)) {
            return false;
        }
        return true;
    }

    /* renamed from: q */
    public void mo20238q() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1053, new Class[0], Void.TYPE).isSupported && this.f10291b != null) {
            if (!CameraController.FlashMode.FLASH_MODE_OFF.equals(this.f10291b.mo17956s()) && !CameraController.FlashMode.FLASH_MODE_TORCH.equals(this.f10291b.mo17956s())) {
                this.f10280K = this.f10291b.mo17956s();
                this.f10291b.mo17886a(CameraController.FlashMode.FLASH_MODE_OFF);
            }
            m10512G();
            m10511F();
        }
    }

    /* renamed from: r */
    public void mo20239r() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1054, new Class[0], Void.TYPE).isSupported && this.f10302n == 1) {
            m10512G();
        }
    }

    /* renamed from: a */
    public void mo20207a(CameraController.FlashMode flashMode, boolean z) {
        if (PatchProxy.proxy(new Object[]{flashMode, new Byte(z ? (byte) 1 : 0)}, this, f10268a, false, 1055, new Class[]{CameraController.FlashMode.class, Boolean.TYPE}, Void.TYPE).isSupported || flashMode == null) {
            return;
        }
        if (z) {
            this.f10280K = flashMode;
        } else if (this.f10280K != null && !CameraController.FlashMode.FLASH_MODE_OFF.equals(flashMode) && !CameraController.FlashMode.FLASH_MODE_TORCH.equals(flashMode)) {
            this.f10280K = flashMode;
        }
    }

    /* renamed from: a */
    public void mo20212a(float[] fArr, boolean z) {
        if (!PatchProxy.proxy(new Object[]{fArr, new Byte(z ? (byte) 1 : 0)}, this, f10268a, false, 1056, new Class[]{float[].class, Boolean.TYPE}, Void.TYPE).isSupported && this.f10286Q && !this.f10283N) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10288S > 200) {
                if (this.f10287R == null) {
                    this.f10287R = new float[3];
                    System.arraycopy(fArr, 0, this.f10287R, 0, 3);
                } else if (this.f10300k) {
                    this.f10300k = false;
                    System.arraycopy(fArr, 0, this.f10287R, 0, 3);
                } else {
                    int a = CameraUtil.m15815a(fArr, this.f10287R);
                    if (this.f10290U && a < 4 && currentTimeMillis - this.f10289T > 500) {
                        this.f10279J = false;
                        if (this.f10312x || (mo20225h() == CameraController.FocusMode.FIXED && DeviceHelper.f14029du == this.f10291b.mo18267u().mo22178o())) {
                            this.f10275F.sendEmptyMessage(0);
                            this.f10286Q = false;
                            this.f10290U = false;
                        } else if (this.f10298i) {
                            this.f10298i = false;
                            this.f10286Q = false;
                            this.f10290U = false;
                            if (m10518M()) {
                                LogUtil.m15952c(f10269m, "shake detected , change to CAF after set Exposure value!!!");
                                this.f10275F.sendEmptyMessage(1);
                                mo20242u();
                            } else if (!DeviceHelper.f13839S) {
                                LogUtil.m15952c(f10269m, "shake detected , reset touch focus after set Exposure value!!!");
                                this.f10275F.sendEmptyMessage(0);
                            } else {
                                mo20238q();
                            }
                        } else if (this.f10291b.mo18266t()) {
                            if (!this.f10284O) {
                                this.f10286Q = false;
                                this.f10290U = false;
                                LogUtil.m15952c(f10269m, "shake detected , change to CAF in video mode!!!");
                                this.f10275F.sendEmptyMessage(1);
                            }
                        } else if (!z) {
                            mo20238q();
                        }
                    }
                    if (!this.f10290U && a >= 6) {
                        this.f10290U = true;
                        this.f10289T = currentTimeMillis;
                        LogUtil.m15952c(f10269m, "shake detected !!!");
                    }
                    System.arraycopy(fArr, 0, this.f10287R, 0, 3);
                }
                this.f10288S = currentTimeMillis;
            }
        }
    }

    /* renamed from: L */
    private boolean m10517L() {
        boolean z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1057, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceHelper.f13841U || !CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL)) {
            return false;
        }
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            z = this.f10291b.mo18260r().equals(CameraController.FocusMode.MANUAL);
        } else {
            z = DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? this.f10291b.mo18260r().equals(CameraController.FocusMode.FIXED) : false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* renamed from: M */
    private boolean m10518M() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1058, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13839S) {
            return false;
        }
        CameraController.FocusMode focusMode = CameraController.FocusMode.CONTINUOUS_PICTURE;
        if (this.f10291b.mo18260r().equals(focusMode) && CameraUtil.m15861a(focusMode, CameraController.m8868g().mo19448Z())) {
            return true;
        }
        return false;
    }

    /* renamed from: s */
    public boolean mo20240s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1059, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10302n != 2) {
            return false;
        }
        this.f10302n = 1;
        LogUtil.m15952c(f10269m, "cancelCaptureAfterFocused mState = STATE_FOCUSING");
        return true;
    }

    /* renamed from: g */
    public void mo20224g(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1060, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10281L) {
                mo20233l();
            }
            this.f10281L = z;
        }
    }

    /* renamed from: h */
    public void mo20226h(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1061, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10291b.mo18267u().mo22173l(z);
        }
    }

    /* renamed from: i */
    public void mo20228i(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10268a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1062, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10269m;
            LogUtil.m15942a(aVar, "set UI Block Shake Focus " + z);
            this.f10283N = z;
        }
    }

    /* renamed from: t */
    public boolean mo20241t() {
        return this.f10283N;
    }

    /* renamed from: u */
    public void mo20242u() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1063, new Class[0], Void.TYPE).isSupported) {
            this.f10291b.mo18267u().mo22051N();
        }
    }

    /* renamed from: v */
    public void mo20243v() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, 1064, new Class[0], Void.TYPE).isSupported) {
            this.f10291b.mo18267u().mo22082a(mo20245x());
        }
    }

    /* renamed from: w */
    public boolean mo20244w() {
        return this.f10299j;
    }

    /* renamed from: N */
    private void m10519N() {
        if (!PatchProxy.proxy(new Object[0], this, f10268a, false, ComponentMessageType.MSG_TYPE_FILTER_START, new Class[0], Void.TYPE).isSupported) {
            if (this.f10274E == null || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2);
                return;
            }
            this.f10293d = (float) this.f10274E.getMaxExposureCompensation();
            this.f10294e = (float) this.f10274E.getMinExposureCompensation();
            this.f10292c = this.f10274E.getExposureCompensationStep();
        }
    }

    /* renamed from: x */
    public MzFocusRenderer.C2743b mo20245x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10268a, false, 1066, new Class[0], MzFocusRenderer.C2743b.class);
        if (proxy.isSupported) {
            return (MzFocusRenderer.C2743b) proxy.result;
        }
        if (this.f10301l == null) {
            this.f10301l = new MzFocusRenderer.C2743b() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10315a;

                /* renamed from: a */
                public void mo20248a(float f) {
                    if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f10315a, false, 1068, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
                        if (DeviceHelper.f13937bk == DeviceHelper.EXPOSURE_STEP.STANDARD) {
                            FocusOverlayManager.this.f10295f = ((float) Math.round(((FocusOverlayManager.this.f10293d * FocusOverlayManager.this.f10292c) * f) * 10.0f)) / 10.0f;
                        } else {
                            int round = Math.round(((FocusOverlayManager.this.f10293d * 10.0f) * f) / (FocusOverlayManager.this.f10292c * 10.0f));
                            FocusOverlayManager.this.f10295f = ((float) Math.round((FocusOverlayManager.this.f10292c * ((float) round)) * 10.0f)) / 10.0f;
                        }
                        new AsyncTaskEx<Void, Void, Void>() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f10317a;

                            /* renamed from: a */
                            public Void mo17658a(Void... voidArr) {
                                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10317a, false, ComponentMessageType.MSG_TYPE_FILTER_DISABLE_TECHNIQUE, new Class[]{Void[].class}, Void.class);
                                if (proxy.isSupported) {
                                    return (Void) proxy.result;
                                }
                                if (FocusOverlayManager.this.f10295f == FocusOverlayManager.this.f10296g) {
                                    return null;
                                }
                                FocusOverlayManager.this.f10297h = true;
                                FocusOverlayManager.this.f10291b.mo18015a(String.valueOf(FocusOverlayManager.this.f10295f), true);
                                FocusOverlayManager.this.f10296g = FocusOverlayManager.this.f10295f;
                                return null;
                            }
                        }.mo22610a(AsyncTaskEx.f13745s, (Params[]) new Void[0]);
                    }
                }

                /* renamed from: a */
                public void mo20247a() {
                    if (!PatchProxy.proxy(new Object[0], this, f10315a, false, ComponentMessageType.MSG_TYPE_FILTER_UPDATE, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.m15952c(FocusOverlayManager.f10269m, "onStartTrackingTouch!!!");
                        boolean unused = FocusOverlayManager.this.f10286Q = false;
                        FocusOverlayManager.this.f10298i = false;
                        FocusOverlayManager.this.f10300k = false;
                        FocusOverlayManager.this.mo20236o();
                        boolean unused2 = FocusOverlayManager.this.f10277H = false;
                        FocusOverlayManager.this.f10291b.mo18258q();
                    }
                }

                /* renamed from: b */
                public void mo20249b() {
                    if (!PatchProxy.proxy(new Object[0], this, f10315a, false, 1070, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.m15952c(FocusOverlayManager.f10269m, "onStopTrackingTouch!!!");
                        boolean unused = FocusOverlayManager.this.f10286Q = true;
                        FocusOverlayManager.this.f10300k = true;
                        FocusOverlayManager.this.f10298i = true;
                    }
                }
            };
        }
        return this.f10301l;
    }

    /* renamed from: y */
    public boolean mo20246y() {
        return this.f10292c <= 1.0f;
    }

    /* renamed from: j */
    public void mo20230j(boolean z) {
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10268a, false, ComponentMessageType.MSG_TYPE_FILTER_STOP, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z || !mo20246y()) {
                z2 = false;
            }
            this.f10299j = z2;
            this.f10291b.mo18267u().mo22171k(this.f10299j);
        }
    }

    /* renamed from: k */
    public void mo20232k(boolean z) {
        this.f10284O = z;
        if (z) {
            this.f10286Q = false;
            this.f10290U = false;
        }
    }

    /* renamed from: a */
    public void mo20202a(float f) {
        this.f10285P = f;
    }
}
