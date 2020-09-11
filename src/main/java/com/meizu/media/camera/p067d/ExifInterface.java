package com.meizu.media.camera.p067d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.p005os.EnvironmentCompat;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;

/* renamed from: com.meizu.media.camera.d.c */
public class ExifInterface {

    /* renamed from: A */
    public static final int f9289A = m9818a(0, 531);

    /* renamed from: B */
    public static final int f9290B = m9818a(0, 532);

    /* renamed from: C */
    public static final int f9291C = m9818a(0, -32104);

    /* renamed from: D */
    public static final int f9292D = m9818a(0, -30871);

    /* renamed from: E */
    public static final int f9293E = m9818a(0, -30683);

    /* renamed from: F */
    public static final int f9294F = m9818a(1, 513);

    /* renamed from: G */
    public static final int f9295G = m9818a(1, 514);

    /* renamed from: H */
    public static final int f9296H = m9818a(2, -32102);

    /* renamed from: I */
    public static final int f9297I = m9818a(2, -32099);

    /* renamed from: J */
    public static final int f9298J = m9818a(2, -30686);

    /* renamed from: K */
    public static final int f9299K = m9818a(2, -30684);

    /* renamed from: L */
    public static final int f9300L = m9818a(2, -30681);

    /* renamed from: M */
    public static final int f9301M = m9818a(2, -30680);

    /* renamed from: N */
    public static final int f9302N = m9818a(2, -28672);

    /* renamed from: O */
    public static final int f9303O = m9818a(2, -28669);

    /* renamed from: P */
    public static final int f9304P = m9818a(2, -28668);

    /* renamed from: Q */
    public static final int f9305Q = m9818a(2, -28415);

    /* renamed from: R */
    public static final int f9306R = m9818a(2, -28414);

    /* renamed from: S */
    public static final int f9307S = m9818a(2, -28159);

    /* renamed from: T */
    public static final int f9308T = m9818a(2, -28158);

    /* renamed from: U */
    public static final int f9309U = m9818a(2, -28157);

    /* renamed from: V */
    public static final int f9310V = m9818a(2, -28156);

    /* renamed from: W */
    public static final int f9311W = m9818a(2, -28155);

    /* renamed from: X */
    public static final int f9312X = m9818a(2, -28154);

    /* renamed from: Y */
    public static final int f9313Y = m9818a(2, -28153);

    /* renamed from: Z */
    public static final int f9314Z = m9818a(2, -28152);

    /* renamed from: a */
    public static ChangeQuickRedirect f9315a;

    /* renamed from: aA */
    public static final int f9316aA = m9818a(2, -23550);

    /* renamed from: aB */
    public static final int f9317aB = m9818a(2, -23549);

    /* renamed from: aC */
    public static final int f9318aC = m9818a(2, -23548);

    /* renamed from: aD */
    public static final int f9319aD = m9818a(2, -23547);

    /* renamed from: aE */
    public static final int f9320aE = m9818a(2, -23546);

    /* renamed from: aF */
    public static final int f9321aF = m9818a(2, -23545);

    /* renamed from: aG */
    public static final int f9322aG = m9818a(2, -23544);

    /* renamed from: aH */
    public static final int f9323aH = m9818a(2, -23543);

    /* renamed from: aI */
    public static final int f9324aI = m9818a(2, -23542);

    /* renamed from: aJ */
    public static final int f9325aJ = m9818a(2, -23541);

    /* renamed from: aK */
    public static final int f9326aK = m9818a(2, -23540);

    /* renamed from: aL */
    public static final int f9327aL = m9818a(2, -23520);

    /* renamed from: aM */
    public static final int f9328aM = m9818a(4, 0);

    /* renamed from: aN */
    public static final int f9329aN = m9818a(4, 1);

    /* renamed from: aO */
    public static final int f9330aO = m9818a(4, 2);

    /* renamed from: aP */
    public static final int f9331aP = m9818a(4, 3);

    /* renamed from: aQ */
    public static final int f9332aQ = m9818a(4, 4);

    /* renamed from: aR */
    public static final int f9333aR = m9818a(4, 5);

    /* renamed from: aS */
    public static final int f9334aS = m9818a(4, 6);

    /* renamed from: aT */
    public static final int f9335aT = m9818a(4, 7);

    /* renamed from: aU */
    public static final int f9336aU = m9818a(4, 8);

    /* renamed from: aV */
    public static final int f9337aV = m9818a(4, 9);

    /* renamed from: aW */
    public static final int f9338aW = m9818a(4, 10);

    /* renamed from: aX */
    public static final int f9339aX = m9818a(4, 11);

    /* renamed from: aY */
    public static final int f9340aY = m9818a(4, 12);

    /* renamed from: aZ */
    public static final int f9341aZ = m9818a(4, 13);

    /* renamed from: aa */
    public static final int f9342aa = m9818a(2, -28151);

    /* renamed from: ab */
    public static final int f9343ab = m9818a(2, -28150);

