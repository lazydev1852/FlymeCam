package com.meizu.statsapp.p081v3.lib.plugin.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.LocationFetcher */
public class LocationFetcher {
    private static String TAG = "LocationFetcher";
    private Context context;
    private boolean enable;
    private long fetchTime;

    /* renamed from: sp */
    SharedPreferences f15999sp;

    public LocationFetcher(Context context2) {
        this.context = context2;
        this.f15999sp = context2.getSharedPreferences(UxipConstants.PREFERENCES_COMMON_NAME, 0);
    }

    public void setInterval(long j) {
        String str = TAG;
        Logger.m17378d(str, "setInterval intervalInMills: " + j);
        SharedPreferences.Editor edit = this.f15999sp.edit();
        edit.putLong(UxipConstants.PREFERENCES_KEY_POSITION_INTERVAL, j);
        edit.apply();
    }

    public void setEnable(boolean z) {
        String str = TAG;
        Logger.m17378d(str, "setReportLocation enable: " + z);
        this.enable = z;
    }

    public Location getLocation() {
        if (!this.enable) {
            return null;
        }
        System.currentTimeMillis();
        return getLocation(this.context);
    }

    private Location getLocation(Context context2) {
        LocationManager locationManager = (LocationManager) context2.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(1);
        criteria.setAccuracy(2);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider != null) {
            try {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                String str = TAG;
                Logger.m17378d(str, "Location found:" + lastKnownLocation);
                return lastKnownLocation;
            } catch (SecurityException e) {
                String str2 = TAG;
                Logger.m17379e(str2, "Security exception:" + e.toString());
                return null;
            } catch (ClassCastException e2) {
                String str3 = TAG;
                Logger.m17379e(str3, "ClassCastException:" + e2.toString());
                return null;
            } catch (NullPointerException e3) {
                String str4 = TAG;
                Logger.m17379e(str4, "NullPointerException:" + e3.toString());
                return null;
            }
        } else {
            Logger.m17379e(TAG, "Location Manager provider is null.");
            return null;
        }
    }
}
