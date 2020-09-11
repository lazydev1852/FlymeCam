package com.meizu.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

public abstract class PackageMonitor extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f15657a = false;

    /* renamed from: b */
    private Context f15658b;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo23916b();

    /* renamed from: a */
    public synchronized void mo23915a(@NonNull Context context) {
        if (!this.f15657a) {
            this.f15657a = true;
            this.f15658b = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addDataScheme("package");
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
            context.registerReceiver(this, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void mo23914a() {
        if (this.f15657a) {
            this.f15657a = false;
            this.f15658b.unregisterReceiver(this);
            this.f15658b = null;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        mo23916b();
    }
}
