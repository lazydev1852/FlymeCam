package com.meizu.media.camera.simplify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.view.View;
import android.view.animation.Animation;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.p077ui.MzFilterUI;
import com.meizu.media.camera.p077ui.SettingController;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.views.MzSlideModeRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import java.util.HashMap;

/* renamed from: com.meizu.media.camera.simplify.j */
public interface MzSimplifyUIController {

    /* renamed from: d */
    public static final int f12067d = ((ApiHelper.f14210k || !DeviceHelper.f13838R) ? 1 : 33);

    /* renamed from: e */
    public static final int f12068e = ((((((DeviceHelper.f13887an ? (char) 2 : 0) ^ (DeviceHelper.f13890aq ? (char) 16 : 0)) ^ true) ^ true) ^ true) ^ DeviceHelper.f13888ao ? 1 : 0);

    /* renamed from: f */
    public static final int f12069f;

    /* renamed from: g */
    public static final int f12070g = 1;

    /* renamed from: h */
    public static final int f12071h;

    /* renamed from: i */
    public static final HashMap<Integer, Integer[]> f12072i = new HashMap<Integer, Integer[]>() {
        {
            put(Integer.valueOf(CameraModeType.ModeType.AUTO.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12067d), Integer.valueOf(MzSimplifyUIController.f12068e)});
            put(Integer.valueOf(CameraModeType.ModeType.MANUAL.ordinal()), new Integer[]{13, 12, 269});
            put(Integer.valueOf(CameraModeType.ModeType.VIDEO.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12070g), 0});
            put(Integer.valueOf(CameraModeType.ModeType.MAKEUP.ordinal()), new Integer[]{5, 12});
            put(Integer.valueOf(CameraModeType.ModeType.PANORAMA.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.REFOCUS.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.BARCODE.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.SLOWMOTION.ordinal()), new Integer[]{5, 5});
            put(Integer.valueOf(CameraModeType.ModeType.MACRO.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12069f), Integer.valueOf(MzSimplifyUIController.f12069f)});
            put(Integer.valueOf(CameraModeType.ModeType.GIF.ordinal()), new Integer[]{1, 0});
            put(Integer.valueOf(CameraModeType.ModeType.TIMELAPSE.ordinal()), new Integer[]{132, 132});
            put(Integer.valueOf(CameraModeType.ModeType.BLACK_WHITE.ordinal()), new Integer[]{12, 12});
            put(Integer.valueOf(CameraModeType.ModeType.PORTRAIT.ordinal()), new Integer[]{12, 12});
            put(Integer.valueOf(CameraModeType.ModeType.FUNNY_SNAP.ordinal()), new Integer[]{13, 12});
            put(Integer.valueOf(CameraModeType.ModeType.SQUARE.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12071h), 12});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_TRACE.ordinal()), new Integer[]{516, 516});
            put(Integer.valueOf(CameraModeType.ModeType.SUPER_NIGHT.ordinal()), new Integer[]{1036, 1036});
            put(Integer.valueOf(CameraModeType.ModeType.AR.ordinal()), new Integer[]{512, 512});
            put(Integer.valueOf(CameraModeType.ModeType.DOCUMENT.ordinal()), new Integer[]{5, 5});
            put(Integer.valueOf(CameraModeType.ModeType.AMAZINGAR.ordinal()), new Integer[]{0, 0});
        }
    };

    /* renamed from: j */
    public static final int f12073j = (((((((((DeviceHelper.f13879af ? 2048 : 0) ^ 1) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256) ^ (DeviceHelper.f13877ad ? 32768 : 0));

    /* renamed from: k */
    public static final int f12074k = ((DeviceHelper.f13882ai ? (char) 2048 : 0) ^ ((((((((DeviceHelper.f13854aG ^ true) ^ true) ^ true) ^ true) ^ true) ^ true) ^ true) ^ (DeviceHelper.f13884ak ? (char) 8192 : 0)) ? 1 : 0);

    /* renamed from: l */
    public static final int f12075l = (((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256);

    /* renamed from: m */
    public static final int f12076m = ((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128);

    /* renamed from: n */
    public static final int f12077n = ((DeviceHelper.f13882ai ? 2048 : 0) ^ 494);

    /* renamed from: o */
    public static final int f12078o = (((((((DeviceHelper.f13879af ? 2048 : 0) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256);

    /* renamed from: p */
    public static final int f12079p = ((DeviceHelper.f13882ai ? 2048 : 0) ^ 494);

    /* renamed from: q */
    public static final int f12080q = (((((((((DeviceHelper.f14049s || DeviceHelper.f14051u || DeviceHelper.f14050t) ? 1 : 0) ^ (DeviceHelper.f13879af ? 2048 : 0)) ^ 4) ^ 8) ^ 32) ^ 64) ^ 128) ^ 256);

    /* renamed from: r */
    public static final int f12081r = (((((((DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES ? 1 : 0) ^ (DeviceHelper.f13879af ? 2048 : 0)) ^ 4) ^ 8) ^ 64) ^ 128) ^ 32);

    /* renamed from: s */
    public static final int f12082s = ((((((((DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PRO7SERIES ? 1 : 0) ^ (DeviceHelper.f13882ai ? 2048 : 0)) ^ 4) ^ 8) ^ 64) ^ 128) ^ 32) ^ 2);

    /* renamed from: t */
    public static final int f12083t = ((DeviceHelper.f13941bo ? 16384 : 0) ^ 4416);

    /* renamed from: u */
    public static final int f12084u;

    /* renamed from: v */
    public static final int f12085v = ((((((!DeviceHelper.f13854aG || !DeviceHelper.f13848aA) ? 0 : 1) ^ 128) ^ 4) ^ 8) ^ 64);

    /* renamed from: w */
    public static final int f12086w;

    /* renamed from: x */
    public static final int f12087x;

    /* renamed from: y */
    public static final HashMap<Integer, Integer[]> f12088y = new HashMap<Integer, Integer[]>() {
        {
            put(Integer.valueOf(CameraModeType.ModeType.AUTO.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12073j), Integer.valueOf(MzSimplifyUIController.f12074k)});
            put(Integer.valueOf(CameraModeType.ModeType.MANUAL.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12075l), Integer.valueOf(MzSimplifyUIController.f12077n)});
            put(Integer.valueOf(CameraModeType.ModeType.MAKEUP.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12078o), Integer.valueOf(MzSimplifyUIController.f12079p)});
            put(Integer.valueOf(CameraModeType.ModeType.PANORAMA.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.REFOCUS.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.VIDEO.ordinal()), new Integer[]{588, 588});
            put(Integer.valueOf(CameraModeType.ModeType.BARCODE.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.SLOWMOTION.ordinal()), new Integer[]{76, 76});
            put(Integer.valueOf(CameraModeType.ModeType.MACRO.ordinal()), new Integer[]{492, 494});
            put(Integer.valueOf(CameraModeType.ModeType.GIF.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.TIMELAPSE.ordinal()), new Integer[]{68, 68});
            put(Integer.valueOf(CameraModeType.ModeType.BLACK_WHITE.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12080q), Integer.valueOf(MzSimplifyUIController.f12080q)});
            put(Integer.valueOf(CameraModeType.ModeType.PORTRAIT.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12081r), Integer.valueOf(MzSimplifyUIController.f12082s)});
            put(Integer.valueOf(CameraModeType.ModeType.FUNNY_SNAP.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12083t), Integer.valueOf(MzSimplifyUIController.f12084u)});
            put(Integer.valueOf(CameraModeType.ModeType.SQUARE.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12085v), Integer.valueOf(MzSimplifyUIController.f12085v)});
            put(Integer.valueOf(CameraModeType.ModeType.BACK_TRACE.ordinal()), new Integer[]{Integer.valueOf(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY), 206});
            put(Integer.valueOf(CameraModeType.ModeType.SUPER_NIGHT.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12086w), Integer.valueOf(MzSimplifyUIController.f12086w)});
            put(Integer.valueOf(CameraModeType.ModeType.AR.ordinal()), new Integer[]{0, 0});
            put(Integer.valueOf(CameraModeType.ModeType.DOCUMENT.ordinal()), new Integer[]{Integer.valueOf(MzSimplifyUIController.f12087x), Integer.valueOf(MzSimplifyUIController.f12087x)});
            put(Integer.valueOf(CameraModeType.ModeType.AMAZINGAR.ordinal()), new Integer[]{0, 0});
        }
    };

    /* renamed from: A */
    void mo20824A();

    /* renamed from: B */
    boolean mo20825B();

    /* renamed from: E */
    boolean mo20828E();

    /* renamed from: F */
    boolean mo20829F();

    /* renamed from: G */
    boolean mo20830G();

    /* renamed from: I */
    View mo20832I();

    /* renamed from: J */
    void mo20833J();

    /* renamed from: K */
    void mo20834K();

    /* renamed from: L */
    MzFilterUI mo20835L();

    /* renamed from: M */
    boolean mo20836M();

    /* renamed from: N */
    void mo20837N();

    /* renamed from: Q */
    void mo20840Q();

    /* renamed from: T */
    boolean mo20843T();

    /* renamed from: W */
    boolean mo20846W();

    /* renamed from: a */
    void mo20851a(float f);

    /* renamed from: a */
    void mo20853a(int i, int i2);

    /* renamed from: a */
    void mo20854a(int i, int i2, int i3);

    /* renamed from: a */
    void mo20855a(int i, int i2, RectF rectF);

    /* renamed from: a */
    void mo20856a(int i, boolean z);

    /* renamed from: a */
    void mo20857a(Intent intent);

    /* renamed from: a */
    void mo20858a(Bitmap bitmap);

    /* renamed from: a */
    void mo20859a(Bitmap bitmap, int i, boolean z, boolean z2);

    /* renamed from: a */
    void mo20860a(Bitmap bitmap, byte[] bArr, String str, int i, int i2, boolean z, int i3, int i4, boolean z2);

    /* renamed from: a */
    void mo20861a(Uri uri);

    /* renamed from: a */
    void mo20863a(Animation animation);

    /* renamed from: a */
    void mo20864a(ComboPreferences eVar);

    /* renamed from: a */
    void mo20865a(MzCommonUI.C2403f fVar);

    /* renamed from: a */
    void mo20866a(SettingController.C2436a aVar);

    /* renamed from: a */
    void mo20867a(Contants.AsdSceneType asdSceneType);

    /* renamed from: a */
    void mo20868a(RenderOverlay renderOverlay, PreviewGestures yVar);

    /* renamed from: a */
    void mo20869a(MzSlideModeRenderer jVar);

    /* renamed from: a */
    void mo20870a(CharSequence charSequence);

    /* renamed from: a */
    void mo20872a(boolean z, boolean z2);

    /* renamed from: a */
    void mo20873a(boolean z, boolean z2, boolean z3);

    /* renamed from: a */
    boolean mo20874a(boolean... zArr);

    /* renamed from: aA */
    boolean mo20875aA();

    /* renamed from: aB */
    void mo20876aB();

    /* renamed from: aC */
    void mo20877aC();

    /* renamed from: aD */
    void mo20878aD();

    /* renamed from: aa */
    void mo20879aa();

    /* renamed from: ab */
    void mo20880ab();

    /* renamed from: ac */
    void mo20881ac();

    /* renamed from: ad */
    void mo20882ad();

    /* renamed from: ae */
    boolean mo20883ae();

    /* renamed from: af */
    boolean mo20884af();

    /* renamed from: ai */
    boolean mo20887ai();

    /* renamed from: ak */
    boolean mo20889ak();

    /* renamed from: al */
    boolean mo20890al();

    /* renamed from: am */
    boolean mo20891am();

    /* renamed from: an */
    boolean mo20892an();

    /* renamed from: ao */
    boolean mo20893ao();

    /* renamed from: ap */
    void mo20894ap();

    /* renamed from: aq */
    void mo20895aq();

    /* renamed from: ar */
    void mo20896ar();

    /* renamed from: as */
    void mo20897as();

    /* renamed from: at */
    void mo20898at();

    /* renamed from: av */
    boolean mo20900av();

    /* renamed from: aw */
    boolean mo20901aw();

    /* renamed from: ay */
    void mo20903ay();

    /* renamed from: az */
    void mo20904az();

    /* renamed from: b */
    void mo20907b(int i, int i2);

    /* renamed from: b */
    void mo20910b(boolean z, boolean z2);

    /* renamed from: b */
    void mo20911b(boolean z, boolean z2, boolean z3);

    /* renamed from: c */
    void mo20912c(int i);

    /* renamed from: c */
    void mo20913c(int i, int i2);

    /* renamed from: c */
    void mo20914c(int i, boolean z);

    /* renamed from: c */
    void mo20915c(boolean z);

    /* renamed from: c */
    void mo20916c(boolean z, boolean z2, boolean z3);

    /* renamed from: d */
    void mo20919d(int i);

    /* renamed from: d */
    void mo20920d(int i, int i2);

    /* renamed from: d */
    void mo20921d(int i, boolean z);

    /* renamed from: d */
    void mo20922d(boolean z);

    /* renamed from: e */
    void mo20925e(int i);

    /* renamed from: e */
    void mo20926e(int i, int i2);

    /* renamed from: e */
    void mo20927e(int i, boolean z);

    /* renamed from: e */
    void mo20928e(boolean z);

    /* renamed from: f */
    void mo20929f(int i);

    /* renamed from: f */
    void mo20931f(boolean z);

    /* renamed from: f */
    boolean mo20933f(int i, int i2);

    /* renamed from: g */
    void mo20935g(int i);

    /* renamed from: g */
    void mo20936g(int i, boolean z);

    /* renamed from: g */
    void mo20937g(boolean z);

    /* renamed from: g */
    boolean mo20938g(int i, int i2);

    /* renamed from: h */
    void mo20939h(int i);

    /* renamed from: h */
    void mo20940h(boolean z);

    /* renamed from: h */
    boolean mo20941h();

    /* renamed from: h */
    boolean mo20942h(int i, int i2);

    /* renamed from: i */
    void mo20943i();

    /* renamed from: i */
    void mo20945i(boolean z);

    /* renamed from: i */
    boolean mo20946i(int i, int i2);

    /* renamed from: j */
    void mo20947j();

    /* renamed from: j */
    void mo20948j(int i);

    /* renamed from: j */
    void mo20949j(boolean z);

    /* renamed from: k */
    void mo20950k();

    /* renamed from: k */
    void mo20951k(int i);

    /* renamed from: k */
    void mo20952k(boolean z);

    /* renamed from: l */
    void mo20954l(int i);

    /* renamed from: l */
    void mo20955l(boolean z);

    /* renamed from: m */
    void mo20957m(int i);

    /* renamed from: m */
    void mo20958m(boolean z);

    /* renamed from: n */
    void mo20960n(int i);

    /* renamed from: n */
    void mo20961n(boolean z);

    /* renamed from: o */
    long mo20962o();

    /* renamed from: o */
    void mo20963o(int i);

    /* renamed from: o */
    void mo20964o(boolean z);

    /* renamed from: p */
    void mo20967p();

    /* renamed from: p */
    void mo20968p(int i);

    /* renamed from: p */
    boolean mo20969p(boolean z);

    /* renamed from: q */
    void mo20970q();

    /* renamed from: q */
    void mo20971q(int i);

    /* renamed from: r */
    void mo20973r(int i);

    /* renamed from: r */
    void mo20974r(boolean z);

    /* renamed from: r */
    boolean mo20975r();

    /* renamed from: s */
    void mo20976s(boolean z);

    /* renamed from: s */
    boolean mo20977s();

    /* renamed from: t */
    void mo20978t();

    /* renamed from: t */
    void mo20979t(boolean z);

    /* renamed from: u */
    void mo20980u();

    /* renamed from: u */
    void mo20981u(boolean z);

    /* renamed from: v */
    void mo20982v();

    /* renamed from: v */
    void mo20983v(boolean z);

    /* renamed from: w */
    void mo20984w();

    /* renamed from: w */
    void mo20985w(boolean z);

    /* renamed from: x */
    void mo20986x();

    /* renamed from: x */
    void mo20987x(boolean z);

    /* renamed from: y */
    Contants.AsdSceneType mo20988y();

    /* renamed from: z */
    void mo20989z();

    static {
        int i;
        int i2 = 1;
        int i3 = 16;
        if (ApiHelper.f14210k || !DeviceHelper.f13838R) {
            i = 5;
        } else {
            i = (((DeviceHelper.f13889ap ? 16 : 0) ^ 1) ^ 2) ^ 4;
        }
        f12069f = i;
        boolean z = ApiHelper.f14210k;
        if (!DeviceHelper.f13889ap) {
            i3 = 0;
        }
        f12071h = (((i3 ^ 1) ^ 8) ^ (DeviceHelper.f13887an ? 2 : 0)) ^ 4;
        int i4 = 2048;
        int i5 = 16384;
        if (!DeviceHelper.f13941bo) {
            i5 = 0;
        }
        f12084u = i5 ^ 4416;
        if (!DeviceHelper.f13879af) {
            i4 = 0;
        }
        f12086w = ((i4 ^ MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY) ^ 32) ^ 256;
        if (!DeviceHelper.f13854aG || !DeviceHelper.f13848aA) {
            i2 = 0;
        }
        f12087x = (((i2 ^ 128) ^ 4) ^ 8) ^ 64;
    }
}
