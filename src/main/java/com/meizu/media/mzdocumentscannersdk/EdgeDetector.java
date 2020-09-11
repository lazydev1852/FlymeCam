package com.meizu.media.mzdocumentscannersdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import org.tensorflow.lite.Interpreter;

public abstract class EdgeDetector {
    private static final int DIM_BATCH_SIZE = 1;
    private static final int DIM_PIXEL_SIZE = 3;
    private static final String TAG = "EdgeDetector";
    protected ByteBuffer imgData = null;
    private int[] intValues = new int[(getImageSizeX() * getImageSizeY())];
    protected Interpreter tflite;
    private MappedByteBuffer tfliteModel;
    private File tfliteModelFile;
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();

    /* access modifiers changed from: protected */
    public abstract void addPixelValue(int i);

    /* access modifiers changed from: protected */
    public abstract int getImageSizeX();

    /* access modifiers changed from: protected */
    public abstract int getImageSizeY();

    /* access modifiers changed from: protected */
    public abstract String getModelPath();

    /* access modifiers changed from: protected */
    public abstract int getNumBytesPerChannel();

    /* access modifiers changed from: protected */
    public abstract byte[] runInferenceByte();

    EdgeDetector(Activity activity) throws IOException {
        this.tfliteModel = loadModelFile(activity);
        this.tflite = new Interpreter((ByteBuffer) this.tfliteModel, this.tfliteOptions);
        this.imgData = ByteBuffer.allocateDirect(getImageSizeX() * 1 * getImageSizeY() * 3 * getNumBytesPerChannel());
        this.imgData.order(ByteOrder.nativeOrder());
        Log.d(TAG, "Created a TensorFlow Lite Edge Detector.");
    }

    EdgeDetector(String str) throws IOException {
        this.tfliteModelFile = new File(str);
        this.tflite = new Interpreter(this.tfliteModelFile, this.tfliteOptions);
        this.imgData = ByteBuffer.allocateDirect(getImageSizeX() * 1 * getImageSizeY() * 3 * getNumBytesPerChannel());
        this.imgData.order(ByteOrder.nativeOrder());
        Log.d(TAG, "Created a TensorFlow Lite Edge Detector.");
    }

    public byte[] detectFrameByte(Bitmap bitmap) {
        if (this.tflite == null) {
            Log.e(TAG, "Edge Detector has not been initialized; Skipped.");
        }
        convertBitmapToByteBuffer(bitmap);
        long uptimeMillis = SystemClock.uptimeMillis();
        byte[] runInferenceByte = runInferenceByte();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        Log.d(TAG, "Timecost to run model inference: " + Long.toString(uptimeMillis2 - uptimeMillis));
        return runInferenceByte;
    }

    public byte[] detectFrameByteData(int[] iArr, int i, int i2) {
        if (this.tflite == null) {
            Log.e(TAG, "Edge Detector has not been initialized; Skipped.");
        }
        convertBitmapToByteBufferData(iArr, i, i2);
        long uptimeMillis = SystemClock.uptimeMillis();
        byte[] runInferenceByte = runInferenceByte();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        Log.d(TAG, "Timecost to run model inference: " + Long.toString(uptimeMillis2 - uptimeMillis));
        return runInferenceByte;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[SYNTHETIC, Splitter:B:27:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[Catch:{ IOException -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0062 A[SYNTHETIC, Splitter:B:37:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006a A[Catch:{ IOException -> 0x0066 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.MappedByteBuffer loadModelFile(android.app.Activity r11) {
        /*
            r10 = this;
            r0 = 0
            android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ IOException -> 0x0047, all -> 0x0042 }
            java.lang.String r1 = r10.getModelPath()     // Catch:{ IOException -> 0x0047, all -> 0x0042 }
            android.content.res.AssetFileDescriptor r11 = r11.openFd(r1)     // Catch:{ IOException -> 0x0047, all -> 0x0042 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            java.io.FileDescriptor r2 = r11.getFileDescriptor()     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003f, all -> 0x003a }
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch:{ IOException -> 0x0038 }
            long r5 = r11.getStartOffset()     // Catch:{ IOException -> 0x0038 }
            long r7 = r11.getDeclaredLength()     // Catch:{ IOException -> 0x0038 }
            java.nio.channels.FileChannel$MapMode r4 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ IOException -> 0x0038 }
            java.nio.MappedByteBuffer r2 = r3.map(r4, r5, r7)     // Catch:{ IOException -> 0x0038 }
            if (r11 == 0) goto L_0x0030
            r11.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r11 = move-exception
            goto L_0x0034
        L_0x0030:
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0037
        L_0x0034:
            r11.printStackTrace()
        L_0x0037:
            return r2
        L_0x0038:
            r2 = move-exception
            goto L_0x004a
        L_0x003a:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0060
        L_0x003f:
            r2 = move-exception
            r1 = r0
            goto L_0x004a
        L_0x0042:
            r11 = move-exception
            r1 = r0
            r0 = r11
            r11 = r1
            goto L_0x0060
        L_0x0047:
            r2 = move-exception
            r11 = r0
            r1 = r11
        L_0x004a:
            r2.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r11 == 0) goto L_0x0055
            r11.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            r11 = move-exception
            goto L_0x005b
        L_0x0055:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005e
        L_0x005b:
            r11.printStackTrace()
        L_0x005e:
            return r0
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            if (r11 == 0) goto L_0x0068
            r11.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0068
        L_0x0066:
            r11 = move-exception
            goto L_0x006e
        L_0x0068:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0071
        L_0x006e:
            r11.printStackTrace()
        L_0x0071:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzdocumentscannersdk.EdgeDetector.loadModelFile(android.app.Activity):java.nio.MappedByteBuffer");
    }

    public void close() {
        this.tflite.close();
        this.tflite = null;
        this.tfliteModel = null;
    }

    private void convertBitmapToByteBuffer(Bitmap bitmap) {
        if (this.imgData != null) {
            this.imgData.rewind();
            bitmap.getPixels(this.intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = 0;
            int i2 = 0;
            while (i < getImageSizeX()) {
                int i3 = i2;
                int i4 = 0;
                while (i4 < getImageSizeY()) {
                    addPixelValue(this.intValues[i3]);
                    i4++;
                    i3++;
                }
                i++;
                i2 = i3;
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            Log.d(TAG, "Timecost to put values into ByteBuffer: " + Long.toString(uptimeMillis2 - uptimeMillis));
        }
    }

    private void convertBitmapToByteBufferData(int[] iArr, int i, int i2) {
        if (this.imgData != null) {
            this.imgData.rewind();
            long uptimeMillis = SystemClock.uptimeMillis();
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                int i5 = i4;
                int i6 = 0;
                while (i6 < i2) {
                    addPixelValue(iArr[i5]);
                    i6++;
                    i5++;
                }
                i3++;
                i4 = i5;
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            Log.d(TAG, "Timecost to put values into ByteBuffer: " + Long.toString(uptimeMillis2 - uptimeMillis));
        }
    }
}
