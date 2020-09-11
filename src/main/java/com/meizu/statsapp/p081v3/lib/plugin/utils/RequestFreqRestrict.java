package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.RequestFreqRestrict */
public class RequestFreqRestrict {
    private static final String PREFERENCES_KEY_CURRENT_REQUEST = "current_request";
    private static final String PREFERENCES_KEY_DATE = "date";
    private static final String PREFERENCES_MOBILE_TRAFFIC_NAME = "com.meizu.statsapp.v3.request_feq_restrict";
    private static final String TAG = "RequestFreqRestrict";

    public static boolean isAllow(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_MOBILE_TRAFFIC_NAME, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String string = sharedPreferences.getString(PREFERENCES_KEY_DATE, "");
        String format = simpleDateFormat.format(new Date());
        if (string.equals(format)) {
            long j = sharedPreferences.getLong(PREFERENCES_KEY_CURRENT_REQUEST, 0);
            if (j > 30) {
                Logger.m17378d(TAG, "isAllow false");
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(PREFERENCES_KEY_CURRENT_REQUEST, j + 1);
            edit.commit();
            Logger.m17378d(TAG, "isAllow true");
            return true;
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putString(PREFERENCES_KEY_DATE, format);
        edit2.putLong(PREFERENCES_KEY_CURRENT_REQUEST, 1);
        edit2.commit();
        Logger.m17378d(TAG, "isAllow true");
        return true;
    }
}
