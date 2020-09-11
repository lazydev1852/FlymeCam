package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c != '1' && c != '2') || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 == '0') {
            if (c6 < '1' || c6 > '9') {
                return false;
            }
        } else if (c5 != '1') {
            return false;
        } else {
            if (!(c6 == '0' || c6 == '1' || c6 == '2')) {
                return false;
            }
        }
        if (i == 48) {
            return i2 >= 49 && i2 <= 57;
        }
        if (i == 49 || i == 50) {
            return i2 >= 48 && i2 <= 57;
        }
        if (i == 51) {
            return i2 == 48 || i2 == 49;
        }
        return false;
    }

    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c == '1') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '2' || c2 < '0' || c2 > '4') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (!(c3 == '6' && c4 == '0')) {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = this.text.length();
        this.f133bp = -1;
        next();
        if (this.f134ch == 65279) {
            next();
        }
    }

    public final char charAt(int i) {
        if (i >= this.len) {
            return JSONLexer.EOI;
        }
        return this.text.charAt(i);
    }

    public final char next() {
        char c;
        int i = this.f133bp + 1;
        this.f133bp = i;
        if (i >= this.len) {
            c = JSONLexer.EOI;
        } else {
            c = this.text.charAt(i);
        }
        this.f134ch = c;
        return c;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    /* access modifiers changed from: protected */
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.f133bp, cArr);
    }

    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    public byte[] bytesValue() {
        return IOUtils.decodeBase64(this.text, this.f135np + 1, this.f136sp);
    }

    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.f135np + 1, this.f136sp);
        }
        return new String(this.sbuf, 0, this.f136sp);
    }

    public final String subString(int i, int i2) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i, i2 + i);
        }
        if (i2 < this.sbuf.length) {
            this.text.getChars(i, i + i2, this.sbuf, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public final char[] sub_chars(int i, int i2) {
        if (!ASMUtils.IS_ANDROID || i2 >= this.sbuf.length) {
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return cArr;
        }
        this.text.getChars(i, i2 + i, this.sbuf, 0);
        return this.sbuf;
    }

    public final String numberString() {
        char charAt = charAt((this.f135np + this.f136sp) - 1);
        int i = this.f136sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.f135np, i);
    }

    public final BigDecimal decimalValue() {
        char charAt = charAt((this.f135np + this.f136sp) - 1);
        int i = this.f136sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.f135np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanISO8601DateIfMatch(boolean r32) {
        /*
            r31 = this;
            r9 = r31
            int r0 = r9.len
            int r1 = r9.f133bp
            int r11 = r0 - r1
            r12 = 6
            r13 = 3
            r14 = 13
            r15 = 2
            r8 = 57
            r7 = 5
            r16 = 1
            r6 = 48
            r5 = 0
            if (r32 != 0) goto L_0x00b2
            if (r11 <= r14) goto L_0x00b2
            int r0 = r9.f133bp
            char r0 = r9.charAt(r0)
            int r1 = r9.f133bp
            int r1 = r1 + 1
            char r1 = r9.charAt(r1)
            int r2 = r9.f133bp
            int r2 = r2 + r15
            char r2 = r9.charAt(r2)
            int r3 = r9.f133bp
            int r3 = r3 + r13
            char r3 = r9.charAt(r3)
            int r4 = r9.f133bp
            int r4 = r4 + 4
            char r4 = r9.charAt(r4)
            int r14 = r9.f133bp
            int r14 = r14 + r7
            char r14 = r9.charAt(r14)
            int r13 = r9.f133bp
            int r13 = r13 + r11
            int r13 = r13 + -1
            char r13 = r9.charAt(r13)
            int r7 = r9.f133bp
            int r7 = r7 + r11
            int r7 = r7 - r15
            char r7 = r9.charAt(r7)
            r15 = 47
            if (r0 != r15) goto L_0x00b2
            r0 = 68
            if (r1 != r0) goto L_0x00b2
            r0 = 97
            if (r2 != r0) goto L_0x00b2
            r0 = 116(0x74, float:1.63E-43)
            if (r3 != r0) goto L_0x00b2
            r0 = 101(0x65, float:1.42E-43)
            if (r4 != r0) goto L_0x00b2
            r0 = 40
            if (r14 != r0) goto L_0x00b2
            r0 = 47
            if (r13 != r0) goto L_0x00b2
            r0 = 41
            if (r7 != r0) goto L_0x00b2
            r0 = -1
            r0 = 6
            r1 = -1
        L_0x0078:
            if (r0 >= r11) goto L_0x008f
            int r2 = r9.f133bp
            int r2 = r2 + r0
            char r2 = r9.charAt(r2)
            r3 = 43
            if (r2 != r3) goto L_0x0087
            r1 = r0
            goto L_0x008c
        L_0x0087:
            if (r2 < r6) goto L_0x008f
            if (r2 <= r8) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            int r0 = r0 + 1
            goto L_0x0078
        L_0x008f:
            r0 = -1
            if (r1 != r0) goto L_0x0093
            return r5
        L_0x0093:
            int r0 = r9.f133bp
            int r0 = r0 + r12
            int r1 = r1 - r0
            java.lang.String r0 = r9.subString(r0, r1)
            long r0 = java.lang.Long.parseLong(r0)
            java.util.TimeZone r2 = r9.timeZone
            java.util.Locale r3 = r9.locale
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
            r9.calendar = r2
            java.util.Calendar r2 = r9.calendar
            r2.setTimeInMillis(r0)
            r0 = 5
            r9.token = r0
            return r16
        L_0x00b2:
            r0 = 8
            r14 = 14
            if (r11 == r0) goto L_0x045b
            if (r11 == r14) goto L_0x045b
            r0 = 17
            if (r11 != r0) goto L_0x00c0
            goto L_0x045b
        L_0x00c0:
            r0 = 9
            if (r11 >= r0) goto L_0x00c5
            return r5
        L_0x00c5:
            int r0 = r9.f133bp
            char r0 = r9.charAt(r0)
            int r1 = r9.f133bp
            int r1 = r1 + 1
            char r1 = r9.charAt(r1)
            int r2 = r9.f133bp
            r3 = 2
            int r2 = r2 + r3
            char r2 = r9.charAt(r2)
            int r3 = r9.f133bp
            r4 = 3
            int r3 = r3 + r4
            char r3 = r9.charAt(r3)
            int r4 = r9.f133bp
            int r4 = r4 + 4
            char r4 = r9.charAt(r4)
            int r7 = r9.f133bp
            r15 = 5
            int r7 = r7 + r15
            char r7 = r9.charAt(r7)
            int r6 = r9.f133bp
            int r6 = r6 + r12
            char r6 = r9.charAt(r6)
            int r8 = r9.f133bp
            int r8 = r8 + 7
            char r8 = r9.charAt(r8)
            int r15 = r9.f133bp
            int r15 = r15 + 8
            char r15 = r9.charAt(r15)
            int r12 = r9.f133bp
            int r12 = r12 + 9
            char r12 = r9.charAt(r12)
            r13 = 45
            if (r4 != r13) goto L_0x0118
            if (r8 == r13) goto L_0x01a7
        L_0x0118:
            r14 = 47
            if (r4 != r14) goto L_0x0122
            r14 = 47
            if (r8 != r14) goto L_0x0122
            goto L_0x01a7
        L_0x0122:
            r14 = 46
            if (r2 != r14) goto L_0x012a
            r14 = 46
            if (r7 == r14) goto L_0x012e
        L_0x012a:
            if (r2 != r13) goto L_0x0136
            if (r7 != r13) goto L_0x0136
        L_0x012e:
            r19 = r0
            r30 = r1
            r7 = r3
            r14 = r4
            goto L_0x01ba
        L_0x0136:
            r14 = 24180(0x5e74, float:3.3883E-41)
            if (r4 == r14) goto L_0x0141
            r14 = 45380(0xb144, float:6.3591E-41)
            if (r4 != r14) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            return r5
        L_0x0141:
            r4 = 26376(0x6708, float:3.696E-41)
            if (r8 == r4) goto L_0x0182
            r4 = 50900(0xc6d4, float:7.1326E-41)
            if (r8 != r4) goto L_0x014b
            goto L_0x0182
        L_0x014b:
            r4 = 26376(0x6708, float:3.696E-41)
            if (r6 == r4) goto L_0x0156
            r4 = 50900(0xc6d4, float:7.1326E-41)
            if (r6 != r4) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            return r5
        L_0x0156:
            r4 = 26085(0x65e5, float:3.6553E-41)
            if (r15 == r4) goto L_0x0176
            r4 = 51068(0xc77c, float:7.1562E-41)
            if (r15 != r4) goto L_0x0160
            goto L_0x0176
        L_0x0160:
            r4 = 26085(0x65e5, float:3.6553E-41)
            if (r12 == r4) goto L_0x016b
            r4 = 51068(0xc77c, float:7.1562E-41)
            if (r12 != r4) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            return r5
        L_0x016b:
            r6 = r0
            r12 = r3
            r14 = r7
            r19 = r8
            r30 = r15
            r7 = 48
            r8 = r1
            goto L_0x01b9
        L_0x0176:
            r6 = r0
            r15 = r2
            r12 = r3
            r14 = r7
            r30 = r8
            r7 = 48
            r19 = 48
            r8 = r1
            goto L_0x01ba
        L_0x0182:
            r4 = 26085(0x65e5, float:3.6553E-41)
            if (r12 == r4) goto L_0x01b1
            r4 = 51068(0xc77c, float:7.1562E-41)
            if (r12 != r4) goto L_0x018c
            goto L_0x01b1
        L_0x018c:
            int r4 = r9.f133bp
            int r4 = r4 + 10
            char r4 = r9.charAt(r4)
            r8 = 26085(0x65e5, float:3.6553E-41)
            if (r4 == r8) goto L_0x01a7
            int r4 = r9.f133bp
            int r4 = r4 + 10
            char r4 = r9.charAt(r4)
            r8 = 51068(0xc77c, float:7.1562E-41)
            if (r4 != r8) goto L_0x01a6
            goto L_0x01a7
        L_0x01a6:
            return r5
        L_0x01a7:
            r8 = r1
            r14 = r6
            r30 = r12
            r19 = r15
            r6 = r0
            r15 = r2
            r12 = r3
            goto L_0x01ba
        L_0x01b1:
            r8 = r1
            r12 = r3
            r14 = r6
            r30 = r15
            r19 = 48
            r6 = r0
        L_0x01b9:
            r15 = r2
        L_0x01ba:
            r22 = r6
            r23 = r8
            r24 = r15
            r25 = r12
            r26 = r7
            r27 = r14
            r28 = r19
            r29 = r30
            boolean r0 = checkDate(r22, r23, r24, r25, r26, r27, r28, r29)
            if (r0 != 0) goto L_0x01d1
            return r5
        L_0x01d1:
            r0 = r31
            r1 = r6
            r2 = r8
            r3 = r15
            r4 = r12
            r12 = 0
            r5 = r7
            r15 = 48
            r6 = r14
            r14 = 5
            r7 = r19
            r8 = r30
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r9.f133bp
            int r0 = r0 + 10
            char r7 = r9.charAt(r0)
            r0 = 84
            if (r7 == r0) goto L_0x0295
            r0 = 32
            if (r7 != r0) goto L_0x01f8
            if (r32 != 0) goto L_0x01f8
            goto L_0x0295
        L_0x01f8:
            r0 = 34
            if (r7 == r0) goto L_0x026a
            r0 = 26
            if (r7 == r0) goto L_0x026a
            r0 = 26085(0x65e5, float:3.6553E-41)
            if (r7 == r0) goto L_0x026a
            r0 = 51068(0xc77c, float:7.1562E-41)
            if (r7 != r0) goto L_0x020a
            goto L_0x026a
        L_0x020a:
            r0 = 43
            if (r7 == r0) goto L_0x0212
            if (r7 != r13) goto L_0x0211
            goto L_0x0212
        L_0x0211:
            return r12
        L_0x0212:
            int r0 = r9.len
            r1 = 16
            if (r0 != r1) goto L_0x0269
            int r0 = r9.f133bp
            r1 = 13
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 != r1) goto L_0x0268
            int r0 = r9.f133bp
            r1 = 14
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            if (r0 != r15) goto L_0x0268
            int r0 = r9.f133bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            if (r0 == r15) goto L_0x023b
            goto L_0x0268
        L_0x023b:
            r1 = 48
            r2 = 48
            r3 = 48
            r4 = 48
            r5 = 48
            r6 = 48
            r0 = r31
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r12)
            int r0 = r9.f133bp
            r1 = 11
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.f133bp
            int r1 = r1 + 12
            char r1 = r9.charAt(r1)
            r9.setTimeZone(r7, r0, r1)
            return r16
        L_0x0268:
            return r12
        L_0x0269:
            return r12
        L_0x026a:
            java.util.Calendar r0 = r9.calendar
            r1 = 11
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r1 = 12
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r1 = 13
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r12)
            int r0 = r9.f133bp
            int r0 = r0 + 10
            r9.f133bp = r0
            char r0 = r9.charAt(r0)
            r9.f134ch = r0
            r9.token = r14
            return r16
        L_0x0295:
            r0 = 19
            if (r11 >= r0) goto L_0x029a
            return r12
        L_0x029a:
            int r0 = r9.f133bp
            r1 = 13
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 == r1) goto L_0x02a8
            return r12
        L_0x02a8:
            int r0 = r9.f133bp
            int r0 = r0 + 16
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 == r1) goto L_0x02b5
            return r12
        L_0x02b5:
            int r0 = r9.f133bp
            r1 = 11
            int r0 = r0 + r1
            char r7 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 12
            char r8 = r9.charAt(r0)
            int r0 = r9.f133bp
            r1 = 14
            int r0 = r0 + r1
            char r10 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 15
            char r17 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 17
            char r19 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 18
            char r21 = r9.charAt(r0)
            r0 = r31
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r17
            r5 = r19
            r6 = r21
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x02f9
            return r12
        L_0x02f9:
            r0 = r31
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r17
            r5 = r19
            r6 = r21
            r0.setTime(r1, r2, r3, r4, r5, r6)
            int r0 = r9.f133bp
            int r0 = r0 + 19
            char r0 = r9.charAt(r0)
            r1 = 46
            if (r0 != r1) goto L_0x0423
            r0 = 21
            if (r11 >= r0) goto L_0x0318
            return r12
        L_0x0318:
            int r0 = r9.f133bp
            int r0 = r0 + 20
            char r0 = r9.charAt(r0)
            if (r0 < r15) goto L_0x0422
            r8 = 57
            if (r0 <= r8) goto L_0x0328
            goto L_0x0422
        L_0x0328:
            int r0 = r0 - r15
            r1 = 21
            if (r11 <= r1) goto L_0x0340
            int r1 = r9.f133bp
            int r1 = r1 + 21
            char r1 = r9.charAt(r1)
            if (r1 < r15) goto L_0x0340
            if (r1 > r8) goto L_0x0340
            int r0 = r0 * 10
            int r1 = r1 - r15
            int r0 = r0 + r1
            r1 = r0
            r0 = 2
            goto L_0x0342
        L_0x0340:
            r1 = r0
            r0 = 1
        L_0x0342:
            r2 = 2
            if (r0 != r2) goto L_0x0356
            int r2 = r9.f133bp
            int r2 = r2 + 22
            char r2 = r9.charAt(r2)
            if (r2 < r15) goto L_0x0356
            if (r2 > r8) goto L_0x0356
            int r1 = r1 * 10
            int r2 = r2 - r15
            int r1 = r1 + r2
            r0 = 3
        L_0x0356:
            java.util.Calendar r2 = r9.calendar
            r3 = 14
            r2.set(r3, r1)
            int r1 = r9.f133bp
            int r1 = r1 + 20
            int r1 = r1 + r0
            char r1 = r9.charAt(r1)
            r2 = 43
            if (r1 == r2) goto L_0x0396
            if (r1 != r13) goto L_0x036d
            goto L_0x0396
        L_0x036d:
            r2 = 90
            if (r1 != r2) goto L_0x0393
            java.util.Calendar r1 = r9.calendar
            java.util.TimeZone r1 = r1.getTimeZone()
            int r1 = r1.getRawOffset()
            if (r1 == 0) goto L_0x038f
            java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r12)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x038f
            r1 = r1[r12]
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r2 = r9.calendar
            r2.setTimeZone(r1)
        L_0x038f:
            r18 = 1
            goto L_0x03fe
        L_0x0393:
            r18 = 0
            goto L_0x03fe
        L_0x0396:
            int r2 = r9.f133bp
            int r2 = r2 + 20
            int r2 = r2 + r0
            int r2 = r2 + 1
            char r2 = r9.charAt(r2)
            if (r2 < r15) goto L_0x0421
            r3 = 49
            if (r2 <= r3) goto L_0x03a9
            goto L_0x0421
        L_0x03a9:
            int r3 = r9.f133bp
            int r3 = r3 + 20
            int r3 = r3 + r0
            r4 = 2
            int r3 = r3 + r4
            char r3 = r9.charAt(r3)
            if (r3 < r15) goto L_0x0420
            if (r3 <= r8) goto L_0x03b9
            goto L_0x0420
        L_0x03b9:
            int r4 = r9.f133bp
            int r4 = r4 + 20
            int r4 = r4 + r0
            r5 = 3
            int r4 = r4 + r5
            char r4 = r9.charAt(r4)
            r5 = 58
            if (r4 != r5) goto L_0x03e6
            int r4 = r9.f133bp
            int r4 = r4 + 20
            int r4 = r4 + r0
            int r4 = r4 + 4
            char r4 = r9.charAt(r4)
            if (r4 == r15) goto L_0x03d6
            return r12
        L_0x03d6:
            int r4 = r9.f133bp
            int r4 = r4 + 20
            int r4 = r4 + r0
            int r4 = r4 + r14
            char r4 = r9.charAt(r4)
            if (r4 == r15) goto L_0x03e3
            return r12
        L_0x03e3:
            r18 = 6
            goto L_0x03fb
        L_0x03e6:
            if (r4 != r15) goto L_0x03f9
            int r4 = r9.f133bp
            int r4 = r4 + 20
            int r4 = r4 + r0
            int r4 = r4 + 4
            char r4 = r9.charAt(r4)
            if (r4 == r15) goto L_0x03f6
            return r12
        L_0x03f6:
            r18 = 5
            goto L_0x03fb
        L_0x03f9:
            r18 = 3
        L_0x03fb:
            r9.setTimeZone(r1, r2, r3)
        L_0x03fe:
            int r1 = r9.f133bp
            int r0 = r0 + 20
            int r0 = r0 + r18
            int r1 = r1 + r0
            char r1 = r9.charAt(r1)
            r2 = 26
            if (r1 == r2) goto L_0x0412
            r2 = 34
            if (r1 == r2) goto L_0x0412
            return r12
        L_0x0412:
            int r1 = r9.f133bp
            int r1 = r1 + r0
            r9.f133bp = r1
            char r0 = r9.charAt(r1)
            r9.f134ch = r0
            r9.token = r14
            return r16
        L_0x0420:
            return r12
        L_0x0421:
            return r12
        L_0x0422:
            return r12
        L_0x0423:
            java.util.Calendar r1 = r9.calendar
            r2 = 14
            r1.set(r2, r12)
            int r1 = r9.f133bp
            int r1 = r1 + 19
            r9.f133bp = r1
            char r1 = r9.charAt(r1)
            r9.f134ch = r1
            r9.token = r14
            r1 = 90
            if (r0 != r1) goto L_0x045a
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x045a
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs(r12)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x045a
            r0 = r0[r12]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x045a:
            return r16
        L_0x045b:
            r12 = 0
            r14 = 5
            r15 = 48
            if (r32 == 0) goto L_0x0462
            return r12
        L_0x0462:
            int r0 = r9.f133bp
            char r1 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 1
            char r2 = r9.charAt(r0)
            int r0 = r9.f133bp
            r3 = 2
            int r0 = r0 + r3
            char r3 = r9.charAt(r0)
            int r0 = r9.f133bp
            r4 = 3
            int r0 = r0 + r4
            char r4 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 4
            char r5 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + r14
            char r6 = r9.charAt(r0)
            int r0 = r9.f133bp
            r7 = 6
            int r0 = r0 + r7
            char r7 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 7
            char r10 = r9.charAt(r0)
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r10
            boolean r0 = checkDate(r22, r23, r24, r25, r26, r27, r28, r29)
            if (r0 != 0) goto L_0x04b6
            return r12
        L_0x04b6:
            r0 = r31
            r13 = 57
            r8 = r10
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 8
            if (r11 == r0) goto L_0x0557
            int r0 = r9.f133bp
            int r0 = r0 + 8
            char r7 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 9
            char r8 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 10
            char r10 = r9.charAt(r0)
            int r0 = r9.f133bp
            r1 = 11
            int r0 = r0 + r1
            char r18 = r9.charAt(r0)
            int r0 = r9.f133bp
            int r0 = r0 + 12
            char r19 = r9.charAt(r0)
            int r0 = r9.f133bp
            r1 = 13
            int r0 = r0 + r1
            char r20 = r9.charAt(r0)
            r0 = r31
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r18
            r5 = r19
            r6 = r20
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0506
            return r12
        L_0x0506:
            r0 = 17
            if (r11 != r0) goto L_0x0540
            int r0 = r9.f133bp
            r1 = 14
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.f133bp
            int r1 = r1 + 15
            char r1 = r9.charAt(r1)
            int r2 = r9.f133bp
            int r2 = r2 + 16
            char r2 = r9.charAt(r2)
            if (r0 < r15) goto L_0x053f
            if (r0 <= r13) goto L_0x0528
            goto L_0x053f
        L_0x0528:
            if (r1 < r15) goto L_0x053e
            if (r1 <= r13) goto L_0x052d
            goto L_0x053e
        L_0x052d:
            if (r2 < r15) goto L_0x053d
            if (r2 <= r13) goto L_0x0532
            goto L_0x053d
        L_0x0532:
            int r0 = r0 - r15
            int r0 = r0 * 100
            int r1 = r1 - r15
            int r1 = r1 * 10
            int r0 = r0 + r1
            int r2 = r2 - r15
            int r0 = r0 + r2
            r5 = r0
            goto L_0x0541
        L_0x053d:
            return r12
        L_0x053e:
            return r12
        L_0x053f:
            return r12
        L_0x0540:
            r5 = 0
        L_0x0541:
            int r7 = r7 - r15
            int r7 = r7 * 10
            int r8 = r8 - r15
            int r0 = r7 + r8
            int r10 = r10 - r15
            int r10 = r10 * 10
            int r18 = r18 + -48
            int r1 = r10 + r18
            int r19 = r19 + -48
            int r19 = r19 * 10
            int r20 = r20 + -48
            int r2 = r19 + r20
            goto L_0x055b
        L_0x0557:
            r0 = 0
            r1 = 0
            r2 = 0
            r5 = 0
        L_0x055b:
            java.util.Calendar r3 = r9.calendar
            r4 = 11
            r3.set(r4, r0)
            java.util.Calendar r0 = r9.calendar
            r3 = 12
            r0.set(r3, r1)
            java.util.Calendar r0 = r9.calendar
            r1 = 13
            r0.set(r1, r2)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r5)
            r9.token = r14
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    /* access modifiers changed from: protected */
    public void setTimeZone(char c, char c2, char c3) {
        int i = (((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    public boolean isEOF() {
        if (this.f133bp != this.len) {
            return this.f134ch == 26 && this.f133bp + 1 == this.len;
        }
        return true;
    }

    public int scanFieldInt(char[] cArr) {
        char c;
        boolean z;
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        int i3 = this.f133bp;
        char c2 = this.f134ch;
        if (!charArrayCompare(this.text, this.f133bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.f133bp + cArr.length;
        int i4 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '-') {
            i = i4 + 1;
            c = charAt(i4);
            z = true;
        } else {
            z = false;
            char c3 = charAt2;
            i = i4;
            c = c3;
        }
        if (c < '0' || c > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i5 = c - '0';
        while (true) {
            i2 = i + 1;
            charAt = charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i5 = (i5 * 10) + (charAt - '0');
                i = i2;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i5 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            if (charAt == ',' || charAt == '}') {
                this.f133bp = i2 - 1;
            }
            if (charAt == ',') {
                int i6 = this.f133bp + 1;
                this.f133bp = i6;
                this.f134ch = charAt(i6);
                this.matchStat = 3;
                this.token = 16;
                return z ? -i5 : i5;
            }
            if (charAt == '}') {
                int i7 = this.f133bp + 1;
                this.f133bp = i7;
                char charAt3 = charAt(i7);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i8 = this.f133bp + 1;
                    this.f133bp = i8;
                    this.f134ch = charAt(i8);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i9 = this.f133bp + 1;
                    this.f133bp = i9;
                    this.f134ch = charAt(i9);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i10 = this.f133bp + 1;
                    this.f133bp = i10;
                    this.f134ch = charAt(i10);
                } else if (charAt3 == 26) {
                    this.token = 20;
                } else {
                    this.f133bp = i3;
                    this.f134ch = c2;
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
            }
            return z ? -i5 : i5;
        }
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.f133bp;
        char c = this.f134ch;
        if (!charArrayCompare(this.text, this.f133bp, cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = this.f133bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i3 = indexOf - 1;
                    int i4 = 0;
                    while (i3 >= 0 && charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int length2 = indexOf - ((this.f133bp + cArr.length) + 1);
                subString = readString(sub_chars(this.f133bp + cArr.length + 1, length2), length2);
            }
            int i5 = indexOf + 1;
            char charAt = charAt(i5);
            if (charAt == ',' || charAt == '}') {
                this.f133bp = i5;
                this.f134ch = charAt;
                if (charAt == ',') {
                    int i6 = this.f133bp + 1;
                    this.f133bp = i6;
                    this.f134ch = charAt(i6);
                    this.matchStat = 3;
                    return subString;
                }
                int i7 = this.f133bp + 1;
                this.f133bp = i7;
                char charAt2 = charAt(i7);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i8 = this.f133bp + 1;
                    this.f133bp = i8;
                    this.f134ch = charAt(i8);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i9 = this.f133bp + 1;
                    this.f133bp = i9;
                    this.f134ch = charAt(i9);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i10 = this.f133bp + 1;
                    this.f133bp = i10;
                    this.f134ch = charAt(i10);
                } else if (charAt2 == 26) {
                    this.token = 20;
                } else {
                    this.f133bp = i;
                    this.f134ch = c;
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            }
            this.matchStat = -1;
            return stringDefaultValue();
        }
        throw new JSONException("unclosed str");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.f133bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.f133bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -2128831035;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.f133bp = i2;
                char charAt2 = charAt(this.f133bp);
                this.f134ch = charAt2;
                if (charAt2 == ',') {
                    int i3 = this.f133bp + 1;
                    this.f133bp = i3;
                    this.f134ch = charAt(i3);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    next();
                    skipWhitespace();
                    char current = getCurrent();
                    if (current == ',') {
                        this.token = 16;
                        int i4 = this.f133bp + 1;
                        this.f133bp = i4;
                        this.f134ch = charAt(i4);
                    } else if (current == ']') {
                        this.token = 15;
                        int i5 = this.f133bp + 1;
                        this.f133bp = i5;
                        this.f134ch = charAt(i5);
                    } else if (current == '}') {
                        this.token = 13;
                        int i6 = this.f133bp + 1;
                        this.f133bp = i6;
                        this.f134ch = charAt(i6);
                    } else if (current == 26) {
                        this.token = 20;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0;
            } else {
                j = (j ^ ((long) charAt)) * 16777619;
                i = i2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 0
            r1.matchStat = r3
            java.lang.String r4 = r1.text
            int r5 = r1.f133bp
            boolean r4 = charArrayCompare(r4, r5, r0)
            r5 = 0
            if (r4 != 0) goto L_0x0018
            r0 = -2
            r1.matchStat = r0
            return r5
        L_0x0018:
            java.lang.Class<java.util.HashSet> r4 = java.util.HashSet.class
            boolean r4 = r2.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x0026
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            goto L_0x003a
        L_0x0026:
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
            boolean r4 = r2.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x0034
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            goto L_0x003a
        L_0x0034:
            java.lang.Object r2 = r19.newInstance()     // Catch:{ Exception -> 0x0193 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x0193 }
        L_0x003a:
            int r4 = r1.f133bp
            int r0 = r0.length
            int r4 = r4 + r0
            int r0 = r4 + 1
            char r4 = r1.charAt(r4)
            r6 = 91
            r7 = 93
            r8 = 44
            r9 = 3
            r10 = -1
            r11 = 1
            if (r4 != r6) goto L_0x0101
            int r4 = r0 + 1
            char r0 = r1.charAt(r0)
        L_0x0055:
            r6 = 34
            if (r0 != r6) goto L_0x00a6
            int r0 = r1.indexOf(r6, r4)
            if (r0 == r10) goto L_0x009e
            int r12 = r0 - r4
            java.lang.String r12 = r1.subString(r4, r12)
            r13 = 92
            int r14 = r12.indexOf(r13)
            if (r14 == r10) goto L_0x0093
        L_0x006d:
            int r12 = r0 + -1
            r14 = 0
        L_0x0070:
            if (r12 < 0) goto L_0x007d
            char r15 = r1.charAt(r12)
            if (r15 != r13) goto L_0x007d
            int r14 = r14 + 1
            int r12 = r12 + -1
            goto L_0x0070
        L_0x007d:
            int r14 = r14 % 2
            if (r14 != 0) goto L_0x008c
            int r6 = r0 - r4
            char[] r4 = r1.sub_chars(r4, r6)
            java.lang.String r12 = readString(r4, r6)
            goto L_0x0093
        L_0x008c:
            int r0 = r0 + 1
            int r0 = r1.indexOf(r6, r0)
            goto L_0x006d
        L_0x0093:
            int r0 = r0 + r11
            int r4 = r0 + 1
            char r0 = r1.charAt(r0)
            r2.add(r12)
            goto L_0x00c4
        L_0x009e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "unclosed str"
            r0.<init>(r2)
            throw r0
        L_0x00a6:
            r6 = 110(0x6e, float:1.54E-43)
            if (r0 != r6) goto L_0x00ef
            java.lang.String r6 = r1.text
            java.lang.String r12 = "ull"
            boolean r6 = r6.startsWith(r12, r4)
            if (r6 == 0) goto L_0x00ef
            int r4 = r4 + 3
            int r0 = r4 + 1
            char r4 = r1.charAt(r4)
            r2.add(r5)
            r16 = r4
            r4 = r0
            r0 = r16
        L_0x00c4:
            if (r0 != r8) goto L_0x00d2
            int r0 = r4 + 1
            char r4 = r1.charAt(r4)
            r16 = r4
            r4 = r0
            r0 = r16
            goto L_0x0055
        L_0x00d2:
            if (r0 != r7) goto L_0x00ec
            int r0 = r4 + 1
            char r4 = r1.charAt(r4)
        L_0x00da:
            boolean r6 = isWhitespace(r4)
            if (r6 == 0) goto L_0x0114
            int r4 = r0 + 1
            char r0 = r1.charAt(r0)
            r16 = r4
            r4 = r0
            r0 = r16
            goto L_0x00da
        L_0x00ec:
            r1.matchStat = r10
            return r5
        L_0x00ef:
            if (r0 != r7) goto L_0x00fe
            int r0 = r2.size()
            if (r0 != 0) goto L_0x00fe
            int r0 = r4 + 1
            char r4 = r1.charAt(r4)
            goto L_0x0114
        L_0x00fe:
            r1.matchStat = r10
            return r5
        L_0x0101:
            java.lang.String r2 = r1.text
            java.lang.String r4 = "ull"
            boolean r2 = r2.startsWith(r4, r0)
            if (r2 == 0) goto L_0x0190
            int r0 = r0 + r9
            int r2 = r0 + 1
            char r4 = r1.charAt(r0)
            r0 = r2
            r2 = r5
        L_0x0114:
            r1.f133bp = r0
            if (r4 != r8) goto L_0x0123
            int r0 = r1.f133bp
            char r0 = r1.charAt(r0)
            r1.f134ch = r0
            r1.matchStat = r9
            return r2
        L_0x0123:
            r6 = 125(0x7d, float:1.75E-43)
            if (r4 != r6) goto L_0x018d
            int r4 = r1.f133bp
            char r4 = r1.charAt(r4)
        L_0x012d:
            if (r4 != r8) goto L_0x013f
            r0 = 16
            r1.token = r0
            int r0 = r1.f133bp
            int r0 = r0 + r11
            r1.f133bp = r0
            char r0 = r1.charAt(r0)
            r1.f134ch = r0
            goto L_0x016d
        L_0x013f:
            if (r4 != r7) goto L_0x0151
            r0 = 15
            r1.token = r0
            int r0 = r1.f133bp
            int r0 = r0 + r11
            r1.f133bp = r0
            char r0 = r1.charAt(r0)
            r1.f134ch = r0
            goto L_0x016d
        L_0x0151:
            if (r4 != r6) goto L_0x0163
            r0 = 13
            r1.token = r0
            int r0 = r1.f133bp
            int r0 = r0 + r11
            r1.f133bp = r0
            char r0 = r1.charAt(r0)
            r1.f134ch = r0
            goto L_0x016d
        L_0x0163:
            r9 = 26
            if (r4 != r9) goto L_0x0171
            r0 = 20
            r1.token = r0
            r1.f134ch = r4
        L_0x016d:
            r0 = 4
            r1.matchStat = r0
            return r2
        L_0x0171:
            r9 = 0
        L_0x0172:
            boolean r12 = isWhitespace(r4)
            if (r12 == 0) goto L_0x0187
            int r4 = r0 + 1
            char r0 = r1.charAt(r0)
            r1.f133bp = r4
            r9 = 1
            r16 = r4
            r4 = r0
            r0 = r16
            goto L_0x0172
        L_0x0187:
            if (r9 == 0) goto L_0x018a
            goto L_0x012d
        L_0x018a:
            r1.matchStat = r10
            return r5
        L_0x018d:
            r1.matchStat = r10
            return r5
        L_0x0190:
            r1.matchStat = r10
            return r5
        L_0x0193:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldLong(char[] cArr) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.f133bp;
        char c = this.f134ch;
        if (!charArrayCompare(this.text, this.f133bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.f133bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '-') {
            charAt2 = charAt(i3);
            i3++;
            z = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.f133bp = i2;
            this.f134ch = c;
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i3 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == ',' || charAt == '}') {
            this.f133bp = i - 1;
        }
        if (j < 0) {
            this.f133bp = i2;
            this.f134ch = c;
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.f133bp + 1;
            this.f133bp = i4;
            this.f134ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i5 = this.f133bp + 1;
            this.f133bp = i5;
            char charAt3 = charAt(i5);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.f133bp + 1;
                this.f133bp = i6;
                this.f134ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.f133bp + 1;
                this.f133bp = i7;
                this.f134ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.f133bp + 1;
                this.f133bp = i8;
                this.f134ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
            } else {
                this.f133bp = i2;
                this.f134ch = c;
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -j : j;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public boolean scanFieldBoolean(char[] cArr) {
        char c;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.f133bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.f133bp + cArr.length;
        int i = length + 1;
        char charAt = charAt(length);
        if (charAt == 't') {
            int i2 = i + 1;
            if (charAt(i) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i3 = i2 + 1;
            if (charAt(i2) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(i3) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.f133bp = i4;
            c = charAt(this.f133bp);
            z = true;
        } else if (charAt == 'f') {
            int i5 = i + 1;
            if (charAt(i) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.f133bp = i8;
            c = charAt(this.f133bp);
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        if (c == ',') {
            int i9 = this.f133bp + 1;
            this.f133bp = i9;
            this.f134ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
        } else if (c == '}') {
            int i10 = this.f133bp + 1;
            this.f133bp = i10;
            char charAt2 = charAt(i10);
            if (charAt2 == ',') {
                this.token = 16;
                int i11 = this.f133bp + 1;
                this.f133bp = i11;
                this.f134ch = charAt(i11);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i12 = this.f133bp + 1;
                this.f133bp = i12;
                this.f134ch = charAt(i12);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i13 = this.f133bp + 1;
                this.f133bp = i13;
                this.f134ch = charAt(i13);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
        } else {
            this.matchStat = -1;
            return false;
        }
        return z;
    }

    public final int scanInt(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.f133bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z = charAt2 == '-';
        if (z) {
            char charAt3 = charAt(i3);
            i3++;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                i4 = (i4 * 10) + (charAt - '0');
                i3 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return z ? -i4 : i4;
                }
            }
            this.f133bp = i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i4 : i4;
        }
    }

    public long scanLong(char c) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.f133bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        if (charAt2 == '-') {
            z = true;
        }
        if (z) {
            char charAt3 = charAt(i3);
            i3++;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i3 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (j < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.f133bp = i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        }
    }

    /* access modifiers changed from: protected */
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    public String info() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.f133bp);
        sb.append(", json : ");
        if (this.text.length() < 65536) {
            str = this.text;
        } else {
            str = this.text.substring(0, 65536);
        }
        sb.append(str);
        return sb.toString();
    }
}
