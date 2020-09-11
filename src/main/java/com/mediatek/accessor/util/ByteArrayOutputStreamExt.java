package com.mediatek.accessor.util;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamExt extends ByteArrayOutputStream {
    private static final int BIT_SHIFT_COUNT_16 = 16;
    private static final int BIT_SHIFT_COUNT_24 = 24;
    private static final int BIT_SHIFT_COUNT_8 = 8;
    private static final int BYTE_MASK_FF = 255;

    public final void writeShort(int i) {
        write(i >> 8);
        write(i & 255);
    }

    public final void writeInt(int i) {
        write(i >> 24);
        write((i >> 16) & 255);
        write((i >> 8) & 255);
        write(i & 255);
    }
}
