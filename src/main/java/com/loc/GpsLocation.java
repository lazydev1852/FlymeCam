package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.loc.ct */
public final class GpsLocation {

    /* renamed from: j */
    static AMapLocation f3114j;

    /* renamed from: k */
    static long f3115k;

    /* renamed from: l */
    static Object f3116l = new Object();

    /* renamed from: q */
    static long f3117q = 0;

    /* renamed from: t */
    static boolean f3118t = false;

    /* renamed from: u */
    static boolean f3119u = false;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public long f3120A = 0;

    /* renamed from: B */
    private int f3121B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f3122C = 0;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public GpsStatus f3123D = null;

    /* renamed from: E */
    private GpsStatus.Listener f3124E = new GpsStatus.Listener() {
        public final void onGpsStatusChanged(int i) {
            Iterable<GpsSatellite> satellites;
            try {
                if (GpsLocation.this.f3130b != null) {
                    GpsStatus unused = GpsLocation.this.f3123D = GpsLocation.this.f3130b.getGpsStatus(GpsLocation.this.f3123D);
                    int i2 = 0;
                    switch (i) {
                        case 2:
                            int unused2 = GpsLocation.this.f3122C = 0;
                            return;
                        case 3:
                            return;
                        case 4:
                            if (!(GpsLocation.this.f3123D == null || (satellites = GpsLocation.this.f3123D.getSatellites()) == null)) {
                                Iterator<GpsSatellite> it = satellites.iterator();
                                int maxSatellites = GpsLocation.this.f3123D.getMaxSatellites();
                                while (it.hasNext() && i2 < maxSatellites) {
                                    if (it.next().usedInFix()) {
                                        i2++;
                                    }
                                }
                            }
                            int unused3 = GpsLocation.this.f3122C = i2;
                            return;
                        default:
                            return;
                    }
                    CoreUtil.m3389a(th, "GpsLocation", "onGpsStatusChanged");
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: F */
    public String f3125F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f3126G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f3127H = 0;

    /* renamed from: I */
    private boolean f3128I = false;

    /* renamed from: a */
    Handler f3129a;

    /* renamed from: b */
    LocationManager f3130b;

    /* renamed from: c */
    AMapLocationClientOption f3131c;

    /* renamed from: d */
    long f3132d = 0;

    /* renamed from: e */
    boolean f3133e = false;

    /* renamed from: f */
    LocFilter f3134f = null;

    /* renamed from: g */
    int f3135g = 240;

    /* renamed from: h */
    int f3136h = 80;

    /* renamed from: i */
    AMapLocation f3137i = null;

    /* renamed from: m */
    long f3138m = 0;

    /* renamed from: n */
    float f3139n = 0.0f;

    /* renamed from: o */
    Object f3140o = new Object();

    /* renamed from: p */
    Object f3141p = new Object();

    /* renamed from: r */
    AMapLocationClientOption.GeoLanguage f3142r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s */
    boolean f3143s = true;

    /* renamed from: v */
    long f3144v = 0;

    /* renamed from: w */
    int f3145w = 0;

    /* renamed from: x */
    LocationListener f3146x = new LocationListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0139, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            com.loc.CoreUtil.m3389a(r10, "GpsLocation", "onLocationChangedLast");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x014a, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x014b, code lost:
            com.loc.CoreUtil.m3389a(r10, "GpsLocation", "onLocationChanged");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0152, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLocationChanged(android.location.Location r10) {
            /*
                r9 = this;
                com.loc.ct r0 = com.loc.GpsLocation.this
                android.os.Handler r0 = r0.f3129a
                if (r0 == 0) goto L_0x000f
                com.loc.ct r0 = com.loc.GpsLocation.this
                android.os.Handler r0 = r0.f3129a
                r1 = 8
                r0.removeMessages(r1)
            L_0x000f:
                if (r10 != 0) goto L_0x0012
                return
            L_0x0012:
                com.amap.api.location.AMapLocation r0 = new com.amap.api.location.AMapLocation     // Catch:{ Throwable -> 0x014a }
                r0.<init>((android.location.Location) r10)     // Catch:{ Throwable -> 0x014a }
                boolean r1 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                if (r1 != 0) goto L_0x001e
                return
            L_0x001e:
                java.lang.String r1 = "gps"
                r0.setProvider(r1)     // Catch:{ Throwable -> 0x014a }
                r1 = 1
                r0.mo8481b((int) r1)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                boolean r2 = r2.f3133e     // Catch:{ Throwable -> 0x014a }
                if (r2 != 0) goto L_0x0058
                boolean r2 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                if (r2 == 0) goto L_0x0058
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                android.content.Context r2 = r2.f3148z     // Catch:{ Throwable -> 0x014a }
                long r3 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r5 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                long r5 = r5.f3120A     // Catch:{ Throwable -> 0x014a }
                r7 = 0
                long r3 = r3 - r5
                double r5 = r0.getLatitude()     // Catch:{ Throwable -> 0x014a }
                double r7 = r0.getLongitude()     // Catch:{ Throwable -> 0x014a }
                boolean r5 = com.loc.CoreUtil.m3390a((double) r5, (double) r7)     // Catch:{ Throwable -> 0x014a }
                com.loc.ReportUtil.m3427a((android.content.Context) r2, (long) r3, (boolean) r5)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                r2.f3133e = r1     // Catch:{ Throwable -> 0x014a }
            L_0x0058:
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                int r2 = r2.f3122C     // Catch:{ Throwable -> 0x014a }
                boolean r2 = com.loc.C1079cp.m3507a((android.location.Location) r10, (int) r2)     // Catch:{ Throwable -> 0x014a }
                if (r2 == 0) goto L_0x00b2
                r0.mo8487c((boolean) r1)     // Catch:{ Throwable -> 0x014a }
                r2 = 4
                r0.mo8500g((int) r2)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.amap.api.location.AMapLocationClientOption r2 = r2.f3131c     // Catch:{ Throwable -> 0x014a }
                boolean r2 = r2.mo8550b()     // Catch:{ Throwable -> 0x014a }
                if (r2 != 0) goto L_0x00b7
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                int r10 = r10.f3145w     // Catch:{ Throwable -> 0x014a }
                r2 = 3
                if (r10 <= r2) goto L_0x00aa
                r10 = 2152(0x868, float:3.016E-42)
                r1 = 0
                com.loc.ReportUtil.m3435a((java.lang.String) r1, (int) r10)     // Catch:{ Throwable -> 0x014a }
                r10 = 15
                r0.mo8485c((int) r10)     // Catch:{ Throwable -> 0x014a }
                java.lang.String r10 = "GpsLocation has been mocked!#1501"
                r0.mo8478a((java.lang.String) r10)     // Catch:{ Throwable -> 0x014a }
                r2 = 0
                r0.setLatitude(r2)     // Catch:{ Throwable -> 0x014a }
                r0.setLongitude(r2)     // Catch:{ Throwable -> 0x014a }
                r0.setAltitude(r2)     // Catch:{ Throwable -> 0x014a }
                r10 = 0
                r0.setSpeed(r10)     // Catch:{ Throwable -> 0x014a }
                r0.setAccuracy(r10)     // Catch:{ Throwable -> 0x014a }
                r0.setBearing(r10)     // Catch:{ Throwable -> 0x014a }
                r0.setExtras(r1)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                r10.m3610c((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                return
            L_0x00aa:
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                int r0 = r10.f3145w     // Catch:{ Throwable -> 0x014a }
                int r0 = r0 + r1
                r10.f3145w = r0     // Catch:{ Throwable -> 0x014a }
                return
            L_0x00b2:
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                r2 = 0
                r1.f3145w = r2     // Catch:{ Throwable -> 0x014a }
            L_0x00b7:
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                int r1 = r1.f3122C     // Catch:{ Throwable -> 0x014a }
                r0.mo8490d((int) r1)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.loc.GpsLocation.m3608b(r1, r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.loc.GpsLocation.m3611c(r1, r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.loc.GpsLocation.m3607b((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.amap.api.location.AMapLocation r0 = com.loc.GpsLocation.m3612d(r1, r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                com.loc.GpsLocation.m3615e(r1, r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                r1.mo13221a((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                java.lang.Object r1 = r1.f3140o     // Catch:{ Throwable -> 0x014a }
                monitor-enter(r1)     // Catch:{ Throwable -> 0x014a }
                com.loc.ct r2 = com.loc.GpsLocation.this     // Catch:{ all -> 0x0147 }
                com.loc.ct r3 = com.loc.GpsLocation.this     // Catch:{ all -> 0x0147 }
                com.amap.api.location.AMapLocation r3 = r3.f3147y     // Catch:{ all -> 0x0147 }
                com.loc.GpsLocation.m3603a(r2, r0, r3)     // Catch:{ all -> 0x0147 }
                monitor-exit(r1)     // Catch:{ all -> 0x0147 }
                boolean r1 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x0139 }
                if (r1 == 0) goto L_0x0141
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                com.amap.api.location.AMapLocation r1 = r1.f3137i     // Catch:{ Throwable -> 0x0139 }
                if (r1 == 0) goto L_0x0118
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                long r2 = r10.getTime()     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                com.amap.api.location.AMapLocation r10 = r10.f3137i     // Catch:{ Throwable -> 0x0139 }
                long r4 = r10.getTime()     // Catch:{ Throwable -> 0x0139 }
                r10 = 0
                long r2 = r2 - r4
                r1.f3138m = r2     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                com.amap.api.location.AMapLocation r1 = r1.f3137i     // Catch:{ Throwable -> 0x0139 }
                float r1 = com.loc.C1079cp.m3497a((com.amap.api.location.AMapLocation) r1, (com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x0139 }
                r10.f3139n = r1     // Catch:{ Throwable -> 0x0139 }
            L_0x0118:
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                java.lang.Object r10 = r10.f3141p     // Catch:{ Throwable -> 0x0139 }
                monitor-enter(r10)     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r1 = com.loc.GpsLocation.this     // Catch:{ all -> 0x0136 }
                com.amap.api.location.AMapLocation r2 = r0.clone()     // Catch:{ all -> 0x0136 }
                r1.f3137i = r2     // Catch:{ all -> 0x0136 }
                monitor-exit(r10)     // Catch:{ all -> 0x0136 }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                java.lang.String unused = r10.f3125F = null     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                boolean unused = r10.f3126G = false     // Catch:{ Throwable -> 0x0139 }
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x0139 }
                int unused = r10.f3127H = 0     // Catch:{ Throwable -> 0x0139 }
                goto L_0x0141
            L_0x0136:
                r1 = move-exception
                monitor-exit(r10)     // Catch:{ Throwable -> 0x0139 }
                throw r1     // Catch:{ Throwable -> 0x0139 }
            L_0x0139:
                r10 = move-exception
                java.lang.String r1 = "GpsLocation"
                java.lang.String r2 = "onLocationChangedLast"
                com.loc.CoreUtil.m3389a(r10, r1, r2)     // Catch:{ Throwable -> 0x014a }
            L_0x0141:
                com.loc.ct r10 = com.loc.GpsLocation.this     // Catch:{ Throwable -> 0x014a }
                r10.m3610c((com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x014a }
                return
            L_0x0147:
                r10 = move-exception
                monitor-exit(r1)     // Catch:{ Throwable -> 0x014a }
                throw r10     // Catch:{ Throwable -> 0x014a }
            L_0x014a:
                r10 = move-exception
                java.lang.String r0 = "GpsLocation"
                java.lang.String r1 = "onLocationChanged"
                com.loc.CoreUtil.m3389a(r10, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.GpsLocation.C10841.onLocationChanged(android.location.Location):void");
        }

        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equalsIgnoreCase(str)) {
                    GpsLocation.this.f3132d = 0;
                    int unused = GpsLocation.this.f3122C = 0;
                }
            } catch (Throwable unused2) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                try {
                    GpsLocation.this.f3132d = 0;
                    int unused = GpsLocation.this.f3122C = 0;
                } catch (Throwable unused2) {
                }
            }
        }
    };

    /* renamed from: y */
    public AMapLocation f3147y = null;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Context f3148z;

    public GpsLocation(Context context, Handler handler) {
        this.f3148z = context;
        this.f3129a = handler;
        try {
            this.f3130b = (LocationManager) this.f3148z.getSystemService("location");
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "GpsLocation", "<init>");
        }
        this.f3134f = new LocFilter();
    }

    /* renamed from: a */
    private void m3601a(int i, int i2, String str, long j) {
        try {
            if (this.f3129a != null && this.f3131c.mo8559h() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.mo8485c(i2);
                aMapLocation.mo8478a(str);
                aMapLocation.mo8481b(1);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.f3129a.sendMessageDelayed(obtain, j);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3603a(GpsLocation ctVar, AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && ctVar.f3131c.mo8556e() && C1079cp.m3497a(aMapLocation, aMapLocation2) < ((float) ctVar.f3135g)) {
            CoreUtil.m3383a(aMapLocation, aMapLocation2);
        }
    }

    /* renamed from: a */
    private static boolean m3604a(LocationManager locationManager) {
        try {
            if (f3118t) {
                return f3119u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                f3119u = false;
            } else {
                f3119u = allProviders.contains("gps");
            }
            f3118t = true;
            return f3119u;
        } catch (Throwable unused) {
            return f3119u;
        }
    }

    /* renamed from: a */
    private boolean m3605a(String str) {
        try {
            ArrayList<String> d = C1079cp.m3536d(str);
            ArrayList<String> d2 = C1079cp.m3536d(this.f3125F);
            if (d == null || d.size() < 8 || d2 == null || d2.size() < 8) {
                return false;
            }
            return C1079cp.m3511a(this.f3125F, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m3607b(AMapLocation aMapLocation) {
        if (C1079cp.m3508a(aMapLocation) && AuthUtil.m3338E()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a = DateUtil.m3399a(time, currentTimeMillis, AuthUtil.m3339F());
            if (a != time) {
                aMapLocation.setTime(a);
                ReportUtil.m3424a(time, currentTimeMillis);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m3608b(GpsLocation ctVar, AMapLocation aMapLocation) {
        try {
            if (!CoreUtil.m3390a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !ctVar.f3131c.mo8566o()) {
                aMapLocation.mo8479a(false);
                aMapLocation.mo8531r("WGS84");
                return;
            }
            DPoint a = OffsetUtil.m3401a(ctVar.f3148z, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a.mo8585b());
            aMapLocation.setLongitude(a.mo8584a());
            aMapLocation.mo8479a(ctVar.f3131c.mo8566o());
            aMapLocation.mo8531r("GCJ02");
        } catch (Throwable unused) {
            aMapLocation.mo8479a(false);
            aMapLocation.mo8531r("WGS84");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3610c(AMapLocation aMapLocation) {
        if (aMapLocation.mo8484c() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f3131c.mo8559h())) {
            return;
        }
        if (this.f3131c.mo8559h().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f3131c.mo8573v() > 0.0f) {
            m3614d(aMapLocation);
        } else if (C1079cp.m3529c() - this.f3144v >= this.f3131c.mo8551c() - 200) {
            this.f3144v = C1079cp.m3529c();
            m3614d(aMapLocation);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3611c(GpsLocation ctVar, AMapLocation aMapLocation) {
        try {
            if (ctVar.f3122C >= 4) {
                aMapLocation.mo8476a(1);
            } else if (ctVar.f3122C == 0) {
                aMapLocation.mo8476a(-1);
            } else {
                aMapLocation.mo8476a(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    static /* synthetic */ AMapLocation m3612d(GpsLocation ctVar, AMapLocation aMapLocation) {
        if (!C1079cp.m3508a(aMapLocation) || ctVar.f3121B < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return ctVar.f3134f.mo13058a(aMapLocation);
    }

    /* renamed from: d */
    private void m3614d(AMapLocation aMapLocation) {
        if (this.f3129a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f3129a.sendMessage(obtain);
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m3615e(GpsLocation ctVar, AMapLocation aMapLocation) {
        if (C1079cp.m3508a(aMapLocation)) {
            ctVar.f3132d = C1079cp.m3529c();
            synchronized (f3116l) {
                f3115k = C1079cp.m3529c();
                f3114j = aMapLocation.clone();
            }
            ctVar.f3121B++;
        }
    }

    /* renamed from: g */
    private static boolean m3619g() {
        try {
            return ((Boolean) Reflect.m3414a(C1107dj.m3824c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), C1107dj.m3824c("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:15|16|(2:17|18)|21|22|23|24|25|26|29|30|31|32|33|34|(3:36|c7|41)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5 A[Catch:{ Throwable -> 0x00f2 }] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.location.AMapLocation m3620h() {
        /*
            r15 = this;
            r0 = 0
            com.amap.api.location.AMapLocation r1 = r15.f3137i     // Catch:{ Throwable -> 0x00f2 }
            boolean r1 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r1)     // Catch:{ Throwable -> 0x00f2 }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r1 = com.loc.AuthUtil.m3375t()     // Catch:{ Throwable -> 0x00f2 }
            if (r1 != 0) goto L_0x0011
            return r0
        L_0x0011:
            boolean r1 = m3619g()     // Catch:{ Throwable -> 0x00f2 }
            if (r1 == 0) goto L_0x00f2
            java.lang.String r1 = "KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="
            java.lang.String r1 = com.loc.C1107dj.m3824c((java.lang.String) r1)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r2 = "UZ2V0TmF2aUxvY2F0aW9u"
            java.lang.String r2 = com.loc.C1107dj.m3824c((java.lang.String) r2)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.Object r1 = com.loc.Reflect.m3414a((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r0, (java.lang.Class<?>[]) r0)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x00f2 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00f2 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "time"
            long r3 = r2.optLong(r1)     // Catch:{ Throwable -> 0x00f2 }
            boolean r1 = r15.f3128I     // Catch:{ Throwable -> 0x00f2 }
            if (r1 != 0) goto L_0x0042
            r1 = 1
            r15.f3128I = r1     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "useNaviLoc"
            java.lang.String r5 = "use NaviLoc"
            com.loc.ReportUtil.m3436a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ Throwable -> 0x00f2 }
        L_0x0042:
            long r5 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x00f2 }
            r1 = 0
            long r5 = r5 - r3
            r7 = 5500(0x157c, double:2.7174E-320)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x00f2
            java.lang.String r1 = "lat"
            r5 = 0
            double r7 = r2.optDouble(r1, r5)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r1 = "lng"
            double r9 = r2.optDouble(r1, r5)     // Catch:{ Throwable -> 0x00f2 }
            r1 = 0
            java.lang.String r11 = "accuracy"
            java.lang.String r12 = "0"
            java.lang.String r11 = r2.optString(r11, r12)     // Catch:{ NumberFormatException -> 0x006a }
            float r11 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x006a }
            goto L_0x006b
        L_0x006a:
            r11 = 0
        L_0x006b:
            java.lang.String r12 = "altitude"
            double r5 = r2.optDouble(r12, r5)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r12 = "bearing"
            java.lang.String r13 = "0"
            java.lang.String r12 = r2.optString(r12, r13)     // Catch:{ NumberFormatException -> 0x007e }
            float r12 = java.lang.Float.parseFloat(r12)     // Catch:{ NumberFormatException -> 0x007e }
            goto L_0x007f
        L_0x007e:
            r12 = 0
        L_0x007f:
            java.lang.String r13 = "speed"
            java.lang.String r14 = "0"
            java.lang.String r2 = r2.optString(r13, r14)     // Catch:{ NumberFormatException -> 0x0093 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0093 }
            r1 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 * r1
            r1 = 1108344832(0x42100000, float:36.0)
            float r1 = r2 / r1
        L_0x0093:
            com.amap.api.location.AMapLocation r2 = new com.amap.api.location.AMapLocation     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r13 = "lbs"
            r2.<init>((java.lang.String) r13)     // Catch:{ Throwable -> 0x00f2 }
            r13 = 9
            r2.mo8481b((int) r13)     // Catch:{ Throwable -> 0x00f2 }
            r2.setLatitude(r7)     // Catch:{ Throwable -> 0x00f2 }
            r2.setLongitude(r9)     // Catch:{ Throwable -> 0x00f2 }
            r2.setAccuracy(r11)     // Catch:{ Throwable -> 0x00f2 }
            r2.setAltitude(r5)     // Catch:{ Throwable -> 0x00f2 }
            r2.setBearing(r12)     // Catch:{ Throwable -> 0x00f2 }
            r2.setSpeed(r1)     // Catch:{ Throwable -> 0x00f2 }
            r2.setTime(r3)     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r5 = "GCJ02"
            r2.mo8531r(r5)     // Catch:{ Throwable -> 0x00f2 }
            com.amap.api.location.AMapLocation r5 = r15.f3137i     // Catch:{ Throwable -> 0x00f2 }
            float r5 = com.loc.C1079cp.m3497a((com.amap.api.location.AMapLocation) r2, (com.amap.api.location.AMapLocation) r5)     // Catch:{ Throwable -> 0x00f2 }
            r6 = 1133903872(0x43960000, float:300.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x00f2
            java.lang.Object r5 = r15.f3141p     // Catch:{ Throwable -> 0x00f2 }
            monitor-enter(r5)     // Catch:{ Throwable -> 0x00f2 }
            com.amap.api.location.AMapLocation r6 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r6.setLongitude(r9)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r6 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r6.setLatitude(r7)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r6 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r6.setAccuracy(r11)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r6 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r6.setBearing(r12)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r6 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r6.setSpeed(r1)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r1 = r15.f3137i     // Catch:{ all -> 0x00ef }
            r1.setTime(r3)     // Catch:{ all -> 0x00ef }
            com.amap.api.location.AMapLocation r1 = r15.f3137i     // Catch:{ all -> 0x00ef }
            java.lang.String r3 = "GCJ02"
            r1.mo8531r(r3)     // Catch:{ all -> 0x00ef }
            monitor-exit(r5)     // Catch:{ all -> 0x00ef }
            return r2
        L_0x00ef:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ Throwable -> 0x00f2 }
            throw r1     // Catch:{ Throwable -> 0x00f2 }
        L_0x00f2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.GpsLocation.m3620h():com.amap.api.location.AMapLocation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.location.AMapLocation mo13218a(com.amap.api.location.AMapLocation r16, java.lang.String r17) {
        /*
            r15 = this;
            r1 = r15
            r2 = r17
            com.amap.api.location.AMapLocation r3 = r1.f3137i
            if (r3 != 0) goto L_0x0008
            return r16
        L_0x0008:
            com.amap.api.location.AMapLocationClientOption r3 = r1.f3131c
            boolean r3 = r3.mo8550b()
            if (r3 != 0) goto L_0x0019
            com.amap.api.location.AMapLocation r3 = r1.f3137i
            boolean r3 = r3.mo8537u()
            if (r3 == 0) goto L_0x0019
            return r16
        L_0x0019:
            com.amap.api.location.AMapLocation r3 = r1.f3137i
            boolean r3 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r3)
            if (r3 != 0) goto L_0x0022
            return r16
        L_0x0022:
            com.amap.api.location.AMapLocation r3 = r15.m3620h()
            r4 = 2
            if (r3 == 0) goto L_0x0033
            boolean r5 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r3)
            if (r5 == 0) goto L_0x0033
            r3.mo8500g((int) r4)
            return r3
        L_0x0033:
            com.amap.api.location.AMapLocation r3 = r1.f3137i
            float r3 = r3.getSpeed()
            r5 = 0
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r7 = 0
            if (r6 != 0) goto L_0x005a
            long r9 = r1.f3138m
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x005a
            long r9 = r1.f3138m
            r11 = 8
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x005a
            float r6 = r1.f3139n
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x005a
            float r3 = r1.f3139n
            long r9 = r1.f3138m
            float r6 = (float) r9
            float r3 = r3 / r6
        L_0x005a:
            r6 = 0
            r9 = 30000(0x7530, double:1.4822E-319)
            if (r16 == 0) goto L_0x009e
            boolean r11 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r16)
            if (r11 == 0) goto L_0x009e
            float r11 = r16.getAccuracy()
            r12 = 1128792064(0x43480000, float:200.0)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            r12 = 1084227584(0x40a00000, float:5.0)
            if (r11 >= 0) goto L_0x008b
            int r11 = r1.f3127H
            r13 = 1
            int r11 = r11 + r13
            r1.f3127H = r11
            java.lang.String r11 = r1.f3125F
            if (r11 != 0) goto L_0x0081
            int r11 = r1.f3127H
            if (r11 < r4) goto L_0x0081
            r1.f3126G = r13
        L_0x0081:
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0088
            r11 = 10000(0x2710, double:4.9407E-320)
            goto L_0x009f
        L_0x0088:
            r11 = 15000(0x3a98, double:7.411E-320)
            goto L_0x009f
        L_0x008b:
            java.lang.String r11 = r1.f3125F
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0097
            r1.f3126G = r6
            r1.f3127H = r6
        L_0x0097:
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x009e
            r11 = 20000(0x4e20, double:9.8813E-320)
            goto L_0x009f
        L_0x009e:
            r11 = r9
        L_0x009f:
            long r13 = com.loc.C1079cp.m3529c()
            long r4 = r1.f3132d
            long r13 = r13 - r4
            int r3 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ab
            return r16
        L_0x00ab:
            int r3 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r3 < 0) goto L_0x00d8
            boolean r3 = r1.f3126G
            if (r3 == 0) goto L_0x00c4
            boolean r2 = r15.m3605a((java.lang.String) r2)
            if (r2 == 0) goto L_0x00c4
            com.amap.api.location.AMapLocation r0 = r1.f3137i
            com.amap.api.location.AMapLocation r0 = r0.clone()
            r2 = 3
            r0.mo8500g((int) r2)
            return r0
        L_0x00c4:
            r2 = 0
            r1.f3125F = r2
            r1.f3127H = r6
            java.lang.Object r3 = r1.f3141p
            monitor-enter(r3)
            r1.f3137i = r2     // Catch:{ all -> 0x00d5 }
            monitor-exit(r3)     // Catch:{ all -> 0x00d5 }
            r1.f3138m = r7
            r2 = 0
            r1.f3139n = r2
            return r16
        L_0x00d5:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x00d8:
            java.lang.String r0 = r1.f3125F
            if (r0 != 0) goto L_0x00e4
            int r0 = r1.f3127H
            r3 = 2
            if (r0 < r3) goto L_0x00e5
            r1.f3125F = r2
            goto L_0x00e5
        L_0x00e4:
            r3 = 2
        L_0x00e5:
            com.amap.api.location.AMapLocation r0 = r1.f3137i
            com.amap.api.location.AMapLocation r0 = r0.clone()
            r0.mo8500g((int) r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.GpsLocation.mo13218a(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|8|(1:10)|11|12|(1:14)|15|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A[Catch:{ Throwable -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[Catch:{ Throwable -> 0x0026 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13219a() {
        /*
            r4 = this;
            android.location.LocationManager r0 = r4.f3130b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.location.LocationListener r0 = r4.f3146x     // Catch:{ Throwable -> 0x0010 }
            if (r0 == 0) goto L_0x0010
            android.location.LocationManager r0 = r4.f3130b     // Catch:{ Throwable -> 0x0010 }
            android.location.LocationListener r1 = r4.f3146x     // Catch:{ Throwable -> 0x0010 }
            r0.removeUpdates(r1)     // Catch:{ Throwable -> 0x0010 }
        L_0x0010:
            android.location.GpsStatus$Listener r0 = r4.f3124E     // Catch:{ Throwable -> 0x001b }
            if (r0 == 0) goto L_0x001b
            android.location.LocationManager r0 = r4.f3130b     // Catch:{ Throwable -> 0x001b }
            android.location.GpsStatus$Listener r1 = r4.f3124E     // Catch:{ Throwable -> 0x001b }
            r0.removeGpsStatusListener(r1)     // Catch:{ Throwable -> 0x001b }
        L_0x001b:
            android.os.Handler r0 = r4.f3129a     // Catch:{ Throwable -> 0x0026 }
            if (r0 == 0) goto L_0x0026
            android.os.Handler r0 = r4.f3129a     // Catch:{ Throwable -> 0x0026 }
            r1 = 8
            r0.removeMessages(r1)     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            r0 = 0
            r4.f3122C = r0
            r1 = 0
            r4.f3120A = r1
            r4.f3144v = r1
            r4.f3132d = r1
            r4.f3121B = r0
            r4.f3145w = r0
            com.loc.bn r3 = r4.f3134f
            r3.mo13060a()
            r3 = 0
            r4.f3137i = r3
            r4.f3138m = r1
            r1 = 0
            r4.f3139n = r1
            r4.f3125F = r3
            r4.f3128I = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.GpsLocation.mo13219a():void");
    }

    /* renamed from: a */
    public final void mo13220a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f3135g = bundle.getInt("I_MAX_GEO_DIS");
                this.f3136h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (!TextUtils.isEmpty(aMapLocation.mo8518l())) {
                    synchronized (this.f3140o) {
                        this.f3147y = aMapLocation;
                    }
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo13221a(AMapLocation aMapLocation) {
        Handler handler;
        if (C1079cp.m3508a(aMapLocation) && this.f3129a != null && this.f3131c.mo8556e()) {
            long c = C1079cp.m3529c();
            if (this.f3131c.mo8551c() <= 8000 || c - this.f3144v > this.f3131c.mo8551c() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f3140o) {
                    if (this.f3147y == null) {
                        handler = this.f3129a;
                    } else if (C1079cp.m3497a(aMapLocation, this.f3147y) > ((float) this.f3136h)) {
                        handler = this.f3129a;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0100, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        r8.f3143s = false;
        com.loc.ReportUtil.m3435a((java.lang.String) null, 2121);
        m3601a(2, 12, r0.getMessage() + "#1201", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0099 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2 A[Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8 A[Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0100 A[ExcHandler: SecurityException (r0v0 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:10:0x0021] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13222a(com.amap.api.location.AMapLocationClientOption r9) {
        /*
            r8 = this;
            r8.f3131c = r9
            com.amap.api.location.AMapLocationClientOption r9 = r8.f3131c
            if (r9 != 0) goto L_0x000d
            com.amap.api.location.AMapLocationClientOption r9 = new com.amap.api.location.AMapLocationClientOption
            r9.<init>()
            r8.f3131c = r9
        L_0x000d:
            android.content.Context r9 = r8.f3148z     // Catch:{ Throwable -> 0x001b }
            java.lang.String r0 = "pref"
            java.lang.String r1 = "lagt"
            long r2 = f3117q     // Catch:{ Throwable -> 0x001b }
            long r0 = com.loc.SpUtil.m3491b((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r1, (long) r2)     // Catch:{ Throwable -> 0x001b }
            f3117q = r0     // Catch:{ Throwable -> 0x001b }
        L_0x001b:
            android.location.LocationManager r9 = r8.f3130b
            if (r9 != 0) goto L_0x0020
            return
        L_0x0020:
            r9 = 0
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            long r2 = f3115k     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r4 = 0
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0052
            com.amap.api.location.AMapLocation r0 = f3114j     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            boolean r0 = com.loc.C1079cp.m3508a((com.amap.api.location.AMapLocation) r0)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 == 0) goto L_0x0052
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            boolean r0 = r0.mo8550b()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 != 0) goto L_0x0047
            com.amap.api.location.AMapLocation r0 = f3114j     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            boolean r0 = r0.mo8537u()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 != 0) goto L_0x0052
        L_0x0047:
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r8.f3132d = r0     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            com.amap.api.location.AMapLocation r0 = f3114j     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r8.m3610c((com.amap.api.location.AMapLocation) r0)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        L_0x0052:
            r0 = 1
            r8.f3143s = r0     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 != 0) goto L_0x0061
            android.content.Context r0 = r8.f3148z     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            android.os.Looper r0 = r0.getMainLooper()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        L_0x0061:
            r7 = r0
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r8.f3120A = r0     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            android.location.LocationManager r0 = r8.f3130b     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            boolean r0 = m3604a((android.location.LocationManager) r0)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 == 0) goto L_0x00ea
            long r0 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            long r2 = f3117q     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            r4 = 0
            long r0 = r0 - r2
            r2 = 259200000(0xf731400, double:1.280618154E-315)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0099
            android.location.LocationManager r0 = r8.f3130b     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            java.lang.String r1 = "gps"
            java.lang.String r2 = "force_xtra_injection"
            r0.sendExtraCommand(r1, r2, r9)     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            long r0 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            f3117q = r0     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            android.content.Context r0 = r8.f3148z     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "lagt"
            long r3 = f3117q     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
            com.loc.SpUtil.m3486a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (long) r3)     // Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        L_0x0099:
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r0 = r0.mo8559h()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            boolean r0 = r0.equals(r1)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            if (r0 == 0) goto L_0x00c8
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            float r0 = r0.mo8573v()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c8
            android.location.LocationManager r1 = r8.f3130b     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            java.lang.String r2 = "gps"
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            long r3 = r0.mo8551c()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            float r5 = r0.mo8573v()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            android.location.LocationListener r6 = r8.f3146x     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        L_0x00c4:
            r1.requestLocationUpdates(r2, r3, r5, r6, r7)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            goto L_0x00d2
        L_0x00c8:
            android.location.LocationManager r1 = r8.f3130b     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            java.lang.String r2 = "gps"
            r3 = 900(0x384, double:4.447E-321)
            r5 = 0
            android.location.LocationListener r6 = r8.f3146x     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            goto L_0x00c4
        L_0x00d2:
            android.location.LocationManager r0 = r8.f3130b     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            android.location.GpsStatus$Listener r1 = r8.f3124E     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r0.addGpsStatusListener(r1)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r3 = 8
            r4 = 14
            java.lang.String r5 = "no enough satellites#1401"
            com.amap.api.location.AMapLocationClientOption r0 = r8.f3131c     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            long r6 = r0.mo8565n()     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            r2 = r8
            r2.m3601a(r3, r4, r5, r6)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            return
        L_0x00ea:
            r2 = 8
            r3 = 14
            java.lang.String r4 = "no gps provider#1402"
            r5 = 0
            r1 = r8
            r1.m3601a(r2, r3, r4, r5)     // Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
            return
        L_0x00f7:
            r9 = move-exception
            java.lang.String r0 = "GpsLocation"
            java.lang.String r1 = "requestLocationUpdates part2"
            com.loc.CoreUtil.m3389a(r9, r0, r1)
            return
        L_0x0100:
            r0 = move-exception
            r1 = 0
            r8.f3143s = r1
            r1 = 2121(0x849, float:2.972E-42)
            com.loc.ReportUtil.m3435a((java.lang.String) r9, (int) r1)
            r3 = 2
            r4 = 12
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = r0.getMessage()
            r9.append(r0)
            java.lang.String r0 = "#1201"
            r9.append(r0)
            java.lang.String r5 = r9.toString()
            r6 = 0
            r2 = r8
            r2.m3601a(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.GpsLocation.mo13222a(com.amap.api.location.AMapLocationClientOption):void");
    }

    /* renamed from: b */
    public final void mo13223b(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f3131c = aMapLocationClientOption;
        if (!(this.f3131c.mo8559h() == AMapLocationClientOption.AMapLocationMode.Device_Sensors || this.f3129a == null)) {
            this.f3129a.removeMessages(8);
        }
        if (this.f3142r != this.f3131c.mo8571t()) {
            synchronized (this.f3140o) {
                this.f3147y = null;
            }
        }
        this.f3142r = this.f3131c.mo8571t();
    }

    /* renamed from: b */
    public final boolean mo13224b() {
        return C1079cp.m3529c() - this.f3132d <= 2800;
    }

    /* renamed from: c */
    public final void mo13225c() {
        this.f3145w = 0;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public final int mo13226d() {
        if (this.f3130b == null || !m3604a(this.f3130b)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int i = Settings.Secure.getInt(this.f3148z.getContentResolver(), "location_mode", 0);
            if (i == 0) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
        } else if (!this.f3130b.isProviderEnabled("gps")) {
            return 2;
        }
        return !this.f3143s ? 4 : 0;
    }

    /* renamed from: e */
    public final int mo13227e() {
        return this.f3122C;
    }

    /* renamed from: f */
    public final boolean mo13228f() {
        return C1079cp.m3529c() - this.f3132d > 300000;
    }
}
