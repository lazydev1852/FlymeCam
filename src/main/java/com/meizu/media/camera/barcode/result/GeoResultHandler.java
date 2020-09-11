package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.zxing.client.result.GeoParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.d */
public final class GeoResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8083a;

    public GeoResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_geo_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8083a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2594, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            switch (i) {
                case 8:
                    mo19237f(m8588k());
                    return;
                case 9:
                    mo19239g(m8588k());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: k */
    private String m8588k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8083a, false, 2595, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        GeoParsedResult geoParsedResult = (GeoParsedResult) mo19232d();
        double altitude = geoParsedResult.getAltitude();
        double latitude = geoParsedResult.getLatitude();
        double longitude = geoParsedResult.getLongitude();
        return mo19236f().getString(R.string.mz_geo_longitude) + longitude + "\n" + mo19236f().getString(R.string.mz_geo_latitude) + latitude + "\n" + mo19236f().getString(R.string.mz_geo_altitude) + altitude;
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8083a, false, 2596, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        ResultInfoItem mVar = new ResultInfoItem();
        mVar.mo19277b(m8588k());
        RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_single_item_margin_top, 0, (int) R.dimen.mz_barcode_list_single_item_margin_bottom);
        a.addRule(3, R.id.title);
        mVar.mo19276b(a);
        arrayList.add(mVar);
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8083a, false, 2597, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank));
        lVar.mo19257a(mo19236f().getString(R.string.mz_geo));
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8083a, false, 2598, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(17039361));
        Typeface create = Typeface.create("sans-serif-medium", 0);
        kVar.mo23384a(create);
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 9, (String) null));
        arrayList.add(gVar);
        if (!((CameraActivity) mo19236f()).mo17636c()) {
            ResultActionBarItem gVar2 = new ResultActionBarItem();
            MzTextDrawable kVar2 = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.share));
            kVar2.mo23384a(create);
            kVar2.mo23383a(color);
            gVar2.mo19212a((Drawable) kVar2);
            gVar2.mo19213a((View.OnClickListener) new ResultButtonListener(this, 8, (String) null));
            arrayList.add(gVar2);
        }
        return arrayList;
    }
}
