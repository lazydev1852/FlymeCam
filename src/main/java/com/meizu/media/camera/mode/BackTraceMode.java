package com.meizu.media.camera.mode;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.view.Surface;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.Exif;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p077ui.MzBackTraceUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.BurstData;
import com.meizu.media.camera.util.CameraSizeUtil;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.meizu.media.camera.mode.c */
public class BackTraceMode extends CameraMode implements CamIntentTask.C1777c {
    /* access modifiers changed from: private */

    /* renamed from: D */
    public static final List<Integer> f10642D;

    /* renamed from: a */
    public static ChangeQuickRedirect f10643a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10644b = new LogUtil.C2630a("BackTraceMode");

    /* renamed from: A */
    private UsageStatsHelper f10645A;

    /* renamed from: B */
    private Handler f10646B = new Handler();

    /* renamed from: C */
    private AsyncTaskEx f10647C;

    /* renamed from: c */
    private int f10648c = 0;

    /* renamed from: d */
    private UUID f10649d = UUID.randomUUID();

    /* renamed from: e */
    private boolean f10650e;

    /* renamed from: f */
    private CopyOnWriteArrayList<C2168a> f10651f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<ContentValues> f10652g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ArrayList<File> f10653l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<String> f10654m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public FileDescriptor[] f10655n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FileOutputStream[] f10656o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f10657p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f10658q = 0;

    /* renamed from: r */
    private boolean f10659r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f10660s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f10661t = 0;

    /* renamed from: u */
    private int f10662u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f10663v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Location f10664w;

    /* renamed from: x */
    private MzBackTraceUI f10665x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Uri f10666y;

    /* renamed from: z */
    private CameraModeListener f10667z;

    /* renamed from: a */
    private boolean m11155a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: A */
    public int mo20377A() {
        return 1;
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

    /* renamed from: c_ */
    public boolean mo20464c_() {
        return false;
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        return null;
    }

    /* renamed from: g */
    public boolean mo18237g() {
        return false;
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

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return false;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return false;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    static {
        List<Integer> list;
        if (DeviceHelper.f13940bn == 30) {
            list = Arrays.asList(new Integer[]{0, 3, 6, 9, 12, 15, 18, 21, 24, Integer.valueOf(DeviceHelper.f13940bn - 1)});
        } else {
            list = Arrays.asList(new Integer[]{0, 1, 2, 4, 6, 8, 10, 12, 13, Integer.valueOf(DeviceHelper.f13940bn - 1)});
        }
        f10642D = list;
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
            com.meizu.savior.ChangeQuickRedirect r2 = f10643a
            java.lang.Class[] r5 = new java.lang.Class[r11]
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r5[r12] = r1
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$ResultCode> r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.class
            r5[r13] = r1
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            r5[r14] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 4603(0x11fb, float:6.45E-42)
            r1 = r15
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0032
            return
        L_0x0032:
            com.meizu.media.camera.util.ac$a r0 = f10644b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onActionDone requestCode:"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = "  resultCode:"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            int[] r0 = com.meizu.media.camera.mode.BackTraceMode.C21677.f10695a
            int r1 = r16.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x009b;
                case 2: goto L_0x0084;
                case 3: goto L_0x0075;
                case 4: goto L_0x005d;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0149
        L_0x005d:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0149
            com.meizu.media.camera.mode.h r0 = r8.f10667z
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            r0.mo22162g((boolean) r13)
            com.meizu.media.camera.mode.h r0 = r8.f10667z
            r0.mo18053al(r12)
            goto L_0x0149
        L_0x0075:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0149
            com.meizu.media.camera.mode.h r0 = r8.f10667z
            r0.mo18053al(r13)
            goto L_0x0149
        L_0x0084:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0149
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.EventBus.m21789a()
            r1 = 11
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.mo27980d(r1)
            goto L_0x0149
        L_0x009b:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_BURST_CAPTURE_FINISHED
            boolean r0 = r0.equals(r9)
            r1 = 5
            r2 = 4
            if (r0 == 0) goto L_0x0105
            int r0 = r10.length
            if (r0 >= r11) goto L_0x00c8
            r0 = r10[r12]
            if (r0 == 0) goto L_0x00b5
            r0 = r10[r12]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            r1 = r10[r13]
            if (r1 == 0) goto L_0x00c2
            r1 = r10[r13]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
        L_0x00c2:
            r1 = 0
            r15.mo20498a((byte[]) r1, (int) r0, (int) r12)
            goto L_0x0149
        L_0x00c8:
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
            r0.m11153a(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0149
        L_0x0105:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_LAST_BURST_CAPTURE_FINISHED
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0149
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
            r0.m11153a(r1, r2, r3, r4, r5, r6, r7)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BackTraceMode.mo18014a(com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.util.Contants$CameraService$ResultCode, java.lang.Object[]):void");
    }

    /* renamed from: b */
    public UUID mo18056b() {
        return this.f10649d;
    }

    /* renamed from: c */
    public SurfaceTexture mo18119c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4604, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : mo20539R().mo18119c();
    }

    /* renamed from: f */
    public SurfaceTexture mo18236f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4605, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : mo20539R().mo18236f();
    }

    /* renamed from: d */
    public boolean mo18176d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4606, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo20539R().mo18176d();
    }

