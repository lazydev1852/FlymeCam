package com.meizu.media.camera.barcode.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.k */
public class ResultInfoAdapter extends BaseAdapter {

    /* renamed from: a */
    public static ChangeQuickRedirect f8125a;

    /* renamed from: b */
    private Context f8126b;

    /* renamed from: c */
    private LayoutInflater f8127c;

    /* renamed from: d */
    private ArrayList<ResultInfoItem> f8128d;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    /* renamed from: com.meizu.media.camera.barcode.result.k$a */
    /* compiled from: ResultInfoAdapter */
    private class C1862a {

        /* renamed from: a */
        TextView f8129a;

        /* renamed from: b */
        TextView f8130b;

        /* renamed from: c */
        TextView f8131c;

        /* renamed from: d */
        ImageView f8132d;

        private C1862a() {
        }
    }

    public ResultInfoAdapter(Context context) {
        this.f8126b = context;
        this.f8127c = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void mo19250a(ArrayList<ResultInfoItem> arrayList) {
        this.f8128d = arrayList;
    }

    public int getCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8125a, false, 2666, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f8128d.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int i2 = i;
        Object[] objArr = {new Integer(i2), view, viewGroup};
        ChangeQuickRedirect changeQuickRedirect = f8125a;
        Object[] objArr2 = objArr;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, this, changeQuickRedirect2, false, 2667, new Class[]{Integer.TYPE, View.class, ViewGroup.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        try {
            ResultInfoItem mVar = this.f8128d.get(i2);
            if (mVar.mo19289h() != null) {
                view2 = this.f8127c.inflate(R.layout.mz_barcode_express_list_item, (ViewGroup) null);
                view2.findViewById(R.id.icon).setBackground(mVar.mo19289h());
            } else if (mVar.mo19287f() != null) {
                view2 = this.f8127c.inflate(R.layout.mz_barcode_uri_chk_result_list_item, (ViewGroup) null);
                TextView textView = (TextView) view2.findViewById(R.id.url_chk_tv_insist_access);
                textView.setText(mVar.mo19287f());
                textView.setOnClickListener(mVar.mo19291j());
                TextView textView2 = (TextView) view2.findViewById(R.id.url_chk_tv_supporter);
                textView2.setText(mVar.mo19288g());
                textView2.setClickable(false);
            } else {
                view2 = this.f8127c.inflate(R.layout.mz_barcode_list_item, (ViewGroup) null);
            }
            C1862a aVar = new C1862a();
            aVar.f8129a = (TextView) view2.findViewById(R.id.title);
            aVar.f8130b = (TextView) view2.findViewById(R.id.content);
            aVar.f8131c = (TextView) view2.findViewById(R.id.extra_content);
            aVar.f8132d = (ImageView) view2.findViewById(R.id.list_item_divider);
            view2.setTag(aVar);
            String d = mVar.mo19282d();
            String e = mVar.mo19285e();
            String k = mVar.mo19292k();
            int a = mVar.mo19267a();
            int b = mVar.mo19273b();
            int c = mVar.mo19278c();
            RelativeLayout.LayoutParams o = mVar.mo19296o();
            RelativeLayout.LayoutParams l = mVar.mo19293l();
            RelativeLayout.LayoutParams m = mVar.mo19294m();
            RelativeLayout.LayoutParams n = mVar.mo19295n();
            View.OnClickListener i3 = mVar.mo19290i();
            if (o != null) {
                aVar.f8132d.setLayoutParams(o);
            }
            if (i2 == getCount() - 1) {
                aVar.f8132d.setVisibility(8);
            }
            if (d != null) {
                aVar.f8129a.setText(d);
                if (((float) a) != 0.0f) {
                    aVar.f8129a.setTextAppearance(this.f8126b, a);
                }
                if (l != null) {
                    aVar.f8129a.setLayoutParams(l);
                }
            } else {
                aVar.f8129a.setVisibility(8);
            }
            if (e != null) {
                aVar.f8130b.setText(e);
                if (((float) b) != 0.0f) {
                    aVar.f8130b.setTextAppearance(this.f8126b, b);
                }
                if (m != null) {
                    aVar.f8130b.setLayoutParams(m);
                }
                if (i3 != null) {
                    aVar.f8130b.setOnClickListener(i3);
                }
            } else {
                aVar.f8130b.setVisibility(8);
            }
            if (k != null) {
                aVar.f8131c.setText(k);
                if (((float) c) != 0.0f) {
                    aVar.f8131c.setTextAppearance(this.f8126b, c);
                }
                if (n != null) {
                    aVar.f8131c.setLayoutParams(n);
                }
            } else {
                aVar.f8131c.setVisibility(8);
            }
            return view2;
        } catch (Exception unused) {
            return new View(this.f8126b);
        }
    }
}
