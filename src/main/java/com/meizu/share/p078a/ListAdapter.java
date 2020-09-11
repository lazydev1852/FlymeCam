package com.meizu.share.p078a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.share.OnViewClickListener;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.share.utils.C2828b;
import com.meizu.share.utils.C2834c;
import com.meizu.sharewidget.R;
import flyme.support.p093v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.meizu.share.a.c */
public class ListAdapter extends RecyclerView.C3260a<C2810a> {

    /* renamed from: a */
    private Context f15669a;

    /* renamed from: b */
    private LayoutInflater f15670b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PackageManager f15671c = this.f15669a.getPackageManager();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f15672d;

    /* renamed from: e */
    private List<DisplayResolveInfo> f15673e;
    /* access modifiers changed from: private */
    @ColorInt

    /* renamed from: f */
    public int f15674f;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: g */
    public int f15675g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Resources f15676h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f15677i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f15678j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnViewClickListener f15679k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f15680l;

    public ListAdapter(Context context, OnViewClickListener fVar) {
        this.f15669a = context.getApplicationContext();
        ActivityManager activityManager = (ActivityManager) this.f15669a.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            this.f15672d = activityManager.getLauncherLargeIconDensity();
        } else {
            Log.d("ListAdapter", "ActivityManager == null, use default dpi=" + this.f15672d);
        }
        this.f15670b = LayoutInflater.from(this.f15669a);
        this.f15676h = context.getResources();
        this.f15677i = context.getResources().getDimensionPixelSize(R.dimen.chooser_dialog_icon_width);
        this.f15678j = context.getResources().getDimensionPixelSize(R.dimen.chooser_dialog_icon_width);
        this.f15679k = fVar;
        this.f15680l = Build.VERSION.SDK_INT >= 28 && this.f15669a.getApplicationInfo().targetSdkVersion >= 28;
    }

    /* renamed from: a */
    public void mo23945a(List<DisplayResolveInfo> list) {
        this.f15673e = list;
        mo26541f();
    }

    /* renamed from: a */
    public void mo23943a(@ColorInt int i) {
        this.f15674f = i;
    }

    /* renamed from: b */
    public void mo23947b(int i) {
        this.f15675g = i;
    }

    /* renamed from: b */
    public List<ResolveInfo> mo23946b() {
        if (this.f15673e == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (DisplayResolveInfo bVar : this.f15673e) {
            arrayList.add(bVar.f15734a);
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public C2810a mo20098b(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.f15670b.inflate(R.layout.item_chooser_target, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(this.f15669a.getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_width), this.f15669a.getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_height)));
        return new C2810a(inflate);
    }

    /* renamed from: a */
    public void mo20097a(@NonNull C2810a aVar, int i) {
        aVar.mo23948a(this.f15673e.get(i));
    }

    /* renamed from: a */
    public int mo20093a() {
        if (this.f15673e == null) {
            return 0;
        }
        return this.f15673e.size();
    }

    /* renamed from: com.meizu.share.a.c$a */
    /* compiled from: ListAdapter */
    class C2810a extends RecyclerView.C3286u {

        /* renamed from: b */
        private View f15682b;

        /* renamed from: c */
        private TextView f15683c;

        /* renamed from: d */
        private ImageView f15684d;

        C2810a(View view) {
            super(view);
            this.f15682b = view;
            this.f15683c = (TextView) view.findViewById(R.id.item_app_name);
            if (ListAdapter.this.f15680l) {
                try {
                    C2834c.m17188a((Object) this.f15683c).mo24024a("setFallbackLineSpacing", Boolean.TYPE).mo24026a(this.f15683c, false);
                } catch (Exception unused) {
                }
            }
            this.f15684d = (ImageView) view.findViewById(R.id.item_app_icon);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo23948a(final DisplayResolveInfo bVar) {
            if (bVar == null || TextUtils.isEmpty(bVar.f15735b)) {
                this.f15682b.setVisibility(4);
                return;
            }
            this.f15682b.setVisibility(0);
            this.f15682b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ListAdapter.this.f15679k.mo23968a(bVar);
                }
            });
            this.f15682b.setBackgroundResource(ListAdapter.this.f15675g);
            this.f15683c.setText(bVar.f15735b);
            this.f15683c.setTextColor(ListAdapter.this.f15674f);
            C2828b.m17174a().mo24013a(this.f15684d, bVar, ListAdapter.this.f15672d, ListAdapter.this.f15671c, ListAdapter.this.f15676h, ListAdapter.this.f15677i, ListAdapter.this.f15678j);
        }
    }
}
