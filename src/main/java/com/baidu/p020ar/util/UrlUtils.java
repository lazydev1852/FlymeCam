package com.baidu.p020ar.util;

/* renamed from: com.baidu.ar.util.UrlUtils */
public final class UrlUtils {
    public static String URL_AR_PREFIX = "https://dusee.baidu.com";

    public static String getAipAuthUrl() {
        return "https://aip.baidubce.com/rpc/2.0/brain/v1/ar/launchar";
    }

    public static String getCloudRecgUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/recognizeimgvis";
    }

    public static String getDeviceRecgUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/onlinefeature";
    }

    public static String getLogoUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/RecognizeLogoVis";
    }

    public static String getQueryResourceUrl() {
        return URL_AR_PREFIX + "/artrack-bos/queryarresource";
    }

    public static String getRecommendUrl() {
        return URL_AR_PREFIX + "/artrack-bos/queryarrecommend";
    }

    public static String getShareUrl() {
        return URL_AR_PREFIX + "/artrack-bos/share/shareupload";
    }

    public static String getStatisticUrl() {
        return URL_AR_PREFIX + "/artrack/count_ar";
    }

    public static String getStepLoadingBatchUrl() {
        return URL_AR_PREFIX + "/artrack-bos/content/zipquery";
    }

    public static void setDebugServer(String str) {
        URL_AR_PREFIX = str;
    }
}
