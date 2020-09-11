package com.meizu.media.mzdocumentscannersdk;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

public class MzCropDSController {
    private static final String TAG = "MzCropDSController";
    private Scanner scanner;

    public static String getVersionCode() {
        return Scanner.getVersionCode();
    }

    public static boolean loadLibrary() {
        Scanner.loadLibrary();
        return Scanner.getStatus();
    }

    public boolean initController() {
        this.scanner = new Scanner();
        if (this.scanner != null) {
            return true;
        }
        Log.e(TAG, "MzCropDSController() is false");
        return false;
    }

    public Bitmap documentCrop(Bitmap bitmap, Point[] pointArr) {
        if (bitmap == null || pointArr == null) {
            Log.e(TAG, "documentCrop Failed : input param is null.");
            return null;
        } else if (pointArr.length != 4) {
            Log.e(TAG, "documentCrop Failed : input points length error.");
            return null;
        } else if (this.scanner != null) {
            return this.scanner.crop(bitmap, pointArr);
        } else {
            Log.e(TAG, "documentCrop Failed : scanner is null.");
            return null;
        }
    }
}
