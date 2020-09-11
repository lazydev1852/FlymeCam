package com.meizu.media.camera.camcontroller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.portrait.DualcamMeta;
import com.meizu.media.camera.stereobokeh.MmsdkCallbackData;
import com.meizu.media.camera.stereobokeh.MmsdkCallbackImpl;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.List;

public abstract class CameraController<T extends CameraProxy> {

    /* renamed from: a */
    public static ChangeQuickRedirect f8273a;

    /* renamed from: f */
    protected static int f8274f;

    /* renamed from: g */
    protected static int f8275g;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static final LogUtil.C2630a f8276o = new LogUtil.C2630a("CameraController");

    /* renamed from: p */
    private static CameraController f8277p;

    /* renamed from: b */
    protected CameraApi f8278b = CameraApi.API1;

    /* renamed from: c */
    protected CameraController<T>.e f8279c;

    /* renamed from: d */
    protected Handler f8280d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    protected CameraOptTask.C1841a f8281e;

    /* renamed from: h */
    protected MmsdkCallbackData f8282h;

    /* renamed from: i */
    protected MmsdkCallbackImpl f8283i;

    /* renamed from: j */
    protected boolean f8284j = true;

    /* renamed from: k */
    protected final Object f8285k = new Object();

    /* renamed from: l */
    protected Context f8286l;

    /* renamed from: m */
    protected Point f8287m;

    /* renamed from: n */
    protected BurstCaptureState f8288n = BurstCaptureState.IDLE;

