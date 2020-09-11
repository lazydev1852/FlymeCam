package com.meizu.statsapp.p081v3.lib.plugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.statsapp.p081v3.GlobalExecutor;
import com.meizu.statsapp.p081v3.lib.plugin.utils.IntervalTimer;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver */
public class EnvironmentReceiver {
    public static final String CHANGE_NAME_NETWORKCONNECT = "CHANGE_NAME_NETWORKCONNECT";
    public static final String CHANGE_NAME_POWER = "CHANGE_NAME_POWER";
    private static final long NETWORK_JITTER_DELAY = 30000;
    private static final long POWER_JITTER_DELAY = 300000;
    private static final String TAG = "EnvironmentReceiver";
    private static EnvironmentReceiver mEnvironmentReceiver;
    private static final Object sLock = new Object();
    /* access modifiers changed from: private */
    public List<IEnvListener> mEnvListeners = new ArrayList();
    /* access modifiers changed from: private */
    public IntervalTimer mNetworkChangeTimer = new IntervalTimer(NETWORK_JITTER_DELAY) {
        public void onTrigger() {
            for (IEnvListener iEnvListener : EnvironmentReceiver.this.mEnvListeners) {
                if (iEnvListener != null) {
                    iEnvListener.environmentChanged(EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT);
                }
            }
            EnvironmentReceiver.this.mNetworkChangeTimer.cancel();
        }
    };
    /* access modifiers changed from: private */
    public IntervalTimer mPowerChangeTimer = new IntervalTimer(POWER_JITTER_DELAY) {
        public void onTrigger() {
            for (IEnvListener iEnvListener : EnvironmentReceiver.this.mEnvListeners) {
                if (iEnvListener != null) {
                    iEnvListener.environmentChanged(EnvironmentReceiver.CHANGE_NAME_POWER);
                }
            }
            EnvironmentReceiver.this.mPowerChangeTimer.cancel();
        }
    };

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver$IEnvListener */
    public interface IEnvListener {
        void environmentChanged(String str);
    }

    private EnvironmentReceiver(Context context) {
        Receiver receiver = new Receiver();
        try {
            context.unregisterReceiver(receiver);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(receiver, intentFilter);
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
        }
    }

    public static EnvironmentReceiver getInstance(Context context) {
        if (mEnvironmentReceiver == null) {
            synchronized (sLock) {
                if (mEnvironmentReceiver == null) {
                    mEnvironmentReceiver = new EnvironmentReceiver(context);
                }
            }
        }
        return mEnvironmentReceiver;
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver$Receiver */
    private class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public void onReceive(final Context context, Intent intent) {
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                Logger.m17378d(EnvironmentReceiver.TAG, "ACTION_POWER_CONNECTED, charging = true");
                EnvironmentReceiver.this.mPowerChangeTimer.start();
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                Logger.m17378d(EnvironmentReceiver.TAG, "ACTION_POWER_DISCONNECTED, charging = false");
                EnvironmentReceiver.this.mPowerChangeTimer.cancel();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                GlobalExecutor.execute(new Runnable() {
                    public void run() {
                        boolean isOnline = NetInfoUtils.isOnline(context);
                        Logger.m17378d(EnvironmentReceiver.TAG, "CONNECTIVITY_ACTION, isOnline = " + isOnline);
                        if (isOnline) {
                            EnvironmentReceiver.this.mNetworkChangeTimer.start();
                        } else {
                            EnvironmentReceiver.this.mNetworkChangeTimer.cancel();
                        }
                    }
                });
            }
        }
    }

    public void addEnvListener(IEnvListener iEnvListener) {
        if (this.mEnvListeners != null && iEnvListener != null) {
            this.mEnvListeners.add(iEnvListener);
        }
    }
}
