package com.alibaba.fastjson.asm;

public class Type {
    public static final Type BOOLEAN_TYPE = new Type(1, (char[]) null, 1509950721, 1);
    public static final Type BYTE_TYPE = new Type(3, (char[]) null, 1107297537, 1);
    public static final Type CHAR_TYPE = new Type(2, (char[]) null, 1124075009, 1);
    public static final Type DOUBLE_TYPE = new Type(8, (char[]) null, 1141048066, 1);
    public static final Type FLOAT_TYPE = new Type(6, (char[]) null, 1174536705, 1);
    public static final Type INT_TYPE = new Type(5, (char[]) null, 1224736769, 1);
    public static final Type LONG_TYPE = new Type(7, (char[]) null, 1241579778, 1);
    public static final Type SHORT_TYPE = new Type(4, (char[]) null, 1392510721, 1);
    public static final Type VOID_TYPE = new Type(0, (char[]) null, 1443168256, 1);
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;

    private Type(int i, char[] cArr, int i2, int i3) {
        this.sort = i;
        this.buf = cArr;
        this.off = i2;
        this.len = i3;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                i4 = (charAt == 'D' || charAt == 'J') ? i4 + 2 : i4 + 1;
                i3 = i;
            }
        }
        char charAt2 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt2 == 'V') {
            i2 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    private static Type getType(char[] cArr, int i) {
        switch (cArr[i]) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            case 'F':
                return FLOAT_TYPE;
            case 'I':
                return INT_TYPE;
            case 'J':
                return LONG_TYPE;
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                int i2 = 1;
                while (true) {
                    int i3 = i + i2;
                    if (cArr[i3] == '[') {
                        i2++;
                    } else {
                        if (cArr[i3] == 'L') {
                            while (true) {
                                i2++;
                                if (cArr[i + i2] != ';') {
                                }
                            }
                        }
                        return new Type(9, cArr, i, i2 + 1);
                    }
                }
            default:
                int i4 = 1;
                while (cArr[i + i4] != ';') {
                    i4++;
                }
                return new Type(10, cArr, i + 1, i4 - 1);
        }
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    /* access modifiers changed from: package-private */
    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }
}
