package com.meizu.media.camera.portrait;

import com.meizu.savior.ChangeQuickRedirect;

public class ArrayCopy {
    public static ChangeQuickRedirect changeQuickRedirect;

    public static void arrayCopyByteToChar(byte[] bArr, int i, char[] cArr, int i2, int i3) {
        for (int i4 = i; i4 < i + i3; i4++) {
            cArr[i2 + i4] = (char) bArr[i + i4];
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v0, types: [int[]] */
    /* JADX WARNING: type inference failed for: r2v1, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void arrayCopyByteToInt(byte[] r3, int r4, int[] r5, int r6, int r7) {
        /*
            r0 = r4
        L_0x0001:
            int r1 = r4 + r7
            if (r0 >= r1) goto L_0x0010
            int r1 = r6 + r0
            int r2 = r4 + r0
            byte r2 = r3[r2]
            r5[r1] = r2
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.portrait.ArrayCopy.arrayCopyByteToInt(byte[], int, int[], int, int):void");
    }

    public static void arrayCopyCharToByte(char[] cArr, int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i; i4 < i + i3; i4++) {
            bArr[i2 + i4] = (byte) cArr[i + i4];
        }
    }
}
