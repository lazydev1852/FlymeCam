package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.InvokerRestrict */
public class InvokerRestrict {
    private static final String TAG = "InvokerRestrict";
    private static final Map<String, Long> forbids = new HashMap();
    private static final List<Pair<String, Long>> invokeRecords = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0193, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean check() {
        /*
            java.lang.Class<com.meizu.statsapp.v3.lib.plugin.utils.InvokerRestrict> r1 = com.meizu.statsapp.p081v3.lib.plugin.utils.InvokerRestrict.class
            monitor-enter(r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0194 }
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()     // Catch:{ all -> 0x0194 }
            int r2 = r0.length     // Catch:{ all -> 0x0194 }
            r3 = 1
            r4 = 3
            if (r2 < r4) goto L_0x0192
            r2 = r0[r4]     // Catch:{ all -> 0x0194 }
            java.lang.String r2 = r2.getClassName()     // Catch:{ all -> 0x0194 }
            r0 = r0[r4]     // Catch:{ all -> 0x0194 }
            java.lang.String r0 = r0.getMethodName()     // Catch:{ all -> 0x0194 }
            java.lang.String r4 = "com.meizu.statsapp.v3"
            boolean r4 = r2.contains(r4)     // Catch:{ all -> 0x0194 }
            if (r4 == 0) goto L_0x0192
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r4.<init>()     // Catch:{ all -> 0x0194 }
            r4.append(r2)     // Catch:{ all -> 0x0194 }
            java.lang.String r2 = "."
            r4.append(r2)     // Catch:{ all -> 0x0194 }
            r4.append(r0)     // Catch:{ all -> 0x0194 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0194 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0194 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r6.<init>()     // Catch:{ all -> 0x0194 }
            java.lang.String r7 = "check for methodKey: "
            r6.append(r7)     // Catch:{ all -> 0x0194 }
            r6.append(r0)     // Catch:{ all -> 0x0194 }
            java.lang.String r7 = ", now: "
            r6.append(r7)     // Catch:{ all -> 0x0194 }
            r6.append(r4)     // Catch:{ all -> 0x0194 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0194 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r6)     // Catch:{ all -> 0x0194 }
            java.util.Map<java.lang.String, java.lang.Long> r2 = forbids     // Catch:{ all -> 0x0194 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0194 }
            r6 = 0
            if (r2 == 0) goto L_0x009c
            java.util.Map<java.lang.String, java.lang.Long> r2 = forbids     // Catch:{ all -> 0x0194 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0194 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0194 }
            long r2 = r2.longValue()     // Catch:{ all -> 0x0194 }
            java.lang.String r7 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r8.<init>()     // Catch:{ all -> 0x0194 }
            java.lang.String r9 = "forbidTime: "
            r8.append(r9)     // Catch:{ all -> 0x0194 }
            r8.append(r2)     // Catch:{ all -> 0x0194 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0194 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r7, r8)     // Catch:{ all -> 0x0194 }
            r7 = 0
            long r4 = r4 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x009a
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.String r3 = "un forbid"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r3)     // Catch:{ all -> 0x0194 }
            java.util.Map<java.lang.String, java.lang.Long> r2 = forbids     // Catch:{ all -> 0x0194 }
            r2.remove(r0)     // Catch:{ all -> 0x0194 }
        L_0x009a:
            monitor-exit(r1)
            return r6
        L_0x009c:
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x0194 }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0194 }
            r2.<init>(r0, r7)     // Catch:{ all -> 0x0194 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r7 = invokeRecords     // Catch:{ all -> 0x0194 }
            r7.add(r2)     // Catch:{ all -> 0x0194 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0194 }
            r2.<init>()     // Catch:{ all -> 0x0194 }
            r7 = 0
            r10 = r7
            r12 = r10
            r9 = 0
        L_0x00b4:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r14 = invokeRecords     // Catch:{ all -> 0x0194 }
            int r14 = r14.size()     // Catch:{ all -> 0x0194 }
            if (r9 >= r14) goto L_0x0108
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r14 = invokeRecords     // Catch:{ all -> 0x0194 }
            java.lang.Object r14 = r14.get(r9)     // Catch:{ all -> 0x0194 }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x0194 }
            java.lang.Object r15 = r14.first     // Catch:{ all -> 0x0194 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0194 }
            boolean r15 = r15.equals(r0)     // Catch:{ all -> 0x0194 }
            if (r15 == 0) goto L_0x0105
            java.lang.Integer r15 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0194 }
            r2.add(r15)     // Catch:{ all -> 0x0194 }
            int r15 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r15 == 0) goto L_0x00e5
            java.lang.Object r15 = r14.second     // Catch:{ all -> 0x0194 }
            java.lang.Long r15 = (java.lang.Long) r15     // Catch:{ all -> 0x0194 }
            long r15 = r15.longValue()     // Catch:{ all -> 0x0194 }
            int r15 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x00ed
        L_0x00e5:
            java.lang.Object r10 = r14.second     // Catch:{ all -> 0x0194 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0194 }
            long r10 = r10.longValue()     // Catch:{ all -> 0x0194 }
        L_0x00ed:
            int r15 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r15 == 0) goto L_0x00fd
            java.lang.Object r15 = r14.second     // Catch:{ all -> 0x0194 }
            java.lang.Long r15 = (java.lang.Long) r15     // Catch:{ all -> 0x0194 }
            long r15 = r15.longValue()     // Catch:{ all -> 0x0194 }
            int r15 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x0105
        L_0x00fd:
            java.lang.Object r12 = r14.second     // Catch:{ all -> 0x0194 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0194 }
            long r12 = r12.longValue()     // Catch:{ all -> 0x0194 }
        L_0x0105:
            int r9 = r9 + 1
            goto L_0x00b4
        L_0x0108:
            int r9 = r2.size()     // Catch:{ all -> 0x0194 }
            r14 = 10
            if (r9 < r14) goto L_0x0192
            java.lang.String r9 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r14.<init>()     // Catch:{ all -> 0x0194 }
            java.lang.String r15 = "accumulate 10 calls, methodKey: "
            r14.append(r15)     // Catch:{ all -> 0x0194 }
            r14.append(r0)     // Catch:{ all -> 0x0194 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0194 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r9, r14)     // Catch:{ all -> 0x0194 }
            int r9 = r2.size()     // Catch:{ all -> 0x0194 }
            int r9 = r9 - r3
        L_0x012b:
            if (r9 < 0) goto L_0x013f
            java.util.List<android.util.Pair<java.lang.String, java.lang.Long>> r14 = invokeRecords     // Catch:{ all -> 0x0194 }
            java.lang.Object r15 = r2.get(r9)     // Catch:{ all -> 0x0194 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x0194 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x0194 }
            r14.remove(r15)     // Catch:{ all -> 0x0194 }
            int r9 = r9 + -1
            goto L_0x012b
        L_0x013f:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r9.<init>()     // Catch:{ all -> 0x0194 }
            java.lang.String r14 = "latest call: "
            r9.append(r14)     // Catch:{ all -> 0x0194 }
            r9.append(r12)     // Catch:{ all -> 0x0194 }
            java.lang.String r14 = ", earliest call: "
            r9.append(r14)     // Catch:{ all -> 0x0194 }
            r9.append(r10)     // Catch:{ all -> 0x0194 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0194 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r9)     // Catch:{ all -> 0x0194 }
            r2 = 0
            long r12 = r12 - r10
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0192
            r7 = 10000(0x2710, double:4.9407E-320)
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0192
            java.util.Map<java.lang.String, java.lang.Long> r2 = forbids     // Catch:{ all -> 0x0194 }
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0194 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0194 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0194 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
            r3.<init>()     // Catch:{ all -> 0x0194 }
            java.lang.String r7 = "add to forbid: "
            r3.append(r7)     // Catch:{ all -> 0x0194 }
            r3.append(r0)     // Catch:{ all -> 0x0194 }
            java.lang.String r0 = ", "
            r3.append(r0)     // Catch:{ all -> 0x0194 }
            r3.append(r4)     // Catch:{ all -> 0x0194 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0194 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r0)     // Catch:{ all -> 0x0194 }
            monitor-exit(r1)
            return r6
        L_0x0192:
            monitor-exit(r1)
            return r3
        L_0x0194:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.utils.InvokerRestrict.check():boolean");
    }
}
