package com.meizu.media.camera.simplify;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.p020ar.base.MsgField;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.Thumbnail;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzSlowMotionUI;
import com.meizu.media.camera.p077ui.MzTimeLapseUI;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.MzTimeLapseRender;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.simplify.n */
public class SimplifyVideoMode extends SimplifyCameraMode implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener, MzTimeLapseRender.C2752a {

    /* renamed from: Z */
    private static final int[] f12107Z = {500, 1000, MsgField.IMSG_SAVE_PICTURE, 4000, 8000};

    /* renamed from: a */
    public static ChangeQuickRedirect f12108a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final LogUtil.C2630a f12109f = new LogUtil.C2630a("VideoMode");

    /* renamed from: A */
    private MzCamcorderProfileManager f12110A;

    /* renamed from: B */
    private int f12111B;

    /* renamed from: C */
    private Object f12112C;

    /* renamed from: D */
    private boolean f12113D;

    /* renamed from: E */
    private long f12114E;

    /* renamed from: F */
    private long f12115F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f12116G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f12117H;

    /* renamed from: I */
    private int f12118I;

    /* renamed from: J */
    private int f12119J;

    /* renamed from: K */
    private boolean f12120K;

    /* renamed from: L */
    private boolean f12121L;

    /* renamed from: M */
    private long f12122M;

    /* renamed from: N */
    private boolean f12123N;

    /* renamed from: O */
    private boolean f12124O;

    /* renamed from: P */
    private int f12125P;

    /* renamed from: Q */
    private MzSlowMotionUI f12126Q;

    /* renamed from: R */
    private MzSimplifyVideoUI f12127R;

    /* renamed from: S */
    private MzTimeLapseUI f12128S;

    /* renamed from: T */
    private int f12129T;

    /* renamed from: U */
    private boolean f12130U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public MzSimplifyCamModule f12131V;

    /* renamed from: W */
    private long f12132W;

    /* renamed from: X */
    private boolean f12133X;

    /* renamed from: Y */
    private boolean f12134Y;

    /* renamed from: aa */
    private int f12135aa;

    /* renamed from: ab */
    private Runnable f12136ab;

    /* renamed from: ac */
    private final MediaSaveService.C1639d f12137ac;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CameraSimplifyActivity f12138g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MzSimplifyUIController f12139h;

    /* renamed from: i */
    private MzSimplifyCamUI f12140i;

    /* renamed from: j */
    private Handler f12141j;

    /* renamed from: k */
    private ContentResolver f12142k;

    /* renamed from: l */
    private MzSimplifyCamParamsManager f12143l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C2361a f12144m;

    /* renamed from: n */
    private boolean f12145n;

    /* renamed from: o */
    private MediaRecorder f12146o;

    /* renamed from: p */
    private Surface f12147p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f12148q;

    /* renamed from: r */
    private long f12149r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f12150s;

    /* renamed from: t */
    private boolean f12151t;

    /* renamed from: u */
    private String f12152u;

    /* renamed from: v */
    private ParcelFileDescriptor f12153v;

    /* renamed from: w */
    private String f12154w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Uri f12155x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f12156y;

    /* renamed from: z */
    private ContentValues f12157z;

    /* renamed from: ap */
    private void m13480ap() {
    }

    /* renamed from: e */
    private String m13499e(int i) {
        return i == 2 ? "video/mp4" : "video/3gpp";
    }

    /* renamed from: f */
    private String m13503f(int i) {
        return i == 2 ? ".mp4" : ".3gp";
    }

    /* renamed from: M */
    public boolean mo21380M() {
        return false;
    }

    /* renamed from: N */
    public boolean mo21381N() {
        return false;
    }

    /* renamed from: h */
    public boolean mo21356h() {
        return false;
    }

    /* renamed from: i */
    public boolean mo21357i() {
        return false;
    }

    /* renamed from: j */
    public boolean mo21358j() {
        return false;
    }

    /* renamed from: m */
    public String mo21361m() {
        return "1920x1080";
    }

    /* renamed from: o */
    public int mo21363o() {
        return 0;
    }

