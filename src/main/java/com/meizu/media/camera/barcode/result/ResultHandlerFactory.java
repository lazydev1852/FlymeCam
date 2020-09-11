package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.barcode.result.j */
public final class ResultHandlerFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f8123a;

    /* renamed from: a */
    public static ResultHandler m8672a(Activity activity, Result result) {
        ChangeQuickRedirect changeQuickRedirect = f8123a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity, result}, (Object) null, changeQuickRedirect, true, 2664, new Class[]{Activity.class, Result.class}, ResultHandler.class);
        if (proxy.isSupported) {
            return (ResultHandler) proxy.result;
        }
        ParsedResult a = m8671a(result);
        switch (a.getType()) {
            case ADDRESSBOOK:
                return new AddressBookResultHandler(activity, a);
            case EMAIL_ADDRESS:
                return new EmailAddressResultHandler(activity, a);
            case PRODUCT:
                return new ProductResultHandler(activity, a);
            case URI:
                return new URIResultHandler(activity, a);
            case WIFI:
                return new WifiResultHandler(activity, a);
            case GEO:
                return new GeoResultHandler(activity, a);
            case TEL:
                return new TelResultHandler(activity, a);
            case SMS:
                return new SMSResultHandler(activity, a);
            case CALENDAR:
                return new CalendarResultHandler(activity, a);
            case ISBN:
                return new ISBNResultHandler(activity, a);
            default:
                return new TextResultHandler(activity, a);
        }
    }

    /* renamed from: a */
    private static ParsedResult m8671a(Result result) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{result}, (Object) null, f8123a, true, 2665, new Class[]{Result.class}, ParsedResult.class);
        return proxy.isSupported ? (ParsedResult) proxy.result : ResultParser.parseResult(result);
    }
}
