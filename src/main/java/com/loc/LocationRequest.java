package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.loc.cb */
public final class LocationRequest extends BinaryRequest {

    /* renamed from: f */
    Map<String, String> f2858f = null;

    /* renamed from: g */
    String f2859g = "";

    /* renamed from: h */
    byte[] f2860h = null;

    /* renamed from: i */
    byte[] f2861i = null;

    /* renamed from: j */
    boolean f2862j = false;

    /* renamed from: k */
    String f2863k = null;

    /* renamed from: l */
    Map<String, String> f2864l = null;

    /* renamed from: m */
    boolean f2865m = false;

    /* renamed from: n */
    private String f2866n = "";

    public LocationRequest(Context context, SDKInfo diVar) {
        super(context, diVar);
    }

    /* renamed from: a */
    public final Map<String, String> mo12965a() {
        return this.f2858f;
    }

    /* renamed from: a */
    public final void mo13160a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2866n = str;
        } else {
            this.f2866n = "";
        }
    }

    /* renamed from: b */
    public final Map<String, String> mo12966b() {
        return this.f2864l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[SYNTHETIC, Splitter:B:23:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC, Splitter:B:28:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13161b(byte[] r3) {
        /*
            r2 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x002a }
            r1.<init>()     // Catch:{ Throwable -> 0x002a }
            if (r3 == 0) goto L_0x0018
            byte[] r0 = m3003a(r3)     // Catch:{ Throwable -> 0x0015, all -> 0x0013 }
            r1.write(r0)     // Catch:{ Throwable -> 0x0015, all -> 0x0013 }
            r1.write(r3)     // Catch:{ Throwable -> 0x0015, all -> 0x0013 }
            goto L_0x0018
        L_0x0013:
            r3 = move-exception
            goto L_0x0039
        L_0x0015:
            r3 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x0018:
            byte[] r3 = r1.toByteArray()     // Catch:{ Throwable -> 0x0015, all -> 0x0013 }
            r2.f2861i = r3     // Catch:{ Throwable -> 0x0015, all -> 0x0013 }
            r1.close()     // Catch:{ IOException -> 0x0022 }
            return
        L_0x0022:
            r3 = move-exception
            r3.printStackTrace()
            return
        L_0x0027:
            r3 = move-exception
            r1 = r0
            goto L_0x0039
        L_0x002a:
            r3 = move-exception
        L_0x002b:
            r3.printStackTrace()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0038:
            return
        L_0x0039:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0043:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LocationRequest.mo13161b(byte[]):void");
    }

    /* renamed from: c */
    public final String mo12967c() {
        return this.f2859g;
    }

    /* renamed from: e */
    public final boolean mo12999e() {
        return this.f2862j;
    }

    /* renamed from: f */
    public final String mo13000f() {
        return this.f2863k;
    }

    /* renamed from: h */
    public final byte[] mo13002h() {
        return this.f2860h;
    }

    /* renamed from: i */
    public final byte[] mo13003i() {
        return this.f2861i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final boolean mo13004j() {
        return this.f2865m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final String mo13024k() {
        return this.f2866n;
    }
}
