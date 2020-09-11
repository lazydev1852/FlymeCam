package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.loc.cv */
public final class LastLocationManager {

    /* renamed from: b */
    static LastLocationInfo f3162b;

    /* renamed from: e */
    static DBOperation f3163e;

    /* renamed from: g */
    static long f3164g;

    /* renamed from: a */
    String f3165a = null;

    /* renamed from: c */
    LastLocationInfo f3166c = null;

    /* renamed from: d */
    LastLocationInfo f3167d = null;

    /* renamed from: f */
    long f3168f = 0;

    /* renamed from: h */
    boolean f3169h = false;

    /* renamed from: i */
    private Context f3170i;

    public LastLocationManager(Context context) {
        this.f3170i = context.getApplicationContext();
    }

    /* renamed from: e */
    private void m3640e() {
        if (f3162b == null || C1079cp.m3529c() - f3164g > 180000) {
            LastLocationInfo f = m3641f();
            f3164g = C1079cp.m3529c();
            if (f != null && C1079cp.m3508a(f.mo13131a())) {
                f3162b = f;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r2 = com.loc.Encrypt.m3214d(r2, r6.f3165a);
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.loc.LastLocationInfo m3641f() {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3170i
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r6.mo13240a()
            com.loc.n r0 = f3163e     // Catch:{ Throwable -> 0x008e }
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            com.loc.n r0 = f3163e     // Catch:{ Throwable -> 0x008e }
            java.lang.String r2 = "_id=1"
            java.lang.Class<com.loc.bw> r3 = com.loc.LastLocationInfo.class
            java.util.List r0 = r0.mo13304b(r2, r3)     // Catch:{ Throwable -> 0x008e }
            if (r0 == 0) goto L_0x006c
            int r2 = r0.size()     // Catch:{ Throwable -> 0x008e }
            if (r2 <= 0) goto L_0x006c
            r2 = 0
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Throwable -> 0x008e }
            com.loc.bw r0 = (com.loc.LastLocationInfo) r0     // Catch:{ Throwable -> 0x008e }
            java.lang.String r2 = r0.mo13137c()     // Catch:{ Throwable -> 0x008c }
            byte[] r2 = com.loc.C1102dd.m3744b((java.lang.String) r2)     // Catch:{ Throwable -> 0x008c }
            if (r2 == 0) goto L_0x0047
            int r3 = r2.length     // Catch:{ Throwable -> 0x008c }
            if (r3 <= 0) goto L_0x0047
            java.lang.String r3 = r6.f3165a     // Catch:{ Throwable -> 0x008c }
            byte[] r2 = com.loc.Encrypt.m3214d(r2, r3)     // Catch:{ Throwable -> 0x008c }
            if (r2 == 0) goto L_0x0047
            int r3 = r2.length     // Catch:{ Throwable -> 0x008c }
            if (r3 <= 0) goto L_0x0047
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x008c }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch:{ Throwable -> 0x008c }
            goto L_0x0048
        L_0x0047:
            r3 = r1
        L_0x0048:
            java.lang.String r2 = r0.mo13135b()     // Catch:{ Throwable -> 0x008c }
            byte[] r2 = com.loc.C1102dd.m3744b((java.lang.String) r2)     // Catch:{ Throwable -> 0x008c }
            if (r2 == 0) goto L_0x0067
            int r4 = r2.length     // Catch:{ Throwable -> 0x008c }
            if (r4 <= 0) goto L_0x0067
            java.lang.String r4 = r6.f3165a     // Catch:{ Throwable -> 0x008c }
            byte[] r2 = com.loc.Encrypt.m3214d(r2, r4)     // Catch:{ Throwable -> 0x008c }
            if (r2 == 0) goto L_0x0067
            int r4 = r2.length     // Catch:{ Throwable -> 0x008c }
            if (r4 <= 0) goto L_0x0067
            java.lang.String r1 = new java.lang.String     // Catch:{ Throwable -> 0x008c }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r2, r4)     // Catch:{ Throwable -> 0x008c }
        L_0x0067:
            r0.mo13134a((java.lang.String) r1)     // Catch:{ Throwable -> 0x008c }
            r1 = r3
            goto L_0x006d
        L_0x006c:
            r0 = r1
        L_0x006d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x008c }
            if (r2 != 0) goto L_0x0099
            com.amap.api.location.AMapLocation r2 = new com.amap.api.location.AMapLocation     // Catch:{ Throwable -> 0x008c }
            java.lang.String r3 = ""
            r2.<init>((java.lang.String) r3)     // Catch:{ Throwable -> 0x008c }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x008c }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x008c }
            com.loc.CoreUtil.m3388a((com.amap.api.location.AMapLocation) r2, (org.json.JSONObject) r3)     // Catch:{ Throwable -> 0x008c }
            boolean r1 = com.loc.C1079cp.m3525b((com.amap.api.location.AMapLocation) r2)     // Catch:{ Throwable -> 0x008c }
            if (r1 == 0) goto L_0x0099
            r0.mo13133a((com.amap.api.location.AMapLocation) r2)     // Catch:{ Throwable -> 0x008c }
            goto L_0x0099
        L_0x008c:
            r1 = move-exception
            goto L_0x0092
        L_0x008e:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0092:
            java.lang.String r2 = "LastLocationManager"
            java.lang.String r3 = "readLastFix"
            com.loc.CoreUtil.m3389a(r1, r2, r3)
        L_0x0099:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LastLocationManager.m3641f():com.loc.bw");
    }

