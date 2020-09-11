package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.loc.af */
public final class StrictLineReader implements Closeable {

    /* renamed from: a */
    private final InputStream f2552a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f2553b;

    /* renamed from: c */
    private byte[] f2554c;

    /* renamed from: d */
    private int f2555d;

    /* renamed from: e */
    private int f2556e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private StrictLineReader(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(Util.f2558a)) {
            this.f2552a = inputStream;
            this.f2553b = charset;
            this.f2554c = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    /* renamed from: b */
    private void m2990b() throws IOException {
        int read = this.f2552a.read(this.f2554c, 0, this.f2554c.length);
        if (read != -1) {
            this.f2555d = 0;
            this.f2556e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public final String mo12994a() throws IOException {
        int i;
        int i2;
        synchronized (this.f2552a) {
            if (this.f2554c != null) {
                if (this.f2555d >= this.f2556e) {
                    m2990b();
                }
                for (int i3 = this.f2555d; i3 != this.f2556e; i3++) {
                    if (this.f2554c[i3] == 10) {
                        if (i3 != this.f2555d) {
                            i2 = i3 - 1;
                            if (this.f2554c[i2] == 13) {
                                String str = new String(this.f2554c, this.f2555d, i2 - this.f2555d, this.f2553b.name());
                                this.f2555d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f2554c, this.f2555d, i2 - this.f2555d, this.f2553b.name());
                        this.f2555d = i3 + 1;
                        return str2;
                    }
                }
                C10481 r1 = new ByteArrayOutputStream((this.f2556e - this.f2555d) + 80) {
                    public final String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, StrictLineReader.this.f2553b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f2554c, this.f2555d, this.f2556e - this.f2555d);
                    this.f2556e = -1;
                    m2990b();
                    i = this.f2555d;
                    while (true) {
                        if (i != this.f2556e) {
                            if (this.f2554c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f2555d) {
                    r1.write(this.f2554c, this.f2555d, i - this.f2555d);
                }
                this.f2555d = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void close() throws IOException {
        synchronized (this.f2552a) {
            if (this.f2554c != null) {
                this.f2554c = null;
                this.f2552a.close();
            }
        }
    }
}
