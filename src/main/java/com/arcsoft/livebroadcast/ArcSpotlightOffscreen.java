package com.arcsoft.livebroadcast;

public class ArcSpotlightOffscreen {
    public static final int ASVL_PAF_I420 = 1537;
    public static final int ASVL_PAF_NV12 = 2049;
    public static final int ASVL_PAF_NV21 = 2050;
    public static final int ASVL_PAF_RGB32_B8G8R8A8 = 770;
    public static final int ASVL_PAF_RGB32_R8G8B8A8 = 773;
    public static final int ASVL_PAF_YUYV = 1281;
    private byte[] data;
    private int height;
    private int pixelFormat;
    private int width;

    public ArcSpotlightOffscreen(int i, int i2, int i3) {
        this.width = i;
        this.height = i2;
        this.pixelFormat = i3;
    }

    public ArcSpotlightOffscreen(int i, int i2, int i3, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.pixelFormat = i3;
        this.data = bArr;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public void setPixelFormat(int i) {
        this.pixelFormat = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
