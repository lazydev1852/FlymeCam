package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.android.volley.toolbox.m */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a */
    private final ByteArrayPool f418a;

    public PoolingByteArrayOutputStream(ByteArrayPool dVar, int i) {
        this.f418a = dVar;
        this.buf = this.f418a.mo8728a(Math.max(i, 256));
    }

    public void close() throws IOException {
        this.f418a.mo8727a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f418a.mo8727a(this.buf);
    }

    /* renamed from: a */
    private void m721a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a = this.f418a.mo8728a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f418a.mo8727a(this.buf);
            this.buf = a;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m721a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        m721a(1);
        super.write(i);
    }
}
