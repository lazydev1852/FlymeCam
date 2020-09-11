package com.mediatek.accessor.util;

import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.media.MtkMediaStore;

public class StereoInfoJsonParser {
    private static final String CONV_OFFSET_TAG = "conv_offset";
    private static final String DEPTHINFO_HEIGHT = "height";
    private static final String DEPTHINFO_TAG = "depth_buffer_size";
    private static final String DEPTHINFO_WIDTH = "width";
    private static final String DEPTH_INFO_DEPTH_HEIGHT = "height";
    private static final String DEPTH_INFO_DEPTH_WIDTH = "width";
    private static final String DEPTH_INFO_META_HEIGHT = "meta_height";
    private static final String DEPTH_INFO_META_WIDTH = "meta_width";
    private static final String DEPTH_INFO_TAG = "depth_buffer_size";
    private static final String DEPTH_ROTATION_INFO_ORIENTATION = "orientation";
    private static final String DEPTH_ROTATION_INFO_TAG = "depthmap_orientation";
    private static final String DOF_LEVEL_TAG = "dof_level";
    private static final String FACE_DETECTION_INFO_BOTTOM = "bottom";
    private static final String FACE_DETECTION_INFO_LEFT = "left";
    private static final String FACE_DETECTION_INFO_RIGHT = "right";
    private static final String FACE_DETECTION_INFO_RIP = "rotation-in-plane";
    private static final String FACE_DETECTION_INFO_TAG = "face_detections";
    private static final String FACE_DETECTION_INFO_TOP = "top";
    private static final String FOCUS_INFO_DAC_CUR = "dac_cur";
    private static final String FOCUS_INFO_DAC_MAX = "dac_max";
    private static final String FOCUS_INFO_DAC_MIN = "dac_min";
    private static final String FOCUS_INFO_FACE_RATIO = "face_ratio";
    private static final String FOCUS_INFO_FOCUS_TYPE = "focus_type";
    private static final String FOCUS_INFO_IS_FACE = "is_face";
    private static final String FOCUS_INFO_TAG = "focus_info";
    private static final String GDEPTHINFO_FAR = "Far";
    private static final String GDEPTHINFO_FORMAT = "Format";
    private static final String GDEPTHINFO_MIME = "Mime";
    private static final String GDEPTHINFO_NEAR = "Near";
    private static final String GDEPTHINFO_TAG = "GDepth";
    private static final String GFOCUSINFO_BLUR_AT_INFINITY = "BlurAtInfinity";
    private static final String GFOCUSINFO_FOCAL_DISTANCE = "FocalDistance";
    private static final String GFOCUSINFO_FOCAL_POINT_X = "FocalPointX";
    private static final String GFOCUSINFO_FOCAL_POINT_Y = "FocalPointY";
    private static final String GFOCUSINFO_TAG = "GFocus";
    private static final String GIMAGEINFO_MIME = "Mime";
    private static final String GIMAGEINFO_TAG = "GImage";
    private static final String JPSINFO_HEIGHT = "height";
    private static final String JPSINFO_TAG = "JPS_size";
    private static final String JPSINFO_WIDTH = "width";
    private static final String LDCINFO_HEIGHT = "height";
    private static final String LDCINFO_TAG = "ldc_size";
    private static final String LDCINFO_WIDTH = "width";
    private static final String MAIN_CAM_POSITION_INFO_POSITION = "relative_position";
    private static final String MAIN_CAM_POSITION_INFO_TAG = "sensor_relative_position";
    private static final String MASKINFO_HEIGHT = "height";
    private static final String MASKINFO_MASK = "mask";
    private static final String MASKINFO_TAG = "mask_info";
    private static final String MASKINFO_WIDTH = "width";
    private static final String ORIENTATIONINFO_ORIENTATION = "orientation";
    private static final String ORIENTATIONINFO_TAG = "capture_orientation";
    private static final String POSINFO_TAG = "main_cam_align_shift";
    private static final String POSINFO_X = "x";
    private static final String POSINFO_Y = "y";
    private static final String TAG = Log.Tag(StereoInfoJsonParser.class.getSimpleName());
    private static final String TOUCH_COORD_INFO_BOTTOM = "bottom";
    private static final String TOUCH_COORD_INFO_LEFT = "left";
    private static final String TOUCH_COORD_INFO_RIGHT = "right";
    private static final String TOUCH_COORD_INFO_TAG = "focus_roi";
    private static final String TOUCH_COORD_INFO_TOP = "top";
    private static final int VALID_MASK = 255;
    public static final String VERIFY_GEO_INFO_LEVEL = "quality_level";
    public static final String VERIFY_GEO_INFO_TAG = "verify_geo_data";
    private static final String VERIFY_MTK_CHA_INFO_LEVEL = "quality_level";
    private static final String VERIFY_MTK_CHA_INFO_TAG = "verify_mtk_cha";
    private static final String VERIFY_PHO_INFO_LEVEL = "quality_level";
    private static final String VERIFY_PHO_INFO_TAG = "verify_pho_data";
    private static final String VIEWINFO_HEIGHT = "height";
    private static final String VIEWINFO_TAG = "input_image_size";
    private static final String VIEWINFO_WIDTH = "width";
    private int mDepthRotation = -1;
    private int mFaceRectCount = -1;
    private int mGDepthHeight = -1;
    private int mGDepthWidth = -1;
    private int mJpsHeight = -1;
    private int mJpsWidth = -1;
    private int mMainCamPostion = -1;
    private int mMaskHeight = -1;
    private int mMaskSize = -1;
    private int mMaskWidth = -1;
    private int mOrientation = -1;
    private JsonParser mParser;
    private int mPosX = -1;
    private int mPosY = -1;
    private int mTouchCoordX1st = -1;
    private int mTouchCoordY1st = -1;
    private int mViewHeight = -1;
    private int mViewWidth = -1;

