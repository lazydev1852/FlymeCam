package com.loc;

import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.loc.i */
public final class LogUpdateRequest extends Request {

    /* renamed from: a */
    private byte[] f3357a;

    /* renamed from: b */
    private String f3358b = "1";

    public LogUpdateRequest(byte[] bArr, String str) {
        this.f3357a = (byte[]) bArr.clone();
        this.f3358b = str;
    }

    /* renamed from: a */
    public final Map<String, String> mo12965a() {
        HashMap hashMap = new HashMap();
        hashMap.put(HTTP.CONTENT_TYPE, "application/zip");
        hashMap.put(HTTP.CONTENT_LEN, String.valueOf(this.f3357a.length));
        return hashMap;
    }

    /* renamed from: b */
    public final Map<String, String> mo12966b() {
        return null;
    }

    /* renamed from: c */
    public final String mo12967c() {
        String c = C1107dj.m3824c(ConstConfig.f3338c);
        byte[] a = C1107dj.m3818a(ConstConfig.f3337b);
        byte[] bArr = new byte[(a.length + 50)];
        System.arraycopy(this.f3357a, 0, bArr, 0, 50);
        System.arraycopy(a, 0, bArr, 50, a.length);
        return String.format(c, new Object[]{"1", this.f3358b, "1", "open", MD5.m3760a(bArr)});
    }

    /* renamed from: d */
    public final byte[] mo12997d() {
        return this.f3357a;
    }
}
