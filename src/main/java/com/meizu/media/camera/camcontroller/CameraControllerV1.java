package com.meizu.media.camera.camcontroller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.accessor.StereoInfoAccessor;
import com.mediatek.mmsdk.BaseParameters;
import com.mediatek.view.impl.ViewDebugManagerImpl;
import com.meizu.camera.MeizuCamera;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.Exif;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraControllerV1;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.p064a.FaceBeautyData;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p067d.Rational;
import com.meizu.media.camera.p068e.AlorgrithmManager;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.cameraAlgorithm.fbmodecomponent.AlorgrithmUtil;
import com.meizu.media.cameraAlgorithm.yuv.YuvUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.meizu.media.camera.camcontroller.b */
public class CameraControllerV1 extends CameraController<CameraProxyV1> {

    /* renamed from: C */
    private static Class<?> f8703C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public static Method f8704D;

    /* renamed from: F */
    private static Class<?> f8705F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public static Method f8706G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public static Method f8707H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public static Method f8708I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public static Method f8709J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public static Method f8710K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public static Method f8711L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public static Method f8712M;

    /* renamed from: O */
    private static Method f8713O;

    /* renamed from: P */
    private static Method f8714P;

    /* renamed from: Q */
    private static Method f8715Q;

    /* renamed from: R */
    private static Method f8716R;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public static Method f8717ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public static Method f8718al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public static Method f8719am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public static Method f8720an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public static Method f8721ao;

    /* renamed from: ap */
    private static Method f8722ap;

    /* renamed from: aq */
    private static Method f8723aq;

    /* renamed from: ar */
    private static Method f8724ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public static Method f8725as;

    /* renamed from: av */
    private static byte[] f8726av;

    /* renamed from: o */
    public static ChangeQuickRedirect f8727o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static final LogUtil.C2630a f8728p = new LogUtil.C2630a("CameraCtlV1");

    /* renamed from: r */
    private static CameraController f8729r;

    /* renamed from: s */
    private static final ArrayList<String> f8730s = new ArrayList<>();

    /* renamed from: A */
    private boolean f8731A;

    /* renamed from: B */
    private boolean f8732B;

    /* renamed from: E */
    private Object f8733E;

    /* renamed from: N */
    private Object f8734N;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public byte[] f8735S;

    /* renamed from: T */
    private byte[] f8736T;

    /* renamed from: U */
    private byte[] f8737U;

    /* renamed from: V */
    private byte[] f8738V;

    /* renamed from: W */
    private byte[] f8739W;

    /* renamed from: X */
    private byte[] f8740X;

    /* renamed from: Y */
    private byte[] f8741Y;

    /* renamed from: Z */
    private byte[] f8742Z;

