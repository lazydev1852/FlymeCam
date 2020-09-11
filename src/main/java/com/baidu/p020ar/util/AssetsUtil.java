package com.baidu.p020ar.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.baidu.ar.util.AssetsUtil */
public final class AssetsUtil {
    private AssetsUtil() {
    }

    /* renamed from: a */
    private static String m2703a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static boolean copyAssetFile(Context context, String str, File file) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                IoUtils.copyStream(open, file);
                IoUtils.closeQuietly(open);
                return true;
            } catch (IOException e) {
                e = e;
                inputStream = open;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(inputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = open;
                IoUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            IoUtils.closeQuietly(inputStream);
            return false;
        }
    }

    public static String getFileHeader(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4];
                fileInputStream.read(bArr, 0, bArr.length);
                String upperCase = m2703a(bArr).toUpperCase();
                IoUtils.closeQuietly(fileInputStream);
                return upperCase;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            e.printStackTrace();
            IoUtils.closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            IoUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static String getFromAssets(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                String loadContent = IoUtils.loadContent(open);
                IoUtils.closeQuietly(open);
                return loadContent;
            } catch (Exception unused) {
                inputStream = open;
                IoUtils.closeQuietly(inputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                inputStream = open;
                IoUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception unused2) {
            IoUtils.closeQuietly(inputStream);
            return "";
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    public static Bitmap getImageFromAssets(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                IoUtils.closeQuietly(inputStream);
                return decodeStream;
            } catch (IOException unused) {
                IoUtils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                IoUtils.closeQuietly(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            IoUtils.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(inputStream2);
            throw th;
        }
    }

    public static boolean isImage(String str) {
        String fileHeader = getFileHeader(str);
        if (fileHeader != null) {
            return fileHeader.contains("FFD8FF") || fileHeader.contains("89504E47") || fileHeader.contains("47494638") || fileHeader.contains("49492A00") || fileHeader.contains("424D");
        }
        return false;
    }

    public static byte[] readBitmap(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        decodeFile.recycle();
        return byteArrayOutputStream.toByteArray();
    }
}
