package com.p006a.p007a.p008a;

import com.alibaba.fastjson.asm.Opcodes;
import java.io.UnsupportedEncodingException;

/* renamed from: com.a.a.a.f */
public class Latin1Converter {
    /* renamed from: a */
    public static ByteBuffer m62a(ByteBuffer bVar) {
        if (!"UTF-8".equals(bVar.mo7505c())) {
            return bVar;
        }
        byte[] bArr = new byte[8];
        ByteBuffer bVar2 = new ByteBuffer((bVar.mo7504b() * 4) / 3);
        int i = 0;
        char c = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bVar.mo7504b()) {
            int a = bVar.mo7499a(i);
            if (c == 11) {
                if (i2 <= 0 || (a & Opcodes.CHECKCAST) != 128) {
                    bVar2.mo7502a(m63a(bArr[0]));
                    i -= i3;
                } else {
                    int i4 = i3 + 1;
                    bArr[i3] = (byte) a;
                    i2--;
                    if (i2 == 0) {
                        bVar2.mo7503a(bArr, 0, i4);
                    } else {
                        i3 = i4;
                    }
                }
                c = 0;
                i3 = 0;
            } else if (a < 127) {
                bVar2.mo7501a((byte) a);
            } else if (a >= 192) {
                int i5 = -1;
                int i6 = a;
                while (i5 < 8 && (i6 & 128) == 128) {
                    i5++;
                    i6 <<= 1;
                }
                bArr[i3] = (byte) a;
                i3++;
                i2 = i5;
                c = 11;
            } else {
                bVar2.mo7502a(m63a((byte) a));
            }
            i++;
        }
        if (c == 11) {
            for (int i7 = 0; i7 < i3; i7++) {
                bVar2.mo7502a(m63a(bArr[i7]));
            }
        }
        return bVar2;
    }

    /* renamed from: a */
    private static byte[] m63a(byte b) {
        byte b2 = b & 255;
        if (b2 >= 128) {
            if (b2 == 129 || b2 == 141 || b2 == 143 || b2 == 144 || b2 == 157) {
                return new byte[]{32};
            }
            try {
                return new String(new byte[]{b}, "cp1252").getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b};
    }
}
