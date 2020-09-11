package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.meizu.media.camera.d.a */
public class CountedDataInputStream extends FilterInputStream {

    /* renamed from: a */
    public static ChangeQuickRedirect f9276a;

    /* renamed from: b */
    static final /* synthetic */ boolean f9277b = (!CountedDataInputStream.class.desiredAssertionStatus());

    /* renamed from: c */
    private int f9278c = 0;

    /* renamed from: d */
    private final byte[] f9279d = new byte[8];

    /* renamed from: e */
    private final ByteBuffer f9280e = ByteBuffer.wrap(this.f9279d);

    public CountedDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    public int mo19808a() {
        return this.f9278c;
    }

    public int read(byte[] bArr) throws IOException {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f9276a, false, 3790, new Class[]{byte[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int read = this.in.read(bArr);
        int i2 = this.f9278c;
        if (read >= 0) {
            i = read;
        }
        this.f9278c = i2 + i;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        Object[] objArr = {bArr, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9276a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3791, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int read = this.in.read(bArr, i, i2);
        int i4 = this.f9278c;
        if (read >= 0) {
            i3 = read;
        }
        this.f9278c = i4 + i3;
        return read;
    }

    public int read() throws IOException {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3792, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int read = this.in.read();
        int i2 = this.f9278c;
        if (read >= 0) {
            i = 1;
        }
        this.f9278c = i2 + i;
        return read;
    }

    public long skip(long j) throws IOException {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9276a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3793, new Class[]{Long.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        long skip = this.in.skip(j);
        this.f9278c = (int) (((long) this.f9278c) + skip);
        return skip;
    }

    /* renamed from: a */
    public void mo19810a(long j) throws IOException {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9276a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3794, new Class[]{Long.TYPE}, Void.TYPE).isSupported && skip(j) != j) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public void mo19815b(long j) throws IOException {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9276a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3795, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            long j2 = j - ((long) this.f9278c);
            if (f9277b || j2 >= 0) {
                mo19810a(j2);
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo19813a(byte[] bArr, int i, int i2) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f9276a, false, 3796, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && read(bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public void mo19812a(byte[] bArr) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f9276a, false, 3797, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            mo19813a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a */
    public void mo19811a(ByteOrder byteOrder) {
        if (!PatchProxy.proxy(new Object[]{byteOrder}, this, f9276a, false, 3798, new Class[]{ByteOrder.class}, Void.TYPE).isSupported) {
            this.f9280e.order(byteOrder);
        }
    }

    /* renamed from: b */
    public ByteOrder mo19814b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3799, new Class[0], ByteOrder.class);
        return proxy.isSupported ? (ByteOrder) proxy.result : this.f9280e.order();
    }

    /* renamed from: c */
    public short mo19816c() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3800, new Class[0], Short.TYPE);
        if (proxy.isSupported) {
            return ((Short) proxy.result).shortValue();
        }
        mo19813a(this.f9279d, 0, 2);
        this.f9280e.rewind();
        return this.f9280e.getShort();
    }

    /* renamed from: d */
    public int mo19817d() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3801, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo19816c() & 65535;
    }

    /* renamed from: e */
    public int mo19818e() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3802, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        mo19813a(this.f9279d, 0, 4);
        this.f9280e.rewind();
        return this.f9280e.getInt();
    }

    /* renamed from: f */
    public long mo19819f() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9276a, false, 3803, new Class[0], Long.TYPE);
        return proxy.isSupported ? ((Long) proxy.result).longValue() : ((long) mo19818e()) & 4294967295L;
    }

    /* renamed from: a */
    public String mo19809a(int i, Charset charset) throws IOException {
        Object[] objArr = {new Integer(i), charset};
        ChangeQuickRedirect changeQuickRedirect = f9276a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3806, new Class[]{Integer.TYPE, Charset.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        byte[] bArr = new byte[i];
        mo19812a(bArr);
        return new String(bArr, charset);
    }
}
