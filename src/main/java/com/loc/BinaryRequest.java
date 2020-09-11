package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.loc.aj */
public abstract class BinaryRequest extends Request {

    /* renamed from: a */
    protected Context f2565a;

    /* renamed from: b */
    protected SDKInfo f2566b;

    public BinaryRequest(Context context, SDKInfo diVar) {
        if (context != null) {
            this.f2565a = context.getApplicationContext();
        }
        this.f2566b = diVar;
    }

    /* renamed from: a */
    protected static byte[] m3003a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    /* renamed from: m */
    private static byte[] mo13256m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C1107dj.m3818a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            BasicLogHandler.m3844a(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    /* renamed from: n */
    private byte[] m3005n() {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (mo12999e()) {
                bArr = ClientInfo.m3689a(this.f2565a, mo13004j());
                byteArrayOutputStream.write(m3003a(bArr));
            } else {
                bArr = new byte[]{0, 0};
            }
            byteArrayOutputStream.write(bArr);
            byte[] a = C1107dj.m3818a(mo13001g());
            if (a == null || a.length <= 0) {
                a = new byte[]{0, 0};
            } else {
                byteArrayOutputStream.write(m3003a(a));
            }
            byteArrayOutputStream.write(a);
            byte[] a2 = C1107dj.m3818a(mo13000f());
            if (a2 == null || a2.length <= 0) {
                a2 = new byte[]{0, 0};
            } else {
                byteArrayOutputStream.write(m3003a(a2));
            }
            byteArrayOutputStream.write(a2);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            BasicLogHandler.m3844a(th2, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    /* renamed from: o */
    private byte[] m3006o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] h = mo13002h();
            if (h != null) {
                if (h.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(m3003a(h));
                    byteArrayOutputStream.write(h);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                BasicLogHandler.m3844a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            BasicLogHandler.m3844a(th3, "bre", "grrd");
        }
        return new byte[]{0};
        throw th;
    }

    /* renamed from: p */
    private byte[] m3007p() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] i = mo13003i();
            if (i != null) {
                if (i.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    Context context = this.f2565a;
                    byte[] a = C1102dd.m3739a(i);
                    byteArrayOutputStream.write(m3003a(a));
                    byteArrayOutputStream.write(a);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                BasicLogHandler.m3844a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            BasicLogHandler.m3844a(th3, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    /* renamed from: b */
    public Map<String, String> mo12966b() {
        String f = AppInfo.m3666f(this.f2565a);
        String a = ClientInfo.m3686a();
        Context context = this.f2565a;
        String a2 = ClientInfo.m3687a(context, a, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    /* renamed from: d */
    public final byte[] mo12997d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(mo13256m());
            byteArrayOutputStream.write(m3005n());
            byteArrayOutputStream.write(m3006o());
            byteArrayOutputStream.write(m3007p());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                BasicLogHandler.m3844a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            BasicLogHandler.m3844a(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    /* renamed from: e */
    public boolean mo12999e() {
        return true;
    }

    /* renamed from: f */
    public String mo13000f() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f2566b.mo13275c(), this.f2566b.mo13272a()});
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo13001g() {
        return "2.1";
    }

    /* renamed from: h */
    public abstract byte[] mo13002h();

    /* renamed from: i */
    public abstract byte[] mo13003i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo13004j() {
        return false;
    }
}
