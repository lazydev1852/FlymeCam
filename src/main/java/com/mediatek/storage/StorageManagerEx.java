package com.mediatek.storage;

import android.os.Environment;
import android.os.SystemProperties;
import android.util.Log;
import java.io.File;

public class StorageManagerEx {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String PROP_2SDCARD_SWAP = "ro.mtk_2sdcard_swap";
    private static final String PROP_DEVICE_TABLET = "tablet";
    private static final String PROP_DEVICE_TYPE = "ro.build.characteristics";
    private static final String PROP_SD_DEFAULT_PATH = "persist.sys.sd.defaultpath";
    private static final String PROP_SD_EXTERNAL_PATH = "vold.path.external_sd";
    private static final String PROP_SD_INTERNAL_PATH = "vold.path.internal_sd";
    private static final String PROP_SD_SWAP = "vold.swap.state";
    private static final String PROP_SD_SWAP_FALSE = "0";
    private static final String PROP_SD_SWAP_TRUE = "1";
    private static final String PROP_SHARED_SDCARD = "ro.mtk_shared_sdcard";
    private static final String STORAGE_PATH_EMULATED = "/storage/emulated/";
    private static final String STORAGE_PATH_SD1 = "/storage/sdcard0";
    private static final String STORAGE_PATH_SD1_ICS = "/mnt/sdcard";
    private static final String STORAGE_PATH_SD2 = "/storage/sdcard1";
    private static final String STORAGE_PATH_SD2_ICS = "/mnt/sdcard2";
    private static final String STORAGE_PATH_SHARE_SD = "/storage/emulated/0";
    private static final String TAG = "StorageManagerEx";

    public static String getDefaultPath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i(TAG, " Default path taken as primary storage, path=" + absolutePath);
        return absolutePath;
    }

    public static void setDefaultPath(String str) {
        Log.i(TAG, "setDefaultPath path=" + str);
        if (str == null) {
            Log.e(TAG, "setDefaultPath error! path=null");
            return;
        }
        try {
            SystemProperties.set(PROP_SD_DEFAULT_PATH, str);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "IllegalArgumentException when set default path:" + e);
        }
    }

    public static File getExternalCacheDir(String str) {
        if (str == null) {
            Log.w(TAG, "packageName = null!");
            return null;
        }
        File buildPath = Environment.buildPath(new File(getDefaultPath()), new String[]{DIR_ANDROID, DIR_DATA, str, DIR_CACHE});
        Log.d(TAG, "getExternalCacheDir path = " + buildPath);
        return buildPath;
    }

    public static String getExternalStoragePath() {
        String str;
        IllegalArgumentException e;
        try {
            str = SystemProperties.get(PROP_SD_EXTERNAL_PATH);
            try {
                Log.i(TAG, "getExternalStoragePath path=" + str);
            } catch (IllegalArgumentException e2) {
                e = e2;
            }
        } catch (IllegalArgumentException e3) {
            IllegalArgumentException illegalArgumentException = e3;
            str = null;
            e = illegalArgumentException;
            Log.e(TAG, "IllegalArgumentException when getExternalStoragePath:" + e);
            Log.d(TAG, "getExternalStoragePath path=" + str);
            return str;
        }
        Log.d(TAG, "getExternalStoragePath path=" + str);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getInternalStoragePath() {
        /*
            r0 = 0
            java.lang.String r1 = "vold.path.internal_sd"
            java.lang.String r1 = android.os.SystemProperties.get(r1)     // Catch:{ IllegalArgumentException -> 0x0020 }
            java.lang.String r0 = "StorageManagerEx"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x001e }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x001e }
            java.lang.String r3 = "getInternalStoragePath from Property path="
            r2.append(r3)     // Catch:{ IllegalArgumentException -> 0x001e }
            r2.append(r1)     // Catch:{ IllegalArgumentException -> 0x001e }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalArgumentException -> 0x001e }
            android.util.Log.i(r0, r2)     // Catch:{ IllegalArgumentException -> 0x001e }
            goto L_0x003a
        L_0x001e:
            r0 = move-exception
            goto L_0x0024
        L_0x0020:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0024:
            java.lang.String r2 = "StorageManagerEx"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "IllegalArgumentException when getInternalStoragePath:"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
        L_0x003a:
            java.lang.String r0 = "ro.mtk_shared_sdcard"
            java.lang.String r0 = android.os.SystemProperties.get(r0)
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0084
            java.lang.String r0 = "ro.mtk_2sdcard_swap"
            java.lang.String r0 = android.os.SystemProperties.get(r0)
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = "/storage/sdcard0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0084
            int r0 = android.os.Process.myUid()
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 != r1) goto L_0x007c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "/storage/emulated/"
            r0.append(r2)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0084
        L_0x007c:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r0.toString()
        L_0x0084:
            java.lang.String r0 = "StorageManagerEx"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getInternalStoragePath path="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.storage.StorageManagerEx.getInternalStoragePath():java.lang.String");
    }

    public static String getInternalStoragePathForLogger() {
        String internalStoragePath = getInternalStoragePath();
        Log.i(TAG, "getInternalStoragePathForLogger raw path=" + internalStoragePath);
        if (internalStoragePath != null && internalStoragePath.startsWith(STORAGE_PATH_EMULATED)) {
            internalStoragePath = STORAGE_PATH_SHARE_SD;
        }
        Log.i(TAG, "getInternalStoragePathForLogger path=" + internalStoragePath);
        return internalStoragePath;
    }
}
