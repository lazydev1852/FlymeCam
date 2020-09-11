package com.meizu.share.p079b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.meizu.sharewidget.R;
import java.util.Locale;

/* renamed from: com.meizu.share.b.b */
public class DisplayResolveInfo {

    /* renamed from: a */
    public ResolveInfo f15734a;

    /* renamed from: b */
    public CharSequence f15735b;

    /* renamed from: c */
    public Drawable f15736c;

    /* renamed from: d */
    public Intent f15737d;

    public DisplayResolveInfo(@NonNull ResolveInfo resolveInfo, Intent intent) {
        this.f15734a = resolveInfo;
        this.f15737d = intent;
    }

    /* renamed from: a */
    public void mo23981a(Context context, CharSequence charSequence) {
        this.f15735b = charSequence;
        if (context != null && "zh_CN".equals(Locale.getDefault().toString())) {
            if (this.f15734a.activityInfo.packageName.equals("com.tencent.mm") && this.f15734a.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareImgUI")) {
                this.f15735b = context.getResources().getString(R.string.wechat_friends);
            } else if (this.f15734a.activityInfo.packageName.equals("com.tencent.mm") && this.f15734a.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI")) {
                this.f15735b = context.getResources().getString(R.string.wechat_pengyouquan);
            } else if (this.f15734a.activityInfo.packageName.equals("com.sina.weibo") && this.f15734a.activityInfo.name.equals("com.sina.weibo.composerinde.ComposerDispatchActivity")) {
                this.f15735b = context.getResources().getString(R.string.weibo_app);
            }
        }
    }

    public String toString() {
        return "DisplayResolveInfo{ri=" + this.f15734a + ", displayLabel=" + this.f15735b + ", displayIcon=" + this.f15736c + ", origIntent=" + this.f15737d + '}';
    }
}
