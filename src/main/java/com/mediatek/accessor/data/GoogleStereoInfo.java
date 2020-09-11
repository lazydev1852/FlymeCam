package com.mediatek.accessor.data;

public class GoogleStereoInfo {
    public byte[] clearImage;
    public String debugDir;
    public double depthFar;
    public String depthFormat;
    public byte[] depthMap;
    public String depthMime;
    public double depthNear;
    public double focusBlurAtInfinity;
    public double focusFocalDistance;
    public double focusFocalPointX;
    public double focusFocalPointY;
    public String imageMime;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoogleStereoInfo:");
        sb.append("\n    focusBlurAtInfinity = " + this.focusBlurAtInfinity);
        sb.append("\n    focusFocalDistance = " + this.focusFocalDistance);
        sb.append("\n    focusFocalPointX = " + this.focusFocalPointX);
        sb.append("\n    focusFocalPointY = " + this.focusFocalPointY);
        sb.append("\n    imageMime = " + this.imageMime);
        sb.append("\n    depthFormat = " + this.depthFormat);
        sb.append("\n    depthNear = " + this.depthNear);
        sb.append("\n    depthFar = " + this.depthFar);
        sb.append("\n    depthMime = " + this.depthMime);
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
        return sb.toString();
    }
}
