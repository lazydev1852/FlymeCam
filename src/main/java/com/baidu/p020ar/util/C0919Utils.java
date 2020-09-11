package com.baidu.p020ar.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.baidu.ar.util.Utils */
public final class C0919Utils {

    /* renamed from: a */
    private static final String f2383a = "com.baidu.ar.util.Utils";

    /* renamed from: b */
    private static String f2384b;

    /* renamed from: c */
    private static String f2385c;

    /* renamed from: d */
    private static String f2386d = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/camera/");

    /* renamed from: a */
    private static void m2748a() {
        File file = new File(f2386d);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static Bitmap adjustBitmapDegree(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap adjustPreviewBitmap(Bitmap bitmap, double d, double d2) {
        if (bitmap == null) {
            return null;
        }
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d) / width, ((float) d2) / height);
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    public static Bitmap adjustSurfaceViewBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createBitmap(bitmap, 0, 0, (int) ((float) bitmap.getWidth()), (int) ((float) bitmap.getHeight()), new Matrix(), true);
    }

    /* renamed from: b */
    private static String m2749b() {
        String format = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        f2384b = "AR_Screenshot_" + format + ".jpg";
        return f2384b;
    }

    public static void broadcastMediaAdded(Context context, File file) {
        if (context != null && file != null && file.isFile()) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        }
    }

    public static void broadcastMediaAdded(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            broadcastMediaAdded(context, new File(str));
        }
    }

    public static boolean checkHideVideoUrlValid() {
        File file = new File(getHideVideoUrl());
        return file.exists() && file.isFile();
    }

    public static boolean checkSDCardSizeAvailable(int i) {
        long sDAvailableSizeByM = SystemInfoUtil.getSDAvailableSizeByM();
        ARLog.m2696e("bdar:avaiableSize = " + sDAvailableSizeByM);
        return sDAvailableSizeByM >= ((long) i);
    }

    public static Bitmap combineBitmap(Bitmap bitmap, Bitmap bitmap2, int i, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (bitmap2 != null) {
            if (z) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, -1.0f);
                matrix.postTranslate(0.0f, (float) bitmap2.getHeight());
                canvas.drawBitmap(bitmap2, matrix, new Paint());
            } else {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        Matrix matrix2 = new Matrix();
        matrix2.postRotate((float) i);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyfile(java.io.File r2, java.io.File r3, java.lang.Boolean r4) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.exists()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            boolean r1 = r2.isFile()
            if (r1 != 0) goto L_0x0012
            return r0
        L_0x0012:
            boolean r1 = r2.canRead()
            if (r1 != 0) goto L_0x0019
            return r0
        L_0x0019:
            java.io.File r0 = r3.getParentFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x002a
            java.io.File r0 = r3.getParentFile()
            r0.mkdirs()
        L_0x002a:
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x0039
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0039
            r3.delete()
        L_0x0039:
            r4 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            com.baidu.p020ar.util.IoUtils.copyStream((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            r2.flush()     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            goto L_0x0063
        L_0x004e:
            r3 = move-exception
            goto L_0x006a
        L_0x0050:
            r3 = move-exception
            goto L_0x0056
        L_0x0052:
            r3 = move-exception
            goto L_0x006b
        L_0x0054:
            r3 = move-exception
            r2 = r4
        L_0x0056:
            r4 = r0
            goto L_0x005d
        L_0x0058:
            r3 = move-exception
            r0 = r4
            goto L_0x006b
        L_0x005b:
            r3 = move-exception
            r2 = r4
        L_0x005d:
            r3.printStackTrace()     // Catch:{ all -> 0x0068 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r4)
        L_0x0063:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r2)
            r2 = 1
            return r2
        L_0x0068:
            r3 = move-exception
            r0 = r4
        L_0x006a:
            r4 = r2
        L_0x006b:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            com.baidu.p020ar.util.IoUtils.closeQuietly(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.C0919Utils.copyfile(java.io.File, java.io.File, java.lang.Boolean):boolean");
    }

    public static Bitmap createBitmapFromColors(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + i5;
                int i7 = iArr[i6];
                iArr[i6] = (i7 & -16711936) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
            }
        }
        new Matrix().postRotate(180.0f);
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static byte[] cropYuv(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || bArr2.length < i * i2) {
            bArr = new byte[(i * i2)];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 % 2 == 1) {
                int i7 = i5;
                for (int i8 = 0; i8 < i3; i8++) {
                    if (i8 % 2 == 1) {
                        bArr[i7] = bArr2[(i6 * i3) + i8];
                        i7++;
                    }
                }
                i5 = i7;
            }
        }
        return bArr;
    }

    public static void decodeYUV420SP(int[] iArr, byte[] bArr, int i, int i2) {
        int[] iArr2 = iArr;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        int i5 = i3 * i4;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = ((i6 >> 1) * i3) + i5;
            int i9 = 0;
            int i10 = 0;
            int i11 = i7;
            int i12 = 0;
            while (i12 < i3) {
                int i13 = (bArr2[i11] & 255) - 16;
                if (i13 < 0) {
                    i13 = 0;
                }
                if ((i12 & 1) == 0) {
                    int i14 = i8 + 1;
                    if (i8 < bArr2.length) {
                        i10 = (bArr2[i8] & 255) - 128;
                        i9 = (bArr2[i8] & 255) - 128;
                    }
                    i8 = i14;
                }
                int i15 = i13 * 1192;
                int i16 = (i10 * 1634) + i15;
                int i17 = (i15 - (i10 * 833)) - (i9 * 400);
                int i18 = i15 + (i9 * 2066);
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 262143) {
                    i16 = 262143;
                }
                if (i17 < 0) {
                    i17 = 0;
                } else if (i17 > 262143) {
                    i17 = 262143;
                }
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i11 < iArr2.length) {
                    iArr2[i11] = ((i18 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK | ((i17 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i16 >> 10) & 255);
                }
                i12++;
                i11++;
            }
            i6++;
            i7 = i11;
        }
    }

    public static void decodeYUV420SPrgb565(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 * i4;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = ((i6 >> 1) * i3) + i5;
            int i9 = 0;
            int i10 = 0;
            int i11 = i7;
            int i12 = 0;
            while (i12 < i3) {
                int i13 = (bArr[i11] & 255) - 16;
                if (i13 < 0) {
                    i13 = 0;
                }
                if ((i12 & 1) == 0) {
                    int i14 = i8 + 1;
                    int i15 = i14 + 1;
                    int i16 = (bArr[i14] & 255) - 128;
                    i9 = (bArr[i8] & 255) - 128;
                    i8 = i15;
                    i10 = i16;
                }
                int i17 = i13 * 1192;
                int i18 = (i9 * 1634) + i17;
                int i19 = (i17 - (i9 * 833)) - (i10 * 400);
                int i20 = i17 + (i10 * 2066);
                int i21 = 262143;
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 262143) {
                    i19 = 262143;
                }
                if (i20 < 0) {
                    i21 = 0;
                } else if (i20 <= 262143) {
                    i21 = i20;
                }
                iArr[i11] = -16777216 | ((i18 << 6) & 16711680) | ((i19 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i21 >> 10) & 255);
                i12++;
                i11++;
            }
            i6++;
            i7 = i11;
        }
    }

    public static void dialPhone(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int dipToPx(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void enterMarket(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
        context.startActivity(Intent.createChooser(intent, Res.getString("bdar_sdk_version_update_market_tips")));
    }

    public static String generateVideoName() {
        String format = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        f2385c = "AR_video_" + format + ".mp4";
        return f2386d + f2385c;
    }

    public static String getDir() {
        return f2386d;
    }

    public static String getFormatterDate() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss.SS").format(new Date());
    }

    public static int getHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT <= 12) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public static String getHidePictureUrl() {
        return f2386d + ".AR_Screenshot.jpg";
    }

    public static String getHideVideoUrl() {
        return f2386d + ".AR_video.mp4";
    }

    public static String getPictureUrl() {
        return f2386d + f2384b;
    }

    public static Bitmap getTransparentBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = (i * 255) / 100;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = (i2 << 24) | (iArr[i3] & ViewCompat.MEASURED_SIZE_MASK);
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    public static String getVideoUrl() {
        generateVideoName();
        return f2386d + f2385c;
    }

    public static int getWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT <= 12) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static Bitmap imageCrop(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmap2 = bitmap;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2, (bitmap.getWidth() - i) / 2, (bitmap.getHeight() - i2) / 2, i, i2, (Matrix) null, false);
        if (z && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap imageCrop(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width > height ? height : width;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, width > height ? (width - height) / 2 : 0, width > height ? 0 : (height - width) / 2, i, i, (Matrix) null, false);
        if (z && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean isSupportVideoType(String str) {
        String[] strArr = {".mp4"};
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            for (String endsWith : strArr) {
                if (str.endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUTF8(String str) {
        if (str == null) {
            return false;
        }
        try {
            str.getBytes(IoUtils.UTF_8);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean needCropSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int min = Math.min(defaultDisplay.getHeight(), defaultDisplay.getWidth());
        int max = Math.max(defaultDisplay.getHeight(), defaultDisplay.getWidth());
        float f = (((float) max) * 1.0f) / ((float) min);
        ARLog.m2696e("bdar: screenRatio = " + f);
        if (max * 9 == min * 16) {
            return true;
        }
        return max * 3 != min * 4 && Float.compare(f, 1.5555556f) > 0;
    }

    public static void openBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap rawByte2RGBABitmap(int i, int i2, byte[] bArr) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                byte b = bArr[i6] & 255;
                int i7 = ((i4 >> 1) * i) + i3 + (i5 & -2);
                byte b2 = bArr[i7 + 0] & 255;
                byte b3 = bArr[i7 + 1] & 255;
                if (b < 16) {
                    b = 16;
                }
                float f = ((float) (b - 16)) * 1.164f;
                float f2 = (float) (b3 - 128);
                int round = Math.round((1.596f * f2) + f);
                float f3 = (float) (b2 - 128);
                int round2 = Math.round((f - (f2 * 0.813f)) - (0.391f * f3));
                int round3 = Math.round(f + (f3 * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    round3 = 0;
                } else if (round3 > 255) {
                    round3 = 255;
                }
                iArr[i6] = (round3 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static Bitmap reversalBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        matrix.postTranslate(0.0f, (float) bitmap.getHeight());
        canvas.drawBitmap(bitmap, matrix, new Paint());
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap rotaingImageView(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static File saveBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        m2748a();
        File file = new File(f2386d, m2749b());
        try {
            file.createNewFile();
            saveBitmap(bitmap, file, 50);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022 A[SYNTHETIC, Splitter:B:16:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC, Splitter:B:22:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File saveBitmap(android.graphics.Bitmap r2, java.io.File r3, int r4) {
        /*
            r4 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001c }
            r0.<init>(r3)     // Catch:{ Exception -> 0x001c }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0017, all -> 0x0014 }
            r1 = 50
            r2.compress(r4, r1, r0)     // Catch:{ Exception -> 0x0017, all -> 0x0014 }
            r0.flush()     // Catch:{ IOException -> 0x0029 }
            r0.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0014:
            r2 = move-exception
            r4 = r0
            goto L_0x002e
        L_0x0017:
            r2 = move-exception
            r4 = r0
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            goto L_0x002e
        L_0x001c:
            r2 = move-exception
        L_0x001d:
            r2.printStackTrace()     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x002d
            r4.flush()     // Catch:{ IOException -> 0x0029 }
            r4.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002d:
            return r3
        L_0x002e:
            if (r4 == 0) goto L_0x003b
            r4.flush()     // Catch:{ IOException -> 0x0037 }
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.C0919Utils.saveBitmap(android.graphics.Bitmap, java.io.File, int):java.io.File");
    }

    public static String saveBitmap(Bitmap bitmap, String str, String str2) {
        if (bitmap == null) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = file.getAbsolutePath() + File.separator + str2;
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveBitmap(bitmap, file2, 50);
        return str3;
    }

    public static String saveBitmap(String str, Bitmap bitmap, int i) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return str;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            saveBitmap(bitmap, file, i);
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveToHideFile(Bitmap bitmap) {
        if (bitmap != null) {
            m2748a();
            File file = new File(f2386d, ".AR_Screenshot.jpg");
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            saveBitmap(bitmap, file, 50);
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static void share(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.addFlags(268435456);
            context.startActivity(Intent.createChooser(intent, "分享"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap transparentBitmap(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAlpha(30);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.save(31);
        canvas.restore();
        if (!(createBitmap == bitmap || bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
