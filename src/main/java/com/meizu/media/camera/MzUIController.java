package com.meizu.media.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.p077ui.MzFilterUI;
import com.meizu.media.camera.p077ui.MzLutFilterUI;
import com.meizu.media.camera.p077ui.SettingController;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.views.MzSlideModeRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.gallery.IThumbnailCallback;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.HashMap;

/* renamed from: com.meizu.media.camera.u */
public interface MzUIController {

    /* renamed from: A */
    public static final int f12273A = ((DeviceHelper.f13941bo ? 16384 : 0) ^ 4416);

    /* renamed from: B */
    public static final int f12274B = (((((((!DeviceHelper.f13854aG || !DeviceHelper.f13848aA) ? 0 : 1) ^ 128) ^ 4) ^ 8) ^ 64) ^ 131072);

    /* renamed from: C */
    public static final int f12275C = (((((DeviceHelper.f13879af ? 2048 : 0) ^ MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY) ^ 32) ^ 256) ^ 131072);

    /* renamed from: D */
    public static final int f12276D;

    /* renamed from: E */
    public static final int f12277E;

    /* renamed from: F */
    public static final HashMap<Integer, Integer[]> f12278F = new HashMap<Integer, Integer[]>() {
        {
            put(Integer.valueOf(CameraModeType.ModeType.AUTO.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12293o), Integer.valueOf(MzUIController.f12294p)});
            put(Integer.valueOf(CameraModeType.ModeType.MANUAL.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12295q), Integer.valueOf(MzUIController.f12297s)});
            put(Integer.valueOf(CameraModeType.ModeType.MAKEUP.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12298t), Integer.valueOf(MzUIController.f12299u)});
            put(Integer.valueOf(CameraModeType.ModeType.PANORAMA.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.REFOCUS.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.VIDEO.ordinal()), new Integer[]{131660, 131660});
            put(Integer.valueOf(CameraModeType.ModeType.BARCODE.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.SLOWMOTION.ordinal()), new Integer[]{76, 76});
            put(Integer.valueOf(CameraModeType.ModeType.MACRO.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12300v), Integer.valueOf(MzUIController.f12300v)});
            put(Integer.valueOf(CameraModeType.ModeType.GIF.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.TIMELAPSE.ordinal()), new Integer[]{131140, 131140});
            put(Integer.valueOf(CameraModeType.ModeType.BLACK_WHITE.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12301w), Integer.valueOf(MzUIController.f12301w)});
            put(Integer.valueOf(CameraModeType.ModeType.PORTRAIT.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12302x), Integer.valueOf(MzUIController.f12303y)});
            put(Integer.valueOf(CameraModeType.ModeType.FUNNY_SNAP.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12304z), Integer.valueOf(MzUIController.f12273A)});
            put(Integer.valueOf(CameraModeType.ModeType.SQUARE.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12274B), Integer.valueOf(MzUIController.f12274B)});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_TRACE.ordinal()), new Integer[]{Integer.valueOf(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY), 206});
            put(Integer.valueOf(CameraModeType.ModeType.SUPER_NIGHT.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12275C), Integer.valueOf(MzUIController.f12276D)});
            put(Integer.valueOf(CameraModeType.ModeType.AR.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.DOCUMENT.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12277E), Integer.valueOf(MzUIController.f12277E)});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_LIGHTING.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12275C), Integer.valueOf(MzUIController.f12276D)});
            put(Integer.valueOf(CameraModeType.ModeType.TOF.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12302x), Integer.valueOf(MzUIController.f12303y)});
            put(Integer.valueOf(CameraModeType.ModeType.NightVision.ordinal()), new Integer[]{0, 0});
        }
    };

    /* renamed from: a */
    public static final int f12279a;

    /* renamed from: b */
    public static final int f12280b = ((((((DeviceHelper.f13887an ? (char) 2 : 0) ^ true) ^ true) ^ true) ^ true) ^ DeviceHelper.f13888ao ? 1 : 0);

    /* renamed from: c */
    public static final int f12281c;

    /* renamed from: d */
    public static final int f12282d;

    /* renamed from: e */
    public static final int f12283e;

    /* renamed from: f */
    public static final int f12284f;

    /* renamed from: g */
    public static final int f12285g;

    /* renamed from: h */
    public static final int f12286h = (DeviceHelper.f13888ao ^ true ? 1 : 0);

    /* renamed from: i */
    public static final int f12287i = (DeviceHelper.f13888ao ^ true ? 1 : 0);

    /* renamed from: j */
    public static final int f12288j;

    /* renamed from: k */
    public static final int f12289k = (((DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? 1024 : 0) ^ 12) ^ (DeviceHelper.f14025dq ? 512 : 0));

    /* renamed from: l */
    public static final int f12290l = ((DeviceHelper.f14025dq ? 512 : 0) ^ 44);

    /* renamed from: m */
    public static final int f12291m;

    /* renamed from: n */
    public static final HashMap<Integer, Integer[]> f12292n = new HashMap<Integer, Integer[]>() {
        {
            put(Integer.valueOf(CameraModeType.ModeType.AUTO.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12279a), Integer.valueOf(MzUIController.f12280b)});
            put(Integer.valueOf(CameraModeType.ModeType.MANUAL.ordinal()), new Integer[]{13, 12, 269});
            put(Integer.valueOf(CameraModeType.ModeType.VIDEO.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12282d), Integer.valueOf(MzUIController.f12283e)});
            put(Integer.valueOf(CameraModeType.ModeType.MAKEUP.ordinal()), new Integer[]{5, 12});
            put(Integer.valueOf(CameraModeType.ModeType.PANORAMA.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.REFOCUS.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.BARCODE.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.SLOWMOTION.ordinal()), new Integer[]{5, 5});
            put(Integer.valueOf(CameraModeType.ModeType.MACRO.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12281c), Integer.valueOf(MzUIController.f12281c)});
            put(Integer.valueOf(CameraModeType.ModeType.GIF.ordinal()), new Integer[]{1, 0});
            put(Integer.valueOf(CameraModeType.ModeType.TIMELAPSE.ordinal()), new Integer[]{132, 132});
            put(Integer.valueOf(CameraModeType.ModeType.BLACK_WHITE.ordinal()), new Integer[]{12, 12});
            put(Integer.valueOf(CameraModeType.ModeType.PORTRAIT.ordinal()), new Integer[]{Integer.valueOf(MsgConstants.SLAM_GESTURE_INTERACTION), Integer.valueOf(MzUIController.f12286h)});
            put(Integer.valueOf(CameraModeType.ModeType.FUNNY_SNAP.ordinal()), new Integer[]{Integer.valueOf(MsgConstants.SLAM_START_FROM_LUA), Integer.valueOf(MzUIController.f12287i)});
            put(Integer.valueOf(CameraModeType.ModeType.SQUARE.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12288j), 12});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_TRACE.ordinal()), new Integer[]{516, 516});
            put(Integer.valueOf(CameraModeType.ModeType.SUPER_NIGHT.ordinal()), new Integer[]{Integer.valueOf(MzUIController.f12289k), Integer.valueOf(MzUIController.f12290l), Integer.valueOf(MzUIController.f12291m)});
            put(Integer.valueOf(CameraModeType.ModeType.AR.ordinal()), new Integer[]{2560, 2560});
            put(Integer.valueOf(CameraModeType.ModeType.DOCUMENT.ordinal()), new Integer[]{5, 5});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_LIGHTING.ordinal()), new Integer[]{44, 44});
            put(Integer.valueOf(CameraModeType.ModeType.TOF.ordinal()), new Integer[]{Integer.valueOf(MsgConstants.SLAM_GESTURE_INTERACTION), Integer.valueOf(MzUIController.f12286h)});
            put(Integer.valueOf(CameraModeType.ModeType.NightVision.ordinal()), new Integer[]{512, 512});
        }
    };

    /* renamed from: o */
    public static final int f12293o = (((((((((((DeviceHelper.f13879af ? 2048 : 0) ^ 1) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256) ^ (DeviceHelper.f13877ad ? 32768 : 0)) ^ (DeviceHelper.f13880ag ? 65536 : 0)) ^ 131072);

    /* renamed from: p */
    public static final int f12294p;

    /* renamed from: q */
    public static final int f12295q = ((((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256) ^ 131072);

    /* renamed from: r */
    public static final int f12296r = (((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 131072);

    /* renamed from: s */
    public static final int f12297s = ((DeviceHelper.f13882ai ? 2048 : 0) ^ 494);

    /* renamed from: t */
    public static final int f12298t = (((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256);

    /* renamed from: u */
    public static final int f12299u = ((DeviceHelper.f13882ai ? 2048 : 0) ^ 494);

    /* renamed from: v */
    public static final int f12300v = ((DeviceHelper.f13882ai ? 2048 : 0) ^ 429);

    /* renamed from: w */
    public static final int f12301w = (((((((((DeviceHelper.f14049s || DeviceHelper.f14051u || DeviceHelper.f14050t) ? 1 : 0) ^ (DeviceHelper.f13879af ? 2048 : 0)) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256);

    /* renamed from: x */
    public static final int f12302x = (((((((DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES ? 1 : 0) ^ (DeviceHelper.f13879af ? 2048 : 0)) ^ 4) ^ 8) ^ 64) ^ 128) ^ 32);

    /* renamed from: y */
    public static final int f12303y = ((((((((DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES ? 1 : 0) ^ (DeviceHelper.f13882ai ? 2048 : 0)) ^ 4) ^ 8) ^ 64) ^ 128) ^ 32) ^ 2);

    /* renamed from: z */
    public static final int f12304z = ((DeviceHelper.f13941bo ? 16384 : 0) ^ 4416);

    /* renamed from: A */
    void mo21476A(boolean z);

    /* renamed from: A */
    boolean mo21477A();

    /* renamed from: B */
    void mo21478B(boolean z);

    /* renamed from: B */
    boolean mo21479B();

    /* renamed from: C */
    void mo21480C();

    /* renamed from: D */
    boolean mo21481D();

    /* renamed from: E */
    boolean mo21482E();

    /* renamed from: F */
    void mo21483F();

    /* renamed from: G */
    void mo21484G();

    /* renamed from: H */
    MzFilterUI mo21485H();

    /* renamed from: I */
    MzLutFilterUI mo21486I();

    /* renamed from: J */
    void mo21487J();

    /* renamed from: K */
    void mo21488K();

    /* renamed from: L */
    void mo21489L();

    /* renamed from: M */
    void mo21490M();

    /* renamed from: N */
    void mo21491N();

    /* renamed from: O */
    boolean mo21492O();

    /* renamed from: P */
    boolean mo21493P();

    /* renamed from: Q */
    boolean mo21494Q();

    /* renamed from: R */
    boolean mo21495R();

    /* renamed from: S */
    void mo21496S();

    /* renamed from: T */
    void mo21497T();

    /* renamed from: U */
    void mo21498U();

    /* renamed from: V */
    boolean mo21499V();

    /* renamed from: W */
    boolean mo21500W();

    /* renamed from: X */
    void mo21501X();

    /* renamed from: Y */
    void mo21502Y();

    /* renamed from: Z */
    boolean mo21503Z();

    /* renamed from: a */
    Contants.AsdSceneType mo21504a();

    /* renamed from: a */
    void mo21505a(float f);

    /* renamed from: a */
    void mo21506a(int i);

    /* renamed from: a */
    void mo21507a(int i, int i2);

    /* renamed from: a */
    void mo21508a(int i, int i2, int i3);

    /* renamed from: a */
    void mo21509a(int i, int i2, RectF rectF);

    /* renamed from: a */
    void mo21510a(int i, boolean z);

    /* renamed from: a */
    void mo21511a(int i, boolean z, boolean z2);

    /* renamed from: a */
    void mo21512a(long j);

    /* renamed from: a */
    void mo21513a(long j, boolean z);

    /* renamed from: a */
    void mo21514a(Intent intent);

    /* renamed from: a */
    void mo21515a(Bitmap bitmap);

    /* renamed from: a */
    void mo21516a(Bitmap bitmap, int i, boolean z, boolean z2);

    /* renamed from: a */
    void mo21517a(Bitmap bitmap, byte[] bArr, String str, int i, int i2, boolean z, int i3, int i4, boolean z2);

    /* renamed from: a */
    void mo21518a(Uri uri);

    /* renamed from: a */
    void mo21519a(ComboPreferences eVar);

    /* renamed from: a */
    void mo21520a(MzCommonUI.C2403f fVar);

    /* renamed from: a */
    void mo21521a(SettingController.C2436a aVar);

    /* renamed from: a */
    void mo21522a(Contants.AsdSceneType asdSceneType);

    /* renamed from: a */
    void mo21523a(RenderOverlay renderOverlay, PreviewGestures yVar);

    /* renamed from: a */
    void mo21524a(MzSlideModeRenderer jVar);

    /* renamed from: a */
    void mo21525a(MzRecyclerView.C3227j jVar);

    /* renamed from: a */
    void mo21526a(RecyclerView.C3260a aVar);

    /* renamed from: a */
    void mo21527a(CharSequence charSequence);

    /* renamed from: a */
    void mo21528a(String str);

    /* renamed from: a */
    void mo21529a(String str, boolean z, long... jArr);

    /* renamed from: a */
    void mo21530a(boolean z);

    /* renamed from: a */
    void mo21531a(boolean z, int i, float f, PathInterpolator pathInterpolator);

    /* renamed from: a */
    void mo21532a(boolean z, boolean z2);

    /* renamed from: a */
    void mo21533a(boolean z, boolean z2, boolean z3);

    /* renamed from: a */
    void mo21534a(float[] fArr);

    /* renamed from: a */
    boolean mo21535a(boolean... zArr);

    /* renamed from: aa */
    long mo21536aa();

    /* renamed from: ab */
    void mo21537ab();

    /* renamed from: ac */
    void mo21538ac();

    /* renamed from: ad */
    void mo21539ad();

    /* renamed from: ae */
    void mo21540ae();

    /* renamed from: af */
    View mo21541af();

    /* renamed from: ag */
    void mo21542ag();

    /* renamed from: ah */
    boolean mo21543ah();

    /* renamed from: ai */
    void mo21544ai();

    /* renamed from: aj */
    boolean mo21545aj();

    /* renamed from: ak */
    void mo21546ak();

    /* renamed from: al */
    void mo21547al();

    /* renamed from: am */
    void mo21548am();

    /* renamed from: an */
    IThumbnailCallback mo21549an();

    /* renamed from: ao */
    void mo21550ao();

    /* renamed from: ap */
    boolean mo21551ap();

    /* renamed from: aq */
    void mo21552aq();

    /* renamed from: ar */
    void mo21553ar();

    /* renamed from: as */
    void mo21554as();

    /* renamed from: at */
    void mo21555at();

    /* renamed from: au */
    boolean mo21556au();

    /* renamed from: av */
    boolean mo21557av();

    /* renamed from: aw */
    boolean mo21558aw();

    /* renamed from: ax */
    void mo21559ax();

    /* renamed from: ay */
    boolean mo21560ay();

    /* renamed from: az */
    void mo21561az();

    /* renamed from: b */
    int mo21562b(String str);

    /* renamed from: b */
    void mo21563b();

    /* renamed from: b */
    void mo21564b(int i);

    /* renamed from: b */
    void mo21565b(int i, int i2);

    /* renamed from: b */
    void mo21566b(int i, boolean z);

    /* renamed from: b */
    void mo21567b(Bitmap bitmap);

    /* renamed from: b */
    void mo21568b(boolean z);

    /* renamed from: b */
    void mo21569b(boolean z, boolean z2);

    /* renamed from: b */
    void mo21570b(boolean z, boolean z2, boolean z3);

    /* renamed from: c */
    void mo21571c();

    /* renamed from: c */
    void mo21572c(int i);

    /* renamed from: c */
    void mo21573c(int i, int i2);

    /* renamed from: c */
    void mo21574c(int i, boolean z);

    /* renamed from: c */
    void mo21575c(boolean z);

    /* renamed from: c */
    void mo21576c(boolean z, boolean z2);

    /* renamed from: c */
    void mo21577c(boolean z, boolean z2, boolean z3);

    /* renamed from: d */
    void mo21578d();

    /* renamed from: d */
    void mo21579d(int i);

    /* renamed from: d */
    void mo21580d(int i, int i2);

    /* renamed from: d */
    void mo21581d(int i, boolean z);

    /* renamed from: d */
    void mo21582d(boolean z);

    /* renamed from: e */
    void mo21583e();

    /* renamed from: e */
    void mo21584e(int i);

    /* renamed from: e */
    void mo21585e(int i, boolean z);

    /* renamed from: e */
    void mo21586e(boolean z);

    /* renamed from: e */
    boolean mo21587e(int i, int i2);

    /* renamed from: f */
    void mo21588f(int i);

    /* renamed from: f */
    void mo21589f(boolean z);

    /* renamed from: f */
    boolean mo21590f();

    /* renamed from: f */
    boolean mo21591f(int i, int i2);

    /* renamed from: g */
    void mo21592g(int i);

    /* renamed from: g */
    void mo21593g(boolean z);

    /* renamed from: g */
    boolean mo21594g();

    /* renamed from: g */
    boolean mo21595g(int i, int i2);

    /* renamed from: h */
    void mo21596h();

    /* renamed from: h */
    void mo21597h(int i);

    /* renamed from: h */
    void mo21598h(int i, int i2);

    /* renamed from: h */
    void mo21599h(boolean z);

    /* renamed from: i */
    void mo21600i(int i);

    /* renamed from: i */
    void mo21601i(boolean z);

    /* renamed from: i */
    boolean mo21602i();

    /* renamed from: i */
    boolean mo21603i(int i, int i2);

    /* renamed from: j */
    CameraController.HdrMode mo21604j();

    /* renamed from: j */
    void mo21605j(int i);

    /* renamed from: j */
    void mo21606j(boolean z);

    /* renamed from: k */
    void mo21607k(int i);

    /* renamed from: k */
    boolean mo21608k();

    /* renamed from: k */
    boolean mo21609k(boolean z);

    /* renamed from: l */
    void mo21610l(int i);

    /* renamed from: l */
    void mo21611l(boolean z);

    /* renamed from: l */
    boolean mo21612l();

    /* renamed from: m */
    void mo21613m(int i);

    /* renamed from: m */
    void mo21614m(boolean z);

    /* renamed from: m */
    boolean mo21615m();

    /* renamed from: n */
    void mo21616n();

    /* renamed from: n */
    void mo21617n(int i);

    /* renamed from: n */
    void mo21618n(boolean z);

    /* renamed from: o */
    void mo21619o();

    /* renamed from: o */
    void mo21620o(int i);

    /* renamed from: o */
    void mo21621o(boolean z);

    /* renamed from: p */
    void mo21622p(int i);

    /* renamed from: p */
    void mo21623p(boolean z);

    /* renamed from: p */
    boolean mo21624p();

    /* renamed from: q */
    void mo21625q();

    /* renamed from: q */
    void mo21626q(int i);

    /* renamed from: q */
    void mo21627q(boolean z);

    /* renamed from: r */
    void mo21628r();

    /* renamed from: r */
    void mo21629r(int i);

    /* renamed from: r */
    void mo21630r(boolean z);

    /* renamed from: s */
    void mo21631s();

    /* renamed from: s */
    void mo21632s(int i);

    /* renamed from: s */
    void mo21633s(boolean z);

    /* renamed from: t */
    void mo21634t();

    /* renamed from: t */
    void mo21635t(int i);

    /* renamed from: t */
    void mo21636t(boolean z);

    /* renamed from: u */
    void mo21637u();

    /* renamed from: u */
    void mo21638u(int i);

    /* renamed from: u */
    void mo21639u(boolean z);

    /* renamed from: v */
    void mo21640v();

    /* renamed from: v */
    void mo21641v(boolean z);

    /* renamed from: w */
    void mo21642w();

    /* renamed from: w */
    void mo21643w(boolean z);

    /* renamed from: x */
    void mo21644x();

    /* renamed from: x */
    void mo21645x(boolean z);

    /* renamed from: y */
    void mo21646y(boolean z);

    /* renamed from: y */
    boolean mo21647y();

    /* renamed from: z */
    void mo21648z(boolean z);

    /* renamed from: z */
    boolean mo21649z();

    static {
        int i;
        int i2;
        int i3 = 16;
        int i4 = 512;
        int i5 = 1;
        if (ApiHelper.f14210k || !DeviceHelper.f13838R) {
            i = 5;
        } else {
            i = (((((((DeviceHelper.f13889ap ? 16 : 0) ^ 1) ^ 8) ^ 64) ^ (DeviceHelper.f13887an ? 2 : 0)) ^ 4) ^ 32) ^ 512;
        }
        f12279a = i;
        if (ApiHelper.f14210k || !DeviceHelper.f13838R) {
            i2 = 5;
        } else {
            i2 = ((((DeviceHelper.f13889ap ? 16 : 0) ^ 1) ^ 2) ^ 4) ^ 8;
        }
        f12281c = i2;
        char c = 8192;
        int i6 = ((DeviceHelper.f13863aP ? 8192 : 0) ^ 4608) ^ (DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? 2 : 0);
        boolean z = ApiHelper.f14210k;
        f12282d = i6 ^ 5;
        int i7 = ((DeviceHelper.f13863aP ? 8192 : 0) ^ 512) ^ (DeviceHelper.f13910bJ == CameraController.CameraApi.API2 ? 2 : 0);
        boolean z2 = ApiHelper.f14210k;
        f12283e = i7 ^ 4;
        int i8 = DeviceHelper.f13863aP ? 8192 : 0;
        boolean z3 = ApiHelper.f14210k;
        f12284f = (i8 ^ 4608) ^ 5;
        int i9 = DeviceHelper.f13863aP ? 8192 : 0;
        boolean z4 = ApiHelper.f14210k;
        f12285g = (i9 ^ 512) ^ 4;
        if (!DeviceHelper.f13889ap) {
            i3 = 0;
        }
        f12288j = (((i3 ^ 1) ^ 8) ^ (DeviceHelper.f13887an ? 2 : 0)) ^ 4;
        if (!DeviceHelper.f14025dq) {
            i4 = 0;
        }
        f12291m = i4 ^ 12;
        int i10 = 2048;
        char c2 = DeviceHelper.f13882ai ? (char) 2048 : 0;
        boolean z5 = ((((((DeviceHelper.f13854aG ^ true) ^ true) ^ true) ^ true) ^ true) ^ true) ^ true;
        if (!DeviceHelper.f13884ak) {
            c = 0;
        }
        f12294p = c2 ^ (z5 ^ c) ? 1 : 0;
        if (!DeviceHelper.f13879af) {
            i10 = 0;
        }
        f12276D = (((i10 ^ MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY) ^ 32) ^ 256) ^ 2;
        if (!DeviceHelper.f13854aG || !DeviceHelper.f13848aA) {
            i5 = 0;
        }
        f12277E = (((i5 ^ 128) ^ 4) ^ 8) ^ 64;
    }
}
