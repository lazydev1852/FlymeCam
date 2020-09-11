package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 == i3) {
                    float f = MAX_AVG_VARIANCE;
                    int i4 = -1;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i5], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            i4 = i5;
                            f = patternMatchVariance;
                        }
                    }
                    if (i4 < 0 || !bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i6 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i6);
                        iArr[i6] = 0;
                        iArr[i3] = 0;
                        i2--;
                    } else {
                        return new int[]{i, nextSet, i4};
                    }
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < CODE_PATTERNS.length; i3++) {
            float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ea, code lost:
        r23 = r5;
        r2 = false;
        r22 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f3, code lost:
        r23 = r5;
        r22 = r9;
        r2 = false;
        r10 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0206, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0207, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0208, code lost:
        r23 = r5;
        r22 = r9;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0248, code lost:
        r10 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0250, code lost:
        r10 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x025a, code lost:
        r23 = r5;
        r22 = r9;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x025f, code lost:
        if (r14 == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0263, code lost:
        if (r10 != 'e') goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0265, code lost:
        r10 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0268, code lost:
        r10 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x026a, code lost:
        r14 = r2;
        r11 = r16;
        r2 = 1;
        r3 = 0;
        r5 = 2;
        r9 = 'c';
        r16 = r12;
        r12 = r8;
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0178, code lost:
        if (r9 != false) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a2, code lost:
        r23 = r5;
        r2 = false;
        r22 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b4, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d4, code lost:
        r2 = false;
        r22 = false;
        r23 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01df, code lost:
        if (r9 != false) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e1, code lost:
        r2 = false;
        r22 = false;
        r23 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r26, com.google.zxing.common.BitArray r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            r25 = this;
            r0 = r27
            r1 = r28
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.zxing.DecodeHintType r4 = com.google.zxing.DecodeHintType.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int[] r4 = findStartPattern(r27)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            r9 = 99
            switch(r6) {
                case 103: goto L_0x0039;
                case 104: goto L_0x0036;
                case 105: goto L_0x0033;
                default: goto L_0x002e;
            }
        L_0x002e:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0033:
            r12 = 99
            goto L_0x003b
        L_0x0036:
            r12 = 100
            goto L_0x003b
        L_0x0039:
            r12 = 101(0x65, float:1.42E-43)
        L_0x003b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r15 = new int[r15]
            r17 = r6
            r10 = r12
            r6 = 0
            r11 = 0
            r16 = 0
            r18 = 0
            r20 = 1
            r22 = 0
            r23 = 0
            r12 = r8
            r8 = r14
            r14 = 0
        L_0x0059:
            if (r6 == 0) goto L_0x00e7
            int r1 = r8 - r12
            int r6 = r0.getNextUnset(r8)
            int r8 = r27.getSize()
            int r14 = r6 - r12
            int r14 = r14 / r5
            int r14 = r14 + r6
            int r8 = java.lang.Math.min(r8, r14)
            boolean r0 = r0.isRange(r6, r8, r3)
            if (r0 == 0) goto L_0x00e2
            int r18 = r18 * r11
            int r17 = r17 - r18
            int r0 = r17 % 103
            if (r0 != r11) goto L_0x00dd
            int r0 = r13.length()
            if (r0 == 0) goto L_0x00d8
            if (r0 <= 0) goto L_0x0092
            if (r20 == 0) goto L_0x0092
            if (r10 != r9) goto L_0x008d
            int r6 = r0 + -2
            r13.delete(r6, r0)
            goto L_0x0092
        L_0x008d:
            int r6 = r0 + -1
            r13.delete(r6, r0)
        L_0x0092:
            r0 = r4[r2]
            r4 = r4[r3]
            int r0 = r0 + r4
            float r0 = (float) r0
            r4 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r4
            float r6 = (float) r12
            float r1 = (float) r1
            float r1 = r1 / r4
            float r6 = r6 + r1
            int r1 = r7.size()
            byte[] r4 = new byte[r1]
            r8 = 0
        L_0x00a6:
            if (r8 < r1) goto L_0x00c7
            com.google.zxing.Result r1 = new com.google.zxing.Result
            java.lang.String r7 = r13.toString()
            com.google.zxing.ResultPoint[] r5 = new com.google.zxing.ResultPoint[r5]
            com.google.zxing.ResultPoint r8 = new com.google.zxing.ResultPoint
            r11 = r26
            float r9 = (float) r11
            r8.<init>(r0, r9)
            r5[r3] = r8
            com.google.zxing.ResultPoint r0 = new com.google.zxing.ResultPoint
            r0.<init>(r6, r9)
            r5[r2] = r0
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.CODE_128
            r1.<init>(r7, r4, r5, r0)
            return r1
        L_0x00c7:
            r11 = r26
            java.lang.Object r9 = r7.get(r8)
            java.lang.Byte r9 = (java.lang.Byte) r9
            byte r9 = r9.byteValue()
            r4[r8] = r9
            int r8 = r8 + 1
            goto L_0x00a6
        L_0x00d8:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x00dd:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x00e2:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x00e7:
            r11 = r26
            int r12 = decodeCode(r0, r15, r8)
            byte r2 = (byte) r12
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r7.add(r2)
            r2 = 106(0x6a, float:1.49E-43)
            if (r12 == r2) goto L_0x00fb
            r20 = 1
        L_0x00fb:
            if (r12 == r2) goto L_0x0103
            int r18 = r18 + 1
            int r24 = r18 * r12
            int r17 = r17 + r24
        L_0x0103:
            int r3 = r15.length
            r24 = r8
            r5 = 0
        L_0x0107:
            if (r5 < r3) goto L_0x0279
            switch(r12) {
                case 103: goto L_0x0119;
                case 104: goto L_0x0119;
                case 105: goto L_0x0119;
                default: goto L_0x010c;
            }
        L_0x010c:
            r3 = 96
            switch(r10) {
                case 99: goto L_0x0210;
                case 100: goto L_0x018b;
                case 101: goto L_0x011e;
                default: goto L_0x0111;
            }
        L_0x0111:
            r9 = r22
            r5 = r23
            r3 = 100
            goto L_0x025a
        L_0x0119:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x011e:
            r9 = 64
            if (r12 >= r9) goto L_0x013a
            r9 = r22
            r5 = r23
            if (r9 != r5) goto L_0x0130
            int r2 = r12 + 32
            char r2 = (char) r2
            r13.append(r2)
            goto L_0x01a2
        L_0x0130:
            int r2 = r12 + 32
            int r2 = r2 + 128
            char r2 = (char) r2
            r13.append(r2)
            goto L_0x01a2
        L_0x013a:
            r9 = r22
            r5 = r23
            if (r12 >= r3) goto L_0x0150
            if (r9 != r5) goto L_0x0149
            int r2 = r12 + -64
            char r2 = (char) r2
            r13.append(r2)
            goto L_0x01a2
        L_0x0149:
            int r2 = r12 + 64
            char r2 = (char) r2
            r13.append(r2)
            goto L_0x01a2
        L_0x0150:
            if (r12 == r2) goto L_0x0154
            r20 = 0
        L_0x0154:
            if (r12 == r2) goto L_0x0206
            switch(r12) {
                case 96: goto L_0x0208;
                case 97: goto L_0x0208;
                case 98: goto L_0x0182;
                case 99: goto L_0x01f3;
                case 100: goto L_0x017c;
                case 101: goto L_0x0170;
                case 102: goto L_0x015a;
                default: goto L_0x0159;
            }
        L_0x0159:
            goto L_0x01b4
        L_0x015a:
            if (r1 == 0) goto L_0x0208
            int r2 = r13.length()
            if (r2 != 0) goto L_0x0169
            java.lang.String r2 = "]C1"
            r13.append(r2)
            goto L_0x0208
        L_0x0169:
            r2 = 29
            r13.append(r2)
            goto L_0x0208
        L_0x0170:
            if (r5 != 0) goto L_0x0176
            if (r9 == 0) goto L_0x0176
            goto L_0x01d4
        L_0x0176:
            if (r5 == 0) goto L_0x01ea
            if (r9 == 0) goto L_0x01ea
            goto L_0x01e1
        L_0x017c:
            r23 = r5
            r22 = r9
            r2 = 0
            goto L_0x0187
        L_0x0182:
            r23 = r5
            r22 = r9
            r2 = 1
        L_0x0187:
            r3 = 100
            goto L_0x0250
        L_0x018b:
            r9 = r22
            r5 = r23
            if (r12 >= r3) goto L_0x01ab
            if (r9 != r5) goto L_0x019a
            int r2 = r12 + 32
            char r2 = (char) r2
            r13.append(r2)
            goto L_0x01a2
        L_0x019a:
            int r2 = r12 + 32
            int r2 = r2 + 128
            char r2 = (char) r2
            r13.append(r2)
        L_0x01a2:
            r23 = r5
            r2 = 0
            r3 = 100
            r22 = 0
            goto L_0x025f
        L_0x01ab:
            if (r12 == r2) goto L_0x01af
            r20 = 0
        L_0x01af:
            if (r12 == r2) goto L_0x0206
            switch(r12) {
                case 96: goto L_0x0208;
                case 97: goto L_0x0208;
                case 98: goto L_0x01fe;
                case 99: goto L_0x01f3;
                case 100: goto L_0x01d0;
                case 101: goto L_0x01ca;
                case 102: goto L_0x01b6;
                default: goto L_0x01b4;
            }
        L_0x01b4:
            r2 = r6
            goto L_0x0207
        L_0x01b6:
            if (r1 == 0) goto L_0x0208
            int r2 = r13.length()
            if (r2 != 0) goto L_0x01c4
            java.lang.String r2 = "]C1"
            r13.append(r2)
            goto L_0x0208
        L_0x01c4:
            r2 = 29
            r13.append(r2)
            goto L_0x0208
        L_0x01ca:
            r23 = r5
            r22 = r9
            r2 = 0
            goto L_0x0203
        L_0x01d0:
            if (r5 != 0) goto L_0x01dd
            if (r9 == 0) goto L_0x01dd
        L_0x01d4:
            r2 = 0
            r3 = 100
            r22 = 0
            r23 = 1
            goto L_0x025f
        L_0x01dd:
            if (r5 == 0) goto L_0x01ea
            if (r9 == 0) goto L_0x01ea
        L_0x01e1:
            r2 = 0
            r3 = 100
            r22 = 0
            r23 = 0
            goto L_0x025f
        L_0x01ea:
            r23 = r5
            r2 = 0
            r3 = 100
            r22 = 1
            goto L_0x025f
        L_0x01f3:
            r23 = r5
            r22 = r9
            r2 = 0
            r3 = 100
            r10 = 99
            goto L_0x025f
        L_0x01fe:
            r23 = r5
            r22 = r9
            r2 = 1
        L_0x0203:
            r3 = 100
            goto L_0x0248
        L_0x0206:
            r2 = 1
        L_0x0207:
            r6 = r2
        L_0x0208:
            r23 = r5
            r22 = r9
            r2 = 0
            r3 = 100
            goto L_0x025f
        L_0x0210:
            r9 = r22
            r5 = r23
            r3 = 100
            if (r12 >= r3) goto L_0x0225
            r2 = 10
            if (r12 >= r2) goto L_0x0221
            r2 = 48
            r13.append(r2)
        L_0x0221:
            r13.append(r12)
            goto L_0x025a
        L_0x0225:
            if (r12 == r2) goto L_0x0229
            r20 = 0
        L_0x0229:
            if (r12 == r2) goto L_0x0253
            switch(r12) {
                case 100: goto L_0x024b;
                case 101: goto L_0x0243;
                case 102: goto L_0x022f;
                default: goto L_0x022e;
            }
        L_0x022e:
            goto L_0x025a
        L_0x022f:
            if (r1 == 0) goto L_0x025a
            int r2 = r13.length()
            if (r2 != 0) goto L_0x023d
            java.lang.String r2 = "]C1"
            r13.append(r2)
            goto L_0x025a
        L_0x023d:
            r2 = 29
            r13.append(r2)
            goto L_0x025a
        L_0x0243:
            r23 = r5
            r22 = r9
            r2 = 0
        L_0x0248:
            r10 = 101(0x65, float:1.42E-43)
            goto L_0x025f
        L_0x024b:
            r23 = r5
            r22 = r9
            r2 = 0
        L_0x0250:
            r10 = 100
            goto L_0x025f
        L_0x0253:
            r23 = r5
            r22 = r9
            r2 = 0
            r6 = 1
            goto L_0x025f
        L_0x025a:
            r23 = r5
            r22 = r9
            r2 = 0
        L_0x025f:
            if (r14 == 0) goto L_0x026a
            r5 = 101(0x65, float:1.42E-43)
            if (r10 != r5) goto L_0x0268
            r10 = 100
            goto L_0x026a
        L_0x0268:
            r10 = 101(0x65, float:1.42E-43)
        L_0x026a:
            r14 = r2
            r11 = r16
            r2 = 1
            r3 = 0
            r5 = 2
            r9 = 99
            r16 = r12
            r12 = r8
            r8 = r24
            goto L_0x0059
        L_0x0279:
            r19 = r5
            r9 = r22
            r5 = r23
            r21 = 101(0x65, float:1.42E-43)
            r22 = 100
            r23 = r15[r19]
            int r24 = r24 + r23
            int r19 = r19 + 1
            r23 = r5
            r22 = r9
            r5 = r19
            r9 = 99
            goto L_0x0107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
