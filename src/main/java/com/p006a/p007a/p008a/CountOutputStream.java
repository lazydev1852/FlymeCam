package com.p006a.p007a.p008a;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.a.a.a.c */
public final class CountOutputStream extends OutputStream {

    /* renamed from: a */
    private final OutputStream f50a;

    /* renamed from: b */
    private int f51b = 0;

    CountOutputStream(OutputStream outputStream) {
        this.f50a = outputStream;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f50a.write(bArr, i, i2);
        this.f51b += i2;
    }

    public void write(byte[] bArr) throws IOException {
        this.f50a.write(bArr);
        this.f51b += bArr.length;
    }

    public void write(int i) throws IOException {
        this.f50a.write(i);
        this.f51b++;
    }

    /* renamed from: a */
    public int mo7506a() {
        return this.f51b;
    }
}
