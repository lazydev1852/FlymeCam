package com.meizu.media.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.arcsoft.livebroadcast.ArcSpotlightOffscreen;
import com.mediatek.view.impl.ViewDebugManagerImpl;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.FaceBeautyData;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p067d.Rational;
import com.meizu.media.camera.p068e.FBProcessTask;
import com.meizu.media.camera.p068e.FBStorage;
import com.meizu.media.camera.singlebokeh.BokehProcessTask;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.mzfunnysnapsdk.MZUtil.HDRenderController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.b */
public class CameraOptTask extends CamIntentTask {

    /* renamed from: A */
    private static Contants.CameraService.Action f7958A;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static boolean f7959C = false;

    /* renamed from: E */
    private static final ArrayList<String> f7960E = new ArrayList<>();

    /* renamed from: t */
    public static ChangeQuickRedirect f7961t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final LogUtil.C2630a f7962u = new LogUtil.C2630a("CameraOptTask");

    /* renamed from: y */
    private static boolean f7963y;

    /* renamed from: z */
    private static boolean f7964z;

    /* renamed from: B */
    private long f7965B;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Queue<Intent> f7966D = new LinkedList();

    /* renamed from: F */
    private C1841a f7967F = new C1841a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7972a;

        /* renamed from: a */
        public void mo19045a(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr) {
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode, resultCode, objArr}, this, f7972a, false, 835, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, Contants.CameraService.ResultCode.class, Object[].class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8380b(uuid, requestCode, resultCode, objArr);
            }
        }

        /* renamed from: b */
        public void mo19053b(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr) {
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode, resultCode, objArr}, this, f7972a, false, 836, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, Contants.CameraService.ResultCode.class, Object[].class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8391c(uuid, requestCode, resultCode, objArr);
            }
        }

        /* renamed from: a */
        public boolean mo19051a(boolean z) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7972a, false, 837, new Class[]{Boolean.TYPE}, Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraOptTask.this.mo18694a(z);
        }

        /* renamed from: a */
        public CamIntentTask.C1777c mo19040a(UUID uuid) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f7972a, false, 838, new Class[]{UUID.class}, CamIntentTask.C1777c.class);
            return proxy.isSupported ? (CamIntentTask.C1777c) proxy.result : CameraOptTask.this.mo18690a(uuid);
        }

        /* renamed from: b */
        public boolean mo19055b(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f7972a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 839, new Class[]{Boolean.TYPE}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            CameraOptTask bVar = CameraOptTask.this;
            return CameraOptTask.m8394c(z);
        }

        /* renamed from: a */
        public boolean mo19050a() {
            return CameraOptTask.this.f7429p;
        }

        /* renamed from: b */
        public boolean mo19054b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 840, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraOptTask.this.mo18698e();
        }

        /* renamed from: c */
        public boolean mo19057c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 841, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraOptTask.this.mo18699f();
        }

        /* renamed from: d */
        public Handler mo19058d() {
            return CameraOptTask.this.f7423d;
        }

        /* renamed from: e */
        public Queue<Intent> mo19059e() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 842, new Class[0], Queue.class);
            return proxy.isSupported ? (Queue) proxy.result : CameraOptTask.this.f7966D;
        }

        /* renamed from: f */
        public Handler mo19060f() {
            return CameraOptTask.this.f7424e;
        }

        /* renamed from: a */
        public void mo19041a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f7972a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 843, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8348a(i);
            }
        }

        /* renamed from: a */
        public void mo19044a(UUID uuid, Contants.CameraService.RequestCode requestCode) {
            Class[] clsArr = {UUID.class, Contants.CameraService.RequestCode.class};
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode}, this, f7972a, false, 844, clsArr, Void.TYPE).isSupported) {
                CameraOptTask.this.m8362a(uuid, requestCode);
            }
        }

        /* renamed from: g */
        public void mo19061g() {
            if (!PatchProxy.proxy(new Object[0], this, f7972a, false, 845, new Class[0], Void.TYPE).isSupported && CameraOptTask.this.f7968G != null) {
                CameraOptTask.this.f7423d.removeCallbacks(CameraOptTask.this.f7968G);
                mo19043a((Object) CameraOptTask.this.f7968G);
            }
        }

        /* renamed from: h */
        public boolean mo19062h() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 846, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraOptTask.f7959C;
        }

        /* renamed from: a */
        public void mo19043a(Object obj) {
            if (!PatchProxy.proxy(new Object[]{obj}, this, f7972a, false, 847, new Class[]{Object.class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8361a(obj);
            }
        }

        /* renamed from: a */
        public void mo19042a(ParamData fVar) {
            if (!PatchProxy.proxy(new Object[]{fVar}, this, f7972a, false, 848, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8376b(fVar);
            }
        }

        /* renamed from: a */
        public void mo19048a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i4), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), new Byte(z5 ? (byte) 1 : 0)}, this, f7972a, false, 849, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8383b(uuid, requestCode, bArr, str, j, location, i, i2, i3, cVar, z, z2, i4, z3, z4, z5);
            }
        }

        /* renamed from: b */
        public void mo19052b(ParamData fVar) {
            if (!PatchProxy.proxy(new Object[]{fVar}, this, f7972a, false, 850, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8389c(fVar);
            }
        }

        /* renamed from: c */
        public void mo19056c(ParamData fVar) {
            if (!PatchProxy.proxy(new Object[]{fVar}, this, f7972a, false, 851, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8398d(fVar);
            }
        }

        /* renamed from: a */
        public void mo19049a(UUID uuid, byte[] bArr, int i, int i2, int i3, long j, int i4, boolean z, Location location, boolean z2, Contants.CameraService.RequestCode requestCode, XmpMetaData gVar) {
            if (!PatchProxy.proxy(new Object[]{uuid, bArr, new Integer(i), new Integer(i2), new Integer(i3), new Long(j), new Integer(i4), new Byte(z ? (byte) 1 : 0), location, new Byte(z2 ? (byte) 1 : 0), requestCode, gVar}, this, f7972a, false, 852, new Class[]{UUID.class, byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Integer.TYPE, Boolean.TYPE, Location.class, Boolean.TYPE, Contants.CameraService.RequestCode.class, XmpMetaData.class}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8369a(uuid, bArr, i, i2, i3, j, i4, z, location, z2, requestCode, gVar);
            }
        }

        /* renamed from: a */
        public void mo19047a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2) {
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f7972a, false, 853, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8366a(uuid, requestCode, bArr, str, j, location, i, i2, i3, cVar, z, z2);
            }
        }

        /* renamed from: a */
        public void mo19046a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, XmpMetaData gVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
            if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar, gVar, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i4), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), new Byte(z5 ? (byte) 1 : 0)}, this, f7972a, false, 854, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, XmpMetaData.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                CameraOptTask.this.m8364a(uuid, requestCode, bArr, str, j, location, i, i2, i3, cVar, gVar, z, z2, i4, z3, z4, z4);
            }
        }

        /* renamed from: i */
        public boolean mo19063i() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 855, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraOptTask.this.mo18701h();
        }

        /* renamed from: j */
        public HDRenderController mo19064j() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7972a, false, 856, new Class[0], HDRenderController.class);
            if (proxy.isSupported) {
                return (HDRenderController) proxy.result;
            }
            if (CameraOptTask.this.f7971x == null) {
                HDRenderController unused = CameraOptTask.this.f7971x = new HDRenderController(CameraOptTask.this.f7428o.getResources());
            }
            return CameraOptTask.this.f7971x;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C1842b f7968G;

    /* renamed from: v */
    private Handler f7969v = new Handler(Looper.getMainLooper());

    /* renamed from: w */
    private CameraController f7970w = CameraController.m8868g();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public HDRenderController f7971x;

    /* renamed from: com.meizu.media.camera.b$a */
    /* compiled from: CameraOptTask */
    public interface C1841a {
        /* renamed from: a */
        CamIntentTask.C1777c mo19040a(UUID uuid);

        /* renamed from: a */
        void mo19041a(int i);

        /* renamed from: a */
        void mo19042a(ParamData fVar);

        /* renamed from: a */
        void mo19043a(Object obj);

        /* renamed from: a */
        void mo19044a(UUID uuid, Contants.CameraService.RequestCode requestCode);

        /* renamed from: a */
        void mo19045a(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr);

        /* renamed from: a */
        void mo19046a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, XmpMetaData gVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5);

        /* renamed from: a */
        void mo19047a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2);

        /* renamed from: a */
        void mo19048a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5);

        /* renamed from: a */
        void mo19049a(UUID uuid, byte[] bArr, int i, int i2, int i3, long j, int i4, boolean z, Location location, boolean z2, Contants.CameraService.RequestCode requestCode, XmpMetaData gVar);

        /* renamed from: a */
        boolean mo19050a();

        /* renamed from: a */
        boolean mo19051a(boolean z);

        /* renamed from: b */
        void mo19052b(ParamData fVar);

        /* renamed from: b */
        void mo19053b(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr);

        /* renamed from: b */
        boolean mo19054b();

        /* renamed from: b */
        boolean mo19055b(boolean z);

        /* renamed from: c */
        void mo19056c(ParamData fVar);

        /* renamed from: c */
        boolean mo19057c();

        /* renamed from: d */
        Handler mo19058d();

        /* renamed from: e */
        Queue<Intent> mo19059e();

        /* renamed from: f */
        Handler mo19060f();

        /* renamed from: g */
        void mo19061g();

        /* renamed from: h */
        boolean mo19062h();

        /* renamed from: i */
        boolean mo19063i();

        /* renamed from: j */
        HDRenderController mo19064j();
    }

    /* renamed from: t */
    public static boolean m8417t() {
        return f7958A == Contants.CameraService.Action.ACTION_TAKE_BURST_PICTURE;
    }

    public CameraOptTask(Context context) {
        super(context);
        this.f7970w.mo19464a(this.f7967F);
        LogUtil.C2630a aVar = f7962u;
        LogUtil.m15942a(aVar, "setCameraOptTaskListener mCameraOptTaskListener:" + this.f7967F);
    }

    /* renamed from: a */
    public void mo18692a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 761, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7962u;
            LogUtil.m15942a(aVar, "setCameraOptTaskListener mCameraOptTaskListener:" + this.f7967F);
            this.f7970w.mo19464a(this.f7967F);
            super.mo18692a(intent);
        }
    }

    /* renamed from: b */
    public void mo18695b() {
        if (!PatchProxy.proxy(new Object[0], this, f7961t, false, 762, new Class[0], Void.TYPE).isSupported) {
            synchronized (f7415s) {
                if (!this.f7970w.mo19444H() && this.f7427j.isEmpty() && ((this.f7425f == null || this.f7425f.isEmpty()) && ((this.f7426g == null || this.f7426g.isEmpty()) && this.f7970w.mo19522k() == null && ((DeviceHelper.f13858aK != DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL || this.f7966D.size() <= 0) && this.f7430q)))) {
                    super.mo18695b();
                    m8420x();
                    LogUtil.C2630a aVar = f7962u;
                    LogUtil.m15942a(aVar, "release this:" + this);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo18696c() {
        CamIntentTask.C1778d dVar;
        String str;
        if (!PatchProxy.proxy(new Object[0], this, f7961t, false, 763, new Class[0], Void.TYPE).isSupported && (dVar = (CamIntentTask.C1778d) this.f7427j.peek()) != null) {
            Intent intent = dVar.f7436a;
            String action = intent.getAction();
            Contants.CameraService.Action valueOf = Contants.CameraService.Action.valueOf(action);
            boolean booleanExtra = intent.getBooleanExtra("needFastThumbnail", false);
            boolean booleanExtra2 = intent.getBooleanExtra("isFBOn", false);
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            LogUtil.C2630a aVar = f7962u;
            StringBuilder sb = new StringBuilder();
            sb.append("action:");
            sb.append(action);
            sb.append("   requestCode:");
            if (requestCode == null) {
                str = "null";
            } else {
                str = requestCode.name();
            }
            sb.append(str);
            sb.append("   needFastThumbnail:");
            sb.append(booleanExtra);
            sb.append("   CameraController.getPostViewTasks():");
            sb.append(CameraController.m8859P());
            sb.append("  CameraController.getCaptureTasks():");
            sb.append(CameraController.m8860Q());
            LogUtil.m15942a(aVar, sb.toString());
            if (CameraController.m8868g().mo19535r() && (Contants.CameraService.Action.ACTION_AUTO_FOCUS.equals(valueOf) || Contants.CameraService.Action.ACTION_CANCEL_AUTO_FOCUS.equals(valueOf) || ((Contants.CameraService.Action.ACTION_CLOSE_CAMERA.equals(valueOf) && CameraController.m8860Q() == 0) || Contants.CameraService.Action.ACTION_SWITCH_CAMERA.equals(valueOf)))) {
                LogUtil.m15942a(f7962u, "focusing will be break!!");
            } else if (CameraController.m8857N() && Contants.CameraService.Action.ACTION_AUTO_FOCUS.equals(valueOf)) {
                LogUtil.m15942a(f7962u, "do focus while capturin!!");
            } else if (!CameraController.m8868g().mo19535r() && CameraController.m8857N() && Contants.CameraService.Action.ACTION_CANCEL_AUTO_FOCUS.equals(valueOf)) {
                this.f7427j.poll();
                return;
            } else if (Contants.CameraService.Action.ACTION_TAKE_STEREO_PICTURE.equals(valueOf) || (Contants.CameraService.Action.ACTION_TAKE_PICTURE.equals(valueOf) && (booleanExtra || booleanExtra2))) {
                long currentTimeMillis = System.currentTimeMillis();
                int P = CameraController.m8859P();
                while (true) {
                    if (!CameraController.m8852I()) {
                        break;
                    }
                    Log.d("while", "block in take pic CameraController.getPostViewTasks():" + CameraController.m8859P());
                    if (P != CameraController.m8859P()) {
                        P = CameraController.m8859P();
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                        LogUtil.m15949b(f7962u, "Blocking in GeneratingPostView takes more than 5s, force return!!!");
                        if (CameraController.m8857N()) {
                            m8380b((UUID) intent.getSerializableExtra("uuid"), requestCode, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                        }
                        CameraController.m8861R();
                        CameraController.m8862S();
                        m8348a(CameraController.m8860Q());
                    } else {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (!Contants.CameraService.Action.ACTION_CLOSE_CAMERA.equals(valueOf) || this.f7966D.peek() == null || DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE || DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG || (!DeviceHelper.f13840T && DeviceHelper.f13858aK != DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                int Q = CameraController.m8860Q();
                while (true) {
                    if (!mo18702i() || dVar.f7437b) {
                        break;
                    }
                    if (Q != CameraController.m8860Q()) {
                        Q = CameraController.m8860Q();
                        currentTimeMillis2 = System.currentTimeMillis();
                    }
                    Log.d("while", "block in other enumAction:" + valueOf);
                    int i = ViewDebugManagerImpl.INPUT_TIMEOUT;
                    if (CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) && DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                        i = 15000;
                    }
                    if (System.currentTimeMillis() - currentTimeMillis2 > ((long) i)) {
                        LogUtil.m15949b(f7962u, "Blocking takes more than 6s, force return!!!");
                        if (CameraController.m8857N()) {
                            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
                            if (!CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT) && !CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING)) {
                                m8380b(uuid, Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_PICTURE, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED, new Object[0]);
                            }
                        }
                        CameraController.m8861R();
                        CameraController.m8862S();
                        m8348a(CameraController.m8860Q());
                        CameraController.m8868g().mo19496b(false);
                    } else {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                UUID uuid2 = (UUID) this.f7966D.peek().getSerializableExtra("uuid");
                if (DeviceHelper.f13840T) {
                    CameraController.m8861R();
                    CameraController.m8862S();
                    this.f7966D.poll();
                }
                m8348a(CameraController.m8860Q());
                m8380b(uuid2, Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
            }
            if (dVar.f7437b) {
                this.f7427j.poll();
                return;
            }
            synchronized (f7415s) {
                this.f7430q = false;
                if (this.f7424e != null && this.f7424e.hasMessages(1)) {
                    LogUtil.m15952c(f7962u, "removeMessages RELEASE_TASK");
                    this.f7424e.removeMessages(1);
                }
                this.f7427j.poll();
            }
            f7958A = valueOf;
            switch (valueOf) {
                case ACTION_RESUME_CAMERA:
                    m8375b(intent);
                    return;
                case ACTION_OPEN_CAMERA:
                    m8397d(intent);
                    return;
                case ACTION_SWITCH_CAMERA:
                    m8388c(intent);
                    return;
                case ACTION_START_PREVIEW:
                    m8400e(intent);
                    return;
                case ACTION_STOP_PREVIEW:
                    m8403f(intent);
                    return;
                case ACTION_CLOSE_CAMERA:
                    m8408j(intent);
                    return;
                case ACTION_RESTART_PREVIEW:
                    m8405g(intent);
                    return;
                case ACTION_START_FACE_DETECTION:
                    m8409k(intent);
                    return;
                case ACTION_STOP_FACE_DETECTION:
                    m8410l(intent);
                    return;
                case ACTION_TAKE_PICTURE:
                    m8414p(intent);
                    return;
                case ACTION_TAKE_STEREO_PICTURE:
                    this.f7966D.add(intent);
                    m8413o(intent);
                    return;
                case ACTION_TAKE_BURST_PICTURE:
                    m8412n(intent);
                    return;
                case ACTION_TAKE_SUPER_NIGHT_PICTURE:
                    m8415q(intent);
                    return;
                case ACTION_TAKE_TOF_PICTURE:
                    m8416r(intent);
                    return;
                case ACTION_STOP_BURST:
                    m8411m(intent);
                    return;
                case ACTION_AUTO_FOCUS:
                    m8406h(intent);
                    return;
                case ACTION_CANCEL_AUTO_FOCUS:
                    m8407i(intent);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public static Intent m8340a(Context context, String str, int i, CameraModeType.ModeType modeType, boolean z, boolean z2, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Context context2 = context;
        String str2 = str;
        int i2 = i;
        CameraModeType.ModeType modeType2 = modeType;
        boolean z3 = z;
        boolean z4 = z2;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        Object[] objArr = {context2, str2, new Integer(i2), modeType2, new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), uuid2, requestCode2};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 764, new Class[]{Context.class, String.class, Integer.TYPE, CameraModeType.ModeType.class, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_RESUME_CAMERA.name());
        intent.putExtra("from", str2);
        intent.putExtra("cameraId", i2);
        intent.putExtra("modeType", modeType2);
        intent.putExtra("stereoOn", z3);
        intent.putExtra("EXTRA_IS_WATCH_CAMERA_INTENT", z4);
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8335a(Context context, int i, CameraModeType.ModeType modeType, boolean z, boolean z2, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Context context2 = context;
        int i2 = i;
        CameraModeType.ModeType modeType2 = modeType;
        boolean z3 = z;
        boolean z4 = z2;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        Object[] objArr = {context2, new Integer(i2), modeType2, new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), uuid2, requestCode2};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 765, new Class[]{Context.class, Integer.TYPE, CameraModeType.ModeType.class, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_OPEN_CAMERA.name());
        intent.putExtra("cameraId", i2);
        intent.putExtra("modeType", modeType2);
        intent.putExtra("stereoOn", z3);
        intent.putExtra("EXTRA_IS_WATCH_CAMERA_INTENT", z4);
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8344a(Context context, boolean z, int i, CameraModeType.ModeType modeType, boolean z2, boolean z3, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Context context2 = context;
        boolean z4 = z;
        int i2 = i;
        CameraModeType.ModeType modeType2 = modeType;
        boolean z5 = z2;
        boolean z6 = z3;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        Object[] objArr = {context2, new Byte(z4 ? (byte) 1 : 0), new Integer(i2), modeType2, new Byte(z5 ? (byte) 1 : 0), new Byte(z6 ? (byte) 1 : 0), uuid2, requestCode2};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 766, new Class[]{Context.class, Boolean.TYPE, Integer.TYPE, CameraModeType.ModeType.class, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        LogUtil.m15942a(f7962u, "createSwitchCameraIntent");
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_SWITCH_CAMERA.name());
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("shouldStopFaceDetection", z4);
        intent.putExtra("cameraId", i2);
        intent.putExtra("modeType", modeType2);
        intent.putExtra("stereoOn", z5);
        intent.putExtra("EXTRA_IS_WATCH_CAMERA_INTENT", z6);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8343a(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, 767, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_AUTO_FOCUS.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: b */
    public static Intent m8372b(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, 768, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_CANCEL_AUTO_FOCUS.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8342a(Context context, UUID uuid, CameraModeType.ModeType modeType, Contants.CameraService.RequestCode requestCode) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, modeType, requestCode}, (Object) null, f7961t, true, 769, new Class[]{Context.class, UUID.class, CameraModeType.ModeType.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_START_PREVIEW.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        intent.putExtra("modeType", modeType);
        return intent;
    }

    /* renamed from: c */
    public static Intent m8385c(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, ArcSpotlightOffscreen.ASVL_PAF_RGB32_B8G8R8A8, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_STOP_PREVIEW.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8341a(Context context, String str, boolean z, boolean z2, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Object[] objArr = {context, str, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), uuid, requestCode};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 771, new Class[]{Context.class, String.class, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("from", str);
        intent.putExtra("requestCode", requestCode);
        intent.putExtra("shouldStopFaceDetection", z);
        intent.putExtra("EXTRA_IS_WATCH_CAMERA_INTENT", z2);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8345a(Context context, boolean z, CameraModeType.ModeType modeType, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, new Byte(z ? (byte) 1 : 0), modeType, uuid, requestCode}, (Object) null, f7961t, true, 772, new Class[]{Context.class, Boolean.TYPE, CameraModeType.ModeType.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_RESTART_PREVIEW.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("needSetPreviewTexture", z);
        intent.putExtra("modeType", modeType);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: d */
    public static Intent m8395d(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, ArcSpotlightOffscreen.ASVL_PAF_RGB32_R8G8B8A8, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_START_FACE_DETECTION.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: e */
    public static Intent m8399e(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, 774, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_STOP_FACE_DETECTION.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8336a(Context context, Location location, int i, int i2, int i3, long j, long j2, int i4, FaceBeautyData dVar, String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Location location2 = location;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        long j3 = j2;
        int i8 = i4;
        FaceBeautyData dVar2 = dVar;
        String str3 = str;
        boolean z11 = z;
        boolean z12 = z2;
        boolean z13 = z3;
        String str4 = str2;
        boolean z14 = z4;
        Object[] objArr = new Object[23];
        objArr[0] = context;
        objArr[1] = location2;
        objArr[2] = new Integer(i5);
        objArr[3] = new Integer(i6);
        objArr[4] = new Integer(i7);
        objArr[5] = new Long(j);
        objArr[6] = new Long(j3);
        objArr[7] = new Integer(i8);
        objArr[8] = dVar2;
        objArr[9] = str3;
        objArr[10] = new Byte(z11 ? (byte) 1 : 0);
        objArr[11] = new Byte(z12 ? (byte) 1 : 0);
        objArr[12] = new Byte(z13 ? (byte) 1 : 0);
        Object[] objArr2 = objArr;
        objArr2[13] = str2;
        objArr2[14] = new Byte(z4 ? (byte) 1 : 0);
        objArr2[15] = new Byte(z5 ? (byte) 1 : 0);
        objArr2[16] = new Byte(z6 ? (byte) 1 : 0);
        objArr2[17] = new Byte(z7 ? (byte) 1 : 0);
        objArr2[18] = new Byte(z8 ? (byte) 1 : 0);
        objArr2[19] = new Byte(z9 ? (byte) 1 : 0);
        objArr2[20] = new Byte(z10 ? (byte) 1 : 0);
        UUID uuid2 = uuid;
        objArr2[21] = uuid2;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        objArr2[22] = requestCode2;
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, (Object) null, changeQuickRedirect, true, 775, new Class[]{Context.class, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE, FaceBeautyData.class, String.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, String.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent();
        intent.setAction(Contants.CameraService.Action.ACTION_TAKE_PICTURE.name());
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("location", location2);
        intent.putExtra("width", i5);
        intent.putExtra("height", i6);
        intent.putExtra("jpegRotation", i7);
        intent.putExtra("captureStartTime", j3);
        intent.putExtra("currentHeading", i8);
        intent.putExtra("fbData", dVar2);
        intent.putExtra("filterEffect", str3);
        intent.putExtra("mirror", z11);
        intent.putExtra("isSquareMode", z12);
        intent.putExtra("needFastThumbnail", z13);
        intent.putExtra("usercomment", str2);
        intent.putExtra("isImageCaptureIntent", z4);
        intent.putExtra("shutterSpeed", j);
        intent.putExtra("isFBOn", z5);
        intent.putExtra("isBokehOn", z6);
        intent.putExtra("isFunnyOn", z8);
        intent.putExtra("isTofOn", z7);
        intent.putExtra("frontFlash", z9);
        intent.putExtra("manualHighPic", z10);
        return intent;
    }

    /* renamed from: f */
    public static Intent m8402f(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, 776, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_TAKE_BURST_PICTURE.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8339a(Context context, Location location, UUID uuid, Contants.CameraService.RequestCode requestCode, int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Context context2 = context;
        Location location2 = location;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        boolean z8 = z;
        boolean z9 = z2;
        boolean z10 = z3;
        boolean z11 = z4;
        boolean z12 = z6;
        Object[] objArr = new Object[15];
        objArr[0] = context2;
        objArr[1] = location2;
        objArr[2] = uuid2;
        objArr[3] = requestCode2;
        objArr[4] = new Integer(i4);
        objArr[5] = new Integer(i5);
        objArr[6] = new Integer(i6);
        objArr[7] = new Long(j2);
        objArr[8] = new Byte(z8 ? (byte) 1 : 0);
        objArr[9] = new Byte(z9 ? (byte) 1 : 0);
        objArr[10] = new Byte(z10 ? (byte) 1 : 0);
        objArr[11] = new Byte(z11 ? (byte) 1 : 0);
        objArr[12] = new Byte(z5 ? (byte) 1 : 0);
        Object[] objArr2 = objArr;
        objArr2[13] = new Byte(z6 ? (byte) 1 : 0);
        boolean z13 = z7;
        objArr2[14] = new Byte(z13 ? (byte) 1 : 0);
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, (Object) null, changeQuickRedirect, true, 777, new Class[]{Context.class, Location.class, UUID.class, Contants.CameraService.RequestCode.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_TAKE_SUPER_NIGHT_PICTURE.name());
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("location", location2);
        intent.putExtra("width", i4);
        intent.putExtra("height", i5);
        intent.putExtra("jpegRotation", i6);
        intent.putExtra("captureStartTime", j2);
        intent.putExtra("isHand", z8);
        intent.putExtra("deviceMark", z9);
        intent.putExtra("timeMark", z10);
        intent.putExtra("isFBOn", z11);
        intent.putExtra("isday", z5);
        intent.putExtra("mirror", z6);
        intent.putExtra("frontMirror", z13);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8338a(Context context, Location location, int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Context context2 = context;
        Location location2 = location;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        boolean z6 = z;
        boolean z7 = z2;
        boolean z8 = z3;
        boolean z9 = z4;
        boolean z10 = z5;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        Object[] objArr = {context2, location2, new Integer(i4), new Integer(i5), new Integer(i6), new Long(j2), new Byte(z6 ? (byte) 1 : 0), new Byte(z7 ? (byte) 1 : 0), new Byte(z8 ? (byte) 1 : 0), new Byte(z9 ? (byte) 1 : 0), new Byte(z10 ? (byte) 1 : 0), uuid2, requestCode2};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 778, new Class[]{Context.class, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_TAKE_TOF_PICTURE.name());
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("location", location2);
        intent.putExtra("width", i4);
        intent.putExtra("height", i5);
        intent.putExtra("jpegRotation", i6);
        intent.putExtra("captureStartTime", j2);
        intent.putExtra("isImageCaptureIntent", z6);
        intent.putExtra("mirror", z7);
        intent.putExtra("deviceMark", z8);
        intent.putExtra("timeMark", z9);
        intent.putExtra("portraitRecord", z10);
        return intent;
    }

    /* renamed from: g */
    public static Intent m8404g(Context context, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uuid, requestCode}, (Object) null, changeQuickRedirect, true, 779, new Class[]{Context.class, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_STOP_BURST.name());
        intent.putExtra("uuid", uuid);
        intent.putExtra("requestCode", requestCode);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8337a(Context context, Location location, int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3, boolean z4, UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Context context2 = context;
        Location location2 = location;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        Object[] objArr = {context2, location2, new Integer(i4), new Integer(i5), new Integer(i6), new Long(j2), new Byte(z5 ? (byte) 1 : 0), new Byte(z6 ? (byte) 1 : 0), new Byte(z7 ? (byte) 1 : 0), new Byte(z8 ? (byte) 1 : 0), uuid2, requestCode2};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 780, new Class[]{Context.class, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, UUID.class, Contants.CameraService.RequestCode.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent(context2, CameraOptTask.class);
        intent.setAction(Contants.CameraService.Action.ACTION_TAKE_STEREO_PICTURE.name());
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("location", location2);
        intent.putExtra("width", i4);
        intent.putExtra("height", i5);
        intent.putExtra("jpegRotation", i6);
        intent.putExtra("captureStartTime", j2);
        intent.putExtra("isImageCaptureIntent", z5);
        intent.putExtra("mirror", z6);
        intent.putExtra("deviceMark", z7);
        intent.putExtra("timeMark", z8);
        return intent;
    }

    /* renamed from: b */
    public static void m8384b(boolean z) {
        if (f7959C != z) {
            f7959C = z;
        }
    }

    /* renamed from: b */
    private void m8375b(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 781, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            boolean booleanExtra = intent.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false);
            LogUtil.C2630a aVar = f7962u;
            LogUtil.m15942a(aVar, "resumeCamera isWatch:" + booleanExtra);
            if (mo18694a(booleanExtra)) {
                LogUtil.m15942a(f7962u, "Cancel resume camera case Next action is close camera");
                m8391c(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
            } else if (mo18698e()) {
                LogUtil.m15942a(f7962u, "Cancel resume camera case Next action is switchCamera");
                m8391c(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
            } else {
                this.f7970w.mo19502c(intent);
            }
        }
    }

    /* renamed from: c */
    private void m8388c(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 782, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            if (mo18698e()) {
                LogUtil.m15942a(f7962u, "Cancel switchCamera case Next action is switchCamera");
                m8391c((UUID) intent.getSerializableExtra("uuid"), (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode"), Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
                return;
            }
            m8408j(intent);
            m8375b(intent);
        }
    }

    /* renamed from: d */
    private void m8397d(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 783, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            this.f7970w.mo19492b(intent);
        }
    }

    /* renamed from: e */
    private void m8400e(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 784, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            CameraProxy k = CameraController.m8868g().mo19522k();
            CamIntentTask.C1777c a = mo18690a(uuid);
            if (mo18698e() || mo18699f() || mo18697d() || mo18700g()) {
                m8391c(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
            } else if (k == null || a == null) {
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            } else {
                CameraController.m8868g().mo19513f(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
            }
        }
    }

    /* renamed from: f */
    private void m8403f(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 785, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (mo18698e() || mo18699f() || mo18697d()) {
                m8391c(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_CANCEL, new Object[0]);
            } else if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19510e(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
            } else {
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            }
        }
    }

    /* renamed from: g */
    private void m8405g(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 786, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19507d(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* renamed from: h */
    private void m8406h(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 787, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                this.f7970w.mo19517h(intent);
            } else {
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            }
        }
    }

    /* renamed from: i */
    private void m8407i(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 788, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19519i(intent);
                this.f7967F.mo19045a(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                CameraController.m8868g().mo19496b(false);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8362a(UUID uuid, Contants.CameraService.RequestCode requestCode) {
        Class[] clsArr = {UUID.class, Contants.CameraService.RequestCode.class};
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode}, this, f7961t, false, 789, clsArr, Void.TYPE).isSupported) {
            if (this.f7968G != null) {
                this.f7423d.removeCallbacks(this.f7968G);
                m8361a((Object) this.f7968G);
            }
            this.f7968G = new C1842b(uuid, requestCode);
            this.f7423d.postDelayed(this.f7968G, 2000);
            if (this.f7426g != null) {
                this.f7426g.add(this.f7968G);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.b$b */
    /* compiled from: CameraOptTask */
    private class C1842b implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f7993a;

        /* renamed from: c */
        private UUID f7995c;

        /* renamed from: d */
        private Contants.CameraService.RequestCode f7996d;

        public C1842b(UUID uuid, Contants.CameraService.RequestCode requestCode) {
            this.f7995c = uuid;
            this.f7996d = requestCode;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f7993a, false, 861, new Class[0], Void.TYPE).isSupported) {
                LogUtil.C2630a z = CameraOptTask.f7962u;
                LogUtil.m15942a(z, "focus timeout, cancel autoFocus mFocusing:" + CameraController.m8868g().mo19535r());
                if (CameraController.m8868g().mo19535r()) {
                    CameraController.m8868g().mo19496b(false);
                    CameraOptTask.this.m8380b(this.f7995c, this.f7996d, Contants.CameraService.ResultCode.RESULT_AUTO_FOCUS_CALLBACK, false);
                }
                CameraOptTask.this.m8361a((Object) this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m8361a(java.lang.Object r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0032 }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x0032 }
            com.meizu.savior.ChangeQuickRedirect r3 = f7961t     // Catch:{ all -> 0x0032 }
            r4 = 0
            r5 = 790(0x316, float:1.107E-42)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0032 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r6[r2] = r0     // Catch:{ all -> 0x0032 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0032 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x001f
            monitor-exit(r8)
            return
        L_0x001f:
            java.util.List r0 = r8.f7426g     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            java.util.List r0 = r8.f7426g     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.contains(r9)     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            java.util.List r0 = r8.f7426g     // Catch:{ all -> 0x0032 }
            r0.remove(r9)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r8)
            return
        L_0x0032:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8361a(java.lang.Object):void");
    }

    /* renamed from: j */
    private void m8408j(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 791, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            this.f7970w.mo19515g(intent);
        }
    }

    /* renamed from: k */
    private void m8409k(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 792, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            CameraController.m8868g().mo19531o(intent);
        }
    }

    /* renamed from: l */
    private void m8410l(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 793, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            CameraController.m8868g().mo19533p(intent);
        }
    }

    /* renamed from: m */
    private void m8411m(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 794, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (mo18690a(uuid) == null || !mo18690a(uuid).mo18237g()) {
                LogUtil.m15942a(f7962u, "endBurst");
                this.f7970w.mo19529n(intent);
                return;
            }
            LogUtil.m15942a(f7962u, "stop endBurst has done, shouldn't endBurst");
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
        }
    }

    /* renamed from: n */
    private void m8412n(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 795, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (mo18690a(uuid) != null && mo18690a(uuid).mo18237g()) {
                LogUtil.m15942a(f7962u, "stopBurst has done, shouldn't continuous take burst picture");
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL, new Object[0]);
            } else if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8863T();
                CameraController.m8864U();
                LogUtil.m15952c(f7962u, "takeBurstPictureEx");
                this.f7970w.mo19527m(intent);
            } else {
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
            }
        }
    }

    /* renamed from: o */
    private void m8413o(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 796, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                this.f7970w.mo19523k(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* renamed from: p */
    private void m8414p(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 797, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (intent.getBooleanExtra("isFunnyOn", false) && this.f7971x == null) {
                this.f7971x = new HDRenderController(this.f7428o.getResources());
            }
            if (CameraController.m8868g().mo19522k() != null) {
                this.f7970w.mo19521j(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* renamed from: q */
    private void m8415q(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 798, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                this.f7970w.mo19453a(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* renamed from: r */
    private void m8416r(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7961t, false, 799, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent.getSerializableExtra("requestCode");
            if (CameraController.m8868g().mo19522k() != null) {
                this.f7970w.mo19525l(intent);
                m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_OK, new Object[0]);
                return;
            }
            m8380b(uuid, requestCode, Contants.CameraService.ResultCode.RESULT_NULL_CAMERA, new Object[0]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r2v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8366a(java.util.UUID r28, com.meizu.media.camera.util.Contants.CameraService.RequestCode r29, byte[] r30, java.lang.String r31, long r32, android.location.Location r34, int r35, int r36, int r37, com.meizu.media.camera.p067d.ExifInterface r38, boolean r39, boolean r40) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r9 = r29
            r15 = r30
            r13 = r31
            r10 = r35
            r11 = r36
            r14 = r39
            r0 = 12
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r12 = 0
            r1[r12] = r8
            r6 = 1
            r1[r6] = r9
            r23 = 2
            r1[r23] = r15
            r24 = 3
            r1[r24] = r13
            java.lang.Long r2 = new java.lang.Long
            r4 = r32
            r2.<init>(r4)
            r25 = 4
            r1[r25] = r2
            r26 = 5
            r1[r26] = r34
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r3 = 6
            r1[r3] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r11)
            r17 = 7
            r1[r17] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r37
            r2.<init>(r4)
            r5 = 8
            r1[r5] = r2
            r2 = 9
            r1[r2] = r38
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r14)
            r18 = 10
            r1[r18] = r2
            java.lang.Byte r2 = new java.lang.Byte
            r4 = r40
            r2.<init>(r4)
            r19 = 11
            r1[r19] = r2
            com.meizu.savior.ChangeQuickRedirect r2 = f7961t
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.util.UUID> r20 = java.util.UUID.class
            r0[r12] = r20
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r20 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r0[r6] = r20
            java.lang.Class<byte[]> r20 = byte[].class
            r0[r23] = r20
            java.lang.Class<java.lang.String> r20 = java.lang.String.class
            r0[r24] = r20
            java.lang.Class r20 = java.lang.Long.TYPE
            r0[r25] = r20
            java.lang.Class<android.location.Location> r20 = android.location.Location.class
            r0[r26] = r20
            java.lang.Class r20 = java.lang.Integer.TYPE
            r0[r3] = r20
            java.lang.Class r20 = java.lang.Integer.TYPE
            r0[r17] = r20
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r5] = r17
            java.lang.Class<com.meizu.media.camera.d.c> r5 = com.meizu.media.camera.p067d.ExifInterface.class
            r17 = 9
            r0[r17] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r0[r18] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r0[r19] = r5
            java.lang.Class r17 = java.lang.Void.TYPE
            r5 = 0
            r18 = 801(0x321, float:1.122E-42)
            r19 = r0
            r0 = r1
            r1 = r27
            r3 = r5
            r4 = r18
            r5 = r19
            r12 = 1
            r6 = r17
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x00b6
            return
        L_0x00b6:
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "saveStereoImage"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            long r0 = r7.f7965B
            int r2 = r15.length
            long r2 = (long) r2
            long r0 = r0 + r2
            r7.f7965B = r0
            boolean r0 = r27.mo19039u()
            if (r0 == 0) goto L_0x00e7
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r1 = new java.lang.Object[r12]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r3 = 0
            r1[r3] = r2
            r7.m8380b(r8, r9, r0, r1)
            long r0 = r7.f7965B
            int r2 = r15.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r7.f7965B = r0
            return
        L_0x00e7:
            if (r10 == 0) goto L_0x00f0
            if (r11 != 0) goto L_0x00ec
            goto L_0x00f0
        L_0x00ec:
            r1 = r10
            r0 = r11
            r2 = 0
            goto L_0x0100
        L_0x00f0:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inJustDecodeBounds = r12
            int r1 = r15.length
            r2 = 0
            android.graphics.BitmapFactory.decodeByteArray(r15, r2, r1, r0)
            int r1 = r0.outWidth
            int r0 = r0.outHeight
        L_0x0100:
            com.meizu.media.camera.Storage r10 = com.meizu.media.camera.Storage.m7750a()
            android.content.Context r3 = r7.f7428o
            android.content.ContentResolver r11 = r3.getContentResolver()
            r3 = 1
            r12 = r31
            r4 = r13
            r5 = r14
            r13 = r32
            r6 = r15
            r15 = r34
            r16 = r37
            r17 = r38
            r18 = r30
            r19 = r1
            r20 = r0
            r21 = r39
            r22 = r40
            android.net.Uri r10 = r10.mo18616a((android.content.ContentResolver) r11, (java.lang.String) r12, (long) r13, (android.location.Location) r15, (int) r16, (com.meizu.media.camera.p067d.ExifInterface) r17, (byte[]) r18, (int) r19, (int) r20, (boolean) r21, (boolean) r22)
            com.meizu.media.camera.util.ac$a r11 = f7962u
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "addStereoImage uri:"
            r12.append(r13)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r11, (java.lang.String) r12)
            android.content.Intent r11 = new android.content.Intent
            java.lang.String r12 = "com.android.camera.STEREO_PIC"
            r11.<init>(r12, r10)
            java.lang.String r12 = "com.meizu.media.gallery"
            r11.setPackage(r12)
            android.content.Context r12 = r7.f7428o
            r12.sendBroadcast(r11)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r11 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r12 = 6
            java.lang.Object[] r12 = new java.lang.Object[r12]
            android.graphics.Bitmap r13 = r38.mo19842a()
            r12[r2] = r13
            r12[r3] = r6
            java.lang.Integer r13 = java.lang.Integer.valueOf(r37)
            r12[r23] = r13
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r39)
            r12[r24] = r13
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12[r25] = r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r12[r26] = r0
            r7.m8380b(r8, r9, r11, r12)
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r0 = r0.mo18626a((boolean) r5, (java.lang.String) r4)
            if (r10 == 0) goto L_0x0191
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r2] = r10
            r7.m8380b(r8, r9, r1, r4)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r2] = r0
            r7.m8380b(r8, r9, r1, r4)
        L_0x0191:
            boolean r0 = r27.mo19039u()
            long r4 = r7.f7965B
            int r1 = r6.length
            long r10 = (long) r1
            long r4 = r4 - r10
            r7.f7965B = r4
            boolean r1 = r27.mo19039u()
            if (r1 == r0) goto L_0x01af
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r1[r2] = r3
            r7.m8380b(r8, r9, r0, r1)
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8366a(java.util.UUID, com.meizu.media.camera.util.Contants$CameraService$RequestCode, byte[], java.lang.String, long, android.location.Location, int, int, int, com.meizu.media.camera.d.c, boolean, boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01bc A[ADDED_TO_REGION] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8376b(com.meizu.media.camera.p064a.ParamData r33) {
        /*
            r32 = this;
            r15 = r32
            r14 = r33
            r13 = 1
            java.lang.Object[] r0 = new java.lang.Object[r13]
            r12 = 0
            r0[r12] = r14
            com.meizu.savior.ChangeQuickRedirect r2 = f7961t
            java.lang.Class[] r5 = new java.lang.Class[r13]
            java.lang.Class<com.meizu.media.camera.a.f> r1 = com.meizu.media.camera.p064a.ParamData.class
            r5[r12] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 802(0x322, float:1.124E-42)
            r1 = r32
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            java.util.UUID r11 = r14.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r10 = r14.f7471h
            byte[] r9 = r14.f7469f
            int r0 = r14.f7472i
            int r1 = r14.f7473j
            int r8 = r14.f7477n
            boolean r7 = r14.f7474k
            boolean r5 = r14.f7488y
            android.location.Location r6 = r14.f7468e
            com.meizu.media.camera.a.g r4 = r14.f7484u
            long r2 = r14.f7466c
            int r12 = r14.f7467d
            com.meizu.media.camera.d.c r15 = com.meizu.media.camera.Exif.m10044a((byte[]) r9)
            boolean r13 = r14.f7463E
            if (r13 == 0) goto L_0x004b
            boolean r13 = com.meizu.media.camera.mode.CameraModeType.m10955c()
            if (r13 == 0) goto L_0x004b
            r15.mo19869c()
        L_0x004b:
            int r18 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r15)
            int r13 = r8 + r18
            int r13 = r13 % 180
            if (r13 != 0) goto L_0x005a
            r19 = r0
            r20 = r1
            goto L_0x005e
        L_0x005a:
            r20 = r0
            r19 = r1
        L_0x005e:
            java.lang.String r13 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r2)
            r21 = 0
            if (r13 != 0) goto L_0x007e
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Unbalanced name/data pair"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r23 = r5
            r24 = r7
            r26 = r9
            r31 = r10
            r30 = r11
            r17 = r15
            r16 = 1
            r15 = r14
            goto L_0x01b3
        L_0x007e:
            r0 = -1
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r12 < 0) goto L_0x00a9
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9371bc
            java.lang.String r1 = "M"
            com.meizu.media.camera.d.h r0 = r15.mo19845a((int) r0, (java.lang.Object) r1)
            int r1 = com.meizu.media.camera.p067d.ExifInterface.f9372bd
            r22 = r2
            com.meizu.media.camera.d.l r2 = new com.meizu.media.camera.d.l
            r24 = r4
            long r3 = (long) r12
            r25 = r5
            r26 = r6
            r5 = 1
            r2.<init>(r3, r5)
            com.meizu.media.camera.d.h r1 = r15.mo19845a((int) r1, (java.lang.Object) r2)
            r15.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
            r15.mo19846a((com.meizu.media.camera.p067d.ExifTag) r1)
            goto L_0x00b1
        L_0x00a9:
            r22 = r2
            r24 = r4
            r25 = r5
            r26 = r6
        L_0x00b1:
            boolean r0 = r14.f7476m
            if (r0 == 0) goto L_0x00c8
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9346ae
            java.lang.String r1 = "FACEBEAUTY"
            com.meizu.media.camera.d.h r0 = r15.mo19845a((int) r0, (java.lang.Object) r1)
            r15.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "isFBOn test"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x00d3
        L_0x00c8:
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9346ae
            java.lang.String r1 = "NORMAL"
            com.meizu.media.camera.d.h r0 = r15.mo19845a((int) r0, (java.lang.Object) r1)
            r15.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
        L_0x00d3:
            boolean r0 = r14.f7476m
            if (r0 == 0) goto L_0x0136
            r0 = r32
            r1 = r11
            r5 = r22
            r2 = r10
            r3 = r9
            r22 = r24
            r4 = r13
            r23 = r25
            r12 = r26
            r24 = r7
            r7 = r12
            r25 = r8
            r8 = r19
            r26 = r9
            r9 = r20
            r13 = r10
            r10 = r18
            r12 = r11
            r11 = r15
            r28 = r12
            r27 = r15
            r15 = 0
            r12 = r24
            r29 = r13
            r16 = 1
            r13 = r25
            r14 = r22
            r0.m8382b((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (byte[]) r3, (java.lang.String) r4, (long) r5, (android.location.Location) r7, (int) r8, (int) r9, (int) r10, (com.meizu.media.camera.p067d.ExifInterface) r11, (boolean) r12, (int) r13, (com.meizu.media.camera.p064a.XmpMetaData) r14)
            boolean r0 = com.meizu.media.camera.camcontroller.CameraController.m8857N()
            if (r0 == 0) goto L_0x011c
            com.meizu.media.camera.camcontroller.CameraController.m8858O()
            int r0 = com.meizu.media.camera.camcontroller.CameraController.m8860Q()
            r17 = r27
            r14 = r32
            r14.m8348a((int) r0)
            goto L_0x0120
        L_0x011c:
            r17 = r27
            r14 = r32
        L_0x0120:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            java.lang.Object[] r1 = new java.lang.Object[r15]
            r11 = r28
            r10 = r29
            r14.m8380b(r11, r10, r0, r1)
            r31 = r10
            r30 = r11
            r1 = r21
            r0 = 1
            r15 = r33
            goto L_0x01b6
        L_0x0136:
            r17 = r15
            r5 = r22
            r22 = r24
            r23 = r25
            r12 = r26
            r15 = 0
            r16 = 1
            r24 = r7
            r25 = r8
            r26 = r9
            r9 = r14
            r14 = r32
            boolean r0 = r9.f7481r
            if (r0 == 0) goto L_0x0171
            r0 = r32
            r1 = r11
            r2 = r10
            r3 = r26
            r4 = r13
            r7 = r12
            r8 = r19
            r13 = r9
            r9 = r20
            r12 = r10
            r10 = r18
            r30 = r11
            r11 = r17
            r31 = r12
            r12 = r24
            r15 = r13
            r13 = r25
            r14 = r22
            r0.m8365a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (byte[]) r3, (java.lang.String) r4, (long) r5, (android.location.Location) r7, (int) r8, (int) r9, (int) r10, (com.meizu.media.camera.p067d.ExifInterface) r11, (boolean) r12, (int) r13, (com.meizu.media.camera.p064a.XmpMetaData) r14)
            goto L_0x01b3
        L_0x0171:
            r15 = r9
            r31 = r10
            r30 = r11
            boolean r0 = r15.f7482s
            if (r0 == 0) goto L_0x0198
            r0 = r32
            r1 = r30
            r2 = r31
            r3 = r26
            r4 = r13
            r7 = r12
            r8 = r19
            r9 = r20
            r10 = r18
            r11 = r17
            r12 = r24
            r13 = r25
            r14 = r22
            android.graphics.Bitmap r0 = r0.m8396d(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r0
            goto L_0x01b5
        L_0x0198:
            r0 = r32
            r1 = r30
            r2 = r31
            r3 = r26
            r4 = r13
            r7 = r12
            r8 = r19
            r9 = r20
            r10 = r18
            r11 = r17
            r12 = r24
            r13 = r25
            r14 = r22
            r0.m8392c(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x01b3:
            r1 = r21
        L_0x01b5:
            r0 = 0
        L_0x01b6:
            boolean r2 = r15.f7481r
            r2 = r2 ^ 1
            if (r0 != 0) goto L_0x020c
            if (r2 == 0) goto L_0x020c
            if (r23 != 0) goto L_0x020c
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            boolean r3 = r15.f7482s
            if (r3 == 0) goto L_0x01cf
            if (r1 == 0) goto L_0x01cf
            r21 = r1
        L_0x01cd:
            r1 = 0
            goto L_0x01db
        L_0x01cf:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r3) goto L_0x01d6
            goto L_0x01cd
        L_0x01d6:
            android.graphics.Bitmap r21 = r17.mo19842a()
            goto L_0x01cd
        L_0x01db:
            r2[r1] = r21
            r2[r16] = r26
            r1 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r2[r1] = r3
            r1 = 3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r24)
            r2[r1] = r3
            r1 = 4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r23)
            r2[r1] = r3
            r1 = 5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r19)
            r2[r1] = r3
            r1 = 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            r2[r1] = r3
            r3 = r30
            r4 = r31
            r1 = r32
            r1.m8380b(r3, r4, r0, r2)
            goto L_0x020e
        L_0x020c:
            r1 = r32
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8376b(com.meizu.media.camera.a.f):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x01c4  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8368a(java.util.UUID r31, byte[] r32, int r33, int r34, int r35, long r36, int r38, java.lang.String r39, boolean r40, boolean r41, boolean r42, android.location.Location r43, boolean r44, com.meizu.media.camera.util.Contants.CameraService.RequestCode r45, com.meizu.media.camera.p064a.XmpMetaData r46) {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r13 = r35
            r7 = r36
            r9 = r38
            r12 = r41
            r11 = r42
            r6 = r44
            r5 = r45
            r0 = 15
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r16 = 0
            r1[r16] = r14
            r4 = 1
            r1[r4] = r32
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r33
            r2.<init>(r3)
            r17 = 2
            r1[r17] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r34
            r2.<init>(r3)
            r18 = 3
            r1[r18] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r13)
            r19 = 4
            r1[r19] = r2
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r7)
            r20 = 5
            r1[r20] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r9)
            r21 = 6
            r1[r21] = r2
            r2 = 7
            r1[r2] = r39
            java.lang.Byte r2 = new java.lang.Byte
            r3 = r40
            r2.<init>(r3)
            r23 = 8
            r1[r23] = r2
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r12)
            r24 = 9
            r1[r24] = r2
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r11)
            r25 = 10
            r1[r25] = r2
            r2 = 11
            r1[r2] = r43
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r6)
            r27 = 12
            r1[r27] = r2
            r2 = 13
            r1[r2] = r5
            r28 = 14
            r1[r28] = r46
            com.meizu.savior.ChangeQuickRedirect r28 = f7961t
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.util.UUID> r29 = java.util.UUID.class
            r0[r16] = r29
            java.lang.Class<byte[]> r29 = byte[].class
            r0[r4] = r29
            java.lang.Class r29 = java.lang.Integer.TYPE
            r0[r17] = r29
            java.lang.Class r29 = java.lang.Integer.TYPE
            r0[r18] = r29
            java.lang.Class r29 = java.lang.Integer.TYPE
            r0[r19] = r29
            java.lang.Class r29 = java.lang.Long.TYPE
            r0[r20] = r29
            java.lang.Class r29 = java.lang.Integer.TYPE
            r0[r21] = r29
            java.lang.Class<java.lang.String> r29 = java.lang.String.class
            r22 = 7
            r0[r22] = r29
            java.lang.Class r29 = java.lang.Boolean.TYPE
            r0[r23] = r29
            java.lang.Class r23 = java.lang.Boolean.TYPE
            r0[r24] = r23
            java.lang.Class r23 = java.lang.Boolean.TYPE
            r0[r25] = r23
            java.lang.Class<android.location.Location> r23 = android.location.Location.class
            r24 = 11
            r0[r24] = r23
            java.lang.Class r23 = java.lang.Boolean.TYPE
            r0[r27] = r23
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r23 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r0[r2] = r23
            java.lang.Class<com.meizu.media.camera.a.g> r2 = com.meizu.media.camera.p064a.XmpMetaData.class
            r23 = 14
            r0[r23] = r2
            java.lang.Class r23 = java.lang.Void.TYPE
            r24 = 0
            r25 = 803(0x323, float:1.125E-42)
            r26 = r0
            r0 = r1
            r1 = r30
            r2 = r28
            r3 = r24
            r4 = r25
            r5 = r26
            r22 = r6
            r6 = r23
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x00e9
            return
        L_0x00e9:
            com.meizu.media.camera.d.c r5 = com.meizu.media.camera.Exif.m10044a((byte[]) r32)
            int r23 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r5)
            int r0 = r13 + r23
            int r0 = r0 % 180
            if (r0 != 0) goto L_0x00fc
            r24 = r33
            r25 = r34
            goto L_0x0100
        L_0x00fc:
            r25 = r33
            r24 = r34
        L_0x0100:
            if (r39 != 0) goto L_0x010f
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Unbalanced name/data pair"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r26 = r5
            r27 = r12
            goto L_0x01bd
        L_0x010f:
            r0 = -1
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r9 < 0) goto L_0x0131
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9371bc
            java.lang.String r1 = "M"
            com.meizu.media.camera.d.h r0 = r5.mo19845a((int) r0, (java.lang.Object) r1)
            int r1 = com.meizu.media.camera.p067d.ExifInterface.f9372bd
            com.meizu.media.camera.d.l r2 = new com.meizu.media.camera.d.l
            long r3 = (long) r9
            r6 = 1
            r2.<init>(r3, r6)
            com.meizu.media.camera.d.h r1 = r5.mo19845a((int) r1, (java.lang.Object) r2)
            r5.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
            r5.mo19846a((com.meizu.media.camera.p067d.ExifTag) r1)
        L_0x0131:
            if (r11 == 0) goto L_0x0146
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9346ae
            java.lang.String r1 = "FACEBEAUTY"
            com.meizu.media.camera.d.h r0 = r5.mo19845a((int) r0, (java.lang.Object) r1)
            r5.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "isFBOn test"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x0151
        L_0x0146:
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9346ae
            java.lang.String r1 = "NORMAL"
            com.meizu.media.camera.d.h r0 = r5.mo19845a((int) r0, (java.lang.Object) r1)
            r5.mo19846a((com.meizu.media.camera.p067d.ExifTag) r0)
        L_0x0151:
            if (r11 == 0) goto L_0x0178
            r0 = r30
            r1 = r31
            r2 = r45
            r3 = r32
            r4 = r39
            r26 = r5
            r5 = r36
            r7 = r43
            r8 = r24
            r9 = r25
            r10 = r23
            r11 = r26
            r27 = r12
            r12 = r40
            r13 = r35
            r14 = r46
            r0.m8382b((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (byte[]) r3, (java.lang.String) r4, (long) r5, (android.location.Location) r7, (int) r8, (int) r9, (int) r10, (com.meizu.media.camera.p067d.ExifInterface) r11, (boolean) r12, (int) r13, (com.meizu.media.camera.p064a.XmpMetaData) r14)
            r0 = 1
            goto L_0x01be
        L_0x0178:
            r26 = r5
            r27 = r12
            if (r27 == 0) goto L_0x019e
            r0 = r30
            r1 = r31
            r2 = r45
            r3 = r32
            r4 = r39
            r5 = r36
            r7 = r43
            r8 = r24
            r9 = r25
            r10 = r23
            r11 = r26
            r12 = r40
            r13 = r35
            r14 = r46
            r0.m8365a((java.util.UUID) r1, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r2, (byte[]) r3, (java.lang.String) r4, (long) r5, (android.location.Location) r7, (int) r8, (int) r9, (int) r10, (com.meizu.media.camera.p067d.ExifInterface) r11, (boolean) r12, (int) r13, (com.meizu.media.camera.p064a.XmpMetaData) r14)
            goto L_0x01bd
        L_0x019e:
            r0 = r30
            r1 = r31
            r2 = r45
            r3 = r32
            r4 = r39
            r5 = r36
            r7 = r43
            r8 = r24
            r9 = r25
            r10 = r23
            r11 = r26
            r12 = r40
            r13 = r35
            r14 = r46
            r0.m8392c(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x01bd:
            r0 = 0
        L_0x01be:
            boolean r1 = com.meizu.media.camera.camcontroller.CameraController.m8857N()
            if (r1 == 0) goto L_0x01ce
            com.meizu.media.camera.camcontroller.CameraController.m8858O()
            int r1 = com.meizu.media.camera.camcontroller.CameraController.m8860Q()
            r15.m8348a((int) r1)
        L_0x01ce:
            r1 = 1
            r2 = r27 ^ 1
            if (r0 != 0) goto L_0x0212
            if (r2 == 0) goto L_0x0212
            if (r22 != 0) goto L_0x0212
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r3 != r4) goto L_0x01e4
            r3 = 0
            goto L_0x01e8
        L_0x01e4:
            android.graphics.Bitmap r3 = r26.mo19842a()
        L_0x01e8:
            r2[r16] = r3
            r2[r1] = r32
            java.lang.Integer r3 = java.lang.Integer.valueOf(r23)
            r2[r17] = r3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r40)
            r2[r18] = r3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r44)
            r2[r19] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            r2[r20] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r25)
            r2[r21] = r3
            r3 = r31
            r4 = r45
            r15.m8380b(r3, r4, r0, r2)
            goto L_0x0216
        L_0x0212:
            r3 = r31
            r4 = r45
        L_0x0216:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2[r16] = r1
            r15.m8380b(r3, r4, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8368a(java.util.UUID, byte[], int, int, int, long, int, java.lang.String, boolean, boolean, boolean, android.location.Location, boolean, com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.a.g):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8365a(java.util.UUID r28, com.meizu.media.camera.util.Contants.CameraService.RequestCode r29, byte[] r30, java.lang.String r31, long r32, android.location.Location r34, int r35, int r36, int r37, com.meizu.media.camera.p067d.ExifInterface r38, boolean r39, int r40, com.meizu.media.camera.p064a.XmpMetaData r41) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r14 = r31
            r15 = r38
            r13 = r39
            r11 = r40
            r0 = 13
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r12 = 0
            r1[r12] = r8
            r6 = 1
            r1[r6] = r9
            r16 = 2
            r1[r16] = r10
            r17 = 3
            r1[r17] = r14
            java.lang.Long r2 = new java.lang.Long
            r4 = r32
            r2.<init>(r4)
            r3 = 4
            r1[r3] = r2
            r2 = 5
            r1[r2] = r34
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r35
            r2.<init>(r4)
            r5 = 6
            r1[r5] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r36
            r2.<init>(r4)
            r19 = 7
            r1[r19] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r37
            r2.<init>(r4)
            r20 = 8
            r1[r20] = r2
            r2 = 9
            r1[r2] = r15
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r13)
            r21 = 10
            r1[r21] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r11)
            r22 = 11
            r1[r22] = r2
            r2 = 12
            r1[r2] = r41
            com.meizu.savior.ChangeQuickRedirect r25 = f7961t
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.util.UUID> r26 = java.util.UUID.class
            r0[r12] = r26
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r26 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r0[r6] = r26
            java.lang.Class<byte[]> r26 = byte[].class
            r0[r16] = r26
            java.lang.Class<java.lang.String> r26 = java.lang.String.class
            r0[r17] = r26
            java.lang.Class r26 = java.lang.Long.TYPE
            r0[r3] = r26
            java.lang.Class<android.location.Location> r26 = android.location.Location.class
            r24 = 5
            r0[r24] = r26
            java.lang.Class r24 = java.lang.Integer.TYPE
            r0[r5] = r24
            java.lang.Class r5 = java.lang.Integer.TYPE
            r0[r19] = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            r0[r20] = r5
            java.lang.Class<com.meizu.media.camera.d.c> r5 = com.meizu.media.camera.p067d.ExifInterface.class
            r19 = 9
            r0[r19] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r0[r21] = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            r0[r22] = r5
            java.lang.Class<com.meizu.media.camera.a.g> r5 = com.meizu.media.camera.p064a.XmpMetaData.class
            r0[r2] = r5
            java.lang.Class r19 = java.lang.Void.TYPE
            r5 = 0
            r20 = 804(0x324, float:1.127E-42)
            r21 = r0
            r0 = r1
            r1 = r27
            r2 = r25
            r3 = r5
            r4 = r20
            r5 = r21
            r12 = 1
            r6 = r19
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x00c2
            return
        L_0x00c2:
            long r0 = r7.f7965B
            int r2 = r10.length
            long r2 = (long) r2
            long r0 = r0 + r2
            r7.f7965B = r0
            boolean r0 = r27.mo19039u()
            if (r0 == 0) goto L_0x00ec
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r1 = new java.lang.Object[r12]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r3 = 0
            r1[r3] = r2
            r7.m8380b(r8, r9, r0, r1)
            long r0 = r7.f7965B
            int r2 = r10.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r7.f7965B = r0
            return
        L_0x00ec:
            r3 = 0
            int r0 = r10.length     // Catch:{ Exception -> 0x01bd }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r10, r3, r0)     // Catch:{ Exception -> 0x01bd }
            if (r0 != 0) goto L_0x0103
            com.meizu.media.camera.util.ac$a r0 = f7962u     // Catch:{ Exception -> 0x01bd }
            java.lang.String r1 = "ImageSaveTask[square] originbmp Null"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01bd }
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ERROR     // Catch:{ Exception -> 0x01bd }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01bd }
            r7.m8380b(r8, r9, r0, r1)     // Catch:{ Exception -> 0x01bd }
            return
        L_0x0103:
            int r21 = java.lang.Math.min(r35, r36)     // Catch:{ Exception -> 0x01bd }
            android.graphics.Bitmap r1 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r0, (boolean) r13, (int) r11)     // Catch:{ Exception -> 0x01bd }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x01bd }
            r2.<init>()     // Catch:{ Exception -> 0x01bd }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x01bd }
            r4 = 85
            r1.compress(r3, r4, r2)     // Catch:{ Exception -> 0x01bd }
            byte[] r19 = r2.toByteArray()     // Catch:{ Exception -> 0x01bd }
            r0.recycle()     // Catch:{ Exception -> 0x01bd }
            r1.recycle()     // Catch:{ Exception -> 0x01bd }
            r2.close()     // Catch:{ Exception -> 0x01bd }
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9368b     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x01bd }
            r15.mo19866b((int) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x01bd }
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9390c     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x01bd }
            r15.mo19866b((int) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x01bd }
            r38.mo19869c()     // Catch:{ Exception -> 0x01bd }
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_GET_THUMBNAIL     // Catch:{ Exception -> 0x01bd }
            r1 = 4
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01bd }
            r3 = 0
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01bd }
            r2[r12] = r1     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r37)     // Catch:{ Exception -> 0x01bd }
            r2[r16] = r1     // Catch:{ Exception -> 0x01bd }
            r2[r17] = r19     // Catch:{ Exception -> 0x01bd }
            r7.m8380b(r8, r9, r0, r2)     // Catch:{ Exception -> 0x01bd }
            android.content.Context r0 = r7.f7428o
            if (r0 != 0) goto L_0x015f
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "addSquareImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x015f:
            com.meizu.media.camera.Storage r11 = com.meizu.media.camera.Storage.m7750a()
            android.content.Context r0 = r7.f7428o
            android.content.ContentResolver r0 = r0.getContentResolver()
            r1 = 0
            r2 = 1
            r12 = r0
            r0 = r13
            r13 = r31
            r3 = r14
            r14 = r32
            r16 = r34
            r17 = r37
            r18 = r38
            r20 = r21
            r22 = r39
            r23 = r41
            android.net.Uri r4 = r11.mo18615a((android.content.ContentResolver) r12, (java.lang.String) r13, (long) r14, (android.location.Location) r16, (int) r17, (com.meizu.media.camera.p067d.ExifInterface) r18, (byte[]) r19, (int) r20, (int) r21, (boolean) r22, (com.meizu.media.camera.p064a.XmpMetaData) r23)
            if (r4 == 0) goto L_0x019e
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r5 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r4
            r7.m8380b(r8, r9, r5, r6)
            com.meizu.media.camera.Storage r4 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r0 = r4.mo18626a((boolean) r0, (java.lang.String) r3)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r3 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r1] = r0
            r7.m8380b(r8, r9, r3, r4)
        L_0x019e:
            boolean r0 = r27.mo19039u()
            long r3 = r7.f7965B
            int r5 = r10.length
            long r5 = (long) r5
            long r3 = r3 - r5
            r7.f7965B = r3
            boolean r3 = r27.mo19039u()
            if (r3 == r0) goto L_0x01bc
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            r2[r1] = r3
            r7.m8380b(r8, r9, r0, r2)
        L_0x01bc:
            return
        L_0x01bd:
            r1 = 0
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r2 = "ImageSaveTask[square] Exception"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ERROR
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r7.m8380b(r8, r9, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8365a(java.util.UUID, com.meizu.media.camera.util.Contants$CameraService$RequestCode, byte[], java.lang.String, long, android.location.Location, int, int, int, com.meizu.media.camera.d.c, boolean, int, com.meizu.media.camera.a.g):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8369a(java.util.UUID r31, byte[] r32, int r33, int r34, int r35, long r36, int r38, boolean r39, android.location.Location r40, boolean r41, com.meizu.media.camera.util.Contants.CameraService.RequestCode r42, com.meizu.media.camera.p064a.XmpMetaData r43) {
        /*
            r30 = this;
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r35
            r14 = r36
            r11 = r38
            r13 = r39
            r12 = r42
            r0 = 12
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r6 = 0
            r1[r6] = r8
            r5 = 1
            r1[r5] = r9
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r33
            r2.<init>(r4)
            r3 = 2
            r1[r3] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r4 = r34
            r2.<init>(r4)
            r26 = 3
            r1[r26] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r27 = 4
            r1[r27] = r2
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r14)
            r28 = 5
            r1[r28] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r11)
            r29 = 6
            r1[r29] = r2
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r13)
            r4 = 7
            r1[r4] = r2
            r2 = 8
            r1[r2] = r40
            java.lang.Byte r2 = new java.lang.Byte
            r4 = r41
            r2.<init>(r4)
            r18 = 9
            r1[r18] = r2
            r2 = 10
            r1[r2] = r12
            r19 = 11
            r1[r19] = r43
            com.meizu.savior.ChangeQuickRedirect r20 = f7961t
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.util.UUID> r21 = java.util.UUID.class
            r0[r6] = r21
            java.lang.Class<byte[]> r21 = byte[].class
            r0[r5] = r21
            java.lang.Class r21 = java.lang.Integer.TYPE
            r0[r3] = r21
            java.lang.Class r21 = java.lang.Integer.TYPE
            r0[r26] = r21
            java.lang.Class r21 = java.lang.Integer.TYPE
            r0[r27] = r21
            java.lang.Class r21 = java.lang.Long.TYPE
            r0[r28] = r21
            java.lang.Class r21 = java.lang.Integer.TYPE
            r0[r29] = r21
            java.lang.Class r21 = java.lang.Boolean.TYPE
            r22 = 7
            r0[r22] = r21
            java.lang.Class<android.location.Location> r21 = android.location.Location.class
            r23 = 8
            r0[r23] = r21
            java.lang.Class r21 = java.lang.Boolean.TYPE
            r0[r18] = r21
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r18 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r0[r2] = r18
            java.lang.Class<com.meizu.media.camera.a.g> r2 = com.meizu.media.camera.p064a.XmpMetaData.class
            r0[r19] = r2
            java.lang.Class r18 = java.lang.Void.TYPE
            r19 = 0
            r21 = 805(0x325, float:1.128E-42)
            r23 = r0
            r0 = r1
            r1 = r30
            r2 = r20
            r13 = 2
            r3 = r19
            r4 = r21
            r13 = 1
            r5 = r23
            r6 = r18
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x00c1
            return
        L_0x00c1:
            com.meizu.media.camera.d.c r0 = com.meizu.media.camera.Exif.m10044a((byte[]) r32)
            int r1 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r0)
            int r2 = r10 + r1
            int r2 = r2 % 180
            if (r2 != 0) goto L_0x00d4
            r2 = r33
            r3 = r34
            goto L_0x00d8
        L_0x00d4:
            r3 = r33
            r2 = r34
        L_0x00d8:
            java.lang.String r4 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r36)
            if (r4 != 0) goto L_0x00e6
            com.meizu.media.camera.util.ac$a r5 = f7962u
            java.lang.String r6 = "Unbalanced name/data pair"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r6)
            goto L_0x0116
        L_0x00e6:
            r5 = -1
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x010b
            int r5 = com.meizu.media.camera.p067d.ExifInterface.f9371bc
            java.lang.String r6 = "M"
            com.meizu.media.camera.d.h r5 = r0.mo19845a((int) r5, (java.lang.Object) r6)
            int r6 = com.meizu.media.camera.p067d.ExifInterface.f9372bd
            com.meizu.media.camera.d.l r13 = new com.meizu.media.camera.d.l
            long r10 = (long) r11
            r14 = 1
            r13.<init>(r10, r14)
            com.meizu.media.camera.d.h r6 = r0.mo19845a((int) r6, (java.lang.Object) r13)
            r0.mo19846a((com.meizu.media.camera.p067d.ExifTag) r5)
            r0.mo19846a((com.meizu.media.camera.p067d.ExifTag) r6)
            r0.mo19869c()
        L_0x010b:
            int r5 = com.meizu.media.camera.p067d.ExifInterface.f9346ae
            java.lang.String r6 = "FUNNY_SNAP|NORMAL"
            com.meizu.media.camera.d.h r5 = r0.mo19845a((int) r5, (java.lang.Object) r6)
            r0.mo19846a((com.meizu.media.camera.p067d.ExifTag) r5)
        L_0x0116:
            long r5 = r7.f7965B
            int r10 = r9.length
            long r10 = (long) r10
            long r5 = r5 + r10
            r7.f7965B = r5
            boolean r5 = r30.mo19039u()
            if (r5 == 0) goto L_0x0141
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5 = 0
            r2[r5] = r1
            r7.m8380b(r8, r12, r0, r2)
            long r0 = r7.f7965B
            int r2 = r9.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r7.f7965B = r0
            return
        L_0x0141:
            r5 = 0
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options
            r6.<init>()
            r6.inJustDecodeBounds = r5
            r10 = 1
            r6.inSampleSize = r10
            int r10 = r9.length
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeByteArray(r9, r5, r10, r6)
            android.content.Context r10 = r7.f7428o
            if (r10 != 0) goto L_0x015d
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "addImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x015d:
            com.meizu.media.mzfunnysnapsdk.MZUtil.HDRenderController r10 = r7.f7971x
            android.graphics.Bitmap r6 = r10.executeMakeUp(r6)
            com.meizu.media.camera.Storage r11 = com.meizu.media.camera.Storage.m7750a()
            android.content.Context r10 = r7.f7428o
            android.content.ContentResolver r10 = r10.getContentResolver()
            r23 = 0
            r24 = 0
            r13 = 2
            java.lang.Object[] r14 = new java.lang.Object[r13]
            com.meizu.media.camera.mode.CameraModeType$ModeType r15 = com.meizu.media.camera.mode.CameraModeType.ModeType.FUNNY_SNAP
            r14[r5] = r15
            r15 = 1
            r14[r15] = r43
            r12 = r10
            r10 = r39
            r13 = r4
            r25 = r14
            r14 = r36
            r16 = r40
            r17 = r1
            r18 = r0
            r19 = r6
            r20 = r2
            r21 = r3
            r22 = r39
            android.net.Uri r11 = r11.mo18613a((android.content.ContentResolver) r12, (java.lang.String) r13, (long) r14, (android.location.Location) r16, (int) r17, (com.meizu.media.camera.p067d.ExifInterface) r18, (android.graphics.Bitmap) r19, (int) r20, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Object[]) r25)
            if (r11 == 0) goto L_0x01f4
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r12 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r13 = 7
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r13[r5] = r6
            r6 = 1
            r13[r6] = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r14 = 2
            r13[r14] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r39)
            r13[r26] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r41)
            r13[r27] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r13[r28] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r13[r29] = r1
            r1 = r42
            r7.m8380b(r8, r1, r12, r13)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r5] = r11
            r7.m8380b(r8, r1, r2, r3)
            com.meizu.media.camera.Storage r2 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r2 = r2.mo18626a((boolean) r10, (java.lang.String) r4)
            r3 = r36
            r7.m8360a((com.meizu.media.camera.p067d.ExifInterface) r0, (long) r3)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r5] = r2
            r7.m8380b(r8, r1, r0, r3)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL
            java.lang.Object[] r2 = new java.lang.Object[r14]
            r2[r5] = r11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r35)
            r2[r6] = r3
            r7.m8380b(r8, r1, r0, r2)
            goto L_0x01f7
        L_0x01f4:
            r1 = r42
            r6 = 1
        L_0x01f7:
            boolean r0 = r30.mo19039u()
            long r2 = r7.f7965B
            int r4 = r9.length
            long r9 = (long) r4
            long r2 = r2 - r9
            r7.f7965B = r2
            boolean r2 = r30.mo19039u()
            if (r2 == r0) goto L_0x0215
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            r2[r5] = r3
            r7.m8380b(r8, r1, r0, r2)
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8369a(java.util.UUID, byte[], int, int, int, long, int, boolean, android.location.Location, boolean, com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.a.g):void");
    }

    /* renamed from: b */
    private void m8382b(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, int i4, XmpMetaData gVar) {
        int i5;
        int i6;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        byte[] bArr2 = bArr;
        String str2 = str;
        int i7 = i;
        int i8 = i2;
        boolean z2 = z;
        if (!PatchProxy.proxy(new Object[]{uuid2, requestCode2, bArr2, str2, new Long(j), location, new Integer(i7), new Integer(i8), new Integer(i3), cVar, new Byte(z2 ? (byte) 1 : 0), new Integer(i4), gVar}, this, f7961t, false, 806, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Integer.TYPE, XmpMetaData.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "addFaceBeautyImage");
            this.f7965B += (long) bArr2.length;
            if (mo19039u()) {
                LogUtil.m15956e(f7962u, "Cannot add image when the queue is full");
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, true);
                this.f7965B -= (long) bArr2.length;
                return;
            }
            if (i7 == 0 || i8 == 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                int i9 = options.outWidth;
                i6 = options.outHeight;
                i5 = i9;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if (this.f7428o == null) {
                LogUtil.m15949b(f7962u, "addFaceBeautyImage:isDestroyed is true,return");
                return;
            }
            String str3 = str2;
            boolean z3 = z2;
            byte[] bArr3 = bArr2;
            Uri a = FBStorage.m10036a().mo20007a(this.f7428o.getContentResolver(), str, j, location, i3, cVar, bArr, i5, i6, z, gVar);
            if (a != null) {
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED, a);
                String a2 = Storage.m7750a().mo18626a(z3, str3);
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_GET_THUMBNAIL, a2, 4, Integer.valueOf(i3), null);
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED, a2);
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL, a, Integer.valueOf(i4));
            }
            boolean u = mo19039u();
            this.f7965B -= (long) bArr3.length;
            if (mo19039u() != u) {
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, false);
            }
        }
    }

    /* renamed from: c */
    private void m8392c(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, int i4, XmpMetaData gVar) {
        int i5;
        int i6;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        byte[] bArr2 = bArr;
        long j2 = j;
        int i7 = i;
        int i8 = i2;
        if (!PatchProxy.proxy(new Object[]{uuid2, requestCode2, bArr2, str, new Long(j2), location, new Integer(i7), new Integer(i8), new Integer(i3), cVar, new Byte(z ? (byte) 1 : 0), new Integer(i4), gVar}, this, f7961t, false, 807, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Integer.TYPE, XmpMetaData.class}, Void.TYPE).isSupported) {
            this.f7965B += (long) bArr2.length;
            if (mo19039u()) {
                LogUtil.m15956e(f7962u, "Cannot add image when the queue is full");
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, true);
                this.f7965B -= (long) bArr2.length;
                return;
            }
            if (i7 == 0 || i8 == 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                int i9 = options.outWidth;
                i5 = options.outHeight;
                i6 = i9;
            } else {
                i6 = i7;
                i5 = i8;
            }
            if (this.f7428o == null) {
                LogUtil.m15949b(f7962u, "addImage:isDestroyed is true,return");
                return;
            }
            long j3 = j2;
            String str2 = str;
            byte[] bArr3 = bArr2;
            Uri a = Storage.m7750a().mo18615a(this.f7428o.getContentResolver(), str, j, location, i3, cVar, bArr, i6, i5, z, gVar);
            if (a != null) {
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED, a);
                String a2 = Storage.m7750a().mo18626a(z, str2);
                m8360a(cVar, j3);
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED, a2);
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL, a, Integer.valueOf(i4));
            }
            boolean u = mo19039u();
            this.f7965B -= (long) bArr3.length;
            if (mo19039u() != u) {
                m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, false);
            }
        }
    }

    /* renamed from: d */
    private Bitmap m8396d(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, int i4, XmpMetaData gVar) {
        Point[] pointArr;
        Bitmap bitmap;
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        byte[] bArr2 = bArr;
        String str2 = str;
        ExifInterface cVar2 = cVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid2, requestCode2, bArr2, str2, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar2, new Byte(z ? (byte) 1 : 0), new Integer(i4), gVar}, this, f7961t, false, 808, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Integer.TYPE, XmpMetaData.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        this.f7965B += (long) bArr2.length;
        if (mo19039u()) {
            LogUtil.m15956e(f7962u, "Cannot add image when the queue is full");
            m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, true);
            this.f7965B -= (long) bArr2.length;
            return null;
        }
        if (cVar2 != null) {
            cVar.mo19869c();
        }
        String g = Storage.m7750a().mo18656g(str2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
        CamIntentTask.C1777c a = mo18690a(uuid);
        if (a != null) {
            LogUtil.m15942a(f7962u, "scan document bitmap start");
            Point[] a2 = a.mo18021a(decodeByteArray);
            bitmap = a.mo17987a(decodeByteArray, a2);
            pointArr = a2;
        } else {
            bitmap = null;
            pointArr = null;
        }
        LogUtil.m15942a(f7962u, "scan document bitmap finish");
        ExifInterface cVar3 = cVar2;
        byte[] bArr3 = bArr2;
        Uri a3 = Storage.m7750a().mo18617a(this.f7428o.getContentResolver(), str, j, location, i3, cVar, bArr, bitmap, pointArr, g, i, i2, gVar);
        if (this.f7428o == null) {
            LogUtil.m15949b(f7962u, "addImage:isDestroyed is true,return");
            return null;
        }
        if (a3 != null) {
            m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED, a3);
            m8360a(cVar3, j);
            m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED, g);
            m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL, a3, Integer.valueOf(i4));
        }
        boolean u = mo19039u();
        this.f7965B -= (long) bArr3.length;
        if (mo19039u() != u) {
            m8380b(uuid2, requestCode2, Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED, false);
        }
        return bitmap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0277, code lost:
        r7 = r12;
        r12 = r36;
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8364a(java.util.UUID r32, com.meizu.media.camera.util.Contants.CameraService.RequestCode r33, byte[] r34, java.lang.String r35, long r36, android.location.Location r38, int r39, int r40, int r41, com.meizu.media.camera.p067d.ExifInterface r42, com.meizu.media.camera.p064a.XmpMetaData r43, boolean r44, boolean r45, int r46, boolean r47, boolean r48, boolean r49) {
        /*
            r31 = this;
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r14 = r35
            r12 = r36
            r0 = r39
            r15 = r40
            r7 = r42
            r6 = r44
            r5 = r46
            r4 = r47
            r1 = 17
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r9
            r3 = 1
            r2[r3] = r10
            r28 = 2
            r2[r28] = r11
            r29 = 3
            r2[r29] = r14
            java.lang.Long r3 = new java.lang.Long
            r3.<init>(r12)
            r30 = 4
            r2[r30] = r3
            r3 = 5
            r2[r3] = r38
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r0)
            r16 = 6
            r2[r16] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r15)
            r18 = 7
            r2[r18] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r1 = r41
            r3.<init>(r1)
            r19 = 8
            r2[r19] = r3
            r3 = 9
            r2[r3] = r7
            r3 = 10
            r2[r3] = r43
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r6)
            r21 = 11
            r2[r21] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r13 = r45
            r3.<init>(r13)
            r12 = 12
            r2[r12] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r5)
            r22 = 13
            r2[r22] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r4)
            r22 = 14
            r2[r22] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r5 = r48
            r3.<init>(r5)
            r22 = 15
            r2[r22] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r5 = r49
            r3.<init>(r5)
            r22 = 16
            r2[r22] = r3
            com.meizu.savior.ChangeQuickRedirect r3 = f7961t
            r12 = 17
            java.lang.Class[] r12 = new java.lang.Class[r12]
            java.lang.Class<java.util.UUID> r22 = java.util.UUID.class
            r23 = 0
            r12[r23] = r22
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r22 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r24 = 1
            r12[r24] = r22
            java.lang.Class<byte[]> r22 = byte[].class
            r12[r28] = r22
            java.lang.Class<java.lang.String> r22 = java.lang.String.class
            r12[r29] = r22
            java.lang.Class r22 = java.lang.Long.TYPE
            r12[r30] = r22
            java.lang.Class<android.location.Location> r22 = android.location.Location.class
            r25 = 5
            r12[r25] = r22
            java.lang.Class r22 = java.lang.Integer.TYPE
            r12[r16] = r22
            java.lang.Class r16 = java.lang.Integer.TYPE
            r12[r18] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r12[r19] = r16
            java.lang.Class<com.meizu.media.camera.d.c> r16 = com.meizu.media.camera.p067d.ExifInterface.class
            r18 = 9
            r12[r18] = r16
            java.lang.Class<com.meizu.media.camera.a.g> r16 = com.meizu.media.camera.p064a.XmpMetaData.class
            r18 = 10
            r12[r18] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r12[r21] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 12
            r12[r19] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r19 = 13
            r12[r19] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 14
            r12[r19] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 15
            r12[r19] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 16
            r12[r19] = r16
            java.lang.Class r16 = java.lang.Void.TYPE
            r19 = 0
            r21 = 809(0x329, float:1.134E-42)
            r1 = r2
            r2 = r31
            r18 = r4
            r4 = r19
            r5 = r21
            r6 = r12
            r12 = r7
            r7 = r16
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0111
            return
        L_0x0111:
            com.meizu.media.camera.util.ac$a r1 = f7962u
            java.lang.String r2 = "updateImage"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            long r1 = r8.f7965B
            int r3 = r11.length
            long r3 = (long) r3
            long r1 = r1 + r3
            r8.f7965B = r1
            boolean r1 = r31.mo19039u()
            if (r1 == 0) goto L_0x0143
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3 = 0
            r2[r3] = r1
            r8.m8380b(r9, r10, r0, r2)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x0143:
            r1 = 1
            r3 = 0
            if (r0 == 0) goto L_0x014c
            if (r15 != 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r2 = r0
            goto L_0x015c
        L_0x014c:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inJustDecodeBounds = r1
            int r2 = r11.length
            android.graphics.BitmapFactory.decodeByteArray(r11, r3, r2, r0)
            int r2 = r0.outWidth
            int r0 = r0.outHeight
            r15 = r0
        L_0x015c:
            android.content.Context r0 = r8.f7428o
            if (r0 != 0) goto L_0x0168
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x0168:
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            r4 = r44
            java.lang.String r5 = r0.mo18626a((boolean) r4, (java.lang.String) r14)
            r6 = 0
        L_0x0173:
            r7 = 10
            if (r6 >= r7) goto L_0x0277
            boolean r16 = m8371a((java.lang.String) r5)
            if (r16 == 0) goto L_0x0260
            android.content.Context r0 = r8.f7428o
            if (r0 != 0) goto L_0x0193
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            m8379b((java.lang.String) r5)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x0193:
            if (r18 == 0) goto L_0x0206
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "get square bitmap start"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            int r0 = r11.length     // Catch:{ Exception -> 0x01f6 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r11, r3, r0)     // Catch:{ Exception -> 0x01f6 }
            if (r0 != 0) goto L_0x01b2
            com.meizu.media.camera.util.ac$a r0 = f7962u     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r1 = "ImageSaveTask[square] originbmp Null"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01f6 }
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ERROR     // Catch:{ Exception -> 0x01f6 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01f6 }
            r8.m8380b(r9, r10, r0, r1)     // Catch:{ Exception -> 0x01f6 }
            return
        L_0x01b2:
            int r1 = java.lang.Math.min(r2, r15)     // Catch:{ Exception -> 0x01f6 }
            r2 = r46
            android.graphics.Bitmap r2 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r0, (boolean) r4, (int) r2)     // Catch:{ Exception -> 0x01f6 }
            java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x01f6 }
            r15.<init>()     // Catch:{ Exception -> 0x01f6 }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x01f6 }
            r3 = 85
            r2.compress(r7, r3, r15)     // Catch:{ Exception -> 0x01f6 }
            byte[] r3 = r15.toByteArray()     // Catch:{ Exception -> 0x01f6 }
            r0.recycle()     // Catch:{ Exception -> 0x01f6 }
            r2.recycle()     // Catch:{ Exception -> 0x01f6 }
            r15.close()     // Catch:{ Exception -> 0x01f6 }
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9368b     // Catch:{ Exception -> 0x01f6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01f6 }
            r12.mo19866b((int) r0, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01f6 }
            int r0 = com.meizu.media.camera.p067d.ExifInterface.f9390c     // Catch:{ Exception -> 0x01f6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01f6 }
            r12.mo19866b((int) r0, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01f6 }
            r42.mo19869c()     // Catch:{ Exception -> 0x01f6 }
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r2 = "get square bitmap end"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
            r22 = r1
            r23 = r22
            goto L_0x020b
        L_0x01f6:
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "ImageSaveTask[square] Exception"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ERROR
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r8.m8380b(r9, r10, r0, r1)
            return
        L_0x0206:
            r22 = r2
            r23 = r15
            r3 = 0
        L_0x020b:
            android.content.Context r0 = r8.f7428o
            if (r0 == 0) goto L_0x0277
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            android.content.Context r1 = r8.f7428o
            android.content.ContentResolver r1 = r1.getContentResolver()
            if (r18 == 0) goto L_0x0221
            r21 = r3
        L_0x021d:
            r7 = r12
            r2 = r36
            goto L_0x0224
        L_0x0221:
            r21 = r11
            goto L_0x021d
        L_0x0224:
            r12 = r0
            r13 = r1
            r14 = r35
            r15 = r36
            r17 = r38
            r18 = r41
            r19 = r42
            r20 = r43
            r24 = r44
            r25 = r45
            r26 = r48
            r27 = r49
            android.net.Uri r0 = r12.mo18614a(r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            com.meizu.media.camera.util.ac$a r1 = f7962u
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "updateImage uri:"
            r12.append(r13)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r12)
            com.meizu.media.camera.Storage r1 = com.meizu.media.camera.Storage.m7750a()
            r1.mo18674p(r5)
            m8379b((java.lang.String) r5)
            r12 = r2
            goto L_0x027b
        L_0x0260:
            r7 = r12
            r12 = r36
            r0 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0269 }
            goto L_0x026e
        L_0x0269:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x026e:
            int r6 = r6 + 1
            r13 = r45
            r12 = r7
            r1 = 1
            r3 = 0
            goto L_0x0173
        L_0x0277:
            r7 = r12
            r12 = r36
            r0 = 0
        L_0x027b:
            android.content.Context r1 = r8.f7428o
            com.meizu.media.camera.util.CameraUtil.m15845a((android.content.Context) r1, (java.lang.String) r5)
            boolean r1 = com.meizu.media.camera.camcontroller.CameraController.m8857N()
            if (r1 == 0) goto L_0x0290
            com.meizu.media.camera.camcontroller.CameraController.m8858O()
            int r1 = com.meizu.media.camera.camcontroller.CameraController.m8860Q()
            r8.m8348a((int) r1)
        L_0x0290:
            r1 = 10
            if (r6 < r1) goto L_0x02b2
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateImage timeout : "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x02b2:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r3 != r6) goto L_0x02c0
            r3 = 0
        L_0x02be:
            r6 = 0
            goto L_0x02c5
        L_0x02c0:
            android.graphics.Bitmap r3 = r42.mo19842a()
            goto L_0x02be
        L_0x02c5:
            r2[r6] = r3
            r3 = 1
            r2[r3] = r11
            java.lang.Integer r14 = java.lang.Integer.valueOf(r41)
            r2[r28] = r14
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r44)
            r2[r29] = r4
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r2[r30] = r4
            r8.m8380b(r9, r10, r1, r2)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r8.m8380b(r9, r10, r1, r2)
            if (r0 == 0) goto L_0x02fd
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r6] = r0
            r8.m8380b(r9, r10, r1, r2)
            r8.m8360a((com.meizu.media.camera.p067d.ExifInterface) r7, (long) r12)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r6] = r5
            r8.m8380b(r9, r10, r0, r1)
        L_0x02fd:
            boolean r0 = r31.mo19039u()
            long r1 = r8.f7965B
            int r3 = r11.length
            long r3 = (long) r3
            long r1 = r1 - r3
            r8.f7965B = r1
            boolean r1 = r31.mo19039u()
            if (r1 == r0) goto L_0x031d
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r1[r2] = r3
            r8.m8380b(r9, r10, r0, r1)
        L_0x031d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8364a(java.util.UUID, com.meizu.media.camera.util.Contants$CameraService$RequestCode, byte[], java.lang.String, long, android.location.Location, int, int, int, com.meizu.media.camera.d.c, com.meizu.media.camera.a.g, boolean, boolean, int, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8383b(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i4), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), new Byte(z5 ? (byte) 1 : 0)}, this, f7961t, false, 810, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "updateFaceBeautyImage");
            FBProcessTask.m10031b(FBProcessTask.m10028a(uuid, requestCode, bArr, str, j, location, i, i2, i3, cVar, z, z2, i4, z3, false, z5));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8389c(ParamData fVar) {
        if (!PatchProxy.proxy(new Object[]{fVar}, this, f7961t, false, 812, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "doEffect");
            this.f7970w.mo19463a(fVar);
        }
    }

    /* renamed from: u */
    public boolean mo19039u() {
        return this.f7965B >= 41943040;
    }

    /* renamed from: a */
    public static void m8349a(final Context context, final Intent intent) {
        Class[] clsArr = {Context.class, Intent.class};
        if (!PatchProxy.proxy(new Object[]{context, intent}, (Object) null, f7961t, true, 813, clsArr, Void.TYPE).isSupported) {
            f7406b.execute(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f7974a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f7974a, false, 857, new Class[0], Void.TYPE).isSupported) {
                        CameraOptTask.m8387c(context, intent);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m8387c(Context context, Intent intent) {
        Class[] clsArr = {Context.class, Intent.class};
        if (!PatchProxy.proxy(new Object[]{context, intent}, (Object) null, f7961t, true, 814, clsArr, Void.TYPE).isSupported) {
            synchronized (f7415s) {
                if (f7413n == null) {
                    f7413n = new CameraOptTask(context.getApplicationContext());
                }
                f7413n.mo18692a(intent);
            }
        }
    }

    /* renamed from: v */
    public static void m8418v() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f7961t, true, 815, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f7962u, "releaseOptTask");
            f7413n.mo18695b();
        }
    }

    /* renamed from: w */
    public static boolean m8419w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7961t, true, 816, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8852I();
    }

    /* renamed from: i */
    public boolean mo18702i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7961t, false, 817, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f7970w.mo19444H();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8380b(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, resultCode, objArr}, this, f7961t, false, 818, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, Contants.CameraService.ResultCode.class, Object[].class}, Void.TYPE).isSupported) {
            final UUID uuid2 = uuid;
            final Contants.CameraService.RequestCode requestCode2 = requestCode;
            final Contants.CameraService.ResultCode resultCode2 = resultCode;
            final Object[] objArr2 = objArr;
            this.f7969v.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f7977a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f7977a, false, 858, new Class[0], Void.TYPE).isSupported) {
                        CameraOptTask.this.mo18693a(uuid2, requestCode2, resultCode2, objArr2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8391c(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr) {
        Class[] clsArr = {UUID.class, Contants.CameraService.RequestCode.class, Contants.CameraService.ResultCode.class, Object[].class};
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, resultCode, objArr}, this, f7961t, false, 819, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7962u;
            LogUtil.m15942a(aVar, "deliverCallbackAsyn:" + resultCode);
            final Contants.CameraService.ResultCode resultCode2 = resultCode;
            final UUID uuid2 = uuid;
            final Contants.CameraService.RequestCode requestCode2 = requestCode;
            final Object[] objArr2 = objArr;
            C18384 r2 = new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f7983a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f7983a, false, 859, new Class[0], Void.TYPE).isSupported) {
                        LogUtil.C2630a z = CameraOptTask.f7962u;
                        LogUtil.m15942a(z, "deliverCallback form deliverCallbackAsyn:" + resultCode2);
                        CameraOptTask.this.mo18693a(uuid2, requestCode2, resultCode2, objArr2);
                        if (CameraOptTask.this.f7425f != null) {
                            CameraOptTask.this.f7425f.remove(this);
                        }
                    }
                }
            };
            this.f7425f.add(r2);
            this.f7424e.post(r2);
            if (requestCode == Contants.CameraService.RequestCode.REQUEST_CODE_CLOSE_CAMERA && resultCode == Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSED) {
                Message obtainMessage = this.f7424e.obtainMessage();
                obtainMessage.what = 1;
                this.f7424e.sendMessage(obtainMessage);
                this.f7430q = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8348a(final int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 820, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                synchronized (f7412m) {
                    Iterator it = f7412m.iterator();
                    while (it.hasNext()) {
                        ((CamIntentTask.C1775a) it.next()).mo18339a(i);
                    }
                }
                return;
            }
            this.f7969v.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f7989a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f7989a, false, 860, new Class[0], Void.TYPE).isSupported) {
                        synchronized (CamIntentTask.f7412m) {
                            LogUtil.C2630a z = CameraOptTask.f7962u;
                            LogUtil.m15952c(z, "deliverCaptureCallbackAsync:" + CamIntentTask.f7412m.size());
                            Iterator<CamIntentTask.C1775a> it = CamIntentTask.f7412m.iterator();
                            while (it.hasNext()) {
                                it.next().mo18339a(i);
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static boolean m8394c(boolean z) {
        return z ? f7964z : f7963y;
    }

    /* renamed from: a */
    public static void m8370a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7961t;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 821, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                f7964z = z2;
            } else {
                f7963y = z2;
            }
            if (z2) {
                synchronized (f7414r) {
                    f7414r.notify();
                    LogUtil.m15942a(f7962u, "setPreparedForStartPreview notify");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m8371a(java.lang.String r10) {
        /*
            java.lang.Class<com.meizu.media.camera.b> r0 = com.meizu.media.camera.CameraOptTask.class
            monitor-enter(r0)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0057 }
            r9 = 0
            r2[r9] = r10     // Catch:{ all -> 0x0057 }
            r3 = 0
            com.meizu.savior.ChangeQuickRedirect r4 = f7961t     // Catch:{ all -> 0x0057 }
            r5 = 1
            r6 = 822(0x336, float:1.152E-42)
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ all -> 0x0057 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r9] = r8     // Catch:{ all -> 0x0057 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0057 }
            com.meizu.savior.PatchProxyResult r2 = com.meizu.savior.PatchProxy.proxy(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0057 }
            boolean r3 = r2.isSupported     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r10 = r2.result     // Catch:{ all -> 0x0057 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0057 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return r10
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0057 }
            if (r2 != 0) goto L_0x0055
            java.util.ArrayList<java.lang.String> r2 = f7960E     // Catch:{ all -> 0x0057 }
            boolean r2 = r2.contains(r10)     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0038
            goto L_0x0055
        L_0x0038:
            com.meizu.media.camera.util.ac$a r2 = f7962u     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "addFastThumbnailList :"
            r3.append(r4)     // Catch:{ all -> 0x0057 }
            r3.append(r10)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0057 }
            com.meizu.media.camera.util.LogUtil.m15952c(r2, r3)     // Catch:{ all -> 0x0057 }
            java.util.ArrayList<java.lang.String> r2 = f7960E     // Catch:{ all -> 0x0057 }
            r2.add(r10)     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return r1
        L_0x0055:
            monitor-exit(r0)
            return r9
        L_0x0057:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8371a(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m8379b(java.lang.String r9) {
        /*
            java.lang.Class<com.meizu.media.camera.b> r0 = com.meizu.media.camera.CameraOptTask.class
            monitor-enter(r0)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x004e }
            r3 = 0
            r2[r3] = r9     // Catch:{ all -> 0x004e }
            r4 = 0
            com.meizu.savior.ChangeQuickRedirect r5 = f7961t     // Catch:{ all -> 0x004e }
            r6 = 1
            r7 = 823(0x337, float:1.153E-42)
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r1[r3] = r8     // Catch:{ all -> 0x004e }
            java.lang.Class r8 = java.lang.Void.TYPE     // Catch:{ all -> 0x004e }
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r1
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004e }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)
            return
        L_0x0026:
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x002e
            monitor-exit(r0)
            return
        L_0x002e:
            java.util.ArrayList<java.lang.String> r1 = f7960E     // Catch:{ all -> 0x004e }
            boolean r1 = r1.remove(r9)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004c
            com.meizu.media.camera.util.ac$a r1 = f7962u     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r2.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "removeFastThumbnailList :"
            r2.append(r3)     // Catch:{ all -> 0x004e }
            r2.append(r9)     // Catch:{ all -> 0x004e }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x004e }
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r9)     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r0)
            return
        L_0x004e:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8379b(java.lang.String):void");
    }

    /* renamed from: x */
    public static synchronized void m8420x() {
        synchronized (CameraOptTask.class) {
            if (!PatchProxy.proxy(new Object[0], (Object) null, f7961t, true, 824, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15952c(f7962u, "clearFastThumbnailList");
                f7960E.clear();
            }
        }
    }

    /* renamed from: a */
    private void m8360a(ExifInterface cVar, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!PatchProxy.proxy(new Object[]{cVar, new Long(j)}, this, f7961t, false, 825, new Class[]{ExifInterface.class, Long.TYPE}, Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f7428o.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z("save_info"));
            a.put("capture_time", Long.toString(j));
            Rational h = cVar.mo19880h(ExifInterface.f9297I);
            Rational h2 = cVar.mo19880h(ExifInterface.f9296H);
            Rational h3 = cVar.mo19880h(ExifInterface.f9343ab);
            Integer g = cVar.mo19879g(ExifInterface.f9300L);
            if (h == null) {
                str = "null";
            } else {
                str = String.format("%.2f", new Object[]{Double.valueOf(h.mo19956c())});
            }
            a.put("f_number", str);
            if (h2 == null) {
                str2 = "null";
            } else {
                str2 = String.format("%.2f", new Object[]{Double.valueOf(h2.mo19956c())});
            }
            a.put("exposure_time", str2);
            if (h3 == null) {
                str3 = "null";
            } else {
                str3 = String.format("%.2f", new Object[]{Double.valueOf(h3.mo19956c())});
            }
            a.put("focal_length", str3);
            if (g == null) {
                str4 = "null";
            } else {
                str4 = Integer.toString(g.intValue());
            }
            a.put("iso_speed", str4);
            UsageStatsHelper.m16042a(this.f7428o.getApplicationContext()).mo22693a("save_info", a);
        }
    }

    /* renamed from: a */
    public static void m8367a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), location, new Integer(i), new Integer(i2), new Integer(i3), cVar, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i4), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), new Byte(z5 ? (byte) 1 : 0)}, (Object) null, f7961t, true, 826, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "updateFaceBeautyImageDirectly");
            if (f7413n != null) {
                ((CameraOptTask) f7413n).m8393c(uuid, requestCode, bArr, str, j, location, i, i2, i3, cVar, z, z2, i4, z3, z4, z5);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r7v3, types: [boolean, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8393c(java.util.UUID r30, com.meizu.media.camera.util.Contants.CameraService.RequestCode r31, byte[] r32, java.lang.String r33, long r34, android.location.Location r36, int r37, int r38, int r39, com.meizu.media.camera.p067d.ExifInterface r40, boolean r41, boolean r42, int r43, boolean r44, boolean r45, boolean r46) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r14 = r33
            r12 = r34
            r0 = r37
            r15 = r38
            r7 = r40
            r6 = r41
            r5 = r44
            r1 = 16
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r4 = 0
            r2[r4] = r9
            r3 = 1
            r2[r3] = r10
            r3 = 2
            r2[r3] = r11
            r16 = 3
            r2[r16] = r14
            java.lang.Long r3 = new java.lang.Long
            r3.<init>(r12)
            r17 = 4
            r2[r17] = r3
            r3 = 5
            r2[r3] = r36
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r0)
            r19 = 6
            r2[r19] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r15)
            r20 = 7
            r2[r20] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r39
            r3.<init>(r4)
            r21 = 8
            r2[r21] = r3
            r3 = 9
            r2[r3] = r7
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r6)
            r4 = 10
            r2[r4] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r4 = r42
            r3.<init>(r4)
            r22 = 11
            r2[r22] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r43
            r3.<init>(r4)
            r23 = 12
            r2[r23] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r5)
            r24 = 13
            r2[r24] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r5 = r45
            r3.<init>(r5)
            r25 = 14
            r2[r25] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r5 = r46
            r3.<init>(r5)
            r25 = 15
            r2[r25] = r3
            com.meizu.savior.ChangeQuickRedirect r3 = f7961t
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<java.util.UUID> r25 = java.util.UUID.class
            r26 = 0
            r1[r26] = r25
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r25 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r27 = 1
            r1[r27] = r25
            java.lang.Class<byte[]> r25 = byte[].class
            r28 = 2
            r1[r28] = r25
            java.lang.Class<java.lang.String> r25 = java.lang.String.class
            r1[r16] = r25
            java.lang.Class r16 = java.lang.Long.TYPE
            r1[r17] = r16
            java.lang.Class<android.location.Location> r16 = android.location.Location.class
            r17 = 5
            r1[r17] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r1[r19] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r1[r20] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r1[r21] = r16
            java.lang.Class<com.meizu.media.camera.d.c> r16 = com.meizu.media.camera.p067d.ExifInterface.class
            r17 = 9
            r1[r17] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r17 = 10
            r1[r17] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r1[r22] = r16
            java.lang.Class r16 = java.lang.Integer.TYPE
            r1[r23] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r1[r24] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 14
            r1[r19] = r16
            java.lang.Class r16 = java.lang.Boolean.TYPE
            r19 = 15
            r1[r19] = r16
            java.lang.Class r16 = java.lang.Void.TYPE
            r19 = 0
            r20 = 827(0x33b, float:1.159E-42)
            r21 = r1
            r1 = r2
            r2 = r29
            r12 = 10
            r13 = 0
            r4 = r19
            r17 = r44
            r5 = r20
            r12 = r6
            r6 = r21
            r7 = r16
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0108
            return
        L_0x0108:
            com.meizu.media.camera.util.ac$a r1 = f7962u
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateFaceBeautyImagefromTask:title:"
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            long r1 = r8.f7965B
            int r3 = r11.length
            long r3 = (long) r3
            long r1 = r1 + r3
            r8.f7965B = r1
            boolean r1 = r29.mo19039u()
            if (r1 == 0) goto L_0x0148
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2[r13] = r1
            r8.m8380b(r9, r10, r0, r2)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x0148:
            r1 = 1
            if (r0 == 0) goto L_0x0153
            if (r15 != 0) goto L_0x014e
            goto L_0x0153
        L_0x014e:
            r21 = r0
            r22 = r15
            goto L_0x0166
        L_0x0153:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inJustDecodeBounds = r1
            int r2 = r11.length
            android.graphics.BitmapFactory.decodeByteArray(r11, r13, r2, r0)
            int r2 = r0.outWidth
            int r0 = r0.outHeight
            r22 = r0
            r21 = r2
        L_0x0166:
            android.content.Context r0 = r8.f7428o
            if (r0 != 0) goto L_0x0172
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x0172:
            r2 = 0
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r3 = r0.mo18626a((boolean) r12, (java.lang.String) r14)
            r4 = 0
            r5 = 10
        L_0x017e:
            if (r4 >= r5) goto L_0x01f3
            boolean r0 = m8371a((java.lang.String) r3)
            if (r0 == 0) goto L_0x01e1
            android.content.Context r0 = r8.f7428o
            if (r0 != 0) goto L_0x019c
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            m8379b((java.lang.String) r3)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x019c:
            r0 = 0
            com.meizu.media.camera.e.c r2 = com.meizu.media.camera.p068e.FBStorage.m10036a()
            android.content.Context r6 = r8.f7428o
            android.content.ContentResolver r6 = r6.getContentResolver()
            if (r17 == 0) goto L_0x01ac
            r20 = r0
            goto L_0x01ae
        L_0x01ac:
            r20 = r11
        L_0x01ae:
            r12 = r2
            r7 = 0
            r13 = r6
            r14 = r33
            r15 = r34
            r17 = r36
            r18 = r39
            r19 = r40
            r23 = r41
            r24 = r42
            r25 = r45
            r26 = r46
            android.net.Uri r2 = r12.mo20008a(r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = "updateImage uri:"
            r6.append(r12)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r6)
            m8379b((java.lang.String) r3)
            goto L_0x01f4
        L_0x01e1:
            r7 = 0
            r12 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x01e8 }
            goto L_0x01ed
        L_0x01e8:
            r0 = move-exception
            r6 = r0
            r6.printStackTrace()
        L_0x01ed:
            int r4 = r4 + 1
            r12 = r41
            r13 = 0
            goto L_0x017e
        L_0x01f3:
            r7 = 0
        L_0x01f4:
            android.content.Context r0 = r8.f7428o
            if (r0 == 0) goto L_0x0204
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r6 = "sendBroadcast"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r6)
            android.content.Context r0 = r8.f7428o
            com.meizu.media.camera.util.CameraUtil.m15845a((android.content.Context) r0, (java.lang.String) r3)
        L_0x0204:
            boolean r0 = com.meizu.media.camera.camcontroller.CameraController.m8857N()
            if (r0 == 0) goto L_0x0214
            com.meizu.media.camera.camcontroller.CameraController.m8858O()
            int r0 = com.meizu.media.camera.camcontroller.CameraController.m8860Q()
            r8.m8348a((int) r0)
        L_0x0214:
            if (r4 < r5) goto L_0x0234
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateImage timeout : "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            long r0 = r8.f7965B
            int r2 = r11.length
            long r2 = (long) r2
            long r0 = r0 - r2
            r8.f7965B = r0
            return
        L_0x0234:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r46)
            r4[r7] = r5
            r8.m8380b(r9, r10, r0, r4)
            if (r2 == 0) goto L_0x0291
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            long r4 = r0.mo18671o(r3)
            r12 = -1
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0253
            r0 = 1
            goto L_0x025b
        L_0x0253:
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r4 = " first update"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r4)
            r0 = 0
        L_0x025b:
            com.meizu.media.camera.Storage r4 = com.meizu.media.camera.Storage.m7750a()
            r4.mo18674p(r3)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r4 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r7] = r2
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6[r1] = r0
            r8.m8380b(r9, r10, r4, r6)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r7] = r3
            r8.m8380b(r9, r10, r0, r4)
            r3 = r34
            r6 = r40
            r8.m8360a((com.meizu.media.camera.p067d.ExifInterface) r6, (long) r3)
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r7] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r43)
            r3[r1] = r2
            r8.m8380b(r9, r10, r0, r3)
        L_0x0291:
            boolean r0 = r29.mo19039u()
            long r2 = r8.f7965B
            int r4 = r11.length
            long r4 = (long) r4
            long r2 = r2 - r4
            r8.f7965B = r2
            boolean r2 = r29.mo19039u()
            if (r2 == r0) goto L_0x02af
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            r1[r7] = r2
            r8.m8380b(r9, r10, r0, r1)
        L_0x02af:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r8.m8380b(r9, r10, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8393c(java.util.UUID, com.meizu.media.camera.util.Contants$CameraService$RequestCode, byte[], java.lang.String, long, android.location.Location, int, int, int, com.meizu.media.camera.d.c, boolean, boolean, int, boolean, boolean, boolean):void");
    }

    /* renamed from: a */
    public static void m8363a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, int i, Location location, int i2, int i3, boolean z, int i4, boolean z2, XmpMetaData gVar) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), new Integer(i), location, new Integer(i2), new Integer(i3), new Byte(z ? (byte) 1 : 0), new Integer(i4), new Byte(z2 ? (byte) 1 : 0), gVar}, (Object) null, f7961t, true, 828, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Integer.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, XmpMetaData.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "addEffectImageDirectly");
            if (f7413n != null) {
                ((CameraOptTask) f7413n).m8368a(uuid, bArr, i2, i3, i4, j, i, str, z, z2, false, location, false, requestCode, gVar);
            }
        }
    }

    /* renamed from: b */
    public static void m8381b(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, int i, Location location, int i2, int i3, boolean z, int i4, boolean z2, XmpMetaData gVar) {
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, bArr, str, new Long(j), new Integer(i), location, new Integer(i2), new Integer(i3), new Byte(z ? (byte) 1 : 0), new Integer(i4), new Byte(z2 ? (byte) 1 : 0), gVar}, (Object) null, f7961t, true, 829, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Integer.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, XmpMetaData.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "updateEffectImageDirectly");
            if (f7413n != null) {
                ExifInterface a = Exif.m10044a(bArr);
                int a2 = Exif.m10043a(a);
                ((CameraOptTask) f7413n).m8364a(uuid, requestCode, bArr, str, j, location, i2, i3, a2, a, gVar, z, false, i4, z2, false, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8398d(ParamData fVar) {
        if (!PatchProxy.proxy(new Object[]{fVar}, this, f7961t, false, 831, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7962u;
            LogUtil.m15942a(aVar, "updateBokehImage:" + fVar.f7466c);
            BokehProcessTask.m13565b(BokehProcessTask.m13562a(fVar));
        }
    }

    /* renamed from: a */
    public static void m8350a(ParamData fVar) {
        if (!PatchProxy.proxy(new Object[]{fVar}, (Object) null, f7961t, true, 832, new Class[]{ParamData.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7962u, "updateBokehImageDirectly");
            if (f7413n != null) {
                ((CameraOptTask) f7413n).m8401e(fVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8401e(com.meizu.media.camera.p064a.ParamData r46) {
        /*
            r45 = this;
            r11 = r45
            r12 = r46
            r13 = 1
            java.lang.Object[] r1 = new java.lang.Object[r13]
            r14 = 0
            r1[r14] = r12
            com.meizu.savior.ChangeQuickRedirect r3 = f7961t
            java.lang.Class[] r6 = new java.lang.Class[r13]
            java.lang.Class<com.meizu.media.camera.a.f> r0 = com.meizu.media.camera.p064a.ParamData.class
            r6[r14] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 833(0x341, float:1.167E-42)
            r2 = r45
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateBokehImagefromTask date is : "
            r1.append(r2)
            long r2 = r12.f7466c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateBokehImagefromTask:title:"
            r1.append(r2)
            java.lang.String r2 = r12.f7465b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateBokehImage:datalengh:"
            r1.append(r2)
            byte[] r2 = r12.f7469f
            int r2 = r2.length
            r1.append(r2)
            java.lang.String r2 = " mBokehorientation: "
            r1.append(r2)
            int r2 = r12.f7486w
            r1.append(r2)
            java.lang.String r2 = " mirror:"
            r1.append(r2)
            boolean r2 = r12.f7474k
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            int r0 = r12.f7472i
            int r1 = r12.f7473j
            int r2 = r12.f7478o
            long r9 = com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr.init(r0, r1, r2, r14)
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            long r1 = r12.f7466c
            com.meizu.media.camera.camcontroller.CameraController$f[] r4 = r0.mo18634a((long) r1)
            if (r4 == 0) goto L_0x00b2
            int r5 = r12.f7477n
            boolean r6 = r12.f7474k
            int r7 = r12.f7472i
            int r8 = r12.f7473j
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            android.graphics.Rect r0 = r0.mo18608B()
            int r15 = r12.f7486w
            r1 = r45
            r2 = r9
            r16 = r9
            r9 = r0
            r10 = r15
            r1.mo19038a((long) r2, (com.meizu.media.camera.camcontroller.CameraController.C1880f[]) r4, (int) r5, (boolean) r6, (int) r7, (int) r8, (android.graphics.Rect) r9, (int) r10)
            goto L_0x00b4
        L_0x00b2:
            r16 = r9
        L_0x00b4:
            com.meizu.media.camera.Storage r0 = com.meizu.media.camera.Storage.m7750a()
            boolean r1 = r12.f7474k
            java.lang.String r2 = r12.f7465b
            java.lang.String r1 = r0.mo18626a((boolean) r1, (java.lang.String) r2)
            byte[] r5 = r12.f7469f
            int r6 = r12.f7472i
            int r7 = r12.f7473j
            int r8 = r12.f7478o
            r9 = 0
            r10 = 1058642330(0x3f19999a, float:0.6)
            r3 = r16
            com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr.captureProcess(r3, r5, r6, r7, r8, r9, r10)
            boolean r0 = r12.f7475l
            r2 = 2
            r3 = 0
            if (r0 != 0) goto L_0x00db
            boolean r0 = r12.f7487x
            if (r0 == 0) goto L_0x0279
        L_0x00db:
            byte[] r0 = r12.f7469f
            if (r0 == 0) goto L_0x0126
            int r0 = r12.f7472i
            int r4 = r12.f7473j
            int r0 = r0 * r4
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocateDirect(r0)
            r0.clear()
            r0.position(r14)
            byte[] r4 = r12.f7469f
            int r5 = r12.f7472i
            int r6 = r12.f7473j
            int r5 = r5 * r6
            java.nio.ByteBuffer r4 = r0.put(r4, r14, r5)
            r4.position(r14)
            int r4 = r12.f7472i
            int r5 = r12.f7473j
            int r4 = r4 * r5
            int r4 = r4 / r2
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocateDirect(r4)
            r4.clear()
            r4.position(r14)
            byte[] r5 = r12.f7469f
            int r6 = r12.f7472i
            int r7 = r12.f7473j
            int r6 = r6 * r7
            int r7 = r12.f7472i
            int r8 = r12.f7473j
            int r7 = r7 * r8
            int r7 = r7 / r2
            java.nio.ByteBuffer r5 = r4.put(r5, r6, r7)
            r5.position(r14)
            goto L_0x0128
        L_0x0126:
            r0 = r3
            r4 = r0
        L_0x0128:
            boolean r5 = r12.f7475l
            if (r5 == 0) goto L_0x01ce
            boolean r5 = com.meizu.media.camera.util.DeviceHelper.f13881ah
            if (r5 == 0) goto L_0x013a
            java.lang.String r5 = r12.f7459A
            if (r5 == 0) goto L_0x013a
            java.lang.String r5 = r12.f7459A
            com.meizu.media.photoalgorithm.WaterMark.setCustomSign(r5)
            goto L_0x013d
        L_0x013a:
            com.meizu.media.photoalgorithm.WaterMark.setCustomSign(r3)
        L_0x013d:
            android.content.Context r5 = r11.f7428o
            java.lang.String r6 = com.meizu.media.camera.util.DeviceHelper.f14008dB
            boolean r7 = com.meizu.media.camera.util.DeviceUtil.m16196a()
            android.graphics.Bitmap r5 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkBitmap(r5, r6, r7)
            if (r5 == 0) goto L_0x01ce
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r6 = com.meizu.media.camera.util.DeviceHelper.f14036f
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r7 = com.meizu.media.camera.util.DeviceHelper.CUSTOM_DEVICE_MARK.PROCESS_AFTER_DEVICE_NAME
            if (r6 != r7) goto L_0x0153
            r6 = 1
            goto L_0x0154
        L_0x0153:
            r6 = 0
        L_0x0154:
            com.meizu.media.photoalgorithm.WaterMark.updateScaleRatioUsedStatus(r6)
            int r6 = r12.f7472i
            int r7 = r12.f7473j
            int r8 = r12.f7477n
            float r6 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkScaledRaio(r6, r7, r5, r8)
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            r7.postScale(r6, r6)
            int r6 = r12.f7477n
            int r6 = 360 - r6
            float r6 = (float) r6
            r7.postRotate(r6)
            r19 = 0
            r20 = 0
            int r21 = r5.getWidth()
            int r22 = r5.getHeight()
            r24 = 1
            r18 = r5
            r23 = r7
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r18, r19, r20, r21, r22, r23, r24)
            int r7 = r12.f7472i
            int r8 = r12.f7473j
            int r9 = r6.getWidth()
            int r10 = r6.getHeight()
            int r15 = r12.f7477n
            android.graphics.Rect r28 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkRect(r7, r8, r9, r10, r15)
            int r7 = r12.f7472i
            int r8 = r12.f7472i
            int r9 = r12.f7472i
            int r10 = r12.f7472i
            int r15 = r12.f7473j
            int r3 = r12.f7477n
            r18 = r0
            r19 = r4
            r20 = r4
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r15
            r26 = r6
            r27 = r3
            com.meizu.media.photoalgorithm.WaterMark.nativePhotoWaterMarkYUV(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r3 = r6.isRecycled()
            if (r3 != 0) goto L_0x01c5
            r6.recycle()
        L_0x01c5:
            boolean r3 = r5.isRecycled()
            if (r3 != 0) goto L_0x01ce
            r5.recycle()
        L_0x01ce:
            boolean r3 = r12.f7487x
            if (r3 == 0) goto L_0x0253
            android.content.Context r3 = r11.f7428o
            java.lang.String r5 = r12.f7489z
            android.graphics.Bitmap r3 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkBitmap(r3, r5)
            if (r3 == 0) goto L_0x0253
            int r5 = r12.f7472i
            int r6 = r12.f7473j
            int r7 = r12.f7477n
            float r5 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkScaledRaio(r5, r6, r3, r7)
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r6.postScale(r5, r5)
            int r5 = r12.f7477n
            int r5 = 360 - r5
            float r5 = (float) r5
            r6.postRotate(r5)
            r19 = 0
            r20 = 0
            int r21 = r3.getWidth()
            int r22 = r3.getHeight()
            r24 = 1
            r18 = r3
            r23 = r6
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r18, r19, r20, r21, r22, r23, r24)
            int r6 = r12.f7472i
            int r7 = r12.f7473j
            int r8 = r5.getWidth()
            int r9 = r5.getHeight()
            int r10 = r12.f7477n
            android.graphics.Rect r28 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkRect(r6, r7, r8, r9, r10)
            int r6 = r12.f7472i
            int r7 = r12.f7472i
            int r8 = r12.f7472i
            int r9 = r12.f7472i
            int r10 = r12.f7473j
            int r15 = r12.f7477n
            r18 = r0
            r19 = r4
            r20 = r4
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r5
            r27 = r15
            com.meizu.media.photoalgorithm.WaterMark.nativePhotoWaterMarkYUV(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r6 = r5.isRecycled()
            if (r6 != 0) goto L_0x024a
            r5.recycle()
        L_0x024a:
            boolean r5 = r3.isRecycled()
            if (r5 != 0) goto L_0x0253
            r3.recycle()
        L_0x0253:
            if (r0 == 0) goto L_0x0279
            if (r4 == 0) goto L_0x0279
            byte[] r3 = r12.f7469f
            if (r3 == 0) goto L_0x0279
            byte[] r3 = r12.f7469f
            int r5 = r0.remaining()
            r0.get(r3, r14, r5)
            byte[] r3 = r12.f7469f
            int r5 = r12.f7472i
            int r6 = r12.f7473j
            int r5 = r5 * r6
            int r6 = r4.remaining()
            r4.get(r3, r5, r6)
            r4.clear()
            r0.clear()
        L_0x0279:
            byte[] r0 = r12.f7469f
            int r3 = r12.f7472i
            int r4 = r12.f7473j
            int r5 = r12.f7478o
            android.graphics.Rect r6 = r12.f7479p
            int r7 = r12.f7477n
            android.location.Location r8 = r12.f7468e
            long r9 = r12.f7466c
            android.hardware.camera2.TotalCaptureResult r15 = r12.f7480q
            boolean[] r2 = new boolean[r13]
            boolean r13 = r12.f7462D
            r2[r14] = r13
            r18 = r0
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r27 = r15
            r28 = r2
            byte[] r2 = com.meizu.media.camera.util.FormatUtil.m16272a(r18, r19, r20, r21, r22, r23, r24, r25, r27, r28)
            r3 = r16
            com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr.uninit(r3, r14)
            if (r2 == 0) goto L_0x02b2
            int r0 = r2.length
            goto L_0x02b3
        L_0x02b2:
            r0 = 0
        L_0x02b3:
            long r3 = r11.f7965B
            long r5 = (long) r0
            long r3 = r3 + r5
            r11.f7965B = r3
            boolean r0 = r45.mo19039u()
            if (r0 == 0) goto L_0x02de
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "Cannot add image when the queue is full"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4[r14] = r3
            r11.m8380b(r0, r1, r2, r4)
            long r0 = r11.f7965B
            long r0 = r0 - r5
            r11.f7965B = r0
            return
        L_0x02de:
            android.content.Context r0 = r11.f7428o
            if (r0 != 0) goto L_0x02ea
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r1 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x02ea:
            com.meizu.media.camera.d.c r3 = com.meizu.media.camera.Exif.m10044a((byte[]) r2)
            int r4 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r3)
            int r0 = r12.f7477n
            int r0 = r0 + r4
            int r0 = r0 % 180
            if (r0 != 0) goto L_0x0302
            int r0 = r12.f7472i
            int r7 = r12.f7473j
        L_0x02fd:
            r39 = r0
            r40 = r7
            goto L_0x0307
        L_0x0302:
            int r0 = r12.f7473j
            int r7 = r12.f7472i
            goto L_0x02fd
        L_0x0307:
            r7 = 0
        L_0x0308:
            r0 = 10
            if (r7 >= r0) goto L_0x038b
            boolean r8 = m8371a((java.lang.String) r1)
            if (r8 == 0) goto L_0x037b
            android.content.Context r8 = r11.f7428o
            if (r8 != 0) goto L_0x0326
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.String r2 = "updateImage:isDestroyed is true,return"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
            m8379b((java.lang.String) r1)
            long r0 = r11.f7965B
            long r0 = r0 - r5
            r11.f7965B = r0
            return
        L_0x0326:
            android.content.Context r8 = r11.f7428o
            if (r8 == 0) goto L_0x038b
            if (r2 == 0) goto L_0x038b
            com.meizu.media.camera.Storage r29 = com.meizu.media.camera.Storage.m7750a()
            android.content.Context r8 = r11.f7428o
            android.content.ContentResolver r30 = r8.getContentResolver()
            java.lang.String r8 = r12.f7465b
            long r9 = r12.f7466c
            android.location.Location r13 = r12.f7468e
            com.meizu.media.camera.a.g r15 = r12.f7484u
            boolean r14 = r12.f7474k
            r42 = 0
            r43 = 0
            r44 = 0
            r31 = r8
            r32 = r9
            r34 = r13
            r35 = r4
            r36 = r3
            r37 = r15
            r38 = r2
            r41 = r14
            android.net.Uri r8 = r29.mo18614a(r30, r31, r32, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            com.meizu.media.camera.util.ac$a r9 = f7962u
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r13 = "updateImage uri:"
            r10.append(r13)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r9, (java.lang.String) r10)
            com.meizu.media.camera.Storage r9 = com.meizu.media.camera.Storage.m7750a()
            r9.mo18674p(r1)
            m8379b((java.lang.String) r1)
            goto L_0x038c
        L_0x037b:
            r8 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0381 }
            goto L_0x0386
        L_0x0381:
            r0 = move-exception
            r8 = r0
            r8.printStackTrace()
        L_0x0386:
            int r7 = r7 + 1
            r14 = 0
            goto L_0x0308
        L_0x038b:
            r8 = 0
        L_0x038c:
            android.content.Context r9 = r11.f7428o
            com.meizu.media.camera.util.CameraUtil.m15845a((android.content.Context) r9, (java.lang.String) r1)
            boolean r9 = com.meizu.media.camera.camcontroller.CameraController.m8857N()
            if (r9 == 0) goto L_0x03a1
            com.meizu.media.camera.camcontroller.CameraController.m8858O()
            int r9 = com.meizu.media.camera.camcontroller.CameraController.m8860Q()
            r11.m8348a((int) r9)
        L_0x03a1:
            if (r7 < r0) goto L_0x03bf
            com.meizu.media.camera.util.ac$a r0 = f7962u
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateImage timeout : "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            long r0 = r11.f7965B
            long r0 = r0 - r5
            r11.f7965B = r0
            return
        L_0x03bf:
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r7 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r9 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            r10 = 0
            java.lang.Object[] r13 = new java.lang.Object[r10]
            r11.m8380b(r0, r7, r9, r13)
            if (r8 == 0) goto L_0x03ed
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r7 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r9 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r10] = r8
            r11.m8380b(r0, r7, r9, r14)
            long r7 = r12.f7466c
            r11.m8360a((com.meizu.media.camera.p067d.ExifInterface) r3, (long) r7)
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r7 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r8 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            java.lang.Object[] r9 = new java.lang.Object[r13]
            r9[r10] = r1
            r11.m8380b(r0, r7, r8, r9)
        L_0x03ed:
            boolean r0 = r45.mo19039u()
            long r7 = r11.f7965B
            long r7 = r7 - r5
            r11.f7965B = r7
            boolean r1 = r45.mo19039u()
            if (r1 == r0) goto L_0x040f
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r5 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r6 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r6)
            r7[r6] = r8
            r11.m8380b(r0, r1, r5, r7)
        L_0x040f:
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r5 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            r6 = 5
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r7 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r8 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r7 != r8) goto L_0x0421
            r3 = 0
        L_0x041f:
            r7 = 0
            goto L_0x0426
        L_0x0421:
            android.graphics.Bitmap r3 = r3.mo19842a()
            goto L_0x041f
        L_0x0426:
            r6[r7] = r3
            r3 = 1
            r6[r3] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r3 = 2
            r6[r3] = r2
            r2 = 3
            boolean r3 = r12.f7474k
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r6[r2] = r3
            r2 = 4
            boolean r3 = r12.f7488y
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r6[r2] = r3
            r11.m8380b(r0, r1, r5, r6)
            java.util.UUID r0 = r12.f7464a
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = r12.f7471h
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r3[r4] = r5
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r3[r4] = r5
            r11.m8380b(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.m8401e(com.meizu.media.camera.a.f):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19038a(long r22, com.meizu.media.camera.camcontroller.CameraController.C1880f[] r24, int r25, boolean r26, int r27, int r28, android.graphics.Rect r29, int r30) {
        /*
            r21 = this;
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = r28
            r5 = r30
            r6 = 8
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Long r8 = new java.lang.Long
            r14 = r22
            r8.<init>(r14)
            r16 = 0
            r7[r16] = r8
            r8 = 1
            r7[r8] = r0
            java.lang.Integer r9 = new java.lang.Integer
            r13 = r25
            r9.<init>(r13)
            r10 = 2
            r7[r10] = r9
            java.lang.Byte r9 = new java.lang.Byte
            r9.<init>(r1)
            r11 = 3
            r7[r11] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r2)
            r12 = 4
            r7[r12] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r3)
            r17 = 5
            r7[r17] = r9
            r9 = 6
            r7[r9] = r29
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r5)
            r18 = 7
            r7[r18] = r9
            com.meizu.savior.ChangeQuickRedirect r9 = f7961t
            java.lang.Class[] r6 = new java.lang.Class[r6]
            java.lang.Class r19 = java.lang.Long.TYPE
            r6[r16] = r19
            java.lang.Class<com.meizu.media.camera.camcontroller.CameraController$f[]> r19 = com.meizu.media.camera.camcontroller.CameraController.C1880f[].class
            r6[r8] = r19
            java.lang.Class r8 = java.lang.Integer.TYPE
            r6[r10] = r8
            java.lang.Class r8 = java.lang.Boolean.TYPE
            r6[r11] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r6[r12] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r6[r17] = r8
            java.lang.Class<android.graphics.Rect> r8 = android.graphics.Rect.class
            r10 = 6
            r6[r10] = r8
            java.lang.Class r8 = java.lang.Integer.TYPE
            r6[r18] = r8
            java.lang.Class r17 = java.lang.Void.TYPE
            r10 = 0
            r11 = 834(0x342, float:1.169E-42)
            r8 = r21
            r12 = r6
            r13 = r17
            com.meizu.savior.PatchProxyResult r6 = com.meizu.savior.PatchProxy.proxy(r7, r8, r9, r10, r11, r12, r13)
            boolean r6 = r6.isSupported
            if (r6 == 0) goto L_0x0083
            return
        L_0x0083:
            int r6 = r0.length
            if (r3 <= r2) goto L_0x008c
            if (r5 == 0) goto L_0x0096
            r7 = 180(0xb4, float:2.52E-43)
            if (r5 == r7) goto L_0x0096
        L_0x008c:
            if (r2 <= r3) goto L_0x009b
            r7 = 90
            if (r5 == r7) goto L_0x0096
            r7 = 270(0x10e, float:3.78E-43)
            if (r5 != r7) goto L_0x009b
        L_0x0096:
            r20 = r3
            r3 = r2
            r2 = r20
        L_0x009b:
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            float r5 = (float) r5
            r7.postRotate(r5)
            float r2 = (float) r2
            r5 = 1157234688(0x44fa0000, float:2000.0)
            float r8 = r2 / r5
            float r3 = (float) r3
            float r9 = r3 / r5
            r7.postScale(r8, r9)
            r8 = 1073741824(0x40000000, float:2.0)
            float r9 = r2 / r8
            float r3 = r3 / r8
            r7.postTranslate(r9, r3)
            r3 = 0
            com.meizu.media.camera.camcontroller.CameraController r9 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r9 = r9.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r9 != r10) goto L_0x00ec
            if (r29 == 0) goto L_0x00ec
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            int r9 = r29.width()
            int r9 = -r9
            float r9 = (float) r9
            float r9 = r9 / r8
            int r10 = r29.height()
            int r10 = -r10
            float r10 = (float) r10
            float r10 = r10 / r8
            r3.preTranslate(r9, r10)
            int r8 = r29.width()
            float r8 = (float) r8
            float r8 = r5 / r8
            int r4 = r29.height()
            float r4 = (float) r4
            float r5 = r5 / r4
            r3.postScale(r8, r5)
        L_0x00ec:
            android.graphics.RectF r4 = new android.graphics.RectF
            r4.<init>()
            r5 = 0
        L_0x00f2:
            if (r5 >= r6) goto L_0x0168
            r8 = r0[r5]
            android.graphics.Rect r8 = r8.mo19557b()
            int r8 = r8.bottom
            r9 = r0[r5]
            android.graphics.Rect r9 = r9.mo19557b()
            int r9 = r9.left
            r10 = r0[r5]
            android.graphics.Rect r10 = r10.mo19557b()
            int r10 = r10.right
            r11 = r0[r5]
            android.graphics.Rect r11 = r11.mo19557b()
            int r11 = r11.top
            android.graphics.Rect r12 = new android.graphics.Rect
            r12.<init>(r9, r11, r10, r8)
            r4.set(r12)
            if (r3 == 0) goto L_0x0121
            r3.mapRect(r4)
        L_0x0121:
            r7.mapRect(r4)
            if (r1 == 0) goto L_0x0132
            float r8 = r4.left
            float r9 = r4.right
            float r9 = r2 - r9
            r4.left = r9
            float r8 = r2 - r8
            r4.right = r8
        L_0x0132:
            com.meizu.media.camera.singlebokeh.c r8 = new com.meizu.media.camera.singlebokeh.c
            float r9 = r4.bottom
            int r9 = (int) r9
            float r10 = r4.left
            int r10 = (int) r10
            float r11 = r4.right
            int r11 = (int) r11
            float r12 = r4.top
            int r12 = (int) r12
            r8.<init>(r9, r10, r11, r12)
            int r13 = r8.mo21435b()
            int r16 = r8.mo21437d()
            int r17 = r8.mo21436c()
            int r8 = r8.mo21434a()
            r9 = r22
            r11 = r6
            r12 = r25
            r14 = r16
            r15 = r17
            r16 = r8
            r17 = r5
            com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr.setCaptureFace(r9, r11, r12, r13, r14, r15, r16, r17)
            int r5 = r5 + 1
            r14 = r22
            goto L_0x00f2
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CameraOptTask.mo19038a(long, com.meizu.media.camera.camcontroller.CameraController$f[], int, boolean, int, int, android.graphics.Rect, int):void");
    }
}