    public StereoInfoJsonParser(String str) {
        this.mParser = new JsonParser(str);
    }

    public StereoInfoJsonParser(byte[] bArr) {
        this.mParser = new JsonParser(bArr);
    }

    public int getGeoVerifyLevel() {
        return this.mParser.getValueIntFromObject(VERIFY_GEO_INFO_TAG, (String) null, VERIFY_GEO_INFO_LEVEL);
    }

    public int getPhoVerifyLevel() {
        return this.mParser.getValueIntFromObject(VERIFY_PHO_INFO_TAG, (String) null, VERIFY_GEO_INFO_LEVEL);
    }

    public int getMtkChaVerifyLevel() {
        return this.mParser.getValueIntFromObject(VERIFY_MTK_CHA_INFO_TAG, (String) null, VERIFY_GEO_INFO_LEVEL);
    }

    public int getJpsWidth() {
        if (this.mJpsWidth != -1) {
            return this.mJpsWidth;
        }
        this.mJpsWidth = this.mParser.getValueIntFromObject(JPSINFO_TAG, (String) null, "width");
        if (this.mJpsWidth < 0) {
            this.mJpsWidth = 0;
        }
        String str = TAG;
        Log.m3993d(str, "<getJpsWidth> mJpsWidth: " + this.mJpsWidth);
        return this.mJpsWidth;
    }

    public int getJpsHeight() {
        if (this.mJpsHeight != -1) {
            return this.mJpsHeight;
        }
        this.mJpsHeight = this.mParser.getValueIntFromObject(JPSINFO_TAG, (String) null, "height");
        if (this.mJpsHeight < 0) {
            this.mJpsHeight = 0;
        }
        String str = TAG;
        Log.m3993d(str, "<getJpsHeight> mJpsHeight: " + this.mJpsHeight);
        return this.mJpsHeight;
    }

