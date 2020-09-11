package com.meizu.media.mzdocumentscannersdk;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.meizu.media.mzdocumentscannersdk.utils.C2761Utils;

public class Scanner {
    private static final String TAG = "Scanner";
    private static boolean isInit = false;

    public static void loadLibrary() {
    }

    private static native void nativeCrop(Bitmap bitmap, Point[] pointArr, Bitmap bitmap2);

    private static native void nativeFindPoints(byte[] bArr, int i, int i2, Point[] pointArr);

    private static native String nativeGetVersionCode();

    private static native void nativeScan(Bitmap bitmap, Point[] pointArr);

    public Point[] scan(Bitmap bitmap) {
        if (bitmap != null) {
            Point[] pointArr = new Point[4];
            nativeScan(bitmap, pointArr);
            return pointArr;
        }
        throw new IllegalArgumentException("srcBmp cannot be null");
    }

    public Point[] scan(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Point[] pointArr = new Point[4];
            nativeFindPoints(bArr, i, i2, pointArr);
            return pointArr;
        }
        throw new IllegalArgumentException("bytes cannot be null");
    }

    public Bitmap crop(Bitmap bitmap, Point[] pointArr) {
        if (bitmap == null || pointArr == null) {
            throw new IllegalArgumentException("srcBmp and cropPoints cannot be null");
        } else if (pointArr.length == 4) {
            Point point = pointArr[0];
            Point point2 = pointArr[1];
            Point point3 = pointArr[2];
            Point point4 = pointArr[3];
            Bitmap createBitmap = Bitmap.createBitmap((((int) C2761Utils.getPointsDistance(point, point2)) + ((int) C2761Utils.getPointsDistance(point4, point3))) / 2, (((int) C2761Utils.getPointsDistance(point, point4)) + ((int) C2761Utils.getPointsDistance(point2, point3))) / 2, Bitmap.Config.ARGB_8888);
            nativeCrop(bitmap, pointArr, createBitmap);
            return createBitmap;
        } else {
            throw new IllegalArgumentException("The length of cropPoints must be 4 , and sort by leftTop, rightTop, rightBottom, leftBottom");
        }
    }

    public static String getVersionCode() {
        return nativeGetVersionCode();
    }

    public static boolean getStatus() {
        return isInit;
    }

    static {
        try {
            System.loadLibrary("scanner");
            isInit = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "======" + e.getMessage());
            isInit = false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            Log.e(TAG, "======" + e2.getMessage());
            isInit = false;
        }
    }
}
