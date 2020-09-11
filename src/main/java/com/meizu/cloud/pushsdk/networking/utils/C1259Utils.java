package com.meizu.cloud.pushsdk.networking.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.networking.common.ANConstants;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.core.Core;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.interfaces.AnalyticsListener;
import com.meizu.cloud.pushsdk.networking.okio.Okio;
import com.meizu.cloud.pushsdk.networking.okio.Source;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;

/* renamed from: com.meizu.cloud.pushsdk.networking.utils.Utils */
public class C1259Utils {
    public static File getDiskCacheDir(Context context, String str) {
        return new File(context.getCacheDir(), str);
    }

    public static String getMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? "application/octet-stream" : contentTypeFor;
    }

    public static ANResponse<Bitmap> decodeBitmap(Response response, int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = Okio.buffer((Source) response.body().source()).readByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int resizedDimension = getResizedDimension(i, i2, i3, i4, scaleType);
            int resizedDimension2 = getResizedDimension(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i3, i4, resizedDimension, resizedDimension2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= resizedDimension && decodeByteArray.getHeight() <= resizedDimension2)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, resizedDimension, resizedDimension2, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return ANResponse.failed(getErrorForParse(new ANError(response)));
        }
        return ANResponse.success(bitmap);
    }

    private static int getResizedDimension(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d2 = (double) i2;
                return ((double) i) * d < d2 ? (int) (d2 / d) : i;
            }
            double d3 = (double) i2;
            return ((double) i) * d > d3 ? (int) (d3 / d) : i;
        }
    }

    public static int findBestSampleSize(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a A[SYNTHETIC, Splitter:B:33:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveFile(com.meizu.cloud.pushsdk.networking.http.Response r3, java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            com.meizu.cloud.pushsdk.networking.http.ResponseBody r3 = r3.body()     // Catch:{ all -> 0x004c }
            java.io.InputStream r3 = r3.byteStream()     // Catch:{ all -> 0x004c }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x004a }
            r2.<init>(r4)     // Catch:{ all -> 0x004a }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x004a }
            if (r4 != 0) goto L_0x001b
            r2.mkdirs()     // Catch:{ all -> 0x004a }
        L_0x001b:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x004a }
            r4.<init>(r2, r5)     // Catch:{ all -> 0x004a }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x004a }
            r5.<init>(r4)     // Catch:{ all -> 0x004a }
        L_0x0025:
            int r4 = r3.read(r0)     // Catch:{ all -> 0x0047 }
            r1 = -1
            if (r4 == r1) goto L_0x0031
            r1 = 0
            r5.write(r0, r1, r4)     // Catch:{ all -> 0x0047 }
            goto L_0x0025
        L_0x0031:
            r5.flush()     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x003e
            r3.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003e:
            r5.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            return
        L_0x0047:
            r4 = move-exception
            r1 = r5
            goto L_0x004e
        L_0x004a:
            r4 = move-exception
            goto L_0x004e
        L_0x004c:
            r4 = move-exception
            r3 = r1
        L_0x004e:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0058:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0062:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.networking.utils.C1259Utils.saveFile(com.meizu.cloud.pushsdk.networking.http.Response, java.lang.String, java.lang.String):void");
    }

    public static void sendAnalytics(AnalyticsListener analyticsListener, long j, long j2, long j3, boolean z) {
        final AnalyticsListener analyticsListener2 = analyticsListener;
        final long j4 = j;
        final long j5 = j2;
        final long j6 = j3;
        final boolean z2 = z;
        Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
            public void run() {
                if (analyticsListener2 != null) {
                    analyticsListener2.onReceived(j4, j5, j6, z2);
                }
            }
        });
    }

    public static ANError getErrorForConnection(ANError aNError) {
        aNError.setErrorDetail(ANConstants.CONNECTION_ERROR);
        aNError.setErrorCode(0);
        aNError.setErrorBody(aNError.getMessage());
        return aNError;
    }

    public static ANError getErrorForServerResponse(ANError aNError, ANRequest aNRequest, int i) {
        ANError parseNetworkError = aNRequest.parseNetworkError(aNError);
        parseNetworkError.setErrorCode(i);
        parseNetworkError.setErrorDetail(ANConstants.RESPONSE_FROM_SERVER_ERROR);
        return parseNetworkError;
    }

    public static ANError getErrorForParse(ANError aNError) {
        aNError.setErrorCode(0);
        aNError.setErrorDetail(ANConstants.PARSE_ERROR);
        aNError.setErrorBody(aNError.getMessage());
        return aNError;
    }

    public static ANError getErrorForNetworkOnMainThreadOrConnection(Exception exc) {
        ANError aNError = new ANError((Throwable) exc);
        if (Build.VERSION.SDK_INT < 11 || !(exc instanceof NetworkOnMainThreadException)) {
            aNError.setErrorDetail(ANConstants.CONNECTION_ERROR);
        } else {
            aNError.setErrorDetail(ANConstants.NETWORK_ON_MAIN_THREAD_ERROR);
        }
        aNError.setErrorCode(0);
        return aNError;
    }
}