    public int getGoogleDepthWidth() {
        if (this.mGDepthWidth != -1) {
            return this.mGDepthWidth;
        }
        this.mGDepthWidth = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, "width");
        String str = TAG;
        Log.m3993d(str, "<getGoogleDepthWidth> mGDepthWidth: " + this.mGDepthWidth);
        return this.mGDepthWidth;
    }

    public int getGoogleDepthHeight() {
        if (this.mGDepthHeight != -1) {
            return this.mGDepthHeight;
        }
        this.mGDepthHeight = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, "height");
        String str = TAG;
        Log.m3993d(str, "<getGoogleDepthHeight> mGDepthHeight: " + this.mGDepthHeight);
        return this.mGDepthHeight;
    }

    public int getMaskWidth() {
        if (this.mMaskWidth != -1) {
            return this.mMaskWidth;
        }
        this.mMaskWidth = this.mParser.getValueIntFromObject(MASKINFO_TAG, (String) null, "width");
        String str = TAG;
        Log.m3993d(str, "<getMaskWidth> mMaskWidth: " + this.mMaskWidth);
        return this.mMaskWidth;
    }

    public int getMaskHeight() {
        if (this.mMaskHeight != -1) {
            return this.mMaskHeight;
        }
        this.mMaskHeight = this.mParser.getValueIntFromObject(MASKINFO_TAG, (String) null, "height");
        String str = TAG;
        Log.m3993d(str, "<getMaskHeight> mMaskHeight: " + this.mMaskHeight);
        return this.mMaskHeight;
    }

    public int getMaskSize() {
        if (this.mMaskSize != -1) {
            return this.mMaskSize;
        }
        this.mMaskSize = getMaskWidth() * getMaskHeight();
        String str = TAG;
        Log.m3993d(str, "<getMaskSize> mMaskSize: " + this.mMaskSize);
        return this.mMaskSize;
    }

    public byte[] getMaskBuffer() {
        this.mMaskSize = getMaskSize();
        int[][] int2DArrayFromObject = this.mParser.getInt2DArrayFromObject(MASKINFO_TAG, MASKINFO_MASK);
        if (int2DArrayFromObject != null) {
            return decodeMaskBuffer(int2DArrayFromObject, this.mMaskSize);
        }
        Log.m3993d(TAG, "<getMaskBuffer> Json mask array is null, return null!!");
        return null;
    }

    public int getPosX() {
        if (this.mPosX != -1) {
            return this.mPosX;
        }
        this.mPosX = this.mParser.getValueIntFromObject(POSINFO_TAG, (String) null, POSINFO_X);
        String str = TAG;
        Log.m3993d(str, "<getPosX> mPosX: " + this.mPosX);
        return this.mPosX;
    }

    public int getPosY() {
        if (this.mPosY != -1) {
            return this.mPosY;
        }
        this.mPosY = this.mParser.getValueIntFromObject(POSINFO_TAG, (String) null, POSINFO_Y);
        String str = TAG;
        Log.m3993d(str, "<getPosY> mPosY: " + this.mPosY);
        return this.mPosY;
    }

    public int getViewWidth() {
        if (this.mViewWidth != -1) {
            return this.mViewWidth;
        }
        this.mViewWidth = this.mParser.getValueIntFromObject(VIEWINFO_TAG, (String) null, "width");
        String str = TAG;
        Log.m3993d(str, "<getViewWidth> mViewWidth: " + this.mViewWidth);
        return this.mViewWidth;
    }

    public int getViewHeight() {
        if (this.mViewHeight != -1) {
            return this.mViewHeight;
        }
        this.mViewHeight = this.mParser.getValueIntFromObject(VIEWINFO_TAG, (String) null, "height");
        String str = TAG;
        Log.m3993d(str, "<getViewHeight> mViewHeight: " + this.mViewHeight);
        return this.mViewHeight;
    }

    public int getOrientation() {
        if (this.mOrientation != -1) {
            return this.mOrientation;
        }
        this.mOrientation = this.mParser.getValueIntFromObject(ORIENTATIONINFO_TAG, (String) null, MtkMediaStore.VideoColumns.ORIENTATION);
        String str = TAG;
        Log.m3993d(str, "<getOrientation> mOrientation: " + this.mOrientation);
        return this.mOrientation;
    }

    public int getDepthRotation() {
        if (this.mDepthRotation != -1) {
            return this.mDepthRotation;
        }
        this.mDepthRotation = this.mParser.getValueIntFromObject(DEPTH_ROTATION_INFO_TAG, (String) null, MtkMediaStore.VideoColumns.ORIENTATION);
        String str = TAG;
        Log.m3993d(str, "<getDepthRotation> mDepthRotation: " + this.mDepthRotation);
        return this.mDepthRotation;
    }

    public int getMainCamPos() {
        if (this.mMainCamPostion != -1) {
            return this.mMainCamPostion;
        }
        this.mMainCamPostion = this.mParser.getValueIntFromObject(MAIN_CAM_POSITION_INFO_TAG, (String) null, MAIN_CAM_POSITION_INFO_POSITION);
        String str = TAG;
        Log.m3993d(str, "<getMainCamPos> mMainCamPostion: " + this.mMainCamPostion);
        return this.mMainCamPostion;
    }

    public int getTouchCoordX1st() {
        if (this.mTouchCoordX1st != -1) {
            return this.mTouchCoordX1st;
        }
        this.mTouchCoordX1st = (this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "left") + this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "right")) / 2;
        String str = TAG;
        Log.m3993d(str, "<getTouchCoordX1st> mTouchCoordX1st: " + this.mTouchCoordX1st);
        return this.mTouchCoordX1st;
    }

    public int getTouchCoordY1st() {
        if (this.mTouchCoordY1st != -1) {
            return this.mTouchCoordY1st;
        }
        this.mTouchCoordY1st = (this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "top") + this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "bottom")) / 2;
        String str = TAG;
        Log.m3993d(str, "<getTouchCoordY1st> mTouchCoordY1st: " + this.mTouchCoordY1st);
        return this.mTouchCoordY1st;
    }

    public int getFocusTop() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "top");
        String str = TAG;
        Log.m3993d(str, "<getFocusTop> top: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getFocusLeft() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "left");
        String str = TAG;
        Log.m3993d(str, "<getFocusLeft> left: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getFocusRight() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "right");
        String str = TAG;
        Log.m3993d(str, "<getFocusRight> top: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getFocusBottom() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(TOUCH_COORD_INFO_TAG, (String) null, "bottom");
        String str = TAG;
        Log.m3993d(str, "<getFocusBottom> bottom: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getFaceRectCount() {
        if (this.mFaceRectCount != -1) {
            return this.mFaceRectCount;
        }
        this.mFaceRectCount = this.mParser.getArrayLength(FACE_DETECTION_INFO_TAG);
        String str = TAG;
        Log.m3993d(str, "<getFaceRectCount> mFaceRectCount: " + this.mFaceRectCount);
        return this.mFaceRectCount;
    }

    public DataItem.Rect getFaceRect(int i) {
        int objectPropertyValueFromArray = this.mParser.getObjectPropertyValueFromArray(FACE_DETECTION_INFO_TAG, i, "left");
        int objectPropertyValueFromArray2 = this.mParser.getObjectPropertyValueFromArray(FACE_DETECTION_INFO_TAG, i, "top");
        int objectPropertyValueFromArray3 = this.mParser.getObjectPropertyValueFromArray(FACE_DETECTION_INFO_TAG, i, "right");
        int objectPropertyValueFromArray4 = this.mParser.getObjectPropertyValueFromArray(FACE_DETECTION_INFO_TAG, i, "bottom");
        if (objectPropertyValueFromArray != -1 && objectPropertyValueFromArray2 != -1 && objectPropertyValueFromArray3 != -1 && objectPropertyValueFromArray4 != -1) {
            return new DataItem.Rect(objectPropertyValueFromArray, objectPropertyValueFromArray2, objectPropertyValueFromArray3, objectPropertyValueFromArray4);
        }
        Log.m3993d(TAG, "<getFaceRect> error: left == -1 || top == -1 || right == -1 || bottom == -1");
        return null;
    }

    public int getFaceRip(int i) {
        return this.mParser.getObjectPropertyValueFromArray(FACE_DETECTION_INFO_TAG, i, FACE_DETECTION_INFO_RIP);
    }

    public double getGFocusBlurAtInfinity() {
        double valueDoubleFromObject = this.mParser.getValueDoubleFromObject(GFOCUSINFO_TAG, (String) null, GFOCUSINFO_BLUR_AT_INFINITY);
        String str = TAG;
        Log.m3993d(str, "<getGFocusBlurAtInfinity>  " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public double getGFocusFocalDistance() {
        double valueDoubleFromObject = this.mParser.getValueDoubleFromObject(GFOCUSINFO_TAG, (String) null, GFOCUSINFO_FOCAL_DISTANCE);
        String str = TAG;
        Log.m3993d(str, "<getGFocusFocalDistance>  " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public double getGFocusFocalPointX() {
        double valueDoubleFromObject = this.mParser.getValueDoubleFromObject(GFOCUSINFO_TAG, (String) null, GFOCUSINFO_FOCAL_POINT_X);
        String str = TAG;
        Log.m3993d(str, "<getGFocusFocalPointX>  " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public double getGFocusFocalPointY() {
        double valueDoubleFromObject = this.mParser.getValueDoubleFromObject(GFOCUSINFO_TAG, (String) null, GFOCUSINFO_FOCAL_POINT_Y);
        String str = TAG;
        Log.m3993d(str, "<getGFocusFocalPointY>  " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public String getGImageMime() {
        String valueStringFromObject = this.mParser.getValueStringFromObject(GIMAGEINFO_TAG, (String) null, "Mime");
        String str = TAG;
        Log.m3993d(str, "<getGImageMime>  " + valueStringFromObject);
        return valueStringFromObject;
    }

    public String getGDepthFormat() {
        String valueStringFromObject = this.mParser.getValueStringFromObject(GDEPTHINFO_TAG, (String) null, GDEPTHINFO_FORMAT);
        String str = TAG;
        Log.m3993d(str, "<getGDepthFormat>  " + valueStringFromObject);
        return valueStringFromObject;
    }

    public double getGDepthNear() {
        double valueIntFromObject = (double) this.mParser.getValueIntFromObject(GDEPTHINFO_TAG, (String) null, GDEPTHINFO_NEAR);
        String str = TAG;
        Log.m3993d(str, "<getGDepthNear>  " + valueIntFromObject);
        return valueIntFromObject;
    }

    public double getGDepthFar() {
        double valueIntFromObject = (double) this.mParser.getValueIntFromObject(GDEPTHINFO_TAG, (String) null, GDEPTHINFO_FAR);
        String str = TAG;
        Log.m3993d(str, "<getGDepthFar>  " + valueIntFromObject);
        return valueIntFromObject;
    }

    public String getGDepthMime() {
        String valueStringFromObject = this.mParser.getValueStringFromObject(GDEPTHINFO_TAG, (String) null, "Mime");
        String str = TAG;
        Log.m3993d(str, "<getGDepthMime>  " + valueStringFromObject);
        return valueStringFromObject;
    }

    public int getDof() {
        int valueIntFromObject = this.mParser.getValueIntFromObject((String) null, (String) null, DOF_LEVEL_TAG);
        String str = TAG;
        Log.m3993d(str, "<getDof>  " + valueIntFromObject);
        return valueIntFromObject;
    }

    public float getConvOffset() {
        float valueDoubleFromObject = (float) this.mParser.getValueDoubleFromObject((String) null, (String) null, CONV_OFFSET_TAG);
        String str = TAG;
        Log.m3993d(str, "<getConvOffset>  " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public int getLdcWidth() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(LDCINFO_TAG, (String) null, "width");
        String str = TAG;
        Log.m3993d(str, "<getLdcWidth> ldcWidth: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getLdcHeight() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(LDCINFO_TAG, (String) null, "height");
        String str = TAG;
        Log.m3993d(str, "<getLdcHeight> ldcHeight: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public boolean getFaceFlag() {
        boolean valueBooleanFromObject = this.mParser.getValueBooleanFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_IS_FACE);
        String str = TAG;
        Log.m3993d(str, "<getFaceFlag> FocusInfo.isFace: " + valueBooleanFromObject);
        return valueBooleanFromObject;
    }

    public double getFaceRatio() {
        double valueDoubleFromObject = this.mParser.getValueDoubleFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_FACE_RATIO);
        String str = TAG;
        Log.m3993d(str, "<getFaceRatio> FocusInfo.faceRatio: " + valueDoubleFromObject);
        return valueDoubleFromObject;
    }

    public int getCurDac() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_DAC_CUR);
        String str = TAG;
        Log.m3993d(str, "<getFocusInfo> FocusInfo.curDac: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getMinDac() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_DAC_MIN);
        String str = TAG;
        Log.m3993d(str, "<getFocusInfo> FocusInfo.minDac: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getMaxDac() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_DAC_MAX);
        String str = TAG;
        Log.m3993d(str, "<getFocusInfo> FocusInfo.maxDac: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getFocusType() {
        int valueIntFromObject = this.mParser.getValueIntFromObject(FOCUS_INFO_TAG, (String) null, FOCUS_INFO_FOCUS_TYPE);
        String str = TAG;
        Log.m3993d(str, "<getFocusType> FocusInfo.focusType: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getMetaBufferWidth() {
        int valueIntFromObject = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, DEPTH_INFO_META_WIDTH);
        String str = TAG;
        Log.m3993d(str, "<getMetaBufferWidth> metaWidth: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getMetaBufferHeight() {
        int valueIntFromObject = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, DEPTH_INFO_META_HEIGHT);
        String str = TAG;
        Log.m3993d(str, "<getMetaBufferHeight> metaHeight: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getDepthBufferWidth() {
        int valueIntFromObject = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, "width");
        String str = TAG;
        Log.m3993d(str, "<getDepthBufferWidth> depthWidth: " + valueIntFromObject);
        return valueIntFromObject;
    }

    public int getDepthBufferHeight() {
        int valueIntFromObject = this.mParser.getValueIntFromObject("depth_buffer_size", (String) null, "height");
        String str = TAG;
        Log.m3993d(str, "<getDepthBufferHeight> depthHeight: " + valueIntFromObject);
        return valueIntFromObject;
    }

    private byte[] decodeMaskBuffer(int[][] iArr, int i) {
        byte[] bArr = new byte[i];
        long currentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = 0;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3][0];
            int i5 = iArr[i3][1] + i4;
            if (i4 > i || i4 < 0 || i5 < 0 || i5 > i) {
                String str = TAG;
                Log.m3993d(str, "<decodeMaskBuffer> error, startIndex: " + i4 + ", endIndex: " + i5 + ", maskSize: " + i);
                return null;
            }
            while (i4 < i5) {
                bArr[i4] = -1;
                i4++;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        String str2 = TAG;
        Log.m3993d(str2, "<decodeMaskBuffer> performance, decode mask costs: " + (currentTimeMillis2 - currentTimeMillis));
        return bArr;
    }
}
