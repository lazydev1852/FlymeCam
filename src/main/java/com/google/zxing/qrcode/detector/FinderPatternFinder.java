package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, (ResultPointCallback) null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback2;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2 = map;
        boolean z = map2 != null && map2.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map2 != null && map2.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        boolean z3 = false;
        while (i2 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean z4 = z3;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < width) {
                if (this.image.get(i5, i2)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 4) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (handlePossibleCenter(iArr, i2, i5, z2)) {
                        if (this.hasSkipped) {
                            z4 = haveMultiplyConfirmedCenters();
                        } else {
                            int findRowSkip = findRowSkip();
                            if (findRowSkip > iArr[2]) {
                                i2 += (findRowSkip - iArr[2]) - 2;
                                i5 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i6 = 0;
                        i4 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i6 = 3;
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
                i5++;
            }
            if (!foundPatternCross(iArr) || !handlePossibleCenter(iArr, i2, width, z2)) {
                i3 = i4;
            } else {
                int i7 = iArr[0];
                if (this.hasSkipped) {
                    i3 = i7;
                    z3 = haveMultiplyConfirmedCenters();
                    i2 += i3;
                } else {
                    i3 = i7;
                }
            }
            z3 = z4;
            i2 += i3;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a5 A[LOOP:4: B:41:0x00a5->B:49:0x00bb, LOOP_START, PHI: r10 
  PHI: (r10v2 int) = (r10v1 int), (r10v5 int) binds: [B:40:0x00a1, B:49:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ce A[LOOP:5: B:55:0x00ce->B:63:0x00e4, LOOP_START, PHI: r10 
  PHI: (r10v3 int) = (r10v2 int), (r10v4 int) binds: [B:54:0x00cb, B:63:0x00e4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0113 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0114 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean crossCheckDiagonal(int r16, int r17, int r18, int r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            int[] r4 = r15.getCrossCheckStateCount()
            r5 = 0
            r6 = 0
        L_0x000d:
            r7 = 2
            r8 = 1
            if (r1 < r6) goto L_0x0028
            if (r2 < r6) goto L_0x0028
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 != 0) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            r9 = r4[r7]
            int r9 = r9 + r8
            r4[r7] = r9
            int r6 = r6 + 1
            goto L_0x000d
        L_0x0028:
            if (r1 < r6) goto L_0x0116
            if (r2 >= r6) goto L_0x002e
            goto L_0x0116
        L_0x002e:
            if (r1 < r6) goto L_0x004b
            if (r2 < r6) goto L_0x004b
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 != 0) goto L_0x004b
            r9 = r4[r8]
            if (r9 <= r3) goto L_0x0043
            goto L_0x004b
        L_0x0043:
            r9 = r4[r8]
            int r9 = r9 + r8
            r4[r8] = r9
            int r6 = r6 + 1
            goto L_0x002e
        L_0x004b:
            if (r1 < r6) goto L_0x0115
            if (r2 < r6) goto L_0x0115
            r9 = r4[r8]
            if (r9 <= r3) goto L_0x0055
            goto L_0x0115
        L_0x0055:
            if (r1 < r6) goto L_0x0072
            if (r2 < r6) goto L_0x0072
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 == 0) goto L_0x0072
            r9 = r4[r5]
            if (r9 <= r3) goto L_0x006a
            goto L_0x0072
        L_0x006a:
            r9 = r4[r5]
            int r9 = r9 + r8
            r4[r5] = r9
            int r6 = r6 + 1
            goto L_0x0055
        L_0x0072:
            r6 = r4[r5]
            if (r6 <= r3) goto L_0x0077
            return r5
        L_0x0077:
            com.google.zxing.common.BitMatrix r6 = r0.image
            int r6 = r6.getHeight()
            com.google.zxing.common.BitMatrix r9 = r0.image
            int r9 = r9.getWidth()
            r10 = 1
        L_0x0084:
            int r11 = r1 + r10
            if (r11 >= r6) goto L_0x009d
            int r12 = r2 + r10
            if (r12 >= r9) goto L_0x009d
            com.google.zxing.common.BitMatrix r13 = r0.image
            boolean r12 = r13.get(r12, r11)
            if (r12 != 0) goto L_0x0095
            goto L_0x009d
        L_0x0095:
            r11 = r4[r7]
            int r11 = r11 + r8
            r4[r7] = r11
            int r10 = r10 + 1
            goto L_0x0084
        L_0x009d:
            if (r11 >= r6) goto L_0x0114
            int r11 = r2 + r10
            if (r11 < r9) goto L_0x00a5
            goto L_0x0114
        L_0x00a5:
            int r11 = r1 + r10
            r12 = 3
            if (r11 >= r6) goto L_0x00c3
            int r13 = r2 + r10
            if (r13 >= r9) goto L_0x00c3
            com.google.zxing.common.BitMatrix r14 = r0.image
            boolean r13 = r14.get(r13, r11)
            if (r13 != 0) goto L_0x00c3
            r13 = r4[r12]
            if (r13 < r3) goto L_0x00bb
            goto L_0x00c3
        L_0x00bb:
            r11 = r4[r12]
            int r11 = r11 + r8
            r4[r12] = r11
            int r10 = r10 + 1
            goto L_0x00a5
        L_0x00c3:
            if (r11 >= r6) goto L_0x0113
            int r11 = r2 + r10
            if (r11 >= r9) goto L_0x0113
            r11 = r4[r12]
            if (r11 < r3) goto L_0x00ce
            goto L_0x0113
        L_0x00ce:
            int r11 = r1 + r10
            r13 = 4
            if (r11 >= r6) goto L_0x00ed
            int r14 = r2 + r10
            if (r14 >= r9) goto L_0x00ed
            com.google.zxing.common.BitMatrix r12 = r0.image
            boolean r11 = r12.get(r14, r11)
            if (r11 == 0) goto L_0x00ed
            r11 = r4[r13]
            if (r11 < r3) goto L_0x00e4
            goto L_0x00ed
        L_0x00e4:
            r11 = r4[r13]
            int r11 = r11 + r8
            r4[r13] = r11
            int r10 = r10 + 1
            r12 = 3
            goto L_0x00ce
        L_0x00ed:
            r1 = r4[r13]
            if (r1 < r3) goto L_0x00f2
            return r5
        L_0x00f2:
            r1 = r4[r5]
            r2 = r4[r8]
            int r1 = r1 + r2
            r2 = r4[r7]
            int r1 = r1 + r2
            r2 = 3
            r2 = r4[r2]
            int r1 = r1 + r2
            r2 = r4[r13]
            int r1 = r1 + r2
            int r1 = r1 - r19
            int r1 = java.lang.Math.abs(r1)
            int r2 = r19 * 2
            if (r1 >= r2) goto L_0x0112
            boolean r1 = foundPatternCross(r4)
            if (r1 == 0) goto L_0x0112
            return r8
        L_0x0112:
            return r5
        L_0x0113:
            return r5
        L_0x0114:
            return r5
        L_0x0115:
            return r5
        L_0x0116:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckDiagonal(int, int, int, int):boolean");
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount2[1] <= i3) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount2[0] <= i3) {
            crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
            i5--;
        }
        if (crossCheckStateCount2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < height && bitMatrix.get(i2, i6)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i6++;
        }
        if (i6 == height) {
            return Float.NaN;
        }
        while (i6 < height && !bitMatrix.get(i2, i6) && crossCheckStateCount2[3] < i3) {
            crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
            i6++;
        }
        if (i6 == height || crossCheckStateCount2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < height && bitMatrix.get(i2, i6) && crossCheckStateCount2[4] < i3) {
            crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
            i6++;
        }
        if (crossCheckStateCount2[4] < i3 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount2)) {
            return centerFromEnd(crossCheckStateCount2, i6);
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount2[1] <= i3) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount2[0] <= i3) {
            crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
            i5--;
        }
        if (crossCheckStateCount2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < width && bitMatrix.get(i6, i2)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i6++;
        }
        if (i6 == width) {
            return Float.NaN;
        }
        while (i6 < width && !bitMatrix.get(i6, i2) && crossCheckStateCount2[3] < i3) {
            crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
            i6++;
        }
        if (i6 == width || crossCheckStateCount2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < width && bitMatrix.get(i6, i2) && crossCheckStateCount2[4] < i3) {
            crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
            i6++;
        }
        if (crossCheckStateCount2[4] < i3 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount2)) {
            return centerFromEnd(crossCheckStateCount2, i6);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, centerFromEnd, iArr[2], i3);
        if (!Float.isNaN(crossCheckVertical)) {
            int i4 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i4, iArr[2], i3);
            if (!Float.isNaN(crossCheckHorizontal) && (!z || crossCheckDiagonal(i4, (int) crossCheckHorizontal, iArr[2], i3))) {
                float f = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                    this.possibleCenters.add(finderPattern2);
                    if (this.resultPointCallback != null) {
                        this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = next;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                i++;
                f2 += next.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.possibleCenters) {
            f += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f3);
        }
        return f <= f2 * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (FinderPattern estimatedModuleSize : this.possibleCenters) {
                    float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                    f2 += estimatedModuleSize2;
                    f3 += estimatedModuleSize2 * estimatedModuleSize2;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                float sqrt = (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5)));
                Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f5, (FurthestFromAverageComparator) null));
                float max = Math.max(0.2f * f5, sqrt);
                int i = 0;
                while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                    if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f5) > max) {
                        this.possibleCenters.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.possibleCenters.size() > 3) {
                for (FinderPattern estimatedModuleSize3 : this.possibleCenters) {
                    f += estimatedModuleSize3.getEstimatedModuleSize();
                }
                Collections.sort(this.possibleCenters, new CenterComparator(f / ((float) this.possibleCenters.size()), (CenterComparator) null));
                this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
            }
            return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        /* synthetic */ FurthestFromAverageComparator(float f, FurthestFromAverageComparator furthestFromAverageComparator) {
            this(f);
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        /* synthetic */ CenterComparator(float f, CenterComparator centerComparator) {
            this(f);
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }
}
