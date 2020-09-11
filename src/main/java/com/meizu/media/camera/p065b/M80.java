package com.meizu.media.camera.p065b;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.p020ar.base.MsgField;
import com.loc.C1108h;
import com.mediatek.camcorder.CamcorderProfileEx;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.b.ac */
public class M80 extends DeviceHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f8000a;

    /* renamed from: a */
    public static void m8482a() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f8000a, true, 3728, new Class[0], Void.TYPE).isSupported) {
            f14006d = new CameraModeType.ModeType[]{CameraModeType.ModeType.AUTO, CameraModeType.ModeType.MANUAL, CameraModeType.ModeType.VIDEO, CameraModeType.ModeType.PANORAMA, CameraModeType.ModeType.SLOWMOTION, CameraModeType.ModeType.BARCODE, CameraModeType.ModeType.TIMELAPSE, CameraModeType.ModeType.FUNNY_SNAP, CameraModeType.ModeType.SQUARE, CameraModeType.ModeType.BACK_TRACE, CameraModeType.ModeType.DOCUMENT, CameraModeType.ModeType.SUPER_NIGHT, CameraModeType.ModeType.AMAZINGAR};
            f14035e = new CameraModeType.ModeType[]{CameraModeType.ModeType.MANUAL, CameraModeType.ModeType.FUNNY_SNAP, CameraModeType.ModeType.AUTO, CameraModeType.ModeType.VIDEO};
            f14037g = DeviceHelper.SHUTTER_SPEED.SP20S;
            f14038h = DeviceHelper.SLOW_MOTION_FPS.SMF_120;
            f14036f = DeviceHelper.CUSTOM_DEVICE_MARK.STANDER;
            f14039i = true;
            f14040j = true;
            f14041k = true;
            f14042l = false;
            f14043m = false;
            f14044n = -1;
            f13838R = true;
            f13839S = true;
            f13840T = false;
            f13841U = false;
            f13843W = true;
            f13844X = false;
            f13845Y = 1500;
            f13842V = 0;
            f13846Z = false;
            f13874aa = false;
            f13877ad = false;
            f13875ab = false;
            f13876ac = false;
            f13878ae = true;
            f13879af = false;
            f13880ag = false;
            f13881ah = false;
            f13882ai = false;
            f13883aj = false;
            f13884ak = false;
            f13885al = false;
            f13886am = false;
            f13887an = true;
            f13889ap = true;
            f13890aq = false;
            f13891ar = DeviceHelper.FRONT_HDR_HAL_CONFIG.NONE;
            f13892as = false;
            f13893at = true;
            f13894au = false;
            f13895av = false;
            f13896aw = false;
            f13897ax = true;
            f13898ay = false;
            f13899az = true;
            f13848aA = false;
            f13849aB = true;
            f13850aC = false;
            f13851aD = false;
            f13852aE = false;
            f13853aF = false;
            f13854aG = true;
            f13855aH = false;
            f13856aI = false;
            f13857aJ = false;
            f13858aK = DeviceHelper.STEREO_TYPE.TYPE_NONE;
            f13859aL = false;
            f13860aM = true;
            f13861aN = false;
            f13862aO = false;
            f13863aP = false;
            f13864aQ = false;
            f13865aR = true;
            f13866aS = false;
            f13867aT = false;
            f13868aU = false;
            f13869aV = false;
            f13871aX = true;
            f13872aY = false;
            f13873aZ = false;
            f13927ba = false;
            f13931be = new int[]{114, 132, Opcodes.DCMPL, 174};
            f13932bf = new int[]{174, Opcodes.DCMPL, 132, 114};
            f13933bg = new int[]{MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 229, 251, 276, 289, 296};
            f13934bh = new int[]{289, 257, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, Opcodes.LCMP, 120, 104};
            f13935bi = false;
            f13936bj = false;
            f13937bk = DeviceHelper.EXPOSURE_STEP.STEP_POINT_ONE;
            f13938bl = 1;
            f13939bm = 2;
            f13940bn = 30;
            f13941bo = false;
            f13942bp = false;
            f13943bq = 2;
            f13944br = false;
            f13945bs = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            f13946bt = 1741;
            f13947bu = 0;
            f13948bv = 0;
            f13949bw = 2;
            f13952bz = 0;
            f13901bA = 0;
            f13902bB = false;
            f13903bC = false;
            f13904bD = false;
            f13905bE = false;
            f13906bF = false;
            f13907bG = false;
            f13908bH = true;
            f13909bI = false;
            f13910bJ = CameraController.CameraApi.API1;
            f13911bK = 0;
            f13912bL = 0;
            f13913bM = 0;
            f13914bN = 0;
            f13915bO = 0;
            f13916bP = 0;
            f13917bQ = 0;
            f13918bR = 5312;
            f13919bS = 2656;
            f13920bT = 1992;
            f13921bU = 2656;
            f13922bV = 1494;
            f13981cb = -1;
            f13982cc = -1;
            f13983cd = -1;
            f13984ce = -1;
            f13985cf = -1;
            f13986cg = -1;
            f13987ch = -1;
            f13988ci = -1;
            f13989cj = -1;
            f13990ck = -1;
            f13991cl = -1;
            f13992cm = -1;
            f13993cn = -1;
            f13994co = -1;
            f13995cp = -1;
            f13996cq = -1;
            f13997cr = -1;
            f13998cs = -1;
            f13999ct = -1;
            f14000cu = -1;
            f14001cv = -1;
            f14002cw = -1;
            f13926bZ = 3200;
            f13980ca = MsgField.MSG_PADDLE_INIT;
            f14003cx = -1;
            f14004cy = 123;
            f14005cz = -1;
            f13954cA = CamcorderProfileEx.SLOW_MOTION_HD_120FPS;
            f13955cB = -1;
            f13956cC = -1;
            f13957cD = 24;
            f13958cE = new int[]{20, 25, 5, 10, 20, 5, 15, 15};
            f13959cF = new int[]{30, 40, 10, 15, 25, 10, 20, 20};
            f13960cG = new int[]{45, 50, 18, 23, 32, 15, 33, 30};
            f13961cH = new int[]{53, 55, 25, 30, 40, 20, 40, 33};
            f13962cI = new int[]{60, 60, 30, 35, 50, 30, 50, 40};
            f13963cJ = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            f13964cK = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            f13966cM = new int[]{0, 0, 0, 0, 0, 0};
            f13967cN = new int[]{40, 35, 10, 15, 0, 0};
            f13968cO = new int[]{50, 45, 13, 18, 0, 0};
            f13969cP = new int[]{65, 65, 18, 20, 0, 0};
            f13970cQ = new int[]{75, 70, 25, 25, 0, 0};
            f13971cR = new int[]{85, 80, 30, 30, 0, 0};
            f13979cZ = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.ENGLISH);
            f14009da = 0;
            f14010db = 0;
            f14011dc = null;
            f14012dd = null;
            f14013de = 0;
            f14014df = 0;
            f14015dg = 0;
            f14016dh = 0;
            f14017di = -1;
            f14018dj = DeviceHelper.EIS_TYPE.STANDARD;
            f14019dk = DeviceHelper.EIS_SUPPORT_SCENE.NONE;
            f14020dl = null;
            f14021dm = false;
            f14022dn = new float[][]{new float[]{-2.0f, -1.5f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 2.0f}, new float[]{-1.5f, -1.0f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}};
            f14023do = new int[]{3, 0, 10, 3, 0, 13};
            f14024dp = 0;
            f14025dq = false;
            f14029du = -1;
            f14030dv = -1;
            f14031dw = false;
            f14032dx = false;
            f14033dy = false;
            f14034dz = false;
            f14007dA = false;
            f14008dB = "m80";
            if (DeviceUtil.m16190a("ro.product.mobile.name", C1108h.f3354h).equals("m80s")) {
                f13919bS = MsgField.IMSG_SAVE_PICTURE;
                f13920bT = 1504;
                f13921bU = 2560;
                f13922bV = 1440;
                f14041k = false;
                f13854aG = false;
                f13878ae = false;
                f13899az = false;
                f14022dn = new float[][]{new float[]{-2.0f, -1.5f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 2.0f}, new float[]{-1.5f, -1.0f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}};
                f14027ds = false;
                f14028dt = false;
                f14026dr = false;
                f14021dm = true;
            }
        }
    }
}
