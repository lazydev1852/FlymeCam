package com.meizu.statsapp.p081v3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.USPMultiProcessService */
public class USPMultiProcessService extends Service {
    private String TAG = USPMultiProcessService.class.getSimpleName();

    public IBinder onBind(Intent intent) {
        String str = this.TAG;
        Logger.m17378d(str, "onBind intent: " + intent);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Logger.m17378d(this.TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str = this.TAG;
        Logger.m17378d(str, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        Logger.m17378d(this.TAG, "onDestroy");
    }
}
