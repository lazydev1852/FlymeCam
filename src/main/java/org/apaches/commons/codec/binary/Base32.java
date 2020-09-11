package org.apaches.commons.codec.binary;

import org.apaches.commons.codec.binary.BaseNCodec;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE;
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE;
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        byte[] bArr = new byte[91];
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = -1;
        bArr[44] = -1;
        bArr[45] = -1;
        bArr[46] = -1;
        bArr[47] = -1;
        bArr[48] = -1;
        bArr[49] = -1;
        bArr[50] = 26;
        bArr[51] = 27;
        bArr[52] = 28;
        bArr[53] = 29;
        bArr[54] = 30;
        bArr[55] = 31;
        bArr[56] = -1;
        bArr[57] = -1;
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        DECODE_TABLE = bArr;
        byte[] bArr2 = new byte[88];
        bArr2[0] = -1;
        bArr2[1] = -1;
        bArr2[2] = -1;
        bArr2[3] = -1;
        bArr2[4] = -1;
        bArr2[5] = -1;
        bArr2[6] = -1;
        bArr2[7] = -1;
        bArr2[8] = -1;
        bArr2[9] = -1;
        bArr2[10] = -1;
        bArr2[11] = -1;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        bArr2[16] = -1;
        bArr2[17] = -1;
        bArr2[18] = -1;
        bArr2[19] = -1;
        bArr2[20] = -1;
        bArr2[21] = -1;
        bArr2[22] = -1;
        bArr2[23] = -1;
        bArr2[24] = -1;
        bArr2[25] = -1;
        bArr2[26] = -1;
        bArr2[27] = -1;
        bArr2[28] = -1;
        bArr2[29] = -1;
        bArr2[30] = -1;
        bArr2[31] = -1;
        bArr2[32] = -1;
        bArr2[33] = -1;
        bArr2[34] = -1;
        bArr2[35] = -1;
        bArr2[36] = -1;
        bArr2[37] = -1;
        bArr2[38] = -1;
        bArr2[39] = -1;
        bArr2[40] = -1;
        bArr2[41] = -1;
        bArr2[42] = -1;
        bArr2[43] = -1;
        bArr2[44] = -1;
        bArr2[45] = -1;
        bArr2[46] = -1;
        bArr2[47] = -1;
        bArr2[49] = 1;
        bArr2[50] = 2;
        bArr2[51] = 3;
        bArr2[52] = 4;
        bArr2[53] = 5;
        bArr2[54] = 6;
        bArr2[55] = 7;
        bArr2[56] = 8;
        bArr2[57] = 9;
        bArr2[58] = -1;
        bArr2[59] = -1;
        bArr2[60] = -1;
        bArr2[61] = -1;
        bArr2[62] = -1;
        bArr2[63] = -1;
        bArr2[64] = -1;
        bArr2[65] = 10;
        bArr2[66] = 11;
        bArr2[67] = 12;
        bArr2[68] = 13;
        bArr2[69] = 14;
        bArr2[70] = 15;
        bArr2[71] = 16;
        bArr2[72] = 17;
        bArr2[73] = 18;
        bArr2[74] = 19;
        bArr2[75] = 20;
        bArr2[76] = 21;
        bArr2[77] = 22;
        bArr2[78] = 23;
        bArr2[79] = 24;
        bArr2[80] = 25;
        bArr2[81] = 26;
        bArr2[82] = 27;
        bArr2[83] = 28;
        bArr2[84] = 29;
        bArr2[85] = 30;
        bArr2[86] = 31;
        bArr2[87] = 32;
        HEX_DECODE_TABLE = bArr2;
    }

    public Base32() {
        this(false);
    }

    public Base32(boolean z) {
        this(0, (byte[]) null, z);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
        } else if (!containsAlphabetOrPad(bArr)) {
            this.encodeSize = bArr.length + 8;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + "]");
        }
        this.decodeSize = this.encodeSize - 1;
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        int i3;
        byte b;
        int i4 = i2;
        BaseNCodec.Context context2 = context;
        if (!context2.eof) {
            boolean z = true;
            if (i4 < 0) {
                context2.eof = true;
            }
            int i5 = 0;
            int i6 = i;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                int i7 = i6 + 1;
                byte b2 = bArr[i6];
                if (b2 == 61) {
                    context2.eof = z;
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context2);
                if (b2 < 0 || b2 >= this.decodeTable.length || (b = this.decodeTable[b2]) < 0) {
                    i3 = i5;
                } else {
                    context2.modulus = (context2.modulus + (z ? 1 : 0)) % 8;
                    i3 = i5;
                    context2.lbitWorkArea = (context2.lbitWorkArea << 5) + ((long) b);
                    if (context2.modulus == 0) {
                        int i8 = context2.pos;
                        context2.pos = i8 + 1;
                        ensureBufferSize[i8] = (byte) ((int) ((context2.lbitWorkArea >> 32) & 255));
                        int i9 = context2.pos;
                        context2.pos = i9 + 1;
                        ensureBufferSize[i9] = (byte) ((int) ((context2.lbitWorkArea >> 24) & 255));
                        int i10 = context2.pos;
                        context2.pos = i10 + 1;
                        ensureBufferSize[i10] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        int i11 = context2.pos;
                        context2.pos = i11 + 1;
                        ensureBufferSize[i11] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        int i12 = context2.pos;
                        context2.pos = i12 + 1;
                        ensureBufferSize[i12] = (byte) ((int) (context2.lbitWorkArea & 255));
                    }
                }
                i5 = i3 + 1;
                i6 = i7;
                z = true;
            }
            if (context2.eof && context2.modulus >= 2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context2);
                switch (context2.modulus) {
                    case 2:
                        int i13 = context2.pos;
                        context2.pos = i13 + 1;
                        ensureBufferSize2[i13] = (byte) ((int) ((context2.lbitWorkArea >> 2) & 255));
                        return;
                    case 3:
                        int i14 = context2.pos;
                        context2.pos = i14 + 1;
                        ensureBufferSize2[i14] = (byte) ((int) ((context2.lbitWorkArea >> 7) & 255));
                        return;
                    case 4:
                        context2.lbitWorkArea >>= 4;
                        int i15 = context2.pos;
                        context2.pos = i15 + 1;
                        ensureBufferSize2[i15] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        int i16 = context2.pos;
                        context2.pos = i16 + 1;
                        ensureBufferSize2[i16] = (byte) ((int) (context2.lbitWorkArea & 255));
                        return;
                    case 5:
                        context2.lbitWorkArea >>= z ? 1 : 0;
                        int i17 = context2.pos;
                        context2.pos = i17 + 1;
                        ensureBufferSize2[i17] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        int i18 = context2.pos;
                        context2.pos = i18 + 1;
                        ensureBufferSize2[i18] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        int i19 = context2.pos;
                        context2.pos = i19 + 1;
                        ensureBufferSize2[i19] = (byte) ((int) (context2.lbitWorkArea & 255));
                        return;
                    case 6:
                        context2.lbitWorkArea >>= 6;
                        int i20 = context2.pos;
                        context2.pos = i20 + 1;
                        ensureBufferSize2[i20] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        int i21 = context2.pos;
                        context2.pos = i21 + 1;
                        ensureBufferSize2[i21] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        int i22 = context2.pos;
                        context2.pos = i22 + 1;
                        ensureBufferSize2[i22] = (byte) ((int) (context2.lbitWorkArea & 255));
                        return;
                    case 7:
                        context2.lbitWorkArea >>= 3;
                        int i23 = context2.pos;
                        context2.pos = i23 + 1;
                        ensureBufferSize2[i23] = (byte) ((int) ((context2.lbitWorkArea >> 24) & 255));
                        int i24 = context2.pos;
                        context2.pos = i24 + 1;
                        ensureBufferSize2[i24] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        int i25 = context2.pos;
                        context2.pos = i25 + 1;
                        ensureBufferSize2[i25] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        int i26 = context2.pos;
                        context2.pos = i26 + 1;
                        ensureBufferSize2[i26] = (byte) ((int) (context2.lbitWorkArea & 255));
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context2.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r12, int r13, int r14, org.apaches.commons.codec.binary.BaseNCodec.Context r15) {
        /*
            r11 = this;
            boolean r0 = r15.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r14 >= 0) goto L_0x022d
            r15.eof = r1
            int r12 = r15.modulus
            if (r12 != 0) goto L_0x0014
            int r12 = r11.lineLength
            if (r12 != 0) goto L_0x0014
            return
        L_0x0014:
            int r12 = r11.encodeSize
            byte[] r12 = r11.ensureBufferSize(r12, r15)
            int r13 = r15.pos
            int r14 = r15.modulus
            r2 = 4
            r3 = 2
            r4 = 3
            r5 = 61
            switch(r14) {
                case 0: goto L_0x020a;
                case 1: goto L_0x01b5;
                case 2: goto L_0x0148;
                case 3: goto L_0x00ce;
                case 4: goto L_0x003c;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Impossible modulus "
            r13.<init>(r14)
            int r14 = r15.modulus
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x003c:
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r2 = 27
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r2 = 22
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r2 = 17
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r2 = 12
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r2 = 7
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            long r2 = r6 >> r3
            int r2 = (int) r2
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r2 = r15.lbitWorkArea
            long r2 = r2 << r4
            int r2 = (int) r2
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            goto L_0x020a
        L_0x00ce:
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r4 = 19
            long r6 = r6 >> r4
            int r4 = (int) r6
            r4 = r4 & 31
            byte r3 = r3[r4]
            r12[r14] = r3
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r4 = 14
            long r6 = r6 >> r4
            int r4 = (int) r6
            r4 = r4 & 31
            byte r3 = r3[r4]
            r12[r14] = r3
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r4 = 9
            long r6 = r6 >> r4
            int r4 = (int) r6
            r4 = r4 & 31
            byte r3 = r3[r4]
            r12[r14] = r3
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            long r6 = r6 >> r2
            int r2 = (int) r6
            r2 = r2 & 31
            byte r2 = r3[r2]
            r12[r14] = r2
            int r14 = r15.pos
            int r2 = r14 + 1
            r15.pos = r2
            byte[] r2 = r11.encodeTable
            long r3 = r15.lbitWorkArea
            long r3 = r3 << r1
            int r1 = (int) r3
            r1 = r1 & 31
            byte r1 = r2[r1]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            goto L_0x020a
        L_0x0148:
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r4 = 11
            long r6 = r6 >> r4
            int r4 = (int) r6
            r4 = r4 & 31
            byte r3 = r3[r4]
            r12[r14] = r3
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            r4 = 6
            long r6 = r6 >> r4
            int r4 = (int) r6
            r4 = r4 & 31
            byte r3 = r3[r4]
            r12[r14] = r3
            int r14 = r15.pos
            int r3 = r14 + 1
            r15.pos = r3
            byte[] r3 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            long r6 = r6 >> r1
            int r1 = (int) r6
            r1 = r1 & 31
            byte r1 = r3[r1]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r3 = r15.lbitWorkArea
            long r2 = r3 << r2
            int r2 = (int) r2
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            goto L_0x020a
        L_0x01b5:
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            long r6 = r6 >> r4
            int r2 = (int) r6
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            byte[] r1 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            long r2 = r6 << r3
            int r2 = (int) r2
            r2 = r2 & 31
            byte r1 = r1[r2]
            r12[r14] = r1
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
            int r14 = r15.pos
            int r1 = r14 + 1
            r15.pos = r1
            r12[r14] = r5
        L_0x020a:
            int r14 = r15.currentLinePos
            int r1 = r15.pos
            int r1 = r1 - r13
            int r14 = r14 + r1
            r15.currentLinePos = r14
            int r13 = r11.lineLength
            if (r13 <= 0) goto L_0x0231
            int r13 = r15.currentLinePos
            if (r13 <= 0) goto L_0x0231
            byte[] r13 = r11.lineSeparator
            int r14 = r15.pos
            byte[] r1 = r11.lineSeparator
            int r1 = r1.length
            java.lang.System.arraycopy(r13, r0, r12, r14, r1)
            int r12 = r15.pos
            byte[] r13 = r11.lineSeparator
            int r13 = r13.length
            int r12 = r12 + r13
            r15.pos = r12
            goto L_0x0231
        L_0x022d:
            r2 = r13
            r13 = 0
        L_0x022f:
            if (r13 < r14) goto L_0x0232
        L_0x0231:
            return
        L_0x0232:
            int r3 = r11.encodeSize
            byte[] r3 = r11.ensureBufferSize(r3, r15)
            int r4 = r15.modulus
            int r4 = r4 + r1
            r5 = 5
            int r4 = r4 % r5
            r15.modulus = r4
            int r4 = r2 + 1
            byte r2 = r12[r2]
            if (r2 >= 0) goto L_0x0247
            int r2 = r2 + 256
        L_0x0247:
            long r6 = r15.lbitWorkArea
            r8 = 8
            long r6 = r6 << r8
            long r9 = (long) r2
            long r6 = r6 + r9
            r15.lbitWorkArea = r6
            int r2 = r15.modulus
            if (r2 != 0) goto L_0x0312
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 35
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 30
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 25
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 20
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 15
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            r7 = 10
            long r9 = r9 >> r7
            int r7 = (int) r9
            r7 = r7 & 31
            byte r6 = r6[r7]
            r3[r2] = r6
            int r2 = r15.pos
            int r6 = r2 + 1
            r15.pos = r6
            byte[] r6 = r11.encodeTable
            long r9 = r15.lbitWorkArea
            long r9 = r9 >> r5
            int r5 = (int) r9
            r5 = r5 & 31
            byte r5 = r6[r5]
            r3[r2] = r5
            int r2 = r15.pos
            int r5 = r2 + 1
            r15.pos = r5
            byte[] r5 = r11.encodeTable
            long r6 = r15.lbitWorkArea
            int r6 = (int) r6
            r6 = r6 & 31
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r15.currentLinePos
            int r2 = r2 + r8
            r15.currentLinePos = r2
            int r2 = r11.lineLength
            if (r2 <= 0) goto L_0x0312
            int r2 = r11.lineLength
            int r5 = r15.currentLinePos
            if (r2 > r5) goto L_0x0312
            byte[] r2 = r11.lineSeparator
            int r5 = r15.pos
            byte[] r6 = r11.lineSeparator
            int r6 = r6.length
            java.lang.System.arraycopy(r2, r0, r3, r5, r6)
            int r2 = r15.pos
            byte[] r3 = r11.lineSeparator
            int r3 = r3.length
            int r2 = r2 + r3
            r15.pos = r2
            r15.currentLinePos = r0
        L_0x0312:
            int r13 = r13 + 1
            r2 = r4
            goto L_0x022f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apaches.commons.codec.binary.Base32.encode(byte[], int, int, org.apaches.commons.codec.binary.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b) {
        return b >= 0 && b < this.decodeTable.length && this.decodeTable[b] != -1;
    }
}
