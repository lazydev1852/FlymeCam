package com.baidu.p020ar.util;

import android.content.ContentResolver;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.baidu.ar.util.ARFileUtils */
public final class ARFileUtils {
    public static final String AR_UNZIP_ROOT_DIR = "ar";

    /* renamed from: a */
    private static String f2353a;

    private ARFileUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A[SYNTHETIC, Splitter:B:39:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081 A[Catch:{ IOException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086 A[Catch:{ IOException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097 A[SYNTHETIC, Splitter:B:54:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009f A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a4 A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b0 A[SYNTHETIC, Splitter:B:67:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b8 A[Catch:{ IOException -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd A[Catch:{ IOException -> 0x00b4 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x0092=Splitter:B:51:0x0092, B:36:0x0074=Splitter:B:36:0x0074} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashSet<java.lang.String> m2693a(java.lang.String r5) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r1 = r1.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008e, IOException -> 0x0070, all -> 0x006c }
            r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x008e, IOException -> 0x0070, all -> 0x006c }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0064, all -> 0x0061 }
            java.lang.String r3 = "UTF-8"
            r5.<init>(r1, r3)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0064, all -> 0x0061 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, all -> 0x0058 }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, all -> 0x0058 }
        L_0x0023:
            java.lang.String r4 = r3.readLine()     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0054 }
            if (r4 == 0) goto L_0x002d
            r0.add(r4)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0054 }
            goto L_0x0023
        L_0x002d:
            r3.close()     // Catch:{ IOException -> 0x0037 }
            r5.close()     // Catch:{ IOException -> 0x0037 }
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "keysSet size is "
            r5.append(r1)
            int r1 = r0.size()
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.baidu.p020ar.util.ARLog.m2695d(r5)
            return r0
        L_0x0054:
            r0 = move-exception
            goto L_0x0074
        L_0x0056:
            r0 = move-exception
            goto L_0x0092
        L_0x0058:
            r0 = move-exception
            goto L_0x00ae
        L_0x005b:
            r0 = move-exception
            r3 = r2
            goto L_0x0074
        L_0x005e:
            r0 = move-exception
            r3 = r2
            goto L_0x0092
        L_0x0061:
            r0 = move-exception
            r5 = r2
            goto L_0x00ae
        L_0x0064:
            r0 = move-exception
            r5 = r2
            r3 = r5
            goto L_0x0074
        L_0x0068:
            r0 = move-exception
            r5 = r2
            r3 = r5
            goto L_0x0092
        L_0x006c:
            r0 = move-exception
            r5 = r2
            r1 = r5
            goto L_0x00ae
        L_0x0070:
            r0 = move-exception
            r5 = r2
            r1 = r5
            r3 = r1
        L_0x0074:
            r0.printStackTrace()     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x007f
            r3.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x007f
        L_0x007d:
            r5 = move-exception
            goto L_0x008a
        L_0x007f:
            if (r5 == 0) goto L_0x0084
            r5.close()     // Catch:{ IOException -> 0x007d }
        L_0x0084:
            if (r1 == 0) goto L_0x008d
            r1.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x008d
        L_0x008a:
            r5.printStackTrace()
        L_0x008d:
            return r2
        L_0x008e:
            r0 = move-exception
            r5 = r2
            r1 = r5
            r3 = r1
        L_0x0092:
            r0.printStackTrace()     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x009d
            r3.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r5 = move-exception
            goto L_0x00a8
        L_0x009d:
            if (r5 == 0) goto L_0x00a2
            r5.close()     // Catch:{ IOException -> 0x009b }
        L_0x00a2:
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00ab
        L_0x00a8:
            r5.printStackTrace()
        L_0x00ab:
            return r2
        L_0x00ac:
            r0 = move-exception
            r2 = r3
        L_0x00ae:
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00b6
        L_0x00b4:
            r5 = move-exception
            goto L_0x00c1
        L_0x00b6:
            if (r5 == 0) goto L_0x00bb
            r5.close()     // Catch:{ IOException -> 0x00b4 }
        L_0x00bb:
            if (r1 == 0) goto L_0x00c4
            r1.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00c4
        L_0x00c1:
            r5.printStackTrace()
        L_0x00c4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.ARFileUtils.m2693a(java.lang.String):java.util.HashSet");
    }

    /* renamed from: a */
    private static void m2694a(ContentResolver contentResolver, String str) {
        if (contentResolver != null && !TextUtils.isEmpty(str)) {
            String str2 = "_data LIKE '" + str + "%'";
            contentResolver.delete(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
            contentResolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
            contentResolver.delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
        }
    }

    public static boolean checkKeyInFile(String str, String str2) {
        HashSet<String> a = m2693a(getARCachePath() + File.separator + str2);
        if (a == null) {
            return false;
        }
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean equals = str.equals(next);
            ARLog.m2695d("item = " + next + ", key = " + str + ", result = " + equals);
            if (equals) {
                return true;
            }
        }
        return false;
    }

    public static void deleteARCache() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ARFileUtils.deleteDir(new File(ARFileUtils.getARCachePath()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String getARCacheLogPath() {
        String aRCachePath = getARCachePath();
        if (aRCachePath == null) {
            return null;
        }
        return aRCachePath + "/log";
    }

    public static String getARCachePath() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "AR" + "/.ARResource" + File.separator + getPackageName();
    }

    public static String getARCaseDirPath(String str) {
        String aRCachePath = getARCachePath();
        if (aRCachePath == null) {
            return null;
        }
        return aRCachePath + File.separator + "bar_" + str;
    }

    public static String getARCaseFullPath(String str) {
        String aRCaseDirPath = getARCaseDirPath(str);
        if (aRCaseDirPath == null) {
            return null;
        }
        return aRCaseDirPath + File.separator + AR_UNZIP_ROOT_DIR;
    }

    public static String getARCaseMainZipFullPath(String str, String str2) {
        String aRCaseTempDir = getARCaseTempDir(str);
        if (aRCaseTempDir == null) {
            return null;
        }
        return aRCaseTempDir + File.separator + "main_" + str2 + ".zip";
    }

    public static String getARCaseTempDir(String str) {
        String aRCaseDirPath = getARCaseDirPath(str);
        if (aRCaseDirPath == null) {
            return null;
        }
        return aRCaseDirPath + File.separator + "temp";
    }

    public static String getDefaultJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/" + "res/default.json";
    }

    public static String getDumixResJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/" + "dumix_res.json";
    }

    public static File getImageCacheDir() {
        String aRCachePath = getARCachePath();
        if (aRCachePath == null) {
            return null;
        }
        File file = new File(aRCachePath, "image_cache");
        FileUtils.ensureDir(file);
        return file;
    }

    public static String getPackageName() {
        return f2353a;
    }

    public static String getResConfigJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/" + "res_config.json";
    }

