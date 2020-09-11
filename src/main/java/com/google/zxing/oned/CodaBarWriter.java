package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char[] START_END_CHARS = {'A', 'B', 'C', 'D'};

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ca A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r11) {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 2
            if (r0 < r1) goto L_0x0151
            r0 = 0
            char r1 = r11.charAt(r0)
            char r1 = java.lang.Character.toUpperCase(r1)
            int r2 = r11.length()
            r3 = 1
            int r2 = r2 - r3
            char r2 = r11.charAt(r2)
            char r2 = java.lang.Character.toUpperCase(r2)
            char[] r4 = START_END_CHARS
            boolean r4 = com.google.zxing.oned.CodaBarReader.arrayContains(r4, r1)
            if (r4 == 0) goto L_0x0030
            char[] r4 = START_END_CHARS
            boolean r4 = com.google.zxing.oned.CodaBarReader.arrayContains(r4, r2)
            if (r4 == 0) goto L_0x0030
            r4 = 1
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            char[] r5 = ALT_START_END_CHARS
            boolean r1 = com.google.zxing.oned.CodaBarReader.arrayContains(r5, r1)
            if (r1 == 0) goto L_0x0043
            char[] r1 = ALT_START_END_CHARS
            boolean r1 = com.google.zxing.oned.CodaBarReader.arrayContains(r1, r2)
            if (r1 == 0) goto L_0x0043
            r1 = 1
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            if (r4 != 0) goto L_0x0071
            if (r1 == 0) goto L_0x0049
            goto L_0x0071
        L_0x0049:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Codabar should start/end with "
            r0.<init>(r1)
            char[] r1 = START_END_CHARS
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r0.append(r1)
            java.lang.String r1 = ", or start/end with "
            r0.append(r1)
            char[] r1 = ALT_START_END_CHARS
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0071:
            r1 = 20
            r1 = 1
            r2 = 20
        L_0x0076:
            int r4 = r11.length()
            int r4 = r4 - r3
            if (r1 < r4) goto L_0x0104
            int r1 = r11.length()
            int r1 = r1 - r3
            int r2 = r2 + r1
            boolean[] r4 = new boolean[r2]
            r5 = 0
            r6 = 0
        L_0x0087:
            int r1 = r11.length()
            if (r5 < r1) goto L_0x008e
            return r4
        L_0x008e:
            char r1 = r11.charAt(r5)
            char r1 = java.lang.Character.toUpperCase(r1)
            if (r5 == 0) goto L_0x009f
            int r2 = r11.length()
            int r2 = r2 - r3
            if (r5 != r2) goto L_0x00af
        L_0x009f:
            r2 = 42
            if (r1 == r2) goto L_0x00c0
            r2 = 69
            if (r1 == r2) goto L_0x00bb
            r2 = 78
            if (r1 == r2) goto L_0x00b6
            r2 = 84
            if (r1 == r2) goto L_0x00b1
        L_0x00af:
            r7 = r1
            goto L_0x00c4
        L_0x00b1:
            r1 = 65
            r7 = 65
            goto L_0x00c4
        L_0x00b6:
            r1 = 66
            r7 = 66
            goto L_0x00c4
        L_0x00bb:
            r1 = 68
            r7 = 68
            goto L_0x00c4
        L_0x00c0:
            r1 = 67
            r7 = 67
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            char[] r2 = com.google.zxing.oned.CodaBarReader.ALPHABET
            int r2 = r2.length
            if (r1 < r2) goto L_0x00cc
            r2 = 0
            goto L_0x00d7
        L_0x00cc:
            char[] r2 = com.google.zxing.oned.CodaBarReader.ALPHABET
            char r2 = r2[r1]
            if (r7 != r2) goto L_0x0101
            int[] r2 = com.google.zxing.oned.CodaBarReader.CHARACTER_ENCODINGS
            r1 = r2[r1]
            r2 = r1
        L_0x00d7:
            r1 = 0
            r7 = 1
        L_0x00d9:
            r8 = 0
        L_0x00da:
            r9 = 7
            if (r1 < r9) goto L_0x00eb
            int r1 = r11.length()
            int r1 = r1 - r3
            if (r5 >= r1) goto L_0x00e8
            r4[r6] = r0
            int r6 = r6 + 1
        L_0x00e8:
            int r5 = r5 + 1
            goto L_0x0087
        L_0x00eb:
            r4[r6] = r7
            int r6 = r6 + 1
            int r9 = 6 - r1
            int r9 = r2 >> r9
            r9 = r9 & r3
            if (r9 == 0) goto L_0x00fc
            if (r8 != r3) goto L_0x00f9
            goto L_0x00fc
        L_0x00f9:
            int r8 = r8 + 1
            goto L_0x00da
        L_0x00fc:
            r7 = r7 ^ 1
            int r1 = r1 + 1
            goto L_0x00d9
        L_0x0101:
            int r1 = r1 + 1
            goto L_0x00c5
        L_0x0104:
            char r4 = r11.charAt(r1)
            boolean r4 = java.lang.Character.isDigit(r4)
            if (r4 != 0) goto L_0x014b
            char r4 = r11.charAt(r1)
            r5 = 45
            if (r4 == r5) goto L_0x014b
            char r4 = r11.charAt(r1)
            r5 = 36
            if (r4 != r5) goto L_0x011f
            goto L_0x014b
        L_0x011f:
            char[] r4 = CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED
            char r5 = r11.charAt(r1)
            boolean r4 = com.google.zxing.oned.CodaBarReader.arrayContains(r4, r5)
            if (r4 == 0) goto L_0x012e
            int r2 = r2 + 10
            goto L_0x014d
        L_0x012e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Cannot encode : '"
            r2.<init>(r3)
            char r11 = r11.charAt(r1)
            r2.append(r11)
            r11 = 39
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r0.<init>(r11)
            throw r0
        L_0x014b:
            int r2 = r2 + 9
        L_0x014d:
            int r1 = r1 + 1
            goto L_0x0076
        L_0x0151:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Codabar should start/end with start/stop symbols"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.CodaBarWriter.encode(java.lang.String):boolean[]");
    }
}
