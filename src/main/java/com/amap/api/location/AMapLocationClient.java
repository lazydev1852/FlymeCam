package com.amap.api.location;

import android.content.Context;
import android.content.Intent;
import com.loc.AmapLocationManager;
import com.loc.C1107dj;
import com.loc.CoreUtil;
import com.loc.InstanceFactory;
import com.loc.RollBackDynamic;
import com.loc.SDKInfo;

/* renamed from: com.amap.api.location.a */
public class AMapLocationClient {

    /* renamed from: a */
    Context f241a;

    /* renamed from: b */
    LocationManagerBase f242b;

    public AMapLocationClient(Context context) {
        if (context != null) {
            try {
                this.f241a = context.getApplicationContext();
                this.f242b = m518a(this.f241a, (Intent) null);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    /* renamed from: a */
    private static LocationManagerBase m518a(Context context, Intent intent) {
        LocationManagerBase eVar;
        try {
            SDKInfo b = CoreUtil.m3392b();
            RollBackDynamic.m3479a(context, b);
            boolean c = RollBackDynamic.m3482c(context);
            RollBackDynamic.m3477a(context);
            if (c) {
                eVar = (LocationManagerBase) InstanceFactory.m3966a(context, b, C1107dj.m3824c("IY29tLmFtYXAuYXBpLmxvY2F0aW9uLkxvY2F0aW9uTWFuYWdlcldyYXBwZXI="), AmapLocationManager.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
            } else {
                eVar = new AmapLocationManager(context, intent);
            }
        } catch (Throwable unused) {
            eVar = new AmapLocationManager(context, intent);
        }
        return eVar == null ? new AmapLocationManager(context, intent) : eVar;
    }

    /* renamed from: a */
    public void mo8592a() {
        try {
            if (this.f242b != null) {
                this.f242b.mo8612a();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocationClient", "startLocation");
        }
    }

    /* renamed from: a */
    public void mo8593a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption != null) {
            try {
                if (this.f242b != null) {
                    this.f242b.mo8613a(aMapLocationClientOption);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    /* renamed from: a */
    public void mo8594a(AMapLocationListener bVar) {
        if (bVar != null) {
            try {
                if (this.f242b != null) {
                    this.f242b.mo8614a(bVar);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    /* renamed from: b */
    public void mo8595b() {
        try {
            if (this.f242b != null) {
                this.f242b.mo8615b();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocationClient", "stopLocation");
        }
    }

    /* renamed from: b */
    public void mo8596b(AMapLocationListener bVar) {
        try {
            if (this.f242b != null) {
                this.f242b.mo8616b(bVar);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }

    /* renamed from: c */
    public void mo8597c() {
        try {
            if (this.f242b != null) {
                this.f242b.mo8617c();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
