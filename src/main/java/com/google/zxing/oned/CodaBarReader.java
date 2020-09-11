package com.google.zxing.oned;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class CodaBarReader extends OneDReader {
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};
    private int counterLength = 0;
    private int[] counters = new int[80];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r11, com.google.zxing.common.BitArray r12, java.util.Map<com.google.zxing.DecodeHintType, ?> r13) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.counters
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            r10.setCounters(r12)
            int r12 = r10.findStartPattern()
            java.lang.StringBuilder r0 = r10.decodeRowResult
            r0.setLength(r1)
            r0 = r12
        L_0x0013:
            int r2 = r10.toNarrowWidePattern(r0)
            r3 = -1
            if (r2 == r3) goto L_0x010c
            java.lang.StringBuilder r4 = r10.decodeRowResult
            char r5 = (char) r2
            r4.append(r5)
            int r0 = r0 + 8
            java.lang.StringBuilder r4 = r10.decodeRowResult
            int r4 = r4.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0038
            char[] r4 = STARTEND_ENCODING
            char[] r6 = ALPHABET
            char r2 = r6[r2]
            boolean r2 = arrayContains(r4, r2)
            if (r2 == 0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            int r2 = r10.counterLength
            if (r0 < r2) goto L_0x0013
        L_0x003c:
            int[] r2 = r10.counters
            int r4 = r0 + -1
            r2 = r2[r4]
            r6 = -8
            r7 = 0
        L_0x0044:
            if (r6 < r3) goto L_0x0101
            int r3 = r10.counterLength
            r8 = 2
            if (r0 >= r3) goto L_0x0054
            int r7 = r7 / r8
            if (r2 < r7) goto L_0x004f
            goto L_0x0054
        L_0x004f:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0054:
            r10.validatePattern(r12)
            r0 = 0
        L_0x0058:
            java.lang.StringBuilder r2 = r10.decodeRowResult
            int r2 = r2.length()
            if (r0 < r2) goto L_0x00ee
            java.lang.StringBuilder r0 = r10.decodeRowResult
            char r0 = r0.charAt(r1)
            char[] r2 = STARTEND_ENCODING
            boolean r0 = arrayContains(r2, r0)
            if (r0 == 0) goto L_0x00e9
            java.lang.StringBuilder r0 = r10.decodeRowResult
            java.lang.StringBuilder r2 = r10.decodeRowResult
            int r2 = r2.length()
            int r2 = r2 - r5
            char r0 = r0.charAt(r2)
            char[] r2 = STARTEND_ENCODING
            boolean r0 = arrayContains(r2, r0)
            if (r0 == 0) goto L_0x00e4
            java.lang.StringBuilder r0 = r10.decodeRowResult
            int r0 = r0.length()
            r2 = 3
            if (r0 <= r2) goto L_0x00df
            if (r13 == 0) goto L_0x0096
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.RETURN_CODABAR_START_END
            boolean r13 = r13.containsKey(r0)
            if (r13 != 0) goto L_0x00a7
        L_0x0096:
            java.lang.StringBuilder r13 = r10.decodeRowResult
            java.lang.StringBuilder r0 = r10.decodeRowResult
            int r0 = r0.length()
            int r0 = r0 - r5
            r13.deleteCharAt(r0)
            java.lang.StringBuilder r13 = r10.decodeRowResult
            r13.deleteCharAt(r1)
        L_0x00a7:
            r13 = 0
            r0 = 0
        L_0x00a9:
            if (r13 < r12) goto L_0x00d7
            float r2 = (float) r0
        L_0x00ac:
            if (r12 < r4) goto L_0x00cf
            float r12 = (float) r0
            com.google.zxing.Result r13 = new com.google.zxing.Result
            java.lang.StringBuilder r0 = r10.decodeRowResult
            java.lang.String r0 = r0.toString()
            r3 = 0
            com.google.zxing.ResultPoint[] r4 = new com.google.zxing.ResultPoint[r8]
            com.google.zxing.ResultPoint r6 = new com.google.zxing.ResultPoint
            float r11 = (float) r11
            r6.<init>(r2, r11)
            r4[r1] = r6
            com.google.zxing.ResultPoint r1 = new com.google.zxing.ResultPoint
            r1.<init>(r12, r11)
            r4[r5] = r1
            com.google.zxing.BarcodeFormat r11 = com.google.zxing.BarcodeFormat.CODABAR
            r13.<init>(r0, r3, r4, r11)
            return r13
        L_0x00cf:
            int[] r13 = r10.counters
            r13 = r13[r12]
            int r0 = r0 + r13
            int r12 = r12 + 1
            goto L_0x00ac
        L_0x00d7:
            int[] r2 = r10.counters
            r2 = r2[r13]
            int r0 = r0 + r2
            int r13 = r13 + 1
            goto L_0x00a9
        L_0x00df:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00e4:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00e9:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00ee:
            java.lang.StringBuilder r2 = r10.decodeRowResult
            char[] r3 = ALPHABET
            java.lang.StringBuilder r6 = r10.decodeRowResult
            char r6 = r6.charAt(r0)
            char r3 = r3[r6]
            r2.setCharAt(r0, r3)
            int r0 = r0 + 1
            goto L_0x0058
        L_0x0101:
            int[] r8 = r10.counters
            int r9 = r0 + r6
            r8 = r8[r9]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0044
        L_0x010c:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.CodaBarReader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }

    /* access modifiers changed from: package-private */
    public void validatePattern(int i) throws NotFoundException {
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int length = this.decodeRowResult.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.counters[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((((float) iArr[i8]) / ((float) iArr2[i8])) + (((float) iArr[i9]) / ((float) iArr2[i9]))) / MAX_ACCEPTABLE;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((((float) iArr[i9]) * MAX_ACCEPTABLE) + PADDING) / ((float) iArr2[i9]);
        }
        loop3:
        while (true) {
            int i10 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i2)];
            int i11 = 6;
            while (i11 >= 0) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                float f = (float) this.counters[i + i11];
                if (f >= fArr2[i12] && f <= fArr[i12]) {
                    i10 >>= 1;
                    i11--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        int i = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            boolean z = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) ^ z) {
                    i++;
                } else {
                    counterAppend(i);
                    z = !z;
                    i = 1;
                }
                nextUnset++;
            }
            counterAppend(i);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void counterAppend(int i) {
        this.counters[this.counterLength] = i;
        this.counterLength++;
        if (this.counterLength >= this.counters.length) {
            int[] iArr = new int[(this.counterLength * 2)];
            System.arraycopy(this.counters, 0, iArr, 0, this.counterLength);
            this.counters = iArr;
        }
    }

    private int findStartPattern() throws NotFoundException {
        for (int i = 1; i < this.counterLength; i += 2) {
            int narrowWidePattern = toNarrowWidePattern(i);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.counters[i3];
                }
                if (i == 1 || this.counters[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static boolean arrayContains(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private int toNarrowWidePattern(int i) {
        int i2 = i + 7;
        if (i2 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i5 = 0;
        for (int i6 = i; i6 < i2; i6 += 2) {
            int i7 = iArr[i6];
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i5) {
                i5 = i7;
            }
        }
        int i8 = (i4 + i5) / 2;
        int i9 = 0;
        for (int i10 = i + 1; i10 < i2; i10 += 2) {
            int i11 = iArr[i10];
            if (i11 < i3) {
                i3 = i11;
            }
            if (i11 > i9) {
                i9 = i11;
            }
        }
        int i12 = (i3 + i9) / 2;
        int i13 = 128;
        int i14 = 0;
        for (int i15 = 0; i15 < 7; i15++) {
            i13 >>= 1;
            if (iArr[i + i15] > ((i15 & 1) == 0 ? i8 : i12)) {
                i14 |= i13;
            }
        }
        for (int i16 = 0; i16 < CHARACTER_ENCODINGS.length; i16++) {
            if (CHARACTER_ENCODINGS[i16] == i14) {
                return i16;
            }
        }
        return -1;
    }
}