    public enum BurstCaptureState {
        BURST_CAPTURE_START,
        BURST_CAPTURE_STOP,
        IDLE;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum CameraApi {
        API1,
        API2;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$a */
    public interface C1874a {
        /* renamed from: a */
        void mo18311a(boolean z, CameraProxy dVar);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$b */
    public interface C1875b {
        /* renamed from: a */
        int mo19546a();

        /* renamed from: a */
        int mo19547a(DualcamMeta dualcamMeta);

        /* renamed from: a */
        int mo19548a(byte[] bArr);

        /* renamed from: a */
        void mo19549a(long j);

        /* renamed from: b */
        void mo19550b(long j);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$c */
    public interface C1876c {
        /* renamed from: a */
        void mo18556a(int i);

        /* renamed from: a */
        void mo18557a(Contants.AsdSceneType asdSceneType);

        /* renamed from: a */
        void mo18558a(boolean z);

        /* renamed from: a */
        boolean mo18559a();

        /* renamed from: b */
        void mo18560b();

        /* renamed from: b */
        void mo18561b(int i);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$d */
    public interface C1877d {
        /* renamed from: a */
        void mo19551a(Rect rect, float f);

        /* renamed from: a */
        void mo19552a(C1880f[] fVarArr, CameraProxy dVar);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$g */
    public static class C1881g extends RuntimeException {
    }

    /* renamed from: A */
    public abstract boolean mo19437A();

    /* renamed from: B */
    public abstract boolean mo19438B();

    /* renamed from: C */
    public abstract boolean mo19439C();

    /* renamed from: D */
    public abstract boolean mo19440D();

    /* renamed from: E */
    public abstract void mo19441E();

    /* renamed from: F */
    public abstract boolean mo19442F();

    /* renamed from: G */
    public abstract List<HashMap<Integer, Size>> mo19443G();

    /* renamed from: H */
    public abstract boolean mo19444H();

    /* renamed from: X */
    public abstract void mo19446X();

    /* renamed from: Y */
    public abstract HdrMode mo19447Y();

    /* renamed from: Z */
    public abstract List<FocusMode> mo19448Z();

    /* renamed from: a */
    public abstract Point mo19449a();

    /* renamed from: a */
    public abstract Point mo19450a(int i, int i2, boolean... zArr);

    /* renamed from: a */
    public abstract String mo19451a(int i, boolean... zArr) throws C1881g;

    /* renamed from: a */
    public abstract void mo19453a(Intent intent);

    /* renamed from: a */
    public abstract void mo19454a(SurfaceTexture surfaceTexture);

    /* renamed from: a */
    public abstract void mo19455a(Location location, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19456a(Handler handler, C1874a aVar);

    /* renamed from: a */
    public abstract void mo19457a(Handler handler, C1877d dVar);

    /* renamed from: a */
    public abstract void mo19458a(Surface surface, boolean z);

    /* renamed from: a */
    public abstract void mo19459a(MeizuCamera.MeizuMetaDataCallback meizuMetaDataCallback);

    /* renamed from: a */
    public abstract void mo19460a(MeizuCamera.MeizuModuleCoveredDetectionCallback meizuModuleCoveredDetectionCallback);

    /* renamed from: a */
    public abstract void mo19461a(MeizuCamera.MeizuSceneModeDetectionCallback meizuSceneModeDetectionCallback);

    /* renamed from: a */
    public abstract void mo19462a(MeizuCamera.MeizuSecureDetectionCallback meizuSecureDetectionCallback);

    /* renamed from: a */
    public void mo19463a(ParamData fVar) {
    }

    /* renamed from: a */
    public abstract void mo19465a(BurstCaptureState burstCaptureState);

    /* renamed from: a */
    public abstract void mo19466a(FlashMode flashMode, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19467a(FocusMode focusMode, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19468a(C1875b bVar);

    /* renamed from: a */
    public abstract void mo19469a(C1876c cVar);

    /* renamed from: a */
    public abstract void mo19470a(ComboPreferences eVar);

    /* renamed from: a */
    public abstract void mo19471a(String str, String str2, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19472a(String str, boolean z);

    /* renamed from: a */
    public abstract void mo19473a(String str, Object... objArr);

    /* renamed from: a */
    public abstract void mo19474a(String str, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19475a(boolean z);

    /* renamed from: a */
    public abstract void mo19476a(boolean z, List<Rect> list);

    /* renamed from: a */
    public abstract void mo19477a(boolean z, boolean... zArr);

    /* renamed from: a */
    public abstract void mo19478a(byte[] bArr);

    /* renamed from: a */
    public abstract void mo19479a(FileDescriptor[] fileDescriptorArr);

    /* renamed from: a */
    public abstract void mo19480a(boolean... zArr);

    /* renamed from: a */
    public abstract boolean mo19481a(int i);

    /* renamed from: a */
    public abstract boolean mo19482a(String str);

    /* renamed from: aa */
    public abstract FocusMode mo19483aa();

    /* renamed from: ab */
    public abstract boolean mo19484ab();

    /* renamed from: ac */
    public abstract Contants.AsdSceneType mo19485ac();

    /* renamed from: ad */
    public abstract boolean mo19486ad();

    /* renamed from: b */
    public abstract int mo19487b() throws C1881g;

    /* renamed from: b */
    public abstract void mo19488b(int i);

    /* renamed from: b */
    public abstract void mo19489b(int i, int i2, boolean... zArr);

    /* renamed from: b */
    public abstract void mo19490b(int i, boolean... zArr);

    /* renamed from: b */
    public abstract void mo19492b(Intent intent);

    /* renamed from: b */
    public abstract void mo19493b(String str);

    /* renamed from: b */
    public abstract void mo19494b(String str, String str2, boolean... zArr);

    /* renamed from: b */
    public abstract void mo19495b(String str, boolean... zArr);

    /* renamed from: b */
    public abstract void mo19496b(boolean z);

    /* renamed from: b */
    public abstract void mo19497b(boolean z, boolean... zArr);

    /* renamed from: c */
    public abstract int mo19498c() throws C1881g;

    /* renamed from: c */
    public abstract void mo19499c(int i);

    /* renamed from: c */
    public abstract void mo19500c(int i, int i2, boolean... zArr);

    /* renamed from: c */
    public abstract void mo19501c(int i, boolean... zArr);

    /* renamed from: c */
    public abstract void mo19502c(Intent intent);

    /* renamed from: c */
    public abstract void mo19503c(boolean z);

    /* renamed from: d */
    public abstract float mo19504d() throws C1881g;

    /* renamed from: d */
    public abstract int mo19505d(int i);

    /* renamed from: d */
    public abstract void mo19506d(int i, boolean... zArr);

    /* renamed from: d */
    public abstract void mo19507d(Intent intent);

    /* renamed from: d */
    public abstract void mo19508d(boolean z);

    /* renamed from: e */
    public abstract FocusMode mo19509e();

    /* renamed from: e */
    public abstract void mo19510e(Intent intent);

    /* renamed from: e */
    public abstract void mo19511e(boolean z);

    /* renamed from: f */
    public abstract int mo19512f();

    /* renamed from: f */
    public abstract void mo19513f(Intent intent);

    /* renamed from: f */
    public abstract void mo19514f(boolean z);

    /* renamed from: g */
    public abstract void mo19515g(Intent intent);

    /* renamed from: h */
    public abstract void mo19517h(Intent intent);

    /* renamed from: i */
    public abstract void mo19519i(Intent intent);

    /* renamed from: j */
    public abstract Point mo19520j();

    /* renamed from: j */
    public abstract void mo19521j(Intent intent);

    /* renamed from: k */
    public abstract T mo19522k();

    /* renamed from: k */
    public abstract void mo19523k(Intent intent);

    /* renamed from: l */
    public abstract Point mo19524l();

    /* renamed from: l */
    public void mo19525l(Intent intent) {
    }

    /* renamed from: m */
    public abstract int mo19526m();

    /* renamed from: m */
    public abstract void mo19527m(Intent intent);

    /* renamed from: n */
    public abstract Point mo19528n();

    /* renamed from: n */
    public abstract void mo19529n(Intent intent);

    /* renamed from: o */
    public abstract List<Point> mo19530o();

    /* renamed from: o */
    public abstract void mo19531o(Intent intent);

    /* renamed from: p */
    public abstract List<Point> mo19532p();

    /* renamed from: p */
    public abstract void mo19533p(Intent intent);

    /* renamed from: q */
    public abstract FlashMode mo19534q();

    /* renamed from: r */
    public abstract boolean mo19535r();

    /* renamed from: s */
    public abstract int mo19536s();

    /* renamed from: t */
    public abstract int mo19537t();

    /* renamed from: u */
    public abstract int mo19538u();

    /* renamed from: v */
    public abstract int mo19539v();

    /* renamed from: w */
    public abstract List<Integer> mo19540w();

    /* renamed from: x */
    public abstract boolean mo19541x();

    /* renamed from: y */
    public abstract void mo19542y();

    /* renamed from: z */
    public abstract boolean mo19543z();

    public enum FocusMode {
        AUTO("auto"),
        CONTINUOUS_PICTURE("continuous-picture"),
        CONTINUOUS_VIDEO("continuous-video"),
        INFINITY("infinity"),
        MACRO("macro"),
        EDOF("edof"),
        FIXED("fixed"),
        MANUAL("manual");
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private String mKey;

        private FocusMode(String str) {
            this.mKey = str;
        }

        public String getKey() {
            return this.mKey;
        }

        public static FocusMode convertFocusMode(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 2756, new Class[]{String.class}, FocusMode.class);
            if (proxy.isSupported) {
                return (FocusMode) proxy.result;
            }
            if (AUTO.getKey().equals(str)) {
                return AUTO;
            }
            if (CONTINUOUS_PICTURE.getKey().equals(str)) {
                return CONTINUOUS_PICTURE;
            }
            if (CONTINUOUS_VIDEO.getKey().equals(str)) {
                return CONTINUOUS_VIDEO;
            }
            if (INFINITY.getKey().equals(str)) {
                return INFINITY;
            }
            if (MACRO.getKey().equals(str)) {
                return MACRO;
            }
            if (EDOF.getKey().equals(str)) {
                return EDOF;
            }
            if (FIXED.getKey().equals(str)) {
                return FIXED;
            }
            if (MANUAL.getKey().equals(str)) {
                return MANUAL;
            }
            return null;
        }

        public static FocusMode focusModeFromInt(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 2757, new Class[]{Integer.TYPE}, FocusMode.class);
            if (proxy.isSupported) {
                return (FocusMode) proxy.result;
            }
            switch (i) {
                case 0:
                    return FIXED;
                case 1:
                    return AUTO;
                case 2:
                    return MACRO;
                case 3:
                    return CONTINUOUS_VIDEO;
                case 4:
                    return CONTINUOUS_PICTURE;
                case 5:
                    return EDOF;
                default:
                    LogUtil.C2630a ae = CameraController.f8276o;
                    LogUtil.m15956e(ae, "Unable to convert from API 2 focus mode: " + i);
                    return null;
            }
        }
    }

    public enum FlashMode {
        NO_FLASH("no_flash"),
        FLASH_MODE_OFF("off"),
        FLASH_MODE_TORCH("torch"),
        FLASH_MODE_AUTO("auto"),
        FLASH_MODE_ON("on"),
        FLASH_MODE_RED_EYE("red-eye");
        
        public static ChangeQuickRedirect changeQuickRedirect;
        public String key;
        private int mFrontPhotoIndex;
        private int mPhotoIndex;
        private int mVideoIndex;

        private FlashMode(String str) {
            this.key = str;
            init();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void init() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 2752(0xac0, float:3.856E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                java.lang.String r1 = r8.key
                int r2 = r1.hashCode()
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = -1
                switch(r2) {
                    case 3551: goto L_0x0057;
                    case 109935: goto L_0x004d;
                    case 3005871: goto L_0x0043;
                    case 110547964: goto L_0x0039;
                    case 981552114: goto L_0x002f;
                    case 1081542389: goto L_0x0025;
                    default: goto L_0x0024;
                }
            L_0x0024:
                goto L_0x0061
            L_0x0025:
                java.lang.String r2 = "red-eye"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 5
                goto L_0x0062
            L_0x002f:
                java.lang.String r2 = "no_flash"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 0
                goto L_0x0062
            L_0x0039:
                java.lang.String r2 = "torch"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 2
                goto L_0x0062
            L_0x0043:
                java.lang.String r2 = "auto"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 3
                goto L_0x0062
            L_0x004d:
                java.lang.String r2 = "off"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 1
                goto L_0x0062
            L_0x0057:
                java.lang.String r2 = "on"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0061
                r1 = 4
                goto L_0x0062
            L_0x0061:
                r1 = -1
            L_0x0062:
                switch(r1) {
                    case 0: goto L_0x00a6;
                    case 1: goto L_0x009f;
                    case 2: goto L_0x0090;
                    case 3: goto L_0x0080;
                    case 4: goto L_0x006d;
                    case 5: goto L_0x0066;
                    default: goto L_0x0065;
                }
            L_0x0065:
                goto L_0x00ac
            L_0x0066:
                r8.mPhotoIndex = r3
                r8.mVideoIndex = r7
                r8.mFrontPhotoIndex = r7
                goto L_0x00ac
            L_0x006d:
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
                if (r1 != r2) goto L_0x0074
                r4 = 2
            L_0x0074:
                r8.mPhotoIndex = r4
                boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13888ao
                if (r1 == 0) goto L_0x007b
                r0 = 2
            L_0x007b:
                r8.mFrontPhotoIndex = r0
                r8.mVideoIndex = r7
                goto L_0x00ac
            L_0x0080:
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
                if (r0 != r1) goto L_0x0087
                r5 = 1
            L_0x0087:
                r8.mPhotoIndex = r5
                r8.mVideoIndex = r7
                boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13888ao
                r8.mFrontPhotoIndex = r0
                goto L_0x00ac
            L_0x0090:
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
                if (r1 != r2) goto L_0x0097
                goto L_0x0098
            L_0x0097:
                r4 = 1
            L_0x0098:
                r8.mPhotoIndex = r4
                r8.mVideoIndex = r6
                r8.mFrontPhotoIndex = r0
                goto L_0x00ac
            L_0x009f:
                r8.mPhotoIndex = r0
                r8.mVideoIndex = r0
                r8.mFrontPhotoIndex = r0
                goto L_0x00ac
            L_0x00a6:
                r8.mPhotoIndex = r7
                r8.mVideoIndex = r7
                r8.mFrontPhotoIndex = r7
            L_0x00ac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraController.FlashMode.init():void");
        }

        public int getIndex(boolean z, boolean... zArr) {
            boolean z2 = false;
            if (zArr != null && zArr.length == 1) {
                z2 = zArr[0];
            }
            if (z) {
                return this.mVideoIndex;
            }
            return z2 ? this.mFrontPhotoIndex : this.mPhotoIndex;
        }

        public static FlashMode convertFlashMode(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 2753, new Class[]{String.class}, FlashMode.class);
            if (proxy.isSupported) {
                return (FlashMode) proxy.result;
            }
            if (FLASH_MODE_AUTO.key.equals(str)) {
                return FLASH_MODE_AUTO;
            }
            if (FLASH_MODE_ON.key.equals(str)) {
                return FLASH_MODE_ON;
            }
            if (FLASH_MODE_OFF.key.equals(str)) {
                return FLASH_MODE_OFF;
            }
            if (FLASH_MODE_TORCH.key.equals(str)) {
                return FLASH_MODE_TORCH;
            }
            if (FLASH_MODE_RED_EYE.key.equals(str)) {
                return FLASH_MODE_RED_EYE;
            }
            if (NO_FLASH.key.equals(str)) {
                return NO_FLASH;
            }
            return FLASH_MODE_OFF;
        }
    }

    public enum HdrMode {
        ON,
        OFF,
        AUTO;
        
        public static ChangeQuickRedirect changeQuickRedirect;

        public static HdrMode convertHdrMode(int i) {
            if (i == 1) {
                return ON;
            }
            if (i == 2) {
                return AUTO;
            }
            return OFF;
        }

        public static int convertInt(HdrMode hdrMode) {
            if (hdrMode == ON) {
                return 1;
            }
            return hdrMode == AUTO ? 2 : 0;
        }
    }

    /* renamed from: a */
    public void mo19464a(CameraOptTask.C1841a aVar) {
        this.f8281e = aVar;
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$f */
    public static abstract class C1880f<T> {

        /* renamed from: a */
        protected T f8295a;

        /* renamed from: b */
        protected boolean f8296b = false;

        /* renamed from: c */
        protected int f8297c;

        /* renamed from: a */
        public abstract int mo19555a();

        /* renamed from: b */
        public abstract Rect mo19557b();

        public C1880f(T t) {
            this.f8295a = t;
        }

        /* renamed from: c */
        public void mo19558c() {
            this.f8296b = true;
        }

        /* renamed from: d */
        public boolean mo19559d() {
            return this.f8296b;
        }

        /* renamed from: e */
        public int mo19560e() {
            return this.f8297c;
        }

        /* renamed from: a */
        public void mo19556a(int i) {
            this.f8297c = i;
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.CameraController$e */
    public class C1878e extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f8290a;

        public C1878e(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public boolean mo19553a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8290a, false, 2748, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            final Object obj = new Object();
            C18791 r2 = new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8292a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8292a, false, 2749, new Class[0], Void.TYPE).isSupported) {
                        synchronized (obj) {
                            obj.notifyAll();
                            LogUtil.m15952c(CameraController.f8276o, "waitDone");
                        }
                    }
                }
            };
            synchronized (obj) {
                CameraController.this.f8279c.post(r2);
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                    LogUtil.m15949b(CameraController.f8276o, "waitDone interrupted");
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: g */
    public static CameraController m8868g() {
        return f8277p;
    }

    /* renamed from: a */
    public static void m8866a(CameraController cameraController) {
        f8277p = cameraController;
    }

    public CameraController() {
        HandlerThread handlerThread = new HandlerThread("MzCamera-Thread");
        handlerThread.start();
        this.f8279c = new C1878e(handlerThread.getLooper());
    }

    /* renamed from: a */
    public void mo19452a(Context context) {
        this.f8286l = context;
    }

    /* renamed from: h */
    public CameraApi mo19516h() {
        return this.f8278b;
    }

    /* renamed from: i */
    public CameraController<T>.e mo19518i() {
        return this.f8279c;
    }

    /* renamed from: I */
    public static boolean m8852I() {
        return f8274f > 0;
    }

    /* renamed from: J */
    public static boolean m8853J() {
        return f8275g > 8;
    }

    /* renamed from: K */
    public static boolean m8854K() {
        return f8275g > 9;
    }

    /* renamed from: L */
    public static boolean m8855L() {
        return f8275g > 4;
    }

    /* renamed from: M */
    public static boolean m8856M() {
        return f8275g > 4;
    }

    /* renamed from: N */
    public static boolean m8857N() {
        return f8275g > 0;
    }

    /* renamed from: O */
    public static void m8858O() {
        f8275g--;
    }

    /* renamed from: P */
    public static int m8859P() {
        return f8274f;
    }

    /* renamed from: Q */
    public static int m8860Q() {
        return f8275g;
    }

    /* renamed from: R */
    public static void m8861R() {
        f8275g = 0;
    }

    /* renamed from: S */
    public static void m8862S() {
        f8274f = 0;
    }

    /* renamed from: T */
    public static void m8863T() {
        f8275g++;
    }

    /* renamed from: U */
    public static void m8864U() {
        f8274f++;
    }

    /* renamed from: V */
    public static int m8865V() {
        if (DeviceHelper.f13910bJ == CameraApi.API1) {
            return CameraProxyV1.f9121e;
        }
        return CameraProxyV2.f9121e;
    }

    /* renamed from: b */
    public void mo19491b(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f8273a, false, 2742, new Class[]{Context.class}, Void.TYPE).isSupported && this.f8282h == null && this.f8283i == null) {
            LogUtil.m15942a(f8276o, "initMmSdkCallback");
            this.f8282h = new MmsdkCallbackData();
            this.f8283i = new MmsdkCallbackImpl(context);
            this.f8283i.mo21454a();
        }
    }

    /* renamed from: W */
    public void mo19445W() {
        if (!PatchProxy.proxy(new Object[0], this, f8273a, false, 2743, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f8285k) {
                LogUtil.C2630a aVar = f8276o;
                LogUtil.m15942a(aVar, "releaseMmSdkCallback, Stereo task num = " + this.f8281e.mo19059e().size());
                if (!(this.f8282h == null || this.f8283i == null || this.f8281e.mo19059e().peek() != null)) {
                    this.f8283i.mo21456b();
                    this.f8282h.mo21445a();
                    this.f8282h = null;
                    this.f8283i = null;
                    this.f8284j = true;
                }
            }
        }
    }
}
