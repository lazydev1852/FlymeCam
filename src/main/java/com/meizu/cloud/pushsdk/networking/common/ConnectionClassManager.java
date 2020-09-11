package com.meizu.cloud.pushsdk.networking.common;

import com.meizu.cloud.pushsdk.networking.interfaces.ConnectionQualityChangeListener;

public class ConnectionClassManager {
    private static final long BANDWIDTH_LOWER_BOUND = 10;
    private static final int BYTES_TO_BITS = 8;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final int DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5;
    private static final int MINIMUM_SAMPLES_TO_DECIDE_QUALITY = 2;
    private static ConnectionClassManager sInstance;
    /* access modifiers changed from: private */
    public ConnectionQualityChangeListener mConnectionQualityChangeListener;
    /* access modifiers changed from: private */
    public int mCurrentBandwidth = 0;
    private int mCurrentBandwidthForSampling = 0;
    /* access modifiers changed from: private */
    public ConnectionQuality mCurrentConnectionQuality = ConnectionQuality.UNKNOWN;
    private int mCurrentNumberOfSample = 0;

    public static ConnectionClassManager getInstance() {
        if (sInstance == null) {
            synchronized (ConnectionClassManager.class) {
                if (sInstance == null) {
                    sInstance = new ConnectionClassManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateBandwidth(long r3, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x00a9
            r0 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00a9
            double r3 = (double) r3
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 * r0
            double r5 = (double) r5
            double r3 = r3 / r5
            r5 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r3 = r3 * r5
            r5 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0020
            goto L_0x00a9
        L_0x0020:
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            int r6 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            int r5 = r5 * r6
            double r5 = (double) r5     // Catch:{ all -> 0x00a6 }
            double r5 = r5 + r3
            int r3 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            int r3 = r3 + 1
            double r3 = (double) r3     // Catch:{ all -> 0x00a6 }
            double r5 = r5 / r3
            int r3 = (int) r5     // Catch:{ all -> 0x00a6 }
            r2.mCurrentBandwidthForSampling = r3     // Catch:{ all -> 0x00a6 }
            int r3 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            int r3 = r3 + 1
            r2.mCurrentNumberOfSample = r3     // Catch:{ all -> 0x00a6 }
            int r3 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            r4 = 5
            if (r3 == r4) goto L_0x0047
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r3 = r2.mCurrentConnectionQuality     // Catch:{ all -> 0x00a6 }
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.UNKNOWN     // Catch:{ all -> 0x00a6 }
            if (r3 != r5) goto L_0x00a4
            int r3 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            r5 = 2
            if (r3 != r5) goto L_0x00a4
        L_0x0047:
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r3 = r2.mCurrentConnectionQuality     // Catch:{ all -> 0x00a6 }
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            r2.mCurrentBandwidth = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            if (r5 > 0) goto L_0x0056
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.UNKNOWN     // Catch:{ all -> 0x00a6 }
            r2.mCurrentConnectionQuality = r5     // Catch:{ all -> 0x00a6 }
            goto L_0x007f
        L_0x0056:
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            r6 = 150(0x96, float:2.1E-43)
            if (r5 >= r6) goto L_0x0061
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.POOR     // Catch:{ all -> 0x00a6 }
            r2.mCurrentConnectionQuality = r5     // Catch:{ all -> 0x00a6 }
            goto L_0x007f
        L_0x0061:
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            r6 = 550(0x226, float:7.71E-43)
            if (r5 >= r6) goto L_0x006c
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.MODERATE     // Catch:{ all -> 0x00a6 }
            r2.mCurrentConnectionQuality = r5     // Catch:{ all -> 0x00a6 }
            goto L_0x007f
        L_0x006c:
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            r6 = 2000(0x7d0, float:2.803E-42)
            if (r5 >= r6) goto L_0x0077
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.GOOD     // Catch:{ all -> 0x00a6 }
            r2.mCurrentConnectionQuality = r5     // Catch:{ all -> 0x00a6 }
            goto L_0x007f
        L_0x0077:
            int r5 = r2.mCurrentBandwidthForSampling     // Catch:{ all -> 0x00a6 }
            if (r5 <= r6) goto L_0x007f
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r5 = com.meizu.cloud.pushsdk.networking.common.ConnectionQuality.EXCELLENT     // Catch:{ all -> 0x00a6 }
            r2.mCurrentConnectionQuality = r5     // Catch:{ all -> 0x00a6 }
        L_0x007f:
            int r5 = r2.mCurrentNumberOfSample     // Catch:{ all -> 0x00a6 }
            if (r5 != r4) goto L_0x0088
            r4 = 0
            r2.mCurrentBandwidthForSampling = r4     // Catch:{ all -> 0x00a6 }
            r2.mCurrentNumberOfSample = r4     // Catch:{ all -> 0x00a6 }
        L_0x0088:
            com.meizu.cloud.pushsdk.networking.common.ConnectionQuality r4 = r2.mCurrentConnectionQuality     // Catch:{ all -> 0x00a6 }
            if (r4 == r3) goto L_0x00a4
            com.meizu.cloud.pushsdk.networking.interfaces.ConnectionQualityChangeListener r3 = r2.mConnectionQualityChangeListener     // Catch:{ all -> 0x00a6 }
            if (r3 == 0) goto L_0x00a4
            com.meizu.cloud.pushsdk.networking.core.Core r3 = com.meizu.cloud.pushsdk.networking.core.Core.getInstance()     // Catch:{ all -> 0x00a6 }
            com.meizu.cloud.pushsdk.networking.core.ExecutorSupplier r3 = r3.getExecutorSupplier()     // Catch:{ all -> 0x00a6 }
            java.util.concurrent.Executor r3 = r3.forMainThreadTasks()     // Catch:{ all -> 0x00a6 }
            com.meizu.cloud.pushsdk.networking.common.ConnectionClassManager$1 r4 = new com.meizu.cloud.pushsdk.networking.common.ConnectionClassManager$1     // Catch:{ all -> 0x00a6 }
            r4.<init>()     // Catch:{ all -> 0x00a6 }
            r3.execute(r4)     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r2)
            return
        L_0x00a6:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x00a9:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.networking.common.ConnectionClassManager.updateBandwidth(long, long):void");
    }

    public int getCurrentBandwidth() {
        return this.mCurrentBandwidth;
    }

    public ConnectionQuality getCurrentConnectionQuality() {
        return this.mCurrentConnectionQuality;
    }

    public void setListener(ConnectionQualityChangeListener connectionQualityChangeListener) {
        this.mConnectionQualityChangeListener = connectionQualityChangeListener;
    }

    public void removeListener() {
        this.mConnectionQualityChangeListener = null;
    }

    public static void shutDown() {
        if (sInstance != null) {
            sInstance = null;
        }
    }
}
