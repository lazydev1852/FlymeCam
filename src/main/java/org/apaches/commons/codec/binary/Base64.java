package org.apaches.commons.codec.binary;

import androidx.appcompat.widget.ActivityChooserView;
import java.math.BigInteger;
import org.apaches.commons.codec.binary.BaseNCodec;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE;
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        byte[] bArr = new byte[123];
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = 62;
        bArr[44] = -1;
        bArr[45] = 62;
        bArr[46] = -1;
        bArr[47] = 63;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = 57;
        bArr[54] = 58;
        bArr[55] = 59;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -1;
        bArr[92] = -1;
        bArr[93] = -1;
        bArr[94] = -1;
        bArr[95] = 63;
        bArr[96] = -1;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = 34;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = 44;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = 48;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        DECODE_TABLE = bArr;
    }

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + "]");
        } else if (i > 0) {
            this.encodeSize = bArr.length + 4;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r8, int r9, int r10, org.apaches.commons.codec.binary.BaseNCodec.Context r11) {
        /*
            r7 = this;
            boolean r0 = r11.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r10 >= 0) goto L_0x00db
            r11.eof = r1
            int r8 = r11.modulus
            if (r8 != 0) goto L_0x0014
            int r8 = r7.lineLength
            if (r8 != 0) goto L_0x0014
            return
        L_0x0014:
            int r8 = r7.encodeSize
            byte[] r8 = r7.ensureBufferSize(r8, r11)
            int r9 = r11.pos
            int r10 = r11.modulus
            r1 = 61
            switch(r10) {
                case 0: goto L_0x00b8;
                case 1: goto L_0x007e;
                case 2: goto L_0x0039;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Impossible modulus "
            r9.<init>(r10)
            int r10 = r11.modulus
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0039:
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r11.ibitWorkArea
            int r3 = r3 >> 10
            r3 = r3 & 63
            byte r2 = r2[r3]
            r8[r10] = r2
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r11.ibitWorkArea
            int r3 = r3 >> 4
            r3 = r3 & 63
            byte r2 = r2[r3]
            r8[r10] = r2
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r11.ibitWorkArea
            int r3 = r3 << 2
            r3 = r3 & 63
            byte r2 = r2[r3]
            r8[r10] = r2
            byte[] r10 = r7.encodeTable
            byte[] r2 = STANDARD_ENCODE_TABLE
            if (r10 != r2) goto L_0x00b8
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            r8[r10] = r1
            goto L_0x00b8
        L_0x007e:
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r11.ibitWorkArea
            int r3 = r3 >> 2
            r3 = r3 & 63
            byte r2 = r2[r3]
            r8[r10] = r2
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r11.ibitWorkArea
            int r3 = r3 << 4
            r3 = r3 & 63
            byte r2 = r2[r3]
            r8[r10] = r2
            byte[] r10 = r7.encodeTable
            byte[] r2 = STANDARD_ENCODE_TABLE
            if (r10 != r2) goto L_0x00b8
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            r8[r10] = r1
            int r10 = r11.pos
            int r2 = r10 + 1
            r11.pos = r2
            r8[r10] = r1
        L_0x00b8:
            int r10 = r11.currentLinePos
            int r1 = r11.pos
            int r1 = r1 - r9
            int r10 = r10 + r1
            r11.currentLinePos = r10
            int r9 = r7.lineLength
            if (r9 <= 0) goto L_0x00df
            int r9 = r11.currentLinePos
            if (r9 <= 0) goto L_0x00df
            byte[] r9 = r7.lineSeparator
            int r10 = r11.pos
            byte[] r1 = r7.lineSeparator
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r0, r8, r10, r1)
            int r8 = r11.pos
            byte[] r9 = r7.lineSeparator
            int r9 = r9.length
            int r8 = r8 + r9
            r11.pos = r8
            goto L_0x00df
        L_0x00db:
            r2 = r9
            r9 = 0
        L_0x00dd:
            if (r9 < r10) goto L_0x00e0
        L_0x00df:
            return
        L_0x00e0:
            int r3 = r7.encodeSize
            byte[] r3 = r7.ensureBufferSize(r3, r11)
            int r4 = r11.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r11.modulus = r4
            int r4 = r2 + 1
            byte r2 = r8[r2]
            if (r2 >= 0) goto L_0x00f5
            int r2 = r2 + 256
        L_0x00f5:
            int r5 = r11.ibitWorkArea
            int r5 = r5 << 8
            int r5 = r5 + r2
            r11.ibitWorkArea = r5
            int r2 = r11.modulus
            if (r2 != 0) goto L_0x016a
            int r2 = r11.pos
            int r5 = r2 + 1
            r11.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r11.ibitWorkArea
            int r6 = r6 >> 18
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r11.pos
            int r5 = r2 + 1
            r11.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r11.ibitWorkArea
            int r6 = r6 >> 12
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r11.pos
            int r5 = r2 + 1
            r11.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r11.ibitWorkArea
            int r6 = r6 >> 6
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r11.pos
            int r5 = r2 + 1
            r11.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r11.ibitWorkArea
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r11.currentLinePos
            int r2 = r2 + 4
            r11.currentLinePos = r2
            int r2 = r7.lineLength
            if (r2 <= 0) goto L_0x016a
            int r2 = r7.lineLength
            int r5 = r11.currentLinePos
            if (r2 > r5) goto L_0x016a
            byte[] r2 = r7.lineSeparator
            int r5 = r11.pos
            byte[] r6 = r7.lineSeparator
            int r6 = r6.length
            java.lang.System.arraycopy(r2, r0, r3, r5, r6)
            int r2 = r11.pos
            byte[] r3 = r7.lineSeparator
            int r3 = r3.length
            int r2 = r2 + r3
            r11.pos = r2
            r11.currentLinePos = r0
        L_0x016a:
            int r9 = r9 + 1
            r2 = r4
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apaches.commons.codec.binary.Base64.encode(byte[], int, int, org.apaches.commons.codec.binary.BaseNCodec$Context):void");
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    context.eof = true;
                    break;
                }
                if (b2 >= 0 && b2 < DECODE_TABLE.length && (b = DECODE_TABLE[b2]) >= 0) {
                    context.modulus = (context.modulus + 1) % 4;
                    context.ibitWorkArea = (context.ibitWorkArea << 6) + b;
                    if (context.modulus == 0) {
                        int i5 = context.pos;
                        context.pos = i5 + 1;
                        ensureBufferSize[i5] = (byte) ((context.ibitWorkArea >> 16) & 255);
                        int i6 = context.pos;
                        context.pos = i6 + 1;
                        ensureBufferSize[i6] = (byte) ((context.ibitWorkArea >> 8) & 255);
                        int i7 = context.pos;
                        context.pos = i7 + 1;
                        ensureBufferSize[i7] = (byte) (context.ibitWorkArea & 255);
                    }
                }
                i3++;
                i = i4;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                switch (context.modulus) {
                    case 1:
                        return;
                    case 2:
                        context.ibitWorkArea >>= 4;
                        int i8 = context.pos;
                        context.pos = i8 + 1;
                        ensureBufferSize2[i8] = (byte) (context.ibitWorkArea & 255);
                        return;
                    case 3:
                        context.ibitWorkArea >>= 2;
                        int i9 = context.pos;
                        context.pos = i9 + 1;
                        ensureBufferSize2[i9] = (byte) ((context.ibitWorkArea >> 8) & 255);
                        int i10 = context.pos;
                        context.pos = i10 + 1;
                        ensureBufferSize2[i10] = (byte) (context.ibitWorkArea & 255);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            return b >= 0 && b < DECODE_TABLE.length && DECODE_TABLE[b] != -1;
        }
        return true;
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int i = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i = 1;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public boolean isInAlphabet(byte b) {
        return b >= 0 && b < this.decodeTable.length && this.decodeTable[b] != -1;
    }
}
