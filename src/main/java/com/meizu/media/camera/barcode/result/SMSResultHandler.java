package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.SMSParsedResult;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.n */
public final class SMSResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8155a;

    public SMSResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_sms_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f8155a, false, 2668, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 10) {
            SMSParsedResult sMSParsedResult = (SMSParsedResult) mo19232d();
            mo19223a(sMSParsedResult.getNumbers()[0], sMSParsedResult.getBody());
        }
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8155a, false, 2669, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        String body = ((SMSParsedResult) mo19232d()).getBody();
        if (m8630l(body)) {
            ResultInfoItem mVar = new ResultInfoItem();
            mVar.mo19277b(body);
            RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_top, 0, (int) R.dimen.mz_barcode_list_item_margin_bottom);
            a.addRule(3, R.id.title);
            mVar.mo19276b(a);
            mVar.mo19274b((int) R.style.MzBarcodeSmallGray);
            arrayList.add(mVar);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8155a, false, 2670, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_sms));
        lVar.mo19257a(mo19236f().getString(R.string.mz_sms));
        lVar.mo19260b(mo19236f().getString(R.string.mz_sms_sendto_pre) + ((SMSParsedResult) mo19232d()).getNumbers()[0]);
        lVar.mo19258a(false);
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8155a, false, 2671, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.mz_barcode_send));
        kVar.mo23384a(Typeface.create("sans-serif-medium", 0));
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 10, (String) null));
        arrayList.add(gVar);
        return arrayList;
    }
}
