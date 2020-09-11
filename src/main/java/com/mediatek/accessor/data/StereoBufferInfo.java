package com.mediatek.accessor.data;

public class StereoBufferInfo {
    public String debugDir;
    public byte[] jpsBuffer;
    public byte[] maskBuffer;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StereoBufferInfo:");
        if (this.jpsBuffer != null) {
            sb.append("\n    jpsBuffer length = 0x" + Integer.toHexString(this.jpsBuffer.length) + "(" + this.jpsBuffer.length + ")");
        } else {
            sb.append("\n    jpsBuffer = null");
        }
        if (this.maskBuffer != null) {
            sb.append("\n    maskBuffer length = 0x" + Integer.toHexString(this.maskBuffer.length) + "(" + this.maskBuffer.length + ")");
        } else {
            sb.append("\n    maskBuffer = null");
        }
        return sb.toString();
    }
}
