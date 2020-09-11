package com.meizu.statsapp.p081v3;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.core.JLibrary;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.page.PageController;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.SDKInstanceImpl;
import com.meizu.statsapp.p081v3.lib.plugin.session.SessionController;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.LocationFetcher;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.utils.log.EncryptLogger;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.UsageStatsProxy3 */
public class UsageStatsProxy3 {
    /* access modifiers changed from: private */
    public static String TAG = "UsageStatsProxy3";
    private static final Object sLock = new Object();
    private static UsageStatsProxy3 sUsageStatsProxy;
    private Application mApplication;
    /* access modifiers changed from: private */
    public Context mContext;
    private PageController mPageController;
    private String mPkgKey;
    private int mPkgType;
    /* access modifiers changed from: private */
    public SDKInstanceImpl mSDKInstanceImpl;
    /* access modifiers changed from: private */
    public SessionController mSessionController;

    @Deprecated
    public void onBackgroundUse(long j, long j2, long j3) {
    }

    private UsageStatsProxy3(Application application, int i, String str, InitConfig initConfig) {
        File externalFilesDir;
        if (application == null) {
            throw new IllegalArgumentException("The context is null!");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("pkgKey is null!");
        } else if (initConfig == null) {
            throw new IllegalArgumentException("initConfig is null!");
        } else if (Build.VERSION.SDK_INT > 15) {
            this.mApplication = application;
            this.mContext = this.mApplication.getBaseContext();
            this.mPkgKey = str;
            this.mPkgType = i;
            if (Logger.sDebug && (externalFilesDir = this.mContext.getExternalFilesDir((String) null)) != null) {
                Logger.setHook(new EncryptLogger(externalFilesDir.getAbsolutePath()));
            }
            long currentTimeMillis = System.currentTimeMillis();
            Logger.m17378d(TAG, "##### UsageStatsProxy3 init");
            this.mSessionController = new SessionController(this.mApplication.getApplicationContext());
            this.mPageController = new PageController(this.mApplication.getApplicationContext());
            initMiitLibrary();
            if (InitConfig.mainThreadInit) {
                realInit();
            }
            String str2 = TAG;
            Logger.m17378d(str2, "##### UsageStatsProxy3 init complete, " + (System.currentTimeMillis() - currentTimeMillis));
        } else {
            throw new IllegalArgumentException("android OS version too low!");
        }
    }

    /* access modifiers changed from: private */
    public void realInit() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        Logger.m17378d(str, "##### UsageStatsProxy3 realInit 1, " + (System.currentTimeMillis() - currentTimeMillis));
        this.mSDKInstanceImpl = new SDKInstanceImpl(this.mContext, this.mPkgType, this.mPkgKey);
        try {
            deleteDirectory(this.mContext.getDir("mz_statsapp_v3_base", 0));
            deleteDirectory(this.mContext.getDir("mz_statsapp_v3_dex", 0));
            deleteDirectory(this.mContext.getDir("mz_statsapp_v3_patch", 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSessionController.attach(this.mSDKInstanceImpl);
        this.mSDKInstanceImpl.attach(this.mSessionController);
        String str2 = TAG;
        Logger.m17378d(str2, "##### UsageStatsProxy3 realInit 2, " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void initMiitLibrary() {
        if ((FlymeOSUtils.isBrandMeizu() && !FlymeOSUtils.isPreFlyme8()) || C2943Utils.isAndroidQ()) {
            JLibrary.InitEntry(this.mContext);
        }
    }

    private static boolean deleteDirectory(File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    deleteDirectory(listFiles[i]);
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return file.delete();
    }

    public static void init(Application application, PkgType pkgType, String str, InitConfig initConfig) {
        if (sUsageStatsProxy == null) {
            synchronized (sLock) {
                if (sUsageStatsProxy == null) {
                    sUsageStatsProxy = new UsageStatsProxy3(application, pkgType.value(), str, initConfig);
                }
            }
        }
    }

    public static void init(Application application, PkgType pkgType, String str) {
        if (sUsageStatsProxy == null) {
            synchronized (sLock) {
                if (sUsageStatsProxy == null) {
                    sUsageStatsProxy = new UsageStatsProxy3(application, pkgType.value(), str, new InitConfig());
                }
            }
        }
    }

    public static UsageStatsProxy3 getInstance() {
        if (sUsageStatsProxy != null) {
            return sUsageStatsProxy;
        }
        throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
    }

    public void onEvent(final String str, final String str2, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEvent, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEvent(str, str2, map);
                }
            });
        }
    }

