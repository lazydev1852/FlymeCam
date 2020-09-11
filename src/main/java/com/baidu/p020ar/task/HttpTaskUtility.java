package com.baidu.p020ar.task;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.DuMixARConfig;
import com.baidu.p020ar.constants.ARConfigKey;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.p035b.C0602a;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.DeviceUuidFactory;
import com.baidu.p020ar.util.NetworkUtil;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.baidu.p020ar.util.UrlUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.task.HttpTaskUtility */
public final class HttpTaskUtility {
    /* renamed from: a */
    private static String m2647a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            addBasicInfo(context, jSONObject);
            m2648a(context, jSONObject, ARConfig.getARKey(), ARConfig.getARId());
            addSystemInfo(context, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static void m2648a(Context context, JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            ARLog.m2696e("bdar: addCaseParams httpParams is null!!!");
            return;
        }
        String arValue = ARConfig.getArValue();
        JSONObject jSONObject2 = arValue != null ? new JSONObject(arValue) : new JSONObject();
        UUID deviceUuid = new DeviceUuidFactory(context).getDeviceUuid();
        if (deviceUuid != null) {
            jSONObject2.put(HttpConstants.HTTP_USER_ID, deviceUuid.toString());
        }
        jSONObject.put(HttpConstants.HTTP_AR_VALUE, jSONObject2.toString());
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("ar_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(ARConfigKey.AR_ID, str2);
        } else {
            jSONObject.put(ARConfigKey.AR_ID, "");
        }
    }

    public static void addBasicInfo(Context context, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            ARLog.m2696e("bdar: addBasicInfo mapParams is null!!!");
            return;
        }
        hashMap.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        hashMap.put(HttpConstants.IS_AIP, C0602a.m1215a());
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("sign", ARConfig.getSignature(currentTimeMillis));
        hashMap.put(HttpConstants.TIMESTAMP, currentTimeMillis + "");
        UUID deviceUuid = new DeviceUuidFactory(context).getDeviceUuid();
        if (deviceUuid != null) {
            hashMap.put(HttpConstants.HTTP_USER_ID, deviceUuid.toString());
        }
        hashMap.put(HttpConstants.CUID, ARConfig.getCUID());
    }

    public static void addBasicInfo(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            ARLog.m2696e("bdar: addBasicInfo jsonParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put(HttpConstants.IS_AIP, C0602a.m1215a());
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("sign", ARConfig.getSignature(currentTimeMillis));
        jSONObject.put(HttpConstants.TIMESTAMP, currentTimeMillis + "");
        UUID deviceUuid = new DeviceUuidFactory(context).getDeviceUuid();
        if (deviceUuid != null) {
            jSONObject.put(HttpConstants.HTTP_USER_ID, deviceUuid.toString());
        }
        jSONObject.put(HttpConstants.CUID, ARConfig.getCUID());
    }

    public static void addSystemInfo(Context context, JSONObject jSONObject) {
        String str;
        Object asList;
        if (context == null || jSONObject == null) {
            ARLog.m2696e("bdar: addSystemInfo context/httpParams is null!!!");
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put("os_type", "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, ARSDKInfo.getVersionCode());
        jSONObject.put("app_id", ARSDKInfo.getAppId(context));
        jSONObject.put("device_id", Build.MODEL);
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] romMemroy = SystemInfoUtil.getRomMemroy();
        boolean z = false;
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, romMemroy[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, romMemroy[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, SystemInfoUtil.getSDCardTotalSize());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, SystemInfoUtil.getSDAvailableSizeByM());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, SystemInfoUtil.getRamMemory(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, SystemInfoUtil.getAvailMemory(context));
        if (SystemInfoUtil.isHasGyroscope(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, SystemInfoUtil.getCpuName());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, SystemInfoUtil.getNumCores());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, SystemInfoUtil.getMinCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, SystemInfoUtil.getMaxCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, SystemInfoUtil.getCurCpuFreq());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null) {
            z = true;
        }
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, z);
        jSONObject.put(HttpConstants.NETWORK_TYPE, NetworkUtil.getNetworkType(context));
        if (Build.VERSION.SDK_INT < 21) {
            str = HttpConstants.OS_CPU_SUPPORTED_ABIS;
            asList = Build.CPU_ABI;
        } else {
            str = HttpConstants.OS_CPU_SUPPORTED_ABIS;
            asList = Arrays.asList(Build.SUPPORTED_ABIS);
        }
        jSONObject.put(str, asList);
        jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
    }

    /* renamed from: b */
    private static String m2649b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            addBasicInfo(context, jSONObject);
            jSONObject.put(HttpConstants.SDK_TYPE, ARSDKInfo.getSDKType());
            jSONObject.put(HttpConstants.FUNCTION_TYPE, ARSDKInfo.getFunctionType());
            jSONObject.put(HttpConstants.SDK_VERSION_CODE, ARSDKInfo.getVersionCode());
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, ARSDKInfo.getVersionName());
            jSONObject.put("os_type", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_id", Build.MODEL.toLowerCase());
            jSONObject.put("ar_key", ARConfig.getARKey());
            jSONObject.put("ar_type", ARConfig.getARType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static HttpHandle doAuth(Context context, HttpResponseListener<JSONObject> httpResponseListener) {
        String b = m2649b(context);
        C0902b bVar = new C0902b(context, UrlUtils.getAipAuthUrl(), httpResponseListener);
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{b});
        return bVar;
    }

    public static HttpHandle doQueryArResource(Context context, HttpResponseListener<JSONObject> httpResponseListener) {
        String queryResourceUrl = UrlUtils.getQueryResourceUrl();
        ARLog.m2695d("doQueryArResource: " + queryResourceUrl);
        String a = m2647a(context);
        ARLog.m2695d("doQueryArResource: " + a);
        C0902b bVar = new C0902b(queryResourceUrl, httpResponseListener);
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{a});
        return bVar;
    }

    public static String getHttpParamsForCaseSwitch(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("update_check", String.valueOf(1));
        return getHttpParamsWithKeyAndMap(context, str, hashMap);
    }

    public static String getHttpParamsForMM(Context context) {
        return m2647a(context);
    }

    public static String getHttpParamsWithKey(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            addBasicInfo(context, jSONObject);
            m2648a(context, jSONObject, str, (String) null);
            addSystemInfo(context, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getHttpParamsWithKeyAndMap(Context context, String str, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            addBasicInfo(context, jSONObject);
            m2648a(context, jSONObject, str, (String) null);
            addSystemInfo(context, jSONObject);
            if (map != null && map.size() > 0) {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
