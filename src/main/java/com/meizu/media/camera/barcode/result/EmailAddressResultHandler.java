package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.zxing.client.result.EmailAddressParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.c */
public final class EmailAddressResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8082a;

    public EmailAddressResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_email_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8082a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2590, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 6) {
            EmailAddressParsedResult emailAddressParsedResult = (EmailAddressParsedResult) mo19232d();
            mo19225a(emailAddressParsedResult.getMailtoURI(), emailAddressParsedResult.getEmailAddress(), emailAddressParsedResult.getSubject(), emailAddressParsedResult.getBody());
        }
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8082a, false, 2591, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        EmailAddressParsedResult emailAddressParsedResult = (EmailAddressParsedResult) mo19232d();
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        ResultInfoItem mVar = new ResultInfoItem();
        String subject = emailAddressParsedResult.getSubject();
        String body = emailAddressParsedResult.getBody();
        StringBuilder sb = new StringBuilder();
        if (subject != null) {
            sb.append(subject);
        }
        if (body != null) {
            sb.append("\n");
            sb.append(body);
        }
        sb.append("");
        if (sb.length() > 0) {
            mVar.mo19277b(sb.toString());
            arrayList.add(mVar);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8082a, false, 2592, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_email));
        lVar.mo19257a(mo19236f().getString(R.string.mz_email));
        lVar.mo19260b(mo19236f().getString(R.string.mz_email_sendto_pre) + ((EmailAddressParsedResult) mo19232d()).getEmailAddress());
        lVar.mo19258a(false);
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8082a, false, 2593, new Class[0], ArrayList.class);
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
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 6, (String) null));
        arrayList.add(gVar);
        return arrayList;
    }
}
