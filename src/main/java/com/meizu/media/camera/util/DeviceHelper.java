package com.meizu.media.camera.util;

import android.os.Build;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.android.p012ex.camera2.portability.p015b.SystemProperties;
import com.baidu.p020ar.base.MsgField;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class DeviceHelper {

    /* renamed from: A */
    public static boolean f13821A = false;

    /* renamed from: B */
    public static boolean f13822B = false;

    /* renamed from: C */
    public static boolean f13823C = false;

    /* renamed from: D */
    public static boolean f13824D = false;

    /* renamed from: E */
    public static boolean f13825E = false;

    /* renamed from: F */
    public static boolean f13826F = false;

    /* renamed from: G */
    public static boolean f13827G = false;

    /* renamed from: H */
    public static boolean f13828H = false;

    /* renamed from: I */
    public static boolean f13829I = false;

    /* renamed from: J */
    public static boolean f13830J = false;

    /* renamed from: K */
    public static boolean f13831K = false;

    /* renamed from: L */
    public static boolean f13832L = false;

    /* renamed from: M */
    public static boolean f13833M = false;

    /* renamed from: N */
    public static boolean f13834N = false;

    /* renamed from: O */
    public static boolean f13835O = false;

    /* renamed from: P */
    public static boolean f13836P = false;

    /* renamed from: Q */
    public static boolean f13837Q = false;

    /* renamed from: R */
    public static boolean f13838R = false;

    /* renamed from: S */
    public static boolean f13839S = false;

    /* renamed from: T */
    public static boolean f13840T = false;

    /* renamed from: U */
    public static boolean f13841U = false;

    /* renamed from: V */
    public static int f13842V = 0;

    /* renamed from: W */
    public static boolean f13843W = false;

    /* renamed from: X */
    public static boolean f13844X = false;

    /* renamed from: Y */
    public static int f13845Y = 1500;

    /* renamed from: Z */
    public static boolean f13846Z = false;

    /* renamed from: a */
    private static final LogUtil.C2630a f13847a = new LogUtil.C2630a("DeviceConfig");

    /* renamed from: aA */
    public static boolean f13848aA = false;

    /* renamed from: aB */
    public static boolean f13849aB = false;

    /* renamed from: aC */
    public static boolean f13850aC = false;

    /* renamed from: aD */
    public static boolean f13851aD = false;

    /* renamed from: aE */
    public static boolean f13852aE = false;

    /* renamed from: aF */
    public static boolean f13853aF = false;

    /* renamed from: aG */
    public static boolean f13854aG = false;

    /* renamed from: aH */
    public static boolean f13855aH = false;

    /* renamed from: aI */
    public static boolean f13856aI = false;

    /* renamed from: aJ */
    public static boolean f13857aJ = false;

    /* renamed from: aK */
    public static STEREO_TYPE f13858aK = STEREO_TYPE.TYPE_NONE;

    /* renamed from: aL */
    public static boolean f13859aL = false;

    /* renamed from: aM */
    public static boolean f13860aM = false;

    /* renamed from: aN */
    public static boolean f13861aN = false;

    /* renamed from: aO */
    public static boolean f13862aO = false;

    /* renamed from: aP */
    public static boolean f13863aP = false;

    /* renamed from: aQ */
    public static boolean f13864aQ = false;

    /* renamed from: aR */
    public static boolean f13865aR = false;

    /* renamed from: aS */
    public static boolean f13866aS = false;

    /* renamed from: aT */
    public static boolean f13867aT = false;

    /* renamed from: aU */
    public static boolean f13868aU = false;

    /* renamed from: aV */
    public static boolean f13869aV = false;

    /* renamed from: aW */
    public static int f13870aW = 54;

    /* renamed from: aX */
    public static boolean f13871aX = false;

    /* renamed from: aY */
    public static boolean f13872aY;

    /* renamed from: aZ */
    public static boolean f13873aZ = false;

    /* renamed from: aa */
    public static boolean f13874aa = false;

    /* renamed from: ab */
    public static boolean f13875ab = false;

    /* renamed from: ac */
    public static boolean f13876ac = false;

    /* renamed from: ad */
    public static boolean f13877ad = false;

    /* renamed from: ae */
    public static boolean f13878ae = false;

    /* renamed from: af */
    public static boolean f13879af = false;

    /* renamed from: ag */
    public static boolean f13880ag = false;

    /* renamed from: ah */
    public static boolean f13881ah = false;

    /* renamed from: ai */
    public static boolean f13882ai = false;

    /* renamed from: aj */
    public static boolean f13883aj = false;

    /* renamed from: ak */
    public static boolean f13884ak = false;

    /* renamed from: al */
    public static boolean f13885al = false;

    /* renamed from: am */
    public static boolean f13886am = false;

    /* renamed from: an */
    public static boolean f13887an = false;

    /* renamed from: ao */
    public static boolean f13888ao = false;

    /* renamed from: ap */
    public static boolean f13889ap = false;

    /* renamed from: aq */
    public static boolean f13890aq = false;

    /* renamed from: ar */
    public static FRONT_HDR_HAL_CONFIG f13891ar = FRONT_HDR_HAL_CONFIG.NONE;

    /* renamed from: as */
    public static boolean f13892as = false;

    /* renamed from: at */
    public static boolean f13893at = false;

    /* renamed from: au */
    public static boolean f13894au = false;

    /* renamed from: av */
    public static boolean f13895av = false;

    /* renamed from: aw */
    public static boolean f13896aw = false;

    /* renamed from: ax */
    public static boolean f13897ax = false;

    /* renamed from: ay */
    public static boolean f13898ay = false;

    /* renamed from: az */
    public static boolean f13899az = false;

    /* renamed from: b */
    public static ChangeQuickRedirect f13900b;

    /* renamed from: bA */
    public static int f13901bA = 0;

    /* renamed from: bB */
    public static boolean f13902bB = false;

    /* renamed from: bC */
    public static boolean f13903bC = false;

    /* renamed from: bD */
    public static boolean f13904bD = false;

    /* renamed from: bE */
    public static boolean f13905bE = false;

    /* renamed from: bF */
    public static boolean f13906bF = false;

    /* renamed from: bG */
    public static boolean f13907bG = false;

    /* renamed from: bH */
    public static boolean f13908bH = false;

    /* renamed from: bI */
    public static boolean f13909bI = false;

    /* renamed from: bJ */
    public static CameraController.CameraApi f13910bJ = CameraController.CameraApi.API1;

    /* renamed from: bK */
    public static int f13911bK = 3;

    /* renamed from: bL */
    public static int f13912bL = 0;

    /* renamed from: bM */
    public static int f13913bM = 0;

    /* renamed from: bN */
    public static int f13914bN = 4;

    /* renamed from: bO */
    public static int f13915bO = 0;

    /* renamed from: bP */
    public static int f13916bP = 0;

    /* renamed from: bQ */
    public static int f13917bQ = 0;

    /* renamed from: bR */
    public static int f13918bR = -1;

    /* renamed from: bS */
    public static int f13919bS;

    /* renamed from: bT */
    public static int f13920bT;

    /* renamed from: bU */
    public static int f13921bU;

    /* renamed from: bV */
    public static int f13922bV;

    /* renamed from: bW */
    public static int f13923bW;

    /* renamed from: bX */
    public static int f13924bX;

    /* renamed from: bY */
    public static int f13925bY = 10;

    /* renamed from: bZ */
    public static int f13926bZ = 3200;

    /* renamed from: ba */
    public static boolean f13927ba = false;

    /* renamed from: bb */
    public static boolean f13928bb = false;

    /* renamed from: bc */
    public static boolean f13929bc = false;

    /* renamed from: bd */
    public static int f13930bd = -1;

    /* renamed from: be */
    public static int[] f13931be = {114, 123, Opcodes.LCMP, 170, 186, 195};

    /* renamed from: bf */
    public static int[] f13932bf = {195, 174, 144, 120, 107, 102};

    /* renamed from: bg */
    public static int[] f13933bg = {MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 229, 251, 276, 289, 296};

    /* renamed from: bh */
    public static int[] f13934bh = {195, 174, 144, 120, 107, 102};

    /* renamed from: bi */
    public static boolean f13935bi = false;

    /* renamed from: bj */
    public static boolean f13936bj = false;

    /* renamed from: bk */
    public static EXPOSURE_STEP f13937bk = EXPOSURE_STEP.STANDARD;

    /* renamed from: bl */
    public static int f13938bl = 1;

    /* renamed from: bm */
    public static int f13939bm = 2;

    /* renamed from: bn */
    public static int f13940bn = 30;

    /* renamed from: bo */
    public static boolean f13941bo = false;

    /* renamed from: bp */
    public static boolean f13942bp = false;

    /* renamed from: bq */
    public static int f13943bq = 1;

    /* renamed from: br */
    public static boolean f13944br = false;

    /* renamed from: bs */
    public static int f13945bs = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: bt */
    public static int f13946bt = 1741;

    /* renamed from: bu */
    public static int f13947bu = 0;

    /* renamed from: bv */
    public static int f13948bv = 0;

    /* renamed from: bw */
    public static int f13949bw = 2;

    /* renamed from: bx */
    public static int f13950bx = 0;

    /* renamed from: by */
    public static int f13951by = 0;

    /* renamed from: bz */
    public static int f13952bz = 0;

    /* renamed from: c */
    public static int f13953c = R.string.mz_cam_mode_portrait;

    /* renamed from: cA */
    public static int f13954cA = -1;

    /* renamed from: cB */
    public static int f13955cB = -1;

    /* renamed from: cC */
    public static int f13956cC = -1;

    /* renamed from: cD */
    public static int f13957cD = -1;

    /* renamed from: cE */
    public static int[] f13958cE = {20, 25, 5, 10, 20, 5, 15, 15};

    /* renamed from: cF */
    public static int[] f13959cF = {30, 40, 10, 15, 25, 10, 20, 20};

    /* renamed from: cG */
    public static int[] f13960cG = {45, 50, 18, 23, 32, 15, 33, 30};

    /* renamed from: cH */
    public static int[] f13961cH = {53, 55, 25, 30, 40, 20, 40, 33};

    /* renamed from: cI */
    public static int[] f13962cI = {60, 60, 30, 35, 50, 30, 50, 40};

    /* renamed from: cJ */
    public static int[] f13963cJ = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: cK */
    public static int[] f13964cK = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: cL */
    public static int[] f13965cL = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: cM */
    public static int[] f13966cM = {0, 0, 0, 0, 0, 0};

    /* renamed from: cN */
    public static int[] f13967cN = {40, 35, 10, 15, 0, 0};

    /* renamed from: cO */
    public static int[] f13968cO = {50, 45, 13, 18, 0, 0};

    /* renamed from: cP */
    public static int[] f13969cP = {65, 65, 18, 20, 0, 0};

    /* renamed from: cQ */
    public static int[] f13970cQ = {75, 70, 25, 25, 0, 0};

    /* renamed from: cR */
    public static int[] f13971cR = {85, 80, 30, 30, 0, 0};

    /* renamed from: cS */
    public static int[] f13972cS = {0, 0, 0, 0, 0, 0};

    /* renamed from: cT */
    public static int[] f13973cT = {40, 35, 10, 15, 0, 0};

    /* renamed from: cU */
    public static int[] f13974cU = {50, 45, 13, 18, 0, 0};

    /* renamed from: cV */
    public static int[] f13975cV = {65, 65, 18, 20, 0, 0};

    /* renamed from: cW */
    public static int[] f13976cW = {75, 70, 25, 25, 0, 0};

    /* renamed from: cX */
    public static int[] f13977cX = {85, 80, 30, 30, 0, 0};

    /* renamed from: cY */
    public static int[] f13978cY = {40, 35, 10, 15, 0, 0};

    /* renamed from: cZ */
    public static SimpleDateFormat f13979cZ = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.ENGLISH);

    /* renamed from: ca */
    public static int f13980ca = MsgField.MSG_PADDLE_INIT;

    /* renamed from: cb */
    public static int f13981cb;

    /* renamed from: cc */
    public static int f13982cc;

    /* renamed from: cd */
    public static int f13983cd;

    /* renamed from: ce */
    public static int f13984ce;

    /* renamed from: cf */
    public static int f13985cf;

    /* renamed from: cg */
    public static int f13986cg;

    /* renamed from: ch */
    public static int f13987ch;

    /* renamed from: ci */
    public static int f13988ci;

    /* renamed from: cj */
    public static int f13989cj;

    /* renamed from: ck */
    public static int f13990ck;

    /* renamed from: cl */
    public static int f13991cl;

    /* renamed from: cm */
    public static int f13992cm;

    /* renamed from: cn */
    public static int f13993cn;

    /* renamed from: co */
    public static int f13994co;

    /* renamed from: cp */
    public static int f13995cp;

    /* renamed from: cq */
    public static int f13996cq;

    /* renamed from: cr */
    public static int f13997cr;

    /* renamed from: cs */
    public static int f13998cs;

    /* renamed from: ct */
    public static int f13999ct;

    /* renamed from: cu */
    public static int f14000cu;

    /* renamed from: cv */
    public static int f14001cv;

    /* renamed from: cw */
    public static int f14002cw;

    /* renamed from: cx */
    public static int f14003cx = -1;

    /* renamed from: cy */
    public static int f14004cy = -1;

    /* renamed from: cz */
    public static int f14005cz = -1;

    /* renamed from: d */
    public static CameraModeType.ModeType[] f14006d;

    /* renamed from: dA */
    public static boolean f14007dA = false;

    /* renamed from: dB */
    public static String f14008dB;

    /* renamed from: da */
    public static int f14009da;

    /* renamed from: db */
    public static int f14010db;

    /* renamed from: dc */
    public static String f14011dc;

    /* renamed from: dd */
    public static String f14012dd;

    /* renamed from: de */
    public static int f14013de;

    /* renamed from: df */
    public static int f14014df;

    /* renamed from: dg */
    public static int f14015dg;

    /* renamed from: dh */
    public static int f14016dh;

    /* renamed from: di */
    public static int f14017di;

    /* renamed from: dj */
    public static EIS_TYPE f14018dj;

    /* renamed from: dk */
    public static EIS_SUPPORT_SCENE f14019dk = EIS_SUPPORT_SCENE.NONE;

    /* renamed from: dl */
    public static float[] f14020dl;

    /* renamed from: dm */
    public static boolean f14021dm;

    /* renamed from: dn */
    public static float[][] f14022dn;

    /* renamed from: do */
    public static int[] f14023do;

    /* renamed from: dp */
    public static int f14024dp;

    /* renamed from: dq */
    public static boolean f14025dq;

    /* renamed from: dr */
    public static boolean f14026dr;

    /* renamed from: ds */
    public static boolean f14027ds;

    /* renamed from: dt */
    public static boolean f14028dt;

    /* renamed from: du */
    public static int f14029du;

    /* renamed from: dv */
    public static int f14030dv;

    /* renamed from: dw */
    public static boolean f14031dw;

    /* renamed from: dx */
    public static boolean f14032dx = false;

    /* renamed from: dy */
    public static boolean f14033dy;

    /* renamed from: dz */
    public static boolean f14034dz = false;

    /* renamed from: e */
    public static CameraModeType.ModeType[] f14035e;

    /* renamed from: f */
    public static CUSTOM_DEVICE_MARK f14036f = CUSTOM_DEVICE_MARK.STANDER;

    /* renamed from: g */
    public static SHUTTER_SPEED f14037g = SHUTTER_SPEED.SPUNKNOW;

    /* renamed from: h */
    public static SLOW_MOTION_FPS f14038h = SLOW_MOTION_FPS.SMF_120;

    /* renamed from: i */
    public static boolean f14039i = false;

    /* renamed from: j */
    public static boolean f14040j = true;

    /* renamed from: k */
    public static boolean f14041k = false;

    /* renamed from: l */
    public static boolean f14042l = false;

    /* renamed from: m */
    public static boolean f14043m = false;

    /* renamed from: n */
    public static int f14044n = -1;

    /* renamed from: o */
    public static boolean f14045o = false;

    /* renamed from: p */
    public static boolean f14046p = false;

    /* renamed from: q */
    public static boolean f14047q = false;

    /* renamed from: r */
    public static boolean f14048r = false;

    /* renamed from: s */
    public static boolean f14049s = false;

    /* renamed from: t */
    public static boolean f14050t = false;

    /* renamed from: u */
    public static boolean f14051u = false;

    /* renamed from: v */
    public static boolean f14052v = false;

    /* renamed from: w */
    public static boolean f14053w = false;

    /* renamed from: x */
    public static boolean f14054x = false;

    /* renamed from: y */
    public static boolean f14055y = false;

    /* renamed from: z */
    public static boolean f14056z = false;

    public enum CUSTOM_DEVICE_MARK {
        STANDER,
        PROCESS_AFTER_DEVICE_NAME;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum EIS_SUPPORT_SCENE {
        NONE,
        BACK,
        BACK_FRONT,
        WITHOUT_TELE,
        ALL;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum EIS_TYPE {
        INVENSENSE,
        ARCSOFT,
        STANDARD;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum EXPOSURE_STEP {
        STEP_POINT_ONE,
        STEP_NORMAL,
        STANDARD;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum FRONT_HDR_HAL_CONFIG {
        NONE,
        SYSTEM_PROPERTIES,
        CAMERA_CHARACTERISTICS;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum SHUTTER_SPEED {
        SPUNKNOW,
        SP10S,
        SP20S,
        SP120S,
        SP420S;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum STEREO_TYPE {
        TYPE_NONE,
        TYPE_PRO7SERIES,
        TYPE_PROCESS_IN_GALLERY,
        TYPE_PROCESS_IN_HAL,
        TYPE_PROCESS_IN_HAL_AND_GALLERY,
        TYPE_PROCESS_IN_NORMAL_CAPTURE,
        TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public enum SLOW_MOTION_FPS {
        SMF_90("90"),
        SMF_102("102"),
        SMF_100("100"),
        SMF_120("120");
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private String mValue;

        public String getValue() {
            return this.mValue;
        }

        private SLOW_MOTION_FPS(String str) {
            this.mValue = str;
        }
    }

    /* renamed from: a */
    public static CameraModeType.ModeType[] m15927a(CameraModeType.ModeType[] modeTypeArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeTypeArr}, (Object) null, f13900b, true, 7971, new Class[]{CameraModeType.ModeType[].class}, CameraModeType.ModeType[].class);
        if (proxy.isSupported) {
            return (CameraModeType.ModeType[]) proxy.result;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(modeTypeArr));
        if (arrayList.contains(CameraModeType.ModeType.FUNNY_SNAP)) {
            arrayList.remove(CameraModeType.ModeType.FUNNY_SNAP);
        }
        if (arrayList.contains(CameraModeType.ModeType.AR)) {
            arrayList.remove(CameraModeType.ModeType.AR);
        }
        if (arrayList.contains(CameraModeType.ModeType.BACK_TRACE)) {
            arrayList.remove(CameraModeType.ModeType.BACK_TRACE);
        }
        return (CameraModeType.ModeType[]) arrayList.toArray(new CameraModeType.ModeType[0]);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m15928b() {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f13900b
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r2 = 0
            r4 = 1
            r5 = 7972(0x1f24, float:1.1171E-41)
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.String r1 = android.os.Build.MODEL
            com.meizu.media.camera.util.ac$a r2 = f13847a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "start init  model:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            com.meizu.media.camera.util.ac$a r2 = f13847a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Build.BRAND:"
            r3.append(r4)
            java.lang.String r4 = android.os.Build.BRAND
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            int r2 = r1.hashCode()
            r6 = 14
            r7 = 12
            r8 = 5
            r9 = 8
            r10 = 7
            r11 = 10
            r12 = 15
            r13 = 11
            r14 = 2
            r15 = 3
            r16 = -1
            switch(r2) {
                case -2043575232: goto L_0x0382;
                case -2042392662: goto L_0x0377;
                case -1926520496: goto L_0x036c;
                case -1926520464: goto L_0x0361;
                case -1127442368: goto L_0x0357;
                case -676750638: goto L_0x034c;
                case -676749769: goto L_0x0341;
                case -567161769: goto L_0x0336;
                case -553319828: goto L_0x032b;
                case -538532618: goto L_0x031f;
                case 1572: goto L_0x0313;
                case 2441: goto L_0x0307;
                case 75569: goto L_0x02fb;
                case 76779: goto L_0x02ef;
                case 106533: goto L_0x02e3;
                case 106539: goto L_0x02d7;
                case 106565: goto L_0x02cb;
                case 106569: goto L_0x02bf;
                case 106570: goto L_0x02b3;
                case 112118: goto L_0x02a7;
                case 2342057: goto L_0x029b;
                case 3302638: goto L_0x028f;
                case 3341974: goto L_0x0283;
                case 41264258: goto L_0x0277;
                case 41264509: goto L_0x026b;
                case 72833859: goto L_0x025f;
                case 72833868: goto L_0x0253;
                case 72834820: goto L_0x0247;
                case 72834825: goto L_0x023b;
                case 72834829: goto L_0x022f;
                case 72835781: goto L_0x0224;
                case 72835790: goto L_0x0218;
                case 76401506: goto L_0x020c;
                case 76401507: goto L_0x0200;
                case 76401508: goto L_0x01f5;
                case 76401541: goto L_0x01e9;
                case 102177041: goto L_0x01dd;
                case 102177971: goto L_0x01d1;
                case 102177972: goto L_0x01c5;
                case 102178002: goto L_0x01b9;
                case 102178220: goto L_0x01ae;
                case 102178221: goto L_0x01a2;
                case 102178932: goto L_0x0196;
                case 102178934: goto L_0x018a;
                case 102178937: goto L_0x017e;
                case 102178964: goto L_0x0172;
                case 102179056: goto L_0x0166;
                case 102179057: goto L_0x015a;
                case 102179118: goto L_0x014e;
                case 102179119: goto L_0x0142;
                case 102179149: goto L_0x0136;
                case 102179150: goto L_0x012a;
                case 102179180: goto L_0x011e;
                case 102179181: goto L_0x0112;
                case 102179893: goto L_0x0106;
                case 102179926: goto L_0x00fa;
                case 102179929: goto L_0x00ee;
                case 102180079: goto L_0x00e2;
                case 102180081: goto L_0x00d6;
                case 102201252: goto L_0x00ca;
                case 102201283: goto L_0x00be;
                case 407406623: goto L_0x00b3;
                case 407406634: goto L_0x00a8;
                case 495587990: goto L_0x009c;
                case 908232785: goto L_0x0090;
                case 1167638442: goto L_0x0084;
                case 1196267593: goto L_0x0078;
                case 2087273802: goto L_0x006c;
                case 2087395894: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x038c
        L_0x0061:
            java.lang.String r2 = "15 Plus"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 6
            goto L_0x038d
        L_0x006c:
            java.lang.String r2 = "15 Lite"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 35
            goto L_0x038d
        L_0x0078:
            java.lang.String r2 = "M6 Note"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 39
            goto L_0x038d
        L_0x0084:
            java.lang.String r2 = "M5 Note"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 13
            goto L_0x038d
        L_0x0090:
            java.lang.String r2 = "Meizu mblu S6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 18
            goto L_0x038d
        L_0x009c:
            java.lang.String r2 = "Meizu M6s"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 19
            goto L_0x038d
        L_0x00a8:
            java.lang.String r2 = "PRO 7-S"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 4
            goto L_0x038d
        L_0x00b3:
            java.lang.String r2 = "PRO 7-H"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 1
            goto L_0x038d
        L_0x00be:
            java.lang.String r2 = "m2091"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 67
            goto L_0x038d
        L_0x00ca:
            java.lang.String r2 = "m2081"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 68
            goto L_0x038d
        L_0x00d6:
            java.lang.String r2 = "m1973"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 66
            goto L_0x038d
        L_0x00e2:
            java.lang.String r2 = "m1971"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 65
            goto L_0x038d
        L_0x00ee:
            java.lang.String r2 = "m1926"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 64
            goto L_0x038d
        L_0x00fa:
            java.lang.String r2 = "m1923"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 63
            goto L_0x038d
        L_0x0106:
            java.lang.String r2 = "m1911"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 62
            goto L_0x038d
        L_0x0112:
            java.lang.String r2 = "m1892"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 38
            goto L_0x038d
        L_0x011e:
            java.lang.String r2 = "m1891"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 9
            goto L_0x038d
        L_0x012a:
            java.lang.String r2 = "m1882"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 37
            goto L_0x038d
        L_0x0136:
            java.lang.String r2 = "m1881"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 25
            goto L_0x038d
        L_0x0142:
            java.lang.String r2 = "m1872"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 36
            goto L_0x038d
        L_0x014e:
            java.lang.String r2 = "m1871"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 31
            goto L_0x038d
        L_0x015a:
            java.lang.String r2 = "m1852"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 60
            goto L_0x038d
        L_0x0166:
            java.lang.String r2 = "m1851"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 59
            goto L_0x038d
        L_0x0172:
            java.lang.String r2 = "m1822"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 61
            goto L_0x038d
        L_0x017e:
            java.lang.String r2 = "m1816"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 57
            goto L_0x038d
        L_0x018a:
            java.lang.String r2 = "m1813"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 56
            goto L_0x038d
        L_0x0196:
            java.lang.String r2 = "m1811"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 55
            goto L_0x038d
        L_0x01a2:
            java.lang.String r2 = "m1793"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 23
            goto L_0x038d
        L_0x01ae:
            java.lang.String r2 = "m1792"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 0
            goto L_0x038d
        L_0x01b9:
            java.lang.String r2 = "m1721"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 40
            goto L_0x038d
        L_0x01c5:
            java.lang.String r2 = "m1712"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 17
            goto L_0x038d
        L_0x01d1:
            java.lang.String r2 = "m1711"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 14
            goto L_0x038d
        L_0x01dd:
            java.lang.String r2 = "m1621"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 12
            goto L_0x038d
        L_0x01e9:
            java.lang.String r2 = "PRO X"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 26
            goto L_0x038d
        L_0x01f5:
            java.lang.String r2 = "PRO 7"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 5
            goto L_0x038d
        L_0x0200:
            java.lang.String r2 = "PRO 6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 49
            goto L_0x038d
        L_0x020c:
            java.lang.String r2 = "PRO 5"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 53
            goto L_0x038d
        L_0x0218:
            java.lang.String r2 = "M891Q"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 8
            goto L_0x038d
        L_0x0224:
            java.lang.String r2 = "M891H"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 7
            goto L_0x038d
        L_0x022f:
            java.lang.String r2 = "M881Q"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 29
            goto L_0x038d
        L_0x023b:
            java.lang.String r2 = "M881M"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 28
            goto L_0x038d
        L_0x0247:
            java.lang.String r2 = "M881H"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 27
            goto L_0x038d
        L_0x0253:
            java.lang.String r2 = "M871Q"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 33
            goto L_0x038d
        L_0x025f:
            java.lang.String r2 = "M871H"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 32
            goto L_0x038d
        L_0x026b:
            java.lang.String r2 = "MEIZU M6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 16
            goto L_0x038d
        L_0x0277:
            java.lang.String r2 = "MEIZU E3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 58
            goto L_0x038d
        L_0x0283:
            java.lang.String r2 = "ma02"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 43
            goto L_0x038d
        L_0x028f:
            java.lang.String r2 = "m80s"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 46
            goto L_0x038d
        L_0x029b:
            java.lang.String r2 = "M1 E"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 44
            goto L_0x038d
        L_0x02a7:
            java.lang.String r2 = "s25"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 41
            goto L_0x038d
        L_0x02b3:
            java.lang.String r2 = "m96"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 21
            goto L_0x038d
        L_0x02bf:
            java.lang.String r2 = "m95"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 50
            goto L_0x038d
        L_0x02cb:
            java.lang.String r2 = "m91"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 10
            goto L_0x038d
        L_0x02d7:
            java.lang.String r2 = "m86"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 52
            goto L_0x038d
        L_0x02e3:
            java.lang.String r2 = "m80"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 45
            goto L_0x038d
        L_0x02ef:
            java.lang.String r2 = "MX6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 51
            goto L_0x038d
        L_0x02fb:
            java.lang.String r2 = "M15"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 34
            goto L_0x038d
        L_0x0307:
            java.lang.String r2 = "M6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 15
            goto L_0x038d
        L_0x0313:
            java.lang.String r2 = "15"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 30
            goto L_0x038d
        L_0x031f:
            java.lang.String r2 = "PRO 7 Plus"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 24
            goto L_0x038d
        L_0x032b:
            java.lang.String r2 = "m3 note"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 11
            goto L_0x038d
        L_0x0336:
            java.lang.String r2 = "PRO 6 Plus"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 22
            goto L_0x038d
        L_0x0341:
            java.lang.String r2 = "Meizu S6"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 20
            goto L_0x038d
        L_0x034c:
            java.lang.String r2 = "Meizu 6T"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 54
            goto L_0x038d
        L_0x0357:
            java.lang.String r2 = "m1792l"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 2
            goto L_0x038d
        L_0x0361:
            java.lang.String r2 = "PRO 6s"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 48
            goto L_0x038d
        L_0x036c:
            java.lang.String r2 = "PRO 6S"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 47
            goto L_0x038d
        L_0x0377:
            java.lang.String r2 = "M3 Max"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 42
            goto L_0x038d
        L_0x0382:
            java.lang.String r2 = "M1792L"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x038c
            r2 = 3
            goto L_0x038d
        L_0x038c:
            r2 = -1
        L_0x038d:
            switch(r2) {
                case 0: goto L_0x0458;
                case 1: goto L_0x0458;
                case 2: goto L_0x0453;
                case 3: goto L_0x0453;
                case 4: goto L_0x0453;
                case 5: goto L_0x0453;
                case 6: goto L_0x044e;
                case 7: goto L_0x044e;
                case 8: goto L_0x044e;
                case 9: goto L_0x044e;
                case 10: goto L_0x0449;
                case 11: goto L_0x0449;
                case 12: goto L_0x0444;
                case 13: goto L_0x0444;
                case 14: goto L_0x043f;
                case 15: goto L_0x043f;
                case 16: goto L_0x043f;
                case 17: goto L_0x043a;
                case 18: goto L_0x043a;
                case 19: goto L_0x043a;
                case 20: goto L_0x043a;
                case 21: goto L_0x0435;
                case 22: goto L_0x0435;
                case 23: goto L_0x0430;
                case 24: goto L_0x0430;
                case 25: goto L_0x042b;
                case 26: goto L_0x042b;
                case 27: goto L_0x042b;
                case 28: goto L_0x042b;
                case 29: goto L_0x042b;
                case 30: goto L_0x042b;
                case 31: goto L_0x0426;
                case 32: goto L_0x0426;
                case 33: goto L_0x0426;
                case 34: goto L_0x0426;
                case 35: goto L_0x0426;
                case 36: goto L_0x0421;
                case 37: goto L_0x041c;
                case 38: goto L_0x0417;
                case 39: goto L_0x0412;
                case 40: goto L_0x0412;
                case 41: goto L_0x040d;
                case 42: goto L_0x040d;
                case 43: goto L_0x040d;
                case 44: goto L_0x040d;
                case 45: goto L_0x0408;
                case 46: goto L_0x0408;
                case 47: goto L_0x0408;
                case 48: goto L_0x0408;
                case 49: goto L_0x0408;
                case 50: goto L_0x0403;
                case 51: goto L_0x0403;
                case 52: goto L_0x03fe;
                case 53: goto L_0x03fe;
                case 54: goto L_0x03f9;
                case 55: goto L_0x03f9;
                case 56: goto L_0x03f4;
                case 57: goto L_0x03ef;
                case 58: goto L_0x03ea;
                case 59: goto L_0x03ea;
                case 60: goto L_0x03e5;
                case 61: goto L_0x03e0;
                case 62: goto L_0x03db;
                case 63: goto L_0x03d6;
                case 64: goto L_0x03d1;
                case 65: goto L_0x03cc;
                case 66: goto L_0x03c7;
                case 67: goto L_0x03c2;
                case 68: goto L_0x03bd;
                default: goto L_0x0390;
            }
        L_0x0390:
            java.lang.String r2 = m15925a()
            if (r2 == 0) goto L_0x0553
            com.meizu.media.camera.util.ac$a r3 = f13847a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "start init  flymeModel:"
            r4.append(r5)
            java.lang.String r5 = r2.toUpperCase()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)
            java.lang.String r2 = r2.toUpperCase()
            int r3 = r2.hashCode()
            switch(r3) {
                case 2016847: goto L_0x0500;
                case 72626262: goto L_0x04f6;
                case 72626265: goto L_0x04ec;
                case 72626292: goto L_0x04e2;
                case 72626385: goto L_0x04d8;
                case 72626447: goto L_0x04ce;
                case 72626478: goto L_0x04c4;
                case 72626509: goto L_0x04ba;
                case 72627221: goto L_0x04b0;
                case 72627254: goto L_0x04a5;
                case 72627257: goto L_0x0499;
                case 72627259: goto L_0x048d;
                case 72627407: goto L_0x0481;
                case 72627409: goto L_0x0475;
                case 72648580: goto L_0x0469;
                case 72648611: goto L_0x045d;
                default: goto L_0x03bb;
            }
        L_0x03bb:
            goto L_0x050b
        L_0x03bd:
            com.meizu.media.camera.p065b.M2081.m8480a()
            goto L_0x0556
        L_0x03c2:
            com.meizu.media.camera.p065b.M2091.m8481a()
            goto L_0x0556
        L_0x03c7:
            com.meizu.media.camera.p065b.M1973.m8512a()
            goto L_0x0556
        L_0x03cc:
            com.meizu.media.camera.p065b.M1971.m8511a()
            goto L_0x0556
        L_0x03d1:
            com.meizu.media.camera.p065b.M1926.m8509a()
            goto L_0x0556
        L_0x03d6:
            com.meizu.media.camera.p065b.M1923.m8508a()
            goto L_0x0556
        L_0x03db:
            com.meizu.media.camera.p065b.M1911.m8507a()
            goto L_0x0556
        L_0x03e0:
            com.meizu.media.camera.p065b.M1822.m8498a()
            goto L_0x0556
        L_0x03e5:
            com.meizu.media.camera.p065b.M1852.m8500a()
            goto L_0x0556
        L_0x03ea:
            com.meizu.media.camera.p065b.M1851.m8499a()
            goto L_0x0556
        L_0x03ef:
            com.meizu.media.camera.p065b.M1816.m8497a()
            goto L_0x0556
        L_0x03f4:
            com.meizu.media.camera.p065b.M1813.m8496a()
            goto L_0x0556
        L_0x03f9:
            com.meizu.media.camera.p065b.M1811.m8495a()
            goto L_0x0556
        L_0x03fe:
            com.meizu.media.camera.p065b.M86.m8483a()
            goto L_0x0556
        L_0x0403:
            com.meizu.media.camera.p065b.M95.m8485a()
            goto L_0x0556
        L_0x0408:
            com.meizu.media.camera.p065b.M80.m8482a()
            goto L_0x0556
        L_0x040d:
            com.meizu.media.camera.p065b.MA02.m8487a()
            goto L_0x0556
        L_0x0412:
            com.meizu.media.camera.p065b.M1721.m8491a()
            goto L_0x0556
        L_0x0417:
            com.meizu.media.camera.p065b.M1892.m8506a()
            goto L_0x0556
        L_0x041c:
            com.meizu.media.camera.p065b.M1882.m8504a()
            goto L_0x0556
        L_0x0421:
            com.meizu.media.camera.p065b.M1872.m8502a()
            goto L_0x0556
        L_0x0426:
            com.meizu.media.camera.p065b.M1871.m8501a()
            goto L_0x0556
        L_0x042b:
            com.meizu.media.camera.p065b.M1881.m8503a()
            goto L_0x0556
        L_0x0430:
            com.meizu.media.camera.p065b.M1793.m8494a()
            goto L_0x0556
        L_0x0435:
            com.meizu.media.camera.p065b.M96.m8486a()
            goto L_0x0556
        L_0x043a:
            com.meizu.media.camera.p065b.M1712.m8490a()
            goto L_0x0556
        L_0x043f:
            com.meizu.media.camera.p065b.M1711.m8489a()
            goto L_0x0556
        L_0x0444:
            com.meizu.media.camera.p065b.M1621.m8488a()
            goto L_0x0556
        L_0x0449:
            com.meizu.media.camera.p065b.M91.m8484a()
            goto L_0x0556
        L_0x044e:
            com.meizu.media.camera.p065b.M1891.m8505a()
            goto L_0x0556
        L_0x0453:
            com.meizu.media.camera.p065b.M1792L.m8493a()
            goto L_0x0556
        L_0x0458:
            com.meizu.media.camera.p065b.M1792.m8492a()
            goto L_0x0556
        L_0x045d:
            java.lang.String r3 = "M2091"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 15
            goto L_0x050c
        L_0x0469:
            java.lang.String r3 = "M2081"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 14
            goto L_0x050c
        L_0x0475:
            java.lang.String r3 = "M1973"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 12
            goto L_0x050c
        L_0x0481:
            java.lang.String r3 = "M1971"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 10
            goto L_0x050c
        L_0x048d:
            java.lang.String r3 = "M1928"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 13
            goto L_0x050c
        L_0x0499:
            java.lang.String r3 = "M1926"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 9
            goto L_0x050c
        L_0x04a5:
            java.lang.String r3 = "M1923"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 8
            goto L_0x050c
        L_0x04b0:
            java.lang.String r3 = "M1911"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 7
            goto L_0x050c
        L_0x04ba:
            java.lang.String r3 = "M1892"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 4
            goto L_0x050c
        L_0x04c4:
            java.lang.String r3 = "M1882"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 3
            goto L_0x050c
        L_0x04ce:
            java.lang.String r3 = "M1872"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 2
            goto L_0x050c
        L_0x04d8:
            java.lang.String r3 = "M1852"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 5
            goto L_0x050c
        L_0x04e2:
            java.lang.String r3 = "M1822"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 6
            goto L_0x050c
        L_0x04ec:
            java.lang.String r3 = "M1816"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 1
            goto L_0x050c
        L_0x04f6:
            java.lang.String r3 = "M1813"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 0
            goto L_0x050c
        L_0x0500:
            java.lang.String r3 = "AR31"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x050b
            r2 = 11
            goto L_0x050c
        L_0x050b:
            r2 = -1
        L_0x050c:
            switch(r2) {
                case 0: goto L_0x054f;
                case 1: goto L_0x054b;
                case 2: goto L_0x0547;
                case 3: goto L_0x0543;
                case 4: goto L_0x053f;
                case 5: goto L_0x053b;
                case 6: goto L_0x0537;
                case 7: goto L_0x0533;
                case 8: goto L_0x052f;
                case 9: goto L_0x052b;
                case 10: goto L_0x0527;
                case 11: goto L_0x0523;
                case 12: goto L_0x051f;
                case 13: goto L_0x051b;
                case 14: goto L_0x0517;
                case 15: goto L_0x0513;
                default: goto L_0x050f;
            }
        L_0x050f:
            m15926a((java.lang.String) r1)
            goto L_0x0556
        L_0x0513:
            com.meizu.media.camera.p065b.M2091.m8481a()
            goto L_0x0556
        L_0x0517:
            com.meizu.media.camera.p065b.M2081.m8480a()
            goto L_0x0556
        L_0x051b:
            com.meizu.media.camera.p065b.M1928.m8510a()
            goto L_0x0556
        L_0x051f:
            com.meizu.media.camera.p065b.M1973.m8512a()
            goto L_0x0556
        L_0x0523:
            com.meizu.media.camera.p065b.AR31.m8479a()
            goto L_0x0556
        L_0x0527:
            com.meizu.media.camera.p065b.M1971.m8511a()
            goto L_0x0556
        L_0x052b:
            com.meizu.media.camera.p065b.M1926.m8509a()
            goto L_0x0556
        L_0x052f:
            com.meizu.media.camera.p065b.M1923.m8508a()
            goto L_0x0556
        L_0x0533:
            com.meizu.media.camera.p065b.M1911.m8507a()
            goto L_0x0556
        L_0x0537:
            com.meizu.media.camera.p065b.M1822.m8498a()
            goto L_0x0556
        L_0x053b:
            com.meizu.media.camera.p065b.M1852.m8500a()
            goto L_0x0556
        L_0x053f:
            com.meizu.media.camera.p065b.M1892.m8506a()
            goto L_0x0556
        L_0x0543:
            com.meizu.media.camera.p065b.M1882.m8504a()
            goto L_0x0556
        L_0x0547:
            com.meizu.media.camera.p065b.M1872.m8502a()
            goto L_0x0556
        L_0x054b:
            com.meizu.media.camera.p065b.M1816.m8497a()
            goto L_0x0556
        L_0x054f:
            com.meizu.media.camera.p065b.M1813.m8496a()
            goto L_0x0556
        L_0x0553:
            m15926a((java.lang.String) r1)
        L_0x0556:
            boolean r1 = com.meizu.media.camera.util.DeviceUtil.m16196a()
            if (r1 == 0) goto L_0x056e
            f13865aR = r0
            com.meizu.media.camera.mode.CameraModeType$ModeType[] r0 = f14006d
            com.meizu.media.camera.mode.CameraModeType$ModeType[] r0 = m15927a((com.meizu.media.camera.mode.CameraModeType.ModeType[]) r0)
            f14006d = r0
            com.meizu.media.camera.mode.CameraModeType$ModeType[] r0 = f14035e
            com.meizu.media.camera.mode.CameraModeType$ModeType[] r0 = m15927a((com.meizu.media.camera.mode.CameraModeType.ModeType[]) r0)
            f14035e = r0
        L_0x056e:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 != r1) goto L_0x0592
            int r0 = m15930d()
            f13870aW = r0
            com.meizu.media.camera.util.ac$a r0 = f13847a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "init Device temperature threshold: "
            r1.append(r2)
            int r2 = f13870aW
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
        L_0x0592:
            m15929c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.DeviceHelper.m15928b():void");
    }

    /* renamed from: a */
    private static void m15926a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, f13900b, true, 7973, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (!"Meizu".equalsIgnoreCase(Build.BRAND)) {
                f13838R = false;
                return;
            }
            throw new IllegalStateException("Your device(" + str + ") is not supported!");
        }
    }

    /* renamed from: a */
    private static String m15925a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13900b, true, 7974, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            Object a = C2634am.m15995a("android.os.SystemProperties", "get", (Class<?>[]) new Class[]{String.class, String.class}, (Object[]) new String[]{"ro.product.device", null});
            if (a != null) {
                return a.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: d */
    private static int m15930d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13900b, true, 7975, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            Object a = C2634am.m15995a("android.os.SystemProperties", "get", (Class<?>[]) new Class[]{String.class, String.class}, (Object[]) new String[]{"persist.meizu.camera.thermal_thresh", null});
            if (a != null) {
                return Integer.parseInt(a.toString());
            }
        } catch (Exception e) {
            LogUtil.C2630a aVar = f13847a;
            LogUtil.m15949b(aVar, "get temperature threshold failed: " + e.getMessage());
        }
        return f13870aW;
    }

    /* renamed from: c */
    public static void m15929c() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f13900b, true, 7976, new Class[0], Void.TYPE).isSupported && f13890aq && f13891ar == FRONT_HDR_HAL_CONFIG.SYSTEM_PROPERTIES) {
            String a = SystemProperties.m562a("ro.vendor.camera.fronthdr.enable", "1");
            LogUtil.C2630a aVar = f13847a;
            LogUtil.m15952c(aVar, "FrontHdrFeature enable:" + a);
            f13890aq = "1".equals(a);
        }
    }
}
