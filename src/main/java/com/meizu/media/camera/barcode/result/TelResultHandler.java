package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.TelParsedResult;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.o */
public final class TelResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8156a;

    public TelResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_tel_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f8156a, false, 2672, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            TelParsedResult telParsedResult = (TelParsedResult) mo19232d();
            if (i == 1) {
                mo19229b(telParsedResult.getTelURI());
            } else if (i == 3) {
                mo19226a(new String[]{telParsedResult.getNumber()}, (String[]) null);
            } else if (i == 8) {
                mo19237f(mo19297k());
            }
        }
    }

    /* renamed from: k */
    public String mo19297k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8156a, false, 2673, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return PhoneNumberUtils.formatNumber(mo19232d().getDisplayResult().replace("\r", ""));
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8156a, false, 2674, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        String number = ((TelParsedResult) mo19232d()).getNumber();
        if (m8630l(number)) {
            ResultInfoItem mVar = new ResultInfoItem();
            mVar.mo19277b(number);
            RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_single_item_margin_top, 0, (int) R.dimen.mz_barcode_list_single_item_margin_bottom);
            a.addRule(3, R.id.title);
            mVar.mo19276b(a);
            mVar.mo19270a((View.OnClickListener) new ResultButtonListener(this, 1, (String) null));
            arrayList.add(mVar);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8156a, false, 2675, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_contact));
        lVar.mo19257a(mo19236f().getString(R.string.mz_tel));
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8156a, false, 2676, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.mz_barcode_save_contact));
        Typeface create = Typeface.create("sans-serif-medium", 0);
        kVar.mo23384a(create);
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 3, (String) null));
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
