package com.meizu.media.camera.mode;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.ImageReader;
import android.view.Surface;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.NullStereoCameraUI;
import com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.p */
public class PortraitMode extends CameraMode implements NullStereoCameraUI.C2435a {

    /* renamed from: a */
    public static ChangeQuickRedirect f11025a;

    /* renamed from: o */
    private static final LogUtil.C2630a f11026o = new LogUtil.C2630a("PortraitMode");

    /* renamed from: b */
    private CameraModeListener f11027b;

    /* renamed from: c */
    private int f11028c;

    /* renamed from: d */
    private UsageStatsHelper f11029d;

    /* renamed from: e */
    private NullStereoCameraUI f11030e;

    /* renamed from: f */
    private ImageReader f11031f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11032g = false;

    /* renamed from: l */
    private long f11033l = -1;

    /* renamed from: m */
    private boolean f11034m = false;

    /* renamed from: n */
    private final Object f11035n = new Object();

    /* renamed from: p */
    private RectF f11036p = new RectF();

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
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public PortraitMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f11027b = hVar;
        this.f11029d = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
        if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
            CameraController.m8868g().mo19491b(this.f10787i.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static boolean m11840a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f11025a, true, 5014, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "meizu.intent.action.shortcut.BACK_PORTRAIT".equals(str);
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.PORTRAIT;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5015, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11026o, "release");
            this.f11027b.mo18052ak(false);
            synchronized (this.f11035n) {
                this.f11034m = false;
                if (this.f11033l != -1) {
                    BokehAlorgrithmMgr.uninit(this.f11033l, true);
                    this.f11033l = -1;
                }
            }
            if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
                CameraController.m8868g().mo19445W();
            }
            if (this.f11030e != null) {
                this.f11030e.mo21869a(false, false);
                this.f11030e.mo21868a(false);
                if (mo20541T() != null) {
                    mo20541T().mo20338d(false, new boolean[0]);
                }
                mo20539R().mo18183dG();
                this.f11030e.mo21871b();
                this.f11030e = null;
            }
            if (this.f11027b.mo17914ak() != null) {
                this.f11027b.mo17914ak().mo20230j(false);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f11025a, false, 5016, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || this.f11030e == null) {
            return;
        }
        if (z) {
            this.f11030e.mo21873b(true);
        } else if (this.f10788j == null) {
        } else {
            if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
                if (this.f11027b.mo18211di() == 1) {
                    mo20542U().mo21506a(MzUIController.f12286h);
                } else {
                    mo20542U().mo21506a((int) MsgConstants.SLAM_GESTURE_INTERACTION);
                }
                this.f11030e.mo21873b(false);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5017, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f11027b.mo18211di() == 1) {
                mo20542U().mo21506a(MzUIController.f12286h);
            } else {
                mo20542U().mo21506a((int) MsgConstants.SLAM_GESTURE_INTERACTION);
            }
            mo20542U().mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            mo20542U().mo21593g(false);
            if (this.f11030e == null) {
                this.f11030e = mo20539R().mo18267u().mo22060W();
                if (this.f11030e != null) {
                    this.f11030e.mo21867a((NullStereoCameraUI.C2435a) this);
                    this.f11030e.mo21866a(this.f10788j);
                }
            }
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                mo20542U().mo21592g(MzUIController.f12302x);
            } else {
                mo20542U().mo21592g(MzUIController.f12303y);
            }
            if (this.f11030e != null) {
                this.f11030e.mo21868a(true);
            }
            if (this.f11027b.mo17914ak() != null) {
                this.f11027b.mo17914ak().mo20230j(true);
            }
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5018, new Class[0], Void.TYPE).isSupported) {
            if (this.f11030e != null) {
                if (this.f11030e.mo21870a()) {
                    this.f11030e.mo21869a(false, false);
                }
                this.f11030e.mo21868a(false);
            }
            this.f11032g = true;
            if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
                CameraController.m8868g().mo19445W();
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5019, new Class[0], Void.TYPE).isSupported) {
            if (this.f11030e != null) {
                this.f11030e.mo21868a(true);
                if (this.f11030e.mo21870a()) {
                    this.f11030e.mo21869a(true, true);
                }
            }
            this.f11032g = false;
            if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) {
                CameraController.m8868g().mo19491b(this.f10787i.getApplicationContext());
            }
        }
    }

    /* renamed from: m */
    public boolean mo20410m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11025a, false, 5020, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11030e == null || !this.f11030e.mo21870a()) {
            return false;
        }
        this.f11030e.mo21869a(false, true);
        UsageStatsHelper.m16042a(this.f10787i.getApplicationContext()).mo22695b("close_bokeh_slider");
        return true;
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11025a, false, 5021, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        mo20542U().mo21581d(4, false);
        mo20542U().mo21510a(-1, false);
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11025a, false, 5022, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11030e == null || !this.f11030e.mo21870a()) {
            return false;
        }
        this.f11030e.mo21869a(false, true);
        return true;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11025a, false, 5023, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f11027b.mo18211di() != 1) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11037a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f11037a, false, 5042, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    PortraitMode.this.mo20631d(PortraitMode.this.mo20632q());
                    PortraitMode.this.mo20630c();
                    return null;
                }
            }.mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5024, new Class[0], Void.TYPE).isSupported) {
            if (this.f11027b.mo18211di() == 1) {
                mo20542U().mo21510a(true ^ DeviceHelper.f13888ao ? 1 : 0, true);
            } else if (!CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21510a(12, true);
            }
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5025, new Class[0], Void.TYPE).isSupported) {
            if (this.f11027b.mo18211di() == 1) {
                mo20542U().mo21510a(true ^ DeviceHelper.f13888ao ? 1 : 0, true);
            } else if (!CameraOptTask.m7846m() && !CameraOptTask.m7844k()) {
                mo20542U().mo21510a(12, true);
            }
        }
    }

    /* renamed from: a */
    public void mo20496a() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5026, new Class[0], Void.TYPE).isSupported) {
            super.mo20496a();
            if (!CameraOptTask.m7846m()) {
                mo20542U().mo21510a(12, true);
                mo20542U().mo21581d(4, true);
            }
        }
    }

    /* renamed from: d */
    public void mo20631d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11025a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5027, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            int i2 = 100;
            if (!DeviceHelper.f13852aE) {
                if (DeviceHelper.f13839S) {
                    i2 = 10;
                }
                this.f11028c = i2;
            } else if (i == -1) {
                if (DeviceHelper.f13839S) {
                    i2 = 10;
                }
                this.f11028c = i2;
            } else {
                this.f11028c = i;
            }
            m11838a("mz_pref_stereo_level_key", String.valueOf(this.f11028c));
        }
    }

    /* renamed from: c */
    public void mo20630c() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5028, new Class[0], Void.TYPE).isSupported && mo20541T() != null) {
            mo20541T().mo20338d(true, new boolean[0]);
            mo20541T().mo20317a(4, new boolean[0]);
        }
    }

    /* renamed from: q */
    public int mo20632q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11025a, false, 5029, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Integer valueOf = Integer.valueOf(mo20539R().mo17902aE().getString("mz_pref_stereo_level_key", "-1"));
        if (DeviceHelper.f13852aE && valueOf.intValue() == -1) {
            valueOf = Integer.valueOf(DeviceHelper.f13839S ? 10 : 100);
            mo20631d(valueOf.intValue());
        }
        return valueOf.intValue();
    }

    /* renamed from: a */
    private void m11838a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f11025a, false, 5030, clsArr, Void.TYPE).isSupported && mo20539R() != null) {
            CameraSettings.m9781a(mo20539R().mo17902aE(), str, str2);
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5031, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = this.f11029d.mo22688a(new String[]{"mode", "location", "voice", "meshline", "level", "time_mark", "count_down", "watch_projection", "sd_card", "mirror", "is_back_camera"});
            a.put("capture_time", Long.toString(this.f11027b.mo18186dJ()));
            a.put("exposure", CameraSettings.m9787d(mo20539R().mo17902aE()));
            a.put("face_num", Integer.toString(this.f11027b.mo18267u().mo22055R()));
            a.put("flash", CameraController.m8868g().mo19534q().key);
            String str = "error mode";
            if (!(this.f11027b.mo17914ak() == null || (ak = this.f11027b.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str = h.getKey();
            }
            a.put("focus_mode", str);
            if (DeviceHelper.f13852aE) {
                String str2 = "0";
                if (mo20632q() == 10) {
                    str2 = "1";
                } else if (mo20632q() == 15) {
                    str2 = "2";
                }
                a.put("bokeh_level", str2);
            }
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1) || (DeviceHelper.f13882ai && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            this.f11029d.mo22693a("capture_info", a);
        }
    }

    /* renamed from: F */
    public void mo20382F() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5032, new Class[0], Void.TYPE).isSupported) {
            super.mo20382F();
            m11841r();
        }
    }

    /* renamed from: r */
    private void m11841r() {
        if (PatchProxy.proxy(new Object[0], this, f11025a, false, 5033, new Class[0], Void.TYPE).isSupported || this.f11027b.mo18211di() == 1 || !DeviceHelper.f13856aI) {
            return;
        }
        if (DeviceHelper.f13839S) {
            CameraController.m8868g().mo19471a("stereo-image-refocus", "on", new boolean[0]);
            if (DeviceHelper.f13858aK != DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY) {
                CameraController.m8868g().mo19471a("stereo-vsdof-mode", "on", new boolean[0]);
                CameraController.m8868g().mo19471a("stereo-denoise-mode", "off", new boolean[0]);
            }
        } else if (DeviceHelper.f14042l) {
            CameraController.m8868g().mo19471a("dual-camera-mode", "on", new boolean[0]);
            CameraController.m8868g().mo19471a("dual-camera-id", String.valueOf(2), new boolean[0]);
            CameraController.m8868g().mo19471a("dual-camera-main-camera", "true", new boolean[0]);
            CameraController.m8868g().mo19494b("zsl", "on", new boolean[0]);
        } else if (DeviceHelper.f14043m && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 3) {
            CameraController.m8868g().mo19471a("bokeh-mode", String.valueOf(1), new boolean[0]);
            CameraController.m8868g().mo19471a("bokeh-blur-value", String.valueOf(DeviceHelper.f13842V), new boolean[0]);
            CameraController.m8868g().mo19471a("sat-mode", String.valueOf(0), new boolean[0]);
            CameraController.m8868g().mo19494b("zsl", "on", new boolean[0]);
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5034, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            mo20402f_();
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11025a, false, 5035, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (!DeviceHelper.f13855aH || this.f11027b.mo18211di() != 1) {
            return null;
        }
        if (this.f11031f != null) {
            this.f11031f.close();
        }
        ArrayList arrayList = new ArrayList();
        Point l = CameraController.m8868g().mo19524l();
        if (l != null) {
            this.f11031f = ImageReader.newInstance(l.x, l.y, 35, 2);
            this.f11031f.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11039a;

                /* JADX WARNING: Code restructure failed: missing block: B:13:0x008c, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0090, code lost:
                    if (r13 != null) goto L_0x0092;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
                    if (r0 != null) goto L_0x0094;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                    r13.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
                    r13 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0099, code lost:
                    r0.addSuppressed(r13);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
                    r13.close();
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onImageAvailable(android.media.ImageReader r13) {
                    /*
                        r12 = this;
                        r0 = 1
                        java.lang.Object[] r1 = new java.lang.Object[r0]
                        r8 = 0
                        r1[r8] = r13
                        com.meizu.savior.ChangeQuickRedirect r3 = f11039a
                        java.lang.Class[] r6 = new java.lang.Class[r0]
                        java.lang.Class<android.media.ImageReader> r0 = android.media.ImageReader.class
                        r6[r8] = r0
                        java.lang.Class r7 = java.lang.Void.TYPE
                        r4 = 0
                        r5 = 5043(0x13b3, float:7.067E-42)
                        r2 = r12
                        com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                        boolean r0 = r0.isSupported
                        if (r0 == 0) goto L_0x001d
                        return
                    L_0x001d:
                        android.media.Image r13 = r13.acquireNextImage()
                        r0 = 0
                        com.meizu.media.camera.mode.p r1 = com.meizu.media.camera.mode.PortraitMode.this     // Catch:{ Throwable -> 0x008e }
                        boolean r1 = r1.f11032g     // Catch:{ Throwable -> 0x008e }
                        if (r1 == 0) goto L_0x0030
                        if (r13 == 0) goto L_0x002f
                        r13.close()
                    L_0x002f:
                        return
                    L_0x0030:
                        int r1 = r13.getWidth()     // Catch:{ Throwable -> 0x008e }
                        int r2 = r13.getHeight()     // Catch:{ Throwable -> 0x008e }
                        android.media.Image$Plane[] r3 = r13.getPlanes()     // Catch:{ Throwable -> 0x008e }
                        r3 = r3[r8]     // Catch:{ Throwable -> 0x008e }
                        int r3 = r3.getRowStride()     // Catch:{ Throwable -> 0x008e }
                        com.meizu.media.camera.mode.p r4 = com.meizu.media.camera.mode.PortraitMode.this     // Catch:{ Throwable -> 0x008e }
                        android.media.Image$Plane[] r5 = r13.getPlanes()     // Catch:{ Throwable -> 0x008e }
                        r5 = r5[r8]     // Catch:{ Throwable -> 0x008e }
                        java.nio.ByteBuffer r5 = r5.getBuffer()     // Catch:{ Throwable -> 0x008e }
                        java.nio.ByteBuffer r4 = r4.mo20628a((java.nio.ByteBuffer) r5)     // Catch:{ Throwable -> 0x008e }
                        com.meizu.media.camera.mode.p r5 = com.meizu.media.camera.mode.PortraitMode.this     // Catch:{ Throwable -> 0x008e }
                        android.media.Image$Plane[] r6 = r13.getPlanes()     // Catch:{ Throwable -> 0x008e }
                        r7 = 2
                        r6 = r6[r7]     // Catch:{ Throwable -> 0x008e }
                        java.nio.ByteBuffer r6 = r6.getBuffer()     // Catch:{ Throwable -> 0x008e }
                        java.nio.ByteBuffer r5 = r5.mo20628a((java.nio.ByteBuffer) r6)     // Catch:{ Throwable -> 0x008e }
                        int r6 = r4.remaining()     // Catch:{ Throwable -> 0x008e }
                        int r9 = r5.remaining()     // Catch:{ Throwable -> 0x008e }
                        int r10 = r3 * r2
                        int r11 = r10 * 3
                        int r11 = r11 / r7
                        byte[] r7 = new byte[r11]     // Catch:{ Throwable -> 0x008e }
                        r4.get(r7, r8, r6)     // Catch:{ Throwable -> 0x008e }
                        r5.get(r7, r10, r9)     // Catch:{ Throwable -> 0x008e }
                        r13.close()     // Catch:{ Throwable -> 0x008e }
                        com.meizu.media.camera.mode.p r6 = com.meizu.media.camera.mode.PortraitMode.this     // Catch:{ Throwable -> 0x008e }
                        r6.mo20629a((byte[]) r7, (int) r1, (int) r2, (int) r3)     // Catch:{ Throwable -> 0x008e }
                        r4.clear()     // Catch:{ Throwable -> 0x008e }
                        r5.clear()     // Catch:{ Throwable -> 0x008e }
                        if (r13 == 0) goto L_0x008b
                        r13.close()
                    L_0x008b:
                        return
                    L_0x008c:
                        r1 = move-exception
                        goto L_0x0090
                    L_0x008e:
                        r0 = move-exception
                        throw r0     // Catch:{ all -> 0x008c }
                    L_0x0090:
                        if (r13 == 0) goto L_0x00a0
                        if (r0 == 0) goto L_0x009d
                        r13.close()     // Catch:{ Throwable -> 0x0098 }
                        goto L_0x00a0
                    L_0x0098:
                        r13 = move-exception
                        r0.addSuppressed(r13)
                        goto L_0x00a0
                    L_0x009d:
                        r13.close()
                    L_0x00a0:
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.PortraitMode.C22072.onImageAvailable(android.media.ImageReader):void");
                }
            }, CameraController.m8868g().mo19518i());
            arrayList.add(this.f11031f.getSurface());
        }
        return arrayList;
    }

    /* renamed from: a */
    public ByteBuffer mo20628a(ByteBuffer byteBuffer) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{byteBuffer}, this, f11025a, false, 5036, new Class[]{ByteBuffer.class}, ByteBuffer.class);
        if (proxy.isSupported) {
            return (ByteBuffer) proxy.result;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        return allocate;
    }

    /* renamed from: C */
    public void mo20379C() {
        if (PatchProxy.proxy(new Object[0], this, f11025a, false, 5037, new Class[0], Void.TYPE).isSupported || !DeviceHelper.f13855aH) {
            return;
        }
        if (this.f11027b.mo18211di() != 1) {
            this.f11027b.mo18052ak(false);
        } else {
            this.f11027b.mo18052ak(true);
        }
    }

    /* renamed from: a */
    public void mo20629a(byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f11025a, false, 5038, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.f11035n) {
                if (this.f11027b.mo18185dI() && this.f11034m) {
                    if (this.f11033l == -1) {
                        this.f11033l = BokehAlorgrithmMgr.init(i, i2, i3, true);
                    }
                    if (bArr != null) {
                        BokehAlorgrithmMgr.previewProcess(this.f11033l, bArr, i, i2, i3, 0, 1.0f);
                        this.f11027b.mo18017a(bArr, i, i2, i3);
                    }
                }
            }
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f11025a, false, 5039, new Class[0], Void.TYPE).isSupported && this.f11027b.mo18211di() == 1) {
            LogUtil.m15942a(f11026o, "onPreviewStarted");
            this.f11034m = true;
            this.f11027b.mo18052ak(true);
            if (((!CameraOptTask.m7849p() && DeviceHelper.f13878ae) || !CameraOptTask.m7846m()) && CameraController.m8868g().mo19522k() != null && this.f10788j != null && DeviceHelper.f13855aH) {
                this.f10788j.mo21611l(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012d, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20546a(com.meizu.media.camera.camcontroller.CameraController.C1880f[] r21, int r22, boolean r23, android.graphics.Rect r24) {
        /*
            r20 = this;
            r8 = r20
            r0 = r21
            r1 = 4
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r10 = 0
            r2[r10] = r0
            java.lang.Integer r3 = new java.lang.Integer
            r15 = r22
            r3.<init>(r15)
            r14 = 1
            r2[r14] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r4 = r23
            r3.<init>(r4)
            r4 = 2
            r2[r4] = r3
            r3 = 3
            r2[r3] = r24
            com.meizu.savior.ChangeQuickRedirect r5 = f11025a
            java.lang.Class[] r6 = new java.lang.Class[r1]
            java.lang.Class<com.meizu.media.camera.camcontroller.CameraController$f[]> r1 = com.meizu.media.camera.camcontroller.CameraController.C1880f[].class
            r6[r10] = r1
            java.lang.Class r1 = java.lang.Integer.TYPE
            r6[r14] = r1
            java.lang.Class r1 = java.lang.Boolean.TYPE
            r6[r4] = r1
            java.lang.Class<android.graphics.Rect> r1 = android.graphics.Rect.class
            r6[r3] = r1
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r11 = 5040(0x13b0, float:7.063E-42)
            r1 = r2
            r2 = r20
            r3 = r5
            r5 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0048
            return
        L_0x0048:
            int r1 = r0.length
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r2 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()
            int r2 = r2.mo14239w()
            com.meizu.camera.effectlib.effects.views.EffectRenderContext r3 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()
            int r3 = r3.mo14240x()
            if (r2 >= r3) goto L_0x005f
            r16 = r2
            r2 = r3
            goto L_0x0061
        L_0x005f:
            r16 = r3
        L_0x0061:
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            r12 = 0
            r13 = 0
            r11 = r3
            r4 = 1
            r14 = r22
            r15 = r2
            m11837a(r11, r12, r13, r14, r15, r16)
            r2 = 0
            com.meizu.media.camera.camcontroller.CameraController r5 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = r5.mo19516h()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r5 != r6) goto L_0x00a9
            if (r24 == 0) goto L_0x00a9
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            int r5 = r24.width()
            int r5 = -r5
            float r5 = (float) r5
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            int r7 = r24.height()
            int r7 = -r7
            float r7 = (float) r7
            float r7 = r7 / r6
            r2.preTranslate(r5, r7)
            int r5 = r24.width()
            float r5 = (float) r5
            r6 = 1157234688(0x44fa0000, float:2000.0)
            float r5 = r6 / r5
            int r7 = r24.height()
            float r7 = (float) r7
            float r6 = r6 / r7
            r2.postScale(r5, r6)
        L_0x00a9:
            java.lang.Object r5 = r8.f11035n
            monitor-enter(r5)
            com.meizu.media.camera.mode.h r6 = r8.f11027b     // Catch:{ all -> 0x012e }
            int r6 = r6.mo18211di()     // Catch:{ all -> 0x012e }
            if (r6 != r4) goto L_0x012c
            long r6 = r8.f11033l     // Catch:{ all -> 0x012e }
            r11 = -1
            int r4 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x00be
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            return
        L_0x00be:
            if (r10 >= r1) goto L_0x012c
            r4 = r0[r10]     // Catch:{ all -> 0x012e }
            android.graphics.Rect r4 = r4.mo19557b()     // Catch:{ all -> 0x012e }
            int r4 = r4.bottom     // Catch:{ all -> 0x012e }
            r6 = r0[r10]     // Catch:{ all -> 0x012e }
            android.graphics.Rect r6 = r6.mo19557b()     // Catch:{ all -> 0x012e }
            int r6 = r6.left     // Catch:{ all -> 0x012e }
            r7 = r0[r10]     // Catch:{ all -> 0x012e }
            android.graphics.Rect r7 = r7.mo19557b()     // Catch:{ all -> 0x012e }
            int r7 = r7.right     // Catch:{ all -> 0x012e }
            r9 = r0[r10]     // Catch:{ all -> 0x012e }
            android.graphics.Rect r9 = r9.mo19557b()     // Catch:{ all -> 0x012e }
            int r9 = r9.top     // Catch:{ all -> 0x012e }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ all -> 0x012e }
            r11.<init>(r6, r9, r7, r4)     // Catch:{ all -> 0x012e }
            android.graphics.RectF r4 = r8.f11036p     // Catch:{ all -> 0x012e }
            r4.set(r11)     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00f1
            android.graphics.RectF r4 = r8.f11036p     // Catch:{ all -> 0x012e }
            r2.mapRect(r4)     // Catch:{ all -> 0x012e }
        L_0x00f1:
            android.graphics.RectF r4 = r8.f11036p     // Catch:{ all -> 0x012e }
            r3.mapRect(r4)     // Catch:{ all -> 0x012e }
            com.meizu.media.camera.singlebokeh.c r4 = new com.meizu.media.camera.singlebokeh.c     // Catch:{ all -> 0x012e }
            android.graphics.RectF r6 = r8.f11036p     // Catch:{ all -> 0x012e }
            float r6 = r6.bottom     // Catch:{ all -> 0x012e }
            int r6 = (int) r6     // Catch:{ all -> 0x012e }
            android.graphics.RectF r7 = r8.f11036p     // Catch:{ all -> 0x012e }
            float r7 = r7.left     // Catch:{ all -> 0x012e }
            int r7 = (int) r7     // Catch:{ all -> 0x012e }
            android.graphics.RectF r9 = r8.f11036p     // Catch:{ all -> 0x012e }
            float r9 = r9.right     // Catch:{ all -> 0x012e }
            int r9 = (int) r9     // Catch:{ all -> 0x012e }
            android.graphics.RectF r11 = r8.f11036p     // Catch:{ all -> 0x012e }
            float r11 = r11.top     // Catch:{ all -> 0x012e }
            int r11 = (int) r11     // Catch:{ all -> 0x012e }
            r4.<init>(r6, r7, r9, r11)     // Catch:{ all -> 0x012e }
            long r11 = r8.f11033l     // Catch:{ all -> 0x012e }
            int r15 = r4.mo21435b()     // Catch:{ all -> 0x012e }
            int r16 = r4.mo21437d()     // Catch:{ all -> 0x012e }
            int r17 = r4.mo21436c()     // Catch:{ all -> 0x012e }
            int r18 = r4.mo21434a()     // Catch:{ all -> 0x012e }
            r13 = r1
            r14 = r22
            r19 = r10
            com.meizu.media.camera.singlebokeh.BokehAlorgrithmMgr.setFace(r11, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x012e }
            int r10 = r10 + 1
            goto L_0x00be
        L_0x012c:
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            return
        L_0x012e:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.PortraitMode.mo20546a(com.meizu.media.camera.camcontroller.CameraController$f[], int, boolean, android.graphics.Rect):void");
    }

    /* renamed from: a */
    public static void m11837a(Matrix matrix, boolean z, boolean z2, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{matrix, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3)}, (Object) null, f11025a, true, 5041, new Class[]{Matrix.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            float f = 1.0f;
            float f2 = z ? -1.0f : 1.0f;
            if (z2) {
                f = -1.0f;
            }
            matrix.setScale(f2, f);
            float f3 = (float) i2;
            float f4 = (float) i3;
            matrix.postScale(f3 / 2000.0f, f4 / 2000.0f);
            matrix.postTranslate(f3 / 2.0f, f4 / 2.0f);
        }
    }
}