    /* renamed from: ac */
    public static final int f9344ac = m9818a(2, -28140);

    /* renamed from: ad */
    public static final int f9345ad = m9818a(2, -28036);

    /* renamed from: ae */
    public static final int f9346ae = m9818a(2, -28026);

    /* renamed from: af */
    public static final int f9347af = m9818a(2, -28016);

    /* renamed from: ag */
    public static final int f9348ag = m9818a(2, -28015);

    /* renamed from: ah */
    public static final int f9349ah = m9818a(2, -28014);

    /* renamed from: ai */
    public static final int f9350ai = m9818a(2, -24576);

    /* renamed from: aj */
    public static final int f9351aj = m9818a(2, -24575);

    /* renamed from: ak */
    public static final int f9352ak = m9818a(2, -24574);

    /* renamed from: al */
    public static final int f9353al = m9818a(2, -24573);

    /* renamed from: am */
    public static final int f9354am = m9818a(2, -24572);

    /* renamed from: an */
    public static final int f9355an = m9818a(2, -24571);

    /* renamed from: ao */
    public static final int f9356ao = m9818a(2, -24053);

    /* renamed from: ap */
    public static final int f9357ap = m9818a(2, -24052);

    /* renamed from: aq */
    public static final int f9358aq = m9818a(2, -24050);

    /* renamed from: ar */
    public static final int f9359ar = m9818a(2, -24049);

    /* renamed from: as */
    public static final int f9360as = m9818a(2, -24048);

    /* renamed from: at */
    public static final int f9361at = m9818a(2, -24044);

    /* renamed from: au */
    public static final int f9362au = m9818a(2, -24043);

    /* renamed from: av */
    public static final int f9363av = m9818a(2, -24041);

    /* renamed from: aw */
    public static final int f9364aw = m9818a(2, -23808);

    /* renamed from: ax */
    public static final int f9365ax = m9818a(2, -23807);

    /* renamed from: ay */
    public static final int f9366ay = m9818a(2, -23806);

    /* renamed from: az */
    public static final int f9367az = m9818a(2, -23551);

    /* renamed from: b */
    public static final int f9368b = m9818a(0, 256);

    /* renamed from: ba */
    public static final int f9369ba = m9818a(4, 14);

    /* renamed from: bb */
    public static final int f9370bb = m9818a(4, 15);

    /* renamed from: bc */
    public static final int f9371bc = m9818a(4, 16);

    /* renamed from: bd */
    public static final int f9372bd = m9818a(4, 17);

    /* renamed from: be */
    public static final int f9373be = m9818a(4, 18);

    /* renamed from: bf */
    public static final int f9374bf = m9818a(4, 19);

    /* renamed from: bg */
    public static final int f9375bg = m9818a(4, 20);

    /* renamed from: bh */
    public static final int f9376bh = m9818a(4, 21);

    /* renamed from: bi */
    public static final int f9377bi = m9818a(4, 22);

    /* renamed from: bj */
    public static final int f9378bj = m9818a(4, 23);

    /* renamed from: bk */
    public static final int f9379bk = m9818a(4, 24);

    /* renamed from: bl */
    public static final int f9380bl = m9818a(4, 25);

    /* renamed from: bm */
    public static final int f9381bm = m9818a(4, 26);

    /* renamed from: bn */
    public static final int f9382bn = m9818a(4, 27);

    /* renamed from: bo */
    public static final int f9383bo = m9818a(4, 28);

    /* renamed from: bp */
    public static final int f9384bp = m9818a(4, 29);

    /* renamed from: bq */
    public static final int f9385bq = m9818a(4, 30);

    /* renamed from: br */
    public static final int f9386br = m9818a(3, 1);

    /* renamed from: bs */
    protected static HashSet<Short> f9387bs = new HashSet<>(f9389bu);

    /* renamed from: bt */
    public static final ByteOrder f9388bt = ByteOrder.BIG_ENDIAN;

    /* renamed from: bu */
    private static HashSet<Short> f9389bu = new HashSet<>();

    /* renamed from: c */
    public static final int f9390c = m9818a(0, 257);

    /* renamed from: d */
    public static final int f9391d = m9818a(0, 258);

    /* renamed from: e */
    public static final int f9392e = m9818a(0, 259);

    /* renamed from: f */
    public static final int f9393f = m9818a(0, 262);

    /* renamed from: g */
    public static final int f9394g = m9818a(0, 270);

    /* renamed from: h */
    public static final int f9395h = m9818a(0, 271);

    /* renamed from: i */
    public static final int f9396i = m9818a(0, 272);

    /* renamed from: j */
    public static final int f9397j = m9818a(0, 273);

    /* renamed from: k */
    public static final int f9398k = m9818a(0, 274);

    /* renamed from: l */
    public static final int f9399l = m9818a(0, 277);

    /* renamed from: m */
    public static final int f9400m = m9818a(0, 278);

    /* renamed from: n */
    public static final int f9401n = m9818a(0, 279);

