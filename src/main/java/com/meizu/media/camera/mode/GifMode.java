package com.meizu.media.camera.mode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.gif.GifCropActivity;
import com.meizu.media.camera.gif.MzGifEncoder;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzGifUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.j */
public class GifMode extends CameraMode {

    /* renamed from: a */
    public static ChangeQuickRedirect f10819a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10820b = new LogUtil.C2630a("GifMode");

    /* renamed from: o */
    private static int f10821o;

    /* renamed from: p */
    private static int f10822p;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f10823A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f10824B = false;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f10825C = false;

    /* renamed from: D */
    private long f10826D;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f10827c;

    /* renamed from: d */
    private long f10828d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f10829e;

    /* renamed from: f */
    private C2188d f10830f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f10831g;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f10832l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f10833m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f10834n;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f10835q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f10836r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f10837s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C2186b f10838t = new C2186b();
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C2185a f10839u = new C2185a();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public MediaSaveService.C1639d f10840v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public MzGifUI f10841w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f10842x = false;

    /* renamed from: y */
    private boolean f10843y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f10844z = false;

    /* renamed from: A */
    public int mo20377A() {
        return -1;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        return true;
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
        return true;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public GifMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        mo20541T().mo20317a(16, new boolean[0]);
        this.f10830f = new C2188d();
        this.f10840v = mo20539R().mo18193dQ();
        this.f10841w = hVar.mo18267u().mo22116ae();
        this.f10841w.mo22427a(uVar);
        if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
            mo20542U().mo21506a(1);
            mo20542U().mo21592g(0);
        } else {
            mo20542U().mo21506a(0);
            mo20542U().mo21592g(0);
        }
        mo20542U().mo21593g(true);
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.GIF;
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4836, new Class[0], Void.TYPE).isSupported) {
            this.f10841w.mo22426a();
            mo20539R().mo18267u().mo22151d(true);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.j$b */
    /* compiled from: GifMode */
    private final class C2186b {

        /* renamed from: b */
        private boolean f10848b;

        /* renamed from: c */
        private boolean f10849c;

        /* renamed from: d */
        private boolean f10850d;

        private C2186b() {
            this.f10848b = false;
            this.f10849c = false;
            this.f10850d = false;
        }

        /* renamed from: a */
        public void mo20564a(boolean z) {
            this.f10848b = z;
        }

        /* renamed from: b */
        public void mo20566b(boolean z) {
            this.f10849c = z;
        }

        /* renamed from: a */
        public boolean mo20565a() {
            return this.f10848b;
        }
    }

    /* renamed from: com.meizu.media.camera.mode.j$a */
    /* compiled from: GifMode */
    private final class C2185a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10845a;

        private C2185a() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10845a, false, 4849, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        if (!GifMode.this.f10824B && !GifMode.this.f10825C && !GifMode.this.mo20539R().mo18200dX() && CameraController.m8868g().mo19522k() != null) {
                            if (System.currentTimeMillis() - GifMode.this.f10827c < 6000) {
                                if (!GifMode.this.f10823A) {
                                    GifMode.this.f10838t.mo20566b(true);
                                }
                                sendEmptyMessageDelayed(1, 100);
                                GifMode.this.f10838t.mo20564a(false);
                                return;
                            }
                            GifMode.this.f10838t.mo20564a(true);
                            GifMode.this.f10839u.sendEmptyMessage(4);
                            return;
                        }
                        return;
                    case 2:
                        GifMode.this.f10840v.mo17844a((Uri) message.obj);
                        return;
                    case 3:
                        if (!GifMode.this.mo20539R().mo18200dX()) {
                            boolean unused = GifMode.this.f10842x = true;
                            Intent intent = new Intent(GifMode.this.mo20540S(), GifCropActivity.class);
                            intent.setAction("com.meizu.media.camera.action.GIF_CROP");
                            intent.putExtra("is_secure_camera", GifMode.this.mo20540S().mo17636c());
                            intent.putExtra("gif_file_path", GifMode.this.f10832l);
                            intent.setType("com.meizu.media.camera.gif/gif");
                            GifMode.this.mo20540S().startActivityForResult(intent, 1001);
                            return;
                        }
                        return;
                    case 4:
                        GifMode.this.mo20539R().mo18122c(false);
                        GifMode.this.f10841w.mo22432e();
                        return;
                    case 5:
                        boolean unused2 = GifMode.this.f10825C = false;
                        boolean unused3 = GifMode.this.f10824B = false;
                        boolean unused4 = GifMode.this.f10844z = false;
                        GifMode.this.f10841w.mo22431d();
                        return;
                    case 6:
                        LogUtil.m15949b(GifMode.f10820b, "encode fail, cancel this capture!!");
                        GifMode.this.mo20562c();
                        return;
                    case 7:
                        boolean unused5 = GifMode.this.f10823A = true;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.j$c */
    /* compiled from: GifMode */
    private static class C2187c {

        /* renamed from: a */
        byte[] f10851a;

        /* renamed from: b */
        boolean f10852b;

        /* renamed from: c */
        boolean f10853c;

        private C2187c() {
        }
    }

    /* renamed from: com.meizu.media.camera.mode.j$d */
    /* compiled from: GifMode */
    private final class C2188d extends Thread {

        /* renamed from: a */
        public static ChangeQuickRedirect f10854a;

        /* renamed from: c */
        private ArrayList<C2187c> f10856c;

        /* renamed from: d */
        private boolean f10857d = false;

        /* renamed from: e */
        private MzGifEncoder f10858e;

        /* renamed from: f */
        private OutputStream f10859f;

        public C2188d() {
            setName("GifSaveThread");
            this.f10856c = new ArrayList<>();
            start();
        }

        /* renamed from: a */
        public void mo20567a() {
            if (!PatchProxy.proxy(new Object[0], this, f10854a, false, 4852, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    this.f10857d = true;
                    notifyAll();
                }
            }
        }

        /* renamed from: a */
        private void m11560a(byte[] bArr, boolean z, boolean z2) {
            Rect rect;
            Object[] objArr = {bArr, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f10854a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4853, new Class[]{byte[].class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                YuvImage yuvImage = new YuvImage(bArr, 17, GifMode.this.f10833m, GifMode.this.f10834n, (int[]) null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (GifMode.this.f10836r) {
                    rect = new Rect(GifMode.this.f10833m - GifMode.this.f10834n, 0, GifMode.this.f10833m, GifMode.this.f10834n);
                } else {
                    rect = new Rect(0, 0, GifMode.this.f10834n, GifMode.this.f10834n);
                }
                yuvImage.compressToJpeg(rect, 70, byteArrayOutputStream);
                if (!this.f10858e.encodeBitmap(m11559a(BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size())), this.f10859f)) {
                    GifMode.this.f10839u.sendEmptyMessage(6);
                }
                this.f10858e.setDuration(100);
                if (z2) {
                    GifMode.this.f10839u.sendEmptyMessage(7);
                }
                if (z) {
                    m11561c();
                }
            }
        }

        /* renamed from: c */
        private void m11561c() {
            if (!PatchProxy.proxy(new Object[0], this, f10854a, false, 4854, new Class[0], Void.TYPE).isSupported) {
                this.f10858e.close(this.f10859f);
                this.f10858e = null;
                try {
                    if (this.f10859f != null) {
                        this.f10859f.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!this.f10857d) {
                    GifMode.this.f10839u.sendEmptyMessage(3);
                }
            }
        }

        /* renamed from: b */
        public void mo20568b() {
            if (!PatchProxy.proxy(new Object[0], this, f10854a, false, 4855, new Class[0], Void.TYPE).isSupported) {
                synchronized (this) {
                    if (this.f10856c.size() == 0) {
                        m11561c();
                        LogUtil.m15952c(GifMode.f10820b, "gif pause stop ...");
                    }
                }
            }
        }

        /* renamed from: d */
        private void m11562d() {
            if (!PatchProxy.proxy(new Object[0], this, f10854a, false, 4856, new Class[0], Void.TYPE).isSupported) {
                String unused = GifMode.this.f10831g = CameraUtil.m15831a(GifMode.this.f10829e);
                String unused2 = GifMode.this.f10832l = Storage.m7750a().mo18651e(GifMode.this.f10831g);
                try {
                    this.f10859f = new BufferedOutputStream(new FileOutputStream(GifMode.this.f10832l));
                    this.f10858e = MzGifEncoder.create(320, 320);
                    this.f10858e.setDuration(100);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: a */
        private Bitmap m11559a(Bitmap bitmap) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, f10854a, false, 4857, new Class[]{Bitmap.class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            Matrix matrix = new Matrix();
            matrix.setRotate((float) GifMode.this.f10835q, ((float) bitmap.getWidth()) * 0.5f, ((float) bitmap.getHeight()) * 0.5f);
            if (GifMode.this.f10837s) {
                if (GifMode.this.f10835q % 180 == 0) {
                    matrix.preScale(-1.0f, 1.0f);
                } else {
                    matrix.preScale(1.0f, -1.0f);
                }
            }
            float c = 320.0f / ((float) GifMode.this.f10834n);
            matrix.postScale(c, c);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        }

        /* renamed from: e */
        private void m11563e() {
            if (!PatchProxy.proxy(new Object[0], this, f10854a, false, 4858, new Class[0], Void.TYPE).isSupported) {
                GifMode.this.f10839u.removeMessages(3);
                if (this.f10858e != null) {
                    this.f10858e.close(this.f10859f);
                    this.f10858e = null;
                }
                try {
                    if (this.f10859f != null) {
                        this.f10859f.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (GifMode.this.f10832l != null) {
                    new File(GifMode.this.f10832l).delete();
                }
                this.f10857d = false;
                GifMode.this.f10839u.sendEmptyMessage(5);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|15|16|46) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                com.meizu.savior.ChangeQuickRedirect r3 = f10854a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 4859(0x12fb, float:6.809E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                boolean r1 = r8.f10857d
                if (r1 == 0) goto L_0x001e
                r8.m11563e()
                return
            L_0x001e:
                monitor-enter(r8)
                java.util.ArrayList<com.meizu.media.camera.mode.j$c> r1 = r8.f10856c     // Catch:{ all -> 0x0079 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0079 }
                if (r1 == 0) goto L_0x002f
                r8.notifyAll()     // Catch:{ all -> 0x0079 }
                r8.wait()     // Catch:{ InterruptedException -> 0x002d }
            L_0x002d:
                monitor-exit(r8)     // Catch:{ all -> 0x0079 }
                goto L_0x0016
            L_0x002f:
                java.util.ArrayList<com.meizu.media.camera.mode.j$c> r1 = r8.f10856c     // Catch:{ all -> 0x0079 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0079 }
                com.meizu.media.camera.mode.j$c r1 = (com.meizu.media.camera.mode.GifMode.C2187c) r1     // Catch:{ all -> 0x0079 }
                monitor-exit(r8)     // Catch:{ all -> 0x0079 }
                com.meizu.media.camera.gif.MzGifEncoder r2 = r8.f10858e
                if (r2 != 0) goto L_0x003f
                r8.m11562d()
            L_0x003f:
                byte[] r2 = r1.f10851a
                boolean r3 = r1.f10852b
                boolean r1 = r1.f10853c
                r8.m11560a(r2, r3, r1)
                monitor-enter(r8)
                java.util.ArrayList<com.meizu.media.camera.mode.j$c> r1 = r8.f10856c     // Catch:{ all -> 0x0076 }
                r1.remove(r0)     // Catch:{ all -> 0x0076 }
                com.meizu.media.camera.mode.j r1 = com.meizu.media.camera.mode.GifMode.this     // Catch:{ all -> 0x0076 }
                boolean r1 = r1.f10824B     // Catch:{ all -> 0x0076 }
                if (r1 != 0) goto L_0x0071
                com.meizu.media.camera.mode.j r1 = com.meizu.media.camera.mode.GifMode.this     // Catch:{ all -> 0x0076 }
                boolean r1 = r1.f10844z     // Catch:{ all -> 0x0076 }
                if (r1 != 0) goto L_0x0071
                com.meizu.media.camera.mode.j r1 = com.meizu.media.camera.mode.GifMode.this     // Catch:{ all -> 0x0076 }
                boolean r1 = r1.f10825C     // Catch:{ all -> 0x0076 }
                if (r1 == 0) goto L_0x0071
                java.util.ArrayList<com.meizu.media.camera.mode.j$c> r1 = r8.f10856c     // Catch:{ all -> 0x0076 }
                int r1 = r1.size()     // Catch:{ all -> 0x0076 }
                if (r1 != 0) goto L_0x0071
                r8.m11561c()     // Catch:{ all -> 0x0076 }
            L_0x0071:
                r8.notifyAll()     // Catch:{ all -> 0x0076 }
                monitor-exit(r8)     // Catch:{ all -> 0x0076 }
                goto L_0x0016
            L_0x0076:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0076 }
                throw r0
            L_0x0079:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0079 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.GifMode.C2188d.run():void");
        }
    }

    /* renamed from: c */
    public void mo20562c() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4837, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10820b, "cancel gif...");
            if (this.f10838t.mo20565a()) {
                LogUtil.m15952c(f10820b, "cancel just after capture finish...");
                return;
            }
            this.f10839u.removeCallbacksAndMessages((Object) null);
            this.f10841w.mo22433f();
            this.f10824B = true;
            this.f10844z = false;
            mo20405i_();
            mo20539R().mo18122c(false);
        }
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return this.f10844z;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4838, new Class[0], Void.TYPE).isSupported) {
            mo20539R().mo18267u().mo22151d(false);
            this.f10841w.mo22429b();
            if (this.f10830f != null) {
                this.f10830f.mo20567a();
                this.f10830f = null;
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4839, new Class[0], Void.TYPE).isSupported) {
            if (!this.f10842x && this.f10830f != null) {
                this.f10830f.mo20567a();
                this.f10830f = null;
            }
            if (this.f10842x) {
                UsageStatsHelper.m16046a(false);
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4840, new Class[0], Void.TYPE).isSupported) {
            if (this.f10830f == null) {
                this.f10830f = new C2188d();
            }
            if (!this.f10842x) {
                UsageStatsHelper.m16046a(true);
            }
            if (this.f10843y) {
                this.f10840v.mo17845a(this.f10832l);
                this.f10843y = false;
                this.f10832l = null;
            }
        }
    }

    /* renamed from: o */
    public void mo20412o() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4841, new Class[0], Void.TYPE).isSupported) {
            if (!this.f10844z) {
                m11531r();
            } else if (this.f10823A) {
                m11504B();
            }
        }
    }

    /* renamed from: r */
    private void m11531r() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4842, new Class[0], Void.TYPE).isSupported) {
            this.f10844z = true;
            this.f10823A = false;
            if (this.f10830f == null) {
                this.f10830f = new C2188d();
            }
            int dR = mo20539R().mo18194dR();
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                this.f10835q = (dR + f10821o) % 360;
                this.f10837s = false;
                this.f10836r = false;
            } else {
                int i = f10822p + dR;
                int i2 = 180;
                if (dR % 180 == 0) {
                    i2 = 0;
                }
                this.f10835q = (i + i2) % 360;
                this.f10837s = this.f10841w.mo22434g();
                this.f10836r = true;
            }
            this.f10827c = System.currentTimeMillis();
            this.f10829e = this.f10827c;
            if (this.f10828d == -1) {
                this.f10828d = this.f10827c;
                mo20539R().mo18175d(this.f10828d);
            }
            this.f10833m = 0;
            this.f10834n = 0;
            this.f10839u.sendEmptyMessage(1);
            this.f10841w.mo22430c();
            mo20539R().mo18230ea();
        }
    }

    /* renamed from: B */
    private void m11504B() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4843, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f10820b, "gif stop record...");
            this.f10839u.sendEmptyMessage(4);
            this.f10844z = false;
            this.f10827c = -6000;
            if (this.f10825C) {
                this.f10830f.mo20568b();
            }
        }
    }

    /* renamed from: ad */
    public void mo20550ad() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4844, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21601i(!this.f10825C);
            if (this.f10825C) {
                this.f10825C = false;
                this.f10827c += System.currentTimeMillis() - this.f10826D;
                this.f10839u.sendEmptyMessage(1);
                mo20542U().mo21605j(5);
                return;
            }
            this.f10825C = true;
            this.f10826D = System.currentTimeMillis();
            mo20542U().mo21605j(4);
        }
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: a */
    public void mo20511a(int i, int i2, Intent intent) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), intent}, this, f10819a, false, 4845, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported && 1001 == i) {
            switch (i2) {
                case -1:
                    m11505K();
                    this.f10841w.mo22428a(true);
                    this.f10843y = true;
                    break;
                case 0:
                    new File(this.f10832l).delete();
                    this.f10841w.mo22428a(false);
                    break;
            }
            this.f10832l = null;
            this.f10831g = null;
            this.f10842x = false;
            this.f10839u.sendEmptyMessage(5);
        }
    }

    /* renamed from: K */
    private void m11505K() {
        if (!PatchProxy.proxy(new Object[0], this, f10819a, false, 4846, new Class[0], Void.TYPE).isSupported) {
            Uri a = Storage.m7750a().mo18610a(mo20539R().mo18187dK(), this.f10829e, this.f10831g, 0, 320, 320);
            int highestOneBit = Integer.highestOneBit((int) Math.ceil(320.0d / ((double) CameraUtil.m15903i())));
            Message.obtain(this.f10839u, 2, a).sendToTarget();
            this.f10840v.mo17846a(this.f10832l, highestOneBit, 0, (byte[]) null);
        }
    }

    /* renamed from: b */
    public void mo20555b(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f10819a, false, 4847, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            this.f10831g = bundle.getString("gif_file_title");
            this.f10832l = bundle.getString("gif_file_path");
        }
    }

    /* renamed from: a */
    public void mo20545a(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f10819a, false, 4848, new Class[]{Bundle.class}, Void.TYPE).isSupported && this.f10842x) {
            bundle.putString("gif_file_title", this.f10831g);
            bundle.putString("gif_file_path", this.f10832l);
        }
    }
}
