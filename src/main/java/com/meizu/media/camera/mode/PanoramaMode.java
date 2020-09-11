package com.meizu.media.camera.mode;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.SensorEvent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.OrientationEventListener;
import com.baidu.p020ar.paddle.PaddleController;
import com.meizu.camera.effectlib.effects.views.EffectRenderContext;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.imageproc.PanoramaStitcher;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p077ui.MzPanoUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.o */
public class PanoramaMode extends CameraMode implements PreviewView.C1193b {

    /* renamed from: J */
    private static final int[] f10957J = new int[2];

    /* renamed from: a */
    public static ChangeQuickRedirect f10958a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10959b = new LogUtil.C2630a("PanoramaMode");

    /* renamed from: A */
    private long f10960A;

    /* renamed from: B */
    private final float f10961B = 1.0E-9f;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f10962C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f10963D;

    /* renamed from: E */
    private int f10964E = -1;

    /* renamed from: F */
    private long f10965F = -1;

    /* renamed from: G */
    private UsageStatsHelper f10966G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public CameraModeListener f10967H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public long f10968I;

    /* renamed from: K */
    private int f10969K;

    /* renamed from: L */
    private int f10970L;

    /* renamed from: M */
    private boolean f10971M = false;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f10972N = false;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f10973O = true;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f10974P = false;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f10975Q = false;

    /* renamed from: R */
    private boolean f10976R = false;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public ArrayList<byte[]> f10977S = new ArrayList<>();

    /* renamed from: T */
    private int f10978T = 4;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f10979U = 0;

