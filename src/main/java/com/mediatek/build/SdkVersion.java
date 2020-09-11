package com.mediatek.build;

import android.os.SystemProperties;

public final class SdkVersion {
    private SdkVersion() {
    }

    public static int getPlatformVersion() {
        return Integer.valueOf(SystemProperties.get("ro.mediatek.version.sdk")).intValue();
    }
}
