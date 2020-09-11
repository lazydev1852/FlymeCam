package com.baidu.p020ar.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.util.FileUtils */
public final class FileUtils {
    private FileUtils() {
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static void deleteDir(File file, boolean z) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean deleteFileIfExist(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void ensureDir(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                return;
            }
        }
        file.mkdirs();
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.mkdirs();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file != null && (parentFile = file.getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean existsDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean existsDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsDir(new File(str));
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static ArrayList<File> getChildFiles(File file) {
        File[] listFiles = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                } else {
                    getChildFiles(file2);
                }
            }
        }
        return arrayList;
    }

    public static String getFileExtention(String str) {
        int lastIndexOf;
        if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(".")) <= -1 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static FileOutputStream openFileOutputStream(File file) {
        deleteFileIfExist(file);
        ensureParent(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static List<String> readFileLineText(File file) {
        FileInputStream fileInputStream;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                IoUtils.closeQuietly(fileInputStream);
                fileInputStream.close();
                throw th;
            }
            try {
                List<String> loadLineContent = IoUtils.loadLineContent(fileInputStream);
                IoUtils.closeQuietly(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return loadLineContent;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream);
                fileInputStream.close();
                return null;
            }
        }
        return null;
    }

    public static List<String> readFileLineText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileLineText(new File(str));
    }

    public static String readFileText(File file) {
        FileInputStream fileInputStream;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                IoUtils.closeQuietly(fileInputStream);
                fileInputStream.close();
                throw th;
            }
            try {
                String loadContent = IoUtils.loadContent(fileInputStream);
                IoUtils.closeQuietly(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return loadContent;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream);
                fileInputStream.close();
                return null;
            }
        }
        return null;
    }

    public static String readFileText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileText(new File(str));
    }
}
