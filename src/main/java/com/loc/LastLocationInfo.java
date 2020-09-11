package com.loc;

import com.amap.api.location.AMapLocation;

@EntityClass(mo13026a = "c")
/* renamed from: com.loc.bw */
public class LastLocationInfo {
    @EntityField(mo13028a = "a2", mo13029b = 6)

    /* renamed from: a */
    private String f2793a;
    @EntityField(mo13028a = "a3", mo13029b = 5)

    /* renamed from: b */
    private long f2794b;
    @EntityField(mo13028a = "a4", mo13029b = 6)

    /* renamed from: c */
    private String f2795c;

    /* renamed from: d */
    private AMapLocation f2796d;

    /* renamed from: a */
    public final AMapLocation mo13131a() {
        return this.f2796d;
    }

    /* renamed from: a */
    public final void mo13132a(long j) {
        this.f2794b = j;
    }

    /* renamed from: a */
    public final void mo13133a(AMapLocation aMapLocation) {
        this.f2796d = aMapLocation;
    }

    /* renamed from: a */
    public final void mo13134a(String str) {
        this.f2795c = str;
    }

    /* renamed from: b */
    public final String mo13135b() {
        return this.f2795c;
    }

    /* renamed from: b */
    public final void mo13136b(String str) {
        this.f2793a = str;
    }

    /* renamed from: c */
    public final String mo13137c() {
        return this.f2793a;
    }

    /* renamed from: d */
    public final long mo13138d() {
        return this.f2794b;
    }
}
