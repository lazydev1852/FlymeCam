package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.meizu.media.camera.d.k */
public class OrderedDataOutputStream extends FilterOutputStream {

    /* renamed from: a */
    public static ChangeQuickRedirect f9478a;

    /* renamed from: b */
    private final ByteBuffer f9479b = ByteBuffer.allocate(4);

    public OrderedDataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* renamed from: a */
    public OrderedDataOutputStream mo19952a(ByteOrder byteOrder) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{byteOrder}, this, f9478a, false, 4008, new Class[]{ByteOrder.class}, OrderedDataOutputStream.class);
        if (proxy.isSupported) {
            return (OrderedDataOutputStream) proxy.result;
        }
        this.f9479b.order(byteOrder);
        return this;
    }

    /* renamed from: a */
    public OrderedDataOutputStream mo19953a(short s) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Short(s)}, this, f9478a, false, 4009, new Class[]{Short.TYPE}, OrderedDataOutputStream.class);
        if (proxy.isSupported) {
            return (OrderedDataOutputStream) proxy.result;
        }
        this.f9479b.rewind();
        this.f9479b.putShort(s);
        this.out.write(this.f9479b.array(), 0, 2);
        return this;
    }

    /* renamed from: a */
    public OrderedDataOutputStream mo19950a(int i) throws IOException {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9478a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4010, new Class[]{Integer.TYPE}, OrderedDataOutputStream.class);
        if (proxy.isSupported) {
            return (OrderedDataOutputStream) proxy.result;
        }
        this.f9479b.rewind();
        this.f9479b.putInt(i);
        this.out.write(this.f9479b.array());
        return this;
    }

    /* renamed from: a */
    public OrderedDataOutputStream mo19951a(Rational lVar) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{lVar}, this, f9478a, false, 4011, new Class[]{Rational.class}, OrderedDataOutputStream.class);
        if (proxy.isSupported) {
            return (OrderedDataOutputStream) proxy.result;
        }
        mo19950a((int) lVar.mo19954a());
        mo19950a((int) lVar.mo19955b());
        return this;
    }
}
