package com.loc;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.loc.bu */
public final class Encrypt {

    /* renamed from: a */
    private static final char[] f2774a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final byte[] f2775b = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};

    /* renamed from: c */
    private static final IvParameterSpec f2776c = new IvParameterSpec(f2775b);

    /* renamed from: a */
    public static String m3206a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String a = m3207a("SHA1", str);
                    return m3207a(MessageDigestAlgorithms.MD5, a + str);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3207a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            byte[] a = MD5.m3761a(str2.getBytes("UTF-8"), str);
            int length = a.length;
            StringBuilder sb = new StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                sb.append(f2774a[(a[i] >> 4) & 15]);
                sb.append(f2774a[a[i] & 15]);
            }
            return sb.toString();
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Encrypt", "encode");
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m3208a(byte[] bArr) {
        int i = 0;
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(C1107dj.m3825c()));
            return instance.doFinal(bArr3);
        } catch (Throwable th) {
            if (bArr != null) {
                i = bArr.length;
            }
            CoreUtil.m3389a(th, "Encrypt", "decryptRsponse length = " + i);
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized byte[] m3209a(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (Encrypt.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C1102dd.m3744b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 245 ? instance.doFinal(bArr, i, 245) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 245;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    /* renamed from: a */
    public static byte[] m3210a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), f2776c);
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    private static SecretKeySpec m3211b(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: b */
    public static synchronized byte[] m3212b(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (Encrypt.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C1102dd.m3744b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 256 ? instance.doFinal(bArr, i, 256) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 256;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    /* renamed from: c */
    public static byte[] m3213c(byte[] bArr, String str) {
        try {
            SecretKeySpec b = m3211b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(C1107dj.m3825c());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, b, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m3214d(byte[] bArr, String str) {
        try {
            SecretKeySpec b = m3211b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(C1107dj.m3825c());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, b, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }
}
