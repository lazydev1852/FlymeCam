package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.loc.C1108h;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.meizu.savior.Constants;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import java.util.List;

public final class Decoder {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table;
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, UxipConstants.EVENT_UPLOAD_MIN_VERSION, "5", "6", "7", "8", "9", SystemInfoUtil.COMMA, ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", "e", C1108h.f3354h, C1108h.f3351e, C1108h.f3352f, "i", C1108h.f3355i, "k", NotifyType.LIGHTS, "m", "n", "o", "p", "q", "r", NotifyType.SOUND, "t", "u", NotifyType.VIBRATE, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", SystemInfoUtil.LINE_END, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", SystemInfoUtil.COMMA, "-", ".", "/", SystemInfoUtil.COLON, Constants.PACKNAME_END, "<", "=", ">", "?", Constants.ARRAY_TYPE, "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|10|11|12|13|(2:14|15)|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.zxing.aztec.decoder.Decoder$Table[] r0 = com.google.zxing.aztec.decoder.Decoder.Table.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.BINARY     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.LOWER     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.MIXED     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.PUNCT     // Catch:{ NoSuchFieldError -> 0x0039 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
        L_0x0039:
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER     // Catch:{ NoSuchFieldError -> 0x0042 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
        L_0x0042:
            $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.$SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table():int[]");
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        return new DecoderResult((byte[]) null, getEncodedData(correctBits(extractBits(aztecDetectorResult.getBits()))), (List<byte[]>) null, (String) null);
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table3 = table;
        int i = 0;
        while (i < length) {
            if (table2 != Table.BINARY) {
                int i2 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int readCode = readCode(zArr, i, i2);
                i += i2;
                String character = getCharacter(table2, readCode);
                if (character.startsWith("CTRL_")) {
                    Table table4 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table2 = table4;
                        table3 = table2;
                    } else {
                        table2 = table4;
                    }
                } else {
                    sb.append(character);
                }
            } else if (length - i < 5) {
                break;
            } else {
                int readCode2 = readCode(zArr, i, 5);
                int i3 = i + 5;
                if (readCode2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    readCode2 = readCode(zArr, i3, 11) + 31;
                    i3 += 11;
                }
                int i4 = readCode2;
                int i5 = i3;
                int i6 = 0;
                while (true) {
                    if (i6 >= i4) {
                        i = i5;
                        break;
                    } else if (length - i5 < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) readCode(zArr, i5, 8));
                        i5 += 8;
                        i6++;
                    }
                }
            }
            table2 = table3;
        }
        return sb.toString();
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        switch (c) {
            case 'L':
                return Table.LOWER;
            case 'M':
                return Table.MIXED;
            default:
                return Table.UPPER;
        }
    }

    private static String getCharacter(Table table, int i) {
        switch ($SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table()[table.ordinal()]) {
            case 1:
                return UPPER_TABLE[i];
            case 2:
                return LOWER_TABLE[i];
            case 3:
                return MIXED_TABLE[i];
            case 4:
                return DIGIT_TABLE[i];
            case 5:
                return PUNCT_TABLE[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length >= nbDatablocks) {
            int i2 = length - nbDatablocks;
            int[] iArr = new int[length];
            int length2 = zArr.length % i;
            int i3 = 0;
            while (i3 < length) {
                iArr[i3] = readCode(zArr, length2, i);
                i3++;
                length2 += i;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, i2);
                int i4 = (1 << i) - 1;
                int i5 = 0;
                for (int i6 = 0; i6 < nbDatablocks; i6++) {
                    int i7 = iArr[i6];
                    if (i7 == 0 || i7 == i4) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i7 == 1 || i7 == i4 - 1) {
                        i5++;
                    }
                }
                boolean[] zArr2 = new boolean[((nbDatablocks * i) - i5)];
                int i8 = 0;
                for (int i9 = 0; i9 < nbDatablocks; i9++) {
                    int i10 = iArr[i9];
                    if (i10 == 1 || i10 == i4 - 1) {
                        Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                        i8 += i - 1;
                    } else {
                        int i11 = i - 1;
                        while (i11 >= 0) {
                            int i12 = i8 + 1;
                            zArr2[i8] = ((1 << i11) & i10) != 0;
                            i11--;
                            i8 = i12;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean[] extractBits(BitMatrix bitMatrix) {
        BitMatrix bitMatrix2 = bitMatrix;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i = isCompact ? (nbLayers * 4) + 11 : (nbLayers * 4) + 14;
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i2 = 2;
        if (isCompact) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            int i6 = 0;
            while (i6 < i4) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
                i6++;
                i2 = 2;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < nbLayers; i9++) {
            int i10 = isCompact ? ((nbLayers - i9) * 4) + 9 : ((nbLayers - i9) * 4) + 12;
            int i11 = i9 * 2;
            int i12 = (i - 1) - i11;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i8 + i14 + i15] = bitMatrix2.get(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i8 + i14 + i15] = bitMatrix2.get(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i8 + i14 + i15] = bitMatrix2.get(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i8 + i14 + i15] = bitMatrix2.get(iArr[i19], iArr[i16]);
                    i15++;
                    i2 = 2;
                }
            }
            i8 += i10 * 8;
        }
        return zArr;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }
}
