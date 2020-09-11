package com.baidu.p020ar.util;

import com.alibaba.fastjson.asm.Opcodes;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;

/* renamed from: com.baidu.ar.util.Base64 */
public class Base64 {

    /* renamed from: a */
    private static final byte[] f2357a = new byte[128];

    /* renamed from: b */
    private static final char[] f2358b = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f2357a[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f2357a[i5] = (byte) (i5 - 65);
        }
        int i6 = ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f2357a[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f2357a[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        f2357a[43] = 62;
        f2357a[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            f2358b[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f2358b[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f2358b[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        f2358b[62] = '+';
        f2358b[63] = '/';
    }

    /* renamed from: a */
    private static int m2704a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m2705a(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static boolean m2705a(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    /* renamed from: b */
    private static boolean m2706b(char c) {
        return c == '=';
    }

    /* renamed from: c */
    private static boolean m2707c(char c) {
        return c < 128 && f2357a[c] != -1;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a = m2704a(charArray);
        if (a % 4 != 0) {
            return null;
        }
        int i = a / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i * 3)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (m2707c(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m2707c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m2707c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m2707c(c4)) {
                            byte b = f2357a[c];
                            byte b2 = f2357a[c2];
                            byte b3 = f2357a[c3];
                            byte b4 = f2357a[c4];
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((b << 2) | (b2 >> 4));
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr[i10] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c5 = charArray[i3];
        if (!m2707c(c5)) {
            return null;
        }
        int i12 = i11 + 1;
        char c6 = charArray[i11];
        if (!m2707c(c6)) {
            return null;
        }
        byte b5 = f2357a[c5];
        byte b6 = f2357a[c6];
        int i13 = i12 + 1;
        char c7 = charArray[i12];
        char c8 = charArray[i13];
        if (m2707c(c7) && m2707c(c8)) {
            byte b7 = f2357a[c7];
            byte b8 = f2357a[c8];
            int i14 = i4 + 1;
            bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i14] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
            bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        } else if (!m2706b(c7) || !m2706b(c8)) {
            if (m2706b(c7) || !m2706b(c8)) {
                return null;
            }
            byte b9 = f2357a[c7];
            if ((b9 & 3) != 0) {
                return null;
            }
            int i15 = i2 * 3;
            byte[] bArr2 = new byte[(i15 + 2)];
            System.arraycopy(bArr, 0, bArr2, 0, i15);
            bArr2[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr2[i4 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & 15) << 4));
            return bArr2;
        } else if ((b6 & 15) != 0) {
            return null;
        } else {
            int i16 = i2 * 3;
            byte[] bArr3 = new byte[(i16 + 1)];
            System.arraycopy(bArr, 0, bArr3, 0, i16);
            bArr3[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            return bArr3;
        }
    }

    public static String encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[((i != 0 ? i2 + 1 : i2) * 4)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            byte b6 = (byte) ((b & Byte.MIN_VALUE) == 0 ? b >> 2 : (b >> 2) ^ Opcodes.CHECKCAST);
            byte b7 = (byte) ((b2 & Byte.MIN_VALUE) == 0 ? b2 >> 4 : (b2 >> 4) ^ 240);
            byte b8 = (byte) ((b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252);
            int i9 = i5 + 1;
            cArr[i5] = f2358b[b6];
            int i10 = i9 + 1;
            cArr[i9] = f2358b[b7 | (b5 << 4)];
            int i11 = i10 + 1;
            cArr[i10] = f2358b[(b4 << 2) | b8];
            cArr[i11] = f2358b[b3 & 63];
            i3++;
            i5 = i11 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b9 = bArr[i4];
            byte b10 = (byte) (b9 & 3);
            int i12 = i5 + 1;
            cArr[i5] = f2358b[(byte) ((b9 & Byte.MIN_VALUE) == 0 ? b9 >> 2 : (b9 >> 2) ^ Opcodes.CHECKCAST)];
            int i13 = i12 + 1;
            cArr[i12] = f2358b[b10 << 4];
            cArr[i13] = '=';
            cArr[i13 + 1] = '=';
        } else if (i == 16) {
            byte b11 = bArr[i4];
            byte b12 = bArr[i4 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            byte b15 = (byte) ((b11 & Byte.MIN_VALUE) == 0 ? b11 >> 2 : (b11 >> 2) ^ Opcodes.CHECKCAST);
            byte b16 = (byte) ((b12 & Byte.MIN_VALUE) == 0 ? b12 >> 4 : (b12 >> 4) ^ 240);
            int i14 = i5 + 1;
            cArr[i5] = f2358b[b15];
            int i15 = i14 + 1;
            cArr[i14] = f2358b[b16 | (b14 << 4)];
            cArr[i15] = f2358b[b13 << 2];
            cArr[i15 + 1] = '=';
        }
        return new String(cArr);
    }
}
