package com.baidu.p020ar.arplay.representation;

/* renamed from: com.baidu.ar.arplay.representation.Matrix */
public final class Matrix {
    private static final float[] TEMP_MATRIX_ARRAY = new float[32];

    private Matrix() {
    }

    public static void frustumM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        } else if (f4 == f3) {
            throw new IllegalArgumentException("top == bottom");
        } else if (f5 == f6) {
            throw new IllegalArgumentException("near == far");
        } else if (f5 <= 0.0f) {
            throw new IllegalArgumentException("near <= 0.0f");
        } else if (f6 > 0.0f) {
            float f7 = 1.0f / (f2 - f);
            float f8 = 1.0f / (f4 - f3);
            float f9 = 1.0f / (f5 - f6);
            fArr[i + 0] = f5 * f7 * 2.0f;
            fArr[i + 5] = f5 * f8 * 2.0f;
            fArr[i + 8] = (f2 + f) * f7 * 2.0f;
            fArr[i + 9] = (f4 + f3) * f8;
            fArr[i + 10] = (f6 + f5) * f9;
            fArr[i + 14] = f6 * f5 * f9 * 2.0f;
            fArr[i + 11] = -1.0f;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 3] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 7] = 0.0f;
            fArr[i + 12] = 0.0f;
            fArr[i + 13] = 0.0f;
            fArr[i + 15] = 0.0f;
        } else {
            throw new IllegalArgumentException("far <= 0.0f");
        }
    }

    /* JADX WARNING: type inference failed for: r39v0, types: [float[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean invertM(float[] r39, int r40, float[] r41, int r42) {
        /*
            int r4 = r42 + 0
            r4 = r41[r4]
            int r5 = r42 + 1
            r5 = r41[r5]
            int r6 = r42 + 2
            r6 = r41[r6]
            int r7 = r42 + 3
            r7 = r41[r7]
            int r8 = r42 + 4
            r8 = r41[r8]
            int r9 = r42 + 5
            r9 = r41[r9]
            int r10 = r42 + 6
            r10 = r41[r10]
            int r11 = r42 + 7
            r11 = r41[r11]
            int r12 = r42 + 8
            r12 = r41[r12]
            int r13 = r42 + 9
            r13 = r41[r13]
            int r14 = r42 + 10
            r14 = r41[r14]
            int r15 = r42 + 11
            r15 = r41[r15]
            int r16 = r42 + 12
            r16 = r41[r16]
            int r17 = r42 + 13
            r17 = r41[r17]
            int r18 = r42 + 14
            r18 = r41[r18]
            int r3 = r42 + 15
            r2 = r41[r3]
            float r3 = r14 * r2
            float r19 = r18 * r15
            float r20 = r10 * r2
            float r21 = r18 * r11
            float r22 = r10 * r15
            float r23 = r14 * r11
            float r24 = r6 * r2
            float r25 = r18 * r7
            float r26 = r6 * r15
            float r27 = r14 * r7
            float r28 = r6 * r11
            float r29 = r10 * r7
            float r30 = r3 * r9
            float r31 = r21 * r13
            float r30 = r30 + r31
            float r31 = r22 * r17
            float r30 = r30 + r31
            float r31 = r19 * r9
            float r32 = r20 * r13
            float r31 = r31 + r32
            float r32 = r23 * r17
            float r31 = r31 + r32
            float r30 = r30 - r31
            float r31 = r19 * r5
            float r32 = r24 * r13
            float r31 = r31 + r32
            float r32 = r27 * r17
            float r31 = r31 + r32
            float r32 = r3 * r5
            float r33 = r25 * r13
            float r32 = r32 + r33
            float r33 = r26 * r17
            float r32 = r32 + r33
            float r31 = r31 - r32
            float r32 = r20 * r5
            float r33 = r25 * r9
            float r32 = r32 + r33
            float r33 = r28 * r17
            float r32 = r32 + r33
            float r33 = r21 * r5
            float r34 = r24 * r9
            float r33 = r33 + r34
            float r34 = r29 * r17
            float r33 = r33 + r34
            float r32 = r32 - r33
            float r33 = r23 * r5
            float r34 = r26 * r9
            float r33 = r33 + r34
            float r34 = r29 * r13
            float r33 = r33 + r34
            float r34 = r22 * r5
            float r35 = r27 * r9
            float r34 = r34 + r35
            float r35 = r28 * r13
            float r34 = r34 + r35
            float r33 = r33 - r34
            float r34 = r19 * r8
            float r35 = r20 * r12
            float r34 = r34 + r35
            float r35 = r23 * r16
            float r34 = r34 + r35
            float r35 = r3 * r8
            float r36 = r21 * r12
            float r35 = r35 + r36
            float r36 = r22 * r16
            float r35 = r35 + r36
            float r34 = r34 - r35
            float r3 = r3 * r4
            float r35 = r25 * r12
            float r3 = r3 + r35
            float r35 = r26 * r16
            float r3 = r3 + r35
            float r19 = r19 * r4
            float r35 = r24 * r12
            float r19 = r19 + r35
            float r35 = r27 * r16
            float r19 = r19 + r35
            float r3 = r3 - r19
            float r21 = r21 * r4
            float r24 = r24 * r8
            float r21 = r21 + r24
            float r19 = r29 * r16
            float r21 = r21 + r19
            float r20 = r20 * r4
            float r25 = r25 * r8
            float r20 = r20 + r25
            float r19 = r28 * r16
            float r20 = r20 + r19
            float r21 = r21 - r20
            float r22 = r22 * r4
            float r27 = r27 * r8
            float r22 = r22 + r27
            float r28 = r28 * r12
            float r22 = r22 + r28
            float r23 = r23 * r4
            float r26 = r26 * r8
            float r23 = r23 + r26
            float r29 = r29 * r12
            float r23 = r23 + r29
            float r22 = r22 - r23
            float r19 = r12 * r17
            float r20 = r16 * r13
            float r23 = r8 * r17
            float r24 = r16 * r9
            float r25 = r8 * r13
            float r26 = r12 * r9
            float r17 = r17 * r4
            float r27 = r16 * r5
            float r13 = r13 * r4
            float r28 = r12 * r5
            float r9 = r9 * r4
            float r5 = r5 * r8
            float r29 = r19 * r11
            float r35 = r24 * r15
            float r29 = r29 + r35
            float r35 = r25 * r2
            float r29 = r29 + r35
            float r35 = r20 * r11
            float r36 = r23 * r15
            float r35 = r35 + r36
            float r36 = r26 * r2
            float r35 = r35 + r36
            float r29 = r29 - r35
            float r35 = r20 * r7
            float r36 = r17 * r15
            float r35 = r35 + r36
            float r36 = r28 * r2
            float r35 = r35 + r36
            float r36 = r19 * r7
            float r37 = r27 * r15
            float r36 = r36 + r37
            float r37 = r13 * r2
            float r36 = r36 + r37
            float r35 = r35 - r36
            float r36 = r23 * r7
            float r37 = r27 * r11
            float r36 = r36 + r37
            float r37 = r9 * r2
            float r36 = r36 + r37
            float r37 = r24 * r7
            float r38 = r17 * r11
            float r37 = r37 + r38
            float r2 = r2 * r5
            float r37 = r37 + r2
            float r36 = r36 - r37
            float r2 = r26 * r7
            float r37 = r13 * r11
            float r2 = r2 + r37
            float r37 = r5 * r15
            float r2 = r2 + r37
            float r7 = r7 * r25
            float r11 = r11 * r28
            float r7 = r7 + r11
            float r15 = r15 * r9
            float r7 = r7 + r15
            float r2 = r2 - r7
            float r7 = r23 * r14
            float r11 = r26 * r18
            float r7 = r7 + r11
            float r11 = r20 * r10
            float r7 = r7 + r11
            float r11 = r25 * r18
            float r15 = r19 * r10
            float r11 = r11 + r15
            float r15 = r24 * r14
            float r11 = r11 + r15
            float r7 = r7 - r11
            float r11 = r13 * r18
            float r19 = r19 * r6
            float r11 = r11 + r19
            float r15 = r27 * r14
            float r11 = r11 + r15
            float r15 = r17 * r14
            float r19 = r28 * r18
            float r15 = r15 + r19
            float r20 = r20 * r6
            float r15 = r15 + r20
            float r11 = r11 - r15
            float r17 = r17 * r10
            float r15 = r5 * r18
            float r17 = r17 + r15
            float r24 = r24 * r6
            float r17 = r17 + r24
            float r18 = r18 * r9
            float r23 = r23 * r6
            float r18 = r18 + r23
            float r27 = r27 * r10
            float r18 = r18 + r27
            float r17 = r17 - r18
            float r9 = r9 * r14
            float r25 = r25 * r6
            float r9 = r9 + r25
            float r28 = r28 * r10
            float r9 = r9 + r28
            float r13 = r13 * r10
            float r5 = r5 * r14
            float r13 = r13 + r5
            float r26 = r26 * r6
            float r13 = r13 + r26
            float r9 = r9 - r13
            float r4 = r4 * r30
            float r8 = r8 * r31
            float r4 = r4 + r8
            float r12 = r12 * r32
            float r4 = r4 + r12
            float r16 = r16 * r33
            float r4 = r4 + r16
            r5 = 0
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x01d7
            r0 = 0
            return r0
        L_0x01d7:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 / r4
            float r30 = r30 * r5
            r39[r40] = r30
            int r4 = r40 + 1
            float r31 = r31 * r5
            r39[r4] = r31
            int r4 = r40 + 2
            float r32 = r32 * r5
            r39[r4] = r32
            int r4 = r40 + 3
            float r33 = r33 * r5
            r39[r4] = r33
            int r4 = r40 + 4
            float r34 = r34 * r5
            r39[r4] = r34
            int r4 = r40 + 5
            float r3 = r3 * r5
            r39[r4] = r3
            int r3 = r40 + 6
            float r21 = r21 * r5
            r39[r3] = r21
            int r3 = r40 + 7
            float r22 = r22 * r5
            r39[r3] = r22
            int r3 = r40 + 8
            float r29 = r29 * r5
            r39[r3] = r29
            int r3 = r40 + 9
            float r35 = r35 * r5
            r39[r3] = r35
            int r3 = r40 + 10
            float r36 = r36 * r5
            r39[r3] = r36
            int r3 = r40 + 11
            float r2 = r2 * r5
            r39[r3] = r2
            int r2 = r40 + 12
            float r7 = r7 * r5
            r39[r2] = r7
            int r2 = r40 + 13
            float r11 = r11 * r5
            r39[r2] = r11
            int r2 = r40 + 14
            float r17 = r17 * r5
            r39[r2] = r17
            int r1 = r40 + 15
            float r9 = r9 * r5
            r39[r1] = r9
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.representation.Matrix.invertM(float[], int, float[], int):boolean");
    }

    public static float length(float f, float f2, float f3) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2) + (f3 * f3)));
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [float[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void multiplyMM(float[] r27, int r28, float[] r29, int r30, float[] r31, int r32) {
        /*
            int r4 = r28 + 0
            int r5 = r30 + 0
            r6 = r29[r5]
            int r7 = r32 + 0
            r8 = r31[r7]
            float r6 = r6 * r8
            int r8 = r30 + 4
            r9 = r29[r8]
            int r10 = r32 + 1
            r11 = r31[r10]
            float r9 = r9 * r11
            float r6 = r6 + r9
            int r9 = r30 + 8
            r11 = r29[r9]
            int r12 = r32 + 2
            r13 = r31[r12]
            float r11 = r11 * r13
            float r6 = r6 + r11
            int r11 = r30 + 12
            r13 = r29[r11]
            int r14 = r32 + 3
            r15 = r31[r14]
            float r13 = r13 * r15
            float r6 = r6 + r13
            r27[r4] = r6
            int r4 = r28 + 1
            int r6 = r30 + 1
            r13 = r29[r6]
            r15 = r31[r7]
            float r13 = r13 * r15
            int r15 = r30 + 5
            r16 = r29[r15]
            r17 = r31[r10]
            float r16 = r16 * r17
            float r13 = r13 + r16
            int r16 = r30 + 9
            r17 = r29[r16]
            r18 = r31[r12]
            float r17 = r17 * r18
            float r13 = r13 + r17
            int r17 = r30 + 13
            r18 = r29[r17]
            r19 = r31[r14]
            float r18 = r18 * r19
            float r13 = r13 + r18
            r27[r4] = r13
            int r4 = r28 + 2
            int r13 = r30 + 2
            r18 = r29[r13]
            r19 = r31[r7]
            float r18 = r18 * r19
            int r19 = r30 + 6
            r20 = r29[r19]
            r21 = r31[r10]
            float r20 = r20 * r21
            float r18 = r18 + r20
            int r20 = r30 + 10
            r21 = r29[r20]
            r22 = r31[r12]
            float r21 = r21 * r22
            float r18 = r18 + r21
            int r21 = r30 + 14
            r22 = r29[r21]
            r23 = r31[r14]
            float r22 = r22 * r23
            float r18 = r18 + r22
            r27[r4] = r18
            int r4 = r28 + 3
            int r18 = r30 + 3
            r22 = r29[r18]
            r7 = r31[r7]
            float r22 = r22 * r7
            int r7 = r30 + 7
            r23 = r29[r7]
            r10 = r31[r10]
            float r23 = r23 * r10
            float r22 = r22 + r23
            int r10 = r30 + 11
            r23 = r29[r10]
            r12 = r31[r12]
            float r23 = r23 * r12
            float r22 = r22 + r23
            int r2 = r30 + 15
            r12 = r29[r2]
            r14 = r31[r14]
            float r12 = r12 * r14
            float r22 = r22 + r12
            r27[r4] = r22
            int r4 = r28 + 4
            r12 = r29[r5]
            int r14 = r32 + 4
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r8]
            int r23 = r32 + 5
            r24 = r31[r23]
            float r22 = r22 * r24
            float r12 = r12 + r22
            r22 = r29[r9]
            int r24 = r32 + 6
            r25 = r31[r24]
            float r22 = r22 * r25
            float r12 = r12 + r22
            r22 = r29[r11]
            int r25 = r32 + 7
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 5
            r12 = r29[r6]
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r15]
            r26 = r31[r23]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r16]
            r26 = r31[r24]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r17]
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 6
            r12 = r29[r13]
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r19]
            r26 = r31[r23]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r20]
            r26 = r31[r24]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r21]
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 7
            r12 = r29[r18]
            r14 = r31[r14]
            float r12 = r12 * r14
            r14 = r29[r7]
            r22 = r31[r23]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r14 = r29[r10]
            r22 = r31[r24]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r14 = r29[r2]
            r22 = r31[r25]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r27[r4] = r12
            int r4 = r28 + 8
            r12 = r29[r5]
            int r14 = r32 + 8
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r8]
            int r23 = r32 + 9
            r24 = r31[r23]
            float r22 = r22 * r24
            float r12 = r12 + r22
            r22 = r29[r9]
            int r24 = r32 + 10
            r25 = r31[r24]
            float r22 = r22 * r25
            float r12 = r12 + r22
            r22 = r29[r11]
            int r25 = r32 + 11
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 9
            r12 = r29[r6]
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r15]
            r26 = r31[r23]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r16]
            r26 = r31[r24]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r17]
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 10
            r12 = r29[r13]
            r22 = r31[r14]
            float r12 = r12 * r22
            r22 = r29[r19]
            r26 = r31[r23]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r20]
            r26 = r31[r24]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r22 = r29[r21]
            r26 = r31[r25]
            float r22 = r22 * r26
            float r12 = r12 + r22
            r27[r4] = r12
            int r4 = r28 + 11
            r12 = r29[r18]
            r14 = r31[r14]
            float r12 = r12 * r14
            r14 = r29[r7]
            r22 = r31[r23]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r14 = r29[r10]
            r22 = r31[r24]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r14 = r29[r2]
            r22 = r31[r25]
            float r14 = r14 * r22
            float r12 = r12 + r14
            r27[r4] = r12
            int r4 = r28 + 12
            r5 = r29[r5]
            int r12 = r32 + 12
            r14 = r31[r12]
            float r5 = r5 * r14
            r8 = r29[r8]
            int r14 = r32 + 13
            r22 = r31[r14]
            float r8 = r8 * r22
            float r5 = r5 + r8
            r8 = r29[r9]
            int r9 = r32 + 14
            r22 = r31[r9]
            float r8 = r8 * r22
            float r5 = r5 + r8
            r8 = r29[r11]
            int r3 = r32 + 15
            r11 = r31[r3]
            float r8 = r8 * r11
            float r5 = r5 + r8
            r27[r4] = r5
            int r4 = r28 + 13
            r5 = r29[r6]
            r6 = r31[r12]
            float r5 = r5 * r6
            r6 = r29[r15]
            r8 = r31[r14]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r6 = r29[r16]
            r8 = r31[r9]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r6 = r29[r17]
            r8 = r31[r3]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r27[r4] = r5
            int r4 = r28 + 14
            r5 = r29[r13]
            r6 = r31[r12]
            float r5 = r5 * r6
            r6 = r29[r19]
            r8 = r31[r14]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r6 = r29[r20]
            r8 = r31[r9]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r6 = r29[r21]
            r8 = r31[r3]
            float r6 = r6 * r8
            float r5 = r5 + r6
            r27[r4] = r5
            int r0 = r28 + 15
            r4 = r29[r18]
            r5 = r31[r12]
            float r4 = r4 * r5
            r5 = r29[r7]
            r6 = r31[r14]
            float r5 = r5 * r6
            float r4 = r4 + r5
            r5 = r29[r10]
            r6 = r31[r9]
            float r5 = r5 * r6
            float r4 = r4 + r5
            r1 = r29[r2]
            r2 = r31[r3]
            float r1 = r1 * r2
            float r4 = r4 + r1
            r27[r0] = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.representation.Matrix.multiplyMM(float[], int, float[], int, float[], int):void");
    }

    /* JADX WARNING: type inference failed for: r20v0, types: [float[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void multiplyMM(float[] r20, float[] r21, float[] r22) {
        /*
            r2 = 0
            r3 = r21[r2]
            r4 = r22[r2]
            float r3 = r3 * r4
            r4 = 4
            r5 = r21[r4]
            r6 = 1
            r7 = r22[r6]
            float r5 = r5 * r7
            float r3 = r3 + r5
            r5 = 8
            r7 = r21[r5]
            r8 = 2
            r9 = r22[r8]
            float r7 = r7 * r9
            float r3 = r3 + r7
            r7 = 12
            r9 = r21[r7]
            r10 = 3
            r11 = r22[r10]
            float r9 = r9 * r11
            float r3 = r3 + r9
            r20[r2] = r3
            r3 = r21[r6]
            r9 = r22[r2]
            float r3 = r3 * r9
            r9 = 5
            r11 = r21[r9]
            r12 = r22[r6]
            float r11 = r11 * r12
            float r3 = r3 + r11
            r11 = 9
            r12 = r21[r11]
            r13 = r22[r8]
            float r12 = r12 * r13
            float r3 = r3 + r12
            r12 = 13
            r13 = r21[r12]
            r14 = r22[r10]
            float r13 = r13 * r14
            float r3 = r3 + r13
            r20[r6] = r3
            r3 = r21[r8]
            r13 = r22[r2]
            float r3 = r3 * r13
            r13 = 6
            r14 = r21[r13]
            r15 = r22[r6]
            float r14 = r14 * r15
            float r3 = r3 + r14
            r14 = 10
            r15 = r21[r14]
            r16 = r22[r8]
            float r15 = r15 * r16
            float r3 = r3 + r15
            r15 = 14
            r16 = r21[r15]
            r17 = r22[r10]
            float r16 = r16 * r17
            float r3 = r3 + r16
            r20[r8] = r3
            r3 = r21[r10]
            r16 = r22[r2]
            float r3 = r3 * r16
            r16 = 7
            r17 = r21[r16]
            r18 = r22[r6]
            float r17 = r17 * r18
            float r3 = r3 + r17
            r17 = 11
            r18 = r21[r17]
            r19 = r22[r8]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = 15
            r18 = r21[r18]
            r19 = r22[r10]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r10] = r3
            r3 = r21[r2]
            r18 = r22[r4]
            float r3 = r3 * r18
            r18 = r21[r4]
            r19 = r22[r9]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r5]
            r19 = r22[r13]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r7]
            r19 = r22[r16]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r4] = r3
            r3 = r21[r6]
            r18 = r22[r4]
            float r3 = r3 * r18
            r18 = r21[r9]
            r19 = r22[r9]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r11]
            r19 = r22[r13]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r12]
            r19 = r22[r16]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r9] = r3
            r3 = r21[r8]
            r18 = r22[r4]
            float r3 = r3 * r18
            r18 = r21[r13]
            r19 = r22[r9]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r14]
            r19 = r22[r13]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r15]
            r19 = r22[r16]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r13] = r3
            r3 = r21[r10]
            r18 = r22[r4]
            float r3 = r3 * r18
            r18 = r21[r16]
            r19 = r22[r9]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r17]
            r19 = r22[r13]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = 15
            r18 = r21[r18]
            r19 = r22[r16]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r16] = r3
            r3 = r21[r2]
            r18 = r22[r5]
            float r3 = r3 * r18
            r18 = r21[r4]
            r19 = r22[r11]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r5]
            r19 = r22[r14]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r7]
            r19 = r22[r17]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r5] = r3
            r3 = r21[r6]
            r18 = r22[r5]
            float r3 = r3 * r18
            r18 = r21[r9]
            r19 = r22[r11]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r11]
            r19 = r22[r14]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r12]
            r19 = r22[r17]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r11] = r3
            r3 = r21[r8]
            r18 = r22[r5]
            float r3 = r3 * r18
            r18 = r21[r13]
            r19 = r22[r11]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r14]
            r19 = r22[r14]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r15]
            r19 = r22[r17]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r14] = r3
            r3 = r21[r10]
            r18 = r22[r5]
            float r3 = r3 * r18
            r18 = r21[r16]
            r19 = r22[r11]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = r21[r17]
            r19 = r22[r14]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r18 = 15
            r18 = r21[r18]
            r19 = r22[r17]
            float r18 = r18 * r19
            float r3 = r3 + r18
            r20[r17] = r3
            r2 = r21[r2]
            r3 = r22[r7]
            float r2 = r2 * r3
            r3 = r21[r4]
            r4 = r22[r12]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r5]
            r4 = r22[r15]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r7]
            r4 = 15
            r4 = r22[r4]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r20[r7] = r2
            r2 = r21[r6]
            r3 = r22[r7]
            float r2 = r2 * r3
            r3 = r21[r9]
            r4 = r22[r12]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r11]
            r4 = r22[r15]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r12]
            r4 = 15
            r4 = r22[r4]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r20[r12] = r2
            r2 = r21[r8]
            r3 = r22[r7]
            float r2 = r2 * r3
            r3 = r21[r13]
            r4 = r22[r12]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r14]
            r4 = r22[r15]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r15]
            r4 = 15
            r4 = r22[r4]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r20[r15] = r2
            r2 = r21[r10]
            r3 = r22[r7]
            float r2 = r2 * r3
            r3 = r21[r16]
            r4 = r22[r12]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = r21[r17]
            r4 = r22[r15]
            float r3 = r3 * r4
            float r2 = r2 + r3
            r3 = 15
            r0 = r21[r3]
            r1 = r22[r3]
            float r0 = r0 * r1
            float r2 = r2 + r0
            r0 = 15
            r20[r0] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.representation.Matrix.multiplyMM(float[], float[], float[]):void");
    }

    public static void multiplyMV(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3) {
        int i4 = i3 + 0;
        int i5 = i3 + 1;
        int i6 = i3 + 2;
        int i7 = i3 + 3;
        fArr[i + 0] = (fArr2[i2 + 0] * fArr3[i4]) + (fArr2[i2 + 4] * fArr3[i5]) + (fArr2[i2 + 8] * fArr3[i6]) + (fArr2[i2 + 12] * fArr3[i7]);
        fArr[i + 1] = (fArr2[i2 + 1] * fArr3[i4]) + (fArr2[i2 + 5] * fArr3[i5]) + (fArr2[i2 + 9] * fArr3[i6]) + (fArr2[i2 + 13] * fArr3[i7]);
        fArr[i + 2] = (fArr2[i2 + 2] * fArr3[i4]) + (fArr2[i2 + 6] * fArr3[i5]) + (fArr2[i2 + 10] * fArr3[i6]) + (fArr2[i2 + 14] * fArr3[i7]);
        fArr[i + 3] = (fArr2[i2 + 3] * fArr3[i4]) + (fArr2[i2 + 7] * fArr3[i5]) + (fArr2[i2 + 11] * fArr3[i6]) + (fArr2[i2 + 15] * fArr3[i7]);
    }

    public static void multiplyMV(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[8] * fArr3[2]) + (fArr2[12] * fArr3[3]);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[9] * fArr3[2]) + (fArr2[13] * fArr3[3]);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1]) + (fArr2[10] * fArr3[2]) + (fArr2[14] * fArr3[3]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[7] * fArr3[1]) + (fArr2[11] * fArr3[2]) + (fArr2[15] * fArr3[3]);
    }

    public static void multiplyMV3(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[8] * fArr3[2]) + (fArr2[12] * f);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[9] * fArr3[2]) + (fArr2[13] * f);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1]) + (fArr2[10] * fArr3[2]) + (fArr2[14] * f);
    }

    public static void orthoM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        } else if (f3 == f4) {
            throw new IllegalArgumentException("bottom == top");
        } else if (f5 != f6) {
            float f7 = 1.0f / (f2 - f);
            float f8 = 1.0f / (f4 - f3);
            float f9 = 1.0f / (f6 - f5);
            fArr[i + 0] = f7 * 2.0f;
            fArr[i + 5] = 2.0f * f8;
            fArr[i + 10] = -2.0f * f9;
            fArr[i + 12] = (-(f2 + f)) * f7;
            fArr[i + 13] = (-(f4 + f3)) * f8;
            fArr[i + 14] = (-(f6 + f5)) * f9;
            fArr[i + 15] = 1.0f;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 3] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 7] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 11] = 0.0f;
        } else {
            throw new IllegalArgumentException("near == far");
        }
    }

    public static void perspectiveM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        float tan = 1.0f / ((float) Math.tan(((double) f) * 0.008726646259971648d));
        float f5 = 1.0f / (f3 - f4);
        fArr[i + 0] = tan / f2;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 5] = tan;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = (f4 + f3) * f5;
        fArr[i + 11] = -1.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = f4 * 2.0f * f3 * f5;
        fArr[i + 15] = 0.0f;
    }

    public static void rotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        synchronized (TEMP_MATRIX_ARRAY) {
            setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
            multiplyMM(TEMP_MATRIX_ARRAY, 16, fArr, i, TEMP_MATRIX_ARRAY, 0);
            System.arraycopy(TEMP_MATRIX_ARRAY, 16, fArr, i, 16);
        }
    }

    public static void rotateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3, float f4) {
        synchronized (TEMP_MATRIX_ARRAY) {
            setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
            multiplyMM(fArr, i, fArr2, i2, TEMP_MATRIX_ARRAY, 0);
        }
    }

    public static void scaleM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            fArr[i3] = fArr[i3] * f;
            int i4 = i3 + 4;
            fArr[i4] = fArr[i4] * f2;
            int i5 = i3 + 8;
            fArr[i5] = fArr[i5] * f3;
        }
    }

    public static void scaleM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i + i3;
            int i5 = i2 + i3;
            fArr[i4] = fArr2[i5] * f;
            fArr[i4 + 4] = fArr2[i5 + 4] * f2;
            fArr[i4 + 8] = fArr2[i5 + 8] * f3;
            fArr[i4 + 12] = fArr2[i5 + 12];
        }
    }

    public static void setIdentityM(float[] fArr, int i) {
        for (int i2 = 0; i2 < 16; i2++) {
            fArr[i + i2] = 0.0f;
        }
        for (int i3 = 0; i3 < 16; i3 += 5) {
            fArr[i + i3] = 1.0f;
        }
    }

    public static void setLookAtM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float[] fArr2 = fArr;
        int i2 = i;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f4 - f10;
        float f14 = f5 - f11;
        float f15 = f6 - f12;
        float length = length(f13, f14, f15) != 0.0f ? 1.0f / length(f13, f14, f15) : 1.0f;
        float f16 = f13 * length;
        float f17 = f14 * length;
        float f18 = f15 * length;
        float f19 = (f17 * f9) - (f18 * f8);
        float f20 = (f18 * f7) - (f16 * f9);
        float f21 = (f16 * f8) - (f17 * f7);
        float length2 = length(f19, f20, f21) != 0.0f ? 1.0f / length(f19, f20, f21) : 1.0f;
        float f22 = f19 * length2;
        float f23 = f20 * length2;
        float f24 = f21 * length2;
        fArr2[i2 + 0] = f22;
        fArr2[i2 + 1] = (f23 * f18) - (f24 * f17);
        fArr2[i2 + 2] = -f16;
        fArr2[i2 + 3] = 0.0f;
        fArr2[i2 + 4] = f23;
        fArr2[i2 + 5] = (f24 * f16) - (f22 * f18);
        fArr2[i2 + 6] = -f17;
        fArr2[i2 + 7] = 0.0f;
        fArr2[i2 + 8] = f24;
        fArr2[i2 + 9] = (f22 * f17) - (f23 * f16);
        fArr2[i2 + 10] = -f18;
        fArr2[i2 + 11] = 0.0f;
        fArr2[i2 + 12] = 0.0f;
        fArr2[i2 + 13] = 0.0f;
        fArr2[i2 + 14] = 0.0f;
        fArr2[i2 + 15] = 1.0f;
        translateM(fArr2, i2, -f10, -f11, -f12);
    }

    public static void setRotateEulerM(float[] fArr, int i, float f, float f2, float f3) {
        double d = (double) (f * 0.017453292f);
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        double d2 = (double) (f2 * 0.017453292f);
        float cos2 = (float) Math.cos(d2);
        float sin2 = (float) Math.sin(d2);
        double d3 = (double) (f3 * 0.017453292f);
        float cos3 = (float) Math.cos(d3);
        float sin3 = (float) Math.sin(d3);
        float f4 = cos * sin2;
        float f5 = sin * sin2;
        fArr[i + 0] = cos2 * cos3;
        fArr[i + 1] = (-cos2) * sin3;
        fArr[i + 2] = sin2;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = (f4 * cos3) + (cos * sin3);
        fArr[i + 5] = ((-f4) * sin3) + (cos * cos3);
        fArr[i + 6] = (-sin) * cos2;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = ((-f5) * cos3) + (sin * sin3);
        fArr[i + 9] = (f5 * sin3) + (sin * cos3);
        fArr[i + 10] = cos * cos2;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
    }

    public static void setRotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        fArr[i + 3] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        double d = (double) (f * 0.017453292f);
        float sin = (float) Math.sin(d);
        float cos = (float) Math.cos(d);
        if (1.0f == f2 && 0.0f == f3 && 0.0f == f4) {
            fArr[i + 5] = cos;
            fArr[i + 10] = cos;
            fArr[i + 6] = sin;
            fArr[i + 9] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 0] = 1.0f;
            return;
        }
        int i2 = (0.0f > f2 ? 1 : (0.0f == f2 ? 0 : -1));
        if (i2 == 0 && 1.0f == f3 && 0.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 10] = cos;
            fArr[i + 8] = sin;
            fArr[i + 2] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 5] = 1.0f;
        } else if (i2 == 0 && 0.0f == f3 && 1.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 5] = cos;
            fArr[i + 1] = sin;
            fArr[i + 4] = -sin;
            fArr[i + 2] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 10] = 1.0f;
        } else {
            float length = length(f2, f3, f4);
            if (1.0f != length) {
                float f5 = 1.0f / length;
                f2 *= f5;
                f3 *= f5;
                f4 *= f5;
            }
            float f6 = 1.0f - cos;
            float f7 = f2 * sin;
            float f8 = f3 * sin;
            float f9 = sin * f4;
            fArr[i + 0] = (f2 * f2 * f6) + cos;
            float f10 = f2 * f3 * f6;
            fArr[i + 4] = f10 - f9;
            float f11 = f4 * f2 * f6;
            fArr[i + 8] = f11 + f8;
            fArr[i + 1] = f10 + f9;
            fArr[i + 5] = (f3 * f3 * f6) + cos;
            float f12 = f3 * f4 * f6;
            fArr[i + 9] = f12 - f7;
            fArr[i + 2] = f11 - f8;
            fArr[i + 6] = f12 + f7;
            fArr[i + 10] = (f4 * f4 * f6) + cos;
        }
    }

    public static void translateM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            int i4 = i3 + 12;
            fArr[i4] = fArr[i4] + (fArr[i3] * f) + (fArr[i3 + 4] * f2) + (fArr[i3 + 8] * f3);
        }
    }

    public static void translateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        for (int i3 = 0; i3 < 12; i3++) {
            fArr[i + i3] = fArr2[i2 + i3];
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i2 + i4;
            fArr[i + i4 + 12] = (fArr2[i5] * f) + (fArr2[i5 + 4] * f2) + (fArr2[i5 + 8] * f3) + fArr2[i5 + 12];
        }
    }

    public static void transposeM(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = (i3 * 4) + i2;
            fArr[i3 + i] = fArr2[i4];
            fArr[i3 + 4 + i] = fArr2[i4 + 1];
            fArr[i3 + 8 + i] = fArr2[i4 + 2];
            fArr[i3 + 12 + i] = fArr2[i4 + 3];
        }
    }
}
