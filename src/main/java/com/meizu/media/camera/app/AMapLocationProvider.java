package com.meizu.media.camera.app;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.meizu.media.camera.app.a */
public class AMapLocationProvider implements LocationProvider {

    /* renamed from: a */
    public static ChangeQuickRedirect f7911a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final LogUtil.C2630a f7912d = new LogUtil.C2630a("AMapLocation");

    /* renamed from: b */
    public AMapLocationClient f7913b;

    /* renamed from: c */
    public AMapLocationClientOption f7914c = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Location f7915e;

    /* renamed from: f */
    private Context f7916f;

    /* renamed from: g */
    private AMapLocationListener f7917g = new AMapLocationListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7918a;

        /* renamed from: a */
        public void mo8598a(AMapLocation aMapLocation) {
            if (!PatchProxy.proxy(new Object[]{aMapLocation}, this, f7918a, false, 2497, new Class[]{AMapLocation.class}, Void.TYPE).isSupported) {
                if (aMapLocation.mo8484c() == 0) {
                    LogUtil.C2630a c = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c, "LocationType:" + aMapLocation.mo8475a(), true);
                    LogUtil.C2630a c2 = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c2, "Accuracy:" + aMapLocation.getAccuracy(), true);
                    LogUtil.C2630a c3 = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c3, "Address:" + aMapLocation.mo8499g(), true);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(aMapLocation.getTime());
                    LogUtil.C2630a c4 = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c4, "Location time:" + simpleDateFormat.format(date), true);
                    Location location = new Location(aMapLocation);
                    double[] a = AMapLocationProvider.this.m8271a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    location.setLatitude(a[0]);
                    location.setLongitude(a[1]);
                    Location unused = AMapLocationProvider.this.f7915e = location;
                    LogUtil.C2630a c5 = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c5, "Latitude:" + AMapLocationProvider.this.f7915e.getLatitude(), true);
                    LogUtil.C2630a c6 = AMapLocationProvider.f7912d;
                    LogUtil.m15944a(c6, "Longitude:" + AMapLocationProvider.this.f7915e.getLongitude(), true);
                    return;
                }
                LogUtil.C2630a c7 = AMapLocationProvider.f7912d;
                LogUtil.m15949b(c7, "location Error, ErrCode:" + aMapLocation.mo8484c() + ", errInfo:" + aMapLocation.mo8489d());
            }
        }
    };

    /* renamed from: b */
    private boolean m8274b(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    public AMapLocationProvider(Context context) {
        this.f7916f = context;
        this.f7914c = new AMapLocationClientOption();
        if (m8278d()) {
            LogUtil.m15942a(f7912d, "isNetworkAvailable true");
            this.f7914c.mo8546a(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
            this.f7914c.mo8552c(false);
        } else {
            LogUtil.m15942a(f7912d, "isNetworkAvailable false");
            this.f7914c.mo8546a(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            this.f7914c.mo8552c(true);
        }
        AMapLocationClientOption.m483e(false);
        this.f7914c.mo8545a(10000);
        this.f7914c.mo8549b(false);
        AsyncTaskEx.f13743q.execute(new Runnable(context) {
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AMapLocationProvider.this.m8270a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8270a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f7911a, false, 2496, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f7913b = new AMapLocationClient(context);
            this.f7913b.mo8594a(this.f7917g);
            this.f7913b.mo8593a(this.f7914c);
        }
    }

    /* renamed from: d */
    private boolean m8278d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7911a, false, 2488, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f7916f.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                return false;
            }
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public Location mo18999a() {
        return this.f7915e;
    }

    /* renamed from: a */
    public void mo19000a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7911a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2489, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            AsyncTaskEx.f13743q.execute(new Runnable(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AMapLocationProvider.this.m8273b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m8273b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7911a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2495, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f7913b == null) {
                this.f7913b = new AMapLocationClient(this.f7916f);
            }
            if (z) {
                this.f7913b.mo8593a(this.f7914c);
                this.f7913b.mo8592a();
                return;
            }
            this.f7913b.mo8595b();
        }
    }

    /* renamed from: b */
    public void mo19001b() {
        if (!PatchProxy.proxy(new Object[0], this, f7911a, false, 2490, new Class[0], Void.TYPE).isSupported) {
            if (this.f7913b != null) {
                this.f7913b.mo8597c();
            }
            this.f7913b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public double[] m8271a(double d, double d2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Double(d), new Double(d2)}, this, f7911a, false, 2491, new Class[]{Double.TYPE, Double.TYPE}, double[].class);
        if (proxy.isSupported) {
            return (double[]) proxy.result;
        }
        double[] e = m8279e(d, d2);
        return new double[]{(d * 2.0d) - e[0], (d2 * 2.0d) - e[1]};
    }

    /* renamed from: c */
    private double m8275c(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        Object[] objArr = {new Double(d3), new Double(d4)};
        ChangeQuickRedirect changeQuickRedirect = f7911a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2492, new Class[]{Double.TYPE, Double.TYPE}, Double.TYPE);
        if (proxy.isSupported) {
            return ((Double) proxy.result).doubleValue();
        }
        double d5 = d3 * 2.0d;
        double sqrt = -100.0d + d5 + (d4 * 3.0d) + (d4 * 0.2d * d4) + (0.1d * d3 * d4) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d3 * 6.0d) * 3.141592653589793d) * 20.0d) + (Math.sin(d5 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d6 = d4 * 3.141592653589793d;
        return sqrt + ((((Math.sin(d6) * 20.0d) + (Math.sin((d4 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d4 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d6 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: d */
    private double m8277d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        Object[] objArr = {new Double(d3), new Double(d4)};
        ChangeQuickRedirect changeQuickRedirect = f7911a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2493, new Class[]{Double.TYPE, Double.TYPE}, Double.TYPE);
        if (proxy.isSupported) {
            return ((Double) proxy.result).doubleValue();
        }
        double d5 = d3 * 0.1d;
        return d3 + 300.0d + (d4 * 2.0d) + (d5 * d3) + (d5 * d4) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d3) * 3.141592653589793d) * 20.0d) + (Math.sin((d3 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d3 * 3.141592653589793d) * 20.0d) + (Math.sin((d3 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d3 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d3 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: e */
    private double[] m8279e(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Double(d3), new Double(d4)}, this, f7911a, false, 2494, new Class[]{Double.TYPE, Double.TYPE}, double[].class);
        if (proxy.isSupported) {
            return (double[]) proxy.result;
        }
        if (m8274b(d, d2)) {
            return new double[]{d3, d4};
        }
        double d5 = d4 - 105.0d;
        double d6 = d3 - 35.0d;
        double c = m8275c(d5, d6);
        double d7 = m8277d(d5, d6);
        double d8 = (d3 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d8);
        double d9 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d9);
        double d10 = d3 + ((c * 180.0d) / ((6335552.717000426d / (d9 * sqrt)) * 3.141592653589793d));
        return new double[]{d10, ((d7 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d8)) * 3.141592653589793d)) + d4};
    }
}
