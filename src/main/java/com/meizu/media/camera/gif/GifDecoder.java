package com.meizu.media.camera.gif;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.gif.a */
public class GifDecoder {

    /* renamed from: L */
    private static final LogUtil.C2630a f10201L = new LogUtil.C2630a("GifDecoder");

    /* renamed from: a */
    public static ChangeQuickRedirect f10202a;

    /* renamed from: A */
    protected int f10203A = 0;

    /* renamed from: B */
    protected int f10204B = 0;

    /* renamed from: C */
    protected boolean f10205C = false;

    /* renamed from: D */
    protected int f10206D = 0;

    /* renamed from: E */
    protected int f10207E;

    /* renamed from: F */
    protected short[] f10208F;

    /* renamed from: G */
    protected byte[] f10209G;

    /* renamed from: H */
    protected byte[] f10210H;

    /* renamed from: I */
    protected byte[] f10211I;

    /* renamed from: J */
    protected ArrayList<GifFrame> f10212J;

    /* renamed from: K */
    protected int f10213K;

    /* renamed from: M */
    private int f10214M;

    /* renamed from: N */
    private int f10215N;

    /* renamed from: O */
    private int f10216O;

    /* renamed from: P */
    private int f10217P;

    /* renamed from: Q */
    private int f10218Q = -1;

    /* renamed from: R */
    private ArrayList<Integer> f10219R;

    /* renamed from: b */
    protected BufferedInputStream f10220b;

    /* renamed from: c */
    protected int f10221c;

    /* renamed from: d */
    protected int f10222d;

    /* renamed from: e */
    protected int f10223e;

    /* renamed from: f */
    protected boolean f10224f;

    /* renamed from: g */
    protected int f10225g;

    /* renamed from: h */
    protected int f10226h = 1;

    /* renamed from: i */
    protected int[] f10227i;

    /* renamed from: j */
    protected int[] f10228j;

    /* renamed from: k */
    protected int[] f10229k;

    /* renamed from: l */
    protected int f10230l;

    /* renamed from: m */
    protected int f10231m;

    /* renamed from: n */
    protected int f10232n;

    /* renamed from: o */
    protected int f10233o;

    /* renamed from: p */
    protected boolean f10234p;

    /* renamed from: q */
    protected boolean f10235q;

    /* renamed from: r */
    protected int f10236r;

    /* renamed from: s */
    protected int f10237s;

    /* renamed from: t */
    protected int f10238t;

    /* renamed from: u */
    protected int f10239u;

    /* renamed from: v */
    protected int f10240v;

    /* renamed from: w */
    protected Bitmap f10241w;

    /* renamed from: x */
    protected Bitmap f10242x;

    /* renamed from: y */
    protected byte[] f10243y = new byte[256];

    /* renamed from: z */
    protected int f10244z = 0;

