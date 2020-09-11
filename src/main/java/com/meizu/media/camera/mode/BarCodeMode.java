package com.meizu.media.camera.mode;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResultType;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.result.ISBNResultHandler;
import com.meizu.media.camera.barcode.result.ProductResultHandler;
import com.meizu.media.camera.barcode.result.ResultActionBarItem;
import com.meizu.media.camera.barcode.result.ResultHandler;
import com.meizu.media.camera.barcode.result.ResultHandlerFactory;
import com.meizu.media.camera.barcode.result.ResultInfoAdapter;
import com.meizu.media.camera.barcode.result.TextResultHandler;
import com.meizu.media.camera.barcode.result.URIResultHandler;
import com.meizu.media.camera.barcode.result.WifiResultHandler;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzBarcodeUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.DownloadCache;
import com.meizu.media.camera.util.ImageReaderHolder;
import com.meizu.media.camera.util.IntentHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.cameraAlgorithm.zbar.Image;
import com.meizu.safe.engine.url.IMyUrlCheckService;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.meizu.media.camera.mode.d */
public class BarCodeMode extends CameraMode implements MzBarcodeUI.C2472a {

    /* renamed from: A */
    private static final Set<BarcodeFormat> f10700A = EnumSet.copyOf(f10702b);

    /* renamed from: a */
    public static ChangeQuickRedirect f10701a;

