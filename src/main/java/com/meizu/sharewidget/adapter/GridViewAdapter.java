package com.meizu.sharewidget.adapter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.sharewidget.R;
import com.meizu.sharewidget.p080a.C2858a;
import com.meizu.sharewidget.p080a.C2859b;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.meizu.sharewidget.adapter.a */
public class GridViewAdapter extends BaseAdapter {

    /* renamed from: a */
    private Context f15915a;

    /* renamed from: b */
    private LayoutInflater f15916b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PackageManager f15917c = this.f15915a.getPackageManager();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f15918d;

    /* renamed from: e */
    private List<C2858a> f15919e;
    /* access modifiers changed from: private */
    @ColorInt

    /* renamed from: f */
    public int f15920f;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: g */
    public int f15921g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Resources f15922h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C2859b f15923i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f15924j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f15925k;

    public long getItemId(int i) {
        return (long) i;
    }

    public GridViewAdapter(Context context, List<C2858a> list, ThreadPoolExecutor threadPoolExecutor, @ColorInt int i, int i2) {
        this.f15915a = context.getApplicationContext();
        this.f15919e = list;
        ActivityManager activityManager = (ActivityManager) this.f15915a.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            this.f15918d = activityManager.getLauncherLargeIconDensity();
        } else {
            Log.d("GridViewAdapter", "ActivityManager == null, use default dpi=" + this.f15918d);
        }
        this.f15916b = LayoutInflater.from(this.f15915a);
        this.f15920f = i;
        this.f15921g = i2;
        this.f15922h = context.getResources();
        this.f15923i = new C2859b(threadPoolExecutor);
        this.f15924j = context.getResources().getDimensionPixelSize(R.dimen.item_icon_width);
        this.f15925k = context.getResources().getDimensionPixelSize(R.dimen.item_icon_width);
    }

    /* renamed from: a */
    public void mo24086a(@ColorInt int i) {
        this.f15920f = i;
    }

    /* renamed from: b */
    public void mo24087b(int i) {
        this.f15921g = i;
    }

    public int getCount() {
        if (this.f15919e == null) {
            return 0;
        }
        return this.f15919e.size();
    }

    /* renamed from: c */
    public C2858a getItem(int i) {
        return this.f15919e.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2884a aVar;
        if (view == null) {
            view = this.f15916b.inflate(R.layout.item_share_view_pager, viewGroup, false);
            aVar = new C2884a(view);
            view.setTag(aVar);
        } else {
            aVar = (C2884a) view.getTag();
        }
        aVar.mo24093a(getItem(i), i);
        return view;
    }

    /* renamed from: com.meizu.sharewidget.adapter.a$a */
    /* compiled from: GridViewAdapter */
    class C2884a {

        /* renamed from: b */
        private View f15927b;

        /* renamed from: c */
        private TextView f15928c;

        /* renamed from: d */
        private ImageView f15929d;

        C2884a(View view) {
            this.f15927b = view;
            this.f15928c = (TextView) view.findViewById(R.id.item_app_name);
            this.f15929d = (ImageView) view.findViewById(R.id.item_app_icon);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo24093a(C2858a aVar, int i) {
            this.f15927b.setBackgroundResource(GridViewAdapter.this.f15921g);
            this.f15928c.setText(aVar.f15834b);
            this.f15928c.setTextColor(GridViewAdapter.this.f15920f);
            GridViewAdapter.this.f15923i.mo24053a(this.f15929d, aVar, GridViewAdapter.this.f15918d, GridViewAdapter.this.f15917c, GridViewAdapter.this.f15922h, GridViewAdapter.this.f15924j, GridViewAdapter.this.f15925k);
        }
    }
}
