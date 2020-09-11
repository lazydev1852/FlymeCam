package com.meizu.statsapp.p081v3.lib.plugin.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.statsapp.p081v3.InitConfig;
import com.meizu.statsapp.p081v3.SdkVer;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.Emitter;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.local.LocalEmitter;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.meizu.statsapp.p081v3.lib.plugin.events.EventUtil;
import com.meizu.statsapp.p081v3.lib.plugin.events.LogEvent;
import com.meizu.statsapp.p081v3.lib.plugin.session.SessionController;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.LocationFetcher;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.Tracker;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.subject.Subject;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.PermissionUtils;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.sdk.SDKInstanceImpl */
public class SDKInstanceImpl {
    private static final String TAG = "SDKInstanceImpl";
    private Context applicationContext;
    private ConfigController configController;
    private Emitter emitter;
    private IDIdentifierController idIdentifierController;
    private LocationFetcher locationFetcher;
    private String pkgKey;
    private SessionController sessionController;
    private Tracker tracker;

    public SDKInstanceImpl(Context context, int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            this.applicationContext = context.getApplicationContext();
            Logger.m17378d(TAG, "##### pkgKey: " + str + ", pkgType: " + i + ", initConfig: " + new InitConfig().toString() + ", sdkVersion: " + SdkVer.verName);
            this.pkgKey = str;
            this.configController = new ConfigController(this.applicationContext, str);
            StringBuilder sb = new StringBuilder();
            sb.append("##### SDKInstanceImpl 1, ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            Logger.m17378d(TAG, sb.toString());
            this.locationFetcher = new LocationFetcher(this.applicationContext);
            this.idIdentifierController = IDIdentifierController.getInstance(context);
            this.emitter = buildEmitter(this.applicationContext, str);
            Logger.m17378d(TAG, "##### SDKInstanceImpl 2, " + (System.currentTimeMillis() - currentTimeMillis));
            Subject buildSubject = buildSubject(this.applicationContext, str, i, SdkVer.verName);
            Logger.m17378d(TAG, "##### SDKInstanceImpl 3, " + (System.currentTimeMillis() - currentTimeMillis));
            this.tracker = buildTrack(this.emitter, buildSubject, this.applicationContext);
            Logger.m17378d(TAG, "##### SDKInstanceImpl 4, " + (System.currentTimeMillis() - currentTimeMillis));
            init();
            Logger.m17378d(TAG, "##### SDKInstanceImpl 5, " + (System.currentTimeMillis() - currentTimeMillis));
            if (InitConfig.useInternationalDomain) {
                Logger.m17378d(TAG, "Switch international domain.");
                UxipConstants.UPLOAD_URL = "http://uxip.in.meizu.com/api/v3/event/";
                UxipConstants.GET_UMID_URL = "http://uxip-config.in.meizu.com/api/v3/umid";
                UxipConstants.GET_CONFIG_URL = "http://uxip-res.in.meizu.com/resource/v3/config/";
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The applicationContext is null!");
    }

    private void init() {
        this.idIdentifierController.init();
        this.locationFetcher.setEnable(InitConfig.reportLocation);
        this.configController.init(this);
        this.emitter.init();
        this.tracker.init(this);
        if (!InitConfig.noBootUp) {
            HashMap hashMap = new HashMap();
            hashMap.put("daily_actived", String.valueOf(getDailyActived(this.applicationContext)));
            hashMap.put("global_actived", String.valueOf(getGlobalActived(this.applicationContext)));
            this.tracker.track(EventUtil.buildActionXEvent(this.applicationContext, "_bootup_", (String) null, hashMap), 0);
        }
    }

    public String getPkgKey() {
        return this.pkgKey;
    }

    public Emitter getEmitter() {
        return this.emitter;
    }

    public Tracker getTracker() {
        return this.tracker;
    }

    public LocationFetcher getLocationFetcher() {
        return this.locationFetcher;
    }

    public void attach(SessionController sessionController2) {
        this.sessionController = sessionController2;
    }

    public SessionController getSessionController() {
        return this.sessionController;
    }

    public IDIdentifierController getIDIdentifierController() {
        return this.idIdentifierController;
    }

    public String getUMID() {
        return this.emitter != null ? this.emitter.getUMID() : "";
    }

    private Tracker buildTrack(Emitter emitter2, Subject subject, Context context) {
        return new Tracker.TrackerBuilder(emitter2, context).subject(subject).debug(CommonUtils.isDebugMode(context)).build();
    }

    private Emitter buildEmitter(Context context, String str) {
        boolean z = InitConfig.offline;
        boolean z2 = InitConfig.noEncrypt;
        boolean z3 = InitConfig.forceOffline;
        Log.d(TAG, "forceOffline:" + z3);
        boolean z4 = true;
        if (CommonUtils.isDebugMode(context)) {
            z2 = true;
        }
        if (InitConfig.useInternationalDomain) {
            PermissionUtils.checkInternetPermission(context);
            LocalEmitter localEmitter = new LocalEmitter(this.applicationContext, str);
            if (z2) {
                z4 = false;
            }
            localEmitter.setEncrypt(z4);
            return localEmitter;
        } else if (!z || (!FlymeOSUtils.findDataService(this.applicationContext) && !z3)) {
            PermissionUtils.checkInternetPermission(context);
            LocalEmitter localEmitter2 = new LocalEmitter(this.applicationContext, str);
            if (z2) {
                z4 = false;
            }
            localEmitter2.setEncrypt(z4);
            return localEmitter2;
        } else {
            V3OfflineEmitter v3OfflineEmitter = new V3OfflineEmitter(this.applicationContext, str);
            if (z2) {
                z4 = false;
            }
            v3OfflineEmitter.setEncrypt(z4);
            return v3OfflineEmitter;
        }
    }

    private Subject buildSubject(Context context, String str, int i, String str2) {
        String str3 = InitConfig.replacePackage;
        if (TextUtils.isEmpty(str3)) {
            return new Subject.SubjectBuilder().context(context).pkgKey(str).pkgType(i).sdkVersion(str2).build();
        }
        return new Subject.SubjectBuilder().context(context).pkgKey(str).pkgType(i).sdkVersion(str2).replacePackage(str3).build();
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        Logger.m17378d(TAG, "onEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            this.tracker.track(EventUtil.buildActionXEvent(this.applicationContext, str, str2, map));
        }
    }

    public void onEventRealtime(String str, String str2, Map<String, String> map) {
        Logger.m17378d(TAG, "onEventRealtime eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            this.tracker.track(EventUtil.buildActionXEvent(this.applicationContext, str, str2, map), 2);
        }
    }

    public void onEventNeartime(String str, String str2, Map<String, String> map) {
        Logger.m17378d(TAG, "onEventNeartime eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            this.tracker.track(EventUtil.buildActionXEvent(this.applicationContext, str, str2, map), 3);
        }
    }

    public void onLog(String str, Map<String, String> map) {
        Logger.m17378d(TAG, "onLog logName: " + str + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(Parameters.PKG_NAME, LogEvent.LOG_PACKAGE);
            this.tracker.trackX(EventUtil.buildLogEvent(this.applicationContext, str, map), 1, hashMap);
        }
    }

    public void onLogRealtime(String str, Map<String, String> map) {
        Logger.m17378d(TAG, "onLogRealtime logName: " + str + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(Parameters.PKG_NAME, LogEvent.LOG_PACKAGE);
            this.tracker.trackX(EventUtil.buildLogEvent(this.applicationContext, str, map), 2, hashMap);
        }
    }

    public void onEventX(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        Logger.m17378d(TAG, "onEventX eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            this.tracker.trackX(EventUtil.buildActionXEvent(this.applicationContext, str, str2, map), 1, map2);
        }
    }

    public void onEventRealtimeX(String str, String str2, Map<String, String> map, Map<String, Object> map2) {
        Logger.m17378d(TAG, "onEventX eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.tracker != null && !TextUtils.isEmpty(str)) {
            this.tracker.trackX(EventUtil.buildActionXEvent(this.applicationContext, str, str2, map), 2, map2);
        }
    }

    public void setEventAttributes(Map<String, String> map) {
        Logger.m17378d(TAG, "setEventAttributes attributes: " + map);
        if (this.tracker != null && this.tracker.getSubject() != null) {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    this.tracker.getSubject().addEventAttributePairs((String) next.getKey(), next.getValue());
                }
                return;
            }
            this.tracker.getSubject().clearEventAttributePairs();
        }
    }

    private int getDailyActived(Context context) {
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SharedPreferences sharedPreferences = context.getSharedPreferences(UxipConstants.PREFERENCES_COMMON_NAME, 0);
        String string = sharedPreferences.getString(UxipConstants.PREFERENCES_KEY_DAILY_ACTIVED_LAST, "");
        Logger.m17378d(TAG, "beforeGetDailyActived ------------------ current states: today:" + format + ", last:" + string);
        if (format.equals(string)) {
            return 0;
        }
        Logger.m17380i(TAG, "a new day");
        sharedPreferences.edit().putString(UxipConstants.PREFERENCES_KEY_DAILY_ACTIVED_LAST, format).apply();
        return 1;
    }

    private int getGlobalActived(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(UxipConstants.PREFERENCES_COMMON_NAME, 0);
        boolean z = sharedPreferences.getBoolean(UxipConstants.PREFERENCES_KEY_GLOBAL_ACTIVED, true);
        if (z) {
            sharedPreferences.edit().putBoolean(UxipConstants.PREFERENCES_KEY_GLOBAL_ACTIVED, false).apply();
        }
        return z ? 1 : 0;
    }
}
