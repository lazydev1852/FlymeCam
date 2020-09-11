package com.meizu.media.mzfunnysnapsdk.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.p020ar.parser.ARResourceKey;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConUtil {
    public static ChangeQuickRedirect changeQuickRedirect;
    public static PowerManager.WakeLock wakeLock;

    public static String getFormatterDate(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9383, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }

    public static Bitmap decodeToBitMap(byte[] bArr, Camera camera) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, camera}, (Object) null, changeQuickRedirect, true, 9384, new Class[]{byte[].class, Camera.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, previewSize.width, previewSize.height, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 80, byteArrayOutputStream);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            return decodeByteArray;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void isGoneKeyBoard(Activity activity) {
        if (!PatchProxy.proxy(new Object[]{activity}, (Object) null, changeQuickRedirect, true, 9385, new Class[]{Activity.class}, Void.TYPE).isSupported && activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void acquireWakeLock(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, changeQuickRedirect, true, 9386, new Class[]{Context.class}, Void.TYPE).isSupported && wakeLock == null) {
            wakeLock = ((PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER)).newWakeLock(6, "My Tag");
            wakeLock.acquire();
        }
    }

    public static void releaseWakeLock() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9387, new Class[0], Void.TYPE).isSupported && wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
            wakeLock = null;
        }
    }

    public static byte[] getGrayscale(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, changeQuickRedirect, true, 9388, new Class[]{Bitmap.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        for (int i = 0; i < bitmap.getHeight(); i++) {
            for (int i2 = 0; i2 < bitmap.getWidth(); i2++) {
                int pixel = bitmap.getPixel(i2, i);
                bArr[(bitmap.getWidth() * i) + i2] = (byte) ((((((16711680 & pixel) >> 16) * 299) + (((65280 & pixel) >> 8) * 587)) + ((pixel & 255) * 114)) / 1000);
            }
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getFileContent(android.content.Context r9, int r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r3 = 1
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r8] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r3] = r0
            java.lang.Class<byte[]> r7 = byte[].class
            r2 = 0
            r0 = 1
            r5 = 9389(0x24ad, float:1.3157E-41)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002f
            java.lang.Object r9 = r0.result
            byte[] r9 = (byte[]) r9
            return r9
        L_0x002f:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            java.io.InputStream r9 = r9.openRawResource(r10)     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
        L_0x0040:
            int r10 = r9.read(r1)     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            r2 = -1
            if (r10 == r2) goto L_0x004b
            r0.write(r1, r8, r10)     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            goto L_0x0040
        L_0x004b:
            r0.close()     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            byte[] r9 = r0.toByteArray()
            return r9
        L_0x0053:
            r9 = move-exception
            throw r9
        L_0x0055:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.Utils.ConUtil.getFileContent(android.content.Context, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getFileContentAssets(android.content.Context r9, java.lang.String r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            r2 = 1
            r1[r2] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class<byte[]> r7 = byte[].class
            r2 = 0
            r4 = 1
            r5 = 9390(0x24ae, float:1.3158E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0028
            java.lang.Object r9 = r0.result
            byte[] r9 = (byte[]) r9
            return r9
        L_0x0028:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            java.io.InputStream r9 = r9.open(r10)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
        L_0x003d:
            int r10 = r9.read(r1)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            r2 = -1
            if (r10 == r2) goto L_0x0048
            r0.write(r1, r8, r10)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            goto L_0x003d
        L_0x0048:
            r0.close()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            byte[] r9 = r0.toByteArray()
            return r9
        L_0x0050:
            r9 = move-exception
            throw r9
        L_0x0052:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.Utils.ConUtil.getFileContentAssets(android.content.Context, java.lang.String):byte[]");
    }

    public static boolean copyFaceModelDataToSD(Context context, String str) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, (Object) null, changeQuickRedirect, true, 9391, new Class[]{Context.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new File(str).exists()) {
                return true;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            InputStream open = context.getAssets().open(GlobalParams.ARCSOFT_FACE_MODEL_FILE_NAME);
            byte[] bArr = new byte[1024];
            for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            open.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            Log.e("ConUtil", "transfer face model to sd - ERROR!" + e.getMessage());
            return false;
        }
    }

    public static void showToast(Context context, String str) {
        if (!PatchProxy.proxy(new Object[]{context, str}, (Object) null, changeQuickRedirect, true, 9392, new Class[]{Context.class, String.class}, Void.TYPE).isSupported && context != null) {
            Toast makeText = Toast.makeText(context, str, 0);
            makeText.setGravity(48, 0, 30);
            makeText.show();
        }
    }

    public static void showLongToast(Context context, String str) {
        if (!PatchProxy.proxy(new Object[]{context, str}, (Object) null, changeQuickRedirect, true, 9393, new Class[]{Context.class, String.class}, Void.TYPE).isSupported && context != null) {
            Toast makeText = Toast.makeText(context, str, 1);
            makeText.setGravity(48, 0, 30);
            makeText.show();
        }
    }

    public static String getVersionName(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, changeQuickRedirect, true, 9394, new Class[]{Context.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap convert(Bitmap bitmap, boolean z) {
        Object[] objArr = {bitmap, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9395, new Class[]{Bitmap.class, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        canvas.drawBitmap(createBitmap2, new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
        return createBitmap;
    }

    public static String saveBitmap(Context context, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, bitmap}, (Object) null, changeQuickRedirect, true, 9396, new Class[]{Context.class, Bitmap.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir("megvii");
        if (!externalFilesDir.exists() && !externalFilesDir.mkdirs()) {
            return null;
        }
        String str = System.currentTimeMillis() + "";
        try {
            fileOutputStream = new FileOutputStream(externalFilesDir + "/" + str);
            try {
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream)) {
                    String str2 = externalFilesDir.getAbsolutePath() + "/" + str;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str2;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream = null;
            e.printStackTrace();
            fileOutputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileOutputStream.close();
            throw th;
        }
    }

    public static float points2angle(float f, float f2, float f3, float f4) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), new Float(f3), new Float(f4)}, (Object) null, changeQuickRedirect, true, 9397, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        double atan = (Math.atan((double) ((f2 - f4) / (f - f3))) * 180.0d) / 3.141592653589793d;
        int i = (f3 > f ? 1 : (f3 == f ? 0 : -1));
        if (i > 0 && f4 <= f2) {
            atan += 180.0d;
        }
        if (f3 <= f && f4 > f2) {
            atan += 360.0d;
        }
        if (i > 0 && f4 > f2) {
            atan += 180.0d;
        }
        return (float) atan;
    }

    public static float points2distance(float f, float f2, float f3, float f4) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), new Float(f3), new Float(f4)}, (Object) null, changeQuickRedirect, true, 9398, new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}
