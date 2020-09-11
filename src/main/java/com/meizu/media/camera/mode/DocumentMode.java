package com.meizu.media.camera.mode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.ViewCompat;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p068e.AlorgrithmManager;
import com.meizu.media.camera.p077ui.MzDocumentUI;
import com.meizu.media.camera.util.CameraSizeDefault;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.media.cameraAlgorithm.yuv.YuvUtil;
import com.meizu.media.mzdocumentscannersdk.MzCropDSController;
import com.meizu.media.mzdocumentscannersdk.MzDSController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.i */
public class DocumentMode extends CameraMode implements MzFocusRenderer.C2745d {

    /* renamed from: a */
    public static ChangeQuickRedirect f10792a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10793b = new LogUtil.C2630a("DocumentMode");

    /* renamed from: c */
    private static final Object f10794c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraModeListener f10795d;

    /* renamed from: e */
    private UsageStatsHelper f10796e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MzDocumentUI f10797f;

    /* renamed from: g */
    private C2183c f10798g = new C2183c();

    /* renamed from: l */
    private ImageReader f10799l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public byte[] f10800m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public HandlerThread f10801n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C2181a f10802o;

    /* renamed from: p */
    private C2182b f10803p;

    /* renamed from: q */
    private MzDSController f10804q;

    /* renamed from: r */
    private MzCropDSController f10805r;

    /* renamed from: s */
    private Point[] f10806s;

    /* renamed from: t */
    private boolean f10807t = false;

    /* renamed from: u */
    private int f10808u;

    /* renamed from: v */
    private int f10809v;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
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

    /* renamed from: com.meizu.media.camera.mode.i$c */
    /* compiled from: DocumentMode */
    private final class C2183c implements Camera.PreviewCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f10817a;

