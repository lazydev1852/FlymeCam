package com.meizu.sharewidget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.meizu.sharewidget.p080a.C2858a;
import com.meizu.sharewidget.p080a.C2877h;
import com.meizu.sharewidget.p080a.C2878j;
import com.meizu.sharewidget.widget.ShareViewGroup;

/* renamed from: com.meizu.sharewidget.d */
public class ShareOnResolveClickListener implements OnResolveClickListener {

    /* renamed from: a */
    private ShareViewGroup.C2890a f15930a;

    /* renamed from: a */
    public void mo24095a(ShareViewGroup.C2890a aVar) {
        this.f15930a = aVar;
    }

    /* renamed from: a */
    public void mo24052a(Activity activity, Intent intent, C2858a aVar, boolean z, boolean z2, boolean z3) {
        if (activity != null && aVar != null && !activity.isFinishing()) {
            if (aVar.f15837e != null) {
                intent = aVar.f15837e;
            }
            Intent intent2 = new Intent(intent);
            intent2.setFlags(intent2.getFlags() & -8388609);
            intent2.addFlags(1);
            intent2.addFlags(16777216);
            intent2.addFlags(134742016);
            if (z) {
                intent2.addFlags(33554432);
            }
            ResolveInfo resolveInfo = aVar.f15833a;
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            C2878j.m17281a(activity.getApplicationContext(), resolveInfo);
            C2877h.m17277b(activity.getApplicationContext(), (resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo).name);
            activity.setResult(-1);
            if (this.f15930a != null) {
                this.f15930a.mo24077a(intent2, resolveInfo, (View) null, 0, 0);
                return;
            }
            if (z3) {
                C2877h.m17275a(activity.getApplicationContext());
                m17319a(activity.getApplicationContext());
            }
            activity.startActivity(intent2);
            if (z2) {
                activity.finish();
            }
        }
    }

    /* renamed from: a */
    private void m17319a(Context context) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent();
        intent.setAction("SHOULD_DELETE_AFTER_SHARE");
        instance.sendBroadcast(intent);
    }
}
