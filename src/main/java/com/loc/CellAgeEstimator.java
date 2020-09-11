package com.loc;

import java.util.HashMap;

/* renamed from: com.loc.bp */
public final class CellAgeEstimator {

    /* renamed from: a */
    private HashMap<Long, Cgi> f2704a = new HashMap<>();

    /* renamed from: b */
    private long f2705b = 0;

    /* renamed from: a */
    private static long m3122a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    /* renamed from: a */
    public final long mo13070a(Cgi bqVar) {
        long j;
        int i;
        int i2;
        if (bqVar == null || !bqVar.f2721p) {
            return 0;
        }
        HashMap<Long, Cgi> hashMap = this.f2704a;
        switch (bqVar.f2716k) {
            case 1:
            case 3:
            case 4:
                i2 = bqVar.f2708c;
                i = bqVar.f2709d;
                break;
            case 2:
                i2 = bqVar.f2713h;
                i = bqVar.f2714i;
                break;
            default:
                j = 0;
                break;
        }
        j = m3122a(i2, i);
        Cgi bqVar2 = hashMap.get(Long.valueOf(j));
        if (bqVar2 == null) {
            bqVar.f2718m = C1079cp.m3529c();
            hashMap.put(Long.valueOf(j), bqVar);
            return 0;
        } else if (bqVar2.f2715j != bqVar.f2715j) {
            bqVar.f2718m = C1079cp.m3529c();
            hashMap.put(Long.valueOf(j), bqVar);
            return 0;
        } else {
            bqVar.f2718m = bqVar2.f2718m;
            hashMap.put(Long.valueOf(j), bqVar);
            return (C1079cp.m3529c() - bqVar2.f2718m) / 1000;
        }
    }

    /* renamed from: a */
    public final void mo13071a() {
        this.f2704a.clear();
        this.f2705b = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005b A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13072a(java.util.ArrayList<? extends com.loc.Cgi> r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0090
            long r0 = com.loc.C1079cp.m3529c()
            long r2 = r12.f2705b
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            long r2 = r12.f2705b
            long r2 = r0 - r2
            r6 = 60000(0xea60, double:2.9644E-319)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x001a
            return
        L_0x001a:
            java.util.HashMap<java.lang.Long, com.loc.bq> r2 = r12.f2704a
            int r3 = r13.size()
            r6 = 0
            r7 = r4
            r4 = 0
        L_0x0023:
            if (r4 >= r3) goto L_0x005e
            java.lang.Object r5 = r13.get(r4)
            com.loc.bq r5 = (com.loc.Cgi) r5
            boolean r9 = r5.f2721p
            if (r9 == 0) goto L_0x005b
            int r9 = r5.f2716k
            switch(r9) {
                case 1: goto L_0x003a;
                case 2: goto L_0x0035;
                case 3: goto L_0x003a;
                case 4: goto L_0x003a;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0042
        L_0x0035:
            int r7 = r5.f2713h
            int r8 = r5.f2714i
            goto L_0x003e
        L_0x003a:
            int r7 = r5.f2708c
            int r8 = r5.f2709d
        L_0x003e:
            long r7 = m3122a(r7, r8)
        L_0x0042:
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
            java.lang.Object r9 = r2.get(r9)
            com.loc.bq r9 = (com.loc.Cgi) r9
            if (r9 == 0) goto L_0x005b
            int r10 = r9.f2715j
            int r11 = r5.f2715j
            if (r10 != r11) goto L_0x0059
            long r9 = r9.f2718m
            r5.f2718m = r9
            goto L_0x005b
        L_0x0059:
            r5.f2718m = r0
        L_0x005b:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x005e:
            r2.clear()
            int r3 = r13.size()
        L_0x0065:
            if (r6 >= r3) goto L_0x008e
            java.lang.Object r4 = r13.get(r6)
            com.loc.bq r4 = (com.loc.Cgi) r4
            boolean r5 = r4.f2721p
            if (r5 == 0) goto L_0x008b
            int r5 = r4.f2716k
            switch(r5) {
                case 1: goto L_0x007c;
                case 2: goto L_0x0077;
                case 3: goto L_0x007c;
                case 4: goto L_0x007c;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0084
        L_0x0077:
            int r5 = r4.f2713h
            int r7 = r4.f2714i
            goto L_0x0080
        L_0x007c:
            int r5 = r4.f2708c
            int r7 = r4.f2709d
        L_0x0080:
            long r7 = m3122a(r5, r7)
        L_0x0084:
            java.lang.Long r5 = java.lang.Long.valueOf(r7)
            r2.put(r5, r4)
        L_0x008b:
            int r6 = r6 + 1
            goto L_0x0065
        L_0x008e:
            r12.f2705b = r0
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CellAgeEstimator.mo13072a(java.util.ArrayList):void");
    }
}