    /* renamed from: a */
    public int mo20167a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10202a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4144, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        this.f10206D = -1;
        if (i >= 0 && i < this.f10213K) {
            this.f10206D = this.f10212J.get(i).f10246b;
        }
        return this.f10206D;
    }

    /* renamed from: a */
    public int mo20166a() {
        return this.f10213K;
    }

    /* renamed from: b */
    public void mo20172b() {
        int i;
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4146, new Class[0], Void.TYPE).isSupported) {
            int[] iArr = new int[(this.f10222d * this.f10223e)];
            if (this.f10204B > 0) {
                if (this.f10204B == 3) {
                    int i3 = this.f10213K - 2;
                    if (i3 > 0) {
                        this.f10242x = mo20171b(i3 - 1);
                    } else {
                        this.f10242x = null;
                    }
                }
                if (this.f10242x != null) {
                    this.f10242x.getPixels(iArr, 0, this.f10222d, 0, 0, this.f10222d, this.f10223e);
                    if (this.f10204B == 2) {
                        int i4 = !this.f10205C ? this.f10232n : 0;
                        for (int i5 = 0; i5 < this.f10217P; i5++) {
                            int i6 = ((this.f10215N + i5) * this.f10222d) + this.f10214M;
                            int i7 = this.f10216O + i6;
                            while (i6 < i7) {
                                iArr[i6] = i4;
                                i6++;
                            }
                        }
                    }
                }
            }
            int i8 = 0;
            int i9 = 1;
            int i10 = 8;
            while (i2 < this.f10240v) {
                if (this.f10235q) {
                    if (i8 >= this.f10240v) {
                        i9++;
                        switch (i9) {
                            case 2:
                                i8 = 4;
                                break;
                            case 3:
                                i8 = 2;
                                i10 = 4;
                                break;
                            case 4:
                                i8 = 1;
                                i10 = 2;
                                break;
                        }
                    }
                    i = i8 + i10;
                } else {
                    i = i8;
                    i8 = i2;
                }
                int i11 = i8 + this.f10238t;
                if (i11 < this.f10223e) {
                    int i12 = i11 * this.f10222d;
                    int i13 = this.f10237s + i12;
                    int i14 = this.f10239u + i13;
                    if (this.f10222d + i12 < i14) {
                        i14 = this.f10222d + i12;
                    }
                    int i15 = this.f10239u * i2;
                    while (i13 < i14) {
                        int i16 = i15 + 1;
                        int i17 = this.f10229k[this.f10211I[i15] & 255];
                        if (i17 != 0) {
                            iArr[i13] = i17;
                        }
                        i13++;
                        i15 = i16;
                    }
                }
                i2++;
                i8 = i;
            }
            this.f10241w = Bitmap.createBitmap(iArr, this.f10222d, this.f10223e, Bitmap.Config.ARGB_4444);
        }
    }

    /* renamed from: b */
    public Bitmap mo20171b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10202a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4147, new Class[]{Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (i < 0 || i >= this.f10213K) {
            return null;
        }
        return this.f10212J.get(i).f10245a;
    }

    /* renamed from: a */
    public int mo20168a(BufferedInputStream bufferedInputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bufferedInputStream}, this, f10202a, false, 4148, new Class[]{BufferedInputStream.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        mo20176e();
        if (bufferedInputStream != null) {
            this.f10220b = bufferedInputStream;
            mo20181j();
            if (!mo20175d()) {
                mo20179h();
                if (this.f10213K < 0) {
                    this.f10221c = 1;
                }
            }
        } else {
            this.f10221c = 2;
        }
        try {
            bufferedInputStream.close();
        } catch (IOException unused) {
        }
        return this.f10221c;
    }

    /* renamed from: a */
    public int mo20169a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f10202a, false, 4150, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        this.f10221c = 0;
        try {
            this.f10220b = new BufferedInputStream(new FileInputStream(str));
            this.f10221c = mo20168a(this.f10220b);
        } catch (IOException unused) {
            this.f10221c = 2;
        }
        return this.f10221c;
    }

    /* renamed from: c */
    public void mo20173c() {
        int i;
        int i2;
        byte b;
        int i3;
        short s;
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4151, new Class[0], Void.TYPE).isSupported) {
            int i4 = this.f10239u * this.f10240v;
            if (this.f10211I == null || this.f10211I.length < i4) {
                this.f10211I = new byte[i4];
            }
            if (this.f10208F == null) {
                this.f10208F = new short[4096];
            }
            if (this.f10209G == null) {
                this.f10209G = new byte[4096];
            }
            if (this.f10210H == null) {
                this.f10210H = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
            }
            int f = mo20177f();
            int i5 = 1 << f;
            int i6 = i5 + 1;
            int i7 = i5 + 2;
            int i8 = f + 1;
            int i9 = (1 << i8) - 1;
            for (int i10 = 0; i10 < i5; i10++) {
                this.f10208F[i10] = 0;
                this.f10209G[i10] = (byte) i10;
            }
            int i11 = i8;
            int i12 = i7;
            int i13 = i9;
            byte b2 = -1;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            byte b3 = 0;
            while (i14 < i4) {
                if (i15 == 0) {
                    if (i16 >= i11) {
                        byte b4 = i18 & i13;
                        i18 >>= i11;
                        i16 -= i11;
                        if (b4 > i12 || b4 == i6) {
                            break;
                        } else if (b4 == i5) {
                            i11 = i8;
                            i12 = i7;
                            i13 = i9;
                            b2 = -1;
                        } else if (b2 == -1) {
                            this.f10210H[i15] = this.f10209G[b4];
                            b2 = b4;
                            b3 = b2;
                            i15++;
                            i8 = i8;
                        } else {
                            i2 = i8;
                            if (b4 == i12) {
                                i3 = i15 + 1;
                                b = b4;
                                this.f10210H[i15] = (byte) b3;
                                s = b2;
                            } else {
                                b = b4;
                                i3 = i15;
                                s = b;
                            }
                            while (s > i5) {
                                this.f10210H[i3] = this.f10209G[s];
                                s = this.f10208F[s];
                                i3++;
                                i5 = i5;
                            }
                            i = i5;
                            byte b5 = this.f10209G[s] & 255;
                            if (i12 >= 4096) {
                                i15 = i3 + 1;
                                b3 = b5;
                                i8 = i2;
                                i5 = i;
                            } else {
                                i15 = i3 + 1;
                                byte b6 = (byte) b5;
                                this.f10210H[i3] = b6;
                                this.f10208F[i12] = (short) b2;
                                this.f10209G[i12] = b6;
                                i12++;
                                if ((i12 & i13) == 0) {
                                    if (i12 < 4096) {
                                        i11++;
                                        i13 += i12;
                                    }
                                }
                                b3 = b5;
                                b2 = b;
                            }
                        }
                    } else {
                        if (i17 == 0) {
                            i17 = mo20178g();
                            if (i17 <= 0) {
                                break;
                            }
                            i19 = 0;
                        }
                        i18 += (this.f10243y[i19] & 255) << i16;
                        i16 += 8;
                        i19++;
                        i17--;
                    }
                } else {
                    i2 = i8;
                    i = i5;
                    byte b7 = b3;
                }
                i15--;
                this.f10211I[i20] = this.f10210H[i15];
                i14++;
                i20++;
                i8 = i2;
                i5 = i;
            }
            for (int i21 = i20; i21 < i4; i21++) {
                this.f10211I[i21] = 0;
            }
        }
    }

    /* renamed from: d */
    public boolean mo20175d() {
        return this.f10221c != 0;
    }

    /* renamed from: e */
    public void mo20176e() {
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4152, new Class[0], Void.TYPE).isSupported) {
            this.f10221c = 0;
            this.f10213K = 0;
            this.f10212J = new ArrayList<>();
            this.f10227i = null;
            this.f10228j = null;
            this.f10218Q = -1;
            this.f10219R = new ArrayList<>();
        }
    }

    /* renamed from: f */
    public int mo20177f() {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10202a, false, 4153, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        try {
            i = this.f10220b.read();
        } catch (IOException unused) {
            this.f10221c = 1;
        }
        this.f10218Q++;
        return i;
    }

    /* renamed from: g */
    public int mo20178g() {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10202a, false, 4154, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        this.f10244z = mo20177f();
        if (this.f10244z > 0) {
            while (i < this.f10244z) {
                try {
                    int read = this.f10220b.read(this.f10243y, i, this.f10244z - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (IOException unused) {
                }
            }
            if (i < this.f10244z) {
                this.f10221c = 1;
            }
        }
        this.f10218Q += i;
        return i;
    }

    /* renamed from: c */
    public int[] mo20174c(int i) {
        int i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10202a, false, 4155, new Class[]{Integer.TYPE}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.f10220b.read(bArr);
            try {
                this.f10218Q += i3;
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            i2 = 0;
        }
        if (i2 < i3) {
            this.f10221c = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                i4 = i7 + 1;
            }
        }
        return iArr;
    }

    /* renamed from: h */
    public void mo20179h() {
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4156, new Class[0], Void.TYPE).isSupported) {
            boolean z = false;
            while (!z && !mo20175d()) {
                int f = mo20177f();
                if (f != 0) {
                    if (f == 33) {
                        int f2 = mo20177f();
                        if (f2 == 249) {
                            this.f10219R.add(Integer.valueOf(this.f10218Q - 1));
                            mo20180i();
                        } else if (f2 != 255) {
                            mo20187p();
                        } else {
                            mo20178g();
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < 11; i++) {
                                sb.append((char) this.f10243y[i]);
                            }
                            if (sb.toString().equals("NETSCAPE2.0")) {
                                mo20184m();
                            } else {
                                mo20187p();
                            }
                        }
                    } else if (f == 44) {
                        mo20182k();
                    } else if (f != 59) {
                        this.f10221c = 1;
                    } else {
                        this.f10219R.add(Integer.valueOf(this.f10218Q));
                        z = true;
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public void mo20180i() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4157, new Class[0], Void.TYPE).isSupported) {
            mo20177f();
            int f = mo20177f();
            this.f10203A = (f & 28) >> 2;
            if (this.f10203A == 0) {
                this.f10203A = 1;
            }
            if ((f & 1) != 0) {
                z = true;
            }
            this.f10205C = z;
            this.f10206D = mo20185n() * 10;
            this.f10207E = mo20177f();
            mo20177f();
        }
    }

    /* renamed from: j */
    public void mo20181j() {
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4158, new Class[0], Void.TYPE).isSupported) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((char) mo20177f());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.f10221c = 1;
                return;
            }
            mo20183l();
            if (this.f10224f && !mo20175d()) {
                this.f10227i = mo20174c(this.f10225g);
                this.f10231m = this.f10227i[this.f10230l];
            }
        }
    }

    /* renamed from: k */
    public void mo20182k() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4159, new Class[0], Void.TYPE).isSupported) {
            this.f10237s = mo20185n();
            this.f10238t = mo20185n();
            this.f10239u = mo20185n();
            this.f10240v = mo20185n();
            int f = mo20177f();
            this.f10234p = (f & 128) != 0;
            this.f10235q = (f & 64) != 0;
            this.f10236r = 2 << (f & 7);
            if (this.f10234p) {
                this.f10228j = mo20174c(this.f10236r);
                this.f10229k = this.f10228j;
            } else {
                this.f10229k = this.f10227i;
                if (this.f10230l == this.f10207E) {
                    this.f10231m = 0;
                }
            }
            if (this.f10205C) {
                int i2 = this.f10229k[this.f10207E];
                this.f10229k[this.f10207E] = 0;
                i = i2;
            }
            if (this.f10229k == null) {
                this.f10221c = 1;
            }
            if (!mo20175d()) {
                mo20173c();
                mo20187p();
                if (!mo20175d()) {
                    this.f10213K++;
                    this.f10241w = Bitmap.createBitmap(this.f10222d, this.f10223e, Bitmap.Config.ARGB_4444);
                    mo20172b();
                    this.f10212J.add(new GifFrame(this.f10241w, this.f10206D));
                    if (this.f10205C) {
                        this.f10229k[this.f10207E] = i;
                    }
                    mo20186o();
                }
            }
        }
    }

    /* renamed from: l */
    public void mo20183l() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4160, new Class[0], Void.TYPE).isSupported) {
            this.f10222d = mo20185n();
            this.f10223e = mo20185n();
            int f = mo20177f();
            if ((f & 128) != 0) {
                z = true;
            }
            this.f10224f = z;
            this.f10225g = 2 << (f & 7);
            this.f10230l = mo20177f();
            this.f10233o = mo20177f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0020  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20184m() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f10202a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4161(0x1041, float:5.831E-42)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            r8.mo20178g()
            byte[] r1 = r8.f10243y
            byte r1 = r1[r0]
            r2 = 1
            if (r1 != r2) goto L_0x0032
            byte[] r1 = r8.f10243y
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r2 = r8.f10243y
            r3 = 2
            byte r2 = r2[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r1 = r1 | r2
            r8.f10226h = r1
        L_0x0032:
            int r1 = r8.f10244z
            if (r1 <= 0) goto L_0x003c
            boolean r1 = r8.mo20175d()
            if (r1 == 0) goto L_0x0016
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.gif.GifDecoder.mo20184m():void");
    }

    /* renamed from: n */
    public int mo20185n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10202a, false, 4162, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo20177f() | (mo20177f() << 8);
    }

    /* renamed from: o */
    public void mo20186o() {
        this.f10204B = this.f10203A;
        this.f10214M = this.f10237s;
        this.f10215N = this.f10238t;
        this.f10216O = this.f10239u;
        this.f10217P = this.f10240v;
        this.f10242x = this.f10241w;
        this.f10232n = this.f10231m;
        this.f10203A = 0;
        this.f10205C = false;
        this.f10206D = 0;
        this.f10228j = null;
    }

    /* renamed from: p */
    public void mo20187p() {
        if (!PatchProxy.proxy(new Object[0], this, f10202a, false, 4163, new Class[0], Void.TYPE).isSupported) {
            do {
                mo20178g();
                if (this.f10244z <= 0 || mo20175d()) {
                }
                mo20178g();
                return;
            } while (mo20175d());
        }
    }

    /* renamed from: a */
    public void mo20170a(String str, String str2, int i, int i2) {
        int i3 = 0;
        Object[] objArr = {str, str2, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10202a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4164, new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            Point point = new Point(this.f10219R.get(0).intValue(), this.f10219R.get(i).intValue() - 1);
            Point point2 = new Point(this.f10219R.get(i2).intValue(), this.f10219R.get(this.f10213K).intValue() - 1);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bArr = new byte[1];
                while (bufferedInputStream.read(bArr) != -1) {
                    if (!m10457a(i3, point)) {
                        if (!m10457a(i3, point2)) {
                            i3++;
                            bufferedOutputStream.write(bArr);
                        }
                    }
                    i3++;
                }
                bufferedOutputStream.flush();
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (Exception e) {
                LogUtil.C2630a aVar = f10201L;
                LogUtil.m15949b(aVar, "" + Log.getStackTraceString(e));
            }
        }
    }

    /* renamed from: a */
    private boolean m10457a(int i, Point point) {
        return i >= point.x && i <= point.y;
    }
}