        private C2183c() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraProxyV1 eVar;
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f10817a, false, 4771, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported && !DocumentMode.this.f10795d.mo18200dX()) {
                if (DocumentMode.this.f10802o.f10814c && !DocumentMode.this.f10802o.hasMessages(1)) {
                    Message.obtain(DocumentMode.this.f10802o, 1).sendToTarget();
                }
                if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (eVar = (CameraProxyV1) CameraController.m8868g().mo19522k()) != null && eVar.mo19730a() != null) {
                    ((Camera) eVar.mo19730a()).setPreviewCallback((Camera.PreviewCallback) null);
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.i$a */
    /* compiled from: DocumentMode */
    private final class C2181a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10812a;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f10814c = true;

        C2181a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10812a, false, 4768, new Class[]{Message.class}, Void.TYPE).isSupported && this.f10814c) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1) {
                    if (i == 5) {
                        try {
                            this.f10814c = false;
                            DocumentMode.this.f10801n.getLooper().quit();
                            HandlerThread unused = DocumentMode.this.f10801n = null;
                        } catch (Exception unused2) {
                            LogUtil.m15949b(DocumentMode.f10793b, "DecodeHandlerThread quit failed");
                        }
                    }
                } else if (!DocumentMode.this.mo20539R().mo18200dX()) {
                    DocumentMode.this.m11458L();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.i$b */
    /* compiled from: DocumentMode */
    private static class C2182b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10815a;

        /* renamed from: b */
        private WeakReference<DocumentMode> f10816b;

        C2182b(DocumentMode iVar) {
            super(Looper.getMainLooper());
            this.f10816b = new WeakReference<>(iVar);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10815a, false, 4769, new Class[]{Message.class}, Void.TYPE).isSupported) {
                super.handleMessage(message);
                ((DocumentMode) this.f10816b.get()).m11457K();
                switch (message.what) {
                    case 2:
                        if (message.obj != null && this.f10816b.get() != null) {
                            ((DocumentMode) this.f10816b.get()).f10797f.mo22293a((Point[]) message.obj);
                            ((DocumentMode) this.f10816b.get()).f10797f.mo22296d();
                            return;
                        }
                        return;
                    case 3:
                    case 4:
                        if (this.f10816b.get() != null) {
                            ((DocumentMode) this.f10816b.get()).f10797f.mo22297e();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* renamed from: a */
        public void mo20559a() {
            if (!PatchProxy.proxy(new Object[0], this, f10815a, false, 4770, new Class[0], Void.TYPE).isSupported) {
                if (this.f10816b.get() != null) {
                    Message.obtain(((DocumentMode) this.f10816b.get()).f10802o, 5).sendToTarget();
                }
                removeMessages(2);
                removeMessages(4);
                removeMessages(3);
            }
        }
    }

    DocumentMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10795d = hVar;
        if (this.f10797f == null) {
            this.f10797f = mo20539R().mo18267u().mo22112aa();
        }
        if (uVar != null) {
            m11472r();
        }
        m11471q();
        this.f10796e = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: q */
    private void m11471q() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4736, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10793b, "init");
            if (this.f10801n == null) {
                this.f10801n = new HandlerThread("document bitmap thread");
                this.f10801n.start();
                this.f10802o = new C2181a(this.f10801n.getLooper());
            } else {
                this.f10802o.removeMessages(5);
            }
            if (this.f10803p == null) {
                this.f10803p = new C2182b(this);
            }
            if (this.f10804q == null) {
                this.f10804q = new MzDSController();
                this.f10804q.initDSController((Activity) this.f10787i);
            }
            if (this.f10805r == null) {
                this.f10805r = new MzCropDSController();
                this.f10805r.initController();
            }
        }
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f10792a, false, 4737, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            super.mo20387a(uVar);
            m11472r();
        }
    }

    /* renamed from: r */
    private void m11472r() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4738, new Class[0], Void.TYPE).isSupported) {
            if (this.f10797f != null) {
                this.f10797f.mo22291a(mo20542U());
            }
            mo20542U().mo21592g(MzUIController.f12277E);
            this.f10788j.mo21581d(134, true);
            if (this.f10795d.mo17914ak() != null) {
                this.f10795d.mo17914ak().mo20230j(true);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10792a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4739, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                mo20542U().mo21506a(5);
            }
            if (!z2) {
                this.f10797f.mo22292a(!z);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4740, new Class[0], Void.TYPE).isSupported) {
            if (!(!NavigationBarUtils.m15972a() || this.f10787i == null || this.f10788j == null)) {
                this.f10788j.mo21635t((int) ViewCompat.MEASURED_STATE_MASK);
            }
            mo20542U().mo21506a(5);
            this.f10797f.mo22295c();
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4741, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10793b, "release");
            this.f10788j.mo21581d(134, true);
            this.f10788j.mo21533a(false, false, false);
            if (this.f10795d.mo17914ak() != null) {
                this.f10795d.mo17914ak().mo20230j(false);
            }
            this.f10797f.mo22294b();
            this.f10800m = null;
            this.f10807t = false;
            synchronized (this) {
                if (this.f10799l != null) {
                    this.f10799l.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                }
            }
            if (this.f10803p != null) {
                this.f10803p.mo20559a();
                this.f10803p = null;
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.DOCUMENT;
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4742, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10793b, "pause");
            if (this.f10788j.mo21602i() && CameraOptTask.m7846m()) {
                mo20542U().mo21510a(22, true);
            }
            this.f10797f.mo22294b();
            this.f10800m = null;
            this.f10807t = false;
            if (this.f10803p != null) {
                this.f10803p.mo20559a();
                this.f10803p = null;
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4743, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10793b, "resume");
            if (CameraOptTask.m7848o()) {
                this.f10788j.mo21625q();
            } else if (((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) && CameraController.m8868g().mo19522k() != null) {
                this.f10788j.mo21611l(true);
            }
            mo20542U().mo21506a(5);
            this.f10797f.mo22288a();
            m11471q();
            if (this.f10807t) {
                LogUtil.m15942a(f10793b, "start request preview frame");
                m11457K();
                this.f10807t = false;
            }
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4744, new Class[0], Void.TYPE).isSupported) {
            if (!CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21510a(-1, true);
                mo20542U().mo21581d(128, true);
            }
            m11459M();
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4745, new Class[0], Void.TYPE).isSupported) {
            if (!CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21510a(-1, true);
                mo20542U().mo21581d(128, true);
            }
            m11459M();
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10792a, false, 4746, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            mo20539R().mo18267u().mo22131at().mo23331a((MzFocusRenderer.C2745d) this);
            if (this.f10795d.mo17914ak() != null) {
                this.f10795d.mo17914ak().mo20230j(true);
                if (!mo20539R().mo18191dO()) {
                    return;
                }
                if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                    this.f10795d.mo17914ak().mo20224g(true);
                }
            }
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10792a, false, 4747, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20542U().mo21581d(4, false);
        mo20542U().mo21581d(128, false);
        mo20542U().mo21510a(-1, false);
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10792a, false, 4748, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String a = CameraSizeDefault.m16165a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: B */
    public MzFocusRenderer.C2743b mo20378B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10792a, false, 4752, new Class[0], MzFocusRenderer.C2743b.class);
        return proxy.isSupported ? (MzFocusRenderer.C2743b) proxy.result : this.f10795d.mo17914ak().mo20245x();
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4753, new Class[0], Void.TYPE).isSupported && this.f10795d.mo18267u().mo22131at() != null) {
            this.f10795d.mo18267u().mo22131at().mo23337e();
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10792a, false, 4754, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        Point l = CameraController.m8868g().mo19524l();
        if (l != null) {
            this.f10808u = l.x;
            this.f10809v = l.y;
            if (this.f10799l != null) {
                this.f10799l.close();
            }
            m11471q();
            this.f10799l = ImageReader.newInstance(this.f10808u, this.f10809v, 35, 1);
            this.f10797f.mo22290a(this.f10808u, this.f10809v);
            arrayList.add(this.f10799l.getSurface());
            this.f10799l.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10810a;

                /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b1, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b8, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onImageAvailable(android.media.ImageReader r11) {
                    /*
                        r10 = this;
                        r0 = 1
                        java.lang.Object[] r1 = new java.lang.Object[r0]
                        r8 = 0
                        r1[r8] = r11
                        com.meizu.savior.ChangeQuickRedirect r3 = f10810a
                        java.lang.Class[] r6 = new java.lang.Class[r0]
                        java.lang.Class<android.media.ImageReader> r2 = android.media.ImageReader.class
                        r6[r8] = r2
                        java.lang.Class r7 = java.lang.Void.TYPE
                        r4 = 0
                        r5 = 4767(0x129f, float:6.68E-42)
                        r2 = r10
                        com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                        boolean r1 = r1.isSupported
                        if (r1 == 0) goto L_0x001d
                        return
                    L_0x001d:
                        com.meizu.media.camera.mode.i r1 = com.meizu.media.camera.mode.DocumentMode.this
                        monitor-enter(r1)
                        android.media.Image r11 = r11.acquireNextImage()     // Catch:{ all -> 0x00cf }
                        r2 = 0
                        com.meizu.media.camera.mode.i r3 = com.meizu.media.camera.mode.DocumentMode.this     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.h r3 = r3.f10795d     // Catch:{ Throwable -> 0x00bb }
                        boolean r3 = r3.mo18200dX()     // Catch:{ Throwable -> 0x00bb }
                        if (r3 != 0) goto L_0x00b2
                        if (r11 != 0) goto L_0x0035
                        goto L_0x00b2
                    L_0x0035:
                        int r3 = r11.getHeight()     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i r4 = com.meizu.media.camera.mode.DocumentMode.this     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i$a r4 = r4.f10802o     // Catch:{ Throwable -> 0x00bb }
                        boolean r4 = r4.f10814c     // Catch:{ Throwable -> 0x00bb }
                        if (r4 == 0) goto L_0x00ab
                        com.meizu.media.camera.mode.i r4 = com.meizu.media.camera.mode.DocumentMode.this     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i$a r4 = r4.f10802o     // Catch:{ Throwable -> 0x00bb }
                        boolean r4 = r4.hasMessages(r0)     // Catch:{ Throwable -> 0x00bb }
                        if (r4 != 0) goto L_0x00ab
                        android.media.Image$Plane[] r4 = r11.getPlanes()     // Catch:{ Throwable -> 0x00bb }
                        r4 = r4[r8]     // Catch:{ Throwable -> 0x00bb }
                        java.nio.ByteBuffer r4 = r4.getBuffer()     // Catch:{ Throwable -> 0x00bb }
                        android.media.Image$Plane[] r5 = r11.getPlanes()     // Catch:{ Throwable -> 0x00bb }
                        r6 = 2
                        r5 = r5[r6]     // Catch:{ Throwable -> 0x00bb }
                        java.nio.ByteBuffer r5 = r5.getBuffer()     // Catch:{ Throwable -> 0x00bb }
                        android.media.Image$Plane[] r7 = r11.getPlanes()     // Catch:{ Throwable -> 0x00bb }
                        r7 = r7[r8]     // Catch:{ Throwable -> 0x00bb }
                        int r7 = r7.getRowStride()     // Catch:{ Throwable -> 0x00bb }
                        int r7 = r7 * r3
                        int r3 = r7 * 3
                        int r3 = r3 / r6
                        java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ Throwable -> 0x00bb }
                        byte[] r6 = r3.array()     // Catch:{ Throwable -> 0x00bb }
                        int r9 = r4.remaining()     // Catch:{ Throwable -> 0x00bb }
                        r4.get(r6, r8, r9)     // Catch:{ Throwable -> 0x00bb }
                        byte[] r4 = r3.array()     // Catch:{ Throwable -> 0x00bb }
                        int r6 = r5.remaining()     // Catch:{ Throwable -> 0x00bb }
                        r5.get(r4, r7, r6)     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i r4 = com.meizu.media.camera.mode.DocumentMode.this     // Catch:{ Throwable -> 0x00bb }
                        byte[] r5 = r3.array()     // Catch:{ Throwable -> 0x00bb }
                        byte[] unused = r4.f10800m = r5     // Catch:{ Throwable -> 0x00bb }
                        r3.rewind()     // Catch:{ Throwable -> 0x00bb }
                        r11.close()     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i r3 = com.meizu.media.camera.mode.DocumentMode.this     // Catch:{ Throwable -> 0x00bb }
                        com.meizu.media.camera.mode.i$a r3 = r3.f10802o     // Catch:{ Throwable -> 0x00bb }
                        android.os.Message r0 = android.os.Message.obtain(r3, r0)     // Catch:{ Throwable -> 0x00bb }
                        r0.sendToTarget()     // Catch:{ Throwable -> 0x00bb }
                    L_0x00ab:
                        if (r11 == 0) goto L_0x00b0
                        r11.close()     // Catch:{ all -> 0x00cf }
                    L_0x00b0:
                        monitor-exit(r1)     // Catch:{ all -> 0x00cf }
                        return
                    L_0x00b2:
                        if (r11 == 0) goto L_0x00b7
                        r11.close()     // Catch:{ all -> 0x00cf }
                    L_0x00b7:
                        monitor-exit(r1)     // Catch:{ all -> 0x00cf }
                        return
                    L_0x00b9:
                        r0 = move-exception
                        goto L_0x00be
                    L_0x00bb:
                        r0 = move-exception
                        r2 = r0
                        throw r2     // Catch:{ all -> 0x00b9 }
                    L_0x00be:
                        if (r11 == 0) goto L_0x00ce
                        if (r2 == 0) goto L_0x00cb
                        r11.close()     // Catch:{ Throwable -> 0x00c6 }
                        goto L_0x00ce
                    L_0x00c6:
                        r11 = move-exception
                        r2.addSuppressed(r11)     // Catch:{ all -> 0x00cf }
                        goto L_0x00ce
                    L_0x00cb:
                        r11.close()     // Catch:{ all -> 0x00cf }
                    L_0x00ce:
                        throw r0     // Catch:{ all -> 0x00cf }
                    L_0x00cf:
                        r11 = move-exception
                        monitor-exit(r1)     // Catch:{ all -> 0x00cf }
                        throw r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.DocumentMode.C21801.onImageAvailable(android.media.ImageReader):void");
                }
            }, CameraController.m8868g().mo19518i());
        }
        return arrayList;
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4755, new Class[0], Void.TYPE).isSupported) {
            Point l = CameraController.m8868g().mo19524l();
            if (l != null) {
                this.f10808u = l.x;
                this.f10809v = l.y;
                this.f10800m = new byte[(this.f10808u * this.f10809v * 2)];
            }
            m11471q();
            this.f10797f.mo22290a(this.f10808u, this.f10809v);
            if (!this.f10787i.mo17677n()) {
                LogUtil.m15942a(f10793b, "start request preview frame");
                m11457K();
                return;
            }
            this.f10807t = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m11457K() {
        CameraProxyV1 eVar;
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4756, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (eVar = (CameraProxyV1) CameraController.m8868g().mo19522k()) != null && eVar.mo19730a() != null && !this.f10787i.mo17677n()) {
            ((Camera) eVar.mo19730a()).setPreviewCallbackWithBuffer(this.f10798g);
            ((Camera) eVar.mo19730a()).addCallbackBuffer(this.f10800m);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m11458L() {
        Point[] documentScan;
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4757, new Class[0], Void.TYPE).isSupported) {
            if (this.f10803p == null || this.f10795d.mo18200dX() || this.f10800m == null) {
                LogUtil.m15942a(f10793b, "documentMode has release");
                return;
            }
            boolean a = LogUtil.m15947a(f10793b, 3);
            if (a) {
                LogUtil.m15942a(f10793b, "start scan");
            }
            byte[] bArr = new byte[131072];
            YuvUtil.scaleNV21Data(this.f10800m, this.f10808u, this.f10809v, bArr, 256, 256);
            int[] a2 = AlorgrithmManager.m10025a(bArr, 256, 256, a);
            if (a) {
                LogUtil.m15942a(f10793b, "decode preview finish");
            }
            synchronized (f10794c) {
                documentScan = this.f10804q.documentScan(a2, 256, 256, this.f10808u, this.f10809v);
            }
            if (documentScan != null) {
                boolean a3 = m11463a(documentScan, this.f10808u, this.f10809v, a);
                if (a3) {
                    this.f10806s = documentScan;
                } else {
                    this.f10806s = null;
                }
                if (this.f10803p == null) {
                    return;
                }
                if (a3) {
                    this.f10803p.removeMessages(4);
                    this.f10803p.removeMessages(150);
                    Message.obtain(this.f10803p, 2, documentScan).sendToTarget();
                } else if (!this.f10803p.hasMessages(4)) {
                    this.f10803p.sendMessageDelayed(Message.obtain(this.f10803p, 4, documentScan), 150);
                }
            } else {
                LogUtil.m15942a(f10793b, "scan bitmap failed");
                if (this.f10803p != null && !this.f10803p.hasMessages(3)) {
                    this.f10803p.sendMessageDelayed(Message.obtain(this.f10803p, 3), 150);
                }
            }
        }
    }

    /* renamed from: a */
    public Point[] mo18021a(Bitmap bitmap) {
        Point[] documentScan;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, f10792a, false, 4758, new Class[]{Bitmap.class}, Point[].class);
        if (proxy.isSupported) {
            return (Point[]) proxy.result;
        }
        synchronized (f10794c) {
            documentScan = this.f10804q.documentScan(bitmap);
        }
        if (m11463a(documentScan, bitmap.getWidth(), bitmap.getHeight(), true)) {
            return documentScan;
        }
        if (this.f10806s != null) {
            Point[] pointArr = new Point[this.f10806s.length];
            float f = ((float) CameraController.m8868g().mo19520j().x) / ((float) this.f10808u);
            for (int i = 0; i < this.f10806s.length; i++) {
                int i2 = (i + 3) % 4;
                pointArr[i] = new Point((int) (((float) bitmap.getWidth()) - (((float) this.f10806s[i2].y) * f)), (int) (((float) this.f10806s[i2].x) * f));
            }
            return pointArr;
        }
        int width = bitmap.getWidth() / 4;
        int height = bitmap.getHeight() / 4;
        int i3 = width * 3;
        int i4 = height * 3;
        return new Point[]{new Point(width, height), new Point(i3, height), new Point(i3, i4), new Point(width, i4)};
    }

    /* renamed from: a */
    public Bitmap mo17987a(Bitmap bitmap, Point[] pointArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, pointArr}, this, f10792a, false, 4759, new Class[]{Bitmap.class, Point[].class}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : this.f10805r.documentCrop(bitmap, pointArr);
    }

    /* renamed from: I */
    public void mo20384I() {
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4761, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = this.f10796e.mo22688a(new String[]{"mode", "location", "voice", "meshline", "level", "capture_type", "sd_card"});
            a.put("capture_time", Long.toString(this.f10795d.mo18186dJ()));
            a.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            a.put("zoom", Integer.toString(this.f10795d.mo18267u().mo22199w()));
            a.put("flash", CameraController.m8868g().mo19534q().key);
            a.put("document_result", this.f10806s == null ? "0" : "1");
            String str = "error mode";
            if (!(this.f10795d.mo17914ak() == null || (ak = this.f10795d.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str = h.getKey();
            }
            a.put("focus_mode", str);
            this.f10796e.mo22693a("capture_info", a);
        }
    }

    /* renamed from: e */
    public void mo20556e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10792a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4762, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo20556e(i);
            this.f10797f.mo22289a(i);
        }
    }

    /* renamed from: ag */
    public void mo20552ag() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4763, new Class[0], Void.TYPE).isSupported) {
            super.mo20552ag();
            this.f10797f.mo22288a();
        }
    }

    /* renamed from: a */
    private boolean m11463a(Point[] pointArr, int i, int i2, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{pointArr, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)}, this, f10792a, false, 4764, new Class[]{Point[].class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean z2 = false;
        for (Point point : pointArr) {
            if (z) {
                LogUtil.m15942a(f10793b, "scan finish, result is " + point);
            }
            if (!((point.x == 0 || point.x == i) && (point.y == 0 || point.y == i2))) {
                if (!z) {
                    return true;
                }
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: M */
    private void m11459M() {
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4765, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && this.f10787i != null && !this.f10787i.mo17677n()) {
            CameraController.m8868g().mo19518i().post(new Runnable() {
                public final void run() {
                    DocumentMode.this.m11460N();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void m11460N() {
        CameraProxyV1 eVar;
        if (!PatchProxy.proxy(new Object[0], this, f10792a, false, 4766, new Class[0], Void.TYPE).isSupported && (eVar = (CameraProxyV1) CameraController.m8868g().mo19522k()) != null && eVar.mo19730a() != null && this.f10787i != null && !this.f10787i.mo17677n()) {
            ((Camera) eVar.mo19730a()).startPreview();
            if (!this.f10803p.hasMessages(3) && !this.f10803p.hasMessages(4) && !this.f10803p.hasMessages(2)) {
                m11457K();
            }
        }
    }
}