    /* renamed from: V */
    private MzCamParamsManager f10980V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public int f10981W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public Handler f10982X = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11012a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f11012a, false, 5004, new Class[]{Message.class}, Void.TYPE).isSupported && message.what == 0) {
                PanoramaMode.this.f10995s.mo17844a((Uri) message.obj);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f10983c = 0;

    /* renamed from: d */
    private int f10984d;

    /* renamed from: e */
    private int f10985e;

    /* renamed from: f */
    private boolean f10986f = false;

    /* renamed from: g */
    private int f10987g;

    /* renamed from: l */
    private int f10988l;

    /* renamed from: m */
    private int f10989m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f10990n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Object f10991o = new Object();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Handler f10992p = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MzPanoUI f10993q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ContentResolver f10994r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public MediaSaveService.C1639d f10995s;

    /* renamed from: t */
    private C2202a f10996t;

    /* renamed from: u */
    private C2203b f10997u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ByteArrayOutputStream f10998v;

    /* renamed from: w */
    private CameraActivity f10999w;

    /* renamed from: x */
    private float f11000x;

    /* renamed from: y */
    private float f11001y;

    /* renamed from: z */
    private boolean f11002z;

    /* renamed from: A */
    public int mo20377A() {
        return -1;
    }

    /* renamed from: a */
    public void mo20386a(int i) {
    }

    /* renamed from: a */
    public void mo20612a(SensorEvent sensorEvent) {
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return false;
    }

    /* renamed from: ae */
    public boolean mo20458ae() {
        return false;
    }

    /* renamed from: c_ */
    public boolean mo20464c_() {
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

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            System.loadLibrary("PanoramaStitcherFor10");
        } else if (Build.VERSION.SDK_INT < 26) {
            System.loadLibrary("PanoramaStitcher");
        } else if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
            System.loadLibrary("PanoramaStitcherForOreo");
        } else {
            System.loadLibrary("PanoramaStitcherForOreoCamera1");
        }
    }

    public PanoramaMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10967H = hVar;
        this.f10980V = lVar;
        EffectRenderContext.m4369h().mo14203c(true);
        this.f10994r = mo20539R().mo18187dK();
        this.f10997u = new C2203b();
        this.f10995s = mo20539R().mo18193dQ();
        this.f10996t = new C2202a(cameraActivity, 2);
        if (this.f10993q == null) {
            this.f10993q = mo20539R().mo18267u().mo22114ac();
            this.f10993q.mo22530a(uVar);
        } else {
            this.f10993q.mo22540d();
        }
        mo20542U().mo21592g(0);
        this.f10986f = false;
        this.f10971M = false;
        this.f10973O = true;
        this.f10976R = false;
        this.f10999w = cameraActivity;
        this.f10966G = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
        if (DeviceHelper.f13840T) {
            this.f10981W = 3;
        } else if (DeviceHelper.f13841U) {
            this.f10981W = 2;
        } else {
            this.f10981W = 1;
        }
    }

    /* renamed from: r */
    private void m11802r() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4979, new Class[0], Void.TYPE).isSupported) {
            mo20541T().mo20317a(16, new boolean[0]);
            Point l = CameraController.m8868g().mo19524l();
            if (l != null) {
                this.f10984d = l.x;
                this.f10985e = l.y;
                this.f10993q.mo22529a(this.f10984d, this.f10985e);
                this.f10976R = true;
            }
        }
    }

    /* renamed from: c */
    public void mo20614c() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4980, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f10991o) {
                if (0 != this.f10983c) {
                    PanoramaStitcher.nativeRelease(this.f10983c);
                    this.f10983c = 0;
                }
                this.f10977S.clear();
                this.f10977S = null;
                System.gc();
                System.runFinalization();
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4981, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10959b, "Panorama mode resume");
            if (!this.f10967H.mo18200dX() && CameraController.m8868g().mo19522k() != null) {
                if (!this.f10976R) {
                    m11802r();
                }
                this.f10993q.mo22535b();
                if (this.f10983c == 0) {
                    if (this.f10977S == null) {
                        this.f10977S = new ArrayList<>();
                    }
                    if (this.f10977S.size() > 0) {
                        this.f10977S.clear();
                    }
                    int i = ((this.f10984d * this.f10985e) * 3) / 2;
                    for (int i2 = 0; i2 < this.f10978T; i2++) {
                        this.f10977S.add(new byte[i]);
                    }
                    this.f10983c = PanoramaStitcher.nativeInit(this.f10984d, this.f10985e, true);
                    LogUtil.C2630a aVar = f10959b;
                    LogUtil.m15952c(aVar, "nativeInit: " + this.f10983c);
                }
                if (this.f10967H != null) {
                    this.f10967H.mo18267u().mo22113ab().setRenderViewCallBackListener(this);
                }
                mo20539R().mo18267u().mo22142b(false);
                if (this.f10996t != null) {
                    this.f10996t.enable();
                }
                if (this.f10997u == null) {
                    this.f10997u = new C2203b();
                }
                EffectRenderContext.m4369h().mo14215g(true);
                this.f10969K = this.f10993q.mo22548l();
                this.f10970L = (this.f10993q.mo22547k() / this.f10969K) - this.f10993q.mo22546j();
                this.f10993q.mo22538c();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e8, code lost:
        r8.f10987g = 0;
        r8.f10988l = 0;
        r8.f10989m = 0;
        r1 = r8.f10962C;
        r8.f10963D = r1;
        r8.f10964E = r1;
        r8.f10990n = 0;
        r8.f10986f = true;
        r8.f10972N = false;
        r8.f10974P = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0102, code lost:
        if (r8.f10965F != -1) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0104, code lost:
        r8.f10965F = r8.f10968I;
        mo20539R().mo18175d(r8.f10965F);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0111, code lost:
        r8.f10975Q = true;
        mo20539R().mo18275x(5);
     */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo20411n() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f10958a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 4982(0x1376, float:6.981E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x001e
            java.lang.Object r0 = r1.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x001e:
            com.meizu.media.camera.util.ac$a r1 = f10959b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onShutterButtonClick mIsSaveComplement : "
            r2.append(r3)
            boolean r3 = r8.f10973O
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "PanoramaMode onShutterButtonClick mIsSaveComplement : "
            r2.append(r3)
            boolean r3 = r8.f10973O
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            boolean r1 = r8.f10973O
            r2 = 1
            if (r1 != 0) goto L_0x0054
            return r2
        L_0x0054:
            com.meizu.media.camera.u r1 = r8.f10788j
            android.view.View r1 = r1.mo21541af()
            r3 = 22560(0x5820, float:3.1613E-41)
            com.meizu.media.camera.util.DeviceUtil.m16194a((android.view.View) r1, (int) r3)
            r3 = 0
            long r5 = r8.f10983c
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x011e
            boolean r1 = r8.f10986f
            if (r1 == 0) goto L_0x0078
            r8.m11770B()
            r0 = -1
            r8.m11786d((int) r0)
            com.meizu.media.camera.ui.v r0 = r8.f10993q
            r0.mo22543g()
            return r2
        L_0x0078:
            com.meizu.media.camera.mode.h r1 = r8.mo20539R()
            r1.mo18230ea()
            com.meizu.media.camera.mode.h r1 = r8.f10967H
            com.meizu.media.camera.h r1 = r1.mo17914ak()
            r1.mo20242u()
            com.meizu.media.camera.ui.v r1 = r8.f10993q
            r1.mo22542f()
            long r3 = java.lang.System.currentTimeMillis()
            r8.f10968I = r3
            com.meizu.media.camera.l r1 = r8.mo20541T()
            r1.mo20341f()
            com.meizu.media.camera.l r1 = r8.mo20541T()
            r1.mo20322a((boolean) r2)
            long r3 = r8.f10983c
            int r1 = r8.f10962C
            int r1 = com.meizu.imageproc.PanoramaStitcher.nativeStartup(r3, r1)
            java.lang.Object r3 = r8.f10991o
            monitor-enter(r3)
            if (r1 == 0) goto L_0x00e7
            com.meizu.media.camera.util.ac$a r4 = f10959b     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r5.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "startup error:"
            r5.append(r6)     // Catch:{ all -> 0x00e5 }
            r5.append(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e5 }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00e5 }
            r8.f10986f = r0     // Catch:{ all -> 0x00e5 }
            java.lang.String r0 = com.meizu.imageproc.PanoramaStitcher.m6360a(r1)     // Catch:{ all -> 0x00e5 }
            r8.m11779a((java.lang.String) r0)     // Catch:{ all -> 0x00e5 }
            com.meizu.media.camera.mode.o$b r0 = r8.f10997u     // Catch:{ all -> 0x00e5 }
            boolean r0 = r0.mo20621a()     // Catch:{ all -> 0x00e5 }
            if (r0 == 0) goto L_0x00de
            com.meizu.media.camera.util.ac$a r0 = f10959b     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "PanoImageSaver isWorking, can not start"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r3)     // Catch:{ all -> 0x00e5 }
            return r2
        L_0x00de:
            long r0 = r8.f10983c     // Catch:{ all -> 0x00e5 }
            com.meizu.imageproc.PanoramaStitcher.nativeRelease(r0)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r3)     // Catch:{ all -> 0x00e5 }
            return r2
        L_0x00e5:
            r0 = move-exception
            goto L_0x011c
        L_0x00e7:
            monitor-exit(r3)     // Catch:{ all -> 0x00e5 }
            r8.f10987g = r0
            r8.f10988l = r0
            r8.f10989m = r0
            int r1 = r8.f10962C
            r8.f10963D = r1
            r8.f10964E = r1
            r8.f10990n = r0
            r8.f10986f = r2
            r8.f10972N = r0
            r8.f10974P = r0
            long r0 = r8.f10965F
            r3 = -1
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0111
            long r0 = r8.f10968I
            r8.f10965F = r0
            com.meizu.media.camera.mode.h r0 = r8.mo20539R()
            long r3 = r8.f10965F
            r0.mo18175d((long) r3)
        L_0x0111:
            r8.f10975Q = r2
            com.meizu.media.camera.mode.h r0 = r8.mo20539R()
            r1 = 5
            r0.mo18275x(r1)
            goto L_0x011e
        L_0x011c:
            monitor-exit(r3)     // Catch:{ all -> 0x00e5 }
            throw r0
        L_0x011e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.PanoramaMode.mo20411n():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11781a(byte[] bArr, int i) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i)}, this, f10958a, false, 4983, new Class[]{byte[].class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f10986f || !this.f10975Q) {
                this.f10972N = true;
                this.f10989m = PanoramaStitcher.nativeGetPanoramaDirectionType(this.f10983c);
                PanoramaStitcher.nativeGetOffsets(this.f10983c, f10957J);
                if (i != 0 && 101 != i && -103 != i && -105 != i && -106 != i) {
                    m11770B();
                    m11786d(i);
                    LogUtil.m15949b(f10959b, "Panorama onError() : " + i);
                } else if (i == 0 || -106 == i) {
                    LogUtil.m15942a(f10959b, "panorama result is " + i);
                } else {
                    this.f10987g -= f10957J[1];
                    this.f10988l += f10957J[0];
                    this.f10979U = (this.f10979U + 1) % this.f10977S.size();
                    this.f10993q.mo22533a(bArr, this.f10987g, this.f10988l, i);
                    if (Math.abs(this.f10987g / this.f10969K) > this.f10970L) {
                        m11770B();
                        m11786d(i);
                        LogUtil.m15949b(f10959b, "Panorama onError() : " + i);
                    }
                    if (2 == this.f10989m) {
                        this.f10993q.mo22528a(1);
                    } else if (1 == this.f10989m) {
                        this.f10993q.mo22528a(-1);
                    }
                    if (101 == i || -103 == i || -105 == i) {
                        if (this.f10993q != null && !this.f10973O && !this.f10986f) {
                            this.f10993q.mo22536b(3);
                        }
                        if (this.f10964E != this.f10962C) {
                            if (!(this.f10962C == -1 || this.f10964E == -1)) {
                                m11770B();
                                m11786d(i);
                                LogUtil.m15949b(f10959b, "Panorama onError() : " + i);
                            }
                            this.f10964E = this.f10962C;
                        }
                        this.f10999w.runOnUiThread(new Runnable() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f11003a;

                            public void run() {
                                if (!PatchProxy.proxy(new Object[0], this, f11003a, false, 5000, new Class[0], Void.TYPE).isSupported) {
                                    PanoramaMode.this.f10993q.mo22544h();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11780a(final byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f10958a, false, 4984, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            this.f10999w.runOnUiThread(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11005a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f11005a, false, 5001, new Class[0], Void.TYPE).isSupported) {
                        PanoramaMode.this.f10993q.mo22532a(bArr);
                    }
                }
            });
        }
    }

    /* renamed from: B */
    private void m11770B() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4985, new Class[0], Void.TYPE).isSupported && this.f10986f) {
            this.f10986f = false;
            if (this.f10972N) {
                mo20539R().mo18275x(6);
            }
            if (this.f10999w != null) {
                this.f10999w.runOnUiThread(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f11008a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f11008a, false, 5002, new Class[0], Void.TYPE).isSupported) {
                            PanoramaMode.this.f10993q.mo22537b(PanoramaMode.this.f10972N);
                        }
                    }
                });
            }
            synchronized (this.f10991o) {
                PanoramaStitcher.nativeStop(this.f10983c);
            }
            if (this.f10997u != null) {
                this.f10997u.mo20622b();
            }
            this.f10975Q = false;
            this.f10967H.mo17914ak().mo20220e(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m11771K() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4986, new Class[0], Void.TYPE).isSupported) {
            this.f10993q.mo22539c(mo20539R().mo18200dX());
            if (!this.f10974P) {
                mo20541T().mo20341f();
                mo20541T().mo20322a(false);
            }
            mo20539R().mo18122c(new boolean[0]);
            this.f10975Q = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11779a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10958a, false, 4987, new Class[]{String.class}, Void.TYPE).isSupported) {
            m11771K();
            this.f10986f = false;
            LogUtil.C2630a aVar = f10959b;
            LogUtil.m15949b(aVar, "Panorama onError() : " + str);
            this.f10975Q = false;
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10958a, false, 4988, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                mo20542U().mo21506a(0);
                m11772L();
            }
            if (!z2) {
                this.f10993q.mo22531a(!z);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4989, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            m11772L();
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4990, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21506a(0);
            m11772L();
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.PANORAMA;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4991, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10959b, "Panorama mode release");
            mo20405i_();
            EffectRenderContext.m4369h().mo14203c(false);
            this.f10993q.mo22541e();
            this.f10993q.mo22545i();
            this.f10973O = true;
            this.f10986f = false;
            if (this.f10997u != null) {
                this.f10997u.mo20624d();
            }
            this.f10997u = null;
            this.f10976R = false;
            if (this.f10980V != null) {
                LogUtil.m15952c(f10959b, "pan mParamsManager.setParameter pan_off");
                CameraController.m8868g().mo19471a("cap-mode", "pan_off", new boolean[0]);
                this.f10980V = null;
            }
            mo20614c();
            m11772L();
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4992, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10959b, "Panorama mode pause");
            this.f10975Q = false;
            if (this.f10967H != null) {
                this.f10967H.mo18267u().mo22113ab().setRenderViewCallBackListener((PreviewView.C1193b) null);
            }
            if (0 != this.f10983c && this.f10986f) {
                m11770B();
                m11786d(-1);
            }
            if (this.f10973O && !this.f10986f) {
                this.f10993q.mo22541e();
            }
            mo20539R().mo18267u().mo22142b(true);
            if (this.f10997u != null) {
                this.f10997u.mo20624d();
                this.f10997u = null;
            }
            if (this.f10996t != null) {
                this.f10996t.disable();
            }
            this.f10974P = true;
            EffectRenderContext.m4369h().mo14215g(false);
            this.f10986f = false;
        }
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10958a, false, 4993, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10986f) {
            return false;
        }
        mo20411n();
        return true;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        if (this.f10986f) {
            return CameraController.FocusMode.AUTO;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: b */
    public void mo20613b(SensorEvent sensorEvent) {
        if (!PatchProxy.proxy(new Object[]{sensorEvent}, this, f10958a, false, 4994, new Class[]{SensorEvent.class}, Void.TYPE).isSupported) {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (((double) sensorEvent.values[1]) >= 6.5d || ((double) sensorEvent.values[1]) <= -6.5d) {
                    if (!this.f11002z && ((double) sensorEvent.values[2]) < 6.5d && ((double) sensorEvent.values[2]) > -6.5d) {
                        this.f11002z = true;
                    }
                } else if (this.f11002z && ((double) sensorEvent.values[2]) < 6.5d && ((double) sensorEvent.values[2]) > -6.5d) {
                    this.f11002z = false;
                }
            } else if (type == 4) {
                long j = sensorEvent.timestamp;
                if (this.f10960A != 0) {
                    float f = ((float) (j - this.f10960A)) * 1.0E-9f;
                    this.f11000x += sensorEvent.values[0] * f * 57.29578f;
                    this.f11001y += sensorEvent.values[1] * f * 57.29578f;
                }
                this.f10960A = j;
            }
        }
    }

    /* renamed from: n_ */
    public void mo14346n_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4995, new Class[0], Void.TYPE).isSupported) {
            AsyncTaskEx.m15786a((Runnable) new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11010a;

                /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        r0 = 0
                        java.lang.Object[] r1 = new java.lang.Object[r0]
                        com.meizu.savior.ChangeQuickRedirect r3 = f11010a
                        java.lang.Class[] r6 = new java.lang.Class[r0]
                        java.lang.Class r7 = java.lang.Void.TYPE
                        r4 = 0
                        r5 = 5003(0x138b, float:7.01E-42)
                        r2 = r10
                        com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                        boolean r0 = r0.isSupported
                        if (r0 == 0) goto L_0x0016
                        return
                    L_0x0016:
                        com.meizu.media.camera.mode.o r0 = com.meizu.media.camera.mode.PanoramaMode.this
                        java.lang.Object r0 = r0.f10991o
                        monitor-enter(r0)
                        r1 = 0
                        com.meizu.media.camera.mode.o r3 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        long r3 = r3.f10983c     // Catch:{ all -> 0x00d5 }
                        int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                        if (r1 == 0) goto L_0x00d3
                        com.meizu.media.camera.mode.o r1 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        java.util.ArrayList r1 = r1.f10977S     // Catch:{ all -> 0x00d5 }
                        com.meizu.media.camera.mode.o r2 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        int r2 = r2.f10979U     // Catch:{ all -> 0x00d5 }
                        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00d5 }
                        byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x00d5 }
                        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00d5 }
                        r3 = 29
                        if (r2 < r3) goto L_0x0068
                        com.meizu.media.camera.mode.o r2 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        long r2 = r2.f10983c     // Catch:{ all -> 0x00d5 }
                        com.meizu.camera.effectlib.effects.views.EffectRenderContext r4 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00d5 }
                        com.meizu.imageproc.SurfaceTextureWrapper r4 = r4.mo14242z()     // Catch:{ all -> 0x00d5 }
                        com.meizu.camera.effectlib.effects.views.EffectRenderContext r5 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00d5 }
                        com.meizu.media.camera.mode.o r6 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        int r6 = r6.f10981W     // Catch:{ all -> 0x00d5 }
                        boolean r7 = com.meizu.media.camera.util.DeviceHelper.f13904bD     // Catch:{ all -> 0x00d5 }
                        boolean r8 = com.meizu.media.camera.util.DeviceHelper.f13905bE     // Catch:{ all -> 0x00d5 }
                        boolean r9 = com.meizu.media.camera.util.DeviceHelper.f13886am     // Catch:{ all -> 0x00d5 }
                        int r5 = r5.mo14188b(r6, r7, r8, r9)     // Catch:{ all -> 0x00d5 }
                        int r2 = com.meizu.imageproc.PanoramaStitcher.nativeProcessImage((long) r2, (com.meizu.imageproc.SurfaceTextureWrapper) r4, (byte[]) r1, (int) r5)     // Catch:{ all -> 0x00d5 }
                        goto L_0x008e
                    L_0x0068:
                        com.meizu.media.camera.mode.o r2 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        long r2 = r2.f10983c     // Catch:{ all -> 0x00d5 }
                        com.meizu.camera.effectlib.effects.views.EffectRenderContext r4 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00d5 }
                        android.graphics.SurfaceTexture r4 = r4.mo14241y()     // Catch:{ all -> 0x00d5 }
                        com.meizu.camera.effectlib.effects.views.EffectRenderContext r5 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00d5 }
                        com.meizu.media.camera.mode.o r6 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        int r6 = r6.f10981W     // Catch:{ all -> 0x00d5 }
                        boolean r7 = com.meizu.media.camera.util.DeviceHelper.f13904bD     // Catch:{ all -> 0x00d5 }
                        boolean r8 = com.meizu.media.camera.util.DeviceHelper.f13905bE     // Catch:{ all -> 0x00d5 }
                        boolean r9 = com.meizu.media.camera.util.DeviceHelper.f13886am     // Catch:{ all -> 0x00d5 }
                        int r5 = r5.mo14188b(r6, r7, r8, r9)     // Catch:{ all -> 0x00d5 }
                        int r2 = com.meizu.imageproc.PanoramaStitcher.nativeProcessImage((long) r2, (android.graphics.SurfaceTexture) r4, (byte[]) r1, (int) r5)     // Catch:{ all -> 0x00d5 }
                    L_0x008e:
                        r3 = -1
                        if (r2 != r3) goto L_0x009c
                        com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.mode.PanoramaMode.f10959b     // Catch:{ all -> 0x00d5 }
                        java.lang.String r2 = " PanoramaStitcher.PANORAMA_RESULT_TYPE_INVALID_VALUE"
                        com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00d5 }
                        monitor-exit(r0)     // Catch:{ all -> 0x00d5 }
                        return
                    L_0x009c:
                        if (r1 != 0) goto L_0x00a9
                        com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.mode.PanoramaMode.f10959b     // Catch:{ all -> 0x00d5 }
                        java.lang.String r2 = "panorama data is null "
                        com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00d5 }
                        monitor-exit(r0)     // Catch:{ all -> 0x00d5 }
                        return
                    L_0x00a9:
                        com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x00d5 }
                        com.meizu.media.camera.camcontroller.d r3 = r3.mo19522k()     // Catch:{ all -> 0x00d5 }
                        if (r3 != 0) goto L_0x00b5
                        monitor-exit(r0)     // Catch:{ all -> 0x00d5 }
                        return
                    L_0x00b5:
                        com.meizu.media.camera.mode.o r3 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        boolean r3 = r3.f10975Q     // Catch:{ all -> 0x00d5 }
                        if (r3 == 0) goto L_0x00c2
                        com.meizu.media.camera.mode.o r3 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        r3.m11781a((byte[]) r1, (int) r2)     // Catch:{ all -> 0x00d5 }
                    L_0x00c2:
                        com.meizu.media.camera.mode.o r2 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        com.meizu.media.camera.ui.v r2 = r2.f10993q     // Catch:{ all -> 0x00d5 }
                        boolean r2 = r2.mo22534a()     // Catch:{ all -> 0x00d5 }
                        if (r2 == 0) goto L_0x00d3
                        com.meizu.media.camera.mode.o r2 = com.meizu.media.camera.mode.PanoramaMode.this     // Catch:{ all -> 0x00d5 }
                        r2.m11780a((byte[]) r1)     // Catch:{ all -> 0x00d5 }
                    L_0x00d3:
                        monitor-exit(r0)     // Catch:{ all -> 0x00d5 }
                        return
                    L_0x00d5:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x00d5 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.PanoramaMode.C22004.run():void");
                }
            });
        }
    }

    /* renamed from: com.meizu.media.camera.mode.o$a */
    /* compiled from: PanoramaMode */
    private class C2202a extends OrientationEventListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11014a;

        public C2202a(Context context, int i) {
            super(context, i);
        }

        public void onOrientationChanged(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f11014a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5005, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                if (i == -1) {
                    int unused = PanoramaMode.this.f10962C = -1;
                    return;
                }
                int i2 = (((i + 45) / 90) * 90) % 360;
                if (i2 != PanoramaMode.this.f10962C) {
                    int unused2 = PanoramaMode.this.f10962C = i2;
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.o$b */
    /* compiled from: PanoramaMode */
    private class C2203b extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f11016a;

        /* renamed from: c */
        private boolean f11018c = false;

        /* renamed from: d */
        private boolean f11019d = false;

        /* renamed from: e */
        private String f11020e;

        public C2203b() {
            setName("PanoImageSaver");
            start();
        }

        /* renamed from: a */
        public boolean mo20621a() {
            return this.f11019d;
        }

        /* renamed from: b */
        public void mo20622b() {
            if (!PatchProxy.proxy(new Object[0], this, f11016a, false, 5006, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f11019d = true;
                    notifyAll();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            com.meizu.media.camera.util.LogUtil.m15952c(com.meizu.media.camera.mode.PanoramaMode.m11799q(), "storeImage start");
            r1 = m11831e();
            r2 = com.meizu.media.camera.mode.PanoramaMode.m11799q();
            com.meizu.media.camera.util.LogUtil.m15952c(r2, "storeImage end,  storeSuccess:" + r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
            if (r1 == false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            m11832f();
            com.meizu.media.camera.mode.PanoramaMode.m11793k(r8.f11017b).post(new com.meizu.media.camera.mode.PanoramaMode.C2203b.C22041(r8));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
            com.meizu.media.camera.mode.PanoramaMode.m11793k(r8.f11017b).post(new com.meizu.media.camera.mode.PanoramaMode.C2203b.C22052(r8));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
            r8.f11019d = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
            monitor-exit(r8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f11016a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 5007(0x138f, float:7.016E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                monitor-enter(r8)
                boolean r1 = r8.f11019d     // Catch:{ all -> 0x0081 }
                if (r1 != 0) goto L_0x002e
                r8.notifyAll()     // Catch:{ all -> 0x0081 }
                boolean r1 = r8.f11018c     // Catch:{ all -> 0x0081 }
                if (r1 == 0) goto L_0x0024
                monitor-exit(r8)     // Catch:{ all -> 0x0081 }
                return
            L_0x0024:
                r8.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x002c
            L_0x0028:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x0081 }
            L_0x002c:
                monitor-exit(r8)     // Catch:{ all -> 0x0081 }
                goto L_0x0016
            L_0x002e:
                monitor-exit(r8)     // Catch:{ all -> 0x0081 }
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.mode.PanoramaMode.f10959b
                java.lang.String r2 = "storeImage start"
                com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
                boolean r1 = r8.m11831e()
                com.meizu.media.camera.util.ac$a r2 = com.meizu.media.camera.mode.PanoramaMode.f10959b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "storeImage end,  storeSuccess:"
                r3.append(r4)
                r3.append(r1)
                java.lang.String r3 = r3.toString()
                com.meizu.media.camera.util.LogUtil.m15952c(r2, r3)
                if (r1 == 0) goto L_0x0068
                r8.m11832f()
                com.meizu.media.camera.mode.o r1 = com.meizu.media.camera.mode.PanoramaMode.this
                android.os.Handler r1 = r1.f10992p
                com.meizu.media.camera.mode.o$b$1 r2 = new com.meizu.media.camera.mode.o$b$1
                r2.<init>()
                r1.post(r2)
                goto L_0x0076
            L_0x0068:
                com.meizu.media.camera.mode.o r1 = com.meizu.media.camera.mode.PanoramaMode.this
                android.os.Handler r1 = r1.f10992p
                com.meizu.media.camera.mode.o$b$2 r2 = new com.meizu.media.camera.mode.o$b$2
                r2.<init>()
                r1.post(r2)
            L_0x0076:
                r8.f11019d = r0
                monitor-enter(r8)
                r8.notifyAll()     // Catch:{ all -> 0x007e }
                monitor-exit(r8)     // Catch:{ all -> 0x007e }
                goto L_0x0016
            L_0x007e:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x007e }
                throw r0
            L_0x0081:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0081 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.PanoramaMode.C2203b.run():void");
        }

        /* renamed from: c */
        public void mo20623c() {
            if (!PatchProxy.proxy(new Object[0], this, f11016a, false, 5008, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    LogUtil.C2630a q = PanoramaMode.f10959b;
                    LogUtil.m15952c(q, "waitDone, mHasNewWorkToDo = " + this.f11019d);
                    while (this.f11019d) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /* renamed from: d */
        public void mo20624d() {
            if (!PatchProxy.proxy(new Object[0], this, f11016a, false, 5009, new Class[0], Void.TYPE).isSupported) {
                mo20623c();
                synchronized (this) {
                    this.f11018c = true;
                    notifyAll();
                }
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: e */
        private boolean m11831e() {
            Location a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11016a, false, 5010, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            boolean unused = PanoramaMode.this.f10973O = false;
            if (0 == PanoramaMode.this.f10983c || !PanoramaMode.this.f10972N) {
                LogUtil.C2630a q = PanoramaMode.f10959b;
                StringBuilder sb = new StringBuilder();
                sb.append("pano store image return, mPanoramaHandle is 0 ?");
                sb.append(PanoramaMode.this.f10983c == 0);
                sb.append(", mKeyFrameCount < 2 ? ");
                sb.append(PanoramaMode.this.f10990n < 2);
                LogUtil.m15952c(q, sb.toString());
                boolean unused2 = PanoramaMode.this.f10973O = true;
                return false;
            }
            this.f11020e = Storage.m7750a().mo18654f(CameraUtil.m15831a(PanoramaMode.this.f10968I));
            int[] iArr = new int[2];
            boolean z = PanoramaMode.this.f10963D == 0 || PanoramaMode.this.f10963D == 180;
            if (PanoramaStitcher.nativeGetResultImageSize(PanoramaMode.this.f10983c, z, iArr) != 0 || iArr[0] == 0 || iArr[1] == 0) {
                boolean unused3 = PanoramaMode.this.f10973O = true;
                return false;
            }
            byte[] bArr = new byte[(((iArr[0] * iArr[1]) * 3) / 2)];
            if (PanoramaStitcher.nativeGetResultImage(PanoramaMode.this.f10983c, z, bArr) != 0) {
                boolean unused4 = PanoramaMode.this.f10973O = true;
                return false;
            }
            YuvImage yuvImage = new YuvImage(bArr, 17, iArr[0], iArr[1], (int[]) null);
            ByteArrayOutputStream unused5 = PanoramaMode.this.f10998v = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, iArr[0], iArr[1]), 90, PanoramaMode.this.f10998v);
            ExifInterface cVar = new ExifInterface();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                cVar.mo19876e();
                cVar.mo19883o(0);
                cVar.mo19858a(ExifInterface.f9408u, currentTimeMillis, TimeZone.getDefault());
                Storage.m7755a(cVar, PanoramaMode.this.f10998v.toByteArray(), (Bitmap) null, 0, 0, 0, false);
                if (!(PanoramaMode.this.f10967H.mo18192dP() == null || (a = PanoramaMode.this.f10967H.mo18192dP().mo19017a(currentTimeMillis)) == null)) {
                    cVar.mo19857a(a.getLatitude(), a.getLongitude());
                    cVar.mo19859a(currentTimeMillis);
                }
                cVar.mo19846a(cVar.mo19845a(ExifInterface.f9346ae, (Object) "NORMAL"));
                cVar.mo19856a(PanoramaMode.this.f10998v.toByteArray(), this.f11020e);
                ByteArrayOutputStream unused6 = PanoramaMode.this.f10998v = null;
                boolean unused7 = PanoramaMode.this.f10973O = true;
                if (PanoramaMode.this.f10974P) {
                    LogUtil.m15942a(PanoramaMode.f10959b, "need releaseMemory");
                    PanoramaMode.this.mo20614c();
                }
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                boolean unused8 = PanoramaMode.this.f10973O = true;
                ByteArrayOutputStream unused9 = PanoramaMode.this.f10998v = null;
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                boolean unused10 = PanoramaMode.this.f10973O = true;
                ByteArrayOutputStream unused11 = PanoramaMode.this.f10998v = null;
                return false;
            } catch (Throwable th) {
                ByteArrayOutputStream unused12 = PanoramaMode.this.f10998v = null;
                throw th;
            }
        }

        /* renamed from: f */
        private void m11832f() {
            if (!PatchProxy.proxy(new Object[0], this, f11016a, false, PaddleController.PADDLE_IMG_SEG_CONTROL, new Class[0], Void.TYPE).isSupported) {
                long j = 0;
                String str = "";
                File file = new File(this.f11020e);
                if (file.exists()) {
                    j = file.length();
                    String name = file.getName();
                    str = name.substring(0, name.indexOf(46));
                }
                long j2 = j;
                String str2 = str;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                options.outHeight = 0;
                options.outWidth = 0;
                BitmapFactory.decodeFile(this.f11020e, options);
                int i = options.outWidth;
                int i2 = options.outHeight;
                Uri a = Storage.m7750a().mo18611a(PanoramaMode.this.f10994r, PanoramaMode.this.f10968I, str2, 0, j2, i, i2, PanoramaMode.this.f10967H.mo18192dP() != null ? PanoramaMode.this.f10967H.mo18192dP().mo19017a(PanoramaMode.this.f10968I) : null);
                if (i <= i2) {
                    i2 = i;
                }
                int highestOneBit = Integer.highestOneBit((int) Math.ceil(((double) i2) / ((double) CameraUtil.m15903i())));
                Message.obtain(PanoramaMode.this.f10982X, 0, a).sendToTarget();
                Storage.m7750a().mo18652e(false);
                PanoramaMode.this.f10995s.mo17846a(this.f11020e, highestOneBit, 0, (byte[]) null);
                PanoramaMode.this.f10995s.mo17845a(this.f11020e);
            }
        }
    }

    /* renamed from: d */
    private void m11786d(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10958a, false, 4996, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(mo20540S().getApplicationContext()).mo22688a(new String[]{"mode", "location", "sd_card"});
            a.put("capture_time", Long.toString(this.f10968I));
            a.put("pano_orient", 2 == this.f10989m ? "right" : "left");
            String str = "2";
            if (i == -102 || i == -108) {
                str = "1";
            } else if (i == -104) {
                str = androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_3D;
            } else if (i == -107) {
                str = "0";
            }
            a.put("pano_end_type", str);
            this.f10966G.mo22693a("capture_info", a);
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4997, new Class[0], Void.TYPE).isSupported) {
            this.f10993q.mo22538c();
            mo20406j_();
        }
    }

    /* renamed from: F */
    public void mo20382F() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4998, new Class[0], Void.TYPE).isSupported) {
            super.mo20382F();
            if (EffectRenderContext.m4369h().mo14223j() && DeviceHelper.f14050t) {
                LogUtil.m15952c(f10959b, "mParamsManager.setParameter pan_open");
                CameraController.m8868g().mo19471a("cap-mode", "pano-open", new boolean[0]);
            }
        }
    }

    /* renamed from: L */
    private void m11772L() {
        if (!PatchProxy.proxy(new Object[0], this, f10958a, false, 4999, new Class[0], Void.TYPE).isSupported && this.f10967H.mo17914ak() != null) {
            this.f10967H.mo17914ak().mo20230j(false);
        }
    }
}
