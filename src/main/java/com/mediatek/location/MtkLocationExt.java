package com.mediatek.location;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import com.mediatek.cta.CtaManagerFactory;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.util.Calendar;

public class MtkLocationExt {
    private static final boolean DEBUG = true;
    private static final String TAG = "MtkLocationExt";

    public static class GnssLocationProvider {
        private static final int EVENT_GPS_TIME_SYNC_CHANGED = 4;
        private static final String INJECT_NLP_LOC = "com.mediatek.location.INJECT_NLP_LOC";
        private static final int UPDATE_LOCATION = 7;
        /* access modifiers changed from: private */
        public final Context mContext;
        private Handler mGpsHandler;
        private GpsTimeSyncObserver mGpsTimeSyncObserver;
        /* access modifiers changed from: private */
        public Thread mGpsTimerThread;
        /* access modifiers changed from: private */
        public Handler mGpsToastHandler = new Handler() {
            public void handleMessage(Message message) {
                Toast.makeText(GnssLocationProvider.this.mContext, (String) message.obj, 1).show();
            }
        };
        private final Handler mHandler;
        /* access modifiers changed from: private */
        public boolean mIsGpsTimeSyncRunning = false;
        private Location mLastLocation;
        /* access modifiers changed from: private */
        public LocationListener mLocationListener = new LocationListener() {
            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            public void onLocationChanged(Location location) {
                GnssLocationProvider.this.mGpsTimerThread.interrupt();
            }
        };
        /* access modifiers changed from: private */
        public LocationManager mLocationManager;
        private LocationListener mPassiveLocationListener = new LocationListener() {
            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            public void onLocationChanged(Location location) {
                if ("gps".equals(location.getProvider())) {
                    GnssLocationProvider.this.doSystemTimeSyncByGps((location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : MtkLocationExt.DEBUG, location.getTime());
                }
            }
        };
        private ServiceConnection mServiceConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(MtkLocationExt.TAG, "LPPe service onServiceConnected");
            }

            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(MtkLocationExt.TAG, "LPPe service onServiceDisconnected");
            }
        };

        public GnssLocationProvider(Context context, Handler handler) {
            Log.d(MtkLocationExt.TAG, "MtkLocationExt GnssLocationProvider()");
            this.mContext = context;
            this.mHandler = handler;
            registerIntentReceiver();
            Log.d(MtkLocationExt.TAG, "add GPS time sync handler and looper");
            this.mGpsHandler = new MyHandler(this.mHandler.getLooper());
            Context context2 = this.mContext;
            Context context3 = this.mContext;
            this.mLocationManager = (LocationManager) context2.getSystemService("location");
            this.mGpsTimeSyncObserver = new GpsTimeSyncObserver(this.mGpsHandler, 4);
            this.mGpsTimeSyncObserver.observe(this.mContext);
        }

        /* access modifiers changed from: private */
        public void bindLPPeService() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.mediatek.location.lppe.main", "com.mediatek.location.lppe.main.LPPeServiceWrapper"));
            boolean bindServiceAsUser = this.mContext.bindServiceAsUser(intent, this.mServiceConnection, 1073741829, new UserHandle(0));
            Log.d(MtkLocationExt.TAG, "binding lppe service bound = " + bindServiceAsUser);
        }

        /* access modifiers changed from: private */
        public void bindNlpService() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.mediatek.nlpservice", "com.mediatek.nlpservice.NlpService"));
            boolean bindServiceAsUser = this.mContext.bindServiceAsUser(intent, this.mServiceConnection, 1073741829, new UserHandle(0));
            Log.d(MtkLocationExt.TAG, "binding nlp service bound = " + bindServiceAsUser);
        }

        private void registerIntentReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction(INJECT_NLP_LOC);
            this.mContext.registerReceiverAsUser(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                        GnssLocationProvider.this.bindLPPeService();
                        GnssLocationProvider.this.bindNlpService();
                    } else if (GnssLocationProvider.INJECT_NLP_LOC.equals(action)) {
                        Location location = new Location(Parameters.NETWORK);
                        location.setLatitude((double) intent.getExtras().getFloat("loc_lat"));
                        location.setLongitude((double) intent.getExtras().getFloat("loc_lng"));
                        location.setAccuracy(intent.getExtras().getFloat("loc_acc"));
                        GnssLocationProvider.this.injectRefLocation(location);
                    }
                }
            }, UserHandle.ALL, intentFilter, (String) null, this.mHandler);
        }

        /* access modifiers changed from: private */
        public void injectRefLocation(Location location) {
            Log.d(MtkLocationExt.TAG, "injectRefLocation");
            if (location != null) {
                this.mHandler.obtainMessage(7, 0, 0, location).sendToTarget();
            }
        }

        private class MyHandler extends Handler {
            public MyHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 4) {
                    boolean access$300 = GnssLocationProvider.this.getGpsTimeSyncState();
                    Log.d(MtkLocationExt.TAG, "GPS Time sync is changed to " + access$300);
                    GnssLocationProvider.this.onGpsTimeChanged(access$300);
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean getGpsTimeSyncState() {
            try {
                if (Settings.Global.getInt(this.mContext.getContentResolver(), "auto_time_gps") > 0) {
                    return MtkLocationExt.DEBUG;
                }
                return false;
            } catch (Settings.SettingNotFoundException unused) {
                return false;
            }
        }

        private static class GpsTimeSyncObserver extends ContentObserver {
            private Handler mHandler;
            private int mMsg;

            GpsTimeSyncObserver(Handler handler, int i) {
                super(handler);
                this.mHandler = handler;
                this.mMsg = i;
            }

            /* access modifiers changed from: package-private */
            public void observe(Context context) {
                context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("auto_time_gps"), false, this);
            }

            public void onChange(boolean z) {
                this.mHandler.obtainMessage(this.mMsg).sendToTarget();
            }
        }

        public void onGpsTimeChanged(boolean z) {
            if (z) {
                startUsingGpsWithTimeout(180000, this.mContext.getString(134545593));
            } else if (this.mGpsTimerThread != null) {
                this.mGpsTimerThread.interrupt();
            }
            setGpsTimeSyncFlag(z);
        }

        private void setGpsTimeSyncFlag(boolean z) {
            Log.d(MtkLocationExt.TAG, "setGpsTimeSyncFlag: " + z);
            if (z) {
                this.mLocationManager.requestLocationUpdates("passive", 0, 0.0f, this.mPassiveLocationListener);
            } else {
                this.mLocationManager.removeUpdates(this.mPassiveLocationListener);
            }
        }

        /* access modifiers changed from: private */
        public void doSystemTimeSyncByGps(boolean z, long j) {
            if (z) {
                Log.d(MtkLocationExt.TAG, " ########## Auto-sync time with GPS: timestamp = " + j + " ########## ");
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(j);
                long timeInMillis = instance.getTimeInMillis();
                if (timeInMillis / 1000 < 2147483647L) {
                    SystemClock.setCurrentTimeMillis(timeInMillis);
                }
                this.mLocationManager.removeUpdates(this.mPassiveLocationListener);
            }
        }

        public void startUsingGpsWithTimeout(final int i, final String str) {
            if (this.mIsGpsTimeSyncRunning) {
                Log.d(MtkLocationExt.TAG, "WARNING: Gps Time Sync is already run");
                return;
            }
            this.mIsGpsTimeSyncRunning = MtkLocationExt.DEBUG;
            Log.d(MtkLocationExt.TAG, "start using GPS for GPS time sync timeout=" + i + " timeoutMsg=" + str);
            this.mLocationManager.requestLocationUpdates("gps", 1000, 0.0f, this.mLocationListener);
            this.mGpsTimerThread = new Thread() {
                public void run() {
                    boolean z;
                    try {
                        Thread.sleep((long) i);
                        z = MtkLocationExt.DEBUG;
                    } catch (InterruptedException unused) {
                        z = false;
                    }
                    Log.d(MtkLocationExt.TAG, "isTimeout=" + z);
                    if (z) {
                        Message message = new Message();
                        message.obj = str;
                        GnssLocationProvider.this.mGpsToastHandler.sendMessage(message);
                    }
                    GnssLocationProvider.this.mLocationManager.removeUpdates(GnssLocationProvider.this.mLocationListener);
                    boolean unused2 = GnssLocationProvider.this.mIsGpsTimeSyncRunning = false;
                }
            };
            this.mGpsTimerThread.start();
        }
    }

    public static class LocationManagerService {
        private final Context mContext;
        private final Handler mHandler;

        public LocationManagerService(Context context, Handler handler) {
            Log.d(MtkLocationExt.TAG, "MtkLocationExt LocationManagerService()");
            this.mContext = context;
            this.mHandler = handler;
        }

        public boolean isCtaFeatureSupport() {
            return CtaManagerFactory.getInstance().makeCtaManager().isCtaSupported();
        }
    }
}
