package com.meizu.cloud.pushsdk.analytics;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.base.DeviceUtils;
import com.meizu.cloud.pushsdk.pushtracer.utils.Util;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;

public class PayloadSub {
    public static final String TAG = "PayloadSub";
    private HashMap<String, Object> appInfoPairs;
    private HashMap<String, String> deviceInfoPairs;
    private HashMap<String, Object> locationPairs;
    private HashMap<String, String> userInfoPairs;

    public static class PayloadSubBuilder {
        /* access modifiers changed from: private */
        public Context context = null;

        public PayloadSubBuilder context(Context context2) {
            this.context = context2;
            return this;
        }

        public PayloadSub build() {
            return new PayloadSub(this);
        }
    }

    private PayloadSub(PayloadSubBuilder payloadSubBuilder) {
        this.userInfoPairs = new HashMap<>();
        this.deviceInfoPairs = new HashMap<>();
        this.appInfoPairs = new HashMap<>();
        this.locationPairs = new HashMap<>();
        setDeviceInfo();
        if (payloadSubBuilder.context != null) {
            setContextualParams(payloadSubBuilder.context);
        }
        DebugLogger.m4829i(TAG, "Subject created successfully.");
    }

    public void setContextualParams(Context context) {
        setLocation(context);
        setTelephonyContext(context);
        setDefaultScreenResolution(context);
        setConnectivityContext(context);
        setAppInfoContext(context);
    }

    private void setDeviceInfo() {
        addDeviceInfoContext(Params.BRAND, Build.BRAND);
        addDeviceInfoContext(Params.DEVICE, Build.MODEL);
        addDeviceInfoContext(Params.OS_TYPE, Build.VERSION.RELEASE);
        addDeviceInfoContext(Params.OS_VERSION, Build.DISPLAY);
        addDeviceInfoContext(Params.LOCAL_LANGUAGE, MzSystemUtils.getCurrentLanguage());
    }

    private void setAppInfoContext(Context context) {
        addAppInfoContext(Params.PACKAGE_NAME, context.getPackageName());
        addAppInfoContext(Params.PACKAGE_VERSION, MzSystemUtils.getAppVersionName(context));
        addAppInfoContext(Params.PACKAGE_VERSION_CODE, Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        addAppInfoContext(Params.PACKAGE_LIST, MzSystemUtils.getInstalledPackage(context));
    }

    private void setLocation(Context context) {
        Location location = Util.getLocation(context);
        if (location == null) {
            DebugLogger.m4828e(TAG, "Location information not available.");
            return;
        }
        addLocationInfoContext(Params.LONGITUDE, Double.valueOf(location.getLongitude()));
        addLocationInfoContext(Params.ATITUDE, Double.valueOf(location.getAltitude()));
    }

    private void setTelephonyContext(Context context) {
        addUserInfoContext(Params.IMEI, MzSystemUtils.getDeviceId(context));
        addUserInfoContext(Params.IMSI_1, MzSystemUtils.getSubscribeId(context));
        addUserInfoContext(Params.PHONE_NUMBER, MzSystemUtils.getLineNumber(context));
        addDeviceInfoContext(Params.OPERATOR, MzSystemUtils.getOperator(context));
    }

    private void setConnectivityContext(Context context) {
        addDeviceInfoContext(Params.MAC_ADDRESS, DeviceUtils.getMACAddress(context));
        addLocationInfoContext(Params.NETWORK_TYPE, MzSystemUtils.getNetWorkType(context));
        addLocationInfoContext(Params.WIFI_BSSID, MzSystemUtils.getBSSID(context));
    }

    @TargetApi(19)
    public void setDefaultScreenResolution(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        try {
            Display.class.getMethod("getSize", new Class[]{Point.class});
            defaultDisplay.getSize(point);
            setScreenResolution(point.x, point.y);
        } catch (NoSuchMethodException unused) {
            DebugLogger.m4828e(TAG, "Display.getSize isn't available on older devices.");
            setScreenResolution(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
    }

    public void setScreenResolution(int i, int i2) {
        this.deviceInfoPairs.put(Params.SCREEN_SIZE, Integer.toString(i) + "." + Integer.toString(i2));
    }

    private void addUserInfoContext(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.userInfoPairs.put(str, str2);
        }
    }

    private void addDeviceInfoContext(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.deviceInfoPairs.put(str, str2);
        }
    }

    private void addAppInfoContext(String str, Object obj) {
        if ((!TextUtils.isEmpty(str) && obj != null) || ((obj instanceof String) && !((String) obj).isEmpty())) {
            this.appInfoPairs.put(str, obj);
        }
    }

    private void addLocationInfoContext(String str, Object obj) {
        if ((!TextUtils.isEmpty(str) && obj != null) || ((obj instanceof String) && !((String) obj).isEmpty())) {
            this.locationPairs.put(str, obj);
        }
    }

    public Map<String, String> getUserInfoSubject() {
        return this.userInfoPairs;
    }

    public Map<String, String> getDeviceInfoSubject() {
        return this.deviceInfoPairs;
    }

    public Map<String, Object> getAppInfoSubject() {
        return this.appInfoPairs;
    }

    public Map<String, Object> getLocationInfoSubject() {
        return this.locationPairs;
    }
}