    public static String getTargetJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/" + "targets.json";
    }

    public static String getVoiceFilePath(String str) {
        return getARCaseFullPath(str) + "/" + "res/voice.json";
    }

    public static void hideARResourceFile(ContentResolver contentResolver) {
        boolean renameTo;
        StringBuilder sb;
        String str;
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "AR";
        File file = new File(str2 + "/ARResource");
        if (file.exists()) {
            File file2 = new File(str2 + "/.ARResource");
            if (file2.exists()) {
                renameTo = deleteDir(file);
                sb = new StringBuilder();
                str = "hideARResourceFile deleteDir result = ";
            } else {
                renameTo = file.renameTo(file2);
                sb = new StringBuilder();
                str = "hideARResourceFile renameTo result = ";
            }
            sb.append(str);
            sb.append(renameTo);
            ARLog.m2697i(sb.toString());
            if (renameTo) {
                m2694a(contentResolver, file.getPath());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094 A[SYNTHETIC, Splitter:B:49:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0099 A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00aa A[SYNTHETIC, Splitter:B:60:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00af A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4 A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c0 A[SYNTHETIC, Splitter:B:71:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c8 A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00cd A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d8 A[SYNTHETIC, Splitter:B:82:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00e0 A[Catch:{ IOException -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00e5 A[Catch:{ IOException -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x00a5=Splitter:B:57:0x00a5, B:68:0x00bb=Splitter:B:68:0x00bb, B:46:0x008f=Splitter:B:46:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void putKeyToFile(java.lang.String r3, java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = getARCachePath()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0012
            r0.mkdirs()
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = getARCachePath()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x003d
            r1.createNewFile()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003d:
            boolean r4 = checkKeyInFile(r3, r4)
            if (r4 == 0) goto L_0x0044
            return
        L_0x0044:
            r4 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00b8, UnsupportedEncodingException -> 0x00a2, IOException -> 0x008c, all -> 0x0088 }
            r2 = 1
            r1.<init>(r0, r2)     // Catch:{ FileNotFoundException -> 0x00b8, UnsupportedEncodingException -> 0x00a2, IOException -> 0x008c, all -> 0x0088 }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x0082, IOException -> 0x007f, all -> 0x007b }
            java.lang.String r2 = "UTF-8"
            r0.<init>(r1, r2)     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x0082, IOException -> 0x007f, all -> 0x007b }
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0079, UnsupportedEncodingException -> 0x0077, IOException -> 0x0075 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0079, UnsupportedEncodingException -> 0x0077, IOException -> 0x0075 }
            r2.write(r3)     // Catch:{ FileNotFoundException -> 0x0072, UnsupportedEncodingException -> 0x006f, IOException -> 0x006c, all -> 0x0068 }
            r2.newLine()     // Catch:{ FileNotFoundException -> 0x0072, UnsupportedEncodingException -> 0x006f, IOException -> 0x006c, all -> 0x0068 }
            r2.close()     // Catch:{ IOException -> 0x00c4 }
            r0.close()     // Catch:{ IOException -> 0x00c4 }
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00d4
        L_0x0068:
            r3 = move-exception
            r4 = r2
            goto L_0x00d6
        L_0x006c:
            r3 = move-exception
            r4 = r2
            goto L_0x008f
        L_0x006f:
            r3 = move-exception
            r4 = r2
            goto L_0x00a5
        L_0x0072:
            r3 = move-exception
            r4 = r2
            goto L_0x00bb
        L_0x0075:
            r3 = move-exception
            goto L_0x008f
        L_0x0077:
            r3 = move-exception
            goto L_0x00a5
        L_0x0079:
            r3 = move-exception
            goto L_0x00bb
        L_0x007b:
            r3 = move-exception
            r0 = r4
            goto L_0x00d6
        L_0x007f:
            r3 = move-exception
            r0 = r4
            goto L_0x008f
        L_0x0082:
            r3 = move-exception
            r0 = r4
            goto L_0x00a5
        L_0x0085:
            r3 = move-exception
            r0 = r4
            goto L_0x00bb
        L_0x0088:
            r3 = move-exception
            r0 = r4
            r1 = r0
            goto L_0x00d6
        L_0x008c:
            r3 = move-exception
            r0 = r4
            r1 = r0
        L_0x008f:
            r3.printStackTrace()     // Catch:{ all -> 0x00d5 }
            if (r4 == 0) goto L_0x0097
            r4.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r0.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x009c:
            if (r1 == 0) goto L_0x00d4
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00d4
        L_0x00a2:
            r3 = move-exception
            r0 = r4
            r1 = r0
        L_0x00a5:
            r3.printStackTrace()     // Catch:{ all -> 0x00d5 }
            if (r4 == 0) goto L_0x00ad
            r4.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00ad:
            if (r0 == 0) goto L_0x00b2
            r0.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00b2:
            if (r1 == 0) goto L_0x00d4
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00d4
        L_0x00b8:
            r3 = move-exception
            r0 = r4
            r1 = r0
        L_0x00bb:
            r3.printStackTrace()     // Catch:{ all -> 0x00d5 }
            if (r4 == 0) goto L_0x00c6
            r4.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c6
        L_0x00c4:
            r3 = move-exception
            goto L_0x00d1
        L_0x00c6:
            if (r0 == 0) goto L_0x00cb
            r0.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00cb:
            if (r1 == 0) goto L_0x00d4
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00d4
        L_0x00d1:
            r3.printStackTrace()
        L_0x00d4:
            return
        L_0x00d5:
            r3 = move-exception
        L_0x00d6:
            if (r4 == 0) goto L_0x00de
            r4.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00de
        L_0x00dc:
            r4 = move-exception
            goto L_0x00e9
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00e3:
            if (r1 == 0) goto L_0x00ec
            r1.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00ec
        L_0x00e9:
            r4.printStackTrace()
        L_0x00ec:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.ARFileUtils.putKeyToFile(java.lang.String, java.lang.String):void");
    }

    public static boolean sdCardAvailable() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1048576 >= 10;
    }

    public static void setPackageName(String str) {
        if (f2353a == null) {
            f2353a = str;
        }
    }
}
