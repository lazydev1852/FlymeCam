package com.meizu.media.camera.mode;

import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class CameraModeType {

    /* renamed from: a */
    public static ChangeQuickRedirect f10556a = null;

    /* renamed from: b */
    public static final ModeType[] f10557b;

    /* renamed from: c */
    public static final ModeType[] f10558c = DeviceHelper.f14035e;

    /* renamed from: d */
    public static final ModeType[] f10559d = {ModeType.AUTO, ModeType.VIDEO, ModeType.FUNNY_SNAP, ModeType.BACK_LIGHTING};

    /* renamed from: e */
    public static final ModeType[] f10560e = {ModeType.AUTO};

    /* renamed from: f */
    private static boolean f10561f = false;

    /* renamed from: g */
    private static boolean f10562g = false;

    /* renamed from: h */
    private static ModeType f10563h = ModeType.AUTO;

    /* renamed from: i */
    private static ModeType f10564i = ModeType.AUTO;

    /* renamed from: j */
    private static ModeType f10565j;

    /* renamed from: k */
    private static final ModeType[] f10566k = {ModeType.AUTO, ModeType.MANUAL, ModeType.VIDEO, ModeType.GIF};

    static {
        if (ApiHelper.f14210k) {
            f10557b = f10566k;
        } else {
            f10557b = DeviceHelper.f14006d;
        }
    }

    public enum ModeType {
        AUTO(R.drawable.mz_mode_auto, R.drawable.mz_mode_auto, R.drawable.mz_mode_auto_disable_move, R.string.mz_cam_mode_auto, 2, 0, new int[0]),
        MANUAL(R.drawable.mz_mode_manual, R.drawable.mz_mode_manual_pressed, R.drawable.mz_mode_manual_disable_move, R.string.mz_cam_mode_manual, -91, 1, new int[0]),
        PORTRAIT(R.drawable.mz_mode_portrait, R.drawable.mz_mode_portrait, R.drawable.mz_mode_portrait_disable_move, DeviceHelper.f13953c, 1, 3, new int[0]),
        MAKEUP(R.drawable.mz_mode_makeup, R.drawable.mz_mode_makeup_pressed, -1, R.string.mz_cam_mode_makeup, -10001, 4, new int[0]),
        PANORAMA(R.drawable.mz_mode_pano, R.drawable.mz_mode_pano_pressed, R.drawable.mz_mode_pano_disable_move, R.string.mz_cam_mode_pano, -102, 5, new int[0]),
        REFOCUS(R.drawable.mz_mode_refocus, R.drawable.mz_mode_refocus_pressed, -1, R.string.mz_cam_mode_refocus, -10002, 6, new int[0]),
        VIDEO(R.drawable.mz_mode_video, R.drawable.mz_mode_video, R.drawable.mz_mode_video_disable_move, R.string.video_camera_label, 3, 7, new int[0]),
        BARCODE(R.drawable.mz_mode_barcode, R.drawable.mz_mode_barcode_pressed, R.drawable.mz_mode_barcode_disable_move, R.string.mz_cam_mode_bar_code, -103, 8, new int[0]),
        SLOWMOTION(R.drawable.mz_mode_slow_motion, R.drawable.mz_mode_slow_motion_pressed, R.drawable.mz_mode_slow_motion_disable_move, R.string.mz_cam_mode_slowmotion, -108, 10, new int[0]),
        MACRO(R.drawable.mz_mode_macro, R.drawable.mz_mode_macro_pressed, R.drawable.mz_mode_macro_disable_move, R.string.mz_cam_mode_macro, -95, 11, new int[0]),
        GIF(R.drawable.mz_mode_gif, R.drawable.mz_mode_gif_pressed, -1, R.string.mz_cam_mode_gif, -10004, 12, new int[0]),
        TIMELAPSE(R.drawable.mz_mode_timelapse, R.drawable.mz_mode_timelapse_pressed, R.drawable.mz_mode_timelapse_disable_move, R.string.mz_cam_mode_timelapse, -106, 13, new int[0]),
        BLACK_WHITE(R.drawable.mz_mode_white_black, R.drawable.mz_mode_white_black_pressed, R.drawable.mz_mode_white_black_disable_move, R.string.mz_cam_mode_white_black, -107, 18, new int[0]),
        FUNNY_SNAP(R.drawable.funny_snap, R.drawable.funny_snap_pressed, R.drawable.funny_snap_disable_move, R.string.mz_cam_mode_funny_snap, -110, 19, new int[0]),
        AR(R.drawable.funny_snap, R.drawable.funny_snap_pressed, -1, R.string.mz_cam_mode_ar, -110, 22, new int[0]),
        SQUARE(R.drawable.mz_mode_square, R.drawable.mz_mode_square_pressed, R.drawable.mz_mode_square_disable_move, R.string.mz_cam_mode_square, -109, 20, new int[0]),
        BACK_TRACE(R.drawable.mz_mode_backtrace, R.drawable.mz_mode_backtrace_pressed, R.drawable.mz_mode_backtrace_disable_move, R.string.mz_cam_mode_back_trace, -109, 21, new int[0]),
        SUPER_NIGHT(R.drawable.mz_mode_supernight, R.drawable.mz_mode_supernight_pressed, R.drawable.mz_mode_supernight_disable_move, R.string.mz_cam_mode_super_night, -112, 22, new int[0]),
        DOCUMENT(R.drawable.mz_mode_doc, R.drawable.mz_mode_doc_pressed, R.drawable.mz_mode_doc_disable_move, R.string.mz_cam_mode_document, -104, 23, new int[0]),
        AMAZINGAR(R.drawable.mz_mode_amazingar, R.drawable.mz_mode_amazingar, R.drawable.mz_mode_amazingar_disable_move, R.string.mz_cam_mode_amazing, -105, 24, R.drawable.mz_mode_amazingar_dl, R.drawable.mz_mode_amazingar_dl_disable_move),
        BACK_LIGHTING(R.drawable.mz_mode_back_lighting, R.drawable.mz_mode_back_lighting_pressed, R.drawable.mz_mode_back_lighting_disable_move, R.string.mz_cam_mode_back_lighting, -111, 25, new int[0]),
        TOF(R.drawable.mz_mode_portrait, R.drawable.mz_mode_portrait, R.drawable.mz_mode_portrait_disable_move, DeviceHelper.f13953c, -113, 26, new int[0]),
        NightVision(R.drawable.mz_mode_nightvision, R.drawable.mz_mode_nightvision_pressed, R.drawable.mz_mode_nightvision_disable_move, R.string.mz_cam_mode_night_vision, -115, 27, new int[0]);
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private int groupId;
        private int groupTextId;
        private int guideBgId;
        private int guideCardId;
        private int iconDisableId;
        private int iconDownloadDisableId;
        private int iconDownloadId;
        private int iconNormalId;
        private int iconPressedId;
        private int sortDeterminer;
        private int txtId;

        private ModeType(int i, int i2, int i3, int i4, int i5, int i6, int... iArr) {
            this.groupTextId = -1;
            this.guideCardId = -1;
            this.guideBgId = -1;
            this.iconNormalId = i;
            this.iconPressedId = i2;
            this.iconDisableId = i3;
            this.txtId = i4;
            this.sortDeterminer = i5;
            this.groupId = i6;
            if (iArr != null && iArr.length > 2) {
                this.groupTextId = iArr[0];
                this.guideCardId = iArr[1];
                this.guideBgId = iArr[2];
            } else if (iArr != null && iArr.length == 2) {
                this.iconDownloadId = iArr[0];
                this.iconDownloadDisableId = iArr[1];
            }
        }

        public int getIconNormalId() {
            return this.iconNormalId;
        }

        public int getIconPressedId() {
            return this.iconPressedId;
        }

        public int getIconDisableId() {
            return this.iconDisableId;
        }

        public int getTxtId() {
            return this.txtId;
        }

        public int getGroupId() {
            return this.groupId;
        }

        public int getGroupTextId() {
            return this.groupTextId;
        }

        public int getGuideCardId() {
            return this.guideCardId;
        }

        public int getGuideBgId() {
            return this.guideBgId;
        }

        public int getSortDeterminer() {
            return this.sortDeterminer;
        }

        public void setSortDeterminer(int i) {
            this.sortDeterminer = i;
        }

        public int getIconDownloadId() {
            return this.iconDownloadId;
        }

        public int getIconDisableDownloadId() {
            return this.iconDownloadDisableId;
        }
    }

    /* renamed from: a */
    public static boolean m10950a(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4696, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return (modeType.getGuideCardId() == -1 || modeType.getGuideBgId() == -1) ? false : true;
    }

    /* renamed from: a */
    public static void m10948a(boolean z) {
        f10561f = z;
    }

    /* renamed from: b */
    public static void m10953b(boolean z) {
        f10562g = z;
    }

    /* renamed from: a */
    public static ModeType m10946a() {
        return f10561f ? f10564i : f10563h;
    }

    /* renamed from: b */
    public static void m10952b(ModeType modeType) {
        if (f10561f) {
            f10564i = modeType;
        } else {
            f10563h = modeType;
        }
    }

    /* renamed from: c */
    public static boolean m10957c(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4697, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!m10986o(m10962e(modeType)) && modeType.getSortDeterminer() >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static void m10959d(ModeType modeType) {
        f10565j = modeType;
    }

    /* renamed from: a */
    public static void m10947a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10556a;
        if (PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 4698, new Class[]{Integer.TYPE}, Void.TYPE).isSupported || m10986o(i)) {
            return;
        }
        if (f10561f) {
            f10564i = f10557b[i];
        } else {
            f10563h = f10557b[i];
        }
    }

    /* renamed from: e */
    public static int m10962e(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4699, new Class[]{ModeType.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        for (int i = 0; i < f10557b.length; i++) {
            if (f10557b[i].equals(modeType)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m10951b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10556a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 4700, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!m10986o(i)) {
            return f10557b[i].ordinal();
        }
        return -1;
    }

    /* renamed from: f */
    public static boolean m10967f(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4701, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (ModeType equals : f10559d) {
            if (equals.equals(modeType)) {
                return true;
            }
        }
        if (modeType.equals(ModeType.PORTRAIT) && DeviceHelper.f13855aH) {
            return true;
        }
        if (!modeType.equals(ModeType.SUPER_NIGHT) || !DeviceHelper.f14025dq) {
            return modeType.equals(ModeType.TOF) && DeviceHelper.f13855aH;
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m10970g(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4702, new Class[]{ModeType.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : ModeType.BLACK_WHITE.equals(modeType);
    }

    /* renamed from: h */
    public static boolean m10973h(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4703, new Class[]{ModeType.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : ModeType.PORTRAIT.equals(modeType);
    }

    /* renamed from: c */
    public static boolean m10956c(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4704, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return m10962e(f10561f ? f10564i : f10563h) != i;
    }

    /* renamed from: a */
    public static boolean m10949a(int i, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, (Object) null, f10556a, true, 4705, new Class[]{Integer.TYPE, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return modeType.equals(ModeType.BARCODE) || modeType.equals(ModeType.SLOWMOTION) || modeType.equals(ModeType.VIDEO) || modeType.equals(ModeType.GIF) || modeType.equals(ModeType.AR) || (modeType.equals(ModeType.FUNNY_SNAP) && !z);
    }

    /* renamed from: d */
    public static boolean m10961d(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4706, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return !modeType.equals(ModeType.BARCODE) && !modeType.equals(ModeType.PANORAMA) && !modeType.equals(ModeType.REFOCUS) && !modeType.equals(ModeType.GIF) && !modeType.equals(ModeType.TIMELAPSE) && !modeType.equals(ModeType.FUNNY_SNAP) && !modeType.equals(ModeType.NightVision);
    }

    /* renamed from: e */
    public static boolean m10964e(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4707, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return !modeType.equals(ModeType.BARCODE) && !modeType.equals(ModeType.PANORAMA) && !modeType.equals(ModeType.REFOCUS) && !modeType.equals(ModeType.GIF) && !modeType.equals(ModeType.FUNNY_SNAP) && !modeType.equals(ModeType.AR) && !modeType.equals(ModeType.NightVision);
    }

    /* renamed from: f */
    public static boolean m10966f(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4709, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.MANUAL) || modeType.equals(ModeType.MACRO) || modeType.equals(ModeType.MAKEUP) || modeType.equals(ModeType.BLACK_WHITE) || modeType.equals(ModeType.PORTRAIT) || modeType.equals(ModeType.SQUARE) || modeType.equals(ModeType.BACK_TRACE) || modeType.equals(ModeType.DOCUMENT) || modeType.equals(ModeType.SUPER_NIGHT) || modeType.equals(ModeType.BACK_LIGHTING) || modeType.equals(ModeType.TOF);
    }

    /* renamed from: g */
    public static boolean m10969g(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4710, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return !modeType.equals(ModeType.MANUAL) && !modeType.equals(ModeType.GIF) && !modeType.equals(ModeType.MAKEUP) && !modeType.equals(ModeType.SQUARE);
    }

    /* renamed from: i */
    public static boolean m10975i(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4711, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return !modeType.equals(ModeType.REFOCUS) && !modeType.equals(ModeType.SLOWMOTION) && !modeType.equals(ModeType.VIDEO) && !modeType.equals(ModeType.PANORAMA) && !modeType.equals(ModeType.BARCODE) && !modeType.equals(ModeType.FUNNY_SNAP) && !modeType.equals(ModeType.BACK_TRACE) && !modeType.equals(ModeType.GIF);
    }

    /* renamed from: j */
    public static boolean m10977j(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4712, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.MAKEUP) || modeType.equals(ModeType.MANUAL) || modeType.equals(ModeType.BLACK_WHITE) || modeType.equals(ModeType.PORTRAIT) || modeType.equals(ModeType.MACRO) || modeType.equals(ModeType.SUPER_NIGHT) || modeType.equals(ModeType.BACK_LIGHTING) || modeType.equals(ModeType.TOF);
    }

    /* renamed from: h */
    public static boolean m10972h(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4713, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.MACRO) || modeType.equals(ModeType.SQUARE);
    }

    /* renamed from: i */
    public static boolean m10974i(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4714, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        LogUtil.C2630a aVar = LogUtil.f14072b;
        LogUtil.m15942a(aVar, "isModeSupportNightScene modeIndex:" + i);
        ModeType modeType = f10557b[i];
        return modeType.equals(ModeType.AUTO) || (modeType.equals(ModeType.SQUARE) && DeviceHelper.f13910bJ == CameraController.CameraApi.API2);
    }

    /* renamed from: b */
    public static boolean m10954b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4715, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : m10946a().equals(ModeType.PORTRAIT);
    }

    /* renamed from: j */
    public static boolean m10976j(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4716, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = LogUtil.f14072b;
        LogUtil.m15942a(aVar, "isModeSupportHighPicSize index:" + i);
        return !m10986o(i) && f10557b[i].equals(ModeType.MANUAL);
    }

    /* renamed from: k */
    public static boolean m10979k(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4718, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return modeType.equals(ModeType.AUTO) || (DeviceHelper.f13848aA && modeType.equals(ModeType.SQUARE)) || modeType.equals(ModeType.DOCUMENT) || modeType.equals(ModeType.MACRO);
    }

    /* renamed from: k */
    public static boolean m10978k(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4719, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        if (modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.VIDEO) || modeType.equals(ModeType.FUNNY_SNAP) || modeType.equals(ModeType.BACK_TRACE) || (modeType.equals(ModeType.SUPER_NIGHT) && DeviceHelper.f14025dq)) {
            return true;
        }
        if (!modeType.equals(ModeType.PORTRAIT) || !DeviceHelper.f13855aH) {
            return modeType.equals(ModeType.TOF) && DeviceHelper.f13855aH;
        }
        return true;
    }

    /* renamed from: l */
    public static boolean m10980l(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4720, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return (modeType.equals(ModeType.MANUAL) || modeType.equals(ModeType.SLOWMOTION) || modeType.equals(ModeType.GIF) || modeType.equals(ModeType.TIMELAPSE) || modeType.equals(ModeType.BLACK_WHITE) || modeType.equals(ModeType.MAKEUP) || modeType.equals(ModeType.SQUARE) || modeType.equals(ModeType.PANORAMA) || modeType.equals(ModeType.MACRO) || modeType.equals(ModeType.DOCUMENT) || ((modeType.equals(ModeType.SUPER_NIGHT) && !DeviceHelper.f14025dq) || modeType.equals(ModeType.BACK_LIGHTING))) && !m10957c(modeType);
    }

    /* renamed from: c */
    public static boolean m10955c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4721, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        if (modeType.equals(ModeType.VIDEO) || modeType.equals(ModeType.SLOWMOTION) || modeType.equals(ModeType.TIMELAPSE)) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public static boolean m10981l(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4722, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (modeType == null) {
            return false;
        }
        return modeType.equals(ModeType.VIDEO) || modeType.equals(ModeType.SLOWMOTION) || modeType.equals(ModeType.TIMELAPSE);
    }

    /* renamed from: m */
    public static boolean m10983m(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4723, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (f10561f) {
            return f10564i.equals(modeType);
        }
        return f10563h.equals(modeType);
    }

    /* renamed from: d */
    public static boolean m10960d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4724, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        if (modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.PORTRAIT) || modeType.equals(ModeType.FUNNY_SNAP) || modeType.equals(ModeType.TOF)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m10958c(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, (Object) null, f10556a, true, 4725, new Class[]{Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        return modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.MAKEUP) || modeType.equals(ModeType.PORTRAIT) || modeType.equals(ModeType.MANUAL) || modeType.equals(ModeType.SQUARE) || modeType.equals(ModeType.BACK_TRACE) || (modeType.equals(ModeType.VIDEO) && z && DeviceHelper.f13864aQ) || ((modeType.equals(ModeType.FUNNY_SNAP) && DeviceHelper.f13942bp) || modeType.equals(ModeType.SUPER_NIGHT) || modeType.equals(ModeType.BACK_LIGHTING) || modeType.equals(ModeType.TOF));
    }

    /* renamed from: e */
    public static boolean m10963e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4726, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        if (modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.TIMELAPSE) || modeType.equals(ModeType.MANUAL) || modeType.equals(ModeType.SQUARE) || modeType.equals(ModeType.VIDEO) || (modeType.equals(ModeType.SUPER_NIGHT) && DeviceHelper.f14026dr)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m10965f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4727, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ((f10561f ? f10564i : f10563h).getSortDeterminer() >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    private static boolean m10986o(int i) {
        return i >= f10557b.length || i < 0;
    }

    /* renamed from: n */
    public static boolean m10985n(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4728, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (ModeType equals : f10557b) {
            if (equals.equals(modeType)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public static boolean m10982m(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4729, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.SQUARE);
    }

    /* renamed from: n */
    public static boolean m10984n(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f10556a, true, 4730, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m10986o(i)) {
            return false;
        }
        ModeType modeType = f10557b[i];
        return !modeType.equals(ModeType.VIDEO) && !modeType.equals(ModeType.SLOWMOTION) && !modeType.equals(ModeType.TIMELAPSE) && !modeType.equals(ModeType.PANORAMA);
    }

    /* renamed from: g */
    public static boolean m10968g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4731, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        if (modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.SQUARE) || modeType.equals(ModeType.MACRO) || (modeType.equals(ModeType.VIDEO) && DeviceHelper.f13910bJ == CameraController.CameraApi.API2)) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m10971h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f10556a, true, 4732, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ModeType modeType = f10561f ? f10564i : f10563h;
        if (modeType.equals(ModeType.AUTO) || modeType.equals(ModeType.FUNNY_SNAP)) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public static boolean m10987o(ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, (Object) null, f10556a, true, 4733, new Class[]{ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return (ModeType.VIDEO.equals(modeType) || ModeType.SLOWMOTION.equals(modeType) || ModeType.TIMELAPSE.equals(modeType) || ModeType.NightVision.equals(modeType)) && DeviceHelper.f13910bJ == CameraController.CameraApi.API2;
    }
}
