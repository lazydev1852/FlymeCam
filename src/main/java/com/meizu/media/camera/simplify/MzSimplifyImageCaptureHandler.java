package com.meizu.media.camera.simplify;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.mediatek.view.impl.ViewDebugManagerImpl;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzIntentCaptureListener;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;

/* renamed from: com.meizu.media.camera.simplify.g */
public class MzSimplifyImageCaptureHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f11952a;

    /* renamed from: b */
    private static final LogUtil.C2630a f11953b = new LogUtil.C2630a("ImgCaptureHandler");

    /* renamed from: c */
    private CameraSimplifyActivity f11954c;

    /* renamed from: d */
    private MzSimplifyImageCaptureUI f11955d;

    /* renamed from: e */
    private ContentResolver f11956e;

    /* renamed from: f */
    private boolean f11957f;

    /* renamed from: g */
    private String f11958g;

    /* renamed from: h */
    private Uri f11959h;

    /* renamed from: i */
    private byte[] f11960i;

    /* renamed from: j */
    private boolean f11961j;

    /* renamed from: k */
    private boolean f11962k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f11963l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f11964m;

    /* renamed from: n */
    private MzSimplifyCamParamsManager f11965n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f11966o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public MzIntentCaptureListener f11967p;

    /* renamed from: q */
    private MediaSaveService.C1639d f11968q = new MediaSaveService.C1639d() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11969a;

        /* renamed from: a */
        public void mo17845a(String str) {
        }

        /* renamed from: a */
        public void mo17846a(String str, int i, int i2, byte[] bArr) {
        }

        /* renamed from: a */
        public void mo17847a(List<String> list) {
        }

        /* renamed from: a */
        public void mo17844a(Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f11969a, false, 6010, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                Intent intent = new Intent();
                intent.setData(uri);
                if (MzSimplifyImageCaptureHandler.this.f11963l) {
                    intent.putExtra("isFlymeMms", 2);
                    if (MzSimplifyImageCaptureHandler.this.f11967p != null) {
                        MzSimplifyImageCaptureHandler.this.f11967p.mo17992a(-1, intent);
                    }
                } else if (MzSimplifyImageCaptureHandler.this.f11964m) {
                    intent.putExtra("isFlymeMms", 3);
                    if (MzSimplifyImageCaptureHandler.this.f11967p != null) {
                        MzSimplifyImageCaptureHandler.this.f11967p.mo17992a(-1, intent);
                    }
                } else if (MzSimplifyImageCaptureHandler.this.f11966o && MzSimplifyImageCaptureHandler.this.f11967p != null) {
                    MzSimplifyImageCaptureHandler.this.f11967p.mo17992a(-1, intent);
                }
                if ((MzSimplifyImageCaptureHandler.this.f11964m || MzSimplifyImageCaptureHandler.this.f11963l || MzSimplifyImageCaptureHandler.this.f11966o) && MzSimplifyImageCaptureHandler.this.f11967p != null) {
                    MzSimplifyImageCaptureHandler.this.f11967p.mo17999a(uri);
                }
            }
        }
    };

    /* renamed from: a */
    public static boolean m13133a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11952a, true, 5998, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ("android.media.action.IMAGE_CAPTURE".equals(str) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(str) || "meizu.intent.action.PICK".equals(str) || "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(str) || "meizu.intent.action.Gallery.Capture".equals(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m13135b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11952a, true, 5999, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(str);
    }

    /* renamed from: a */
    public String mo21272a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11952a, false, ViewDebugManagerImpl.INPUT_TIMEOUT, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if ((this.f11962k & (!this.f11963l)) && (!this.f11964m)) {
            return (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) ? "2048x1536" : "1920x1088";
        }
        return null;
    }

    public MzSimplifyImageCaptureHandler(CameraSimplifyActivity cameraSimplifyActivity, MzIntentCaptureListener oVar, MzSimplifyCamParamsManager cVar) {
        this.f11954c = cameraSimplifyActivity;
        this.f11956e = cameraSimplifyActivity.getContentResolver();
        this.f11967p = oVar;
        this.f11957f = cameraSimplifyActivity.getIntent().getBooleanExtra("android.intent.extra.quickCapture", false);
        Bundle extras = cameraSimplifyActivity.getIntent().getExtras();
        if (extras != null) {
            this.f11959h = (Uri) extras.getParcelable("output");
            this.f11958g = extras.getString("crop");
        }
        this.f11961j = "meizu.intent.action.PICK".equals(cameraSimplifyActivity.getIntent().getAction());
        this.f11962k = "android.media.action.MEIZU_CAMERA_APP_MMS_EX".equals(cameraSimplifyActivity.getIntent().getAction());
        m13138h();
        this.f11965n = cVar;
        this.f11966o = "meizu.intent.action.Gallery.Capture".equals(cameraSimplifyActivity.getIntent().getAction());
    }

    /* renamed from: a */
    public void mo21274a(MzSimplifyImageCaptureUI hVar) {
        this.f11955d = hVar;
    }

    /* renamed from: b */
    public void mo21277b() {
        this.f11960i = null;
    }

    /* renamed from: a */
    public void mo21276a(byte[] bArr, int i, boolean z) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f11952a, false, ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, new Class[]{byte[].class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11960i = bArr;
            if (this.f11967p == null || this.f11967p.mo18200dX() || this.f11960i == null) {
                LogUtil.C2630a aVar = f11953b;
                LogUtil.m15956e(aVar, "onPictureTaken return, activity is paused or data is null ? (mJpegImageData : " + this.f11960i + ")");
            } else if (!this.f11957f || this.f11961j) {
                this.f11955d.mo21286a(this.f11960i, i, z);
            } else {
                mo21275a(z);
            }
        }
    }

    /* renamed from: c */
    public void mo21278c() {
        if (!PatchProxy.proxy(new Object[0], this, f11952a, false, 6002, new Class[0], Void.TYPE).isSupported) {
            this.f11967p.mo17992a(0, new Intent());
        }
    }

    /* renamed from: d */
    public void mo21279d() {
        if (!PatchProxy.proxy(new Object[0], this, f11952a, false, 6003, new Class[0], Void.TYPE).isSupported && !this.f11967p.mo18200dX()) {
            mo21277b();
            this.f11955d.mo21287b();
            this.f11967p.mo18122c(new boolean[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r8.f11967p.mo17992a(0, (android.content.Intent) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d2, code lost:
        com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r8.f11967p.mo17992a(0, (android.content.Intent) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01dc, code lost:
        com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01df, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01e0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01e1, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:72:0x01cd, B:78:0x01d7] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x01cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x01d7 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:78:0x01d7=Splitter:B:78:0x01d7, B:72:0x01cd=Splitter:B:72:0x01cd} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo21275a(boolean r24) {
        /*
            r23 = this;
            r8 = r23
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r2 = new java.lang.Byte
            r15 = r24
            r2.<init>(r15)
            r9 = 0
            r1[r9] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = f11952a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r6[r9] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 6004(0x1774, float:8.413E-42)
            r2 = r23
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0027
            return
        L_0x0027:
            com.meizu.media.camera.o r1 = r8.f11967p
            boolean r1 = r1.mo18200dX()
            if (r1 != 0) goto L_0x01e6
            byte[] r1 = r8.f11960i
            if (r1 != 0) goto L_0x0035
            goto L_0x01e6
        L_0x0035:
            byte[] r10 = r8.f11960i
            java.lang.String r1 = r8.f11958g
            r2 = 0
            if (r1 != 0) goto L_0x0161
            android.net.Uri r0 = r8.f11959h
            r1 = -1
            if (r0 == 0) goto L_0x00c9
            android.content.ContentResolver r0 = r8.f11956e     // Catch:{ IOException -> 0x00a9 }
            android.net.Uri r3 = r8.f11959h     // Catch:{ IOException -> 0x00a9 }
            java.io.OutputStream r3 = r0.openOutputStream(r3)     // Catch:{ IOException -> 0x00a9 }
            if (r3 == 0) goto L_0x0084
            r3.write(r10)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r3.close()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            boolean r0 = r8.f11961j     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            if (r0 == 0) goto L_0x0065
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r0.<init>()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            android.net.Uri r2 = r8.f11959h     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r0.setData(r2)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            com.meizu.media.camera.o r2 = r8.f11967p     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r2.mo17992a(r1, r0)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            goto L_0x00a1
        L_0x0065:
            boolean r0 = r8.f11962k     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            if (r0 == 0) goto L_0x0079
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r0.<init>()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.String r2 = "Camera_Type"
            r0.putExtra(r2, r9)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            com.meizu.media.camera.o r2 = r8.f11967p     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r2.mo17992a(r1, r0)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            goto L_0x00a1
        L_0x0079:
            com.meizu.media.camera.o r0 = r8.f11967p     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r0.mo17992a(r1, r2)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            goto L_0x00a1
        L_0x007f:
            r0 = move-exception
            goto L_0x00c5
        L_0x0081:
            r0 = move-exception
            r2 = r3
            goto L_0x00aa
        L_0x0084:
            com.meizu.media.camera.util.ac$a r0 = f11953b     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r1.<init>()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.String r4 = "outputStream is null error uri : "
            r1.append(r4)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            android.net.Uri r4 = r8.f11959h     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r1.append(r4)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            com.meizu.media.camera.o r0 = r8.f11967p     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r0.mo17992a(r9, r2)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
        L_0x00a1:
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
            goto L_0x01c9
        L_0x00a6:
            r0 = move-exception
            r3 = r2
            goto L_0x00c5
        L_0x00a9:
            r0 = move-exception
        L_0x00aa:
            com.meizu.media.camera.util.ac$a r1 = f11953b     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r3.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = "uri save error "
            r3.append(r4)     // Catch:{ all -> 0x00a6 }
            r3.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a6 }
            com.meizu.media.camera.util.LogUtil.m15956e(r1, r0)     // Catch:{ all -> 0x00a6 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
            goto L_0x01c9
        L_0x00c5:
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
            throw r0
        L_0x00c9:
            boolean r0 = r8.f11964m
            if (r0 != 0) goto L_0x00fd
            boolean r0 = r8.f11963l
            if (r0 != 0) goto L_0x00fd
            boolean r0 = r8.f11966o
            if (r0 == 0) goto L_0x00d6
            goto L_0x00fd
        L_0x00d6:
            com.meizu.media.camera.d.c r0 = com.meizu.media.camera.Exif.m10044a((byte[]) r10)
            int r0 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r0)
            r2 = 51200(0xc800, float:7.1746E-41)
            android.graphics.Bitmap r2 = com.meizu.media.camera.util.CameraUtil.m15825a((byte[]) r10, (int) r2)
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.CameraUtil.m15819a((android.graphics.Bitmap) r2, (int) r0)
            com.meizu.media.camera.o r2 = r8.f11967p
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "inline-data"
            r3.<init>(r4)
            java.lang.String r4 = "data"
            android.content.Intent r0 = r3.putExtra(r4, r0)
            r2.mo17992a(r1, r0)
            goto L_0x01c9
        L_0x00fd:
            com.meizu.media.camera.o r0 = r8.f11967p
            if (r0 == 0) goto L_0x01c9
            com.meizu.media.camera.d.c r18 = com.meizu.media.camera.Exif.m10044a((byte[]) r10)
            int r17 = com.meizu.media.camera.Exif.m10043a((com.meizu.media.camera.p067d.ExifInterface) r18)
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            android.graphics.Point r0 = r0.mo19520j()
            com.meizu.media.camera.o r1 = r8.f11967p
            int r1 = r1.mo18142cT()
            int r1 = r1 + r17
            int r1 = r1 % 180
            if (r1 != 0) goto L_0x0124
            int r1 = r0.x
            int r0 = r0.y
        L_0x0121:
            r16 = r0
            goto L_0x0129
        L_0x0124:
            int r1 = r0.y
            int r0 = r0.x
            goto L_0x0121
        L_0x0129:
            long r12 = java.lang.System.currentTimeMillis()
            java.lang.String r11 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r12)
            if (r11 != 0) goto L_0x013c
            com.meizu.media.camera.util.ac$a r0 = f11953b
            java.lang.String r1 = "Flyme MMS title null"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            goto L_0x01c9
        L_0x013c:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r10)
            com.a.a.d r0 = com.meizu.media.camera.util.XmpUtil.m16113a((java.io.InputStream) r0)
            com.a.a.a.m r0 = (com.p006a.p007a.p008a.XMPMetaImpl) r0
            com.meizu.media.camera.a.g r22 = com.meizu.media.camera.util.XmpUtilHelper.m16122a((com.p006a.p007a.p008a.XMPMetaImpl) r0)
            com.meizu.media.camera.CameraSimplifyActivity r0 = r8.f11954c
            com.meizu.media.camera.MediaSaveService r9 = r0.mo17764p()
            r14 = 0
            com.meizu.media.camera.MediaSaveService$d r0 = r8.f11968q
            android.content.ContentResolver r2 = r8.f11956e
            r15 = r1
            r19 = r0
            r20 = r2
            r21 = r24
            r9.mo17831a(r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x01c9
        L_0x0161:
            com.meizu.media.camera.CameraSimplifyActivity r1 = r8.f11954c     // Catch:{ FileNotFoundException -> 0x01d6, IOException -> 0x01cc, all -> 0x01ca }
            java.lang.String r3 = "crop-temp"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ FileNotFoundException -> 0x01d6, IOException -> 0x01cc, all -> 0x01ca }
            r1.delete()     // Catch:{ FileNotFoundException -> 0x01d6, IOException -> 0x01cc, all -> 0x01ca }
            com.meizu.media.camera.CameraSimplifyActivity r3 = r8.f11954c     // Catch:{ FileNotFoundException -> 0x01d6, IOException -> 0x01cc, all -> 0x01ca }
            java.lang.String r4 = "crop-temp"
            java.io.FileOutputStream r3 = r3.openFileOutput(r4, r9)     // Catch:{ FileNotFoundException -> 0x01d6, IOException -> 0x01cc, all -> 0x01ca }
            r3.write(r10)     // Catch:{ FileNotFoundException -> 0x01d7, IOException -> 0x01cd }
            r3.close()     // Catch:{ FileNotFoundException -> 0x01d7, IOException -> 0x01cd }
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ FileNotFoundException -> 0x01d7, IOException -> 0x01cd }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = r8.f11958g
            java.lang.String r4 = "circle"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0197
            java.lang.String r3 = "circleCrop"
            java.lang.String r4 = "true"
            r2.putString(r3, r4)
        L_0x0197:
            android.net.Uri r3 = r8.f11959h
            if (r3 == 0) goto L_0x01a3
            java.lang.String r3 = "output"
            android.net.Uri r4 = r8.f11959h
            r2.putParcelable(r3, r4)
            goto L_0x01a8
        L_0x01a3:
            java.lang.String r3 = "return-data"
            r2.putBoolean(r3, r0)
        L_0x01a8:
            com.meizu.media.camera.CameraSimplifyActivity r3 = r8.f11954c
            boolean r3 = r3.mo17636c()
            if (r3 == 0) goto L_0x01b5
            java.lang.String r3 = "showWhenLocked"
            r2.putBoolean(r3, r0)
        L_0x01b5:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "com.meizu.media.camera.action.CROP"
            r0.<init>(r3)
            r0.setData(r1)
            r0.putExtras(r2)
            com.meizu.media.camera.CameraSimplifyActivity r1 = r8.f11954c
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.startActivityForResult(r0, r2)
        L_0x01c9:
            return
        L_0x01ca:
            r0 = move-exception
            goto L_0x01e2
        L_0x01cc:
            r3 = r2
        L_0x01cd:
            com.meizu.media.camera.o r0 = r8.f11967p     // Catch:{ all -> 0x01e0 }
            r0.mo17992a(r9, r2)     // Catch:{ all -> 0x01e0 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
            return
        L_0x01d6:
            r3 = r2
        L_0x01d7:
            com.meizu.media.camera.o r0 = r8.f11967p     // Catch:{ all -> 0x01e0 }
            r0.mo17992a(r9, r2)     // Catch:{ all -> 0x01e0 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
            return
        L_0x01e0:
            r0 = move-exception
            r2 = r3
        L_0x01e2:
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
            throw r0
        L_0x01e6:
            com.meizu.media.camera.util.ac$a r0 = f11953b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onCaptureDone(mJpegImageData : "
            r1.append(r2)
            byte[] r2 = r8.f11960i
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler.mo21275a(boolean):void");
    }

    /* renamed from: a */
    public void mo21273a(int i, int i2, Intent intent) {
        Bundle extras;
        Object[] objArr = {new Integer(i), new Integer(i2), intent};
        ChangeQuickRedirect changeQuickRedirect = f11952a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6005, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported && i == 1000) {
            Intent intent2 = new Intent();
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                intent2.putExtras(extras);
            }
            this.f11967p.mo17992a(i2, intent2);
            this.f11954c.getFileStreamPath("crop-temp").delete();
        }
    }

    /* renamed from: h */
    private void m13138h() {
        if (!PatchProxy.proxy(new Object[0], this, f11952a, false, 6006, new Class[0], Void.TYPE).isSupported) {
            int intExtra = this.f11954c.getIntent().getIntExtra("isFlymeMms", -1);
            if (intExtra == 2) {
                this.f11963l = true;
                Storage.m7750a().mo18680v();
            } else if (intExtra == 3) {
                this.f11964m = true;
            }
        }
    }

    /* renamed from: e */
    public void mo21280e() {
        if (!PatchProxy.proxy(new Object[0], this, f11952a, false, 6007, new Class[0], Void.TYPE).isSupported && this.f11955d != null) {
            this.f11955d.mo21290d();
        }
    }

    /* renamed from: f */
    public boolean mo21281f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11952a, false, 6008, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11955d != null) {
            return this.f11955d.mo21289c();
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo21282g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11952a, false, 6009, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11955d != null) {
            return this.f11955d.mo21291e();
        }
        return false;
    }
}
