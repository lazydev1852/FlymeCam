package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;

/* renamed from: com.amap.api.location.c */
public class AMapLocationQualityReport implements Cloneable {

    /* renamed from: a */
    AMapLocationClientOption.AMapLocationMode f243a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: b */
    private boolean f244b = false;

    /* renamed from: c */
    private int f245c = 2;

    /* renamed from: d */
    private int f246d = 0;

    /* renamed from: e */
    private String f247e = "UNKNOWN";

    /* renamed from: f */
    private long f248f = 0;

    /* renamed from: g */
    private boolean f249g = false;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        com.loc.CoreUtil.m3389a(r1, "AMapLocationQualityReport", "clone");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.location.AMapLocationQualityReport clone() {
        /*
            r4 = this;
            com.amap.api.location.c r0 = new com.amap.api.location.c
            r0.<init>()
            super.clone()     // Catch:{ Throwable -> 0x0008 }
        L_0x0008:
            int r1 = r4.f245c     // Catch:{ Throwable -> 0x002c }
            r0.mo8600a((int) r1)     // Catch:{ Throwable -> 0x002c }
            int r1 = r4.f246d     // Catch:{ Throwable -> 0x002c }
            r0.mo8605b((int) r1)     // Catch:{ Throwable -> 0x002c }
            boolean r1 = r4.f244b     // Catch:{ Throwable -> 0x002c }
            r0.mo8604a((boolean) r1)     // Catch:{ Throwable -> 0x002c }
            long r1 = r4.f248f     // Catch:{ Throwable -> 0x002c }
            r0.mo8601a((long) r1)     // Catch:{ Throwable -> 0x002c }
            java.lang.String r1 = r4.f247e     // Catch:{ Throwable -> 0x002c }
            r0.mo8603a((java.lang.String) r1)     // Catch:{ Throwable -> 0x002c }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = r4.f243a     // Catch:{ Throwable -> 0x002c }
            r0.mo8602a((com.amap.api.location.AMapLocationClientOption.AMapLocationMode) r1)     // Catch:{ Throwable -> 0x002c }
            boolean r1 = r4.f249g     // Catch:{ Throwable -> 0x002c }
            r0.mo8606b((boolean) r1)     // Catch:{ Throwable -> 0x002c }
            goto L_0x0034
        L_0x002c:
            r1 = move-exception
            java.lang.String r2 = "AMapLocationQualityReport"
            java.lang.String r3 = "clone"
            com.loc.CoreUtil.m3389a(r1, r2, r3)
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocationQualityReport.clone():com.amap.api.location.c");
    }

    /* renamed from: a */
    public void mo8600a(int i) {
        this.f245c = i;
    }

    /* renamed from: a */
    public void mo8601a(long j) {
        this.f248f = j;
    }

    /* renamed from: a */
    public void mo8602a(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f243a = aMapLocationMode;
    }

    /* renamed from: a */
    public void mo8603a(String str) {
        this.f247e = str;
    }

    /* renamed from: a */
    public void mo8604a(boolean z) {
        this.f244b = z;
    }

    /* renamed from: b */
    public void mo8605b(int i) {
        this.f246d = i;
    }

    /* renamed from: b */
    public void mo8606b(boolean z) {
        this.f249g = z;
    }
}
