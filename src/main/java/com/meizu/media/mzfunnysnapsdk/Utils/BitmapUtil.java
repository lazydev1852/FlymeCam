package com.meizu.media.mzfunnysnapsdk.Utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class BitmapUtil {
    public static ChangeQuickRedirect changeQuickRedirect;

    public static String getSD() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9376, new Class[0], String.class);
        return proxy.isSupported ? (String) proxy.result : Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean saveBitmap(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, changeQuickRedirect, true, 9377, new Class[]{Bitmap.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        String str = getSD() + "/0_MzFunnySnapDemo/";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str + System.currentTimeMillis() + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Float(f)}, (Object) null, changeQuickRedirect, true, 9378, new Class[]{Bitmap.class, Float.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    public static void saveBitmap(Bitmap bitmap, String str) throws IOException {
        Class[] clsArr = {Bitmap.class, String.class};
        if (!PatchProxy.proxy(new Object[]{bitmap, str}, (Object) null, changeQuickRedirect, true, 9379, clsArr, Void.TYPE).isSupported) {
            File file = new File(getSD() + "/DCIM/Camera/" + str);
            if (file.exists()) {
                file.delete();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String getCharacterAndNumber() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9380, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    }

    public static Bitmap flipBitmap(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, changeQuickRedirect, true, 9381, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[SYNTHETIC, Splitter:B:30:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089 A[Catch:{ IOException -> 0x0085 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap readZipFile(android.content.res.AssetManager r10, java.lang.String r11) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.res.AssetManager> r0 = android.content.res.AssetManager.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r4 = 1
            r5 = 9382(0x24a6, float:1.3147E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0028
            java.lang.Object r10 = r0.result
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            return r10
        L_0x0028:
            r0 = 0
            java.io.InputStream r10 = r10.open(r11)     // Catch:{ IOException -> 0x0079 }
            java.util.zip.ZipInputStream r11 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x0076 }
            r11.<init>(r10)     // Catch:{ IOException -> 0x0076 }
        L_0x0032:
            java.util.zip.ZipEntry r1 = r11.getNextEntry()     // Catch:{ IOException -> 0x0074 }
            if (r1 == 0) goto L_0x0090
            java.lang.String r2 = r1.getName()     // Catch:{ IOException -> 0x0074 }
            boolean r1 = r1.isDirectory()     // Catch:{ IOException -> 0x0074 }
            if (r1 == 0) goto L_0x0056
            int r1 = r2.length()     // Catch:{ IOException -> 0x0074 }
            int r1 = r1 - r9
            java.lang.String r1 = r2.substring(r8, r1)     // Catch:{ IOException -> 0x0074 }
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ IOException -> 0x0074 }
            int r2 = r2 + r9
            r1.substring(r2)     // Catch:{ IOException -> 0x0074 }
            goto L_0x0032
        L_0x0056:
            java.lang.String r1 = ".png"
            boolean r1 = r2.endsWith(r1)     // Catch:{ IOException -> 0x0074 }
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = ".jpg"
            boolean r1 = r2.endsWith(r1)     // Catch:{ IOException -> 0x0074 }
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = ".JPG"
            boolean r1 = r2.endsWith(r1)     // Catch:{ IOException -> 0x0074 }
            if (r1 == 0) goto L_0x0032
        L_0x006e:
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r11)     // Catch:{ IOException -> 0x0074 }
            r0 = r1
            goto L_0x0032
        L_0x0074:
            r1 = move-exception
            goto L_0x007c
        L_0x0076:
            r1 = move-exception
            r11 = r0
            goto L_0x007c
        L_0x0079:
            r1 = move-exception
            r10 = r0
            r11 = r10
        L_0x007c:
            r1.printStackTrace()
            if (r10 == 0) goto L_0x0087
            r10.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0087
        L_0x0085:
            r10 = move-exception
            goto L_0x008d
        L_0x0087:
            if (r11 == 0) goto L_0x0090
            r11.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0090
        L_0x008d:
            r10.printStackTrace()
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.Utils.BitmapUtil.readZipFile(android.content.res.AssetManager, java.lang.String):android.graphics.Bitmap");
    }
}
