package com.baidu.p020ar.p021a.p022a.p025c;

import android.os.Bundle;
import com.baidu.p020ar.p021a.p031c.C0507a;
import com.baidu.p020ar.track2d.AR2DJniClient;
import com.baidu.p020ar.util.ARLog;

/* renamed from: com.baidu.ar.a.a.c.b */
public class C0497b {

    /* renamed from: a */
    boolean f581a = false;

    /* renamed from: b */
    private C0496a f582b = new C0496a();

    /* renamed from: c */
    private C0498c f583c;

    /* renamed from: d */
    private int f584d = -1;

    /* renamed from: e */
    private boolean f585e = false;

    /* renamed from: f */
    private boolean f586f = false;

    /* renamed from: g */
    private final Object f587g = new Object();

    /* renamed from: h */
    private C0507a f588h;

    /* renamed from: i */
    private int[] f589i = new int[2];

    public C0497b(C0498c cVar) {
        this.f583c = cVar;
        this.f588h = new C0507a();
    }

    /* renamed from: a */
    private float m883a(int i, int i2, float f) {
        if (Float.isNaN(f)) {
            return f;
        }
        return (f * 500.0f) / ((float) Math.sqrt((double) ((i * i) + (i2 * i2))));
    }

    /* renamed from: a */
    private float m884a(boolean z, float[] fArr) {
        if (!z || fArr == null) {
            return Float.NaN;
        }
        return m883a(this.f583c.f592c, this.f583c.f593d, (float) Math.sqrt((double) ((fArr[9] * fArr[9]) + (fArr[10] * fArr[10]) + (fArr[11] * fArr[11]))));
    }

    /* renamed from: a */
    private boolean m885a(int i, int i2) {
        try {
            float[] b = m887b(i, i2);
            String str = this.f583c.f591b;
            System.currentTimeMillis();
            int arInit = AR2DJniClient.arInit(i, i2, b, str);
            if (arInit != 1) {
                AR2DJniClient.arRelease();
            }
            return arInit == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private Bundle m886b(byte[] bArr, int i, int i2) {
        Bundle bundle = new Bundle();
        float[] fArr = new float[12];
        long currentTimeMillis = System.currentTimeMillis();
        int arTracking = AR2DJniClient.arTracking(bArr, fArr);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        boolean z = this.f584d == 1 && arTracking == 1;
        int a = z ? this.f588h.mo8973a((int) currentTimeMillis2) : 0;
        boolean a2 = this.f582b.mo8954a(z);
        boolean a3 = this.f582b.mo8953a();
        boolean b = this.f582b.mo8955b();
        this.f584d = arTracking;
        this.f585e = z;
        if (!AR2DJniClient.arGetMarkerSize(this.f589i)) {
            ARLog.m2696e("arGetMarkerSize--fail");
        } else {
            this.f583c.f592c = this.f589i[0];
            this.f583c.f593d = this.f589i[1];
        }
        float a4 = m884a(z, fArr);
        bundle.putInt("track2D_method_type", 1);
        bundle.putInt("result", arTracking);
        bundle.putLong("time", currentTimeMillis2);
        bundle.putFloat("distance", a4);
        bundle.putBoolean("isTracked", z);
        bundle.putBoolean("isTrackStatusValid", a2);
        bundle.putBoolean("trackedFromTrackLost", a3);
        bundle.putBoolean("trackLostFromTracked", b);
        bundle.putFloatArray("RTMatrix", fArr);
        bundle.putInt("averageTime", a);
        return bundle;
    }

    /* renamed from: b */
    private float[] m887b(int i, int i2) {
        float f = (float) i;
        float f2 = f / 2.0f;
        float f3 = (f * 600.0f) / 640.0f;
        return new float[]{f3, 0.0f, f2, 0.0f, f3, ((float) i2) / 2.0f, 0.0f, 0.0f, 1.0f};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle mo8957a(byte[] r4, int r5, int r6) {
        /*
            r3 = this;
            boolean r0 = r3.f586f
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            if (r4 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r3.f587g
            monitor-enter(r0)
            boolean r2 = r3.f581a     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0033
            boolean r4 = r3.f586f     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r1
        L_0x0016:
            com.baidu.ar.a.a.c.c r4 = r3.f583c     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0037
            boolean r4 = r3.m885a((int) r5, (int) r6)     // Catch:{ all -> 0x0039 }
            r3.f581a = r4     // Catch:{ all -> 0x0039 }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "track2D_method_type"
            r5 = 0
            r1.putInt(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "result"
            boolean r5 = r3.f581a     // Catch:{ all -> 0x0039 }
            r1.putBoolean(r4, r5)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        L_0x0033:
            android.os.Bundle r1 = r3.m886b(r4, r5, r6)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r1
        L_0x0039:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.p021a.p022a.p025c.C0497b.mo8957a(byte[], int, int):android.os.Bundle");
    }

    /* renamed from: a */
    public void mo8958a() {
        synchronized (this.f587g) {
            this.f586f = true;
            if (this.f581a) {
                AR2DJniClient.arRelease();
            }
            this.f581a = false;
        }
        this.f582b.mo8956c();
        this.f584d = -1;
        if (this.f585e) {
            this.f585e = false;
        }
        if (this.f588h != null) {
            this.f588h.mo8974a();
        }
    }
}
