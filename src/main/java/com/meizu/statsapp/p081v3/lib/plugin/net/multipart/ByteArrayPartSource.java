package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.ByteArrayPartSource */
public class ByteArrayPartSource implements PartSource {
    private byte[] bytes;
    private String fileName;

    public ByteArrayPartSource(String str, byte[] bArr) {
        this.fileName = str;
        this.bytes = bArr;
    }

    public long getLength() {
        return (long) this.bytes.length;
    }

    public String getFileName() {
        return this.fileName;
    }

    public InputStream createInputStream() {
        return new ByteArrayInputStream(this.bytes);
    }
}