    /* renamed from: com.meizu.media.camera.mode.c$a */
    /* compiled from: BackTraceMode */
    private static class C2168a {

        /* renamed from: a */
        long f10696a;

        /* renamed from: b */
        int f10697b;

        /* renamed from: c */
        boolean f10698c;

        /* renamed from: d */
        int f10699d;

        private C2168a() {
        }
    }

    public BackTraceMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        CameraOptTask.m7840a((CamIntentTask.C1777c) this);
        m11146O();
        if (mo20539R().mo18267u() != null && this.f10787i.getIntent() == null) {
            this.f10665x = mo20539R().mo18267u().mo22059V();
        }
        this.f10667z = hVar;
        this.f10645A = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: a */
    public static boolean m11156a(Intent intent, ContentResolver contentResolver) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent, contentResolver}, (Object) null, f10643a, true, 4607, new Class[]{Intent.class, ContentResolver.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!CameraModeType.ModeType.BACK_TRACE.toString().equals(intent.getStringExtra("lab_camera_mode_type")) || 1 != Settings.Global.getInt(contentResolver, "enable_back_trace_mode", 0)) {
            return false;
        }
        return true;
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4608, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f10665x == null) {
                this.f10665x = mo20539R().mo18267u().mo22059V();
            }
            this.f10665x.mo21988a();
            this.f10665x.mo21991b();
            m11143L();
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10643a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4609, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            m11143L();
        }
    }

    /* renamed from: L */
    private void m11143L() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4610, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21571c();
            this.f10788j.mo21506a(516);
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                this.f10788j.mo21592g((int) MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY);
            } else {
                this.f10788j.mo21592g(206);
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4611, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            if (this.f10665x == null) {
                this.f10665x = mo20539R().mo18267u().mo22059V();
            }
            this.f10665x.mo21988a();
            m11143L();
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.BACK_TRACE;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4612, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10644b, "release");
            if (this.f10665x != null) {
                this.f10665x.mo21994e();
            }
            this.f10788j.mo21578d();
            CameraOptTask.m7842b((CamIntentTask.C1777c) this);
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10668a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f10668a, false, 4631, new Class[0], Void.TYPE).isSupported) {
                        Iterator it = BackTraceMode.this.f10653l.iterator();
                        while (it.hasNext()) {
                            ((File) it.next()).delete();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4613, new Class[0], Void.TYPE).isSupported) {
            if (this.f10665x != null) {
                this.f10665x.mo21993d();
            }
            if (this.f10647C != null && this.f10647C.mo22613c() == AsyncTaskEx.Status.RUNNING) {
                LogUtil.m15952c(f10644b, "cancel mCaptureAsyncTask");
                this.f10647C.mo22612b(true);
                this.f10647C = null;
            }
            if (this.f10650e && DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                this.f10788j.mo21597h(2);
                AsyncTaskEx.f13741o.execute(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10670a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f10670a, false, 4632, new Class[0], Void.TYPE).isSupported) {
                            new File(Storage.m7750a().mo18657h() + '/' + BackTraceMode.this.f10657p).delete();
                        }
                    }
                });
                mo20499q();
                this.f10650e = false;
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4614, new Class[0], Void.TYPE).isSupported) {
            m11146O();
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4615, new Class[0], Void.TYPE).isSupported && this.f10665x != null) {
            this.f10665x.mo21992c();
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4616, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f10665x.mo21992c();
        return false;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10643a, false, 4617, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.m15942a(f10644b, "capture");
        this.f10650e = true;
        this.f10665x.mo21989a(this.f10650e);
        this.f10788j.mo21631s();
        this.f10647C = new AsyncTaskEx<Void, Void, Void>() {

            /* renamed from: a */
            public static ChangeQuickRedirect f10672a;

            /* renamed from: a */
            public Void mo17658a(Void... voidArr) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10672a, false, 4633, new Class[]{Void[].class}, Void.class);
                if (proxy.isSupported) {
                    return (Void) proxy.result;
                }
                BackTraceMode.this.f10652g.clear();
                String unused = BackTraceMode.this.f10657p = CameraUtil.m15883c(System.currentTimeMillis());
                Storage.m7750a().mo18668m(BackTraceMode.this.f10657p);
                CameraController.m8868g().mo19479a(BackTraceMode.this.f10655n);
                LogUtil.m15942a(BackTraceMode.f10644b, "capture doInBackground done");
                BackTraceMode.this.mo20500r();
                return null;
            }

            /* renamed from: a */
            public void mo17660a(Void voidR) {
                if (!PatchProxy.proxy(new Object[]{voidR}, this, f10672a, false, 4634, new Class[]{Void.class}, Void.TYPE).isSupported) {
                    super.mo17660a(voidR);
                    if (!mo22615d()) {
                        int unused = BackTraceMode.this.f10658q = CameraUtil.m15882c(CameraController.m8868g().mo19522k().mo19733b(), BackTraceMode.this.mo20539R().mo18194dR());
                        BackTraceMode.this.mo20541T().mo20322a(true);
                        CameraController.m8868g().mo19490b(BackTraceMode.this.f10658q, new boolean[0]);
                        if (DeviceHelper.f13840T) {
                            BackTraceMode.this.mo20541T().mo20320a(MzCamParamsManager.f10481f, true);
                        } else {
                            BackTraceMode.this.mo20541T().mo20320a(MzCamParamsManager.f10481f, new Object[0]);
                        }
                        BackTraceMode.this.m11145N();
                        Location unused2 = BackTraceMode.this.f10664w = BackTraceMode.this.mo20539R().mo18192dP().mo19017a(System.currentTimeMillis());
                        CameraController.m8868g().mo19455a(BackTraceMode.this.f10664w, new boolean[0]);
                        BackTraceMode.this.mo20539R().mo17914ak().mo20220e(true);
                        BackTraceMode.this.mo20541T().mo20350o();
                        CameraController.m8868g().mo19480a(new boolean[0]);
                        CameraController.m8868g().mo19465a(CameraController.BurstCaptureState.IDLE);
                        LogUtil.m15942a(BackTraceMode.f10644b, "capture sendCommend");
                        CameraOptTask.m8349a((Context) BackTraceMode.this.f10787i, CameraOptTask.m8402f(BackTraceMode.this.f10787i.getApplicationContext(), BackTraceMode.this.mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_BACKTRACE_PICTURE));
                    }
                }
            }
        }.mo22614c((Params[]) new Void[0]);
        this.f10788j.mo21597h(0);
        return true;
    }

    /* renamed from: a */
    public void mo20498a(byte[] bArr, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f10643a, false, 4618, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f10644b, "flag：" + i2 + " data:" + bArr);
            if (!this.f10650e) {
                LogUtil.m15942a(f10644b, "mCapturing is false, return ");
                return;
            }
            if (m11155a(i2, 1)) {
                LogUtil.m15942a(f10644b, "BURST_ENCODING_FLAG");
                this.f10648c++;
                if (this.f10648c >= DeviceHelper.f13940bn) {
                    mo20499q();
                }
                if (this.f10651f != null) {
                    C2168a aVar = new C2168a();
                    aVar.f10696a = System.currentTimeMillis();
                    this.f10651f.add(aVar);
                }
            }
            if (m11155a(i2, 2)) {
                LogUtil.m15942a(f10644b, "BURST_WRITE_FILE_FLAG");
                if (this.f10651f != null && this.f10651f.size() != 0) {
                    if (!this.f10659r) {
                        this.f10659r = true;
                    }
                    if (DeviceHelper.f13841U) {
                        i = (-16777216 & i) >> 24;
                    }
                    boolean a = m11155a(i2, 8);
                    if (m11155a(i2, 4)) {
                        LogUtil.m15949b(f10644b, "burst callback, delete a failed image   isLast:" + a);
                        this.f10653l.get(i - 1).delete();
                        if (a) {
                            this.f10660s = true;
                            return;
                        }
                        return;
                    }
                    C2168a aVar2 = this.f10651f.get(i - 1);
                    aVar2.f10699d = i;
                    aVar2.f10698c = a;
                    m11152a(aVar2);
                    if (a) {
                        LogUtil.m15952c(f10644b, "BURST_WRITE_FILE_FLAG,last-image-saved message arrive.");
                    }
                }
            } else if (m11155a(i2, 16)) {
                LogUtil.m15952c(f10644b, "BURST_END_FLAG");
            }
        }
    }

    /* renamed from: a */
    private void m11153a(Boolean bool, BurstData hVar, int i, int i2, int i3, boolean z, boolean z2) {
        Boolean bool2;
        if (!PatchProxy.proxy(new Object[]{bool, hVar, new Integer(i), new Integer(i2), new Integer(i3), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10643a, false, 4619, new Class[]{Boolean.class, BurstData.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!this.f10650e) {
                LogUtil.m15942a(f10644b, "mCapturing is false, return ");
                return;
            }
            this.f10648c++;
            if (this.f10648c >= DeviceHelper.f13940bn) {
                this.f10650e = false;
                bool2 = true;
            } else {
                bool2 = bool;
            }
            if (!this.f10659r) {
                this.f10659r = true;
            }
            m11154a(bool2, hVar.mo22728a(), System.currentTimeMillis(), this.f10658q, i, i2, i3, z, this.f10648c, z2);
            if (bool2.booleanValue()) {
                LogUtil.m15952c(f10644b, "BURST_WRITE_FILE_FLAG,last-image-saved message arrive.");
                this.f10660s = true;
                mo20499q();
            }
        }
    }

    /* renamed from: a */
    private void m11154a(Boolean bool, byte[] bArr, long j, int i, int i2, int i3, int i4, boolean z, int i5, boolean z2) {
        String a;
        String b;
        int i6;
        int i7;
        File file;
        String str;
        long j2 = j;
        int i8 = i5;
        int i9 = i2;
        int i10 = i3;
        if (!PatchProxy.proxy(new Object[]{bool, bArr, new Long(j2), new Integer(i), new Integer(i9), new Integer(i10), new Integer(i4), new Byte(z ? (byte) 1 : 0), new Integer(i8), new Byte(z2 ? (byte) 1 : 0)}, this, f10643a, false, 4620, new Class[]{Boolean.class, byte[].class, Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!f10642D.contains(Integer.valueOf(i8 - 1))) {
                LogUtil.C2630a aVar = f10644b;
                LogUtil.m15942a(aVar, "index:" + i8 + "  delete");
                return;
            }
            if (i8 != 1) {
                a = CameraUtil.m15832a(j2, this.f10648c);
            } else {
                a = CameraUtil.m15831a(j);
            }
            String str2 = a;
            if (i8 != 1) {
                b = Storage.m7750a().mo18645c(str2, this.f10657p);
            } else {
                b = Storage.m7750a().mo18639b(str2, this.f10657p);
                this.f10663v = b;
            }
            String str3 = b;
            File file2 = new File(str3);
            this.f10654m.add(file2.getAbsolutePath());
            if (this.f10658q == 90 || this.f10658q == 270) {
                i7 = i10;
                i6 = i9;
            } else {
                i6 = i10;
                i7 = i9;
            }
            if (i8 == 1) {
                file = file2;
                str = str3;
                this.f10652g.add(Storage.m7750a().mo18635b(j, this.f10657p, str2, 0, -1, i7, i6, this.f10664w));
            } else {
                file = file2;
                str = str3;
            }
            final boolean z3 = z;
            final byte[] bArr2 = bArr;
            final String str4 = str;
            final long j3 = j;
            final int i11 = i2;
            final int i12 = i3;
            final int i13 = i4;
            final boolean z4 = z2;
            final int i14 = i5;
            final File file3 = file;
            final Boolean bool2 = bool;
            new AsyncTaskEx<Void, Void, Uri>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10674a;

                /* renamed from: a */
                public Uri mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10674a, false, 4635, new Class[]{Void[].class}, Uri.class);
                    if (proxy.isSupported) {
                        return (Uri) proxy.result;
                    }
                    if (z3) {
                        Storage.m7750a().mo18631a(str4, Exif.m10044a(bArr2), bArr2);
                    } else {
                        ExifInterface cVar = new ExifInterface();
                        cVar.mo19876e();
                        cVar.mo19883o(0);
                        cVar.mo19858a(ExifInterface.f9408u, j3, TimeZone.getDefault());
                        Storage.m7750a().mo18632a(str4, cVar, bArr2, i11, i12, i13, BackTraceMode.this.f10658q, z4, (Boolean) false);
                    }
                    LogUtil.C2630a B = BackTraceMode.f10644b;
                    LogUtil.m15942a(B, "start setAttribute number:" + i14);
                    try {
                        androidx.exifinterface.media.ExifInterface exifInterface = new androidx.exifinterface.media.ExifInterface(file3.getAbsolutePath());
                        exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, CameraModeType.ModeType.BACK_TRACE.toString());
                        exifInterface.saveAttributes();
                        LogUtil.C2630a B2 = BackTraceMode.f10644b;
                        LogUtil.m15942a(B2, "end setAttribute i.number:" + i14);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (!bool2.booleanValue()) {
                        return null;
                    }
                    if (BackTraceMode.this.f10787i != null) {
                        return Storage.m7750a().mo18618a(BackTraceMode.this.f10787i.getContentResolver(), (ArrayList<ContentValues>) BackTraceMode.this.f10652g);
                    }
                    LogUtil.m15942a(BackTraceMode.f10644b, "activity is destroyed, abort insert!!!");
                    return null;
                }

                /* renamed from: a */
                public void mo17660a(Uri uri) {
                    if (!PatchProxy.proxy(new Object[]{uri}, this, f10674a, false, 4636, new Class[]{Uri.class}, Void.TYPE).isSupported && uri != null) {
                        int ceil = (int) Math.ceil(((double) BackTraceMode.this.f10661t) / ((double) CameraUtil.m15903i()));
                        if (!BackTraceMode.this.mo20539R().mo18200dX()) {
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17846a(BackTraceMode.this.f10663v, Integer.highestOneBit(ceil), 0, (byte[]) null);
                            LogUtil.C2630a B = BackTraceMode.f10644b;
                            LogUtil.m15942a(B, "uri:" + uri);
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17844a(uri);
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17845a(BackTraceMode.this.f10663v);
                            BackTraceMode.this.mo20539R().mo18275x(3);
                            BackTraceMode.this.mo20542U().mo21614m(false);
                        } else if (BackTraceMode.this.f10787i == null) {
                            LogUtil.m15942a(BackTraceMode.f10644b, "activity is destroyed, abort capture!!!");
                            return;
                        } else {
                            BackTraceMode.this.f10787i.mo17673b(uri);
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17844a((Uri) null);
                        }
                        boolean unused = BackTraceMode.this.f10660s = true;
                        BackTraceMode.this.m11144M();
                    }
                }
            }.mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: q */
    public void mo20499q() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4621, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10644b;
            LogUtil.m15942a(aVar, "endBurst mBurstCount:" + this.f10648c);
            if (this.f10650e) {
                this.f10648c = 0;
                mo20539R().mo17914ak().mo20220e(false);
                this.f10665x.mo21989a(this.f10650e);
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    CameraOptTask.m8349a((Context) this.f10787i, CameraOptTask.m8404g(this.f10787i, this.f10649d, Contants.CameraService.RequestCode.REQUEST_CODE_STOP_BURST));
                    if (DeviceHelper.f13840T) {
                        mo20541T().mo20320a(MzCamParamsManager.f10481f, false);
                    } else {
                        mo20541T().mo20320a(MzCamParamsManager.f10478c, new Object[0]);
                    }
                    CameraController.m8868g().mo19480a(new boolean[0]);
                }
            }
        }
    }

    /* renamed from: a */
    private void m11152a(C2168a aVar) {
        String a;
        String b;
        C2168a aVar2 = aVar;
        if (!PatchProxy.proxy(new Object[]{aVar2}, this, f10643a, false, 4622, new Class[]{C2168a.class}, Void.TYPE).isSupported) {
            if (aVar2.f10699d != 1) {
                a = CameraUtil.m15832a(aVar2.f10696a, aVar2.f10699d);
            } else {
                a = CameraUtil.m15831a(aVar2.f10696a);
            }
            String str = a;
            if (aVar2.f10699d != 1) {
                b = Storage.m7750a().mo18645c(str, this.f10657p);
            } else {
                b = Storage.m7750a().mo18639b(str, this.f10657p);
                this.f10663v = b;
            }
            final String str2 = b;
            final File file = new File(str2);
            int i = this.f10661t;
            int i2 = this.f10662u;
            if (((this.f10658q / 90) & 1) == 1) {
                i = this.f10662u;
                i2 = this.f10661t;
            }
            int i3 = i;
            int i4 = i2;
            if (aVar2.f10699d == 1) {
                this.f10652g.add(Storage.m7750a().mo18635b(aVar2.f10696a, this.f10657p, str, 0, aVar2.f10697b, i3, i4, this.f10664w));
            }
            final C2168a aVar3 = aVar;
            new AsyncTaskEx<Void, Void, Uri>(0) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10687a;

                /* renamed from: a */
                public Uri mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10687a, false, 4637, new Class[]{Void[].class}, Uri.class);
                    if (proxy.isSupported) {
                        return (Uri) proxy.result;
                    }
                    if (!((File) BackTraceMode.this.f10653l.get(aVar3.f10699d - 1)).renameTo(file)) {
                        LogUtil.C2630a B = BackTraceMode.f10644b;
                        LogUtil.m15942a(B, "BurstPicture filePath is wrong! filePath:" + str2);
                    }
                    BackTraceMode.this.f10654m.add(file.getAbsolutePath());
                    if (!BackTraceMode.f10642D.contains(Integer.valueOf(aVar3.f10699d - 1))) {
                        boolean delete = file.delete();
                        LogUtil.C2630a B2 = BackTraceMode.f10644b;
                        LogUtil.m15942a(B2, "index:" + (aVar3.f10699d - 1) + "  delete:" + delete);
                    } else {
                        LogUtil.C2630a B3 = BackTraceMode.f10644b;
                        LogUtil.m15942a(B3, "start setAttribute i.number:" + aVar3.f10699d);
                        try {
                            androidx.exifinterface.media.ExifInterface exifInterface = new androidx.exifinterface.media.ExifInterface(file.getAbsolutePath());
                            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, CameraModeType.ModeType.BACK_TRACE.toString());
                            exifInterface.saveAttributes();
                            LogUtil.C2630a B4 = BackTraceMode.f10644b;
                            LogUtil.m15942a(B4, "end setAttribute i.number:" + aVar3.f10699d);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (aVar3.f10699d != 1) {
                        return null;
                    }
                    Uri unused = BackTraceMode.this.f10666y = Storage.m7750a().mo18618a(BackTraceMode.this.f10787i.getContentResolver(), (ArrayList<ContentValues>) BackTraceMode.this.f10652g);
                    return BackTraceMode.this.f10666y;
                }

                /* renamed from: a */
                public void mo17660a(Uri uri) {
                    if (!PatchProxy.proxy(new Object[]{uri}, this, f10687a, false, 4638, new Class[]{Uri.class}, Void.TYPE).isSupported && aVar3.f10698c) {
                        int ceil = (int) Math.ceil(((double) BackTraceMode.this.f10661t) / ((double) CameraUtil.m15903i()));
                        if (!BackTraceMode.this.mo20539R().mo18200dX()) {
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17846a(BackTraceMode.this.f10663v, Integer.highestOneBit(ceil), 0, (byte[]) null);
                            LogUtil.C2630a B = BackTraceMode.f10644b;
                            LogUtil.m15942a(B, "mBurstFinishUri:" + BackTraceMode.this.f10666y);
                            if (BackTraceMode.this.f10666y != null) {
                                BackTraceMode.this.mo20539R().mo18193dQ().mo17844a(BackTraceMode.this.f10666y);
                            }
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17845a(BackTraceMode.this.f10663v);
                            BackTraceMode.this.mo20539R().mo18275x(3);
                            BackTraceMode.this.mo20542U().mo21614m(false);
                        } else if (BackTraceMode.this.f10787i == null) {
                            LogUtil.m15942a(BackTraceMode.f10644b, "activity is destroyed, abort capture!!!");
                            return;
                        } else {
                            BackTraceMode.this.f10787i.mo17673b(BackTraceMode.this.f10666y);
                            BackTraceMode.this.mo20539R().mo18193dQ().mo17844a((Uri) null);
                        }
                        boolean unused = BackTraceMode.this.f10660s = true;
                        BackTraceMode.this.m11144M();
                    }
                }
            }.mo22614c((Params[]) new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m11144M() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4623, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10644b;
            LogUtil.m15952c(aVar, "onBurstFinish(),, mIsAppDone = " + this.f10660s);
            if (this.f10660s) {
                this.f10648c = 0;
                this.f10659r = false;
                this.f10650e = false;
                this.f10665x.mo21989a(this.f10650e);
                this.f10788j.mo21597h(2);
                this.f10788j.mo21634t();
                this.f10787i.mo17669a(Storage.m7750a().mo18662j(this.f10657p));
                m11146O();
                mo20541T().mo20322a(false);
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    mo20539R().mo18256p();
                    CameraOptTask.m8349a((Context) this.f10787i, CameraOptTask.m8345a((Context) this.f10787i, false, CameraModeType.ModeType.BACK_TRACE, this.f10649d, Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_BACKTRACE_PREVIEW));
                    return;
                }
                mo20539R().mo18122c(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m11145N() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4624, new Class[0], Void.TYPE).isSupported) {
            boolean z = true;
            if (!DeviceHelper.f13872aY || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                z = false;
            }
            if (z) {
                Point j = CameraController.m8868g().mo19520j();
                if (j != null) {
                    this.f10661t = j.x;
                    this.f10662u = j.y;
                    return;
                }
                return;
            }
            int i = DeviceHelper.f13919bS;
            int i2 = DeviceHelper.f13920bT;
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                CameraController.m8868g().mo19500c(i, i2, new boolean[0]);
                this.f10661t = i;
                this.f10662u = i2;
            }
        }
    }

    /* renamed from: r */
    public void mo20500r() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4625, new Class[0], Void.TYPE).isSupported) {
            try {
                if (this.f10656o != null) {
                    for (int i = 0; i < this.f10656o.length; i++) {
                        if (this.f10656o[i] != null) {
                            this.f10656o[i].close();
                        }
                    }
                    this.f10656o = null;
                }
            } catch (IOException unused) {
                LogUtil.m15952c(f10644b, "close burst file stream failed");
            }
        }
    }

    /* renamed from: y */
    public String mo20422y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4626, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        m11145N();
        String str = this.f10661t + "x" + this.f10662u;
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            return str;
        }
        if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
            return CameraSizeUtil.m16182d("4 : 3");
        }
        return DeviceHelper.f13919bS + "x" + DeviceHelper.f13920bT;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10643a, false, 4627, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (mo20539R().mo18211di() == 1) {
            return CameraController.FocusMode.AUTO;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: O */
    private void m11146O() {
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4628, new Class[0], Void.TYPE).isSupported) {
            if (this.f10651f == null) {
                this.f10651f = new CopyOnWriteArrayList<>();
            } else {
                this.f10651f.clear();
            }
            if (this.f10653l == null) {
                this.f10653l = new ArrayList<>();
            } else {
                this.f10653l.clear();
            }
            if (this.f10654m == null) {
                this.f10654m = new ArrayList<>();
            } else {
                this.f10654m.clear();
            }
            this.f10655n = new FileDescriptor[DeviceHelper.f13940bn];
            this.f10656o = new FileOutputStream[DeviceHelper.f13940bn];
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10693a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    boolean z;
                    int i = 0;
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10693a, false, 4639, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    Storage.m7750a().mo18679u();
                    while (true) {
                        if (i >= DeviceHelper.f13940bn) {
                            break;
                        }
                        try {
                            String str = "." + i;
                            File file = new File(Storage.m7750a().mo18639b(str, (String) null) + ".tmp");
                            if (file.exists()) {
                                z = true;
                            } else {
                                z = file.createNewFile();
                                if (!z) {
                                    z = file.createNewFile();
                                }
                            }
                            if (BackTraceMode.this.f10653l == null) {
                                LogUtil.m15949b(BackTraceMode.f10644b, "mBurstFiles is null, break!");
                                break;
                            }
                            if (z) {
                                BackTraceMode.this.f10653l.add(file);
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                BackTraceMode.this.f10656o[i] = fileOutputStream;
                                BackTraceMode.this.f10655n[i] = fileOutputStream.getFD();
                            } else {
                                LogUtil.m15949b(BackTraceMode.f10644b, "burstCapture(), create file failed !!!");
                            }
                            i++;
                        } catch (IOException e) {
                            LogUtil.m15949b(BackTraceMode.f10644b, "create capture file fail " + e);
                        }
                    }
                    return null;
                }
            }.mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f10643a, false, 4629, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = this.f10645A.mo22688a(new String[]{"mode", "is_back_camera", "location", "voice", "meshline", "level", "capture_type", "mirror", "sd_card"});
            a.put("capture_time", Long.toString(this.f10667z.mo18186dJ()));
            a.put("face_num", Integer.toString(this.f10667z.mo18267u().mo22055R()));
            String str = "error mode";
            if (!(this.f10667z.mo17914ak() == null || (ak = this.f10667z.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str = h.getKey();
            }
            a.put("focus_mode", str);
            this.f10645A.mo22693a("capture_info", a);
        }
    }

    /* renamed from: a */
    public Point[] mo18021a(Bitmap bitmap) {
        return new Point[0];
    }
}
