package com.google.zxing.oned.rss.expanded;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.meizu.camera.MeizuCamera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES;
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM;
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY}, new int[]{Opcodes.INSTANCEOF, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, Opcodes.RET, 85, 44, 132}, new int[]{Opcodes.INVOKEINTERFACE, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, Opcodes.IFLE, 52, 156}, new int[]{46, 138, MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY, Opcodes.NEW, 139, 206, 196, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, Opcodes.IFEQ, 37, 111, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, 155}, new int[]{43, 129, Opcodes.ARETURN, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, 137, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, Opcodes.GETSTATIC, 112, 125, 164}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, 179, 115}, new int[]{134, 191, Opcodes.DCMPL, 31, 93, 68, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 190}, new int[]{Opcodes.LCMP, 22, 66, Opcodes.IFNULL, 172, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, Opcodes.CHECKCAST, Opcodes.IFNE, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, Opcodes.IAND, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, 175}, new int[]{103, 98, 83, 38, 114, 131, Opcodes.INVOKEVIRTUAL, 124}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, 127, 170, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, Opcodes.IF_ICMPNE, 58, 174, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven = false;

    static {
        int[] iArr = new int[5];
        iArr[1] = 348;
        iArr[2] = 1388;
        iArr[3] = 2948;
        iArr[4] = 3988;
        GSUM = iArr;
        int[] iArr2 = new int[3];
        iArr2[1] = 1;
        iArr2[2] = 1;
        int[] iArr3 = new int[4];
        iArr3[1] = 2;
        iArr3[2] = 1;
        iArr3[3] = 3;
        int[] iArr4 = new int[5];
        iArr4[1] = 4;
        iArr4[2] = 1;
        iArr4[3] = 3;
        iArr4[4] = 2;
        int[] iArr5 = new int[6];
        iArr5[1] = 4;
        iArr5[2] = 1;
        iArr5[3] = 3;
        iArr5[4] = 3;
        iArr5[5] = 5;
        int[] iArr6 = new int[7];
        iArr6[1] = 4;
        iArr6[2] = 1;
        iArr6[3] = 3;
        iArr6[4] = 4;
        iArr6[5] = 5;
        iArr6[6] = 5;
        int[] iArr7 = new int[8];
        iArr7[2] = 1;
        iArr7[3] = 1;
        iArr7[4] = 2;
        iArr7[5] = 2;
        iArr7[6] = 3;
        iArr7[7] = 3;
        int[] iArr8 = new int[9];
        iArr8[2] = 1;
        iArr8[3] = 1;
        iArr8[4] = 2;
        iArr8[5] = 2;
        iArr8[6] = 3;
        iArr8[7] = 4;
        iArr8[8] = 4;
        int[] iArr9 = new int[10];
        iArr9[2] = 1;
        iArr9[3] = 1;
        iArr9[4] = 2;
        iArr9[5] = 2;
        iArr9[6] = 3;
        iArr9[7] = 4;
        iArr9[8] = 5;
        iArr9[9] = 5;
        int[] iArr10 = new int[11];
        iArr10[2] = 1;
        iArr10[3] = 1;
        iArr10[4] = 2;
        iArr10[5] = 3;
        iArr10[6] = 3;
        iArr10[7] = 4;
        iArr10[8] = 4;
        iArr10[9] = 5;
        iArr10[10] = 5;
        FINDER_PATTERN_SEQUENCES = new int[][]{new int[2], iArr2, iArr3, iArr4, iArr5, iArr6, iArr7, iArr8, iArr9, iArr10};
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                } else if (checkChecksum()) {
                    return this.pairs;
                } else {
                    boolean z = !this.rows.isEmpty();
                    storeRow(i, false);
                    if (z) {
                        List<ExpandedPair> checkRows = checkRows(false);
                        if (checkRows != null) {
                            return checkRows;
                        }
                        List<ExpandedPair> checkRows2 = checkRows(true);
                        if (checkRows2 != null) {
                            return checkRows2;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
            list = null;
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pairs.addAll(list.get(i2).getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException unused) {
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        boolean z;
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i).getFinderPattern().getValue() != iArr[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z3 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (!z2 && !z3 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z;
        Iterator<ExpandedRow> it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow next = it.next();
            if (next.getPairs().size() != list.size()) {
                Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (it2.hasNext()) {
                        ExpandedPair next2 = it2.next();
                        Iterator<ExpandedPair> it3 = list.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (next2.equals(it3.next())) {
                                    continue;
                                    break;
                                }
                            } else {
                                z2 = false;
                                continue;
                                break;
                            }
                        }
                        if (!z2) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z;
        boolean z2;
        Iterator<ExpandedRow> it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                ExpandedRow next = it.next();
                Iterator<ExpandedPair> it2 = iterable.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ExpandedPair next2 = it2.next();
                        Iterator<ExpandedPair> it3 = next.getPairs().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (next2.equals(it3.next())) {
                                    z2 = true;
                                    continue;
                                    break;
                                }
                            } else {
                                z2 = false;
                                continue;
                                break;
                            }
                        }
                        if (!z2) {
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, (byte[]) null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i++;
            }
        }
        if (((i - 4) * 211) + (checksumPortion % 211) == leftChar.getValue()) {
            return true;
        }
        return false;
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    /* access modifiers changed from: package-private */
    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).mustBeLast()) {
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (!z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) ^ z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        this.startEnd[0] = i2;
                        this.startEnd[1] = i;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            i2 = i5 + 1;
            i3 = this.startEnd[0] - i2;
            i4 = this.startEnd[1];
        } else {
            i2 = this.startEnd[0];
            i4 = bitArray.getNextUnset(this.startEnd[1] + 1);
            i3 = i4 - this.startEnd[1];
        }
        int i6 = i2;
        int i7 = i4;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i3;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i6, i7}, i6, i7, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.oned.rss.DataCharacter decodeDataCharacter(com.google.zxing.common.BitArray r17, com.google.zxing.oned.rss.FinderPattern r18, boolean r19, boolean r20) throws com.google.zxing.NotFoundException {
        /*
            r16 = this;
            r0 = r17
            int[] r2 = r16.getDataCharacterCounters()
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = 3
            r2[r6] = r3
            r6 = 4
            r2[r6] = r3
            r7 = 5
            r2[r7] = r3
            r7 = 6
            r2[r7] = r3
            r7 = 7
            r2[r7] = r3
            if (r20 == 0) goto L_0x002a
            int[] r7 = r18.getStartEnd()
            r7 = r7[r3]
            recordPatternInReverse(r0, r7, r2)
            goto L_0x0039
        L_0x002a:
            int[] r7 = r18.getStartEnd()
            r7 = r7[r4]
            recordPattern(r0, r7, r2)
            int r0 = r2.length
            int r0 = r0 - r4
            r7 = r0
            r0 = 0
        L_0x0037:
            if (r0 < r7) goto L_0x0149
        L_0x0039:
            r0 = 17
            int r7 = count(r2)
            float r7 = (float) r7
            float r8 = (float) r0
            float r7 = r7 / r8
            int[] r8 = r18.getStartEnd()
            r8 = r8[r4]
            int[] r9 = r18.getStartEnd()
            r9 = r9[r3]
            int r8 = r8 - r9
            float r8 = (float) r8
            r9 = 1097859072(0x41700000, float:15.0)
            float r8 = r8 / r9
            float r9 = r7 - r8
            float r9 = java.lang.Math.abs(r9)
            float r9 = r9 / r8
            r8 = 1050253722(0x3e99999a, float:0.3)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 > 0) goto L_0x0142
            int[] r9 = r16.getOddCounts()
            int[] r10 = r16.getEvenCounts()
            float[] r11 = r16.getOddRoundingErrors()
            float[] r12 = r16.getEvenRoundingErrors()
            r13 = 0
        L_0x0072:
            int r14 = r2.length
            if (r13 < r14) goto L_0x00f8
            r14 = r16
            r14.adjustOddEvenCounts(r0)
            int r0 = r18.getValue()
            int r0 = r0 * 4
            if (r19 == 0) goto L_0x0084
            r2 = 0
            goto L_0x0085
        L_0x0084:
            r2 = 2
        L_0x0085:
            int r0 = r0 + r2
            r2 = r20 ^ 1
            int r0 = r0 + r2
            int r15 = r0 + -1
            int r0 = r9.length
            int r0 = r0 - r4
            r2 = 0
            r7 = 0
        L_0x008f:
            if (r0 >= 0) goto L_0x00df
            int r0 = r10.length
            int r0 = r0 - r4
            r8 = 0
        L_0x0094:
            if (r0 >= 0) goto L_0x00c8
            int r2 = r2 + r8
            r0 = r7 & 1
            if (r0 != 0) goto L_0x00c3
            r0 = 13
            if (r7 > r0) goto L_0x00c3
            if (r7 < r6) goto L_0x00c3
            int r0 = r0 - r7
            int r0 = r0 / r5
            int[] r1 = SYMBOL_WIDEST
            r1 = r1[r0]
            int r5 = 9 - r1
            int r1 = com.google.zxing.oned.rss.RSSUtils.getRSSvalue(r9, r1, r4)
            int r3 = com.google.zxing.oned.rss.RSSUtils.getRSSvalue(r10, r5, r3)
            int[] r4 = EVEN_TOTAL_SUBSET
            r4 = r4[r0]
            int[] r5 = GSUM
            r0 = r5[r0]
            int r1 = r1 * r4
            int r1 = r1 + r3
            int r1 = r1 + r0
            com.google.zxing.oned.rss.DataCharacter r0 = new com.google.zxing.oned.rss.DataCharacter
            r0.<init>(r1, r2)
            return r0
        L_0x00c3:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x00c8:
            boolean r11 = isNotA1left(r18, r19, r20)
            if (r11 == 0) goto L_0x00dc
            int[][] r11 = WEIGHTS
            r11 = r11[r15]
            int r12 = r0 * 2
            int r12 = r12 + r4
            r11 = r11[r12]
            r12 = r10[r0]
            int r12 = r12 * r11
            int r8 = r8 + r12
        L_0x00dc:
            int r0 = r0 + -1
            goto L_0x0094
        L_0x00df:
            boolean r8 = isNotA1left(r18, r19, r20)
            if (r8 == 0) goto L_0x00f2
            int[][] r8 = WEIGHTS
            r8 = r8[r15]
            int r11 = r0 * 2
            r8 = r8[r11]
            r11 = r9[r0]
            int r11 = r11 * r8
            int r2 = r2 + r11
        L_0x00f2:
            r8 = r9[r0]
            int r7 = r7 + r8
            int r0 = r0 + -1
            goto L_0x008f
        L_0x00f8:
            r14 = r16
            r15 = 1065353216(0x3f800000, float:1.0)
            r0 = r2[r13]
            float r0 = (float) r0
            float r0 = r0 * r15
            float r0 = r0 / r7
            r15 = 1056964608(0x3f000000, float:0.5)
            float r3 = r0 + r15
            int r3 = (int) r3
            r5 = 8
            if (r3 >= r4) goto L_0x0116
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0111
            r3 = 1
            goto L_0x0127
        L_0x0111:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x0116:
            if (r3 <= r5) goto L_0x0127
            r3 = 1091253043(0x410b3333, float:8.7)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0122
            r3 = 8
            goto L_0x0127
        L_0x0122:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x0127:
            int r5 = r13 / 2
            r15 = r13 & 1
            if (r15 != 0) goto L_0x0134
            r9[r5] = r3
            float r3 = (float) r3
            float r0 = r0 - r3
            r11[r5] = r0
            goto L_0x013a
        L_0x0134:
            r10[r5] = r3
            float r3 = (float) r3
            float r0 = r0 - r3
            r12[r5] = r0
        L_0x013a:
            int r13 = r13 + 1
            r0 = 17
            r3 = 0
            r5 = 2
            goto L_0x0072
        L_0x0142:
            r14 = r16
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x0149:
            r14 = r16
            r3 = r2[r0]
            r5 = r2[r7]
            r2[r0] = r5
            r2[r7] = r3
            int r0 = r0 + 1
            int r7 = r7 + -1
            r3 = 0
            r5 = 2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.decodeDataCharacter(com.google.zxing.common.BitArray, com.google.zxing.oned.rss.FinderPattern, boolean, boolean):com.google.zxing.oned.rss.DataCharacter");
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return finderPattern.getValue() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adjustOddEvenCounts(int r11) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.getOddCounts()
            int r0 = count(r0)
            int[] r1 = r10.getEvenCounts()
            int r1 = count(r1)
            int r2 = r0 + r1
            int r2 = r2 - r11
            r11 = r0 & 1
            r3 = 0
            r4 = 1
            if (r11 != r4) goto L_0x001b
            r11 = 1
            goto L_0x001c
        L_0x001b:
            r11 = 0
        L_0x001c:
            r5 = r1 & 1
            if (r5 != 0) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            r6 = 4
            r7 = 13
            if (r0 <= r7) goto L_0x002b
            r8 = 0
            r9 = 1
            goto L_0x0031
        L_0x002b:
            if (r0 >= r6) goto L_0x002f
            r8 = 1
            goto L_0x0030
        L_0x002f:
            r8 = 0
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r1 <= r7) goto L_0x0035
            r6 = 1
            goto L_0x0039
        L_0x0035:
            if (r1 >= r6) goto L_0x0038
            r3 = 1
        L_0x0038:
            r6 = 0
        L_0x0039:
            if (r2 != r4) goto L_0x004f
            if (r11 == 0) goto L_0x0046
            if (r5 != 0) goto L_0x0041
        L_0x003f:
            r9 = 1
            goto L_0x0079
        L_0x0041:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0046:
            if (r5 == 0) goto L_0x004a
            r6 = 1
            goto L_0x0079
        L_0x004a:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x004f:
            r7 = -1
            if (r2 != r7) goto L_0x0066
            if (r11 == 0) goto L_0x005d
            if (r5 != 0) goto L_0x0058
        L_0x0056:
            r8 = 1
            goto L_0x0079
        L_0x0058:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x005d:
            if (r5 == 0) goto L_0x0061
            r3 = 1
            goto L_0x0079
        L_0x0061:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0066:
            if (r2 != 0) goto L_0x00c3
            if (r11 == 0) goto L_0x0077
            if (r5 == 0) goto L_0x0072
            if (r0 >= r1) goto L_0x0070
            r6 = 1
            goto L_0x0056
        L_0x0070:
            r3 = 1
            goto L_0x003f
        L_0x0072:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0077:
            if (r5 != 0) goto L_0x00be
        L_0x0079:
            if (r8 == 0) goto L_0x008e
            if (r9 != 0) goto L_0x0089
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x008e
        L_0x0089:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x008e:
            if (r9 == 0) goto L_0x009b
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            decrement(r11, r0)
        L_0x009b:
            if (r3 == 0) goto L_0x00b0
            if (r6 != 0) goto L_0x00ab
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x00b0
        L_0x00ab:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00b0:
            if (r6 == 0) goto L_0x00bd
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getEvenRoundingErrors()
            decrement(r11, r0)
        L_0x00bd:
            return
        L_0x00be:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00c3:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.adjustOddEvenCounts(int):void");
    }
}
