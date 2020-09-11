package com.meizu.media.camera.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.meizu.media.camera.R;
import com.meizu.media.camera.adapter.StickerAdapter;
import com.meizu.media.camera.bean.Sticker;
import com.meizu.media.camera.bean.StickerCategory;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class StickerPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    public static ChangeQuickRedirect f7543a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f7544b = new LogUtil.C2630a("StickerPgAdapter");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f7545c;

    /* renamed from: d */
    private List<RecyclerView> f7546d = new ArrayList();

    /* renamed from: e */
    private List<StickerCategory> f7547e = new ArrayList();

    /* renamed from: f */
    private ArrayList<StickerAdapter> f7548f;

    /* renamed from: g */
    private View.OnClickListener f7549g;

    /* renamed from: h */
    private StickerAdapter.C1792a f7550h;

    /* renamed from: i */
    private View f7551i;

    /* renamed from: j */
    private StickerCategory f7552j;

    /* renamed from: k */
    private int f7553k;

    /* renamed from: l */
    private View.OnClickListener f7554l = new View.OnClickListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7555a;

        public void onClick(View view) {
            if (!PatchProxy.proxy(new Object[]{view}, this, f7555a, false, 2275, new Class[]{View.class}, Void.TYPE).isSupported) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?id=%s", new Object[]{"com.lemon.faceu"})));
                intent.setFlags(268435456);
                intent.setPackage("com.meizu.mstore");
                intent.putExtra("source_apkname", "com.meizu.media.camera");
                UsageStatsHelper.m16042a(StickerPagerAdapter.this.f7545c).mo22695b("download_faceu");
                try {
                    StickerPagerAdapter.this.f7545c.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    LogUtil.m15949b(StickerPagerAdapter.f7544b, e.getMessage());
                }
            }
        }
    };

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public StickerPagerAdapter(Context context, ArrayList<StickerAdapter> arrayList, View.OnClickListener onClickListener, StickerAdapter.C1792a aVar) {
        this.f7545c = context;
        this.f7548f = arrayList;
        this.f7549g = onClickListener;
        this.f7550h = aVar;
        this.f7553k = this.f7545c.getResources().getDimensionPixelOffset(R.dimen.mz_funny_snap_icon_left_margin);
    }

    /* renamed from: a */
    public void mo18778a(List<StickerCategory> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f7543a, false, 2262, new Class[]{List.class}, Void.TYPE).isSupported) {
            this.f7547e.clear();
            this.f7547e.addAll(list);
            int count = getCount();
            LogUtil.C2630a aVar = f7544b;
            LogUtil.m15942a(aVar, "setCategories size:" + count);
            this.f7548f.clear();
            this.f7546d.clear();
            for (int i = 0; i < count; i++) {
                RecyclerView recyclerView = new RecyclerView(this.f7545c);
                recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f7545c);
                linearLayoutManager.setOrientation(0);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setClipChildren(true);
                recyclerView.setClipToPadding(false);
                recyclerView.setPadding(this.f7553k, 0, 0, 0);
                recyclerView.setAdapter(new StickerAdapter(this.f7545c, this.f7549g, this.f7550h));
                this.f7548f.add((StickerAdapter) recyclerView.getAdapter());
                this.f7546d.add(recyclerView);
                if ("faceu".equals(list.get(i).mo19364b().toLowerCase())) {
                    if (this.f7552j == null) {
                        m7989c();
                    }
                    if (!this.f7547e.contains(this.f7552j)) {
                        this.f7547e.add(this.f7552j);
                        m7990d();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public StickerCategory mo18776a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7543a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2263, new Class[]{Integer.TYPE}, StickerCategory.class);
        if (proxy.isSupported) {
            return (StickerCategory) proxy.result;
        }
        LogUtil.C2630a aVar = f7544b;
        LogUtil.m15942a(aVar, "getCategoryItem position:" + i + "   mCategories size:" + this.f7547e.size());
        LogUtil.C2630a aVar2 = f7544b;
        StringBuilder sb = new StringBuilder();
        sb.append("mCategories:");
        sb.append(this);
        LogUtil.m15942a(aVar2, sb.toString());
        return this.f7547e.get(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f7543a, false, 2264, new Class[]{ViewGroup.class, Integer.TYPE}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        LogUtil.C2630a aVar = f7544b;
        LogUtil.m15942a(aVar, "instantiateItem:" + i);
        if (i < this.f7546d.size()) {
            viewGroup.addView(this.f7546d.get(i));
            return this.f7546d.get(i);
        }
        viewGroup.addView(this.f7551i);
        return this.f7551i;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Object[] objArr = {viewGroup, new Integer(i), obj};
        ChangeQuickRedirect changeQuickRedirect = f7543a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2265, new Class[]{ViewGroup.class, Integer.TYPE, Object.class}, Void.TYPE).isSupported) {
            viewGroup.removeView((View) obj);
        }
    }

    public int getCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7543a, false, 2266, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f7547e == null) {
            return 0;
        }
        return this.f7547e.size();
    }

    /* renamed from: b */
    public String getPageTitle(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7543a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2267, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String country = this.f7545c.getResources().getConfiguration().locale.getCountry();
        LogUtil.C2630a aVar = f7544b;
        LogUtil.m15942a(aVar, "country:" + country);
        if (Locale.CHINA.getCountry().equals(country)) {
            if (this.f7547e == null) {
                return null;
            }
            return this.f7547e.get(i).mo19364b();
        } else if (Locale.TAIWAN.getCountry().equals(country) || "HK".equals(country)) {
            if (this.f7547e == null) {
                return null;
            }
            return this.f7547e.get(i).mo19366c();
        } else if (this.f7547e == null) {
            return null;
        } else {
            return this.f7547e.get(i).mo19368d();
        }
    }

    /* renamed from: a */
    public int mo18775a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7543a, false, 2268, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        LogUtil.C2630a aVar = f7544b;
        LogUtil.m15942a(aVar, "categoryId:" + str);
        for (StickerCategory next : this.f7547e) {
            LogUtil.C2630a aVar2 = f7544b;
            LogUtil.m15942a(aVar2, "for categoryId:" + String.valueOf(next.mo19360a()));
            if (str.equals(String.valueOf(next.mo19360a()))) {
                return this.f7547e.indexOf(next);
            }
        }
        return -1;
    }

    /* renamed from: b */
    public ArrayList<Sticker> mo18780b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7543a, false, 2269, new Class[]{String.class}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<Sticker> arrayList = new ArrayList<>();
        Iterator<StickerAdapter> it = this.f7548f.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().mo18769a(str));
        }
        return arrayList;
    }

    /* renamed from: c */
    public void mo18782c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7543a, false, 2270, new Class[]{String.class}, Void.TYPE).isSupported) {
            Iterator<StickerAdapter> it = this.f7548f.iterator();
            while (it.hasNext()) {
                it.next().mo18772b(str);
            }
        }
    }

    /* renamed from: c */
    public RecyclerView mo18781c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7543a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2271, new Class[]{Integer.TYPE}, RecyclerView.class);
        if (proxy.isSupported) {
            return (RecyclerView) proxy.result;
        }
        if (this.f7546d.size() > i) {
            return this.f7546d.get(i);
        }
        return null;
    }

    /* renamed from: d */
    public int mo18783d(int i) {
        String str;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7543a, false, 2272, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        LogUtil.C2630a aVar = f7544b;
        StringBuilder sb = new StringBuilder();
        sb.append("getCategoryId position:");
        sb.append(i);
        if (this.f7547e == null) {
            str = " mCategories == null";
        } else {
            str = " size: " + this.f7547e.size();
        }
        sb.append(str);
        LogUtil.m15942a(aVar, sb.toString());
        if (this.f7547e == null || this.f7547e.size() <= i) {
            return -1;
        }
        return this.f7547e.get(i).mo19360a();
    }

    /* renamed from: a */
    public void mo18777a() {
        this.f7545c = null;
        this.f7548f = null;
        this.f7549g = null;
        this.f7550h = null;
    }

    /* renamed from: c */
    private void m7989c() {
        if (!PatchProxy.proxy(new Object[0], this, f7543a, false, 2273, new Class[0], Void.TYPE).isSupported) {
            this.f7552j = new StickerCategory();
            this.f7552j.mo19361a(-100);
            this.f7552j.mo19363a("更多");
            this.f7552j.mo19365b("更多");
            this.f7552j.mo19367c("More");
            this.f7552j.mo19362a((Boolean) false);
        }
    }

    /* renamed from: d */
    private void m7990d() {
        if (!PatchProxy.proxy(new Object[0], this, f7543a, false, 2274, new Class[0], Void.TYPE).isSupported) {
            this.f7551i = LayoutInflater.from(this.f7545c).inflate(R.layout.mz_faceu_item, (ViewGroup) null, false);
            this.f7551i.setOnClickListener(this.f7554l);
        }
    }
}
