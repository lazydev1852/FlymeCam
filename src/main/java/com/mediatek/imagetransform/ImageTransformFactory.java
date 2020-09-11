package com.mediatek.imagetransform;

import android.graphics.Rect;
import android.media.Image;
import android.util.Log;

public class ImageTransformFactory {
    public static final String FLIP_H = "horizontally";
    public static final String FLIP_V = "vertically";
    public static final int ROT_0 = 0;
    public static final int ROT_180 = 180;
    public static final int ROT_270 = 270;
    public static final int ROT_90 = 90;
    private static final String TAG = "ImageTransformFactory";
    private static ImageTransformFactory sImageTransformFactory;

    private static native boolean native_applyTransform(Image image, Image image2, Options options);

    ImageTransformFactory() {
    }

    public static ImageTransformFactory createImageTransformFactory() {
        if (sImageTransformFactory == null) {
            sImageTransformFactory = new ImageTransformFactory();
        }
        return sImageTransformFactory;
    }

    public boolean applyTransform(Image image, Image image2, Options options) {
        Log.i(TAG, "applyTransform()");
        return native_applyTransform(image, image2, options);
    }

    public class Options {
        private Rect cropRoi;
        private boolean dither;
        private int encodingQuality;
        private String flip;
        private int rotation;
        private int sharpness;

        public Options() {
        }

        public void setCropRoi(Rect rect) {
            this.cropRoi = rect;
        }

        public Rect getCropRoi() {
            return this.cropRoi;
        }

        public void setFlip(String str) {
            this.flip = str;
        }

        public String getFlip() {
            return this.flip;
        }

        public void setRotation(int i) {
            this.rotation = i;
        }

        public int getRotation() {
            return this.rotation;
        }

        public void setEncodingQuality(int i) {
            this.encodingQuality = i;
        }

        public int getEncodingQuality() {
            return this.encodingQuality;
        }

        public void setDither(boolean z) {
            this.dither = z;
        }

        public boolean isDither() {
            return this.dither;
        }

        public void setSharpness(int i) {
            this.sharpness = i;
        }

        public int getSharpness() {
            return this.sharpness;
        }
    }

    static {
        System.loadLibrary("jni_imagetransform");
    }
}
