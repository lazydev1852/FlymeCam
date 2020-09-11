package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

public final class DecodedBitStreamParser {

    /* renamed from: $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode */
    private static /* synthetic */ int[] f2432xca07ee0 = null;

    /* renamed from: AL */
    private static final int f2433AL = 28;

    /* renamed from: AS */
    private static final int f2434AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final BigInteger[] EXP900 = new BigInteger[16];

    /* renamed from: LL */
    private static final int f2435LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', 13, 9, ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};

    /* renamed from: ML */
    private static final int f2436ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;

    /* renamed from: PL */
    private static final int f2437PL = 25;

    /* renamed from: PS */
    private static final int f2438PS = 29;
    private static final char[] PUNCT_CHARS = {';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', 13, 9, ',', ':', 10, '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|10|11|12|13|(2:14|15)|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* renamed from: $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] m2758xca07ee0() {
        /*
            int[] r0 = f2432xca07ee0
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0039 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
        L_0x0039:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0042 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
        L_0x0042:
            f2432xca07ee0 = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.m2758xca07ee0():int[]");
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f A[LOOP:0: B:1:0x0011->B:24:0x005f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.zxing.common.DecoderResult decode(int[] r5, java.lang.String r6) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r5.length
            r2 = 2
            int r1 = r1 * 2
            r0.<init>(r1)
            r1 = 1
            r1 = r5[r1]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
        L_0x0011:
            r4 = 0
            r4 = r5[r4]
            if (r2 < r4) goto L_0x002f
            int r5 = r0.length()
            if (r5 == 0) goto L_0x002a
            com.google.zxing.common.DecoderResult r5 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r5.<init>(r1, r0, r1, r6)
            r5.setOther(r3)
            return r5
        L_0x002a:
            com.google.zxing.FormatException r5 = com.google.zxing.FormatException.getFormatInstance()
            throw r5
        L_0x002f:
            r4 = 913(0x391, float:1.28E-42)
            if (r1 == r4) goto L_0x0058
            r4 = 928(0x3a0, float:1.3E-42)
            if (r1 == r4) goto L_0x0053
            switch(r1) {
                case 900: goto L_0x004e;
                case 901: goto L_0x0058;
                case 902: goto L_0x0049;
                default: goto L_0x003a;
            }
        L_0x003a:
            switch(r1) {
                case 922: goto L_0x0044;
                case 923: goto L_0x0044;
                case 924: goto L_0x0058;
                default: goto L_0x003d;
            }
        L_0x003d:
            int r2 = r2 + -1
            int r1 = textCompaction(r5, r2, r0)
            goto L_0x005c
        L_0x0044:
            com.google.zxing.FormatException r5 = com.google.zxing.FormatException.getFormatInstance()
            throw r5
        L_0x0049:
            int r1 = numericCompaction(r5, r2, r0)
            goto L_0x005c
        L_0x004e:
            int r1 = textCompaction(r5, r2, r0)
            goto L_0x005c
        L_0x0053:
            int r1 = decodeMacroBlock(r5, r2, r3)
            goto L_0x005c
        L_0x0058:
            int r1 = byteCompaction(r1, r5, r2, r0)
        L_0x005c:
            int r2 = r5.length
            if (r1 >= r2) goto L_0x0064
            int r2 = r1 + 1
            r1 = r5[r1]
            goto L_0x0011
        L_0x0064:
            com.google.zxing.FormatException r5 = com.google.zxing.FormatException.getFormatInstance()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i4 = textCompaction + 1;
                int[] iArr3 = new int[(iArr[0] - i4)];
                boolean z = false;
                int i5 = 0;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < TEXT_COMPACTION_MODE_LATCH) {
                        iArr3[i5] = i7;
                        i4 = i6;
                        i5++;
                    } else if (i7 == MACRO_PDF417_TERMINATOR) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i4 = i6 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
                return i4;
            } else if (iArr[textCompaction] != MACRO_PDF417_TERMINATOR) {
                return textCompaction;
            } else {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                        default:
                            switch (i4) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b7, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d9, code lost:
        r3 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f9, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00fa, code lost:
        if (r3 == 0) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fc, code lost:
        r0.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ff, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r14, int[] r15, int r16, java.lang.StringBuilder r17) {
        /*
            r0 = r17
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r4 = r1
            r5 = r2
            r2 = 0
            r1 = r16
        L_0x000b:
            if (r2 < r1) goto L_0x000e
            return
        L_0x000e:
            r6 = r14[r2]
            int[] r7 = m2758xca07ee0()
            int r8 = r4.ordinal()
            r7 = r7[r8]
            r8 = 28
            r9 = 27
            r10 = 32
            r11 = 913(0x391, float:1.28E-42)
            r12 = 900(0x384, float:1.261E-42)
            r13 = 29
            r3 = 26
            switch(r7) {
                case 1: goto L_0x00d1;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0078;
                case 4: goto L_0x005c;
                case 5: goto L_0x0047;
                case 6: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x00f9
        L_0x002d:
            if (r6 >= r13) goto L_0x0034
            char[] r3 = PUNCT_CHARS
            char r3 = r3[r6]
            goto L_0x004c
        L_0x0034:
            if (r6 != r13) goto L_0x0039
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0039:
            if (r6 != r11) goto L_0x0042
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x0059
        L_0x0042:
            if (r6 != r12) goto L_0x0059
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0047:
            if (r6 >= r3) goto L_0x004f
            int r6 = r6 + 65
            char r3 = (char) r6
        L_0x004c:
            r4 = r5
            goto L_0x00fa
        L_0x004f:
            if (r6 != r3) goto L_0x0054
            r4 = r5
            goto L_0x00d9
        L_0x0054:
            if (r6 != r12) goto L_0x0059
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0059:
            r4 = r5
            goto L_0x00f9
        L_0x005c:
            if (r6 >= r13) goto L_0x0064
            char[] r3 = PUNCT_CHARS
            char r3 = r3[r6]
            goto L_0x00fa
        L_0x0064:
            if (r6 != r13) goto L_0x0069
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0069:
            if (r6 != r11) goto L_0x0073
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f9
        L_0x0073:
            if (r6 != r12) goto L_0x00f9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0078:
            r7 = 25
            if (r6 >= r7) goto L_0x0082
            char[] r3 = MIXED_CHARS
            char r3 = r3[r6]
            goto L_0x00fa
        L_0x0082:
            if (r6 != r7) goto L_0x0089
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
        L_0x0086:
            r4 = r3
            goto L_0x00f9
        L_0x0089:
            if (r6 != r3) goto L_0x008c
            goto L_0x00d9
        L_0x008c:
            if (r6 != r9) goto L_0x0091
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0086
        L_0x0091:
            if (r6 != r8) goto L_0x0096
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x0096:
            if (r6 != r13) goto L_0x009b
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b7
        L_0x009b:
            if (r6 != r11) goto L_0x00a5
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f9
        L_0x00a5:
            if (r6 != r12) goto L_0x00f9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x00aa:
            if (r6 >= r3) goto L_0x00b0
            int r6 = r6 + 97
            char r3 = (char) r6
            goto L_0x00fa
        L_0x00b0:
            if (r6 != r3) goto L_0x00b3
            goto L_0x00d9
        L_0x00b3:
            if (r6 != r9) goto L_0x00b9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
        L_0x00b7:
            r5 = r4
            goto L_0x0086
        L_0x00b9:
            if (r6 != r8) goto L_0x00be
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0086
        L_0x00be:
            if (r6 != r13) goto L_0x00c3
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b7
        L_0x00c3:
            if (r6 != r11) goto L_0x00cc
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f9
        L_0x00cc:
            if (r6 != r12) goto L_0x00f9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x00d1:
            if (r6 >= r3) goto L_0x00d7
            int r6 = r6 + 65
            char r3 = (char) r6
            goto L_0x00fa
        L_0x00d7:
            if (r6 != r3) goto L_0x00dc
        L_0x00d9:
            r3 = 32
            goto L_0x00fa
        L_0x00dc:
            if (r6 != r9) goto L_0x00e1
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0086
        L_0x00e1:
            if (r6 != r8) goto L_0x00e6
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0086
        L_0x00e6:
            if (r6 != r13) goto L_0x00eb
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b7
        L_0x00eb:
            if (r6 != r11) goto L_0x00f4
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f9
        L_0x00f4:
            if (r6 != r12) goto L_0x00f9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0086
        L_0x00f9:
            r3 = 0
        L_0x00fa:
            if (r3 == 0) goto L_0x00ff
            r0.append(r3)
        L_0x00ff:
            int r2 = r2 + 1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, int i2, StringBuilder sb) {
        int i3;
        int i4 = i;
        StringBuilder sb2 = sb;
        int i5 = MACRO_PDF417_TERMINATOR;
        int i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        long j = 900;
        if (i4 == BYTE_COMPACTION_MODE_LATCH) {
            char[] cArr = new char[6];
            int[] iArr2 = new int[6];
            int i7 = iArr[i2];
            int i8 = i2 + 1;
            boolean z = false;
            int i9 = 0;
            long j2 = 0;
            while (i8 < iArr[0] && !z) {
                int i10 = i9 + 1;
                iArr2[i9] = i7;
                j2 = (j2 * j) + ((long) i7);
                int i11 = i8 + 1;
                int i12 = iArr[i8];
                if (i12 == TEXT_COMPACTION_MODE_LATCH || i12 == BYTE_COMPACTION_MODE_LATCH || i12 == NUMERIC_COMPACTION_MODE_LATCH || i12 == BYTE_COMPACTION_MODE_LATCH_6 || i12 == 928 || i12 == i6 || i12 == i5) {
                    i11--;
                    i9 = i10;
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    j = 900;
                    z = true;
                } else if (i10 % 5 != 0 || i10 <= 0) {
                    i9 = i10;
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    j = 900;
                } else {
                    int i13 = 0;
                    while (i13 < 6) {
                        cArr[5 - i13] = (char) ((int) (j2 % 256));
                        j2 >>= 8;
                        i13++;
                        i5 = MACRO_PDF417_TERMINATOR;
                        i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    }
                    sb2.append(cArr);
                    j = 900;
                    i9 = 0;
                }
                int i14 = i11;
                i7 = i12;
                i8 = i14;
            }
            if (i8 != iArr[0] || i7 >= TEXT_COMPACTION_MODE_LATCH) {
                i3 = i9;
            } else {
                iArr2[i9] = i7;
                i3 = i9 + 1;
            }
            for (int i15 = 0; i15 < i3; i15++) {
                sb2.append((char) iArr2[i15]);
            }
            return i8;
        } else if (i4 != BYTE_COMPACTION_MODE_LATCH_6) {
            return i2;
        } else {
            int i16 = i2;
            int i17 = 0;
            boolean z2 = false;
            long j3 = 0;
            while (i16 < iArr[0] && !z2) {
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                if (i19 < TEXT_COMPACTION_MODE_LATCH) {
                    i17++;
                    j3 = (j3 * 900) + ((long) i19);
                    i16 = i18;
                } else {
                    if (i19 != TEXT_COMPACTION_MODE_LATCH && i19 != BYTE_COMPACTION_MODE_LATCH && i19 != NUMERIC_COMPACTION_MODE_LATCH && i19 != BYTE_COMPACTION_MODE_LATCH_6 && i19 != 928) {
                        if (i19 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                            if (i19 != MACRO_PDF417_TERMINATOR) {
                                i16 = i18;
                            }
                            i16 = i18 - 1;
                            z2 = true;
                        }
                    }
                    i16 = i18 - 1;
                    z2 = true;
                }
                if (i17 % 5 == 0 && i17 > 0) {
                    char[] cArr2 = new char[6];
                    int i20 = 0;
                    for (int i21 = 6; i20 < i21; i21 = 6) {
                        cArr2[5 - i20] = (char) ((int) (j3 & 255));
                        j3 >>= 8;
                        i20++;
                    }
                    sb2.append(cArr2);
                    i17 = 0;
                }
            }
            return i16;
        }
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        loop0:
        while (true) {
            int i2 = 0;
            while (i < iArr[0] && !z) {
                int i3 = i + 1;
                int i4 = iArr[i];
                if (i3 == iArr[0]) {
                    z = true;
                }
                if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                    iArr2[i2] = i4;
                    i2++;
                } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                    i3--;
                    z = true;
                }
                if (i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) {
                    sb.append(decodeBase900toBase10(iArr2, i2));
                    i = i3;
                } else {
                    i = i3;
                }
            }
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
