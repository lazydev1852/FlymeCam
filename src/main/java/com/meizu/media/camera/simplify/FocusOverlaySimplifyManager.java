package com.meizu.media.camera.simplify;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraControllerV2;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.simplify.b */
public class FocusOverlaySimplifyManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f11724a;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final LogUtil.C2630a f11725m = new LogUtil.C2630a("FocusManager");

    /* renamed from: A */
    private List<Rect> f11726A;

    /* renamed from: B */
    private List<Rect> f11727B;

    /* renamed from: C */
    private CameraController.FocusMode f11728C;

    /* renamed from: D */
    private String[] f11729D;

    /* renamed from: E */
    private CameraController.FocusMode f11730E;

    /* renamed from: F */
    private Camera.Parameters f11731F;

    /* renamed from: G */
    private Handler f11732G;

    /* renamed from: H */
    private boolean f11733H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public boolean f11734I;

    /* renamed from: J */
    private boolean f11735J;

    /* renamed from: K */
    private boolean f11736K = false;

    /* renamed from: L */
    private CameraController.FlashMode f11737L;

    /* renamed from: M */
    private boolean f11738M;

    /* renamed from: N */
    private boolean f11739N;

    /* renamed from: O */
    private boolean f11740O;

    /* renamed from: P */
    private boolean f11741P = false;

    /* renamed from: Q */
    private float f11742Q = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f11743R = false;

    /* renamed from: S */
    private float[] f11744S;

    /* renamed from: T */
    private long f11745T;

    /* renamed from: U */
    private long f11746U;

    /* renamed from: V */
    private boolean f11747V = false;

    /* renamed from: b */
    C2303b f11748b;

    /* renamed from: c */
    float f11749c = 1.0f;

    /* renamed from: d */
    float f11750d = 3.0f;

    /* renamed from: e */
    float f11751e = -3.0f;

    /* renamed from: f */
    float f11752f;

    /* renamed from: g */
    float f11753g;

    /* renamed from: h */
    boolean f11754h = false;

    /* renamed from: i */
    boolean f11755i = false;

    /* renamed from: j */
    boolean f11756j = false;

    /* renamed from: k */
    boolean f11757k = false;

    /* renamed from: l */
    MzFocusRenderer.C2743b f11758l;

    /* renamed from: n */
    private int f11759n = 0;

    /* renamed from: o */
    private boolean f11760o;

    /* renamed from: p */
    private boolean f11761p;

    /* renamed from: q */
    private boolean f11762q;

    /* renamed from: r */
    private boolean f11763r;

    /* renamed from: s */
    private boolean f11764s;

    /* renamed from: t */
    private Matrix f11765t;

    /* renamed from: u */
    private int f11766u;

    /* renamed from: v */
    private int f11767v;

    /* renamed from: w */
    private int f11768w;

    /* renamed from: x */
    private boolean f11769x;

    /* renamed from: y */
    private boolean f11770y;

    /* renamed from: z */
    private int f11771z;

    /* renamed from: com.meizu.media.camera.simplify.b$a */
    /* compiled from: FocusOverlaySimplifyManager */
    public interface C2302a {
    }

    /* renamed from: com.meizu.media.camera.simplify.b$b */
    /* compiled from: FocusOverlaySimplifyManager */
    public interface C2303b {
        /* renamed from: H */
        void mo18357H();

        /* renamed from: I */
        void mo18358I();

        /* renamed from: J */
        boolean mo18359J();

        /* renamed from: L */
        void mo18361L();

        /* renamed from: M */
        void mo18362M();

        /* renamed from: N */
        void mo18363N();

        /* renamed from: X */
        CameraController.FlashMode mo18373X();

        /* renamed from: a */
        void mo18391a(CameraController.FlashMode flashMode);

        /* renamed from: a */
        void mo18395a(String str, boolean z);

        /* renamed from: ar */
        MzSimplifyCamUI mo18443ar();

        /* renamed from: aw */
        CameraController.FocusMode mo18448aw();

        /* renamed from: az */
        boolean mo18451az();
    }

    /* renamed from: com.meizu.media.camera.simplify.b$c */
    /* compiled from: FocusOverlaySimplifyManager */
    private class C2304c extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f11776a;

        public C2304c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f11776a, false, 5471, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 0:
                        FocusOverlaySimplifyManager.this.m12788E();
                        FocusOverlaySimplifyManager.this.f11748b.mo18361L();
                        return;
                    case 1:
                        FocusOverlaySimplifyManager.this.m12789F();
                        FocusOverlaySimplifyManager.this.f11748b.mo18361L();
                        return;
                    case 2:
                        FocusOverlaySimplifyManager.this.mo21077f();
                        return;
                    case 3:
                        boolean unused = FocusOverlaySimplifyManager.this.f11743R = true;
                        FocusOverlaySimplifyManager.this.f11757k = true;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public FocusOverlaySimplifyManager(MzSimplifyCamParamsManager cVar, String[] strArr, C2303b bVar, boolean z, boolean z2, Looper looper, C2302a aVar) {
        this.f11732G = new C2304c(looper);
        this.f11765t = new Matrix();
        this.f11729D = strArr;
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            if (k != null) {
                mo21062a(((CameraProxyV1) k).mo19740f(), cVar);
            }
        } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            mo21065a(cVar);
        }
        this.f11748b = bVar;
        mo21070b(z);
        this.f11734I = true;
        this.f11770y = z2;
    }

    /* renamed from: a */
    public final void mo21062a(Camera.Parameters parameters, MzSimplifyCamParamsManager cVar) {
        Class[] clsArr = {Camera.Parameters.class, MzSimplifyCamParamsManager.class};
        if (!PatchProxy.proxy(new Object[]{parameters, cVar}, this, f11724a, false, 5411, clsArr, Void.TYPE).isSupported) {
            this.f11731F = parameters;
            mo21065a(cVar);
            if (parameters != null) {
                m12795L();
            }
        }
    }

    /* renamed from: a */
    public final void mo21065a(MzSimplifyCamParamsManager cVar) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{cVar}, this, f11724a, false, 5412, new Class[]{MzSimplifyCamParamsManager.class}, Void.TYPE).isSupported) {
            if (cVar != null) {
                this.f11761p = cVar.mo21113a();
                this.f11762q = cVar.mo21119b();
                if (!cVar.mo21121c() && !cVar.mo21122d()) {
                    z = false;
                }
                this.f11763r = z;
            }
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "setParameters mFocusAreaSupported:" + this.f11761p + ",mMeteringAreaSupported:" + this.f11762q);
            m12795L();
        }
    }

    /* renamed from: a */
    public void mo21061a(int i, int i2, int i3) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5413, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f11766u != i || this.f11767v != i2) {
                this.f11766u = i;
                this.f11767v = i2;
                this.f11768w = i3;
                m12806z();
            }
        }
    }

    /* renamed from: a */
    public void mo21066a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5414, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                mo21060a(this.f11766u / 2, (this.f11766u / 2) + CameraUtil.m15901h());
            } else {
                mo21060a(this.f11766u / 2, (this.f11767v / 2) + this.f11768w);
            }
        }
    }

    /* renamed from: b */
    public void mo21070b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5415, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11769x = z;
            m12806z();
        }
    }

    /* renamed from: a */
    public void mo21059a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5416, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f11771z = i;
            m12806z();
        }
    }

    /* renamed from: z */
    private void m12806z() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5417, new Class[0], Void.TYPE).isSupported && this.f11766u != 0 && this.f11767v != 0) {
            Matrix matrix = new Matrix();
            CameraUtil.m15849a(matrix, this.f11769x, this.f11770y, this.f11771z, this.f11766u, this.f11767v);
            matrix.invert(this.f11765t);
            this.f11760o = true;
        }
    }

    /* renamed from: A */
    private void m12784A() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5418, new Class[0], Void.TYPE).isSupported && this.f11763r && !this.f11764s) {
            this.f11764s = true;
            this.f11748b.mo18363N();
        }
    }

    /* renamed from: a */
    public void mo21057a() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5422, new Class[0], Void.TYPE).isSupported && this.f11760o) {
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15952c(aVar, "doSnap: " + this.f11759n);
            this.f11739N = false;
            if (!m12792I() || this.f11759n == 3 || this.f11759n == 4) {
                m12790G();
            } else if (this.f11759n == 1) {
                this.f11759n = 2;
            } else if (this.f11759n == 0) {
                m12790G();
            }
        }
    }

    /* renamed from: a */
    public void mo21067a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11724a, false, 5423, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15952c(aVar, "onAutoFocus focused=" + z + " mState=" + this.f11759n + " shutterButtonPressed" + z2);
            if (this.f11759n == 2) {
                if (z) {
                    this.f11759n = 3;
                } else {
                    this.f11759n = 4;
                }
                m12785B();
                mo21085j();
                m12790G();
            } else if (this.f11759n == 1) {
                if (z) {
                    this.f11759n = 3;
                } else {
                    this.f11759n = 4;
                }
                mo21085j();
                this.f11754h = false;
                if (z2) {
                    m12784A();
                }
            } else {
                int i = this.f11759n;
            }
            boolean z3 = this.f11739N && this.f11759n == 4;
            if ((this.f11734I || this.f11739N || this.f11754h) && (this.f11734I || !z3)) {
                if (this.f11748b.mo18451az() && !this.f11741P && !this.f11769x) {
                    this.f11743R = true;
                    this.f11757k = true;
                    LogUtil.m15952c(f11725m, "need shake focus in video mode");
                }
            } else if (this.f11756j || CameraModeType.m10946a().equals(CameraModeType.ModeType.BLACK_WHITE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP) || CameraModeType.m10946a().equals(CameraModeType.ModeType.PANORAMA) || CameraModeType.m10946a().equals(CameraModeType.ModeType.BACK_TRACE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.BARCODE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.NightVision) || this.f11748b.mo18451az()) {
                this.f11743R = true;
                this.f11757k = true;
                this.f11755i = true;
                LogUtil.m15952c(f11725m, "need shake focus");
            } else if (m12794K()) {
                this.f11732G.sendEmptyMessage(1);
            } else if (m12793J()) {
                this.f11732G.sendEmptyMessage(2);
            } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL)) {
                this.f11743R = true;
                this.f11757k = true;
                this.f11755i = true;
                LogUtil.m15952c(f11725m, "need shake focus");
            } else {
                this.f11732G.sendEmptyMessageDelayed(0, 3000);
            }
            m12785B();
        }
    }

    /* renamed from: B */
    private void m12785B() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5424, new Class[0], Void.TYPE).isSupported && this.f11737L != null) {
            this.f11748b.mo18391a(this.f11737L);
            this.f11737L = null;
        }
    }

    /* renamed from: c */
    public void mo21072c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5425, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !this.f11760o) {
            return;
        }
        if (this.f11748b.mo18443ar().mo21218s()) {
            LogUtil.m15952c(f11725m, "onAutoFocusMoving() : hasFaces");
        } else if (!CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP)) {
            if (this.f11748b.mo18448aw() != CameraController.FocusMode.CONTINUOUS_PICTURE) {
                LogUtil.m15952c(f11725m, "onAutoFocusMoving() : DON'T need CAF !!!");
            } else if (CameraModeType.ModeType.PANORAMA.equals(CameraModeType.m10946a())) {
                LogUtil.m15952c(f11725m, "onAutoFocusMoving() : PANORAMA MODE");
            } else if (this.f11759n == 0) {
                if (z && !this.f11733H) {
                    this.f11748b.mo18443ar().mo21159a(-1, -1);
                    this.f11748b.mo18443ar().mo21220u();
                } else if (!z && this.f11733H) {
                    this.f11748b.mo18443ar().mo21162a(0);
                }
                this.f11733H = z;
            }
        }
    }

    @TargetApi(14)
    /* renamed from: b */
    private void m12801b(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5426, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "initializeFocusAreas x:" + i + ",y:" + i2 + ",mFocusArea:" + this.f11726A);
            if (this.f11726A == null) {
                this.f11726A = new ArrayList();
                this.f11726A.add(new Rect());
            }
            Rect rect = this.f11726A.get(0);
            if (rect != null) {
                LogUtil.C2630a aVar2 = f11725m;
                LogUtil.m15942a(aVar2, "after init mFoucsAreas:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
            }
            if (!m12799a(i, i2, 1.0f, this.f11726A)) {
                this.f11726A = null;
            }
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    private void m12804c(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11724a, false, 5427, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f11727B == null) {
                this.f11727B = new ArrayList();
                this.f11727B.add(new Rect());
            }
            Rect rect = this.f11727B.get(0);
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "after init mMeteringArea:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
            if (!m12799a(i, i2, CameraModeType.ModeType.FUNNY_SNAP.equals(CameraModeType.m10946a()) ? 4.0f : 1.5f, this.f11727B)) {
                this.f11727B = null;
            }
        }
    }

    /* renamed from: C */
    private void m12786C() {
        this.f11727B = null;
    }

    /* renamed from: a */
    public void mo21060a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11724a, false, 5430, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (!this.f11760o || this.f11759n == 2) {
                LogUtil.C2630a aVar = f11725m;
                LogUtil.m15952c(aVar, "mInitialized: " + this.f11760o + " mState: " + this.f11759n);
            } else if (this.f11748b.mo18443ar().mo21183b(i, i2)) {
                LogUtil.C2630a aVar2 = f11725m;
                LogUtil.m15942a(aVar2, "onSingleTapUp mState:" + this.f11759n + ",mFocusDefault:" + this.f11734I + ",mFocusAreaSupported:" + this.f11761p + ",mMeteringAreaSupported:" + this.f11762q);
                if (!this.f11734I && (this.f11759n == 1 || this.f11759n == 3 || this.f11759n == 4)) {
                    m12788E();
                }
                if (this.f11766u != 0 && this.f11767v != 0) {
                    this.f11734I = false;
                    if (this.f11761p) {
                        m12801b(i, i2);
                    }
                    if (this.f11762q) {
                        m12804c(i, i2);
                    }
                    this.f11748b.mo18443ar().mo21221v();
                    this.f11748b.mo18443ar().mo21159a(i, i2);
                    this.f11748b.mo18362M();
                    this.f11748b.mo18363N();
                    if (this.f11761p) {
                        this.f11736K = true;
                        m12787D();
                        if (this.f11738M) {
                            this.f11739N = true;
                            this.f11748b.mo18443ar().mo21193f(this.f11739N);
                            return;
                        }
                        this.f11739N = false;
                        return;
                    }
                    mo21085j();
                    mo21091n();
                    if (this.f11769x) {
                        this.f11732G.sendEmptyMessageDelayed(3, this.f11756j ? 3000 : 0);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo21069b() {
        this.f11759n = 0;
    }

    /* renamed from: c */
    public void mo21071c() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5431, new Class[0], Void.TYPE).isSupported) {
            this.f11759n = 0;
            mo21087k();
            mo21085j();
        }
    }

    /* renamed from: d */
    public void mo21073d() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5432, new Class[0], Void.TYPE).isSupported) {
            mo21071c();
        }
    }

    /* renamed from: e */
    public void mo21075e() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5433, new Class[0], Void.TYPE).isSupported) {
            m12788E();
        }
    }

    /* renamed from: D */
    private void m12787D() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5434, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11725m, "Start autofocus.");
            this.f11748b.mo18357H();
            this.f11759n = 1;
            this.f11747V = false;
            if (this.f11755i) {
                this.f11743R = false;
                this.f11755i = false;
            }
            this.f11754h = false;
            this.f11748b.mo18443ar().mo21221v();
            mo21085j();
            mo21091n();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m12788E() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5435, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11725m, "Cancel autofocus.");
            mo21087k();
            this.f11748b.mo18358I();
            this.f11748b.mo18443ar().mo21222w();
            this.f11759n = 0;
            mo21085j();
            mo21091n();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m12789F() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5436, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11725m, "changeToCafAfterAf");
            if (this.f11760o) {
                this.f11734I = true;
            }
            this.f11748b.mo18443ar().mo21219t();
            this.f11748b.mo18358I();
            this.f11759n = 0;
            mo21091n();
        }
    }

    /* renamed from: f */
    public void mo21077f() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5437, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11725m, "changeToManualAfterAf");
            if (this.f11760o) {
                this.f11734I = true;
            }
            this.f11759n = 0;
            mo21091n();
        }
    }

    /* renamed from: G */
    private void m12790G() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5438, new Class[0], Void.TYPE).isSupported && this.f11748b.mo18359J()) {
            this.f11759n = 0;
            mo21091n();
        }
    }

    /* renamed from: d */
    public void mo21074d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5439, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21076e(z);
            if (!z || (z && this.f11759n == 1)) {
                m12788E();
            }
        }
    }

    /* renamed from: e */
    public void mo21076e(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5440, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15952c(aVar, "is block CAF " + z);
            this.f11735J = z;
        }
    }

    /* renamed from: g */
    public CameraController.FocusMode mo21079g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5441, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        this.f11743R = false;
        if (this.f11730E != null) {
            return this.f11730E;
        }
        List<CameraController.FocusMode> Z = CameraController.m8868g().mo19448Z();
        if (Z == null) {
            return this.f11769x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
        }
        if (!this.f11761p || this.f11734I) {
            if (this.f11735J) {
                this.f11728C = this.f11769x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
            } else {
                this.f11728C = this.f11748b.mo18448aw();
            }
            if (this.f11728C == null) {
                int i = 0;
                while (true) {
                    if (i >= this.f11729D.length) {
                        break;
                    }
                    CameraController.FocusMode convertFocusMode = CameraController.FocusMode.convertFocusMode(this.f11729D[i]);
                    if (CameraUtil.m15861a(convertFocusMode, Z)) {
                        this.f11728C = convertFocusMode;
                        break;
                    }
                    i++;
                }
            }
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.MACRO)) {
            this.f11728C = CameraController.FocusMode.MACRO;
        } else {
            this.f11728C = this.f11769x ? CameraController.FocusMode.FIXED : CameraController.FocusMode.AUTO;
        }
        if (this.f11728C == CameraController.FocusMode.MACRO) {
            this.f11743R = true;
        }
        if (!CameraUtil.m15861a(this.f11728C, Z)) {
            LogUtil.m15942a(f11725m, "The focus mode need to be modified to be supported");
            if (this.f11728C == CameraController.FocusMode.CONTINUOUS_PICTURE) {
                this.f11743R = true;
            }
            if (CameraUtil.m15861a(CameraController.FocusMode.AUTO, Z)) {
                this.f11728C = CameraController.FocusMode.AUTO;
            } else {
                LogUtil.m15942a(f11725m, "getFocusMode from Camera");
                this.f11728C = CameraController.m8868g().mo19483aa();
            }
        }
        if (this.f11755i) {
            this.f11743R = true;
        }
        LogUtil.C2630a aVar = f11725m;
        LogUtil.m15945a(aVar, "getFocusMode(%s), mFocusAreaSupported:" + this.f11761p + ", mFocusDefault:" + this.f11734I, this.f11728C);
        return this.f11728C;
    }

    /* renamed from: h */
    public List mo21081h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5442, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f11726A != null) {
            Rect rect = this.f11726A.get(0);
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "getFocusAreas mFoucsAreas:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
        }
        return this.f11726A;
    }

    /* renamed from: i */
    public List mo21083i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5443, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f11727B != null) {
            Rect rect = this.f11727B.get(0);
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "getMeteringAreas mMeteringArea:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "},width:" + rect.width());
        }
        return this.f11727B;
    }

    /* renamed from: j */
    public void mo21085j() {
        if (PatchProxy.proxy(new Object[0], this, f11724a, false, 5444, new Class[0], Void.TYPE).isSupported || !this.f11760o) {
            return;
        }
        if (this.f11759n == 0) {
            if (this.f11734I) {
                this.f11748b.mo18443ar().mo21219t();
            } else {
                this.f11748b.mo18443ar().mo21220u();
            }
        } else if (this.f11759n == 1 || this.f11759n == 2) {
            this.f11748b.mo18443ar().mo21220u();
        } else if (CameraController.FocusMode.CONTINUOUS_PICTURE.equals(this.f11728C)) {
            this.f11748b.mo18443ar().mo21162a(-1);
        } else if (this.f11759n == 3) {
            if (this.f11739N) {
                this.f11748b.mo18443ar().mo21201j(true);
            } else {
                this.f11748b.mo18443ar().mo21162a(this.f11756j ? 3000 : 0);
            }
        } else if (this.f11759n == 4) {
            this.f11748b.mo18443ar().mo21199i(true);
        }
    }

    /* renamed from: k */
    public void mo21087k() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5445, new Class[0], Void.TYPE).isSupported && this.f11760o) {
            this.f11748b.mo18443ar().mo21219t();
            if (this.f11761p) {
                this.f11726A = null;
            }
            if (this.f11762q) {
                m12786C();
            }
            this.f11734I = true;
        }
    }

    /* renamed from: a */
    private boolean m12799a(int i, int i2, float f, List<Rect> list) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        List<Rect> list2 = list;
        Object[] objArr = {new Integer(i3), new Integer(i4), new Float(f2), list2};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        Object[] objArr2 = objArr;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, this, changeQuickRedirect2, false, 5446, new Class[]{Integer.TYPE, Integer.TYPE, Float.TYPE, List.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11725m;
        LogUtil.m15942a(aVar, " start calculateTapArea x:" + i3 + ",y:" + i4 + ",mOffsetY:" + this.f11768w + ",areaMultiple:" + f2 + ",mPreviewWidth:" + this.f11766u + ",mPreviewHeight:" + this.f11767v + ", crop:" + this.f11742Q);
        int i5 = i4 - this.f11768w;
        Rect rect = null;
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
            rect = m12797a(i3, i5, f2, list2.get(0));
            list.clear();
            list2.add(rect);
        } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && Build.VERSION.SDK_INT >= 23) {
            CameraControllerV2 cameraControllerV2 = (CameraControllerV2) CameraController.m8868g();
            Rect ai = cameraControllerV2.mo19567ai();
            Rect rect2 = new Rect(cameraControllerV2.mo19568aj());
            rect2.inset((int) ((this.f11742Q / 2.0f) * ((float) rect2.width())), (int) ((this.f11742Q / 2.0f) * ((float) rect2.height())));
            int i6 = this.f11766u;
            int i7 = this.f11767v;
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
            int i10 = i5 + ((i9 - this.f11767v) / 2);
            int a2 = CameraUtil.m15812a(((i8 - this.f11766u) / 2) + i3, 0, this.f11766u);
            float a3 = (float) CameraUtil.m15812a(i10, this.f11768w, this.f11767v + this.f11768w);
            rect = m12796a((float) a2, a3, i8, i9, f, rect2, ai);
            list.clear();
            list2.add(rect);
        }
        if (rect != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private Rect m12797a(int i, int i2, float f, Rect rect) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Float(f), rect};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5447, new Class[]{Integer.TYPE, Integer.TYPE, Float.TYPE, Rect.class}, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        int H = (int) (((float) m12791H()) * f);
        int i3 = H / 2;
        int a = CameraUtil.m15812a(i - i3, 0, this.f11766u - H);
        int a2 = CameraUtil.m15812a(i2 - i3, 0, this.f11767v - H);
        if (a == 0 && a2 == 0 && H == 0) {
            return null;
        }
        LogUtil.C2630a aVar = f11725m;
        LogUtil.m15942a(aVar, "areaSize:" + H + ",left:" + a + ",top:" + a2);
        RectF rectF = new RectF((float) a, (float) a2, (float) (a + H), (float) (a2 + H));
        this.f11765t.mapRect(rectF);
        CameraUtil.m15850a(rectF, rect);
        LogUtil.C2630a aVar2 = f11725m;
        LogUtil.m15942a(aVar2, "after calculateTapArea rect left:{" + rect.left + ",right:" + rect.right + ",top:" + rect.top + ",bottom:" + rect.bottom + "}");
        return rect;
    }

    /* renamed from: a */
    private Rect m12796a(float f, float f2, int i, int i2, float f3, Rect rect, Rect rect2) {
        float f4 = f;
        float f5 = f2;
        int i3 = i;
        int i4 = i2;
        float f6 = f3;
        Rect rect3 = rect;
        Object[] objArr = {new Float(f4), new Float(f5), new Integer(i3), new Integer(i4), new Float(f6), rect3, rect2};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        Class[] clsArr = {Float.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE, Rect.class, Rect.class};
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5448, clsArr, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        int max = (int) (((float) (Math.max(i, i2) / 8)) * f6);
        float f7 = (float) (max / 2);
        RectF rectF = new RectF(f4 - f7, f5 - f7, f4 + f7, f7 + f5);
        LogUtil.C2630a aVar = f11725m;
        LogUtil.m15942a(aVar, "start calculateTapAreaCamera2 after meteringRegionF rect left:{" + rectF.left + ",right:" + rectF.right + ",top:" + rectF.top + ",bottom:" + rectF.bottom + "}, x:" + f4 + ",y:" + f5 + ",side:" + max + ",width:" + i3 + ",height:" + i4 + ",originCropRegion.width():" + rect2.width() + ",originCropRegion.height():" + rect2.height() + "mDisplayOrientation:" + this.f11771z);
        Matrix matrix = new Matrix();
        CameraUtil.m15849a(matrix, this.f11769x, this.f11770y, this.f11771z, i, i2);
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
        LogUtil.C2630a aVar2 = f11725m;
        LogUtil.m15942a(aVar2, "end calculateTapAreaCamera2 after calculateTapArea rect left:{" + rect4.left + ",right:" + rect4.right + ",top:" + rect4.top + ",bottom:" + rect4.bottom + "}, x:" + f4 + ",y:" + f5);
        return rect4;
    }

    /* renamed from: H */
    private int m12791H() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5449, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : Math.max(this.f11766u, this.f11767v) / 8;
    }

    /* renamed from: l */
    public boolean mo21089l() {
        return this.f11759n == 1;
    }

    /* renamed from: m */
    public boolean mo21090m() {
        return this.f11759n == 2;
    }

    /* renamed from: n */
    public void mo21091n() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5450, new Class[0], Void.TYPE).isSupported) {
            this.f11732G.removeMessages(0);
            this.f11732G.removeMessages(1);
            this.f11732G.removeMessages(2);
        }
    }

    /* renamed from: a */
    public void mo21064a(CameraController.FocusMode focusMode) {
        this.f11730E = focusMode;
    }

    /* renamed from: f */
    public void mo21078f(boolean z) {
        this.f11764s = z;
    }

    /* renamed from: o */
    public boolean mo21092o() {
        return this.f11764s;
    }

    /* renamed from: I */
    private boolean m12792I() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5451, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        CameraController.FocusMode g = mo21079g();
        if (CameraController.FocusMode.INFINITY.equals(g) || CameraController.FocusMode.FIXED.equals(g) || CameraController.FocusMode.EDOF.equals(g)) {
            return false;
        }
        return true;
    }

    /* renamed from: p */
    public void mo21093p() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5452, new Class[0], Void.TYPE).isSupported && this.f11748b != null) {
            if (!CameraController.FlashMode.FLASH_MODE_OFF.equals(this.f11748b.mo18373X()) && !CameraController.FlashMode.FLASH_MODE_TORCH.equals(this.f11748b.mo18373X())) {
                this.f11737L = this.f11748b.mo18373X();
                this.f11748b.mo18391a(CameraController.FlashMode.FLASH_MODE_OFF);
            }
            m12788E();
            m12787D();
        }
    }

    /* renamed from: q */
    public void mo21094q() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5453, new Class[0], Void.TYPE).isSupported && this.f11759n == 1) {
            m12788E();
        }
    }

    /* renamed from: a */
    public void mo21063a(CameraController.FlashMode flashMode, boolean z) {
        if (PatchProxy.proxy(new Object[]{flashMode, new Byte(z ? (byte) 1 : 0)}, this, f11724a, false, 5454, new Class[]{CameraController.FlashMode.class, Boolean.TYPE}, Void.TYPE).isSupported || flashMode == null) {
            return;
        }
        if (z) {
            this.f11737L = flashMode;
        } else if (this.f11737L != null && !CameraController.FlashMode.FLASH_MODE_OFF.equals(flashMode) && !CameraController.FlashMode.FLASH_MODE_TORCH.equals(flashMode)) {
            this.f11737L = flashMode;
        }
    }

    /* renamed from: a */
    public void mo21068a(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f11724a, false, 5455, new Class[]{float[].class}, Void.TYPE).isSupported && this.f11743R && !this.f11740O) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f11745T > 200) {
                if (this.f11744S == null) {
                    this.f11744S = new float[3];
                    System.arraycopy(fArr, 0, this.f11744S, 0, 3);
                } else if (this.f11757k) {
                    this.f11757k = false;
                    System.arraycopy(fArr, 0, this.f11744S, 0, 3);
                } else {
                    int a = CameraUtil.m15815a(fArr, this.f11744S);
                    if (this.f11747V && a < 4 && currentTimeMillis - this.f11746U > 500) {
                        this.f11736K = false;
                        if (this.f11769x) {
                            this.f11732G.sendEmptyMessage(0);
                            this.f11743R = false;
                            this.f11747V = false;
                        } else if (this.f11755i) {
                            this.f11755i = false;
                            this.f11743R = false;
                            this.f11747V = false;
                            if (m12794K()) {
                                LogUtil.m15952c(f11725m, "shake detected , change to CAF after set Exposure value!!!");
                                this.f11732G.sendEmptyMessage(1);
                                mo21097t();
                            } else if (!DeviceHelper.f13839S) {
                                LogUtil.m15952c(f11725m, "shake detected , reset touch focus after set Exposure value!!!");
                                this.f11732G.sendEmptyMessage(0);
                            } else {
                                mo21093p();
                            }
                        } else if (!this.f11748b.mo18451az()) {
                            mo21093p();
                        } else if (!this.f11741P) {
                            this.f11743R = false;
                            this.f11747V = false;
                            LogUtil.m15952c(f11725m, "shake detected , change to CAF in video mode!!!");
                            this.f11732G.sendEmptyMessage(1);
                        }
                    }
                    if (!this.f11747V && a >= 6) {
                        this.f11747V = true;
                        this.f11746U = currentTimeMillis;
                        LogUtil.m15952c(f11725m, "shake detected !!!");
                    }
                    System.arraycopy(fArr, 0, this.f11744S, 0, 3);
                }
                this.f11745T = currentTimeMillis;
            }
        }
    }

    /* renamed from: J */
    private boolean m12793J() {
        boolean z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5456, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceHelper.f13841U || !CameraModeType.m10946a().equals(CameraModeType.ModeType.MANUAL)) {
            return false;
        }
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            z = this.f11748b.mo18448aw().equals(CameraController.FocusMode.MANUAL);
        } else {
            z = DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? this.f11748b.mo18448aw().equals(CameraController.FocusMode.FIXED) : false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* renamed from: K */
    private boolean m12794K() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5457, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13839S) {
            return false;
        }
        CameraController.FocusMode focusMode = CameraController.FocusMode.CONTINUOUS_PICTURE;
        if (this.f11748b.mo18448aw().equals(focusMode) && CameraUtil.m15861a(focusMode, CameraController.m8868g().mo19448Z())) {
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public boolean mo21095r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5458, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11759n != 2) {
            return false;
        }
        this.f11759n = 1;
        LogUtil.m15952c(f11725m, "cancelCaptureAfterFocused mState = STATE_FOCUSING");
        return true;
    }

    /* renamed from: g */
    public void mo21080g(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5459, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f11738M) {
                mo21087k();
            }
            this.f11738M = z;
        }
    }

    /* renamed from: h */
    public void mo21082h(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5460, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11748b.mo18443ar().mo21197h(z);
        }
    }

    /* renamed from: i */
    public void mo21084i(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11724a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5461, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11725m;
            LogUtil.m15942a(aVar, "set UI Block Shake Focus " + z);
            this.f11740O = z;
        }
    }

    /* renamed from: s */
    public boolean mo21096s() {
        return this.f11740O;
    }

    /* renamed from: t */
    public void mo21097t() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5462, new Class[0], Void.TYPE).isSupported) {
            this.f11748b.mo18443ar().mo21219t();
        }
    }

    /* renamed from: u */
    public void mo21098u() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5463, new Class[0], Void.TYPE).isSupported) {
            this.f11748b.mo18443ar().mo21170a(mo21100w());
        }
    }

    /* renamed from: v */
    public boolean mo21099v() {
        return this.f11756j;
    }

    /* renamed from: L */
    private void m12795L() {
        if (!PatchProxy.proxy(new Object[0], this, f11724a, false, 5464, new Class[0], Void.TYPE).isSupported) {
            if (this.f11731F == null || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2);
                return;
            }
            this.f11750d = (float) this.f11731F.getMaxExposureCompensation();
            this.f11751e = (float) this.f11731F.getMinExposureCompensation();
            this.f11749c = this.f11731F.getExposureCompensationStep();
        }
    }

    /* renamed from: w */
    public MzFocusRenderer.C2743b mo21100w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11724a, false, 5465, new Class[0], MzFocusRenderer.C2743b.class);
        if (proxy.isSupported) {
            return (MzFocusRenderer.C2743b) proxy.result;
        }
        if (this.f11758l == null) {
            this.f11758l = new MzFocusRenderer.C2743b() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11772a;

                /* renamed from: a */
                public void mo20248a(float f) {
                    if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f11772a, false, 5467, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
                        if (DeviceHelper.f13937bk == DeviceHelper.EXPOSURE_STEP.STANDARD) {
                            FocusOverlaySimplifyManager.this.f11752f = ((float) Math.round(((FocusOverlaySimplifyManager.this.f11750d * FocusOverlaySimplifyManager.this.f11749c) * f) * 10.0f)) / 10.0f;
                        } else {
                            int round = Math.round(((FocusOverlaySimplifyManager.this.f11750d * 10.0f) * f) / (FocusOverlaySimplifyManager.this.f11749c * 10.0f));
                            FocusOverlaySimplifyManager.this.f11752f = ((float) Math.round((FocusOverlaySimplifyManager.this.f11749c * ((float) round)) * 10.0f)) / 10.0f;
                        }
                        new AsyncTaskEx<Void, Void, Void>() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f11774a;

                            /* renamed from: a */
                            public Void mo17658a(Void... voidArr) {
                                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11774a, false, 5470, new Class[]{Void[].class}, Void.class);
                                if (proxy.isSupported) {
                                    return (Void) proxy.result;
                                }
                                if (FocusOverlaySimplifyManager.this.f11752f == FocusOverlaySimplifyManager.this.f11753g) {
                                    return null;
                                }
                                FocusOverlaySimplifyManager.this.f11754h = true;
                                FocusOverlaySimplifyManager.this.f11748b.mo18395a(String.valueOf(FocusOverlaySimplifyManager.this.f11752f), true);
                                FocusOverlaySimplifyManager.this.f11753g = FocusOverlaySimplifyManager.this.f11752f;
                                return null;
                            }
                        }.mo22610a(AsyncTaskEx.f13745s, (Params[]) new Void[0]);
                    }
                }

                /* renamed from: a */
                public void mo20247a() {
                    if (!PatchProxy.proxy(new Object[0], this, f11772a, false, 5468, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.m15952c(FocusOverlaySimplifyManager.f11725m, "onStartTrackingTouch!!!");
                        boolean unused = FocusOverlaySimplifyManager.this.f11743R = false;
                        FocusOverlaySimplifyManager.this.f11755i = false;
                        FocusOverlaySimplifyManager.this.f11757k = false;
                        FocusOverlaySimplifyManager.this.mo21091n();
                        boolean unused2 = FocusOverlaySimplifyManager.this.f11734I = false;
                        FocusOverlaySimplifyManager.this.f11748b.mo18363N();
                    }
                }

                /* renamed from: b */
                public void mo20249b() {
                    if (!PatchProxy.proxy(new Object[0], this, f11772a, false, 5469, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.m15952c(FocusOverlaySimplifyManager.f11725m, "onStopTrackingTouch!!!");
                        boolean unused = FocusOverlaySimplifyManager.this.f11743R = true;
                        FocusOverlaySimplifyManager.this.f11757k = true;
                        FocusOverlaySimplifyManager.this.f11755i = true;
                    }
                }
            };
        }
        return this.f11758l;
    }

    /* renamed from: x */
    public boolean mo21101x() {
        return this.f11749c <= 1.0f;
    }

    /* renamed from: j */
    public void mo21086j(boolean z) {
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11724a, false, 5466, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z || !mo21101x()) {
                z2 = false;
            }
            this.f11756j = z2;
            this.f11748b.mo18443ar().mo21195g(this.f11756j);
        }
    }

    /* renamed from: k */
    public void mo21088k(boolean z) {
        this.f11741P = z;
        if (z) {
            this.f11743R = false;
            this.f11747V = false;
        }
    }

    /* renamed from: a */
    public void mo21058a(float f) {
        this.f11742Q = f;
    }
}
