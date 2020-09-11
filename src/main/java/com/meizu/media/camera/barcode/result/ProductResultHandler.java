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
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.entity.BarcodeRequest;
import com.meizu.media.camera.barcode.entity.ProductEntity;
import com.meizu.media.camera.barcode.entity.ProductStoresEntity;
import com.meizu.media.camera.util.HttpUtils;
import com.meizu.media.camera.util.JSONUtils;
import com.meizu.media.camera.util.PostParameter;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.barcode.result.f */
public final class ProductResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8091a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ProductEntity f8092f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f8093g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f8094h;

    public ProductResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_product_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8091a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2610, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 8) {
            mo19237f(m8609k());
        }
    }

    /* renamed from: k */
    private String m8609k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8091a, false, 2611, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8092f.getName());
        sb.append("\n");
        sb.append(mo19218a((int) R.string.mz_product_specification));
        sb.append(this.f8092f.getSpecifications());
        sb.append("\n");
        sb.append(mo19218a((int) R.string.mz_product_info_title));
        sb.append("\n");
        sb.append(mo19218a((int) R.string.mz_product_info_price));
        sb.append(this.f8092f.getPrice());
        sb.append("\n");
        sb.append(mo19218a((int) R.string.mz_product_info_factory));
        sb.append(this.f8092f.getFactory());
        sb.append("\n");
        sb.append(mo19218a((int) R.string.mz_product_info_origin));
        sb.append(this.f8092f.getOrigin());
        ArrayList<ProductStoresEntity> stores = this.f8092f.getStores();
        if (stores.size() > 0) {
            sb.append(mo19218a((int) R.string.mz_product_stores_title));
            sb.append("\n");
        }
        for (int i = 0; i < stores.size(); i++) {
            sb.append(stores.get(i).getSeller());
            sb.append(" ");
            sb.append(stores.get(i).getPrice());
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8091a, false, 2612, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, 8);
        if (this.f8092f == null) {
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
        mVar2.mo19272a(mo19218a((int) R.string.mz_product_info_title));
        mVar2.mo19268a((int) R.style.MzBarcodeMediumWhite);
        RelativeLayout.LayoutParams a2 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_top, 0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_bottom);
        a2.addRule(15, -1);
        mVar2.mo19271a(a2);
        arrayList.add(mVar2);
        ResultInfoItem mVar3 = new ResultInfoItem();
        String a3 = mo19218a((int) R.string.mz_bar_code_renminbi);
        String factory = this.f8092f.getFactory();
        String origin = this.f8092f.getOrigin();
        StringBuilder sb = new StringBuilder();
        if (m8630l(factory)) {
            sb.append(mo19218a((int) R.string.mz_product_info_factory));
            sb.append(factory);
            if (m8630l(origin)) {
                sb.append("\n");
            }
        }
        if (m8630l(origin)) {
            sb.append(mo19218a((int) R.string.mz_product_info_origin));
            sb.append(this.f8092f.getOrigin());
        }
        if (m8630l(sb.toString())) {
            mVar3.mo19277b(sb.toString());
            mVar3.mo19274b((int) R.style.MzBarcodeSmallGray);
            RelativeLayout.LayoutParams a4 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_info_title_margin_top, 0, (int) R.dimen.mz_barcode_list_product_detail_info_content_margin_bottom);
            a4.addRule(3, R.id.title);
            mVar3.mo19276b(a4);
            mVar3.mo19283d(layoutParams);
        }
        if (m8630l(sb.toString())) {
            arrayList.add(mVar3);
        }
        if (arrayList.size() <= 1) {
            arrayList.remove(mVar2);
        }
        ArrayList<ProductStoresEntity> stores = this.f8092f.getStores();
        if (stores == null || stores.size() < 1) {
            if (arrayList.size() < 1) {
                ResultInfoItem mVar4 = new ResultInfoItem();
                mVar4.mo19277b(mo19236f().getString(R.string.mz_barcode_no_response));
                RelativeLayout.LayoutParams a5 = mo19217a(0, (int) R.dimen.mz_barcode_list_item_margin_top, 0, (int) R.dimen.mz_barcode_list_item_margin_bottom);
                a5.addRule(3, R.id.title);
                mVar4.mo19276b(a5);
                arrayList.add(mVar4);
            } else {
                arrayList.add(m8610l());
            }
            return arrayList;
        }
        ResultInfoItem mVar5 = new ResultInfoItem();
        mVar5.mo19272a(mo19218a((int) R.string.mz_product_stores_title));
        mVar5.mo19268a((int) R.style.MzBarcodeMediumWhite);
        RelativeLayout.LayoutParams a6 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_store_title_margin_top, 0, (int) R.dimen.mz_barcode_list_product_store_title_margin_bottom);
        mVar5.mo19271a(a6);
        arrayList.add(mVar5);
        RelativeLayout.LayoutParams a7 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_store_info_margin_top, 0, (int) R.dimen.mz_barcode_list_product_store_info_margin_top);
        a6.addRule(15, -1);
        RelativeLayout.LayoutParams a8 = mo19217a(0, (int) R.dimen.mz_barcode_list_product_store_info_price_margin_top, 0, (int) R.dimen.mz_barcode_list_product_store_info_price_margin_bottom);
        a8.addRule(21, -1);
        for (int i = 0; i < stores.size(); i++) {
            ResultInfoItem mVar6 = new ResultInfoItem();
            mVar6.mo19277b(stores.get(i).getSeller());
            mVar6.mo19274b((int) R.style.MzBarcodeMediumWhite);
            mVar6.mo19276b(a7);
            mVar6.mo19286e(a3 + stores.get(i).getPrice());
            mVar6.mo19279c((int) R.style.MzBarcodeMediumBig);
            mVar6.mo19280c(a8);
            mVar6.mo19283d(layoutParams);
            arrayList.add(mVar6);
        }
        arrayList.add(m8610l());
        return arrayList;
    }

    /* renamed from: l */
    private ResultInfoItem m8610l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8091a, false, 2613, new Class[0], ResultInfoItem.class);
        if (proxy.isSupported) {
            return (ResultInfoItem) proxy.result;
        }
        RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_summary_margin_top, 0, (int) R.dimen.mz_barcode_list_isbn_detail_info_content_margin_bottom);
        a.addRule(14, -1);
        ResultInfoItem mVar = new ResultInfoItem();
        mVar.mo19277b(mo19218a((int) R.string.mz_barcode_lingdong));
        mVar.mo19274b((int) R.style.MzBarcodeSmallGray);
        mVar.mo19276b(a);
        return mVar;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8091a, false, 2614, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        if (this.f8092f == null) {
            lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank));
            lVar.mo19257a(m8607a(mo19232d()));
            return lVar;
        }
        Drawable o = mo19248o(this.f8092f.getLogo());
        if (o == null) {
            o = mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank);
        }
        lVar.mo19256a(o);
        String name = this.f8092f.getName();
        if (m8630l(name)) {
            lVar.mo19257a(name);
        } else {
            lVar.mo19257a(m8607a(mo19232d()));
        }
        String specifications = this.f8092f.getSpecifications();
        if (m8630l(specifications)) {
            lVar.mo19260b(mo19218a((int) R.string.mz_product_specification) + specifications);
        }
        String price = this.f8092f.getPrice();
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
    public void mo19202a(Handler handler, int i) {
        if (!PatchProxy.proxy(new Object[]{handler, new Integer(i)}, this, f8091a, false, 2615, new Class[]{Handler.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f8093g = handler;
            this.f8094h = i;
            new C1857a().execute(new String[]{m8607a(mo19232d())});
        }
    }

    /* renamed from: a */
    private static String m8607a(ParsedResult parsedResult) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parsedResult}, (Object) null, f8091a, true, 2616, new Class[]{ParsedResult.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (parsedResult instanceof ProductParsedResult) {
            return ((ProductParsedResult) parsedResult).getNormalizedProductID();
        }
        if (parsedResult instanceof ExpandedProductParsedResult) {
            return ((ExpandedProductParsedResult) parsedResult).getRawText();
        }
        throw new IllegalArgumentException(parsedResult.getClass().toString());
    }

    /* renamed from: com.meizu.media.camera.barcode.result.f$a */
    /* compiled from: ProductResultHandler */
    private class C1857a extends AsyncTask<String, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f8095a;

        private C1857a() {
        }

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            String a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f8095a, false, 2618, new Class[]{String[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            if (ProductResultHandler.this.mo19241h() && (a = HttpUtils.m16279a("GET", BarcodeRequest.m8524a(strArr[0]), (List<PostParameter>) null, (HttpUtils.C2663c) null)) != null && !a.equals("")) {
                ProductEntity unused = ProductResultHandler.this.f8092f = (ProductEntity) JSONUtils.m15932a(a, new TypeReference<ProductEntity>() {
                });
            }
            return null;
        }

        public void onPreExecute() {
            if (!PatchProxy.proxy(new Object[0], this, f8095a, false, 2619, new Class[0], Void.TYPE).isSupported) {
                ProductEntity unused = ProductResultHandler.this.f8092f = null;
            }
        }

        public void onCancelled() {
            if (!PatchProxy.proxy(new Object[0], this, f8095a, false, 2620, new Class[0], Void.TYPE).isSupported) {
                super.onCancelled();
            }
        }

        /* renamed from: a */
        public void onCancelled(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8095a, false, 2621, new Class[]{Void.class}, Void.TYPE).isSupported) {
                super.onCancelled(voidR);
            }
        }

        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8095a, false, 2622, new Class[]{Void.class}, Void.TYPE).isSupported) {
                Message obtainMessage = ProductResultHandler.this.f8093g.obtainMessage();
                obtainMessage.obj = ProductResultHandler.this;
                obtainMessage.what = ProductResultHandler.this.f8094h;
                ProductResultHandler.this.f8093g.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8091a, false, 2617, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (this.f8092f == null || ((CameraActivity) mo19236f()).mo17636c()) {
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
