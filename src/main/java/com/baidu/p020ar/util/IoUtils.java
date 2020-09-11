package com.baidu.p020ar.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.util.IoUtils */
public class IoUtils {
    public static final String UTF_8 = "utf-8";

    /* renamed from: com.baidu.ar.util.IoUtils$Cancelable */
    public interface Cancelable {
        boolean isCancelled();
    }

    /* renamed from: com.baidu.ar.util.IoUtils$Operation */
    public interface Operation extends Cancelable, ProgressListener {
    }

    /* renamed from: com.baidu.ar.util.IoUtils$ProgressListener */
    public interface ProgressListener {
        void progress(long j, long j2);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyStream(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = FileUtils.openFileOutputStream(file);
            try {
                copyStream(inputStream, (OutputStream) fileOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static void copyStream(InputStream inputStream, File file, long j, ProgressListener progressListener) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = FileUtils.openFileOutputStream(file);
            try {
                copyStream(inputStream, (OutputStream) fileOutputStream, j, progressListener);
                closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static void copyStream(InputStream inputStream, File file, Cancelable cancelable) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = FileUtils.openFileOutputStream(file);
            try {
                copyStream(inputStream, (OutputStream) fileOutputStream, cancelable);
                closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, Operation operation) {
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
                if (operation != null) {
                    operation.progress(j2, j);
                    if (operation.isCancelled()) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, final ProgressListener progressListener) {
        copyStream(inputStream, outputStream, j, (Operation) new Operation() {
            public boolean isCancelled() {
                return false;
            }

            public void progress(long j, long j2) {
                if (progressListener != null) {
                    progressListener.progress(j, j2);
                }
            }
        });
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, final Cancelable cancelable) {
        copyStream(inputStream, outputStream, 0, (Operation) new Operation() {
            public boolean isCancelled() {
                return cancelable != null && cancelable.isCancelled();
            }

            public void progress(long j, long j2) {
            }
        });
    }

    public static String loadContent(InputStream inputStream) {
        return loadContent(inputStream, (String) null);
    }

    public static String loadContent(InputStream inputStream, String str) {
        if (inputStream != null) {
            if (TextUtils.isEmpty(str)) {
                str = System.getProperty("file.encoding", UTF_8);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[4096];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            inputStreamReader.close();
            stringWriter.close();
            return (!UTF_8.equalsIgnoreCase(str) || !stringWriter2.startsWith("﻿")) ? stringWriter2 : stringWriter2.substring(1);
        }
        throw new IllegalArgumentException("stream may not be null.");
    }

    public static List<String> loadLineContent(InputStream inputStream) {
        return loadLineContent(inputStream, (String) null);
    }

    public static List<String> loadLineContent(InputStream inputStream, String str) {
        ArrayList arrayList = new ArrayList();
        if (inputStream != null) {
            if (TextUtils.isEmpty(str)) {
                str = System.getProperty("file.encoding", UTF_8);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    arrayList.add(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return arrayList;
                }
            }
        } else {
            throw new IllegalArgumentException("stream may not be null.");
        }
    }
}
