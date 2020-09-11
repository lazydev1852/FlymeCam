package com.meizu.media.camera.util;

import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public interface Contants {

    public interface CameraService {

        public enum Action {
            ACTION_RESUME_CAMERA,
            ACTION_OPEN_CAMERA,
            ACTION_SWITCH_CAMERA,
            ACTION_CLOSE_CAMERA,
            ACTION_STRONG_RELEASE_CAMERA,
            ACTION_START_PREVIEW,
            ACTION_STOP_PREVIEW,
            ACTION_RESTART_PREVIEW,
            ACTION_START_FACE_DETECTION,
            ACTION_STOP_FACE_DETECTION,
            ACTION_TAKE_PICTURE,
            ACTION_TAKE_STEREO_PICTURE,
            ACTION_TAKE_BURST_PICTURE,
            ACTION_STOP_BURST,
            ACTION_AUTO_FOCUS,
            ACTION_CANCEL_AUTO_FOCUS,
            ACTION_TAKE_SUPER_NIGHT_PICTURE,
            ACTION_TAKE_TOF_PICTURE;
            
            public static ChangeQuickRedirect changeQuickRedirect;
        }

        public enum RequestCode {
            REQUEST_CODE_RESUME_CAMERA,
            REQUEST_CODE_START_PREVIEW,
            REQUEST_CODE_STOP_PREVIEW,
            REQUEST_CODE_CLOSE_CAMERA,
            REQUEST_CODE_STRONG_RELEASE_CAMERA,
            REQUEST_CODE_RESTART_PREVIEW,
            REQUEST_CODE_RESTART_BACKTRACE_PREVIEW,
            REQUEST_CODE_START_FACE_DETECTION,
            REQUEST_CODE_TAKE_PICTURE,
            REQUEST_CODE_RESTART_CAMERA,
            REQUEST_CODE_SWITCH_CAMERA,
            REQUEST_CODE_SET_PREVIEW_TEXTURE,
            REQUEST_CODE_STOP_FACE_DETECTION,
            REQUEST_CODE_TAKE_BURST_PICTURE,
            REQUEST_CODE_STOP_BURST,
            REQUEST_CODE_TAKE_STEREO_PICTURE,
            REQUEST_CODE_TAKE_HDR_PICTURE,
            REQUEST_CODE_TAKE_MFLL_PICTURE,
            REQUEST_CODE_TAKE_HDR_AND_MFLL_PICTURE,
            REQUEST_CODE_AUTO_FOCUS,
            REQUEST_CODE_CANCEL_AUTO_FOCUS,
            REQUEST_CODE_RESTART_PREVIEW_FOR_MODE_CHANGE,
            REQUEST_CODE_TAKE_BACKTRACE_PICTURE,
            REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE,
            REQUEST_CODE_TAKE_TOF_PICTURE;
            
            public static ChangeQuickRedirect changeQuickRedirect;
        }

        public enum ResultCode {
            RESULT_OK,
            RESULT_NULL_CAMERA,
            RESULT_CAMERA_DISABLED,
            RESULT_OPEN_CAMERA_FAILURE,
            RESULT_RECONNECTION_FAILURE,
            RESULT_FACE_DETECTION_STOPED,
            REQUEST_CODE_TAKE_PICTURE_START,
            RESULT_SHUTTER_CALLBACK,
            RESULT_TOF_SHUTTER_CALLBACK,
            RESULT_ON_PICTURE_TOKEN_CALLBACK,
            RESULT_MEMORY_QUEUE_CHANGED,
            RESULT_ERROR,
            RESULT_ON_GET_THUMBNAIL,
            RESULT_ON_FILE_SAVED,
            RESULT_ON_MEDIA_SAVED,
            RESULT_CREATE_PICTURE_THUMBNAIL,
            RESULT_ON_IMAGE_CAPTURE_INTENT_DONE,
            RESULT_FAST_STEREO_IMAGE,
            RESULT_ON_BURST_CAPTURE_FINISHED,
            RESULT_ON_LAST_BURST_CAPTURE_FINISHED,
            RESULT_PICTURE_POSTVIEW_CALLBACK,
            RESULT_CAMERA_OPENED,
            RESULT_CAMERA_CLOSED,
            RESULT_START_PREVIEW_DONE,
            RESULT_START_PREVIEW_DONE2,
            RESULT_ON_CAPTURE_FINISHED,
            RESULT_ON_CAPTURE_CANCEL,
            RESULT_CANCEL,
            RESULT_CANCEL_START_PREVIEW,
            RESULT_AUTO_FOCUS_CALLBACK,
            RESULT_CAMERA_CLOSE_START,
            RESULT_KILL_SELF,
            RESULT_UPDATE_WATCH_THUMBNAIL,
            RESULT_STOP_PREVIEW_DONE;
            
            public static ChangeQuickRedirect changeQuickRedirect;
        }
    }

    /* renamed from: com.meizu.media.camera.util.Contants$a */
    public interface C2628a {

        /* renamed from: a */
        public static final String[] f13820a = {"libgnustl_shared", "libopencv_java3", "libARSlamClient", "libAREngineCpp"};
    }

    public enum CameraV2Key {
        SMOOTH_ZOOM_TRANSITION("com.meizu.smoothTransition.fastZoomIn", Byte.TYPE),
        SMOOTH_ZOOM_TRANSITION_OUT("com.meizu.smoothTransitionNew.fastZoomOut", Byte.TYPE),
        BEAUTY_LEVEL("com.meizu.beauty.beautyLevel", Integer.TYPE),
        CAMERA_STATUS("com.meizu.aiasd.camerastatus", Integer.TYPE),
        SELECT_PRIORITY("org.codeaurora.qcamera3.iso_exp_priority.select_priority", Integer.TYPE),
        ISO_EXP("org.codeaurora.qcamera3.iso_exp_priority.use_iso_exp_priority", Long.TYPE),
        DEVICE_ORIENTATION("com.meizu.device.orientation", Integer.TYPE),
        DEVICE_MOVING("com.meizu.device.moving", Integer.TYPE),
        AI_ASD_RESULTS("com.meizu.aiasd.asdresults", int[].class),
        AI_ASD_ENABLE("com.meizu.aiasd.enable", Integer.TYPE),
        USE_ISO_VALUE("org.codeaurora.qcamera3.iso_exp_priority.use_iso_value", Integer.TYPE),
        EIS3_ENABLE("org.quic.camera.eis3enable.EISV3Enable", Byte.TYPE),
        END_OF_STREAM("org.quic.camera.recording.endOfStream", Byte.TYPE),
        HDR_DETECTED("com.meizu.hdr.hdrDetected", Integer.TYPE),
        HDR_ENABLE("com.meizu.hdr.enable", Integer.TYPE),
        MFNR_ENABLE("com.meizu.mfnr.enable", Integer.TYPE),
        MFNR_DETECTED("com.meizu.mfnr.mfnrDetected", Integer.TYPE),
        CONTROL_ENABLE_ZSL("android.control.enableZsl", Boolean.TYPE),
        DUAL_OPT_DATA("com.meizu.dualcamera.bokehOTP", byte[].class),
        DUAL_OPT_JCX_DATA("com.meizu.dualcamera.bokehOTP_JCX", byte[].class),
        EXPOSURE_METERING_MODE("org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode", Integer.TYPE),
        AE_ISO("com.qti.chi.statsaec.ae_iso", Integer.TYPE),
        IS_FLASH_REQUIRED("com.qti.stats_control.is_flash_snapshot", Integer.TYPE),
        STOP_EIS("com.meizu.videoEIS.stopEIS", Integer.TYPE),
        SUPER_NIGHT_MODE("com.meizu.night.nightMode", Integer.TYPE),
        BURST_FPS("org.quic.camera.BurstFPS.burstfps", Byte.TYPE),
        SUPER_NIGHT_TRIPOD_LONG_EXPOSURE("com.meizu.night.tripod", Integer.TYPE),
        WIDE_ANGLE_UNDISTORT("com.meizu.undistort.isDisableUndistort", Integer.TYPE),
        TOF_OPT_ENABLE("com.meizu.dualcamera.bokehTx_enable", Byte.TYPE);
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private String mKeyName;
        private Class mType;

        public String getKeyName() {
            return this.mKeyName;
        }

        public Class getKeyType() {
            return this.mType;
        }

        private CameraV2Key(String str, Class cls) {
            this.mKeyName = str;
            this.mType = cls;
        }
    }

    public enum CameraCharacteristicsKey {
        FEATURE_FRONT_HDR("com.meizu.feature.FrontHDR", Integer.TYPE),
        FEATURE_WIDE_ANGLE_UNDISTORT("com.meizu.feature.MeizuSupportDisableUndistort", Integer.TYPE),
        FEATURE_HFR_TABLE("com.meizu.feature.MeizuCustomHFRFpsTable", int[].class);
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private String mKeyName;
        private Class mType;

        public String getKeyName() {
            return this.mKeyName;
        }

        public Class getKeyType() {
            return this.mType;
        }

        private CameraCharacteristicsKey(String str, Class cls) {
            this.mKeyName = str;
            this.mType = cls;
        }
    }

    public enum AsdSceneType {
        AUTO(0, "auto", 0, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        LANDSCAPE(1, "landscape", R.drawable.icon_asd_landscape, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mzlandscape")),
        PORTRAIT(2, "portrait", R.drawable.icon_asd_portrait, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        NIGHT(4, "night", R.drawable.mz_ic_supernight, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        SUNSET(8, "sunset", R.drawable.icon_asd_sunset, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        BEACH(9, "beach", R.drawable.icon_asd_beach, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        SNOW(10, "snow", R.drawable.icon_asd_snow, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        FIREWORK(11, "firework", R.drawable.icon_asd_firework, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        TEXT(12, "text", R.drawable.icon_asd_text, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mztext")),
        GOURMET(19, "gourmet", R.drawable.icon_asd_gourmet, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mzfood")),
        INFANT(20, "infant", R.drawable.icon_asd_infant, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        BLUE_SKY(21, "blueSky", R.drawable.icon_asd_bule_sky, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mzblue")),
        INDOOR(22, "indoor", R.drawable.icon_asd_indoor, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        CAT(31, "cat", R.drawable.icon_asd_cat, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        DOG(32, "dog", R.drawable.icon_asd_dog, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        SPOTLIGHT(38, "spotlight", R.drawable.icon_asd_spotlight, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone")),
        GRASS(47, "grass", R.drawable.icon_asd_grass, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mzgrass")),
        SUPERNIGHT(-2, "night", R.drawable.mz_ic_supernight, new C2627a(0.0f, 0.0f, 0.0f, 0.0f, "Mznone"));
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private final C2627a mAsdEffect;
        private final int mIcon;
        private final int mId;
        private final String mTitle;

        private AsdSceneType(int i, String str, int i2, C2627a aVar) {
            this.mId = i;
            this.mTitle = str;
            this.mIcon = i2;
            this.mAsdEffect = aVar;
        }

        public int getId() {
            return this.mId;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public C2627a getAsdEffect() {
            return this.mAsdEffect;
        }

        public static AsdSceneType convertAsdSceneType(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 7957, new Class[]{Integer.TYPE}, AsdSceneType.class);
            if (proxy.isSupported) {
                return (AsdSceneType) proxy.result;
            }
            if (LANDSCAPE.getId() == i) {
                return LANDSCAPE;
            }
            if (PORTRAIT.getId() == i) {
                return PORTRAIT;
            }
            if (SUNSET.getId() == i) {
                return SUNSET;
            }
            if (BEACH.getId() == i) {
                return BEACH;
            }
            if (SNOW.getId() == i) {
                return SNOW;
            }
            if (FIREWORK.getId() == i) {
                return FIREWORK;
            }
            if (TEXT.getId() == i) {
                return TEXT;
            }
            if (GOURMET.getId() == i) {
                return GOURMET;
            }
            if (INFANT.getId() == i) {
                return INFANT;
            }
            if (BLUE_SKY.getId() == i) {
                return BLUE_SKY;
            }
            if (INDOOR.getId() == i) {
                return INDOOR;
            }
            if (CAT.getId() == i) {
                return CAT;
            }
            if (DOG.getId() == i) {
                return DOG;
            }
            if (SPOTLIGHT.getId() == i) {
                return SPOTLIGHT;
            }
            if (GRASS.getId() == i) {
                return GRASS;
            }
            if (SUPERNIGHT.getId() == i) {
                return SUPERNIGHT;
            }
            return AUTO;
        }

        /* renamed from: com.meizu.media.camera.util.Contants$AsdSceneType$a */
        public static class C2627a {

            /* renamed from: a */
            public float f13815a;

            /* renamed from: b */
            public float f13816b;

            /* renamed from: c */
            public float f13817c;

            /* renamed from: d */
            public float f13818d;

            /* renamed from: e */
            public String f13819e;

            public C2627a(float f, float f2, float f3, float f4, String str) {
                this.f13815a = f;
                this.f13816b = f2;
                this.f13817c = f3;
                this.f13818d = f4;
                this.f13819e = str;
            }
        }
    }

    public enum DeviceMarkType {
        DEVICE_MARK_CLOSE("0", "false"),
        DEVICE_MARK_DEFAULT("1", "true"),
        DEVICE_MARK_CUSTOM("2", "other");
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private String mOption;
        private String mValue;

        public String getOption() {
            return this.mOption;
        }

        public String getValue() {
            return this.mValue;
        }

        private DeviceMarkType(String str, String str2) {
            this.mOption = str;
            this.mValue = str2;
        }
    }
}