    /* renamed from: aA */
    private int f8743aA;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public boolean f8744aB = false;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public Camera.ShutterCallback f8745aC = $$Lambda$b$wR510rLbG5IhyNbiTtPddHJ1Y.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public Camera.PictureCallback f8746aD = new Camera.PictureCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f8777a;

        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f8777a, false, 2875, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(CameraControllerV1.f8728p, "RawCallback onPictureTaken()");
                if (CameraControllerV1.this.f8751aI != null && CameraControllerV1.this.f8281e != null && CameraControllerV1.this.f8281e.mo19058d() != null) {
                    CameraControllerV1.this.f8281e.mo19058d().removeCallbacks(CameraControllerV1.this.f8751aI);
                    CameraControllerV1.this.f8281e.mo19043a((Object) CameraControllerV1.this.f8751aI);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public Camera.PictureCallback f8747aE = $$Lambda$b$R9w7SJ7rOHE7WegnylmuopV9pQ.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: aF */
    public Camera.PictureCallback f8748aF = $$Lambda$b$P73uz1owr_K5K2IBGBSPBDBDM10.INSTANCE;

    /* renamed from: aG */
    private C2006l f8749aG;

    /* renamed from: aH */
    private int f8750aH = 0;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public C1993d f8751aI;

    /* renamed from: aJ */
    private Camera.PreviewCallback f8752aJ = new Camera.PreviewCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f8904a;

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f8904a, false, 2923, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported && CameraControllerV1.this.f8284j) {
                CameraControllerV1.this.m9423aD();
                CameraControllerV1.this.f8284j = false;
            }
        }
    };

    /* renamed from: aa */
    private byte[] f8753aa;

    /* renamed from: ab */
    private StereoInfoAccessor f8754ab;

    /* renamed from: ac */
    private Class<?> f8755ac;

    /* renamed from: ad */
    private Class<?> f8756ad;

    /* renamed from: ae */
    private Class<?> f8757ae;

    /* renamed from: af */
    private Class<?> f8758af;
    /* access modifiers changed from: private */

    /* renamed from: ag */
    public Object f8759ag;

    /* renamed from: ah */
    private Object f8760ah;

    /* renamed from: ai */
    private Object f8761ai;

    /* renamed from: aj */
    private Object f8762aj;

    /* renamed from: at */
    private byte[] f8763at;

    /* renamed from: au */
    private byte[] f8764au;

    /* renamed from: aw */
    private byte[] f8765aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public byte[][] f8766ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public int f8767ay = 0;
    /* access modifiers changed from: private */

    /* renamed from: az */
    public float[] f8768az = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CameraProxyV1 f8769q;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Queue<C1997g> f8770t = new LinkedBlockingQueue();
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f8771u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f8772v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f8773w;

    /* renamed from: x */
    private boolean f8774x;

    /* renamed from: y */
    private boolean f8775y;

    /* renamed from: z */
    private boolean f8776z;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m9416a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: F */
    public boolean mo19442F() {
        return false;
    }

    /* renamed from: G */
    public List<HashMap<Integer, Size>> mo19443G() {
        return null;
    }

    /* renamed from: a */
    public void mo19468a(CameraController.C1875b bVar) {
    }

    /* renamed from: a */
    public void mo19469a(CameraController.C1876c cVar) {
    }

    /* renamed from: a */
    public void mo19472a(String str, boolean z) {
    }

    /* renamed from: a */
    public void mo19478a(byte[] bArr) {
    }

    /* renamed from: ab */
    public boolean mo19484ab() {
        return false;
    }

    /* renamed from: ad */
    public boolean mo19486ad() {
        return false;
    }

    /* renamed from: b */
    public void mo19493b(String str) {
    }

    /* renamed from: c */
    public void mo19499c(int i) {
    }

    /* renamed from: c */
    public void mo19503c(boolean z) {
    }

    /* renamed from: d */
    public void mo19508d(boolean z) {
    }

    /* renamed from: e */
    public void mo19511e(boolean z) {
    }

    /* renamed from: f */
    public void mo19514f(boolean z) {
    }

    /* renamed from: o */
    static /* synthetic */ int m9485o(CameraControllerV1 bVar) {
        int i = bVar.f8743aA;
        bVar.f8743aA = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: aE */
    public static /* synthetic */ void m9424aE() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f8727o, true, 2874, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "ShutterCallback onShutter()");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m9448b(byte[] bArr, Camera camera) {
        if (!PatchProxy.proxy(new Object[]{bArr, camera}, (Object) null, f8727o, true, 2873, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "PostViewCallback onPictureTaken()");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m9415a(byte[] bArr, Camera camera) {
        if (!PatchProxy.proxy(new Object[]{bArr, camera}, (Object) null, f8727o, true, 2872, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "JpegCallback onPictureTaken()");
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$b */
    /* compiled from: CameraControllerV1 */
    private class C1991b implements MeizuCamera.MeizuCameraContinuousCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f8944a;

        /* renamed from: c */
        private UUID f8946c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f8947d;

        public C1991b(UUID uuid, Contants.CameraService.RequestCode requestCode) {
            this.f8946c = uuid;
            this.f8947d = requestCode;
        }

        public void onContinuousNotify(int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f8944a, false, 2931, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                if (CameraControllerV1.this.m9416a(i2, 16)) {
                    if (CameraController.f8274f > 0) {
                        CameraController.f8274f--;
                    }
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                        CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                    }
                    boolean unused = CameraControllerV1.this.f8771u = false;
                }
                LogUtil.m15952c(CameraControllerV1.f8728p, "deliver callback RESULT_ON_BURST_CAPTURE_FINISHED");
                CameraControllerV1.this.f8281e.mo19045a(this.f8946c, this.f8947d, Contants.CameraService.ResultCode.RESULT_ON_BURST_CAPTURE_FINISHED, Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$e */
    /* compiled from: CameraControllerV1 */
    private static class C1994e implements Camera.FaceDetectionListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f8954a;

        /* renamed from: b */
        private final Handler f8955b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final CameraController.C1877d f8956c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final CameraProxy f8957d;

        /* renamed from: a */
        public static C1994e m9595a(Handler handler, CameraProxy dVar, CameraController.C1877d dVar2) {
            ChangeQuickRedirect changeQuickRedirect = f8954a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{handler, dVar, dVar2}, (Object) null, changeQuickRedirect, true, 2934, new Class[]{Handler.class, CameraProxy.class, CameraController.C1877d.class}, C1994e.class);
            if (proxy.isSupported) {
                return (C1994e) proxy.result;
            }
            if (handler == null || dVar == null || dVar2 == null) {
                return null;
            }
            return new C1994e(handler, dVar, dVar2);
        }

        private C1994e(Handler handler, CameraProxy dVar, CameraController.C1877d dVar2) {
            this.f8955b = handler;
            this.f8957d = dVar;
            this.f8956c = dVar2;
        }

        public void onFaceDetection(final Camera.Face[] faceArr, Camera camera) {
            Class[] clsArr = {Camera.Face[].class, Camera.class};
            if (!PatchProxy.proxy(new Object[]{faceArr, camera}, this, f8954a, false, 2935, clsArr, Void.TYPE).isSupported) {
                this.f8955b.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8958a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8958a, false, 2936, new Class[0], Void.TYPE).isSupported && faceArr != null) {
                            CameraController.C1880f[] fVarArr = new CameraController.C1880f[faceArr.length];
                            for (int i = 0; i < faceArr.length; i++) {
                                fVarArr[i] = new C1996f(faceArr[i]);
                            }
                            C1994e.this.f8956c.mo19552a(fVarArr, C1994e.this.f8957d);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$a */
    /* compiled from: CameraControllerV1 */
    private static class C1989a implements Camera.AutoFocusMoveCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f8937a;

        /* renamed from: b */
        private final Handler f8938b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final CameraController.C1874a f8939c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final CameraProxy f8940d;

        /* renamed from: a */
        public static C1989a m9592a(Handler handler, CameraProxy dVar, CameraController.C1874a aVar) {
            ChangeQuickRedirect changeQuickRedirect = f8937a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{handler, dVar, aVar}, (Object) null, changeQuickRedirect, true, 2928, new Class[]{Handler.class, CameraProxy.class, CameraController.C1874a.class}, C1989a.class);
            if (proxy.isSupported) {
                return (C1989a) proxy.result;
            }
            if (handler == null || dVar == null || aVar == null) {
                return null;
            }
            return new C1989a(handler, dVar, aVar);
        }

        private C1989a(Handler handler, CameraProxy dVar, CameraController.C1874a aVar) {
            this.f8938b = handler;
            this.f8940d = dVar;
            this.f8939c = aVar;
        }

        public void onAutoFocusMoving(final boolean z, Camera camera) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0), camera};
            ChangeQuickRedirect changeQuickRedirect = f8937a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2929, new Class[]{Boolean.TYPE, Camera.class}, Void.TYPE).isSupported) {
                this.f8938b.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8941a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8941a, false, 2930, new Class[0], Void.TYPE).isSupported) {
                            C1989a.this.f8939c.mo18311a(z, C1989a.this.f8940d);
                        }
                    }
                });
            }
        }
    }

    private CameraControllerV1() {
        this.f8278b = CameraController.CameraApi.API1;
    }

    /* renamed from: a */
    public Point mo19449a() {
        Camera.Size previewSize;
        int i;
        int i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2761, new Class[0], Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        boolean z = true;
        if (DeviceHelper.f13872aY && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
            if (this.f8769q == null) {
                return null;
            }
            Camera.Size pictureSize = this.f8769q.mo19740f().getPictureSize();
            return new Point(pictureSize.width, pictureSize.height);
        } else if (this.f8769q == null || (previewSize = this.f8769q.mo19740f().getPreviewSize()) == null) {
            return null;
        } else {
            float f = ((float) previewSize.width) / ((float) previewSize.height);
            if (((double) Math.abs(f - 1.3333334f)) >= 0.01d) {
                z = false;
            }
            if (CameraUtil.m15829a(f) == CameraUtil.ScreeAspectRatio.Ratio_18_9) {
                i2 = DeviceHelper.f13923bW;
                i = DeviceHelper.f13924bX;
            } else {
                i2 = z ? DeviceHelper.f13919bS : DeviceHelper.f13921bU;
                i = z ? DeviceHelper.f13920bT : DeviceHelper.f13922bV;
            }
            mo19500c(i2, i, new boolean[0]);
            return new Point(i2, i);
        }
    }

    /* renamed from: a */
    public String mo19451a(int i, boolean... zArr) throws CameraController.C1881g {
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2762, new Class[]{Integer.TYPE, boolean[].class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f8769q != null) {
            switch (i) {
                case 1:
                    return this.f8769q.mo19740f().get(ManualMode.f10869c);
                case 2:
                    return this.f8769q.mo19740f().get(ManualMode.f10870d);
                case 5:
                    return this.f8769q.mo19740f().get(ManualMode.f10873g);
                case 6:
                    return this.f8769q.mo19740f().get(ManualMode.f10874l);
                default:
                    return null;
            }
        } else {
            throw new CameraController.C1881g();
        }
    }

    /* renamed from: b */
    public int mo19487b() throws CameraController.C1881g {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2763, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getMaxExposureCompensation();
        }
        throw new CameraController.C1881g();
    }

    /* renamed from: c */
    public int mo19498c() throws CameraController.C1881g {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2764, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getMinExposureCompensation();
        }
        throw new CameraController.C1881g();
    }

    /* renamed from: d */
    public float mo19504d() throws CameraController.C1881g {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2765, new Class[0], Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getExposureCompensationStep();
        }
        throw new CameraController.C1881g();
    }

    /* renamed from: a */
    public void mo19470a(ComboPreferences eVar) {
        if (!PatchProxy.proxy(new Object[]{eVar}, this, f8727o, false, 2766, new Class[]{ComboPreferences.class}, Void.TYPE).isSupported) {
            try {
                String string = eVar.getString("mz_pref_iso_key", "auto");
                if (CameraUtil.m15863a(string, CameraUtil.m15836a(mo19451a(2, new boolean[0])))) {
                    mo19471a(MzCamParamsManager.f10483h, string, new boolean[0]);
                }
                String string2 = eVar.getString("mz_pref_shutterspeed_key", "auto");
                if (CameraUtil.m15863a(string2, CameraUtil.m15836a(mo19451a(1, new boolean[0])))) {
                    mo19471a(MzCamParamsManager.f10484i, string2, new boolean[0]);
                }
                String string3 = eVar.getString("pref_camera_whitebalance_key", "auto");
                if (CameraUtil.m15864a(string3, mo19656b(new boolean[0]))) {
                    CameraController.m8868g().mo19495b(string3, new boolean[0]);
                }
            } catch (CameraController.C1881g e) {
                LogUtil.m15949b(f8728p, e.toString());
            }
        }
    }

    /* renamed from: af */
    public static CameraController m9425af() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f8727o, true, 2767, new Class[0], CameraController.class);
        if (proxy.isSupported) {
            return (CameraController) proxy.result;
        }
        if (f8729r == null) {
            f8729r = new CameraControllerV1();
        }
        return f8729r;
    }

    /* renamed from: j */
    public Point mo19520j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2768, new Class[0], Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        Point[] pointArr = new Point[1];
        if (this.f8769q != null) {
            Camera.Size pictureSize = this.f8769q.mo19740f().getPictureSize();
            pointArr[0] = new Point(pictureSize.width, pictureSize.height);
        } else {
            pointArr[0] = null;
        }
        return pointArr[0];
    }

    /* renamed from: n */
    public Point mo19528n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2769, new Class[0], Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        Point[] pointArr = new Point[1];
        if (this.f8769q != null) {
            Camera.Size previewSize = this.f8769q.mo19740f().getPreviewSize();
            pointArr[0] = new Point(previewSize.width, previewSize.height);
        } else {
            pointArr[0] = null;
        }
        return pointArr[0];
    }

    /* renamed from: c */
    public void mo19500c(int i, int i2, boolean... zArr) {
        Object[] objArr = {new Integer(i), new Integer(i2), zArr};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2770, new Class[]{Integer.TYPE, Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setPictureSize(i, i2);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setPictureSize at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8791a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8791a, false, 2886, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: o */
    public List<Point> mo19530o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2771, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f8769q != null) {
            List<Camera.Size> supportedPictureSizes = this.f8769q.mo19740f().getSupportedPictureSizes();
            if (supportedPictureSizes != null) {
                for (Camera.Size next : supportedPictureSizes) {
                    arrayList.add(new Point(next.width, next.height));
                }
            } else {
                LogUtil.m15949b(f8728p, "support picture sizes are null");
                m9409a(new RuntimeException("getSupportedPictureSizes null"));
            }
        }
        return arrayList;
    }

    /* renamed from: p */
    public List<Point> mo19532p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2772, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f8769q != null) {
            List<Camera.Size> supportedPreviewSizes = this.f8769q.mo19740f().getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                for (Camera.Size next : supportedPreviewSizes) {
                    arrayList.add(new Point(next.width, next.height));
                }
            } else {
                LogUtil.m15949b(f8728p, "support preview sizes are null");
                m9409a(new RuntimeException("getSupportedPreviewSizes null"));
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    public CameraController.FlashMode mo19534q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2774, new Class[0], CameraController.FlashMode.class);
        if (proxy.isSupported) {
            return (CameraController.FlashMode) proxy.result;
        }
        if (this.f8769q != null) {
            return CameraController.FlashMode.convertFlashMode(this.f8769q.mo19740f().getFlashMode());
        }
        return CameraController.FlashMode.FLASH_MODE_OFF;
    }

    /* renamed from: r */
    public boolean mo19535r() {
        return this.f8772v;
    }

    /* renamed from: b */
    public void mo19496b(boolean z) {
        this.f8772v = z;
    }

    /* renamed from: a */
    public void mo19466a(CameraController.FlashMode flashMode, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{flashMode, zArr}, this, f8727o, false, 2775, new Class[]{CameraController.FlashMode.class, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        Camera.Parameters f = this.f8769q.mo19740f();
                        if (CameraUtil.m15864a(flashMode.key, f.getSupportedFlashModes())) {
                            if (CameraController.FlashMode.FLASH_MODE_TORCH.key.equals(f.getFlashMode()) && flashMode == CameraController.FlashMode.FLASH_MODE_AUTO) {
                                f.setFlashMode(CameraController.FlashMode.FLASH_MODE_OFF.key);
                                if (this.f8769q != null) {
                                    this.f8769q.mo19742h();
                                }
                            }
                            f.setFlashMode(flashMode.key);
                            LogUtil.C2630a aVar = f8728p;
                            LogUtil.m15952c(aVar, "setFlashMode(" + flashMode.key + ")");
                        }
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setFlashMode at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8825a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8825a, false, 2897, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: a */
    public boolean mo19482a(String str) {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8727o, false, 2776, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            if (this.f8769q != null) {
                boolean equals = "on".equals(this.f8769q.mo19740f().get(str));
                try {
                    LogUtil.C2630a aVar = f8728p;
                    LogUtil.m15952c(aVar, "get zsl/zsd: " + equals);
                    return equals;
                } catch (RuntimeException e) {
                    e = e;
                    z = equals;
                    LogUtil.m15942a(f8728p, "setZsl at a wrong time!");
                    e.printStackTrace();
                    return z;
                }
            }
        } catch (RuntimeException e2) {
            e = e2;
            LogUtil.m15942a(f8728p, "setZsl at a wrong time!");
            e.printStackTrace();
            return z;
        }
        return z;
    }

    /* renamed from: b */
    public void mo19494b(String str, String str2, boolean... zArr) {
        Class[] clsArr = {String.class, String.class, boolean[].class};
        if (!PatchProxy.proxy(new Object[]{str, str2, zArr}, this, f8727o, false, 2777, clsArr, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().set(str, str2);
                        LogUtil.C2630a aVar = f8728p;
                        LogUtil.m15952c(aVar, "set zsl/zsd: " + str2);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setZsl at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8874a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8874a, false, 2909, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: s */
    public int mo19536s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2778, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getMaxNumDetectedFaces();
        }
        return 0;
    }

    /* renamed from: d */
    public void mo19506d(int i, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), zArr}, this, f8727o, false, 2780, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setPreviewFrameRate(i);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setPreviewFrameRate at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8906a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8906a, false, 2924, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: t */
    public int mo19537t() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2781, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getPreviewFrameRate();
        }
        return -1;
    }

    /* renamed from: u */
    public int mo19538u() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2782, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getZoom();
        }
        return -1;
    }

    /* renamed from: v */
    public int mo19539v() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2783, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getMaxZoom();
        }
        return -1;
    }

    /* renamed from: w */
    public List<Integer> mo19540w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2784, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f8769q == null) {
            return null;
        }
        Camera.Parameters f = this.f8769q.mo19740f();
        List<Integer> zoomRatios = f.getZoomRatios();
        StringBuilder sb = new StringBuilder();
        for (Integer num : zoomRatios) {
            sb.append(num.toString());
            sb.append(SystemInfoUtil.COMMA);
        }
        LogUtil.C2630a aVar = f8728p;
        LogUtil.m15942a(aVar, "getZoomRatios :" + sb);
        return f.getZoomRatios();
    }

    /* renamed from: x */
    public boolean mo19541x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2785, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().isZoomSupported();
        }
        return false;
    }

    /* renamed from: ag */
    public CameraProxyV1 mo19522k() {
        return this.f8769q;
    }

    /* renamed from: b */
    public void mo19492b(Intent intent) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2786, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8728p, "openCamera");
            final UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            final Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            CameraModeType.ModeType modeType = (CameraModeType.ModeType) intent.getSerializableExtra("modeType");
            boolean booleanExtra = intent.getBooleanExtra("stereoOn", false);
            final boolean booleanExtra2 = intent.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false);
            final int intExtra = intent.getIntExtra("cameraId", 0);
            if (intExtra != 0) {
                z = false;
            }
            m9408a(modeType, booleanExtra, z);
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8908a;

                /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A[SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        r0 = 0
                        java.lang.Object[] r1 = new java.lang.Object[r0]
                        com.meizu.savior.ChangeQuickRedirect r3 = f8908a
                        java.lang.Class[] r6 = new java.lang.Class[r0]
                        java.lang.Class r7 = java.lang.Void.TYPE
                        r4 = 0
                        r5 = 2925(0xb6d, float:4.099E-42)
                        r2 = r10
                        com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                        boolean r1 = r1.isSupported
                        if (r1 == 0) goto L_0x0016
                        return
                    L_0x0016:
                        r1 = 0
                    L_0x0017:
                        com.meizu.media.camera.camcontroller.b r2 = com.meizu.media.camera.camcontroller.CameraControllerV1.this
                        com.meizu.media.camera.camcontroller.e r2 = r2.f8769q
                        if (r2 != 0) goto L_0x00b8
                        int r2 = r1 + 1
                        r3 = 10
                        if (r1 >= r3) goto L_0x00b8
                        r1 = 0
                        java.lang.String r4 = "startUp"
                        java.lang.String r5 = "openCamera"
                        com.meizu.media.camera.util.TimingLoggerUtil.m16032a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x004f }
                        int r4 = r4     // Catch:{ Exception -> 0x004f }
                        android.hardware.Camera r4 = android.hardware.Camera.open(r4)     // Catch:{ Exception -> 0x004f }
                        if (r4 == 0) goto L_0x00a1
                        com.meizu.media.camera.camcontroller.b$c r5 = new com.meizu.media.camera.camcontroller.b$c     // Catch:{ Exception -> 0x004f }
                        r5.<init>()     // Catch:{ Exception -> 0x004f }
                        r4.setErrorCallback(r5)     // Catch:{ Exception -> 0x004f }
                        com.meizu.media.camera.camcontroller.e r5 = new com.meizu.media.camera.camcontroller.e     // Catch:{ Exception -> 0x004f }
                        int r6 = r4     // Catch:{ Exception -> 0x004f }
                        r5.<init>(r6, r4)     // Catch:{ Exception -> 0x004f }
                        boolean r1 = r5     // Catch:{ Exception -> 0x004b }
                        r5.mo19732a((boolean) r1)     // Catch:{ Exception -> 0x004b }
                        r1 = r5
                        goto L_0x00a1
                    L_0x004b:
                        r1 = move-exception
                        r4 = r1
                        r1 = r5
                        goto L_0x0050
                    L_0x004f:
                        r4 = move-exception
                    L_0x0050:
                        com.meizu.media.camera.util.ac$a r5 = com.meizu.media.camera.camcontroller.CameraControllerV1.f8728p
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        java.lang.String r7 = "open camera :"
                        r6.append(r7)
                        int r7 = r4
                        r6.append(r7)
                        java.lang.String r7 = "  fail, "
                        r6.append(r7)
                        java.lang.String r4 = r4.getMessage()
                        r6.append(r4)
                        java.lang.String r4 = r6.toString()
                        com.meizu.media.camera.util.LogUtil.m15952c(r5, r4)
                        if (r2 != r3) goto L_0x00a1
                        com.meizu.media.camera.camcontroller.b r3 = com.meizu.media.camera.camcontroller.CameraControllerV1.this
                        com.meizu.media.camera.b$a r3 = r3.f8281e
                        boolean r4 = r5
                        boolean r3 = r3.mo19051a((boolean) r4)
                        com.meizu.media.camera.camcontroller.b r4 = com.meizu.media.camera.camcontroller.CameraControllerV1.this
                        com.meizu.media.camera.b$a r4 = r4.f8281e
                        java.util.UUID r5 = r6
                        com.meizu.media.camera.util.Contants$CameraService$RequestCode r6 = r7
                        com.meizu.media.camera.util.Contants$CameraService$ResultCode r7 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OPEN_CAMERA_FAILURE
                        r8 = 2
                        java.lang.Object[] r8 = new java.lang.Object[r8]
                        int r9 = r4
                        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                        r8[r0] = r9
                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                        r9 = 1
                        r8[r9] = r3
                        r4.mo19045a(r5, r6, r7, r8)
                    L_0x00a1:
                        if (r1 != 0) goto L_0x00b0
                        r3 = 200(0xc8, double:9.9E-322)
                        java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00a9 }
                        goto L_0x00ad
                    L_0x00a9:
                        r1 = move-exception
                        r1.printStackTrace()
                    L_0x00ad:
                        r1 = r2
                        goto L_0x0017
                    L_0x00b0:
                        r1.mo19739e()
                        com.meizu.media.camera.camcontroller.b r0 = com.meizu.media.camera.camcontroller.CameraControllerV1.this
                        com.meizu.media.camera.camcontroller.CameraProxyV1 unused = r0.f8769q = r1
                    L_0x00b8:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraControllerV1.C198149.run():void");
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x035f, code lost:
        if (r8.f8281e.mo19054b() != false) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0367, code lost:
        if (r8.f8281e.mo19051a(r14) == false) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x036c, code lost:
        if (com.meizu.media.camera.util.DeviceHelper.f13840T == false) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0374, code lost:
        if (r8.f8769q.mo19734c() == null) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0376, code lost:
        com.meizu.media.camera.util.LogUtil.m15942a(f8728p, "setParams for qcom dual mode on sub camera");
        r8.f8279c.post(new com.meizu.media.camera.camcontroller.CameraControllerV1.C19856(r8));
        r8.f8279c.mo19553a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x038d, code lost:
        r8.f8281e.mo19053b(r7, r11, com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW, new java.lang.Object[0]);
        com.meizu.media.camera.util.LogUtil.m15942a(f8728p, "Cancel case Next action is switchCamera or closeCamera");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x039d, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029e  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19502c(android.content.Intent r17) {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            r9 = 1
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r10 = 0
            r1[r10] = r0
            com.meizu.savior.ChangeQuickRedirect r3 = f8727o
            java.lang.Class[] r6 = new java.lang.Class[r9]
            java.lang.Class<android.content.Intent> r2 = android.content.Intent.class
            r6[r10] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 2787(0xae3, float:3.905E-42)
            r2 = r16
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r1 = "uuid"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            r7 = r1
            java.util.UUID r7 = (java.util.UUID) r7
            java.lang.String r1 = "requestCode"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            r11 = r1
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r11 = (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r11
            java.lang.String r1 = "modeType"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            r12 = r1
            com.meizu.media.camera.mode.CameraModeType$ModeType r12 = (com.meizu.media.camera.mode.CameraModeType.ModeType) r12
            java.lang.String r1 = "stereoOn"
            boolean r13 = r0.getBooleanExtra(r1, r10)
            java.lang.String r1 = "EXTRA_IS_WATCH_CAMERA_INTENT"
            boolean r14 = r0.getBooleanExtra(r1, r10)
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "resumeCamera isWatch:"
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19051a((boolean) r14)
            if (r1 == 0) goto L_0x0078
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel resume camera case Next action is close camera"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            return
        L_0x0078:
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19054b()
            if (r1 == 0) goto L_0x0091
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel resume camera case Next action is switchCamera"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            return
        L_0x0091:
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19055b((boolean) r14)
            if (r1 == 0) goto L_0x009c
            com.meizu.media.camera.CameraOptTask.m8370a((boolean) r14, (boolean) r10)
        L_0x009c:
            java.lang.String r1 = "cameraId"
            int r0 = r0.getIntExtra(r1, r10)
            if (r0 != 0) goto L_0x00a6
            r1 = 1
            goto L_0x00a7
        L_0x00a6:
            r1 = 0
        L_0x00a7:
            r8.m9408a((com.meizu.media.camera.mode.CameraModeType.ModeType) r12, (boolean) r13, (boolean) r1)
            com.meizu.media.camera.camcontroller.CameraController$e r15 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$50 r6 = new com.meizu.media.camera.camcontroller.b$50
            r1 = r6
            r2 = r16
            r3 = r0
            r4 = r14
            r5 = r7
            r9 = r6
            r6 = r11
            r1.<init>(r3, r4, r5, r6)
            r15.post(r9)
            com.meizu.media.camera.camcontroller.CameraController$e r1 = r8.f8279c
            r1.mo19553a()
            com.meizu.media.camera.camcontroller.e r1 = r8.f8769q
            if (r1 == 0) goto L_0x04ca
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CAMERA_OPENED  requestCode:"
            r2.append(r3)
            java.lang.String r3 = r11.name()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19051a((boolean) r14)
            if (r1 != 0) goto L_0x014b
            if (r13 == 0) goto L_0x010c
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r1 == 0) goto L_0x010c
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x010c
            com.meizu.media.camera.camcontroller.e r1 = r8.f8769q
            java.lang.Object r1 = r1.mo19734c()
            if (r1 != 0) goto L_0x010c
            com.meizu.media.camera.camcontroller.CameraController$e r1 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$51 r2 = new com.meizu.media.camera.camcontroller.b$51
            r2.<init>()
            r1.post(r2)
            com.meizu.media.camera.camcontroller.CameraController$e r1 = r8.f8279c
            r1.mo19553a()
        L_0x010c:
            if (r13 == 0) goto L_0x0140
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r1 == 0) goto L_0x0140
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x0140
            com.meizu.media.camera.camcontroller.e r1 = r8.f8769q
            java.lang.Object r1 = r1.mo19734c()
            if (r1 != 0) goto L_0x0140
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19051a((boolean) r14)
            com.meizu.media.camera.b$a r2 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r3 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OPEN_CAMERA_FAILURE
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r10] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r1 = 1
            r4[r1] = r0
            r2.mo19045a(r7, r11, r3, r4)
            goto L_0x0174
        L_0x0140:
            r1 = 1
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CAMERA_OPENED
            java.lang.Object[] r3 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r2, r3)
            goto L_0x0174
        L_0x014b:
            r1 = 1
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL
            java.lang.Object[] r3 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r2, r3)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CAMERA_OPENED  requestCode:"
            r2.append(r3)
            java.lang.String r3 = r11.name()
            r2.append(r3)
            java.lang.String r3 = ",  but next action is close camera"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
        L_0x0174:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.a$c r2 = r0.mo19040a((java.util.UUID) r7)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x04b9
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19057c()
            if (r0 != 0) goto L_0x04b9
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 != 0) goto L_0x04b9
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r0 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x01a6
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x01a6
            goto L_0x04b9
        L_0x01a6:
            if (r2 == 0) goto L_0x02b1
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "listener.getSurfaceTexture() != null:"
            r3.append(r4)
            android.graphics.SurfaceTexture r4 = r2.mo18119c()
            if (r4 == 0) goto L_0x01bc
            r4 = 1
            goto L_0x01bd
        L_0x01bc:
            r4 = 0
        L_0x01bd:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isPreparedForStartPreview(isWatchCameraIntent):"
            r3.append(r4)
            com.meizu.media.camera.b$a r4 = r8.f8281e
            boolean r4 = r4.mo19055b((boolean) r14)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
            android.graphics.SurfaceTexture r0 = r2.mo18119c()
            if (r0 == 0) goto L_0x0202
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19055b((boolean) r14)
            if (r0 == 0) goto L_0x0202
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$2 r3 = new com.meizu.media.camera.camcontroller.b$2
            r3.<init>(r2)
            r0.post(r3)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
        L_0x0200:
            r0 = 1
            goto L_0x023b
        L_0x0202:
            java.lang.Object r3 = com.meizu.media.camera.CamIntentTask.f7414r
            monitor-enter(r3)
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ InterruptedException -> 0x0217 }
            java.lang.String r4 = "resumeCamera wait"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r4)     // Catch:{ InterruptedException -> 0x0217 }
            java.lang.Object r0 = com.meizu.media.camera.CamIntentTask.f7414r     // Catch:{ InterruptedException -> 0x0217 }
            r4 = 6000(0x1770, double:2.9644E-320)
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x0217 }
            goto L_0x021b
        L_0x0214:
            r0 = move-exception
            goto L_0x02af
        L_0x0217:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0214 }
        L_0x021b:
            monitor-exit(r3)     // Catch:{ all -> 0x0214 }
            android.graphics.SurfaceTexture r0 = r2.mo18119c()
            if (r0 == 0) goto L_0x023a
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19055b((boolean) r14)
            if (r0 == 0) goto L_0x023a
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$3 r3 = new com.meizu.media.camera.camcontroller.b$3
            r3.<init>(r2)
            r0.post(r3)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
            goto L_0x0200
        L_0x023a:
            r0 = 0
        L_0x023b:
            com.meizu.media.camera.b$a r3 = r8.f8281e
            boolean r3 = r3.mo19054b()
            if (r3 != 0) goto L_0x029e
            com.meizu.media.camera.b$a r3 = r8.f8281e
            boolean r3 = r3.mo19057c()
            if (r3 != 0) goto L_0x029e
            com.meizu.media.camera.b$a r3 = r8.f8281e
            boolean r3 = r3.mo19051a((boolean) r14)
            if (r3 != 0) goto L_0x029e
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r3 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x0266
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r3 = r12.equals(r3)
            if (r3 != 0) goto L_0x0266
            goto L_0x029e
        L_0x0266:
            if (r0 != 0) goto L_0x02b1
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "resumeCamera wait time out,return!  surfaceTexture:"
            r3.append(r4)
            android.graphics.SurfaceTexture r4 = r2.mo18119c()
            if (r4 == 0) goto L_0x027b
            goto L_0x027c
        L_0x027b:
            r1 = 0
        L_0x027c:
            r3.append(r1)
            java.lang.String r1 = ", isPreparedForStartPreview:"
            r3.append(r1)
            com.meizu.media.camera.b$a r1 = r8.f8281e
            boolean r1 = r1.mo19055b((boolean) r14)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_KILL_SELF
            java.lang.Object[] r3 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r3)
            goto L_0x02b1
        L_0x029e:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera,or stopPreview ,or closeCamera, or currentModeType is not the modeType who create the task"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x02af:
            monitor-exit(r3)     // Catch:{ all -> 0x0214 }
            throw r0
        L_0x02b1:
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "setPreviewTexture done"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x04a8
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19057c()
            if (r0 != 0) goto L_0x04a8
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 != 0) goto L_0x04a8
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r0 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x02e4
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x02e4
            goto L_0x04a8
        L_0x02e4:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r0 == 0) goto L_0x039e
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x039e
            com.meizu.media.camera.camcontroller.e r0 = r8.f8769q
            java.lang.Object r0 = r0.mo19734c()
            if (r0 == 0) goto L_0x039e
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r0 == 0) goto L_0x030b
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$4 r1 = new com.meizu.media.camera.camcontroller.b$4
            r1.<init>()
            r0.post(r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
        L_0x030b:
            if (r2 == 0) goto L_0x0359
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x0348
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 == 0) goto L_0x031e
            goto L_0x0348
        L_0x031e:
            android.graphics.SurfaceTexture r0 = r2.mo18236f()
            if (r0 == 0) goto L_0x033c
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19055b((boolean) r14)
            if (r0 == 0) goto L_0x033c
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$5 r1 = new com.meizu.media.camera.camcontroller.b$5
            r1.<init>(r2)
            r0.post(r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
            goto L_0x0359
        L_0x033c:
            r0 = 5
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0342 }
            goto L_0x030b
        L_0x0342:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            goto L_0x030b
        L_0x0348:
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera or closeCamera"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            return
        L_0x0359:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x038d
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 == 0) goto L_0x036a
            goto L_0x038d
        L_0x036a:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r0 == 0) goto L_0x039e
            com.meizu.media.camera.camcontroller.e r0 = r8.f8769q
            java.lang.Object r0 = r0.mo19734c()
            if (r0 == 0) goto L_0x039e
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "setParams for qcom dual mode on sub camera"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$6 r1 = new com.meizu.media.camera.camcontroller.b$6
            r1.<init>()
            r0.post(r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
            goto L_0x039e
        L_0x038d:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera or closeCamera"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x039e:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_GALLERY
            if (r0 != r1) goto L_0x03b0
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13856aI
            if (r0 == 0) goto L_0x03b0
            byte[] r0 = f8726av
            if (r0 != 0) goto L_0x03b0
            r16.m9420aA()
            goto L_0x03de
        L_0x03b0:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL
            if (r0 != r1) goto L_0x03de
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13856aI
            if (r0 == 0) goto L_0x03de
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x03de
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$7 r1 = new com.meizu.media.camera.camcontroller.b$7
            r1.<init>()
            r0.post(r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
            com.meizu.media.camera.camcontroller.e r0 = r8.f8769q
            java.lang.Object r0 = r0.mo19730a()
            android.hardware.Camera r0 = (android.hardware.Camera) r0
            android.hardware.Camera$PreviewCallback r1 = r8.f8752aJ
            r0.setOneShotPreviewCallback(r1)
        L_0x03de:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x0497
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19057c()
            if (r0 != 0) goto L_0x0497
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 != 0) goto L_0x0497
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r0 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x040a
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x040a
            goto L_0x0497
        L_0x040a:
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "startPreviewSync"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            java.lang.String r0 = "startUp"
            java.lang.String r1 = "startPreview"
            com.meizu.media.camera.util.TimingLoggerUtil.m16032a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ RuntimeException -> 0x042b }
            com.meizu.media.camera.camcontroller.e r0 = r8.f8769q     // Catch:{ RuntimeException -> 0x042b }
            java.lang.Object r0 = r0.mo19730a()     // Catch:{ RuntimeException -> 0x042b }
            android.hardware.Camera r0 = (android.hardware.Camera) r0     // Catch:{ RuntimeException -> 0x042b }
            r0.startPreview()     // Catch:{ RuntimeException -> 0x042b }
            java.lang.String r0 = "startUp"
            java.lang.String r1 = "startPreviewFinish"
            com.meizu.media.camera.util.TimingLoggerUtil.m16032a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ RuntimeException -> 0x042b }
            goto L_0x042f
        L_0x042b:
            r0 = move-exception
            com.meizu.media.camera.util.DeviceUtil.m16195a((java.lang.RuntimeException) r0)
        L_0x042f:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r0 == 0) goto L_0x044a
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.PORTRAIT
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x044a
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            com.meizu.media.camera.camcontroller.b$8 r1 = new com.meizu.media.camera.camcontroller.b$8
            r1.<init>()
            r0.post(r1)
            com.meizu.media.camera.camcontroller.CameraController$e r0 = r8.f8279c
            r0.mo19553a()
        L_0x044a:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19054b()
            if (r0 != 0) goto L_0x0486
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19057c()
            if (r0 != 0) goto L_0x0486
            com.meizu.media.camera.b$a r0 = r8.f8281e
            boolean r0 = r0.mo19051a((boolean) r14)
            if (r0 != 0) goto L_0x0486
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r0 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x0475
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.m10946a()
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0475
            goto L_0x0486
        L_0x0475:
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "RESULT_START_PREVIEW_DONE"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            goto L_0x04d3
        L_0x0486:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera,or stopPreview ,or closeCamera, or currentModeType is not the modeType who create the task"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x0497:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera,or stopPreview ,or closeCamera, or currentModeType is not the modeType who create the task"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x04a8:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera,or stopPreview ,or closeCamera, or currentModeType is not the modeType who create the task"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x04b9:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "Cancel case Next action is switchCamera,or stopPreview ,or closeCamera, or currentModeType is not the modeType who create the task"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x04ca:
            com.meizu.media.camera.b$a r0 = r8.f8281e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_NULL_CAMERA
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r0.mo19053b(r7, r11, r1, r2)
        L_0x04d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraControllerV1.mo19502c(android.content.Intent):void");
    }

    /* renamed from: d */
    public void mo19507d(Intent intent) {
        Intent intent2 = intent;
        if (!PatchProxy.proxy(new Object[]{intent2}, this, f8727o, false, 2788, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent2.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent2.getSerializableExtra("requestCode");
            boolean booleanExtra = intent2.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false);
            CamIntentTask.C1777c a = this.f8281e.mo19040a(uuid);
            boolean booleanExtra2 = intent2.getBooleanExtra("needSetPreviewTexture", false);
            CameraProxyV1 eVar = (CameraProxyV1) CameraController.m8868g().mo19522k();
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            final Contants.CameraService.RequestCode requestCode2 = requestCode;
            final CameraProxyV1 eVar2 = eVar;
            final boolean z = booleanExtra;
            C19889 r10 = r1;
            final UUID uuid2 = uuid;
            C19889 r1 = new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8931a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8931a, false, 2883, new Class[0], Void.TYPE).isSupported) {
                        if (Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_BACKTRACE_PREVIEW.equals(requestCode2)) {
                            if (DeviceHelper.f13839S) {
                                eVar2.mo19740f().set("cap-mode", "normal");
                            } else if (DeviceHelper.f13841U) {
                                eVar2.mo19740f().set("shot-mode", "0");
                            } else if (DeviceHelper.f13840T) {
                                eVar2.mo19740f().set("scene-mode", "auto");
                            }
                            if (eVar2.mo19733b() != 1) {
                                eVar2.mo19740f().setFocusMode("continuous-picture");
                            }
                            eVar2.mo19742h();
                        }
                        ((Camera) eVar2.mo19730a()).stopPreview();
                        if (CameraControllerV1.this.f8281e.mo19055b(z) && requestCode2.equals(Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW_FOR_MODE_CHANGE)) {
                            CameraOptTask.m8370a(z, false);
                        }
                        CameraControllerV1.this.f8281e.mo19053b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_STOP_PREVIEW_DONE, new Object[0]);
                    }
                }
            };
            i.post(r10);
            i.mo19553a();
            if (requestCode.equals(Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW_FOR_MODE_CHANGE)) {
                while (a != null) {
                    if (this.f8281e.mo19051a(booleanExtra) || this.f8281e.mo19057c() || this.f8281e.mo19054b()) {
                        this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                        return;
                    } else if (this.f8281e.mo19055b(booleanExtra)) {
                        mo19513f(intent);
                        return;
                    } else {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            }
            final boolean z2 = booleanExtra;
            final UUID uuid3 = uuid;
            final Contants.CameraService.RequestCode requestCode3 = requestCode;
            final CameraProxyV1 eVar3 = eVar;
            final boolean z3 = booleanExtra2;
            final CamIntentTask.C1777c cVar = a;
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8779a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8779a, false, 2884, new Class[0], Void.TYPE).isSupported) {
                        if (CameraControllerV1.this.f8281e.mo19051a(z2) || CameraControllerV1.this.f8281e.mo19057c() || CameraControllerV1.this.f8281e.mo19054b()) {
                            CameraControllerV1.this.f8281e.mo19053b(uuid3, requestCode3, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                            return;
                        }
                        if (EffectRenderContext.m4369h().mo14223j() && DeviceHelper.f14050t) {
                            Camera.Parameters f = eVar3.mo19740f();
                            LogUtil.m15952c(CameraControllerV1.f8728p, "mParamsManager.setParameter pan_open");
                            f.set("cap-mode", "pano-open");
                            eVar3.mo19742h();
                        }
                        if (z3) {
                            try {
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setPreviewTexture(cVar.mo18119c());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            LogUtil.m15942a(CameraControllerV1.f8728p, "setPreviewTexture done");
                        }
                        try {
                            ((Camera) eVar3.mo19730a()).startPreview();
                        } catch (RuntimeException e2) {
                            DeviceUtil.m16195a(e2);
                        }
                        CameraControllerV1.this.f8281e.mo19053b(uuid3, requestCode3, Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE, new Object[0]);
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: e */
    public void mo19510e(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2789, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            final UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            final Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8787a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8787a, false, 2885, new Class[0], Void.TYPE).isSupported) {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).stopPreview();
                        CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_STOP_PREVIEW_DONE, new Object[0]);
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: f */
    public void mo19513f(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2790, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            final UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            final Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            final boolean booleanExtra = intent.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false);
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8793a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8793a, false, 2887, new Class[0], Void.TYPE).isSupported) {
                        CamIntentTask.C1777c a = CameraControllerV1.this.f8281e.mo19040a(uuid);
                        while (true) {
                            if (a == null) {
                                break;
                            } else if (CameraControllerV1.this.f8281e.mo19051a(booleanExtra) || CameraControllerV1.this.f8281e.mo19057c() || CameraControllerV1.this.f8281e.mo19054b()) {
                                CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                            } else if (a.mo18119c() != null) {
                                try {
                                    ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setPreviewTexture(a.mo18119c());
                                    break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    Thread.sleep(5);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                        return;
                    }
                    return;
                    CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE, new Object[0]);
                    LogUtil.m15942a(CameraControllerV1.f8728p, "setPreviewTexture done");
                    if (CameraControllerV1.this.f8281e.mo19051a(booleanExtra) || CameraControllerV1.this.f8281e.mo19057c() || CameraControllerV1.this.f8281e.mo19054b()) {
                        CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                        return;
                    }
                    try {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).startPreview();
                    } catch (RuntimeException e3) {
                        DeviceUtil.m16195a(e3);
                    }
                    CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE, new Object[0]);
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: g */
    public void mo19515g(final Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2791, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8798a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8798a, false, 2888, new Class[0], Void.TYPE).isSupported) {
                        UUID uuid = (UUID) intent.getSerializableExtra("uuid");
                        Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
                        intent.getBooleanExtra("shouldStopFaceDetection", false);
                        boolean booleanExtra = intent.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false);
                        LogUtil.C2630a ah = CameraControllerV1.f8728p;
                        LogUtil.m15942a(ah, "closeCamera isWatch:" + booleanExtra);
                        CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSE_START, new Object[0]);
                        if (CameraControllerV1.this.f8769q != null) {
                            try {
                                if (CameraControllerV1.this.f8772v) {
                                    ((Camera) CameraControllerV1.this.f8769q.mo19730a()).cancelAutoFocus();
                                    boolean unused = CameraControllerV1.this.f8772v = false;
                                }
                                if (CameraControllerV1.this.f8773w) {
                                    ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setFaceDetectionListener((Camera.FaceDetectionListener) null);
                                    ((Camera) CameraControllerV1.this.f8769q.mo19730a()).stopFaceDetection();
                                    boolean unused2 = CameraControllerV1.this.f8773w = false;
                                    CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_FACE_DETECTION_STOPED, new Object[0]);
                                }
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setZoomChangeListener((Camera.OnZoomChangeListener) null);
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setFaceDetectionListener((Camera.FaceDetectionListener) null);
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setPreviewCallback((Camera.PreviewCallback) null);
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback) null);
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setErrorCallback((Camera.ErrorCallback) null);
                                if (CameraControllerV1.this.f8769q.mo19741g() != null) {
                                    CameraControllerV1.this.f8769q.mo19741g().release();
                                }
                                ((Camera) CameraControllerV1.this.f8769q.mo19730a()).release();
                                CameraControllerV1.this.f8770t.clear();
                                LogUtil.m15952c(CameraControllerV1.f8728p, "release success");
                                if (DeviceHelper.f13840T && CameraControllerV1.this.f8769q.mo19734c() != null) {
                                    ((Camera) CameraControllerV1.this.f8769q.mo19734c()).release();
                                    CameraControllerV1.this.f8769q.mo19731a(null);
                                }
                                CameraController.m8868g().mo19446X();
                                CameraOptTask.m8370a(booleanExtra, false);
                                CameraProxyV1 unused3 = CameraControllerV1.this.f8769q = null;
                                CameraOptTask.m8370a(booleanExtra, false);
                            } catch (RuntimeException e) {
                                DeviceUtil.m16195a(e);
                            }
                        } else {
                            CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
                        }
                        CameraControllerV1.this.f8281e.mo19053b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSED, new Object[0]);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19471a(String str, String str2, boolean... zArr) {
        Class[] clsArr = {String.class, String.class, boolean[].class};
        if (!PatchProxy.proxy(new Object[]{str, str2, zArr}, this, f8727o, false, 2792, clsArr, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().set(str, str2);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15949b(f8728p, "setParameter at a wrong time");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8801a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8801a, false, 2889, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: a */
    public void mo19480a(boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f8727o, false, 2793, new Class[]{boolean[].class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8803a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8803a, false, 2890, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        CameraControllerV1.this.f8769q.mo19742h();
                    }
                }
            });
            if (zArr == null || zArr.length <= 0 || !zArr[0]) {
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: a */
    public Point mo19450a(int i, int i2, boolean... zArr) {
        int i3 = i;
        int i4 = i2;
        Object[] objArr = {new Integer(i3), new Integer(i4), zArr};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        Object[] objArr2 = objArr;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, this, changeQuickRedirect2, false, 2794, new Class[]{Integer.TYPE, Integer.TYPE, boolean[].class}, Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        if (!Looper.getMainLooper().getThread().getName().equals(Thread.currentThread().getName())) {
            try {
                if (this.f8769q != null) {
                    Camera.Parameters f = this.f8769q.mo19740f();
                    List<Camera.Size> supportedPreviewSizes = f.getSupportedPreviewSizes();
                    double d = ((double) i3) / ((double) i4);
                    Camera.Size size = null;
                    if (supportedPreviewSizes == null) {
                        return null;
                    }
                    Size d2 = DeviceUtil.m16203d(this.f8286l);
                    int min = Math.min(d2.getWidth(), d2.getHeight());
                    double d3 = Double.MAX_VALUE;
                    for (Camera.Size next : supportedPreviewSizes) {
                        if (Math.abs((((double) next.width) / ((double) next.height)) - d) <= 0.1d && ((double) Math.abs(next.height - min)) < d3) {
                            size = next;
                            d3 = (double) Math.abs(next.height - min);
                        }
                        boolean[] zArr2 = zArr;
                    }
                    if (size == null) {
                        double d4 = Double.MAX_VALUE;
                        for (Camera.Size next2 : supportedPreviewSizes) {
                            if (((double) Math.abs(next2.height - min)) < d4) {
                                size = next2;
                                d4 = (double) Math.abs(next2.height - min);
                            }
                        }
                    }
                    LogUtil.C2630a aVar = f8728p;
                    LogUtil.m15942a(aVar, "setOptimalPreviewSize ratio:" + d + "  targetPreviewSize width:" + size.width + "  height:" + size.height);
                    if (size != null) {
                        synchronized (this.f8769q.f9129g) {
                            f.setPreviewSize(size.width, size.height);
                        }
                    }
                    this.f8287m = new Point(size.width, size.height);
                }
            } catch (RuntimeException e) {
                LogUtil.m15950b(f8728p, "setOptimalPreviewSize at a wrong time!", e);
                e.printStackTrace();
            }
            boolean[] zArr3 = zArr;
            if (zArr3 != null && zArr3.length > 0 && zArr3[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8805a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8805a, false, 2891, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
            return this.f8287m;
        }
        throw new IllegalStateException("Cannot run setOptimalPreviewSize on main thread!");
    }

    /* renamed from: l */
    public Point mo19524l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2795, new Class[0], Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        if (this.f8287m == null) {
            return mo19528n();
        }
        return this.f8287m;
    }

    /* renamed from: a */
    public void mo19462a(final MeizuCamera.MeizuSecureDetectionCallback meizuSecureDetectionCallback) {
        if (!PatchProxy.proxy(new Object[]{meizuSecureDetectionCallback}, this, f8727o, false, 2796, new Class[]{MeizuCamera.MeizuSecureDetectionCallback.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8807a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8807a, false, 2892, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null && CameraControllerV1.this.f8769q.mo19741g() != null) {
                        CameraControllerV1.this.f8769q.mo19741g().setSecureDetectionCallback(meizuSecureDetectionCallback);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19461a(final MeizuCamera.MeizuSceneModeDetectionCallback meizuSceneModeDetectionCallback) {
        if (!PatchProxy.proxy(new Object[]{meizuSceneModeDetectionCallback}, this, f8727o, false, 2797, new Class[]{MeizuCamera.MeizuSceneModeDetectionCallback.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8810a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8810a, false, 2893, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null && CameraControllerV1.this.f8769q.mo19741g() != null) {
                        CameraControllerV1.this.f8769q.mo19741g().setSceneModeDetectionCallback(meizuSceneModeDetectionCallback);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19460a(final MeizuCamera.MeizuModuleCoveredDetectionCallback meizuModuleCoveredDetectionCallback) {
        if (!PatchProxy.proxy(new Object[]{meizuModuleCoveredDetectionCallback}, this, f8727o, false, 2798, new Class[]{MeizuCamera.MeizuModuleCoveredDetectionCallback.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8816a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8816a, false, 2894, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null && CameraControllerV1.this.f8769q.mo19741g() != null) {
                        CameraControllerV1.this.f8769q.mo19741g().setModuleCoveredDetectionCallback(meizuModuleCoveredDetectionCallback);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19459a(final MeizuCamera.MeizuMetaDataCallback meizuMetaDataCallback) {
        if (!PatchProxy.proxy(new Object[]{meizuMetaDataCallback}, this, f8727o, false, 2799, new Class[]{MeizuCamera.MeizuMetaDataCallback.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8819a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8819a, false, 2895, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null && CameraControllerV1.this.f8769q.mo19741g() != null) {
                        CameraControllerV1.this.f8769q.mo19741g().setMeizuMetaDataCallback(meizuMetaDataCallback);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo19475a(final boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2800, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8822a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8822a, false, 2896, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).enableShutterSound(z);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: b */
    public void mo19488b(final int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2801, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8827a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8827a, false, 2898, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setDisplayOrientation(i);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19457a(final Handler handler, final CameraController.C1877d dVar) {
        Class[] clsArr = {Handler.class, CameraController.C1877d.class};
        if (!PatchProxy.proxy(new Object[]{handler, dVar}, this, f8727o, false, 2802, clsArr, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8830a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8830a, false, 2899, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setFaceDetectionListener(C1994e.m9595a(handler, CameraControllerV1.this.f8769q, dVar));
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19456a(final Handler handler, final CameraController.C1874a aVar) {
        Class[] clsArr = {Handler.class, CameraController.C1874a.class};
        if (!PatchProxy.proxy(new Object[]{handler, aVar}, this, f8727o, false, 2803, clsArr, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8834a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8834a, false, 2900, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setAutoFocusMoveCallback(C1989a.m9592a(handler, CameraControllerV1.this.f8769q, aVar));
                    }
                }
            });
        }
    }

    /* renamed from: m */
    public int mo19526m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2804, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8769q == null) {
            return -1;
        }
        try {
            return this.f8769q.mo19741g().getFocusDistance();
        } catch (Exception e) {
            LogUtil.m15955d(f8728p, "Get Focus Distance failed ", e);
            return -1;
        }
    }

    /* renamed from: a */
    public void mo19454a(final SurfaceTexture surfaceTexture) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture}, this, f8727o, false, 2805, new Class[]{SurfaceTexture.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8838a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8838a, false, 2901, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        try {
                            ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setPreviewTexture(surfaceTexture);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19479a(final FileDescriptor[] fileDescriptorArr) {
        if (!PatchProxy.proxy(new Object[]{fileDescriptorArr}, this, f8727o, false, 2806, new Class[]{FileDescriptor[].class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8841a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8841a, false, 2902, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        CameraControllerV1.this.f8769q.mo19741g().setFileDescriptor(fileDescriptorArr);
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: y */
    public void mo19542y() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2808, new Class[0], Void.TYPE).isSupported) {
            this.f8774x = CameraUtil.m15892d(this.f8769q.mo19740f());
            this.f8775y = CameraUtil.m15887c(this.f8769q.mo19740f());
            this.f8776z = CameraUtil.m15858a(this.f8769q.mo19740f());
            this.f8731A = CameraUtil.m15880b(this.f8769q.mo19740f());
            this.f8732B = CameraUtil.m15864a(CameraController.FocusMode.CONTINUOUS_PICTURE.getKey(), this.f8769q.mo19740f().getSupportedFocusModes());
        }
    }

    /* renamed from: a */
    public void mo19476a(boolean z, List<Rect> list) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), list};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2809, new Class[]{Boolean.TYPE, List.class}, Void.TYPE).isSupported) {
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (Rect area : list) {
                    arrayList.add(new Camera.Area(area, 1));
                }
            }
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        Camera.Parameters f = this.f8769q.mo19740f();
                        if (z) {
                            f.setMeteringAreas(arrayList);
                        } else {
                            f.setFocusAreas(arrayList);
                        }
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setFocusAndMeteringAreas at a wrong time!");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public void mo19517h(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2810, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            final UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            final Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            final CameraProxyV1 eVar = (CameraProxyV1) CameraController.m8868g().mo19522k();
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8844a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8844a, false, 2903, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.m15942a(CameraControllerV1.f8728p, "autoFocus");
                        if (CameraControllerV1.this.f8772v) {
                            ((Camera) eVar.mo19730a()).cancelAutoFocus();
                            LogUtil.m15942a(CameraControllerV1.f8728p, "cancel last autoFocus");
                        }
                        boolean unused = CameraControllerV1.this.f8772v = true;
                        CameraControllerV1.this.f8281e.mo19044a(uuid, requestCode);
                        try {
                            ((Camera) eVar.mo19730a()).autoFocus(new Camera.AutoFocusCallback() {

                                /* renamed from: a */
                                public static ChangeQuickRedirect f8849a;

                                public void onAutoFocus(boolean z, Camera camera) {
                                    if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), camera}, this, f8849a, false, 2904, new Class[]{Boolean.TYPE, Camera.class}, Void.TYPE).isSupported) {
                                        LogUtil.C2630a ah = CameraControllerV1.f8728p;
                                        LogUtil.m15942a(ah, "onAutoFocus focused:" + z);
                                        if (CameraControllerV1.this.f8281e != null) {
                                            boolean unused = CameraControllerV1.this.f8772v = false;
                                            CameraControllerV1.this.f8281e.mo19061g();
                                            CameraControllerV1.this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_AUTO_FOCUS_CALLBACK, Boolean.valueOf(z));
                                        }
                                    }
                                }
                            });
                        } catch (RuntimeException e) {
                            DeviceUtil.m16195a(e);
                        }
                        CameraControllerV1.this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: i */
    public void mo19519i(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2811, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            final CameraProxyV1 eVar = (CameraProxyV1) CameraController.m8868g().mo19522k();
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8854a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8854a, false, 2905, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.C2630a ah = CameraControllerV1.f8728p;
                        LogUtil.m15942a(ah, "cancel autoFocus  mFocusing:" + CameraController.m8868g().mo19535r());
                        ((Camera) eVar.mo19730a()).cancelAutoFocus();
                        boolean unused = CameraControllerV1.this.f8772v = false;
                        LogUtil.m15942a(CameraControllerV1.f8728p, "cancel last autoFocus");
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: z */
    public boolean mo19543z() {
        return this.f8774x;
    }

    /* renamed from: A */
    public boolean mo19437A() {
        return this.f8775y;
    }

    /* renamed from: B */
    public boolean mo19438B() {
        return this.f8776z;
    }

    /* renamed from: C */
    public boolean mo19439C() {
        return this.f8731A;
    }

    /* renamed from: D */
    public boolean mo19440D() {
        return this.f8732B;
    }

    /* renamed from: a */
    public void mo19458a(Surface surface, boolean z) {
        if (!PatchProxy.proxy(new Object[]{surface, new Byte(z ? (byte) 1 : 0)}, this, f8727o, false, 2812, new Class[]{Surface.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8857a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8857a, false, 2906, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        CameraControllerV1.this.f8769q.mo19743i();
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: E */
    public void mo19441E() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2813, new Class[0], Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8859a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8859a, false, 2907, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                        CameraControllerV1.this.f8769q.mo19744j();
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: j */
    public void mo19521j(Intent intent) {
        boolean z;
        Contants.CameraService.RequestCode requestCode;
        Intent intent2 = intent;
        if (!PatchProxy.proxy(new Object[]{intent2}, this, f8727o, false, 2814, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent2.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode2 = (Contants.CameraService.RequestCode) intent2.getSerializableExtra("requestCode");
            Location location = (Location) intent2.getParcelableExtra("location");
            int intExtra = intent2.getIntExtra("width", 0);
            int intExtra2 = intent2.getIntExtra("height", 0);
            int intExtra3 = intent2.getIntExtra("jpegRotation", 0);
            long longExtra = intent2.getLongExtra("shutterSpeed", 0);
            long longExtra2 = intent2.getLongExtra("captureStartTime", 0);
            int intExtra4 = intent2.getIntExtra("currentHeading", 0);
            FaceBeautyData dVar = (FaceBeautyData) intent2.getSerializableExtra("fbData");
            String stringExtra = intent2.getStringExtra("filterEffect");
            boolean booleanExtra = intent2.getBooleanExtra("mirror", false);
            boolean booleanExtra2 = intent2.getBooleanExtra("deviceMark", false);
            boolean booleanExtra3 = intent2.getBooleanExtra("isSquareMode", false);
            boolean booleanExtra4 = intent2.getBooleanExtra("isFBOn", false);
            boolean booleanExtra5 = intent2.getBooleanExtra("isFunnyOn", false);
            boolean booleanExtra6 = intent2.getBooleanExtra("needFastThumbnail", false);
            boolean booleanExtra7 = intent2.getBooleanExtra("isImageCaptureIntent", false);
            String stringExtra2 = intent2.getStringExtra("usercomment");
            LogUtil.m15942a(f8728p, "takePicture shutterSpeed=" + longExtra);
            if (requestCode2 != Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE || this.f8281e.mo19062h()) {
                requestCode = requestCode2;
                z = booleanExtra6;
            } else {
                Contants.CameraService.RequestCode requestCode3 = Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_PICTURE;
                LogUtil.m15942a(f8728p, "requestCode change to REQUEST_CODE_TAKE_PICTURE because scene mode changed");
                requestCode = requestCode3;
                z = false;
            }
            String str = stringExtra2;
            C1997g gVar = r1;
            Contants.CameraService.RequestCode requestCode4 = requestCode;
            long j = longExtra;
            long j2 = longExtra2;
            UUID uuid2 = uuid;
            C1997g gVar2 = new C1997g(this, uuid, requestCode, location, intExtra, intExtra2, intExtra3, j2, intExtra4, dVar, stringExtra, booleanExtra, booleanExtra2, booleanExtra3, z, booleanExtra7, booleanExtra4, booleanExtra5, false);
            this.f8770t.add(gVar);
            f8275g++;
            f8274f++;
            UUID uuid3 = uuid2;
            Contants.CameraService.RequestCode requestCode5 = requestCode4;
            int i = intExtra3;
            boolean z2 = booleanExtra;
            int i2 = intExtra;
            int i3 = intExtra2;
            boolean z3 = z;
            this.f8769q.mo19738a((Handler) this.f8279c, (CameraProxyV1.C2019c) new C2008n(uuid3, requestCode5, i, z2, i2, i3, j2, z3, booleanExtra4, booleanExtra5, str), (CameraProxyV1.C2018b) new C2007m(), (CameraProxyV1.C2018b) new C2005k(uuid3, requestCode5, i, z2, i2, i3, j2, z3), (CameraProxyV1.C2018b) new C2002h());
            Contants.CameraService.RequestCode requestCode6 = requestCode4;
            UUID uuid4 = uuid2;
            this.f8281e.mo19053b(uuid4, requestCode6, Contants.CameraService.ResultCode.REQUEST_CODE_TAKE_PICTURE_START, new Object[0]);
            m9413a(uuid4, requestCode6, true, (int) (j / 1000));
            CamIntentTask.C1777c a = this.f8281e.mo19040a(uuid4);
            if (z) {
                return;
            }
            if (booleanExtra4 && a.mo18240i()) {
                return;
            }
            if ((!DeviceHelper.f14046p && !DeviceHelper.f13840T) || (requestCode6 != Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_AND_MFLL_PICTURE && requestCode6 != Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_PICTURE && requestCode6 != Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE)) {
                this.f8771u = true;
                while (this.f8771u) {
                    if (this.f8281e.mo19051a(false)) {
                        f8275g = 0;
                        f8274f = 0;
                        this.f8281e.mo19041a(f8275g);
                        this.f8281e.mo19045a(uuid4, requestCode6, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
                        m9412a(uuid4, requestCode6, false);
                        return;
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x01bf, code lost:
        r0 = th;
     */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19523k(android.content.Intent r53) {
        /*
            r52 = this;
            r15 = r52
            r0 = r53
            r14 = 1
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r13 = 0
            r1[r13] = r0
            com.meizu.savior.ChangeQuickRedirect r3 = f8727o
            java.lang.Class[] r6 = new java.lang.Class[r14]
            java.lang.Class<android.content.Intent> r2 = android.content.Intent.class
            r6[r13] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 2815(0xaff, float:3.945E-42)
            r2 = r52
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r1 = "uuid"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            r12 = r1
            java.util.UUID r12 = (java.util.UUID) r12
            java.lang.String r1 = "requestCode"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)
            r11 = r1
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r11 = (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r11
            java.lang.String r1 = "width"
            int r22 = r0.getIntExtra(r1, r13)
            java.lang.String r1 = "height"
            int r23 = r0.getIntExtra(r1, r13)
            java.lang.String r1 = "jpegRotation"
            int r9 = r0.getIntExtra(r1, r13)
            java.lang.String r1 = "mirror"
            boolean r24 = r0.getBooleanExtra(r1, r13)
            java.lang.String r1 = "location"
            android.os.Parcelable r1 = r0.getParcelableExtra(r1)
            r25 = r1
            android.location.Location r25 = (android.location.Location) r25
            java.lang.String r1 = "captureStartTime"
            long r2 = java.lang.System.currentTimeMillis()
            long r26 = r0.getLongExtra(r1, r2)
            java.lang.String r1 = "deviceMark"
            boolean r28 = r0.getBooleanExtra(r1, r13)
            java.lang.String r1 = "timeMark"
            boolean r16 = r0.getBooleanExtra(r1, r13)
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            r10 = 0
            if (r0 != r1) goto L_0x0104
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "takeStereoPicture"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.String r1 = "send takeStereoPicture to HAL success!"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.e r0 = r15.f8769q
            com.meizu.media.camera.b$a r1 = r15.f8281e
            android.os.Handler r29 = r1.mo19058d()
            com.meizu.media.camera.camcontroller.b$n r30 = new com.meizu.media.camera.camcontroller.b$n
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r1 = r30
            r2 = r52
            r3 = r12
            r4 = r11
            r5 = r9
            r6 = r24
            r7 = r22
            r8 = r23
            r31 = r9
            r9 = r26
            r33 = r11
            r11 = r13
            r13 = r12
            r12 = r16
            r34 = r13
            r13 = r17
            r14 = r18
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14)
            com.meizu.media.camera.camcontroller.b$m r14 = new com.meizu.media.camera.camcontroller.b$m
            r12 = 0
            r14.<init>()
            r32 = 0
            com.meizu.media.camera.camcontroller.b$g r35 = new com.meizu.media.camera.camcontroller.b$g
            r1 = r35
            r11 = 0
            r12 = 0
            java.lang.String r13 = "none"
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            r3 = r34
            r4 = r33
            r5 = r25
            r6 = r22
            r7 = r23
            r8 = r31
            r22 = r14
            r14 = r24
            r15 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2 = r0
            r3 = r29
            r4 = r30
            r5 = r22
            r6 = r32
            r7 = r35
            r2.mo19738a((android.os.Handler) r3, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2019c) r4, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r5, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r6, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r7)
            int r0 = f8275g
            r15 = 1
            int r0 = r0 + r15
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r15
            f8274f = r0
            r9 = r33
            r11 = r34
            r14 = r52
            r14.m9412a((java.util.UUID) r11, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r9, (boolean) r15)
            r2 = r14
            goto L_0x0537
        L_0x0104:
            r31 = r9
            r9 = r11
            r11 = r12
            r14 = r15
            r15 = 1
            r12 = r10
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES
            if (r0 != r1) goto L_0x01d4
            com.meizu.media.camera.camcontroller.e r0 = r14.f8769q
            android.hardware.Camera$Parameters r0 = r0.mo19740f()
            r14.m9403a((android.hardware.Camera.Parameters) r0)
            com.meizu.media.camera.camcontroller.e r0 = r14.f8769q     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object r1 = r0.f9129g     // Catch:{ Exception -> 0x01c1 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x01c1 }
            java.lang.reflect.Method r0 = f8716R     // Catch:{ all -> 0x01b9 }
            com.meizu.media.camera.camcontroller.e r2 = r14.f8769q     // Catch:{ all -> 0x01b9 }
            android.hardware.Camera$Parameters r2 = r2.mo19740f()     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ all -> 0x01b9 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x01b9 }
            r3[r13] = r4     // Catch:{ all -> 0x01b9 }
            r0.invoke(r2, r3)     // Catch:{ all -> 0x01b9 }
            monitor-exit(r1)     // Catch:{ all -> 0x01b9 }
            java.lang.reflect.Method r0 = f8713O     // Catch:{ Exception -> 0x01c1 }
            com.meizu.media.camera.camcontroller.e r1 = r14.f8769q     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object r1 = r1.mo19730a()     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object[] r2 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object r3 = r14.f8733E     // Catch:{ Exception -> 0x01c1 }
            r2[r13] = r3     // Catch:{ Exception -> 0x01c1 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x01c1 }
            java.lang.reflect.Method r0 = f8714P     // Catch:{ Exception -> 0x01c1 }
            com.meizu.media.camera.camcontroller.e r1 = r14.f8769q     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object r1 = r1.mo19730a()     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object[] r2 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01c1 }
            java.lang.Object r3 = r14.f8734N     // Catch:{ Exception -> 0x01c1 }
            r2[r13] = r3     // Catch:{ Exception -> 0x01c1 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x01c1 }
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "takeStereoPicture"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.e r0 = r14.f8769q
            com.meizu.media.camera.camcontroller.CameraController$e r13 = r14.f8279c
            com.meizu.media.camera.camcontroller.b$n r16 = new com.meizu.media.camera.camcontroller.b$n
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r1 = r16
            r2 = r52
            r3 = r11
            r4 = r9
            r5 = r31
            r6 = r24
            r7 = r22
            r8 = r23
            r36 = r9
            r9 = r26
            r37 = r11
            r11 = r12
            r12 = r17
            r17 = r13
            r13 = r18
            r15 = r14
            r14 = r19
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14)
            r12 = 0
            com.meizu.media.camera.camcontroller.b$k r13 = new com.meizu.media.camera.camcontroller.b$k
            r11 = 1
            r1 = r13
            r3 = r37
            r4 = r36
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11)
            com.meizu.media.camera.camcontroller.b$p r7 = new com.meizu.media.camera.camcontroller.b$p
            r14 = r36
            r7.<init>(r14)
            r2 = r0
            r3 = r17
            r4 = r16
            r5 = r12
            r6 = r13
            r2.mo19738a((android.os.Handler) r3, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2019c) r4, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r5, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r6, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r7)
            int r0 = f8275g
            r1 = 1
            int r0 = r0 + r1
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r1
            f8274f = r0
            r11 = r37
            r15.m9412a((java.util.UUID) r11, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r14, (boolean) r1)
            goto L_0x0411
        L_0x01b9:
            r0 = move-exception
            r15 = r14
        L_0x01bb:
            monitor-exit(r1)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bd }
        L_0x01bd:
            r0 = move-exception
            goto L_0x01c3
        L_0x01bf:
            r0 = move-exception
            goto L_0x01bb
        L_0x01c1:
            r0 = move-exception
            r15 = r14
        L_0x01c3:
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.String r2 = "Reflect stereo error"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.String r0 = r0.getMessage()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r0)
            return
        L_0x01d4:
            r15 = r14
            r14 = r9
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_GALLERY
            if (r0 != r1) goto L_0x036d
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            r0.mo18646c()
            com.meizu.media.camera.camcontroller.e r0 = r15.f8769q
            java.lang.Object r0 = r0.mo19730a()
            r9 = r0
            android.hardware.Camera r9 = (android.hardware.Camera) r9
            com.meizu.media.camera.camcontroller.e r0 = r15.f8769q
            java.lang.Object r0 = r0.mo19734c()
            r10 = r0
            android.hardware.Camera r10 = (android.hardware.Camera) r10
            if (r9 == 0) goto L_0x0349
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r0 == 0) goto L_0x01ff
            if (r10 != 0) goto L_0x01ff
            goto L_0x0349
        L_0x01ff:
            r52.m9444az()
            r52.m9442ax()
            r52.m9443ay()
            java.lang.reflect.Method r0 = f8724ar     // Catch:{ Exception -> 0x0336 }
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0336 }
            java.lang.Object r1 = r15.f8762aj     // Catch:{ Exception -> 0x0336 }
            r2[r13] = r1     // Catch:{ Exception -> 0x0336 }
            r0.invoke(r9, r2)     // Catch:{ Exception -> 0x0336 }
            com.meizu.media.camera.camcontroller.b$l r0 = new com.meizu.media.camera.camcontroller.b$l
            r1 = r0
            r2 = r52
            r3 = r11
            r4 = r14
            r5 = r31
            r6 = r24
            r7 = r22
            r8 = r23
            r38 = r9
            r39 = r10
            r9 = r26
            r40 = r11
            r11 = r28
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11)
            r15.f8749aG = r0
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14042l
            if (r0 == 0) goto L_0x02af
            android.hardware.Camera$Parameters r0 = r39.getParameters()
            r11 = r31
            r0.setRotation(r11)
            r10 = r39
            r10.setParameters(r0)
            com.meizu.media.camera.camcontroller.b$33 r0 = new com.meizu.media.camera.camcontroller.b$33
            r1 = r0
            r2 = r52
            r3 = r38
            r4 = r40
            r5 = r14
            r6 = r11
            r7 = r24
            r8 = r22
            r9 = r23
            r41 = r10
            r10 = r26
            r12 = r28
            r15 = 0
            r13 = r16
            r42 = r14
            r14 = r25
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14)
            java.lang.Void[] r1 = new java.lang.Void[r15]
            r0.mo22614c((Params[]) r1)
            java.lang.reflect.Method r0 = f8722ap     // Catch:{ Exception -> 0x028f }
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x028f }
            r3 = 0
            r15 = r52
            java.lang.Object r4 = r15.f8760ah     // Catch:{ Exception -> 0x028b }
            r2[r3] = r4     // Catch:{ Exception -> 0x028b }
            r4 = r41
            r0.invoke(r4, r2)     // Catch:{ Exception -> 0x0289 }
            java.lang.reflect.Method r0 = f8725as     // Catch:{ Exception -> 0x0289 }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0289 }
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13917bQ     // Catch:{ Exception -> 0x0289 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0289 }
            r2[r3] = r1     // Catch:{ Exception -> 0x0289 }
            r0.invoke(r4, r2)     // Catch:{ Exception -> 0x0289 }
            goto L_0x0297
        L_0x0289:
            r0 = move-exception
            goto L_0x0294
        L_0x028b:
            r0 = move-exception
            r4 = r41
            goto L_0x0294
        L_0x028f:
            r0 = move-exception
            r4 = r41
            r15 = r52
        L_0x0294:
            r0.printStackTrace()
        L_0x0297:
            r14 = 0
            r4.takePicture(r14, r14, r14, r14)
            int r0 = f8275g
            r1 = 1
            int r0 = r0 + r1
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r1
            f8274f = r0
            r13 = r40
            r12 = r42
            r15.m9412a((java.util.UUID) r13, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r12, (boolean) r1)
            goto L_0x0334
        L_0x02af:
            r11 = r31
            r13 = r40
            r1 = 1
            r3 = 0
            r51 = r14
            r14 = r12
            r12 = r51
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14043m
            if (r0 == 0) goto L_0x0334
            java.lang.reflect.Method r0 = f8721ao     // Catch:{ Exception -> 0x02db }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02db }
            java.lang.Object r4 = r15.f8759ag     // Catch:{ Exception -> 0x02db }
            r2[r3] = r4     // Catch:{ Exception -> 0x02db }
            r9 = r38
            r0.invoke(r9, r2)     // Catch:{ Exception -> 0x02d9 }
            java.lang.reflect.Method r0 = f8725as     // Catch:{ Exception -> 0x02d9 }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02d9 }
            int r1 = com.meizu.media.camera.util.DeviceHelper.f13915bO     // Catch:{ Exception -> 0x02d9 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x02d9 }
            r2[r3] = r1     // Catch:{ Exception -> 0x02d9 }
            r0.invoke(r9, r2)     // Catch:{ Exception -> 0x02d9 }
            goto L_0x02e1
        L_0x02d9:
            r0 = move-exception
            goto L_0x02de
        L_0x02db:
            r0 = move-exception
            r9 = r38
        L_0x02de:
            r0.printStackTrace()
        L_0x02e1:
            com.meizu.media.camera.camcontroller.b$j r0 = new com.meizu.media.camera.camcontroller.b$j
            r17 = 1
            r1 = r0
            r2 = r52
            r3 = r13
            r4 = r12
            r5 = r11
            r6 = r24
            r7 = r22
            r8 = r23
            r14 = r9
            r9 = r26
            r29 = r11
            r11 = r17
            r43 = r12
            r12 = r28
            r44 = r13
            r13 = r16
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13)
            com.meizu.media.camera.camcontroller.b$i r13 = new com.meizu.media.camera.camcontroller.b$i
            r12 = 0
            r1 = r13
            r3 = r44
            r4 = r43
            r5 = r25
            r6 = r22
            r7 = r23
            r8 = r29
            r11 = r24
            r15 = r13
            r13 = r28
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13)
            r9 = 0
            r14.takePicture(r0, r9, r9, r15)
            int r0 = f8275g
            r15 = 1
            int r0 = r0 + r15
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r15
            f8274f = r0
            r8 = r43
            r14 = r44
            r10 = r52
            r10.m9412a((java.util.UUID) r14, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r8, (boolean) r15)
            goto L_0x036a
        L_0x0334:
            r10 = r15
            goto L_0x036a
        L_0x0336:
            r0 = move-exception
            r10 = r15
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.String r2 = "Reflect stereo error"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.util.ac$a r1 = f8728p
            java.lang.String r0 = r0.getMessage()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r0)
            return
        L_0x0349:
            r14 = r9
            r4 = r10
            r10 = r15
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "main or sub camera device is null!!! mainCamera:"
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = "   subCamera:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
        L_0x036a:
            r2 = r10
            goto L_0x0537
        L_0x036d:
            r9 = r12
            r8 = r14
            r10 = r15
            r29 = r31
            r15 = 1
            r14 = r11
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL
            if (r0 != r1) goto L_0x0414
            com.meizu.media.camera.util.ac$a r0 = f8728p
            java.lang.String r1 = "takeStereoPicture in 813"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.String r1 = "send takeStereoPicture to HAL success!"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.b$q r0 = new com.meizu.media.camera.camcontroller.b$q
            r1 = r0
            r11 = 0
            r12 = 0
            java.lang.String r13 = "none"
            r16 = 0
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r2 = r52
            r3 = r14
            r4 = r8
            r5 = r25
            r6 = r22
            r7 = r23
            r45 = r8
            r8 = r29
            r21 = r9
            r9 = r26
            r46 = r14
            r14 = r24
            r15 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r15 = r52
            com.meizu.media.camera.stereobokeh.a r1 = r15.f8282h
            if (r1 == 0) goto L_0x03bf
            com.meizu.media.camera.stereobokeh.a r1 = r15.f8282h
            r1.mo21446a((android.hardware.Camera.PictureCallback) r0)
        L_0x03bf:
            com.meizu.media.camera.camcontroller.e r14 = r15.f8769q
            com.meizu.media.camera.b$a r1 = r15.f8281e
            android.os.Handler r16 = r1.mo19058d()
            com.meizu.media.camera.camcontroller.b$n r17 = new com.meizu.media.camera.camcontroller.b$n
            r11 = 1
            r12 = 0
            r13 = 0
            r18 = 0
            r1 = r17
            r2 = r52
            r3 = r46
            r4 = r45
            r5 = r29
            r6 = r24
            r7 = r22
            r8 = r23
            r9 = r26
            r19 = r14
            r14 = r18
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14)
            com.meizu.media.camera.camcontroller.b$m r12 = new com.meizu.media.camera.camcontroller.b$m
            r14 = 0
            r12.<init>()
            com.meizu.media.camera.camcontroller.b$k r13 = new com.meizu.media.camera.camcontroller.b$k
            r1 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11)
            r2 = r19
            r3 = r16
            r4 = r17
            r5 = r12
            r6 = r13
            r7 = r0
            r2.mo19737a((android.os.Handler) r3, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2019c) r4, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r5, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r6, (android.hardware.Camera.PictureCallback) r7)
            int r0 = f8275g
            r13 = 1
            int r0 = r0 + r13
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r13
            f8274f = r0
            r11 = r45
            r12 = r46
            r15.m9412a((java.util.UUID) r12, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r11, (boolean) r13)
        L_0x0411:
            r2 = r15
            goto L_0x0537
        L_0x0414:
            r11 = r8
            r15 = r10
            r12 = r14
            r13 = 1
            r14 = r9
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE
            if (r0 != r1) goto L_0x04a4
            com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.String r1 = "send takeStereoPicture to HAL success!"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.e r0 = r15.f8769q
            com.meizu.media.camera.b$a r1 = r15.f8281e
            android.os.Handler r30 = r1.mo19058d()
            com.meizu.media.camera.camcontroller.b$j r31 = new com.meizu.media.camera.camcontroller.b$j
            r17 = 1
            r1 = r31
            r2 = r52
            r3 = r12
            r4 = r11
            r5 = r29
            r6 = r24
            r7 = r22
            r8 = r23
            r9 = r26
            r47 = r11
            r11 = r17
            r48 = r12
            r12 = r28
            r13 = r16
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13)
            com.meizu.media.camera.camcontroller.b$m r9 = new com.meizu.media.camera.camcontroller.b$m
            r9.<init>()
            r32 = 0
            com.meizu.media.camera.camcontroller.b$g r33 = new com.meizu.media.camera.camcontroller.b$g
            r1 = r33
            r11 = 0
            r12 = 0
            java.lang.String r13 = "none"
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            r3 = r48
            r4 = r47
            r5 = r25
            r6 = r22
            r7 = r23
            r8 = r29
            r22 = r9
            r9 = r26
            r14 = r24
            r15 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2 = r0
            r3 = r30
            r4 = r31
            r5 = r22
            r6 = r32
            r7 = r33
            r2.mo19738a((android.os.Handler) r3, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2019c) r4, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r5, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r6, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r7)
            int r0 = f8275g
            r15 = 1
            int r0 = r0 + r15
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r15
            f8274f = r0
            r11 = r47
            r12 = r48
            r13 = r52
            r13.m9412a((java.util.UUID) r12, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r11, (boolean) r15)
        L_0x04a1:
            r2 = r13
            goto L_0x0537
        L_0x04a4:
            r13 = r15
            r15 = 1
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG
            if (r0 != r1) goto L_0x04a1
            com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.String r1 = "send takeStereoPicture to HAL success!"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.e r0 = r13.f8769q
            com.meizu.media.camera.b$a r1 = r13.f8281e
            android.os.Handler r30 = r1.mo19058d()
            com.meizu.media.camera.camcontroller.b$j r31 = new com.meizu.media.camera.camcontroller.b$j
            r17 = 1
            r1 = r31
            r2 = r52
            r3 = r12
            r4 = r11
            r5 = r29
            r6 = r24
            r7 = r22
            r8 = r23
            r9 = r26
            r49 = r11
            r11 = r17
            r50 = r12
            r12 = r28
            r14 = r13
            r13 = r16
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13)
            com.meizu.media.camera.camcontroller.b$m r13 = new com.meizu.media.camera.camcontroller.b$m
            r1 = 0
            r13.<init>()
            com.meizu.media.camera.camcontroller.b$k r32 = new com.meizu.media.camera.camcontroller.b$k
            r11 = 1
            r1 = r32
            r3 = r50
            r4 = r49
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r11)
            com.meizu.media.camera.camcontroller.b$g r33 = new com.meizu.media.camera.camcontroller.b$g
            r1 = r33
            r11 = 0
            r12 = 0
            java.lang.String r2 = "none"
            r34 = r13
            r13 = r2
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            r2 = r52
            r5 = r25
            r6 = r22
            r7 = r23
            r8 = r29
            r14 = r24
            r15 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2 = r0
            r3 = r30
            r4 = r31
            r5 = r34
            r6 = r32
            r7 = r33
            r2.mo19738a((android.os.Handler) r3, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2019c) r4, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r5, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r6, (com.meizu.media.camera.camcontroller.CameraProxyV1.C2018b) r7)
            int r0 = f8275g
            r1 = 1
            int r0 = r0 + r1
            f8275g = r0
            int r0 = f8274f
            int r0 = r0 + r1
            f8274f = r0
            r4 = r49
            r3 = r50
            r2 = r52
            r2.m9412a((java.util.UUID) r3, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r4, (boolean) r1)
        L_0x0537:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraControllerV1.mo19523k(android.content.Intent):void");
    }

    /* renamed from: m */
    public void mo19527m(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2816, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            final UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            final Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            LogUtil.m15942a(f8728p, "takeBurstPicture");
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8876a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8876a, false, 2910, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8288n == CameraController.BurstCaptureState.IDLE) {
                        CameraControllerV1.this.f8769q.mo19736a(CameraControllerV1.this.f8745aC, CameraControllerV1.this.f8746aD, CameraControllerV1.this.f8747aE, CameraControllerV1.this.f8748aF, (MeizuCamera.MeizuCameraContinuousCallback) new C1991b(uuid, requestCode));
                        CameraControllerV1.this.f8288n = CameraController.BurstCaptureState.BURST_CAPTURE_START;
                        boolean unused = CameraControllerV1.this.f8771u = true;
                    }
                }
            });
            this.f8279c.mo19553a();
            if (this.f8771u) {
                m9412a(uuid, requestCode, true);
            } else {
                this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
            }
            while (this.f8771u && !this.f8281e.mo19051a(false) && !this.f8281e.mo19063i()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            f8275g = 0;
            f8274f = 0;
            this.f8771u = false;
        }
    }

    /* renamed from: n */
    public void mo19529n(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2817, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            this.f8279c.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f8880a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f8880a, false, 2911, new Class[0], Void.TYPE).isSupported) {
                        if (CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                            CameraControllerV1.this.f8769q.mo19741g().cancelContinuousShot();
                        }
                        CameraControllerV1.this.f8288n = CameraController.BurstCaptureState.BURST_CAPTURE_STOP;
                    }
                }
            });
            this.f8279c.mo19553a();
        }
    }

    /* renamed from: H */
    public boolean mo19444H() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2818, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Log.d("while", "hasBackgroundTask sCapturingTaskNum:" + f8275g + "  mFocusing:" + this.f8772v);
        if (f8275g > 0 || this.f8772v) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public synchronized void mo19465a(CameraController.BurstCaptureState burstCaptureState) {
        this.f8288n = burstCaptureState;
    }

    /* renamed from: X */
    public void mo19446X() {
        this.f8773w = false;
    }

    /* renamed from: o */
    public void mo19531o(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2819, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            if (this.f8773w) {
                LogUtil.m15952c(f8728p, "Face detection is already running");
                return;
            }
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (this.f8769q != null) {
                CameraController<T>.e i = CameraController.m8868g().mo19518i();
                i.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8882a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8882a, false, 2912, new Class[0], Void.TYPE).isSupported) {
                            boolean unused = CameraControllerV1.this.f8773w = true;
                            ((Camera) CameraControllerV1.this.f8769q.mo19730a()).startFaceDetection();
                        }
                    }
                });
                i.mo19553a();
                if (this.f8281e != null) {
                    this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                }
            } else if (this.f8281e != null) {
                this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            }
        }
    }

    /* renamed from: p */
    public void mo19533p(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8727o, false, 2820, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            if (!this.f8773w) {
                LogUtil.m15952c(f8728p, "Face detection is already stopped");
                return;
            }
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (this.f8769q != null) {
                CameraController<T>.e i = CameraController.m8868g().mo19518i();
                i.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8884a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8884a, false, 2913, new Class[0], Void.TYPE).isSupported) {
                            ((Camera) CameraControllerV1.this.f8769q.mo19730a()).setFaceDetectionListener((Camera.FaceDetectionListener) null);
                            ((Camera) CameraControllerV1.this.f8769q.mo19730a()).stopFaceDetection();
                            boolean unused = CameraControllerV1.this.f8773w = false;
                        }
                    }
                });
                i.mo19553a();
                if (this.f8281e != null) {
                    this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                }
            } else if (this.f8281e != null) {
                this.f8281e.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private void m9403a(Camera.Parameters parameters) {
        if (!PatchProxy.proxy(new Object[]{parameters}, this, f8727o, false, 2821, new Class[]{Camera.Parameters.class}, Void.TYPE).isSupported) {
            if (this.f8754ab == null) {
                this.f8754ab = new StereoInfoAccessor();
            }
            try {
                if (f8715Q == null) {
                    f8715Q = Camera.class.getMethod("setProperty", new Class[]{String.class, String.class});
                }
                try {
                    if (f8703C == null) {
                        f8703C = Class.forName("android.hardware.Camera$StereoCameraWarningCallback");
                    }
                    if (f8704D == null) {
                        f8704D = f8703C.getMethod("onWarning", new Class[]{Integer.TYPE});
                    }
                    if (this.f8733E == null) {
                        this.f8733E = Proxy.newProxyInstance(f8703C.getClassLoader(), new Class[]{f8703C}, new C2009o());
                    }
                    try {
                        if (f8705F == null) {
                            f8705F = Class.forName("android.hardware.Camera$StereoCameraDataCallback");
                        }
                        if (f8706G == null) {
                            f8706G = f8705F.getMethod("onJpsCapture", new Class[]{byte[].class});
                        }
                        if (f8707H == null) {
                            f8707H = f8705F.getMethod("onMaskCapture", new Class[]{byte[].class});
                        }
                        if (f8708I == null) {
                            f8708I = f8705F.getMethod("onDepthMapCapture", new Class[]{byte[].class});
                        }
                        if (f8709J == null) {
                            f8709J = f8705F.getMethod("onClearImageCapture", new Class[]{byte[].class});
                        }
                        if (f8710K == null) {
                            f8710K = f8705F.getMethod("onLdcCapture", new Class[]{byte[].class});
                        }
                        if (f8711L == null) {
                            f8711L = f8705F.getMethod("onN3dCapture", new Class[]{byte[].class});
                        }
                        if (f8712M == null) {
                            f8712M = f8705F.getMethod("onDepthWrapperCapture", new Class[]{byte[].class});
                        }
                        if (this.f8734N == null) {
                            this.f8734N = Proxy.newProxyInstance(f8705F.getClassLoader(), new Class[]{f8705F}, new C2009o());
                        }
                        try {
                            if (f8713O == null) {
                                f8713O = Camera.class.getMethod("setStereoCameraWarningCallback", new Class[]{f8703C});
                            }
                            if (f8714P == null) {
                                f8714P = Camera.class.getMethod("setStereoCameraDataCallback", new Class[]{f8705F});
                            }
                            if (f8715Q == null) {
                                f8715Q = Camera.class.getMethod("setProperty", new Class[]{String.class, String.class});
                            }
                            try {
                                if (f8716R == null && parameters != null) {
                                    f8716R = parameters.getClass().getMethod("setCameraMode", new Class[]{Integer.TYPE});
                                }
                            } catch (Exception e) {
                                LogUtil.m15942a(f8728p, "Reflect setCameraMode error");
                                LogUtil.m15942a(f8728p, e.getMessage());
                            }
                        } catch (Exception e2) {
                            LogUtil.m15942a(f8728p, "Reflect setProperty error");
                            LogUtil.m15942a(f8728p, e2.getMessage());
                        }
                    } catch (Exception e3) {
                        LogUtil.m15942a(f8728p, "Reflect stereo error");
                        LogUtil.m15942a(f8728p, e3.getMessage());
                    }
                } catch (Exception e4) {
                    LogUtil.m15942a(f8728p, "Reflect stereo error");
                    LogUtil.m15942a(f8728p, e4.getMessage());
                }
            } catch (Exception e5) {
                LogUtil.m15942a(f8728p, "Reflect setProperty error");
                LogUtil.m15942a(f8728p, e5.getMessage());
            }
        }
    }

    /* renamed from: aw */
    private void m9441aw() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2822, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f8757ae == null) {
                    this.f8757ae = Class.forName("android.hardware.Camera$DualCamCalCallback");
                }
                if (f8719am == null) {
                    f8719am = this.f8757ae.getMethod("onDualCamCalCallback", new Class[]{byte[].class, Camera.class});
                }
                if (this.f8761ai == null) {
                    this.f8761ai = Proxy.newProxyInstance(this.f8757ae.getClassLoader(), new Class[]{this.f8757ae}, new C2009o());
                }
                if (f8723aq == null) {
                    f8723aq = Camera.class.getMethod("setDualCamCalCb", new Class[]{this.f8757ae});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: ax */
    private void m9442ax() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2823, new Class[0], Void.TYPE).isSupported) {
            try {
                if (f8725as == null) {
                    f8725as = Camera.class.getMethod("addYuvImageCallbackBuffer", new Class[]{byte[].class});
                }
            } catch (NoSuchMethodException e) {
                LogUtil.m15942a(f8728p, "Reflect YuvBuffer error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: ay */
    private void m9443ay() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2824, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f8756ad == null) {
                    this.f8756ad = Class.forName("android.hardware.Camera$YuvCallback");
                }
                if (f8718al == null) {
                    f8718al = this.f8756ad.getMethod("onYuvCallback", new Class[]{byte[].class, Camera.class});
                }
                if (this.f8760ah == null) {
                    this.f8760ah = Proxy.newProxyInstance(this.f8756ad.getClassLoader(), new Class[]{this.f8756ad}, new C2012r());
                }
                if (f8722ap == null) {
                    f8722ap = Camera.class.getMethod("setYuvCb", new Class[]{this.f8756ad});
                }
            } catch (Exception e) {
                LogUtil.m15942a(f8728p, "Reflect subYuv error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: az */
    private void m9444az() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2825, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f8755ac == null) {
                    this.f8755ac = Class.forName("android.hardware.Camera$YuvCallback");
                }
                if (this.f8758af == null) {
                    this.f8758af = Class.forName("android.hardware.Camera$DualCamMetaDataCallback");
                }
                if (f8717ak == null) {
                    f8717ak = this.f8755ac.getMethod("onYuvCallback", new Class[]{byte[].class, Camera.class});
                }
                if (f8720an == null) {
                    f8720an = this.f8758af.getMethod("onDualCamMetaDataCallback", new Class[]{byte[].class, Camera.class});
                }
                if (this.f8759ag == null) {
                    this.f8759ag = Proxy.newProxyInstance(this.f8755ac.getClassLoader(), new Class[]{this.f8755ac}, new C2009o());
                }
                if (this.f8762aj == null) {
                    this.f8762aj = Proxy.newProxyInstance(this.f8758af.getClassLoader(), new Class[]{this.f8758af}, new C2009o());
                }
                if (f8721ao == null) {
                    f8721ao = Camera.class.getMethod("setYuvCb", new Class[]{this.f8755ac});
                }
                if (f8724ar == null) {
                    f8724ar = Camera.class.getMethod("setDualCamMetaDataCb", new Class[]{this.f8758af});
                }
            } catch (Exception e) {
                LogUtil.m15942a(f8728p, "Reflect QuaDual error");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: aA */
    private void m9420aA() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2826, new Class[0], Void.TYPE).isSupported) {
            if (!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                LogUtil.m15949b(f8728p, "Only Camera API V1 supported!");
                return;
            }
            m9441aw();
            try {
                f8723aq.invoke(CameraController.m8868g().mo19522k().mo19730a(), new Object[]{this.f8761ai});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m9408a(CameraModeType.ModeType modeType, boolean z, boolean z2) {
        String str;
        Camera.Parameters parameters;
        if (!PatchProxy.proxy(new Object[]{modeType, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f8727o, false, 2827, new Class[]{CameraModeType.ModeType.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13839S) {
            if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES) {
                str = (!CameraModeType.ModeType.AUTO.equals(modeType) || !z2) ? (!CameraModeType.ModeType.PORTRAIT.equals(modeType) || !z2) ? "Default" : "MtkStereo" : "MtkDualCam";
            } else if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY || DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
                str = (!CameraModeType.ModeType.PORTRAIT.equals(modeType) || !z2) ? "" : "MtkStereo";
            } else {
                str = null;
            }
            if (CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
                CameraProxyV1 eVar = (CameraProxyV1) CameraController.m8868g().mo19522k();
                if (eVar == null) {
                    parameters = null;
                } else {
                    parameters = eVar.mo19740f();
                }
                m9403a(parameters);
            }
            LogUtil.m15952c(f8728p, "setProperty + appModeValue:" + str);
            try {
                f8715Q.invoke((Object) null, new Object[]{"client.appmode", str});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            LogUtil.m15952c(f8728p, "setProperty -");
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$o */
    /* compiled from: CameraControllerV1 */
    private class C2009o implements Serializable, InvocationHandler {

        /* renamed from: a */
        public static ChangeQuickRedirect f9059a = null;
        private static final long serialVersionUID = 1;

        private C2009o() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, method, objArr}, this, f9059a, false, 2950, new Class[]{Object.class, Method.class, Object[].class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            if (method.equals(CameraControllerV1.f8704D)) {
                CameraControllerV1.this.m9459e(objArr[0].intValue());
                return null;
            } else if (method.equals(CameraControllerV1.f8706G)) {
                CameraControllerV1.this.m9447b(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8707H)) {
                CameraControllerV1.this.m9451c(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8708I)) {
                CameraControllerV1.this.m9455d(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8709J)) {
                CameraControllerV1.this.m9461e(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8710K)) {
                CameraControllerV1.this.m9464f(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8711L)) {
                CameraControllerV1.this.m9467g(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8712M)) {
                CameraControllerV1.this.m9470h(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8717ak)) {
                CameraControllerV1.this.m9473i(objArr[0]);
                return null;
            } else if (method.equals(CameraControllerV1.f8719am)) {
                CameraControllerV1.this.m9478k(objArr[0]);
                return null;
            } else if (!method.equals(CameraControllerV1.f8720an)) {
                return null;
            } else {
                CameraControllerV1.this.m9480l(objArr[0]);
                return null;
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$r */
    /* compiled from: CameraControllerV1 */
    private class C2012r implements Serializable, InvocationHandler {

        /* renamed from: a */
        public static ChangeQuickRedirect f9084a;

        private C2012r() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, method, objArr}, this, f9084a, false, 2953, new Class[]{Object.class, Method.class, Object[].class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            if (!method.equals(CameraControllerV1.f8718al)) {
                return null;
            }
            CameraControllerV1.this.m9476j(objArr[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9459e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2828, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onWarning type = " + i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9447b(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2829, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "JPS data is null");
                return;
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onJpsCapture jpsData:" + bArr.length);
            this.f8736T = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9451c(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2830, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "Mask data is null");
                return;
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onMaskCapture maskData:" + bArr.length);
            this.f8737U = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9455d(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2831, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "depth data is null");
                return;
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onDepthMapCapture depthData:" + bArr.length);
            this.f8738V = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9461e(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2832, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (bArr == null) {
                LogUtil.m15952c(f8728p, " clearImage data is null");
                return;
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onClearImageCapture clearImageData:" + bArr.length);
            this.f8739W = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9464f(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2833, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            if (bArr == null) {
                LogUtil.m15952c(f8728p, " ldc data is null");
                return;
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "onLdcCapture ldcData:" + bArr.length);
            this.f8740X = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m9467g(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2834, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            this.f8742Z = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m9470h(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2835, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            this.f8753aa = bArr;
            m9421aB();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m9473i(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2836, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "onYuvCaptureCb");
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "yuv data is null");
                return;
            }
            this.f8763at = bArr;
            if (this.f8749aG != null) {
                this.f8749aG.mo19723a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m9476j(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2837, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "onSubYuvCaptureCb");
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "sub yuv data is null");
            } else {
                this.f8764au = bArr;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m9478k(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2838, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f8728p, "onDualCamCaptureCb");
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "dual cam data is null");
            } else {
                f8726av = bArr;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m9480l(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f8727o, false, 2839, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8728p, "onDualCamMetaDataCaptureCb");
            if (bArr == null) {
                LogUtil.m15952c(f8728p, "dual cam meta data is null");
            } else {
                this.f8765aw = bArr;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x018d, code lost:
        return;
     */
    /* renamed from: aB */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m9421aB() {
        /*
            r22 = this;
            r15 = r22
            monitor-enter(r22)
            r8 = 0
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ all -> 0x018e }
            com.meizu.savior.ChangeQuickRedirect r3 = f8727o     // Catch:{ all -> 0x018e }
            r4 = 0
            r5 = 2840(0xb18, float:3.98E-42)
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ all -> 0x018e }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x018e }
            r2 = r22
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x018e }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x001b
            monitor-exit(r22)
            return
        L_0x001b:
            com.meizu.media.camera.b$a r0 = r15.f8281e     // Catch:{ all -> 0x018e }
            java.util.Queue r0 = r0.mo19059e()     // Catch:{ all -> 0x018e }
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x018e }
            android.content.Intent r0 = (android.content.Intent) r0     // Catch:{ all -> 0x018e }
            if (r0 != 0) goto L_0x0034
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "mStereoCaptureIntents.peek() return null, capture may be end!!"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            r15.f8750aH = r8     // Catch:{ all -> 0x018e }
            monitor-exit(r22)
            return
        L_0x0034:
            int r0 = r15.f8750aH     // Catch:{ all -> 0x018e }
            r14 = 1
            int r0 = r0 + r14
            r15.f8750aH = r0     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r1.<init>()     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "notifyMergeData mCurrentNum = "
            r1.append(r2)     // Catch:{ all -> 0x018e }
            int r2 = r15.f8750aH     // Catch:{ all -> 0x018e }
            r1.append(r2)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)     // Catch:{ all -> 0x018e }
            r0 = 6
            int r1 = r15.f8750aH     // Catch:{ all -> 0x018e }
            if (r1 != r0) goto L_0x018c
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "notifyMergeData start preview +"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "notifyMergeData start preview -"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.b$a r0 = r15.f8281e     // Catch:{ all -> 0x018e }
            java.util.Queue r0 = r0.mo19059e()     // Catch:{ all -> 0x018e }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x018e }
            android.content.Intent r0 = (android.content.Intent) r0     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "requestCode"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)     // Catch:{ all -> 0x018e }
            r13 = r1
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r13 = (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r13     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "uuid"
            java.io.Serializable r1 = r0.getSerializableExtra(r1)     // Catch:{ all -> 0x018e }
            r12 = r1
            java.util.UUID r12 = (java.util.UUID) r12     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "location"
            android.os.Parcelable r1 = r0.getParcelableExtra(r1)     // Catch:{ all -> 0x018e }
            r9 = r1
            android.location.Location r9 = (android.location.Location) r9     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "width"
            int r10 = r0.getIntExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "height"
            int r11 = r0.getIntExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "jpegRotation"
            int r16 = r0.getIntExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "isImageCaptureIntent"
            boolean r17 = r0.getBooleanExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "mirror"
            boolean r18 = r0.getBooleanExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "deviceMark"
            boolean r19 = r0.getBooleanExtra(r1, r8)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "captureStartTime"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018e }
            long r5 = r0.getLongExtra(r1, r2)     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r1.<init>()     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "notifymergedata date is : "
            r1.append(r2)     // Catch:{ all -> 0x018e }
            r1.append(r5)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            java.lang.String r7 = com.meizu.media.camera.util.CameraUtil.m15874b((long) r5)     // Catch:{ all -> 0x018e }
            com.mediatek.accessor.data.StereoCaptureInfo r1 = new com.mediatek.accessor.data.StereoCaptureInfo     // Catch:{ all -> 0x018e }
            r1.<init>()     // Catch:{ all -> 0x018e }
            r1.debugDir = r7     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8736T     // Catch:{ all -> 0x018e }
            r1.jpsBuffer = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8735S     // Catch:{ all -> 0x018e }
            r1.jpgBuffer = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8737U     // Catch:{ all -> 0x018e }
            r1.configBuffer = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8739W     // Catch:{ all -> 0x018e }
            r1.clearImage = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8738V     // Catch:{ all -> 0x018e }
            r1.depthMap = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8740X     // Catch:{ all -> 0x018e }
            r1.ldc = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8742Z     // Catch:{ all -> 0x018e }
            r1.debugBuffer = r0     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8753aa     // Catch:{ all -> 0x018e }
            r1.depthBuffer = r0     // Catch:{ all -> 0x018e }
            r0 = 0
        L_0x00fc:
            int r2 = r0 + 1
            r3 = 3
            if (r0 >= r3) goto L_0x014e
            com.mediatek.accessor.StereoInfoAccessor r0 = r15.f8754ab     // Catch:{ OutOfMemoryError -> 0x010a }
            byte[] r0 = r0.writeStereoCaptureInfo(r1)     // Catch:{ OutOfMemoryError -> 0x010a }
            r15.f8741Y = r0     // Catch:{ OutOfMemoryError -> 0x010a }
            goto L_0x014e
        L_0x010a:
            if (r2 != r3) goto L_0x012c
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "Memory is not enough!!"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r3)     // Catch:{ all -> 0x018e }
            int r0 = f8275g     // Catch:{ all -> 0x018e }
            if (r0 <= 0) goto L_0x0123
            int r0 = f8275g     // Catch:{ all -> 0x018e }
            int r0 = r0 - r14
            f8275g = r0     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.b$a r0 = r15.f8281e     // Catch:{ all -> 0x018e }
            int r3 = f8275g     // Catch:{ all -> 0x018e }
            r0.mo19041a((int) r3)     // Catch:{ all -> 0x018e }
        L_0x0123:
            com.meizu.media.camera.b$a r0 = r15.f8281e     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r3 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED     // Catch:{ all -> 0x018e }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x018e }
            r0.mo19045a(r12, r13, r3, r4)     // Catch:{ all -> 0x018e }
        L_0x012c:
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x018e }
            r0.gc()     // Catch:{ all -> 0x018e }
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x018e }
            r0.runFinalization()     // Catch:{ all -> 0x018e }
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x018e }
            r0.gc()     // Catch:{ all -> 0x018e }
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0147 }
            goto L_0x014c
        L_0x0147:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()     // Catch:{ all -> 0x018e }
        L_0x014c:
            r0 = r2
            goto L_0x00fc
        L_0x014e:
            r15.f8750aH = r8     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.ac$a r0 = f8728p     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r1.<init>()     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "notifyMergeData mXmpJpegData: "
            r1.append(r2)     // Catch:{ all -> 0x018e }
            byte[] r2 = r15.f8741Y     // Catch:{ all -> 0x018e }
            r1.append(r2)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018e }
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)     // Catch:{ all -> 0x018e }
            byte[] r0 = r15.f8741Y     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x018c
            byte[] r4 = r15.f8741Y     // Catch:{ all -> 0x018e }
            r1 = r22
            r2 = r12
            r3 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r16
            r20 = r12
            r12 = r17
            r21 = r13
            r13 = r18
            r14 = r19
            r1.m9414a(r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x018e }
            r2 = r20
            r1 = r21
            r3 = 1
            r15.m9412a((java.util.UUID) r2, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r1, (boolean) r3)     // Catch:{ all -> 0x018e }
        L_0x018c:
            monitor-exit(r22)
            return
        L_0x018e:
            r0 = move-exception
            monitor-exit(r22)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraControllerV1.m9421aB():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9411a(UUID uuid, Contants.CameraService.RequestCode requestCode, String str, String str2, boolean z) {
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        if (!PatchProxy.proxy(new Object[]{uuid2, requestCode2, str3, str4, new Byte(z2 ? (byte) 1 : 0)}, this, f8727o, false, 2841, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, String.class, String.class, Boolean.TYPE}, Void.TYPE).isSupported && f8275g != 0) {
            Uri uri = null;
            Storage.m7750a().mo18626a(z2, str4);
            if (!(f8726av == null || this.f8765aw == null || this.f8763at == null)) {
                LogUtil.m15942a(f8728p, "start save dual date");
                Storage.m7750a().mo18627a(1, f8726av, str3);
                Storage.m7750a().mo18627a(2, this.f8765aw, str3);
                if (this.f8764au != null) {
                    Storage.m7750a().mo18627a(3, this.f8763at, str3);
                    Storage.m7750a().mo18627a(4, this.f8764au, str3);
                } else {
                    Storage.m7750a().mo18633a(this.f8763at, str3);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (uri != null) {
                    break;
                } else if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    LogUtil.m15942a(f8728p, "spending too much time for getting thumbBitmapUri");
                    break;
                } else {
                    uri = Storage.m7750a().mo18636b();
                }
            }
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15942a(aVar, "saveDualData: " + uri + "---" + str3);
            Intent intent = new Intent("com.meizu.media.imageservice.ARC_REFOCUS_REQUEST", uri);
            intent.setPackage("com.meizu.media.imageservice");
            intent.putExtra("dataFileUri", str3);
            intent.setFlags(32);
            this.f8286l.startService(intent);
            this.f8281e.mo19059e().poll();
            String a = Storage.m7750a().mo18626a(z2, str4);
            if (uri != null) {
                this.f8281e.mo19045a(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED, uri);
                this.f8281e.mo19045a(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED, a);
            }
        }
    }

    /* renamed from: a */
    private void m9414a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, long j, String str, Location location, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        int i5;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        int i6 = i3;
        boolean z4 = z;
        if (!PatchProxy.proxy(new Object[]{uuid2, requestCode2, bArr, new Long(j), str, location, new Integer(i), new Integer(i2), new Integer(i6), new Byte(z4 ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)}, this, f8727o, false, 2842, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, Long.TYPE, String.class, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8728p, "start saveStereoImage");
            ExifInterface a = Exif.m10044a(bArr);
            int a2 = Exif.m10043a(a);
            if ((i6 + a2) % 180 == 0) {
                i5 = i;
                i4 = i2;
            } else {
                i4 = i;
                i5 = i2;
            }
            if (z4) {
                if (f8275g > 0) {
                    f8275g--;
                    this.f8281e.mo19041a(f8275g);
                }
                this.f8281e.mo19045a(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_IMAGE_CAPTURE_INTENT_DONE, bArr, Long.valueOf(j), Integer.valueOf(i3));
                return;
            }
            this.f8281e.mo19046a(uuid, requestCode, bArr, str, j, location, i5, i4, a2, a, (XmpMetaData) null, z2, z3, i3, false, true, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9412a(UUID uuid, Contants.CameraService.RequestCode requestCode, boolean z) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, new Byte(z ? (byte) 1 : 0)}, this, f8727o, false, 2847, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            m9413a(uuid, requestCode, z, 0);
        }
    }

    /* renamed from: a */
    private void m9413a(UUID uuid, Contants.CameraService.RequestCode requestCode, boolean z, int i) {
        Object[] objArr = {uuid, requestCode, new Byte(z ? (byte) 1 : 0), new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2848, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, Boolean.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f8751aI != null) {
                this.f8281e.mo19058d().removeCallbacks(this.f8751aI);
            }
            if (z) {
                this.f8751aI = new C1993d(uuid, requestCode);
                this.f8281e.mo19058d().postDelayed(this.f8751aI, (long) (i + ViewDebugManagerImpl.INPUT_TIMEOUT));
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$d */
    /* compiled from: CameraControllerV1 */
    private class C1993d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f8950a;

        /* renamed from: c */
        private UUID f8952c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f8953d;

        public C1993d(UUID uuid, Contants.CameraService.RequestCode requestCode) {
            this.f8952c = uuid;
            this.f8953d = requestCode;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f8950a, false, 2933, new Class[0], Void.TYPE).isSupported) {
                LogUtil.C2630a ah = CameraControllerV1.f8728p;
                LogUtil.m15942a(ah, "take pic timeout, cancel all take pic task  sCapturingTaskNum:" + CameraController.f8275g);
                if (CameraController.f8275g > 0) {
                    CameraController.f8275g = 0;
                    CameraController.f8274f = 0;
                    CamIntentTask.m7843j();
                    boolean unused = CameraControllerV1.this.f8771u = false;
                    CameraControllerV1.this.f8770t.clear();
                    byte[][] unused2 = CameraControllerV1.this.f8766ax = null;
                    CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                    CameraControllerV1.this.f8281e.mo19045a(this.f8952c, this.f8953d, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo19477a(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f8727o, false, 2849, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setAutoExposureLock(z);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setAutoExposureLock at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8886a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8886a, false, 2914, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: a */
    public void mo19474a(String str, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{str, zArr}, this, f8727o, false, 2850, new Class[]{String.class, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().set("auto-exposure", str);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setExposureMode at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8890a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8890a, false, 2915, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: b */
    public void mo19497b(boolean z, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), zArr}, this, f8727o, false, 2851, new Class[]{Boolean.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setAutoWhiteBalanceLock(z);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setAutoWhiteBalanceLock at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8892a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8892a, false, 2916, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: a */
    public void mo19455a(Location location, boolean... zArr) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{location, zArr}, this, f8727o, false, 2852, new Class[]{Location.class, boolean[].class}, Void.TYPE).isSupported) {
            if (this.f8769q != null) {
                synchronized (this.f8769q.f9129g) {
                    Camera.Parameters f = this.f8769q.mo19740f();
                    f.removeGpsData();
                    f.setGpsTimestamp(System.currentTimeMillis() / 1000);
                    if (location != null) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        if (latitude == 0.0d) {
                            if (longitude == 0.0d) {
                                z = false;
                            }
                        }
                        if (z) {
                            LogUtil.m15942a(f8728p, "Set gps location");
                            f.setGpsLatitude(latitude);
                            f.setGpsLongitude(longitude);
                            f.setGpsProcessingMethod(location.getProvider().toUpperCase());
                            if (location.hasAltitude()) {
                                f.setGpsAltitude(location.getAltitude());
                            } else {
                                f.setGpsAltitude(0.0d);
                            }
                            if (location.getTime() != 0) {
                                f.setGpsTimestamp(location.getTime() / 1000);
                            }
                        }
                    }
                }
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8894a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8894a, false, 2917, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: b */
    public void mo19490b(int i, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), zArr}, this, f8727o, false, 2853, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setRotation(i);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setRotation at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8896a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8896a, false, 2918, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: c */
    public void mo19501c(int i, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), zArr}, this, f8727o, false, 2854, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setZoom(i);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setZoom at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8898a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8898a, false, 2919, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: b */
    public List<String> mo19656b(boolean... zArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{zArr}, this, f8727o, false, 2855, new Class[]{boolean[].class}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f8769q != null) {
            return this.f8769q.mo19740f().getSupportedWhiteBalance();
        }
        return null;
    }

    /* renamed from: b */
    public void mo19495b(String str, boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{str, zArr}, this, f8727o, false, 2856, new Class[]{String.class, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setWhiteBalance(str);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setWhiteBalance at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8900a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8900a, false, 2921, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: b */
    public void mo19489b(int i, int i2, boolean... zArr) {
        Object[] objArr = {new Integer(i), new Integer(i2), zArr};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2857, new Class[]{Integer.TYPE, Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            try {
                if (this.f8769q != null) {
                    synchronized (this.f8769q.f9129g) {
                        this.f8769q.mo19740f().setJpegThumbnailSize(i, i2);
                    }
                }
            } catch (RuntimeException e) {
                LogUtil.m15942a(f8728p, "setJpegThumbnailSize at a wrong time!");
                e.printStackTrace();
            }
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                this.f8279c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8902a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8902a, false, 2922, new Class[0], Void.TYPE).isSupported && CameraControllerV1.this.f8769q != null) {
                            CameraControllerV1.this.f8769q.mo19742h();
                        }
                    }
                });
                this.f8279c.mo19553a();
            }
        }
    }

    /* renamed from: d */
    public int mo19505d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f8727o;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2858, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.orientation;
    }

    /* renamed from: a */
    public boolean mo19481a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8727o, false, 2859, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo19512f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2860, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : Camera.getNumberOfCameras();
    }

    /* renamed from: Y */
    public CameraController.HdrMode mo19447Y() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2861, new Class[0], CameraController.HdrMode.class);
        if (proxy.isSupported) {
            return (CameraController.HdrMode) proxy.result;
        }
        if (this.f8769q != null) {
            Camera.Parameters f = this.f8769q.mo19740f();
            if (DeviceHelper.f13839S) {
                z = MzCamParamsManager.f10479d.equals(f.get("cap-mode"));
            } else if (DeviceHelper.f13841U) {
                z = MzCamParamsManager.f10479d.equals(f.get("shot-mode"));
            } else if (DeviceHelper.f13840T) {
                z = MzCamParamsManager.f10479d.equals(f.getSceneMode());
            }
        }
        return z ? CameraController.HdrMode.ON : CameraController.HdrMode.OFF;
    }

    /* renamed from: a */
    public void mo19473a(String str, Object... objArr) {
        if (PatchProxy.proxy(new Object[]{str, objArr}, this, f8727o, false, 2862, new Class[]{String.class, Object[].class}, Void.TYPE).isSupported || str.equals(m9422aC())) {
            return;
        }
        if (DeviceHelper.f13839S) {
            mo19471a("cap-mode", str, new boolean[0]);
        } else if (DeviceHelper.f13841U) {
            if (objArr.length <= 0) {
                mo19471a("shot-mode", str, new boolean[0]);
            } else if (objArr[0].booleanValue()) {
                mo19471a(str, "1", new boolean[0]);
            } else {
                mo19471a(str, "0", new boolean[0]);
            }
        } else if (!DeviceHelper.f13840T) {
        } else {
            if (!MzCamParamsManager.f10481f.equals(str)) {
                mo19471a("scene-mode", str, new boolean[0]);
                LogUtil.C2630a aVar = f8728p;
                LogUtil.m15942a(aVar, "setCaptureMode setParameter scene-mode :" + str);
            } else if (objArr.length <= 0) {
            } else {
                if (objArr[0].booleanValue()) {
                    mo19471a("cap-mode", str, new boolean[0]);
                } else {
                    mo19471a("cap-mode", "null", new boolean[0]);
                }
            }
        }
    }

    /* renamed from: aC */
    private String m9422aC() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2863, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f8769q == null) {
            return null;
        }
        Camera.Parameters f = this.f8769q.mo19740f();
        if (DeviceHelper.f13839S) {
            return f.get("cap-mode");
        }
        if (DeviceHelper.f13841U) {
            return f.get("shot-mode");
        }
        return null;
    }

    /* renamed from: Z */
    public List<CameraController.FocusMode> mo19448Z() {
        List<String> supportedFocusModes;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2864, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f8769q == null || (supportedFocusModes = this.f8769q.mo19740f().getSupportedFocusModes()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String convertFocusMode : supportedFocusModes) {
            arrayList.add(CameraController.FocusMode.convertFocusMode(convertFocusMode));
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo19467a(CameraController.FocusMode focusMode, boolean... zArr) {
        Class[] clsArr = {CameraController.FocusMode.class, boolean[].class};
        if (!PatchProxy.proxy(new Object[]{focusMode, zArr}, this, f8727o, false, 2865, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f8728p;
            LogUtil.m15952c(aVar, "setFocusMode " + focusMode);
            mo19471a("focus-mode", focusMode.getKey(), zArr);
        }
    }

    /* renamed from: aa */
    public CameraController.FocusMode mo19483aa() {
        String focusMode;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8727o, false, 2866, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f8769q == null || (focusMode = this.f8769q.mo19740f().getFocusMode()) == null) {
            return null;
        }
        return CameraController.FocusMode.convertFocusMode(focusMode);
    }

    /* renamed from: e */
    public CameraController.FocusMode mo19509e() {
        return CameraController.FocusMode.MANUAL;
    }

    /* renamed from: a */
    public void mo19453a(Intent intent) {
        Intent intent2 = intent;
        if (!PatchProxy.proxy(new Object[]{intent2}, this, f8727o, false, 2867, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            this.f8743aA = 0;
            this.f8744aB = false;
            this.f8766ax = null;
            if (this.f8769q.f9122a == 1) {
                this.f8768az = DeviceHelper.f14022dn[1];
            } else {
                this.f8768az = DeviceHelper.f14022dn[0];
            }
            this.f8767ay = this.f8768az.length;
            mo19471a("exposure-compensation", "0", true);
            UUID uuid = (UUID) intent2.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent2.getSerializableExtra("requestCode");
            Contants.CameraService.RequestCode requestCode2 = requestCode;
            int intExtra = intent2.getIntExtra("width", 0);
            int intExtra2 = intent2.getIntExtra("height", 0);
            int intExtra3 = intent2.getIntExtra("jpegRotation", 0);
            long longExtra = intent2.getLongExtra("shutterSpeed", 0);
            long longExtra2 = intent2.getLongExtra("captureStartTime", 0);
            int intExtra4 = intent2.getIntExtra("currentHeading", 0);
            Contants.CameraService.RequestCode requestCode3 = requestCode;
            FaceBeautyData dVar = (FaceBeautyData) intent2.getSerializableExtra("fbData");
            String stringExtra = intent2.getStringExtra("filterEffect");
            boolean booleanExtra = intent2.getBooleanExtra("mirror", false);
            boolean booleanExtra2 = intent2.getBooleanExtra("frontMirror", true);
            boolean booleanExtra3 = intent2.getBooleanExtra("deviceMark", false);
            boolean booleanExtra4 = intent2.getBooleanExtra("timeMark", false);
            boolean booleanExtra5 = intent2.getBooleanExtra("isSquareMode", false);
            boolean booleanExtra6 = intent2.getBooleanExtra("isFBOn", false);
            boolean booleanExtra7 = intent2.getBooleanExtra("isFunnyOn", false);
            intent2.getBooleanExtra("needFastThumbnail", false);
            boolean booleanExtra8 = intent2.getBooleanExtra("isImageCaptureIntent", false);
            LogUtil.m15942a(f8728p, "takePicture shutterSpeed=" + longExtra);
            C2013s sVar = r1;
            UUID uuid2 = uuid;
            C2013s sVar2 = new C2013s(this, uuid, requestCode2, (Location) intent2.getParcelableExtra("location"), intExtra, intExtra2, intExtra3, longExtra2, intExtra4, dVar, stringExtra, booleanExtra, booleanExtra2, booleanExtra3, booleanExtra5, true, booleanExtra8, booleanExtra6, booleanExtra7, false, booleanExtra4, -1, (ExifInterface) null);
            this.f8770t.add(sVar);
            f8275g++;
            f8274f++;
            this.f8771u = true;
            this.f8769q.mo19738a((Handler) this.f8279c, (CameraProxyV1.C2019c) null, (CameraProxyV1.C2018b) new C2007m(), (CameraProxyV1.C2018b) new C2005k(uuid2, requestCode3, intExtra3, booleanExtra, intExtra, intExtra2, longExtra2, true), (CameraProxyV1.C2018b) new C2002h());
            Contants.CameraService.RequestCode requestCode4 = requestCode3;
            UUID uuid3 = uuid2;
            this.f8281e.mo19053b(uuid3, requestCode4, Contants.CameraService.ResultCode.REQUEST_CODE_TAKE_PICTURE_START, new Object[0]);
            m9413a(uuid3, requestCode4, true, (int) HttpConstants.HTTP_CONNECT_TIMEOUT);
            this.f8281e.mo19040a(uuid3);
            while (this.f8771u) {
                if (this.f8281e.mo19051a(false)) {
                    f8275g = 0;
                    f8274f = 0;
                    this.f8281e.mo19041a(f8275g);
                    this.f8281e.mo19045a(uuid3, requestCode4, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
                    m9412a(uuid3, requestCode4, false);
                    return;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: ac */
    public Contants.AsdSceneType mo19485ac() {
        return Contants.AsdSceneType.AUTO;
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$c */
    /* compiled from: CameraControllerV1 */
    private static final class C1992c implements Camera.ErrorCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f8948a;

        /* renamed from: b */
        private final LogUtil.C2630a f8949b;

        private C1992c() {
            this.f8949b = new LogUtil.C2630a("CamErrorCallback");
        }

        public void onError(int i, Camera camera) {
            Object[] objArr = {new Integer(i), camera};
            ChangeQuickRedirect changeQuickRedirect = f8948a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2932, new Class[]{Integer.TYPE, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a aVar = this.f8949b;
                LogUtil.m15949b(aVar, "Got camera error callback. error=" + i);
                if (i == 100) {
                    Process.killProcess(Process.myPid());
                } else if (i == 2) {
                    Process.killProcess(Process.myPid());
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$g */
    /* compiled from: CameraControllerV1 */
    private class C1997g implements CameraProxyV1.C2018b {

        /* renamed from: a */
        public static ChangeQuickRedirect f8961a;

        /* renamed from: b */
        UUID f8962b;

        /* renamed from: c */
        Contants.CameraService.RequestCode f8963c;

        /* renamed from: d */
        Location f8964d;

        /* renamed from: e */
        int f8965e;

        /* renamed from: f */
        int f8966f;

        /* renamed from: g */
        int f8967g;

        /* renamed from: h */
        long f8968h;

        /* renamed from: i */
        int f8969i;

        /* renamed from: j */
        FaceBeautyData f8970j;

        /* renamed from: k */
        String f8971k;

        /* renamed from: l */
        boolean f8972l;

        /* renamed from: m */
        boolean f8973m;

        /* renamed from: n */
        boolean f8974n;

        /* renamed from: o */
        boolean f8975o;

        /* renamed from: p */
        boolean f8976p;

        /* renamed from: q */
        boolean f8977q;

        /* renamed from: r */
        boolean f8978r;

        /* renamed from: s */
        boolean f8979s;

        /* renamed from: t */
        boolean f8980t;

        public C1997g(CameraControllerV1 bVar, UUID uuid, Contants.CameraService.RequestCode requestCode, Location location, int i, int i2, int i3, long j, int i4, FaceBeautyData dVar, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
            CameraControllerV1.this = bVar;
            this.f8962b = uuid;
            this.f8963c = requestCode;
            this.f8964d = location;
            this.f8965e = i;
            this.f8966f = i2;
            this.f8967g = i3;
            this.f8968h = j;
            this.f8969i = i4;
            this.f8970j = dVar;
            this.f8971k = str;
            this.f8972l = z;
            this.f8973m = z2;
            this.f8974n = z3;
            this.f8975o = CameraModeType.m10983m(CameraModeType.ModeType.DOCUMENT);
            this.f8976p = z4;
            this.f8977q = z5;
            this.f8978r = z6;
            this.f8979s = z7;
            this.f8980t = z8;
            LogUtil.C2630a ah = CameraControllerV1.f8728p;
            LogUtil.m15942a(ah, "new JpegPictureCallback this:" + this);
        }

        private C1997g() {
        }

        /* renamed from: a */
        public void mo19715a(final byte[] bArr, CameraProxy dVar) {
            int i;
            int i2;
            if (!PatchProxy.proxy(new Object[]{bArr, dVar}, this, f8961a, false, 2937, new Class[]{byte[].class, CameraProxy.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "JpegPictureCallback mNeedFastThumbnail:" + this.f8976p);
                LogUtil.m15942a(CameraControllerV1.f8728p, "new JpegPictureCallback this:" + this);
                if (CameraControllerV1.this.f8281e.mo19050a()) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "JpegPictureCallback:isDestroyed is false");
                } else if (bArr == null) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "JpegPictureCallback: data is null");
                } else if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY && Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE == this.f8963c) {
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                        CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                    }
                    CameraControllerV1.this.f8281e.mo19045a(this.f8962b, this.f8963c, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                    if (CameraController.f8275g > 0) {
                        CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, true);
                    } else {
                        CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, false);
                    }
                } else {
                    boolean unused = CameraControllerV1.this.f8771u = false;
                    CameraControllerV1.this.f8281e.mo19045a(this.f8962b, this.f8963c, Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK, bArr, this.f8964d, Boolean.valueOf(this.f8978r), Integer.valueOf(this.f8965e), Integer.valueOf(this.f8966f));
                    if (this.f8977q) {
                        if (CameraController.f8275g > 0) {
                            CameraController.f8275g--;
                            CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                        }
                        if (CameraController.f8275g > 0) {
                            CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, true);
                        } else {
                            CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, false);
                        }
                    } else {
                        CamIntentTask.C1777c a = CameraControllerV1.this.f8281e.mo19040a(this.f8962b);
                        if (this.f8978r && a.mo18240i()) {
                            if (!CameraControllerV1.this.f8281e.mo19051a(false)) {
                                CameraControllerV1.this.f8281e.mo19054b();
                            }
                            new AsyncTaskEx<Void, Void, Void>() {

                                /* renamed from: a */
                                public static ChangeQuickRedirect f8982a;

                                /* renamed from: a */
                                public Void mo17658a(Void... voidArr) {
                                    int i;
                                    int i2;
                                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f8982a, false, 2938, new Class[]{Void[].class}, Void.class);
                                    if (proxy.isSupported) {
                                        return (Void) proxy.result;
                                    }
                                    ExifInterface a = Exif.m10044a(bArr);
                                    int a2 = Exif.m10043a(a);
                                    if ((C1997g.this.f8967g + a2) % 180 == 0) {
                                        i = C1997g.this.f8965e;
                                        i2 = C1997g.this.f8966f;
                                    } else {
                                        i = C1997g.this.f8966f;
                                        i2 = C1997g.this.f8965e;
                                    }
                                    CameraControllerV1.this.f8281e.mo19048a(C1997g.this.f8962b, C1997g.this.f8963c, bArr, C1997g.this.f8974n ? CameraUtil.m15831a(C1997g.this.f8968h) : CameraUtil.m15874b(C1997g.this.f8968h), C1997g.this.f8968h, C1997g.this.f8964d, i, i2, a2, a, C1997g.this.f8972l, C1997g.this.f8973m, C1997g.this.f8967g, C1997g.this.f8974n, false, C1997g.this.f8978r);
                                    CameraControllerV1.this.m9412a(C1997g.this.f8962b, C1997g.this.f8963c, false);
                                    return null;
                                }
                            }.mo22614c((Params[]) new Void[0]);
                        } else if (this.f8979s) {
                            new AsyncTaskEx<Void, Void, Void>() {

                                /* renamed from: a */
                                public static ChangeQuickRedirect f8985a;

                                /* renamed from: a */
                                public Void mo17658a(Void... voidArr) {
                                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f8985a, false, 2939, new Class[]{Void[].class}, Void.class);
                                    if (proxy.isSupported) {
                                        return (Void) proxy.result;
                                    }
                                    CameraControllerV1.this.f8281e.mo19049a(C1997g.this.f8962b, bArr, C1997g.this.f8965e, C1997g.this.f8966f, C1997g.this.f8967g, C1997g.this.f8968h, C1997g.this.f8969i, C1997g.this.f8972l, C1997g.this.f8964d, C1997g.this.f8976p, C1997g.this.f8963c, (XmpMetaData) null);
                                    if (CameraController.f8275g > 0) {
                                        CameraController.f8275g--;
                                        CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                                        LogUtil.m15942a(CameraControllerV1.f8728p, "after JpegPictureCallback sCapturingTaskNum:" + CameraController.f8275g);
                                    }
                                    CameraControllerV1.this.f8281e.mo19045a(C1997g.this.f8962b, C1997g.this.f8963c, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                                    CameraControllerV1.this.m9412a(C1997g.this.f8962b, C1997g.this.f8963c, true);
                                    return null;
                                }
                            }.mo22614c((Params[]) new Void[0]);
                        } else {
                            if (this.f8976p) {
                                final ExifInterface a2 = Exif.m10044a(bArr);
                                final int a3 = Exif.m10043a(a2);
                                if ((this.f8967g + a3) % 180 == 0) {
                                    i = this.f8965e;
                                    i2 = this.f8966f;
                                } else {
                                    i = this.f8966f;
                                    i2 = this.f8965e;
                                }
                                final int i3 = i;
                                final int i4 = i2;
                                final byte[] bArr2 = bArr;
                                new AsyncTaskEx<Void, Void, Void>() {

                                    /* renamed from: a */
                                    public static ChangeQuickRedirect f8988a;

                                    /* renamed from: a */
                                    public Void mo17658a(Void... voidArr) {
                                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f8988a, false, 2940, new Class[]{Void[].class}, Void.class);
                                        if (proxy.isSupported) {
                                            return (Void) proxy.result;
                                        }
                                        CameraControllerV1.this.f8281e.mo19046a(C1997g.this.f8962b, C1997g.this.f8963c, bArr2, C1997g.this.f8974n ? CameraUtil.m15831a(C1997g.this.f8968h) : CameraUtil.m15874b(C1997g.this.f8968h), C1997g.this.f8968h, C1997g.this.f8964d, i3, i4, a3, a2, (XmpMetaData) null, C1997g.this.f8972l, C1997g.this.f8973m, C1997g.this.f8967g, C1997g.this.f8974n, C1997g.this.f8980t, C1997g.this.f8978r);
                                        return null;
                                    }
                                }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
                            } else {
                                new AsyncTaskEx<Void, Void, Void>() {

                                    /* renamed from: a */
                                    public static ChangeQuickRedirect f8995a;

                                    /* renamed from: a */
                                    public Void mo17658a(Void... voidArr) {
                                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f8995a, false, 2941, new Class[]{Void[].class}, Void.class);
                                        if (proxy.isSupported) {
                                            return (Void) proxy.result;
                                        }
                                        CameraControllerV1.this.f8281e.mo19042a(new ParamData(C1997g.this.f8962b, C1997g.this.f8963c).mo18733a(bArr).mo18734b(C1997g.this.f8965e).mo18737c(C1997g.this.f8966f).mo18740d(C1997g.this.f8967g).mo18724a(C1997g.this.f8968h).mo18723a(C1997g.this.f8969i).mo18729a(C1997g.this.f8970j).mo18741d(C1997g.this.f8971k).mo18732a(C1997g.this.f8972l).mo18742d(C1997g.this.f8974n).mo18744e(C1997g.this.f8975o).mo18739c(C1997g.this.f8978r).mo18727a(C1997g.this.f8964d).mo18748h(C1997g.this.f8976p));
                                        return null;
                                    }
                                }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
                                if ((!this.f8978r || a.mo18240i()) && CameraController.f8275g > 0) {
                                    CameraController.f8275g--;
                                    CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                                    LogUtil.m15942a(CameraControllerV1.f8728p, "after JpegPictureCallback sCapturingTaskNum:" + CameraController.f8275g);
                                }
                            }
                            if (!this.f8978r || a.mo18240i()) {
                                CameraControllerV1.this.f8281e.mo19045a(this.f8962b, this.f8963c, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                                if (CameraController.f8275g > 0) {
                                    CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, true);
                                } else {
                                    CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, false);
                                }
                            } else {
                                CameraControllerV1.this.m9412a(this.f8962b, this.f8963c, false);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$s */
    /* compiled from: CameraControllerV1 */
    private class C2013s extends C1997g {

        /* renamed from: v */
        public static ChangeQuickRedirect f9086v;

        /* renamed from: A */
        int f9087A;

        /* renamed from: B */
        int f9088B;

        /* renamed from: C */
        long f9089C;

        /* renamed from: D */
        int f9090D;

        /* renamed from: E */
        FaceBeautyData f9091E;

        /* renamed from: F */
        String f9092F;

        /* renamed from: G */
        boolean f9093G;

        /* renamed from: H */
        boolean f9094H;

        /* renamed from: I */
        boolean f9095I;

        /* renamed from: J */
        boolean f9096J;

        /* renamed from: K */
        boolean f9097K = CameraModeType.m10983m(CameraModeType.ModeType.DOCUMENT);

        /* renamed from: L */
        boolean f9098L;

        /* renamed from: M */
        boolean f9099M;

        /* renamed from: N */
        boolean f9100N;

        /* renamed from: O */
        boolean f9101O;

        /* renamed from: P */
        boolean f9102P;

        /* renamed from: Q */
        boolean f9103Q;

        /* renamed from: R */
        int f9104R;

        /* renamed from: S */
        ExifInterface f9105S;

        /* renamed from: T */
        final /* synthetic */ CameraControllerV1 f9106T;

        /* renamed from: w */
        UUID f9107w;

        /* renamed from: x */
        Contants.CameraService.RequestCode f9108x;

        /* renamed from: y */
        Location f9109y;

        /* renamed from: z */
        int f9110z;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2013s(CameraControllerV1 bVar, UUID uuid, Contants.CameraService.RequestCode requestCode, Location location, int i, int i2, int i3, long j, int i4, FaceBeautyData dVar, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, ExifInterface cVar) {
            super();
            this.f9106T = bVar;
            this.f9107w = uuid;
            this.f9108x = requestCode;
            this.f9109y = location;
            this.f9110z = i;
            this.f9087A = i2;
            this.f9088B = i3;
            this.f9089C = j;
            this.f9090D = i4;
            this.f9091E = dVar;
            this.f9092F = str;
            this.f9093G = z;
            this.f9094H = z2;
            this.f9095I = z3;
            this.f9096J = z4;
            this.f9098L = z5;
            this.f9099M = z6;
            this.f9100N = z7;
            this.f9101O = z8;
            this.f9102P = z9;
            this.f9103Q = z10;
            this.f9104R = i5;
            this.f9105S = cVar;
            LogUtil.C2630a ah = CameraControllerV1.f8728p;
            LogUtil.m15942a(ah, "new SuperNightJpegPictureCallback this:" + this);
        }

        /* renamed from: a */
        public void mo19715a(byte[] bArr, CameraProxy dVar) {
            int i;
            int i2;
            if (!PatchProxy.proxy(new Object[]{bArr, dVar}, this, f9086v, false, 2954, new Class[]{byte[].class, CameraProxy.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "SuperNightJpegPictureCallback mNeedFastThumbnail:" + this.f9098L + "  sCapturingTaskNum: " + CameraController.f8275g);
                LogUtil.C2630a ah = CameraControllerV1.f8728p;
                StringBuilder sb = new StringBuilder();
                sb.append("new SuperNightJpegPictureCallback this:");
                sb.append(this);
                LogUtil.m15942a(ah, sb.toString());
                if (this.f9106T.f8281e.mo19050a()) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "SuperNightJpegPictureCallback:isDestroyed is false");
                } else if (bArr == null) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "SuperNightJpegPictureCallback: data is null");
                } else if (!this.f9106T.f8771u) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "not in capture action");
                } else {
                    if (this.f9106T.f8766ax == null) {
                        byte[][] unused = this.f9106T.f8766ax = (byte[][]) Array.newInstance(byte.class, new int[]{this.f9106T.f8767ay, 0});
                    }
                    ExifInterface a = Exif.m10044a(bArr);
                    a.mo19869c();
                    Rational h = a.mo19880h(ExifInterface.f9310V);
                    float d = this.f9106T.mo19504d();
                    if (DeviceHelper.f13937bk == DeviceHelper.EXPOSURE_STEP.STEP_POINT_ONE && d < 0.4f) {
                        d *= 10.0f;
                    }
                    if (h != null) {
                        if (h.mo19956c() == 0.0d && this.f9104R == -1) {
                            Integer g = a.mo19879g(ExifInterface.f9300L);
                            if (g == null) {
                                i2 = 0;
                            } else {
                                i2 = g.intValue();
                            }
                            this.f9104R = i2;
                            this.f9105S = a;
                        }
                        i = this.f9106T.f8767ay - 1;
                        while (true) {
                            if (i >= 0) {
                                if (Math.abs(((double) (this.f9106T.f8768az[i] * d)) - h.mo19956c()) < 0.1d && ((this.f9106T.f8766ax[i].length == 0 || h.mo19954a() == 0) && this.f9106T.f8766ax[i].length == 0)) {
                                    this.f9106T.f8766ax[i] = new byte[1];
                                    break;
                                }
                                i--;
                            } else {
                                break;
                            }
                        }
                    }
                    i = -1;
                    if (i != -1) {
                        CameraControllerV1.m9485o(this.f9106T);
                        AsyncTaskEx.f13743q.execute(new Runnable(bArr, i) {
                            private final /* synthetic */ byte[] f$1;
                            private final /* synthetic */ int f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                CameraControllerV1.C2013s.this.m9619a(this.f$1, this.f$2);
                            }
                        });
                    }
                    int a2 = m9616a();
                    if (a2 != -1) {
                        AsyncTaskEx.f13744r.execute(new Runnable(a2) {
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CameraControllerV1.C2013s.this.m9617a(this.f$1);
                            }
                        });
                        return;
                    }
                    if (CameraController.f8274f > 0) {
                        CameraController.f8274f--;
                    }
                    if (CameraController.f8274f == 0) {
                        this.f9106T.f8281e.mo19045a(this.f9107w, this.f9108x, Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK, Boolean.valueOf(this.f9098L), Integer.valueOf(this.f9088B), Boolean.valueOf(this.f9093G), Integer.valueOf(this.f9110z), Integer.valueOf(this.f9087A), Long.valueOf(this.f9089C), Boolean.valueOf(this.f9100N), CameraUtil.m15918x());
                        AsyncTaskEx.f13744r.execute(new Runnable() {
                            public final void run() {
                                CameraControllerV1.C2013s.this.m9621c();
                            }
                        });
                    }
                    AsyncTaskEx.f13743q.execute(new Runnable(this.f9106T.f8769q.f9122a, this.f9104R, a, this.f9105S) {
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ int f$2;
                        private final /* synthetic */ ExifInterface f$3;
                        private final /* synthetic */ ExifInterface f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void run() {
                            CameraControllerV1.C2013s.this.m9618a(this.f$1, this.f$2, this.f$3, this.f$4);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m9619a(byte[] bArr, int i) {
            if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i)}, this, f9086v, false, 2960, new Class[]{byte[].class, Integer.TYPE}, Void.TYPE).isSupported) {
                AlorgrithmManager.m10018a();
                byte[] nativeDecodeNv21 = YuvUtil.nativeDecodeNv21(bArr, bArr.length, this.f9110z, this.f9087A, new int[]{0, 0});
                if (nativeDecodeNv21 == null) {
                    LogUtil.m15942a(CameraControllerV1.f8728p, "not support libjpeg");
                    Bitmap a = AlorgrithmManager.m10017a(bArr);
                    LogUtil.m15942a(CameraControllerV1.f8728p, "getNV21Data start");
                    nativeDecodeNv21 = AlorgrithmUtil.changeARGBToNV21(a);
                    LogUtil.m15942a(CameraControllerV1.f8728p, "ARGBToNV21 end");
                    a.recycle();
                    LogUtil.m15942a(CameraControllerV1.f8728p, "getNV21Data end");
                }
                if (this.f9106T.f8766ax != null) {
                    this.f9106T.f8766ax[i] = nativeDecodeNv21;
                    if (m9620b()) {
                        boolean unused = this.f9106T.f8744aB = true;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m9617a(int i) {
            int i2 = i;
            if (!PatchProxy.proxy(new Object[]{new Integer(i2)}, this, f9086v, false, 2959, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                CameraControllerV1 bVar = this.f9106T;
                bVar.mo19471a("exposure-compensation", this.f9106T.f8768az[i2] + "", true);
                this.f9106T.f8770t.add(new C2013s(this.f9106T, this.f9107w, this.f9108x, this.f9109y, this.f9110z, this.f9087A, this.f9088B, this.f9089C, this.f9090D, this.f9091E, this.f9092F, this.f9093G, this.f9094H, this.f9095I, this.f9096J, this.f9098L, this.f9099M, this.f9100N, this.f9101O, false, this.f9103Q, this.f9104R, this.f9105S));
                CameraProxyV1 b = this.f9106T.f8769q;
                CameraController.C1878e eVar = this.f9106T.f8279c;
                C2007m mVar = new C2007m();
                b.mo19738a((Handler) eVar, (CameraProxyV1.C2019c) null, (CameraProxyV1.C2018b) mVar, (CameraProxyV1.C2018b) new C2005k(this.f9107w, this.f9108x, this.f9088B, this.f9093G, this.f9110z, this.f9087A, this.f9089C, this.f9098L), (CameraProxyV1.C2018b) new C2002h());
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m9621c() {
            if (!PatchProxy.proxy(new Object[0], this, f9086v, false, 2958, new Class[0], Void.TYPE).isSupported) {
                this.f9106T.mo19471a("exposure-compensation", "0", true);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Object[]} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void m9618a(int r26, int r27, com.meizu.media.camera.p067d.ExifInterface r28, com.meizu.media.camera.p067d.ExifInterface r29) {
            /*
                r25 = this;
                r9 = r25
                r8 = r26
                r10 = 4
                java.lang.Object[] r1 = new java.lang.Object[r10]
                java.lang.Integer r0 = new java.lang.Integer
                r0.<init>(r8)
                r11 = 0
                r1[r11] = r0
                java.lang.Integer r0 = new java.lang.Integer
                r15 = r27
                r0.<init>(r15)
                r14 = 1
                r1[r14] = r0
                r13 = 2
                r1[r13] = r28
                r12 = 3
                r1[r12] = r29
                com.meizu.savior.ChangeQuickRedirect r3 = f9086v
                java.lang.Class[] r6 = new java.lang.Class[r10]
                java.lang.Class r0 = java.lang.Integer.TYPE
                r6[r11] = r0
                java.lang.Class r0 = java.lang.Integer.TYPE
                r6[r14] = r0
                java.lang.Class<com.meizu.media.camera.d.c> r0 = com.meizu.media.camera.p067d.ExifInterface.class
                r6[r13] = r0
                java.lang.Class<com.meizu.media.camera.d.c> r0 = com.meizu.media.camera.p067d.ExifInterface.class
                r6[r12] = r0
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 2957(0xb8d, float:4.144E-42)
                r2 = r25
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x0043
                return
            L_0x0043:
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                boolean r0 = r0.f8744aB
                if (r0 != 0) goto L_0x0057
                r0 = 100
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0051 }
                goto L_0x0043
            L_0x0051:
                r0 = move-exception
                r1 = r0
                r1.printStackTrace()
                goto L_0x0043
            L_0x0057:
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                boolean unused = r0.f8771u = r11
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                if (r0 <= 0) goto L_0x006e
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                int r0 = r0 - r14
                com.meizu.media.camera.camcontroller.CameraController.f8275g = r0
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                com.meizu.media.camera.b$a r0 = r0.f8281e
                int r1 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                r0.mo19041a((int) r1)
            L_0x006e:
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                if (r0 <= 0) goto L_0x007c
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                java.util.UUID r1 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r2 = r9.f9108x
                r0.m9412a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (boolean) r14)
                goto L_0x0085
            L_0x007c:
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                java.util.UUID r1 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r2 = r9.f9108x
                r0.m9412a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (boolean) r11)
            L_0x0085:
                com.meizu.media.camera.p068e.AlorgrithmManager.m10018a()
                int r0 = r9.f9110z
                int r1 = r9.f9087A
                int r0 = r0 * r1
                int r0 = r0 * 3
                int r0 = r0 / r13
                byte[] r0 = new byte[r0]
                if (r8 == r14) goto L_0x0097
                r1 = 0
                goto L_0x0098
            L_0x0097:
                r1 = 3
            L_0x0098:
                com.meizu.media.camera.camcontroller.b r2 = r9.f9106T
                byte[][] r2 = r2.f8766ax
                int r3 = r9.f9110z
                int r4 = r9.f9087A
                r16 = 1
                com.meizu.media.camera.camcontroller.b r5 = r9.f9106T
                float[] r17 = r5.f8768az
                int[] r5 = com.meizu.media.camera.util.DeviceHelper.f14023do
                r18 = r5[r1]
                int[] r5 = com.meizu.media.camera.util.DeviceHelper.f14023do
                int r6 = r1 + 1
                r19 = r5[r6]
                int[] r5 = com.meizu.media.camera.util.DeviceHelper.f14023do
                int r1 = r1 + r13
                r20 = r5[r1]
                int r21 = com.meizu.media.camera.util.DeviceHelper.f14024dp
                if (r8 != r14) goto L_0x00c0
                r23 = 1
                goto L_0x00c2
            L_0x00c0:
                r23 = 0
            L_0x00c2:
                r24 = 0
                r1 = 3
                r12 = r2
                r2 = 2
                r13 = r0
                r5 = 1
                r14 = r3
                r15 = r4
                r22 = r27
                com.meizu.media.cameraAlgorithm.supernight.SNUtil.getSnImage((byte[][]) r12, (byte[]) r13, (int) r14, (int) r15, (boolean) r16, (float[]) r17, (int) r18, (int) r19, (int) r20, (int) r21, (int) r22, (boolean) r23, (boolean) r24)
                boolean r3 = r9.f9100N
                if (r3 == 0) goto L_0x0122
                long r3 = java.lang.System.currentTimeMillis()
                com.meizu.media.camera.util.ac$a r6 = com.meizu.media.camera.camcontroller.CameraControllerV1.f8728p
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r12 = "processFB start ： length: "
                r7.append(r12)
                int r12 = r0.length
                r7.append(r12)
                java.lang.String r7 = r7.toString()
                com.meizu.media.camera.util.LogUtil.m15952c(r6, r7)
                int[] r6 = new int[r2]
                int r7 = r9.f9110z
                r6[r11] = r7
                int r7 = r9.f9087A
                r6[r5] = r7
                int r7 = r0.length
                r12 = r6[r11]
                r6 = r6[r5]
                boolean r13 = com.meizu.media.camera.util.DeviceHelper.f13905bE
                com.meizu.media.cameraAlgorithm.fbmodecomponent.AlorgrithmUtil.processNV21Data(r0, r7, r12, r6, r13)
                com.meizu.media.camera.util.ac$a r6 = com.meizu.media.camera.camcontroller.CameraControllerV1.f8728p
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r12 = "processFB end: "
                r7.append(r12)
                long r12 = java.lang.System.currentTimeMillis()
                long r12 = r12 - r3
                r7.append(r12)
                java.lang.String r3 = r7.toString()
                com.meizu.media.camera.util.LogUtil.m15952c(r6, r3)
            L_0x0122:
                com.meizu.media.camera.camcontroller.b r3 = r9.f9106T
                com.meizu.media.camera.b$a r3 = r3.f8281e
                java.util.UUID r4 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r6 = r9.f9108x
                com.meizu.media.camera.util.Contants$CameraService$ResultCode r7 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
                java.lang.Object[] r12 = new java.lang.Object[r11]
                r3.mo19045a(r4, r6, r7, r12)
                com.meizu.media.camera.camcontroller.b r3 = r9.f9106T
                r4 = 0
                byte[][] r4 = (byte[][]) r4
                byte[][] unused = r3.f8766ax = r4
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
                r4 = 1024(0x400, float:1.435E-42)
                r3.<init>(r4)
                boolean r4 = r9.f9094H
                if (r4 == 0) goto L_0x0157
                if (r8 != r5) goto L_0x0157
                int r4 = r9.f9088B
                r6 = 270(0x10e, float:3.78E-43)
                r7 = 90
                if (r4 != r7) goto L_0x0151
                r9.f9088B = r6
                goto L_0x0157
            L_0x0151:
                int r4 = r9.f9088B
                if (r4 != r6) goto L_0x0157
                r9.f9088B = r7
            L_0x0157:
                int r4 = r9.f9110z
                int r6 = r9.f9087A
                int r7 = r9.f9088B
                byte[] r0 = com.meizu.media.cameraAlgorithm.yuv.YuvUtil.rotateNV21Data(r0, r4, r6, r7, r11)
                int r6 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r28)
                int r4 = r9.f9088B
                int r4 = r4 + r6
                int r4 = r4 % 180
                if (r4 != 0) goto L_0x0171
                int r4 = r9.f9110z
                int r7 = r9.f9087A
                goto L_0x0175
            L_0x0171:
                int r4 = r9.f9087A
                int r7 = r9.f9110z
            L_0x0175:
                boolean r8 = r9.f9095I
                if (r8 == 0) goto L_0x0182
                java.lang.String r8 = com.meizu.media.camera.util.DeviceHelper.f14008dB
                java.lang.String r8 = r8.toLowerCase()
                com.meizu.imageproc.WaterMark.m6373a(r0, r4, r7, r8, r11)
            L_0x0182:
                boolean r8 = r9.f9103Q
                if (r8 == 0) goto L_0x01a2
                com.meizu.media.camera.camcontroller.b r8 = r9.f9106T
                android.content.Context r8 = r8.f8286l
                android.content.Context r12 = r8.getApplicationContext()
                r16 = 0
                java.text.SimpleDateFormat r8 = com.meizu.media.camera.util.DeviceHelper.f13979cZ
                long r13 = r9.f9089C
                java.lang.Long r13 = java.lang.Long.valueOf(r13)
                java.lang.String r17 = r8.format(r13)
                r13 = r0
                r14 = r4
                r15 = r7
                com.meizu.media.photoalgorithm.WaterMark.renderTimeWaterMark4NV21(r12, r13, r14, r15, r16, r17)
            L_0x01a2:
                android.graphics.YuvImage r8 = new android.graphics.YuvImage
                r14 = 17
                int[] r15 = new int[r1]
                r15[r11] = r4
                r15[r5] = r4
                r15[r2] = r4
                r12 = r8
                r13 = r0
                r0 = r15
                r15 = r4
                r16 = r7
                r17 = r0
                r12.<init>(r13, r14, r15, r16, r17)
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>(r11, r11, r4, r7)
                r12 = 97
                r8.compressToJpeg(r0, r12, r3)
                byte[] r3 = r3.toByteArray()
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                com.meizu.media.camera.b$a r0 = r0.f8281e
                java.util.UUID r8 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r12 = r9.f9108x
                com.meizu.media.camera.util.Contants$CameraService$ResultCode r13 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK
                r14 = 5
                java.lang.Object[] r14 = new java.lang.Object[r14]
                r14[r11] = r3
                android.location.Location r15 = r9.f9109y
                r14[r5] = r15
                boolean r15 = r9.f9100N
                java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
                r14[r2] = r15
                int r2 = r9.f9110z
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r14[r1] = r2
                int r1 = r9.f9087A
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r14[r10] = r1
                r0.mo19045a(r8, r12, r13, r14)
                boolean r0 = r9.f9099M
                if (r0 == 0) goto L_0x0223
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                if (r0 <= 0) goto L_0x020b
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                int r0 = r0 - r5
                com.meizu.media.camera.camcontroller.CameraController.f8275g = r0
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                com.meizu.media.camera.b$a r0 = r0.f8281e
                int r1 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                r0.mo19041a((int) r1)
            L_0x020b:
                int r0 = com.meizu.media.camera.camcontroller.CameraController.f8275g
                if (r0 <= 0) goto L_0x0219
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                java.util.UUID r1 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r2 = r9.f9108x
                r0.m9412a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (boolean) r5)
                goto L_0x0222
            L_0x0219:
                com.meizu.media.camera.camcontroller.b r0 = r9.f9106T
                java.util.UUID r1 = r9.f9107w
                com.meizu.media.camera.util.Contants$CameraService$RequestCode r2 = r9.f9108x
                r0.m9412a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (boolean) r11)
            L_0x0222:
                return
            L_0x0223:
                com.meizu.media.camera.camcontroller.b$s$1 r0 = new com.meizu.media.camera.camcontroller.b$s$1
                r1 = r0
                r2 = r25
                r5 = r7
                r7 = r29
                r8 = r28
                r1.<init>(r3, r4, r5, r6, r7, r8)
                java.util.concurrent.Executor r1 = com.meizu.media.camera.util.AsyncTaskEx.f13741o
                java.lang.Void[] r2 = new java.lang.Void[r11]
                r0.mo22610a((java.util.concurrent.Executor) r1, (Params[]) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.camcontroller.CameraControllerV1.C2013s.m9618a(int, int, com.meizu.media.camera.d.c, com.meizu.media.camera.d.c):void");
        }

        /* renamed from: a */
        private int m9616a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9086v, false, 2955, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            for (int m = this.f9106T.f8767ay - 1; m >= 0; m--) {
                if (this.f9106T.f8766ax[m].length == 0) {
                    return m;
                }
            }
            return -1;
        }

        /* renamed from: b */
        private boolean m9620b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9086v, false, 2956, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            for (int i = 0; i < this.f9106T.f8767ay; i++) {
                if (this.f9106T.f8766ax[i].length < 10) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$h */
    /* compiled from: CameraControllerV1 */
    private final class C2002h implements CameraProxyV1.C2018b {

        /* renamed from: a */
        public static ChangeQuickRedirect f8998a;

        private C2002h() {
        }

        /* renamed from: a */
        public void mo19715a(byte[] bArr, CameraProxy dVar) {
            C1997g gVar;
            Class[] clsArr = {byte[].class, CameraProxy.class};
            if (!PatchProxy.proxy(new Object[]{bArr, dVar}, this, f8998a, false, 2942, clsArr, Void.TYPE).isSupported && (gVar = (C1997g) CameraControllerV1.this.f8770t.poll()) != null) {
                gVar.mo19715a(bArr, dVar);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$i */
    /* compiled from: CameraControllerV1 */
    private final class C2003i implements Camera.PictureCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f9000a;

        /* renamed from: b */
        UUID f9001b;

        /* renamed from: c */
        Contants.CameraService.RequestCode f9002c;

        /* renamed from: d */
        Location f9003d;

        /* renamed from: e */
        int f9004e;

        /* renamed from: f */
        int f9005f;

        /* renamed from: g */
        int f9006g;

        /* renamed from: h */
        long f9007h;

        /* renamed from: i */
        boolean f9008i;

        /* renamed from: j */
        boolean f9009j;

        /* renamed from: k */
        boolean f9010k;

        public C2003i(UUID uuid, Contants.CameraService.RequestCode requestCode, Location location, int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3) {
            this.f9001b = uuid;
            this.f9002c = requestCode;
            this.f9003d = location;
            this.f9004e = i;
            this.f9005f = i2;
            this.f9006g = i3;
            this.f9007h = j;
            this.f9008i = z;
            this.f9009j = z2;
            this.f9010k = z3;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i;
            int i2;
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f9000a, false, 2943, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "OriginJpegPictureCallback mNeedFastThumbnail:" + this.f9009j + " sCapturingTaskNum:" + CameraController.f8275g);
                if (CameraController.f8275g != 0) {
                    boolean unused = CameraControllerV1.this.f8771u = false;
                    CameraControllerV1.this.f8281e.mo19045a(this.f9001b, this.f9002c, Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK, bArr, this.f9003d, Integer.valueOf(this.f9006g));
                    ExifInterface a = Exif.m10044a(bArr);
                    int a2 = Exif.m10043a(a);
                    if ((this.f9006g + a2) % 180 == 0) {
                        i = this.f9004e;
                        i2 = this.f9005f;
                    } else {
                        i = this.f9005f;
                        i2 = this.f9004e;
                    }
                    CameraControllerV1.this.f8281e.mo19047a(this.f9001b, this.f9002c, bArr, CameraUtil.m15874b(this.f9007h), this.f9007h, this.f9003d, i, i2, a2, a, this.f9008i, this.f9010k);
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                        CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                    }
                    CameraControllerV1.this.f8281e.mo19045a(this.f9001b, this.f9002c, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                    if (CameraController.f8275g > 0) {
                        CameraControllerV1.this.m9412a(this.f9001b, this.f9002c, true);
                    } else {
                        CameraControllerV1.this.m9412a(this.f9001b, this.f9002c, false);
                    }
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$l */
    /* compiled from: CameraControllerV1 */
    private final class C2006l {

        /* renamed from: a */
        public static ChangeQuickRedirect f9034a;

        /* renamed from: c */
        private UUID f9036c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f9037d;

        /* renamed from: e */
        private int f9038e;

        /* renamed from: f */
        private boolean f9039f;

        /* renamed from: g */
        private int f9040g;

        /* renamed from: h */
        private int f9041h;

        /* renamed from: i */
        private long f9042i;

        /* renamed from: j */
        private String f9043j;

        /* renamed from: k */
        private boolean f9044k;

        public C2006l(UUID uuid, Contants.CameraService.RequestCode requestCode, int i, boolean z, int i2, int i3, long j, boolean z2) {
            this.f9036c = uuid;
            this.f9037d = requestCode;
            this.f9038e = i;
            this.f9039f = z;
            this.f9040g = i2;
            this.f9041h = i3;
            this.f9042i = j;
            this.f9044k = z2;
        }

        /* renamed from: a */
        public void mo19723a() {
            if (!PatchProxy.proxy(new Object[0], this, f9034a, false, 2948, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "onOriginDataBack");
                if (CameraController.f8275g != 0) {
                    boolean unused = CameraControllerV1.this.f8771u = false;
                    this.f9043j = CameraUtil.m15874b(this.f9042i);
                    CameraControllerV1.this.m9411a(this.f9036c, this.f9037d, Storage.m7750a().mo18622a(this.f9043j, this.f9042i), this.f9043j, this.f9039f);
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                        CameraControllerV1.this.f8281e.mo19041a(CameraController.f8275g);
                    }
                    CameraControllerV1.this.f8281e.mo19045a(this.f9036c, this.f9037d, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                    if (CameraController.f8275g > 0) {
                        CameraControllerV1.this.m9412a(this.f9036c, this.f9037d, true);
                    } else {
                        CameraControllerV1.this.m9412a(this.f9036c, this.f9037d, false);
                    }
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$q */
    /* compiled from: CameraControllerV1 */
    private final class C2011q implements Camera.PictureCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f9064a;

        /* renamed from: b */
        UUID f9065b;

        /* renamed from: c */
        Contants.CameraService.RequestCode f9066c;

        /* renamed from: d */
        Location f9067d;

        /* renamed from: e */
        int f9068e;

        /* renamed from: f */
        int f9069f;

        /* renamed from: g */
        int f9070g;

        /* renamed from: h */
        long f9071h;

        /* renamed from: i */
        int f9072i;

        /* renamed from: j */
        FaceBeautyData f9073j;

        /* renamed from: k */
        String f9074k;

        /* renamed from: l */
        boolean f9075l;

        /* renamed from: m */
        boolean f9076m;

        /* renamed from: n */
        boolean f9077n;

        /* renamed from: o */
        boolean f9078o = false;

        /* renamed from: p */
        boolean f9079p;

        /* renamed from: q */
        boolean f9080q;

        /* renamed from: r */
        boolean f9081r;

        /* renamed from: s */
        boolean f9082s;

        /* renamed from: t */
        final /* synthetic */ CameraControllerV1 f9083t;

        public C2011q(CameraControllerV1 bVar, UUID uuid, Contants.CameraService.RequestCode requestCode, Location location, int i, int i2, int i3, long j, int i4, FaceBeautyData dVar, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            this.f9083t = bVar;
            this.f9065b = uuid;
            this.f9066c = requestCode;
            this.f9067d = location;
            this.f9068e = i;
            this.f9069f = i2;
            this.f9070g = i3;
            this.f9071h = j;
            this.f9072i = i4;
            this.f9073j = dVar;
            this.f9074k = str;
            this.f9075l = z;
            this.f9076m = z2;
            this.f9077n = z3;
            this.f9079p = z4;
            this.f9080q = z5;
            this.f9081r = z6;
            this.f9082s = z7;
            LogUtil.C2630a ah = CameraControllerV1.f8728p;
            LogUtil.m15942a(ah, "new JpegPictureCallback this:" + this);
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            boolean z;
            boolean z2;
            int i;
            int i2;
            byte[] bArr2 = bArr;
            if (!PatchProxy.proxy(new Object[]{bArr2, camera}, this, f9064a, false, 2952, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "StereoJpegPictureCallback mNeedFastThumbnail:" + this.f9079p);
                LogUtil.m15942a(CameraControllerV1.f8728p, "new JpegPictureCallback this:" + this);
                if (bArr2 == null) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "JpegPictureCallback: data is null");
                    return;
                }
                if (this.f9079p) {
                    ExifInterface a = Exif.m10044a(bArr);
                    int a2 = Exif.m10043a(a);
                    if ((this.f9070g + a2) % 180 == 0) {
                        i = this.f9068e;
                        i2 = this.f9069f;
                    } else {
                        i = this.f9069f;
                        i2 = this.f9068e;
                    }
                    int i3 = i2;
                    z = true;
                    z2 = false;
                    this.f9083t.f8281e.mo19046a(this.f9065b, this.f9066c, bArr, this.f9077n ? CameraUtil.m15831a(this.f9071h) : CameraUtil.m15874b(this.f9071h), this.f9071h, this.f9067d, i, i3, a2, a, (XmpMetaData) null, this.f9075l, this.f9076m, this.f9070g, this.f9077n, false, this.f9081r);
                } else {
                    z2 = false;
                    z = true;
                    this.f9083t.f8281e.mo19042a(new ParamData(this.f9065b, this.f9066c).mo18733a(bArr2).mo18734b(this.f9068e).mo18737c(this.f9069f).mo18740d(this.f9070g).mo18724a(this.f9071h).mo18723a(this.f9072i).mo18729a(this.f9073j).mo18741d(this.f9074k).mo18732a(this.f9075l).mo18742d(this.f9077n).mo18744e(this.f9078o).mo18739c(this.f9081r).mo18727a(this.f9067d).mo18748h(this.f9079p));
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                        this.f9083t.f8281e.mo19041a(CameraController.f8275g);
                        LogUtil.m15942a(CameraControllerV1.f8728p, "after JpegPictureCallback sCapturingTaskNum:" + CameraController.f8275g);
                    }
                }
                this.f9083t.f8281e.mo19059e().poll();
                if (this.f9083t.f8286l == null || this.f9083t.f8281e.mo19050a() || CameraController.m8868g().mo19522k() == null) {
                    this.f9083t.mo19445W();
                    if (this.f9083t.f8281e.mo19059e().size() == 0 && !this.f9083t.f8281e.mo19060f().hasMessages(z ? 1 : 0)) {
                        Message obtainMessage = this.f9083t.f8281e.mo19060f().obtainMessage();
                        obtainMessage.what = z;
                        this.f9083t.f8281e.mo19060f().sendMessage(obtainMessage);
                    }
                }
                if (CameraController.f8275g > 0) {
                    this.f9083t.m9412a(this.f9065b, this.f9066c, z);
                } else {
                    this.f9083t.m9412a(this.f9065b, this.f9066c, z2);
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$p */
    /* compiled from: CameraControllerV1 */
    private final class C2010p implements CameraProxyV1.C2018b {

        /* renamed from: a */
        public static ChangeQuickRedirect f9061a;

        /* renamed from: c */
        private Contants.CameraService.RequestCode f9063c;

        public C2010p(Contants.CameraService.RequestCode requestCode) {
            this.f9063c = requestCode;
        }

        /* renamed from: a */
        public void mo19715a(byte[] bArr, CameraProxy dVar) {
            Class[] clsArr = {byte[].class, CameraProxy.class};
            if (!PatchProxy.proxy(new Object[]{bArr, dVar}, this, f9061a, false, 2951, clsArr, Void.TYPE).isSupported) {
                LogUtil.C2630a ah = CameraControllerV1.f8728p;
                LogUtil.m15942a(ah, "[mJpegPictureCallback] " + this);
                if (CameraControllerV1.this.f8281e.mo19050a()) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "StereoJpegPictureCallback:isDestroyed is false");
                } else if (bArr == null) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "[mJpegPictureCallback] jpegData is null");
                } else {
                    byte[] unused = CameraControllerV1.this.f8735S = bArr;
                    CameraControllerV1.this.m9421aB();
                    LogUtil.m15942a(CameraControllerV1.f8728p, "[mJpegPictureCallback] end");
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$k */
    /* compiled from: CameraControllerV1 */
    private final class C2005k implements CameraProxyV1.C2018b {

        /* renamed from: a */
        public static ChangeQuickRedirect f9024a;

        /* renamed from: c */
        private UUID f9026c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f9027d;

        /* renamed from: e */
        private int f9028e;

        /* renamed from: f */
        private boolean f9029f;

        /* renamed from: g */
        private int f9030g;

        /* renamed from: h */
        private int f9031h;

        /* renamed from: i */
        private long f9032i;

        /* renamed from: j */
        private boolean f9033j;

        public C2005k(UUID uuid, Contants.CameraService.RequestCode requestCode, int i, boolean z, int i2, int i3, long j, boolean z2) {
            this.f9026c = uuid;
            this.f9027d = requestCode;
            this.f9028e = i;
            this.f9029f = z;
            this.f9030g = i2;
            this.f9031h = i3;
            this.f9032i = j;
            this.f9033j = z2;
        }

        /* renamed from: a */
        public void mo19715a(byte[] bArr, CameraProxy dVar) {
            if (!PatchProxy.proxy(new Object[]{bArr, dVar}, this, f9024a, false, 2947, new Class[]{byte[].class, CameraProxy.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "PicturePostviewCallback onPictureTaken  sGeneratingPostViewTaskNum:" + CameraController.f8274f);
                if (CameraControllerV1.this.f8281e.mo19050a()) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "PicturePostviewCallback:isDestroyed is false");
                    return;
                }
                if (Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE.equals(this.f9027d) || Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE.equals(this.f9027d)) {
                    if (CameraController.f8274f > 0) {
                        CameraController.f8274f--;
                    }
                    if (CameraController.f8274f == 0) {
                        CameraControllerV1.this.f8281e.mo19045a(this.f9026c, this.f9027d, Contants.CameraService.ResultCode.RESULT_PICTURE_POSTVIEW_CALLBACK, bArr, Integer.valueOf(this.f9028e), Boolean.valueOf(this.f9029f), Integer.valueOf(this.f9030g), Integer.valueOf(this.f9031h), Long.valueOf(this.f9032i), Boolean.valueOf(this.f9033j));
                    }
                }
                if (Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE.equals(this.f9027d) && DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
                    if (CameraController.f8275g > 0) {
                        CameraController.f8275g--;
                    }
                    if (CameraController.f8275g == 0) {
                        CameraControllerV1.this.f8281e.mo19045a(this.f9026c, this.f9027d, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                    }
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$m */
    /* compiled from: CameraControllerV1 */
    private final class C2007m implements CameraProxyV1.C2018b {
        /* renamed from: a */
        public void mo19715a(byte[] bArr, CameraProxy dVar) {
        }

        private C2007m() {
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$n */
    /* compiled from: CameraControllerV1 */
    private final class C2008n implements CameraProxyV1.C2019c {

        /* renamed from: a */
        public static ChangeQuickRedirect f9046a;

        /* renamed from: c */
        private UUID f9048c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f9049d;

        /* renamed from: e */
        private int f9050e;

        /* renamed from: f */
        private boolean f9051f;

        /* renamed from: g */
        private int f9052g;

        /* renamed from: h */
        private int f9053h;

        /* renamed from: i */
        private long f9054i;

        /* renamed from: j */
        private boolean f9055j;

        /* renamed from: k */
        private boolean f9056k;

        /* renamed from: l */
        private boolean f9057l;

        /* renamed from: m */
        private String f9058m = null;

        public C2008n(UUID uuid, Contants.CameraService.RequestCode requestCode, int i, boolean z, int i2, int i3, long j, boolean z2, boolean z3, boolean z4, String str) {
            this.f9048c = uuid;
            this.f9049d = requestCode;
            this.f9050e = i;
            this.f9051f = z;
            this.f9052g = i2;
            this.f9053h = i3;
            this.f9054i = j;
            this.f9055j = z2;
            this.f9056k = z3;
            this.f9057l = z4;
            this.f9058m = str;
        }

        /* renamed from: a */
        public void mo19721a(CameraProxy dVar) {
            if (!PatchProxy.proxy(new Object[]{dVar}, this, f9046a, false, 2949, new Class[]{CameraProxy.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "ShutterCallback");
                if (CameraControllerV1.this.f8281e.mo19050a()) {
                    LogUtil.m15952c(CameraControllerV1.f8728p, "ShutterCallback:isDestroyed is false");
                    return;
                }
                if (this.f9057l && CameraControllerV1.this.f8281e.mo19064j() != null) {
                    CameraControllerV1.this.f8281e.mo19064j().getCurrentInfo();
                }
                if ((!Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE.equals(this.f9049d) || DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY) && ((!Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE.equals(this.f9049d) || DeviceHelper.f13840T) && CameraController.f8274f > 0)) {
                    CameraController.f8274f--;
                }
                if (CameraController.f8274f == 0) {
                    CameraControllerV1.this.f8281e.mo19045a(this.f9048c, this.f9049d, Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK, Boolean.valueOf(this.f9055j), Integer.valueOf(this.f9050e), Boolean.valueOf(this.f9051f), Integer.valueOf(this.f9052g), Integer.valueOf(this.f9053h), Long.valueOf(this.f9054i), Boolean.valueOf(this.f9056k), this.f9058m);
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$j */
    /* compiled from: CameraControllerV1 */
    private final class C2004j implements Camera.ShutterCallback, CameraProxyV1.C2019c {

        /* renamed from: a */
        public static ChangeQuickRedirect f9012a;

        /* renamed from: c */
        private UUID f9014c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f9015d;

        /* renamed from: e */
        private int f9016e;

        /* renamed from: f */
        private boolean f9017f;

        /* renamed from: g */
        private int f9018g;

        /* renamed from: h */
        private int f9019h;

        /* renamed from: i */
        private long f9020i;

        /* renamed from: j */
        private boolean f9021j;

        /* renamed from: k */
        private boolean f9022k;

        /* renamed from: l */
        private boolean f9023l;

        public C2004j(UUID uuid, Contants.CameraService.RequestCode requestCode, int i, boolean z, int i2, int i3, long j, boolean z2, boolean z3, boolean z4) {
            this.f9014c = uuid;
            this.f9015d = requestCode;
            this.f9016e = i;
            this.f9017f = z;
            this.f9018g = i2;
            this.f9019h = i3;
            this.f9020i = j;
            this.f9021j = z2;
            this.f9022k = z4;
            this.f9023l = z3;
        }

        public void onShutter() {
            if (!PatchProxy.proxy(new Object[0], this, f9012a, false, 2945, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15942a(CameraControllerV1.f8728p, "OriginShutterCallback");
                if (Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE.equals(this.f9015d)) {
                    if (CameraController.f8274f > 0) {
                        CameraController.f8274f--;
                    }
                    if (CameraController.f8274f == 0) {
                        CameraControllerV1.this.f8281e.mo19045a(this.f9014c, this.f9015d, Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK, Boolean.valueOf(this.f9021j), Long.valueOf(this.f9020i), Integer.valueOf(this.f9018g), Integer.valueOf(this.f9019h), Integer.valueOf(this.f9016e), Boolean.valueOf(this.f9017f), Boolean.valueOf(this.f9023l), Boolean.valueOf(this.f9022k), null);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo19721a(CameraProxy dVar) {
            if (!PatchProxy.proxy(new Object[]{dVar}, this, f9012a, false, 2946, new Class[]{CameraProxy.class}, Void.TYPE).isSupported) {
                onShutter();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.b$f */
    /* compiled from: CameraControllerV1 */
    public static class C1996f extends CameraController.C1880f<Camera.Face> {
        public C1996f(Camera.Face face) {
            super(face);
        }

        /* renamed from: a */
        public int mo19555a() {
            return ((Camera.Face) this.f8295a).score;
        }

        /* renamed from: b */
        public Rect mo19557b() {
            return ((Camera.Face) this.f8295a).rect;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aD */
    public void m9423aD() {
        if (!PatchProxy.proxy(new Object[0], this, f8727o, false, 2868, new Class[0], Void.TYPE).isSupported) {
            if (!CameraModeType.m10983m(CameraModeType.ModeType.PORTRAIT)) {
                LogUtil.m15942a(f8728p, "currentModeType is not PORTRAIT");
                return;
            }
            LogUtil.m15942a(f8728p, "start configSurfacesByParam");
            mo19491b(this.f8286l);
            Camera.Parameters parameters = ((Camera) this.f8769q.mo19730a()).getParameters();
            int indexOf = DeviceHelper.f14011dc.indexOf(120);
            if (indexOf != -1) {
                int parseInt = Integer.parseInt(DeviceHelper.f14011dc.substring(0, indexOf)) * Integer.parseInt(DeviceHelper.f14011dc.substring(indexOf + 1));
                if (parameters != null) {
                    String str = parameters.get("dualcam-callback-buffers");
                    LogUtil.C2630a aVar = f8728p;
                    LogUtil.m15942a(aVar, "callbackBufferList = " + str);
                    if (str == null) {
                        str = "ci,bi,mdb,mbm,mdw,ldc";
                    }
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    if (str.contains("ci") || str.contains(NotificationStyle.BANNER_IMAGE_URL)) {
                        m9410a((HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2, BaseParameters.KEY_PICTURE_SIZE, String.valueOf(parseInt));
                    }
                    if (str.contains("mbd") || str.contains("mdw")) {
                        m9410a((HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2, "stereo-depth-size", String.valueOf(172800));
                    }
                    synchronized (this.f8285k) {
                        if (!(this.f8283i == null || this.f8282h == null)) {
                            this.f8283i.mo21455a(this.f8282h.mo21444a(hashMap, hashMap2, str), str);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m9410a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2) {
        if (!PatchProxy.proxy(new Object[]{hashMap, hashMap2, str, str2}, this, f8727o, false, 2869, new Class[]{HashMap.class, HashMap.class, String.class, String.class}, Void.TYPE).isSupported && hashMap != null && hashMap2 != null) {
            hashMap2.put(str, str2);
            if (hashMap.get(str) == null || Integer.parseInt(hashMap.get(str)) <= Integer.parseInt(str2)) {
                hashMap.put(str, str2);
            }
        }
    }

    /* renamed from: a */
    private void m9409a(RuntimeException runtimeException) {
        if (!PatchProxy.proxy(new Object[]{runtimeException}, this, f8727o, false, 2870, new Class[]{RuntimeException.class}, Void.TYPE).isSupported) {
            DeviceUtil.m16195a(runtimeException);
        }
    }
}
