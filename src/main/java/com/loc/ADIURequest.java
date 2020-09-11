package com.loc;

import java.util.Map;

/* renamed from: com.loc.ah */
public final class ADIURequest extends Request {

    /* renamed from: a */
    private byte[] f2560a;

    /* renamed from: b */
    private Map<String, String> f2561b;

    public ADIURequest(byte[] bArr, Map<String, String> map) {
        this.f2560a = bArr;
        this.f2561b = map;
    }

    /* renamed from: a */
    public final Map<String, String> mo12965a() {
        return null;
    }

    /* renamed from: b */
    public final Map<String, String> mo12966b() {
        return this.f2561b;
    }

    /* renamed from: c */
    public final String mo12967c() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    /* renamed from: d */
    public final byte[] mo12997d() {
        return this.f2560a;
    }
}
