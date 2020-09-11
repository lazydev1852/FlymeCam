package com.meizu.media.camera.mode;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.base.MsgField;
import com.mediatek.media.MtkMediaStore;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.Thumbnail;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraControllerV2;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p070g.AudioRecorder;
import com.meizu.media.camera.p070g.HWRecorderWrapper;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.p077ui.MzSlowMotionUI;
import com.meizu.media.camera.p077ui.MzTimeLapseUI;
import com.meizu.media.camera.p077ui.MzVideoBaseUI;
import com.meizu.media.camera.p077ui.MzVideoUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.CameraSizeUtil;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.meizu.media.camera.mode.u */
public class VideoMode extends CameraMode implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener, AudioRecorder.C2077a, HWRecorderWrapper.C2083b, MzTimeLapseRender.C2752a {

    /* renamed from: a */
    public static ChangeQuickRedirect f11164a;

    /* renamed from: af */
    private static final int[] f11165af = {500, 1000, MsgField.IMSG_SAVE_PICTURE, 4000, 8000};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f11166b = new LogUtil.C2630a("VideoMode");

    /* renamed from: A */
    private ContentValues f11167A;

    /* renamed from: B */
    private MzCamcorderProfileManager f11168B;

    /* renamed from: C */
    private int f11169C;

    /* renamed from: D */
    private int f11170D;

    /* renamed from: E */
    private boolean f11171E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Object f11172F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f11173G;

    /* renamed from: H */
    private long f11174H;

    /* renamed from: I */
    private long f11175I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public boolean f11176J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f11177K;

    /* renamed from: L */
    private int f11178L;

    /* renamed from: M */
    private int f11179M;

    /* renamed from: N */
    private boolean f11180N;

    /* renamed from: O */
    private boolean f11181O;

    /* renamed from: P */
    private long f11182P;

    /* renamed from: Q */
    private boolean f11183Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f11184R;

    /* renamed from: S */
    private int f11185S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public int f11186T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public MzSlowMotionUI f11187U;

    /* renamed from: V */
    private MzVideoUI f11188V;

    /* renamed from: W */
    private MzTimeLapseUI f11189W;

    /* renamed from: X */
    private MzVideoBaseUI f11190X;

    /* renamed from: Y */
    private int f11191Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public boolean f11192Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public CameraModeListener f11193aa;

    /* renamed from: ab */
    private long f11194ab;

    /* renamed from: ac */
    private boolean f11195ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public C2235b f11196ad;

    /* renamed from: ae */
    private boolean f11197ae;

    /* renamed from: ag */
    private int f11198ag;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public HWRecorderWrapper f11199ah;

    /* renamed from: ai */
    private AudioRecorder f11200ai;

    /* renamed from: aj */
    private int f11201aj;

    /* renamed from: ak */
    private boolean f11202ak;

    /* renamed from: al */
    private boolean f11203al;

    /* renamed from: am */
    private boolean f11204am;

    /* renamed from: an */
    private int f11205an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public int f11206ao;

    /* renamed from: ap */
    private int f11207ap;

    /* renamed from: aq */
    private Runnable f11208aq;

    /* renamed from: ar */
    private final MediaSaveService.C1639d f11209ar;

    /* renamed from: as */
    private MzSlowMotionUI.C2607a f11210as;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraActivity f11211c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MzUIController f11212d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MzCamUI f11213e;

    /* renamed from: f */
    private Handler f11214f;

    /* renamed from: g */
    private ContentResolver f11215g;

    /* renamed from: l */
    private MzCamParamsManager f11216l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C2234a f11217m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f11218n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MediaRecorder f11219o;

    /* renamed from: p */
    private Surface f11220p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f11221q;

    /* renamed from: r */
    private long f11222r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f11223s;

    /* renamed from: t */
    private boolean f11224t;

    /* renamed from: u */
    private String f11225u;

    /* renamed from: v */
    private ParcelFileDescriptor f11226v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f11227w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public String f11228x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Uri f11229y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f11230z;

    /* renamed from: at */
    private void m12105at() {
    }

    /* renamed from: f */
    private String m12126f(int i) {
        return i == 2 ? "video/mp4" : "video/3gpp";
    }

    /* renamed from: g */
    private String m12129g(int i) {
        return i == 2 ? ".mp4" : ".3gp";
    }

    /* renamed from: A */
    public int mo20377A() {
        return 0;
    }

    /* renamed from: ae */
    public boolean mo20458ae() {
        return false;
    }

