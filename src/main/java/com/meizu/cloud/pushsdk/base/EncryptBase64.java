package com.meizu.cloud.pushsdk.base;

import com.meizu.savior.Constants;
import java.nio.charset.Charset;

public class EncryptBase64 {
    private static final char[] base64_table = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Constants.OBJECT_TYPE, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final char last2byte = ((char) Integer.parseInt("00000011", 2));
    private static final char last4byte = ((char) Integer.parseInt("00001111", 2));
    private static final char last6byte = ((char) Integer.parseInt("00111111", 2));
    private char[] mBase64Table;
    private int offset = 0;
    private String private_key;

    public EncryptBase64(String str) {
        this.private_key = str;
        initPrivateTable();
    }

    public String encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        int length = bArr.length;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            char c = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.mBase64Table[c >>> 2]);
                sb.append(this.mBase64Table[(c & last2byte) << 4]);
                sb.append("==");
                break;
            }
            int i3 = i2 + 1;
            char c2 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(this.mBase64Table[c >>> 2]);
                sb.append(this.mBase64Table[((c & last2byte) << 4) | (c2 >>> 4)]);
                sb.append(this.mBase64Table[(last4byte & c2) << 2]);
                sb.append("=");
                break;
            }
            int i4 = i3 + 1;
            char c3 = bArr[i3] & 255;
            sb.append(this.mBase64Table[c >>> 2]);
            sb.append(this.mBase64Table[((c & last2byte) << 4) | (c2 >>> 4)]);
            sb.append(this.mBase64Table[((c2 & last4byte) << 2) | (c3 >>> 6)]);
            sb.append(this.mBase64Table[last6byte & c3]);
            i = i4;
        }
        return sb.toString();
    }

    public byte[] decode(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder((i * 3) / 4);
        int[] iArr = new int[4];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < 4) {
                int i5 = i3 + 1;
                iArr[i4] = base64_to_256(bArr[i3]);
                int i6 = iArr[i4];
                i4++;
                i3 = i5;
            }
            sb.append((char) ((iArr[0] << 2) | (iArr[1] >>> 4)));
            if (iArr[2] != 64) {
                sb.append((char) (((iArr[1] & last4byte) << 4) | (iArr[2] >>> 2)));
            }
            if (iArr[3] != 64) {
                sb.append((char) (iArr[3] | ((iArr[2] & last2byte) << 6)));
            }
            i2 = i3;
        }
        return sb.toString().getBytes(Charset.forName("ISO8859-1"));
    }

    private void initPrivateTable() {
        char[] cArr = new char[base64_table.length];
        this.offset = this.private_key.charAt(0) % 13;
        for (int i = 0; i < base64_table.length; i++) {
            cArr[i] = base64_table[(this.offset + i) % base64_table.length];
        }
        this.mBase64Table = cArr;
    }

    private int base64_to_256(byte b) {
        if (b >= 65 && b <= 90) {
            return ((b - 65) + (base64_table.length - this.offset)) % base64_table.length;
        }
        if (b >= 97 && b <= 122) {
            return (((b - 97) + 26) + (base64_table.length - this.offset)) % base64_table.length;
        }
        if (b >= 48 && b <= 57) {
            return (((b - 48) + 52) + (base64_table.length - this.offset)) % base64_table.length;
        }
        if (b == 43) {
            return ((base64_table.length - this.offset) + 62) % base64_table.length;
        }
        if (b == 47) {
            return ((base64_table.length - this.offset) + 63) % base64_table.length;
        }
        return 64;
    }
}
