package com.meizu.media.camera.p067d;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.meizu.media.camera.d.f */
public class ExifParser {

    /* renamed from: a */
    public static ChangeQuickRedirect f9427a;

    /* renamed from: b */
    private static final Charset f9428b = Charset.forName("US-ASCII");

    /* renamed from: t */
    private static final short f9429t = ExifInterface.m9820a(ExifInterface.f9292D);

    /* renamed from: u */
    private static final short f9430u = ExifInterface.m9820a(ExifInterface.f9293E);

    /* renamed from: v */
    private static final short f9431v = ExifInterface.m9820a(ExifInterface.f9355an);

    /* renamed from: w */
    private static final short f9432w = ExifInterface.m9820a(ExifInterface.f9294F);

    /* renamed from: x */
    private static final short f9433x = ExifInterface.m9820a(ExifInterface.f9295G);

    /* renamed from: y */
    private static final short f9434y = ExifInterface.m9820a(ExifInterface.f9397j);

    /* renamed from: z */
    private static final short f9435z = ExifInterface.m9820a(ExifInterface.f9401n);

    /* renamed from: A */
    private final TreeMap<Integer, Object> f9436A = new TreeMap<>();

    /* renamed from: c */
    private final CountedDataInputStream f9437c;

    /* renamed from: d */
    private final int f9438d;

    /* renamed from: e */
    private int f9439e = 0;

    /* renamed from: f */
    private int f9440f = 0;

    /* renamed from: g */
    private int f9441g;

    /* renamed from: h */
    private ExifTag f9442h;

    /* renamed from: i */
    private C2034c f9443i;

    /* renamed from: j */
    private ExifTag f9444j;

    /* renamed from: k */
    private ExifTag f9445k;

    /* renamed from: l */
    private boolean f9446l;

    /* renamed from: m */
    private boolean f9447m = false;

    /* renamed from: n */
    private int f9448n;

    /* renamed from: o */
    private int f9449o = 0;

    /* renamed from: p */
    private byte[] f9450p;

    /* renamed from: q */
    private int f9451q;

    /* renamed from: r */
    private int f9452r;

    /* renamed from: s */
    private final ExifInterface f9453s;

    /* renamed from: b */
    private boolean m9891b(int i) {
        switch (i) {
            case 0:
                if ((this.f9438d & 1) != 0) {
                    return true;
                }
                return false;
            case 1:
                if ((this.f9438d & 2) != 0) {
                    return true;
                }
                return false;
            case 2:
                if ((this.f9438d & 4) != 0) {
                    return true;
                }
                return false;
            case 3:
                if ((this.f9438d & 16) != 0) {
                    return true;
                }
                return false;
            case 4:
                return (this.f9438d & 8) != 0;
            default:
                return false;
        }
    }

    /* renamed from: n */
    private boolean m9894n() {
        return (this.f9438d & 32) != 0;
    }

    private ExifParser(InputStream inputStream, int i, ExifInterface cVar) throws IOException, ExifInvalidFormatException {
        if (inputStream != null) {
            this.f9453s = cVar;
            this.f9447m = m9889a(inputStream);
            this.f9437c = new CountedDataInputStream(inputStream);
            this.f9438d = i;
            if (this.f9447m) {
                m9897q();
                long f = this.f9437c.mo19819f();
                if (f <= 2147483647L) {
                    int i2 = (int) f;
                    this.f9451q = i2;
                    this.f9441g = 0;
                    if (m9891b(0) || m9895o()) {
                        m9886a(0, f);
                        if (f != 8) {
                            this.f9450p = new byte[(i2 - 8)];
                            mo19889a(this.f9450p);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new ExifInvalidFormatException("Invalid offset " + f);
            }
            return;
        }
        throw new IOException("Null argument inputStream to ExifParser");
    }

    /* renamed from: a */
    public static ExifParser m9885a(InputStream inputStream, ExifInterface cVar) throws IOException, ExifInvalidFormatException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream, cVar}, (Object) null, f9427a, true, 3942, new Class[]{InputStream.class, ExifInterface.class}, ExifParser.class);
        return proxy.isSupported ? (ExifParser) proxy.result : new ExifParser(inputStream, 63, cVar);
    }

