package com.mediatek.gnssdebugreport;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class GnssDebugReportManager {
    private static final String SERVICE_ACTION = "com.mediatek.gnssdebugreport.start";
    private static final String SERVICE_PKG = "com.mediatek.gnssdebugreport";

    public static boolean bindService(Context context, ServiceConnection serviceConnection) {
        Intent intent = new Intent(SERVICE_ACTION);
        intent.setPackage(SERVICE_PKG);
        return context.bindService(intent, serviceConnection, 1);
    }

    public static void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
