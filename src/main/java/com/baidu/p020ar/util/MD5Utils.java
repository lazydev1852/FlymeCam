package com.baidu.p020ar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.baidu.ar.util.MD5Utils */
public class MD5Utils {

    /* renamed from: a */
    private static char[] f2371a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static MessageDigest f2372b;

    static {
        try {
            f2372b = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException e) {
            PrintStream printStream = System.err;
            printStream.println(MD5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static String m2722a(byte[] bArr) {
        return m2723a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private static String m2723a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            m2724a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m2724a(byte b, StringBuffer stringBuffer) {
        char c = f2371a[(b & 240) >> 4];
        char c2 = f2371a[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String fileToMD5(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                        IoUtils.closeQuietly(fileInputStream);
                        return bigInteger;
                    } else if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                }
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

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a A[SYNTHETIC, Splitter:B:16:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMD5String(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0027 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0028 }
        L_0x000a:
            int r2 = r1.read(r5)     // Catch:{ IOException -> 0x0028 }
            if (r2 <= 0) goto L_0x0017
            java.security.MessageDigest r3 = f2372b     // Catch:{ IOException -> 0x0028 }
            r4 = 0
            r3.update(r5, r4, r2)     // Catch:{ IOException -> 0x0028 }
            goto L_0x000a
        L_0x0017:
            r1.close()     // Catch:{ IOException -> 0x0028 }
            java.security.MessageDigest r5 = f2372b     // Catch:{ IOException -> 0x0028 }
            byte[] r5 = r5.digest()     // Catch:{ IOException -> 0x0028 }
            java.lang.String r5 = m2722a(r5)     // Catch:{ IOException -> 0x0028 }
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0033
        L_0x0027:
            r1 = r0
        L_0x0028:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0034
        L_0x002e:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0025 }
            goto L_0x0034
        L_0x0033:
            throw r5
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.MD5Utils.getFileMD5String(java.io.File):java.lang.String");
    }

    public static String getFileMD5StringOld(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        fileInputStream.close();
        f2372b.update(map);
        return m2722a(f2372b.digest());
    }

    public static synchronized String getMD5String(String str) {
        String mD5String;
        synchronized (MD5Utils.class) {
            mD5String = getMD5String(str.getBytes(Charset.forName(IoUtils.UTF_8)));
        }
        return mD5String;
    }

    public static String getMD5String(byte[] bArr) {
        f2372b.update(bArr);
        return m2722a(f2372b.digest());
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
