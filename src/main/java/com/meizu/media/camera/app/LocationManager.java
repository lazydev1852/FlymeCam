package com.meizu.media.camera.app;

import android.content.Context;
import android.location.Location;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.app.e */
public class LocationManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7938a;

    /* renamed from: c */
    private static final LogUtil.C2630a f7939c = new LogUtil.C2630a("LocationManager");

    /* renamed from: b */
    LocationProvider f7940b;

    /* renamed from: d */
    private boolean f7941d;

    /* renamed from: e */
    private Location f7942e;

    public LocationManager(Context context) {
        LogUtil.m15942a(f7939c, "Using legacy location provider.");
        this.f7940b = new AMapLocationProvider(context);
    }

    /* renamed from: a */
    public void mo19019a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7938a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2526, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7941d = z;
            this.f7940b.mo19000a(this.f7941d);
        }
    }

    /* renamed from: a */
    public Location mo19017a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7938a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2527, new Class[]{Long.TYPE}, Location.class);
        if (proxy.isSupported) {
            return (Location) proxy.result;
        }
        this.f7942e = this.f7940b.mo18999a();
        if (!this.f7941d || this.f7942e == null) {
            return null;
        }
        this.f7942e.setTime(j);
        return this.f7942e;
    }

    /* renamed from: a */
    public void mo19018a() {
        if (!PatchProxy.proxy(new Object[0], this, f7938a, false, 2528, new Class[0], Void.TYPE).isSupported) {
            this.f7942e = null;
            this.f7940b.mo19001b();
        }
    }
}