    /* renamed from: o */
    public static final int f9402o = m9818a(0, 282);

    /* renamed from: p */
    public static final int f9403p = m9818a(0, 283);

    /* renamed from: q */
    public static final int f9404q = m9818a(0, 284);

    /* renamed from: r */
    public static final int f9405r = m9818a(0, 296);

    /* renamed from: s */
    public static final int f9406s = m9818a(0, 301);

    /* renamed from: t */
    public static final int f9407t = m9818a(0, 305);

    /* renamed from: u */
    public static final int f9408u = m9818a(0, 306);

    /* renamed from: v */
    public static final int f9409v = m9818a(0, 315);

    /* renamed from: w */
    public static final int f9410w = m9818a(0, 318);

    /* renamed from: x */
    public static final int f9411x = m9818a(0, 319);

    /* renamed from: y */
    public static final int f9412y = m9818a(0, 529);

    /* renamed from: z */
    public static final int f9413z = m9818a(0, 530);

    /* renamed from: bv */
    private ExifData f9414bv = new ExifData(f9388bt);

    /* renamed from: bw */
    private final DateFormat f9415bw = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    /* renamed from: bx */
    private final DateFormat f9416bx = new SimpleDateFormat("yyyy:MM:dd");

    /* renamed from: by */
    private final Calendar f9417by = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    /* renamed from: bz */
    private SparseIntArray f9418bz = null;

    /* renamed from: a */
    public static int m9818a(int i, short s) {
        return (i << 16) | (s & 65535);
    }

    /* renamed from: a */
    public static short m9820a(int i) {
        return (short) i;
    }

    /* renamed from: b */
    public static int m9824b(int i) {
        return i >>> 16;
    }

    /* renamed from: b */
    public static int m9825b(short s) {
        if (s == 1) {
            return 0;
        }
        if (s == 3) {
            return 180;
        }
        if (s != 6) {
            return s != 8 ? 0 : 270;
        }
        return 90;
    }

    /* renamed from: l */
    public static int m9829l(int i) {
        return i >>> 24;
    }

    /* renamed from: m */
    public static short m9830m(int i) {
        return (short) ((i >> 16) & 255);
    }

    /* renamed from: n */
    public static int m9831n(int i) {
        return i & 65535;
    }

    static {
        f9389bu.add(Short.valueOf(m9820a(f9293E)));
        f9389bu.add(Short.valueOf(m9820a(f9292D)));
        f9389bu.add(Short.valueOf(m9820a(f9294F)));
        f9389bu.add(Short.valueOf(m9820a(f9355an)));
        f9389bu.add(Short.valueOf(m9820a(f9397j)));
        f9387bs.add(Short.valueOf(m9820a(-1)));
        f9387bs.add(Short.valueOf(m9820a(f9295G)));
        f9387bs.add(Short.valueOf(m9820a(f9401n)));
    }

