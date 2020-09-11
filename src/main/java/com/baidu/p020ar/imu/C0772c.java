package com.baidu.p020ar.imu;

import android.hardware.SensorManager;
import com.baidu.p020ar.arplay.representation.Quaternion;
import com.baidu.p020ar.util.ARLog;
import java.util.Arrays;

/* renamed from: com.baidu.ar.imu.c */
public class C0772c extends C0777f {

    /* renamed from: k */
    private final Quaternion f1730k = new Quaternion();

    /* renamed from: l */
    private Quaternion f1731l = new Quaternion();

    /* renamed from: m */
    private Quaternion f1732m = new Quaternion();

    /* renamed from: n */
    private long f1733n;

    /* renamed from: o */
    private double f1734o = 0.0d;

    /* renamed from: p */
    private boolean f1735p = false;

    /* renamed from: q */
    private int f1736q;

    /* renamed from: r */
    private int f1737r = 0;

    public C0772c(SensorManager sensorManager) {
        super(sensorManager);
        this.f1753d.add(sensorManager.getDefaultSensor(4));
        this.f1753d.add(sensorManager.getDefaultSensor(11));
    }

    /* renamed from: a */
    private void m2021a(Quaternion quaternion) {
        Quaternion clone = quaternion.clone();
        clone.mo9391w(-clone.mo9390w());
        synchronized (this.f1752c) {
            this.f1755f.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.f1754e.matrix, clone.toArray());
            mo10135a();
            this.f1737r++;
            if (this.f1737r > 100) {
                setChanged();
            } else if (!m2023f()) {
                setChanged();
            }
            notifyObservers();
        }
    }

    /* renamed from: a */
    public static void m2022a(float[] fArr, float[] fArr2) {
        if (fArr2.length >= 4) {
            fArr[0] = fArr2[3];
        } else {
            fArr[0] = ((1.0f - (fArr2[0] * fArr2[0])) - (fArr2[1] * fArr2[1])) - (fArr2[2] * fArr2[2]);
            float f = 0.0f;
            if (fArr[0] > 0.0f) {
                f = (float) Math.sqrt((double) fArr[0]);
            }
            fArr[0] = f;
        }
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[1];
        fArr[3] = fArr2[2];
    }

    /* renamed from: f */
    private boolean m2023f() {
        return ((double) Math.abs(1.0f - this.f1759j.matrix[0])) < 0.001d && ((double) Math.abs(1.0f - this.f1759j.matrix[5])) < 0.001d && ((double) Math.abs(1.0f - this.f1759j.matrix[10])) < 0.001d && ((double) Math.abs(1.0f - this.f1759j.matrix[15])) < 0.001d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10135a() {
        String str;
        StringBuilder sb;
        if (this.f1756g) {
            m2041a(this.f1758i.matrix, this.f1754e.matrix, this.f1757h.matrix);
            m2043c(this.f1759j.matrix, this.f1758i.matrix);
            sb = new StringBuilder();
            str = "orientation provider2: ";
        } else if (m2042b(this.f1757h.matrix, this.f1754e.matrix)) {
            this.f1756g = true;
            m2041a(this.f1758i.matrix, this.f1754e.matrix, this.f1757h.matrix);
            m2043c(this.f1759j.matrix, this.f1758i.matrix);
            sb = new StringBuilder();
            str = "orientation provider1: ";
        } else {
            return;
        }
        sb.append(str);
        sb.append(Arrays.toString(this.f1758i.matrix));
        sb.append("\n");
        ARLog.m2695d(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r0 = new float[4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        android.hardware.SensorManager.getQuaternionFromVector(r0, r13.values);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        m2022a(r0, r13.values);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0077, code lost:
        if (r12.f1733n == 0) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
        r0 = ((float) (r13.timestamp - r12.f1733n)) * 1.0E-9f;
        r2 = r13.values[0];
        r5 = r13.values[1];
        r1 = r13.values[2];
        r12.f1734o = java.lang.Math.sqrt((double) (((r2 * r2) + (r5 * r5)) + (r1 * r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        if (r12.f1734o <= 0.10000000149011612d) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        r2 = (float) (((double) r2) / r12.f1734o);
        r5 = (float) (((double) r5) / r12.f1734o);
        r1 = (float) (((double) r1) / r12.f1734o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        r12.f1734o = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00be, code lost:
        r6 = (r12.f1734o * ((double) r0)) / 2.0d;
        r8 = java.lang.Math.sin(r6);
        r6 = java.lang.Math.cos(r6);
        r12.f1730k.setX((float) (((double) r2) * r8));
        r12.f1730k.setY((float) (((double) r5) * r8));
        r12.f1730k.setZ((float) (r8 * ((double) r1)));
        r12.f1730k.setW(-((float) r6));
        r12.f1730k.multiplyByQuat(r12.f1731l, r12.f1731l);
        r0 = r12.f1731l.dotProduct(r12.f1732m);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0108, code lost:
        if (java.lang.Math.abs(r0) >= 0.0f) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0110, code lost:
        if (java.lang.Math.abs(r0) >= 0.0f) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0112, code lost:
        r12.f1736q++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0117, code lost:
        m2021a(r12.f1731l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011d, code lost:
        r0 = new com.baidu.p020ar.arplay.representation.Quaternion();
        r12.f1731l.slerp(r12.f1732m, r0, (float) (r12.f1734o * 0.009999999776482582d));
        m2021a(r0);
        r12.f1731l.copyVec4(r0);
        r12.f1736q = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0141, code lost:
        if (r12.f1736q <= 60) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0143, code lost:
        com.baidu.p020ar.util.ARLog.m2695d("Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014e, code lost:
        if (r12.f1734o >= 3.0d) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0150, code lost:
        com.baidu.p020ar.util.ARLog.m2695d("Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
        m2021a(r12.f1732m);
        r12.f1731l.copyVec4(r12.f1732m);
        r12.f1736q = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0164, code lost:
        com.baidu.p020ar.util.ARLog.m2695d("Rotation Vector" + java.lang.String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", new java.lang.Object[]{java.lang.Double.valueOf(r12.f1734o)}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0188, code lost:
        r12.f1733n = r13.timestamp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r13) {
        /*
            r12 = this;
            android.hardware.Sensor r0 = r13.sensor
            int r0 = r0.getType()
            r1 = 2
            r2 = 4
            r3 = 1
            r4 = 0
            r5 = 11
            if (r0 != r5) goto L_0x005b
            java.lang.Object r0 = r12.f1750a
            monitor-enter(r0)
            r5 = 0
        L_0x0012:
            float[] r6 = r13.values     // Catch:{ all -> 0x0058 }
            int r6 = r6.length     // Catch:{ all -> 0x0058 }
            if (r5 >= r6) goto L_0x002c
            float[] r6 = r13.values     // Catch:{ all -> 0x0058 }
            r6 = r6[r5]     // Catch:{ all -> 0x0058 }
            boolean r6 = java.lang.Float.isNaN(r6)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x0029
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0058 }
            r12.f1751b = r13     // Catch:{ all -> 0x0058 }
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            return
        L_0x0029:
            int r5 = r5 + 1
            goto L_0x0012
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            float[] r0 = new float[r2]
            float[] r2 = r13.values     // Catch:{ Exception -> 0x0035 }
            android.hardware.SensorManager.getQuaternionFromVector(r0, r2)     // Catch:{ Exception -> 0x0035 }
            goto L_0x003a
        L_0x0035:
            float[] r13 = r13.values
            m2022a(r0, r13)
        L_0x003a:
            com.baidu.ar.arplay.representation.Quaternion r13 = r12.f1732m
            r2 = r0[r3]
            r1 = r0[r1]
            r5 = 3
            r5 = r0[r5]
            r0 = r0[r4]
            float r0 = -r0
            r13.setXYZW(r2, r1, r5, r0)
            boolean r13 = r12.f1735p
            if (r13 != 0) goto L_0x0190
            com.baidu.ar.arplay.representation.Quaternion r13 = r12.f1731l
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1732m
            r13.set(r0)
            r12.f1735p = r3
            goto L_0x0190
        L_0x0058:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r13
        L_0x005b:
            android.hardware.Sensor r0 = r13.sensor
            int r0 = r0.getType()
            if (r0 != r2) goto L_0x0190
            java.lang.Object r0 = r12.f1750a
            monitor-enter(r0)
            java.lang.Boolean r2 = r12.f1751b     // Catch:{ all -> 0x018d }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x018d }
            if (r2 != 0) goto L_0x0070
            monitor-exit(r0)     // Catch:{ all -> 0x018d }
            return
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x018d }
            long r5 = r12.f1733n
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0188
            long r5 = r13.timestamp
            long r7 = r12.f1733n
            long r5 = r5 - r7
            float r0 = (float) r5
            r2 = 814313567(0x3089705f, float:1.0E-9)
            float r0 = r0 * r2
            float[] r2 = r13.values
            r2 = r2[r4]
            float[] r5 = r13.values
            r5 = r5[r3]
            float[] r6 = r13.values
            r1 = r6[r1]
            float r6 = r2 * r2
            float r7 = r5 * r5
            float r6 = r6 + r7
            float r7 = r1 * r1
            float r6 = r6 + r7
            double r6 = (double) r6
            double r6 = java.lang.Math.sqrt(r6)
            r12.f1734o = r6
            double r6 = r12.f1734o
            r8 = 4591870180174331904(0x3fb99999a0000000, double:0.10000000149011612)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ba
            double r6 = (double) r2
            double r8 = r12.f1734o
            double r6 = r6 / r8
            float r2 = (float) r6
            double r5 = (double) r5
            double r7 = r12.f1734o
            double r5 = r5 / r7
            float r5 = (float) r5
            double r6 = (double) r1
            double r8 = r12.f1734o
            double r6 = r6 / r8
            float r1 = (float) r6
            goto L_0x00be
        L_0x00ba:
            r6 = 0
            r12.f1734o = r6
        L_0x00be:
            double r6 = r12.f1734o
            double r8 = (double) r0
            double r6 = r6 * r8
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r6 / r8
            double r8 = java.lang.Math.sin(r6)
            double r6 = java.lang.Math.cos(r6)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1730k
            double r10 = (double) r2
            double r10 = r10 * r8
            float r2 = (float) r10
            r0.setX(r2)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1730k
            double r10 = (double) r5
            double r10 = r10 * r8
            float r2 = (float) r10
            r0.setY(r2)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1730k
            double r1 = (double) r1
            double r8 = r8 * r1
            float r1 = (float) r8
            r0.setZ(r1)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1730k
            float r1 = (float) r6
            float r1 = -r1
            r0.setW(r1)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1730k
            com.baidu.ar.arplay.representation.Quaternion r1 = r12.f1731l
            com.baidu.ar.arplay.representation.Quaternion r2 = r12.f1731l
            r0.multiplyByQuat(r1, r2)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1731l
            com.baidu.ar.arplay.representation.Quaternion r1 = r12.f1732m
            float r0 = r0.dotProduct(r1)
            float r1 = java.lang.Math.abs(r0)
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x011d
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0117
            int r0 = r12.f1736q
            int r0 = r0 + r3
            r12.f1736q = r0
        L_0x0117:
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1731l
            r12.m2021a(r0)
            goto L_0x013d
        L_0x011d:
            com.baidu.ar.arplay.representation.Quaternion r0 = new com.baidu.ar.arplay.representation.Quaternion
            r0.<init>()
            com.baidu.ar.arplay.representation.Quaternion r1 = r12.f1731l
            com.baidu.ar.arplay.representation.Quaternion r2 = r12.f1732m
            r5 = 4576918229175238656(0x3f847ae140000000, double:0.009999999776482582)
            double r7 = r12.f1734o
            double r7 = r7 * r5
            float r5 = (float) r7
            r1.slerp(r2, r0, r5)
            r12.m2021a(r0)
            com.baidu.ar.arplay.representation.Quaternion r1 = r12.f1731l
            r1.copyVec4(r0)
            r12.f1736q = r4
        L_0x013d:
            int r0 = r12.f1736q
            r1 = 60
            if (r0 <= r1) goto L_0x0188
            java.lang.String r0 = "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent."
            com.baidu.p020ar.util.ARLog.m2695d(r0)
            double r0 = r12.f1734o
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0164
            java.lang.String r0 = "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value."
            com.baidu.p020ar.util.ARLog.m2695d(r0)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1732m
            r12.m2021a(r0)
            com.baidu.ar.arplay.representation.Quaternion r0 = r12.f1731l
            com.baidu.ar.arplay.representation.Quaternion r1 = r12.f1732m
            r0.copyVec4(r1)
            r12.f1736q = r4
            goto L_0x0188
        L_0x0164:
            java.lang.String r0 = "Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3"
            java.lang.Object[] r1 = new java.lang.Object[r3]
            double r2 = r12.f1734o
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r1[r4] = r2
            java.lang.String r0 = java.lang.String.format(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Rotation Vector"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.baidu.p020ar.util.ARLog.m2695d(r0)
        L_0x0188:
            long r0 = r13.timestamp
            r12.f1733n = r0
            goto L_0x0190
        L_0x018d:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018d }
            throw r13
        L_0x0190:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.imu.C0772c.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
