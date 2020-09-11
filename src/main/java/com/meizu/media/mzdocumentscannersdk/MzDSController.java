package com.meizu.media.mzdocumentscannersdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import com.meizu.media.mzdocumentscannersdk.utils.C2761Utils;
import java.io.IOException;

public class MzDSController {
    private static final int HEIGHT = 256;
    public static final String MODEL_FILE = "model.tflite";
    private static final String TAG = "MzDSController";
    private static final int THRESHOLD = 10;
    private static final int WIDTH = 256;
    private EdgeDetector edgeDetector;
    private Point[] prePoints = {new Point(0, 0), new Point(256, 0), new Point(256, 256), new Point(0, 256)};
    private Scanner scanner;
    private long testTimeCropper = 0;
    private long testTimeEdge = 0;

    public static String getVersionCode() {
        return Scanner.getVersionCode();
    }

    public static boolean loadLibrary() {
        Scanner.loadLibrary();
        return Scanner.getStatus();
    }

    public boolean initDSController(Activity activity) {
        try {
            this.edgeDetector = new EdgeDetectorFloat(activity);
            this.scanner = new Scanner();
            if (this.edgeDetector != null && this.scanner != null) {
                return true;
            }
            Log.e(TAG, "initDSController(activity) is false");
            return false;
        } catch (IOException e) {
            Log.e(TAG, "Failed to initialize an edge detector : EdgeDetectorFloat(activity). " + e.getMessage());
            return false;
        }
    }

    public boolean initDSController(String str) {
        try {
            this.edgeDetector = new EdgeDetectorFloat(str);
            this.scanner = new Scanner();
            if (this.edgeDetector != null && this.scanner != null) {
                return true;
            }
            Log.e(TAG, "initDSController(String modelPath) is false");
            return false;
        } catch (IOException unused) {
            Log.e(TAG, "Failed to initialize an edge detector : EdgeDetectorFloat(modelPath).");
            return false;
        }
    }

    public Point[] documentScan(Bitmap bitmap) {
        this.testTimeEdge = 0;
        this.testTimeCropper = 0;
        if (bitmap == null) {
            Log.e(TAG, "Failed : bitmap is null.");
            return null;
        } else if (this.edgeDetector == null) {
            Log.e(TAG, "Failed : edgeDetector is null.");
            return null;
        } else if (this.scanner == null) {
            Log.e(TAG, "Failed : smartCropper is null.");
            return null;
        } else {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 256, 256, false);
            long uptimeMillis = SystemClock.uptimeMillis();
            byte[] detectFrameByte = this.edgeDetector.detectFrameByte(createScaledBitmap);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.testTimeEdge = uptimeMillis2;
            Log.d(TAG, "Timecost to run edge inference: " + Long.toString(uptimeMillis2));
            long uptimeMillis3 = SystemClock.uptimeMillis();
            Point[] scan = this.scanner.scan(detectFrameByte, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
            this.testTimeCropper = uptimeMillis4;
            Log.d(TAG, "Timecost to find points: " + Long.toString(uptimeMillis4));
            createScaledBitmap.recycle();
            for (int i = 0; i < scan.length; i++) {
                Point point = scan[i];
                point.x = (int) (((float) point.x) * ((((float) bitmap.getWidth()) * 1.0f) / 256.0f));
                Point point2 = scan[i];
                point2.y = (int) (((float) point2.y) * ((((float) bitmap.getHeight()) * 1.0f) / 256.0f));
            }
            return scan;
        }
    }

    public Point[] documentScan(int[] iArr, int i, int i2) {
        this.testTimeEdge = 0;
        this.testTimeCropper = 0;
        if (iArr == null) {
            Log.e(TAG, "Failed : bitmap is null.");
            return null;
        } else if (this.edgeDetector == null) {
            Log.e(TAG, "Failed : edgeDetector is null.");
            return null;
        } else if (this.scanner == null) {
            Log.e(TAG, "Failed : smartCropper is null.");
            return null;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            byte[] detectFrameByteData = this.edgeDetector.detectFrameByteData(iArr, i, i2);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.testTimeEdge = uptimeMillis2;
            Log.d(TAG, "Timecost to run edge inference: " + Long.toString(uptimeMillis2));
            long uptimeMillis3 = SystemClock.uptimeMillis();
            Point[] scan = this.scanner.scan(detectFrameByteData, i, i2);
            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
            this.testTimeCropper = uptimeMillis4;
            Log.d(TAG, "Timecost to find points: " + Long.toString(uptimeMillis4));
            if (!checkPoints(scan, this.prePoints)) {
                this.prePoints = scan;
            }
            Point[] pointArr = new Point[this.prePoints.length];
            for (int i3 = 0; i3 < this.prePoints.length; i3++) {
                pointArr[i3] = new Point(this.prePoints[i3].x, this.prePoints[i3].y);
            }
            return pointArr;
        }
    }

    public Point[] documentScan(int[] iArr, int i, int i2, int i3, int i4) {
        Point[] documentScan = documentScan(iArr, i, i2);
        for (int i5 = 0; i5 < documentScan.length; i5++) {
            Point point = documentScan[i5];
            point.x = (int) (((float) point.x) * ((((float) i3) * 1.0f) / ((float) i)));
            Point point2 = documentScan[i5];
            point2.y = (int) (((float) point2.y) * ((((float) i4) * 1.0f) / ((float) i2)));
        }
        return documentScan;
    }

    private boolean checkPoints(Point[] pointArr, Point[] pointArr2) {
        return C2761Utils.getPointsDistance(pointArr[0], pointArr2[0]) < 10.0d && C2761Utils.getPointsDistance(pointArr[1], pointArr2[1]) < 10.0d && C2761Utils.getPointsDistance(pointArr[2], pointArr2[2]) < 10.0d && C2761Utils.getPointsDistance(pointArr[3], pointArr2[3]) < 10.0d;
    }

    public long getTestTimeEdge() {
        return this.testTimeEdge;
    }

    public long getTestTimeCropper() {
        return this.testTimeCropper;
    }

    public void destroy() {
        if (this.edgeDetector != null) {
            this.edgeDetector.close();
        }
    }
}
