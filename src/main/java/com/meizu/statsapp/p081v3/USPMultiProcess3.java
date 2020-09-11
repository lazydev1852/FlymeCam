package com.meizu.statsapp.p081v3;

import android.app.Application;
import java.util.Map;

@Deprecated
/* renamed from: com.meizu.statsapp.v3.USPMultiProcess3 */
public class USPMultiProcess3 {
    private static String TAG = "USPMultiProcess3";
    private static final Object lock = new Object();
    private static USPMultiProcess3 sInstance;

    public long getPageDuration(String str) {
        return 0;
    }

    @Deprecated
    public void onBackgroundUse(long j, long j2, long j3) {
    }

    public static void init(Application application, PkgType pkgType, String str, InitConfig initConfig) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new USPMultiProcess3();
                    UsageStatsProxy3.init(application, pkgType, str, initConfig);
                }
            }
        }
    }

    public static void init(Application application, PkgType pkgType, String str) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new USPMultiProcess3();
                    UsageStatsProxy3.init(application, pkgType, str);
                }
            }
        }
    }

    public static USPMultiProcess3 getInstance() {
        return sInstance;
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onEvent(str, str2, map);
        }
    }

    public void onEventRealtime(String str, String str2, Map<String, String> map) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onEventRealtime(str, str2, map);
        }
    }

    public void onEventNeartime(String str, String str2, Map<String, String> map) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onEventNeartime(str, str2, map);
        }
    }

    public void onEventLib(String str, String str2, Map<String, String> map, String str3) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onEventLib(str, str2, map, str3);
        }
    }

    public void onEventRealtimeLib(String str, String str2, Map<String, String> map, String str3) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onEventRealtimeLib(str, str2, map, str3);
        }
    }

    public void onLog(String str, Map<String, String> map) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onLog(str, map);
        }
    }

    public void onLogRealtime(String str, Map<String, String> map) {
        if (str != null) {
            UsageStatsProxy3.getInstance().onLogRealtime(str, map);
        }
    }

    public void onPageStart(String str) {
        UsageStatsProxy3.getInstance().onPageStart(str);
    }

    public void onPageStop(String str) {
        UsageStatsProxy3.getInstance().onPageStop(str);
    }

    public void setSource(String str) {
        UsageStatsProxy3.getInstance().setSource(str);
    }

    public String getSource() {
        return UsageStatsProxy3.getInstance().getSource();
    }

    public void setAttributes(Map<String, String> map) {
        UsageStatsProxy3.getInstance().setAttributes(map);
    }

    public String getSessionId() {
        return UsageStatsProxy3.getInstance().getSessionId();
    }
}
