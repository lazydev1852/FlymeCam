package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        boolean z;
        int i4;
        BitArray bitArray;
        int i5;
        int i6;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i7 = 32;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            int abs = Math.abs(i2);
            if (z2) {
                i7 = 4;
            }
            if (abs <= i7) {
                i5 = totalBitsInLayer(abs, z2);
                i4 = WORD_SIZE[abs];
                int i8 = i5 - (i5 % i4);
                bitArray = stuffBits(encode, i4);
                if (bitArray.getSize() + size > i8) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (!z2 || bitArray.getSize() <= i4 * 64) {
                    z = z2;
                    i3 = abs;
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        } else {
            BitArray bitArray2 = null;
            int i9 = 0;
            int i10 = 0;
            while (i9 <= 32) {
                z = i9 <= 3;
                i3 = z ? i9 + 1 : i9;
                int i11 = totalBitsInLayer(i3, z);
                if (size2 <= i11) {
                    if (i10 != WORD_SIZE[i3]) {
                        i10 = WORD_SIZE[i3];
                        bitArray2 = stuffBits(encode, i10);
                    }
                    int i12 = i11 - (i11 % i10);
                    if ((!z || bitArray2.getSize() <= i10 * 64) && bitArray2.getSize() + size <= i12) {
                        i4 = i10;
                        bitArray = bitArray2;
                        i5 = i11;
                    }
                }
                i9++;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i5, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray generateModeMessage = generateModeMessage(z, i3, size3);
        int i13 = z ? (i3 * 4) + 11 : (i3 * 4) + 14;
        int[] iArr = new int[i13];
        int i14 = 2;
        if (z) {
            for (int i15 = 0; i15 < iArr.length; i15++) {
                iArr[i15] = i15;
            }
            i6 = i13;
        } else {
            int i16 = i13 / 2;
            int i17 = i13 + 1 + (((i16 - 1) / 15) * 2);
            int i18 = i17 / 2;
            int i19 = 0;
            while (i19 < i16) {
                int i20 = (i19 / 15) + i19;
                iArr[(i16 - i19) - 1] = (i18 - i20) - 1;
                iArr[i16 + i19] = i18 + i20 + 1;
                i19++;
                i14 = 2;
            }
            i6 = i17;
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i21 = 0;
        for (int i22 = 0; i22 < i3; i22++) {
            int i23 = z ? ((i3 - i22) * 4) + 9 : ((i3 - i22) * 4) + 12;
            for (int i24 = 0; i24 < i23; i24++) {
                int i25 = i24 * 2;
                int i26 = 0;
                while (i26 < i14) {
                    if (generateCheckWords.get(i21 + i25 + i26)) {
                        int i27 = i22 * 2;
                        bitMatrix.set(iArr[i27 + i26], iArr[i27 + i24]);
                    }
                    if (generateCheckWords.get(i21 + (i23 * 2) + i25 + i26)) {
                        int i28 = i22 * 2;
                        bitMatrix.set(iArr[i28 + i24], iArr[((i13 - 1) - i28) - i26]);
                    }
                    if (generateCheckWords.get(i21 + (i23 * 4) + i25 + i26)) {
                        int i29 = (i13 - 1) - (i22 * 2);
                        bitMatrix.set(iArr[i29 - i26], iArr[i29 - i24]);
                    }
                    if (generateCheckWords.get(i21 + (i23 * 6) + i25 + i26)) {
                        int i30 = i22 * 2;
                        bitMatrix.set(iArr[((i13 - 1) - i30) - i24], iArr[i30 + i26]);
                    }
                    i26++;
                    i14 = 2;
                }
            }
            i21 += i23 * 8;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i31 = i6 / 2;
            drawBullsEye(bitMatrix, i31, 7);
            int i32 = 0;
            int i33 = 0;
            while (i32 < (i13 / 2) - 1) {
                for (int i34 = i31 & 1; i34 < i6; i34 += 2) {
                    int i35 = i31 - i33;
                    bitMatrix.set(i35, i34);
                    int i36 = i31 + i33;
                    bitMatrix.set(i36, i34);
                    bitMatrix.set(i34, i35);
                    bitMatrix.set(i34, i36);
                }
                i32 += 15;
                i33 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i3);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.set(i5, i4);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i4, i5);
                bitMatrix.set(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - (bitArray.getSize() / i2));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int appendBits : bitsToWords) {
            bitArray2.appendBits(appendBits, i2);
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        if (i == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i != 12) {
            return null;
        }
        return GenericGF.AZTEC_DATA_12;
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
                i3--;
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
                i3--;
            } else {
                bitArray2.appendBits(i4, i);
            }
            i3 += i;
        }
        return bitArray2;
    }
}
