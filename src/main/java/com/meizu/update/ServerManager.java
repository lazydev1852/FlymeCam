package com.meizu.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.p020ar.constants.HttpConstants;
import com.meizu.savior.Constants;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.update.p083a.UpdateInfoCache;
import com.meizu.update.util.HttpLoadException;
import com.meizu.update.util.Loger;
import com.meizu.update.util.UrlRequest;
import com.meizu.update.util.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.update.d */
public class ServerManager {
    /* renamed from: a */
    public static final UpdateInfo m17683a(Context context) {
        return m17684a(context, context.getPackageName());
    }

    /* renamed from: a */
    public static final UpdateInfo m17684a(Context context, String str) {
        try {
            return m17694b(context, str);
        } catch (HttpLoadException e) {
            Loger.m17943d("ServerManager --> checkUpdate Error: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static final List<UpdateInfo> m17687a(Context context, List<PackageInfo> list, boolean z) {
        return m17688a(context, list, z, (List<String>) null);
    }

    /* renamed from: a */
    public static final List<UpdateInfo> m17688a(Context context, List<PackageInfo> list, boolean z, List<String> list2) {
        String str;
        Context context2 = context;
        List<PackageInfo> list3 = list;
        List<String> list4 = list2;
        if (context2 == null || list3 == null || list.size() == 0) {
            Loger.m17943d("ServerManager --> checkUpdateMulti: Illegal Plugin check params ! ");
            return null;
        }
        try {
            String q = Utility.m17998q(context);
            String q2 = Utility.m17998q(context);
            String d = Utility.m17979d(context);
            String f = Utility.m17986f(context);
            String c = Utility.m17974c(context);
            String b = Utility.m17969b(context);
            String a = Utility.m17958a();
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < list.size()) {
                PackageInfo packageInfo = list3.get(i);
                if (m17691a(packageInfo)) {
                    String str2 = packageInfo.packageName;
                    String str3 = packageInfo.versionName;
                    int i2 = packageInfo.versionCode;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("serviceName", str2);
                    jSONObject.put(UxipConstants.RESPONSE_KEY_VERSION, str3);
                    jSONObject.put("versionCode", i2);
                    if (list4 != null && list4.contains(str2)) {
                        jSONObject.put("patch", String.valueOf(1));
                    }
                    jSONArray.put(jSONObject);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ServerManager --> checkUpdateMulti invalid packageInfo : ");
                    sb.append(packageInfo);
                    Loger.m17942c(sb.toString() == null ? "" : packageInfo.packageName);
                }
                i++;
                list3 = list;
            }
            if (jSONArray.length() == 0) {
                Loger.m17943d("ServerManager --> checkUpdateMulti no valid packageInfos!");
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deviceType", d);
            jSONObject2.put("firmware", c);
            jSONObject2.put("sysVer", b);
            jSONObject2.put("imei", q);
            jSONObject2.put("deviceId", q2);
            jSONObject2.put("sn", f);
            jSONObject2.put("displayId", a);
            jSONObject2.put("services", jSONArray);
            if (list4 == null) {
                String jSONObject3 = jSONObject2.toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(jSONObject3);
                stringBuffer.append("2635881a7ab0593849fe89e685fc56cd");
                str = m17685a(context2, jSONObject3, Utility.m17971b(stringBuffer.toString()), Utility.m18001t(context));
            } else {
                String jSONObject4 = jSONObject2.toString();
                String valueOf = String.valueOf(System.currentTimeMillis());
                str = m17686a(context2, jSONObject4, Utility.m17963a(jSONObject4, valueOf, "325POre45f12iplghn196yUTrhgvcxAz"), valueOf);
            }
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList.add(list.get(i3).packageName);
                }
                List<UpdateInfo> a2 = m17689a(str, (List<String>) arrayList, false);
                if (a2 == null || a2.size() <= 0) {
                    Loger.m17943d("UpdateInfos parse failed!" + str);
                } else {
                    for (int i4 = 0; i4 < a2.size(); i4++) {
                        UpdateInfo updateInfo = a2.get(i4);
                        if (!updateInfo.mExistsUpdate) {
                            Loger.m17941b("PackageName: " + updateInfo.mPackageName + " no update");
                        } else if (z) {
                            if (a2.size() == 1) {
                                if (((String) arrayList.get(0)).equalsIgnoreCase(context.getPackageName())) {
                                    UpdateInfoCache.m17544a(context2, str);
                                    UpdateInfoCache.m17543a(context);
                                }
                            }
                        }
                    }
                }
                return a2;
            }
            Loger.m17943d("check update multi response null!");
            return null;
        } catch (Exception e) {
            Loger.m17943d("ServerManager --> checkUpdateMulti Exception: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static final CdnCheckInfo m17693b(Context context) {
        PackageInfo packageInfo;
        ArrayList arrayList = new ArrayList();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        arrayList.add(packageInfo);
        return m17681a(context, (List<PackageInfo>) arrayList);
    }

    /* renamed from: a */
    public static final CdnCheckInfo m17681a(Context context, List<PackageInfo> list) {
        if (context == null || list == null || list.size() == 0) {
            Loger.m17943d("ServerManager --> checkCdn: Illegal params!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (m17691a(list.get(i))) {
                arrayList.add(list.get(i));
            }
        }
        if (arrayList.size() == 0) {
            Loger.m17942c("ServerManager --> checkCdn: appInfos size is 0!");
            return null;
        }
        try {
            String b = Utility.m17969b(context);
            String d = Utility.m17979d(context);
            String a = Utility.m17958a();
            String c = Utility.m17974c(context);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = ((PackageInfo) arrayList.get(i2)).packageName;
                String str2 = ((PackageInfo) arrayList.get(i2)).versionName;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", str);
                jSONObject.put(UxipConstants.RESPONSE_KEY_VERSION, str2);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("subService", jSONArray);
            jSONObject2.put("maskId", b);
            jSONObject2.put("productType", d);
            jSONObject2.put("androidVersion", c);
            jSONObject2.put("displayId", a);
            String jSONObject3 = jSONObject2.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jSONObject3);
            stringBuffer.append("2635881a7ab0593849fe89e685fc56cd");
            String b2 = Utility.m17971b(stringBuffer.toString());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Pair("apps", jSONObject3));
            arrayList2.add(new Pair("sign", b2));
            String a2 = UrlRequest.m17953a(context, Constants.f16136d, arrayList2);
            if (!TextUtils.isEmpty(a2)) {
                return m17682a(a2);
            }
            Loger.m17943d("check CDN response is null!");
            return null;
        } catch (Exception e) {
            Loger.m17943d("ServerManager --> checkCdn: Excpetion: " + e.toString());
            return null;
        }
    }