    /* renamed from: a */
    public void mo19853a(boolean z) {
        ExifTag hVar;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9315a, false, 3825, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                hVar = mo19845a(f9342aa, (Object) (short) 1);
            } else {
                hVar = mo19845a(f9342aa, (Object) (short) 0);
            }
            if (hVar != null) {
                mo19846a(hVar);
            }
        }
    }

    /* renamed from: a */
    public void mo19850a(Rational lVar, float f) {
        ExifTag a;
        if (!PatchProxy.proxy(new Object[]{lVar, new Float(f)}, this, f9315a, false, 3826, new Class[]{Rational.class, Float.TYPE}, Void.TYPE).isSupported) {
            ExifTag a2 = mo19845a(f9343ab, (Object) lVar);
            if (a2 != null) {
                mo19846a(a2);
            }
            if (DeviceHelper.f14020dl != null && (a = mo19845a(f9319aD, (Object) Short.valueOf((short) ((int) (lVar.mo19956c() * ((double) f)))))) != null) {
                mo19846a(a);
            }
        }
    }

    /* renamed from: c */
    public void mo19870c(int i) {
        ExifTag hVar;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9315a, false, 3827, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == 1) {
                hVar = mo19845a(f9317aB, (Object) (short) 0);
            } else {
                hVar = mo19845a(f9317aB, (Object) (short) 1);
            }
            if (hVar != null) {
                mo19846a(hVar);
            }
        }
    }

    /* renamed from: a */
    public void mo19849a(Rational lVar) {
        ExifTag a;
        if (!PatchProxy.proxy(new Object[]{lVar}, this, f9315a, false, 3829, new Class[]{Rational.class}, Void.TYPE).isSupported && (a = mo19845a(f9296H, (Object) lVar)) != null) {
            mo19846a(a);
        }
    }

    /* renamed from: b */
    public void mo19863b(Rational lVar) {
        ExifTag a;
        if (!PatchProxy.proxy(new Object[]{lVar}, this, f9315a, false, 3830, new Class[]{Rational.class}, Void.TYPE).isSupported && (a = mo19845a(f9297I, (Object) lVar)) != null) {
            mo19846a(a);
        }
    }

    /* renamed from: d */
    public void mo19873d(int i) {
        ExifTag a;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3831, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (a = mo19845a(f9300L, (Object) Integer.valueOf(i))) != null) {
            mo19846a(a);
        }
    }

    /* renamed from: e */
    public void mo19875e(int i) {
        ExifTag a;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3832, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (a = mo19845a(f9313Y, (Object) Integer.valueOf(i))) != null) {
            mo19846a(a);
        }
    }

    /* renamed from: f */
    public void mo19878f(int i) {
        ExifTag a;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3833, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (a = mo19845a(f9316aA, (Object) Integer.valueOf(i))) != null) {
            mo19846a(a);
        }
    }

    /* renamed from: c */
    public void mo19871c(Rational lVar) {
        ExifTag a;
        if (!PatchProxy.proxy(new Object[]{lVar}, this, f9315a, false, 3834, new Class[]{Rational.class}, Void.TYPE).isSupported && (a = mo19845a(f9310V, (Object) lVar)) != null) {
            mo19846a(a);
        }
    }

    public ExifInterface() {
        this.f9416bx.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    public void mo19854a(byte[] bArr) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f9315a, false, 3835, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            mo19851a((InputStream) new ByteArrayInputStream(bArr));
        }
    }

    /* renamed from: a */
    public void mo19851a(InputStream inputStream) throws IOException {
        if (!PatchProxy.proxy(new Object[]{inputStream}, this, f9315a, false, 3836, new Class[]{InputStream.class}, Void.TYPE).isSupported) {
            if (inputStream != null) {
                try {
                    this.f9414bv = new ExifReader(this).mo19906a(inputStream);
                } catch (ExifInvalidFormatException e) {
                    throw new IOException("Invalid exif format : " + e);
                }
            } else {
                throw new IllegalArgumentException("Argument is null");
            }
        }
    }

    /* renamed from: a */
    public void mo19852a(String str) throws FileNotFoundException, IOException {
        if (!PatchProxy.proxy(new Object[]{str}, this, f9315a, false, 3837, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (str != null) {
                BufferedInputStream bufferedInputStream = null;
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        mo19851a((InputStream) bufferedInputStream2);
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        m9821a((Closeable) bufferedInputStream);
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                    m9821a((Closeable) bufferedInputStream);
                    throw e;
                }
            } else {
                throw new IllegalArgumentException("Argument is null");
            }
        }
    }

    /* renamed from: a */
    public void mo19855a(byte[] bArr, OutputStream outputStream) throws IOException {
        if (!PatchProxy.proxy(new Object[]{bArr, outputStream}, this, f9315a, false, 3840, new Class[]{byte[].class, OutputStream.class}, Void.TYPE).isSupported) {
            if (bArr == null || outputStream == null) {
                throw new IllegalArgumentException("Argument is null");
            }
            OutputStream a = mo19847a(outputStream);
            a.write(bArr, 0, bArr.length);
            a.flush();
        }
    }

    /* renamed from: a */
    public void mo19856a(byte[] bArr, String str) throws FileNotFoundException, IOException {
        OutputStream outputStream;
        if (!PatchProxy.proxy(new Object[]{bArr, str}, this, f9315a, false, 3843, new Class[]{byte[].class, String.class}, Void.TYPE).isSupported) {
            if (bArr == null || str == null) {
                throw new IllegalArgumentException("Argument is null");
            }
            try {
                outputStream = mo19861b(str);
                try {
                    outputStream.write(bArr, 0, bArr.length);
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e = e;
                    m9821a((Closeable) outputStream);
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                m9821a((Closeable) outputStream);
                throw e;
            }
        }
    }

    /* renamed from: a */
    public void mo19848a(Bitmap bitmap, String str, int i) throws FileNotFoundException, IOException {
        OutputStream outputStream;
        if (!PatchProxy.proxy(new Object[]{bitmap, str, new Integer(i)}, this, f9315a, false, 3844, new Class[]{Bitmap.class, String.class, Integer.TYPE}, Void.TYPE).isSupported) {
            if (bitmap == null || str == null) {
                throw new IllegalArgumentException("Argument is null");
            }
            try {
                outputStream = mo19861b(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e = e;
                    m9821a((Closeable) outputStream);
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                m9821a((Closeable) outputStream);
                throw e;
            }
        }
    }

    /* renamed from: a */
    public OutputStream mo19847a(OutputStream outputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{outputStream}, this, f9315a, false, 3847, new Class[]{OutputStream.class}, OutputStream.class);
        if (proxy.isSupported) {
            return (OutputStream) proxy.result;
        }
        if (outputStream != null) {
            ExifOutputStream eVar = new ExifOutputStream(outputStream, this);
            eVar.mo19884a(this.f9414bv);
            return eVar;
        }
        throw new IllegalArgumentException("Argument is null");
    }

    /* renamed from: b */
    public OutputStream mo19861b(String str) throws FileNotFoundException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f9315a, false, 3848, new Class[]{String.class}, OutputStream.class);
        if (proxy.isSupported) {
            return (OutputStream) proxy.result;
        }
        if (str != null) {
            try {
                return mo19847a((OutputStream) new FileOutputStream(str));
            } catch (FileNotFoundException e) {
                m9821a((Closeable) null);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Argument is null");
        }
    }

    /* renamed from: a */
    public ExifTag mo19843a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3856, new Class[]{Integer.TYPE, Integer.TYPE}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        if (!ExifTag.m9917a(i2)) {
            return null;
        }
        return this.f9414bv.mo19826a(m9820a(i), i2);
    }

    /* renamed from: b */
    public Integer mo19862b(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3864, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.class);
        if (proxy.isSupported) {
            return (Integer) proxy.result;
        }
        int[] d = mo19874d(i, i2);
        if (d == null || d.length <= 0) {
            return null;
        }
        return Integer.valueOf(d[0]);
    }

    /* renamed from: g */
    public Integer mo19879g(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3865, new Class[]{Integer.TYPE}, Integer.class);
        if (proxy.isSupported) {
            return (Integer) proxy.result;
        }
        return mo19862b(i, mo19881i(i));
    }

    /* renamed from: c */
    public Rational mo19868c(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3868, new Class[]{Integer.TYPE, Integer.TYPE}, Rational.class);
        if (proxy.isSupported) {
            return (Rational) proxy.result;
        }
        Rational[] e = mo19877e(i, i2);
        if (e == null || e.length == 0) {
            return null;
        }
        return new Rational(e[0]);
    }

    /* renamed from: h */
    public Rational mo19880h(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3869, new Class[]{Integer.TYPE}, Rational.class);
        if (proxy.isSupported) {
            return (Rational) proxy.result;
        }
        return mo19868c(i, mo19881i(i));
    }

    /* renamed from: d */
    public int[] mo19874d(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3872, new Class[]{Integer.TYPE, Integer.TYPE}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        ExifTag a = mo19843a(i, i2);
        if (a == null) {
            return null;
        }
        return a.mo19934h();
    }

    /* renamed from: e */
    public Rational[] mo19877e(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3876, new Class[]{Integer.TYPE, Integer.TYPE}, Rational[].class);
        if (proxy.isSupported) {
            return (Rational[]) proxy.result;
        }
        ExifTag a = mo19843a(i, i2);
        if (a == null) {
            return null;
        }
        return a.mo19933g();
    }

    /* renamed from: i */
    public int mo19881i(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3881, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (mo19872d().get(i) == 0) {
            return -1;
        }
        return m9824b(i);
    }

    /* renamed from: a */
    public static boolean m9822a(short s) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Short(s)}, (Object) null, f9315a, true, 3883, new Class[]{Short.TYPE}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : f9389bu.contains(Short.valueOf(s));
    }

    /* renamed from: a */
    public ExifTag mo19844a(int i, int i2, Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), obj}, this, f9315a, false, 3884, new Class[]{Integer.TYPE, Integer.TYPE, Object.class}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        int i3 = mo19872d().get(i);
        if (i3 == 0 || obj == null) {
            return null;
        }
        short m = m9830m(i3);
        int n = m9831n(i3);
        boolean z = n != 0;
        if (!m9827f(i3, i2)) {
            return null;
        }
        ExifTag hVar = new ExifTag(m9820a(i), m, n, i2, z);
        if (!hVar.mo19912a(obj)) {
            return null;
        }
        return hVar;
    }

    /* renamed from: a */
    public ExifTag mo19845a(int i, Object obj) {
        Object[] objArr = {new Integer(i), obj};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3885, new Class[]{Integer.TYPE, Object.class}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        return mo19844a(i, m9824b(i), obj);
    }

    /* renamed from: j */
    public ExifTag mo19882j(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9315a, false, 3886, new Class[]{Integer.TYPE}, ExifTag.class);
        if (proxy.isSupported) {
            return (ExifTag) proxy.result;
        }
        int i2 = mo19872d().get(i);
        if (i2 == 0) {
            return null;
        }
        short m = m9830m(i2);
        int n = m9831n(i2);
        return new ExifTag(m9820a(i), m, n, m9824b(i), n != 0);
    }

    /* renamed from: b */
    public boolean mo19865b(int i, int i2, Object obj) {
        Object[] objArr = {new Integer(i), new Integer(i2), obj};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3887, new Class[]{Integer.TYPE, Integer.TYPE, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ExifTag a = mo19843a(i, i2);
        if (a == null) {
            return false;
        }
        return a.mo19912a(obj);
    }

    /* renamed from: b */
    public boolean mo19866b(int i, Object obj) {
        Object[] objArr = {new Integer(i), obj};
        ChangeQuickRedirect changeQuickRedirect = f9315a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3888, new Class[]{Integer.TYPE, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19865b(i, mo19881i(i), obj);
    }

    /* renamed from: a */
    public ExifTag mo19846a(ExifTag hVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hVar}, this, f9315a, false, 3889, new Class[]{ExifTag.class}, ExifTag.class);
        return proxy.isSupported ? (ExifTag) proxy.result : this.f9414bv.mo19824a(hVar);
    }

    /* renamed from: a */
    public Bitmap mo19842a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9315a, false, 3899, new Class[0], Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (this.f9414bv.mo19834b()) {
            byte[] a = this.f9414bv.mo19830a();
            return BitmapFactory.decodeByteArray(a, 0, a.length);
        }
        this.f9414bv.mo19837d();
        return null;
    }

    /* renamed from: b */
    public boolean mo19864b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9315a, false, 3903, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f9414bv.mo19834b();
    }

    /* renamed from: b */
    public boolean mo19867b(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, this, f9315a, false, 3904, new Class[]{byte[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f9414bv.mo19840f();
        this.f9414bv.mo19829a(bArr);
        return true;
    }

    /* renamed from: a */
    public boolean mo19860a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, f9315a, false, 3905, new Class[]{Bitmap.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream)) {
            return false;
        }
        return mo19867b(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: c */
    public void mo19869c() {
        if (!PatchProxy.proxy(new Object[0], this, f9315a, false, 3906, new Class[0], Void.TYPE).isSupported) {
            this.f9414bv.mo19829a((byte[]) null);
        }
    }

    /* renamed from: k */
    public static short m9828k(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 < 90) {
            return 1;
        }
        if (i2 < 180) {
            return 6;
        }
        return i2 < 270 ? (short) 3 : 8;
    }

    /* renamed from: a */
    public boolean mo19858a(int i, long j, TimeZone timeZone) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Long(j), timeZone}, this, f9315a, false, 3910, new Class[]{Integer.TYPE, Long.TYPE, TimeZone.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (i != f9408u && i != f9304P && i != f9303O) {
            return false;
        }
        this.f9415bw.setTimeZone(timeZone);
        ExifTag a = mo19845a(f9408u, (Object) this.f9415bw.format(Long.valueOf(j)));
        if (a == null) {
            return false;
        }
        mo19846a(a);
        ExifTag a2 = mo19845a(f9304P, (Object) this.f9415bw.format(Long.valueOf(j)));
        if (a2 == null) {
            return false;
        }
        mo19846a(a2);
        ExifTag a3 = mo19845a(f9303O, (Object) this.f9415bw.format(Long.valueOf(j)));
        if (a3 == null) {
            return false;
        }
        mo19846a(a3);
        return true;
    }

    /* renamed from: a */
    public boolean mo19857a(double d, double d2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Double(d), new Double(d2)}, this, f9315a, false, 3911, new Class[]{Double.TYPE, Double.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ExifTag a = mo19845a(f9330aO, (Object) m9823a(d));
        ExifTag a2 = mo19845a(f9332aQ, (Object) m9823a(d2));
        ExifTag a3 = mo19845a(f9329aN, (Object) d >= 0.0d ? "N" : androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
        ExifTag a4 = mo19845a(f9331aP, (Object) d2 >= 0.0d ? androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST : androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST);
        if (a == null || a2 == null || a3 == null || a4 == null) {
            return false;
        }
        mo19846a(a);
        mo19846a(a2);
        mo19846a(a3);
        mo19846a(a4);
        return true;
    }

    /* renamed from: a */
    public boolean mo19859a(long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f9315a, false, 3912, new Class[]{Long.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ExifTag a = mo19845a(f9384bp, (Object) this.f9416bx.format(Long.valueOf(j)));
        if (a == null) {
            return false;
        }
        mo19846a(a);
        this.f9417by.setTimeInMillis(j);
        ExifTag a2 = mo19845a(f9335aT, (Object) new Rational[]{new Rational((long) this.f9417by.get(11), 1), new Rational((long) this.f9417by.get(12), 1), new Rational((long) this.f9417by.get(13), 1)});
        if (a2 == null) {
            return false;
        }
        mo19846a(a2);
        return true;
    }

    /* renamed from: a */
    public static Rational[] m9823a(double d) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Double(d)}, (Object) null, f9315a, true, 3913, new Class[]{Double.TYPE}, Rational[].class);
        if (proxy.isSupported) {
            return (Rational[]) proxy.result;
        }
        double abs = Math.abs(d);
        int i = (int) abs;
        double d2 = (abs - ((double) i)) * 60.0d;
        int i2 = (int) d2;
        return new Rational[]{new Rational((long) i, 1), new Rational((long) i2, 1), new Rational((long) ((int) ((d2 - ((double) i2)) * 6000.0d)), 100)};
    }

    /* renamed from: a */
    public static void m9821a(Closeable closeable) {
        if (!PatchProxy.proxy(new Object[]{closeable}, (Object) null, f9315a, true, 3915, new Class[]{Closeable.class}, Void.TYPE).isSupported && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    public SparseIntArray mo19872d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9315a, false, 3916, new Class[0], SparseIntArray.class);
        if (proxy.isSupported) {
            return (SparseIntArray) proxy.result;
        }
        if (this.f9418bz == null) {
            this.f9418bz = new SparseIntArray();
            m9826f();
        }
        return this.f9418bz;
    }

    /* renamed from: f */
    private void m9826f() {
        if (!PatchProxy.proxy(new Object[0], this, f9315a, false, 3917, new Class[0], Void.TYPE).isSupported) {
            int a = m9819a(new int[]{0, 1}) << 24;
            int i = a | 131072;
            int i2 = i | 0;
            this.f9418bz.put(f9395h, i2);
            int i3 = a | 262144;
            int i4 = i3 | 1;
            this.f9418bz.put(f9368b, i4);
            this.f9418bz.put(f9390c, i4);
            int i5 = a | 196608;
            this.f9418bz.put(f9391d, i5 | 3);
            int i6 = i5 | 1;
            this.f9418bz.put(f9392e, i6);
            this.f9418bz.put(f9393f, i6);
            this.f9418bz.put(f9398k, i6);
            this.f9418bz.put(f9399l, i6);
            this.f9418bz.put(f9404q, i6);
            this.f9418bz.put(f9413z, i5 | 2);
            this.f9418bz.put(f9289A, i6);
            int i7 = a | 327680;
            int i8 = i7 | 1;
            this.f9418bz.put(f9402o, i8);
            this.f9418bz.put(f9403p, i8);
            this.f9418bz.put(f9405r, i6);
            int i9 = i3 | 0;
            this.f9418bz.put(f9397j, i9);
            this.f9418bz.put(f9400m, i4);
            this.f9418bz.put(f9401n, i9);
            this.f9418bz.put(f9406s, i5 | 768);
            this.f9418bz.put(f9410w, i7 | 2);
            int i10 = i7 | 6;
            this.f9418bz.put(f9411x, i10);
            this.f9418bz.put(f9412y, i7 | 3);
            this.f9418bz.put(f9290B, i10);
            this.f9418bz.put(f9408u, i | 20);
            this.f9418bz.put(f9394g, i2);
            this.f9418bz.put(f9395h, i2);
            this.f9418bz.put(f9396i, i2);
            this.f9418bz.put(f9407t, i2);
            this.f9418bz.put(f9409v, i2);
            this.f9418bz.put(f9291C, i2);
            this.f9418bz.put(f9292D, i4);
            this.f9418bz.put(f9293E, i4);
            int a2 = (m9819a(new int[]{1}) << 24) | 262144 | 1;
            this.f9418bz.put(f9294F, a2);
            this.f9418bz.put(f9295G, a2);
            int a3 = m9819a(new int[]{2}) << 24;
            int i11 = a3 | 458752;
            int i12 = i11 | 4;
            this.f9418bz.put(f9302N, i12);
            this.f9418bz.put(f9350ai, i12);
            int i13 = a3 | 196608;
            int i14 = i13 | 1;
            this.f9418bz.put(f9351aj, i14);
            this.f9418bz.put(f9305Q, i12);
            int i15 = a3 | 327680 | 1;
            this.f9418bz.put(f9306R, i15);
            int i16 = 262144 | a3 | 1;
            this.f9418bz.put(f9352ak, i16);
            this.f9418bz.put(f9353al, i16);
            int i17 = i11 | 0;
            this.f9418bz.put(f9345ad, i17);
            this.f9418bz.put(f9346ae, i17);
            int i18 = a3 | 131072;
            this.f9418bz.put(f9354am, i18 | 13);
            int i19 = i18 | 20;
            this.f9418bz.put(f9303O, i19);
            this.f9418bz.put(f9304P, i19);
            int i20 = i18 | 0;
            this.f9418bz.put(f9347af, i20);
            this.f9418bz.put(f9348ag, i20);
            this.f9418bz.put(f9349ah, i20);
            this.f9418bz.put(f9327aL, i18 | 33);
            this.f9418bz.put(f9296H, i15);
            this.f9418bz.put(f9297I, i15);
            this.f9418bz.put(f9298J, i14);
            this.f9418bz.put(f9299K, i20);
            int i21 = i13 | 0;
            this.f9418bz.put(f9300L, i21);
            this.f9418bz.put(f9301M, i17);
            int i22 = a3 | 655360 | 1;
            this.f9418bz.put(f9307S, i22);
            this.f9418bz.put(f9308T, i15);
            this.f9418bz.put(f9309U, i22);
            this.f9418bz.put(f9310V, i22);
            this.f9418bz.put(f9311W, i15);
            this.f9418bz.put(f9312X, i15);
            this.f9418bz.put(f9313Y, i14);
            this.f9418bz.put(f9314Z, i14);
            this.f9418bz.put(f9342aa, i14);
            this.f9418bz.put(f9343ab, i15);
            this.f9418bz.put(f9344ac, i21);
            this.f9418bz.put(f9356ao, i15);
            this.f9418bz.put(f9357ap, i17);
            this.f9418bz.put(f9358aq, i15);
            this.f9418bz.put(f9359ar, i15);
            this.f9418bz.put(f9360as, i14);
            this.f9418bz.put(f9361at, 2 | i13);
            this.f9418bz.put(f9362au, i15);
            this.f9418bz.put(f9363av, i14);
            int i23 = i11 | 1;
            this.f9418bz.put(f9364aw, i23);
            this.f9418bz.put(f9365ax, i23);
            this.f9418bz.put(f9366ay, i17);
            this.f9418bz.put(f9367az, i14);
            this.f9418bz.put(f9316aA, i14);
            this.f9418bz.put(f9317aB, i14);
            this.f9418bz.put(f9318aC, i15);
            this.f9418bz.put(f9319aD, i14);
            this.f9418bz.put(f9320aE, i14);
            this.f9418bz.put(f9321aF, i15);
            this.f9418bz.put(f9322aG, i14);
            this.f9418bz.put(f9323aH, i14);
            this.f9418bz.put(f9324aI, i14);
            this.f9418bz.put(f9325aJ, i17);
            this.f9418bz.put(f9326aK, i14);
            this.f9418bz.put(f9355an, i16);
            int a4 = m9819a(new int[]{4}) << 24;
            int i24 = 65536 | a4;
            this.f9418bz.put(f9328aM, i24 | 4);
            int i25 = a4 | 131072;
            int i26 = i25 | 2;
            this.f9418bz.put(f9329aN, i26);
            this.f9418bz.put(f9331aP, i26);
            int i27 = a4 | 655360 | 3;
            this.f9418bz.put(f9330aO, i27);
            this.f9418bz.put(f9332aQ, i27);
            this.f9418bz.put(f9333aR, i24 | 1);
            int i28 = 327680 | a4;
            int i29 = i28 | 1;
            this.f9418bz.put(f9334aS, i29);
            this.f9418bz.put(f9335aT, i28 | 3);
            int i30 = i25 | 0;
            this.f9418bz.put(f9336aU, i30);
            this.f9418bz.put(f9337aV, i26);
            this.f9418bz.put(f9338aW, i26);
            this.f9418bz.put(f9339aX, i29);
            this.f9418bz.put(f9340aY, i26);
            this.f9418bz.put(f9341aZ, i29);
            this.f9418bz.put(f9369ba, i26);
            this.f9418bz.put(f9370bb, i29);
            this.f9418bz.put(f9371bc, i26);
            this.f9418bz.put(f9372bd, i29);
            this.f9418bz.put(f9373be, i30);
            this.f9418bz.put(f9374bf, i26);
            this.f9418bz.put(f9375bg, i29);
            this.f9418bz.put(f9378bj, i26);
            this.f9418bz.put(f9379bk, i29);
            this.f9418bz.put(f9380bl, i26);
            this.f9418bz.put(f9381bm, i29);
            int i31 = 458752 | a4 | 0;
            this.f9418bz.put(f9382bn, i31);
            this.f9418bz.put(f9383bo, i31);
            this.f9418bz.put(f9384bp, i25 | 11);
            this.f9418bz.put(f9385bq, a4 | 196608 | 11);
            this.f9418bz.put(f9386br, (m9819a(new int[]{3}) << 24) | 131072 | 0);
        }
    }

    /* renamed from: f */
    public static boolean m9827f(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, (Object) null, f9315a, true, 3919, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int[] a = IfdData.m9959a();
        int l = m9829l(i);
        for (int i3 = 0; i3 < a.length; i3++) {
            if (i2 == a[i3] && ((l >> i3) & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m9819a(int[] iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{iArr}, (Object) null, f9315a, true, 3920, new Class[]{int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int[] a = IfdData.m9959a();
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (a[i2] == iArr[i3]) {
                    i |= 1 << i2;
                    break;
                }
                i3++;
            }
        }
        return i;
    }

    /* renamed from: e */
    public boolean mo19876e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9315a, false, 3921, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        String str = Build.MANUFACTURER;
        if (str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            str = "Meizu";
        }
        ExifTag a = mo19845a(f9395h, (Object) str);
        if (a == null) {
            return false;
        }
        mo19846a(a);
        ExifTag a2 = mo19845a(f9396i, (Object) Build.MODEL);
        if (a2 == null) {
            return false;
        }
        mo19846a(a2);
        ExifTag a3 = mo19845a(f9407t, (Object) "Meizu Camera");
        if (a3 == null) {
            return false;
        }
        mo19846a(a3);
        return true;
    }

    /* renamed from: o */
    public boolean mo19883o(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9315a, false, 3922, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ExifTag a = mo19845a(f9398k, (Object) Integer.valueOf(i == 90 ? 6 : i == 180 ? 3 : i == 270 ? 8 : 1));
        if (a == null) {
            return false;
        }
        mo19846a(a);
        return true;
    }
}
