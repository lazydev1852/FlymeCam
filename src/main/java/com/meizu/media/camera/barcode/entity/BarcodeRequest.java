package com.meizu.media.camera.barcode.entity;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import org.apaches.commons.codec.digest.DigestUtils;

/* renamed from: com.meizu.media.camera.barcode.entity.a */
public class BarcodeRequest {

    /* renamed from: a */
    public static ChangeQuickRedirect f8046a;

    /* renamed from: e */
    private static String m8528e(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8046a, true, 2570, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return DigestUtils.sha1Hex(str + "3C2FE4D14F1AB4B289AC448146F417C9" + "084C30501BC10224061C88EE5E3A0233");
    }

    /* renamed from: a */
    public static String m8524a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8046a, true, 2571, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "http://barcode-api.kuaipai.cn/api/json/" + str + ".do?signature=" + m8528e(str) + "&channel=meizu&_fileds=sellers";
    }

    /* renamed from: b */
    public static String m8525b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8046a, true, 2572, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "http://api.photos.meizu.com/open/api/qrcode/appwhitelist.do?url=" + str;
    }

    /* renamed from: c */
    public static String m8526c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8046a, true, 2573, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "http://api.kuaidi100.com/apisearch.do?id=e170124d19ab94cd&nu=" + str;
    }

    /* renamed from: d */
    public static String m8527d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8046a, true, 2574, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "https://m.kuaidi100.com/app/query/?coname=meizucamera&hdisplay=web&nu=" + str;
    }
}
