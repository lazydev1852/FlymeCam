package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(String str, int i) {
        this((Reader) new StringReader(str), i);
    }

    public JSONReaderScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader2) {
        this(reader2, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader2, int i) {
        super(i);
        this.reader = reader2;
        this.buf = BUF_LOCAL.get();
        if (this.buf != null) {
            BUF_LOCAL.set((Object) null);
        }
        if (this.buf == null) {
            this.buf = new char[8192];
        }
        try {
            this.bufLength = reader2.read(this.buf);
            this.f133bp = -1;
            next();
            if (this.f134ch == 65279) {
                next();
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public JSONReaderScanner(char[] cArr, int i, int i2) {
        this((Reader) new CharArrayReader(cArr, 0, i), i2);
    }

    public final char charAt(int i) {
        if (i >= this.bufLength) {
            if (this.bufLength == -1) {
                if (i < this.f136sp) {
                    return this.buf[i];
                }
                return JSONLexer.EOI;
            } else if (this.f133bp == 0) {
                char[] cArr = new char[((this.buf.length * 3) / 2)];
                System.arraycopy(this.buf, this.f133bp, cArr, 0, this.bufLength);
                try {
                    this.bufLength += this.reader.read(cArr, this.bufLength, cArr.length - this.bufLength);
                    this.buf = cArr;
                } catch (IOException e) {
                    throw new JSONException(e.getMessage(), e);
                }
            } else {
                int i2 = this.bufLength - this.f133bp;
                if (i2 > 0) {
                    System.arraycopy(this.buf, this.f133bp, this.buf, 0, i2);
                }
                try {
                    this.bufLength = this.reader.read(this.buf, i2, this.buf.length - i2);
                    if (this.bufLength == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    } else if (this.bufLength == -1) {
                        return JSONLexer.EOI;
                    } else {
                        this.bufLength += i2;
                        i -= this.f133bp;
                        this.f135np -= this.f133bp;
                        this.f133bp = 0;
                    }
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.buf[i];
    }

    public final int indexOf(char c, int i) {
        int i2 = i - this.f133bp;
        while (true) {
            char charAt = charAt(this.f133bp + i2);
            if (c == charAt) {
                return i2 + this.f133bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i2++;
        }
    }

    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i, i2, i3);
    }

    public final char next() {
        int i = this.f133bp + 1;
        this.f133bp = i;
        if (i >= this.bufLength) {
            if (this.bufLength == -1) {
                return JSONLexer.EOI;
            }
            if (this.f136sp > 0) {
                int i2 = this.bufLength - this.f136sp;
                if (this.f134ch == '\"') {
                    i2--;
                }
                System.arraycopy(this.buf, i2, this.buf, 0, this.f136sp);
            }
            this.f135np = -1;
            i = this.f136sp;
            this.f133bp = i;
            try {
                int i3 = this.f133bp;
                int length = this.buf.length - i3;
                if (length == 0) {
                    char[] cArr = new char[(this.buf.length * 2)];
                    System.arraycopy(this.buf, 0, cArr, 0, this.buf.length);
                    this.buf = cArr;
                    length = this.buf.length - i3;
                }
                this.bufLength = this.reader.read(this.buf, this.f133bp, length);
                if (this.bufLength == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                } else if (this.bufLength == -1) {
                    this.f134ch = JSONLexer.EOI;
                    return JSONLexer.EOI;
                } else {
                    this.bufLength += this.f133bp;
                }
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char c = this.buf[i];
        this.f134ch = c;
        return c;
    }

    /* access modifiers changed from: protected */
    public final void copyTo(int i, int i2, char[] cArr) {
        System.arraycopy(this.buf, i, cArr, 0, i2);
    }

    public final boolean charArrayCompare(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (charAt(this.f133bp + i) != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    public byte[] bytesValue() {
        return IOUtils.decodeBase64(this.buf, this.f135np + 1, this.f136sp);
    }

    /* access modifiers changed from: protected */
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        System.arraycopy(this.buf, i, cArr, i2, i3);
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return new String(this.sbuf, 0, this.f136sp);
        }
        int i = this.f135np + 1;
        if (i < 0) {
            throw new IllegalStateException();
        } else if (i <= this.buf.length - this.f136sp) {
            return new String(this.buf, i, this.f136sp);
        } else {
            throw new IllegalStateException();
        }
    }

    public final String subString(int i, int i2) {
        if (i2 >= 0) {
            return new String(this.buf, i, i2);
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    public final char[] sub_chars(int i, int i2) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        } else if (i == 0) {
            return this.buf;
        } else {
            char[] cArr = new char[i2];
            System.arraycopy(this.buf, i, cArr, 0, i2);
            return cArr;
        }
    }

    public final String numberString() {
        int i = this.f135np;
        if (i == -1) {
            i = 0;
        }
        char charAt = charAt((this.f136sp + i) - 1);
        int i2 = this.f136sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        return new String(this.buf, i, i2);
    }

    public final BigDecimal decimalValue() {
        int i = this.f135np;
        if (i == -1) {
            i = 0;
        }
        char charAt = charAt((this.f136sp + i) - 1);
        int i2 = this.f136sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        return new BigDecimal(this.buf, i, i2);
    }

    public void close() {
        super.close();
        if (this.buf.length <= 32768) {
            BUF_LOCAL.set(this.buf);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    public boolean isEOF() {
        if (this.bufLength == -1 || this.f133bp == this.buf.length) {
            return true;
        }
        return this.f134ch == 26 && this.f133bp + 1 == this.buf.length;
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char c = this.buf[i];
            if (c == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(c)) {
                return false;
            } else {
                i++;
            }
        }
    }
}
