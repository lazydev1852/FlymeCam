package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* renamed from: com.loc.bo */
public final class AmapSensorManager implements SensorEventListener {

    /* renamed from: a */
    SensorManager f2682a = null;

    /* renamed from: b */
    Sensor f2683b = null;

    /* renamed from: c */
    Sensor f2684c = null;

    /* renamed from: d */
    Sensor f2685d = null;

    /* renamed from: e */
    public boolean f2686e = false;

    /* renamed from: f */
    public double f2687f = 0.0d;

    /* renamed from: g */
    public float f2688g = 0.0f;

    /* renamed from: h */
    Handler f2689h = new Handler() {
    };

    /* renamed from: i */
    double f2690i = 0.0d;

    /* renamed from: j */
    double f2691j = 0.0d;

    /* renamed from: k */
    double f2692k = 0.0d;

    /* renamed from: l */
    double f2693l = 0.0d;

    /* renamed from: m */
    double[] f2694m = new double[3];

    /* renamed from: n */
    volatile double f2695n = 0.0d;

    /* renamed from: o */
    long f2696o = 0;

    /* renamed from: p */
    long f2697p = 0;

    /* renamed from: q */
    final int f2698q = 100;

    /* renamed from: r */
    final int f2699r = 30;

    /* renamed from: s */
    private Context f2700s = null;

    /* renamed from: t */
    private float f2701t = 1013.25f;

