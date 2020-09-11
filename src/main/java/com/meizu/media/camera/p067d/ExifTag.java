package com.meizu.media.camera.p067d;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/* renamed from: com.meizu.media.camera.d.h */
public class ExifTag {

    /* renamed from: a */
    public static ChangeQuickRedirect f9462a;

    /* renamed from: b */
    private static Charset f9463b = Charset.forName("UTF-8");

    /* renamed from: c */
    private static final int[] f9464c = new int[11];

    /* renamed from: k */
    private static final SimpleDateFormat f9465k = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");

    /* renamed from: d */
    private final short f9466d;

    /* renamed from: e */
    private final short f9467e;

    /* renamed from: f */
    private boolean f9468f;

    /* renamed from: g */
    private int f9469g;

    /* renamed from: h */
    private int f9470h;

    /* renamed from: i */
    private Object f9471i = null;

    /* renamed from: j */
    private int f9472j;

    /* renamed from: a */
    public static boolean m9917a(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
    }

    /* renamed from: a */
    public static boolean m9918a(short s) {
        return s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 7 || s == 9 || s == 10;
    }

    /* renamed from: c */
    private static String m9923c(short s) {
        switch (s) {
            case 1:
                return "UNSIGNED_BYTE";
            case 2:
                return "UTF8";
            case 3:
                return "UNSIGNED_SHORT";
            case 4:
                return "UNSIGNED_LONG";
            case 5:
                return "UNSIGNED_RATIONAL";
            case 7:
                return "UNDEFINED";
            case 9:
                return "LONG";
            case 10:
                return "RATIONAL";
            default:
                return "";
        }
    }

    static {
        f9464c[1] = 1;
        f9464c[2] = 1;
        f9464c[3] = 2;
        f9464c[4] = 4;
        f9464c[5] = 8;
        f9464c[7] = 1;
        f9464c[9] = 4;
        f9464c[10] = 8;
    }

    ExifTag(short s, short s2, int i, int i2, boolean z) {
        this.f9466d = s;
        this.f9467e = s2;
        this.f9469g = i;
        this.f9468f = z;
        this.f9470h = i2;
    }

    /* renamed from: b */
    public static int m9919b(short s) {
        return f9464c[s];
    }

    /* renamed from: a */
    public int mo19907a() {
        return this.f9470h;
    }

    /* renamed from: b */
    public void mo19920b(int i) {
        this.f9470h = i;
    }

    /* renamed from: b */
    public short mo19919b() {
        return this.f9466d;
    }

    /* renamed from: c */
    public short mo19923c() {
        return this.f9467e;
    }

