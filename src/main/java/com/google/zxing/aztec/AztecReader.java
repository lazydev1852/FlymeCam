package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import java.util.Map;

public final class AztecReader implements Reader {
    public void reset() {
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062 A[LOOP:0: B:35:0x005f->B:36:0x0062, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap r7, java.util.Map<com.google.zxing.DecodeHintType, ?> r8) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r6 = this;
            com.google.zxing.aztec.detector.Detector r0 = new com.google.zxing.aztec.detector.Detector
            com.google.zxing.common.BitMatrix r7 = r7.getBlackMatrix()
            r0.<init>(r7)
            r7 = 0
            r1 = 0
            com.google.zxing.aztec.AztecDetectorResult r2 = r0.detect(r7)     // Catch:{ NotFoundException -> 0x002b, FormatException -> 0x0025 }
            com.google.zxing.ResultPoint[] r3 = r2.getPoints()     // Catch:{ NotFoundException -> 0x002b, FormatException -> 0x0025 }
            com.google.zxing.aztec.decoder.Decoder r4 = new com.google.zxing.aztec.decoder.Decoder     // Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
            r4.<init>()     // Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
            com.google.zxing.common.DecoderResult r2 = r4.decode(r2)     // Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x002f
        L_0x0021:
            r2 = move-exception
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r1
        L_0x0027:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r3 = r1
        L_0x002d:
            r4 = r3
            r3 = r1
        L_0x002f:
            if (r1 != 0) goto L_0x0052
            r5 = 1
            com.google.zxing.aztec.AztecDetectorResult r0 = r0.detect(r5)     // Catch:{ NotFoundException -> 0x004e, FormatException -> 0x004a }
            com.google.zxing.ResultPoint[] r5 = r0.getPoints()     // Catch:{ NotFoundException -> 0x004e, FormatException -> 0x004a }
            com.google.zxing.aztec.decoder.Decoder r4 = new com.google.zxing.aztec.decoder.Decoder     // Catch:{ NotFoundException -> 0x0048, FormatException -> 0x0046 }
            r4.<init>()     // Catch:{ NotFoundException -> 0x0048, FormatException -> 0x0046 }
            com.google.zxing.common.DecoderResult r0 = r4.decode(r0)     // Catch:{ NotFoundException -> 0x0048, FormatException -> 0x0046 }
            r1 = r0
            r4 = r5
            goto L_0x0052
        L_0x0046:
            r4 = r5
            goto L_0x004a
        L_0x0048:
            r4 = r5
            goto L_0x004e
        L_0x004a:
            if (r3 != 0) goto L_0x004d
            goto L_0x0052
        L_0x004d:
            throw r3
        L_0x004e:
            if (r2 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            throw r2
        L_0x0052:
            if (r8 == 0) goto L_0x006a
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r8 = r8.get(r0)
            com.google.zxing.ResultPointCallback r8 = (com.google.zxing.ResultPointCallback) r8
            if (r8 == 0) goto L_0x006a
            int r0 = r4.length
        L_0x005f:
            if (r7 < r0) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            r2 = r4[r7]
            r8.foundPossibleResultPoint(r2)
            int r7 = r7 + 1
            goto L_0x005f
        L_0x006a:
            com.google.zxing.Result r7 = new com.google.zxing.Result
            java.lang.String r8 = r1.getText()
            byte[] r0 = r1.getRawBytes()
            com.google.zxing.BarcodeFormat r2 = com.google.zxing.BarcodeFormat.AZTEC
            r7.<init>(r8, r0, r4, r2)
            java.util.List r8 = r1.getByteSegments()
            if (r8 == 0) goto L_0x0084
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r7.putMetadata(r0, r8)
        L_0x0084:
            java.lang.String r8 = r1.getECLevel()
            if (r8 == 0) goto L_0x008f
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r7.putMetadata(r0, r8)
        L_0x008f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecReader.decode(com.google.zxing.BinaryBitmap, java.util.Map):com.google.zxing.Result");
    }
}
