package com.loc;

import android.content.Context;

/* renamed from: com.loc.bl */
public final class WiFiUplateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private Context f2649b;

    /* renamed from: c */
    private boolean f2650c = false;

    public WiFiUplateStrategy(Context context) {
        this.f2649b = context;
        this.f2650c = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo13042a() {
        return DeviceInfo.m3729r(this.f2649b) == 1 || this.f2650c;
    }
}
