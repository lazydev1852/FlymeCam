package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.util.Pair;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.FailureRestrict */
public class FailureRestrict {
    private static final String TAG = "FailureRestrict";
    private static final List<Pair<String, Long>> failRecords = new ArrayList();
    private static final Map<String, Long> forbids = new HashMap();

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x016f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x007d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean check(java.lang.String r15) {
        /*
            java.lang.Class<com.meizu.statsapp.v3.lib.plugin.utils.FailureRestrict> r0 = com.meizu.statsapp.p081v3.lib.plugin.utils.FailureRestrict.class
            monitor-enter(r0)
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r4.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r5 = "check "
            r4.append(r5)     // Catch:{ all -> 0x0170 }
            r4.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r5 = ", now: "
            r4.append(r5)     // Catch:{ all -> 0x0170 }
            r4.append(r1)     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x0170 }
            java.util.Map<java.lang.String, java.lang.Long> r3 = forbids     // Catch:{ all -> 0x0170 }
            boolean r3 = r3.containsKey(r15)     // Catch:{ all -> 0x0170 }
            r4 = 0
            if (r3 == 0) goto L_0x007e
            java.util.Map<java.lang.String, java.lang.Long> r3 = forbids     // Catch:{ all -> 0x0170 }
            java.lang.Object r3 = r3.get(r15)     // Catch:{ all -> 0x0170 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0170 }
            long r5 = r3.longValue()     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r7.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r8 = "forbid "
            r7.append(r8)     // Catch:{ all -> 0x0170 }
            r7.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r8 = ", forbidTime: "
            r7.append(r8)     // Catch:{ all -> 0x0170 }
            r7.append(r5)     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r7)     // Catch:{ all -> 0x0170 }
            r3 = 0
            long r1 = r1 - r5
            r5 = 300000(0x493e0, double:1.482197E-318)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x007c
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r2.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = "un forbid "
            r2.append(r3)     // Catch:{ all -> 0x0170 }
            r2.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r1, r2)     // Catch:{ all -> 0x0170 }
            java.util.Map<java.lang.String, java.lang.Long> r1 = forbids     // Catch:{ all -> 0x0170 }
            r1.remove(r15)     // Catch:{ all -> 0x0170 }
        L_0x007c:
            monitor-exit(r0)
            return r4
        L_0x007e:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0170 }
            r3.<init>()     // Catch:{ all -> 0x0170 }
            r5 = 0
            r8 = r5
            r10 = r8
            r7 = 0
        L_0x0088:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r12 = failRecords     // Catch:{ all -> 0x0170 }
            int r12 = r12.size()     // Catch:{ all -> 0x0170 }
            if (r7 >= r12) goto L_0x00dc
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r12 = failRecords     // Catch:{ all -> 0x0170 }
            java.lang.Object r12 = r12.get(r7)     // Catch:{ all -> 0x0170 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0170 }
            java.lang.Object r13 = r12.first     // Catch:{ all -> 0x0170 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0170 }
            boolean r13 = r13.equals(r15)     // Catch:{ all -> 0x0170 }
            if (r13 == 0) goto L_0x00d9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0170 }
            r3.add(r13)     // Catch:{ all -> 0x0170 }
            int r13 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r13 == 0) goto L_0x00b9
            java.lang.Object r13 = r12.second     // Catch:{ all -> 0x0170 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x0170 }
            long r13 = r13.longValue()     // Catch:{ all -> 0x0170 }
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x00c1
        L_0x00b9:
            java.lang.Object r8 = r12.second     // Catch:{ all -> 0x0170 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0170 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x0170 }
        L_0x00c1:
            int r13 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r13 == 0) goto L_0x00d1
            java.lang.Object r13 = r12.second     // Catch:{ all -> 0x0170 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x0170 }
            long r13 = r13.longValue()     // Catch:{ all -> 0x0170 }
            int r13 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r13 <= 0) goto L_0x00d9
        L_0x00d1:
            java.lang.Object r10 = r12.second     // Catch:{ all -> 0x0170 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0170 }
            long r10 = r10.longValue()     // Catch:{ all -> 0x0170 }
        L_0x00d9:
            int r7 = r7 + 1
            goto L_0x0088
        L_0x00dc:
            int r7 = r3.size()     // Catch:{ all -> 0x0170 }
            r12 = 2
            r13 = 1
            if (r7 < r12) goto L_0x016e
            java.lang.String r7 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r12.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r14 = "accumulate 2 fail records, methodKey: "
            r12.append(r14)     // Catch:{ all -> 0x0170 }
            r12.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r7, r12)     // Catch:{ all -> 0x0170 }
            int r7 = r3.size()     // Catch:{ all -> 0x0170 }
            int r7 = r7 - r13
        L_0x00ff:
            if (r7 < 0) goto L_0x0113
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r12 = failRecords     // Catch:{ all -> 0x0170 }
            java.lang.Object r14 = r3.get(r7)     // Catch:{ all -> 0x0170 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0170 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0170 }
            r12.remove(r14)     // Catch:{ all -> 0x0170 }
            int r7 = r7 + -1
            goto L_0x00ff
        L_0x0113:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r7.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r12 = "latest call: "
            r7.append(r12)     // Catch:{ all -> 0x0170 }
            r7.append(r10)     // Catch:{ all -> 0x0170 }
            java.lang.String r12 = ", earliest call: "
            r7.append(r12)     // Catch:{ all -> 0x0170 }
            r7.append(r8)     // Catch:{ all -> 0x0170 }
            java.lang.String r12 = ", methodKey: "
            r7.append(r12)     // Catch:{ all -> 0x0170 }
            r7.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r7)     // Catch:{ all -> 0x0170 }
            r3 = 0
            long r10 = r10 - r8
            int r3 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x016e
            r5 = 10000(0x2710, double:4.9407E-320)
            int r3 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x016e
            java.util.Map<java.lang.String, java.lang.Long> r3 = forbids     // Catch:{ all -> 0x0170 }
            java.lang.Long r5 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0170 }
            r3.put(r15, r5)     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r5.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.String r6 = "add to forbid: "
            r5.append(r6)     // Catch:{ all -> 0x0170 }
            r5.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r15 = ", now: "
            r5.append(r15)     // Catch:{ all -> 0x0170 }
            r5.append(r1)     // Catch:{ all -> 0x0170 }
            java.lang.String r15 = r5.toString()     // Catch:{ all -> 0x0170 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r15)     // Catch:{ all -> 0x0170 }
            monitor-exit(r0)
            return r4
        L_0x016e:
            monitor-exit(r0)
            return r13
        L_0x0170:
            r15 = move-exception
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.utils.FailureRestrict.check(java.lang.String):boolean");
    }

    public static synchronized void addFail(String str) {
        synchronized (FailureRestrict.class) {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = TAG;
            Logger.m17378d(str2, "addFail " + str + ", now: " + currentTimeMillis);
            failRecords.add(new Pair(str, Long.valueOf(currentTimeMillis)));
        }
    }
}
