package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* renamed from: com.loc.aw */
public class StatisticsManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WeakReference<LogConfig> f2618a;

    /* renamed from: a */
    public static void m3065a(final Context context) {
        SDKLogHandler.m3869d().submit(new Runnable() {
            public final void run() {
                try {
                    LogConfig a = C1059ax.m3069a(StatisticsManager.f2618a);
                    C1059ax.m3071a(context, a, C1108h.f3353g, 1000, 307200, "2");
                    if (a.f2597g == null) {
                        a.f2597g = new ByteJoinDataStrategy(new StatisticsHeaderDataStrategy(context, new EncryptRsaDataStrategy(new StatisticsPubDataStrategy(new ZipUpdateDataStrategy()))));
                    }
                    a.f2598h = 3600000;
                    if (TextUtils.isEmpty(a.f2599i)) {
                        a.f2599i = "cKey";
                    }
                    if (a.f2596f == null) {
                        a.f2596f = new TimeUpdateStrategy(context, a.f2598h, a.f2599i, new FileNumUpdateStrategy(30, a.f2591a, new WiFiUplateStrategy(context)));
                    }
                    LogEngine.m3049a(a);
                } catch (Throwable th) {
                    SDKLogHandler.m3867b(th, Parameters.SENT_TIMESTAMP, "usd");
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m3066a(Context context, byte[] bArr) throws IOException {
        LogConfig a = C1059ax.m3069a(f2618a);
        C1059ax.m3071a(context, a, C1108h.f3353g, 1000, 307200, "2");
        if (a.f2595e == null) {
            a.f2595e = new NoneEncryptProcessor();
        }
        Random random = new Random();
        try {
            LogEngine.m3050a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a);
        } catch (Throwable th) {
            SDKLogHandler.m3867b(th, Parameters.SENT_TIMESTAMP, "wts");
        }
    }

    /* renamed from: a */
    public static synchronized void m3067a(final StatisticsEntity avVar, final Context context) {
        synchronized (StatisticsManager.class) {
            SDKLogHandler.m3869d().submit(new Runnable() {
                public final void run() {
                    try {
                        synchronized (StatisticsManager.class) {
                            StatisticsManager.m3066a(context, avVar.mo13035a());
                        }
                    } catch (Throwable th) {
                        SDKLogHandler.m3867b(th, Parameters.SENT_TIMESTAMP, AdvanceSetting.ADVANCE_SETTING);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r3.size() == 0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        com.loc.SDKLogHandler.m3869d().submit(new com.loc.StatisticsManager.C10572());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m3068a(final java.util.List<com.loc.StatisticsEntity> r3, final android.content.Context r4) {
        /*
            java.lang.Class<com.loc.aw> r0 = com.loc.StatisticsManager.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            int r1 = r3.size()     // Catch:{ Throwable -> 0x000e }
            if (r1 != 0) goto L_0x000e
            goto L_0x001e
        L_0x000c:
            r3 = move-exception
            goto L_0x001c
        L_0x000e:
            java.util.concurrent.ExecutorService r1 = com.loc.SDKLogHandler.m3869d()     // Catch:{ all -> 0x000c }
            com.loc.aw$2 r2 = new com.loc.aw$2     // Catch:{ all -> 0x000c }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x000c }
            r1.submit(r2)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)
            return
        L_0x001c:
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.StatisticsManager.m3068a(java.util.List, android.content.Context):void");
    }
}
