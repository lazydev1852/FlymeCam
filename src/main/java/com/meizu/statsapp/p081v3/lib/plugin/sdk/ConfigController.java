package com.meizu.statsapp.p081v3.lib.plugin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.meizu.statsapp.p081v3.GlobalExecutor;
import com.meizu.statsapp.p081v3.lib.plugin.constants.TerType;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.EventFilter;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.sdk.ConfigController */
public class ConfigController {
    private static final String TAG = "ConfigController";
    private static final String WORK_THREAD_NAME = "com.meizu.statsapp.v3.ConfigControllerWorker";
    private final int CHECK_UPDATE = 1;
    private Context mContext;
    /* access modifiers changed from: private */
    public SharedPreferences.Editor mEditor;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public SharedPreferences mSP;
    private SDKInstanceImpl mSdkInstance;
    private String pkgKey;

    public ConfigController(Context context, String str) {
        this.mContext = context;
        this.pkgKey = str;
        this.mSP = this.mContext.getSharedPreferences(UxipConstants.PREFERENCES_SERVER_CONFIG_NAME, 0);
        this.mEditor = this.mSP.edit();
        HandlerThread handlerThread = new HandlerThread(WORK_THREAD_NAME, 5);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    long j = 0;
                    try {
                        j = simpleDateFormat.parse(ConfigController.this.mSP.getString(UxipConstants.PREFERENCES_KEY_GET_TIME, "")).getTime();
                    } catch (ParseException unused) {
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j > ((long) (ConfigController.this.randInt(120, 240) * 60 * 1000)) && ConfigController.this.getConfigFromServer()) {
                        ConfigController.this.mEditor.putString(UxipConstants.PREFERENCES_KEY_GET_TIME, simpleDateFormat.format(new Date(currentTimeMillis)));
                        ConfigController.this.mEditor.commit();
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void init(SDKInstanceImpl sDKInstanceImpl) {
        this.mSdkInstance = sDKInstanceImpl;
        Receiver receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.mContext.registerReceiver(receiver, intentFilter);
        } catch (Exception e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
        }
        checkUpdate(1000);
    }

    /* access modifiers changed from: package-private */
    public void checkUpdate(int i) {
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler.sendEmptyMessageDelayed(1, (long) i);
    }

    /* access modifiers changed from: private */
    public int randInt(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    private String getTerType() {
        if (FlymeOSUtils.isBox(this.mContext)) {
            return TerType.FLYME_TV.toString();
        }
        if (FlymeOSUtils.isTablet(this.mContext)) {
            return TerType.PAD.toString();
        }
        return TerType.PHONE.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getConfigFromServer() {
        /*
            r7 = this;
            boolean r0 = com.meizu.statsapp.p081v3.InitConfig.offline
            r1 = 0
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "ConfigController"
            java.lang.String r2 = "getConfigFromServer, sdk offline mode"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r2)
            return r1
        L_0x000d:
            android.content.Context r0 = r7.mContext
            boolean r0 = com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils.kaiJiXiangDao(r0)
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "ConfigController"
            java.lang.String r2 = "getConfigFromServer --> 还未完成开机向导"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r2)
            return r1
        L_0x001d:
            android.content.Context r0 = r7.mContext
            boolean r0 = com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils.isOnline(r0)
            if (r0 != 0) goto L_0x002d
            java.lang.String r0 = "ConfigController"
            java.lang.String r2 = "getConfigFromServer, network unavailable"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r2)
            return r1
        L_0x002d:
            java.lang.String r0 = "ConfigController"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getConfigFromServer, now: "
            r2.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r3 = ", last get time: "
            r2.append(r3)
            android.content.SharedPreferences r3 = r7.mSP
            java.lang.String r4 = "getTime"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.getString(r4, r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r2)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.SharedPreferences r2 = r7.mSP
            java.lang.String r3 = "lastModified"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r3, r4)
            java.lang.String r3 = com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil.HEADER_If_Modified_Since
            r0.put(r3, r2)
            android.content.SharedPreferences r2 = r7.mSP
            java.lang.String r3 = "ETag"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r3, r4)
            java.lang.String r3 = com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil.HEADER_If_None_Match
            r0.put(r3, r2)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.GET_CONFIG_URL
            r3.append(r4)
            java.lang.String r4 = r7.pkgKey
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "ConfigController"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "try local... cdn url: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r6 = ", header: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r4, r5)
            android.content.Context r4 = r7.mContext
            boolean r4 = com.meizu.statsapp.p081v3.lib.plugin.utils.RequestFreqRestrict.isAllow(r4)
            if (r4 != 0) goto L_0x00c3
            return r1
        L_0x00c3:
            android.content.Context r4 = r7.mContext     // Catch:{ IOException -> 0x00d3, RuntimeException -> 0x00ce }
            com.meizu.statsapp.v3.lib.plugin.net.NetRequester r4 = com.meizu.statsapp.p081v3.lib.plugin.net.NetRequester.getInstance(r4)     // Catch:{ IOException -> 0x00d3, RuntimeException -> 0x00ce }
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r0 = r4.postNoGslb(r3, r0)     // Catch:{ IOException -> 0x00d3, RuntimeException -> 0x00ce }
            goto L_0x00d8
        L_0x00ce:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00d7
        L_0x00d3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d7:
            r0 = r2
        L_0x00d8:
            java.lang.String r2 = "ConfigController"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getConfigFromServer response: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r4)
            r2 = 1
            if (r0 == 0) goto L_0x0175
            int r4 = r0.getResponseCode()
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x0175
            java.lang.String r0 = r0.getResponseBody()
            if (r0 == 0) goto L_0x0187
            java.lang.String r4 = "ConfigController"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            r5.<init>()     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            java.lang.String r6 = "Successfully posted to "
            r5.append(r6)     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            r5.append(r3)     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            java.lang.String r3 = r5.toString()     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r4, r3)     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            android.content.SharedPreferences$Editor r3 = r7.mEditor     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            java.lang.String r4 = "response"
            r3.putString(r4, r0)     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            android.content.SharedPreferences$Editor r3 = r7.mEditor     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            r3.commit()     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            r7.parseAndApply(r0)     // Catch:{ JSONException -> 0x014d, NumberFormatException -> 0x0125 }
            goto L_0x0186
        L_0x0125:
            r0 = move-exception
            java.lang.String r2 = "ConfigController"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception: "
            r3.append(r4)
            java.lang.String r4 = r0.toString()
            r3.append(r4)
            java.lang.String r4 = " - Cause: "
            r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17382w(r2, r0)
            goto L_0x0187
        L_0x014d:
            r0 = move-exception
            java.lang.String r2 = "ConfigController"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception: "
            r3.append(r4)
            java.lang.String r4 = r0.toString()
            r3.append(r4)
            java.lang.String r4 = " - Cause: "
            r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17382w(r2, r0)
            goto L_0x0187
        L_0x0175:
            if (r0 == 0) goto L_0x0187
            int r0 = r0.getResponseCode()
            r3 = 304(0x130, float:4.26E-43)
            if (r0 != r3) goto L_0x0187
            java.lang.String r0 = "ConfigController"
            java.lang.String r1 = "config in server has no change"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)
        L_0x0186:
            r1 = 1
        L_0x0187:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.sdk.ConfigController.getConfigFromServer():boolean");
    }

    private void parseAndApply(String str) throws JSONException {
        Logger.m17378d(TAG, "parseConfigJson 1");
        JSONObject jSONObject = new JSONObject(str);
        Logger.m17378d(TAG, "parseConfigJson 2, config json:" + jSONObject.toString());
        this.mEditor.putInt(UxipConstants.RESPONSE_KEY_VERSION, jSONObject.getInt(UxipConstants.RESPONSE_KEY_VERSION));
        this.mEditor.commit();
        boolean z = jSONObject.getBoolean("active");
        JSONObject jSONObject2 = jSONObject.getJSONObject(UxipConstants.RESPONSE_KEY_UPLOADPOLICY);
        boolean z2 = jSONObject2.getBoolean(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
        boolean z3 = jSONObject2.getBoolean(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONRECONNECT);
        long j = jSONObject2.getLong(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_MOBILEQUOTA);
        int i = jSONObject2.getInt(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_CACHECAPACITY);
        int i2 = jSONObject2.getInt(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_NEARTIME_INTERVAL);
        this.mSdkInstance.getEmitter().updateConfig(z, z2, jSONObject2.getBoolean(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONCHARGE), z3, jSONObject2.getLong(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_INTERVAL) * 60 * 1000, i, j, i2);
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
            String string = jSONObject3.getString("name");
            hashMap.put(string, new EventFilter(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean(UxipConstants.RESPONSE_KEY_EVENTS_REALTIME), jSONObject3.getBoolean(UxipConstants.RESPONSE_KEY_EVENTS_NEARTIME)));
        }
        this.mSdkInstance.getTracker().setEventFilterMap(hashMap);
        this.mSdkInstance.getLocationFetcher().setInterval(jSONObject.getLong(UxipConstants.RESPONSE_KEY_POSITIONING_INTERVAL) * 60 * 1000);
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.sdk.ConfigController$Receiver */
    private class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public void onReceive(final Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                GlobalExecutor.execute(new Runnable() {
                    public void run() {
                        boolean isOnline = NetInfoUtils.isOnline(context);
                        Logger.m17378d(ConfigController.TAG, "CONNECTIVITY_ACTION, isOnline = " + isOnline);
                        if (isOnline) {
                            ConfigController.this.checkUpdate(1000);
                        }
                    }
                });
            }
        }
    }
}
