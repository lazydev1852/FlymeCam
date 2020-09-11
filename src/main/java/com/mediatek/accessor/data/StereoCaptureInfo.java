package com.mediatek.accessor.data;

public class StereoCaptureInfo {
    public byte[] clearImage;
    public byte[] configBuffer;
    public byte[] debugBuffer;
    public String debugDir;
    public byte[] depthBuffer;
    public byte[] depthMap;
    public byte[] jpgBuffer;
    public byte[] jpsBuffer;
    public byte[] ldc;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StereoBufferInfo:");
        if (this.jpgBuffer != null) {
            sb.append("\n    jpgBuffer length = 0x" + Integer.toHexString(this.jpgBuffer.length) + "(" + this.jpgBuffer.length + ")");
        } else {
            sb.append("\n    jpgBuffer = null");
        }
        if (this.jpsBuffer != null) {
            sb.append("\n    jpsBuffer length = 0x" + Integer.toHexString(this.jpsBuffer.length) + "(" + this.jpsBuffer.length + ")");
        } else {
            sb.append("\n    jpsBuffer = null");
        }
        if (this.configBuffer != null) {
            sb.append("\n    jsonBuffer length = 0x" + Integer.toHexString(this.configBuffer.length) + "(" + this.configBuffer.length + ")");
        } else {
            sb.append("\n    jsonBuffer = null");
        }
        if (this.clearImage != null) {
            sb.append("\n    clearImage length = 0x" + Integer.toHexString(this.clearImage.length) + "(" + this.clearImage.length + ")");
        } else {
            sb.append("\n    clearImage = null");
        }
        if (this.depthMap != null) {
            sb.append("\n    depthMap length = 0x" + Integer.toHexString(this.depthMap.length) + "(" + this.depthMap.length + ")");
        } else {
            sb.append("\n    depthMap = null");
        }
        if (this.depthBuffer != null) {
            sb.append("\n    depthBuffer length = 0x" + Integer.toHexString(this.depthBuffer.length) + "(" + this.depthBuffer.length + ")");
        } else {
            sb.append("\n    depthBuffer = null");
        }
        if (this.ldc != null) {
            sb.append("\n    ldc length = 0x" + Integer.toHexString(this.ldc.length) + "(" + this.ldc.length + ")");
        } else {
            sb.append("\n    ldc = null");
        }
        if (this.debugBuffer != null) {
            sb.append("\n    debugBuffer length = 0x" + Integer.toHexString(this.debugBuffer.length) + "(" + this.debugBuffer.length + ")");
        } else {
            sb.append("\n    debugBuffer = null");
        }
        return sb.toString();
    }
}
