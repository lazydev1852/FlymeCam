package com.mediatek.accessor.data;

public class StereoDepthInfo {
    public byte[] debugBuffer;
    public String debugDir;
    public byte[] depthBuffer;
    public int depthBufferHeight;
    public int depthBufferWidth;
    public byte[] depthMap;
    public int depthMapHeight;
    public int depthMapWidth;
    public int depthOfFieldLast;
    public int metaBufferHeight;
    public int metaBufferWidth;
    public int touchCoordXLast;
    public int touchCoordYLast;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentMaskInfo:");
        sb.append("\n    metaBufferWidth  = 0x" + Integer.toHexString(this.metaBufferWidth) + "(" + this.metaBufferWidth + ")");
        sb.append("\n    metaBufferHeight = 0x" + Integer.toHexString(this.metaBufferHeight) + "(" + this.metaBufferHeight + ")");
        sb.append("\n    touchCoordXLast = 0x" + Integer.toHexString(this.touchCoordXLast) + "(" + this.touchCoordXLast + ")");
        sb.append("\n    touchCoordYLast = 0x" + Integer.toHexString(this.touchCoordYLast) + "(" + this.touchCoordYLast + ")");
        sb.append("\n    depthOfFieldLast = 0x" + Integer.toHexString(this.depthOfFieldLast) + "(" + this.depthOfFieldLast + ")");
        sb.append("\n    depthBufferWidth = 0x" + Integer.toHexString(this.depthBufferWidth) + "(" + this.depthBufferWidth + ")");
        sb.append("\n    depthBufferHeight = 0x" + Integer.toHexString(this.depthBufferHeight) + "(" + this.depthBufferHeight + ")");
        sb.append("\n    depthMapWidth = 0x" + Integer.toHexString(this.depthMapWidth) + "(" + this.depthMapWidth + ")");
        sb.append("\n    depthMapHeight = 0x" + Integer.toHexString(this.depthMapHeight) + "(" + this.depthMapHeight + ")");
        if (this.depthBuffer != null) {
            sb.append("\n    depthBuffer length = 0x" + Integer.toHexString(this.depthBuffer.length) + "(" + this.depthBuffer.length + ")");
        } else {
            sb.append("\n    depthBuffer = null");
        }
        if (this.depthMap != null) {
            sb.append("\n    depthMap length = 0x" + Integer.toHexString(this.depthMap.length) + "(" + this.depthMap.length + ")");
        } else {
            sb.append("\n    depthMap = null");
        }
        if (this.debugBuffer != null) {
            sb.append("\n    debugBuffer length = 0x" + Integer.toHexString(this.debugBuffer.length) + "(" + this.debugBuffer.length + ")");
        } else {
            sb.append("\n    debugBuffer = null");
        }
        return sb.toString();
    }
}