    /* renamed from: b */
    static final Set<BarcodeFormat> f10702b = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});

    /* renamed from: c */
    static final Set<BarcodeFormat> f10703c = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);

    /* renamed from: d */
    static final Set<BarcodeFormat> f10704d = EnumSet.of(BarcodeFormat.QR_CODE);

    /* renamed from: e */
    static final Set<BarcodeFormat> f10705e = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    /* renamed from: f */
    static final Set<BarcodeFormat> f10706f = EnumSet.of(BarcodeFormat.AZTEC);

    /* renamed from: g */
    static final Set<BarcodeFormat> f10707g = EnumSet.of(BarcodeFormat.PDF_417);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final LogUtil.C2630a f10708l = new LogUtil.C2630a("BarCodeMode");
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static int f10709o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static int f10710p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static int f10711q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static int f10712r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static int f10713s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static int f10714t;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C2175d f10715B;

    /* renamed from: C */
    private C2174c f10716C = new C2174c();
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ResultInfoAdapter f10717D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f10718E = true;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f10719F = true;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public byte[] f10720G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public byte[] f10721H;

    /* renamed from: I */
    private C2176e f10722I = new C2176e();

    /* renamed from: J */
    private ImageReader f10723J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public IMyUrlCheckService f10724K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f10725L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public ResultHandler f10726M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f10727N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public long f10728O = 0;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public C2177f f10729P = new C2177f();

    /* renamed from: Q */
    private LinkedList<Surface> f10730Q = null;

    /* renamed from: R */
    private ServiceConnection f10731R = new ServiceConnection() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10740a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!PatchProxy.proxy(new Object[]{componentName, iBinder}, this, f10740a, false, 4669, new Class[]{ComponentName.class, IBinder.class}, Void.TYPE).isSupported) {
                IMyUrlCheckService unused = BarCodeMode.this.f10724K = IMyUrlCheckService.C2795a.m16971a(iBinder);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (!PatchProxy.proxy(new Object[]{componentName}, this, f10740a, false, 4670, new Class[]{ComponentName.class}, Void.TYPE).isSupported) {
                IMyUrlCheckService unused = BarCodeMode.this.f10724K = null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MzBarcodeUI f10732m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f10733n = false;

    /* renamed from: u */
    private Rect f10734u;

    /* renamed from: v */
    private long f10735v = System.currentTimeMillis();

    /* renamed from: w */
    private long f10736w = 0;

    /* renamed from: x */
    private int f10737x = 0;

    /* renamed from: y */
    private long[] f10738y = {255, 255, 255, 255};

    /* renamed from: z */
    private Boolean f10739z;

    /* renamed from: A */
    public int mo20377A() {
        return -1;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return true;
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return true;
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
        return true;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    static {
        f10700A.addAll(f10703c);
    }

    /* renamed from: com.meizu.media.camera.mode.d$f */
    /* compiled from: BarCodeMode */
    private class C2177f {

        /* renamed from: a */
        public static ChangeQuickRedirect f10767a;

        /* renamed from: c */
        private Map<DecodeHintType, Object> f10769c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f10770d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public C2178a f10771e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public MultiFormatReader f10772f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f10773g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f10774h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Object f10775i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public Image f10776j;

        private C2177f() {
            this.f10770d = false;
            this.f10771e = null;
            this.f10773g = false;
            this.f10774h = true;
            this.f10775i = new Object();
            this.f10776j = null;
        }

        /* renamed from: a */
        public void mo20536a(Map<DecodeHintType, Object> map) {
            if (!PatchProxy.proxy(new Object[]{map}, this, f10767a, false, 4681, new Class[]{Map.class}, Void.TYPE).isSupported) {
                this.f10772f = new MultiFormatReader();
                this.f10772f.setHints(map);
                this.f10769c = map;
            }
        }

        /* renamed from: com.meizu.media.camera.mode.d$f$a */
        /* compiled from: BarCodeMode */
        private class C2178a extends Thread {

            /* renamed from: a */
            public static ChangeQuickRedirect f10777a;

            private C2178a() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f9, code lost:
                return;
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x01ad */
            /* JADX WARNING: Removed duplicated region for block: B:101:0x01cc A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x01f0 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r19 = this;
                    r8 = r19
                    r9 = 0
                    java.lang.Object[] r1 = new java.lang.Object[r9]
                    com.meizu.savior.ChangeQuickRedirect r3 = f10777a
                    java.lang.Class[] r6 = new java.lang.Class[r9]
                    java.lang.Class r7 = java.lang.Void.TYPE
                    r4 = 0
                    r5 = 4684(0x124c, float:6.564E-42)
                    r2 = r19
                    com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                    boolean r0 = r0.isSupported
                    if (r0 == 0) goto L_0x0019
                    return
                L_0x0019:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    boolean r0 = r0.f10774h
                    if (r0 == 0) goto L_0x0223
                    int r0 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    r1 = 0
                    if (r0 == 0) goto L_0x021d
                    int r0 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    if (r0 != 0) goto L_0x0030
                    goto L_0x021d
                L_0x0030:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    boolean r0 = r0.f10719F
                    if (r0 == 0) goto L_0x0058
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10720G
                    if (r0 == 0) goto L_0x0058
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10720G
                    if (r0 != 0) goto L_0x004f
                    goto L_0x0019
                L_0x004f:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10720G
                    goto L_0x0075
                L_0x0058:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10721H
                    if (r0 == 0) goto L_0x0217
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10721H
                    if (r0 != 0) goto L_0x006d
                    goto L_0x0019
                L_0x006d:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    byte[] r0 = r0.f10721H
                L_0x0075:
                    if (r0 == 0) goto L_0x0216
                    int r2 = r0.length
                    if (r2 != 0) goto L_0x007c
                    goto L_0x0216
                L_0x007c:
                    r3 = r1
                    r2 = 0
                L_0x007e:
                    r4 = 90
                    if (r2 >= r4) goto L_0x01fa
                    int r4 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    if (r4 == 0) goto L_0x01f4
                    int r4 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    if (r4 != 0) goto L_0x0090
                    goto L_0x01f4
                L_0x0090:
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r4 = com.meizu.media.camera.mode.BarCodeMode.this
                    int r5 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    int r6 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    float r7 = (float) r2
                    android.graphics.Bitmap r4 = r4.m11231a((byte[]) r0, (int) r5, (int) r6, (float) r7)
                    if (r4 != 0) goto L_0x00a5
                    goto L_0x01f0
                L_0x00a5:
                    boolean r5 = r4.isRecycled()
                    if (r5 == 0) goto L_0x00ad
                    goto L_0x01f0
                L_0x00ad:
                    int r5 = r4.getByteCount()
                    byte[] r5 = new byte[r5]
                    java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r5)
                    r4.copyPixelsToBuffer(r6)
                    com.meizu.media.camera.mode.d$f r6 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r6 = com.meizu.media.camera.mode.BarCodeMode.this
                    int r7 = r4.getWidth()
                    int r4 = r4.getHeight()
                    byte[] r11 = r6.m11250b(r5, r7, r4)
                    if (r11 != 0) goto L_0x00ce
                    goto L_0x01f0
                L_0x00ce:
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.cameraAlgorithm.zbar.Image r4 = r4.f10776j
                    if (r4 != 0) goto L_0x00ea
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.cameraAlgorithm.zbar.Image r5 = new com.meizu.media.cameraAlgorithm.zbar.Image
                    int r6 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    int r7 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    java.lang.String r10 = "Y800"
                    r5.<init>(r6, r7, r10)
                    com.meizu.media.cameraAlgorithm.zbar.Image unused = r4.f10776j = r5
                L_0x00ea:
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.cameraAlgorithm.zbar.Image r4 = r4.f10776j
                    r4.setData((byte[]) r11)
                    com.meizu.media.cameraAlgorithm.zbar.ImageScanner r4 = com.meizu.media.cameraAlgorithm.zbar.ImageScanner.getInstance()
                    com.meizu.media.camera.mode.d$f r5 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.cameraAlgorithm.zbar.Image r5 = r5.f10776j
                    int r4 = r4.scanImage(r5)
                    r5 = 2
                    r6 = 1
                    if (r4 == 0) goto L_0x0159
                    com.meizu.media.cameraAlgorithm.zbar.ImageScanner r4 = com.meizu.media.cameraAlgorithm.zbar.ImageScanner.getInstance()
                    com.meizu.media.cameraAlgorithm.zbar.ZbarDecoder r4 = r4.getResults()
                    java.util.Iterator r4 = r4.iterator()
                    java.lang.Object r4 = r4.next()
                    com.meizu.media.cameraAlgorithm.zbar.Symbol r4 = (com.meizu.media.cameraAlgorithm.zbar.Symbol) r4
                    if (r4 == 0) goto L_0x0159
                    com.meizu.media.camera.mode.d$f r3 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r3 = com.meizu.media.camera.mode.BarCodeMode.this
                    r12 = 0
                    long unused = r3.f10728O = r12
                    com.google.zxing.Result r3 = new com.google.zxing.Result
                    java.lang.String r7 = r4.getData()
                    byte[] r4 = r4.getDataBytes()
                    com.google.zxing.BarcodeFormat r10 = com.google.zxing.BarcodeFormat.QR_CODE
                    r3.<init>(r7, r4, r1, r10)
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r4 = com.meizu.media.camera.mode.BarCodeMode.this
                    com.meizu.media.camera.mode.d$d r4 = r4.f10715B
                    if (r4 == 0) goto L_0x0154
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r4 = com.meizu.media.camera.mode.BarCodeMode.this
                    boolean r4 = r4.mo20521r()
                    if (r4 != 0) goto L_0x0154
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r4 = com.meizu.media.camera.mode.BarCodeMode.this
                    com.meizu.media.camera.mode.d$d r4 = r4.f10715B
                    android.os.Message r4 = android.os.Message.obtain(r4, r5, r3)
                    r4.sendToTarget()
                L_0x0154:
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    boolean unused = r4.f10770d = r6
                L_0x0159:
                    if (r3 == 0) goto L_0x015d
                    goto L_0x01fa
                L_0x015d:
                    com.google.zxing.PlanarYUVLuminanceSource r4 = new com.google.zxing.PlanarYUVLuminanceSource
                    int r12 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    int r13 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    r14 = 0
                    r15 = 0
                    int r16 = com.meizu.media.camera.mode.BarCodeMode.f10709o
                    int r17 = com.meizu.media.camera.mode.BarCodeMode.f10710p
                    r18 = 0
                    r10 = r4
                    r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                    com.meizu.media.camera.mode.d$f r7 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    boolean r7 = r7.f10773g
                    r4.setScanPortrait(r7)
                    com.meizu.media.camera.mode.d$f r7 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d$f r10 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    boolean r10 = r10.f10773g
                    r6 = r6 ^ r10
                    boolean unused = r7.f10773g = r6
                    com.google.zxing.BinaryBitmap r6 = new com.google.zxing.BinaryBitmap
                    com.google.zxing.common.HybridBinarizer r7 = new com.google.zxing.common.HybridBinarizer
                    r7.<init>(r4)
                    r6.<init>(r7)
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this     // Catch:{ ReaderException -> 0x01c1, IndexOutOfBoundsException -> 0x01ad }
                    com.google.zxing.MultiFormatReader r4 = r4.f10772f     // Catch:{ ReaderException -> 0x01c1, IndexOutOfBoundsException -> 0x01ad }
                    com.google.zxing.Result r4 = r4.decodeWithState(r6)     // Catch:{ ReaderException -> 0x01c1, IndexOutOfBoundsException -> 0x01ad }
                    com.meizu.media.camera.mode.d$f r3 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.google.zxing.MultiFormatReader r3 = r3.f10772f
                    r3.reset()
                    r3 = r4
                    goto L_0x01ca
                L_0x01ab:
                    r0 = move-exception
                    goto L_0x01b7
                L_0x01ad:
                    com.meizu.media.camera.util.ac$a r4 = com.meizu.media.camera.mode.BarCodeMode.f10708l     // Catch:{ all -> 0x01ab }
                    java.lang.String r6 = "decode buffer length error"
                    com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r6)     // Catch:{ all -> 0x01ab }
                    goto L_0x01c1
                L_0x01b7:
                    com.meizu.media.camera.mode.d$f r1 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.google.zxing.MultiFormatReader r1 = r1.f10772f
                    r1.reset()
                    throw r0
                L_0x01c1:
                    com.meizu.media.camera.mode.d$f r4 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.google.zxing.MultiFormatReader r4 = r4.f10772f
                    r4.reset()
                L_0x01ca:
                    if (r3 == 0) goto L_0x01f0
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    com.meizu.media.camera.mode.d$d r0 = r0.f10715B
                    if (r0 == 0) goto L_0x01fa
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    boolean r0 = r0.mo20521r()
                    if (r0 != 0) goto L_0x01fa
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                    com.meizu.media.camera.mode.d$d r0 = r0.f10715B
                    android.os.Message r0 = android.os.Message.obtain(r0, r5, r3)
                    r0.sendToTarget()
                    goto L_0x01fa
                L_0x01f0:
                    int r2 = r2 + 30
                    goto L_0x007e
                L_0x01f4:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.BarCodeMode.C2177f.C2178a unused = r0.f10771e = r1
                    return
                L_0x01fa:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    java.lang.Object r1 = r0.f10775i
                    monitor-enter(r1)
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this     // Catch:{ InterruptedException -> 0x020d }
                    java.lang.Object r0 = r0.f10775i     // Catch:{ InterruptedException -> 0x020d }
                    r0.wait()     // Catch:{ InterruptedException -> 0x020d }
                    goto L_0x0211
                L_0x020b:
                    r0 = move-exception
                    goto L_0x0214
                L_0x020d:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x020b }
                L_0x0211:
                    monitor-exit(r1)     // Catch:{ all -> 0x020b }
                    goto L_0x0019
                L_0x0214:
                    monitor-exit(r1)     // Catch:{ all -> 0x020b }
                    throw r0
                L_0x0216:
                    return
                L_0x0217:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.BarCodeMode.C2177f.C2178a unused = r0.f10771e = r1
                    return
                L_0x021d:
                    com.meizu.media.camera.mode.d$f r0 = com.meizu.media.camera.mode.BarCodeMode.C2177f.this
                    com.meizu.media.camera.mode.BarCodeMode.C2177f.C2178a unused = r0.f10771e = r1
                    return
                L_0x0223:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BarCodeMode.C2177f.C2178a.run():void");
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0055 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo20535a() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f10767a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 4682(0x124a, float:6.561E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.ui.g r1 = r1.f10732m
                if (r1 == 0) goto L_0x002b
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.ui.g r1 = r1.f10732m
                boolean r1 = r1.mo22016i()
                if (r1 == 0) goto L_0x002b
                return
            L_0x002b:
                r8.f10770d = r0
                com.meizu.media.camera.mode.d$f$a r1 = r8.f10771e
                r2 = 1
                if (r1 != 0) goto L_0x0046
                boolean r1 = r8.f10770d
                if (r1 != 0) goto L_0x0046
                r8.f10774h = r2
                com.meizu.media.camera.mode.d$f$a r0 = new com.meizu.media.camera.mode.d$f$a
                r1 = 0
                r0.<init>()
                r8.f10771e = r0
                com.meizu.media.camera.mode.d$f$a r0 = r8.f10771e
                r0.start()
                goto L_0x0061
            L_0x0046:
                r8.f10774h = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.Object r1 = r8.f10775i     // Catch:{ Exception -> 0x0055 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0055 }
                java.lang.Object r2 = r8.f10775i     // Catch:{ all -> 0x0052 }
                r2.notify()     // Catch:{ all -> 0x0052 }
                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                goto L_0x0061
            L_0x0052:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                throw r2     // Catch:{ Exception -> 0x0055 }
            L_0x0055:
                r8.f10774h = r0     // Catch:{ Exception -> 0x005d }
                com.meizu.media.camera.mode.d$f$a r0 = r8.f10771e     // Catch:{ Exception -> 0x005d }
                r0.interrupt()     // Catch:{ Exception -> 0x005d }
                goto L_0x0061
            L_0x005d:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0061:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BarCodeMode.C2177f.mo20535a():void");
        }

        /* renamed from: b */
        public void mo20537b() {
            if (!PatchProxy.proxy(new Object[0], this, f10767a, false, 4683, new Class[0], Void.TYPE).isSupported) {
                this.f10774h = false;
                if (this.f10771e != null && this.f10771e.isAlive()) {
                    this.f10771e.interrupt();
                }
                this.f10771e = null;
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.d$e */
    /* compiled from: BarCodeMode */
    private final class C2176e implements Camera.PreviewCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f10763a;

        /* renamed from: c */
        private Handler f10765c;

        /* renamed from: d */
        private int f10766d;

        private C2176e() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo20533a(Handler handler, int i) {
            this.f10765c = handler;
            this.f10766d = i;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraProxyV1 eVar;
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f10763a, false, 4680, new Class[]{byte[].class, Camera.class}, Void.TYPE).isSupported && !BarCodeMode.this.f10733n) {
                Handler handler = this.f10765c;
                if (handler != null) {
                    handler.obtainMessage(this.f10766d).sendToTarget();
                    if (!(!CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) || (eVar = (CameraProxyV1) CameraController.m8868g().mo19522k()) == null || eVar.mo19730a() == null)) {
                        ((Camera) eVar.mo19730a()).setPreviewCallback((Camera.PreviewCallback) null);
                    }
                    this.f10765c = null;
                    return;
                }
                LogUtil.m15949b(BarCodeMode.f10708l, "Got preview callback, but no handler or resolution available");
            }
        }
    }

    public BarCodeMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        if (this.f10788j != null && modeType == CameraModeType.ModeType.BARCODE && !m11237a(this.f10787i.getIntent().getAction())) {
            m11240aj();
        }
        if (this.f10717D == null) {
            this.f10717D = new ResultInfoAdapter(mo20540S().mo17639f());
        }
        DownloadCache.m16215a(mo20540S(), "BarCodeProductLogoCache", 209715200);
        m11241ak();
    }

    /* renamed from: com.meizu.media.camera.mode.d$c */
    /* compiled from: BarCodeMode */
    private class C2174c implements ImageReader.OnImageAvailableListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f10756a;

        /* renamed from: c */
        private byte[] f10758c;

        private C2174c() {
            this.f10758c = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
            if (r10 != null) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
            if (r1 != null) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r10.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            r1.addSuppressed(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
            r10.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f10756a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<android.media.ImageReader> r0 = android.media.ImageReader.class
                r6[r8] = r0
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 4676(0x1244, float:6.552E-42)
                r2 = r9
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x001d
                return
            L_0x001d:
                com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                monitor-enter(r0)
                android.media.Image r10 = r10.acquireLatestImage()     // Catch:{ all -> 0x00a7 }
                r1 = 0
                com.meizu.media.camera.mode.d r2 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ IllegalStateException -> 0x008a }
                boolean r2 = r2.f10733n     // Catch:{ IllegalStateException -> 0x008a }
                if (r2 != 0) goto L_0x007f
                if (r10 != 0) goto L_0x0030
                goto L_0x007f
            L_0x0030:
                android.media.Image$Plane[] r2 = r10.getPlanes()     // Catch:{ IllegalStateException -> 0x008a }
                r2 = r2[r8]     // Catch:{ IllegalStateException -> 0x008a }
                int r2 = r2.getRowStride()     // Catch:{ IllegalStateException -> 0x008a }
                int unused = com.meizu.media.camera.mode.BarCodeMode.f10709o = r2     // Catch:{ IllegalStateException -> 0x008a }
                android.media.Image$Plane[] r2 = r10.getPlanes()     // Catch:{ IllegalStateException -> 0x008a }
                r2 = r2[r8]     // Catch:{ IllegalStateException -> 0x008a }
                java.nio.ByteBuffer r2 = r2.getBuffer()     // Catch:{ IllegalStateException -> 0x008a }
                int r2 = r2.remaining()     // Catch:{ IllegalStateException -> 0x008a }
                byte[] r3 = new byte[r2]     // Catch:{ IllegalStateException -> 0x008a }
                r9.f10758c = r3     // Catch:{ IllegalStateException -> 0x008a }
                android.media.Image$Plane[] r3 = r10.getPlanes()     // Catch:{ IllegalStateException -> 0x008a }
                r3 = r3[r8]     // Catch:{ IllegalStateException -> 0x008a }
                java.nio.ByteBuffer r3 = r3.getBuffer()     // Catch:{ IllegalStateException -> 0x008a }
                byte[] r4 = r9.f10758c     // Catch:{ IllegalStateException -> 0x008a }
                r3.get(r4, r8, r2)     // Catch:{ IllegalStateException -> 0x008a }
                r10.close()     // Catch:{ IllegalStateException -> 0x008a }
                com.meizu.media.camera.mode.d r2 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ IllegalStateException -> 0x008a }
                boolean r2 = r2.f10719F     // Catch:{ IllegalStateException -> 0x008a }
                if (r2 == 0) goto L_0x0071
                com.meizu.media.camera.mode.d r2 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ IllegalStateException -> 0x008a }
                byte[] r3 = r9.f10758c     // Catch:{ IllegalStateException -> 0x008a }
                byte[] unused = r2.f10721H = r3     // Catch:{ IllegalStateException -> 0x008a }
                goto L_0x0078
            L_0x0071:
                com.meizu.media.camera.mode.d r2 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ IllegalStateException -> 0x008a }
                byte[] r3 = r9.f10758c     // Catch:{ IllegalStateException -> 0x008a }
                byte[] unused = r2.f10720G = r3     // Catch:{ IllegalStateException -> 0x008a }
            L_0x0078:
                if (r10 == 0) goto L_0x007d
                r10.close()     // Catch:{ all -> 0x00a7 }
            L_0x007d:
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x007f:
                if (r10 == 0) goto L_0x0084
                r10.close()     // Catch:{ all -> 0x00a7 }
            L_0x0084:
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0086:
                r2 = move-exception
                goto L_0x0096
            L_0x0088:
                r1 = move-exception
                goto L_0x0095
            L_0x008a:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ Throwable -> 0x0088 }
                if (r10 == 0) goto L_0x0093
                r10.close()     // Catch:{ all -> 0x00a7 }
            L_0x0093:
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0095:
                throw r1     // Catch:{ all -> 0x0086 }
            L_0x0096:
                if (r10 == 0) goto L_0x00a6
                if (r1 == 0) goto L_0x00a3
                r10.close()     // Catch:{ Throwable -> 0x009e }
                goto L_0x00a6
            L_0x009e:
                r10 = move-exception
                r1.addSuppressed(r10)     // Catch:{ all -> 0x00a7 }
                goto L_0x00a6
            L_0x00a3:
                r10.close()     // Catch:{ all -> 0x00a7 }
            L_0x00a6:
                throw r2     // Catch:{ all -> 0x00a7 }
            L_0x00a7:
                r10 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BarCodeMode.C2174c.onImageAvailable(android.media.ImageReader):void");
        }
    }

    /* renamed from: aj */
    private void m11240aj() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4640, new Class[0], Void.TYPE).isSupported && this.f10788j != null) {
            this.f10725L = CameraModeType.ModeType.AUTO.equals(this.f10789k);
            this.f10732m = mo20539R().mo18267u().mo22056S();
            this.f10732m.mo22010e(this.f10725L);
            this.f10732m.mo22000a(this.f10788j);
            this.f10732m.mo22001a((MzBarcodeUI.C2472a) this);
            this.f10732m.mo21997a();
        }
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        this.f10788j = uVar;
    }

    /* renamed from: a */
    public static boolean m11237a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f10701a, true, 4641, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "meizu.intent.action.OPEN_SCANNER".equals(str);
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4642, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            if (this.f10732m == null) {
                m11240aj();
            } else {
                this.f10732m.mo21997a();
            }
            if (!this.f10725L) {
                m11242al();
                if (!this.f10732m.mo22016i()) {
                    this.f10732m.mo22005c();
                }
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4643, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (!this.f10725L) {
                if (this.f10732m != null) {
                    this.f10732m.mo22005c();
                }
                if (CameraModeType.m10957c(this.f10789k)) {
                    m11242al();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10701a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4644, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!this.f10725L && !z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                m11242al();
            }
            if (!z2 && this.f10732m != null) {
                this.f10732m.mo22014g(!z);
            }
        }
    }

    /* renamed from: ak */
    private void m11241ak() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4645, new Class[0], Void.TYPE).isSupported) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.service.UrlCheckRealService"));
                intent.setAction("com.meizu.safe.service.UrlCheckService");
                this.f10787i.bindService(intent, this.f10731R, 1);
            } catch (SecurityException e) {
                e.printStackTrace();
                this.f10724K = null;
            }
        }
    }

    /* renamed from: al */
    private void m11242al() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4646, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21506a(0);
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4647, new Class[0], Void.TYPE).isSupported) {
            this.f10733n = true;
            if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                CameraController.m8868g().mo19518i().post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10742a;

                    public void run() {
                        CameraProxyV1 eVar;
                        if (!PatchProxy.proxy(new Object[0], this, f10742a, false, 4671, new Class[0], Void.TYPE).isSupported && (eVar = (CameraProxyV1) CameraController.m8868g().mo19522k()) != null && eVar.mo19730a() != null) {
                            ((Camera) eVar.mo19730a()).setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                        }
                    }
                });
            }
            if (this.f10715B != null) {
                this.f10715B.mo20531b();
                this.f10715B = null;
            }
            this.f10739z = null;
            if (this.f10732m != null && !this.f10725L) {
                this.f10732m.mo22019l();
            }
            if (this.f10732m != null) {
                this.f10732m.mo22018k();
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        this.f10733n = false;
    }

    /* renamed from: a */
    public void mo20514a(boolean z) {
        this.f10727N = z;
    }

    /* renamed from: am */
    private void m11243am() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4648, new Class[0], Void.TYPE).isSupported) {
            int a = CameraUtil.m15809a();
            int b = CameraUtil.m15865b();
            int h = CameraUtil.m15901h();
            Point l = CameraController.m8868g().mo19524l();
            if (l != null) {
                int i = l.y;
                int i2 = l.x;
                int dimensionPixelOffset = ContextBuilder.m6349a(mo20540S(), true, true).getResources().getDimensionPixelOffset(R.dimen.mz_barcode_scan_length);
                int i3 = (a * i2) / i;
                f10709o = i2;
                f10710p = i;
                if (this.f10725L) {
                    f10711q = f10709o;
                    f10712r = f10710p;
                    f10713s = 0;
                    f10714t = 0;
                } else {
                    f10711q = (i * dimensionPixelOffset) / a;
                    f10712r = f10711q;
                    if (this.f10734u != null) {
                        f10713s = (this.f10734u.top * i) / a;
                        f10714t = (this.f10734u.left * i) / a;
                    } else {
                        f10713s = (((((b - h) - dimensionPixelOffset) / 2) + ((i3 - b) / 2)) * i) / a;
                        f10714t = (((a - dimensionPixelOffset) / 2) * i) / a;
                    }
                }
                int i4 = i2 * i * 2;
                this.f10720G = new byte[i4];
                this.f10721H = new byte[i4];
                LogUtil.C2630a aVar = f10708l;
                LogUtil.m15942a(aVar, "IMG_WIDTH:" + f10709o);
                LogUtil.C2630a aVar2 = f10708l;
                LogUtil.m15942a(aVar2, "IMG_HEIGHT:" + f10710p);
                LogUtil.C2630a aVar3 = f10708l;
                LogUtil.m15942a(aVar3, "CROP_WIDTH:" + f10711q);
                LogUtil.C2630a aVar4 = f10708l;
                LogUtil.m15942a(aVar4, "CROP_HEIGHT:" + f10712r);
                LogUtil.C2630a aVar5 = f10708l;
                LogUtil.m15942a(aVar5, "CROP_LEFT:" + f10713s);
                LogUtil.C2630a aVar6 = f10708l;
                LogUtil.m15942a(aVar6, "CROP_TOP:" + f10714t);
                LogUtil.C2630a aVar7 = f10708l;
                LogUtil.m15942a(aVar7, "previewWidth:" + i2);
                LogUtil.C2630a aVar8 = f10708l;
                LogUtil.m15942a(aVar8, "previewHeight:" + i);
            }
        }
    }

    /* renamed from: c */
    public void mo20518c() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4649, new Class[0], Void.TYPE).isSupported && !mo20540S().mo17677n() && !mo20540S().isFinishing() && !mo20540S().isDestroyed()) {
            if (!this.f10725L) {
                mo20542U().mo21578d();
            }
            if (this.f10788j != null) {
                this.f10788j.mo21510a(1, true);
            }
            if (mo20539R().mo18267u() != null) {
                mo20539R().mo18267u().mo22142b(true);
            }
            if (this.f10732m != null) {
                this.f10732m.mo22015h();
                if (this.f10715B == null) {
                    this.f10715B = new C2175d();
                }
                this.f10715B.mo20530a();
            }
        }
    }

    /* renamed from: q */
    public Boolean mo20520q() {
        return this.f10739z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo20512a(android.os.Handler r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006d }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x006d }
            java.lang.Integer r3 = new java.lang.Integer     // Catch:{ all -> 0x006d }
            r3.<init>(r10)     // Catch:{ all -> 0x006d }
            r4 = 1
            r1[r4] = r3     // Catch:{ all -> 0x006d }
            com.meizu.savior.ChangeQuickRedirect r3 = f10701a     // Catch:{ all -> 0x006d }
            r5 = 0
            r6 = 4650(0x122a, float:6.516E-42)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x006d }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r0[r2] = r7     // Catch:{ all -> 0x006d }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x006d }
            r0[r4] = r2     // Catch:{ all -> 0x006d }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006d }
            r2 = r8
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            com.meizu.media.camera.mode.d$e r0 = r8.f10722I     // Catch:{ all -> 0x006d }
            r0.mo20533a(r9, r10)     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = r0.mo19516h()     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1     // Catch:{ all -> 0x006d }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0064
            com.meizu.media.camera.camcontroller.CameraController r9 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.camcontroller.d r9 = r9.mo19522k()     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.camcontroller.e r9 = (com.meizu.media.camera.camcontroller.CameraProxyV1) r9     // Catch:{ all -> 0x006d }
            java.lang.Object r10 = r9.mo19730a()     // Catch:{ all -> 0x006d }
            android.hardware.Camera r10 = (android.hardware.Camera) r10     // Catch:{ all -> 0x006d }
            com.meizu.media.camera.mode.d$e r0 = r8.f10722I     // Catch:{ all -> 0x006d }
            r10.setPreviewCallbackWithBuffer(r0)     // Catch:{ all -> 0x006d }
            java.lang.Object r9 = r9.mo19730a()     // Catch:{ all -> 0x006d }
            android.hardware.Camera r9 = (android.hardware.Camera) r9     // Catch:{ all -> 0x006d }
            byte[] r10 = r8.f10720G     // Catch:{ all -> 0x006d }
            r9.addCallbackBuffer(r10)     // Catch:{ all -> 0x006d }
            goto L_0x006b
        L_0x0064:
            android.os.Message r9 = r9.obtainMessage(r10)     // Catch:{ all -> 0x006d }
            r9.sendToTarget()     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r8)
            return
        L_0x006d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BarCodeMode.mo20512a(android.os.Handler, int):void");
    }

    /* renamed from: a */
    public synchronized void mo20515a(byte[] bArr) {
        if (this.f10725L && !this.f10733n) {
            this.f10720G = bArr;
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10701a, false, 4651, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        this.f10730Q = new LinkedList<>();
        this.f10730Q.add(ImageReaderHolder.f14378b.mo22759a().mo22757a(1, 35, this.f10716C, (Handler) null).getSurface());
        return this.f10730Q;
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4652, new Class[0], Void.TYPE).isSupported) {
            super.mo20492m_();
            if (CameraController.m8868g().mo19522k() != null) {
                if (this.f10732m == null) {
                    m11240aj();
                }
                this.f10734u = this.f10732m.mo22003b();
                m11243am();
                if (this.f10715B != null) {
                    if (!this.f10725L || mo20539R().mo17926aw()) {
                        this.f10715B.sendEmptyMessage(3);
                    }
                } else if (!this.f10733n) {
                    this.f10715B = new C2175d();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.d$d */
    /* compiled from: BarCodeMode */
    private final class C2175d extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10759a;

        /* renamed from: c */
        private final C2173b f10761c;

        /* renamed from: d */
        private boolean f10762d = true;

        C2175d() {
            this.f10761c = new C2173b();
            this.f10761c.start();
            if (BarCodeMode.this.f10732m != null && !BarCodeMode.this.f10732m.mo22016i()) {
                if (!BarCodeMode.this.f10725L || BarCodeMode.this.mo20539R().mo17926aw()) {
                    sendEmptyMessage(3);
                }
            }
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10759a, false, 4677, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 2:
                        if (this.f10762d) {
                            this.f10762d = false;
                            if (BarCodeMode.this.f10732m != null) {
                                BarCodeMode.this.f10732m.mo22002a(true);
                            }
                            if (!BarCodeMode.this.f10725L) {
                                BarCodeMode.this.mo20542U().mo21571c();
                                if (BarCodeMode.this.f10788j != null) {
                                    BarCodeMode.this.f10788j.mo21510a(1, false);
                                }
                                if (BarCodeMode.this.mo20539R().mo18267u() != null) {
                                    BarCodeMode.this.mo20539R().mo18267u().mo22142b(false);
                                }
                            }
                            byte[] unused = BarCodeMode.this.f10720G = new byte[BarCodeMode.this.f10720G.length];
                            byte[] unused2 = BarCodeMode.this.f10721H = new byte[BarCodeMode.this.f10721H.length];
                            BarCodeMode.this.mo20513a((Result) message.obj);
                            return;
                        }
                        return;
                    case 3:
                        if (!BarCodeMode.this.mo20539R().mo18200dX() && !BarCodeMode.this.f10733n) {
                            if (BarCodeMode.this.f10732m != null && BarCodeMode.this.f10725L && BarCodeMode.this.f10732m.mo22016i()) {
                                return;
                            }
                            if (CameraController.m8868g().mo19522k() == null || DeviceUtil.m16197a((Context) BarCodeMode.this.f10787i) || BarCodeMode.this.f10720G == null) {
                                sendEmptyMessageDelayed(3, 200);
                                return;
                            }
                            if (BarCodeMode.this.f10725L && BarCodeMode.this.f10726M != null && BarCodeMode.this.f10727N) {
                                if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo21998a((ResultHandler) null);
                                }
                                ResultHandler unused3 = BarCodeMode.this.f10726M = null;
                            }
                            BarCodeMode.this.mo20512a(this.f10761c.mo20527a(), 1);
                            return;
                        }
                        return;
                    case 5:
                    case 6:
                    case 7:
                        if (message.obj != null && BarCodeMode.this.f10715B != null) {
                            ResultHandler iVar = (ResultHandler) message.obj;
                            BarCodeMode.this.f10717D.mo19250a(iVar.mo19170a());
                            if (BarCodeMode.this.f10732m != null) {
                                BarCodeMode.this.f10732m.mo21999a(iVar.mo19174b(), BarCodeMode.this.f10717D, iVar.mo19175c());
                            }
                            if (BarCodeMode.this.f10725L) {
                                if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo21998a(iVar);
                                }
                                BarCodeMode.this.f10715B.mo20530a();
                                return;
                            } else if (BarCodeMode.this.f10732m != null) {
                                BarCodeMode.this.f10732m.mo22004b(true);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case 8:
                        BarCodeMode.this.m11244an();
                        return;
                    case 9:
                        if (message.obj != null && BarCodeMode.this.f10732m != null && BarCodeMode.this.f10715B != null) {
                            ResultHandler iVar2 = (ResultHandler) message.obj;
                            if (iVar2.mo19170a() == null || iVar2.mo19170a().size() <= 0) {
                                if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo21999a(iVar2.mo19174b(), (ResultInfoAdapter) null, (ArrayList<ResultActionBarItem>) null);
                                }
                                if (BarCodeMode.this.f10725L) {
                                    BarCodeMode.this.f10732m.mo21998a(iVar2);
                                    BarCodeMode.this.f10715B.mo20530a();
                                    return;
                                } else if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo22004b(true);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                BarCodeMode.this.f10717D.mo19250a(iVar2.mo19170a());
                                if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo21999a(iVar2.mo19174b(), BarCodeMode.this.f10717D, iVar2.mo19175c());
                                }
                                if (BarCodeMode.this.f10725L) {
                                    BarCodeMode.this.f10732m.mo21998a(iVar2);
                                    BarCodeMode.this.f10715B.mo20530a();
                                    return;
                                } else if (BarCodeMode.this.f10732m != null) {
                                    BarCodeMode.this.f10732m.mo22004b(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    case 10:
                        if (BarCodeMode.this.f10732m != null) {
                            BarCodeMode.this.f10732m.mo22009e();
                            return;
                        }
                        return;
                    case 11:
                        if (BarCodeMode.this.f10732m != null && BarCodeMode.this.f10788j != null && message.obj != null) {
                            boolean D = BarCodeMode.this.f10788j.mo21481D();
                            if (((Boolean) message.obj).booleanValue() || !D) {
                                BarCodeMode.this.f10732m.mo22011f(BarCodeMode.this.f10788j.mo21481D());
                                return;
                            } else {
                                BarCodeMode.this.f10732m.mo22019l();
                                return;
                            }
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        /* renamed from: a */
        public void mo20530a() {
            if (!PatchProxy.proxy(new Object[0], this, f10759a, false, 4678, new Class[0], Void.TYPE).isSupported) {
                if (!BarCodeMode.this.f10725L) {
                    sendEmptyMessage(3);
                } else if (!hasMessages(3)) {
                    sendEmptyMessageDelayed(3, 500);
                }
                this.f10762d = true;
            }
        }

        /* renamed from: b */
        public void mo20531b() {
            if (!PatchProxy.proxy(new Object[0], this, f10759a, false, 4679, new Class[0], Void.TYPE).isSupported) {
                Message.obtain(this.f10761c.mo20527a(), 4).sendToTarget();
                try {
                    this.f10761c.join(500);
                } catch (InterruptedException unused) {
                }
                removeMessages(2);
                removeMessages(3);
                removeMessages(11);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.d$b */
    /* compiled from: BarCodeMode */
    final class C2173b extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f10751a;

        /* renamed from: c */
        private final Map<DecodeHintType, Object> f10753c = new EnumMap(DecodeHintType.class);

        /* renamed from: d */
        private Handler f10754d;

        /* renamed from: e */
        private final CountDownLatch f10755e = new CountDownLatch(1);

        C2173b() {
            setName("BarDecodeThread");
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            noneOf.addAll(BarCodeMode.f10702b);
            noneOf.addAll(BarCodeMode.f10703c);
            noneOf.addAll(BarCodeMode.f10704d);
            noneOf.addAll(BarCodeMode.f10705e);
            noneOf.addAll(BarCodeMode.f10706f);
            noneOf.addAll(BarCodeMode.f10707g);
            this.f10753c.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Handler mo20527a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10751a, false, 4674, new Class[0], Handler.class);
            if (proxy.isSupported) {
                return (Handler) proxy.result;
            }
            try {
                this.f10755e.await();
            } catch (InterruptedException unused) {
            }
            return this.f10754d;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10751a, false, 4675, new Class[0], Void.TYPE).isSupported) {
                Looper.prepare();
                this.f10754d = new C2172a(this.f10753c);
                this.f10755e.countDown();
                Looper.loop();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.d$a */
    /* compiled from: BarCodeMode */
    private final class C2172a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10745a;

        /* renamed from: c */
        private final MultiFormatReader f10747c = new MultiFormatReader();

        /* renamed from: d */
        private boolean f10748d = true;

        /* renamed from: e */
        private byte[] f10749e;

        /* renamed from: f */
        private int f10750f = 0;

        C2172a(Map<DecodeHintType, Object> map) {
            this.f10747c.setHints(map);
            BarCodeMode.this.f10729P.mo20536a(map);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10745a, false, 4672, new Class[]{Message.class}, Void.TYPE).isSupported && this.f10748d) {
                int i = message.what;
                if (i != 1) {
                    if (i == 4) {
                        this.f10748d = false;
                        Looper.myLooper().quit();
                    }
                } else if (DeviceHelper.f13910bJ != CameraController.CameraApi.API2 || BarCodeMode.this.f10725L) {
                    if (DeviceHelper.f13910bJ != CameraController.CameraApi.API2) {
                        mo20525a(BarCodeMode.this.f10720G);
                    } else if (BarCodeMode.this.f10719F) {
                        mo20525a(BarCodeMode.this.f10720G);
                        boolean unused = BarCodeMode.this.f10719F = false;
                    } else {
                        if (BarCodeMode.this.f10721H != null) {
                            mo20525a(BarCodeMode.this.f10721H);
                        }
                        boolean unused2 = BarCodeMode.this.f10719F = true;
                    }
                } else if (BarCodeMode.this.f10719F) {
                    if (this.f10749e != BarCodeMode.this.f10720G) {
                        this.f10749e = BarCodeMode.this.f10720G;
                        mo20525a(BarCodeMode.this.f10720G);
                    } else if (BarCodeMode.this.f10715B != null) {
                        Message.obtain(BarCodeMode.this.f10715B, 3).sendToTarget();
                    }
                    boolean unused3 = BarCodeMode.this.f10719F = false;
                } else {
                    if (this.f10749e != BarCodeMode.this.f10721H) {
                        this.f10749e = BarCodeMode.this.f10721H;
                        if (BarCodeMode.this.f10721H != null) {
                            mo20525a(BarCodeMode.this.f10721H);
                        }
                    } else if (BarCodeMode.this.f10715B != null) {
                        Message.obtain(BarCodeMode.this.f10715B, 3).sendToTarget();
                    }
                    boolean unused4 = BarCodeMode.this.f10719F = true;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x019f */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01d6  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo20525a(byte[] r26) {
            /*
                r25 = this;
                r8 = r25
                r15 = r26
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r14 = 0
                r1[r14] = r15
                com.meizu.savior.ChangeQuickRedirect r3 = f10745a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<byte[]> r2 = byte[].class
                r6[r14] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 4673(0x1241, float:6.548E-42)
                r2 = r25
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0022
                return
            L_0x0022:
                com.meizu.media.camera.mode.d r2 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$f r2 = r2.f10729P
                r2.mo20535a()
                r2 = 500(0x1f4, double:2.47E-321)
                r4 = 3
                if (r15 != 0) goto L_0x0050
                com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r0 = r0.f10715B
                android.os.Message r0 = android.os.Message.obtain(r0, r4)
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                boolean r1 = r1.f10725L
                if (r1 == 0) goto L_0x004c
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r1 = r1.f10715B
                r1.sendMessageDelayed(r0, r2)
                goto L_0x004f
            L_0x004c:
                r0.sendToTarget()
            L_0x004f:
                return
            L_0x0050:
                monitor-enter(r26)
                com.meizu.media.camera.mode.d r5 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0203 }
                long r5 = r5.f10728O     // Catch:{ all -> 0x0203 }
                r12 = 0
                int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
                if (r5 != 0) goto L_0x0066
                com.meizu.media.camera.mode.d r5 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0203 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0203 }
                long unused = r5.f10728O = r6     // Catch:{ all -> 0x0203 }
            L_0x0066:
                int r5 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                if (r5 == 0) goto L_0x0200
                int r5 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0203 }
                if (r5 != 0) goto L_0x0074
                goto L_0x0200
            L_0x0074:
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.util.DeviceHelper.f13910bJ     // Catch:{ all -> 0x0203 }
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1     // Catch:{ all -> 0x0203 }
                r7 = 2
                if (r5 != r6) goto L_0x013b
                int r5 = r8.f10750f     // Catch:{ all -> 0x0203 }
                r6 = 5
                if (r5 >= r6) goto L_0x00f5
                int r5 = r15.length     // Catch:{ all -> 0x0203 }
                int r5 = r5 / r7
                byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0203 }
                r6 = 0
            L_0x0085:
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0203 }
                if (r6 >= r9) goto L_0x00a3
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                int r9 = r9 * r6
                int r9 = r9 * 2
                int r10 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                int r10 = r10 * r6
                int r11 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                java.lang.System.arraycopy(r15, r9, r5, r10, r11)     // Catch:{ all -> 0x0203 }
                int r6 = r6 + 2
                goto L_0x0085
            L_0x00a3:
                int r6 = r5.length     // Catch:{ all -> 0x0203 }
                int r6 = r6 / r7
                byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0203 }
            L_0x00a7:
                int r9 = r5.length     // Catch:{ all -> 0x0203 }
                int r9 = r9 / r7
                if (r14 >= r9) goto L_0x00b4
                int r9 = r14 * 2
                byte r9 = r5[r9]     // Catch:{ all -> 0x0203 }
                r6[r14] = r9     // Catch:{ all -> 0x0203 }
                int r14 = r14 + 1
                goto L_0x00a7
            L_0x00b4:
                com.google.zxing.PlanarYUVLuminanceSource r5 = new com.google.zxing.PlanarYUVLuminanceSource     // Catch:{ all -> 0x0203 }
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                int r18 = r9 / 2
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0203 }
                int r19 = r9 / 2
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10713s     // Catch:{ all -> 0x0203 }
                int r20 = r9 / 2
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10714t     // Catch:{ all -> 0x0203 }
                int r21 = r9 / 2
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10711q     // Catch:{ all -> 0x0203 }
                int r22 = r9 / 2
                int r9 = com.meizu.media.camera.mode.BarCodeMode.f10712r     // Catch:{ all -> 0x0203 }
                int r23 = r9 / 2
                r24 = 0
                r16 = r5
                r17 = r6
                r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0203 }
                com.meizu.media.camera.mode.d r9 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0203 }
                int r10 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                int r10 = r10 / r7
                int r11 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0203 }
                int r11 = r11 / r7
                r9.m11234a((byte[]) r6, (int) r10, (int) r11)     // Catch:{ all -> 0x0203 }
                r1 = r12
                r6 = r15
                goto L_0x0134
            L_0x00f5:
                com.google.zxing.PlanarYUVLuminanceSource r5 = new com.google.zxing.PlanarYUVLuminanceSource     // Catch:{ all -> 0x0203 }
                int r11 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0203 }
                int r6 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0203 }
                int r16 = com.meizu.media.camera.mode.BarCodeMode.f10713s     // Catch:{ all -> 0x0203 }
                int r17 = com.meizu.media.camera.mode.BarCodeMode.f10714t     // Catch:{ all -> 0x0203 }
                int r18 = com.meizu.media.camera.mode.BarCodeMode.f10711q     // Catch:{ all -> 0x0203 }
                int r19 = com.meizu.media.camera.mode.BarCodeMode.f10712r     // Catch:{ all -> 0x0203 }
                r20 = 0
                r9 = r5
                r10 = r26
                r1 = r12
                r12 = r6
                r13 = r16
                r3 = 0
                r14 = r17
                r6 = r15
                r15 = r18
                r16 = r19
                r17 = r20
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0207 }
                com.meizu.media.camera.mode.d r9 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0207 }
                int r10 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0207 }
                int r11 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0207 }
                r9.m11234a((byte[]) r6, (int) r10, (int) r11)     // Catch:{ all -> 0x0207 }
                r8.f10750f = r3     // Catch:{ all -> 0x0207 }
            L_0x0134:
                int r3 = r8.f10750f     // Catch:{ all -> 0x0207 }
                int r3 = r3 + r0
                r8.f10750f = r3     // Catch:{ all -> 0x0207 }
                r3 = r5
                goto L_0x015f
            L_0x013b:
                r1 = r12
                r6 = r15
                com.google.zxing.PlanarYUVLuminanceSource r3 = new com.google.zxing.PlanarYUVLuminanceSource     // Catch:{ all -> 0x0207 }
                int r11 = com.meizu.media.camera.mode.BarCodeMode.f10709o     // Catch:{ all -> 0x0207 }
                int r12 = com.meizu.media.camera.mode.BarCodeMode.f10710p     // Catch:{ all -> 0x0207 }
                int r13 = com.meizu.media.camera.mode.BarCodeMode.f10713s     // Catch:{ all -> 0x0207 }
                int r14 = com.meizu.media.camera.mode.BarCodeMode.f10714t     // Catch:{ all -> 0x0207 }
                int r15 = com.meizu.media.camera.mode.BarCodeMode.f10711q     // Catch:{ all -> 0x0207 }
                int r16 = com.meizu.media.camera.mode.BarCodeMode.f10712r     // Catch:{ all -> 0x0207 }
                r17 = 0
                r9 = r3
                r10 = r26
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0207 }
            L_0x015f:
                if (r3 == 0) goto L_0x01b7
                com.meizu.media.camera.mode.d r5 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0207 }
                boolean r5 = r5.f10718E     // Catch:{ all -> 0x0207 }
                r3.setScanPortrait(r5)     // Catch:{ all -> 0x0207 }
                com.meizu.media.camera.mode.d r5 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0207 }
                com.meizu.media.camera.mode.d r9 = com.meizu.media.camera.mode.BarCodeMode.this     // Catch:{ all -> 0x0207 }
                boolean r9 = r9.f10718E     // Catch:{ all -> 0x0207 }
                r0 = r0 ^ r9
                boolean unused = r5.f10718E = r0     // Catch:{ all -> 0x0207 }
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ     // Catch:{ all -> 0x0207 }
                com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1     // Catch:{ all -> 0x0207 }
                if (r0 != r5) goto L_0x0187
                com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap     // Catch:{ all -> 0x0207 }
                com.google.zxing.common.GlobalHistogramBinarizer r5 = new com.google.zxing.common.GlobalHistogramBinarizer     // Catch:{ all -> 0x0207 }
                r5.<init>(r3)     // Catch:{ all -> 0x0207 }
                r0.<init>(r5)     // Catch:{ all -> 0x0207 }
                goto L_0x0191
            L_0x0187:
                com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap     // Catch:{ all -> 0x0207 }
                com.google.zxing.common.HybridBinarizer r5 = new com.google.zxing.common.HybridBinarizer     // Catch:{ all -> 0x0207 }
                r5.<init>(r3)     // Catch:{ all -> 0x0207 }
                r0.<init>(r5)     // Catch:{ all -> 0x0207 }
            L_0x0191:
                com.google.zxing.MultiFormatReader r3 = r8.f10747c     // Catch:{ ReaderException -> 0x01b4, IndexOutOfBoundsException -> 0x019f }
                com.google.zxing.Result r0 = r3.decodeWithState(r0)     // Catch:{ ReaderException -> 0x01b4, IndexOutOfBoundsException -> 0x019f }
                com.google.zxing.MultiFormatReader r3 = r8.f10747c     // Catch:{ all -> 0x0207 }
                r3.reset()     // Catch:{ all -> 0x0207 }
                goto L_0x01b8
            L_0x019d:
                r0 = move-exception
                goto L_0x01ae
            L_0x019f:
                com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.mode.BarCodeMode.f10708l     // Catch:{ all -> 0x019d }
                java.lang.String r3 = "decode buffer length error"
                com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r3)     // Catch:{ all -> 0x019d }
                com.google.zxing.MultiFormatReader r0 = r8.f10747c     // Catch:{ all -> 0x0207 }
            L_0x01aa:
                r0.reset()     // Catch:{ all -> 0x0207 }
                goto L_0x01b7
            L_0x01ae:
                com.google.zxing.MultiFormatReader r1 = r8.f10747c     // Catch:{ all -> 0x0207 }
                r1.reset()     // Catch:{ all -> 0x0207 }
                throw r0     // Catch:{ all -> 0x0207 }
            L_0x01b4:
                com.google.zxing.MultiFormatReader r0 = r8.f10747c     // Catch:{ all -> 0x0207 }
                goto L_0x01aa
            L_0x01b7:
                r0 = 0
            L_0x01b8:
                monitor-exit(r26)     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x01d6
                com.meizu.media.camera.mode.d r3 = com.meizu.media.camera.mode.BarCodeMode.this
                long unused = r3.f10728O = r1
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r1 = r1.f10715B
                if (r1 == 0) goto L_0x01ff
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r1 = r1.f10715B
                android.os.Message r0 = android.os.Message.obtain(r1, r7, r0)
                r0.sendToTarget()
                goto L_0x01ff
            L_0x01d6:
                com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r0 = r0.f10715B
                if (r0 == 0) goto L_0x01ff
                com.meizu.media.camera.mode.d r0 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r0 = r0.f10715B
                android.os.Message r0 = android.os.Message.obtain(r0, r4)
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                boolean r1 = r1.f10725L
                if (r1 == 0) goto L_0x01fc
                com.meizu.media.camera.mode.d r1 = com.meizu.media.camera.mode.BarCodeMode.this
                com.meizu.media.camera.mode.d$d r1 = r1.f10715B
                r2 = 500(0x1f4, double:2.47E-321)
                r1.sendMessageDelayed(r0, r2)
                goto L_0x01ff
            L_0x01fc:
                r0.sendToTarget()
            L_0x01ff:
                return
            L_0x0200:
                r6 = r15
                monitor-exit(r26)     // Catch:{ all -> 0x0207 }
                return
            L_0x0203:
                r0 = move-exception
                r6 = r15
            L_0x0205:
                monitor-exit(r26)     // Catch:{ all -> 0x0207 }
                throw r0
            L_0x0207:
                r0 = move-exception
                goto L_0x0205
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.BarCodeMode.C2172a.mo20525a(byte[]):void");
        }
    }

    /* renamed from: a */
    public void mo20513a(Result result) {
        if (!PatchProxy.proxy(new Object[]{result}, this, f10701a, false, 4653, new Class[]{Result.class}, Void.TYPE).isSupported) {
            ResultHandler a = ResultHandlerFactory.m8672a(mo20540S(), result);
            this.f10726M = a;
            if (!this.f10725L) {
                mo20539R().mo18275x(7);
                DeviceUtil.m16194a(mo20542U().mo21541af(), 22550);
            }
            ParsedResultType g = a.mo19238g();
            if (g != ParsedResultType.TEXT) {
                a.mo19242i();
            }
            switch (g) {
                case PRODUCT:
                    ((ProductResultHandler) a).mo19202a((Handler) this.f10715B, 5);
                    return;
                case ISBN:
                    ((ISBNResultHandler) a).mo19193a((Handler) this.f10715B, 6);
                    return;
                case URI:
                    ((URIResultHandler) a).mo19172a(this.f10724K, this.f10715B, 9, 10, this.f10725L);
                    return;
                case WIFI:
                    ((WifiResultHandler) a).mo19312a((Handler) this.f10715B, 8);
                    this.f10717D.mo19250a(a.mo19170a());
                    if (this.f10732m != null) {
                        this.f10732m.mo21999a(a.mo19174b(), this.f10717D, a.mo19175c());
                    }
                    if (this.f10725L) {
                        this.f10732m.mo21998a(a);
                        this.f10715B.mo20530a();
                        return;
                    } else if (this.f10732m != null) {
                        this.f10732m.mo22004b(true);
                        return;
                    } else {
                        return;
                    }
                case TEXT:
                    ((TextResultHandler) a).mo19298a(this.f10715B, 7, this.f10725L);
                    return;
                default:
                    this.f10717D.mo19250a(a.mo19170a());
                    this.f10732m.mo21999a(a.mo19174b(), this.f10717D, a.mo19175c());
                    if (this.f10725L) {
                        this.f10732m.mo21998a(a);
                        this.f10715B.mo20530a();
                    } else if (this.f10732m != null) {
                        this.f10732m.mo22004b(true);
                    }
                    if (this.f10788j != null) {
                        this.f10788j.mo21510a(1, true);
                    }
                    if (mo20539R().mo18267u() != null) {
                        mo20539R().mo18267u().mo22142b(true);
                        return;
                    }
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: an */
    public void m11244an() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4654, new Class[0], Void.TYPE).isSupported) {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 23) {
                intent.setClassName("com.meizu.connectivitysettings", "com.meizu.connectivitysettings.wifi.WifiSettings");
            } else if (Build.VERSION.SDK_INT >= 11) {
                intent.setClassName("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity");
            } else {
                intent.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings");
            }
            this.f10787i.startActivity(intent);
            if (this.f10732m != null) {
                this.f10732m.mo22013g();
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.BARCODE;
    }

    /* renamed from: d_ */
    public void mo20490d_() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4655, new Class[0], Void.TYPE).isSupported) {
            super.mo20490d_();
            LogUtil.m15942a(f10708l, "unbindService");
            if (this.f10787i != null && this.f10724K != null) {
                this.f10787i.unbindService(this.f10731R);
                this.f10724K = null;
            }
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10701a, false, 4656, new Class[0], Void.TYPE).isSupported) {
            mo20490d_();
            if (this.f10723J != null) {
                this.f10723J.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                this.f10723J.close();
            }
            if (this.f10732m != null) {
                this.f10739z = null;
                this.f10732m.mo22007d();
                this.f10788j.mo21533a(true, DeviceHelper.f13910bJ == CameraController.CameraApi.API1, false);
                if (this.f10715B != null) {
                    this.f10715B.mo20531b();
                    this.f10715B = null;
                }
                this.f10729P.mo20537b();
            }
        }
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10701a, false, 4657, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10732m != null) {
            return this.f10732m.mo22012f();
        }
        return false;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: b */
    public void mo20517b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10701a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4658, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            super.mo20517b(z);
            if (this.f10732m != null) {
                this.f10732m.mo22008d(z);
            }
        }
    }

    /* renamed from: a */
    public void mo20511a(int i, int i2, Intent intent) {
        Object[] objArr = {new Integer(i), new Integer(i2), intent};
        ChangeQuickRedirect changeQuickRedirect = f10701a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4659, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported && 800001 == i && i2 != -1 && intent != null) {
            m11246b(intent.getStringExtra("code"));
        }
    }

    /* renamed from: b */
    private void m11246b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10701a, false, 4660, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (str.startsWith("HTTP://")) {
                str = "http" + str.substring(4);
            } else if (str.startsWith("HTTPS://")) {
                str = "https" + str.substring(5);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            if (CameraModeType.ModeType.BARCODE == IntentHelper.m16298a(this.f10787i.getIntent(), this.f10787i.getContentResolver())) {
                intent.putExtra("com.android.browser.application_id", "com.android.browser");
            }
            this.f10787i.startActivity(intent);
        }
    }

    /* renamed from: b */
    public void mo20516b(int i) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10701a, false, 4661, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo20516b(i);
            if (this.f10732m != null && !this.f10725L) {
                CameraController.FlashMode flashMode = CameraController.FlashMode.FLASH_MODE_OFF;
                boolean[] zArr = new boolean[1];
                zArr[0] = mo20539R().mo18211di() == 1;
                if (i == flashMode.getIndex(true, zArr)) {
                    z = true;
                }
                this.f10732m.mo22011f(z);
                this.f10739z = true;
                this.f10738y = new long[]{0, 0, 0, 0};
                if (z) {
                    this.f10736w = System.currentTimeMillis();
                }
                if (this.f10715B != null) {
                    this.f10715B.removeMessages(11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11234a(byte[] bArr, int i, int i2) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f10701a, false, 4662, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10735v >= 100 && currentTimeMillis - this.f10736w >= 800) {
                this.f10735v = currentTimeMillis;
                long j = (long) (i * i2);
                long j2 = 0;
                for (int i3 = 0; ((long) i3) < j; i3 += 10) {
                    j2 += ((long) bArr[i3]) & 255;
                }
                long j3 = j2 / (j / ((long) 10));
                long[] jArr = this.f10738y;
                int i4 = this.f10737x % r13;
                this.f10737x = i4;
                jArr[i4] = j3;
                this.f10737x++;
                for (long j4 : this.f10738y) {
                    if (j4 > 60) {
                        z = false;
                    }
                }
                m11254d(z);
            }
        }
    }

    /* renamed from: c */
    public void mo20519c(int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10701a, false, 4663, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo20519c(i);
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10735v >= 100 && currentTimeMillis - this.f10736w >= 800) {
                    this.f10735v = currentTimeMillis;
                    if (i <= 2000) {
                        z = false;
                    }
                    m11254d(z);
                }
            }
        }
    }

    /* renamed from: d */
    private void m11254d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10701a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4664, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f10715B == null) {
            return;
        }
        if (this.f10739z == null || this.f10739z.booleanValue() != z) {
            this.f10739z = Boolean.valueOf(z);
            Message obtain = Message.obtain(this.f10715B, 11);
            obtain.obj = Boolean.valueOf(z);
            obtain.sendToTarget();
            LogUtil.C2630a aVar = f10708l;
            LogUtil.m15952c(aVar, "mIsDarkEnv :" + this.f10739z);
        }
    }

    /* renamed from: r */
    public boolean mo20521r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10701a, false, 4665, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10732m != null && this.f10732m.mo22016i();
    }

    /* renamed from: B */
    public boolean mo20510B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10701a, false, 4666, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10732m != null && this.f10732m.mo22017j();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m11231a(byte[] bArr, int i, int i2, float f) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2), new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f10701a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4667, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Float.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        try {
            int[] iArr = new int[(i * i2)];
            synchronized (bArr) {
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            for (int i3 = 0; i3 < bArr.length / 2; i3++) {
                iArr[i3] = -16777216 | ((bArr[i3] << 16) & 16711680) | ((bArr[i3] << 8) & 65280) | (bArr[i3] & 255);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap2.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
            Canvas canvas = new Canvas(createBitmap);
            canvas.rotate(f, (float) (i / 2), (float) (i2 / 2));
            canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public byte[] m11250b(byte[] bArr, int i, int i2) {
        int i3 = 2;
        byte[] bArr2 = new byte[(((i * i2) * 3) / 2)];
        int i4 = 0;
        while (i3 < bArr.length) {
            bArr2[i4] = bArr[i3];
            i3 += 4;
            i4++;
        }
        return bArr2;
    }
}