    public void onEventRealtime(final String str, final String str2, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventRealtime, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventRealtime(str, str2, map);
                }
            });
        }
    }

    public void onEventNeartime(final String str, final String str2, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventNeartime, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventNeartime(str, str2, map);
                }
            });
        }
    }

    public void onLog(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onLog, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    UsageStatsProxy3.this.mSDKInstanceImpl.onLog(str, map);
                }
            });
        }
    }

    public void onLogRealtime(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onLogRealtime, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    UsageStatsProxy3.this.mSDKInstanceImpl.onLogRealtime(str, map);
                }
            });
        }
    }

    public void onEventLib(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str)) {
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            final Map<String, String> map2 = map;
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventLib, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Parameters.PKG_NAME, str4);
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventX(str5, str6, map2, hashMap);
                }
            });
        }
    }

    public void onEventRealtimeLib(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str)) {
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            final Map<String, String> map2 = map;
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventRealtimeLib, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Parameters.PKG_NAME, str4);
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventRealtimeX(str5, str6, map2, hashMap);
                }
            });
        }
    }

    public void onEventFramework(String str, String str2, Map<String, String> map, String str3, String str4, int i) {
        if (!TextUtils.isEmpty(str)) {
            final String str5 = str3;
            final String str6 = str4;
            final int i2 = i;
            final String str7 = str;
            final String str8 = str2;
            final Map<String, String> map2 = map;
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventFramework, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Parameters.PKG_NAME, str5);
                    hashMap.put(Parameters.PKG_VER, str6);
                    hashMap.put(Parameters.PKG_VER_CODE, Integer.valueOf(i2));
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventX(str7, str8, map2, hashMap);
                }
            });
        }
    }

    public void onEventRealtimeFramework(String str, String str2, Map<String, String> map, String str3, String str4, int i) {
        if (!TextUtils.isEmpty(str)) {
            final String str5 = str3;
            final String str6 = str4;
            final int i2 = i;
            final String str7 = str;
            final String str8 = str2;
            final Map<String, String> map2 = map;
            GlobalExecutor.execute(new Runnable() {
                public void run() {
                    if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                        Logger.m17382w(UsageStatsProxy3.TAG, "onEventRealtimeFramework, sdkInstanceImpl is NULL!");
                        UsageStatsProxy3.this.realInit();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Parameters.PKG_NAME, str5);
                    hashMap.put(Parameters.PKG_VER, str6);
                    hashMap.put(Parameters.PKG_VER_CODE, Integer.valueOf(i2));
                    UsageStatsProxy3.this.mSDKInstanceImpl.onEventRealtimeX(str7, str8, map2, hashMap);
                }
            });
        }
    }

    public void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPageController.startPage(str);
        }
    }

    public void onPageStop(String str) {
        onPageStop(str, (Map<String, String>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.mPageController.stopPage(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageStop(final java.lang.String r3, final java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.meizu.statsapp.v3.lib.plugin.page.PageController r0 = r2.mPageController
            com.meizu.statsapp.v3.lib.plugin.page.PageController$Page r0 = r0.stopPage(r3)
            if (r0 == 0) goto L_0x0017
            com.meizu.statsapp.v3.UsageStatsProxy3$10 r1 = new com.meizu.statsapp.v3.UsageStatsProxy3$10
            r1.<init>(r3, r0, r4)
            com.meizu.statsapp.p081v3.GlobalExecutor.execute(r1)
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.UsageStatsProxy3.onPageStop(java.lang.String, java.util.Map):void");
    }

    public void setSource(final String str) {
        GlobalExecutor.execute(new Runnable() {
            public void run() {
                if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                    Logger.m17382w(UsageStatsProxy3.TAG, "setSource, sdkInstanceImpl is NULL!");
                    UsageStatsProxy3.this.realInit();
                }
                UsageStatsProxy3.this.mSessionController.setSource(str);
            }
        });
    }

    public String getSource() {
        return this.mSessionController.getSource();
    }

    public void setAttributes(final Map<String, String> map) {
        GlobalExecutor.execute(new Runnable() {
            public void run() {
                if (UsageStatsProxy3.this.mSDKInstanceImpl == null) {
                    Logger.m17382w(UsageStatsProxy3.TAG, "setAttributes, sdkInstanceImpl is NULL!");
                    UsageStatsProxy3.this.realInit();
                }
                UsageStatsProxy3.this.mSDKInstanceImpl.setEventAttributes(map);
            }
        });
    }

    public String getSessionId() {
        return this.mSessionController.getSessionId();
    }

    public void onAppWidgetResume() {
        this.mSessionController.onAppWidgetResume();
    }

    public void onAppWidgetPaused() {
        this.mSessionController.onAppWidgetPaused();
    }

    public String getUMID() {
        if (this.mSDKInstanceImpl == null) {
            Logger.m17382w(TAG, "getUMID, sdkInstanceImpl is NULL!");
            realInit();
        }
        return this.mSDKInstanceImpl.getUMID();
    }

    public String getFlymeUID() {
        return FlymeOSUtils.isBrandMeizu() ? FlymeOSUtils.getFlymeUid(this.mApplication) : "";
    }

    public long getPageDuration(String str) {
        return this.mPageController.getPageDuration(str);
    }

    public LocationFetcher getLocationFetcher() {
        if (this.mSDKInstanceImpl != null) {
            return this.mSDKInstanceImpl.getLocationFetcher();
        }
        Logger.m17382w(TAG, "getLocationFetcher, sdkInstanceImpl is NULL!");
        return null;
    }

    public SDKInstanceImpl getSdkInstanceImpl() {
        return this.mSDKInstanceImpl;
    }
}
