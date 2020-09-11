package com.meizu.cloud.pushsdk.notification.util;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class FileUtil {
    public static final String TAG = "FileUtil";

    public static void copyFile(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[1444];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFolder(String str, String str2) {
        File file;
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i = 0; i < list.length; i++) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + list[i]);
                } else {
                    file = new File(str + File.separator + list[i]);
                }
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName().toString());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    copyFolder(str + "/" + list[i], str2 + "/" + list[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static File[] listFile(String str, final String str2) {
        File file = new File(str);
        return file.isDirectory() ? file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                try {
                    if (Long.valueOf(str2).longValue() > Long.valueOf(file.getName().split("-")[1]).longValue()) {
                        return true;
                    }
                    return false;
                } catch (Exception e) {
                    DebugLogger.m4828e(FileUtil.TAG, "filters file error " + e.getMessage());
                    return true;
                }
            }
        }) : new File[0];
    }

    public static boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteDirectory(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        if (!z) {
            return false;
        }
        return file.delete();
    }

    public static long getDirSize(File file) {
        long j = 0;
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                j += file2.length();
            } else if (file2.isDirectory()) {
                j = j + file2.length() + getDirSize(file2);
            }
        }
        return j;
    }

    public static String formatFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j < 1024) {
            return decimalFormat.format((double) j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(((double) j) / 1024.0d) + "KB";
        } else if (j < 1073741824) {
            return decimalFormat.format(((double) j) / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(((double) j) / 1.073741824E9d) + "G";
        }
    }
}
