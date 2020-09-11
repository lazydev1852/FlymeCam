package com.loc;

import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

/* renamed from: com.loc.bn */
public final class LocFilter {

    /* renamed from: a */
    AMapLocationServer f2674a = null;

    /* renamed from: b */
    long f2675b = 0;

    /* renamed from: c */
    long f2676c = 0;

    /* renamed from: d */
    int f2677d = 0;

    /* renamed from: e */
    long f2678e = 0;

    /* renamed from: f */
    AMapLocation f2679f = null;

    /* renamed from: g */
    long f2680g = 0;

    /* renamed from: h */
    private boolean f2681h = true;

    /* renamed from: b */
    private AMapLocationServer m3111b(AMapLocationServer aMapLocationServer) {
        int i;
        if (C1079cp.m3509a(aMapLocationServer)) {
            if (!this.f2681h || !AuthUtil.m3349b(aMapLocationServer.getTime())) {
                i = this.f2677d;
            } else if (aMapLocationServer.mo8475a() == 5 || aMapLocationServer.mo8475a() == 6) {
                i = 4;
            }
            aMapLocationServer.mo8481b(i);
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public final AMapLocation mo13058a(AMapLocation aMapLocation) {
        if (!C1079cp.m3508a(aMapLocation)) {
            return aMapLocation;
        }
        long c = C1079cp.m3529c() - this.f2680g;
        this.f2680g = C1079cp.m3529c();
        if (c > 5000) {
            return aMapLocation;
        }
        if (this.f2679f == null) {
            this.f2679f = aMapLocation;
            return aMapLocation;
        } else if (1 != this.f2679f.mo8475a() && !"gps".equalsIgnoreCase(this.f2679f.getProvider())) {
            this.f2679f = aMapLocation;
            return aMapLocation;
        } else if (this.f2679f.getAltitude() == aMapLocation.getAltitude() && this.f2679f.getLongitude() == aMapLocation.getLongitude()) {
            this.f2679f = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.f2679f.getTime());
            if (30000 < abs) {
                this.f2679f = aMapLocation;
                return aMapLocation;
            } else if (C1079cp.m3497a(aMapLocation, this.f2679f) > (((this.f2679f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f2679f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                return this.f2679f;
            } else {
                this.f2679f = aMapLocation;
                return aMapLocation;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        if (r11 < 30000) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012b, code lost:
        if ((r9 - r0.f2676c) > 30000) goto L_0x00d1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13059a(com.autonavi.aps.amapapi.model.AMapLocationServer r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            long r2 = com.loc.C1079cp.m3529c()
            long r4 = r0.f2678e
            long r2 = r2 - r4
            r4 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001c
            r0.f2674a = r1
            long r1 = com.loc.C1079cp.m3529c()
            r0.f2678e = r1
        L_0x0019:
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.f2674a
            return r1
        L_0x001c:
            long r2 = com.loc.C1079cp.m3529c()
            r0.f2678e = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.f2674a
            boolean r2 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)
            if (r2 == 0) goto L_0x0056
            boolean r2 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r21)
            if (r2 != 0) goto L_0x0031
            goto L_0x0056
        L_0x0031:
            long r2 = r21.getTime()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.f2674a
            long r6 = r6.getTime()
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            r3 = 1133903872(0x43960000, float:300.0)
            if (r2 != 0) goto L_0x004a
            float r2 = r21.getAccuracy()
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.String r2 = r21.getProvider()
            java.lang.String r6 = "gps"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x005f
        L_0x0056:
            long r2 = com.loc.C1079cp.m3529c()
            r0.f2675b = r2
        L_0x005c:
            r0.f2674a = r1
            goto L_0x0019
        L_0x005f:
            int r2 = r21.mo8795B()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.f2674a
            int r6 = r6.mo8795B()
            if (r2 == r6) goto L_0x006c
            goto L_0x0056
        L_0x006c:
            java.lang.String r2 = r21.mo8530r()
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.f2674a
            java.lang.String r6 = r6.mo8530r()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = r21.mo8530r()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0087
            goto L_0x0056
        L_0x0087:
            int r2 = r21.mo8475a()
            r0.f2677d = r2
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.f2674a
            float r2 = com.loc.C1079cp.m3497a((com.amap.api.location.AMapLocation) r1, (com.amap.api.location.AMapLocation) r2)
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r0.f2674a
            float r6 = r6.getAccuracy()
            float r7 = r21.getAccuracy()
            float r8 = r7 - r6
            long r9 = com.loc.C1079cp.m3529c()
            long r11 = r0.f2675b
            long r11 = r9 - r11
            r13 = 1120403456(0x42c80000, float:100.0)
            int r14 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            r15 = 1
            r16 = 0
            r17 = 1133871104(0x43958000, float:299.0)
            if (r14 > 0) goto L_0x00b9
            int r14 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x00b9
            r14 = 1
            goto L_0x00ba
        L_0x00b9:
            r14 = 0
        L_0x00ba:
            int r18 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x00c3
            int r19 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r15 = 0
        L_0x00c4:
            r4 = 0
            if (r14 != 0) goto L_0x011a
            if (r15 == 0) goto L_0x00cb
            goto L_0x011a
        L_0x00cb:
            int r13 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x00d9
            if (r18 <= 0) goto L_0x00d9
        L_0x00d1:
            r0.f2675b = r9
            r0.f2674a = r1
            r0.f2676c = r4
            goto L_0x0019
        L_0x00d9:
            int r13 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r13 > 0) goto L_0x00df
            r0.f2676c = r4
        L_0x00df:
            r4 = 1092616192(0x41200000, float:10.0)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x010e
            double r4 = (double) r2
            r13 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r2 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x010e
            r2 = 1084227584(0x40a00000, float:5.0)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x010e
            r2 = -1013579776(0xffffffffc3960000, float:-300.0)
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0103
        L_0x00fb:
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.f2674a
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r0.m3111b(r1)
            goto L_0x005c
        L_0x0103:
            float r6 = r6 / r7
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x00fb
            r0.f2675b = r9
            goto L_0x005c
        L_0x010e:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0056
            r2 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x00fb
            goto L_0x0056
        L_0x011a:
            long r2 = r0.f2676c
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0123
            r0.f2676c = r9
            goto L_0x00fb
        L_0x0123:
            long r2 = r0.f2676c
            long r2 = r9 - r2
            r6 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x00fb
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.LocFilter.mo13059a(com.autonavi.aps.amapapi.model.AMapLocationServer):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    public final void mo13060a() {
        this.f2674a = null;
        this.f2675b = 0;
        this.f2676c = 0;
        this.f2679f = null;
        this.f2680g = 0;
    }

    /* renamed from: a */
    public final void mo13061a(boolean z) {
        this.f2681h = z;
    }
}
