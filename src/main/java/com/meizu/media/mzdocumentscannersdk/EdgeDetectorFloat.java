package com.meizu.media.mzdocumentscannersdk;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class EdgeDetectorFloat extends EdgeDetector {
    private static final String TAG = "EdgeDetectorFloat";
    private ByteBuffer outputBuffer;

    /* access modifiers changed from: protected */
    public int getImageSizeX() {
        return 256;
    }

    /* access modifiers changed from: protected */
    public int getImageSizeY() {
        return 256;
    }

    /* access modifiers changed from: protected */
    public String getModelPath() {
        return MzDSController.MODEL_FILE;
    }

    /* access modifiers changed from: protected */
    public int getNumBytesPerChannel() {
        return 4;
    }

    EdgeDetectorFloat(Activity activity) throws IOException {
        super(activity);
        this.outputBuffer = null;
        this.outputBuffer = ByteBuffer.allocateDirect(getImageSizeX() * getImageSizeY() * getNumBytesPerChannel());
        this.outputBuffer.order(ByteOrder.nativeOrder());
    }

    EdgeDetectorFloat(String str) throws IOException {
        super(str);
        this.outputBuffer = null;
        this.outputBuffer = ByteBuffer.allocateDirect(getImageSizeX() * getImageSizeY() * getNumBytesPerChannel());
        this.outputBuffer.order(ByteOrder.nativeOrder());
    }

    /* access modifiers changed from: protected */
    public void addPixelValue(int i) {
        this.imgData.putFloat(((float) ((i >> 16) & 255)) / 255.0f);
        this.imgData.putFloat(((float) ((i >> 8) & 255)) / 255.0f);
        this.imgData.putFloat(((float) (i & 255)) / 255.0f);
    }

    /* access modifiers changed from: protected */
    public byte[] runInferenceByte() {
        this.outputBuffer.rewind();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.tflite.run(this.imgData, this.outputBuffer);
        long uptimeMillis2 = SystemClock.uptimeMillis();
        Log.d(TAG, "Timecost to run model inference(ByteBuffer): " + Long.toString(uptimeMillis2 - uptimeMillis));
        this.outputBuffer.flip();
        byte[] bArr = new byte[(getImageSizeX() * getImageSizeY())];
        long uptimeMillis3 = SystemClock.uptimeMillis();
        for (int i = 0; i < getImageSizeX() * getImageSizeY(); i++) {
            if (this.outputBuffer.getFloat() > 0.0f) {
                bArr[i] = -1;
            } else {
                bArr[i] = 0;
            }
        }
        long uptimeMillis4 = SystemClock.uptimeMillis();
        Log.d(TAG, "Timecost to setPixel: " + Long.toString(uptimeMillis4 - uptimeMillis3));
        return bArr;
    }
}
