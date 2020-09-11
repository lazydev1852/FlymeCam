package com.mediatek.accessor.data;

public class SegmentMaskInfo {
    public String debugDir;
    public byte[] maskBuffer;
    public int maskHeight;
    public int maskWidth;
    public int segmentBottom;
    public int segmentLeft;
    public int segmentRight;
    public int segmentTop;
    public int segmentX;
    public int segmentY;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentMaskInfo:");
        sb.append("\n    maskWidth  = 0x" + Integer.toHexString(this.maskWidth) + "(" + this.maskWidth + ")");
        sb.append("\n    maskHeight = 0x" + Integer.toHexString(this.maskHeight) + "(" + this.maskHeight + ")");
        sb.append("\n    segmentX = 0x" + Integer.toHexString(this.segmentX) + "(" + this.segmentX + ")");
        sb.append("\n    segmentY = 0x" + Integer.toHexString(this.segmentY) + "(" + this.segmentY + ")");
        sb.append("\n    segmentLeft = 0x" + Integer.toHexString(this.segmentLeft) + "(" + this.segmentLeft + ")");
        sb.append("\n    segmentTop = 0x" + Integer.toHexString(this.segmentTop) + "(" + this.segmentTop + ")");
        sb.append("\n    segmentRight = 0x" + Integer.toHexString(this.segmentRight) + "(" + this.segmentRight + ")");
        sb.append("\n    segmentBottom = 0x" + Integer.toHexString(this.segmentBottom) + "(" + this.segmentBottom + ")");
        if (this.maskBuffer != null) {
            sb.append("\n    maskBuffer length = 0x" + Integer.toHexString(this.maskBuffer.length) + "(" + this.maskBuffer.length + ")");
        } else {
            sb.append("\n    maskBuffer = null");
        }
        return sb.toString();
    }
}