    /* renamed from: d */
    public int mo19925d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9462a, false, 3970, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo19927e() * m9919b(mo19923c());
    }

    /* renamed from: e */
    public int mo19927e() {
        return this.f9469g;
    }

    /* renamed from: c */
    public void mo19924c(int i) {
        this.f9469g = i;
    }

    /* renamed from: f */
    public boolean mo19931f() {
        return this.f9471i != null;
    }

    /* renamed from: a */
    public boolean mo19916a(int[] iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{iArr}, this, f9462a, false, 3971, new Class[]{int[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m9926h(iArr.length)) {
            return false;
        }
        if (this.f9467e != 3 && this.f9467e != 9 && this.f9467e != 4) {
            return false;
        }
        if (this.f9467e == 3 && m9920b(iArr)) {
            return false;
        }
        if (this.f9467e == 4 && m9924c(iArr)) {
            return false;
        }
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = (long) iArr[i];
        }
        this.f9471i = jArr;
        this.f9469g = iArr.length;
        return true;
    }

    /* renamed from: d */
    public boolean mo19926d(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9462a, false, 3972, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19916a(new int[]{i});
    }

    /* renamed from: a */
    public boolean mo19917a(long[] jArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jArr}, this, f9462a, false, 3973, new Class[]{long[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m9926h(jArr.length) || this.f9467e != 4 || m9921b(jArr)) {
            return false;
        }
        this.f9471i = jArr;
        this.f9469g = jArr.length;
        return true;
    }

    /* renamed from: a */
    public boolean mo19910a(long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f9462a, false, 3974, new Class[]{Long.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19917a(new long[]{j});
    }

    /* renamed from: a */
    public boolean mo19913a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f9462a, false, 3975, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f9467e != 2 && this.f9467e != 7) {
            return false;
        }
        byte[] bytes = str.getBytes(f9463b);
        if (bytes.length > 0) {
            if (!(bytes[bytes.length - 1] == 0 || this.f9467e == 7)) {
                bytes = Arrays.copyOf(bytes, bytes.length + 1);
            }
        } else if (this.f9467e == 2 && this.f9469g == 1) {
            bytes = new byte[]{0};
        }
        int length = bytes.length;
        if (m9926h(length)) {
            return false;
        }
        this.f9469g = length;
        this.f9471i = bytes;
        return true;
    }

    /* renamed from: a */
    public boolean mo19918a(Rational[] lVarArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{lVarArr}, this, f9462a, false, 3976, new Class[]{Rational[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m9926h(lVarArr.length)) {
            return false;
        }
        if (this.f9467e != 5 && this.f9467e != 10) {
            return false;
        }
        if (this.f9467e == 5 && m9922b(lVarArr)) {
            return false;
        }
        if (this.f9467e == 10 && m9925c(lVarArr)) {
            return false;
        }
        this.f9471i = lVarArr;
        this.f9469g = lVarArr.length;
        return true;
    }

    /* renamed from: a */
    public boolean mo19911a(Rational lVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{lVar}, this, f9462a, false, 3977, new Class[]{Rational.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19918a(new Rational[]{lVar});
    }

    /* renamed from: a */
    public boolean mo19915a(byte[] bArr, int i, int i2) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9462a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3978, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (m9926h(i2)) {
            return false;
        }
        if (this.f9467e != 1 && this.f9467e != 7) {
            return false;
        }
        this.f9471i = new byte[i2];
        System.arraycopy(bArr, i, this.f9471i, 0, i2);
        this.f9469g = i2;
        return true;
    }

    /* renamed from: a */
    public boolean mo19914a(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f9462a, false, 3979, new Class[]{byte[].class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo19915a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo19909a(byte b) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(b)}, this, f9462a, false, 3980, new Class[]{Byte.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19914a(new byte[]{b});
    }

    /* renamed from: a */
    public boolean mo19912a(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f9462a, false, 3981, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Short) {
            return mo19926d(((Short) obj).shortValue() & 65535);
        }
        if (obj instanceof String) {
            return mo19913a((String) obj);
        }
        if (obj instanceof int[]) {
            return mo19916a((int[]) obj);
        }
        if (obj instanceof long[]) {
            return mo19917a((long[]) obj);
        }
        if (obj instanceof Rational) {
            return mo19911a((Rational) obj);
        }
        if (obj instanceof Rational[]) {
            return mo19918a((Rational[]) obj);
        }
        if (obj instanceof byte[]) {
            return mo19914a((byte[]) obj);
        }
        if (obj instanceof Integer) {
            return mo19926d(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return mo19910a(((Long) obj).longValue());
        }
        if (obj instanceof Byte) {
            return mo19909a(((Byte) obj).byteValue());
        }
        if (obj instanceof Short[]) {
            Short[] shArr = (Short[]) obj;
            int[] iArr = new int[shArr.length];
            for (int i = 0; i < shArr.length; i++) {
                iArr[i] = shArr[i] == null ? 0 : shArr[i].shortValue() & 65535;
            }
            return mo19916a(iArr);
        } else if (obj instanceof Integer[]) {
            Integer[] numArr = (Integer[]) obj;
            int[] iArr2 = new int[numArr.length];
            for (int i2 = 0; i2 < numArr.length; i2++) {
                iArr2[i2] = numArr[i2] == null ? 0 : numArr[i2].intValue();
            }
            return mo19916a(iArr2);
        } else if (obj instanceof Long[]) {
            Long[] lArr = (Long[]) obj;
            long[] jArr = new long[lArr.length];
            for (int i3 = 0; i3 < lArr.length; i3++) {
                jArr[i3] = lArr[i3] == null ? 0 : lArr[i3].longValue();
            }
            return mo19917a(jArr);
        } else if (!(obj instanceof Byte[])) {
            return false;
        } else {
            Byte[] bArr = (Byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr2[i4] = bArr[i4] == null ? 0 : bArr[i4].byteValue();
            }
            return mo19914a(bArr2);
        }
    }

    /* renamed from: g */
    public Rational[] mo19933g() {
        if (this.f9471i instanceof Rational[]) {
            return (Rational[]) this.f9471i;
        }
        return new Rational[0];
    }

    /* renamed from: h */
    public int[] mo19934h() {
        if (this.f9471i == null) {
            return null;
        }
        if (!(this.f9471i instanceof long[])) {
            return new int[0];
        }
        long[] jArr = (long[]) this.f9471i;
        int[] iArr = new int[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            iArr[i] = (int) jArr[i];
        }
        return iArr;
    }

    /* renamed from: i */
    public Object mo19935i() {
        return this.f9471i;
    }

    /* renamed from: j */
    public String mo19936j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9462a, false, 3991, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f9471i == null) {
            return "";
        }
        if (this.f9471i instanceof byte[]) {
            if (this.f9467e == 2) {
                return new String((byte[]) this.f9471i, f9463b);
            }
            return Arrays.toString((byte[]) this.f9471i);
        } else if (this.f9471i instanceof long[]) {
            if (((long[]) this.f9471i).length == 1) {
                return String.valueOf(((long[]) this.f9471i)[0]);
            }
            return Arrays.toString((long[]) this.f9471i);
        } else if (!(this.f9471i instanceof Object[])) {
            return this.f9471i.toString();
        } else {
            if (((Object[]) this.f9471i).length != 1) {
                return Arrays.toString((Object[]) this.f9471i);
            }
            Object obj = ((Object[]) this.f9471i)[0];
            if (obj == null) {
                return "";
            }
            return obj.toString();
        }
    }

    /* renamed from: e */
    public long mo19928e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9462a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3992, new Class[]{Integer.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        if (this.f9471i instanceof long[]) {
            return ((long[]) this.f9471i)[i];
        }
        if (this.f9471i instanceof byte[]) {
            return (long) ((byte[]) this.f9471i)[i];
        }
        throw new IllegalArgumentException("Cannot get integer value from " + m9923c(this.f9467e));
    }

    /* renamed from: k */
    public byte[] mo19937k() {
        return (byte[]) this.f9471i;
    }

    /* renamed from: f */
    public Rational mo19930f(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9462a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3994, new Class[]{Integer.TYPE}, Rational.class);
        if (proxy.isSupported) {
            return (Rational) proxy.result;
        }
        if (this.f9467e == 10 || this.f9467e == 5) {
            return ((Rational[]) this.f9471i)[i];
        }
        throw new IllegalArgumentException("Cannot get RATIONAL value from " + m9923c(this.f9467e));
    }

    /* renamed from: b */
    public void mo19921b(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f9462a, false, 3995, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            mo19922b(bArr, 0, bArr.length);
        }
    }

    /* renamed from: b */
    public void mo19922b(byte[] bArr, int i, int i2) {
        Object[] objArr = {bArr, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9462a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3996, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f9467e == 7 || this.f9467e == 1) {
                Object obj = this.f9471i;
                if (i2 > this.f9469g) {
                    i2 = this.f9469g;
                }
                System.arraycopy(obj, 0, bArr, i, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot get BYTE value from " + m9923c(this.f9467e));
        }
    }

    /* renamed from: l */
    public int mo19938l() {
        return this.f9472j;
    }

    /* renamed from: g */
    public void mo19932g(int i) {
        this.f9472j = i;
    }

    /* renamed from: a */
    public void mo19908a(boolean z) {
        this.f9468f = z;
    }

    /* renamed from: m */
    public boolean mo19939m() {
        return this.f9468f;
    }

    /* renamed from: h */
    private boolean m9926h(int i) {
        return this.f9468f && this.f9469g != i;
    }

    /* renamed from: b */
    private boolean m9920b(int[] iArr) {
        for (int i : iArr) {
            if (i > 65535 || i < 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m9921b(long[] jArr) {
        for (long j : jArr) {
            if (j < 0 || j > 4294967295L) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m9924c(int[] iArr) {
        for (int i : iArr) {
            if (i < 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m9922b(Rational[] lVarArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{lVarArr}, this, f9462a, false, 3997, new Class[]{Rational[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (Rational lVar : lVarArr) {
            if (lVar.mo19954a() < 0 || lVar.mo19955b() < 0 || lVar.mo19954a() > 4294967295L || lVar.mo19955b() > 4294967295L) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m9925c(Rational[] lVarArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{lVarArr}, this, f9462a, false, 3998, new Class[]{Rational[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (Rational lVar : lVarArr) {
            if (lVar.mo19954a() < -2147483648L || lVar.mo19955b() < -2147483648L || lVar.mo19954a() > 2147483647L || lVar.mo19955b() > 2147483647L) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f9462a, false, 3999, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (obj == null || !(obj instanceof ExifTag)) {
            return false;
        }
        ExifTag hVar = (ExifTag) obj;
        if (hVar.f9466d != this.f9466d || hVar.f9469g != this.f9469g || hVar.f9467e != this.f9467e) {
            return false;
        }
        if (this.f9471i != null) {
            if (hVar.f9471i == null) {
                return false;
            }
            if (this.f9471i instanceof long[]) {
                if (!(hVar.f9471i instanceof long[])) {
                    return false;
                }
                return Arrays.equals((long[]) this.f9471i, (long[]) hVar.f9471i);
            } else if (this.f9471i instanceof Rational[]) {
                if (!(hVar.f9471i instanceof Rational[])) {
                    return false;
                }
                return Arrays.equals((Rational[]) this.f9471i, (Rational[]) hVar.f9471i);
            } else if (!(this.f9471i instanceof byte[])) {
                return this.f9471i.equals(hVar.f9471i);
            } else {
                if (!(hVar.f9471i instanceof byte[])) {
                    return false;
                }
                return Arrays.equals((byte[]) this.f9471i, (byte[]) hVar.f9471i);
            }
        } else if (hVar.f9471i == null) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9462a, false, 4000, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return String.format("tag id: %04X\n", new Object[]{Short.valueOf(this.f9466d)}) + "ifd id: " + this.f9470h + "\ntype: " + m9923c(this.f9467e) + "\ncount: " + this.f9469g + "\noffset: " + this.f9472j + "\nvalue: " + mo19936j() + "\n";
    }
}