    /* renamed from: a */
    public final AMapLocation mo13239a(AMapLocation aMapLocation, String str, long j) {
        if (aMapLocation == null || aMapLocation.mo8484c() == 0 || aMapLocation.mo8475a() == 1 || aMapLocation.mo8484c() == 7) {
            return aMapLocation;
        }
        try {
            m3640e();
            if (f3162b != null) {
                if (f3162b.mo13131a() != null) {
                    boolean z = false;
                    if (TextUtils.isEmpty(str)) {
                        long c = C1079cp.m3529c() - f3162b.mo13138d();
                        if (c >= 0 && c <= j) {
                            z = true;
                        }
                        aMapLocation.mo8500g(3);
                    } else {
                        z = C1079cp.m3511a(f3162b.mo13135b(), str);
                        aMapLocation.mo8500g(2);
                    }
                    if (!z) {
                        return aMapLocation;
                    }
                    AMapLocation a = f3162b.mo13131a();
                    try {
                        a.mo8481b(9);
                        a.mo8483b(true);
                        a.mo8478a(aMapLocation.mo8480b());
                        return a;
                    } catch (Throwable th) {
                        AMapLocation aMapLocation2 = a;
                        th = th;
                        aMapLocation = aMapLocation2;
                        CoreUtil.m3389a(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
            CoreUtil.m3389a(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
    }

    /* renamed from: a */
    public final void mo13240a() {
        if (!this.f3169h) {
            try {
                if (this.f3165a == null) {
                    this.f3165a = Encrypt.m3207a(MessageDigestAlgorithms.MD5, DeviceInfo.m3733v(this.f3170i));
                }
                if (f3163e == null) {
                    f3163e = new DBOperation(this.f3170i, DBOperation.m3894a((Class<? extends DBCreator>) SdCardDbCreator.class));
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.f3169h = true;
        }
    }

    /* renamed from: a */
    public final boolean mo13241a(AMapLocation aMapLocation, String str) {
        if (this.f3170i != null && aMapLocation != null && C1079cp.m3508a(aMapLocation) && aMapLocation.mo8475a() != 2 && !aMapLocation.mo8537u() && !aMapLocation.mo8535t()) {
            LastLocationInfo bwVar = new LastLocationInfo();
            bwVar.mo13133a(aMapLocation);
            if (aMapLocation.mo8475a() == 1) {
                bwVar.mo13134a((String) null);
            } else {
                bwVar.mo13134a(str);
            }
            try {
                f3162b = bwVar;
                f3164g = C1079cp.m3529c();
                this.f3166c = bwVar;
                if ((this.f3167d == null || C1079cp.m3497a(this.f3167d.mo13131a(), bwVar.mo13131a()) > 500.0f) && C1079cp.m3529c() - this.f3168f > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    /* renamed from: b */
    public final AMapLocation mo13242b() {
        m3640e();
        if (f3162b != null && C1079cp.m3508a(f3162b.mo13131a())) {
            return f3162b.mo13131a();
        }
        return null;
    }

    /* renamed from: c */
    public final void mo13243c() {
        try {
            mo13244d();
            this.f3168f = 0;
            this.f3169h = false;
            this.f3166c = null;
            this.f3167d = null;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "LastLocationManager", "destroy");
        }
    }

    /* renamed from: d */
    public final void mo13244d() {
        String str;
        try {
            mo13240a();
            if (this.f3166c != null && C1079cp.m3508a(this.f3166c.mo13131a()) && f3163e != null && this.f3166c != this.f3167d) {
                if (this.f3166c.mo13138d() == 0) {
                    String w = this.f3166c.mo13131a().mo8539w();
                    String b = this.f3166c.mo13135b();
                    this.f3167d = this.f3166c;
                    String str2 = null;
                    if (!TextUtils.isEmpty(w)) {
                        str = C1102dd.m3743b(Encrypt.m3213c(w.getBytes("UTF-8"), this.f3165a));
                        if (!TextUtils.isEmpty(b)) {
                            str2 = C1102dd.m3743b(Encrypt.m3213c(b.getBytes("UTF-8"), this.f3165a));
                        }
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        LastLocationInfo bwVar = new LastLocationInfo();
                        bwVar.mo13136b(str);
                        bwVar.mo13132a(C1079cp.m3529c());
                        bwVar.mo13134a(str2);
                        f3163e.mo13301a((Object) bwVar, "_id=1");
                        this.f3168f = C1079cp.m3529c();
                        if (f3162b != null) {
                            f3162b.mo13132a(C1079cp.m3529c());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
