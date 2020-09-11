package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.meizu.media.camera.d.e */
public class ExifOutputStream extends FilterOutputStream {

    /* renamed from: a */
    public static ChangeQuickRedirect f9419a;

    /* renamed from: b */
    private ExifData f9420b;

    /* renamed from: c */
    private int f9421c = 0;

    /* renamed from: d */
    private int f9422d;

    /* renamed from: e */
    private int f9423e;

    /* renamed from: f */
    private byte[] f9424f = new byte[1];

    /* renamed from: g */
    private ByteBuffer f9425g = ByteBuffer.allocate(4);

    /* renamed from: h */
    private final ExifInterface f9426h;

    public ExifOutputStream(OutputStream outputStream, ExifInterface cVar) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.f9426h = cVar;
    }

    /* renamed from: a */
    public void mo19884a(ExifData bVar) {
        this.f9420b = bVar;
    }

    /* renamed from: a */
    private int m9874a(int i, byte[] bArr, int i2, int i3) {
        Object[] objArr = {new Integer(i), bArr, new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f9419a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3928, new Class[]{Integer.TYPE, byte[].class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int position = i - this.f9425g.position();
        if (i3 <= position) {
            position = i3;
        }
        this.f9425g.put(bArr, i2, position);
        return position;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2)}, this, f9419a, false, 3929, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            while (true) {
                if ((this.f9422d > 0 || this.f9423e > 0 || this.f9421c != 2) && i2 > 0) {
                    if (this.f9422d > 0) {
                        int i3 = i2 > this.f9422d ? this.f9422d : i2;
                        i2 -= i3;
                        this.f9422d -= i3;
                        i += i3;
                    }
                    if (this.f9423e > 0) {
                        int i4 = i2 > this.f9423e ? this.f9423e : i2;
                        this.out.write(bArr, i, i4);
                        i2 -= i4;
                        this.f9423e -= i4;
                        i += i4;
                    }
                    if (i2 != 0) {
                        switch (this.f9421c) {
                            case 0:
                                int a = m9874a(2, bArr, i, i2);
                                i += a;
                                i2 -= a;
                                if (this.f9425g.position() >= 2) {
                                    this.f9425g.rewind();
                                    if (this.f9425g.getShort() == -40) {
                                        this.out.write(this.f9425g.array(), 0, 2);
                                        this.f9421c = 1;
                                        this.f9425g.rewind();
                                        m9876a();
                                        break;
                                    } else {
                                        throw new IOException("Not a valid jpeg image, cannot write exif");
                                    }
                                } else {
                                    return;
                                }
                            case 1:
                                int a2 = m9874a(4, bArr, i, i2);
                                i += a2;
                                i2 -= a2;
                                if (this.f9425g.position() == 2 && this.f9425g.getShort() == -39) {
                                    this.out.write(this.f9425g.array(), 0, 2);
                                    this.f9425g.rewind();
                                }
                                if (this.f9425g.position() >= 4) {
                                    this.f9425g.rewind();
                                    short s = this.f9425g.getShort();
                                    if (s == -31) {
                                        this.f9422d = (this.f9425g.getShort() & 65535) - 2;
                                        this.f9421c = 2;
                                    } else if (!JpegHeader.m9968a(s)) {
                                        this.out.write(this.f9425g.array(), 0, 4);
                                        this.f9423e = (this.f9425g.getShort() & 65535) - 2;
                                    } else {
                                        this.out.write(this.f9425g.array(), 0, 4);
                                        this.f9421c = 2;
                                    }
                                    this.f9425g.rewind();
                                    break;
                                } else {
                                    return;
                                }
                        }
                    } else {
                        return;
                    }
                }
            }
            if (i2 > 0) {
                this.out.write(bArr, i, i2);
            }
        }
    }

    public void write(int i) throws IOException {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9419a, false, 3930, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f9424f[0] = (byte) (i & 255);
            write(this.f9424f);
        }
    }

    public void write(byte[] bArr) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f9419a, false, 3931, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            write(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a */
    private void m9876a() throws IOException {
        if (!PatchProxy.proxy(new Object[0], this, f9419a, false, 3932, new Class[0], Void.TYPE).isSupported && this.f9420b != null) {
            ArrayList<ExifTag> b = m9880b(this.f9420b);
            m9881b();
            int c = m9883c() + 8;
            if (c <= 65535) {
                OrderedDataOutputStream kVar = new OrderedDataOutputStream(this.out);
                kVar.mo19952a(ByteOrder.BIG_ENDIAN);
                kVar.mo19953a(-31);
                kVar.mo19953a((short) c);
                kVar.mo19950a(1165519206);
                kVar.mo19953a(0);
                if (this.f9420b.mo19838e() == ByteOrder.BIG_ENDIAN) {
                    kVar.mo19953a(19789);
                } else {
                    kVar.mo19953a(18761);
                }
                kVar.mo19952a(this.f9420b.mo19838e());
                kVar.mo19953a(42);
                kVar.mo19950a(8);
                m9882b(kVar);
                m9879a(kVar);
                Iterator<ExifTag> it = b.iterator();
                while (it.hasNext()) {
                    this.f9420b.mo19824a(it.next());
                }
                return;
            }
            throw new IOException("Exif header is too large (>64Kb)");
        }
    }

    /* renamed from: b */
    private ArrayList<ExifTag> m9880b(ExifData bVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar}, this, f9419a, false, 3933, new Class[]{ExifData.class}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ExifTag> arrayList = new ArrayList<>();
        for (ExifTag next : bVar.mo19841g()) {
            if (next.mo19935i() == null && !ExifInterface.m9822a(next.mo19919b())) {
                bVar.mo19833b(next.mo19919b(), next.mo19907a());
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m9879a(OrderedDataOutputStream kVar) throws IOException {
        if (!PatchProxy.proxy(new Object[]{kVar}, this, f9419a, false, 3934, new Class[]{OrderedDataOutputStream.class}, Void.TYPE).isSupported) {
            if (this.f9420b.mo19834b()) {
                kVar.write(this.f9420b.mo19830a());
            } else if (this.f9420b.mo19837d()) {
                for (int i = 0; i < this.f9420b.mo19835c(); i++) {
                    kVar.write(this.f9420b.mo19831a(i));
                }
            }
        }
    }

    /* renamed from: b */
    private void m9882b(OrderedDataOutputStream kVar) throws IOException {
        if (!PatchProxy.proxy(new Object[]{kVar}, this, f9419a, false, 3935, new Class[]{OrderedDataOutputStream.class}, Void.TYPE).isSupported) {
            m9878a(this.f9420b.mo19832b(0), kVar);
            m9878a(this.f9420b.mo19832b(2), kVar);
            IfdData b = this.f9420b.mo19832b(3);
            if (b != null) {
                m9878a(b, kVar);
            }
            IfdData b2 = this.f9420b.mo19832b(4);
            if (b2 != null) {
                m9878a(b2, kVar);
            }
            if (this.f9420b.mo19832b(1) != null) {
                m9878a(this.f9420b.mo19832b(1), kVar);
            }
        }
    }

    /* renamed from: a */
    private void m9878a(IfdData iVar, OrderedDataOutputStream kVar) throws IOException {
        if (!PatchProxy.proxy(new Object[]{iVar, kVar}, this, f9419a, false, 3936, new Class[]{IfdData.class, OrderedDataOutputStream.class}, Void.TYPE).isSupported) {
            ExifTag[] b = iVar.mo19945b();
            kVar.mo19953a((short) b.length);
            for (ExifTag hVar : b) {
                kVar.mo19953a(hVar.mo19919b());
                kVar.mo19953a(hVar.mo19923c());
                kVar.mo19950a(hVar.mo19927e());
                if (hVar.mo19925d() > 4) {
                    kVar.mo19950a(hVar.mo19938l());
                } else {
                    m9877a(hVar, kVar);
                    int d = 4 - hVar.mo19925d();
                    for (int i = 0; i < d; i++) {
                        kVar.write(0);
                    }
                }
            }
            kVar.mo19950a(iVar.mo19948e());
            for (ExifTag hVar2 : b) {
                if (hVar2.mo19925d() > 4) {
                    m9877a(hVar2, kVar);
                }
            }
        }
    }

    /* renamed from: a */
    private int m9875a(IfdData iVar, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{iVar, new Integer(i)}, this, f9419a, false, 3937, new Class[]{IfdData.class, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int d = i + (iVar.mo19947d() * 12) + 2 + 4;
        for (ExifTag hVar : iVar.mo19945b()) {
            if (hVar.mo19925d() > 4) {
                hVar.mo19932g(d);
                d += hVar.mo19925d();
            }
        }
        return d;
    }

    /* renamed from: b */
    private void m9881b() throws IOException {
        if (!PatchProxy.proxy(new Object[0], this, f9419a, false, 3938, new Class[0], Void.TYPE).isSupported) {
            IfdData b = this.f9420b.mo19832b(0);
            if (b == null) {
                b = new IfdData(0);
                this.f9420b.mo19828a(b);
            }
            ExifTag j = this.f9426h.mo19882j(ExifInterface.f9292D);
            if (j != null) {
                b.mo19941a(j);
                IfdData b2 = this.f9420b.mo19832b(2);
                if (b2 == null) {
                    b2 = new IfdData(2);
                    this.f9420b.mo19828a(b2);
                }
                if (this.f9420b.mo19832b(4) != null) {
                    ExifTag j2 = this.f9426h.mo19882j(ExifInterface.f9293E);
                    if (j2 != null) {
                        b.mo19941a(j2);
                    } else {
                        throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9293E);
                    }
                }
                if (this.f9420b.mo19832b(3) != null) {
                    ExifTag j3 = this.f9426h.mo19882j(ExifInterface.f9355an);
                    if (j3 != null) {
                        b2.mo19941a(j3);
                    } else {
                        throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9355an);
                    }
                }
                IfdData b3 = this.f9420b.mo19832b(1);
                if (this.f9420b.mo19834b()) {
                    if (b3 == null) {
                        b3 = new IfdData(1);
                        this.f9420b.mo19828a(b3);
                    }
                    ExifTag j4 = this.f9426h.mo19882j(ExifInterface.f9294F);
                    if (j4 != null) {
                        b3.mo19941a(j4);
                        ExifTag j5 = this.f9426h.mo19882j(ExifInterface.f9295G);
                        if (j5 != null) {
                            j5.mo19926d(this.f9420b.mo19830a().length);
                            b3.mo19941a(j5);
                            b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9397j));
                            b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9401n));
                            return;
                        }
                        throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9295G);
                    }
                    throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9294F);
                } else if (this.f9420b.mo19837d()) {
                    if (b3 == null) {
                        b3 = new IfdData(1);
                        this.f9420b.mo19828a(b3);
                    }
                    int c = this.f9420b.mo19835c();
                    ExifTag j6 = this.f9426h.mo19882j(ExifInterface.f9397j);
                    if (j6 != null) {
                        ExifTag j7 = this.f9426h.mo19882j(ExifInterface.f9401n);
                        if (j7 != null) {
                            long[] jArr = new long[c];
                            for (int i = 0; i < this.f9420b.mo19835c(); i++) {
                                jArr[i] = (long) this.f9420b.mo19831a(i).length;
                            }
                            j7.mo19917a(jArr);
                            b3.mo19941a(j6);
                            b3.mo19941a(j7);
                            b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9294F));
                            b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9295G));
                            return;
                        }
                        throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9401n);
                    }
                    throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9397j);
                } else if (b3 != null) {
                    b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9397j));
                    b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9401n));
                    b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9294F));
                    b3.mo19944b(ExifInterface.m9820a(ExifInterface.f9295G));
                }
            } else {
                throw new IOException("No definition for crucial exif tag: " + ExifInterface.f9292D);
            }
        }
    }

    /* renamed from: c */
    private int m9883c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9419a, false, 3939, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        IfdData b = this.f9420b.mo19832b(0);
        int a = m9875a(b, 8);
        b.mo19942a(ExifInterface.m9820a(ExifInterface.f9292D)).mo19926d(a);
        IfdData b2 = this.f9420b.mo19832b(2);
        int a2 = m9875a(b2, a);
        IfdData b3 = this.f9420b.mo19832b(3);
        if (b3 != null) {
            b2.mo19942a(ExifInterface.m9820a(ExifInterface.f9355an)).mo19926d(a2);
            a2 = m9875a(b3, a2);
        }
        IfdData b4 = this.f9420b.mo19832b(4);
        if (b4 != null) {
            b.mo19942a(ExifInterface.m9820a(ExifInterface.f9293E)).mo19926d(a2);
            a2 = m9875a(b4, a2);
        }
        IfdData b5 = this.f9420b.mo19832b(1);
        if (b5 != null) {
            b.mo19943a(a2);
            a2 = m9875a(b5, a2);
        }
        if (this.f9420b.mo19834b()) {
            b5.mo19942a(ExifInterface.m9820a(ExifInterface.f9294F)).mo19926d(a2);
            return a2 + this.f9420b.mo19830a().length;
        } else if (!this.f9420b.mo19837d()) {
            return a2;
        } else {
            long[] jArr = new long[this.f9420b.mo19835c()];
            for (int i = 0; i < this.f9420b.mo19835c(); i++) {
                jArr[i] = (long) a2;
                a2 += this.f9420b.mo19831a(i).length;
            }
            b5.mo19942a(ExifInterface.m9820a(ExifInterface.f9397j)).mo19917a(jArr);
            return a2;
        }
    }

    /* renamed from: a */
    static void m9877a(ExifTag hVar, OrderedDataOutputStream kVar) throws IOException {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{hVar, kVar}, (Object) null, f9419a, true, 3940, new Class[]{ExifTag.class, OrderedDataOutputStream.class}, Void.TYPE).isSupported) {
            switch (hVar.mo19923c()) {
                case 1:
                case 7:
                    byte[] bArr = new byte[hVar.mo19927e()];
                    hVar.mo19921b(bArr);
                    kVar.write(bArr);
                    return;
                case 2:
                    byte[] k = hVar.mo19937k();
                    if (k.length == hVar.mo19927e()) {
                        k[k.length - 1] = 0;
                        kVar.write(k);
                        return;
                    }
                    kVar.write(k);
                    kVar.write(0);
                    return;
                case 3:
                    int e = hVar.mo19927e();
                    while (i < e) {
                        kVar.mo19953a((short) ((int) hVar.mo19928e(i)));
                        i++;
                    }
                    return;
                case 4:
                case 9:
                    int e2 = hVar.mo19927e();
                    while (i < e2) {
                        kVar.mo19950a((int) hVar.mo19928e(i));
                        i++;
                    }
                    return;
                case 5:
                case 10:
                    int e3 = hVar.mo19927e();
                    while (i < e3) {
                        kVar.mo19951a(hVar.mo19930f(i));
                        i++;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
