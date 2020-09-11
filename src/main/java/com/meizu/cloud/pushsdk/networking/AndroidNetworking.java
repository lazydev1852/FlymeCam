package com.meizu.cloud.pushsdk.networking;

import android.content.Context;
import com.meizu.cloud.pushsdk.networking.common.ANLog;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.common.ConnectionClassManager;
import com.meizu.cloud.pushsdk.networking.common.ConnectionQuality;
import com.meizu.cloud.pushsdk.networking.core.Core;
import com.meizu.cloud.pushsdk.networking.interfaces.ConnectionQualityChangeListener;
import com.meizu.cloud.pushsdk.networking.interfaces.Parser;
import com.meizu.cloud.pushsdk.networking.internal.ANImageLoader;
import com.meizu.cloud.pushsdk.networking.internal.ANRequestQueue;
import com.meizu.cloud.pushsdk.networking.internal.InternalNetworking;

public class AndroidNetworking {
    public static void setParserFactory(Parser.Factory factory) {
    }

    private AndroidNetworking() {
    }

    public static void initialize(Context context) {
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    public static void setConnectionQualityChangeListener(ConnectionQualityChangeListener connectionQualityChangeListener) {
        ConnectionClassManager.getInstance().setListener(connectionQualityChangeListener);
    }

    public static void removeConnectionQualityChangeListener() {
        ConnectionClassManager.getInstance().removeListener();
    }

    public static ANRequest.GetRequestBuilder get(String str) {
        return new ANRequest.GetRequestBuilder(str);
    }

    public static ANRequest.HeadRequestBuilder head(String str) {
        return new ANRequest.HeadRequestBuilder(str);
    }

    public static ANRequest.PostRequestBuilder post(String str) {
        return new ANRequest.PostRequestBuilder(str);
    }

    public static ANRequest.PutRequestBuilder put(String str) {
        return new ANRequest.PutRequestBuilder(str);
    }

    public static ANRequest.DeleteRequestBuilder delete(String str) {
        return new ANRequest.DeleteRequestBuilder(str);
    }

    public static ANRequest.PatchRequestBuilder patch(String str) {
        return new ANRequest.PatchRequestBuilder(str);
    }

    public static ANRequest.DownloadBuilder download(String str, String str2, String str3) {
        return new ANRequest.DownloadBuilder(str, str2, str3);
    }

    public static ANRequest.MultiPartBuilder upload(String str) {
        return new ANRequest.MultiPartBuilder(str);
    }

    public static void cancel(Object obj) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(obj, false);
    }

    public static void forceCancel(Object obj) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(obj, true);
    }

    public static void cancelAll() {
        ANRequestQueue.getInstance().cancelAll(false);
    }

    public static void forceCancelAll() {
        ANRequestQueue.getInstance().cancelAll(true);
    }

    public static void enableLogging() {
        ANLog.enableLogging();
    }

    public static void enableLogging(String str) {
        ANLog.enableLogging();
        ANLog.setTag(str);
    }

    public static void disableLogging() {
        ANLog.disableLogging();
    }

    public static void evictBitmap(String str) {
        ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null && str != null) {
            imageCache.evictBitmap(str);
        }
    }

    public static void evictAllBitmap() {
        ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null) {
            imageCache.evictAllBitmap();
        }
    }

    public static void setUserAgent(String str) {
        InternalNetworking.setUserAgent(str);
    }

    public static int getCurrentBandwidth() {
        return ConnectionClassManager.getInstance().getCurrentBandwidth();
    }

    public static ConnectionQuality getCurrentConnectionQuality() {
        return ConnectionClassManager.getInstance().getCurrentConnectionQuality();
    }

    public static void shutDown() {
        Core.shutDown();
        evictAllBitmap();
        ConnectionClassManager.getInstance().removeListener();
        ConnectionClassManager.shutDown();
    }
}