    private SimplifyVideoMode(CameraSimplifyActivity cameraSimplifyActivity, MzSimplifyCamParamsManager cVar, MzSimplifyUIController jVar, MzSimplifyCamModule mzSimplifyCamModule, CameraModeType.ModeType modeType) {
        super(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType);
        this.f12144m = new C2361a();
        this.f12148q = false;
        this.f12151t = false;
        this.f12112C = new Object();
        this.f12122M = 0;
        this.f12130U = false;
        this.f12132W = -1;
        this.f12133X = false;
        this.f12134Y = false;
        this.f12135aa = f12107Z[0];
        this.f12136ab = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f12158a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f12158a, false, 6207, new Class[0], Void.TYPE).isSupported) {
                    long unused = SimplifyVideoMode.this.f12150s = System.currentTimeMillis();
                    SimplifyVideoMode.this.m13487aw();
                }
            }
        };
        this.f12137ac = new MediaSaveService.C1639d() {

            /* renamed from: a */
            public static ChangeQuickRedirect f12160a;

            /* renamed from: a */
            public void mo17846a(String str, int i, int i2, byte[] bArr) {
            }

            /* renamed from: a */
            public void mo17847a(List<String> list) {
            }

            /* renamed from: a */
            public void mo17844a(Uri uri) {
                if (!PatchProxy.proxy(new Object[]{uri}, this, f12160a, false, 6208, new Class[]{Uri.class}, Void.TYPE).isSupported && uri != null) {
                    Uri unused = SimplifyVideoMode.this.f12155x = uri;
                    boolean unused2 = SimplifyVideoMode.this.f12156y = true;
                    SimplifyVideoMode.this.mo21409X();
                    SimplifyVideoMode.this.f12138g.mo17745a(uri);
                }
            }

            /* renamed from: a */
            public void mo17845a(String str) {
                if (!PatchProxy.proxy(new Object[]{str}, this, f12160a, false, 6209, new Class[]{String.class}, Void.TYPE).isSupported) {
                    SimplifyVideoMode.this.f12138g.mo17746a(str, true);
                }
            }
        };
        this.f12138g = cameraSimplifyActivity;
        this.f12143l = cVar;
        this.f12140i = mzSimplifyCamModule.mo18443ar();
        this.f12142k = mzSimplifyCamModule.mo18445at();
        this.f12139h = jVar;
        this.f12131V = mzSimplifyCamModule;
        this.f12141j = mzSimplifyCamModule.mo18434ai();
        this.f12145n = m13461a(this.f12138g.getIntent().getAction());
        if (this.f12145n) {
            m13466aE();
        }
        if (DeviceHelper.f13844X) {
            m13511i(true);
            if (!this.f12144m.hasMessages(5)) {
                this.f12144m.sendEmptyMessage(5);
            }
        }
        this.f12110A = new MzCamcorderProfileManager();
    }

    public SimplifyVideoMode(CameraSimplifyActivity cameraSimplifyActivity, MzSimplifyCamParamsManager cVar, MzSimplifyUIController jVar, MzSimplifyCamModule mzSimplifyCamModule, CameraModeType.ModeType modeType, boolean z, boolean z2) {
        this(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType);
        this.f12123N = z;
        this.f12134Y = z2;
        this.f12143l.mo21110a(true, this.f12123N, this.f12134Y);
        m13475ak();
        if (this.f12139h != null && this.f12140i != null) {
            m13468ad();
        }
    }

    /* renamed from: a */
    public void mo21348a(MzSimplifyUIController jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f12108a, false, 6132, new Class[]{MzSimplifyUIController.class}, Void.TYPE).isSupported) {
            super.mo21348a(jVar);
            this.f12140i = this.f12131V.mo18443ar();
            this.f12139h = jVar;
        }
    }

    /* renamed from: ad */
    private void m13468ad() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6133, new Class[0], Void.TYPE).isSupported && this.f12140i != null) {
            this.f12127R = this.f12140i.mo21140B();
            this.f12127R.mo21339a(this.f12139h);
        }
    }

    /* renamed from: a */
    public void mo21412a() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6134, new Class[0], Void.TYPE).isSupported) {
            if (this.f12123N) {
                this.f12139h.mo20912c(5);
                this.f12139h.mo20954l(76);
            } else if (this.f12134Y) {
                this.f12139h.mo20912c(132);
                this.f12139h.mo20954l(131140);
            } else if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                this.f12139h.mo20912c(MzUIController.f12282d);
                this.f12139h.mo20954l(131660);
            } else {
                this.f12139h.mo20912c(MzUIController.f12283e);
                this.f12139h.mo20954l(131660);
            }
            mo21404x().mo20937g(true);
            mo21404x().mo20958m(this.f12123N);
            mo21404x().mo20961n(this.f12134Y);
            m13498d(false);
            mo21404x().mo20971q(-1);
        }
    }

    /* renamed from: d */
    private void m13498d(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12108a, false, 6135, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12162a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f12162a, false, 6210, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    CameraController.m8868g().mo19475a(z);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.simplify.n$a */
    /* compiled from: SimplifyVideoMode */
    private class C2361a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f12170a;

        private C2361a() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f12170a, false, 6213, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        SimplifyVideoMode.this.mo21408W();
                        return;
                    case 2:
                        SimplifyVideoMode.this.m13485au();
                        return;
                    case 3:
                        SimplifyVideoMode.this.m13486av();
                        return;
                    case 4:
                        SimplifyVideoMode.this.m13469ae();
                        return;
                    case 5:
                        if (DeviceHelper.f13844X && SimplifyVideoMode.this.f12138g != null && !SimplifyVideoMode.this.f12138g.mo17752n()) {
                            LogUtil.m15942a(SimplifyVideoMode.f12109f, "video record, force execute gc");
                            System.runFinalization();
                            System.gc();
                            SimplifyVideoMode.this.f12144m.removeMessages(5);
                            SimplifyVideoMode.this.f12144m.sendEmptyMessageDelayed(5, 5000);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: B */
    public void mo21407B() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6136, new Class[0], Void.TYPE).isSupported) {
            m13474aj();
            this.f12139h.mo20986x();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ae */
    public void m13469ae() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6137, new Class[0], Void.TYPE).isSupported) {
            m13474aj();
            m13470af();
            if (DeviceHelper.f13860aM) {
                this.f12131V.mo18438am().mo21075e();
            }
            this.f12131V.mo18438am().mo21097t();
        }
    }

    /* renamed from: af */
    private void m13470af() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6138, new Class[0], Void.TYPE).isSupported) {
            mo21415b(true);
            if (DeviceHelper.f13839S) {
                if (DeviceHelper.f13849aB) {
                    return;
                }
                if (this.f12139h.mo20977s()) {
                    mo21416c(false);
                    this.f12131V.mo18449ax();
                    this.f12131V.mo18479i(false);
                    return;
                }
                this.f12131V.mo18479i(false);
                mo21416c(false);
            } else if (DeviceHelper.f13841U) {
                mo21416c(false);
            } else {
                mo21416c(false);
            }
        }
    }

    /* renamed from: U */
    public List<Surface> mo21388U() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12108a, false, 6139, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (this.f12140i != null && this.f12140i.mo21225z() != null && this.f12140i.mo21225z().mo21291e()) {
            return null;
        }
        if (this.f12146o == null || this.f12147p == null || !this.f12147p.isValid()) {
            this.f12150s = System.currentTimeMillis();
            synchronized (this.f12112C) {
                m13501e(true);
            }
        }
        LogUtil.C2630a aVar = f12109f;
        LogUtil.m15942a(aVar, "getPreviewSurfaces: mMediaRecorder = " + this.f12146o + ", mIsMediaRecorderPrepare = " + this.f12133X + ", mMediaSurface = " + this.f12147p);
        if (this.f12146o == null || !this.f12133X || this.f12147p == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f12147p);
        return arrayList;
    }

    /* renamed from: ag */
    private void m13471ag() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6140, new Class[0], Void.TYPE).isSupported) {
            String[] strArr = new String[6];
            strArr[0] = "mode";
            strArr[1] = (this.f12134Y || this.f12123N) ? "" : "is_back_camera";
            strArr[2] = "location";
            strArr[3] = "meshline";
            strArr[4] = "level";
            strArr[5] = "sd_card";
            Map<String, String> a = UsageStatsHelper.m16042a(mo21402v().getApplicationContext()).mo22688a(strArr);
            a.put("capture_time", Long.toString(this.f12150s));
            a.put("torch", CameraController.m8868g().mo19534q().key);
            if (!this.f12123N && !this.f12134Y) {
                a.put("video_size", m13493b(this.f12131V.mo18437al().getString("pref_video_quality_key", (String) null)));
            }
            if (this.f12134Y) {
                a.put("time_lapse", String.valueOf(this.f12135aa));
            }
            a.put("video_length", Long.toString(System.currentTimeMillis() - this.f12150s));
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f14029du ? "1" : "0");
            }
            UsageStatsHelper.m16042a(this.f12138g.getApplicationContext()).mo22693a("capture_info", a);
        }
    }

    /* renamed from: t */
    public void mo21368t() {
        String str;
        FocusOverlaySimplifyManager am;
        CameraController.FocusMode g;
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6141, new Class[0], Void.TYPE).isSupported) {
            String[] strArr = new String[6];
            strArr[0] = "mode";
            strArr[1] = (this.f12134Y || this.f12123N) ? "" : "is_back_camera";
            strArr[2] = "location";
            strArr[3] = "meshline";
            strArr[4] = "level";
            strArr[5] = "sd_card";
            Map<String, String> a = UsageStatsHelper.m16042a(mo21402v().getApplicationContext()).mo22688a(strArr);
            a.put("capture_time", Long.toString(this.f12150s));
            a.put("torch", CameraController.m8868g().mo19534q().key);
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f12131V.mo18438am() == null || (am = this.f12131V.mo18438am()) == null || (g = am.mo21079g()) == null)) {
                str2 = g.getKey();
            }
            a.put("focus_mode", str2);
            a.put("video_length", Long.toString(System.currentTimeMillis() - this.f12150s));
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f14029du ? "1" : "0");
            }
            UsageStatsHelper.m16042a(this.f12138g.getApplicationContext()).mo22693a("capture_info", a);
        }
    }

    /* renamed from: b */
    private String m13493b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12108a, false, 6142, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if ((DeviceHelper.f13871aX && String.valueOf(DeviceHelper.f13957cD).equals(str)) || String.valueOf(4).equals(str)) {
            return "480P";
        }
        if (String.valueOf(DeviceHelper.f14004cy).equals(str)) {
            return "4k";
        }
        return (!String.valueOf(5).equals(str) && String.valueOf(6).equals(str)) ? "1080P" : "720P";
    }

    /* renamed from: K */
    public void mo21378K() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6144, new Class[0], Void.TYPE).isSupported) {
            boolean z = this.f12148q;
            if (z) {
                this.f12141j.postDelayed(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f12165a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f12165a, false, 6211, new Class[0], Void.TYPE).isSupported) {
                            SimplifyVideoMode.this.m13469ae();
                        }
                    }
                }, 0);
            } else {
                this.f12131V.mo18430ae();
                if (this.f12131V.mo18431af() <= 105906176) {
                    LogUtil.m15952c(f12109f, "Storage issue, ignore the start request");
                    return;
                }
                this.f12138g.mo17765q();
                mo21416c(true);
                this.f12148q = true;
                mo21415b(false);
                m13475ak();
                if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.ARCSOFT) {
                    m13504f(true);
                    this.f12141j.postDelayed(this.f12136ab, 150);
                } else if (this.f12138g.mo17767s()) {
                    this.f12141j.postDelayed(this.f12136ab, 60);
                } else {
                    this.f12150s = System.currentTimeMillis();
                    m13487aw();
                }
            }
            if (!this.f12145n || !z) {
                this.f12141j.sendEmptyMessageDelayed(12, 500);
            }
        }
    }

    /* renamed from: L */
    public void mo21379L() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6145, new Class[0], Void.TYPE).isSupported && this.f12146o != null) {
            if (this.f12113D) {
                this.f12114E = (this.f12114E + SystemClock.uptimeMillis()) - this.f12115F;
                m13473ai();
                mo21408W();
                UsageStatsHelper.m16042a(this.f12138g.getApplicationContext()).mo22695b("click_resume_recording");
            } else {
                this.f12115F = SystemClock.uptimeMillis();
                m13472ah();
                UsageStatsHelper.m16042a(this.f12138g.getApplicationContext()).mo22695b("click_pause_recording");
            }
            this.f12139h.mo20949j(this.f12113D);
        }
    }

    /* renamed from: ah */
    private void m13472ah() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6146, new Class[0], Void.TYPE).isSupported) {
            this.f12113D = true;
            try {
                C2634am.m15993a((Object) this.f12146o, "pause", (Class<?>[]) null, (Object[]) null);
            } catch (Exception unused) {
                LogUtil.m15949b(f12109f, "invoke exception pause()");
            }
        }
    }

    /* renamed from: ai */
    private void m13473ai() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6147, new Class[0], Void.TYPE).isSupported) {
            this.f12113D = false;
            try {
                C2634am.m15993a((Object) this.f12146o, "resume", (Class<?>[]) null, (Object[]) null);
            } catch (Exception unused) {
                LogUtil.m15949b(f12109f, "invoke exception resume()");
            }
        }
    }

    /* renamed from: W */
    public void mo21408W() {
        long j;
        String str;
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6148, new Class[0], Void.TYPE).isSupported && this.f12148q && !this.f12113D) {
            long uptimeMillis = (SystemClock.uptimeMillis() - this.f12149r) - this.f12114E;
            long max = (this.f12111B != 0 && (uptimeMillis > ((long) (this.f12111B - 60000)) ? 1 : (uptimeMillis == ((long) (this.f12111B - 60000)) ? 0 : -1)) >= 0) || this.f12123N ? Math.max(0, ((long) this.f12111B) - uptimeMillis) + 999 : uptimeMillis;
            if (this.f12123N) {
                this.f12126Q.mo22599a(m13457a(max - 999));
            } else {
                if (this.f12134Y) {
                    str = CameraUtil.m15833a(m13491b(uptimeMillis), true);
                } else {
                    str = CameraUtil.m15833a(max, false);
                }
                if (this.f12127R != null) {
                    this.f12127R.mo21340a(str);
                }
            }
            if (this.f12134Y) {
                j = (long) this.f12135aa;
            } else {
                j = this.f12123N ? 100 : 1000;
            }
            long j2 = j - (uptimeMillis % j);
            if (!DeviceHelper.f13840T || !this.f12123N || max - 999 > 0 || !this.f12148q) {
                this.f12144m.sendEmptyMessageDelayed(1, j2);
            } else {
                this.f12144m.sendEmptyMessage(4);
            }
        }
    }

    /* renamed from: a */
    private String m13457a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6149, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        long j2 = j / 1000;
        long j3 = j2 - ((j2 / 60) * 60);
        StringBuilder sb = new StringBuilder();
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3);
        sb.append(".");
        long j4 = (j - (j2 * 1000)) / 10;
        if (j4 < 10) {
            sb.append('0');
        }
        sb.append(j4);
        return sb.toString();
    }

    /* renamed from: g */
    private void m13505g(int i) {
        String str;
        File file;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12108a, false, 6150, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            long j = this.f12150s;
            if (this.f12132W == -1) {
                this.f12132W = j;
                mo21401u().mo18381a(this.f12132W);
            }
            String a = Storage.m7750a().mo18620a((Context) this.f12138g, j);
            String str2 = a + m13503f(i);
            String e = m13499e(i);
            if (this.f12121L) {
                file = new File(Storage.m7750a().mo18663k());
                str = Storage.m7750a().mo18658h(str2);
            } else {
                file = new File(Storage.m7750a().mo18665l());
                str = Storage.m7750a().mo18660i(str2);
                this.f12130U = Storage.m7750a().mo18682x();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = str + ".tmp";
            this.f12157z = new ContentValues(12);
            this.f12157z.put(PushConstants.TITLE, a);
            this.f12157z.put("_display_name", str2);
            this.f12157z.put("datetaken", Long.valueOf(j));
            this.f12157z.put("date_modified", Long.valueOf(j / 1000));
            this.f12157z.put("mime_type", e);
            this.f12157z.put("_data", str);
            this.f12157z.put("resolution", Integer.toString(this.f12110A.mo20363b()) + "x" + Integer.toString(this.f12110A.mo20364c()));
            int c = this.f12131V.mo18432ag() != -1 ? CameraUtil.m15882c(this.f12131V.mo18440ao(), this.f12131V.mo18432ag()) : 0;
            this.f12157z.put("width", Integer.valueOf(this.f12110A.mo20363b()));
            this.f12157z.put("height", Integer.valueOf(this.f12110A.mo20364c()));
            LogUtil.m15942a(f12109f, "generateVideoFilename: width = " + this.f12157z.get("width") + ", height = " + this.f12157z.get("height"));
            if (((c / 90) & 1) == 1) {
                this.f12157z.put(MtkMediaStore.VideoColumns.ORIENTATION, 90);
            } else {
                this.f12157z.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            }
            Location a2 = this.f12131V.mo18433ah().mo19017a(this.f12150s);
            if (a2 != null) {
                this.f12157z.put(Parameters.LATITUDE, Double.valueOf(a2.getLatitude()));
                this.f12157z.put(Parameters.LONGITUDE, Double.valueOf(a2.getLongitude()));
            }
            this.f12152u = str3;
            LogUtil.m15952c(f12109f, "New video filename: " + this.f12152u);
        }
    }

    /* renamed from: aj */
    private void m13474aj() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6151, new Class[0], Void.TYPE).isSupported) {
            m13471ag();
            boolean ay = m13489ay();
            if (!this.f12145n) {
                if (!ay) {
                    if (!this.f12131V.mo18200dX()) {
                        boolean z = ApiHelper.f14205f;
                    }
                    if (!this.f12116G || !this.f12117H) {
                        this.f12139h.mo20914c((int) R.string.mz_recording_save, true);
                    }
                }
                if (this.f12123N) {
                    if (this.f12126Q != null) {
                        this.f12126Q.mo22599a("60.00");
                    }
                } else if (!this.f12134Y && this.f12127R != null) {
                    this.f12127R.mo21340a("00:00:00");
                }
            } else if (!ay) {
                m13490az();
            }
        }
    }

    /* renamed from: X */
    public void mo21409X() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6152, new Class[0], Void.TYPE).isSupported && !this.f12145n) {
            this.f12139h.mo20861a(this.f12155x);
        }
    }

    /* renamed from: ak */
    private void m13475ak() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6153, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12109f, "readVideoPreferences start");
            String a = CameraSizeDefault.m16166a(this.f12131V.mo18440ao());
            int intValue = Integer.valueOf(a).intValue();
            Intent intent = this.f12138g.getIntent();
            boolean z = true;
            if (intent.hasExtra("android.intent.extra.videoQuality") && !DeviceHelper.f13838R) {
                intValue = intent.getIntExtra("android.intent.extra.videoQuality", 0) > 0 ? 1 : 0;
            }
            if (intent.hasExtra("android.intent.extra.durationLimit")) {
                this.f12111B = intent.getIntExtra("android.intent.extra.durationLimit", 0) * 1000;
            } else {
                this.f12111B = CameraSettings.m9776a((Context) this.f12138g);
            }
            this.f12124O = false;
            if (intValue == DeviceHelper.f14004cy) {
                this.f12124O = true;
            }
            if (DeviceHelper.f13838R && this.f12131V.mo18410aF() && DeviceHelper.f13841U && (this.f12124O || intValue == 6)) {
                intValue = 5;
                this.f12124O = false;
                LogUtil.m15952c(f12109f, "MX4 Pro Video Filter Change to 720P!!!");
            }
            if (this.f12122M == 0 || this.f12122M > 276480) {
                z = false;
            }
            if (z && !this.f12121L) {
                intValue = 2;
                this.f12124O = false;
                LogUtil.m15952c(f12109f, "MMS Record Change to QCIF!!!");
            }
            if (this.f12123N) {
                intValue = DeviceHelper.f13954cA;
                this.f12124O = false;
                this.f12111B = 60000;
            }
            if (this.f12134Y) {
                intValue = 1006;
                this.f12124O = false;
            }
            this.f12110A.mo20361a(this.f12131V.mo18440ao(), intValue);
            String str = this.f12110A.mo20363b() + "x" + this.f12110A.mo20364c();
            LogUtil.m15952c(f12109f, "videoSize: " + str);
            SharedPreferences.Editor edit = this.f12131V.mo18437al().edit();
            String valueOf = String.valueOf(intValue);
            if (!valueOf.equals(a) && !this.f12123N && !this.f12134Y) {
                edit.putString("pref_video_quality_key", valueOf);
            }
            edit.putString("pref_camera_videosize_key", str);
            edit.apply();
            m13476al();
            LogUtil.m15952c(f12109f, "readVideoPreferences end");
        }
    }

    @TargetApi(11)
    /* renamed from: al */
    private void m13476al() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6154, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null) {
            if (this.f12110A.mo20363b() == -1 || this.f12110A.mo20364c() == -1) {
                Point l = CameraController.m8868g().mo19524l();
                if (l != null) {
                    this.f12118I = l.x;
                    this.f12119J = l.y;
                }
            } else {
                this.f12118I = this.f12110A.mo20363b();
                this.f12119J = this.f12110A.mo20364c();
            }
            LogUtil.C2630a aVar = f12109f;
            LogUtil.m15952c(aVar, "previewWidth=" + this.f12118I + " previewHeight=" + this.f12119J);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0224 A[Catch:{ Exception -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0225 A[Catch:{ Exception -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0254 A[Catch:{ Exception -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0255 A[Catch:{ Exception -> 0x0267 }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13501e(boolean r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r12)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f12108a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 6155(0x180b, float:8.625E-42)
            r2 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.util.ac$a r1 = f12109f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "initializeRecorder "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 != 0) goto L_0x0043
            return
        L_0x0043:
            com.meizu.media.camera.CameraSimplifyActivity r1 = r11.f12138g
            android.content.Intent r1 = r1.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r11.m13483as()
            r11.f12156y = r8
            boolean r2 = r11.f12145n
            if (r2 == 0) goto L_0x0091
            if (r1 == 0) goto L_0x0091
            java.lang.String r2 = "output"
            android.os.Parcelable r2 = r1.getParcelable(r2)
            android.net.Uri r2 = (android.net.Uri) r2
            boolean r3 = r11.f12120K
            if (r3 == 0) goto L_0x006c
            java.lang.String r2 = "output_video"
            android.os.Parcelable r2 = r1.getParcelable(r2)
            android.net.Uri r2 = (android.net.Uri) r2
        L_0x006c:
            if (r2 == 0) goto L_0x0085
            android.content.ContentResolver r3 = r11.f12142k     // Catch:{ FileNotFoundException -> 0x007b }
            java.lang.String r4 = "rw"
            android.os.ParcelFileDescriptor r3 = r3.openFileDescriptor(r2, r4)     // Catch:{ FileNotFoundException -> 0x007b }
            r11.f12153v = r3     // Catch:{ FileNotFoundException -> 0x007b }
            r11.f12155x = r2     // Catch:{ FileNotFoundException -> 0x007b }
            goto L_0x0085
        L_0x007b:
            r2 = move-exception
            com.meizu.media.camera.util.ac$a r3 = f12109f
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r2)
        L_0x0085:
            boolean r2 = r11.f12120K
            if (r2 == 0) goto L_0x0091
            java.lang.String r2 = "meizu_video_record_max_size"
            long r1 = r1.getLong(r2)
            r11.f12122M = r1
        L_0x0091:
            if (r12 == 0) goto L_0x009a
            android.media.MediaRecorder r1 = new android.media.MediaRecorder
            r1.<init>()
            r11.f12146o = r1
        L_0x009a:
            android.media.MediaRecorder r1 = r11.f12146o
            if (r1 != 0) goto L_0x00a6
            com.meizu.media.camera.util.ac$a r12 = f12109f
            java.lang.String r0 = "MediaRecorder has been release."
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r0)
            return
        L_0x00a6:
            com.meizu.media.camera.MzSimplifyCamModule r1 = r11.f12131V
            com.meizu.media.camera.e r1 = r1.mo18437al()
            java.lang.String r2 = "pref_video_quality_key"
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r1.intValue()
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ee
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            boolean r2 = r11.f12123N
            r1.mo19458a((android.view.Surface) r3, (boolean) r2)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            com.meizu.media.camera.camcontroller.e r1 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r1
            android.media.MediaRecorder r2 = r11.f12146o
            java.lang.Object r1 = r1.mo19730a()
            android.hardware.Camera r1 = (android.hardware.Camera) r1
            r2.setCamera(r1)
            android.media.MediaRecorder r1 = r11.f12146o
            r1.setVideoSource(r0)
            goto L_0x0104
        L_0x00ee:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0104
            android.media.MediaRecorder r1 = r11.f12146o
            r2 = 2
            r1.setVideoSource(r2)
        L_0x0104:
            boolean r1 = r11.f12123N
            r2 = 5
            if (r1 == 0) goto L_0x0169
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            int r4 = r4.mo20366e()
            r1.setOutputFormat(r4)
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            int r4 = r4.mo20365d()
            r1.setVideoFrameRate(r4)
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            int r4 = r4.mo20363b()
            com.meizu.media.camera.m r5 = r11.f12110A
            int r5 = r5.mo20364c()
            r1.setVideoSize(r4, r5)
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            int r4 = r4.mo20367f()
            r1.setVideoEncodingBitRate(r4)
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            int r4 = r4.mo20368g()
            r1.setVideoEncoder(r4)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 != 0) goto L_0x014e
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14053w
            if (r1 == 0) goto L_0x0195
        L_0x014e:
            com.meizu.media.camera.simplify.c r1 = r11.f12143l
            java.lang.String r1 = r1.mo21135q()
            if (r1 == 0) goto L_0x0195
            java.lang.String r4 = "off"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0195
            android.media.MediaRecorder r4 = r11.f12146o
            int r1 = java.lang.Integer.parseInt(r1)
            double r5 = (double) r1
            r4.setCaptureRate(r5)
            goto L_0x0195
        L_0x0169:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13841U
            if (r1 == 0) goto L_0x0171
            boolean r1 = r11.f12124O
            if (r1 != 0) goto L_0x0179
        L_0x0171:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x0181
            boolean r1 = r11.f12124O
            if (r1 == 0) goto L_0x0181
        L_0x0179:
            com.meizu.media.camera.m r1 = r11.f12110A
            android.media.MediaRecorder r4 = r11.f12146o
            r1.mo20362a(r4)
            goto L_0x0195
        L_0x0181:
            boolean r1 = r11.f12134Y
            if (r1 != 0) goto L_0x018a
            android.media.MediaRecorder r1 = r11.f12146o
            r1.setAudioSource(r2)
        L_0x018a:
            android.media.MediaRecorder r1 = r11.f12146o
            com.meizu.media.camera.m r4 = r11.f12110A
            android.media.CamcorderProfile r4 = r4.mo20360a()
            r1.setProfile(r4)
        L_0x0195:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x019d
            boolean r1 = r11.f12123N
            if (r1 != 0) goto L_0x01a4
        L_0x019d:
            android.media.MediaRecorder r1 = r11.f12146o
            int r4 = r11.f12111B
            r1.setMaxDuration(r4)
        L_0x01a4:
            boolean r1 = r11.f12134Y
            if (r1 == 0) goto L_0x01ce
            com.meizu.media.camera.util.ac$a r1 = f12109f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "TimeLapseCaptureMs = "
            r4.append(r5)
            int r5 = r11.f12135aa
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r4)
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r1 = r11.f12135aa
            double r6 = (double) r1
            double r4 = r4 / r6
            android.media.MediaRecorder r1 = r11.f12146o
            r1.setCaptureRate(r4)
        L_0x01ce:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x026f
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13893at     // Catch:{ Exception -> 0x0267 }
            if (r1 == 0) goto L_0x01f5
            android.media.MediaRecorder r1 = r11.f12146o     // Catch:{ Exception -> 0x0267 }
            java.lang.String r4 = "setParametersEx"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0267 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r8] = r6     // Catch:{ Exception -> 0x0267 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0267 }
            java.lang.String r7 = "enable-highspl-effect=1"
            r6[r8] = r7     // Catch:{ Exception -> 0x0267 }
            com.meizu.media.camera.util.C2634am.m15993a((java.lang.Object) r1, (java.lang.String) r4, (java.lang.Class<?>[]) r5, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x0267 }
        L_0x01f5:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13862aO     // Catch:{ Exception -> 0x0267 }
            if (r1 == 0) goto L_0x026f
            com.meizu.media.camera.m r1 = r11.f12110A     // Catch:{ Exception -> 0x0267 }
            int r1 = r1.mo20369h()     // Catch:{ Exception -> 0x0267 }
            if (r1 == r2) goto L_0x020d
            com.meizu.media.camera.m r1 = r11.f12110A     // Catch:{ Exception -> 0x0267 }
            int r1 = r1.mo20369h()     // Catch:{ Exception -> 0x0267 }
            r4 = 6
            if (r1 != r4) goto L_0x020b
            goto L_0x020d
        L_0x020b:
            r1 = 0
            goto L_0x020e
        L_0x020d:
            r1 = 1
        L_0x020e:
            com.meizu.media.camera.util.ac$a r4 = f12109f     // Catch:{ Exception -> 0x0267 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0267 }
            r5.<init>()     // Catch:{ Exception -> 0x0267 }
            java.lang.String r6 = "set mmf-camera-vdis="
            r5.append(r6)     // Catch:{ Exception -> 0x0267 }
            boolean r6 = r11.f12134Y     // Catch:{ Exception -> 0x0267 }
            if (r6 != 0) goto L_0x0228
            boolean r6 = r11.f12123N     // Catch:{ Exception -> 0x0267 }
            if (r6 != 0) goto L_0x0228
            if (r1 != 0) goto L_0x0225
            goto L_0x0228
        L_0x0225:
            java.lang.String r6 = "on"
            goto L_0x022a
        L_0x0228:
            java.lang.String r6 = "off"
        L_0x022a:
            r5.append(r6)     // Catch:{ Exception -> 0x0267 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0267 }
            com.meizu.media.camera.util.LogUtil.m15952c(r4, r5)     // Catch:{ Exception -> 0x0267 }
            android.media.MediaRecorder r4 = r11.f12146o     // Catch:{ Exception -> 0x0267 }
            java.lang.String r5 = "setParametersEx"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0267 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r8] = r7     // Catch:{ Exception -> 0x0267 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0267 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0267 }
            r9.<init>()     // Catch:{ Exception -> 0x0267 }
            java.lang.String r10 = "mmf-camera-vdis="
            r9.append(r10)     // Catch:{ Exception -> 0x0267 }
            boolean r10 = r11.f12134Y     // Catch:{ Exception -> 0x0267 }
            if (r10 != 0) goto L_0x0258
            boolean r10 = r11.f12123N     // Catch:{ Exception -> 0x0267 }
            if (r10 != 0) goto L_0x0258
            if (r1 != 0) goto L_0x0255
            goto L_0x0258
        L_0x0255:
            java.lang.String r1 = "on"
            goto L_0x025a
        L_0x0258:
            java.lang.String r1 = "off"
        L_0x025a:
            r9.append(r1)     // Catch:{ Exception -> 0x0267 }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0267 }
            r7[r8] = r1     // Catch:{ Exception -> 0x0267 }
            com.meizu.media.camera.util.C2634am.m15993a((java.lang.Object) r4, (java.lang.String) r5, (java.lang.Class<?>[]) r6, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x0267 }
            goto L_0x026f
        L_0x0267:
            r1 = move-exception
            com.meizu.media.camera.util.ac$a r4 = f12109f
            java.lang.String r5 = "MediaRecorder setParametersEx failed! "
            com.meizu.media.camera.util.LogUtil.m15953c(r4, r5, r1)
        L_0x026f:
            r11.m13477am()
            android.os.ParcelFileDescriptor r1 = r11.f12153v
            if (r1 == 0) goto L_0x0282
            android.media.MediaRecorder r1 = r11.f12146o
            android.os.ParcelFileDescriptor r4 = r11.f12153v
            java.io.FileDescriptor r4 = r4.getFileDescriptor()
            r1.setOutputFile(r4)
            goto L_0x0292
        L_0x0282:
            com.meizu.media.camera.m r1 = r11.f12110A
            int r1 = r1.mo20366e()
            r11.m13505g((int) r1)
            android.media.MediaRecorder r1 = r11.f12146o
            java.lang.String r4 = r11.f12152u
            r1.setOutputFile(r4)
        L_0x0292:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02bb
            r1 = 23
            if (r12 == 0) goto L_0x02b0
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r1) goto L_0x02b0
            android.view.Surface r12 = android.media.MediaCodec.createPersistentInputSurface()
            r11.f12147p = r12
        L_0x02b0:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r1) goto L_0x02bb
            android.media.MediaRecorder r12 = r11.f12146o
            android.view.Surface r1 = r11.f12147p
            r12.setInputSurface(r1)
        L_0x02bb:
            com.meizu.media.camera.MzSimplifyCamModule r12 = r11.f12131V
            long r4 = r12.mo18431af()
            r6 = 105906176(0x6500000, double:5.2324603E-316)
            long r4 = r4 - r6
            int r12 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            r6 = 4294967296(0x100000000, double:2.121995791E-314)
            r9 = 0
            if (r12 < r1) goto L_0x02de
            long r6 = r11.f12122M
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x02da
            r12 = 1
            goto L_0x02db
        L_0x02da:
            r12 = 0
        L_0x02db:
            r11.f12117H = r12
            goto L_0x02ee
        L_0x02de:
            r11.f12117H = r8
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x02e6
            r4 = r6
            goto L_0x02ee
        L_0x02e6:
            long r6 = r11.f12122M
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x02ee
            r11.f12117H = r0
        L_0x02ee:
            long r6 = r11.f12122M
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x02fc
            long r6 = r11.f12122M
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x02fc
            long r4 = r11.f12122M
        L_0x02fc:
            android.media.MediaRecorder r12 = r11.f12146o     // Catch:{ RuntimeException -> 0x0301 }
            r12.setMaxFileSize(r4)     // Catch:{ RuntimeException -> 0x0301 }
        L_0x0301:
            com.meizu.media.camera.MzSimplifyCamModule r12 = r11.f12131V
            int r12 = r12.mo18432ag()
            r1 = -1
            if (r12 == r1) goto L_0x031b
            com.meizu.media.camera.MzSimplifyCamModule r12 = r11.f12131V
            int r12 = r12.mo18440ao()
            com.meizu.media.camera.MzSimplifyCamModule r1 = r11.f12131V
            int r1 = r1.mo18432ag()
            int r12 = com.meizu.media.camera.util.CameraUtil.m15882c((int) r12, (int) r1)
            goto L_0x031c
        L_0x031b:
            r12 = 0
        L_0x031c:
            android.media.MediaRecorder r1 = r11.f12146o
            r1.setOrientationHint(r12)
            com.meizu.media.camera.util.ac$a r12 = f12109f     // Catch:{ IOException -> 0x0337 }
            java.lang.String r1 = "mediaRecorder.prepare() start"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r1)     // Catch:{ IOException -> 0x0337 }
            android.media.MediaRecorder r12 = r11.f12146o     // Catch:{ IOException -> 0x0337 }
            r12.prepare()     // Catch:{ IOException -> 0x0337 }
            r11.f12133X = r0     // Catch:{ IOException -> 0x0337 }
            com.meizu.media.camera.util.ac$a r12 = f12109f     // Catch:{ IOException -> 0x0337 }
            java.lang.String r1 = "mediaRecorder.prepare() finish"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r1)     // Catch:{ IOException -> 0x0337 }
            goto L_0x035e
        L_0x0337:
            r12 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f12109f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "prepare failed for "
            r4.append(r5)
            java.lang.String r5 = r11.f12152u
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15950b(r1, r4, r12)
            int r1 = r11.f12129T
            int r1 = r1 + r0
            r11.f12129T = r1
            int r0 = r11.f12129T
            if (r0 >= r2) goto L_0x036b
            r11.m13458a((android.view.Surface) r3)
            r11.f12133X = r8
        L_0x035e:
            r11.f12129T = r8
            android.media.MediaRecorder r12 = r11.f12146o
            r12.setOnErrorListener(r11)
            android.media.MediaRecorder r12 = r11.f12146o
            r12.setOnInfoListener(r11)
            return
        L_0x036b:
            r11.m13482ar()
            r11.f12129T = r8
            android.media.MediaRecorder r0 = r11.f12146o
            r0.release()
            android.view.Surface r0 = r11.f12147p
            r0.release()
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "MediaRecorder.prepare() more than 5 times!!!"
            r0.<init>(r1, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.SimplifyVideoMode.m13501e(boolean):void");
    }

    /* renamed from: am */
    private void m13477am() {
        Location a;
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6156, new Class[0], Void.TYPE).isSupported && (a = this.f12131V.mo18433ah().mo19017a(this.f12150s)) != null) {
            this.f12146o.setLocation((float) a.getLatitude(), (float) a.getLongitude());
        }
    }

    /* renamed from: an */
    private void m13478an() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6157, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12109f, "Releasing media recorder.");
            synchronized (this.f12112C) {
                if (this.f12146o != null) {
                    m13482ar();
                    this.f12146o.reset();
                    this.f12146o.release();
                    this.f12146o = null;
                }
                this.f12152u = null;
            }
        }
    }

    /* renamed from: ao */
    private void m13479ao() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6158, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12109f, "reset media recorder.");
            if (this.f12146o != null) {
                m13482ar();
                this.f12146o.reset();
            }
            this.f12152u = null;
        }
    }

    /* renamed from: aq */
    private void m13481aq() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6159, new Class[0], Void.TYPE).isSupported) {
            m13504f(false);
        }
    }

    /* renamed from: f */
    private void m13504f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6160, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) || !DeviceHelper.f13862aO) {
            return;
        }
        if ((this.f12110A.mo20369h() == 5 || this.f12110A.mo20369h() == 6) && !this.f12123N) {
            CameraController.m8868g().mo19503c(z);
        }
    }

    /* renamed from: a */
    private void m13458a(Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f12108a, false, 6161, new Class[]{Surface.class}, Void.TYPE).isSupported) {
            m13479ao();
            this.f12150s = System.currentTimeMillis();
            m13501e(false);
            CameraController.m8868g().mo19458a(surface, this.f12123N);
        }
    }

    /* renamed from: ar */
    private void m13482ar() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6162, new Class[0], Void.TYPE).isSupported && this.f12152u != null) {
            File file = new File(this.f12152u);
            if (file.length() == 0 && file.delete()) {
                LogUtil.C2630a aVar = f12109f;
                LogUtil.m15952c(aVar, "Empty video file deleted: " + this.f12152u);
                this.f12152u = null;
            }
        }
    }

    /* renamed from: as */
    private void m13483as() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6163, new Class[0], Void.TYPE).isSupported && this.f12153v != null) {
            try {
                this.f12153v.close();
            } catch (IOException e) {
                LogUtil.m15950b(f12109f, "Fail to close fd", e);
            }
            this.f12153v = null;
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        Object[] objArr = {mediaRecorder, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6164, new Class[]{MediaRecorder.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12109f;
            LogUtil.m15949b(aVar, "MediaRecorder error. what=" + i + ". extra=" + i2);
            if (i == 1) {
                m13489ay();
                this.f12131V.mo18429ad();
            }
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, final int i, int i2) {
        Object[] objArr = {mediaRecorder, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6165, new Class[]{MediaRecorder.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f12138g != null) {
            this.f12138g.runOnUiThread(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12167a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f12167a, false, 6212, new Class[0], Void.TYPE).isSupported) {
                        if (i == 800) {
                            LogUtil.m15952c(SimplifyVideoMode.f12109f, "media recoder reached max duration");
                            if (SimplifyVideoMode.this.f12148q) {
                                SimplifyVideoMode.this.m13469ae();
                            }
                        } else if (i == 801) {
                            LogUtil.m15952c(SimplifyVideoMode.f12109f, "media recoder reached max size");
                            if (SimplifyVideoMode.this.f12148q) {
                                SimplifyVideoMode.this.m13469ae();
                            }
                            int i = R.string.video_reach_size_limit;
                            if (!SimplifyVideoMode.this.f12117H) {
                                boolean unused = SimplifyVideoMode.this.f12116G = true;
                            }
                            if (SimplifyVideoMode.this.f12117H) {
                                i = R.string.mz_space_is_low;
                                SimplifyVideoMode.this.f12131V.mo18429ad();
                            }
                            SimplifyVideoMode.this.f12139h.mo20914c(i, false);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: at */
    private boolean m13484at() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12108a, false, 6166, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12145n || SystemClock.uptimeMillis() - this.f12149r >= 500) {
            return true;
        }
        if (!TextUtils.isEmpty(this.f12152u)) {
            m13496c(this.f12152u);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: au */
    public void m13485au() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6167, new Class[0], Void.TYPE).isSupported) {
            if (CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
                return;
            }
            if (DeviceHelper.f13860aM) {
                this.f12131V.mo18438am().mo21075e();
            } else {
                this.f12131V.mo18438am().mo21093p();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: av */
    public void m13486av() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6168, new Class[0], Void.TYPE).isSupported) {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f12154w)) {
                bitmap = Thumbnail.m7941a(this.f12154w, this.f12118I, new long[0]);
            }
            if (bitmap != null) {
                bitmap = CameraUtil.m15872b(bitmap, 0, false);
            }
            this.f12139h.mo20858a(bitmap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aw */
    public void m13487aw() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6169, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f12109f, "startVideoRecording");
            if (DeviceHelper.f13838R && this.f12148q) {
                this.f12131V.mo18468e(1);
            }
            this.f12155x = null;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                m13501e(true);
            } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                m13458a(this.f12147p);
            }
            if (this.f12146o == null) {
                this.f12148q = false;
                LogUtil.m15949b(f12109f, "Fail to initialize media recorder");
                return;
            }
            mo21404x().mo20897as();
            try {
                LogUtil.m15952c(LogUtil.f14072b, "startVideoRecording");
                this.f12146o.start();
                this.f12148q = true;
                this.f12139h.mo20910b(this.f12148q, this.f12124O);
                this.f12140i.mo21211o(this.f12148q);
                this.f12131V.mo18438am().mo21088k(true);
                this.f12116G = false;
                this.f12149r = SystemClock.uptimeMillis();
                this.f12114E = 0;
                if (this.f12134Y) {
                    this.f12128S.mo21792b();
                } else if (!this.f12123N) {
                    this.f12127R.mo21341a(true);
                }
                this.f12139h.mo20872a(true, m13488ax());
                this.f12131V.mo18438am().mo21084i(true);
                mo21408W();
                m13464aC();
            } catch (RuntimeException e) {
                LogUtil.m15950b(f12109f, "Could not start media recorder. ", e);
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    m13478an();
                    CameraController.m8868g().mo19441E();
                } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                    m13458a((Surface) null);
                }
                if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.ARCSOFT) {
                    m13504f(false);
                }
                if ("already exists".equals(e.getMessage())) {
                    LogUtil.m15949b(f12109f, "Record device is occupied.");
                    this.f12139h.mo20914c((int) R.string.mz_record_device_occupied, false);
                }
                mo21404x().mo20898at();
                m13470af();
                this.f12148q = false;
            }
        }
    }

    /* renamed from: ax */
    private boolean m13488ax() {
        boolean z = DeviceHelper.f13838R;
        if (!DeviceHelper.f13838R || !DeviceHelper.f13841U) {
            return z;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0173  */
    /* renamed from: ay */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m13489ay() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f12108a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 6170(0x181a, float:8.646E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x001e
            java.lang.Object r0 = r1.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x001e:
            com.meizu.media.camera.util.ac$a r1 = f12109f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "stopVideoRecording mPaused:"
            r2.append(r3)
            com.meizu.media.camera.MzSimplifyCamModule r3 = r8.f12131V
            boolean r3 = r3.mo18200dX()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            boolean r1 = r8.f12148q
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0157
            android.os.Handler r1 = r8.f12141j
            java.lang.Runnable r4 = r8.f12136ab
            r1.removeCallbacks(r4)
            com.meizu.media.camera.simplify.j r1 = r8.mo21404x()
            r1.mo20898at()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r4) goto L_0x0067
            boolean r1 = r8.f12123N
            if (r1 != 0) goto L_0x0067
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraControllerV2 r1 = (com.meizu.media.camera.camcontroller.CameraControllerV2) r1
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x0067
            r1.mo19565ag()
        L_0x0067:
            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.util.LogUtil.f14072b     // Catch:{ RuntimeException -> 0x009f }
            java.lang.String r4 = "stopVideoRecording"
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r4)     // Catch:{ RuntimeException -> 0x009f }
            android.media.MediaRecorder r1 = r8.f12146o     // Catch:{ RuntimeException -> 0x009f }
            r1.setOnErrorListener(r3)     // Catch:{ RuntimeException -> 0x009f }
            android.media.MediaRecorder r1 = r8.f12146o     // Catch:{ RuntimeException -> 0x009f }
            r1.setOnInfoListener(r3)     // Catch:{ RuntimeException -> 0x009f }
            android.media.MediaRecorder r1 = r8.f12146o     // Catch:{ RuntimeException -> 0x009f }
            r1.stop()     // Catch:{ RuntimeException -> 0x009f }
            java.lang.String r1 = r8.f12152u     // Catch:{ RuntimeException -> 0x009c }
            r8.f12154w = r1     // Catch:{ RuntimeException -> 0x009c }
            com.meizu.media.camera.util.ac$a r1 = f12109f     // Catch:{ RuntimeException -> 0x009c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x009c }
            r4.<init>()     // Catch:{ RuntimeException -> 0x009c }
            java.lang.String r5 = "stopVideoRecording: Setting current video filename: "
            r4.append(r5)     // Catch:{ RuntimeException -> 0x009c }
            java.lang.String r5 = r8.f12154w     // Catch:{ RuntimeException -> 0x009c }
            r4.append(r5)     // Catch:{ RuntimeException -> 0x009c }
            java.lang.String r4 = r4.toString()     // Catch:{ RuntimeException -> 0x009c }
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r4)     // Catch:{ RuntimeException -> 0x009c }
            r1 = 0
            r4 = 1
            goto L_0x00b2
        L_0x009c:
            r1 = move-exception
            r4 = 1
            goto L_0x00a1
        L_0x009f:
            r1 = move-exception
            r4 = 0
        L_0x00a1:
            com.meizu.media.camera.util.ac$a r5 = f12109f
            java.lang.String r6 = "stop fail"
            com.meizu.media.camera.util.LogUtil.m15950b(r5, r6, r1)
            java.lang.String r1 = r8.f12152u
            if (r1 == 0) goto L_0x00b1
            java.lang.String r1 = r8.f12152u
            r8.m13496c((java.lang.String) r1)
        L_0x00b1:
            r1 = 1
        L_0x00b2:
            com.meizu.media.camera.MzSimplifyCamModule r5 = r8.f12131V
            boolean r5 = r5.mo18200dX()
            if (r5 == 0) goto L_0x00c2
            r8.m13481aq()
            com.meizu.media.camera.MzSimplifyCamModule r5 = r8.f12131V
            r5.mo18482k()
        L_0x00c2:
            com.meizu.media.camera.util.DeviceHelper$EIS_TYPE r5 = com.meizu.media.camera.util.DeviceHelper.f14018dj
            com.meizu.media.camera.util.DeviceHelper$EIS_TYPE r6 = com.meizu.media.camera.util.DeviceHelper.EIS_TYPE.ARCSOFT
            if (r5 != r6) goto L_0x00cb
            r8.m13504f((boolean) r0)
        L_0x00cb:
            com.meizu.media.camera.CameraSimplifyActivity r5 = r8.f12138g
            r5.mo17766r()
            r8.f12148q = r0
            boolean r5 = com.meizu.media.camera.util.DeviceHelper.f13936bj
            if (r5 == 0) goto L_0x00f7
            boolean r5 = r8.f12130U
            if (r5 == 0) goto L_0x00ed
            boolean r5 = r8.f12130U
            com.meizu.media.camera.Storage r6 = com.meizu.media.camera.Storage.m7750a()
            boolean r6 = r6.mo18682x()
            if (r5 == r6) goto L_0x00ed
            com.meizu.media.camera.simplify.j r4 = r8.f12139h
            r4.mo20858a((android.graphics.Bitmap) r3)
            r4 = 0
            goto L_0x0100
        L_0x00ed:
            com.meizu.media.camera.simplify.j r5 = r8.f12139h
            android.graphics.Bitmap r6 = r8.m13463aB()
            r5.mo20858a((android.graphics.Bitmap) r6)
            goto L_0x0100
        L_0x00f7:
            com.meizu.media.camera.simplify.j r5 = r8.f12139h
            android.graphics.Bitmap r6 = r8.m13463aB()
            r5.mo20858a((android.graphics.Bitmap) r6)
        L_0x0100:
            com.meizu.media.camera.simplify.j r5 = r8.f12139h
            boolean r6 = r8.f12148q
            boolean r7 = r8.f12124O
            r5.mo20910b((boolean) r6, (boolean) r7)
            com.meizu.media.camera.simplify.d r5 = r8.f12140i
            boolean r6 = r8.f12148q
            r5.mo21211o((boolean) r6)
            com.meizu.media.camera.MzSimplifyCamModule r5 = r8.f12131V
            com.meizu.media.camera.simplify.b r5 = r5.mo18438am()
            r5.mo21088k(r0)
            r8.f12113D = r0
            com.meizu.media.camera.simplify.j r5 = r8.f12139h
            r5.mo20949j((boolean) r0)
            boolean r5 = r8.f12134Y
            if (r5 == 0) goto L_0x012a
            com.meizu.media.camera.ui.aa r5 = r8.f12128S
            r5.mo21793c()
            goto L_0x0133
        L_0x012a:
            boolean r5 = r8.f12123N
            if (r5 != 0) goto L_0x0133
            com.meizu.media.camera.simplify.k r5 = r8.f12127R
            r5.mo21341a((boolean) r0)
        L_0x0133:
            com.meizu.media.camera.simplify.j r5 = r8.f12139h
            boolean r6 = com.meizu.media.camera.util.DeviceHelper.f13838R
            r5.mo20872a((boolean) r0, (boolean) r6)
            r8.m13465aD()
            if (r4 == 0) goto L_0x0145
            if (r1 != 0) goto L_0x0145
            r8.m13462aA()
            goto L_0x014c
        L_0x0145:
            boolean r4 = r8.f12145n
            if (r4 == 0) goto L_0x014c
            r8.m13490az()
        L_0x014c:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13838R
            if (r4 == 0) goto L_0x0158
            com.meizu.media.camera.MzSimplifyCamModule r4 = r8.f12131V
            r5 = 2
            r4.mo18468e((int) r5)
            goto L_0x0158
        L_0x0157:
            r1 = 0
        L_0x0158:
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            r4.mo19441E()
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = r4.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0173
            r8.m13478an()
            goto L_0x0198
        L_0x0173:
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = r4.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0198
            boolean r4 = r8.f12145n
            if (r4 != 0) goto L_0x0198
            com.meizu.media.camera.MzSimplifyCamModule r4 = r8.f12131V
            boolean r4 = r4.mo18200dX()
            if (r4 != 0) goto L_0x0198
            com.meizu.media.camera.camcontroller.CameraController r4 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            boolean r5 = r8.f12123N
            r4.mo19458a((android.view.Surface) r3, (boolean) r5)
        L_0x0198:
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r3 = r3.mo19522k()
            if (r3 == 0) goto L_0x01b0
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r3 = r3.mo19522k()
            int r3 = r3.mo19733b()
            if (r3 == r2) goto L_0x01bd
        L_0x01b0:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13860aM
            if (r2 != 0) goto L_0x01bd
            com.meizu.media.camera.MzSimplifyCamModule r2 = r8.f12131V
            com.meizu.media.camera.simplify.b r2 = r2.mo18438am()
            r2.mo21094q()
        L_0x01bd:
            com.meizu.media.camera.MzSimplifyCamModule r2 = r8.f12131V
            com.meizu.media.camera.simplify.b r2 = r2.mo18438am()
            r2.mo21084i(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.SimplifyVideoMode.m13489ay():boolean");
    }

    /* renamed from: az */
    private void m13490az() {
        Bitmap aB;
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6171, new Class[0], Void.TYPE).isSupported && (aB = m13463aB()) != null) {
            m13481aq();
            this.f12131V.mo18365P();
            this.f12140i.mo21225z().mo21288b(aB);
        }
    }

    /* renamed from: aA */
    private void m13462aA() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6172, new Class[0], Void.TYPE).isSupported) {
            if (this.f12153v == null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f12149r;
                if (!this.f12117H || m13484at()) {
                    if (this.f12134Y) {
                        uptimeMillis = m13491b(uptimeMillis);
                    }
                    this.f12138g.mo17764p().mo17830a(this.f12154w, uptimeMillis, this.f12157z, this.f12137ac, this.f12142k);
                }
            }
            this.f12157z = null;
        }
    }

    /* renamed from: c */
    private void m13496c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12108a, false, 6173, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12109f;
            LogUtil.m15952c(aVar, "Deleting video " + str);
            if (!new File(str).delete()) {
                LogUtil.C2630a aVar2 = f12109f;
                LogUtil.m15952c(aVar2, "Could not delete " + str);
            }
        }
    }

    /* renamed from: aB */
    private Bitmap m13463aB() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12108a, false, 6174, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Bitmap bitmap = null;
        if (this.f12153v != null) {
            bitmap = Thumbnail.m7940a(this.f12153v.getFileDescriptor(), this.f12118I);
        } else if (this.f12155x != null) {
            try {
                bitmap = Thumbnail.m7940a(this.f12142k.openFileDescriptor(this.f12155x, "r").getFileDescriptor(), this.f12118I);
            } catch (FileNotFoundException e) {
                LogUtil.m15949b(f12109f, e.toString());
            }
        } else if (!TextUtils.isEmpty(this.f12154w)) {
            bitmap = Thumbnail.m7941a(this.f12154w, this.f12118I, new long[0]);
        }
        if (bitmap == null) {
            return bitmap;
        }
        if (this.f12145n) {
            return CameraUtil.m15820a(bitmap, 0, false);
        }
        return CameraUtil.m15872b(bitmap, 0, false);
    }

    /* renamed from: aC */
    private void m13464aC() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6175, new Class[0], Void.TYPE).isSupported) {
            this.f12141j.removeMessages(3);
            this.f12138g.getWindow().addFlags(128);
        }
    }

    /* renamed from: aD */
    private void m13465aD() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6176, new Class[0], Void.TYPE).isSupported) {
            this.f12141j.removeMessages(3);
            this.f12138g.getWindow().addFlags(128);
            this.f12141j.sendEmptyMessageDelayed(3, 120000);
        }
    }

    /* renamed from: aE */
    private void m13466aE() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6177, new Class[0], Void.TYPE).isSupported) {
            this.f12120K = "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(this.f12138g.getIntent().getAction());
            this.f12122M = this.f12138g.getIntent().getLongExtra("android.intent.extra.sizeLimit", this.f12122M);
            if (this.f12138g.getIntent().getIntExtra("isFlymeMms", -1) == 2) {
                this.f12121L = true;
            }
        }
    }

    /* renamed from: g */
    private void m13506g(boolean z) {
        String str;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12108a, false, 6178, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13840T || DeviceHelper.f14053w) {
                LogUtil.C2630a aVar = f12109f;
                LogUtil.m15952c(aVar, "setSlowHALParamsForQcomm: " + this.f12123N);
                CameraController g = CameraController.m8868g();
                if (z) {
                    str = "off";
                } else {
                    str = this.f12123N ? DeviceHelper.f14038h.getValue() : "off";
                }
                g.mo19471a("video-hfr", str, new boolean[0]);
            }
        }
    }

    /* renamed from: a */
    public static boolean m13461a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f12108a, true, 6179, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ("android.media.action.VIDEO_CAPTURE".equals(str) || "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: Y */
    public void mo21410Y() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6181, new Class[0], Void.TYPE).isSupported) {
            m13508h(true);
        }
    }

    /* renamed from: Z */
    public void mo21411Z() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6182, new Class[0], Void.TYPE).isSupported) {
            if (this.f12156y) {
                this.f12142k.delete(this.f12155x, (String) null, (String[]) null);
            }
            this.f12131V.mo18454b(0, new Intent());
        }
    }

    /* renamed from: aa */
    public void mo21413aa() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6183, new Class[0], Void.TYPE).isSupported && !this.f12131V.mo18200dX()) {
            this.f12140i.mo21225z().mo21287b();
            this.f12131V.mo18467e();
            this.f12131V.mo18438am().mo21074d(false);
        }
    }

    /* renamed from: h */
    private void m13508h(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12108a, false, 6184, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            Intent intent = new Intent();
            intent.addFlags(1);
            int i2 = -1;
            if (z) {
                intent.setData(this.f12155x);
                i = -1;
            }
            if (!this.f12120K || this.f12121L) {
                i2 = i;
            } else {
                intent.putExtra("Camera_Type", 1);
            }
            if (this.f12121L) {
                intent.putExtra("Camera_Type", 1);
                intent.putExtra("isFlymeMms", 2);
            }
            if (this.f12131V != null) {
                this.f12131V.mo18454b(i2, intent);
            }
        }
    }

    /* renamed from: ab */
    public void mo21414ab() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6185, new Class[0], Void.TYPE).isSupported) {
            Intent intent = new Intent();
            intent.setClassName("com.meizu.media.video", "com.meizu.media.video.player.ui.VideoWindowActivity");
            intent.setDataAndType(this.f12155x, m13499e(this.f12110A.mo20366e()));
            intent.addFlags(1);
            if (this.f12120K) {
                intent.putExtra("playSource", 4);
                intent.putExtra("video_title", "temp_video");
                intent.putExtra("meizu_video_record", true);
            }
            try {
                this.f12138g.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                LogUtil.m15949b(f12109f, "Count not find MZ Video player");
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(this.f12155x, m13499e(this.f12110A.mo20366e()));
                this.f12138g.startActivity(intent2);
            }
        }
    }

    /* renamed from: b */
    public void mo21415b(boolean z) {
        boolean z2 = true;
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12108a, false, 6186, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || DeviceHelper.f13853aF || DeviceHelper.f13849aB || DeviceHelper.f13840T) {
            return;
        }
        if (z) {
            CameraController.m8868g().mo19471a("recording-hint", "false", new boolean[0]);
            if (this.f12125P != -1) {
                CameraController.m8868g().mo19506d(this.f12125P, new boolean[0]);
            }
            this.f12125P = -1;
            return;
        }
        CameraController.m8868g().mo19471a("recording-hint", "true", new boolean[0]);
        this.f12125P = CameraController.m8868g().mo19537t();
        CameraController.m8868g().mo19506d(this.f12110A.mo20365d(), new boolean[0]);
        if (this.f12123N || !DeviceHelper.f13838R) {
            z2 = false;
        }
        if (z2) {
            this.f12143l.mo21105a(20, new boolean[0]);
        } else {
            this.f12143l.mo21105a(4, new boolean[0]);
        }
    }

    /* renamed from: c */
    public void mo21416c(boolean z) {
        if (z) {
            boolean z2 = this.f12123N;
        }
    }

    /* renamed from: n */
    public CameraController.FocusMode mo21362n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12108a, false, 6187, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f12131V.mo18440ao() == 1) {
            return CameraController.FocusMode.FIXED;
        }
        if (DeviceHelper.f13860aM) {
            return CameraController.FocusMode.CONTINUOUS_VIDEO;
        }
        return CameraController.FocusMode.AUTO;
    }

    /* renamed from: d */
    public CameraModeType.ModeType mo21352d() {
        if (this.f12123N) {
            return CameraModeType.ModeType.SLOWMOTION;
        }
        if (this.f12134Y) {
            return CameraModeType.ModeType.TIMELAPSE;
        }
        return CameraModeType.ModeType.VIDEO;
    }

    /* renamed from: c */
    public void mo21351c() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6188, new Class[0], Void.TYPE).isSupported) {
            if (!this.f12145n) {
                m13478an();
                m13480ap();
            }
            m13481aq();
            if (this.f12123N) {
                this.f12123N = false;
                this.f12139h.mo20958m(false);
                this.f12126Q.mo22595a();
            } else if (this.f12134Y) {
                this.f12128S.mo21787a();
                mo20669d(0);
                this.f12139h.mo20961n(false);
                this.f12139h.mo20985w(false);
            } else {
                this.f12127R.mo21343c();
            }
            if (DeviceHelper.f13844X) {
                if (this.f12144m.hasMessages(5)) {
                    this.f12144m.removeMessages(5);
                }
                m13511i(false);
            }
            this.f12143l.mo21110a(false, false, false);
            this.f12139h.mo20873a(true, DeviceHelper.f13910bJ == CameraController.CameraApi.API1, false);
            m13506g(true);
            if (DeviceUtil.m16200b()) {
                m13498d(true);
            }
        }
    }

    /* renamed from: b */
    public void mo21350b() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6190, new Class[0], Void.TYPE).isSupported) {
            mo21412a();
            if (!this.f12123N && !this.f12134Y) {
                this.f12127R.mo21342b();
            }
        }
    }

    /* renamed from: P */
    public void mo21383P() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6191, new Class[0], Void.TYPE).isSupported && this.f12123N && this.f12131V.mo18438am() != null && !DeviceHelper.f13860aM) {
            this.f12131V.mo18438am().mo21066a(false);
        }
    }

    /* renamed from: Q */
    public void mo21384Q() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6192, new Class[0], Void.TYPE).isSupported) {
            m13498d(false);
        }
    }

    /* renamed from: e */
    public void mo21353e() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6193, new Class[0], Void.TYPE).isSupported) {
            if (!this.f12145n) {
                m13478an();
                m13480ap();
            }
            m13481aq();
            this.f12144m.removeMessages(5);
        }
    }

    /* renamed from: f */
    public void mo21354f() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6194, new Class[0], Void.TYPE).isSupported && !this.f12144m.hasMessages(5)) {
            this.f12144m.sendEmptyMessage(5);
        }
    }

    /* renamed from: p */
    public void mo21364p() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6195, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            if (!this.f12145n) {
                m13478an();
                m13480ap();
            }
            if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.INVENSENSE) {
                m13481aq();
            }
        }
    }

    /* renamed from: g */
    public void mo21355g() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6196, new Class[0], Void.TYPE).isSupported) {
            super.mo21355g();
            mo21412a();
            if (this.f12127R == null) {
                this.f12127R = this.f12140i.mo21140B();
                this.f12127R.mo21339a(this.f12139h);
            }
            this.f12127R.mo21342b();
            if (CameraController.m8868g().mo19522k() != null) {
                m13498d(false);
            }
            if (this.f12131V.mo18438am() != null) {
                if (!this.f12123N || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                    this.f12131V.mo18438am().mo21074d(false);
                }
                if (this.f12123N && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f12131V.mo18438am().mo21066a(false);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo21349a(UUID uuid) {
        return this.f12123N;
    }

    /* renamed from: k */
    public boolean mo21359k() {
        return !this.f12134Y;
    }

    /* renamed from: l */
    public boolean mo21360l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12108a, false, 6197, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f12148q) {
            return false;
        }
        mo21378K();
        return true;
    }

    /* renamed from: G */
    public boolean mo21374G() {
        return !this.f12148q;
    }

    /* renamed from: H */
    public void mo21375H() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6198, new Class[0], Void.TYPE).isSupported && this.f12148q) {
            mo21407B();
        }
    }

    /* renamed from: I */
    public boolean mo21376I() {
        return this.f12148q && !this.f12113D;
    }

    /* renamed from: b */
    public void mo21398b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6199, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f12123N && this.f12126Q != null) {
                this.f12126Q.mo22601b(i);
            } else if (!this.f12134Y && this.f12127R != null) {
                this.f12127R.mo21338a(i);
            }
        }
    }

    /* renamed from: b */
    private long m13491b(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6200, new Class[]{Long.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        return (long) (((((double) j) / ((double) this.f12135aa)) / ((double) this.f12110A.mo20365d())) * 1000.0d);
    }

    /* renamed from: d */
    public void mo20669d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6202, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12134Y) {
            this.f12135aa = f12107Z[i];
            this.f12128S.mo21788a(i);
            LogUtil.C2630a aVar = LogUtil.f14072b;
            LogUtil.m15942a(aVar, "TimeLapseMode onLapseTimeChange:" + this.f12135aa);
        }
    }

    /* renamed from: D */
    public void mo21371D() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6203, new Class[0], Void.TYPE).isSupported) {
            super.mo21371D();
        }
    }

    /* renamed from: s */
    public void mo21367s() {
        if (!PatchProxy.proxy(new Object[0], this, f12108a, false, 6204, new Class[0], Void.TYPE).isSupported) {
            m13475ak();
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && (this.f12146o == null || this.f12147p == null)) {
                this.f12150s = System.currentTimeMillis();
                synchronized (this.f12112C) {
                    m13501e(true);
                }
            }
            m13506g(false);
        }
    }

    /* renamed from: a */
    public void mo21394a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12108a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6205, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.mo21394a(z);
            if (this.f12134Y) {
                this.f12128S.mo21794d();
            }
        }
    }

    /* renamed from: i */
    private void m13511i(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12108a, false, 6206, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            try {
                Object a = C2634am.m15996a("dalvik.system.VMRuntime", "getRuntime", (Object[]) null);
                if (z) {
                    C2634am.m15993a(a, "setTargetHeapUtilization", (Class<?>[]) new Class[]{Float.TYPE}, new Object[]{Float.valueOf(0.95f)});
                } else {
                    C2634am.m15993a(a, "setTargetHeapUtilization", (Class<?>[]) new Class[]{Float.TYPE}, new Object[]{Float.valueOf(0.75f)});
                }
                LogUtil.C2630a aVar = f12109f;
                LogUtil.m15942a(aVar, "after handleTargetHeapUtilization, value is " + C2634am.m15994a(a, "getTargetHeapUtilization", (Object[]) null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
