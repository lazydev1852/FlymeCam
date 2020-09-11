package com.baidu.p020ar.bean;

import android.content.Context;
import android.os.Build;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.DeviceUuidFactory;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.ar.bean.ARPConfig */
public class ARPConfig {
    public static final String APP_CHANNEL = "channel";
    public static final String APP_VERSION = "app_version";
    public static final String AR_KEY = "ar_key";
    public static final String AR_TYPE = "ar_type";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_TYPE = "device_type";
    public static final String KEY_EXTRA_INFO = "extra_info";
    public static final String OS_TYPE = "os_type";
    public static final String OS_VERSION = "os_version";

    /* renamed from: a */
    private static String f1063a;

    /* renamed from: b */
    private static String f1064b;

    public static Map getUserInfoData() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", String.valueOf(ARSDKInfo.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", f1063a);
        hashMap.put("extra_info", ARConfig.getARExtraInfo());
        hashMap.put("os_type", "android");
        hashMap.put("device_type", Build.BRAND);
        hashMap.put(APP_CHANNEL, f1064b);
        return hashMap;
    }

    public static void initARConfig(Context context) {
        f1063a = new DeviceUuidFactory(context).getDeviceUuid().toString();
        f1064b = ARSDKInfo.getAppId(context);
    }
}
