package com.loc;

import com.meizu.savior.Constants;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.loc.dd */
/* compiled from: Encrypt */
public final class C1102dd {

    /* renamed from: a */
    private static final char[] f3294a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Constants.OBJECT_TYPE, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b */
    private static final byte[] f3295b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f3295b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f3295b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f3295b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f3295b[i4] = (byte) ((i4 - 48) + 52);
        }
        f3295b[43] = 62;
        f3295b[47] = 63;
    }

    /* renamed from: a */
    public static String m3738a(String str) {
        return C1107dj.m3810a(m3744b(str));
    }

    /* renamed from: a */
    public static byte[] m3739a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey d = C1107dj.m3828d();
        if (d == null) {
            return null;
        }
        byte[] a = m3740a(encoded, (Key) d);
        byte[] a2 = m3741a(encoded, bArr);
        byte[] bArr2 = new byte[(a.length + a2.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(a2, 0, bArr2, a.length, a2.length);
        return bArr2;
    }

    /* renamed from: a */
    static byte[] m3740a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(C1107dj.m3824c(ConstConfig.f3336a));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private static byte[] m3741a(byte[] bArr, byte[] bArr2) {
        try {
            return m3742a(bArr, bArr2, C1107dj.m3825c());
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "er", "asEn");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m3742a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    public static String m3743b(byte[] bArr) {
        try {
            return m3746d(bArr);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[LOOP:2: B:11:0x0024->B:14:0x0031, LOOP_START, PHI: r4 
  PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:10:0x0022, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[EDGE_INSN: B:49:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096 A[EDGE_INSN: B:51:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m3744b(java.lang.String r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            byte[] r8 = new byte[r0]
            return r8
        L_0x0006:
            byte[] r8 = com.loc.C1107dj.m3818a((java.lang.String) r8)
            int r1 = r8.length
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>(r1)
        L_0x0010:
            if (r0 >= r1) goto L_0x0096
        L_0x0012:
            byte[] r3 = f3295b
            int r4 = r0 + 1
            byte r0 = r8[r0]
            byte r0 = r3[r0]
            r3 = -1
            if (r4 >= r1) goto L_0x0022
            if (r0 == r3) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = r4
            goto L_0x0012
        L_0x0022:
            if (r0 == r3) goto L_0x0096
        L_0x0024:
            byte[] r5 = f3295b
            int r6 = r4 + 1
            byte r4 = r8[r4]
            byte r4 = r5[r4]
            if (r6 >= r1) goto L_0x0033
            if (r4 == r3) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r4 = r6
            goto L_0x0024
        L_0x0033:
            if (r4 == r3) goto L_0x0096
            int r0 = r0 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r0 = r0 | r5
            r2.write(r0)
        L_0x003f:
            if (r6 != r1) goto L_0x0046
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0046:
            int r0 = r6 + 1
            byte r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L_0x0053
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0053:
            byte[] r7 = f3295b
            byte r5 = r7[r5]
            if (r0 >= r1) goto L_0x005e
            if (r5 == r3) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r6 = r0
            goto L_0x003f
        L_0x005e:
            if (r5 == r3) goto L_0x0096
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r2.write(r4)
        L_0x006c:
            if (r0 != r1) goto L_0x0073
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0073:
            int r4 = r0 + 1
            byte r0 = r8[r0]
            if (r0 != r6) goto L_0x007e
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x007e:
            byte[] r7 = f3295b
            byte r0 = r7[r0]
            if (r4 >= r1) goto L_0x0089
            if (r0 == r3) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r0 = r4
            goto L_0x006c
        L_0x0089:
            if (r0 == r3) goto L_0x0096
            r3 = r5 & 3
            int r3 = r3 << 6
            r0 = r0 | r3
            r2.write(r0)
            r0 = r4
            goto L_0x0010
        L_0x0096:
            byte[] r8 = r2.toByteArray()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1102dd.m3744b(java.lang.String):byte[]");
    }

    /* renamed from: c */
    public static String m3745c(byte[] bArr) {
        try {
            return m3746d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static String m3746d(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f3294a[b >>> 2]);
                stringBuffer.append(f3294a[(b & 3) << 4]);
                str = "==";
                break;
            }
            int i3 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f3294a[b >>> 2]);
                stringBuffer.append(f3294a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                stringBuffer.append(f3294a[(b2 & 15) << 2]);
                str = "=";
                break;
            }
            int i4 = i3 + 1;
            byte b3 = bArr[i3] & 255;
            stringBuffer.append(f3294a[b >>> 2]);
            stringBuffer.append(f3294a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
            stringBuffer.append(f3294a[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
            stringBuffer.append(f3294a[b3 & 63]);
            i = i4;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
