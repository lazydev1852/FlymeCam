package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.TypeReference;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.TextParsedResult;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.entity.BarcodeRequest;
import com.meizu.media.camera.barcode.entity.ExpressEntity;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.HttpUtils;
import com.meizu.media.camera.util.JSONUtils;
import com.meizu.media.camera.util.PostParameter;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.meizu.media.camera.barcode.result.p */
public final class TextResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8157a;

    /* renamed from: f */
    boolean f8158f = false;

    /* renamed from: g */
    boolean f8159g = false;

    /* renamed from: h */
    private Handler f8160h;

    /* renamed from: i */
    private int f8161i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ExpressEntity f8162j;

    /* renamed from: k */
    private Pattern f8163k = Pattern.compile("^[0-9a-zA-Z\\\\-\\\\_]{5,40}$");

    public TextResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8157a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2677, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            String displayResult = mo19232d().getDisplayResult();
            String m = mo19246m(displayResult);
            if (m != null) {
                displayResult = m;
            }
            switch (i) {
                case 8:
                    mo19237f(displayResult);
                    return;
                case 9:
                    mo19239g(displayResult);
                    return;
                case 11:
                    mo19240h(str);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8157a, false, 2678, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        if (this.f8158f) {
            ResultInfoItem mVar = new ResultInfoItem();
            mVar.mo19272a(this.f8162j.getName() + " " + this.f8162j.getNu());
            mVar.mo19277b(this.f8162j.getContext());
            mVar.mo19286e(this.f8162j.getTime());
            Drawable o = mo19248o(this.f8162j.getIcon());
            if (o == null) {
                o = mo19236f().getResources().getDrawable(R.drawable.mz_barcode_blank);
            }
            mVar.mo19269a(o);
            arrayList.add(mVar);
        } else {
            ResultInfoItem mVar2 = new ResultInfoItem();
            String text = ((TextParsedResult) mo19232d()).getText();
            String m = mo19246m(text);
            if (m != null) {
                text = m;
            }
            mVar2.mo19277b(text);
            RelativeLayout.LayoutParams a = mo19217a(0, (int) R.dimen.mz_barcode_list_product_detail_title_margin_top, 0, (int) R.dimen.mz_barcode_list_item_margin_bottom);
            a.addRule(3, R.id.title);
            mVar2.mo19276b(a);
            mVar2.mo19274b((int) R.style.MzBarcodeSmallGray);
            arrayList.add(mVar2);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        Drawable drawable;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8157a, false, 2679, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        if (this.f8158f) {
            drawable = mo19236f().getResources().getDrawable(R.drawable.mz_barcode_express);
            lVar.mo19257a(mo19236f().getString(R.string.mz_express));
        } else {
            drawable = mo19236f().getResources().getDrawable(R.drawable.mz_barcode_text);
            lVar.mo19257a(mo19236f().getString(R.string.mz_text));
        }
        lVar.mo19256a(drawable);
        lVar.mo19258a(true);
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8157a, false, 2680, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        if (this.f8158f) {
            ResultActionBarItem gVar = new ResultActionBarItem();
            int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
            MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.mz_barcode_detail));
            kVar.mo23384a(Typeface.create("sans-serif-medium", 0));
            kVar.mo23383a(color);
            gVar.mo19212a((Drawable) kVar);
            gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 11, this.f8162j.getNu()));
            arrayList.add(gVar);
        } else {
            ResultActionBarItem gVar2 = new ResultActionBarItem();
            int color2 = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
            MzTextDrawable kVar2 = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(17039361));
            Typeface create = Typeface.create("sans-serif-medium", 0);
            kVar2.mo23384a(create);
            kVar2.mo23383a(color2);
            gVar2.mo19212a((Drawable) kVar2);
            gVar2.mo19213a((View.OnClickListener) new ResultButtonListener(this, 9, (String) null));
            arrayList.add(gVar2);
            if (!((CameraActivity) mo19236f()).mo17636c()) {
                ResultActionBarItem gVar3 = new ResultActionBarItem();
                MzTextDrawable kVar3 = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.share));
                kVar3.mo23384a(create);
                kVar3.mo23383a(color2);
                gVar3.mo19212a((Drawable) kVar3);
                gVar3.mo19213a((View.OnClickListener) new ResultButtonListener(this, 8, (String) null));
                arrayList.add(gVar3);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo19298a(Handler handler, int i, boolean z) {
        Object[] objArr = {handler, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f8157a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2681, new Class[]{Handler.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f8160h = handler;
            this.f8161i = i;
            String displayResult = mo19232d().getDisplayResult();
            if (displayResult.contains("camera/filter") && EffectRenderFactory.m4739a().mo14338j()) {
                this.f8159g = true;
                if (!z) {
                    mo19300l();
                    return;
                }
                m8728m();
                mo19242i();
            } else if (!this.f8163k.matcher(displayResult).matches() || DeviceUtil.m16196a()) {
                m8728m();
                mo19242i();
            } else {
                new C1864a().mo22614c((Params[]) new String[]{displayResult});
            }
        }
    }

    /* renamed from: k */
    public boolean mo19299k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8157a, false, 2682, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo19232d().getDisplayResult().contains("camera/filter") && EffectRenderFactory.m4739a().mo14338j();
    }

    /* renamed from: l */
    public void mo19300l() {
        if (!PatchProxy.proxy(new Object[0], this, f8157a, false, 2683, new Class[0], Void.TYPE).isSupported) {
            Intent intent = new Intent("com.android.gallery.action.FILTER_MANAGER");
            intent.setPackage("com.meizu.media.gallery");
            intent.putExtra("DlUrl", mo19232d().getDisplayResult());
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            mo19228b(intent);
        }
    }

    /* renamed from: com.meizu.media.camera.barcode.result.p$a */
    /* compiled from: TextResultHandler */
    private class C1864a extends AsyncTaskEx<String, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f8164a;

        /* renamed from: a */
        public void mo19181a() {
        }

        /* renamed from: b */
        public void mo17660a(Void voidR) {
        }

        private C1864a() {
        }

        /* renamed from: a */
        public Void mo17658a(String... strArr) {
            String a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f8164a, false, 2685, new Class[]{String[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            if (TextResultHandler.this.mo19241h() && (a = HttpUtils.m16279a("GET", BarcodeRequest.m8526c(strArr[0]), (List<PostParameter>) null, (HttpUtils.C2663c) null)) != null && !a.equals("")) {
                ExpressEntity unused = TextResultHandler.this.f8162j = (ExpressEntity) JSONUtils.m15932a(a, new TypeReference<ExpressEntity>() {
                });
                if (TextResultHandler.this.f8162j != null && "1".equals(TextResultHandler.this.f8162j.getStatus())) {
                    TextResultHandler.this.f8158f = true;
                    TextResultHandler.this.f8115e = "EXPRESS";
                }
            }
            TextResultHandler.this.m8728m();
            TextResultHandler.this.mo19242i();
            return null;
        }

        /* renamed from: b */
        public void mo19184b() {
            if (!PatchProxy.proxy(new Object[0], this, f8164a, false, 2686, new Class[0], Void.TYPE).isSupported) {
                super.mo19184b();
            }
        }

        /* renamed from: a */
        public void mo19185b(Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8164a, false, 2687, new Class[]{Void.class}, Void.TYPE).isSupported) {
                super.mo19185b(voidR);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m8728m() {
        if (!PatchProxy.proxy(new Object[0], this, f8157a, false, 2684, new Class[0], Void.TYPE).isSupported) {
            if (this.f8158f) {
                this.f8114d = this.f8113c.getResources().getString(R.string.mz_barcode_auto_express_result_hint);
            } else if (this.f8159g) {
                this.f8114d = this.f8113c.getResources().getString(R.string.mz_barcode_auto_filter_result_hint);
            } else {
                this.f8114d = this.f8113c.getResources().getString(R.string.mz_barcode_auto_text_result_hint);
            }
            Message obtainMessage = this.f8160h.obtainMessage();
            obtainMessage.obj = this;
            obtainMessage.what = this.f8161i;
            this.f8160h.sendMessage(obtainMessage);
        }
    }
}
