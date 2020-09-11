package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Number number;
        int i3;
        int i4;
        Number number2 = null;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (map == null) {
            number = null;
        } else {
            number = (Number) map.get(EncodeHintType.ERROR_CORRECTION);
        }
        if (map != null) {
            number2 = (Number) map.get(EncodeHintType.AZTEC_LAYERS);
        }
        Charset forName = str2 == null ? DEFAULT_CHARSET : Charset.forName(str2);
        if (number == null) {
            i3 = 33;
        } else {
            i3 = number.intValue();
        }
        if (number2 == null) {
            i4 = 0;
        } else {
            i4 = number2.intValue();
        }
        return encode(str, barcodeFormat, i, i2, forName, i3, i4);
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int max = Math.max(i, width);
            int max2 = Math.max(i2, height);
            int min = Math.min(max / width, max2 / height);
            int i3 = (max - (width * min)) / 2;
            int i4 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i5 = 0;
            while (i5 < height) {
                int i6 = i3;
                int i7 = 0;
                while (i7 < width) {
                    if (matrix.get(i7, i5)) {
                        bitMatrix.setRegion(i6, i4, min, min);
                    }
                    i7++;
                    i6 += min;
                }
                i5++;
                i4 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }
}