    /* renamed from: c_ */
    public boolean mo20464c_() {
        return false;
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
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

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    private VideoMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f11221q = false;
        this.f11224t = false;
        this.f11172F = new Object();
        this.f11182P = 0;
        this.f11192Z = false;
        this.f11194ab = -1;
        this.f11195ac = false;
        this.f11197ae = false;
        this.f11198ag = f11165af[0];
        this.f11199ah = new HWRecorderWrapper();
        this.f11200ai = new AudioRecorder();
        this.f11201aj = 42;
        this.f11202ak = false;
        this.f11203al = false;
        this.f11204am = false;
        this.f11205an = 0;
        this.f11206ao = 0;
        this.f11207ap = 0;
        this.f11208aq = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f11231a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f11231a, false, 5241, new Class[0], Void.TYPE).isSupported) {
                    long unused = VideoMode.this.f11223s = System.currentTimeMillis();
                    VideoMode.this.m12085aA();
                }
            }
        };
        this.f11209ar = new MediaSaveService.C1639d() {

            /* renamed from: a */
            public static ChangeQuickRedirect f11233a;

            /* renamed from: a */
            public void mo17846a(String str, int i, int i2, byte[] bArr) {
            }

            /* renamed from: a */
            public void mo17847a(List<String> list) {
            }

            /* renamed from: a */
            public void mo17844a(Uri uri) {
                if (!PatchProxy.proxy(new Object[]{uri}, this, f11233a, false, 5242, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                    if (VideoMode.this.f11193aa.mo17859H()) {
                        Bitmap b = CameraUtil.m15872b(Thumbnail.m7941a(VideoMode.this.f11228x, VideoMode.this.f11206ao, VideoMode.this.f11199ah.mo20133a()), 0, false);
                        VideoMode.this.f11211c.mo17673b(uri);
                        VideoMode.this.f11212d.mo21518a(uri);
                        VideoMode.this.f11212d.mo21515a(b);
                    }
                    if (uri != null) {
                        Uri unused = VideoMode.this.f11229y = uri;
                        boolean unused2 = VideoMode.this.f11230z = true;
                        VideoMode.this.mo20674r();
                        VideoMode.this.f11211c.mo17673b(uri);
                    } else if (VideoMode.this.f11211c != null && !VideoMode.this.f11211c.mo17677n()) {
                        VideoMode.this.f11212d.mo21577c(false, false, true);
                    }
                    if (VideoMode.this.f11196ad != null) {
                        VideoMode.this.f11196ad.f11258j = null;
                    }
                }
            }

            /* renamed from: a */
            public void mo17845a(String str) {
                if (!PatchProxy.proxy(new Object[]{str}, this, f11233a, false, 5243, new Class[]{String.class}, Void.TYPE).isSupported) {
                    VideoMode.this.f11211c.mo17670a(str, true);
                }
            }
        };
        this.f11210as = new MzSlowMotionUI.C2607a() {

            /* renamed from: a */
            public static ChangeQuickRedirect f11235a;

            /* renamed from: a */
            public void mo20676a() {
                if (!PatchProxy.proxy(new Object[0], this, f11235a, false, 5244, new Class[0], Void.TYPE).isSupported) {
                    String q = CameraUtil.m15911q();
                    String string = VideoMode.this.f11193aa.mo17902aE().getString("pref_camera_slowmotion_high_frame_rate_key", q);
                    if (string != null) {
                        int unused = VideoMode.this.f11186T = Integer.valueOf(string).intValue();
                    } else {
                        int unused2 = VideoMode.this.f11186T = Integer.valueOf(q).intValue();
                    }
                    if (VideoMode.this.f11187U != null) {
                        VideoMode.this.f11187U.mo22602c(VideoMode.this.f11186T);
                    }
                }
            }
        };
        this.f11217m = new C2234a(this);
        this.f11211c = cameraActivity;
        this.f11216l = lVar;
        this.f11213e = hVar.mo18267u();
        this.f11215g = hVar.mo18187dK();
        this.f11212d = uVar;
        this.f11193aa = hVar;
        this.f11214f = hVar.mo18188dL();
        this.f11218n = m12115b(this.f11211c.getIntent().getAction());
        if (this.f11218n) {
            m12091aG();
        }
        if (DeviceHelper.f13844X) {
            m12137j(true);
            if (!this.f11217m.hasMessages(5)) {
                this.f11217m.sendEmptyMessage(5);
            }
        }
        this.f11168B = new MzCamcorderProfileManager();
        EffectRenderContext.m4369h().mo14229m(true);
    }

    public VideoMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType, boolean z, boolean z2) {
        this(cameraActivity, lVar, uVar, hVar, modeType);
        this.f11183Q = z;
        this.f11197ae = z2;
        m12069N();
        this.f11216l.mo20323a(true, this.f11183Q, this.f11197ae);
        m12100ao();
        if (!(this.f11212d == null || this.f11213e == null)) {
            m12070O();
        }
        EffectRenderContext.m4369h().mo14229m(true);
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f11164a, false, 5157, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            super.mo20387a(uVar);
            this.f11213e = this.f11193aa.mo18267u();
            this.f11212d = uVar;
        }
    }

    /* renamed from: N */
    private void m12069N() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5158, new Class[0], Void.TYPE).isSupported) {
            this.f11200ai.mo20113a((AudioRecorder.C2077a) this);
            this.f11199ah.mo20134a((HWRecorderWrapper.C2083b) this);
        }
    }

    /* renamed from: O */
    private void m12070O() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5159, new Class[0], Void.TYPE).isSupported && this.f11213e != null) {
            if (this.f11183Q) {
                this.f11187U = this.f11213e.mo22117af();
                this.f11187U.mo22597a(this.f11212d);
                this.f11187U.mo22598a(this.f11210as);
                m12071P();
            } else if (this.f11197ae) {
                this.f11189W = this.f11213e.mo22118ag();
                this.f11189W.mo21789a(this.f11212d);
                m12071P();
            } else {
                this.f11188V = this.f11213e.mo22119ah();
                this.f11188V.mo21833a(this.f11212d, new boolean[0]);
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                this.f11190X = this.f11213e.mo22120ai();
                if (this.f11190X != null) {
                    this.f11190X.mo21822a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20452a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5160, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f11190X != null) {
            this.f11190X.mo21823a(f);
        }
    }

    /* renamed from: P */
    private void m12071P() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5161, new Class[0], Void.TYPE).isSupported) {
            if (this.f11183Q) {
                this.f11212d.mo21506a(5);
                this.f11212d.mo21592g(76);
            } else if (this.f11197ae) {
                this.f11212d.mo21506a(132);
                this.f11212d.mo21592g(131140);
            } else if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                if (this.f11184R) {
                    this.f11212d.mo21506a(MzUIController.f12284f);
                } else {
                    this.f11212d.mo21506a(MzUIController.f12282d);
                }
                this.f11212d.mo21592g(131660);
            } else {
                if (this.f11184R) {
                    this.f11212d.mo21506a(MzUIController.f12285g);
                } else {
                    this.f11212d.mo21506a(MzUIController.f12283e);
                }
                this.f11212d.mo21592g(131660);
            }
            mo20542U().mo21593g(true);
            mo20542U().mo21599h(this.f11183Q);
            mo20542U().mo21630r(this.f11197ae);
            m12123e(false);
            mo20542U().mo21607k(-1);
        }
    }

    /* renamed from: e */
    private void m12123e(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11164a, false, 5162, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11237a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11237a, false, 5245, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    CameraController.m8868g().mo19475a(z);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.u$a */
    /* compiled from: VideoMode */
    private static class C2234a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f11247a;

        /* renamed from: b */
        private WeakReference<VideoMode> f11248b;

        public C2234a(VideoMode uVar) {
            this.f11248b = new WeakReference<>(uVar);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f11247a, false, 5249, new Class[]{Message.class}, Void.TYPE).isSupported) {
                if (this.f11248b.get() == null) {
                    LogUtil.m15942a(VideoMode.f11166b, "videoMode has been destroy!");
                    return;
                }
                try {
                    switch (message.what) {
                        case 1:
                            ((VideoMode) this.f11248b.get()).mo20673q();
                            return;
                        case 2:
                            ((VideoMode) this.f11248b.get()).m12110ay();
                            return;
                        case 3:
                            ((VideoMode) this.f11248b.get()).m12111az();
                            return;
                        case 4:
                            ((VideoMode) this.f11248b.get()).m12072Q();
                            return;
                        case 5:
                            if (DeviceHelper.f13844X && ((VideoMode) this.f11248b.get()).f11211c != null && !((VideoMode) this.f11248b.get()).f11211c.mo17677n()) {
                                LogUtil.m15942a(VideoMode.f11166b, "video record, force execute gc");
                                System.runFinalization();
                                System.gc();
                                ((VideoMode) this.f11248b.get()).f11217m.removeMessages(5);
                                ((VideoMode) this.f11248b.get()).f11217m.sendEmptyMessageDelayed(5, 5000);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (NullPointerException e) {
                    LogUtil.m15949b(VideoMode.f11166b, "handler throw npe!");
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.u$b */
    /* compiled from: VideoMode */
    private class C2235b extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f11249a;

        /* renamed from: b */
        boolean f11250b = false;

        /* renamed from: c */
        boolean f11251c = false;

        /* renamed from: d */
        boolean f11252d;

        /* renamed from: e */
        boolean f11253e;

        /* renamed from: f */
        boolean f11254f;

        /* renamed from: g */
        Bitmap f11255g = null;

        /* renamed from: h */
        MediaRecorder f11256h;

        /* renamed from: i */
        ContentValues f11257i;

        /* renamed from: j */
        String f11258j;

        public C2235b(MediaRecorder mediaRecorder, boolean z, ContentValues contentValues, String str, boolean z2, boolean z3) {
            this.f11252d = z;
            this.f11257i = contentValues;
            this.f11258j = str;
            this.f11256h = mediaRecorder;
            this.f11253e = z2;
            this.f11254f = z3;
        }

        /* renamed from: a */
        public Void mo17658a(Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11249a, false, 5250, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            if (this.f11254f) {
                VideoMode.this.m12094aJ();
            } else {
                try {
                    VideoMode.this.m12093aI();
                    this.f11256h.setOnErrorListener((MediaRecorder.OnErrorListener) null);
                    this.f11256h.setOnInfoListener((MediaRecorder.OnInfoListener) null);
                    this.f11256h.stop();
                    this.f11251c = true;
                    String unused = VideoMode.this.f11227w = this.f11258j;
                    this.f11255g = VideoMode.this.m12088aD();
                    LogUtil.C2630a M = VideoMode.f11166b;
                    LogUtil.m15952c(M, "stopVideoRecording: Setting current video filename: " + VideoMode.this.f11227w);
                } catch (RuntimeException e) {
                    LogUtil.m15950b(VideoMode.f11166b, "stop fail", e);
                    this.f11250b = true;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo17660a(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f11249a, false, 5251, new Class[]{Void.class}, Void.TYPE).isSupported) {
                if (VideoMode.this.f11193aa.mo18200dX()) {
                    VideoMode.this.m12106au();
                }
                if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.ARCSOFT) {
                    VideoMode.this.m12130g(false);
                }
                VideoMode.this.f11211c.mo17692s();
                boolean unused = VideoMode.this.f11221q = false;
                if (!this.f11254f) {
                    if (!DeviceHelper.f13936bj) {
                        VideoMode.this.f11212d.mo21515a(this.f11255g);
                    } else if (!VideoMode.this.f11192Z || VideoMode.this.f11192Z == Storage.m7750a().mo18682x()) {
                        VideoMode.this.f11212d.mo21515a(this.f11255g);
                    } else {
                        this.f11251c = false;
                        VideoMode.this.f11212d.mo21515a((Bitmap) null);
                    }
                }
                VideoMode.this.f11212d.mo21569b(VideoMode.this.f11221q, VideoMode.this.f11184R);
                VideoMode.this.f11213e.mo22197v(VideoMode.this.f11221q);
                if (VideoMode.this.f11193aa.mo17914ak() != null) {
                    VideoMode.this.f11193aa.mo17914ak().mo20232k(false);
                }
                boolean unused2 = VideoMode.this.f11173G = false;
                VideoMode.this.f11212d.mo21601i(false);
                VideoMode.this.f11213e.mo22148c(false);
                VideoMode.this.m12090aF();
                if (!this.f11254f) {
                    if (this.f11251c && !this.f11250b) {
                        VideoMode.this.m12079a(this.f11257i, this.f11258j);
                    } else if (VideoMode.this.f11218n) {
                        VideoMode.this.m12087aC();
                    }
                    VideoMode.this.f11212d.mo21586e(true);
                    if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                        CameraController.m8868g().mo19441E();
                        VideoMode.this.m12103ar();
                    } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && this.f11253e && !VideoMode.this.f11218n) {
                        LogUtil.C2630a M = VideoMode.f11166b;
                        LogUtil.m15942a(M, "release MediaRecorder in task, " + this.f11256h);
                        if (this.f11256h != null) {
                            this.f11256h.reset();
                            this.f11256h.release();
                            if (VideoMode.this.f11219o == this.f11256h) {
                                synchronized (VideoMode.this.f11172F) {
                                    MediaRecorder unused3 = VideoMode.this.f11219o = null;
                                }
                            }
                            this.f11256h = null;
                        }
                    }
                    if (this.f11252d && VideoMode.this.f11218n && !this.f11250b) {
                        VideoMode.this.m12087aC();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void mo20668c() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5163, new Class[0], Void.TYPE).isSupported) {
            m12099an();
            this.f11212d.mo21596h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m12072Q() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5164, new Class[0], Void.TYPE).isSupported) {
            m12099an();
            m12095aj();
            if (DeviceHelper.f13860aM) {
                this.f11193aa.mo17914ak().mo20221f();
            }
            this.f11193aa.mo17914ak().mo20242u();
        }
    }

    /* renamed from: aj */
    private void m12095aj() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5165, new Class[0], Void.TYPE).isSupported) {
            mo20667a(true);
            if (DeviceHelper.f13839S) {
                if (DeviceHelper.f13849aB) {
                    return;
                }
                if (this.f11212d.mo21594g()) {
                    mo20670d(false);
                    this.f11193aa.mo18202dZ();
                    this.f11193aa.mo18051aj(false);
                    return;
                }
                this.f11193aa.mo18051aj(false);
                mo20670d(false);
            } else if (DeviceHelper.f13841U) {
                mo20670d(false);
            } else {
                mo20670d(false);
            }
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5166, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        synchronized (this.f11172F) {
            if (this.f11219o == null || this.f11220p == null || !this.f11220p.isValid()) {
                this.f11223s = System.currentTimeMillis();
                m12127f(true);
            }
        }
        LogUtil.C2630a aVar = f11166b;
        LogUtil.m15942a(aVar, "getPreviewSurfaces: mMediaRecorder = " + this.f11219o + ", mIsMediaRecorderPrepare = " + this.f11195ac + ", mMediaSurface = " + this.f11220p);
        if (this.f11219o == null || !this.f11195ac || this.f11220p == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f11220p);
        return arrayList;
    }

    /* renamed from: ak */
    private void m12096ak() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5167, new Class[0], Void.TYPE).isSupported) {
            String[] strArr = new String[7];
            strArr[0] = "mode";
            strArr[1] = (this.f11197ae || this.f11183Q) ? "" : "is_back_camera";
            strArr[2] = "location";
            strArr[3] = "meshline";
            strArr[4] = "level";
            strArr[5] = "sd_card";
            strArr[6] = DeviceHelper.f13863aP ? "eis" : "";
            Map<String, String> a = UsageStatsHelper.m16042a(mo20540S().getApplicationContext()).mo22688a(strArr);
            a.put("capture_time", Long.toString(this.f11223s));
            a.put("torch", CameraController.m8868g().mo19534q().key);
            if (!this.f11183Q && !this.f11197ae) {
                a.put("video_size", CameraSizeUtil.m16180b(this.f11193aa.mo17902aE().getString("pref_video_quality_key", (String) null)));
            }
            if (this.f11197ae) {
                a.put("time_lapse", String.valueOf(this.f11198ag));
            }
            if (this.f11183Q && CameraController.m8868g().mo19443G() != null) {
                a.put("fps", Integer.toString(this.f11186T));
            }
            if (!this.f11183Q) {
                a.put("zoom", Integer.toString(this.f11193aa.mo18267u().mo22199w()));
            }
            if (CameraModeType.m10968g()) {
                String string = this.f11211c.getResources().getString(R.string.mz_filter_none_title);
                String i = UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22706i();
                if ("none".equals(i)) {
                    UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22722x(string);
                } else if (!string.equals(i)) {
                    a.put("filter_value", i);
                    a.put("filter_type", UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22702g());
                    a.put("num_filter", UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22704h());
                }
            }
            a.put("video_length", Long.toString(System.currentTimeMillis() - this.f11223s));
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", this.f11193aa.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            if (DeviceHelper.f13863aP) {
                a.put("telephoto_lens", this.f11193aa.mo18211di() == DeviceHelper.f13949bw ? "1" : "0");
            }
            UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22693a("capture_info", a);
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5168, new Class[0], Void.TYPE).isSupported) {
            String[] strArr = new String[6];
            strArr[0] = "mode";
            strArr[1] = (this.f11197ae || this.f11183Q) ? "" : "is_back_camera";
            strArr[2] = "location";
            strArr[3] = "meshline";
            strArr[4] = "level";
            strArr[5] = "sd_card";
            Map<String, String> a = UsageStatsHelper.m16042a(mo20540S().getApplicationContext()).mo22688a(strArr);
            a.put("capture_time", Long.toString(this.f11223s));
            a.put("torch", CameraController.m8868g().mo19534q().key);
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            a.put("zoom", Integer.toString(this.f11193aa.mo18267u().mo22199w()));
            String str2 = "error mode";
            if (!(this.f11193aa.mo17914ak() == null || (ak = this.f11193aa.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            a.put("video_length", Long.toString(System.currentTimeMillis() - this.f11223s));
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", this.f11193aa.mo18211di() == DeviceHelper.f14029du ? "1" : "0");
            }
            UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22693a("capture_info", a);
        }
    }

    /* renamed from: o */
    public void mo20412o() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5170, new Class[0], Void.TYPE).isSupported) {
            boolean z = this.f11221q;
            if (z) {
                this.f11214f.postDelayed(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f11240a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f11240a, false, 5246, new Class[0], Void.TYPE).isSupported) {
                            VideoMode.this.m12072Q();
                        }
                    }
                }, 0);
            } else {
                this.f11193aa.mo18233ed();
                if (this.f11193aa.mo18197dU() <= 105906176) {
                    LogUtil.m15952c(f11166b, "Storage issue, ignore the start request");
                    return;
                }
                this.f11211c.mo17691r();
                mo20670d(true);
                this.f11221q = true;
                mo20667a(false);
                m12100ao();
                if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.ARCSOFT) {
                    m12130g(true);
                    this.f11214f.postDelayed(this.f11208aq, 150);
                } else if (this.f11211c.mo17693t()) {
                    this.f11214f.postDelayed(this.f11208aq, 60);
                } else {
                    this.f11223s = System.currentTimeMillis();
                    m12085aA();
                }
            }
            if (!this.f11218n || !z) {
                this.f11214f.sendEmptyMessageDelayed(12, 500);
            }
        }
    }

    /* renamed from: ad */
    public void mo20550ad() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5171, new Class[0], Void.TYPE).isSupported && this.f11219o != null) {
            if (this.f11173G) {
                this.f11174H = (this.f11174H + SystemClock.uptimeMillis()) - this.f11175I;
                m12098am();
                mo20673q();
                UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22695b("click_resume_recording");
            } else {
                this.f11175I = SystemClock.uptimeMillis();
                m12097al();
                UsageStatsHelper.m16042a(this.f11211c.getApplicationContext()).mo22695b("click_pause_recording");
            }
            this.f11212d.mo21601i(this.f11173G);
        }
    }

    /* renamed from: al */
    private void m12097al() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5172, new Class[0], Void.TYPE).isSupported) {
            this.f11173G = true;
            try {
                C2634am.m15993a((Object) this.f11219o, "pause", (Class<?>[]) null, (Object[]) null);
            } catch (Exception unused) {
                LogUtil.m15949b(f11166b, "invoke exception pause()");
            }
        }
    }

    /* renamed from: am */
    private void m12098am() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5173, new Class[0], Void.TYPE).isSupported) {
            this.f11173G = false;
            try {
                C2634am.m15993a((Object) this.f11219o, "resume", (Class<?>[]) null, (Object[]) null);
            } catch (Exception unused) {
                LogUtil.m15949b(f11166b, "invoke exception resume()");
            }
        }
    }

    /* renamed from: q */
    public void mo20673q() {
        long j;
        long j2;
        String str;
        if (PatchProxy.proxy(new Object[0], this, f11164a, false, 5174, new Class[0], Void.TYPE).isSupported || !this.f11221q || this.f11173G) {
            return;
        }
        if (this.f11196ad == null || this.f11196ad.mo22613c() != AsyncTaskEx.Status.RUNNING) {
            long uptimeMillis = (SystemClock.uptimeMillis() - this.f11222r) - this.f11174H;
            if ((this.f11169C != 0 && uptimeMillis >= ((long) (this.f11169C - 60000))) || this.f11183Q) {
                j = Math.max(0, ((long) this.f11169C) - uptimeMillis) + 999;
            } else {
                j = (!this.f11171E || this.f11170D == 0) ? uptimeMillis : Math.max(0, ((long) this.f11170D) - uptimeMillis) + 999;
            }
            if (this.f11183Q) {
                this.f11187U.mo22599a(m12077a(j - 999));
            } else if (this.f11188V != null) {
                if (this.f11171E) {
                    this.f11188V.mo21834a(CameraUtil.m15894e(j - 999), true);
                } else {
                    if (this.f11197ae) {
                        str = CameraUtil.m15833a(m12112b(uptimeMillis), true);
                    } else {
                        str = CameraUtil.m15833a(j, false);
                    }
                    this.f11188V.mo21834a(str, true);
                }
            }
            if (this.f11197ae) {
                j2 = (long) this.f11198ag;
            } else {
                j2 = this.f11183Q ? 100 : 1000;
            }
            long j3 = j2 - (uptimeMillis % j2);
            if (!DeviceHelper.f13840T || ((!this.f11183Q && !this.f11171E) || j - 999 > 0 || !this.f11221q)) {
                C2234a aVar = this.f11217m;
                if (this.f11171E) {
                    j3 = j2;
                }
                aVar.sendEmptyMessageDelayed(1, j3);
                return;
            }
            this.f11217m.sendEmptyMessage(4);
        }
    }

    /* renamed from: a */
    private String m12077a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5175, new Class[]{Long.TYPE}, String.class);
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

    /* renamed from: h */
    private void m12132h(int i) {
        String str;
        File file;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11164a, false, 5176, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            long j = this.f11223s;
            if (this.f11194ab == -1) {
                this.f11194ab = j;
                mo20539R().mo18175d(this.f11194ab);
            }
            String a = Storage.m7750a().mo18620a((Context) this.f11211c, j);
            String str2 = a + m12129g(i);
            String f = m12126f(i);
            if (this.f11181O) {
                file = new File(Storage.m7750a().mo18663k());
                str = Storage.m7750a().mo18658h(str2);
            } else {
                file = new File(Storage.m7750a().mo18665l());
                str = Storage.m7750a().mo18660i(str2);
                this.f11192Z = Storage.m7750a().mo18682x();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f11228x = str;
            String str3 = str + ".tmp";
            ContentValues contentValues = new ContentValues(12);
            contentValues.put(PushConstants.TITLE, a);
            contentValues.put("_display_name", str2);
            contentValues.put("datetaken", Long.valueOf(j));
            contentValues.put("date_modified", Long.valueOf(j / 1000));
            contentValues.put("mime_type", f);
            contentValues.put("_data", str);
            contentValues.put("resolution", Integer.toString(this.f11168B.mo20363b()) + "x" + Integer.toString(this.f11168B.mo20364c()));
            int c = this.f11193aa.mo18194dR() != -1 ? CameraUtil.m15882c(this.f11193aa.mo18211di(), this.f11193aa.mo18194dR()) : 0;
            contentValues.put("width", Integer.valueOf(this.f11168B.mo20363b()));
            contentValues.put("height", Integer.valueOf(this.f11168B.mo20364c()));
            LogUtil.m15942a(f11166b, "generateVideoFilename: width = " + contentValues.get("width") + ", height = " + contentValues.get("height"));
            this.f11206ao = EffectRenderContext.m4369h().mo14239w();
            this.f11207ap = EffectRenderContext.m4369h().mo14240x();
            if (((c / 90) & 1) == 1) {
                contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, 90);
                this.f11206ao = EffectRenderContext.m4369h().mo14240x();
                this.f11207ap = EffectRenderContext.m4369h().mo14239w();
            } else {
                contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            }
            this.f11205an = c;
            Location a2 = this.f11193aa.mo18192dP().mo19017a(this.f11223s);
            if (a2 != null) {
                contentValues.put(Parameters.LATITUDE, Double.valueOf(a2.getLatitude()));
                contentValues.put(Parameters.LONGITUDE, Double.valueOf(a2.getLongitude()));
            }
            this.f11167A = contentValues;
            this.f11225u = str3;
            if (this.f11193aa.mo17859H()) {
                LogUtil.m15952c(f11166b, "New Effectvideo filename: " + this.f11228x);
                return;
            }
            LogUtil.m15952c(f11166b, "New video filename: " + this.f11225u);
        }
    }

    /* renamed from: an */
    private void m12099an() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5177, new Class[0], Void.TYPE).isSupported) {
            m12096ak();
            m12133h(true);
            if (!this.f11176J || !this.f11177K) {
                this.f11212d.mo21566b((int) R.string.mz_recording_save, true);
            }
            if (this.f11183Q) {
                if (this.f11187U != null) {
                    this.f11187U.mo22599a("60.00");
                }
            } else if (this.f11197ae) {
                if (this.f11189W != null) {
                    this.f11189W.mo21793c();
                }
            } else if (this.f11188V != null) {
                this.f11188V.mo21834a(this.f11171E ? "10:00" : "00:00:00", new boolean[0]);
            }
        }
    }

    /* renamed from: r */
    public void mo20674r() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5178, new Class[0], Void.TYPE).isSupported && !this.f11218n) {
            this.f11212d.mo21518a(this.f11229y);
        }
    }

    /* renamed from: ao */
    private void m12100ao() {
        boolean z;
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5179, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11166b, "readVideoPreferences start");
            String string = this.f11193aa.mo17902aE().getString("pref_video_quality_key", (String) null);
            if (string == null) {
                CameraSizeDefault.m16167a((Activity) this.f11211c, this.f11193aa.mo18211di());
                string = CameraSizeDefault.m16170b((Context) this.f11211c, this.f11193aa.mo18211di());
            }
            int parseInt = Integer.parseInt(string);
            if (!DeviceHelper.f13863aP || this.f11183Q || this.f11197ae || (!(this.f11193aa.mo18211di() == DeviceHelper.f13949bw || (DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE && this.f11193aa.mo18211di() == DeviceHelper.f14029du)) || parseInt == 5 || parseInt == 6)) {
                z = true;
            } else {
                CameraController.m8868g().mo19472a("30", false);
                LogUtil.m15952c(f11166b, "videoSize, reset quality 1080P");
                parseInt = 6;
                z = false;
            }
            Intent intent = this.f11211c.getIntent();
            if (intent.hasExtra("android.intent.extra.videoQuality") && !DeviceHelper.f13838R) {
                parseInt = intent.getIntExtra("android.intent.extra.videoQuality", 0) > 0 ? 1 : 0;
            }
            if (intent.hasExtra("android.intent.extra.durationLimit")) {
                this.f11169C = intent.getIntExtra("android.intent.extra.durationLimit", 0) * 1000;
            } else {
                this.f11169C = CameraSettings.m9776a((Context) this.f11211c);
            }
            this.f11184R = false;
            if (parseInt == DeviceHelper.f14004cy || parseInt == DeviceHelper.f14005cz) {
                this.f11184R = true;
            }
            if (DeviceHelper.f13838R && this.f11193aa.mo17859H() && DeviceHelper.f13841U && (this.f11184R || parseInt == 6)) {
                this.f11184R = false;
                LogUtil.m15952c(f11166b, "MX4 Pro Video Filter Change to 720P!!!");
                parseInt = 5;
            }
            if ((this.f11182P != 0 && this.f11182P <= 276480) && !this.f11181O) {
                parseInt = 2;
                this.f11184R = false;
                LogUtil.m15952c(f11166b, "MMS Record Change to QCIF!!!");
            }
            if (this.f11183Q) {
                String q = CameraUtil.m15911q();
                int i = this.f11193aa.mo17902aE().getInt("pref_slow_motion_quality_key", "240".equals(q) ? DeviceHelper.f13955cB : DeviceHelper.f13954cA);
                String string2 = this.f11193aa.mo17902aE().getString("pref_camera_slowmotion_high_frame_rate_key", q);
                if (string2 != null) {
                    this.f11186T = Integer.valueOf(string2).intValue();
                } else {
                    this.f11186T = Integer.valueOf(q).intValue();
                }
                this.f11184R = false;
                this.f11169C = 60000;
                parseInt = i;
            }
            if (parseInt == -1 || parseInt != DeviceHelper.f14005cz) {
                this.f11171E = false;
                this.f11170D = 0;
            } else {
                this.f11171E = true;
                this.f11170D = 600000;
            }
            if (this.f11197ae) {
                parseInt = 1006;
                this.f11184R = false;
            }
            this.f11168B.mo20361a(this.f11193aa.mo18211di(), parseInt);
            String str = this.f11168B.mo20363b() + "x" + this.f11168B.mo20364c();
            LogUtil.m15952c(f11166b, "videoSize: " + str + ", quality = " + parseInt);
            if (z) {
                SharedPreferences.Editor edit = this.f11193aa.mo17902aE().edit();
                String valueOf = String.valueOf(parseInt);
                if (!valueOf.equals(string) && !this.f11197ae) {
                    if (!this.f11183Q) {
                        edit.putString("pref_video_quality_key", valueOf);
                    } else {
                        edit.putInt("pref_slow_motion_quality_key", parseInt);
                    }
                }
                edit.putString("pref_camera_videosize_key", str);
                edit.apply();
            }
            m12101ap();
            this.f11212d.mo21569b(false, this.f11184R);
            LogUtil.m15952c(f11166b, "readVideoPreferences end");
        }
    }

    @TargetApi(11)
    /* renamed from: ap */
    private void m12101ap() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5180, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null) {
            if (this.f11168B.mo20363b() == -1 || this.f11168B.mo20364c() == -1) {
                Point l = CameraController.m8868g().mo19524l();
                if (l != null) {
                    this.f11178L = l.x;
                    this.f11179M = l.y;
                }
            } else {
                this.f11178L = this.f11168B.mo20363b();
                this.f11179M = this.f11168B.mo20364c();
            }
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15952c(aVar, "previewWidth=" + this.f11178L + " previewHeight=" + this.f11179M);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0285 A[Catch:{ Exception -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0286 A[Catch:{ Exception -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0255 A[Catch:{ Exception -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0256 A[Catch:{ Exception -> 0x0298 }] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12127f(boolean r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r12)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f11164a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 5181(0x143d, float:7.26E-42)
            r2 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            com.meizu.media.camera.util.ac$a r1 = f11166b
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
            com.meizu.media.camera.CameraActivity r1 = r11.f11211c
            android.content.Intent r1 = r1.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r11.m12108aw()
            r11.f11230z = r8
            boolean r2 = r11.f11218n
            if (r2 == 0) goto L_0x0091
            if (r1 == 0) goto L_0x0091
            java.lang.String r2 = "output"
            android.os.Parcelable r2 = r1.getParcelable(r2)
            android.net.Uri r2 = (android.net.Uri) r2
            boolean r3 = r11.f11180N
            if (r3 == 0) goto L_0x006c
            java.lang.String r2 = "output_video"
            android.os.Parcelable r2 = r1.getParcelable(r2)
            android.net.Uri r2 = (android.net.Uri) r2
        L_0x006c:
            if (r2 == 0) goto L_0x0085
            android.content.ContentResolver r3 = r11.f11215g     // Catch:{ FileNotFoundException -> 0x007b }
            java.lang.String r4 = "rw"
            android.os.ParcelFileDescriptor r3 = r3.openFileDescriptor(r2, r4)     // Catch:{ FileNotFoundException -> 0x007b }
            r11.f11226v = r3     // Catch:{ FileNotFoundException -> 0x007b }
            r11.f11229y = r2     // Catch:{ FileNotFoundException -> 0x007b }
            goto L_0x0085
        L_0x007b:
            r2 = move-exception
            com.meizu.media.camera.util.ac$a r3 = f11166b
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r2)
        L_0x0085:
            boolean r2 = r11.f11180N
            if (r2 == 0) goto L_0x0091
            java.lang.String r2 = "meizu_video_record_max_size"
            long r1 = r1.getLong(r2)
            r11.f11182P = r1
        L_0x0091:
            if (r12 == 0) goto L_0x009a
            android.media.MediaRecorder r1 = new android.media.MediaRecorder
            r1.<init>()
            r11.f11219o = r1
        L_0x009a:
            android.media.MediaRecorder r1 = r11.f11219o
            if (r1 != 0) goto L_0x00a6
            com.meizu.media.camera.util.ac$a r12 = f11166b
            java.lang.String r0 = "MediaRecorder has been release."
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r0)
            return
        L_0x00a6:
            com.meizu.media.camera.mode.h r1 = r11.f11193aa
            com.meizu.media.camera.e r1 = r1.mo17902aE()
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
            boolean r2 = r11.f11183Q
            r1.mo19458a((android.view.Surface) r3, (boolean) r2)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            com.meizu.media.camera.camcontroller.e r1 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r1
            android.media.MediaRecorder r2 = r11.f11219o
            java.lang.Object r1 = r1.mo19730a()
            android.hardware.Camera r1 = (android.hardware.Camera) r1
            r2.setCamera(r1)
            android.media.MediaRecorder r1 = r11.f11219o
            r1.setVideoSource(r0)
            goto L_0x0104
        L_0x00ee:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0104
            android.media.MediaRecorder r1 = r11.f11219o
            r2 = 2
            r1.setVideoSource(r2)
        L_0x0104:
            boolean r1 = r11.f11183Q
            r2 = 5
            if (r1 == 0) goto L_0x0169
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            int r4 = r4.mo20366e()
            r1.setOutputFormat(r4)
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            int r4 = r4.mo20365d()
            r1.setVideoFrameRate(r4)
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            int r4 = r4.mo20363b()
            com.meizu.media.camera.m r5 = r11.f11168B
            int r5 = r5.mo20364c()
            r1.setVideoSize(r4, r5)
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            int r4 = r4.mo20367f()
            r1.setVideoEncodingBitRate(r4)
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            int r4 = r4.mo20368g()
            r1.setVideoEncoder(r4)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 != 0) goto L_0x014e
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14053w
            if (r1 == 0) goto L_0x019f
        L_0x014e:
            com.meizu.media.camera.l r1 = r11.f11216l
            java.lang.String r1 = r1.mo20356u()
            if (r1 == 0) goto L_0x019f
            java.lang.String r4 = "off"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x019f
            android.media.MediaRecorder r4 = r11.f11219o
            int r1 = java.lang.Integer.parseInt(r1)
            double r5 = (double) r1
            r4.setCaptureRate(r5)
            goto L_0x019f
        L_0x0169:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13841U
            if (r1 == 0) goto L_0x0171
            boolean r1 = r11.f11184R
            if (r1 != 0) goto L_0x0183
        L_0x0171:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x0179
            boolean r1 = r11.f11184R
            if (r1 != 0) goto L_0x0183
        L_0x0179:
            com.meizu.media.camera.m r1 = r11.f11168B
            int r1 = r1.mo20369h()
            int r4 = com.meizu.media.camera.util.DeviceHelper.f14003cx
            if (r1 != r4) goto L_0x018b
        L_0x0183:
            com.meizu.media.camera.m r1 = r11.f11168B
            android.media.MediaRecorder r4 = r11.f11219o
            r1.mo20362a(r4)
            goto L_0x019f
        L_0x018b:
            boolean r1 = r11.f11197ae
            if (r1 != 0) goto L_0x0194
            android.media.MediaRecorder r1 = r11.f11219o
            r1.setAudioSource(r2)
        L_0x0194:
            android.media.MediaRecorder r1 = r11.f11219o
            com.meizu.media.camera.m r4 = r11.f11168B
            android.media.CamcorderProfile r4 = r4.mo20360a()
            r1.setProfile(r4)
        L_0x019f:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r1 == 0) goto L_0x01a7
            boolean r1 = r11.f11183Q
            if (r1 != 0) goto L_0x01ae
        L_0x01a7:
            android.media.MediaRecorder r1 = r11.f11219o
            int r4 = r11.f11169C
            r1.setMaxDuration(r4)
        L_0x01ae:
            boolean r1 = r11.f11197ae
            if (r1 == 0) goto L_0x01d8
            com.meizu.media.camera.util.ac$a r1 = f11166b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "TimeLapseCaptureMs = "
            r4.append(r5)
            int r5 = r11.f11198ag
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r4)
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r1 = r11.f11198ag
            double r6 = (double) r1
            double r4 = r4 / r6
            android.media.MediaRecorder r1 = r11.f11219o
            r1.setCaptureRate(r4)
        L_0x01d8:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13861aN
            if (r1 == 0) goto L_0x01ff
            android.media.MediaRecorder r1 = r11.f11219o     // Catch:{ Exception -> 0x01f7 }
            java.lang.String r4 = "setParametersEx"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x01f7 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r8] = r6     // Catch:{ Exception -> 0x01f7 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01f7 }
            java.lang.String r7 = "camera-csc=1"
            r6[r8] = r7     // Catch:{ Exception -> 0x01f7 }
            com.meizu.media.camera.util.C2634am.m15993a((java.lang.Object) r1, (java.lang.String) r4, (java.lang.Class<?>[]) r5, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x01f7 }
            com.meizu.media.camera.util.ac$a r1 = f11166b     // Catch:{ Exception -> 0x01f7 }
            java.lang.String r4 = "MediaRecorder set csc"
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r4)     // Catch:{ Exception -> 0x01f7 }
            goto L_0x01ff
        L_0x01f7:
            r1 = move-exception
            com.meizu.media.camera.util.ac$a r4 = f11166b
            java.lang.String r5 = "MediaRecorder setParametersEx failed! "
            com.meizu.media.camera.util.LogUtil.m15953c(r4, r5, r1)
        L_0x01ff:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02a0
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13893at     // Catch:{ Exception -> 0x0298 }
            if (r1 == 0) goto L_0x0226
            android.media.MediaRecorder r1 = r11.f11219o     // Catch:{ Exception -> 0x0298 }
            java.lang.String r4 = "setParametersEx"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0298 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r8] = r6     // Catch:{ Exception -> 0x0298 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0298 }
            java.lang.String r7 = "enable-highspl-effect=1"
            r6[r8] = r7     // Catch:{ Exception -> 0x0298 }
            com.meizu.media.camera.util.C2634am.m15993a((java.lang.Object) r1, (java.lang.String) r4, (java.lang.Class<?>[]) r5, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x0298 }
        L_0x0226:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13862aO     // Catch:{ Exception -> 0x0298 }
            if (r1 == 0) goto L_0x02a0
            com.meizu.media.camera.m r1 = r11.f11168B     // Catch:{ Exception -> 0x0298 }
            int r1 = r1.mo20369h()     // Catch:{ Exception -> 0x0298 }
            if (r1 == r2) goto L_0x023e
            com.meizu.media.camera.m r1 = r11.f11168B     // Catch:{ Exception -> 0x0298 }
            int r1 = r1.mo20369h()     // Catch:{ Exception -> 0x0298 }
            r4 = 6
            if (r1 != r4) goto L_0x023c
            goto L_0x023e
        L_0x023c:
            r1 = 0
            goto L_0x023f
        L_0x023e:
            r1 = 1
        L_0x023f:
            com.meizu.media.camera.util.ac$a r4 = f11166b     // Catch:{ Exception -> 0x0298 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0298 }
            r5.<init>()     // Catch:{ Exception -> 0x0298 }
            java.lang.String r6 = "set mmf-camera-vdis="
            r5.append(r6)     // Catch:{ Exception -> 0x0298 }
            boolean r6 = r11.f11197ae     // Catch:{ Exception -> 0x0298 }
            if (r6 != 0) goto L_0x0259
            boolean r6 = r11.f11183Q     // Catch:{ Exception -> 0x0298 }
            if (r6 != 0) goto L_0x0259
            if (r1 != 0) goto L_0x0256
            goto L_0x0259
        L_0x0256:
            java.lang.String r6 = "on"
            goto L_0x025b
        L_0x0259:
            java.lang.String r6 = "off"
        L_0x025b:
            r5.append(r6)     // Catch:{ Exception -> 0x0298 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0298 }
            com.meizu.media.camera.util.LogUtil.m15952c(r4, r5)     // Catch:{ Exception -> 0x0298 }
            android.media.MediaRecorder r4 = r11.f11219o     // Catch:{ Exception -> 0x0298 }
            java.lang.String r5 = "setParametersEx"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0298 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r8] = r7     // Catch:{ Exception -> 0x0298 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0298 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0298 }
            r9.<init>()     // Catch:{ Exception -> 0x0298 }
            java.lang.String r10 = "mmf-camera-vdis="
            r9.append(r10)     // Catch:{ Exception -> 0x0298 }
            boolean r10 = r11.f11197ae     // Catch:{ Exception -> 0x0298 }
            if (r10 != 0) goto L_0x0289
            boolean r10 = r11.f11183Q     // Catch:{ Exception -> 0x0298 }
            if (r10 != 0) goto L_0x0289
            if (r1 != 0) goto L_0x0286
            goto L_0x0289
        L_0x0286:
            java.lang.String r1 = "on"
            goto L_0x028b
        L_0x0289:
            java.lang.String r1 = "off"
        L_0x028b:
            r9.append(r1)     // Catch:{ Exception -> 0x0298 }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0298 }
            r7[r8] = r1     // Catch:{ Exception -> 0x0298 }
            com.meizu.media.camera.util.C2634am.m15993a((java.lang.Object) r4, (java.lang.String) r5, (java.lang.Class<?>[]) r6, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x0298 }
            goto L_0x02a0
        L_0x0298:
            r1 = move-exception
            com.meizu.media.camera.util.ac$a r4 = f11166b
            java.lang.String r5 = "MediaRecorder setParametersEx failed! "
            com.meizu.media.camera.util.LogUtil.m15953c(r4, r5, r1)
        L_0x02a0:
            r11.m12102aq()
            android.os.ParcelFileDescriptor r1 = r11.f11226v
            if (r1 == 0) goto L_0x02b3
            android.media.MediaRecorder r1 = r11.f11219o
            android.os.ParcelFileDescriptor r4 = r11.f11226v
            java.io.FileDescriptor r4 = r4.getFileDescriptor()
            r1.setOutputFile(r4)
            goto L_0x02c3
        L_0x02b3:
            com.meizu.media.camera.m r1 = r11.f11168B
            int r1 = r1.mo20366e()
            r11.m12132h((int) r1)
            android.media.MediaRecorder r1 = r11.f11219o
            java.lang.String r4 = r11.f11225u
            r1.setOutputFile(r4)
        L_0x02c3:
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = r1.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02ec
            r1 = 23
            if (r12 == 0) goto L_0x02e1
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r1) goto L_0x02e1
            android.view.Surface r12 = android.media.MediaCodec.createPersistentInputSurface()
            r11.f11220p = r12
        L_0x02e1:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r1) goto L_0x02ec
            android.media.MediaRecorder r12 = r11.f11219o
            android.view.Surface r1 = r11.f11220p
            r12.setInputSurface(r1)
        L_0x02ec:
            com.meizu.media.camera.mode.h r12 = r11.f11193aa
            long r4 = r12.mo18197dU()
            r6 = 105906176(0x6500000, double:5.2324603E-316)
            long r4 = r4 - r6
            int r12 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            r6 = 4294967296(0x100000000, double:2.121995791E-314)
            r9 = 0
            if (r12 < r1) goto L_0x030f
            long r6 = r11.f11182P
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x030b
            r12 = 1
            goto L_0x030c
        L_0x030b:
            r12 = 0
        L_0x030c:
            r11.f11177K = r12
            goto L_0x031f
        L_0x030f:
            r11.f11177K = r8
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0317
            r4 = r6
            goto L_0x031f
        L_0x0317:
            long r6 = r11.f11182P
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x031f
            r11.f11177K = r0
        L_0x031f:
            long r6 = r11.f11182P
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x032d
            long r6 = r11.f11182P
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x032d
            long r4 = r11.f11182P
        L_0x032d:
            android.media.MediaRecorder r12 = r11.f11219o     // Catch:{ RuntimeException -> 0x0332 }
            r12.setMaxFileSize(r4)     // Catch:{ RuntimeException -> 0x0332 }
        L_0x0332:
            com.meizu.media.camera.mode.h r12 = r11.f11193aa
            int r12 = r12.mo18194dR()
            r1 = -1
            if (r12 == r1) goto L_0x034c
            com.meizu.media.camera.mode.h r12 = r11.f11193aa
            int r12 = r12.mo18211di()
            com.meizu.media.camera.mode.h r1 = r11.f11193aa
            int r1 = r1.mo18194dR()
            int r12 = com.meizu.media.camera.util.CameraUtil.m15882c((int) r12, (int) r1)
            goto L_0x034d
        L_0x034c:
            r12 = 0
        L_0x034d:
            android.media.MediaRecorder r1 = r11.f11219o
            r1.setOrientationHint(r12)
            com.meizu.media.camera.util.ac$a r12 = f11166b     // Catch:{ IOException -> 0x0368 }
            java.lang.String r1 = "mediaRecorder.prepare() start"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r1)     // Catch:{ IOException -> 0x0368 }
            android.media.MediaRecorder r12 = r11.f11219o     // Catch:{ IOException -> 0x0368 }
            r12.prepare()     // Catch:{ IOException -> 0x0368 }
            r11.f11195ac = r0     // Catch:{ IOException -> 0x0368 }
            com.meizu.media.camera.util.ac$a r12 = f11166b     // Catch:{ IOException -> 0x0368 }
            java.lang.String r1 = "mediaRecorder.prepare() finish"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r12, (java.lang.String) r1)     // Catch:{ IOException -> 0x0368 }
            goto L_0x038f
        L_0x0368:
            r12 = move-exception
            com.meizu.media.camera.util.ac$a r1 = f11166b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "prepare failed for "
            r4.append(r5)
            java.lang.String r5 = r11.f11225u
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15950b(r1, r4, r12)
            int r1 = r11.f11191Y
            int r1 = r1 + r0
            r11.f11191Y = r1
            int r0 = r11.f11191Y
            if (r0 >= r2) goto L_0x039c
            r11.m12080a((android.view.Surface) r3)
            r11.f11195ac = r8
        L_0x038f:
            r11.f11191Y = r8
            android.media.MediaRecorder r12 = r11.f11219o
            r12.setOnErrorListener(r11)
            android.media.MediaRecorder r12 = r11.f11219o
            r12.setOnInfoListener(r11)
            return
        L_0x039c:
            r11.m12107av()
            r11.f11191Y = r8
            android.media.MediaRecorder r0 = r11.f11219o
            r0.release()
            android.view.Surface r0 = r11.f11220p
            r0.release()
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "MediaRecorder.prepare() more than 5 times!!!"
            r0.<init>(r1, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.VideoMode.m12127f(boolean):void");
    }

    /* renamed from: aq */
    private void m12102aq() {
        Location a;
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5182, new Class[0], Void.TYPE).isSupported && (a = this.f11193aa.mo18192dP().mo19017a(this.f11223s)) != null) {
            this.f11219o.setLocation((float) a.getLatitude(), (float) a.getLongitude());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ar */
    public void m12103ar() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5183, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f11172F) {
                LogUtil.C2630a aVar = f11166b;
                LogUtil.m15952c(aVar, "Releasing media recorder, " + this.f11219o);
                if (this.f11219o != null) {
                    m12107av();
                    this.f11219o.reset();
                    this.f11219o.release();
                    this.f11219o = null;
                    this.f11195ac = false;
                }
                this.f11225u = null;
            }
        }
    }

    /* renamed from: as */
    private void m12104as() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5184, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11166b, "reset media recorder.");
            if (this.f11219o != null) {
                m12107av();
                this.f11219o.reset();
                this.f11195ac = false;
            }
            this.f11225u = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: au */
    public void m12106au() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5185, new Class[0], Void.TYPE).isSupported) {
            m12130g(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m12130g(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5186, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) || !DeviceHelper.f13862aO) {
            return;
        }
        if ((this.f11168B.mo20369h() == 5 || this.f11168B.mo20369h() == 6 || this.f11168B.mo20369h() == DeviceHelper.f14003cx || this.f11168B.mo20369h() == DeviceHelper.f14004cy || (this.f11168B.mo20369h() == DeviceHelper.f14005cz && DeviceHelper.f13859aL)) && !this.f11183Q) {
            CameraController.m8868g().mo19503c(z);
        }
    }

    /* renamed from: a */
    private void m12080a(Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f11164a, false, 5187, new Class[]{Surface.class}, Void.TYPE).isSupported) {
            m12104as();
            this.f11223s = System.currentTimeMillis();
            m12127f(false);
            CameraController.m8868g().mo19458a(surface, this.f11183Q);
        }
    }

    /* renamed from: av */
    private void m12107av() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5188, new Class[0], Void.TYPE).isSupported && this.f11225u != null) {
            File file = new File(this.f11225u);
            if (file.length() == 0 && file.delete()) {
                LogUtil.C2630a aVar = f11166b;
                LogUtil.m15952c(aVar, "Empty video file deleted: " + this.f11225u);
                this.f11225u = null;
            }
        }
    }

    /* renamed from: aw */
    private void m12108aw() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5189, new Class[0], Void.TYPE).isSupported && this.f11226v != null) {
            try {
                this.f11226v.close();
            } catch (IOException e) {
                LogUtil.m15950b(f11166b, "Fail to close fd", e);
            }
            this.f11226v = null;
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{mediaRecorder, new Integer(i), new Integer(i2)}, this, f11164a, false, 5190, new Class[]{MediaRecorder.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15949b(aVar, "MediaRecorder error. what=" + i + ". extra=" + i2);
            if (i == 1) {
                m12133h(false);
                this.f11193aa.mo18234ee();
            }
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, final int i, int i2) {
        Object[] objArr = {mediaRecorder, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5191, new Class[]{MediaRecorder.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.f11211c != null) {
            this.f11211c.runOnUiThread(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11242a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f11242a, false, 5247, new Class[0], Void.TYPE).isSupported) {
                        if (i == 800) {
                            LogUtil.m15952c(VideoMode.f11166b, "media recoder reached max duration");
                            if (VideoMode.this.f11221q) {
                                VideoMode.this.m12072Q();
                            }
                        } else if (i == 801) {
                            LogUtil.m15952c(VideoMode.f11166b, "media recoder reached max size");
                            if (VideoMode.this.f11221q) {
                                VideoMode.this.m12072Q();
                            }
                            int i = R.string.video_reach_size_limit;
                            if (!VideoMode.this.f11177K) {
                                boolean unused = VideoMode.this.f11176J = true;
                            }
                            if (VideoMode.this.f11177K) {
                                i = R.string.mz_space_is_low;
                                VideoMode.this.f11193aa.mo18234ee();
                            }
                            VideoMode.this.f11212d.mo21566b(i, false);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: ax */
    private boolean m12109ax() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5192, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11218n || SystemClock.uptimeMillis() - this.f11222r >= 500) {
            return true;
        }
        if (!TextUtils.isEmpty(this.f11225u)) {
            m12120d(this.f11225u);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ay */
    public void m12110ay() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5193, new Class[0], Void.TYPE).isSupported) {
            if (CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
                return;
            }
            if (DeviceHelper.f13860aM) {
                this.f11193aa.mo17914ak().mo20221f();
            } else {
                this.f11193aa.mo17914ak().mo20238q();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: az */
    public void m12111az() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5194, new Class[0], Void.TYPE).isSupported) {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f11227w)) {
                bitmap = Thumbnail.m7941a(this.f11227w, this.f11178L, new long[0]);
            }
            if (bitmap != null) {
                bitmap = CameraUtil.m15872b(bitmap, 0, false);
            }
            this.f11212d.mo21515a(bitmap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aA */
    public void m12085aA() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5195, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f11166b, "startVideoRecording");
            if (DeviceHelper.f13838R && this.f11221q) {
                this.f11193aa.mo18275x(1);
            }
            this.f11229y = null;
            m12092aH();
            if (this.f11193aa.mo17859H()) {
                m12132h(this.f11168B.mo20366e());
                boolean a = this.f11199ah.mo20137a(this.f11206ao, this.f11207ap, this.f11201aj, this.f11200ai.mo20112a(), this.f11200ai.mo20114b(), this.f11228x, true, this.f11168B);
                this.f11193aa.mo18064b(this.f11199ah.mo20138b());
                if (a) {
                    this.f11202ak = true;
                    this.f11204am = false;
                    this.f11200ai.mo20115c();
                    LogUtil.m15952c(f11166b, "start record");
                    this.f11193aa.mo18277y(this.f11205an);
                    mo20542U().mo21631s();
                } else {
                    LogUtil.m15949b(f11166b, "init recorder failed!");
                    return;
                }
            } else {
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    m12127f(true);
                } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                    m12080a(this.f11220p);
                }
                if (this.f11219o == null) {
                    this.f11221q = false;
                    LogUtil.m15949b(f11166b, "Fail to initialize media recorder");
                    return;
                }
                mo20542U().mo21631s();
                try {
                    LogUtil.m15952c(LogUtil.f14072b, "startVideoRecording");
                    this.f11219o.start();
                } catch (RuntimeException e) {
                    LogUtil.m15950b(f11166b, "Could not start media recorder. ", e);
                    if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                        m12103ar();
                        CameraController.m8868g().mo19441E();
                    } else if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                        m12080a((Surface) null);
                    }
                    if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.ARCSOFT) {
                        m12130g(false);
                    }
                    m12093aI();
                    if ("already exists".equals(e.getMessage())) {
                        LogUtil.m15949b(f11166b, "Record device is occupied.");
                        this.f11212d.mo21566b((int) R.string.mz_record_device_occupied, false);
                    }
                    mo20542U().mo21634t();
                    m12095aj();
                    this.f11221q = false;
                    return;
                }
            }
            Storage.m7750a().mo18652e(false);
            this.f11213e.mo22148c(true);
            this.f11221q = true;
            this.f11212d.mo21569b(this.f11221q, this.f11184R);
            this.f11213e.mo22197v(this.f11221q);
            this.f11193aa.mo17914ak().mo20232k(true);
            this.f11176J = false;
            this.f11222r = SystemClock.uptimeMillis();
            this.f11174H = 0;
            if (this.f11197ae) {
                this.f11189W.mo21792b();
            } else if (!this.f11183Q) {
                this.f11188V.mo21835a(true);
            }
            this.f11212d.mo21532a(true, m12086aB());
            this.f11193aa.mo17914ak().mo20228i(true);
            mo20673q();
            m12089aE();
        }
    }

    /* renamed from: aB */
    private boolean m12086aB() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5196, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraModeType.m10968g();
    }

    /* renamed from: h */
    private void m12133h(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11164a, false, 5197, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15952c(aVar, "stopVideoRecording mPaused:" + this.f11193aa.mo18200dX());
            if (this.f11221q && (this.f11196ad == null || this.f11196ad.mo22613c() != AsyncTaskEx.Status.RUNNING)) {
                this.f11212d.mo21586e(false);
                this.f11214f.removeCallbacks(this.f11208aq);
                mo20542U().mo21634t();
                this.f11212d.mo21532a(false, m12086aB());
                if (this.f11196ad == null || this.f11196ad.mo22613c() != AsyncTaskEx.Status.RUNNING) {
                    this.f11196ad = new C2235b(this.f11219o, z, this.f11167A, this.f11225u, this.f11193aa.mo18200dX(), this.f11193aa.mo17859H());
                    this.f11196ad.mo22614c((Params[]) new Void[0]);
                }
                if (DeviceHelper.f13838R) {
                    this.f11193aa.mo18275x(2);
                }
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2 && !this.f11183Q) {
                    CameraControllerV2 cameraControllerV2 = (CameraControllerV2) CameraController.m8868g();
                    if (Build.VERSION.SDK_INT >= 23) {
                        cameraControllerV2.mo19565ag();
                    }
                }
            }
            CameraController.m8868g().mo19441E();
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && !this.f11218n && !this.f11193aa.mo18200dX()) {
                CameraController.m8868g().mo19458a((Surface) null, this.f11183Q);
            }
            if ((CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) && !DeviceHelper.f13860aM) {
                this.f11193aa.mo17914ak().mo20239r();
            }
            if (!(CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1 || !DeviceHelper.f14027ds)) {
                mo20542U().mo21511a(CameraController.m8868g().mo19522k().mo19733b(), false, false);
            }
            this.f11193aa.mo17914ak().mo20228i(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aC */
    public void m12087aC() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5198, new Class[0], Void.TYPE).isSupported && m12088aD() != null) {
            m12106au();
            this.f11193aa.mo18213dk();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12079a(ContentValues contentValues, String str) {
        Class[] clsArr = {ContentValues.class, String.class};
        if (!PatchProxy.proxy(new Object[]{contentValues, str}, this, f11164a, false, 5199, clsArr, Void.TYPE).isSupported) {
            if (this.f11226v == null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f11222r;
                if (!this.f11177K || m12109ax()) {
                    if (this.f11197ae) {
                        uptimeMillis = m12112b(uptimeMillis);
                    }
                    String str2 = str;
                    this.f11211c.mo17689p().mo17830a(str2, uptimeMillis, contentValues, this.f11209ar, this.f11215g);
                }
            }
            this.f11167A = null;
        }
    }

    /* renamed from: d */
    private void m12120d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11164a, false, 5200, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15952c(aVar, "Deleting video " + str);
            if (!new File(str).delete()) {
                LogUtil.C2630a aVar2 = f11166b;
                LogUtil.m15952c(aVar2, "Could not delete " + str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aD */
    public Bitmap m12088aD() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5201, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Bitmap bitmap = null;
        if (this.f11226v != null) {
            bitmap = Thumbnail.m7940a(this.f11226v.getFileDescriptor(), this.f11178L);
        } else if (this.f11229y != null) {
            try {
                bitmap = Thumbnail.m7940a(this.f11215g.openFileDescriptor(this.f11229y, "r").getFileDescriptor(), this.f11178L);
            } catch (FileNotFoundException e) {
                LogUtil.m15949b(f11166b, e.toString());
            }
        } else if (!TextUtils.isEmpty(this.f11227w)) {
            bitmap = Thumbnail.m7941a(this.f11227w, this.f11178L, new long[0]);
        }
        if (bitmap == null) {
            return bitmap;
        }
        if (this.f11218n) {
            return CameraUtil.m15820a(bitmap, 0, false);
        }
        return CameraUtil.m15872b(bitmap, 0, false);
    }

    /* renamed from: aE */
    private void m12089aE() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5202, new Class[0], Void.TYPE).isSupported) {
            this.f11214f.removeMessages(3);
            this.f11211c.getWindow().addFlags(128);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aF */
    public void m12090aF() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5203, new Class[0], Void.TYPE).isSupported) {
            this.f11214f.removeMessages(3);
            this.f11211c.getWindow().addFlags(128);
            this.f11214f.sendEmptyMessageDelayed(3, 120000);
        }
    }

    /* renamed from: aG */
    private void m12091aG() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5204, new Class[0], Void.TYPE).isSupported) {
            this.f11180N = "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(this.f11211c.getIntent().getAction());
            this.f11182P = this.f11211c.getIntent().getLongExtra("android.intent.extra.sizeLimit", this.f11182P);
            if (this.f11211c.getIntent().getIntExtra("isFlymeMms", -1) == 2) {
                this.f11181O = true;
            }
        }
    }

    /* renamed from: i */
    private void m12135i(boolean z) {
        String str;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11164a, false, 5205, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13840T || DeviceHelper.f14053w) {
                LogUtil.C2630a aVar = f11166b;
                LogUtil.m15952c(aVar, "setSlowHALParamsForQcomm: " + this.f11183Q);
                CameraController g = CameraController.m8868g();
                if (z) {
                    str = "off";
                } else {
                    str = this.f11183Q ? DeviceHelper.f14038h.getValue() : "off";
                }
                g.mo19471a("video-hfr", str, new boolean[0]);
            }
        }
    }

    /* renamed from: b */
    public static boolean m12115b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11164a, true, 5206, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ("android.media.action.VIDEO_CAPTURE".equals(str) || "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m12118c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11164a, true, 5207, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ("android.media.action.VIDEO_CAPTURE".equals(str) || "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(str) || "meizu.intent.action.shortcut.BACK_VIDEO".equals(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m12083a(Intent intent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent}, (Object) null, f11164a, true, 5208, new Class[]{Intent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (intent == null) {
            return false;
        }
        long longExtra = intent.getLongExtra("android.intent.extra.sizeLimit", 0);
        return longExtra != 0 && longExtra <= 276480;
    }

    /* renamed from: B */
    public void mo20664B() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, ARPMessageType.MSG_TYPE_VIDEO, new Class[0], Void.TYPE).isSupported) {
            if (this.f11230z) {
                this.f11215g.delete(this.f11229y, (String) null, (String[]) null);
            }
            this.f11193aa.mo18060b(0, new Intent());
        }
    }

    /* renamed from: a */
    public void mo20667a(boolean z) {
        boolean z2 = true;
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11164a, false, 5214, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || DeviceHelper.f13853aF || DeviceHelper.f13849aB || DeviceHelper.f13840T) {
            return;
        }
        if (z) {
            CameraController.m8868g().mo19471a("recording-hint", "false", new boolean[0]);
            if (this.f11185S != -1) {
                CameraController.m8868g().mo19506d(this.f11185S, new boolean[0]);
            }
            this.f11185S = -1;
            return;
        }
        CameraController.m8868g().mo19471a("recording-hint", "true", new boolean[0]);
        this.f11185S = CameraController.m8868g().mo19537t();
        CameraController.m8868g().mo19506d(this.f11168B.mo20365d(), new boolean[0]);
        if (this.f11183Q || !DeviceHelper.f13838R) {
            z2 = false;
        }
        if (z2) {
            this.f11216l.mo20317a(20, new boolean[0]);
        } else {
            this.f11216l.mo20317a(4, new boolean[0]);
        }
    }

    /* renamed from: d */
    public void mo20670d(boolean z) {
        if (z) {
            boolean z2 = this.f11183Q;
        }
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5215, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f11193aa.mo18211di() == 1) {
            return CameraController.FocusMode.FIXED;
        }
        if (DeviceHelper.f13860aM) {
            return CameraController.FocusMode.CONTINUOUS_VIDEO;
        }
        return CameraController.FocusMode.AUTO;
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        if (this.f11183Q) {
            return CameraModeType.ModeType.SLOWMOTION;
        }
        if (this.f11197ae) {
            return CameraModeType.ModeType.TIMELAPSE;
        }
        return CameraModeType.ModeType.VIDEO;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5216, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15942a(aVar, "release VideoMode, " + this);
            if (this.f11196ad != null) {
                this.f11196ad.mo22612b(true);
                this.f11196ad = null;
            }
            if (!this.f11218n) {
                m12103ar();
                m12105at();
            }
            m12106au();
            if (this.f11183Q) {
                this.f11183Q = false;
                this.f11212d.mo21599h(false);
                this.f11187U.mo22595a();
                if (DeviceHelper.f13945bs != -1) {
                    this.f11193aa.mo18267u().mo22155e(-1);
                }
            } else if (this.f11197ae) {
                this.f11189W.mo21787a();
                mo20669d(0);
                this.f11212d.mo21630r(false);
                this.f11212d.mo21639u(false);
            } else {
                this.f11188V.mo21837b();
            }
            if (this.f11190X != null) {
                this.f11190X.mo21829e();
            }
            if (DeviceHelper.f13844X) {
                if (this.f11217m.hasMessages(5)) {
                    this.f11217m.removeMessages(5);
                }
                m12137j(false);
            }
            this.f11216l.mo20323a(false, false, false);
            this.f11212d.mo21533a(true, DeviceHelper.f13910bJ == CameraController.CameraApi.API1, false);
            m12135i(true);
            if (DeviceUtil.m16200b()) {
                m12123e(true);
            }
            EffectRenderContext.m4369h().mo14229m(false);
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11164a, false, 5217, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f11166b, "onModeMenuVisibilityChanged");
            if (z) {
                if (!this.f11183Q && !this.f11197ae && this.f11188V != null) {
                    this.f11188V.mo21838b(true);
                }
            } else if (this.f11212d != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                m12071P();
                if (!this.f11183Q && !this.f11197ae && this.f11188V != null) {
                    this.f11188V.mo21838b(false);
                }
            }
            if (z2) {
                return;
            }
            if (this.f11183Q && this.f11187U != null) {
                this.f11187U.mo22600a(!z);
            } else if (this.f11197ae && this.f11189W != null) {
                this.f11189W.mo21791a(!z);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5218, new Class[0], Void.TYPE).isSupported) {
            m12071P();
            if (this.f11183Q && this.f11187U != null) {
                this.f11187U.mo22596a(this.f11186T);
            } else if (this.f11197ae && this.f11189W != null) {
                this.f11189W.mo21790a((MzTimeLapseRender.C2752a) this);
            } else if (this.f11188V != null) {
                this.f11188V.mo21836a(this.f11171E, this.f11184R);
            }
            if (this.f11190X != null) {
                this.f11190X.mo21826b();
            }
        }
    }

    /* renamed from: ag */
    public void mo20552ag() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5219, new Class[0], Void.TYPE).isSupported) {
            if (this.f11183Q && this.f11193aa.mo17914ak() != null && !DeviceHelper.f13860aM) {
                this.f11193aa.mo17914ak().mo20210a(false);
            }
            if (this.f11183Q && DeviceHelper.f13945bs != -1) {
                this.f11193aa.mo18267u().mo22155e(DeviceHelper.f13945bs);
            }
            if (this.f11190X != null) {
                this.f11190X.mo21827c();
            }
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5220, new Class[0], Void.TYPE).isSupported) {
            m12123e(false);
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5221, new Class[0], Void.TYPE).isSupported) {
            if (!this.f11218n && !this.f11221q) {
                m12103ar();
                m12105at();
            }
            m12106au();
            this.f11217m.removeMessages(5);
            if (this.f11190X != null) {
                this.f11190X.mo21824a(this.f11193aa.mo18211di());
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5222, new Class[0], Void.TYPE).isSupported) {
            if (!this.f11217m.hasMessages(5)) {
                this.f11217m.sendEmptyMessage(5);
            }
            if (this.f11190X != null) {
                this.f11190X.mo21828d();
            }
        }
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5223, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
            if (!this.f11218n) {
                m12103ar();
                m12105at();
            }
            if (DeviceHelper.f14018dj == DeviceHelper.EIS_TYPE.INVENSENSE) {
                m12106au();
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5224, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            m12071P();
            if (this.f11183Q) {
                if (this.f11187U == null) {
                    this.f11187U = this.f11213e.mo22117af();
                    this.f11187U.mo22597a(this.f11212d);
                }
                this.f11187U.mo22598a(this.f11210as);
                this.f11187U.mo22596a(this.f11186T);
                if (DeviceHelper.f13945bs != -1) {
                    this.f11193aa.mo18267u().mo22155e(DeviceHelper.f13945bs);
                }
            } else if (this.f11197ae) {
                if (this.f11189W == null) {
                    this.f11189W = this.f11213e.mo22118ag();
                    this.f11189W.mo21789a(this.f11212d);
                }
                this.f11189W.mo21790a((MzTimeLapseRender.C2752a) this);
            } else {
                if (this.f11188V == null) {
                    this.f11188V = this.f11213e.mo22119ah();
                    this.f11188V.mo21833a(this.f11212d, new boolean[0]);
                }
                this.f11188V.mo21836a(this.f11171E, this.f11184R);
            }
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2 && this.f11190X == null) {
                this.f11190X = this.f11213e.mo22120ai();
            }
            if (CameraController.m8868g().mo19522k() != null) {
                m12123e(false);
            }
            if (this.f11193aa.mo17914ak() != null) {
                if (!this.f11183Q || !CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2)) {
                    this.f11193aa.mo17914ak().mo20218d(false);
                }
                if (this.f11183Q && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                    this.f11193aa.mo17914ak().mo20210a(false);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return this.f11183Q;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return !this.f11197ae;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11164a, false, 5225, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f11221q) {
            return false;
        }
        mo20412o();
        return true;
    }

    /* renamed from: ac */
    public boolean mo20549ac() {
        return !this.f11221q;
    }

    /* renamed from: k_ */
    public void mo20407k_() {
        if (PatchProxy.proxy(new Object[0], this, f11164a, false, 5226, new Class[0], Void.TYPE).isSupported || !this.f11221q) {
            return;
        }
        if (this.f11196ad == null || this.f11196ad.mo22613c() != AsyncTaskEx.Status.RUNNING) {
            mo20668c();
        }
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return this.f11221q && !this.f11173G;
    }

    /* renamed from: e */
    public void mo20556e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5227, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f11183Q && this.f11187U != null) {
                this.f11187U.mo22601b(i);
            } else if (!this.f11197ae && this.f11188V != null) {
                this.f11188V.mo21832a(i);
            }
        }
    }

    /* renamed from: b */
    private long m12112b(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5228, new Class[]{Long.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        return (long) (((((double) j) / ((double) this.f11198ag)) / ((double) this.f11168B.mo20365d())) * 1000.0d);
    }

    /* renamed from: d */
    public void mo20669d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5230, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f11197ae) {
            this.f11198ag = f11165af[i];
            this.f11189W.mo21788a(i);
            LogUtil.C2630a aVar = LogUtil.f14072b;
            LogUtil.m15942a(aVar, "TimeLapseMode onLapseTimeChange:" + this.f11198ag);
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5231, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
        }
    }

    /* renamed from: F */
    public void mo20382F() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5232, new Class[0], Void.TYPE).isSupported) {
            m12100ao();
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API2) && (this.f11219o == null || this.f11220p == null)) {
                this.f11223s = System.currentTimeMillis();
                synchronized (this.f11172F) {
                    m12127f(true);
                }
            }
            m12135i(false);
        }
    }

    /* renamed from: b */
    public void mo20517b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11164a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5233, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.mo20517b(z);
            if (this.f11197ae) {
                this.f11189W.mo21794d();
            }
        }
    }

    /* renamed from: j */
    private void m12137j(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11164a, false, 5234, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            try {
                Object a = C2634am.m15996a("dalvik.system.VMRuntime", "getRuntime", (Object[]) null);
                if (z) {
                    C2634am.m15993a(a, "setTargetHeapUtilization", (Class<?>[]) new Class[]{Float.TYPE}, new Object[]{Float.valueOf(0.95f)});
                } else {
                    C2634am.m15993a(a, "setTargetHeapUtilization", (Class<?>[]) new Class[]{Float.TYPE}, new Object[]{Float.valueOf(0.75f)});
                }
                LogUtil.C2630a aVar = f11166b;
                LogUtil.m15942a(aVar, "after handleTargetHeapUtilization, value is " + C2634am.m15994a(a, "getTargetHeapUtilization", (Object[]) null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: aH */
    private void m12092aH() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5235, new Class[0], Void.TYPE).isSupported && this.f11183Q) {
            CameraController.FocusMode aa = CameraController.m8868g().mo19483aa();
            if (CameraController.FocusMode.CONTINUOUS_VIDEO == aa) {
                CameraController.m8868g().mo19467a(CameraController.FocusMode.AUTO, new boolean[0]);
                if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                    CameraController.m8868g().mo19480a(true);
                }
                if (!(this.f11193aa == null || this.f11193aa.mo17914ak() == null)) {
                    this.f11193aa.mo17914ak().mo20220e(true);
                }
            }
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15952c(aVar, "lock caf :" + aa);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aI */
    public void m12093aI() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5236, new Class[0], Void.TYPE).isSupported && this.f11183Q) {
            if (!(this.f11193aa == null || this.f11193aa.mo17914ak() == null)) {
                this.f11193aa.mo17914ak().mo20220e(false);
            }
            LogUtil.m15952c(f11166b, "unlock caf");
        }
    }

    /* renamed from: K */
    public String mo20665K() {
        if (this.f11196ad != null) {
            return this.f11196ad.f11258j;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: aJ */
    public void m12094aJ() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5237, new Class[0], Void.TYPE).isSupported && !this.f11203al) {
            this.f11203al = true;
            LogUtil.m15952c(f11166b, "stopEffectRecording");
            this.f11200ai.mo20116d();
            this.f11199ah.mo20141d();
            this.f11193aa.mo18232ec();
        }
    }

    /* renamed from: a */
    public void mo20118a(@Nullable byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f11164a, false, 5238, new Class[]{byte[].class}, Void.TYPE).isSupported && this.f11202ak && !this.f11204am) {
            this.f11199ah.mo20139b(bArr);
        }
    }

    /* renamed from: a */
    public void mo20142a(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11164a, false, 5239, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f11166b;
            LogUtil.m15952c(aVar, "onVideoSaved: " + str);
            this.f11203al = false;
            this.f11202ak = false;
            long uptimeMillis = SystemClock.uptimeMillis() - this.f11222r;
            this.f11167A.put("_size", Long.valueOf(new File(str).length()));
            this.f11167A.put("duration", Long.valueOf(uptimeMillis));
            if (!this.f11177K || m12109ax()) {
                if (this.f11197ae) {
                    uptimeMillis = m12112b(uptimeMillis);
                }
                String str2 = str;
                this.f11211c.mo17689p().mo17830a(str2, uptimeMillis, this.f11167A, this.f11209ar, this.f11193aa.mo18187dK());
            }
            this.f11211c.runOnUiThread(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11245a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f11245a, false, 5248, new Class[0], Void.TYPE).isSupported) {
                        VideoMode.this.f11212d.mo21586e(true);
                    }
                }
            });
        }
    }

    /* renamed from: L */
    public void mo20666L() {
        if (!PatchProxy.proxy(new Object[0], this, f11164a, false, 5240, new Class[0], Void.TYPE).isSupported && this.f11202ak) {
            this.f11199ah.mo20140c();
        }
    }
}
