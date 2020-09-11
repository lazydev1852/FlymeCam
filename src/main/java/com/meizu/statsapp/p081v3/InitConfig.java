package com.meizu.statsapp.p081v3;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.InitConfig */
public class InitConfig {
    public static boolean forceOffline = false;
    public static boolean mainThreadInit = false;
    public static boolean noBootUp = false;
    public static boolean noEncrypt = false;
    public static boolean offline = true;
    public static boolean printLog = false;
    public static String replacePackage = "";
    public static boolean reportLocation = true;
    public static boolean sendEventSync = false;
    public static boolean useInternationalDomain = false;

    @Deprecated
    public InitConfig setCatchEveryExIfPossible(boolean z) {
        return this;
    }

    public InitConfig setReportLocation(boolean z) {
        reportLocation = z;
        return this;
    }

    public InitConfig setNoBootUp(boolean z) {
        noBootUp = z;
        return this;
    }

    public InitConfig setOffline(boolean z) {
        offline = z;
        return this;
    }

    public InitConfig setMainThreadInit(boolean z) {
        mainThreadInit = z;
        return this;
    }

    public InitConfig setNoEncrypt(boolean z) {
        noEncrypt = z;
        return this;
    }

    public InitConfig replacePackage(String str) {
        Log.d("UsageStatsProxy3", "##### InitConfig replacePackage: " + str);
        if (!TextUtils.isEmpty(str)) {
            replacePackage = str;
            return this;
        }
        throw new IllegalStateException("InitConfig - replacePackage can't be empty if set");
    }

    public InitConfig setUseInternationalDomain(boolean z) {
        useInternationalDomain = z;
        return this;
    }

    public InitConfig setSendEventSync(boolean z) {
        sendEventSync = z;
        return this;
    }

    public InitConfig setPrintLog(boolean z) {
        printLog = z;
        return this;
    }

    public InitConfig setForceOffline(boolean z) {
        forceOffline = z;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reportLocation", reportLocation);
            jSONObject.put("noBootUp", noBootUp);
            jSONObject.put("offline", offline);
            jSONObject.put("mainThreadInit", mainThreadInit);
            jSONObject.put("noEncrypt", noEncrypt);
            jSONObject.put("replacePackage", replacePackage);
            jSONObject.put("useInternationalDomain", useInternationalDomain);
            jSONObject.put("sendEventSync", sendEventSync);
            jSONObject.put("printLog", printLog);
            jSONObject.put("forceOffline", forceOffline);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
