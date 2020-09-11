package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r13) {
        /*
            r12 = this;
            int r0 = r13.length()
            r1 = 1
            if (r0 < r1) goto L_0x00e6
            r2 = 80
            if (r0 > r2) goto L_0x00e6
            r2 = 0
            r3 = 0
        L_0x000d:
            r4 = 32
            if (r3 < r0) goto L_0x00c1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 1
        L_0x001a:
            if (r3 < r0) goto L_0x0066
            int r6 = r6 % 103
            int[][] r13 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r13 = r13[r6]
            r5.add(r13)
            int[][] r13 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r0 = 106(0x6a, float:1.49E-43)
            r13 = r13[r0]
            r5.add(r13)
            java.util.Iterator r9 = r5.iterator()
            r13 = 0
        L_0x0033:
            boolean r0 = r9.hasNext()
            if (r0 != 0) goto L_0x0052
            boolean[] r0 = new boolean[r13]
            java.util.Iterator r3 = r5.iterator()
        L_0x003f:
            boolean r13 = r3.hasNext()
            if (r13 != 0) goto L_0x0046
            return r0
        L_0x0046:
            java.lang.Object r13 = r3.next()
            int[] r13 = (int[]) r13
            int r13 = appendPattern(r0, r2, r13, r1)
            int r2 = r2 + r13
            goto L_0x003f
        L_0x0052:
            java.lang.Object r0 = r9.next()
            r10 = r0
            int[] r10 = (int[]) r10
            int r11 = r10.length
            r0 = r13
            r13 = 0
        L_0x005c:
            if (r13 < r11) goto L_0x0060
            r13 = r0
            goto L_0x0033
        L_0x0060:
            r3 = r10[r13]
            int r0 = r0 + r3
            int r13 = r13 + 1
            goto L_0x005c
        L_0x0066:
            r9 = 99
            if (r7 != r9) goto L_0x006c
            r10 = 2
            goto L_0x006d
        L_0x006c:
            r10 = 4
        L_0x006d:
            boolean r10 = isDigits(r13, r3, r10)
            r11 = 100
            if (r10 == 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r9 = 100
        L_0x0078:
            if (r9 != r7) goto L_0x00a1
            char r9 = r13.charAt(r3)
            switch(r9) {
                case 241: goto L_0x0090;
                case 242: goto L_0x008d;
                case 243: goto L_0x008a;
                case 244: goto L_0x009f;
                default: goto L_0x0081;
            }
        L_0x0081:
            if (r7 != r11) goto L_0x0093
            char r9 = r13.charAt(r3)
            int r11 = r9 + -32
            goto L_0x009f
        L_0x008a:
            r11 = 96
            goto L_0x009f
        L_0x008d:
            r11 = 97
            goto L_0x009f
        L_0x0090:
            r11 = 102(0x66, float:1.43E-43)
            goto L_0x009f
        L_0x0093:
            int r9 = r3 + 2
            java.lang.String r9 = r13.substring(r3, r9)
            int r11 = java.lang.Integer.parseInt(r9)
            int r3 = r3 + 1
        L_0x009f:
            int r3 = r3 + r1
            goto L_0x00b1
        L_0x00a1:
            if (r7 != 0) goto L_0x00af
            if (r9 != r11) goto L_0x00aa
            r7 = 104(0x68, float:1.46E-43)
            r11 = 104(0x68, float:1.46E-43)
            goto L_0x00b0
        L_0x00aa:
            r7 = 105(0x69, float:1.47E-43)
            r11 = 105(0x69, float:1.47E-43)
            goto L_0x00b0
        L_0x00af:
            r11 = r9
        L_0x00b0:
            r7 = r9
        L_0x00b1:
            int[][] r9 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r9 = r9[r11]
            r5.add(r9)
            int r11 = r11 * r8
            int r6 = r6 + r11
            if (r3 == 0) goto L_0x001a
            int r8 = r8 + 1
            goto L_0x001a
        L_0x00c1:
            char r5 = r13.charAt(r3)
            if (r5 < r4) goto L_0x00cb
            r4 = 126(0x7e, float:1.77E-43)
            if (r5 <= r4) goto L_0x00e2
        L_0x00cb:
            switch(r5) {
                case 241: goto L_0x00e2;
                case 242: goto L_0x00e2;
                case 243: goto L_0x00e2;
                case 244: goto L_0x00e2;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Bad character in input: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x00e2:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x00e6:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Contents length should be between 1 and 80 characters, but got "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.encode(java.lang.String):boolean[]");
    }

    private static boolean isDigits(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 241) {
                    return false;
                }
                i3++;
            }
            i++;
        }
        if (i3 <= length) {
            return true;
        }
        return false;
    }
}