    /* renamed from: a */
    public int mo19888a() throws IOException, ExifInvalidFormatException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3943, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!this.f9447m) {
            return 5;
        }
        int a = this.f9437c.mo19808a();
        int i = this.f9439e + 2 + (this.f9440f * 12);
        if (a < i) {
            this.f9442h = m9896p();
            if (this.f9442h == null) {
                return mo19888a();
            }
            if (this.f9446l) {
                m9893c(this.f9442h);
            }
            return 1;
        }
        if (a == i) {
            if (this.f9441g == 0) {
                long i2 = mo19901i();
                if ((m9891b(1) || m9894n()) && i2 != 0) {
                    m9886a(1, i2);
                }
            } else {
                int intValue = this.f9436A.size() > 0 ? this.f9436A.firstEntry().getKey().intValue() - this.f9437c.mo19808a() : 4;
                if (intValue < 4) {
                    Log.w("ExifParser", "Invalid size of link to next IFD: " + intValue);
                } else {
                    long i3 = mo19901i();
                    if (i3 != 0) {
                        Log.w("ExifParser", "Invalid link to next IFD: " + i3);
                    }
                }
            }
        }
        while (this.f9436A.size() != 0) {
            Map.Entry<Integer, Object> pollFirstEntry = this.f9436A.pollFirstEntry();
            Object value = pollFirstEntry.getValue();
            try {
                m9892c(pollFirstEntry.getKey().intValue());
                if (value instanceof C2033b) {
                    C2033b bVar = (C2033b) value;
                    this.f9441g = bVar.f9456a;
                    this.f9440f = this.f9437c.mo19817d();
                    this.f9439e = pollFirstEntry.getKey().intValue();
                    if ((this.f9440f * 12) + this.f9439e + 2 > this.f9448n) {
                        Log.w("ExifParser", "Invalid size of IFD " + this.f9441g);
                        return 5;
                    }
                    this.f9446l = m9895o();
                    if (bVar.f9457b) {
                        return 0;
                    }
                    mo19893b();
                } else if (value instanceof C2034c) {
                    this.f9443i = (C2034c) value;
                    return this.f9443i.f9459b;
                } else {
                    C2032a aVar = (C2032a) value;
                    this.f9442h = aVar.f9454a;
                    if (this.f9442h.mo19923c() != 7) {
                        mo19894b(this.f9442h);
                        m9893c(this.f9442h);
                    }
                    if (aVar.f9455b) {
                        return 2;
                    }
                }
            } catch (IOException unused) {
                Log.w("ExifParser", "Failed to skip to data at: " + pollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be broken.");
            }
        }
        return 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r0 = (r8.f9439e + 2) + (r8.f9440f * 12);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19893b() throws java.io.IOException, com.meizu.media.camera.p067d.ExifInvalidFormatException {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9427a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3944(0xf68, float:5.527E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            int r0 = r8.f9439e
            int r0 = r0 + 2
            int r1 = r8.f9440f
            int r1 = r1 * 12
            int r0 = r0 + r1
            com.meizu.media.camera.d.a r1 = r8.f9437c
            int r1 = r1.mo19808a()
            if (r1 <= r0) goto L_0x0028
            return
        L_0x0028:
            boolean r2 = r8.f9446l
            if (r2 == 0) goto L_0x0041
        L_0x002c:
            if (r1 >= r0) goto L_0x0044
            com.meizu.media.camera.d.h r2 = r8.m9896p()
            r8.f9442h = r2
            int r1 = r1 + 12
            com.meizu.media.camera.d.h r2 = r8.f9442h
            if (r2 != 0) goto L_0x003b
            goto L_0x002c
        L_0x003b:
            com.meizu.media.camera.d.h r2 = r8.f9442h
            r8.m9893c((com.meizu.media.camera.p067d.ExifTag) r2)
            goto L_0x002c
        L_0x0041:
            r8.m9892c((int) r0)
        L_0x0044:
            long r0 = r8.mo19901i()
            int r2 = r8.f9441g
            if (r2 != 0) goto L_0x0062
            r2 = 1
            boolean r3 = r8.m9891b((int) r2)
            if (r3 != 0) goto L_0x0059
            boolean r3 = r8.m9894n()
            if (r3 == 0) goto L_0x0062
        L_0x0059:
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0062
            r8.m9886a((int) r2, (long) r0)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p067d.ExifParser.mo19893b():void");
    }

    /* renamed from: o */
    private boolean m9895o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3945, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        switch (this.f9441g) {
            case 0:
                if (m9891b(2) || m9891b(4) || m9891b(3) || m9891b(1)) {
                    return true;
                }
                return false;
            case 1:
                return m9894n();
            case 2:
                return m9891b(3);
            default:
                return false;
        }
    }

    /* renamed from: c */
    public ExifTag mo19895c() {
        return this.f9442h;
    }

    /* renamed from: d */
    public int mo19896d() {
        return this.f9441g;
    }

    /* renamed from: e */
    public int mo19897e() {
        return this.f9443i.f9458a;
    }

    /* renamed from: f */
    public int mo19898f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3946, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f9444j == null) {
            return 0;
        }
        return (int) this.f9444j.mo19928e(0);
    }

    /* renamed from: g */
    public int mo19899g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3947, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f9445k == null) {
            return 0;
        }
        return (int) this.f9445k.mo19928e(0);
    }

    /* renamed from: c */
    private void m9892c(int i) throws IOException {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9427a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3948, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f9437c.mo19815b((long) i);
            while (!this.f9436A.isEmpty() && this.f9436A.firstKey().intValue() < i) {
                this.f9436A.pollFirstEntry();
            }
        }
    }

    /* renamed from: a */
    public void mo19892a(ExifTag hVar) {
        if (!PatchProxy.proxy(new Object[]{hVar}, this, f9427a, false, 3949, new Class[]{ExifTag.class}, Void.TYPE).isSupported && hVar.mo19938l() >= this.f9437c.mo19808a()) {
            this.f9436A.put(Integer.valueOf(hVar.mo19938l()), new C2032a(hVar, true));
        }
    }

    /* renamed from: a */
    private void m9886a(int i, long j) {
        Object[] objArr = {new Integer(i), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9427a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3950, new Class[]{Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            this.f9436A.put(Integer.valueOf((int) j), new C2033b(i, m9891b(i)));
        }
    }

    /* renamed from: a */
    private void m9887a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9427a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3951, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            this.f9436A.put(Integer.valueOf((int) j), new C2034c(3));
        }
    }

    /* renamed from: b */
    private void m9890b(int i, long j) {
        Object[] objArr = {new Integer(i), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9427a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3952, new Class[]{Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            this.f9436A.put(Integer.valueOf((int) j), new C2034c(4, i));
        }
    }

    /* renamed from: p */
    private ExifTag m9896p() throws IOException, ExifInvalidFormatException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3953, new Class[0], ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        short c = this.f9437c.mo19816c();
        short c2 = this.f9437c.mo19816c();
        long f = this.f9437c.mo19819f();
        if (f > 2147483647L) {
            throw new ExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
        } else if (!ExifTag.m9918a(c2)) {
            Log.w("ExifParser", String.format("Tag %04x: Invalid data type %d", new Object[]{Short.valueOf(c), Short.valueOf(c2)}));
            this.f9437c.skip(4);
            return null;
        } else {
            int i = (int) f;
            ExifTag hVar = new ExifTag(c, c2, i, this.f9441g, i != 0);
            int d = hVar.mo19925d();
            if (d > 4) {
                long f2 = this.f9437c.mo19819f();
                if (f2 > 2147483647L) {
                    throw new ExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
                } else if (f2 >= ((long) this.f9451q) || c2 != 7) {
                    hVar.mo19932g((int) f2);
                } else {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f9450p, ((int) f2) - 8, bArr, 0, i);
                    hVar.mo19914a(bArr);
                }
            } else {
                boolean m = hVar.mo19939m();
                hVar.mo19908a(false);
                mo19894b(hVar);
                hVar.mo19908a(m);
                this.f9437c.skip((long) (4 - d));
                hVar.mo19932g(this.f9437c.mo19808a() - 4);
            }
            return hVar;
        }
    }

    /* renamed from: c */
    private void m9893c(ExifTag hVar) {
        if (!PatchProxy.proxy(new Object[]{hVar}, this, f9427a, false, 3954, new Class[]{ExifTag.class}, Void.TYPE).isSupported && hVar.mo19927e() != 0) {
            short b = hVar.mo19919b();
            int a = hVar.mo19907a();
            if (b != f9429t || !m9888a(a, ExifInterface.f9292D)) {
                if (b != f9430u || !m9888a(a, ExifInterface.f9293E)) {
                    if (b != f9431v || !m9888a(a, ExifInterface.f9355an)) {
                        if (b != f9432w || !m9888a(a, ExifInterface.f9294F)) {
                            if (b != f9433x || !m9888a(a, ExifInterface.f9295G)) {
                                if (b != f9434y || !m9888a(a, ExifInterface.f9397j)) {
                                    if (b == f9435z && m9888a(a, ExifInterface.f9401n) && m9894n() && hVar.mo19931f()) {
                                        this.f9444j = hVar;
                                    }
                                } else if (!m9894n()) {
                                } else {
                                    if (hVar.mo19931f()) {
                                        for (int i = 0; i < hVar.mo19927e(); i++) {
                                            if (hVar.mo19923c() == 3) {
                                                m9890b(i, hVar.mo19928e(i));
                                            } else {
                                                m9890b(i, hVar.mo19928e(i));
                                            }
                                        }
                                        return;
                                    }
                                    this.f9436A.put(Integer.valueOf(hVar.mo19938l()), new C2032a(hVar, false));
                                }
                            } else if (m9894n()) {
                                this.f9445k = hVar;
                            }
                        } else if (m9894n()) {
                            m9887a(hVar.mo19928e(0));
                        }
                    } else if (m9891b(3)) {
                        m9886a(3, hVar.mo19928e(0));
                    }
                } else if (m9891b(4)) {
                    m9886a(4, hVar.mo19928e(0));
                }
            } else if (m9891b(2) || m9891b(3)) {
                m9886a(2, hVar.mo19928e(0));
            }
        }
    }

    /* renamed from: a */
    private boolean m9888a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9427a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3955, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int i3 = this.f9453s.mo19872d().get(i2);
        if (i3 == 0) {
            return false;
        }
        return ExifInterface.m9827f(i3, i);
    }

    /* renamed from: b */
    public void mo19894b(ExifTag hVar) throws IOException {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{hVar}, this, f9427a, false, 3956, new Class[]{ExifTag.class}, Void.TYPE).isSupported) {
            short c = hVar.mo19923c();
            if (c == 2 || c == 7 || c == 1) {
                int e = hVar.mo19927e();
                if (this.f9436A.size() > 0 && this.f9436A.firstEntry().getKey().intValue() < this.f9437c.mo19808a() + e) {
                    Object value = this.f9436A.firstEntry().getValue();
                    if (value instanceof C2034c) {
                        Log.w("ExifParser", "Thumbnail overlaps value for tag: \n" + hVar.toString());
                        Map.Entry<Integer, Object> pollFirstEntry = this.f9436A.pollFirstEntry();
                        Log.w("ExifParser", "Invalid thumbnail offset: " + pollFirstEntry.getKey());
                    } else {
                        if (value instanceof C2033b) {
                            Log.w("ExifParser", "Ifd " + ((C2033b) value).f9456a + " overlaps value for tag: \n" + hVar.toString());
                        } else if (value instanceof C2032a) {
                            Log.w("ExifParser", "Tag value for tag: \n" + ((C2032a) value).f9454a.toString() + " overlaps value for tag: \n" + hVar.toString());
                        }
                        int intValue = this.f9436A.firstEntry().getKey().intValue() - this.f9437c.mo19808a();
                        Log.w("ExifParser", "Invalid size of tag: \n" + hVar.toString() + " setting count to: " + intValue);
                        hVar.mo19924c(intValue);
                    }
                }
            }
            switch (hVar.mo19923c()) {
                case 1:
                case 7:
                    byte[] bArr = new byte[hVar.mo19927e()];
                    mo19889a(bArr);
                    hVar.mo19914a(bArr);
                    return;
                case 2:
                    hVar.mo19913a(mo19890a(hVar.mo19927e()));
                    return;
                case 3:
                    int[] iArr = new int[hVar.mo19927e()];
                    int length = iArr.length;
                    while (i < length) {
                        iArr[i] = mo19900h();
                        i++;
                    }
                    hVar.mo19916a(iArr);
                    return;
                case 4:
                    long[] jArr = new long[hVar.mo19927e()];
                    int length2 = jArr.length;
                    while (i < length2) {
                        jArr[i] = mo19901i();
                        i++;
                    }
                    hVar.mo19917a(jArr);
                    return;
                case 5:
                    Rational[] lVarArr = new Rational[hVar.mo19927e()];
                    int length3 = lVarArr.length;
                    while (i < length3) {
                        lVarArr[i] = mo19902j();
                        i++;
                    }
                    hVar.mo19918a(lVarArr);
                    return;
                case 9:
                    int[] iArr2 = new int[hVar.mo19927e()];
                    int length4 = iArr2.length;
                    while (i < length4) {
                        iArr2[i] = mo19903k();
                        i++;
                    }
                    hVar.mo19916a(iArr2);
                    return;
                case 10:
                    Rational[] lVarArr2 = new Rational[hVar.mo19927e()];
                    int length5 = lVarArr2.length;
                    while (i < length5) {
                        lVarArr2[i] = mo19904l();
                        i++;
                    }
                    hVar.mo19918a(lVarArr2);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: q */
    private void m9897q() throws IOException, ExifInvalidFormatException {
        if (!PatchProxy.proxy(new Object[0], this, f9427a, false, 3957, new Class[0], Void.TYPE).isSupported) {
            short c = this.f9437c.mo19816c();
            if (18761 == c) {
                this.f9437c.mo19811a(ByteOrder.LITTLE_ENDIAN);
            } else if (19789 == c) {
                this.f9437c.mo19811a(ByteOrder.BIG_ENDIAN);
            } else {
                throw new ExifInvalidFormatException("Invalid TIFF header");
            }
            if (this.f9437c.mo19816c() != 42) {
                throw new ExifInvalidFormatException("Invalid TIFF header");
            }
        }
    }

    /* renamed from: a */
    private boolean m9889a(InputStream inputStream) throws IOException, ExifInvalidFormatException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, this, f9427a, false, 3958, new Class[]{InputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        CountedDataInputStream aVar = new CountedDataInputStream(inputStream);
        if (aVar.mo19816c() == -40) {
            short c = aVar.mo19816c();
            while (c != -39 && !JpegHeader.m9968a(c)) {
                int d = aVar.mo19817d();
                if (c == -31 && d >= 8) {
                    int e = aVar.mo19818e();
                    short c2 = aVar.mo19816c();
                    d -= 6;
                    if (e == 1165519206 && c2 == 0) {
                        this.f9452r = aVar.mo19808a();
                        this.f9448n = d;
                        this.f9449o = this.f9452r + this.f9448n;
                        return true;
                    }
                }
                if (d >= 2) {
                    long j = (long) (d - 2);
                    if (j == aVar.skip(j)) {
                        c = aVar.mo19816c();
                    }
                }
                Log.w("ExifParser", "Invalid JPEG format.");
                return false;
            }
            return false;
        }
        throw new ExifInvalidFormatException("Invalid JPEG format");
    }

    /* renamed from: a */
    public int mo19889a(byte[] bArr) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f9427a, false, 3960, new Class[]{byte[].class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9437c.read(bArr);
    }

    /* renamed from: a */
    public String mo19890a(int i) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9427a, false, 3961, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : mo19891a(i, f9428b);
    }

    /* renamed from: a */
    public String mo19891a(int i, Charset charset) throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), charset}, this, f9427a, false, 3962, new Class[]{Integer.TYPE, Charset.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return i > 0 ? this.f9437c.mo19809a(i, charset) : "";
    }

    /* renamed from: h */
    public int mo19900h() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3963, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9437c.mo19816c() & 65535;
    }

    /* renamed from: i */
    public long mo19901i() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3964, new Class[0], Long.TYPE);
        return proxy.isSupported ? ((Long) proxy.result).longValue() : ((long) mo19903k()) & 4294967295L;
    }

    /* renamed from: j */
    public Rational mo19902j() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3965, new Class[0], Rational.class);
        if (proxy.isSupported) {
            return (Rational) proxy.result;
        }
        return new Rational(mo19901i(), mo19901i());
    }

    /* renamed from: k */
    public int mo19903k() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3966, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9437c.mo19818e();
    }

    /* renamed from: l */
    public Rational mo19904l() throws IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3967, new Class[0], Rational.class);
        if (proxy.isSupported) {
            return (Rational) proxy.result;
        }
        return new Rational((long) mo19903k(), (long) mo19903k());
    }

    /* renamed from: com.meizu.media.camera.d.f$c */
    /* compiled from: ExifParser */
    private static class C2034c {

        /* renamed from: a */
        int f9458a;

        /* renamed from: b */
        int f9459b;

        C2034c(int i) {
            this.f9458a = 0;
            this.f9459b = i;
        }

        C2034c(int i, int i2) {
            this.f9459b = i;
            this.f9458a = i2;
        }
    }

    /* renamed from: com.meizu.media.camera.d.f$b */
    /* compiled from: ExifParser */
    private static class C2033b {

        /* renamed from: a */
        int f9456a;

        /* renamed from: b */
        boolean f9457b;

        C2033b(int i, boolean z) {
            this.f9456a = i;
            this.f9457b = z;
        }
    }

    /* renamed from: com.meizu.media.camera.d.f$a */
    /* compiled from: ExifParser */
    private static class C2032a {

        /* renamed from: a */
        ExifTag f9454a;

        /* renamed from: b */
        boolean f9455b;

        C2032a(ExifTag hVar, boolean z) {
            this.f9454a = hVar;
            this.f9455b = z;
        }
    }

    /* renamed from: m */
    public ByteOrder mo19905m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9427a, false, 3968, new Class[0], ByteOrder.class);
        return proxy.isSupported ? (ByteOrder) proxy.result : this.f9437c.mo19814b();
    }
}
