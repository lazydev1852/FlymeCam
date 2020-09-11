package com.meizu.statsapp.p081v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.AppInfo */
public class AppInfo {
    private static final String TAG = "AppInfo";
    private HashMap<String, Object> appPairs;

    public void setContextualParams(Context context) {
    }

    private AppInfo(AppInfoBuilder appInfoBuilder) {
        this.appPairs = new HashMap<>();
        setChannelId(appInfoBuilder.context);
        if (appInfoBuilder.context != null) {
            setContextualParams(appInfoBuilder.context);
        }
        Logger.m17381v(TAG, "AppInfo created successfully.");
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.AppInfo$AppInfoBuilder */
    public static class AppInfoBuilder {
        /* access modifiers changed from: private */
        public Context context = null;

        public AppInfoBuilder context(Context context2) {
            this.context = context2;
            return this;
        }

        public AppInfo build() {
            return new AppInfo(this);
        }
    }

    private void setChannelId(Context context) {
        add(Parameters.CHANNEL_ID, getChannelId(context));
    }

    private String getChannelId(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "0";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return "0";
            }
            if (applicationInfo.metaData.get("uxip_channel_num") == null) {
                return "0";
            }
            return String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return "0";
        }
    }

    private void add(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null) {
            this.appPairs.put(str, str2);
        }
    }

    private void add(String str, Object obj) {
        if (str != null && !str.isEmpty() && obj != null) {
            this.appPairs.put(str, obj);
        }
    }

    public Map getMap() {
        return this.appPairs;
    }
}