    /* renamed from: b */
    public static final List<UpdateInfo> m17695b(Context context, List<String> list, boolean z) {
        if (context == null || list == null || list.size() == 0) {
            Loger.m17943d("ServerManager --> checkUpdateMulti: Illegal Plugin check params ! ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = next;
            packageInfo.versionName = Utility.m17961a(context, next);
            packageInfo.versionCode = Utility.m17985f(context, next);
            arrayList.add(packageInfo);
        }
        return m17687a(context, (List<PackageInfo>) arrayList, z);
    }

    /* renamed from: b */
    public static final UpdateInfo m17694b(Context context, String str) throws HttpLoadException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<UpdateInfo> b = m17695b(context, arrayList, true);
        if (b == null || b.size() != 1) {
            return null;
        }
        return b.get(0);
    }

    /* renamed from: a */
    private static String m17686a(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("apps", str));
        arrayList.add(new Pair("sign", str2));
        arrayList.add(new Pair(HttpConstants.TIMESTAMP, str3));
        return UrlRequest.m17953a(context, Constants.f16137e, arrayList);
    }

    /* renamed from: a */
    private static String m17685a(Context context, String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("apps", str));
        arrayList.add(new Pair("sign", str2));
        arrayList.add(new Pair("unitType", String.valueOf(i)));
        return UrlRequest.m17953a(context, Constants.f16134b, arrayList);
    }

    /* renamed from: a */
    public static List<UpdateInfo> m17689a(String str, List<String> list, boolean z) throws JSONException {
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject(str).getJSONObject("reply");
        int i = jSONObject.getInt("code");
        if (i == 200) {
            Loger.m17939a("UpdateInfos: " + jSONObject.toString());
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            int length = jSONArray.length();
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("serviceName");
                    if (m17692a(list, string)) {
                        UpdateInfo updateInfo = new UpdateInfo();
                        if (!z) {
                            str2 = "existsUpdate";
                        } else {
                            str2 = "existsCurrVersion";
                        }
                        updateInfo.mExistsUpdate = jSONObject2.getBoolean(str2);
                        if (jSONObject2.has("serviceName")) {
                            updateInfo.mPackageName = jSONObject2.getString("serviceName");
                        }
                        if (updateInfo.mExistsUpdate) {
                            updateInfo.mUpdateUrl = jSONObject2.getString("updateUrl");
                            updateInfo.mSize = jSONObject2.getString("fileSize");
                            updateInfo.mVersionDate = jSONObject2.getString("releaseDate");
                            updateInfo.mVersionDesc = jSONObject2.getString("releaseNote");
                            if (!z) {
                                str3 = "latestVersion";
                            } else {
                                str3 = UxipConstants.RESPONSE_KEY_VERSION;
                            }
                            updateInfo.mVersionName = jSONObject2.getString(str3);
                            if (jSONObject2.has("digest")) {
                                updateInfo.mDigest = jSONObject2.getString("digest");
                            }
                            if (jSONObject2.has("verifyMode")) {
                                updateInfo.mVerifyMode = jSONObject2.getInt("verifyMode");
                            }
                            if (jSONObject2.has("size")) {
                                updateInfo.mSizeByte = jSONObject2.getLong("size");
                            }
                            if (jSONObject2.has("updateUrl2")) {
                                updateInfo.mUpdateUrl2 = jSONObject2.getString("updateUrl2");
                            }
                            if (!z) {
                                if (jSONObject2.has("latestVersionCode")) {
                                    updateInfo.mVersionCode = jSONObject2.getInt("latestVersionCode");
                                }
                            } else if (jSONObject2.has("versionCode")) {
                                updateInfo.mVersionCode = jSONObject2.getInt("versionCode");
                            }
                            if (Utility.m17981d() && !TextUtils.isEmpty(updateInfo.mVersionName) && updateInfo.mVersionName.endsWith("_i")) {
                                updateInfo.mVersionName = updateInfo.mVersionName.substring(0, updateInfo.mVersionName.length() - "_i".length());
                            }
                            if (jSONObject2.has("noteNetwork")) {
                                updateInfo.mNoteNetWork = jSONObject2.getBoolean("noteNetwork");
                            }
                            if (jSONObject2.has("silentUpgrade")) {
                                updateInfo.mSilentUpgrade = jSONObject2.getInt("silentUpgrade");
                            }
                            if (jSONObject2.has("upgradeCondition")) {
                                updateInfo.mUpgradeCondition = jSONObject2.getInt("upgradeCondition");
                            }
                            if (jSONObject2.has("advancedOptions")) {
                                updateInfo.mAdvancedOptions = jSONObject2.getInt("advancedOptions");
                            }
                            if (jSONObject2.has("patch")) {
                                updateInfo.mIsPatch = jSONObject2.getBoolean("patch");
                                if (updateInfo.mIsPatch) {
                                    if (jSONObject2.has("svn")) {
                                        String string2 = jSONObject2.getString("svn");
                                        if (TextUtils.isEmpty(string2) || !string2.endsWith(Constants.PACKNAME_END)) {
                                            updateInfo.mSourceVersionName = string2;
                                        } else {
                                            updateInfo.mSourceVersionName = string2.replace(Constants.PACKNAME_END, "");
                                        }
                                    }
                                    if (jSONObject2.has("sDigest")) {
                                        updateInfo.mSourceMsgDigest = jSONObject2.getString("sDigest");
                                    }
                                    if (jSONObject2.has("sSize")) {
                                        updateInfo.mSourceFileSize = jSONObject2.getLong("sSize");
                                    }
                                    if (jSONObject2.has("fDigest")) {
                                        updateInfo.mTargetMsgDigest = jSONObject2.getString("fDigest");
                                    }
                                    if (jSONObject2.has("fSize")) {
                                        updateInfo.mTargetFileSize = jSONObject2.getLong("fSize");
                                    }
                                }
                            }
                        }
                        arrayList.add(updateInfo);
                    } else {
                        Loger.m17943d("server return package : " + string);
                    }
                }
                return arrayList;
            }
            Loger.m17943d("server return size : " + length);
            return null;
        }
        Loger.m17942c("unknown server code : " + i);
        return null;
    }

    /* renamed from: a */
    public static CdnCheckInfo m17682a(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            Loger.m17943d("ServerManager parseCdnCheckInfo : res is null!");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("code") == 200) {
                Loger.m17939a("CdnCheckInfo : " + jSONObject.toString());
                JSONObject jSONObject2 = jSONObject.getJSONObject("value");
                CdnCheckInfo cdnCheckInfo = new CdnCheckInfo();
                if (jSONObject2.has("delay")) {
                    cdnCheckInfo.mDelay = jSONObject2.getBoolean("delay");
                }
                if (jSONObject2.has("allowPackages") && (jSONArray = jSONObject2.getJSONArray("allowPackages")) != null && jSONArray.length() > 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.get(i).toString();
                    }
                    cdnCheckInfo.mAllowPackages = strArr;
                }
                if (jSONObject2.has("strategy")) {
                    cdnCheckInfo.mStrategy = jSONObject2.getString("strategy");
                }
                if (jSONObject2.has("allowRate")) {
                    cdnCheckInfo.mAllowRate = jSONObject2.getDouble("allowRate");
                }
                if (jSONObject2.has("delaySecond")) {
                    cdnCheckInfo.mDelaySecond = jSONObject2.getInt("delaySecond");
                }
                return cdnCheckInfo;
            }
        } catch (Exception e) {
            Loger.m17943d("ServerManager parseCdnCheckInfo exception: " + e.toString());
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m17690a(Context context, HashMap<PackageInfo, String> hashMap) {
        Context context2 = context;
        HashMap<PackageInfo, String> hashMap2 = hashMap;
        if (context2 == null || hashMap2 == null || hashMap.size() == 0) {
            Loger.m17943d("ServerManager --> registerPushMulti: Illegal Plugin check params ! ");
            return false;
        }
        try {
            Loger.m17938a(context2, "start register push to server");
            String q = Utility.m17998q(context);
            String q2 = Utility.m17998q(context);
            String d = Utility.m17979d(context);
            String f = Utility.m17986f(context);
            String c = Utility.m17974c(context);
            String b = Utility.m17969b(context);
            String a = Utility.m17958a();
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo next : hashMap.keySet()) {
                if (m17691a(next)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("serviceName", next.packageName);
                        jSONObject.put("subStatus", 1);
                        jSONObject.put(UxipConstants.RESPONSE_KEY_VERSION, next.versionName);
                        jSONObject.put("versionCode", next.versionCode);
                        jSONObject.put("serviceToken", hashMap2.get(next));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        Loger.m17943d("ServerManager --> registerPushMulti push to server jsonException:" + e.toString());
                    }
                }
            }
            if (jSONArray.length() == 0) {
                Loger.m17943d("ServerManager --> registerPushMulti no valid packageInfos!");
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deviceType", d);
            jSONObject2.put("firmware", c);
            jSONObject2.put("sysVer", b);
            jSONObject2.put("displayId", a);
            jSONObject2.put("imei", q);
            jSONObject2.put("deviceId", q2);
            jSONObject2.put("sn", f);
            jSONObject2.put("services", jSONArray);
            String jSONObject3 = jSONObject2.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jSONObject3);
            stringBuffer.append("2635881a7ab0593849fe89e685fc56cd");
            return m17696b(context2, jSONObject3, Utility.m17971b(stringBuffer.toString()), Utility.m18001t(context));
        } catch (Exception e2) {
            Loger.m17938a(context2, "ServerManager --> registerPush exception:" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m17697c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            Loger.m17938a(context, "registerPush --> can not find packageInfo!");
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(packageInfo, str);
        return m17690a(context, (HashMap<PackageInfo, String>) hashMap);
    }

    /* renamed from: b */
    private static boolean m17696b(Context context, String str, String str2, int i) throws JSONException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("subservices", str));
        arrayList.add(new Pair("sign", str2));
        String a = UrlRequest.m17953a(context, Constants.f16139g, arrayList);
        if (a == null) {
            Loger.m17938a(context, "register push response null");
            return false;
        } else if (new JSONObject(a).getJSONObject("reply").getInt("code") == 200) {
            Loger.m17938a(context, "register push success");
            return true;
        } else {
            Loger.m17938a(context, "register push failed: " + a);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m17692a(List<String> list, String str) {
        if (list == null || list.size() == 0 || str.equalsIgnoreCase("")) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (str.equalsIgnoreCase(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m17691a(PackageInfo packageInfo) {
        if (packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName) && !packageInfo.packageName.trim().equals("") && !TextUtils.isEmpty(packageInfo.versionName) && !packageInfo.versionName.trim().equals("") && packageInfo.versionCode > 0) {
            return true;
        }
        return false;
    }
}
