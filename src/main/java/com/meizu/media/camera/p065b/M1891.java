package com.meizu.media.camera.p065b;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.base.MsgField;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.b.s */
public class M1891 extends DeviceHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f8023a;

    /* renamed from: a */
    public static void m8505a() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f8023a, true, 3718, new Class[0], Void.TYPE).isSupported) {
            f14006d = new CameraModeType.ModeType[]{CameraModeType.ModeType.AUTO, CameraModeType.ModeType.MANUAL, CameraModeType.ModeType.PORTRAIT, CameraModeType.ModeType.VIDEO, CameraModeType.ModeType.PANORAMA, CameraModeType.ModeType.SLOWMOTION, CameraModeType.ModeType.BARCODE, CameraModeType.ModeType.TIMELAPSE, CameraModeType.ModeType.FUNNY_SNAP, CameraModeType.ModeType.SQUARE, CameraModeType.ModeType.BACK_TRACE, CameraModeType.ModeType.DOCUMENT, CameraModeType.ModeType.SUPER_NIGHT, CameraModeType.ModeType.AMAZINGAR};
            f14035e = new CameraModeType.ModeType[]{CameraModeType.ModeType.FUNNY_SNAP, CameraModeType.ModeType.PORTRAIT, CameraModeType.ModeType.AUTO, CameraModeType.ModeType.VIDEO};
            f14037g = DeviceHelper.SHUTTER_SPEED.SP20S;
            f14038h = DeviceHelper.SLOW_MOTION_FPS.SMF_100;
            f14036f = DeviceHelper.CUSTOM_DEVICE_MARK.STANDER;
            f14039i = false;
            f14040j = false;
            f14041k = true;
            f14042l = false;
            f14043m = true;
            f14044n = -1;
            f13826F = true;
            f13838R = true;
            f13839S = false;
            f13840T = false;
            f13841U = true;
            f13843W = true;
            f13844X = false;
            f13845Y = 1500;
            f13842V = 65;
            f13846Z = false;
            f13874aa = false;
            f13877ad = false;
            f13875ab = false;
            f13876ac = true;
            f13878ae = false;
            f13879af = true;
            f13880ag = false;
            f13881ah = false;
            f13882ai = false;
            f13883aj = false;
            f13884ak = true;
            f13885al = false;
            f13886am = false;
            f13887an = true;
            f13889ap = true;
            f13890aq = false;
            f13891ar = DeviceHelper.FRONT_HDR_HAL_CONFIG.NONE;
            f13892as = false;
            f13893at = true;
            f13894au = true;
            f13895av = false;
            f13896aw = false;
            f13897ax = false;
            f13898ay = false;
            f13899az = true;
            f13848aA = false;
            f13849aB = false;
            f13850aC = true;
            f13851aD = true;
            f13852aE = false;
            f13853aF = true;
            f13854aG = true;
            f13855aH = false;
            f13856aI = true;
            f13857aJ = false;
            f13858aK = DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_GALLERY;
            f13859aL = false;
            f13860aM = true;
            f13861aN = false;
            f13862aO = true;
            f13863aP = false;
            f13864aQ = true;
            f13865aR = true;
            f13866aS = false;
            f13867aT = false;
            f13868aU = true;
            f13869aV = false;
            f13871aX = false;
            f13872aY = false;
            f13873aZ = false;
            f13927ba = true;
            f13931be = new int[]{106, 125, Opcodes.IF_ACMPEQ, 172, Opcodes.NEW, 195};
            f13932bf = new int[]{195, 174, 144, 120, 107, 102};
            f13933bg = new int[]{MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 226, 246, 274, 291, 298};
            f13934bh = new int[]{285, 236, 180, 139, 115, 104};
            f13935bi = false;
            f13936bj = false;
            f13937bk = DeviceHelper.EXPOSURE_STEP.STANDARD;
            f13938bl = 1;
            f13939bm = 2;
            f13940bn = 30;
            f13941bo = true;
            f13942bp = true;
            f13943bq = 1;
            f13944br = false;
            f13945bs = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            f13946bt = 1650;
            f13947bu = 0;
            f13948bv = 0;
            f13949bw = 2;
            f13952bz = 3872;
            f13901bA = 5168;
            f13902bB = true;
            f13903bC = false;
            f13904bD = true;
            f13905bE = true;
            f13906bF = false;
            f13907bG = false;
            f13908bH = true;
            f13909bI = false;
            f13910bJ = CameraController.CameraApi.API1;
            f13911bK = 3;
            f13912bL = 3;
            f13913bM = 0;
            f13914bN = 0;
            f13915bO = 19450672;
            f13916bP = 0;
            f13917bQ = 0;
            f13918bR = -1;
            f13919bS = MsgField.IMSG_SAVE_PICTURE;
            f13920bT = 1504;
            f13921bU = MsgField.IMSG_SAVE_PICTURE;
            f13922bV = 1126;
            f13925bY = 6;
            f13981cb = 60;
            f13982cc = 2;
            f13983cd = 5;
            f13984ce = 36000000;
            f13985cf = 30;
            f13986cg = 3840;
            f13987ch = 2160;
            f13988ci = 3;
            f13989cj = 96000;
            f13990ck = AudioParams.DEFAULT_SAMPLE_RATE;
            f13991cl = 1;
            f13992cm = 60;
            f13993cn = 2;
            f13994co = 2;
            f13995cp = 18000000;
            f13996cq = 120;
            f13997cr = 1280;
            f13998cs = 720;
            f13999ct = -1;
            f14000cu = -1;
            f14001cv = -1;
            f14002cw = -1;
            f13926bZ = 3200;
            f13980ca = MsgField.MSG_PADDLE_INIT;
            f14003cx = -1;
            f14004cy = 23;
            f14005cz = -1;
            f13954cA = 21;
            f13955cB = -1;
            f13956cC = -1;
            f13957cD = 24;
            f13958cE = new int[]{18, 20, 10, 15, 1, 0, 10, 12};
            f13959cF = new int[]{20, 25, 13, 15, 1, 0, 10, 15};
            f13960cG = new int[]{25, 30, 15, 15, 2, 0, 15, 18};
            f13961cH = new int[]{30, 35, 20, 20, 3, 0, 15, 25};
            f13962cI = new int[]{35, 40, 25, 25, 3, 0, 20, 30};
            f13963cJ = new int[]{25, -1, 20, 15, 0, 25, 100, 80, 0, 0, 10, 0, 30, 50};
            f13964cK = new int[]{40, -1, 20, 15, 0, 30, 100, 80, 0, 0, 25, 25, 40, 50};
            f13966cM = new int[]{0, 0, 0, 0, 0, 0};
            f13967cN = new int[]{20, 0, 15, 25, 10, 50};
            f13968cO = new int[]{20, 35, 13, 15, 0, 0};
            f13969cP = new int[]{30, 45, 15, 15, 0, 0};
            f13970cQ = new int[]{36, 55, 18, 20, 0, 0};
            f13971cR = new int[]{40, 0, 15, 25, 20, 50};
            f13979cZ = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.ENGLISH);
            f14009da = 0;
            f14010db = 0;
            f14011dc = "3264x2448";
            f14012dd = null;
            f14013de = 0;
            f14014df = 0;
            f14015dg = 0;
            f14016dh = 0;
            f14017di = -1;
            f14018dj = DeviceHelper.EIS_TYPE.STANDARD;
            f14019dk = DeviceHelper.EIS_SUPPORT_SCENE.NONE;
            f14020dl = null;
            f14021dm = true;
            f14022dn = new float[][]{new float[]{-20.0f, -15.0f, -10.0f, -5.0f, 0.0f, 0.0f, 0.0f, 0.0f}, new float[]{-15.0f, -10.0f, -5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}};
            f14023do = new int[]{3, 0, 10, 3, 0, 13};
            f14024dp = 0;
            f14025dq = false;
            f14029du = -1;
            f14027ds = false;
            f14028dt = false;
            f14026dr = false;
            f14030dv = -1;
            f14031dw = false;
            f14032dx = false;
            f14033dy = false;
            f14034dz = false;
            f14007dA = false;
            f14008dB = "M1891";
        }
    }
}
