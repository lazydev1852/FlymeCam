package com.meizu.statsapp.p081v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.TerType;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.OSUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.DeviceInfo */
public class DeviceInfo {
    private static final String TAG = "DeviceInfo";
    private HashMap<String, Object> devicesPairs;

    private DeviceInfo(DeviceInfoBuilder deviceInfoBuilder) {
        this.devicesPairs = new HashMap<>();
        setDevice();
        setSn();
        setProductModel();
        setBuildMask();
        setOsType();
        setBrand();
        setOsVersion();
        setOs();
        if (deviceInfoBuilder.context != null) {
            setContextualParams(deviceInfoBuilder.context);
        }
        Logger.m17381v(TAG, "DeviceInfo created successfully.");
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.subject.DeviceInfo$DeviceInfoBuilder */
    public static class DeviceInfoBuilder {
        /* access modifiers changed from: private */
        public Context context = null;

        public DeviceInfoBuilder context(Context context2) {
            this.context = context2;
            return this;
        }

        public DeviceInfo build() {
            return new DeviceInfo(this);
        }
    }

    public void setContextualParams(Context context) {
        setImei(context);
        setCountry(context);
        setOperator(context);
        setInternational(context);
        isRoot(context);
        setFlymeUid(context);
        setMacAddress(context);
        setSre(context);
        setAndroidId(context);
        setAndroidAdId(context);
        setTerType(context);
    }

    private void setDevice() {
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", "").replace("\r", "");
        }
        add(Parameters.DEVICE, str);
    }

    private void setImei(Context context) {
        String deviceId = FlymeOSUtils.getDeviceId(context);
        add("imei", deviceId);
        Logger.m17378d(TAG, "deviceInfo set imei when init, imei: " + deviceId);
    }

    private void setCountry(Context context) {
        String country = FlymeOSUtils.getCountry(context);
        if (!TextUtils.isEmpty(country)) {
            country = country.replace("\n", "").replace("\r", "");
        }
        add(Parameters.COUNTRY, country);
    }

    private void setOperator(Context context) {
        String operator = FlymeOSUtils.getOperator(context);
        if (!TextUtils.isEmpty(operator)) {
            operator = operator.replace("\n", "").replace("\r", "");
        }
        add(Parameters.OPERATOR, operator);
    }

    private void setInternational(Context context) {
        add(Parameters.INTERNATIONAL, (Object) Boolean.valueOf(FlymeOSUtils.firmwareProductInternational()));
    }

    private void isRoot(Context context) {
        add(Parameters.ROOT, (Object) Boolean.valueOf(FlymeOSUtils.isRoot(context)));
    }

    private void setSn() {
        add("sn", FlymeOSUtils.getSN());
    }

    private void setFlymeUid(Context context) {
        if (FlymeOSUtils.isBrandMeizu()) {
            add(Parameters.FLYME_UID, FlymeOSUtils.getFlymeUid(context));
        }
    }

    private void setMacAddress(Context context) {
        add(Parameters.MAC_ADDRESS, NetInfoUtils.getMACAddress(context));
    }

    private void setProductModel() {
        String productModel = FlymeOSUtils.getProductModel();
        if (!TextUtils.isEmpty(productModel)) {
            productModel = productModel.replace("\n", "").replace("\r", "");
        }
        add(Parameters.PRODUCT_MODEL, productModel);
    }

    private void setBuildMask() {
        String buildMask = FlymeOSUtils.getBuildMask();
        if (!TextUtils.isEmpty(buildMask)) {
            buildMask = buildMask.replace("\n", "").replace("\r", "");
        }
        add(Parameters.BUILD_MASK, buildMask);
    }

    private void setSre(Context context) {
        add(Parameters.SRE, FlymeOSUtils.getDisplaySize(context));
    }

    private void setTerType(Context context) {
        if (FlymeOSUtils.isTablet(context)) {
            add(Parameters.TER_TYPE, (Object) Integer.valueOf(TerType.PAD.value()));
        } else if (FlymeOSUtils.isBox(context)) {
            add(Parameters.TER_TYPE, (Object) Integer.valueOf(TerType.FLYME_TV.value()));
        } else {
            add(Parameters.TER_TYPE, (Object) Integer.valueOf(TerType.PHONE.value()));
        }
    }

    private void setOsType() {
        add("os_type", "android");
    }

    private void setBrand() {
        String brand = FlymeOSUtils.getBrand();
        if (!TextUtils.isEmpty(brand)) {
            brand = brand.replace("\n", "").replace("\r", "");
        }
        add(Parameters.BRAND, brand);
    }

    private void setOsVersion() {
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", "").replace("\r", "");
        }
        add("os_version", str);
    }

    private void setOs() {
        boolean isBrandMeizu = FlymeOSUtils.isBrandMeizu();
        Logger.m17378d(TAG, "isBrandMeizu:" + isBrandMeizu);
        if (isBrandMeizu) {
            add(Parameters.f15985OS, "Flyme");
        } else {
            add(Parameters.f15985OS, OSUtils.getOtherBrandOs());
        }
    }

    private void setAndroidId(Context context) {
        String androidId = FlymeOSUtils.getAndroidId(context);
        Logger.m17378d(TAG, "Android ID:" + androidId);
        add(Parameters.ANDROID_ID, androidId);
    }

    private void setAndroidAdId(Context context) {
        String advertisingId = FlymeOSUtils.getAdvertisingId(context);
        Logger.m17378d(TAG, "Advertising ID:" + advertisingId);
        add(Parameters.ANDROID_AD_ID, advertisingId);
    }

    private void add(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null) {
            this.devicesPairs.put(str, str2);
        }
    }

    private void add(String str, Object obj) {
        if (str != null && !str.isEmpty() && obj != null) {
            this.devicesPairs.put(str, obj);
        }
    }

    public Map getMap() {
        return this.devicesPairs;
    }
}
