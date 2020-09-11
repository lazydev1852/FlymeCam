package com.meizu.statsapp.p081v3.lib.plugin.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.TerType;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester;
import com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil;
import com.meizu.statsapp.p081v3.lib.plugin.utils.RequestFreqRestrict;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.sdk.UmidFetcher */
public class UmidFetcher {
    public static final String PREFERENCES_KEY_IMEI = "imei";
    public static final String PREFERENCES_KEY_SECONDARY_IMEI = "secondary_imei";
    public static final String PREFERENCES_KEY_SN = "sn";
    public static final String PREFERENCES_KEY_UMID = "UMID";
    public static final String PREFERENCES_UMID_NAME = "com.meizu.statsapp.v3.umid";
    private static final String TAG = "UmidFetcher";
    private static UmidFetcher sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private AtomicBoolean mFulled = new AtomicBoolean(false);
    private SharedPreferences mSP;

    private UmidFetcher(Context context) {
        this.mContext = context;
        this.mSP = context.getSharedPreferences(PREFERENCES_UMID_NAME, 0);
    }

    public static UmidFetcher getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new UmidFetcher(context);
                }
            }
        }
        return sInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return r4 ? getUmidFromSettings() : "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String fetchOrRequestUMID(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.readUmidFromLocal()     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            java.lang.String r0 = r3.getUmidFromServer()     // Catch:{ all -> 0x0033 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0019
            monitor-exit(r3)
            return r0
        L_0x0019:
            if (r4 == 0) goto L_0x0020
            java.lang.String r4 = r3.getUmidFromSettings()     // Catch:{ all -> 0x0033 }
            goto L_0x0022
        L_0x0020:
            java.lang.String r4 = ""
        L_0x0022:
            monitor-exit(r3)
            return r4
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r4 = r3.mFulled     // Catch:{ all -> 0x0033 }
            r1 = 0
            r2 = 1
            boolean r4 = r4.compareAndSet(r1, r2)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x0031
            r3.fullUmidIdIf()     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r3)
            return r0
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.sdk.UmidFetcher.fetchOrRequestUMID(boolean):java.lang.String");
    }

    public synchronized String fetchOrRequestUMID() {
        return fetchOrRequestUMID(true);
    }

    private String getUmidFromServer() {
        if (!NetInfoUtils.isOnline(this.mContext)) {
            Logger.m17378d(TAG, "getUmidFromServer, network unavailable");
            return "";
        } else if (FlymeOSUtils.kaiJiXiangDao(this.mContext) || !FlymeOSUtils.isCTA()) {
            String buildGetUri = buildGetUri(this.mContext);
            if (!RequestFreqRestrict.isAllow(this.mContext)) {
                return "";
            }
            Logger.m17378d(TAG, "try getUmidFromServer... url: " + buildGetUri);
            NetResponse stringPartRequest = HttpSecureRequester.getInstance(this.mContext).stringPartRequest(buildGetUri, "GET", (Map<String, String>) null, (String) null);
            Logger.m17378d(TAG, "getUmidFromServer, response: " + stringPartRequest);
            handleResponse(stringPartRequest);
            return readUmidFromLocal();
        } else {
            Logger.m17378d(TAG, "getUmidFromServer, cta -> boot guide ing...");
            return "";
        }
    }

    private String getUmidFromSettings() {
        String string = Settings.Global.getString(this.mContext.getContentResolver(), UxipConstants.MZ_ANALYTIC_SDK_UMID);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        Logger.m17378d(TAG, "setting.global --> sp");
        this.mSP.edit().putString(PREFERENCES_KEY_UMID, string).commit();
        return string;
    }

    public String readUmidFromLocal() {
        return this.mSP.getString(PREFERENCES_KEY_UMID, "");
    }

    private void fullUmidIdIf() {
        boolean z;
        if (!NetInfoUtils.isOnline(this.mContext)) {
            Logger.m17378d(TAG, "full UMID Ids, network unavailable");
        } else if (FlymeOSUtils.kaiJiXiangDao(this.mContext) || !FlymeOSUtils.isCTA()) {
            String deviceId = FlymeOSUtils.getDeviceId(this.mContext);
            String string = this.mSP.getString("imei", "");
            String string2 = this.mSP.getString("secondary_imei", "");
            if (TextUtils.isEmpty(deviceId) || (!deviceId.equals(string) && !deviceId.equals(string2))) {
                Logger.m17378d(TAG, "findNewImei true");
                z = true;
            } else {
                z = false;
            }
            if (z && !TextUtils.isEmpty(deviceId)) {
                String buildFullUri = buildFullUri(this.mContext);
                Logger.m17378d(TAG, "try fullUmidFromServer... url: " + buildFullUri);
                NetResponse stringPartRequest = HttpSecureRequester.getInstance(this.mContext).stringPartRequest(buildFullUri, "POST", (Map<String, String>) null, (String) null);
                Logger.m17378d(TAG, "fullUmidIds, response: " + stringPartRequest);
                handleResponse(stringPartRequest);
            }
        } else {
            Logger.m17378d(TAG, "getUmidFromServer, cta -> boot guide ing...");
        }
    }

    private boolean handleResponse(NetResponse netResponse) {
        if (netResponse == null || netResponse.getResponseCode() != 200 || netResponse.getResponseBody() == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(netResponse.getResponseBody());
            if (jSONObject.getInt("code") != 200) {
                return false;
            }
            Logger.m17378d(TAG, "Successfully posted to " + UxipConstants.GET_UMID_URL);
            JSONObject jSONObject2 = jSONObject.getJSONObject("value");
            String string = jSONObject2.getString("umid");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            Logger.m17378d(TAG, "new umid " + string);
            SharedPreferences.Editor edit = this.mSP.edit();
            edit.putString(PREFERENCES_KEY_UMID, string);
            edit.putString("imei", jSONObject2.getString("imei"));
            edit.putString("secondary_imei", jSONObject2.getString("secondary_imei"));
            edit.putString("sn", jSONObject2.getString("sn"));
            edit.apply();
            return true;
        } catch (JSONException e) {
            Logger.m17382w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            return false;
        }
    }

    private String getMacWithoutColon() {
        String mACAddress = NetInfoUtils.getMACAddress(this.mContext);
        return mACAddress != null ? mACAddress.replace(SystemInfoUtil.COLON, "").toUpperCase() : mACAddress;
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

    private String buildGetUri(Context context) {
        Uri.Builder buildUpon = Uri.parse(UxipConstants.GET_UMID_URL).buildUpon();
        HashMap hashMap = new HashMap();
        String terType = getTerType();
        buildUpon.appendQueryParameter(Parameters.TER_TYPE, terType);
        hashMap.put(Parameters.TER_TYPE, terType);
        if (!FlymeOSUtils.isBox(context) && !FlymeOSUtils.isTablet(context)) {
            buildUpon.appendQueryParameter("imei", FlymeOSUtils.getDeviceId(context));
            hashMap.put("imei", FlymeOSUtils.getDeviceId(context));
        }
        buildUpon.appendQueryParameter("os_type", "android");
        hashMap.put("os_type", "android");
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        String macWithoutColon = getMacWithoutColon();
        buildUpon.appendQueryParameter("mac", macWithoutColon);
        hashMap.put("mac", macWithoutColon);
        String sn = FlymeOSUtils.getSN();
        hashMap.put("sn", sn);
        buildUpon.appendQueryParameter("sn", sn);
        String androidId = FlymeOSUtils.getAndroidId(context);
        buildUpon.appendQueryParameter(Parameters.ANDROID_ID, androidId);
        hashMap.put(Parameters.ANDROID_ID, androidId);
        boolean z = FlymeOSUtils.isBrandMeizu() && !FlymeOSUtils.isPreFlyme8();
        if (FlymeOSUtils.kaiJiXiangDao(this.mContext) && (z || C2943Utils.isAndroidQ())) {
            IDIdentifierController instance = IDIdentifierController.getInstance(this.mContext);
            String oaid = instance.getOAID();
            buildUpon.appendQueryParameter(Parameters.OAID, oaid);
            hashMap.put(Parameters.OAID, oaid);
            String vaid = instance.getVAID();
            buildUpon.appendQueryParameter(Parameters.VAID, vaid);
            hashMap.put(Parameters.VAID, vaid);
            String aaid = instance.getAAID();
            buildUpon.appendQueryParameter(Parameters.AAID, aaid);
            hashMap.put(Parameters.AAID, aaid);
            if (FlymeOSUtils.isBrandMeizu()) {
                String udid = instance.getUDID();
                if (!TextUtils.isEmpty(udid)) {
                    buildUpon.appendQueryParameter(Parameters.UDID, udid);
                    hashMap.put(Parameters.UDID, udid);
                }
            }
        }
        String str = z ? "1" : "0";
        buildUpon.appendQueryParameter(Parameters.FLYME8_NEXT, str);
        hashMap.put(Parameters.FLYME8_NEXT, str);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String valueOf = String.valueOf(currentTimeMillis);
        buildUpon.appendQueryParameter("ts", valueOf);
        hashMap.put("ts", valueOf);
        String valueOf2 = String.valueOf(currentTimeMillis + ((long) new Random().nextInt()));
        buildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        hashMap.put(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        for (Map.Entry entry : hashMap.entrySet()) {
            Logger.m17378d(TAG, "buildGetUri, uriParam: " + ((String) entry.getKey()) + SystemInfoUtil.COMMA + ((String) entry.getValue()));
        }
        buildUpon.appendQueryParameter("sign", NetRequestUtil.sign("GET", UxipConstants.GET_UMID_URL, hashMap, (Map<String, String>) null));
        return buildUpon.toString();
    }

    private String buildFullUri(Context context) {
        Uri.Builder buildUpon = Uri.parse(UxipConstants.GET_UMID_URL).buildUpon();
        HashMap hashMap = new HashMap();
        String terType = getTerType();
        buildUpon.appendQueryParameter(Parameters.TER_TYPE, terType);
        hashMap.put(Parameters.TER_TYPE, terType);
        if (!FlymeOSUtils.isBox(context) && !FlymeOSUtils.isTablet(context)) {
            buildUpon.appendQueryParameter("imei", FlymeOSUtils.getDeviceId(context));
            hashMap.put("imei", FlymeOSUtils.getDeviceId(context));
        }
        buildUpon.appendQueryParameter("os_type", "android");
        hashMap.put("os_type", "android");
        String androidId = FlymeOSUtils.getAndroidId(context);
        buildUpon.appendQueryParameter(Parameters.ANDROID_ID, androidId);
        hashMap.put(Parameters.ANDROID_ID, androidId);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String valueOf = String.valueOf(currentTimeMillis);
        buildUpon.appendQueryParameter("ts", valueOf);
        hashMap.put("ts", valueOf);
        String valueOf2 = String.valueOf(currentTimeMillis + ((long) new Random().nextInt()));
        buildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        hashMap.put(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        String string = this.mSP.getString(PREFERENCES_KEY_UMID, "");
        buildUpon.appendQueryParameter("umid", string);
        hashMap.put("umid", string);
        for (Map.Entry entry : hashMap.entrySet()) {
            Logger.m17378d(TAG, "buildFullUri, uriParam: " + ((String) entry.getKey()) + SystemInfoUtil.COMMA + ((String) entry.getValue()));
        }
        buildUpon.appendQueryParameter("sign", NetRequestUtil.sign("POST", UxipConstants.GET_UMID_URL, hashMap, (Map<String, String>) null));
        return buildUpon.toString();
    }
}
