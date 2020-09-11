package com.meizu.statsapp.p081v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.subject.AppInfo;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.subject.DeviceInfo;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.Subject */
public class Subject {
    private static String TAG = "Subject";
    private AppInfo appInfo;
    private DeviceInfo deviceInfo;
    private ConcurrentHashMap<String, Object> eventAttributePairs;
    private ConcurrentHashMap<String, Object> settingPropertyPairs;

    private Subject(SubjectBuilder subjectBuilder) {
        this.eventAttributePairs = new ConcurrentHashMap<>();
        this.settingPropertyPairs = new ConcurrentHashMap<>();
        long currentTimeMillis = System.currentTimeMillis();
        setDefaultDebug();
        setDefaultFlymeVersion();
        String str = TAG;
        Logger.m17378d(str, "##### Subject step 1, " + (System.currentTimeMillis() - currentTimeMillis));
        if (subjectBuilder.context != null) {
            setContextualParams(subjectBuilder.context);
            if (TextUtils.isEmpty(subjectBuilder.replacePackage)) {
                setDefaultPackage(subjectBuilder.context);
            } else {
                setReplacePackage(subjectBuilder.context, subjectBuilder.replacePackage);
            }
            setPkgKey(subjectBuilder.pkgKey);
            setPkgType(subjectBuilder.pkgType);
            setSdkVersion(subjectBuilder.sdkVersion);
        }
        String str2 = TAG;
        Logger.m17378d(str2, "##### Subject step 2, " + (System.currentTimeMillis() - currentTimeMillis));
        Logger.m17378d(TAG, "Subject created successfully.");
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.Subject$SubjectBuilder */
    public static class SubjectBuilder {
        /* access modifiers changed from: private */
        public Context context = null;
        /* access modifiers changed from: private */
        public String pkgKey;
        /* access modifiers changed from: private */
        public int pkgType;
        /* access modifiers changed from: private */
        public String replacePackage;
        /* access modifiers changed from: private */
        public String sdkVersion;

        public SubjectBuilder context(Context context2) {
            this.context = context2;
            return this;
        }

        public SubjectBuilder pkgKey(String str) {
            this.pkgKey = str;
            return this;
        }

        public SubjectBuilder pkgType(int i) {
            this.pkgType = i;
            return this;
        }

        public SubjectBuilder sdkVersion(String str) {
            this.sdkVersion = str;
            return this;
        }

        public SubjectBuilder replacePackage(String str) {
            this.replacePackage = str;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }

    public void setContextualParams(Context context) {
        this.deviceInfo = new DeviceInfo.DeviceInfoBuilder().context(context).build();
        this.appInfo = new AppInfo.AppInfoBuilder().context(context).build();
    }

    private void setDefaultDebug() {
        addSettingProperty(Parameters.DEBUG, false);
    }

    public void setDebug(boolean z) {
        addSettingProperty(Parameters.DEBUG, z);
    }

    private void setDefaultFlymeVersion() {
        addSettingProperty(Parameters.FLYME_VER, Build.DISPLAY);
    }

    private void setDefaultPackage(Context context) {
        String packageName = context.getPackageName();
        addSettingProperty(Parameters.PKG_NAME, packageName);
        addSettingProperty(Parameters.PKG_VER, FlymeOSUtils.getPackageVersion(packageName, context));
        addSettingProperty(Parameters.PKG_VER_CODE, FlymeOSUtils.getPackageCode(packageName, context));
    }

    private void setReplacePackage(Context context, String str) {
        PackageInfo packageInfo;
        String str2 = TAG;
        Logger.m17378d(str2, "### setReplacePackage, replacePackage: " + str);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            addSettingProperty(Parameters.PKG_NAME, packageInfo.packageName);
            addSettingProperty(Parameters.PKG_VER, packageInfo.versionName);
            addSettingProperty(Parameters.PKG_VER_CODE, packageInfo.versionCode);
            String str3 = TAG;
            Logger.m17378d(str3, "setReplacePackage, packageInfo: " + packageInfo);
        } else {
            addSettingProperty(Parameters.PKG_NAME, "");
            addSettingProperty(Parameters.PKG_VER, "");
            addSettingProperty(Parameters.PKG_VER_CODE, 0);
        }
        String packageName = context.getPackageName();
        this.eventAttributePairs.put("_my_pkg_name_", packageName);
        this.eventAttributePairs.put("_my_pkg_ver_", FlymeOSUtils.getPackageVersion(packageName, context));
        ConcurrentHashMap<String, Object> concurrentHashMap = this.eventAttributePairs;
        concurrentHashMap.put("_my_pkg_ver_code_", "" + FlymeOSUtils.getPackageCode(packageName, context));
    }

    private void setPkgKey(String str) {
        addSettingProperty(Parameters.PKG_KEY, str);
    }

    private void setPkgType(int i) {
        addSettingProperty(Parameters.PKG_TYPE, i);
    }

    private void setSdkVersion(String str) {
        addSettingProperty(Parameters.SDK_VER, str);
    }

    private void addSettingProperty(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null) {
            this.settingPropertyPairs.put(str, str2);
        }
    }

    private void addSettingProperty(String str, int i) {
        if (str != null && !str.isEmpty()) {
            this.settingPropertyPairs.put(str, Integer.valueOf(i));
        }
    }

    private void addSettingProperty(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            this.settingPropertyPairs.put(str, Boolean.valueOf(z));
        }
    }

    public void addEventAttributePairs(String str, Object obj) {
        if (str != null && !str.isEmpty() && obj != null) {
            this.eventAttributePairs.put(str, obj);
        }
    }

    public void clearEventAttributePairs() {
        this.eventAttributePairs = new ConcurrentHashMap<>();
    }

    public Map<String, Object> getVolatileProperty(Context context) {
        HashMap hashMap = new HashMap();
        String[] imsi = FlymeOSUtils.getImsi(context);
        if (imsi != null) {
            if (imsi[0] != null) {
                hashMap.put(Parameters.IMSI1, imsi[0]);
            }
            if (imsi[1] != null) {
                hashMap.put(Parameters.IMSI2, imsi[1]);
            }
        }
        hashMap.put("lla", FlymeOSUtils.getLocationLanguage(context));
        hashMap.put("imei", FlymeOSUtils.getDeviceId(context));
        hashMap.put(Parameters.MAC_ADDRESS, NetInfoUtils.getMACAddress(context));
        String str = TAG;
        Logger.m17378d(str, "getVolatileProperty ..." + hashMap);
        return hashMap;
    }

    public Map<String, Object> getDeviceInfo() {
        return this.deviceInfo.getMap();
    }

    public Map<String, Object> getAppInfo() {
        return this.appInfo.getMap();
    }

    public Map<String, Object> getEventAttributePairs() {
        return this.eventAttributePairs;
    }

    public Map<String, Object> getSettingProperty() {
        return this.settingPropertyPairs;
    }
}
