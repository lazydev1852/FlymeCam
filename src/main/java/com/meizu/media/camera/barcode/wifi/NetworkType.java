package com.meizu.media.camera.barcode.wifi;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public enum NetworkType {
    WEP,
    WPA,
    NO_PASSWORD;
    
    public static ChangeQuickRedirect changeQuickRedirect;

    static NetworkType forIntentValue(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 2721, new Class[]{String.class}, NetworkType.class);
        if (proxy.isSupported) {
            return (NetworkType) proxy.result;
        }
        if (str == null) {
            return NO_PASSWORD;
        }
        if ("WPA".equals(str)) {
            return WPA;
        }
        if ("WEP".equals(str)) {
            return WEP;
        }
        if ("nopass".equals(str)) {
            return NO_PASSWORD;
        }
        throw new IllegalArgumentException(str);
    }
}
