package com.meizu.statsapp;

import android.content.Context;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class UsageStatsProxy {
    private static final String TAG = "UsageStatsProxy";
    private static Object sLock = new Object();
    private static UsageStatsProxy sUsageStatsProxy;

    private UsageStatsProxy(Context context, boolean z, boolean z2) {
    }

    private static UsageStatsProxy getInstance(Context context, boolean z, boolean z2) {
        if (sUsageStatsProxy == null) {
            synchronized (sLock) {
                if (sUsageStatsProxy == null) {
                    sUsageStatsProxy = new UsageStatsProxy(context, z, z2);
                }
            }
        }
        return sUsageStatsProxy;
    }

    private static void _WARNING_() {
        Logger.m17382w(TAG, "_WARNING_, DO NOT USE STATSAPP V2 INTERFACE IN V3!");
    }

    public static UsageStatsProxy getInstance(Context context, boolean z) {
        _WARNING_();
        if (sUsageStatsProxy == null) {
            synchronized (sLock) {
                if (sUsageStatsProxy == null) {
                    sUsageStatsProxy = new UsageStatsProxy(context, z, true);
                }
            }
        }
        return sUsageStatsProxy;
    }

    public static UsageStatsProxy getOnlineInstance(Context context, boolean z) {
        _WARNING_();
        return getInstance(context, true, z);
    }

    public static UsageStatsProxy getOfflineInstance(Context context) {
        _WARNING_();
        return getInstance(context, false, true);
    }

    public static UsageStatsProxy getOnlineInstance(Context context, boolean z, String str, long j, int i) {
        _WARNING_();
        return getOnlineInstance(context, z);
    }

    public static UsageStatsProxy getOfflineInstance(Context context, String str, long j, int i) {
        _WARNING_();
        return getOfflineInstance(context);
    }

    public void setUploaded(boolean z) {
        _WARNING_();
    }

    public void setOnline(boolean z) {
        _WARNING_();
    }

    public void setAttributes(Map<String, String> map) {
        _WARNING_();
        UsageStatsProxy3.getInstance().setAttributes(map);
    }

    public void onPageStart(String str) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onPageStart(str);
    }

    public void onPageStop(String str) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onPageStop(str);
    }

    public void onEvent(String str, String str2, String str3) {
        _WARNING_();
        HashMap hashMap = new HashMap();
        hashMap.put("value", str3);
        UsageStatsProxy3.getInstance().onEvent(str, str2, hashMap);
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onEvent(str, str2, map);
    }

    public void onEventRealtime(String str, String str2, Map<String, String> map) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onEventRealtime(str, str2, map);
    }

    public void onLog(String str, Map<String, String> map) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onLog(str, map);
    }

    public void onLogRealtime(String str, Map<String, String> map) {
        _WARNING_();
        UsageStatsProxy3.getInstance().onLogRealtime(str, map);
    }

    public String getSessionId() {
        _WARNING_();
        return UsageStatsProxy3.getInstance().getSessionId();
    }

    public void setSource(String str) {
        _WARNING_();
        UsageStatsProxy3.getInstance().setSource(str);
    }

    public String getSource() {
        _WARNING_();
        return UsageStatsProxy3.getInstance().getSource();
    }

    public void setBulkLimit(int i) {
        _WARNING_();
    }

    public String getUMID() {
        _WARNING_();
        return UsageStatsProxy3.getInstance().getUMID();
    }
}
