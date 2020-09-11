package com.p006a.p007a.p008a;

/* renamed from: com.a.a.a.k */
public class Utils {

    /* renamed from: a */
    private static boolean[] f60a;

    /* renamed from: b */
    private static boolean[] f61b;

    /* renamed from: a */
    static boolean m105a(char c) {
        return ((c > 31 && c != 127) || c == 9 || c == 10 || c == 13) ? false : true;
    }

    static {
        m104a();
    }

    /* renamed from: a */
    public static String m102a(String str) {
        if ("x-default".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '-' || charAt == '_') {
                    stringBuffer.append('-');
                    i++;
                } else if (i != 2) {
                    stringBuffer.append(Character.toLowerCase(str.charAt(i2)));
                } else {
                    stringBuffer.append(Character.toUpperCase(str.charAt(i2)));
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    static String[] m107b(String str) {
        int indexOf = str.indexOf(61);
        String substring = str.substring(str.charAt(1) == '?' ? 2 : 1, indexOf);
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = i + 1;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - indexOf);
        while (i2 < length) {
            stringBuffer.append(str.charAt(i2));
            i2++;
            if (str.charAt(i2) == charAt) {
                i2++;
            }
        }
        return new String[]{substring, stringBuffer.toString()};
    }

    /* renamed from: c */
    static boolean m109c(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                i2++;
                z = z && (i == 8 || i == 13 || i == 18 || i == 23);
            }
            i++;
        }
        if (z && 4 == i2 && 36 == i) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m110d(String str) {
        if (str.length() > 0 && !m106b(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!m108c(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m111e(String str) {
        if (str.length() > 0 && (!m106b(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!m108c(str.charAt(i)) || str.charAt(i) == ':') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m103a(String str, boolean z, boolean z2) {
        boolean z3;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z3 = false;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '<' || charAt == '>' || charAt == '&' || ((z2 && (charAt == 9 || charAt == 10 || charAt == 13)) || (z && charAt == '\"'))) {
                z3 = true;
            } else {
                i++;
            }
        }
        z3 = true;
        if (!z3) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer((str.length() * 4) / 3);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt2 = str.charAt(i2);
            if (z2 && (charAt2 == 9 || charAt2 == 10 || charAt2 == 13)) {
                stringBuffer.append("&#x");
                stringBuffer.append(Integer.toHexString(charAt2).toUpperCase());
                stringBuffer.append(';');
            } else if (charAt2 == '\"') {
                stringBuffer.append(z ? "&quot;" : "\"");
            } else if (charAt2 == '&') {
                stringBuffer.append("&amp;");
            } else if (charAt2 == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt2 != '>') {
                stringBuffer.append(charAt2);
            } else {
                stringBuffer.append("&gt;");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: f */
    static String m112f(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (m105a(stringBuffer.charAt(i))) {
                stringBuffer.setCharAt(i, ' ');
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static boolean m106b(char c) {
        return c > 255 || f60a[c];
    }

    /* renamed from: c */
    private static boolean m108c(char c) {
        return c > 255 || f61b[c];
    }

    /* renamed from: a */
    private static void m104a() {
        f61b = new boolean[256];
        f60a = new boolean[256];
        char c = 0;
        while (c < f61b.length) {
            boolean z = true;
            f60a[c] = ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == ':' || c == '_' || ((192 <= c && c <= 214) || (216 <= c && c <= 246));
            boolean[] zArr = f61b;
            if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && !(('0' <= c && c <= '9') || c == ':' || c == '_' || c == '-' || c == '.' || c == 183 || ((192 <= c && c <= 214) || (216 <= c && c <= 246))))) {
                z = false;
            }
            zArr[c] = z;
            c = (char) (c + 1);
        }
    }
}
