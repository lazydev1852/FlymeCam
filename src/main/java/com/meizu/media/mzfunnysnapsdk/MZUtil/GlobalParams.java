package com.meizu.media.mzfunnysnapsdk.MZUtil;

import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.savior.ChangeQuickRedirect;

public class GlobalParams {
    public static final String ARCSOFT_FACE_MODEL_FILE_NAME = "track_data.dat";
    public static int BEAUTY_LOOKUPTABLE_TYPE = FRAME_TYPE_TWO;
    public static int BEAUTY_QUALITY = BEAUTY_QUALITY_HIGH;
    public static int BEAUTY_QUALITY_HIGH = 1;
    public static int BEAUTY_QUALITY_LOW = 2;
    public static boolean BOOLEAN_WATERMARK = false;
    public static int CameraID = 1;
    public static int DEFAULT_HEIGHT = 1280;
    public static int DEFAULT_WIDTH = 720;
    public static int FRAME_TYPE = FRAME_TYPE_TWO;
    public static int FRAME_TYPE_ONE = 1;
    public static int FRAME_TYPE_TWO = 2;
    public static int HEIGHT = DEFAULT_HEIGHT;
    public static int SCREEN_ANGLE = 0;
    public static float SCREEN_ANGLE_ORIGIN_X = 0.0f;
    public static float SCREEN_ANGLE_ORIGIN_Y = 0.0f;
    public static float SCREEN_ANGLE_ORIGIN_Z = 0.0f;
    public static int SCREEN_ANGLE_temp = 0;
    public static int WIDTH = DEFAULT_WIDTH;
    public static boolean boolScaleEnable;
    public static ChangeQuickRedirect changeQuickRedirect;
    public static float eyesScale;
    public static float faceScale;
    public static FaceArcsoft.Face[] faces_readout_current;
    public static int globalScaleDistanceIndexes = 0;
    public static int[] globalScaleIndexes = new int[2];
    public static int intCurrentFilter = 1;
    public static boolean isStickerReadyToRender = false;
    public static int skinSmoothLevel;
    public static String strCurrentSticker;

    public static void setCameraID(int i) {
        CameraID = i;
    }

    public static int getCameraID() {
        return CameraID;
    }

    public static void setScreenAngle(int i) {
        SCREEN_ANGLE_temp = i;
    }

    public static void setRenderSize(int i, int i2) {
        DEFAULT_WIDTH = i;
        DEFAULT_HEIGHT = i2;
        WIDTH = i;
        HEIGHT = i2;
    }

    public static int getScreenAngle() {
        return SCREEN_ANGLE_temp;
    }

    public static void setScreenAngleOrigin(float f, float f2, float f3) {
        SCREEN_ANGLE_ORIGIN_X = f;
        SCREEN_ANGLE_ORIGIN_Y = f2;
        SCREEN_ANGLE_ORIGIN_Z = f3;
    }

    public static float getScreenAngleOriginX() {
        return SCREEN_ANGLE_ORIGIN_X;
    }

    public static float getScreenAngleOriginY() {
        return SCREEN_ANGLE_ORIGIN_Y;
    }

    public static float getScreenAngleOriginZ() {
        return SCREEN_ANGLE_ORIGIN_Z;
    }

    public static String getCurrentSticker() {
        return strCurrentSticker;
    }
}
