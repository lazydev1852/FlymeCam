package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.StereoBufferInfo;
import com.mediatek.accessor.data.StereoCaptureInfo;
import com.mediatek.accessor.data.StereoConfigInfo;
import com.mediatek.accessor.data.StereoDepthInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.StereoInfoJsonParser;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class StereoCaptureInfoParser implements IParser {
    private static final String TAG = Log.Tag(StereoCaptureInfoParser.class.getSimpleName());
    private StereoBufferInfo mBufferInfo = new StereoBufferInfo();
    private StereoConfigInfo mConfigInfo = new StereoConfigInfo();
    private IMetaOperator mCustomizedMetaOperator;
    private StereoDepthInfo mDepthInfo = new StereoDepthInfo();
    private IMetaOperator mStandardMetaOperator;
    private StereoBufferInfoParser mStereoBufferInfoParser;
    private StereoCaptureInfo mStereoCaptureInfo;
    private StereoConfigInfoParser mStereoConfigInfoParser;
    private StereoDepthInfoParser mStereoDepthInfoParser;

    public void read() {
    }

    public StereoCaptureInfoParser(byte[] bArr, byte[] bArr2, Map<String, byte[]> map, StereoCaptureInfo stereoCaptureInfo) {
        this.mStereoCaptureInfo = stereoCaptureInfo;
        this.mCustomizedMetaOperator = MetaOperatorFactory.getOperatorInstance(1, (byte[]) null, map);
        this.mStandardMetaOperator = MetaOperatorFactory.getOperatorInstance(0, bArr, (Map<String, byte[]>) null);
    }

    public void write() {
        TraceHelper.beginSection(">>>>StereoCaptureInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mStereoCaptureInfo == null) {
            Log.m3993d(TAG, "<write> mStereoCaptureInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpJsonBuffer("write");
        writeInfo();
        this.mStereoBufferInfoParser = new StereoBufferInfoParser(this.mCustomizedMetaOperator, this.mBufferInfo);
        this.mStereoBufferInfoParser.write();
        this.mStereoDepthInfoParser = new StereoDepthInfoParser(this.mStandardMetaOperator, (IMetaOperator) null, this.mCustomizedMetaOperator, this.mDepthInfo);
        this.mStereoDepthInfoParser.write();
        this.mStereoConfigInfoParser = new StereoConfigInfoParser(this.mStandardMetaOperator, (IMetaOperator) null, this.mCustomizedMetaOperator, this.mConfigInfo);
        this.mStereoConfigInfoParser.write();
        TraceHelper.endSection();
    }

    public SerializedInfo serialize() {
        TraceHelper.beginSection(">>>>StereoCaptureInfoParser-serialize");
        Log.m3993d(TAG, "<serialize>");
        SerializedInfo serializedInfo = new SerializedInfo();
        if (this.mStandardMetaOperator != null) {
            serializedInfo.standardXmpBuf = this.mStandardMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        if (this.mCustomizedMetaOperator != null) {
            serializedInfo.customizedBufMap = this.mCustomizedMetaOperator.serialize();
        }
        TraceHelper.endSection();
        return serializedInfo;
    }

    private void writeInfo() {
        TraceHelper.beginSection(">>>>StereoCaptureInfoParser-writeInfo");
        this.mBufferInfo.debugDir = this.mStereoCaptureInfo.debugDir;
        this.mBufferInfo.jpsBuffer = this.mStereoCaptureInfo.jpsBuffer;
        this.mConfigInfo.debugDir = this.mStereoCaptureInfo.debugDir;
        this.mConfigInfo.ldcBuffer = this.mStereoCaptureInfo.ldc;
        this.mConfigInfo.clearImage = this.mStereoCaptureInfo.clearImage;
        if (this.mStereoCaptureInfo.configBuffer == null) {
            TraceHelper.endSection();
            return;
        }
        StereoInfoJsonParser stereoInfoJsonParser = new StereoInfoJsonParser(this.mStereoCaptureInfo.configBuffer);
        this.mBufferInfo.maskBuffer = stereoInfoJsonParser.getMaskBuffer();
        this.mConfigInfo.jpsWidth = stereoInfoJsonParser.getJpsWidth();
        this.mConfigInfo.jpsHeight = stereoInfoJsonParser.getJpsHeight();
        this.mConfigInfo.maskWidth = stereoInfoJsonParser.getMaskWidth();
        this.mConfigInfo.maskHeight = stereoInfoJsonParser.getMaskHeight();
        this.mConfigInfo.posX = stereoInfoJsonParser.getPosX();
        this.mConfigInfo.posY = stereoInfoJsonParser.getPosY();
        this.mConfigInfo.viewWidth = stereoInfoJsonParser.getViewWidth();
        this.mConfigInfo.viewHeight = stereoInfoJsonParser.getViewHeight();
        this.mConfigInfo.imageOrientation = stereoInfoJsonParser.getOrientation();
        this.mConfigInfo.depthOrientation = stereoInfoJsonParser.getDepthRotation();
        this.mConfigInfo.mainCamPos = stereoInfoJsonParser.getMainCamPos();
        this.mConfigInfo.touchCoordX1st = stereoInfoJsonParser.getTouchCoordX1st();
        this.mConfigInfo.touchCoordY1st = stereoInfoJsonParser.getTouchCoordY1st();
        this.mConfigInfo.faceCount = stereoInfoJsonParser.getFaceRectCount();
        this.mConfigInfo.fdInfoArray = prepareFdInfo(stereoInfoJsonParser, this.mConfigInfo.faceCount);
        StereoConfigInfo.FocusInfo focusInfo = new StereoConfigInfo.FocusInfo();
        focusInfo.focusType = stereoInfoJsonParser.getFocusType();
        focusInfo.focusLeft = stereoInfoJsonParser.getFocusLeft();
        focusInfo.focusTop = stereoInfoJsonParser.getFocusTop();
        focusInfo.focusRight = stereoInfoJsonParser.getFocusRight();
        focusInfo.focusBottom = stereoInfoJsonParser.getFocusBottom();
        this.mConfigInfo.focusInfo = focusInfo;
        this.mConfigInfo.dofLevel = stereoInfoJsonParser.getDof();
        this.mConfigInfo.convOffset = stereoInfoJsonParser.getConvOffset();
        this.mConfigInfo.ldcWidth = stereoInfoJsonParser.getLdcWidth();
        this.mConfigInfo.ldcHeight = stereoInfoJsonParser.getLdcHeight();
        this.mConfigInfo.isFace = stereoInfoJsonParser.getFaceFlag();
        this.mConfigInfo.faceRatio = (float) stereoInfoJsonParser.getFaceRatio();
        this.mConfigInfo.curDac = stereoInfoJsonParser.getCurDac();
        this.mConfigInfo.minDac = stereoInfoJsonParser.getMinDac();
        this.mConfigInfo.maxDac = stereoInfoJsonParser.getMaxDac();
        this.mDepthInfo.debugDir = this.mStereoCaptureInfo.debugDir;
        this.mDepthInfo.metaBufferWidth = stereoInfoJsonParser.getMetaBufferWidth();
        this.mDepthInfo.metaBufferHeight = stereoInfoJsonParser.getMetaBufferHeight();
        this.mDepthInfo.depthBufferWidth = stereoInfoJsonParser.getDepthBufferWidth();
        this.mDepthInfo.depthBufferHeight = stereoInfoJsonParser.getDepthBufferHeight();
        this.mDepthInfo.depthBuffer = this.mStereoCaptureInfo.depthBuffer;
        this.mDepthInfo.debugBuffer = this.mStereoCaptureInfo.debugBuffer;
        TraceHelper.endSection();
    }

    private ArrayList<StereoConfigInfo.FaceDetectionInfo> prepareFdInfo(StereoInfoJsonParser stereoInfoJsonParser, int i) {
        if (i <= 0 || stereoInfoJsonParser == null) {
            Log.m3993d(TAG, "<prepareFdInfo> invalid params!!");
            return null;
        }
        ArrayList<StereoConfigInfo.FaceDetectionInfo> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            DataItem.Rect faceRect = stereoInfoJsonParser.getFaceRect(i2);
            int faceRip = stereoInfoJsonParser.getFaceRip(i2);
            if (faceRect != null) {
                StereoConfigInfo.FaceDetectionInfo faceDetectionInfo = new StereoConfigInfo.FaceDetectionInfo(faceRect.left, faceRect.top, faceRect.right, faceRect.bottom, faceRip);
                arrayList.add(i2, faceDetectionInfo);
                String str = TAG;
                Log.m3993d(str, "<prepareFdInfo> faceInfo-i: " + faceDetectionInfo);
            }
        }
        return arrayList;
    }

    private void dumpJsonBuffer(String str) {
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mStereoCaptureInfo.debugDir + "/";
            Log.m3993d(TAG, "<dumpJsonBuffer> dumpPath: " + str2);
            if (this.mStereoCaptureInfo.configBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoCaptureInfo_jsonConfigBuffer_" + str + ".txt", this.mStereoCaptureInfo.configBuffer);
                return;
            }
            Log.m3993d(TAG, "<dumpJsonBuffer> mStereoCaptureInfo.configBuffer is null!");
        }
    }
}
