package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.meizu.media.camera.util.ag */
public class MzDataInputStream extends FilterInputStream {

    /* renamed from: a */
    public static ChangeQuickRedirect f14090a;

    /* renamed from: b */
    private final byte[] f14091b = new byte[8];

    /* renamed from: c */
    private final ByteBuffer f14092c = ByteBuffer.wrap(this.f14091b);

    public MzDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
        super(inputStream);
        this.f14092c.order(byteOrder);
    }

    public final int read(byte[] bArr) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f14090a, false, 8141, new Class[]{byte[].class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : super.read(bArr);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f14090a, false, 8142, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.in.read(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo22665a(byte[] bArr, int i, int i2) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f14090a, false, 8143, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && read(bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public int mo22664a() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14090a, false, 8149, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        mo22665a(this.f14091b, 0, 4);
        this.f14092c.rewind();
        return this.f14092c.getInt();
    }

    /* renamed from: b */
    public long mo22666b() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14090a, false, 8150, new Class[0], Long.TYPE);
        return proxy.isSupported ? ((Long) proxy.result).longValue() : ((long) mo22664a()) & 4294967295L;
    }
}
