package com.meizu.sharewidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

public abstract class PackageMonitor extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f15831a = false;

    /* renamed from: b */
    private Context f15832b;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo24050b();

    /* renamed from: a */
    public synchronized void mo24049a(@NonNull Context context) {
        if (!this.f15831a) {
            this.f15831a = true;
            this.f15832b = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addDataScheme("package");
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
            context.registerReceiver(this, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void mo24048a() {
        if (this.f15831a) {
            this.f15831a = false;
            this.f15832b.unregisterReceiver(this);
            this.f15832b = null;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        mo24050b();
    }
}
