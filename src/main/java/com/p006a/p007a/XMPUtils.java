package com.p006a.p007a;

import com.p006a.p007a.p008a.Base64;
import com.p006a.p007a.p008a.ISO8601Converter;

/* renamed from: com.a.a.h */
public class XMPUtils {
    /* renamed from: a */
    public static String m385a(boolean z) {
        return z ? "True" : "False";
    }

    /* renamed from: a */
    public static boolean m387a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty convert-string", 5);
        }
        String lowerCase = str.toLowerCase();
        try {
            if (Integer.parseInt(lowerCase) != 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            if ("true".equals(lowerCase) || "t".equals(lowerCase) || "on".equals(lowerCase) || "yes".equals(lowerCase)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: b */
    public static int m388b(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.startsWith("0x")) {
                        return Integer.parseInt(str.substring(2), 16);
                    }
                    return Integer.parseInt(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid integer string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    /* renamed from: a */
    public static String m382a(int i) {
        return String.valueOf(i);
    }

    /* renamed from: c */
    public static long m389c(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.startsWith("0x")) {
                        return Long.parseLong(str.substring(2), 16);
                    }
                    return Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid long string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    /* renamed from: a */
    public static String m383a(long j) {
        return String.valueOf(j);
    }

    /* renamed from: d */
    public static double m390d(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Double.parseDouble(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid double string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    /* renamed from: a */
    public static String m381a(double d) {
        return String.valueOf(d);
    }

    /* renamed from: e */
    public static XMPDateTime m391e(String str) throws XMPException {
        if (str != null && str.length() != 0) {
            return ISO8601Converter.m59a(str);
        }
        throw new XMPException("Empty convert-string", 5);
    }

    /* renamed from: a */
    public static String m384a(XMPDateTime aVar) {
        return ISO8601Converter.m61a(aVar);
    }

    /* renamed from: a */
    public static String m386a(byte[] bArr) {
        return new String(Base64.m27a(bArr));
    }

    /* renamed from: f */
    public static byte[] m392f(String str) throws XMPException {
        try {
            return Base64.m29b(str.getBytes());
        } catch (Throwable th) {
            throw new XMPException("Invalid base64 string", 5, th);
        }
    }
}
