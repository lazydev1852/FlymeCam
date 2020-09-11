package org.p113a.p114a.p115a.p116a;

import java.nio.charset.Charset;
import org.p113a.p114a.p115a.C3570a;

/* renamed from: org.a.a.a.a.a */
public class C3571a {

    /* renamed from: a */
    public static final Charset f19012a = C3570a.f19011f;

    /* renamed from: b */
    private static final char[] f19013b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static final char[] f19014c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d */
    private final Charset f19015d;

    /* renamed from: a */
    public static char[] m21771a(byte[] bArr) {
        return m21772a(bArr, true);
    }

    /* renamed from: a */
    public static char[] m21772a(byte[] bArr, boolean z) {
        return m21773a(bArr, z ? f19013b : f19014c);
    }

    /* renamed from: a */
    protected static char[] m21773a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    /* renamed from: b */
    public static String m21774b(byte[] bArr) {
        return new String(m21771a(bArr));
    }

    public String toString() {
        return String.valueOf(super.toString()) + "[charsetName=" + this.f19015d + "]";
    }
}
