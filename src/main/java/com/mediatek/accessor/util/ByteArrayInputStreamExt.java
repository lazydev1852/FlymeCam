package com.mediatek.accessor.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExt extends ByteArrayInputStream {
    private static final int BIT_SHIFT_COUNT_16 = 16;
    private static final int BIT_SHIFT_COUNT_24 = 24;
    private static final int BIT_SHIFT_COUNT_8 = 8;
    private static final String TAG = Log.Tag(ByteArrayInputStreamExt.class.getSimpleName());

    public ByteArrayInputStreamExt(byte[] bArr) {
        super(bArr);
        String str = TAG;
        Log.m3993d(str, "<ByteArrayInputStreamExt> new instance, buf count 0x" + Integer.toHexString(bArr.length));
    }

    public final int readUnsignedShort() {
        return (read() << 8) | read();
    }

    public final int readInt() {
        return (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    public final int readReverseInt() {
        int read = read();
        int read2 = read();
        return read | (read2 << 8) | (read() << 16) | (read() << 24);
    }

    public synchronized void seek(long j) throws IOException {
        if (j <= ((long) (this.count - 1))) {
            this.pos = (int) j;
        } else {
            throw new IOException("offset out of buffer range: offset " + j + ", buffer count " + this.count);
        }
    }

    public synchronized long getFilePointer() {
        return (long) this.pos;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
