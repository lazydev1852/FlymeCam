package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

public final class SerializeWriter extends Writer {
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeautres = ((((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserSecure.mask) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask);
    protected boolean beanToArray;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer2) {
        this(writer2, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer2, SerializerFeature... serializerFeatureArr) {
        this(writer2, 0, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer2, int i, SerializerFeature... serializerFeatureArr) {
        this.writer = writer2;
        this.buf = bufLocal.get();
        if (this.buf != null) {
            bufLocal.set((Object) null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i |= mask.getMask();
        }
        this.features = i;
        computeFeatures();
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer2, int i) {
        this.writer = writer2;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= ~SerializerFeature.WriteEnumUsingName.getMask();
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features &= ~SerializerFeature.WriteEnumUsingToString.getMask();
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    /* access modifiers changed from: protected */
    public void computeFeatures() {
        boolean z = false;
        this.quoteFieldNames = (this.features & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.useSingleQuotes = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.sortField = (this.features & SerializerFeature.SortField.mask) != 0;
        this.disableCircularReferenceDetect = (this.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.beanToArray = (this.features & SerializerFeature.BeanToArray.mask) != 0;
        this.writeNonStringValueAsString = (this.features & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.notWriteDefaultValue = (this.features & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.writeEnumUsingName = (this.features & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.writeEnumUsingToString = (this.features & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        if (this.quoteFieldNames && (this.features & nonDirectFeautres) == 0 && (this.beanToArray || this.writeEnumUsingName)) {
            z = true;
        }
        this.writeDirect = z;
        this.keySeperator = this.useSingleQuotes ? '\'' : '\"';
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public void write(int i) {
        int i2 = this.count + 1;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.count + i2;
            if (i4 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i4);
                } else {
                    do {
                        int length = this.buf.length - this.count;
                        System.arraycopy(cArr, i, this.buf, this.count, length);
                        this.count = this.buf.length;
                        flush();
                        i2 -= length;
                        i += length;
                    } while (i2 > this.buf.length);
                    i4 = i2;
                }
            }
            System.arraycopy(cArr, i, this.buf, this.count, i2);
            this.count = i4;
        }
    }

    public void expandCapacity(int i) {
        int length = ((this.buf.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.buf, 0, cArr, 0, this.count);
        this.buf = cArr;
    }

    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(char c) {
        write((int) c);
        return this;
    }

    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    int length = this.buf.length - this.count;
                    i3 = i + length;
                    str.getChars(i, i3, this.buf, this.count);
                    this.count = this.buf.length;
                    flush();
                    i2 -= length;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void writeTo(Writer writer2) throws IOException {
        if (this.writer == null) {
            writer2.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        } else {
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            char[] cArr = new char[this.count];
            System.arraycopy(this.buf, 0, cArr, 0, this.count);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            char[] cArr = new char[(this.count - 2)];
            System.arraycopy(this.buf, 1, cArr, 0, this.count - 2);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str == null || "UTF-8".equals(str)) {
            charset = IOUtils.UTF8;
        } else {
            charset = Charset.forName(str);
        }
        return toBytes(charset);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8Bytes();
        } else {
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i = (int) (((double) this.count) * 3.0d);
        byte[] bArr = bytesBufLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            bytesBufLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i = (int) (((double) this.count) * 3.0d);
        byte[] bArr = bytesBufLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            bytesBufLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, encodeUTF8);
        return bArr2;
    }

    public int size() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        if (this.buf.length <= 65536) {
            bufLocal.set(this.buf);
        }
        this.buf = null;
    }

    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i, stringSize, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        char c = this.useSingleQuotes ? '\'' : '\"';
        if (length == 0) {
            write(this.useSingleQuotes ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.f137CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = this.count + (((i2 / 3) + 1) << 2) + 2;
        int i5 = 0;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                int i6 = 0;
                while (i6 < i) {
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    byte b = ((bArr2[i6] & 255) << 16) | ((bArr2[i7] & 255) << 8) | (bArr2[i8] & 255);
                    write((int) cArr[(b >>> 18) & 63]);
                    write((int) cArr[(b >>> 12) & 63]);
                    write((int) cArr[(b >>> 6) & 63]);
                    write((int) cArr[b & 63]);
                    i6 = i8 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = (bArr2[i] & 255) << 10;
                    if (i9 == 2) {
                        i5 = (bArr2[i2] & 255) << 2;
                    }
                    int i11 = i10 | i5;
                    write((int) cArr[i11 >> 12]);
                    write((int) cArr[(i11 >>> 6) & 63]);
                    write((int) i9 == 2 ? cArr[i11 & 63] : '=');
                    write(61);
                }
                write((int) c);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i12 = i3 + 1;
        this.buf[i3] = c;
        int i13 = 0;
        while (i13 < i) {
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            byte b2 = ((bArr2[i13] & 255) << 16) | ((bArr2[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b3 = b2 | (bArr2[i15] & 255);
            int i17 = i12 + 1;
            this.buf[i12] = cArr[(b3 >>> 18) & 63];
            int i18 = i17 + 1;
            this.buf[i17] = cArr[(b3 >>> 12) & 63];
            int i19 = i18 + 1;
            this.buf[i18] = cArr[(b3 >>> 6) & 63];
            this.buf[i19] = cArr[b3 & 63];
            i13 = i16;
            i12 = i19 + 1;
        }
        int i20 = length - i;
        if (i20 > 0) {
            int i21 = (bArr2[i] & 255) << 10;
            if (i20 == 2) {
                i5 = (bArr2[i2] & 255) << 2;
            }
            int i22 = i21 | i5;
            this.buf[i4 - 5] = cArr[i22 >> 12];
            this.buf[i4 - 4] = cArr[(i22 >>> 6) & 63];
            this.buf[i4 - 3] = i20 == 2 ? cArr[i22 & 63] : '=';
            this.buf[i4 - 2] = '=';
        }
        this.buf[i4 - 1] = c;
    }

    public void writeFloat(float f, boolean z) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            writeNull();
            return;
        }
        String f2 = Float.toString(f);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && f2.endsWith(".0")) {
            f2 = f2.substring(0, f2.length() - 2);
        }
        write(f2);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeDouble(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
            return;
        }
        String d2 = Double.toString(d);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && d2.endsWith(".0")) {
            d2 = d2.substring(0, d2.length() - 2);
        }
        write(d2);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> enumR) {
        if (enumR == null) {
            writeNull();
            return;
        }
        String str = null;
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = enumR.name();
        } else if (this.writeEnumUsingToString) {
            str = enumR.toString();
        }
        if (str != null) {
            int i = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i);
            write(str);
            write(i);
            return;
        }
        writeInt(enumR.ordinal());
    }

    public void writeLong(long j) {
        boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j != Long.MIN_VALUE) {
            int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
            int i = this.count + stringSize;
            if (z) {
                i += 2;
            }
            if (i > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i);
                } else {
                    char[] cArr = new char[stringSize];
                    IOUtils.getChars(j, stringSize, cArr);
                    if (z) {
                        write(34);
                        write(cArr, 0, cArr.length);
                        write(34);
                        return;
                    }
                    write(cArr, 0, cArr.length);
                    return;
                }
            }
            if (z) {
                this.buf[this.count] = '\"';
                int i2 = i - 1;
                IOUtils.getChars(j, i2, this.buf);
                this.buf[i2] = '\"';
            } else {
                IOUtils.getChars(j, i, this.buf);
            }
            this.count = i;
        } else if (z) {
            write("\"-9223372036854775808\"");
        } else {
            write("-9223372036854775808");
        }
    }

    public void writeNull() {
        write("null");
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public void writeNull(int i, int i2) {
        if ((i & i2) == 0 && (this.features & i2) == 0) {
            writeNull();
        } else if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
        } else if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
        } else if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03de, code lost:
        if (r7 == -1) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0414, code lost:
        if (r7 == -1) goto L_0x03e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(java.lang.String r19, char r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            if (r1 != 0) goto L_0x0011
            r18.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r19.length()
            int r4 = r0.count
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r4 = r4 + 1
        L_0x001e:
            char[] r5 = r0.buf
            int r5 = r5.length
            r6 = 0
            r7 = 47
            r8 = 48
            r9 = 117(0x75, float:1.64E-43)
            r10 = 12
            r11 = 8
            r12 = 34
            r13 = 92
            r14 = 4
            r15 = 1
            if (r4 <= r5) goto L_0x018a
            java.io.Writer r5 = r0.writer
            if (r5 == 0) goto L_0x0187
            r0.write((int) r12)
        L_0x003b:
            int r3 = r19.length()
            if (r6 >= r3) goto L_0x017e
            char r3 = r1.charAt(r6)
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)
            if (r4 == 0) goto L_0x00a1
            if (r3 < r8) goto L_0x0053
            r4 = 57
            if (r3 <= r4) goto L_0x0177
        L_0x0053:
            r4 = 97
            if (r3 < r4) goto L_0x005b
            r4 = 122(0x7a, float:1.71E-43)
            if (r3 <= r4) goto L_0x0177
        L_0x005b:
            r4 = 65
            if (r3 < r4) goto L_0x0063
            r4 = 90
            if (r3 <= r4) goto L_0x0177
        L_0x0063:
            r4 = 44
            if (r3 == r4) goto L_0x0177
            r4 = 46
            if (r3 == r4) goto L_0x0177
            r4 = 95
            if (r3 == r4) goto L_0x0177
            r0.write((int) r13)
            r0.write((int) r9)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x00a1:
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)
            if (r4 == 0) goto L_0x0123
            if (r3 == r11) goto L_0x0118
            if (r3 == r10) goto L_0x0118
            r4 = 10
            if (r3 == r4) goto L_0x0118
            r4 = 13
            if (r3 == r4) goto L_0x0118
            r4 = 9
            if (r3 == r4) goto L_0x0118
            if (r3 == r12) goto L_0x0118
            if (r3 == r7) goto L_0x0118
            if (r3 != r13) goto L_0x00c0
            goto L_0x0118
        L_0x00c0:
            r4 = 32
            if (r3 >= r4) goto L_0x00e3
            r0.write((int) r13)
            r0.write((int) r9)
            r0.write((int) r8)
            r0.write((int) r8)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r3 = r3 * 2
            char r4 = r4[r3]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r3 = r3 + r15
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x00e3:
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 < r4) goto L_0x0177
            r0.write((int) r13)
            r0.write((int) r9)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x0118:
            r0.write((int) r13)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x0123:
            byte[] r4 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r4 = r4.length
            if (r3 >= r4) goto L_0x012e
            byte[] r4 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r4 = r4[r3]
            if (r4 != 0) goto L_0x0138
        L_0x012e:
            if (r3 != r7) goto L_0x0177
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)
            if (r4 == 0) goto L_0x0177
        L_0x0138:
            r0.write((int) r13)
            byte[] r4 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r4 = r4[r3]
            if (r4 != r14) goto L_0x016f
            r0.write((int) r9)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r3 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.write((int) r4)
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x016f:
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x017a
        L_0x0177:
            r0.write((int) r3)
        L_0x017a:
            int r6 = r6 + 1
            goto L_0x003b
        L_0x017e:
            r0.write((int) r12)
            if (r2 == 0) goto L_0x0186
            r0.write((int) r2)
        L_0x0186:
            return
        L_0x0187:
            r0.expandCapacity(r4)
        L_0x018a:
            int r5 = r0.count
            int r5 = r5 + r15
            int r14 = r5 + r3
            char[] r10 = r0.buf
            int r11 = r0.count
            r10[r11] = r12
            char[] r10 = r0.buf
            r1.getChars(r6, r3, r10, r5)
            r0.count = r4
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r3)
            r10 = -1
            if (r3 == 0) goto L_0x0271
            r1 = r5
        L_0x01a6:
            if (r1 >= r14) goto L_0x01d4
            char[] r3 = r0.buf
            char r3 = r3[r1]
            if (r3 < r8) goto L_0x01b2
            r6 = 57
            if (r3 <= r6) goto L_0x01d1
        L_0x01b2:
            r6 = 97
            if (r3 < r6) goto L_0x01ba
            r6 = 122(0x7a, float:1.71E-43)
            if (r3 <= r6) goto L_0x01d1
        L_0x01ba:
            r6 = 65
            if (r3 < r6) goto L_0x01c2
            r6 = 90
            if (r3 <= r6) goto L_0x01d1
        L_0x01c2:
            r6 = 44
            if (r3 == r6) goto L_0x01d1
            r6 = 46
            if (r3 == r6) goto L_0x01d1
            r6 = 95
            if (r3 == r6) goto L_0x01d1
            int r4 = r4 + 5
            r10 = r1
        L_0x01d1:
            int r1 = r1 + 1
            goto L_0x01a6
        L_0x01d4:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x01dc
            r0.expandCapacity(r4)
        L_0x01dc:
            r0.count = r4
        L_0x01de:
            if (r10 < r5) goto L_0x0257
            char[] r1 = r0.buf
            char r1 = r1[r10]
            if (r1 < r8) goto L_0x01ea
            r3 = 57
            if (r1 <= r3) goto L_0x0254
        L_0x01ea:
            r3 = 97
            if (r1 < r3) goto L_0x01f2
            r3 = 122(0x7a, float:1.71E-43)
            if (r1 <= r3) goto L_0x0254
        L_0x01f2:
            r3 = 65
            if (r1 < r3) goto L_0x01fa
            r3 = 90
            if (r1 <= r3) goto L_0x0254
        L_0x01fa:
            r3 = 44
            if (r1 == r3) goto L_0x0254
            r3 = 46
            if (r1 == r3) goto L_0x0254
            r3 = 95
            if (r1 == r3) goto L_0x0254
            char[] r3 = r0.buf
            int r4 = r10 + 1
            char[] r6 = r0.buf
            int r7 = r10 + 6
            int r11 = r14 - r10
            int r11 = r11 - r15
            java.lang.System.arraycopy(r3, r4, r6, r7, r11)
            char[] r3 = r0.buf
            r3[r10] = r13
            char[] r3 = r0.buf
            r3[r4] = r9
            char[] r3 = r0.buf
            int r4 = r10 + 2
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 12
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 3
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 8
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 4
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 4
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 5
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r1 = r1 & 15
            char r1 = r6[r1]
            r3[r4] = r1
            int r14 = r14 + 5
        L_0x0254:
            int r10 = r10 + -1
            goto L_0x01de
        L_0x0257:
            if (r2 == 0) goto L_0x0269
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 + -2
            r1[r3] = r12
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 - r15
            r1[r3] = r2
            goto L_0x0270
        L_0x0269:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r15
            r1[r2] = r12
        L_0x0270:
            return
        L_0x0271:
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r3)
            if (r3 == 0) goto L_0x03cb
            r1 = r5
        L_0x027a:
            if (r1 >= r14) goto L_0x02b3
            char[] r3 = r0.buf
            char r3 = r3[r1]
            if (r3 == r12) goto L_0x02ad
            if (r3 == r7) goto L_0x02ad
            if (r3 != r13) goto L_0x0287
            goto L_0x02ad
        L_0x0287:
            r6 = 8
            if (r3 == r6) goto L_0x02aa
            r6 = 12
            if (r3 == r6) goto L_0x02aa
            r6 = 10
            if (r3 == r6) goto L_0x02aa
            r6 = 13
            if (r3 == r6) goto L_0x02aa
            r6 = 9
            if (r3 != r6) goto L_0x029c
            goto L_0x02aa
        L_0x029c:
            r6 = 32
            if (r3 >= r6) goto L_0x02a3
            int r4 = r4 + 5
            goto L_0x02af
        L_0x02a3:
            r6 = 127(0x7f, float:1.78E-43)
            if (r3 < r6) goto L_0x02b0
            int r4 = r4 + 5
            goto L_0x02af
        L_0x02aa:
            int r4 = r4 + 1
            goto L_0x02af
        L_0x02ad:
            int r4 = r4 + 1
        L_0x02af:
            r10 = r1
        L_0x02b0:
            int r1 = r1 + 1
            goto L_0x027a
        L_0x02b3:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x02bb
            r0.expandCapacity(r4)
        L_0x02bb:
            r0.count = r4
        L_0x02bd:
            if (r10 < r5) goto L_0x03b1
            char[] r1 = r0.buf
            char r1 = r1[r10]
            r3 = 8
            if (r1 == r3) goto L_0x038f
            r4 = 12
            if (r1 == r4) goto L_0x038f
            r6 = 10
            if (r1 == r6) goto L_0x038f
            r6 = 13
            if (r1 == r6) goto L_0x038f
            r6 = 9
            if (r1 != r6) goto L_0x02d9
            goto L_0x038f
        L_0x02d9:
            if (r1 == r12) goto L_0x0376
            if (r1 == r7) goto L_0x0376
            if (r1 != r13) goto L_0x02e1
            goto L_0x0376
        L_0x02e1:
            r6 = 32
            if (r1 >= r6) goto L_0x0323
            char[] r6 = r0.buf
            int r11 = r10 + 1
            char[] r3 = r0.buf
            int r4 = r10 + 6
            int r16 = r14 - r10
            int r7 = r16 + -1
            java.lang.System.arraycopy(r6, r11, r3, r4, r7)
            char[] r3 = r0.buf
            r3[r10] = r13
            char[] r3 = r0.buf
            r3[r11] = r9
            char[] r3 = r0.buf
            int r4 = r10 + 2
            r3[r4] = r8
            char[] r3 = r0.buf
            int r4 = r10 + 3
            r3[r4] = r8
            char[] r3 = r0.buf
            int r4 = r10 + 4
            char[] r6 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r1 = r1 * 2
            char r6 = r6[r1]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 5
            char[] r6 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r1 = r1 + r15
            char r1 = r6[r1]
            r3[r4] = r1
            int r14 = r14 + 5
            goto L_0x03ab
        L_0x0323:
            r3 = 127(0x7f, float:1.78E-43)
            if (r1 < r3) goto L_0x03ab
            char[] r3 = r0.buf
            int r4 = r10 + 1
            char[] r6 = r0.buf
            int r7 = r10 + 6
            int r11 = r14 - r10
            int r11 = r11 - r15
            java.lang.System.arraycopy(r3, r4, r6, r7, r11)
            char[] r3 = r0.buf
            r3[r10] = r13
            char[] r3 = r0.buf
            r3[r4] = r9
            char[] r3 = r0.buf
            int r4 = r10 + 2
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 12
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 3
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 8
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 4
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r1 >>> 4
            r7 = r7 & 15
            char r6 = r6[r7]
            r3[r4] = r6
            char[] r3 = r0.buf
            int r4 = r10 + 5
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r1 = r1 & 15
            char r1 = r6[r1]
            r3[r4] = r1
            int r14 = r14 + 5
            goto L_0x03ab
        L_0x0376:
            char[] r3 = r0.buf
            int r4 = r10 + 1
            char[] r6 = r0.buf
            int r7 = r10 + 2
            int r11 = r14 - r10
            int r11 = r11 - r15
            java.lang.System.arraycopy(r3, r4, r6, r7, r11)
            char[] r3 = r0.buf
            r3[r10] = r13
            char[] r3 = r0.buf
            r3[r4] = r1
            int r14 = r14 + 1
            goto L_0x03ab
        L_0x038f:
            char[] r3 = r0.buf
            int r4 = r10 + 1
            char[] r6 = r0.buf
            int r7 = r10 + 2
            int r11 = r14 - r10
            int r11 = r11 - r15
            java.lang.System.arraycopy(r3, r4, r6, r7, r11)
            char[] r3 = r0.buf
            r3[r10] = r13
            char[] r3 = r0.buf
            char[] r6 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r1 = r6[r1]
            r3[r4] = r1
            int r14 = r14 + 1
        L_0x03ab:
            int r10 = r10 + -1
            r7 = 47
            goto L_0x02bd
        L_0x03b1:
            if (r2 == 0) goto L_0x03c3
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 + -2
            r1[r3] = r12
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 - r15
            r1[r3] = r2
            goto L_0x03ca
        L_0x03c3:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r15
            r1[r2] = r12
        L_0x03ca:
            return
        L_0x03cb:
            r3 = r5
            r7 = -1
            r11 = 0
            r17 = -1
        L_0x03d0:
            if (r3 >= r14) goto L_0x041e
            char[] r12 = r0.buf
            char r12 = r12[r3]
            r8 = 8232(0x2028, float:1.1535E-41)
            if (r12 != r8) goto L_0x03e8
            int r6 = r6 + 1
            int r4 = r4 + 4
            if (r7 != r10) goto L_0x03e4
        L_0x03e0:
            r7 = r3
            r17 = r7
            goto L_0x03e6
        L_0x03e4:
            r17 = r3
        L_0x03e6:
            r11 = r12
            goto L_0x0417
        L_0x03e8:
            r8 = 93
            if (r12 < r8) goto L_0x03fc
            r8 = 127(0x7f, float:1.78E-43)
            if (r12 < r8) goto L_0x0417
            r8 = 160(0xa0, float:2.24E-43)
            if (r12 >= r8) goto L_0x0417
            if (r7 != r10) goto L_0x03f7
            r7 = r3
        L_0x03f7:
            int r6 = r6 + 1
            int r4 = r4 + 4
            goto L_0x03e4
        L_0x03fc:
            int r8 = r0.features
            boolean r8 = isSpecial(r12, r8)
            if (r8 == 0) goto L_0x0417
            int r6 = r6 + 1
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r8 = r8.length
            if (r12 >= r8) goto L_0x0414
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r8 = r8[r12]
            r11 = 4
            if (r8 != r11) goto L_0x0414
            int r4 = r4 + 4
        L_0x0414:
            if (r7 != r10) goto L_0x03e4
            goto L_0x03e0
        L_0x0417:
            int r3 = r3 + 1
            r8 = 48
            r12 = 34
            goto L_0x03d0
        L_0x041e:
            if (r6 <= 0) goto L_0x05ac
            int r4 = r4 + r6
            char[] r3 = r0.buf
            int r3 = r3.length
            if (r4 <= r3) goto L_0x0429
            r0.expandCapacity(r4)
        L_0x0429:
            r0.count = r4
            if (r6 != r15) goto L_0x04db
            r1 = 8232(0x2028, float:1.1535E-41)
            if (r11 != r1) goto L_0x0465
            int r1 = r17 + 1
            int r3 = r17 + 6
            int r14 = r14 - r17
            int r14 = r14 - r15
            char[] r4 = r0.buf
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r4, r1, r5, r3, r14)
            char[] r3 = r0.buf
            r3[r17] = r13
            char[] r3 = r0.buf
            r3[r1] = r9
            char[] r3 = r0.buf
            int r1 = r1 + r15
            r4 = 50
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r15
            r4 = 48
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r15
            r4 = 50
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r15
            r4 = 56
            r3[r1] = r4
            goto L_0x05ac
        L_0x0465:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r1 = r1.length
            if (r11 >= r1) goto L_0x04bf
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r1 = r1[r11]
            r3 = 4
            if (r1 != r3) goto L_0x04bf
            int r1 = r17 + 1
            int r3 = r17 + 6
            int r14 = r14 - r17
            int r14 = r14 - r15
            char[] r4 = r0.buf
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r4, r1, r5, r3, r14)
            char[] r3 = r0.buf
            r3[r17] = r13
            char[] r3 = r0.buf
            int r4 = r1 + 1
            r3[r1] = r9
            char[] r1 = r0.buf
            int r3 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r11 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            char[] r1 = r0.buf
            int r4 = r3 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r11 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r3] = r5
            char[] r1 = r0.buf
            int r3 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r11 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            char[] r1 = r0.buf
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r5 = r11 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            goto L_0x05ac
        L_0x04bf:
            int r1 = r17 + 1
            int r3 = r17 + 2
            int r14 = r14 - r17
            int r14 = r14 - r15
            char[] r4 = r0.buf
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r4, r1, r5, r3, r14)
            char[] r3 = r0.buf
            r3[r17] = r13
            char[] r3 = r0.buf
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r4[r11]
            r3[r1] = r4
            goto L_0x05ac
        L_0x04db:
            if (r6 <= r15) goto L_0x05ac
            int r3 = r7 - r5
        L_0x04df:
            int r4 = r19.length()
            if (r3 >= r4) goto L_0x05ac
            char r4 = r1.charAt(r3)
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r5 = r5.length
            if (r4 >= r5) goto L_0x04f8
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            if (r5 != 0) goto L_0x04f5
            goto L_0x04f8
        L_0x04f5:
            r5 = 47
            goto L_0x0504
        L_0x04f8:
            r5 = 47
            if (r4 != r5) goto L_0x0559
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r6 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r6)
            if (r6 == 0) goto L_0x0559
        L_0x0504:
            char[] r6 = r0.buf
            int r8 = r7 + 1
            r6[r7] = r13
            byte[] r6 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r6 = r6[r4]
            r10 = 4
            if (r6 != r10) goto L_0x054e
            char[] r6 = r0.buf
            int r7 = r8 + 1
            r6[r8] = r9
            char[] r6 = r0.buf
            int r8 = r7 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 12
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r7] = r11
            char[] r6 = r0.buf
            int r7 = r8 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 8
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r8] = r11
            char[] r6 = r0.buf
            int r8 = r7 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 4
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r7] = r11
            char[] r6 = r0.buf
            int r7 = r8 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r11[r4]
            r6[r8] = r4
            goto L_0x05a8
        L_0x054e:
            char[] r6 = r0.buf
            int r7 = r8 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r11[r4]
            r6[r8] = r4
            goto L_0x05a8
        L_0x0559:
            r10 = 4
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r6) goto L_0x05a1
            char[] r6 = r0.buf
            int r8 = r7 + 1
            r6[r7] = r13
            char[] r6 = r0.buf
            int r7 = r8 + 1
            r6[r8] = r9
            char[] r6 = r0.buf
            int r8 = r7 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 12
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r7] = r11
            char[] r6 = r0.buf
            int r7 = r8 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 8
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r8] = r11
            char[] r6 = r0.buf
            int r8 = r7 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r12 = r4 >>> 4
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r7] = r11
            char[] r6 = r0.buf
            int r7 = r8 + 1
            char[] r11 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r11[r4]
            r6[r8] = r4
            goto L_0x05a8
        L_0x05a1:
            char[] r6 = r0.buf
            int r8 = r7 + 1
            r6[r7] = r4
            r7 = r8
        L_0x05a8:
            int r3 = r3 + 1
            goto L_0x04df
        L_0x05ac:
            if (r2 == 0) goto L_0x05c0
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 + -2
            r4 = 34
            r1[r3] = r4
            char[] r1 = r0.buf
            int r3 = r0.count
            int r3 = r3 - r15
            r1[r3] = r2
            goto L_0x05c9
        L_0x05c0:
            r4 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r15
            r1[r2] = r4
        L_0x05c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length + 3;
        if (i > this.buf.length) {
            expandCapacity(i);
        }
        this.buf[this.count] = '\"';
        str.getChars(0, length, this.buf, this.count + 1);
        this.count = i;
        this.buf[this.count - 2] = '\"';
        this.buf[this.count - 1] = ':';
    }

    public void write(List<String> list) {
        boolean z;
        int i;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i2 = this.count;
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            String str = list.get(i4);
            if (str == null) {
                z = true;
            } else {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z) {
                        break;
                    }
                }
            }
            if (z) {
                this.count = i2;
                write(91);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str2 = list.get(i6);
                    if (i6 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i3 + 3;
            if (i4 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i3;
                expandCapacity(length2);
            }
            if (i4 == 0) {
                i = i3 + 1;
                this.buf[i3] = '[';
            } else {
                i = i3 + 1;
                this.buf[i3] = ',';
            }
            int i7 = i + 1;
            this.buf[i] = '\"';
            str.getChars(0, str.length(), this.buf, i7);
            int length3 = i7 + str.length();
            this.buf[length3] = '\"';
            i4++;
            i3 = length3 + 1;
        }
        this.buf[i3] = ']';
        this.count = i3 + 1;
    }

    public void writeFieldValue(char c, String str, char c2) {
        write((int) c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValue(char c, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        this.buf[i3] = c;
        int i4 = i3 + length + 1;
        this.buf[i3 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i4 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i4 + 2, 6);
        }
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            writeInt(i);
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = this.count + length + 4 + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeInt(i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        this.buf[i3] = c;
        int i4 = i3 + length + 1;
        this.buf[i3 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        this.buf[i4 + 2] = ':';
        IOUtils.getChars(i, this.count, this.buf);
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            writeLong(j);
            return;
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = this.count + length + 4 + stringSize;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        this.buf[i2] = c;
        int i3 = i2 + length + 1;
        this.buf[i2 + 1] = this.keySeperator;
        str.getChars(0, length, this.buf, i2 + 2);
        this.buf[i3 + 1] = this.keySeperator;
        this.buf[i3 + 2] = ':';
        IOUtils.getChars(j, this.count, this.buf);
    }

    public void writeFieldValue(char c, String str, float f) {
        write((int) c);
        writeFieldName(str);
        writeFloat(f, false);
    }

    public void writeFieldValue(char c, String str, double d) {
        write((int) c);
        writeFieldName(str);
        writeDouble(d, false);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (this.useSingleQuotes) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (isEnabled(SerializerFeature.BrowserSecure)) {
            write((int) c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, 0);
        } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
            write((int) c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, 0);
        } else {
            writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
        }
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char c, String str, String str2) {
        int i;
        int i2;
        int i3;
        String str3 = str;
        String str4 = str2;
        int length = str.length();
        int i4 = this.count;
        if (str4 == null) {
            i2 = i4 + length + 8;
            i = 4;
        } else {
            i = str2.length();
            i2 = i4 + length + i + 6;
        }
        int i5 = 0;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeStringWithDoubleQuote(str3, ':');
                writeStringWithDoubleQuote(str4, 0);
                return;
            }
            expandCapacity(i2);
        }
        this.buf[this.count] = c;
        int i6 = this.count + 2;
        int i7 = i6 + length;
        this.buf[this.count + 1] = '\"';
        str3.getChars(0, length, this.buf, i6);
        this.count = i2;
        this.buf[i7] = '\"';
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        this.buf[i8] = ':';
        if (str4 == null) {
            int i10 = i9 + 1;
            this.buf[i9] = 'n';
            int i11 = i10 + 1;
            this.buf[i10] = 'u';
            this.buf[i11] = 'l';
            this.buf[i11 + 1] = 'l';
            return;
        }
        int i12 = i9 + 1;
        this.buf[i9] = '\"';
        int i13 = i12 + i;
        str4.getChars(0, i, this.buf, i12);
        int i14 = i2;
        int i15 = -1;
        char c2 = 0;
        int i16 = -1;
        for (int i17 = i12; i17 < i13; i17++) {
            char c3 = this.buf[i17];
            if (c3 >= ']') {
                if (c3 >= 127 && (c3 == 8232 || c3 < 160)) {
                    if (i15 == -1) {
                        i15 = i17;
                    }
                    i5++;
                    i14 += 4;
                }
            } else if (isSpecial(c3, this.features)) {
                i5++;
                if (c3 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c3] == 4) {
                    i14 += 4;
                }
                if (i15 == -1) {
                    i15 = i17;
                    i16 = i15;
                    c2 = c3;
                }
            }
            i16 = i17;
            c2 = c3;
        }
        if (i5 > 0) {
            int i18 = i14 + i5;
            if (i18 > this.buf.length) {
                expandCapacity(i18);
            }
            this.count = i18;
            if (i5 == 1) {
                if (c2 == 8232) {
                    int i19 = i16 + 1;
                    System.arraycopy(this.buf, i19, this.buf, i16 + 6, (i13 - i16) - 1);
                    this.buf[i16] = '\\';
                    this.buf[i19] = 'u';
                    int i20 = i19 + 1;
                    this.buf[i20] = '2';
                    int i21 = i20 + 1;
                    this.buf[i21] = '0';
                    int i22 = i21 + 1;
                    this.buf[i22] = '2';
                    this.buf[i22 + 1] = '8';
                } else if (c2 >= IOUtils.specicalFlags_doubleQuotes.length || IOUtils.specicalFlags_doubleQuotes[c2] != 4) {
                    int i23 = i16 + 1;
                    System.arraycopy(this.buf, i23, this.buf, i16 + 2, (i13 - i16) - 1);
                    this.buf[i16] = '\\';
                    this.buf[i23] = IOUtils.replaceChars[c2];
                } else {
                    int i24 = i16 + 1;
                    System.arraycopy(this.buf, i24, this.buf, i16 + 6, (i13 - i16) - 1);
                    this.buf[i16] = '\\';
                    int i25 = i24 + 1;
                    this.buf[i24] = 'u';
                    int i26 = i25 + 1;
                    this.buf[i25] = IOUtils.DIGITS[(c2 >>> 12) & 15];
                    int i27 = i26 + 1;
                    this.buf[i26] = IOUtils.DIGITS[(c2 >>> 8) & 15];
                    this.buf[i27] = IOUtils.DIGITS[(c2 >>> 4) & 15];
                    this.buf[i27 + 1] = IOUtils.DIGITS[c2 & 15];
                }
            } else if (i5 > 1) {
                for (int i28 = i15 - i12; i28 < str2.length(); i28++) {
                    char charAt = str4.charAt(i28);
                    if ((charAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        int i29 = i15 + 1;
                        this.buf[i15] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                            int i30 = i29 + 1;
                            this.buf[i29] = 'u';
                            int i31 = i30 + 1;
                            this.buf[i30] = IOUtils.DIGITS[(charAt >>> 12) & 15];
                            int i32 = i31 + 1;
                            this.buf[i31] = IOUtils.DIGITS[(charAt >>> 8) & 15];
                            int i33 = i32 + 1;
                            this.buf[i32] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                            i3 = i33 + 1;
                            this.buf[i33] = IOUtils.DIGITS[charAt & 15];
                        } else {
                            i3 = i29 + 1;
                            this.buf[i29] = IOUtils.replaceChars[charAt];
                        }
                        i15 = i3;
                    } else if (charAt == 8232) {
                        int i34 = i15 + 1;
                        this.buf[i15] = '\\';
                        int i35 = i34 + 1;
                        this.buf[i34] = 'u';
                        int i36 = i35 + 1;
                        this.buf[i35] = IOUtils.DIGITS[(charAt >>> 12) & 15];
                        int i37 = i36 + 1;
                        this.buf[i36] = IOUtils.DIGITS[(charAt >>> 8) & 15];
                        int i38 = i37 + 1;
                        this.buf[i37] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                        this.buf[i38] = IOUtils.DIGITS[charAt & 15];
                        i15 = i38 + 1;
                    } else {
                        this.buf[i15] = charAt;
                        i15++;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, 0);
                return;
            }
            expandCapacity(i2);
        }
        this.buf[this.count] = c;
        int i3 = this.count + 2;
        int i4 = i3 + length;
        this.buf[this.count + 1] = '\"';
        str.getChars(0, length, this.buf, i3);
        this.count = i2;
        this.buf[i4] = '\"';
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        this.buf[i5] = ':';
        this.buf[i6] = '\"';
        str2.getChars(0, length2, this.buf, i6 + 1);
        this.buf[this.count - 1] = '\"';
    }

    static boolean isSpecial(char c, int i) {
        if (c == ' ') {
            return false;
        }
        if (c == '/') {
            return (SerializerFeature.WriteSlashAsSpecial.mask & i) != 0;
        }
        if (c <= '#' || c == '\\') {
            return c <= 31 || c == '\\' || c == '\"';
        }
        return false;
    }

    public void writeFieldValue(char c, String str, Enum<?> enumR) {
        if (enumR == null) {
            write((int) c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.toString());
        } else {
            writeFieldValue(c, str, enumR.ordinal());
        }
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        write((int) c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }

    public void writeString(String str, char c) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write((int) c);
            return;
        }
        writeStringWithDoubleQuote(str, c);
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count + 1;
        int i5 = i4 + length;
        this.buf[this.count] = '\'';
        str.getChars(0, length, this.buf, i4);
        this.count = i3;
        int i6 = -1;
        char c = 0;
        for (int i7 = i4; i7 < i5; i7++) {
            char c2 = this.buf[i7];
            if (c2 <= 13 || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i6 = i7;
                c = c2;
            }
        }
        int i8 = i3 + i;
        if (i8 > this.buf.length) {
            expandCapacity(i8);
        }
        this.count = i8;
        if (i == 1) {
            int i9 = i6 + 1;
            System.arraycopy(this.buf, i9, this.buf, i6 + 2, (i5 - i6) - 1);
            this.buf[i6] = '\\';
            this.buf[i9] = IOUtils.replaceChars[c];
        } else if (i > 1) {
            int i10 = i6 + 1;
            System.arraycopy(this.buf, i10, this.buf, i6 + 2, (i5 - i6) - 1);
            this.buf[i6] = '\\';
            this.buf[i10] = IOUtils.replaceChars[c];
            int i11 = i5 + 1;
            for (int i12 = i10 - 2; i12 >= i4; i12--) {
                char c3 = this.buf[i12];
                if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    int i13 = i12 + 1;
                    System.arraycopy(this.buf, i13, this.buf, i12 + 2, (i11 - i12) - 1);
                    this.buf[i12] = '\\';
                    this.buf[i13] = IOUtils.replaceChars[c3];
                    i11++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            boolean z2 = str.length() == 0;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    break;
                } else if (isSpecial(str.charAt(i), 0)) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z2) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        String str2 = str;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char charAt = str2.charAt(i3);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt2]);
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            if (this.count + 3 > this.buf.length) {
                expandCapacity(this.count + 3);
            }
            char[] cArr = this.buf;
            int i4 = this.count;
            this.count = i4 + 1;
            cArr[i4] = '\'';
            char[] cArr2 = this.buf;
            int i5 = this.count;
            this.count = i5 + 1;
            cArr2[i5] = '\'';
            char[] cArr3 = this.buf;
            int i6 = this.count;
            this.count = i6 + 1;
            cArr3[i6] = ':';
            return;
        }
        int i7 = this.count;
        int i8 = i7 + length;
        str2.getChars(0, length, this.buf, i7);
        this.count = i;
        int i9 = i7;
        boolean z2 = false;
        while (i9 < i8) {
            char c = this.buf[i9];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > this.buf.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    int i10 = i9 + 1;
                    System.arraycopy(this.buf, i10, this.buf, i9 + 3, (i8 - i9) - 1);
                    System.arraycopy(this.buf, i2, this.buf, 1, i9);
                    this.buf[i7] = '\'';
                    this.buf[i10] = '\\';
                    int i11 = i10 + 1;
                    this.buf[i11] = IOUtils.replaceChars[c];
                    i8 += 2;
                    this.buf[this.count - 2] = '\'';
                    i9 = i11;
                    z2 = true;
                } else {
                    i++;
                    if (i > this.buf.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    int i12 = i9 + 1;
                    System.arraycopy(this.buf, i12, this.buf, i9 + 2, i8 - i9);
                    this.buf[i9] = '\\';
                    this.buf[i12] = IOUtils.replaceChars[c];
                    i8++;
                    i9 = i12;
                }
            }
            i9++;
            i2 = 0;
        }
        this.buf[i - 1] = ':';
    }

    public void flush() {
        if (this.writer != null) {
            try {
                this.writer.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }
}
