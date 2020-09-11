package com.p006a.p007a.p008a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apaches.commons.codec.CharEncoding;

/* renamed from: com.a.a.a.b */
public class ByteBuffer {

    /* renamed from: a */
    private byte[] f47a;

    /* renamed from: b */
    private int f48b;

    /* renamed from: c */
    private String f49c;

    public ByteBuffer(int i) {
        this.f49c = null;
        this.f47a = new byte[i];
        this.f48b = 0;
    }

    public ByteBuffer(byte[] bArr) {
        this.f49c = null;
        this.f47a = bArr;
        this.f48b = bArr.length;
    }

    public ByteBuffer(InputStream inputStream) throws IOException {
        this.f49c = null;
        this.f48b = 0;
        this.f47a = new byte[16384];
        while (true) {
            int read = inputStream.read(this.f47a, this.f48b, 16384);
            if (read > 0) {
                this.f48b += read;
                if (read == 16384) {
                    m49b(this.f48b + 16384);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public InputStream mo7500a() {
        return new ByteArrayInputStream(this.f47a, 0, this.f48b);
    }

    /* renamed from: b */
    public int mo7504b() {
        return this.f48b;
    }

    /* renamed from: a */
    public int mo7499a(int i) {
        if (i < this.f48b) {
            return this.f47a[i] & 255;
        }
        throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
    }

    /* renamed from: a */
    public void mo7501a(byte b) {
        m49b(this.f48b + 1);
        byte[] bArr = this.f47a;
        int i = this.f48b;
        this.f48b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo7503a(byte[] bArr, int i, int i2) {
        m49b(this.f48b + i2);
        System.arraycopy(bArr, i, this.f47a, this.f48b, i2);
        this.f48b += i2;
    }

    /* renamed from: a */
    public void mo7502a(byte[] bArr) {
        mo7503a(bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public String mo7505c() {
        if (this.f49c == null) {
            if (this.f48b < 2) {
                this.f49c = "UTF-8";
            } else if (this.f47a[0] == 0) {
                if (this.f48b < 4 || this.f47a[1] != 0) {
                    this.f49c = CharEncoding.UTF_16BE;
                } else if ((this.f47a[2] & 255) == 254 && (this.f47a[3] & 255) == 255) {
                    this.f49c = "UTF-32BE";
                } else {
                    this.f49c = "UTF-32";
                }
            } else if ((this.f47a[0] & 255) < 128) {
                if (this.f47a[1] != 0) {
                    this.f49c = "UTF-8";
                } else if (this.f48b < 4 || this.f47a[2] != 0) {
                    this.f49c = CharEncoding.UTF_16LE;
                } else {
                    this.f49c = "UTF-32LE";
                }
            } else if ((this.f47a[0] & 255) == 239) {
                this.f49c = "UTF-8";
            } else if ((this.f47a[0] & 255) == 254) {
                this.f49c = "UTF-16";
            } else if (this.f48b < 4 || this.f47a[2] != 0) {
                this.f49c = "UTF-16";
            } else {
                this.f49c = "UTF-32";
            }
        }
        return this.f49c;
    }

    /* renamed from: b */
    private void m49b(int i) {
        if (i > this.f47a.length) {
            byte[] bArr = this.f47a;
            this.f47a = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, this.f47a, 0, bArr.length);
        }
    }
}
