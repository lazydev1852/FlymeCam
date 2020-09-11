package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkAndNudgePoints(com.google.zxing.common.BitMatrix r9, float[] r10) throws com.google.zxing.NotFoundException {
        /*
            int r0 = r9.getWidth()
            int r9 = r9.getHeight()
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x000c:
            int r5 = r10.length
            r6 = 0
            r7 = -1
            if (r3 >= r5) goto L_0x0049
            if (r4 != 0) goto L_0x0014
            goto L_0x0049
        L_0x0014:
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x0044
            if (r4 > r0) goto L_0x0044
            if (r8 < r7) goto L_0x0044
            if (r8 > r9) goto L_0x0044
            if (r4 != r7) goto L_0x002a
            r10[r3] = r6
        L_0x0028:
            r4 = 1
            goto L_0x0033
        L_0x002a:
            if (r4 != r0) goto L_0x0032
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0028
        L_0x0032:
            r4 = 0
        L_0x0033:
            if (r8 != r7) goto L_0x0039
            r10[r5] = r6
        L_0x0037:
            r4 = 1
            goto L_0x0041
        L_0x0039:
            if (r8 != r9) goto L_0x0041
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0037
        L_0x0041:
            int r3 = r3 + 2
            goto L_0x000c
        L_0x0044:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L_0x0049:
            int r3 = r10.length
            int r3 = r3 + -2
            r4 = 1
        L_0x004d:
            if (r3 < 0) goto L_0x0087
            if (r4 != 0) goto L_0x0052
            goto L_0x0087
        L_0x0052:
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x0082
            if (r4 > r0) goto L_0x0082
            if (r8 < r7) goto L_0x0082
            if (r8 > r9) goto L_0x0082
            if (r4 != r7) goto L_0x0068
            r10[r3] = r6
        L_0x0066:
            r4 = 1
            goto L_0x0071
        L_0x0068:
            if (r4 != r0) goto L_0x0070
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0066
        L_0x0070:
            r4 = 0
        L_0x0071:
            if (r8 != r7) goto L_0x0077
            r10[r5] = r6
        L_0x0075:
            r4 = 1
            goto L_0x007f
        L_0x0077:
            if (r8 != r9) goto L_0x007f
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0075
        L_0x007f:
            int r3 = r3 + -2
            goto L_0x004d
        L_0x0082:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.GridSampler.checkAndNudgePoints(com.google.zxing.common.BitMatrix, float[]):void");
    }
}
