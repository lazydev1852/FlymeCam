package com.meizu.cloud.pushsdk.analytics;

import android.content.Context;
import com.meizu.cloud.pushsdk.analytics.PayloadSub;
import com.meizu.cloud.pushsdk.analytics.secure.HttpSecureRequester;
import com.meizu.cloud.pushsdk.base.ExecutorProxy;
import com.meizu.cloud.pushsdk.pushtracer.dataload.TrackerDataload;
import java.util.Map;

public class FastTracker {
    private static final String TAG = "FastTracker";

    public static TrackerDataload buildDataLoad(Context context) {
        TrackerDataload trackerDataload = new TrackerDataload();
        PayloadSub payloadSubject = getPayloadSubject(context);
        Map<String, String> userInfoSubject = payloadSubject.getUserInfoSubject();
        Map<String, String> deviceInfoSubject = payloadSubject.getDeviceInfoSubject();
        Map<String, Object> appInfoSubject = payloadSubject.getAppInfoSubject();
        Map<String, Object> locationInfoSubject = payloadSubject.getLocationInfoSubject();
        if (userInfoSubject.size() > 0) {
            trackerDataload.add(Params.USER_INFO, (Object) userInfoSubject);
        }
        if (deviceInfoSubject.size() > 0) {
            trackerDataload.add(Params.DEVICE_INFO, (Object) deviceInfoSubject);
        }
        if (appInfoSubject.size() > 0) {
            trackerDataload.add(Params.APP_INFO, (Object) appInfoSubject);
        }
        if (locationInfoSubject.size() > 0) {
            trackerDataload.add(Params.LOCATION_INFO, (Object) locationInfoSubject);
        }
        return trackerDataload;
    }

    public static void uploadData(final Context context) {
        ExecutorProxy.get().execute(new Runnable() {
            public void run() {
                HttpSecureRequester.getInstance(context).stringPartRequest("POST", (Map<String, String>) null, FastTracker.buildDataLoad(context).toString());
            }
        });
    }

    private static PayloadSub getPayloadSubject(Context context) {
        return new PayloadSub.PayloadSubBuilder().context(context).build();
    }
}
