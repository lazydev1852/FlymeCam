package com.meizu.media.camera;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.ViewCompat;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeListener;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p077ui.MzBurstUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.BurstData;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.j */
public class MzBurstHandler implements CamIntentTask.C1777c {

    /* renamed from: a */
    public static ChangeQuickRedirect f10398a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10399b = new LogUtil.C2630a("MzBurstHandler");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f10400A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f10401B = null;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f10402C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f10403D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f10404E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public final Object f10405F = new Object();

    /* renamed from: G */
    private UUID f10406G = UUID.randomUUID();
    /* access modifiers changed from: private */

    /* renamed from: H */
    public ArrayList<ContentValues> f10407H = new ArrayList<>();

    /* renamed from: I */
    private Handler f10408I = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10435a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10435a, false, 1157, new Class[]{Message.class}, Void.TYPE).isSupported) {
                int i = message.what;
                if (i != 6) {
                    switch (i) {
                        case 1:
                            MzBurstHandler.this.f10411c.mo22033a(message.arg1);
                            return;
                        case 2:
                            MzBurstHandler.this.mo20299r();
                            return;
                        case 3:
                            MzBurstHandler.this.f10412d.mo20345j();
                            CameraController.m8868g().mo19480a(new boolean[0]);
                            MzBurstHandler.this.f10415g.mo18231eb();
                            boolean unused = MzBurstHandler.this.f10402C = true;
                            MzBurstHandler.this.m10691b(true);
                            return;
                        case 4:
                            if (MzBurstHandler.this.f10411c != null && MzBurstHandler.this.f10413e != null) {
                                MzBurstHandler.this.f10411c.mo22034a(0, false);
                                MzBurstHandler.this.f10423o.mo18019a(true, true);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else if (!MzBurstHandler.this.f10421m) {
                    MzBurstHandler.this.mo20300s();
                } else {
                    sendEmptyMessageDelayed(6, 20);
                }
            }
        }
    };

    /* renamed from: J */
    private MeizuCamera.MeizuCameraContinuousCallback f10409J = new MeizuCamera.MeizuCameraContinuousCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10437a;

        public void onContinuousNotify(int i, int i2) {
            Object[] objArr = {new Integer(i), new Integer(i2)};
            ChangeQuickRedirect changeQuickRedirect = f10437a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1167, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                MzBurstHandler.this.m10682a((byte[]) null, i, i2, (Camera) null);
            }
        }
    };

    /* renamed from: K */
    private C2134a f10410K;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzBurstUI f10411c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MzCamParamsManager f10412d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CameraActivity f10413e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ContentResolver f10414f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CameraModeListener f10415g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MediaSaveService.C1639d f10416h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MzUIController f10417i;

    /* renamed from: j */
    private ArrayList<C2135b> f10418j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public FileDescriptor[] f10419k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public FileOutputStream[] f10420l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f10421m = false;

    /* renamed from: n */
    private boolean f10422n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C2136c f10423o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f10424p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f10425q = true;

    /* renamed from: r */
    private boolean f10426r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f10427s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f10428t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f10429u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Location f10430v;

    /* renamed from: w */
    private int f10431w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ArrayList<File> f10432x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ArrayList<String> f10433y;

    /* renamed from: z */
    private ArrayList<C2135b> f10434z;

    /* renamed from: com.meizu.media.camera.j$c */
    /* compiled from: MzBurstHandler */
    public interface C2136c {
        /* renamed from: a */
        void mo18019a(boolean... zArr);

        /* renamed from: v */
        void mo18270v();
    }

    /* renamed from: a */
    private boolean m10683a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public Bitmap mo17987a(Bitmap bitmap, Point[] pointArr) {
        return null;
    }

    /* renamed from: a */
    public List<Surface> mo17988a(boolean z) {
        return null;
    }

    /* renamed from: a */
    public void mo18006a(ParamData fVar) {
    }

    /* renamed from: e */
    public List<Surface> mo18229e() {
        return null;
    }

    /* renamed from: h */
    public int mo18238h() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18240i() {
        return false;
    }

    /* renamed from: j */
    public void mo18241j() {
    }

    /* renamed from: k */
    public void mo18243k() {
    }

    public MzBurstHandler(CameraActivity cameraActivity, MzCamParamsManager lVar, CameraModeListener hVar, C2136c cVar, MediaSaveService.C1639d dVar) {
        this.f10412d = lVar;
        this.f10415g = hVar;
        this.f10423o = cVar;
        this.f10413e = cameraActivity;
        this.f10414f = cameraActivity.getApplicationContext().getContentResolver();
        this.f10416h = dVar;
        CameraOptTask.m7840a((CamIntentTask.C1777c) this);
    }

    /* renamed from: a */
    public void mo20291a() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1138, new Class[0], Void.TYPE).isSupported) {
            this.f10418j = new ArrayList<>();
            m10718x();
        }
    }

    /* renamed from: a */
    public void mo20292a(MzUIController uVar) {
        this.f10417i = uVar;
    }

    /* renamed from: l */
    public void mo20293l() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1139, new Class[0], Void.TYPE).isSupported) {
            this.f10421m = false;
            mo20298q();
            m10717w();
            if (this.f10410K != null) {
                this.f10410K.mo20313b();
                this.f10410K = null;
            }
            if (this.f10426r) {
                this.f10408I.removeMessages(3);
                this.f10408I.removeMessages(2);
                mo20299r();
                this.f10431w = 0;
                this.f10426r = false;
                this.f10425q = true;
                this.f10423o.mo18019a(new boolean[0]);
                if (this.f10411c != null && this.f10413e != null) {
                    this.f10411c.mo22034a(0, false);
                }
            }
        }
    }

    /* renamed from: m */
    public boolean mo20294m() {
        return this.f10426r;
    }

    /* renamed from: a */
    private void m10679a(C2135b bVar) {
        C2135b bVar2 = bVar;
        if (!PatchProxy.proxy(new Object[]{bVar2}, this, f10398a, false, 1140, new Class[]{C2135b.class}, Void.TYPE).isSupported) {
            this.f10418j.add(bVar2);
            String b = CameraUtil.m15875b(bVar2.f10471a, bVar2.f10474d);
            final String a = Storage.m7750a().mo18623a(b, this.f10401B);
            new AsyncTaskEx<C2135b, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10440a;

                /* renamed from: a */
                public Void mo17658a(C2135b... bVarArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVarArr}, this, f10440a, false, 1158, new Class[]{C2135b[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    if (MzBurstHandler.this.f10432x == null) {
                        return null;
                    }
                    LogUtil.C2630a v = MzBurstHandler.f10399b;
                    LogUtil.m15942a(v, "file:" + ((File) MzBurstHandler.this.f10432x.get(bVarArr[0].f10474d - 1)).getAbsolutePath());
                    LogUtil.C2630a v2 = MzBurstHandler.f10399b;
                    LogUtil.m15942a(v2, "filePath:" + a);
                    if (!((File) MzBurstHandler.this.f10432x.get(bVarArr[0].f10474d - 1)).renameTo(new File(a))) {
                        LogUtil.m15942a(MzBurstHandler.f10399b, "BurstPicture filePath is wrong!");
                    }
                    if (MzBurstHandler.this.f10433y == null) {
                        return null;
                    }
                    MzBurstHandler.this.f10433y.add(new File(a).getAbsolutePath());
                    return null;
                }
            }.mo22614c((Params[]) new C2135b[]{bVar2});
            int i = this.f10427s;
            int i2 = this.f10428t;
            if (((this.f10429u / 90) & 1) == 1) {
                i = this.f10428t;
                i2 = this.f10427s;
            }
            int i3 = i;
            int i4 = i2;
            this.f10407H.add(Storage.m7750a().mo18609a(bVar2.f10471a, this.f10401B, b, 0, bVar2.f10472b, i3, i4, this.f10430v));
            if (bVar2.f10473c) {
                CameraActivity cameraActivity = this.f10413e;
                CameraUtil.m15845a((Context) cameraActivity, Storage.m7750a().mo18655g() + "/" + this.f10401B);
                new AsyncTaskEx<Void, Void, Uri>(0) {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10443a;

                    /* renamed from: a */
                    public Uri mo17658a(Void... voidArr) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10443a, false, 1159, new Class[]{Void[].class}, Uri.class);
                        return proxy.isSupported ? (Uri) proxy.result : Storage.m7750a().mo18618a(MzBurstHandler.this.f10414f, (ArrayList<ContentValues>) MzBurstHandler.this.f10407H);
                    }

                    /* renamed from: a */
                    public void mo17660a(Uri uri) {
                        if (!PatchProxy.proxy(new Object[]{uri}, this, f10443a, false, 1160, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                            int ceil = (int) Math.ceil(((double) MzBurstHandler.this.f10427s) / ((double) CameraUtil.m15903i()));
                            if (!MzBurstHandler.this.f10415g.mo18200dX()) {
                                MzBurstHandler.this.f10416h.mo17846a(a, Integer.highestOneBit(ceil), 0, (byte[]) null);
                                if (uri != null) {
                                    MzBurstHandler.this.f10416h.mo17844a(uri);
                                }
                                MzBurstHandler.this.f10416h.mo17847a((List<String>) MzBurstHandler.this.f10433y);
                            } else if (MzBurstHandler.this.f10413e == null) {
                                LogUtil.m15942a(MzBurstHandler.f10399b, "activity is destroyed, abort capture!!!");
                                return;
                            } else {
                                MzBurstHandler.this.f10413e.mo17673b(uri);
                                MzBurstHandler.this.f10416h.mo17844a((Uri) null);
                            }
                            boolean unused = MzBurstHandler.this.f10403D = true;
                            MzBurstHandler.this.m10691b(true);
                        }
                    }
                }.mo22614c((Params[]) new Void[0]);
            }
        }
    }

    /* renamed from: w */
    private void m10717w() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1141, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10399b, "clearBurstFiles start");
            this.f10421m = false;
            new AsyncTaskEx<Object, Object, Object>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10447a;

                /* renamed from: a */
                public Object mo17658a(Object... objArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, this, f10447a, false, 1161, new Class[]{Object[].class}, Object.class);
                    if (proxy.isSupported) {
                        return proxy.result;
                    }
                    synchronized (MzBurstHandler.this.f10405F) {
                        if (MzBurstHandler.this.f10432x != null) {
                            for (int i = 0; i < MzBurstHandler.this.f10432x.size(); i++) {
                                File file = (File) MzBurstHandler.this.f10432x.get(i);
                                if (file.exists() && !file.delete()) {
                                    LogUtil.m15942a(MzBurstHandler.f10399b, "failed to delete burst files");
                                }
                            }
                            ArrayList unused = MzBurstHandler.this.f10432x = null;
                        }
                    }
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Object[0]);
            this.f10434z = null;
            this.f10433y = null;
            LogUtil.m15942a(f10399b, "clearBurstFiles end");
        }
    }

    /* renamed from: n */
    public void mo20295n() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1142, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10399b, "reInit");
            mo20293l();
            mo20291a();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18014a(com.meizu.media.camera.util.Contants.CameraService.RequestCode r16, com.meizu.media.camera.util.Contants.CameraService.ResultCode r17, java.lang.Object... r18) {
        /*
            r15 = this;
            r8 = r15
            r7 = r16
            r9 = r17
            r10 = r18
            r11 = 3
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r12 = 0
            r0[r12] = r7
            r13 = 1
            r0[r13] = r9
            r14 = 2
            r0[r14] = r10
            com.meizu.savior.ChangeQuickRedirect r2 = f10398a
            java.lang.Class[] r5 = new java.lang.Class[r11]
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r5[r12] = r1
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$ResultCode> r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.class
            r5[r13] = r1
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            r5[r14] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 1143(0x477, float:1.602E-42)
            r1 = r15
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0032
            return
        L_0x0032:
            com.meizu.media.camera.util.ac$a r0 = f10399b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onActionDone requestCode:"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ",resultCode:"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            int[] r0 = com.meizu.media.camera.MzBurstHandler.C21262.f10439a
            int r1 = r16.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0092;
                case 2: goto L_0x005d;
                case 3: goto L_0x0073;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x014c
        L_0x005d:
            com.meizu.media.camera.util.ac$a r0 = f10399b
            java.lang.String r1 = "REQUEST_CODE_START_PREVIEW"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10958c((boolean) r12)
            if (r0 == 0) goto L_0x0073
            com.meizu.media.camera.util.ac$a r0 = f10399b
            java.lang.String r1 = "break case, will do in REQUEST_CODE_START_FACE_DETECTION"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x014c
        L_0x0073:
            com.meizu.media.camera.util.ac$a r0 = f10399b
            java.lang.String r1 = "REQUEST_CODE_START_FACE_DETECTION"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            boolean r0 = r8.f10426r
            if (r0 == 0) goto L_0x014c
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x014c
            com.meizu.media.camera.mode.h r0 = r8.f10415g
            r0.mo18053al(r13)
            r8.f10402C = r13
            r15.m10691b((boolean) r13)
            goto L_0x014c
        L_0x0092:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_BURST_CAPTURE_FINISHED
            boolean r0 = r0.equals(r9)
            r1 = 5
            r2 = 4
            if (r0 == 0) goto L_0x00fc
            int r0 = r10.length
            if (r0 >= r11) goto L_0x00bf
            r0 = r10[r12]
            if (r0 == 0) goto L_0x00ac
            r0 = r10[r12]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            r1 = r10[r13]
            if (r1 == 0) goto L_0x00b9
            r1 = r10[r13]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
        L_0x00b9:
            r1 = 0
            r15.m10682a(r1, r0, r12, r1)
            goto L_0x014c
        L_0x00bf:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r12)
            r0 = r10[r12]
            r4 = r0
            com.meizu.media.camera.util.h r4 = (com.meizu.media.camera.util.BurstData) r4
            r0 = r10[r13]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r5 = r0.intValue()
            r0 = r10[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r6 = r0.intValue()
            r0 = r10[r11]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            r0 = r10[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r9 = r0.booleanValue()
            r0 = r10[r1]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            r0 = r15
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r0.m10681a(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x014c
        L_0x00fc:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_LAST_BURST_CAPTURE_FINISHED
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0141
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
            r0 = r10[r12]
            r4 = r0
            com.meizu.media.camera.util.h r4 = (com.meizu.media.camera.util.BurstData) r4
            r0 = r10[r13]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r5 = r0.intValue()
            r0 = r10[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r6 = r0.intValue()
            r0 = r10[r11]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            r0 = r10[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r9 = r0.booleanValue()
            r0 = r10[r1]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            r0 = r15
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r0.m10681a(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x014c
        L_0x0141:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x014c
            r15.m10720z()
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzBurstHandler.mo18014a(com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.util.Contants$CameraService$ResultCode, java.lang.Object[]):void");
    }

    /* renamed from: a */
    private void m10681a(Boolean bool, BurstData hVar, int i, int i2, int i3, boolean z, boolean z2) {
        Boolean bool2;
        int i4;
        int i5;
        int i6 = i;
        int i7 = i2;
        if (!PatchProxy.proxy(new Object[]{bool, hVar, new Integer(i6), new Integer(i7), new Integer(i3), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10398a, false, 1144, new Class[]{Boolean.class, BurstData.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f10434z != null && this.f10431w + 1 <= DeviceHelper.f13940bn) {
            if (!this.f10422n) {
                this.f10422n = true;
            }
            if (!this.f10400A && !this.f10415g.mo18200dX()) {
                this.f10415g.mo18275x(4);
                DeviceUtil.m16194a(this.f10417i.mo21541af(), 22502);
            }
            this.f10431w++;
            if (this.f10431w == DeviceHelper.f13940bn) {
                this.f10408I.sendEmptyMessage(2);
                bool2 = true;
            } else {
                bool2 = bool;
            }
            this.f10408I.obtainMessage(1, this.f10431w, -1).sendToTarget();
            final long currentTimeMillis = System.currentTimeMillis();
            String b = CameraUtil.m15875b(currentTimeMillis, this.f10431w);
            String a = Storage.m7750a().mo18623a(b, this.f10401B);
            if (this.f10433y != null) {
                this.f10433y.add(new File(a).getAbsolutePath());
            }
            if (this.f10429u == 90 || this.f10429u == 270) {
                i4 = i6;
                i5 = i7;
            } else {
                i5 = i6;
                i4 = i7;
            }
            this.f10407H.add(Storage.m7750a().mo18609a(currentTimeMillis, this.f10401B, b, 0, -1, i5, i4, this.f10430v));
            final boolean z3 = z;
            final BurstData hVar2 = hVar;
            final String str = a;
            int ceil = (int) Math.ceil(((double) i5) / ((double) CameraUtil.m15903i()));
            final int i8 = i;
            final int i9 = i2;
            C21306 r14 = r0;
            final int i10 = i3;
            String str2 = a;
            final boolean z4 = z2;
            C21306 r0 = new AsyncTaskEx<Boolean, Void, Uri>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10449a;

                /* renamed from: a */
                public Uri mo17658a(Boolean... boolArr) {
                    Location a;
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{boolArr}, this, f10449a, false, 1162, new Class[]{Boolean[].class}, Uri.class);
                    if (proxy.isSupported) {
                        return (Uri) proxy.result;
                    }
                    if (z3) {
                        ExifInterface a2 = Exif.m10044a(hVar2.mo22728a());
                        a2.mo19846a(a2.mo19845a(ExifInterface.f9346ae, (Object) "NORMAL"));
                        Storage.m7750a().mo18631a(str, a2, hVar2.mo22728a());
                        return null;
                    }
                    ExifInterface cVar = new ExifInterface();
                    cVar.mo19876e();
                    cVar.mo19883o(0);
                    cVar.mo19858a(ExifInterface.f9408u, currentTimeMillis, TimeZone.getDefault());
                    if (!(MzBurstHandler.this.f10413e == null || MzBurstHandler.this.f10415g.mo18192dP() == null || (a = MzBurstHandler.this.f10415g.mo18192dP().mo19017a(currentTimeMillis)) == null)) {
                        cVar.mo19857a(a.getLatitude(), a.getLongitude());
                        cVar.mo19859a(currentTimeMillis);
                    }
                    cVar.mo19846a(cVar.mo19845a(ExifInterface.f9346ae, (Object) "NORMAL"));
                    Storage a3 = Storage.m7750a();
                    String str = str;
                    byte[] a4 = hVar2.mo22728a();
                    int i = i8;
                    int i2 = i9;
                    int i3 = i10;
                    int i4 = i2;
                    int i5 = i3;
                    a3.mo18632a(str, cVar, a4, i, i4, i5, MzBurstHandler.this.f10429u, z4, boolArr[0]);
                    CameraUtil.m15845a((Context) MzBurstHandler.this.f10413e, str);
                    boolean unused = MzBurstHandler.this.f10425q = boolArr[0].booleanValue();
                    if (!boolArr[0].booleanValue() || MzBurstHandler.this.f10417i == null) {
                        return null;
                    }
                    MzBurstHandler.this.f10417i.mo21577c(false, false, !MzBurstHandler.this.f10415g.mo18200dX());
                    return null;
                }
            };
            r14.mo22610a(AsyncTaskEx.f13742p, (Params[]) new Boolean[]{bool2});
            if (this.f10431w == 1) {
                this.f10424p = str2;
            }
            if (bool2.booleanValue()) {
                final int i11 = ceil;
                new AsyncTaskEx<Void, Void, Void>() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10459a;

                    /* renamed from: a */
                    public Void mo17658a(Void... voidArr) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10459a, false, 1163, new Class[]{Void[].class}, Void.class);
                        if (proxy.isSupported) {
                            return (Void) proxy.result;
                        }
                        Uri a = Storage.m7750a().mo18618a(MzBurstHandler.this.f10414f, (ArrayList<ContentValues>) MzBurstHandler.this.f10407H);
                        if (!MzBurstHandler.this.f10415g.mo18200dX()) {
                            MzBurstHandler.this.f10416h.mo17846a(MzBurstHandler.this.f10424p, Integer.highestOneBit(i11), 0, (byte[]) null);
                            if (a != null) {
                                MzBurstHandler.this.f10416h.mo17844a(a);
                            }
                            MzBurstHandler.this.f10416h.mo17847a((List<String>) MzBurstHandler.this.f10433y);
                        } else if (MzBurstHandler.this.f10413e == null) {
                            LogUtil.m15942a(MzBurstHandler.f10399b, "activity is destroyed, abort capture!!!");
                            return null;
                        } else {
                            MzBurstHandler.this.f10413e.mo17673b(a);
                            MzBurstHandler.this.f10416h.mo17844a((Uri) null);
                        }
                        String unused = MzBurstHandler.this.f10424p = null;
                        return null;
                    }
                }.mo22614c((Params[]) new Void[0]);
                LogUtil.m15952c(f10399b, "burst callback,last-image-saved message arrive.");
                this.f10403D = true;
                this.f10402C = true;
                m10691b(false);
            }
        }
    }

    /* renamed from: b */
    public UUID mo18056b() {
        return this.f10406G;
    }

    /* renamed from: c */
    public SurfaceTexture mo18119c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10398a, false, 1145, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : this.f10415g.mo18119c();
    }

    /* renamed from: d */
    public boolean mo18176d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10398a, false, 1146, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10415g.mo18176d();
    }

    /* renamed from: f */
    public SurfaceTexture mo18236f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10398a, false, 1147, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : this.f10415g.mo18119c();
    }

    /* renamed from: g */
    public boolean mo18237g() {
        return this.f10404E;
    }

    /* renamed from: o */
    public boolean mo20296o() {
        return this.f10425q;
    }

    /* renamed from: com.meizu.media.camera.j$b */
    /* compiled from: MzBurstHandler */
    private static class C2135b {

        /* renamed from: a */
        long f10471a;

        /* renamed from: b */
        int f10472b;

        /* renamed from: c */
        boolean f10473c;

        /* renamed from: d */
        int f10474d;

        private C2135b() {
        }
    }

    /* renamed from: x */
    private void m10718x() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1148, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10399b, "createNewBurstFiles start");
            this.f10421m = true;
            if (this.f10434z == null) {
                this.f10434z = new ArrayList<>();
            } else {
                this.f10434z.clear();
            }
            if (this.f10433y == null) {
                this.f10433y = new ArrayList<>();
            } else {
                this.f10433y.clear();
            }
            LogUtil.C2630a aVar = f10399b;
            LogUtil.m15942a(aVar, "createNewBurstFiles end mBurstFilesInfo:" + this.f10434z);
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10462a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    boolean z;
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10462a, false, 1164, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    synchronized (MzBurstHandler.this.f10405F) {
                        if (MzBurstHandler.this.f10432x == null) {
                            ArrayList unused = MzBurstHandler.this.f10432x = new ArrayList();
                        } else {
                            MzBurstHandler.this.f10432x.clear();
                        }
                        FileDescriptor[] unused2 = MzBurstHandler.this.f10419k = new FileDescriptor[DeviceHelper.f13940bn];
                        FileOutputStream[] unused3 = MzBurstHandler.this.f10420l = new FileOutputStream[DeviceHelper.f13940bn];
                        int i = 0;
                        while (true) {
                            if (i >= DeviceHelper.f13940bn) {
                                break;
                            }
                            try {
                                String str = "." + i;
                                File file = new File(Storage.m7750a().mo18623a(str, (String) null) + ".tmp");
                                if (file.exists()) {
                                    z = true;
                                } else {
                                    z = file.createNewFile();
                                }
                                if (MzBurstHandler.this.f10432x == null) {
                                    break;
                                }
                                if (z) {
                                    MzBurstHandler.this.f10432x.add(file);
                                } else {
                                    LogUtil.m15949b(MzBurstHandler.f10399b, "burstCapture(), create file failed !!!");
                                }
                                i++;
                            } catch (IOException e) {
                                boolean unused4 = MzBurstHandler.this.f10421m = false;
                                LogUtil.m15949b(MzBurstHandler.f10399b, "create capture file fail " + e);
                            }
                        }
                        MzBurstHandler.this.m10719y();
                        boolean unused5 = MzBurstHandler.this.f10421m = false;
                    }
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m10719y() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1149, new Class[0], Void.TYPE).isSupported && this.f10432x != null) {
            LogUtil.m15942a(f10399b, "start initBurstFD");
            int size = this.f10432x.size();
            int i = 0;
            while (i < size) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f10432x.get(i));
                    this.f10420l[i] = fileOutputStream;
                    this.f10419k[i] = fileOutputStream.getFD();
                    i++;
                } catch (Exception e) {
                    LogUtil.C2630a aVar = f10399b;
                    LogUtil.m15949b(aVar, "getBurstFD(), get descriptor failed !!!" + e.getLocalizedMessage());
                    this.f10419k = null;
                    this.f10421m = false;
                    return;
                }
            }
        }
    }

    /* renamed from: p */
    public FileDescriptor[] mo20297p() {
        return this.f10419k;
    }

    /* renamed from: q */
    public void mo20298q() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1150, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f10420l != null) {
                    for (int i = 0; i < this.f10420l.length; i++) {
                        if (this.f10420l[i] != null) {
                            this.f10420l[i].close();
                        }
                    }
                    this.f10420l = null;
                }
            } catch (IOException unused) {
                LogUtil.m15952c(f10399b, "close burst file stream failed");
            }
        }
    }

    /* renamed from: r */
    public void mo20299r() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1151, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10399b, "stopBurst");
            if (this.f10408I != null && this.f10408I.hasMessages(6)) {
                this.f10408I.removeMessages(6);
            }
            if (this.f10426r && !this.f10400A) {
                this.f10400A = true;
                if (this.f10431w != DeviceHelper.f13940bn) {
                    if (this.f10410K == null) {
                        this.f10410K = new C2134a();
                    } else {
                        this.f10410K.mo20312a();
                    }
                } else if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    CameraController.m8868g().mo19480a(new boolean[0]);
                }
                this.f10404E = true;
            }
        }
    }

    /* renamed from: s */
    public boolean mo20300s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10398a, false, 1152, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f10399b;
        LogUtil.m15952c(aVar, "capture()   mIsInBurstCapture:" + this.f10426r + "    mCaptureIniting:" + this.f10421m);
        if (this.f10426r || this.f10413e == null) {
            return false;
        }
        if (this.f10421m) {
            this.f10408I.sendEmptyMessageDelayed(6, 10);
            return false;
        }
        final FileDescriptor[] p = mo20297p();
        boolean z = true;
        boolean z2 = p != null;
        if (z2) {
            int length = p.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (p[i] == null) {
                    z2 = false;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (!z2) {
            this.f10403D = true;
            this.f10402C = true;
            if (DeviceHelper.f13910bJ != CameraController.CameraApi.API1) {
                z = false;
            }
            m10691b(z);
            return false;
        }
        this.f10411c = this.f10415g.mo18267u().mo22058U();
        this.f10423o.mo18270v();
        this.f10411c.mo22035a(this.f10417i);
        this.f10411c.mo22036b(DeviceHelper.f13940bn);
        this.f10422n = false;
        this.f10426r = true;
        this.f10402C = false;
        this.f10403D = false;
        this.f10400A = false;
        this.f10431w = 0;
        this.f10404E = false;
        new AsyncTaskEx<Void, Void, Void>() {

            /* renamed from: a */
            public static ChangeQuickRedirect f10464a;

            /* renamed from: a */
            public Void mo17658a(Void... voidArr) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10464a, false, 1165, new Class[]{Void[].class}, Void.class);
                if (proxy.isSupported) {
                    return (Void) proxy.result;
                }
                CameraController.m8868g().mo19479a(p);
                MzBurstHandler.this.mo20298q();
                MzBurstHandler.this.f10407H.clear();
                String unused = MzBurstHandler.this.f10401B = CameraUtil.m15890d(System.currentTimeMillis());
                Storage.m7750a().mo18666l(MzBurstHandler.this.f10401B);
                return null;
            }

            /* renamed from: a */
            public void mo17660a(Void voidR) {
                if (!PatchProxy.proxy(new Object[]{voidR}, this, f10464a, false, 1166, new Class[]{Void.class}, Void.TYPE).isSupported) {
                    super.mo17660a(voidR);
                    if (MzBurstHandler.this.f10413e == null) {
                        LogUtil.m15942a(MzBurstHandler.f10399b, "activity is destroyed abort capture!!!");
                        return;
                    }
                    int unused = MzBurstHandler.this.f10429u = CameraUtil.m15882c(MzBurstHandler.this.f10415g.mo18211di(), MzBurstHandler.this.f10415g.mo18194dR());
                    CameraController.m8868g().mo19490b(MzBurstHandler.this.f10429u, new boolean[0]);
                    if (DeviceHelper.f13840T) {
                        MzBurstHandler.this.f10412d.mo20320a(MzCamParamsManager.f10481f, true);
                    } else {
                        MzBurstHandler.this.f10412d.mo20320a(MzCamParamsManager.f10481f, new Object[0]);
                    }
                    if (DeviceHelper.f13841U && !DeviceHelper.f13831K) {
                        CameraController.m8868g().mo19471a("preview-fps-range", "30000,30000", new boolean[0]);
                    }
                    Location unused2 = MzBurstHandler.this.f10430v = MzBurstHandler.this.f10415g.mo18192dP().mo19017a(System.currentTimeMillis());
                    CameraController.m8868g().mo19455a(MzBurstHandler.this.f10430v, new boolean[0]);
                    Point a = CameraController.m8868g().mo19449a();
                    if (a == null) {
                        LogUtil.m15942a(MzBurstHandler.f10399b, "burstImageSize is null");
                        return;
                    }
                    int unused3 = MzBurstHandler.this.f10427s = a.x;
                    int unused4 = MzBurstHandler.this.f10428t = a.y;
                    MzBurstHandler.this.f10412d.mo20350o();
                    MzBurstHandler.this.f10412d.mo20318a(0);
                    MzBurstHandler.this.f10412d.mo20346k();
                    if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                        MzBurstHandler.this.f10412d.mo20331b(false, new boolean[0]);
                        CameraController.m8868g().mo19471a(Contants.CameraV2Key.AI_ASD_ENABLE.getKeyName(), "0", new boolean[0]);
                    }
                    CameraController.m8868g().mo19480a(new boolean[0]);
                    if (MzBurstHandler.this.f10404E || MzBurstHandler.this.f10413e == null || MzBurstHandler.this.f10400A || MzBurstHandler.this.f10413e.mo17677n()) {
                        LogUtil.m15942a(MzBurstHandler.f10399b, "precondition is not satisfied, cancel take burst picture");
                        MzBurstHandler.this.m10720z();
                        return;
                    }
                    Storage.m7750a().mo18652e(false);
                    CameraController.m8868g().mo19465a(CameraController.BurstCaptureState.IDLE);
                    Intent f = CameraOptTask.m8402f(MzBurstHandler.this.f10413e.getApplicationContext(), MzBurstHandler.this.mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_BURST_PICTURE);
                    boolean unused5 = MzBurstHandler.this.f10425q = false;
                    CameraOptTask.m8349a((Context) MzBurstHandler.this.f10413e, f);
                }
            }
        }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10682a(byte[] bArr, int i, int i2, Camera camera) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), camera}, this, f10398a, false, 1153, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Camera.class}, Void.TYPE).isSupported) {
            if (m10683a(i2, 2)) {
                LogUtil.m15942a(f10399b, "BURST_WRITE_FILE_FLAG:" + this.f10434z);
                if (this.f10434z != null) {
                    if (!this.f10422n) {
                        this.f10422n = true;
                    }
                    int i3 = DeviceHelper.f13841U ? (-16777216 & i) >> 24 : i;
                    LogUtil.m15942a(f10399b, "savedImageNumber is " + i3);
                    boolean a = m10683a(i2, 8);
                    if (m10683a(i2, 4)) {
                        LogUtil.m15949b(f10399b, "burst callback, delete a failed image   isLast:" + a);
                        this.f10432x.get(i3 - 1).delete();
                        if (a) {
                            this.f10403D = true;
                        }
                    } else if (this.f10434z.size() < i3) {
                        LogUtil.m15942a(f10399b, "burst callback number is error, don't need to save burstInfo");
                    } else {
                        C2135b bVar = this.f10434z.get(i3 - 1);
                        bVar.f10474d = i3;
                        bVar.f10473c = a;
                        if (DeviceHelper.f13841U) {
                            bVar.f10472b = i & ViewCompat.MEASURED_SIZE_MASK;
                        }
                        m10679a(bVar);
                        if (a) {
                            LogUtil.m15952c(f10399b, "burst callback,last-image-saved message arrive.");
                            if (DeviceHelper.f13840T) {
                                this.f10408I.sendEmptyMessage(3);
                            }
                        }
                    }
                }
            } else if (m10683a(i2, 16)) {
                LogUtil.m15952c(f10399b, "burst callback, HAL-all-done message arrive.");
                if (this.f10431w == 0 || !this.f10422n) {
                    this.f10403D = true;
                }
                this.f10408I.sendEmptyMessage(3);
                this.f10425q = true;
            } else {
                if (!m10683a(i2, 1)) {
                    LogUtil.m15949b(f10399b, "burst callback, error, why not encoding flag !!!");
                }
                if (!this.f10400A && !this.f10415g.mo18200dX()) {
                    this.f10415g.mo18275x(4);
                    DeviceUtil.m16194a(this.f10417i.mo21541af(), 22502);
                }
                this.f10431w++;
                if (this.f10431w == DeviceHelper.f13940bn) {
                    this.f10408I.sendEmptyMessage(2);
                }
                this.f10408I.obtainMessage(1, this.f10431w, -1).sendToTarget();
                if (this.f10434z != null) {
                    C2135b bVar2 = new C2135b();
                    bVar2.f10471a = System.currentTimeMillis();
                    if (!DeviceHelper.f13841U) {
                        bVar2.f10472b = i;
                    }
                    this.f10434z.add(bVar2);
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.j$a */
    /* compiled from: MzBurstHandler */
    private class C2134a extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f10467a;

        /* renamed from: c */
        private boolean f10469c = false;

        /* renamed from: d */
        private boolean f10470d = false;

        public C2134a() {
            setName("CancelThreadForM75");
            this.f10469c = true;
            start();
        }

        /* renamed from: a */
        public void mo20312a() {
            if (!PatchProxy.proxy(new Object[0], this, f10467a, false, 1168, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f10469c = true;
                    notifyAll();
                }
            }
        }

        /* renamed from: b */
        public void mo20313b() {
            if (!PatchProxy.proxy(new Object[0], this, f10467a, false, 1169, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f10470d = true;
                    notifyAll();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            com.meizu.media.camera.camcontroller.CameraController.m8868g().mo19529n(new android.content.Intent());
            r8.f10469c = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            monitor-exit(r8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f10467a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 1170(0x492, float:1.64E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                monitor-enter(r8)
                boolean r1 = r8.f10469c     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x002e
                r8.notifyAll()     // Catch:{ all -> 0x0046 }
                boolean r1 = r8.f10470d     // Catch:{ all -> 0x0046 }
                if (r1 == 0) goto L_0x0024
                monitor-exit(r8)     // Catch:{ all -> 0x0046 }
                return
            L_0x0024:
                r8.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x002c
            L_0x0028:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x0046 }
            L_0x002c:
                monitor-exit(r8)     // Catch:{ all -> 0x0046 }
                goto L_0x0016
            L_0x002e:
                monitor-exit(r8)     // Catch:{ all -> 0x0046 }
                com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
                android.content.Intent r2 = new android.content.Intent
                r2.<init>()
                r1.mo19529n(r2)
                r8.f10469c = r0
                monitor-enter(r8)
                r8.notifyAll()     // Catch:{ all -> 0x0043 }
                monitor-exit(r8)     // Catch:{ all -> 0x0043 }
                goto L_0x0016
            L_0x0043:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0043 }
                throw r0
            L_0x0046:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0046 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzBurstHandler.C2134a.run():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m10720z() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1154, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(LogUtil.f14072b, "cancelTakeBurstPicture");
            this.f10422n = false;
            File file = new File(Storage.m7750a().mo18655g() + '/' + this.f10401B);
            if (file.exists() && file.list() != null && file.list().length <= 0 && !file.delete()) {
                LogUtil.m15942a(f10399b, "failed to delete empty dir");
            }
            m10718x();
            this.f10426r = false;
            if (DeviceHelper.f13840T) {
                this.f10412d.mo20320a(MzCamParamsManager.f10481f, false);
            } else {
                this.f10412d.mo20320a(MzCamParamsManager.f10478c, new Object[0]);
            }
            this.f10423o.mo18019a(true, true, true);
            this.f10415g.mo18267u().mo22142b(true);
            if (!(this.f10411c == null || this.f10413e == null)) {
                this.f10411c.mo22034a(100, true);
            }
            this.f10425q = true;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                this.f10412d.mo20317a(16, new boolean[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10691b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10398a, false, 1155, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10399b;
            LogUtil.m15952c(aVar, "onBurstFinish(), mIsHalDone = " + this.f10402C + ", mIsAppDone = " + this.f10403D);
            if (this.f10413e != null && this.f10402C && this.f10403D) {
                this.f10422n = false;
                m10718x();
                this.f10426r = false;
                if (DeviceHelper.f13840T) {
                    this.f10412d.mo20320a(MzCamParamsManager.f10481f, false);
                }
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                    CameraController.m8868g().mo19471a(Contants.CameraV2Key.BURST_FPS.getKeyName(), "0", new boolean[0]);
                }
                this.f10408I.sendEmptyMessage(4);
                this.f10413e.mo17669a(Storage.m7750a().mo18664k(this.f10401B));
                if (z) {
                    this.f10412d.mo20317a(16, new boolean[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public Point[] mo18021a(Bitmap bitmap) {
        return new Point[0];
    }

    /* renamed from: t */
    public void mo20301t() {
        if (!PatchProxy.proxy(new Object[0], this, f10398a, false, 1156, new Class[0], Void.TYPE).isSupported) {
            CameraOptTask.m7842b((CamIntentTask.C1777c) this);
            if (this.f10410K != null) {
                this.f10410K.mo20313b();
                this.f10410K = null;
            }
            this.f10417i = null;
            this.f10413e = null;
        }
    }

    /* renamed from: u */
    public int mo20302u() {
        return this.f10431w;
    }
}
