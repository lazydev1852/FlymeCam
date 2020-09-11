package com.baidu.p020ar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* renamed from: com.baidu.ar.util.ZipUtils */
public class ZipUtils {
    /* renamed from: a */
    private static void m2750a(ZipInputStream zipInputStream, File file) {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                File file2 = new File(file, nextEntry.getName());
                FileUtils.ensureParent(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    IoUtils.copyStream((InputStream) zipInputStream, file2);
                }
                zipInputStream.closeEntry();
            } else {
                return;
            }
        }
    }

    public static void closeZipFile(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean isZipFile(String str) {
        try {
            closeZipFile(new ZipFile(str));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            closeZipFile((ZipFile) null);
            return false;
        } catch (Throwable th) {
            closeZipFile((ZipFile) null);
            throw th;
        }
    }

    public static boolean unzip(File file, File file2) {
        ZipInputStream zipInputStream = null;
        try {
            ZipInputStream zipInputStream2 = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
            try {
                m2750a(zipInputStream2, file2);
                IoUtils.closeQuietly(zipInputStream2);
                return true;
            } catch (IOException e) {
                e = e;
                zipInputStream = zipInputStream2;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(zipInputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(zipInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = zipInputStream2;
                IoUtils.closeQuietly(zipInputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            IoUtils.closeQuietly(zipInputStream);
            return false;
        }
    }
}
