package com.meizu.statsapp.p081v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.meizu.statsapp.p081v3.lib.plugin.IVccOfflineStatsCallback;
import com.meizu.statsapp.p081v3.lib.plugin.IVccOfflineStatsInterface;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.List;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V3RemoteServiceRequester */
public class V3RemoteServiceRequester {
    private static final long BINDING_TIMEOUT = 3000;
    private static final String TAG = "V3RemoteServiceReq";
    private static final Object lock = new Object();
    private static V3RemoteServiceRequester sInstance;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public IRemoteConnCallback remoteConnCallback;
    /* access modifiers changed from: private */
    public final ServiceConn serviceConn = new ServiceConn();
    /* access modifiers changed from: private */
    public IVccOfflineStatsInterface vccOfflineStatsInterface;
    private ServiceInfo vccOfflineStatsService;

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V3RemoteServiceRequester$IRemoteConnCallback */
    interface IRemoteConnCallback {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    @Deprecated
    public boolean emitterAddEventRealtime(String str, long j, TrackerPayload trackerPayload) {
        return false;
    }

    private V3RemoteServiceRequester(Context context2) {
        this.context = context2;
        List<ResolveInfo> queryIntentServices = context2.getPackageManager().queryIntentServices(new Intent(FlymeOSUtils.ACTION_VCC_OFFLINE_STATS), 64);
        Logger.m17378d(TAG, "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + queryIntentServices);
        if (queryIntentServices != null) {
            for (ResolveInfo next : queryIntentServices) {
                String str = next.serviceInfo.packageName;
                String str2 = next.serviceInfo.name;
                if (FlymeOSUtils.DATASERVICE_PACKAGENAME.equals(str)) {
                    Logger.m17378d(TAG, "choose serviceName---" + str2 + " pkgName---" + str);
                    this.vccOfflineStatsService = next.serviceInfo;
                    return;
                }
            }
        }
    }

    public static V3RemoteServiceRequester getInstance(Context context2) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new V3RemoteServiceRequester(context2);
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    public void setRemoteConnCallback(IRemoteConnCallback iRemoteConnCallback) {
        this.remoteConnCallback = iRemoteConnCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean emitterAddEvent(String str, long j, TrackerPayload trackerPayload) {
        if (this.vccOfflineStatsService == null) {
            Log.i(TAG, "emitterAddEvent--> offline service is null");
            return false;
        } else if (this.vccOfflineStatsInterface != null && internalAdd(str, j, trackerPayload)) {
            return true;
        } else {
            Logger.m17382w(TAG, "not get remote interface.");
            bindRemoteService();
            return false;
        }
    }

    private boolean internalAdd(String str, long j, TrackerPayload trackerPayload) {
        try {
            this.vccOfflineStatsInterface.emitterAddEvent(str, j, trackerPayload);
            return true;
        } catch (RemoteException e) {
            Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
            return false;
        }
    }

    public boolean emitterBulkAddEvents(String str, List<Long> list, List<TrackerPayload> list2) {
        if (this.vccOfflineStatsService == null) {
            Log.i(TAG, "emitterBulkAddEvents--> offline service is null");
            return false;
        } else if (this.vccOfflineStatsInterface != null && internalBulkAdd(str, list, list2)) {
            return true;
        } else {
            Logger.m17382w(TAG, "not get remote interface.");
            bindRemoteService();
            return false;
        }
    }

    private boolean internalBulkAdd(String str, List<Long> list, List<TrackerPayload> list2) {
        try {
            this.vccOfflineStatsInterface.emitterBulkAddEvents(str, list, list2);
            return true;
        } catch (RemoteException e) {
            Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
            return false;
        }
    }

    public boolean emitterUpdateConfig(String str, EmitterConfig emitterConfig) {
        if (this.vccOfflineStatsService == null) {
            Log.i(TAG, "emitterUpdateConfig--> offline service is null");
            return false;
        } else if (this.vccOfflineStatsInterface != null && internalUpdateConfig(str, emitterConfig)) {
            return true;
        } else {
            Logger.m17382w(TAG, "not get remote interface.");
            bindRemoteService();
            return false;
        }
    }

    private boolean internalUpdateConfig(String str, EmitterConfig emitterConfig) {
        try {
            this.vccOfflineStatsInterface.emitterUpdateConfig(str, emitterConfig);
            return true;
        } catch (RemoteException e) {
            Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
            return false;
        }
    }

    public String emitterGetUmid(String str) {
        String str2;
        boolean z;
        if (this.vccOfflineStatsService != null) {
            if (this.vccOfflineStatsInterface != null) {
                try {
                    str2 = this.vccOfflineStatsInterface.emitterGetUmid(str);
                    z = true;
                } catch (RemoteException e) {
                    Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                    z = false;
                    str2 = null;
                }
                if (z) {
                    return str2;
                }
            }
            Logger.m17382w(TAG, "not get remote interface.");
        } else {
            Log.i(TAG, "emitterGetUmid--> offline service is null");
        }
        return null;
    }

    public boolean emitterUpdateEventSource(String str, String str2) {
        if (this.vccOfflineStatsService != null) {
            if (this.vccOfflineStatsInterface != null) {
                try {
                    this.vccOfflineStatsInterface.emitterUpdateEventSource(str, str2);
                    return true;
                } catch (RemoteException e) {
                    Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                }
            }
            Logger.m17382w(TAG, "not get remote interface.");
            return false;
        }
        Log.i(TAG, "emitterUpdateEventSource--> offline service is null");
        return false;
    }

    public void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) {
        if (this.vccOfflineStatsService != null) {
            if (this.vccOfflineStatsInterface != null) {
                try {
                    this.vccOfflineStatsInterface.setCallback(str, iVccOfflineStatsCallback);
                } catch (RemoteException e) {
                    Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                }
            }
            Logger.m17382w(TAG, "not get remote interface.");
            return;
        }
        Log.i(TAG, "setCallback--> offline service is null");
    }

    private void bindRemoteService() {
        if (this.vccOfflineStatsService != null) {
            synchronized (this.serviceConn) {
                Intent intent = new Intent();
                intent.setAction(FlymeOSUtils.ACTION_VCC_OFFLINE_STATS);
                intent.setPackage(this.vccOfflineStatsService.packageName);
                intent.setComponent(new ComponentName(this.vccOfflineStatsService.packageName, this.vccOfflineStatsService.name));
                boolean bindService = this.context.bindService(intent, this.serviceConn, 1);
                Logger.m17378d(TAG, "bindService, " + this.serviceConn + " result: " + bindService);
                if (bindService) {
                    try {
                        this.serviceConn.wait(BINDING_TIMEOUT);
                        Logger.m17378d(TAG, "serviceConn wait END");
                    } catch (InterruptedException e) {
                        Logger.m17382w(TAG, "Exception:" + e.toString() + " - Cause:" + e.getCause());
                    }
                }
            }
            return;
        }
        Log.i(TAG, "offline service is null,unable to bind");
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V3RemoteServiceRequester$ServiceConn */
    private class ServiceConn implements ServiceConnection {
        private ServiceConn() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Logger.m17378d(V3RemoteServiceRequester.TAG, "onServiceConnected, " + iBinder);
                IVccOfflineStatsInterface unused = V3RemoteServiceRequester.this.vccOfflineStatsInterface = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
                if (V3RemoteServiceRequester.this.remoteConnCallback != null) {
                    V3RemoteServiceRequester.this.remoteConnCallback.onServiceConnected();
                }
            } catch (Exception e) {
                Logger.m17379e(V3RemoteServiceRequester.TAG, "Exception onServiceConnected:" + e.toString() + " - Cause:" + e.getCause());
            }
            synchronized (V3RemoteServiceRequester.this.serviceConn) {
                V3RemoteServiceRequester.this.serviceConn.notifyAll();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.m17378d(V3RemoteServiceRequester.TAG, "onServiceDisconnected, " + componentName);
            IVccOfflineStatsInterface unused = V3RemoteServiceRequester.this.vccOfflineStatsInterface = null;
            if (V3RemoteServiceRequester.this.remoteConnCallback != null) {
                V3RemoteServiceRequester.this.remoteConnCallback.onServiceDisconnected();
            }
            V3RemoteServiceRequester.this.context.unbindService(this);
        }
    }
}
