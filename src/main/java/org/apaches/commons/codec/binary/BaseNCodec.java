package org.apaches.commons.codec.binary;

import java.util.Arrays;
import org.apaches.commons.codec.BinaryDecoder;
import org.apaches.commons.codec.BinaryEncoder;
import org.apaches.commons.codec.DecoderException;
import org.apaches.commons.codec.EncoderException;

public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = PAD_DEFAULT;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    private final int unencodedBlockSize;

    protected static boolean isWhiteSpace(byte b) {
        if (b == 13 || b == 32) {
            return true;
        }
        switch (b) {
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    /* access modifiers changed from: package-private */
    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    /* access modifiers changed from: protected */
    public int getDefaultBufferSize() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isInAlphabet(byte b);

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)});
        }
    }

    protected BaseNCodec(int i, int i2, int i3, int i4) {
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.chunkSeparatorLength = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    /* access modifiers changed from: package-private */
    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    private byte[] resizeBuffer(Context context) {
        if (context.buffer == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr = new byte[(context.buffer.length * 2)];
            System.arraycopy(context.buffer, 0, bArr, 0, context.buffer.length);
            context.buffer = bArr;
        }
        return context.buffer;
    }

    /* access modifiers changed from: protected */
    public byte[] ensureBufferSize(int i, Context context) {
        if (context.buffer == null || context.buffer.length < context.pos + i) {
            return resizeBuffer(context);
        }
        return context.buffer;
    }

    /* access modifiers changed from: package-private */
    public int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int min = Math.min(available(context), i2);
        System.arraycopy(context.buffer, context.readPos, bArr, i, min);
        context.readPos += min;
        if (context.readPos >= context.pos) {
            context.buffer = null;
        }
        return min;
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        byte[] bArr2 = new byte[context.pos];
        readResults(bArr2, 0, bArr2.length, context);
        return bArr2;
    }

    public byte[] encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, 0, bArr.length, context);
        encode(bArr, 0, -1, context);
        byte[] bArr2 = new byte[(context.pos - context.readPos)];
        readResults(bArr2, 0, bArr2.length, context);
        return bArr2;
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isInAlphabet(bArr[i]) && (!z || (bArr[i] != 61 && !isWhiteSpace(bArr[i])))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    /* access modifiers changed from: protected */
    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] bArr) {
        long length = ((long) (((bArr.length + this.unencodedBlockSize) - 1) / this.unencodedBlockSize)) * ((long) this.encodedBlockSize);
        return this.lineLength > 0 ? length + ((((((long) this.lineLength) + length) - 1) / ((long) this.lineLength)) * ((long) this.chunkSeparatorLength)) : length;
    }
}
