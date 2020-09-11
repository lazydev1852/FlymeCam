package com.mediatek.accessor.data;

import com.baidu.p020ar.util.SystemInfoUtil;
import java.util.ArrayList;

public class StereoConfigInfo {
    public byte[] clearImage;
    public float convOffset;
    public int curDac;
    public String debugDir;
    public int depthOrientation;
    public int dofLevel;
    public int faceCount;
    public float faceRatio;
    public ArrayList<FaceDetectionInfo> fdInfoArray;
    public FocusInfo focusInfo;
    public int imageOrientation;
    public boolean isFace;
    public int jpsHeight;
    public int jpsWidth;
    public byte[] ldcBuffer;
    public int ldcHeight;
    public int ldcWidth;
    public int mainCamPos;
    public int maskHeight;
    public int maskWidth;
    public int maxDac;
    public int minDac;
    public int posX;
    public int posY;
    public int touchCoordX1st;
    public int touchCoordY1st;
    public int viewHeight;
    public int viewWidth;

    public static class FaceDetectionInfo {
        public int faceBottom;
        public int faceLeft;
        public int faceRight;
        public int faceRip;
        public int faceTop;

        public FaceDetectionInfo() {
        }

        public FaceDetectionInfo(int i, int i2, int i3, int i4, int i5) {
            this.faceLeft = i;
            this.faceTop = i2;
            this.faceRight = i3;
            this.faceBottom = i4;
            this.faceRip = i5;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FaceDetectionInfo:");
            sb.append("\n    faceLeft = 0x" + Integer.toHexString(this.faceLeft) + "(" + this.faceLeft + ")");
            sb.append("\n    faceTop = 0x" + Integer.toHexString(this.faceTop) + "(" + this.faceTop + ")");
            sb.append("\n    faceRight = 0x" + Integer.toHexString(this.faceRight) + "(" + this.faceRight + ")");
            sb.append("\n    faceBottom = 0x" + Integer.toHexString(this.faceBottom) + "(" + this.faceBottom + ")");
            sb.append("\n    faceRip = 0x" + Integer.toHexString(this.faceRip) + "(" + this.faceRip + ")");
            return sb.toString();
        }
    }

    public static class FocusInfo {
        public int focusBottom;
        public int focusLeft;
        public int focusRight;
        public int focusTop;
        public int focusType;

        public FocusInfo() {
        }

        public FocusInfo(int i, int i2, int i3, int i4, int i5) {
            this.focusLeft = i2;
            this.focusTop = i3;
            this.focusRight = i4;
            this.focusBottom = i5;
            this.focusType = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FocusInfo:");
            sb.append("(left,top,right,bottom|type): ");
            sb.append("(" + this.focusLeft + SystemInfoUtil.COMMA + this.focusTop + SystemInfoUtil.COMMA + this.focusRight + SystemInfoUtil.COMMA + this.focusBottom + "|" + this.focusType + ")");
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StereoConfigInfo:");
        sb.append("\n    jpsWidth  = 0x" + Integer.toHexString(this.jpsWidth) + "(" + this.jpsWidth + ")");
        sb.append("\n    jpsHeight = 0x" + Integer.toHexString(this.jpsHeight) + "(" + this.jpsHeight + ")");
        sb.append("\n    maskWidth = 0x" + Integer.toHexString(this.maskWidth) + "(" + this.maskWidth + ")");
        sb.append("\n    maskHeight = 0x" + Integer.toHexString(this.maskHeight) + "(" + this.maskHeight + ")");
        sb.append("\n    posX = 0x" + Integer.toHexString(this.posX) + "(" + this.posX + ")");
        sb.append("\n    posY = 0x" + Integer.toHexString(this.posY) + "(" + this.posY + ")");
        sb.append("\n    viewWidth = 0x" + Integer.toHexString(this.viewWidth) + "(" + this.viewWidth + ")");
        sb.append("\n    viewHeight = 0x" + Integer.toHexString(this.viewHeight) + "(" + this.viewHeight + ")");
        sb.append("\n    imageOrientation = 0x" + Integer.toHexString(this.imageOrientation) + "(" + this.imageOrientation + ")");
        sb.append("\n    depthOrientation = 0x" + Integer.toHexString(this.depthOrientation) + "(" + this.depthOrientation + ")");
        sb.append("\n    mainCamPos = 0x" + Integer.toHexString(this.mainCamPos) + "(" + this.mainCamPos + ")");
        sb.append("\n    touchCoordX1st = 0x" + Integer.toHexString(this.touchCoordX1st) + "(" + this.touchCoordX1st + ")");
        sb.append("\n    touchCoordY1st = 0x" + Integer.toHexString(this.touchCoordY1st) + "(" + this.touchCoordY1st + ")");
        sb.append("\n    faceCount = 0x" + Integer.toHexString(this.faceCount) + "(" + this.faceCount + ")");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n    ");
        sb2.append(this.focusInfo.toString());
        sb.append(sb2.toString());
        sb.append("\n    dofLevel = 0x" + Integer.toHexString(this.dofLevel) + "(" + this.dofLevel + ")");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\n    convOffset = ");
        sb3.append(this.convOffset);
        sb.append(sb3.toString());
        sb.append("\n    ldcWidth = 0x" + Integer.toHexString(this.ldcWidth) + "(" + this.ldcWidth + ")");
        sb.append("\n    ldcHeight = 0x" + Integer.toHexString(this.ldcHeight) + "(" + this.ldcHeight + ")");
        if (this.ldcBuffer != null) {
            sb.append("\n    ldcBuffer length = 0x" + Integer.toHexString(this.ldcBuffer.length) + "(" + this.ldcBuffer.length + ")");
        } else {
            sb.append("\n    ldcBuffer = null");
        }
        if (this.clearImage != null) {
            sb.append("\n    clearImage length = 0x" + Integer.toHexString(this.clearImage.length) + "(" + this.clearImage.length + ")");
        } else {
            sb.append("\n    clearImage = null");
        }
        sb.append("\n    isFace = " + this.isFace);
        sb.append("\n    faceRatio = " + this.faceRatio);
        sb.append("\n    curDac = " + this.curDac);
        sb.append("\n    minDac = " + this.minDac);
        sb.append("\n    maxDac = " + this.maxDac);
        if (this.fdInfoArray != null) {
            int size = this.fdInfoArray.size();
            for (int i = 0; i < size; i++) {
                if (this.fdInfoArray.get(i) != null) {
                    sb.append("\n    fdInfoArray[" + i + "] = " + this.fdInfoArray.get(i).toString());
                } else {
                    sb.append("\n    fdInfoArray[" + i + "] = null");
                }
            }
        } else {
            sb.append("\n    fdInfoArray = null");
        }
        return sb.toString();
    }
}
