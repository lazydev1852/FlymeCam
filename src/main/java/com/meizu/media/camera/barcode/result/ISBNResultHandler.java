package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.TypeReference;
import com.baidu.p020ar.base.MsgField;
import com.google.zxing.client.result.ISBNParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.entity.BarcodeRequest;
import com.meizu.media.camera.barcode.entity.BookEntity;
import com.meizu.media.camera.util.HttpUtils;
import com.meizu.media.camera.util.JSONUtils;
import com.meizu.media.camera.util.PostParameter;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.barcode.result.e */
public final class ISBNResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8084a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BookEntity f8085f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f8086g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f8087h;

    public ISBNResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_isbn_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8084a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2599, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 8) {
            mo19237f(m8596k());
        }
    }

    /* renamed from: k */
    private String m8596k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8084a, false, MsgField.MSG_ON_LOAD_BATCH_RETRY, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return this.f8085f.getName() + "\n" + mo19218a((int) R.string.mz_isbn_author) + this.f8085f.getAuthor() + "\n" + mo19218a((int) R.string.mz_isbn_info_title) + "\n" + mo19218a((int) R.string.mz_isbn_info_price) + this.f8085f.getPrice() + "\n" + mo19218a((int) R.string.mz_isbn_info_publish) + this.f8085f.getPublish() + "\n" + mo19218a((int) R.string.mz_isbn_info_summary) + this.f8085f.getSummary();
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8084a, false, 2601, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, 8);
        if (this.f8085f == null) {
            ResultInfoItem mVar = new ResultInfoItem();
            if (mo19241h()) {
                mVar.mo19277b(mo19236f().getString(R.string.mz_barcode_no_response));
            } else {
                mVar.mo19277b(mo19236f().getString(R.string.mz_barcode_no_network));
            }
            RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_item_margin_top, 0, (int) R.dimen.mz_barcode_list_item_margin_bottom);
            a.addRule(3, R.id.title);
            mVar.mo19276b(a);
            arrayList.add(mVar);
            return arrayList;
        }
        ResultInfoItem mVar2 = new ResultInfoItem();
        mVar2.mo19272a(mo19218a((int) R.string.mz_isbn_info_title));
        mVar2.mo19268a((int) R.style.MzBarcodeMediumWhite);
        RelativeLayout.LayoutParams a2 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_top, 0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_bottom);
        a2.addRule(15, -1);
        mVar2.mo19271a(a2);
        arrayList.add(mVar2);
        String a3 = mo19218a((int) R.string.mz_isbn_info_publish);
        ResultInfoItem mVar3 = new ResultInfoItem();
        mVar3.mo19283d(layoutParams);
        mVar3.mo19277b(a3 + this.f8085f.getPublish());
        mVar3.mo19274b((int) R.style.MzBarcodeSmallGray);
        RelativeLayout.LayoutParams a4 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_info_title_margin_top, 0, (int) R.dimen.mz_barcode_list_isbn_detail_info_content_margin_bottom);
        a4.addRule(3, R.id.title);
        mVar3.mo19276b(a4);
        arrayList.add(mVar3);
        String a5 = mo19218a((int) R.string.mz_isbn_info_summary);
        ResultInfoItem mVar4 = new ResultInfoItem();
        mVar4.mo19283d(layoutParams);
        mVar4.mo19277b(a5 + this.f8085f.getSummary());
        mVar4.mo19274b((int) R.style.MzBarcodeSmallGray);
        RelativeLayout.LayoutParams a6 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_summary_margin_top, 0, (int) R.dimen.mz_barcode_list_isbn_detail_info_content_margin_bottom);
        a6.addRule(3, R.id.title);
        mVar4.mo19276b(a6);
        arrayList.add(mVar4);
        RelativeLayout.LayoutParams a7 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_summary_margin_top, 0, (int) R.dimen.mz_barcode_list_isbn_detail_info_content_margin_bottom);
        a7.addRule(14, -1);
        ResultInfoItem mVar5 = new ResultInfoItem();
        mVar5.mo19277b(mo19218a((int) R.string.mz_barcode_lingdong));
        mVar5.mo19274b((int) R.style.MzBarcodeSmallGray);
        mVar5.mo19276b(a7);
        arrayList.add(mVar5);
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8084a, false, 2602, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        if (this.f8085f == null) {
            lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank));
            lVar.mo19257a(((ISBNParsedResult) mo19232d()).getISBN());
            return lVar;
        }
        Drawable o = mo19248o(this.f8085f.getLogo());
        if (o == null) {
            o = mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank);
        }
        lVar.mo19256a(o);
        lVar.mo19257a(this.f8085f.getName());
        lVar.mo19260b(mo19218a((int) R.string.mz_isbn_author) + this.f8085f.getAuthor());
        String price = this.f8085f.getPrice();
        String a = mo19218a((int) R.string.mz_bar_code_renminbi);
        if (m8630l(price)) {
            String a2 = mo19218a((int) R.string.mz_product_info_price_new);
            lVar.mo19262c(a + price);
            lVar.mo19264d(a2);
        }
        lVar.mo19258a(false);
        return lVar;
    }

    /* renamed from: a */
    public void mo19193a(Handler handler, int i) {
        if (!PatchProxy.proxy(new Object[]{handler, new Integer(i)}, this, f8084a, false, 2603, new Class[]{Handler.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f8086g = handler;
            this.f8087h = i;
            new C1854a().execute(new String[]{((ISBNParsedResult) mo19232d()).getISBN()});
        }
    }

    /* renamed from: com.meizu.media.camera.barcode.result.e$a */
    /* compiled from: ISBNResultHandler */
    private class C1854a extends AsyncTask<String, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f8088a;

        private C1854a() {
        }

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            String a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f8088a, false, 2605, new Class[]{String[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            if (ISBNResultHandler.this.mo19241h() && (a = HttpUtils.m16279a("GET", BarcodeRequest.m8524a(strArr[0]), (List<PostParameter>) null, (HttpUtils.C2663c) null)) != null && !a.equals("")) {
                BookEntity unused = ISBNResultHandler.this.f8085f = (BookEntity) JSONUtils.m15932a(a, new TypeReference<BookEntity>() {
                });
            }
            return null;
        }

        public void onPreExecute() {
            if (!PatchProxy.proxy(new Object[0], this, f8088a, false, 2606, new Class[0], Void.TYPE).isSupported) {
                super.onPreExecute();
            }
        }

        public void onCancelled() {
            if (!PatchProxy.proxy(new Object[0], this, f8088a, false, 2607, new Class[0], Void.TYPE).isSupported) {
                super.onCancelled();
            }
        }

        /* renamed from: a */
        public void onCancelled(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8088a, false, 2608, new Class[]{Void.class}, Void.TYPE).isSupported) {
                super.onCancelled(voidR);
            }
        }

        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8088a, false, 2609, new Class[]{Void.class}, Void.TYPE).isSupported) {
                Message obtainMessage = ISBNResultHandler.this.f8086g.obtainMessage();
                obtainMessage.obj = ISBNResultHandler.this;
                obtainMessage.what = ISBNResultHandler.this.f8087h;
                ISBNResultHandler.this.f8086g.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8084a, false, 2604, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (this.f8085f == null || ((CameraActivity) mo19236f()).mo17636c()) {
            return null;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.share));
        kVar.mo23384a(Typeface.create("sans-serif-medium", 0));
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 8, (String) null));
        arrayList.add(gVar);
        return arrayList;
    }
}
