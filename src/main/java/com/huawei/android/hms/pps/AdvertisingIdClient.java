package com.huawei.android.hms.pps;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class AdvertisingIdClient {

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final native String getId();

        @Keep
        public final native boolean isLimitAdTrackingEnabled();
    }

    @Keep
    public static native Info getAdvertisingIdInfo(Context context);

    private static native String getTag();
}
