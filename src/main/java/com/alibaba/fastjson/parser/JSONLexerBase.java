package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.meizu.savior.Constants;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final int[] digits = new int[103];
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();

    /* renamed from: bp */
    protected int f133bp;
    protected Calendar calendar = null;

    /* renamed from: ch */
    protected char f134ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    /* renamed from: np */
    protected int f135np;
    protected int pos;
    protected char[] sbuf;

    /* renamed from: sp */
    protected int f136sp;
    protected String stringDefaultValue = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected int token;

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8);
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    /* access modifiers changed from: protected */
    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    public abstract byte[] bytesValue();

    /* access modifiers changed from: protected */
    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    /* access modifiers changed from: protected */
    public abstract void copyTo(int i, int i2, char[] cArr);

    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char c, int i);

    public String info() {
        return "";
    }

    public abstract boolean isEOF();

    public abstract char next();

    public abstract String numberString();

    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract char[] sub_chars(int i, int i2);

    /* access modifiers changed from: protected */
    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        this.sbuf = SBUF_LOCAL.get();
        if (this.sbuf == null) {
            this.sbuf = new char[512];
        }
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public final void nextToken() {
        this.f136sp = 0;
        while (true) {
            this.pos = this.f133bp;
            if (this.f134ch == '/') {
                skipComment();
            } else if (this.f134ch == '\"') {
                scanString();
                return;
            } else if (this.f134ch == ',') {
                next();
                this.token = 16;
                return;
            } else if (this.f134ch >= '0' && this.f134ch <= '9') {
                scanNumber();
                return;
            } else if (this.f134ch == '-') {
                scanNumber();
                return;
            } else {
                switch (this.f134ch) {
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i = this.eofPos;
                                this.f133bp = i;
                                this.pos = i;
                                return;
                            }
                            throw new JSONException("EOF error");
                        } else if (this.f134ch <= 31 || this.f134ch == 127) {
                            next();
                            break;
                        } else {
                            lexError("illegal.char", String.valueOf(this.f134ch));
                            next();
                            return;
                        }
                }
            }
        }
    }

    public final void nextToken(int i) {
        this.f136sp = 0;
        while (true) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 12) {
                        if (i != 18) {
                            if (i != 20) {
                                switch (i) {
                                    case 14:
                                        if (this.f134ch == '[') {
                                            this.token = 14;
                                            next();
                                            return;
                                        } else if (this.f134ch == '{') {
                                            this.token = 12;
                                            next();
                                            return;
                                        }
                                        break;
                                    case 15:
                                        if (this.f134ch == ']') {
                                            this.token = 15;
                                            next();
                                            return;
                                        }
                                        break;
                                    case 16:
                                        if (this.f134ch == ',') {
                                            this.token = 16;
                                            next();
                                            return;
                                        } else if (this.f134ch == '}') {
                                            this.token = 13;
                                            next();
                                            return;
                                        } else if (this.f134ch == ']') {
                                            this.token = 15;
                                            next();
                                            return;
                                        } else if (this.f134ch == 26) {
                                            this.token = 20;
                                            return;
                                        }
                                        break;
                                }
                            }
                            if (this.f134ch == 26) {
                                this.token = 20;
                                return;
                            }
                        } else {
                            nextIdent();
                            return;
                        }
                    } else if (this.f134ch == '{') {
                        this.token = 12;
                        next();
                        return;
                    } else if (this.f134ch == '[') {
                        this.token = 14;
                        next();
                        return;
                    }
                } else if (this.f134ch == '\"') {
                    this.pos = this.f133bp;
                    scanString();
                    return;
                } else if (this.f134ch >= '0' && this.f134ch <= '9') {
                    this.pos = this.f133bp;
                    scanNumber();
                    return;
                } else if (this.f134ch == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (this.f134ch == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (this.f134ch >= '0' && this.f134ch <= '9') {
                this.pos = this.f133bp;
                scanNumber();
                return;
            } else if (this.f134ch == '\"') {
                this.pos = this.f133bp;
                scanString();
                return;
            } else if (this.f134ch == '[') {
                this.token = 14;
                next();
                return;
            } else if (this.f134ch == '{') {
                this.token = 12;
                next();
                return;
            }
            if (this.f134ch == ' ' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 12 || this.f134ch == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.f134ch)) {
            next();
        }
        if (this.f134ch == '_' || Character.isLetter(this.f134ch)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char c) {
        this.f136sp = 0;
        while (this.f134ch != c) {
            if (this.f134ch == ' ' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 12 || this.f134ch == 8) {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.f134ch);
            }
        }
        next();
        nextToken();
    }

    public final int token() {
        return this.token;
    }

    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public final int pos() {
        return this.pos;
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.f135np == -1) {
            this.f135np = 0;
        }
        int i = this.f135np;
        int i2 = this.f135np + this.f136sp;
        char c = ' ';
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = Constants.OBJECT_TYPE;
        } else if (charAt == 'S') {
            i2--;
            c = 'S';
        }
        if (charAt(this.f135np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = MULTMIN_RADIX_TEN;
        if (i < i2) {
            j2 = (long) (-(charAt(i) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = (long) charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = MULTMIN_RADIX_TEN;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i <= this.f135np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = numberString.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + numberString);
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    public void config(Feature feature, boolean z) {
        this.features = Feature.config(this.features, feature, z);
        if ((this.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    public final char getCurrent() {
        return this.f134ch;
    }

    /* access modifiers changed from: protected */
    public void skipComment() {
        next();
        if (this.f134ch == '/') {
            do {
                next();
            } while (this.f134ch != 10);
            next();
        } else if (this.f134ch == '*') {
            next();
            while (this.f134ch != 26) {
                if (this.f134ch == '*') {
                    next();
                    if (this.f134ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        if (this.f134ch == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (this.f134ch == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (this.f134ch == '}') {
            next();
            this.token = 13;
            return null;
        } else if (this.f134ch == ',') {
            next();
            this.token = 16;
            return null;
        } else if (this.f134ch == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String str;
        int i;
        this.f135np = this.f133bp;
        this.f136sp = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    if (this.f135np == -1) {
                        i = 0;
                    } else {
                        i = this.f135np + 1;
                    }
                    str = addSymbol(i, this.f136sp, i2, symbolTable);
                } else {
                    str = symbolTable.addSymbol(this.sbuf, 0, this.f136sp, i2);
                }
                this.f136sp = 0;
                next();
                return str;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else if (next == '\\') {
                if (!z) {
                    if (this.f136sp >= this.sbuf.length) {
                        int length = this.sbuf.length * 2;
                        if (this.f136sp > length) {
                            length = this.f136sp;
                        }
                        char[] cArr = new char[length];
                        System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                        this.sbuf = cArr;
                    }
                    arrayCopy(this.f135np + 1, this.sbuf, 0, this.f136sp);
                    z = true;
                }
                char next2 = next();
                switch (next2) {
                    case '/':
                        i2 = (i2 * 31) + 47;
                        putChar('/');
                        break;
                    case '0':
                        i2 = (i2 * 31) + next2;
                        putChar(0);
                        break;
                    case '1':
                        i2 = (i2 * 31) + next2;
                        putChar(1);
                        break;
                    case '2':
                        i2 = (i2 * 31) + next2;
                        putChar(2);
                        break;
                    case '3':
                        i2 = (i2 * 31) + next2;
                        putChar(3);
                        break;
                    case '4':
                        i2 = (i2 * 31) + next2;
                        putChar(4);
                        break;
                    case '5':
                        i2 = (i2 * 31) + next2;
                        putChar(5);
                        break;
                    case '6':
                        i2 = (i2 * 31) + next2;
                        putChar(6);
                        break;
                    case '7':
                        i2 = (i2 * 31) + next2;
                        putChar(7);
                        break;
                    default:
                        switch (next2) {
                            case 't':
                                i2 = (i2 * 31) + 9;
                                putChar(9);
                                break;
                            case 'u':
                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                i2 = (i2 * 31) + parseInt;
                                putChar((char) parseInt);
                                break;
                            case 'v':
                                i2 = (i2 * 31) + 11;
                                putChar(11);
                                break;
                            default:
                                switch (next2) {
                                    case '\"':
                                        i2 = (i2 * 31) + 34;
                                        putChar('\"');
                                        break;
                                    case '\'':
                                        i2 = (i2 * 31) + 39;
                                        putChar('\'');
                                        break;
                                    case 'F':
                                    case 'f':
                                        i2 = (i2 * 31) + 12;
                                        putChar(12);
                                        break;
                                    case '\\':
                                        i2 = (i2 * 31) + 92;
                                        putChar('\\');
                                        break;
                                    case 'b':
                                        i2 = (i2 * 31) + 8;
                                        putChar(8);
                                        break;
                                    case 'n':
                                        i2 = (i2 * 31) + 10;
                                        putChar(10);
                                        break;
                                    case 'r':
                                        i2 = (i2 * 31) + 13;
                                        putChar(13);
                                        break;
                                    case 'x':
                                        char next3 = next();
                                        this.f134ch = next3;
                                        char next4 = next();
                                        this.f134ch = next4;
                                        char c2 = (char) ((digits[next3] * 16) + digits[next4]);
                                        i2 = (i2 * 31) + c2;
                                        putChar(c2);
                                        break;
                                    default:
                                        this.f134ch = next2;
                                        throw new JSONException("unclosed.str.lit");
                                }
                        }
                }
            } else {
                i2 = (i2 * 31) + next;
                if (!z) {
                    this.f136sp++;
                } else if (this.f136sp == this.sbuf.length) {
                    putChar(next);
                } else {
                    char[] cArr2 = this.sbuf;
                    int i3 = this.f136sp;
                    this.f136sp = i3 + 1;
                    cArr2[i3] = next;
                }
            }
        }
    }

    public final void resetStringPosition() {
        this.f136sp = 0;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.f134ch;
        if (this.f134ch >= zArr.length || zArr[i]) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.f135np = this.f133bp;
            this.f136sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.f136sp++;
            }
            this.f134ch = charAt(this.f133bp);
            this.token = 18;
            if (this.f136sp == 4 && i == 3392903 && charAt(this.f135np) == 'n' && charAt(this.f135np + 1) == 'u' && charAt(this.f135np + 2) == 'l' && charAt(this.f135np + 3) == 'l') {
                return null;
            }
            return addSymbol(this.f135np, this.f136sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.f134ch + info());
    }

    public final void scanString() {
        this.f135np = this.f133bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.f134ch = next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed string : " + next);
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    if (this.f136sp >= this.sbuf.length) {
                        int length = this.sbuf.length * 2;
                        if (this.f136sp > length) {
                            length = this.f136sp;
                        }
                        char[] cArr = new char[length];
                        System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                        this.sbuf = cArr;
                    }
                    copyTo(this.f135np + 1, this.f136sp, this.sbuf);
                }
                char next2 = next();
                switch (next2) {
                    case '/':
                        putChar('/');
                        break;
                    case '0':
                        putChar(0);
                        break;
                    case '1':
                        putChar(1);
                        break;
                    case '2':
                        putChar(2);
                        break;
                    case '3':
                        putChar(3);
                        break;
                    case '4':
                        putChar(4);
                        break;
                    case '5':
                        putChar(5);
                        break;
                    case '6':
                        putChar(6);
                        break;
                    case '7':
                        putChar(7);
                        break;
                    default:
                        switch (next2) {
                            case 't':
                                putChar(9);
                                break;
                            case 'u':
                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                break;
                            case 'v':
                                putChar(11);
                                break;
                            default:
                                switch (next2) {
                                    case '\"':
                                        putChar('\"');
                                        break;
                                    case '\'':
                                        putChar('\'');
                                        break;
                                    case 'F':
                                    case 'f':
                                        putChar(12);
                                        break;
                                    case '\\':
                                        putChar('\\');
                                        break;
                                    case 'b':
                                        putChar(8);
                                        break;
                                    case 'n':
                                        putChar(10);
                                        break;
                                    case 'r':
                                        putChar(13);
                                        break;
                                    case 'x':
                                        putChar((char) ((digits[next()] * 16) + digits[next()]));
                                        break;
                                    default:
                                        this.f134ch = next2;
                                        throw new JSONException("unclosed string : " + next2);
                                }
                        }
                }
            } else if (!this.hasSpecial) {
                this.f136sp++;
            } else if (this.f136sp == this.sbuf.length) {
                putChar(next);
            } else {
                char[] cArr2 = this.sbuf;
                int i = this.f136sp;
                this.f136sp = i + 1;
                cArr2[i] = next;
            }
        }
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
    }

    public final int intValue() {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        if (this.f135np == -1) {
            this.f135np = 0;
        }
        int i4 = this.f135np;
        int i5 = this.f135np + this.f136sp;
        if (charAt(this.f135np) == '-') {
            i4++;
            z = true;
            i = Integer.MIN_VALUE;
        } else {
            z = false;
            i = -2147483647;
        }
        if (i4 < i5) {
            i3 = -(charAt(i4) - '0');
            i4++;
        }
        while (true) {
            if (i4 >= i5) {
                break;
            }
            i2 = i4 + 1;
            char charAt = charAt(i4);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i4 = i2;
            } else {
                int i6 = charAt - '0';
                if (((long) i3) >= -214748364) {
                    int i7 = i3 * 10;
                    if (i7 >= i + i6) {
                        i3 = i7 - i6;
                        i4 = i2;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        i4 = i2;
        if (!z) {
            return -i3;
        }
        if (i4 > this.f135np + 1) {
            return i3;
        }
        throw new NumberFormatException(numberString());
    }

    public void close() {
        if (this.sbuf.length <= 8192) {
            SBUF_LOCAL.set(this.sbuf);
        }
        this.sbuf = null;
    }

    public final boolean isRef() {
        if (this.f136sp == 4 && charAt(this.f135np + 1) == '$' && charAt(this.f135np + 2) == 'r' && charAt(this.f135np + 3) == 'e' && charAt(this.f135np + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        if (!charArrayCompare(typeFieldName)) {
            return -2;
        }
        int length = this.f133bp + typeFieldName.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            if (str.charAt(i) != charAt(length + i)) {
                return -1;
            }
        }
        int i2 = length + length2;
        if (charAt(i2) != '\"') {
            return -1;
        }
        int i3 = i2 + 1;
        this.f134ch = charAt(i3);
        if (this.f134ch == ',') {
            int i4 = i3 + 1;
            this.f134ch = charAt(i4);
            this.f133bp = i4;
            this.token = 16;
            return 3;
        }
        if (this.f134ch == '}') {
            i3++;
            this.f134ch = charAt(i3);
            if (this.f134ch == ',') {
                this.token = 16;
                i3++;
                this.f134ch = charAt(i3);
            } else if (this.f134ch == ']') {
                this.token = 15;
                i3++;
                this.f134ch = charAt(i3);
            } else if (this.f134ch == '}') {
                this.token = 13;
                i3++;
                this.f134ch = charAt(i3);
            } else if (this.f134ch != 26) {
                return -1;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.f133bp = i3;
        return this.matchStat;
    }

    public final boolean matchField(char[] cArr) {
        if (!charArrayCompare(cArr)) {
            return false;
        }
        this.f133bp += cArr.length;
        this.f134ch = charAt(this.f133bp);
        if (this.f134ch == '{') {
            next();
            this.token = 12;
        } else if (this.f134ch == '[') {
            next();
            this.token = 14;
        } else if (this.f134ch == 'S' && charAt(this.f133bp + 1) == 'e' && charAt(this.f133bp + 2) == 't' && charAt(this.f133bp + 3) == '[') {
            this.f133bp += 3;
            this.f134ch = charAt(this.f133bp);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.f133bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.f133bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.f133bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = indexOf - 1;
                    int i3 = 0;
                    while (i2 >= 0 && charAt(i2) == '\\') {
                        i3++;
                        i2--;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int length3 = indexOf - ((this.f133bp + cArr.length) + 1);
                subString = readString(sub_chars(this.f133bp + cArr.length + 1, length3), length3);
            }
            int length4 = i + (indexOf - ((this.f133bp + cArr.length) + 1)) + 1;
            int i4 = length4 + 1;
            char charAt = charAt(this.f133bp + length4);
            if (charAt == ',') {
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i5 = i4 + 1;
                char charAt2 = charAt(this.f133bp + i4);
                if (charAt2 == ',') {
                    this.token = 16;
                    this.f133bp += i5;
                    this.f134ch = charAt(this.f133bp);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    this.f133bp += i5;
                    this.f134ch = charAt(this.f133bp);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    this.f133bp += i5;
                    this.f134ch = charAt(this.f133bp);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.f133bp += i5 - 1;
                    this.f134ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.f133bp + 0);
        if (charAt == 'n') {
            if (charAt(this.f133bp + 1) != 'u' || charAt(this.f133bp + 1 + 1) != 'l' || charAt(this.f133bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.f133bp + 4) == c) {
                this.f133bp += 5;
                this.f134ch = charAt(this.f133bp);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        } else {
            int i = this.f133bp + 1;
            int indexOf = indexOf('\"', i);
            if (indexOf != -1) {
                String subString = subString(this.f133bp + 1, indexOf - i);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i2 = indexOf - 1;
                        int i3 = 0;
                        while (i2 >= 0 && charAt(i2) == '\\') {
                            i3++;
                            i2--;
                        }
                        if (i3 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i4 = indexOf - i;
                    subString = readString(sub_chars(this.f133bp + 1, i4), i4);
                }
                int i5 = 1 + (indexOf - (this.f133bp + 1)) + 1;
                int i6 = i5 + 1;
                if (charAt(this.f133bp + i5) == c) {
                    this.f133bp += i6;
                    this.f134ch = charAt(this.f133bp);
                    this.matchStat = 3;
                    return subString;
                }
                this.matchStat = -1;
                return subString;
            }
            throw new JSONException("unclosed str");
        }
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.f133bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -2128831035;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.f133bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.f133bp + i2);
                if (charAt2 == ',') {
                    this.f133bp += i3;
                    this.f134ch = charAt(this.f133bp);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i4 = i3 + 1;
                    char charAt3 = charAt(this.f133bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.f133bp += i4;
                        this.f134ch = charAt(this.f133bp);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.f133bp += i4;
                        this.f134ch = charAt(this.f133bp);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.f133bp += i4;
                        this.f134ch = charAt(this.f133bp);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.f133bp += i4 - 1;
                        this.f134ch = JSONLexer.EOI;
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
            } else {
                j = (j ^ ((long) charAt)) * 16777619;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Enum<?> scanEnum(java.lang.Class<?> r1, com.alibaba.fastjson.parser.SymbolTable r2, char r3) {
        /*
            r0 = this;
            java.lang.String r2 = r0.scanSymbolWithSeperator(r2, r3)
            if (r2 != 0) goto L_0x0008
            r1 = 0
            return r1
        L_0x0008:
            java.lang.Enum r1 = java.lang.Enum.valueOf(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanEnum(java.lang.Class, com.alibaba.fastjson.parser.SymbolTable, char):java.lang.Enum");
    }

    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        this.matchStat = 0;
        char charAt = charAt(this.f133bp + 0);
        if (charAt == 'n') {
            if (charAt(this.f133bp + 1) != 'u' || charAt(this.f133bp + 1 + 1) != 'l' || charAt(this.f133bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.f133bp + 4) == c) {
                this.f133bp += 5;
                this.f134ch = charAt(this.f133bp);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i = 1;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                char charAt2 = charAt(this.f133bp + i);
                if (charAt2 == '\"') {
                    int i4 = this.f133bp + 0 + 1;
                    String addSymbol = addSymbol(i4, ((this.f133bp + i3) - i4) - 1, i2, symbolTable);
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.f133bp + i3);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.f133bp + i5);
                            i5++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    this.f133bp += i5;
                    this.f134ch = charAt(this.f133bp);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i2 = (i2 * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i = i3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0117, code lost:
        if (r12 != ',') goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0119, code lost:
        r11.f133bp += r0;
        r11.f134ch = charAt(r11.f133bp);
        r11.matchStat = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012c, code lost:
        if (r12 != '}') goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012e, code lost:
        r6 = r0 + 1;
        r12 = charAt(r11.f133bp + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0137, code lost:
        if (r12 != ',') goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r11.token = 16;
        r11.f133bp += r6;
        r11.f134ch = charAt(r11.f133bp);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014b, code lost:
        if (r12 != ']') goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014d, code lost:
        r11.token = 15;
        r11.f133bp += r6;
        r11.f134ch = charAt(r11.f133bp);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015f, code lost:
        if (r12 != '}') goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0161, code lost:
        r11.token = 13;
        r11.f133bp += r6;
        r11.f134ch = charAt(r11.f133bp);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0175, code lost:
        if (r12 != 26) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0177, code lost:
        r11.f133bp += r6 - 1;
        r11.token = 20;
        r11.f134ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0184, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0187, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0188, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018b, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            r11 = this;
            r0 = 0
            r11.matchStat = r0
            boolean r1 = r11.charArrayCompare(r12)
            r2 = 0
            if (r1 != 0) goto L_0x000e
            r12 = -2
            r11.matchStat = r12
            return r2
        L_0x000e:
            java.lang.Class<java.util.HashSet> r1 = java.util.HashSet.class
            boolean r1 = r13.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x001c
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            goto L_0x0030
        L_0x001c:
            java.lang.Class<java.util.ArrayList> r1 = java.util.ArrayList.class
            boolean r1 = r13.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x002a
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            goto L_0x0030
        L_0x002a:
            java.lang.Object r13 = r13.newInstance()     // Catch:{ Exception -> 0x0196 }
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ Exception -> 0x0196 }
        L_0x0030:
            int r12 = r12.length
            int r1 = r11.f133bp
            int r3 = r12 + 1
            int r1 = r1 + r12
            char r12 = r11.charAt(r1)
            r1 = 91
            r4 = -1
            if (r12 == r1) goto L_0x0042
            r11.matchStat = r4
            return r2
        L_0x0042:
            int r12 = r11.f133bp
            int r1 = r3 + 1
            int r12 = r12 + r3
            char r12 = r11.charAt(r12)
        L_0x004b:
            r3 = 44
            r5 = 93
            r6 = 34
            if (r12 != r6) goto L_0x00b5
            int r12 = r11.f133bp
            int r12 = r12 + r1
            int r12 = r11.indexOf(r6, r12)
            if (r12 == r4) goto L_0x00ad
            int r7 = r11.f133bp
            int r7 = r7 + r1
            int r8 = r12 - r7
            java.lang.String r7 = r11.subString(r7, r8)
            r8 = 92
            int r9 = r7.indexOf(r8)
            if (r9 == r4) goto L_0x0099
        L_0x006d:
            int r7 = r12 + -1
            r9 = 0
        L_0x0070:
            if (r7 < 0) goto L_0x007d
            char r10 = r11.charAt(r7)
            if (r10 != r8) goto L_0x007d
            int r9 = r9 + 1
            int r7 = r7 + -1
            goto L_0x0070
        L_0x007d:
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x0092
            int r6 = r11.f133bp
            int r6 = r6 + r1
            int r6 = r12 - r6
            int r7 = r11.f133bp
            int r7 = r7 + r1
            char[] r7 = r11.sub_chars(r7, r6)
            java.lang.String r7 = readString(r7, r6)
            goto L_0x0099
        L_0x0092:
            int r12 = r12 + 1
            int r12 = r11.indexOf(r6, r12)
            goto L_0x006d
        L_0x0099:
            int r6 = r11.f133bp
            int r6 = r6 + r1
            int r12 = r12 - r6
            int r12 = r12 + 1
            int r1 = r1 + r12
            int r12 = r11.f133bp
            int r6 = r1 + 1
            int r12 = r12 + r1
            char r12 = r11.charAt(r12)
            r13.add(r7)
            goto L_0x00ea
        L_0x00ad:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "unclosed str"
            r12.<init>(r13)
            throw r12
        L_0x00b5:
            r6 = 110(0x6e, float:1.54E-43)
            if (r12 != r6) goto L_0x0106
            int r6 = r11.f133bp
            int r6 = r6 + r1
            char r6 = r11.charAt(r6)
            r7 = 117(0x75, float:1.64E-43)
            if (r6 != r7) goto L_0x0106
            int r6 = r11.f133bp
            int r6 = r6 + r1
            int r6 = r6 + 1
            char r6 = r11.charAt(r6)
            r7 = 108(0x6c, float:1.51E-43)
            if (r6 != r7) goto L_0x0106
            int r6 = r11.f133bp
            int r6 = r6 + r1
            int r6 = r6 + 2
            char r6 = r11.charAt(r6)
            if (r6 != r7) goto L_0x0106
            int r1 = r1 + 3
            int r12 = r11.f133bp
            int r6 = r1 + 1
            int r12 = r12 + r1
            char r12 = r11.charAt(r12)
            r13.add(r2)
        L_0x00ea:
            if (r12 != r3) goto L_0x00f7
            int r12 = r11.f133bp
            int r1 = r6 + 1
            int r12 = r12 + r6
            char r12 = r11.charAt(r12)
            goto L_0x004b
        L_0x00f7:
            if (r12 != r5) goto L_0x0103
            int r12 = r11.f133bp
            int r0 = r6 + 1
            int r12 = r12 + r6
            char r12 = r11.charAt(r12)
            goto L_0x0117
        L_0x0103:
            r11.matchStat = r4
            return r2
        L_0x0106:
            if (r12 != r5) goto L_0x018e
            int r12 = r13.size()
            if (r12 != 0) goto L_0x018e
            int r12 = r11.f133bp
            int r0 = r1 + 1
            int r12 = r12 + r1
            char r12 = r11.charAt(r12)
        L_0x0117:
            if (r12 != r3) goto L_0x012a
            int r12 = r11.f133bp
            int r12 = r12 + r0
            r11.f133bp = r12
            int r12 = r11.f133bp
            char r12 = r11.charAt(r12)
            r11.f134ch = r12
            r12 = 3
            r11.matchStat = r12
            return r13
        L_0x012a:
            r1 = 125(0x7d, float:1.75E-43)
            if (r12 != r1) goto L_0x018b
            int r12 = r11.f133bp
            int r6 = r0 + 1
            int r12 = r12 + r0
            char r12 = r11.charAt(r12)
            if (r12 != r3) goto L_0x014b
            r12 = 16
            r11.token = r12
            int r12 = r11.f133bp
            int r12 = r12 + r6
            r11.f133bp = r12
            int r12 = r11.f133bp
            char r12 = r11.charAt(r12)
            r11.f134ch = r12
            goto L_0x0184
        L_0x014b:
            if (r12 != r5) goto L_0x015f
            r12 = 15
            r11.token = r12
            int r12 = r11.f133bp
            int r12 = r12 + r6
            r11.f133bp = r12
            int r12 = r11.f133bp
            char r12 = r11.charAt(r12)
            r11.f134ch = r12
            goto L_0x0184
        L_0x015f:
            if (r12 != r1) goto L_0x0173
            r12 = 13
            r11.token = r12
            int r12 = r11.f133bp
            int r12 = r12 + r6
            r11.f133bp = r12
            int r12 = r11.f133bp
            char r12 = r11.charAt(r12)
            r11.f134ch = r12
            goto L_0x0184
        L_0x0173:
            r0 = 26
            if (r12 != r0) goto L_0x0188
            int r12 = r11.f133bp
            int r6 = r6 + -1
            int r12 = r12 + r6
            r11.f133bp = r12
            r12 = 20
            r11.token = r12
            r11.f134ch = r0
        L_0x0184:
            r12 = 4
            r11.matchStat = r12
            return r13
        L_0x0188:
            r11.matchStat = r4
            return r2
        L_0x018b:
            r11.matchStat = r4
            return r2
        L_0x018e:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "illega str"
            r12.<init>(r13)
            throw r12
        L_0x0196:
            r12 = move-exception
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = r12.getMessage()
            r13.<init>(r0, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public void scanStringArray(Collection<String> collection, char c) {
        int i;
        char c2;
        int i2;
        char c3;
        Collection<String> collection2 = collection;
        char c4 = c;
        this.matchStat = 0;
        char charAt = charAt(this.f133bp + 0);
        char c5 = 'u';
        char c6 = 'n';
        if (charAt == 'n' && charAt(this.f133bp + 1) == 'u' && charAt(this.f133bp + 1 + 1) == 'l' && charAt(this.f133bp + 1 + 2) == 'l' && charAt(this.f133bp + 1 + 3) == c4) {
            this.f133bp += 5;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 5;
        } else if (charAt != '[') {
            this.matchStat = -1;
        } else {
            char charAt2 = charAt(this.f133bp + 1);
            int i3 = 2;
            while (true) {
                if (charAt2 != c6 || charAt(this.f133bp + i3) != c5 || charAt(this.f133bp + i3 + 1) != 'l' || charAt(this.f133bp + i3 + 2) != 'l') {
                    if (charAt2 == ']' && collection.size() == 0) {
                        i = i3 + 1;
                        c2 = charAt(this.f133bp + i3);
                        break;
                    } else if (charAt2 != '\"') {
                        this.matchStat = -1;
                        return;
                    } else {
                        int i4 = this.f133bp + i3;
                        int indexOf = indexOf('\"', i4);
                        if (indexOf != -1) {
                            String subString = subString(this.f133bp + i3, indexOf - i4);
                            if (subString.indexOf(92) != -1) {
                                while (true) {
                                    int i5 = indexOf - 1;
                                    int i6 = 0;
                                    while (i5 >= 0 && charAt(i5) == '\\') {
                                        i6++;
                                        i5--;
                                    }
                                    if (i6 % 2 == 0) {
                                        break;
                                    }
                                    indexOf = indexOf('\"', indexOf + 1);
                                }
                                int i7 = indexOf - i4;
                                subString = readString(sub_chars(this.f133bp + i3, i7), i7);
                            }
                            int i8 = i3 + (indexOf - (this.f133bp + i3)) + 1;
                            i2 = i8 + 1;
                            c3 = charAt(this.f133bp + i8);
                            collection2.add(subString);
                        } else {
                            throw new JSONException("unclosed str");
                        }
                    }
                } else {
                    int i9 = i3 + 3;
                    i2 = i9 + 1;
                    c3 = charAt(this.f133bp + i9);
                    collection2.add((Object) null);
                }
                if (c3 == ',') {
                    i3 = i2 + 1;
                    charAt2 = charAt(this.f133bp + i2);
                    c5 = 'u';
                    c6 = 'n';
                } else if (c3 == ']') {
                    i = i2 + 1;
                    c2 = charAt(this.f133bp + i2);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            if (c2 == c4) {
                this.f133bp += i;
                this.f134ch = charAt(this.f133bp);
                this.matchStat = 3;
                return;
            }
            this.matchStat = -1;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.f133bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.f133bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f133bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                i3 = (i3 * 10) + (charAt - '0');
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            this.f133bp += i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.f133bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f133bp += i4 - 1;
                this.f134ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        int i;
        int i2;
        char c;
        int[] iArr;
        boolean z;
        int i3;
        char charAt;
        char c2;
        int[] iArr2;
        this.matchStat = 0;
        int[] iArr3 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.f133bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt2 = charAt(this.f133bp + i4);
        int[] iArr4 = new int[16];
        if (charAt2 == ']') {
            i = i5 + 1;
            c = charAt(this.f133bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.f133bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    int[] iArr5 = iArr3;
                    this.matchStat = -1;
                } else {
                    int i7 = charAt2 - '0';
                    while (true) {
                        i3 = i5 + 1;
                        charAt = charAt(this.f133bp + i5);
                        if (charAt >= '0' && charAt <= '9') {
                            i7 = (i7 * 10) + (charAt - '0');
                            i5 = i3;
                        }
                    }
                    if (i6 >= iArr4.length) {
                        int[] iArr6 = new int[((iArr4.length * 3) / 2)];
                        System.arraycopy(iArr4, 0, iArr6, 0, i6);
                        iArr4 = iArr6;
                    }
                    i2 = i6 + 1;
                    if (z) {
                        i7 = -i7;
                    }
                    iArr4[i6] = i7;
                    if (charAt == ',') {
                        i5 = i3 + 1;
                        c2 = charAt(this.f133bp + i3);
                        iArr2 = null;
                    } else if (charAt == ']') {
                        i = i3 + 1;
                        c = charAt(this.f133bp + i3);
                        break;
                    } else {
                        iArr2 = null;
                        c2 = charAt;
                        i5 = i3;
                    }
                    int i8 = i2;
                    iArr3 = iArr2;
                    charAt2 = c2;
                    i6 = i8;
                }
            }
            int[] iArr52 = iArr3;
            this.matchStat = -1;
            return iArr52;
        }
        if (i2 != iArr4.length) {
            iArr = new int[i2];
            System.arraycopy(iArr4, 0, iArr, 0, i2);
        } else {
            iArr = iArr4;
        }
        if (c == ',') {
            this.f133bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr;
        } else if (c == '}') {
            int i9 = i + 1;
            char charAt3 = charAt(this.f133bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.f133bp += i9 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.f133bp += i9 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.f133bp += i9 - 1;
                next();
            } else if (charAt3 == 26) {
                this.f133bp += i9 - 1;
                this.token = 20;
                this.f134ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.f133bp + 0);
        int i = 2;
        if (charAt == 't') {
            if (charAt(this.f133bp + 1) == 'r' && charAt(this.f133bp + 1 + 1) == 'u' && charAt(this.f133bp + 1 + 2) == 'e') {
                charAt = charAt(this.f133bp + 4);
                z = true;
                i = 5;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt == 'f') {
            if (charAt(this.f133bp + 1) == 'a' && charAt(this.f133bp + 1 + 1) == 'l' && charAt(this.f133bp + 1 + 2) == 's' && charAt(this.f133bp + 1 + 3) == 'e') {
                charAt = charAt(this.f133bp + 5);
                i = 6;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt == '1') {
            charAt = charAt(this.f133bp + 1);
            z = true;
        } else if (charAt == '0') {
            charAt = charAt(this.f133bp + 1);
        } else {
            i = 1;
        }
        while (charAt != c) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.f133bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        this.f133bp += i;
        this.f134ch = charAt(this.f133bp);
        this.matchStat = 3;
        return z;
    }

    public int scanInt(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.f133bp + 0);
        int i2 = 1;
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.f133bp + 1);
            i2 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f133bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                i3 = (i3 * 10) + (charAt - '0');
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i3 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    i++;
                    charAt = charAt(this.f133bp + i);
                } else {
                    this.matchStat = -1;
                    return z ? -i3 : i3;
                }
            }
            this.f133bp += i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        }
    }

    public boolean scanFieldBoolean(char[] cArr) {
        boolean z;
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.f133bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.f133bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.f133bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.f133bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.f133bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.f133bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.f133bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.f133bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.f133bp + i);
        if (charAt2 == ',') {
            this.f133bp += i9;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i10 = i9 + 1;
            char charAt3 = charAt(this.f133bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                this.f133bp += i10;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.f133bp += i10;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.f133bp += i10;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f133bp += i10 - 1;
                this.f134ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.f133bp + length);
        if (charAt2 == '-') {
            i = i3 + 1;
            charAt2 = charAt(this.f133bp + i3);
            z = true;
        } else {
            i = i3;
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i2 = i + 1;
            charAt = charAt(this.f133bp + i);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i = i2;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (j < 0 || i2 > 21) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            this.f133bp += i2;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i2 + 1;
            char charAt3 = charAt(this.f133bp + i2);
            if (charAt3 == ',') {
                this.token = 16;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f133bp += i4 - 1;
                this.f134ch = JSONLexer.EOI;
            } else {
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

    public long scanLong(char c) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        char charAt2 = charAt(this.f133bp + 0);
        int i2 = 1;
        if (charAt2 == '-') {
            z = true;
        }
        if (z) {
            charAt2 = charAt(this.f133bp + 1);
            i2 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f133bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i2 = i;
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
                    charAt = charAt(this.f133bp + i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.f133bp += i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        }
    }

    public final float scanFieldFloat(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.f133bp + length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f133bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                i2 = i;
            }
        }
        if (charAt == '.') {
            int i3 = i + 1;
            char charAt3 = charAt(this.f133bp + i);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(this.f133bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i3 = i;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        int length2 = this.f133bp + cArr.length;
        float parseFloat = Float.parseFloat(subString(length2, ((this.f133bp + i) - length2) - 1));
        if (charAt == ',') {
            this.f133bp += i;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt4 = charAt(this.f133bp + i);
            if (charAt4 == ',') {
                this.token = 16;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt4 == ']') {
                this.token = 15;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt4 == '}') {
                this.token = 13;
                this.f133bp += i4;
                this.f134ch = charAt(this.f133bp);
            } else if (charAt4 == 26) {
                this.f133bp += i4 - 1;
                this.token = 20;
                this.f134ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 4;
            return parseFloat;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    public final float scanFloat(char c) {
        int i;
        char charAt;
        int i2;
        char c2;
        this.matchStat = 0;
        char charAt2 = charAt(this.f133bp + 0);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i3 = 1;
        while (true) {
            i = i3 + 1;
            charAt = charAt(this.f133bp + i3);
            if (charAt >= '0' && charAt <= '9') {
                i3 = i;
            }
        }
        if (charAt == '.') {
            int i4 = i + 1;
            char charAt3 = charAt(this.f133bp + i);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i2 = i4 + 1;
                    c2 = charAt(this.f133bp + i4);
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    i4 = i2;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        } else {
            c2 = charAt;
            i2 = i;
        }
        int i5 = this.f133bp;
        float parseFloat = Float.parseFloat(subString(i5, ((this.f133bp + i2) - i5) - 1));
        if (c2 == c) {
            this.f133bp += i2;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        }
        this.matchStat = -1;
        return parseFloat;
    }

    public final double scanDouble(char c) {
        int i;
        char charAt;
        int i2;
        this.matchStat = 0;
        char charAt2 = charAt(this.f133bp + 0);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i3 = 1;
        while (true) {
            i = i3 + 1;
            charAt = charAt(this.f133bp + i3);
            if (charAt >= '0' && charAt <= '9') {
                i3 = i;
            }
        }
        if (charAt == '.') {
            int i4 = i + 1;
            char charAt3 = charAt(this.f133bp + i);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i2 = i4 + 1;
                    charAt = charAt(this.f133bp + i4);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i4 = i2;
                }
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
        } else {
            i2 = i;
        }
        int i5 = this.f133bp;
        double parseDouble = Double.parseDouble(subString(i5, ((this.f133bp + i2) - i5) - 1));
        if (charAt == c) {
            this.f133bp += i2;
            this.f134ch = charAt(this.f133bp);
            this.matchStat = 3;
            this.token = 16;
            return parseDouble;
        }
        this.matchStat = -1;
        return parseDouble;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[] scanFieldFloatArray(char[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r18.charArrayCompare(r19)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.matchStat = r3
            return r4
        L_0x0010:
            r2 = r19
            int r2 = r2.length
            int r5 = r0.f133bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.charAt(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0023
            r0.matchStat = r3
            return r4
        L_0x0023:
            int r2 = r0.f133bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r5 = 16
            float[] r6 = new float[r5]
            r7 = r6
            r6 = 0
        L_0x0032:
            int r8 = r0.f133bp
            int r8 = r8 + r3
            r9 = 1
            int r8 = r8 - r9
            r10 = 45
            if (r2 != r10) goto L_0x003d
            r11 = 1
            goto L_0x003e
        L_0x003d:
            r11 = 0
        L_0x003e:
            if (r11 == 0) goto L_0x004a
            int r2 = r0.f133bp
            int r12 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r3 = r12
        L_0x004a:
            r12 = -1
            r13 = 48
            if (r2 < r13) goto L_0x01b3
            r14 = 57
            if (r2 > r14) goto L_0x01b3
            int r2 = r2 + -48
        L_0x0055:
            int r15 = r0.f133bp
            int r16 = r3 + 1
            int r15 = r15 + r3
            char r3 = r0.charAt(r15)
            if (r3 < r13) goto L_0x006a
            if (r3 > r14) goto L_0x006a
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = r16
            goto L_0x0055
        L_0x006a:
            r15 = 46
            if (r3 != r15) goto L_0x0070
            r15 = 1
            goto L_0x0071
        L_0x0070:
            r15 = 0
        L_0x0071:
            r5 = 10
            if (r15 == 0) goto L_0x00a4
            int r3 = r0.f133bp
            int r15 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            if (r3 < r13) goto L_0x00a1
            if (r3 > r14) goto L_0x00a1
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = 10
        L_0x008a:
            int r1 = r0.f133bp
            int r16 = r15 + 1
            int r1 = r1 + r15
            char r1 = r0.charAt(r1)
            if (r1 < r13) goto L_0x00a6
            if (r1 > r14) goto L_0x00a6
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            int r3 = r3 * 10
            r15 = r16
            goto L_0x008a
        L_0x00a1:
            r0.matchStat = r12
            return r4
        L_0x00a4:
            r1 = r3
            r3 = 1
        L_0x00a6:
            r15 = 101(0x65, float:1.42E-43)
            if (r1 == r15) goto L_0x00b1
            r15 = 69
            if (r1 != r15) goto L_0x00af
            goto L_0x00b1
        L_0x00af:
            r15 = 0
            goto L_0x00b2
        L_0x00b1:
            r15 = 1
        L_0x00b2:
            if (r15 == 0) goto L_0x00e3
            int r1 = r0.f133bp
            int r17 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r4 = 43
            if (r1 == r4) goto L_0x00c8
            if (r1 != r10) goto L_0x00c5
            goto L_0x00c8
        L_0x00c5:
            r16 = r17
            goto L_0x00d4
        L_0x00c8:
            int r1 = r0.f133bp
            int r4 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.charAt(r1)
        L_0x00d2:
            r16 = r4
        L_0x00d4:
            if (r1 < r13) goto L_0x00e3
            if (r1 > r14) goto L_0x00e3
            int r1 = r0.f133bp
            int r4 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            goto L_0x00d2
        L_0x00e3:
            int r4 = r0.f133bp
            int r4 = r4 + r16
            int r4 = r4 - r8
            int r4 = r4 - r9
            if (r15 != 0) goto L_0x00f4
            if (r4 >= r5) goto L_0x00f4
            float r2 = (float) r2
            float r3 = (float) r3
            float r2 = r2 / r3
            if (r11 == 0) goto L_0x00fc
            float r2 = -r2
            goto L_0x00fc
        L_0x00f4:
            java.lang.String r2 = r0.subString(r8, r4)
            float r2 = java.lang.Float.parseFloat(r2)
        L_0x00fc:
            int r3 = r7.length
            r4 = 3
            if (r6 < r3) goto L_0x010c
            int r3 = r7.length
            int r3 = r3 * 3
            int r3 = r3 / 2
            float[] r3 = new float[r3]
            r5 = 0
            java.lang.System.arraycopy(r7, r5, r3, r5, r6)
            r7 = r3
        L_0x010c:
            int r3 = r6 + 1
            r7[r6] = r2
            r2 = 44
            if (r1 != r2) goto L_0x0126
            int r1 = r0.f133bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r16 = r2
        L_0x0120:
            r2 = 0
            r4 = 16
            r10 = 0
            goto L_0x01a9
        L_0x0126:
            r5 = 93
            if (r1 != r5) goto L_0x0120
            int r1 = r0.f133bp
            int r6 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            int r8 = r7.length
            if (r3 == r8) goto L_0x013e
            float[] r8 = new float[r3]
            r10 = 0
            java.lang.System.arraycopy(r7, r10, r8, r10, r3)
            r7 = r8
        L_0x013e:
            if (r1 != r2) goto L_0x0150
            int r1 = r0.f133bp
            int r6 = r6 - r9
            int r1 = r1 + r6
            r0.f133bp = r1
            r18.next()
            r0.matchStat = r4
            r4 = 16
            r0.token = r4
            return r7
        L_0x0150:
            r4 = 16
            r3 = 125(0x7d, float:1.75E-43)
            if (r1 != r3) goto L_0x01a5
            int r1 = r0.f133bp
            int r8 = r6 + 1
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x016d
            r0.token = r4
            int r1 = r0.f133bp
            int r8 = r8 - r9
            int r1 = r1 + r8
            r0.f133bp = r1
            r18.next()
            goto L_0x019d
        L_0x016d:
            if (r1 != r5) goto L_0x017d
            r1 = 15
            r0.token = r1
            int r1 = r0.f133bp
            int r8 = r8 - r9
            int r1 = r1 + r8
            r0.f133bp = r1
            r18.next()
            goto L_0x019d
        L_0x017d:
            if (r1 != r3) goto L_0x018d
            r1 = 13
            r0.token = r1
            int r1 = r0.f133bp
            int r8 = r8 - r9
            int r1 = r1 + r8
            r0.f133bp = r1
            r18.next()
            goto L_0x019d
        L_0x018d:
            r2 = 26
            if (r1 != r2) goto L_0x01a1
            int r1 = r0.f133bp
            int r8 = r8 - r9
            int r1 = r1 + r8
            r0.f133bp = r1
            r1 = 20
            r0.token = r1
            r0.f134ch = r2
        L_0x019d:
            r1 = 4
            r0.matchStat = r1
            return r7
        L_0x01a1:
            r0.matchStat = r12
            r2 = 0
            return r2
        L_0x01a5:
            r2 = 0
            r0.matchStat = r12
            return r2
        L_0x01a9:
            r4 = r2
            r6 = r3
            r3 = r16
            r5 = 16
            r2 = r1
            r1 = 0
            goto L_0x0032
        L_0x01b3:
            r2 = r4
            r0.matchStat = r12
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[][] scanFieldFloatArray2(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r19.charArrayCompare(r20)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0012
            r0.matchStat = r3
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0012:
            r2 = r20
            int r2 = r2.length
            int r5 = r0.f133bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.charAt(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0027
            r0.matchStat = r3
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0027:
            int r2 = r0.f133bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r6 = 16
            float[][] r7 = new float[r6][]
            r8 = r7
            r7 = 0
        L_0x0036:
            if (r2 != r5) goto L_0x0229
            int r2 = r0.f133bp
            int r9 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            float[] r3 = new float[r6]
            r10 = 0
        L_0x0044:
            int r11 = r0.f133bp
            int r11 = r11 + r9
            r12 = 1
            int r11 = r11 - r12
            r13 = 45
            if (r2 != r13) goto L_0x004f
            r14 = 1
            goto L_0x0050
        L_0x004f:
            r14 = 0
        L_0x0050:
            if (r14 == 0) goto L_0x005c
            int r2 = r0.f133bp
            int r15 = r9 + 1
            int r2 = r2 + r9
            char r2 = r0.charAt(r2)
            goto L_0x005d
        L_0x005c:
            r15 = r9
        L_0x005d:
            r9 = -1
            r5 = 48
            if (r2 < r5) goto L_0x0222
            r6 = 57
            if (r2 > r6) goto L_0x0222
            int r2 = r2 + -48
        L_0x0068:
            int r1 = r0.f133bp
            int r16 = r15 + 1
            int r1 = r1 + r15
            char r1 = r0.charAt(r1)
            if (r1 < r5) goto L_0x007d
            if (r1 > r6) goto L_0x007d
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r15 = r16
            goto L_0x0068
        L_0x007d:
            r15 = 46
            if (r1 != r15) goto L_0x00b8
            int r1 = r0.f133bp
            int r15 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            if (r1 < r5) goto L_0x00b3
            if (r1 > r6) goto L_0x00b3
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = 10
        L_0x0096:
            int r12 = r0.f133bp
            int r16 = r15 + 1
            int r12 = r12 + r15
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ad
            if (r12 > r6) goto L_0x00ad
            int r2 = r2 * 10
            int r12 = r12 + -48
            int r2 = r2 + r12
            int r1 = r1 * 10
            r15 = r16
            goto L_0x0096
        L_0x00ad:
            r18 = r12
            r12 = r1
            r1 = r18
            goto L_0x00b9
        L_0x00b3:
            r0.matchStat = r9
            float[][] r4 = (float[][]) r4
            return r4
        L_0x00b8:
            r12 = 1
        L_0x00b9:
            r15 = 101(0x65, float:1.42E-43)
            if (r1 == r15) goto L_0x00c4
            r15 = 69
            if (r1 != r15) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r15 = 0
            goto L_0x00c5
        L_0x00c4:
            r15 = 1
        L_0x00c5:
            if (r15 == 0) goto L_0x00f6
            int r1 = r0.f133bp
            int r17 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r4 = 43
            if (r1 == r4) goto L_0x00db
            if (r1 != r13) goto L_0x00d8
            goto L_0x00db
        L_0x00d8:
            r16 = r17
            goto L_0x00e7
        L_0x00db:
            int r1 = r0.f133bp
            int r4 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.charAt(r1)
        L_0x00e5:
            r16 = r4
        L_0x00e7:
            if (r1 < r5) goto L_0x00f6
            if (r1 > r6) goto L_0x00f6
            int r1 = r0.f133bp
            int r4 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            goto L_0x00e5
        L_0x00f6:
            int r4 = r0.f133bp
            int r4 = r4 + r16
            int r4 = r4 - r11
            r5 = 1
            int r4 = r4 - r5
            if (r15 != 0) goto L_0x010a
            r5 = 10
            if (r4 >= r5) goto L_0x010a
            float r2 = (float) r2
            float r4 = (float) r12
            float r2 = r2 / r4
            if (r14 == 0) goto L_0x0112
            float r2 = -r2
            goto L_0x0112
        L_0x010a:
            java.lang.String r2 = r0.subString(r11, r4)
            float r2 = java.lang.Float.parseFloat(r2)
        L_0x0112:
            int r4 = r3.length
            r5 = 3
            if (r10 < r4) goto L_0x0122
            int r4 = r3.length
            int r4 = r4 * 3
            int r4 = r4 / 2
            float[] r4 = new float[r4]
            r6 = 0
            java.lang.System.arraycopy(r3, r6, r4, r6, r10)
            r3 = r4
        L_0x0122:
            int r4 = r10 + 1
            r3[r10] = r2
            r2 = 44
            if (r1 != r2) goto L_0x013c
            int r1 = r0.f133bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r9 = r2
            r5 = 16
            r6 = 0
            r11 = 0
            r2 = r1
            goto L_0x0219
        L_0x013c:
            r6 = 93
            if (r1 != r6) goto L_0x0212
            int r1 = r0.f133bp
            int r10 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            int r11 = r3.length
            if (r4 == r11) goto L_0x0155
            float[] r11 = new float[r4]
            r12 = 0
            java.lang.System.arraycopy(r3, r12, r11, r12, r4)
            r3 = r11
            goto L_0x0156
        L_0x0155:
            r12 = 0
        L_0x0156:
            int r11 = r8.length
            if (r7 < r11) goto L_0x0163
            int r8 = r8.length
            int r8 = r8 * 3
            int r8 = r8 / 2
            float[][] r8 = new float[r8][]
            java.lang.System.arraycopy(r3, r12, r8, r12, r4)
        L_0x0163:
            int r4 = r7 + 1
            r8[r7] = r3
            if (r1 != r2) goto L_0x017a
            int r1 = r0.f133bp
            int r2 = r10 + 1
            int r1 = r1 + r10
            char r1 = r0.charAt(r1)
            r3 = r2
            r5 = 16
            r6 = 0
            r11 = 0
            r2 = r1
            goto L_0x020e
        L_0x017a:
            if (r1 != r6) goto L_0x0208
            int r1 = r0.f133bp
            int r3 = r10 + 1
            int r1 = r1 + r10
            char r1 = r0.charAt(r1)
            int r7 = r8.length
            if (r4 == r7) goto L_0x018f
            float[][] r7 = new float[r4][]
            r11 = 0
            java.lang.System.arraycopy(r8, r11, r7, r11, r4)
            goto L_0x0190
        L_0x018f:
            r7 = r8
        L_0x0190:
            if (r1 != r2) goto L_0x01a3
            int r1 = r0.f133bp
            r2 = 1
            int r3 = r3 - r2
            int r1 = r1 + r3
            r0.f133bp = r1
            r19.next()
            r0.matchStat = r5
            r5 = 16
            r0.token = r5
            return r7
        L_0x01a3:
            r5 = 16
            r4 = 125(0x7d, float:1.75E-43)
            if (r1 != r4) goto L_0x0201
            int r1 = r0.f133bp
            int r4 = r3 + 1
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01c1
            r0.token = r5
            int r1 = r0.f133bp
            r2 = 1
            int r4 = r4 - r2
            int r1 = r1 + r4
            r0.f133bp = r1
            r19.next()
            goto L_0x01f6
        L_0x01c1:
            r2 = 1
            if (r1 != r6) goto L_0x01d2
            r1 = 15
            r0.token = r1
            int r1 = r0.f133bp
            int r4 = r4 - r2
            int r1 = r1 + r4
            r0.f133bp = r1
            r19.next()
            goto L_0x01f6
        L_0x01d2:
            r3 = 125(0x7d, float:1.75E-43)
            if (r1 != r3) goto L_0x01e4
            r1 = 13
            r0.token = r1
            int r1 = r0.f133bp
            int r4 = r4 - r2
            int r1 = r1 + r4
            r0.f133bp = r1
            r19.next()
            goto L_0x01f6
        L_0x01e4:
            r3 = 26
            if (r1 != r3) goto L_0x01fa
            int r1 = r0.f133bp
            int r4 = r4 - r2
            int r1 = r1 + r4
            r0.f133bp = r1
            r1 = 20
            r0.token = r1
            r1 = 26
            r0.f134ch = r1
        L_0x01f6:
            r1 = 4
            r0.matchStat = r1
            return r7
        L_0x01fa:
            r0.matchStat = r9
            r6 = 0
            r4 = r6
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0201:
            r6 = 0
            r0.matchStat = r9
            r4 = r6
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0208:
            r5 = 16
            r6 = 0
            r11 = 0
            r2 = r1
            r3 = r10
        L_0x020e:
            r7 = r4
            r4 = r6
            r1 = 0
            goto L_0x022b
        L_0x0212:
            r5 = 16
            r6 = 0
            r11 = 0
            r2 = r1
            r9 = r16
        L_0x0219:
            r10 = r4
            r4 = r6
            r1 = 0
            r5 = 91
            r6 = 16
            goto L_0x0044
        L_0x0222:
            r6 = r4
            r0.matchStat = r9
            r4 = r6
            float[][] r4 = (float[][]) r4
            return r4
        L_0x0229:
            r5 = 16
        L_0x022b:
            r5 = 91
            r6 = 16
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final double scanFieldDouble(char[] r11) {
        /*
            r10 = this;
            r0 = 0
            r10.matchStat = r0
            boolean r0 = r10.charArrayCompare(r11)
            r1 = 0
            if (r0 != 0) goto L_0x000f
            r11 = -2
            r10.matchStat = r11
            return r1
        L_0x000f:
            int r0 = r11.length
            int r3 = r10.f133bp
            int r4 = r0 + 1
            int r3 = r3 + r0
            char r0 = r10.charAt(r3)
            r3 = -1
            r5 = 48
            if (r0 < r5) goto L_0x0116
            r6 = 57
            if (r0 > r6) goto L_0x0116
        L_0x0022:
            int r0 = r10.f133bp
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.charAt(r0)
            if (r0 < r5) goto L_0x0031
            if (r0 > r6) goto L_0x0031
            r4 = r7
            goto L_0x0022
        L_0x0031:
            r4 = 46
            if (r0 != r4) goto L_0x0054
            int r0 = r10.f133bp
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.charAt(r0)
            if (r0 < r5) goto L_0x0051
            if (r0 > r6) goto L_0x0051
        L_0x0042:
            int r0 = r10.f133bp
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.charAt(r0)
            if (r0 < r5) goto L_0x0054
            if (r0 > r6) goto L_0x0054
            r4 = r7
            goto L_0x0042
        L_0x0051:
            r10.matchStat = r3
            return r1
        L_0x0054:
            r4 = 101(0x65, float:1.42E-43)
            if (r0 == r4) goto L_0x005c
            r4 = 69
            if (r0 != r4) goto L_0x0087
        L_0x005c:
            int r0 = r10.f133bp
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.charAt(r0)
            r7 = 43
            if (r0 == r7) goto L_0x0070
            r7 = 45
            if (r0 != r7) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r7 = r4
            goto L_0x0079
        L_0x0070:
            int r0 = r10.f133bp
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.charAt(r0)
        L_0x0079:
            if (r0 < r5) goto L_0x0087
            if (r0 > r6) goto L_0x0087
            int r0 = r10.f133bp
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.charAt(r0)
            goto L_0x006e
        L_0x0087:
            int r4 = r10.f133bp
            int r11 = r11.length
            int r4 = r4 + r11
            int r11 = r10.f133bp
            int r11 = r11 + r7
            int r11 = r11 - r4
            int r11 = r11 + -1
            java.lang.String r11 = r10.subString(r4, r11)
            double r4 = java.lang.Double.parseDouble(r11)
            r11 = 16
            r6 = 44
            if (r0 != r6) goto L_0x00b2
            int r0 = r10.f133bp
            int r0 = r0 + r7
            r10.f133bp = r0
            int r0 = r10.f133bp
            char r0 = r10.charAt(r0)
            r10.f134ch = r0
            r0 = 3
            r10.matchStat = r0
            r10.token = r11
            return r4
        L_0x00b2:
            r8 = 125(0x7d, float:1.75E-43)
            if (r0 != r8) goto L_0x0113
            int r0 = r10.f133bp
            int r9 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.charAt(r0)
            if (r0 != r6) goto L_0x00d1
            r10.token = r11
            int r11 = r10.f133bp
            int r11 = r11 + r9
            r10.f133bp = r11
            int r11 = r10.f133bp
            char r11 = r10.charAt(r11)
            r10.f134ch = r11
            goto L_0x010c
        L_0x00d1:
            r11 = 93
            if (r0 != r11) goto L_0x00e7
            r11 = 15
            r10.token = r11
            int r11 = r10.f133bp
            int r11 = r11 + r9
            r10.f133bp = r11
            int r11 = r10.f133bp
            char r11 = r10.charAt(r11)
            r10.f134ch = r11
            goto L_0x010c
        L_0x00e7:
            if (r0 != r8) goto L_0x00fb
            r11 = 13
            r10.token = r11
            int r11 = r10.f133bp
            int r11 = r11 + r9
            r10.f133bp = r11
            int r11 = r10.f133bp
            char r11 = r10.charAt(r11)
            r10.f134ch = r11
            goto L_0x010c
        L_0x00fb:
            r11 = 26
            if (r0 != r11) goto L_0x0110
            r0 = 20
            r10.token = r0
            int r0 = r10.f133bp
            int r9 = r9 + -1
            int r0 = r0 + r9
            r10.f133bp = r0
            r10.f134ch = r11
        L_0x010c:
            r11 = 4
            r10.matchStat = r11
            return r4
        L_0x0110:
            r10.matchStat = r3
            return r1
        L_0x0113:
            r10.matchStat = r3
            return r1
        L_0x0116:
            r10.matchStat = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    public final void scanTrue() {
        if (this.f134ch == 't') {
            next();
            if (this.f134ch == 'r') {
                next();
                if (this.f134ch == 'u') {
                    next();
                    if (this.f134ch == 'e') {
                        next();
                        if (this.f134ch == ' ' || this.f134ch == ',' || this.f134ch == '}' || this.f134ch == ']' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 26 || this.f134ch == 12 || this.f134ch == 8 || this.f134ch == ':' || this.f134ch == '/') {
                            this.token = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final void scanNullOrNew() {
        if (this.f134ch == 'n') {
            next();
            if (this.f134ch == 'u') {
                next();
                if (this.f134ch == 'l') {
                    next();
                    if (this.f134ch == 'l') {
                        next();
                        if (this.f134ch == ' ' || this.f134ch == ',' || this.f134ch == '}' || this.f134ch == ']' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 26 || this.f134ch == 12 || this.f134ch == 8) {
                            this.token = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException("error parse null");
                }
                throw new JSONException("error parse null");
            } else if (this.f134ch == 'e') {
                next();
                if (this.f134ch == 'w') {
                    next();
                    if (this.f134ch == ' ' || this.f134ch == ',' || this.f134ch == '}' || this.f134ch == ']' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 26 || this.f134ch == 12 || this.f134ch == 8) {
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException("error parse new");
            } else {
                throw new JSONException("error parse new");
            }
        } else {
            throw new JSONException("error parse null or new");
        }
    }

    public final void scanFalse() {
        if (this.f134ch == 'f') {
            next();
            if (this.f134ch == 'a') {
                next();
                if (this.f134ch == 'l') {
                    next();
                    if (this.f134ch == 's') {
                        next();
                        if (this.f134ch == 'e') {
                            next();
                            if (this.f134ch == ' ' || this.f134ch == ',' || this.f134ch == '}' || this.f134ch == ']' || this.f134ch == 10 || this.f134ch == 13 || this.f134ch == 9 || this.f134ch == 26 || this.f134ch == 12 || this.f134ch == 8 || this.f134ch == ':' || this.f134ch == '/') {
                                this.token = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public final void scanIdent() {
        this.f135np = this.f133bp - 1;
        this.hasSpecial = false;
        do {
            this.f136sp++;
            next();
        } while (Character.isLetterOrDigit(this.f134ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        int i3;
        char[] cArr2 = new char[i];
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            char c = cArr[i2];
            if (c != '\\') {
                cArr2[i5] = c;
                i5++;
            } else {
                i2++;
                char c2 = cArr[i2];
                switch (c2) {
                    case '/':
                        i3 = i5 + 1;
                        cArr2[i5] = '/';
                        break;
                    case '0':
                        i3 = i5 + 1;
                        cArr2[i5] = 0;
                        break;
                    case '1':
                        i3 = i5 + 1;
                        cArr2[i5] = 1;
                        break;
                    case '2':
                        i3 = i5 + 1;
                        cArr2[i5] = 2;
                        break;
                    case '3':
                        i3 = i5 + 1;
                        cArr2[i5] = 3;
                        break;
                    case '4':
                        i3 = i5 + 1;
                        cArr2[i5] = 4;
                        break;
                    case '5':
                        i3 = i5 + 1;
                        cArr2[i5] = 5;
                        break;
                    case '6':
                        i3 = i5 + 1;
                        cArr2[i5] = 6;
                        break;
                    case '7':
                        i3 = i5 + 1;
                        cArr2[i5] = 7;
                        break;
                    default:
                        switch (c2) {
                            case 't':
                                i3 = i5 + 1;
                                cArr2[i5] = 9;
                                break;
                            case 'u':
                                i3 = i5 + 1;
                                int i6 = i2 + 1;
                                int i7 = i6 + 1;
                                int i8 = i7 + 1;
                                i2 = i8 + 1;
                                cArr2[i5] = (char) Integer.parseInt(new String(new char[]{cArr[i6], cArr[i7], cArr[i8], cArr[i2]}), 16);
                                break;
                            case 'v':
                                i3 = i5 + 1;
                                cArr2[i5] = 11;
                                break;
                            default:
                                switch (c2) {
                                    case '\"':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '\"';
                                        break;
                                    case '\'':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '\'';
                                        break;
                                    case 'F':
                                    case 'f':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 12;
                                        break;
                                    case '\\':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '\\';
                                        break;
                                    case 'b':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 8;
                                        break;
                                    case 'n':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 10;
                                        break;
                                    case 'r':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 13;
                                        break;
                                    case 'x':
                                        i3 = i5 + 1;
                                        int i9 = i2 + 1;
                                        i2 = i9 + 1;
                                        cArr2[i5] = (char) ((digits[cArr[i9]] * 16) + digits[cArr[i2]]);
                                        break;
                                    default:
                                        throw new JSONException("unclosed.str.lit");
                                }
                        }
                }
                i5 = i3;
            }
            i4 = i2 + 1;
        }
        return new String(cArr2, 0, i5);
    }

    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    public final void skipWhitespace() {
        while (this.f134ch <= '/') {
            if (this.f134ch == ' ' || this.f134ch == 13 || this.f134ch == 10 || this.f134ch == 9 || this.f134ch == 12 || this.f134ch == 8) {
                next();
            } else if (this.f134ch == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    private void scanStringSingleQuote() {
        this.f135np = this.f133bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    if (this.f136sp > this.sbuf.length) {
                        char[] cArr = new char[(this.f136sp * 2)];
                        System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                        this.sbuf = cArr;
                    }
                    copyTo(this.f135np + 1, this.f136sp, this.sbuf);
                }
                char next2 = next();
                switch (next2) {
                    case '/':
                        putChar('/');
                        break;
                    case '0':
                        putChar(0);
                        break;
                    case '1':
                        putChar(1);
                        break;
                    case '2':
                        putChar(2);
                        break;
                    case '3':
                        putChar(3);
                        break;
                    case '4':
                        putChar(4);
                        break;
                    case '5':
                        putChar(5);
                        break;
                    case '6':
                        putChar(6);
                        break;
                    case '7':
                        putChar(7);
                        break;
                    default:
                        switch (next2) {
                            case 't':
                                putChar(9);
                                break;
                            case 'u':
                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                break;
                            case 'v':
                                putChar(11);
                                break;
                            default:
                                switch (next2) {
                                    case '\"':
                                        putChar('\"');
                                        break;
                                    case '\'':
                                        putChar('\'');
                                        break;
                                    case 'F':
                                    case 'f':
                                        putChar(12);
                                        break;
                                    case '\\':
                                        putChar('\\');
                                        break;
                                    case 'b':
                                        putChar(8);
                                        break;
                                    case 'n':
                                        putChar(10);
                                        break;
                                    case 'r':
                                        putChar(13);
                                        break;
                                    case 'x':
                                        putChar((char) ((digits[next()] * 16) + digits[next()]));
                                        break;
                                    default:
                                        this.f134ch = next2;
                                        throw new JSONException("unclosed single-quote string");
                                }
                        }
                }
            } else if (!this.hasSpecial) {
                this.f136sp++;
            } else if (this.f136sp == this.sbuf.length) {
                putChar(next);
            } else {
                char[] cArr2 = this.sbuf;
                int i = this.f136sp;
                this.f136sp = i + 1;
                cArr2[i] = next;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void putChar(char c) {
        if (this.f136sp == this.sbuf.length) {
            char[] cArr = new char[(this.sbuf.length * 2)];
            System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
            this.sbuf = cArr;
        }
        char[] cArr2 = this.sbuf;
        int i = this.f136sp;
        this.f136sp = i + 1;
        cArr2[i] = c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanNumber() {
        /*
            r9 = this;
            int r0 = r9.f133bp
            r9.f135np = r0
            char r0 = r9.f134ch
            r1 = 45
            r2 = 1
            if (r0 != r1) goto L_0x0013
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
        L_0x0013:
            char r0 = r9.f134ch
            r3 = 57
            r4 = 48
            if (r0 < r4) goto L_0x0028
            char r0 = r9.f134ch
            if (r0 > r3) goto L_0x0028
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            goto L_0x0013
        L_0x0028:
            r0 = 0
            char r5 = r9.f134ch
            r6 = 46
            if (r5 != r6) goto L_0x0049
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
        L_0x0037:
            char r0 = r9.f134ch
            if (r0 < r4) goto L_0x0048
            char r0 = r9.f134ch
            if (r0 > r3) goto L_0x0048
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            goto L_0x0037
        L_0x0048:
            r0 = 1
        L_0x0049:
            char r5 = r9.f134ch
            r6 = 76
            if (r5 != r6) goto L_0x0058
            int r1 = r9.f136sp
            int r1 = r1 + r2
            r9.f136sp = r1
            r9.next()
            goto L_0x00a1
        L_0x0058:
            char r5 = r9.f134ch
            r6 = 83
            if (r5 != r6) goto L_0x0067
            int r1 = r9.f136sp
            int r1 = r1 + r2
            r9.f136sp = r1
            r9.next()
            goto L_0x00a1
        L_0x0067:
            char r5 = r9.f134ch
            r6 = 66
            if (r5 != r6) goto L_0x0076
            int r1 = r9.f136sp
            int r1 = r1 + r2
            r9.f136sp = r1
            r9.next()
            goto L_0x00a1
        L_0x0076:
            char r5 = r9.f134ch
            r6 = 70
            if (r5 != r6) goto L_0x0085
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            goto L_0x00de
        L_0x0085:
            char r5 = r9.f134ch
            r7 = 68
            if (r5 != r7) goto L_0x0094
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            goto L_0x00de
        L_0x0094:
            char r5 = r9.f134ch
            r8 = 101(0x65, float:1.42E-43)
            if (r5 == r8) goto L_0x00a3
            char r5 = r9.f134ch
            r8 = 69
            if (r5 != r8) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r2 = r0
            goto L_0x00de
        L_0x00a3:
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            char r0 = r9.f134ch
            r5 = 43
            if (r0 == r5) goto L_0x00b5
            char r0 = r9.f134ch
            if (r0 != r1) goto L_0x00bd
        L_0x00b5:
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
        L_0x00bd:
            char r0 = r9.f134ch
            if (r0 < r4) goto L_0x00ce
            char r0 = r9.f134ch
            if (r0 > r3) goto L_0x00ce
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
            goto L_0x00bd
        L_0x00ce:
            char r0 = r9.f134ch
            if (r0 == r7) goto L_0x00d6
            char r0 = r9.f134ch
            if (r0 != r6) goto L_0x00de
        L_0x00d6:
            int r0 = r9.f136sp
            int r0 = r0 + r2
            r9.f136sp = r0
            r9.next()
        L_0x00de:
            if (r2 == 0) goto L_0x00e4
            r0 = 3
            r9.token = r0
            goto L_0x00e7
        L_0x00e4:
            r0 = 2
            r9.token = r0
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.f135np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L_0x0008
            r15.f135np = r1
        L_0x0008:
            int r0 = r15.f135np
            int r2 = r15.f135np
            int r3 = r15.f136sp
            int r2 = r2 + r3
            int r3 = r15.f135np
            char r3 = r15.charAt(r3)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x0020
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = 1
            goto L_0x0025
        L_0x0020:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0025:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L_0x0038
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r9 = (long) r0
        L_0x0036:
            r0 = r8
            goto L_0x003a
        L_0x0038:
            r9 = 0
        L_0x003a:
            if (r0 >= r2) goto L_0x0077
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            r11 = 76
            if (r0 == r11) goto L_0x0076
            r11 = 83
            if (r0 == r11) goto L_0x0076
            r11 = 66
            if (r0 != r11) goto L_0x004f
            goto L_0x0076
        L_0x004f:
            int r0 = r0 + -48
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L_0x006c
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x0062
            long r9 = r9 - r11
            goto L_0x0036
        L_0x0062:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x006c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0076:
            r0 = r8
        L_0x0077:
            if (r1 == 0) goto L_0x0089
            int r1 = r15.f135np
            int r1 = r1 + r5
            if (r0 <= r1) goto L_0x007f
            return r9
        L_0x007f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0089:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.f135np + this.f136sp) - 1);
        if (charAt == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage() + ", " + info());
            }
        } else if (charAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        }
    }
}
