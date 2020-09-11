package com.meizu.statsapp.p081v3;

import android.webkit.JavascriptInterface;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.MzUsageStatsJavascriptInterface */
public class MzUsageStatsJavascriptInterface {
    private final String TAG = "MzUsageStatsJavascriptInterface";

    public static MzUsageStatsJavascriptInterface getInstance() {
        return new MzUsageStatsJavascriptInterface();
    }

    @JavascriptInterface
    public String getUMID() {
        Logger.m17378d("MzUsageStatsJavascriptInterface", "getUMID");
        return UsageStatsProxy3.getInstance().getUMID();
    }

    @JavascriptInterface
    public String getFlymeUid() {
        Logger.m17378d("MzUsageStatsJavascriptInterface", "getFlymeUid");
        return UsageStatsProxy3.getInstance().getFlymeUID();
    }
}