    /* renamed from: u */
    private float f2702u = 0.0f;

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0068 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmapSensorManager(android.content.Context r5) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.f2700s = r0
            r4.f2682a = r0
            r4.f2683b = r0
            r4.f2684c = r0
            r4.f2685d = r0
            r0 = 0
            r4.f2686e = r0
            r0 = 0
            r4.f2687f = r0
            r2 = 0
            r4.f2688g = r2
            r3 = 1149063168(0x447d5000, float:1013.25)
            r4.f2701t = r3
            r4.f2702u = r2
            com.loc.bo$1 r2 = new com.loc.bo$1
            r2.<init>()
            r4.f2689h = r2
            r4.f2690i = r0
            r4.f2691j = r0
            r4.f2692k = r0
            r4.f2693l = r0
            r2 = 3
            double[] r2 = new double[r2]
            r4.f2694m = r2
            r4.f2695n = r0
            r0 = 0
            r4.f2696o = r0
            r4.f2697p = r0
            r0 = 100
            r4.f2698q = r0
            r0 = 30
            r4.f2699r = r0
            r4.f2700s = r5     // Catch:{ Throwable -> 0x0072 }
            android.hardware.SensorManager r5 = r4.f2682a     // Catch:{ Throwable -> 0x0072 }
            if (r5 != 0) goto L_0x0055
            android.content.Context r5 = r4.f2700s     // Catch:{ Throwable -> 0x0072 }
            java.lang.String r0 = "sensor"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ Throwable -> 0x0072 }
            android.hardware.SensorManager r5 = (android.hardware.SensorManager) r5     // Catch:{ Throwable -> 0x0072 }
            r4.f2682a = r5     // Catch:{ Throwable -> 0x0072 }
        L_0x0055:
            android.hardware.SensorManager r5 = r4.f2682a     // Catch:{ Throwable -> 0x005e }
            r0 = 6
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x005e }
            r4.f2683b = r5     // Catch:{ Throwable -> 0x005e }
        L_0x005e:
            android.hardware.SensorManager r5 = r4.f2682a     // Catch:{ Throwable -> 0x0068 }
            r0 = 11
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x0068 }
            r4.f2684c = r5     // Catch:{ Throwable -> 0x0068 }
        L_0x0068:
            android.hardware.SensorManager r5 = r4.f2682a     // Catch:{ Throwable -> 0x0071 }
            r0 = 1
            android.hardware.Sensor r5 = r5.getDefaultSensor(r0)     // Catch:{ Throwable -> 0x0071 }
            r4.f2685d = r5     // Catch:{ Throwable -> 0x0071 }
        L_0x0071:
            return
        L_0x0072:
            r5 = move-exception
            java.lang.String r0 = "AMapSensorManager"
            java.lang.String r1 = "<init>"
            com.loc.CoreUtil.m3389a(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapSensorManager.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public final void mo13062a() {
        if (this.f2682a != null && !this.f2686e) {
            this.f2686e = true;
            try {
                if (this.f2683b != null) {
                    this.f2682a.registerListener(this, this.f2683b, 3, this.f2689h);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AMapSensorManager", "registerListener mPressure");
            }
            try {
                if (this.f2684c != null) {
                    this.f2682a.registerListener(this, this.f2684c, 3, this.f2689h);
                }
            } catch (Throwable th2) {
                CoreUtil.m3389a(th2, "AMapSensorManager", "registerListener mRotationVector");
            }
            try {
                if (this.f2685d != null) {
                    this.f2682a.registerListener(this, this.f2685d, 3, this.f2689h);
                }
            } catch (Throwable th3) {
                CoreUtil.m3389a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ Throwable -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025 A[Catch:{ Throwable -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13063b() {
        /*
            r2 = this;
            android.hardware.SensorManager r0 = r2.f2682a
            if (r0 == 0) goto L_0x002c
            boolean r0 = r2.f2686e
            if (r0 == 0) goto L_0x002c
            r0 = 0
            r2.f2686e = r0
            android.hardware.Sensor r0 = r2.f2683b     // Catch:{ Throwable -> 0x0016 }
            if (r0 == 0) goto L_0x0016
            android.hardware.SensorManager r0 = r2.f2682a     // Catch:{ Throwable -> 0x0016 }
            android.hardware.Sensor r1 = r2.f2683b     // Catch:{ Throwable -> 0x0016 }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x0016 }
        L_0x0016:
            android.hardware.Sensor r0 = r2.f2684c     // Catch:{ Throwable -> 0x0021 }
            if (r0 == 0) goto L_0x0021
            android.hardware.SensorManager r0 = r2.f2682a     // Catch:{ Throwable -> 0x0021 }
            android.hardware.Sensor r1 = r2.f2684c     // Catch:{ Throwable -> 0x0021 }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x0021 }
        L_0x0021:
            android.hardware.Sensor r0 = r2.f2685d     // Catch:{ Throwable -> 0x002c }
            if (r0 == 0) goto L_0x002c
            android.hardware.SensorManager r0 = r2.f2682a     // Catch:{ Throwable -> 0x002c }
            android.hardware.Sensor r1 = r2.f2685d     // Catch:{ Throwable -> 0x002c }
            r0.unregisterListener(r2, r1)     // Catch:{ Throwable -> 0x002c }
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapSensorManager.mo13063b():void");
    }

    /* renamed from: c */
    public final double mo13064c() {
        return this.f2687f;
    }

    /* renamed from: d */
    public final float mo13065d() {
        return this.f2702u;
    }

    /* renamed from: e */
    public final double mo13066e() {
        return this.f2693l;
    }

    /* renamed from: f */
    public final void mo13067f() {
        try {
            mo13063b();
            this.f2683b = null;
            this.f2684c = null;
            this.f2682a = null;
            this.f2685d = null;
            this.f2686e = false;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapSensorManager", "destroy");
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSensorChanged(android.hardware.SensorEvent r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            android.hardware.Sensor r0 = r12.sensor     // Catch:{ Throwable -> 0x012e }
            int r0 = r0.getType()     // Catch:{ Throwable -> 0x012e }
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0078
            r1 = 6
            if (r0 == r1) goto L_0x0054
            r1 = 11
            if (r0 == r1) goto L_0x0016
            goto L_0x012e
        L_0x0016:
            android.hardware.Sensor r0 = r11.f2684c     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0053
            float[] r12 = r12.values     // Catch:{ Throwable -> 0x0053 }
            java.lang.Object r12 = r12.clone()     // Catch:{ Throwable -> 0x0053 }
            float[] r12 = (float[]) r12     // Catch:{ Throwable -> 0x0053 }
            if (r12 == 0) goto L_0x0053
            r0 = 9
            float[] r0 = new float[r0]     // Catch:{ Throwable -> 0x0053 }
            android.hardware.SensorManager.getRotationMatrixFromVector(r0, r12)     // Catch:{ Throwable -> 0x0053 }
            r12 = 3
            float[] r12 = new float[r12]     // Catch:{ Throwable -> 0x0053 }
            android.hardware.SensorManager.getOrientation(r0, r12)     // Catch:{ Throwable -> 0x0053 }
            r12 = r12[r2]     // Catch:{ Throwable -> 0x0053 }
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0053 }
            double r0 = java.lang.Math.toDegrees(r0)     // Catch:{ Throwable -> 0x0053 }
            float r12 = (float) r0     // Catch:{ Throwable -> 0x0053 }
            r11.f2702u = r12     // Catch:{ Throwable -> 0x0053 }
            float r12 = r11.f2702u     // Catch:{ Throwable -> 0x0053 }
            r0 = 0
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x0046
            float r12 = r11.f2702u     // Catch:{ Throwable -> 0x0053 }
        L_0x0044:
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0053 }
            goto L_0x004c
        L_0x0046:
            float r12 = r11.f2702u     // Catch:{ Throwable -> 0x0053 }
            r0 = 1135869952(0x43b40000, float:360.0)
            float r12 = r12 + r0
            goto L_0x0044
        L_0x004c:
            double r0 = java.lang.Math.floor(r0)     // Catch:{ Throwable -> 0x0053 }
            float r12 = (float) r0     // Catch:{ Throwable -> 0x0053 }
            r11.f2702u = r12     // Catch:{ Throwable -> 0x0053 }
        L_0x0053:
            return
        L_0x0054:
            android.hardware.Sensor r0 = r11.f2683b     // Catch:{ Throwable -> 0x0077 }
            if (r0 == 0) goto L_0x0077
            float[] r12 = r12.values     // Catch:{ Throwable -> 0x0077 }
            java.lang.Object r12 = r12.clone()     // Catch:{ Throwable -> 0x0077 }
            float[] r12 = (float[]) r12     // Catch:{ Throwable -> 0x0077 }
            if (r12 == 0) goto L_0x0066
            r0 = r12[r2]     // Catch:{ Throwable -> 0x0077 }
            r11.f2688g = r0     // Catch:{ Throwable -> 0x0077 }
        L_0x0066:
            if (r12 == 0) goto L_0x0077
            float r0 = r11.f2701t     // Catch:{ Throwable -> 0x0077 }
            r12 = r12[r2]     // Catch:{ Throwable -> 0x0077 }
            float r12 = android.hardware.SensorManager.getAltitude(r0, r12)     // Catch:{ Throwable -> 0x0077 }
            float r12 = com.loc.C1079cp.m3496a((float) r12)     // Catch:{ Throwable -> 0x0077 }
            double r0 = (double) r12     // Catch:{ Throwable -> 0x0077 }
            r11.f2687f = r0     // Catch:{ Throwable -> 0x0077 }
        L_0x0077:
            return
        L_0x0078:
            android.hardware.Sensor r0 = r11.f2685d     // Catch:{  }
            if (r0 == 0) goto L_0x012e
            float[] r12 = r12.values     // Catch:{  }
            java.lang.Object r12 = r12.clone()     // Catch:{  }
            float[] r12 = (float[]) r12     // Catch:{  }
            double[] r0 = r11.f2694m     // Catch:{  }
            double[] r3 = r11.f2694m     // Catch:{  }
            r4 = r3[r2]     // Catch:{  }
            r6 = 4605380979056443392(0x3fe99999a0000000, double:0.800000011920929)
            double r4 = r4 * r6
            r3 = r12[r2]     // Catch:{  }
            r8 = 1045220556(0x3e4ccccc, float:0.19999999)
            float r3 = r3 * r8
            double r9 = (double) r3     // Catch:{  }
            double r4 = r4 + r9
            r0[r2] = r4     // Catch:{  }
            double[] r0 = r11.f2694m     // Catch:{  }
            double[] r3 = r11.f2694m     // Catch:{  }
            r4 = r3[r1]     // Catch:{  }
            double r4 = r4 * r6
            r3 = r12[r1]     // Catch:{  }
            float r3 = r3 * r8
            double r9 = (double) r3     // Catch:{  }
            double r4 = r4 + r9
            r0[r1] = r4     // Catch:{  }
            double[] r0 = r11.f2694m     // Catch:{  }
            double[] r3 = r11.f2694m     // Catch:{  }
            r4 = 2
            r9 = r3[r4]     // Catch:{  }
            double r9 = r9 * r6
            r3 = r12[r4]     // Catch:{  }
            float r3 = r3 * r8
            double r5 = (double) r3     // Catch:{  }
            double r9 = r9 + r5
            r0[r4] = r9     // Catch:{  }
            r0 = r12[r2]     // Catch:{  }
            double r5 = (double) r0     // Catch:{  }
            double[] r0 = r11.f2694m     // Catch:{  }
            r2 = r0[r2]     // Catch:{  }
            r0 = 0
            double r5 = r5 - r2
            r11.f2690i = r5     // Catch:{  }
            r0 = r12[r1]     // Catch:{  }
            double r2 = (double) r0     // Catch:{  }
            double[] r0 = r11.f2694m     // Catch:{  }
            r5 = r0[r1]     // Catch:{  }
            r0 = 0
            double r2 = r2 - r5
            r11.f2691j = r2     // Catch:{  }
            r12 = r12[r4]     // Catch:{  }
            double r0 = (double) r12     // Catch:{  }
            double[] r12 = r11.f2694m     // Catch:{  }
            r2 = r12[r4]     // Catch:{  }
            r12 = 0
            double r0 = r0 - r2
            r11.f2692k = r0     // Catch:{  }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{  }
            long r2 = r11.f2696o     // Catch:{  }
            r12 = 0
            long r2 = r0 - r2
            r4 = 100
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x012e
            double r2 = r11.f2690i     // Catch:{  }
            double r4 = r11.f2690i     // Catch:{  }
            double r2 = r2 * r4
            double r4 = r11.f2691j     // Catch:{  }
            double r6 = r11.f2691j     // Catch:{  }
            double r4 = r4 * r6
            r12 = 0
            double r2 = r2 + r4
            double r4 = r11.f2692k     // Catch:{  }
            double r6 = r11.f2692k     // Catch:{  }
            double r4 = r4 * r6
            r12 = 0
            double r2 = r2 + r4
            double r2 = java.lang.Math.sqrt(r2)     // Catch:{  }
            long r4 = r11.f2697p     // Catch:{  }
            r6 = 1
            long r4 = r4 + r6
            r11.f2697p = r4     // Catch:{  }
            r11.f2696o = r0     // Catch:{  }
            double r0 = r11.f2695n     // Catch:{  }
            r12 = 0
            double r0 = r0 + r2
            r11.f2695n = r0     // Catch:{  }
            long r0 = r11.f2697p     // Catch:{  }
            r2 = 30
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x012e
            double r0 = r11.f2695n     // Catch:{  }
            long r2 = r11.f2697p     // Catch:{  }
            double r2 = (double) r2     // Catch:{  }
            double r0 = r0 / r2
            r11.f2693l = r0     // Catch:{  }
            r0 = 0
            r11.f2695n = r0     // Catch:{  }
            r0 = 0
            r11.f2697p = r0     // Catch:{  }
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapSensorManager.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
