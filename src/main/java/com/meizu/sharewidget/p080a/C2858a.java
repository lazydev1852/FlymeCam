package com.meizu.sharewidget.p080a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import com.meizu.sharewidget.R;
import java.util.Locale;

/* renamed from: com.meizu.sharewidget.a.a */
/* compiled from: DisplayResolveInfo */
public class C2858a {

    /* renamed from: a */
    public ResolveInfo f15833a;

    /* renamed from: b */
    public CharSequence f15834b;

    /* renamed from: c */
    public Drawable f15835c;

    /* renamed from: d */
    public CharSequence f15836d;

    /* renamed from: e */
    public Intent f15837e;

    public C2858a(Context context, ResolveInfo resolveInfo, CharSequence charSequence, CharSequence charSequence2, Intent intent) {
        this.f15833a = resolveInfo;
        this.f15834b = charSequence;
        if (context != null && "zh_CN".equals(Locale.getDefault().toString())) {
            if (this.f15833a.activityInfo.packageName.equals("com.tencent.mm") && this.f15833a.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareImgUI")) {
                this.f15834b = context.getResources().getString(R.string.wechat_friends);
            } else if (this.f15833a.activityInfo.packageName.equals("com.tencent.mm") && this.f15833a.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI")) {
                this.f15834b = context.getResources().getString(R.string.wechat_pengyouquan);
            } else if (this.f15833a.activityInfo.packageName.equals("com.sina.weibo") && this.f15833a.activityInfo.name.equals("com.sina.weibo.composerinde.ComposerDispatchActivity")) {
                this.f15834b = context.getResources().getString(R.string.weibo_app);
            }
        }
        this.f15836d = charSequence2;
        this.f15837e = intent;
    }
}
