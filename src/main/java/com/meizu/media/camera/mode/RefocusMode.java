package com.meizu.media.camera.mode;

import android.graphics.Point;
import android.hardware.Camera;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzRefocusUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.q */
public class RefocusMode extends CameraMode {

    /* renamed from: E */
    private static Class<?> f11041E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public static Method f11042F;

    /* renamed from: G */
    private static Method f11043G;

    /* renamed from: a */
    public static ChangeQuickRedirect f11044a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f11045b = new LogUtil.C2630a("RefocusMode");

    /* renamed from: A */
    private Camera.ShutterCallback f11046A = new Camera.ShutterCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11074a;

        public void onShutter() {
            if (!PatchProxy.proxy(new Object[0], this, f11074a, false, 5057, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15952c(RefocusMode.f11045b, "ShutterCallback onShutter()");
            }
        }
    };

    /* renamed from: B */
    private Camera.PictureCallback f11047B = new Camera.PictureCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11076a;

        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f11076a, false, 5058, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(RefocusMode.f11045b, "RawCallback onPictureTaken()");
            }
        }
    };

    /* renamed from: C */
    private Camera.PictureCallback f11048C = new Camera.PictureCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11078a;

        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f11078a, false, 5059, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(RefocusMode.f11045b, "PostViewCallback onPictureTaken()");
            }
        }
    };

    /* renamed from: D */
    private Camera.PictureCallback f11049D = new Camera.PictureCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11080a;

        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f11080a, false, 5060, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(RefocusMode.f11045b, "JpegCallback onPictureTaken()");
            }
        }
    };

    /* renamed from: H */
    private Object f11050H;

    /* renamed from: I */
    private MeizuCamera.MeizuCameraRefocusCallback f11051I = new MeizuCamera.MeizuCameraRefocusCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11082a;

        public void onRefocusNotify(int i, int i2, MeizuCamera meizuCamera) {
            Object[] objArr = {new Integer(i), new Integer(i2), meizuCamera};
            ChangeQuickRedirect changeQuickRedirect = f11082a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5061, new Class[]{Integer.TYPE, Integer.TYPE, MeizuCamera.class}, Void.TYPE).isSupported) {
                RefocusMode.this.m11885a((byte[]) null, i, i2, (Camera) null);
            }
        }
    };

    /* renamed from: c */
    private MzRefocusUI f11052c;

    /* renamed from: d */
    private C2216c f11053d;

    /* renamed from: e */
    private boolean f11054e;

    /* renamed from: f */
    private C2214a f11055f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f11056g = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f11057l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f11058m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Location f11059n;

    /* renamed from: o */
    private int f11060o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ArrayList<File> f11061p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ArrayList<String> f11062q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ArrayList<C2217d> f11063r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f11064s = null;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f11065t = ".config";

    /* renamed from: u */
    private boolean f11066u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f11067v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f11068w = false;

    /* renamed from: x */
    private UsageStatsHelper f11069x;

    /* renamed from: y */
    private long f11070y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Handler f11071z = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11072a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f11072a, false, 5056, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 0:
                        RefocusMode.this.mo20539R().mo18193dQ().mo17844a((Uri) message.obj);
                        return;
                    case 1:
                        LogUtil.m15949b(RefocusMode.f11045b, "refocus capture timeout(7sec)!");
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: a */
    private boolean m11886a(int i, int i2) {
        return (i & i2) == i2;
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

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public RefocusMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        m11878K();
        lVar.mo20320a(MzCamParamsManager.f10482g, new Object[0]);
        CameraController.m8868g().mo19501c(0, new boolean[0]);
        if (this.f11052c == null) {
            this.f11052c = hVar.mo18267u().mo22115ad();
            this.f11052c.mo22550a(uVar);
        }
        this.f11052c.mo22549a();
        this.f11069x = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: c */
    public void mo20635c() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5044, new Class[0], Void.TYPE).isSupported && !this.f11054e) {
            this.f11066u = false;
            this.f11067v = false;
            this.f11054e = true;
            mo20539R().mo18230ea();
            this.f11052c.mo22554d();
            this.f11060o = 0;
            this.f11070y = System.currentTimeMillis();
            if (this.f11053d == null) {
                this.f11066u = true;
                this.f11067v = true;
                m11884a(true);
                return;
            }
            FileDescriptor[] b = this.f11053d.mo20647b();
            if (b == null) {
                this.f11053d.mo20646a();
                b = this.f11053d.mo20647b();
            }
            boolean z = b != null;
            if (z) {
                int length = b.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (b[i] == null) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (!z) {
                this.f11066u = true;
                this.f11067v = true;
                m11884a(true);
                return;
            }
            this.f11053d.mo20649d();
            this.f11058m = CameraUtil.m15882c(mo20539R().mo18211di(), mo20539R().mo18194dR());
            CameraController.m8868g().mo19490b(this.f11058m, new boolean[0]);
            mo20541T().mo20320a(MzCamParamsManager.f10482g, new Object[0]);
            this.f11059n = mo20539R().mo18192dP().mo19017a(this.f11070y);
            CameraController.m8868g().mo19455a(this.f11059n, new boolean[0]);
            CameraController.m8868g().mo19480a(new boolean[0]);
            m11879L();
            this.f11064s = CameraUtil.m15890d(this.f11070y);
            Storage.m7750a().mo18670n(this.f11064s);
            this.f11071z.sendEmptyMessageDelayed(1, 7000);
        }
    }

    /* renamed from: K */
    private void m11878K() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5045, new Class[0], Void.TYPE).isSupported) {
            this.f11055f = new C2214a();
            this.f11053d = new C2216c();
            m11880M();
            mo20539R().mo18267u().mo22142b(false);
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5046, new Class[0], Void.TYPE).isSupported) {
            if (this.f11054e) {
                this.f11066u = true;
                this.f11067v = true;
                m11884a(true);
            }
            if (this.f11055f != null) {
                this.f11055f.mo20642a();
                this.f11055f = null;
            }
            if (this.f11053d != null) {
                this.f11053d.mo20648c();
                this.f11053d = null;
            }
        }
    }

    /* renamed from: q */
    public void mo20636q() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5047, new Class[0], Void.TYPE).isSupported && !this.f11054e) {
            Storage.m7750a().mo18676r();
            if (this.f11053d != null) {
                this.f11053d.mo20646a();
            }
        }
    }

    /* renamed from: L */
    private void m11879L() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5048, new Class[0], Void.TYPE).isSupported) {
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                LogUtil.m15949b(f11045b, "getRefocusImageSize() error, pictureSize is null");
                return;
            }
            this.f11056g = j.x;
            this.f11057l = j.y;
        }
    }

    /* renamed from: com.meizu.media.camera.mode.q$d */
    /* compiled from: RefocusMode */
    private static class C2217d {

        /* renamed from: a */
        long f11096a;

        /* renamed from: b */
        int f11097b;

        /* renamed from: c */
        boolean f11098c;

        /* renamed from: d */
        boolean f11099d;

        /* renamed from: e */
        int f11100e;

        private C2217d() {
        }
    }

    /* renamed from: com.meizu.media.camera.mode.q$a */
    /* compiled from: RefocusMode */
    private class C2214a extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f11084a;

        /* renamed from: c */
        private ArrayList<C2217d> f11086c;

        /* renamed from: d */
        private boolean f11087d = false;

        public C2214a() {
            setName("InsertRefocusImage");
            this.f11086c = new ArrayList<>();
            start();
        }

        /* renamed from: a */
        public void mo20643a(C2217d dVar) {
            if (!PatchProxy.proxy(new Object[]{dVar}, this, f11084a, false, 5062, new Class[]{C2217d.class}, Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f11086c.add(dVar);
                    notifyAll();
                }
            }
        }

        /* renamed from: b */
        private void m11922b() {
            if (!PatchProxy.proxy(new Object[0], this, f11084a, false, 5063, new Class[0], Void.TYPE).isSupported) {
                if (RefocusMode.this.f11061p != null) {
                    for (int i = 0; i < RefocusMode.this.f11061p.size(); i++) {
                        File file = (File) RefocusMode.this.f11061p.get(i);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
                ArrayList unused = RefocusMode.this.f11061p = null;
                ArrayList unused2 = RefocusMode.this.f11063r = null;
                ArrayList unused3 = RefocusMode.this.f11062q = null;
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (r1.f11099d == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
            r2 = com.meizu.media.camera.mode.RefocusMode.m11888b(r15.f11085b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r9 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            r4 = r1.f11096a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            if (com.meizu.media.camera.util.DeviceHelper.f13841U == false) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
            r2 = r1.f11100e + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            r2 = r1.f11100e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
            r2 = com.meizu.media.camera.util.CameraUtil.m15884c(r4, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
            r2 = com.meizu.media.camera.Storage.m7750a().mo18624a(r9, com.meizu.media.camera.mode.RefocusMode.m11891c(r15.f11085b), r1.f11099d);
            ((java.io.File) com.meizu.media.camera.mode.RefocusMode.m11881a(r15.f11085b).get(r1.f11100e - 1)).renameTo(new java.io.File(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
            if (r1.f11099d != false) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
            com.meizu.media.camera.mode.RefocusMode.m11894d(r15.f11085b).add(new java.io.File(r2).getAbsolutePath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
            if (r1.f11099d != false) goto L_0x00f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0098, code lost:
            r4 = com.meizu.media.camera.mode.RefocusMode.m11895e(r15.f11085b);
            r5 = com.meizu.media.camera.mode.RefocusMode.m11896f(r15.f11085b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ae, code lost:
            if (((com.meizu.media.camera.mode.RefocusMode.m11897g(r15.f11085b) / 90) & 1) != 1) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
            r4 = com.meizu.media.camera.mode.RefocusMode.m11896f(r15.f11085b);
            r5 = com.meizu.media.camera.mode.RefocusMode.m11895e(r15.f11085b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
            r4 = com.meizu.media.camera.Storage.m7750a().mo18612a(r15.f11085b.mo20539R().mo18187dK(), r1.f11096a, com.meizu.media.camera.mode.RefocusMode.m11891c(r15.f11085b), r9, 0, r1.f11097b, r4, r5, com.meizu.media.camera.mode.RefocusMode.m11898h(r15.f11085b));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e0, code lost:
            if (r4 == null) goto L_0x00f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
            if (r1.f11100e != 2) goto L_0x00f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
            r5 = android.os.Message.obtain();
            r5.obj = r4;
            r5.what = 0;
            com.meizu.media.camera.mode.RefocusMode.m11899i(r15.f11085b).sendMessage(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fa, code lost:
            if (r1.f11098c != false) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0102, code lost:
            if (com.meizu.media.camera.mode.RefocusMode.m11900j(r15.f11085b) == false) goto L_0x014a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
            com.meizu.media.camera.mode.RefocusMode.m11887a(r15.f11085b, false);
            r15.f11085b.mo20539R().mo18193dQ().mo17846a(r2, java.lang.Integer.highestOneBit((int) java.lang.Math.ceil(((double) com.meizu.media.camera.mode.RefocusMode.m11895e(r15.f11085b)) / ((double) com.meizu.media.camera.util.CameraUtil.m15903i()))), 0, (byte[]) null);
            r15.f11085b.mo20539R().mo18193dQ().mo17847a((java.util.List<java.lang.String>) com.meizu.media.camera.mode.RefocusMode.m11894d(r15.f11085b));
            com.meizu.media.camera.mode.RefocusMode.m11890b(r15.f11085b, true);
            com.meizu.media.camera.mode.RefocusMode.m11893c(r15.f11085b, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x014a, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r15.f11086c.remove(0);
            notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0153, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f11084a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 5064(0x13c8, float:7.096E-42)
                r2 = r15
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                monitor-enter(r15)
                java.util.ArrayList<com.meizu.media.camera.mode.q$d> r1 = r15.f11086c     // Catch:{ all -> 0x0159 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0159 }
                if (r1 == 0) goto L_0x0030
                r15.notifyAll()     // Catch:{ all -> 0x0159 }
                boolean r1 = r15.f11087d     // Catch:{ all -> 0x0159 }
                if (r1 == 0) goto L_0x002b
                r15.m11922b()     // Catch:{ all -> 0x0159 }
                monitor-exit(r15)     // Catch:{ all -> 0x0159 }
                return
            L_0x002b:
                r15.wait()     // Catch:{ InterruptedException -> 0x002e }
            L_0x002e:
                monitor-exit(r15)     // Catch:{ all -> 0x0159 }
                goto L_0x0016
            L_0x0030:
                java.util.ArrayList<com.meizu.media.camera.mode.q$d> r1 = r15.f11086c     // Catch:{ all -> 0x0159 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0159 }
                com.meizu.media.camera.mode.q$d r1 = (com.meizu.media.camera.mode.RefocusMode.C2217d) r1     // Catch:{ all -> 0x0159 }
                monitor-exit(r15)     // Catch:{ all -> 0x0159 }
                boolean r2 = r1.f11099d
                r3 = 1
                if (r2 == 0) goto L_0x0046
                com.meizu.media.camera.mode.q r2 = com.meizu.media.camera.mode.RefocusMode.this
                java.lang.String r2 = r2.f11065t
            L_0x0044:
                r9 = r2
                goto L_0x0057
            L_0x0046:
                long r4 = r1.f11096a
                boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13841U
                if (r2 == 0) goto L_0x0050
                int r2 = r1.f11100e
                int r2 = r2 + r3
                goto L_0x0052
            L_0x0050:
                int r2 = r1.f11100e
            L_0x0052:
                java.lang.String r2 = com.meizu.media.camera.util.CameraUtil.m15884c((long) r4, (int) r2)
                goto L_0x0044
            L_0x0057:
                com.meizu.media.camera.Storage r2 = com.meizu.media.camera.Storage.m7750a()
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                java.lang.String r4 = r4.f11064s
                boolean r5 = r1.f11099d
                java.lang.String r2 = r2.mo18624a((java.lang.String) r9, (java.lang.String) r4, (boolean) r5)
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                java.util.ArrayList r4 = r4.f11061p
                int r5 = r1.f11100e
                int r5 = r5 - r3
                java.lang.Object r4 = r4.get(r5)
                java.io.File r4 = (java.io.File) r4
                java.io.File r5 = new java.io.File
                r5.<init>(r2)
                r4.renameTo(r5)
                boolean r4 = r1.f11099d
                if (r4 != 0) goto L_0x0094
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                java.util.ArrayList r4 = r4.f11062q
                java.io.File r5 = new java.io.File
                r5.<init>(r2)
                java.lang.String r5 = r5.getAbsolutePath()
                r4.add(r5)
            L_0x0094:
                boolean r4 = r1.f11099d
                if (r4 != 0) goto L_0x00f8
                r10 = 0
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                int r4 = r4.f11056g
                com.meizu.media.camera.mode.q r5 = com.meizu.media.camera.mode.RefocusMode.this
                int r5 = r5.f11057l
                com.meizu.media.camera.mode.q r6 = com.meizu.media.camera.mode.RefocusMode.this
                int r6 = r6.f11058m
                int r6 = r6 / 90
                r6 = r6 & r3
                if (r6 != r3) goto L_0x00bc
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                int r4 = r4.f11057l
                com.meizu.media.camera.mode.q r5 = com.meizu.media.camera.mode.RefocusMode.this
                int r5 = r5.f11056g
            L_0x00bc:
                r12 = r4
                r13 = r5
                com.meizu.media.camera.Storage r4 = com.meizu.media.camera.Storage.m7750a()
                com.meizu.media.camera.mode.q r5 = com.meizu.media.camera.mode.RefocusMode.this
                com.meizu.media.camera.mode.h r5 = r5.mo20539R()
                android.content.ContentResolver r5 = r5.mo18187dK()
                long r6 = r1.f11096a
                com.meizu.media.camera.mode.q r8 = com.meizu.media.camera.mode.RefocusMode.this
                java.lang.String r8 = r8.f11064s
                int r11 = r1.f11097b
                com.meizu.media.camera.mode.q r14 = com.meizu.media.camera.mode.RefocusMode.this
                android.location.Location r14 = r14.f11059n
                android.net.Uri r4 = r4.mo18612a((android.content.ContentResolver) r5, (long) r6, (java.lang.String) r8, (java.lang.String) r9, (int) r10, (int) r11, (int) r12, (int) r13, (android.location.Location) r14)
                if (r4 == 0) goto L_0x00f8
                int r5 = r1.f11100e
                r6 = 2
                if (r5 != r6) goto L_0x00f8
                android.os.Message r5 = android.os.Message.obtain()
                r5.obj = r4
                r5.what = r0
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                android.os.Handler r4 = r4.f11071z
                r4.sendMessage(r5)
            L_0x00f8:
                boolean r1 = r1.f11098c
                if (r1 != 0) goto L_0x0104
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                boolean r1 = r1.f11068w
                if (r1 == 0) goto L_0x014a
            L_0x0104:
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                boolean unused = r1.f11068w = r0
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                int r1 = r1.f11056g
                double r4 = (double) r1
                int r1 = com.meizu.media.camera.util.CameraUtil.m15903i()
                double r6 = (double) r1
                double r4 = r4 / r6
                double r4 = java.lang.Math.ceil(r4)
                int r1 = (int) r4
                int r1 = java.lang.Integer.highestOneBit(r1)
                com.meizu.media.camera.mode.q r4 = com.meizu.media.camera.mode.RefocusMode.this
                com.meizu.media.camera.mode.h r4 = r4.mo20539R()
                com.meizu.media.camera.MediaSaveService$d r4 = r4.mo18193dQ()
                r5 = 0
                r4.mo17846a(r2, r1, r0, r5)
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                com.meizu.media.camera.mode.h r1 = r1.mo20539R()
                com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
                com.meizu.media.camera.mode.q r2 = com.meizu.media.camera.mode.RefocusMode.this
                java.util.ArrayList r2 = r2.f11062q
                r1.mo17847a((java.util.List<java.lang.String>) r2)
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                boolean unused = r1.f11067v = r3
                com.meizu.media.camera.mode.q r1 = com.meizu.media.camera.mode.RefocusMode.this
                r1.m11884a((boolean) r0)
            L_0x014a:
                monitor-enter(r15)
                java.util.ArrayList<com.meizu.media.camera.mode.q$d> r1 = r15.f11086c     // Catch:{ all -> 0x0156 }
                r1.remove(r0)     // Catch:{ all -> 0x0156 }
                r15.notifyAll()     // Catch:{ all -> 0x0156 }
                monitor-exit(r15)     // Catch:{ all -> 0x0156 }
                goto L_0x0016
            L_0x0156:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0156 }
                throw r0
            L_0x0159:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0159 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.RefocusMode.C2214a.run():void");
        }

        /* renamed from: a */
        public void mo20642a() {
            if (!PatchProxy.proxy(new Object[0], this, f11084a, false, 5065, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f11087d = true;
                    notifyAll();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.q$c */
    /* compiled from: RefocusMode */
    private class C2216c extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f11090a;

        /* renamed from: c */
        private boolean f11092c = false;

        /* renamed from: d */
        private FileDescriptor[] f11093d;

        /* renamed from: e */
        private boolean f11094e = false;

        /* renamed from: f */
        private FileOutputStream[] f11095f;

        public C2216c() {
            setName("RefocusFdCreator");
            start();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(3:15|16|24)(3:17|18|25)|22|8|7) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0018 A[LOOP:0: B:7:0x0018->B:22:0x0018, LOOP_START, SYNTHETIC, Splitter:B:7:0x0018] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void run() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002f }
                com.meizu.savior.ChangeQuickRedirect r3 = f11090a     // Catch:{ all -> 0x002f }
                r4 = 0
                r5 = 5067(0x13cb, float:7.1E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002f }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x002f }
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002f }
                boolean r1 = r1.isSupported     // Catch:{ all -> 0x002f }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r1 = r8.f11094e     // Catch:{ all -> 0x002f }
                if (r1 == 0) goto L_0x001e
                monitor-exit(r8)
                return
            L_0x001e:
                boolean r1 = r8.f11092c     // Catch:{ all -> 0x002f }
                if (r1 != 0) goto L_0x0026
                r8.wait()     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0018
            L_0x0026:
                r8.m11925e()     // Catch:{ all -> 0x002f }
                r8.f11092c = r0     // Catch:{ all -> 0x002f }
                r8.notifyAll()     // Catch:{ all -> 0x002f }
                goto L_0x0018
            L_0x002f:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.RefocusMode.C2216c.run():void");
        }

        /* renamed from: a */
        public synchronized void mo20646a() {
            if (!PatchProxy.proxy(new Object[0], this, f11090a, false, 5068, new Class[0], Void.TYPE).isSupported) {
                if (this.f11093d == null) {
                    this.f11092c = true;
                    notifyAll();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|21|20|9|8) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x001c A[LOOP:0: B:8:0x001c->B:20:0x001c, LOOP_START, SYNTHETIC, Splitter:B:8:0x001c] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.io.FileDescriptor[] mo20647b() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002b }
                com.meizu.savior.ChangeQuickRedirect r3 = f11090a     // Catch:{ all -> 0x002b }
                r4 = 0
                r5 = 5069(0x13cd, float:7.103E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002b }
                java.lang.Class<java.io.FileDescriptor[]> r7 = java.io.FileDescriptor[].class
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002b }
                boolean r1 = r0.isSupported     // Catch:{ all -> 0x002b }
                if (r1 == 0) goto L_0x001c
                java.lang.Object r0 = r0.result     // Catch:{ all -> 0x002b }
                java.io.FileDescriptor[] r0 = (java.io.FileDescriptor[]) r0     // Catch:{ all -> 0x002b }
                monitor-exit(r8)
                return r0
            L_0x001c:
                boolean r0 = r8.f11092c     // Catch:{ all -> 0x002b }
                if (r0 == 0) goto L_0x0024
                r8.wait()     // Catch:{ InterruptedException -> 0x001c }
                goto L_0x001c
            L_0x0024:
                java.io.FileDescriptor[] r0 = r8.f11093d     // Catch:{ all -> 0x002b }
                r1 = 0
                r8.f11093d = r1     // Catch:{ all -> 0x002b }
                monitor-exit(r8)
                return r0
            L_0x002b:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.RefocusMode.C2216c.mo20647b():java.io.FileDescriptor[]");
        }

        /* renamed from: e */
        private void m11925e() {
            boolean z;
            if (!PatchProxy.proxy(new Object[0], this, f11090a, false, 5070, new Class[0], Void.TYPE).isSupported) {
                if (RefocusMode.this.f11061p == null) {
                    ArrayList unused = RefocusMode.this.f11061p = new ArrayList(8);
                } else {
                    RefocusMode.this.f11061p.clear();
                }
                if (RefocusMode.this.f11063r == null) {
                    ArrayList unused2 = RefocusMode.this.f11063r = new ArrayList(8);
                } else {
                    RefocusMode.this.f11063r.clear();
                }
                if (RefocusMode.this.f11062q == null) {
                    ArrayList unused3 = RefocusMode.this.f11062q = new ArrayList(8);
                } else {
                    RefocusMode.this.f11062q.clear();
                }
                this.f11093d = new FileDescriptor[8];
                this.f11095f = new FileOutputStream[8];
                for (int i = 0; i < 8; i++) {
                    try {
                        String str = "." + i;
                        File file = new File(Storage.m7750a().mo18624a(str, (String) null, false) + ".tmp");
                        if (file.exists()) {
                            z = true;
                        } else {
                            z = file.createNewFile();
                        }
                        if (z) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            this.f11095f[i] = fileOutputStream;
                            this.f11093d[i] = fileOutputStream.getFD();
                            RefocusMode.this.f11061p.add(file);
                        } else {
                            LogUtil.m15949b(RefocusMode.f11045b, "create refocus file failed !!!");
                        }
                    } catch (Exception e) {
                        LogUtil.m15949b(RefocusMode.f11045b, "create capture file fail " + e);
                    }
                }
            }
        }

        /* renamed from: c */
        public synchronized void mo20648c() {
            if (!PatchProxy.proxy(new Object[0], this, f11090a, false, 5071, new Class[0], Void.TYPE).isSupported) {
                this.f11094e = true;
                mo20649d();
                notifyAll();
            }
        }

        /* renamed from: d */
        public void mo20649d() {
            if (!PatchProxy.proxy(new Object[0], this, f11090a, false, 5072, new Class[0], Void.TYPE).isSupported) {
                try {
                    if (this.f11095f != null) {
                        for (FileOutputStream close : this.f11095f) {
                            close.close();
                        }
                        this.f11095f = null;
                    }
                } catch (Exception unused) {
                    LogUtil.m15952c(RefocusMode.f11045b, "close burst file stream failed");
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.q$b */
    /* compiled from: RefocusMode */
    private class C2215b implements Serializable, InvocationHandler {

        /* renamed from: a */
        public static ChangeQuickRedirect f11088a = null;
        private static final long serialVersionUID = 1;

        private C2215b() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, method, objArr}, this, f11088a, false, 5066, new Class[]{Object.class, Method.class, Object[].class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            if (!method.equals(RefocusMode.f11042F)) {
                return null;
            }
            RefocusMode.this.m11885a(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3]);
            return null;
        }
    }

    /* renamed from: M */
    private void m11880M() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5049, new Class[0], Void.TYPE).isSupported) {
            try {
                if (f11041E == null) {
                    f11041E = Class.forName("android.hardware.Camera$RefocusPictureCallback");
                }
                if (f11042F == null) {
                    f11042F = f11041E.getMethod("onPictureTaken", new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Camera.class});
                }
                if (f11043G == null) {
                    f11043G = Camera.class.getMethod("takePicture", new Class[]{Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, f11041E});
                }
                if (this.f11050H == null) {
                    this.f11050H = Proxy.newProxyInstance(f11041E.getClassLoader(), new Class[]{f11041E}, new C2215b());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11885a(byte[] bArr, int i, int i2, Camera camera) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), camera}, this, f11044a, false, 5050, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Camera.class}, Void.TYPE).isSupported && this.f11063r != null && this.f11061p != null && this.f11061p.size() != 0 && this.f11055f != null) {
            if (m11886a(i2, 2)) {
                boolean a = m11886a(i2, 8);
                if (m11886a(i2, 4)) {
                    LogUtil.m15949b(f11045b, "refocus callback, delete a failed image");
                    this.f11061p.get(i - 1).delete();
                    if (a) {
                        this.f11068w = true;
                        return;
                    }
                    return;
                }
                int size = this.f11063r.size();
                if (size == 0) {
                    LogUtil.m15949b(f11045b, "mRefocusFilesInfo is empty! Cannot happen!");
                    return;
                }
                if (i > size) {
                    LogUtil.m15952c(f11045b, "refocus callback, HAL deliver the wrong number!!!");
                    i = size;
                }
                C2217d dVar = this.f11063r.get(i - 1);
                dVar.f11100e = i;
                dVar.f11098c = a;
                if (this.f11055f != null) {
                    this.f11055f.mo20643a(dVar);
                    if (a) {
                        LogUtil.m15952c(f11045b, "refocus callback,last-image-saved message arrive.");
                    }
                }
            } else if (m11886a(i2, 16)) {
                LogUtil.m15952c(f11045b, "refocus callback, HAL-all-done message arrive.");
                mo20539R().mo18188dL().sendEmptyMessage(1);
                this.f11066u = true;
                m11884a(false);
            } else {
                if (!m11886a(i2, 1)) {
                    LogUtil.m15949b(f11045b, "refocus callback, error, why not encoding flag !!!");
                }
                this.f11060o++;
                if (this.f11060o == 8) {
                    mo20539R().mo18275x(2);
                }
                if (this.f11060o == 8) {
                    this.f11052c.mo22555e();
                }
                C2217d dVar2 = new C2217d();
                dVar2.f11096a = this.f11070y;
                dVar2.f11097b = i;
                if (DeviceHelper.f13841U) {
                    if (this.f11060o == 8) {
                        dVar2.f11099d = true;
                    } else {
                        dVar2.f11099d = false;
                    }
                } else if (this.f11060o == 1) {
                    dVar2.f11099d = true;
                } else {
                    dVar2.f11099d = false;
                }
                if (this.f11063r != null) {
                    this.f11063r.add(dVar2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11884a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11044a, false, 5051, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f11066u) {
                this.f11071z.removeMessages(1);
            }
            if (this.f11066u && this.f11067v) {
                this.f11054e = false;
                mo20539R().mo18122c(z);
                this.f11052c.mo22551a(mo20539R().mo18200dX());
                mo20540S().mo17669a((String) null);
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.REFOCUS;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5052, new Class[0], Void.TYPE).isSupported) {
            mo20405i_();
            mo20539R().mo18267u().mo22142b(true);
            mo20541T().mo20345j();
            this.f11052c.mo22552b();
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5053, new Class[0], Void.TYPE).isSupported) {
            m11878K();
        }
    }

    /* renamed from: W */
    public void mo20544W() {
        if (!PatchProxy.proxy(new Object[0], this, f11044a, false, 5054, new Class[0], Void.TYPE).isSupported) {
            mo20636q();
        }
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f11044a, false, 5055, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20635c();
        return true;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.AUTO;
    }
}
