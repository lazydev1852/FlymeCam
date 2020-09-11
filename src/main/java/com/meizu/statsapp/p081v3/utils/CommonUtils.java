package com.meizu.statsapp.p081v3.utils;

import android.content.Context;
import android.util.Log;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.meizu.statsapp.v3.utils.CommonUtils */
public class CommonUtils {
    public static final String TAG = "UsageStatsUtils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean isDebugMode(Context context) {
        try {
            String str = SystemProperties.get("persist.meizu.usagestats.debug", "");
            if (str != null) {
                return str.equals("all") || str.equals(context.getPackageName());
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isPrintLog() {
        try {
            String str = SystemProperties.get("persist.meizu.usagestats.log", "false");
            if (str == null || !str.equals("true")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Log.e(TAG, "Logger -->Failed to get system properites");
            return false;
        }
    }
}
